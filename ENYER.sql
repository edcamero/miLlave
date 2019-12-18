PGDMP     0        
            u         
   ferreteria    9.5.6    9.5.6      �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           1262    24697 
   ferreteria    DATABASE     �   CREATE DATABASE ferreteria WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';
    DROP DATABASE ferreteria;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    7            �           0    0    public    ACL     �   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                  postgres    false    7                        3079    12355    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            �           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    24698    sec_caja    SEQUENCE     j   CREATE SEQUENCE sec_caja
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 50
    CACHE 1;
    DROP SEQUENCE public.sec_caja;
       public       postgres    false    7            �            1259    24700    caja    TABLE       CREATE TABLE caja (
    id_caja integer DEFAULT nextval('sec_caja'::regclass) NOT NULL,
    total_venta numeric,
    id_empleado numeric NOT NULL,
    estado boolean DEFAULT false
)
WITH (autovacuum_enabled='true', autovacuum_analyze_threshold='1', autovacuum_vacuum_scale_factor='1');
    DROP TABLE public.caja;
       public         postgres    false    187    7            �            1259    24785    sec_categoria    SEQUENCE     q   CREATE SEQUENCE sec_categoria
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 1000
    CACHE 1;
 $   DROP SEQUENCE public.sec_categoria;
       public       postgres    false    7            �            1259    24710 	   categoria    TABLE     �   CREATE TABLE categoria (
    id_categoria numeric DEFAULT nextval('sec_categoria'::regclass) NOT NULL,
    nombre_categoria text NOT NULL
);
    DROP TABLE public.categoria;
       public         postgres    false    196    7            �            1259    24717    cliente    TABLE     r   CREATE TABLE cliente (
    id_cliente numeric NOT NULL,
    nombre text,
    apellido text,
    tiempo integer
);
    DROP TABLE public.cliente;
       public         postgres    false    7            �            1259    24723    detalle_venta    TABLE     d   CREATE TABLE detalle_venta (
    id_venta numeric,
    cantidad numeric,
    id_producto numeric
);
 !   DROP TABLE public.detalle_venta;
       public         postgres    false    7            �            1259    24729    producto    TABLE     .  CREATE TABLE producto (
    id_producto numeric NOT NULL,
    nombre_producto text NOT NULL,
    valor_producto numeric NOT NULL,
    id_familia numeric NOT NULL,
    nit_proveedor numeric NOT NULL,
    cantidad numeric NOT NULL,
    stock_minimo numeric NOT NULL,
    stock_maximo numeric NOT NULL
);
    DROP TABLE public.producto;
       public         postgres    false    7            �            1259    24788 	   sec_promo    SEQUENCE     l   CREATE SEQUENCE sec_promo
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 1000
    CACHE 1;
     DROP SEQUENCE public.sec_promo;
       public       postgres    false    7            �            1259    24735 	   promocion    TABLE     �   CREATE TABLE promocion (
    id_promocion integer DEFAULT nextval('sec_promo'::regclass) NOT NULL,
    id_producto numeric,
    fecha_inicial date,
    fecha_final date
);
    DROP TABLE public.promocion;
       public         postgres    false    197    7            �            1259    24741 	   proveedor    TABLE     c   CREATE TABLE proveedor (
    nit_proveedor numeric NOT NULL,
    nombre_proveedor text NOT NULL
);
    DROP TABLE public.proveedor;
       public         postgres    false    7            �            1259    24792    sec_vent    SEQUENCE     l   CREATE SEQUENCE sec_vent
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 10000
    CACHE 1;
    DROP SEQUENCE public.sec_vent;
       public       postgres    false    7            �            1259    24747    venta    TABLE     �   CREATE TABLE venta (
    id_venta numeric DEFAULT nextval('sec_vent'::regclass) NOT NULL,
    id_cliente numeric,
    total_venta numeric,
    id_caja numeric,
    fecha date
);
    DROP TABLE public.venta;
       public         postgres    false    198    7            s          0    24700    caja 
   TABLE DATA               B   COPY caja (id_caja, total_venta, id_empleado, estado) FROM stdin;
    public       postgres    false    188   �       t          0    24710 	   categoria 
   TABLE DATA               <   COPY categoria (id_categoria, nombre_categoria) FROM stdin;
    public       postgres    false    189   N       u          0    24717    cliente 
   TABLE DATA               @   COPY cliente (id_cliente, nombre, apellido, tiempo) FROM stdin;
    public       postgres    false    190   �       v          0    24723    detalle_venta 
   TABLE DATA               A   COPY detalle_venta (id_venta, cantidad, id_producto) FROM stdin;
    public       postgres    false    191   U!       w          0    24729    producto 
   TABLE DATA               �   COPY producto (id_producto, nombre_producto, valor_producto, id_familia, nit_proveedor, cantidad, stock_minimo, stock_maximo) FROM stdin;
    public       postgres    false    192   �)       x          0    24735 	   promocion 
   TABLE DATA               S   COPY promocion (id_promocion, id_producto, fecha_inicial, fecha_final) FROM stdin;
    public       postgres    false    193   �*       y          0    24741 	   proveedor 
   TABLE DATA               =   COPY proveedor (nit_proveedor, nombre_proveedor) FROM stdin;
    public       postgres    false    194   �*       �           0    0    sec_caja    SEQUENCE SET     0   SELECT pg_catalog.setval('sec_caja', 10, true);
            public       postgres    false    187            �           0    0    sec_categoria    SEQUENCE SET     4   SELECT pg_catalog.setval('sec_categoria', 7, true);
            public       postgres    false    196            �           0    0 	   sec_promo    SEQUENCE SET     0   SELECT pg_catalog.setval('sec_promo', 3, true);
            public       postgres    false    197            �           0    0    sec_vent    SEQUENCE SET     1   SELECT pg_catalog.setval('sec_vent', 157, true);
            public       postgres    false    198            z          0    24747    venta 
   TABLE DATA               K   COPY venta (id_venta, id_cliente, total_venta, id_caja, fecha) FROM stdin;
    public       postgres    false    195   �+       s   e   x�5���0��0������QHU��N�!C%�mqb<�\ě�&+��T���G��k'�͜�f�4@]-���oE��@�[�J��$��5�|ȡ�      t   ]   x�%���0 �3L�&����P1J+��[����E�Z(8%-n�H����[X��|1�	I8�EQ\��*9u��l����Z�{D|yT"�      u   �  x�=�A��0D��)|�"�lKZ��c��Jː�?��z��"J���f8��N�s�J���M�'3��峮�]e���[�bx�y�E�X�{�r�L����*�hm2��ĸZP�ML�9���W�<`{����(�����F�e�?�J��M���F|隋�hi���C�w>DRt��3�5Oɩ^.�6>��?0Lpo��� g�N)���o��|�O:���9�d�33�(��IY��w�y�΄Υ�R[��-7�>�\R�1D�5�;i�����*�RR)X�ХlyE�{�2TB,��/��[c4�;�!gl&󪩬G�(viO�J��������^�V�s=҉^�@���[��h�H�	Q|0�������������f���ů�      v   Z  x�=X[�,)��Z̄����#����,y)���������?��������q�?����Aމ��q���/u���?K����y9���s�p���ߺ<�K���]��+Y|�����=/����wg��������~ kVv� �ڝd�C+���G�$�g��Ut��bB|��~�]`1�B��c����egӴJ-�������8XzL�'�I�)T�A���	��*D<1�*����T:x�w֦V�Xj�&��͆�s��1�
�n�R辽�= ��_��Ӹ�4z+]�Bbt�f9N��ݡf�i������{C H���?{��=;�3i���g3�s�e.�^�Xgѓfq��B#]�2E��
��j�%�ě��KΣ}z�<��j�H9�j8�7��D�dwG��T�auGe*��R�;#����0��H0B<�^�� c����.�ܼ�c�����;��@/�lH�����}}k���[+A���+�AP��ᖤB?�Ѓ.b�h~!����h�b�jSRLZ����J/�ʞw'�S�rk �D0&������z��ɍG2G'�)a�8RT����z�^D�U{�,�!�����	��<��h^iv�o��Y�"�߈���.�m�{-G��}�To�$mG�.���4LT���H�X��z鈸t���]��g�F�9� �vOf����|�A������G炑�tb��6�"���\a�+����ׁ!R������5<k@ChY�\q )Է�α�6m�F��{6vZ_J,K�5��ք��i[��n��r��Z�g�r.�4,�������p}��6�V�����,p���Ե��#�t�6+����ד���b��ᵔ���a)ea��:�Ձ��C'���qk J���Q�)��:���e�p}8z��l�&�)]��פ�t��]N�S�b���\�.ID��Lh��

�X)��J��J��0����%�,��m�b �z�_d��%0zy�P�tvgTE;7.�����׊X�[��ck#k���E�9ZOG��-ijn�r�W�=�{���l�Wgc�o��̓��={�S�;[�[��ykݎmo�R�9 �v��[W����(	�p��C�ۺ��.���齥��X��-]�-�7e�tԽ�N��U�J��su�oe�}� ��0z�@8�qzx�=����c�h�|xK�ـ#�4�;��W?��C�=�*:�lzt.�窇�{vz��QQ���� >%�P��)Ne�9<bk��K�Q��kb����(�C�;��-Ơ7�Á��6����踤0�t��a����]ɞGP��-�&�Ȇn\6\��J�ᚢ|d�W�F_C�{ر�*��&y�VM�`i�O��FTル�7��L�|#����~���q~��@On�jY�T���������VtL�8o���s������Y�_(h�%�H.�81�d=l:o�3
r��f<�U�((�M�(�X��+;H���U��h1B� ����@���x,�frR6K�ٖOn���JSU�c��,�mI��,�T�[=�S��W��}�d7�6̶([,��l���|��~�x�8s�l���@#��6��Ye��l��ȇ���[��)d�CU8?HL��J�&/��l��܄��U�?����L+���"���q����w&]��l�@pW�c��1���z{)m��nK�����J�����9[\���u�f�,|���C��C��W�!7�_���\��<��=����̧�L�§��Y��ێ���]":��\�8#^nq�46R"E ���[>��o�|��Q��J��Z������#��;��5n��,޳b�:�!&)XZ(YE0Y��жPi����������G	�b�DQ�>�x�E^,t2�F�X�Hg*�9U �z�M�V�x�Խ�Pl7�l=5�zYDO?S U;Z��V|`��8�HB$ ֌�μ���e88���3�a�h,؇F���"���	y~���Z�H=����TZCŏ���O�������T���TI9s�KE.e�\��;X�l��`K�1�|QH|���ܬ:�?6%|�����Ò[�      w   �   x�U�1r� �zu
N�YV�]�`�A���>H��7�w�<���8�@�vq�P���5�͗5f�����k��%�c����-���l٬u���"ꚛF��u	RP[ŵ��b�0�0w��/!� �Y<�_�̤�$�Gɲo��\S<w��a��TgG4v&�5�n$",�����G���e=Ï/5������y�����t�V      x   0   x�3�4�4204�50�5�@0-��8�|cd&�1V)]#�=... g�,      y   �   x�-P�n� >���	*Q��Q�i��S'����x�	�C�V{���L:�g?Fc���#\��ZI�1^^��i��
��[�u��_T�����H�,�G4;�<sE�p�|�0c�x�2��C1ߚ������@z^����{�{xI�ZA�>х��!�<��f�yv��Y��孷��0檯��w�$��G~��l�M�iNzMm� z�\ẖ5�v-� )7i�"i*A�_I�PՃ(���D�c���{�`"      z   �  x�mXI�� \��<4�]r�sD2`�ewo� �T*
 q��O���O�?TXğB�"����S�-L����?�+��v�o�()ܯy7kAC�V�^F��Պ�*�R���04�-`澛�D��B���ֱ�х/�J;��_w��y |�����'����8��G�G��F���d��l
��.��W�N����|x���#������W�����ցȰ����)d����U�k.1�{D�lU�p[�EIS��Rh�w��:P,�:h��HEM���T��+�>�����[�8%�`��� �� ���V�0o˷[�>ZW��b
�t� ���ޝG����U"�\	���[Kn�D�`��Q`�n��0c���|e�:{��	7�A)D-�e�M��T�f+N8g[5bɼ�m���\�Ѻʹ�ec�~��Ӿ�z�8��<T%��\`�6�LH�Ho��<� �@R�=�:ͦɍ(��E��B.��֛:��(���s<J�L9�1)�3���v���L�m�s��R����ƚ���~���V�+�x��<��WaV�g>0z|��4~z���EM�XZʷ���=����g5W�&KqN��k���:�G�e��d�%�슒��,4���`�#ǍWw�fj���i��(��mv�H��maG%7`{&�Ֆ�sM��'h�%�&��w��P8��F�Q}��h��$��r�5c�d1��":AN�}M�LT/.n�Ӽ�ֻ=�)�Pqb's�CrJ���	�G'|iq��v��G~���K B��r=�j͉�����9^o�i��4,P�e��|�Y;��J�O��}�^�*�o�Y��VЧ�?�v�>�l �H��qu&_�����mg�K���}N�M�a�"��1ɧq�w����䚇��;�a��!���(C�o��M���O�m��qZb�~��;�0�����ʍT7��oa��)黍b��O2�L�4.��n������;��y�O�����qu"�uv[=��/��_���2�)�|(�^�7Q��A�K�	�/��lΏ����b�<ӎ������K'�B�?���䱤=����-5�>$���y��f���a���M��b!�Մ�K%��D��� 9[]��Y�o%a����/VL�6n�G�����~���)I     