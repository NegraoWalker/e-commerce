--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3
-- Dumped by pg_dump version 16.3

-- Started on 2024-07-03 14:18:50

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

--
-- TOC entry 4998 (class 1262 OID 16398)
-- Name: db_ecommerce_test; Type: DATABASE; Schema: -; Owner: postgres
--

--CREATE DATABASE db_ecommerce_test WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';


ALTER DATABASE db_ecommerce_test OWNER TO postgres;

--\connect db_ecommerce_test

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

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- TOC entry 4999 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 255 (class 1255 OID 16682)
-- Name: validperson(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.validperson() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE
    thereIsAPerson INTEGER; -- existePessoa
BEGIN
    -- Verifica se existe uma pessoa física com o ID especificado
    thereIsAPerson := (SELECT COUNT(1) FROM tb_natural_person WHERE id = NEW.person_id);

    -- Se não encontrou pessoa física, verifica pessoa jurídica
    IF thereIsAPerson <= 0 THEN
        thereIsAPerson := (SELECT COUNT(1) FROM tb_legal_person WHERE id = NEW.person_id);

        -- Se não encontrou nem pessoa física nem jurídica, levanta uma exceção
        IF thereIsAPerson <= 0 THEN
            RAISE EXCEPTION 'NÃO FOI ENCONTRADO O ID E PK DA PESSOA PARA REALIZAR A ASSOCIAÇÃO DO CADASTRO';
        END IF;
    END IF;

    -- Retorna o novo registro para continuar a operação
    RETURN NEW;
END;
$$;


ALTER FUNCTION public.validperson() OWNER TO postgres;

--
-- TOC entry 256 (class 1255 OID 16691)
-- Name: validperson2(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.validperson2() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE
    thereIsAPerson INTEGER; -- existePessoa
BEGIN
    -- Verifica se existe uma pessoa física com o ID especificado
    thereIsAPerson := (SELECT COUNT(1) FROM tb_natural_person WHERE id = NEW.supplier_id);

    -- Se não encontrou pessoa física, verifica pessoa jurídica
    IF thereIsAPerson <= 0 THEN
        thereIsAPerson := (SELECT COUNT(1) FROM tb_legal_person WHERE id = NEW.supplier_id);

        -- Se não encontrou nem pessoa física nem jurídica, levanta uma exceção
        IF thereIsAPerson <= 0 THEN
            RAISE EXCEPTION 'NÃO FOI ENCONTRADO O ID E PK DA PESSOA PARA REALIZAR A ASSOCIAÇÃO DO CADASTRO';
        END IF;
    END IF;

    -- Retorna o novo registro para continuar a operação
    RETURN NEW;
END;
$$;


ALTER FUNCTION public.validperson2() OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16421)
-- Name: seq_access; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_access
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_access OWNER TO postgres;

--
-- TOC entry 232 (class 1259 OID 16530)
-- Name: seq_account_payable; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_account_payable
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_account_payable OWNER TO postgres;

--
-- TOC entry 233 (class 1259 OID 16531)
-- Name: seq_account_receivable; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_account_receivable
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_account_receivable OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 16490)
-- Name: seq_address; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_address
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_address OWNER TO postgres;

--
-- TOC entry 234 (class 1259 OID 16532)
-- Name: seq_discount_coupon; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_discount_coupon
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_discount_coupon OWNER TO postgres;

--
-- TOC entry 244 (class 1259 OID 16584)
-- Name: seq_invoice_product_item; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_invoice_product_item
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_invoice_product_item OWNER TO postgres;

--
-- TOC entry 235 (class 1259 OID 16533)
-- Name: seq_payment_method; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_payment_method
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_payment_method OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16422)
-- Name: seq_person; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_person
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_person OWNER TO postgres;

--
-- TOC entry 238 (class 1259 OID 16552)
-- Name: seq_product; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_product
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_product OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16423)
-- Name: seq_product_brand; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_product_brand
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_product_brand OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16424)
-- Name: seq_product_category; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_product_category
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_product_category OWNER TO postgres;

--
-- TOC entry 240 (class 1259 OID 16560)
-- Name: seq_product_image; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_product_image
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_product_image OWNER TO postgres;

--
-- TOC entry 250 (class 1259 OID 16624)
-- Name: seq_product_rating; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_product_rating
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_product_rating OWNER TO postgres;

--
-- TOC entry 242 (class 1259 OID 16573)
-- Name: seq_purchase_invoice; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_purchase_invoice
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_purchase_invoice OWNER TO postgres;

--
-- TOC entry 251 (class 1259 OID 16625)
-- Name: seq_sale; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_sale
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_sale OWNER TO postgres;

--
-- TOC entry 252 (class 1259 OID 16626)
-- Name: seq_sale_invoice; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_sale_invoice
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_sale_invoice OWNER TO postgres;

--
-- TOC entry 253 (class 1259 OID 16627)
-- Name: seq_sale_item; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_sale_item
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_sale_item OWNER TO postgres;

--
-- TOC entry 254 (class 1259 OID 16628)
-- Name: seq_tracking_status; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_tracking_status
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_tracking_status OWNER TO postgres;

--
-- TOC entry 236 (class 1259 OID 16534)
-- Name: seq_user; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_user
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_user OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 219 (class 1259 OID 16454)
-- Name: tb_access; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_access (
    id bigint NOT NULL,
    description character varying(255) NOT NULL
);


ALTER TABLE public.tb_access OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 16492)
-- Name: tb_account_payable; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_account_payable (
    id bigint NOT NULL,
    account_status_payable character varying(255),
    description character varying(255),
    discount_amount numeric(19,2),
    due_date date,
    payment_date date,
    total_amount numeric(19,2),
    person_id bigint NOT NULL,
    supplier_id bigint NOT NULL
);


ALTER TABLE public.tb_account_payable OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 16499)
-- Name: tb_account_receivable; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_account_receivable (
    id bigint NOT NULL,
    account_status_receivable character varying(255),
    description character varying(255),
    discount_amount numeric(19,2),
    due_date date,
    payment_date date,
    total_amount numeric(19,2),
    person_id bigint NOT NULL
);


ALTER TABLE public.tb_account_receivable OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16459)
-- Name: tb_address; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_address (
    id bigint NOT NULL,
    address_complement character varying(255),
    cep character varying(255),
    city character varying(255),
    neighborhood character varying(255),
    number character varying(255),
    street character varying(255),
    uf character varying(255),
    person_id bigint NOT NULL,
    address_type character varying(255)
);


ALTER TABLE public.tb_address OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 16506)
-- Name: tb_discount_coupon; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_discount_coupon (
    id bigint NOT NULL,
    coupon_code character varying(255),
    coupon_expiration_date date,
    discount_amount numeric(19,2),
    discount_percentage numeric(19,2)
);


ALTER TABLE public.tb_discount_coupon OWNER TO postgres;

--
-- TOC entry 243 (class 1259 OID 16579)
-- Name: tb_invoice_product_item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_invoice_product_item (
    id bigint NOT NULL,
    quantity double precision,
    product_id bigint NOT NULL,
    purchase_invoice_id bigint NOT NULL
);


ALTER TABLE public.tb_invoice_product_item OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16466)
-- Name: tb_legal_person; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_legal_person (
    id bigint NOT NULL,
    email character varying(255),
    name character varying(255),
    phone character varying(255),
    business_name character varying(255),
    category character varying(255),
    cnpj character varying(255),
    municipal_registration character varying(255),
    state_registration character varying(255),
    trade_name character varying(255)
);


ALTER TABLE public.tb_legal_person OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16473)
-- Name: tb_natural_person; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_natural_person (
    id bigint NOT NULL,
    email character varying(255),
    name character varying(255),
    phone character varying(255),
    cpf character varying(255) NOT NULL,
    date_of_birth date
);


ALTER TABLE public.tb_natural_person OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 16511)
-- Name: tb_payment_method; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_payment_method (
    id bigint NOT NULL,
    decription character varying(255)
);


ALTER TABLE public.tb_payment_method OWNER TO postgres;

--
-- TOC entry 237 (class 1259 OID 16545)
-- Name: tb_product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_product (
    id bigint NOT NULL,
    alert_stock boolean,
    click_count integer,
    depth double precision,
    description text,
    heigth double precision,
    link_you_tube character varying(255),
    name character varying(255),
    quantity_stock integer,
    sale_value numeric(19,2),
    stock_quantity_alert integer,
    unit_type character varying(255),
    weight double precision,
    width double precision,
    is_active boolean
);


ALTER TABLE public.tb_product OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16480)
-- Name: tb_product_brand; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_product_brand (
    id bigint NOT NULL,
    description_name character varying(255) NOT NULL
);


ALTER TABLE public.tb_product_brand OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 16485)
-- Name: tb_product_category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_product_category (
    id bigint NOT NULL,
    description_name character varying(255) NOT NULL
);


ALTER TABLE public.tb_product_category OWNER TO postgres;

--
-- TOC entry 239 (class 1259 OID 16553)
-- Name: tb_product_image; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_product_image (
    id bigint NOT NULL,
    original_image text,
    thumbnail_image text,
    product_id bigint NOT NULL
);


ALTER TABLE public.tb_product_image OWNER TO postgres;

--
-- TOC entry 245 (class 1259 OID 16595)
-- Name: tb_product_rating; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_product_rating (
    id bigint NOT NULL,
    justification character varying(255) NOT NULL,
    score integer NOT NULL,
    person_id bigint NOT NULL,
    product_id bigint NOT NULL
);


ALTER TABLE public.tb_product_rating OWNER TO postgres;

--
-- TOC entry 241 (class 1259 OID 16566)
-- Name: tb_purchase_invoice; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_purchase_invoice (
    id bigint NOT NULL,
    icmsamount numeric(19,2),
    description character varying(255),
    discount_amount numeric(19,2),
    invoice_number character varying(255),
    invoice_series character varying(255),
    purchase_date date,
    total_amount numeric(19,2),
    account_payable_id bigint NOT NULL,
    person_id bigint NOT NULL
);


ALTER TABLE public.tb_purchase_invoice OWNER TO postgres;

--
-- TOC entry 246 (class 1259 OID 16600)
-- Name: tb_sale; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_sale (
    id bigint NOT NULL,
    delivery_date date NOT NULL,
    delivery_days integer NOT NULL,
    discount_amount numeric(19,2),
    sale_date date NOT NULL,
    shipping_cost numeric(19,2) NOT NULL,
    total_amount numeric(19,2) NOT NULL,
    billing_address_id bigint NOT NULL,
    delivery_address_id bigint NOT NULL,
    discount_coupon_id bigint,
    payment_method_id bigint NOT NULL,
    person_id bigint NOT NULL,
    sale_invoice_id bigint NOT NULL
);


ALTER TABLE public.tb_sale OWNER TO postgres;

--
-- TOC entry 247 (class 1259 OID 16605)
-- Name: tb_sale_invoice; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_sale_invoice (
    id bigint NOT NULL,
    invoice_number character varying(255) NOT NULL,
    invoice_series character varying(255) NOT NULL,
    pdf text NOT NULL,
    type character varying(255) NOT NULL,
    xml text NOT NULL,
    sale_id bigint NOT NULL
);


ALTER TABLE public.tb_sale_invoice OWNER TO postgres;

--
-- TOC entry 248 (class 1259 OID 16612)
-- Name: tb_sale_item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_sale_item (
    id bigint NOT NULL,
    quantity double precision NOT NULL,
    product_id bigint NOT NULL,
    sale_id bigint NOT NULL
);


ALTER TABLE public.tb_sale_item OWNER TO postgres;

--
-- TOC entry 249 (class 1259 OID 16617)
-- Name: tb_tracking_status; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_tracking_status (
    id bigint NOT NULL,
    city character varying(255),
    distribution_center character varying(255),
    state character varying(255),
    status character varying(255),
    sale_id bigint NOT NULL
);


ALTER TABLE public.tb_tracking_status OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 16516)
-- Name: tb_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_user (
    id bigint NOT NULL,
    login character varying(255),
    password character varying(255),
    password_update_date date,
    person_id bigint NOT NULL
);


ALTER TABLE public.tb_user OWNER TO postgres;

--
-- TOC entry 231 (class 1259 OID 16523)
-- Name: tb_user_access; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_user_access (
    user_id bigint NOT NULL,
    access_id bigint NOT NULL
);


ALTER TABLE public.tb_user_access OWNER TO postgres;

--
-- TOC entry 4957 (class 0 OID 16454)
-- Dependencies: 219
-- Data for Name: tb_access; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4964 (class 0 OID 16492)
-- Dependencies: 226
-- Data for Name: tb_account_payable; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4965 (class 0 OID 16499)
-- Dependencies: 227
-- Data for Name: tb_account_receivable; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4958 (class 0 OID 16459)
-- Dependencies: 220
-- Data for Name: tb_address; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4966 (class 0 OID 16506)
-- Dependencies: 228
-- Data for Name: tb_discount_coupon; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4981 (class 0 OID 16579)
-- Dependencies: 243
-- Data for Name: tb_invoice_product_item; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4959 (class 0 OID 16466)
-- Dependencies: 221
-- Data for Name: tb_legal_person; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4960 (class 0 OID 16473)
-- Dependencies: 222
-- Data for Name: tb_natural_person; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_natural_person (id, email, name, phone, cpf, date_of_birth) VALUES (1, 'test@gmail.com', 'test name', 'test phone', 'test cpf', '2010-10-10');


--
-- TOC entry 4967 (class 0 OID 16511)
-- Dependencies: 229
-- Data for Name: tb_payment_method; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4975 (class 0 OID 16545)
-- Dependencies: 237
-- Data for Name: tb_product; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_product (id, alert_stock, click_count, depth, description, heigth, link_you_tube, name, quantity_stock, sale_value, stock_quantity_alert, unit_type, weight, width, is_active) VALUES (1, false, 10, 2, 'Test description', 1, 'test link', 'test name', 10, 199.99, 5, 'test unit', 5, 1, true);


--
-- TOC entry 4961 (class 0 OID 16480)
-- Dependencies: 223
-- Data for Name: tb_product_brand; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4962 (class 0 OID 16485)
-- Dependencies: 224
-- Data for Name: tb_product_category; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4977 (class 0 OID 16553)
-- Dependencies: 239
-- Data for Name: tb_product_image; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4983 (class 0 OID 16595)
-- Dependencies: 245
-- Data for Name: tb_product_rating; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_product_rating (id, justification, score, person_id, product_id) VALUES (1, 'test justification 2', 5, 1, 1);


--
-- TOC entry 4979 (class 0 OID 16566)
-- Dependencies: 241
-- Data for Name: tb_purchase_invoice; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4984 (class 0 OID 16600)
-- Dependencies: 246
-- Data for Name: tb_sale; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4985 (class 0 OID 16605)
-- Dependencies: 247
-- Data for Name: tb_sale_invoice; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4986 (class 0 OID 16612)
-- Dependencies: 248
-- Data for Name: tb_sale_item; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4987 (class 0 OID 16617)
-- Dependencies: 249
-- Data for Name: tb_tracking_status; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4968 (class 0 OID 16516)
-- Dependencies: 230
-- Data for Name: tb_user; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4969 (class 0 OID 16523)
-- Dependencies: 231
-- Data for Name: tb_user_access; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5000 (class 0 OID 0)
-- Dependencies: 215
-- Name: seq_access; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_access', 1, false);


--
-- TOC entry 5001 (class 0 OID 0)
-- Dependencies: 232
-- Name: seq_account_payable; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_account_payable', 1, false);


--
-- TOC entry 5002 (class 0 OID 0)
-- Dependencies: 233
-- Name: seq_account_receivable; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_account_receivable', 1, false);


--
-- TOC entry 5003 (class 0 OID 0)
-- Dependencies: 225
-- Name: seq_address; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_address', 1, false);


--
-- TOC entry 5004 (class 0 OID 0)
-- Dependencies: 234
-- Name: seq_discount_coupon; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_discount_coupon', 1, false);


--
-- TOC entry 5005 (class 0 OID 0)
-- Dependencies: 244
-- Name: seq_invoice_product_item; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_invoice_product_item', 1, false);


--
-- TOC entry 5006 (class 0 OID 0)
-- Dependencies: 235
-- Name: seq_payment_method; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_payment_method', 1, false);


--
-- TOC entry 5007 (class 0 OID 0)
-- Dependencies: 216
-- Name: seq_person; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_person', 1, false);


--
-- TOC entry 5008 (class 0 OID 0)
-- Dependencies: 238
-- Name: seq_product; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_product', 1, false);


--
-- TOC entry 5009 (class 0 OID 0)
-- Dependencies: 217
-- Name: seq_product_brand; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_product_brand', 1, false);


--
-- TOC entry 5010 (class 0 OID 0)
-- Dependencies: 218
-- Name: seq_product_category; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_product_category', 1, false);


--
-- TOC entry 5011 (class 0 OID 0)
-- Dependencies: 240
-- Name: seq_product_image; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_product_image', 1, false);


--
-- TOC entry 5012 (class 0 OID 0)
-- Dependencies: 250
-- Name: seq_product_rating; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_product_rating', 1, false);


--
-- TOC entry 5013 (class 0 OID 0)
-- Dependencies: 242
-- Name: seq_purchase_invoice; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_purchase_invoice', 1, false);


--
-- TOC entry 5014 (class 0 OID 0)
-- Dependencies: 251
-- Name: seq_sale; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_sale', 1, false);


--
-- TOC entry 5015 (class 0 OID 0)
-- Dependencies: 252
-- Name: seq_sale_invoice; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_sale_invoice', 1, false);


--
-- TOC entry 5016 (class 0 OID 0)
-- Dependencies: 253
-- Name: seq_sale_item; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_sale_item', 1, false);


--
-- TOC entry 5017 (class 0 OID 0)
-- Dependencies: 254
-- Name: seq_tracking_status; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_tracking_status', 1, false);


--
-- TOC entry 5018 (class 0 OID 0)
-- Dependencies: 236
-- Name: seq_user; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_user', 1, false);


--
-- TOC entry 4735 (class 2606 OID 16458)
-- Name: tb_access tb_access_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_access
    ADD CONSTRAINT tb_access_pkey PRIMARY KEY (id);


--
-- TOC entry 4747 (class 2606 OID 16498)
-- Name: tb_account_payable tb_account_payable_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_account_payable
    ADD CONSTRAINT tb_account_payable_pkey PRIMARY KEY (id);


--
-- TOC entry 4749 (class 2606 OID 16505)
-- Name: tb_account_receivable tb_account_receivable_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_account_receivable
    ADD CONSTRAINT tb_account_receivable_pkey PRIMARY KEY (id);


--
-- TOC entry 4737 (class 2606 OID 16465)
-- Name: tb_address tb_address_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_address
    ADD CONSTRAINT tb_address_pkey PRIMARY KEY (id);


--
-- TOC entry 4751 (class 2606 OID 16510)
-- Name: tb_discount_coupon tb_discount_coupon_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_discount_coupon
    ADD CONSTRAINT tb_discount_coupon_pkey PRIMARY KEY (id);


--
-- TOC entry 4767 (class 2606 OID 16583)
-- Name: tb_invoice_product_item tb_invoice_product_item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_invoice_product_item
    ADD CONSTRAINT tb_invoice_product_item_pkey PRIMARY KEY (id);


--
-- TOC entry 4739 (class 2606 OID 16472)
-- Name: tb_legal_person tb_legal_person_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_legal_person
    ADD CONSTRAINT tb_legal_person_pkey PRIMARY KEY (id);


--
-- TOC entry 4741 (class 2606 OID 16479)
-- Name: tb_natural_person tb_natural_person_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_natural_person
    ADD CONSTRAINT tb_natural_person_pkey PRIMARY KEY (id);


--
-- TOC entry 4753 (class 2606 OID 16515)
-- Name: tb_payment_method tb_payment_method_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_payment_method
    ADD CONSTRAINT tb_payment_method_pkey PRIMARY KEY (id);


--
-- TOC entry 4743 (class 2606 OID 16484)
-- Name: tb_product_brand tb_product_brand_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_product_brand
    ADD CONSTRAINT tb_product_brand_pkey PRIMARY KEY (id);


--
-- TOC entry 4745 (class 2606 OID 16489)
-- Name: tb_product_category tb_product_category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_product_category
    ADD CONSTRAINT tb_product_category_pkey PRIMARY KEY (id);


--
-- TOC entry 4763 (class 2606 OID 16559)
-- Name: tb_product_image tb_product_image_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_product_image
    ADD CONSTRAINT tb_product_image_pkey PRIMARY KEY (id);


--
-- TOC entry 4761 (class 2606 OID 16551)
-- Name: tb_product tb_product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_product
    ADD CONSTRAINT tb_product_pkey PRIMARY KEY (id);


--
-- TOC entry 4769 (class 2606 OID 16599)
-- Name: tb_product_rating tb_product_rating_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_product_rating
    ADD CONSTRAINT tb_product_rating_pkey PRIMARY KEY (id);


--
-- TOC entry 4765 (class 2606 OID 16572)
-- Name: tb_purchase_invoice tb_purchase_invoice_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_purchase_invoice
    ADD CONSTRAINT tb_purchase_invoice_pkey PRIMARY KEY (id);


--
-- TOC entry 4773 (class 2606 OID 16611)
-- Name: tb_sale_invoice tb_sale_invoice_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_sale_invoice
    ADD CONSTRAINT tb_sale_invoice_pkey PRIMARY KEY (id);


--
-- TOC entry 4775 (class 2606 OID 16616)
-- Name: tb_sale_item tb_sale_item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_sale_item
    ADD CONSTRAINT tb_sale_item_pkey PRIMARY KEY (id);


--
-- TOC entry 4771 (class 2606 OID 16604)
-- Name: tb_sale tb_sale_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_sale
    ADD CONSTRAINT tb_sale_pkey PRIMARY KEY (id);


--
-- TOC entry 4777 (class 2606 OID 16623)
-- Name: tb_tracking_status tb_tracking_status_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_tracking_status
    ADD CONSTRAINT tb_tracking_status_pkey PRIMARY KEY (id);


--
-- TOC entry 4755 (class 2606 OID 16522)
-- Name: tb_user tb_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_user
    ADD CONSTRAINT tb_user_pkey PRIMARY KEY (id);


--
-- TOC entry 4757 (class 2606 OID 16681)
-- Name: tb_user_access uk_jg1ddsj0wccenca6qe3b3gy6x; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_user_access
    ADD CONSTRAINT uk_jg1ddsj0wccenca6qe3b3gy6x UNIQUE (access_id);


--
-- TOC entry 4759 (class 2606 OID 16529)
-- Name: tb_user_access unique_access_user; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_user_access
    ADD CONSTRAINT unique_access_user UNIQUE (user_id, access_id);


--
-- TOC entry 4806 (class 2620 OID 16688)
-- Name: tb_product_rating validpersoninsert1; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER validpersoninsert1 BEFORE INSERT ON public.tb_product_rating FOR EACH ROW EXECUTE FUNCTION public.validperson();


--
-- TOC entry 4796 (class 2620 OID 16690)
-- Name: tb_account_payable validpersoninsert2; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER validpersoninsert2 BEFORE INSERT ON public.tb_account_payable FOR EACH ROW EXECUTE FUNCTION public.validperson();


--
-- TOC entry 4797 (class 2620 OID 16693)
-- Name: tb_account_payable validpersoninsert3; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER validpersoninsert3 BEFORE INSERT ON public.tb_account_payable FOR EACH ROW EXECUTE FUNCTION public.validperson2();


--
-- TOC entry 4800 (class 2620 OID 16695)
-- Name: tb_account_receivable validpersoninsert4; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER validpersoninsert4 BEFORE INSERT ON public.tb_account_receivable FOR EACH ROW EXECUTE FUNCTION public.validperson();


--
-- TOC entry 4794 (class 2620 OID 16697)
-- Name: tb_address validpersoninsert5; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER validpersoninsert5 BEFORE INSERT ON public.tb_address FOR EACH ROW EXECUTE FUNCTION public.validperson();


--
-- TOC entry 4804 (class 2620 OID 16699)
-- Name: tb_purchase_invoice validpersoninsert6; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER validpersoninsert6 BEFORE INSERT ON public.tb_purchase_invoice FOR EACH ROW EXECUTE FUNCTION public.validperson();


--
-- TOC entry 4802 (class 2620 OID 16701)
-- Name: tb_user validpersoninsert7; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER validpersoninsert7 BEFORE INSERT ON public.tb_user FOR EACH ROW EXECUTE FUNCTION public.validperson();


--
-- TOC entry 4808 (class 2620 OID 16703)
-- Name: tb_sale validpersoninsert8; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER validpersoninsert8 BEFORE INSERT ON public.tb_sale FOR EACH ROW EXECUTE FUNCTION public.validperson();


--
-- TOC entry 4807 (class 2620 OID 16687)
-- Name: tb_product_rating validpersonupdate1; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER validpersonupdate1 BEFORE UPDATE ON public.tb_product_rating FOR EACH ROW EXECUTE FUNCTION public.validperson();


--
-- TOC entry 4798 (class 2620 OID 16689)
-- Name: tb_account_payable validpersonupdate2; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER validpersonupdate2 BEFORE UPDATE ON public.tb_account_payable FOR EACH ROW EXECUTE FUNCTION public.validperson();


--
-- TOC entry 4799 (class 2620 OID 16692)
-- Name: tb_account_payable validpersonupdate3; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER validpersonupdate3 BEFORE UPDATE ON public.tb_account_payable FOR EACH ROW EXECUTE FUNCTION public.validperson2();


--
-- TOC entry 4801 (class 2620 OID 16694)
-- Name: tb_account_receivable validpersonupdate4; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER validpersonupdate4 BEFORE UPDATE ON public.tb_account_receivable FOR EACH ROW EXECUTE FUNCTION public.validperson();


--
-- TOC entry 4795 (class 2620 OID 16696)
-- Name: tb_address validpersonupdate5; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER validpersonupdate5 BEFORE UPDATE ON public.tb_address FOR EACH ROW EXECUTE FUNCTION public.validperson();


--
-- TOC entry 4805 (class 2620 OID 16698)
-- Name: tb_purchase_invoice validpersonupdate6; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER validpersonupdate6 BEFORE UPDATE ON public.tb_purchase_invoice FOR EACH ROW EXECUTE FUNCTION public.validperson();


--
-- TOC entry 4803 (class 2620 OID 16700)
-- Name: tb_user validpersonupdate7; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER validpersonupdate7 BEFORE UPDATE ON public.tb_user FOR EACH ROW EXECUTE FUNCTION public.validperson();


--
-- TOC entry 4809 (class 2620 OID 16702)
-- Name: tb_sale validpersonupdate8; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER validpersonupdate8 BEFORE UPDATE ON public.tb_sale FOR EACH ROW EXECUTE FUNCTION public.validperson();


--
-- TOC entry 4778 (class 2606 OID 16535)
-- Name: tb_user_access access_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_user_access
    ADD CONSTRAINT access_fk FOREIGN KEY (access_id) REFERENCES public.tb_access(id);


--
-- TOC entry 4781 (class 2606 OID 16574)
-- Name: tb_purchase_invoice account_payable_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_purchase_invoice
    ADD CONSTRAINT account_payable_fk FOREIGN KEY (account_payable_id) REFERENCES public.tb_account_payable(id);


--
-- TOC entry 4785 (class 2606 OID 16634)
-- Name: tb_sale billing_address_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_sale
    ADD CONSTRAINT billing_address_fk FOREIGN KEY (billing_address_id) REFERENCES public.tb_address(id);


--
-- TOC entry 4786 (class 2606 OID 16639)
-- Name: tb_sale delivery_address_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_sale
    ADD CONSTRAINT delivery_address_fk FOREIGN KEY (delivery_address_id) REFERENCES public.tb_address(id);


--
-- TOC entry 4787 (class 2606 OID 16644)
-- Name: tb_sale discount_coupon_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_sale
    ADD CONSTRAINT discount_coupon_fk FOREIGN KEY (discount_coupon_id) REFERENCES public.tb_discount_coupon(id);


--
-- TOC entry 4788 (class 2606 OID 16649)
-- Name: tb_sale payment_method_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_sale
    ADD CONSTRAINT payment_method_fk FOREIGN KEY (payment_method_id) REFERENCES public.tb_payment_method(id);


--
-- TOC entry 4780 (class 2606 OID 16561)
-- Name: tb_product_image product_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_product_image
    ADD CONSTRAINT product_fk FOREIGN KEY (product_id) REFERENCES public.tb_product(id);


--
-- TOC entry 4782 (class 2606 OID 16585)
-- Name: tb_invoice_product_item product_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_invoice_product_item
    ADD CONSTRAINT product_fk FOREIGN KEY (product_id) REFERENCES public.tb_product(id);


--
-- TOC entry 4784 (class 2606 OID 16629)
-- Name: tb_product_rating product_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_product_rating
    ADD CONSTRAINT product_fk FOREIGN KEY (product_id) REFERENCES public.tb_product(id);


--
-- TOC entry 4791 (class 2606 OID 16664)
-- Name: tb_sale_item product_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_sale_item
    ADD CONSTRAINT product_fk FOREIGN KEY (product_id) REFERENCES public.tb_product(id);


--
-- TOC entry 4783 (class 2606 OID 16590)
-- Name: tb_invoice_product_item purchase_invoice_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_invoice_product_item
    ADD CONSTRAINT purchase_invoice_fk FOREIGN KEY (purchase_invoice_id) REFERENCES public.tb_purchase_invoice(id);


--
-- TOC entry 4790 (class 2606 OID 16659)
-- Name: tb_sale_invoice sale_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_sale_invoice
    ADD CONSTRAINT sale_fk FOREIGN KEY (sale_id) REFERENCES public.tb_sale(id);


--
-- TOC entry 4792 (class 2606 OID 16669)
-- Name: tb_sale_item sale_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_sale_item
    ADD CONSTRAINT sale_fk FOREIGN KEY (sale_id) REFERENCES public.tb_sale(id);


--
-- TOC entry 4793 (class 2606 OID 16674)
-- Name: tb_tracking_status sale_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_tracking_status
    ADD CONSTRAINT sale_fk FOREIGN KEY (sale_id) REFERENCES public.tb_sale(id);


--
-- TOC entry 4789 (class 2606 OID 16654)
-- Name: tb_sale sale_invoice_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_sale
    ADD CONSTRAINT sale_invoice_fk FOREIGN KEY (sale_invoice_id) REFERENCES public.tb_sale_invoice(id);


--
-- TOC entry 4779 (class 2606 OID 16540)
-- Name: tb_user_access user_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_user_access
    ADD CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES public.tb_user(id);


-- Completed on 2024-07-03 14:18:50

--
-- PostgreSQL database dump complete
--

