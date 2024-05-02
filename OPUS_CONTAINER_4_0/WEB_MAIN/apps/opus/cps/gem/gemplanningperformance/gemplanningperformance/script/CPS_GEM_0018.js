/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : cps_gem_0018.js
*@FileTitle : [CPS_GEM-0018] Summary_After Closing
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009.07.03 박창준
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
     * @author CLT
     */

    /**
     * @extends 
     * @class cps_gem_0018 : cps_gem_0018 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function cps_gem_0018() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.getBackEndJobStatus 	= getBackEndJobStatus;
    	
    	this.sheet1_OnClick = sheet1_OnClick;
    }
    
   	/* 개발자 작업	*/


 // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var frm = null;
    var sheet1 = null;
    var sheet2 = null;
    var sheet3 = null;
    var sheet4 = null;
    var sheet5 = null;
    var sheet6 = null;
    var sheet7 = null;
    
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
    					alert(srcName);
    					break;
    				case "btn1_New":
    					// 초기화하시겠습니까?
     					if(!ComCodeMsgByInitialize01()) return;
     					ComResetAll();
     					ComEnableObject(frm.ofc_lvl1, true);
    					ComEnableObject(frm.ofc_lvl2, true);
    					ComEnableObject(frm.ofc_lvl3, true);		
    					frm.sls_ofc_div_cd[0].disabled=false;
    					frm.sls_ofc_div_cd[1].disabled=false;
    					
    					frm.sel_target[0].disabled=false;
    	        		frm.sel_target[1].disabled=false;
    	        		frm.sel_target[2].disabled=false;
    	        		frm.sel_target[3].disabled=false;
    	        		
    	        		frm.ofc_cur[0].disabled = false;
    	        	    frm.ofc_cur[1].disabled = false;
    	        	    frm.ofc_cur[2].disabled = false;
    	        	    
    	        	    frm.expn_dep[0].disabled=false;
    	        		frm.expn_dep[1].disabled=false;
    	        		
    	        		frm.ofc_sal[0].disabled=false;
    	        		frm.ofc_sal[1].disabled=false;
    	        		frm.ofc_sal[2].disabled=false;
    	        		
    	        		frm.ofc_co[0].disabled=false;
    	        		frm.ofc_co[1].disabled=false;
    	        		frm.ofc_co[2].disabled=false;
    	        		
    	        		frm.target_rpt[0].disabled=false;
    	        		frm.target_rpt[1].disabled=false;
    	        		frm.target_rpt[2].disabled=false;
    	        		frm.target_rpt[3].disabled=false;
    	        		
    	        		frm.sub_office_view.disabled=false;
    	          	  	frm.monthly_view.disabled=false;
    	          	  	frm.comparing_last_year.disabled=false;
    	        		
     					loadPage();
     					
     					sheet1_OnLoadFinish();
     					
    					break;
    				case "btn1_Preview":
    					alert(srcName);
    					break;
    				case "btn1_DownExcel":
    					
    					if(frm.from_rslt_yrmon.value == "" || frm.to_rslt_yrmon.value == ""){
    						ComShowCodeMessage("GEM01068");
    		 				return false;
    		 			}

    					if(validateForm(SEARCHLIST)){
    					if(!frm.target_rpt[0].checked && !frm.target_rpt[1].checked && !frm.target_rpt[2].checked && !frm.target_rpt[3].checked){
    						//ComOpenWait(true);
    						//doActionIBSheet(SEARCHLIST);
    						//ComOpenWait(false);
    						frm.f_cmd.value = SEARCHLIST10;
    						frm.sch_expense_from.value = combo1.Code;
    		 				frm.sch_expense_to.value = combo2.Code;
    		 				frm.sch_expense_group.value = combo3.Code;
    		 				
    						var sXml = sheet1.GetSearchXml("CPS_GEM_0018GS.do", FormQueryString(frm));
    						var arrXml = sXml.split("|$$|");
    						
    						var backendJobKey = ComGetEtcData(arrXml[0], "BackEndJobKey")
    						if (backendJobKey.length > 0) {
    							frm.backendjob_key.value = backendJobKey;
    							sheet1.WaitImageVisible = false;
    							ComOpenWait(true);			
    							sheet1.RequestTimeOut = 10000;
    							timer=setInterval(getBackEndJobStatus, 3000); //3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
    						}
    					}
    					else if(frm.target_rpt[0].checked){
    						ComOpenWait(true);
    						doActionIBSheet(SEARCHLIST04);
    						ComOpenWait(false);
    					}
    					else if(frm.target_rpt[1].checked){
    						ComOpenWait(true);
    						doActionIBSheet(SEARCHLIST05);
    						ComOpenWait(false);
    					}
    					else if(frm.target_rpt[2].checked){
    						ComOpenWait(true);
    						doActionIBSheet(SEARCHLIST06);
    						ComOpenWait(false);
    					}
    					else if(frm.target_rpt[3].checked){
    						ComOpenWait(true);
    						doActionIBSheet(SEARCHLIST07);
    						
    						if (sheet5.RowCount > 0 ) {
    							doActionIBSheet(SEARCHLIST08);
	    						doActionIBSheet(SEARCHLIST09);
    						}
	    					
    						sheet5.Down2Excel(1,false,false,true,"","apps/opus/cps/gem/gemplanningperformance/gemplanningperformance/script/CPS_GEM_0018_05.xml",false,false,"Monthly Expense",false);
	    					
    						if (sheet5.RowCount > 0 ) {
    							sheet6.Down2Excel(1,true,false,true);
	    						sheet7.Down2Excel(1,true,false,true);
    						}
    						
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
    				case "btn2_ActualresultsbyExpense":
    					
    					setTargetCon('expense');
    					break;
    				case "btn2_ActualresultsbyOffice":
    					
    					setTargetCon('office');
    					break;
    				case "btn2_ActualresultsbySubsidiary":
    					
    					setTargetCon('subsidiary');
    					break;
    				case "btn2_MonthlyExpense":
    					
    					setTargetCon('monthly');
    					break;

    				case "btn2_RequestExpenseofInitial":
    					//alert(srcName);
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
       	 	sheet2 = sheetObjects[1];
       	 	sheet3 = sheetObjects[2];
       	 	sheet4 = sheetObjects[3];
       	 	sheet5 = sheetObjects[4];
       	 	sheet6 = sheetObjects[5];
       	    sheet7 = sheetObjects[6];
       	 	sheetCnt = sheetObjects.length ;
       	 	
       	 	// combo
    		combo1 = comboObjects[0];
    		combo2 = comboObjects[1];
    		combo3 = comboObjects[2];
    		comboCnt = comboObjects.length;
    		
    		frm.sel_target[0].disabled=true;
  		  	frm.sel_target[1].disabled=true;
  		  	frm.sel_target[2].disabled=true;
  		  	frm.sel_target[3].disabled=false;
  		  	
  		  	//사무국(PLP+Superuser) 접속 시에만 Target Report(for Committee) 활성화 됨
  		  	if ( frm.usr_auth_tp_cd.value == USR_AUTH_TP_CD || frm.usr_ofc_cd.value == "SELPLP") {
  		  		document.all.target_report.style.display="";
			}
        	
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
            if (comboObj.id == "combo3") {
            	comboObj.MultiSelect = true;
            } else {
            	comboObj.MultiSelect = false;
            }         	
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
                         style.height = 0;

                         //전체 너비 설정
                         SheetWidth = mainTable.clientWidth;

                         //Host정보 설정[필수][HostIp, Port, PagePath]
                         if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                         //전체Merge 종류 [선택, Default msNone]
                         MergeSheet = msHeaderOnly;

                        //전체Edit 허용 여부 [선택, Default false]
                         Editable = true;

                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                         InitRowInfo(4, 1, 15, 100);
                        
                        var HeadTitle1 = "|  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  ";
                        var HeadTitle2 = "| | | | | | | | | | | | | | | | | | | |2009|2009|2009|2009|2009|2009|2009|2009|2009|2009|2009|2009|2009|2008|2008|2008|2008|2008|2007|2007|2007|2007|2007|2006|2006|2006|2006|2006";
     					var HeadTitle3 = "|CC|CUR|UNIT|Year|FM\nMON|TO\nMON|OFC|SUB\nOFC|COM|BU|RHQ l BU|Region|Salary|Expense Code|Expense Code Name|TIC|1st Group|2nd Group|3rd Group|LCL|LCL|LCL|USD(Ex.Rate-Plan)|USD(Ex.Rate-Plan)|USD(Ex.Rate-Plan)|USD(Ex.Rate-Account)|USD(Ex.Rate-Account)|USD(Ex.Rate-Account)|Ratio %|Ratio %|Ex.Rate|Ex.Rate|Performance|Performance|Performance|Ratio %|Ratio %|Performance|Performance|Performance|Ratio %|Ratio %|Performance|Performance|Performance|Ratio %|Ratio %";
     					var HeadTitle4 = "|CC|CUR|UNIT|Year|FM\nMON|TO\nMON|OFC|SUB\nOFC|COM|BU|RHQ l BU|Region|Salary|Expense Code|Expense Code Name|TIC|1st Group|2nd Group|3rd Group|INI\nAssigned|Assigned\n(A)|Performance\n(B)|INI\nAssigned|Assigned\n(C)|Performance\n(D)|INI\nAssigned|Assigned\n(E)|Performance\n(F)|Ratio\n(B/A)|Ratio\n(F/C)|Plan|Account|LCL|USD\n(Ex.Rate-Plan)|USD\n(Ex.Rate-Account)|LCL|USD*|LCL|USD\n(Ex.Rate-Plan)|USD\n(Ex.Rate-Account)|LCL|USD*|LCL|USD\n(Ex.Rate-Plan)|USD\n(Ex.Rate-Account)|LCL|USD*";
                         
     					var headCount = ComCountHeadTitle(HeadTitle1);

                         //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                         InitColumnInfo(headCount, 0, 0, true);

                         // 해더에서 처리할 수 있는 각종 기능을 설정한다
                         InitHeadMode(true, true, false, true, false,false)

                         //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                         InitHeadRow(0, HeadTitle1, true);
     					 InitHeadRow(1, HeadTitle2, true);
     					 InitHeadRow(2, HeadTitle3, true);
     					 InitHeadRow(3, HeadTitle4, true);

                         //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT,		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
     					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
     					
     					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,       "office_expense",			false,		"",			dfNone,			0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"locl_curr_cd",				false,		"",			dfNone,			0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"rqst_ut_val",				false,		"",			dfNone,			0, false, false);					
     					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"rt_yr",					false,		"",			dfNone,			0, false, false);					
     					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,       "rt_fm_mon",				false,		"",			dfNone,			0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"rt_to_mon",				false,		"",			dfNone,			0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"ofc_cd",					false,		"",			dfNone,			0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"sub_ofc_cd",				false,		"",			dfNone,			0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"ofc_co_div_cd",			false,		"",			dfNone,			0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"level_2",					false,		"",			dfNone,			0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"level_3",					false,		"",			dfNone,			0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"rgn_ofc_flg",				false,		"",			dfNone,			0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"sls_ofc_flg",				false,		"",			dfNone,			0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,		"gen_expn_cd",				false,		"",			dfNone,			0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,		"abbr_nm",					false,		"",			dfNone,			0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"tic_cd",					false,		"",			dfNone,			0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		"abbr_nm01",				false,		"",			dfNone,			0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		"abbr_nm02",				false,		"",			dfNone,			0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		"abbr_nm03",				false,		"",			dfNone,			0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daRight,	true,		"gen_expn_init_amt",		false,		"",			dfNullInteger,	0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daRight,	true,		"lcl_assigned",				false,		"",			dfNullInteger,	0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daRight,	true,		"slp_perf_amt",				false,		"",			dfNullFloat,	3, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daRight,	true,		"usd_expn_init_amt",		false,		"",			dfNullInteger,	0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daRight,	true,		"usd_assigned",				false,		"",			dfNullInteger,	0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daRight,	true,		"usd_perf_amt",				false,		"",			dfNullFloat,	3, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daRight,	true,		"usd_acc_expn_init_amt",	false,		"",			dfNullInteger,	0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daRight,	true,		"usd_acc_assigned",			false,		"",			dfNullInteger,	0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daRight,	true,		"usd_acc_perf_amt",			false,		"",			dfNullFloat,	3, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		"ratio_ba",					false,		"",			dfNullFloat,	2, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		"ratio_fc",					false,		"",			dfNullFloat,	2, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		"usd_locl_xch_rt",			false,		"",			dfNullFloat,	1, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		"usd_acc_locl_xch_rt",		false,		"",			dfNullFloat,	1, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daRight,	true,		"slp_perf_amt01",			false,		"",			dfNullFloat,	3, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daRight,	true,		"usd_perf_amt01",			false,		"",			dfNullFloat,	3, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daRight,	true,		"usd_acc_perf_amt01",		false,		"",			dfNullFloat,	3, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		"lcl_ratio01",				false,		"",			dfNullFloat,	2, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		"usd_ratio01",				false,		"",			dfNullFloat,	2, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daRight,	true,		"slp_perf_amt02",			false,		"",			dfNullFloat,	3, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daRight,	true,		"usd_perf_amt02",			false,		"",			dfNullFloat,	3, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daRight,	true,		"usd_acc_perf_amt02",		false,		"",			dfNullFloat,	3, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		"lcl_ratio02",				false,		"",			dfNullFloat,	2, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		"usd_ratio02",				false,		"",			dfNullFloat,	2, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daRight,	true,		"slp_perf_amt03",			false,		"",			dfNullFloat,	3, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daRight,	true,		"usd_perf_amt03",			false,		"",			dfNullFloat,	3, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daRight,	true,		"usd_acc_perf_amt03",		false,		"",			dfNullFloat,	3, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		"lcl_ratio03",				false,		"",			dfNullFloat,	2, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		"usd_ratio03",				false,		"",			dfNullFloat,	2, false, false);
     				
//     					CountPosition = 0;
     				}
     				break;
     				
                 case "sheet2":
                     with (sheetObj) {
                         // 높이 설정
                         style.height = 0;

                         //전체 너비 설정
                         SheetWidth = mainTable.clientWidth;

                         //Host정보 설정[필수][HostIp, Port, PagePath]
                         if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                         //전체Merge 종류 [선택, Default msNone]
                         MergeSheet = msHeaderOnly;

                        //전체Edit 허용 여부 [선택, Default false]
                         Editable = true;

                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                         InitRowInfo(8, 1, 15, 100);
                        
                        var HeadTitle1 = "|  |  |  |  |  |  |  |  |  |  |  |  |  |  ";
                        var HeadTitle2 = "| | | | | | | | | | | | | | ";
                        var HeadTitle3 = "|BU|  |  |  |  |Expense|  |~|  |Expense Group|  |TIC|  |  ";
                        var HeadTitle4 = "| | | | | | | | | | | | | | ";
                        var HeadTitle5 = "|  |  |  |  |  |  |  |  |  |  |  |  |  |  ";
                        var HeadTitle6 = "|Group|Group|Expense Code|Expense Name|Jan ~ Mar|Jan ~ Mar|Jan ~ Mar|Jan ~ Mar|Jan ~ Mar|Year to date|Year to date|Year to date|Year to date|Year to date";
     					var HeadTitle7 = "|Group|Group|Expense Code|Expense Name|2008|2008|2008|2007|2007|2008|2008|2008|2007|2007";
     					var HeadTitle8 = "|Group|Group|Expense Code|Expense Name|Assigned|Performance|Ratio %|Performance|Growth\nYear-on-Year|Assigned|Performance|Ratio %|Performance|Growth\nYear-on-Year";
                         
     					var headCount = ComCountHeadTitle(HeadTitle1);

                         //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                         InitColumnInfo(headCount, 0, 0, true);

                         // 해더에서 처리할 수 있는 각종 기능을 설정한다
                         InitHeadMode(true, true, false, true, false,false)

                         //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                         InitHeadRow(0, HeadTitle1, true);
     					 InitHeadRow(1, HeadTitle2, true);
     					 InitHeadRow(2, HeadTitle3, true);
     					 InitHeadRow(3, HeadTitle4, true);
     					 InitHeadRow(4, HeadTitle5, true);
     					 InitHeadRow(5, HeadTitle6, true);
     					 InitHeadRow(6, HeadTitle7, true);
    					 InitHeadRow(7, HeadTitle8, true);

                         //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT,		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
     					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
     					
     					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,       "abbr_nm01",				false,		"",			dfNone,			0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		"abbr_nm02",				false,		"",			dfNone,			0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,		"gen_expn_cd",				false,		"",			dfNone,			0, false, false);					
     					InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,		"abbr_nm",					false,		"",			dfNone,			0, false, false);					
     					InitDataProperty(0, cnt++ , dtAutoSum,		150,	daRight,	true,       "usd_assigned",				false,		"",			dfNullInteger,	0, false, false);
     					InitDataProperty(0, cnt++ , dtAutoSum,		150,	daRight,	true,       "usd_acc_perf_amt",			false,		"",			dfNullFloat,	3, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		"ratio",					false,		"|usd_acc_perf_amt|/|usd_assigned|*100",			dfNullInteger,	0, false, false);
     					InitDataProperty(0, cnt++ , dtAutoSum,		150,	daRight,	true,		"usd_acc_perf_amt01",		false,		"",			dfNullFloat,	3, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		"growth",					false,		"(|usd_acc_perf_amt|-|usd_acc_perf_amt01|)/|usd_acc_perf_amt01|*100",			dfNullInteger,	0, false, false);
     					InitDataProperty(0, cnt++ , dtAutoSum,		150,	daRight,	true,		"usd_assigned02",			false,		"",			dfNullInteger,	0, false, false);
     					InitDataProperty(0, cnt++ , dtAutoSum,		150,	daRight,	true,		"usd_acc_perf_amt02",		false,		"",			dfNullFloat,	3, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		"ratio01",					false,		"|usd_acc_perf_amt02|/|usd_assigned02|*100",		dfNullInteger,	0, false, false);
     					InitDataProperty(0, cnt++ , dtAutoSum,		150,	daRight,	true,		"usd_acc_perf_amt03",		false,		"",			dfNullFloat,	3, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		"growth01",					false,		"(|usd_acc_perf_amt02|-|usd_acc_perf_amt03|)/|usd_acc_perf_amt03|*100",			dfNullInteger,	0, false, false);
     					
//     					CountPosition = 0;
     				}
     				break;
     				
                 case "sheet3":
                     with (sheetObj) {
                         // 높이 설정
                         style.height = 0;

                         //전체 너비 설정
                         SheetWidth = mainTable.clientWidth;

                         //Host정보 설정[필수][HostIp, Port, PagePath]
                         if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                         //전체Merge 종류 [선택, Default msNone]
                         MergeSheet = msHeaderOnly;

                        //전체Edit 허용 여부 [선택, Default false]
                         Editable = true;

                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                         InitRowInfo(7, 1, 15, 100);
                         
                        var HeadTitle1 = "|  |  |  |  |  |  |  |  |  |  |  |  ";
                        var HeadTitle2 = "| | | | | | | | | | | | ";
                        var HeadTitle3 = "|BU|  |  |  |  |Expense|  |Expense Group|  |TIC|  |  ";
                        var HeadTitle4 = "| | | | | | | | | | | | ";
                        var HeadTitle5 = "|RHQ|Office|Jan ~ Mar|Jan ~ Mar|Jan ~ Mar|Jan ~ Mar|Jan ~ Mar|Year to date|Year to date|Year to date|Year to date|Year to date";
     					var HeadTitle6 = "|RHQ|Office|2008|2008|2008|2007|2007|2008|2008|2008|2007|2007";
     					var HeadTitle7 = "|RHQ|Office|Assigned|Performance|Ratio %|Performance|Growth\nYear-on-Year|Assigned|Performance|Ratio %|Performance|Growth\nYear-on-Year";
                         
     					var headCount = ComCountHeadTitle(HeadTitle1);

                         //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                         InitColumnInfo(headCount, 0, 0, true);

                         // 해더에서 처리할 수 있는 각종 기능을 설정한다
                         InitHeadMode(true, true, false, true, false,false)

                         //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                         InitHeadRow(0, HeadTitle1, true);
     					 InitHeadRow(1, HeadTitle2, true);
     					 InitHeadRow(2, HeadTitle3, true);
     					 InitHeadRow(3, HeadTitle4, true);
     					 InitHeadRow(4, HeadTitle5, true);
    					 InitHeadRow(5, HeadTitle6, true);
    					 InitHeadRow(6, HeadTitle7, true);

                         //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT,		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
     					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
     					
     					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,       "level_3",				false,		"",			dfNone,				0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		"ofc_cd",				false,		"",			dfNone,				0, false, false);
     					InitDataProperty(0, cnt++ , dtAutoSum,		150,	daRight,	true,       "usd_assigned",			false,		"",			dfNullInteger,		0, false, false);
     					InitDataProperty(0, cnt++ , dtAutoSum,		150,	daRight,	true,       "usd_acc_perf_amt",		false,		"",			dfNullFloat,		3, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		"ratio",				false,		"|usd_acc_perf_amt|/|usd_assigned|*100",			dfNullInteger,		0, false, false);
     					InitDataProperty(0, cnt++ , dtAutoSum,		150,	daRight,	true,		"usd_acc_perf_amt01",	false,		"",			dfNullFloat,		3, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"growth",				false,		"(|usd_acc_perf_amt|-|usd_acc_perf_amt01|)/|usd_acc_perf_amt01|*100",			dfNullInteger,		0, false, false);
     					InitDataProperty(0, cnt++ , dtAutoSum,		150,	daRight,	true,		"usd_assigned02",		false,		"",			dfNullInteger,		0, false, false);
     					InitDataProperty(0, cnt++ , dtAutoSum,		150,	daRight,	true,		"usd_acc_perf_amt02",	false,		"",			dfNullFloat,		3, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		"ratio01",				false,		"|usd_acc_perf_amt02|/|usd_assigned02|*100",		dfNullInteger,		0, false, false);
     					InitDataProperty(0, cnt++ , dtAutoSum,		150,	daRight,	true,		"usd_acc_perf_amt03",	false,		"",			dfNullFloat,		3, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"growth01",				false,		"(|usd_acc_perf_amt02|-|usd_acc_perf_amt03|)/|usd_acc_perf_amt03|*100",			dfNullInteger,		0, false, false);
     					
//     					CountPosition = 0;
     				}
     				break;
     				
                 case "sheet4":
                     with (sheetObj) {
                         // 높이 설정
                         style.height = 0;

                         //전체 너비 설정
                         SheetWidth = mainTable.clientWidth;

                         //Host정보 설정[필수][HostIp, Port, PagePath]
                         if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                         //전체Merge 종류 [선택, Default msNone]
                         MergeSheet = msHeaderOnly;

                        //전체Edit 허용 여부 [선택, Default false]
                         Editable = true;

                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                         InitRowInfo(7, 1, 15, 100);
                        
                        var HeadTitle1 = "|  |  |  |  |  |  |  |  |  |  |  |  |  ";
                        var HeadTitle2 = "| | | | | | | | | | | | | ";
                        var HeadTitle3 = "|BU|  |  |  |  |Expense|  |Expense Group|  |TIC|  |  |  ";
                        var HeadTitle4 = "| | | | | | | | | | | | | ";
                        var HeadTitle5 = "|BU|RHQ|Office|Jan ~ Mar|Jan ~ Mar|Jan ~ Mar|Jan ~ Mar|Jan ~ Mar|Year to date|Year to date|Year to date|Year to date|Year to date";
     					var HeadTitle6 = "|BU|RHQ|Office|2008|2008|2008|2007|2007|2008|2008|2008|2007|2007";
     					var HeadTitle7 = "|BU|RHQ|Office|Assigned|Performance|Ratio %|Performance|Growth\nYear-on-Year|Assigned|Performance|Ratio %|Performance|Growth\nYear-on-Year";
                         
     					var headCount = ComCountHeadTitle(HeadTitle1);

                         //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                         InitColumnInfo(headCount, 0, 0, true);

                         // 해더에서 처리할 수 있는 각종 기능을 설정한다
                         InitHeadMode(true, true, false, true, false,false)

                         //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                         InitHeadRow(0, HeadTitle1, true);
     					 InitHeadRow(1, HeadTitle2, true);
     					 InitHeadRow(2, HeadTitle3, true);
     					 InitHeadRow(3, HeadTitle4, true);
     					 InitHeadRow(4, HeadTitle5, true);
    					 InitHeadRow(5, HeadTitle6, true);
    					 InitHeadRow(6, HeadTitle7, true);

                         //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT,		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
     					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
     					
     					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		"level_2",				false,		"",			dfNone,					0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,       "level_3",				false,		"",			dfNone,					0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		"ofc_cd",				false,		"",			dfNone,					0, false, false);
     					InitDataProperty(0, cnt++ , dtAutoSum,		150,	daRight,	true,       "usd_assigned",			false,		"",			dfNullInteger,			0, false, false);
     					InitDataProperty(0, cnt++ , dtAutoSum,		150,	daRight,	true,       "usd_acc_perf_amt",		false,		"",			dfNullFloat,			3, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		"ratio",				false,		"|usd_acc_perf_amt|/|usd_assigned|*100",			dfNullInteger,			0, false, false);
     					InitDataProperty(0, cnt++ , dtAutoSum,		150,	daRight,	true,		"usd_acc_perf_amt01",	false,		"",			dfNullFloat,			3, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		"growth",				false,		"(|usd_acc_perf_amt|-|usd_acc_perf_amt01|)/|usd_acc_perf_amt01|*100",			dfNullInteger,			0, false, false);
     					InitDataProperty(0, cnt++ , dtAutoSum,		150,	daRight,	true,		"usd_assigned02",		false,		"",			dfNullInteger,			0, false, false);
     					InitDataProperty(0, cnt++ , dtAutoSum,		150,	daRight,	true,		"usd_acc_perf_amt02",	false,		"",			dfNullFloat,			3, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		"ratio01",				false,		"|usd_acc_perf_amt02|/|usd_assigned02|*100",		dfNullInteger,			0, false, false);
     					InitDataProperty(0, cnt++ , dtAutoSum,		150,	daRight,	true,		"usd_acc_perf_amt03",	false,		"",			dfNullFloat,			3, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		"growth01",				false,		"(|usd_acc_perf_amt02|-|usd_acc_perf_amt03|)/|usd_acc_perf_amt03|*100",			dfNullInteger,			0, false, false);
     					
//     					CountPosition = 0;
     				}
     				break;
     				
                 case "sheet5":
                     with (sheetObj) {
                         // 높이 설정
                         style.height = 0;

                         //전체 너비 설정
                         SheetWidth = mainTable.clientWidth;

                         //Host정보 설정[필수][HostIp, Port, PagePath]
                         if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                         //전체Merge 종류 [선택, Default msNone]
                         MergeSheet = msHeaderOnly;

                        //전체Edit 허용 여부 [선택, Default false]
                         Editable = true;

                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                         InitRowInfo(5, 1, 15, 100);
                        
                        var HeadTitle1 = "|  |  |  |  |  |  |  |  |  |  |  ";
                        var HeadTitle2 = "| | | | | | | | | | | ";
                        var HeadTitle3 = "|BU|  |  |  |  |Expense|  |Expense Group|  |TIC|  ";
                        var HeadTitle4 = "| | | | | | | | | | | ";
                        var HeadTitle5 = "|MONTH|BRANCH|BRANCH|화폐단위|화폐단위|급여성(LCL)|비급여성(LCL)|계|급여성(USD)|비급여성(USD)|계(USD)";
     					var headCount = ComCountHeadTitle(HeadTitle1);

                         //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                         InitColumnInfo(headCount, 0, 0, true);

                         // 해더에서 처리할 수 있는 각종 기능을 설정한다
                         InitHeadMode(true, true, false, true, false,false)

                         //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                         InitHeadRow(0, HeadTitle1, true);
                         InitHeadRow(1, HeadTitle2, true);
                         InitHeadRow(2, HeadTitle3, true);
     					 InitHeadRow(3, HeadTitle4, true);
     					 InitHeadRow(4, HeadTitle5, true);

                         //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT,		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
     					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
     					
     					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"rslt_yrmon01",			false,		"",			dfNone,					0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,       "l_3",					false,		"",			dfNone,					0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"ofc_cd",				false,		"",			dfNone,					0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,       "locl_curr_cd",			false,		"",			dfNone,					0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,		"usd_locl_xch_rt",		false,		"",			dfNullFloat,			2, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daRight,	true,       "lcl_sal",				false,		"",			dfNullInteger,			0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daRight,	true,       "lcl_non_sal",			false,		"",			dfNullInteger,			0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		"lcl_sum",				false,		"|lcl_sal|+|lcl_non_sal|",			dfNullInteger,			0, false, false);
     					InitDataProperty(0, cnt++ , dtAutoSum,		150,	daRight,	true,		"usd_sal",				false,		"",			dfNullInteger,			0, false, false);
     					InitDataProperty(0, cnt++ , dtAutoSum,		150,	daRight,	true,		"usd_non_sal",			false,		"",			dfNullInteger,			0, false, false);
     					InitDataProperty(0, cnt++ , dtAutoSum,		150,	daRight,	true,		"usd_sum",				false,		"|usd_sal|+|usd_non_sal|",			dfNullInteger,			0, false, false);
     					
//     					CountPosition = 0;
     				}
     				break;
     				
                 case "sheet6":
                     with (sheetObj) {
                         // 높이 설정
                         style.height = 0;

                         //전체 너비 설정
                         SheetWidth = mainTable.clientWidth;

                         //Host정보 설정[필수][HostIp, Port, PagePath]
                         if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                         //전체Merge 종류 [선택, Default msNone]
                         MergeSheet = msHeaderOnly;

                        //전체Edit 허용 여부 [선택, Default false]
                         Editable = true;

                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                         InitRowInfo(1, 1, 15, 100);

                        var HeadTitle1 = "|Month|Expense\nCode|Expense Name|OFC|RHQ|CUR|Unit|Salary|Total";
     					var headCount = ComCountHeadTitle(HeadTitle1);

                         //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                         InitColumnInfo(headCount, 3, 0, true);

                         // 해더에서 처리할 수 있는 각종 기능을 설정한다
                         InitHeadMode(true, true, false, true, false,false)

                         //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                         InitHeadRow(0, HeadTitle1, true);

                         //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT,		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
     					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
     					
     					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"rslt_yrmon01",				false,		"",			dfNone,					0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			100,	daRight,		true,       "gen_expn_cd",				false,		"",			dfNone,					0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,			true,		"abbr_nm",					false,		"",			dfNone,					0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,       "ofc_cd",					false,		"",			dfNone,					0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"l_3",						false,		"",			dfNone,					0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daCenter,		true,       "locl_curr_cd",				false,		"",			dfNone,					0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daCenter,		true,       "rqst_ut_val",				false,		"",			dfNone,					0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		"sal_type",					false,		"",			dfNone,					0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daRight,		true,		"lcl_sal",					false,		"",			dfNullInteger,			0, false, false);
     					
//     					CountPosition = 0;
     				}
     				break;
     				
                 case "sheet7":
                     with (sheetObj) {
                         // 높이 설정
                         style.height = 0;

                         //전체 너비 설정
                         SheetWidth = mainTable.clientWidth;

                         //Host정보 설정[필수][HostIp, Port, PagePath]
                         if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                         //전체Merge 종류 [선택, Default msNone]
                         MergeSheet = msAll;

                        //전체Edit 허용 여부 [선택, Default false]
                         Editable = true;

                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                         InitRowInfo(1, 1, 15, 100);
                        
                        var HeadTitle1 = "| | | | | | | | | ";
                        var headCount = ComCountHeadTitle(HeadTitle1);

                         //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                         InitColumnInfo(headCount, 0, 0, true);

                         // 해더에서 처리할 수 있는 각종 기능을 설정한다
                         InitHeadMode(true, true, false, true, false,false)

                         //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                         InitHeadRow(0, HeadTitle1, true, true);
                         
                         sheet7.HeadBackColor = RgbColor(255,255,255);
                         
                         //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT,		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
     					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
     					
     					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		"rslt_yrmon01",			false,		"",			dfNone,					0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,       "l_3",					false,		"",			dfNone,					0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		"ofc_cd",				false,		"",			dfNone,					0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,       "locl_curr_cd",			false,		"",			dfNone,					0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		"usd_locl_xch_rt",		false,		"",			dfNone,					0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,       "lcl_sal",				false,		"",			dfNone,					0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,       "lcl_non_sal",			false,		"",			dfNone,					0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		true,		"usd_sal",				false,		"",			dfNone,					0, false, false);
     					InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,		"usd_non_sal",			false,		"",			dfNone,					0, false, false);
     					
//     					CountPosition = 0;
     					DataRowMerge(0) = true;
     				}
     				break;
             }
         }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sAction) {
            
            switch(sAction) {
    			case IBSEARCH:      //조회
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
     	  			
     	  			combo3.InsertItem(0,"Select All","");
     	  			
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
    				
    			case SEARCHLIST02:      //Open
     				
     				frm.f_cmd.value = SEARCH;
     				var sXml = sheet1.GetSearchXml("CPS_GEM_0018GS.do", FormQueryString(frm));
     				
     				var arrXml = sXml.split("|$$|");
     				var authFlg  = "";
     				
     				// 로그인 오피스 정보 
     				if (arrXml.length > 0) {		
     					// =========================================================
    					// 2009.10.26일 권한 변경 추가
    					// =========================================================
    					//사용자 오피스 설정
    					frm.usr_ofc_cd.value = ComGetEtcData(arrXml[0], "usr_ofc_cd");
    					
    					var list = ComXml2ListMap(arrXml[0]);
    					var officeLevelVo  = list[0];			
    					authFlg  = officeLevelVo["auth_flg"];
    					
    					// 사무국
    					if ( authFlg == "YNYN" || authFlg == "YNYY") {				
    						//사무국인경우 수퍼유저가 아니경우 비용팀으로 권한 설정
    						if (authFlg == "YNYY") {
    							if ( frm.usr_auth_tp_cd.value != USR_AUTH_TP_CD ) {
    								authFlg = "YNYN";
    							} else {
    								var sp_commit = document.getElementById("sp_commit");
    								sp_commit.style.display = "inline";
    							}
    						}
    					}				
    					
    					//권한 설정
    					frm.auth_flg.value = authFlg;    					

    					//=========================================================    					
    					
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
    	 					
     					}
     					
     				}	

     				break;
    			
    			case SEARCHLIST: // Down Excel
    				
	 				frm.f_cmd.value = SEARCHLIST;
	 				frm.sch_expense_from.value = combo1.Code;
	 				frm.sch_expense_to.value = combo2.Code;
	 				frm.sch_expense_group.value = combo3.Code;
     				
     				var sXml = sheet1.GetSearchXml("CPS_GEM_0018GS.do", FormQueryString(frm));
	      			
	      			var arrXml = sXml.split("|$$|");
		  			if (arrXml.length > 0) {
		  				sheet1.LoadSearchXml(arrXml[0]);
		  				
		  				sheet1.CellValue(1, 20) = frm.from_rslt_yrmon.value.substring(0,4);
		  				sheet1.CellValue(1, 21) = frm.from_rslt_yrmon.value.substring(0,4);
		  				sheet1.CellValue(1, 22) = frm.from_rslt_yrmon.value.substring(0,4);
		  				sheet1.CellValue(1, 23) = frm.from_rslt_yrmon.value.substring(0,4);
		  				sheet1.CellValue(1, 24) = frm.from_rslt_yrmon.value.substring(0,4);
		  				sheet1.CellValue(1, 25) = frm.from_rslt_yrmon.value.substring(0,4);
		  				sheet1.CellValue(1, 26) = frm.from_rslt_yrmon.value.substring(0,4);
		  				sheet1.CellValue(1, 27) = frm.from_rslt_yrmon.value.substring(0,4);
		  				sheet1.CellValue(1, 28) = frm.from_rslt_yrmon.value.substring(0,4);
		  				sheet1.CellValue(1, 29) = frm.from_rslt_yrmon.value.substring(0,4);
		  				sheet1.CellValue(1, 30) = frm.from_rslt_yrmon.value.substring(0,4);
		  				sheet1.CellValue(1, 31) = frm.from_rslt_yrmon.value.substring(0,4);
		  				sheet1.CellValue(1, 32) = frm.from_rslt_yrmon.value.substring(0,4);
		  				
		  				sheet1.CellValue(1, 33) = frm.from_rslt_yrmon.value.substring(0,4)-1;
		  				sheet1.CellValue(1, 34) = frm.from_rslt_yrmon.value.substring(0,4)-1;
		  				sheet1.CellValue(1, 35) = frm.from_rslt_yrmon.value.substring(0,4)-1;
		  				sheet1.CellValue(1, 36) = frm.from_rslt_yrmon.value.substring(0,4)-1;
		  				sheet1.CellValue(1, 37) = frm.from_rslt_yrmon.value.substring(0,4)-1;
		  				
		  				sheet1.CellValue(1, 38) = frm.from_rslt_yrmon.value.substring(0,4)-2;
		  				sheet1.CellValue(1, 39) = frm.from_rslt_yrmon.value.substring(0,4)-2;
		  				sheet1.CellValue(1, 40) = frm.from_rslt_yrmon.value.substring(0,4)-2;
		  				sheet1.CellValue(1, 41) = frm.from_rslt_yrmon.value.substring(0,4)-2;
		  				sheet1.CellValue(1, 42) = frm.from_rslt_yrmon.value.substring(0,4)-2;
		  				
		  				sheet1.CellValue(1, 43) = frm.from_rslt_yrmon.value.substring(0,4)-3;
		  				sheet1.CellValue(1, 44) = frm.from_rslt_yrmon.value.substring(0,4)-3;
		  				sheet1.CellValue(1, 45) = frm.from_rslt_yrmon.value.substring(0,4)-3;
		  				sheet1.CellValue(1, 46) = frm.from_rslt_yrmon.value.substring(0,4)-3;
		  				sheet1.CellValue(1, 47) = frm.from_rslt_yrmon.value.substring(0,4)-3;
		  				
		  				if(frm.monthly_view.checked){
		  					sheet1.CellValue(2, 5) = "MON";
		  					sheet1.CellValue(3, 5) = "MON";
		  				}
		  				else{
		  					sheet1.CellValue(2, 5) = "FM\nMON";
		  					sheet1.CellValue(3, 5) = "FM\nMON";
		  				}
		  				
		  				if(frm.ofc_cur[2].checked){
		  					sheet1.CellValue(2, 23) = "KRW(Ex.Rate-Plan)";
		  					sheet1.CellValue(2, 24) = "KRW(Ex.Rate-Plan)";
		  					sheet1.CellValue(2, 25) = "KRW(Ex.Rate-Plan)";
		  					
		  					sheet1.CellValue(2, 26) = "KRW(Ex.Rate-Account)";
		  					sheet1.CellValue(2, 27) = "KRW(Ex.Rate-Account)";
		  					sheet1.CellValue(2, 28) = "KRW(Ex.Rate-Account)";
		  					
		  					sheet1.CellValue(3, 34) = "KRW\n(Ex.Rate-Plan)";
		  					sheet1.CellValue(3, 35) = "KRW\n(Ex.Rate-Account)";		  					
		  					sheet1.CellValue(3, 37) = "KRW*";
		  					
		  					sheet1.CellValue(3, 39) = "KRW\n(Ex.Rate-Plan)";
		  					sheet1.CellValue(3, 40) = "KRW\n(Ex.Rate-Account)";		  					
		  					sheet1.CellValue(3, 42) = "KRW*";
		  					
		  					sheet1.CellValue(3, 44) = "KRW\n(Ex.Rate-Plan)";
		  					sheet1.CellValue(3, 45) = "KRW\n(Ex.Rate-Account)";		  					
		  					sheet1.CellValue(3, 47) = "KRW*";
		  					
		  				}
		  				else{
		  					sheet1.CellValue(2, 23) = "USD(Ex.Rate-Plan)";
		  					sheet1.CellValue(2, 24) = "USD(Ex.Rate-Plan)";
		  					sheet1.CellValue(2, 25) = "USD(Ex.Rate-Plan)";
		  					
		  					sheet1.CellValue(2, 26) = "USD(Ex.Rate-Account)";
		  					sheet1.CellValue(2, 27) = "USD(Ex.Rate-Account)";
		  					sheet1.CellValue(2, 28) = "USD(Ex.Rate-Account)";
		  					
		  					sheet1.CellValue(3, 34) = "USD\n(Ex.Rate-Plan)";
		  					sheet1.CellValue(3, 35) = "USD\n(Ex.Rate-Account)";		  					
		  					sheet1.CellValue(3, 37) = "USD*";
		  					
		  					sheet1.CellValue(3, 39) = "USD\n(Ex.Rate-Plan)";
		  					sheet1.CellValue(3, 40) = "USD\n(Ex.Rate-Account)";		  					
		  					sheet1.CellValue(3, 42) = "USD*";
		  					
		  					sheet1.CellValue(3, 44) = "USD\n(Ex.Rate-Plan)";
		  					sheet1.CellValue(3, 45) = "USD\n(Ex.Rate-Account)";		  					
		  					sheet1.CellValue(3, 47) = "USD*";
		  				}
		  				
		  				var maskfield = "";
		  				
		  				if(frm.monthly_view.checked){
		  					maskfield = "rt_to_mon";
		  				}
		  				if(frm.sub_office_view.checked){
		  					maskfield = maskfield + "|gen_expn_init_amt|lcl_assigned|usd_expn_init_amt|usd_assigned|usd_acc_expn_init_amt|usd_acc_assigned";
		  				}
		  				if(!frm.comparing_last_year.checked){
		  					maskfield = maskfield + "|slp_perf_amt01|usd_perf_amt01|usd_acc_perf_amt01|lcl_ratio01|usd_ratio01|slp_perf_amt02|usd_perf_amt02|usd_acc_perf_amt02|lcl_ratio02|usd_ratio02|slp_perf_amt03|usd_perf_amt03|usd_acc_perf_amt03|lcl_ratio03|usd_ratio03";
		  				}
		  				
		  				//sheet1.Down2Excel(1,false,false,true,"","apps/opus/cps/gem/gemplanningperformance/gemplanningperformance/script/CPS_GEM_0018_01.xml",false,false,"Summary_After Closing",false,maskfield);
		  				sheet1.SpeedDown2Excel(1,false,false,"","apps/opus/cps/gem/gemplanningperformance/gemplanningperformance/script/CPS_GEM_0018_01.xml",false,false,"Summary_After Closing",false,maskfield);
		  				
		  			}
    				
     				break;
     				
    			case SEARCHLIST04: // Actual results by Expense
     				
    				frm.f_cmd.value = SEARCHLIST04;
     				frm.sch_expense_from.value = combo1.Code;
     				frm.sch_expense_to.value = combo2.Code;
     				frm.sch_expense_group.value = combo3.Code;
     				
     				var sXml = sheet2.GetSearchXml("CPS_GEM_0018GS.do", FormQueryString(frm));
	      			
	      			var arrXml = sXml.split("|$$|");
		  			if (arrXml.length > 0) {
		  				sheet2.LoadSearchXml(arrXml[0]);
		  				
		  				var fmmon = "";
		  				var tomon = "";
		  				
		  				if(frm.from_rslt_yrmon.value.substring(5,7) == "01"){
		  					fmmon = "Jan";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "02"){
		  					fmmon = "Feb";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "03"){
		  					fmmon = "Mar";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "04"){
		  					fmmon = "Apr";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "05"){
		  					fmmon = "May";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "06"){
		  					fmmon = "Jun";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "07"){
		  					fmmon = "Jul";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "08"){
		  					fmmon = "Aug";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "09"){
		  					fmmon = "Sep";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "10"){
		  					fmmon = "Oct";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "11"){
		  					fmmon = "Nov";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "12"){
		  					fmmon = "Dec";
		  				}
		  				
		  				if(frm.to_rslt_yrmon.value.substring(5,7) == "01"){
		  					tomon = "Jan";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "02"){
		  					tomon = "Feb";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "03"){
		  					tomon = "Mar";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "04"){
		  					tomon = "Apr";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "05"){
		  					tomon = "May";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "06"){
		  					tomon = "Jun";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "07"){
		  					tomon = "Jul";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "08"){
		  					tomon = "Aug";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "09"){
		  					tomon = "Sep";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "10"){
		  					tomon = "Oct";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "11"){
		  					tomon = "Nov";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "12"){
		  					tomon = "Dec";
		  				}
		  				
		  				var current = "";
		  				
		  				if(frm.ofc_cur[1].checked){
		  					current = " (USD)";
		  				}else if(frm.ofc_cur[2].checked){
		  					current = " (KRW)";
		  				}
		  				
		  				sheet2.CellValue(5, 5) = fmmon + " ~ " + tomon + current;
		  				sheet2.CellValue(5, 6) = fmmon + " ~ " + tomon + current;
		  				sheet2.CellValue(5, 7) = fmmon + " ~ " + tomon + current;
		  				sheet2.CellValue(5, 8) = fmmon + " ~ " + tomon + current;
		  				sheet2.CellValue(5, 9) = fmmon + " ~ " + tomon + current;
		  				
		  				sheet2.CellValue(5, 10) = "Year to date" + current;
		  				sheet2.CellValue(5, 11) = "Year to date" + current;
		  				sheet2.CellValue(5, 12) = "Year to date" + current;
		  				sheet2.CellValue(5, 13) = "Year to date" + current;
		  				sheet2.CellValue(5, 14) = "Year to date" + current;
		  				
		  				sheet2.CellValue(6, 5) = frm.from_rslt_yrmon.value.substring(0,4);
		  				sheet2.CellValue(6, 6) = frm.from_rslt_yrmon.value.substring(0,4);
		  				sheet2.CellValue(6, 7) = frm.from_rslt_yrmon.value.substring(0,4);
		  				
		  				sheet2.CellValue(6, 8) = frm.from_rslt_yrmon.value.substring(0,4)-1;
		  				sheet2.CellValue(6, 9) = frm.from_rslt_yrmon.value.substring(0,4)-1;
		  				
		  				sheet2.CellValue(6, 10) = frm.from_rslt_yrmon.value.substring(0,4);
		  				sheet2.CellValue(6, 11) = frm.from_rslt_yrmon.value.substring(0,4);
		  				sheet2.CellValue(6, 12) = frm.from_rslt_yrmon.value.substring(0,4);
		  				
		  				sheet2.CellValue(6, 13) = frm.from_rslt_yrmon.value.substring(0,4)-1;
		  				sheet2.CellValue(6, 14) = frm.from_rslt_yrmon.value.substring(0,4)-1;
		  				
		  				if(frm.sls_ofc_div_cd[0].checked){
		  					sheet2.CellValue(2, 2) = "HO";
		  				}else if(frm.sls_ofc_div_cd[1].checked){
		  					sheet2.CellValue(2, 2) = "HQ";
		  				}else{
		  					sheet2.CellValue(2, 2) = "";
		  				}
		  				
		  				sheet2.CellValue(2, 3) = frm.ofc_lvl1.value;
		  				sheet2.CellValue(2, 4) = frm.ofc_lvl2.value;
		  				sheet2.CellValue(2, 5) = frm.ofc_lvl3.value;
		  				
		  				if(frm.ofc_lvl3.value == ''){
		  					sheet2.CellValue(2, 5) = frm.ofc_expn_cd.value;			  				
		  				}		 
		  				
		  				sheet2.CellValue(2, 7) = frm.sch_expense_from.value;
		  				sheet2.CellValue(2, 9) = frm.sch_expense_to.value;
		  				
		  				sheet2.CellValue(2, 11) = frm.sch_expense_group.value;
		  				
		  				sheet2.CellValue(2, 13) = frm.sch_tic_cd.value;
		  				
		  				with(sheet2){
		  					
		  					ShowSubSum("abbr_nm01", "5|6|8|10|11|13", -1, false, false, 0,"abbr_nm02=Total;ratio=|usd_acc_perf_amt|/|usd_assigned|*100;growth=(|usd_acc_perf_amt|-|usd_acc_perf_amt01|)/|usd_acc_perf_amt01|*100;ratio01=|usd_acc_perf_amt02|/|usd_assigned02|*100;growth01=(|usd_acc_perf_amt02|-|usd_acc_perf_amt03|)/|usd_acc_perf_amt03|*100");
		  					ShowSubSum("abbr_nm02", "5|6|8|10|11|13", -1, false, false, 0,"gen_expn_cd=Sub Total;ratio=|usd_acc_perf_amt|/|usd_assigned|*100;growth=(|usd_acc_perf_amt|-|usd_acc_perf_amt01|)/|usd_acc_perf_amt01|*100;ratio01=|usd_acc_perf_amt02|/|usd_assigned02|*100;growth01=(|usd_acc_perf_amt02|-|usd_acc_perf_amt03|)/|usd_acc_perf_amt03|*100");
		  					
		  					SumText(0,"abbr_nm01")="";
		  					SumText(0,"abbr_nm01")="Grand Total";
		  					SumValue(0,"ratio") = SumValue(0,"usd_acc_perf_amt")/SumValue(0,"usd_assigned")*100;
		  					SumValue(0,"growth") = (SumValue(0,"usd_acc_perf_amt")-SumValue(0,"usd_acc_perf_amt01"))/SumValue(0,"usd_acc_perf_amt01")*100;
		  					SumValue(0,"ratio01") = SumValue(0,"usd_acc_perf_amt02")/SumValue(0,"usd_assigned02")*100;
		  					SumValue(0,"growth01") = (SumValue(0,"usd_acc_perf_amt02")-SumValue(0,"usd_acc_perf_amt03"))/SumValue(0,"usd_acc_perf_amt03")*100;
		  				}
		  				
		  				var maskfield = "";
		  				
		  				sheet2.Down2Excel(1,false,false,true,"","apps/opus/cps/gem/gemplanningperformance/gemplanningperformance/script/CPS_GEM_0018_02.xml",false,false,"Actual results by Expense",false,maskfield);
		  				
		  			}
    				
     				break;
     				
    			case SEARCHLIST05: // Actual results by Office
    				
     				frm.f_cmd.value = SEARCHLIST05;
     				frm.sch_expense_from.value = combo1.Code;
     				frm.sch_expense_to.value = combo2.Code;
     				frm.sch_expense_group.value = combo3.Code;
     				
     				var sXml = sheet3.GetSearchXml("CPS_GEM_0018GS.do", FormQueryString(frm));
	      			
	      			var arrXml = sXml.split("|$$|");
		  			if (arrXml.length > 0) {
		  				sheet3.LoadSearchXml(arrXml[0]);
		  				
		  				var fmmon = "";
		  				var tomon = "";
		  				
		  				if(frm.from_rslt_yrmon.value.substring(5,7) == "01"){
		  					fmmon = "Jan";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "02"){
		  					fmmon = "Feb";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "03"){
		  					fmmon = "Mar";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "04"){
		  					fmmon = "Apr";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "05"){
		  					fmmon = "May";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "06"){
		  					fmmon = "Jun";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "07"){
		  					fmmon = "Jul";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "08"){
		  					fmmon = "Aug";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "09"){
		  					fmmon = "Sep";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "10"){
		  					fmmon = "Oct";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "11"){
		  					fmmon = "Nov";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "12"){
		  					fmmon = "Dec";
		  				}
		  				
		  				if(frm.to_rslt_yrmon.value.substring(5,7) == "01"){
		  					tomon = "Jan";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "02"){
		  					tomon = "Feb";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "03"){
		  					tomon = "Mar";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "04"){
		  					tomon = "Apr";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "05"){
		  					tomon = "May";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "06"){
		  					tomon = "Jun";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "07"){
		  					tomon = "Jul";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "08"){
		  					tomon = "Aug";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "09"){
		  					tomon = "Sep";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "10"){
		  					tomon = "Oct";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "11"){
		  					tomon = "Nov";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "12"){
		  					tomon = "Dec";
		  				}
		  				
		  				var current = "";
		  				
		  				if(frm.ofc_cur[1].checked){
		  					current = " (USD)";
		  				}else if(frm.ofc_cur[2].checked){
		  					current = " (KRW)";
		  				}
		  				
		  				sheet3.CellValue(4, 3) = fmmon + " ~ " + tomon + current;
		  				sheet3.CellValue(4, 4) = fmmon + " ~ " + tomon + current;
		  				sheet3.CellValue(4, 5) = fmmon + " ~ " + tomon + current;
		  				sheet3.CellValue(4, 6) = fmmon + " ~ " + tomon + current;
		  				sheet3.CellValue(4, 7) = fmmon + " ~ " + tomon + current;
		  				
		  				sheet3.CellValue(4, 8) = "Year to date" + current;
		  				sheet3.CellValue(4, 9) = "Year to date" + current;
		  				sheet3.CellValue(4, 10) = "Year to date" + current;
		  				sheet3.CellValue(4, 11) = "Year to date" + current;
		  				sheet3.CellValue(4, 12) = "Year to date" + current;
		  				
		  				sheet3.CellValue(5, 3) = frm.from_rslt_yrmon.value.substring(0,4);
		  				sheet3.CellValue(5, 4) = frm.from_rslt_yrmon.value.substring(0,4);
		  				sheet3.CellValue(5, 5) = frm.from_rslt_yrmon.value.substring(0,4);
		  				
		  				sheet3.CellValue(5, 6) = frm.from_rslt_yrmon.value.substring(0,4)-1;
		  				sheet3.CellValue(5, 7) = frm.from_rslt_yrmon.value.substring(0,4)-1;
		  				
		  				sheet3.CellValue(5, 8) = frm.from_rslt_yrmon.value.substring(0,4);
		  				sheet3.CellValue(5, 9) = frm.from_rslt_yrmon.value.substring(0,4);
		  				sheet3.CellValue(5, 10) = frm.from_rslt_yrmon.value.substring(0,4);
		  				
		  				sheet3.CellValue(5, 11) = frm.from_rslt_yrmon.value.substring(0,4)-1;
		  				sheet3.CellValue(5, 12) = frm.from_rslt_yrmon.value.substring(0,4)-1;
		  				
		  				if(frm.sls_ofc_div_cd[0].checked){
		  					sheet3.CellValue(2, 2) = "HO";
		  				}else if(frm.sls_ofc_div_cd[1].checked){
		  					sheet3.CellValue(2, 2) = "HQ";
		  				}else{
		  					sheet3.CellValue(2, 2) = "";
		  				}
		  				
		  				sheet3.CellValue(2, 3) = frm.ofc_lvl1.value;
		  				sheet3.CellValue(2, 4) = frm.ofc_lvl2.value;
		  				sheet3.CellValue(2, 5) = frm.ofc_lvl3.value;
		  				
		  				if(frm.ofc_lvl3.value == ''){
		  					sheet3.CellValue(2, 5) = frm.ofc_expn_cd.value;			  				
		  				}			  				
		  				
		  				sheet3.CellValue(2, 7) = frm.sch_expense_from.value + " ~ " + frm.sch_expense_to.value;
		  				
		  				sheet3.CellValue(2, 9) = frm.sch_expense_group.value;
		  				
		  				sheet3.CellValue(2, 11) = frm.sch_tic_cd.value;
		  				
		  				with(sheet3){
		  					
		  					ShowSubSum("level_3", "3|4|6|8|9|11", -1, false, false, 0,"ofc_cd=Sub Total;ratio=|usd_acc_perf_amt|/|usd_assigned|*100;growth=(|usd_acc_perf_amt|-|usd_acc_perf_amt01|)/|usd_acc_perf_amt01|*100;ratio01=|usd_acc_perf_amt02|/|usd_assigned02|*100;growth01=(|usd_acc_perf_amt02|-|usd_acc_perf_amt03|)/|usd_acc_perf_amt03|*100");
		  					
		  					SumText(0,"level_3")="";
		  					SumText(0,"level_3")="Grand Total";
		  					SumValue(0,"ratio") = SumValue(0,"usd_acc_perf_amt")/SumValue(0,"usd_assigned")*100;
		  					SumValue(0,"growth") = (SumValue(0,"usd_acc_perf_amt")-SumValue(0,"usd_acc_perf_amt01"))/SumValue(0,"usd_acc_perf_amt01")*100;
		  					SumValue(0,"ratio01") = SumValue(0,"usd_acc_perf_amt02")/SumValue(0,"usd_assigned02")*100;
		  					SumValue(0,"growth01") = (SumValue(0,"usd_acc_perf_amt02")-SumValue(0,"usd_acc_perf_amt03"))/SumValue(0,"usd_acc_perf_amt03")*100;
		  				}
		  				var maskfield = "";
		  				
		  				sheet3.Down2Excel(1,false,false,true,"","apps/opus/cps/gem/gemplanningperformance/gemplanningperformance/script/CPS_GEM_0018_03.xml",false,false,"Actual results by Office",false,maskfield);
		  				
		  			}
    				
     				break;
     				
    			case SEARCHLIST06: // Actual results by Subsidiaries
    				
     				frm.f_cmd.value = SEARCHLIST06;
     				frm.sch_expense_from.value = combo1.Code;
     				frm.sch_expense_to.value = combo2.Code;
     				frm.sch_expense_group.value = combo3.Code;
     				
     				var sXml = sheet4.GetSearchXml("CPS_GEM_0018GS.do", FormQueryString(frm));
	      			
	      			var arrXml = sXml.split("|$$|");
		  			if (arrXml.length > 0) {
		  				sheet4.LoadSearchXml(arrXml[0]);
		  				
		  				var fmmon = "";
		  				var tomon = "";
		  				
		  				if(frm.from_rslt_yrmon.value.substring(5,7) == "01"){
		  					fmmon = "Jan";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "02"){
		  					fmmon = "Feb";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "03"){
		  					fmmon = "Mar";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "04"){
		  					fmmon = "Apr";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "05"){
		  					fmmon = "May";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "06"){
		  					fmmon = "Jun";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "07"){
		  					fmmon = "Jul";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "08"){
		  					fmmon = "Aug";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "09"){
		  					fmmon = "Sep";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "10"){
		  					fmmon = "Oct";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "11"){
		  					fmmon = "Nov";
		  				}else if(frm.from_rslt_yrmon.value.substring(5,7) == "12"){
		  					fmmon = "Dec";
		  				}
		  				
		  				if(frm.to_rslt_yrmon.value.substring(5,7) == "01"){
		  					tomon = "Jan";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "02"){
		  					tomon = "Feb";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "03"){
		  					tomon = "Mar";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "04"){
		  					tomon = "Apr";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "05"){
		  					tomon = "May";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "06"){
		  					tomon = "Jun";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "07"){
		  					tomon = "Jul";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "08"){
		  					tomon = "Aug";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "09"){
		  					tomon = "Sep";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "10"){
		  					tomon = "Oct";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "11"){
		  					tomon = "Nov";
		  				}else if(frm.to_rslt_yrmon.value.substring(5,7) == "12"){
		  					tomon = "Dec";
		  				}
		  				
		  				var current = "";
		  				
		  				if(frm.ofc_cur[1].checked){
		  					current = " (USD)";
		  				}else if(frm.ofc_cur[2].checked){
		  					current = " (KRW)";
		  				}
		  				
		  				sheet4.CellValue(4, 4) = fmmon + " ~ " + tomon + current;
		  				sheet4.CellValue(4, 5) = fmmon + " ~ " + tomon + current;
		  				sheet4.CellValue(4, 6) = fmmon + " ~ " + tomon + current;
		  				sheet4.CellValue(4, 7) = fmmon + " ~ " + tomon + current;
		  				sheet4.CellValue(4, 8) = fmmon + " ~ " + tomon + current;
		  				
		  				sheet4.CellValue(4, 9) = "Year to date" + current;
		  				sheet4.CellValue(4, 10) = "Year to date" + current;
		  				sheet4.CellValue(4, 11) = "Year to date" + current;
		  				sheet4.CellValue(4, 12) = "Year to date" + current;
		  				sheet4.CellValue(4, 13) = "Year to date" + current;
		  				
		  				sheet4.CellValue(5, 4) = frm.from_rslt_yrmon.value.substring(0,4);
		  				sheet4.CellValue(5, 5) = frm.from_rslt_yrmon.value.substring(0,4);
		  				sheet4.CellValue(5, 6) = frm.from_rslt_yrmon.value.substring(0,4);
		  				
		  				sheet4.CellValue(5, 7) = frm.from_rslt_yrmon.value.substring(0,4)-1;
		  				sheet4.CellValue(5, 8) = frm.from_rslt_yrmon.value.substring(0,4)-1;
		  				
		  				sheet4.CellValue(5, 9) = frm.from_rslt_yrmon.value.substring(0,4);
		  				sheet4.CellValue(5, 10) = frm.from_rslt_yrmon.value.substring(0,4);
		  				sheet4.CellValue(5, 11) = frm.from_rslt_yrmon.value.substring(0,4);
		  				
		  				sheet4.CellValue(5, 12) = frm.from_rslt_yrmon.value.substring(0,4)-1;
		  				sheet4.CellValue(5, 13) = frm.from_rslt_yrmon.value.substring(0,4)-1;
		  				
		  				if(frm.sls_ofc_div_cd[0].checked){
		  					sheet4.CellValue(2, 2) = "HO";
		  				}else if(frm.sls_ofc_div_cd[1].checked){
		  					sheet4.CellValue(2, 2) = "HQ";
		  				}else{
		  					sheet4.CellValue(2, 2) = "";
		  				}
		  				
		  				sheet4.CellValue(2, 3) = frm.ofc_lvl1.value;
		  				sheet4.CellValue(2, 4) = frm.ofc_lvl2.value;
		  				sheet4.CellValue(2, 5) = frm.ofc_lvl3.value;

		  				if(frm.ofc_lvl3.value == ''){
		  					sheet4.CellValue(2, 5) = frm.ofc_expn_cd.value;			  				
		  				}
		  				
		  				sheet4.CellValue(2, 7) = frm.sch_expense_from.value + " ~ " + frm.sch_expense_to.value;
		  				
		  				sheet4.CellValue(2, 9) = frm.sch_expense_group.value;
		  				
		  				sheet4.CellValue(2, 11) = frm.sch_tic_cd.value;
		  				
		  				with(sheet4){
		  					
		  					ShowSubSum("level_2", "4|5|7|9|10|12", -1, false, false, 0,"level_3=Total;ratio=|usd_acc_perf_amt|/|usd_assigned|*100;growth=(|usd_acc_perf_amt|-|usd_acc_perf_amt01|)/|usd_acc_perf_amt01|*100;ratio01=|usd_acc_perf_amt02|/|usd_assigned02|*100;growth01=(|usd_acc_perf_amt02|-|usd_acc_perf_amt03|)/|usd_acc_perf_amt03|*100");
		  					ShowSubSum("level_3", "4|5|7|9|10|12", -1, false, false, 0,"ofc_cd=Sub Total;ratio=|usd_acc_perf_amt|/|usd_assigned|*100;growth=(|usd_acc_perf_amt|-|usd_acc_perf_amt01|)/|usd_acc_perf_amt01|*100;ratio01=|usd_acc_perf_amt02|/|usd_assigned02|*100;growth01=(|usd_acc_perf_amt02|-|usd_acc_perf_amt03|)/|usd_acc_perf_amt03|*100");
		  					
		  					SumText(0,"level_2")="";
		  					SumText(0,"level_2")="Grand Total";
		  					SumValue(0,"ratio") = SumValue(0,"usd_acc_perf_amt")/SumValue(0,"usd_assigned")*100;
		  					SumValue(0,"growth") = (SumValue(0,"usd_acc_perf_amt")-SumValue(0,"usd_acc_perf_amt01"))/SumValue(0,"usd_acc_perf_amt01")*100;
		  					SumValue(0,"ratio01") = SumValue(0,"usd_acc_perf_amt02")/SumValue(0,"usd_assigned02")*100;
		  					SumValue(0,"growth01") = (SumValue(0,"usd_acc_perf_amt02")-SumValue(0,"usd_acc_perf_amt03"))/SumValue(0,"usd_acc_perf_amt03")*100;
		  				}
		  				var maskfield = "";
		  				
		  				sheet4.Down2Excel(1,false,false,true,"","apps/opus/cps/gem/gemplanningperformance/gemplanningperformance/script/CPS_GEM_0018_04.xml",false,false,"Actual results by Subsidiaries",false,maskfield);
		  				
		  			}
    				
     				break;
     				
    			case SEARCHLIST07: // Monthly Expense
    				
     				frm.f_cmd.value = SEARCHLIST07;
     				frm.sch_expense_from.value = combo1.Code;
     				frm.sch_expense_to.value = combo2.Code;
     				frm.sch_expense_group.value = combo3.Code;
     				
     				var sXml = sheet5.GetSearchXml("CPS_GEM_0018GS.do", FormQueryString(frm));
	      			
     				if(frm.sls_ofc_div_cd[0].checked){
	  					sheet5.CellValue(2, 2) = "HO";
	  				}else if(frm.sls_ofc_div_cd[1].checked){
	  					sheet5.CellValue(2, 2) = "HQ";
	  				}else{
	  					sheet5.CellValue(2, 2) = "";
	  				}
	  				
	  				sheet5.CellValue(2, 3) = frm.ofc_lvl1.value;
	  				sheet5.CellValue(2, 4) = frm.ofc_lvl2.value;
	  				sheet5.CellValue(2, 5) = frm.ofc_lvl3.value;

	  				if(frm.ofc_lvl3.value == ''){
	  					sheet5.CellValue(2, 5) = frm.ofc_expn_cd.value;			  				
	  				}
	  				
	  				sheet5.CellValue(2, 7) = frm.sch_expense_from.value + " ~ " + frm.sch_expense_to.value;
	  				
	  				sheet5.CellValue(2, 9) = frm.sch_expense_group.value;
	  				
	  				sheet5.CellValue(2, 11) = frm.sch_tic_cd.value;
     				
	      			var arrXml = sXml.split("|$$|");
		  			if (arrXml.length > 0) {
		  				sheet5.LoadSearchXml(arrXml[0]);
		  				
		  				with(sheet5){
		  					
		  					ShowSubSum("l_3", "9|10|11", -1, false, false, 0,"usd_locl_xch_rt=Sub Total;");
		  					
		  					SumText(0,"rslt_yrmon01")="";
		  					SumText(0,"lcl_sum")="TOTAL USD : ";
		  				}
		  						  				
		  			}
    				
     				break;
     				
    			case SEARCHLIST08: // Monthly Expense
    				
     				frm.f_cmd.value = SEARCHLIST08;
     				frm.sch_expense_from.value = combo1.Code;
     				frm.sch_expense_to.value = combo2.Code;
     				frm.sch_expense_group.value = combo3.Code;
     				
     				var sXml = sheet6.GetSearchXml("CPS_GEM_0018GS.do", FormQueryString(frm));
	      			
	      			var arrXml = sXml.split("|$$|");
		  			if (arrXml.length > 0) {
		  				sheet6.LoadSearchXml(arrXml[0]);	  				
		  			}
     	  			
     				break;
     				
    			case SEARCHLIST09: // Monthly Expense
    				
     				frm.f_cmd.value = SEARCHLIST09;
     				frm.sch_expense_from.value = combo1.Code;
     				frm.sch_expense_to.value = combo2.Code;
     				frm.sch_expense_group.value = combo3.Code;
     				
     				var sXml = sheet7.GetSearchXml("CPS_GEM_0018GS.do", FormQueryString(frm));
	      			
	      			var arrXml = sXml.split("|$$|");
		  			if (arrXml.length > 0) {
		  				sheet7.LoadSearchXml(arrXml[0]);
		  				
		  				//sheet7.RowBackColor(1) = sheet7.RgbColor(255,255,255);
		  						  				
		  			}
     	  			
     				break;
    				
    			case SEARCHLIST01: // Expense 조회
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
     				
     			case SEARCHLIST03: // Group Expense 조회
     				frm.f_cmd.value = SEARCHLIST03;
     				frm.sch_expense_group.value = combo3.Code;
     				
     				var sXml = sheet1.GetSearchXml("CPS_GEM_0010GS.do", FormQueryString(frm));
     				
     				var langDiv = getLanguage();
     				// ---------------------------------
     				// Group Expense 
     				// --------------------------------- 
     	  			combo3.RemoveAll();
     	  			combo3.InsertItem(0,"Select All","");
     	  			
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

    			case IBSAVE:        //저장
//    	          	if(!validateForm(sheetObj,formObj,sAction)) return;
//    				alert (" Save .. ");
    				break;

    			case IBINSERT:      // 입력
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
         
         function onOnlyNumber(obj){
         	 
          	  if ((event.keyCode >= 48 && event.keyCode <= 57) || event.keyCode == 8 || event.keyCode == 9 
          			|| (event.keyCode >= 96 && event.keyCode <= 105) || event.keyCode == 46
          			|| (event.keyCode >= 37 && event.keyCode <= 40)) {
          	   
          	  } else {
          	   event.returnValue = false;
          	  }
         }
         
         /**
          * Key 체크
          */
         function chkKey(colName) {
        	 
        	 var objLvl1 = eval(colName);
        	 
        	 if(objLvl1.value.length == 4 && event.keyCode != 8){
        		 objLvl1.value = objLvl1.value+"-";
        	 }
        	 if(frm.from_rslt_yrmon.value.length == 7){
        		 frm.to_rslt_yrmon.focus();
        	 }
       
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
        	 
        	 return true;
        	 
         }
         
         function sheet1_OnLoadFinish(sheetObj) {
        	//오피스 콤보 호출
     	    doActionIBSheet(SEARCHLIST20);
             
             // 초기Data조회
     		doActionIBSheet(IBSEARCH);
     		 
     		doActionIBSheet(SEARCHLIST02);
     		
     		frm.from_rslt_yrmon.focus();
      	 }
         
         
         /**
          * 선택된 Item이 변경되었을 때 이벤트가 발생한다.
          * @param comboObj
          * @param index_cd
          * @param text
          * @return
          */
          /*
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
          */
          
        //===================================================================================
        //IBCombo 이벤트 처리
        //===================================================================================
        /**
        * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
        * @return
        */
        function combo3_OnCheckClick(comboObj, index, code) {
        	if(index==0) {
        	   	//checked
        	   	var bChk = comboObj.CheckIndex(index);
        		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
        			comboObj.CheckIndex(i) = bChk;
        		}
	        } else {
	        		comboObj.CheckIndex(0) = false;
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
          
 function setTarget(val) {
	if (val == "ini") {
		frm.target_rpt[0].disabled = true;
		frm.target_rpt[1].disabled = true;
		frm.target_rpt[2].disabled = true;
		frm.target_rpt[3].disabled = true;

		frm.rt_fm_mon.value = "";
		frm.rt_to_mon.value = "";

	} else {
		frm.target_rpt[0].disabled = false;
		frm.target_rpt[1].disabled = false;
		frm.target_rpt[2].disabled = false;
		frm.target_rpt[3].disabled = false;

	}
}
          
function setTargetCon(val) {
	if (!frm.sel_target[0].checked) {
		if (val == "expense") {

			frm.target_rpt[0].checked = true;

			frm.sls_ofc_div_cd[0].disabled = false;
			frm.sls_ofc_div_cd[1].disabled = false;
			
			frm.sel_target[3].checked = true;
			frm.sel_target[0].disabled = true;
			frm.sel_target[1].disabled = true;
			frm.sel_target[2].disabled = true;

			frm.ofc_cur[1].disabled = false;
			frm.ofc_cur[2].disabled = false;

			if (frm.ofc_cur[0].checked) {
				ComShowCodeMessage("GEM01079");
				frm.ofc_cur[1].checked = true;
			}

			frm.ofc_cur[0].disabled = true;

			frm.expn_dep[0].disabled = false;

			frm.expn_dep[0].checked = true;
			frm.expn_dep[1].disabled = true;

			frm.ofc_sal[0].checked = true;
			frm.ofc_sal[1].disabled = true;
			frm.ofc_sal[2].disabled = true;

			frm.ofc_co[1].disabled = false;
			frm.ofc_co[1].checked = true;
			frm.ofc_co[0].disabled = true;
			frm.ofc_co[2].disabled = true;

		}

		if (val == "office") {

			frm.target_rpt[1].checked = true;
			
			frm.sls_ofc_div_cd[0].disabled = false;
			frm.sls_ofc_div_cd[1].disabled = false;			

			frm.sel_target[3].checked = true;
			frm.sel_target[0].disabled = true;
			frm.sel_target[1].disabled = true;
			frm.sel_target[2].disabled = true;

			frm.ofc_cur[1].disabled = false;
			frm.ofc_cur[2].disabled = false;

			if (frm.ofc_cur[0].checked) {
				ComShowCodeMessage("GEM01079");
				frm.ofc_cur[1].checked = true;
			}

			frm.ofc_cur[0].disabled = true;

			frm.expn_dep[0].disabled = false;
			frm.expn_dep[1].disabled = false;

			frm.ofc_sal[0].checked = true;
			frm.ofc_sal[1].disabled = true;
			frm.ofc_sal[2].disabled = true;

			frm.ofc_co[1].disabled = false;
			frm.ofc_co[1].checked = true;
			frm.ofc_co[0].disabled = true;
			frm.ofc_co[2].disabled = true;

		}

		if (val == "subsidiary") {

			frm.target_rpt[2].checked = true;

			frm.sls_ofc_div_cd[0].disabled = false;
			frm.sls_ofc_div_cd[1].disabled = false;

			frm.sel_target[3].checked = true;
			frm.sel_target[0].disabled = true;
			frm.sel_target[1].disabled = true;
			frm.sel_target[2].disabled = true;

			frm.ofc_cur[1].disabled = false;
			frm.ofc_cur[2].disabled = false;

			if (frm.ofc_cur[0].checked) {
				ComShowCodeMessage("GEM01079");
				frm.ofc_cur[1].checked = true;
			}

			frm.ofc_cur[0].disabled = true;

			frm.expn_dep[1].checked = true;
			frm.expn_dep[0].disabled = true;
			frm.expn_dep[1].disabled = false;

			frm.ofc_sal[0].checked = true;
			frm.ofc_sal[1].disabled = true;
			frm.ofc_sal[2].disabled = true;

			frm.ofc_co[2].disabled = false;
			frm.ofc_co[2].checked = true;
			frm.ofc_co[0].disabled = true;
			frm.ofc_co[1].disabled = true;

		}

		if (val == "monthly") {

			frm.target_rpt[3].checked = true;
			
			frm.sel_target[3].checked = true;
			frm.sel_target[0].disabled = true;
			frm.sel_target[1].disabled = true;
			frm.sel_target[2].disabled = true;

			frm.ofc_cur[0].checked = true;
			frm.ofc_cur[1].checked = false;
			frm.ofc_cur[2].checked = false;

			frm.ofc_cur[0].disabled = false;
			frm.ofc_cur[1].disabled = true;
			frm.ofc_cur[2].disabled = true;

			frm.expn_dep[0].checked = false;
			frm.expn_dep[1].checked = true;

			frm.expn_dep[0].disabled = true;
			frm.expn_dep[1].disabled = false;

			frm.ofc_sal[0].checked = true;
			frm.ofc_sal[1].disabled = true;
			frm.ofc_sal[2].disabled = true;

			frm.ofc_co[1].disabled = false;
			frm.ofc_co[1].checked = true;
			frm.ofc_co[0].disabled = true;
			frm.ofc_co[2].disabled = true;

			frm.sls_ofc_div_cd[0].checked = false;
			frm.sls_ofc_div_cd[1].checked = true;
			setHOHQ01('HQ');
			selLevelChange('GEM_COMMONGS.do', 'SEARCHLIST01', 'sheet1',
					'sls_ofc_div_cd', '1', 'document.form.ofc_lvl');
			frm.sls_ofc_div_cd[0].disabled = true;

		}

		frm.sub_office_view.disabled = true;
		frm.monthly_view.disabled = true;
		frm.comparing_last_year.disabled = true;

	}
}
          



/**
 * Do you want to initialize?
 */
function ComCodeMsgByInitialize01() {
	return ComShowCodeConfirm('GEM00015');
}
          
          /**
           * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
           */
          function getBackEndJobStatus() {

          		frm.f_cmd.value = SEARCHLIST11;
          		var sXml = sheet1.GetSearchXml("CPS_GEM_0018GS.do", FormQueryString(frm));
          		var arrXml = sXml.split("|$$|");
          		var jobState = ComGetEtcData(arrXml[0], "jb_sts_flg")
          		// alert("sheet1 :::>> jobState : "+jobState);
          	
          		if(jobState == "3") {
          	    	getBackEndJobLoadFile();
          	    	clearInterval(timer);
          	    } else if(jobState == "4") {
          	    	// BackEndJob을 실패 하였습니다.
          	    	comShowBackEndErrorMsg('GEM01059');
          	    } else if(jobState == "5") {
          	    	// 이미 BackEndJob 결과 파일을 읽었습니다.
          	    	comShowBackEndErrorMsg('GEM01060');
          	    }
          	  
          }
          
          /**
           * BackEndJob의 결과가 완료되면 Excel파일로 내려받음.(Request Expense Inital)
           */
          function getBackEndJobLoadFile() {

          	frm.f_cmd.value = SEARCHLIST12;
          	var sXml = sheet1.GetSearchXml("CPS_GEM_0018GS.do", FormQueryString(frm));
          	var arrXml = sXml.split("|$$|");
          	//alert("arrXml : "+arrXml);
          	if(arrXml.length > 0) {
          		sheet1.LoadSearchXml(arrXml[0]);
  				
  				sheet1.CellValue(1, 20) = frm.from_rslt_yrmon.value.substring(0,4);
  				sheet1.CellValue(1, 21) = frm.from_rslt_yrmon.value.substring(0,4);
  				sheet1.CellValue(1, 22) = frm.from_rslt_yrmon.value.substring(0,4);
  				sheet1.CellValue(1, 23) = frm.from_rslt_yrmon.value.substring(0,4);
  				sheet1.CellValue(1, 24) = frm.from_rslt_yrmon.value.substring(0,4);
  				sheet1.CellValue(1, 25) = frm.from_rslt_yrmon.value.substring(0,4);
  				sheet1.CellValue(1, 26) = frm.from_rslt_yrmon.value.substring(0,4);
  				sheet1.CellValue(1, 27) = frm.from_rslt_yrmon.value.substring(0,4);
  				sheet1.CellValue(1, 28) = frm.from_rslt_yrmon.value.substring(0,4);
  				sheet1.CellValue(1, 29) = frm.from_rslt_yrmon.value.substring(0,4);
  				sheet1.CellValue(1, 30) = frm.from_rslt_yrmon.value.substring(0,4);
  				sheet1.CellValue(1, 31) = frm.from_rslt_yrmon.value.substring(0,4);
  				sheet1.CellValue(1, 32) = frm.from_rslt_yrmon.value.substring(0,4);
  				
  				sheet1.CellValue(1, 33) = frm.from_rslt_yrmon.value.substring(0,4)-1;
  				sheet1.CellValue(1, 34) = frm.from_rslt_yrmon.value.substring(0,4)-1;
  				sheet1.CellValue(1, 35) = frm.from_rslt_yrmon.value.substring(0,4)-1;
  				sheet1.CellValue(1, 36) = frm.from_rslt_yrmon.value.substring(0,4)-1;
  				sheet1.CellValue(1, 37) = frm.from_rslt_yrmon.value.substring(0,4)-1;
  				
  				sheet1.CellValue(1, 38) = frm.from_rslt_yrmon.value.substring(0,4)-2;
  				sheet1.CellValue(1, 39) = frm.from_rslt_yrmon.value.substring(0,4)-2;
  				sheet1.CellValue(1, 40) = frm.from_rslt_yrmon.value.substring(0,4)-2;
  				sheet1.CellValue(1, 41) = frm.from_rslt_yrmon.value.substring(0,4)-2;
  				sheet1.CellValue(1, 42) = frm.from_rslt_yrmon.value.substring(0,4)-2;
  				
  				sheet1.CellValue(1, 43) = frm.from_rslt_yrmon.value.substring(0,4)-3;
  				sheet1.CellValue(1, 44) = frm.from_rslt_yrmon.value.substring(0,4)-3;
  				sheet1.CellValue(1, 45) = frm.from_rslt_yrmon.value.substring(0,4)-3;
  				sheet1.CellValue(1, 46) = frm.from_rslt_yrmon.value.substring(0,4)-3;
  				sheet1.CellValue(1, 47) = frm.from_rslt_yrmon.value.substring(0,4)-3;
  				
  				if(frm.monthly_view.checked){
  					sheet1.CellValue(2, 5) = "MON";
  					sheet1.CellValue(3, 5) = "MON";
  				}
  				else{
  					sheet1.CellValue(2, 5) = "FM\nMON";
  					sheet1.CellValue(3, 5) = "FM\nMON";
  				}
  				
  				if(frm.ofc_cur[2].checked){
  					sheet1.CellValue(2, 23) = "KRW(Ex.Rate-Plan)";
  					sheet1.CellValue(2, 24) = "KRW(Ex.Rate-Plan)";
  					sheet1.CellValue(2, 25) = "KRW(Ex.Rate-Plan)";
  					
  					sheet1.CellValue(2, 26) = "KRW(Ex.Rate-Account)";
  					sheet1.CellValue(2, 27) = "KRW(Ex.Rate-Account)";
  					sheet1.CellValue(2, 28) = "KRW(Ex.Rate-Account)";
  					
  					sheet1.CellValue(3, 34) = "KRW\n(Ex.Rate-Plan)";
  					sheet1.CellValue(3, 35) = "KRW\n(Ex.Rate-Account)";		  					
  					sheet1.CellValue(3, 37) = "KRW*";
  					
  					sheet1.CellValue(3, 39) = "KRW\n(Ex.Rate-Plan)";
  					sheet1.CellValue(3, 40) = "KRW\n(Ex.Rate-Account)";		  					
  					sheet1.CellValue(3, 42) = "KRW*";
  					
  					sheet1.CellValue(3, 44) = "KRW\n(Ex.Rate-Plan)";
  					sheet1.CellValue(3, 45) = "KRW\n(Ex.Rate-Account)";		  					
  					sheet1.CellValue(3, 47) = "KRW*";
  					
  				}
  				else{
  					sheet1.CellValue(2, 23) = "USD(Ex.Rate-Plan)";
  					sheet1.CellValue(2, 24) = "USD(Ex.Rate-Plan)";
  					sheet1.CellValue(2, 25) = "USD(Ex.Rate-Plan)";
  					
  					sheet1.CellValue(2, 26) = "USD(Ex.Rate-Account)";
  					sheet1.CellValue(2, 27) = "USD(Ex.Rate-Account)";
  					sheet1.CellValue(2, 28) = "USD(Ex.Rate-Account)";
  					
  					sheet1.CellValue(3, 34) = "USD\n(Ex.Rate-Plan)";
  					sheet1.CellValue(3, 35) = "USD\n(Ex.Rate-Account)";		  					
  					sheet1.CellValue(3, 37) = "USD*";
  					
  					sheet1.CellValue(3, 39) = "USD\n(Ex.Rate-Plan)";
  					sheet1.CellValue(3, 40) = "USD\n(Ex.Rate-Account)";		  					
  					sheet1.CellValue(3, 42) = "USD*";
  					
  					sheet1.CellValue(3, 44) = "USD\n(Ex.Rate-Plan)";
  					sheet1.CellValue(3, 45) = "USD\n(Ex.Rate-Account)";		  					
  					sheet1.CellValue(3, 47) = "USD*";
  				}
  				
  				var maskfield = "";
  				
  				if(frm.monthly_view.checked){
  					maskfield = "rt_to_mon";
  				}
  				if(frm.sub_office_view.checked){
  					maskfield = maskfield + "|gen_expn_init_amt|lcl_assigned|usd_expn_init_amt|usd_assigned|usd_acc_expn_init_amt|usd_acc_assigned";
  				}
  				if(!frm.comparing_last_year.checked){
  					maskfield = maskfield + "|slp_perf_amt01|usd_perf_amt01|usd_acc_perf_amt01|lcl_ratio01|usd_ratio01|slp_perf_amt02|usd_perf_amt02|usd_acc_perf_amt02|lcl_ratio02|usd_ratio02|slp_perf_amt03|usd_perf_amt03|usd_acc_perf_amt03|lcl_ratio03|usd_ratio03";
  				}
  				
  				//sheet1.Down2Excel(1,false,false,true,"","apps/opus/cps/gem/gemplanningperformance/gemplanningperformance/script/CPS_GEM_0018_01.xml",false,false,"Summary_After Closing",false,maskfield);
  				//sheet1.SpeedDown2Excel(1,false,false,"","apps/opus/cps/gem/gemplanningperformance/gemplanningperformance/script/CPS_GEM_0018_01.xml",false,false,"Summary_After Closing",false,maskfield);
  				
          	}
          	ComOpenWait(false);
          	
          	if (sheet1.RowCount <= 0 ) {
          		// There is no related data!
          		ComCodeMsgByNoRelatedData();
          		return;
          	} else {
          		sheet1.SpeedDown2Excel(1,false,false,"","apps/opus/cps/gem/gemplanningperformance/gemplanningperformance/script/CPS_GEM_0018_01.xml",false,false,"Summary_After Closing",false,maskfield);         		
          	}
          }

	/* 개발자 작업  끝 */