/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mnr_0212.js
*@FileTitle : M&R Expense Plan Creation by HO
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
     * @class ees_mnr_0212 : business script for ui_mnr_0212.
     */
    function ees_mnr_0212() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* developer job	*/

 // common global variables
 
    var sheetObjects = new Array();
    var sheetCnt = 0;


    // Event handler processing by button click event */
    document.onclick = processButtonClick;

    // Event handler processing by button name */
    function processButtonClick(){
         
    	var sheetObject1 = sheetObjects[0];
 		
    		    
         /*******************************************************/
         

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		if(ComGetBtnDisable(srcName)) return false;
				switch(srcName) {
					case "btn_OK":
						//comPopupOK();   
						self.close();
					break;
					
					case "btn_CLOSE":
						self.close();
					break;

				} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {     
				ComFuncErrMsg(e);          
			} else {      
				ComFuncErrMsg(e);    
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
        	 MnrWaitControl(true);
            for(i=0;i<sheetObjects.length;i++){

            //
                ComConfigSheet (sheetObjects[i] );

                initSheet(sheetObjects[i],i+1);
            //
                ComEndConfigSheet(sheetObjects[i]);
            }
    		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    		MnrWaitControl(false);
        }


      /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;
    		var sheetID = sheetObj.id;
    				
            switch(sheetID) {
                case "sheet1":
                    with (sheetObj) {
                        // setting height
                        style.height = 112;
                        // setting width
                        SheetWidth = mainTable.clientWidth;

                        //setting Host information[HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //Merge kind [optional, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //Edit kind [optional, Default false]
                        Editable = false;

                        //setting Row information [mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 10, 100);

    		            var HeadTitle1 = "|S|Office|Office Name|Office Location";
                        var headCount = ComCountHeadTitle(HeadTitle1);

                        //setting Column information [mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // setting function handling header
                        InitHeadMode(true, true, false, true, false,false);

                        //setting header Row information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);

                        //data property    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        var prefix="sheet1_";
                        InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter, true,   prefix + "Status");
                      //InitDataProperty(0, cnt++ , dtCheckBox,     30,     daCenter, true,   prefix + "Chk");
                        InitDataProperty(0, cnt++ , dtSeq,          30,     daLeft,   true,   prefix + "Seq");
                        InitDataProperty(0, cnt++ , dtData,         80,     daLeft,   false,  prefix + "ofc_cd",      false,  "",   dfNone,   0,  true,   true);
                        InitDataProperty(0, cnt++ , dtData,         220,    daLeft,   false,  prefix + "ofc_eng_nm",  false,  "",   dfNone,   0,  true,   true);
                        InitDataProperty(0, cnt++ , dtData,         40,     daLeft,   false,  prefix + "loc_cd",      false,  "",   dfNone,   0,  true,   true);			    	
    		

			    		CountPosition = 0;

    		  }
    	  break;

            }
        }

    	function sheet1_OnSearchEnd(sheetObj, errMsg) {
   		 	MnrWaitControl(false);
    	}

      // handling process for sheet
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
           
            switch(sAction) {
				case IBSEARCH:      //retrieving
					MnrWaitControl(true);
					if(validateForm(sheetObj,formObj,sAction)){
						ComShowCodeMessage("MNR00003");
						
					}else{
					   sheetObj.Redraw = false;    
	    	           formObj.f_cmd.value = SEARCH;
	        	       sheetObj.DoSearch("EES_MNR_0212GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
	       	           sheetObj.Redraw = true;
					}
				break;
            }
        }



        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
				if(!ComIsNull(formObj.ofc_cd)){
					MnrWaitControl(false);
					return false;
				}
            }
           
            return true;
        }
            
       
            
        function sheet1_OnDblClick(sheetObj,Row,Col){
        	var formObj = document.form; 
        	 formObj.retfld.value = sheetObj.CellText(Row, "sheet1_ofc_cd");
            
        	  comPopupOK();    
        	  //self.close();
         }
         function sheet1_OnClick(sheetObj,Row,Col){
        		var formObj = document.form; 
              	 formObj.retfld.value = sheetObj.CellText(Row,  "sheet1_ofc_cd");
              	 
         }
       
        
      

	/* developer job */