/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0235.js 
*@FileTitle  : MNR Release Order Transmission 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends  
     * @class EES_MNR_0235 : business script for EES_MNR_0235.
     */
/* developer job	*/	
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;    
var rdObjects=new Array();
var rdCnt=0;
var queryStr="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
	function processButtonClick(){
		var sheetObject=sheetObjects[0];
		var rdObject=rdObjects[0];
		/*******************************************************/
		var formObject=document.form;
    	try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_Print":
					printRd(rdObjects[0]);
					break;
				case "btn_DOCSend":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                	break;
				case "btn_Close":
					ComClosePopup(); 
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
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
		MnrWaitControl(true);
    	// initializing IBMultiCombo
    	for ( var k=0; k < comboObjects.length; k++) {
    		initCombo(comboObjects[k], k + 1);
    	}
    	// initializing IBSheet
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        // initializing RD
		initRdConfig(rdObjects[0]);
		// initializing
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		// initializing Axon event
		initControl();
        MnrWaitControl(false);
    }
	/**
	 * initializing  HTML Control event. <br>
	 **/
	function initControl() {
	    axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form); 
	    axon_event.addListenerFormat('focus',  		'obj_focus',    document.form); 
//	    axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);	
    }
  	/**
     * RD initail value
     * @param	{RdObject}	rdObject	RD Object 
     */
	function initRdConfig(rdObject){
	    var Rdviewer=rdObject ;
//		Rdviewer.AutoAdjust=true;
//		viewer.hideToolbar();
//		Rdviewer.HideStatusBar();
//		Rdviewer.ViewShowMode(0);
//		Rdviewer.SetBackgroundColor(128,128,128);
//		Rdviewer.SetPageLineColor(128,128,128);
	}
  	/**
     * IBsetting combo basic info
     * @param	{IBCombo}	comboObj	initializing ComboObject 
     * @param	{Number}	comboNo		ComboObject tag serial number
     */
    function initCombo(comboObj, comboNo) {
	    var cnt=0 ;
	    var formObject=document.form
	    switch(comboNo) {
	    	case 1: 
	            with (comboObj) { 
	    			SetColAlign(0, "left");
					SetDropHeight(160);
			    }
	            break;
	     } 
	}
	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {
	                var HeadTitle="|||||||";
	                var headCount=ComCountHeadTitle(HeadTitle);
	
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetVisible(false);
          		}
                break;
        }
    }
    /**
     * registering IBCombo Object as list
     * 
     * @param {IBCombo}
     *            combo_obj IBCombo Object as list
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++]=combo_obj;
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
     * checking on HTML Control's onblur event. <br>
     **/
    function obj_blur(){
		ComChkObjValid(ComGetEvent());
	}	
	/**
     * checking on HTML Control's focus event. <br>
     **/
    function obj_focus(){
		ComClearSeparator(ComGetEvent());
    }
	/**
	 * checking on HTML Control's onkeypress event. <br>
	 **/
	function obj_keypress(){
		obj=event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat;
		switch(obj.dataformat) {
			case "engup":
				ComKeyOnlyNumber(event.srcElement,"-,");
				break;
	    } 
	}
    /**
     * event in case of changing Transmission Type combo
     *  
     * @param comboObj
     * @param Index_Code
     * @param Text
     * @return
     */
    function trsm_mod_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
    	if(newCode=="F") {
			document.getElementById("iFax_no").style.display="inline";
			document.getElementById("iMnr_prnr_eml").style.display="none";
    	} else if(newCode=="M") {
			document.getElementById("iFax_no").style.display="none";
			document.getElementById("iMnr_prnr_eml").style.display="inline";
    	}
    	document.form.fax_no.value=faxNo;
    	document.form.mnr_prnr_eml.value=mnrPrnrEml;
    }
   /**
    * handling SaveEnd event on sheet1.
    * @param sheetObj
    * @param Row
    * @param Col
    * @param Value
    * @return
    */
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){  
		if (ErrMsg == "") { 		   
			ComShowCodeMessage("MNR00321"); 
			ComClosePopup(); 
		} else { 
			ComShowCodeMessage("MNR00076",ErrMsg);
		}			       
	}
  	/**
     * handling process sheet
     * @param	{IBSheet}	sheetObj	handling sheetObject 
     * @param	{Form}		formObj		handling formObject
     * @param	{Number}	sAction		Action constants  
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
        	//initializing
			case IBCLEAR:
				//retrieving combo 
				var sCondition=new Array (
					new Array("MnrGenCd","CD00016", "COMMON")	//Transmission Type
				); 
				var comboList=MnrComSearchCombo(sheetObj,sCondition);   
				//setting combo        
				for(var i=0; i<comboList.length ; i++){
					if(comboList[i] != null){
						var rowCnt=0;
						//Display[CODE_NAME]:Transmission Type 
						for(var j=0; j < comboList[i].length;j++){ 
							var tempText=comboList[i][j].split("|");
							if(tempText[0]=="F" || tempText[0]=="M") {
								comboObjects[i].InsertItem(rowCnt, tempText[1] ,tempText[0]);
								rowCnt++;
							}
						}
					}
				}
				//setting initial value
				trsm_mod_cd.SetSelectCode("F");//Transmission Type
				formObj.fax_no.value=faxNo;		//FAX
				formObj.mnr_prnr_eml.value=mnrPrnrEml;	//E-Mail
				//RD Display
				rdView(sheetObjects[0]);
	            break;
			//saving
			case IBSAVE:        
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=MULTI;
					sheetObjects[0].DataInsert(-1);
					sheetObj.DoSave("EES_MNR_0235GS.do", FormQueryString(formObj),-1,false);
				}
				break;
        }
    }
    /**
     * handling process for input validation
     * @param	{IBSheet}	sheetObj	checking sheetObject 
     * @param	{Form}		formObj		checking comboObject
     * @param	{Number}	sAction		Action constants  
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	switch(sAction) { 	
				case IBSAVE: 
					var trsmModCd=ComGetObjValue(formObj.trsm_mod_cd);
					var faxNo=ComGetObjValue(formObj.fax_no);
					var mnrPrnrEml=ComGetObjValue(formObj.mnr_prnr_eml);
					if(trsmModCd=="F" && (faxNo=="" || faxNo==null)) {
						ComShowCodeMessage("MNR00003");
						formObj.fax_no.focus();
						return false;
					} else if(trsmModCd=="M" && (mnrPrnrEml=="" || mnrPrnrEml==null)) {
						ComShowCodeMessage("MNR00003");
						formObj.mnr_prnr_eml.focus();
						return false;
					}
				 	break;	
			}		
        }
        return true;
    }
   /**
    * open RD
    * @param sheetObj
    * @param Row
    * @return
    */
	function rdView(sheetObj,Row) {
		var Rdviewer=rdObjects[0] ;
		var rdParam='/rv disp_no['+ dispNo +'] user_nm['+ userNm +'] mnr_prnr_cnt_cd['+ mnrPrnrCntCd +'] mnr_prnr_seq['+mnrPrnrSeq+']';
//		Rdviewer.AutoAdjust=false; 
        viewer.zoom = 100;  
//		Rdviewer.ApplyLicense("0.0.0.0"); 
		viewer.openFile(RD_path+'apps/opus/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0184.mrd', RDServer + rdParam, {timeout:1800});
	}
  	/**
     * print RD
     * @param	{RdObject}	rdObject	RD Object 
     */
	function printRd(rdObject){
	    var Rdviewer=rdObject ;
	    viewer.print({isServerSide:true});
	}	
