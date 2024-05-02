/*=========================================================
*Copyright(c) Since 2009 CyberLogitec
*@FileName : ESD_TPB_0115.js
*@FileTitle : TPB Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-06
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2009-08-12 O Wan-Ki 			1.0  최초 생성
* 2009-10-06 Jong-Geon Byeon	1.1 ALPS Migration
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
     * @class ESD_TPB_0115 : ESD_TPB_0115 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0115() {
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
    var curTab = 1;
    var beforetab = 0;
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var isReadOnly = "";
    
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
		
		isReadOnly = document.form.s_readonly.value;
		
		for(i=0;i<sheetObjects.length;i++){
		   //khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		sheetObjects[1].Visible = false; 

		if ( document.form.s_n3pty_no.value.length > 0 ){
			doActionIBSheet(sheetObjects[1],document.form,SEARCH);
			doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
		}
		
		document.form.s_vndr_cust_div_cd.onchange = s_vndr_cust_div_cd_OnChange;
		//document.form.s_trd_party_val.onfocus = s_trd_party_val_OnFocus; 
		document.form.s_trd_party_val.onblur = s_trd_party_val_OnBlur;

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
					style.height = 370;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 10, 10);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(31, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
					
                    //var HeadTitle1 = " |TPB No.|Invoice No.|TPB Seq No.|Seq.|Exp. Type|Exp. Type|Exp. Type|EQ Type|EQ No.|BKG No.|B/L No.|VVD|S/P Inv. No.|I/F (TES/TRS/M&R)|I/F (TES/TRS/M&R)|I/F (TES/TRS/M&R)|Confirmed|Confirmed|Invoiced|Invoiced|ERP I/F|ERP I/F|I/F (TES/TRS/M&R)|I/F (TES/TRS/M&R)|I/F (TES/TRS/M&R)|Confirmed|Confirmed|Confirmed|Overdue days|Remark";
                    //var HeadTitle2 = " |TPB No.|Invoice No.|TPB Seq No.|Seq.|Main|Sub-Cd|Sub|EQ Type|EQ No.|BKG No.|B/L No.|VVD|S/P Inv. No.|Cur.|Amount|USD|Cur.|Amount|Cur.|Amount|Cur.|Amount|Office|User|Date|Office|User|Date|Overdue days|Remark";
                    var HeadTitle1 = " |TPB No.|Invoice No.|TPB Seq No.|Seq.|Exp. Type|Exp. Type|Exp. Type|EQ Kind|EQ No.|BKG No.|B/L No.|VVD|S/P Inv. No.|I/F (TES/TRS/M&R)|I/F (TES/TRS/M&R)|I/F (TES/TRS/M&R)|Confirmed|Confirmed|Invoiced|Invoiced|ERP I/F|ERP I/F|I/F (TES/TRS/M&R)|I/F (TES/TRS/M&R)|I/F (TES/TRS/M&R)|Confirmed|Confirmed|Confirmed|Overdue days|Remark";
					var HeadTitle2 = " |TPB No.|Invoice No.|TPB Seq No.|Seq.|Main|Sub-Cd|Sub|EQ Kind|EQ No.|BKG No.|B/L No.|VVD|S/P Inv. No.|Cur.|Amount|USD|Cur.|Amount|Cur.|Amount|Cur.|Amount|Office|User|Date|Office|User|Date|Overdue days|Remark";
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					//sheetNo = "";
				   

					//          [  ROW ,COL   ,DATATYPE        ,WIDTH ,DATAALIGN ,COLMERGE ,SAVENAME           ,KEYFIELD ,CALCULOGIC ,DATAFORMAT ,POINTCOUNT ,UPDATEEDIT ,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0 ,cnt++ ,dtHiddenStatus  ,100   ,daCenter  ,false    ,"sts"              ,false    ,""         ,dfNone     ,0          ,false      ,false  );
					InitDataProperty(0 ,cnt++ ,dtData          ,100   ,daCenter  ,true     ,"n3pty_no"         ,false    ,""         ,dfNone     ,0          ,false      ,false  );
					InitDataProperty(0 ,cnt++ ,dtHidden        ,100   ,daCenter  ,true     ,"n3pty_inv_no"     ,false    ,""         ,dfNone     ,0          ,false      ,false  );
					InitDataProperty(0 ,cnt++ ,dtHidden        ,30    ,daCenter  ,true     ,"ots_dtl_seq"      ,false    ,""         ,dfNone     ,0          ,false      ,false  );
					InitDataProperty(0 ,cnt++ ,dtData          ,30    ,daCenter  ,true     ,"n3pty_no_dp_seq"  ,false    ,""         ,dfNone     ,0          ,false      ,false  );
					                                                                                                                                                              
					InitDataProperty(0 ,cnt++ ,dtData          ,70    ,daCenter  ,false    ,"n3pty_expn_tp_cd" ,false    ,""         ,dfNone     ,0          ,false      ,false  );
					InitDataProperty(0 ,cnt++ ,dtHidden        ,60    ,daCenter  ,false    ,"n3pty_bil_tp_cd"  ,false    ,""         ,dfNone     ,0          ,false      ,false  );
					InitDataProperty(0 ,cnt++ ,dtData          ,130   ,daLeft    ,false    ,"n3pty_bil_tp_nm"  ,false    ,""         ,dfNone     ,0          ,false      ,false  );
					InitDataProperty(0 ,cnt++ ,dtData          ,60    ,daCenter  ,true     ,"eq_knd_nm"        ,false    ,""         ,dfNone     ,0          ,false      ,false  );
					InitDataProperty(0 ,cnt++ ,dtData          ,100   ,daCenter  ,true     ,"eq_no"            ,false    ,""         ,dfNone     ,0          ,false      ,false  );
					                                                                                                                                                              
					InitDataProperty(0 ,cnt++ ,dtData          ,100   ,daCenter  ,true     ,"bkg_no"           ,false    ,""         ,dfNone     ,0          ,false      ,false  );
					InitDataProperty(0 ,cnt++ ,dtData          ,100   ,daCenter  ,true     ,"bl_no"            ,false    ,""         ,dfNone     ,0          ,false      ,false  );
					InitDataProperty(0 ,cnt++ ,dtData          ,100   ,daCenter  ,true     ,"rev_vvd"          ,false    ,""         ,dfNone     ,0          ,false      ,false  );
					InitDataProperty(0 ,cnt++ ,dtData          ,100   ,daCenter  ,true     ,"n3pty_src_no"     ,false    ,""         ,dfNone     ,0          ,false      ,false  );
					InitDataProperty(0 ,cnt++ ,dtData          ,50    ,daCenter  ,true     ,"if_curr_cd"       ,false    ,""         ,dfNone     ,0          ,false      ,false  );
					                                                                                                                                                              
					InitDataProperty(0 ,cnt++ ,dtData          ,110   ,daRight   ,false    ,"if_amt"           ,false    ,""         ,dfFloat    ,2          ,false      ,false  );
					InitDataProperty(0 ,cnt++ ,dtData          ,110   ,daRight   ,false    ,"if_amt_usd"       ,false    ,""         ,dfFloat    ,2          ,false      ,false  );
					InitDataProperty(0 ,cnt++ ,dtData          ,50    ,daCenter  ,true     ,"cfm_curr_cd"      ,false    ,""         ,dfNone     ,0          ,false      ,false  );
					InitDataProperty(0 ,cnt++ ,dtData          ,110   ,daRight   ,false    ,"cfm_amt"          ,false    ,""         ,dfFloat    ,2          ,false      ,false  );
					InitDataProperty(0 ,cnt++ ,dtData          ,50    ,daCenter  ,true     ,"inv_curr_cd"      ,false    ,""         ,dfNone     ,0          ,false      ,false  );
					                                                                                                                                                              
					InitDataProperty(0 ,cnt++ ,dtData          ,110   ,daRight   ,true     ,"inv_amt"          ,false    ,""         ,dfFloat    ,2          ,false      ,false  );
					InitDataProperty(0 ,cnt++ ,dtData          ,50    ,daCenter  ,true     ,"clt_curr_cd"      ,false    ,""         ,dfNone     ,0          ,false      ,false  );
					InitDataProperty(0 ,cnt++ ,dtData          ,110   ,daRight   ,true     ,"clt_amt"          ,false    ,""         ,dfFloat    ,2          ,false      ,false  );
					                                                                                                                                                              
					InitDataProperty(0 ,cnt++ ,dtData          ,80    ,daCenter  ,true     ,"if_ofc_cd"        ,false    ,""         ,dfNone     ,0          ,false      ,false );
					InitDataProperty(0 ,cnt++ ,dtData          ,80    ,daCenter  ,true     ,"if_usr_id"        ,false    ,""         ,dfNone     ,0          ,false      ,false );
					InitDataProperty(0 ,cnt++ ,dtData          ,100   ,daCenter  ,true     ,"if_dt"            ,false    ,""         ,dfNone     ,0          ,false      ,false );
					                                                                                                                                                              
					InitDataProperty(0 ,cnt++ ,dtData          ,80    ,daCenter  ,true     ,"cfm_ofc_cd"       ,false    ,""         ,dfNone     ,0          ,false      ,false );
					InitDataProperty(0 ,cnt++ ,dtData          ,80    ,daCenter  ,true     ,"cfm_usr_id"       ,false    ,""         ,dfNone     ,0          ,false      ,false );
					InitDataProperty(0 ,cnt++ ,dtData          ,100   ,daCenter  ,true     ,"cfm_dt"           ,false    ,""         ,dfNone     ,0          ,false      ,false );
					InitDataProperty(0 ,cnt++ ,dtData          ,90    ,daCenter  ,true     ,"overdue_days"     ,false    ,""         ,dfNone     ,0          ,false      ,false );
					                                                                                                                                                              
					InitDataProperty(0 ,cnt++ ,dtData          ,0     ,daLeft    ,true     ,"cfm_rmk"          ,false    ,""         ,dfNone     ,0          ,false      ,false );

					if ( isReadOnly!='Y' ){
						allReadonly(document.form);
					}
				}
				break;

			case 2: //sheet2 init
				with (sheetObj) {
					var cnt = 0;
					// 높이 설정
					style.height = 110; //getSheetHeight(1);

					//전체 너비 설정
					SheetWidth = 110; //mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(13, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)

					var HeadTitle = "STS|n3pty_no|n3pty_inv_no|ofc_cd|ots_sts_nm|overdue|vndr_cust_div_cd|trd_party_val|trd_party_nm|csr_no|roc_in|roc_out|file_no";
					/// vndr_seq|accm_seq|accm_cost_seq|lgs_cost_cd|cre_usr_id|cre_dt|upd_usr_id|upd_dt

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					//sheetNo = "";

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,        	  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					//InitDataProperty(0, cnt++, dtDelCheck,   30,    daCenter,  true,    "");
					InitDataProperty(0, cnt++ , dtStatus,   100,   daCenter,  false,    "ibflag"       		, false,    ""    );
					InitDataProperty(0, cnt++ , dtData,     100,   daCenter,  false,    "n3pty_no"     		, false,    "",         dfNone,     0,          false,      false);
  					InitDataProperty(0, cnt++ , dtData,     100,   daCenter,  false,    "n3pty_inv_no"     	, false,    "",         dfNone,     0,          false,      false);
  					InitDataProperty(0, cnt++ , dtData,     100,   daCenter,  false,    "ofc_cd"     		, false,    "",         dfNone,     0,          false,      false);
  					InitDataProperty(0, cnt++ , dtData,     100,   daCenter,  false,    "ots_sts_nm"     	, false,    "",         dfNone,     0,          false,      false);
  					InitDataProperty(0, cnt++ , dtData,     100,   daCenter,  false,    "overdue"     		, false,    "",         dfNone,     0,          false,      false);
  					InitDataProperty(0, cnt++ , dtData,     100,   daCenter,  false,    "vndr_cust_div_cd"	, false,    "",         dfNone,     0,          false,      false);
  					InitDataProperty(0, cnt++ , dtData,     100,   daCenter,  false,    "trd_party_val"     , false,    "",         dfNone,     0,          false,      false);
  					InitDataProperty(0, cnt++ , dtData,     100,   daCenter,  false,    "trd_party_nm"     	, false,    "",         dfNone,     0,          false,      false);
  					InitDataProperty(0, cnt++ , dtData,     100,   daCenter,  false,    "csr_no"     		, false,    "",         dfNone,     0,          false,      false);
  					InitDataProperty(0, cnt++ , dtData,     100,   daCenter,  false,    "roc_in"     		, false,    "",         dfNone,     0,          false,      false);
  					InitDataProperty(0, cnt++ , dtData,     100,   daCenter,  false,    "roc_out"     		, false,    "",         dfNone,     0,          false,      false);
  					InitDataProperty(0, cnt++ , dtData,     100,   daCenter,  false,    "file_no"     		, false,    "",         dfNone,     0,          false,      false);
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
			
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "bttn_add":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
				case "btn_cancel_process": /// Cancel By Super User
					var ots = formObject.s_ots_sts_cd.value;
					if(ots == 'L' || ots == 'A' || ots == 'K' || ots == 'E' || ots == 'D'){ //ERP I/F // Added K/E/D case By Kim Jin-seung In 2007-07-30
						ComShowCodeMessage("TPB90010","use Cancel Close Function ");  // Changed By Kim Jin-seung In 2007-07-19
						return;
					}
					doActionIBSheet(sheetObjects[1],formObject,COMMAND01);
					break;
				case "btn_close_process": /// Close Process By General User
     	            formObject.s_process_close_message.value = "";
					var ots = formObject.s_ots_sts_cd.value;
					if(ots == 'L' || ots == 'A' || ots == 'K' || ots == 'E' || ots == 'D'){ //ERP I/F // Added K/E/D case By Kim Jin-seung In 2007-07-30
						ComShowCodeMessage("TPB90010","use Process Close Function ");  // Changed By Kim Jin-seung In 2007-07-19
						return;
					}
					if(formObject.s_n3pty_bil_tp_cd.value=='JO'){ // JO Case Blocking ... Added By Kim Jin-seung In 2007-10-29
						ComShowCodeMessage("TPB90047");  
						return;
					}
					if(ots == 'I' || ots == 'R'){ // Invoice / Adjustment Request Case ... Added By Kim Jin-seung In 2007-12-03
					    if ( ots == 'I' ){
       						ComShowCodeMessage("TPB90049");
					    } else if ( ots == 'R' ){
					        ComShowCodeMessage("TPB90050");
					    }
						return;
					}
					doActionIBSheet(sheetObjects[1],formObject,COMMAND02);
					break;
				case "btn_save":
					var ots = formObject.s_ots_sts_cd.value;

                    if(ots != 'O' && ots != 'J' && ots != 'M'){ // Changed By Kim Jin-seung In 2007-08-20
						ComShowCodeMessage('TPB90010','save ','','');
						return;
					}
					doActionIBSheet(sheetObjects[1],formObject,IBSAVE);
					break;
				case "bttn_remove":
					break;
				case "bttn_preview":
					sheetObject.ExcelPrint = "PreView";
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "bttn_excel":
					sheetObject.ExcelPrint = "";
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "bttn_print":
					sheetObject.ExcelPrint = "PrintOnly";
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "btn_retrieve":
					doActionIBSheet(document.all.sheet2,formObject,SEARCH);
					doActionIBSheet(sheetObject,formObject,SEARCH01);
					break;
				case "btn_new":
					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
					formObject.reset();
					formObject.s_n3pty_no.value = "";
					break;
				case "btn_3rdParty":
					get3rdParty( document.all.s_vndr_cust_div_cd.value );
					break;
				case "btn_recoveryactivity":
					var read = document.form.s_readonly.value;//yoon 메뉴에 따라서...
					openRecoveryActPopup(formObject.s_n3pty_no.value,formObject.s_n3pty_inv_no.value,'',read);
					break;
				case "btn_settlement":
					var ots = formObject.s_ots_sts_cd.value;
					if(ots != 'O' && ots != 'J' && ots != 'L'&& ots != 'M'){
						ComShowCodeMessage('TPB90007','','','');
						return;
					}
					return;
					location.href = "ESD_TPB_015.do?n3pty_no="+formObject.s_detail_n3pty_no.value+"&f_cmd="+SEARCH;
					break;
				case "btn_invoicecreation":
					if(formObject.s_h_vndr_cust_div_cd.value != "" &&
					   formObject.s_h_vndr_cust_div_cd.value != "S"){ //Staff은 Invoice Creation 불가
						
						var act = null;
						if(formObject.s_ots_sts_cd.value == "O" || formObject.s_ots_sts_cd.value == "M"){
							act = "ESD_TPB_0110.do";
						}else{
							ComShowCodeMessage('TPB90011','','','');
							return;
						}
						formObject.f_cmd.value = SEARCH01;
						formObject.method = "post";
						formObject.action = act;
						formObject.submit();
					}
					break;
				case "btn_close":
  					window.close();
  					break;	
				case "btn_downexcel":
  					sheetObject.ExcelPrint = "";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
			} // end switch
	}
	
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case SEARCH:	  //조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}

//				if ( isReadOnly!='Y' ){
//					formObj.s_n3pty_no.value = formObj.s_detail_n3pty_no.value; //yoon
//				}

  				formObj.f_cmd.value = SEARCH;
  				sheetObj.DoSearch4Post("ESD_TPB_0115GS.do", tpbFrmQryStr(formObj));

                document.form.s_n3pty_no.value 			= GetNull(sheetObj.CellValue(1,"n3pty_no"));
                document.form.s_n3pty_inv_no.value 		= GetNull(sheetObj.CellValue(1,"n3pty_inv_no"));
                document.form.s_ofc_cd.value 			= GetNull(sheetObj.CellValue(1,"ofc_cd"));
                document.form.s_ots_sts_nm.value 		= GetNull(sheetObj.CellValue(1,"ots_sts_nm"));
                document.form.s_overdue.value 			= GetNull(sheetObj.CellValue(1,"overdue"));
                document.form.s_vndr_cust_div_cd.value 	= GetNull(sheetObj.CellValue(1,"vndr_cust_div_cd"));
                document.form.s_trd_party_val.value 	= GetNull(sheetObj.CellValue(1,"trd_party_val"));
                document.form.s_trd_party_nm.value	 	= GetNull(sheetObj.CellValue(1,"trd_party_nm"));
                document.form.s_csr_no.value 			= GetNull(sheetObj.CellValue(1,"csr_no"));
                document.form.s_roc_out.value 			= GetNull(sheetObj.CellValue(1,"roc_out"));
				
				break;
			case SEARCH01:	  //조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
//                if ( formObj.s_detail_n3pty_no.value.length == 14){
//  				    formObj.s_n3pty_no.value = formObj.s_detail_n3pty_no.value;
//                }

				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch4Post("ESD_TPB_0115GS.do", tpbFrmQryStr(formObj));

				break;
			case IBSAVE:		//저장
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				if(document.form.s_vndr_cust_div_cd.value == "" ||
				   document.form.s_trd_party_val.value == ""){
					if(document.form.s_vndr_cust_div_cd.value == ""){
						ComShowCodeMessage("COM12113","3rd Party type","","");
						document.form.s_vndr_cust_div_cd.focus();
						return;
					}
					if(document.form.s_trd_party_val.value == ""){
						ComShowCodeMessage("COM12114","3rd Party code","","");
						document.form.s_trd_party_val.focus();
						return;
					}
				}
				sheetObj.DataInsert();
				formObj.f_cmd.value = ADD;
				sheetObj.DoSave("ESD_TPB_0115GS.do", tpbFrmQryStr(formObj));
				sheetObj.RemoveAll();
				break;
			case COMMAND01:		// Cancel By Super User
				if ( sheetObj.RowCount > 0 ) { sheetObj.RemoveAll();}
				var sRow = sheetObj.DataInsert();

				sheetObj.CellValue2(sRow, "cancel_n3pty_no") = formObj.s_detail_n3pty_no.value;

				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value = COMMAND01;
				sheetObj.DoSave("ESD_TPB_0115GS.do", tpbFrmQryStr(formObj));
				sheetObj.RemoveAll();
				break;
			case COMMAND02:		// Close Process By General User
				if ( sheetObj.RowCount > 0 ) { sheetObj.RemoveAll();}
				var sRow = sheetObj.DataInsert();
				sheetObj.CellValue2(sRow, "cancel_n3pty_no") = formObj.s_detail_n3pty_no.value;
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				var n3pty_src_sub_sys_cd = formObj.s_n3pty_src_sub_sys_cd.value;
				var last_vndr_cust_div_cd = formObj.s_last_vndr_cust_div_cd.value;
				processCloseCase = 0;
				if (n3pty_src_sub_sys_cd=="TES" || n3pty_src_sub_sys_cd=="TRS"){
				   if ( last_vndr_cust_div_cd == "C" ) {
				       processCloseCase = 1;
				   } else if ( last_vndr_cust_div_cd == "V" ) {
				       processCloseCase = 2;
				   }
				} else if (n3pty_src_sub_sys_cd=="MNR") {
				   if ( last_vndr_cust_div_cd == "C" || last_vndr_cust_div_cd == "V" ) {
				       processCloseCase = 3;
				   } 
				} 
                if ( processCloseCase != 0 ){
				     var processCloseOk = openProcessClosePopup(formObj, processCloseCase);
                } else {
                    ComShowCodeMessage("TPB90048");
                    return;
                }
                if ( processCloseOk==true ){
    				formObj.f_cmd.value = COMMAND02;
    				sheetObj.DoSave("ESD_TPB_0115GS.do", tpbFrmQryStr(formObj));
 				    sheetObj.RemoveAll();
                }
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
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		return true;
	}
	
	/**
	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	 */
	function sheet1_OnSearchEnd(sheetObj,errMsg){
		//sheet size 자동조절. * 2008-11-24 O Wan-Ki 1.1 Confirm Remark 보완
		sheetObj.ColWidth("cfm_rmk") = 0;
		
		if(errMsg!=null){
			ComShowMessage(errMsg);
		}
	}

	function sheet2_OnSaveEnd(sheetObj, ErrMsg){ 
	}

	function allReadonly(f){
		var el;
		for ( var n = 0, sz = f.elements.length; n < sz; n++){
			el = f.elements(n);
			if ( ! el.name || el.name=="s_trd_party_val" || el.name=="s_trd_party_nm") continue;

			if(el != undefined && el.type != undefined && el.type == 'text'){
				el.readOnly=true;
                 el.style.backgroundColor = "#EEEEEE";
                 el.style.color = "#555555";
			}
		}
	}

	function tpb_getEmailInfo(){
		var classId = "COM_ENS_092";
		var param = '?classId='+classId;
		comPopup('/hanjin/COM_ENS_0092.do' + param, 850, 550, 'getStaff_formail', 'none', true);
	}

	function getStaff_formail(rowArray){
		var gubun = ':';
		var formObj = document.form;
		var user_id = '';
		var user_email = '';

		for(var i=0; i<rowArray.length; i++){
			if(i == rowArray.length-1) gubun = '';

			colArray = rowArray[i];
			user_id += colArray[0] + gubun;
			user_email += colArray[1] + gubun;
		}
		formObj.toEmail.value = user_email+";"+user_id;
	}

	/**
	 * Process Close시 Message자료 등록을 위한 팝업 
	 */
    function openProcessClosePopup(formObject, processCloseCase){
    	return;
    	var theURL = "ESD_TPB_0917.do?processCloseCase="+processCloseCase;
    	var features = "scroll:no;status:no;help:no;dialogWidth:700px;dialogHeight:385px";
    	var rtnValue = window.showModalDialog(theURL, window, features);
        var process_colose_message = "";
        
    	if(rtnValue != undefined && rtnValue != null && rtnValue.length > 0){
    	    for(var i=0; i<rtnValue.length; i++ ){
    	       if ( i > 0){
    	           process_colose_message += "|$@$|";
    	       }
    	       process_colose_message += rtnValue[i];
    	    }
     	    formObject.s_process_close_message.value = process_colose_message;
     	    return true;
    	} else {
    	    return false;
    	}
     }
     
     function GetNull(val){
         if ( val == undefined || val == null ){
            val = "";             
         }
         return val;
     }
	/* 개발자 작업  끝 */