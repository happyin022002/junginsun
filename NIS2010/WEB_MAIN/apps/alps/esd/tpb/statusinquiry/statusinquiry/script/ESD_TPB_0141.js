/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0141.js
*@FileTitle : Fax/E-mail Sending History Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-17
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2015-04-17 KIM HYUN HWA	1.0	최초 생성
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
     * @class ESD_TPB_0141 : ESD_TPB_0141 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0141() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
    /* 공통전역변수 */

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
  		
  		document.form.s_vndr_cust_div_cd.onchange = s_vndr_cust_div_cd_OnChange_ToSearch; // for searching 
  		document.form.s_trd_party_val.onfocus = s_trd_party_val_OnFocus; // Added By Kim Jin-seung In 2007-06-21
  		document.form.s_trd_party_val.onblur = s_trd_party_val_OnBlur_ToSearch;
  		document.form.s_if_rhq_cd.onchange = if_rhq_cd_OnChange;
  		document.form.s_if_ctrl_cd.onchange = if_ctrl_cd_OnChange;
  		tpb_3rdPartyStaffClear(document.form.s_vndr_cust_div_cd);


  		
  		func_rhq_ctrl_ofc_list();
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
  					// 높이 설정
  					style.height = 410;
  										
  					//전체 너비 설정
  					SheetWidth = mainTable.clientWidth;

  					//Host정보 설정[필수][HostIp, Port, PagePath]
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

  					//전체Merge 종류 [선택, Default msNone]
  					//MergeSheet = msHeaderOnly;
  					MergeSheet = msAll;

  				   //전체Edit 허용 여부 [선택, Default false]
  					Editable = true;

  					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitRowInfo( 1, 1, 9, 100);

  					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitColumnInfo(13, 5, 0, true);

  					// 해더에서 처리할 수 있는 각종 기능을 설정한다
  					InitHeadMode(true, true, false, true, false, false)

  					var HeadTitle = "SEQ|Invoice No.|Ver.|3rd Party|3rd Party|type|Fax/Email|Result|Sent Date|Sender ID|Issued Date|Issued By|Office"; 

  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);
  					
  					//데이터속성       [ROW,   COL, DATATYPE,   	WIDTH,   DATAALIGN, COLMERGE, SAVENAME,  			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++, dtSeq,          25,    daCenter,  false,    "seq");
  					InitDataProperty(0, cnt++, dtData,         90,    daCenter,  false,    "n3pty_inv_no",         false,     "",    dfNone,    0,     	false,    false);
  					InitDataProperty(0, cnt++, dtData,     	   30,    daCenter,  false,    "n3pty_inv_rvis_cd",    false,     "",    dfNone,    0,     	false,    false);
  					InitDataProperty(0, cnt++, dtData,         60,    daCenter,  false,    "trd_party_cd",         false,     "",    dfNone,    0,     	false,    false);
  					InitDataProperty(0, cnt++, dtData,         120,   daLeft,    false,    "trd_party_nm",         false,     "",    dfNone,    0,     	false,    false);
  					InitDataProperty(0, cnt++, dtData,          35,   daCenter,  false,    "n3pty_inv_snd_tp_cd",  false,     "",    dfNone,    0,     	false,    false);
  					InitDataProperty(0, cnt++, dtData,         130,   daLeft,    false,    "vndr_cust_eml_fax",    false,     "",    dfNone,    0,     	false,    false);
  					InitDataProperty(0, cnt++, dtData,         120,   daLeft ,   false,    "fax_eml_snd_rslt_msg", false,     "",    dfNone,    0,     	false,    false);
  					InitDataProperty(0, cnt++, dtData,         120,   daCenter,  false,    "snd_dt",               false,     "",    dfNone,    0,     	false,    false);
  					InitDataProperty(0, cnt++, dtData,          60,   daCenter , false,    "cre_usr_id",           false,     "",    dfNone,    0,     	false,    false);
  					InitDataProperty(0, cnt++, dtData,          80,   daCenter , false,    "inv_iss_locl_dt",      false,     "",    dfNone,    0,     	false,    false);
  					InitDataProperty(0, cnt++, dtData,          60,   daCenter , false,    "iss_usr_id",           false,     "",    dfNone,    0,     	false,    false);
  	 				InitDataProperty(0, cnt++, dtData,          30,   daCenter,  false,    "ofc_cd",         	   false,     "",    dfNone,    0,     	false,    false);

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
  				case "btn_downexcel":
  					sheetObject.ExcelPrint = "";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_retrieve":
  					
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btn_3rdParty":
  					get3rdParty( formObject.all.s_vndr_cust_div_cd.value );
  					break;

				case "btns_sender_id":
					  ComOpenPopup('/hanjin/COM_ENS_091.do', 770, 570, "setUsrNm", "1,0,1,1,1,1,1", true);
					break;

  				case "btn_new":
  					sheetObject.RemoveAll();
  					formObject.reset();
  					break;
  				case "btns_calendar1":
  					 if(!window.event.srcElement.disabled){
  						 var cal = new calendarPopup();
  						 cal.select(formObject.s_sdate, 's_sdate', 'yyyy-MM-dd');
  					 }
  					break;
  				case "btns_calendar2":
  					if (!document.all.btns_calendar2.disabled){
	  					var cal = new ComCalendarFromTo();
	  					cal.displayType = "date";
	  					cal.select(formObject.s_sdate, formObject.s_edate,'yyyy-MM-dd');
  					}
  					break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowCodeMessage('COM12111');
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
  				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
  				var div = formObj.s_vndr_cust_div_cd.value;
  				var val = formObj.s_trd_party_val.value;
  				if(val !=""){
  				   if (div == "C"){
	  					formObj.s_cust_cnt_cd.value = val.substr(0,2);
	  					formObj.s_cust_seq.value = val.substr(2,6);
	  					formObj.s_vndr_seq.value = "";
  				   }else if(div == "V"){
  					    formObj.s_cust_cnt_cd.value = "";
	  					formObj.s_cust_seq.value = "";
	  					formObj.s_vndr_seq.value = val;
  				   }
  				 }else{
  					formObj.s_vndr_seq.value = "";
  					formObj.s_cust_cnt_cd.value = "";
  					formObj.s_cust_seq.value = "";
  				 }
  				
  				formObj.f_cmd.value = SEARCH;
  				sheetObj.DoSearch4Post("ESD_TPB_0141GS.do", tpbFrmQryStr(formObj));
  				break;
  		   case IBDOWNEXCEL:  //엑셀내려받기
  				sheetObj.SpeedDown2Excel(true);
  				break;
  		}
  	}
  	
  	/**
  	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  	 */
  	function validateForm(sheetObj,formObj,sAction){
  		with(formObj){
   		    
  			if(!ComChkValid(formObj)) return false;
  		}
  		
  		return true;
  	}

  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){

  	}
  	
    /*
     * Issue Name 공통팝업에서 선택한 Issue Name, Issue Code값을 해당 필드에 설정 
     */
    function setUsrNm(aryPopupData){
        document.form.sndrnmm.value = aryPopupData[0][5];
        document.form.sndrid.value = aryPopupData[0][4];
    } 	
  	
	/* 개발자 작업  끝 */