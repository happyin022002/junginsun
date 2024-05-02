/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0122.js
*@FileTitle  : MOT Surcharge Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/18
=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var popupRow = 0;

//-------------------------------------
//Event handler processing by button click event
//-------------------------------------
document.onclick=processButtonClick;

//-------------------------------------
//Init Area
//-------------------------------------
/**
* initializing sheet <br>
* implementing onLoad event handler in body tag <br>
* adding first-served functions after loading screen. <br>
* <br><b>Example :</b>
* <pre>
*     loadPage();
* </pre>
* @return void
* @author 
* @version 2014.11.18
*/
function loadPage() {
    var formObj=document.form;
    // IBSheet Initialize
    for(i=0;i<sheetObjects.length;i++){
        //Modify Environment Setting Function's name
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        //Add Environment Setting Function
        ComEndConfigSheet(sheetObjects[i]);
    }
    // IBMultiCombo Initialize
    for ( var k=0; k < comboObjects.length; k++) {
        initCombo(comboObjects[k], k + 1);
    }
    // Axon Event Initialize
    initControl();    
    // Combo Initialize
    initIBComboItem();
}

//-------------------------------------
//Common Function Area for Init
//-------------------------------------
/**
* registering IBSheet Object as list <br>
* <pre>
*     setSheetObject(sheetObj);
* </pre>
* @param {ibsheet} sheet_obj mandatory IBSheet Object
* @return void
* @author 
* @version 2014.11.18
*/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * registering IBMultiCombo Object as list <br>
 * adding process for list in case of needing batch processing with other items<br>
 * defining list on the top of source <br>
 * <br><b>Example :</b>
 * <pre>
 *     setComboObject(combo_Obj);
 * </pre>
 * @param {ibcombo} combo_obj Mandatory IBMultiCombo Object
 * @return void
 * @author 
 * @version 2009.06.04
 */
function setComboObject(combo_obj) {
    comboObjects[comboCnt++]=combo_obj;
}

/**
* Catching events for Axon event.<br>
* <br><b>Example :</b>
* <pre>
*     initControl()
* </pre>
* @param  void
* @return void
* @author 
* @version 2010.10.13
*/         
function initControl() {
	 // Process Axon Event No.1, Event Catch            
	 axon_event.addListenerForm('blur', 'obj_deactivate', document.form);
}

/**
 * setting intial combo value <br>
 * adding case as numbers of counting combo<br>
 * <br><b>Example :</b>
 * <pre>
 *     initCombo(comboObj,1);
 * </pre>
 * @param {object} comboObj Mandatory IBMultiCombo Object
 * @param {int} comboNo Mandatory IBMultiCombo Object ,Serial no for Tag's ID
 * @return void
 * @author 
 * @version 2009.06.04
 */
function initCombo(comboObj, comboNo) {
    switch (comboObj.options.id) {
        case "chg_cd":
            var i=0;
            with (comboObj) {
                SetDropHeight(200);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetUseAutoComplete(1);
                SetMaxLength(3);
                ValidChar(2);
            }
            break;
    }
}

/**
 * Setting retrieved items to IBMultiCombo<br>
 * <br><b>Example :</b>
 * <pre>
 *     initIBComboItem ();
 * </pre>
 * @return void
 * @author 
 * @version 2009.06.04
 */
function initIBComboItem() {
    var formObj = document.form;
	
	//chg_cd
	ComPriTextCode2ComboItem(chgCdComboValue, chgCdComboText, getComboObject(comboObjects, 'chg_cd'),"|","\t");
    chg_cd.SetSelectIndex(0, true);
    //access date
    formObj.acc_dt.value = setInitDate();
    
}

/**
 * setting sheet initial values and header <br>
 * adding case as numbers of counting sheets  <br>
 * <br><b>Example :</b>
 * <pre>
 *     initSheet(sheetObj,1);
 * </pre>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @param {int} sheetNo mandatory IBSheet Object Serial No
 * @return void
 * @author 
 * @version 2014.11.18
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    var sheetID=sheetObj.id;
    switch(sheetID) {
        case "sheet1":
            with(sheetObj){
                var HeadTitle="||Seq.|POL|Customer Code|Customer Name|SOC|Cargo\ntype|Container\nType|Service\nLane|Lane|Pay term|Agent Code|Effective\nDate|Expire\nDate|Cur.|20|40|45|A|B|C|D|E";
                var headCount=ComCountHeadTitle(HeadTitle);
                
                SetConfig( { MergeSheet:1, Page:20, ComboMaxHeight: 120 } );
                
                var info    = { Sort:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [
                            {Type:"Status",		Hidden:1,	Width:40,	Align:"Left",	ColMerge:0,	SaveName:"ibflag",	        	KeyField:0, CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                            {Type:"DummyCheck",	Hidden:0, 	Width:30,   Align:"Center", ColMerge:0, SaveName:"chk" 		},
                            {Type:"Seq",    	Hidden:0, 	Width:40,   Align:"Center", ColMerge:0, SaveName:"seq"		},
                            {Type:"Text",   	Hidden:0, 	Width:80,   Align:"Center", ColMerge:0, SaveName:"pol_cd",				KeyField:1, CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:0,   InsertEdit:1,	EditLen:5, AcceptKeys:"E",		InputCaseSensitive:1 },
                            {Type:"PopupEdit",  Hidden:0, 	Width:120,  Align:"Center", ColMerge:0, SaveName:"cust_cnt_cd_seq",		KeyField:0, CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:8, AcceptKeys:"N|E",	InputCaseSensitive:1 },
                            {Type:"Text",   	Hidden:0, 	Width:390,  Align:"Left", 	ColMerge:0, SaveName:"cust_nm", 			KeyField:0, CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Combo",  	Hidden:0, 	Width:50,   Align:"Center", ColMerge:0, SaveName:"soc_flg",         	KeyField:0, CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:1 },
                            {Type:"Combo",  	Hidden:0, 	Width:50,   Align:"Center", ColMerge:0, SaveName:"prc_cgo_tp_cd",       KeyField:0, CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:2 },
                            {Type:"Combo",  	Hidden:0, 	Width:70,   Align:"Center", ColMerge:0, SaveName:"mot_file_cntr_tp_cd", KeyField:0, CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:2 },
                            {Type:"Combo",  	Hidden:0, 	Width:50,   Align:"Center", ColMerge:0, SaveName:"mot_file_lane_cd",    KeyField:0, CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:2 },
                            {Type:"PopupEdit",  Hidden:0, 	Width:60,   Align:"Center", ColMerge:0, SaveName:"vsl_slan_cd",		    KeyField:0, CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:3, AcceptKeys:"N|E",	InputCaseSensitive:1 },
                            {Type:"Combo",  	Hidden:0, 	Width:100,  Align:"Center", ColMerge:0, SaveName:"pay_term_cd",         KeyField:0, CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:1 },
                            {Type:"Text",   	Hidden:0, 	Width:100,  Align:"Left", 	ColMerge:0, SaveName:"agn_cd",				KeyField:0, CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:6, AcceptKeys:"N|E",	InputCaseSensitive:1 },
                            {Type:"Date",  		Hidden:0, 	Width:90,   Align:"Center", ColMerge:0, SaveName:"eff_dt",         		KeyField:1, CalcLogic:"",   Format:"Ymd",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:10 },
                            {Type:"Date",  		Hidden:0, 	Width:90,   Align:"Center", ColMerge:0, SaveName:"exp_dt",         		KeyField:0, CalcLogic:"",   Format:"Ymd",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:10 },
                            
                            {Type:"Combo",  	Hidden:0, 	Width:70,   Align:"Center", ColMerge:0, SaveName:"curr_cd",         	KeyField:1, CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:3 },
                            {Type:"Int", 		Hidden:0, 	Width:100,  Align:"Right", 	ColMerge:0, SaveName:"cntr_20ft_rt_amt",   	KeyField:0, CalcLogic:"",   Format:"Integer",	PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Int", 		Hidden:0, 	Width:100,  Align:"Right", 	ColMerge:0, SaveName:"cntr_40ft_rt_amt",   	KeyField:0, CalcLogic:"",   Format:"Integer",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Int",    	Hidden:0, 	Width:100,  Align:"Right", 	ColMerge:0, SaveName:"cntr_45ft_rt_amt",   	KeyField:0, CalcLogic:"",   Format:"Integer",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 },

                            {Type:"Text",   	Hidden:1, 	Width:50,   Align:"Left",   ColMerge:0, SaveName:"cust_cnt_cd",     	KeyField:0, CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",   	Hidden:1, 	Width:50,   Align:"Left", 	ColMerge:0, SaveName:"cust_seq",      		KeyField:0, CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",   	Hidden:1, 	Width:50,  	Align:"Left",   ColMerge:0, SaveName:"chg_cd",			    KeyField:0, CalcLogic:"",   Format:"",   		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",   	Hidden:1, 	Width:50,   Align:"Left",	ColMerge:0, SaveName:"chg_rt_seq",      	KeyField:0, CalcLogic:"",   Format:"",   		PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
                ];
                   
                InitColumns(cols);
                
                SetColProperty( "curr_cd", 				{ComboText:currCdText, 		ComboCode:currCdValue} );
                SetColProperty( "soc_flg", 				{ComboText:socFlgText, 		ComboCode:socFlgValue} );
                SetColProperty( "prc_cgo_tp_cd", 		{ComboText:cgoTpCdText, 	ComboCode:cgoTpCdValue} );
                SetColProperty( "mot_file_cntr_tp_cd", 	{ComboText:cntrTpCdText, 	ComboCode:cntrTpCdValue} );
                SetColProperty( "mot_file_lane_cd", 	{ComboText:laneCdText, 		ComboCode:laneCdValue} );
                SetColProperty( "pay_term_cd", 			{ComboText:payTermCdText, 	ComboCode:payTermCdValue} );
                
                SetEditable(1);		//All Cell Editible
                SetSelectionMode(0);//select Cell Mode
                SetShowButtonImage(2);
                resizeSheet();
            }
            break;   
    }
}

//-------------------------------------
//Event Area
//-------------------------------------
/**
 * Event handler processing by button name  <br>
 * <br><b>Example :</b>
 * <pre>
 *     processButtonClick();
 * </pre>
 * @return void
 * @author 
 * @version 2014.11.18
 */
function processButtonClick() {
    var sheetObject1=sheetObjects[0];
    var formObj=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        
        switch (srcName) {
            //Main Button
            case "btn_retrieve":
                doActionIBSheet(sheetObject1,formObj,IBSEARCH);
                break;
            case "btn_new":
                doActionIBSheet(sheetObject1,formObj,IBCLEAR);
                break;
            case "btn_save":
                doActionIBSheet(sheetObject1,formObj,IBSAVE);
                break;          
            
            //Buttons related Sheet
            case "btn_copy":
                doActionIBSheet(sheetObject1,formObj,IBCOPYROW);
                break;
            case "btn_add":
                doActionIBSheet(sheetObject1,formObj,IBINSERT);
                break;
            case "btn_del":
                doActionIBSheet(sheetObject1,formObj,IBDELETE);
                break;

            
            //ETC buttons
            case "btns_calendar1": //calendar button
	            var cal=new ComCalendar();                
	            cal.select(formObj.acc_dt, 'yyyy-MM-dd');
	            break;

        }
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
        }
    }
}


/**
 * Handling Onbeforedeactivate  event <br>
 * <br><b>Example :</b>
 * <pre>
 *     obj_deactivate()
 * </pre>
 * @param N/A
 * @return N/A
 * @author 
 * @version 2014.11.18
 */   
 function obj_deactivate() {
	 
	 var formObj=document.form;
     var sheetObj1=sheetObjects[0]; 
     var eleName=ComGetEvent("name");
     switch(eleName){

                  
         default:
        	 break;

     }
	 
	 
 }
 
 /**
  * Calling Function in case of OnChange event <br>
  * Display the Description of selected code when chg_cd combo modified. <br>
  * <br><b>Example :</b>
  * <pre>
  *
  * </pre>
  * @param {object} comboObj Mandatory IBMultiCombo Object
  * @param {string} value Mandatory, value of selected item
  * @param {string} text Mandatory selected item's text
  * @returns void
  * @author 
  * @version 2009.06.04
  */
 function chg_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
     var formObj=document.form;

     if (NewTxt != null && NewTxt.length > 0) {
         formObj.chg_nm.value=comboObj.GetText(NewCod, 1);
     } else {
     	formObj.chg_nm.value="";
     }
 }
 

/**
 * Call After saving is completed(DoSave) <br>
 * @param (int)code : (0:success)/(1:fail)
 * @return N/A
 * @author 
 * @version 2014.11.18
 */
function sheet1_OnSaveEnd(sheetObj, code) {
	ComOpenWait(false);	
	ComPriSaveCompleted();
    if(code >= 0) {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
}

/**
 * calling function when occurring OnChange Event <br> 
 * @param {object} comboObj Mandatory IBMultiCombo Object
 * @param {int} row index
 * @param {int} col index
 * @param {string} cell value
 * @author 
 * @version 
 */
 function sheet1_OnChange(sheetObj, Row, Col, Value)
 {
  	var colname=sheetObj.ColSaveName(Col);
  	var formObj=document.form;
  	switch(colname)
  	{
	    	case "cust_cnt_cd_seq":
	    		if (Value.length > 0){
	    			if (sheetObj.GetCellValue(Row, "cust_cnt_cd_seq") !=""){
	 	    			formObj.f_cmd.value=SEARCH01;
	 	    			var sCustCntCdSeq = sheetObj.GetCellValue(Row, "cust_cnt_cd_seq");
	 	    	    	var sCustCntCd = sCustCntCdSeq.substring(0,2);
	 	    	    	var sCustSeq = sCustCntCdSeq.substring(2,8);
	 	    	    	if(ComIsAlphabet(sCustCntCd) && ComIsNumber(sCustSeq)){
	 	    	    		var param=FormQueryString(formObj)+"&nmd_cust_flg=N" +"&cust_cnt_cd="+sCustCntCd+"&cust_seq="+sCustSeq;
		 	    			var sXml=sheetObj.GetSearchData("ESM_PRI_4014GS.do", param);
		   	  				var arrData=ComPriXml2Array(sXml, "cust_lgl_eng_nm|bzet_addr|loc_cd");   	  	
		 					if (arrData != undefined && arrData != null){
		 						sheetObj.SetCellValue(Row, "cust_cnt_cd", sCustCntCd,1);
		 						sheetObj.SetCellValue(Row, "cust_seq", sCustSeq,1);
		 						sheetObj.SetCellValue(Row,"cust_nm",arrData[0][0], 1);
		 					}else{
		 						ComShowCodeMessage("PRI00315");
		 						sheetObj.SetCellValue(Row, "cust_cnt_cd_seq","",0);
		 				  		sheetObj.SetCellValue(Row, "cust_nm","",0);
		 				  		sheetObj.SetCellValue(Row, "cust_cnt_cd", "",0);
		 						sheetObj.SetCellValue(Row, "cust_seq", "",0);
		 					}
	 	    	    	}
	    			}
	    		}
	    		break;	 
	    	case "vsl_slan_cd": //2015.05.18  Validation ADD
	    		if (Value.length == 3){
	    			formObj.f_cmd.value=COMMAND26;
	    			var sParam=FormQueryString(formObj)+"&cd="+Value;
	    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
	  				if (arrData != null && arrData.length > 0) {
						sheetObj.SetCellValue(Row, "vsl_slan_cd",arrData[0],0);
  					}else{
	  					sheetObj.SetCellValue(Row,"vsl_slan_cd","",0);
	  					sheetObj.SelectCell(Row,"vsl_slan_cd");
  					}	  				
	    		}else{	 	
  					sheetObj.SetCellValue(Row, "vsl_slan_cd","",0);
  					sheetObj.SelectCell(Row, "vsl_slan_cd");
	    		}
	    		break;
 

  	}
}


/**
 * Call After Click the button on the Cell <br>
 * @param {object} comboObj Mandatory IBMultiCombo Object
 * @param {int} row index
 * @param {int} col index
 * @author 
 * @version 2015.05.14
 */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
    var colName=sheetObj.ColSaveName(Col);
    var formObj=document.form;
    popupRow = Row;
    
    if (colName == "cust_cnt_cd_seq") {
    	var sCustCntCdSeq = sheetObj.GetCellValue(Row, "cust_cnt_cd_seq");
    	var sCustCntCd = sCustCntCdSeq.substring(0,2);
    	var sCustSeq = sCustCntCdSeq.substring(2,8);
        var sUrl="ESM_PRI_4014_POP.do?is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+sCustCntCd+"&cust_seq="+sCustSeq;
   		ComOpenPopup(sUrl, 640, 465, "cust_seq_returnVal", "none", false);  
    } else if (colName == "vsl_slan_cd") {
    	var sCustCntCdSeq = sheetObj.GetCellValue(Row, "cust_cnt_cd_seq");
    	var sCustCntCd = sCustCntCdSeq.substring(0,2);
    	var sCustSeq = sCustCntCdSeq.substring(2,8);
        var sUrl="ESM_PRI_4012.do?is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+sCustCntCd+"&cust_seq="+sCustSeq;
   		ComOpenPopup(sUrl, 480, 380, "vsl_slan_cd_returnVal", "1,0", false);  
    }

}

/**
 * receive the customer info (ESM_PRI_4014) <br>
 * @param {object} customer info object
 * @author 
 * @version 2015.05.14
 */
function cust_seq_returnVal(rtnVal) {
	var sheetObj = sheetObjects[0];
	if (rtnVal != null){
		
    	var sCustCntCd = rtnVal.custCntCd;
    	var sCustSeq = ComLpad(rtnVal.custSeq, 6, "0");
    	var sCustCntCdSeq = sCustCntCd+sCustSeq;
    	
		sheetObj.SetCellValue(popupRow, "cust_cnt_cd_seq", sCustCntCdSeq,1);
		sheetObj.SetCellValue(popupRow, "cust_nm", rtnVal.custNm,1);

	}
}

/**
 * receive Lane Code info (Lane Code Inquiry:ESM_PRI_4012) <br>
 * @param {object} Lane Code info object
 * @author 
 * @version 2015.05.18
 */
function vsl_slan_cd_returnVal(rtnVal) {
	var sheetObj = sheetObjects[0];
	if (rtnVal != null){
		sheetObj.SetCellValue(popupRow, "vsl_slan_cd",rtnVal.toString(),0);  					
	}
}

/**
 * Handling Sheet's AfterEdit  event <br>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @param {integer} sheetObj row index
 * @param {integer} sheetObj column index
 * @return N/A
 * @author 
 * @version 2014.11.18
 */
function sheet1_OnAfterEdit(sheetObj, Row, Col) {
	var ColName = sheetObj.ColSaveName(Col);
	if(ColName=="cust_cnt_cd_seq"){
		var Value = sheetObj.GetCellValue(Row, "cust_cnt_cd_seq");
		var custName = searchCustName(sheetObj, Row, Value);
		if(custName != null && custName != undefined && custName != "") {
			sheetObj.SetCellValue(Row, "cust_nm", custName);
			
			var custCndCd = Value.substr(0,2);
			var custSeq   = ComParseInt(Value.substr(2));
			sheetObj.SetCellValue(Row, "cust_cnt_cd", custCndCd);
			sheetObj.SetCellValue(Row, "cust_seq", custSeq);
			sheetObj.SetCellValue(Row, "cust_cnt_cd_seq", custCndCd+ComLpad(custSeq,   6, "0"), 0);
		} else {
			sheetObj.SetCellValue(Row, "cust_cnt_cd", "");
			sheetObj.SetCellValue(Row, "cust_seq", "");
			sheetObj.SetCellValue(Row, "cust_cnt_cd_seq", "");
			sheetObj.SetCellValue(Row, "cust_nm", "");
		}
	} else if(ColName=="pol_cd"){
		if(!checkPolCd(sheetObj, Row, true)) {
			sheetObj.SetCellValue(Row, ColName, "");
		 }
	}
	
	

}

//-------------------------------------
//User Function Area
//-------------------------------------
/**
* Handling sheet's processes <br>
* <br><b>Example :</b>
* <pre>
*     doActionIBSheet(sheetObj, document.form, IBSEARCH)
* </pre>
* @param {ibsheet} sheetObj mandatory IBSheet Object
* @param {form} formObj mandatory html form object
* @param {int} sAction mandatory,Constant Variable
* @return void
* @author 
* @version 2014.11.18
*/
function doActionIBSheet(sheetObj, formObj, sAction) {
    try {

        switch (sAction) { 
        	//Main Button
            case IBSEARCH:
            	if(!validateForm(sheetObj, formObj, sAction)) {
            		return;
            	}
            	searchMoqFilingCommissionData(sheetObj, formObj);
                break;
            case IBSAVE:
            	saveMotFilingCommission(formObj);
                break;
            case IBCLEAR:
            	setFormClear(sheetObj, formObj);
            	break;
            
            //Buttons related Sheet
            case IBCOPYROW:
            	setSheetRowCopy(sheetObj, formObj);
            	break;
            case IBINSERT:
            	setSheetRowInsert(sheetObj, formObj);
                break;
            case IBDELETE:
            	setSheetRowDelete(sheetObj, formObj, sAction);
                break;


        }
    }catch(e){
        if (e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
        }
    }finally {
         ComOpenWait(false);
    }
}


/**
* Insert Row on Sheet <br>
* @param {ibsheet} sheetObj mandatory IBSheet Object
* @param {form} formObj mandatory html form object
* @return void
* @author 
* @version 2014.11.18
*/
function setSheetRowInsert(sheetObj, formObj) {
	
	if(!checkChgCd()) return;
	
	var rowIdx = sheetObj.DataInsert();
	sheetObj.SetCellValue(rowIdx, "curr_cd", "USD" );
	sheetObj.SetCellValue(rowIdx, "chg_cd", chg_cd.GetSelectCode() );
	sheetObj.SelectCell(rowIdx, "pol_cd", 0);
}

/**
* Delete Row on Sheet <br>
* @param {ibsheet} sheetObj mandatory IBSheet Object
* @param {form} formObj mandatory html form object
* @param {int} sAction Mandatory ,Process Flag constant variable
* @return void
* @author 
* @version 2014.11.18
*/
function setSheetRowDelete(sheetObj, formObj, sAction) {
	var chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
	if(chkArr != null && chkArr != undefined && chkArr.length > 0) {
		deleteRowCheck(sheetObj, "chk" ,true);
	} else {
		ComShowCodeMessage("COM12114", "rows to delete");
	}
}

/**
* Insert the Checked Row on Sheet into the end of Sheet  <br>
* @param {ibsheet} sheetObj mandatory IBSheet Object
* @param {form} formObj mandatory html form object
* @return void
* @author 
* @version 2014.11.18
*/
function setSheetRowCopy(sheetObj, formObj) {
	var chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
	if(chkArr != null && chkArr != undefined && chkArr.length > 0) {
	    for(var i=0;i < chkArr.length;i++){
	    	var newRowIdx = sheetObj.DataInsert(-1);
	    	for(var j=0;j < sheetObj.LastCol();j++){
	    		var sSaveName = sheetObj.ColSaveName(0, j);
	    		if(sSaveName == "chk") continue;
	    		
	    		sheetObj.SetCellValue(newRowIdx, sSaveName, sheetObj.GetCellValue(chkArr[i], sSaveName));
	    	}
	    	sheetObj.SetCellValue(newRowIdx, "ibflag", "I" );
	    }
	} else {
		ComShowCodeMessage("COM12114", "rows to copy");
	}
}

/**
* Clear the form  <br>
* @param {ibsheet} sheetObj mandatory IBSheet Object
* @param {form} formObj mandatory html form object
* @return void
* @author 
* @version 2014.11.18
*/
function setFormClear(sheetObj, formObj) {
	//chg_cd
	chg_cd.SetSelectIndex(0, true);
    //access date
    formObj.acc_dt.value = setInitDate();
    //sheet
    sheetObj.RemoveAll();
    
}

/**
 * handling process for input validation <br>
 * <br><b>Example :</b>
 * <pre>
 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
 *         handling logic;
 *     }
 * </pre>
 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 * @param {form} formObj Mandatory html form object
 * @param {int} sAction Mandatory ,Process Flag constant variable
 * @returns bool <br>
 *          true  : valid<br>
 *          false : invalid
 * @author 
 * @version 2014.11.18
 */
function validateForm(sheetObj, formObj, sAction) {

    switch (sAction) {
    //------------------------------------
    case IBSEARCH:
    	checkChgCd();
    	break;

    case IBSAVE: // Save

        var sheetObj = sheetObjects[0];
        
        if(!checkChgCd()) return false;
        
        
        //---------------------------
        //check whether the pol is blank or isn't
        //---------------------------
        var rowCnt = sheetObj.RowCount();
        var noPolCdCnt = 0;
		for(var i=1; i<=rowCnt; i++){
			var polCd = sheetObj.GetCellValue(i, "pol_cd");
			if(!isNotEmpty(polCd)) {
				//필수지정시 메세지 필요없음
	        	return false;
			}
			
			var effDt = sheetObj.GetCellValue(i, "eff_dt");
			if(!isNotEmpty(effDt)) {
				//필수지정시 메세지 필요없음
	        	return false;
			}
			
			//check POL length
			if(isNotEmpty(polCd) && polCd.length != 5) {
				var msg = ComGetMsg("PRI00308", "The POL's lenght should be 5","");
				ComShowMessage(msg.replace("Please ",""));
	        	return false;
			}
			
			//check CUSTOMER length
			var custInfo = sheetObj.GetCellValue(i, "cust_cnt_cd_seq");
			if(isNotEmpty(custInfo) && custInfo.length != 8) {
				var msg = ComGetMsg("PRI00308", "The Customer Code's lenght should be 8","");
				ComShowMessage(msg.replace("Please ",""));
	        	return false;
			} 
			
			//check AGENT length
			var agentInfo = sheetObj.GetCellValue(i, "agn_cd");
			if(isNotEmpty(agentInfo) && agentInfo.length != 6) {
				var msg = ComGetMsg("PRI00308", "The Agent Code's lenght should be 6","");
				ComShowMessage(msg.replace("Please ",""));
	        	return false;
			}
			

	        //check CURR_CD length
			var currCd = sheetObj.GetCellValue(i, "curr_cd");
			if(isNotEmpty(currCd) && currCd.length != 3) {
				var msg = ComGetMsg("PRI00308", "The Currency Code's lenght should be 3","");
				ComShowMessage(msg.replace("Please ",""));
	        	return false;
			} else if (!isNotEmpty(currCd)) {
				//필수지정시 메세지 필요없음
				return false;
			}
		}		
		//dup check
		var dupIdxRow = sheetObj.ColValueDup("pol_cd|cust_cnt_cd_seq|soc_flg|prc_cgo_tp_cd|mot_file_cntr_tp_cd|mot_file_lane_cd|vsl_slan_cd|pay_term_cd|agn_cd|eff_dt|exp_dt", 0);
		if(dupIdxRow != -1) {
			ComShowCodeMessage("PRI00302");
			return false;
		}
        break;       
        
      //------------------------------------    
    } //end switch
    
    return true;
}   


function checkChgCd() {
	var sChgCd = chg_cd.GetSelectCode();
    if(sChgCd == "" || sChgCd == null || sChgCd == undefined || sChgCd == " ") {
        ComShowCodeMessage('COM12113','charge first.');
        return false;
    }  
    return true;
}


function isNotEmpty(val) {
	var result = false;
	
	if(val != null && val != undefined && val != "" ) {
		result = true;
	}
	
	return result;
}


/**
 * get today.<br> 
 * @return N/A
 * @version 2014.11.18
 */
function setInitDate() {
	//DEFAULT SEARCH DATE SET
    var rDate = new Date();
    var yy = rDate.getFullYear();
    var mm = rDate.getMonth() + 1 +"";
    var dd = rDate.getDate() +"";
    if (mm.length == 1) mm = "0" + mm;
    if (dd.length == 1) dd = "0" + dd;  
    return ComGetMaskedValue(yy+mm+dd,"ymd","-");
}

//-------------------------------------
//User Function Area - Data
//-------------------------------------
/**
 *  search the custer name <br>
 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 * @param {integer} sheetObj Row index
 * @param {string}  sheetObj Cell Value
 * @return {string} customer name
 * @version 2014.11.18
 */ 
function searchCustName(sheetObj, rowIdx, Value) {
	 var formObj = document.form;
	 var result = "";
	 
	 var custCndCdSeq = Value;
	 
	 if(custCndCdSeq.length > 2){
		 var custCndCd = custCndCdSeq.substr(0,2);
		 var custSeq   = ComParseInt(custCndCdSeq.substr(2));
	     if(ComIsAlphabet(custCndCd) && ComIsNumber(custSeq)){
	    	 formObj.f_cmd.value=COMMAND01;
		     var sParam=FormQueryString(formObj)+"&cust_cnt_cd="+custCndCd+"&cust_seq="+custSeq;
		     var sXml=sheetObj.GetSearchData("ESM_PRI_0122GS.do", sParam);
		     var custName = ComGetEtcData(sXml,"CUST_NAME");
		     if(custName != null && custName != undefined && custName != "") {
		    	 result = custName;
		     }
	     }
	 }
	return result;
}


/**
 *  search the MOQ Filing Commission Info <br>
 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 * @param {form} formObj
 * @return N/A
 * @version 2014.11.18
 */ 
function searchMoqFilingCommissionData(sheetObj, formObj) {
	
	ComOpenWait(true);
	

	formObj.f_cmd.value=SEARCHLIST01;
    var sXml=sheetObj.GetSearchData("ESM_PRI_0122GS.do" , FormQueryString(formObj));
    if (sXml != null && sXml != undefined && sXml.length > 0) {
    	sheetObj.LoadSearchData(sXml,{Sync:0} ); //header(commission)

    }

    
    ComOpenWait(false);
}

/**
 *  save the MOQ Filing Commission Info <br>
 * @return N/A
 * @version 2014.11.18
 */ 
function saveMotFilingCommission(formObj) {
	
	var sParamForm=FormQueryString(formObj);
	var sParamSheet=sheetObjects[0].GetSaveString(); //Commission Detail

	
	// escape from saving process if the info is not modified
	if (!sheetObjects[0].IsDataModified() && sParamSheet == "") {
		ComShowCodeMessage("PRI00301");
		return;
	}
	
	// check Validation
	if(!validateForm(sheetObjects[0], formObj, IBSAVE)) {
		return;
	}
	
	// ask for saving
	if (!ComPriConfirmSave()) {
		return false;
	}
	
	ComOpenWait(true);
	
	formObj.f_cmd.value=MULTI01;
	var sParamForm = FormQueryString(formObj);
	var sParam = sParamForm + "&" + ComPriSetPrifix(sParamSheet, "sheet1_");
	sheetObjects[0].DoSave("ESM_PRI_0122GS.do", sParam, -1, false);
	
	ComOpenWait(false);
}


function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}

/**
 *  Check POL_CD<br>
 * @return {Integer} ROW INDEX
 * @version 2014.11.18
 */
function checkPolCd(sheetObj, Row, isMsg) {
	var result = true;
	
	var formObj=document.form;
    var locCd=sheetObj.GetCellValue(Row, "pol_cd");
    // Location
    if (locCd.length == 5) {
        formObj.f_cmd.value=SEARCH05;
        var sParam = FormQueryString(formObj)+"&cd="+locCd.toUpperCase();
        var sXml=sheetObj.GetSearchData("PRICommonGS.do",sParam);
        var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
        if (arrDesc != null && arrDesc.length > 0) {
        	result = true;
        } else {
        	if(isMsg){
        		ComShowCodeMessage("PRI06017", locCd);
        	}
        	result = false;
        }
    } else {
    	if(isMsg){
    		ComShowCodeMessage("PRI06017", locCd);
    	}
    	result = false;
    }
    
    return result;
}