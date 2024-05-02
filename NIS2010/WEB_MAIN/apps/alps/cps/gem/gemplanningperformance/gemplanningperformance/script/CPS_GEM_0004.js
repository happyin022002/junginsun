/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : cps_gem_0004.js
*@FileTitle : [CPS_GEM-0004] Actual Results for Subsidiaries
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009.05.25 박창준
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
     * @class cps_gem_0004 : cps_gem_0004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function cps_gem_0004() {
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
 var frm = null;
 var sheet1 = null;
 var sheetCnt = 0;
 
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
 					if(frm.pln_yr.value == ""){
 						ComShowCodeMessage("GEM01064");
 						return false;
 					}
 					if(frm.pln_mon.value == ""){
 						ComShowCodeMessage("GEM01065");
 						return false;
 					}
 					sheet1.WaitImageVisible = true;
 					doActionIBSheet(SEARCHLIST);
 					sheet1.WaitImageVisible = false;
 	                break;   
 				case "btn1_Performance":
 					if(frm.pln_yr.value == ""){
 						ComShowCodeMessage("GEM01064");
 						return false;
 					}
 					if(frm.pln_mon.value == ""){
 						ComShowCodeMessage("GEM01065");
 						return false;
 					}
 					if(frm.ofc_lvl3.value == ""){
 						ComShowCodeMessage("GEM01066");
 						return false;
 					}
 					if(frm.pln_yr.value != "" && frm.pln_mon.value != "" && frm.ofc_lvl3.value != ""){
 						sheet1.WaitImageVisible = true;
 						doActionIBSheet(SEARCHLIST01);
 						sheet1.WaitImageVisible = false;
 					}
 	                break;
 				case "btn1_ReqPerformance":		
 					sheet1.WaitImageVisible = true;
 					ComOpenGroupwareMail(sheet1,frm);
 					sheet1.WaitImageVisible = false;
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
 						sheet1.SpeedDown2Excel(1,false,false,"","",false,false,"Actual Results for Subsidiaries",false,"slp_perf_amt01|subs_slp_flag");
 						sheet1.WaitImageVisible = false;
 					}
 					break;
 				case "btn1_Slip_Upload":

 					var param   = "pln_yr="        + frm.pln_yr.value;
 					    param  += "&pln_mon="      + frm.pln_mon.value;
 					    param  += "&ofc_lvl3="     + frm.ofc_lvl3.value;
 					    param  += "&hpln_yr="      + frm.hpln_yr.value;
 					    param  += "&hpln_mon="     + frm.hpln_mon.value;
 					    param  += "&login_ofc_cd=" + frm.login_ofc_cd.value;
 					    param  += "&auth_flg="     + frm.auth_flg.value;
 					var sUrl    = "CPS_GEM_0032.do?" + param;
 					var winName = "CPS_GEM_0032"; 					
 					var rVal = ComOpenWindowCenter(sUrl,winName,1024,550, true);
 					
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
    		sheetCnt = sheetObjects.length ;

    		for(i=0;i<sheetCnt;i++){
    			
    			//khlee-시작 환경 설정 함수 이름 변경
    	        ComConfigSheet (sheetObjects[i] );

    	        initSheet(sheetObjects[i],i+1);
    	        //khlee-마지막 환경 설정 함수 추가
    	        ComEndConfigSheet(sheetObjects[i]);
    		}
    		sheet1.WaitImageVisible = false;
     }
     
     function initControl() {
    		//** Date 구분자 **/
    	 	DATE_SEPARATOR = "/";
    	 	
    	    //Axon 이벤트 처리1. 이벤트catch
    	 	axon_event.addListenerForm('keypress', 'obj_keypress', frm); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
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
                     style.height = 445;

                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 20, 100);

 					var HeadTitle1 = "Month|Office|Expense|Expense Name|CUR|Unit|Performance|Year to date|Year to date|Year to date|Year to date|Creator\nID|Performance||";
 					var HeadTitle2 = "Month|Office|Expense|Expense Name|CUR|Unit|Performance|Assigned|Performance|Ratio %|Reason|Creator\nID|Performance|";
                     var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 3, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
 					 InitHeadRow(1, HeadTitle2, true);
 					
                     //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT,		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
// 					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
 					
 					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		 "rslt_yrmon",			false,		"",			dfDateYm,		0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		 "ofc_cd",				false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		 "gen_expn_cd",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			160,	daLeft,		true,		 "abbr_nm",				false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		 "locl_curr_cd",		false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,		 "rqst_ut_val",			false,		"",			dfNullInteger,	0, false, false);					
 					InitDataProperty(0, cnt++ , dtAutoSum,		120,	daRight,	true,		 "perf_amt",			true,		"",			dfNullFloat,	3, false, true,	12);
 					InitDataProperty(0, cnt++ , dtAutoSum,		120,	daRight,	true,		 "gen_expn_amt",		false,		"",			dfNullInteger,	0, false, false);
 					InitDataProperty(0, cnt++ , dtAutoSum,		120,	daRight,	true,		 "slp_perf_amt",		false,		"",			dfNullFloat,	3, false, false);
 					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,		 "ratio1",				false,		"|slp_perf_amt|/|gen_expn_amt|*100",			dfNullFloat,	1, false, false);
 					InitDataProperty(0, cnt++ , dtData,	 		160,	daLeft,		true,		 "gen_expn_ovr_rto_rsn",false,		"",			dfNone,			0, false,false, 100);
 					InitDataProperty(0, cnt++ , dtData,			0,		daCenter,	true,		 "cre_usr_id",			false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtHidden,		100,	daRight,	true,		 "slp_perf_amt01",		false,		"",			dfNullFloat,	3, false, false);
 					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		 "subs_slp_flag",		false,		"",			dfNone,			0, false, false);
 					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		 "ibflag");
 					
 					PopupImage  =  "img/btns_note.gif";
 					ShowButtonImage = 1;
// 					CountPosition = 0;
 				}
 				break;
         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sAction) {
         //sheetObj.ShowDebugMsg = false;
         switch(sAction) {

 			
 				
 			case IBSEARCH:      //Open

 				frm.f_cmd.value = SEARCH;
 				var sXml = sheet1.GetSearchXml("CPS_GEM_0004GS.do", FormQueryString(frm));

 				var arrXml = sXml.split("|$$|");
 				var authFlg  = "";
 				
 				// 로그인 오피스 정보 
 				if (arrXml.length > 0) {			
 					var list = ComXml2ListMap(arrXml[0]);
 					var officeLevelVo  = list[0];
 					var loginOfcCd = ComGetEtcData(arrXml[0] ,"usr_ofc_cd");
 					
 					authFlg  = officeLevelVo["auth_flg"];
 					//권한 설정
					frm.auth_flg.value = authFlg;
					frm.login_ofc_cd.value = loginOfcCd;
 					
 				}
 				// 권한 없는 Office 가 로그인 시 화면 닫음
 				if ( authFlg == null || authFlg == "" || authFlg == "NNNN") {
 					goNoAuthority();
 			    }

 				// 실적을 입력할 년월
 				if (arrXml.length > 0) {
 					
 					var closingDate = ComGetEtcData(arrXml[0] ,"closingDate");
 	 				
 	 				frm.pln_yr.value = closingDate.substring(0,4);
 	 				frm.pln_mon.value = closingDate.substring(4,6);
 	 				
 	 				frm.hpln_yr.value = closingDate.substring(0,4);
 	 				frm.hpln_mon.value = closingDate.substring(4,6);
 	 				
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
	 						selLevelChange('GEM_COMMONGS.do','SEARCHLIST03','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');			
	 						ComSetObjValue(frm.ofc_lvl2,level3);					
	 						//LV3
	 						selLevelChange('GEM_COMMONGS.do','SEARCHLIST04','sheet1','sls_ofc_div_cd','2','document.form.ofc_lvl');			
	 						ComSetObjValue(frm.ofc_lvl3,level4);					
	 										
	 					//사무국 , BU ,TIC
	 					} else if ( authFlg == "YNYN" || authFlg == "YNYY" || authFlg == "YYYN") {
	 						ComEnableObject(frm.ofc_lvl1, true);
	 						ComEnableObject(frm.ofc_lvl2, true);
	 						ComEnableObject(frm.ofc_lvl3, true);				
	 						frm.sls_ofc_div_cd[0].checked = false;
	 						frm.sls_ofc_div_cd[1].checked = false;
	 						
	 						if ( authFlg == "YNYY")
	 						{
	 							if ( frm.usr_auth_tp_cd.value != USR_AUTH_TP_CD ) {
	 								authFlg = "YNYN";
	 								frm.auth_flg.value = authFlg;
	 							} 							
	 						}
	 						
	 					} else {
	 						ComEnableObject(frm.ofc_lvl1, false);
	 						ComEnableObject(frm.ofc_lvl2, false);
	 						ComEnableObject(frm.ofc_lvl3, false);		
	 						frm.sls_ofc_div_cd[0].disabled=true;
	 						frm.sls_ofc_div_cd[1].disabled=true;
	 					}
 					}
 				}	

 				frm.pln_yr.focus();
 				break;


 			case SEARCHLIST: // 조회
 				
 	      			frm.f_cmd.value = SEARCHLIST;     		   
 	      			var sXml = sheet1.GetSearchXml("CPS_GEM_0004GS.do", FormQueryString(frm));
 	      			
 	      			var arrXml = sXml.split("|$$|");
 		  			if (arrXml.length > 0) {
 		  				with(sheet1){
 		  					LoadSearchXml(arrXml[0]);
 		  					
 		  					SumText(0,"rslt_yrmon")="Grand Total";
 		  					SumValue(0,"ratio1") = SumValue(0,"slp_perf_amt")/SumValue(0,"gen_expn_amt")*100;
 		  							  					
 		  					var ofc_nm = sheet1.CellValue(2, 1);
 		  					var ofc_count = 1;
 		  					for ( var i = 3; i <= sheet1.RowCount+1; i++) {
 		  	     					if(sheet1.CellValue(i, 1) != ofc_nm && sheet1.CellValue(i, 1) != ''){
 		  	     						ofc_count++;
 		  	     						ofc_nm = sheet1.CellValue(i, 1);
 		  	     					}
 		  					}
 		  					SumText(0,"ofc_cd") = ofc_count;
 		  						
 		  				}	
 		  			}
 		  					  			
 		  			var pln_yrmon = frm.pln_yr.value+frm.pln_mon.value;
 		  			
 		  			var hpln_yrmon = frm.hpln_yr.value+frm.hpln_mon.value;
 		  			
 		  			
 		  			if(pln_yrmon < hpln_yrmon){
 		  				
 		  				for ( var i = 0; i <= sheet1.RowCount+1; i++) {
 	 						sheet1.CellEditable(i,6) = false;
 	 					}
 		  				
 		  			}else{
 		  				
 		  				for ( var i = 0; i <= sheet1.RowCount+1; i++) {
 		  					
 		  					var subsSlpflag = sheet1.CellValue(i, "subs_slp_flag");
 		  					
 		  					if( subsSlpflag == "Y" ) {
 		  						sheet1.CellEditable(i,6) = false;
 		  					}else{
 		  						sheet1.CellEditable(i,6) = true;
 		  					}
 	 					}
 		  			}
 		  			
 		  			sheet1.ColBackColor(10) = sheet1.RgbColor(255,255,255);
 		  					  			
 	     	   	break;
 	     	   	
 			case IBSAVE:        //저장
 				if(validateForm(sAction)) {
 					// 저장하시겠습니까?
 					if(!ComCodeMsgBySave()) return;
 					
 					frm.f_cmd.value = MULTI; 
 					sheet1.DoSave("CPS_GEM_0004GS.do", FormQueryString(frm),-1,false);

 				}
 				break;

 			case IBINSERT:      // 입력

 				break;
 				
 			case SEARCHLIST20:      // 조회
 				
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
 				
 			case SEARCHLIST01: // Performance Input
 				
 	      			frm.f_cmd.value = SEARCHLIST01;     		   
 	      			var sXml = sheet1.GetSearchXml("CPS_GEM_0004GS.do", FormQueryString(frm));
 	      			
 	      			var arrXml = sXml.split("|$$|");
 	      			if (arrXml.length > 0) {
 		  				with(sheet1){
 		  					LoadSearchXml(arrXml[0]);
 		  					
 		  					SumText(0,"rslt_yrmon")="Grand Total";
 		  					SumValue(0,"ratio1") = SumValue(0,"slp_perf_amt")/SumValue(0,"gen_expn_amt")*100;
 		  							  					
 		  					var ofc_nm = sheet1.CellValue(2, 1);
 		  					var ofc_count = 1;
 		  					for ( var i = 3; i <= sheet1.RowCount+1; i++) {
 		  	     					if(sheet1.CellValue(i, 1) != ofc_nm && sheet1.CellValue(i, 1) != ''){
 		  	     						ofc_count++;
 		  	     						ofc_nm = sheet1.CellValue(i, 1);
 		  	     					}
 		  					}
 		  					SumText(0,"ofc_cd") = ofc_count;
 		  						
 		  				}	
 		  			}
 		  					  			
 	      			var pln_yrmon = frm.pln_yr.value+frm.pln_mon.value;
 		  			
 		  			var hpln_yrmon = frm.hpln_yr.value+frm.hpln_mon.value;
 		  			
 		  			
 		  			if(pln_yrmon < hpln_yrmon){
 		  				
 		  				for ( var i = 0; i <= sheet1.RowCount+1; i++) {
 	 						sheet1.CellEditable(i,6) = false;
 	 					}
 		  				
 		  			}else{
 		  				
 		  				for ( var i = 0; i <= sheet1.RowCount+1; i++) {
 		  					
 		  					var subsSlpflag = sheet1.CellValue(i, "subs_slp_flag");
 		  					
 		  					if( subsSlpflag == "Y" ) {
 		  						sheet1.CellEditable(i,6) = false; 		  						
 		  					}else{
 		  						sheet1.CellEditable(i,6) = true;
 		  					}
 	 					}
 		  			}
 		  			
 		  			sheet1.ColBackColor(10) = sheet1.RgbColor(255,255,255);
 		  					  			
 	     	   	break;
         }
     }
     
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sAction){
     	if (!ComChkValid(frm)) return false;
     	
     	if(sAction == SEARCHLIST) {
     		if(frm.sch_lvl1.value != '') {
     			if(!isRadioUnselected("sch_hohq_gbn")) {
     				// HO or HQ를 선택하세요.
     				ComShowCodeMessage("GEM01038","HO or HQ");
     				return false;
     			}
     		}
     	}
     	
     	if(sAction == IBSAVE) {
     		
     		var Ucnt = 0;

     			for ( var i = 2; i <= sheet1.RowCount+1; i++) {
     					   
     					if((sheet1.CellValue(i, "ratio1") > 100) && sheet1.CellValue(i, "gen_expn_ovr_rto_rsn") == ''
     						&& sheet1.CellValue(i, "rslt_yrmon")!= "Grand Total" && sheet1.CellValue(i, "rslt_yrmon")!= "Sub Total"){
     						ComShowCodeMessage("GEM01067",i-1);
     						sheet1.SelectCell(i, "gen_expn_ovr_rto_rsn");
     						return false;
     					}
     					
     					if(sheet1.CellValue(i, 14) == 'U'){
     						Ucnt++;
     					}

				}

     			if(Ucnt == 0){
     				ComShowCodeMessage("GEM01056");
					return false;
     			}
     		
     	}
     	
     	return true;
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
      		isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST03','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');
      	}
      	if ( !c1 && !c2 ) {
      		ComSetObjValue(frm.ofc_lvl1,"");
      		ComSetObjValue(frm.ofc_lvl2,"");
      		ComSetObjValue(frm.ofc_lvl3,"");
      	}
      } 
 	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		//ShowSubSum(StdCol, SumCols, [PosBottom], [Sort], [ShowCumulate], [CaptionCol], [OtherColText], [AvgCols], [IsSumEx]) 
		
		if(frm.sum_up[0].checked){
		subSum(sheetObj);
		}
	}

	function sheet1_OnChange(sheetObj, Row, Col, Value)  {
		with(sheetObj){
			if(ColSaveName(Col) == "perf_amt"){
				
				sheet1.CellValue(Row, 8) = eval(sheet1.CellValue(Row, 12)) + eval(sheet1.CellValue(Row, 6));
				
				if(sheet1.CellValue(Row, 6) == ""){
					sheet1.CellValue(Row, 6) = 0;
				}
			}
			if(ColSaveName(Col) ==  "slp_perf_amt" || ColSaveName(Col) == "gen_expn_amt"||ColSaveName(Col) == "perf_amt")
				if(frm.sum_up[0].checked){
					subSum(sheetObj);
				}
			
			SumText(0,"rslt_yrmon")="Grand Total";
			SumValue(0,"ratio1") = SumValue(0,"slp_perf_amt")/SumValue(0,"gen_expn_amt")*100;

				var ofc_nm = sheet1.CellValue(2, 1);
				var ofc_count = 1;
				for ( var i = 3; i <= sheet1.RowCount+1; i++) {
    					if(sheet1.CellValue(i, 1) != ofc_nm && sheet1.CellValue(i, 1) != ''){
    						ofc_count++;
    						ofc_nm = sheet1.CellValue(i, 1);
    					}
				}
				SumText(0,"ofc_cd") = ofc_count;
		}
	}

	function subSum(sheetObj){
		with(sheetObj){
			Redraw = false;
			HideSubSum("ofc_cd");
			ShowSubSum("ofc_cd", "6|7|8", -1, false, false, 0,"rslt_yrmon=Sub Total;ratio1=|slp_perf_amt|/|gen_expn_amt|*100");
//			var sRow = FindSubSumRow();
////			alert(sRow);
//			  var arrRow = sRow.split("|");
//
//			  //가져온 행을 배열로 반든다.
//			  for (idx=0; idx<arrRow.length-1; idx++){ 
////				  	if(idx<20) alert(CellValue(idx,"slp_perf_amt"));
//					CellValue2(arrRow[idx],"ratio1") = CellValue(arrRow[idx],"slp_perf_amt")/CellValue(arrRow[idx],"gen_expn_amt") *100;
//				  
//			  }
//
//			SumValue(0,"ratio1") = SumValue(0,"slp_perf_amt")/SumValue(0,"gen_expn_amt") *100;
			Redraw = true;
			
		}

	}
	
 	//===================================================================================
 	//Sheet 이벤트 처리
 	//===================================================================================
 	/**
 	 * 셀을 클릭했을때 발생하는 이벤트 <br>
 	 * @param {ibsheet} sheetObj    IBSheet Object
 	 * @param {ibsheet} row     	sheetObj의 선택된 Row
 	 * @param {ibsheet} col     	sheetObj의 선택된 Col
 	 **/
 	function sheet1_OnClick(sheetObj, row, col, value) {

        //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
        if (sheetObj.ColSaveName(col) == "gen_expn_ovr_rto_rsn") {	 

//        	ComShowMemoPad(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax)
        	ComShowMemoPad(sheetObj, null, null, null, null, null, 1300)
		}
 		
 	}
 	
 	function sheet1_OnLoadFinish(sheetObj) {
 		// html컨트롤 이벤트초기화
	    initControl();

	    //오피스 콤보 호출
	    doActionIBSheet(SEARCHLIST20);

	    // 초기Data조회
		doActionIBSheet(IBSEARCH);
 	}
 	
 	var start = (new Date()).getTime();//시작시간 체크
 	
 	function noticeButton() {
 			
 			var ptime = new Date(0, 0, 0, 0, 0, 0, (new Date()).getTime() - start);
 			var seconds = ptime.getSeconds()%2;
 			
 			if(frm.ofc_lvl3.value != ""){
 				if(seconds == 1){
 					document.all.btn1_Performance.style.color = 'red';
 				}
 				else{
 					document.all.btn1_Performance.style.color = 'black';	
 				}
 			
 				if(sheet1.RowCount == 0){
 					setTimeout("noticeButton()", 1000); //주기적으로 noticeButton()호출
 				}
 				else{
 					document.all.btn1_Performance.style.color = 'black';
 				}
 				
 				frm.sum_up[1].focus();
 			}
 
 	}
 	
 	/**
     * EnterKey 체크
     */
    function chkEntkey() {
   	 
   	 if(event.keyCode == 13){ 	
   		 sheet1.WaitImageVisible = true;	
   		 doActionIBSheet(SEARCHLIST);	
   		 sheet1.WaitImageVisible = false;
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

	/* 개발자 작업  끝 */