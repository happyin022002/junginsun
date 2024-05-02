/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0109.js
*@FileTitle : IBudget Information Input for SKD Creation(PF SKD Use) (Pop-Up)
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.10 진마리아
* 1.0 Creation
* 
* History
* 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
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
	 * @class vop_vsk_0109 : vop_vsk_0109 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function vop_vsk_0109() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
    	this.initCombo            	= initCombo;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	}
    
   	/* 개발자 작업	*/


	// 공통전역변수
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
	//
	var glbEtbDyCdArr = new Array();
	var glbSkdDirCdArr = new Array();
	var glbClptSeqArr = new Array();
	
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
                case "btn_calendar":
                    var cal = new ComCalendar();
                    cal.select(formObject.vps_etb_dt, 'yyyy-MM-dd');
                    
                    break;

                case "btn_pf_lane_help":
					var sUrl = "/hanjin/VOP_VSK_0111.do?vsl_slan_cd="+formObject.vsl_slan_cd.value;
					ComOpenPopup(sUrl, 310, 400, "getPfLaneHelp", "0,0", true);
					
                    break;

                case "btn_ok":
                	doMakeReturnData(sheetObject, formObject);
                    break;

                case "btn_close":
                	self.close();
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
	 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	 * @param combo_obj
	 * @return
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
    	
    	//============== TEST =================>>>
//    	document.form.vsl_slan_cd.value = "FEX";
    	//============== TEST =================<<<
        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
		
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
		}
        
        initControl();
        
        document.form.slan_stnd_flg.value = "Y";
        
        doActionIBSheet(sheetObjects[0],document.form, SEARCH);
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;
		var prefix = sheetID + "_";

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(9, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "||||||||";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	0,    	daCenter,  true,    "Status");
                    InitDataProperty(0, cnt++ , dtData,    		100,    daCenter,  true,    prefix+"vsl_slan_cd",     	false,          "",      dfNone,				0,			true,		true);
                    InitDataProperty(0, cnt++ , dtData,    		450,    daCenter,  true,    prefix+"vsl_slan_nm",     	false,          "",      dfNone,				0,			true,		true);
                    InitDataProperty(0, cnt++ , dtData,    		100,    daCenter,  true,    prefix+"pf_svc_tp_cd",     	false,          "",      dfNone,				0,			true,		true);
                    InitDataProperty(0, cnt++ , dtData,    		100,    daCenter,  true,    prefix+"port_cd",     		false,          "",      dfNone,				0,			true,		true);
                    InitDataProperty(0, cnt++ , dtData,    		100,    daCenter,  true,    prefix+"skd_dir_cd",     	false,          "",      dfNone,				0,			true,		true);
                    InitDataProperty(0, cnt++ , dtData,    		100,    daCenter,  true,    prefix+"etb_dy_cd",     	false,          "",      dfNone,				0,			true,		true);
                    InitDataProperty(0, cnt++ , dtData,    		100,    daCenter,  true,    prefix+"vps_etb_dt",     	false,          "",      dfNone,				0,			true,		true);
                    InitDataProperty(0, cnt++ , dtData,    		100,    daCenter,  true,    prefix+"clpt_seq",     	false,          "",      dfNone,				0,			true,		true);
                }
                
                break;
			}
    }
	
	/**
   	 * Combo 기본 설정 
   	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
   	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
   	 */ 
   	function initCombo(comboObj, comboNo) {
   	    var formObj = document.form;
   	    
   	    switch(comboObj.id) {
   	    	case "port_cd":
   	    		with (comboObj) { 
   					MultiSelect = false;
   					UseAutoComplete = true;	
   					SetColAlign("left|left");        
  					SetColWidth("60|30|50");
  					DropHeight = 160;
  					UseCode = false;
   		    	}
   	    		break;
   	     }
   	}

   	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

           	case SEARCH:      // 콤보 정보 조회
				formObj.f_cmd.value = SEARCH;
				
                var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("VOP_VSK_0109GS.do", sParam);
				formObj.etb_dy_cd.value = "";
				showSheetData(sheetObj, formObj, sXml);
				
				
                break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
       		case COMMAND01:      // 콤보 정보 조회
       			var startPort = getComboObject("port_cd").Text;
       			var startDay = formObj.etb_dy_cd.value;
       			var vpsEtbDt = formObj.vps_etb_dt.value;
       			
       			if(startPort == null || startPort == undefined || startPort == ""){
       				ComShowCodeMessage("VSK00021", "Start Port");
       				getComboObject("port_cd").focus();
       				return false;
       			}
       			else if(startDay == null || startDay == undefined || startDay == ""){
       				ComShowCodeMessage("VSK00021", "Start Day");
       				formObj.etb_dy_cd.focus();
       				return false;
       			}
       			else if(vpsEtbDt == null || vpsEtbDt == undefined || vpsEtbDt == ""){
       				ComShowCodeMessage("VSK00021", "Start Port ETB Date");
       				formObj.vps_etb_dt.focus();
       				return false;
       			}
       			break;
    	}

        return true;
    }
    
    /**
     * 조회 후 처리로직.
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @return
     */
    function showSheetData(sheetObj, formObj, sXml){
    	setGlbFormData(sXml);
		
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(sXml);

		var dataNode = xmlDoc.selectSingleNode("//DATA/@TOTAL");

		if(dataNode){
			
			var totValue = dataNode.value;
			if(totValue > 0){
				var portCdArr = ComGetEtcData(sXml, "port_cd").split("|");
				var clptSeqArr = ComGetEtcData(sXml, "clpt_seq").split("|");
				var dirCdArr = ComGetEtcData(sXml, "skd_dir_cd").split("|");
				
				appendMultiComboItem(getComboObject("port_cd"), portCdArr, clptSeqArr, dirCdArr, "", "DEF");
				
				formObj.slan_stnd_flg.value = "";
				
				var vslSlanNm = ComGetEtcData(sXml, "vsl_slan_nm");
				var pfSvcTpCd = ComGetEtcData(sXml, "pf_svc_tp_cd");
				
				if(vslSlanNm != null && vslSlanNm != undefined && vslSlanNm != ""){
					formObj.vsl_slan_nm.value = vslSlanNm;
				}
				if(pfSvcTpCd != null && pfSvcTpCd != undefined && pfSvcTpCd != ""){
					formObj.pf_svc_tp_cd.value = pfSvcTpCd;
				}
			}else{
				var comboObj = getComboObject("port_cd");
				
				comboObj.Index2 = 0;
				comboObj.RemoveAll();
				
				formObj.pf_svc_tp_cd.value = "";
				formObj.etb_dy_cd.value = "";
				
				ComShowCodeMessage("VSK00043");
			}
		}else{
			sheetObj.LoadSearchXml(sXml);
		}
    }

	/*
	 * =====================================================================
	 * Combo Event
	 * =====================================================================
	 */
	
	function port_cd_OnChange(comboObj, Index, Text) {
		var formObj = document.form;
		
    	if(glbEtbDyCdArr != null && glbEtbDyCdArr.length > 0){
    		formObj.etb_dy_cd.value = glbEtbDyCdArr[Index];
    	}
    	
    	if(glbSkdDirCdArr != null && glbSkdDirCdArr.length > 0){
    		formObj.skd_dir_cd.value = glbSkdDirCdArr[Index];
    	}
    	
    	if(glbClptSeqArr != null && glbClptSeqArr.length > 0){
    		formObj.clpt_seq.value = glbClptSeqArr[Index];
    	}
	}
 	
	
	/*
	 * =====================================================================
	 * Object Event
	 * =====================================================================
	 */
    
    function initControl() {
    	//Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm('change', 'obj_change', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    	axon_event.addListenerForm('keypress', 'obj_keypress', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    	axon_event.addListenerForm('keyup', 'obj_keyup', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeyup 이벤트에 코드 처리
	}
    
    function obj_change(){
    	var formObject = document.form;
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                	
                case "pf_svc_tp_cd":
                	doActionIBSheet(sheetObjects[0],formObject, SEARCH);
                	
                	break;
                	
                case "vps_etb_dt":
                	formObject.vps_etb_dt.value = ComGetMaskedValue(formObject.vps_etb_dt.value, "ymd");
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
    
    function obj_keypress(){
		switch (event.srcElement.name) {
		    case "vps_etb_dt":
		    	ComKeyOnlyNumber(document.form.vps_etb_dt);
				break;
				
		    case "pf_svc_tp_cd":
		    	ComKeyOnlyNumber(document.form.pf_svc_tp_cd);
				break;
		}
    }
	
	function obj_keyup(){
		var eleObj = event.srcElement;
		var formObj = document.form;
		
		switch (eleObj.name) {
		    case "pf_svc_tp_cd":
		    	if(eleObj.value.length == 4){
		    		getComboObject("port_cd").focus();
		    	}
				break;
		}
	}



	/*
	 * =====================================================================
	 * 
	 * =====================================================================
	 */
    
    /**
     * P/F TYPE Key Help 팝업 창을 오픈한다
     * @return
     */
    function getPfLaneHelp(rtnObjs){
    	if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.pf_svc_tp_cd.value = rtnDatas[2];
					
					doActionIBSheet(sheetObjects[0], document.form, SEARCH);
				}
			}
    	}
    }

	/*
	 * =====================================================================
	 * Etc Function
	 * =====================================================================
	 */
    
    /**
     * Multi Combo에 item을 추가한다.
     * 
     * @param comboObj
     * @param optionCdArr
     * @param optionDescArr
     * @param selCode
     * @param sFlag
     * @return
     */
	function appendMultiComboItem(comboObj, portCdArr, clptSeqArr, dirCdArr, selCode, sFlag){
		comboObj.Index2 = 0;portCdArr, clptSeqArr, dirCdArr
		comboObj.RemoveAll();
		
		if(sFlag == "DEF"){
			for(var i=0; i<portCdArr.length; i++) {
				comboObj.InsertItem(i, portCdArr[i]+"|"+clptSeqArr[i]+"|"+dirCdArr[i], portCdArr[i]);
			}
//		}else{
//			for(var i=0; i<optionCdArr.length; i++) {
//				comboObj.InsertItem(i, optionDescArr[i], portCdArr[i]);
//			}
		}
    	
		comboObj.Code2 = selCode;
	}
    
	/**
	 * 전역변수로 선언한 Direction Code List, Etb Dy Cd List를 Setting.
	 * 
	 * @param sXml
	 * @return
	 */
    function setGlbFormData(sXml){
    	
		if(sXml == null  || sXml == "") return;
		
		var xmlEtcData = "";
		
		xmlEtcData = ComGetEtcData(sXml, "skd_dir_cd");
		if(xmlEtcData != null && xmlEtcData != undefined && xmlEtcData != ""){
			glbSkdDirCdArr = xmlEtcData.split("|");
		}else{
			glbSkdDirCdArr = null;
		}
		
		xmlEtcData = ComGetEtcData(sXml, "etb_dy_cd");
		if(xmlEtcData != null && xmlEtcData != undefined && xmlEtcData != ""){
			glbEtbDyCdArr = xmlEtcData.split("|");
		}else{
			glbEtbDyCdArr = null;
		}
		
		xmlEtcData = ComGetEtcData(sXml, "clpt_seq");
		if(xmlEtcData != null && xmlEtcData != undefined && xmlEtcData != ""){
			glbClptSeqArr = xmlEtcData.split("|");
		}else{
			glbClptSeqArr = null;
		}
    }

    /**
     * 부모창으로 해당 데이타를 전송한다.
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
	function doMakeReturnData(sheetObj, formObj){
		var prefix = sheetObj.id + "_";
		
		if(validateForm(sheetObj,formObj,COMMAND01)){
			with (sheetObj) {
				DataInsert(-1);
	
				getComboObject("port_cd").UseCode = true;
				
				CellValue2(1, prefix+"vsl_slan_cd") 	= formObj.vsl_slan_cd.value;
				CellValue2(1, prefix+"vsl_slan_nm") 	= formObj.vsl_slan_nm.value;
				CellValue2(1, prefix+"pf_svc_tp_cd") 	= formObj.pf_svc_tp_cd.value;
				CellValue2(1, prefix+"port_cd") 		= getComboObject("port_cd").Code;
				CellValue2(1, prefix+"skd_dir_cd") 		= formObj.skd_dir_cd.value;
				CellValue2(1, prefix+"etb_dy_cd") 		= formObj.etb_dy_cd.value;
				CellValue2(1, prefix+"vps_etb_dt") 		= formObj.vps_etb_dt.value;
				CellValue2(1, prefix+"clpt_seq") 		= formObj.clpt_seq.value;
			}

			comPopupOK();
		}
	}
    
    /**
     * combo id 로 해당 comboObject를 찾아 반환한다.
     * 
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
    
	/* 개발자 작업  끝 */