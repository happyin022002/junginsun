/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0086.js
*@FileTitle  : Tax Evidence 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class ESM_FMS_0086 : ESM_FMS_0086 definition of biz script for creation screen
 */
	// common global variables 
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event*/
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
        var sheetObject=sheetObjects[0];
        var sheetObject1=sheetObjects[1];
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_close":
					ComClosePopup(); 
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
     * * adding first-served functions after loading screen. 
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        initControl();
        sheet1_OnLoadFinish(sheetObjects[0]);
    }
    /**
     * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
     * * adding first-served functions after loading screen. 
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.SetWaitImageVisible(0);
    	CoFmsGetBizCombo('FORM', document.form, sheetObj, 'ofc_cd', 'ofc_nm', '11', 'ESM_FMS_0022GS.do', '');
        doActionIBSheet(sheetObj, document.form, IBSEARCH);
		sheetObj.SetWaitImageVisible(1);
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
            case 1:
                with(sheetObj){
	              var HeadTitle1=" |순번|품명|공급가액|세액|합계";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"tax_dtl_ser_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:440,  Align:"Left",    ColMerge:1,   SaveName:"itm_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",       Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"spl_amt",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"tax_amt",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",       Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"total_amt",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	               
	              InitColumns(cols);
	              SetEditable(0);
	              SetSheetHeight(120);
                }
            break;
        }
    }
    /**
     * Handling IBSheet's process(Retrieve, Save) <br>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form}    formObj Mandatory html form object
     * @param {int}     sAction mandatory,Constant Variable
     **/ 
    function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      
				formObj.f_cmd.value=SEARCH;
				var sXml=sheetObj.GetSearchData("ESM_FMS_0086GS.do" , FormQueryString(formObj));
  				var arrXml=sXml.split("|$$|");
	       		if (arrXml.length > 0) {
	       			sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
	       		}
	   			var taxInvYrmon=ComGetEtcData(sXml, "taxInvYrmon");
	   			var ofcCd=ComGetEtcData(sXml, "ofcCd");
	   			var docEvidTpCd=ComGetEtcData(sXml, "docEvidTpCd");
	   			var taxVatTpCd=ComGetEtcData(sXml, "taxVatTpCd");
	   			var taxNaidFlg=ComGetEtcData(sXml, "taxNaidFlg");
	   			var taxDivCd=ComGetEtcData(sXml, "taxDivCd");
	   			var faFlg=ComGetEtcData(sXml, "faFlg");
	   			var taxPlCd=ComGetEtcData(sXml, "taxPlCd");
	   			var taxNslFlg=ComGetEtcData(sXml, "taxNslFlg");
	   			var splRgstNo=ComGetEtcData(sXml, "splRgstNo");
	   			var ownrNm=ComGetEtcData(sXml, "ownrNm");
	   			var coNm=ComGetEtcData(sXml, "coNm");
	   			var bzctNm=ComGetEtcData(sXml, "bzctNm");
	   			var bztpNm=ComGetEtcData(sXml, "bztpNm");
	   			var splAddr=ComGetEtcData(sXml, "splAddr");
	   			var issDt=ComGetEtcData(sXml, "issDt");
	   			var splAmt=ComGetEtcData(sXml, "splAmt");
	   			var taxAmt=ComGetEtcData(sXml, "taxAmt");
	   			var totalAmt=ComGetEtcData(sXml, "totalAmt");
	   			if(typeof taxInvYrmon != "undefined" && taxInvYrmon != "" ) {
	   				formObj.tax_inv_yrmon.value=taxInvYrmon;
	   				setOfcCd(ofcCd);
	   				if(typeof docEvidTpCd != "undefined" && docEvidTpCd != "" ) {
		   				if(docEvidTpCd == "PAPER") {
		   					formObj.tax_iss_cd[1].checked=true;
		   				} else {
		   					formObj.tax_iss_cd[0].checked=true;
		   				}
	   				}
		   			if(typeof taxVatTpCd != "undefined" && taxVatTpCd != "" ) {
		   				if(taxVatTpCd == "1") {
		   					formObj.tax_vat_tp_cd[0].checked=true;
		   				} else {
		   					formObj.tax_vat_tp_cd[1].checked=true;
		   				}
		   				if(taxPlCd == "1") {
			   				formObj.tax_pl_cd[0].checked=true;
			   			} else {
			   				formObj.tax_pl_cd[1].checked=true;
			   			}
		   			} else {
		   				document.all.l_evid_tp_cd.style.display="none";
		   				formObj.tax_pl_cd[0].checked=true;
		   	        	sheetObjects[0].SetColHidden("tax_amt",1);
		   			}
		   			if(taxDivCd == "1") {
		   				formObj.tax_div_cd[0].checked=true;
		   			} else {
		   				formObj.tax_div_cd[1].checked=true;
		   			}
		   			formObj.spl_rgst_no.value=splRgstNo;
		   			if(typeof ownrNm != "undefined" && ownrNm != "" ) {
		   				formObj.ownr_nm.value=ownrNm;
		   			}
		   			if(typeof coNm != "undefined" && coNm != "" ) {
		   				formObj.co_nm.value=coNm;
		   			}
		   			if(typeof bzctNm != "undefined" && bzctNm != "" ) {
		   				formObj.bzct_nm.value=bzctNm;
		   			}
		   			if(typeof bztpNm != "undefined" && bztpNm != "" ) {
		   				formObj.bztp_nm.value=bztpNm;
		   			}
		   			if(typeof splAddr != "undefined" && splAddr != "" ) {
		   				formObj.spl_addr.value=splAddr;
		   			}
		   			formObj.iss_dt.value=issDt;
		   			formObj.spl_amt.value=splAmt;
		   			formObj.tax_amt.value=taxAmt;
		   			formObj.total_amt.value=totalAmt;
	   			} else {
	   				setOfcCd(ofcCd);
	   			}
                break;
        }
    }
    /**
     * Loading Event of HTML_Control existing on page dynamically <br>
     * Calling the function from {@link #loadPage} to initialize IBSheet Object <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sequence of sheetObjects array
     **/
    function initControl() {
    	DATE_SEPARATOR="-";
    	axon_event.addListener  ('change', 'spl_rgst_no_change', 'spl_rgst_no');	// Getting Name information after inserting Vessel Code
        axon_event.addListenerForm  ('blur'            ,'obj_deactivate', form); 	//- form Code Handling to OnBeforeDeactivate(blur) Event of All Controls
    }
    /**
     * Only insert Numeric by onkeypress Event of HTML Control <br>
     **/
    function spl_rgst_no_change()
    {
    	
    }
    /**
     * Only insert English and Numefic by onkeypress Event of HTML Control <br>
     **/
    function eng_keypress() {
        ComKeyOnlyAlphabet('upper');
    }
    /**
     * Only insert English and Numefic by onkeypress Event of HTML Control <br>
     **/
    function eng_num_keypress() {
        ComKeyOnlyAlphabet('uppernum');
    }
    /**
     * Checking Validation in onblur Event of HTML Control <br>
     **/
    function obj_deactivate(){
    	switch(ComGetEvent().name){
	    	case "tax_inv_yrmon": 
	    	case "iss_dt": 	
	    		ComChkObjValid(ComGetEvent());
    			break;
    	}
    }
    /**
     * Removing Mask Separator in onfocus Event of HTML Control <br>
     **/
    function obj_activate(){
    	ComClearSeparator(ComGetEvent());
    }
    /**
     * Setting Office Code <br>
     * @return none
     **/
    function setOfcCd(ofcCd) {
    	if(typeof ofcCd == "undefined" || ofcCd == "") {
    		var length=form.ofc_cd.length;
    		for(var i=0; i<length; i++){ 
        		form.ofc_cd.options.remove(0); 
        	}
    	} else {
	    	var length=form.ofc_cd.length;
			if(length > 0) {
				for(var i=0; i<length; i++) {
					if(form.ofc_cd.options[i].value == ofcCd) {
						form.ofc_cd.selectedIndex=i;
						break;
					}
				}
			}
    	}
		form.ofc_cd.disabled=true;
    }