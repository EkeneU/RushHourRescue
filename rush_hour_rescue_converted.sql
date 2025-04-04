--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2
-- Dumped by pg_dump version 17.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: delivery_status; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.delivery_status (
    delivery_id integer NOT NULL,
    issuccessful boolean,
    completiontime timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.delivery_status OWNER TO postgres;

--
-- Name: delivery_status_delivery_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.delivery_status_delivery_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.delivery_status_delivery_id_seq OWNER TO postgres;

--
-- Name: delivery_status_delivery_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.delivery_status_delivery_id_seq OWNED BY public.delivery_status.delivery_id;


--
-- Name: engagement_time; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.engagement_time (
    engagement_id integer NOT NULL,
    session_start timestamp without time zone NOT NULL,
    session_end timestamp without time zone,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    session_active boolean
);


ALTER TABLE public.engagement_time OWNER TO postgres;

--
-- Name: engagement_time_engagement_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.engagement_time_engagement_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.engagement_time_engagement_id_seq OWNER TO postgres;

--
-- Name: engagement_time_engagement_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.engagement_time_engagement_id_seq OWNED BY public.engagement_time.engagement_id;


--
-- Name: qr_code_scan; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.qr_code_scan (
    scan_id integer NOT NULL,
    scan_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.qr_code_scan OWNER TO postgres;

--
-- Name: qr_code_scan_scan_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.qr_code_scan_scan_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.qr_code_scan_scan_id_seq OWNER TO postgres;

--
-- Name: qr_code_scan_scan_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.qr_code_scan_scan_id_seq OWNED BY public.qr_code_scan.scan_id;


--
-- Name: rider; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rider (
    rider_id integer NOT NULL,
    name text,
    status text
);


ALTER TABLE public.rider OWNER TO postgres;

--
-- Name: rider_rider_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rider_rider_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.rider_rider_id_seq OWNER TO postgres;

--
-- Name: rider_rider_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.rider_rider_id_seq OWNED BY public.rider.rider_id;


--
-- Name: user_location; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_location (
    location_id integer NOT NULL,
    status text,
    latitude numeric,
    longitude numeric,
    speed numeric,
    zone_id text
);


ALTER TABLE public.user_location OWNER TO postgres;

--
-- Name: user_location_location_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_location_location_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.user_location_location_id_seq OWNER TO postgres;

--
-- Name: user_location_location_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_location_location_id_seq OWNED BY public.user_location.location_id;


--
-- Name: user_request; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_request (
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


ALTER TABLE public.user_request OWNER TO postgres;

--
-- Name: user_request_request_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_request_request_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.user_request_request_id_seq OWNER TO postgres;

--
-- Name: user_request_request_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_request_request_id_seq OWNED BY public.user_request.request_id;


--
-- Name: delivery_status delivery_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.delivery_status ALTER COLUMN delivery_id SET DEFAULT nextval('public.delivery_status_delivery_id_seq'::regclass);


--
-- Name: engagement_time engagement_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.engagement_time ALTER COLUMN engagement_id SET DEFAULT nextval('public.engagement_time_engagement_id_seq'::regclass);


--
-- Name: qr_code_scan scan_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.qr_code_scan ALTER COLUMN scan_id SET DEFAULT nextval('public.qr_code_scan_scan_id_seq'::regclass);


--
-- Name: rider rider_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rider ALTER COLUMN rider_id SET DEFAULT nextval('public.rider_rider_id_seq'::regclass);


--
-- Name: user_location location_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_location ALTER COLUMN location_id SET DEFAULT nextval('public.user_location_location_id_seq'::regclass);


--
-- Name: user_request request_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_request ALTER COLUMN request_id SET DEFAULT nextval('public.user_request_request_id_seq'::regclass);


--
-- Data for Name: delivery_status; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.delivery_status (delivery_id, issuccessful, completiontime) FROM stdin;
\.


--
-- Data for Name: engagement_time; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.engagement_time (engagement_id, session_start, session_end, created_at, session_active) FROM stdin;
\.


--
-- Data for Name: qr_code_scan; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.qr_code_scan (scan_id, scan_time) FROM stdin;
\.


--
-- Data for Name: rider; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.rider (rider_id, name, status) FROM stdin;
\.


--
-- Data for Name: user_location; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_location (location_id, status, latitude, longitude, speed, zone_id) FROM stdin;
\.


--
-- Data for Name: user_request; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_request (request_id, first_name, last_name, age, sex, email, user_password, request_time, location_id, delivery_id) FROM stdin;
\.


--
-- Name: delivery_status_delivery_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.delivery_status_delivery_id_seq', 1, false);


--
-- Name: engagement_time_engagement_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.engagement_time_engagement_id_seq', 1, false);


--
-- Name: qr_code_scan_scan_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.qr_code_scan_scan_id_seq', 1, false);


--
-- Name: rider_rider_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.rider_rider_id_seq', 1, false);


--
-- Name: user_location_location_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_location_location_id_seq', 1, false);


--
-- Name: user_request_request_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_request_request_id_seq', 1, false);


--
-- Name: delivery_status delivery_status_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.delivery_status
    ADD CONSTRAINT delivery_status_pkey PRIMARY KEY (delivery_id);


--
-- Name: engagement_time engagement_time_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.engagement_time
    ADD CONSTRAINT engagement_time_pkey PRIMARY KEY (engagement_id);


--
-- Name: qr_code_scan qr_code_scan_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.qr_code_scan
    ADD CONSTRAINT qr_code_scan_pkey PRIMARY KEY (scan_id);


--
-- Name: rider rider_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rider
    ADD CONSTRAINT rider_pkey PRIMARY KEY (rider_id);


--
-- Name: user_location user_location_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_location
    ADD CONSTRAINT user_location_pkey PRIMARY KEY (location_id);


--
-- Name: user_request user_request_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_request
    ADD CONSTRAINT user_request_email_key UNIQUE (email);


--
-- Name: user_request user_request_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_request
    ADD CONSTRAINT user_request_pkey PRIMARY KEY (request_id);


--
-- Name: user_request user_request_user_password_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_request
    ADD CONSTRAINT user_request_user_password_key UNIQUE (user_password);


--
-- Name: user_request user_request_delivery_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_request
    ADD CONSTRAINT user_request_delivery_id_fkey FOREIGN KEY (delivery_id) REFERENCES public.delivery_status(delivery_id);


--
-- Name: user_request user_request_location_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_request
    ADD CONSTRAINT user_request_location_id_fkey FOREIGN KEY (location_id) REFERENCES public.user_location(location_id);


--
-- PostgreSQL database dump complete
--

