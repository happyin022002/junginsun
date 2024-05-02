/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0920.js
*@FileTitle  : TRO-Copy
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event  */
    document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_RowAdd":
					sheetObject1.DataInsert(-1);
					break;
				case "btn_Delete":
					for (var i=sheetObject1.RowCount()+1 ; i >= 1; i--) {
						if (sheetObject1.GetCellValue(i, "del_chk") == 1) {
							if( sheetObject1.GetRowStatus(i) == "I"){
								sheetObject1.RowDelete(i , 0);
							} else {
								sheetObject1.SetCellValue(i, "ibflag","D",0);
							}
						}
					}
					break;
				case "btn_OK":
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;
				case "btn_Close":
					ComClosePopup(); 
					break;
            } // end switch
    	}catch(e) {
    		ComShowMessage(e.message);
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
     * adding first-served functions after loading screen
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);                
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
    }
    function initControl() {
    	var formObj=document.form;
    	var nRow=sheetObjects[0].DataInsert(-1);
    	sheetObjects[0].SelectCell(nRow, "bkg_no");
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		switch(sheetObj.id) {
			case "sheet1":      //hidden sheet1
	            with(sheetObj){
		          var HeadTitle=" | |Booking No.";
		          var headCount=ComCountHeadTitle(HeadTitle);
		
		          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				     {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 } ];
		           
		          InitColumns(cols);
		
		          SetEditable(1);
                  SetColProperty(0 ,"bkg_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                  SetSheetHeight(160);
                  //InitDataValid(0, "bkg_no", vtNumericOther, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
          }


				break; 	
		}
	}
    // handling sheet process
    function doActionIBSheet(sheetObj, formObj, sAction) { 
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
          	case IBSAVE: 
 	          	if(!validateForm(sheetObj, formObj, sAction)){
 	          		return false;
 	          	}
 	          	formObj.f_cmd.value=MULTI;  
          		var sParam1=ComGetSaveString(sheetObjects);
                if (sParam1 == "") return;
                var sParam=FormQueryString(formObj);
          		sParam += "&" + ComSetPrifix(sheetObjects[0].GetSaveString(), "sheet1_");
           		var sXml=sheetObj.GetSaveData("ESM_BKG_0920GS.do", sParam);
           		sheetObjects[0].LoadSaveData(sXml);
          		break;
        }
    }
    //#################(Event)############################
    /**
    * save complete
    */    
    function sheet1_OnSaveEnd(sheetObj,code , ErrMsg) {
    	if ( ErrMsg.trim() == msgs['BKG00166'].trim()) {
    		ComClosePopup(); 
    	}
    }
    //#################(Etc/Logic)############################
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj, formObj, sAction){
        with(formObj)
        {
        	switch (sAction) {
         	    case IBSAVE:
 					if (sheetObj.IsDataModified()== false) {
 						ComShowCodeMessage("BKG00567");
 						return false;
 					}
					if (!chkTroCopy()) {
						return false;
					}
         	    	break; 
            }
        }
        return true;
    }
 	/**     
	 * chkTroCopy 
	 */
	function chkTroCopy() {
	    var formObj=document.form;
		var sheetObj=sheetObjects[0]; 
		with(sheetObj)
		{
			for (var i=1; i<=LastRow(); i++)
			{
				//check mandatory 
				if (GetCellValue(i, "bkg_no") == "") {
					ComShowCodeMessage("BKG00888", "Booking No.");
	 				return false;
				} 
			}
			if (!ComBkgProcessYn("TroCopy")) {
	    		return false;
	    	}
		}
		return true;
	} 	
