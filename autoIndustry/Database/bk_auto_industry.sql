PGDMP                         z            auto_industry    14.5    14.4     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                        1262    16409    auto_industry    DATABASE     l   CREATE DATABASE auto_industry WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Colombia.1252';
    DROP DATABASE auto_industry;
                postgres    false            ?            1259    16481    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            ?            1259    16464 	   inventory    TABLE     ?   CREATE TABLE public.inventory (
    id bigint NOT NULL,
    created_date date,
    quantity integer,
    updated_date date,
    id_product bigint,
    id_user bigint
);
    DROP TABLE public.inventory;
       public         heap    postgres    false            ?            1259    16469    products    TABLE     Z   CREATE TABLE public.products (
    id bigint NOT NULL,
    name character varying(255)
);
    DROP TABLE public.products;
       public         heap    postgres    false            ?            1259    16474    users    TABLE     ?   CREATE TABLE public.users (
    id bigint NOT NULL,
    age integer,
    created_date date,
    lastname character varying(255),
    name character varying(255),
    "position" character varying(255),
    updated_date date
);
    DROP TABLE public.users;
       public         heap    postgres    false            ?          0    16464 	   inventory 
   TABLE DATA           b   COPY public.inventory (id, created_date, quantity, updated_date, id_product, id_user) FROM stdin;
    public          postgres    false    209   Q       ?          0    16469    products 
   TABLE DATA           ,   COPY public.products (id, name) FROM stdin;
    public          postgres    false    210   ?       ?          0    16474    users 
   TABLE DATA           `   COPY public.users (id, age, created_date, lastname, name, "position", updated_date) FROM stdin;
    public          postgres    false    211   u                  0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 44, true);
          public          postgres    false    212            e           2606    16468    inventory inventory_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.inventory
    ADD CONSTRAINT inventory_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.inventory DROP CONSTRAINT inventory_pkey;
       public            postgres    false    209            g           2606    16473    products products_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.products DROP CONSTRAINT products_pkey;
       public            postgres    false    210            i           2606    16480    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    211            k           2606    16487 %   inventory fkhswsc1325j491ecwn05kiso20    FK CONSTRAINT     ?   ALTER TABLE ONLY public.inventory
    ADD CONSTRAINT fkhswsc1325j491ecwn05kiso20 FOREIGN KEY (id_user) REFERENCES public.users(id);
 O   ALTER TABLE ONLY public.inventory DROP CONSTRAINT fkhswsc1325j491ecwn05kiso20;
       public          postgres    false    209    3177    211            j           2606    16482 %   inventory fkmx3pes0uhrr0qn5veeype1j56    FK CONSTRAINT     ?   ALTER TABLE ONLY public.inventory
    ADD CONSTRAINT fkmx3pes0uhrr0qn5veeype1j56 FOREIGN KEY (id_product) REFERENCES public.products(id);
 O   ALTER TABLE ONLY public.inventory DROP CONSTRAINT fkmx3pes0uhrr0qn5veeype1j56;
       public          postgres    false    3175    210    209            ?   \   x?M??? ?G/f?ԨM???#?L"3|???*?t?<??La?d"?OP?A??=???h????m\???c?Ĵ??[????"??L?      ?   ?   x?mͻ?@??z?)?	?"??[aD????FG???^m?????Db}?PG??Zn?C?cu?Z?d???????.???7???I?KF??Vܸ^?a^?wG'?0??I????z?0?:??ɼ<U?f?}??l?{?3?B???,???!???,q?GK5p[?J?SL      ?   f   x?m?1
?0E??????:z 'W?H?t0????n:8=>????q?i3l??Ve???km?X?YX.???????bFZ:O?-???w??0?b?	??%     