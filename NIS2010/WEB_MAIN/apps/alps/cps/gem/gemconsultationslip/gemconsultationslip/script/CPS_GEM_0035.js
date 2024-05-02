/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CPS_GEM_0035.js
*@FileTitle : Consultation Slip
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.17 
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
     * @class CPS_GEM_0033 : CPS_GEM_0033 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function CPS_GEM_0035() {
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

 // 공통전역변수
    var sheetObjects = new Array();
    var comboObjects = new Array();
    var sheetCnt = 0;
    var comboCnt = 0;
    var sheet1 = null;
    //sheetResizeFull = true;
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    	function processButtonClick(){
    		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

    		 var sheetObject = sheetObjects[0];

    		 /*******************************************************/
    		 var formObject = document.form;

//    		try {
    		    var srcObj  = window.event.srcElement;
    			var srcName = window.event.srcElement.getAttribute("name");

    			switch(srcName) {
    		    	case "btn_new":
    		    		sheetObject.RemoveAll();
    		    		ComResetAll();
    		    		doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
            		break;
                	case "btn_retrive":
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;

    				case "btn_downexcel":
    					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    					break;
    					
    				case "btns_calendar2":
    					if ( srcObj.style.filter == "" ) {
    						var cal = new ComCalendarFromTo();
    						cal.select(formObject.period_stdt, formObject.period_eddt, 'yyyy-MM-dd');
    					}
    				break;
//    				case "btn_print" :
//    					var param = "";
//    					for(var i=0;i<formObject.gen_expn_rqst_tp_cd.length;i++){
//    						if(formObject.gen_expn_rqst_tp_cd[i].checked){
//    							param += "gen_expn_rqst_tp_cd="+formObject.gen_expn_rqst_tp_cd[i].value;
//    						}
//    					}
//    					param += "&period_stdt="+formObject.period_stdt.value;
//    					param += "&period_eddt="+formObject.period_eddt.value;
//    					param += "&csr_no="+formObject.csr_no.value;
//    					param += "&ofc_lvl1="+formObject.ofc_lvl1.value;
//    					param += "&ofc_lvl2="+formObject.ofc_lvl2.value;
//    					param += "&ofc_lvl3="+formObject.ofc_lvl3.value;
//    					param += "&subs_expn_nm="+formObject.subs_expn_nm.value;
//    					
//    					param += "&expn_div_cd="+(formObject.expn_div_cd.options[formObject.expn_div_cd.selectedIndex].text.replace('&',' '));
//    					
//    					param += "&status="+formObject.status.options[formObject.status.selectedIndex].text;
//    					window.showModalDialog("/hanjin/CPS_GEM_0037.do?"+param, window, "dialogWidth:955px; dialogHeight:750px; help:no; status:no; scroll:no; resizable:no;");
//    					break;

    			} // end switch
//    		}catch(e) {
//        		if( e == "[object Error]") {
//        		    ComShowCodeMessage("COM12111");
//        		} else {
//        			ComShowMessage(e);
//        		}
//    		}
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
         * IBSheet Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setComboObject(combo_obj){
        	comboObjects[comboCnt++] = combo_obj;
        }

    	/**
    	 * Sheet 기본 설정 및 초기화
    	 * body 태그의 onLoad 이벤트핸들러 구현
    	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    	 */
    	function loadPage() {
    		var formObj = document.form;
    		
    		for(i=0;i<sheetObjects.length;i++){

    			//khlee-시작 환경 설정 함수 이름 변경
    			ComConfigSheet(sheetObjects[i]);
    			
    			initSheet(sheetObjects[i],i+1);
    			//khlee-마지막 환경 설정 함수 추가
    			ComEndConfigSheet(sheetObjects[i]);
    		}
    		    	            
            for(k = 0; k < comboObjects.length; k++){
                initCombo(comboObjects[k], k + 1);
            }    		
    		
    		// period 초기 조건 설정 (5일)
    		var today = ComGetNowInfo("ymd","-");
    		sheet1 = sheetObjects[0];
    		//formObj.to_cre_dt.value = today;
    		//formObj.fr_cre_dt.value = ComGetDateAdd(today,"D",-5,"-");
    		
    		axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); //- 키 눌렸을때
    		axon_event.addListenerFormat('focus',   'obj_focus',    formObj);
    		axon_event.addListenerFormat('blur', 'obj_deactivate',  formObj);
    		
    	}

    	
     	
        function initCombo(comboObj, comboNo) {
            switch(comboObj.id) {   	 			
    	 		case "pprl_eml_rcv_cd" :	
    	            var i = 0;
    	            with (comboObj) {
    	 				DropHeight = 200;                                                                                                                                                                                                                                                                                                                                                                                                                           
    	 				MultiSelect = false;                                                                                                                                                                                                                                                                                                                                                                                                                        
    	 				MaxSelect = 1;                                                                                                                                                                                                                                                                                                                                                                                                                              
    	 				UseAutoComplete = true;  
    	                InsertItem(i++, "ALL", " ");
    	                InsertItem(i++, "User Mail", "NOR");
    	                InsertItem(i++, "DPCS Mail", "DPC");
    	                InsertItem(i++, "N-DPCS Mail", "NPC");
    	                Index = 1; //로딩시 "User Mail" 기본으로 선택함
    	            }
    	            break;
            }       	
        }
        

       	
        /**
    	 * 시트 초기설정값, 헤더 정의
    	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    	 */
    	function initSheet(sheetObj,sheetNo) {
    		
    		var cnt = 0;

    		switch(sheetNo) {
    			 case 1:      //sheet1 init
    				with (sheetObj) {
    					// 높이 설정
    					//style.height = 300 ;
    					style.height = GetSheetHeight(19) ;
    					//전체 너비 설정
    					SheetWidth = mainTable.clientWidth;
    					
    					//Host정보 설정[필수][HostIp, Port, PagePath]
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    					//전체Merge 종류 [선택, Default msNone]
    					MergeSheet = msHeaderOnly;

    				   //전체Edit 허용 여부 [선택, Default false]
    					Editable = true;

    					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo( 1, 1, 9, 100);
                
    					var HeadTitle = "Seq|Expense Type|Input Date|Invoice Date|CSR|Expense Name|INV Amount|USD Amount|Pay To|Status|Status Date";    					
 
    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);

    					// 해더에서 처리할 수 있는 각종 기능을 설정한다 ([SortEnable], [ColumnMove], [AllCheckEnable],  [UserResize], [RowMove],[Head3D]) 
    					InitHeadMode(true, true, false, true, false, false);

    				
    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle, true);

    					//데이터속성       [ROW, COL,  DATATYPE,          WIDTH,   DATAALIGN, COLMERGE, SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++, dtSeq,                80,     daCenter,  false,    "",        		false,          "",       dfNone,    0,     true,        true, 		    0,		false,		true);
    					InitDataProperty(0, cnt++, dtData,       		180,    daLeft,    true,    "expn_div_cd",     	false,          "",       dfNone,    0,     false,       false, 		0,		false,		true);    					
    					InitDataProperty(0, cnt++, dtData,       		100,    daCenter,  true,    "inp_dt",       	false,          "",       dfNone,    0,     false,       false, 		0,		false,		true);
    					InitDataProperty(0, cnt++, dtData,       		100,    daCenter,  true,    "inv_dt",         	false,          "",       dfNone,    0,     false,       false, 		0,		false,		true);
    					InitDataProperty(0, cnt++, dtData,       		150,    daLeft,    true,    "subs_csr_no",     	false,          "",       dfNone,    0,     false,       false, 		0,		false,		true);
    					InitDataProperty(0, cnt++, dtData,       		250,    daLeft,    true,    "gen_expn_nm",     	false,          "",       dfNone,    0,     false,       false, 		0,		false,		true);
    					InitDataProperty(0, cnt++, dtData,       		100,    daCenter,  false,   "inv_locl_ttl_amt", false,          "",       dfFloat,    2,    false,       false, 		0,		false,		true);
    					InitDataProperty(0, cnt++, dtData,       		100,    daCenter,  false,   "inv_usd_ttl_amt",  false,          "",       dfFloat,    2,    false,       false, 		0,		false,		true);
    					InitDataProperty(0, cnt++, dtData,       		200,    daCenter,  false,   "pay_vndr_nm",    	false,          "",       dfNone,    0,     false,       false, 		0,		false,		true);
    					InitDataProperty(0, cnt++, dtData,       		100,    daCenter,  false,   "apro_rslt_cd",   	false,          "",       dfNone,    0,     false,       false, 		0,		false,		true);
    					InitDataProperty(0, cnt++, dtData,       		100,   daCenter,   false,   "apro_dt",        	false,          "",       dfNone,    0,     false,       true, 		    0,		false,		true);    				
    					        
    			   }
    				break;
    		}
    	}


      // Sheet관련 프로세스 처리
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;

    		switch(sAction) {
    		
    		case IBSEARCH_ASYNC01:      //Open
    			formObj.f_cmd.value = SEARCH;
 				var sXml = sheetObj.GetSearchXml("CPS_GEM_0004GS.do", FormQueryString(formObj));

 				var arrXml = sXml.split("|$$|");
 				var authFlg  = "";
 				
 				// 로그인 오피스 정보 
 				if (arrXml.length > 0) {			
 					var list = ComXml2ListMap(arrXml[0]);
 					var officeLevelVo  = list[0];
 					var loginOfcCd = ComGetEtcData(arrXml[0] ,"usr_ofc_cd");
 					
 					authFlg  = officeLevelVo["auth_flg"];
 					//권한 설정
					formObj.auth_flg.value = authFlg;
					formObj.login_ofc_cd.value = loginOfcCd;
 					
 				}
 				// 권한 없는 Office 가 로그인 시 화면 닫음
 				if ( authFlg == null || authFlg == "" || authFlg == "NNNN") {
 					goNoAuthority();
 			    }

 				// 실적을 입력할 년월
 				if (arrXml.length > 0) {
 					
 					var closingDate = ComGetEtcData(arrXml[0] ,"closingDate");
 	 				
 	 			    formObj.pln_yr.value = closingDate.substring(0,4);
 	 				formObj.pln_mon.value = closingDate.substring(4,6);
 	 				
 	 				formObj.hpln_yr.value = closingDate.substring(0,4);
 	 				formObj.hpln_mon.value = closingDate.substring(4,6);
 	 				
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
	 						formObj.sls_ofc_div_cd[0].checked = true;
	 					} else {
	 						formObj.sls_ofc_div_cd[1].checked = true;
	 					}
	 					//집행단위.지역그룹
	 					if ( authFlg == "YNNN" || authFlg == "YYNN" ) {
	 						ComEnableObject(formObj.ofc_lvl1, false);
	 						ComEnableObject(formObj.ofc_lvl2, false);
	 						ComEnableObject(formObj.ofc_lvl3, false);
	 						if ( authFlg == "YYNN" ) {
	 							ComEnableObject(formObj.ofc_lvl3, true);
	 						}
	 						formObj.sls_ofc_div_cd[0].disabled=true;
	 						formObj.sls_ofc_div_cd[1].disabled=true;
	 						//LV1
	 						ComSetObjValue(formObj.ofc_lvl1,level2);					
	 						//LV2
	 						selLevelChange('GEM_COMMONGS.do','SEARCHLIST03','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');			
	 						ComSetObjValue(formObj.ofc_lvl2,level3);					
	 						//LV3
	 						selLevelChange('GEM_COMMONGS.do','SEARCHLIST04','sheet1','sls_ofc_div_cd','2','document.form.ofc_lvl');			
	 						ComSetObjValue(formObj.ofc_lvl3,level4);					
	 										
	 					//사무국 , BU ,TIC
	 					} else if ( authFlg == "YNYN" || authFlg == "YNYY" || authFlg == "YYYN") {
	 						ComEnableObject(formObj.ofc_lvl1, true);
	 						ComEnableObject(formObj.ofc_lvl2, true);
	 						ComEnableObject(formObj.ofc_lvl3, true);				
	 						formObj.sls_ofc_div_cd[0].checked = false;
	 						formObj.sls_ofc_div_cd[1].checked = false;
	 						
	 						if ( authFlg == "YNYY")
	 						{
	 							//office가 SELBPG 인경우 아래의 조건 SKIP
	 							if(formObj.login_ofc_cd.value != "SELBPG"){
	 								if ( formObj.usr_auth_tp_cd.value != USR_AUTH_TP_CD ) {
	 									authFlg = "YNYN";
	 									formObj.auth_flg.value = authFlg;
	 								} 
	 							}
	 						}
	 						
	 					} else {
	 						ComEnableObject(formObj.ofc_lvl1, false);
	 						ComEnableObject(formObj.ofc_lvl2, false);
	 						ComEnableObject(formObj.ofc_lvl3, false);		
	 						formObj.sls_ofc_div_cd[0].disabled=true;
	 						formObj.sls_ofc_div_cd[1].disabled=true;
	 					}
 					}
 				}	

 			//	formObj.pln_yr.focus();
 				break;
    		   case IBSEARCH:      //조회
    						   				
    				if(!validateForm(sheetObj,formObj,sAction)){
                        return false;
                    }  
                    	
    				sheetObj.RemoveAll();
    				
    				formObj.f_cmd.value = SEARCH;
    				//sheetObj.DoSearch4Post("COM_PPL_0001GS.do", FormQueryString(formObj));
    				var sXml = sheetObj.GetSearchXml("CPS_GEM_0035GS.do", FormQueryString(formObj));
    				sheetObj.LoadSearchXml(sXml);
    				
    				break;			

    		   case IBDOWNEXCEL:        //엑셀 다운로드
    				//sheetObj.Down2Excel(-1, false, false, true);    			
    				//sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false);
    			    // 2014.12.04 신 로직
    			   sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "12");
    			   //sheetObj.Down2Text("Header", "\t", "1|2|3|4|5|6|7|8|9|10|11|13|14", "AllData.txt");

    				break;
    				
    		   case SEARCHLIST20:      // 조회
    				
    				formObj.f_cmd.value = SEARCH;
    				
    				var sXml = sheetObj.GetSearchXml("GEM_COMMONGS.do", FormQueryString(formObj));
    				
    				// LEVEL2 조회
    				var comboListData = ComGetEtcData(sXml, "searchBUOfficeList").split("|");
    				
    				if (typeof comboListData != "undefined" && comboListData != "") {
    					
    					var ofcLvl = formObj.ofc_lvl1;
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
    	function validateForm(sheetObj,formObj,sAction){
    		var formObj = document.form;
    		
    		if(sAction == IBSEARCH) {
    			
    		    if (ComGetObjValue(formObj.gen_expn_rqst_tp_cd) == "C")	{
    		    	if (formObj.csr_no.value == ''){
    		    		ComShowCodeMessage("GEM01098");
    		    		formObj.csr_no.focus();
    		    		return false;
    		    	}
    	  	    }else {
    	  	    	if (formObj.period_stdt.value == '' || formObj.period_eddt.value == ''){
    	  	    		ComShowCodeMessage("GEM01077");
    	  	    		formObj.period_stdt.focus();
    	  	    		return false;
    	  	    	}
    	        }   			
    		}
    		
    		return true;
    	}

      //Axon 이벤트 처리2. 이벤트처리함수
    	function obj_focus(){
    		var formObj = document.form;
    		var obj = event.srcElement;
    		
    	    if (event.srcElement.name == "period_stdt"){		
    	    	ComClearSeparator(formObj.period_stdt, "ymd");
    	    	ComSetFocus(formObj.period_stdt);
    	    }else if(event.srcElement.name == "period_eddt"){		
    	    	ComClearSeparator(formObj.period_eddt, "ymd");
    	    	ComSetFocus(formObj.period_eddt);
    	    }
    	}
    	
       	/**
       	 * Key-Down Event 처리
    	 */
       	function obj_deactivate() {
       		var obj      = event.srcElement;
       		var formObj  = document.form;       		
       			switch(obj.name) {
      		     case "period_stdt": 
       				ComAddSeparator(formObj.period_stdt, "ymd");
       			   break;
      		   case "period_eddt": 
      				ComAddSeparator(formObj.period_eddt, "ymd");
      			   break;
         		}
       	}
       	
       	
    	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
//    		for(var i=1; i<sheetObj.Rows; i++) {
//    			if(sheetObj.CellValue(i,"org_file_nm") != "") {
//    				sheetObj.CellValue2(i, "atch_file_yn") = "O";    //첨부파일이 있으면 셀에 "O" 표시			    				
//    			}
//    			else {
//    				sheetObj.CellValue2(i, "atch_file_yn") = "X";    //첨부파일이 있으면 셀에 "X" 표시		
//    			}
//    			
//    			//Content에 메모 이미지 표시
//    			sheetObj.CellImage(i, "pprl_eml_ctnt") = 0; 			
//    		}
    	}
    	
    	/**
    	 * sheet1 클릭 이벤트 <br>
    	 * @param {ibsheet} sheet    	IBSheet Object
    	 * @param {ibsheet} row     	sheet 선택된 row
    	 * @param {ibsheet} col     	sheet 선택된 col
    	 * @param {String} 	value     	파일명
    	 **/
    	function sheet1_OnClick(sheetObj,row,col,value){

    	    switch (sheetObj.ColSaveName(col)) {
//	            case "pprl_eml_ctnt":
//	            	//content 클릭시 메모장 오픈
//	                sheetObj.CellEditable(row, col) = false;
//	                ComShowMemoPad(sheetObj, row, col, true, 300, 250);
//	                break;
//	                
//	            case "atch_file_yn" :	        		
//	        		if(sheetObj.CellText(row, "org_file_nm") == "") {
//	        			return;
//	        		}
//	        		else {
//	            		//var frm1 = document.form1;
//	            		//frm1.action = "/hanjin/FileDownload?key="+sheet.CellText(row, "org_file_nm");
//	            		//frm1.submit();	        			
//	        			
//	        			if(sheetObj.CellValue(row, "pprl_eml_rcv_cd") == "NOR") {	        				
//	        				location.href = "/hanjin/FileDownload?key="+sheetObj.CellValue(row, "org_file_nm"); //"NOR" 시 file key 로 다운로드
//	        			}
//	        			else {	        				
//	        				location.href = "/hanjin/FileDownload?downloadLocation="+sheetObj.CellValue(row, "atch_file_path_ctnt") + "&downloadFileName=" + sheetObj.CellValue(row, "org_file_nm"); //"DPC" 시  file 경로로 다운로드
//	        			}
//	        			
//	            		return;	        			
//	        		}
//	        		
//	            	break;
    	    }

    	} 
    	
    	
    	function sheet1_OnLoadFinish(sheetObj) {
    	    // 초기Data조회
    		var formObject = document.form;
    		doActionIBSheet(sheetObj,formObject,SEARCHLIST20);
    		doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC01);
    		
     	}
 
        /**
         * HO, HQ 체크 박스 설정 
         * @param {value} 선택된 체크 박스구분
         */
         function setHOHQ01(value) {
        	 var frm = document.form;
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
         
         
   	function onChagnetypeCd(){
   		var formObj  = document.form;
   		
  	    if (ComGetObjValue(formObj.gen_expn_rqst_tp_cd) == "C")	{
  	    	formObj.period_stdt.value = "";
    		formObj.period_eddt.value = "";
    		formObj.csr_no.value = ""; 
    		formObj.period_stdt.disabled = true;
    		formObj.period_eddt.disabled = true;
    		formObj.csr_no.disabled = false; 
    		ComEnableObject(formObj.btns_calendar2,  false);
    		formObj.period_stdt.className  = "input";
    		formObj.period_eddt.className  = "input";
         }else {
        	formObj.period_stdt.value = "";
     		formObj.period_eddt.value = "";
     		formObj.csr_no.value = "";  
  			formObj.period_stdt.disabled = false;
      		formObj.period_eddt.disabled = false;
       		formObj.csr_no.disabled = true;   
       		ComEnableObject(formObj.btns_calendar2,  true);
       		formObj.period_stdt.className  = "input1";
    		formObj.period_eddt.className  = "input1";
        }
           		
     }
   	
   	// dblick 
   	function sheet1_OnDblClick(sheet, row, col) {
   		var csrNo = sheet.CellValue(row , "subs_csr_no");
   		document.form.action = "/hanjin/CPS_GEM_0033.do?subs_csr_no="+csrNo;
   		document.form.target = "_self";
   		document.form.method = "post";
   		document.form.submit();
   	}
	/* 개발자 작업  끝 */