/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : cps_gem_0015.js
*@FileTitle : [CPS_GEM-0015] Expense Vs Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009.06.09 박창준
* 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2011-02-17 이준범 [CHM-201108627-01]
 * 제목: Request 권한 없는 office user의 접근 시 all data open 오류 해소 요청
 * 보완: Request 권한 없는 Office 에 대한 화면 Block
 * 2011.03.28 [CHM-201109333-01]
 * 개발자 : 이준범
 * Title: 사무국 권한 명확화 요청
 * DESC : 사무국 SELPLP 소속 사용자 중, 슈퍼유저 와 일반유저를 구분하여, 데이터 조회 할 수 있도록  SQL 수정
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
     * @class cps_gem_0015 : cps_gem_0015 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function cps_gem_0015() {
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

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
 			switch(srcName) {
 				case "btn1_Retrieve":
 					
 					if(frm.from_rslt_yrmon.value == "" || frm.to_rslt_yrmon.value == ""){
 						ComShowCodeMessage("GEM01071");
 		 				return false;
 		 			} 
 					
 					if(chkMonth()){
 						sheet1.WaitImageVisible = true;
 						doActionIBSheet(SEARCHLIST);
 						sheet1.WaitImageVisible = false;
 					}
 					
 					break;
 				case "btn1_New":
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
 				case "btn1_Save":
 					sheet1.WaitImageVisible = true;
 					doActionIBSheet(IBSAVE);
 					sheet1.WaitImageVisible = false;
 					break;
 				case "btn1_DownExcel":
 					if (sheet1.RowCount <= 0 ) {
 						// 조회된 건수가 없습니다.
 						ComCodeMsgByNoRelatedData();
 						return;
 					} else {
 						sheet1.WaitImageVisible = true;
 						//sheet1.Down2Excel(1,true,true,true,"","",false,false,"Expense Vs Performance",false,"abbr_nm|rslt_yrmon");
 						//sheet1.Down2Excel(1,false,false,true,"","",false,false,"Expense Vs Performance",false,"rslt_yrmon");
 						sheet1.SpeedDown2Excel(1,false,false,"","",false,false,"Expense Vs Performance",false,"rslt_yrmon");
 						sheet1.WaitImageVisible = false;
 					}
 					break;
/* 					
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
*/ 	                
 				case "btn_popup":
 					var param = "popup=Y";
 		   			var url = "CPS_GEM_0010.do?"+param;
 		   			var winName = "CPS_GEM_0010";
 		   			
 		   			var win = ComOpenWindowCenter(url,winName,1000,800, false);
 		   			win.focus();
 		   			
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
    	 
    	 frm = document.form;
    	 sheet1 = sheetObjects[0];
    	 
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
         
         var current= new Date();
         var outYear = current.getFullYear();
         var outMonth = current.getMonth() + 1;
         
         if(outMonth < 10){
        	 frm.from_rslt_yrmon.value = outYear + "-0" +outMonth;
        	 frm.to_rslt_yrmon.value = outYear + "-0" +outMonth;
         }
         else{
        	 frm.from_rslt_yrmon.value = outYear + "-" +outMonth;
        	 frm.to_rslt_yrmon.value = outYear + "-" +outMonth; 
         }
         
         
 		 
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
                     style.height = 400;

                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 15, 100);

 					var HeadTitle1 = "|Office|Company\nDIV|Expense\nCode|Expense\nName|CUR|Unit|Year|Month|Month|Month|Year to date|Year to date|Year to date|Year to date|Year to date|Year to date";
 					var HeadTitle2 = "|Office|Company\nDIV|Expense\nCode|Expense\nName|CUR|Unit|Assigned Expense|Assigned Expense |Performance|Ratio %|Assigned Expense|Performance|Ratio %|Diff(A-P)|Reason of Increase / Decrease|Month";
                     
 					var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 6, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
 					 InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT,		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
 					
 					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,       "ofc_cd",				false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,       "ofc_co_div_cd",		false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"gen_expn_cd",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		"abbr_nm",				false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"locl_curr_cd",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"rqst_ut_val",			false,		"",			dfNullInteger,	0, false, false);
 					InitDataProperty(0, cnt++ , dtAutoSum,		160,	daRight,	true,		"year_ass_exp",			false,		"",			dfNullInteger,	0, false, false);
 					InitDataProperty(0, cnt++ , dtAutoSum,		160,	daRight,	true,		"mon_ass_exp",			false,		"",			dfNullInteger,	0, false, false);
 					InitDataProperty(0, cnt++ , dtAutoSum,		160,	daRight,	true,		"mon_perf",				false,		"",			dfNullFloat,	3, false, false);
 					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		"ratio",				false,		"",			dfNullFloat,	2, false, false);
 					InitDataProperty(0, cnt++ , dtAutoSum,		160,	daRight,	true,		"ytd_ass_exp",			false,		"",			dfNullInteger,	0, false, false);
 					InitDataProperty(0, cnt++ , dtAutoSum,		160,	daRight,	true,		"ytd_perf",				false,		"",			dfNullFloat,	3, false, false);
 					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,		"ratio1",				false,		"",			dfNullFloat,	2, false, false);
 					InitDataProperty(0, cnt++ , dtAutoSum,		160,	daRight,	true,		"diff",					false,		"",			dfNullInteger,	0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			0,		daLeft,		true,		"gen_expn_ovr_rto_rsn",	false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,		"rslt_yrmon",			false,		"",			dfNone,			0, false, false);

 					PopupImage  =  "img/btns_note.gif";
 					ShowButtonImage = 1;
// 					CountPosition = 0;
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
	 				
	 				var from_closing_date = '';
	 				var to_closing_date = '';
	 				
	 				if(frm.from_rslt_yrmon.value.replace('-', '') <= frm.closing_date.value){
	 					from_closing_date = frm.from_rslt_yrmon.value.replace('-', '');
	 				}else{
	 					from_closing_date = frm.closing_date.value;
	 				}
	 				
	 				if(frm.to_rslt_yrmon.value.replace('-', '') <= frm.closing_date.value){
	 					to_closing_date = frm.to_rslt_yrmon.value.replace('-', '');
	 				}else{
	 					to_closing_date = frm.closing_date.value;
	 				}
	 				
	 				if(frm.perf_div[1].checked){
	 					var fromToMonth = "Month (" + from_closing_date.substring(2,4)+ "." + from_closing_date.substring(4,6)+ "~" + to_closing_date.substring(2,4)+ "." + to_closing_date.substring(4,6)+")";
		 				var fromToYtd = "Year to date (" + to_closing_date.substring(2,4)+ ".01" + "~" + to_closing_date.substring(2,4)+ "." + to_closing_date.substring(4,6)+")";
		 				
	 				}
	 				else{
		 				var fromToMonth = "Month (" + frm.from_rslt_yrmon.value.substring(2,4)+ "." + frm.from_rslt_yrmon.value.substring(5,7)+ "~" + frm.to_rslt_yrmon.value.substring(2,4)+ "." + frm.to_rslt_yrmon.value.substring(5,7)+")";
		 				var fromToYtd = "Year to date (" + frm.from_rslt_yrmon.value.substring(2,4)+ ".01" + "~" + frm.to_rslt_yrmon.value.substring(2,4)+ "." + frm.to_rslt_yrmon.value.substring(5,7)+")";
		 			}
	 				
	 				sheet1.CellValue(0, 8) = fromToMonth;
	 				sheet1.CellValue(0, 9) = fromToMonth;
	 				sheet1.CellValue(0, 10) = fromToMonth;
	 				sheet1.CellValue(0, 11) = fromToYtd;
	 				sheet1.CellValue(0, 12) = fromToYtd;
	 				sheet1.CellValue(0, 13) = fromToYtd;
	 				sheet1.CellValue(0, 14) = fromToYtd;
	 				sheet1.CellValue(0, 15) = fromToYtd;
	 				sheet1.CellValue(0, 16) = fromToYtd;
	      			
	      			var sXml = sheet1.GetSearchXml("CPS_GEM_0015GS.do", FormQueryString(frm));
	      			
	      			var arrXml = sXml.split("|$$|");
		  			if (arrXml.length > 0) {
		  				sheet1.LoadSearchXml(arrXml[0]);
		  				sheet1.ColBackColor(3) = sheet1.RgbColor(239,235,239);
		  				sheet1.SumText(0,"ofc_cd")="";
		  				sheet1.SumText(0,"abbr_nm")="Grand Total";
		  				
		  				sheet1.SumValue(0,"ratio") = sheet1.SumValue(0,"mon_perf")/sheet1.SumValue(0,"mon_ass_exp")*100;
		  				sheet1.SumValue(0,"ratio1") = sheet1.SumValue(0,"ytd_perf")/sheet1.SumValue(0,"ytd_ass_exp")*100;
		  			}

		  			if(frm.from_rslt_yrmon.value == frm.to_rslt_yrmon.value){
		  				sheet1.ColBackColor(15) = sheet1.RgbColor(255,255,255);
		        	}
        	 	}	
	     	   	break;
				
         case SEARCHLIST02:      //Open
				
				frm.f_cmd.value = SEARCH;
				var sXml = sheet1.GetSearchXml("CPS_GEM_0015GS.do", FormQueryString(frm));
				
				var arrXml = sXml.split("|$$|");
				var authFlg  = "";
				
				// 로그인 오피스 정보 
				if (arrXml.length > 0) {			
					var list = ComXml2ListMap(arrXml[0]);
					var officeLevelVo  = list[0];
					
					authFlg  = officeLevelVo["auth_flg"];
					
				}
				
				if ( authFlg == null || authFlg == "" || authFlg == "NNNN") {
					goNoAuthority();
					return;
			    }
				
	  			// Closing Date
 				if (arrXml.length > 0) {
 					
 					var closingDate = ComGetEtcData(arrXml[0] ,"closingDate");
 	 				
 					frm.closing_date.value = closingDate;
 	 				
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
					//권한 설정
					frm.auth_flg.value = authFlg;
					
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
 				if(validateForm(sAction)) {
 					// 저장하시겠습니까?
 					if(!ComCodeMsgBySave()) return;
 					frm.f_cmd.value = MULTI; 
 					sheet1.DoSave("CPS_GEM_0015GS.do", FormQueryString(frm),-1,false);

 				}
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
      	
      	//keypress
        axon_event.addListenerForm('keypress', 'obj_keypress', frm);
        // focus in
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);
        // focus out
        axon_event.addListenerFormat('beforeactivate',   'obj_activate',    frm);
      	
         //Axon 이벤트 처리1. 이벤트catch
         //axon_event.addListenerForm('keypress', 'obj_keypress', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
     }
     
     /**
      * HTML Control KeyPress 이벤트 호출
      */
     function obj_keypress() {
         switch (event.srcElement.name) {    
         case "com_diff_num":
     		ComKeyOnlyNumber(event.srcElement, ".");
     		break;
         case "com_ratio_num":
     		ComKeyOnlyNumber(event.srcElement, ".");
     		break;
     	}
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
				ComShowCodeMessage("GEM01072");
				return false;
		 }
    	 
    	 if(frm.from_rslt_yrmon.value != "" && frm.to_rslt_yrmon.value != "" && (frm.from_rslt_yrmon.value.substring(0,4)+frm.from_rslt_yrmon.value.substring(5,7)) > (frm.to_rslt_yrmon.value.substring(0,4)+frm.to_rslt_yrmon.value.substring(5,7))){
				frm.to_rslt_yrmon.value = "";
				ComShowCodeMessage("GEM01073");
				return false;
		 }
    	 
    	 if(frm.from_rslt_yrmon.value != "" && frm.to_rslt_yrmon.value != "" && (frm.from_rslt_yrmon.value.length != 7 || frm.to_rslt_yrmon.value.length != 7)){
    		 	frm.to_rslt_yrmon.value = "";	
    		 	ComShowCodeMessage("GEM01073");
				return false;
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
    	 
    	 if(frm.from_rslt_yrmon.value.length == 7){
    		 frm.to_rslt_yrmon.focus();
    	 }
    	 
    	 if(event.keyCode == 13){
        	if(frm.from_rslt_yrmon.value == "" || frm.to_rslt_yrmon.value == ""){
        		ComShowCodeMessage("GEM01071");
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
         		ComShowCodeMessage("GEM01071");
         		
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
      * Sub Total 설정
      */
     function setSubTotal() {
    	
    	 if(frm.sub_total[2].checked && frm.ofc_cur[0].checked){
    		 ComShowCodeMessage("GEM01074");
       		frm.ofc_cur[1].checked = true;
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
       * Ratio 항목 체크
       */
      function ratioChange() {
     	 
     	 if(frm.com_ratio[0].selected){
 				frm.com_ratio_num.value = "";
 		 }
     	 
      }
      
      /**
       * Diff 항목 체크
       */
      function diffChange() {
     	 
     	 if(frm.com_diff[0].selected){
 				frm.com_diff_num.value = "";
 		 }
     	 
      }
      
      
      /**
       * Divide 세팅
       */
      function putDivide() {
     	 
    	  frm.expn_dep[1].checked = true;
     	 
      }

 	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 		//ShowSubSum(StdCol, SumCols, [PosBottom], [Sort], [ShowCumulate], [CaptionCol], [OtherColText], [AvgCols], [IsSumEx]) 
 		if(frm.sub_total[1].checked){
 			sheetObj.ShowSubSum("ofc_cd", "7|8|9|11|12|14", -1, false,false, 0,"1=;2=Sub Total;ratio=|mon_perf|/|mon_ass_exp|*100;ratio1=|ytd_perf|/|ytd_ass_exp|*100");
 		}
 		if(frm.sub_total[2].checked){
 			sheetObj.ShowSubSum("gen_expn_cd", "7|8|9|11|12|14", -1, false,false, 0,"1=;2=Sub Total;ratio=|mon_perf|/|mon_ass_exp|*100;ratio1=|ytd_perf|/|ytd_ass_exp|*100");
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
 	
/*
 	function sheet1_OnPopupClick(sheetObj, Row, Col) {
         //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
         if (sheetObj.ColSaveName(Col) == "Reason") {
 			ComShowMemoPad(sheetObj);
 		}
 	}
*/ 	
 	function sheet1_OnClick(sheetObj, row, col, value) {
// 		alert(col);
        //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
        if (sheetObj.ColSaveName(col) == "gen_expn_ovr_rto_rsn") {	 
        	if(frm.from_rslt_yrmon.value == frm.to_rslt_yrmon.value){
        		ComShowMemoPad(sheetObj);
        	}
		}
 		
 	}
 	
 	/**
     * sheet1 MouseMove 이벤트 
     * @param {ibsheet} sheet 해당 시트   
     * @param {int} button 마우스버튼 방향, 1:왼쪽, 2:오른쪽
     * @param {lnt} shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외 0
     * @param {long} X X 좌표
     * @param {long} Y Y 좌표
     */
 	/*
 	function sheet1_OnMouseMove(sheet , button, shift, X, Y) {
        
     	   var sName = sheet1.ColSaveName(sheet1.MouseCol);
   	   
     	   if ("abbr_nm" == sName) {  
     		   	sheet1.MouseToolTipText = sheet1.CellText(sheet1.MouseRow,"gen_expn_cd");	
     	   } else {
     		    sheet1.MouseToolTipText = "";	
     	   } 
     	   
     }
     */
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