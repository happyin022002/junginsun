/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0005.js
*@FileTitle  : Customer Code Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
/****************************************************************************************
 event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Customer Code Entry : Customer Code Entry definition of biz script for creation screen
     */
	//  common global variables 
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1; 
	var sheetObjects=new Array();
	var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name  */
    function processButtonClick(){
    	var sheetObject=sheetObjects[0];
       var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
          	switch(srcName) {
            	case "btn_retrieve":
	             	if(!CoFmsInitConfirm(sheetObject)) return;
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;
				case "btn_new":
	             	if(!CoFmsInitConfirm(sheetObject)) return;
					ComResetAll();
					sheetObject.RemoveAll();
                break;
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
                break;
				case "btn_savetofile":
					sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
                break;
				case "btn_print":
					alert("btn_print");
                break;
				case "btn_add":
					if(!validateForm(sheetObject,formObject)) return;
					var row=sheetObject.DataInsert(-1);
//					sheetObject.Cellvalue(row, "flet_ownr_tp_cd")='';
					sheetObject.SelectCell(row, "cust_cnt_cd");
                break;
				case "btn_ins":
					if(!validateForm(sheetObject,formObject)) return;
					var row=sheetObject.DataInsert();
//					sheetObject.Cellvalue(row, "flet_ownr_tp_cd")='';
					sheetObject.SelectCell(row, "cust_cnt_cd");
					break;
				case "btn_del":
					if(checkBoxCheckYn(sheetObject, "DelChk")) { 
						ComRowHideDelete(sheetObject, "DelChk"); 
					}
                break;
          } // end switch
    	}catch(e) {
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
     * adding first-served functions after loading screen. 
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
           ComConfigSheet (sheetObjects[i] );
           initSheet(sheetObjects[i],i+1);
           ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        sheet1_OnLoadFinish(sheet1);
    }
    /**
     * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
     * Handling Sheet1 OnLoadFinish Event
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.SetWaitImageVisible(0);
    	doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "flet_ownr_tp_cd");
		sheetObj.SetWaitImageVisible(1);
    }
	/**
     * Loading Event of HTML_Control existing on page dynamically <br>
     * Calling the function from {@link #loadPage} to initialize IBSheet Object<br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sequence of sheetObjects array
     **/
    function initControl() {
    	DATE_SEPARATOR="/";
    }

     /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
//              (10, 0, 0, true);
              var HeadTitle="|Sel|Seq|Customer Code|Customer Code|Chartered Company Name|Head Ownership Name|Head Ownership Name|Owner Type|Korea Tax Required";

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                     {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
                     {Type:"Text",      Hidden:0,  Width:290,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"flet_mgmt_ownr_cust_seq" },
                     {Type:"Popup",     Hidden:0, Width:260,  Align:"Left",    ColMerge:0,   SaveName:"ownr_nm",                  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"flet_ownr_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"tax_required",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetShowButtonImage(2);
              SetColProperty("cust_seq", {Format:"######"} );
              SetSelectionMode(smSelectionRow);
              SetDataLinkMouse("cust_seq",1);
              SetDataLinkMouse("ownr_nm",1);
//              SetSheetHeight(500);
              resizeSheet();
              }
                break;
         }
     }
   /**
     * Handling IBSheet's process(Retrieve, Save) <br>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form}    formObj Mandatory html form object
     * @param {int}     sAction mandatory,Constant Variable
     * @param {String}  gubun     	gubun value
     **/  
    function doActionIBSheet(sheetObj,formObj, sAction, Col, Row) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
         	case IBSEARCH:      
        		formObj.f_cmd.value=SEARCH;
        		sheetObj.DoSearch("ESM_FMS_0005GS.do", FormQueryString(formObj) );
                break;
           	case IBSAVE:        
	 			if(!validateForm(sheetObj,formObj,sAction))return;
	 			formObj.f_cmd.value=MULTI;
	 			sheetObj.DoSave("ESM_FMS_0005GS.do", FormQueryString(formObj));
                break;
			case IBROWSEARCH:   
				if (Col == "flet_ownr_tp_cd") {//Owner Type
					formObj.f_cmd.value=SEARCH01;
					var sXml=sheetObj.GetSearchData("ESM_FMS_0006GS.do" , FormQueryString(formObj));
		   			var comboCode=ComGetEtcData(sXml, "comboCode");
		   			var comboText=ComGetEtcData(sXml, "comboText");
		   			if(typeof comboCode == "undefined") {
	    				comboCode="";
	    				comboText="";
	    			}
	    			setMakeCombo(sheetObj, comboText, comboCode, Col);
	    		} else if (Col == "cust_seq") {// Inserting Vendor/Customer code directly
					formObj.f_cmd.value=SEARCH01;
					var sXml=sheetObj.GetSearchData("ESM_FMS_0070GS.do" , FormQueryString(formObj)+"&cond_flag=CM&cd_cnt="+sheetObj.GetCellValue(Row,"cust_cnt_cd")+"&cd_seq="+sheetObj.GetCellValue(Row,Col));
	    			setVendorCustomerName(sheetObj, sXml, Row, Col);
				}
        }
    }
    /**
     * Making Type Combo box <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboText   name of Type
     * @param {String}  comboCode   code of Type
     * @param {int}  	col   		column index
     **/
    function setMakeCombo(sheetObj, comboText, comboCode, Col) {
    	if(comboText != "" ) {
    		var typeText=comboText.substring(0,comboText.length-1);
    		var typeCode=comboCode.substring(0,comboCode.length-1);
        	sheetObj.SetColProperty(Col, {ComboText:typeText, ComboCode:typeCode} );
    	}
    }
    /**
     * Setting Vendor/Customer information <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboText   name of Type
     * @param {String}  comboCode   code of Type
     * @param {int}  	col   		column index
     **/
    function setVendorCustomerName(sheetObj, sXml, Row, Col) {
    	if (sXml != "" ) {
			if (ComGetEtcData(sXml, "cdName") != undefined) {
				sheetObj.SetCellValue(Row,"cust_lgl_eng_nm",ComGetEtcData(sXml, "cdName"));
	    	} else {
				sheetObj.SetCellValue(Row,"cust_seq",'',0);
				sheetObj.SetCellValue(Row,"cust_lgl_eng_nm",'',0);
				sheetObj.SetCellValue(Row,"tax_required",'',0);
				ComShowCodeMessage('FMS01335');
				sheetObj.SelectCell(Row, Col);
	    	}
	    }		
    }
     /**
      * Handling process for input validation
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
      * IBSheet Object에서 팝업을 클릭시
      */
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	}	
    /**
      * In case of Clicking Popup in IBSheet Object
      */
 	function sheet1_OnPopupClick(sheetObj, Row,Col)
 		{
 			if (sheetObj.ColSaveName(Col) == "cust_seq") {
 				ComOpenPopup("ESM_FMS_0070.do?condFlag=CP", 550, 432, "setCustomrCode", "1,0,1,1,1,1", true, false, Row, Col, 0, "ESM_FMS_0070");
 			} else if (sheetObj.ColSaveName(Col) == "ownr_nm") {
 				ComOpenPopup("ESM_FMS_0083.do", 500, 375, "setOwnerName", "1,0,1,1,1,1", true, false, Row, Col, 0, "ESM_FMS_0083");
 			}
 		}
     /**
      * In case there is a change in input value in IBSheet Object
      */
 	function sheet1_OnChange(sheetObj,Row, Col, Value)
 		{
 			if (sheetObj.ColSaveName(Col) == "cust_cnt_cd" || sheetObj.ColSaveName(Col) == "cust_seq") {
 				if (sheetObj.GetCellValue(Row,"cust_cnt_cd") != '' && sheetObj.GetCellValue(Row,"cust_seq") != '') {
					sheetObj.SetCellValue(Row,"cust_lgl_eng_nm",'');
					sheetObj.SetCellValue(Row,"tax_required",'');
	        		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "cust_seq", Row);
				}
 			}
 		}
	/**
	 * Insert Customer Code<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setCustomrCode(aryPopupData, Row, Col, sheetIdx){
		sheetObjects[0].SetCellValue(Row,Col,aryPopupData[0][5],0);
		sheetObjects[0].SetCellValue(Row,"cust_lgl_eng_nm",aryPopupData[0][3],0);
		sheetObjects[0].SetCellValue(Row,"cust_cnt_cd",aryPopupData[0][4],0);
	}
	/**
	 * Insert Owner Name <br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setOwnerName(aryPopupData, Row, Col, sheetIdx){
		sheetObjects[0].SetCellValue(Row,Col,aryPopupData[0][4],0);
		sheetObjects[0].SetCellValue(Row,"flet_mgmt_ownr_cust_seq",aryPopupData[0][3],0);
		sheetObjects[0].SetCellValue(Row,"flet_ownr_tp_cd",aryPopupData[0][5],0);
	}

	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}	