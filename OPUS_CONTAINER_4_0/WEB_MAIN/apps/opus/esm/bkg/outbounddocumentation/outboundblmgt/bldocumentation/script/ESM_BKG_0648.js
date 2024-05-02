/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0648.js
*@FileTitle  : BL Copy 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
*/

/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					          MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					          Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
/**
  * @fileoverview 
  * @author CLT
  */
/**
 * @extends 
 * @class ESM_BKG_0648 : ESM_BKG_0648 - task script definition for screen
 */
    function ESM_BKG_0648() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    // public variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
       document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
        /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var obj = event.target || event.srcElement;
        var formObject=document.form;
        if ($(obj).prop('disabled')) { 
        	  return;
        	 }
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            var btnFlag=ComIsBtnEnable(srcName);
        	switch(srcName) {
	            case "btn_add":  //Row Add
	        		sheetObject1.DataInsert(-1);
	            	break;
	            case "btn_delete":  //Row Delete
	            	ComRowDeleteComplete(sheetObject1, "chk", 1);
	                break;
                case "btn_retrieve":  //Retrieve
	            	formObject.elements["bkg_no"].value=ComTrim(formObject.elements["bkg_no"].value);
	            	formObject.elements["s_bkg_no"].value=ComTrim(formObject.elements["s_bkg_no"].value);
                	doActionIBSheet(sheetObject1,document.form,IBSEARCH);
                    break;
                case "btn_new":  //New
                	sheetObject1.RemoveAll();
                	formObject.reset();
                    break;
                case "btn_copy":  //Copy
                	formObject.elements["bkg_no"].value=ComTrim(formObject.elements["bkg_no"].value);
	            	formObject.elements["s_bkg_no"].value=ComTrim(formObject.elements["s_bkg_no"].value);
                	// retrieve check
                	if (""==formObject.elements["bkg_no"].value ||
                		formObject.elements["bkg_no"].value != formObject.elements["s_bkg_no"].value) {
	            		ComShowCodeMessage("BKG00255");  //"Booking Number is not available."
	            		ComSetFocus(formObject.s_bkg_no);
	                	ComBtnEnable(srcName);
	                	return;
                	}
                	//Copy Item check
            		if (!formObject.elements["cust_flg"].checked &&
            			!formObject.elements["mark_flg"].checked &&
            			!formObject.elements["desc_flg"].checked) {
            			ComShowCodeMessage("BKG00412");  //"Click item that you want to copy first"
                    	ComBtnEnable(srcName);
            			return;
            		}
           		    //Copy check
           			if (0==sheetObject1.RowCount()) {
        				ComShowCodeMessage("BKG00411");  //"Input 'Copy To' booking number"
                    	ComBtnEnable(srcName);
            			return;
            		}
            		//check grid validation
            		if (!checkValidation(formObject,sheetObject1)) {
            			ComBtnEnable(srcName);
            			return;
            		}
                	//CONFIRM
                	if (!ComShowCodeConfirm("BKG00410")) {  //"Do you want to copy the B/L data ?"
                    	ComBtnEnable(srcName);
                		return;
                	}
           		    //copy
                	doActionIBSheet(sheetObject1,document.form,IBSAVE);
                    break;
                case "btn_Close":  //Close
                	ComClosePopup(); 
	                break;
            }  //end switch
            if (btnFlag) {
            	ComBtnEnable(srcName);
            } else {
            	ComBtnDisable(srcName);
            }
        } catch(e) {
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
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for (i=0;i<sheetObjects.length;i++) {
        	ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
    	initControl();
    	ufGetBkgNo(sheetObjects[0]);
    }
    /**
     * load HTML Control event on the page <br>
     * {@link #loadPage}call the function and init IBSheet Object <br>
     * 
     * @param {ibsheet}
     *            sheetObj IBSheet Object
     * @param {int}
     *            sheetNo sheetObjects 
     */
    function initControl() {
    	var formObject=document.form;
    	// Axon Event process1 Event catch(Develoer can change)
    	ComBtnDisable("btn_copy");
    	//axon_event.addListenerFormat("keypress", "obj_KeyPress", formObject); //- in case of keyboard input
    	//axon_event.addListener("keydown", "ComKeyEnter", "form");
    	//axon_event.addListenerForm("beforedeactivate", "obj_deactivate",  formObject); //- focus in
    }
    function obj_deactivate() {
    	if ("s_bkg_no"== ComGetEvent()) {
        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	}
    }
    /**
     * setting sheet initial values and header
     * param : sheetObject, sheetNo 
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObject,sheetNo) {
        var cnt=0;
        var sheetID=sheetObject.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObject){
	              var HeadTitle="|Sel.|Booking No.|Booking No.|Result";
	              var headCount=ComCountHeadTitle(HeadTitle);
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	                     {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"copy_bkg_no",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
	                     {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"bkgPop",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"resultMsg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	              InitColumns(cols);
	              SetEditable(1);
	              SetShowButtonImage(2);
	              SetSheetHeight(145);
	              }
            break;
        }
    }
    //handling sheet process
    function doActionIBSheet(sheetObject,formObject,sAction) {
    	sheetObject.ShowDebugMsg(false);
    	var sXml;
        switch(sAction) {
            case IBSEARCH:  //retrieve
                if (!validateForm(sheetObject,formObject,sAction)) return;
	            ComSetObjValue(formObject.elements["f_cmd"], SEARCH);
	            sXml=sheetObject.GetSearchData("ESM_BKG_0648GS.do", FormQueryString(formObject));
	            var xmlDoc = ComGetXmlDoc(sXml);
	            if (xmlDoc == null)
	            	return;
				var xmlRoot = xmlDoc.documentElement;
				if (xmlRoot && 1 < xmlRoot.getElementsByTagName("ETC-DATA").item(0).childNodes.length) {
					ComEtcDataXmlToForm(sXml, formObject);
	            	ComBtnEnable("btn_copy");
				} else {  
					ComShowCodeMessage("BKG08017");  //BKG No. not exists
		            if (!ComIsEmpty(formObject.elements["bkg_no"].value)) {
			            ComSetObjValue(formObject.elements["s_bkg_no"], formObject.elements["bkg_no"].value);
		            	ComBtnEnable("btn_copy");
		            } else {
		            	ComBtnDisable("btn_copy");
		            }
//		            formObject.elements["s_bkg_no"].focus();
				}
                break;
            case IBSAVE:  //copy
                if (!validateForm(sheetObject,formObject,sAction)) return;
	            ComSetObjValue(formObject.elements["f_cmd"], MULTI01);
	            ComSetObjValue(formObject.elements["bkg_no"], formObject.elements["s_bkg_no"].value);
	            sXml=sheetObject.GetSaveData("ESM_BKG_0648GS.do", ComGetSaveString(sheetObject,true,true) + "&" + FormQueryString(formObject));
  				sheetObject.LoadSearchData(sXml,{Sync:1} );
  				break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObject,formObject,sAction) {
        with(formObject){
			if (!ComChkValid(formObject)) return false;
        }
        return true;
    }
    /*
    function sheet1_OnSearchEnd(sheetObject, ErrMsg) {
        with(sheetObject) {
            SetColFontUnderline("copy_bkg_no",1);
        }
    }
    */
    //check grid validation
    function checkValidation(formObject,sheetObject) {
		for (var i=1; i<=sheetObject.RowCount(); i++) {
			//empty
			if (ComIsEmpty(sheetObject.GetCellValue(i,2))) {
				ComShowCodeMessage("BKG00411");  //"Input 'Copy To' booking number"
				sheetObject.SelectCell(i,2);
				return false;
			} else if (11>ComGetLenByByte(sheetObject.GetCellValue(i,2)) || 13<ComGetLenByByte(sheetObject.GetCellValue(i,2))) {
				ComShowCodeMessage("BKG00381");  //"Incorrect Data Length"
				sheetObject.SelectCell(i,2);
				return false;
			} else if (formObject.elements["bkg_no"].value==sheetObject.GetCellValue(i,2)) {
				ComShowCodeMessage("BKG08019");  //"Please Check BKG No."
				sheetObject.SelectCell(i,2);
				return false;
			}
			//exited data check
			for (var j=sheetObject.RowCount(); 0<j; j--) {
				if (i!=j && sheetObject.GetCellValue(i,2)==sheetObject.GetCellValue(j,2)) {
				ComShowCodeMessage("BKG04008");  //"The Data you input were already exsited. Please check it again";
				sheetObject.SelectCell(j,2);
				return false;
    			}
    		}
		}
		return true;
    }
    //get bkg_no from opener 
    function ufGetBkgNo(sheetObj) {
    	if ("Y"==document.form.isPop.value && opener && opener.sheetObjects[0]) {
	    	var sRow=opener.sheetObjects[0].FindCheckedRow("slct_flg");
	    	var arrRow=sRow.split("|");
			for(var i=0; i < arrRow.length; i++) {
        		var row=sheetObj.DataInsert(-1);
        		sheetObj.SetCellValue(row,"copy_bkg_no", opener.sheetObjects[0].GetCellValue(arrRow[i],"bkg_no"),0);
			}
    	}
    }
    //call BKG main popup
	function sheet1_OnPopupClick(sheetObject, row, col) {
		if ("bkgPop"==sheetObject.ColSaveName(col)) {
			var bkg_no=sheetObject.GetCellValue(row, "copy_bkg_no");
			if (""==bkg_no) {
				ComShowCodeMessage("BKG08017");  //BKG No. not exists
				return;
			}
			comBkgCallPopBkgDetail(bkg_no,false);
		}
	}
