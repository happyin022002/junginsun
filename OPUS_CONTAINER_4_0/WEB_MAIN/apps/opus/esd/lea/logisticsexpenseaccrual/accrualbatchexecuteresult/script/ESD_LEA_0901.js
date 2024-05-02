/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0901.js
*@FileTitle : Account Cost Inquiry (Pop-up)
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
     * @class ESD_LEA_0901 : business script for ESD_LEA_0901
     */
    function ESD_LEA_0901() {
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

            
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

            	    case "btng_select":
        	            lea_selectAccontCode(sheetObject);
            	        break;

    				case "btn_ok":
    				  break;

    				case "btn_close":
    					  window.close();
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
	      * registering IBSheet Object as list
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

                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i],i+1);
                
                ComEndConfigSheet(sheetObjects[i]);
            }
            
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

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

                    //Setting the Host information[Required][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //Kind of merge[Optional, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //Edit kind[Optional, Default false]
                    Editable = true;

                    //Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(6, 0, 0, true);

                    //Setting function handling header
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "Account\nCode|Rep.\nAcount\nCode|Cost\nType l |sub_cost_tp_cd|Cost Type Ⅱ|Account Name" ;

                    //Setting the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData	,        60,    daCenter,  true,    "acct_cd"   		,        false,          "",       dfNone,     	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData	,        60,    daCenter,  true,    "rep_acct_cd"   ,        false,          "",       dfNone,     	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData	,        60,    daCenter,  true,    "mn_cost_tp_cd" ,        false,          "",       dfNone,     	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,        60,    daCenter,  true,    "sub_cost_tp_cd",        false,          "",       dfNone,     	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData	,       200,    daCenter,  true,    "sub_cost_tp_nm",        false,          "",       dfNone,     	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData	,       220,    daCenter,  true,    "acct_nm"    ,        false,          "",       dfNone,     	0,     false,       false);

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
				  
            	   var searchXml = sheetObj.GetSearchXml("ESD_LEA_0901GS.do", leaFormQueryString(formObj));
					  
					  
            	   if(searchXml != "") sheetObj.LoadSearchXml(searchXml,false);
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
         * Handling the event after retrieving sheet data
         */
    	function sheet1_OnSearchEnd(sheetObj,ErrMsg)
    	{
    			var openerFormObj = window.dialogArguments.document.form;
    			var Row = sheetObj.FindText("acct_cd", openerFormObj.frm_acct_cd.value);
    			if(Row > 0){
    	      sheetObj.SelectCell(Row, "acct_cd", false);  
    	      sheetObj.TopRow = Row;
    	   	}

    	}
        
    	/**
         * Sending the selected row to AccontCode Parent
         */
        function lea_selectAccontCode(sheetObj){
        	var openerFormObj = window.dialogArguments.document.form;
        	if(sheetObj.RowCount < 1){
        		ComShowMessage("No searched data.");
        		return false;
        	}
        	
        	if(sheetObj.SelectRow <= 0){
        		ComShowMessage("No selected row.");
        		return false;
        	}
        	openerFormObj.frm_acct_cd.value = sheetObj.CellValue(sheetObj.SelectRow,"acct_cd");
        	window.close();
        }
        
        
        /**
    	 * Calling this function after double-clicking the sheet.
    	 *
    	 */
    	function sheet1_OnDblClick(sheet1,row, col){
    			lea_selectAccontCode(sheet1);		
    	}

