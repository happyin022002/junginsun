/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_AOC_3034.js
*@FileTitle : Default Currency Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
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
     * @class ESD_AOC_3034 : esd_aoc_3034 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esd_aoc_3034() {
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

					case "btn_retrieve":
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						break;

					case "btn_country":
						ComOpenPopup('/hanjin/COM_ENS_0M1.do', 565, 480, 'getCountry', "1,0,1,1,1,1,1,1,1,1,1,1", true);
						break;

					case "btn_currency":
						ComOpenPopup('/hanjin/COM_ENS_N13.do', 565, 480, 'getCurrency', "1,0,1,1,1,1,1,1,1,1,1,1", true);
						break;

					case "btn_save":
						doActionIBSheet(sheetObject1, formObject, MULTI01);
						break;

					case "btn_row_add":
						var inx = sheetObject1.DataInsert(-1);
						sheetObject1.CellValue(inx, "sheet1_rhq_cd") = ComGetObjValue(formObject.strRhq_ofc_cd);
						break;

					case "btn_row_delete":
						if(ComShowConfirm(ComGetMsg("COM12165"))){
							var delRows = sheetObject1.FindCheckedRow("sheet1_del_chk");
							var arrRow  = delRows.split("|");
							var uCnt    = 0;
							var dCnt    = 0;
							for (idx=arrRow.length-2; idx>=0; idx--){ 
								if (sheetObject1.RowStatus(arrRow[idx]) == "I" )
								{
									uCnt++;
								}
								sheetObject1.CellValue2(arrRow[idx] , "sheet1_hid_del_chk") = "Y";
								dCnt++;
							}
							ComRowHideDelete(sheetObject1, "sheet1_del_chk");
							if (uCnt != dCnt) {
								doActionIBSheet(sheetObject1, formObject, MULTI02);
							}
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

 	 	//IBMultiCombo초기화
 	    for(var c=0; c<comboObjects.length; c++){
 	        initCombo(comboObjects[c], c+1);
 	    }

		initControl();
		setRHQMultiCombo();

		var formObject = document.form;		
		doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
    }

	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */
	function initCombo(comboObj, comboNo) {
		var i=0;
   	    switch(comboObj.id) {
			case "rhq_cd":
				with(comboObj) {
					comboObj.DropHeight=125;
					comboObj.MultiSelect = true;
					comboObj.MultiSeparator=",";
					comboObj.UseEdit = false;			
					comboObj.enable = false;
					//comboObj.BackColor = "#CCFFFD";
					//comboObj.Code = "";
	        	}
				break;  
		}
	}

	//RHQ MultiCombo 생성
    function setRHQMultiCombo() {
		var formObj = document.form;
		formObj.f_cmd.value = SEARCH01;
		var sParam = FormQueryString(formObj);
		var sXml = sheetObjects[1].GetSearchXml("ESD_AOC_3034GS.do", sParam);
		ComXml2ComboItem(sXml, comboObjects[0], "rhq_cd", "rhq_nm");
		
		comboObjects[0].Code = ComGetObjValue(formObj.strRhq_ofc_cd);
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
                    style.height = 416;
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

					var HeadTitle1 = "|STS|Country\nCode|Country\nName|Continent|Sub Continent|EU Flag|Currency\nCode|Currency\nName|RHQ|Update\nDate|Update\nUser|hid";
					
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    var prefix="sheet1_";
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtCheckBox, 	30, daCenter,	true,	prefix+"del_chk",		false, "", dfNone, 0, true,	true);
	                InitDataProperty(0, cnt++, dtStatus,30,daCenter,false,prefix+"ibflag");
					InitDataProperty(0, cnt++, dtPopupEdit, 64, daCenter,	true,	prefix+"cnt_cd", 		true, "", dfNone, 0, false, true, 2);
					InitDataProperty(0, cnt++, dtData, 	140,	daLeft,		true,	prefix+"cnt_nm", 		false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,		daLeft,		true,	prefix+"conti_nm", 		false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	130,	daLeft,		true,	prefix+"sconti_nm", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,		daCenter,	true,	prefix+"eu_cnt_flg",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtComboEdit, 75,	daCenter,	true,	prefix+"curr_cd", 		true, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 	130,	daLeft,		true,	prefix+"curr_nm", 		false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtCombo, 75,		daCenter,	true,	prefix+"rhq_cd", 		false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,		daCenter,	true,	prefix+"upd_dt", 		false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,		daLeft,		true,	prefix+"upd_usr_id", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,50,	    daLeft,		true,	prefix+"hid_del_chk", 	false, "", dfNone, 0, false, false);

					InitDataValid(0, "sheet1_cnt_cd", vtEngUpOnly, "");
					InitDataValid(0, "sheet1_curr_cd", vtEngUpOnly, "");
					InitDataCombo(0, "sheet1_curr_cd", " |"+po_local_curr_cdCode, " |"+po_local_curr_cdCode);
					InitDataCombo(0, "sheet1_rhq_cd", " |"+f_rhq_cdText , " |"+f_rhq_cdCode);
				}
				break;
        }
    }

	function sheet1_OnChange(sheetObj, Row, Col, Value){
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);
		
		if (sName == "sheet1_cnt_cd" && sheetObj.CellValue(Row , "sheet1_cnt_cd") != "") {
			formObj.f_cmd.value = SEARCH05;
			ComSetObjValue(formObj.sel_cnt_cd, sheetObj.CellValue(Row, "sheet1_cnt_cd"));
			ComSetObjValue(formObj.sel_rhq_cd, formObj.strRhq_ofc_cd.value);
			var sParam = FormQueryString(formObj);
			var sXml = sheetObjects[1].GetSearchXml("ESD_AOC_3034GS.do", sParam);
			var knt = ComGetEtcData(sXml, "knt");
			if(knt!="0"){
				ComSetObjValue(formObj.sel_cnt_cd, sheetObj.CellValue(Row, "sheet1_cnt_cd"));
				 
				formObj.f_cmd.value = SEARCH02;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObjects[1].GetSearchXml("ESD_AOC_3034GS.do", sParam);
				
				if(ComGetEtcData(sXml, "cnt_nm") == "" || ComGetEtcData(sXml, "cnt_nm") == "null"){
					ComShowCodeMessage("COM132201", "Country Code");
					sheetObj.CellValue(Row , "sheet1_cnt_cd") = "";
					sheetObj.CellValue(Row , "sheet1_cnt_nm") = "";
					sheetObj.CellValue(Row , "sheet1_conti_nm") = "";
					sheetObj.CellValue(Row , "sheet1_sconti_nm") = "";
					sheetObj.CellValue(Row , "sheet1_eu_cnt_flg") = "";
					sheetObj.CellValue(Row , "sheet1_curr_cd") = "";
					sheetObj.CellValue(Row , "sheet1_curr_nm") = "";
					sheetObj.SelectCell(Row, "sheet1_cnt_cd", false);
				}else{
					sheetObj.CellValue(Row , "sheet1_cnt_nm") = ComGetEtcData(sXml, "cnt_nm");
					sheetObj.CellValue(Row , "sheet1_conti_nm") = ComGetEtcData(sXml, "conti_nm");
					sheetObj.CellValue(Row , "sheet1_sconti_nm") = ComGetEtcData(sXml, "sconti_nm");
					sheetObj.CellValue(Row , "sheet1_eu_cnt_flg") = ComGetEtcData(sXml, "eu_cnt_flg");
					sheetObj.CellValue(Row , "sheet1_curr_cd") = ComGetEtcData(sXml, "curr_cd");
					sheetObj.CellValue(Row , "sheet1_curr_nm") = ComGetEtcData(sXml, "curr_nm");
				}
			}else if(knt=="0"){
				sheetObj.CellValue(Row , "sheet1_cnt_cd") = "";
				sheetObj.CellValue(Row , "sheet1_cnt_nm") = "";
				sheetObj.CellValue(Row , "sheet1_conti_nm") = "";
				sheetObj.CellValue(Row , "sheet1_sconti_nm") = "";
				sheetObj.CellValue(Row , "sheet1_eu_cnt_flg") = "";
				sheetObj.CellValue(Row , "sheet1_curr_cd") = "";
				sheetObj.CellValue(Row , "sheet1_curr_nm") = "";
				sheetObj.SelectCell(Row, "sheet1_cnt_cd", false);
				ComShowCodeMessage("AOC90038");
			}
		}else if (sName == "sheet1_curr_cd") {
			ComSetObjValue(formObj.sel_curr_cd, Value);
			if(ComGetObjValue(formObj.sel_curr_cd) != ""){
				formObj.f_cmd.value = SEARCH03;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObjects[1].GetSearchXml("ESD_AOC_3034GS.do", sParam);
				
				if(ComGetEtcData(sXml, "curr_nm") == "" || ComGetEtcData(sXml, "curr_nm") == "null"){
					ComShowCodeMessage("COM132201", "Currency Code");
					sheetObj.SelectCell(Row, "sheet1_curr_cd", true);
				}else{
					sheetObj.CellValue(Row , "sheet1_curr_nm") = ComGetEtcData(sXml, "curr_nm");
				}
			}else{
				sheetObj.CellValue(Row , "sheet1_curr_nm") = "";
			}
		}
	}
	
	function sheet1_OnPopupClick(sheetObj, Row, Col)
	{
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);
		
		if (sName == "sheet1_cnt_cd"){
			ComOpenPopup('/hanjin/COM_ENS_0M1.do', 565, 480, 'getGridCountry', "1,0,1,1,1,1,1,1,1,1,1,1", true);
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
					var sXml = sheetObj.GetSearchXml("ESD_AOC_3034GS.do", sParam);
					if(sXml.length>0){
						sheetObj.LoadSearchXml(sXml);
					}
				}	
				break;

			case MULTI01: //Save
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = MULTI01;
					sheetObj.DoSave("ESD_AOC_3034GS.do", AocFrmQryString(formObj), -1,false);
//					var sParam =  ComGetSaveString(sheetObj, true, false);
//					if( sParam == ""){ return;}
//					var sXml = sheetObj.GetSaveXml("ESD_AOC_3034GS.do", FormQueryString(formObj) + "&" + sParam, true);	        			
//					sheetObj.LoadSaveXml(sXml);
				}	
				break;

			case MULTI02: //Delete
				formObj.f_cmd.value = MULTI02;
				sheetObj.DoSave("ESD_AOC_3034GS.do", AocFrmQryString(formObj), "sheet1_hid_del_chk",true);
				break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
			case IBSEARCH:
				break;

			case MULTI01:
				if( sheetObj.RowCount < 1 ){
					ComShowCodeMessage("COM130503");
					return false;
				}else{
					//중복체크
	            	var idxDub = sheetObj.ColValueDup("sheet1_cnt_cd");
	            	if(idxDub > -1){
	            		ComShowCodeMessage("COM12115","[Country Code]");
	            		sheetObj.SelectCell(idxDub, "sheet1_cnt_cd", true);
	            		return false;
	            	}
				}
				break;
		}
        return true;
    }

	function rhq_cd_OnKeyDown(combo, keycode, shift){
		var formObj = document.form;
		var objs = document.all.item("tabLayer");
		if(keycode == 13){
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		}
	}
    /* initControl() */
    function initControl() {
    	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
    	axon_event.addListenerForm('blur', 'obj_deactivate', form);
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
			case "uppernum":
				// 영문 대문자만 입력하기, 영문대+숫자
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "upper":
				// 영문 대문자만 입력하기
				ComKeyOnlyAlphabet('upper');
				break;
        	case "ymd":
        		ComKeyOnlyNumber(event.srcElement);
            	break;
			case "engupcomma":	//영문대문자+Comma
				ComKeyOnlyAlphabet('upper', '44');
            	break;
     	}
    }    
    
    //업무 자바스크립트 Onblur 이벤트 처리
    function obj_deactivate(){
     	var elementObj = event.srcElement;
		var formObj = document.form;
	
	 	switch(elementObj.name){ 	    	
	 		case "cnt_cd":
	 			if(!isNull(elementObj.value)){
	 				formObj.f_cmd.value = SEARCH03;
					var sXml = sheetObjects[1].GetSearchXml("ESD_AOC_3001GS.do", FormQueryString(formObj), true);
					var err_flg = ComGetEtcData(sXml, "err_flg");
					
					if( err_flg == "Y" ){
						//ComShowCodeMessage("COM132201", "Country Code");
						//ComAlertFocus(formObj.cnt_cd, "");
						alert("Country Code is invalid.");
						document.form.cnt_cd.value = "";
						document.form.cnt_cd.focus();
						return false;
					}
	 			}
	 			break;
	 		case "curr_cd":
	 			if(!isNull(elementObj.value)){
	 				formObj.f_cmd.value = SEARCH04;
					var sXml = sheetObjects[1].GetSearchXml("ESD_AOC_3034GS.do", FormQueryString(formObj), true);
					var err_flg = ComGetEtcData(sXml, "err_flg");
					
					if( err_flg == "Y" ){
						//ComShowCodeMessage("COM132201", "Currency Code");
						//ComAlertFocus(formObj.curr_cd, "");
						alert("Currency Code is invalid.");
						document.form.curr_cd.value = "";
						document.form.curr_cd.focus();
						return false;
					}
	 			}
	 			break;
	 	}	
    }
	

	function getCountry(rowArray) {
		var colArray = rowArray[0];
		if( document.form.cnt_cd.value != ""){
			document.form.cnt_cd.value = document.form.cnt_cd.value + "," + colArray[3];
		} else{
			document.form.cnt_cd.value = colArray[3];
		}
		document.form.cnt_cd.focus();
	}
	
	function getCurrency(rowArray) {
		var colArray = rowArray[0];
		if( document.form.curr_cd.value != ""){
			document.form.curr_cd.value = document.form.curr_cd.value + "," + colArray[3];
		} else{
			document.form.curr_cd.value = colArray[3];
		}
		document.form.curr_cd.focus();
	}
	
	function getGridCountry(rowArray) {
		var colArray = rowArray[0];
		sheetObjects[0].CellValue(sheetObjects[0].SelectRow , "sheet1_cnt_cd") = colArray[3];
	}	
	
	/**
	* 팝업호출
	*/
	function so_OnPopupClick(val) {
		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId ="getCOM_ENS_so";
		var xx1=val;  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";
		var title = val;
		if (val == "sw" ) {
			if(formObject.radio_gubun[0].checked)  {
				title = "S/O No.";
			} else {
				title = "W/O No.";
			}
		}
		var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&returntitle="+title;
		ComOpenPopup('/hanjin/ESD_TRS_0906.do' + param, 412, 330, 'getCOM_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
	}
	
	/**
	* Multi Select
	*/
	function getTRS_ENS_906(rowArray,returnval) {
		var formObject = document.form;
	
		if(returnval=="Country") {
			var x1=document.form.cnt_cd.value;
			if(x1==""){
				document.form.cnt_cd.value = rowArray;
			}else{
				document.form.cnt_cd.value = document.form.cnt_cd.value+","+rowArray;
			}
			document.form.cnt_cd.value = document.form.cnt_cd.value.toUpperCase()
			formObject.cnt_cd.focus();
		}else if(returnval=="Currency") {
			var x1=document.form.curr_cd.value;
			if(x1==""){
				document.form.curr_cd.value = rowArray;
			}else{
				document.form.curr_cd.value = document.form.curr_cd.value+","+rowArray;
			}
			document.form.curr_cd.value = document.form.curr_cd.value.toUpperCase()
			formObject.curr_cd.focus();
		}
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
	
	function rhq_cd_OnCheckClick(comboObj, index, code) {
		if( code == "" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Code = "";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Code = "";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}
	/* 개발자 작업  끝 */