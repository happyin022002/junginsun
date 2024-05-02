/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_2105.jsp
*@FileTitle  : DAR History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    
	// common global variables
	var sheetObjects 	= new Array();
	var sheetCnt 		= 0;
	

	var RFA_NO 			= "rfa_no";
	var APRO_OFC 		= "apro_ofc_cd";
	var DAR_NO 			= "rfa_expt_dar_no";
	var MAPG_SEQ 		= "rfa_expt_mapg_seq";
	var VER_SEQ 		= "rfa_expt_ver_seq";
	var APRO_NO 		= "rfa_expt_apro_no";
	var STATUS 			= "dmdt_expt_rqst_sts_desc";
	var REQ_OFC 		= "req_ofc_cd";
	var REQ_USR_NM 		= "req_usr_nm";
	var REQ_DT 			= "req_dt";
	var APVL_OFC 		= "apvl_ofc_cd";
	var APVL_USR_NM 	= "apvl_usr_nm";
	var APVL_DT 		= "apvl_dt";
	
	var DEF_SHEET_HEIGHT = 312;
	
	// Event handler processing by button click event */
	document.onclick 	= processButtonClick;

	// Event handler processing by button name */
    function processButtonClick(){
         /***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=window.event.srcElement.getAttribute("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
				case "btn_Copy":
					doActionCopy();
					break;
				case "btn_Close":
					doActionClose();
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
     * Register as an array IBSheet Object
     * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	var formObj=document.form;
        for (i=0 ; i < sheetObjects.length ; i++) {
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		initDisableControls();
		if (ComGetObjValue(formObj.is_copy) == "Y")
        	ComBtnEnable("btn_Copy");
        else
        	ComBtnDisable("btn_Copy");        
        doActionRetrieve();        
    }
  /**
     * Sheet the initial setting, the header definition
     * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
     * Many case as the number of sheets to add the sheet, a sheet should initialize the module configuration
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      // sheet1 init
            	with(sheetObj){
	            	var HeadTitle1="|Seq.|Sel.|RFA No.|APVL\nOffice|DAR No.|Ver.|Approval No.|Status|Request Office|Request Office|Request Office|Approval Office|Approval Office|Approval Office";
	            	var HeadTitle2="|Seq.|Sel.|RFA No.|APVL\nOffice|DAR No.|Ver.|Approval No.|Status|Office|Name|Date|Office|Name|Date";
	
	            	SetConfig( { SearchMode:2, FrozenCol:9, MergeSheet:5, Page:100, DataRowMerge:1 } );
	
	            	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            	var headers = [ { Text:HeadTitle1, Align:"Center"},
	            	                { Text:HeadTitle2, Align:"Center"} ];
	            	InitHeaders(headers, info);
	
	            	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Status" },
	            	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	            	             {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"SEL",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:RFA_NO,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:APRO_OFC,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:DAR_NO,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:VER_SEQ,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:APRO_NO,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:STATUS,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:REQ_OFC,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:125,  Align:"Left",    ColMerge:1,   SaveName:REQ_USR_NM,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:REQ_DT,         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:APVL_OFC,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:125,  Align:"Left",    ColMerge:1,   SaveName:APVL_USR_NM,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:APVL_DT,        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:MAPG_SEQ,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	            	 
	            	InitColumns(cols);
	
	            	//SetSheetWidth(mainTable.clientWidth);
	            	SetSheetHeight(DEF_SHEET_HEIGHT);
	            	SetEditable(1);
	            	//SetCountPosition(0);
            	}


                break;
        }
    }
    // Sheet processing-related processes
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      
        		with(formObj) {
        			if (searchType[0].checked == true) {
        				ComSetObjValue(f_cmd, 	SEARCH);	
        			}
        			else {
        				ComSetObjValue(f_cmd, 	SEARCH01);
        			}
        			ComSetObjValue(rfa_no, 	ComGetObjValue(rFANo));
        			ComSetObjValue(cust_cd, ComGetObjValue(custCd));
     			}
        		sheetObj.RemoveAll();
        		//*********************************************************************************
        		ComOpenWait(true);
        		sheetObj.SetWaitImageVisible(0);
        		//*********************************************************************************
        		sheetObj.DoSearch("EES_DMT_2105GS.do", FormQueryString(formObj) );
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				break;
        }
    }
    /**
    * Screen input form validation process for handling
    */
    function validateForm(sheetObj,formObj,sAction){
       with(formObj){
       }
       return true;
    }
    function doActionRetrieve() {
   	    var formObj=document.form;
   	    var sheetObj=sheetObjects[0];
   	    doActionIBSheet(sheetObj, formObj, IBSEARCH);
    }   
     function doActionCopy() {
    	var formObj=document.form;   		 
     	var sheetObj=sheetObjects[0];
    	
     	var opener=window.dialogArguments;
    	if (!opener) opener=window.opener;  //이 코드 추가할것
     	if (!opener) opener=parent;

     	var sCheckRow = sheetObj.FindCheckedRow("SEL");     	
     	if (sCheckRow == "") {
     		return ComShowCodeMessage("DMT00178");
     	}
     	
    	if (ComParseInt(ComGetObjValue(formObj.rowcount)) > 0) {
    		if (!ComShowCodeConfirm("DMT00177")) return;
    	}
    	var iCheckRow = ComParseInt(sCheckRow);
		var paramsArray=new Array();
		paramsArray[0]=sheetObj.GetCellValue(iCheckRow, DAR_NO);
		paramsArray[1]=sheetObj.GetCellValue(iCheckRow, MAPG_SEQ);
		paramsArray[2]=sheetObj.GetCellValue(iCheckRow, VER_SEQ);
		if (	paramsArray[0] == ComGetObjValue(formObj.dar_no) 
			&& 	paramsArray[2] == ComGetObjValue(formObj.ver_seq)	) {
			return ComShowCodeMessage("DMT01121");
		}
		opener.copyDARHistory(paramsArray);
		ComClosePopup();
     }
     
     function doActionClose() {
    	 ComClosePopup();
     }
     
  	 function initDisableControls(flag) {
  		 var formObj=document.form;
		 with(formObj) {
			 ComEnableManyObjects(false, rFANo, custCd, custNm);
			 rFANo.className="input2";
			 custCd.className="input2";
			 custNm.className="input2";
		 }
  	 }
