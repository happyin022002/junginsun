/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CoSce.js
 * *@FileTitle : Common JavaScript for Joint Operation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.17
 *@LastModifier : 신한성
 *@LastVersion : 1.0
 * 2009.07.17 최초 생성
 * 1.0 Creation
 * -------------------------------------------------------
 * history
 * 2010.12.15 김영철 [CHM-201007731-01] IRG상 BKG&Temp Flag 적용방법 변경 관련하여, Alert Message 처리 요청사항.
=========================================================*/

	// SCE 관련 message
    msgs['SCE90001'] = 'When you enter VVD, you must enter one among POR, POL, POD and DEL.' ;
	msgs['SCE90002'] = 'When you enter POR, POL, POD, DEL, you must enter between VVD or BKG Date.' ;
	msgs['SCE90003'] = '{?msg1}.\n\n Please enter correct date.\n\n Format : YYYY-MM-DD';
	msgs['SCE90004'] = 'Please select between Estimated Date/Time and Actual Date/Time.';
	msgs['SCE90005'] = 'Updated properly.';
	msgs['SCE90006'] = 'Updated not properly.';
	msgs['SCE90007'] = 'Selected BKG No. and BKG No. Split do not match.';
	msgs['SCE90008'] = 'There is no Activity with changed time date.';
	msgs['SCE90009'] = 'You can change only one time data of Activity.';
	msgs['SCE90010'] = 'Please select same {?msg1}.';
	msgs['SCE90011'] = 'You can do a batch update of only the COP status is Created or In-Transit only.';
	msgs['SCE90012'] = 'You can do Mode Change of the COP Whose Status is In-Transit only.' ;
	msgs['SCE90013'] = 'COP Mode has been Changed successfully.' ;
	msgs['SCE90014'] = 'Please enter VVD/Router, BKG Date and DEL Due Date.' ;
	msgs['SCE90015'] = 'Please enter VVD and one among POR, POL, POD and DEL.' ;
	msgs['SCE90016'] = 'Please enter search options.' ;
	msgs['SCE90017'] = 'There is no container No of Exception No.' ;
	msgs['SCE90018'] = 'There is no data to search.' ;
	msgs['SCE90019'] = 'You can not add any more.' ;
	msgs['SCE90020'] = 'Resolved Exception can not update batch.\n\n [{?msg1} line]' ;
	msgs['SCE90021'] = 'Please select between{?msg1}and{?msg2}.' ;
	msgs['SCE90022'] = 'The Effective Date To of {?msg1} can not have more than 2 null values.' ;
	msgs['SCE90023'] = 'Please select EDI Customer Group.' ;
	msgs['SCE90024'] = 'Please select one of followings : VVD, BKG NO, CNTR NO or BL NO.' ;
	msgs['SCE90025'] = 'POD is mandatory item when you select VVD.' ;
	msgs['SCE90026'] = 'Please enter {?msg1} as {?msg2} characters long.' ;
	msgs['SCE90027'] = 'Below COP was not updated properly.\n\n {?msg1}' ;
	msgs['SCE90028'] = 'There is no Customer for {?msg1}.';
	msgs['SCE90029'] = 'You can not enter {?msg2} on {?msg1}.' ;
	msgs['SCE90030'] = 'Please enter date, BKG, B/L, container and VVD.' ;
	msgs['SCE90031'] = 'Please enter one more {?msg1} to search.' ;
	msgs['SCE90032'] = '{?msg1} Format is not correct.' ;
	msgs['SCE90033'] = 'When you enter {?msg1} you must enter {?msg2}.';
	msgs['SCE90034'] = 'Please enter between {?msg1} and {?msg2}.';
	msgs['SCE90035'] = 'VVD is 9 characters long.';
	msgs['SCE90036'] = 'Start date is later than {?msg1}.';
	msgs['SCE90037'] = '{?msg1} is not exist.';
	msgs['SCE90038'] = 'Do you want to the Manual Close?' ;
	msgs['SCE90039'] = 'Node is 7 characters long.';
	msgs['SCE90040'] = 'Location is 5 characters long.';
	msgs['SCE90041'] = 'Maximum Minute is 59.';
	msgs['SCE90045'] = 'VVD is mandatory item.' ;
	msgs['SCE90046'] = 'Selection will be canceled because Booking number of selected value is not coinside.';
	msgs['SCE90047'] = "This COP already canceled, You can not replan cop data"	
	msgs['SCE90048'] = "Input location is not same as original location. Do you want to continue?"
	msgs['SCE90049'] = "The selected route have 'Temp Flag'.\n which should be applied to a special case.\n Do you really want to change this route?"
	msgs['SCE90050'] = "'{?msg1}' should be later than '{?msg2}'";
	msgs['SCE90051'] = "At the least one dwell type should be selected.";
	msgs['SCE90052'] = "E-mail is invalid {?msg1}. Please check it again.";
	msgs['SCE90053'] = "Data was changed. Do you want to close the window without save ?";
	msgs['SCE90054'] = "Data was changed. Do you want to cancel change?";
	msgs['SCE90055'] = "Period Date can not be earlier than Today";
    msgs['SCE90056'] = "At least one dwell type should be selected";
    msgs['SCE90057'] = "'Remark' is the mandatory item";
    msgs['SCE90058'] = "Saving has been completed.";
	msgs['SCE90059'] = "There are remaining data not being displayed, if all rows exceed 2,000.\nPlease use Down Excel button on the top right side of this screen to get them all.";
	msgs['SCE90060'] = "In view of the data processing time, inquiry period will be limited to three month.";
	msgs['SCE90061'] = "Please input the 'W/O Office'!!";
	msgs['SCE90062'] = "You can inquire the 'Office Help' popup for one office code at a time.";
	msgs['SCE90063'] = "You can do S/O Status Change of the COP Whose Status is 'S/O Deleted' or 'Candidate Deleted'.";
	msgs['SCE90064'] = "Please enter one of followings : VVD, B/L No. and Container No.";
	
	/**##################함대성 START##################**/
	msgs['SCE01221'] = 'Please check {?msg1} again.' ;
	msgs['SCE01222'] = "There is no data to save.";
	msgs['SCE01223'] = "Plese select {?msg1}";
	
	/**#################신한성 START##################**/
	msgs['SCE02001'] = 'Please enter Orgin In-Gate On Sheet.';
	msgs['SCE02002'] = '{?msg1}';
	msgs['SCE02003'] = 'Please check the inputted node.' ;
	msgs['SCE02004'] = 'The inquiry period is limited to 1 year.' ;
	msgs['SCE02005'] = 'Please select one route at least.' ;
	msgs['SCE02006'] = 'It will be delete all data in sheet \n\nDo you really want to change it?' ;
	     
	function containsSheetCombo(name, value){
	    var data = null;
	    eval("data = getSheetCombo_"+name+"()");
	    if(data == null) return false;
	    var data = "|"+data[0]+"|";
	    return (data.indexOf("|"+value+"|") >= 0);
	}
	/**##################함대성 END####################**/
	
/** WEB_MAIN\apps\alps\esd\sce\common\commonpopup\script\common_popup.js 부분 시작 */
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
		param += getURLParam(multi, "sysCode",      sysCode, "ENIS") ;
		
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
		
		ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'setValFromLocPop', display, true) ;
		
	}

	/**
	 *  LOC(ROR/POL/POD/EDL) 팝업 오픈 &&&
	 *
	 * @param multi multi check 여부
	 * @param custCd Customer Code
	 * @param custNm Customer Name
	 * @param ofcCd Sales Office
	 * @param custSgmt Segmentation
	 * 2008.6.24 LOC(ROR/POL/POD/EDL)팝업창 추가
	 */
	function openLocPopUp(multi, locCd, locDesc, contiCd, scontiCd, cntCd,
	                    locState, locEqOfc, locPortInd, sysCode){
//		alert(multi);
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
		param += getURLParam(multi, "sysCode",      sysCode, "ENIS") ;
		multiChkYN    = multi
//		alert(param);
		contiCdFld    = contiCd ;
		scontiCdFld   = scontiCd ;
		cntCdFld      = cntCd ;
		locStateFld   = locState ;
		locEqOfcFld   = locEqOfc ;
		locCdFld      = locCd ;
		locDescFld    = locDesc ;
		locPortIndFld = locPortInd ;
		sysCodeFld    = sysCode ;
		ComOpenPopup('ESD_SCE_0109.do' + param, 800, 470, 'setValFromLocPop', display, true) ;
		
		
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
		param += getURLParam(multi, "sysCode",      sysCode, "ENIS") ;

		ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'setValFromLocPop', display, true) ;
	}

	/**
	 * Location 공통 팝업에서 호출하는 함수
	 *
	 * @param rowArray 결과값
	 */
	function setValFromLocPop(rowArray){
		var colArray = null ;
		var gubun    = '';
//alert(rowArray.length);
//		alert(multichkyn=""+multiChkYN)
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

		ofcLevFld   = ofcLev ;
		ofcPtsCdFld = ofcPtsCd ;
		ofcCdFld    = ofcCd ;
		ofcNmFld    = ofcNm ;
		callTypeFld = callType ;
		multiChkYN  = multi ;
		ComOpenPopup('/hanjin/COM_ENS_071.do' + param, 770, 450, 'setValFromOfcPop', display, true) ;
		
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

		ComOpenPopup('/hanjin/COM_ENS_071.do' + param, 770, 450, 'setValFromOfcPop', display, true) ;
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

		custCdFld   = custCd ;
		custNmFld   = custNm ;
		ofcCdFld    = ofcCd ;
		custSgmtFld = custSgmt ;
		multiChkYN  = multi ;
		ComOpenPopup('/hanjin/COM_ENS_041.do' + param, 770, 450, 'setValFromCustPop', display, true) ;
		
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

		vvdCdFld   = vvdCd ;
		sDateFld   = sDate ;
		eDateFld   = eDate ;
		etdetaFld  = etdeta ;
		locCdFld   = locCd ;
		laneCdFld  = laneCd ;
		operFld    = oper ;
		multiChkYN = multi ;
		
		ComOpenPopup('/hanjin/COM_ENS_0B2.do' + param, 770, 470, 'setValFromVVDPop', display, true) ;

		
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

//		ComOpenPopup('ESD_SCE_0103.do' + param, 800, 430, 'setValFromVVDPop', display) ;
		var newWin = window.showModalDialog("ESD_SCE_0103.do"+ param, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:430px");
		
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

		nodeCdFld   = nodeCd ;
		nodeNmFld   = nodeNm ;
		cntCdFld    = cntCd ;
		locCdFld    = locCd ;
		ofcCdFld    = ofcCd ;
		modeFld     = mode ;
		modeOnlyFld = modeOnly ;
		multiChkYN  = multi ;
		
		ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 451, 'setValFromNodePop', display, true) ;

		
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

		ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 451, 'setValFromNodePop', display, true) ;
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

		ptsVndrCdFld = ptsVndrCd ;
		vndrNmEngFld = vndrNmEng ;
		cntCdFld     = cntCd ;
		ofcCdFld     = ofcCd ;
		multiChkYN   = multi
		
		ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 620, 451, 'setValFromServiceProviderPop', display, true) ;

		
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
		userCdFld  = userCd ;
		userNmFld  = userNm ;
		ofcCdFld   = ofcCd ;
		multiChkYN = multi
		ComOpenPopup('/hanjin/COM_ENS_091.do' + param, 770, 580, 'setValFromStaffPop', display, true) ;
	//comPopupWith2ndSheet('/hanjin/COM_ENS_091.do' + param, 770, 580, 'setValFromStaffPop', display) ;
		
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

		ComOpenPopup('/hanjin/COM_ENS_091.do' + param, 770, 580, 'setValFromStaffPop', display, true) ;

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
//			setValFromStaffArray_new(colArray, gubun, )
			setValFromStaffArray(colArray,gubun, 0) ;
		}

		sheetObject = null ;
		sheetRow    = 0 ;
	}

	/**
	 * Staff Inquiry 에서 넘어온 값을 field에 세팅
	 *
	 * @param colArray 한 row의 column 배열
	 * @param gubun 다중선택시 값의 구분
	 * @param idx row의 index
	 * 
	 * 2010.03.15 ESD_SCE_0028.js 으로 위치 변경
	 *  
	 */
//	function setValFromStaffArray(colArray, gubun, idx){
//		alert("ofcCdFld = " + ofcCdFld);
//		alert("userCdFld = " + userCdFld);
//		alert("userNmFld = " + userNmFld);
//		setValToFld(colArray, ofcCdFld,   idx,  3, gubun) ;
//		setValToFld(colArray, userCdFld,  idx,  4, gubun) ;
//		setValToFld(colArray, userNmFld,  idx,  5, gubun) ;
//	}



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
//	 	alert(fldNm);
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
/** WEB_MAIN\apps\alps\esd\sce\common\commonpopup\script\common_popup.js 부분 종료 */
	
/** WEB_MAIN\apps\alps\esd\sce\common\util\script\key_validation.js 부분 시작 */
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

	/**
	 * 컨테이너 번호 Check Digit 계산 함수.
	 */

	function cntrCheckDigit(obj){
	   var cntrNo = obj.value;
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
	
	/**
	 * Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩하지 않는다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     var sCondParam=SceFrmQryString(document.frmSearch); //결과:"txtname=이경희&rdoYn=1&sltMoney=원화";
	 * </pre>
	 * @param {form} form Form 오브젝트
	 * @return string
	 * @version 1.0.0.0
	 * @see #SceFrmQryStringEnc
	 */
	function SceFrmQryString(form) {

	    if (typeof form != "object" || form.tagName != "FORM") {
	        alert("Error : Please contact the administrator\n" + "Detail : Parameter of SceFrmQryString Function is not a FORM Tag.");
	        return "";
	    }

	    var name = new Array(form.elements.length);
	    var value = new Array(form.elements.length);
	    var j = 0;
	    var plain_text="";

	    //사용가능한 컨트롤을 배열로 생성한다.
	    len = form.elements.length;
	    for (i = 0; i < len; i++) {
	      //클래스 아이디로 제품을 구분함-아래는 HTMl제품
	      if(form.elements[i].classid==undefined){
	    	  //전송전에 폼의 마스크를 제거한다.
//	    	  ComClearSeparator(form.elements[i]);
	      switch (form.elements[i].type) {
	        case "button":
	        case "reset":
	        case "submit":
	          break;
	        case "radio":
	        case "checkbox":
	                    if (form.elements[i].checked == true) {
	                        name[j] = form.elements[i].name;
	                        value[j] = form.elements[i].value;
	                        j++;
	                    }
	                    break;
	            case "select-one":
	                    name[j] = form.elements[i].name;
	                    var ind = form.elements[i].selectedIndex;
	                    if(ind >= 0) {
	                        if (form.elements[i].options[ind].value != '')
	                            value[j] = form.elements[i].options[ind].value;
	                        else
	                            value[j] = '';
	                    } else {
	                        value[j] = "";
	                    }
	                    j++;
	                    break;
	            case "select-multiple":
	                    name[j] = form.elements[i].name;
	                    var llen = form.elements[i].length;
	                    var increased = 0;
	                    for( k = 0; k < llen; k++) {
	                        if (form.elements[i].options[k].selected) {
	                            name[j] = form.elements[i].name;
	                            if (form.elements[i].options[k].value != '')
	                                value[j] = form.elements[i].options[k].value;
	                            else
	                                value[j] = '';
	                            j++;
	                            increased++;
	                        }
	                    }
	                    if(increased > 0) {
	                        j--;
	                    } else {
	                        value[j] = "";
	                    }
	                    j++;
	                    break;
	                default :
	                    if(form.elements[i].value.length >0 ) {
	                    	name[j] = form.elements[i].name;
	                    	value[j] = form.elements[i].value;
	                    	
	                    	j++;
	                    }
	        }
		  	//전송후에 폼의 마스크를 다시 셋팅한다.
//	      ComAddSeparator(form.elements[i]);
	    //IB에서 제공하는 컨트롤의 값을 조합한다.
	    }else{
	      switch(form.elements[i].classid){
	        case "CLSID:BFED6FBB-30E3-4402-B5D6-C31F40B56A0E":  // IBMaskEdit 경우
	          name[j] = form.elements[i].name==""?form.elements[i].id:form.elements[i].name;
	                value[j] = form.elements[i].Value;
	                j++;
	          break;
	        case CLSID_IBMCOMBO: // IBMultiCombo 경우
	          name[j] = form.elements[i].name==""?form.elements[i].id:form.elements[i].name;
	          		if(form.elements[i].UseCode)
	          			value[j] = form.elements[i].Code;
	          		else
	          			value[j] = form.elements[i].Text;
	                j++;
	                break;
	      }
	    }
	    }

	    // QueryString을 조합한다.
	    //   1) Explorer 5.5 이상일 경우, encodeURIComponent() 를 이용하여 URL Encode
	    //   2) 기타 경우는 IB Sheet 를 이용하여 URL Encode
	    var webBrowserName = navigator.appName;
	    var webBrowserVer  = navigator.appVersion.substring(navigator.appVersion.indexOf("MSIE") + 5,
	                                                        navigator.appVersion.indexOf("MSIE") + 8)

	    if(webBrowserName == "Microsoft Internet Explorer" && webBrowserVer >= 5.5) {
	        for (i = 0; i < j; i++) {
	            // if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
	            if (name[i] != '') plain_text += name[i]+ "=" + encodeURIComponent(value[i]) + "&";
	        }
	    } else {
	        var tmpUrlEncodeSheet    = document.getElementById("SceFrmQryString");

	        if( tmpUrlEncodeSheet == undefined || tmpUrlEncodeSheet == null || tmpUrlEncodeSheet == '')
	        {
	            //인코딩을 위해 숨겨진IBSheet를 만든다.
	            var sTag = ComGetSheetObjectTag("SceFrmQryString");
	            form.insertAdjacentHTML('afterEnd', sTag);
	        }

	        for (i = 0; i < j; i++) {
	            // if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
	            if (name[i] != '') plain_text += name[i]+ "=" + SceFrmQryString.UrlEncoding(value[i]) + "&";
	        }
	    }


	  //마지막에 &를 없애기 위함
	  if (plain_text != "")
	    plain_text = plain_text.substr(0, plain_text.length -1);
	    return plain_text;
	}
	/** WEB_MAIN\apps\alps\esd\sce\common\util\script\key_validation.js 부분 종료 */

	/**
	 * Sheet의 column name으로 index를 구한다.
	 * @author Park, Man-geon
	 * @param sheetObj
	 * @param colName
	 * @return int col
	 */ 
	function coSceSaveNameCol(sheetObj, colName) {
		if (sheetObj == undefined || sheetObj == null) return -1;
 		if (colName == '' || colName == undefined) return -1;
 		var maxIdx = sheetObj.LastCol ;
 		var col = -1;
 		for (var i = 0; i <= maxIdx; i ++) {
 			if (sheetObj.ColSaveName(i) == colName) {
 				col = i;
 				break;
 			}
 		}
 		return col;
	}
	
	
    /**
     * 키보드가 눌릴 때 dataformat으로 세팅하고 엔터키를 누를때 조회한다.
     * @author  김민정
     */
    function obj_KeyPress(){
     var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
     var srcName = event.srcElement.getAttribute("name");
     var srcValue = event.srcElement.getAttribute("value");

     switch(event.srcElement.dataformat) {
         case "ymd":
       	  ComKeyOnlyNumber(event.srcElement);
       	  if (srcValue.length == 4) {
       		  document.form.elements[srcName].value = srcValue.substring(0,4) + "-"
       	  }
       	  if (srcValue.length > 4 && srcValue.indexOf('-') < 0) {
       		  return;
       	  }
       	  if (srcValue.length == 7) {
       		  document.form.elements[srcName].value = srcValue.substring(0,7) + "-"
       	  }
             break;
         case "ymdhm":
       	  ComKeyOnlyNumber(event.srcElement);
       	  if (srcValue.length == 4) {
       		  document.form.elements[srcName].value = srcValue.substring(0,4) + "-"
       	  }
       	  if (srcValue.length == 7) {
       		  document.form.elements[srcName].value = srcValue.substring(0,7) + "-"
       	  }
       	  if (srcValue.length == 10) {
       		  document.form.elements[srcName].value = srcValue.substring(0,10) + " "
       	  }
       	  if (srcValue.length == 13) {
       		  document.form.elements[srcName].value = srcValue.substring(0,13) + ":"
       	  }
             break;
         case "ym":
             ComKeyOnlyNumber(event.srcElement);
             if (srcValue.length == 4) {
               document.form.elements[srcName].value = srcValue.substring(0,4) + "-"
             }
             break;
         case "yw":
         case "jumin":
         case "saupja":  //숫자 + "-"
             ComKeyOnlyNumber(event.srcElement, "-"); break;
         case "hms":
             ComKeyOnlyNumber(event.srcElement, ":");
             if (srcValue.length == 2) {
           	  document.form.elements[srcName].value = srcValue.substring(0,2) + ":"
             }
             if (srcValue.length == 5) {
           	  document.form.elements[srcName].value = srcValue.substring(0,5) + ":"
             }
             break;
         case "hm":    //숫자 + ":"
             ComKeyOnlyNumber(event.srcElement, ":");
             if (srcValue.length == 2) {
           	  document.form.elements[srcName].value = srcValue.substring(0,2) + ":"
             }
             break;
         case "yy":    //숫자 + "0"
             ComKeyOnlyNumber(event.srcElement, "0"); break;
         case "int":    //숫자
             ComKeyOnlyNumber(event.srcElement);  break;
         case "float":  //숫자+"."
             ComKeyOnlyNumber(event.srcElement, "."); break;
         case "signedfloat":  //숫자+".-"
           ComKeyOnlyNumber(event.srcElement, ".-"); break;
         case "commafloat":  //숫자+",-"
               ComKeyOnlyNumber(event.srcElement, ",-"); break;
         case "dashfloat":  //숫자+",-"
           ComKeyOnlyNumber(event.srcElement, "-"); break;
         case "eng":    //영문 + 숫자
           // 영문은 기본 대문자로 한다.(포멧에 대소문자 구분 + 숫자가 없음)
             ComKeyOnlyAlphabet('uppernum'); break;
         case "engup":  //영문대문자
             ComKeyOnlyAlphabet('upper'); break;
         case "engdn":  //영문소문자
             ComKeyOnlyAlphabet('upper'); break;
         case "engupnum"://숫자+"영문대분자"입력하기
         	  ComKeyOnlyAlphabet('uppernum'); break;
         case "engnum"://숫자+"영문대소"입력하기
     	  	  ComKeyOnlyAlphabet('num'); break;
         case "engupspace": //영문대문자 + Space
             if(event.keyCode != 32) {
                 ComKeyOnlyAlphabet('uppernum');
             }
         case "engupspace2": //영문대문자 + Space
	          if(event.keyCode != 32) {
	        	  ComKeyOnlyAlphabet('upper');
	          }
             break;
         case "engupspecial": // 영문대문자 + Space + &-,.
             ComKeyOnlyAlphabet('uppernum', "32|38|45|44|46");
             break;
         case "etc": //모든 문자 가능하지만 영문은 대문자로
             if(keyValue >= 97 && keyValue <= 122) {//소문자
                 event.keyCode = keyValue + 65 - 97;
             }
         	  break;
         default:     //영문 + 숫자
             ComKeyOnlyAlphabet('uppernum'); break;
       }
   }
     
    /**
     * 날짜 From To 에대한 개월수를 초과하는지 검사하여 From + months >= To일 경우 false를 반대의 경우 True를 return 한다.
     * @author 박만건
     * @param fromDate 시작일
     * @param toDate 종료일
     * @param months 검사할 최대개월수
     * @param formatStr 날짜 포멧 문자
     * @return boolean
     * @version 2009.07.02
     */
    function sceMonthsBetweenCheck(fromDate, toDate, months, formatStr){
        var fmtStr = "";
        if (formatStr == null || formatStr == "") {
            fmtStr = "-";
        } else {
            fmtStr = formatStr;
        }
        var ufFromDate = fromDate.replace(eval("/" + fmtStr + "/gi"), "");
        var ufToDate = toDate.replace(eval("/" + fmtStr + "/gi"), "");

        var fYear  = parseInt(ufFromDate.substring(0,4));
        var fMonth = ufFromDate.substring(4,5)=="0"?parseInt(ufFromDate.substring(5,6))-1:parseInt(ufFromDate.substring(4,6))-1;
        var fDay   = ufFromDate.substring(6,7)=="0"?parseInt(ufFromDate.substring(7,8)):parseInt(ufFromDate.substring(6,8));

        var tYear  = parseInt(ufToDate.substring(0,4));
        var tMonth = ufToDate.substring(4,5)=="0"?parseInt(ufToDate.substring(5,6))-1:parseInt(ufToDate.substring(4,6))-1;
        var tDay   = ufToDate.substring(6,7)=="0"?parseInt(ufToDate.substring(7,8)):parseInt(ufToDate.substring(6,8));

        var bLastDay = false;
        var iLastDay = ComGetLastDay(fYear, fMonth +1);
        if (iLastDay == fDay) { bLastDay = true; }

        // 월처리
        for (var i = 0; i< months; i++ ) {
            fMonth = fMonth + 1;
            if (fMonth > 11) {
                fYear = fYear + 1;
                fMonth = 0;
            }
        }

        // 말일이면 변경된 월의 말일을 가져온다.
        if(bLastDay) {
            fDay = ComGetLastDay(tYear, tMonth +1);;
        }

        var dAddedDate =new Date("" + fYear, "" + fMonth, "" + fDay);
        var dToDate = new Date("" + tYear, "" + tMonth , "" + tDay);

        diffDay = ( dAddedDate - dToDate) /(1000*3600*24);
        if ( diffDay > 0) {
            return true;
        }
        return false;
    }
    
    /**
     * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
     * IBMultiCombo의 item으로 insert 해준다.<br>
     * <b>Example :</b>
     *
     * <pre>
     * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
     * var arrData = ComPriXml2ComboItem(xmlStr, combo1, &quot;cd&quot;, &quot;nm&quot;);
     *
     * </pre>
     *
     * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
     * @param {object} cmbObj 필수, insert하고자 하는 IBMultiCombo Object.
     * @param {string} codeCol 필수, Combo의 Code컬럼명.
     * @param {string} textCol 필수, Combo의 Text컬럼명. 다수일 경우 '|' 로 연결
     * @param {boolean} bClear 선택, Combo의 기존 내용을 Clear할지 여부(combo.RemoveAll()). 기본값=true.
     * @return 없음.
      * @author 박성수
      * @version 2009.04.22
     */
    function ComSceXml2ComboItem(xmlStr, cmbObj, codeCol, textCol, bClear) {
        if (xmlStr == null || xmlStr == "" || cmbObj == null || cmbObj == "") {
            return;
        }
        if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
            return;
        }

        try {
            if (bClear != false) {
                cmbObj.RemoveAll();
            }

            var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
            xmlDoc.loadXML(xmlStr);

            var xmlRoot = xmlDoc.documentElement;
            if (xmlRoot == null) {
                return;
            }

            var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
            if (dataNode == null || dataNode.attributes.length < 3) {
                return;
            }

            var col = dataNode.getAttribute("COLORDER");
            var colArr = col.split("|");
            var sep = dataNode.getAttribute("COLSEPARATOR");
            var total = dataNode.getAttribute("TOTAL");

            var dataChildNodes = dataNode.childNodes;
            if (dataChildNodes == null) {
                return;
            }

            var colListIdx = Array();
            var arrText = textCol.split("|");
            for (var i = 0; i < colArr.length; i++) {
                if (colArr[i] == codeCol) {
                    colListIdx[0] = i;
                }
                for (var j = 0; j < arrText.length; j++) {
                    if (colArr[i] == arrText[j]) {
                        colListIdx[j+1] = i;
                    }
                }
            }

            for (var i = 0; i < dataChildNodes.length; i++) {
                if (dataChildNodes[i].nodeType != 1) {
                    continue;
                }

                var arrData = null;
                if (sep == null || sep == "") {
                    arrData = new Array();
                    var trChildNodes = dataChildNodes[i].childNodes;
                    for (var j = 0; j < trChildNodes.length; j++) {
                        if (trChildNodes[j].nodeType != 1) {
                            continue;
                        }
                        arrData.push(trChildNodes[j].firstChild.nodeValue);
                    }
                } else {
                    arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
                }

                var item = "";
                for (var j = 1; j < colListIdx.length; j++) {
                    item += arrData[colListIdx[j]];
                    if (j < colListIdx.length - 1) {
                        item += "|";
                    }
                }
                cmbObj.InsertItem(-1, item, arrData[colListIdx[0]]);
            }

        } catch (err) {
            ComFuncErrMsg(err.message);
        }
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
