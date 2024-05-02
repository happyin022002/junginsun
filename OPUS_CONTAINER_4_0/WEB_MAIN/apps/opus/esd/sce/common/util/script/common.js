/** sheet 관련여부 **/
var sheetObject = null ;
var sheetRow    = 0 ;
 
/** mult check 관련 변수 **/ 
var multiChkYN = false ;

/** Location 관련 변수 **/
var contiCdFld    = "" ;
var scontiCdFld   = "" ;
var cntCdFld      = "" ;
var locStateFld   = "" ;
var locEqOfcFld   = "" ;
var locCdFld      = "" ;
var locDescFld    = "" ;
var locPortIndFld = "" ;
var sysCodeFld    = "" ;

/** Office 관련 변수 **/
var ofcLevFld   = "" ;
var ofcPtsCdFld = "" ;
var ofcCdFld    = "" ;
var ofcNmFld    = "" ;
var callTypeFld = "" ;


/** Customer 관련 변수 **/
var custCdFld   = "" ;
var custNmFld   = "" ;
var custSgmtFld = "" ;

/** VVD 관련 변수 **/
var etdetaFld = "" ;
var sDateFld  = "" ;
var eDateFld  = "" ;
var vvdCdFld  = "" ;
var laneCdFld = "" ;
var operFld   = "" ;

/** Node 관련 변수 **/
var nodeCdFld   = "" ;
var nodeNmFld   = "" ;
var modeFld     = "" ;
var modeOnlyFld = "" ;

/** Service Provider 관련 변수 **/
var ptsVndrCdFld = "" ;
var vndrNmEngFld = "" ;

/** Staff 관련 변수 **/
var userCdFld = "" ;
var userNmFld = "" ;



/**
 *  Location 공통 팝업 오픈
 * 
 * @param multi check 여부
 * @param locCd Loc Code
 * @param locDesc Loc Name
 * @param contiCd Conti
 * @param ScontiCd Sub Conti
 * @param cntCd Country
 * @param locState State
 * @param locEqOfc Control Office
 * @param locPortInd Port Only
 * @param sysCode System
 */
function openLocPop(multi, locCd, locDesc, contiCd, scontiCd, cntCd,
                    locState, locEqOfc, locPortInd, sysCode){
	var param   = "" ;
	var display = getCommPopDisplay(multi) ;
	
	param  = "?classId=" + getCommPopClassId() ; 
	param += getURLParam(multi, "conti_cd",     contiCd) ;
	param += getURLParam(multi, "sconti_cd",    scontiCd) ;
	param += getURLParam(multi, "cnt_cd",       cntCd) ;
	param += getURLParam(multi, "loc_state",    locState) ;
	param += getURLParam(multi, "loc_eq_ofc",   locEqOfc) ;
	param += getURLParam(multi, "loc_cd",       locCd) ;
	param += getURLParam(multi, "loc_desc",     locDesc) ;
	param += getURLParam(multi, "loc_port_ind", locPortInd) ;

	ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 770, 470, 'setValFromLocPop', display) ;
	contiCdFld    = contiCd ;
	scontiCdFld   = scontiCd ;
	cntCdFld      = cntCd ;
	locStateFld   = locState ;
	locEqOfcFld   = locEqOfc ;
	locCdFld      = locCd ;
	locDescFld    = locDesc ;
	locPortIndFld = locPortInd ;
	sysCodeFld    = sysCode ;
	multiChkYN    = multi
}

/**
 *  Location 공통 팝업 오픈(sheet)
 * 
 * @param sheetObj IBSheet Object
 * @param row Row
 * @param multi check 여부
 * @param locCd Loc Code
 * @param locDesc Loc Name
 * @param contiCd Conti
 * @param ScontiCd Sub Conti
 * @param cntCd Country
 * @param locState State
 * @param locEqOfc Control Office
 * @param locPortInd Port Only
 * @param sysCode System
 */
function openLocPopSheet(sheetObj, row, multi, locCd, locDesc, contiCd, scontiCd, cntCd,
                    locState, locEqOfc, locPortInd, sysCode){
	var param   = "" ;
	var display = getCommPopDisplay(multi) ;
	
	contiCdFld    = contiCd ;
	scontiCdFld   = scontiCd ;
	cntCdFld      = cntCd ;
	locStateFld   = locState ;
	locEqOfcFld   = locEqOfc ;
	locCdFld      = locCd ;
	locDescFld    = locDesc ;
	locPortIndFld = locPortInd ;
	sysCodeFld    = sysCode ;
	multiChkYN    = multi
	sheetRow      = row ;	
	sheetObject   = sheetObj ;
	
	param  = "?classId=" + getCommPopClassId() ; 
	param += getURLParam(multi, "conti_cd",     contiCd) ;
	param += getURLParam(multi, "sconti_cd",    scontiCd) ;
	param += getURLParam(multi, "cnt_cd",       cntCd) ;
	param += getURLParam(multi, "loc_state",    locState) ;
	param += getURLParam(multi, "loc_eq_ofc",   locEqOfc) ;
	param += getURLParam(multi, "loc_cd",       locCd) ;
	param += getURLParam(multi, "loc_desc",     locDesc) ;
	param += getURLParam(multi, "loc_port_ind", locPortInd) ;

	ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 770, 470, 'setValFromLocPop', display) ;
}

/**
 * Location 공통 팝업에서 호출하는 함수
 * 
 * @param rowArray 결과값
 */
function setValFromLocPop(rowArray){
	var colArray = null ;
	var gubun    = '';
	
	if(multiChkYN){
		
		for(i=0; i<rowArray.length; i++){
			if(i<rowArray.length-1) gubun = ',';
			else gubun = "" ;
			colArray = rowArray[i];
			setValFromLocArray(colArray, gubun, i)
		}
	}
	else{
		colArray = rowArray[0] ;
		setValFromLocArray(colArray,gubun, 0) ;
	}
	
	sheetObject = null ;
	sheetRow    = 0 ;
	
 }
 
 /**
 * Location 에서 넘어온 값을 field에 세팅
 * 
 * @param colArray 한 row의 column 배열
 * @param gubun 다중선택시 값의 구분
 * @param idx row의 index
 */
function setValFromLocArray(colArray, gubun, idx){
	setValToFld(colArray, contiCdFld,  idx,  5, gubun) ;
	setValToFld(colArray, scontiCdFld, idx,  6, gubun) ;
	setValToFld(colArray, cntCdFld,    idx,  8, gubun) ;
	setValToFld(colArray, locStateFld, idx,  9, gubun) ;
	setValToFld(colArray, locEqOfcFld, idx, 10, gubun) ;
	setValToFld(colArray, locCdFld,    idx,  3, gubun) ;
	setValToFld(colArray, locDescFld,  idx,  4, gubun) ;
}

 /**
 *  Office 공통 팝업 오픈
 * 
 * @param multi multi check 여부
 * @param ofcCd Office Code
 * @param ofcNm Office Name
 * @param callType Call TYpe
 * @param ofcLev Office Level
 * @param ofcPtsCd Parent Office
 */
function openOfcPop(multi, ofcCd, ofcNm, callType, ofcLev, ofcPtsCd){
	var formObj = document.form ;
	var param   = "" ;
	var display = getCommPopDisplay(multi) ;
	
	param  = "?classId=" + getCommPopClassId() ;
	param += getURLParam(multi, "ofc_lev",    ofcLev) ;
	param += getURLParam(multi, "ofc_pts_cd", ofcPtsCd) ;
	param += getURLParam(multi, "ofc_cd",     ofcCd) ;
	param += getURLParam(multi, "ofc_nm",     ofcNm) ;
	param += getURLParam(multi, "CallType",   callType, "2") ;
	
	ComOpenPopup('/opuscntr/COM_ENS_071.do' + param, 770, 450, 'setValFromOfcPop', display) ;
	ofcLevFld   = ofcLev ;
	ofcPtsCdFld = ofcPtsCd ;
	ofcCdFld    = ofcCd ;
	ofcNmFld    = ofcNm ;
	callTypeFld = callType ;
	multiChkYN  = multi ;
}

/**
 *  Office 공통 팝업 오픈(sheet)
 * 
 * @param sheetObj IBSheet Object
 * @param row Row
 * @param multi multi check 여부
 * @param ofcCd Office Code
 * @param ofcNm Office Name
 * @param callType Call TYpe
 * @param ofcLev Office Level
 * @param ofcPtsCd Parent Office
 */
function openOfcPopSheet(sheetObj, row, multi, ofcCd, ofcNm, callType, ofcLev, ofcPtsCd){
	var formObj = document.form ;
	var param   = "" ;
	var display = getCommPopDisplay(multi) ;
	
	ofcLevFld   = ofcLev ;
	ofcPtsCdFld = ofcPtsCd ;
	ofcCdFld    = ofcCd ;
	ofcNmFld    = ofcNm ;
	callTypeFld = callType ;
	multiChkYN  = multi ;
	sheetRow    = row ;	
	sheetObject = sheetObj ;	
	
	param  = "?classId=" + getCommPopClassId() ;
	param += getURLParam(multi, "ofc_lev",    ofcLev) ;
	param += getURLParam(multi, "ofc_pts_cd", ofcPtsCd) ;
	param += getURLParam(multi, "ofc_cd",     ofcCd) ;
	param += getURLParam(multi, "ofc_nm",     ofcNm) ;
	param += getURLParam(multi, "CallType",   callType, "2") ;
	
	ComOpenPopup('/opuscntr/COM_ENS_071.do' + param, 770, 450, 'setValFromOfcPop', display) ;
}


/**
 * Office 공통 팝업에서 호출하는 함수
 * 
 * @param rowArray 결과값
 */
function setValFromOfcPop(rowArray){
	var colArray = null ;
	var gubun    = '';
	
	if(multiChkYN){
		
		for(i=0; i<rowArray.length; i++){
			if(i<rowArray.length-1) gubun = ',';
			else gubun = "" ;
			colArray = rowArray[i];
			setValFromOfcArray(colArray, gubun, i)
		}
	}
	else{
		colArray = rowArray[0] ;
		setValFromOfcArray(colArray,gubun, 0) ;
	}
	
	sheetObject = null ;
	sheetRow    = 0 ;
 }

/**
 * Office 에서 넘어온 값을 field에 세팅
 * 
 * @param colArray 한 row의 column 배열
 * @param gubun 다중선택시 값의 구분
 * @param idx row의 index
 */
 function setValFromOfcArray(colArray, gubun, idx){
	setValToFld(colArray, ofcCdFld, idx, 3, gubun) ;
	setValToFld(colArray, ofcNmFld, idx, 4, gubun) ;
 }
  
/**
 *  Customer 공통 팝업 오픈
 * 
 * @param multi multi check 여부
 * @param custCd Customer Code
 * @param custNm Customer Name
 * @param ofcCd Sales Office
 * @param custSgmt Segmentation
 */
function openCustPop(multi, custCd, custNm, ofcCd, custSgmt){
	var formObj = document.form ;
	var param   = "" ;
	var display = getCommPopDisplay(multi) ;
	
	param  = "?classId=" + getCommPopClassId() ;
	param += getURLParam(multi, "cust_cd", custCd) ;
	param += getURLParam(multi, "cust_nm", custNm) ;
	param += getURLParam(multi, "ofc_cd",  ofcCd) ;
	
	ComOpenPopup('/opuscntr/COM_ENS_041.do' + param, 770, 450, 'setValFromCustPop', display) ;
	custCdFld   = custCd ;
	custNmFld   = custNm ;
	ofcCdFld    = ofcCd ;
	custSgmtFld = custSgmt ;
	multiChkYN  = multi ;
}


/**
 * Customer 공통 팝업에서 호출하는 함수
 * 
 * @param rowArray 결과값
 */
function setValFromCustPop(rowArray){
	var colArray = null ;
	var gubun    = '';
	
	if(multiChkYN){
		
		for(i=0; i<rowArray.length; i++){
			if(i<rowArray.length-1) gubun = ',';
			else gubun = "" ;
			colArray = rowArray[i];
			setValFromCustArray(colArray, gubun, i)
		}
	}
	else{
		colArray = rowArray[0] ;
		setValFromCustArray(colArray,gubun, 0) ;
	}
	
	sheetObject = null ;
	sheetRow    = 0 ;
}

 /**
 * Customer 에서 넘어온 값을 field에 세팅
 * 
 * @param colArray 한 row의 column 배열
 * @param gubun 다중선택시 값의 구분
 * @param idx row의 index
 */
function setValFromCustArray(colArray, gubun, idx){
	setValToFld(colArray, custCdFld,   idx, 3, gubun) ;
	setValToFld(colArray, custNmFld,   idx, 4, gubun) ;
	setValToFld(colArray, custSgmtFld, idx, 5, gubun) ;
	setValToFld(colArray, ofcCdFld,    idx, 9, gubun) ;
}
 
 

/**
 *  vvd 공통 팝업 오픈
 * 
 * @param multi multi check 여부
 * @param custCd Customer Code
 * @param custNm Customer Name
 * @param ofcCd Sales Office
 * @param custSgmt Segmentation
 */
function openVVDPop(multi, vvdCd, sDate, eDate, etdeta, locCd, laneCd, oper){
	var formObj = document.form ;
	var param   = "" ;
	var display = getCommPopDisplay(multi) ;
	
	param  = "?classId=" + getCommPopClassId() ;
	param += getURLParam(multi, "vvd_cd", vvdCd) ;
	param += getURLParam(multi, "sdate", sDate) ;
	param += getURLParam(multi, "edate", eDate) ;
	param += getURLParam(multi, "etdeta", etdeta) ;
	param += getURLParam(multi, "loc_cd", locCd) ;
	param += getURLParam(multi, "lane_cd", laneCd) ;
	param += getURLParam(multi, "oper", oper) ;
	
	ComOpenPopup('/opuscntr/COM_ENS_0B2.do' + param, 770, 470, 'setValFromVVDPop', display) ;
	
	vvdCdFld   = vvdCd ;
	sDateFld   = sDate ;
	eDateFld   = eDate ;
	etdetaFld  = etdeta ;
	locCdFld   = locCd ;
	laneCdFld  = laneCd ;
	operFld    = oper ;
	multiChkYN = multi ;
}

/**
 * vvd 공통 팝업에서 호출하는 함수
 * 
 * @param rowArray 결과값
 */
function setValFromVVDPop(rowArray){
	var colArray = null ;
	var gubun    = '';
	
	if(multiChkYN){
		
		for(i=0; i<rowArray.length; i++){
			if(i<rowArray.length-1) gubun = ',';
			else gubun = "" ;
			colArray = rowArray[i];
			setValFromVVDArray(colArray, gubun, i)
		}
	}
	else{
		colArray = rowArray[0] ;
		setValFromVVDArray(colArray,gubun, 0) ;
	}
	
	sheetObject = null ;
	sheetRow    = 0 ;
}

/**
 * vvd 에서 넘어온 값을 field에 세팅
 * 
 * @param colArray 한 row의 column 배열
 * @param gubun 다중선택시 값의 구분
 * @param idx row의 index
 */
function setValFromVVDArray(colArray, gubun, idx){
	setValToFld(colArray, vvdCdFld,   idx, 7, gubun) ;
	setValToFld(colArray, sDateFld,   idx, 5, gubun) ;
	setValToFld(colArray, eDateFld,   idx, 6, gubun) ;
	setValToFld(colArray, locCdFld,   idx, 4, gubun) ;
	setValToFld(colArray, laneCdFld,  idx, 3, gubun) ;
}
 
/**
 *  node 공통 팝업 오픈
 * 
 * @param multi multi check 여부
 * @param nodeCd Node
 * @param nodeNm Node Name
 * @param cntCd Country
 * @param locCd Location
 * @param ofcCd Control Office
 * @param mode Yard/Zone
 * @param modeOnly Search Yard/Zone Only
 */
function openNodePop(multi, nodeCd, nodeNm, cntCd, locCd, ofcCd, mode, modeOnly){
	var formObj = document.form ;
	var param   = "" ;
	var display = getCommPopDisplay(multi) ;
	
	param  = "?classId=" + getCommPopClassId() ;
	param += getURLParam(multi, "node_cd"  , nodeCd) ;
	param += getURLParam(multi, "node_nm"  , nodeNm) ;
	param += getURLParam(multi, "cnt_cd"   , cntCd) ;
	param += getURLParam(multi, "loc_cd"   , locCd) ;
	param += getURLParam(multi, "ofc_cd"   , ofcCd) ;
	param += getURLParam(multi, "mode"     , mode) ;
	param += getURLParam(multi, "mode_only", modeOnly) ;
	
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 770, 451, 'setValFromNodePop', display) ;
	
	nodeCdFld   = nodeCd ;
	nodeNmFld   = nodeNm ;
	cntCdFld    = cntCd ;
	locCdFld    = locCd ;
	ofcCdFld    = ofcCd ;
	modeFld     = mode ;
	modeOnlyFld = modeOnly ;
	multiChkYN  = multi ;
}


/**
 *  node 공통 팝업 오픈(sheet)
 * 
 * @param sheetObj Sheet Object
 * @param row Row
 * @param multi multi check 여부
 * @param nodeCd Node
 * @param nodeNm Node Name
 * @param cntCd Country
 * @param locCd Location
 * @param ofcCd Control Office
 * @param mode Yard/Zone
 * @param modeOnly Search Yard/Zone Only
 */
function openNodePopSheet(sheetObj, row, multi, nodeCd, nodeNm, cntCd, locCd, ofcCd, mode, modeOnly){
	var formObj = document.form ;
	var param   = "" ;
	var display = getCommPopDisplay(multi) ;
	
	nodeCdFld   = nodeCd ;
	nodeNmFld   = nodeNm ;
	cntCdFld    = cntCd ;
	locCdFld    = locCd ;
	ofcCdFld    = ofcCd ;
	modeFld     = mode ;
	modeOnlyFld = modeOnly ;
	multiChkYN  = multi ;
	sheetObject = sheetObj ;
	sheetRow    = row ;
	
	param  = "?classId=" + getCommPopClassId() ;
	param += getURLParam(multi, "node_cd"  , nodeCd) ;
	param += getURLParam(multi, "node_nm"  , nodeNm) ;
	param += getURLParam(multi, "cnt_cd"   , cntCd) ;
	param += getURLParam(multi, "loc_cd"   , locCd) ;
	param += getURLParam(multi, "ofc_cd"   , ofcCd) ;
	param += getURLParam(multi, "mode"     , mode) ;
	param += getURLParam(multi, "mode_only", modeOnly) ;
	
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 770, 451, 'setValFromNodePop', display) ;
}
 
/**
 * node 공통 팝업에서 호출하는 함수
 * 
 * @param rowArray 결과값
 */
function setValFromNodePop(rowArray){
	var colArray = null ;
	var gubun    = '';
	
	if(multiChkYN){
		
		for(i=0; i<rowArray.length; i++){
			if(i<rowArray.length-1) gubun = ',';
			else gubun = "" ;
			colArray = rowArray[i];
			setValFromNodeArray(colArray, gubun, i)
		}
	}
	else{
		colArray = rowArray[0] ;
		setValFromNodeArray(colArray,gubun, 0) ;
	}
	
	sheetObject = null ;
	sheetRow    = 0 ;
}

/**
 * node 에서 넘어온 값을 field에 세팅
 * 
 * @param colArray 한 row의 column 배열
 * @param gubun 다중선택시 값의 구분
 * @param idx row의 index
 */
function setValFromNodeArray(colArray, gubun, idx){
	setValToFld(colArray, cntCdFld,   idx, 12, gubun) ;
	setValToFld(colArray, locCdFld,   idx, 13, gubun) ;
	setValToFld(colArray, ofcCdFld,   idx,  5, gubun) ;
	setValToFld(colArray, nodeCdFld,  idx,  3, gubun) ;
	setValToFld(colArray, nodeNmFld,  idx,  4, gubun) ;
}



/**
 *  Service Provider 공통 팝업 오픈
 * 
 * @param multi multi check 여부
 * @param ptsVndrCd Parent Service Provider Code
 * @param vndrNmEng Service Provider Name
 * @param cntCd Country
 * @param ofcCd Control Office
 */
function openServiceProviderPop(multi, ptsVndrCd, vndrNmEng, cntCd, ofcCd){
	var formObj = document.form ;
	var param   = "" ;
	var display = getCommPopDisplay(multi) ;
	
	param  = "?classId=" + getCommPopClassId() ;
	param += getURLParam(multi, "pts_vndr_cd", ptsVndrCd) ;
	param += getURLParam(multi, "vndr_nm_eng", vndrNmEng) ;
	param += getURLParam(multi, "cnt_cd"     , cntCd) ;
	param += getURLParam(multi, "ofc_cd"     , ofcCd) ;
	
	ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 620, 451, 'setValFromServiceProviderPop', display) ;
	
	ptsVndrCdFld = ptsVndrCd ;
	vndrNmEngFld = vndrNmEng ;
	cntCdFld     = cntCd ;
	ofcCdFld     = ofcCd ;
	multiChkYN   = multi
}
 
/**
 * Service Provider 공통 팝업에서 호출하는 함수
 * 
 * @param rowArray 결과값
 */
function setValFromServiceProviderPop(rowArray){
	var colArray = null ;
	var gubun    = '';
	
	if(multiChkYN){
		
		for(i=0; i<rowArray.length; i++){
			if(i<rowArray.length-1) gubun = ',';
			else gubun = "" ;
			colArray = rowArray[i];
			setValFromServiceProviderArray(colArray, gubun, i)
		}
	}
	else{
		colArray = rowArray[0] ;
		setValFromServiceProviderArray(colArray,gubun, 0) ;
	}
	
	sheetObject = null ;
	sheetRow    = 0 ;
}

/**
 * Service Provider 에서 넘어온 값을 field에 세팅
 * 
 * @param colArray 한 row의 column 배열
 * @param gubun 다중선택시 값의 구분
 * @param idx row의 index
 */
function setValFromServiceProviderArray(colArray, gubun, idx){
	setValToFld(colArray, cntCdFld,      idx,  5, gubun) ;
	setValToFld(colArray, ofcCdFld,      idx,  3, gubun) ;
	setValToFld(colArray, ptsVndrCdFld,  idx,  7, gubun) ;
	setValToFld(colArray, vndrNmEngFld,  idx,  4, gubun) ;
} 


/**
 *  Staaf 공통 팝업 오픈
 * 
 * @param multi multi check 여부
 * @param userCd User Code
 * @param userNm User Name
 * @param ofcCd Office Code
 */
function openStaffPop(multi, userCd, userNm, ofcCd){
	var formObj = document.form ;
	var param   = "" ;
	var display = getCommPopDisplay(multi) ;
	
	param  = "?classId=" + getCommPopClassId() ;
	param += getURLParam(multi, "user_cd", userCd) ;
	param += getURLParam(multi, "user_nm", userNm) ;
	param += getURLParam(multi, "ofc_cd" , ofcCd) ;
	param += "&f_cmd=2" ;
	
	ComOpenPopup('/opuscntr/COM_ENS_091.do' + param, 770, 580, 'setValFromStaffPop', display) ;
	
	userCdFld  = userCd ;
	userNmFld  = userNm ;
	ofcCdFld   = ofcCd ;
	multiChkYN = multi
}


/**
 *  Staaf 공통 팝업 오픈(sheet)
 * 
 * @param sheetObj IBSheet Object
 * @param row Row
 * @param multi multi check 여부
 * @param userCd User Code
 * @param userNm User Name
 * @param ofcCd Office Code
 */
function openStaffPopSheet(sheetObj, row, multi, userCd, userNm, ofcCd){
	var formObj = document.form ;
	var param   = "" ;
	var display = getCommPopDisplay(multi) ;
	
	userCdFld   = userCd ;
	userNmFld   = userNm ;
	ofcCdFld    = ofcCd ;
	sheetObject = sheetObj ;
	sheetRow    = row ;	
	multiChkYN  = multi
	
	param  = "?classId=" + getCommPopClassId() ;
	param += getURLParam(multi, "user_cd", userCd) ;
	param += getURLParam(multi, "user_nm", userNm) ;
	param += getURLParam(multi, "ofc_cd" , ofcCd) ;
	param += "&f_cmd=2" ;
	
	ComOpenPopup('/opuscntr/COM_ENS_091.do' + param, 770, 580, 'setValFromStaffPop', display) ;

}


 
/**
 * SStaaf 공통 팝업에서 호출하는 함수
 * 
 * @param rowArray 결과값
 */
function setValFromStaffPop(rowArray){
	var colArray = null ;
	var gubun    = '';
	
	if(multiChkYN){
		for(i=0; i<rowArray.length; i++){
			if(i<rowArray.length-1) gubun = ',';
			else gubun = "" ;
			
			colArray = rowArray[i];
			setValFromStaffArray(colArray, gubun, i)
		}
	}
	else{
		colArray = rowArray[0] ;
		setValFromStaffArray(colArray,gubun, 0) ;
	}
	
	sheetObject = null ;
	sheetRow    = 0 ;
}

/**
 * Service Provider 에서 넘어온 값을 field에 세팅
 * 
 * @param colArray 한 row의 column 배열
 * @param gubun 다중선택시 값의 구분
 * @param idx row의 index
 */
function setValFromStaffArray(colArray, gubun, idx){
	setValToFld(colArray, ofcCdFld,   idx,  3, gubun) ;
	setValToFld(colArray, userCdFld,  idx,  4, gubun) ;
	setValToFld(colArray, userNmFld,  idx,  5, gubun) ;
} 

 
/**
 * classId 얻기
 */
function getCommPopClassId(){
	var url = document.location.href ;
	var classId = url.substring(url.lastIndexOf("/")+1, url.lastIndexOf(".do")) ;
	return classId ;
}
  
 
/**
 * display 얻기
 * 
 * @param multi 다중선택 가능 여부
 *              true : 다중선택 가능, false : 불가능
 */
function getCommPopDisplay(multi){
 	var display = multi?'0,1,1,1,1,1,1,1,1,1,1,1':'1,0,1,1,1,1,1,1,1,1,1,1' ;
 	return display ;
}
 
/**
 * field 값 세팅
 * 
 * @param fldNam 명
 * @param colIdx row의 index 
 * @param colIdx column의 index
 * @param gubun 구분   
 */
function setValToFld(colArray, fldNm, rowIdx, colIdx, gubun){
 	var formObj  = document.form ;
 	
 	if(sheetObject==null){
	 	if(formObj[fldNm]!=null){
			if(rowIdx==0){
		    	formObj[fldNm].value = colArray[colIdx] + gubun ;
			}
			else{
				formObj[fldNm].value += colArray[colIdx] + gubun ;
			}
	    	formObj[fldNm].focus() ;
		}
 	}
 	else{
 		if(fldNm!=null){
	 		if(rowIdx==0){
		    	sheetObject.CellValue2(sheetRow,fldNm) = colArray[colIdx] + gubun ;
			}
			else{
				sheetObject.CellValue2(sheetRow,fldNm) = sheetObject.CellValue(sheetRow,fldNm) + 
														 colArray[colIdx] + gubun ;
			}
 		}
 	}
}

 
/**
 * 공통 팝업 URL에 넘길 파마라메터 얻기
 *
 * @param multi mult check 가능 여부
 * @param paramNm 파라메터명
 * @param fldNm 필드명
 * @param defaultVal 값이 없을 경우 default 값
 */
function getURLParam(multi, paramNm, fldNm, defaultVal){
	var formObj  = document.form ;
	var param    = "" ;
	
	if(!multi){
		defaultVal = defaultVal==null?"":defaultVal ;
		
		if(sheetObject==null){
			param = "&" + paramNm + "=" + (fldNm!=null&&formObj[fldNm]!=null?
	                formObj[fldNm].value:defaultVal) ;
		}
		else{
			param = "&" + paramNm + "=" + (fldNm==null || sheetObject.CellValue(sheetRow, fldNm)==null?defaultVal:
										   sheetObject.CellValue(sheetRow, fldNm)) ;
			
		}
	}
	
	return param ;
}


function IBS_Sheet2SheetCheck2(fromSheet, toSheet, chkCol, headerCnt)  { //보내는Sheet, 받는Sheet, column위치, header수
	//함수 인자 유효성 확인
	if (typeof fromSheet != "object" || fromSheet.tagName != "OBJECT") { //"Sheet2SheetCheck 함수의 fromSheet 인자는 IBSheet가 아닙니다."
	    ComShowMessage(getMsg('COM12111'));
		return false; 
	}
	else if (typeof toSheet != "object" || toSheet.tagName != "OBJECT") { //"Sheet2SheetCheck 함수의 toSheet 인자는 IBSheet가 아닙니다."
	    ComShowMessage(getMsg('COM12111'));
	    return false;
	}
	else if (chkCol < 0 || chkCol > fromSheet.LastCol) //"Sheet2SheetCheck 함수의 chkCol 인자는 컬럼 영역 이내가 아닙니다."
	{
	    ComShowMessage(getMsg('COM12111'));
	    return false;
	}
	
	//데이터 행의 개수 확인
	var toRow = toSheet.RowCount;
	fromSheet.Redraw = false;
	toSheet.Redraw = false;

	//원본에서 역순으로 Check 된 데이터를 확인하여 이동
	for (ir = fromSheet.RowCount+(headerCnt-1); ir>= headerCnt; ir--) {
		//Check 되지 않은 경우 건너뜀
		if (fromSheet.CellValue(ir, fromSheet.ColSaveName(chkCol)) == '0') continue;
		//데이터 행 추가
		toRow = toSheet.DataInsert(-1); //마지막 row밑에 붙이는 경우는 -1, 상단은 0, 아니면 toRow
		
		//데이터 옮기기
		for (ic = 0; ic<=fromSheet.LastCol; ic++) { //체크 컬럼은 빼고 옮김
			if (ic == chkCol) {
				if (fromSheet.CellValue(ir, fromSheet.ColSaveName(chkCol)) == '1') {
					fromSheet.RowStatus(ir) = "R";
				}
			} else {
				toSheet.CellValue(toRow, fromSheet.ColSaveName(ic)) = fromSheet.CellValue(ir, fromSheet.ColSaveName(ic));
			}
		}
		//원본에서 지움
		fromSheet.RowDelete(ir, false);
		toRow--;
	}
	toSheet.Redraw = true;
	fromSheet.Redraw = true;
}

/*
 * Node를 비교하기 위해서 만든 function
 * Java의 HashTable과 비슷한 기능을 한다.
 */
var nodeCount = 0;
function objInit() {
	this.nodeObject = new Object();
	this.HPut = HPut;
	this.HGet = HGet;
	this.HDel = HDel;
	nodeCount = 0;
}

function HPut(key, value) {
	obj = this.nodeObject;
	flag = 0;
	for(var n in obj) {
		if(n == key) {
			obj[key] = value;
			flag = 1;
		}
	}
	if(flag == 0) {
		obj[key] = value;
	}
	nodeCount++;
}

function HGet(key) {
	obj = this.nodeObject;
	return obj[key];
}

function HDel(key) {
    this.HPut(key, null);
	nodeCount--;
}

/*
 combo 관련 펑션 및 변수 처리는 모두 comboUtil.js에서..
*/


// 공통으로 사용할 스크립트 소스
/**
 * sep에 해당하는 char를 제거하는 스크립트
 */
function doSepRemove(obj, sep) {
	var ch = "";
	var lvobj = "";
	for(var i=0; i<obj.length; i++) {
		if(obj.charAt(i) == sep) {
			ch = "";
		} else {
			ch = obj.charAt(i);
		}
		lvobj = lvobj + ch;
	}
	return lvobj;
}

/**
 * 날짜에 대한 유효성을 체크.
 */
function doDatecheck(obj) {
	if( obj.length == 8 ) {
		objy = obj.substring(0, 4);
		objm = obj.substring(4, 6);
		objd = obj.substring(6);
	} else {
		return false;
	}
	var lverr = 0; // 에러 변수
	var lvmonday = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
	if( objy%1000 != 0 && objy%4 == 0 )
		lvmonday[1] = 29; //윤년
	if( objd > lvmonday[objm-1] || objd < 1 )
		lverr = 1; //year check
	if( objm < 1 || objm > 12 )
		lverr = 1; //month check
	if( objm%1!=0 || objy%1!=0 || objd%1!=0 ) 
		lverr = 1; //number check
	if( lverr == 1 ) {
		return false;
	} else {
		return true;
	}
}

/**
 * 한글 여부에 대한 유효성을 체크.
 */
function dohancheck(obj) {
	var lveng = /[^a-z|A-Z]/;
	if( lveng.test(obj) ) {
	    ComShowMessage(getMsg('COM12123','This field'));
		return false;
	}
	return true;
}

/**
 * 영문과 숫자에 대한 유효성을 체크.
 */
function doengnumcheck(obj) {
	var lveng = /[^a-z|A-Z|,|0-9|]/;
	if( lveng.test(obj) ) {
		ComShowMessage(getMsg('COM12127','This field'));
		return false;
	}
	return true;
}

/**
 * 날짜에 빼기에 대한 유효성을 체크
 */
function dateCalcuration(objFrom, objTo) {
	var lvfrmDate = doSepRemove(doSepRemove(objFrom, " "), "-");
	var lvtoDate = doSepRemove(doSepRemove(objTo, " "), "-");
	var lvFrom = lvfrmDate.substring(4, 6)+"-"+lvfrmDate.substring(6)+"-"+lvfrmDate.substring(0, 4);
	var lvTo = lvtoDate.substring(4, 6)+"-"+lvtoDate.substring(6)+"-"+lvtoDate.substring(0, 4);
	var fromDay = new Date(lvFrom);
	var toDay = new Date(lvTo);
	var objFT = (toDay.getTime()-fromDay.getTime()) / (24*60*60*1000);
	return objFT;
}

/**
 * 일자에 '-'제거 및 입력하는 함수
 *
 */
function delHypen(obj) { //hypen제거
	var lvobj = doSepRemove(obj.value, "-");
	obj.value = lvobj;
}
function getHypen(obj) { //hypen입력
	if( obj.value.length == 8 ) {
		obj.value = obj.value.substring(0, 4)+"-"+obj.value.substring(4,6)+"-"+obj.value.substring(6);
	}
}


/**
 * 숫자 소수점 2자리...리턴
 *
 */
function myRound(num, pos) { 
	var posV = Math.pow(10, (pos ? pos : 2))
	return Math.round(num*posV)/posV
}


/**
 * 숫자 콤마..
 *
 */
function commaNum(num) { 

	if (num < 0) { num *= -1; var minus = true}
	else var minus = false

	var dotPos = (num+"").split(".")
	var dotU = dotPos[0]
	var dotD = dotPos[1]
	var commaFlag = dotU.length%3

	if(commaFlag) {
	 var out = dotU.substring(0, commaFlag) 
	 if (dotU.length > 3) out += ","
	}
	else var out = ""

	for (var i=commaFlag; i < dotU.length; i+=3) {
	 out += dotU.substring(i, i+3) 
	 if( i < dotU.length-3) out += ","
	}

	if(minus) out = "-" + out
	if(dotD) return out + "." + dotD
	else return out 
}

/**
 * 대문자로 바꾼는 함수.
 */
function setgetUpper(obj) {
	return obj.value = obj.value.toUpperCase()
}

/**
 * 컨테이너 번호 Check Digit 계산 함수.
 */

function cntrCheckDigit(cntrNo){

 if (cntrNo.length != 10){

  return cntrNo;

 } 

 var sum = 0;
 cntrNo = cntrNo.toUpperCase();

 for(var i=0;i<10;i++){

  sum = sum + productValue( cntrNo.charAt(i),i);

 }

 var mod = sum % 11;

 if (mod == 10) mod =0;
 
 if (isNaN(mod)) return cntrNo;

 return cntrNo+mod;

 

}

/**
 * 컨테이너 번호 Check Digit 계산 함수 -product Value 계산 하는 로직을 포함한 메소드
 */
 
function productValue(str,position){

 var strMap = new Array("10","12","13","14","15","16","17","18","19","20","21","23","24","25","26","27","28","29","30","31","32","34","35","36","37","38");

 

 var num = new Number(str);

 if (isNaN(num)){

  var index = new Number(str.charCodeAt(0)-65) ;

  var strNum = strMap[index];


  return strNum * Math.pow(2, position);

 } else {

  return num* Math.pow(2, position);

 }

}

function multiCntrChkDgt(cntrList){
	if(cntrList == undefined || cntrList == '') return cntrList;

	var cntrArray = cntrList.split(',');
	var newCntrList = '';

	for(var i=0; i<cntrArray.length; i++){
		newCntrList += cntrCheckDigit(cntrArray[i]);
		if(i < cntrArray.length-1) newCntrList += ',';
	}
	return newCntrList;
}


jsLEng  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" ;
jsSEng  = "abcdefghijklmnopqrstuvwxyz" ;
jsEng   = jsLEng + jsSEng ;
jsNum   = "0123456789";
jsSChar = "!@#$%^&*()_+=-,./<>?;':\"{}[]" ;

/**
 * 필드 유혀성 체크
 * 
 * @param obj Field Object
 * @param type Check type
 * @param upper 대문자 변환여부
 * @param maxLen 최대길이 
 * @param pchar 허용 문자
 * @param format Format
 */
 
function chkField(obj, type, upper, maxLen, pchar, format){
	switch (type) {
		case "eng_num" :
			chkEngNumObj(obj, upper, maxLen) ;
			break;
		case "eng" :
			chkEngObj(obj, upper, maxLen) ;
			break ;
		case "leng" :
			chkLEngObj(obj, upper, maxLen) ;
			break ;
		case "seng" :
			chkSEngObj(obj, upper, maxLen) ;
			break ;
		case "num" :
			chkNumObj(obj, maxLen, format) ;
			break ;
		case "custmoer" :
			chkCharObj(obj, pchar, upper, maxLen) ;
			break ;
		case "date" :
			dateFormatObj(obj, format) ;
		default:
			break;
	}
}

function chkEngObj(obj, upper, maxLen){
	chkCharObj(obj, jsEng, upper, maxLen) ;
}

function chkLEngObj(obj, upper, maxLen){
	chkCharObj(obj, jsLEng, upper, maxLen) ;
}

function chkSEngObj(obj, upper, maxLen){
	chkCharObj(obj, jsSEng, upper, maxLen) ;
}

function chkEngNumObj(obj, upper, maxLen){
	chkCharObj(obj, jsEng+jsNum, upper, maxLen) ;
}

function chkNumObj(obj, upper, maxLen){
	chkCharObj(obj, jsNum, upper, maxLen) ;
}

function chkCharObj(obj, pchar, upper, maxLen){
	obj.value = chkCharValue(obj.value, pchar, upper, maxLen) ;
}

function chkCharValue(value, pchar, upper, maxLen){
	var newValue = "" ;
	var oneChar  = null ;
	
	for(i=0;i<value.length; i++){
		oneChar = value.charAt(i) ;
		if(pchar.indexOf(oneChar)!=-1 && (maxLen==null || newValue.length<maxLen)){
			newValue += oneChar ;
		}
	}
	
	newValue = upper ? newValue.toUpperCase() : newValue ;
	
	return newValue ;
}

function dateFormatObj(obj, format){
	var value = obj.value ;
	obj.value = dateFormatValue(value, format)
}

function dateFormatValue(value, format) {
	var oldValue = chkCharValue(value, jsNum, false) ;
	var newValue = "" ;
	var chkValue = "" ;
	var oneChar  = null ;
	var maxLen   = 8 + (format.length*2)
	
	for(i=0; i<oldValue.length; i++){
		oneChar = oldValue.charAt(i) ;
		
		if(newValue.length<maxLen){
			if(i==4){
				if(oneChar>1){
					newValue = newValue + format + "0" + oneChar ;
				}
				else{
					newValue = newValue + format + oneChar ;
				}
			}
			else if(i==6){
				if(oneChar>3){
					newValue = newValue + format + "0" + oneChar ;
				}
				else{
					newValue = newValue + format + oneChar ;
				}
			}
			else {
				newValue += oneChar ;
			}
		}
	}
	
	chkValue = oldValue.substring(0,8) ;
	if(!chkDateValue(chkValue)){
		newValue = newValue.substring(0, newValue.length-1) ;
	}
		
	return newValue ;
}


function chkDateValue(value){
	var yyyy = value.substring(0,4) ;
	var mm   = value.substring(4,6) ;
	var dd   = value.substring(6) ;
	
	var daysInMonth = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31) ;
	
	// 월체크
	if(mm>12) {
		return false ;
	}
	
	// 윤달
	if(mm==2){
		daysInMonth[1] = yyyy%400==0 || ((yyyy%4==0) && (yyyy%100!=0)) ? 29 : 28 ; 
	}

	// 일체크
	if(dd!="" && mm!="" && dd>daysInMonth[mm-1]){
		return false ;
	}
	
	return true ;
}

function chkMonthValue(value){
	var yyyy = value.substring(0,4) ;
	var mm   = value.substring(4,6) ;
	
	// 월체크
	if(mm>12) {
		return false ;
	}
	
	return true ;
}


function chkLenth(obj, len, msg) {
	var result = true ;
	
	if( getLenByByte(obj.value)!==len ) {
		ComShowMessage(getMsg('EAS90002', msg, len));
		obj.focus();
		result = false;
	}
	return result ;
}


function chkLenthOver(obj, len, msg) {
	var result = true;
	if( getLenByByte(obj.value)<len ) {
		ComShowMessage(getMsg('COM12143', msg, len));
		obj.focus();
		result = false;
	}
	return result;
}

