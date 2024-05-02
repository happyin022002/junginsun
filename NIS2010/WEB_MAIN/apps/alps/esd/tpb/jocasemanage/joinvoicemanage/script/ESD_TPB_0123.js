/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0123.js
*@FileTitle : JO TPB Invoice Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-26
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2008-09-11 Kim Jin-seung		1.0	 최초 생성
* 2009-10-26 Jong-Geon Byeon	1.1 ALPS Migration
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
     * @class ESD_TPB_105 : ESD_TPB_105 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_105() {
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
  var curTab = 1;
  var beforetab = 0;
  var sheetObjects = new Array();
  var sheetCnt = 0;

  /* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

  	/**
  	 * IBTab Object를 초기화 설정
  	 * 탭 ID는 tab1,tab2,...
  	 * setupPage() 함수에서 loadPage() 호출 전에 이 함수를 호출한다.
  	 */
  	function InitTab() {
  		try{
  			with(document.all.tab1){
  				InsertTab(0, "Dry Index" , 23 );
  				InsertTab(1, "Tanker Index" , 23); 
  				InsertTab(2, "Time Charter" , 23 );
  				InsertTab(3, "Bunker Price" , 23 );
  				InsertTab(4, "Ship Price" , 23); 
  				InsertTab(5, "FFA Index" , 23 );
  				TabBackColor(0)="146,174,230";
  			}
  		}catch(e){
  			ComShowMessage(e);
  		}
  	}
  	
  	/**
  	 * tab1의 onChange이벤트핸들러
  	 * IBSheetConfig.js에서 정의한 핸들러 함수를 구현한 것임
  	 */
  	function tab1_OnChange(nItem){
  		ChangeTab(document.all.tab1,nItem);
  	}
  	
  	/**
  	 * IBTab Object 클릭할 때 해당 탭의 내용을 보여준다
  	 * 탭별로 그루핑된 DIV TAG의 ID는 모두 동일하게 "tabLayer"로 정한다.
  	 */
  	function ChangeTab(tabObj,nItem){
  		tabObj.BackColor="#FFFFFF";
  		tabObj.TabBackColor(nItem)="146,174,230";
  	
  		var objs = document.all.item("tabLayer");
  		objs[beforetab].style.display = "none";
  		objs[nItem].style.display = "Inline";
  	
  		//--------------- 요기가 중요 --------------------------//
  		//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
  		//ksw수정 : zIndex가 -2이하로 가게되면 버튼클릭이 안됨
  		objs[beforetab].style.zIndex = 0;
  		objs[nItem].style.zIndex = 9;
  		//------------------------------------------------------//
  		beforetab= nItem;
  	}

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
  		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
  					style.height = 160;
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
  					InitColumnInfo(10, 3, 0, true);

  					// 해더에서 처리할 수 있는 각종 기능을 설정한다
  					InitHeadMode(true, true, false, true, false, false)
  		
  					var HeadTitle = "";

  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);
  		
  					//데이터속성	[ROW,	  COL,			DATATYPE, WIDTH,   DATAALIGN, COLMERGE,	 SAVENAME,   KEYFIELD, CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++, dtStatus,      150,    daCenter,  true,    "ibflag",        false,          "",       dfNone);
  					InitDataProperty(0, cnt++, dtData,       65,  daRight,   true,    "inv_iss_ofc_cd",        false,          "",    dfNone);
  					InitDataProperty(0, cnt++, dtData,       65,  daRight,   true,    "co_nm",        false,          "",    dfNone);
  					InitDataProperty(0, cnt++, dtData,       65,  daRight,   true,    "ofc_addr",        false,          "",    dfNone);
  					InitDataProperty(0, cnt++, dtData,       65,  daRight,   true,    "ofc_phn_no",        false,          "",    dfNone);
  					InitDataProperty(0, cnt++, dtData,       65,  daRight,   true,    "ofc_fax_no",        false,          "",    dfNone);
  					InitDataProperty(0, cnt++, dtData,       65,  daRight,   true,    "bil_to_loc_div_cd",        false,          "",    dfNone);
  					InitDataProperty(0, cnt++, dtData,       65,  daRight,   true,    "vat_xch_rt",        false,          "",    dfNone);
  					InitDataProperty(0, cnt++, dtData,       65,  daRight,   true,    "inv_rmk1",        false,          "",    dfNone);
  					InitDataProperty(0, cnt++, dtData,       65,  daRight,   true,    "inv_rmk2",        false,          "",    dfNone);

  				}
  				break;
  		}
  	}

  	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
  	document.onclick = processButtonClick;
  	
  	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
  	function processButtonClick(){
  		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 ****/
  		 var sheetObject = sheetObjects[curTab-1];
  		 /******************************************************/
  		 var formObject = document.form;
  		 if(curTab == 2)
  			formObject = document.form2;
  			
  		try {
  			var srcName = window.event.srcElement.getAttribute("name");

  			switch(srcName) {
  				case "btn_save":
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
  					break;
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btn_new":
  					var ofc_cd = formObject.s_inv_iss_ofc_cd.value;
  					formObject.reset();
  					formObject.s_inv_iss_ofc_cd.value = ofc_cd;
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
  				formObj.f_cmd.value = SEARCH;
  				sheetObj.DoSearch4Post("ESD_TPB_0123GS.do", tpbFrmQryStr(formObj));
  				break;
  				
  			case IBSAVE:		//저장
  				gridSave(sheetObj);
  				if(!validateForm(formObj)) {
  					return false;
  				}
  				formObj.f_cmd.value = MULTI;
  				sheetObj.DoSave("ESD_TPB_0123GS.do", tpbFrmQryStr(formObj),false);
  				sheetObj.RemoveAll();
  				break;
  		}
  	}
  	
  
  	function gridSave(sheetObj){
  		if(sheetObj.RowCount <= 0){
	  		sheetObj.DataInsert(0);
  		}
  		
  		sheetObj.CellValue2(1, 'inv_iss_ofc_cd') = document.form.s_inv_iss_ofc_cd.value;
  		sheetObj.CellValue2(1, 'vat_xch_rt') = document.form.s_vat_xch_rt.value;
  		sheetObj.CellValue2(1, 'co_nm') = document.form.s_co_nm.value;
  		sheetObj.CellValue2(1, 'bil_to_loc_div_cd') = document.form.s_bil_to_loc_div_cd.value;
  		sheetObj.CellValue2(1, 'ofc_addr') = document.form.s_ofc_addr.value;
  		sheetObj.CellValue2(1, 'ofc_phn_no') = document.form.s_ofc_phn_no.value;
  		sheetObj.CellValue2(1, 'ofc_fax_no') = document.form.s_ofc_fax_no.value;
  		sheetObj.CellValue2(1, 'inv_rmk1') = document.form.s_inv_rmk1.value;
  		sheetObj.CellValue2(1, 'inv_rmk2') = document.form.s_inv_rmk2.value;
  	}

  	/**
  	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  	 */
  	function validateForm(formObj){
  		with(formObj){
  			//VAT Rate 숫자 타입 체크
			if(!ComIsNumber(formObj.s_vat_xch_rt,".") && ComTrim(formObj.s_vat_xch_rt.value).length != 0){
				ComShowMessage(msgs['COM12178']);
				formObj.s_vat_xch_rt.focus();
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
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  		var ofc_cd = document.form.s_inv_iss_ofc_cd.value;
  		
  		document.form.s_inv_iss_ofc_cd.value = sheetObj.CellValue(1, 'inv_iss_ofc_cd');
  		document.form.s_vat_xch_rt.value = sheetObj.CellValue(1, 'vat_xch_rt');
  		document.form.s_co_nm.value = sheetObj.CellValue(1, 'co_nm');
  		ComSetObjValue(document.form.s_bil_to_loc_div_cd, sheetObj.CellValue(1, 'bil_to_loc_div_cd'));
	  	document.form.s_ofc_addr.value = sheetObj.CellValue(1, 'ofc_addr');
	  	document.form.s_ofc_phn_no.value = sheetObj.CellValue(1, 'ofc_phn_no');
	  	document.form.s_ofc_fax_no.value = sheetObj.CellValue(1, 'ofc_fax_no');
	  	document.form.s_inv_rmk1.value = sheetObj.CellValue(1, 'inv_rmk1');
	  	document.form.s_inv_rmk2.value = sheetObj.CellValue(1, 'inv_rmk2');
	  	
	  	if(sheetObj.RowCount > 0){
	  		sheetObj.RowStatus(1) = "U";
	  	} else{
	  		sheetObj.DataInsert(0);
	  		document.form.reset();
	  		document.form.s_inv_iss_ofc_cd.value = ofc_cd;
	  	}

  		if(errMsg!=null){
  			ComShowMessage(errMsg);
  		}

  	}

  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSaveEnd(sheetObj,errMsg){
  		if(errMsg==null || errMsg == ''){
  			ComShowMessage(getMsg('COM12149','Data','',''));
  		}
  		doActionIBSheet(sheetObj,document.form,IBSEARCH);	
  		
  		var rtnValue = new Array();
  		rtnValue[0] = document.form.s_bil_to_loc_div_cd.options[document.form.s_bil_to_loc_div_cd.selectedIndex].value;
  		rtnValue[1] = document.form.s_vat_xch_rt.value;
  		window.returnValue = rtnValue;

  	}
	/* 개발자 작업  끝 */