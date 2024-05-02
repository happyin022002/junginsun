/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1126.js
*@FileTitle : Estimated Pool Chassis Expense Report (Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/


    /**
     * @extends 
     * @class EES_CGM_1126 : EES_CGM_1126 business script for
     */
    function EES_CGM_1126() {
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

 var tabObjects = new Array();
 var tabCnt = 0 ;
 var beforetab = 1; 

 var sheetObjects = new Array();
 var sheetCnt = 0;

 // Event handler processing by button click event */
 document.onclick = processButtonClick;

 // Event handler processing by button name */
     function processButtonClick(){
          /***** use additional sheet var in case of more than 2 tap each sheet *****/
          var sheetObject1 = sheetObjects[0];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
     		if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {

	            case "btn_close":
					 window.close();
	                 break; 
				
				case "btn_downexcel":
					 sheetObject1.SpeedDown2Excel(-1);
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
      * Sheet setting and reset
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {

         for(i=0;i<sheetObjects.length;i++){

         		//
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
         		//
             ComEndConfigSheet(sheetObjects[i]);
         }
         
         initControl(); // 
     }
      
      /**
      * 
      * @param sheetObj
      * @return
      */
     function sheet1_OnLoadFinish(sheetObj) {
         sheetObj.WaitImageVisible = false;
  	     

		 sheetObj.WaitImageVisible = true; 
    }
     
     /**
     * init control of form <br>
     * @param  {object} sheetObj	
     * @return 
     * @author 
     * @version 
     */
    function initControl(){
    	var sheetObj = sheetObjects[0];
    	// Form object
    	  formObj = document.form;
       
    	// Lease Term Combo Control init setting
    	doActionIBSheet(sheetObj,formObj,IBSEARCH);
    	
    	//formObj.chss_pool_cd.focus();
      
    }

   /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      //sheet1 init
                 with (sheetObj) {

                     // setting height
                     style.height = 280;
                     //setting width
                     SheetWidth = mainTable.clientWidth;

                     //setting Host information [mandatory][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //Merge kind [optional, Default msNone]
                     MergeSheet = msAll;

                    //Edit kind [optional, Default false]
                     Editable = false;

                     //setting Row information [mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 6, 100);
                     
                     //setting Column information [mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//                     InitColumnInfo(8, 0, 0, true);

                  // setting function handling header

                     var HeadTitle = "Type|Lessor/Pool|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC|Lessor/Pool Total";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     var tmp="";
                     var tmp2="";
        
                     //setting Column information [mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 2, 0, true);

                     //setting header Row information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);
                     

                     //data property    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtData   , 100, daCenter,  true, "chss_pool_tp_cd", false, "", dfNone,      0, false, false);
                     //if(document.form.chss_pool_tp_cd.value== "CP"){
                    //	 InitDataProperty(0, cnt++ , dtData   , 100, daCenter,   false, "chss_pool_cd",    false, "", dfNone,      0, false, false);
                     //} else {
                    	 
                    	 InitDataProperty(0, cnt++ , dtData   , 400, daLeft,   false, "chss_pool_cd",    false, "", dfNone,      0, false, false);
                     //}
                     
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "jan",             false, "", dfNullFloat, 2, false, false);
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "feb",             false, "", dfNullFloat, 2, false, false);
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "mar",             false, "", dfNullFloat, 2, false, false);
                                                                                                                                              
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "apr",             false, "", dfNullFloat, 2, false, false);
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "may",             false, "", dfNullFloat, 2, false, false);
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "jun",             false, "", dfNullFloat, 2, false, false);
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "jul",             false, "", dfNullFloat, 2, false, false);
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "aug",             false, "", dfNullFloat, 2, false, false);
                                                                                                                                              
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "sep",             false, "", dfNullFloat, 2, false, false);
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "oct",             false, "", dfNullFloat, 2, false, false);
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "nov",             false, "", dfNullFloat, 2, false, false);
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "dec",             false, "", dfNullFloat, 2, false, false);
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "total",           false, "", dfNullFloat, 2, false, false);

//                     FrozenCols = 6;
                 }
                 break;

         }
     }

   // handling process for Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         //sheetObj.ShowDebugMsg = false;
         switch(sAction) {

           case IBSEARCH:      //retrieve
		       	formObj.f_cmd.value = SEARCH;
			    sheetObj.WaitImageVisible=false;
			 	ComOpenWait(true);
			    var sXml = sheetObj.DoSearch("EES_CGM_1126GS.do" , FormQueryString(formObj)); 
			    sheetObj.LoadSearchXml(sXml);
			    ComOpenWait(false);
             break;
         }
     }



     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }

         return true;
     }

     /**
      * Sheet1 OnSearchEnd event handling <br>
      * @param  {object} sheetObj		 Sheet Object
      * @param  {string} ErrMsg		 String
      * @return 
      * @version 2009.07.16
      * @author 
      */ 
     function sheet1_OnSearchEnd(sheetObj, ErrMsg)
     {
     	with(sheetObj)
     	{
   			ShowSubSum("chss_pool_tp_cd", "2|3|4|5|6|7|8|9|10|11|12|13|14",-1, false, false, -1,"chss_pool_tp_cd=;chss_pool_cd=Sub Total");
     	}
     }
      
	  /**
	   * call back function. <br>
	   * Total display 
	   * @param  {Object} sheetObj			 SheetObj
	   * @param  {Int} row				  Row
	   * @return 
	   * @author 
	   * @version 2009.10.01
	   */ 
	  function sheet1_OnChangeSum(sheetObj, Row)
	  {
	  	with(sheetObj)
	  	{
	  		SumText(0, "chss_pool_tp_cd") = "";
	  		SumText(0, "chss_pool_cd") = "Grand Total";
	  		
	  		CellAlign(Row, "chss_pool_tp_cd") = daCenter;
	  	}
	  }      
	/* developer job end */