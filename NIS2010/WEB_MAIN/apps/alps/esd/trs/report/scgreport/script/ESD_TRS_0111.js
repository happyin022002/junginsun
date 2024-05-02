/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0111.js
*@FileTitle : Surcharge Report
*Open Issues :
*Change history :
*@LastModifyDate : 2013-10-16
*@LastModifier : 조인영
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class ESD_TRS_0111 : esd_trs_0111 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esd_trs_0111() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0; 
var globalCheck = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

         var sheetObject1 = sheetObjects[0];
         
         /*******************************************************/
         var formObject = document.form;
 		 
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {
   
	    			case "btns_calendar":
	    				getCalendar();
	    			break;
	    			
					case "btn_retrieve":
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						break;
						
					case "btn_new":
						fn_reset();
						break;

					case "btns_office": //M CNTR
						if( validation_check() ) {
							var ofc_cd = formObject.input_office.value;
							ComOpenWindow('ESD_TRS_0964.screen?ctrl_ofc_cd='+ofc_cd, 'ESD_TRS_0964', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:410px;dialogHeight:400px', true);
						}  
						break;

					case "btn_detail":
						if(sheetObject1.SelectRow >= sheetObject1.HeaderRows){
							var iCheckRow = sheetObject1.CheckedRows("sheet1_del_chk");
							if(iCheckRow <= 0){
								ComShowCodeMessage("COM12176");
								return false;
							}else{
					    		make_detail_info(sheetObject1);
					    		formObject.f_cmd.value = "";
								var myOption = "width=1024,height=640,menubar=0,status=0,scrollbars=0,resizable=1";
					    		ComPostOpenWindow("/hanjin/ESD_TRS_0112.do", "ESD_TRS_0112", myOption);	
							}
						}else{
							ComShowCodeMessage("COM12176");
						}
						break;

					case "btn_down_excel":
						sheetObject1.SpeedDown2Excel(-1);
						break;

				} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Combo Object를 배열로 등록
     */    
 	function setComboObject(combo_obj){
 	    comboObjects[comboCnt++] = combo_obj;
 	}
	 
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

    	setScgType();
		initControl();
    }



	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetID = sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {
					// 높이 설정
                    style.height = 386;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "Flag|All|W/O Office|Inv Office|Month|Box Count|Currency|Total Amount|Additional Labor|Seasonal Surcharge|Chassis Drayage|Drop&Pull(Drop&Pick up/Bob tail)|Dry Run|Ferry Cost|Fine|Fumigation/Cleaning|Reefer|HAZMAT(DG)|Inspection|Lifting Charge|Multiple Delivery|Over Size(OOG)|Over Weight|Pre -Pull|Redirection Charge|Scale Stop|Storage|Street Turn|Weekend/Holiday|Swing/Flip|T-DOC Fee|Toll|Waiting Charges|Other Surcharge|ENSF";
					
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    var prefix="sheet1_";
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, dtHiddenStatus,	30,	daCenter,	false,	prefix+"ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck, 	30, daCenter,	true,	prefix+"del_chk",		false, "", dfNone, 	0, true,	true);
					InitDataProperty(0, cnt++, dtData, 	70,	    daCenter,	true,	prefix+"wo_ofc_cd", 		false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	    daCenter,	true,	prefix+"inv_ofc_cd", 		false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,		daCenter,	true,	prefix+"month", 			false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,		daRight,	true,	prefix+"box_count",			false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,		daCenter,	true,	prefix+"curr", 				false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++, dtData, 	90,		daRight,	true,	prefix+"tot_amt",			false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"add_labor",			false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"barge_low",			false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"chassis",			false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"drop_pull",			false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"dry_run",			false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"ferry_cost",		false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"fine",				false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"fumigation",		false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"gen_set",			false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"hazmat",			false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"inspection",		false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"lifting",			false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"multiple",			false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"over_size",			false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"over_weight",		false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"pre_pull",			false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"redirection",		false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"scale_stop",		false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"storage",			false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"street_turn",		false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"sunday",			false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"swing_flip",		false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"t_doc",				false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"toll",				false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"waiting_charge",	false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"other",				false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daRight,	true,	prefix+"ensf",				false, "", dfFloat, 2, false, false);
					}
				break;
        }
    }

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH: //Retrieve
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH;
					var arr = new Array("sheet1_", "");
		        	var sParam = FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr);
					var sXml = sheetObj.GetSearchXml("ESD_TRS_0111GS.do", sParam);
					if(sXml.length>0){
						sheetObj.LoadSearchXml(sXml);
					}
				}	
				break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
			case IBSEARCH:
				if(isNull(formObj.from_date.value)){
					ComShowCodeMessage("COM130201", "From to Date");
					formObj.from_date.focus();
					return false;
		      	}else if(isNull(formObj.to_date.value)){
					ComShowCodeMessage("COM130201", "From to Date");
					formObj.to_date.focus();
					return false;
		      	}else if(isNull(formObj.input_office.value)){
					ComShowCodeMessage("COM130201", "W/O Issue Office Code");
					formObj.input_office.focus();
					return false;
		      	}
				
				break;
		}
        return true;
    }

    /* initControl() */
    function initControl() {
 		axon_event.addListenerForm('keypress', 'obj_keypress',  form);    	  
    	axon_event.addListenerFormat('focus', 'obj_activate', form);
    	axon_event.addListenerForm ('blur', 'obj_blur', form);
    }
    
    //업무 자바스크립트 OnFocus 이벤트 처리
    function obj_activate() {
       	//마스크 구분자 없애기
        //ComClearSeparator(event.srcElement);
           
       	switch(event.srcElement.name){ 	    	
       		case "from_date":
       			ComClearSeparator(event.srcElement);
       			event.srcElement.select();
       			break;
       		case "to_date":
       			ComClearSeparator(event.srcElement);
       			event.srcElement.select();
       			break;
       	}
    }

    /** 
     * 업무 자바스크립트 Onblur 이벤트 처리  <br>
     */    
    function obj_blur(){
    	obj = event.srcElement;
    	var formObj = document.form;

    	switch(obj.name) {
    		case "slan_cd":
    			if( formObj.slan_cd.value != ""){
    				if(!ComChkObjValid(obj)){
    					setFocus("slan_cd");
    					return false;
    				}
    			}
    			break; 

			case "from_date":
    			if( formObj.from_date.value != ""){
                    if(!ComChkObjValid(obj)){
                    	setObjValue("from_date", "");
                    	setFocus("from_date");
                    	return false;
                    }
                }
    			break;
    		case "to_date":
    			if( formObj.to_date.value != ""){
                    if(!ComChkObjValid(obj)){
                    	setObjValue("to_date", "");
                    	setFocus("to_date");
                    	return false;
                    }
                }
    			break;
    	}
    }

	function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
		var formObj = document.form;
		var row = sheetObj.MouseRow;
		var col = sheetObj.MouseCol;
		if ((row == 0) && col == 1) {
			if(globalCheck == 0) { globalCheck = 1;}
			else {globalCheck = 0;}

			if (globalCheck == 1) {
				for(var i=sheetObj.HeaderRows ; i<=sheetObj.RowCount-1 ; i++){
					sheetObj.CellValue2(i, "sheet1_del_chk") = 1;
				}
			} else {
				for(var i=sheetObj.HeaderRows ; i<=sheetObj.RowCount+1 ; i++){
					sheetObj.CellValue2(i, "sheet1_del_chk") = 0;
				}
			}
		}
	}
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var formObj = document.form;
		globalCheck = 0;
		sheetObj.ShowSubSum("sheet1_del_chk", "5|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34", -1, true, false, -1, "sheet1_wo_ofc_cd=Total;");
	}

	
	function sheet1_OnDblClick(sheetObj, Row, Col, Value){
		var formObj = document.form;
		//if( sheetObj.CellValue(Row, "sheet1_wo_ofc_cd") == "ALL"){
			ComSetObjValue(formObj.sel_wo_ofc_cd, sheetObj.CellValue(Row, "sheet1_wo_ofc_cd"));
			ComSetObjValue(formObj.sel_inv_ofc_cd, sheetObj.CellValue(Row, "sheet1_inv_ofc_cd"));
			ComSetObjValue(formObj.sel_month, sheetObj.CellValue(Row, "sheet1_month"));
			ComSetObjValue(formObj.sel_op_tp, "SINGLE"); // single row double click
    		formObj.f_cmd.value = "";
			var myOption = "width=1024,height=640,menubar=0,status=0,scrollbars=0,resizable=1";
    		ComPostOpenWindow("/hanjin/ESD_TRS_0112.do", "ESD_TRS_0112", myOption);	
		//}
	}

    

	 /**
	 * make_detail_info :: detail에 전달할 정보를 생성하는 Event
	 */
	function make_detail_info(sheetObj) {
		var formObj = document.form;
		
		with(sheetObj) {
			var vDelCheck = FindCheckedRow("sheet1_del_chk").split("|");
			var vWoOfcCd = "";
			var vInvOfcCd = "";
			var vComma = "";
			var vMonth = "";

			for(var i=0; i<vDelCheck.length; i++) {
				if(vDelCheck[i] != "") {
					if(i!=0){ vComma = "#"; };
					vWoOfcCd += vComma + CellValue(vDelCheck[i], "sheet1_wo_ofc_cd");
					vInvOfcCd += vComma + CellValue(vDelCheck[i], "sheet1_inv_ofc_cd");
					vMonth += vComma + CellValue(vDelCheck[i], "sheet1_month");
				}
			}
            ComSetObjValue(formObj.sel_wo_ofc_cd, vWoOfcCd);
			ComSetObjValue(formObj.sel_inv_ofc_cd, vInvOfcCd);
			ComSetObjValue(formObj.sel_month, vMonth);
			ComSetObjValue(formObj.sel_op_tp, "MULTI"); // multi row select and go detail
		}
	}


    /** 
     * Object 의 Keypress 이벤트에 대한 처리  <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * @param  없음
     * @return 없음
     * @author 김종옥
     * @version 2009.06.15
     */ 
    function obj_keypress(){
     	obj = event.srcElement;
     	if(obj.dataformat == null) return;
     	 	
     	window.defaultStatus = obj.dataformat;
     	 
     	switch(obj.dataformat) {
        	case "ym":
        		ComKeyOnlyNumber(event.srcElement);
            	break;
     	}
    }    

	/**
     * Get Object Value
     */
    function getObjValue(name) {
    	return ComGetObjValue(eval("document.form."+name));
    }
    
    /**
     * Set Object Value
     */
    function setObjValue(name, value) {
    	ComSetObjValue(eval("document.form."+name), value);
    }
    
    /**
     * Move Focus in Object
     */
    function setFocus(name) {
    	ComSetFocus(eval("document.form."+name));
    	eval("document.form."+name).select();
    }

	/**
	* 화면 폼입력값에 Null Check
	*/
	function isNull(itemValue){
	   if(itemValue==null || itemValue=="" || itemValue=="undefined"){
	   	return true;
	   }
	   else{
	   	return false;
	   }
	}

//control s/o office code return value.
function rtn_office_code(obj) {
	document.form.input_office.value = obj;
}
	
//Include Office를 처리하기 위한 Logic
var request = null;
function createHttpRequest() {
	try{
		request = new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request = null;
			}
		}
	}
	if( request == null ) {
		ComShowMessage("Erroe Request XMLHttp");
	}
}
	
//Include Check Bok를 Click했을 때
function fun_chkOffice() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.input_office.value.toUpperCase(), " "); //input text

	if(doc_office.checked == true){
		document.form.incl_sub_ofc_flg.value="Y";
	}else{
		document.form.incl_sub_ofc_flg.value="N";
	}
	
	if( prm_office == "" ) {
		doc_office.checked = false;
		document.form.input_office.value = "";
		ComShowCodeMessage("TRS90522");
		return false;
	}
	if( doc_office.checked == true ) {
		var url = "ESD_TRS_0002GS.do?f_cmd="+SEARCH11+"&ctrl_so_office="+prm_office;
		document.form.old_ofc_cd.value = prm_office;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange = subCntorlOffice;
		request.send(null);
	} else {
		document.form.input_office.value = document.form.old_ofc_cd.value;
	}
}

//Office의 값을 가지고 온다.
function subCntorlOffice() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("row-count")[0];
			var subXml = null;
			var text_ofc = "";
			for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
				subXml = docXml.getElementsByTagName("sub-office")[n];
				text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			}
			if( text_ofc.length < 1 ) {
				ComShowMessage("No Data!");
			}
			document.form.input_office.value = text_ofc.substring(0, text_ofc.length-1);
		}
	}
}

//Office-PopUp Validation Checked
function validation_check() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.input_office.value.toUpperCase(), " "); //input text
	var aoffice = prm_office.split(",");
	if( prm_office == "" ) {
		document.form.input_office.value = "";
		ComShowCodeMessage("TRS90522");
		return false;
	}
	if( doc_office.checked == true ) {
		ComShowCodeMessage("TRS90523");
		return false;
	} else {
		if( aoffice.length == 1 ) {
			return true;		
		} else {
			ComShowCodeMessage("TRS90523");
			return false;
		}
	}
}

/**
 * 조회조건 초기화 - new button Click 시
 */
function fn_reset(){

	var formObject = document.form;	

	sheetObjects[0].RemoveAll();  //Master sheet
	formObject.reset();

}

function setScgType(){
	 var formObj = document.form;
	 var scg_type = "";
	 if ( formObj.scg_radio[0].checked == true ) {
		 scg_type = "WO";
	 }else if( formObj.scg_radio[1].checked == true ) {
		 scg_type = "INV";
	 }
	 formObj.scg_type.value = scg_type;	 
}

/*
* 멀티 달력 입력 Pop-Up
*/
function getCalendar() {
	var cal = new ComCalendarFromTo();
	cal.displayType = "date";
	cal.select(document.form.from_date, document.form.to_date, 'yyyy-MM-dd');
}
	/* 개발자 작업  끝 */