/*===================================================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0002.js
*@FileTitle : Accrual Result by Account Code (Tab1)
*Open Issues :
*Change history :2007-02-13 Park Yeon Jin 최초 생성
*@LastModifyDate : 2009.09.09
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.09.09 전재홍
* 1.0 Creation
* 2009-01-05 Jeon Jae Hong :(1) Manual Input 화면에서 Account 항목 추가(6개) 
*            			    (2) Manual Input 화면에서 입력값에 따른 자동계산 로직 추가
===================================================================================*/
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
     * @class ESD_LEA_0002 : ESD_LEA_0002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_LEA_0002() {
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
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject 	= sheetObjects[0];
             var sheetObject1 	= sheetObjects[1];
             var sheetObject2 	= sheetObjects[2];
             var sheetObject3 	= sheetObjects[3];

             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

            	    case "btn_retrieve":
            	        lea_retrieve(sheetObject, sheetObject1, formObject);
            	        
            	        /* GL_ACCL_IF Confirm 여부(ERP_IF_FLG = 'Y') 조회 */
            	        lea_getFlagValues(sheetObject3, formObject);
            	        
    					break;

            	    case "t1btng_confirm":
            	    	if ( sheetObject.RowCount < 1 ){
            	    		ComShowMessage(ComGetMsg("LEA90008"));	//No data found.
            	    		return false;
            	    	}
            	    	//lea_getFlagValues(sheetObject3, formObject);	//parameter 변경 : sheetObject3 << sheetObject1 전용sheet추가(etc data)
            	    	
            	    	
//            	    	if(formObject.frm_mnl_inp_flg.value != "Y"){
//            	    		ComShowMessage(ComGetMsg("LEA90009"));	//Not Saved Manual Input.
//            	    		return false;
//            	    	} 
//        	            
//            	    	if(formObject.erp_if_dt.value == "Y"){
//            	    		ComShowMessage(ComGetMsg("LEA90010"));	//Completed ERP interface
//            	    		return false;
//            	    	}
            	    	
            	    	doActionIBSheet(sheetObject, formObject, IBSAVE);
            	    	
            	        /* GL_ACCL_IF Confirm 여부(ERP_IF_FLG = 'Y') 조회 */
            	        lea_getFlagValues(sheetObject3, formObject);
            	        
            	        break;

            	
            	    case "t1btng_downexcel":
//            	    	lea_form2sheet(formObject,sheetObject2);
//            	    	sheetObject2.Down2Excel(-1,false,false,true,"","",false,false, "",true);
//            	    	sheetObject Down2Excel(-1,true,false,true,"","",false,false, "",true);
        	            //doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
            	    	sheetObject. ExcelOption= "NOCOLOR";
            	    	sheetObject.SpeedDown2Excel(true);
            	    	sheetObject. ExcelOption= "";   
            	        break;

            	    case "t2btng_save":
        	            
            	    	if ( sheetObject1.RowCount < 1 ){
    		              	ComShowMessage(ComGetMsg("LEA90008"));	//No data found.
    		                return false;
    		            }
            	    	
    					lea_getFlagValues(sheetObject3, formObject);
    					
           	    		if(formObject.frm_erp_if_flg.value == "Y"){
    		              	ComShowMessage(ComGetMsg("LEA90012"));	//Confirmed.
    		                return false;
           	    		} 
        	            if(formObject.erp_if_dt.value == "Y"){
    		              	ComShowMessage(ComGetMsg("LEA90010"));	//Completed ERP interface
    		                return false;
           	    		}
           	    		if(formObject.frm_cond_cfm_flg.value != "Y"){
    		              	ComShowMessage(ComGetMsg("LEA90013"));	//Not Confirmed Accrual Batch Condition Item
    		                return false;
           	    		}
           	    		
           	    		doActionIBSheet2(sheetObject1,formObject,IBSAVE);
           	    		
           	    		//doActionIBSheet2(sheetObject1,formObject,IBSEARCH);

           	    		break;

            	    case "t2btng_downexcel":
//            	    	lea_form2sheet(formObject,sheetObject2);
//    					sheetObject2.Down2Excel(-1,false,false,true,"","",false,false, "",true);
//    					sheetObject1.Down2Excel(-1,true	,false,true,"","",false,false, "",true);
//        	            doActionIBSheet2(sheetObject1,formObject,IBDOWNEXCEL);
            	    	sheetObject1. ExcelOption= "NOCOLOR";
            	    	sheetObject1.SpeedDown2Excel(true);
            	    	sheetObject1. ExcelOption= "";   
            	        break;

                    case "btns_calendar1":
           	         	var cal = new ComCalendar();
           	         	cal.setDisplayType('month');
           	         	cal.select(formObject.frm_rev_yrmon_from, 'yyyy-MM');
           	         	break;

                    case "btns_calendar2":
           	         	var cal = new ComCalendar();
           	         	cal.setDisplayType('month');
           	         	cal.select(formObject.frm_rev_yrmon_to, 'yyyy-MM');
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
        	
            for(i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet(sheetObjects[i]);

                initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }

    		for(k=0;k<tabObjects.length;k++){
    			initTab(tabObjects[k],k+1);
    		}
    		
    }
       /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj, sheetNo) {

            var cnt = 0;

            switch(sheetNo) {
                case 1:      //IBSheet1 init
                    with (sheetObj) {
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                        //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 15, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(17, 3, 0, true);

                       // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, true, true, false, false)

                        var HeadTitle  = "STS|Exe.\nMonth|Rev.\nMonth|Accrual\nType|Account\nCode|Account Name|Estimated\nCost|Actual Cost|Actual Cost|Actual Cost|Actual Cost|Accrual\nCost |Confirmed\nCost|Cost Diff.||" ;
                        var HeadTitle1 = "STS|Exe.\nMonth|Rev.\nMonth|Accrual\nType|Account\nCode|Account Name|Estimated\nCost|Pre-\nAllocated|Post-\nAllocated|Diff.|Actual\nRatio (%)|Accrual\nCost |Confirmed\nCost|Cost Diff.||" ;

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle , true);
                        InitHeadRow(1, HeadTitle1, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++,  dtHiddenStatus ,    	 30,    daCenter,  true,    "ibflag");
    					InitDataProperty(0, cnt++ , dtHidden ,       80,    daCenter,  true ,    "exe_yrmon"          ,        false,          "",       dfDateYm 		,   	0,     false,        false);                                              
    					InitDataProperty(0, cnt++ , dtData   ,       80,    daCenter,  true ,    "rev_yrmon"          ,        false,          "",       dfDateYm 		,   	0,     false,        false); 
    					InitDataProperty(0, cnt++ , dtCombo  ,      100,    daCenter,  true ,    "accl_auto_cd"       ,        false,          "",       dfNone   		,   	0,     false,        false);                                              
    					InitDataProperty(0, cnt++ , dtData   ,       60,    daCenter,  true ,    "acct_cd"            ,        false,          "",       dfNone   		,   	0,     false,        false);                                              
    					InitDataProperty(0, cnt++ , dtData   ,      250,    daLeft,  true ,    "acct_cd_nm"         ,        false,          "",       dfNone   		,   	0,     false,        false, -1, false,true, true);                                              
    					InitDataProperty(0, cnt++ , dtAutoSum,       80,    daRight ,  true ,    "estm_cost_amt"      ,        false,          "",       dfFloat		,   	2,     false,        false);                                              
    					InitDataProperty(0, cnt++ , dtAutoSum,       80,    daRight ,  false,    "pre_act_cost_amt"   ,        false,          "",       dfFloat		,   	2,     false,        false);                                              
    					InitDataProperty(0, cnt++ , dtAutoSum,       80,    daRight ,  false,    "pst_act_cost_amt"   ,        false,          "",       dfFloat		,   	2,     false,        false);                                              
    					InitDataProperty(0, cnt++ , dtAutoSum,       80,    daRight ,  false,    "diff_act_cost_amt"  ,        false,          "",       dfFloat		,   	2,     false,        false);        
    					InitDataProperty(0, cnt++ , dtData   ,       80,    daRight ,  false,    "act_cost_ratio"     ,        false,          "",       dfNullFloatOrg	,   	1,     false,        false);       
    					InitDataProperty(0, cnt++ , dtAutoSum,       80,    daRight ,  true ,    "accl_cost_amt"      ,        false,          "",       dfFloat		,   	2,     false,        false);                                              
    					InitDataProperty(0, cnt++ , dtAutoSum,       80,    daRight ,  true ,    "confirmed_cost_amt" ,        false,          "",       dfFloat		,   	2,     false,        false);           
    					InitDataProperty(0, cnt++ , dtAutoSum,       80,    daRight ,  true ,    "diff_cost_amt"      ,        false,          "",       dfFloat		,   	2,     false,        false); 
    					InitDataProperty(0, cnt++ , dtHidden ,       60,    daCenter,  false,    "mnl_inp_flg"        ,        false,          "",       dfNone   		,   	0,     false,        false);                                              
    					InitDataProperty(0, cnt++ , dtHidden ,       60,    daCenter,  false,    "erp_if_flg"         ,        false,          "",       dfNone   		,   	0,     false,        false);                                              
    					InitDataProperty(0, cnt++ , dtHidden ,       60,    daCenter,  false,    "erp_if_dt"          ,        false,          "",       dfNone   		,   	0,     false,        false);                                              
    					
    					InitDataCombo(0 , "accl_auto_cd"	, "Auto Accrual|Manual Accrual|Transfer", "A|M|T");
    										
                        RangeBackColor(1, 7, 1, 10) = RgbColor(222, 251, 248);   // ENIS
                        style.height = GetSheetHeight(17) ;
                   }
                    break;
                    
                case 2:      //IBSheet2 init
                    with (sheetObj) {
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                        //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 15, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        //InitColumnInfo(51, 3, 0, true);
                        InitColumnInfo(59, 3, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, true, true, false, false)
    	            		
    	            	var HeadTitle   = "STS|Exe.\nMonth|Rev.\nMonth|Full Volume Discount & Incentive-\nTerminal (512073)|Full Volume Discount & Incentive-\nTerminal (512073)|Full Volume Discount & Incentive-\nTerminal (512073)|Full Volume Discount & Incentive-\nTerminal (512073)|";
    	            		HeadTitle  += "Full Volume Discount & Incentive-\nTransportation (512361)|Full Volume Discount & Incentive-\nTransportation (512361)|Full Volume Discount & Incentive-\nTransportation (512361)|Full Volume Discount & Incentive-\nTransportation (512361)|";
    	            		
    	            		HeadTitle  += "|Empty Volume Discount & Incentive-\nTerminal (512074)|Empty Volume Discount & Incentive-\nTerminal (512074)|Empty Volume Discount & Incentive-\nTerminal (512074)||Empty Volume Discount & Incentive-\nTransportation (512362)|Empty Volume Discount & Incentive-\nTransportation (512362)|Empty Volume Discount & Incentive-\nTransportation (512362)|";
    	            		
    	            		HeadTitle  += "|Empty Stevedorage\n(512061)|Empty Stevedorage\n(512061)|Empty Stevedorage\n(512061)|";
    	            		HeadTitle  += "|Empty Terminal Handling\n(512151)|Empty Terminal Handling\n(512151)|Empty Terminal Handling\n(512151)|";
    	            		HeadTitle  += "|Empty RePosition Storage\n(512221)|Empty RePosition Storage\n(512221)|Empty RePosition Storage\n(512221)|";
    	            		HeadTitle  += "|Empty RePosition Transportation\n(512341)|Empty RePosition Transportation\n(512341)|Empty RePosition Transportation\n(512341)|";
    	            		
    	            		HeadTitle  += "|Chassis Bundle Cost\n (512171)|Chassis Bundle Cost\n (512171)|Chassis Bundle Cost\n (512171)|";
    	            		HeadTitle  += "|Chassis Drayage \n (512331)|Chassis Drayage \n (512331)|Chassis Drayage \n (512331)|"	;

    	            		HeadTitle  += "|US Domestic Rail Cost\n(512351)|US Domestic Rail Cost\n(512351)|US Domestic Rail Cost\n(512351)|";
    	            		HeadTitle  += "|Other Carrier's Terminal Cost\n(512019)|Other Carrier's Terminal Cost\n(512019)|Other Carrier's Terminal Cost\n(512019)|";
    	            		HeadTitle  += "|3rd Party Billing \nStevedorage (512181)|3rd Party Billing \nStevedorage (512181)|3rd Party Billing \nStevedorage (512181)|";
    	            		HeadTitle  += "|3rd Party Billing \nTransportation (512381)|3rd Party Billing \nTransportation (512381)|3rd Party Billing \nTransportation (512381)|";
                        
    	            		var HeadTitle1  = "STS|Exe.\nMonth|Rev.\nMonth|";
    	             		HeadTitle1 += "|Estimated \n Cost|Actual \n Cost|Accrual \n Cost||Estimated \n Cost|Actual \n Cost|Accrual \n Cost|";
    	             		
    	             		HeadTitle1 += "|Estimated \n Cost|Actual \n Cost|Accrual \n Cost||Estimated \n Cost|Actual \n Cost|Accrual \n Cost|";
    	             		
    	             		HeadTitle1 += "|Estimated \n Cost|Actual \n Cost|Accrual \n Cost||Estimated \n Cost|Actual \n Cost|Accrual \n Cost|";
    	             		HeadTitle1 += "|Estimated \n Cost|Actual \n Cost|Accrual \n Cost||Estimated \n Cost|Actual \n Cost|Accrual \n Cost|";
    	             		
    	             		HeadTitle1 += "||Actual \n Cost|||Estimated \n Cost|Actual \n Cost|Accrual \n Cost|";
    	             		
    	             		HeadTitle1 += "|Estimated \n Cost|Actual \n Cost|Accrual \n Cost||Estimated \n Cost|Actual \n Cost|Accrual \n Cost|";
    	             		HeadTitle1 += "|Estimated \n Cost|Actual \n Cost|Accrual \n Cost||Estimated \n Cost|Actual \n Cost|Accrual \n Cost|";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);
                        InitHeadRow(1, HeadTitle1, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++,  dtHiddenStatus,    	  30,    daCenter,  true ,    "ibflag");
    					InitDataProperty(0, cnt++ , dtHidden,       65,    daCenter,  true ,    "exe_yrmon"		  ,        false,          "",       dfDateYm 	,   	0,     false,        false); 																															
    					InitDataProperty(0, cnt++ , dtData  ,       65,    daCenter,  true ,    "rev_yrmon"       ,        false,          "",       dfDateYm  	,   	0,     false,        false);                                                              
    					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true ,    "ibflag_a"        ,        false,          "",       dfNone   	,   	0,     false,        false );                                                              
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "estm_cost_amt_a" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "act_cost_amt_a"  ,        false,          "",       dfNullFloat,   	2,     false,        false , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "accl_cost_amt_a" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					
    					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true ,    "ibflag_d"        ,        false,          "",       dfNone   	,   	0,     false,        false );                                                              
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "estm_cost_amt_d" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "act_cost_amt_d"  ,        false,          "",       dfNullFloat,   	2,     false,        false , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "accl_cost_amt_d" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);
    					
    					//EMPTY VOL. INCENTIVE START//
    					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true ,    "ibflag_aa"        ,        false,          "",       dfNone   	,   	0,     false,        false );                                                              
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "estm_cost_amt_aa" ,        false,          "",       dfNullFloat,   	2,     false ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "act_cost_amt_aa" ,        false,          "",       dfNullFloat,   	2,     false ,        false  , 14);
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "accl_cost_amt_aa" ,        false,          "",       dfNullFloat,   	2,     false ,        true  , 14);			
    					
    					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true ,    "ibflag_dd"        ,        false,          "",       dfNone   	,   	0,     false,        false );                                                              
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "estm_cost_amt_dd" ,        false,          "",       dfNullFloat,   	2,     false ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "act_cost_amt_dd" ,        false,          "",       dfNullFloat,   	2,     false ,        false  , 14);
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "accl_cost_amt_dd" ,        false,          "",       dfNullFloat,   	2,     false ,        true  , 14);			
    					//EMPTY VOL. INCENTIVE END//
    					
    					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true ,    "ibflag_f"        ,        false,          "",       dfNone   	,   	0,     false,        false );                                                              
    					InitDataProperty(0, cnt++ , dtHidden  ,       95,    daRight ,  false,    "estm_cost_amt_f" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "act_cost_amt_f"  ,        false,          "",       dfNullFloat,   	2,     false,        false , 14);                 
    					InitDataProperty(0, cnt++ , dtHidden  ,       95,    daRight ,  false,    "accl_cost_amt_f" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);			
    					
    					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true ,    "ibflag_g"        ,        false,          "",       dfNone   	,   	0,     false,        false );                                                              
    					InitDataProperty(0, cnt++ , dtHidden  ,       95,    daRight ,  false,    "estm_cost_amt_g" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "act_cost_amt_g"  ,        false,          "",       dfNullFloat,   	2,     false,        false , 14);                 
    					InitDataProperty(0, cnt++ , dtHidden  ,       95,    daRight ,  false,    "accl_cost_amt_g" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14); 
    					
    					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true ,    "ibflag_h"        ,        false,          "",       dfNone   	,   	0,     false,        false );                                                              
    					InitDataProperty(0, cnt++ , dtHidden  ,       95,    daRight ,  false,    "estm_cost_amt_h" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "act_cost_amt_h"  ,        false,          "",       dfNullFloat,   	2,     false,        false , 14);                 
    					InitDataProperty(0, cnt++ , dtHidden  ,       95,    daRight ,  false,    "accl_cost_amt_h" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14); 
    					
    					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true ,    "ibflag_i"        ,        false,          "",       dfNone   	,   	0,     false,        false );                                                              
    					InitDataProperty(0, cnt++ , dtHidden  ,       95,    daRight ,  false,    "estm_cost_amt_i" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "act_cost_amt_i"  ,        false,          "",       dfNullFloat,   	2,     false,        false , 14);                 
    					InitDataProperty(0, cnt++ , dtHidden  ,       95,    daRight ,  false,    "accl_cost_amt_i" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14); 
    					
    					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true ,    "ibflag_l"        ,        false,          "",       dfNone   	,   	0,     false,        false );                                                              
    					InitDataProperty(0, cnt++ , dtHidden  ,       95,    daRight ,  false,    "estm_cost_amt_l" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "act_cost_amt_l"  ,        false,          "",       dfNullFloat,   	2,     false,        false , 14);                 
    					InitDataProperty(0, cnt++ , dtHidden  ,       95,    daRight ,  false,    "accl_cost_amt_l" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14); 
    					
    					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true ,    "ibflag_m"        ,        false,          "",       dfNone   	,   	0,     false,        false );                                                              
    					InitDataProperty(0, cnt++ , dtHidden  ,       95,    daRight ,  false,    "estm_cost_amt_m" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "act_cost_amt_m"  ,        false,          "",       dfNullFloat,   	2,     false,        false , 14);                 
    					InitDataProperty(0, cnt++ , dtHidden  ,       95,    daRight ,  false,    "accl_cost_amt_m" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14); 
    				
    					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true ,    "ibflag_c"        ,        false,          "",       dfNone   	,   	0,     false,        false );                                                              
    					InitDataProperty(0, cnt++ , dtHidden  ,       95,    daRight ,  false,    "estm_cost_amt_c" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "act_cost_amt_c"  ,        false,          "",       dfNullFloat,   	2,     false,        false , 14);                 
    					InitDataProperty(0, cnt++ , dtHidden  ,       95,    daRight ,  false,    "accl_cost_amt_c" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					
    					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true ,    "ibflag_b"        ,        false,          "",       dfNone   	,   	0,     false,        false );                                                              
    					InitDataProperty(0, cnt++ , dtHidden  ,       95,    daRight ,  false,    "estm_cost_amt_b" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "act_cost_amt_b"  ,        false,          "",       dfNullFloat,   	2,     false,        false , 14);                 
    					InitDataProperty(0, cnt++ , dtHidden  ,       95,    daRight ,  false,    "accl_cost_amt_b" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					
    					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true ,    "ibflag_j"        ,        false,          "",       dfNone   	,   	0,     false,        false );                                                              
    					InitDataProperty(0, cnt++ , dtHidden  ,       95,    daRight ,  false,    "estm_cost_amt_j" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "act_cost_amt_j"  ,        false,          "",       dfNullFloat,   	2,     true,        true , 14);                 
    					InitDataProperty(0, cnt++ , dtHidden  ,       95,    daRight ,  false,    "accl_cost_amt_j" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14); 
    					
    					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true ,    "ibflag_k"        ,        false,          "",       dfNone   	,   	0,     false,        false );                                                              
    					InitDataProperty(0, cnt++ , dtHidden  ,       95,    daRight ,  false,    "estm_cost_amt_k" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "act_cost_amt_k"  ,        false,          "",       dfNullFloat,   	2,     true,        true , 14);                 
    					InitDataProperty(0, cnt++ , dtHidden  ,       95,    daRight ,  false,    "accl_cost_amt_k" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14); 
    					
                        RangeBackColor(1,3, 1, 42) = RgbColor(222, 251, 248);   // ENIS
                        style.height = GetSheetHeight(16) ;
                   }
                    break;
                    
                case 3:      //IBSheet2 init
                    with (sheetObj) {
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                        //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 9, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(3, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, true, true, false,false)

                        var HeadTitle   = "Exe.\nYear-Month|Rev.Year-Month|Rev.Year-Month";
                        var HeadTitle1  = "Exe.\nYear-Month|From|To";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);
                        InitHeadRow(1, HeadTitle1, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtData  ,       65,    daCenter,  true ,    "exe_yrmon"				,        false,          "",       dfDateYm 	,   	0,     true ,        true  ); 																															
    					InitDataProperty(0, cnt++ , dtData  ,       65,    daCenter,  true ,    "rev_yrmon_from"  ,        false,          "",       dfDateYm  	,   	0,     true ,        true  );                                                              
    					InitDataProperty(0, cnt++ , dtData  ,       65,    daCenter,  true ,    "rev_yrmon_to"    ,        false,          "",       dfDateYm  	,   	0,     true ,        true  );                                                              
                                           
                        HeadRowHeight = 20 ;
                        HeadRowHeight = 21 ;
                         style.height = GetSheetHeight(13) ;
                   }
                    break;
                    
                case 4:      //IBSheet2 init
                    with (sheetObj) {
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

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(4, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, true, true, false, false)

                        var HeadTitle   = "mnl_inp_flg|erp_if_flg|erp_if_dt|cond_cfm_flg";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtData  ,       125,    daCenter,  true ,    "mnl_inp_flg"				,        false,          "",       dfNone 	,   	0,     true ,        true  ); 																															
    					InitDataProperty(0, cnt++ , dtData  ,       125,    daCenter,  true ,    "erp_if_flg"  ,        false,          "",       dfNone  	,   	0,     true ,        true  );                                                              
    					InitDataProperty(0, cnt++ , dtData  ,       125,    daCenter,  true ,    "erp_if_dt"    ,        false,          "",       dfNone  	,   	0,     true ,        true  );                                                              
    					InitDataProperty(0, cnt++ , dtData  ,       125,    daCenter,  true ,    "cond_cfm_flg"    ,        false,          "",       dfNone  	,   	0,     true ,        true  );                                                              
                        
    					
                        HeadRowHeight = 20 ;
                        HeadRowHeight = 21 ;
                         style.height = GetSheetHeight(13) ;
                   }
                    break;                

            }
        }

      // Sheet1관련 프로세스 처리
        function doActionIBSheet(sheetObj, formObj, sAction) {
            sheetObj.ShowDebugMsg = false;

            switch(sAction) {

            	case IBSEARCH:      //조회
                   //if(validateForm(sheetObj,formObj,sAction))
            		formObj.f_cmd.value = SEARCH;
            		//var searchXml 		= sheetObj.GetSearchXml("ESD_LEA_0002GS.do", FormQueryString(formObj));
            		
            		var searchXml 		= sheetObj.GetSearchXml("ESD_LEA_0002GS.do", leaFormQueryString(formObj));
            		
            		//ComShowMessage(searchXml);
            		if(searchXml != "") sheetObj.LoadSearchXml(searchXml, false);
            		break;
            		
            	case IBSAVE:        //저장
    				//if (!lea_comm_validChkForm(formObj)){
    				//		return false;
    				//}
            		
    				formObj.frm_confirm_div.value 	= "E";
    				formObj.f_cmd.value 			= MODIFY;
    				var param 	= sheetObj.GetSaveString(true);
    				//var savexml = sheetObj.GetSaveXml("ESD_LEA_0002GS.do", param+'&' + FormQueryString(formObj));
    				
    				var savexml = sheetObj.GetSaveXml("ESD_LEA_0002GS.do", param+'&' + leaFormQueryString(formObj));
    				
    				if (savexml != "") sheetObj.LoadSaveXml(savexml, true);
    				break;
    				
                				
            	case IBDOWNEXCEL:        // excel down
    	
    					//if(validateForm(sheetObj,formObj,sAction))
    					/*
    						mySheet.Down2Excel([Mode], [UseOpenFile], [NewSheet], [Merge],  [SaveAsName],[ReportPageUrl],[HideExcelMsg],
                                 [WriteTreeLevel], [WorkSheetName], [FocusFirstSheet]) 
            */
            		sheetObj.Down2Excel(-1,false,false,true,"","",false,false, "Accrual Batch Result by Account Code",true);
            		break;
            }
        }
      // Sheet2관련 프로세스 처리
        function doActionIBSheet2(sheetObj, formObj, sAction) {
            sheetObj.ShowDebugMsg = false;

            switch(sAction) {

    			case IBSEARCH:      //조회
                   //if(validateForm(sheetObj,formObj,sAction))
    			   	formObj.f_cmd.value = SEARCH01;
    			   //	var searchXml 		= sheetObj.GetSearchXml("ESD_LEA_0002GS.do", FormQueryString(formObj));
    			   	
    			   	var searchXml 		= sheetObj.GetSearchXml("ESD_LEA_0002GS.do", leaFormQueryString(formObj));
    			   	
    				//ComShowMessage(searchXml);
    				if(searchXml != "") sheetObj.LoadSearchXml(searchXml,false);
    				
    				for (i=2; i<=sheetObjects[1].LastRow; i++)
    				{
    					if(sheetObjects[1].CellValue(i,"rev_yrmon").substr(0,4) > '2011')
    					{
    						sheetObjects[1].CellEditable(i,"estm_cost_amt_a")	= false;
    						sheetObjects[1].CellEditable(i,"accl_cost_amt_a")	= false;
    						sheetObjects[1].CellEditable(i,"estm_cost_amt_d")	= false;
    						sheetObjects[1].CellEditable(i,"accl_cost_amt_d")	= false;
    					}
    				}
    				
					//EMPTY VOL. INCENTIVE 2011년이전 수정불가, 2012년이후 ESTM수정가능, ACT-READ ONLY, ACCL-READ ONLY//
    				for (i=2; i<=sheetObjects[1].LastRow; i++)
    				{
    					if(sheetObjects[1].CellValue(i,"rev_yrmon") >= '201201')
    					{
    						//default : celleditable = false setting//
    						sheetObjects[1].CellEditable(i,"estm_cost_amt_aa")	= true;
    						//sheetObjects[1].CellEditable(i,"accl_cost_amt_aa")	= false;
    						sheetObjects[1].CellEditable(i,"estm_cost_amt_dd")	= true;
    						//sheetObjects[1].CellEditable(i,"accl_cost_amt_dd")	= false;
    					}
    				}    				
                    break;
    				
    			case IBSAVE:        //저장
    				//if (!lea_comm_validChkForm(formObj)){
    				//		return false;
    				//}
    				formObj.frm_confirm_div.value 	= "M";
    				formObj.f_cmd.value 			= MULTI;
    				var param 	= sheetObj.GetSaveString(true);
    				
    				//var savexml = sheetObj.GetSaveXml("ESD_LEA_0002GS.do", param+'&'+FormQueryString(formObj));
    				
    				var savexml = sheetObj.GetSaveXml("ESD_LEA_0002GS.do", param+'&'+ leaFormQueryString(formObj));
    				
    				if (savexml != "") sheetObj.LoadSaveXml(savexml,true);
    				
    				//sheetObj.DoAllSave("ESD_LEA_0002GS.do",FormQueryString(formObj))
    				break;
    			
    			case IBDOWNEXCEL:        // excel down
    				//if(validateForm(sheetObj,formObj,sAction))
    				/*
    				mySheet.Down2Excel([Mode], [UseOpenFile], [NewSheet], [Merge],  [SaveAsName],[ReportPageUrl],[HideExcelMsg],
                   [WriteTreeLevel], [WorkSheetName], [FocusFirstSheet]) 
    				 */
    				
    				sheetObj.Down2Excel(-1,false,false,true,"","",false,false, "Manual Input",true);
    				break;
            }
        }

     /*
       * hidden_sheets4_etc 관련 프로세스처리
       */
      function doActionIBSheet2_etc(sheetObj,formObj,sAction) {
    	  
      	//sheetObj.ShowDebugMsg = false;
      	
      	switch(sAction) {
      		case IBSEARCH_ASYNC01:      //조회
      			//if (!validateForm(sheetObj,formObj,sAction)){
      			//  return false;
      			//}

      			formObj.f_cmd.value = SEARCH02;

      			//var searchXml		= sheetObj.GetSearchXml("ESD_LEA_0002GS.do", FormQueryString(formObj));
      			
      		    var searchXml		= sheetObj.GetSearchXml("ESD_LEA_0002GS.do", leaFormQueryString(formObj));
      			
      	
      			//ComShowMessage(searchXml);
      			if(searchXml != "") sheetObj.LoadSearchXml(searchXml, true);
      			
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
    	}


    	/**
    	 * Tab 기본 설정
    	 * 탭의 항목을 설정한다.
    	 */
    	function initTab(tabObj , tabNo) {

    		 switch(tabNo) {
    		 case 1:
    				with (tabObj) {
    					var cnt  = 0 ;
    					InsertTab( cnt++, "Result By Account Code" , -1 );
    					InsertTab( cnt++, "Manual Input" , -1 );

    				}
    			 break;

    		}
    	}

    	/**
    	 * Tab 클릭시 이벤트 관련
    	 * 선택한 탭의 요소가 활성화 된다.
    	 */
    	function tab1_OnChange(tabObj , nItem)
    	{


    		var objs = document.all.item("tabLayer");

    		objs[nItem].style.display = "Inline";
    		objs[beforetab].style.display = "none";

    		//--------------- 요기가 중요 --------------------------//
    		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    		//------------------------------------------------------//
    		beforetab		= nItem;
    		
	        var sheetObject 	= sheetObjects[0];
	        var sheetObject1 	= sheetObjects[1];
	        var sheetObject3 	= sheetObjects[3];
	                     
	        var formObj 		= document.form;
        
    		switch(nItem) {
    			case 0:
    				sheetObject.RemoveAll();
     				
	        		 if ( sheetObject.RowCount > 0 ){
	        		 }
    				formObj.f_acct_type_a.checked = true;
    				formObj.f_acct_type_m.checked = true; 
    				formObj.f_acct_type_a.disabled = false;
    				formObj.f_acct_type_m.disabled = false;    				
    				
    				doActionIBSheet(sheetObject,formObj,IBSEARCH);
    				
        	        /* GL_ACCL_IF Confirm 여부(ERP_IF_FLG = 'Y') 조회 */
        	        lea_getFlagValues(sheetObject3, formObj);
     				
     				//lea_retrieve(sheetObject, sheetObject1, formObject);
     				
//	        		 if ( sheetObject.RowCount > 0 ){
//	        		 }
//    				formObj.f_acct_type_a.checked = true;
//    				formObj.f_acct_type_m.checked = true; 
//    				formObj.f_acct_type_a.disabled = false;
//    				formObj.f_acct_type_m.disabled = false;
//        	  	    doActionIBSheet2(sheetObject1,formObj,IBSEARCH);
	        		 break;
    			case 1:
    				sheetObject1.RemoveAll();
//        	  doActionIBSheet(sheetObject,formObj,IBSEARCH);
    				doActionIBSheet2(sheetObject1,formObj,IBSEARCH);
    				formObj.f_acct_type_a.checked = false;
    				formObj.f_acct_type_m.checked = false;
    				formObj.f_acct_type_a.disabled = true;
    				formObj.f_acct_type_m.disabled = true;
    			break;
    		}
    	

    	}
      /*
       * Sheet Search 끝난후 발생하는 Event처리 함수
       */

    	function sheet1_OnSearchEnd(sheetObj,ErrMsg)
    	{
    		
    		
    		if ( sheetObj.RowCount > 0 ){
    			for(var i=sheetObj.HeaderRows ; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
    				 if(sheetObj.CellValue(i,"accl_auto_cd") != "A"){
    				 		sheetObj.CellFontColor(i,"diff_act_cost_amt") = sheetObj.DataBackColor; 
    				 		sheetObj.CellFontColor(i,"act_cost_ratio"		) = sheetObj.DataBackColor; 
    				}
    			}
    			
    		}
    		
    		
    		// 서식포맷과 데이터포맷을 따로 적용해서 데이터포맷으로 sum할수잇는 기능추가 예정(2007.3월 말경)
//    		sheetObj.SubSumBackColor = sheetObj.RgbColor(232,255,198);
//    		sheetObj.ShowSubSum( "rev_yrmon"   , "6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22", -1, true, false , 1 ,"1=%s;2=%s;3=Sub Total");
//    		sheetObj.SubSumBackColor = sheetObj.RgbColor(247,231,236);
//    		sheetObj.ShowSubSum( "accl_auto_cd", "6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22", -1, true, false , 1 ,"1=%s;2=%s;3=%s;4=Sub Total");

    	   sheetObj.SumText(0,2) = "Grand Total" ;
    	  // sheetObj.SumBackColor  	= sheetObj.RgbColor(236,231,247);
    		 sheetObj.SumFontBold 		= true;
        
          var subSumRows = sheetObj.FindSubSumRow("rev_yrmon")+sheetObj.FindSubSumRow("accl_auto_cd");
          var arrRow = subSumRows.split("|");
      		for (var i=0; i<arrRow.length-1; i++){ 
      			if(sheetObj.CellValue(arrRow[i],"estm_cost_amt") == 0){
      				sheetObj.CellValue(arrRow[i],"act_cost_ratio") = 0;
      			}else{
      				sheetObj.CellValue(arrRow[i],"act_cost_ratio") = sheetObj.CellValue(arrRow[i],"pst_act_cost_amt")/ sheetObj.CellValue(arrRow[i],"estm_cost_amt")*100;
      			 }
      		}

      		if(sheetObj.SumValue(0,"estm_cost_amt") == 0)
    				sheetObj.SumValue(0,"act_cost_ratio") = 0;
    			else
    				sheetObj.SumValue(0,"act_cost_ratio") = sheetObj.SumValue(0,"pst_act_cost_amt")/ sheetObj.SumValue(0,"estm_cost_amt")*100;
         

    	}


      /*
       * Sheet Save 끝난후 발생하는 Event처리 함수
       */
    	
    	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    		if (ErrMsg == "") {
    			
    			ComShowMessage(ComGetMsg("LEA90010"));
 
    		} else {
    			ComShowMessage(ComGetMsg("LEA90009"));
    			return;
    		}
    	}
    	
      	function sheet2_OnSaveEnd(sheet2, ErrMsg) {
             var sheetObject1 = sheetObjects[1];
             var formObject = document.form;
             
             if (ErrMsg == null || ErrMsg == "")	ComShowMessage(ComGetMsg("LEA90026"));
             
//    		if (ErrMsg == null || ErrMsg == ""){
    			sheet2.RemoveAll();
    			doActionIBSheet2(sheet2,formObject,IBSEARCH);
//    		}

    		lea_getFlagValues(sheetObj, formObj)
    		
    	}

    	/**
    	 * 해당 Sheet OnScroll Event발생시 실행하는 함수.
    	 *
    	 */
    	 function sheet1_OnScroll(sheet1, oldTopRow, oldLeftCol, newTopRow, newLeftCol){
    	 	 if (oldTopRow != newTopRow ) {
    	 	 		sheet1.SelectRow = newTopRow;
    	 	 }
    	 	
    	}
    	/**
    	 * 해당 Sheet OnDblClick Event발생시 실행하는 함수.
    	 *
    	 */
    	function sheet1_OnDblClick(sheet1,row, col){
    		if(!lea_com_isSubSumRow(sheet1, row)){
    			 var url_str = "ESD_LEA_0004.do";
    			 		url_str += "?exe_yrmon="	+ lea_com_convertYymm2(sheet1.CellValue(row, "exe_yrmon"));
    			 		url_str += "&rev_yrmon="	+ lea_com_convertYymm2(sheet1.CellValue(row, "rev_yrmon"));
    			 		url_str += "&acct_cd="		+ sheet1.CellValue(row, "acct_cd");
    					url_str += "&open_div=POP";
    			 window.showModalDialog(url_str, window, "dialogWidth:1010px; dialogHeight:710px; help:no; status:no; resizable:yes;");
    					//ComOpenWindow(url_str, "byBooking", "statebar = no , width= 1000 , height=700" );
    		}
    	}
    	/**
    	 * 해당 Sheet change Event발생시 실행하는 함수.
    	 *
    	 */
    	function sheet1_OnMouseMove(sheetObj,buttonValue, shiftValue, x_pos, y_pos)
    	{ 
         
          //마우스 모양 설정하기
          if (sheetObj.MouseCol == 5){
           	  sText = sheetObj.CellText(sheetObj.MouseRow,sheetObj.MouseCol);
              //풍선도움말 만들기
          		sheetObj.ToolTipText(sheetObj.MouseRow,sheetObj.MouseCol)  = sText;
          }

      }	
    	/**
    	 * 해당 Sheet change Event발생시 실행하는 함수.
    	 *
    	 */

    	function sheet2_OnChange(sheet2,row, col){
    			
			var formObj = document.form;
			
			if (sheet2.ColSaveName(col) == "estm_cost_amt_a" ){
				if ( sheet2.CellValue(row, "exe_yrmon").substr(4,2) - sheet2.CellValue(row, "rev_yrmon").substr(4,2) >= 5){
					sheet2.CellValue(row,"accl_cost_amt_a" ) = 0;
				}else if ( Math.abs(sheet2.CellValue(row, "estm_cost_amt_a" )) - Math.abs(sheet2.CellValue(row, "act_cost_amt_a" )) <=0 ){
					sheet2.CellValue(row,"accl_cost_amt_a" ) = 0;
				}else {
					sheet2.CellValue(row,"accl_cost_amt_a" ) = sheet2.CellValue(row, "estm_cost_amt_a" ) - sheet2.CellValue(row, "act_cost_amt_a" );
				}
			}
			
			if (sheet2.ColSaveName(col) == "estm_cost_amt_d" ){ 
				if ( sheet2.CellValue(row, "exe_yrmon").substr(4,2) - sheet2.CellValue(row, "rev_yrmon").substr(4,2) >= 5){
					sheet2.CellValue(row,"accl_cost_amt_d" ) = 0;
				}else if ( Math.abs(sheet2.CellValue(row, "estm_cost_amt_d" )) - Math.abs(sheet2.CellValue(row, "act_cost_amt_d" )) <=0 ){
					sheet2.CellValue(row,"accl_cost_amt_d" ) = 0;
				}else {
					sheet2.CellValue(row,"accl_cost_amt_d" ) = sheet2.CellValue(row, "estm_cost_amt_d" ) - sheet2.CellValue(row, "act_cost_amt_d" );
				}
			}
			
			//EMPTY VOL. INCENTIVE 2011년이전 수정불가, 2012년이후 ACCL 재계산 START//
			//2012년이후 EMPTY VOLUME INCENTIVE에 대해서 12개월 ACCRUAL COST 제거처리로 로직변경함 :: 2012-09-17//
			if (sheet2.ColSaveName(col) == "estm_cost_amt_aa" ){
					
				//EMPTY VOL. INCENTIVE에 대한 ACCRUAL COST ZERO처리 12개월로 변경함.
				if ( Math.abs(sheet2.CellValue(row, "estm_cost_amt_aa" )) - Math.abs(sheet2.CellValue(row, "act_cost_amt_aa" )) <=0 ){
					sheet2.CellValue(row,"accl_cost_amt_aa" ) = 0;
				}else {
					sheet2.CellValue(row,"accl_cost_amt_aa" ) = sheet2.CellValue(row, "estm_cost_amt_aa" ) - sheet2.CellValue(row, "act_cost_amt_aa" );
				}
					
			}
			
			if (sheet2.ColSaveName(col) == "estm_cost_amt_dd" ){ 
				//2012년이후 EMPTY VOLUME INCENTIVE에 대해서 12개월 ACCRUAL COST 제거처리로 로직변경함 :: 2012-09-21//
				if ( Math.abs(sheet2.CellValue(row, "estm_cost_amt_dd" )) - Math.abs(sheet2.CellValue(row, "act_cost_amt_dd" )) <=0 ){
					sheet2.CellValue(row,"accl_cost_amt_dd" ) = 0;
				}else {
					sheet2.CellValue(row,"accl_cost_amt_dd" ) = sheet2.CellValue(row, "estm_cost_amt_dd" ) - sheet2.CellValue(row, "act_cost_amt_dd" );
				}
			}	
			//EMPTY VOL. INCENTIVE 2011년이전 수정불가, 2012년이후 ACCL 재계산 END//
			
		
	//    			if (sheet2.ColSaveName(col) == "estm_cost_amt_j" ){ 
	//    				sheet2.CellValue(row,"act_cost_amt_j" ) = sheet2.CellValue(row, "estm_cost_amt_j");
	//    			}
	//    			
	//    			if (sheet2.ColSaveName(col) == "estm_cost_amt_k" ){ 
	//    				sheet2.CellValue(row,"act_cost_amt_k" ) = sheet2.CellValue(row, "estm_cost_amt_k");
	//    			}
      }
      
       /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
//                if (!isNumber(iPage)) {
    //
//                    return false;
//                }
            }

            return true;
        }
       /**
         * 조회 프로세스 처리
         */
        
        function lea_retrieve(sheetObject, sheetObject1, formObject){
        	
        	sheetObject.RemoveAll();
     		sheetObject1.RemoveAll();
     		
     		doActionIBSheet	(sheetObject , formObject, IBSEARCH);
        	doActionIBSheet2(sheetObject1, formObject, IBSEARCH);
        }
        
       /**
         * EnterKey Event 조회 프로세스 처리
         */
    		function lea_enterRetrieve(){
             var sheetObject 	= sheetObjects[0];
             var sheetObject1 	= sheetObjects[1];
             var formObject 	= document.form;
    			
     		lea_retrieve(sheetObject, sheetObject1, formObject);
    			
    		}
    		
       /**
         * Form Data를Sheet로 Copy 프로세스 처리
         */
    		function lea_form2sheet(formObj,sheetObj){
    			sheetObj.RemoveAll();
    			var Row = sheetObj.DataInsert(-1);
    			sheetObj.CellValue(Row, "exe_yrmon" 	) = formObj.frm_exe_yrmon.value		;
    			sheetObj.CellValue(Row, "rev_yrmon_from") = formObj.frm_rev_yrmon_from.value;
    			sheetObj.CellValue(Row, "rev_yrmon_to"  ) = formObj.frm_rev_yrmon_to.value	;
    		}
    	/*
    	 * Flag 값을가져오는 프로세스
    	*/
    	function lea_getFlagValues(sheetObj, formObj){
    		sheetObj.RemoveAll();// 2011.05.27 기존값이 그대로 남아 있어서 주석품
    	
    		doActionIBSheet2_etc(sheetObj, formObj, IBSEARCH_ASYNC01);
    		
    		var row	 = 1;
    		//js function name change : removeSpaces ==>> ComTrimAll
    		formObj.frm_mnl_inp_flg .value = ComTrimAll(sheetObj.CellValue(row, "mnl_inp_flg"	));
    		formObj.frm_erp_if_flg  .value = ComTrimAll(sheetObj.CellValue(row, "erp_if_flg"	));
    		formObj.erp_if_dt       .value = ComTrimAll(sheetObj.CellValue(row, "erp_if_dt"		));
    		formObj.frm_cond_cfm_flg.value = ComTrimAll(sheetObj.CellValue(row, "cond_cfm_flg"	));
    		
    		/* GL_ACCL_IF Confirm여부에 따른 UI에 Text 처리 */
    		if(formObj.frm_erp_if_flg.value == 'Y'){	
    			formObj.gl_accl_if_confirm_text.value	= 'Manual Input is confirmed.';
    			formObj.gl_accl_if_confirm_text2.value	= 'Manual Input is confirmed.';
    			ComBtnDisable("t1btng_confirm");
    			ComBtnDisable("t2btng_save");
    			
    		}else{										
    			formObj.gl_accl_if_confirm_text.value	= '';								
    			formObj.gl_accl_if_confirm_text2.value	= '';
    		}
    	}
    	
    	//original
//    	function lea_getFlagValues(sheetObj, formObj){
//    		doActionIBSheet2_etc(sheetObj, formObj, IBSEARCH_ASYNC01);
//    		
//    		alert('lea_getFlagValues');
//    		alert(sheetObj.EtcData("flagCd"));
//    		
//    		var flagArray = (sheetObj.EtcData("flagCd") != null)? sheetObj.EtcData("flagCd").split("|") :"";
//    			formObj.frm_mnl_inp_flg .value = removeSpaces(flagArray[0]);
//    			formObj.frm_erp_if_flg  .value = removeSpaces(flagArray[1]);
//    			formObj.erp_if_dt       .value = removeSpaces(flagArray[2]);
//    			formObj.frm_cond_cfm_flg.value = removeSpaces(flagArray[3]);
    //
//    	}	
    	
    	/*
    	 * Accrual Type check 값을 Cookie에 Set 프로세스
    	*/
    	
   	function lea_setCookieAcclType(){
//    		setCookie("form_lea_accl_type_a",(document.form.f_acct_type_a.checked == true ?"1":"0"));
//    		setCookie("form_lea_accl_type_m",(document.form.f_acct_type_m.checked == true ?"1":"0"));
//    		setCookie("form_lea_accl_type_t",(document.form.f_acct_type_t.checked == true ?"1":"0"));
          
    		document.form.f_acct_type_a.value = (document.form.f_acct_type_a.checked == true ?"1":"0");
    		document.form.f_acct_type_m.value = (document.form.f_acct_type_m.checked == true ?"1":"0");
    		//document.form.f_acct_type_t.value = (document.form.f_acct_type_t.checked == true ?"1":"0");   
    	}
    	
    	/*
    	 * frm_rev_yrmon_to 값을 setting.
    	*/
    	function lea_setRevToYymm(obj1,obj2){
    		if (event.keyCode == 13){
    			lea_com_setRevToYymm(obj1,obj2)
    		}
    	}

	/* 개발자 작업  끝 */