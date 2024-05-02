/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0807.js
*@FileTitle : Recovery Activity Inquiry / Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-28
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2009-08-12 O Wan-Ki 			1.0	 최초 생성
* 2009-09-28 Jong-Geon Byeon	1.1 ALPS Migration
* 2010.12.13 신자영 [CHM-201007599-01] [TPB] Remark 입력 한도 설정
* 2010.12.14 변종건 [CHM-201007599-01] [TPB] Remark 입력 한도 설정
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
     * @class ESD_TPB_0807 : ESD_TPB_0807 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0807() {
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
	var beforetab = 1;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	
	var isReadOnly = "";
	
	/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

  	/**
  	 * IBTab Object를 초기화 설정
  	 * 탭 ID는 tab1,tab2,...
  	 * setupPage() 함수에서 loadPage() 호출 전에 이 함수를 호출한다.
  	 */
  	function InitTab() {
  		try{
  			with(document.all.tab1){
//  				InsertTab( 0, "TPB No" , -1 );
//  				InsertTab( 1, " Invoice No " , -1 );
  				//TabBackColor(0)="146,174,230";
  			}
  		}catch(e){
  			ComShowMessage(e);
  		}

  		if(document.form.s_n3pty_no.value == ''){
  			tabObjects[0].SelectedIndex = 1;
  		}
  	}
  	
  	/**
  	 * tab1의 onChange이벤트핸들러
  	 * IBSheetConfig.js에서 정의한 핸들러 함수를 구현한 것임
  	 */
  	function tab1_OnChange(obj,nItem){
  		ChangeTab(document.all.tab1,nItem);
  	}
  	
  	/**
  	 * IBTab Object 클릭할 때 해당 탭의 내용을 보여준다
  	 * 탭별로 그루핑된 DIV TAG의 ID는 모두 동일하게 "tabLayer"로 정한다.
  	 */
  	function ChangeTab(tabObj,nItem){
  		//tabObj.BackColor="#FFFFFF";
  		//tabObj.TabBackColor(nItem)="146,174,230";
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
  		curTab = beforetab+1;
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

  		isReadOnly = document.form.s_readonly.value;

  		for(i=0;i<sheetObjects.length;i++){
  		   //khlee-시작 환경 설정 함수 이름 변경
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//khlee-마지막 환경 설정 함수 추가
  			ComEndConfigSheet(sheetObjects[i]);
  		}

  		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
  		
  		var file_no = document.form.s_file_no.value; 
  		if ( file_no!=null && file_no.length > 0 ) {
  			getFileNo(file_no);
  		}
  	}

  	/**
  	 * 시트 초기설정값, 헤더 정의
  	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  	 */
  	function initSheet(sheetObj,sheetNo) {
  		sheetObj.UseUtf8 = true;
  		var cnt = 0;
  		switch(sheetNo) {
  		case 1:      //t1sheet1 init
  			with (sheetObj) {
  				//세로높이설정
  				style.height = 400;// 252 ;
  				//전체 너비 설정
  				SheetWidth = mainTable.clientWidth;

  				//Host정보 설정[필수][HostIp, Port, PagePath]
  				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

  				//전체Merge 종류 [선택, Default msNone]
  				MergeSheet = msAll;

  				//전체Edit 허용 여부 [선택, Default false]
  				Editable = true;

  				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  				InitRowInfo( 1, 1, 10, 100);

  				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  				InitColumnInfo(17, 2, 0, true);

  				// 해더에서 처리할 수 있는 각종 기능을 설정한다
  				InitHeadMode(true, true, false, true, false,false)

  				var HeadTitle = "Del.|STS|sortNo|TPB No.|Seq.|Remark|Update Date|Updated By|Updated By|Contact Person|Auto\nGenerated|Manual Input|File Attached|file no|n3pty_inv_no|n3pty_clt_rmk_tp_cd|file_count" ;
  				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  				InitHeadRow(0, HeadTitle, true);

  				//데이터속성     [ROW,     COL,   DATATYPE,WIDTH, DATAALIGN, COLMERGE, SAVENAME, 			 KEYFIELD, CALCULOGIC, 	 DATAFORMAT, POINTCOUNT,  UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  				InitDataProperty(0, cnt++ , dtDelCheck,   30,  daCenter,  false,    "");
  				InitDataProperty(0, cnt++ , dtStatus,     30,  daCenter,  false,    "ibflag");
  				InitDataProperty(0, cnt++ , dtHidden,    120,  daCenter,  true,     "sortNo",            	false,         "",       dfNone,   			0,     false,     false,	8);
  				InitDataProperty(0, cnt++ , dtData,      120,  daCenter,  true,     "n3pty_no",          	false,         "",       dfNone,   			0,     false,     false,	8);
  				InitDataProperty(0, cnt++ , dtData,       30,  daCenter,  false,    "ots_grp_rcvr_act_seq", false,         "",       dfNone,   			0,     false,     false,	8);
  				InitDataProperty(0, cnt++ , dtData,      250,  daLeft,    false,    "act_rmk",           	true,          "",       dfNone,   			0,     true,      true,		1000);
  				InitDataProperty(0, cnt++ , dtData,      100,  daCenter,  false,    "locl_cre_dt",       	true,          "",       dfNone,   			0,     false,     false     );
  				InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  false,    "clt_act_upd_ofc_cd",	false,         "",       dfNone,   			0,     false,     false,	6);
  				InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  false,    "upd_usr_id",        	false,         "",       dfNone,   			0,     false,     false,	20);
  				InitDataProperty(0, cnt++ , dtData,      100,  daCenter,  false,    "cntc_pson_nm",      	false,         "",       dfNone,   			0,     true,      true,		100);
  				InitDataProperty(0, cnt++ , dtCheckBox,   70,  daCenter,  false,    "n3pty_no_y",        	false,         "",       dfNone,   			0,     false,     false,	8);
  				InitDataProperty(0, cnt++ , dtCheckBox,   70,  daCenter,  false,    "n3pty_no_n",        	false,         "",       dfNone,           	0,     false,     false,	7);
  				InitDataProperty(0, cnt++ , dtData,       95,  daCenter,  false,    "img_file_no",       	false,         "",       dfNone,           	0,     false,     false,	8);
  				InitDataProperty(0, cnt++ , dtHidden,     80,  daCenter,  false,    "file_no",           	false,         "",       dfNone,           	0,     false,     false,	8);
  				InitDataProperty(0, cnt++ , dtHidden,     80,  daCenter,  false,    "n3pty_inv_no",     	false,         "",       dfNone,           	0,     false,     false,	8);
  				InitDataProperty(0, cnt++ , dtHidden,     80,  daCenter,  false,    "n3pty_clt_rmk_tp_cd",  false,         "",       dfNone,           	0,     false,     false,	8);
  				InitDataProperty(0, cnt++ , dtHidden,     80,  daCenter,  false,    "file_count",       	false,         "",       dfNone,           	0,     false,     false,	8);
  				 
  				// ImageList(0) = "/hanjin/img/enis/button/btns_filesearch.gif";
  				DataLinkMouse("img_file_no") = true;
  				WordWrap = true;

  			}
  			break;
/*
  		   case 2:      //t2sheet1 init
  			with (sheetObj) {
  				//세로높이설정
  				style.height = 232 ;
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
  				InitRowInfo( 1, 1, 10, 100);

  				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  				InitColumnInfo(13, 2, 0, true);

  				// 해더에서 처리할 수 있는 각종 기능을 설정한다
  				InitHeadMode(true, true, false, true, false,false)

  				var HeadTitle = "Del.|STS|Invoice No.|Seq.|Remark|Update Date|Updated By|Updated By|Contact Person|Auto Generated|Manual Input" ;
  				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  				InitHeadRow(0, HeadTitle, true);

  				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  				InitDataProperty(0, cnt++ , dtDelCheck,   30,  daCenter,  false,    "");
  				InitDataProperty(0, cnt++ , dtStatus,     30,  daCenter,  false,    "ibflag");
//  				InitDataProperty(0, cnt++ , dtSeq,        30,  daCenter,  false,    "");
  				InitDataProperty(0, cnt++ , dtData,       80,  daCenter,  true,    "n3pty_inv_no",     false,         "",       dfNone,           0,     false,      false,     8);
  				InitDataProperty(0, cnt++ , dtData,       30,  daCenter,  false,    "n3pty_inv_clt_act_seq", false,    "",       dfNone,           0,     false,      false,     8);
  				InitDataProperty(0, cnt++ , dtData,      250,  daLeft,    false,    "act_rmk",           true,          "",       dfNone,   		0,     true,       true,     1000);
//  				InitDataProperty(0, cnt++ , dtData,       85,  daCenter,  false,    "locl_cre_dt",       true,          "",    dfDateYmd,   		0,     false,      false,     8);
  				InitDataProperty(0, cnt++ , dtData,      100,  daCenter,  false,    "locl_cre_dt",       true,          "",       dfNone,   		0,     false,      false     );
  				InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  false,    "clt_act_upd_ofc_cd",false,         "",       dfNone,   		0,     false,      false,     6);
  				InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  false,    "upd_usr_id",        false,         "",       dfNone,   		0,     false,      false,     20);
  				InitDataProperty(0, cnt++ , dtData,      100,  daCenter,  false,    "cntc_pson_nm",      false,         "",       dfNone,   		0,     true,       true,     100);
  				//InitDataProperty(0, cnt++ , dtData,      200,  daLeft,  false,    "act_rmk",      true,          "",       dfNone,   		0,     true,      true,     1000);
  				InitDataProperty(0, cnt++ , dtCheckBox,   70,  daCenter,  false,    "n3pty_inv_no_y",    false,         "",       dfNone,   		0,     false,      false,     8);
  				InitDataProperty(0, cnt++ , dtCheckBox,   70,  daCenter,  false,    "n3pty_inv_no_n",    false,         "",       dfNone,           0,     false,      false,     7);

  				InitDataProperty(0, cnt++ , dtHidden,      80,  daCenter,  false,    "file_no",          false,         "",       dfNone,           0,     false,      false,     8);
  				InitDataProperty(0, cnt++ , dtHidden,      80,  daCenter,  false,    "n3pty_clt_rmk_tp_cd", false,      "",       dfNone,           0,     false,      false,     8);				 
  				//ImageList(0) = "/hanjin/img/enis/button/btns_filesearch.gif";
  				WordWrap = true;

  			}


  			break;
*/
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
  		 //if(curTab == 2)
  		//	formObject = document.form2;
  			
  		try {
  			var srcName = window.event.srcElement.getAttribute("name");

  			switch(srcName) {
  				case "btn_add1":
  					   doActionIBSheet(sheetObject,formObject,IBINSERT);
  					break;
  				case "btn_add2":
  					   doActionIBSheet(sheetObject,formObject,IBINSERT);
  					break;
  				case "btn_save1":
  					doActionIBSheet(sheetObject,formObject,MULTI01);
  					break;
  				case "btn_save2":
  					// doActionIBSheet(sheetObject,formObject,MULTI02);
  					break;
  				case "bttn_preview":
  					sheetObject.ExcelPrint = "PreView";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_downexcel":
  					sheetObject.ExcelPrint = "";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "bttn_print":
  					sheetObject.ExcelPrint = "PrintOnly";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_filesearch":
  					openFileUploadPopup(document.form.s_file_no.value, 'getFileNo', 'Y', 'Y', '', document.form.s_n3pty_inv_no.value);
  					break;
  				case "btn_close":
  					window.close();
  					break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowMessage(ComGetMsg('COM12111'));
  			} else {
  				ComShowMessage(e);
  			}
  		}
  	}
  	
  	/* Sheet관련 프로세스 처리 */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;
  		switch(sAction) {
  		   case SEARCH01:	  //조회
  				
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  		   
  				formObj.f_cmd.value = SEARCH01;
  				sheetObj.DoSearch4Post("ESD_TPB_0807GS.do", tpbFrmQryStr(formObj));
  				
  				//retrieveEnd(sheetObj);
  				break;
  			case MULTI01:		//저장

  				//2010.12.14 변종건 [CHM-201007599-01] [TPB] Remark 입력 한도 설정
	  			for(var idx=1;idx<=sheetObj.RowCount;idx++){
	  	        	if (sheetObj.CellValue(idx,"ibflag") == "I" 
	  	        		&& sheetObj.CellValue(idx,"act_rmk") == "Maximum 1,000 characters are allowed to leave as remarks. If more, please attach it with file after 'Confirmation'"){       		
	  	        		sheetObj.CellValue2(idx,"act_rmk") = "";
	  	        		sheetObj.CellFontColor(idx,"act_rmk") = sheetObj.RgbColor(0, 0, 0);
	  	        		sheetObj.CellFont("FontItalic",idx,"act_rmk") = false;
	  	        	}
	  	  		}
  			
  			
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				//n3pty_clt_rmk_tp_cd 세팅
  				for(var i=1;i<=sheetObj.RowCount;i++){
  					if(sheetObj.RowStatus(i) != "R"){
  						if(sheetObj.CellValue(i, "n3pty_no_n")=='1'){
  							sheetObj.CellValue(i,"n3pty_clt_rmk_tp_cd") = '1';
  						}
  					}
  				}				
  				formObj.f_cmd.value = MULTI01;
  				sheetObj.DoSave("ESD_TPB_0807GS.do", tpbFrmQryStr(formObj));
  				break;
  			case MULTI02:		//저장
  				
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				
  				//n3pty_clt_rmk_tp_cd 세팅
  				for(var i=1;i<=sheetObj.RowCount;i++){
  					if(sheetObj.RowStatus(i) != "R"){
  						if(sheetObj.CellValue(i, "n3pty_no_n")=='1'){
  							sheetObj.CellValue(i,"n3pty_clt_rmk_tp_cd") = '1';
  						}
  					}
  				}
  				formObj.f_cmd.value = MULTI02;

  				sheetObj.DoSave("ESD_TPB_0807GS.do", tpbFrmQryStr(formObj));
  				break;
  			case IBINSERT:	  //입력
  				var Row = sheetObj.DataInsert(-1);
  				sheetObj.CellValue2(Row,"ots_grp_rcvr_act_seq") = ComParseInt(sheetObj.CellValue(Row - 1,"ots_grp_rcvr_act_seq")) + 1;
  				sheetObj.CellValue2(Row,"upd_usr_id") = formObj.s_user_id.value;
  				sheetObj.CellValue2(Row,"locl_cre_dt") = getDateStrAdd(null, "", 0, "-");
  				sheetObj.CellValue2(Row,"img_file_no") = "File Attach";
  				// sheetObj.CellFontUnderline(Row, "img_file_no") = true;

  				if(curTab-1 == 0){
  					sheetObj.CellValue(Row,"n3pty_no") = formObj.s_n3pty_no.value;
  					sheetObj.CellValue(Row,"clt_act_upd_ofc_cd") = formObj.s_if_ofc_cd.value;
  					sheetObj.CellValue(Row,"n3pty_no_n") = '1';
  				}else if(curTab-1 == 1){
  					sheetObj.CellValue(Row,"clt_act_upd_ofc_cd") = formObj.s_if_ofc_cd.value;
  					sheetObj.CellValue(Row,"n3pty_inv_no_n") = '1';
  				}
  				//n3pty_clt_rmk_tp_cd 세팅
  				if(sheetObj.CellValue(Row, "n3pty_no_n")=='1'){
  					sheetObj.CellValue(Row,"n3pty_clt_rmk_tp_cd") = '1';
  				}
  				//n3pty_clt_rmk_tp_cd 세팅
  				if(sheetObj.CellValue(Row, "n3pty_inv_no_n")=='1'){
  					sheetObj.CellValue(Row,"n3pty_clt_rmk_tp_cd") = '1';
  				}
  				//2010.12.13 신자영 [CHM-201007599-01] [TPB] Remark 입력 한도 설정 - 초기 row add시 문구 설정
  				sheetObj.CellValue2(Row,"act_rmk") = "Maximum 1,000 characters are allowed to leave as remarks. If more, please attach it with file after 'Confirmation'";
  				sheetObj.CellFontColor(Row,"act_rmk") = sheetObj.RgbColor(153, 153, 153);
  				sheetObj.CellFont("FontItalic",Row,"act_rmk") = true;

  				break;
  			case IBCLEAR:	   //Clear
  				sheetObj.RemoveAll();
  				break;
  			case IBDOWNEXCEL:  //엑셀내려받기
  				sheetObj.SpeedDown2Excel(true);
  				break;
  		}
  	}
  	
  	function retrieveEnd(sheetObj){
  		var cnt = sheetObj.RowCount;
  		var idx;
  		
  		for(idx=1;idx<=cnt;idx++)
  		{
  			if (sheetObj.CellValue(idx, 'n3pty_no_y') == 0){
  				sheetObj.CellEditable(idx, 0) = false;
  			}
  		}
  		
  	}
  	
  	/**
  	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  	 */
  	function validateForm(sheetObj,formObj,sAction){
  		with(formObj){
  			/**
  			 * @TODO 개발자 분들께서 넣어 주셔야 합니다. 
  			 */
  			//if (!isNumber(formObj.iPage)) {
  			//	return false;
  		   // }
  		}
  		
  		return true;
  	}

  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  		try{
  			var matchYN = false;
  			var matchStr = '';
  			var tmpFileNo = '';
  			var n3pty_no = document.form.s_n3pty_no.value; 
  			for ( var i = 1; i <= sheetObj.RowCount; i++ ){
  				if(sheetObj.CellValue(i,'n3pty_no_y') == '1'){
  					sheetObj.RowEditable(i) = false;
  				}
  	
  				if(!matchYN && sheetObj.CellValue(i,'n3pty_no') == matchStr){
  					matchYN = true;
  				}
  				matchStr = sheetObj.CellValue(i,'n3pty_no');
  	
  				tmpFileNo = sheetObj.CellValue(i, "file_no");
  				tmpFileCount = sheetObj.CellValue(i, "file_count");
  				if ( tmpFileNo!=null && tmpFileNo.length>0 && tmpFileCount > 0){
  	    			sheetObj.CellFontUnderline(i, "img_file_no") = true;
  				} 
  			}
  			if(sheetObj.searchRows == 1) matchYN = true;
  			if(sheetObj.SearchRows > 0 && !matchYN){
  				document.all.btn_save1.style.display = "none";
  				document.all.btn_add1.style.display = "none";
  			}else{
  				document.all.btn_save1.style.display = "";
  				document.all.btn_add1.style.display = "";
  			}
  	
  			//Invoice쪽에서 호출하였을 경우는 3rd Party No. 저장 못함
  			if(document.form.s_n3pty_no.value == ''){
  				document.all.btn_save1.style.display = "none";
  				document.all.btn_add1.style.display = "none";
  			}
  		}catch(e){}
  	}	

  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
/*
  	function sheet2_OnSearchEnd(sheetObj,errMsg){
  		//if(errMsg!=null){
  		//	ComShowMessage(errMsg);
  		//}
  		document.form.s_n3pty_inv_no.value = sheetObj.EtcData("s_n3pty_inv_no");
  		for ( var i = 1; i <= sheetObj.RowCount; i++ ){
  			if(sheetObj.CellValue(i,'n3pty_inv_no_y') == '1'){
  				sheetObj.RowEditable(i) = false;
  			}
  			//file attach 설정
  			//if(i == 1){
  			//	//document.form.s_file_no.value = sheetObj.CellValue(i,'file_no');
  			//	//ifr.document.location.href = "TPBFileDownload.do?fileNo="+document.form.s_file_no.value+"&f_cmd="+SEARCH+"&downloadLink=Y&col=1";
  			//}
  		}

  		//Outstanding쪽에서 호출하였을 경우는 Invoice No. 저장 못함
  		if(document.form.s_n3pty_inv_no_origin.value == ''){
  			document.all.btn_save2.style.display = "none";
  			document.all.btn_add2.style.display = "none";
  			document.all.btn_filesearch.style.display = "none";
  		}
  	}
*/
  	/**
  	 * IBTab Object를 배열로 등록
  	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  	 * 배열은 소스 상단에 정의
  	 */
  	function setTabObject(tab_obj){
  		tabObjects[tabCnt++] = tab_obj;

  	}

  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSaveEnd(sheetObj,errMsg){

  		var matchYN = false;
  		var matchStr = '';
  		var tmpFileNo = '';
  		for ( var i = 1; i <= sheetObj.RowCount; i++ ){
  			if(sheetObj.CellValue(i,'n3pty_no_y') == '1'){
  				sheetObj.RowEditable(i) = false;
  			}

  			if(!matchYN && sheetObj.CellValue(i,'n3pty_no') == matchStr){
  				matchYN = true;
  			}
  			matchStr = sheetObj.CellValue(i,'n3pty_no');

  			tmpFileNo = sheetObj.CellValue(i, "file_no");
  			tmpFileCount = sheetObj.CellValue(i, "file_count");
  			if ( tmpFileNo!=null && tmpFileNo.length>0 && tmpFileCount > 0){
      			sheetObj.CellFontUnderline(i, "img_file_no") = true;
  			} 
  		}

  		if(errMsg==null || errMsg == ''){
  			ComShowMessage(ComGetMsg('COM12149','Data','',''));
  		}
  	}

  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	 
/*
  	function sheet2_OnSaveEnd(sheetObj,errMsg){
  		for ( var i = 1; i <= sheetObj.RowCount; i++ ){
  			if(sheetObj.CellValue(i,'n3pty_inv_no_y') == '1'){
  				sheetObj.RowEditable(i) = false;
  			}
  			//file attach 설정
  			// if(i == 1){
  			//	//document.form.s_file_no.value = sheetObj.CellValue(i,'file_no');
  			//	//ifr.document.location.href = "TPBFileDownload.do?fileNo="+document.form.s_file_no.value+"&f_cmd="+SEARCH+"&downloadLink=Y&col=1";
  			//}
  		}


  		if(errMsg==null || errMsg == ''){
  			ComShowMessage(getMsg('COM12149','Data','',''));
  		}
  	}
*/

  	var fileAttchRow = "0";
      function sheet1_OnClick(sheetObj,Row,Col,Value){
          if(sheetObj.ColSaveName(Col) == "img_file_no"){ // sheetObj.RowEditable(Row) && 
              var fileAttachAuthYn = "N";
  			if ( sheetObj.CellValue(Row, "n3pty_no_n")=='1' || sheetObj.CellValue(Row, "img_file_no").length>0) { // MANUAL INPUT 
  				if ( isReadOnly != "Y" // not read only
//      			    && sheetObj.CellValue(Row,'sortNo') != '1' // ROC From 
              		&& document.form.s_n3pty_no.value != ""  // inv 기준일 경우 
              		&& ( sheetObj.CellValue(Row,"upd_usr_id") == document.form.s_user_id.value ) // same user
              	   ){
              	    fileAttachAuthYn = "Y";
  				}
  				fileAttchRow = Row;
  			    var rtnValue = openFileUploadPopup(sheetObj.CellValue(Row,"file_no"), 'getFileNoSheet', 'Y', fileAttachAuthYn);
  			    getFileNoSheet(rtnValue);
  			}
  		}
  	}

  	function getFileNo(fileNoReceive){
  		document.form.s_file_no.value = fileNoReceive;
  		ifr.document.location.href = "TPBFileDownload.do?fileNo="+document.form.s_file_no.value+"&f_cmd="+SEARCH+"&downloadLink=Y&col=1";
  	}

  	function getFileNoSheet(fileNoReceive){
      	var currentFileNo = sheetObjects[0].CellValue(fileAttchRow, "file_no");
          if ( currentFileNo==undefined || currentFileNo==null || currentFileNo=="" || currentFileNo=="0" ) { // 현재 file no가 유효하지 않았을 경우
      		if ( fileNoReceive!=undefined && fileNoReceive!=null && fileNoReceive!="" && fileNoReceive!="0" ) {
                  sheetObjects[0].CellValue(fileAttchRow, "file_no") = fileNoReceive;
                  sheetObjects[0].CellFontUnderline(i, "img_file_no") = true;
              }
          }
  		// var rowStatus = sheetObjects[0].RowStatus(fileAttchRow);
  		// if ( rowStatus == 'R' ) { // R상태에서 file attach하였을 경우
  		// 	docObjects[0].RowStatus(fileAttchRow) = "U";
  		// }
  		fileAttchRow = "0"; // 초기화 
  	}
  	
  	//2010.12.14 변종건 [CHM-201007599-01] [TPB] Remark 입력 한도 설정
  	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
  		var colNm = sheetObj.ColSaveName(NewCol);

  		if( colNm == "act_rmk"){
        	if (sheetObj.CellValue(NewRow,"ibflag") == "I" 
        		&& sheetObj.CellValue(NewRow,"act_rmk") == "Maximum 1,000 characters are allowed to leave as remarks. If more, please attach it with file after 'Confirmation'"){       		
        		sheetObj.CellValue2(NewRow,"act_rmk") = "";
        		sheetObj.CellFontColor(NewRow,"act_rmk") = sheetObj.RgbColor(0, 0, 0);
        		sheetObj.CellFont("FontItalic",NewRow,"act_rmk") = false;
        	}
  		}
    }
