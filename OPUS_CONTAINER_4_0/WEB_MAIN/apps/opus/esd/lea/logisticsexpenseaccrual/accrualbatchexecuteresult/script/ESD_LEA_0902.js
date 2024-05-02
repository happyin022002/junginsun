/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0902.js
*@FileTitle : Rev.VVD Inquiry (Pop-up)
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
     * @class ESD_LEA_0902 : business script for ESD_LEA_0902
     */
    function ESD_LEA_0902() {
    	
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
    // Common global variables
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    /* Event handler processing by button click event */
    document.onclick = processButtonClick;
    
    /* Event handler processing by button name */
        function processButtonClick(){
        	
             var sheetObject  = sheetObjects[0];
             var sheetObject1 = sheetObjects[1];
             
             var formObject = document.form;
             
        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {
               
            	    case "btng_select":
        	            lea_selectRevVVD(sheetObject);
            	        break;

					case "btn_retrieve":
							lea_enterRetrieve();
					  break;
	
					case "btng_duplicatedvvd":
					    formObject.frm_dup_select.value="Y";
						  sheetObject.RemoveAll();
			 				doActionIBSheet(sheetObject,formObject,IBSEARCH);
					  break;

            	    case "btng_downexcel":
            	    
            	    	sheetObject. ExcelOption= "NOCOLOR";
            	    	sheetObject.SpeedDown2Excel(true);
            	    	sheetObject. ExcelOption= "";   
            	    	
    				case "btn_close":
  					  window.close();    								

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
    				var formObject = document.form;
            for(i=0;i<sheetObjects.length;i++){

                ComConfigSheet(sheetObjects[i]);

                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            
            lea_enterRetrieve();

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

                        //Setting the host information[Required][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                      //Kind of Merge [Optional, Default msNone]
                        MergeSheet = msHeaderOnly;

                      //Edit kind [Optional, Default false]
                        Editable = true;

                      //Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 1, 1, 9, 100);

                      //Setting the column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(8, 0, 0, true);

                     // Setting function handling header
                        InitHeadMode(true, true, true, true, false,false)

                        var HeadTitle = "|Rev. Month|VVD|Lane|Type|Inter/Ocean||" ;

                      //Setting the header[[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);

                      //Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHidden,        70,    daCenter,  true,    "exe_yrmon"				,        false,          "",       dfDateYm,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData  ,        70,    daCenter,  true,    "rev_yrmon"				,        false,          "",       dfDateYm,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData	,       120,    daCenter,  true,    "rev_vvd_no"			,        false,          "",       dfNone,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData	,        80,    daCenter,  true,    "rlane_cd"				,        false,          "",       dfNone,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData	,        60,    daCenter,  true,    "estm_vvd_tp_cd"	,        false,          "",       dfNone,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData	,        80,    daCenter,  true,    "estm_ioc_div_cd"	,        false,          "",       dfNone,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,        80,    daCenter,  true,    "estm_vvd_hdr_id"	,        false,          "",       dfNone,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,        80,    daCenter,  true,    "estm_bc_div_cd"	,        false,          "",       dfNone,     	0,     false,       false);

                        style.height = GetSheetHeight(10) ;
                   }
                    break;
                case 2:      //IBSheet1 init
                    with (sheetObj) {
                		//Setting width
                        SheetWidth = mainTable.clientWidth;

                      //Setting the Host information[Required][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //Kind of merge[Optional, Default msNone]
                        MergeSheet = msHeaderOnly;

                      //Edit kind[Optional, Default false]
                        Editable = true;

                      //Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 1, 1, 9, 100);

                      //Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(3, 0, 0, true);

                      //Setting function handling header
                        InitHeadMode(true, true, true, true, false,false)

                        var HeadTitle  = "Exe.Month|From Rev.Month|To Rev.Month" ;

                      //Setting the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);

                      //Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "exe_yrmon"         ,        false,          "",       dfDateYm,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "rev_yrmon_from"    ,        false,          "",       dfDateYm,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "rev_yrmon_to"      ,        false,          "",       dfDateYm,     	0,     false,       false);

                        HeadRowHeight = 20 ;
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
            	   formObj.f_cmd.value = SEARCH;
            	   var searchXml = sheetObj.GetSearchXml("ESD_LEA_0902GS.do", leaFormQueryString(formObj));
            	   if(searchXml != "") sheetObj.LoadSearchXml(searchXml,false);
            	   break;
                    
               case IBDOWNEXCEL:	// excel down		
            	   sheetObj.Down2Excel(-1,	false,	false,	true,	"",	"",	false,	false, "",	true);
            	   break;
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
         * Handling the event after double-clicking sheet
         */
    	function sheet1_OnDblClick(sheet1,row, col){
    			lea_selectRevVVD(sheet1);		
    	}
       /**
         * Send the VVD Code of the selected row to the parent.
         */
        function lea_selectRevVVD(sheetObj){
        	
        	var openerFormObj = window.dialogArguments.document.form;
        	
        	if(sheetObj.RowCount < 1){
        		ComShowMessage("No searched data.");
        		return false;
        	}
        	
        	if(sheetObj.SelectRow <= 0){
        		ComShowMessage("No selected row.");
        		return false;
        	}
        	
        	openerFormObj.frm_vvd_no.value = sheetObj.CellValue(sheetObj.SelectRow,"rev_vvd_no");      	
        	close();
        	
        }

    		function lea_enterRetrieve(){
    				
            var sheetObject = sheetObjects[0];
            var formObject = document.form;
            formObject.frm_dup_select.value="";
    			  sheetObject.RemoveAll();
     				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    			
    		}
    		/**
    		 * Copying the form data to sheet
    		 */
    		function lea_form2sheet(formObj,sheetObj){

    			sheetObj.RemoveAll();

    			var Row = sheetObj.DataInsert(-1);
    			
    			sheetObj.CellValue(Row , "exe_yrmon" 			) = formObj.frm_exe_yrmon.value;
    			sheetObj.CellValue(Row , "rev_yrmon_from" ) = formObj.frm_rev_yrmon_from.value;
    			sheetObj.CellValue(Row , "rev_yrmon_to" 	) = formObj.frm_rev_yrmon_to.value;

    		}
    		
    	/*
    	 * Setting frm_rev_yrmon_to value
    	*/
    	function lea_setRevToYymm(obj1,obj2){
    		if (event.keyCode == 13){
    			lea_com_setRevToYymm(obj1,obj2)
    		}
    	}
