/*===================================================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0002.js
*@FileTitle : Accrual Result by Account Code (Tab1)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
===================================================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /**
     * @extends 
     * @class ESD_LEA_0002 : business script for ESD_LEA_0002
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
    

    // The common global variables
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

    /* Event handler processing by button click event */
    document.onclick = processButtonClick;

    /* Event handler processing by button name */
        function processButtonClick(){
             
             var sheetObject 	= sheetObjects[0];
             var sheetObject1 	= sheetObjects[1];
             var sheetObject2 	= sheetObjects[2];
             var sheetObject3 	= sheetObjects[3];

             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

            	    case "btn_retrieve":
            	        lea_retrieve(sheetObject, sheetObject1, formObject);
    					break;

            	   
            	    case "t1btng_detailbybooking":
            	    	
            	    	if ( sheetObject.RowCount < 1 ){
            	    		ComShowMessage(ComGetMsg("LEA90008"));
            	    		return false;
            	    	}
            	    	if ( sheetObject.SelectRow < 0 ){
            	    		ComShowMessage(ComGetMsg("LEA90003"));
            	    		return false;
            	    	}
    					
            	    	var url_str = "ESD_LEA_0004.do"	;
    						url_str += "?exe_yrmon="	+ formObject.frm_exe_yrmon.value;
    						url_str += "&rev_yrmon=" + formObject.frm_exe_yrmon.value;
    						url_str += "&acct_cd="		+ sheetObject.CellValue(sheetObject.SelectRow, "acct_cd");
    						url_str += "&open_div=POP"	;
    					
    						window.showModalDialog(url_str, window, "dialogWidth:1040px; dialogHeight:500px; help:no; status:no; resizable:yes;");
    					break;

            	    case "t1btng_confirm":
            	    	if ( sheetObject.RowCount < 1 ){
            	    		ComShowMessage(ComGetMsg("LEA90008"));	//No data found.
            	    		return false;
            	    	}
            	       
            	    	lea_getFlagValues(sheetObject3, formObject);	
            	    	
            	    	
            	    	doActionIBSheet(sheetObject, formObject, IBSAVE);
            	        break;

            	
            	    case "t1btng_report":
            	    	if ( sheetObject.RowCount < 1 ){
            	    		ComShowMessage(ComGetMsg("LEA90008"));
            	    		return false;
            	    	}
            	    	
            	    	var url_str = "ESD_LEA_0006.do";
    						url_str += "?exe_yrmon="	+ formObject.frm_exe_yrmon.value;
    						url_str += "&revFromYYMM="	+ formObject.frm_rev_yrmon_from.value;
    						url_str += "&revToYYMM="	+ formObject.frm_rev_yrmon_to.value;
    						url_str += "&open_div=POP";
    					
    						window.showModalDialog(url_str, window, "dialogWidth:1020px; dialogHeight:450px; help:no; status:no; resizable:yes;");
    					break;

            	    case "t1btng_downexcel":
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
           	    		
           	    		break;

            	    case "t2btng_downexcel":
            	    	sheetObject1. ExcelOption= "NOCOLOR";
            	    	sheetObject1.SpeedDown2Excel(true);
            	    	sheetObject1. ExcelOption= "";   
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
         * Registering IBSheet Object as list
         * Adding process for list in case of needing batch processing with other items 
         * Defining list on the top of source
         */
        function setSheetObject(sheet_obj){

           sheetObjects[sheetCnt++] = sheet_obj;

        }

        /**
         * initializing sheet
         * implementing onLoad event handler in body tag
         * adding first-served functions after loading screen.
         */
        function loadPage() {
        	
            for(i=0;i<sheetObjects.length;i++){

            
                ComConfigSheet(sheetObjects[i]);

                initSheet(sheetObjects[i],i+1);            
                ComEndConfigSheet(sheetObjects[i]);
            }

    		for(k=0;k<tabObjects.length;k++){
    			initTab(tabObjects[k],k+1);
    		}
    		
    }

        /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj, sheetNo) {

            var cnt = 0;

            switch(sheetNo) {
                case 1:      //IBSheet1 init
                    with (sheetObj) {
                		//Setting width
                        SheetWidth = mainTable.clientWidth;

                        //Setting the Host information[Required][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //Kind of merge [Optional, Default msNone]
                        MergeSheet = msHeaderOnly;

                        //Edit kind [Optional, Default false]
                        Editable = true;

                      //Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 9, 100);

                      //Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(17, 3, 0, true);

                     // Setting function handling header
                        InitHeadMode(true, true, true, true, false,false)

                        var HeadTitle  = "STS|Exe.\nMonth|Rev.\nMonth|Accrual\nType|Account\nCode|Account Name|Estimated\nCost|Actual Cost|Actual Cost|Actual Cost|Actual Cost|Accrual\nCost |Confirmed\nCost|Cost Diff.||" ;
                        var HeadTitle1 = "STS|Exe.\nMonth|Rev.\nMonth|Accrual\nType|Account\nCode|Account Name|Estimated\nCost|Pre-\nAllocted|Post-\nAllocated|Diff.|Actual\nRatio (%)|Accrual\nCost |Confirmed\nCost|Cost Diff.||" ;

                      //Setting the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);
                        InitHeadRow(1, HeadTitle1, true);

                      //Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++,  dtHiddenStatus ,    	 30,    daCenter,  true,    "ibflag");
    					InitDataProperty(0, cnt++ , dtHidden ,       80,    daCenter,  true ,    "exe_yrmon"          ,        false,          "",       dfDateYm 	,   	0,     false,        false);                                              
    					InitDataProperty(0, cnt++ , dtData   ,       80,    daCenter,  true ,    "rev_yrmon"          ,        false,          "",       dfDateYm 	,   	0,     false,        false); 
    					InitDataProperty(0, cnt++ , dtCombo  ,      100,    daCenter,  true ,    "accl_auto_cd"       ,        false,          "",       dfNone   	,   	0,     false,        false);                                              
    					InitDataProperty(0, cnt++ , dtData   ,       60,    daCenter,  true ,    "acct_cd"            ,        false,          "",       dfNone   	,   	0,     false,        false);                                              
    					InitDataProperty(0, cnt++ , dtData   ,      250,    daCenter,  true ,    "acct_cd_nm"         ,        false,          "",       dfNone   	,   	0,     false,        false, -1, false,true, true);                                              
    					InitDataProperty(0, cnt++ , dtAutoSum,       80,    daRight ,  true ,    "estm_cost_amt"      ,        false,          "",       dfFloat,   	2,     false,        false);                                              
    					InitDataProperty(0, cnt++ , dtAutoSum,       80,    daRight ,  false,    "pre_act_cost_amt"   ,        false,          "",       dfFloat,   	2,     false,        false);                                              
    					InitDataProperty(0, cnt++ , dtAutoSum,       80,    daRight ,  false,    "pst_act_cost_amt"   ,        false,          "",       dfFloat,   	2,     false,        false);                                              
    					InitDataProperty(0, cnt++ , dtAutoSum,       80,    daRight ,  false,    "diff_act_cost_amt"  ,        false,          "",       dfFloat,   	2,     false,        false);        
    					InitDataProperty(0, cnt++ , dtData   ,       80,    daRight ,  false,    "act_cost_ratio"     ,        false,          "",       dfNullFloatOrg,   	1,     false,        false);       
    					InitDataProperty(0, cnt++ , dtAutoSum,       80,    daRight ,  true ,    "accl_cost_amt"      ,        false,          "",       dfFloat,   	2,     false,        false);                                              
    					InitDataProperty(0, cnt++ , dtAutoSum,       80,    daRight ,  true ,    "confirmed_cost_amt" ,        false,          "",       dfFloat,   	2,     false,        false);           
    					InitDataProperty(0, cnt++ , dtAutoSum,       80,    daRight ,  true ,    "diff_cost_amt"      ,        false,          "",       dfFloat,   	2,     false,        false); 
    					InitDataProperty(0, cnt++ , dtHidden ,       60,    daCenter,  false,    "mnl_inp_flg"        ,        false,          "",       dfNone   	,   	0,     false,        false);                                              
    					InitDataProperty(0, cnt++ , dtHidden ,       60,    daCenter,  false,    "erp_if_flg"         ,        false,          "",       dfNone   	,   	0,     false,        false);                                              
    					InitDataProperty(0, cnt++ , dtHidden ,       60,    daCenter,  false,    "erp_if_dt"          ,        false,          "",       dfNone   	,   	0,     false,        false);                                              
    					
    					InitDataCombo(0 , "accl_auto_cd"	, "Auto Accrual|Manual Accrual|Transfer", "A|M|T");
    										
                        RangeBackColor(1, 7, 1, 10) = RgbColor(222, 251, 248);   // ENIS
                        style.height = GetSheetHeight(13) ;
                   }
                    break;
                case 2:      //IBSheet2 init
                    with (sheetObj) {
                		//Setting width
                        SheetWidth = mainTable.clientWidth;

                      //Setting the Host information[Required][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                      //Kind of merge [Optional, Default msNone]
                        MergeSheet = msHeaderOnly;

                      //Edit kind [Optional, Default false]
                        Editable = true;

                      //Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 9, 100);

                      //Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(43, 3, 0, true);

                     // Setting function handling header
                        InitHeadMode(true, true, true, true, false, false)

                        var HeadTitle   = "STS|Exe.\nMonth|Rev.\nMonth|Volume Discount & Incentive-\nTerminal (512073)|Volume Discount & Incentive-\nTerminal (512073)|Volume Discount & Incentive-\nTerminal (512073)|Volume Discount & Incentive-\nTerminal (512073)|";
    	            		HeadTitle  += "Other Carrier's Terminal Cost\n(512019)|Other Carrier's Terminal Cost\n(512019)|Other Carrier's Terminal Cost\n(512019)|Other Carrier's Terminal Cost\n(512019)|";
    	            		HeadTitle  += "US Domestic Rail Cost\n(512351)|US Domestic Rail Cost\n(512351)|US Domestic Rail Cost\n(512351)|US Domestic Rail Cost\n(512351)|";
    	            		HeadTitle  += "Volume Discount & Incentive-\nTranspotation (512361)|Volume Discount & Incentive-\nTranspotation (512361)|Volume Discount & Incentive-\nTranspotation (512361)|Volume Discount & Incentive-\nTranspotation (512361)|";
    	            		HeadTitle  += "Empty RePosition Stevedorage\n(512061)|Empty RePosition Stevedorage\n(512061)|Empty RePosition Stevedorage\n(512061)|Empty RePosition Stevedorage\n(512061)|";
    	            		HeadTitle  += "Empty RePosition Terminal Handling\n(512151)|Empty RePosition Terminal Handling\n(512151)|Empty RePosition Terminal Handling\n(512151)|Empty RePosition Terminal Handling\n(512151)|";
    	            		HeadTitle  += "Empty RePosition Storage\n(512221)|Empty RePosition Storage\n(512221)|Empty RePosition Storage\n(512221)|Empty RePosition Storage\n(512221)|";
    	            		HeadTitle  += "Empty RePosition Transportation\n(512341)|Empty RePosition Transportation\n(512341)|Empty RePosition Transportation\n(512341)|Empty RePosition Transportation\n(512341)|";
    	            		HeadTitle  += "3rd Party Billing Stevedorage\n(512181)|3rd Party Billing Stevedorage\n(512181)|3rd Party Billing Stevedorage\n(512181)|3rd Party Billing Stevedorage\n(512181)|";
    	            		HeadTitle  += "3rd Party Billing Transportation\n(512381)|3rd Party Billing Transportation\n(512381)|3rd Party Billing Transportation\n(512381)|3rd Party Billing Transportation\n(512381)|";
                        var HeadTitle1  = "STS|Exe.\nMonth|Rev.\nMonth|";
    	             		HeadTitle1 += "|Estimated\nCost|Actual\nCost|Accrual\nCost||Estimated\nCost|Actual\nCost|Accrual\nCost|";
    	             		HeadTitle1 += "|Estimated\nCost|Actual\nCost|Accrual\nCost||Estimated\nCost|Actual\nCost|Accrual\nCost|";
    	             		HeadTitle1 += "|Estimated\nCost|Actual\nCost|Accrual\nCost||Estimated\nCost|Actual\nCost|Accrual\nCost|";
    	             		HeadTitle1 += "|Estimated\nCost|Actual\nCost|Accrual\nCost||Estimated\nCost|Actual\nCost|Accrual\nCost|";
    	             		HeadTitle1 += "|Estimated\nCost|Actual\nCost|Accrual\nCost||Estimated\nCost|Actual\nCost|Accrual\nCost|";
                         		

    	             	//Setting the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);
                        InitHeadRow(1, HeadTitle1, true);

                        //Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++,  dtHiddenStatus,    	  30,    daCenter,  true ,    "ibflag");
    					InitDataProperty(0, cnt++ , dtHidden,       65,    daCenter,  true ,    "exe_yrmon"		  ,        false,          "",       dfDateYm 	,   	0,     false,        false); 																															
    					InitDataProperty(0, cnt++ , dtData  ,       65,    daCenter,  true ,    "rev_yrmon"       ,        false,          "",       dfDateYm  	,   	0,     false,        false);                                                              
    					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true ,    "ibflag_a"        ,        false,          "",       dfNone   	,   	0,     false,        false );                                                              
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "estm_cost_amt_a" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "act_cost_amt_a"  ,        false,          "",       dfNullFloat,   	2,     false,        false , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "accl_cost_amt_a" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true ,    "ibflag_b"        ,        false,          "",       dfNone   	,   	0,     false,        false );                                                              
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "estm_cost_amt_b" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "act_cost_amt_b"  ,        false,          "",       dfNullFloat,   	2,     false,        false , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "accl_cost_amt_b" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true ,    "ibflag_c"        ,        false,          "",       dfNone   	,   	0,     false,        false );                                                              
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "estm_cost_amt_c" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "act_cost_amt_c"  ,        false,          "",       dfNullFloat,   	2,     false,        false , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "accl_cost_amt_c" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true ,    "ibflag_d"        ,        false,          "",       dfNone   	,   	0,     false,        false );                                                              
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "estm_cost_amt_d" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "act_cost_amt_d"  ,        false,          "",       dfNullFloat,   	2,     false,        false , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "accl_cost_amt_d" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);
    					
    					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true ,    "ibflag_f"        ,        false,          "",       dfNone   	,   	0,     false,        false );                                                              
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "estm_cost_amt_f" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "act_cost_amt_f"  ,        false,          "",       dfNullFloat,   	2,     false,        false , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "accl_cost_amt_f" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);			
    					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true ,    "ibflag_g"        ,        false,          "",       dfNone   	,   	0,     false,        false );                                                              
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "estm_cost_amt_g" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "act_cost_amt_g"  ,        false,          "",       dfNullFloat,   	2,     false,        false , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "accl_cost_amt_g" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14); 
    					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true ,    "ibflag_h"        ,        false,          "",       dfNone   	,   	0,     false,        false );                                                              
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "estm_cost_amt_h" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "act_cost_amt_h"  ,        false,          "",       dfNullFloat,   	2,     false,        false , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "accl_cost_amt_h" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14); 
    					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true ,    "ibflag_i"        ,        false,          "",       dfNone   	,   	0,     false,        false );                                                              
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "estm_cost_amt_i" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "act_cost_amt_i"  ,        false,          "",       dfNullFloat,   	2,     false,        false , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "accl_cost_amt_i" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14); 
    					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true ,    "ibflag_j"        ,        false,          "",       dfNone   	,   	0,     false,        false );                                                              
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "estm_cost_amt_j" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "act_cost_amt_j"  ,        false,          "",       dfNullFloat,   	2,     false,        false , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "accl_cost_amt_j" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14); 
    					InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true ,    "ibflag_k"        ,        false,          "",       dfNone   	,   	0,     false,        false );                                                              
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "estm_cost_amt_k" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "act_cost_amt_k"  ,        false,          "",       dfNullFloat,   	2,     false,        false , 14);                 
    					InitDataProperty(0, cnt++ , dtData  ,       95,    daRight ,  false,    "accl_cost_amt_k" ,        false,          "",       dfNullFloat,   	2,     true ,        true  , 14); 
    					
                                                               
                        RangeBackColor(1,3, 1, 42) = RgbColor(222, 251, 248);   // ENIS
                        style.height = GetSheetHeight(13) ;
                   }
                    break;
                    
                case 3:      //IBSheet2 init
                    with (sheetObj) {
                		//Setting width
                        SheetWidth = mainTable.clientWidth;

                      //Setting the Host information[Required][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                      //Kind of merge [Optional, Default msNone]
                        MergeSheet = msHeaderOnly;

                      //Edit kind [Optional, Default false]
                        Editable = true;

                      //Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 9, 100);

                      //Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(3, 0, 0, true);

                     // Setting function handling header
                        InitHeadMode(true, true, true, true, false,false)

                        var HeadTitle   = "Exe.\nYear-Month|Rev.Year-Month|Rev.Year-Month";
                        var HeadTitle1  = "Exe.\nYear-Month|From|To";

                      //Setting the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);
                        InitHeadRow(1, HeadTitle1, true);

                      //Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
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
                		//Setting width
                        SheetWidth = mainTable.clientWidth;

                      //Setting the Host information[Required][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                      //Kind of merge [Optional, Default msNone]
                        MergeSheet = msHeaderOnly;

                      //Edit kind [Optional, Default false]
                        Editable = true;

                      //Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 1, 1, 9, 100);

                      //Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(4, 0, 0, true);

                     // Setting function handling header
                        InitHeadMode(true, true, true, true, false, false)

                        var HeadTitle   = "mnl_inp_flg|erp_if_flg|erp_if_dt|cond_cfm_flg";

                      //Setting the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);

                      //Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
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

        /**
    	 * Handling the process about the sheet -Sheet1
    	 */ 
        function doActionIBSheet(sheetObj, formObj, sAction) {
            sheetObj.ShowDebugMsg = false;

            switch(sAction) {

            	case IBSEARCH:      //Retrieving 
            		formObj.f_cmd.value = SEARCH;
            		
            		var searchXml 		= sheetObj.GetSearchXml("ESD_LEA_0002GS.do", leaFormQueryString(formObj));
            		
            		if(searchXml != "") sheetObj.LoadSearchXml(searchXml, false);
            		break;
            		
            	case IBSAVE:        //Saving
            		
    				formObj.frm_confirm_div.value 	= "E";
    				formObj.f_cmd.value 			= MODIFY;
    				var param 	= sheetObj.GetSaveString(true);
    				
    				var savexml = sheetObj.GetSaveXml("ESD_LEA_0002GS.do", param+'&' + leaFormQueryString(formObj));
    				
    				if (savexml != "") sheetObj.LoadSaveXml(savexml, true);
    				break;
    				
                				
            	case IBDOWNEXCEL:        // excel down
            		sheetObj.Down2Excel(-1,false,false,true,"","",false,false, "Accrual Batch Result by Account Code",true);
            		break;
            }
        }
        /**
    	 * Handling the process about the sheet -Sheet2
    	 */
        function doActionIBSheet2(sheetObj, formObj, sAction) {
            sheetObj.ShowDebugMsg = false;

            switch(sAction) {

    			case IBSEARCH:      //Retrieving
    			   	formObj.f_cmd.value = SEARCH01;
    			   	
    			   	var searchXml 		= sheetObj.GetSearchXml("ESD_LEA_0002GS.do", leaFormQueryString(formObj));
    			   	
    				if(searchXml != "") sheetObj.LoadSearchXml(searchXml,false);
                    break;
    				
    			case IBSAVE:        //Saving
    				formObj.frm_confirm_div.value 	= "M";
    				formObj.f_cmd.value 			= MULTI;
    				var param 	= sheetObj.GetSaveString(true);
    				
    				
    				var savexml = sheetObj.GetSaveXml("ESD_LEA_0002GS.do", param+'&'+ leaFormQueryString(formObj));
    				
    				if (savexml != "") sheetObj.LoadSaveXml(savexml,true);
    				
    				break;
    			
    			case IBDOWNEXCEL:        // excel down
    				sheetObj.Down2Excel(-1,false,false,true,"","",false,false, "Manual Input",true);
    				break;
            }
        }

      /**
       * Handling the process about the sheet -Sheet2
       */
      function doActionIBSheet2_etc(sheetObj,formObj,sAction) {
    	  
      	switch(sAction) {
      		case IBSEARCH_ASYNC01:      //Retrieving
      			formObj.f_cmd.value = SEARCH02;

      		    var searchXml		= sheetObj.GetSearchXml("ESD_LEA_0002GS.do", leaFormQueryString(formObj));

      		    if(searchXml != "") sheetObj.LoadSearchXml(searchXml, true);
      			
      			break;
      		}
      }
       /**
      	* Registering IBTab Object as list
      	* adding process for list in case of needing batch processing with other items 
      	* defining list on the top of source
      	*/
    	function setTabObject(tab_obj){
    		tabObjects[tabCnt++] = tab_obj;
    	}


       /**
        * initializing Tab
        * setting Tab items
        */
    	function initTab(tabObj , tabNo) {

    		 switch(tabNo) {
    		 case 1:
    				with (tabObj) {
    					var cnt  = 0 ;
    					InsertTab( cnt++, "Result by Account Code" , -1 );
    					InsertTab( cnt++, "Manual Input" , -1 );

    				}
    			 break;

    		}
    	}

       /**
        * Event when clicking Tab
        * activating selected tab items
        */
    	function tab1_OnChange(tabObj , nItem)
    	{


    		var objs = document.all.item("tabLayer");

    		objs[nItem].style.display = "Inline";
    		objs[beforetab].style.display = "none";

    		
    		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    		
    		beforetab= nItem;
    		
        var sheetObject = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        var formObj = document.form;
    		switch(nItem) {
    			case 0:
    				sheetObject.RemoveAll();
     				doActionIBSheet(sheetObject,formObj,IBSEARCH);
        		 if ( sheetObject.RowCount > 0 ){
        		}
    			break;
    			case 1:
    				sheetObject1.RemoveAll();
        	  doActionIBSheet2(sheetObject1,formObj,IBSEARCH);
    			break;
    		}
    	

    	}
      /**
       * Calling this function after retrieving Sheet1.
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
    		
    		
    	   sheetObj.SumText(0,2) = "Grand Total" ;
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


    	/**
         * Handling this event after saving Sheet1.
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
			sheet2.RemoveAll();
			doActionIBSheet2(sheet2,formObject,IBSEARCH);
    	}

      	/**
         * Calling this function after scrolling Sheet1.
         */
    	 function sheet1_OnScroll(sheet1, oldTopRow, oldLeftCol, newTopRow, newLeftCol){
    	 	 if (oldTopRow != newTopRow ) {
    	 	 		sheet1.SelectRow = newTopRow;
    	 	 }
    	 	
    	}
    	
    	 /**
          * Handling this event after double-clicking Sheet1.
          */
    	function sheet1_OnDblClick(sheet1,row, col){
    		if(!lea_com_isSubSumRow(sheet1, row)){
    			 var url_str = "ESD_LEA_0004.do";
    			 		url_str += "?exe_yrmon="	+ lea_com_convertYymm2(sheet1.CellValue(row, "exe_yrmon"));
    			 		url_str += "&rev_yrmon="	+ lea_com_convertYymm2(sheet1.CellValue(row, "rev_yrmon"));
    			 		url_str += "&acct_cd="		+ sheet1.CellValue(row, "acct_cd");
    					url_str += "&open_div=POP";
    			 window.showModalDialog(url_str, window, "dialogWidth:1010px; dialogHeight:710px; help:no; status:no; resizable:yes;");
    		}
    	}
    	
    	/**
         * Calling this function after double-clicking Sheet1.
         */
    	function sheet1_OnMouseMove(sheetObj,buttonValue, shiftValue, x_pos, y_pos)
    	{ 
         
          //Setting the cursor
          if (sheetObj.MouseCol == 5){
           	  sText = sheetObj.CellText(sheetObj.MouseRow,sheetObj.MouseCol);
              //Making the ballon help.
          		sheetObj.ToolTipText(sheetObj.MouseRow,sheetObj.MouseCol)  = sText;
          }

      }	
    	/**
    	 * 
    	 * Calling this function when one sheet occurs the change event.
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
    		
    			if (sheet2.ColSaveName(col) == "estm_cost_amt_j" ){ 
    				sheet2.CellValue(row,"act_cost_amt_j" ) = sheet2.CellValue(row, "estm_cost_amt_j");
    			}
    			
    			if (sheet2.ColSaveName(col) == "estm_cost_amt_k" ){ 
    				sheet2.CellValue(row,"act_cost_amt_k" ) = sheet2.CellValue(row, "estm_cost_amt_k");
    			}
      }
      
       /**
         * Handling the process for the input validation
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
            	
            }

            return true;
        }
       /**
         * Handling the retrieving process
         */
        
        function lea_retrieve(sheetObject, sheetObject1, formObject){
        	
        	sheetObject.RemoveAll();
     		sheetObject1.RemoveAll();
        	
     		doActionIBSheet	(sheetObject , formObject, IBSEARCH);
        	doActionIBSheet2(sheetObject1, formObject, IBSEARCH);
        }
        
        /**
         * Handling the retrieving process when pressed Enter key Event
         */
    		function lea_enterRetrieve(){
             var sheetObject 	= sheetObjects[0];
             var sheetObject1 	= sheetObjects[1];
             var formObject 	= document.form;
    			
     		lea_retrieve(sheetObject, sheetObject1, formObject);
    			
    		}
    		
        /**
         * Copying the form data to sheet one
         */
    		function lea_form2sheet(formObj,sheetObj){
    			sheetObj.RemoveAll();
    			var Row = sheetObj.DataInsert(-1);
    			sheetObj.CellValue(Row, "exe_yrmon" 	) = formObj.frm_exe_yrmon.value		;
    			sheetObj.CellValue(Row, "rev_yrmon_from") = formObj.frm_rev_yrmon_from.value;
    			sheetObj.CellValue(Row, "rev_yrmon_to"  ) = formObj.frm_rev_yrmon_to.value	;
    		}
    	/*
    	 * The process which gets the flag
    	 */
    	function lea_getFlagValues(sheetObj, formObj){
    	
    		doActionIBSheet2_etc(sheetObj, formObj, IBSEARCH_ASYNC01);
    		
    		var row	 = 1;
    		
    		formObj.frm_mnl_inp_flg .value = ComTrimAll(sheetObj.CellValue(row, "mnl_inp_flg"	));
    		formObj.frm_erp_if_flg  .value = ComTrimAll(sheetObj.CellValue(row, "erp_if_flg"	));
    		formObj.erp_if_dt       .value = ComTrimAll(sheetObj.CellValue(row, "erp_if_dt"		));
    		formObj.frm_cond_cfm_flg.value = ComTrimAll(sheetObj.CellValue(row, "cond_cfm_flg"	));

    	}
    	
    	/*
    	 * Setting Accrual Type check to cookie
    	 */
    	function lea_setCookieAcclType(){
          
    		document.form.f_acct_type_a.value = (document.form.f_acct_type_a.checked == true ?"1":"0");
    		document.form.f_acct_type_m.value = (document.form.f_acct_type_m.checked == true ?"1":"0");
    		document.form.f_acct_type_t.value = (document.form.f_acct_type_t.checked == true ?"1":"0");   
    	}
    	
    	/*
    	 * Setting frm_rev_yrmon_to value.
    	*/
    	function lea_setRevToYymm(obj1,obj2){
    		if (event.keyCode == 13){
    			lea_com_setRevToYymm(obj1,obj2)
    		}
    	}
