--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3
-- Dumped by pg_dump version 16.3

-- Started on 2025-05-15 17:06:14

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
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
-- TOC entry 218 (class 1259 OID 16490)
-- Name: artista; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.artista (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    senha character varying(100) NOT NULL
);


ALTER TABLE public.artista OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16489)
-- Name: artista_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.artista_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.artista_id_seq OWNER TO postgres;

--
-- TOC entry 4939 (class 0 OID 0)
-- Dependencies: 217
-- Name: artista_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.artista_id_seq OWNED BY public.artista.id;


--
-- TOC entry 227 (class 1259 OID 16602)
-- Name: curtidas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.curtidas (
    id_usuario integer NOT NULL,
    id_musica integer NOT NULL
);


ALTER TABLE public.curtidas OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 16617)
-- Name: descurtidas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.descurtidas (
    id_usuario integer NOT NULL,
    id_musica integer NOT NULL
);


ALTER TABLE public.descurtidas OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16527)
-- Name: historico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.historico (
    id integer NOT NULL,
    usuario_id integer,
    musica_id integer,
    data_busca timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.historico OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 16653)
-- Name: historico_buscas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.historico_buscas (
    id integer NOT NULL,
    id_usuario integer,
    id_musica integer,
    texto_busca text
);


ALTER TABLE public.historico_buscas OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 16652)
-- Name: historico_buscas_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.historico_buscas_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.historico_buscas_id_seq OWNER TO postgres;

--
-- TOC entry 4940 (class 0 OID 0)
-- Dependencies: 229
-- Name: historico_buscas_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.historico_buscas_id_seq OWNED BY public.historico_buscas.id;


--
-- TOC entry 222 (class 1259 OID 16526)
-- Name: historico_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.historico_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.historico_id_seq OWNER TO postgres;

--
-- TOC entry 4941 (class 0 OID 0)
-- Dependencies: 222
-- Name: historico_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.historico_id_seq OWNED BY public.historico.id;


--
-- TOC entry 220 (class 1259 OID 16499)
-- Name: musica; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.musica (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    genero character varying(50),
    artista_id integer
);


ALTER TABLE public.musica OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16498)
-- Name: musica_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.musica_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.musica_id_seq OWNER TO postgres;

--
-- TOC entry 4942 (class 0 OID 0)
-- Dependencies: 219
-- Name: musica_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.musica_id_seq OWNED BY public.musica.id;


--
-- TOC entry 226 (class 1259 OID 16556)
-- Name: musica_playlist; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.musica_playlist (
    playlist_id integer NOT NULL,
    musica_id integer NOT NULL
);


ALTER TABLE public.musica_playlist OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16510)
-- Name: musica_usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.musica_usuario (
    usuario_id integer NOT NULL,
    musica_id integer NOT NULL,
    status character varying(10),
    CONSTRAINT musica_usuario_status_check CHECK (((status)::text = ANY ((ARRAY['curtida'::character varying, 'descurtida'::character varying])::text[])))
);


ALTER TABLE public.musica_usuario OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 16545)
-- Name: playlist; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.playlist (
    id integer NOT NULL,
    nome character varying(100),
    usuario_id integer
);


ALTER TABLE public.playlist OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 16544)
-- Name: playlist_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.playlist_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.playlist_id_seq OWNER TO postgres;

--
-- TOC entry 4943 (class 0 OID 0)
-- Dependencies: 224
-- Name: playlist_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.playlist_id_seq OWNED BY public.playlist.id;


--
-- TOC entry 216 (class 1259 OID 16481)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    senha character varying(100) NOT NULL
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16480)
-- Name: usuario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.usuario_id_seq OWNER TO postgres;

--
-- TOC entry 4944 (class 0 OID 0)
-- Dependencies: 215
-- Name: usuario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;


--
-- TOC entry 4730 (class 2604 OID 16493)
-- Name: artista id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.artista ALTER COLUMN id SET DEFAULT nextval('public.artista_id_seq'::regclass);


--
-- TOC entry 4732 (class 2604 OID 16530)
-- Name: historico id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.historico ALTER COLUMN id SET DEFAULT nextval('public.historico_id_seq'::regclass);


--
-- TOC entry 4735 (class 2604 OID 16656)
-- Name: historico_buscas id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.historico_buscas ALTER COLUMN id SET DEFAULT nextval('public.historico_buscas_id_seq'::regclass);


--
-- TOC entry 4731 (class 2604 OID 16502)
-- Name: musica id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.musica ALTER COLUMN id SET DEFAULT nextval('public.musica_id_seq'::regclass);


--
-- TOC entry 4734 (class 2604 OID 16548)
-- Name: playlist id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.playlist ALTER COLUMN id SET DEFAULT nextval('public.playlist_id_seq'::regclass);


--
-- TOC entry 4729 (class 2604 OID 16484)
-- Name: usuario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);


--
-- TOC entry 4921 (class 0 OID 16490)
-- Dependencies: 218
-- Data for Name: artista; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.artista (id, nome, email, senha) FROM stdin;
1	Queen	queen@email.com	123
2	Taylor Swift	taylor@email.com	123
3	Eminem	eminem@email.com	123
4	The Beatles	beatles@email.com	123
5	Imagine Dragons	imagine@email.com	123
\.


--
-- TOC entry 4930 (class 0 OID 16602)
-- Dependencies: 227
-- Data for Name: curtidas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.curtidas (id_usuario, id_musica) FROM stdin;
2	9
3	19
4	9
5	3
5	10
7	15
7	13
5	20
5	1
5	17
\.


--
-- TOC entry 4931 (class 0 OID 16617)
-- Dependencies: 228
-- Data for Name: descurtidas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.descurtidas (id_usuario, id_musica) FROM stdin;
7	6
5	15
5	19
\.


--
-- TOC entry 4926 (class 0 OID 16527)
-- Dependencies: 223
-- Data for Name: historico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.historico (id, usuario_id, musica_id, data_busca) FROM stdin;
\.


--
-- TOC entry 4933 (class 0 OID 16653)
-- Dependencies: 230
-- Data for Name: historico_buscas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.historico_buscas (id, id_usuario, id_musica, texto_busca) FROM stdin;
1	5	\N	rock
2	5	\N	pop
3	5	\N	juliamna
4	5	\N	jmoises
5	5	\N	jmoises
6	5	\N	joao
7	5	\N	a
8	5	\N	5
9	5	\N	5v
10	5	\N	r
11	5	\N	i
12	5	\N	o
13	5	\N	op
14	5	\N	x
15	5	\N	rock
\.


--
-- TOC entry 4923 (class 0 OID 16499)
-- Dependencies: 220
-- Data for Name: musica; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.musica (id, nome, genero, artista_id) FROM stdin;
1	Bohemian Rhapsody	Rock	1
2	Dont Stop Me Now	Rock	1
3	Shake It Off	Pop	2
4	Blank Space	Pop	2
5	Lose Yourself	Hip-Hop	3
6	Without Me	Hip-Hop	3
7	Hey Jude	Rock	4
8	Let It Be	Rock	4
9	Demons	Alternative Rock	5
10	Radioactive	Alternative Rock	5
11	Somebody to Love	Rock	1
12	Love Story	Pop	2
13	Mockingbird	Hip-Hop	3
14	Come Together	Rock	4
15	Thunder	Alternative Rock	5
16	Believer	Alternative Rock	5
17	Yesterday	Rock	4
18	Style	Pop	2
19	Rap God	Hip-Hop	3
20	Another One Bites the Dust	Rock	1
\.


--
-- TOC entry 4929 (class 0 OID 16556)
-- Dependencies: 226
-- Data for Name: musica_playlist; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.musica_playlist (playlist_id, musica_id) FROM stdin;
9	19
\.


--
-- TOC entry 4924 (class 0 OID 16510)
-- Dependencies: 221
-- Data for Name: musica_usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.musica_usuario (usuario_id, musica_id, status) FROM stdin;
\.


--
-- TOC entry 4928 (class 0 OID 16545)
-- Dependencies: 225
-- Data for Name: playlist; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.playlist (id, nome, usuario_id) FROM stdin;
1	PAZ	3
2	É FODA	3
3	Kleber	3
4	kleber	2
5	kleber	3
6	kleber	3
7	kleber	3
8	kleber	3
9	AdoraBundadePitufu	3
10	Yaspodre	4
11	playlist1	5
12	Minha Playlist	7
13	ahhh	5
\.


--
-- TOC entry 4919 (class 0 OID 16481)
-- Dependencies: 216
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (id, nome, email, senha) FROM stdin;
1	Joao	blabla@gmail.com	123456
2	Joao	joao@joao.com	123456
3	joao	joao@joao	123456
4	yasmin	sla@gmail.com	123456
5	joao	joao.joao	1234
6	joao	yasburra.burra	1234
7	justica	justica.justica	1234
\.


--
-- TOC entry 4945 (class 0 OID 0)
-- Dependencies: 217
-- Name: artista_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.artista_id_seq', 1, false);


--
-- TOC entry 4946 (class 0 OID 0)
-- Dependencies: 229
-- Name: historico_buscas_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.historico_buscas_id_seq', 15, true);


--
-- TOC entry 4947 (class 0 OID 0)
-- Dependencies: 222
-- Name: historico_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.historico_id_seq', 1, false);


--
-- TOC entry 4948 (class 0 OID 0)
-- Dependencies: 219
-- Name: musica_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.musica_id_seq', 1, false);


--
-- TOC entry 4949 (class 0 OID 0)
-- Dependencies: 224
-- Name: playlist_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.playlist_id_seq', 13, true);


--
-- TOC entry 4950 (class 0 OID 0)
-- Dependencies: 215
-- Name: usuario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_id_seq', 7, true);


--
-- TOC entry 4742 (class 2606 OID 16497)
-- Name: artista artista_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.artista
    ADD CONSTRAINT artista_email_key UNIQUE (email);


--
-- TOC entry 4744 (class 2606 OID 16495)
-- Name: artista artista_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.artista
    ADD CONSTRAINT artista_pkey PRIMARY KEY (id);


--
-- TOC entry 4756 (class 2606 OID 16606)
-- Name: curtidas curtidas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curtidas
    ADD CONSTRAINT curtidas_pkey PRIMARY KEY (id_usuario, id_musica);


--
-- TOC entry 4758 (class 2606 OID 16621)
-- Name: descurtidas descurtidas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.descurtidas
    ADD CONSTRAINT descurtidas_pkey PRIMARY KEY (id_usuario, id_musica);


--
-- TOC entry 4760 (class 2606 OID 16660)
-- Name: historico_buscas historico_buscas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.historico_buscas
    ADD CONSTRAINT historico_buscas_pkey PRIMARY KEY (id);


--
-- TOC entry 4750 (class 2606 OID 16533)
-- Name: historico historico_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.historico
    ADD CONSTRAINT historico_pkey PRIMARY KEY (id);


--
-- TOC entry 4746 (class 2606 OID 16504)
-- Name: musica musica_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.musica
    ADD CONSTRAINT musica_pkey PRIMARY KEY (id);


--
-- TOC entry 4754 (class 2606 OID 16560)
-- Name: musica_playlist musica_playlist_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.musica_playlist
    ADD CONSTRAINT musica_playlist_pkey PRIMARY KEY (playlist_id, musica_id);


--
-- TOC entry 4748 (class 2606 OID 16515)
-- Name: musica_usuario musica_usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.musica_usuario
    ADD CONSTRAINT musica_usuario_pkey PRIMARY KEY (usuario_id, musica_id);


--
-- TOC entry 4752 (class 2606 OID 16550)
-- Name: playlist playlist_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.playlist
    ADD CONSTRAINT playlist_pkey PRIMARY KEY (id);


--
-- TOC entry 4738 (class 2606 OID 16488)
-- Name: usuario usuario_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_email_key UNIQUE (email);


--
-- TOC entry 4740 (class 2606 OID 16486)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);


--
-- TOC entry 4769 (class 2606 OID 16612)
-- Name: curtidas curtidas_id_musica_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curtidas
    ADD CONSTRAINT curtidas_id_musica_fkey FOREIGN KEY (id_musica) REFERENCES public.musica(id) ON DELETE CASCADE;


--
-- TOC entry 4770 (class 2606 OID 16607)
-- Name: curtidas curtidas_id_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curtidas
    ADD CONSTRAINT curtidas_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id) ON DELETE CASCADE;


--
-- TOC entry 4771 (class 2606 OID 16627)
-- Name: descurtidas descurtidas_id_musica_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.descurtidas
    ADD CONSTRAINT descurtidas_id_musica_fkey FOREIGN KEY (id_musica) REFERENCES public.musica(id) ON DELETE CASCADE;


--
-- TOC entry 4772 (class 2606 OID 16622)
-- Name: descurtidas descurtidas_id_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.descurtidas
    ADD CONSTRAINT descurtidas_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id) ON DELETE CASCADE;


--
-- TOC entry 4773 (class 2606 OID 16666)
-- Name: historico_buscas historico_buscas_id_musica_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.historico_buscas
    ADD CONSTRAINT historico_buscas_id_musica_fkey FOREIGN KEY (id_musica) REFERENCES public.musica(id);


--
-- TOC entry 4774 (class 2606 OID 16661)
-- Name: historico_buscas historico_buscas_id_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.historico_buscas
    ADD CONSTRAINT historico_buscas_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id);


--
-- TOC entry 4764 (class 2606 OID 16539)
-- Name: historico historico_musica_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.historico
    ADD CONSTRAINT historico_musica_id_fkey FOREIGN KEY (musica_id) REFERENCES public.musica(id);


--
-- TOC entry 4765 (class 2606 OID 16534)
-- Name: historico historico_usuario_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.historico
    ADD CONSTRAINT historico_usuario_id_fkey FOREIGN KEY (usuario_id) REFERENCES public.usuario(id);


--
-- TOC entry 4761 (class 2606 OID 16505)
-- Name: musica musica_artista_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.musica
    ADD CONSTRAINT musica_artista_id_fkey FOREIGN KEY (artista_id) REFERENCES public.artista(id);


--
-- TOC entry 4767 (class 2606 OID 16566)
-- Name: musica_playlist musica_playlist_musica_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.musica_playlist
    ADD CONSTRAINT musica_playlist_musica_id_fkey FOREIGN KEY (musica_id) REFERENCES public.musica(id);


--
-- TOC entry 4768 (class 2606 OID 16561)
-- Name: musica_playlist musica_playlist_playlist_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.musica_playlist
    ADD CONSTRAINT musica_playlist_playlist_id_fkey FOREIGN KEY (playlist_id) REFERENCES public.playlist(id);


--
-- TOC entry 4762 (class 2606 OID 16521)
-- Name: musica_usuario musica_usuario_musica_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.musica_usuario
    ADD CONSTRAINT musica_usuario_musica_id_fkey FOREIGN KEY (musica_id) REFERENCES public.musica(id);


--
-- TOC entry 4763 (class 2606 OID 16516)
-- Name: musica_usuario musica_usuario_usuario_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.musica_usuario
    ADD CONSTRAINT musica_usuario_usuario_id_fkey FOREIGN KEY (usuario_id) REFERENCES public.usuario(id);


--
-- TOC entry 4766 (class 2606 OID 16551)
-- Name: playlist playlist_usuario_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.playlist
    ADD CONSTRAINT playlist_usuario_id_fkey FOREIGN KEY (usuario_id) REFERENCES public.usuario(id);


-- Completed on 2025-05-15 17:06:14

--
-- PostgreSQL database dump complete
--

