/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0014.js
*@FileTitle : Expense Report by Office
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

   /**
     * @fileoverview 
     * @author 
     */

    /**
     * @extends 
     * @class ESD_LEA_0014 : business script for ESD_LEA_0014
     */
    function ESD_LEA_0014() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
    
    /* Common global variables */
    var sheetObjects = new Array();
    var sheetCnt = 0;

    /* Event handler processing by button click event */
    document.onclick = processButtonClick;

    	/* Event handler processing by button name */
    	function processButtonClick(){
    	
    	    var sheetObject = sheetObjects[0];
    	
    	    var formObject = document.form;
    	
    		try {
    			var srcName = window.event.srcElement.getAttribute("name");
    	
    	       switch(srcName) {
    	
    	   	    case "btn_retrieve":
    	   	        sheetObject.RemoveAll();
    	    		doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	            break;
    	
    	   	    case "btng_downexcel":
    				//lea_form2sheet(formObject,sheetObject);
    				//sheetObject1.Down2Excel(-1,false,false,true,"","",false,false, "",true);
    				//sheetObject .Down2Excel(-1,true,false,true,"","",false,false, "",true);
    		        //doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
        	    	sheetObject. ExcelOption= "NOCOLOR";
        	    	sheetObject.SpeedDown2Excel(true);
        	    	sheetObject. ExcelOption= "";   
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
         * Setting IBSheet Object as array
         * adding process for list in case of needing batch processing with other items 
         * defining list on the top of source
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

            	//Modifying the name of the starting environment setting function
            	ComConfigSheet(sheetObjects[i]);

                initSheet(sheetObjects[i],i+1);
                
                //Adding to setting last environment function 
                ComEndConfigSheet(sheetObjects[i]);
            }
             var sheetObject = sheetObjects[0];
             var formObject = document.form;
             sheetObject.RemoveAll();

        }


        /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;

            switch(sheetNo) {
                case 1:      //IBSheet1 init
                    with (sheetObj) {
                        // Setting total width
                        SheetWidth = mainTable.clientWidth;
                        
                        // Setting height
    					style.height = 400;

                        //Setting the host information[Required][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //Kind of Merge [Optional, Default msNone]
                        MergeSheet = msHeaderOnly;

                        //Edit kind [Optional, Default false]
                        Editable = false;

                        //Setting the row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 9, 100);

                        //Setting the column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(18, 4, 0, true);

                       // Setting function handling header
                        InitHeadMode(true, false, false, true, false,false);

                        var HeadTitle  = "Rev.\n Month|RHQ|Office|Sub Office|Cost Type|Cost Type Ⅱ|Cost\n Code|Acct\n Code|1st\n Node|2nd\n Node|3rd\n Node|4th\n Node|Vol.|Estimated\n Cost|Actual Cost\n (Invoice)|Accrual\n Cost|Confirmed\n Cost|Cost Diff" ;
                                            		
                        //The information of the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, false, false);
                        InitHeadRow(1, HeadTitle, false, false);
                        
                        //Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtData ,	70,		daCenter,	true ,	"rev_yrmon"			,	false,          "",       dfDateYm ,   		0,     false,	false);   
    					InitDataProperty(0, cnt++ , dtData ,	70,    	daCenter,	true ,  "rhq_cd"          	,	false,          "",       dfNone ,   		0,     false,	false); 
    					InitDataProperty(0, cnt++ , dtData ,	70,    	daCenter,	true ,	"ctrl_ofc_cd"		,	false,          "",       dfNone ,   		0,     false,	false); 
    					InitDataProperty(0, cnt++ , dtData ,	70,    	daCenter,	true ,  "sub_ofc_cd"		,	false,          "",       dfNone ,   		0,     false,	false); 
    					InitDataProperty(0, cnt++ , dtData ,	90,    	daCenter,	true ,	"mn_cost_tp_nm"		,	false,          "",       dfNone ,   		0,     false,	false);                                               
    					InitDataProperty(0, cnt++ , dtData ,	250,   	daCenter,	true ,	"sub_cost_tp_nm"	,	false,          "",       dfNone ,   		0,     false,	false);
    					InitDataProperty(0, cnt++ , dtData ,	70,    	daCenter,   true ,	"coa_cost_src_cd"	,	false,          "",       dfNone ,          0,     false,	false);
    					InitDataProperty(0, cnt++ , dtData ,	70,    	daCenter,   true ,	"acct_cd"			,	false,          "",       dfNone ,          0,     false,	false);
    					InitDataProperty(0, cnt++ , dtData ,	70,    	daCenter,   true ,	"n1st_nod_cd"		,	false,          "",       dfNone ,          0,     false,	false);
    					InitDataProperty(0, cnt++ , dtData ,	70,    	daCenter,   true ,	"n2nd_nod_cd"		,	false,          "",       dfNone ,          0,     false,	false);
    					InitDataProperty(0, cnt++ , dtData ,	70,    	daCenter,   true ,	"n3rd_nod_cd"		,	false,          "",       dfNone ,          0,     false,	false);
    					InitDataProperty(0, cnt++ , dtData ,	70,    	daCenter,   true ,	"n4th_nod_cd"		,	false,          "",       dfNone ,          0,     false,	false);
    					InitDataProperty(0, cnt++ , dtAutoSum ,	70,    	daRight ,  	true ,	"cntr_qty"			,	false,          "",       dfFloat ,			2,     false,	false); 
    					InitDataProperty(0, cnt++ , dtAutoSum ,	90,    	daRight ,  	true ,	"estm_cost_amt"		,	false,          "",       dfFloat ,			2,     false,	false);  
    					InitDataProperty(0, cnt++ , dtAutoSum ,	90,    	daRight ,  	true ,	"act_cost_amt"		,	false,          "",       dfFloat ,			2,     false,	false); 
    					InitDataProperty(0, cnt++ , dtAutoSum ,	90,    	daRight ,  	true ,	"accl_cost_amt"		,	false,          "",       dfFloat ,			2,     false,	false);                                              
    					InitDataProperty(0, cnt++ , dtAutoSum ,	90,    	daRight ,  	true ,	"confirmed_cost_amt",	false,          "",       dfFloat ,			2,     false,	false);           
    					InitDataProperty(0, cnt++ , dtAutoSum , 90,    	daRight ,  	true ,	"diff_cost_amt"		,	false,          "",       dfFloat ,			2,     false,	false); 

                        RangeBackColor(1, 6, 1, 8) = RgbColor(222, 251, 248);   // ENIS
                        HeadRowHeight = 20 ;
                        HeadRowHeight = 21 ;
                      //  style.height = GetSheetHeight(13) ;
                    }
                    break;
            }
        }
        
        /* Handling the process about the sheet */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;

            switch(sAction) {

            	case IBSEARCH:      //Retrieving
            			if(validateForm(sheetObj,formObj,sAction)) {
    			    	formObj.f_cmd.value = SEARCH;
    			    	//var searchXml = sheetObj.GetSearchXml("ESD_LEA_0014GS.do", FormQueryString(formObj));
    			    	
    			    	var searchXml = sheetObj.GetSearchXml("ESD_LEA_0014GS.do", leaFormQueryString(formObj));
    			    	
    			    	
    				    //ComShowMessage(searchXml);
    				    if(searchXml != "") sheetObj.LoadSearchXml(searchXml,false);
            			}
    	                break;
                    
    			case IBDOWNEXCEL:	// excel down		
    				//if(validateForm(sheetObj,formObj,sAction))
    				//mySheet.Down2Excel([Mode], [UseOpenFile], [NewSheet], [Merge],  [SaveAsName],[ReportPageUrl],[HideExcelMsg],
    	            //     				[WriteTreeLevel], [WorkSheetName], [FocusFirstSheet]) 		
    				sheetObj.Down2Excel(-1,	false,	false,	true,	"",	"",	false,	false, "",	true);
    				break;
            }
        }

        
        /**
         * Calling the event after finishing to retrieving sheet data
         */
    	function sheet1_OnSearchEnd(sheetObj,ErrMsg)
    	{
    		sheetObj.ColHidden("rhq_cd") = false;
    		sheetObj.ColHidden("ctrl_ofc_cd") = false;
    	    sheetObj.ColHidden("sub_ofc_cd") = false;

    	    if( document.form.f_report.value == '1' ){
    	    	sheetObj.ColHidden("ctrl_ofc_cd") = true;
    		    sheetObj.ColHidden("sub_ofc_cd") = true;
     	    }

    	}
    	
    	/**
         * Handling the process for the input validation
         */
        function validateForm(sheetObj,formObj,sAction){
        	var rtn = true;
            with(formObj){
        		if( formObj.f_cost_type_f.value == "0" && formObj.f_cost_type_m.value == "0" &&
        				formObj.f_cost_type_v.value == "0" ) {
        			ComShowMessage(ComGetMsg("COM12113", "Full/Empty"));
        			ComSetFocus(formObj.f_cost_type_f);
        			rtn = false;
        		}
        		else if ( formObj.rev_yrmon.value =="" ) {
        			ComShowMessage(ComGetMsg("LEA90001"));
        			ComSetFocus(formObj.rev_yrmon);
        			rtn = false;		
        		}
        		else {
        			rtn = true;
        		}
            }
            return rtn;
        }

           		
    	/**
    	* Activating/deactivating RHQ and Office.
    	*/
    	function reportChange(tp){
    	    if(tp == '1') {//Deactivating Office. Only RHQ can be selected.
    	    	document.form.f_rhq_cd.disabled = false;
    	        document.form.f_ctrl_ofc_cd.disabled = true;	
    	    } else if(tp == '2') {//RHQ has to be selected('All' can't be selected). Office can be selected(optional)
    	    	document.form.f_rhq_cd.disabled = false;    	
    	        document.form.f_ctrl_ofc_cd.disabled = false;		        
    	    }
    	}     
    		
    	

    	function changeRHQCd(rhqCd) {
    			if (document.form.f_report.value == '1') {			
    				document.form.f_ctrl_ofc_cd.disabled = true;				
    			}else {
    				var formObj = document.form;			
    				formObj.target = "frmHidden";
    				formObj.action = "apps/opus/esm/coa/common/jsp/ESM_COA_5150.jsp?code=" + rhqCd;
    				formObj.submit();
    			}
    	}	



    	/*
    	 * Setting the Cost Type check to cookie.
    	*/
    	function lea_setCookieAcclType(){
//    		setCookie("form_lea_cost_type_m",(document.form.f_cost_type_m.checked == true ?"1":"0"));
//    		setCookie("form_lea_cost_type_f",(document.form.f_cost_type_f.checked == true ?"1":"0"));
    		document.form.f_cost_type_m.value = (document.form.f_cost_type_m.checked == true ?"1":"0");
    		document.form.f_cost_type_f.value = (document.form.f_cost_type_f.checked == true ?"1":"0");
    		document.form.f_cost_type_v.value = (document.form.f_cost_type_v.checked == true ?"1":"0");

    	}


