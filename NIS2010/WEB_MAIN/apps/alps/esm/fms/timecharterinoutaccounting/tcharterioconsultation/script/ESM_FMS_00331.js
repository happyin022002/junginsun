/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_00331.js
*@FileTitle : RCS / Invoice No Inquiry - Window
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.08.03 최우석
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
     * @class esm_fms_0033 : esm_fms_0033 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_00331() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.initControl            = initControl;
    	this.obj_keypress			= obj_keypress;
    	this.eng_keypress			= eng_keypress;
    	this.obj_change				= obj_change;
    	this.setVslCd				= setVslCd;
    	this.setContractNo			= setContractNo;
    	this.obj_blur				= obj_blur;
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
		var sheetObject1 = sheetObjects[1];

		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_Retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;

				case "btn_Confirm":
					comPopupOK();
					break;

				case "btn_New":
					ComResetAll();
					break;
					
				case "btn_vslCd":
     				ComOpenPopup("ESM_FMS_0022.do", 520, 440, "setVslCd", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0022");
     				break;
     			
     			case "btn_fletCtrtNo":
     				if(formObject.vsl_cd.value == "") {
     					ComAlertFocus(formObject.vsl_cd, ComGetMsg('FMS01231'));
     					return;
     				}
     				var param = "typeFlag=" + "TO" + "&vsl_cd=" + formObject.vsl_cd.value;
     				ComOpenPopup("ESM_FMS_0023.do?" + param, 520, 395, "setContractNo", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0023");
     				break;
     				
     			case "btn_close":
     				window.close();
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

			sheetObjects[i].ExtendLastCol = false;
		}
		
		initControl();
	}
	
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

    	var cnt = 0;

    	switch(sheetNo) {
        	case 1:      //t1sheet1 init
        		with (sheetObj) {

        		// 높이 설정
        		style.height = 240;
        		//전체 너비 설정
        		SheetWidth = mainTable.clientWidth;

        		//Host정보 설정[필수][HostIp, Port, PagePath]
        		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

        		//전체Merge 종류 [선택, Default msNone]
        		MergeSheet = msAll;

        		//전체Edit 허용 여부 [선택, Default false]
        		Editable = true;

        		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        		InitRowInfo(1, 1, 3, 100);

				var HeadTitle = "||Seq|Invoice No.|CSR Number";
				var headCount = ComCountHeadTitle(HeadTitle);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtRadioCheck,	0,    	daCenter,  	false,	"radio",   		false,	"", dfNone,	0,	true,	true);
                InitDataProperty(0, cnt++, dtCheckBox,  	0,    	daCenter,  	false,  "check",   		false,  "", dfNone, 0,  true,       true);
                InitDataProperty(0, cnt++, dtSeq,         	30,    	daCenter,  	true,	"Seq");
				InitDataProperty(0, cnt++, dtData,			130,  	daCenter,	false,	"to_inv_no",	false,	"",	dfNone,	0,	false, false);
				InitDataProperty(0, cnt++, dtData,			180,  	daCenter,	false,	"csr_no",		false,	"",	dfNone,	0,	false, false);
        	}
        	break;
    	}
    }
	
    /**
     * Sheet관련 프로세스를 처리한다.<br>
     */
    function doActionIBSheet(sheetObj,formObj,sAction,objNm) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        	case IBSEARCH:      // 조회
    			if(objNm == "vsl_cd") {
        			formObj.f_cmd.value = SEARCH01;
        			var param = FormQueryString(formObj);
    	   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do", param);
    	   			var vslEngNm = ComGetEtcData(sXml, "vslEngNm");        	   			
    	   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
    	   				formObj.vsl_eng_nm.value = vslEngNm;
    	   				form.flet_ctrt_no.value = "";
    	   				initDefaultContractNo(); //선박 대 계약 자동 매치
    				} else {
    					//form.btn_vslCdClr.checked = false;
    					formObj.vsl_cd.value = "";
    					form.flet_ctrt_no.value = "";
    					// 존재하지 않는 Vessel Code입니다
    					ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS00006", "Vessel Code"));
    					return;
    				}
    			} else {
    				if(validateForm(sheetObj,formObj,sAction)) {
	        			formObj.f_cmd.value = SEARCH;
		   				sheetObj.DoSearch("ESM_FMS_00331GS.do", FormQueryString(formObj));
    				}
    			}
                break;

        	case IBSAVE:        // 저장
              	if(validateForm(sheetObj,formObj,sAction))
              		alert (" Save .. ");
                break;

			case IBINSERT:      // 입력
                break;
                
			case IBSEARCH_ASYNC02: //선박 대 계약 자동 매치			
				if(formObj.vsl_cd.value == "") return;				
				var f_query = "";					
				f_query += "f_cmd=" + SEARCH01; 
				f_query += "&vsl_cd="+formObj.vsl_cd.value;	 			
				f_query += "&type_flag="+gFletCtrtTpCdAll;  			
				f_query += "&order_priority="+gOrderPriorityTO; 
				
				var sXml = sheetObj.GetSearchXml("FMS_COMGS.do",f_query);

	   			var varFletCtrtNo = ComGetEtcData(sXml, "flet_ctrt_no");
	   			
	   			if(typeof varFletCtrtNo != "undefined" && varFletCtrtNo != "" ) {
					formObj.flet_ctrt_no.value = varFletCtrtNo;
				}else{
					ComShowCodeMessage("FMS20001","Agreement");
					clearAll();
					return;
				}
				break;
				
        }
    }

    /**
     * 화면 폼입력값에 대한 Validation을 체크한다.<br>
     */
    function validateForm(sheetObj,formObj,sAction){
    	if(formObj.vsl_cd.value != "") {
    		exptElems = "csr_no";
    		if (!ComFmsChkValid(formObj, exptElems)) {
    	    	return false;
    	    }
    	}
    	
        return true;
    }
     
    /**
  	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
  	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
  	 * @param {ibsheet} sheetObj    IBSheet Object
  	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
  	 **/
  	function initControl() {
  		//Axon 이벤트 처리1. 이벤트catch
  		axon_event.addListenerForm  ('blur'		, 'obj_blur', form); 				//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
  		axon_event.addListenerFormat('keypress'	, 'obj_keypress', form); 			//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
  		axon_event.addListenerForm  ('keypress'	, 'eng_keypress', form); 			//- form 전체 컨트롤 모든 컨트롤의 OnKeypress이벤트에 코드 처리
  		axon_event.addListenerForm  ('change'	, 'obj_change', form); 				//- form 전체 컨트롤 모든 컨트롤의 OnChange이벤트에 코드 처리
  	}

    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다.<br>
     **/
    function obj_keypress() {
    	switch(event.srcElement.dataformat){
 			case "int":
 		        //숫자 만입력하기
 		        ComKeyOnlyNumber(event.srcElement);
 				break;
 			case "float":
 		        //숫자+"."입력하기
 		        ComKeyOnlyNumber(event.srcElement, ".");
 				break;
     	}
    }
     
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다.<br>
     **/
    function eng_keypress() {
    	if((event.srcElement.name == "vsl_cd")) { 
     		//영대문자 자동변환
     		ComKeyOnlyAlphabet('upper');
     	} else if((event.srcElement.name == "csr_no")) { 
     		//영대문자 자동변환
     		ComKeyOnlyAlphabet('upper', '48|49|50|51|52|53|54|55|56|57');
     	}
    }

    /**
     * HTML Control의 onchange이벤트에서 Vessel Name을 가져온다.<br>
     */
 	function obj_change() {
 		if((event.srcElement.name == "vsl_cd")) {
 			if(form.vsl_cd.value.length == 4) {
	 	    	form.vsl_eng_nm.value = "";
	 	    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"vsl_cd");
 			}
 		}
 	}
     
    /**
  	 * Vessel Code 팝업창에서 선택한 Vessel Code, Vessel Name을 Form항목에 설정한다.<br>
  	 */
  	function setVslCd(aryPopupData) {
  		form.vsl_cd.value = aryPopupData[0][2];
  		form.vsl_eng_nm.value = aryPopupData[0][3];
  		
     	//선박 대 계약 자동 매치
		if(form.vsl_cd.value != ""){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"vsl_cd");
		}
  	}
  	
  	/**
 	 * Contract Type 팝업창에서 선택한 Contract No.를 Form항목에 설정한다.<br>
 	 */
 	function setContractNo(aryPopupData){
 		form.flet_ctrt_no.value = aryPopupData[0][3];
 	}
 	 
 	/**
     * HTML Control의 onblur이벤트에서 CSR No.의 Validation을 체크한다.<br>
     **/
    function obj_blur() {
    	if(event.srcElement.name == "csr_no") {
    		ComChkObjValid(event.srcElement);
       	} else {
       		ComChkObjValid(event.srcElement);
       	}
    }
    
  //선박 대 계약 자동 매치
    function initDefaultContractNo(){
  	  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);   
    }
	/* 개발자 작업  끝 */