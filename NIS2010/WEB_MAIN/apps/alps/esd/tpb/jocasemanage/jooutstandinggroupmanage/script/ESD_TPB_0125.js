/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0125.js
*@FileTitle : JO TPB Modification
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.16
*@LastModifier : 박성진
*@LastVersion : 1.6
* 2008-09-11 O Wan-Ki 1.0 최초 생성
* 2008-11-19 O Wan-Ki 1.1 JO TPB Cancel 기능 추가
* 2008-11-25 O Wan-Ki 1.2 JO TPB Cancel CSR Valid 추가
* 2008-12-08 O Wan-Ki 1.3 JO TPB Cancel Process Upgrade
* 2009-01-16 O Wan-Ki 1.4 VVD 9digit Role에 따른 보완.
* 2009-01-20 O Wan-Ki 1.5 bkg_no, bl_no 수정로직 변경.
* 2009-11-16 Park Sung-Jin 1.6 ALPS Migration 작업
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
     * @class ESD_TPB_0125 : ESD_TPB_0125 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0125() {
    	this.processButtonClick     = processButtonClick;
        this.setSheetObject         = setSheetObject;
        this.setComboObject         = setComboObject;
        this.setTabObject           = setTabObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;        
        this.initControl            = initControl;
        this.initTab                = initTab;
        this.doActionIBSheet        = doActionIBSheet;
        this.validateForm           = validateForm;
    }
    
   	/* 개발자 작업	*/
    /* 공통전역변수 */
  //var calPop = new calendarPopupGrid();
  var curTab = 1;
  var beforetab = 0;
  var sheetObjects = new Array();
  var sheetCnt = 0;
  var currentRow = 0;

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

  		if ( document.form.s_n3pty_no_strs_link.value.length >= 14) {
  			document.form.s_n3pty_no.value = document.form.s_n3pty_no_strs_link.value
  		    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  		}		
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
  					style.height = 450;
  					//전체 너비 설정
  					SheetWidth = mainTable.clientWidth;
  		
  					//Host정보 설정[필수][HostIp, Port, PagePath]
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
  		
  					//전체Merge 종류 [선택, Default msNone]
  					MergeSheet = msHeaderOnly;
  		
  					//전체Edit 허용 여부 [선택, Default false]
  					Editable = true;
  		
  					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitRowInfo( 2, 1, 9);
  		
  					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitColumnInfo(33, 6, 0, true);

  					// 해더에서 처리할 수 있는 각종 기능을 설정한다
  					InitHeadMode(true, true, true, true, false, false)
  		
  					var HeadTitle1 = "Del.|STS|csrvaild|editable|ots_dtl_seq|TPB No.|SEQ|Exp. Type|Exp. Type|S/P Inv No.|BKG No.|B/L No.|VVD|EQ No.|3rd Party|3rd Party|TPB Status|Curr.|Confirmed|n3pty_bil_tp_cd|bkg_no|bkg_no_split|bl_no|bl_no_tp|bl_no_chk|vsl_cd|skd_voy_no|finc_dir_cd|vvd_cd|vndr_seq|cust_cnt_cd|cust_seq|n3pty_ofc_cd";
  					var HeadTitle2 = "Del.|STS|csrvaild|editable|ots_dtl_seq|TPB No.|SEQ|Main|Sub|S/P Inv No.|BKG No.|B/L No.|VVD|EQ No.|Code|Name|TPB Status|Curr.|Confirmed|n3pty_bil_tp_cd|bkg_no|bkg_no_split|bl_no|bl_no_tp|bl_no_chk|vsl_cd|skd_voy_no|finc_dir_cd|vvd_cd|vndr_seq|cust_cnt_cd|cust_seq|n3pty_ofc_cd";

  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle1, true);
  					InitHeadRow(1, HeadTitle2, true);
  		
  					//  [ROW ,COL    ,DATATYPE   ,WIDTH  ,DATAALIGN ,COLMERGE ,SAVENAME                  ,KEYFIELD ,CALCULOGIC ,DATAFORMAT ,POINTCOUNT ,UPDATEEDIT ,INSERTEDIT ,EDITLEN ,FULLINPUT ,SORTENABLE ,TOOLTIP ,ALLCHECK ,SAVESTATUS ,FORMATFIX]
  					//  InitDataProperty(0   ,cnt++  ,dtDelCheck ,30     ,daCenter  ,true     ,""                        ,false    ,""         ,dfNone     ,0          ,false      ,false      ,0       ,false     ,false      ,""      ,false);
  					InitDataProperty(0   ,cnt++  ,dtHidden   ,30     ,daCenter  ,true     ,""                        ,false    ,""         ,dfNone     ,0          ,false      ,false      ,0       ,false     ,false      ,""      ,false);
  					InitDataProperty(0   ,cnt++  ,dtStatus   ,30     ,daCenter  ,true     ,"ibflag"                  );
  					InitDataProperty(0   ,cnt++  ,dtHidden   ,30     ,daCenter  ,true     ,"csrvalid"                ,false    ,""         ,dfNone     ,0          ,false      ,true       ); // * 2008-11-25 O Wan-Ki 1.2 JO TPB Cancel CSR Valid 추가
  					InitDataProperty(0   ,cnt++  ,dtHidden   ,30     ,daCenter  ,true     ,"editable"                ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					InitDataProperty(0   ,cnt++  ,dtHidden   ,50     ,daCenter  ,true     ,"ots_dtl_seq"             ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					InitDataProperty(0   ,cnt++  ,dtData     ,100    ,daCenter  ,true     ,"n3pty_no"                ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					InitDataProperty(0   ,cnt++  ,dtData     ,40     ,daCenter  ,true     ,"n3pty_no_dp_seq"         ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  	
  					InitDataProperty(0   ,cnt++  ,dtData     ,40     ,daCenter  ,true     ,"n3pty_src_sub_sys_cd"    ,false    ,""         ,dfNone     ,0          ,false      ,true       );	// Exp.Type - Main
  					InitDataProperty(0   ,cnt++  ,dtData     ,120    ,daCenter  ,true     ,"n3pty_bil_tp_nm"         ,false    ,""         ,dfNone     ,0          ,false      ,true       );	// Exp.Type - Sub
  					InitDataProperty(0   ,cnt++  ,dtData     ,110    ,daCenter  ,true     ,"n3pty_src_no_visible"    ,false    ,""         ,dfNone     ,0          ,false      ,true       );	// S/P Inv No.(칼럼명:n3pty_src_no)
  					
  					InitDataProperty(0   ,cnt++  ,dtData     ,90     ,daCenter  ,true     ,"bkg_no_all"              ,false    ,""         ,dfNone     ,0          ,false      ,true       );	// BKG No.
  					InitDataProperty(0   ,cnt++  ,dtData     ,90     ,daCenter  ,true     ,"bl_no_all"               ,false    ,""         ,dfNone     ,0          ,false      ,true       );	// B/L No.
  					InitDataProperty(0   ,cnt++  ,dtData     ,80     ,daCenter  ,true     ,"g_vvd"                   ,false    ,""         ,dfNone     ,0          ,false      ,true       ,9);	// VVD
  					InitDataProperty(0   ,cnt++  ,dtData     ,90     ,daCenter  ,true     ,"eq_no"                   ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					
  					InitDataProperty(0   ,cnt++  ,dtCombo    ,60     ,daCenter  ,true     ,"vndr_cust_div_cd"        ,false    ,""         ,dfNone     ,0          ,true       ,false      ,0 );	// 3rd Party - Type
  					InitDataProperty(0   ,cnt++  ,dtData     ,100    ,daCenter  ,true     ,"trd_party_val"           ,false    ,""         ,dfNone     ,0          ,true       ,false      ,0 );// 3rd Party - Code

  					InitDataProperty(0   ,cnt++  ,dtData     ,150    ,daLeft    ,true     ,"ots_sts_nm"              ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					InitDataProperty(0   ,cnt++  ,dtData     ,50     ,daCenter  ,true     ,"curr_cd"                 ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					InitDataProperty(0   ,cnt++  ,dtData     ,70     ,daRight   ,true     ,"cfm_amt"                 ,false    ,""         ,dfFloat    ,2          ,false      ,false      );

  					// hidden data
  					InitDataProperty(0   ,cnt++  ,dtHidden   ,50     ,daCenter  ,true     ,"n3pty_bil_tp_cd"         ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					
  					InitDataProperty(0   ,cnt++  ,dtHidden   ,50     ,daCenter  ,true     ,"bkg_no"                  ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					InitDataProperty(0   ,cnt++  ,dtHidden   ,50     ,daCenter  ,true     ,"bkg_no_split"            ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					
  					InitDataProperty(0   ,cnt++  ,dtHidden   ,50     ,daCenter  ,true     ,"bl_no"                   ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					InitDataProperty(0   ,cnt++  ,dtHidden   ,50     ,daCenter  ,true     ,"bl_no_tp"                ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					InitDataProperty(0   ,cnt++  ,dtHidden   ,50     ,daCenter  ,true     ,"bl_no_chk"               ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					
  					InitDataProperty(0   ,cnt++  ,dtHidden   ,50     ,daCenter  ,true     ,"vsl_cd"                  ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					InitDataProperty(0   ,cnt++  ,dtHidden   ,50     ,daCenter  ,true     ,"skd_voy_no"              ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					InitDataProperty(0   ,cnt++  ,dtHidden   ,50     ,daCenter  ,true     ,"finc_dir_cd"             ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					
  					InitDataProperty(0   ,cnt++  ,dtHidden   ,50     ,daCenter  ,true     ,"vvd_cd"                  ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					
  					InitDataProperty(0   ,cnt++  ,dtHidden   ,50     ,daCenter  ,true     ,"vndr_seq"                ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					InitDataProperty(0   ,cnt++  ,dtHidden   ,50     ,daCenter  ,true     ,"cust_cnt_cd"             ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					InitDataProperty(0   ,cnt++  ,dtHidden   ,50     ,daCenter  ,true     ,"cust_seq"                ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					InitDataProperty(0   ,cnt++  ,dtHidden   ,50     ,daCenter  ,true     ,"n3pty_ofc_cd"            ,false    ,""         ,dfNone     ,0          ,false      ,true       );

  					sheetObj.DataLinkMouse("vndr_cust_div_cd") = true;
  					sheetObj.DataLinkMouse("trd_party_val") = true;
  					InitDataCombo (0, "vndr_cust_div_cd", " |"+combo01Text, " |"+combo01Code);
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
  				case "btn_jotpbcancel":
  					doActionIBSheet(sheetObject,formObject,COMMAND01);
  					break;
  				case "btn_save":
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
  					break;
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btn_new":
  					sheetObject.RemoveAll();
  					formObject.reset();
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

  				formObj.f_cmd.value = SEARCH;
  				sheetObj.DoSearch4Post("ESD_TPB_0125GS.do", tpbFrmQryStr(formObj));

  				break;
  			case IBSAVE:		//저장
  				
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  			
  				//VVD 항목 체크(VVD값이 모두 동일해야하나 일부 공백이나 다른 값이 올 경우 저장 불가)
				var vvdDiffVal = 0;
				for(var idx=2;idx<=sheetObj.RowCount+1;idx++)
				{
					if(sheetObj.CellValue(2,'g_vvd') != sheetObj.CellValue(idx,'g_vvd'))
					{
						vvdDiffVal++;
					}
				}

				if(vvdDiffVal != 0)
				{
					ComShowCodeMessage('TPB90070');
					return false;
				}

  				formObj.f_cmd.value = MULTI;
  				sheetObj.DoSave("ESD_TPB_0125GS.do", tpbFrmQryStr(formObj));
  				break;
  				
  			case IBINSERT:	  //입력
  				var Row = sheetObj.DataInsert();
  				break;

  			case IBCLEAR:	   //Clear
  				sheetObj.RemoveAll();
  				break;

  			case IBDOWNEXCEL:  //엑셀내려받기
  				sheetObj.SpeedDown2Excel(true);
  				break;

  			case COMMAND01: // JO TPB Cancel
  				formObj.f_cmd.value = REMOVE; // COMMAND01==1
  				sheetObj.RowStatus(2) = 'U';
  				sheetObj.DoSave("ESD_TPB_0125GS.do", tpbFrmQryStr(formObj));
  				if( sheetObj.RowCount > 0 ){
  					sheetObj.RowStatus(2) = 'R';
  				}
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
  	
  		for ( var i = 2; i <= sheetObj.RowCount+1; i++ ){
  			
  			// 3rd Party 항목에 팝업가능 표시 - underline
  			if(sheetObj.CellValue(i, "vndr_cust_div_cd") != "" ){ 
  				sheetObj.CellFontUnderline(i, "vndr_cust_div_cd") = true;
  			}
  			if(sheetObj.CellValue(i, "trd_party_val") != "" ){ 
  				sheetObj.CellFontUnderline(i, "trd_party_val") = true;
  			}
  			
  			// EDITABLE_YN 칼럼에 따른 처리.
  			if(sheetObj.CellValue(i,"editable")=="Y"){
  				sheetObj.CellEditable(i,          "bkg_no_all") = true;
  				sheetObj.CellEditable(i,           "bl_no_all") = true;
  				sheetObj.CellEditable(i,               "g_vvd") = true;
  				sheetObj.CellEditable(i,               "eq_no") = true;
  				
  			}else if(sheetObj.CellValue(i,"editable")=="N"){
  				sheetObj.RowEditable(i)=false;
  			}
  		}

  		//Outstanding Amount 의 Auto Upate check
  		tpb_chgColor_ots_amt(sheetObj, 27, 12);
  	}
  					
  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSaveEnd(sheetObj,errMsg){
  		if(errMsg==null || errMsg == ''){
  			ComShowCodeMessage('COM12149','Data','','');
  		}
  		for ( var i = 2; i <= sheetObj.RowCount+1; i++ ){
	  		if(sheetObj.CellValue(i,"editable")=="Y"){
				sheetObj.CellEditable(i,          "bkg_no_all") = true;
				sheetObj.CellEditable(i,           "bl_no_all") = true;
				sheetObj.CellEditable(i,               "g_vvd") = true;
				sheetObj.CellEditable(i,               "eq_no") = true;
				
			}else if(sheetObj.CellValue(i,"editable")=="N"){
				sheetObj.RowEditable(i)=false;
			}
  		}
  	}

  	function sheet1_OnClick(sheetObj,Row,Col,Value){

  		var colNm = sheetObj.ColSaveName(Col);
  		
  		// 3rd Party Selection 호출
  		if( colNm == 'vndr_cust_div_cd'||colNm == 'trd_party_val' ){
  			var vndr_cust_div_cd = sheetObj.CellValue(Row, "vndr_cust_div_cd");
  			var trd_party_val = sheetObj.CellValue(Row, "trd_party_val");
  			
  			var param;
  			var theURL;
  			var winName;
  			var features;
  	
  			param = "?vndr_cust_div_cd="+sheetObj.CellValue(Row,"vndr_cust_div_cd")+"&trd_party_val="+sheetObj.CellValue(Row,"trd_party_val");
  			theURL = "ESD_TPB_0809.do"+param;
  			winName = "ESD_TPB_0809";
  			features = "scroll:no;status:no;help:no;dialogWidth:310px;dialogHeight:220px";
  			
  			var rtnValue = window.showModalDialog(theURL, window, features);
  		    
	    	if(rtnValue != undefined && rtnValue != null ){
	    		gen3rdParty(rtnValue.divCd, rtnValue.trdVal);
	    	}
  		}
  	}

  	
  	function sheet1_OnPopupClick(sheetObj,Row,Col){
  		get3rdPartyTarget_sheet( sheetObj.CellValue(Row,"vndr_cust_div_cd"), Row,Col,sheetObj );
  	}
  	
  	function sheet1_OnChange(sheetObj,Row,Col,Value){
  		var row_cnt = sheetObj.RowCount+1;
  		currentRow = Row;
  		
  		// * 2009-01-20 O Wan-Ki 1.2 bkg_no, bl_no 수정로직 변경.
  		var bkg_no_all = sheetObj.CellValue(Row, "bkg_no_all");
  		bkg_no_all = ComTrim(bkg_no_all).toUpperCase(); // ComTrim & UPPER CASE
  		sheetObj.CellValue2(Row, "bkg_no_all") = bkg_no_all;
  		
  		var bl_no_all = sheetObj.CellValue(Row, "bl_no_all");
  		bl_no_all = ComTrim(bl_no_all).toUpperCase(); // ComTrim & UPPER CASE
  		sheetObj.CellValue2(Row, "bl_no_all") = bl_no_all;
  		
  		var g_vvd = sheetObj.CellValue(Row, "g_vvd");
  		g_vvd = ComTrim(g_vvd).toUpperCase(); // ComTrim & UPPER CASE
  		sheetObj.CellValue2(Row, "g_vvd") = g_vvd;
  		
  		var eq_no = sheetObj.CellValue(Row, "eq_no");
  		eq_no = ComTrim(eq_no).toUpperCase(); // ComTrim & UPPER CASE
  		sheetObj.CellValue2(Row, "eq_no") = eq_no;
  		//////////////////////////////////////////////////////

  		var vndr_cust_div_cd = sheetObj.CellValue(Row, "vndr_cust_div_cd");
  		var trd_party_val = sheetObj.CellValue(Row, "trd_party_val");
  		trd_party_val = ComTrim(trd_party_val).toUpperCase(); // ComTrim & UPPER CASE 
  		var n3pty_bil_tp_cd = sheetObj.CellValue(Row, "n3pty_bil_tp_cd");
  		sheetObj.CellValue2(Row, "trd_party_val") = trd_party_val;
  		var colNm = sheetObj.ColSaveName(Col);
  		
  		if ( colNm == 'trd_party_val' && ( vndr_cust_div_cd=="V" || vndr_cust_div_cd=="C" || vndr_cust_div_cd=="S" ) ){ // Add colNm condition By Kim Jin-seung In 2008-05-21
  	          // server side로부터 가져와서 getTPBGenCombo 함수이하에서 직접 처리함 
  	          document.all.s_vndr_cust_div_cd.value = vndr_cust_div_cd; // input type hidden 이용 
  	          document.all.s_trd_party_val.value = trd_party_val; // input type hidden 이용 
  	          // ComShowMessage(" .. " +Row);
  	          getTPBGenCombo('Void_ThirdParty_Sheet','checkTrdParty','V','','',new Array("s_trd_party_val","s_vndr_cust_div_cd"), Row); 
  	    }

  	    //** TPB요소의 변경이 일어났을 경우 정합성 체크.
  	    // vndr_cust_div_cd 를 변경하였을 경우 trd_party_val 값을 "" 로 변경.
  	    if(sheetObj.ColSaveName(Col) =="vndr_cust_div_cd" ){
  		    for ( var i = 2; i <= row_cnt; i++ ){
  				sheetObj.CellValue2(i, "vndr_cust_div_cd") = vndr_cust_div_cd;
  				sheetObj.CellValue2(i, "trd_party_val") = "";
  			}
  	    }
  	    

  	    //Validation Check
  		if( colNm == 'bkg_no_all' && Value != '')
  		{
  			document.form.s_bkg_no.value = Value;
  			getTPBGenCombo('CheckBkgNo','checkBLNo','V','','',new Array('s_bkg_no'),Value);
  		}

  		if( colNm == 'bl_no_all' && Value != '')
  		{
  			document.form.s_bl_no_all.value = Value;
  			getTPBGenCombo('CheckBlNo','checkBKGNoWithBLNo','V','','',new Array('s_bl_no_all'),Value);
  		}
  		
  		if( colNm == 'g_vvd' && Value.length >= 9)
  		{
  			document.form.s_vvd.value = Value;
  			getTPBGenCombo('CheckVvdNo','searchCheckVVD','V','','',new Array('s_vvd','otherObjs'),Value);
  		}
  		else if(colNm == 'g_vvd' && Value.length < 9 && Value.length != '')
  		{
  			ComShowCodeMessage('TPB90070');
  			sheetObjects[0].CellValue2(currentRow, "g_vvd") = "";
  		}
  	}
  	
  	function bkgAutoInput(chkFlg,chkVal){
  	    if(chkFlg == false)
  	    {
  	    	ComShowCodeMessage('TPB90100');
			sheetObjects[0].CellValue2(currentRow, "bkg_no_all") = "";
  	    }
  	    else
  	    {
  	    	sheetObjects[0].CellValue2(currentRow,"bl_no_all") = chkVal;
	    	sheetObjects[0].CellValue2(currentRow,"bl_no") = chkVal;
	    	
//	    	// BKG No. 를 입력 하였을 경우 모든 ROW에 같은 값을 반영.
//  	    	var row_cnt = sheetObjects[0].RowCount+1;
//	  		bkg_no_all = sheetObjects[0].CellValue(-1, "bl_no_all");
//	    	for ( var i = 2; i <= row_cnt; i++ )
//	    	{
//		    	if(sheetObjects[0].CellValue(i, "bkg_no_all") == _TEMP_VALUE){ //2009-01-20 O Wan-Ki 1.2 bkg_no, bl_no 수정로직 변경.
//		    		sheetObjects[0].CellValue2(i, "bkg_no_all") = bkg_no_all;
//					// hidden 칼럼에 변경값 입력
//		    		sheetObjects[0].CellValue2(i, "bkg_no") = bkg_no_all;
//				}
//			}
//			_TEMP_VALUE = bkg_no_all;
  	    }
  	}
  	
  	function blAutoInput(chkFlg,chkVal){
  		if(chkFlg == false)
  		{
  			ComShowCodeMessage('TPB90101');
			sheetObjects[0].CellValue2(currentRow, "bl_no_all") = "";
	    }
	    else
	    {
	    	sheetObjects[0].CellValue2(currentRow,"bkg_no_all") = chkVal;
	    	sheetObjects[0].CellValue2(currentRow,"bkg_no") = chkVal;
	    	
//	    	// B/L No. 를 입력 하였을 경우 모든 ROW에 같은 값을 반영.
//	  		var row_cnt = sheetObjects[0].RowCount+1;
//	  		bl_no_all = sheetObjects[0].CellValue(-1, "bl_no_all");
//	  		for ( var i = 2; i <= row_cnt; i++ )
//	  		{
//	    		if(sheetObjects[0].CellValue(i, "bl_no_all") == _TEMP_VALUE){ //2009-01-20 O Wan-Ki 1.2 bkg_no, bl_no 수정로직 변경.
//		    		sheetObjects[0].CellValue2(i, "bl_no_all") = bl_no_all;
//					// hidden 칼럼에 변경값 입력
//		    		sheetObjects[0].CellValue2(i, "bl_no") = bl_no_all;
//				}
//			}
//			_TEMP_VALUE = bl_no_all;
	    }
  	}
  	 
  	function vvdAutoInput(chkFlg){
  	    // VVD 를 입력 하였을 경우 모든 ROW에 같은 값을 반영.
  		if(chkFlg == false)
  		{
  			ComShowCodeMessage('TPB90070');
			sheetObjects[0].CellValue2(currentRow, "g_vvd") = "";
	    }
	    else
	    {
	    	var n3pty_bil_tp_cd = sheetObjects[0].CellValue(currentRow, "n3pty_bil_tp_cd");
	    	var row_cnt = sheetObjects[0].RowCount+1;
	  		g_vvd = sheetObjects[0].CellValue(-1, "g_vvd");
		    for ( var i = 2; i <= row_cnt; i++ )
		    {
		    	sheetObjects[0].CellValue2(i, "g_vvd") = g_vvd;
	
				if( n3pty_bil_tp_cd == 'JO' ){
					sheetObjects[0].CellValue2(i, "vvd_cd") = g_vvd;
				}else{
					sheetObjects[0].CellValue2(i, "vsl_cd") = g_vvd.substring(0,4);
					sheetObjects[0].CellValue2(i, "skd_voy_no") = g_vvd.substring(4,8);
					sheetObjects[0].CellValue2(i, "finc_dir_cd") = g_vvd.substring(8,10);
				}
			}
	    }
  	}
  	
  	/** BL_NO,BKG_NO 의 수정이 일어날 때, 같은 항목만 변경시키기 위한 저장 **/
  	var _TEMP_VALUE;
  	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
  		// 2009-01-20 O Wan-Ki 1.2 bkg_no, bl_no 수정로직 변경.
  		var colNm = sheetObj.ColSaveName(NewCol);
  		
  		/** BL_NO,BKG_NO 의 수정이 일어날 때, 같은 항목만 변경시키기 위한 저장 **/
  		if( colNm == "bl_no_all" || colNm == "bkg_no_all" ){
  			_TEMP_VALUE = sheetObj.CellValue(NewRow,NewCol);
  		}
  		// * 2008-12-08 O Wan-Ki 1.3 JO TPB Cancel Process Upgrade
  		if( sheetObj.CellValue(NewRow, "editable") == "Y" ){
  			//document.form.btn_jotpbcancel.style.display = "";
  			sheetObj.CellEditable(NewRow,0) = true;
  		}else if( sheetObj.CellValue(NewRow, "editable") == "N" ){
  			//document.form.btn_jotpbcancel.style.display = "none";
  			sheetObj.CellEditable(NewRow,0) = false;
  		}
      }
      
      function gen3rdParty( vndr_cust_div_cd, trd_party_val ){

      	var len = document.all.sheet1.RowCount+1;
  		trd_party_val = ComTrim(trd_party_val).toUpperCase(); // TRIM & UPPER CASE 
      	
  		// trd_party_val 입력 하였을 경우 모든 ROW에 같은 값을 반영.
  		for(var i=2 ; i<=len ; i++ ){
  			
  			document.all.sheet1.CellValue(i,"vndr_cust_div_cd") = vndr_cust_div_cd;
  			document.all.sheet1.CellValue(i,"trd_party_val") = trd_party_val;
  			
  			if( vndr_cust_div_cd == 'V' ){
  				document.all.sheet1.CellValue2(i, "vndr_seq") = trd_party_val;
  				
  				document.all.sheet1.CellValue2(i, "cust_cnt_cd") = "";
  				document.all.sheet1.CellValue2(i, "cust_seq") = "";
  				document.all.sheet1.CellValue2(i, "n3pty_ofc_cd") = "";
  		
  			}else if( vndr_cust_div_cd == 'C' ){
  				document.all.sheet1.CellValue2(i, "cust_cnt_cd") = trd_party_val.substring(0,2);
  				document.all.sheet1.CellValue2(i, "cust_seq") = trd_party_val.substring(2,8);
  				
  				document.all.sheet1.CellValue2(i, "vndr_seq") = "";
  				document.all.sheet1.CellValue2(i, "n3pty_ofc_cd") = "";
  				
  			}else if( vndr_cust_div_cd == 'S' ){
  				document.all.sheet1.CellValue2(i, "n3pty_ofc_cd") = trd_party_val;
  				
  				document.all.sheet1.CellValue2(i, "vndr_seq") = "";
  				document.all.sheet1.CellValue2(i, "cust_cnt_cd") = "";
  				document.all.sheet1.CellValue2(i, "cust_seq") = "";
  			}
  		}
      }
	/* 개발자 작업  끝 */