/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : cps_gem_0016.js
*@FileTitle : [CPS_GEM-0016] Slip Inquiry by Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009.06.04 박창준
* 1.0 Creation
* ----------------------------------------------------------
* History
* 2011.01.31 이준범[CHM-201108626-01]
* 요청사항 : SELPLL- >SELLIC  관련 문제 연관 해소
* 보완내역 : Office 코드 입력 조회시, Sheet1 초기화   
 * 2011-02-17 이준범 [CHM-201108627-01]
 * 제목: Request 권한 없는 office user의 접근 시 all data open 오류 해소 요청
 * 보완: Request 권한 없는 Office 에 대한 화면 Block 
 * 2011-02-23 이준범 [CHM-201108800-01]
 * 제목: Split 01-ERP에서 ALPS>GEM으로 AP slip data 송신 시 추가정보 요청
 * 보완: upplier code, Supplier Name, Credit card user name 항목 추가
 * 2011-03-11 이준범 [CHM-201108800-01]
 * 제목: ERP I/F DATA 추가 요청
 * 보완: 1. 법인카드 가맹점 정보 추가 I/F
 *      2. GEM 수신 메뉴
 *        - INQUIRY > SLIP INQUIRY
 *        - 화면상 보이지 않고 DOWNLOAD 시 VANDER NAME 옆에 다운로드
 * 2011.03.28 [CHM-201109333-01]
 * 개발자 : 이준범
 * Title: 사무국 권한 명확화 요청
 * DESC : 사무국 SELPLP 소속 사용자 중, 슈퍼유저 와 일반유저를 구분하여, 데이터 조회 할 수 있도록  SQL 수정
 * 2012.05.09 이준범 {CHM-201217605-01] 
 * 제목 : GEM - Excel Upload 기능에서 I/F Error data 삭제 기능 개발
 * 내용 : 1) 지역본부 Upload 시 산하 조직 모두 가능토록 구현
 *       2) 논리적으로 삭제 처리 되던 전표(승인 전)에 대하여  물리적으로 삭제 처리 
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
     * @class cps_gem_0016 : cps_gem_0016 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function cps_gem_0016() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	
    	this.sheet1_OnClick = sheet1_OnClick;
    }
    
   	/* 개발자 작업	*/


 // 공통전역변수
 var sheetObjects = new Array();
 var sheetCnt = 0;
 var frm = null;
 var sheet1 = null;
 var sheet2 = null;
 
//IBMultiCombo
 var comboObjects = new Array();
 var combo1 = null;
 var combo2 = null;
 var combo3 = null;
 var comboCnt = 0;

 
 /**
  * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
  * 상단에 정의
  */
 function setSheetObject(sheet_obj){
 	sheetObjects[sheetCnt++] = sheet_obj;
 }

 /**
 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
 * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
 **/
 function setComboObject(combo_obj){
   comboObjects[comboCnt++] = combo_obj;
 }

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject1 = sheetObjects[0];
          /*******************************************************/
          var formObject = document.form;

  
 		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
		    case "btn_popup":
		    	var param = "popup=Y";
		   			var url = "CPS_GEM_0112.do?"+param;
		   			var winName = "CPS_GEM_0112";
		   			
		   			var win = ComOpenWindowCenter(url,winName,1000,500, false);
		   			win.focus();
		   			
					break;
			case "btn_Retrieve":
				
				if(frm.from_rslt_yrmon.value == "" || frm.to_rslt_yrmon.value == ""){
					ComShowCodeMessage("GEM01068");
	 				return false;
	 			} 
				
				if(chkMonth()){
					sheet1.WaitImageVisible = true;
					sheet1.RemoveAll();
					frm.page_no.value = "1";
					doActionIBSheet(SEARCHLIST);
					sheet1.WaitImageVisible = false;
				}
				
				break;
			case "btn_New":
			// 초기화하시겠습니까?
				if(!ComCodeMsgByInitialize()) return;
				ComResetAll();
				ComEnableObject(frm.ofc_lvl1, true);
				ComEnableObject(frm.ofc_lvl2, true);
				ComEnableObject(frm.ofc_lvl3, true);		
				frm.sls_ofc_div_cd[0].disabled=false;
				frm.sls_ofc_div_cd[1].disabled=false;
				loadPage();
				sheet1_OnLoadFinish();
				break;
			case "btn_DownExcel":
				if (sheet1.RowCount <= 0 ) {
					// 조회된 건수가 없습니다.
					ComCodeMsgByNoRelatedData();
					return;
				} else {
					//var skiprow = "ABBR NM|SUB ABBR NM"; 						
					var skiprow = "";
					if(chkMonth() && validateForm(SEARCHLIST)){						
						ComOpenWait(true);	
		      			frm.f_cmd.value = SEARCHLIST;
		      			frm.sch_expense_from.value = combo1.Code;
		 				frm.sch_expense_to.value = combo2.Code;
		 				frm.sch_expense_group.value = combo3.Code;
		 				frm.page_no.value = "";
		 				sheet2.DoSearch4Fx("CPS_GEM_0016GS.do", FormQueryString(frm));
 						sheet2.SpeedDown2Excel(1,false,false,"","",false,false,"Slip Inquiry by Performance",true,skiprow); 						
 						ComOpenWait(false);	
					}
				}
				break;
			case "from_rslt_yrmon_cal":
				var cal = new ComCalendar();
				cal.setDisplayType('month');
				cal.select(frm.from_rslt_yrmon, 'yyyy-MM');
                break;
			case "to_rslt_yrmon_cal":
				var cal = new ComCalendar();
				cal.setDisplayType('month');
				cal.select(frm.to_rslt_yrmon, 'yyyy-MM');
                break;
			case "chk_commit":
				
				if ( frm.chk_commit.checked ) {
					frm.usr_tic_cd.value = "";
					frm.auth_flg.value = "YNYY"; 
				} else {
					frm.usr_tic_cd.value = frm.usr_ofc_cd.value;
					frm.auth_flg.value = "YNYN";
				}
				
				break;	                
         } // end switch
     
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
    	 frm = document.form;
    	 sheet1 = sheetObjects[0];
    	 sheet2 = sheetObjects[1];
    	 sheetCnt = sheetObjects.length ;
    	 
    		// combo
    		combo1 = comboObjects[1];
    		combo2 = comboObjects[2];
    		combo3 = comboObjects[0];
    		comboCnt = comboObjects.length;
    	 
         for(i=0;i<sheetObjects.length;i++){
 			ComConfigSheet (sheetObjects[i] );
 			initSheet(sheetObjects[i],i+1);
 			ComEndConfigSheet(sheetObjects[i]);
         }	
         
         // IBMultiCombo초기화
         for(var k=0; k<comboObjects.length; k++){
             initCombo(comboObjects[k]);
         }
         
         // html컨트롤 이벤트초기화
         initControl();
         sheet1.WaitImageVisible = false;
         
     }

     /**
     * 콤보 초기설정값
     * @param {IBMultiCombo} comboObj  comboObj
     */
     function initCombo(comboObj) {
     	comboObj.MultiSelect = false;
     	comboObj.UseCode = true;
     	comboObj.LineColor = "#ffffff";
     	comboObj.SetColAlign("left|left");
     	comboObj.MultiSeparator = ",";
     	comboObj.DropHeight = 190;
     }

   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
         switch(sheetObj.id) {

             case "sheet1":
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 420;

                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet =  msNone;
                     //MergeSheet =  msNone;
                     //MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 15, 100);

 					//var HeadTitle1 = "|SLIP NO.|SEQ|Office|EXPN CD|ABBR NM|TIC|CUR|EFF DT|SLIP AMT|Expense|Ratio %|SLIP Description";
 					var HeadTitle1 = "|SLIP No.|Seq.|Office|SUB OFC|COM|EXPN CD|SUB EXPN|EXPN NM|SUB EXPN NM|TIC|CUR|EFF DT|SLIP AMT|Expense|Performance|Ratio %|SLIP Description";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 5, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
 					 //InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT,		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");					
 					InitDataProperty(0, cnt++ , dtData,			140,	daCenter,	true,       "slp_tj_no",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"slp_seq_no",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"ofc_cd",				false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"sub_ofc_cd",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"ofc_co_div_cd",		false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,		"gen_expn_cd",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,		"sub_gen_expn_cd",		false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,		    100,	daLeft,  	true,		"abbr_nm",				false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,	    	100,	daLeft,	    true,		"sub_abbr_nm",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"tic_cd",				false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"slp_curr_cd",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"gl_eff_dt",			false,		"",			dfDateYmd,		0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,		"slp_amt",				false,		"",			dfNullFloat,	3, false, false);
 					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,		"gen_expn_fnl_locl_amt",false,		"",			dfNullInteger,	0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,		"slp_perf_amt",			false,		"",			dfNullFloat,	3, false, false); 					
 					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,		"ratio",				false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			400,	daLeft,		true,		"slp_desc",				false,		"",			dfNone,			0, false, false);
 					/*
 					cnt = 0;
 					InitDataProperty(1, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag1");				
 					InitDataProperty(1, cnt++ , dtData,			140,	daCenter,	true,       "slp_tj_no1",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			40,		daCenter,	true,		"slp_seq_no1",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			60,		daCenter,	true,		"sub_ofc_cd",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			70,		daCenter,	true,		"sub_gen_expn_cd",		false,		"",			dfNone,			0, false, false);
 					InitDataProperty(1, cnt++ , dtHidden,		60,		daCenter,	true,		"sub_abbr_nm",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			50,		daCenter,	true,		"tic_cd1",				false,		"",			dfNone,			0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			30,		daCenter,	true,		"slp_curr_cd1",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			70,		daCenter,	true,		"gl_eff_dt1",			false,		"",			dfDateYmd,		0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			140,	daRight,	true,		"slp_amt1",				false,		"",			dfNullInteger,	0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			140,	daRight,	true,		"slp_perf_amt",			false,		"",			dfNullInteger,	0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			60,		daRight,	true,		"ratio1",				false,		"",			dfNone,			0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			400,	daLeft,		true,		"slp_desc1",			false,		"",			dfNone,			0, false, false);					
					
 					cnt = 0;
 					InitDataProperty(2, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag1");				
 					InitDataProperty(2, cnt++ , dtData,			140,	daCenter,	true,       "slp_tj_no1",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			40,		daCenter,	true,		"slp_seq_no1",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			60,		daCenter,	true,		"sub_ofc_cd",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			70,		daCenter,	true,		"sub_gen_expn_cd",		false,		"",			dfNone,			0, false, false);
 					InitDataProperty(2, cnt++ , dtHidden,		60,		daCenter,	true,		"sub_abbr_nm",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			50,		daCenter,	true,		"tic_cd1",				false,		"",			dfNone,			0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			30,		daCenter,	true,		"slp_curr_cd1",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			70,		daCenter,	true,		"gl_eff_dt1",			false,		"",			dfDateYmd,		0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			140,	daRight,	true,		"slp_amt1",				false,		"",			dfNullInteger,	0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			140,	daRight,	true,		"slp_perf_amt",			false,		"",			dfNullInteger,	0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			60,		daRight,	true,		"ratio1",				false,		"",			dfNone,			0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			400,	daLeft,		true,		"slp_desc1",			false,		"",			dfNone,			0, false, false);					
                    */
// 					CountPosition = 0;
 					//SetSortDialog(false);
 					//DataRowMerge(0) = true;
    				//DataRowMerge(1) = true;
 					CountFormat = "[SELECTDATAROW / TOTALROWS]";
 				}
 				break;
             case "sheet2":
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 470;

                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet =  msNone;
                     //MergeSheet =  msNone;
                     //MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;
                     WaitImageVisible = false;
                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 15, 100);

 					//var HeadTitle1 = "|SLIP NO.|SEQ|Office|EXPN CD|ABBR NM|TIC|CUR|EFF DT|SLIP AMT|Expense|Ratio %|SLIP Description";
 					var HeadTitle1 = "|SLIP NO.|SEQ|Office|SUB OFC|COM|EXPN CD|SUB EXPN|ACCT CD|EXPN NM|SUB EXPN NM|TIC|CUR|EFF DT|SLIP AMT|SLIP VENDOR|Expense|Performance|Ratio %|Vendor Code|Vendor Name|Card Shop Name|Credit Card User Name|SLIP Description";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 5, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, false, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
 					 //InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT,		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");					
 					InitDataProperty(0, cnt++ , dtData,			140,	daCenter,	true,       "slp_tj_no",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"slp_seq_no",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"ofc_cd",				false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"sub_ofc_cd",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"ofc_co_div_cd",		false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"gen_expn_cd",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"sub_gen_expn_cd",		false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"acct_cd",				false,		"",			dfNone,			0, false, false);
 					
 					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		"abbr_nm",				false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		"sub_abbr_nm",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"tic_cd",				false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"slp_curr_cd",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"gl_eff_dt",			false,		"",			dfDateYmd,		0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,		"slp_amt",				false,		"",			dfNullFloat,	3, false, false);
 					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"slp_vndr_cd",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,		"gen_expn_fnl_locl_amt",false,		"",			dfNullInteger,	0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,		"slp_perf_amt",			false,		"",			dfNullFloat,	3, false, false); 					
 					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,		"ratio",				false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			80,	    daCenter, 	true,		"slp_splr_cd",	    	false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			80,	    daLeft, 	true,		"slp_splr_nm",	    	false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		true,		"crd_shop_nm",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			80,	    daLeft, 	true,		"cr_crd_usr_nm",		false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			400,	daLeft,		true,		"slp_desc",				false,		"",			dfNone,			0, false, false);
 					
 					/*
 					cnt = 0;
 					InitDataProperty(1, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag1");				
 					InitDataProperty(1, cnt++ , dtData,			140,	daCenter,	true,       "slp_tj_no1",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			40,		daCenter,	true,		"slp_seq_no1",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			60,		daCenter,	true,		"sub_ofc_cd",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			70,		daCenter,	true,		"sub_gen_expn_cd",		false,		"",			dfNone,			0, false, false);
 					InitDataProperty(1, cnt++ , dtHidden,		60,		daCenter,	true,		"sub_abbr_nm",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			50,		daCenter,	true,		"tic_cd1",				false,		"",			dfNone,			0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			30,		daCenter,	true,		"slp_curr_cd1",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			70,		daCenter,	true,		"gl_eff_dt1",			false,		"",			dfDateYmd,		0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			140,	daRight,	true,		"slp_amt1",				false,		"",			dfNullInteger,	0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			140,	daRight,	true,		"slp_perf_amt",			false,		"",			dfNullInteger,	0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			60,		daRight,	true,		"ratio1",				false,		"",			dfNone,			0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			400,	daLeft,		true,		"slp_desc1",			false,		"",			dfNone,			0, false, false);					
					
 					cnt = 0;
 					InitDataProperty(2, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag1");				
 					InitDataProperty(2, cnt++ , dtData,			140,	daCenter,	true,       "slp_tj_no1",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			40,		daCenter,	true,		"slp_seq_no1",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			60,		daCenter,	true,		"sub_ofc_cd",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			70,		daCenter,	true,		"sub_gen_expn_cd",		false,		"",			dfNone,			0, false, false);
 					InitDataProperty(2, cnt++ , dtHidden,		60,		daCenter,	true,		"sub_abbr_nm",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			50,		daCenter,	true,		"tic_cd1",				false,		"",			dfNone,			0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			30,		daCenter,	true,		"slp_curr_cd1",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			70,		daCenter,	true,		"gl_eff_dt1",			false,		"",			dfDateYmd,		0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			140,	daRight,	true,		"slp_amt1",				false,		"",			dfNullInteger,	0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			140,	daRight,	true,		"slp_perf_amt",			false,		"",			dfNullInteger,	0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			60,		daRight,	true,		"ratio1",				false,		"",			dfNone,			0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			400,	daLeft,		true,		"slp_desc1",			false,		"",			dfNone,			0, false, false);					
                    */
// 					CountPosition = 0;
 					//SetSortDialog(false);
 					//DataRowMerge(0) = true;
    				//DataRowMerge(1) = true;
 					
 				}
 				break; 				
         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sAction) {
         
         switch(sAction) {

 			case IBSEARCH:      //Open
 				
 				frm.f_cmd.value = SEARCH;
 				
 	  			var sXml = sheet1.GetSearchXml("CPS_GEM_0010GS.do", FormQueryString(frm));

 	  			var arrXml = sXml.split("|$$|");
 	  			
 	  			
 	  			var langDiv = getLanguage();
 	  			// ---------------------------------
 	  			// Tic List
 	  			// ---------------------------------
 	  			var comboTicData = ComGetEtcData(arrXml[0], "ticList").split("|");
 		   		
 	  			if(typeof comboTicData != "undefined" && comboTicData != "") {	
 					var ticCd = frm.sch_tic_cd;
 					ticCd.length = 0;
 					ComAddComboItem(ticCd,"","");
 					
 					for(var i=0 ; i < comboTicData.length ; i++ ) {
 						ComAddComboItem(ticCd,comboTicData[i],comboTicData[i]);
 					}
 		   		}
 		   		
 	  			combo1.RemoveAll(); 
 	  			combo2.RemoveAll();
 	  			// ---------------------------------
 	  			// Expense Form ~ To 
 	  			// ---------------------------------
 		   		
 		   		combo1.InsertItem(0, "", "");
				combo2.InsertItem(0, "", "");
 		   		
 	  			var arrTempData = ComXml2ListMap(arrXml[0]);		
 	  			for(var i=0 ; i < arrTempData.length ; i++ ) {
 	  				var tempData = arrTempData[i];
 	  				
 	  				if(langDiv == "K") {
 						combo1.InsertItem(i+1, tempData["gen_expn_cd"]+"|"+tempData["krn_abbr_nm"], tempData["gen_expn_cd"]);
 						combo2.InsertItem(i+1, tempData["gen_expn_cd"]+"|"+tempData["krn_abbr_nm"], tempData["gen_expn_cd"]);
 					} else if(langDiv == "E") {
 						combo1.InsertItem(i+1, tempData["gen_expn_cd"]+"|"+tempData["eng_abbr_nm"], tempData["gen_expn_cd"]);
 						combo2.InsertItem(i+1, tempData["gen_expn_cd"]+"|"+tempData["eng_abbr_nm"], tempData["gen_expn_cd"]);
 					}
 	  			}
 	  			combo1.Code = "";
 	  			combo2.Code = "";
 	  			
 	  			// ---------------------------------
 	  			// Group Expense 
 	  			// ---------------------------------
 	  			
 	  			combo3.RemoveAll();
 	  			
 	  			combo3.InsertItem(0, "", "");
 	  			
 	  			var arrTempData = ComXml2ListMap(arrXml[1]);
 	  			for(var i=0 ; i < arrTempData.length ; i++ ) {
 	  				var tempData = arrTempData[i];
 	  				
 	  				if(langDiv == "K") {
 						combo3.InsertItem(i+1, tempData["gen_expn_cd"]+"|"+tempData["krn_abbr_nm"], tempData["gen_expn_cd"]);
 					} else if(langDiv == "E") {
 						combo3.InsertItem(i+1, tempData["gen_expn_cd"]+"|"+tempData["eng_abbr_nm"], tempData["gen_expn_cd"]);
 					}
 	  			}
 	  			combo3.Code = "";

 				break;
 				
 			case SEARCHLIST: // 조회
 				
 				if(validateForm(sAction)){
 	      			frm.f_cmd.value = SEARCHLIST; 
 
 	      			frm.sch_expense_from.value = combo1.Code;
 	 				frm.sch_expense_to.value = combo2.Code;
 	 				frm.sch_expense_group.value = combo3.Code;
 	 				frm.ofc_co_div_cd.value = frm.sch_com_div.value;
 	      			/*
 	      			var sXml = sheet1.GetSearchXml("CPS_GEM_0016GS.do", FormQueryString(frm));
 	      			
 	      			var arrXml = sXml.split("|$$|");
 		  			if (arrXml.length > 0) {
 		  				sheet1.LoadSearchXml(arrXml[0]);
 		  				sheet1.ColBackColor(5) = sheet1.RgbColor(239,235,239);
 		  			}
 		  			*/

 	 				//sheet1.DoSearch4Fx("CPS_GEM_0016GS.do", FormQueryString(frm),"page_no=" + frm.page_no.value ,true); 	 				
 	 				sheet1.DoSearch4Post("CPS_GEM_0016GS.do", FormQueryString(frm), "", true);
 	 				
 	 				if (sheet1.RowCount == 0) {
 	 					//msgs["GEM00013"] = "There is no related data!";
 	 					ComShowCodeMessage("GEM00013");
 	 					return;
 	 				}
 	 				
 				}			  			
 	     	   	break;

 			case SEARCHLIST02:      //Open
 				
 				frm.f_cmd.value = SEARCH;
 				var sXml = sheet1.GetSearchXml("CPS_GEM_0016_01GS.do", FormQueryString(frm));
 				
 				var arrXml = sXml.split("|$$|");
 				var authFlg  = "";
 				
 				// 로그인 오피스 정보 
 				if (arrXml.length > 0) {			
 					var list = ComXml2ListMap(arrXml[0]);
 					var officeLevelVo  = list[0];
 					
 					authFlg  = officeLevelVo["auth_flg"];
 					
 					//권한 설정
 					frm.auth_flg.value = authFlg;
 				}		
 				
				if ( authFlg == null || authFlg == "" || authFlg == "NNNN") {
					goNoAuthority();
					return;
			    }

 				// 로그인 사용자 오피스 정보
 				if (arrXml.length > 1) {
 					
 					var list = ComXml2ListMap(arrXml[1]);
 					
 					if(list.length > 0){
	 					var officeHierarchyVO  = list[0];
	 					var level1   = officeHierarchyVO["level1"];
	 					var level2   = officeHierarchyVO["level2"];
	 					var level3   = officeHierarchyVO["level3"];
	 					var level4   = officeHierarchyVO["level4"];
	 					var rgnOfcFlg  = officeHierarchyVO["rgn_ofc_flg"];
	 					if ("N" == rgnOfcFlg) {
	 						frm.sls_ofc_div_cd[0].checked = true;
	 					} else {
	 						frm.sls_ofc_div_cd[1].checked = true;
	 					}
	 					//집행단위.지역그룹
	 					if ( authFlg == "YNNN" || authFlg == "YYNN" ) {
	 						ComEnableObject(frm.ofc_lvl1, false);
	 						ComEnableObject(frm.ofc_lvl2, false);
	 						ComEnableObject(frm.ofc_lvl3, false);
	 						if ( authFlg == "YYNN" ) {
	 							ComEnableObject(frm.ofc_lvl3, true);
	 						}
	 						frm.sls_ofc_div_cd[0].disabled=true;
	 						frm.sls_ofc_div_cd[1].disabled=true;
	 						//LV1
	 						ComSetObjValue(frm.ofc_lvl1,level2);					
	 						//LV2
	 						selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');			
	 						ComSetObjValue(frm.ofc_lvl2,level3);					
	 						//LV3
	 						selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet1','sls_ofc_div_cd','2','document.form.ofc_lvl');			
	 						ComSetObjValue(frm.ofc_lvl3,level4);					
	 										
	 					//사무국 , BU ,TIC
	 					} else if ( authFlg == "YNYN" || authFlg == "YNYY" || authFlg == "YYYN") {
	 						ComEnableObject(frm.ofc_lvl1, true);
	 						ComEnableObject(frm.ofc_lvl2, true);
	 						ComEnableObject(frm.ofc_lvl3, true);				
	 						frm.sls_ofc_div_cd[0].checked = false;
	 						frm.sls_ofc_div_cd[1].checked = false;
	 					} else {
	 						ComEnableObject(frm.ofc_lvl1, false);
	 						ComEnableObject(frm.ofc_lvl2, false);
	 						ComEnableObject(frm.ofc_lvl3, false);		
	 						frm.sls_ofc_div_cd[0].disabled=true;
	 						frm.sls_ofc_div_cd[1].disabled=true;
	 					}
	 									
	 					frm.login_office.value = level4;
	 					frm.usr_ofc_cd.value = level4;
 					}
 					
					// BU	
					if ( authFlg == "YYYN" ) {				
						//비용주관팀  TIC 설정 Authorized Expense Code
						frm.usr_tic_cd.value = frm.usr_ofc_cd.value;				
					// 사무국
					} else if ( authFlg == "YNYN" || authFlg == "YNYY") {				

						//사무국인경우 수퍼유저인경우 commit체크박스 디스플레이				
						if (authFlg == "YNYY") {
							if ( frm.usr_auth_tp_cd.value == USR_AUTH_TP_CD ) {
								var sp_commit = document.getElementById("sp_commit");
								sp_commit.style.display = "inline";
							} else {
								//사무국인경우 비용팀으로 수퍼유저이더라도 commit체크시 수퍼유저로 사용
								authFlg = "YNYN";
							}
						}
						
						//비용주관팀  TIC 설정 Authorized Expense Code 
						if (authFlg == "YNYN") {
							frm.usr_tic_cd.value = frm.usr_ofc_cd.value;
						}
						
					}		
 					

					frm.auth_flg.value = authFlg;
 					
 				}	

 				break;
 				
 			case SEARCHLIST01: // Expense조회
 				frm.f_cmd.value = SEARCHLIST01;
 				frm.sch_expense_from.value = combo1.Code;
 				frm.sch_expense_to.value = combo2.Code;

 				
 	  			var sXml = sheet1.GetSearchXml("CPS_GEM_0010GS.do", FormQueryString(frm));
 	  			
 	  			var langDiv = getLanguage();
 	  			// ---------------------------------
 	  			// Expense Form ~ To 
 	  			// ---------------------------------
 	  			combo1.RemoveAll(); 
 	  			combo2.RemoveAll();
 	  			
 	  			combo1.InsertItem(0, "", "");
				combo2.InsertItem(0, "", "");
 	  			
 	  			var arrTempData = ComXml2ListMap(sXml);		
 	  			for(var i=0 ; i < arrTempData.length ; i++ ) {
 	  				var tempData = arrTempData[i];
 	  				
 	  				
 	  				if(langDiv == "K") {
 						combo1.InsertItem(i+1, tempData["gen_expn_cd"]+"|"+tempData["krn_abbr_nm"], tempData["gen_expn_cd"]);
 						combo2.InsertItem(i+1, tempData["gen_expn_cd"]+"|"+tempData["krn_abbr_nm"], tempData["gen_expn_cd"]);
 					} else if(langDiv == "E") {
 						combo1.InsertItem(i+1, tempData["gen_expn_cd"]+"|"+tempData["eng_abbr_nm"], tempData["gen_expn_cd"]);
 						combo2.InsertItem(i+1, tempData["gen_expn_cd"]+"|"+tempData["eng_abbr_nm"], tempData["gen_expn_cd"]);
 					}
 	  			}
 	  			combo1.Code = "";
 	  			combo2.Code = "";
 	  			
 				break;
 				
 			case SEARCHLIST03: // Group Expense조회
 				frm.f_cmd.value = SEARCHLIST03;
 				frm.sch_expense_group.value = combo3.Code;
 				
 				var sXml = sheet1.GetSearchXml("CPS_GEM_0010GS.do", FormQueryString(frm));
 				
 				var langDiv = getLanguage();
 				// ---------------------------------
 				// Group Expense 
 				// --------------------------------- 
 	  			combo3.RemoveAll();
 	  			combo3.InsertItem(0, "", "");
 	  			
 				var arrTempData = ComXml2ListMap(sXml);
 				for(var i=0 ; i < arrTempData.length ; i++ ) {
 					var tempData = arrTempData[i];
 					
 					if(langDiv == "K") {
 						combo3.InsertItem(i+1, tempData["gen_expn_cd"]+"|"+tempData["krn_abbr_nm"], tempData["gen_expn_cd"]);
 					} else if(langDiv == "E") {
 						combo3.InsertItem(i+1, tempData["gen_expn_cd"]+"|"+tempData["eng_abbr_nm"], tempData["gen_expn_cd"]);
 					}
 				}
 				combo3.Code = "";
 				
 				break;

 			case IBSAVE:        //저장
// 	          	if(!validateForm(sheetObj,formObj,sAction)) return;
// 				alert (" Save .. ");
 				break;

 			case IBINSERT:      // 입력

 				break;

 			case SEARCHLIST20:      
 				
 				frm.f_cmd.value = SEARCH;
 				
 				var sXml = sheet1.GetSearchXml("GEM_COMMONGS.do", FormQueryString(frm));
 				
 				// LEVEL2 조회
 				var comboListData = ComGetEtcData(sXml, "searchBUOfficeList").split("|");
 				
 				if (typeof comboListData != "undefined" && comboListData != "") {
 					
 					var ofcLvl = frm.ofc_lvl1;
 					ofcLvl.length = 0;
 					ComAddComboItem(ofcLvl, "", "");
 					
 					for ( var i = 0; i < comboListData.length; i++) {
 						ComAddComboItem(ofcLvl, comboListData[i], comboListData[i]);
 					}
 				}

 				break;
         }
     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sAction){
    		
    		if(sAction == SEARCHLIST) {		
    			var fromCd = combo1.Code;
    			var toCd = combo2.Code;		
    			if(parseInt(toCd.replace(/-/g, '')) < parseInt(fromCd.replace(/-/g, ''))) {
    				// GEM01038	ENG	W	검색값의 범위입력 오류!
    				ComShowCodeMessage("GEM01037");
    				combo1.focus();
    				return false;
    			}
    		}
    		return true;
     }
     
     /**
      * 검색 언어 조회
      */
     function getLanguage() {
     	var langDiv = "";
     	var c = document.getElementsByName("sch_lang");
     	for (var i = 0; i < c.length; i++)	{
     		if(c[i].checked == true) {
     			langDiv = c[i].value;
     			break;
     		}
     	}
     	return langDiv;
     }
     
     /**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {int}     sheetNo     sheetObjects 배열에서 순번
      **/
     function initControl() {
     	//** Date 구분자 **/
      	DATE_SEPARATOR = "/";
      	
         //Axon 이벤트 처리1. 이벤트catch
         //axon_event.addListenerForm('keypress', 'obj_keypress', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
     }
     
     /**
      * 검색 언어 선택시 Expense, Group Expense의 값을 변경
      */
     function isLangCheck(val) {
     	// expense
     	doActionIBSheet(SEARCHLIST01);
     	
     	// group expense
     	doActionIBSheet(SEARCHLIST03);
     }
     
     /**
      * Month 항목 체크
      */
     function chkMonth() {
    	 
    	 if(frm.from_rslt_yrmon.value != "" && frm.to_rslt_yrmon.value != "" && frm.from_rslt_yrmon.value.substring(0,4) != frm.to_rslt_yrmon.value.substring(0,4)){
				frm.to_rslt_yrmon.value = "";
				ComShowCodeMessage("GEM01069");
				return false;
		 }
    	 
    	 if(frm.from_rslt_yrmon.value != "" && frm.to_rslt_yrmon.value != "" && (frm.from_rslt_yrmon.value.substring(0,4)+frm.from_rslt_yrmon.value.substring(5,7)) > (frm.to_rslt_yrmon.value.substring(0,4)+frm.to_rslt_yrmon.value.substring(5,7))){
				frm.to_rslt_yrmon.value = "";
				ComShowCodeMessage("GEM01070");
				return false;
		 }
    	 
    	 if(frm.from_rslt_yrmon.value != "" && frm.to_rslt_yrmon.value != "" && (frm.from_rslt_yrmon.value.length != 7 || frm.to_rslt_yrmon.value.length != 7)){
 		 		frm.to_rslt_yrmon.value = "";	
 		 		ComShowCodeMessage("GEM01070");
				return false;
		 }
    	 
    	 
    	 if (frm.from_rslt_yrmon.value != "" && frm.to_rslt_yrmon.value != "") {    	 
	    	 var frmDt = parseInt(ComTrimAll(frm.from_rslt_yrmon.value,"-"),10);
	    	 var toDt = parseInt(ComTrimAll(frm.to_rslt_yrmon.value,"-"),10) ;
	    	 //12개월만 입력가능    	 
	    	 if (toDt - frmDt > 11) {
	    		 frm.to_rslt_yrmon.value = "";	
	    		 //msgs["GEM01085"] = "Month exceeds maximum duration 3 months.";
			 	 ComShowCodeMessage("GEM01085");
	    		 return false;
	    	 }
	    	     	
    	 }
    	 return true;
    	 
     }
     
     /**
      * EnterKey 체크
      */
     function chkEntkey(colName) {
    	 
    	 var objLvl1 = eval(colName);
    	 
    	 if(objLvl1.value.length == 4 && event.keyCode != 8){
    		 objLvl1.value = objLvl1.value+"-";
    	 }
    	 
    	 if(event.keyCode == 13){
        	if(frm.from_rslt_yrmon.value == "" || frm.to_rslt_yrmon.value == ""){
        		ComShowCodeMessage("GEM01068");
 				return false;
 			} 
    		
    		if(chkMonth()){
    			sheet1.WaitImageVisible = true;
    			doActionIBSheet(SEARCHLIST);
    			sheet1.WaitImageVisible = false;
			}
    	 }
     }
     
      function onOfficeKeyup() {
      	 var ofc_expn_cd = frm.ofc_expn_cd.value;

      	 if (ofc_expn_cd.length < 5) {
      		 return;
      	 }
      	 
      	 
     	 if(event.keyCode == 13){       		 
     		 if(frm.from_rslt_yrmon.value == "" || frm.to_rslt_yrmon.value == ""){
          		ComShowCodeMessage("GEM01068");
          		
         		if (frm.to_rslt_yrmon.value == "") {
          			frm.to_rslt_yrmon.focus();
          		}
          		
          		if (frm.from_rslt_yrmon.value == "") {
          			frm.from_rslt_yrmon.focus();
          		}
          		
          		
   				return ;
   			} 
      		
      		if(chkMonth()){
      			sheet1.WaitImageVisible = true;
				sheet1.RemoveAll();
      			doActionIBSheet(SEARCHLIST);
      			sheet1.WaitImageVisible = false;
  			}
     	 }    	  
        }      
      
      
     function onOnlyNumber(obj){
    	 
      	  if ((event.keyCode >= 48 && event.keyCode <= 57) || event.keyCode == 8 || event.keyCode == 9 
      			|| (event.keyCode >= 96 && event.keyCode <= 105) || event.keyCode == 46
      			|| (event.keyCode >= 37 && event.keyCode <= 40)) {
      	   
      	  } else {
      	   event.returnValue = false;
      	  }
     }
     
     /**
      * HO, HQ 체크 박스 설정 
      * @param {value} 선택된 체크 박스구분
      */
      function setHOHQ01(value) {
      	var c1 = frm.sls_ofc_div_cd[0].checked;
      	var c2 = frm.sls_ofc_div_cd[1].checked;	
      	if ( c1 && c2 ) {
      		if (value == "HO") {
     		frm.sls_ofc_div_cd[1].checked = false;
     	} else if (value == "HQ") {
      			frm.sls_ofc_div_cd[0].checked = false;
      		}
      		isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST01','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');
      	}
      	if ( !c1 && !c2 ) {
      		ComSetObjValue(frm.ofc_lvl1,"");
      		ComSetObjValue(frm.ofc_lvl2,"");
      		ComSetObjValue(frm.ofc_lvl3,"");
      	}
      }
      
      /**
      * sheet1 MouseMove 이벤트 
      * @param {ibsheet} sheet 해당 시트   
      * @param {int} button 마우스버튼 방향, 1:왼쪽, 2:오른쪽
      * @param {lnt} shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
      * @param {long} X X 좌표
      * @param {long} Y Y 좌표
      */
      function sheet1_OnMouseMove(sheet , button, shift, X, Y) {
         
      	   var sName = sheet1.ColSaveName(sheet1.MouseCol);
    	   
      	   if ("abbr_nm" == sName) {  
      		   	sheet1.MouseToolTipText = sheet1.CellText(sheet1.MouseRow,"gen_expn_cd");	
      	   }else if ("sub_abbr_nm" == sName) {
         		sheet1.MouseToolTipText = sheet1.CellText(sheet1.MouseRow,"sub_gen_expn_cd");	
      	   } else {
      		 sheet1.MouseToolTipText = "";	
      	   } 
      	   
      }
      
      function sheet1_OnLoadFinish(sheetObj) {
    	 //오피스 콤보 호출
  	     doActionIBSheet(SEARCHLIST20);
          
         // 초기Data조회
  		 doActionIBSheet(IBSEARCH);
  		 
  		 doActionIBSheet(SEARCHLIST02);
  		 
  		 frm.from_rslt_yrmon.focus();
   	  }
      
      
      
      function sheet2_OnSearchEnd(sheet, ErrMsg) {    	  
    	  sheet2.ApplyFormat() ;
      }
      
  	 function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {		
  		frm.page_no.value = PageNo;  		
  		doActionIBSheet(SEARCHLIST);
	 }      
      
      /**
      * 선택된 Item이 변경되었을 때 이벤트가 발생한다.
      * @param comboObj
      * @param index_cd
      * @param text
      * @return
      */
      function combo3_OnChange(comboObj, index_cd, text) {
      	// 다음 포커스로 이동
    	combo1.focus();
      }
      
      function combo3_OnKeyUp(comboObj, KeyCode, Shift) {
    		var sText = comboObj.Text;
    		// 숫자6자리만 입력
    		if ((KeyCode >= 48 && KeyCode <= 57) || (KeyCode >= 96 && KeyCode <= 105) ) {
    			if (sText.length == 6) {
    				frm.sch_expense_to.value = sText;
    				combo1.focus();
    			}
    		} else { 
    			comboObj.Text = ""; 
    		}
      }
      
      function combo1_OnChange(comboObj, index_cd, text) {
        	// 다음 포커스로 이동
      	combo2.focus();
      }
        
      function combo1_OnKeyUp(comboObj, KeyCode, Shift) {
    	  var sText = comboObj.Text;
      	  // 숫자6자리만 입력
      	  if ((KeyCode >= 48 && KeyCode <= 57) || (KeyCode >= 96 && KeyCode <= 105) ) {
      		  if (sText.length == 6) {
      			  frm.sch_expense_to.value = sText;
      			  combo2.focus();
      		  }
      	  } else { 
      		  comboObj.Text = ""; 
      	  }
      }
      
      function combo2_OnChange(comboObj, index_cd, text) {
      	// 다음 포커스로 이동
    	comFocusChange('document.form.sch_tic_cd');
      }
      
      function combo2_OnKeyUp(comboObj, KeyCode, Shift) {
    	  var sText = comboObj.Text;
    	  // 숫자6자리만 입력
    	  if ((KeyCode >= 48 && KeyCode <= 57) || (KeyCode >= 96 && KeyCode <= 105) ) {
    		  if (sText.length == 6) {
    			  frm.sch_expense_to.value = sText;
    			  frm.sch_tic_cd.focus();
    		  }
    	  } else { 
    		  comboObj.Text = ""; 
    	  }
      }

	/* 개발자 작업  끝 */