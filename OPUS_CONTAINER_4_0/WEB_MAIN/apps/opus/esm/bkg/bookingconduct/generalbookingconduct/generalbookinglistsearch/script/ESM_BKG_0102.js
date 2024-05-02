/*=========================================================
 * 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0102.js
*@FileTitle  :  Compulsory Firm
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/04
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Added code to make a good JSDoc ------------------*/
   /**
     * @fileoverview JavaScript File is commonly using. calendar functions have is defined.
     * @author 
     */
    /**
     * @extends 
     * @class esm_bkg_0102 : business script for esm_bkg_0102
     */
    function esm_bkg_0102() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
 // Common global variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
        /*****  Tab ->two or more sheet : sheet  a variable assignment *****/
		var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var obj = event.target || ComGetEvent();
    		   if ($(obj).prop('disabled')) {
    			   return;
    		 }
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH,"");
					break;
				case "btn_New":
//					sheetObject1.RemoveAll();
//																					
					formObject.reset();		
					bkg_sts_cd.SetSelectIndex(0);
					bkg_sts_cd.SetSelectIndex(1);
					break;						
				case "btn_CompulsoryFirm":
					doActionIBSheet(sheetObjects[0],formObject,IBSAVE,"");
					break;
		        case "btns_Calendar":
		            var cal=new ComCalendarFromTo();
		            cal.select(formObject.s_bkg_cre_dt,formObject.e_bkg_cre_dt, 'yyyy-MM-dd');
		            break;	
		        case "btn_Firm":
					doActionIBSheet(sheetObjects[0], formObject, MODIFY04);
                	break;
		        case "btn_Waiting":
					doActionIBSheet(sheetObjects[0], formObject, MODIFY05);
	              	break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("COM12111");   
    		} else {
    			ComShowMessage(e);
    		}
    	}
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
		var formObj=document.form;
		var sXml=ComGetObjValue(formObj.sXml);
		formObj.sXml.value=null;
		var arrXml=sXml.split("|$$|");    
		// Combo 
		if (arrXml.length > 0){
			ComBkgXml2ComboItem(arrXml[0], comboObjects[0], "val", "name");
		}     
		//comboObjects[0].Code2 = "W";
		ComBtnDisable("btn_Waiting");
		bkg_sts_cd.SetSelectIndex(1);
		initControl();
	}
     /**
      * HTML Control on the page  loaded dynamically  the event. <br>
      * {@ link # loadPage} function this function  call initializes the IBSheet Object. <br>
      * 
      * @param {ibsheet}
      *            sheetObj IBSheet Object
      * @param {int}
      *            sheetNo sheetObjects array  sequence number
      */
     function initControl() {
     	var formObject=document.form;
//         axon_event.addListenerFormat('keypress','bkg0102_keypress',formObject); //- When typing the keyboard
//         axon_event.addListenerForm  ('beforedeactivate', 'bkg0102_deactivate',  formObject); //- out  focus 
//         axon_event.addListenerFormat('beforeactivate', 'bkg0102_activate',    formObject); //- in  focus 
//         axon_event.addListener('keydown', 'ComKeyEnter', 'form');
     }   
      /**
       * registering IBCombo Object as list
       * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
       **/
     function setComboObject(combo_obj){
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
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":      //sheet1 init
            	with(sheetObj){
                 
              //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	              var HeadTitle1="|Sel.|No.|Booking No.|STS|T.VVD|T.POL|Shipper|Forwarder|Rep. Commodity|Rep. Commodity|Q’ty|Q’ty|K.Ton|POD|bkg_wt_chk_flg|edi_hld_flg";
	              var HeadTitle2="|Sel.|No.|Booking No.|STS|T.VVD|T.POL|Shipper|Forwarder|Code|Description|FEU|TEU|K.Ton|POD|bkg_wt_chk_flg|edi_hld_flg";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"},
	                          { Text:HeadTitle2, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	                     {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bkg_number",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_t_vvd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:170,  Align:"Left",    ColMerge:1,   SaveName:"s_cust_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:170,  Align:"Left",    ColMerge:1,   SaveName:"f_cust_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:140,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"feu",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"teu",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"ton",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no" },
	                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bdr_flg" },
	                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bkg_wt_chk_flg" },
	                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"edi_hld_flg" }];
	               
	              InitColumns(cols);
	              SetEditable(1);
//	              SetSheetHeight(352);
	              updateSheetSize(sheetObj);
            }
            break;
        }
    }

    $(window).resize(function() {
		if(this.resizeTO) {
			clearTimeout(this.resizeTO);
		}
		this.resizeTO = setTimeout(function() {
			$(this).trigger('resizeEnd');
		}, 300);
 });
 
 $(window).on('resizeEnd', function() {
	 updateSheetSize(sheetObjects[0]);
 });
 
 function updateSheetSize(sheetObj){
	 var obj = $("#" + sheetObj.id).offset();
	 var marginDefault = 50;
	 var marginHeight = obj.top + marginDefault;
    var height = $(window).height();

    with(sheetObj){
        SetSheetHeight(height - marginHeight);
    }
 }
 
      // Sheet handling process
    function doActionIBSheet(sheetObj,formObj,sAction, custTp) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(custTp == "S"){
					var custCntCd=formObj.s_cust_cnt_cd.value;
					var custSeq=formObj.s_cust_seq.value;
					formObj.f_cmd.value=SEARCH01;
//					sheetObj.SetWaitImageVisible(0);
					sheetObj.WaitImageVisible=false;
//					ComOpenWait(true);
					var sXml=sheetObj.GetSearchData("ESM_BKG_0102GS.do?cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq , FormQueryString(formObj));
//					ComOpenWait(false); 
					if(ComGetEtcData(sXml,ComWebKey.Trans_Result_Key)=="S"){
						formObj.s_cust_nm.value=ComGetEtcData(sXml,"cust_nm");
					} else {
						formObj.s_cust_nm.value="";
					}
				} else if(custTp == "F"){
					var custCntCd=formObj.f_cust_cnt_cd.value;
					var custSeq=formObj.f_cust_seq.value;		
					formObj.f_cmd.value=SEARCH01;
//					sheetObj.SetWaitImageVisible(0);
					sheetObj.WaitImageVisible=false;
//					ComOpenWait(true);
					var sXml=sheetObj.GetSearchData("ESM_BKG_0102GS.do?cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq , FormQueryString(formObj));
//					ComOpenWait(false); 
					if(ComGetEtcData(sXml,ComWebKey.Trans_Result_Key)=="S"){
						formObj.f_cust_nm.value=ComGetEtcData(sXml,"cust_nm");
					} else {
						formObj.f_cust_nm.value="";
					}
				} else {					
					if(validateForm(sheetObj, formObj, sAction)){
						formObj.f_cmd.value=SEARCH;
//						sheetObj.SetWaitImageVisible(0);
						sheetObj.WaitImageVisible=false;
						ComOpenWait(true);						
						var sXml=sheetObj.GetSearchData("ESM_BKG_0102GS.do" , FormQueryString(formObj));
						ComOpenWait(false); 
						sheetObj.LoadSearchData(sXml,{Sync:1} );
//no support[check again]CLT 						if(sheetObj.Rows == 3){ 
//						var bkgStsCd=sheetObj.GetCellValue(2, "bkg_sts_cd");
//							if(bkgStsCd.length == 1){
//								comboObjects[0].SetSelectCode(bkgStsCd,false);
//								bkg_sts_cd_OnChange(formObj, bkgStsCd, bkgStsCd);
//								
//							}
					}
				}				
			break;
			case IBSAVE:        //Save
				if(validateForm(sheetObj, formObj, sAction)){
					var chkRowArr=sheetObj.FindCheckedRow("chk");
					var chkRow=chkRowArr.split("|");
//					sheetObj.SetWaitImageVisible(0);
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);
					for (var idx=0;idx<chkRow.length;idx++) {
						var param="?f_cmd=" + MODIFY;
						param=param + "&bkg_no=" + sheetObj.GetCellValue(chkRow[idx], "bkg_no");
						var sXml=sheetObj.GetSaveData("ESM_BKG_0102GS.do"+param);
						if(ComGetEtcData(sXml,ComWebKey.Trans_Result_Key)!="S"){
							sheetObj.LoadSearchData(sXml,{Sync:1} );
							break;
						}
					}
					ComOpenWait(false); 
					if(ComGetEtcData(sXml,ComWebKey.Trans_Result_Key)=="S"){	
						ComBkgSaveCompleted();							
					}
					doActionIBSheet(sheetObj,formObj,IBSEARCH,"");			
				}
			break;
			case MODIFY04:      //Waiting -> Firm (pending remove)
				if(validateForm(sheetObj, formObj, sAction)){
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);
	    	      	for (var idx=sheetObj.HeaderRows(); idx<=sheetObj.LastRow(); idx++) {
	    	      		if(sheetObj.GetCellValue(idx,"chk") == "1"){
	    	      			var bkgWtChkFlg = sheetObj.GetCellValue(idx, "bkg_wt_chk_flg");
	    	      			var ediHldFlg = sheetObj.GetCellValue(idx, "edi_hld_flg");
	    	      			var polCd = sheetObj.GetCellValue(idx, "pol_cd");
	    	      			var param = "?f_cmd=" + MODIFY04 + "&newStsCd=F&bkg_no=" + sheetObj.GetCellValue(idx, "bkg_no")+"&bkg_wt_chk_flg=" + bkgWtChkFlg + "&edi_hld_flg=" + ediHldFlg + "&bkg_pol_cd=" + polCd
	    	      						+ "&his_ui_nm=ESM_BKG_0102";
	    	      			var sXml=sheetObj.GetSaveData("ESM_BKG_0079_01GS.do" + param);
							if(ComGetEtcData(sXml, "isSuccess") != "Y"){
								sheetObj.LoadSearchData(sXml,{Sync:1} );
								break;
							}
	    	     		}
	    	      	}	    	      	
					ComOpenWait(false); 
				}
				if(ComGetEtcData(sXml, "isSuccess") == "Y"){
					ComBkgSaveCompleted();		
				}
				doActionIBSheet(sheetObj,formObj,IBSEARCH,"");
			break;			
			case MODIFY05:      //Firm -> Waiting
				if(validateForm(sheetObj, formObj, sAction)){
//					sheetObj.SetWaitImageVisible(0);
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);
	    	      	for (var idx=sheetObj.HeaderRows(); idx<=sheetObj.LastRow(); idx++) {
	    	      		if(sheetObj.GetCellValue(idx,"chk") == "1"){
	    	      			var param="?f_cmd=" + MODIFY05 + "&newStsCd=P&bkg_no=" + sheetObj.GetCellValue(idx, "bkg_no");
	    	      			var sXml=sheetObj.GetSaveData("ESM_BKG_0079_01GS.do" + param);
							if(ComGetEtcData(sXml, "isSuccess") != "Y"){
								sheetObj.LoadSearchData(sXml,{Sync:1} );
								break;
							}
	    	     		}
	    	      	}					
					ComOpenWait(false); 
				}
				if(ComGetEtcData(sXml, "isSuccess") == "Y"){
					ComBkgSaveCompleted();
				}
				doActionIBSheet(sheetObj,formObj,IBSEARCH,"");
			break;
        }
    }
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		var form=document.form;
		var fmDtObj=form.s_bkg_cre_dt;	
		var toDtObj=form.e_bkg_cre_dt;
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(formObj.bkg_no.value.length >10){
					return true;
				}
				if (formObj.s_bkg_cre_dt.value != "" && formObj.e_bkg_cre_dt.value != "") {
					if (ComGetDaysBetween(formObj.s_bkg_cre_dt.value, formObj.e_bkg_cre_dt.value)>31){
						ComShowMessage(msgs['BKG50469']);
						return false;
					} 
					if(!chkDate(fmDtObj)) { return false; }
					if(!chkDate(toDtObj)) { return false; }
					if(formObj.pol_cd.value.length==0 && formObj.pod_cd.value.length==0 
							&& formObj.bkg_ofc_cd.value.length==0 && formObj.ob_sls_ofc_cd.value.length==0){
						ComShowCodeMessage("BKG00104","POL or POD or B.OFC or S.OFC");			
						return false;
					} 
					return true;
				}
				if(formObj.bkg_vvd_cd.value.length != 9){
					ComShowCodeMessage("BKG00115");
					formObj.bkg_vvd_cd.focus();
					return false;
				}
			break;
			case IBSAVE:        //Save
				if(sheetObj.CheckedRows("chk") < 1){
					ComShowCodeMessage("BKG00155");
					return false;
				}else{
	    	      	for (var idx=sheetObj.HeaderRows(); idx<=sheetObj.LastRow(); idx++) {
	    	      		if(sheetObj.GetCellValue(idx,"chk") == "1"){
	    	      			if(sheetObj.GetCellValue(idx,"bdr_flg") == "Y"){
//	    	     				ComShowCodeMessage("BKG00003");
//	    	     				return false;
//	    	     				break;
	    	     			}
	    	     		}
	    	 	    } 							
				}				
			break;	
	    	case MODIFY04:      // Waiting -> Firm   
				if(sheetObj.CheckedRows("chk") < 1){
					ComShowCodeMessage("BKG00155");
					return false;
				}else{	        
			      	for (var idx=sheetObj.HeaderRows(); idx<=sheetObj.LastRow(); idx++) {
			      		if(sheetObj.GetCellValue(idx,"chk") == "1"){
			      			if(sheetObj.GetCellValue(idx,"bkg_sts_cd") == "F"){
			     				ComShowCodeMessage("BKG00383");
			     				return false;
			     				break;
			     			}
			     		}
			 	    } 	
				}
			break;      
        	case MODIFY05:      // Firm -> Waiting    
	        	if(sheetObj.CheckedRows("chk") < 1){
					ComShowCodeMessage("BKG00155");
					return false;
				}else{	        
					for (var idx=sheetObj.HeaderRows(); idx<=sheetObj.LastRow(); idx++) {
						if(sheetObj.GetCellValue(idx,"chk") == "1"){
							if(sheetObj.GetCellValue(idx,"bkg_sts_cd") == "W"){
			     				ComShowCodeMessage("BKG00383");
			     				return false;
			     				break;
			     			}
			     		}
			 	    } 
				}
				return true;        		
	    	break;              
        }
	    return true;
	}
//	function bkg_sts_cd_OnChange(formObj, Code ,oldindex, oldtext , newindex, newtext , newcode){
//		 
//		if(Code=="0"){
//			ComBtnEnable("btn_Firm");
//			ComBtnDisable("btn_Waiting");			
//		}else  {
//			ComBtnEnable("btn_Waiting");
//			ComBtnDisable("btn_Firm");			
//		}
//		
//	}
		 function bkg_sts_cd_OnChange(formObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {			 
			if(oldCode=="W"){
				ComBtnEnable("btn_Waiting");
				ComBtnDisable("btn_Firm");				
			}else  {				
				ComBtnEnable("btn_Firm");
				ComBtnDisable("btn_Waiting");	
			}
			form.bkg_sts_cd_text.value = formObj.GetText(parseInt(newIndex), 0);
		}
    /**
     * OnSaveEnd Event Call<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg 
     * @return 
     * @author 
     * @version 2009.05.17
     */ 	
// 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
// 		if (ErrMsg == "") {
//			ComBkgSaveCompleted();
//			sheetObj.RemoveAll();
//			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"");
//		}
//	}     	
//	function bkg0102_keypress(){
//	    switch(event.srcElement.dataformat){
//	    	case "engup":
//		        //English uppercase characters
//	    		ComKeyOnlyAlphabet('upper');
//		        break;
//	        case "engupnum":
//	            //the number + English capital letter
//	        	ComKeyOnlyAlphabet('uppernum');
//	            break;
//	        case "num":
//	            //Numeric input
//	        	ComKeyOnlyNumber(event.srcElement);
//	            break;	            
//	        default:
//	    }
//	}    
        
    
    function deactivateNew(obj) {
    	var formObj=document.form;
	    switch(ComGetEvent("name")) {
    		case "s_cust_cnt_cd":	    		
	    		if(formObj.s_cust_cnt_cd.value.length == 0 ){
	    			formObj.s_cust_nm.value="";	    			
	    		}
	    		break;
	    	case "s_cust_seq":	    		
	    		if(formObj.s_cust_cnt_cd.value.length > 0 && formObj.s_cust_seq.value.length > 0){
	    			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH, "S");
	    		}else{
	    			formObj.s_cust_nm.value="";
	    		}
	    		break;
    		case "f_cust_cnt_cd":	    		
	    		if(formObj.f_cust_cnt_cd.value.length == 0 ){
	    			formObj.f_cust_nm.value="";	    			
	    		}
	    		break;
	    	case "f_cust_seq":
	    		if(formObj.f_cust_cnt_cd.value.length > 0 && formObj.f_cust_seq.value.length > 0){
	    			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH, "F");
	    		}else{
	    			formObj.s_cust_nm.value="";
	    		}
	    		break;        	
	    	case "s_bkg_cre_dt":
	    		ComAddSeparator(ComGetEvent());
				break;
	    	case "e_bkg_cre_dt":
	    		ComAddSeparator(ComGetEvent());
				break;	    		
	    }
    }
    
	/**
	 * The onFocus event in HTML Control Validation Check. <br>
	 **/
	function activateNew(){
		//Input Validation to check
		switch(ComGetEvent("name")){	
	    	case "s_bkg_cre_dt":
	    		ComClearSeparator(ComGetEvent());
				break;
	    	case "f_bkg_cre_dt":
	    		ComClearSeparator(ComGetEvent());
				break;
			default:
				break;
		}
	}    
	/** 
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 chkDate <br>
	* Application 날짜 Validation을 체크한다. <br>
	* <br><b>Example :</b>
	* <pre>
	* </pre>
	* @param  {object} formObj : 폼 오브젝트
	* @return {boolean}
	* @see #
	* @author 김대호
	* @version 2010.01.19
	*/ 
	function chkDate(formObj) {
		var form=document.form;
	    var fmDtObj=form.s_bkg_cre_dt;
	    var toDtObj=form.e_bkg_cre_dt;
		var fmDtValue=fmDtObj.value.replace(/-/g,'');
		var toDtValue=toDtObj.value.replace(/-/g,'');
		if(fmDtValue != "" && toDtValue != "") {
			if( parseInt(fmDtValue,10) > parseInt(toDtValue,10) ) {
				ComShowCodeMessage("BKG95026", "From Date", "To Date");
				event.returnValue=false;			
				ComSetFocus(formObj);
				return false;
			}
		}
		return true;
	}
	
	function bkg0102_keydown(){
		var keyValue=ComGetEvent("keycode");
		 var formObject=document.form;
		 if(keyValue == 13){
			 try {
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH,"");
			} catch(err) { ComFuncErrMsg(err.message); }
		 }
	}
