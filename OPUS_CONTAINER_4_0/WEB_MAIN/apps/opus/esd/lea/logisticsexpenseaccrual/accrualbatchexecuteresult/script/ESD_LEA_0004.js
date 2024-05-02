/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0004.js
*@FileTitle : Accrual Result by Booking
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
     * @extends 
     * @class ESD_LEA_0004 : business script for ESD_LEA_0004 
     */
    function ESD_LEA_0004() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    

    var sheetObjects = new Array();
    var sheetCnt = 0;

    /* Event handler processing by button click event */
    document.onclick = processButtonClick;

    	/* Event handler processing by button name */
        function processButtonClick(){
             var sheetObject = sheetObjects[0];
             var sheetObject1 = sheetObjects[1];

             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

            	    case "btn_retrieve":
            	    	sheetObject.RemoveAll();
           
        	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	            
    									break;

            	    case "btng_detailbycontainer":
    			            if ( sheetObject.RowCount < 1 ) 
    			            {
    			              	//ComShowMessage("No data found.");
    			              	ComShowMessage(ComGetMsg("LEA90008"));
    			                return false;
    			            }
    			            if ( sheetObject.SelectRow < 0 ) 
    			            {
    			              	//ComShowMessage("Nothing Selected.");
    			              	ComShowMessage(ComGetMsg("LEA90003"));
    			                return false;
    			            }
    									var url_str = "ESD_LEA_0005.do";
											url_str += "?exe_yrmon="		+formObject.frm_exe_yrmon.value;
											url_str += "&rev_yrmon="		+formObject.frm_rev_yrmon.value;
											url_str += "&acct_cd="		    +formObject.frm_acct_cd.value;
											url_str += "&rev_vvd_no="		+sheetObject.CellValue(sheetObject.SelectRow, "rev_vvd_no");
											url_str += "&bkg_no="		  	+sheetObject.CellValue(sheetObject.SelectRow, "bkg_no").substr(0,13);
											url_str += "&open_div=POP";
    											
    									window.showModalDialog(url_str, window, "dialogWidth:1010px; dialogHeight:480px; help:no; status:no; resizable:yes;");
    									//ComOpenWindow(url_str, "By Container", "statebar=no, width=1000, height=460");
            	        break;

            	    case "btng_downexcel":
            	    
    						//lea_form2sheet(formObject,sheetObject1);
//                sheetObject1.Down2Excel(-1,false,false,true,"","",false,false, "",true);
//    						sheetObject .Down2Excel(-1,true,false,true,"","",false,false, "",true);

       	            //doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
            	    	sheetObject. ExcelOption= "NOCOLOR";
            	    	sheetObject.SpeedDown2Excel(true);
            	    	sheetObject. ExcelOption= "";   
            	        break;

            	    case "btns_acct_search":
    									window.showModalDialog('ESD_LEA_0901.do', window, "dialogWidth:800px; dialogHeight:480px; help:no; status:no; resizable:yes;");
            	    					
            	        break;
            	        
            	    case "btns_rev_vvd_search":
    									var url_str = "ESD_LEA_0902.do";
											url_str += "?exe_yrmon="	+formObject.frm_exe_yrmon.value;
											url_str += "&rev_yrmon="	+formObject.frm_rev_yrmon.value;
									        window.showModalDialog(url_str, window, "dialogWidth:600px; dialogHeight:480px; help:no; status:no; resizable:yes;");
											//ComOpenWindow(url_str, "RevVVD", "statebar = no , width= 600 , height=500");
											
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
             var sheetObj = sheetObjects[0];
             var formObj = document.form;

            for(i=0;i<sheetObjects.length;i++){

                ComConfigSheet(sheetObjects[i]);

                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            if(formObj.winopen_div.value == "POP")
    					doActionIBSheet(sheetObj,formObj,IBSEARCH);
    				
    				
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
                	//Setting width
                        SheetWidth = mainTable.clientWidth;
                        
                     // Setting height
    					style.height = 400;

    					//Setting the Host information[Required][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                      //Kind of merge [Optional, Default msNone]
                        MergeSheet = msHeaderOnly;

                      //Edit kind [Optional, Default false]
                        Editable = true;

                      //Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 9, 100);

                    	//Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(11, 2, 0, true);

                    	// Setting function handling header
                        InitHeadMode(true, true, true, true, false,false)

                        var HeadTitle = "SEQ|Exe.Month|Rev.Month|Rev.VVD|BKG#|Estimated\nCost|Actual Cost|Accrual Cost|Confirmed\nCost|Cost Diff|Cost Diff" ;
                        var HeadTitle1 = "SEQ|Exe.Month|Rev.Month|Rev.VVD|BKG#|Estimated\nCost|Actual Cost|Accrual Cost|Confirmed\nCost|Amount|%" ;

                    	//The information of the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);
                        InitHeadRow(1, HeadTitle1, true);

                    	//Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtSeq    ,       30,    daCenter,  true,    "",        false,          "",       dfNone,   	0,     true,        true);
                        InitDataProperty(0, cnt++ , dtHidden ,      100,    daCenter,  true,    "exe_yrmon"         ,        false,          "",       dfDateYm,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden ,      100,    daCenter,  true,    "rev_yrmon"         ,        false,          "",       dfDateYm,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   ,       90,    daCenter,  true,    "rev_vvd_no"        ,        false,          "",       dfNone ,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   ,       90,    daCenter,  true,    "bkg_no"            ,        false,          "",       dfNone ,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtAutoSum,       90,    daRight,   true,    "estm_cost_amt"     ,        false,          "",       dfFloat,  	2,     false,       false);
                        InitDataProperty(0, cnt++ , dtAutoSum,       90,    daRight,   true,    "act_cost_amt"      ,        false,          "",       dfFloat,  	2,     false,       false);
                        InitDataProperty(0, cnt++ , dtAutoSum,       90,    daRight,   true,    "accl_cost_amt"     ,        false,          "",       dfFloat,  	2,     false,       false);
                        InitDataProperty(0, cnt++ , dtAutoSum,       90,    daRight,   true,    "confirmed_cost_amt",        false,          "",       dfFloat,  	2,     false,       false);
                        InitDataProperty(0, cnt++ , dtAutoSum,       90,    daRight,   true,    "cost_diff_amt"     ,        false,          "",       dfFloat,  	2,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   ,       70,    daRight,   true,    "cost_diff_per"     ,        false,          "",       dfFloat,  	1,     false,       false);

                        RangeBackColor(1, 7, 1, 10) = RgbColor(222, 251, 248);   // ENIS
                        HeadRowHeight = 20 ;
                        HeadRowHeight = 21 ;
                        //style.height = GetSheetHeight(13) ;
                   }
                    break;
                case 2:      //IBSheet1 init
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
                        InitColumnInfo(7, 0, 0, true);

    					// Setting function handling header
                        InitHeadMode(true, true, true, true, false,false)

                        var HeadTitle  = "Exe.Month|Rev.Month|Account Code|Rev.VVD|BKG#|Cost Diff. Filtering|Cost Diff. Filtering" ;
                        var HeadTitle1 = "Exe.Month|Rev.Month|Account Code|Rev.VVD|BKG#|Amount|percent" ;

                    	//The information of the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);
                        InitHeadRow(1, HeadTitle1, true);

                    	//Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "exe_yrmon"         ,        false,          "",       dfDateYm,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "rev_yrmon"         ,        false,          "",       dfDateYm,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "acct_cd"           ,        false,          "",       dfNone ,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "rev_vvd_no"        ,        false,          "",       dfNone ,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "bkg_no"            ,        false,          "",       dfNone ,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "cost_diff_amt"     ,        false,          "",       dfNone ,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "cost_diff_per"     ,        false,          "",       dfNone ,     	0,     false,       false);

                        HeadRowHeight = 20 ;
                        HeadRowHeight = 21 ;
                        style.height = GetSheetHeight(13) ;
                   }
                    break;

            }
        }

     // Handling the process about the sheet
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            
            switch(sAction) {

               case IBSEARCH:      //Retrieving
                   //if(!validateForm(sheetObj,formObj,sAction)) return false;
                   
    					    	formObj.f_cmd.value = SEARCH;
    							  //var searchXml = sheetObj.GetSearchXml("ESD_LEA_0004GS.do", FormQueryString(formObj));
    							  
    							  var searchXml = sheetObj.GetSearchXml("ESD_LEA_0004GS.do", leaFormQueryString(formObj));
    							  
    						    //ComShowMessage(searchXml);
    						    if(searchXml != "") sheetObj.LoadSearchXml(searchXml,false);
                    break;
                    
    					case IBDOWNEXCEL:        // excel down
    		
    						//if(validateForm(sheetObj,formObj,sAction))
    						/*
    							mySheet.Down2Excel([Mode], [UseOpenFile], [NewSheet], [Merge],  [SaveAsName],[ReportPageUrl],[HideExcelMsg],
                                     [WriteTreeLevel], [WorkSheetName], [FocusFirstSheet]) 
                                                */

    						sheetObj.Down2Excel(-1,false,false,true,"","",false,false, "",true);
    						break;

            }
        }

    	function sheet1_OnSearchEnd(sheetObj,ErrMsg)
    	{
    	   sheetObj.SumText(0,0) = "";
    	   sheetObj.SumText(0,3) = "Grand Total" ;
    	  // sheetObj.SumBackColor  	= sheetObj.RgbColor(153,153,255);
    		 sheetObj.SumFontBold 		= true;
    		 

      		if(sheetObj.SumValue(0,"estm_cost_amt") == 0)
    				sheetObj.SumValue(0,"cost_diff_per") = 0;
    			else
    				sheetObj.SumValue(0,"cost_diff_per") = sheetObj.SumValue(0,"cost_diff_amt")/ sheetObj.SumValue(0,"estm_cost_amt")*100;

    	}

    	 function sheet1_OnScroll(sheet1, oldTopRow, oldLeftCol, newTopRow, newLeftCol){
    	 	 if (oldTopRow != newTopRow ) {
    	 	 		sheet1.SelectRow = newTopRow;
    	 	 }
    	 	
    	}

    	function sheet1_OnDblClick(sheet1,row, col){
         var formObject = document.form;
    		if(!lea_com_isSubSumRow(sheet1, row)){
    			
    			var url_str = "ESD_LEA_0005.do";
    					url_str += "?exe_yrmon="		+formObject.frm_exe_yrmon.value;
    					url_str += "&rev_yrmon="		+formObject.frm_rev_yrmon.value;
    					url_str += "&acct_cd="		    +formObject.frm_acct_cd.value;
    					url_str += "&rev_vvd_no="		+sheet1.CellValue(row, "rev_vvd_no");
    					url_str += "&bkg_no="		  	+sheet1.CellValue(row, "bkg_no").substr(0,13);
    					url_str += "&open_div=POP";
    			window.showModalDialog(url_str, window, "dialogWidth:1110px; dialogHeight:600px; help:no; status:no; resizable:yes;");
    					//ComOpenWindow(url_str, "By Container", "statebar = no , width= 1100 , height=600");
    		}
    	}
       
    	/**
    	 * Handling the process for the input validation
    	 */
        function validateForm(sheetObj,formObj,sAction){
    				if(!lea_comm_validChkForm(formObj)) return false;
    	  		if((formObj.frm_acct_cd.value == "" || formObj.frm_acct_cd.value == null || formObj.frm_acct_cd.value == "ALL" ) &&
    	  		   (formObj.frm_vvd_no .value == "" || formObj.frm_vvd_no .value == null || formObj.frm_vvd_no .value == "ALL" ) &&
    	  		   (formObj.frm_bkg_no .value == "" || formObj.frm_bkg_no .value == null) ){
    	     		 
    	     		 ComShowMessage(ComGetMsg("LEA90004","Acc. Code","Rev. VVD ","BKG No."));
    	  		   //	ComShowMessage("Please enter  Acc. Code or Rev. VVD or BKG No. ");
    	  		   	return false;
    	  		}
            return true;
        }
        /**
         * Handling the retrieving process when pressed Enter key Event
         */
    		function lea_enterRetrieve(){
            var sheetObject = sheetObjects[0];
            var formObject = document.form;
    			  sheetObject.RemoveAll();
     				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    			
    		}
    		
    		 /**
             * Copying the form data to sheet one
             */
    		function lea_form2sheet(formObj,sheetObj){
    			
    			sheetObj.RemoveAll();
    			var Row = sheetObj.DataInsert(-1);
    			sheetObj.CellValue(Row , "exe_yrmon" ) = formObj.frm_exe_yrmon.value;
    			sheetObj.CellValue(Row , "rev_yrmon" ) = formObj.frm_rev_yrmon.value;
    			sheetObj.CellValue(Row , "acct_cd"   ) = formObj.frm_acct_cd  .value;
    			sheetObj.CellValue(Row , "rev_vvd_no") = formObj.frm_vvd_no   .value;
    			sheetObj.CellValue(Row , "bkg_no"    ) = formObj.frm_bkg_no   .value;
    			if(getRadioValue(formObj.frm_diff_div) == "A")
    				sheetObj.CellValue(Row , "cost_diff_amt") = formObj.frm_cost_diff_amt.value;
    			else
    				sheetObj.CellValue(Row , "cost_diff_per") = formObj.frm_cost_diff_per.value;
    		}
    		
    		
    		function lea_selectRadio(obj1,obj2){
    			if(obj1.name == "frm_cost_diff_amt"){
    				document.form.frm_diff_div[0].checked = true; 
    				obj2.value = 0;
    			}else{
    				document.form.frm_diff_div[1].checked = true; 
    				obj2.value = 0;
    			}
    		}

