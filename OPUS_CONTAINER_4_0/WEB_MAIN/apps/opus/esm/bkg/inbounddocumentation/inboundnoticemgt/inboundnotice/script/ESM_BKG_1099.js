/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1099.jsp
*@FileTitle  : Integrated Customer Data Update Setup Pop-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
    // Common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
   // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * 
     * @return 
     */
    function processButtonClick(){
        var formObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
            case "btn_Ok":
            	if ((formObj.ofc_cd.value != "") && (formObj.auto_upd_flg.value != sheetObj.GetCellValue(1, "auto_upd_flg"))) {
                	doActionIBSheet(sheetObjects[0],formObj,MULTI);
            	} else {
            		ComShowCodeMessage("BKG00233");
            	}
                break;                      
            case "btn_Close":
            	if ((sheetObj.GetCellValue(1, "auto_upd_flg")||"" == "") && formObj.auto_upd_flg.value == "Y") {
            		ComClosePopup(); 
            		break;
            	}
            	if (formObj.auto_upd_flg.value != sheetObj.GetCellValue(1, "auto_upd_flg")||"") {
            		if(ComShowCodeConfirm("BKG00168")) {
            			doActionIBSheet(sheetObjects[0],formObj,MULTI);
            			ComClosePopup(); 
            		} else {
            			ComClosePopup(); 
            		}
            	} else {
            		ComClosePopup(); 
            	}
                break;
            } // end switch
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen. <br>
     * 
     * @return 
     */
    function loadPage() {
        //initControl();
		for(i=0;i<sheetObjects.length;i++){
	        //khlee- Preferences change the name of the function to start
				ComConfigSheet (sheetObjects[i] );
				initSheet(sheetObjects[i],i+1);
	        //khlee- The final configuration functions added
				ComEndConfigSheet(sheetObjects[i]);
			}
         if (document.form.ofc_cd.value != "") {
         	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         }
    }
     /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      //sheet1 init
                 with (sheetObj) {
                 
                 var HeadTitle="|ofc_cd|auto_upd_flg|upd_usr_id|upd_locl_dt" ;
                 var headCount=ComCountHeadTitle(HeadTitle);                 

                 SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );

                 var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
                 InitHeaders(headers, info);

                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"auto_upd_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:1,   SaveName:"upd_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"upd_locl_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                  
                 InitColumns(cols);

                 SetEditable(1);
                 SetWaitImageVisible(0);
                 SetShowButtonImage(1);

                 SetSheetHeight(420);
             }
                 break;
         }
     }
    /**
     * Sheet handling process <br>
     * 
     * @param {ibsheet} sheetObj mandatory, IBSheet Object
     * @param {object}  formObj  mandatory, HTML Form Object
     * @param {string}  sAction  mandatory, Action Name 
     * @return 
     */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
	         //Retrieve
	     	 case IBSEARCH:
	     		 
	     	    ComOpenWait(true);
	     		setTimeout( function () { //@ setTimeout ###########################################################
		     		formObj.f_cmd.value=SEARCH;
		     		//if(!validateForm(sheetObj,formObj,sAction)) return;
		     		sheetObj.DoSearch("ESM_BKG_1099GS.do", FormQueryString(formObj) );
	     		} , 100);//@ setTimeout end ###########################################################
	     		break;
	     	case MULTI:
	     		if(!validateForm(sheetObj,formObj,sAction)) return;
	     		
	     		ComOpenWait(true);
		     	setTimeout( function () { //@ setTimeout ###########################################################	     		
			     		formObj.f_cmd.value=MULTI;
			     		var params=FormQueryString(formObj)
			     		//alert(params);
			     		var sXml=sheetObj.GetSaveData("ESM_BKG_1099GS.do", FormQueryString(formObj));
			     		sheetObj.LoadSaveData(sXml);
	     		} , 100);//@ setTimeout end ###########################################################	
	     		break;	     		
         }
     }
    /**
     * handling process for input validation <br>
     * 
     * @param {ibsheet} sheetObj mandatory, IBSheet Object
     * @param {object}  formObj  mandatory, HTML Form Object
     * @param {string}  sAction  mandatory, Action Name 
     * @return boolean Form Returns whether the object is validated. (valid true -> true, valid false -> false)
     */
    function validateForm(formObj,sAction){
      	switch(sAction) {
     	case IBSEARCH:
  	    	break;
        }
        return true;
    }

    /************************************************************************************
    SaveEnd Event of IBSHEET의 start
************************************************************************************/
/**
 * handle the details after blInfo save
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg){
	ComOpenWait(false);
	var formObj=document.form;
	doActionIBSheet(sheetObj,formObj,IBSEARCH);
}    

/**
 * handle the details after IBSheet retrieve
 */
 function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	 ComOpenWait(false);
    if (ErrMsg != "") {
        return;           
    }
    var formObj=document.form;
	if(sheetObj.RowCount()> 0) {
		if(sheetObj.GetCellValue(1, "auto_upd_flg") == "Y") {
 			formObj.auto_upd_flg.value="Y";
 		} else {
 			formObj.auto_upd_flg.value="N";
 		}
		upd_usr_id.innerHTML=sheetObj.GetCellValue(1, "upd_usr_id") + " / " + sheetObj.GetCellValue(1, "upd_locl_dt")
	} else {
		formObj.auto_upd_flg.value="Y";
		upd_usr_id.innerHTML=""
	}
}