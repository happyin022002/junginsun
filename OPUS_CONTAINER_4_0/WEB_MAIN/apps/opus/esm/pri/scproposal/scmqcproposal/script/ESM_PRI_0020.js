/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0020.js
*@FileTitle  : MQC
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_PRI_0020 : Business Script for ESM_PRI_0020
     */
//    function ESM_PRI_0020() {
//    	this.processButtonClick=tprocessButtonClick;
//    	this.setSheetObject=setSheetObject;
//    	this.loadPage=loadPage;
//    	this.initSheet=initSheet;
//    	this.initControl=initControl;
//    	this.doActionIBSheet=doActionIBSheet;
//    	this.setTabObject=setTabObject;
//    	this.setComboObject=setComboObject;    	
//    	this.validateForm=validateForm;
//    }
 // common global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var comboCnt=0;
 var rData="N";
 var winHeight=0;


 //var subMqcSwitch = 0;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 /**
  * Event handler processing by button name  <br>
  * <br><b>Example :</b>
  * <pre>
  *     processButtonClick();
  * </pre>
  * @return void
  * @author 
  * @version 2009.04.17
  */
 	function processButtonClick(){
      var sheetObject1=sheetObjects[0];
      var sheetObject2=sheetObjects[1];
      /*******************************************************/
      var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_Retrieve":
 					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 					if (ComTrim(svc_scp_cd.value) !=""){ 	
 						doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01);
 					}
 					break;
 				case "btn_Amend":
 					doActionIBSheet(sheetObjects[0],document.form,MODIFY03);
 					break;
 				case "btn_AmendCancel":
 					doActionIBSheet(sheetObjects[0],document.form,MODIFY04);
 					break;
 				case "btn_Save":
 					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
 					break;
 				case "btn_Accept":	 				
 					doActionIBSheet(sheetObjects[0],document.form,MODIFY01);
 					break;
 				case "btn_AcceptCancel":
 					doActionIBSheet(sheetObjects[0],document.form,MODIFY02);
 					break;
				case "btn_New2":
					doActionIBSheet(sheetObjects[1],document.form,IBINSERT);
					break;
				case "btn_Delete2":
					doActionIBSheet(sheetObjects[1],document.form,IBDELETE);
					break;
				case "btn_Save2":
 					doActionIBSheet(sheetObjects[1],document.form,IBSAVE);
 					break;
				case "btn_Amend2":
 					doActionIBSheet(sheetObjects[1],document.form,MODIFY03);
 					break;
				case "btn_AmendCancel2":
 					doActionIBSheet(sheetObjects[1],document.form,MODIFY04);
 					break;
				case "btn_Accept2":
 					doActionIBSheet(sheetObjects[1],document.form,MODIFY01);
 					break;
				case "btn_AcceptCancel2":
 					doActionIBSheet(sheetObjects[1],document.form,MODIFY02);
 					break;		
				case "btn_AcceptAll":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY05);
					break;
				case "btn_CancelAll":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY06);
					break; 		 					
				case "btn_Close":
					ComPopUpReturnValue(rData);
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
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj mandatory IBSheet Object
     * @return void
     * @author 
     * @version 2009.04.17
     */
	 function setSheetObject(sheet_obj){
	     sheetObjects[sheetCnt++]=sheet_obj;
	 }
     /**
     * registering IBCombo Object as list</b>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_obj);
     * </pre>
     * @param {ibcombo} combo_obj Mandatory IBCombo Object
     * @return void
     * @author 
     * @version 2009.04.17
     */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
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
    * @version 2009.04.17
    */
     function loadPage() {
    	 
    	 if (!opener) opener = window.dialogArguments;
    	 if (!opener) opener = window.opener;
    	 if (!opener) opener = parent;
    	 
    	  var formObj=document.form;
          for(i=0;i<sheetObjects.length;i++){
              //Modify Environment Setting Function's name
              ComConfigSheet (sheetObjects[i] );
              initSheet(sheetObjects[i],i+1);
              //Add Environment Setting Function
              ComEndConfigSheet(sheetObjects[i]);             
          }
      	    //Initializing IBMultiCombo
      	  for(var k=0; k < comboObjects.length; k++){
      	       initCombo(comboObjects[k], k + 1);
      	  }
      	// Hide sub MQC
    	//window.dialogHeight="330px";
     	var formObj=document.form; 
   	    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
  	    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
  	    // When sheet called this, retrieve this using svc_scp_cd
  	    var svcScpCd=formObj.svc_scp.value;
  	    if (svcScpCd != "" && svcScpCd != null &&  svcScpCd !="null" ){
  		    if (comboObjects[0].GetItemCount() > 0 ){   
  			   //Initialize using received value.
  		  	  comboObjects[0].SetSelectText(svcScpCd);
  			  svc_scp_cd_OnBlur(comboObjects[0]);
  		    }
  	    }
  	    // Display when the data exists on Sub Mqc
//  	    sheet1_OnSearchEnd(sheet1);
//  	    sheet2_OnSearchEnd(sheet2);
  	    if (sheetObjects[1].RowCount()> 0){
//  	      	document.all.subDivMqc.style.display="inline";
  	    	document.getElementById("subDivMqc").style.display="inline";
  	      	//window.dialogHeight="455px"
  	      	formObj.selectMqc.value=1;
  	    }  	    
  	    initControl();  
  	    
  	    
  	    
     }
     
     /**
      * after the page is loaded all <br>
      * @return void
      * @author 
      * @version 2014.11.17
      */
     $(document).ready(function() {
    	//get the window height when document is loaded    
	 	winHeight = $(document).height();
	 });
     
  	/**
 	 * Handling body tag's unonLoad event handler <br>
 	 * adding the functions when screen is closing.<br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *     unloadPage();
 	 * </pre>
 	 * @return void
 	 * @author 
 	 * @version 2009.08.17
 	 */      
	 function unloadPage(){
//		 window.returnValue=rData;
	 }       
    /**
     * Process OPtion Axon event <br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl()
     * </pre>
     * @param  void
     * @returns void
     * @author 
     * @version 2009.04.17
     */ 	 
	function initControl() {
	    // Process Axon Event No.1, Event Catch 
	    axon_event.addListener('change', 'select_Onchange', 'selectMqc');
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
     * @version 2009.04.17
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 		 var sheetID=sheetObj.id;
 		 var amdt_seq=document.form.amdt_seq.value;
         switch(sheetID) {
             case "sheet1":
                 with (sheetObj) {
               
	                 var HeadTitle="|sel|prop_no|amdt_seq|Unit|Proposal|C/Offer|Final|EFF Date|EXP Date|Source|Source|Status|Status|acptusrid|acptofccd|acptdt|mneffdt|mnexpdt||||";
	                 var headCount=ComCountHeadTitle(HeadTitle);
	
	                 SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                 var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                 InitHeaders(headers, info);
	
	                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                              {Type:"DummyCheck", Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	                              {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                              {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                 if (amdt_seq == "0"){
		                 cols.push({Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_lod_ut_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		                 cols.push({Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"prop_scp_mqc_qty",    KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 });
		                 cols.push({Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"coffr_mqc_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:6 });
	                 }else{
		                 cols.push({Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_lod_ut_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		                 cols.push({Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"prop_scp_mqc_qty",    KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 });
		                 cols.push({Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"coffr_mqc_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 });
	                 }
	                 cols.push({Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"fnl_mqc_qty",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 });
	                 cols.push({Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"src_info_dtl",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"prc_prog_sts_dtl",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mn_eff_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mn_exp_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"du_eff_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"du_exp_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dur_dup_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	
	                 InitColumns(cols);
	                 SetEditable(1);
	                 SetSheetHeight(100);
	                 SetCountPosition(0);
	                 SetWaitImageVisible(0);
	                 SetColHidden("chk",1);
 				}
                 break;
             case "sheet2"://sub mqc
                 with (sheetObj) {
                
	                 var HeadTitle="|sel|prop_no|amdt_seq|Sub.MQC|EFF Date|EXP Date|Source|Source|Status|Status|acptusrid|acptofccd|acptdt|mneffdt|mnexpdt||";
	                 var headCount=ComCountHeadTitle(HeadTitle);
	
	                 SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                 InitHeaders(headers, info);
	
	                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                  {Type:"DummyCheck", Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	                  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                 if (amdt_seq == "0"){
	                     cols.push({Type:"Text",      Hidden:0,  Width:290,  Align:"Left",    ColMerge:0,   SaveName:"sub_mqc_ctnt",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	                 }else{
	                	 cols.push({Type:"Text",      Hidden:0,  Width:290,  Align:"Left",    ColMerge:0,   SaveName:"sub_mqc_ctnt",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	                 }
	                 cols.push({Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"src_info_dtl",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"prc_prog_sts_dtl",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mn_eff_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mn_exp_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dur_dup_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	      
	                 InitColumns(cols);
	
	                 SetEditable(1);
	                 SetSheetHeight(102);
	                 SetWaitImageVisible(0);
	                 SetCountPosition(0);
	                 SetColHidden("chk",1);

 				}
                 break;
         }
     }
     /**
     * setting combo initial values <br>
     * adding case as numbers of counting combo<br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj, comboNo);
     * </pre>
     * @param {ibcombo} sheetObj Mandatory IBSheet Object
     * @param {int} ComboNo Mandatory IBCombo Object ,Serial no for Tag's ID
     * @return void
     * @author 
     * @version 2009.04.17
     */
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.options.id) {
	        case "svc_scp_cd":
	            with(comboObj) {
	            	SetDropHeight(260);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	                SetUseAutoComplete(1);
//no support[check again]CLT 	            	IMEMode=0;
	                ValidChar(2);
	            	SetMaxLength(3);
	            }
	            break;
	    }
	}           
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
    * @version 2009.04.17
    */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         try{
             switch(sAction) {
 	 		case IBSEARCH_ASYNC10: //combo setting,Retrieve scope
 		        //srcInfocd		        
 	 			sheetObj.SetColProperty("src_info_cd", {ComboText:srcInfoCdText, ComboCode:srcInfoCdValue} );
 	 			sheetObjects[1].SetColProperty("src_info_cd", {ComboText:srcInfoCdText, ComboCode:srcInfoCdValue} );
 		        //status
 	 			sheetObj.SetColProperty("prc_prog_sts_cd", {ComboText:stsCdText, ComboCode:stsCdValue} );
 	 			sheetObjects[1].SetColProperty("prc_prog_sts_cd", {ComboText:stsCdText, ComboCode:stsCdValue} );
 	 			sheetObj.SetColProperty("cntr_lod_ut_cd", {ComboText:lodUtCdText, ComboCode:lodUtCdValue} );
 	 			// Retrieve Service Scope when screen is loading
 				comboObjects[0].RemoveAll();
 				formObj.f_cmd.value=SEARCH13;
 				var sParam=FormQueryString(formObj) + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value;				
  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
 				ComPriXml2ComboItem(sXml,svc_scp_cd, "cd", "cd|nm");  				
 				break; 								
             case IBSEARCH:      //Retrieving			
 				ComOpenWait(true);
             	formObj.f_cmd.value=SEARCH01;				
              	sheetObj.DoSearch("ESM_PRI_0020GS.do", FormQueryString(formObj), {Sync:2} );
             	// Retrieve SUB MQC
 				if (ComTrim(formObj.svc_scp_nm.value) ==""){//Case of Main
 					formObj.f_cmd.value=SEARCH02;		
  					sheetObjects[1].DoSearch("ESM_PRI_0020GS.do", FormQueryString(formObj), {Sync:2});
 				}				
 				ComOpenWait(false); //->waiting->End
 				buttonControl(); 				
 				break;
             case IBSEARCH_ASYNC01:      //Retrieve				
             	ComOpenWait(true);
             	formObj.f_cmd.value=SEARCH02;				
  				sheetObjects[1].DoSearch("ESM_PRI_0020GS.do", FormQueryString(formObj) );
 				ComOpenWait(false); //->waiting->End
 				break;
  			 case IBSAVE:        		
  			 	ComOpenWait(true); //->waiting->start 
  			 	if (!validateForm(sheetObj,document.form,sAction)) {
 					return false;
 				}
 	             if (!ComPriConfirmSave()) {
 	                 return false;
 	             } 		 	            
  			 	if (sheetObj.id == "sheet1"){
  	  			 	if (sheetObj.id == "sheet1"){
  	  			 		checkAllSave();	
  	  			 	}  			 		 		
  			 		if (ComTrim(formObj.svc_scp_nm.value) != ""){
  			 			var saveChk=mqcCheck(sheetObj,"N");
  			 			if (saveChk == false){
  			 				ComShowCodeMessage('PRI01008');
  			 				return false;
  			 			}
  			 		}else{
  			 			var saveChk=mqcCheck(sheetObj,"Y");
  			 			if (saveChk == false){
  			 				ComShowCodeMessage('PRI01008');
  			 				return false;
  			 			}
  			 		}  			 		
  			 	}
  			 	if (sheetObj.id == "sheet1"){
  			 		formObj.f_cmd.value=MULTI01;
  			 	}else{
  			 		formObj.f_cmd.value=MULTI02;
  			 	}  			 	
             	for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
             		// if C/Offer amount is inputed, Changing prc_prog_sts_cd to Returned
             		if (sheetObj.GetRowStatus(i) == "U"
             				&& getMainStatus() == "Q"
             					&& sheetObj.GetCellValue(i, "prc_prog_sts_cd") == "I"
             						&& sheetObj.GetCellValue(i, "coffr_mqc_qty") != null
             						&& sheetObj.GetCellValue(i, "coffr_mqc_qty") != "") {
             			sheetObj.SetCellValue(i, "prc_prog_sts_cd","R");
             		}             		
             		// if C/Offer amount is cleared, Changing prc_prog_sts_cd to Initial
             		if (sheetObj.GetRowStatus(i) == "U"
         				&& getMainStatus() == "Q"
         					&& sheetObj.GetCellValue(i, "prc_prog_sts_cd") == "R"
         						&& (sheetObj.GetCellValue(i, "coffr_mqc_qty") == null || sheetObj.GetCellValue(i, "coffr_mqc_qty") == "0")) {
         			sheetObj.SetCellValue(i, "prc_prog_sts_cd","I");
             		}
         		}
  				var sParam=FormQueryString(formObj);
  				var sParamSheet=sheetObj.GetSaveString();
   				var sXml=sheetObj.GetSaveData("ESM_PRI_0020GS.do", sParam+"&"+sParamSheet);
   				sheetObj.LoadSaveData(sXml);
  				formObj.amendcancel_gbn.value="";
 				ComOpenWait(false); //->waiting->End
                break;
  			 case MODIFY01:        //accept
  			 	ComOpenWait(true); //->waiting->start 
 	 			var req_usr_flg=formObj.req_usr_flg.value;
 	 			var apro_usr_flg=formObj.apro_usr_flg.value;
 	 			var sts=getMainStatus();
 	            if (!ComShowCodeConfirm("PRI00008")) {
 	            	return false;
 	            }
 			 	 if (sheetObj.id == "sheet1"){
 	 			 	formObj.f_cmd.value=MODIFY01;
 	 			 	var cQty=sheetObj.GetCellValue(sheetObj.RowCount(),"coffr_mqc_qty");
 	 			 	var pQty=sheetObj.GetCellValue(sheetObj.RowCount(),"prop_scp_mqc_qty");
 	 			 	var fQty=0;
 	 			 	// When the status of S/C is requested, Acceptance by Authorizer copy Proposal Qty to Final.
 	 			 	// When the status of S/C is returned, Acceptance by Authorizer copy Proposal Qty to Final , by Sales Rep. copy C/Offer Qty
 	 			 	// Set final value to 0 when Amendment cancelled.
 	 			 	// Modify it depend on status of main. No considering authority
 	 			 	if (sts == "Q"){
 	 			 		fQty=pQty;
 	 			 	}else if (sts == "R"){	 			 		
 	 			 		fQty=cQty;
 	 			 	}
 	 			 	sheetObj.SetCellValue(sheetObj.RowCount(),"fnl_mqc_qty",fQty);
  			 	 }else{
  			 		formObj.f_cmd.value=MODIFY11;
  			 	 } 		
 				var rVal=sheetAcceptCheckedRows(sheetObj,formObj);
 				ComOpenWait(false); //->waiting->End
 				buttonControl();
 				break;		  			 
  			 case MODIFY02:        //accept cancel
  			 	ComOpenWait(true); //->waiting->start 
 	            if (!ComShowCodeConfirm("PRI00009")) {
 	            	return false;
 	            } 		
  			    var rVal="";
 			 	 if (sheetObj.id == "sheet1"){
   			 		formObj.f_cmd.value=MODIFY02;
   			 		sheetObj.SetCellValue(sheetObj.RowCount(),"fnl_mqc_qty",0);
   			 		rVal=sheetAcceptCancelReturnCheckedRows(sheetObj,formObj);
   			 	 }else{
   			 		formObj.f_cmd.value=MODIFY12;
   			 		rVal=comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_0020GS.do", false)
   			 	 }
 			 	ComOpenWait(false); //->waiting->End
 				buttonControl();
 				break;	  			 
  			 case MODIFY03:        //amend			
 				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
 				var colName="";
  			 	if (sheetObj.id == "sheet1"){
  			 		if (ComTrim(formObj.svc_scp_nm.value) == ""){		
  			 			colName="cntr_lod_ut_cd|prop_scp_mqc_qty";
  			 		}else{
  			 			colName="prop_scp_mqc_qty";
  			 		} 
  			 	}else{
  			 		colName="sub_mqc_ctnt";
  			 	}  			 	
 				if(chkArr.length > 0){
 					if(chkArr.length > 1){					
 						ComShowCodeMessage("PRI00310");
 					}else{						
 						sheetAmendRow(sheetObj,formObj,chkArr[0],"M", colName);						
 					}
 				}else{ 					
 					sheetAmendRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M", colName);
 				}
 				if (sheetObj.id == "sheet1"){
 					sheetObj.SelectCell(2,"prop_scp_mqc_qty");
 				}else{
 					sheetObj.SelectCell(2,"sub_mqc_ctnt");
 				} 			
 				formObj.amendcancel_gbn.value="";
 				break;  			 	
  			 case MODIFY04:        //amend cancel
 				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
 				var colName="";
 			 	if (sheetObj.id == "sheet1"){
  					if (ComTrim(formObj.svc_scp_nm.value) == ""){		
  						colName="cntr_lod_ut_cd|prop_scp_mqc_qty|coffr_mqc_qty";
  					}else{
  						colName="prop_scp_mqc_qty|coffr_mqc_qty";
  					} 		
 			 	}else{
 			 		colName="sub_mqc_ctnt";
 			 	}				
 				if(chkArr.length > 0){
 					if(chkArr.length > 1){					
 						ComShowCodeMessage("PRI00310");
 					}else{
 						sheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", colName);		
 					}
 				}else{ 
 					sheetAmendCancelRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M", colName);
 				}	
 				setScMqc(sheetObj);// Modifying the value of S/C MQC   
 				// Setting Y when Amendment Cancelled. It used at checkallsave.
 				formObj.amendcancel_gbn.value="Y";
 				break; 			 
  			case MODIFY05: // Accept All
  				ComOpenWait(true); //->waiting->start 
 				if (!ComShowCodeConfirm("PRI01015")){
 					return false;
 				}
 				formObj.f_cmd.value=MODIFY05;
 				formObj.sts_cd.value='A';
 				var sParam=FormQueryString(formObj);
  				var sXml=sheetObj.GetSaveData("ESM_PRI_0020GS.do", sParam);
  				sheetObj.LoadSaveData(sXml);
 				if(ComGetEtcData(sXml,"rValue") > 0){
 					changeAcceptStatus(sheetObj,"A");
 				}
 				ComOpenWait(false); //->waiting->End
 				buttonControl();
 				break;	
 			case MODIFY06: // Cancel All
 				ComOpenWait(true); //->waiting->start 
 				if (!ComShowCodeConfirm("PRI01010")){
 					return false;
 				}			
 				formObj.f_cmd.value=MODIFY06;
 				formObj.sts_cd.value='I';
 				var sParam=FormQueryString(formObj); 				
  				var sXml=sheetObj.GetSaveData("ESM_PRI_0020GS.do", sParam);
  				sheetObj.LoadSaveData(sXml);
 				if(ComGetEtcData(sXml,"rValue") > 0){
 					if (sheetObj.GetCellValue(sheetObj.RowCount(), "coffr_mqc_qty") == 0 ){
 						changeAcceptStatus(sheetObj,"I");
 					}else{
 						changeAcceptStatus(sheetObj,"R");
 					} 					
 				}			
 				ComOpenWait(false); //->waiting->End
 				buttonControl();
 				break;	 			 
  			case IBINSERT: // Row Add		
  				var formObj=document.form;
 				var amdt_seq=formObj.amdt_seq.value;
 				if (getValidRowCount(sheetObj) > 0){
 					ComShowCodeMessage("PRI01002");
 					return;
 				}  
  				if (sheetObj.GetSelectRow()> 0){
  					if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"amdt_seq")!=amdt_seq && sheetObj.GetCellValue(sheetObj.GetSelectRow(),"amdt_seq")!=""){
  						ComShowCodeMessage("PRI01002");
  						return;
  					}
  				}
 				var idx=sheetObj.DataInsert();
 				sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value,0);
 				sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value,0);
 				sheetObj.SetCellValue(idx, "eff_dt",formObj.main_eff_dt.value,0);
 				sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",amdt_seq,0);
 				sheetObj.SetCellValue(idx, "exp_dt",formObj.main_exp_dt.value,0);
 				sheetObj.SetCellValue(idx, "mn_eff_dt",formObj.main_eff_dt.value,0);
 				sheetObj.SetCellValue(idx, "mn_exp_dt",formObj.main_exp_dt.value,0);
 				sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I",0);
 				sheetObj.SetCellValue(idx, "src_info_cd","NW",0);
 				if(amdt_seq!=0){
  					sheetObj.SetCellFont("FontColor", idx, "sub_mqc_ctnt", idx, "prc_prog_sts_dtl","#FF0000");
 			         //backcolor change
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(idx, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
 				}
 				sheetObj.SelectCell(1,"sub_mqc_ctnt");
 				break;	 
 			case IBDELETE: // Delete					
 				var amdt_seq=formObj.amdt_seq.value;
 				var colName="";
 			 	if (sheetObj.id == "sheet1"){
  					if (ComTrim(formObj.svc_scp_nm.value) == ""){		
  						colName="cntr_lod_ut_cd|prop_scp_mqc_qty|coffr_mqc_qty";
  					}else{
  						colName="prop_scp_mqc_qty|coffr_mqc_qty";
  					} 		
 			 	}else{
 			 		colName="sub_mqc_ctnt";
 			 	}							
 				if(amdt_seq=="0"){	
 					if (validateForm(sheetObj,document.form,sAction)) {
 						sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk",1);
 						deleteRowCheck(sheetObj, "chk");
 					}
 				}else{					
 					var eff_dt=formObj.eff_dt.value;
 					var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
 					if(chkArr.length > 0){						
 						for(i=0;i < chkArr.length;i++){
 							if(sheetObj.GetCellValue(chkArr[i],"amdt_seq")!=amdt_seq||(sheetObj.GetCellValue(chkArr[i],"src_info_cd")!="NW"&&sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq")==amdt_seq)){
 								ComShowCodeMessage("PRI01002");
 								return;
 							}
 						} 						
 						var sRow=0;
 						for(j=0;j < chkArr.length;j++){
 							if(sheetObj.GetCellValue(chkArr[j]+sRow,"n1st_cmnc_amdt_seq")!=amdt_seq){
 								comSheetAmendRow(sheetObj,formObj,chkArr[j]+sRow,"D",colName);
 								sRow++;
 							}
 						}
 						deleteRowCheck(sheetObj, "chk");
 					}else{ 
 						if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"amdt_seq")!=amdt_seq || ( sheetObj.GetCellValue(sheetObj.GetSelectRow(),"n1st_cmnc_amdt_seq")==amdt_seq && sheetObj.GetCellValue(sheetObj.GetSelectRow(),"src_info_cd")!="NW")){
 							ComShowCodeMessage("PRI01002");
 							return;
 						}
 						if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"n1st_cmnc_amdt_seq")!=amdt_seq){
 							comSheetAmendRow(sheetObj,formObj,sheetObj.GetSelectRow(),"D",colName);
 						}else{
 							sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk",1);
 							deleteRowCheck(sheetObj, "chk");
 						}	
 					}					
 				}
 				break;
 			}        	 
         } catch (e) {
          	if (e == "[object Error]") {
                  ComShowMessage(OBJECT_ERROR);
              } else {
                  ComShowMessage(e.message);
              }
          }finally{
          	if (sAction == IBSEARCH_ASYNC10 || sAction == MODIFY03 || sAction == MODIFY04) {
          		return;
          	}
          	ComOpenWait(false); //->waiting->End
          }
     }
     /**
      * Calling Function in case of OnChange event <br>
      * Fill Input box using SVC Scope name of Combo Item. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
      * @param {int} code Mandatory Onclick 
      * @param {int} text Mandatory 
      * @return void
      * @author 
      * @version 2009.04.17
      */  	
  	function svc_scp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
  		try{
  	    	var formObj=document.form;  		
  	    	var arrText=newCode;
  	  		if (arrText != null && arrText.length > 1) {
  	  			formObj.svc_scp_nm.value=comboObj.GetText(newCode,1);;
  	  			ComOpenWait(true);
  	  			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
  	  			ComOpenWait(false);
  	  		}  			
        } catch (e) {
          	if (e == "[object Error]") {
                  ComShowMessage(OBJECT_ERROR);
              } else {
                  ComShowMessage(e.message);
              }
      }finally{
    	  ComOpenWait(false); //->waiting->End
      }  		
  	}      
  /**
   * calling function in case of OnBlur event of IBMultiCombo <br>
   * Fill Input box using SVC Scope name of Combo Item. And Retrieve <br>
   * <br><b>Example :</b>
   * <pre>
   *
   * </pre>
   * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
   * @param {int} code Mandatory Onclick 
   * @param {int} text Mandatory 
   * @return void
   * @author 
   * @version 2009.04.17
   */        
 	function svc_scp_cd_OnBlur(comboObj) {
	   try{
		   var formObj=document.form;		
		   var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
			if (code != null && code != "") {
				var text=comboObj.GetText(code, 1);
				if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
					formObj.svc_scp_nm.value=comboObj.GetText(code, 1);
					ComOpenWait(true);
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					ComOpenWait(false);
				}
			}		   
       } catch (e) {
         	if (e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e.message);
             }
       }finally{
   	  		ComOpenWait(false); //->waiting->End
       }  	
	}           
      /**
       * Calling Function in case of OnChange event <br>
       * Display the contents of SubMqc. <br>
       * <br><b>Example :</b>
       * <pre>
       *
       * </pre>
       * @param  void
       * @return void
       * @author 
       * @version 2009.06.104
       */       
      function select_Onchange(){
    	  if(document.form.selectMqc.value == "1") {
    		  document.all.subDivMqc.style.display="inline";
    		  document.getElementById("subDivMqc").style.display="inline";
    	  } else {
    		  document.all.subDivMqc.style.display="none";
    		  document.getElementById("subDivMqc").style.display="none";
    	  }
      }
      
   /**
    * Calling Function in case of OnChange event <br>
    * Fill Final using Proposal, C/Offer amount. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {int} Row mandatory Onclick ,Cell's Row Index
    * @param {int} Col mandatory Onclick ,Cell's Column Index
    * @param {string} Value Mandatory Value
    * @return void
    * @author 
    * @version 2009.04.17
    */  	
    function sheet1_OnChange(sheetObj, Row, Col, Value)
    {
    	var colname=sheetObj.ColSaveName(Col);
    	var formObj=document.form
    	switch(colname)
    	{
	    	case "prop_scp_mqc_qty":
	    		if (sheetObj.GetCellValue(Row,Col) < 0){
            		sheetObj.SetCellValue(Row, Col,0,0);
            	}
	    		setScMqc(sheetObj);// Modifying the value of S/C MQC   		
	    		break;
	    	case "coffr_mqc_qty":
	    		if (sheetObj.GetCellValue(Row,Col) < 0){
            		sheetObj.SetCellValue(Row, Col,0,0);
            	}
	    		setScMqc(sheetObj);// Modifying the value of S/C MQC
	    		break;
	    	case "cntr_lod_ut_cd":
	    		formObj.unit.value=sheetObj.GetCellText(Row,Col);
	    		break;   
    	}
    }    	
    /**
     * calling function when occurring OnSaveEnd event <br>
     * Setting data modification flag to "Y" after saving<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2009.04.17
     */ 	
 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	 if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
    		 rData="Y";
		 }    	 
		var formObj=document.form;
		formObj.save_gbn.value="";
		formObj.save_scp.value="";
	}       
    /**
     * Calling Function in case of OnSearchEnd event <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2009.05.20
     */ 	    
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		var amdt_seq=document.form.amdt_seq.value;
		var formObj=document.form;
		if (sheetObj.RowCount()> 0){
			setSearchEnd(sheetObj);
		}
		var sCols="";
		if (ComTrim(formObj.svc_scp_nm.value) == ""){		
			sCols="cntr_lod_ut_cd|prop_scp_mqc_qty|coffr_mqc_qty";
		}else{
			sCols="prop_scp_mqc_qty|coffr_mqc_qty";
		}		
		searchEndFontChange(sheetObj, sCols,document.form.lgcy_if_flg.value);
		formObj.amendcancel_gbn.value="";
	}	
     /**
     * calling function in case of OnSelectCell event <br>
     * <br><b>Example :</b>
     * <pre>
     *		
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} OldRow Mandatory ,previous selected cell's Row Index
     * @param {int} OldCol Mandatory Previous selected Cell's Column Index
     * @param {int} NewRow Mandatory ,current selected cell's Row Index
     * @param {int} NewCol Mandatory ,current selected cell's Column Index
     * @return void
     * @author 
     * @version 2009.04.17
     */        	
  	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
         if (OldRow != NewRow) {
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
         }
  	}       
     /**
     * calling function when occurring OnSaveEnd event <br>
     * After save completed, Define the font style of sheet . <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2009.04.17
     */ 	
 	function sheet2_OnSaveEnd(sheetObj, ErrMsg)  {
    	 if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
			rData="Y";
			var sCols="sub_mqc_ctnt";
			searchEndFontChange(sheetObj, sCols);
		}
	}
     /**
      * Calling Function in case of OnSearchEnd event <br>
      * After retrieve finish, define the font style.
      * <br><b>Example :</b>
      * <pre>
      * 
      * </pre>
      * @param {ibsheet} sheetObj mandatory IBSheet Object
      * @param {string} ErrMsg mandatory from server
      * @return void
      * @author 
      * @version 2009.05.20
      */ 		
 	function sheet2_OnSearchEnd(sheetObj, errMsg){
 		var amdt_seq=document.form.amdt_seq.value;
		var formObj=document.form
		var maxRow=sheetObj.RowCount();
		formObj.dur_sub_dup_flg.value=sheetObj.GetCellValue(maxRow,"dur_dup_flg");
		var sCols="sub_mqc_ctnt";
		searchEndFontChange(sheetObj, sCols,document.form.lgcy_if_flg.value); 		
 	}	     
      /**
       * calling function in case of OnSelectCell event <br>
       * <br><b>Example :</b>
       * <pre>
       *		
       * </pre>
       * @param {ibsheet} sheetObj mandatory IBSheet Object
       * @param {int} OldRow Mandatory ,previous selected cell's Row Index
       * @param {int} OldCol Mandatory Previous selected Cell's Column Index
       * @param {int} NewRow Mandatory ,current selected cell's Row Index
       * @param {int} NewCol Mandatory ,current selected cell's Column Index
       * @return void
       * @author 
       * @version 2009.04.17
       */        	
    	function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
           if (OldRow != NewRow) {
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
           }
    	}        
    /**
    * Call it right after retrieve finished. <br>
    * Update the retrieved sheet values to input box.
    * <br><b>Example :</b>
    * <pre>
    *      setSearchEnd (sheetObj)
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @return void
    * @author 
    * @version 2009.05.20
    */ 			
	function setSearchEnd (sheetObj){
		var formObj=document.form
		var maxRow=sheetObj.RowCount();
		// Setting the value of duration setting scope table
		formObj.dur_eff_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(maxRow,"du_eff_dt"),"ymd","-");//(main,scope)duration
		formObj.dur_exp_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(maxRow,"du_exp_dt"),"ymd","-");//duration
		// To Insert value Sub MQC's mn_eff_dt ,mn_exp_dt
		formObj.main_eff_dt.value=sheetObj.GetCellValue(maxRow,"mn_eff_dt"); //(main,scope) eff_dt
		formObj.main_exp_dt.value=sheetObj.GetCellValue(maxRow,"mn_exp_dt");	//(main,scope) exp_dt
		// To Insert value Sub MQC's eff_dt ,exp_dt.
		formObj.eff_dt.value=sheetObj.GetCellValue(maxRow,"mn_eff_dt");
		formObj.exp_dt.value=sheetObj.GetCellValue(maxRow,"mn_exp_dt");
		formObj.pre_exp_dt.value=ComGetDateAdd(sheetObj.GetCellValue(maxRow,"mn_eff_dt"), "D", -1);
		// Setting unit value
		formObj.unit.value=sheetObj.GetCellText(maxRow,"cntr_lod_ut_cd");
		formObj.dur_dup_flg.value=sheetObj.GetCellValue(maxRow,"dur_dup_flg");
		// Setting S/C MQC value 
		setScMqc(sheetObj);		
	}
    /**
    * Modifying S/C MQC, using modified MQC value on Sheet.<br>
    * <br><b>Example :</b>
    * <pre>
    *     setScMqc (sheetObj);
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @author 
    * @version 2009.04.17
    */	
	function setScMqc (sheetObj){
		var formObj=document.form
		var maxRow = getValidRowCount(sheetObj);
		if (ComTrim(formObj.svc_scp_nm.value) !=""){
			return;
		}
		// When Final rate exist, fill S/C MQC using it, or not exist, using Proposal rate.
		if (sheetObj.GetCellValue(maxRow,"coffr_mqc_qty") == ""
			|| sheetObj.GetCellValue(maxRow,"coffr_mqc_qty") == "0"
			|| formObj.prop_sts_cd.value == "I"	){
			formObj.sc_mqc.value=ComAddComma(sheetObj.GetCellValue(maxRow,"prop_scp_mqc_qty"));
		}else{
			formObj.sc_mqc.value=ComAddComma(sheetObj.GetCellValue(maxRow,"coffr_mqc_qty"));
		}
	}
    /**
    *  Button Control function <br>
    *  <br>
    * <br><b>Example :</b>
    * <pre>
    *		buttonControl()
    * </pre>
    * @param  void
    * @return void
    * @author 
    * @version 2009.04.17
    */     
    function buttonControl(){
		var formObj=document.form;
		var reqUsrFlg=formObj.req_usr_flg.value;
		var aproUsrFlg=formObj.apro_usr_flg.value;
		var amdt_seq=formObj.amdt_seq.value;
		var sts=getMainStatus();	
		try{
			if(amdt_seq == 0) {
				hiddenButton("btn_Amend");
				hiddenButton("btn_AmendCancel");
				hiddenButton("btn_Amend2");
				hiddenButton("btn_AmendCancel2");
			} else {
				showButton("btn_Amend");
				showButton("btn_AmendCancel");	
				showButton("btn_Amend2");
				showButton("btn_AmendCancel2");	
			}				
			switch(sts) { 				
				case 'I':   // Initial
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");
					ComBtnDisable("btn_Accept2");
					ComBtnDisable("btn_AcceptCancel2");		
					ComBtnDisable("btn_AcceptAll");					
					ComBtnDisable("btn_CancelAll");
					if (amdt_seq == "0"){
						ComBtnDisable("btn_Save");
//						sheetObjects[0].CellEditable(Row, "dir_call_flg") = true;
					}
					if (reqUsrFlg != "true" && aproUsrFlg != "true"){
						ComBtnDisable("btn_Save");
						ComBtnDisable("btn_Save2");
						ComBtnDisable("btn_Amend");
						ComBtnDisable("btn_AmendCancel");
						ComBtnDisable("btn_Delete2");
						ComBtnDisable("btn_Amend2");
						ComBtnDisable("btn_AmendCancel2");	
						ComBtnDisable("btn_AcceptAll");
						ComBtnDisable("btn_CancelAll"); 
						ComBtnDisable("btn_New2");
						for (var i=1; i <= sheetObjects[0].RowCount();i++){
							sheetObjects[0].SetCellEditable(i,"cntr_lod_ut_cd",0);
							sheetObjects[0].SetCellEditable(i,"prop_scp_mqc_qty",0);
						}
						for (var i=1; i <= sheetObjects[1].RowCount();i++){
							sheetObjects[1].SetCellEditable(i,"sub_mqc_ctnt",0);
						}
					}					
					for (var i=1; i <= sheetObjects[0].RowCount();i++){
						sheetObjects[0].SetCellEditable(i,"coffr_mqc_qty",0);
					}
					break;
				case 'A': // Approved
					ComBtnDisable("btn_Save");
					ComBtnDisable("btn_Save2");
					ComBtnDisable("btn_New2");
					ComBtnDisable("btn_Delete2");
					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");				
					ComBtnDisable("btn_Delete2");
					ComBtnDisable("btn_Amend2");
					ComBtnDisable("btn_AmendCancel2");						
					ComBtnDisable("btn_AcceptAll");
					ComBtnDisable("btn_CancelAll");
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");
					ComBtnDisable("btn_Accept2");
					ComBtnDisable("btn_AcceptCancel2");							
					for (var i=1; i <= sheetObjects[0].RowCount();i++){
						sheetObjects[0].SetCellEditable(i,"cntr_lod_ut_cd",0);
						sheetObjects[0].SetCellEditable(i,"prop_scp_mqc_qty",0);
						sheetObjects[0].SetCellEditable(i,"coffr_mqc_qty",0);
					}
					for (var i=1; i <= sheetObjects[1].RowCount();i++){
						sheetObjects[1].SetCellEditable(i,"sub_mqc_ctnt",0);
					}	
					break;
				case 'Q':// Requested - Prohibit modify related to save  - If there is countoffer, Authority User can modify it 
					ComBtnDisable("btn_Save2");
					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");
					ComBtnDisable("btn_New2");
					ComBtnDisable("btn_Delete2");
					ComBtnDisable("btn_Amend2");
					ComBtnDisable("btn_AmendCancel2");						
					ComBtnDisable("btn_AcceptAll");
					ComBtnDisable("btn_CancelAll");
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");
					ComBtnDisable("btn_Accept2");
					ComBtnDisable("btn_AcceptCancel2");
					if (aproUsrFlg == "true"){
						if (amdt_seq != "0"){
							ComBtnEnable("btn_Save");
							ComBtnEnable("btn_AcceptAll");
							ComBtnEnable("btn_CancelAll");
							ComBtnEnable("btn_Accept");
							ComBtnEnable("btn_AcceptCancel");
							ComBtnEnable("btn_Accept2");
							ComBtnEnable("btn_AcceptCancel2");							
						}else{
							ComBtnDisable("btn_Save");
						}
						for (var i=1; i <= sheetObjects[0].RowCount();i++){
							sheetObjects[0].SetCellEditable(i,"cntr_lod_ut_cd",0);
							sheetObjects[0].SetCellEditable(i,"prop_scp_mqc_qty",0);
							if (sheetObjects[0].GetCellValue(i, "prc_prog_sts_cd") == "A"){
								sheetObjects[0].SetCellEditable(i,"coffr_mqc_qty",0);
							}else{
								sheetObjects[0].SetCellEditable(i,"coffr_mqc_qty",1);
							}
						}
					}else{
						ComBtnDisable("btn_Save");
						ComBtnDisable("btn_AcceptAll");
						ComBtnDisable("btn_CancelAll");
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
						ComBtnDisable("btn_Accept2");
						ComBtnDisable("btn_AcceptCancel2");		
						for (var i=1; i <= sheetObjects[0].RowCount();i++){
							sheetObjects[0].SetCellEditable(i,"cntr_lod_ut_cd",0);
							sheetObjects[0].SetCellEditable(i,"prop_scp_mqc_qty",0);
							sheetObjects[0].SetCellEditable(i,"coffr_mqc_qty",0);
						}
					}											
					for (var i=1; i <= sheetObjects[1].RowCount();i++){
						sheetObjects[1].SetCellEditable(i,"sub_mqc_ctnt",0);
					}						
					break;
				case 'R':  // Returned
					ComBtnDisable("btn_Save2");
					ComBtnDisable("btn_Save");
					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");					
					ComBtnDisable("btn_New2");
					ComBtnDisable("btn_Delete2");
					ComBtnDisable("btn_Amend2");
					ComBtnDisable("btn_AmendCancel2");	
					ComBtnDisable("btn_AcceptAll");
					ComBtnDisable("btn_CancelAll");
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");
					ComBtnDisable("btn_Accept2");
					ComBtnDisable("btn_AcceptCancel2");			
					if(reqUsrFlg == "true"){
						ComBtnEnable("btn_AcceptAll");
						ComBtnEnable("btn_Accept");
						ComBtnEnable("btn_Accept2");
					}
					if (aproUsrFlg == "true"){
						ComBtnEnable("btn_AcceptAll");
						ComBtnEnable("btn_CancelAll");
						ComBtnEnable("btn_Accept");
						ComBtnEnable("btn_AcceptCancel");
						ComBtnEnable("btn_Accept2");
						ComBtnEnable("btn_AcceptCancel2");	
					}
					for (var i=1; i <= sheetObjects[0].RowCount();i++){
						sheetObjects[0].SetCellEditable(i,"cntr_lod_ut_cd",0);
						sheetObjects[0].SetCellEditable(i,"prop_scp_mqc_qty",0);
						sheetObjects[0].SetCellEditable(i,"coffr_mqc_qty",0);
					}
					for (var i=1; i <= sheetObjects[1].RowCount();i++){
						sheetObjects[1].SetCellEditable(i,"sub_mqc_ctnt",0);
					}
					break;
				case 'F': // Filed
					ComBtnDisable("btn_Save");
					ComBtnDisable("btn_Save2");
					ComBtnDisable("btn_New2");
					ComBtnDisable("btn_Delete2");
					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");
					ComBtnDisable("btn_Amend2");
					ComBtnDisable("btn_AmendCancel2");						
					ComBtnDisable("btn_AcceptAll");
					ComBtnDisable("btn_CancelAll");
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");
					ComBtnDisable("btn_Accept2");
					ComBtnDisable("btn_AcceptCancel2");							
					for (var i=1; i <= sheetObjects[0].RowCount();i++){
						sheetObjects[0].SetCellEditable(i,"cntr_lod_ut_cd",0);
						sheetObjects[0].SetCellEditable(i,"prop_scp_mqc_qty",0);
						sheetObjects[0].SetCellEditable(i,"coffr_mqc_qty",0);
					}
					for (var i=1; i <= sheetObjects[1].RowCount();i++){
						sheetObjects[1].SetCellEditable(i,"sub_mqc_ctnt",0);
					}	
					break;
				case 'C': //  // Cancled
					ComBtnDisable("btn_Save");
					ComBtnDisable("btn_Save2");
					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");
					ComBtnDisable("btn_Amend2");
					ComBtnDisable("btn_AmendCancel2");						
					ComBtnDisable("btn_AcceptAll");
					ComBtnDisable("btn_CancelAll");
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");
					ComBtnDisable("btn_Accept2");
					ComBtnDisable("btn_AcceptCancel2");							
					for (var i=1; i <= sheetObjects[0].RowCount();i++){
						sheetObjects[0].SetCellEditable(i,"cntr_lod_ut_cd",0);
						sheetObjects[0].SetCellEditable(i,"prop_scp_mqc_qty",0);
						sheetObjects[0].SetCellEditable(i,"coffr_mqc_qty",0);
					}
					for (var i=1; i <= sheetObjects[1].RowCount();i++){
						sheetObjects[1].SetCellEditable(i,"sub_mqc_ctnt",0);
					}		
					break;
				default:
    				showButton("btn_Amend");
    				showButton("btn_AmendCancel");
    				showButton("btn_Amend2");
    				showButton("btn_AmendCancel2");
    				ComBtnEnable("btn_AcceptAll");
    				ComBtnEnable("btn_CancelAll");
    				ComBtnEnable("btn_Accept");
    				ComBtnEnable("btn_AcceptCancel");
    				ComBtnEnable("btn_Accept2");
    				ComBtnEnable("btn_AcceptCancel2");
					break;
			} 		
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}      
    /**
    * Compare Main MQC with Scope MQC. <br>
    * when Scope MQC is bigger, you cannot save it.<br>
    * <br><b>Example :</b>
    * <pre>
    *     mqcCheck (sheetObj);
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {string} isAll   Y: Scope Mqc Gross Sum 
    *                         N: Sum of Service Scope MQC except seleted row.l
    * @author 
    * @version 2009.04.17
    */	
	function mqcCheck (sheetObj, isAll){
		var formObj=document.form;
		if (formObj.save_gbn.value == "Y"){// When it saves Main and Scope. Do not check when it saves Scope and Main together			
			return true;
		}
		if (isAll !="Y"){
			formObj.f_cmd.value=SEARCH03;			
		}else{
			formObj.f_cmd.value=SEARCH04;
		}
 		var sXml=sheetObj.GetSearchData("ESM_PRI_0020GS.do", FormQueryString(formObj));
		var arrData=ComPriXml2Array(sXml, "prop_scp_mqc_qty");
		if (arrData != null && arrData.length > 0) {
			if (isAll != "Y"){
				var scpMqc=0;
				if (sheetObj.GetCellValue(sheetObj.RowCount(),"coffr_mqc_qty") != 0){
					scpMqc=sheetObj.GetCellValue(sheetObj.RowCount(),"coffr_mqc_qty");
				}else{
					scpMqc=sheetObj.GetCellValue(sheetObj.RowCount(),"prop_scp_mqc_qty");
				}
				if (arrData[0][0] != ""){
					scpMqc=parseInt(scpMqc) + parseInt(arrData[0][0]);	
				}				
				if (ComParseInt(scpMqc) > ComParseInt(ComGetUnMaskedValue(formObj.sc_mqc.value,",",","))){// Prohibit to save if it is bigger
					return false;
				}
			}else{
				var scpMqc=sheetObj.GetCellValue(sheetObj.RowCount(),"prop_scp_mqc_qty");
				if (parseInt(arrData[0][0]) > parseInt(scpMqc)){					
					return false;
				}
			}
		}
		return true;	
	}
    /**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *        handling logic
     *     }
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {form} formObj mandatory html form object
     * @param {int} sAction mandatory,Constant Variable
     * @returns bool <br>
     *          true  : valid<br>
     *          false : inValid
     * @author 
     * @version 2009.04.17
     */
  	function validateForm(sheetObj, formObj, sAction) {
  		switch (sAction) {
	  		case IBDELETE: // Delete
		 	 	if (sheetObj.GetSelectRow()<= 0){
					ComShowCodeMessage('PRI01002');
					return false;
			 	 }else{
			 		 return true;
			 	 }
				break;
	  		case IBSAVE://save
				var sParam=FormQueryString(formObj);
				var sParamSheet=sheetObj.GetSaveString();
				if (sParamSheet == ""){
					return false;
				}
				if (!sheetObj.IsDataModified()) {
					ComShowCodeMessage("PRI00301");
					return false;
				}
	  			return true;
	  			break;
	  		case MODIFY03: // amend
		 	 	if (sheetObj.GetSelectRow()<= 0){
					ComShowCodeMessage('PRI01002');
					return false;
			 	 }else{
			 		 return true;
			 	 }
				break;  			
  		}//end switch
  	}
     /**
      * Process Accept to checked rows on sheet.
      * sheetObj    : sheet object
      * formObj     : form object
      * isAll       : Whole designated Rows applied or not flag
      *           ex) sheetAcceptCheckedRows(sheetObjects[1],document.form,true);
      * @return {string}
      * @author 
      * @version 2009.05.29
      */
     function sheetAcceptCheckedRows(sheetObj,formObj,isAll){
         var amdt_seq=formObj.amdt_seq.value;
         var prop_sts_cd=getMainStatus();
         var eff_dt=formObj.eff_dt.value;
         if(isAll == undefined || isAll ==""){
             isAll=false;
         }
         if(prop_sts_cd == "R") {
             if(isAll){
                 comChangeValue(sheetObj, "chk", "0");
                 comChangeValue(sheetObj, "chk", "1", "n1st_cmnc_amdt_seq|prc_prog_sts_cd", amdt_seq+"|R");
                 if(sheetObj.CheckedRows("chk") == 0) {
                     ComShowCodeMessage("PRI00301");
                     return false;
                 }
             }
             var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
             if(chkArr.length == 0){
                 sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
                 chkArr[0]=sheetObj.GetSelectRow();
             }
             for(i=0;i<chkArr.length;i++){
            	 if(sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd")!="R" || sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq")!=amdt_seq){
                     sheetObj.SetCellValue(chkArr[i],"chk","0",0);
                     ComShowCodeMessage("PRI00313");
                     return false;
                 }
             }
             comChangeValue(sheetObj, "prc_prog_sts_cd|prc_prog_sts_dtl|ibflag", "A|Accepted|U", "chk", "1");
             var sParam=FormQueryString(formObj);
             var sParamSheet=sheetObj.GetSaveString(false, false, "chk");
             sParam=sParam + "&" + sParamSheet;
              var sXml=sheetObj.GetSaveData("ESM_PRI_0020GS.do", sParam);
              sheetObj.LoadSaveData(sXml, false, "chk");
             comChangeValue(sheetObj, "chk|ibflag", "0|R", "chk", "1");
         } else {
             if(isAll){
                 comChangeValue(sheetObj, "chk", "0");
                 comChangeValue(sheetObj, "chk", "1", "n1st_cmnc_amdt_seq|prc_prog_sts_cd", amdt_seq+"|I");
                 if(sheetObj.CheckedRows("chk")==0){
                     //ComShowCodeMessage("PRI00301");
                     ComShowCodeMessage("PRI00329");
                     return false;
                 }
             }
             var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
             if(chkArr.length == 0){
                 sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
                 chkArr[0]=sheetObj.GetSelectRow();
             }
             for(i=0;i<chkArr.length;i++){
                 /*
if((sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd")!="I" && sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd")!="R") || sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq")!=amdt_seq){
                     sheetObj.SetCellValue(chkArr[i],"chk","0",0);
                     ComShowCodeMessage("PRI00313");
                     return false;
                 }
                 */
            	 if(sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd")!="I" && sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd")!="R"){
                     sheetObj.SetCellValue(chkArr[i],"chk","0",0);
                     ComShowCodeMessage("PRI01037");
                     return false;
                 }
            	 if(sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq")!=amdt_seq){
                     sheetObj.SetCellValue(chkArr[i],"chk","0",0);
                     ComShowCodeMessage("PRI00313");
                     return false;
                 }
             }
             comChangeValue(sheetObj, "prc_prog_sts_cd|prc_prog_sts_dtl|ibflag", "A|Accepted|U", "chk", "1");
             var sParam=FormQueryString(formObj);
             var sParamSheet=sheetObj.GetSaveString(false, false, "chk");
             sParam=sParam + "&" + sParamSheet;
              var sXml=sheetObj.GetSaveData("ESM_PRI_0020GS.do", sParam);
              sheetObj.LoadSaveData(sXml, false, "chk");
             comChangeValue(sheetObj, "chk|ibflag", "0|R", "chk", "1");
         }
         return true;
     }     
     /**
      * Process Accept Cancel to checked rows on sheet.  
      * sheetObj    : sheet object
      * formObj     : form object  
      * isAll       : Whole designated Rows applied or not flag
      * 			ex) sheetAcceptCancelReturnCheckedRows(sheetObjects[1],document.form,true);
      * @return {string} 
      * @author 
      * @version 2009.05.29
      */		
  	function sheetAcceptCancelReturnCheckedRows(sheetObj,formObj,isAll){
  		var eff_dt=formObj.eff_dt.value;
  		var amdtSeq=formObj.amdt_seq.value;
  		if(isAll == undefined || isAll ==""){
  			isAll=false;
  		}
  		if(isAll){
  			comChangeValue(sheetObj, "chk", "0");
  			comChangeValue(sheetObj, "chk", "1", "n1st_cmnc_amdt_seq|prc_prog_sts_cd", amdtSeq+"|A");
  			if(sheetObj.CheckedRows("chk")==0){
  				ComShowCodeMessage("PRI00301");
  				return false;				
  			}			
  		}
  		var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
  		if(chkArr.length == 0){
  			sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
  			chkArr[0]=sheetObj.GetSelectRow();
  		}
  		for(i=0;i<chkArr.length;i++){
  			if(sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd")!="A" || sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq")!=amdtSeq){
  				sheetObj.SetCellValue(chkArr[i],"chk","0",0);
  				ComShowCodeMessage("PRI00313");
  				return false;
  			}
  		}
  		for(i=0;i<chkArr.length;i++){
  			sheetObj.SetCellValue(chkArr[i], "chk" ,"1",0);
  			if (sheetObj.GetCellValue(chkArr[i], "coffr_mqc_qty") !="0"){
  				sheetObj.SetCellValue(chkArr[i], "prc_prog_sts_cd" ,"R",0);
  			}else{
  				sheetObj.SetCellValue(chkArr[i], "prc_prog_sts_cd" ,"I",0);
  			}
  		}  		
  		var sParam=FormQueryString(formObj);
  		var sParamSheet=sheetObj.GetSaveString(false, false, "chk");
  		sParam=sParam + "&" + sParamSheet;
   		var sXml=sheetObj.GetSaveData("ESM_PRI_0020GS.do", sParam);
   		sheetObj.LoadSaveData(sXml, false, "chk");
  		comChangeValue(sheetObj, "chk|ibflag", "0|R", "chk", "1");					
  		return true;
  	}    
      /**
      * Amending <br>
      * sheetObj    : sheet object
      * formObj     : form object
      * sRow        : Row
      * sAction     : M : Update Amend, D : Delete Amend
      * sCols       : Inputting target to be copied except eff_dt, src_info_cd, prc_prog_sts_cd. using "|" delimiter
      *          ex) comSheetAmendRow(sheetObjects[1],document.form,sheetObjects[1].SelectRow,"A", "loc_cd|ofc_cd");
      * @return {string}
      * @author 
      * @version 2009.05.29
      */
     function sheetAmendRow(sheetObj,formObj,sRow,sAction, sCols){
         var prop_no=formObj.prop_no.value;
         var amdt_seq=formObj.amdt_seq.value;
         var pre_amdt_seq=formObj.pre_amdt_seq.value;
         var eff_dt=formObj.eff_dt.value;
         var exp_dt=formObj.exp_dt.value;
         var pre_exp_dt=formObj.pre_exp_dt.value;
         var arrCols=sCols.split("|");
         var dur_dup_flg="";
         var sheetID=sheetObj.id;
         if (sheetID == "sheet1"){
        	 dur_dup_flg=formObj.dur_dup_flg.value;
         }else{
        	 dur_dup_flg=formObj.dur_sub_dup_flg.value;
         }
         //Removing check
         sheetObj.SetCellValue(sRow,"chk",0);
         // except already amended row
         	if(sheetObj.GetCellValue(sRow,"amdt_seq")!= amdt_seq || sheetObj.GetCellValue(sRow,"n1st_cmnc_amdt_seq")== amdt_seq){
             ComShowCodeMessage("PRI00313");
             return false;
         }
         // Setting sRow to set base row for DataCopy/ Insert
         sheetObj.SetSelectRow(sRow);
         var idx=sheetObj.DataCopy();     // new row
         var idx2=idx-1;                  // old row
         // Add, Modify, Delete Common New Row Creation
         sheetObj.SetCellValue(idx,"eff_dt",eff_dt,0);
         sheetObj.SetCellValue(idx,"n1st_cmnc_amdt_seq",amdt_seq,0);
         sheetObj.SetCellValue(idx,"prc_prog_sts_cd","I",0);
         sheetObj.SetCellValue(idx,"src_info_cd","AM",0);
         sheetObj.SetRowStatus(idx,"U");
		 sheetObj.SetCellValue(idx, "prop_scp_mqc_qty","",0);
		 sheetObj.SetCellValue(idx, "coffr_mqc_qty","",0);
		 sheetObj.SetCellValue(idx, "fnl_mqc_qty","",0);
         for(x=0;x<arrCols.length;x++){
             sheetObj.SetCellEditable(idx,arrCols[x],1);
         }
          sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#FF0000");
          sheetObj.SetCellFont("FontStrike", idx2, 1, idx2, sheetObj.LastCol(),true);
         if(dur_dup_flg=="Y"){
             sheetObj.SetCellValue(idx2,"exp_dt",pre_exp_dt,0);
         }
         sheetObj.SetCellValue(idx2,"amdt_seq",pre_amdt_seq,0);
         sheetObj.SetRowEditable(idx2,0);
         // Delete, Add Case, New Row Update
         if(sAction=="D"){
             sheetObj.SetCellValue(idx,"src_info_cd","AD",0);
             for(z=0;z<arrCols.length;z++){
                 sheetObj.SetCellEditable(idx,arrCols[z],0);
             }
         }
         sheetObj.SetRowStatus(idx2,"R");
         //backcolor change
         changeSelectBackColor(sheetObj, sheetObj.GetCellValue(idx, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
         return true;
     }
    /**
     * Cancelling amendment of row
     * sheetObj    : sheet object
     * formObj     : form object
     * sRow        : Row
     * sAction     : A : Insert Amend, M : Update Amend, D : Delete Amend
     * sCols       : Inputting target to be copied except eff_dt, src_info_cd, prc_prog_sts_cd. using "|" delimiter
     *           ex) comSheetAmendCancelRow(sheetObjects[1],document.form,sheetObjects[1].SelectRow,"A", "loc_cd|ofc_cd");
     * @return {string}
     * @author 
     * @version 2009.05.29
     */
     function sheetAmendCancelRow(sheetObj,formObj,sRow,sAction, sCols){
    	 var amdt_seq=formObj.amdt_seq.value;
         var eff_dt=formObj.eff_dt.value;
         var exp_dt=formObj.exp_dt.value;
         var arrCols=sCols.split("|");
         var pre_amdt_seq=formObj.pre_amdt_seq.value;
         var dur_dup_flg="";
         var sheetID=sheetObj.id;
         if (sheetID == "sheet1"){
        	 dur_dup_flg=formObj.dur_dup_flg.value;
         }else{
        	 dur_dup_flg=formObj.dur_sub_dup_flg.value;
         }
         sheetObj.SetCellValue(sRow,"chk",0);
         // handling in case of  n1st_cmnc_amdt_seq == amdt_seq in A/M/D
         if(sheetObj.GetCellValue(sRow,"n1st_cmnc_amdt_seq")!= amdt_seq){
             ComShowCodeMessage("PRI00313");
             return false;
         }
         var idx=sRow-1;
         var idx2=sRow;
         if(sAction=="A"&&(sheetObj.GetCellValue(sRow,"src_info_cd")=="NW"||sheetObj.GetCellValue(sRow,"src_info_cd")=="GM"||sheetObj.GetCellValue(sRow,"src_info_cd")=="GC")){
             sheetObj.SetRowStatus(sRow,"D");
             sheetObj.SetRowEditable(sRow,0);
             sheetObj.SetRowHidden(sRow,1);
             return false;
         }else{
        	 if(sheetObj.GetCellValue(sRow,"src_info_cd")!="AD"&&sheetObj.GetCellValue(sRow,"src_info_cd")!="AM"){
                 ComShowCodeMessage("PRI00313");
                 return false;
             }
             if(dur_dup_flg=="Y"){            
             	sheetObj.SetCellValue(idx,"exp_dt",exp_dt,0);
             }
              
             sheetObj.SetCellFont("FontStrike", idx, 1, idx, sheetObj.LastCol(), false);
             sheetObj.SetCellFont("FontItalic", idx, 1, idx, sheetObj.LastCol(),0);
             sheetObj.SetCellValue(idx,"amdt_seq",sheetObj.GetCellValue(idx2,"amdt_seq"),0);
             sheetObj.SetCellValue(idx2,"amdt_seq",pre_amdt_seq,0);
             sheetObj.SetRowEditable(idx,1);
             sheetObj.SelectCell(idx,"chk");
             sheetObj.SetRowStatus(idx,"U");
             sheetObj.RowDelete(idx2, false);
         }
         return true;
     }          
     /**
     * Accepting or initializing row <br>
     * sheetObj    : sheet object
     * type   		: A : Accept , I : Initial R :Returned
     *           ex) changeAcceptStatus(sheetObjects[1],"A");
     * @author 
     * @version 2009.05.29
     */         
     function changeAcceptStatus(sheetObj,type){
	   	 var formObj=document.form;
	   	 var amdtSeq=formObj.amdt_seq.value;
	   	 var sheetObj2=sheetObjects[1];
	   	 var stsCd="";
	   	 var stsDtl="";
	   	 if (type == "A"){
	   		 stsCd="A";
	   		 stsDtl="Accepted";
	   	 }else if (type =="I"){
	   		 stsCd="I";
	   		 stsDtl="Initial";
	   	 }else{
	   		 stsCd="R";
	   		 stsDtl="Returned";
	   	 }
	   	 for (var i=1; i <=2; i++){
	   		 if (sheetObj.GetCellValue(i, "n1st_cmnc_amdt_seq") == amdtSeq && sheetObj.GetCellValue(i, "prc_prog_sts_cd") != stsCd ){
	   			 sheetObj.SetCellValue(i, "prc_prog_sts_cd",stsCd);
	   			 sheetObj.SetCellValue(i, "prc_prog_sts_dtl",stsDtl);
	   			 if (stsCd=="R" || stsCd=="I"){
	   				sheetObj.SetCellValue(i, "fnl_mqc_qty",0);
	   			 }else{
	   				 if (getMainStatus() =="Q"){
	   					 sheetObj.SetCellValue(i, "fnl_mqc_qty",sheetObj.GetCellValue(i, "prop_scp_mqc_qty"));
	   				 }else if (getMainStatus() =="R"){
	   					 sheetObj.SetCellValue(i, "fnl_mqc_qty",sheetObj.GetCellValue(i, "coffr_mqc_qty"));
	   				 }	   				 
	   			 }
	   		 }
			if (sheetObj2.GetCellValue(i, "n1st_cmnc_amdt_seq") == amdtSeq && sheetObj2.GetCellValue(i, "prc_prog_sts_cd") != stsCd ){
	   			 sheetObj2.SetCellValue(i, "prc_prog_sts_cd",stsCd);
	   			 sheetObj2.SetCellValue(i, "prc_prog_sts_dtl",stsDtl);
	   		 }   		 
	   	 }
     }     
     /**
     * Retrieve Main Status. <br>
     * @return {string}
     * @author 
     * @version 2009.05.29
     */    
     function getMainStatus(){
    	 return opener.sheetObjects[0].GetCellValue(1, "prop_sts_cd");
     }
     /**
      * Retrieving a count of scope when saving<br>
      * When there's one SVC Scope, confirm whether Main & Scope save at the same time.<br> 
      * <br><b>Example :</b>
      * <pre>
      *		checkAllSave();
      * </pre>
      * @param  void
      * @author 
      * @version 2009.05.07
      */  
     function checkAllSave(){
         var formObj=document.form;
         var sheetObj=sheetObjects[0];
         if (formObj.amendcancel_gbn.value == "Y"){//Do not check when AMEND CANCEL
        	 return;
         }
         formObj.f_cmd.value=SEARCH05;
         try{
             var sParam=FormQueryString(formObj);            
              var sXml=sheetObj.GetSearchData("ESM_PRI_0020GS.do" , sParam);
             var arrData=ComPriXml2Array(sXml, "etc1|etc2");
             if (arrData != null && arrData.length > 0) {
                 var cnt=0;
                 cnt=ComParseInt(arrData[0][1]);               
                 var scpCd="";              
                 scpCd=arrData[0][0];
                 var msgCd="";                 
                 if (ComTrim(formObj.svc_scp_nm.value) != ""){//scope
                	 msgCd="PRI01133";//scope
                 }else{//main
                	 msgCd="PRI01134";//main
                 }
            	 if (cnt == 1 ){                 		
            		 if (ComShowCodeConfirm(msgCd)){
						formObj.save_gbn.value="Y";
						formObj.save_scp.value=scpCd;
						if (sheetObj.GetCellValue(sheetObj.RowCount(), "coffr_mqc_qty") =="0"
							|| sheetObj.GetCellValue(sheetObj.RowCount(), "coffr_mqc_qty") ==""){
							formObj.sc_mqc.value=sheetObj.GetCellValue(sheetObj.RowCount(), "prop_scp_mqc_qty");
						}else{
							formObj.sc_mqc.value=sheetObj.GetCellValue(sheetObj.RowCount(), "coffr_mqc_qty");
						}						
					}else{
						formObj.save_gbn.value="N"; 
						formObj.save_scp.value="";
					}             		 
                 } else if(cnt > 1) {
                	 formObj.save_gbn.value="N";
                	 formObj.save_scp.value="";
                 }
            	 // Setting Y Whe Amendment Cancelled.
            	 formObj.amendcancel_gbn.value="N";
             }        	
         } catch (e) {
         	if (e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e.message);
             }
         }finally{
         }       
     }        
