/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VOP_VSK_0080.js
*@FileTitle : Indivisual Setup Screen - Notification for Vessel Schedule Change
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.15
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2013.07.15 정상기
* 1.0 Creation
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
     * @class vop_vsk_0080 : vop_vsk_0080 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */


	function vop_vsk_0080() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	}
    
   	/* 개발자 작업	*/

	// 공통전역변수

	var sheetObjects = new Array();
	var sheetCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 
		 var sheetObject = sheetObjects[0];
		 
		 /*******************************************************/
		 var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				
				case "btn_Retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
					
				case "btn_New":
					formObject.lane_cd.value	= "";
					formObject.port_cd.value	= "";
					sheetObject.RemoveAll();
					break;						
					
				case "btn_Save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;				
					
				case "btn_port":
					doActionIBSheet(sheetObject,formObject,COMMAND12);
					break;
					
				case "btn_lane_cd":
					doActionIBSheet(sheetObject,formObject,COMMAND02);
					break;
					
				case "btn_RowAdd":
					var inx 	= sheetObject.DataInsert(-1);
					var prefix	= sheetObject.id+"_";
					
					//sheetObject.CellValue2(sheetObject.SelectRow, prefix+"eta_dlay_fm_mark")	= "<";
					//sheetObject.CellValue2(sheetObject.SelectRow, prefix+"eta_dlay_fixmark")	= "PFS";
					//sheetObject.CellValue2(sheetObject.SelectRow, prefix+"eta_dlay_to_mark")	= "<";

					//sheetObject.CellValue2(sheetObject.SelectRow, prefix+"etb_dlay_fm_mark")	= "<";
					//sheetObject.CellValue2(sheetObject.SelectRow, prefix+"etb_dlay_fixmark")	= "PFS";
					//sheetObject.CellValue2(sheetObject.SelectRow, prefix+"etb_dlay_to_mark")	= "<";
					
					//sheetObject.CellValue2(sheetObject.SelectRow, prefix+"etd_dlay_fm_mark")	= "<";
					//sheetObject.CellValue2(sheetObject.SelectRow, prefix+"etd_dlay_fixmark")	= "PFS";
					//sheetObject.CellValue2(sheetObject.SelectRow, prefix+"etd_dlay_to_mark")	= "<";
					
					sheetObject.CellValue2(sheetObject.SelectRow, prefix+"aply_flg")			= "1";
					sheetObject.CellValue2(sheetObject.SelectRow, prefix+"login_usr_id")		= formObject.login_usr_id.value;
					
					break;

				case "btn_RowDelete":
					var prefix	= sheetObject.id+"_";
					
					//alert('HeaderRows ['+sheetObject.HeaderRows+'], LastRows ['+sheetObject.LastRow+']');
					
					for(var i=sheetObject.HeaderRows; i<=sheetObject.LastRow; i++){
						if(sheetObject.CellValue(i, prefix+"chk") == "1"){
							//alert('HeaderRows ['+sheetObject.HeaderRows+'], LastRows ['+sheetObject.LastRow+'], seleted rows ['+i+']');
							sheetObject.RowHidden(i) = true;
							sheetObject.CellValue2(i, prefix+"ibflag")	= "D";
						}
					}
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

			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		initControl();
		
		document.form.lane_cd.focus();
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
	                    style.height = 440;
	                    //전체 너비 설정
	                    SheetWidth = mainTable.clientWidth;

	                    //Host정보 설정[필수][HostIp, Port, PagePath]
	                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	                    //전체Merge 종류 [선택, Default msNone]
	                    MergeSheet = msHeaderOnly;
	                    //MergeSheet = msAll;
	                    
	                    //전체Edit 허용 여부 [선택, Default false]
	                    Editable = true;

	                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                    InitRowInfo(2, 1, 3, 100);

						var HeadTitle1 = "STS|CHK|Lane|Port|dir|port|||||ETA|ETA|ETB|ETB|ETD|ETD|Skip|Reverse\nCall|Apply|USR|UPD ID|Update DT";
						var HeadTitle2 = "STS|CHK|Lane|Port|dir|port|org|org|org|org|Advance(-)|Delay(+)|Advance(-)|Delay(+)|Advance(-)|Delay(+)|Skip|Reverse\nCall|Apply|USR|UPD ID|Update DT";
						var headCount = ComCountHeadTitle(HeadTitle1);

	                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                    InitColumnInfo(headCount, 0, 0, true);

	                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                    InitHeadMode(false, false, false, true, false, false);

	                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                    InitHeadRow(0, HeadTitle1, true, false);
	                    InitHeadRow(1, HeadTitle2, true, false);
	                    
						var prefix	= "sheet1_";
	                    //데이터속성        [ROW, COL   , DATATYPE,    WIDTH, 	DATAALIGN, COLMERGE,SAVENAME					,  KEYFIELD,    CALCULOGIC	, DATAFORMAT, 	   POINTCOUNT, 	UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                    //InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	false,	prefix+"ibflag");
	                    InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,	prefix+"ibflag");
	                    InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,	prefix+"chk"				,	false,		""			,	dfNone,			0,			true,		true	);
	                    
	                    InitDataProperty(0, cnt++ , dtPopupEdit,	70,		daCenter,	true,	prefix+"vsl_slan_cd"		,	false,		""			,	dfEngUpKey,		0,			true,		true, 3	);
	                    InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,	true,	prefix+"dir_port_desc"		,	false,		""			,	dfNone,			0,			true,		true	);
	                    InitDataProperty(0, cnt++ , dtHidden,		35,		daCenter,	true,	prefix+"skd_dir_cd"			,	false,		""			,	dfNone,			0,			true,		true	);
	                    InitDataProperty(0, cnt++ , dtHidden,		55,		daCenter,	true,	prefix+"vps_port_cd"		,	false,		""			,	dfNone,			0,			true,		true	);
	                    
	                    //=========== PRIMARY KEY SET ========================================================================================
	                    InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	prefix+"org_vsl_slan_cd"		,	false,		""			,	dfEngUpKey,		0,			true,		true, 3	);
	                    InitDataProperty(0, cnt++ , dtHidden,		35,		daCenter,	true,	prefix+"org_skd_dir_cd"			,	false,		""			,	dfNone,			0,			true,		true	);
	                    InitDataProperty(0, cnt++ , dtHidden,		55,		daCenter,	true,	prefix+"org_vps_port_cd"		,	false,		""			,	dfNone,			0,			true,		true	);
	                    InitDataProperty(0, cnt++ , dtHidden,		55,		daCenter,	true,	prefix+"pk_modi_flg"			,	false,		""			,	dfNone,			0,			true,		true	);
	                    //=========== PRIMARY KEY SET ========================================================================================	                    
	                    
	                    InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefix+"eta_dlay_fm_hrs"	,	false,		""			,	dfNullInteger,	0,			true,		true, 3	);
	                    //InitDataProperty(0, cnt++ , dtHidden,		20,		daCenter,	true,	prefix+"eta_dlay_fm_mark"	,	false,		""			,	dfNone,			0,			false,		false	);
	                    //InitDataProperty(0, cnt++ , dtHidden,		35,		daCenter,	true,	prefix+"eta_dlay_fixmark"	,	false,		""			,	dfNone,			0,			false,		false	);
	                    //InitDataProperty(0, cnt++ , dtHidden,		20,		daCenter,	true,	prefix+"eta_dlay_to_mark"	,	false,		""			,	dfNone,			0,			false,		false	);
	                    InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefix+"eta_dlay_to_hrs"	,	false,		""			,	dfNullInteger,	0,			true,		true, 3	);
	                    
	                    InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefix+"etb_dlay_fm_hrs"	,	false,		""			,	dfNullInteger,	0,			true,		true, 3	);
	                    //InitDataProperty(0, cnt++ , dtHidden,		20,		daCenter,	true,	prefix+"etb_dlay_fm_mark"	,	false,		""			,	dfNone,			0,			false,		false	);
	                    //InitDataProperty(0, cnt++ , dtHidden,		35,		daCenter,	true,	prefix+"etb_dlay_fixmark"	,	false,		""			,	dfNone,			0,			false,		false	);
	                    //InitDataProperty(0, cnt++ , dtHidden,		20,		daCenter,	true,	prefix+"etb_dlay_to_mark"	,	false,		""			,	dfNone,			0,			false,		false	);
	                    InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefix+"etb_dlay_to_hrs"	,	false,		""			,	dfNullInteger,	0,			true,		true, 3	);
	                    
	                    InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefix+"etd_dlay_fm_hrs"	,	false,		""			,	dfNullInteger,	0,			true,		true, 3	);
	                    //InitDataProperty(0, cnt++ , dtHidden,		20,		daCenter,	true,	prefix+"etd_dlay_fm_mark"	,	false,		""			,	dfNone,			0,			false,		false	);
	                    //InitDataProperty(0, cnt++ , dtHidden,		35,		daCenter,	true,	prefix+"etd_dlay_fixmark"	,	false,		""			,	dfNone,			0,			false,		false	);
	                    //InitDataProperty(0, cnt++ , dtHidden,		20,		daCenter,	true,	prefix+"etd_dlay_to_mark"	,	false,		""			,	dfNone,			0,			false,		false	);
	                    InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefix+"etd_dlay_to_hrs"	,	false,		""			,	dfNullInteger,	0,			true,		true, 3	);
	                    
	                    InitDataProperty(0, cnt++ , dtCheckBox,		80,		daCenter,	true,	prefix+"skp_clpt_tgt_flg"	,	false,		""			,	dfNone,			0,			true,		true	);
	                    //InitDataProperty(0, cnt++ , dtCheckBox,		65,		daCenter,	true,	prefix+"rvs_clpt_tgt_flg"	,	false,		""			,	dfNone,			0,			true,		true	);
	                    InitDataProperty(0, cnt++ , dtHidden,		65,		daCenter,	true,	prefix+"rvs_clpt_tgt_flg"	,	false,		""			,	dfNone,			0,			true,		true	);

	                    InitDataProperty(0, cnt++ , dtCheckBox	,	80,		daCenter,	true,	prefix+"aply_flg"			,	false,		""			,	dfNone,			0,			true,		true	);
	                    InitDataProperty(0, cnt++ , dtHidden	,	60,		daCenter,	true,	prefix+"login_usr_id"		,	false,		""			,	dfNone,			0,			false,		false	);
	                    InitDataProperty(0, cnt++ , dtHidden	,	60,		daCenter,	true,	prefix+"upd_usr_id"			,	false,		""			,	dfNone,			0,			false,		false	);
	                    InitDataProperty(0, cnt++ , dtData		,	90,		daCenter,	true,	prefix+"upd_dt"				,	false,		""			,	dfNone,			0,			false,		false	);

						//CountPosition = 0;
	                    
	                    //sheetObj.CellComboitem()
	                    
	                    //CountFormat = "[SELECTDATAROW / ROWCOUNT]";
	                    
	                    InitDataValid(0, prefix+"vsl_slan_cd"	, vtEngUpOther, "123456789");	//dfEngUpKey - vtEngUpOnly
	                    InitDataCombo(0, prefix+"dir_port_desc"	, "", "");
	                    
	                    //MaximumValue(0, prefix+"eta_dlay_fm_hrs") = "0";
	                    //MaximumValue(0, prefix+"etb_dlay_fm_hrs") = "0";
	                    //MaximumValue(0, prefix+"etd_dlay_fm_hrs") = "0";
	                    //MinimumValue(0, prefix+"eta_dlay_to_hrs") = "0";
	                    //MinimumValue(0, prefix+"etb_dlay_to_hrs") = "0";
	                    //MinimumValue(0, prefix+"etd_dlay_to_hrs") = "0";
	                    
	                    ////ColHidden("sheet1_vir_skd_sts_cd") = true;
	                    
					}
	                break;	
				
		}
	}
	
	

	/*
	 * =====================================================================
	 * Object Event
	 * =====================================================================
	 */
	
	function initControl() {
    	//Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm('activate'	, 'obj_activate', form);
    	axon_event.addListenerForm('blur'		, 'obj_blur'	, form);
    	axon_event.addListenerForm('change'		, 'obj_change'	, form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onchange 이벤트에 코드 처리
    	axon_event.addListenerForm('keypress'	, 'obj_keypress', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    	axon_event.addListenerForm('keyup'		, 'obj_keyup'	, form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeyup 이벤트에 코드 처리
    	axon_event.addListenerForm('keydown'	, 'obj_keydown'	, form);
	}
    
	function obj_change(){
		var formObj = document.form;
		
	    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	    var sheetObj = sheetObjects[0];
	    /*******************************************************/
		try {
			var eleObj 	= window.event.srcElement;
			var srcName = eleObj.getAttribute("name");
			checkObj(srcName);
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
			} else {
				ComShowMessage(e);
			}
		}
		
	}
	
	function obj_keypress(){
		var formObj = document.form;
		switch (event.srcElement.name) 
		{
		    case "lane_cd":
		    	ComKeyOnlyAlphabet('uppernum');
				break;
	
			case "port_cd":
		    	ComKeyOnlyAlphabet('uppernum');
				break;

		}
	}
	
	function obj_keyup(){
		var eleObj 	= event.srcElement;
		var formObj = document.form;
		
		switch (eleObj.name) 
		{
		    case "lane_cd":
		    	if(eleObj.value.length == 3){
		    		formObj.port_cd.focus();
		    	} 
				break;    
			case "port_cd":
		    	if(eleObj.value.length == 5){
		    		//formObj.vsl_cd.focus();
		    	}
				break; 

		}
	}
	
	function obj_activate() {
		var srcName = event.srcElement.name;
		
		switch(srcName){
			case "fm_dt":
			case "to_dt":
			case "fm_wk":
			case "to_wk":
				ComClearSeparator(event.srcElement); // 입력시 마스크 안보이기
				event.srcElement.select();
				break;
		}
	}
	
	function obj_blur(){
		var srcName = event.srcElement.name;
		
		switch(srcName){
			case "fm_dt":
			case "to_dt":
			case "fm_wk":
			case "to_wk":
				ComChkObjValid(event.srcElement);
				break;
		}
	}
	
	function obj_keydown() {
		var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		//Enter event
		if(keyValue == 13){
			var flg = 0;
			var srcName = event.srcElement.name;
			switch(srcName){
			
				case "lane_cd":
				case "port_cd":
					
					if(!checkObj(srcName)){
						flg = 1;
					}
					break;

			}
			//올바르지 않은 조회조건을 넣었을 때는 조회하지 않는다.
			if(flg != 1){
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
		}
	}
	

 	function checkObj(srcName){
		var formObj 	= document.form;
		
	    var sheetObj 	= sheetObjects[0];
        switch(srcName) 
        {
	        case "lane_cd":
	        	
	        	if(isCheckVslSlanCd(sheetObj, formObj.lane_cd.value, "search")){
	        		formObj.port_cd.focus();
	        		return true;
	        	}else{
	        		formObj.lane_cd.value = "";
	        		formObj.lane_cd.focus();
	        		return false;
	        	}
	        	break;

	        case "port_cd":
	            	var portCd = formObj.port_cd.value;
	            	
	            	//alert('checkObj :: --- port_cd >> ['+portCd+']');
	            	
	            	if(portCd != ""){
	            		//formObj.port_cd.value = portCd;
						////var sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
						var sXml = doActionIBSheet(sheetObj, formObj, COMMAND12);
						
						//alert('checkObj.port_cd::sXml >>> ['+sXml+']');
						
						if(!isCheckPortForm(sheetObj, formObj, sXml)){
							formObj.port_cd.value = "";
							formObj.port_cd.focus();
							return false;
						}
	            	}
	            	break;

        } // end switch
	}

	function sheet1_OnChange(sheetObj, Row, Col, Value){
		var colSaveName = sheetObj.ColSaveName(Col);
		var formObj 	= document.form;
		
		//alert('sheet1 onchange row ['+Row+'], col = ['+Col+'], Value ['+Value+']');
		
		switch(colSaveName){
			case "sheet1_vsl_slan_cd":

				//alert('sheet1_vsl_slan_cd  on change...');
				//checkObj("lane_cd");
				
				var	isResult	= isCheckVslSlanCd(sheetObj, sheetObj.CellValue(Row, Col), "grid");
				
				if(isResult == true){
					
					var sXml = doActionIBSheet(sheetObj, formObj, SEARCH12);
					//sheetObj.CellComboItem(sheetObj.HeaderRows+i, prefix+"yd_cd", ydCdsArr[i], ydCdsArr[i]);
					

/*					var SkdDirList 	= ComGetEtcData(sXml, "SkdDirList").split("|");
					if(SkdDirList != null && SkdDirList != undefined && SkdDirList != ""){
						for(var i=0 ; i < SkdDirList.length ; i++ ){
							SkdDirListArr[i] = SkdDirList[i];
						}
					}	
					var PortList 	= ComGetEtcData(sXml, "PortList").split("|");
					if(PortList != null && PortList != undefined && PortList != ""){
						for(var i=0 ; i < PortList.length ; i++ ){
							PortListArr[i] = PortList[i];
						}
					}
					
					sheetObj.CellComboItem(sheetObj.HeaderRows+i, "sheet1_vps_port_cd", SkdDirListArr, PortListArr);*/
					
					var skdDirList 		= ComGetEtcData(sXml, "SkdDirList");
					var portList 		= ComGetEtcData(sXml, "PortList");
					var skdDirPortTxt	= "";					
					
					//alert('SkdDirList >> ['+SkdDirList+']');
					//alert('PortList >> ['+PortList+']');
					
					if(skdDirList != null && skdDirList != undefined && skdDirList != ""){
						var arrSkdDirList 	= skdDirList.split("|");
						var arrPortList		= portList.split("|");
						
						////skdDirPortTxt		= arrSkdDirList[0] + "\t" + arrPortList[0];
						
						skdDirPortTxt		= "";
						for(var i=0; i<arrSkdDirList.length; i++){
							
							//alert('skdDirPortTxt >> ['+skdDirPortTxt+']');
							
							////skdDirPortTxt 	= skdDirPortTxt + "|" + arrSkdDirList[i] + " - " + arrPortList[i] + "\t" + arrSkdDirList[i] + arrPortList[i];
							skdDirPortTxt 	= skdDirPortTxt + "|" + arrSkdDirList[i] + " - " + arrPortList[i];
						}
						
						//alert('skdDirPortTxt >> ['+skdDirPortTxt+']');
						
						sheetObj.CellComboItem(sheetObj.SelectRow, "sheet1_dir_port_desc", skdDirPortTxt, skdDirPortTxt, 0);		
						
						//sheetObjects[0].CellComboItem(i, "bkg_no", sheetObjects[0].CellValue(i, "bkg_no_list_ctnt"), sheetObjects[0].CellValue(i, "bkg_no_list_ctnt") );
					}
					
				}else{
					sheetObj.CellValue2(sheetObj.SelectRow, "sheet1_vsl_slan_cd")	= "";
				}
				break;
				
			case "sheet1_dir_port_desc":
				
				sheetObj.CellValue2(sheetObj.SelectRow, "sheet1_skd_dir_cd")	= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_dir_port_desc").substring(0,1);
				sheetObj.CellValue2(sheetObj.SelectRow, "sheet1_vps_port_cd")	= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_dir_port_desc").substring(4);
				
				break;
				
			case "sheet1_eta_dlay_fm_hrs":
			case "sheet1_etb_dlay_fm_hrs":
			case "sheet1_etd_dlay_fm_hrs":
				
				if(parseInt(Value)>0){
					//::VSK02005::Pls input hours as negative number for advance:://
					ComShowCodeMessage('VSK02005');
					sheetObj.CellValue2(Row,Col)	= "";
					sheetObj.SelectCell(Row,Col);
					return false;
				}
				break;
				
			case "sheet1_eta_dlay_to_hrs":
			case "sheet1_etb_dlay_to_hrs":
			case "sheet1_etd_dlay_to_hrs":
				
				if(parseInt(Value)<0){
					//::VSK02006::Pls input hours as positive number for delay:://
					ComShowCodeMessage('VSK02006');
					sheetObj.CellValue2(Row,Col)	= "";
					sheetObj.SelectCell(Row,Col);					
					return false;
				}
				break;				
				
				
		}
	}
	
    /**
     * 로우를 클릭 했을 때 이벤트 처리
  	*/ 
 	function sheet1_OnClick(sheetObj,Row,Col,Value) {
		
 		if(sheetObj.ColSaveName(Col) == "sheet1_dir_port_desc"){
 			
 			//////////////////////////////////////////////////////////
 			
 			var vsl_slan_cd	= sheetObj.CellValue(Row,"sheet1_vsl_slan_cd");
 			var	isResult	= isCheckVslSlanCd(sheetObj, vsl_slan_cd, "grid");
			
 			//alert('value >>> '+vsl_slan_cd+', isResult >>'+isResult);
 			
			if(isResult == true){
				
				var sXml 			= doActionIBSheet(sheetObj, document.form, SEARCH12);
				var skdDirList 		= ComGetEtcData(sXml, "SkdDirList");
				var portList 		= ComGetEtcData(sXml, "PortList");
				var skdDirPortTxt	= "";		
				
				if(skdDirList != null && skdDirList != undefined && skdDirList != ""){
					var arrSkdDirList 	= skdDirList.split("|");
					var arrPortList		= portList.split("|");
					skdDirPortTxt		= "";

					for(var i=0; i<arrSkdDirList.length; i++){
						skdDirPortTxt 	= skdDirPortTxt + "|" + arrSkdDirList[i] + " - " + arrPortList[i];
					}
					
					sheetObj.CellComboItem(Row, "sheet1_dir_port_desc", skdDirPortTxt, skdDirPortTxt, 0);		
				}
			} 			
 			
 			//////////////////////////////////////////////////////////
 			
 			
 		}
 		
 		
 				
 		
 		
 	} 	
	
	 function sheet1_OnPopupClick(sheetObj, Row, Col){

		var laneCd 			= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_vsl_slan_cd");
		var newVslSlanCd	= ComOpenPopupWithTarget('/hanjin/VOP_VSK_0202.do?vsl_slan_cd='+laneCd, 420, 470, "", "0,1", true);			
		
		if(newVslSlanCd){
			sheetObj.CellValue(Row, "sheet1_vsl_slan_cd") = newVslSlanCd;
			saveRows.push(Row);
		}
	}
	 
	 
	 
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg 	= false;
		//var sheetID 			= sheetObj.id;
		var prefix				= sheetObj.id+"_";
		var sUrl 				= "";
		
		switch(sAction) {

		   case IBSEARCH:      //조회
				////if(validateForm(sheetObj,formObj,sAction)){
		   
					formObj.f_cmd.value = SEARCH;
					////var sParam 	= FormQueryString(formObj);
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					var sXml 	= sheetObj.GetSearchXml("VOP_VSK_0080GS.do", sParam);
					
					
					sheetObj.LoadSearchXml(sXml);
					//showSheetData(sheetObj,formObj,sXml);
					
					ComOpenWait(false);
					
					//alert(sXml);
					
			        //var arrXml = sXml.split("|$$|");
			        
			        //alert(arrXml);

					//submitFlg = "Y";
/*					for(var inx=0; inx<arrXml.length; inx++){
						showSheetData(sheetObjects[inx],formObj,arrXml[inx], "N");
					}*/

					//var lastPos = sheetObjects[1].RowCount+sheetObjects[1].HeaderRows;
					//setlastLowView(sheetObjects[1],lastPos);					
					
					
					////
				////}

				break;
				
		   case IBSAVE:      //저장
				if(validateForm(sheetObj,formObj,sAction)){
					
					/*====================================================
					 * PRIMARY KEY (VSL_SLAN_CD+SKD_DIR_CD+VPS_PORT_CD)
					 * 변경대상 구분자 SETTING
					 *====================================================
					 */
					 
					var prefix	= sheetObj.id+"_";
					
					for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++)
					{
						
						var	grid_vsl_slan_cd		= sheetObj.CellValue(i, prefix+"vsl_slan_cd");
						var	grid_vps_port_cd		= sheetObj.CellValue(i, prefix+"vps_port_cd");
						var	grid_skd_dir_cd			= sheetObj.CellValue(i, prefix+"skd_dir_cd");
						
						var	grid_org_vsl_slan_cd	= sheetObj.CellValue(i, prefix+"org_vsl_slan_cd");
						var	grid_org_vps_port_cd	= sheetObj.CellValue(i, prefix+"org_vps_port_cd");
						var	grid_org_skd_dir_cd		= sheetObj.CellValue(i, prefix+"org_skd_dir_cd");

						if(grid_org_vsl_slan_cd != "" && grid_org_vps_port_cd != "" && grid_org_skd_dir_cd != ""){
							if(grid_vsl_slan_cd != grid_org_vsl_slan_cd || grid_vps_port_cd != grid_org_vps_port_cd || grid_skd_dir_cd != grid_org_skd_dir_cd){
								sheetObj.CellValue2(i,prefix+"pk_modi_flg")	= "Y";
							}
						}
					}						
					/*================================================*/
					
			   		formObj.f_cmd.value = MULTI;
			   		var sParam 		= FormQueryString(formObj);
					ComOpenWait(true);
					
					//sheetObj.showDebugMsg	= true;
					var sXml 	= sheetObj.GetSaveXml("VOP_VSK_0080GS.do", sParam + "&" + ComGetSaveString(sheetObj));
					//sheetObj.showDebugMsg	= false;
					
		     	   	if(sXml.length>0) sheetObj.LoadSearchXml(sXml);  	   	
		     		doActionIBSheet(sheetObj, formObj, IBSEARCH);	
					
					ComOpenWait(false);			
					
				}
	
				break;				
				
			case SEARCH04:				//Lane Check
				////if(validateForm(sheetObj,formObj,sAction)){
		        	formObj.f_cmd.value = SEARCH03;
					var sParam 			= FormQueryString(formObj);
					var sXml 			= sheetObj.GetSearchXml("VSK_COMGS.do", sParam);
					
					//alert('Lane Check >> ['+sXml+']');
					
					return sXml;
				////}
				break;	
				
			case COMMAND12:      //Port Check
				////if(validateForm(sheetObj, formObj, sAction)){
					var sXml 				= null;
					formObj.f_cmd.value 	= COMMAND12;
					formObj.loc_cd.value	= formObj.port_cd.value;
					var sParam 				= FormQueryString(formObj);
					
					//sheetObj.showDebugMsg	= true;
					sXml 					= sheetObj.GetSearchXml("VSK_COMGS.do", sParam);
					//sheetObj.showDebugMsg	= false;
					
					//alert('Port Check (COMMAND12) >> ['+sXml+']');
					
					return sXml;
				break;	
				
			case SEARCH12:      //All SKD_DIR_CD+PORT_CD List for Proforma

				var sXml 					= null;
				formObj.f_cmd.value 		= SEARCH12;
				formObj.slan_cd.value		= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_vsl_slan_cd");
				var sParam 					= FormQueryString(formObj);
				
				//sheetObj.showDebugMsg		= true;
				sXml 						= sheetObj.GetSearchXml("VSK_COMGS.do", sParam);
				//sheetObj.showDebugMsg		= false;
				
				//alert('All SKD_DIR_CD+PORT_CD List (SEARCH12) >> ['+sXml+']');
				
				return sXml;
				break;				

			case COMMAND01:      // Port Pop-up
				sUrl = "/hanjin/VOP_VSK_0043.do";
				ComOpenPopup(sUrl, 422, 520, "returnPortHelp", "0,0", true);
				break;
				
			case COMMAND02:      // Lane Pop-up
				sUrl = "/hanjin/VOP_VSK_0202.do?vsl_slan_cd=" + formObj.vsl_slan_cd.value;
				ComOpenPopup(sUrl, 422, 470, "returnLaneCdHelp", "0,0", true);
				break;
		}
	}

	/*
	 * 선처리 CSR(SRM-201011796) Port 필수입력해제, 기간 제한 1년확대
	 */
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){

		 var prefix	= sheetObj.id+"_";
		 
		 switch(sAction) {
		 	case IBSAVE:      //저장
			
		 		//alert('HEADER >> '+sheetObj.HeaderRows+', LastRow >>> '+sheetObj.LastRow);
		 	
		 		if(sheetObj.LastRow-sheetObj.HeaderRows < 0){
					ComShowCodeMessage('VSK57017');
					return false;
		 		}
		 	
				for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++)
				{
					
					var	grid_vsl_slan_cd	= sheetObj.CellValue(i, prefix+"vsl_slan_cd");
					var	grid_vps_port_cd	= sheetObj.CellValue(i, prefix+"vps_port_cd");
					var	grid_skd_dir_cd		= sheetObj.CellValue(i, prefix+"skd_dir_cd");
					
					if(grid_vsl_slan_cd == ""){
						ComShowCodeMessage('VSK00027', "Lane");
						return false;
					}
					if(grid_vps_port_cd == ""){
						ComShowCodeMessage('VSK00027', "Port");
						return false;
					}
					if(grid_skd_dir_cd == ""){
						ComShowCodeMessage('VSK00027', "Port");
						return false;
					}		
					
					var grid_keyfield			= sheetObj.CellValue(i, prefix+"vsl_slan_cd")+" "+sheetObj.CellValue(i, prefix+"vps_port_cd")+"-"+sheetObj.CellValue(i, prefix+"skd_dir_cd");
					var	grid_eta_dlay_fm_hrs	= sheetObj.CellValue(i, prefix+"eta_dlay_fm_hrs");
					var	grid_eta_dlay_to_hrs	= sheetObj.CellValue(i, prefix+"eta_dlay_to_hrs");
					var	grid_etb_dlay_fm_hrs	= sheetObj.CellValue(i, prefix+"etb_dlay_fm_hrs");
					var	grid_etb_dlay_to_hrs	= sheetObj.CellValue(i, prefix+"etb_dlay_to_hrs");
					var	grid_etd_dlay_fm_hrs	= sheetObj.CellValue(i, prefix+"etd_dlay_fm_hrs");
					var	grid_etd_dlay_to_hrs	= sheetObj.CellValue(i, prefix+"etd_dlay_to_hrs");
					
					//alert((grid_eta_dlay_fm_hrs));
					
					if((grid_eta_dlay_fm_hrs != "" && grid_eta_dlay_to_hrs != "") && (parseInt(grid_eta_dlay_fm_hrs) >= parseInt(grid_eta_dlay_to_hrs))){
						ComShowCodeMessage('VSK57018', "from hrs", "to hrs", "ETA of "+grid_keyfield);
						sheetObj.SelectCell(i, prefix+"eta_dlay_fm_hrs");
						return false;						
					}
					if((grid_etb_dlay_fm_hrs != "" && grid_etb_dlay_to_hrs != "") && (parseInt(grid_etb_dlay_fm_hrs) >= parseInt(grid_etb_dlay_to_hrs))){
						ComShowCodeMessage('VSK57018', "from hrs", "to hrs", "ETB of "+grid_keyfield);
						sheetObj.SelectCell(i, prefix+"etb_dlay_fm_hrs");
						return false;						
					}
					if((grid_etd_dlay_fm_hrs != "" && grid_etd_dlay_to_hrs != "") && (parseInt(grid_etd_dlay_fm_hrs) >= parseInt(grid_etd_dlay_to_hrs))){
						ComShowCodeMessage('VSK57018', "from hrs", "to hrs", "ETD of "+grid_keyfield);
						sheetObj.SelectCell(i, prefix+"etd_dlay_fm_hrs");
						return false;						
					}					
				}	

		 	case IBSEARCH:
		 		
		 		return true;
    	
		 }
	}
	
	/**
     * 조회 후 처리로직.
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @return
     */
	function showSheetData(sheetObj, formObj, sXml){
		var prefix = "sheet1_";
		
		//alert('sXml >>> \n\n'+sXml);
		
		if(sXml != null){
			var rootNode = VskGetXmlRootNode(sXml);
			
			//alert('rootNode >>> \n\n'+rootNode);
			
			var dataNode = rootNode.selectSingleNode("//DATA/@TOTAL");
			
			//alert('dataNode >>> \n\n'+dataNode);

			if(dataNode){
				var totValue = dataNode.value;

				if(totValue > 0){
					sheetObj.Redraw = false;
					
					var xmlYdKind = ComGetEtcData(sXml, "dir_port_desc");
					sheetObj.InitDataCombo(0, prefix+"dir_port_desc", xmlYdKind, xmlYdKind);
					
					sheetObj.LoadSearchXml(sXml);
					sheetObj.Redraw = true;
				}else{
					sheetObj.Redraw = false;
					sheetObj.LoadSearchXml(sXml);
					sheetObj.Redraw = true;
				}
			}
		}
	}
	
	/*
	 * =====================================================================
	 * Pop Up Data 처리
	 * =====================================================================
	 */
	
	/**
	 * [Port] Button Click 후 Pop-up에서 호출.
	 * @param rtnObjs
	 * @return
	 */
	function returnPortHelp(rtnObjs){
		var formObj 		= document.form;
		var sheetObj 		= sheetObjects[0];
		
		if(rtnObjs){
			var rtnDatas 	= rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.port_cd.value = rtnDatas[2];
				}
			}
		}
	}
	
	/**
	 * [Lane Code] Button Click 후 Pop-up에서 호출.
	 * @param rtnObjs
	 * @return
	 */
	function returnLaneCdHelp(rtnObjs){
		var formObj 		= document.form;
		var sheetObj 		= sheetObjects[0];
		
		if(rtnObjs){
			var rtnDatas 	= rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.lane_cd.value = rtnDatas[1];
				}
			}
		}
		
	}
    
	/**
     * Port Code 존재여부에 따라 화면 제어
     * 
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @return
     */
    function isCheckPortForm(sheetObj, formObj, sXml){
    	var chkPort = ComGetEtcData(sXml, "check_port");
    	
		if(chkPort == "X"){
			return true;
		}else{
			if(!ComIsNull(formObj.port_cd.value)){
				//해당 Port({?msg1})가 존재하지 않습니다.
				ComShowCodeMessage("VSK00029", formObj.port_cd.value);
				
				formObj.port_cd.value = "";
			}
			
		}
		
		return false;
    }
    
    
    /**
     * Lane Code가 유효한지 조회한다.
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function isCheckVslSlanCd(sheetObj, newVslSlanCd, gubun){
    	 
    	if(newVslSlanCd == null || newVslSlanCd == undefined || newVslSlanCd == "") return false;
    	
    	var formObj	= document.form;
    	formObj.vsl_slan_cd.value	= newVslSlanCd;    	
    	
    	if(ComChkLen(formObj.vsl_slan_cd, 3) == 2){
    		
			var sXml 	= doActionIBSheet(sheetObj, formObj, SEARCH04);
			var chkLane = ComGetEtcData(sXml, "checkLane");
			
			if(chkLane == null || chkLane == undefined || chkLane == ""){
	    		return false;
	    	}else{
	    		return true;
	    	}
    	}else{
    		ComShowCodeMessage("COM12114", "Lane Code");
    		formObj.lane_cd.value = "";
			return false;
    	}
	}
    
    /**
     * Carrier Code가 유효한지 조회한다.
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function isCheckCarrierCd(sheetObj, formObj){
    	if(formObj.carrier_cd.value == null || formObj.carrier_cd.value == undefined || formObj.carrier_cd.value == "") return false;
    	
    	if(ComChkLen(formObj.carrier_cd, 3) == 2){
    		var sXml = doActionIBSheet(sheetObj, formObj, SEARCH02);
    		var crrCd = ComGetEtcData(sXml, "crr_cd");
    		if(crrCd == null || crrCd == undefined || crrCd == ""){
    			ComShowCodeMessage('VSK00021', formObj.carrier_cd.value);
    			formObj.carrier_cd.value = "";
    			return false;
    		}else{
    			return true;
    		}
		}else{
			ComShowCodeMessage("COM12114", "Carrier Code");
			formObj.carrier_cd.value = "";
			return false;
		}
    }
     
    /**
    * 로우를 더블클릭 했을 때 이벤트 처리
 	*/ 
	function sheet1_OnDblClick(sheetObj,Row,Col,Value) {
//		var formObj = document.form;
		var prefix = "sheet1_";
		sheetObj.ShowDebugMsg = false;
		var vvd = sheetObj.CellValue(Row, prefix+"vvd");
		var vsl_cd = vvd.substr(0,4);
		var skd_voy_no = vvd.substr(4,4);
		var skd_dir_cd = vvd.substr(8,1);

		var url = "/hanjin/VOP_VSK_0019.do?vsl_cd="+ vsl_cd+"&skd_voy_no="+skd_voy_no+"&skd_dir_cd="+skd_dir_cd;
		var rtnObj = ComOpenPopup(url, 1010, 655, "", "0,0", true);
				
		
		
	}    
    
    /**
     * 마우스가 이동될 때 이벤트 처리 
     * 
     * @param sheetObj
     * @param Button
     * @param Shift
     * @param X
     * @param Y
     * @return
     */
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
    	var Row = sheetObj.MouseRow;
    	var Col = sheetObj.MouseCol;
    	var ydText = sheetObj.CellText(Row, sheetObj.id + "_pol_yard_nm");
    	var dlyText = sheetObj.CellText(Row, sheetObj.id + "_vsl_dlay_rsn_desc");
    	
    	// TMNL Code 셀에서 POL YARD Name 툴팁이 뜨게 한다.
    	if(Col == sheetObj.SaveNameCol(sheetObj.id + "_pol_tml_cd")){
    		sheetObj.MouseToolTipText = ydText;	
    		
    	// Delay Code 셀에서 Delay Desc. Tooltip이 뜨게 한다.
    	}else if(Col == sheetObj.SaveNameCol(sheetObj.id + "_vsl_dlay_rsn_cd")){
    		sheetObj.MouseToolTipText = dlyText;	
    	}else{
    		sheetObj.MouseToolTipText = "";
    	}
    	
    }  
    
 	
	function checkPeriod(fromDate, toDate){
		var fmDt = ComReplaceStr(fromDate.value, "-", "");
		var toDt = ComReplaceStr(toDate.value, "-", "");
		if(ComChkPeriod(fmDt, toDt) < 1){
			return false;
		}else{
			return true;
		}
	}
	
	function wm_change( kind ){
	    var formObj = document.form;
		if ( kind == "0" ){// Month
			document.getElementById("div_month").style.display= "inline";
			document.getElementById("div_week").style.display= "none";
			document.form.wm_cd[0].checked= true;
		}else if ( kind == "1" ){// Week
			document.getElementById("div_month").style.display= "none";
			document.getElementById("div_week").style.display= "inline";
			document.form.wm_cd[1].checked= true;
		}
	}
 	
 	/**
	 * Mutil Combo에 item을 추가한다.
	 * @param comboObj
	 * @param optionCds
	 * @param optionTxts
	 * @param selCode
	 * @return
	 */
	function appendMultiComboItem(comboObj, optionCdArr, optionDescArr, selCode, sFlag){
		comboObj.RemoveAll();
		
		if(optionCdArr != null){
			if(sFlag == "DEF"){
				for(var i=0; i<optionCdArr.length; i++) {
					comboObj.InsertItem(i, optionDescArr[i], optionCdArr[i]);
				}
			}else{
				for(var i=0; i<optionCdArr.length; i++) {
					comboObj.InsertItem(i, optionDescArr[i], optionCdArr[i]);
				}
			}
	    	
			comboObj.Code2 = selCode;
		}
	}
    
    /**
     * combo id 로 해당 comboObject를 찾아 반환한다.
     * @param comboId
     * @return
     */
    function getComboObject(comboId){
    	var cnt = comboObjects.length;
    	if(cnt > 0){
    		for(var i=0; i<cnt; i++){
    			if(comboObjects[i].id == comboId){
    				return comboObjects[i];
    			}
    		}
    	}
    	
    	return null;
    }
    
    /*
	 * =====================================================================
	 * Combo Event
	 * =====================================================================
	 */
	
	function vskd_port_rhq_cd_OnChange(comboObj, Index_Code, Text) {
		doActionIBSheet(sheetObjects[0], document.form, COMMAND06);
	}	
	
	/**
	 * Tml Cd Combo를 Setting.
	 * @return
	 */
	function setTmlCdCombo(sXml){
		if(sXml == null || sXml == undefined || sXml == ""){
			return;
		}
		
		var ydCd = ComGetEtcData(sXml, "yd_cd");
		var ydNm = ComGetEtcData(sXml, "yd_nm");

		var ydTxtArr = new Array();
		var ydCdArr = ("ALL|"+ ydCd).split("|");
		var ydNmArr = ("ALL|"+ ydNm).split("|");
		var ydCnt = ydCdArr.length;
		
		ydTxtArr[0] = ydCdArr[0] + "|" + ydNmArr[0];
		for(var i=1; i<ydCnt; i++){
			ydTxtArr[i] = ydCdArr[i] + "|" + ydNmArr[i];
		}
		appendMultiComboItem(getComboObject("tml_cd"), ydCdArr, ydTxtArr, "", "DEF");
	}
	
	/**
	 * CTRL Office - ALL 선택시 전체 체크
	 */
	function vop_port_ctrl_ofc_cd_OnCheckClick(comboObj, index, code) {
    	if (code == "" || code == "ALL") {
    		var bChk = comboObj.CheckIndex(index);
    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			comboObj.CheckIndex(i) = bChk;
        	}
       }else{
    	   comboObj.CheckIndex(0) = false;
       }
    }
	
	/**
	 * TMNL Code - ALL 선택시 전체 체크
	 */
	function tml_cd_OnCheckClick(comboObj, index, code) {
    	if (code == "" || code == "ALL") {
    		var bChk = comboObj.CheckIndex(index);
    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			comboObj.CheckIndex(i) = bChk;
        	}
       }else{
    	   comboObj.CheckIndex(0) = false;
       }
    }
	 
	 
	 /**
	  * 조회한 다음 후처리 이벤트
	  * @param sheetObj
	  * @param ErrMsg
	  * @return
	  */
	 function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 
	 	with (sheetObj) {
	 		var prefix	= "sheet1_";
	 		var color1 	= RgbColor(0, 0, 255);
	 		var color2 	= RgbColor(255, 0, 0);
			
	 		sheetObj.ColFontColor(prefix+"eta_dlay_fm_hrs")	= color1;
			sheetObj.ColFontColor(prefix+"etb_dlay_fm_hrs")	= color1;
			sheetObj.ColFontColor(prefix+"etd_dlay_fm_hrs")	= color1;

			sheetObj.ColFontColor(prefix+"eta_dlay_to_hrs")	= color2;
			sheetObj.ColFontColor(prefix+"etb_dlay_to_hrs")	= color2;
			sheetObj.ColFontColor(prefix+"etd_dlay_to_hrs")	= color2;
	 	}
	 }
	 
    
	/* 개발자 작업  끝 */