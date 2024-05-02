/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0937.js
*@FileTitle  : BKG CGO SPE Detail Popup - BB
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
/**
 * @fileoverview Defining scripts
 * @author author_name
 */
/**
 * @extends Bkg
 * @class ESD_TRS_0937 : 
 */
/*------------------ Defining general java script function   ------------------*/
// General global variable
var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;
/* Branch processing event handler with the name of button */
    function processButtonClick(){
         /***** Adding additional sheet variables to use more than one sheet per a tab *****/
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
        	    case "btng_apply":
        	        break;
        	    case "btn_close":
        	    	ComClosePopup(); 
        	        break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			errMsg=ComGetMsg("TRS90392" );
                ComShowMessage(errMsg);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    /**
 * Register IBSheet Object with array
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
* Setting sheets and initialization
* Implementing the onLoad event handler of body tag
* Adding the preceding function after loading page
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        var sheetObject=sheetObjects[0];
        var formObject=document.form;
        doActionIBSheet(sheetObject,formObject,IBSEARCH);
		initControl();
  }
	/**
      * Loading the event of HTML Control <br>
	 * {@link #loadPage} Initializing IBSheet Object <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     The order number of sheetObjects array
	 **/
	function initControl() {
	}
	/**
    * Using English character and number when onkeypress event occurs <br>
	 **/
	function engnum_keypress() {
	//    ComKeyOnlyAlphabet('uppernum');
	}
	/**
	 * BKG Creation <br>
	 **/
	function manual_click() {
	    //Activating Bkg_no to edit mode when manual check box is checked
	//    form.boo_bkg_no.readOnly =!form.manual.checked;
	}
	/**
	 * Processing when Booking number of tab BKG Creation is changed <br>
	 **/
	function bkgno_keyup() {
	    //Handling bl_no comparing with the saved data
	    /*
	    if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
		form.boo_bl_no.value="";
	    else
		form.boo_bl_no.value=form.hdn_boo_bl_no.value;
		*/
	}
	/**
	 * Validating the data when onblur event occurred <br>
	 **/
	function obj_blur(){
	//    return ComChkObjValid(event.srcElement);
	}
	/**
	 * Removing the separator when onfocus event occurred
	 **/
	function obj_focus(){
	//    ComClearSeparator(event.srcElement);
	}
	/**
	 * Processing to be input only number when onkeypress event occurred
	 **/
	function obj_keypress(){
	//    ComKeyOnlyNumber(event.srcElement);
	}
   /**
     * Define the initial values and headers of sheets
     * 
     * 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
              var HeadTitle0="Package|Package|Weight|Weight|Center of Gravity|Commodity|Commodity|Sling\nPoint|Cargo Packing\nDetail|Total Dimension (cm)|Total Dimension (cm)|Total Dimension (cm)"
              +"|Void Space\n(FEU)|Loading\nMethod|Shipping Crane\n(K.Ton)|Secure & Dunnage|Special Request|Remark";
              var HeadTitle1=" || ||Center of Gravity|| |Sling\nPoint|Cargo Packing\nDetail|Length|Width|Height"
              +"|Void Space\n(FEU)|Loading\nMethod|Shipping Crane\n(K.Ton)|Secure & Dunnage|Special Request|Remark";

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle0, Align:"Center"},
                          { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"pck_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"grs_wgt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"grav_ctr_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"cmdt_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"slng_pnt_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
                     {Type:"Text",      Hidden:0,  Width:150,  Align:"left",    ColMerge:1,   SaveName:"pck_dtl_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
                     {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"dim_len",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
                     {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"dim_wdt",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
                     {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"dim_hgt",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"void_slt_knt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cgo_lodg_mzd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"shp_crn_wgt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"scr_dng_ctnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
                     {Type:"Text",      Hidden:0,  Width:150,  Align:"left",    ColMerge:1,   SaveName:"spcl_rqst_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
                     {Type:"Text",      Hidden:0,  Width:150,  Align:"left",    ColMerge:1,   SaveName:"brk_cgo_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 } ];
               
              InitColumns(cols);

              SetEditable(0);
              SetRangeBackColor(1, 0, 1, 11,"#555555");// ENIS
              SetSheetHeight(ComGetSheetHeight(sheetObj, 12));
              }


                break;
        }
    }
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      //Retrieve
                if(validateForm(sheetObj,formObj,sAction))
                {
					formObj.f_cmd.value=SEARCH;
 					sheetObj.DoSearch("ESD_TRS_0937GS.do", TrsFrmQryString(formObj),{Sync:2} );
                }
                break;
           case IBLOADEXCEL:        //Excel upload
               sheetObj.LoadExcel();
              break;
        }
    }
   /**
    * Validating inputted values of form
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//   if (!ComIsNumber(iPage)) {
//
//       return false;
//   }
//        }
        return true;
    }
}