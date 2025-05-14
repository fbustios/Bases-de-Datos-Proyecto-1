1 Proyecto Bases de Datos 1 con Spring Boot 

Los inserts para la tabla taxon fueron los siguientes:
select * from reportes.observacion

select * from modelos.taxon
--clases de cada filo del animalia
insert into modelos.taxon(nombre,padre_id) values('calcarea',5),('demospongiae',5),('hexactinellida',5),('homoscleromorpha',5)
,('anthozoa',6),('scyphozoa',6),('cubozoa',6),('hydrozoa',6),('staurozoa',6),('myxozoa',6),('polypodiozoa',6),('tentaculata',7),('nuda',7)
,('polychaeta',9)('oligochaeta',9)('hirudinea',9),('insecta',10),('arachnida',10),('crustacea',10),('chilopoda',10),('diplopoda',10),('gastropoda',11)
,('bivalvia',11),('cephalopoda',11),('polyplacophora',11),('monoplacophora',11),('scaphopoda',11),('aplacophora',11),('asteroidea',12)
,('ophiuroidea',12),('echinoidea',12),('holothuroidea',12),('crinoidea',12),('ascidiacea',13),('appendicularia',13),('thaliacea',13),
('leptocardii',13),('myxini',13),('petromyzontida',13),('chondrichthyes',13),('actinopterygii',13),('sarcopterygii',13),
('amphibia',13),('reptilia',13),('aves',13),('mammalia',13),('secernentea',14),('adenophorea',14),('turbellaria',15),('trematoda',15),
('cestoda',15),('monogenea',15), ('monogononta',16), ('bdelloidea',16), ('seisonidea',16)

--clases de cada filo del plantae

insert into modelos.taxon(nombre,padre_id) values('bryopsida',34),('marchantiopsida',35),('jungermanniopsida',35),('anthocerotopsida',36),
('lycopodiopsida',37),('polypodiopsida',38),('equisetopsida',38),('cycadopsida',39),('ginkgoopsida',40),('pinopsida',41),('monocotyledoneae',43),('eudicotyledoneae',43)

--clases de cada filo del fungi

insert into modelos.taxon(nombre,padre_id) values('chytridiomycetes',44),('blastocladiomycetes',45),('neocallimastigomycetes',46),('glomeromycetes',47),
('saccharomycetes',48),('eurotiomycetes',48),('sordariomycetes',48),('leotiomycetes',48),('dothideomycetes',48),('pezizomycetes',48),('laboulbeniomycetes',48),
('agaricomycetes',49),('ustilaginomycetes',49),('pucciniomycetes',48)

--ordenes de cada clase del animalia
insert into modelos.taxon(nombre,padre_id) values('leucosolenida',51),('clathrinida',51),('haplosclerida',52),('poecilosclerida',52),('spirophorida',52),
('lyssacinosida',53),('hexactinosida',53),('scleractinia',55),('actiniaria',55),('alcyonacea',55),('semaeostomeae',56),('rhizostomeae',56),
('carybdeida',57),('chirodropida',57),('leptothecata',58),('anthoathecata',58),('errantia',64),('sedentaria',64),('haplotaxida',65),('rhynchobdellida',66),
('arhynchobdellida',66),('coleoptera',67),('lepidoptera',67),('diptera',67),('hymenoptera',67),('araneae',68),('scorpiones',68),('acari',68),
('decapoda',69),('isopoda',69),('amphipoda',69),('scolopendromorpha',70),('julida',71),('spirobolida',71),('stylommatophora',72),('neogastropoda',72),
('venerida',73),('mytilida',73),('octopoda',74),('teuthida',74),('sepiida',74),('forcipulatida',79),('valvatida',79),('ophiurida',80),('euryalida',80),
('cidaroida',81),('camarodonta',81),('aspidochirotida',82),('dendrochirotida',82),('comatulida',83),('isocrinida',83),
('perciformes',91),('cypriniformes',91),('siluriformes',91),('anura',93),('caudata',93),('squamata',94),('testudines',94),('crocodilia',94),
('passeriformes',95),('falconiformes',95),('anseriformes',95),('primates',96),('carnivora',96),('rodentia',96),('cetacea',96)

--ordenes de cada clase del plantae

insert into modelos.taxon(nombre,padre_id) values('bryales',106),('hypnales',106),('dicranales',106),('funariales',106),('polytrichales',106),
('marchantiales',107),('jungermanniales',107),('metzgeriales',107),('anthocerotales',109),('lycopodiales',110),('isoetales',110),('selaginellales',110),
('polypodiales',111),('salviniales',111),('osmundales',111),('cyatheales',111),('schizaeales',111),('marattiales',111),('gleicheniales',111),
('hymenophyllales',111),('equisetales',112),('cycadales',113),('ginkgoales',114),('pinales',115)
--ordenes de cada clase del fungi

--ordenes de cada clase del fungi
insert into modelos.taxon(nombre,padre_id) values('chytridiales',118),('spizellomycetales',118),('rhizophydiales',118),('blastocladiales',119),
('neocallimastigales',120),('glomerales',121),('saccharomycetales',123),('eurotiales',123),('onygenales',123),('hypocreales',124),('sordariales',124),('xylariales',124),
('helotiales',125),('erysiphales',125),('pleosporales',126),('capnodiales',126),('pezizales',127),('agaricales',129),('boletales',129),
('polyporales',129),('russulales',129),('cantharellales',129),('thelephorales',129),('ustilaginales',130),('pucciniales',131)

--familias de cada orden del animalia
insert into modelos.taxon(nombre,padre_id) values('hominidae',194),('cercopithecidae',194),('atelidae',194),('callitrichidae',194),
('canidae',195),('felidae',195),('ursidae',195),('mustelidae',195),('procyonidae',195),('hyaenidae',195),('muridae',196),
('sciuridae',196),('caviidae',196),('cricetidae',196),('balaenidae',197),('delphinidae',197),('phocoenidae',197),('colubridae',188),
('viperidae',188),('elapidae',188),('iguanidae',188),('agamidae',188),('gekkonidae',188),('testudinidae',189),('cheloniidae',189),(' emydidae',189),
('alligatordae',190),('crocodylidae',190),('gavialidae',190),('ranidae',186),('bufonidae',186),('hylidae',186),('salamandridae',187),('ambystomatidae',187),
('corvidae',191),('turdidae',191),('paridae',191),('fringillidae',191),('estrildidae',191),('falconidae',192),('carabidae',153),('tenebrionidae',153),
('cerambycidae',153),('curculionidae',153),('nymphalidae',154),('pieridae',154),('saturniidae',154),('muscidae',155),('ceratopogonidae',155),('culicidae',155),
('apidae',156),('formicidae',156),('vespidae',156),('theraphosidae',157),('salticidae',157),('araneidae',157)

--familias de cada orden del plantae
insert into modelos.taxon(nombre,padre_id) values('bryaceae',198),('mniaceae',198),('funariaceae',198),('hypnaceae',199),('pleuroziaceae',199),('pleroceraceae',199),
('polypodiaceae',210),('dryopteridaceae',210),('aspleniaceae',210),('blechnaceae',210),('equisetaceae',218),('pinaceae',221),('cupressaceae',221),
('podocarpaceae',221),('taxaceae',221),('marchantiaceae',203),('aytoniaceae',203)

--familias de cada orden del fungi
insert into modelos.taxon(nombre,padre_id) values('agaricaceae',239),('amanitaceae',239),('marasmiaceae',239),('strophariaceae',239),
('psathyrellaceae',239),('boletaceae',240),('suillaceae',240),('sclerodermataceae',240),('polyporaceae',241),('ganodermataceae',241),('ganodermataceae',241),
('russulaceae',242),('auriscalpiaceae',242),('hericiaceae',238),('pezizaceae',238),('morchellaceae',238),('tuberaceae',238),('sordariaceae',232),('chaetomiaceae',232),
('clavicipitaceae',231),('hypocreaceae',231),('nectriaceae',231),('dermateaceae',234),('dermateaceae',234)

--géneros de cada familia del animalia
insert into modelos.taxon(nombre,padre_id) values('homo',247),('pan',247),('gorilla',247),('pongo',247),('cercopithecus',248),('macaca',248),
('colobus',248),('baboon',248),('canis',251),('vulpes',251),('cuon',251),('lycaon',251),('panthera',252),('felis',252),('puma',252),('lynx',252),
('ursus',253),('melursus',253),('ailuropoda',253),('tremarctos',253),('helarctos',253),('mustela',254),('martes',254),('lutra',254),('marten',254),
('mus',257),('rattus',257),('apodemus',257),('gerbillus',257),('sciurus',258),('tamias',258),('glaucomys',258),('spermophilus',258),
('balaena',261),('eschrichtius',261),('megaptera',261),('balaenoptera',261),('delphinus',262),('tursiops',262),('stenella',262),
('coluber',264),('pantherophis',264),('lampropeltis',264),('nerodia',264),('vipera',265),('crotalus',265),('agkistrodon',265),('trimeresurus',265),
('naja',266),('ophiophagus',266),('bungarus',266),('dignus',266),('iguana',267),('ctenosaura',267),('amblyrhynchus',267),
('testudo',270),('geochelone',270),('centrochelys',270),('chelonia',271),('caretta',271),('eretmochelys',271),('dermochelys',271),
('alligator',273),('cavia',273),('melanochelys',273),('crocodylus',274),('osteolaemus',274),('paleosuchus',274),('carabus',287),('calosoma',287),
('bembidion',287),('pterostichus',287),('tenebrio',288),('allecula',288),('lasiocampidae',288),('staphylinidae',288),('turdus',282),('sialia',282),
('corvus',281),('cyanocitta',281),('falco',286),('caracara',286),('parus',283),('poecile',283),('baeolophus',283),('cyanistes',283),('lophophanes',283)


--géneros de cada familia del plantae
insert into modelos.taxon(nombre,padre_id) values('bryum',303),('plagiobryum',303),('rosulabryum',303),('mnium',304),('plagiomnium',304),('rhodobryum',304),
('funaria',305),('physcomitrium',305),('hypnum',306),('campylopus',306),('pleurozia',307),('polypodium',309),
('phlebodium',309),('microgramma',309),('dryopteris',310),('polystichum',310),('atherium',310),('asplenium',311),('camptosorus',311),('blechnum',312),('woodwardia',312),
('pinus',314),('abies',314),('picea',314),('larix',314),('tsuga',314),('juniperus',315),('cupressus',315),('thuja',315),('podocarpus',316),('dacrycarpus',316),
('prumnopitys',316)


--especies de animalia
insert into modelos.taxon(nombre,padre_id) values('canis lupus',352),('canis familiaris',352),('felis catus',357),('panthera leo',356),('panthera tigris',356),
('ursus arctos',360),('ursus maritimus',360),('balaenoptera musculus',380),('delphinus delphis',381),('tursiops truncatus',381),
('parus domesticus',426),('parus troglodytes',426),('pongo domesticus',347),('pongo rufus',347),('ailuropoda melanoleuca',362),('ailuropoda melanoleuca',362),
('tremarctos ornatus',363),('tremarctos flavus',363),('helarctos malayanus',364),('helarctos indicus',364),('mustela erminea',365),('mustela vison',365),
('martes martes',366),('martes americana',366),('lutra lutra',367),('lutra canadensis',367),('marten americana',368),('marten martes',368),
('rattus norvegicus',370),('rattus rattus',370),('sciurus vulgaris',373),('sciurus carolinensis',373),('tamias striatus',374),('tamias striatus',374),
('glaucomys volans',375),('glaucomys sabrinus',375),('spermophilus tridecemlineatus',376),('spermophilus lateralis',376),('balaena mysticetus',377),
('balaena glacialis',377),('eschrichtius robustus',378),('eschrichtius gibbosus',378),('megaptera novaeangliae',379),('delphinus capenses',381),
('stenella longirostris',383),('stenella attenuata',383),('coluber constrictor',384),('coluber viridiflavus',384),('pantherophis guttatus',385),
('pantherophis obsoletus',385),('lampropeltis getula',386),('lampropeltis triangulum',386),('nerodia sipedon',387),('nerodia erythrogaster',387),
('vipera aspis',388),('crotalus atrox',389),('crotalus adamanteus',389),('trimeresurus erythrurus',391),('trimeresurus hageni',391),
('iguana iguana',396),('iguana delicatissima',396),('ctenosaura pectinata',397),('ctenosaura defensor',397),('amblyrhynchus cristatus',398),
('amblyrhynchus microlepis',398),('testudo graeca',399),('testudo hermanni',399),('geochelone gigantea',400),('geochelone elegans',400),('centrochelys sulcata',401),
('centrochelys galapagensis',401),('chelonia mydas',402),('chelonia agassizii',402),('caretta caretta',403),('caretta caretta',403),
('eretmochelys imbricata',404),('eretmochelys bissa',404),('alligator mississippiensis',406),('alligator sinensis',406),('cavia porcellus',407),
('cavia tschudii',407),('crocodylus acutus',409),('crocodylus porosus',409),('osteolaemus tetraspis',410),('osteolaemus osborni',410),
('carabus auratus',412),('carabus nemoralis',412),('calosoma sycophanta',413),('calosoma inquisitor',413),('pterostichus melanarius',415),
('tenebrio molitor',416),('tenebrio obscurus',416),('lasiocampa quercus',418),('lasiocampa trifolii',418),('turdus merula',420),('turdus philomelos',420),
('sialia sialis',421),('sialia currucoides',421),('corvus corax',422),('corvus brachyrhynchos',422),('cyanocitta cristata',423),('cyanocitta stelleri',423),
('falco peregrinus',424),('falco tinnunculus',424),('caracara plancus',425),('caracara cheriway',425),('parus major',426),('parus caeruleus',426),
('baeolophus bicolor',428),('baeolophus inornatus',428),('cyanistes caeruleus',429),('cyanistes cyanus',429),('lophophanes cristatus',430)


--especies de plantae

insert into modelos.taxon(nombre,padre_id) values('bryum argenteum',431),('bryum caespiticium',431),('plagiobryum zollingeri',432),('plagiobryum laetum',432),
('polypodium vulgare',442),('polypodium interjectum',442),('phlebodium aureum',443),('microgramma vacciniifolia',444),('microgramma heterophylla',444),
('dryopteris filix-mas',445),('dryopteris affinis',445),('polystichum aculeatum',446),('polystichum setiferum',446),('asplenium scolopendrium',448),('asplenium trichomanes',448),
('camptosorus rhizophyllus',449),('blechnum spicant',450),('blechnum penna-marina',450),('woodwardia radicans',451),('woodwardia virginica',451),
('pinus sylvestris',452),('pinus nigra',452),('abies alba',453),('abies nordmanniana',453),('picea abies',454),('picea sitchensis',454),('larix decidua',455),
('larix kaempferi',455),('tsuga canadensis',456),('tsuga heterophylla',456),('juniperus communis',457),('juniperus virginiana',457),('cupressus sempervirens',458),
('cupressus arizonica',458),('thuja occidentalis',459),('thuja plicata',459),('podocarpus macrophyllus',460),('podocarpus totara',460),
('dacrycarpus dacrydioides',461),('dacrycarpus imbricatus',461),('prumnopitys andina',462),('prumnopitys taxifolia',462)


--nombres comunes de  las especies de animalia
insert into modelos.taxon(nombre,padre_id) values('lobo gris',463),('perro domestico',464),('gato domestico',465),('leon',466),('tigre',467),
('oso pardo',468),('oso polar',469),('ballena azul',470),('delfin comun',471),('delfin nariz de botella',472),
('gorrion comun',473),('chochin europeo',474),('orangutan comun',475),('orangutan rojo',476),('panda gigante',477),('panda menor',478),
('oso andino',479),('oso de los andes',480),('oso malayo',481),('oso indio',482),('comadreja',483),('nutria americana',484),
('marta comun',485),('marta americana',486),('nutria europea',487),('nutria de rio',488),('marta americana',489),('marta comun',490),
('rata parda',491),('rata negra',492),('ardilla roja',493),('ardilla gris',494),('ardilla listada del este',495),('ardilla listada de hudson',496),
('ardilla voladora del sur',497),('ardilla voladora del norte',498),('ardilla de trece franjas',499),('ardilla de cola roja',500),('ballena franca del artico',501),
('ballena franca del atlantico norte',502),('ballena gris',503),('ballena repetida',504),('ballena jorobada',505),('delfin de las costas',506),
('delfin de pico largo',507),('delfin de aletas largas',508),('serpiente de cola negra',509),('serpiente verde y amarilla',510),('serpiente rey de maiz',511),
('serpiente rey negra',512),('serpiente rey comun',513),('serpiente rey de tres bandas',514),('serpiente acuatica comun',515),('serpiente acuatica amarilla',516),
('vibora de aspis',517),('cascabel del desierto',518),('cascabel diamante del este',519),('vibora de bambu de cola roja',520),('vibora de piton de hagen',521),
('iguana verde',522),('iguana de las antillas',523),('iguana de cola espinosa de yucatan',524),('iguana de cola espinosa de cozumel',525),('iguana marina de galapagos',526),
('iguana marina de isla espanola',527),('tortuga griega',528),('tortuga de hermann',529),('tortuga gigante de aldabra',530),('tortuga de estrella india',531),('tortuga africana de espolones',532),
('tortuga gigante de galapagos',533),('tortuga verde',534),('tortuga de agassiz',535),('tortuga boba',536),('tortuga boba gigante',537),
('tortuga carey',538),('tortuga carey del pacifico',539),('caiman americano',540),('caiman chino',541),('cobaya',542),
('cobaya de montana',543),('cocodrilo americano',544),('cocodrilo de agua salada',545),('cocodrilo enano',546),('cocodrilo enano de osborn',547),
('escarabajo dorado',548),('escarabajo de bosque',549),('escarabajo devorador de orugas',550),('escarabajo inquisidor',551),('escarabajo negro',552),
('gusano de harina',553),('gusano de harina oscuro',554),('oruga de roble',555),('oruga de trebol',556),('mirlo comun',557),('mirlo pardo',558),
('azulejo del este',559),('azulejo occidental',560),('cuervo comun',561),('cuervo americano',562),('arrendajo azul',563),('arrendajo de steller',564),
('halcon peregrino',565),('cernicalo vulgar',566),('carancho',567),('caracara norteno',568),('carbonero comun',569),('carbonero azul',570),
('herrero de dos colores',571),('herrero sencillo',572),('herrero azul',573),('herrero comun',574),('herrero crestado',575)

--nombres comunes de las especies plantae
insert into modelos.taxon(nombre,padre_id) values('musgo plateado',576),('musgo de cesped',577),('musgo de zollinger',578),('musgo alegre',579),
('helecho comun',580),('helecho intercalado',581),('helecho dorado',582),('helecho de hojas de arandano',583),('helecho de hojas heterofilicas',584),
('helecho macho',585),('helecho afin',586),('helecho aciculado',587),('helecho setifero',588),('helecho lengua de ciervo',589),('helecho de hojas finas',590),
('(helecho rizofilico',591),('helecho espigado',592),('helecho plumoso',593),('helecho radicante',594),('helecho virginal',595),
('pino silvestre',596),('pino negro',597),('abeto blanco',598),('abeto de nordmann',599),('abeto rojo',600),('abeto de sitka',601),('larice europeo',602),
('larice japones',603),('ttsuga canadiense',604),('tsuga de hojas variables',605),('enebro comun',606),('cedro rojo del este',607),('cipres comun',608),
('cipres de arizona',609),('tuya occidental',610),('tuya gigante',611),('inumaki',612),('totara',613),
('kahikatea',614),('igem',615),('lleuque',616),('kakaterro',617)



El informe propuesto mide la habilidad de identificar especies en especifico de los usuarios, cada usuario con más de tres observaciones o identificaciones de la misma especie se le considera experto.
La sentencia SQL es la siguiente
-->
select u.id, u.nombre, u.primer_apellido, t.nombre
from (
	select o.user_id, o.taxon_id from reportes.observacion o 

	union all

	select i.user_id, i.taxon_id from reportes.identificacion i
	
) as acciones
inner join modelos.user u on u.id = acciones.user_id
inner join modelos.taxon t on t.id = acciones.taxon_id
group by u.id, u.nombre, u.primer_apellido, t.nombre
having count(*) > 3
order by count(*) asc

[DocumentaciónProyecto1-FrancoBustios-AlexanderSalazar.pdf](https://github.com/user-attachments/files/20028469/DocumentacionProyecto1-FrancoBustios-AlexanderSalazar.pdf)

