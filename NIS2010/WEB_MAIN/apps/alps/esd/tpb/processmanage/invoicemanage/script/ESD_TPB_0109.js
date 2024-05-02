/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0109.js
*@FileTitle : Invoice Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-14
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2008-09-11 O Wan-Ki 			1.0	 최초 생성
* 2009-09-14 Jong-Geon Byeon	1.1 ALPS Migration
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
     * @class ESD_TPB_0109 : ESD_TPB_0109 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0109() {
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
    /* 공통전역변수 */
    //var calPop = new calendarPopupGrid();
 	var sheetObjects = new Array();
 	var sheetCnt = 0;

  /* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

  	/**
  	 * IBSheet Object를 배열로 등록
  	 * ComSheetObject(id)에서 호출한다
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
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//khlee-마지막 환경 설정 함수 추가
  			ComEndConfigSheet(sheetObjects[i]);
  		}
  		
  		initControl();
  		
  		if( document.form.s_cnt_cd.value == 'IN' ){
  			document.getElementById("t_vat").style.display	= "none";
  			document.getElementById("s_vat").style.display	= "none";
  			document.getElementById("ida_info").style.display	= "inline";
  		} else{
  			document.getElementById("t_vat").style.display	= "inline";
  			document.getElementById("s_vat").style.display	= "inline";
  			document.getElementById("ida_info").style.display	= "none";
  		}

  		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  		
  		//alert("document.form.ibflag.value:"+document.form.ibflag.value);
  	}

  	/**
  	 * 시트 초기설정값, 헤더 정의
  	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  	 */
  	function initSheet(sheetObj,sheetNo) {
  		sheetObj.UseUtf8 = true;
  		switch(sheetNo) {
  			case 1:	  //IBSheet1 init
  				with (sheetObj) {
  					var cnt = 0;
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
  					InitRowInfo( 1, 1, 10);
  		
  					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitColumnInfo(11, 3, 0, true);

  					// 해더에서 처리할 수 있는 각종 기능을 설정한다
  					InitHeadMode(true, true, false, true, false, false)
  		
  					var HeadTitle = "";

  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);
  		
  					//데이터속성	  [ROW,	  COL,	ATATYPE, WIDTH,  DATAALIGN, COLMERGE, SAVENAME,   			KEYFIELD, CALCULOGIC,  DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++, dtStatus,    150,  daCenter,  true,    "ibflag",        		false,          "",    dfNone);

  					WaitImageVisible = false;
  				}
  				break;
  		}
  	}


  	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */

  	document.onclick = processButtonClick;
  	
  	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
  	function processButtonClick(){
  		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 ****/
  		 var sheetObject = sheetObjects[0];
  		 /******************************************************/
  		 var formObject = document.form;
  			
  		try {
  			var srcName = window.event.srcElement.getAttribute("name");

  			switch(srcName) {
  				case "btn_retrieve":
  					var ofc_cd = formObject.s_inv_iss_ofc_cd.value;
  					ComResetAll();
  					formObject.s_inv_iss_ofc_cd.value = ofc_cd;
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
					
  				case "btn_save":
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
  					break;

  				case "btn_new":
  					var ofc_cd = formObject.s_inv_iss_ofc_cd.value;
  					ComResetAll();
  					formObject.s_inv_iss_ofc_cd.value = ofc_cd;
  					document.form.ibflag.value = "I";
  					break;
  					
  				case "btn_close":
  					window.close();
  					break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowMessage(getMsg('COM12111'));
  			} else {
  				ComShowMessage(e);
  			}
  		}
  	}
  	
  	/* Sheet관련 프로세스 처리 */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;
  		switch(sAction) {

  		   case IBSEARCH:	  //조회
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESD_TPB_0109GS.do", tpbFrmQryStr(formObj));
				ComOpenWait(false);
				break;
				
  		   case IBSAVE:		//저장
  		   //alert("\n IBSAVE		1");
  			    if (formObj.onchange_flag.value != "Y") {
					ComShowCodeMessage("COM130503");    // "There is no updated data to save.COM130503
					return;
				}  			  
  			  //alert("\n IBSAVE		2");
  				//Validation Check
  				if(!validateForm(formObj)) {
  					return false;
  				}
  				//alert("\n IBSAVE		3");	
				ComOpenWait(true);
				//alert("\n IBSAVE		4");
  				formObj.f_cmd.value = MULTI;
  				//alert("\n IBSAVE		5");
//  				sheetObj.DoAllSave("ESD_TPB_0109GS.do", tpbFrmQryStr(formObj));
  				sheetObj.LoadSaveXml(sheetObj.GetSaveXml("ESD_TPB_0109GS.do", tpbFrmQryStr(formObj)));
  				//alert("\n IBSAVE		6");
				ComOpenWait(false);
				//alert("\n IBSAVE		7");
  				break;
  		}
  	}


  //---------------------------------------------------------------------------------------------

	/**
	 * Form의 Conrol 초기화 및 초기 이벤트 등록
	 */
	function initControl() {
		axon_event.addListenerForm("change", "frmObj_OnChange", document.form);
	}

 	/**
	 * Form Element의 OnChange 이벤트
	 */
	function frmObj_OnChange() {
		var elementName = window.event.srcElement.getAttribute("name");
		switch (elementName) {
			default:
				document.form.onchange_flag.value = "Y";    // 저장시 HTML의 Object내의 value들이 변경되었는지 감지
			break;
		}
	}

  	/**
  	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  	 */
  	function validateForm(formObj){
  		with(formObj){
  			//VAT Rate 숫자 타입 체크
			if(!ComIsNumber(formObj.vat_xch_rt,".") && ComTrim(formObj.vat_xch_rt.value).length != 0){
				ComShowMessage(msgs['COM12178']);    // Please enter number only.
				formObj.vat_xch_rt.focus();
				return false;
			}
  			if(!ComChkValid(formObj)) return false;
  		}
  		
  		return true;
  	}

  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSearchEnd(sheetObj, errMsg){
 		 if (errMsg != "") return;
 		 if (sheetObj.EtcData("data_knt") != "1") {
			ComShowMessage(msgs['COM130401']);    // There is no data to search.
			document.form.ibflag.value = "I";
			//alert("document.form.ibflag.value:"+document.form.ibflag.value);
			return;
 		 }
         ComEtcDataToForm(document.form, sheetObj);    //조회된 ETC데이터를 Form의 오브젝트에 담는다.
         document.form.onchange_flag.value = "";
         document.form.ibflag.value = "U";
         //alert("document.form.ibflag.value:"+document.form.ibflag.value);
  	}

  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSaveEnd(sheetObj,errMsg){
  		 if (errMsg != "") return;
  		 ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
  		 doActionIBSheet(sheetObj,document.form,IBSEARCH);	
  		
  		 var rtnValue = new Array();
  		 rtnValue[0] = document.form.bil_to_loc_div_cd.value;
  		 rtnValue[1] = document.form.vat_xch_rt.value;
  		 window.returnValue = rtnValue;

  	}