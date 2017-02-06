grammar Formation;

// Parser Rules

formation: sector? groupWithDelimiter+;

groupWithDelimiter: DELIMITER? group;

group: (GROUP_START vehicleWithDelimiter+ GROUP_END | FICTIVE_VEHICLE);

vehicleWithDelimiter: DELIMITER? vehicle;

vehicle: STATUS? NO_LEFT_PASSAGE? vehicleType NO_RIGHT_PASSAGE? order? offer? sector?;

sector: SECTOR_PREFIX sectorName;

sectorName: TEXT;

vehicleType: TEXT;

order: ORDER_PREFIX orderNumber;

orderNumber: TEXT;

offer: OFFER_PREFIX offerDetail+;

offerDetail: offerText OFFER_DELIMITER?;

offerText: TEXT;


// Lexer Rules

DELIMITER: ',';

GROUP_START: '[';

GROUP_END: ']';

FICTIVE_VEHICLE: 'F';

STATUS:  '-' | 'R' ;

NO_LEFT_PASSAGE: '(';

NO_RIGHT_PASSAGE: ')';

SECTOR_PREFIX: '@';

ORDER_PREFIX: ':';

OFFER_PREFIX: '#';

OFFER_DELIMITER: ';';

TEXT : ( [a-zA-Z] | [0-9] )+ ;

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ -> skip ;