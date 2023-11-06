create table ColoringBook
(
    id integer not null primary key,
    illustration varchar not null,
    positionOfColors varchar not null
);
select *
from ColoringBook;

create table TemplatesForColoringBook
(
    id integer not null primary key,
    name varchar not null,
    positionOfColors varchar not null
);

insert into TemplatesForColoringBook
(id, name, positionOfColors) VALUES
(1, 'Parrot', '111111133311111111111311331111111111316991111111111311991111111113331691111111113333111111111132223311111111322253311111111222253311111111444533111111114488533111111118855331111111115556611111111113517677777111113111111111111'),
(2, 'Chicken', '111111111111111111111111111111111331111111111113551111111111115455111111511122555111115551113555511555551113555555555551111555555515511111555555515511111155155115111111155511155111111115555551111111111114111111111111114111111');