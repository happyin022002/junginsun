/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0021.js
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
* 2009-01-13 서관영 CSR:N200901090022 
* "PREV"를 "-1 day FCST"로 변경 
* 2009-02-02 최윤성 CSR:N200812260003, R200902030004
* "Adjusted allocation status" Tab 관련 로직 추가
*@LastModifyDate : 2009.08.10
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.10 한상훈
* 1.0 Creation
* 2011.04.07 이석준 [CHM-201109823] sheet2,shee3에서 VVD double click시에 0042 UI popup 호출 추가
* 2011.05.16 이석준 [CHM-201110710-01] Daily F"cast Status 화면 조건 추가
*                                    rlane1,rlane2,rlane3,rhq combo 추가    
* 2011.05.31 이석준 [CHM-201111306-01] 각 tab에  Area2 check box 추가                                    
* 2011.06.03 김종준 [CHM-201110708-01] F"cast 입력 요청 메세지 송부 기능추가(메일보내기 버튼 추가)
* 2011.07.05 이행지 [CHM-201111946-01] Daily F"cast Status 화면 보완 - 2,3번째 tab에 Dest.(IAS) chek box추가, Dest.컬럼 추가
* 2011.07.26 김종준 [SRM-201118467] allocation 체크박스 User Role이 SPC01 인 유저들에게만 활성화 되게 수정,조회조건에 Office들 셋팅해주고 비활성화/활성화 해주는 부분 삭제
* 2011.08.26 이행지 [선처리] RGN Office와 Login Office가 동일할 경우 Allocation 보여주기
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2012.02.16 김성훈 [CHM-201216142-01] 사용자별 Lane 정보 관리/조회시 Lane 항목 추가
* 2012.06.13 김성훈 [CHM-201218360-01] Daily Forecast Status 화면 보완
* 2012.08.08 전상화 [CHM-201219578-01] Tab : BKG Status(RHQ) 추가 
* 2012.11.16 최윤성 [CHM-201221640-01] FCST&PFMC by ACCT 신규 탭 추가
* 2013.01.15 최윤성 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.04.25 진마리아 [CHM-201324211] 프로젝트 안정화 및 HELP DESK - weekly AVG 통합
* 2013.06.13 진마리아 SELCDO 팀코드 변경 (SELCTY)
* 2013.08.02 진마리아 [CHM-201325983-01] Yield Group 추가, timeout 오류 수정
* 2013.08.08 진마리아 [선처리] Allocation 추가요건 - Guide 더블클릭시 Daily Forecast Status 팝업
* 2013.08.23 진마리아 [Trouble shooting] CC,RC,LC별 grouping을 Yield Group별 grouping으로 변경
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
* 2014.06.17 신자영 [CHM-201430603] FCST comparison 메뉴 일부 개선 요청 - Lane, VVD 추가
* 2014.07.27 Arie Im [CHM-201431081] SPC Allocation Control Option 추가 보완 요청
* 2014.10.21 Arie Im [CHM-201432344] Daily FCST - Dest Control시 SUM기능 보완
* 2014.10.27 박은주 [CHM-201432467] Daily FCST Inquiry 보완 요청(BKG Status(RHQ)에 POR 추가)
* 2014.11.04 박은주 [CHM-201432710]  [SPC : 사후CSR 진행] [CHM-201431980]Daily FCST -Dest/Local-IPI 조회기능 보완요청
* 2014.11.05 [CHM-201432345] SMP Report 신규 생성(요건 변경으로 FCST&PFMC Status by ACCT탭 수정) 
				- Accout Class삭제, L.OFC 체크박스 추가, Fcast 체크박스 추가
				- TTL CM, CMPB, Load% BKG옆에 추가
				- Inqurity by Customized Condition 팝업링크 추가
* 2014.11.20 [CHM-201432864] Daily FCST보완
				- SUB Trade별 전체 실적 GUIDE추가(Acct)
				- SUB Trade, Trade 별 USMode/Account/Dest Sum 추가(HO/RHQ)
				- 체크박스 기능 재정의(HO/RHQ)
				- Excluding Sector(IAS) 추가 (HO/RHQ탭)
* 2014.12.16 박은주 [CHM-201433153] Daily FCST status 리포트 보완 요청(겹선)
* 2015.02.24 김승만 [CHM-201533936] 사용자 표준환경 관련 개선
* 2015.03.09 [CHM-201534504]SMP IAS 보완에 따른 FCST 추가 개발 요청
* 2015.11.19 이혜민 [CHM-201538539] Allocation Control by Main office - Daily FCST Acct 화면 팝업 처리
* 2015.11.10 이혜민 [CHM-201538774] NON SMP account FCST 의 Daily FCST 보완 요청
* 2016.01.12 이혜민 [CHM-201539227] Daily FCST status _ Allocation status(HO) & Allocation status(RHQ) 기능추가
* 2016.05.03 이혜민 [CHM-201640976] Daily F"cast Status 오류 수정 요청 & Tap 위치 조정
* 2016.05.03 이혜민 [CHM-201640928] Daily Forecast Status 모든 조회 옵션 및 탭 > 그리드 화면에 SELCS, TYOSC 독립 RHQ 분리 요청
* 2016.05.27 이혜민 SELSC, TYOSC RHQ 독립분리
* 2018.01.03 김동호 [CSR-2928] SELCTY, SELCMA, SELCMI 외 사용자 로그인 시 Office 조회 조건 고정
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class ESM_SPC_0021 : ESM_SPC_0021 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0021() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
   	/** 개발자 작업	*/
    // 공통전역변수

    var sheetObjects = new Array();
    var comboObjects = new Array();
    
    var comObjects = new Array();
    var sheetCnt = 0;
    var comboCnt = 0;
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    //sheetResizeFull = true;
    //retrive check
    var check_retrive = false;
    var tab_retrives = new Array(7);
    //조회해온 결과의 week, 날짜
    var week;
    var fdtd;
    var rtn; 
    var portv;
    var week1;
    var fdtd1;
    var rtn1;  
    var portv1;
    var duration2_from;
    var duration2_to;
    
    // User Role
    var usrRoleYn = "N";
    
    var rlane_rtn_xml;
    var rlane1_combo_chg = false; // rlane1 combo에서 event를 발생 시켰는지 구분자
//    var rlane2_combo_chg = false; // rlane2 combo에서 event를 발생 시켰는지 구분자
//    var rlane3_combo_chg = false; // rlane3 combo에서 event를 발생 시켰는지 구분자
//    var rlane4_combo_chg = false; // rlane4 combo에서 event를 발생 시켰는지 구분자
//    var rlane5_combo_chg = false; // rlane5 combo에서 event를 발생 시켰는지 구분자
//    var rlane6_combo_chg = false; // rlane5 combo에서 event를 발생 시켰는지 구분자
   // var rlane7_combo_chg = false; // rlane5 combo에서 event를 발생 시켰는지 구분자
   // var rlane8_combo_chg = false; // rlane5 combo에서 event를 발생 시켰는지 구분자
//    var rlane11_combo_chg = false; // rlane11 combo에서 event를 발생 시켰는지 구분자
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    var init_year = '';
    var init_week = '';
    var init_date = '';
    var init_salesRep = '';
    
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         /*******************************************************/
         var sheetObject5   = sheetObjects[5];
         var sheetObject  = sheetObjects[0];
         var sheetObject1  = sheetObjects[1];
         var sheetObject2  = sheetObjects[2];
         var sheetObject3  = sheetObjects[3];	// SHKIM 20120613
         
         var sheetObject4  = sheetObjects[4];	// Add 2012.08.08
         var sheetObject6  = sheetObjects[6];	// Add 2012.09.26
         var sheetObject7  = sheetObjects[7];	// Add 2012.09.26
         var sheetObject8  = sheetObjects[8];	// Add 2012.09.26
         var sheetObject9  = sheetObjects[9];	// Add 2012.09.26
         
         var sheetObject10 = sheetObjects[10];	// Add 2012.11.16

         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		if (srcName == "check_area1" || srcName == "check_area2" || srcName == "check_area3" || srcName == "check_area4" || srcName == "check_area5"
    				|| srcName == "check_sector2" || srcName == "check_sector5") srcName = 'btn_retrieve';
    		if (srcName == "check_dest2" || srcName == "check_dest3" || srcName == "check_dest5" ) hiddenCheck();
    		
            switch(srcName) {
        	    case "btn_retrieve":
    	            for(var i = 0 ; i < sheetObjects.length; i++){
				        tab_retrives[i] = false;
				    }   	            
				    check_retrive = true;
    	            if(beforetab==5){				//F'cast Comparison
    	            	doActionIBSheet(sheetObject5,formObject,IBSEARCH);
    	            	tab_retrives[5] = true;
    	            }else if(beforetab==0){			// Allocation Status(HO) -- sheet2
    	            	doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	            	tab_retrives[0] = true;
    	            }else if(beforetab==1){ 		// Allocation Status(RHQ) -- sheet5
    	            	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    	            	tab_retrives[1] = true;
    	            }else if(beforetab==2){			// Adjusted allocation status
    	            	doActionIBSheet(sheetObject2,formObject,IBSEARCH);
    	            	tab_retrives[2] = true;
    	            }else if(beforetab==3){ 		// PFMC Ration vs QTA & BSA
    	            	doActionIBSheet(sheetObject3,formObject,IBSEARCH);
    	            	tab_retrives[3] = true;    	            
		            } else if( beforetab==4 ){		// BKG Status(RHQ)
		            	doActionIBSheet(sheetObject4,formObject,IBSEARCH);
		            	tab_retrives[4] = true;
		            } else if( beforetab==6 ){
		            	doActionIBSheet(sheetObject6,formObject,IBSEARCH);
		            	tab_retrives[6] = true;
		            } else if( beforetab== 7 ){ 		
		            	doActionIBSheet(sheetObject7,formObject,IBSEARCH);
		            	tab_retrives[7] = true;
		            } else if( beforetab== 8 ){		// FCST & PFMC Status by ACCT
		            	doActionIBSheet(sheetObject10,formObject,IBSEARCH);
		            	tab_retrives[8] = true;
		            }
        	        break;
        	        
        	    case "btn_new":
        	    	
					if(checkModifiedSheet(sheetObject)) {
						if(ComShowConfirm (getMsg("SPC90001")) != 1) {
							return;
						}
					}
	            	//공통함수사용: 화면을 초기화
//    					resetAll_test(); 
					ComResetAll();
					//Duration을 기본 4로 setting
					formObject.duration.value = 1;
					// rhq값을 로그인한 유저의 rhq로 setting
					
					formObject.rhq.Code = formObject.login_rhq_cd.value;    					
//    					comObjects[1].Code = "";
					for(var i = 0 ; i < sheetObjects.length ; i++){
				        tab_retrives[i] = false;
				    }
				    check_retrive = false;
				    
    				formObject.year.value = init_year;
					formObject.week1.value = init_week;  
					formObject.from_dt.value = init_date;  
			    	SpcSearchOptionWeek("week1",false,document.form.year.value);
			    	
			    	SpcSearchOptionTrade("trade", true, true);
	     			SpcSearchOptionSubTrade("subtrade1");
	     			SpcSearchOptionLane("rlane1",true,true);
//	     			SpcSearchOptionSubTrade("subtrade2");
//	     			SpcSearchOptionLane("rlane2",true,true);
//	     			SpcSearchOptionSubTrade("subtrade3");
//	     			SpcSearchOptionLane("rlane3",true,true);
//	     			SpcSearchOptionSubTrade("subtrade4");		// SHKIM 20120613 
//	     			SpcSearchOptionLane("rlane4",true,true);	// SHKIM 20120613 
//	     			SpcSearchOptionSubTrade("subtrade5");
//	     			SpcSearchOptionLane("rlane5",true,true);
//	     			SpcSearchOptionSubTrade("subtrade6");
//	     			SpcSearchOptionLane("rlane6",true,true); 
//	     			SpcSearchOptionSubTrade("subtrade11");		// Add 2012.11.16
//	     			SpcSearchOptionLane("rlane11",true,true);	// Add 2012.11.16
	     			
	     			// Add 2012.10.15
	     	     	SpcSearchOptionTrade("trade7", true, true, '', false, true, true);
	     	     	SpcSearchOptionLane("rlane7",true,true,'','','','', true, true);
	     	     	ComBtnDisable("btng_season_grp");
					break;
					    
                case "btn_downexcel":
    	            if(beforetab==5){
    	            	doActionIBSheet(sheetObject5,formObject,IBDOWNEXCEL);
    	            }else if(beforetab==0){
    	            	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    	            }else if(beforetab==1){
    	            	doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
    	            }else if(beforetab==2){
    	            	doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
	                }else if(beforetab==3){	// SHKIM 20120613 
		            	doActionIBSheet(sheetObject3,formObject,IBDOWNEXCEL);
		            
			    	}else if(beforetab==4){	///Add 2012.08.08.
			        	doActionIBSheet(sheetObject4,formObject,IBDOWNEXCEL);
			        }else if(beforetab==6){	///Add 2012.09.20.
			        	doActionIBSheet(sheetObject6,formObject,IBDOWNEXCEL);
			        }else if(beforetab==7){	///Add 2012.09.20.
			        	doActionIBSheet(sheetObject7,formObject,IBDOWNEXCEL);
			        }else if(beforetab==8){	///Add 2012.11.16
			        	doActionIBSheet(sheetObject10,formObject,IBDOWNEXCEL);
			        }
    	
                    break;

                case "btn_print":
                    ComShowMessage("btn_print cleck");
                    break;
                    
                case "btn_popup_office":
                    if (beforetab == 8 
                        && document.form.login_ofc_cd.value != "SELCTY" 
                        && document.form.login_ofc_cd.value != "SELCMA"
                        && document.form.login_ofc_cd.value != "SELCMI"
                        && document.form.login_ofc_cd.value != "SELGMS") {
                        return;
                    }
	   	        	var sales_office = formObject.sales_office.value;
	   	        	var param = 'ofc_cd='+sales_office;
					spcPopup("SalesOffice", param, 770, 470, "getSalesOffice", "1,0,1,1,1,1,1,1");
        	        break;  
        	        
                case "btn_popup_office1":
                	var sales_office = formObject.sales_office1.value;
                	var param = 'ofc_cd='+sales_office;
                	spcPopup("SalesOffice", param, 770, 470, "getSalesOffice1", "1,0,1,1,1,1,1,1");
                	break;  
        	        
				case "btn_popup_pol_cd":
		   	        var pol_cd = formObject.pol_cd.value;
		   	        spcPopup("POL", "loc_cd="+pol_cd+"&loc_port_ind=Y", 770, 470, "getPOL", "1,0,1,1,1,1,1,1" );
	   	        	break;  
	   	        	
				case "btn_sendmail":
					if (formObject.login_ofc_cd.value != "SELCDO" && formObject.login_ofc_cd.value != "SELCTY") return;
		    		var vFeatures = "status=no, resizable=no, scrollbars=no, width=" + 800
				  	  + ", height=" + 600 + ", left=" + (screen.width -770) / 2
				  	  + ", top=" + (screen.height -780) / 2;
					ComPostOpenWindow("/hanjin/ESM_SPC_0029.do?f_cmd=", "ESM_SPC_0029", vFeatures);
	   	        	break;  
	   	        	
				case "btn_save":
					// 2012.01.20 SHKIM
				    check_retrive = true;
				    
				    obj = document.getElementById('rlane1');
    	            
				    var selCnt 		= 0;	// 선택된 건수 
        			var trd_cd 		= "";
        			var sub_trd_cd 	= "";
        			var rlane_cd 	= "";
        			
        			rlane_cd = obj.Code	// 총 선택한 Lane
        			
        			for( i=1 ; i<obj.GetCount() ; i++ ){
        				if(obj.CheckIndex(i)==true){
        					selCnt++;
        					if(selCnt == 1){	
        						trd_cd 		+= obj.GetIndexText(i,0);		sub_trd_cd 	+= obj.GetIndexText(i,1);
        					}else{	
        						trd_cd 		+= ","+obj.GetIndexText(i,0);	sub_trd_cd 	+= ","+obj.GetIndexText(i,1);
        					}
        				}
        			}
        			var formObj = document.formSave;
        			formObj.ibflag.value 		= selCnt;
        			formObj.trd_cd.value 		= trd_cd;
        			formObj.sub_trd_cd.value 	= sub_trd_cd;
        			formObj.rlane_cd.value 		= rlane_cd;
        			formObj.dir_cd.value 		= document.form.bound.value;
        			
	            	doActionIBSheet(sheetObject1,formObj,IBSAVE);
        	        break;	
        	        
				case "btn_period1":
					var cal = new ComCalendar();
					cal.select(formObject.from_dt, 'yyyy-MM-dd');
					break;
	   	        	
				// Quota Upload Popup 호출
				case "btn_qta":
					var leftpos = (screen.width - 1024) / 2;
					if (leftpos < 0)
						leftpos = 0;
					var toppos = (screen.height - 540) / 2;
					if (toppos < 0)
						toppos = 0;    				
					
					ComOpenWindow("/hanjin/ESM_SPC_0085.do",'none',"scroll:yes;status:no;maximize:yes;minimize:yes;help:no;dialogWidth:770px;dialogHeight:620px;resizable:yes;dialogLeft:"+leftpos + ";dialogTop:" + toppos, true);
	   	        	break; 
	   	        	
				case "btn_vvd":
					var leftpos = (screen.width - 1024) / 2;
					if (leftpos < 0)
						leftpos = 0;
					var toppos = (screen.height - 540) / 2;
					if (toppos < 0)
						toppos = 0;    				
					
					ComOpenWindow("/hanjin/ESM_SPC_0086.do",'none',"scroll:yes;status:no;maximize:yes;minimize:yes;help:no;dialogWidth:420px;dialogHeight:530px;resizable:yes;dialogLeft:"+leftpos + ";dialogTop:" + toppos, true);
	   	        	break;

				case "btng_season_grp":
					yieldGrpPopup();
					break;
            } // end switch
            
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("COM12111");
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    function resetAll_test(){
        if(arguments[0] == undefined || arguments[0]){
            document.form.reset();
        }        	
    	 var objs = document.getElementsByTagName("OBJECT");
    	    for(var i = 0 ; i < objs.length ; i++){
    	        switch(objs[i].classid){
    	        case "CLSID:DAB66ACA-49CD-41F2-89A0-8593DBB0C36C": // IBSheet
    	            if(arguments[2] != undefined && !arguments[2]) continue;
    	            log(objs[i].id);
    	            objs[i].RemoveAll();
    	            break;
    	        case "CLSID:D9FA9278-6363-4906-A14E-0AFB460CEA90": //IBMultiCombo
    	            if(arguments[1] != undefined && !arguments[1]) continue;
    	            var id = objs[i].id;
    	            if(eval("initDataValue_" + id)){
    	                log("initDataValue_" + id + "()");
    	                eval("initDataValue_" + id + "()");
    	            }
    	            break;
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
		comObjects[comboCnt++] = combo_obj;
    }
    
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	//[CHM-201533936] Split13-사용자 표준환경 관련 combo를 diabled 하여 로딩후 다시 enable 
    	document.getElementById("trade").Enable = false;
    	document.getElementById("subtrade1").Enable = false;
    	
     	SpcSearchOptionYear("year");
     	SpcSearchOptionWeek("week1");
     	SpcSearchOptionDuration("duration", 6, 4);
     	SpcSearchOptionDuration("duration2_from", 14, 1);
     	SpcSearchOptionDuration("duration2_to", 14, 1);
     	SpcSearchOptionTrade("trade");
     	SpcSearchOptionBound("bound",false,true,false,false);
     	SpcSearchOptionRhq("rhq");
     	SpcSearchOptionRhq("rhq1");
     	SpcSearchOptionSubTrade("subtrade1");
     	
     	// Duration 설정 - Add 2012.09.10.
     	SpcSearchOptionDuration("duration1", 15, 5);
     	
     	SpcSearchOptionTrade("trade7", true, true, '', false, true, true);
     	SpcSearchOptionLane("rlane7",true,true,'','','','', true, true);
		
     	var combo = document.getElementById("grp_acct");
     	combo.enable = false;
     	var combo1 = document.getElementById("acct");
     	combo1.enable = false;
    	
    	var formObj = document.form;
    	initControl();
    	for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        var sheetResizeFull = true;
		document_onresize();
        
        SpcSearchOptionRHQCombo("rhq", true);
        //Allocation HO/RHQ 탭의 RHQ 조건 세팅
        SpcSearchOptionRHQCombo("rhq2", false, false, true);
        // 초기화
        // CASE1 : SELCDO, RHQ값이 없음. RHQ,AREA,OFC 활성화
        // CASE2 : RHQ, AREA값이 없음. AREA,OFC 비활성화
        // CASE3 : AREA, OFC값이 없음, OFC 활성화
        // CASE4 : OFC , RHQ,AREA,OFC 비활성화
         var rhq_cd = formObj.login_rhq_cd.value;
         var aq_cd  = formObj.login_aq_cd.value;
         var rgn_cd = formObj.login_rgn_cd.value;
        if (rhq_cd ==null || rhq_cd ==""){ // case1
        } else if ((aq_cd == null || aq_cd =="") && (rgn_cd == null || rgn_cd =="")){ // case2
        	formObj.rhq.Code = rhq_cd;
        	formObj.rhq1.Code = rhq_cd;
        	formObj.rhq2.Code = rhq_cd;
        } else if (rgn_cd == null || rgn_cd ==""){ // case3
        	formObj.rhq.Code               = rhq_cd;
        	formObj.area.value             = aq_cd;
        	formObj.rhq1.Code               = rhq_cd;
        	formObj.rhq2.Code               = rhq_cd;
        	formObj.area1.value             = aq_cd;
        } else { //case4
        	formObj.rhq.Code = rhq_cd;
        	formObj.area.value = aq_cd;
        	formObj.sales_office.value = rgn_cd;  
        	formObj.rhq1.Code = rhq_cd;
        	formObj.rhq2.Code = rhq_cd;
        	formObj.area1.value = aq_cd;
        	formObj.sales_office1.value = rgn_cd; 
        }
    	var chkViewP = document.form.chkViewP.checked;
    	var chkViewL = document.form.chkViewL.checked;
    	if(chkViewP==true && chkViewL==false){
			document.form.chkview.value="P";
    	}else{
    		document.form.chkview.value="O"; 
    	}
    	document.form.duration.options.value="4";
    	tab_retrives[0] = false;
		tab_retrives[1] = false;
		tab_retrives[2] = false;
		tab_retrives[3] = false;	// SHKIM 0615
		tab_retrives[4] = false;	// SHKIM 0615		
		//Add 2012.08.08.
		tab_retrives[5] = false;
		tab_retrives[6] = false;
		tab_retrives[7] = false;
		//Add 2012.11.16
		tab_retrives[8] = false;
//		changetitle();
//		changeTitle2(document.form.check_office);
//		changeTitle3(document.form.check_office2);	
//		changeTitle4(document.form.check_office3);	
//		changeTitle5(document.form.check_office5);	
		
		//Add 2012.08.08.
//		changeTitle6(document.form.check_office6);
		
		RevenueLaneSetting(); /* Multi Combo Data Setting */
		document.form.year.focus();
        if (formObj.login_ofc_cd.value =="SELCDO" || formObj.login_ofc_cd.value == "SELCTY") {
        	document.getElementById("btn_sendmail").disabled = false;
        } else {
        	document.getElementById("btn_sendmail").disabled = true;
        }
        
        doActionIBSheet(sheetObjects[0],document.form,SEARCHLIST08);	//USR_ROLE_CD 가져오기
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        document.form.from_dt.value = ComGetNowInfo();

    	init_year = document.form.year.value; // 년 초기화용
    	init_week = document.form.week1.value; // 주차 초기화용
    	init_date = document.form.from_dt.value; // 주차 초기화용
    	init_salesRep = document.getElementById("srep_cd").Code; 
     	
//     	var rtn = getCodeList("TradeAccount", "year="+init_year+"&week="+init_week+"&duration="+document.form.duration.value);
//    	initData_acctList(rtn[0].split("|"), rtn[1].split("|"));
//    	var rtn = getCodeList("Account", "grp=Y&year="+init_year+"&week="+init_week+"&duration="+document.form.duration.value);
//    	initData_groupAcctList(rtn[0].split("|"), rtn[1].split("|"));
    	
    	if(rgn_cd == "SELSC"){
	    	var rtn = getCodeList("TeamSalesRep", "ofc_cd=" + rgn_cd + "&level=4");
			initData_salesRep(rtn[0].split("|"), rtn[1].split("|"));
    	}
    	
    	if(document.form.t_year.value != ""){
    		document.form.year.value         = document.form.t_year.value;
	    	document.form.week1.value        = document.form.t_week.value;
	    	document.form.duration.value     = document.form.t_duration.value;
	    	document.form.trade.Code         = document.form.t_trade.value;
	    	document.form.subtrade1.Code     = document.form.t_subtrade.value;
	    	document.form.rlane1.Code        = document.form.t_rlane.value;
	    	document.form.rhq.Code           = document.form.t_rhq.value;
	    	document.form.rhq2.Code          = document.form.t_rhq.value;
	    	document.form.sales_office.value = document.form.t_rgn_cd.value;
	    	document.form.acct.Code          = document.form.t_acct.value;
	    	
	    	tabObjects[0].SelectedIndex = (tabObjects[0].TabInfo.split("|")).length - 1;
	    	
	    	//Control by HO나 Allocation Control by Main Office에서 팝업으로 열었을경우
	    	if(document.form.t_src.value == "0042" || document.form.t_src.value == "0044"){
	    		document.form.view_type11[1].checked = true;//LOFC
	    		sheet11ReSearch();
    		}
	    	doActionIBSheet(sheetObjects[10],document.form,IBSEARCH);
    	}
    	
    	ComBtnDisable("btng_season_grp");
    	    	
    	//[CHM-201533936] Split13-사용자 표준환경 관련 combo를 diabled 하여 로딩후 다시 enable 
    	document.getElementById("trade").Enable = true;
    	document.getElementById("subtrade1").Enable = true;
    	        
        if (beforetab == 8
                && document.form.login_ofc_cd.value != "SELCTY" 
                && document.form.login_ofc_cd.value != "SELCMA"
                && document.form.login_ofc_cd.value != "SELCMI"
                && document.form.login_ofc_cd.value != "SELGMS") {
            document.getElementById("rhq").Code = document.form.login_rhq_cd.value;
            document.getElementById("rhq2").Code = document.form.login_rhq_cd.value;
            document.getElementById("sales_office").value = document.form.login_rgn_cd.value;
            document.getElementById("rhq").Enable = false;
            document.getElementById("rhq2").Enable = false;
            document.getElementById("sales_office").disabled = "disabled";
        } else {
            document.getElementById("rhq").Enable = true;
            document.getElementById("rhq2").Enable = true;
            document.getElementById("sales_office").disabled = "";
        }
    }
	
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        
        switch(sheetObj.id) {
            case "sheet1":      //sheet1 init  --tab6 : F'cast Comparison
	            sheetObj.style.height = sheetObj.getSheetHeight(16) ;
            	initSheet1(sheetObj, "200701|200702|200703", "20070101~20070106|20070107~20070113|20070114~20070120", "O", '1','1');
                break;
            case "sheet2":     //sheet2 init   --tab1 : Allocation Status(HO)
	            sheetObj.style.height = sheetObj.getSheetHeight(16) ;
            	initSheet2(sheetObj, "200701|200702|200703", "20070101~20070106|20070107~20070113|20070114~20070120", "O");
				chagneSheet2(sheetObj, "200701|200702|200703");
                break;
            case "sheet3":     //sheet3 init   --tab3 : Adjusted allocation status
	            sheetObj.style.height = sheetObj.getSheetHeight(16) ;
            	initSheet3(sheetObj, "200701|200702|200703", "20070101~20070106|20070107~20070113|20070114~20070120", "O");
				chagneSheet3(sheetObj, "200701|200702|200703");
                break;
            case "sheet4":     //sheet4 init SHKIM --tab4 : PFMC Ration vs QTA & BSA
	            sheetObj.style.height = sheetObj.getSheetHeight(16) ;
            	initSheet4(sheetObj, "200701|200702|200703", "20070101~20070106|20070107~20070113|20070114~20070120", "O");
                break;
            
            case "sheet5":		//sheet5 init --tab2 : Allocation Status(RHQ)
            	sheetObj.style.height = sheetObj.getSheetHeight(16) ;
            	initSheet5(sheetObj, "200701|200702|200703", "20070101~20070106|20070107~20070113|20070114~20070120", "O");
				chagneSheet5(sheetObj, "200701|200702|200703");
                break;
                            
            //Add 2012.08.08.
            case "sheet6":		//sheet5 init --tab5 : BKG Status(RHQ)
            	sheetObj.style.height = sheetObj.getSheetHeight(16) ;
            	initSheet6(sheetObj, "200701|200702|200703", "20070101~20070106|20070107~20070113|20070114~20070120", "O");
            	chagneSheet6(sheetObj, "200701|200702|200703");
            	break;
            	
            //Add 2012.09.10.
            case "sheet7":		//sheet5 init --tab7 : Alloc&PFMC status by S.REP
            	sheetObj.style.height = sheetObj.getSheetHeight(17) ;
            	initSheet7(sheetObj, "CAX", "SMXX0001W", "O");
            	break;
            	
            //Add 2012.09.10.
            case "sheet8":		//sheet5 init --tab8 : FCST&BKG PFMC by S.Office
            	sheetObj.style.height = sheetObj.getSheetHeight(17) ;
            	initSheet8(sheetObj, "Trade|Lane|VVD|PROJ\n&BKG");
            	break;
            	
            case "sheet9":		//sheet5 init
            case "sheet10":		//sheet5 init 
            	sheetObj.style.height = sheetObj.getSheetHeight(17) ;
            	initSheet8(sheetObj, "Trade|Lane|VVD|출발일");
            	break;
            
            //Add 2012.11.16
            case "sheet11":     //sheet11 init --tab9 : FCST & PFMC Status by ACCT
	            sheetObj.style.height = sheetObj.getSheetHeight(15) ;
	            initSheet11(sheetObj, "200701|200702|200703", "20070101~20070106|20070107~20070113|20070114~20070120", "ACCT", "1");
                break;
                
        }
    }
    
     
    /**
     * TabSheet1에서 조회후 타이틀 변경
     * F'cast Comparison
     */
	function initSheet1(sheetObj, strWeeks, strFdTds, strPortV, duration2_from, duration2_to){
       with (sheetObj) {
            // 높이 설정
            //style.height = getSheetHeight(17) ;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msPrevColumnMerge;

            //전체Edit 허용 여부 [선택, Default false]
            Editable = false;
            FocusEditMode = default_edit_mode;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo( 3, 1, 5, 100);
            var duration_cnt = duration2_to - duration2_from
            //1~5 5-1 = 4
            var weekArr = strWeeks.split("|");
            var fdtdArr = strFdTds.split("|");
            // modify 2013.12.10
            // Lane, r_Num 추가로 3->5
            var columnCount = 5 + (weekArr.length) * (5 + duration_cnt + 1) ;
            //var columnCount = 3 + (weekArr.length) * 11;
            
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(columnCount + 1, 5 , 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, true, false, true, false,false) ;
			if(strPortV=="O"){
			    var HeadTitle0 = "Lane|Area|Office|R_num| ";
	            var HeadTitle1 = "Lane|Area|Office|R_num| ";
			}else{
				var HeadTitle0 = "Lane|Port|Office|R_num| ";
	            var HeadTitle1 = "Lane|Port|Office|R_num| ";
			}
			
            var HeadTitle2 = "QTA|F'cast|-1 day F'cast|-2 day F'cast|-3 day F'cast|-4 day F'cast|-5 day F'cast|-6 day F'cast|DIFF|BKG|Perf";
            //2013.12.10 duration 선택에 따라 title 변경
            var HeadTitleTEST = "QTA|F'cast"
            var HeadTitleAdd = ""
            for(var i = 0 ; i < duration_cnt + 1 ; i++, duration2_from++ ){    
           
            	HeadTitleAdd = HeadTitleAdd + "|-" + duration2_from + "day F'cast"      
            }	
            HeadTitleTEST = HeadTitleTEST + HeadTitleAdd + "|DIFF|BKG|Perf"
            HeadTitle2 = HeadTitleTEST ;
            var WeekTitle = "";
            var FdTdTitle = "";
            var Title3 = "";
            
            for(var i = 0 ; i < weekArr.length ; i++){                    	
//        		for(var h = 0 ; h < 5 ; h++){
            		for(var k = 0 ; k < 6 + duration_cnt; k++){
                		WeekTitle = WeekTitle+ "|" + weekArr[i];
                		FdTdTitle = FdTdTitle+ "|" + fdtdArr[i];                		
            		}     
            		Title3 = Title3+"|"+ HeadTitle2;      
//        		}        		
            }	
			HeadTitle0 = HeadTitle0+ WeekTitle;
			HeadTitle1 = HeadTitle1+ FdTdTitle;
			if(strPortV=="O"){
				HeadTitle2 = "Lane|Area|Office|R_num| "+Title3; 
			}else{
				HeadTitle2 = "Lane|Port|Office|R_num| "+Title3; 
			}
			
            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle0, true);
            InitHeadRow(1, HeadTitle1, true);
            InitHeadRow(2, HeadTitle2, true);
            
			var cnt = 0;
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData ,    70,    daCenter,   true,    "rlane_cd",  false,          "",       dfNone,       0,     true,       true);
			InitDataProperty(0, cnt++ , dtData ,    70,    daCenter,   true,    "area",     false,          "",       dfNone,       0,     true,       true);
            InitDataProperty(0, cnt++ , dtData ,    70,    daCenter,   true,    "ofc_cd",   false,          "",       dfNone,       0,     true,       true);
            InitDataProperty(0, cnt++ , dtHidden ,  30,    daCenter,   true,    "r_num",     false,          "",       dfNone,       0,     true,       true);
            InitDataProperty(0, cnt++ , dtHidden ,  30,    daCenter,   true,    "level",    false,          "",       dfNone,       0,     true,       true);			
			for(var j = 1 ; j < weekArr.length+1 ; j++){
				var i = 1;
				InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   true,    "qta"+i+j,       false,          "",       dfInteger,       0,     true,       true);
            	InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   true,    "fcast"+i+j,     false,          "",       dfInteger,       0,     true,       true);
            	InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "prev"+i+j,     false,          "",       dfInteger,       0,     true,       true);
            	if (duration_cnt > 0){
            		InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "prev"+i+j,     false,          "",       dfInteger,       0,     true,       true);
            	}
            	if (duration_cnt > 1){
                	InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "prev"+i+j,     false,          "",       dfInteger,       0,     true,       true);
                }
            	if (duration_cnt > 2){
                	InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "prev"+i+j,     false,          "",       dfInteger,       0,     true,       true);
                }
            	if (duration_cnt > 3){
                	InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "prev"+i+j,     false,          "",       dfInteger,       0,     true,       true);
                }
            	if (duration_cnt > 4){
                	InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "prev"+i+j,     false,          "",       dfInteger,       0,     true,       true);
                }
            	InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "diff"+i+j,     false,          "",       dfInteger,       0,     true,       true);
        		InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "bkg"+i+j,      false,          "",       dfInteger,       0,     true,       true);
            	InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "pref"+i+j,     false,          "",       dfNone,          1,     true,       true);
				
		    }
			
			sheetObj.ShowTreeLevel(2);
			
            CellBackColor(1,0) = RgbColor(222, 251, 248);
            for(var m = 0 ; m <columnCount ; m ++)
            {
                CellBackColor(1,m) = RgbColor(222, 251, 248);   // ENIS
                CellBackColor(2,m) = RgbColor(222, 251, 248);   // ENIS
            }
            // 여기에 숫자 더해야 LANE/AREA/Office옆에 보임	       
            InitTreeInfo(4, "level", RgbColor(0,0,255), false);
            HeadRowHeight = 20 ;
			HeadRowHeight = 21 ; 
       }
	}
	
	/**
     * TabSheet2에서 조회후 타이틀 변경
     * Allocation Status(HO)
     */
	function initSheet2(sheetObj, strWeeks, strFdTds, strPortV){ 
    	 
	       with (sheetObj) {
	       		Reset();
	            // 높이 설정
//	            style.height = getSheetHeight(30) ;
	            //전체 너비 설정
	            SheetWidth = mainTable.clientWidth;
	
	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msPrevColumnMerge;
	
	            //전체Edit 허용 여부 [선택, Default false]
	            Editable = false;
	            FocusEditMode = default_edit_mode;
	
	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo( 4, 1, 1, 100);
				
	            var weekArr = strWeeks.split("|");
	            var fdtdArr = strFdTds.split("|");
	            
	            var columnCount = 12 + (weekArr.length) *6;
//	            var columnCount = 7 + (weekArr.length) *5;
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(columnCount + 4, 10 , 0, true);//+20?
	
	            // 해더에서 처리할 수 있는 각종 기능을 설정한다([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
	            InitHeadMode(false, true, false, true, false,false) ;
	            
	            var HeadTitle0 = "";
	        	var HeadTitle1 = "";
	        	
				if(strPortV=="O"){	
					HeadTitle0 = "Dest.|Sub Trade\n/Lane|||||||||||||";
					HeadTitle1 = "Dest.|Sub Trade\n/Lane|Area|Load Office|Sub Office|Yield Group|IPI/Local|Account|Dest|Lvl|Hidden Check|hg|hc1|hc2|hc3";
				}else{
					HeadTitle0 = "Dest.|Sub Trade\n/Lane|||||||||||||";
					HeadTitle1 = "Dest.|Sub Trade\n/Lane|Port|Load Office|Sub Office|Yield Group|IPI/Local|Account|Dest|Lvl|Hidden Check|hg|hc1|hc2|hc3";
				}
				
				var HeadTitle2 = HeadTitle0;
	            var HeadTitle3 = HeadTitle0;
	            var WeekTitle = "";
	            var FdTdTitle = "";
	            var Title3 = "";
//    	            var ItemArr = new Array("Vol/Teu.", "G.RPB/USD", "CMB/USD", "G.Rev/1000USD", "CM/1000USD");
	            var ItemArr = new Array("Vol/Teu.");
	            var ValuArr = new Array("QTA", "F'cast", "Alloc", "BKG", "Perf(TEU)", "Perf(WGT)");
	            var ItemTitle = "";
	            
	            for(var i = 0 ; i < weekArr.length ; i++){      
          	    	for(var k = 0 ; k < 6 ; k++){
                		HeadTitle0 = HeadTitle0+ "|" + weekArr[i];
                		HeadTitle1 = HeadTitle1+ "|" + fdtdArr[i];   
            			HeadTitle2 = HeadTitle2+ "|" + ItemArr[0];
            			HeadTitle3 = HeadTitle3+ "|" + ValuArr[k];
            		}
	            }

	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle0, true);
                InitHeadRow(1, HeadTitle1, true);
                InitHeadRow(2, HeadTitle2, true);
                InitHeadRow(3, HeadTitle3, true);
                
				var cnt = 0;
	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,     "dest",         false,          "",      dfNone,      0,     true,       true,          30);
				InitDataProperty(0, cnt++ , dtData,       100,   daCenter,  true,     "rlane_cd",     false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtData,       90,    daCenter,  true,     "area",         false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "ofc_cd",       false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "sub_ofc_cd",       false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "acct_lvl",     false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,     "usa_bkg_mod_cd",		 false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "acct_cd",					 false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,     "dest_loc_cd",			 false,          "",      dfNone,      0,     true,       true,          30);
                
                InitDataProperty(0, cnt++ , dtHidden ,    150,   daCenter,  true,     "level",        false,          "",      dfNone,      0,     true,       true);
                InitDataProperty(0, cnt++ , dtHidden ,    50,    daCenter,  true,     "hidden_chk",   false,          "",      dfNone,      0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox ,  30,    daCenter,  true,     "hg",   false,          "",      dfNone,      0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox ,  30,    daCenter,  true,     "hc1",   false,          "",      dfNone,      0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox ,  30,    daCenter,  true,     "hc2",   false,          "",      dfNone,      0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox ,  30,    daCenter,  true,     "hc3",   false,          "",      dfNone,      0,     true,       true);
                ColHidden(cnt-1) = true;
                ColHidden(cnt-2) = true;
                ColHidden(cnt-3) = true;
                ColHidden(cnt-4) = true;
                var sCol = cnt;
                
	            for(var j = 1 ; j < weekArr.length+1 ; j++){
	            	var m =1;
	            	InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "qta"+m+j,     false,          "",       dfInteger,       0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "fcast"+m+j,   false,          "",       dfInteger,       0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "alloc"+m+j,   false,          "",       dfInteger,       0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "bkg"+m+j,     false,          "",       dfInteger,       0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   true,    "pref"+m+j,    false,          "",       dfNone,          1,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    65,    daRight ,   true,    "prf"+m+j,    false,          "",       dfNone,          1,     true,       true);
		            ColHidden("prf"+m+j) = true;
				}
				var eCol = cnt;
				for(var n = sCol ; n < eCol ; n++){
					ColHidden(n) = true;
				}
				
	            sheetObj.RangeBackColor(1, 10+3, 3, columnCount-1+3)  = RgbColor(222, 251, 248);	// 조회 후 Header 색 변경
	            InitTreeInfo(9, "level", RgbColor(0,0,0), false);

				HeadRowHeight = 20 ; 
				RowHidden(2) = true;
	       }
	}
     
     /**
      * SHKIM 20120613 TabSheet3에서 조회후 타이틀 변경
      * PFMC Ratio vs QTA & BSA
      */
 	function initSheet4(sheetObj, strWeeks, strFdTds, strPortV){ 
 		
    	  with (sheetObj) {
       		Reset();
            // 높이 설정
            //style.height = getSheetHeight(17) ;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msPrevColumnMerge;

            //전체Edit 허용 여부 [선택, Default false]
            Editable = false;
            FocusEditMode = default_edit_mode;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo( 4, 1, 5, 100);
			
            var weekArr = strWeeks.split("|");
            var fdtdArr = strFdTds.split("|");
            var columnCount = 5 + (weekArr.length) *6;
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(columnCount, 4 , 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, true, false, true, false,false) ;
            
            var HeadTitle0 = "";
	        var HeadTitle1 = "";
	        	
            HeadTitle0 = "Sub Trade\n/Lane|||";
        	HeadTitle1 = "Sub Trade\n/Lane|RHQ|Area|Load Office";

        	var HeadTitle2 = HeadTitle0;
            var HeadTitle3 = HeadTitle0;
            var WeekTitle = "";
            var FdTdTitle = "";
            var Title3 = "";
            var ItemArr = new Array("Vol/Teu.");
	        var ValuArr = new Array("FCST", "vs QTA", "vs BSA", "BKG", "vs QTA", "vs BSA");
            var ItemTitle = "";
            
            
            for(var i = 0 ; i < weekArr.length ; i++){      
         	    	for(var k = 0 ; k < 6 ; k++){	// 20120615 SHKIM
               		HeadTitle0 = HeadTitle0+ "|" + weekArr[i];
               		HeadTitle1 = HeadTitle1+ "|" + fdtdArr[i];   
           			HeadTitle2 = HeadTitle2+ "|" + ItemArr[0];
           			HeadTitle3 = HeadTitle3+ "|" + ValuArr[k];
           		}
            }

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle0, true);
            InitHeadRow(1, HeadTitle1, true);
            InitHeadRow(2, HeadTitle2, true);
            InitHeadRow(3, HeadTitle3, true);
               
			var cnt = 0;
            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtData,       100,   daCenter,  true,     "rlane_cd",     false,          "",      dfNone,      0,     true,       true,          30);
            InitDataProperty(0, cnt++ , dtHidden ,    90,    daCenter,  true,     "rhq_cd",       false,          "",      dfNone,      0,     true,       true);
            InitDataProperty(0, cnt++ , dtData,       90,    daCenter,  true,     "area",         false,          "",      dfNone,      0,     true,       true,          30);
            InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "ofc_cd",       false,          "",      dfNone,      0,     true,       true,          30);
            var sCol = cnt;
           
            for(var j = 1 ; j < weekArr.length+1 ; j++){
            	var m =1;
            	InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "fct"+m+j,      false,          "",       dfInteger,    0,     true,       true);
            	InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "fqta"+m+j,     false,          "",       dfNone,       1,     true,       true);
            	InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "fbsa"+m+j,     false,          "",       dfNone,       1,     true,       true);
            	InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "bkg"+m+j,      false,          "",       dfInteger,    0,     true,       true);
            	InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "bqta"+m+j,     false,          "",       dfNone,       1,     true,       true);
            	InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "bbsa"+m+j,     false,          "",       dfNone,       1,     true,       true);
			}
			var eCol = cnt;
			for(var n = sCol ; n < eCol ; n++){
				//ColHidden(n) = true;
			}
			
            sheetObj.RangeBackColor(1, 4, 3, columnCount-1)  = RgbColor(222, 251, 248);	// 조회 후 Header 색 변경
            HeadRowHeight = 20 ;
			HeadRowHeight = 21 ; 
			RowHidden(2) = true;
       }
 	}
	/**
     * TabSheet4에서 조회후 타이틀 변경
     * Allocation Status(RHQ)
     */
	function initSheet5(sheetObj, strWeeks, strFdTds, strPortV){ 
    	 
	       with (sheetObj) {
	       		Reset();
	            // 높이 설정
//	            style.height = getSheetHeight(30) ;
	            //전체 너비 설정
	            SheetWidth = mainTable.clientWidth;
	
	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msPrevColumnMerge;
	
	            //전체Edit 허용 여부 [선택, Default false]
	            Editable = false;
	            FocusEditMode = default_edit_mode;
	
	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo( 4, 1, 5, 100);
				
	            var weekArr = strWeeks.split("|");
	            var fdtdArr = strFdTds.split("|");
	            
	                        
	            var columnCount = 11 + (weekArr.length) *6 + 7;//7->10
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(columnCount + 1, 11 , 0, true);//8-->11
	
	            // 해더에서 처리할 수 있는 각종 기능을 설정한다([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
	            InitHeadMode(false, true, false, true, false,false) ;
	            
	            var HeadTitle0 = "";
	        	var HeadTitle1 = "";
	        	
	            HeadTitle0 = "Dest.|Sub Trade\n/Lane|||||||||||ho|hg0|hg|hc1|hc2|hc3";
	        	HeadTitle1 = "Dest.|Sub Trade\n/Lane|RHQ|Area|Load Office|Sub Office|Yield Group|IPI/Local|Account|Dest|level|Hidden Check|ho|hg0|hg|hc1|hc2|hc3";

	        	var HeadTitle2 = HeadTitle0;
	            var HeadTitle3 = HeadTitle0;
	            var WeekTitle = "";
	            var FdTdTitle = "";
	            var Title3 = "";
	            var ItemArr = new Array("Vol/Teu.");
	            var ValuArr = new Array("QTA", "F'cast", "Alloc", "BKG", "Perf(TEU)", "Perf(WGT)");
	            var ItemTitle = "";
	            
	            for(var i = 0 ; i < weekArr.length ; i++){      
          	    	for(var k = 0 ; k < 6 ; k++){
                		HeadTitle0 = HeadTitle0+ "|" + weekArr[i];
                		HeadTitle1 = HeadTitle1+ "|" + fdtdArr[i];   
            			HeadTitle2 = HeadTitle2+ "|" + ItemArr[0];
            			HeadTitle3 = HeadTitle3+ "|" + ValuArr[k];
            		}
	            }

	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle0, true);
                InitHeadRow(1, HeadTitle1, true);
                InitHeadRow(2, HeadTitle2, true);
                InitHeadRow(3, HeadTitle3, true);
                
				var cnt = 0;
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,     "dest",         false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtData,       100,   daCenter,  true,     "rlane_cd",     false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtHidden,     90,    daCenter,  true,     "rhq_cd",       false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtData,       90,    daCenter,  true,     "area",         false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "ofc_cd",       false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "sub_ofc_cd",   false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "acct_lvl",     false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,     "usa_bkg_mod_cd",false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "acct_cd",		false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,     "dest_loc_cd",	false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtHidden ,    150,   daCenter,  true,     "level",        false,          "",      dfNone,      0,     true,       true);
                InitDataProperty(0, cnt++ , dtHidden ,    50,    daCenter,  true,     "hidden_chk",   false,          "",      dfNone,      0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox ,  30,    daCenter,  false,    "ho",   false,          "",      dfNone,      0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox ,  30,    daCenter,  false,    "hg0",   false,          "",      dfNone,      0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox ,  30,    daCenter,  false,    "hg",   false,          "",      dfNone,      0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox ,  30,    daCenter,  false,    "hc1",   false,          "",      dfNone,      0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox ,  30,    daCenter,  false,    "hc2",   false,          "",      dfNone,      0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox ,  30,    daCenter,  false,    "hc3",   false,          "",      dfNone,      0,     true,       true);
                ColHidden(cnt-6) = true; //Office
                ColHidden(cnt-5) = true; //Guide For None Office
                ColHidden(cnt-4) = true; //Guide
                ColHidden(cnt-3) = true; //UsMode
                ColHidden(cnt-2) = true; //Account
                ColHidden(cnt-1) = true; //Dest
                
                var sCol = cnt;
                
	            for(var j = 1 ; j < weekArr.length+1 ; j++){
	            	var m =1;
	            	InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "qta"+m+j,     false,          "",       dfNone,       0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "fcast"+m+j,   false,          "",       dfNone,       0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "alloc"+m+j,   false,          "",       dfNone,       0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "bkg"+m+j,     false,          "",       dfNone,       0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   true,    "pref"+m+j,    false,          "",       dfNone,       1,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    65,    daRight ,   true,    "prf"+m+j,    false,          "",       dfNone,          1,     true,       true);
		            ColHidden("prf"+m+j) = true;
				}
				var eCol = cnt;
				for(var n = sCol ; n < eCol ; n++){
					ColHidden(n) = true;
				}
				InitTreeInfo("level", "", RgbColor(0,0,0), false);

				
	            sheetObj.RangeBackColor(1, 11, 3, columnCount-1)  = RgbColor(222, 251, 248);//8-->11
                HeadRowHeight = 20 ;
				HeadRowHeight = 21 ; 
				RowHidden(2) = true;
	       }
	}
	
	/**
     * TabSheet5에서 조회후 타이틀 변경
     * BKG Status(RHQ)
     * Add 2012.08.08.
     */
	function initSheet6(sheetObj, strWeeks, strFdTds, strPortV){ 
    	 
		var formObj = document.form;		
		
		
	       with (sheetObj) {
	       		Reset();
	            // 높이 설정
	            //style.height = getSheetHeight(17) ;
	            //전체 너비 설정
	            SheetWidth = mainTable.clientWidth;
	            
	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	            
	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msPrevColumnMerge;
	            
	            //전체Edit 허용 여부 [선택, Default false]
	            Editable = false;
	            FocusEditMode = default_edit_mode;
	            
	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo(4, 1, 5, 100);
				
	            var weekArr = strWeeks.split("|");
	            var fdtdArr = strFdTds.split("|");
	            
	            var columnCount = 9 + (weekArr.length) * 21; //22;
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(columnCount, 8, 0, true);
	            
	            // 해더에서 처리할 수 있는 각종 기능을 설정한다([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
	            InitHeadMode(false, true, false, true, false,false) ;
	            
	            var HeadTitle0 = "";
	        	var HeadTitle1 = "";
	        	var HeadTitle2 = "";
	            var HeadTitle3 = "";
	           	        
	            HeadTitle0 = "Sub Trade\n/Lane|||||||";
	            
	            if(formObj.viewDiv.value =="OFFICE")
	        	HeadTitle1 = "Sub Trade\n/Lane||Area|SubTradeCd|lane|bound|Load Office|POL/POD/DEL";
	            else if(formObj.viewDiv.value =="PORT")
	            HeadTitle1 = "Sub Trade\n/Lane||Area|SubTraedCd|lane|bound|POL/POD/DEL|Load Office";	
	            
	            HeadTitle2 = "Sub Trade\n/Lane|||||||";
	            HeadTitle3 = "Sub Trade\n/Lane|||||||";
	            
	            var ValuArr01 = new Array( 
	            						"QTA",
	            						"Alloc","Alloc",
	            						"VVD",
	            						"BKG", "BKG", "BKG","BKG","BKG","BKG","BKG","BKG","BKG","BKG","BKG","BKG",
	            						"CNTR","CNTR","CNTR",
//	            						"CNTR","CNTR","CNTR","CNTR",
	            						"Perf","Perf"
	            						);
	            var ValuArr02 = new Array(
					            		"",
					            		"TEU","Reefer",
					            		"VVD",
										"TEU", "TEU", "TEU","TEU","TEU","TEU","TEU","TEU","TEU","Reefer","Reefer","Reefer",
										"MVNT","MVNT","MVNT",
//										"MVNT","MVNT","MVNT","MVNT",
										"TEU","Reefer"
										);
	           
	            var ValuArr03 = new Array( 
					            		"",
										""," ",
										"VVD",
										"TTL","20'", "40'","D2","D4", "HC","RD","45'","53'","TTL","R2","R5",
										"OP","OC","VL",
//										"EN","OP","OC","VL",
										""," "
										);
	           
	            
	            for(var i = 0 ; i < weekArr.length ; i++){      
          	    	for(var k = 0 ; k < 21 ; k++){
//          	    	for(var k = 0 ; k < 22 ; k++){
                		HeadTitle0 +=  "|" + weekArr[i];
                		HeadTitle1 +=  "|" + ValuArr01[k];   
            			HeadTitle2 +=  "|" + ValuArr02[k];   
            			HeadTitle3 +=  "|" + ValuArr03[k];   
            		}
	            }
	           
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle0, true);
                InitHeadRow(1, HeadTitle1, true);
                InitHeadRow(2, HeadTitle2, true);
                InitHeadRow(3, HeadTitle3, true);
                
                
				var cnt = 0;
	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		        InitDataProperty(0, cnt++ , dtData,       100,   daCenter,  true,     "rlane_cd",     false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtHidden ,    30,    daCenter,  true,     "level",        false,          "",      dfNone,      0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "aq_cd",       false,          "",      dfNone,      0,     true,       true,          30);
                
                InitDataProperty(0, cnt++ , dtHidden,       90,    daCenter,  true,     "sub_trd_cd",         false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtHidden,       90,    daCenter,  true,     "lane",         false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtHidden,       90,    daCenter,  true,     "bound",         false,          "",      dfNone,      0,     true,       true,          30);
                
                
                if(formObj.viewDiv.value =="OFFICE"){
                InitDataProperty(0, cnt++ , dtData,       90,    daCenter,  true,     "ofc_cd",         false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtData,       90,    daCenter,  true,     "port",         false,          "",      dfNone,      0,     true,       true,          30);
                }else if(formObj.viewDiv.value =="PORT"){
                InitDataProperty(0, cnt++ , dtData,       90,    daCenter,  true,     "port",         false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtData,       90,    daCenter,  true,     "ofc_cd",         false,          "",      dfNone,      0,     true,       true,          30);
                }
                
                var sCol = cnt;
                 
	            for(var j = 1 ; j < weekArr.length+1 ; j++){
	            	var m =1;
	            	
	            	// QAT : 1
	            	InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "qta"+m+j,     false,          "",       dfInteger,       0,     true,       true);
		            	            	
	            	// Alloc : 2
	            	InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "alc"+m+j,   	false,          "",       dfInteger,       0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "alc_rf"+m+j,   false,          "",       dfInteger,       0,     true,       true);
		            
		         	
		        	// VVD
	            	InitDataProperty(0, cnt++ , dtHidden,    50,    daRight ,   true,    "VVD"+m+j,   false,          "",       dfNone,       0,     true,       true);
	  			
		            // BKG : 7 
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "bkg"+m+j,   false,          "",       dfInteger,       0,     true,       true);
		          	 
		            
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "bkg_20"+m+j,   false,          "",       dfInteger,       0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "bkg_40"+m+j,   false,          "",       dfInteger,       0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "bkg_d2"+m+j,   false,          "",       dfInteger,       0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "bkg_d4"+m+j,   false,          "",       dfInteger,       0,     true,       true);
				    InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "bkg_hc"+m+j,   false,          "",       dfInteger,       0,     true,       true);
				    InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "bkg_rd"+m+j,   false,          "",       dfInteger,       0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "bkg_45"+m+j,   false,          "",       dfInteger,       0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "bkg_53"+m+j,   false,          "",       dfInteger,       0,     true,       true);
		             
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "bkg_rf"+m+j,   false,          "",       dfInteger,       0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "bkg_r2"+m+j,   false,          "",       dfInteger,       0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "bkg_r5"+m+j,   false,          "",       dfInteger,       0,     true,       true);
		               
		            // CNTR : 3
//		            InitDataProperty(0, cnt++ , dtHidden ,    50,    daRight ,   true,    "cm_en"+m+j,    false,          "",       dfInteger,       0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "cm_op"+m+j,    false,          "",       dfInteger,       0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "cm_oc"+m+j,    false,          "",       dfInteger,       0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "cm_vl"+m+j,    false,          "",       dfInteger,       0,     true,       true);
		           
		            // Perf : 2
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "pref"+m+j,     false,          "",       dfNone,       0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "pref_rf"+m+j,  false,          "",       dfNone,       0,     true,       true);
				                	            	  
	            }
	           
	            sheetObj.RangeBackColor(1, 8, 3, columnCount-1)  = RgbColor(222, 251, 248);	// 조회 후 Header 색 변경
	            
	            //sheetObj.RangeBackColor(1, 6, 3, columnCount)  = RgbColor(222, 251, 248);
	            InitTreeInfo(1, "level", RgbColor(0,0,0), false);           
				HeadRowHeight = 21 ; 
	       }
	       
	       
	       // add : View 부분 설정
	       setSheet6View();
		  
	}
	
	/**
     * TabSheet5에서 조회후 타이틀 변경
     * Alloc&PFMC status by S.REP
     */
	function initSheet7(sheetObj, strCrrs, strVvds, strPortV){ 
    	 
	       with (sheetObj) {
	       		Reset();
	            // 높이 설정
	            //style.height = getSheetHeight(17) ;
	            //전체 너비 설정
	            SheetWidth = mainTable.clientWidth;
	
	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msPrevColumnMerge;
	
	            //전체Edit 허용 여부 [선택, Default false]
	            Editable = false;
	            FocusEditMode = default_edit_mode;
	
	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo( 4, 1, 5, 100);
				
	            var crrArr = strCrrs.split(",");
	            var vvdArr = strVvds.split(",");
	            
	            var columnCount = 7 + (crrArr.length) * 9;
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(columnCount + 4, 7, 0, true);
	
	            // 해더에서 처리할 수 있는 각종 기능을 설정한다([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
	            InitHeadMode(false, true, false, true, false,false) ;
	            
	            var HeadTitle0 = "";
	        	var HeadTitle1 = "";
	        	
	            HeadTitle0 = "Date|LANE|LANE|LANE|LANE|LANE|LANE";
	            HeadTitle1 = "Date|VVD|VVD|VVD|VVD|VVD|VVD";
	        	HeadTitle2 = "Date|Office|S.REP|ACCT|ACCT|POL|POD";

	        	var HeadTitle3 = HeadTitle2;
	            var ItemArr = new Array("F'cast", "BKG", "PFMC");
	            var ValueArr = new Array("TTL", "20", "40");
	            var ItemTitle = "";
	            
	            for(var i = 0 ; i < crrArr.length ; i++){     
          	    	for(var k = 0 ; k < 9 ; k++){
                		HeadTitle0 = HeadTitle0+ "|" + crrArr[i];
                		HeadTitle1 = HeadTitle1+ "|" + vvdArr[i];
                		HeadTitle2 = HeadTitle2+ "|" + ItemArr[parseInt(k/3)];   
            			HeadTitle3 = HeadTitle3+ "|" + ValueArr[k%3];
            		}
	            }
	            
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle0, true);
                InitHeadRow(1, HeadTitle1, true);
                InitHeadRow(2, HeadTitle2, true);
                InitHeadRow(3, HeadTitle3, true);
                
				var cnt = 0;
	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,     "bse_dt",       false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,     "ofc_cd",       false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtData ,      120,   daCenter,  true,     "srep_nm",      false,          "",      dfNone,      0,     true,       true);
                InitDataProperty(0, cnt++ , dtHidden,     90,    daCenter,  true,     "cust_cd",      false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtData,       90,    daCenter,  true,     "ctrt_cust_cd", false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,     "pol_cd",       false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,     "pod_cd",       false,          "",      dfNone,      0,     true,       true,          30);
                
	            for(var j = 1 ; j < crrArr.length+1 ; j++){
	            	var m =1;
	            	InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "fcast_ttl"+m+j,  false,          "",       dfNone,      0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "fcast_20"+m+j,   false,          "",       dfNone,      0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "fcast_40"+m+j,   false,          "",       dfNone,      0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "bkg_ttl"+m+j,    false,          "",       dfNone,      0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "bkg_20"+m+j,     false,          "",       dfNone,      0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "bkg_40"+m+j,     false,          "",       dfNone,      0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "pref_ttl"+m+j,   false,          "",       dfNone,      0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "pref_20"+m+j,    false,          "",       dfNone,      0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "pref_40"+m+j,    false,          "",       dfNone,      0,     true,       true);
				}
	            
                InitDataProperty(0, cnt++ , dtHidden,       80,    daCenter,  true,     "gid",       false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtHidden,       80,    daCenter,  true,     "lvl",       false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true,     "level",     false,          "",      dfNone,      0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,         20,    daCenter,  true,     "",          false,          "",      dfNone,      0,     true,       true,          30);
				
	            sheetObj.RangeBackColor(1, 7, 1, columnCount)  = RgbColor(222, 232, 247);
	            sheetObj.RangeBackColor(2, 7, 3, columnCount)  = RgbColor(222, 251, 248);
	            InitTreeInfo("level", "level", RgbColor(0,0,0), false);           
                HeadRowHeight = 20 ;
				HeadRowHeight = 21 ; 
	       }
	}
	
	/**
	 * TabSheet6에서 조회후 타이틀 변경
	 * FCST*BKG PFMC by S.Office
	 */
	function initSheet8(sheetObj, hdrStr){ 
		
		with (sheetObj) {
			Reset();
			// 높이 설정
			//style.height = getSheetHeight(17) ;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge;
			
			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;
			FocusEditMode = default_edit_mode;
	           CountPosition = 0;	//페이지카운트 없애기 
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 3, 1, 5, 100);
			
			var HeadArr = new Array("SELSC Total", "PUSBS Total", "한국지점 Total");
			var TeamArr = new Array("SELSCA/E/R", "SELBK", "SELBS", "Total", " ", " ");
			var ItemArr = new Array("QTA", "전일", "금일", "달성률");
			
			var columnCount = 4 + (TeamArr.length) * 4;
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(columnCount + 4, 4, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
			InitHeadMode(false, true, false, true, false,false) ;
			
			var HeadTitle0 = "";
			var HeadTitle1 = "";
			var HeadTitle2 = "";
			
			HeadTitle0 = hdrStr;
			HeadTitle1 = HeadTitle0;
			HeadTitle2 = HeadTitle0;
			
			for(var i = 0 ; i < 6 ; i++){
				for(var j = 0 ; j < 4 ; j++){   
					HeadTitle0 = HeadTitle0 + "|" + HeadArr[i>3?i-3:parseInt(i/4)]; 
					HeadTitle1 = HeadTitle1 + "|" + TeamArr[i]; 
					HeadTitle2 = HeadTitle2 + "|" + ItemArr[j];   
				}
				
				if(i == 3 || i == 4 || i == 5){
					HeadTitle0 = HeadTitle0+ "|" + " ";
					HeadTitle1 = HeadTitle1+ "|" + "Alloc";
					HeadTitle2 = HeadTitle2+ "|" + " ";
				}
			}
			
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle0, true);
			InitHeadRow(1, HeadTitle1, true);
			InitHeadRow(2, HeadTitle2, true);
			
			var cnt = 0;
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHidden,     60,    daCenter,  true,     "trd_cd",       false,          "",      dfNone,      0,     true,       false,          30);
			InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,     "rlane_cd",     false,          "",      dfNone,      0,     true,       false,          30);
			InitDataProperty(0, cnt++ , dtData ,      100,   daCenter,  true,     "vvd",          false,          "",      dfNone,      0,     true,       false);
			InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,     "bkg_flg",      false,          "",      dfNone,      0,     true,       false,          30);
			
			for(var j = 1 ; j < TeamArr.length+1 ; j++){
				var m =1;
				InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "qta"+j,       false,          "",       dfInteger,  0,     true,       false);
				InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "prev"+j,      false,          "",       dfInteger,  0,     true,       false);
				InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "fcast"+j,     false,          "",       dfInteger,  0,     true,       false);
				InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "pfmc"+j,      false,          "",       dfNone,     0,     true,       false);
				
				if(j == 4 || j == 5 || j == 6){
					InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "alc"+j,   false,          "",       dfInteger,  0,     true,       false);
				}
			}
			InitDataProperty(0, cnt++ , dtData,         20,    daCenter,  true,     "",              false,        "",       dfNone,     0,     true,       false,          30);
			
			sheetObj.RangeBackColor(2, 5, 2, columnCount)  = RgbColor(222, 251, 248);
			HeadRowHeight = 20 ;
			HeadRowHeight = 21 ; 
		}
	}
	
	/**
     * TabSheet4에서 조회후 타이틀 변경
     * Adjusted allocation status
     */
	function initSheet3(sheetObj, strWeeks, strFdTds, strPortV){ 
    	 
	       with (sheetObj) {
	       		Reset();
	            // 높이 설정
	            //style.height = getSheetHeight(17) ;
	            //전체 너비 설정
	            SheetWidth = mainTable.clientWidth;
	
	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msPrevColumnMerge;
	
	            //전체Edit 허용 여부 [선택, Default false]
	            Editable = false;
	            FocusEditMode = default_edit_mode;
	
	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo( 4, 1, 5, 100);
				
	            var weekArr = strWeeks.split("|");
	            var fdtdArr = strFdTds.split("|");
	            
	            var columnCount = 5 + (weekArr.length) *5;
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(columnCount + 1, 5 , 0, true);
	
	            // 해더에서 처리할 수 있는 각종 기능을 설정한다([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
	            InitHeadMode(false, true, false, true, false,false) ;
	            
	            var HeadTitle0 = "";
	        	var HeadTitle1 = "";
	        	
				if(strPortV=="O"){	
		            HeadTitle0 = "Dest.|Sub Trade\n/Lane|||";
		        	HeadTitle1 = "Dest.|Sub Trade\n/Lane||Area|Load Office";
				}else{
					HeadTitle0 = "Dest.|Sub Trade\n/Lane|||";
		        	HeadTitle1 = "Dest.|Sub Trade\n/Lane||Port|Load Office";
				}
				
				var HeadTitle2 = HeadTitle0;
	            var HeadTitle3 = HeadTitle0;
	            var WeekTitle = "";
	            var FdTdTitle = "";
	            var Title3 = "";
//    	            var ItemArr = new Array("Vol/Teu.", "G.RPB/USD", "CMB/USD", "G.Rev/1000USD", "CM/1000USD");
	            var ItemArr = new Array("Vol/Teu.");
	            var ValuArr = new Array("QTA", "F'cast", "Alloc", "BKG", "Perf");
	            var ItemTitle = "";
	            
	            for(var i = 0 ; i < weekArr.length ; i++){      
          	    	for(var k = 0 ; k < 5 ; k++){
                		HeadTitle0 = HeadTitle0+ "|" + weekArr[i];
                		HeadTitle1 = HeadTitle1+ "|" + fdtdArr[i];   
            			HeadTitle2 = HeadTitle2+ "|" + ItemArr[0];
            			HeadTitle3 = HeadTitle3+ "|" + ValuArr[k];
            		}
	            }

	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle0, true);
                InitHeadRow(1, HeadTitle1, true);
                InitHeadRow(2, HeadTitle2, true);
                InitHeadRow(3, HeadTitle3, true);
                
				var cnt = 0;
	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,     "dest",         false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtData,       100,   daCenter,  true,     "rlane_cd",     false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtHidden ,    30,    daCenter,  true,     "level",        false,          "",      dfNone,      0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,       90,    daCenter,  true,     "area",         false,          "",      dfNone,      0,     true,       true,          30);
                InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "ofc_cd",       false,          "",      dfNone,      0,     true,       true,          30);
                     
                var sCol = cnt;
                
	            for(var j = 1 ; j < weekArr.length+1 ; j++){
	            	var m =1;
	            	InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "qta"+m+j,     false,          "",       dfInteger,       0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "fcast"+m+j,   false,          "",       dfInteger,       0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "alloc"+m+j,   false,          "",       dfInteger,       0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "bkg"+m+j,     false,          "",       dfInteger,       0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "pref"+m+j,    false,          "",       dfNone,          1,     true,       true);
				}
				var eCol = cnt;
				for(var n = sCol ; n < eCol ; n++){
					ColHidden(n) = true;
				}
				
	            sheetObj.RangeBackColor(1, 5, 3, columnCount-1)  = RgbColor(222, 251, 248);	// 조회 후 Header 색 변경
	            InitTreeInfo(2, "level", RgbColor(0,0,0), false);
                HeadRowHeight = 20 ;
				HeadRowHeight = 21 ; 
				RowHidden(2) = true;
	       }
	}
	
	/**
     * TabSheet8에서 조회후 타이틀 변경
     * FCST&PFMC Status by ACCT
     */
	function initSheet11(sheetObj, strWeeks, strFdTds, viewType, itemView){ 
    	 
	       with (sheetObj) {
	       		Reset();
	            // 높이 설정
//	            style.height = getSheetHeight(25) ;
	            //전체 너비 설정
	            SheetWidth = mainTable.clientWidth;
	
	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msPrevColumnMerge;
	
	            //전체Edit 허용 여부 [선택, Default false]
	            Editable = false;
	            FocusEditMode = default_edit_mode;
	
	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo(4, 1, 5, 100);
				
	            var weekArr = strWeeks.split("|");
	            var fdtdArr = strFdTds.split("|");
	            
	            var columnCount = 16 + (weekArr.length) *8;//
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(columnCount + 4, 12, 0, true);
	
	            // 해더에서 처리할 수 있는 각종 기능을 설정한다([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
	            InitHeadMode(false, true, false, true, false,false) ;
	            
	            var HeadTitle0 = "";
	        	var HeadTitle1 = "";
	        	
				if(viewType=="ACCT"){
		            HeadTitle0 = "Trade|G/ACCT|G/ACCT|CUST_GRP_ID|Type|Yield\nGroup|I/ACCT|CUST_NO|S/C No.|RFA#|BCO/NVO|C.OFC|Load\nOffice|Sub\nTrade|Lane|AVG";
		        	HeadTitle1 = "Trade|G/ACCT|G/ACCT|CUST_GRP_ID|Type|Yield\nGroup|I/ACCT|CUST_NO|S/C No.|RFA#|BCO/NVO|C.OFC|Load\nOffice|Sub\nTrade|Lane|AVG";
				}else{
					HeadTitle0 = "Trade|Load\nOffice|Sub\nTrade|Lane|Yield\nGroup|G/ACCT|CUST_GRP_ID|Type|ACCT\nClass|I/ACCT|CUST_NO|S/C No.|RFA#|BCO/NVO|C.OFC|AVG";
		        	HeadTitle1 = "Trade|Load\nOffice|Sub\nTrade|Lane|Yield\nGroup|G/ACCT|CUST_GRP_ID|Type|ACCT\nClass|I/ACCT|CUST_NO|S/C No.|RFA#|BCO/NVO|C.OFC|AVG";
				}
				
				var HeadTitle2 = HeadTitle0;
	            var HeadTitle3 = HeadTitle0;
	            var WeekTitle  = "";
	            var FdTdTitle  = "";
	            var Title3     = "";
	            
	            var ItemArr   = new Array("Vol/Teu.");
	            var ValuArr   = new Array("VVD", "GUIDE", "FCST", "BKG", "CM", "CMB", "C.FCST", "LOAD%");
	            var ItemTitle = "";
	            
	            for(var i = 0 ; i < weekArr.length ; i++){      
          	    	for(var k = 0 ; k < 8 ; k++){//
                		HeadTitle0 = HeadTitle0+ "|" + weekArr[i];
                		HeadTitle1 = HeadTitle1+ "|" + fdtdArr[i];   
            			HeadTitle2 = HeadTitle2+ "|" + ItemArr[0];
            			HeadTitle3 = HeadTitle3+ "|" + ValuArr[k];
            		}
	            }
	            
        		HeadTitle0 = HeadTitle0+ "|ch|ch2|gc|";
        		HeadTitle1 = HeadTitle1+ "|ch|ch2|gc|";
    			HeadTitle2 = HeadTitle2+ "|ch|ch2|gc|";
    			HeadTitle3 = HeadTitle3+ "|ch|ch2|gc|";

	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle0, true);
                InitHeadRow(1, HeadTitle1, true);
                InitHeadRow(2, HeadTitle2, true);
                InitHeadRow(3, HeadTitle3, true);
                
				var cnt = 0;
	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

				InitDataProperty(0, cnt++ , dtHidden,     60,    daCenter,  true,     "trd_cd"     ,     false,          "",      dfNone,      0,     true,       true,          30);
				if(viewType=="LOFC"){
					InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,     "l_ofc_cd"   ,     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,     "sub_trd"    ,     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "rlane_cd"   ,     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,     "cust_ctrl_cd",     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,       100,   daLeft,    true,     "g_acct"     ,     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,     "cust_grp_id"       ,     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,     "type"       ,     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,       45,    daCenter,  true,     "g_grp"      ,     false,          "",      dfNone,      0,     true,       true,          30);
				}else{
					InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  true,     "g_grp"      ,     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,       100,   daLeft,    true,     "g_acct"     ,     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,     "cust_grp_id"       ,     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,     "type"       ,     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,     "cust_ctrl_cd",     false,          "",      dfNone,      0,     true,       true,          30);
				}
				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,    true,     "i_acct"     ,     false,          "",      dfNone,      0,     true,       true,          30);
				InitDataProperty(0, cnt++ , dtHidden,     60,    daCenter,    true,     "cust_no"     ,     false,          "",      dfNone,      0,     true,       true,          30);
				InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,     "sc_no"      ,     false,          "",      dfNone,      0,     true,       true,          30);
				InitDataProperty(0, cnt++ , dtData,       75,    daCenter,  true,     "rfa_no"     ,     false,          "",      dfNone,      0,     true,       true,          30);
				InitDataProperty(0, cnt++ , dtCombo,      70,    daCenter,  true,     "cust_tp"    ,     false,          "",      dfNone,      0,     true,       true,          30);
				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,     "c_ofc_cd"   ,     false,          "",      dfNone,      0,     true,       true,          30);
				if(viewType=="ACCT"){
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,     "l_ofc_cd"   ,     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,     "sub_trd"    ,     false,          "",      dfNone,      0,     true,       true,          30);
					InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "rlane_cd"   ,     false,          "",      dfNone,      0,     true,       true,          30);
				}
				if(itemView=="1"){
					InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "avg_wk" +1+1,   false,          "",       dfInteger,       0,     true,       true);
				}else{
					InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "avg_wk" +1+1,   false,          "",       dfFloat,         1,     true,       true);
				}
                var sCol = cnt;

	            for(var j = 1 ; j < weekArr.length+1 ; j++){
	            	var m =1;
	            	//cm, cmb, ratio추가
	            	InitDataProperty(0, cnt++ , dtData,     75,    daCenter,   true,    "vvd"    +m+j,   false,          "",       dfNone   ,       0,     true,       true,          30);
	            	if(itemView=="1"){
		            	InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "max"    +m+j,   false,          "",       dfInteger,       0,     true,       true);
			            InitDataProperty(0, cnt++ , dtData ,    70,    daRight ,   true,    "fcast"  +m+j,   false,          "",       dfInteger,       0,     true,       true);
			            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "bkg"    +m+j,   false,          "",       dfInteger,       0,     true,       true);
			            InitDataProperty(0, cnt++ , dtData ,    80,    daRight ,   true,    "cm"    +m+j,   false,          "",       dfInteger,       0,     true,       true);
			            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "cmb"    +m+j,   false,          "",       dfInteger,       0,     true,       true);
//			            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "avg_wk" +m+j,   false,          "",       dfInteger,       0,     true,       true);
			            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "cfcast" +m+j,   false,          "",       dfInteger,       0,     true,       true);
			            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "ratio"    +m+j,   false,          "",       dfInteger,       0,     true,       true);
	            	}else {
	            		InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "max"    +m+j,   false,          "",       dfFloat,         1,     true,       true);
	            		InitDataProperty(0, cnt++ , dtData ,    70,    daRight ,   true,    "fcast"  +m+j,   false,          "",       dfFloat,         1,     true,       true);
	            		InitDataProperty(0, cnt++ , dtData ,    70,    daRight ,   true,    "bkg"    +m+j,   false,          "",       dfFloat,         1,     true,       true);
			            InitDataProperty(0, cnt++ , dtData ,    70,    daRight ,   true,    "cm"    +m+j,   false,          "",       dfInteger,       0,     true,       true);
			            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "cmb"    +m+j,   false,          "",       dfInteger,       0,     true,       true);
//	            		InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "avg_wk" +m+j,   false,          "",       dfFloat,         1,     true,       true);
	            		InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "cfcast" +m+j,   false,          "",       dfFloat,         1,     true,       true);
			            InitDataProperty(0, cnt++ , dtData ,    50,    daRight ,   true,    "ratio"    +m+j,   false,          "",       dfNullInteger,       0,     true,       true);
	            	}
				}
	            
                InitDataProperty(0, cnt++ , dtCheckBox ,  20,    daCenter,  true,     "ch",   false,          "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtCheckBox ,  20,    daCenter,  true,     "ch2",   false,          "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtCheckBox ,  20,    daCenter,  true,     "gc",   false,          "",      dfNone,      0,     false,       false);
                ColHidden(cnt-3) = true;
                ColHidden(cnt-2) = true;
                ColHidden(cnt-1) = true; 
				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,     "dd"   ,     false,          "",      dfNone,      0,     true,       true,          30);

                
	            InitDataCombo(0, "cust_tp", "BCO|NVO", "BO|NO");
	            sheetObj.RangeBackColor(1, 5, 3, columnCount-1)  = RgbColor(222, 251, 248);	// 조회 후 Header 색 변경
	            
                HeadRowHeight = 20 ; 
				RowHidden(2) = true;
	       }
	}
	
	var allocHide = false;
	/**
	 * Allocation 체크박스 숨김처리
	 * HO, RHQ, 지점에서만 확인가능
	 */
	function hideAlloc(){
		allocHide = true;
		check_alloc_div.style.display  = "none";
		check_alloc_div2.style.display = "none";
		check_alloc_div3.style.display = "none";
	}		
	
	/**
	 * item2선택시 컬럼 display
	 */
	function changeColum2(obj){
		if(check_retrive && tab_retrives[0]){
			var sheetObj = sheetObjects[0];

	    	sheetObj.Redraw = false;
	    	chagneSheet2(sheetObj);
	    	sheetObj.Redraw = true; 
		} 	
	}
	
	/*
	 * item3선택시 컬럼 display
	 */
	function changeColum3(obj){
		if(check_retrive && tab_retrives[1]){
			var sheetObj = sheetObjects[1];

	    	sheetObj.Redraw = false;
	    	chagneSheet3(sheetObj);
	    	sheetObj.Redraw = true; 
		} 	
	}
	
	/*
 	 * SHKIM item4선택시 컬럼 display
 	 */
 	function changeColum4(obj){
 		if(check_retrive && tab_retrives[2]){
 			var sheetObj = sheetObjects[2];

 	    	sheetObj.Redraw = false;
 	    	sheetObj.Redraw = true; 
 		} 	
 	}
	
	/*
	 * item5선택시 컬럼 display
	 */
	function changeColum5(obj){
		if(check_retrive && tab_retrives[3]){
			var sheetObj = sheetObjects[3];

	    	sheetObj.Redraw = false;
	    	chagneSheet5(sheetObj);
	    	sheetObj.Redraw = true; 
		} 	
	}
	
	/*
	 * item6선택시 컬럼 display
	 * Add 2012.08.08.
	 */
	function changeColum6(obj){
			
		if(check_retrive && tab_retrives[4]){
			var sheetObj = sheetObjects[4];

	    	sheetObj.Redraw = false;
	    	chagneSheet6(sheetObj);
	    	sheetObj.Redraw = true; 
	    	
		} 	
	}
	
	/*
	 * item11선택시 컬럼 display
	 * Add 2012.11.16.
	 */
	function changeColum11(obj){
		
		if(check_retrive && tab_retrives[8]){
			var sheetObj = sheetObjects[10];

	    	sheetObj.Redraw = false;
	    	chagneSheet11(sheetObj);
	    	sheetObj.Redraw = true; 
	    	
		} 	
	}
	
	
	/**
	 * 체크박스 선택시 showWgtLf2 컬럼을 보여줄지 여부
	 */
	function showWgtLf2(){    	
    	var sheetObj = sheetObjects[0];
		var formObj = document.form;
        var item2 = "1";
        var week1 = sheetObj.EtcData("week");
    	if(week1 == undefined){
    		week1='||';
    	}
        var weekArr = week1.split("|");
        var wlen = weekArr.length;
    	var type = formObj.check_wgt2.checked;
    	
    	for(var j = 1 ; j <= wlen ; j++){
    		sheetObj.ColHidden("prf" + item2 + j) = !type;
    	}
    }
	
    /**
	 * 체크박스 선택시 Allocation 컬럼을 보여줄지 여부
	 */
	function showAlloc2(obj){    	
    	var sheetObj = sheetObjects[0];
		var formObj = document.form;
        var item2 = "1";
        var week1 = sheetObj.EtcData("week");
    	if(week1 == undefined){
    		week1='||';
    	}
        var weekArr = week1.split("|");
        var wlen = weekArr.length;
    	var type = obj.checked;
        hiddenItem2(sheetObj, item2, wlen, false, !type);
    }

	/**
	 * 체크박스 선택시 Allocation 컬럼을 보여줄지 여부
	 */
	function showAlloc3(obj){    	
    	var sheetObj = sheetObjects[2];
		var formObj = document.form;
        var item3 = "1";
        var week1 = sheetObj.EtcData("week");
    	if(week1 == undefined){
    		return;
    	}            
        var weekArr = week1.split("|");
        var wlen = weekArr.length;
    	var type = obj.checked;
        hiddenItem2(sheetObj, item3, wlen, false, !type);
    }
 	
	
	function showWgtLf5(){    	
    	var sheetObj = sheetObjects[1];
		var formObj = document.form;
        var item2 = "1";
        var week1 = sheetObj.EtcData("week");
    	if(week1 == undefined){
    		week1='||';
    	}
        var weekArr = week1.split("|");
        var wlen = weekArr.length;
        var type5 = formObj.check_wgt5.checked;

    	for(var j = 1 ; j <= wlen ; j++){
    		sheetObj.ColHidden("prf" + item2 + j) = !type5;
    	}
    }
    /**
	 * 체크박스 선택시 Allocation 컬럼을 보여줄지 여부
	 */
	function showAlloc5(obj){    	
    	var sheetObj = sheetObjects[1];
		var formObj = document.form;
        var item5 = "1";
        var week1 = sheetObj.EtcData("week");
    	if(week1 == undefined){
    		week1='||';
    	}
        var weekArr = week1.split("|");
        var wlen = weekArr.length;
    	var type = obj.checked;
        hiddenItem2(sheetObj, item5, wlen, false, !type);
    }
	
    
	/*
	 * hidden 컬럼 설정
	 */
	var oldItem = "0";
	function hiddenItem2(sheetObj, item, wlen, sts, aloc){
		if(item == "0") return;
		
    	for(var j = 1 ; j <= wlen ; j++){
    		sheetObj.ColHidden("qta" + item + j) = sts;
    		sheetObj.ColHidden("fcast" + item + j) = sts;
    		sheetObj.ColHidden("alloc" + item + j) = allocHide?true:(sts || aloc);
    		sheetObj.ColHidden("bkg" + item + j) = sts;
    		sheetObj.ColHidden("pref" + item + j) = sts;
    		
    	}
	}
	
	/**
	 * Allocation 컬럼을 보여줄지 여부
	 */
	function chagneSheet2(sheetObj, week1){
		var formObj = document.form;
        var item2 = "1";
        if(week1 == undefined){
	        week1 = sheetObj.EtcData("week");
	    }
        var weekArr = week1.split("|");
        var wlen = weekArr.length;
        hiddenItem2(sheetObj, oldItem, wlen, true, true);
        hiddenItem2(sheetObj, item2, wlen, false, !formObj.check_alloc.checked);
		oldItem = item2;
	}
	
	/**
	 * Allocation 컬럼을 보여줄지 여부
	 */
	function chagneSheet3(sheetObj, week1){
		var formObj = document.form;
        var item3 = "1";
        if(week1 == undefined){
	        week1 = sheetObj.EtcData("week");
	    }
        var weekArr = week1.split("|");
        var wlen = weekArr.length;
        hiddenItem2(sheetObj, oldItem, wlen, true, true);
        hiddenItem2(sheetObj, item3, wlen, false, !formObj.check_alloc2.checked);
		oldItem = item3;
	}
	
	/**
	 * Allocation 컬럼을 보여줄지 여부
	 */
	function chagneSheet5(sheetObj, week1){
		
		var formObj = document.form;
        var item5 = "1";
        if(week1 == undefined){
	        week1 = sheetObj.EtcData("week");
	    }
        var weekArr = week1.split("|");
        var wlen = weekArr.length;
        hiddenItem2(sheetObj, oldItem, wlen, true, true);
        hiddenItem2(sheetObj, item5, wlen, false, !formObj.check_alloc4.checked);
		oldItem = item5;
	}
	

	/**
	 * Allocation 컬럼을 보여줄지 여부
	 * Add 2012.08.08.
	 */
	function chagneSheet6(sheetObj, week1){
		
		var formObj = document.form;
        var item6 = "1";
        if(week1 == undefined){
	        week1 = sheetObj.EtcData("week");
	    }
        var weekArr = week1.split("|");
        var wlen = weekArr.length;
		oldItem = item6;
	}
	
	/**
	 * I/ACCT, VVD 컬럼을 보여줄지 여부
	 */
	function chagneSheet11(sheetObj, week1){
		var formObj = document.form;
        if(sheetObj == undefined){
        	sheetObj = sheetObjects[10];
	    }
        if(week1 == undefined){
	        week1 = sheetObj.EtcData("week");
	    }
       
        //ACCT가 아니면 LOFC를 disabled한다
        if(getRadioValue(document.form.view_type11) == "ACCT") {
        	formObj.check_lofc.disabled = false;
	        //L.OFC가 체크되지 않으면 Lane과 CFcast는 uncheck후 비활성화 시킨다.
	        if(!formObj.check_lofc.checked) {
	            formObj.check_lane.checked = false;
	            formObj.check_cfcst.checked	= false;
		        formObj.check_lane.disabled = true;
		        formObj.check_cfcst.disabled = true;
	        } else {
		        formObj.check_lane.disabled = false;
		        formObj.check_cfcst.disabled = false;
	        }
        } else {
        	formObj.check_lofc.checked = false;
        	formObj.check_lofc.disabled = true;
        }
      
        if(sheetObj.Rows > 4) { // 조회 내역이 있을 시만 수행
	        var weekArr = week1.split("|");
	        var wlen    = weekArr.length;	        
	        
	        sheetObj.ColHidden("i_acct")   = !formObj.check_acct.checked;		// Individual Account
	        sheetObj.ColHidden("cust_tp")  = !formObj.check_acct_tp.checked;	// Account Type - BCO/NVO
	        sheetObj.ColHidden("c_ofc_cd") = !formObj.check_cfcst.checked;		// Contract Office
	        sheetObj.ColHidden("sc_no")    = !formObj.check_tps.checked;		// S/C No
	        sheetObj.ColHidden("rfa_no")   = !formObj.check_aes.checked;		// RFA
	        
	        
	        for(var j = 1 ; j <= wlen ; j++){
	        	sheetObj.ColHidden("vvd1" + j) 	  = !formObj.check_vvd.checked;		// VVD
	        	sheetObj.ColHidden("cfcast1" + j) = !formObj.check_cfcst.checked;	// Contract Forecast
	        	sheetObj.ColHidden("max1" + j)    = !formObj.check_guide.checked;	// Guide
	        	sheetObj.ColHidden("fcast1" + j)  = !formObj.check_fcst.checked;	// FCAST
	        }
	        
	        var viewType = getRadioValue(document.form.view_type11);
	        var lasts = formObj.check_lane.checked;
	        var gSts = formObj.check_guide.checked;//guide check
	        
	        
	        if(viewType == "ACCT") {
		        //L.OFC
				//ch:L.OFC가 언체크되어있으면 HIDDEN, ch2 체크:L.OFC가 체크되어있으면 HIDDEN
				var lofc = formObj.check_lofc.checked;
				var arrRow = sheetObj.FindCheckedRow("ch").split("|");
				var arrRow2 = sheetObj.FindCheckedRow("ch2").split("|");
				
				for (var idx=0; idx<arrRow.length-1; idx++) {
					sheetObj.RowHidden(arrRow[idx]) = lofc;
				}
			
				for (var idx=0; idx<arrRow2.length-1; idx++) {
					sheetObj.RowHidden(arrRow2[idx]) = !lofc;
				}
	        }
	        
	        // Lane 정보 숨김처리
	        for(var i=4; i<sheetObj.SearchRows + 4; i++){
	        	var lane = sheetObj.CellValue(i, "rlane_cd");
	        	if( ( viewType == "ACCT" && lane != "" && lane.substring(lane.length-3) != "TTL" && sheetObj.CellValue(i, "type") != "Other Detail" && sheetObj.CellValue(i, "g_acct") != "Other (+)")
	        	  || ( viewType == "LOFC" && lane != "" && lane.substring(lane.length-3) != "TTL" && sheetObj.CellValue(i, "type") != "Other Detail")
	        	  )
	        		{	//하단 Guide 숨김처리 안하기 위해 if문 추가

	        			if(ComTrim(sheetObj.CellValue(i, "cust_ctrl_cd")).length<2) sheetObj.RowHidden(i) = !formObj.check_lane.checked;
	        		}
	        	
	        	sheetObj.CellAlign(i,"sc_no") = daCenter;
	        	sheetObj.CellAlign(i,"rfa_no") = daCenter;
	        	sheetObj.CellAlign(i,"cust_tp") = daCenter;
	        	sheetObj.CellAlign(i,"c_ofc_cd") = daCenter;
	        	sheetObj.CellAlign(i,"l_ofc_cd") = daCenter;
	        	sheetObj.CellAlign(i,"sub_trd") = daCenter;
	        	sheetObj.CellAlign(i,"cust_ctrl_cd") = daCenter;

	        	if(ComTrim(sheetObj.CellValue(i, "g_acct")) == 'Guide TTL') {
	        		sheetObj.RowHidden(i) = !gSts;
	        	}
	        	
	        }
	        sheetObj.ColHidden("rlane_cd") = !formObj.check_lane.checked;
	        
        }
	}
	
	/**
	 * Trade 변경시
	 *  - 선택된 Trade에 해당하는 Sub Trade 및 Rev. Lane 정보 가져와서 Combo Box 셋팅
	 */
	function trade_OnChange_t(){
		var formObj = document.form;
		var trade = formObj.trade.Code;

		formObj.subtrade1.Code2 = "";
		formObj.bound.value    = "";
		
		if(trade != null && trade != ''){
    		
			SpcSearchOptionSubTrade("subtrade1",true,false, "", "", formObj.trade.Code);			// 0207 SHKIM
    		SpcSearchOptionLane("rlane1",true,true,'',formObj.trade.Code,'',true);	// 0207 SHKIM
    		
    		document.formSel.f_cmd.value = SEARCHLIST09;
			var param = trade;
			document.formSel.trd_cd.value = trade;
			document.formSel.sub_trd_cd.value = "";
			document.formSel.dir_cd.value = "";
			var rtn1 = sheetObjects[0].GetSearchXml("ESM_SPC_0021GS6.do", FormQueryString(document.formSel));
			
			// TPS 선택시 BCO/NVO, Contract Forecast 체크박스 활성화
			if(trade == "TPS"){
				formObj.check_tps.checked = true;
			} else {
				formObj.check_tps.checked = false;
			}
			
			// AES 선택시 BCO/NVO, Contract Forecast 체크박스 활성화
			if(trade == "AES" || trade == "IAS" ){//2015.03.09 [CHM-201534504]SMP IAS 보완에 따른 FCST 추가 개발 요청
				formObj.check_aes.checked = true;
			} else {
				formObj.check_aes.checked = false;
			}
				
		}
		// [E] 2012.01.19 SHKIM CHECK 가져오기 ..
		RevenueLaneSetting(formObj.trade.Code);      		
		controlCheckBox();    	
		RevenueLaneSetting2(formObj.trade.Code,rtn1);
		
		setGrpAcctNAcct();
	}
	
	/**
	 * Trade 변경시
	 *  - 선택된 Trade에 해당하는 Sub Trade 및 Rev. Lane 정보 가져와서 Combo Box 셋팅
	function trade1_OnChange(){
		var formObj = document.form;
		// [S] 2012.01.19 SHKIM CHECK 가져오기 ..
		var trade = formObj.trade1.Code;

		formObj.bound1.value    = "";
		
		if(trade != null && trade != ''){
    		
    		//SpcSearchOptionSubTrade("subtrade7",true,false, "", "", formObj.trade1.Code);
    		//SpcSearchOptionLane("rlane7",true,true,'',formObj.trade1.Code,'',true);
    		//SpcSearchOptionSubTrade("subtrade8",true,false, "", "", formObj.trade.Code);
    		//SpcSearchOptionLane("rlane8",true,true,'',formObj.trade.Code,'',true);
    		
    		document.formSel.f_cmd.value = SEARCHLIST09;
			var param = trade;
			document.formSel.trd_cd.value = trade;
			document.formSel.sub_trd_cd.value = "";
			document.formSel.dir_cd.value = "";
			var rtn1 = sheetObjects[0].GetSearchXml("ESM_SPC_0021GS6.do", FormQueryString(document.formSel));
		}
		
		// [E] 2012.01.19 SHKIM CHECK 가져오기 ..
		RevenueLaneSetting(formObj.trade1.Code);      		
		controlCheckBox();    		
		RevenueLaneSetting2(formObj.trade1.Code,rtn1);
		
	}
	 */
	
	/**
	 * Sub Trade 변경시
	 * 	- 선택된 Sub Trade에 해당하는 Rev. Lane 정보 Combo Box에 셋팅
	 */
	function subtrade1_OnChange_t(){
		var formObj = document.form;
//    	formObj.item1.value = "1";
    	
    	var trade = formObj.trade.Code;
    	var sub_trd = formObj.subtrade1.Code;
    	var dir_cd = formObj.bound.value;
    	// reset rlane combo
    	if (rlane1_combo_chg        == false){
    		ComOpenWait(true);
    		//reset_rlane_combo("rlane1",false);
    		
    		if(trade == null && trade == ''){
    			ComShowMessage(getMsg("SPC90117", "Trade"));
        		ComOpenWait(false);
    			return;
    		}
    		
			document.formSel.f_cmd.value = SEARCHLIST09;
			var param = trade;
			document.formSel.trd_cd.value = trade;
			document.formSel.sub_trd_cd.value = sub_trd;
			document.formSel.dir_cd.value = dir_cd;
			var rtn1 = sheetObjects[0].GetSearchXml("ESM_SPC_0021GS6.do", FormQueryString(document.formSel));
			
    		// [E] 2012.01.19 SHKIM CHECK 가져오기 ..
    		RevenueLaneSetting(formObj.trade.Code, formObj.subtrade1.Code, beforetab+1);      		
    		controlCheckBox();    		
    		RevenueLaneSetting2(formObj.trade.Code,rtn1);
    		ComOpenWait(false);
    	}
	}
	
	/**
	 * Sub Trade 변경시
	 * 	- 선택된 Sub Trade에 해당하는 Rev. Lane 정보 Combo Box에 셋팅
	
	function subtrade2_OnChange(){
		var formObj = document.form;
		var item2_index = formObj.item2.options.selectedIndex;
    	formObj.item2.value = formObj.item2.options[item2_index].value;
    	
    	var trade = formObj.trade.Code;
    	var sub_trd = formObj.subtrade2.Code;
    	var dir_cd = formObj.bound.value;
    	// reset rlane combo
    	if (rlane2_combo_chg        == false){
    		ComOpenWait(true);
    		//reset_rlane_combo("rlane2",false);
    		
    		if(trade == null && trade == ''){
    			ComShowMessage(getMsg("SPC90117", "Trade"));
    			return;
    			
    		}
			document.formSel.f_cmd.value = SEARCHLIST09;
			var param = trade;
			document.formSel.trd_cd.value = trade;
			document.formSel.sub_trd_cd.value = sub_trd;
			document.formSel.dir_cd.value = dir_cd;
			var rtn1 = sheetObjects[1].GetSearchXml("ESM_SPC_0021GS6.do", FormQueryString(document.formSel));
    		// [E] 2012.01.19 SHKIM CHECK 가져오기 ..
    		RevenueLaneSetting(formObj.trade.Code, formObj.subtrade2.Code, beforetab+1);
    		controlCheckBox();    		
    		RevenueLaneSetting2(formObj.trade.Code,rtn1);
    		ComOpenWait(false);
    	}
    	
	} */
	
	/**
	 * Sub Trade 변경시
	 * 	- 선택된 Sub Trade에 해당하는 Rev. Lane 정보 Combo Box에 셋팅
	 
	function subtrade3_OnChange(){
		var formObj = document.form;
		var item3_index = formObj.item3.options.selectedIndex;
    	formObj.item3.value = formObj.item3.options[item3_index].value;
    	var trade = formObj.trade.Code;
    	var sub_trd = formObj.subtrade3.Code;
    	var dir_cd = formObj.bound.value;
    	// reset rlane combo
    	if (rlane3_combo_chg        == false){
    		ComOpenWait(true);
    		//reset_rlane_combo("rlane3",false);
    		
    		if(trade == null && trade == ''){
    			ComShowMessage(getMsg("SPC90117", "Trade"));
    			return;
    			
    		}
			document.formSel.f_cmd.value = SEARCHLIST09;
			var param = trade;
			document.formSel.trd_cd.value = trade;
			document.formSel.sub_trd_cd.value = sub_trd;
			document.formSel.dir_cd.value = dir_cd;
			var rtn1 = sheetObjects[3].GetSearchXml("ESM_SPC_0021GS6.do", FormQueryString(document.formSel));
    		// [E] 2012.01.19 SHKIM CHECK 가져오기 ..
    		RevenueLaneSetting(formObj.trade.Code, formObj.subtrade3.Code, beforetab+1);   		
    		controlCheckBox();
    		RevenueLaneSetting2(formObj.trade.Code,rtn1);
    		ComOpenWait(false);
    	}        	
	}*/

	/**
	 * Sub Trade 변경시
	 * 	- 선택된 Sub Trade에 해당하는 Rev. Lane 정보 Combo Box에 셋팅
	 
	function subtrade4_OnChange(){
		var formObj = document.form;
		var item4_index = formObj.item4.options.selectedIndex;
		formObj.item3.value = formObj.item4.options[item4_index].value;
		var trade = formObj.trade.Code;
		var sub_trd = formObj.subtrade4.Code;
		var dir_cd = formObj.bound.value;
		// reset rlane combo
		if (rlane4_combo_chg        == false){
			ComOpenWait(true);
			//reset_rlane_combo("rlane3",false);
			
			if(trade == null && trade == ''){
				ComShowMessage(getMsg("SPC90117", "Trade"));
				return;
				
			}
			document.formSel.f_cmd.value = SEARCHLIST09;
			var param = trade;
			document.formSel.trd_cd.value = trade;
			document.formSel.sub_trd_cd.value = sub_trd;
			document.formSel.dir_cd.value = dir_cd;
			var rtn1 = sheetObjects[4].GetSearchXml("ESM_SPC_0021GS6.do", FormQueryString(document.formSel));
			// [E] 2012.01.19 SHKIM CHECK 가져오기 ..
			RevenueLaneSetting(formObj.trade.Code, formObj.subtrade4.Code, beforetab+1);   
			controlCheckBox();  
			RevenueLaneSetting2(formObj.trade.Code,rtn1);
			ComOpenWait(false);
		}        	
		
	}*/
	
	/**
	 * Sub Trade 변경시
	 * 	- 선택된 Sub Trade에 해당하는 Rev. Lane 정보 Combo Box에 셋팅
	 
	function subtrade5_OnChange(){
		var formObj = document.form;
		var item5_index = formObj.item5.options.selectedIndex;
    	formObj.item5.value = formObj.item5.options[item5_index].value;
    	
    	var trade = formObj.trade.Code;
    	var sub_trd = formObj.subtrade5.Code;
    	var dir_cd = formObj.bound.value;
    	// reset rlane combo
    	if (rlane5_combo_chg        == false){
    		ComOpenWait(true);
    		
    		if(trade == null && trade == ''){
    			ComShowMessage(getMsg("SPC90117", "Trade"));
    			return;
    			
    		}
			document.formSel.f_cmd.value = SEARCHLIST09;
			var param = trade;
			document.formSel.trd_cd.value = trade;
			document.formSel.sub_trd_cd.value = sub_trd;
			document.formSel.dir_cd.value = dir_cd;
			var rtn1 = sheetObjects[2].GetSearchXml("ESM_SPC_0021GS6.do", FormQueryString(document.formSel));
    		// [E] 2012.01.19 SHKIM CHECK 가져오기 ..
    		RevenueLaneSetting(formObj.trade.Code, formObj.subtrade5.Code, beforetab+1);     		
    		controlCheckBox();    		
    		RevenueLaneSetting2(formObj.trade.Code,rtn1);
    		ComOpenWait(false);
    	}
    	
	}*/

	/**
	 * Sub Trade 변경시
	 * 	- 선택된 Sub Trade에 해당하는 Rev. Lane 정보 Combo Box에 셋팅
	
	function subtrade6_OnChange(){
		var formObj = document.form;
		var item6_index = formObj.item6.options.selectedIndex;
    	formObj.item6.value = formObj.item6.options[item6_index].value;
    	
    	var trade = formObj.trade.Code;
    	var sub_trd = formObj.subtrade6.Code;
    	var dir_cd = formObj.bound.value;
    	// reset rlane combo
    	if (rlane6_combo_chg        == false){
    		ComOpenWait(true);
    		
    		if(trade == null && trade == ''){
    			ComShowMessage(getMsg("SPC90117", "Trade"));
    			return;
    			
    		}
			document.formSel.f_cmd.value = SEARCHLIST09;
			var param = trade;
			document.formSel.trd_cd.value = trade;
			document.formSel.sub_trd_cd.value = sub_trd;
			document.formSel.dir_cd.value = dir_cd;
			var rtn1 = sheetObjects[2].GetSearchXml("ESM_SPC_0021GS6.do", FormQueryString(document.formSel));
    		// [E] 2012.01.19 SHKIM CHECK 가져오기 ..
    		RevenueLaneSetting(formObj.trade.Code, formObj.subtrade6.Code, beforetab+1);     		
    		controlCheckBox();    		
    		RevenueLaneSetting2(formObj.trade.Code,rtn1);
    		ComOpenWait(false);
    	}
    	
	} */
	
	/**
	 * Add 2012.11.16
	 * Sub Trade 변경시
	 * 	- 선택된 Sub Trade에 해당하는 Rev. Lane 정보 Combo Box에 셋팅
	 
	function subtrade11_OnChange(){
		var formObj = document.form;
    	formObj.item11.value = 1;
    	
    	var trade = formObj.trade.Code;
    	var sub_trd = formObj.subtrade11.Code;
    	var dir_cd = formObj.bound.value;
    	// reset rlane combo
    	if (rlane11_combo_chg        == false){
    		ComOpenWait(true);
    		//reset_rlane_combo("rlane11",false);
    		
    		if(trade == null && trade == ''){
    			ComShowMessage(getMsg("SPC90117", "Trade"));
    			return;
    		}
    		
			document.formSel.f_cmd.value = SEARCHLIST09;
			var param = trade;
			document.formSel.trd_cd.value = trade;
			document.formSel.sub_trd_cd.value = sub_trd;
			document.formSel.dir_cd.value = dir_cd;
			var rtn1 = sheetObjects[10].GetSearchXml("ESM_SPC_0021GS6.do", FormQueryString(document.formSel));
			RevenueLaneSetting(formObj.trade.Code, formObj.subtrade11.Code, beforetab+1);
    		controlCheckBox();
    		RevenueLaneSetting2(formObj.trade.Code,rtn1);
    		ComOpenWait(false);
    	}
    	
	}*/
	
	/**
	 * Sheet1의 조회 후
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		
        var formObj = document.form;
        var item1 = "1";

		week = getEtcDataFromXml(rtn, "week");
	    fdtd = getEtcDataFromXml(rtn, "fdtd");
	    var weekArr = week.split("|");

		for(var j = 1 ; j < weekArr.length+1 ; j++){
			for(var i = 1 ; i < 6 ; i++){
				var sts = (i != item1);
        		sheetObj.ColHidden("qta"+i+j) = sts;
        		sheetObj.ColHidden("fcast"+i+j) = sts;
        		sheetObj.ColHidden("prev"+i+j) = sts;
        		sheetObj.ColHidden("diff"+i+j) = sts;
        		sheetObj.ColHidden("bkg"+i+j) = sts;
        		sheetObj.ColHidden("pref"+i+j) = sts;
			}
		}
	}
	
	/**
	 * Sheet2 조회 후
	 * 	- Office 항목 숨김 및 Allocation 항목 숨김 여부
	 */
	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
        var formObj = document.form;
		changeTitle2(formObj.check_office);//office 및 guide정보 관리(hiddenGuide2)
		chagneSheet2(sheetObj);//allocation 정보관리
		var soSts = formObj.check_suboffice.checked;
		if(soSts){
			sheetObj.ColHidden("sub_ofc_cd") = false;
		}else{
			sheetObj.ColHidden("sub_ofc_cd") = true;
		}
		showWgtLf2();
	}
	
	/**
	 * Sheet3 조회 후
	 * 	- Office 항목 숨김 및 Allocation 항목 숨김 여부
	 */
	function sheet3_OnSearchEnd(sheetObj, ErrMsg){
        var formObj = document.form;
		changeTitle3(formObj.check_office2);
		chagneSheet3(sheetObj);
	}
	
	/**
	 * Sheet4 조회 후
	 * 	- Office 항목 숨김
	 */
	function sheet4_OnSearchEnd(sheetObj, ErrMsg){
		var formObj = document.form;
		changeTitle4(formObj.check_office3);
	}
	
	/**
	 * Sheet5 조회 후
	 * 	- Office 항목 숨김 및 Allocation 항목 숨김 여부
	 */
	function sheet5_OnSearchEnd(sheetObj, ErrMsg){
        var formObj = document.form;
        checkBoxControl5(document.form.check_office5); //changeTitle5(formObj.check_office5);
		chagneSheet5(sheetObj);
		var soSts = formObj.check_suboffice5.checked;
		if(soSts){
			sheetObj.ColHidden("sub_ofc_cd") = false;
		}else{
			sheetObj.ColHidden("sub_ofc_cd") = true;
		}
		showWgtLf5();
	}
	
	
	/**
	 * Sheet6 조회 후
	 * 	- Office 항목 숨김 및 Allocation 항목 숨김 여부
	 */
	function sheet6_OnSearchEnd(sheetObj, ErrMsg){		
		
        var formObj = document.form;
		changeTitle6(formObj.check_office5);
		chagneSheet6(sheetObj);
	 
		 showAlloc6();
		 
		 if(formObj.viewDiv.value =="OFFICE" ){
			 formObj.officeView.checked = true;
			 formObj.portView.checked = false;
			 sheet6OfficeView();
		 }else{
			 formObj.officeView.checked = false;
			 formObj.portView.checked = true;
			 sheet6PortView();  
		 }
	     sheet6TypeView();    
		 sheet6CntrView(); 
		 
	}
	
	/**
	 * Sheet11 조회 후
	 * 	- Other 항목 숨김 및 I/ACCT, VVD 항목 숨김 여부
	 */
	function sheet11_OnSearchEnd(sheetObj, ErrMsg){
        var formObj = document.form;
		chagneSheet11(sheetObj);
        if(sheetObj.RowCount>0){
        	ComBtnEnable("btng_season_grp");
        }else{
        	ComBtnDisable("btng_season_grp");
        }
	}
	
  // Sheet1관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	
    	sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH:      //조회
            	if(validateForm(sheetObj,formObj,sAction)){
					if(formObj.chkViewP.checked){
						formObj.chkview.value="P"; 
					}else{
						formObj.chkview.value="O"; 
					}

                	if (formObj.check_area1.checked ) {
                		formObj.check_area1.value = "Y";
                	} else {
                		formObj.check_area1.value = "N";
                	}  
                	if (formObj.check_area2.checked ) {
                		formObj.check_area2.value = "Y";
                	} else {
                		formObj.check_area2.value = "N";
                	} 
                	if (formObj.check_area3.checked ) {
                		formObj.check_area3.value = "Y";
                	} else {
                		formObj.check_area3.value = "N";
                	}
                	// SHKIM 20120613 S
                	if (formObj.check_area4.checked ) {
                		formObj.check_area4.value = "Y";
                	} else {
                		formObj.check_area4.value = "N";
                	}
                	// SHKIM 20120613 E  
                	if (formObj.check_area5.checked ) {
                		formObj.check_area5.value = "Y";
                	} else {
                		formObj.check_area5.value = "N";
                	}
                	
                	//
                	if (formObj.check_sector2.checked ) {
                		formObj.check_sector2.value = "Y";
                	} else {
                		formObj.check_sector2.value = "N";
                	}
                	//
                	if (formObj.check_sector5.checked ) {
                		formObj.check_sector5.value = "Y";
                	} else {
                		formObj.check_sector5.value = "N";
                	}
                	// 겹선 관련
                	if (formObj.check_vvd1.checked ) formObj.check_vvd1.value = "Y";
                	else formObj.check_vvd1.value = "N";
                	if (formObj.check_vvd2.checked ) formObj.check_vvd2.value = "Y";
                	else formObj.check_vvd2.value = "N";
                	if (formObj.check_vvd3.checked ) formObj.check_vvd3.value = "Y";
                	else formObj.check_vvd3.value = "N";
                	if (formObj.check_vvd4.checked ) formObj.check_vvd4.value = "Y";
                	else formObj.check_vvd4.value = "N";
                	if (formObj.check_vvd5.checked ) formObj.check_vvd5.value = "Y";
                	else formObj.check_vvd5.value = "N";
                	
                    if(beforetab==5){ //F'cast Comparison            	
                    	duration2_from = formObj.duration2_from.value;
                    	duration2_to = formObj.duration2_to.value;
                    	var period = duration2_to - duration2_from;
                    	if(period >= 6 || period <0){
                    		ComShowMessage(getMsg("SPC90200", "Duration2"));
    	    				formObj.duration2_from.focus();
    	    				return false; 
                    	}
                    	if(!formObj.chkViewL.checked){
							formObj.f_cmd.value = SEARCHLIST01;	
                    	}
                    	sheetObjects[5].RemoveAll(); 
	                	sheetObjects[5].Redraw = false;    	                	
	                	
	                	var param = SpcFormString(formObj,'chkview,year,week1,duration,duration2_from,,duration2_to,trade,bound,rhq2,area,sales_office,pol_cd,item1,subtrade1,rlane1,check_alloc,check_alloc2,check_alloc3,check_area1,check_area2,check_area3,check_area4,check_area5,check_dest2,check_dest3,check_dest5');
	                	rtn = sheetObjects[5].GetSearchXml("ESM_SPC_0021GS.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param); //EsmSpc0021ViewAdapter
		
						week = getEtcDataFromXml(rtn, "week");
	                	fdtd = getEtcDataFromXml(rtn, "fdtd");
	                	portv = getEtcDataFromXml(rtn, "portv");

	                	sheetObj.Reset();
	                	initSheet1(sheetObj, week, fdtd, portv, duration2_from, duration2_to);
	                	sheetObj.LoadSearchXml(rtn); 
	                	sheetObjects[5].Redraw = true;	
	                	
	                }else if(beforetab==0){//Allocation Status(HO)
	                	hiddenCheck();
                    	
	                	if(!formObj.chkViewL.checked){
							formObj.f_cmd.value = SEARCHLIST03;	
                    	}
                    	sheetObjects[0].RemoveAll(); 
	                	sheetObjects[0].Redraw = false;
	                	hiddenCheck();
                        var param = SpcFormString(formObj,'chkview,year,week1,duration,trade,bound,rhq2,area,sales_office,pol_cd,item1,subtrade1,rlane1,check_alloc,check_alloc2,check_alloc3,check_area1,check_area2,check_area3,check_area4,check_area5,check_dest2,check_dest3,check_dest5,check_ipi_local,check_dest_ctrl,check_sector2,check_vvd1');
                	    var check_suboffice = "N";
                	    if(formObj.check_suboffice.checked){
                	    	check_suboffice = "Y";
                	    }else{
                	    	check_suboffice = "N";
                	    }
	                	rtn1 = sheetObjects[0].GetSearchXml("ESM_SPC_0021GS2.do", "f_cmd="+ formObj.f_cmd.value+ "&" + "sub_office="+ check_suboffice +"&"+ param); //EsmSpc0021ViewAdapter2
	                	
	                	week1 = getEtcDataFromXml(rtn1, "week");
	                	fdtd1= getEtcDataFromXml(rtn1, "fdtd");
	                	portv1 = getEtcDataFromXml(rtn1, "portv");
	                	
	                	var isSmp = getEtcDataFromXml(rtn1, "isSmp");
	                	
	                	if(isSmp == "true"){
	                		document.form.check_guide2.disabled = (!isSmp=="true"?true:false);
	                	} else {
	                		document.form.check_guide2.disabled = (!isSmp=="true"?false:true);
	                		document.form.check_guide2.checked  = (!isSmp=="true"?true:false);
	                	}
	                	
	                	initSheet2(sheetObj, week1, fdtd1, portv1);
	                	sheetObj.LoadSearchXml(rtn1);
	                	sheetObjects[0].Redraw = true;

	                	hiddenCheck();
	                	
	                } else if(beforetab==1){//Allocation Status(RHQ)
	                	hiddenCheck();
                    	
	                	if(!formObj.chkViewL.checked){
							formObj.f_cmd.value = SEARCHLIST11;	
                    	}
                    	sheetObjects[1].RemoveAll(); 
	                	sheetObjects[1].Redraw = false;
	                	hiddenCheck();
                        var param = SpcFormString(formObj,'chkview,year,week1,duration,trade,bound,rhq2,area,sales_office,pol_cd,item1,subtrade1,rlane1,check_alloc,check_alloc2,check_alloc3,check_area1,check_area2,check_area3,check_area4,check_area5,check_dest2,check_dest3,check_dest5,check_ipi_local2,check_dest_ctrl2,check_sector5,check_vvd2');
                	    var check_suboffice = "N";
                	    if(formObj.check_suboffice5.checked){
                	    	check_suboffice = "Y";
                	    }else{
                	    	check_suboffice = "N";
                	    }
                        rtn1 = sheetObjects[1].GetSearchXml("ESM_SPC_0021GS8.do", "f_cmd="+ formObj.f_cmd.value+ "&" + "sub_office="+ check_suboffice +"&"+ param); //EsmSpc0021ViewAdapter5
	                	
	                	week1 = getEtcDataFromXml(rtn1, "week");
	                	fdtd1= getEtcDataFromXml(rtn1, "fdtd");
	                	portv1 = getEtcDataFromXml(rtn1, "portv");
	                	
	                	var isSmp = getEtcDataFromXml(rtn1, "isSmp");
	                	
	                	if(isSmp == "true"){
	                		document.form.check_guide5.disabled = (!isSmp=="true"?true:false);
	                	} else {
	                		document.form.check_guide5.disabled = (!isSmp=="true"?false:true);
	                		document.form.check_guide5.checked  = (!isSmp=="true"?true:false);
	                	}
	                	
	                	initSheet5(sheetObj, week1, fdtd1, portv1);
	                	sheetObj.LoadSearchXml(rtn1);
	                	sheetObjects[1].Redraw = true;
	                	hiddenCheck();
	                	
	                } else if(beforetab==2){ //Adjusted allocation status
	                	hiddenCheck();
                    	
	                	if(!formObj.chkViewL.checked){
							formObj.f_cmd.value = SEARCHLIST05;
                    	}
                    	sheetObjects[2].RemoveAll(); 
	                	sheetObjects[2].Redraw = false;
	                	hiddenCheck();
	                	
	                	var param = SpcFormString(formObj,'chkview,year,week1,duration,trade,bound,rhq2,area,sales_office,pol_cd,item1,subtrade1,rlane1,check_alloc,check_alloc2,check_alloc3,check_area1,check_area2,check_area3,check_area4,check_area5,check_dest2,check_dest3,check_dest5,check_vvd3');
 	                	
 	                	rtn1 = sheetObjects[2].GetSearchXml("ESM_SPC_0021GS3.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param); //EsmSpc0021ViewAdapter3
	                	
	                	week1 = getEtcDataFromXml(rtn1, "week");
	                	fdtd1= getEtcDataFromXml(rtn1, "fdtd");
	                	portv1 = getEtcDataFromXml(rtn1, "portv");
	                	
	                	initSheet3(sheetObj, week1, fdtd1, portv1);
	                	sheetObj.LoadSearchXml(rtn1); 
	                	sheetObjects[2].Redraw = true;
	                	
	                	hiddenCheck();
	                	
	                }else if(beforetab==3){	// PFMC Ratio VS QTA & BSA
	                	if(!formObj.chkViewL.checked){
							formObj.f_cmd.value = SEARCHLIST10;
                    	}
                    	sheetObjects[3].RemoveAll(); 
	                	sheetObjects[3].Redraw = false;
	                	var param = SpcFormString(formObj,'chkview,year,week1,duration,trade,bound,rhq2,area,sales_office,pol_cd,item1,subtrade1,rlane1,check_alloc,check_alloc2,check_alloc3,check_area1,check_area2,check_area3,check_area4,check_area5,check_dest2,check_dest3,check_dest5,check_vvd4');
	                	
	                	rtn1 = sheetObjects[3].GetSearchXml("ESM_SPC_0021GS7.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param); //EsmSpc0021ViewAdapter4
	                	week1 = getEtcDataFromXml(rtn1, "week");
	                	fdtd1= getEtcDataFromXml(rtn1, "fdtd");
	                	portv1 = getEtcDataFromXml(rtn1, "portv");
	                	
	                	initSheet4(sheetObj, week1, fdtd1, portv1);
	                	sheetObj.LoadSearchXml(rtn1); 
	                	sheetObjects[3].Redraw = true;	

	                //Add 2012.08.08. 	
	                }else if(beforetab==4){	 // BKG Status(RHQ)
	                	
						formObj.f_cmd.value = SEARCHLIST12;
                    	sheetObjects[4].RemoveAll(); 
	                	sheetObjects[4].Redraw = false;
	                	
	                	var param = SpcFormString(formObj,'chkview,year,week1,duration,trade,bound,rhq2,area,sales_office,pol_cd,port_div,rlane1,subtrade1,del_cd,por_cd,check_vvd5');
	                	var URL ="";
	                	
	              	   if(formObj.viewDiv.value =="OFFICE"){
	              		 URL ="ESM_SPC_0021GS9ByOffice.do"; //EsmSpc0021ViewAdapter6ByOffice
	              		
	              	   } else{
	              		 URL ="ESM_SPC_0021GS9ByPort.do"; //EsmSpc0021ViewAdapter6ByPort
	              	   } 
	                	rtn1 = sheetObjects[4].GetSearchXml(URL, "f_cmd="+ formObj.f_cmd.value +"&"+ "viewDiv="+ formObj.viewDiv.value + "&"+param);
	                	week1 = getEtcDataFromXml(rtn1, "week");
	                	fdtd1= getEtcDataFromXml(rtn1, "fdtd");
	                	portv1 = getEtcDataFromXml(rtn1, "portv");
	                	
	                	initSheet6(sheetObj, week1, fdtd1, portv1);
	                	sheetObj.LoadSearchXml(rtn1); 
	                	sheetObjects[4].Redraw = true;	
	                	
	                }else if(beforetab==6){	//Alloc & PFMC Status by S.Rep
	                	
						formObj.f_cmd.value = SEARCHLIST13;
	                	sheetObjects[6].RemoveAll(); 
	                	sheetObjects[6].Redraw = false;
	                	
	                	var param = SpcFormString(formObj,'chkview,from_dt,duration1,rhq1,area1,sales_office1,pol_cd,port_div,srep_cd,trade7,rlane7');
	                	var isToday = formObj.from_dt.value >= init_date?"Y":"N";
	                	
	                	rtn1 = sheetObjects[6].GetSearchXml("ESM_SPC_0021GS10.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param+"&sDate="+isToday); //EsmSpc0021ViewAdapter7
	                	crrList = getEtcDataFromXml(rtn1, "crr");
	                	vvdList = getEtcDataFromXml(rtn1, "vvd");
	                	
	                	initSheet7(sheetObj, crrList, vvdList, "O");
	                	sheetObj.LoadSearchXml(rtn1); 
	                	sheetObjects[6].Redraw = true;
	                	
	                }else if(beforetab==7){	//FCST&BKG PFMC by S.Office
	                	
	                	// 현재 주차 - BKG & Projection
						formObj.f_cmd.value = SEARCHLIST14;
	                	sheetObjects[7].RemoveAll(); 
	                	sheetObjects[7].Redraw = false;
	                	
	                	var param = SpcFormString(formObj,'chkview,from_dt,duration1,rhq1,area1,sales_office1,srep_cd');
	                	rtn1 = sheetObjects[7].GetSearchXml("ESM_SPC_0021GS11.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param+"&viewDiv=T"); //EsmSpc0021ViewAdapter8
	                	
	                	sheetObj.LoadSearchXml(rtn1); 
	                	sheetObjects[7].Redraw = true;
	                	
	                	
	                	// 차주 - Projection
	                	formObj.f_cmd.value = SEARCHLIST14;
	                	sheetObjects[8].RemoveAll(); 
	                	sheetObjects[8].Redraw = false;
	                	
	                	var param = SpcFormString(formObj,'chkview,from_dt,duration1,rhq1,area1,sales_office1,srep_cd');
	                	rtn1 = sheetObjects[8].GetSearchXml("ESM_SPC_0021GS11.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param+"&viewDiv=U"); //EsmSpc0021ViewAdapter8
	                	
	                	sheetObjects[8].LoadSearchXml(rtn1); 
	                	sheetObjects[8].Redraw = true;
	                	
	                	
	                	// 전주 - Booking
	                	formObj.f_cmd.value = SEARCHLIST14;
	                	sheetObjects[9].RemoveAll(); 
	                	sheetObjects[9].Redraw = false;
	                	
	                	var param = SpcFormString(formObj,'chkview,from_dt,duration1,rhq1,area1,sales_office1,srep_cd');
	                	rtn1 = sheetObjects[9].GetSearchXml("ESM_SPC_0021GS11.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param+"&viewDiv=S"); //EsmSpc0021ViewAdapter8
	                	
	                	sheetObjects[9].LoadSearchXml(rtn1); 
	                	sheetObjects[9].Redraw = true;
	                	
	                }else if(beforetab==8){ //FCAST&PFMC Status by ACCT
                        formObj.chkview.value = formObj.item11.value;
                    	
                    	formObj.f_cmd.value = SEARCHLIST15;
                    	
                    	sheetObjects[10].RemoveAll(); 
	                	sheetObjects[10].Redraw = false;
	                	
                        var param = SpcFormString(formObj,'chkview,year,week1,duration,trade,bound,rhq,area,sales_office,pol_cd,subtrade1,rlane1,item11,view_type11,acct,grp_acct,acct_clss,check_smp');
	                	rtn1 = sheetObjects[10].GetSearchXml("ESM_SPC_0021GS12.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param); //EsmSpc0021ViewAdapter9
	                	
	                	week1  = getEtcDataFromXml(rtn1, "week");
	                	fdtd1  = getEtcDataFromXml(rtn1, "fdtd");
	                	portv1 = getRadioValue(document.form.view_type11);
	                	itemv1 = formObj.chkview.value;	                	
	                	initSheet11(sheetObj, week1, fdtd1, portv1, itemv1);
	                	
	                	sheetObj.LoadSearchXml(rtn1);
	                	sheetObjects[10].Redraw = true;

	                }else{
	                	formObj.f_cmd.value = SEARCHLIST07;	
	                	
	                	var param = SpcFormString(formObj,'chkview,year,week1,duration,trade,bound,rhq,area,sales_office,pol_cd,item1,subtrade1,rlane1,check_alloc,check_alloc2,check_area1,check_area2,check_area3,check_dest2,check_dest3');
  	                	
	                	sheetObj.DoSearch4Pos("ESM_SPC_0021GS3.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param); //EsmSpc0021ViewAdapter3
						
	                }
                }
                break;
                
            case SEARCHLIST08:      //Allocation 권한 조회
            	formObj.f_cmd.value = SEARCHLIST08;
            	var param = SpcFormString(formObj,"usr_role_cd");
            	rtn = sheetObjects[0].GetSearchXml("ESM_SPC_0021GS4.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param); //DefaultViewAdapter
            	usrRoleYn = ComGetEtcData(rtn,"usrRoleYn");
            	var rhq_cd = formObj.login_rhq_cd.value;
            	var area   = formObj.area.value;
            	var rgn_cd = formObj.login_rgn_cd.value;
            	var login_ofc_cd = formObj.login_ofc_cd.value;
            	if ( usrRoleYn != 'Y' && rgn_cd != login_ofc_cd ) {	//해당 조건만 alloc 기존대로 보이게
            		hideAlloc();
            	}
            	
            	break;
            	
            case IBDOWNEXCEL:        //엑셀 다운로드
            	if(beforetab==7){
            		sheetObj.Down2Excel(-1);
            		sheetObjects[8].Down2Excel(-1, true);
            		sheetObjects[9].Down2Excel(-1, true);

            	}if(beforetab==8){
            		sheetObjects[10].Down2Excel(-1, true);
            	}else{
            		sheetObj.Down2Excel(-1);
            	}
                break;
                
            case IBSAVE:      //저장
            	if(validateForm(sheetObj,formObj,sAction)){
                	sheetObj.WaitImageVisible=false;
        			//var param = SpcFormString(formObj,'chkview,year,week1,duration,trade,bound,rhq,area,sales_office,pol_cd,item1,subtrade1,rlane1,item2,subtrade2,rlane2,check_office,check_alloc,item3,subtrade3,rlane3,check_office2,check_alloc2,subtrade4,check_area1,check_area2,check_area3,check_dest2,check_dest3');
        			var param = SpcFormString(formObj,'chkview,year,week1,duration,trade,bound,rhq,area,sales_office,pol_cd,item1,subtrade1,rlane1,item2,subtrade2,rlane2,check_alloc,item3,subtrade3,rlane3,check_alloc2,subtrade4,item5,subtrade5,rlane5,check_alloc3,check_area1,check_area2,check_area3,check_area5,check_dest2,check_dest3,check_dest5');
                    
                    formObj.f_cmd.value = MULTI;
                    var sXml = sheetObj.GetSaveXml("ESM_SPC_0021GS5.do", FormQueryString(formObj)); //DefaultViewAdapter
                    if(sXml != null && sXml !=''){ 
                    	ComShowMessage(getMsg("SPC90133"));
                    } 
                    //sheetObj.LoadSaveXml( sXml );
                    ComOpenWait(false);
                    return;
            	}
                break;
        }
    }

  
    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
		tab_retrives[tabCnt++] = false;
    }

    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
    	var formObj  = document.form;
    	 switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "Allocation Status(HO)" , -1 );
                    InsertTab( cnt++ , "Allocation Status(RHQ)" , -1 );
                    // 2013.03.27 숨김처리 - 4.22 숨김 해제
                    if(usrRoleYn == "Y")
                    	InsertTab( cnt++ , "Adjusted allocation status" , -1 );
                    InsertTab( cnt++ , "PFMC Ratio vs QTA & BSA" , -1 );
                    //Add 2012.08.08. 
                    InsertTab( cnt++ , "BKG Status(RHQ)" , -1 );
                    InsertTab( cnt++ , "F'cast Comparison" , -1 );
                    // SELCDO & SELSC에게만 해당 탭 보여지도록 함. - Add 2012.09.10
                    if( formObj.login_ofc_cd.value =="SELCDO" || formObj.login_ofc_cd.value =="SELCTY" || formObj.login_rgn_cd.value =="SELSC" ){
	                    InsertTab( cnt++ , "Alloc&PFMC status by S.REP" , -1 );
	                    InsertTab( cnt++ , "FCST&BKG PFMC by S.Office" , -1 );
                    }
                    
                    // SELCDO 에게만 해당 탭 보여지도록 함.Add 2012.11.16. 
                    //if( formObj.login_ofc_cd.value == "SELCDO" ){
                    	InsertTab( cnt++ , "FCST&PFMC Status by ACCT" , -1 );
                    //}
                }
             break;
         }
    }

	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 **/
	function initControl() {
    	axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form); 	//- 포커스 나갈때
    	axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);		//- 키입력 할때
		axon_event.addListenerFormat('change',	 	'obj_change',	document.form);		//- 변경될때
    	axon_event.addListenerForm  ('activate', 	'obj_activate', document.form);
	} 
	
	/**
	 * HTML Control의 onchange 이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_change()
	{
		var obj      = event.srcElement;
		var formObj  = document.form;

		if ( ComTrim(obj.value) != "" )
		{
			switch(obj.name)
			{
    			case "check_area1":
    			case "check_area2":
    			case "check_area3":
    			case "check_area5":
    			case "check_dest2":
    			case "check_dest3":
    			case "check_dest5":
    			case "check_sector2":
    			case "check_sector5":
    				processButtonClick();
    				break;
    				
    			case "sales_office1":
    				setSalesRepCombo(obj);
    				break;

			}
		}
	}
	
	function obj_keypress(){
		var formObj = document.form;
		switch (event.srcElement.name) {
	        case "from_dt":
	            ComKeyOnlyNumber(formObj.from_dt);
	            break;
	    }
	}
	
	function obj_activate() {
		var srcName = event.srcElement.name;
		
		switch(srcName){
			case "from_dt":
				ComClearSeparator(event.srcElement); // 입력시 마스크 안보이기
				event.srcElement.select();
				break;
		}
	}
	
	function obj_blur() {
		var srcName = event.srcElement.name;
		
		switch(srcName){
			case "from_dt":
				ComChkObjValid(event.srcElement);
				break;
		}
	}
	
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var formObj = document.form;
        var objs = document.all.item("tabLayer");
    	var search_objs = document.all.item("searchLayer");
        var chkview;
        var chkViewP = document.form.chkViewP.checked;
    	var chkViewL = document.form.chkViewL.checked;
    	var rhq_div  = document.getElementById("rhq_div");
    	var rhq2_div = document.getElementById("rhq2_div");
    	
    	if(formObj.chkViewP.checked){
			formObj.chkview.value="P";
			chkview = "P";
		}else{
			formObj.chkview.value="O";
			chkview = "O";
		}
		
    	var tabInfos = (tabObjects[0].TabInfo).split("|");
    	var tabName = tabInfos[nItem].split(",");
    	
    	if(usrRoleYn == "Y") {
    		// 2013.04.22 숨김 풀면서 원복
        	if(tabName[1] == "FCST&PFMC Status by ACCT" && nItem == 6)
        		nItem = 8;
    	} else {
    		// 탭 중간에 숨김처리 되는 탭 처리 
        	if(tabName[1] == "PFMC Ratio vs QTA & BSA" && nItem == 2){
        		nItem = 3;
        	} else if(tabName[1] == "BKG Status(RHQ)" && nItem == 3){
        		nItem = 4;
        	} else if(tabName[1] == "Alloc&PFMC status by S.REP" && nItem == 5){
        		nItem = 6;
        	} else if(tabName[1] == "FCST&BKG PFMC by S.Office" && nItem == 6){
        		nItem = 7;
        	} else if(tabName[1] == "FCST&PFMC Status by ACCT" && nItem == 7){
        		nItem = 8;
        	} else if(tabName[1] == "FCST&PFMC Status by ACCT" && nItem == 5){
        		nItem = 8;
        	}
    	}
    	
    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    		
    	beforetab = nItem;

    	//타이틀 변경
		changetitle();
		
		// Allocation Status(HO) / Allocation Status(RHQ) / Adjusted allocation Status 의 경우
		// Dest 항목 숨기 처리
		if(beforetab == 0 || beforetab == 1 || beforetab == 2 ){
        	hiddenCheck();
		}
		
		if(beforetab != 5){
			//option 초기화
	     	//SpcSearchOptionDuration("duration2_from", 14, 1);
	     	//SpcSearchOptionDuration("duration2_to", 14, 1);
		    formObj.duration2_from.disabled = true;
		    formObj.duration2_to.disabled = true;
		    formObj.duration2_from.value = '1';
		    formObj.duration2_to.value = '1';
		}else{
		    formObj.duration2_from.disabled = false;
		    formObj.duration2_to.disabled = false;
		}
    	if(check_retrive && !tab_retrives[beforetab]){  
    		var queryString = "";
            if(beforetab==5){
				tab_retrives[5] = true;
            }else if(beforetab==0){
				tab_retrives[0] = true;
            }else if(beforetab==1){
				tab_retrives[1] = true;
            }else if(beforetab==2){	//SHKIM 20120613
				tab_retrives[2] = true;
            }else if(beforetab==3){
				tab_retrives[3] = true;
			
			//Add 2012.08.08.
            }else if(beforetab==4){           	
				tab_retrives[4] = true;		
				
			// Add 2012.09.10
            }else if(beforetab==6){           	
            	tab_retrives[6] = true;		
            }else if(beforetab==7){           	
            	tab_retrives[7] = true;		
            
            //Add 2012.11.16.
            }else if(beforetab==8){           	
				tab_retrives[8] = true;
            }	
    	}
    	
    	//Allocation Status(HO) / Allocation Status(RHQ) / Adjusted allocation status / PFMC Ratio cs QTA & BSA / BKG Stattus(RHQ) / F'cast Comparison 
    	//탭의 경우 RHQ 콤보에 SELSC, TYOSC 추가
    	if(beforetab < 6){
   		 	rhq_div.style.display = "none";
    		rhq2_div.style.display = "inline";
		}else{
   		 	rhq_div.style.display = "inline";
    		rhq2_div.style.display = "none";
		}
    	
    	// Alloc&PFMC status by S.REP의 경우 조회조건 변경
    	if(tabName[1] == "Alloc&PFMC status by S.REP" || tabName[1] == "FCST&BKG PFMC by S.Office"){
        	search_objs[0].style.display = "none";
        	search_objs[1].style.display = "Inline";		
        	
        	var combo = document.getElementById("srep_cd");
        	if(tabName[1] == "FCST&BKG PFMC by S.Office"){
        		combo.enable = false;
        		formObj.from_dt.disabled = true;
        		formObj.duration1.disabled = true;
        	}else{
        		combo.enable = true;
        		formObj.from_dt.disabled = false;
        		formObj.duration1.disabled = false;
        	}
        }else{           	
        	search_objs[0].style.display = "Inline";
        	search_objs[1].style.display = "none";
        }
    	
    	if (beforetab == 8
                && document.form.login_ofc_cd.value != "SELCTY" 
                && document.form.login_ofc_cd.value != "SELCMA"
                && document.form.login_ofc_cd.value != "SELCMI"
                && document.form.login_ofc_cd.value != "SELGMS") {
            document.getElementById("rhq").Code = document.form.login_rhq_cd.value;
            document.getElementById("rhq2").Code = document.form.login_rhq_cd.value;
    	    document.getElementById("sales_office").value = document.form.login_rgn_cd.value;
            document.getElementById("rhq").Enable = false;
            document.getElementById("rhq2").Enable = false;
            document.getElementById("sales_office").disabled = "disabled";
        } else {
            document.getElementById("rhq").Enable = true;
            document.getElementById("rhq2").Enable = true;
            document.getElementById("sales_office").disabled = "";
        }
    }
    
    /**
     * tree구조 선택시 
     */
    function sheet1_OnClick(sheetObj, row, col){
    	switch(sheetObj.ColSaveName(col)){
    	case "area":
    	case "ofc_cd":
    		var total_row = sheetObj.FindText("ofc_cd", "TOTAL");   
    		 		
    		if(sheetObj.CellValue(row, col) == "+"){
    			sheetObj.RowExpanded(row) = true;
   				sheetObj.CellValue2(row, col) = "-";
    		}else if(sheetObj.CellValue(row, col) == "-"){
    			sheetObj.RowExpanded(row) = false;
   				sheetObj.CellValue2(row, col) = "+";
    		} 
    		break;
    	}
    }
     
    /**
     * tree구조 선택시 (2) Allocation Status(HO) (sheet2)
     */
    function sheet2_OnClick(sheetObj, row, col){  

    	switch(sheetObj.ColSaveName(col)){
    	case "rlane_cd":
    	case "area": 		
    		if(sheetObj.CellValue(row, col) == "+"){
    			sheetObj.RowExpanded(row) = true;
   				sheetObj.CellValue2(row, col) = "-";
   				sheet2TotalRowHidden();
    		}else if(sheetObj.CellValue(row, col) == "-"){
    			sheetObj.RowExpanded(row) = false;
   				sheetObj.CellValue2(row, col) = "+";
    		}
    		break;
    	case "ofc_cd":
    		if(sheetObj.CellValue(row, col) == "+"){
    			sheetObj.RowExpanded(row) = true;
   				sheetObj.CellValue2(row, col) = "-";
   				sheet2TotalRowHidden();
    		}else if(sheetObj.CellValue(row, col) == "-"){
    			sheetObj.RowExpanded(row) = false;
   				sheetObj.CellValue2(row, col) = "+";
    		} 
    		break;
    	case "sub_ofc_cd":
    		if(sheetObj.CellValue(row, col) == "+"){
    			sheetObj.RowExpanded(row) = true;
   				sheetObj.CellValue2(row, col) = "-";
    		}else if(sheetObj.CellValue(row, col) == "-"){
    			sheetObj.RowExpanded(row) = false;
   				sheetObj.CellValue2(row, col) = "+";
    		} 
    		break;	
    	case "acct_lvl":
    		if(sheetObj.CellValue(row, col) == "+"){
    			sheetObj.RowExpanded(row) = true;
    			sheetObj.CellValue2(row, col) = "-";
    		}else if(sheetObj.CellValue(row, col) == "-"){
    			sheetObj.RowExpanded(row) = false;
    			sheetObj.CellValue2(row, col) = "+";
    		} 
    		break;
    	case "usa_bkg_mod_cd":
    		if(sheetObj.CellValue(row, col) == "+"){
    			sheetObj.RowExpanded(row) = true;
    			sheetObj.CellValue2(row, col) = "-";
    		}else if(sheetObj.CellValue(row, col) == "-"){
    			sheetObj.RowExpanded(row) = false;
    			sheetObj.CellValue2(row, col) = "+";
    		} 
    		break;
    	case "acct_cd":
    		if(sheetObj.CellValue(row, col) == "+"){
    			sheetObj.RowExpanded(row) = true;
    			sheetObj.CellValue2(row, col) = "-";
    		}else if(sheetObj.CellValue(row, col) == "-"){
    			sheetObj.RowExpanded(row) = false;
    			sheetObj.CellValue2(row, col) = "+";
    		} 
    		break;
    		//dest_loc_cd
    		
    	}
    }
    
    /**
     * sheet2TotalRowHidden 
     */
    function sheet2TotalRowHidden(){
    	
    	if(document.form.check_destLoc2.checked || document.form.check_usMod2.checked || document.form.check_acct2.checked) return;
    	
    	var sheetObj = sheetObjects[0];
    	var arrRow = sheetObj.FindCheckedRow("hg").split("|");
    	for (var idx=0; idx < arrRow.length-1; idx++) {
			if(	ComTrim(sheetObj.CellValue(arrRow[idx], "area")) == ComTrim(sheetObj.CellValue(arrRow[idx], "ofc_cd"))	&& ComTrim(sheetObj.CellValue(arrRow[idx], "acct_lvl")) == '*') {
				sheetObj.RowHidden(arrRow[idx]) = true; 
			}
    	}	
    }
    /* Sheet2에서 VVD 선택시 0042 UI PopUp Open */
    function sheet2_OnDblClick(sheetObj,row,col){
    	var formObj = document.form;
    	if (sheetObj.RowMerge(row) == false ) return; //VVD는 Merge된 Row에서만 선택될 수 있으므로 , Merge된 행이 아니면 return
    	if (formObj.login_ofc_cd.value !="SELCDO" && formObj.login_ofc_cd.value !="SELCTY") return;

    	
    	if (sheetObj.CellValue(row, col).length == 9 || sheetObj.CellValue(row, col).length ==19) {
			var pgmNo = "&pgmNo=ESM_SPC_0042";
	        var param = "vvd="+sheetObj.CellValue(row, col);
	            param += "&year="+ComGetObjValue(formObj.year);
	            param += "&week="  +ComGetObjValue(formObj.week1);
	            param += "&duration="  +ComGetObjValue(formObj.duration); 
			var url = "ESM_SPC_0042.do?" + param + pgmNo;
			
			var leftpos = (screen.width - 1024) / 2;
			if (leftpos < 0)
				leftpos = 0;
			var toppos = (screen.height - 540) / 2;
			if (toppos < 0)
				toppos = 0;    				

			ComOpenWindow(url, 'none',"scroll:yes;status:no;maximize:yes;minimize:yes;help:no;dialogWidth:1024px;dialogHeight540px;resizable:yes;dialogLeft:"+leftpos + ";dialogTop:" + toppos, true);
    	}        	
    }
    
    /**
     * tree구조 선택시 
     */
    function sheet3_OnClick(sheetObj, row, col){
    	switch(sheetObj.ColSaveName(col)){
    	case "rlane_cd":
    	case "area":
    		if(sheetObj.CellValue(row, col) == "+"){
    			sheetObj.RowExpanded(row) = true;
   				sheetObj.CellValue2(row, col) = "-";
    		}else if(sheetObj.CellValue(row, col) == "-"){
    			sheetObj.RowExpanded(row) = false;
   				sheetObj.CellValue2(row, col) = "+";
    		}
    		break;
    	case "ofc_cd":
    		if(sheetObj.CellValue(row, col) == "+"){
    			sheetObj.RowExpanded(row) = true;
   				sheetObj.CellValue2(row, col) = "-";
    		}else if(sheetObj.CellValue(row, col) == "-"){
    			sheetObj.RowExpanded(row) = false;
   				sheetObj.CellValue2(row, col) = "+";
    		}
    		break;
    	}
    }

    /* Sheet3에서 VVD 선택시 0042 UI PopUp Open */
    function sheet3_OnDblClick(sheetObj,row,col){
    	var formObj = document.form;
    	if (sheetObj.RowMerge(row) == false) return; //VVD는 Merge된 Row에서만 선택될 수 있으므로 , Merge된 행이 아니면 return
    	if (formObj.login_ofc_cd.value !="SELCDO" && formObj.login_ofc_cd.value !="SELCTY") return;
    	
    	if (sheetObj.CellValue(row, col).length == 9 || sheetObj.CellValue(row, col).length ==19) {
			var pgmNo = "&pgmNo=ESM_SPC_0042";
	        var param = "vvd="+sheetObj.CellValue(row, col);
	            param += "&year="+ComGetObjValue(formObj.year);
	            param += "&week="  +ComGetObjValue(formObj.week1);
	            param += "&duration="  +ComGetObjValue(formObj.duration); 
			var url = "ESM_SPC_0042.do?" + param + pgmNo;
			
			var leftpos = (screen.width - 1024) / 2;
			if (leftpos < 0)
				leftpos = 0;
			var toppos = (screen.height - 540) / 2;
			if (toppos < 0)
				toppos = 0;    				

			ComOpenWindow(url, 'none',"scroll:yes;status:no;maximize:yes;minimize:yes;help:no;dialogWidth:1024px;dialogHeight540px;resizable:yes;dialogLeft:"+leftpos + ";dialogTop:" + toppos, true);
    	}        	
    }
    
    /* SHKIM 20120613 Sheet3에서 VVD 선택시 0042 UI PopUp Open */
    function sheet4_OnDblClick(sheetObj,row,col){
    	var formObj = document.form;
    	if (sheetObj.RowMerge(row) == false) return; //VVD는 Merge된 Row에서만 선택될 수 있으므로 , Merge된 행이 아니면 return
    	if (formObj.login_ofc_cd.value !="SELCDO" && formObj.login_ofc_cd.value !="SELCTY") return;
    	
    	if (sheetObj.CellValue(row, col).length == 9 || sheetObj.CellValue(row, col).length ==19) {
			var pgmNo = "&pgmNo=ESM_SPC_0042";
	        var param = "vvd="+sheetObj.CellValue(row, col);
	            param += "&year="+ComGetObjValue(formObj.year);
	            param += "&week="  +ComGetObjValue(formObj.week1);
	            param += "&duration="  +ComGetObjValue(formObj.duration); 
			var url = "ESM_SPC_0042.do?" + param + pgmNo;
			
			var leftpos = (screen.width - 1024) / 2;
			if (leftpos < 0)
				leftpos = 0;
			var toppos = (screen.height - 540) / 2;
			if (toppos < 0)
				toppos = 0;    				

			ComOpenWindow(url, 'none',"scroll:yes;status:no;maximize:yes;minimize:yes;help:no;dialogWidth:1024px;dialogHeight540px;resizable:yes;dialogLeft:"+leftpos + ";dialogTop:" + toppos, true);
    	}        	
    }
    
    /*
     * tree구조 선택시 
     */
    function sheet4_OnClick(sheetObj, row, col){
    	switch(sheetObj.ColSaveName(col)){
    	case "rlane_cd":
    	case "area":
    		if(sheetObj.CellValue(row, col) == "+"){
    			sheetObj.RowExpanded(row) = true;
   				sheetObj.CellValue2(row, col) = "-";
    		}else if(sheetObj.CellValue(row, col) == "-"){
    			sheetObj.RowExpanded(row) = false;
   				sheetObj.CellValue2(row, col) = "+";
    		}
    		break;
    	case "ofc_cd":
    		if(sheetObj.CellValue(row, col) == "+"){
    			sheetObj.RowExpanded(row) = true;
   				sheetObj.CellValue2(row, col) = "-";
    		}else if(sheetObj.CellValue(row, col) == "-"){
    			sheetObj.RowExpanded(row) = false;
   				sheetObj.CellValue2(row, col) = "+";
    		} 
    		break;
    	}
    }

    /*
     * tree구조 선택시 
     *  Add 2012.08.08.
     *  Allocation Status(RHQ)
     */
 
    function sheet5_OnClick(sheetObj, row, col){
    	
		switch(sheetObj.ColSaveName(col)){
		case "rlane_cd":
		case "area":
			if(sheetObj.CellValue(row, col) == "+"){
				sheetObj.RowExpanded(row) = true;
					sheetObj.CellValue2(row, col) = "-";
			}else if(sheetObj.CellValue(row, col) == "-"){
				sheetObj.RowExpanded(row) = false;
					sheetObj.CellValue2(row, col) = "+";
			}
			break;
		case "ofc_cd":
			if(sheetObj.CellValue(row, col) == "+"){
				sheetObj.RowExpanded(row) = true;
				sheetObj.CellValue2(row, col) = "-";
			}else if(sheetObj.CellValue(row, col) == "-"){
				sheetObj.RowExpanded(row) = false;
				sheetObj.CellValue2(row, col) = "+";
			}
			//TOTAL 값 숨김처리
			for (var i=sheetObj.HeaderRows; i < sheetObj.HeaderRows+sheetObj.RowCount; i++) {
				if((ComTrim(sheetObj.CellValue(i, "sub_ofc_cd")) == '+' || ComTrim(sheetObj.CellValue(i, "sub_ofc_cd")) == '-') && ComTrim(sheetObj.CellValue(i, "acct_lvl")) == '*') {
					sheetObj.RowHidden(i) = true;
				}
			}
			break;
		case "acct_lvl":
			if(sheetObj.CellValue(row, col) == "+"){
				sheetObj.RowExpanded(row) = true;
				sheetObj.CellValue2(row, col) = "-";
			}else if(sheetObj.CellValue(row, col) == "-"){
				sheetObj.RowExpanded(row) = false;
				sheetObj.CellValue2(row, col) = "+";
			} 	
			break;
		case "usa_bkg_mod_cd":
			if(sheetObj.CellValue(row, col) == "+"){
				sheetObj.RowExpanded(row) = true;
				sheetObj.CellValue2(row, col) = "-";
			}else if(sheetObj.CellValue(row, col) == "-"){
				sheetObj.RowExpanded(row) = false;
				sheetObj.CellValue2(row, col) = "+";
			}
			break;
		case "acct_cd":
			if(sheetObj.CellValue(row, col) == "+"){
				sheetObj.RowExpanded(row) = true;
				sheetObj.CellValue2(row, col) = "-";
			}else if(sheetObj.CellValue(row, col) == "-"){
				sheetObj.RowExpanded(row) = false;
				sheetObj.CellValue2(row, col) = "+";
			}
			break;
		case "dest_loc_cd":
			if(sheetObj.CellValue(row, col) == "+"){
				sheetObj.RowExpanded(row) = true;
				sheetObj.CellValue2(row, col) = "-";
			}else if(sheetObj.CellValue(row, col) == "-"){
				sheetObj.RowExpanded(row) = false;
				sheetObj.CellValue2(row, col) = "+";
			}
			break;   
		}
    }
    
    /* VVD 선택시 0042 UI PopUp Open 
     * 
     * Allocation Status(RHQ)
     * */
    function sheet5_OnDblClick(sheetObj,row,col){	
    	var formObj = document.form;
    	if (sheetObj.RowMerge(row) == false ) return; //VVD는 Merge된 Row에서만 선택될 수 있으므로 , Merge된 행이 아니면 return
    	if (formObj.login_ofc_cd.value !="SELCDO" && formObj.login_ofc_cd.value !="SELCTY") return;

    	
    	if (sheetObj.CellValue(row, col).length == 9 || sheetObj.CellValue(row, col).length ==19) {
    		var pgmNo = "&pgmNo=ESM_SPC_0042";
	        var param = "vvd="+sheetObj.CellValue(row, col);
	            param += "&year="+ComGetObjValue(formObj.year);
	            param += "&week="  +ComGetObjValue(formObj.week1);
	            param += "&duration="  +ComGetObjValue(formObj.duration); 
			var url = "ESM_SPC_0042.do?" + param + pgmNo;

			/**by 현업요구에 의해 HO로 변경
    		var pgmNo = "&pgmNo=ESM_SPC_0047";
	        var param = "vvd="+sheetObj.CellValue(row, col);
	            param += "&year="+ComGetObjValue(formObj.year);
	            param += "&week="  +ComGetObjValue(formObj.week1);
	            param += "&duration="  +ComGetObjValue(formObj.duration); 
	            param += "&office="  +comObjects[4].Code;
	            param += "&popup_flg=Y";	
			var url = "ESM_SPC_0047.do?" + param + pgmNo;   		
			*/
			var leftpos = (screen.width - 1024) / 2;
			if (leftpos < 0)
				leftpos = 0;
			var toppos = (screen.height - 540) / 2;
			if (toppos < 0)
				toppos = 0;    				

			ComOpenWindow(url, 'none',"scroll:yes;status:no;maximize:yes;minimize:yes;help:no;dialogWidth:1024px;dialogHeight540px;resizable:yes;dialogLeft:"+leftpos + ";dialogTop:" + toppos, true);
    	}        	
    }
    
    
    function sheet6_OnClick(sheetObj, row, col){

    	switch(sheetObj.ColSaveName(col)){
    	case "rlane_cd":
    	case "aq_cd":    		
    		if(sheetObj.CellValue(row, col) == "+"){
    			sheetObj.RowExpanded(row) = true;
   				sheetObj.CellValue2(row, col) = "-";
    		}else if(sheetObj.CellValue(row, col) == "-"){
    			sheetObj.RowExpanded(row) = false;
   				sheetObj.CellValue2(row, col) = "+";
    		}
    		break;
    	case "ofc_cd":    		
    		if(sheetObj.CellValue(row, col) == "+"){
    			sheetObj.RowExpanded(row) = true;
   				sheetObj.CellValue2(row, col) = "-";
    		}else if(sheetObj.CellValue(row, col) == "-"){
    			sheetObj.RowExpanded(row) = false;
   				sheetObj.CellValue2(row, col) = "+";
    		} 
    		break;
    	case "port":    		
			if(sheetObj.CellValue(row, col) == "+"){
				sheetObj.RowExpanded(row) = true;
					sheetObj.CellValue2(row, col) = "-";
			}else if(sheetObj.CellValue(row, col) == "-"){
				sheetObj.RowExpanded(row) = false;
					sheetObj.CellValue2(row, col) = "+";
			} 
			break;
		}
    }
   
    
    /* Sheet6에서  BKG 수량 선택시 0049 UI PopUp Open */
    function sheet6_OnDblClick(sheetObj,row,col){
    		// bkg
    	var formObj = document.form;
    	var colName = sheetObj.ColSaveName(col);
	
		var param = "";
		var sheet1 = sheetObjects[4];
		var sUrl = "/hanjin/ESM_SPC_0049.do";
		var port_div =formObj.port_div.value;
		var sub_trd_cd="";		
		var lane="";
		var bound="";
		
		var ioc_cd ="O";		
		var pol_cd="";
		var pod_cd="";
		var ofc_cd="";
		var cnt =0;
		
    	//Booking(TTL) TOtal TEU 물량이 있을시 
		
		if(  colName.length > 3
		   && colName.substring(0, 3) == "bkg"
		   && colName.substring(0, 4) != "bkg_"){
			
			 cnt = eval(sheetObj.CellValue(row, col));
			
			lane   = sheet1.CellValue(row, "lane");
			bound  = sheet1.CellValue(row, "bound");
			
			if(sheet1.CellValue(row, "sub_trd_cd") != null
					&& sheet1.CellValue(row, "sub_trd_cd") != "TOTAL")
			sub_trd_cd = sheet1.CellValue(row, "sub_trd_cd");
			
			if(sheet1.CellValue(row, "port") != null
					&& sheet1.CellValue(row, "port") != "+"
					&& sheet1.CellValue(row, "port") != "-"
						){
						if(port_div =="POD")
							pod_cd	=sheet1.CellValue(row, "port");
						else if (port_div =="POL")
							pol_cd	=sheet1.CellValue(row, "port");
					}
					
				
			if(sheet1.CellValue(row, "ofc_cd") != null
					  && sheet1.CellValue(row, "ofc_cd") != "+"
					  && sheet1.CellValue(row, "ofc_cd") != "-"	)
					ofc_cd =sheet1.CellValue(row, "ofc_cd");
					
			if( port_div != "DEL"
				&& lane !="TOTAL"
				&& bound !="TOTAL"
				&& cnt > 0
				&& ofc_cd != null
				&& ofc_cd.length > 0){				
				
				lane6 = SpcFormString(formObj,'rlane6');				
				if(lane6.length > 7)
					rlane =	lane6.substring(7);									
				
	    		param = "?f_cmd="+SEARCHLIST
	    			+ "&trade="   		+ formObj.trade.Code
					+ "&subtrade="		+ sub_trd_cd
					+ "&lane="    		+ lane
					+ "&bound="   		+ bound
					+ "&year="    		+ sheet1.CellValue(0, col).substring(0, 4)
					+ "&week="   		+ sheet1.CellValue(0, col).substring(4)
					+ "&vvd="     		+ sheet1.CellValue(row, "VVD"+colName.substring(3))
					
					+ "&ioc_cd="   		+ ioc_cd
					+ "&sls_area_cd="   + ""
					+ "&sls_ofc_cd="   	+ ofc_cd
					+ "&pol_cd="   		+ pol_cd
					+ "&pod_cd="   		+ pod_cd;
	    			
				var leftpos = (screen.width - 1024) / 2;
				if (leftpos < 0)
					leftpos = 0;
				var toppos = (screen.height - 540) / 2;
				if (toppos < 0)
					toppos = 0;    				

				
				ComOpenWindow(sUrl+param,       'none',"scroll:yes;status:no;maximize:yes;minimize:yes;help:no;dialogWidth:1024px;dialogHeight540px;resizable:yes;dialogLeft:"+leftpos + ";dialogTop:" + toppos, true);
			}
		}       	
    }
	
	
	/**
     * OTHERS 선택시 처리
     */
    function sheet11_OnDblClick(sheetObj, row, col){

    	switch(cname){
	    	case "g_acct":
	    		var type_chk   = sheetObj.CellValue(row, "type");
	    		var hidden_chk = true;
	    		var n_chk      = row;
	    		
	    		if(type_chk == "Other"){
	    			for (var j = n_chk + 1; j < sheetObj.Rows; j++) {
	    				if(sheetObj.CellValue(j, "type") == "Other Detail"){
	    					hidden_chk = sheetObj.RowHidden(j);	// Click 된 Other 하위인 Other Detail 의 첫 Row 의 Hidden 상태 
	    					row = j;
	    					break;
	    				}
	    			}
	    			
	    			// View Type 이 L/Office 일 경우 Click 한 Office 와 위에서 찾은 Other Detail Row 에 해당하는 Office 가 동일하지 않을경우 Function 멈춤
	    			// Other 만 존재하고 Other Detail 이 존재하지 않는 경우를 위한 예외 처리
	    			if(getRadioValue(document.form.view_type11) == "LOFC" && (sheetObj.CellValue(row, "l_ofc_cd") != sheetObj.CellValue(n_chk, "l_ofc_cd"))){
	    				break;
	    			}
	    			
	    			for (var i = row; i < sheetObj.Rows; i++) {
	    				if(sheetObj.CellValue(i, "type") == "Other Detail"){
	    					sheetObj.RowHidden(i) = !hidden_chk;
	    				} else {
	    					break;
	    				}
	    			}
	    		}
	    		
	    		break;
    	}
    	var yglength = ComTrim(sheetObj.CellValue(row, "cust_ctrl_cd")).length;
    	if(cname.substr(0,3) == "bkg" && (yglength==1 || yglength==2)) {
	    	//Booking(TTL) TOtal TEU 물량이 있을시
    		try {   			

	    		var sUrl = "/hanjin/ESM_SPC_0049.do";
	    		var cnt = eval(ComTrim(sheetObj.CellValue(row, col)));
	    		var cust_grp_id = (ComTrim(sheetObj.CellValue(row, "cust_grp_id")));
	    		var cno = cname.substr(3,2);
	    		var rlane = ComTrim(sheetObj.CellValue(row, "rlane_cd"));
	    		var yrwk = ComTrim(sheetObj.CellValue(0, col));
	    		var vvd = ComTrim(sheetObj.CellValue(row, "vvd" + cno));
   		
	    		if(cust_grp_id != "cust_grp_id" && cnt > 0 && yrwk.length >= 6) {//SUM항목이 아니라면 팝업 조회
	    			var cust_no = ComTrim(sheetObj.CellValue(row, "cust_no"));
		    		if(cust_no == "cust_no") {//둘이 같으면 cust_grp_id가 없는경우임.
		    			cust_no = "";
		    		}		    		
		    		if(rlane.length>5) {
		    			rlane = "";
		    		}
	    			var param = "?f_cmd="		+ SEARCHLIST
	    			      + "&trade="		+ ComTrim(sheetObj.CellValue(row, "trd_cd"))
	    			      + "&subtrade="	+ ComTrim(sheetObj.CellValue(row, "sub_trd"))
	    			      + "&lane="		+ rlane
		    			  + "&year="		+ ComTrim((yrwk.length>=6?yrwk.substr(0, 4):""))
		    			  + "&week="		+ ComTrim((yrwk.length>=6?yrwk.substr(4, 2):""))
	    			      + "&vvd="			+ vvd
	    			      + "&sls_ofc_cd="	+ ComTrim(sheetObj.CellValue(row, "l_ofc_cd"))
	    			      + "&ctrt_ofc_cd="	+ ComTrim(sheetObj.CellValue(row, "c_ofc_cd"))
	    			      + "&cust_grp_id="	+ cust_grp_id
	    			      + "&cust_cd="	    + cust_no
	    			      + "&sc_no="		+ ComTrim(sheetObj.CellValue(row, "sc_no"))
	    			      + "&rfa_no="		+ ComTrim(sheetObj.CellValue(row, "rfa_no"))
	    			      + "&call_ui=ESM_SPC_0021"
//	    			      + "&cust_ctrl="	+ ComTrim(sheetObj.CellValue(row, "cust_ctrl_cd")) //bkg실적조회레포트의 sc, rfa no 하단쿼리때문에 뺌.
	    			      ;  			
	    			var leftpos = (screen.width - 1024) / 2;
	    			if (leftpos < 0) leftpos = 0;
	    			
	    			var toppos = (screen.height - 540) / 2;
	    			if (toppos < 0) toppos = 0;
	    			var rtn = window.open(sUrl+param, "none", "height=560px,width=1024px,status=no,toolbar=no,menubar=no,location=no,resizable=yes,Left="+leftpos + ",dialogTop:" + toppos)
	
	    			
	    		}

        	}catch(e) {
        		if( e == "[object Error]") {
        			ComShowCodeMessage("COM12111");
        		} else {
        			ComShowMessage(e);
        		}
        	}
    	}
    }
    
    /**
     * 초기 화면시 OTHERS 처리
     */
    function otherHidden(sheetObj){
    	for (var i = 1; i < sheetObj.Rows; i++) {
    		if(sheetObj.CellValue(i, "type") == "Other Detail"){
    			sheetObj.RowHidden(i) = true;
    		}
    	}
    }
    
    /**
	 * 라디오버튼 선택시 재조회
	 * Add 2012.12.06
	 */
	function sheet11ReSearch(){
		var formObject = document.form;
		var sheetObject10 = sheetObjects[10];
		
		if(getRadioValue(document.form.view_type11) == "LOFC"){
			formObject.check_lane.checked  = true;
			formObject.check_lane.value    = "Y";
			formObject.check_lane.disabled = true;
		} else {
			formObject.check_lane.checked  = false;
			formObject.check_lane.value    = "N";
			formObject.check_lane.disabled = false;
		}
		
		doActionIBSheet(sheetObject10,formObject,IBSEARCH);
		tab_retrives[8] = true;
    }
      
    /*
     * Portview체크시 타이틀 변경
     */
    function changetitle(){
    	var formObj = document.form;
    	var chkViewP = formObj.chkViewP.checked;

    	if(beforetab==5){
	    	if(chkViewP){
	    		var sheetObj = sheetObjects[5];
	    		sheetObj.CellText(0,0)="Port";
	    		sheetObj.CellText(1,0)="Port";
	    		sheetObj.CellText(2,0)="Port";
	    	}else{
	    		var sheetObj = sheetObjects[5];
	    		sheetObj.CellText(0,0)="Area";
	    		sheetObj.CellText(1,0)="Area";
	    		sheetObj.CellText(2,0)="Area";
	    	}
    	}else{
    		if(chkViewP){
	    		var sheetObj = sheetObjects[0];	    		
	    		sheetObj.CellText(0,2)="Port";
	    		sheetObj.CellText(1,2)="Port";
	    		sheetObj.CellText(2,2)="Port";
	    		sheetObj.CellText(3,2)="Port";
	    		
	    		sheetObj = sheetObjects[2];
	    		sheetObj.CellText(0,2)="Port";
	    		sheetObj.CellText(1,2)="Port";
	    		sheetObj.CellText(2,2)="Port";
	    		sheetObj.CellText(3,2)="Port";
	    	}else{
	    		var sheetObj = sheetObjects[0];
	    		sheetObj.CellText(0,2)="Area";
	    		sheetObj.CellText(1,2)="Area";
	    		sheetObj.CellText(2,2)="Area";
	    		sheetObj.CellText(3,2)="Area";
	    		
	    		sheetObj = sheetObjects[2];
	    		sheetObj.CellText(0,2)="Area";
	    		sheetObj.CellText(1,2)="Area";
	    		sheetObj.CellText(2,2)="Area";
	    		sheetObj.CellText(3,2)="Area";
	    	}
    	}
    }
    
    //Alloc Status HO/RHQ 탭의 Sub Office 체크시 해당레벨로 재조회
    function clickSubOfc(obj){  
    	var type = obj.checked;     	
    	var formObj = document.form;
    	if(type){
        	if(beforetab==0){			// Allocation Status(HO) -- sheet2
            	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
            }else if(beforetab==1){ 		// Allocation Status(RHQ) -- sheet5
            	doActionIBSheet(sheetObjects[1],formObj,IBSEARCH);
            }	
    	}
    }
    
    
    /**
	 * 체크박스 선택시 office 컬럼을 보여줄지 여부
	 * 화면의 office 체크박스 클릭하면 수행함
	 */
    function changeTitle2(obj, flg){  
    	var sheetObj = sheetObjects[0];
    	var formObj = document.form;
    	var type = obj.checked;
		var soSts = formObj.check_suboffice.checked;
    	
    	if(flg == undefined || flg == null){
    		flg = '0';
    	}
    	
    	if(type){
    		sheetObj.ShowTreeLevel(2, 1);
		}else{
			sheetObj.ShowTreeLevel(1, 1);
		}
    	
    	// Dest 항목 숨김 여부
    	if(flg != '1'){
        	var sts;
			if(document.form.check_dest2.checked == undefined || document.form.check_dest2.checked == false) sts = true;
			else sts = false;
			
			for(i=3; i < sheetObj.RowCount; i++){
				rlane = sheetObj.CellValue(i, "rlane_cd");
				
				if(sheetObj.CellValue(i, "dest") != " " && rlane.substr(rlane.length-3, 3) == "TTL"){
					sheetObj.RowHidden(i) = sts;
				}
			}
    	}

    	var findTxt = "";
    	var replTxt = "";
    	
    	if(type){
        	findTxt = "+";
        	replTxt = "-";
    	}else{
    		findTxt = "-";
    		replTxt = "+";
    	}
    	
		row = 0;
		while((row = sheetObj.FindText("ofc_cd", findTxt, row)) > 0){
			sheetObj.CellValue2(row, "ofc_cd") = replTxt;
		}

		if(!document.form.check_guide2.disabled) {
			hiddenGuide2();
			sheetObj.ColHidden("acct_lvl") = false;
		} else {//IAS노선의 경우		
			sheetObj.ColHidden("acct_lvl") = true;
			sheetObj.ColHidden("dest_loc_cd") = !(document.form.check_usMod2.checked);	
			sheetObj.ColHidden("acct_cd") = !(document.form.check_acct2.checked);
			sheetObj.ColHidden("usa_bkg_mod_cd") = !(document.form.check_destLoc2.checked);
		}
		
		if(soSts){
			changeTitle2_subOfc(formObj.check_suboffice);
		}
    }
    
    /**
	 * 체크박스 선택시 sub office 컬럼을 보여줄지 여부
	 * 화면의 sub office 체크박스 클릭하면 수행함
	 */
    function changeTitle2_subOfc(obj, flg){  
    	var sheetObj = sheetObjects[0];
    	var formObj = document.form;
    	var type = obj.checked;     	
		var oSts = formObj.check_office.checked;

    	if(flg == undefined || flg == null){
    		flg = '0';
    	}

    	if(type){
			sheetObj.ShowTreeLevel(3, 1);
		}else{
			if(oSts){
				sheetObj.ShowTreeLevel(2, 1);
			}else{
				sheetObj.ShowTreeLevel(1, 1);
			}
		}
    	
    	// Dest 항목 숨김 여부
    	if(flg != '1'){
        	var sts;
			if(document.form.check_dest2.checked == undefined || document.form.check_dest2.checked == false) sts = true;
			else sts = false;
			
			for(i=3; i < sheetObj.RowCount; i++){
				rlane = sheetObj.CellValue(i, "rlane_cd");
				
				if(sheetObj.CellValue(i, "dest") != " " && rlane.substr(rlane.length-3, 3) == "TTL"){
					sheetObj.RowHidden(i) = sts;
				}
			}
    	}
    	var findTxt = "";
    	var replTxt = "";
    	
    	if(type){
        	findTxt = "+";
        	replTxt = "-";
    	}else{
    		findTxt = "-";
    		replTxt = "+";
    	}

			row = 0;
			while((row = sheetObj.FindText("sub_ofc_cd", findTxt, row)) > 0){
				sheetObj.CellValue2(row, "sub_ofc_cd") = replTxt;
			}
    	
		if(!document.form.check_guide2.disabled) {
			hiddenGuide2_subOfc();
			sheetObj.ColHidden("acct_lvl") = false;
		} else {//IAS노선의 경우		
			sheetObj.ColHidden("acct_lvl") = true;
			sheetObj.ColHidden("dest_loc_cd") = !(document.form.check_usMod2.checked);	
			sheetObj.ColHidden("acct_cd") = !(document.form.check_acct2.checked);
			sheetObj.ColHidden("usa_bkg_mod_cd") = !(document.form.check_destLoc2.checked);
		}
    }
    
    /**
	 * 체크박스 선택시 office 컬럼을 보여줄지 여부
	 */
	function changeTitle3(obj, flg){    	
    	var sheetObj;
    	var type;  
    	
    	if(flg == undefined || flg == null){
    		flg = '0';
    	}   	
    	
    	sheetObj = sheetObjects[2];
    	type = obj.checked;

    	if(type){
			sheetObj.ShowTreeLevel(2, 2);
		}
		else{
			sheetObj.ShowTreeLevel(1, 1);
		}
    	
    	// Dest 항목 숨김 여부
    	if(flg != '1'){
        	var sts = false;
			if(document.form.check_dest3.checked == undefined || document.form.check_dest3.checked == false) sts = true;
			else sts = false;
			
			for(i=3; i < sheetObj.RowCount; i++){
				rlane = sheetObj.CellValue(i, "rlane_cd");
				
				if(sheetObj.CellValue(i, "dest") != " " && rlane.substr(rlane.length-3, 3) == "TTL"){
					sheetObj.RowHidden(i) = sts;
				}
			}
    	}
		
    	var findTxt = "";
    	var replTxt = "";
    	
    	if(type){
        	findTxt = "+";
        	replTxt = "-";
    	}else{
    		findTxt = "-";
    		replTxt = "+";
    	}
    	
		row = 0;
		while((row = sheetObj.FindText("ofc_cd", findTxt, row)) > 0){
			sheetObj.CellValue2(row, "ofc_cd") = replTxt;
		}
    }
	
	/**
	 * 체크박스 선택시 office 컬럼을 보여줄지 여부
	 */
	function changeTitle4(obj, flg){    	
		var sheetObj;
		var type;  
		
		if(flg == undefined || flg == null){
			flg = '0';
		}   	
		
		sheetObj = sheetObjects[3];
		type = obj.checked;
		
		if(type){
			sts = false;
		}else{
			sts = true;
		}
		
		for(i=3; i < sheetObj.RowCount; i++){
			sheetObj.CellAlign(i,"rhq_cd") = daCenter;
			sheetObj.CellAlign(i,"rlane_cd") = daCenter;
			sheetObj.CellAlign(i,"area") = daCenter;
			if(!(sheetObj.CellValue(i, "ofc_cd") == " TTL" || sheetObj.CellValue(i, "ofc_cd") == sheetObj.CellValue(i, "area"))){
				sheetObj.RowHidden(i) = sts;
			}
		}
	}
        
	
	/**
	 * 체크박스 선택시 office 컬럼을 보여줄지 여부
	 * Add 2012.08.08.
	 */
	function changeTitle6(obj, flg){    
					
    	var sheetObj;
    	sheetObj = sheetObjects[4];
    	sheetObj.ShowTreeLevel(2, 2);
    	for(i=4; i < sheetObj.RowCount; i++){			
    		sheetObj.CellAlign(i,"rhq_cd") = daCenter;
			sheetObj.CellAlign(i,"rlane_cd") = daCenter;
			sheetObj.CellAlign(i,"area") = daCenter;			
		}
    }
	
	/**
	 * 체크박스 선택시 Guide Row 를 보여줄지 여부
	 * Add 2013.03.21.
	 */
	function hiddenGuide2(){	
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];
		var ofcSts   = formObj.check_office.checked;
		var guideSts = formObj.check_guide2.checked;
		
		if(sheetObj.RowCount > 0){
			var hRow  = sheetObj.HeaderRows;
			var gRows = sheetObj.ColValueDupRows("hidden_chk", true, true, hRow);
			var gArr  = gRows.split("|");
			
			for(var j = 0; j < gArr.length; j++) {
				var tArr  = gArr[j].split(",");
				
				for(var i = 0; i < tArr.length; i++) {						
					if(sheetObj.CellValue(tArr[i], "hidden_chk") == "OFFICE"){
						if(guideSts && ofcSts) {
							sheetObj.RowExpanded(tArr[i]) = true;
							sheetObj.CellValue2(tArr[i], "acct_lvl") = "-";
						} else {
							sheetObj.RowExpanded(tArr[i]) = false;
							sheetObj.CellValue2(tArr[i], "acct_lvl") = "+";
						}
					} 
				}
			}
		}
		
		//위의 RowExpanded하면서 GUIDE항목이 사라지는 현상이 발생하므로..아래에서 처리
		var uSts = formObj.check_usMod2.checked;
		var aSts = formObj.check_acct2.checked;
		var dSts = formObj.check_destLoc2.checked;
		if(ofcSts) {
			if(dSts) sheetObj.ShowTreeLevel(6, 0);
			else if(aSts) sheetObj.ShowTreeLevel(5, 0);
			else if(uSts) sheetObj.ShowTreeLevel(4, 0);
			else if(guideSts) sheetObj.ShowTreeLevel(3, 0);
			else sheetObj.ShowTreeLevel(2, 0); 
			
			sheetObj.ColHidden("dest_loc_cd") = !dSts;	
			sheetObj.ColHidden("acct_cd") = !(aSts||dSts);
			sheetObj.ColHidden("usa_bkg_mod_cd") = !(uSts||aSts||dSts);
		} else {
			sheetObj.ShowTreeLevel(1, 0);
			sheetObj.ColHidden("dest_loc_cd") = !dSts;	
			sheetObj.ColHidden("acct_cd") = !aSts;
			sheetObj.ColHidden("usa_bkg_mod_cd") = !uSts;
		}

		var arrRow = sheetObj.FindCheckedRow("hg").split("|");
		var arrRow1 = sheetObj.FindCheckedRow("hc1").split("|");
		var arrRow2 = sheetObj.FindCheckedRow("hc2").split("|");
		var arrRow3 = sheetObj.FindCheckedRow("hc3").split("|");

		for (var idx=0; idx < arrRow.length-1; idx++) {			
			sheetObj.RowHidden(arrRow[idx]) = !guideSts;
    		sheetObj.CellAlign(arrRow[idx],"area") = daCenter;
			sheetObj.CellAlign(arrRow[idx],"ofc_cd") = daCenter;
			sheetObj.CellAlign(arrRow[idx],"acct_lvl") = daCenter;
		}
		
		for (var idx=0; idx < arrRow1.length-1; idx++) {
			//office가 선택되어져 있으면 AREA별 UsMode는 무조건 HIDDEN
			if(ComTrim(sheetObj.CellValue(arrRow1[idx], "area")) == ComTrim(sheetObj.CellValue(arrRow1[idx], "ofc_cd")) 
					&& ComTrim(sheetObj.CellValue(arrRow1[idx], "acct_lvl")) == '*') {
				sheetObj.RowHidden(arrRow1[idx]) = ofcSts?true:!uSts;
			}
			else sheetObj.RowHidden(arrRow1[idx]) = !uSts;
		}
		
		for (var idx=0; idx < arrRow2.length-1; idx++) {
			//office가 선택되어져 있으면 AREA별 Acct는 무조건 HIDDEN
			if(ComTrim(sheetObj.CellValue(arrRow2[idx], "area")) == ComTrim(sheetObj.CellValue(arrRow2[idx], "ofc_cd")) 
					&& ComTrim(sheetObj.CellValue(arrRow2[idx], "acct_lvl")) == '*') {
				sheetObj.RowHidden(arrRow2[idx]) = ofcSts?true:!aSts;
			}
			else sheetObj.RowHidden(arrRow2[idx]) = !aSts;
		}
		
		for (var idx=0; idx < arrRow3.length-1; idx++) {
			//office가 선택되어져 있으면 AREA별 Dest는 무조건 HIDDEN
			if(ComTrim(sheetObj.CellValue(arrRow3[idx], "area")) == ComTrim(sheetObj.CellValue(arrRow3[idx], "ofc_cd")) 
					&& ComTrim(sheetObj.CellValue(arrRow3[idx], "acct_lvl")) == '*') {
				sheetObj.RowHidden(arrRow3[idx]) = ofcSts?true:!dSts;
			}
			else sheetObj.RowHidden(arrRow3[idx]) = !dSts;
		}

	}
	
	/**
	 * 체크박스 선택시 Guide Row 를 보여줄지 여부
	 */
	function hiddenGuide2_subOfc(){	
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];
		var sofcSts   = formObj.check_suboffice.checked;
		var guideSts = formObj.check_guide2.checked;
		
		if(sheetObj.RowCount > 0){
			var hRow  = sheetObj.HeaderRows;
			var gRows = sheetObj.ColValueDupRows("hidden_chk", true, true, hRow);
			var gArr  = gRows.split("|");
			
			for(var j = 0; j < gArr.length; j++) {
				var tArr  = gArr[j].split(",");
				
				for(var i = 0; i < tArr.length; i++) {						
					if(sheetObj.CellValue(tArr[i], "hidden_chk") == "OFFICE"){
						if(guideSts && sofcSts) {
							sheetObj.RowExpanded(tArr[i]) = true;
							sheetObj.CellValue2(tArr[i], "acct_lvl") = "-";
						} else {
							sheetObj.RowExpanded(tArr[i]) = false;
							sheetObj.CellValue2(tArr[i], "acct_lvl") = "+";
						}
					} 
				}
				
			}
			
			
		}
		
		//위의 RowExpanded하면서 GUIDE항목이 사라지는 현상이 발생하므로..아래에서 처리
		var uSts = formObj.check_usMod2.checked;
		var aSts = formObj.check_acct2.checked;
		var dSts = formObj.check_destLoc2.checked;
		var oSts = formObj.check_office.checked;
		if(sofcSts) {
			if(dSts) sheetObj.ShowTreeLevel(7, 0);
			else if(aSts) sheetObj.ShowTreeLevel(6, 0);
			else if(uSts) sheetObj.ShowTreeLevel(5, 0);
			else if(guideSts) sheetObj.ShowTreeLevel(4, 0);
			else sheetObj.ShowTreeLevel(3, 0);
			
			sheetObj.ColHidden("dest_loc_cd") = !dSts;	
			sheetObj.ColHidden("acct_cd") = !(aSts||dSts);
			sheetObj.ColHidden("usa_bkg_mod_cd") = !(uSts||aSts||dSts);
		} else {
			if(oSts){
				sheetObj.ShowTreeLevel(2, 0);
			}else{
				sheetObj.ShowTreeLevel(1, 0);
			}
			sheetObj.ColHidden("dest_loc_cd") = !dSts;	
			sheetObj.ColHidden("acct_cd") = !aSts;
			sheetObj.ColHidden("usa_bkg_mod_cd") = !uSts;
		}

		var arrRow = sheetObj.FindCheckedRow("hg").split("|");
		var arrRow1 = sheetObj.FindCheckedRow("hc1").split("|");
		var arrRow2 = sheetObj.FindCheckedRow("hc2").split("|");
		var arrRow3 = sheetObj.FindCheckedRow("hc3").split("|");

		for (var idx=0; idx < arrRow.length-1; idx++) {			
			sheetObj.RowHidden(arrRow[idx]) = !guideSts;
    		sheetObj.CellAlign(arrRow[idx],"area") = daCenter;
			sheetObj.CellAlign(arrRow[idx],"sub_ofc_cd") = daCenter;
			sheetObj.CellAlign(arrRow[idx],"acct_lvl") = daCenter;
		}
		
		for (var idx=0; idx < arrRow1.length-1; idx++) {
			//office가 선택되어져 있으면 AREA별 UsMode는 무조건 HIDDEN
			if(ComTrim(sheetObj.CellValue(arrRow1[idx], "area")) == ComTrim(sheetObj.CellValue(arrRow1[idx], "sub_ofc_cd")) 
					&& ComTrim(sheetObj.CellValue(arrRow1[idx], "acct_lvl")) == '*') {
				sheetObj.RowHidden(arrRow1[idx]) = sofcSts?true:!uSts;
			}
			else sheetObj.RowHidden(arrRow1[idx]) = !uSts;
		}
		
		for (var idx=0; idx < arrRow2.length-1; idx++) {
			//office가 선택되어져 있으면 AREA별 Acct는 무조건 HIDDEN
			if(ComTrim(sheetObj.CellValue(arrRow2[idx], "area")) == ComTrim(sheetObj.CellValue(arrRow2[idx], "sub_ofc_cd")) 
					&& ComTrim(sheetObj.CellValue(arrRow2[idx], "acct_lvl")) == '*') {
				sheetObj.RowHidden(arrRow2[idx]) = sofcSts?true:!aSts;
			}
			else sheetObj.RowHidden(arrRow2[idx]) = !aSts;
		}
		
		for (var idx=0; idx < arrRow3.length-1; idx++) {
			//office가 선택되어져 있으면 AREA별 Dest는 무조건 HIDDEN
			if(ComTrim(sheetObj.CellValue(arrRow3[idx], "area")) == ComTrim(sheetObj.CellValue(arrRow3[idx], "sub_ofc_cd")) 
					&& ComTrim(sheetObj.CellValue(arrRow3[idx], "acct_lvl")) == '*') {
				sheetObj.RowHidden(arrRow3[idx]) = sofcSts?true:!dSts;
			}
			else sheetObj.RowHidden(arrRow3[idx]) = !dSts;
		}

	}
	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){	
		switch(sAction) {
			case IBSEARCH:
				var sheetObj = sheetObjects[beforetab];        
//		    		var rhq = formObj.rhq.value;
	    		var queryString = FormQueryString(formObj);
	    		
	    		if(beforetab < 6 || beforetab == 8){
		    		var area = formObj.area.value;
		            var sales_office = formObj.sales_office.value;
		    		var trade = comObjects[0].Code;
		    		var bound = formObj.bound.value;
		    		var rhq = comObjects[3].Code;
		    		var rhq2 = comObjects[4].Code;
		    		
		    		if(trade==""){
		    			ComShowMessage(getMsg("SPC90114", "Trade"));
		    			formObj.trade.focus();
		    			return false; 
		    		}
		    		
		    		if(beforetab==0){
		    			if(rhq2=="" && area=="" && sales_office==""){
		    				ComShowMessage(getMsg("SPC90121", "RHQ", "Area","Office"));
		    				comObjects[4].focus();
		    				return false; 
		    			}
		    		}else if(beforetab==1){
		    			if(rhq2==""){
		    				ComShowMessage(getMsg("SPC90114", "RHQ"));
		    				comObjects[4].focus();
		    				return false; 
		    			}
		    		}else if(beforetab==8){
		    			if(rhq==""){
		    				ComShowMessage(getMsg("SPC90114", "RHQ"));
		    				comObjects[3].focus();
		    				return false; 
		    			}
		    		}else{	
		    			if(rhq2=="" && area=="" && sales_office==""){
		    				ComShowMessage(getMsg("SPC90121", "RHQ", "Area","Office"));
		    				comObjects[3].focus();
		    				return false; 
		    			}
		    		}
		    		
		    		if(beforetab == 0){
			    		var soSts = formObj.check_suboffice.checked;
			    		if(soSts && (formObj.sales_office.value == null || formObj.sales_office.value == "")){
			    			ComShowMessage(getMsg("SPC90312"));
			    			formObj.check_suboffice.checked = false;
			    			return false; 
			    		}
		    		}else if(beforetab == 1){
			    		var soSts = formObj.check_suboffice5.checked;
			    		if(soSts && (formObj.sales_office.value == null || formObj.sales_office.value == "")){
			    			ComShowMessage(getMsg("SPC90312"));
			    			formObj.check_suboffice5.checked = false;
			    			return false; 
			    		}
		    		}

	    		}else{
	    			var area = formObj.area1.value;
		            var sales_office = formObj.sales_office1.value;
		    		var rhq = comObjects[5].Code;
		    		
		    		if(rhq==""){
		    			ComShowMessage(getMsg("SPC90114", "RHQ"));
	    				comObjects[5].focus();
	    				return false; 
		    		}
	    			if(sales_office==""){
	    				ComShowMessage(getMsg("SPC90114", "Office"));
	    				formObj.sales_office1.focus();
	    				return false; 
	    			}
	    			
	    		}
	    		break;
	    		
			case IBSAVE:
				var trade = formObj.trd_cd.value;
    			var rlane = formObj.rlane_cd.value;
	    		if(trade==""){
	    			ComShowMessage(getMsg("SPC90117", "Lane"));
	    			document.form.trade.focus();
	    			return false; 
	    		}
	    		break;
		}
        return true;
    }
    
    /**
	 * Sales Offeice 변경시
	 */
	function getSalesOffice(rowArray){
        var colArray = rowArray[0];	    	
    	document.all.sales_office.value = colArray[3];        
    }
    
    /**
	 * Sales Offeice1 변경시
	 */
	function getSalesOffice1(rowArray){
        var colArray = rowArray[0];	    	
    	document.all.sales_office1.value = colArray[3];        
    }
    
    /**
     * pol setting
	 */		
	function getPOL(rowArray){
    	var colArray = rowArray[0];	    	
    	document.all.pol_cd.value = colArray[3];        
    }
    
    
    function getEtcDataFromXml(xml, str){
    	var pos = xml.indexOf("ETC KEY=\""+str+"\"");
    	if(pos < 0) return "";
		pos = xml.indexOf(">", pos + 1);
		if(pos < 0) return "";
		var epos = xml.indexOf("</ETC>", pos + 1);
		var rtn = "";
		if(epos < 0){
			rtn = xml.substring(pos + 1);
		}
		else{
			rtn = xml.substring(pos + 1, epos);
		}
		return rtn;
	}
	
	
	/**
	 * 입력한 Office, Port값 체크
	 */
	 function checkValue(obj) {
    	var formObj = document.form;
    	var value;
    	var rtn;
    	
    	if(obj=="office"){
    		value = formObj.sales_office.value;
    		value = ComTrim(value);
    		
	    	if(value.length>0){
				if(value.length<5){
					ComShowMessage(getMsg("SPC90116", "Office"));
					formObj.sales_office.focus();
					return;
				}else{
					rtn = getCodeList("Office", "ofc_cd="+value);
			    	if(rtn[0] == ""){    		
			    		ComShowMessage(getMsg("SPC90106", value));
			    		formObj.sales_office.focus();
			    		return;
			    	}	
				}
	    	}
	    	
    	}else if(obj="pol"){
    		value = formObj.pol_cd.value;
    		value = ComTrim(value);
	    	
	    	if(value.length>0){
		    	if(value.length<5){
		    		ComShowMessage(getMsg("SPC90116", "Port"));
					formObj.pol_cd.focus();
					return;
				}
	    	}
    	}else if(obj=="office1"){
    		value = formObj.sales_office1.value;
    		value = ComTrim(value);
    		
	    	if(value.length>0){
				if(value.length<5){
					ComShowMessage(getMsg("SPC90116", "Office"));
					formObj.sales_office.focus();
					return;
				}else{
					rtn = getCodeList("Office", "ofc_cd="+value);
			    	if(rtn[0] == ""){    		
			    		ComShowMessage(getMsg("SPC90106", value));
			    		formObj.sales_office1.focus();
			    		return;
			    	}	
				}
	    	}
	    	
    	}
    }
	 
	/**
	 * Revenue Lane Setting
	 * 	- 선택된 Trade / Sub Trade 에 해당하는 Rev. Lane 조회 후 Combo 셋팅
	 */
	function RevenueLaneSetting(trdCd, subTrdCd, target) {
		if(trdCd == undefined || trdCd == null){
	 		trdCd = '';
	 	}     		
	 	if(subTrdCd == undefined || subTrdCd == null){
	 		subTrdCd = '';
	 	}     		
//	 	if(target == undefined || target == null){
	 		target = '';
//	 	}
	 	
		rlane_rtn_xml = SpcSearchRevLane("rlane1",true,"N",true,trdCd,subTrdCd);    	
		
//		SpcSearchRevLane("rlane2",true,"N",false,trdCd,subTrdCd);
//		SpcSearchRevLane("rlane3",true,"N",false,trdCd,subTrdCd);
//		SpcSearchRevLane("rlane4",true,"N",false,trdCd,subTrdCd);
//		SpcSearchRevLane("rlane5",true,"N",false,trdCd,subTrdCd);
//		SpcSearchRevLane("rlane6",true,"N",false,trdCd,subTrdCd);
//		SpcSearchRevLane("rlane11",true,"N",false,trdCd,subTrdCd);
		
		var rlane1_combo = document.getElementById("rlane1");
//		var rlane2_combo = document.getElementById("rlane2");
//		var rlane3_combo = document.getElementById("rlane3");
//		var rlane4_combo = document.getElementById("rlane4");
//		var rlane5_combo = document.getElementById("rlane5");
//		var rlane6_combo = document.getElementById("rlane6");
//		//var rlane7_combo = document.getElementById("rlane7");
//		var rlane11_combo = document.getElementById("rlane11");
		
		if(target == '' || target == 1){
    		ComXml2ComboItem(rlane_rtn_xml, rlane1_combo, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm|flg");
    		rlane1_combo.InsertItem(0, "||ALL|ALL|");
		}
//		
//		if(target == '' || target == 2){
//    		ComXml2ComboItem(rlane_rtn_xml, rlane2_combo, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm|flg");
//    		rlane2_combo.InsertItem(0, "||ALL|ALL|");
//		}
//		if(target == '' || target == 4){
//    		ComXml2ComboItem(rlane_rtn_xml, rlane3_combo, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm|flg");
//    		rlane3_combo.InsertItem(0, "||ALL|ALL|");
//		}
//		if(target == '' || target == 5){
//    		ComXml2ComboItem(rlane_rtn_xml, rlane4_combo, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm|flg");
//    		rlane4_combo.InsertItem(0, "||ALL|ALL|");
//		}
//		if(target == '' || target == 3){
//			ComXml2ComboItem(rlane_rtn_xml, rlane5_combo, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm|flg");
//			rlane5_combo.InsertItem(0, "||ALL|ALL|");
//		}
//		if(target == '' || target == 6){
//			ComXml2ComboItem(rlane_rtn_xml, rlane6_combo, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm|flg");
//			rlane6_combo.InsertItem(0, "||ALL|ALL|");
//		}
//		if(target == '' || target == 9){ // 탭 FCST&PFMC Status by ACCT 
//			ComXml2ComboItem(rlane_rtn_xml, rlane11_combo, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm|flg");
//			rlane11_combo.InsertItem(0, "||ALL|ALL|");
//		}
	}
	
	/**
	 * Revenue Lane Setting2 
	 * 	- 사용자가 등록한 Rev. Lane 일 경우 Combo에 체크
	 * 2012.01.20 SHKIM
	 */
	function RevenueLaneSetting2(trdCd,xmlStr) {
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);
        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return;
        var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);            
        var sep = dataNode.getAttribute("COLSEPARATOR");
        var total = dataNode.getAttribute("TOTAL");
        var dataChildNodes = dataNode.childNodes;
        if (dataChildNodes == null) {
            return;
        }
        var col = dataNode.getAttribute("COLORDER");
        if(col == null || col == '') return; 
        var colArr = col.split("|");
        var colList = "trd_cd|sub_trd_cd|rlane_cd";
        var colListArr = colList.split("|");
        var colListIdx = Array();
        for (var i = 0; i < colListArr.length; i++) {
            for (var j = 0; j < colArr.length; j++) {
                if (colListArr[i] == colArr[j]) { colListIdx[i] = j;    break;     }
            }
        }
        var rtnArr = new Array();
        for (var i = 0; i < dataChildNodes.length; i++) {
            if (dataChildNodes[i].nodeType != 1) {  continue;     }
            var arrData = null;
            if (sep == null || sep == "") {
                arrData = new Array();
                var trChildNodes = dataChildNodes[i].childNodes;
                for (var j = 0; j < trChildNodes.length; j++) {
                    if (trChildNodes[j].nodeType != 1) { continue; }
                    arrData.push(trChildNodes[j].firstChild.nodeValue);
                }
            } else { arrData = dataChildNodes[i].firstChild.nodeValue.split(sep); }
            var subDataArr = new Array();
            for (var j = 0; j < colListIdx.length; j++) {
                subDataArr[j] = arrData[colListIdx[j]];
            }
            rtnArr[i] = (subDataArr);
        }
		var objText = "";
		var obj = document.getElementById('rlane1');
		for( i=1 ; i<obj.GetCount() ; i++ ){
			objText = obj.GetIndexText(i,0)+","+ obj.GetIndexText(i,1)+","+obj.GetIndexText(i,2);
			for( iJ = 0 ; iJ< total ; iJ++ ){	if(objText == rtnArr[iJ]){	obj.CheckIndex(i) = true;	}		}
		}
	}	
	
	/** 
	 * COMBO 변경 이벤트
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 */
	function rlane1_OnChange(comboObj,Index_Code, Text){    		    		
		var subtrade_value      = comboObj.GetText(Index_Code,1);
		comboValue              = comboObj.Code;    
	}    	
	
    /**
     * rlane1 콤보를 클릭할 때 전체체크
     * @param comboObj
     * @param index
     * @param code
     * @return
     */
    function rlane1_OnCheckClick(comboObj, index, code) {
    	if (code == "" || code == "All") {
    		var bChk = comboObj.CheckIndex(index);
    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			comboObj.CheckIndex(i) = bChk;
        	}
       }else{
    	   comboObj.CheckIndex(0) = false;
       }
    }

    /**
     * rlane2 콤보를 클릭할 때 전체체크
     * @param comboObj
     * @param index
     * @param code
     * @return
    
    function rlane2_OnCheckClick(comboObj, index, code) {
    	if (code == "" || code == "All") {
    		var bChk = comboObj.CheckIndex(index);
    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			comboObj.CheckIndex(i) = bChk;
        	}
       }else{
    	   comboObj.CheckIndex(0) = false;
       }
    } */
    
    /**
     * rlane3 콤보를 클릭할 때 전체체크
     * @param comboObj
     * @param index
     * @param code
     * @return
    
    function rlane3_OnCheckClick(comboObj, index, code) {
    	if (code == "" || code == "All") {
    		var bChk = comboObj.CheckIndex(index);
    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			comboObj.CheckIndex(i) = bChk;
        	}
       }else{
    	   comboObj.CheckIndex(0) = false;
       }
    	
    } */
    
     /** SHKIM 20120613
      * rlane3 콤보를 클릭할 때 전체체크
      * @param comboObj
      * @param index
      * @param code
      * @return
     
     function rlane4_OnCheckClick(comboObj, index, code) {
     	if (code == "" || code == "All") {
     		var bChk = comboObj.CheckIndex(index);
     		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
     			comboObj.CheckIndex(i) = bChk;
         	}
        }else{
     	   comboObj.CheckIndex(0) = false;
        }
     	
     }   */
     
     /**
      * rlane5 콤보를 클릭할 때 전체체크
      * @param comboObj
      * @param index
      * @param code
      * @return
     
     function rlane5_OnCheckClick(comboObj, index, code) {
     	if (code == "" || code == "All") {
     		var bChk = comboObj.CheckIndex(index);
     		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
     			comboObj.CheckIndex(i) = bChk;
         	}
        }else{
     	   comboObj.CheckIndex(0) = false;
        }
     } */
     

     /**
      * rlane6 콤보를 클릭할 때 전체체크
      * @param comboObj
      * @param index
      * @param code
      * @return
      
     function rlane6_OnCheckClick(comboObj, index, code) {
     	if (code == "" || code == "All") {
     		var bChk = comboObj.CheckIndex(index);
     		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
     			comboObj.CheckIndex(i) = bChk;
         	}
        }else{
     	   comboObj.CheckIndex(0) = false;
        }
     }*/
     
     /**
      * rlane7 콤보를 클릭할 때 전체체크
      * @param comboObj
      * @param index
      * @param code
      * @return
      */
     function rlane7_OnCheckClick(comboObj, index, code) {
    	 if (code == "" || code == "All") {
    		 var bChk = comboObj.CheckIndex(index);
    		 for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			 comboObj.CheckIndex(i) = bChk;
    		 }
    	 }else{
    		 comboObj.CheckIndex(0) = false;
    	 }
     }
     
     /**
      * rlane11 콤보를 클릭할 때 전체체크
      * @param comboObj
      * @param index
      * @param code
      * @return
      
     function rlane11_OnCheckClick(comboObj, index, code) {
    	 if (code == "" || code == "All") {
    		 var bChk = comboObj.CheckIndex(index);
    		 for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			 comboObj.CheckIndex(i) = bChk;
    		 }
    	 }else{
    		 comboObj.CheckIndex(0) = false;
    	 }
     }*/
     
     /**
      * trade7 콤보를 클릭할 때 전체체크
      * @param comboObj
      * @param index
      * @param code
      * @return
      */
     function trade7_OnCheckClick(comboObj, index, code) {
    	 if (code == "" || code == "All") {
    		 var bChk = comboObj.CheckIndex(index);
    		 for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			 comboObj.CheckIndex(i) = bChk;
    		 }
    	 }else{
    		 comboObj.CheckIndex(0) = false;
    	 }
     }
     
	/** 
	 * COMBO 변경 이벤트
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 
	function rlane2_OnChange(comboObj,Index_Code, Text){
		var subtrade_value      = comboObj.GetText(Index_Code,1);
		comboValue              = comboObj.Code;    
	} */

	/** 
	 * COMBO 변경 이벤트
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 
	function rlane3_OnChange(comboObj,Index_Code, Text){    		    		
		var subtrade_value      = comboObj.GetText(Index_Code,1);
		comboValue              = comboObj.Code;    
	}  */

	/** 
	 * COMBO 변경 이벤트
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 
	function rlane4_OnChange(comboObj,Index_Code, Text){    		    		
		var subtrade_value      = comboObj.GetText(Index_Code,1);
		comboValue              = comboObj.Code;    
	} */
     
	/** 
	 * COMBO 변경 이벤트
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 
	function rlane5_OnChange(comboObj,Index_Code, Text){
		var subtrade_value      = comboObj.GetText(Index_Code,1);
		comboValue              = comboObj.Code;    
	} */

	/** 
	 * COMBO 변경 이벤트
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 
	function rlane6_OnChange(comboObj,Index_Code, Text){
		var subtrade_value      = comboObj.GetText(Index_Code,1);
		comboValue              = comboObj.Code;    
	}*/
	
	/** 
	 * COMBO 변경 이벤트
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 */
	function rlane7_OnChange(comboObj,Index_Code, Text){
		var subtrade_value      = comboObj.GetText(Index_Code,1);
		comboValue              = comboObj.Code;    
	}
	
	/** 
	 * COMBO 변경 이벤트
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	
	function rlane8_OnChange(comboObj,Index_Code, Text){
		var subtrade_value      = comboObj.GetText(Index_Code,1);
		comboValue              = comboObj.Code;    
	} */
	
	/** 
	 * COMBO 변경 이벤트
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	
	function rlane11_OnChange(comboObj,Index_Code, Text){
		var subtrade_value      = comboObj.GetText(Index_Code,1);
		comboValue              = comboObj.Code;    
	} */
	
	/** 
	 * COMBO 변경 이벤트
	 * @param	{IBMultiCombo}	comboObj	revenue 콤보 이름
	 * @param	{IBMultiCombo}	comboObj	subTrade 콤보 이름
	 * @param	{Number}		subtrade_value	선택한 콤보 value의 sub trade 값 
	 */
	function rlane_to_subtrade_change(comboObj,eleName,subtrade_value){
		var formObj            = document.form; 
		var cnt = 0;
		var chk_cnt = 0;
		var subtrade_combo = document.getElementById(eleName);    		
		subtrade_combo.Code = subtrade_value;
	}
	
	/** 
	 * revenue Lane의 combo 전체 check true or false 선택
	 * @param	{String}	elemName	revenue 콤보 이름
	 * @param	{booleadn}	chk_flg	    전체 check 여부
	 */    	
	function reset_rlane_combo(elemName,chk_flg){
		var obj = document.getElementById(elemName);
		obj.Code = "";
		for(var i = 1 ; i < obj.GetCount() ; i++) {
			obj.CheckIndex(i) = chk_flg;
		}    		
		
	}
	
    /**
     * Dest.(IAS) Check Box 선택여부에 따라 Dest.컬럼 Hidden 조정
     * @return
     */
	function hiddenCheck(){
		var formObj = document.form;
		var sheetObj = null;
		var vlaue = "";
		
		if(beforetab == 0){		
			if (formObj.check_dest2.checked ) {
	    		formObj.check_dest2.value = "Y";
	    	} else {
	    		formObj.check_dest2.value = "N";
	    	}
			sheetObj = sheetObjects[0];
			value = formObj.check_dest2.value;
			
		} else if(beforetab == 1){			
			sheetObj = sheetObjects[1];
			if (formObj.check_dest5.checked ) {
	    		formObj.check_dest5.value = "Y";
	    	} else {
	    		formObj.check_dest5.value = "N";
	    	}
			value = formObj.check_dest5.value;
			
		} else if(beforetab == 2){			
			sheetObj = sheetObjects[2];
			if (formObj.check_dest3.checked ) {
	    		formObj.check_dest3.value = "Y";
	    	} else {
	    		formObj.check_dest3.value = "N";
	    	}
			value = formObj.check_dest3.value;
		}		
    	if(value == "Y"){
    		sheetObj.ColHidden("dest") = false;
    		hiddenDest(false);
    	} else {
    		sheetObj.ColHidden("dest") = true;
    		hiddenDest(true);
    	}	
	}
	
	/**
     * Dest Sub TTL 항목 숨김처리 - Dest.(IAS) 를 체크한 경우에만 Dest Sub TTL 이 보여지도록 함.
     */
	function hiddenDest(sts){
		var formObj = document.form;
		var sheetObj = null;
		var rlane = "";
		
		if(beforetab == 0){
			sheetObj = sheetObjects[0];
		} else if(beforetab == 1){
			sheetObj = sheetObjects[1];
		} else if(beforetab == 2){	// SHKIM 20120613
			sheetObj = sheetObjects[2];
		} 
		
		for(i=3; i < sheetObj.RowCount; i++){
			rlane = sheetObj.CellValue(i, "rlane_cd");
			if(sheetObj.CellValue(i, "dest") != " " && rlane.substr(rlane.length-3, 3) == "TTL"){
				sheetObj.RowHidden(i) = sts;
			}
		}
		
		if(sts == false){			
			changeTitle2(document.form.check_office,  '1');
			changeTitle2_subOfc(document.form.check_suboffice,  '1');

			changeTitle3(document.form.check_office2, '1');
			checkBoxControl5(document.form.check_office5);//changeTitle5(document.form.check_office5, '1');
			//Add 2012.08.08.
			changeTitle6(document.form.check_office5, '1');
		}
	}
	
	/**
	 * Trade에 따라 CheckBox Control
	 * IAS일 경우만 Dest.(IAS) Check Box 선택가능
	 * @return
	 */
	function controlCheckBox(){
		var formObj = document.form;
		var trade   = formObj.trade.Code;
		
		if(trade == "IAS"){
			formObj.check_dest2.disabled = false;
			formObj.check_dest3.disabled = false;
			formObj.check_dest5.disabled = false;
			
			formObj.check_sector2.disabled = false;
			formObj.check_sector5.disabled = false;
			
		} else {
			formObj.check_dest2.disabled = true;
			formObj.check_dest2.value = "N";
			formObj.check_dest2.checked = false;
			
			formObj.check_dest3.disabled = true;
			formObj.check_dest3.value = "N";
			formObj.check_dest3.checked = false;
			
			formObj.check_dest5.disabled = true;
			formObj.check_dest5.value = "N";
			formObj.check_dest5.checked = false;
			
			formObj.check_sector2.disabled = true;
			formObj.check_sector2.value = "N";
			formObj.check_sector2.checked = false;
			
			formObj.check_sector5.disabled = true;
			formObj.check_sector5.value = "N";
			formObj.check_sector5.checked = false;
		}
	}
	
    /**
     * Start Week 의 year 변경시
     * Start Week 의 year 변경시 주차 변경
     */
    function checkWeek(){
    	SpcSearchOptionWeek("week1",false,document.form.year.value);
    	
    }	
    
    /**
     * Direction 변경시 
     *  - 선택된 Trade , Sub Trade에 해당하는 Sub Trade / Rev.Lane 정보 Combo 셋팅
     * @param obj
     */
    function bound_Change(obj){
    	var formObj = document.form;
//    	formObj.item1.value = "1";
    	
    	var trade = formObj.trade.Code;
    	var dir_cd = formObj.bound.value;
    	var sub_trd_cd = "";
    	if(beforetab != 7 && beforetab != 8) sub_trd_cd = formObj.subtrade1.Code;
//    	else if(beforetab == 1) sub_trd_cd = formObj.subtrade2.Code;
//    	else if(beforetab == 2) sub_trd_cd = formObj.subtrade5.Code;
//    	else if(beforetab == 3) sub_trd_cd = formObj.subtrade3.Code;
//    	else if(beforetab == 4) sub_trd_cd = formObj.subtrade4.Code;
//    	else if(beforetab == 5) sub_trd_cd = formObj.subtrade5.Code;
//    	else if(beforetab == 6) sub_trd_cd = formObj.subtrade6.Code;
//    	//else if(beforetab == 7) sub_trd_cd = formObj.subtrade7.Code;
//    	//else if(beforetab == 8) sub_trd_cd = formObj.subtrade8.Code;
//    	else if(beforetab == 8) sub_trd_cd = formObj.subtrade11.Code;
    	
		if(trade == null || trade == ''){
			ComShowMessage(getMsg("SPC90117", "Trade"));
    		ComOpenWait(false);
			return;
		}
		
		document.formSel.f_cmd.value = SEARCHLIST09;
		var param = trade;
		document.formSel.trd_cd.value = trade;
		document.formSel.sub_trd_cd.value = sub_trd_cd;
		document.formSel.dir_cd.value = dir_cd;
		var rtn1 = sheetObjects[0].GetSearchXml("ESM_SPC_0021GS6.do", FormQueryString(document.formSel)); //DefaultViewAdapter
		
		// [E] 2012.01.19 SHKIM CHECK 가져오기 ..
		RevenueLaneSetting(formObj.trade.Code);      		
		RevenueLaneSetting(formObj.trade.Code, sub_trd_cd, beforetab+1);      		
		controlCheckBox();    		
		RevenueLaneSetting2(formObj.trade.Code,rtn1);
    }
    
    /**
     * Week 변경시 
     *  - 화주 List 가져온다
     * @param obj
     */
    function week_Change(obj){
    	setGrpAcctNAcct();
    }
    
    /**
     * SMP Non SMP 변경시 
     *  - 화주 List 가져온다
     * @param obj
     */
    function smp_Change(obj){
    	setGrpAcctNAcct();
    }
    
    function setGrpAcctNAcct(){
     	var formObj = document.form;
     	var check_smp = getRadioValue(formObj.check_smp);
     	if(check_smp == "SMP"){
         	//Account 콤보 세팅
        	var rtn = getCodeList("TradeAccount", "trade="     +formObj.trade.Code
    							                 +"&year="     +formObj.year.value
    							                 +"&week="     +formObj.week1.value
    							                 +"&duration=" +formObj.duration.value);
    		initData_acctList(rtn[0].split("|"), rtn[1].split("|"));
    		
    		//Group Account 콤보 세팅
    		var rtn = getCodeList("TradeAccount",  "trade="     +formObj.trade.Code
    								   		 	  +"&year="	    +formObj.year.value
    								   		   	  +"&week="	    +formObj.week1.value
    								   			  +"&duration=" +formObj.duration.value
    								   			  +"&grp=Y");
    		initData_groupAcctList(rtn[0].split("|"), rtn[1].split("|"));
     		
     	}else if(check_smp == "NSMP"){
         	//Account 콤보 세팅
        	var rtn = getCodeList("NSmpAccount", "trade="      +formObj.trade.Code
    							                 +"&year="     +formObj.year.value
    							                 +"&week="     +formObj.week1.value
    							                 +"&duration=" +formObj.duration.value
    							                 +"&rhqCd="	   +formObj.rhq.Code);
    		initData_acctList(rtn[0].split("|"), rtn[1].split("|"));
    		
         	var combo = document.getElementById("grp_acct");
         	combo.enable = false;
     		
     	}
     }
    
    
    /**
	 * 체크박스 선택시 Allocation 컬럼을 보여줄지 여부
	 * Add 2012.08.08.
	 */
	function sheet6OfficeView(){    	
		
		
		var sheetObj = sheetObjects[4];
		var formObj = document.form;				
		var veiwYN= formObj.officeView.checked;
		
		var colOffice =0;
		var colPort =0;
		var rowCount=sheetObj.RowCount+4;
		/*********************** Office 컬럼이 부모 level 일 때 [Start]*****************************/
		  if(formObj.viewDiv.value =="OFFICE"){
			  colOffice =6;
			  colPort =7;			  
			   // 자식 객체 점검
				 if(! veiwYN){
					 if(  formObj.portView.checked ){
					 formObj.portView.checked= false;
					 sheet6PortView();
					 }
				 }				 
				 for(var row = 0 ; row< rowCount; row++){
					 if(sheetObj.CellValue(row, colOffice) == "+"
					   || sheetObj.CellValue(row, colOffice) == "-"){
						 if(veiwYN){				   
				    			sheetObj.RowExpanded(row) = true;
				   				sheetObj.CellValue2(row, colOffice) = "-";		    		
						 }else{
								sheetObj.RowExpanded(row) = false;
					   			sheetObj.CellValue2(row, colOffice) = "+";					 	
						 }   
				 	}
			    }
					 
		/*********************** Office 컬럼이 부모 level 일 때 [End]*****************************/
		
	    /*********************** Office 컬럼이 Child level 일 때 [Start]*****************************/	  
		  } else if(formObj.viewDiv.value =="PORT"){
			  colPort =6;
			  colOffice =7;			  
			   // 부모 객체 점검
				 if(veiwYN){
					 if( ! formObj.portView.checked ){
					 formObj.portView.checked=veiwYN;
					 sheet6PortView();
					 }
				 }				 
				 for(var row = 0 ; row< rowCount; row++){					
					 if(veiwYN){						 
					    if( sheetObj.CellValue(row, colOffice) == "+"){			    			
			   				sheetObj.CellValue2(row, colOffice) = "-";
			   				
			   				if(sheetObj.CellValue(row, colPort) != "+")
			   				sheetObj.RowExpanded(row) = true;
			    		} 
					 }else{
						 if( sheetObj.CellValue(row, colOffice) == "-"){							 
							 sheetObj.CellValue2(row, colOffice) = "+";							 
							 if(sheetObj.CellValue(row, colPort) != "-"){								 
								 sheetObj.RowExpanded(row) = false;	
							 }							 
						 }	
					 }   
			    }			  
		  }  
	  /*********************** Office 컬럼이 Child level 일 때 [End]*****************************/        
		  
		
		
    }
	
	
	 /**
	 * 체크박스 선택시 Allocation 컬럼을 보여줄지 여부
	 * Add 2012.08.08.
	 */
	function sheet6PortView(){    	
				
		var sheetObj = sheetObjects[4];
		var formObj = document.form;				
		var veiwYN= formObj.portView.checked;		
		var colOffice =0;
		var colPort =0;
		var rowCount=sheetObj.RowCount+4;
		/*********************** Port  컬럼이 Child Level 일 때 [Start]*****************************/
		  if(formObj.viewDiv.value =="OFFICE"){
			  colOffice =6;
			  colPort =7;
			  
			// 부모 객체 점검
				 if(veiwYN){
					 if( ! formObj.officeView.checked ){
					 formObj.officeView.checked=veiwYN;
					 sheet6OfficeView();
					 }
				 }
				 
				 for(var row = 0 ; row< rowCount; row++){
					
					 if(veiwYN){						 
					    if( sheetObj.CellValue(row, colPort) == "+"){			    			
			   				sheetObj.CellValue2(row, colPort) = "-";
			   				if(sheetObj.CellValue(row, colOffice) != "+")
			   				sheetObj.RowExpanded(row) = true;
			    		} 
					 }else{
						 if( sheetObj.CellValue(row, colPort) == "-"){
							 sheetObj.CellValue2(row, colPort) = "+";
							if(sheetObj.CellValue(row, colOffice) != "-")	
							 sheetObj.RowExpanded(row) = false;				   			
						 }	
					 }   
			    }	
		
	  /*********************** Port  컬럼이 Child Level  일 때 [End]*****************************/	
				 

	 /*********************** Port  컬럼이 부모 Level  일 때 [Start]*****************************/				 
		  } else if(formObj.viewDiv.value =="PORT"){
			  colPort =6;
			  colOffice =7;
			  
			// 자식 객체 점검
				 if(! veiwYN){
					 if(  formObj.officeView.checked ){
					 formObj.officeView.checked= false;
					 sheet6OfficeView();
					 }
				 }				 
				 for(var row = 0 ; row< rowCount; row++){
					 if(sheetObj.CellValue(row, colPort) == "+"
					   || sheetObj.CellValue(row, colPort) == "-"){
						 if(veiwYN){				   
				    			sheetObj.RowExpanded(row) = true;
				   				sheetObj.CellValue2(row, colPort) = "-";		    		
						 }else{
								sheetObj.RowExpanded(row) = false;
					   			sheetObj.CellValue2(row, colPort) = "+";					 	
						 }   
				 	}
			    }
		  }  
	      
    /*********************** Port  컬럼이 부모 Level  일 때 [End]*****************************/		
			
		 
    }
	
	
	 /**
	 * 체크박스 선택시 Allocation 컬럼을 보여줄지 여부
	 * Add 2012.08.08.
	 */
	function sheet6TypeView(){    	
		
		var sheetObj = sheetObjects[4];
		var formObj = document.form;
		var week1 = sheetObj.EtcData("week");
	    	if(week1 == undefined){
	    		week1="200701|200702|200703";
	    	}
	    var weekArr = week1.split("|");
	    var veiwYN;
		
		if(formObj.typeView.checked)
			veiwYN = false;
		else 
			veiwYN = true;
		
		
			 for(var j = 1 ; j <= weekArr.length+1 ; j++){
	            	var m =1;
	            	
	            	sheetObj.ColHidden("bkg_20"+m+j) = veiwYN;
	            	sheetObj.ColHidden("bkg_40"+m+j) = veiwYN;
	            	sheetObj.ColHidden("bkg_d2"+m+j) = veiwYN;
	            	sheetObj.ColHidden("bkg_d4"+m+j) = veiwYN;
	            	sheetObj.ColHidden("bkg_hc"+m+j) = veiwYN;
	            	sheetObj.ColHidden("bkg_rd"+m+j) = veiwYN;
	            	sheetObj.ColHidden("bkg_45"+m+j) = veiwYN;
	            	sheetObj.ColHidden("bkg_53"+m+j) = veiwYN;
	            	
	            	sheetObj.ColHidden("bkg_r2"+m+j) = veiwYN;
	            	sheetObj.ColHidden("bkg_r5"+m+j) = veiwYN;	            	            	  
	            }
			 
			 if(formObj.typeView.checked || formObj.cntrView.checked )
				 sheetObj.RowHidden(3) = false;
			 else 
				 sheetObj.RowHidden(3) = true;
    }
	
	
	 /**
	 * 체크박스 선택시 Allocation 컬럼을 보여줄지 여부
	 * Add 2012.08.08.
	 */
	function sheet6CntrView(){    	
		
		var sheetObj = sheetObjects[4];
		var formObj = document.form;
		var week1 = sheetObj.EtcData("week");
	    	if(week1 == undefined){
	    		week1="200701|200702|200703";
	    	}
	    var weekArr = week1.split("|");
	    var veiwYN;
			
			if(formObj.cntrView.checked)
				veiwYN = false;
			else 
				veiwYN = true;
			
			
		
			 for(var j = 1 ; j < weekArr.length+1 ; j++){
	            	var m =1;
	            	sheetObj.ColHidden("cm_en"+m+j) = veiwYN;
	            	sheetObj.ColHidden("cm_op"+m+j) = veiwYN;
	            	sheetObj.ColHidden("cm_oc"+m+j) = veiwYN;
	            	sheetObj.ColHidden("cm_vl"+m+j) = veiwYN;	            	  
	            }
			 
			 if(formObj.typeView.checked || formObj.cntrView.checked )
			 sheetObj.RowHidden(3) = false;
			 else 
			 sheetObj.RowHidden(3) = true;
		
    }
	
	
	
	 /**
	 * 체크박스 선택시 Allocation 컬럼을 보여줄지 여부
	 * Add 2012.08.08.
	 * Drop 2014.07.25 by Shin
	 */
	function sheet6PortReSearch(pordDiv){    	
		 if(pordDiv=='N') {
			 var pobj = document.form.div_cd;
			 if(pobj[0].checked)  pordDiv="POR"
			 else if(pobj[1].checked) pordDiv="POL"
			 else pordDiv="DEL"
		 }	
	 document.form.port_div.value = pordDiv;
		
	 var formObject = document.form;
	 var sheetObject5 = sheetObjects[4];	// Add 2012.08.08
	 
	 // View가 BKG 이고 POR/DEL 선택시 Input Box를 보여준다.
	 if (document.getElementById("viewDiv").selectedIndex==1){
		 if(document.all.div_cd[0].checked) {   // POR
			 formObject.por_cd.style.display = "Inline";
			 formObject.del_cd.value = "";
			 formObject.del_cd.style.display = "none"
		 } else if(document.all.div_cd[3].checked) {          // DEL
			 formObject.del_cd.style.display = "Inline";
			 formObject.por_cd.value = "";
			 formObject.por_cd.style.display = "none";
		 } else {
			 formObject.del_cd.value = "";
			 formObject.del_cd.style.display = "none";
			 formObject.por_cd.value = "";
			 formObject.por_cd.style.display = "none";
		 }
	 }
//	doActionIBSheet(sheetObject5,formObject,IBSEARCH);
//	tab_retrives[5] = true;
		
    }
	
	/**
	 * 체크박스 선택시 Allocation 컬럼을 보여줄지 여부
	 * Add 2012.08.08.
	 */
	function showAlloc6(){    	
		var sheetObj = sheetObjects[4];
		var formObj = document.form;
		var week1 = sheetObj.EtcData("week");
	    	if(week1 == undefined){
	    		week1="200701|200702|200703";
	    	}
	    var weekArr = week1.split("|");
	    var veiwYN;
			
			if(formObj.check_alloc6.checked)
				veiwYN = false;
			else 
				veiwYN = true;
		
			 for(var j = 1 ; j < weekArr.length+1 ; j++){
	            	var m =1;
	            	sheetObj.ColHidden("alc"+m+j) = veiwYN;
	            	sheetObj.ColHidden("alc_rf"+m+j) = veiwYN;            	  
	            }
			 
			 if(formObj.typeView.checked || formObj.cntrView.checked )
			 sheetObj.RowHidden(3) = false;
			 else 
			 sheetObj.RowHidden(3) = true;
    }
 
	
	/**
	 * 체크박스 선택시 Allocation 컬럼을 보여줄지 여부
	 * Add 2012.08.08.
	 */
	function setSheet6View(){    	
		
    	var sheetObj = sheetObjects[4];
		var formObj = document.form;
		var week1 = sheetObj.EtcData("week");
	    	if(week1 == undefined){
	    		week1="200701|200702|200703";
	    	}
	    var weekArr = week1.split("|");
	        
		var veiwYN= formObj.check_alloc6.checked;
		
			 for(var j = 1 ; j <= weekArr.length+1 ; j++){
	            	var m =1;
	            	
	            	sheetObj.ColHidden("bkg_20"+m+j) = veiwYN;
	            	sheetObj.ColHidden("bkg_40"+m+j) = veiwYN;
	            	sheetObj.ColHidden("bkg_d2"+m+j) = veiwYN;
	            	sheetObj.ColHidden("bkg_d4"+m+j) = veiwYN;
	            	sheetObj.ColHidden("bkg_hc"+m+j) = veiwYN;
	            	sheetObj.ColHidden("bkg_rd"+m+j) = veiwYN;
	            	sheetObj.ColHidden("bkg_45"+m+j) = veiwYN;
	            	sheetObj.ColHidden("bkg_53"+m+j) = veiwYN;
	            	
	            	sheetObj.ColHidden("bkg_r2"+m+j) = veiwYN;
	            	sheetObj.ColHidden("bkg_r5"+m+j) = veiwYN;
	            	
	            	sheetObj.ColHidden("cm_op"+m+j) = veiwYN;
	            	sheetObj.ColHidden("cm_oc"+m+j) = veiwYN;
	            	sheetObj.ColHidden("cm_vl"+m+j) = veiwYN;	            	  
	            }			 
			 sheetObj.RowHidden(3) = veiwYN;
			 
	}
	
	/**
	 * 체크박스 선택시 Allocation 컬럼을 보여줄지 여부
	 * Add 2012.08.08.
	 * Drop 2014.07.25 by Shin
	 */
	function doSelectSheet6ByView(){
		var sheetObj = sheetObjects[4];
		var formObj = document.form;
//		doActionIBSheet(sheetObj,formObj,IBSEARCH);//콤보선택시 재조회하는기능 막음(by shin)
		sheet6PortReSearch('N');
	}
	
	/**
	 * Office 변경시 해당 소속 Sales Rep List 조회하여 매핑
	 * @param obj
	 */
	function setSalesRepCombo(obj) {
		if (obj.value == "")
			return;
		
		var rtn = getCodeList("TeamSalesRep", "ofc_cd=" + obj.value + "&level=4");
		initData_salesRep(rtn[0].split("|"), rtn[1].split("|"));
	}
	
	function initData_salesRep(codes, names) {
		var sheetObj = document.getElementById("srep_cd");
		var cnt = 0;

		with (sheetObj) {
			RemoveAll();
			SetTitle("Code|Name|OFC|OFC NM");
			SetColWidth("60|150|60|100");
			SetColAlign("left|left|left|left");
			ShowCol = 0;
			MultiSelect = false;
			MaxSelect = 1;
			DropHeight = 190;

			if (codes == undefined || codes == null) {
				return;
			}

			if (codes.length > 2) {
				InsertItem(-1, "|ALL", "");
			}

			var selectCode = "";
			for ( var i = 0; i < codes.length - 1; i++) {
				var txt = names[i].split("~");
				if (txt[3] == "1") {
					selectCode = codes[i];
				}
				InsertItem(-1, codes[i] + "|" + names[i].replace(/~/g, "|"),
						codes[i]);
			}

			if (selectCode != "") {
				Code = selectCode;
			} else {
				Index = 0;
			}
		}
	}
	
	/**
	 * Sheet7 조회 후
	 * 	- BKG Customer 정보 숨김처리
	 */
	function sheet7_OnSearchEnd(sheetObj, ErrMsg){		
		
        var formObj = document.form;

        sheet7ColView("ctrt_cust_cd", false);
        sheet7ColView("pol_cd", false);
        sheet7ColView("pod_cd", true);
        //sheet7HiddenItems();
		 
	}
	
	/**
	 * Sheet7 OnClick Event
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 */
	function sheet7_OnClick(sheetObj, Row, Col, Value){
		var formObj = document.form;
		
		switch(sheetObj.ColSaveName(Col)){
			// Other Account Click시 - Other Account로 Grouping된 BKG Account List 펼치기.
			case "ctrt_cust_cd":
				 if (Value == "XX999999"){
					 var gid = sheetObj.CellValue(Row, "gid");
		
					 for(i=4; i<sheetObj.RowCount+4; i++){
						 if(sheetObj.CellValue(i, "gid") == gid && sheetObj.CellValue(i, "lvl") == 2){
							 sheetObj.RowHidden(i) = !(sheetObj.RowHidden(i));
						 }
					 }
					 
					 //sheet7ColView("crtr_cust_cd", false);
					 //sheet7ColView("pol_cd", false);
					 sheet7ColView("pod_cd", false);
				 }
				 break;
			case "ctrt_cust_cd":
			case "pol_cd":
			case "pod_cd":
				if(sheetObj.CellValue(Row, Col) == "+"){
	    			sheetObj.RowExpanded(Row) = true;
	   				sheetObj.CellValue2(Row, Col) = "-";
	    		}else if(sheetObj.CellValue(Row, Col) == "-"){
	    			sheetObj.RowExpanded(Row) = false;
	   				sheetObj.CellValue2(Row, Col) = "+";
	    		} 
				break;
		}
	}
	
	function sheet7HiddenItems(){
		var sheetObj = sheetObjects[6];
		var formObj = document.form;
		var tpsz = formObj.check_tpsz7.checked;
		var crr = sheetObj.EtcData("crr");
    	if(crr == undefined){
    		crr="CAX";
    	}
    	var crrArr = crr.split(",");
		
		for(var j = 1 ; j < crrArr.length+1 ; j++){
        	var m =1;
			sheetObj.ColHidden("fcast_20"+m+j) = !tpsz;
			sheetObj.ColHidden("fcast_40"+m+j) = !tpsz;
			sheetObj.ColHidden("bkg_20"+m+j) = !tpsz;
			sheetObj.ColHidden("bkg_40"+m+j) = !tpsz;
			sheetObj.ColHidden("pref_20"+m+j) = !tpsz;
			sheetObj.ColHidden("pref_40"+m+j) = !tpsz;
		}
        
        for(i=4; i<sheetObj.RowCount+4; i++){
        	if(sheetObj.CellValue(i, "lvl") == 2)
        		sheetObj.RowHidden(i) = true;
        }
	}
	
	function sheet7ColView(col, hiddenSts){
		var sheetObj = sheetObjects[6];
		var formObj = document.form;
		var sts = true;
		
		if(hiddenSts == undefined){
			hiddenSts = true;
		}
		
		for(i=4; i<sheetObj.RowCount+4; i++){
			if(col == "pod_cd"){
				sts = formObj.check_pod7.checked;
				
				if(sheetObj.CellValue(i, "pod_cd") == "+"
					   || sheetObj.CellValue(i, "pod_cd") == "-"){
					if(sts){			    			
						sheetObj.CellValue2(i, "pod_cd") = "-";
						sheetObj.RowExpanded(i) = true;
					}else{			    			
						sheetObj.CellValue2(i, "pod_cd") = "+";
						sheetObj.RowExpanded(i) = false;
					}
				}
			}
			
			if(col == "pol_cd"){
				sts = formObj.check_pol7.checked;
				if(sheetObj.CellValue(i, "pol_cd") == "+"
					   || sheetObj.CellValue(i, "pol_cd") == "-"){
					if(sts){			    			
						sheetObj.CellValue2(i, "pol_cd") = "-";
						sheetObj.RowExpanded(i) = true;
					}else{			    			
						sheetObj.CellValue2(i, "pol_cd") = "+";
						sheetObj.RowExpanded(i) = false;
					}
				}
			}
			
			if(col == "ctrt_cust_cd"){
				sts = formObj.check_acct7.checked;
				if(sheetObj.CellValue(i, "ctrt_cust_cd") == "+"
					|| sheetObj.CellValue(i, "ctrt_cust_cd") == "-"){
					if(sts){			    			
						sheetObj.CellValue2(i, "ctrt_cust_cd") = "-";
						sheetObj.RowExpanded(i) = true;
					}else{			    			
						sheetObj.CellValue2(i, "ctrt_cust_cd") = "+";
						sheetObj.RowExpanded(i) = false;
					}
				}
			}
		}

		if(hiddenSts){
			sheet7HiddenItems();
		}
	}
	
	 /*
     * 선택된 하나의 Radio Object Value를 반환
     * @param     oRadio : object Radio
     * @return    String
     */
    function getRadioValue(oRadio) {
        if (oRadio == null) return "";

        if (oRadio.length != null)
        {
            for(i=0; i<oRadio.length; i++)
            {
                if (oRadio[i].checked) return oRadio[i].value;
            } // end for
        } else  {
            if (oRadio.checked) return oRadio.value;
        } // end if
        return "";
    }
    
    function initData_acctList(codes, names) {
    	var sheetObj = document.getElementById("acct");
    	var cnt = 0;
    	
    	with (sheetObj) {
    		RemoveAll();
    		SetTitle("Code|Name");
    		SetColWidth("80|250");
    		SetColAlign("left|left");
    		ShowCol = 0;
    		MultiSelect = true;
    		//MaxSelect = 1;
    		DropHeight = 190;
    		
    		if (codes == undefined || codes == null) {
    			return;
    		}
    		
    		if (codes.length > 1) {
    			InsertItem(-1, "|ALL", "");
    		}
    		
    		var selectCode = "";
    		for ( var i = 0; i < codes.length - 1; i++) {
    			var txt = names[i].split("~");
    			if (txt[1] == "1") {
    				selectCode = codes[i];
    			}
    			InsertItem(-1, codes[i] + "|" + txt[0], codes[i]);
    		}
    		
    		if (selectCode != "") {
    			Code = selectCode;
    		} else {
    			//Index = 0;
    		}
    		Enable = (GetCount() > 0);
    	}
    }
    
    function initData_groupAcctList(codes, names) {
    	var sheetObj = document.getElementById("grp_acct");
    	var cnt = 0;
    	
    	with (sheetObj) {
    		RemoveAll();
    		SetTitle("Code|Name");
    		SetColWidth("80|250");
    		SetColAlign("left|left");
    		ShowCol = 0;
    		MultiSelect = true;
    		//MaxSelect = 1;
    		DropHeight = 190;
    		
    		if (codes == undefined || codes == null) {
    			return;
    		}
    		
    		if (codes.length > 1) {
    			InsertItem(-1, "|ALL", "");
    		}
    		
    		var selectCode = "";
    		for ( var i = 0; i < codes.length - 1; i++) {
    			var txt = names[i].split("~");
    			if (txt[1] == "1") {
    				selectCode = codes[i];
    			}
    			InsertItem(-1, codes[i] + "|" + txt[0], codes[i]);
    		}
    		
    		if (selectCode != "") {
    			Code = selectCode;
    		} else {
    			//Index = 0;
    		}
    		Enable = (GetCount() > 0);
    	}
    }
    
    /**
     * acct 콤보를 클릭할 때 전체체크
     * @param comboObj
     * @param index
     * @param code
     * @return
     */
    function acct_OnCheckClick(comboObj, index, code) {
    	if (code == "" || code == "All") {
    		var bChk = comboObj.CheckIndex(index);
    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			comboObj.CheckIndex(i) = bChk;
        	}
       }else{
    	   comboObj.CheckIndex(0) = false;
       }
    }
    
    /**
     * grp_acct 콤보를 클릭할 때 전체체크
     * @param comboObj
     * @param index
     * @param code
     * @return
     */
    function grp_acct_OnCheckClick(comboObj, index, code) {
    	if (code == "" || code == "All") {
    		var bChk = comboObj.CheckIndex(index);
    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			comboObj.CheckIndex(i) = bChk;
        	}
       }else{
    	   comboObj.CheckIndex(0) = false;
       }
    }
    
    /**
     * 마우스가 이동될 때 이벤트 처리 
     * 
     * @param sheetObj
     * @param Button
     * @param Shift
     * @param X
     * @param Y
     * @return
     */
    function sheet11_OnMouseMove(sheetObj, Button, Shift, X, Y){
    	var header = ComTrim(sheetObj.CellValue(sheetObj.MouseRow, sheetObj.MouseCol));

    	if(header == "AVG"){
    		sheetObj.MousePointer = "Hand";
    		sheetObj.MouseToolTipText = "AVG PFMC of past 8 weeks."; 
    		sheetObj.ToolTipOption="balloon:true;width:320";
    	} else {
    		sheetObj.MousePointer = "Default";
    		sheetObj.MouseToolTipText = "";
    	}
    }
    
    /**
     * Yield Group 팝업 호출(ESM_SPC_0094)
     */
    function yieldGrpPopup() {
    	var formObj = document.form;

    	if(formObj.year.value=="" || formObj.week1.value=="" || formObj.trade.Code==""){
    		return;
    	}
    	var param = "yrwk="   + formObj.year.value + formObj.week1.value;
    	param = param + "&trd_cd=" + formObj.trade.Code;
    	
    	ComOpenWindow("ESM_SPC_0094.do?" + param, "Yield Group", "height=300,width=450,status=0");
    }
    
    //--------------------------------------------------------------------------------------------------------//
    
  /*
   * IPI/Local Check시 GUIDE와 USA모드 활성화, Uncheck시 Account와 DEST 닫기
   * 펼칠때는 내뒤가 펼쳐지지 않은경우만 펼치기
   * 닫을때는 내뒤가 안펼쳐진 경우에만 닫기
   */
  function hiddenUsMod2(){	  
	  	var sheetObj = sheetObjects[0];
	  	var formObj = document.form;
		var uSts = formObj.check_usMod2.checked;
		var oSts = formObj.check_office.checked;
		var aSts = formObj.check_acct2.checked;
		var dSts = formObj.check_destLoc2.checked;
		
		if(oSts) {
			sheetObj.ColHidden("dest_loc_cd") = !dSts;	
			sheetObj.ColHidden("acct_cd") = !(aSts||dSts);
			sheetObj.ColHidden("usa_bkg_mod_cd") = !(uSts||aSts||dSts);
		} else {
			sheetObj.ColHidden("dest_loc_cd") = !dSts;	
			sheetObj.ColHidden("acct_cd") = !aSts;
			sheetObj.ColHidden("usa_bkg_mod_cd") = !uSts;
		}

		
		//office가 체크되어 있으면 office와 연동
		if(oSts) {
			if(uSts){
				if(!dSts&&!aSts){//트리펼치기	
					sheetObj.ShowTreeLevel(4, 1);
				} 			
			} else{					
				if(!(aSts||dSts)){//트리닫기
					sheetObj.ShowTreeLevel(2, 1);
				} 
//				else if(dSts){
//					sheetObj.ColHidden("usa_bkg_mod_cd") = false;
//					sheetObj.ColHidden("acct_cd") = false;
//				} else if(aSts){
//					sheetObj.ColHidden("acct_cd") = false;
//				}
			}
			
			//office가 선택되어져 있으면 AREA별 USMode는 무조건 HIDDEN
			var arrRow1 = sheetObj.FindCheckedRow("hc1").split("|");
			for (var idx=0; idx < arrRow1.length-1; idx++) {
				if(ComTrim(sheetObj.CellValue(arrRow1[idx], "area")) == ComTrim(sheetObj.CellValue(arrRow1[idx], "ofc_cd")) 
						&& ComTrim(sheetObj.CellValue(arrRow1[idx], "acct_lvl")) == '*') {
					sheetObj.RowHidden(arrRow1[idx]) = true;
				}
			}
			
			//office가 선택되어져 있으면 AREA별 Acct는 무조건 HIDDEN
			var arrRow2 = sheetObj.FindCheckedRow("hc2").split("|");
			for (var idx=0; idx < arrRow2.length-1; idx++) {
				if(ComTrim(sheetObj.CellValue(arrRow2[idx], "area")) == ComTrim(sheetObj.CellValue(arrRow2[idx], "ofc_cd")) 
						&& ComTrim(sheetObj.CellValue(arrRow2[idx], "acct_lvl")) == '*') {
					sheetObj.RowHidden(arrRow2[idx]) = true;
				}
			}	
			
			//office가 선택되어져 있으면 AREA별 Dest는 무조건 HIDDEN
			var arrRow3 = sheetObj.FindCheckedRow("hc3").split("|");
			for (var idx=0; idx < arrRow3.length-1; idx++) {
				if(ComTrim(sheetObj.CellValue(arrRow3[idx], "area")) == ComTrim(sheetObj.CellValue(arrRow3[idx], "ofc_cd")) 
						&& ComTrim(sheetObj.CellValue(arrRow3[idx], "acct_lvl")) == '*') {
					sheetObj.RowHidden(arrRow3[idx]) = true;
				}
			}	
		} else {

			var arrRow1 = sheetObj.FindCheckedRow("hc1").split("|");
			for (var idx=0; idx < arrRow1.length-1; idx++) {
				sheetObj.RowHidden(arrRow1[idx]) = !uSts;
			}
			
			var arrRow2 = sheetObj.FindCheckedRow("hc2").split("|");
			for (var idx=0; idx < arrRow2.length-1; idx++) {
				sheetObj.RowHidden(arrRow2[idx]) = !aSts;
			}
			
			var arrRow3 = sheetObj.FindCheckedRow("hc3").split("|");
			for (var idx=0; idx < arrRow3.length-1; idx++) {
				sheetObj.RowHidden(arrRow3[idx]) = !dSts;
			}	
		}
  }
  
  /*
   * Account Check시  GUIDE와 USA모드 Account 활성화 , Uncheck시 DEST 닫기
   */
  function hiddenAcct2(){
	  	var sheetObj = sheetObjects[0];
	  	var formObj = document.form;
		var uSts = formObj.check_usMod2.checked;
		var oSts = formObj.check_office.checked;
		var aSts = formObj.check_acct2.checked;
		var dSts = formObj.check_destLoc2.checked;
		
		if(oSts) {
			sheetObj.ColHidden("dest_loc_cd") = !dSts;	
			sheetObj.ColHidden("acct_cd") = !(aSts||dSts);
			sheetObj.ColHidden("usa_bkg_mod_cd") = !(uSts||aSts||dSts);
		} else {
			sheetObj.ColHidden("dest_loc_cd") = !dSts;	
			sheetObj.ColHidden("acct_cd") = !aSts;
			sheetObj.ColHidden("usa_bkg_mod_cd") = !uSts;
		}
		
		if(oSts) {
			if(aSts){							
				if(!dSts){//트리펼치기
					sheetObj.ShowTreeLevel(5, 1);	
//					sheetObj.ColHidden("usa_bkg_mod_cd") = false;
				} 
//				else {
//					sheetObj.ColHidden("dest_loc_cd") = false;	
//					sheetObj.ColHidden("acct_cd") = false;	
//					sheetObj.ColHidden("usa_bkg_mod_cd") = false;
//				}			
			} else{	
				if(!dSts){//dest가 선택되어져 있지 않으면
					if(uSts){	//usa가 선택되어 있으면 USA까지만 펼치기
						sheetObj.ShowTreeLevel(4, 1);
					} else {
						sheetObj.ShowTreeLevel(2, 1);
					}
				} 
//				else {
//					sheetObj.ColHidden("dest_loc_cd") = false;	
//					sheetObj.ColHidden("acct_cd") = false;	
//					sheetObj.ColHidden("usa_bkg_mod_cd") = false;
//				}
			}
			//office가 선택되어져 있으면 AREA별 USMode는 무조건 HIDDEN
			var arrRow1 = sheetObj.FindCheckedRow("hc1").split("|");
			for (var idx=0; idx < arrRow1.length-1; idx++) {
				if(ComTrim(sheetObj.CellValue(arrRow1[idx], "area")) == ComTrim(sheetObj.CellValue(arrRow1[idx], "ofc_cd")) 
						&& ComTrim(sheetObj.CellValue(arrRow1[idx], "acct_lvl")) == '*') {
					sheetObj.RowHidden(arrRow1[idx]) = true;
				}
			}
			
			//office가 선택되어져 있으면 AREA별 USMode는 무조건 HIDDEN
			var arrRow1 = sheetObj.FindCheckedRow("hc1").split("|");
			for (var idx=0; idx < arrRow1.length-1; idx++) {
				if(ComTrim(sheetObj.CellValue(arrRow1[idx], "area")) == ComTrim(sheetObj.CellValue(arrRow1[idx], "ofc_cd")) 
						&& ComTrim(sheetObj.CellValue(arrRow1[idx], "acct_lvl")) == '*') {
					sheetObj.RowHidden(arrRow1[idx]) = true;
				}
			}
			
			//office가 선택되어져 있으면 AREA별 Acct는 무조건 HIDDEN
			var arrRow2 = sheetObj.FindCheckedRow("hc2").split("|");
			for (var idx=0; idx < arrRow2.length-1; idx++) {
				if(ComTrim(sheetObj.CellValue(arrRow2[idx], "area")) == ComTrim(sheetObj.CellValue(arrRow2[idx], "ofc_cd")) 
						&& ComTrim(sheetObj.CellValue(arrRow2[idx], "acct_lvl")) == '*') {
					sheetObj.RowHidden(arrRow2[idx]) = true;
				}
			}	
			
			//office가 선택되어져 있으면 AREA별 Dest는 무조건 HIDDEN
			var arrRow3 = sheetObj.FindCheckedRow("hc3").split("|");
			for (var idx=0; idx < arrRow3.length-1; idx++) {
				if(ComTrim(sheetObj.CellValue(arrRow3[idx], "area")) == ComTrim(sheetObj.CellValue(arrRow3[idx], "ofc_cd")) 
						&& ComTrim(sheetObj.CellValue(arrRow3[idx], "acct_lvl")) == '*') {
					sheetObj.RowHidden(arrRow3[idx]) = true;
				}
			}				
			
		} else {

			var arrRow1 = sheetObj.FindCheckedRow("hc1").split("|");
			for (var idx=0; idx < arrRow1.length-1; idx++) {
				sheetObj.RowHidden(arrRow1[idx]) = !uSts;
			}
			
			var arrRow2 = sheetObj.FindCheckedRow("hc2").split("|");
			for (var idx=0; idx < arrRow2.length-1; idx++) {
				sheetObj.RowHidden(arrRow2[idx]) = !aSts;
			}
			
			var arrRow3 = sheetObj.FindCheckedRow("hc3").split("|");
			for (var idx=0; idx < arrRow3.length-1; idx++) {
				sheetObj.RowHidden(arrRow3[idx]) = !dSts;
			}	
		}
  }
  
  /*
   * Dest시  GUIDE와 USA모드, Account,Dest 활성화
   */
  function hiddenDestLoc2(){
	  	var sheetObj = sheetObjects[0];
	  	var formObj = document.form;
		var uSts = formObj.check_usMod2.checked;
		var oSts = formObj.check_office.checked;
		var aSts = formObj.check_acct2.checked;
		var dSts = formObj.check_destLoc2.checked;
		
//		sheetObj.ColHidden("dest_loc_cd") = !dSts;	
//		sheetObj.ColHidden("acct_cd") = !aSts;
//		sheetObj.ColHidden("usa_bkg_mod_cd") = !uSts;
		if(oSts) {
			sheetObj.ColHidden("dest_loc_cd") = !dSts;	
			sheetObj.ColHidden("acct_cd") = !(aSts||dSts);
			sheetObj.ColHidden("usa_bkg_mod_cd") = !(uSts||aSts||dSts);
		} else {
			sheetObj.ColHidden("dest_loc_cd") = !dSts;	
			sheetObj.ColHidden("acct_cd") = !aSts;
			sheetObj.ColHidden("usa_bkg_mod_cd") = !uSts;
		}	
		if(oSts) {
			if(dSts){							
				//트리펼치기
				sheetObj.ShowTreeLevel(6, 2);
//				sheetObj.ColHidden("acct_cd") = false;
//				sheetObj.ColHidden("usa_bkg_mod_cd") = false;
			} else{	
				if(aSts){//account가 선택되어 있으면
					sheetObj.ShowTreeLevel(5, 2);
//					sheetObj.ColHidden("usa_bkg_mod_cd") = false;
				} else if(uSts){//usa가 선택되어 있으면 USA까지만 펼치기		
					sheetObj.ShowTreeLevel(4, 1);
				} else {
					sheetObj.ShowTreeLevel(2, 1);
				}
			}
			
			//office가 선택되어져 있으면 AREA별 USMode는 무조건 HIDDEN
			var arrRow1 = sheetObj.FindCheckedRow("hc1").split("|");
			for (var idx=0; idx < arrRow1.length-1; idx++) {
				if(ComTrim(sheetObj.CellValue(arrRow1[idx], "area")) == ComTrim(sheetObj.CellValue(arrRow1[idx], "ofc_cd")) 
						&& ComTrim(sheetObj.CellValue(arrRow1[idx], "acct_lvl")) == '*') {
					sheetObj.RowHidden(arrRow1[idx]) = true;
				}
			}
			
			//office가 선택되어져 있으면 AREA별 Acct는 무조건 HIDDEN
			var arrRow2 = sheetObj.FindCheckedRow("hc2").split("|");
			for (var idx=0; idx < arrRow2.length-1; idx++) {
				if(ComTrim(sheetObj.CellValue(arrRow2[idx], "area")) == ComTrim(sheetObj.CellValue(arrRow2[idx], "ofc_cd")) 
						&& ComTrim(sheetObj.CellValue(arrRow2[idx], "acct_lvl")) == '*') {
					sheetObj.RowHidden(arrRow2[idx]) = true;
				}
			}	
			
			//office가 선택되어져 있으면 AREA별 Dest는 무조건 HIDDEN
			var arrRow3 = sheetObj.FindCheckedRow("hc3").split("|");
			for (var idx=0; idx < arrRow3.length-1; idx++) {
				if(ComTrim(sheetObj.CellValue(arrRow3[idx], "area")) == ComTrim(sheetObj.CellValue(arrRow3[idx], "ofc_cd")) 
						&& ComTrim(sheetObj.CellValue(arrRow3[idx], "acct_lvl")) == '*') {
					sheetObj.RowHidden(arrRow3[idx]) = true;
				}
			}	
		} 
		
		else {
		//area,ofc_cd,acct_lvl
			var arrRow1 = sheetObj.FindCheckedRow("hc1").split("|");
			for (var idx=0; idx < arrRow1.length-1; idx++) {
				sheetObj.RowHidden(arrRow1[idx]) = !uSts;
			}
			
			var arrRow2 = sheetObj.FindCheckedRow("hc2").split("|");
			for (var idx=0; idx < arrRow2.length-1; idx++) {
				sheetObj.RowHidden(arrRow2[idx]) = !aSts;
			}
			
			var arrRow3 = sheetObj.FindCheckedRow("hc3").split("|");
			for (var idx=0; idx < arrRow3.length-1; idx++) {
				sheetObj.RowHidden(arrRow3[idx]) = !dSts;
			}		
		}
		
  }
  
	/*
	 * Allocation RHQ화면의 CheckBox control
	 */ 
	function checkBoxControl5(obj){
		//obj.id
		var formObj = document.form;
		var sheetObj = sheetObjects[1];
		var guideSts = formObj.check_guide5.checked;
		var oSts = formObj.check_office5.checked;
		var soSts = formObj.check_suboffice5.checked;
		//USMode, Account, Dest추가 처리
		var uSts = formObj.check_usMod5.checked;
		var aSts = formObj.check_acct5.checked;
		var dSts = formObj.check_destLoc5.checked;
		var noneAcctLvl = "*";	
		
		sheetObj.Redraw = false;
		
		if(!document.form.check_guide5.disabled) {//IAS에 대한 처리
			// Dest 항목 숨김 여부
			var idSts = formObj.check_dest5.checked;
			for(var i=3; i < sheetObj.RowCount; i++){
				rlane = sheetObj.CellValue(i, "rlane_cd");
				
				if(sheetObj.CellValue(i, "dest") != " " && rlane.substr(rlane.length-3, 3) == "TTL"){
					sheetObj.RowHidden(i) = !idSts;
				}
			}
			sheetObj.ColHidden("acct_lvl") = false;
			
		} else {
			sheetObj.ColHidden("acct_lvl") = true;
			
		}
		
		//Office
		var arrRow0 = sheetObj.FindCheckedRow("ho").split("|");
		for (var idx=0; idx < arrRow0.length-1; idx++) {
			if(oSts && guideSts) {
				sheetObj.RowExpanded(arrRow0[idx]) = true;
				sheetObj.CellValue2(arrRow0[idx], "acct_lvl") = "-";
				sheetObj.RowHidden(arrRow0[idx]) = false;
			} else {
				sheetObj.RowExpanded(arrRow0[idx]) = false;
				sheetObj.CellValue2(arrRow0[idx], "acct_lvl") = "+";
				sheetObj.RowHidden(arrRow0[idx]) = !oSts;
			}
			
			sheetObj.CellAlign(arrRow0[idx],"rhq_cd") = daCenter;
			sheetObj.CellAlign(arrRow0[idx],"rlane_cd") = daCenter;
			sheetObj.CellAlign(arrRow0[idx],"area") = daCenter;
			sheetObj.CellAlign(arrRow0[idx],"ofc_cd") = daCenter;
			sheetObj.CellAlign(arrRow0[idx],"acct_lvl") = daCenter;
		}
	
		//Guide, Guide for none office
		var arrRow = sheetObj.FindCheckedRow("hg").split("|");
		for (var idx=0; idx < arrRow.length-1; idx++) {
			if(guideSts) {
				if(oSts || (!oSts && sheetObj.CellValue(arrRow[idx], "hg0") == '1'))
					sheetObj.RowHidden(arrRow[idx]) = false;
				else sheetObj.RowHidden(arrRow[idx]) = true;
			} else {
				sheetObj.RowHidden(arrRow[idx]) = true;
			}	
			sheetObj.CellAlign(arrRow[idx],"rhq_cd") = daCenter;
			sheetObj.CellAlign(arrRow[idx],"rlane_cd") = daCenter;
			sheetObj.CellAlign(arrRow[idx],"area") = daCenter;
			sheetObj.CellAlign(arrRow[idx],"ofc_cd") = daCenter;
			sheetObj.CellAlign(arrRow[idx],"acct_lvl") = daCenter;
		}
	
		if(oSts) {
			sheetObj.ColHidden("dest_loc_cd") = !dSts;	
			sheetObj.ColHidden("acct_cd") = !(aSts||dSts);
			sheetObj.ColHidden("usa_bkg_mod_cd") = !(uSts||aSts||dSts);
		} else {
			sheetObj.ColHidden("dest_loc_cd") = !dSts;	
			sheetObj.ColHidden("acct_cd") = !aSts;
			sheetObj.ColHidden("usa_bkg_mod_cd") = !uSts;
		}
		
	
		//Dest
		var arrRow3 = sheetObj.FindCheckedRow("hc3").split("|");
		for (var idx=0; idx < arrRow3.length-1; idx++) {
	
			if(ComTrim(sheetObj.CellValue(arrRow3[idx], "ofc_cd")) == 'TTL' && dSts) {//TTL항목은 무조건 보이게
				sheetObj.RowHidden(arrRow3[idx]) = false;
			} else if(oSts) {//Office가 선택되면
				//각 option sum은 Hidden
				if(ComTrim(sheetObj.CellValue(arrRow3[idx], "acct_lvl")) == noneAcctLvl) sheetObj.RowHidden(arrRow3[idx]) = true;
				else sheetObj.RowHidden(arrRow3[idx]) = !dSts;			
			} else {
				if(ComTrim(sheetObj.CellValue(arrRow3[idx], "acct_lvl")) == noneAcctLvl && (dSts)) sheetObj.RowHidden(arrRow3[idx]) = false;
				else if(ComTrim(sheetObj.CellValue(arrRow3[idx], "acct_lvl")) != noneAcctLvl) sheetObj.RowHidden(arrRow3[idx]) = true;
				sheetObj.RowHidden(arrRow3[idx]) = !dSts;
			}
			
		}
		
		//Account
		var arrRow2 = sheetObj.FindCheckedRow("hc2").split("|");
		for (var idx=0; idx < arrRow2.length-1; idx++) {
			//
			if(ComTrim(sheetObj.CellValue(arrRow2[idx], "ofc_cd")) == 'TTL' && aSts) {//TTL항목은 무조건 보이게
				sheetObj.RowHidden(arrRow2[idx]) = false;
			} else if(oSts) {//Office가 선택되면
				//각 option sum은 Hidden
				if(ComTrim(sheetObj.CellValue(arrRow2[idx], "acct_lvl")) == noneAcctLvl) sheetObj.RowHidden(arrRow2[idx]) = true;
				else {//Tree구조의 경우는 dest가 선택되었으면 보여주고
					if(dSts) sheetObj.RowHidden(arrRow2[idx]) = false;
					else sheetObj.RowHidden(arrRow2[idx]) = !aSts;
				}
			} else {
				if(ComTrim(sheetObj.CellValue(arrRow2[idx], "acct_lvl")) == noneAcctLvl && aSts) sheetObj.RowHidden(arrRow2[idx]) = false;
				else if(ComTrim(sheetObj.CellValue(arrRow2[idx], "acct_lvl")) != '*') sheetObj.RowHidden(arrRow2[idx]) = true;
				else sheetObj.RowHidden(arrRow2[idx]) = !aSts;
			}
	
		}
		//UsMode
		var arrRow1 = sheetObj.FindCheckedRow("hc1").split("|");
		for (var idx=0; idx < arrRow1.length-1; idx++) {
			
			if(ComTrim(sheetObj.CellValue(arrRow1[idx], "ofc_cd")) == 'TTL' && uSts) {//TTL항목은 무조건 보이게
				sheetObj.RowHidden(arrRow1[idx]) = false;
			} else if(oSts){ //Office가 선택되면
				//각 option sum은 Hidden
				if(ComTrim(sheetObj.CellValue(arrRow1[idx], "acct_lvl")) == noneAcctLvl) sheetObj.RowHidden(arrRow1[idx]) = true;
				else {//Tree구조의 경우는 account나dest가 선택되었으면 보여주고
					if(dSts||aSts) sheetObj.RowHidden(arrRow1[idx]) = false;
					else sheetObj.RowHidden(arrRow1[idx]) = !uSts;
				}
			} else {
				if(ComTrim(sheetObj.CellValue(arrRow1[idx], "acct_lvl")) == noneAcctLvl && uSts) sheetObj.RowHidden(arrRow1[idx]) = false;
				else if(ComTrim(sheetObj.CellValue(arrRow1[idx], "acct_lvl")) != noneAcctLvl) sheetObj.RowHidden(arrRow1[idx]) = true;
				else sheetObj.RowHidden(arrRow1[idx]) = !uSts;
			}
		}
		
		//
		if(oSts && guideSts && !uSts && !dSts && !aSts) {
			sheetObj.ShowTreeLevel(2, 1);
			//Guide, Guide for none office
			var arrRow = sheetObj.FindCheckedRow("hg").split("|");
			var usCd = ""; 
			for (var idx=0; idx < arrRow.length-1; idx++) {
				usCd = ComTrim(sheetObj.CellValue(arrRow[idx], "usa_bkg_mod_cd"));
				if(ComTrim(sheetObj.CellValue(arrRow[idx], "acct_lvl")) != noneAcctLvl
						&& (usCd == '+' || usCd == '-')) sheetObj.RowHidden(arrRow[idx]) = false;
				else sheetObj.RowHidden(arrRow[idx]) = true;
			}
		}
		
		sheetObj.Redraw = true;
		
		if(soSts){
			checkBoxControl5_subOfc(formObj.check_suboffice5);	
		}
		
	}
  
  
  
	/*
	 * Allocation RHQ화면의 sub office CheckBox control
	 */ 
	function checkBoxControl5_subOfc(obj){
		//obj.id
		var formObj = document.form;
		var sheetObj = sheetObjects[1];
		var guideSts = formObj.check_guide5.checked;
		var oSts = formObj.check_office5.checked;
		var soSts = formObj.check_suboffice5.checked;

		//USMode, Account, Dest추가 처리
		var uSts = formObj.check_usMod5.checked;
		var aSts = formObj.check_acct5.checked;
		var dSts = formObj.check_destLoc5.checked;
		var noneAcctLvl = "*";	
		
		sheetObj.Redraw = false;
		
		if(!document.form.check_guide5.disabled) {//IAS에 대한 처리
			// Dest 항목 숨김 여부
			var idSts = formObj.check_dest5.checked;
			for(var i=3; i < sheetObj.RowCount; i++){
				rlane = sheetObj.CellValue(i, "rlane_cd");
				
				if(sheetObj.CellValue(i, "dest") != " " && rlane.substr(rlane.length-3, 3) == "TTL"){
					sheetObj.RowHidden(i) = !idSts;
				}
			}
			sheetObj.ColHidden("acct_lvl") = false;
			
		} else {
			sheetObj.ColHidden("acct_lvl") = true;
			
		}
		//Office
		var arrRow0 = sheetObj.FindCheckedRow("ho").split("|");
		for (var idx=0; idx < arrRow0.length-1; idx++) {
			if(soSts && guideSts) {
				sheetObj.RowExpanded(arrRow0[idx]) = true;
				sheetObj.CellValue2(arrRow0[idx], "acct_lvl") = "-";
				sheetObj.RowHidden(arrRow0[idx]) = false;
			} else {
				sheetObj.RowExpanded(arrRow0[idx]) = false;
				sheetObj.CellValue2(arrRow0[idx], "acct_lvl") = "+";
				sheetObj.RowHidden(arrRow0[idx]) = !soSts;
			}
			sheetObj.CellAlign(arrRow0[idx],"rhq_cd") = daCenter;
			sheetObj.CellAlign(arrRow0[idx],"rlane_cd") = daCenter;
			sheetObj.CellAlign(arrRow0[idx],"area") = daCenter;
			sheetObj.CellAlign(arrRow0[idx],"ofc_cd") = daCenter;
			sheetObj.CellAlign(arrRow0[idx],"acct_lvl") = daCenter;
		}
		//Guide, Guide for none office
		var arrRow = sheetObj.FindCheckedRow("hg").split("|");
		for (var idx=0; idx < arrRow.length-1; idx++) {
			if(guideSts) {
				if(soSts || (!soSts && sheetObj.CellValue(arrRow[idx], "hg0") == '1'))
					sheetObj.RowHidden(arrRow[idx]) = false;
				else sheetObj.RowHidden(arrRow[idx]) = true;
			} else {
				sheetObj.RowHidden(arrRow[idx]) = true;
			}	
			sheetObj.CellAlign(arrRow[idx],"rhq_cd") = daCenter;
			sheetObj.CellAlign(arrRow[idx],"rlane_cd") = daCenter;
			sheetObj.CellAlign(arrRow[idx],"area") = daCenter;
			sheetObj.CellAlign(arrRow[idx],"ofc_cd") = daCenter;
			sheetObj.CellAlign(arrRow[idx],"acct_lvl") = daCenter;
		}
		if(soSts) {
			sheetObj.ColHidden("dest_loc_cd") = !dSts;	
			sheetObj.ColHidden("acct_cd") = !(aSts||dSts);
			sheetObj.ColHidden("usa_bkg_mod_cd") = !(uSts||aSts||dSts);
		} else {
			sheetObj.ColHidden("dest_loc_cd") = !dSts;	
			sheetObj.ColHidden("acct_cd") = !aSts;
			sheetObj.ColHidden("usa_bkg_mod_cd") = !uSts;
		}
		

		//Dest
		var arrRow3 = sheetObj.FindCheckedRow("hc3").split("|");
		for (var idx=0; idx < arrRow3.length-1; idx++) {
	
			if(ComTrim(sheetObj.CellValue(arrRow3[idx], "ofc_cd")) == 'TTL' && dSts) {//TTL항목은 무조건 보이게
				sheetObj.RowHidden(arrRow3[idx]) = false;
			} else if(soSts) {//Office가 선택되면
				//각 option sum은 Hidden
				if(ComTrim(sheetObj.CellValue(arrRow3[idx], "acct_lvl")) == noneAcctLvl) sheetObj.RowHidden(arrRow3[idx]) = true;
				else sheetObj.RowHidden(arrRow3[idx]) = !dSts;			
			} else {
				if(ComTrim(sheetObj.CellValue(arrRow3[idx], "acct_lvl")) == noneAcctLvl && (dSts)) sheetObj.RowHidden(arrRow3[idx]) = false;
				else if(ComTrim(sheetObj.CellValue(arrRow3[idx], "acct_lvl")) != noneAcctLvl) sheetObj.RowHidden(arrRow3[idx]) = true;
				sheetObj.RowHidden(arrRow3[idx]) = !dSts;
			}
			
		}

		//Account
		var arrRow2 = sheetObj.FindCheckedRow("hc2").split("|");
		for (var idx=0; idx < arrRow2.length-1; idx++) {
			//
			if(ComTrim(sheetObj.CellValue(arrRow2[idx], "ofc_cd")) == 'TTL' && aSts) {//TTL항목은 무조건 보이게
				sheetObj.RowHidden(arrRow2[idx]) = false;
			} else if(soSts) {//Office가 선택되면
				//각 option sum은 Hidden
				if(ComTrim(sheetObj.CellValue(arrRow2[idx], "acct_lvl")) == noneAcctLvl) sheetObj.RowHidden(arrRow2[idx]) = true;
				else {//Tree구조의 경우는 dest가 선택되었으면 보여주고
					if(dSts) sheetObj.RowHidden(arrRow2[idx]) = false;
					else sheetObj.RowHidden(arrRow2[idx]) = !aSts;
				}
			} else {
				if(ComTrim(sheetObj.CellValue(arrRow2[idx], "acct_lvl")) == noneAcctLvl && aSts) sheetObj.RowHidden(arrRow2[idx]) = false;
				else if(ComTrim(sheetObj.CellValue(arrRow2[idx], "acct_lvl")) != '*') sheetObj.RowHidden(arrRow2[idx]) = true;
				else sheetObj.RowHidden(arrRow2[idx]) = !aSts;
			}
	
		}

		//UsMode
		var arrRow1 = sheetObj.FindCheckedRow("hc1").split("|");
		for (var idx=0; idx < arrRow1.length-1; idx++) {
			
			if(ComTrim(sheetObj.CellValue(arrRow1[idx], "ofc_cd")) == 'TTL' && uSts) {//TTL항목은 무조건 보이게
				sheetObj.RowHidden(arrRow1[idx]) = false;
			} else if(soSts){ //Office가 선택되면
				//각 option sum은 Hidden
				if(ComTrim(sheetObj.CellValue(arrRow1[idx], "acct_lvl")) == noneAcctLvl) sheetObj.RowHidden(arrRow1[idx]) = true;
				else {//Tree구조의 경우는 account나dest가 선택되었으면 보여주고
					if(dSts||aSts) sheetObj.RowHidden(arrRow1[idx]) = false;
					else sheetObj.RowHidden(arrRow1[idx]) = !uSts;
				}
			} else {
				if(ComTrim(sheetObj.CellValue(arrRow1[idx], "acct_lvl")) == noneAcctLvl && uSts) sheetObj.RowHidden(arrRow1[idx]) = false;
				else if(ComTrim(sheetObj.CellValue(arrRow1[idx], "acct_lvl")) != noneAcctLvl) sheetObj.RowHidden(arrRow1[idx]) = true;
				else sheetObj.RowHidden(arrRow1[idx]) = !uSts;
			}
		}

		//
		if(soSts && guideSts && !uSts && !dSts && !aSts) {
			sheetObj.ShowTreeLevel(3, 1);
			//Guide, Guide for none office
			var arrRow = sheetObj.FindCheckedRow("hg").split("|");
			var usCd = ""; 
			for (var idx=0; idx < arrRow.length-1; idx++) {
				usCd = ComTrim(sheetObj.CellValue(arrRow[idx], "usa_bkg_mod_cd"));
				if(ComTrim(sheetObj.CellValue(arrRow[idx], "acct_lvl")) != noneAcctLvl
						&& (usCd == '+' || usCd == '-')) sheetObj.RowHidden(arrRow[idx]) = false;
				else sheetObj.RowHidden(arrRow[idx]) = true;
			}
		}
		
		if(soSts){
			for (var i=sheetObj.HeaderRows; i < sheetObj.HeaderRows+sheetObj.RowCount; i++) {
				if(ComTrim(sheetObj.CellValue(i, "sub_ofc_cd")) == '+') {
					sheetObj.CellValue2(i, "sub_ofc_cd") = "-";
				}
			}
		}else{
			for (var i=sheetObj.HeaderRows; i < sheetObj.HeaderRows+sheetObj.RowCount; i++) {
				if(ComTrim(sheetObj.CellValue(i, "sub_ofc_cd")) == '-') {
					sheetObj.CellValue2(i, "sub_ofc_cd") = "+";
				}
			}	
		}
		sheetObj.Redraw = true;
	}
	
	/**
	* keyEnter를 눌렀을때 쉬트 Retrieve
	*/
	function sheet6ReSearch(){
		if(event.keyCode == 13){
			var fObj = document.form;
			if(fObj.div_cd[3].checked && fObj.del_cd.value!="") {//
				doActionIBSheet(sheetObjects[4],fObj,IBSEARCH);
				tab_retrives[4] = true;	
			} else if (fObj.div_cd[0].checked && fObj.por_cd.value!="") {
				doActionIBSheet(sheetObjects[4],fObj,IBSEARCH);
				tab_retrives[4] = true;	
			}
		}
	}
	/**************** IE11지원을 위해 combobox 잔상 제거용 코드 추가 ****************/
	 /*
	  * 기존의 onChange를 onChange_t로 변경하고, onChange에서는 timeout을 두어 onChange_t를 호출하도록 변경함
	  */
	 function trade_OnFocus(combj, value, text){
        document.getElementById("year").focus();
        document.getElementById("trade").focus(); 
	 }

	 function subtrade1_OnFocus(combj, value, text){
        document.getElementById("year").focus();
        document.getElementById("subtrade1").focus(); 
	 }
	 
	 function rlane1_OnFocus(combj, value, text){
        document.getElementById("year").focus();
        document.getElementById("rlane1").focus(); 
	 }
	 
	 function trade_OnChange(combj, value, text){
		 var formObj = document.form;
		 setTimeout(function(){trade_OnChange_t()},10);
	 }

	 function subtrade1_OnChange(combj, value, text){
		 var formObj = document.form;
		 setTimeout(function(){subtrade1_OnChange_t()},10);
	 }
	 
	 function rhq_OnChange(combj, value, text){
		 var formObj = document.form;
		 var check_smp = getRadioValue(formObj.check_smp);
		 if(check_smp == "NSMP"){
			 setGrpAcctNAcct();
		 } 
	 }

	/** 개발자 작업  끝 */
