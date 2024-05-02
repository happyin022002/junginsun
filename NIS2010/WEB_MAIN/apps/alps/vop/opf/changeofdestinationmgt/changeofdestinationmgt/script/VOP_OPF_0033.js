/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0033.js
*@FileTitle : COD Approve Main Screen
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.08
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.07.20 김종옥
* 1.0 Creation
=========================================================
* History
* 2010.07.26 LHJ [Ticket-ID:CHM-201004935] COD application 조회 기능 추가 요청 및 에러 수정건
* 2010.08.24 윤진영 [CHM-201005460] Freight 변경 가능및 Row 추가  
* 2012.10.08 진마리아 CHM-201220208-01 COD APPROVAL 관련 요청 사항 (ETA,경과 시간 표시)
*=========================================================*/
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
     * @class VOP_OPF_0033 : VOP_OPF_0033 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_OPF_0033() {
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
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var objBlurFlg = false;
	
    //VVD CD 관련 항목들
    var strVVDOptions = "vsl_cd|skd_voy_no|skd_dir_cd";

 	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

 	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
  
		var sheetObject1  = sheetObjects[0];   //t1sheet1
  
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
			
        		case "btn_slan_cd_pop":
        			var slan_cd = formObject.slan_cd.value;
        			ComOpenPopup("VOP_VSK_0202.do?vsl_slan_cd="+slan_cd, 420, 470, "slan_cd_pop_event", "0,0", true);
        			break;
        		
				case "btn_VVDpop":
					//VVD 선택팝업 열기					
					var vsl_cd = getObjValue("vsl_cd");
                	var sUrl = "";
                	
                	if(vsl_cd == ""){
                		sUrl = "/hanjin/VOP_VSK_0219.do?op=0219";
                		ComOpenPopup(sUrl, 463, 500, "setCallBackVSL", "0,0", true);
                	}else{
                		sUrl = "/hanjin/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
                		ComOpenPopup(sUrl, 335, 420, "setCallBackVVD", "0,0", true);
                	}
					break;
					
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				
				case "btn_New":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;

				case "btn_Detail":
					var sUrl = "";
					//if(sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_bkg_no") != ""){
					//if(sheetObject1.RowCount >= sheetObject1.HeaderRows){
					if(sheetObject1.SelectRow >= sheetObject1.HeaderRows){
						var vBkgNo = sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_bkg_no");
						var vBlNo = sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_bl_no");
						var vVvd = sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_vvd");
						var vVslSlanCd = sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_vsl_slan_cd");
						var vCodRqstSeq = sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_cod_rqst_seq");
						var vCodRhndPortCd = sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_cod_rhnd_port_cd");
						var vCodStsCd = sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_cod_sts_cd");
						var vCodEmailSendYn = sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_cod_email_send_yn");
						sUrl = "/hanjin/VOP_OPF_0206.do?bkg_no="+vBkgNo+"&bl_no="+vBlNo+"&vvd="+vVvd+"&vsl_slan_cd="+vVslSlanCd+"&cod_rqst_seq="+vCodRqstSeq+"&cod_rhnd_port_cd="+vCodRhndPortCd+"&cod_sts_cd="+vCodStsCd+"&cod_email_send_yn="+vCodEmailSendYn;
                		ComOpenPopup(sUrl, 916, 700, "", "0,0", true, false, "", "", "","COD Approval Detail at RSO Office");
					}else{
						ComShowCodeMessage("COM12177");
					}
					break;
					
				case "btn_History":
					if(sheetObject1.SelectRow >= sheetObject1.HeaderRows){
    					var param="?bkg_no="+sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_bkg_no");
    					param+="&cod_rqst_seq="+sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_cod_rqst_seq");
    					ComOpenPopup("/hanjin/ESM_BKG_0981.do"+param, 800, 280, '', '0,1,1,1,1,1,1,1,1,1,1,1', true);
					}else{
						ComShowCodeMessage("COM12177");
					}
					break;
					
				case "btn_Tariff":
            		sUrl = "/hanjin/VOP_OPF_0207.do?isPop=";
            		ComOpenPopup(sUrl, 600, 300, "", "0,0", true);
					break;
					
		        case "btns_period": // From 달력버튼
		        	var cal = new ComCalendarFromTo();
		        	cal.endFunction = "cal_end_func";
		        	cal.select(formObject.fr_dt, formObject.to_dt, 'yyyy-MM-dd');
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
	 * Calendar From To 선택 후 호출하는 함수
	 */
	function cal_end_func(){
		sheetObjects[0].RemoveAll();
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
	function loadPage(rso) {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		setRso_Combo(rso); //RSO 콤보 세팅
//		setCod_Combo(); //COD Condition 콤보 세팅
		setAuth_Combo(); // Auth Result 콤보 세팅 2010.07.23 추가 by LHJ
		setCodRsn_Combo(); // DOC Reason 콤보 세팅 2010.07.23 추가 by LHJ
		initControl();
		//ComBtnDisable("btn_Tariff");
	}
    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl(){
   		axon_event.addListenerFormat('beforedeactivate'	, 'obj_deactivate'	, form); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리    	 
        axon_event.addListenerFormat('focus',     'obj_activate',   form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress',  'obj_keypress',   form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
        axon_event.addListenerFormat('blur',	  'obj_blur',	    form); 
        axon_event.addListenerForm  ("keyup",    'obj_keyup',      form);
        
    	axon_event.addListener  ('keypress', 'eng_keypress', 'slan_cd'); //Code 입력 시 영문 대문자만 입력하기
    	axon_event.addListener  ('change', 'change_event', 'slan_cd');   //Input Box 이벤트
    	axon_event.addListener  ('keydown', 'ComKeyEnter', 'form');
    }
     
     /**
      * OnBlur
      */
     function obj_deactivate(){
     	ComChkObjValid(event.srcElement);
     }     

    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
     **/
    function obj_activate(){
        ComClearSeparator(event.srcElement);
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
    		case "engup":
    			switch(event.srcElement.name){
    				case "slan_cd":		    	     
    					ComKeyOnlyAlphabet('uppernum');		//영문대문자/숫자 입력하기
    					break;	    	
    				case "vsl_cd":		    	        	
    					ComKeyOnlyAlphabet('uppernum');		//영문대문자/숫자 입력하기
    					break;
    				case "skd_voy_no":		    	        	
    					ComKeyOnlyNumber(event.srcElement);	//숫자입력하기
    					break;
    				case "skd_dir_cd":		    	        	
    					ComKeyOnlyAlphabet('upper');		//영문대문자 입력하기
    					break;
    			}
    			break;    			
    		case "ymd":	
    	    		ComKeyOnlyNumber();
    			break;    			

    		default:    	    	
    			ComKeyOnlyAlphabet("num");					//공통기준:영문, 숫자만을 인식
	    		break;
    	}
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문 대문자만 입력 처리한다. <br>
     **/
    function eng_keypress() {
		//영대문자 자동변환
        ComKeyOnlyAlphabet('upper');
    }
    
    /**
     * Key 입력된 popup Data Validation 함수.
     */
    function change_event() {
    	var elementObj = event.srcElement;
    	var sheetObj = sheetObjects[0];
    	var gubun = "";

    	if(!isNull(elementObj.value)){
    		// Object의 Length Check..
	    	if(elementObj.maxLength != elementObj.value.length){
	    		ComShowCodeMessage("OPF50007",elementObj.caption,elementObj.maxLength);
	    		setFocus(elementObj.name);
	    		return false;
	    	}

    		// Popup Data Validation Check!
    		if(elementObj.name=="slan_cd"){
        		gubun = "slanCd";
        	}

    		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, gubun);
    	}
    }
    
    /**
  	 * VSL Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
  	 * @param {arry} rtnObjs
  	 */
  	function setCallBackVSL(rtnObjs) {
  		if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					setObjValue("vsl_cd", rtnDatas[1]);
					
					//포커스 이동
					setFocus("skd_voy_no");
				}
			}
    	}
  	} 
  	
    /**
  	 * VVD Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
  	 * @param {arry} obj
  	 */
  	function setCallBackVVD(obj) {
  		if(obj){
			var rtnDatas = obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					setObjValue("skd_voy_no", rtnDatas[2]);
					setObjValue("skd_dir_cd", rtnDatas[3]);
				}
			}
    	}
  		
  		//[#1-2]VVD 관련 항목 채우기
  		searchVVDInfo();
  	}
  	
  	/**
     * VVD 정보 조회
     */
  	
    function searchVVDInfo() {
    	if(objBlurFlg){
	    	var formObj = document.form;
			formObj.f_cmd.value = SEARCH06;
			var sXml = sheetObjects[0].GetSearchXml("VOP_OPF_UTILGS.do", FormQueryString(formObj)); 	
			
	 	   	//VVD 정보 관련 항목 셋팅
	 	    setVVDInfo(formObj, sXml);
	 		objBlurFlg = false;
    	}else{
    		objBlurFlg = true;
    	}
    }
  	
  	/**
     * VVD 정보 관련 항목 셋팅 : VVD
     */
    function setVVDInfo(formObj, sXml) {
    	var vvdData = ComOpfXml2Array(sXml, strVVDOptions);
 	   	if(vvdData == null) {
 		    ComShowCodeMessage("COM12114", "VVD CD");
 		    initObjs("form", formObj, strVVDOptions, 0, "");
 	   	} else {
 	   		if(vvdData.length > 1) {
 	   			ComShowCodeMessage("COM12114", "VVD CD");
 	   			initObjs("form", formObj, strVVDOptions, 0, "");
 	   		}
 	   	}
    }

    /**
     * 선택된 Object의 초기화와 포커스 이동
     */
    function initObjs(type, sheetObj, nameVars, focusIdx, etcVal) {
    	var nameArrs = nameVars.split("|");
    	
    	for(var objIdx=0; objIdx<nameArrs.length; objIdx++) {
    		
    		if(type == 'sheet') sheetObj.CellValue2(etcVal, prefixs[0]+nameArrs[objIdx]) = "";
    		else {
    			if(eval("document.form."+nameArrs[objIdx]).type == 'hidden') {
    				setObjValue(nameArrs[objIdx],"");
    			} else {
    				ComClearObject(eval("document.form."+nameArrs[objIdx]));
    			}
    		}
    		
    		if(focusIdx == objIdx) {
    			if(type == 'sheet') sheetObj.SelectCell(etcVal, nameArrs[objIdx]);
    			else {
    				setFocus(nameArrs[objIdx]);
    			}
    		}
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
    
    // 업무 자바스크립트 OnKeyUp 이벤트 처리
    function obj_keyup() {
    	if(event.keyCode != 9) obj_nextfocus(event.srcElement);
    }  
    
    // 인자로 받은 HTML태그(Object)의 다음 HTML태그(Object)로 포커스를 이동
    function obj_nextfocus(obj) {
    	var objMaxLength = obj.getAttribute("maxlength");
    	var objValue = obj.getAttribute("value");
    	
    	if (ComChkLen(objValue, objMaxLength) == 2) {
			var formObj = document.form;
			ComSetNextFocus(obj);
			if(obj.name == 'vsl_cd') {
				setObjValue("skd_voy_no", ""); 	
				setObjValue("skd_dir_cd", ""); 
			} else if(obj.name == 'skd_voy_no') {
				setObjValue("skd_dir_cd", ""); 
			}
    	}
    }
    
    // 업무 자바스크립트 OnBlur 이벤트 처리
    function obj_blur() {
    	
    	switch(event.srcElement.name){ 
	    	case "skd_dir_cd":
	        	//[#1-1]VVD 정보 조회
	        	searchVVDInfo();
	        	break;
    	}
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
                    style.height = 442;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

 					var HeadTitle1 = "|Seq.|LANE|VVD|BKG No.|RSN|OLD|OLD|OLD|NEW|NEW|Re-Handling Port|Re-Handling Port|Elapsed\n(day)|Requested\nDate|First Act Date|APRVL\nID|CNTR\nQ'ty|BKG\nOffice|Auth\nResult|Remark(s)|BL No.|CSeq|||";
					var HeadTitle2 = "|Seq.|LANE|VVD|BKG No.|RSN|POL|POD|DEL|POD|DEL|Port|ETA|Elapsed\n(day)|Requested\nDate|First Act Date|APRVL\nID|CNTR\nQ'ty|BKG\nOffice|Auth\nResult|Remark(s)|BL No.|CSeq|||"; 
 										
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 5, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    
                    HeadRowHeight = 30;
                    
                    var prefix="sheet1_";
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtDataSeq,		35,		daCenter,	true,	prefix+"Seq");
                    InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	true,	prefix+"vsl_slan_cd",  		false,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix+"vvd",   			false,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,	prefix+"bkg_no",   			false,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix+"cod_rqst_rsn_cd", 	false,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	prefix+"old_pol", 			false,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	prefix+"old_pod", 			false,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	prefix+"old_del", 			false,		"",		dfNone,		0,	true,	true);
                //    InitDataProperty(0, cnt++ , dtHidden,	    50,		daCenter,	true,	prefix+"new_pol", 			false,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	prefix+"new_pod", 			false,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	prefix+"new_del", 			false,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	prefix+"cod_rhnd_port_cd",	false,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix+"rhnd_pord_eta_dt",	false,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"elapsed_day",		false,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			95,	    daCenter,	true,	prefix+"requested_date",	false,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix+"first_react_date",	false,		"",		dfNone,		0,	true,	true);                    
                    InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"aprv_rjct_id",		false,		"",		dfNone,		0,	true,	true);                    
                    InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	true,	prefix+"cntr_qty",  		false,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"cod_rqst_ofc_cd",	false,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"cod_sts_cd",		false,		"",		dfNone,		0,	true,	true);
                   // InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"chg_amt",			false,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			40,		daLeft,		true,	prefix+"diff_rmk",			false,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtHidden,		40,		daLeft,		true,	prefix+"bl_no",				false,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtHidden,		40,		daLeft,		true,	prefix+"cod_rqst_seq",		false,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtHidden,		40,		daLeft,		true,	prefix+"act_dept_yn",		false,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtHidden,		40,		daLeft,		true,	prefix+"pod_eta_dt",		false,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtHidden,		40,		daLeft,		true,	prefix+"cod_email_send_yn",	false,		"",		dfNone,		0,	true,	true);
                    //CountPosition = 0;                                         
 				}
 			}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction, gubun) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH;
	        	var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				var sXml = sheetObj.GetSearchXml("VOP_OPF_0033GS.do", sParam);
				if(sXml.length>0){ 
					sheetObj.LoadSearchXml(sXml);
				}
				break;

			case IBCLEAR:
				setRso_Combo(); //RSO 콤보 세팅
				//setCod_Combo(); //COD Condition 콤보 세팅
				setAuth_Combo();
				setCodRsn_Combo();
				setObjValue("slan_cd", ""); 
				setObjValue("vsl_cd", "");
				setObjValue("skd_voy_no", "");
				setObjValue("skd_dir_cd", "");
				setObjValue("bkg_no", "");
				setObjValue("fr_dt", ""); 
				setObjValue("to_dt", ""); 
				sheetObj.RemoveAll();
				break;				
				
			case IBROWSEARCH:	
				if(gubun=="slanCd"){
					formObj.f_cmd.value = COMMAND12;
					var lanXml = sheetObjects[1].GetSearchXml("VOP_VSK_0202GS.do?vsl_slan_cd="+formObj.slan_cd.value , FormQueryString(formObj));
					var strLanCdDesc = ComGetEtcData(lanXml, "checkLane");
		    		  
					if(isNull(strLanCdDesc)){
						ComShowCodeMessage("OPF50004", "Data");
						setObjValue("slan_cd", "");
						setFocus("slan_cd");

						return false;
					}
				}
				break;
				
         }
	}

	/**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
		}

		return true;
	}

    /* RSO 콤보 가져옴 */
	function setRso_Combo(rso){
	    var formObj = document.form;
		formObj.f_cmd.value = SEARCH01;
		var sRhqXml = sheetObjects[1].GetSearchXml("VOP_OPF_0033GS.do", FormQueryString(formObj));
		ComXml2ComboItem(sRhqXml, comboObjects[0], "rgn_shp_opr_cd", "rgn_shp_opr_cd|rgn_shp_opr_desc");
		if( rso != ''){
			comboObjects[0].Code = rso;
		} else {
			comboObjects[0].Code ="AMR";
		}
	}
	
    /* COD Codition 콤보 가져옴 */
	/*function setCod_Combo(){
	    var formObj = document.form;
		formObj.f_cmd.value = SEARCH02;
		var sRhqXml = sheetObjects[1].GetSearchXml("VOP_OPF_0033GS.do", FormQueryString(formObj));
		comboObjects[1].DropHeight=125;
		ComXml2ComboItem(sRhqXml, comboObjects[1], "intg_cd_val_ctnt", "intg_cd_val_dp_desc");
		comboObjects[1].Code ="^";
	} */
	
	/* Auth Result 콤보 가져옴  2010.07.23 추가 by LHJ*/
	function setAuth_Combo(){
	    var formObj = document.form;
		formObj.f_cmd.value = SEARCH03;
		var sRhqXml = sheetObjects[1].GetSearchXml("VOP_OPF_0033GS.do", FormQueryString(formObj));
		comboObjects[1].DropHeight=150;
		ComXml2ComboItem(sRhqXml, comboObjects[1], "intg_cd_val_ctnt", "intg_cd_val_dp_desc|intg_cd_val_ctnt");
		comboObjects[1].Code ="";
	}
	
	/* COD Reason 콤보 가져옴  2010.07.23 추가 by LHJ*/
	function setCodRsn_Combo(){
		var formObj = document.form;
		formObj.f_cmd.value = SEARCH04;
		var sRhqXml = sheetObjects[1].GetSearchXml("VOP_OPF_0033GS.do", FormQueryString(formObj));
		comboObjects[2].DropHeight=170;
		ComXml2ComboItem(sRhqXml, comboObjects[2], "intg_cd_val_ctnt", "intg_cd_val_ctnt|intg_cd_val_dp_desc");
		comboObjects[2].Index =0;
	}
	
    /**
     * slan_cd Data PopUp Value 입력 함수.
     */
    function slan_cd_pop_event(aryPopupData) {
    	document.form.slan_cd.value = aryPopupData[0][1];
    }
    
    function sheet1_OnDblClick(sheetObj, Row, Col){
		var vBkgNo = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_bkg_no");
		var vBlNo = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_bl_no");
		var vVvd = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_vvd");
		var vVslSlanCd = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_vsl_slan_cd");
		var vCodRqstSeq = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_cod_rqst_seq");
		var vCodRhndPortCd = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_cod_rhnd_port_cd");
		var vCodStsCd = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_cod_sts_cd");
		var vCodEmailSendYn = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_cod_email_send_yn");
		sUrl = "/hanjin/VOP_OPF_0206.do?bkg_no="+vBkgNo+"&bl_no="+vBlNo+"&vvd="+vVvd+"&vsl_slan_cd="+vVslSlanCd+"&cod_rqst_seq="+vCodRqstSeq+"&cod_rhnd_port_cd="+vCodRhndPortCd+"&cod_sts_cd="+vCodStsCd+"&cod_email_send_yn="+vCodEmailSendYn;;
		//ComOpenPopup(sUrl, 916, 620, "", "0,0", false);
		ComOpenPopup(sUrl, 916, 700, "", "0,0", true, false, "", "", "","COD Approval Detail at RSO Office");
    }
    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
 	 		if(sheetObj.RowCount > 0){	 			
 	 			for(var i=sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++){ 	 				
 	 				if(sheetObj.CellValue(i, "sheet1_act_dept_yn") == "N"){
 	 					for(var j=1 ; j<21 ; j++){
 	 						sheetObj.CellBackColor(i, j) = sheetObj.RgbColor(247, 225, 236);
 	 					}
 	 				} 	 				
 	 			}
 	 		}
		}
	}    
    
    function call_0206(){
		var sheetObject1  = sheetObjects[0];   //t1sheet1
		var formObject = document.form;    	
    	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    }
	/* 개발자 작업  끝 */