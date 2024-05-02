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
 *  vvd 공통 팝업 오픈
 *
 * @param multi multi check 여부
 * @param custCd Customer Code
 * @param custNm Customer Name
 * @param ofcCd Sales Office
 * @param custSgmt Segmentation
 */
function openVVDPopUp(multi, vvdCd, sDate, eDate, etdeta, locCd, laneCd, oper){
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

	ComOpenPopup('ESD_SCE_0103.do' + param, 800, 430, 'setValFromVVDPop', display) ;

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
	/**
	setValToFld(colArray, cntCdFld,      idx,  5, gubun) ;
	setValToFld(colArray, ofcCdFld,      idx,  3, gubun) ;
	setValToFld(colArray, ptsVndrCdFld,  idx,  7, gubun) ;
	setValToFld(colArray, vndrNmEngFld,  idx,  4, gubun) ;
*/
	setValToFld(colArray, cntCdFld,      idx,  7, gubun) ;
	setValToFld(colArray, ofcCdFld,      idx,  3, gubun) ;
	setValToFld(colArray, ptsVndrCdFld,  idx,  2, gubun) ;
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
	
	//alert(ofcCd);
	var formObj = document.form ;
	var param   = "" ;
	var display = getCommPopDisplay(multi) ;

	param  = "?classId=" + getCommPopClassId() ;
	param += getURLParam(multi, "user_cd", userCd) ;
	param += getURLParam(multi, "user_nm", userNm) ;
	param += getURLParam(multi, "ofc_cd" , ofcCd) ;
	param += "&f_cmd=2" ;

//alert(param);

	ComOpenPopup('/opuscntr/COM_ENS_091.do' + param, 770, 580, 'setValFromStaffPop', display) ;
//comPopupWith2ndSheet('/opuscntr/COM_ENS_091.do' + param, 770, 580, 'setValFromStaffPop', display) ;
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
			// setValFromStaffArray 함수 중복(ESD_SCE_0102.js에도 존재) 일단 ESD_SCE_0102.js 함수를 setValFromStaffArray_new로 변경하고 호출
			setValFromStaffArray_new(colArray, gubun, i)
			//setValFromStaffArray(colArray, gubun, i)
		}
	}
	else{
		colArray = rowArray[0] ;
		// setValFromStaffArray 함수 중복(ESD_SCE_0102.js에도 존재) 일단 ESD_SCE_0102.js 함수를 setValFromStaffArray_new로 변경하고 호출
		setValFromStaffArray_new(colArray, gubun, i)
		//setValFromStaffArray(colArray,gubun, 0) ;
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
 	//alert(fldNm);
 	if(sheetObject==null){
	 	if(formObj[fldNm]!=null){
			if(rowIdx==0){
				//alert(fldNm);
		    	formObj[fldNm].value = colArray[colIdx] + gubun ;
			}
			else{
				//alert(fldNm);
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