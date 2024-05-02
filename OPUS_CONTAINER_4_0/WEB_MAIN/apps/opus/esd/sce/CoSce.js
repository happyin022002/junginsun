/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CoSce.js
*@FileTitle  : Common JavaScript for Joint Operation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
 
	if(msgs == undefined){
		msgs = new Array();
	}
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
	msgs['SCE90047'] = "This COP already canceled, You can not replan cop data";	
	msgs['SCE90048'] = "Input location is not same as original location. Do you want to continue?";
	msgs['SCE90049'] = "The selected route have 'Temp Flag'.\n which should be applied to a special case.\n Do you really want to change this route?";	
	msgs['SCE90050'] = "actual date / time is out of sequence."	;
	msgs['SCE90051'] = "There are changed data. Do you still want to retrieve?";	
	msgs['SCE90052'] = "Actual Status Mapping Code and Standard EDI Status Code is duplicated.";
	msgs['SCE90053'] = 'Mandatory field is missing. Please enter Actual Status Mapping Code or Standard EDI Status Code.';
	msgs['SCE90054'] = "It will be refresh all data in PRD&COP \n\nAre you sure to proceed?";
	
	/**##################함대성 START##################**/
	msgs['SCE01221'] = 'Please check {?msg1} again.' ;
	msgs['SCE01222'] = "There is no data to save.";
	msgs['SCE01223'] = "Please select {?msg1}";
	
	/**#################신한성 START##################**/
	msgs['SCE02001'] = 'Please enter Orgin In-Gate On Sheet.';
	
	msgs['SCE02002'] = 'Please select Service Type as Lane.';
	
	function containsSheetCombo(name, value){
	    var data=null;
	    eval("data=getSheetCombo_"+name+"()");
	    if(data == null) return false;
	    var data="|"+data[0]+"|";
	    return (data.indexOf("|"+value+"|") >= 0);
	}
	/**##################함대성 END####################**/
	/** sheet 관련여부 **/
	var sheetObject=null ;
	var sheetRow=0 ;
	/** mult check 관련 변수 **/
	var multiChkYN=false ;
	/** Location 관련 변수 **/
	var contiCdFld="" ;
	var scontiCdFld="" ;
	var cntCdFld="" ;
	var locStateFld="" ;
	var locEqOfcFld="" ;
	var locCdFld="" ;
	var locDescFld="" ;
	var locPortIndFld="" ;
	var sysCodeFld="" ;
	/** Office 관련 변수 **/
	var ofcLevFld="" ;
	var ofcPtsCdFld="" ;
	var ofcCdFld="" ;
	var ofcNmFld="" ;
	var callTypeFld="" ;
	/** Customer 관련 변수 **/
	var custCdFld="" ;
	var custNmFld="" ;
	var custSgmtFld="" ;
	/** VVD 관련 변수 **/
	var etdetaFld="" ;
	var sDateFld="" ;
	var eDateFld="" ;
	var vvdCdFld="" ;
	var laneCdFld="" ;
	var operFld="" ;
	/** Node 관련 변수 **/
	var nodeCdFld="" ;
	var nodeNmFld="" ;
	var modeFld="" ;
	var modeOnlyFld="" ;
	/** Service Provider 관련 변수 **/
	var ptsVndrCdFld="" ;
	var vndrNmEngFld="" ;
	/** Staff 관련 변수 **/
	var userCdFld="" ;
	var userNmFld="" ;
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
		var param="" ;
		var display=getCommPopDisplay(multi) ;
		param="?classId=" + getCommPopClassId() ;
		param += getURLParam(multi, "conti_cd",     contiCd) ;
		param += getURLParam(multi, "sconti_cd",    scontiCd) ;
		param += getURLParam(multi, "cnt_cd",       cntCd) ;
		param += getURLParam(multi, "loc_state",    locState) ;
		param += getURLParam(multi, "loc_eq_ofc",   locEqOfc) ;
		param += getURLParam(multi, "loc_cd",       locCd) ;
		param += getURLParam(multi, "loc_desc",     locDesc) ;
		param += getURLParam(multi, "loc_port_ind", locPortInd) ;
		contiCdFld=contiCd ;
		scontiCdFld=scontiCd ;
		cntCdFld=cntCd ;
		locStateFld=locState ;
		locEqOfcFld=locEqOfc ;
		locCdFld=locCd ;
		locDescFld=locDesc ;
		locPortIndFld=locPortInd ;
		sysCodeFld=sysCode ;
		multiChkYN=multi
		ComOpenPopup('COM_ENS_051.do' + param, 900, 470, 'setValFromLocPop', display, true) ;
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
		var param="" ;
		var display=getCommPopDisplay(multi) ;
		param="?classId=" + getCommPopClassId() ;
		param += getURLParam(multi, "conti_cd",     contiCd) ;
		param += getURLParam(multi, "sconti_cd",    scontiCd) ;
		param += getURLParam(multi, "cnt_cd",       cntCd) ;
		param += getURLParam(multi, "loc_state",    locState) ;
		param += getURLParam(multi, "loc_eq_ofc",   locEqOfc) ;
		param += getURLParam(multi, "loc_cd",       locCd) ;
		param += getURLParam(multi, "loc_desc",     locDesc) ;
		param += getURLParam(multi, "loc_port_ind", locPortInd) ;
		multiChkYN=multi
//		alert(param);
		contiCdFld=contiCd ;
		scontiCdFld=scontiCd ;
		cntCdFld=cntCd ;
		locStateFld=locState ;
		locEqOfcFld=locEqOfc ;
		locCdFld=locCd ;
		locDescFld=locDesc ;
		locPortIndFld=locPortInd ;
		sysCodeFld=sysCode ;
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
		var param="" ;
		var display=getCommPopDisplay(multi) ;
		contiCdFld=contiCd ;
		scontiCdFld=scontiCd ;
		cntCdFld=cntCd ;
		locStateFld=locState ;
		locEqOfcFld=locEqOfc ;
		locCdFld=locCd ;
		locDescFld=locDesc ;
		locPortIndFld=locPortInd ;
		sysCodeFld=sysCode ;
		multiChkYN=multi
		sheetRow=row ;
		sheetObject=sheetObj ;
		param="?classId=" + getCommPopClassId() ;
		param += getURLParam(multi, "conti_cd",     contiCd) ;
		param += getURLParam(multi, "sconti_cd",    scontiCd) ;
		param += getURLParam(multi, "cnt_cd",       cntCd) ;
		param += getURLParam(multi, "loc_state",    locState) ;
		param += getURLParam(multi, "loc_eq_ofc",   locEqOfc) ;
		param += getURLParam(multi, "loc_cd",       locCd) ;
		param += getURLParam(multi, "loc_desc",     locDesc) ;
		param += getURLParam(multi, "loc_port_ind", locPortInd) ;
		ComOpenPopup('COM_ENS_051.do' + param, 770, 470, 'setValFromLocPop', display, true) ;
	}
	/**
	 * Location 공통 팝업에서 호출하는 함수
	 *
	 * @param rowArray 결과값
	 */
	function setValFromLocPop(rowArray){
		var colArray=null ;
		var gubun='';
		if(multiChkYN){
			for(i=0; i<rowArray.length; i++){
				if(i<rowArray.length-1) gubun=',';
				else gubun="" ;
				colArray=rowArray[i];
				setValFromLocArray(colArray, gubun, i)
			}
		}
		else{
			colArray=rowArray[0] ;
			setValFromLocArray(colArray,gubun, 0) ;
		}
		sheetObject=null ;
		sheetRow=0 ;
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
		var formObj=document.form ;
		var param="" ;
		var display=getCommPopDisplay(multi) ;
		param="?classId=" + getCommPopClassId() ;
		param += getURLParam(multi, "ofc_lev",    ofcLev) ;
		param += getURLParam(multi, "ofc_pts_cd", ofcPtsCd) ;
		param += getURLParam(multi, "ofc_cd",     ofcCd) ;
		param += getURLParam(multi, "ofc_nm",     ofcNm) ;
		param += getURLParam(multi, "CallType",   callType, "2") ;
		ofcLevFld=ofcLev ;
		ofcPtsCdFld=ofcPtsCd ;
		ofcCdFld=ofcCd ;
		ofcNmFld=ofcNm ;
		callTypeFld=callType ;
		multiChkYN=multi ;
		ComOpenPopup('COM_ENS_071.do' + param, 770, 450, 'setValFromOfcPop', display, true) ;
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
		var formObj=document.form ;
		var param="" ;
		var display=getCommPopDisplay(multi) ;
		ofcLevFld=ofcLev ;
		ofcPtsCdFld=ofcPtsCd ;
		ofcCdFld=ofcCd ;
		ofcNmFld=ofcNm ;
		callTypeFld=callType ;
		multiChkYN=multi ;
		sheetRow=row ;
		sheetObject=sheetObj ;
		param="?classId=" + getCommPopClassId() ;
		param += getURLParam(multi, "ofc_lev",    ofcLev) ;
		param += getURLParam(multi, "ofc_pts_cd", ofcPtsCd) ;
		param += getURLParam(multi, "ofc_cd",     ofcCd) ;
		param += getURLParam(multi, "ofc_nm",     ofcNm) ;
		param += getURLParam(multi, "CallType",   callType, "2") ;
		ComOpenPopup('COM_ENS_071.do' + param, 770, 450, 'setValFromOfcPop', display, true) ;
	}
	/**
	 * Office 공통 팝업에서 호출하는 함수
	 *
	 * @param rowArray 결과값
	 */
	function setValFromOfcPop(rowArray){
		var colArray=null ;
		var gubun='';
		if(multiChkYN){
			for(i=0; i<rowArray.length; i++){
				if(i<rowArray.length-1) gubun=',';
				else gubun="" ;
				colArray=rowArray[i];
				setValFromOfcArray(colArray, gubun, i)
			}
		}
		else{
			colArray=rowArray[0] ;
			setValFromOfcArray(colArray,gubun, 0) ;
		}
		sheetObject=null ;
		sheetRow=0 ;
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
		var formObj=document.form ;
		var param="" ;
		var display=getCommPopDisplay(multi) ;
		param="?classId=" + getCommPopClassId() ;
		param += getURLParam(multi, "cust_cd", custCd) ;
		param += getURLParam(multi, "cust_nm", custNm) ;
		param += getURLParam(multi, "ofc_cd",  ofcCd) ;
		custCdFld=custCd ;
		custNmFld=custNm ;
		ofcCdFld=ofcCd ;
		custSgmtFld=custSgmt ;
		multiChkYN=multi ;
		ComOpenPopup('COM_ENS_041.do' + param, 770, 450, 'setValFromCustPop', display, true) ;
	}
	/**
	 * Customer 공통 팝업에서 호출하는 함수
	 *
	 * @param rowArray 결과값
	 */
	function setValFromCustPop(rowArray){
		var colArray=null ;
		var gubun='';
		if(multiChkYN){
			for(i=0; i<rowArray.length; i++){
				if(i<rowArray.length-1) gubun=',';
				else gubun="" ;
				colArray=rowArray[i];
				setValFromCustArray(colArray, gubun, i)
			}
		}
		else{
			colArray=rowArray[0] ;
			setValFromCustArray(colArray,gubun, 0) ;
		}
		sheetObject=null ;
		sheetRow=0 ;
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
		var formObj=document.form ;
		var param="" ;
		var display=getCommPopDisplay(multi) ;
		param="?classId=" + getCommPopClassId() ;
		param += getURLParam(multi, "vvd_cd", vvdCd) ;
		param += getURLParam(multi, "sdate", sDate) ;
		param += getURLParam(multi, "edate", eDate) ;
		param += getURLParam(multi, "etdeta", etdeta) ;
		param += getURLParam(multi, "loc_cd", locCd) ;
		param += getURLParam(multi, "lane_cd", laneCd) ;
		param += getURLParam(multi, "oper", oper) ;
		vvdCdFld=vvdCd ;
		sDateFld=sDate ;
		eDateFld=eDate ;
		etdetaFld=etdeta ;
		locCdFld=locCd ;
		laneCdFld=laneCd ;
		operFld=oper ;
		multiChkYN=multi ;
		ComOpenPopup('COM_ENS_0B2.do' + param, 770, 470, 'setValFromVVDPop', display, true) ;
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
		var formObj=document.form ;
		var param="" ;
		var display=getCommPopDisplay(multi) ;
		param="?classId=" + getCommPopClassId() ;
		param += getURLParam(multi, "vvd_cd", vvdCd) ;
		param += getURLParam(multi, "sdate", sDate) ;
		param += getURLParam(multi, "edate", eDate) ;
		param += getURLParam(multi, "etdeta", etdeta) ;
		param += getURLParam(multi, "loc_cd", locCd) ;
		param += getURLParam(multi, "lane_cd", laneCd) ;
		param += getURLParam(multi, "oper", oper) ;
//		ComOpenPopup('ESD_SCE_0103.do' + param, 800, 430, 'setValFromVVDPop', display) ;
		var newWin =  ComOpenWindow("ESD_SCE_0103.do"+ param,  window,  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:430px" , true);
		vvdCdFld=vvdCd ;
		sDateFld=sDate ;
		eDateFld=eDate ;
		etdetaFld=etdeta ;
		locCdFld=locCd ;
		laneCdFld=laneCd ;
		operFld=oper ;
		multiChkYN=multi ;
	}
	/**
	 * vvd 공통 팝업에서 호출하는 함수
	 *
	 * @param rowArray 결과값
	 */
	function setValFromVVDPop(rowArray){
		var colArray=null ;
		var gubun='';
		if(multiChkYN){
			for(i=0; i<rowArray.length; i++){
				if(i<rowArray.length-1) gubun=',';
				else gubun="" ;
				colArray=rowArray[i];
				setValFromVVDArray(colArray, gubun, i)
			}
		}
		else{
			colArray=rowArray[0] ;
			setValFromVVDArray(colArray,gubun, 0) ;
		}
		sheetObject=null ;
		sheetRow=0 ;
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
		var formObj=document.form ;
		var param="" ;
		var display=getCommPopDisplay(multi) ;
		param="?classId=" + getCommPopClassId() ;
		param += getURLParam(multi, "node_cd"  , nodeCd) ;
		param += getURLParam(multi, "node_nm"  , nodeNm) ;
		param += getURLParam(multi, "cnt_cd"   , cntCd) ;
		param += getURLParam(multi, "loc_cd"   , locCd) ;
		param += getURLParam(multi, "ofc_cd"   , ofcCd) ;
		param += getURLParam(multi, "mode"     , mode) ;
		param += getURLParam(multi, "mode_only", modeOnly) ;
		nodeCdFld=nodeCd ;
		nodeNmFld=nodeNm ;
		cntCdFld=cntCd ;
		locCdFld=locCd ;
		ofcCdFld=ofcCd ;
		modeFld=mode ;
		modeOnlyFld=modeOnly ;
		multiChkYN=multi ;
		ComOpenPopup('COM_ENS_061.do' + param, 770, 451, 'setValFromNodePop', display, false) ;
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
		var formObj=document.form ;
		var param="" ;
		var display=getCommPopDisplay(multi) ;
		nodeCdFld=nodeCd ;
		nodeNmFld=nodeNm ;
		cntCdFld=cntCd ;
		locCdFld=locCd ;
		ofcCdFld=ofcCd ;
		modeFld=mode ;
		modeOnlyFld=modeOnly ;
		multiChkYN=multi ;
		sheetObject=sheetObj ;
		sheetRow=row ;
		param="?classId=" + getCommPopClassId() ;
		param += getURLParam(multi, "node_cd"  , nodeCd) ;
		param += getURLParam(multi, "node_nm"  , nodeNm) ;
		param += getURLParam(multi, "cnt_cd"   , cntCd) ;
		param += getURLParam(multi, "loc_cd"   , locCd) ;
		param += getURLParam(multi, "ofc_cd"   , ofcCd) ;
		param += getURLParam(multi, "mode"     , mode) ;
		param += getURLParam(multi, "mode_only", modeOnly) ;
		ComOpenPopup('COM_ENS_061.do' + param, 770, 451, 'setValFromNodePop', display, true) ;
	}
	/**
	 * node 공통 팝업에서 호출하는 함수
	 *
	 * @param rowArray 결과값
	 */
	function setValFromNodePop(rowArray){
		var colArray=null ;
		var gubun='';
		if(multiChkYN){
			for(i=0; i<rowArray.length; i++){
				if(i<rowArray.length-1) gubun=',';
				else gubun="" ;
				colArray=rowArray[i];
				setValFromNodeArray(colArray, gubun, i)
			}
		}
		else{
			colArray=rowArray[0] ;
			setValFromNodeArray(colArray,gubun, 0) ;
		}
		sheetObject=null ;
		sheetRow=0 ;
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
		var formObj=document.form ;
		var param="" ;
		var display=getCommPopDisplay(multi) ;
		param="?classId=" + getCommPopClassId() ;
		param += getURLParam(multi, "pts_vndr_cd", ptsVndrCd) ;
		param += getURLParam(multi, "vndr_nm_eng", vndrNmEng) ;
		param += getURLParam(multi, "cnt_cd"     , cntCd) ;
		param += getURLParam(multi, "ofc_cd"     , ofcCd) ;
		ptsVndrCdFld=ptsVndrCd ;
		vndrNmEngFld=vndrNmEng ;
		cntCdFld=cntCd ;
		ofcCdFld=ofcCd ;
		multiChkYN=multi
		ComOpenPopup('COM_ENS_0C1.do' + param, 620, 451, 'setValFromServiceProviderPop', display, true) ;
	}
	/**
	 * Service Provider 공통 팝업에서 호출하는 함수
	 *
	 * @param rowArray 결과값
	 */
	function setValFromServiceProviderPop(rowArray){
		var colArray=null ;
		var gubun='';
		if(multiChkYN){
			for(i=0; i<rowArray.length; i++){
				if(i<rowArray.length-1) gubun=',';
				else gubun="" ;
				colArray=rowArray[i];
				setValFromServiceProviderArray(colArray, gubun, i)
			}
		}
		else{
			colArray=rowArray[0] ;
			setValFromServiceProviderArray(colArray,gubun, 0) ;
		}
		sheetObject=null ;
		sheetRow=0 ;
	}
	/**
	 * Service Provider 에서 넘어온 값을 field에 세팅
	 *
	 * @param colArray 한 row의 column 배열
	 * @param gubun 다중선택시 값의 구분
	 * @param idx row의 index
	 */
	function setValFromServiceProviderArray(colArray, gubun, idx){
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
		var formObj=document.form ;
		var param="" ;
		var display=getCommPopDisplay(multi) ;
		param="?classId=" + getCommPopClassId() ;
		param += getURLParam(multi, "user_cd", userCd) ;
		param += getURLParam(multi, "user_nm", userNm) ;
		param += getURLParam(multi, "ofc_cd" , ofcCd) ;
		param += "&f_cmd=2" ;
	//alert(param);
		userCdFld=userCd ;
		userNmFld=userNm ;
		ofcCdFld=ofcCd ;
		multiChkYN=multi
		ComOpenPopup('COM_ENS_091.do' + param, 770, 580, 'setValFromStaffPop', display, true) ;
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
		var formObj=document.form ;
		var param="" ;
		var display=getCommPopDisplay(multi) ;
		userCdFld=userCd ;
		userNmFld=userNm ;
		ofcCdFld=ofcCd ;
		sheetObject=sheetObj ;
		sheetRow=row ;
		multiChkYN=multi
		param="?classId=" + getCommPopClassId() ;
		param += getURLParam(multi, "user_cd", userCd) ;
		param += getURLParam(multi, "user_nm", userNm) ;
		param += getURLParam(multi, "ofc_cd" , ofcCd) ;
		param += "&f_cmd=2" ;
		ComOpenPopup('COM_ENS_091.do' + param, 770, 580, 'setValFromStaffPop', display, true) ;
	}
	/**
	 * SStaaf 공통 팝업에서 호출하는 함수
	 *
	 * @param rowArray 결과값
	 */
	function setValFromStaffPop(rowArray){
		var colArray=null ;
		var gubun='';
		if(multiChkYN){
			for(i=0; i<rowArray.length; i++){
				if(i<rowArray.length-1) gubun=',';
				else gubun="" ;
				colArray=rowArray[i];
				// setValFromStaffArray 함수 중복(ESD_SCE_0102.js에도 존재) 일단 ESD_SCE_0102.js 함수를 setValFromStaffArray_new로 변경하고 호출
				setValFromStaffArray_new(colArray, gubun, i)
				//setValFromStaffArray(colArray, gubun, i)
			}
		}
		else{
			colArray=rowArray[0] ;
			// setValFromStaffArray 함수 중복(ESD_SCE_0102.js에도 존재) 일단 ESD_SCE_0102.js 함수를 setValFromStaffArray_new로 변경하고 호출
//			setValFromStaffArray_new(colArray, gubun, )
			setValFromStaffArray(colArray,gubun, 0) ;
		}
		sheetObject=null ;
		sheetRow=0 ;
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
		var url=document.location.href ;
		var classId=url.substring(url.lastIndexOf("/")+1, url.lastIndexOf(".do")) ;
		return classId ;
	}
	/**
	 * display 얻기
	 *
	 * @param multi 다중선택 가능 여부
	 *              true : 다중선택 가능, false : 불가능
	 */
	function getCommPopDisplay(multi){
	 	var display=multi?'0,1,1,1,1,1,1,1,1,1,1,1':'1,0,1,1,1,1,1,1,1,1,1,1' ;
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
	 	var formObj=document.form ;
//	 	alert(fldNm);
	 	if(sheetObject==null){
		 	if(formObj[fldNm]!=null){
				if(rowIdx==0){
					//alert(fldNm);
			    	formObj[fldNm].value=colArray[colIdx] + gubun ;
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
			    	sheetObject.SetCellValue(sheetRow,fldNm,colArray[colIdx] + gubun ,0);
				}
				else{
                    sheetObject.SetCellValue(sheetRow,fldNm,sheetObject.GetCellValue(sheetRow,fldNm) +colArray[colIdx] + gubun , 0);
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
		var formObj=document.form ;
		var param="" ;
		if(!multi){
			defaultVal=defaultVal==null?"":defaultVal ;
			if(sheetObject==null){
				param="&" + paramNm + "=" + (fldNm!=null&&formObj[fldNm]!=null?
		                formObj[fldNm].value:defaultVal) ;
			}
			else{
                param="&" + paramNm + "=" + (fldNm==null || sheetObject.GetCellValue(sheetRow, fldNm)==null?defaultVal:
                sheetObject.GetCellValue(sheetRow, fldNm)) ;
			}
		}
		return param ;
	}
	/**
	 * sep에 해당하는 char를 제거하는 스크립트
	 */
	function doSepRemove(obj, sep) {
		var ch="";
		var lvobj="";
		for(var i=0; i<obj.length; i++) {
			if(obj.charAt(i) == sep) {
				ch="";
			} else {
				ch=obj.charAt(i);
			}
			lvobj=lvobj + ch;
		}
		return lvobj;
	}	
	jsLEng="ABCDEFGHIJKLMNOPQRSTUVWXYZ" ;
	jsSEng="abcdefghijklmnopqrstuvwxyz" ;
	jsEng=jsLEng + jsSEng ;
	jsNum="0123456789";
	jsSChar="!@#$%^&*()_+=-,./<>?;':\"{}[]" ;
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
		obj.value=chkCharValue(obj.value, pchar, upper, maxLen) ;
	}
	function chkCharValue(value, pchar, upper, maxLen){
		var newValue="" ;
		var oneChar=null ;
		for(i=0;i<value.length; i++){
			oneChar=value.charAt(i) ;
			if(pchar.indexOf(oneChar)!=-1 && (maxLen==null || newValue.length<maxLen)){
				newValue += oneChar ;
			}
		}
		newValue=upper ? newValue.toUpperCase() : newValue ;
		return newValue ;
	}
	function dateFormatObj(obj, format){
		var value=obj.value ;
		obj.value=dateFormatValue(value, format)
	}
	function dateFormatValue(value, format) {
		var oldValue=chkCharValue(value, jsNum, false) ;
		var newValue="" ;
		var chkValue="" ;
		var oneChar=null ;
		var maxLen=8 + (format.length*2)
		for(i=0; i<oldValue.length; i++){
			oneChar=oldValue.charAt(i) ;
			if(newValue.length<maxLen){
				if(i==4){
					if(oneChar>1){
						newValue=newValue + format + "0" + oneChar ;
					}
					else{
						newValue=newValue + format + oneChar ;
					}
				}
				else if(i==6){
					if(oneChar>3){
						newValue=newValue + format + "0" + oneChar ;
					}
					else{
						newValue=newValue + format + oneChar ;
					}
				}
				else {
					newValue += oneChar ;
				}
			}
		}
		chkValue=oldValue.substring(0,8) ;
		if(!chkDateValue(chkValue)){
			newValue=newValue.substring(0, newValue.length-1) ;
		}
		return newValue ;
	}
	function chkDateValue(value){
		var yyyy=value.substring(0,4) ;
		var mm=value.substring(4,6) ;
		var dd=value.substring(6) ;
		var daysInMonth=new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31) ;
		// 월체크
		if(mm>12) {
			return false ;
		}
		// 윤달
		if(mm==2){
			daysInMonth[1]=yyyy%400==0 || ((yyyy%4==0) && (yyyy%100!=0)) ? 29 : 28 ; 
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
	   var cntrNo=obj.value;
	 if (cntrNo.length != 10){
	  return cntrNo;
	 } 
	 var sum=0;
	 cntrNo=cntrNo.toUpperCase();
	 for(var i=0;i<10;i++){
	  sum=sum + productValue( cntrNo.charAt(i),i);
	 }
	 var mod=sum % 11;
	 if (mod == 10) mod=0;
	 if (isNaN(mod)) return cntrNo;
	 return cntrNo+mod;
	}
	/**
	 * 컨테이너 번호 Check Digit 계산 함수 -product Value 계산 하는 로직을 포함한 메소드
	 */
	function productValue(str,position){
	 var strMap=new Array("10","12","13","14","15","16","17","18","19","20","21","23","24","25","26","27","28","29","30","31","32","34","35","36","37","38");
	 var num=new Number(str);
	 if (isNaN(num)){
	  var index=new Number(str.charCodeAt(0)-65) ;
	  var strNum=strMap[index];
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
		return FormQueryString(form);
	   
	}

	function getTextVendorSeq(sheetObj, formObj, vndr_seq) {
		formObj.f_cmd.value = SEARCH01;
		//formObj.combo_svc_provider.value = get_only_num(vndr_seq);
		var sXml = sheetObj.GetSearchData("ESD_SCE_0056GS.do", SceFrmQryString(formObj));
		var vendorNoList = ComGetEtcData(sXml, 'vndr_no');
		var vendorNmList = ComGetEtcData(sXml, 'vndr_nm_eng');
		if (vendorNoList == undefined || vendorNoList == '') {
			formObj.combo_svc_provider.value = '';
			formObj.svc_provider.value = '';
			return false;
		}
		formObj.combo_svc_provider.value = lpad(ComTrim(vendorNoList), 6, '0');
		formObj.svc_provider.value = vendorNmList;
		return true;
	}
	
	function lpad(src, len, padStr) {
		var retStr = "";
		var padCnt = Number(len) - String(src).length;
		for ( var i = 0; i < padCnt; i++)
			retStr += String(padStr);
		return retStr + src;
	}