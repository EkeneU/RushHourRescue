PGDMP  
    
            
    |            rush_hour_rescue    17.2    17.2 2    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            �           1262    16387    rush_hour_rescue    DATABASE     �   CREATE DATABASE rush_hour_rescue WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_Nigeria.1252';
     DROP DATABASE rush_hour_rescue;
                     postgres    false            �            1259    16621    delivery_status    TABLE     �   CREATE TABLE public.delivery_status (
    delivery_id integer NOT NULL,
    issuccessful boolean,
    completiontime timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
 #   DROP TABLE public.delivery_status;
       public         heap r       postgres    false            �            1259    16620    delivery_status_delivery_id_seq    SEQUENCE     �   CREATE SEQUENCE public.delivery_status_delivery_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.delivery_status_delivery_id_seq;
       public               postgres    false    224            �           0    0    delivery_status_delivery_id_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.delivery_status_delivery_id_seq OWNED BY public.delivery_status.delivery_id;
          public               postgres    false    223            �            1259    16613    engagement_time    TABLE       CREATE TABLE public.engagement_time (
    engagement_id integer NOT NULL,
    session_start timestamp without time zone NOT NULL,
    session_end timestamp without time zone,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    session_active boolean
);
 #   DROP TABLE public.engagement_time;
       public         heap r       postgres    false            �            1259    16612 !   engagement_time_engagement_id_seq    SEQUENCE     �   CREATE SEQUENCE public.engagement_time_engagement_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE public.engagement_time_engagement_id_seq;
       public               postgres    false    222            �           0    0 !   engagement_time_engagement_id_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE public.engagement_time_engagement_id_seq OWNED BY public.engagement_time.engagement_id;
          public               postgres    false    221            �            1259    16605    qr_code_scan    TABLE     �   CREATE TABLE public.qr_code_scan (
    scan_id integer NOT NULL,
    scan_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
     DROP TABLE public.qr_code_scan;
       public         heap r       postgres    false            �            1259    16604    qr_code_scan_scan_id_seq    SEQUENCE     �   CREATE SEQUENCE public.qr_code_scan_scan_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.qr_code_scan_scan_id_seq;
       public               postgres    false    220            �           0    0    qr_code_scan_scan_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.qr_code_scan_scan_id_seq OWNED BY public.qr_code_scan.scan_id;
          public               postgres    false    219            �            1259    16596    rider    TABLE     ]   CREATE TABLE public.rider (
    rider_id integer NOT NULL,
    name text,
    status text
);
    DROP TABLE public.rider;
       public         heap r       postgres    false            �            1259    16595    rider_rider_id_seq    SEQUENCE     �   CREATE SEQUENCE public.rider_rider_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.rider_rider_id_seq;
       public               postgres    false    218            �           0    0    rider_rider_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.rider_rider_id_seq OWNED BY public.rider.rider_id;
          public               postgres    false    217            �            1259    16629    user_location    TABLE     �   CREATE TABLE public.user_location (
    location_id integer NOT NULL,
    status text,
    latitude numeric,
    longitude numeric,
    speed numeric,
    zone_id text
);
 !   DROP TABLE public.user_location;
       public         heap r       postgres    false            �            1259    16628    user_location_location_id_seq    SEQUENCE     �   CREATE SEQUENCE public.user_location_location_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.user_location_location_id_seq;
       public               postgres    false    226            �           0    0    user_location_location_id_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.user_location_location_id_seq OWNED BY public.user_location.location_id;
          public               postgres    false    225            �            1259    16638    user_request    TABLE     9  CREATE TABLE public.user_request (
    request_id integer NOT NULL,
    first_name text,
    last_name text,
    age integer,
    sex text,
    email text,
    user_password text NOT NULL,
    request_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    location_id integer,
    delivery_id integer
);
     DROP TABLE public.user_request;
       public         heap r       postgres    false            �            1259    16637    user_request_request_id_seq    SEQUENCE     �   CREATE SEQUENCE public.user_request_request_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.user_request_request_id_seq;
       public               postgres    false    228            �           0    0    user_request_request_id_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.user_request_request_id_seq OWNED BY public.user_request.request_id;
          public               postgres    false    227            ?           2604    16624    delivery_status delivery_id    DEFAULT     �   ALTER TABLE ONLY public.delivery_status ALTER COLUMN delivery_id SET DEFAULT nextval('public.delivery_status_delivery_id_seq'::regclass);
 J   ALTER TABLE public.delivery_status ALTER COLUMN delivery_id DROP DEFAULT;
       public               postgres    false    224    223    224            =           2604    16616    engagement_time engagement_id    DEFAULT     �   ALTER TABLE ONLY public.engagement_time ALTER COLUMN engagement_id SET DEFAULT nextval('public.engagement_time_engagement_id_seq'::regclass);
 L   ALTER TABLE public.engagement_time ALTER COLUMN engagement_id DROP DEFAULT;
       public               postgres    false    222    221    222            ;           2604    16608    qr_code_scan scan_id    DEFAULT     |   ALTER TABLE ONLY public.qr_code_scan ALTER COLUMN scan_id SET DEFAULT nextval('public.qr_code_scan_scan_id_seq'::regclass);
 C   ALTER TABLE public.qr_code_scan ALTER COLUMN scan_id DROP DEFAULT;
       public               postgres    false    220    219    220            :           2604    16599    rider rider_id    DEFAULT     p   ALTER TABLE ONLY public.rider ALTER COLUMN rider_id SET DEFAULT nextval('public.rider_rider_id_seq'::regclass);
 =   ALTER TABLE public.rider ALTER COLUMN rider_id DROP DEFAULT;
       public               postgres    false    217    218    218            A           2604    16632    user_location location_id    DEFAULT     �   ALTER TABLE ONLY public.user_location ALTER COLUMN location_id SET DEFAULT nextval('public.user_location_location_id_seq'::regclass);
 H   ALTER TABLE public.user_location ALTER COLUMN location_id DROP DEFAULT;
       public               postgres    false    226    225    226            B           2604    16641    user_request request_id    DEFAULT     �   ALTER TABLE ONLY public.user_request ALTER COLUMN request_id SET DEFAULT nextval('public.user_request_request_id_seq'::regclass);
 F   ALTER TABLE public.user_request ALTER COLUMN request_id DROP DEFAULT;
       public               postgres    false    227    228    228            �          0    16621    delivery_status 
   TABLE DATA           T   COPY public.delivery_status (delivery_id, issuccessful, completiontime) FROM stdin;
    public               postgres    false    224   �<       �          0    16613    engagement_time 
   TABLE DATA           p   COPY public.engagement_time (engagement_id, session_start, session_end, created_at, session_active) FROM stdin;
    public               postgres    false    222   =       �          0    16605    qr_code_scan 
   TABLE DATA           :   COPY public.qr_code_scan (scan_id, scan_time) FROM stdin;
    public               postgres    false    220   (=       �          0    16596    rider 
   TABLE DATA           7   COPY public.rider (rider_id, name, status) FROM stdin;
    public               postgres    false    218   E=       �          0    16629    user_location 
   TABLE DATA           a   COPY public.user_location (location_id, status, latitude, longitude, speed, zone_id) FROM stdin;
    public               postgres    false    226   b=       �          0    16638    user_request 
   TABLE DATA           �   COPY public.user_request (request_id, first_name, last_name, age, sex, email, user_password, request_time, location_id, delivery_id) FROM stdin;
    public               postgres    false    228   =       �           0    0    delivery_status_delivery_id_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.delivery_status_delivery_id_seq', 1, false);
          public               postgres    false    223                        0    0 !   engagement_time_engagement_id_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public.engagement_time_engagement_id_seq', 1, false);
          public               postgres    false    221                       0    0    qr_code_scan_scan_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.qr_code_scan_scan_id_seq', 1, false);
          public               postgres    false    219                       0    0    rider_rider_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.rider_rider_id_seq', 1, false);
          public               postgres    false    217                       0    0    user_location_location_id_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.user_location_location_id_seq', 1, false);
          public               postgres    false    225                       0    0    user_request_request_id_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.user_request_request_id_seq', 1, false);
          public               postgres    false    227            K           2606    16627 $   delivery_status delivery_status_pkey 
   CONSTRAINT     k   ALTER TABLE ONLY public.delivery_status
    ADD CONSTRAINT delivery_status_pkey PRIMARY KEY (delivery_id);
 N   ALTER TABLE ONLY public.delivery_status DROP CONSTRAINT delivery_status_pkey;
       public                 postgres    false    224            I           2606    16619 $   engagement_time engagement_time_pkey 
   CONSTRAINT     m   ALTER TABLE ONLY public.engagement_time
    ADD CONSTRAINT engagement_time_pkey PRIMARY KEY (engagement_id);
 N   ALTER TABLE ONLY public.engagement_time DROP CONSTRAINT engagement_time_pkey;
       public                 postgres    false    222            G           2606    16611    qr_code_scan qr_code_scan_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public.qr_code_scan
    ADD CONSTRAINT qr_code_scan_pkey PRIMARY KEY (scan_id);
 H   ALTER TABLE ONLY public.qr_code_scan DROP CONSTRAINT qr_code_scan_pkey;
       public                 postgres    false    220            E           2606    16603    rider rider_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.rider
    ADD CONSTRAINT rider_pkey PRIMARY KEY (rider_id);
 :   ALTER TABLE ONLY public.rider DROP CONSTRAINT rider_pkey;
       public                 postgres    false    218            M           2606    16636     user_location user_location_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY public.user_location
    ADD CONSTRAINT user_location_pkey PRIMARY KEY (location_id);
 J   ALTER TABLE ONLY public.user_location DROP CONSTRAINT user_location_pkey;
       public                 postgres    false    226            O           2606    16648 #   user_request user_request_email_key 
   CONSTRAINT     _   ALTER TABLE ONLY public.user_request
    ADD CONSTRAINT user_request_email_key UNIQUE (email);
 M   ALTER TABLE ONLY public.user_request DROP CONSTRAINT user_request_email_key;
       public                 postgres    false    228            Q           2606    16646    user_request user_request_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.user_request
    ADD CONSTRAINT user_request_pkey PRIMARY KEY (request_id);
 H   ALTER TABLE ONLY public.user_request DROP CONSTRAINT user_request_pkey;
       public                 postgres    false    228            S           2606    16650 +   user_request user_request_user_password_key 
   CONSTRAINT     o   ALTER TABLE ONLY public.user_request
    ADD CONSTRAINT user_request_user_password_key UNIQUE (user_password);
 U   ALTER TABLE ONLY public.user_request DROP CONSTRAINT user_request_user_password_key;
       public                 postgres    false    228            T           2606    16656 *   user_request user_request_delivery_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_request
    ADD CONSTRAINT user_request_delivery_id_fkey FOREIGN KEY (delivery_id) REFERENCES public.delivery_status(delivery_id);
 T   ALTER TABLE ONLY public.user_request DROP CONSTRAINT user_request_delivery_id_fkey;
       public               postgres    false    224    4683    228            U           2606    16651 *   user_request user_request_location_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_request
    ADD CONSTRAINT user_request_location_id_fkey FOREIGN KEY (location_id) REFERENCES public.user_location(location_id);
 T   ALTER TABLE ONLY public.user_request DROP CONSTRAINT user_request_location_id_fkey;
       public               postgres    false    228    226    4685            �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �     