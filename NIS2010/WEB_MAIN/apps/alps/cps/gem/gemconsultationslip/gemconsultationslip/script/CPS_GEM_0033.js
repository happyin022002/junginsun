/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CPS_GEM_0033.js
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
    function CPS_GEM_0033() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.obj_keypress           = obj_keypress;
		this.obj_keyup              = obj_keyup;
		this.obj_keydown            = obj_keydown;
		this.aciveFlg 	            = aciveFlg;
    }
    
   	/* 개발자 작업	*/

 // 공통전역변수
    var sheetObjects = new Array();
    var comboObjects = new Array();
    var sheetCnt = 0;
    var comboCnt = 0;
    var saveFlag ="";
    var new_csr_no = "";
    var resultCd = "";
    var reqWin = null;
    
    //sheetResizeFull = true;
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    	function processButtonClick(){
    		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

    		 var sheetObject = sheetObjects[0];
             var comboObject = comboObjects[0];
    		 /*******************************************************/
    		 var formObject = document.form;

//    		try {
    		    var srcObj  = window.event.srcElement;
    			var srcName = window.event.srcElement.getAttribute("name");

    			switch(srcName) {

                	case "btn_new": 
                		if(sheetObject.RowCount > 0 ){
                   			if (ComShowCodeConfirm("GEM00011")) {
                   				sheetObject.RemoveAll();
                   				comboObject.RemoveAll();
                			}
                		}
                		ComResetAll();
                		formObject.inv_dt.disabled = false;
                		formObject.pay_vndr_nm.disabled = false;
                		formObject.pay_vndr_nm.disabled = false;
                		formObject.inv_locl_ttl_amt.disabled = false;
                		formObject.expn_div_cd[0].disabled =false;
                		formObject.expn_div_cd[1].disabled =false;
                		formObject.expn_div_cd[2].disabled =false;
                		formObject.expn_div_cd[3].disabled =false;
                		comboObjects[0].enable = true;
            	        var today = ComGetNowInfo("ymd","-");
        		        formObject.inp_dt.value = today;
        		        sheetObject.Editable = true;
        	    		doActionIBSheet(sheetObject, formObject,IBSEARCH);
                		doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC01);
                		doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC02);
                		onChagnetypeCd();
                		ComEnableObject(formObject.btns_calendar1,  true);
                		ComBtnEnable("btn_gw");
	  					ComBtnEnable("btn_save");
	  					ComBtnEnable("btn_cancel");
	  					ComBtnEnable("Row_Add");
	  					ComBtnEnable("Delete");
                		break;
                	case "btn_save" :
                		doActionIBSheet(sheetObject,formObject,IBSAVE);
                		break;
                		
    				case "btn_gw":
    					doActionIBSheet(sheetObject, formObject , IBSEARCH_ASYNC04);
    					break;

    				case "btn_downexcel":
    					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    				break;
    				case "Row_Add":
    					if (sheetObject.RowCount < 10 ){
    					    var row = sheetObject.DataInsert();
    					}else {
    						ComShowCodeMessage("GEM01100");	
    					}
    				break;
    				case "Delete":
    					 sheetObject.RowDelete();
    				break;
    				case "btns_calendar1": //달력버튼
    					if ( srcObj.style.filter == "" ) {
                			var cal = new ComCalendar();
    						cal.select(formObject.inv_dt, 'yyyy-MM-dd');
    					}
    	         	break;
    				case "btns_popup":
    				// CSR No 조회 팝업 오픈	
    					var url = "CPS_GEM_0036.do";
    					var winName = "CPS_GEM_0036";
    					if (reqWin != null) {
    						reqWin.close();
    					}
    					reqWin = ComOpenWindowCenter("about:blank",winName,800,430, false);
    			
    					formObject.action = url;        
    					formObject.target = winName;
    					formObject.submit();
    					formObject.target = "";	    
    				break;
    				case "btn_cancel": //Cancel 버튼
    					doActionIBSheet(sheetObject, formObject , IBSEARCH_ASYNC07);          	 
	         	    break; 
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
    		formObj.inp_dt.value = today;
     		formObj.inp_dt.disabled = true;
    		formObj.apro_dt.disabled = true;
    		formObj.subs_csr_no.disabled = true;
    		formObj.apro_rslt_cd.disabled = true;
    		formObj.inv_usd_ttl_amt.disabled = true;
    		ComBtnDisable("btn_gw");
    		
    		
    		axon_event.addListenerForm  ('keydown',		'obj_keydown',	formObj); //- 키 눌렸을때
    		axon_event.addListenerFormat('keyup',	'obj_keyup',	formObj);   //- 키 눌렸을때
    		axon_event.addListenerForm('blur', 'obj_deactivate',  formObj);
    		axon_event.addListenerFormat('keypress','obj_keypress',	formObj);
    		axon_event.addListenerFormat('focus',   'obj_focus',    formObj);   //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    			 
     	}

        function initCombo(comboObj, comboNo) {
            switch(comboObj.id) {   	 			
    	 		case "inv_curr_cd" :	
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
    					MergeSheet = msNone;

    				   //전체Edit 허용 여부 [선택, Default false]
    					Editable = true;

    					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo( 1, 1, 9, 100);
    					
                        var HeadTitle = "|Expense Name|INV Amount(LCL)|INV Amount(USD)|Description|Expense code|Expense|csr_no";    					
 
    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);

    					// 해더에서 처리할 수 있는 각종 기능을 설정한다 ([SortEnable], [ColumnMove], [AllCheckEnable],  [UserResize], [RowMove],[Head3D]) 
    					InitHeadMode(true, true, true, true, false,false);

    				//	var HeadTitle = "|Expense Name|INV Amount(LCL)|INV Amount(USD)|Desription|";    					

    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle, true);

    					//데이터속성    [ ROW, COL,  DATATYPE,            WIDTH, DATAALIGN, COLMERGE, SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++, dtHiddenStatus,       80,    daCenter,   true,    "ibflag",        false,       "",       dfNone,      0,         true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtComboEdit,   	    300,    daCenter,  true,    "gen_expn",    false,       "",       dfNone,         0,         true,       true, 		100,	false,		true);    					
    					InitDataProperty(0, cnt++, dtData,       		150,    daCenter,  true,    "inv_locl_amt",   false,       "",       dfFloat,     2,         true,       true, 		12,		false,		true);
    					InitDataProperty(0, cnt++, dtData,       		150,    daCenter,  true,    "inv_usd_amt",    false,       "",       dfFloat,     2,         false,      false, 	12,		false,		true);
    					InitDataProperty(0, cnt++, dtData,       		300,    daLeft,    true,    "inv_slp_desc",   false,       "",       dfNone,      0,         true,       true, 		300,	false,		true);
    					InitDataProperty(0, cnt++, dtHidden,       		300,    daLeft,    true,    "gen_expn_cd",    false,       "",       dfNone,      0,         true,       true, 		0,		false,		true);
    					InitDataProperty(0, cnt++, dtHidden,   	        250,    daCenter,  true,    "gen_expn_nm",    false,       "",       dfNone,      0,         true,       true, 		100,	false,		true);
    					InitDataProperty(0, cnt++, dtHidden,       		300,    daLeft,    true,    "subs_csr_no",    false,       "",       dfNone,      0,         true,       true, 		0,		false,		true);
    				    
    			   }
    				break;
    		}
    	}


      // Sheet관련 프로세스 처리
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;

    		switch(sAction) {

    		case IBSEARCH:      //Open

    			formObj.f_cmd.value = SEARCH;
 				var sXml = sheetObj.GetSearchXml("CPS_GEM_0033GS.do", FormQueryString(formObj));

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
					formObj.subs_ofc_cd.value = loginOfcCd;
 					
 				}
 				// 권한 없는 Office 가 로그인 시 화면 닫음
 				if ( authFlg == null || authFlg == "" || authFlg == "NNNN") {
 					goNoAuthority();
 			    }

 				// 실적을 입력할 년월
 				if (arrXml.length > 0) {
 					
 					var closingDate = ComGetEtcData(arrXml[0] ,"closingDate");
 	 				
// 	 				formObj.pln_yr.value = closingDate.substring(0,4);
// 	 				formObj.pln_mon.value = closingDate.substring(4,6);
 	 				
 	 				formObj.hpln_yr.value = closingDate.substring(0,4);
 	 				formObj.hpln_mon.value = closingDate.substring(4,6);
 	 				
 				}		

 				// 로그인 사용자 오피스 정보
 				if (arrXml.length > 1) {

 					var list = ComXml2ListMap(arrXml[1]);

// 					if(list.length > 0){
//	 					var officeHierarchyVO  = list[0];
//	 					var level1   = officeHierarchyVO["level1"];
//	 					var level2   = officeHierarchyVO["level2"];
//	 					var level3   = officeHierarchyVO["level3"];
//	 					var level4   = officeHierarchyVO["level4"];
//	 					var rgnOfcFlg  = officeHierarchyVO["rgn_ofc_flg"];
//	 					if ("N" == rgnOfcFlg) {
//	 						formObj.sls_ofc_div_cd[0].checked = true;
//	 					} else {
//	 						formObj.sls_ofc_div_cd[1].checked = true;
//	 					}
//	 					//집행단위.지역그룹
//	 					if ( authFlg == "YNNN" || authFlg == "YYNN" ) {
//	 						ComEnableObject(formObj.ofc_lvl1, false);
//	 						ComEnableObject(formObj.ofc_lvl2, false);
//	 						ComEnableObject(formObj.ofc_lvl3, false);
//	 						if ( authFlg == "YYNN" ) {
//	 							ComEnableObject(formObj.ofc_lvl3, true);
//	 						}
//	 						formObj.sls_ofc_div_cd[0].disabled=true;
//	 						formObj.sls_ofc_div_cd[1].disabled=true;
//	 						//LV1
//	 						ComSetObjValue(formObj.ofc_lvl1,level2);					
//	 						//LV2
//	 						selLevelChange('GEM_COMMONGS.do','SEARCHLIST03','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');			
//	 						ComSetObjValue(formObj.ofc_lvl2,level3);					
//	 						//LV3
//	 						selLevelChange('GEM_COMMONGS.do','SEARCHLIST04','sheet1','sls_ofc_div_cd','2','document.form.ofc_lvl');			
//	 						ComSetObjValue(formObj.ofc_lvl3,level4);					
//	 										
//	 					//사무국 , BU ,TIC
//	 					} else if ( authFlg == "YNYN" || authFlg == "YNYY" || authFlg == "YYYN") {
//	 						ComEnableObject(formObj.ofc_lvl1, true);
//	 						ComEnableObject(formObj.ofc_lvl2, true);
//	 						ComEnableObject(formObj.ofc_lvl3, true);				
//	 						formObj.sls_ofc_div_cd[0].checked = false;
//	 						formObj.sls_ofc_div_cd[1].checked = false;
//	 						
//	 						if ( authFlg == "YNYY")
//	 						{
//	 							if ( formObj.usr_auth_tp_cd.value != USR_AUTH_TP_CD ) {
//	 								authFlg = "YNYN";
//	 								formObj.auth_flg.value = authFlg;
//	 							} 							
//	 						}
//	 						
//	 					} else {
//	 						ComEnableObject(formObj.ofc_lvl1, false);
//	 						ComEnableObject(formObj.ofc_lvl2, false);
//	 						ComEnableObject(formObj.ofc_lvl3, false);		
//	 						formObj.sls_ofc_div_cd[0].disabled=true;
//	 						formObj.sls_ofc_div_cd[1].disabled=true;
//	 					}
// 					}
 				}	

 				formObj.inv_dt.focus();
 				break;
    		  case IBSEARCH_ASYNC03:        //Detail 정보 조회
  	 			formObj.f_cmd.value = SEARCH03;
  				var sXml = sheetObj.GetSearchXml("CPS_GEM_0033GS.do", FormQueryString(formObj));
 				var arrXml = sXml.split("|$$|");
	  			if (arrXml.length > 0) {
    				sheetObj.LoadSearchXml(sXml);
	  			}
  		      break;	
    		  case IBSAVE:        //저장
    	 			if(!validateForm(sheetObj,formObj,sAction)) return;
    	 			if (ComShowCodeConfirm("GEM00012")) {
               		var sParam = "";
               	    var sheetObject = sheetObjects[0];
               		var sParamSheet1 = sheetObject.GetSaveString(true);
             	     formObj.f_cmd.value = MULTI;
    	 			 sParam += FormQueryString(formObj) + "&" + sParamSheet1;
    				var sXml = sheetObj.GetSaveXml("CPS_GEM_0033GS.do", sParam);
    		        saveFlag = ComGemGetXMLData(sXml, "TR-ALL");
    		        new_csr_no = ComGetEtcData(sXml, "new_csr_no");
    		        resultCd = ComGetEtcData(sXml, "status");
    		        sheetObj.LoadSaveXml(sXml);
    	 			}
    		   break;
    			case IBSEARCH_ASYNC01:      //currecy 조회
    				var vOfccd  = formObj.ofc_cd.value;
    				var vinputDt = formObj.inv_dt.value;
    				var vCombo1 = ComGetObjValue(comboObjects[0]);
    				if(vOfccd != null && vOfccd != "" && vinputDt != null){
    					formObj.f_cmd.value = SEARCH01;
    					sheetObj.WaitImageVisible = false;
    					var sXml = sheetObj.GetSearchXml("CPS_GEM_0033GS.do", FormQueryString(formObj));
    					sheetObj.WaitImageVisible = true;
    					
    					if ( sXml != "" ) {
    						ComXml2ComboItem(sXml, comboObjects[0], "locl_curr_cd", "locl_curr_cd");
    			
    						formObj.usd_locl_xch_rt.value = ComGetEtcData(sXml, "usd_locl_xch_rt");
    						formObj.inv_locl_ttl_amt.value ="";
    						formObj.inv_usd_ttl_amt.value ="";
    						comboObjects[0].Code = ComGetEtcData(sXml, "locl_curr_cd");    					}
    				}
    				break;
    				
    			case IBSEARCH_ASYNC02:      //expense cd list 조회
    					formObj.f_cmd.value = SEARCH02;
    					sheetObj.WaitImageVisible = false;
    					var sXml = sheetObj.GetSearchXml("CPS_GEM_0033GS.do", FormQueryString(formObj));
    					sheetObj.WaitImageVisible = true;
    					if ( sXml != "" ) {
    						var xmlCnt    = ComGetEtcData(sXml, "total_count");
    						var expense_cd = "";
    						var expense_nm = "";
    				        var combocode = "";
    						for(var i = 0 ; i < Number(xmlCnt) ; i++ ){
    							expense_cd = expense_cd + " |" + ComGetEtcData(sXml, "subs_expn_cd"+ i);
    							expense_nm = expense_nm + " |" + ComGetEtcData(sXml, "subs_expn_nm"+ i);
    							
    					 	}
    						
    				        sheetObj.InitDataCombo(0, "gen_expn",expense_nm, expense_cd,"","",0);
    					}
    				break;
    			case IBSEARCH_ASYNC04:	//결재 요청(GW)
	    			formObj.f_cmd.value = MULTI01;
	    	
	    			var sXml = sheetObj.GetSearchXml("CPS_GEM_0033GS.do", FormQueryString(formObj),"",true);
	    			
	    			var gwUrl = ComGetEtcData(sXml , "GW_URL");
	    			
	    			if (ComIsNull(gwUrl)) {
	    				ComShowMessage(ComGetMsg('CSR25006'));
	    				return;
	    			}
	    			
	    			ComOpenPopup(gwUrl, 900, 780, "", "1,0,1,1,1", true);
	    			sys_result();
	    			
	    			break;	
    			case IBSEARCH_ASYNC05:	//결재 요청 후 결과 값 조회 
    				formObj.f_cmd.value = SEARCH04;
      				var sXml = sheetObj.GetSearchXml("CPS_GEM_0033GS.do", FormQueryString(formObj));
     				var arrXml = sXml.split("|$$|");
     				var saveflag = ComGetEtcData(sXml, "GW_Result");
     				if(saveflag == "P"){
     					formObj.apro_rslt_cd.value ="Submitted";
     					aciveFlg();
    	  				sheetObj.Editable = false;
     				}else if (saveflag == "N"){
     					formObj.apro_rslt_cd.value ="Rejected";
     					aciveFlg();
    	  				sheetObj.Editable = false;
     				}else if (saveflag == "Y"){
     					formObj.apro_rslt_cd.value ="Approved";
     					aciveFlg();
    	  				sheetObj.Editable = false;
     				}
    	  			
    	  			break;	
    			case IBSEARCH_ASYNC06:	//HDR 정보 조회
    				formObj.f_cmd.value = SEARCH06;
    				var sXml = sheetObj.GetSearchXml("CPS_GEM_0033GS.do", FormQueryString(formObj));
     				var arrXml = sXml.split("|$$|");
    	  			if (arrXml.length > 0) {
    	  				ComSetObjValue(formObj.inp_dt , ComGetEtcData(arrXml, "inp_dt"));
    	  				ComSetObjValue(formObj.inv_dt , ComGetEtcData(arrXml, "inv_dt"));
    	  				ComSetObjValue(formObj.apro_dt , ComGetEtcData(arrXml, "apro_dt"));
    	  				ComSetObjValue(formObj.expn_div_cd , ComGetEtcData(arrXml, "expn_div_cd"));
    	  				ComSetObjValue(formObj.inv_curr_cd , ComGetEtcData(arrXml, "inv_curr_cd"));
    	  				ComSetObjValue(formObj.inv_locl_ttl_amt , ComGetEtcData(arrXml, "inv_locl_ttl_amt"));
    	  				ComSetObjValue(formObj.inv_usd_ttl_amt , ComGetEtcData(arrXml, "inv_usd_ttl_amt"));
    	  				ComSetObjValue(formObj.apro_rslt_cd , ComGetEtcData(arrXml, "apro_rslt_cd"));
    	  				ComSetObjValue(formObj.pay_vndr_nm , ComGetEtcData(arrXml, "pay_vndr_nm"));
    	  				aciveFlg();
    	  			}
    	  			break;
    			case IBSEARCH_ASYNC07:	//Cancel 시행
    				if(!validateForm(sheetObj,formObj,sAction)) return;
    	 				if (ComShowCodeConfirm("GEM00016")) {
    	 					var csr_no = formObj.subs_csr_no.value;
    	 					formObj.f_cmd.value = MULTI02;
    	 					var sXml = sheetObj.GetSaveXml("CPS_GEM_0033GS.do", FormQueryString(formObj));
    	 					saveFlag = ComGemGetXMLData(sXml, "TR-ALL");
    	 					//sheetObj.LoadSaveXml(sXml);
    	 					initReset(csr_no);
    	 			}
    	  			break;
    		}
    	}	
      	
    	
       /**
    	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    	 */
    	function validateForm(sheetObj,formObj,sAction){
    		var formObj = document.form;
       		if(sAction == IBSAVE){
    			if(formObj.inv_dt.value ==""){
    				ComShowCodeMessage("GEM00009","Invoice Date");
    	    		formObj.inv_dt.focus();
	  	    		return false;
    			}
    			
    			if(formObj.pay_vndr_nm.value ==""){
    				ComShowCodeMessage("GEM00009","Pay To");
    				formObj.pay_vndr_nm.focus();
	  	    		return false;
    			}
    		
    			if(ComGetObjValue(formObj.inv_curr_cd) ==""){
    				ComShowCodeMessage("GEM00009","INV Currency");
    	    		formObj.inv_curr_cd.focus();
	  	    		return false;
    			}
    			
    			if(formObj.inv_locl_ttl_amt.value ==""){
    				ComShowCodeMessage("GEM00009","INV Amount");
    				formObj.inv_locl_ttl_amt.focus();
	  	    		return false;
    			}
    			

    			var start_dt = formObj.inp_dt.value.split("-");
    			var end_dt = formObj.inv_dt.value.split("-");
    			start_dt[1] = (Number(start_dt[1]) - 1) + "";
    			end_dt[1] = (Number(end_dt[1]) - 1) + "";
    			var from_dt = new Date(start_dt[0], start_dt[1], start_dt[2]);
    			var to_dt = new Date(end_dt[0], end_dt[1], end_dt[2]);
    			
    			if (from_dt.getTime() < to_dt.getTime()) {
    				ComShowCodeMessage("GEM01099");
    				formObj.inv_dt.value ="";
    	    		formObj.inv_dt.focus();
    				return false;
    			}
    		
    			var rowCount = sheetObj.RowCount;
    			if(rowCount < 1){
    				ComShowCodeMessage("GEM01056");
    				return false;
    			}
    			var localAmt = 0;
    			var usdAmt = 0;
    			for(var i=0; i< rowCount; i++){
    				localAmt = Number(localAmt) +  Number(sheetObj.CellValue(i+1,"inv_locl_amt"));
    				usdAmt   = Number(usdAmt) +  Number(sheetObj.CellValue(i+1, "inv_usd_amt"));
    			}
    			
    			if( formObj.inv_locl_ttl_amt.value !=  ComAddComma(localAmt.toFixed(2))){
    				ComShowCodeMessage("GEM01097");
    				formObj.inv_locl_ttl_amt.value = "";
    				formObj.inv_usd_ttl_amt.value = "";
    				formObj.inv_locl_ttl_amt.focus()
    				return false;
    			}
    		} else if(sAction == IBSEARCH_ASYNC07){
    			if(formObj.apro_rslt_cd.value !="Saved"){
    				ComShowCodeMessage("GEM01102");
    	    		formObj.inv_dt.focus();
	  	    		return false;
    			}
    		}
    		
    		return true;
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
	            case "pprl_eml_ctnt":
	                 break;
    	    }

    	}
   
    	
    	function sheet1_OnLoadFinish(sheetObj) {
    	    // 초기Data조회
    		var formObject = document.form;
    		doActionIBSheet(sheetObj, formObject,IBSEARCH);
    		doActionIBSheet(sheetObj, formObject, IBSEARCH_ASYNC01);
    		doActionIBSheet(sheetObj, formObject, IBSEARCH_ASYNC02);
    		if (ComGetObjValue(formObject.csrNo) != ""){
    			setCsrNo(ComGetObjValue(formObject.csrNo));
    		}
     	}
    	
    	
    	/**
    	 * sheet1 클릭 이벤트 <br>
    	 * @param {ibsheet} sheet    	IBSheet Object
    	 * @param {ibsheet} row     	sheet 선택된 row
    	 * @param {ibsheet} col     	sheet 선택된 col
    	 * @param {String} 	value     	파일명
    	 **/
    	function sheet1_OnChange(sheetObj,row,col,value){
    		var formObj  = document.form;
    	    switch (sheetObj.ColSaveName(col)) {
	            case "inv_locl_amt":
	            	var lclamt = sheetObj.CellValue(row,"inv_locl_amt");
	            	if(ComGetObjValue(formObj.inv_curr_cd) != "USD"){
	            		sheetObj.CellValue2(row, "inv_usd_amt") = ComAddComma(getCsrUsdAmt(sheetObj.CellValue(row,"inv_locl_amt") , "1" , formObj.usd_locl_xch_rt.value));
	            		sheetObj.CellValue2(row,"inv_locl_amt")= ComAddComma(lclamt);
	            	}else {
	            	    sheetObj.CellValue2(row, "inv_usd_amt") = ComAddComma(getCsrUsdAmt(sheetObj.CellValue(row,"inv_locl_amt") , "1" , "1"));
	 	                sheetObj.CellValue2(row,"inv_locl_amt")= ComAddComma(lclamt);	
	            	}
	            break;
	            case "gen_expn":
	            	formObj.f_cmd.value = SEARCH05;
    				formObj.expense_text.value = sheetObj.CellText(row,"gen_expn");
    				sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("CPS_GEM_0033GS.do", FormQueryString(formObj));
					sheetObj.WaitImageVisible = true;
					if ( sXml != "" ) {
						var xmlCnt    = ComGetEtcData(sXml, "total_count");
						if (xmlCnt < 1){
							ComShowCodeMessage("GEM01101");
			                sheetObj.CellText(row,"gen_expn") = "";
						}else {
							var expnCd = sheetObj.CellValue(row,"gen_expn");
			            	var expnNm = sheetObj.CellText(row,"gen_expn");
			                sheetObj.CellValue2(row, "gen_expn_cd") = expnCd;
			                sheetObj.Cellvalue2(row, "gen_expn_nm") = expnNm;
						}
					}
					formObj.expense_text.value = "";
	            	
	            break;
    	    }

    	}
   
    	 
     function obj_keyup() {
		var obj      = event.srcElement;
		var vKeyCode = event.keyCode;
		var formObj  = document.form;

		switch (obj.name) {
//			case "inv_dt":
//				if (formObj.inv_dt.value.length == 10) {
//					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
//				}
//            break;
    	}
   }
   
     
 	/**
 	 * HTML Control의 Key-Press Event 처리한다.
 	 */
   	function obj_keypress() {
 		var obj = event.srcElement;

 		switch(obj.dataformat) {
 	        case "ymd":
 	        	if(obj.name=="inv_dt") ComKeyOnlyNumber('int', "-");
	        	break;
 	        case "ym":
 	        case "hms":
 	        case "hm":
 	        case "jumin":
 	        case "saupja":
 	        case "int":
 	            ComKeyOnlyNumber(obj);
 	            break;
 	        case "float":
 	            ComKeyOnlyNumber(obj, "-.");
 	            break;
 	        case "eng":
 	        	if ( obj.name == "lse_ctrt_no" ) {
 	        		ComKeyOnlyAlphabet("num","45|95");
 	        	//} else if ( obj.name == "ref_no" ) {
 	        	//	ComDebug(event.keyCode);
 	        	//	ComKeyOnlyAlphabet("num","8|32|44|45|46|95");
 	        	} else {
 	        		ComKeyOnlyAlphabet();
 	        	}
 	            break;
 	        case "engup":
 	            ComKeyOnlyAlphabet('upper');
 	            break;
 	        case "engdn":
 	            ComKeyOnlyAlphabet('lower');
 	            break;
 	     
 	    }
   	}

  	/**
	 * Key-Down Event 처리
	 */
   	function obj_keydown() {
   		var obj      = event.srcElement;
   		var vKeyCode = event.keyCode;
   		var formObj  = document.form;       		
   			switch(obj.name) {
//   		       case "inv_dt":
//					if (formObj.inv_dt.value.length == 10) {
//						doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
//					}
//	           break;
//			   case "inv_locl_ttl_amt": 
//				   if(formObj.inv_locl_ttl_amt.value.length > 0){
//					 var tempValue = formObj.inv_locl_ttl_amt.value;
//					  if(ComGetObjValue(formObj.inv_curr_cd) != "USD"){
//						formObj.inv_usd_ttl_amt.value = ComAddComma(getCsrUsdAmt(formObj.inv_locl_ttl_amt.value , "1" , formObj.usd_locl_xch_rt.value));
//					  }else {
//						formObj.inv_usd_ttl_amt.value = ComAddComma(getCsrUsdAmt(formObj.inv_locl_ttl_amt.value , "1" , "1"));  
//					  }
//					formObj.inv_locl_ttl_amt.value = ComAddComma(tempValue);
//				   }
//	           break;
			}
   	}
   	
   	
   	/**
	 * Key-Down Event 처리
	 */
   	function obj_deactivate() {
   		var obj      = event.srcElement;
   		var formObj  = document.form;       		
   			switch(obj.name) {
//   			   case "inv_dt":
//   					if (formObj.inv_dt.value.length == 8 || formObj.inv_dt.value.length == 10 ) {
//   					    ComChkObjValid(obj);
//   						doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
//   					}
//   	           break;
   			   case "inv_locl_ttl_amt": 
   				   if(formObj.inv_locl_ttl_amt.value.length > 0){
   					 var tempValue = formObj.inv_locl_ttl_amt.value;
   					  if(ComGetObjValue(formObj.inv_curr_cd) != "USD"){
   						formObj.inv_usd_ttl_amt.value = ComAddComma(getCsrUsdAmt(formObj.inv_locl_ttl_amt.value , "1" , formObj.usd_locl_xch_rt.value));
   					  }else {
   						formObj.inv_usd_ttl_amt.value = ComAddComma(getCsrUsdAmt(formObj.inv_locl_ttl_amt.value , "1" , "1"));  
   					  }
   					  if (tempValue.indexOf(".") < 0 ) {
   						formObj.inv_locl_ttl_amt.value = ComAddComma(tempValue) +".00";  
   					  }else {
   						formObj.inv_locl_ttl_amt.value = ComAddComma(tempValue);
   	   				  }
   				   }
   			   break;
   			   case "inv_dt": 
   				ComAddSeparator(formObj.inv_dt, "ymd");
   			   break;
     		}
   	}
   	
  //Axon 이벤트 처리2. 이벤트처리함수
   	
	function obj_focus(){
		var formObj = document.form;
		var obj = event.srcElement;
		
	    if (event.srcElement.name == "inv_dt"){		
	    	ComClearSeparator(formObj.inv_dt, "ymd");
	    	ComSetFocus(formObj.inv_dt);
	    } 
	}
	
   	/**
   	* combo item change 부분<br>
   	* @param type
   	* @param object 대상 Object
   	* @param Row 대상Object가 IBSheet일 경우 해당 Row index
   	*/
   	function inv_curr_cd_OnChange(comboObj,value,text){
   		var formObj  = document.form;
   		formObj.inv_usd_ttl_amt.value ="";
   		formObj.inv_locl_ttl_amt.value ="";
   		onChangeCurreny();
   	}
   	
   	
   	function onChagnetypeCd(){
   		var formObj  = document.form;
   		var sheetObject = sheetObjects[0];
   		if(formObj.apro_rslt_cd.value != "Deleted") {
   			if(sheetObject.RowCount > 0 ){
   				if (ComShowCodeConfirm("GEM00011")) {
   					sheetObject.RemoveAll();
   					var today = ComGetNowInfo("ymd","-");
   					formObj.inp_dt.value = today;
   					if (formObj.apro_rslt_cd.value == "Saved"){
   						ComBtnEnable("btn_gw");	
   					}else {
   						ComBtnDisable("btn_gw");
   					}
   				}
   			}
   		}
   		doActionIBSheet(sheetObject, formObj, IBSEARCH_ASYNC02);
   	}
   	
   	/**
     * 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;

    	if(!/Error/.test(ErrMsg)) {
       		ComShowCodeMessage("GEM00008");
       		formObj.subs_csr_no.value = new_csr_no; 
	        formObj.apro_rslt_cd.value = resultCd;
    		doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC03);
    		ComBtnEnable("btn_gw");
    	}
    }
    
    
    function onChangeCurreny(){
    	var formObj  = document.form;
   		var sheetObject = sheetObjects[0];    	
   		if (sheetObject.RowCount > 0){
   			for (i=1 ; i< sheetObject.RowCount+1 ; i++){
   				var lclamt = sheetObject.CellValue(i,"inv_locl_amt");
   		    	if(ComGetObjValue(formObj.inv_curr_cd) != "USD"){
   		    		sheetObject.CellValue2(i, "inv_usd_amt") = ComAddComma(getCsrUsdAmt(sheetObject.CellValue(i,"inv_locl_amt") , "1" , formObj.usd_locl_xch_rt.value));
   		    		sheetObject.CellValue2(i,"inv_locl_amt")= ComAddComma(lclamt);
   		    	}else {
   		    		sheetObject.CellValue2(i, "inv_usd_amt") = ComAddComma(getCsrUsdAmt(sheetObject.CellValue(i,"inv_locl_amt") , "1" , "1"));
   		    		sheetObject.CellValue2(i,"inv_locl_amt")= ComAddComma(lclamt);	
   		    	}
   			}
   			
   		}
    }
    // GW 보내고난뒤에 결과를 가져온다.
    function sys_result(){
    	var formObj  = document.form;
   		var sheetObject = sheetObjects[0];
   		doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC05);
    }
    
    /**
     * 팝업에서 genExpnRqstNo 받음
     */
   function setCsrNo(csrNo) {
	var formObj  = document.form;
	 var sheetObject = sheetObjects[0];
	formObj.subs_csr_no.value = csrNo;
	doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC06);
	onChagnetypeCd();
   	doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC03);
   	aciveFlg();
   } 
   
   /**
    * 팝업에서 genExpnRqstNo 받음
    */
  function initReset(obj) {
	    var formObj  = document.form;
	    var sheetObject = sheetObjects[0];
	    sheetObject.Editable = false;
	    formObj.subs_csr_no.value = obj
		doActionIBSheet(sheetObject, formObj, IBSEARCH_ASYNC06);
	    onChagnetypeCd();
		doActionIBSheet(sheetObject, formObj, IBSEARCH_ASYNC03);
		aciveFlg();
		
		//doActionIBSheet(sheetObject, formObj, IBSEARCH_ASYNC02);
		
		
  } 
  
 // 버튼 및 필드값의 활성화 여부 판단 
 function aciveFlg(){
	 var formObj  = document.form;
	 var sheetObject = sheetObjects[0];
 	if(ComGetObjValue(formObj.apro_rslt_cd) == "Saved"){
		ComBtnEnable("btn_gw");
		ComBtnEnable("btn_save");
		ComBtnEnable("btn_cancel");
		sheetObject.Editable = true;
		formObj.inv_dt.disabled = false;
		formObj.pay_vndr_nm.disabled = false;
		formObj.pay_vndr_nm.disabled = false;
		formObj.inv_locl_ttl_amt.disabled = false;
		formObj.inv_curr_cd.disabled = false;
		formObj.expn_div_cd[0].disabled =false;
		formObj.expn_div_cd[1].disabled =false;
		formObj.expn_div_cd[2].disabled =false;
		formObj.expn_div_cd[3].disabled =false;
		comboObjects[0].enable = true;
		ComEnableObject(formObj.btns_calendar1,  true);
		ComBtnEnable("Row_Add");
		ComBtnEnable("Delete");
	}else {
		ComBtnDisable("btn_gw");
		ComBtnDisable("btn_save");
		ComBtnDisable("btn_cancel");
		formObj.inv_dt.disabled = true;
		formObj.pay_vndr_nm.disabled = true;
		formObj.pay_vndr_nm.disabled = true;
		formObj.inv_locl_ttl_amt.disabled = true;
		comboObjects[0].enable = false;;
		formObj.expn_div_cd[0].disabled =true;
		formObj.expn_div_cd[1].disabled =true;
		formObj.expn_div_cd[2].disabled =true;
		formObj.expn_div_cd[3].disabled =true;
		sheetObject.Editable = false;
		ComEnableObject(formObj.btns_calendar1,  false);
		ComBtnDisable("Row_Add");
		ComBtnDisable("Delete");
	}
 }
	/* 개발자 작업  끝 */