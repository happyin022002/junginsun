/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1124.js
*@FileTitle  : Neutral Pool Payable Charge Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================
*/

/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class ees_cgm_1124 : ees_cgm_1124 business script for
 */

   	/* developer job	*/
	// common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var BTN_ENABLE="btn1";
    var BTN_DISABLE="btn1_1";
    var NO_DATA_FOUND=0;
    var RETREIVE_SUCCESS=1
    var COST_YRMON_OLD1=null;	
    var COST_YRMON_OLD2=null;	
    var sXml_1 = "";
    var onLoad = "Y";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
     * Event handler processing by button name <br>
     * @param
     * @return 
     * @author 
     * @version
     */ 
    function processButtonClick(){
    	/***** use additional sheet var in case of more than 2 tap each sheet *****/
    	var sheetObject1=sheetObjects[0];
    	var sheetObject2=sheetObjects[1];	// Hidden Sheet
        /*******************************************************/
        var formObject=document.form;
        var comboObjInv=combo_inv.GetSelectText();
        var comboObjAgmt=combo_agmt.GetSelectText();
        var costYrmon=formObject.cost_yrmon.value;
        var costOfcCd=formObject.cost_ofc_cd.value;
        try {
        	var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
    			case "btn_Retrieve":
    				if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {	
    					// retrieve Action
	    				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
	    				
    				}
    				break;
    			case "btn_New":
    				// Control reset
    				initControl(sheetObject1);
    				document.form.actionflag.value="NEW";
    				break;
    				
    			case "btn_Save":
    				if(validateForm(sheetObject1,formObject,IBSAVE) != false) {
    					formObject.actionflag.value="SAVE";
    					doActionIBSheet(sheetObject1, formObject, IBSAVE);
    				}
    				break;
    				
    			case "btn_Confirm":
    				if(validateForm(sheetObject1,formObject,IBSAVE) != false) {
    					document.form.actionflag.value="CONFIRM";
    					// Confirm Action
	        			doActionIBSheet(sheetObject1, formObject, IBSAVE);
    				}
    				break;
    				
    			case "btn_Delete":
    				if(document.getElementById("btn_Delete").className != BTN_DISABLE){
    					if (ComShowCodeConfirm("CGM00005","the Invoice")){ 
    						document.form.actionflag.value="DELETE";
    						// deleting Action
    						doActionIBSheet(sheetObject2, formObject, IBDELETE);
    					}
            		}
    				break;
    				
    			case "btns_cost_yrmon":
    				if(!formObject.cost_yrmon.readOnly){
	    				COST_YRMON_OLD2=document.form.cost_yrmon.value;	
	    				var cal=new ComCalendar();
						cal.setEndFunction("processEndCal");    
						cal.setDisplayType('month');
				        cal.select(formObject.cost_yrmon, "yyyy-MM");	
    				}
    				break;

    			case "btns_office":	// Office Code getting popup
    				if(!formObject.cost_ofc_cd.readOnly){
    					ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do', 800, 480, "ofc_cd:cost_ofc_cd", "1,0,1,1,1,1,1,1", true);
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
     * registering IBSheet Object as list <br>
     * @param  {object} sheetObj	
     * @return 
     * @author 
     * @version
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet <br>
     * implementing onLoad event handler in body tag <br>
     * @param  
     * @return 
     * @author 
     * @version
     */
    function loadPage() {
    	// axon event regist
    	// axon_event.addListenerFormat('keyup', 'obj_keyup', form);
    	// axon_event.addListenerFormat('keypress', 'obj_keypress', form);
    	//axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
    	//axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
    	axon_event.addListener('focusout', 'obj_focusout', 'cost_yrmon'); 
    	axon_event.addListener('change', 'obj_change', 'cost_ofc_cd');
    	for(i=0;i<sheetObjects.length;i++){
            //
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //
            ComEndConfigSheet(sheetObjects[i]);
        }
    	//IBMultiComboreset
    	comboObjects[comboCnt++]=combo_inv;
    	comboObjects[comboCnt++]=combo_agmt;
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k]);
	    }
	    sheet1_OnLoadFinish(sheetObjects[0]);
    }
    function sheet1_OnLoadFinish(sheetObj) {
     	sheetObj.SetWaitImageVisible(0);
     	doActionIBSheet(sheetObjects[1], document.form, IBRESET);
    	// sheet reset
    	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
    	// Form reset
    	initControl(sheetObjects[0]);
     	sheetObj.SetWaitImageVisible(1);
    }
    
    function firstDayInPreviousMonth(yourDate) {
        var d=new Date(yourDate);
        d.setDate(1);
        d.setMonth(d.getMonth() - 1);
        return d;
    }
    
    
    /**
     * init control of form <br>
     * @param  
     * @return 
     * @author 
     * @version
     */
    function initControl(sheetObj){
    	var formObj=document.form;
    	
    	var d=firstDayInPreviousMonth(new Date()); //firstDayInPreviousMonth(new Date());
    	var y=d.getFullYear(); 
    	var m="";
    	var mtmp=d.getMonth()+1;
		if(mtmp<10)	m='0'+mtmp; 
		else m=''+ mtmp;
		var costYrmon=y+ '-' + m;
    	// COST YMO
    	document.form.cost_yrmon.value=costYrmon;
//    	var today=new Date();
//    	var year=today.getFullYear();
//    	var month=today.getMonth()+1;
//    	var date=today.getDate();
//    	var cost_yrmon=ComLpad(year, 4, "0") + "-" + ComLpad(month, 2, "0");
//    	formObj.cost_yrmon.value=cost_yrmon;
//    	formObj.inv_dt.value = inv_dt;
    	formObj.vndr_seq.value="";
    	formObj.vndr_lgl_eng_nm.value="";
    	formObj.cost_ofc_cd.value=formObj.ofc_cd.value;
    	formObj.diff_rmk.value="";
    	formObj.pool_max_rt_amt.value="";
    	formObj.pool_min_rt_amt.value="";
    	// hidden input tag value reset
    	formObj.pay_inv_seq.value="";
    	formObj.inv_no.value="";
    	formObj.chss_mgst_inv_sts_cd.value="";
    	formObj.agmt_ofc_cty_cd.value="";
    	formObj.agmt_seq.value="";
    	// MultiCombo reset
    	for(var i=0; i<2; i++){
    		comboObjects[i].SetSelectText("",false);
    	}
    	// Form Enable handling
    	doFromControlEnable(true, 'input1');
    	// button enable/disable handling
    	doActionBtnEnable();
    	// Sheet reset
    	for(var i=1; i <= sheetObjects[0].RowCount(); i++){
			sheetObjects[0].SetCellValue(i,"cost_chss_qty", "");
			sheetObjects[0].SetCellValue(i,"cost_bil_dys", "");
			sheetObjects[0].SetCellValue(i,"cost_amt", "0");
    	}
    	// Invoice No. retrieve
    	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
    }
    function initControl2(){
    	var formObj=document.form;
    	var today=new Date();
    	var year=today.getFullYear();
    	var month=today.getMonth() + 1;
    	var date=today.getDate();
    	formObj.vndr_seq.value="";
    	formObj.vndr_lgl_eng_nm.value="";
    	formObj.cost_ofc_cd.value=formObj.ofc_cd.value;
    	formObj.diff_rmk.value="";
    	formObj.pool_max_rt_amt.value="";
    	formObj.pool_min_rt_amt.value="";
    	// hidden input tag value reset
    	formObj.pay_inv_seq.value="";
    	formObj.chss_mgst_inv_sts_cd.value="";
    	formObj.agmt_ofc_cty_cd.value="";
    	formObj.agmt_seq.value="";
    	// MultiCombo reset
    	comboObjects[1].SetSelectText("",false);
    	// button enable/disable handling
    	doActionBtnEnable();
    	// sheet reset
    	for(var i=1; i <= sheetObjects[0].RowCount(); i++){
			sheetObjects[0].SetCellValue(i,"cost_chss_qty", "");
			sheetObjects[0].SetCellValue(i,"cost_bil_dys", "");
			sheetObjects[0].SetCellValue(i,"cost_amt", "0");
    	}
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * @param  {object} sheetObj		 Sheet Object
     * @param  {int} sheetNo
     * @return 
     * @author 
     * @version
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":
			    with(sheetObj){
				      var HeadTitle1="|||Chassis Type|Quantity|Billing Days|Amount (USD)";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dtl_pool_cost_itm_cd" },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"pay_inv_seq" },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"intg_cd_val_dp_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"cost_chss_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"cost_bil_dys",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
				             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cost_amt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 } ];
				      InitColumns(cols);
				      SetEditable(1);
				      SetSheetHeight(300);
		            }
				break;
				
			case "sheet2":
			    with(sheetObj){
				      var HeadTitle1="";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
				      InitColumns(cols);
				      SetEditable(1);
				      SetSheetHeight(300);
		            }
        		break;
	    }
	}
	/**
     * handling process for Sheet <br>
     * @param  {object} sheetObj		 Sheet Object
     * @param  {object} formObj	 Form Object
     * @param  {String} sAction	 Action Type
     * @return 
     * @author 
     * @version
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {	
    		case IBSEARCH:      //retrieve
    			onLoad = "N";
    			formObj.f_cmd.value=SEARCH;
    			formObj.eq_knd_cd.value=EQ_KND_CD_MGSET;
    			formObj.chss_mgst_inv_knd_cd.value="NP";
    			sheetObj.SetWaitImageVisible(0);
			 	ComOpenWait(true);
			 	var sXml=sheetObj.GetSearchData("EES_CGM_1124GS.do" , FormQueryString(formObj), '', true);
			 	sXml_1 = sXml;
    			sheetObj.LoadSearchData(sXml,{Sync:0} );
    			
     			formObj.pool_max_rt_amt.value = ComAddComma(formObj.pool_max_rt_amt.value);
     			formObj.pool_min_rt_amt.value =  ComAddComma(formObj.pool_min_rt_amt.value);
    			
    			break;
    			
    		case IBCLEAR:        //New reset
    			formObj.f_cmd.value=SEARCH02;
	    		sheetObj.SetWaitImageVisible(0);
			 	ComOpenWait(true);
			 	sheetObj.DoSearch("EES_CGM_1124GS.do",FormQueryString(formObj) );
    			ComOpenWait(false);
    			break;	
    			
    		case IBSAVE:        //saving , Confirm
    			formObj.f_cmd.value=MULTI;
    			formObj.eq_knd_cd.value=EQ_KND_CD_MGSET;
    			formObj.chss_mgst_inv_knd_cd.value="NP";
    			formObj.inv_no.value=combo_inv.GetSelectText();
    			var sParam=sheetObj.GetSaveString(true);
	         	sParam=sParam + "&";
	         	sParam=sParam + FormQueryString(formObj);
	         	sheetObj.SetWaitImageVisible(0);
			 	ComOpenWait(true);
			 	var sXml=sheetObj.GetSaveData("EES_CGM_1124GS.do", sParam);
			 	sheetObj.LoadSaveData(sXml);
	     		ComOpenWait(false);  			
    			break;
    			
    		case IBDELETE:      // deleting
    			formObj.f_cmd.value=REMOVE;
    			formObj.eq_knd_cd.value=EQ_KND_CD_MGSET;
    			sheetObj.SetWaitImageVisible(0);
			 	ComOpenWait(true);
			 	var sXml=sheetObj.GetSaveData("EES_CGM_1124GS.do", FormQueryString(formObj));
			 	sheetObj.LoadSaveData(sXml);
    			ComOpenWait(false);  
    			break;
    			
    		case IBSEARCH_ASYNC01:	// inv_no Combo retrieve
	    		formObj.f_cmd.value=SEARCH01;
	    		var sXml=sheetObj.GetSearchData("EES_CGM_1124GS.do", FormQueryString(formObj), '', true);
				var sStr=ComGetEtcData(sXml,"comboList");    			
				var arrStr=sStr.split("@");
				MakeComboObject(combo_inv, arrStr);
	    		break;
	    		
	    	case IBSEARCH_ASYNC02:	// agreemnt no Combo retrieve
	    		formObj.f_cmd.value=SEARCH01;
	    		formObj.agmt_lstm_cd.value="NP";
	    		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
				var sStr=ComGetEtcData(sXml,"comboList");    			
				var arrStr=sStr.split("@");
				MakeComboObject2(combo_agmt, arrStr, 0);
	    		break;
	    		
	    	case IBSEARCH_ASYNC04:
	    		var ofcCd=formObj.ofc_cd.value;
	    		formObj.ofc_cd.value=formObj.cost_ofc_cd.value;
	    		formObj.f_cmd.value=COMMAND01;
	    		var sXml=sheetObj.GetSearchData("CgmValidationGS.do", FormQueryString(formObj), '', true);
	        	var sCheckResult=ComGetEtcData(sXml,"checkResult");    	
	        	if(sCheckResult == COM_VALIDATION_FALSE){
	        		ComShowCodeMessage('CGM10009','Office');
	        		formObj.cost_ofc_cd.value="";
	        	}
	        	formObj.ofc_cd.value=ofcCd;
	    		break;
	    		
	    	 case IBRESET:
	    	 		var idx=0
	    	 		var sXml2=document.form2.sXml.value;
	    	 		var arrXml=sXml2.split("|$$|");
	    	 		//agmt_lstm_cd
	    	 		if ( arrXml[idx] == null ) {return;}
	    	 		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
	    	 	    var arrStr1=new Array();
	    	 	    var arrStr2=new Array();
	    	 		for ( var i=0; i < vArrayListData.length; i++) {
	    	 		    vListData=vArrayListData[i];
	    	 		    arrStr1[i]=vListData["code1"] +vListData["code2"] + "|" + vListData["code4"] + "|" + vListData["desc4"] + "|" + vListData["code6"];
	    	 		    arrStr2[i]=vListData["code1"] +vListData["code2"] ;
	    	 		}
	    		  	MakeComboObject3(combo_agmt, arrStr1, arrStr2);
	    	 		idx++;       
	    	 		break;
        }
    }
     /**
      * handling process for input validation <br>
      * @param  {object} sheetObj		 Sheet Object
      * @param  {object} formObj	 Form Object
      * @param  {String} sAction	 Action Type
      * @return {boolean}			false => validation check error, true => validation check succes
      * @author 
      * @version
      */  
     function validateForm(sheetObj,formObj,sAction){
        switch(sAction) {
        		case IBSEARCH:
        			if(combo_inv.GetSelectText()== ''){
        				ComShowCodeMessage('CGM10004','Invoice No.');
        				return false;
        			}	
        			break;
         	case IBSAVE:
 		        if(formObj.cost_yrmon.value == ''){
 			   		ComShowCodeMessage('CGM10004','Cost Month');
 			   		return false;
 		        } else if(formObj.cost_ofc_cd.value == ''){	
 			   		ComShowCodeMessage('CGM10004','Cost Office');
 			   		return false;
 		        } else if(combo_inv.GetSelectText()== ''){
 	        		ComShowCodeMessage('CGM10004','Invoice No.');
 	        		return false;
 	        	} else if(combo_agmt.GetSelectText()== ''){
 	        		ComShowCodeMessage('CGM10004','Agreement No.');
 	        		return false;
 	        	}
 		        
     			formObj.pool_max_rt_amt.value = ComReplaceStr(formObj.pool_max_rt_amt.value,",","");
     			formObj.pool_min_rt_amt.value =  ComReplaceStr(formObj.pool_min_rt_amt.value,",","");
 		        
         		break;
         }
         return true;
     }
     /** 
      * Sheet change event handling  <br>
      * @param  
      * @return 
      * @author 
      * @version
      */
     function sheet1_OnChange(sheetObj, Row, Col){
     	if(sheetObj.ColSaveName(Col) == "cost_chss_qty"  || sheetObj.ColSaveName(Col) == "cost_bil_dys"){
     		var costChssQty=sheetObj.GetCellValue(Row, "cost_chss_qty");
     		var costBilDys=sheetObj.GetCellValue(Row, "cost_bil_dys");
 	    	if(costChssQty=='') costChssQty=0;
 	    	if(costBilDys=='') costBilDys=0;
 	    	if(costChssQty < 0){
 	    		sheetObj.SetCellValue(Row, "cost_chss_qty", Math.abs(sheetObj.GetCellValue(Row, "cost_chss_qty")));
	    	}
	    	if(costBilDys < 0){
	    		sheetObj.SetCellValue(Row, "cost_bil_dys", Math.abs(sheetObj.GetCellValue(Row, "cost_bil_dys")));
	    	}
	    	if(sheetObj.GetCellValue(Row,"dtl_pool_cost_itm_cd") == 'NE'){
	    		sheetObj.SetCellValue(Row, "cost_amt", -1 * Math.abs(costChssQty * costBilDys));
	    	} else {	
	    		sheetObj.SetCellValue(Row, "cost_amt", Math.abs(costChssQty * costBilDys));
	    	}
     	}
    	if(sheetObj.ColSaveName(Col) == "cost_amt"){
    		if(sheetObj.GetCellValue(Row,"dtl_pool_cost_itm_cd") == 'NE'){
    			sheetObj.SetCellValue(Row, "cost_amt", -1 * Math.abs(sheetObj.GetCellValue(Row, "cost_amt")));
	    	} else {
	    		sheetObj.SetCellValue(Row, "cost_amt", Math.abs(sheetObj.GetCellValue(Row, "cost_amt")));
	    	}
    	}

    }
    /** 
     * Sheet changeSum event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version
     */
    function sheet1_OnChangeSum(sheetObj, Row)
    {
     	with(sheetObj){
//     		SetSumText(0, "ExpenseDetail","Total Amount");
     		document.form.chg_smry_amt.value=GetSumValue(0, "cost_amt");
     		document.form.inv_smry_amt.value=GetSumValue(0, "cost_amt");
     	}
    }
     /** 
      * Object keypress event handling  <br>
      * @param  
      * @return 
      * @author 
      * @version
      */
//     function obj_keypress(){
// 	    obj=event.srcElement;
// 	    if(obj.dataformat == null) return;
// 	    window.defaultStatus=obj.dataformat;
// 	    switch(obj.dataformat) {
// 	        case "ym":
// 	        case "ymd":
// 	            ComKeyOnlyNumber(obj);
// 	            break;
// 	        case "engup":
// 	        	if(obj.name=="cost_ofc_cd") ComKeyOnlyAlphabet('uppernum');
// 	        	else ComKeyOnlyAlphabet('upper');
// 	        	break;
// 	       case "float":
//	            ComKeyOnlyNumber(obj, ".");
//	            break;
// 	    }
// 	}
    /** 
     * Object keyup event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version
     */      
//    function obj_keyup(){
//    	var formObj=document.form;
//     	obj=event.srcElement;
//     	switch(ComGetEvent("name")) {
//     		case "pool_max_rt_amt":
//     			var strPoolMaxRtAmt=formObj.pool_max_rt_amt.value;
//     			var arrPoolMax=strPoolMaxRtAmt.split(".");
//     			if(arrPoolMax.length > 2){
//     				formObj.pool_max_rt_amt.value=strPoolMaxRtAmt.substring(0,strPoolMaxRtAmt.length-1);
//     				return;
//     			}
//     			if(arrPoolMax[0].length > 5){
//     				if(arrPoolMax.length == 2){
//     					formObj.pool_max_rt_amt.value=arrPoolMax[0].substring(0,arrPoolMax[0].length-1) + "." + arrPoolMax[1];
//     				} else {
//     					formObj.pool_max_rt_amt.value=arrPoolMax[0].substring(0,arrPoolMax[0].length-1);
//     				}
//     				return;
// 				}
//     			if(arrPoolMax.length == 2){
//     				if(arrPoolMax[1].length > 2){
//     					formObj.pool_max_rt_amt.value=arrPoolMax[0] + "." + arrPoolMax[1].substring(0,arrPoolMax[1].length-1);
//     					return;
//     				}
//     			}
//     			break;
//     		case "pool_min_rt_amt":
//     			var strPoolMinRtAmt=formObj.pool_min_rt_amt.value;
//     			var arrPoolMin=strPoolMinRtAmt.split(".");
//     			if(arrPoolMin.length > 2){
//     				formObj.pool_min_rt_amt.value=strPoolMinRtAmt.substring(0,strPoolMinRtAmt.length-1);
//     				return;
//     			}
//     			if(arrPoolMin[0].length > 5){
//     				if(arrPoolMin.length == 2){
//     					formObj.pool_min_rt_amt.value=arrPoolMin[0].substring(0,arrPoolMin[0].length-1) + "." + arrPoolMin[1];
//     				} else {
//     					formObj.pool_min_rt_amt.value=arrPoolMin[0].substring(0,arrPoolMin[0].length-1);
//     				}
//     				return;
// 				}
//     			if(arrPoolMin.length == 2){
//     				if(arrPoolMin[1].length > 2){
//     					formObj.pool_min_rt_amt.value=arrPoolMin[0] + "." + arrPoolMin[1].substring(0,arrPoolMin[1].length-1);
//     					return;
//     				}
//     			}
//     			break;
//     	}
//    }
     /** 
      * Object activate event handling  <br>
      * @param  
      * @return 
      * @author 
      * @version
      */
     function obj_activate(){
 	    ComClearSeparator(event.srcElement);
 	    COST_YRMON_OLD1=document.form.cost_yrmon.value;
 	}
     /** 
      * Object deactivate event handling  <br>
      * @param  
      * @return 
      * @author 
      * @version
      */ 
     function obj_deactivate(){
     	var formObj=document.form;
     	obj=event.srcElement;
     	switch(ComGetEvent("name")) {
 	    	case "cost_yrmon":	
 	    	case "inv_dt":
 	    		ComChkObjValid(event.srcElement);
 	    		break;
     	}
 	}
    /** 
     * Object focusout event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version
     */  
    function obj_focusout(){
     	var formObj=document.form;
     	obj=event.srcElement;
     	switch(ComGetEvent("name")) {
 	    	case "cost_yrmon":	
 	    		var costYrmon=ComReplaceStr(document.form.cost_yrmon.value,"-","");
 	    		if(costYrmon != COST_YRMON_OLD1){
 		    		initControl2();
 		    		doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC01);
 	    		}
 	            break;	
 	    } 	
    } 
    /** 
     * Object change event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version
     */  
    function obj_change(){
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	obj=event.srcElement;
    	switch(ComGetEvent("name")) {
	    	case "cost_ofc_cd":	
	    		if(formObj.cost_ofc_cd.value != ''){
    	 			doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC04);
    	 		}
	            break;	
	   } 	
    }
    function processEndCal(){
    	var formObj=document.form;
		var costYrmon=ComReplaceStr(formObj.cost_yrmon.value,"-","");
		if(costYrmon != COST_YRMON_OLD2){
			initControl2();
    		doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC01);
		}
    }
    function doFromControlEnable(bEnable, sStyle){
    	var formObj=document.form;
		comboObjects[1].SetEnable(bEnable);
	    if(sStyle == undefined){
	    	ComCgmEnableObject(formObj.cost_yrmon, bEnable);
		    ComCgmEnableObject(formObj.cost_ofc_cd, bEnable);
	    } else {
		    ComCgmEnableObject(formObj.cost_yrmon, bEnable, sStyle);
		    ComCgmEnableObject(formObj.cost_ofc_cd, bEnable, sStyle);
	    }
	    ComCgmEnableObject(formObj.btns_cost_yrmon, bEnable);
	    ComCgmEnableObject(formObj.btns_office, bEnable);
	}
    /**
     * Action button의 enable/disable setting한다. <br>
     * @param  
     * @return 
     * @author 
     * @version
     */	
    function doActionBtnEnable (){
    	var chssMgstInvStsCd=document.form.chss_mgst_inv_sts_cd.value;
    	if(chssMgstInvStsCd == ''){
    		ComBtnEnable("btn_Save");
    		ComBtnEnable("btn_Confirm");
    		ComBtnDisable("btn_Delete");
    	} else if(chssMgstInvStsCd == 'H'){
    		ComBtnEnable("btn_Save");
    		ComBtnEnable("btn_Confirm");
    		ComBtnEnable("btn_Delete");
    	} else if(chssMgstInvStsCd == 'S'){
    		ComBtnDisable("btn_Save");
    		ComBtnEnable("btn_Confirm");
    		ComBtnEnable("btn_Delete");
    	} else if(chssMgstInvStsCd == 'C'){
    		ComBtnDisable("btn_Save");
    		ComBtnDisable("btn_Confirm");
    		ComBtnDisable("btn_Delete");
    	}
    }
    /** 
     * Invoice No. MultiCombo change event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version
     */ 
    function combo_inv_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, idx_cd, text){
    	var formObj=document.form;
    	var arrValue=newCode.split("|");
    	var invNo=arrValue[0];
    	var chssMgstInvStsCd=arrValue[1];
    	formObj.inv_no.value=invNo;
    	formObj.chss_mgst_inv_sts_cd.value=chssMgstInvStsCd;
    	
//    	if(newText != '' && comboObj.FindItem(newText, 0, true) != -1){
//        	doFromControlEnable(false, 'input2');
//        	initControl2();
//    	} else {
//    		if(combo_agmt.GetSelectCode() == "" || combo_agmt.GetSelectIndex() == -1){
//    			ComShowCodeMessage("CGM20040");
//    			combo_inv.SetText(newIndex, 0, "");
//    			formObj.inv_no.value == "";
//    			return;
//    		}else{
//    			var checkInvNo = CGMcheckInvoiceNo(sheetObjects[0], newText,document.form.vndr_seq.value,"","CHS");
//				
//				if(checkInvNo != null && checkInvNo != ""){
//					combo_inv.SetText(newIndex, 0, "");
//	    			formObj.inv_no.value == "";
//					return;
//				}
//    		}
//    		// Form Enable handling
//        	doFromControlEnable(true, 'input1');
//    	}
    }
    
    function combo_inv_OnBlur(){
//    	if(combo_inv.GetText() != "" && combo_inv.GetText() != undefined){
    	if(document.form.combo_inv_text.value != ""&&document.form.combo_inv_text.value != undefined){
    		var text = document.form.combo_inv_text.value;
//        	text = text.toUpperCase();
//        	combo_inv.SetSelectText(text, false);
        	
        	if(text != '' && combo_inv.FindItem(text, 0, true) != -1){
            	doFromControlEnable(false, 'input2');
            	initControl2();
        	} else {
        		// Form Enable handling
            	doFromControlEnable(true, 'input1');
        		if(combo_agmt.GetSelectCode() == "" || combo_agmt.GetSelectIndex() == -1){
        			ComShowCodeMessage("CGM20040");
        			combo_inv.SetText(-1, 0, "");
        			document.form.inv_no.value == "";
        			return;
        		}else{
        			var checkInvNo = CGMcheckInvoiceNo(sheetObjects[0], text,document.form.vndr_seq.value,"","CHS");
    				
    				if(checkInvNo != null && checkInvNo != ""){
    					combo_inv.SetText(-1, 0, "");
    					document.form.inv_no.value == "";
    					return;
    				}
        		}
        	}
    	}
    }
    /** 
     * Agreement No. MultiCombo change event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version
     */ 
    function combo_agmt_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, idx_cd, text){
    	var formObj=document.form;
    	var comboObjAgmt=combo_agmt;
    	var idx = parseInt(newIndex);
    	var agmtNo=comboObjAgmt.GetText(idx,0);
    	var vndrSeq=comboObjAgmt.GetText(idx,1);
    	var vndrNm=comboObjAgmt.GetText(idx,2);
    	var currCd=comboObjAgmt.GetText(idx,3);
    	formObj.agmt_ofc_cty_cd.value=agmtNo.substring(0,3);
    	formObj.agmt_seq.value=agmtNo.substring(3);	
    	formObj.vndr_seq.value=vndrSeq;
    	formObj.vndr_lgl_eng_nm.value=vndrNm;
    	formObj.curr_cd.value=currCd;
    }
    /** 
     * MultiCombo reset  <br>
     * @param  
     * @return 
     * @author 
     * @version
     */ 
    function initCombo(comboObj) {
    	switch(comboObj.options.id) {
	        case "combo_inv":
	            var cnt=0;
	            with(comboObj) {
	            	Code="";
	            	Text="";
	            	SetBackColor("#CCFFFD");
	            	SetDropHeight(100);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetEnable(1);
	            	SetUseEdit(true);
	            	ValidChar(2,3);
	            }
	            break;
	            
	        case "combo_agmt":
	            with(comboObj) {
	            	Code="";
	            	Text="";
	            	SetBackColor("#CCFFFD");
	            	SetDropHeight(100);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            }
	            break;
	    }
	}
    function MakeComboObject(cmbObj, arrStr) {
		cmbObj.RemoveAll();
		for (var i=0; i < arrStr.length;i++ ) {
			cmbObj.InsertItem(i, arrStr[i], arrStr[i]);
		}
		cmbObj.SetSelectIndex("" ,false);
	}
	function MakeComboObject2(cmbObj, arrStr, col) {
		cmbObj.RemoveAll();
		for (var i=0; i < arrStr.length;i++ ) {
			var arrCode=arrStr[i].split("|");
			cmbObj.InsertItem(i, arrStr[i], arrCode[col]);
		}
		cmbObj.SetSelectIndex("" ,false);
	}
	function MakeComboObject3(cmbObj, arrStr, arrStr2) {
		cmbObj.RemoveAll();
		for (var i=0; i < arrStr.length;i++ ) {
			var arrCode=arrStr[i].split("|");
			cmbObj.InsertItem(i, arrStr[i], arrStr2[i]);
		}
		cmbObj.SetSelectIndex("" ,false);
	}
	/**
	 * Sheet1 OnSaveEnd event handling (Save, Confirm)<br>
	 * @param  {object} sheetObj		 Sheet Object
	 * @param  {string} ErrMsg		 String
	 * @return 
	 * @version
	 */ 
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		if(errMsg =='') {   
			ComShowCodeMessage('CGM00003');
			if(validateForm(sheetObjects[0],document.form,IBSEARCH) != false) {	
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
			// Invoice No retrieve
	    	var invNo=comboObjects[0].GetSelectText();
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
			comboObjects[0].SetSelectText(invNo,false);
		}
	}
	/**
	 * Sheet2 OnSaveEnd event handling (deleting)<br>
	 * @param  {object} sheetObj		 Sheet Object
	 * @param  {string} ErrMsg		 String
	 * @return 
	 * @version
	 */ 
	function sheet2_OnSaveEnd(sheetObj, errMsg) {
		if(errMsg =='') {   
			ComShowCodeMessage('CGM00006','The Invoice');
			// deleting , reset handling
			initControl(sheetObjects[0]);
		}
	} 
	
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		ComOpenWait(false);
		if(onLoad == "N"){
			var agmt_ofc_cty_cd=ComGetEtcData(sXml_1,"agmt_ofc_cty_cd");
			var agmt_seq="000000" + ComGetEtcData(sXml_1,"agmt_seq");
			// hidden value
			document.form.inv_no.value=ComCgmNullToBlank(sheetObj.GetEtcData("inv_no"));
			document.form.pay_inv_seq.value=ComCgmNullToBlank(sheetObj.GetEtcData("pay_inv_seq"));
			document.form.chss_mgst_inv_knd_cd.value=ComCgmNullToBlank(sheetObj.GetEtcData("chss_mgst_inv_knd_cd"));
			document.form.chss_mgst_inv_sts_cd.value=ComCgmNullToBlank(sheetObj.GetEtcData("chss_mgst_inv_sts_cd"));
			document.form.agmt_ofc_cty_cd.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_ofc_cty_cd"));
			document.form.agmt_seq.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_seq"));
			// text value
			document.form.cost_ofc_cd.value=ComCgmNullToBlank(sheetObj.GetEtcData("cost_ofc_cd"));
			document.form.diff_rmk.value=ComCgmNullToBlank(sheetObj.GetEtcData("diff_rmk"));
			document.form.pool_max_rt_amt.value=ComCgmNullToBlank(sheetObj.GetEtcData("pool_max_rt_amt"));
			document.form.pool_min_rt_amt.value=ComCgmNullToBlank(sheetObj.GetEtcData("pool_min_rt_amt"));
			document.form.vndr_seq.value=ComCgmNullToBlank(sheetObj.GetEtcData("vndr_seq"));
			document.form.vndr_lgl_eng_nm.value=ComCgmNullToBlank(sheetObj.GetEtcData("vndr_lgl_eng_nm"));
			// combo value (Agreement No.)
			if(ComCgmNullToBlank(ComGetEtcData(sXml_1,"agmt_ofc_cty_cd")) != ''){
				comboObjects[1].SetSelectText(agmt_ofc_cty_cd + agmt_seq.substring(agmt_seq.length-6),false);
			} else {
				comboObjects[1].SetSelectText("",false);
			}
			
			document.form.pool_max_rt_amt.value = ComAddComma(document.form.pool_max_rt_amt.value);
			document.form.pool_min_rt_amt.value =  ComAddComma(document.form.pool_min_rt_amt.value);

			
			// Form Enable handling
	    	doFromControlEnable(true, 'input1');
			// button enable/disable handling
	    	doActionBtnEnable();
	    	document.form.actionflag.value="SEARCH";
		}
		sheetObjects[0].SetSumText(0, "intg_cd_val_dp_desc", "TOTAL");
		sheetObjects[0].SetCellAlign(sheetObjects[0].LastRow(), "intg_cd_val_dp_desc", "Center");
		
     	with(sheetObjects[0]){
     		document.form.chg_smry_amt.value=GetSumValue(0, "cost_amt");
     		document.form.inv_smry_amt.value=GetSumValue(0, "cost_amt");
     	}		
	}