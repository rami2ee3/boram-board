-- table
create table public.board_article
(
    ba_id         integer not null
        constraint board_article_pk
            primary key,
    ba_title      varchar(200),
    ba_insert_dt  date,
    ba_read_count integer,
    ba_password   varchar(1000),
    ba_contents   text
);

alter table public.board_article
    owner to postgres;


create table public.board_comments
(
    bc_id        integer not null
        constraint board_comments_pk
            primary key,
    ba_id        integer
        constraint board_comments_board_article_ba_id_fk
            references public.board_article,
    bc_contents  varchar(2000),
    bc_password  varchar(1000),
    bc_insert_dt date
);

alter table public.board_comments
    owner to postgres;
-- // table

-- sequence
create sequence public.seq_ba_id
    as integer;

alter sequence public.seq_ba_id owner to postgres;

create sequence public.seq_bc_id
    as integer;

alter sequence public.seq_bc_id owner to postgres;
-- // sequence
