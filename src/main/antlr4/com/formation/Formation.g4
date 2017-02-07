grammar Formation;

// Parser Rules

formation: sector? (DELIMITER? (group | vehicle))+;

group: GROUP_START (DELIMITER? vehicle)+ GROUP_END;

vehicle: STATUS? NO_LEFT_PASSAGE? vehicleType NO_RIGHT_PASSAGE? order? offer? sector?;

sector: SECTOR_PREFIX sectorName;

sectorName: TEXT;

vehicleType: TEXT;

order: ORDER_PREFIX orderNumber;

orderNumber: TEXT;

offer: OFFER_PREFIX (offerText OFFER_DELIMITER?)+;

offerText: TEXT;


// Lexer Rules

DELIMITER: ',';

GROUP_START: '[';

GROUP_END: ']';

STATUS:  '-' | 'R' ;

NO_LEFT_PASSAGE: '(';

NO_RIGHT_PASSAGE: ')';

SECTOR_PREFIX: '@';

ORDER_PREFIX: ':';

OFFER_PREFIX: '#';

OFFER_DELIMITER: ';';

TEXT : ( [a-zA-Z] | [0-9] )+ ;

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ -> skip ;