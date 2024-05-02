/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0035.js
*@FileTitle : Prepayments Settlement
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_FMS_0035 : ESM_FMS_0035 definition of biz script for creation screen
     */
	// common global variables 
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1; 
	var sheetObjects=new Array();
	var sheetCnt=0;
	var prefix="sheet1_";
	var pre_eff_dt = "";
	// Event handler processing by button click event*/
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	var sheetObject=sheetObjects[0];
       var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
          	switch(srcName) {
            	case "btn_retrieve":
	       	   	  	if(validateForm(sheetObject,formObject,srcName)){
		             	if(!CoFmsInitConfirm(sheetObject)) return;
		            	ComOpenPopup("ESM_FMS_0074.do?" + FormQueryString(formObject), 900, 373,"searchVvdList", "1,0,1,1,1", true, false, null, null, 0, "ESM_FMS_0074");
		             	/*
		            	if (ComIsBtnEnable("btn_retrieve")) {
							ComOpenPopup("ESM_FMS_0074.do?" + FormQueryString(formObject), 900, 373,"searchVvdList", "1,0,1,1,1", true, false, null, null, 0, "ESM_FMS_0074");
						}*/
					}	 
                break;
				case "btn_new":
	             	if(!CoFmsInitConfirm(sheetObject)) return;
	             	clearAll(); //NYK Modify 2014.10.21
                break;
				case "btn_save":
					if (ComIsBtnEnable("btn_save")) {
						doActionIBSheet(sheetObject,formObject,IBSAVE);
                	}
                break;
				case "btn_slipInquiry":
					ComOpenPopup("ESM_FMS_0041_1.do?popup=yes", 1024, 700,"", "1,0,1,1,1", false, false, null, null, 0, "ESM_FMS_0041_1");
					//ComOpenPopup("ESM_FMS_0041.do?popup=yes", 1024, 590,"", "1,0,1,1,1", false, false, null, null, 0, "ESM_FMS_0041");
                break;
				case "btn_print":
					rdOpen(formObject);
                break;
				case "btn_vslpop":
					ComOpenPopup("ESM_FMS_0022.do", 520, 470,"setVslCd", "1,0,1,1,1", true, false, null, null, 0, "ESM_FMS_0022");
					break;
				case "btn_ctrtpop":
					 if(formObject.vsl_cd.value == "") {
						 ComAlertFocus(formObject.vsl_cd, ComGetMsg('FMS01231'));
						 return;
					 }
					 clearAll("CTRT"); //NYK Modify 2014.10.21
					 ComOpenPopup("ESM_FMS_0023.do?vsl_cd=" + formObject.vsl_cd.value+"&typeFlag=" + "TI", 520, 415,"setContractNo", "1,0,1,1,1", true, false, null, null, 0, "ESM_FMS_0023");
					 break;
				case "eff_dt_cal":
					var cal=new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.eff_dt, 'yyyy-MM-dd');
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
        
		$("#vsl_cd").blur(function(){
			vsl_cd_change();
		});
		
		$("#csr_curr_cd").blur(function(){
			currencyOnChange();
		});
		
		resizeSheet();		
    }
	/**
     * Loading Event of HTML_Control existing on page dynamically <br>
     * Calling the function from {@link #loadPage} to initialize IBSheet Object<br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sequence of sheetObjects array
     **/
    function initControl() {
        //Axon Event Handling1. Event Catch
    	axon_event.addListenerForm  ('blur'				, 'obj_deactivate', form); 	//- form Code Handling to OnBeforeDeactivate(blur) Event of All Controls
        axon_event.addListener  ('change'  , 'vsl_cd_change', 'vsl_cd');			//- Getting Name Information after inserting Vessel Code 
        axon_event.addListener  ('change'  , 'currencyOnChange', 'csr_curr_cd');			//- Getting Name information after inserting Currency Code
        setCsrDate();
        
        //NYK Modify 2014.10.14
        initDefaultDate();
        
		//Prepayment Retrieve Button Disable 
		//ComBtnDisable("btn_retrieve");
		//Print Button Disable 
		ComBtnDisable("btn_print");
    }
    
    //NYK Modify 2014.10.14
    function initDefaultDate(){
		pre_eff_dt = "";
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);    	
    }
	/**
	 * Setting Current Date into CSR Date
	 */
	function setCsrDate() {
		document.form.slp_iss_dt.value = ComFmsCurrentDate();
	}
	/**
	 * Inserting Vessel Code <br>
	 * @param {arry} aryPopupData
	 */
	function setVslCd(aryPopupData) {
		form.vsl_cd.value=aryPopupData[0][2];
		form.vsl_eng_nm.value=aryPopupData[0][3];
		
		//NYK Modify 2014.10.21
		if(form.vsl_cd.value != ""){
			vsl_cd_change();
		}
	}
    /**
	 * Inserting Contract No<br>
	 * @param {arry} aryPopupData
	 */
	function setContractNo(aryPopupData){
		form.flet_ctrt_no.value=aryPopupData[0][3];
		contract_no_change();
	}
    /**
	 * Separating unsorted Prepayment Slip by Voyage <br>
	 * @param {arry} aryPopupData
	 */
	function searchVvdList(aryPopupData){
		form.slp_desc.value=aryPopupData[0][3];
		form.org_slip_no.value=aryPopupData[0][4];
		form.acct_cd.value=aryPopupData[0][6];
		form.slp_amt.value=aryPopupData[0][8];
		form.org_slp_tp_cd.value=aryPopupData[0][9];
		form.org_slp_func_cd.value=aryPopupData[0][10];
		form.org_slp_ofc_cd.value=aryPopupData[0][11];
		form.org_slp_iss_dt.value=aryPopupData[0][12];
		form.org_slp_ser_no.value=aryPopupData[0][13];
		form.org_slp_seq_no.value=aryPopupData[0][5];
		form.ctr_cd.value=aryPopupData[0][14];
		form.slp_loc_cd.value=aryPopupData[0][15];
		form.vvd_exp_dt.value=aryPopupData[0][16];
		form.vvd_eff_dt.value=aryPopupData[0][17];
		form.inv_seq.value=aryPopupData[0][18];
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	/**
     * Getting relevant Name when selecting Contract No <br>
     **/
    function contract_no_change() {
    	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'flet_ctrt_no');
    }
    /**
     * Only insert English/Numeric by onkeypress Event of HTML Control <br>
     **/
    function eng_keypress() {
        ComKeyOnlyAlphabet('upper');
    }
    /**
     * Getting Name relevant to the VslCd when VslCd is changed <br>
     **/
    function vsl_cd_change() {
    	form.vsl_eng_nm.value="";
    	if (form.vsl_cd.value != "" && form.vsl_cd.value.trim().length == 4) {
   			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'vsl_cd');
    	}
    }
    /**
     * Checking when Effective Date is changed <br>
     **/
    function eff_dt_change() {
    	if (form.eff_dt.value != "" && ComIsDate(form.eff_dt.value)) {
   			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'eff_dt');
    	}else{
      		ComAlertFocus(form.eff_dt, ComGetMsg("FMS01565"));
      	} 
    }
	/**
     * Deciding whether Currency Code value is existing in IBSheet input values <br>
     * @return none
     **/
    function currencyOnChange() {
    	if (form.csr_curr_cd.value.trim().length == 3) {
   			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'csr_curr_cd');
    	}
	}
    /**
     * Checking Validation in onblur Event of HTML Control <br>
     **/
    function obj_deactivate(){
	    ComChkObjValid(event.srcElement);
	    obj=event.srcElement;
	    if (obj.name == 'eff_dt') {
	    	if(pre_eff_dt == form.eff_dt.value) return;
	    	eff_dt_change();
	    }
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
            case 1:     //sheet1 init
                with(sheetObj){
              var HeadTitle1="|Seq.|Acct Code|Vendor Code|Center Code|City|Eff. Date|Slip Amount||||||";
              var HeadTitle2="|Seq.|Description|Description|Description|VVD Code||Key Number|||||||";
              var headCount=ComCountHeadTitle(HeadTitle1);
              (headCount, 0, 0, true);
              SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );

              var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [[ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"slp_seq_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"acct_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vndr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ctr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"slp_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Date",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"eff_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Float",     Hidden:0,  Width:200,  Align:"Right",   ColMerge:0,   SaveName:prefix+"csr_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"org_slp_tp_cd" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"org_slp_func_cd" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"org_slp_ofc_cd" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"org_slp_iss_dt" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"org_slp_ser_no" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"org_slp_seq_no" }
                     ],[
							{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag1" },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"slp_seq_no1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:prefix+"csr_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:prefix+"csr_desc1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:prefix+"csr_desc2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dummy1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"slp_key_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"ppay_hir_no" },
							{Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"inv_seq" },
							{Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"vvd_eff_dt" },
							{Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"vvd_exp_dt" },
							{Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"trns_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
							{Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"lsg_gr_no" } 
                     ]];
              InitColumns(cols,2);
              SetEditable(1);
              
              SetRangeBackColor(1,2,1,7,"#555555");
              SetSheetHeight(380);
              }
             break;
        }
    }
    function doActionIBSheet(sheetObj,formObj,sAction, Col, Row) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
         	case IBSEARCH:      
       	   	  	if(validateForm(sheetObj,formObj,sAction)){
	        		formObj.f_cmd.value=SEARCH01;
 	        		sheetObj.DoSearch("ESM_FMS_0074GS.do", FormQueryString(formObj) );
	  	   	  		//inputReadOnly("Search");
	  	   	  	}	
                break;
           	case IBSAVE:        
	 			if(!validateForm(sheetObj,formObj,sAction)) return;
	 			if(!saveConfirm()) return;
	 			formObj.f_cmd.value=MULTI;
	 			//sheetObj.DoSave("ESM_FMS_0035GS.do", FormQueryString(formObj));
	 			var param=FormQueryString(formObj) + "&" + sheetObj.GetSaveString();
	 			var sXml=sheetObj.GetSaveData("ESM_FMS_0035GS.do", param);	 				       		
	 			//NYK Modify 2014.10.08
	 	    	//var csr_no=sheetObj.GetEtcData("csr_no");
	 	    	var rtnCsrNo=ComGetEtcData(sXml, "csr_no");
	 			if(typeof rtnCsrNo != "undefined" && rtnCsrNo != "" ) {
	 				formObj.csr_no.value=rtnCsrNo; 
	 				//Save Button Disable 하기
	 				ComBtnDisable("btn_save");
	 				//Print Button Disable 하기
	 				ComBtnEnable("btn_print");
	 			}
	 			
                break;
			case IBROWSEARCH:   
				if (Col == "vsl_cd") {
					formObj.f_cmd.value=SEARCH01;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		   			var vslEngNm=ComGetEtcData(sXml, "vslEngNm");
		   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
		   				formObj.vsl_eng_nm.value=vslEngNm;
		   				initDefaultContractNo(); //NYK Modify 2014.10.21
					} else {
						formObj.vsl_cd.value="";
						formObj.vsl_eng_nm.value="";
						ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS01056"));
						return;
					}
	    		} else if (Col == "flet_ctrt_no") {
					formObj.f_cmd.value=SEARCH;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0035GS.do" , FormQueryString(formObj));
		   			var fletCtrtTpCd=ComGetEtcData(sXml, "fletCtrtTpCd");
		   			if(typeof fletCtrtTpCd != "undefined" && fletCtrtTpCd != "" ) {
		   				formObj.flet_ctrt_tp_cd.value=fletCtrtTpCd;
		   				formObj.vndr_seq.value=ComGetEtcData(sXml, "vndrSeq");
		   				formObj.vndr_nm.value=ComGetEtcData(sXml, "vndrNm");
					}
	    		} else if (Col == "eff_dt") {
					formObj.f_cmd.value=SEARCH09;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , ComReplaceStr(FormQueryString(formObj),"-",""));
		   			
	 		   		var closFlg=ComGetEtcData(sXml, "clos_yn");
		   			var effDt=ComGetEtcData(sXml, "eff_dt");
		   			var oldEffDt=ComGetUnMaskedValue(formObj.eff_dt, "ymd");
				
		   			if (closFlg=="C"){
						//closed, and open item not exists
						if (ComTrim(effDt) == ""){
							ComShowCodeMessage("FMS20009", oldEffDt.substring(0,6));
							formObj.eff_dt.value="";
							pre_eff_dt="";
							return;					
						}
						//closed, and user confirmed, setting next month 1 day
						if (ComShowCodeConfirm('FMS20010',oldEffDt, effDt)){
							formObj.eff_dt.value=effDt;
							
							pre_eff_dt = formObj.eff_dt.value;
			   				//formObj.csr_desc.value="Hire Settlement "+formObj.vsl_cd.value + " " + formObj.eff_dt.value.substring(0,7);
			   				//ComBtnEnable("btn_retrieve");
							
						}else{
							formObj.eff_dt.value="";
						}
					//before closing month, and before closing previous month
					}else if (closFlg=="X"){
						//Two or more un-closed month exist ! Do you want ignore it 
						//if (!ComShowCodeConfirm("FMS20011")){
						//	formObj.eff_dt.value="";
						//	formObj.eff_dt.focus();
						//}
					//in case of not existing data
					}else if (closFlg=="E"){
						ComShowCodeMessage("FMS20012", oldEffDt.substring(0,6));
						formObj.eff_dt.value="";
						pre_eff_dt="";
					}else{
						pre_eff_dt = formObj.eff_dt.value;
		   				formObj.csr_desc.value="Hire Settlement "+formObj.vsl_cd.value + " " + formObj.eff_dt.value.substring(0,7);
		   				//ComBtnEnable("btn_retrieve");
					}
 		   			/*
 		   			var effDt=ComGetEtcData(sXml, "effDt");
		   			if(typeof effDt == "undefined" || effDt == "" ) {
						formObj.eff_dt.value="";
						ComAlertFocus(formObj.eff_dt, ComGetMsg("FMS01565"));
						return;
					} else {
						pre_eff_dt = formObj.eff_dt.value;
		   				formObj.csr_desc.value="Hire Settlement "+formObj.vsl_cd.value + " " + formObj.eff_dt.value.substring(0,7);
		   				//ComBtnEnable("btn_retrieve");
					}*/
	        	} else if(Col == "csr_curr_cd") {
	        		formObj.f_cmd.value=SEARCH01;
 	        		var sXml=sheetObj.GetSearchData("ESM_FMS_0076GS.do" , FormQueryString(formObj)+"&curr_cd="+formObj.csr_curr_cd.value);
		   			var currCd=ComGetEtcData(sXml, "currCd");
		   			if(typeof currCd == "undefined" || currCd == "") {
		   				formObj.csr_curr_cd.value="";
						ComAlertFocus(formObj.csr_curr_cd, ComGetMsg("FMS01142"));
		   			}
				}	
				break;
            	
			case IBSEARCH_ASYNC01: //NYK Modify 2014.10.14
				sheetObj.SetWaitImageVisible(0);
				var f_query = "";					
				f_query += "f_cmd=" + SEARCH; 
				f_query += "&csr_type="+formObj.csr_type.value;	 			
				f_query += "&slp_ofc_cd="+formObj.slp_ofc_cd.value; 
				
				var sXml = sheetObj.GetSearchData("FMS_COMGS.do",f_query);

	   			var varRqstDt = ComGetEtcData(sXml, "rqst_dt");
	   			var varEffDt = ComGetEtcData(sXml, "eff_dt");

	   			if(typeof varEffDt != "undefined" && varEffDt != "" ) {
					formObj.eff_dt.value = ComGetMaskedValue(varEffDt,"ymd");
				}
				sheetObj.SetWaitImageVisible(1);
				
				eff_dt_change();
				break;
            	
			case IBSEARCH_ASYNC02: //NYK Modify 2014.10.21				
				if(formObj.vsl_cd.value == "") return;				
				var f_query = "";					
				f_query += "f_cmd=" + SEARCH01; 
				f_query += "&vsl_cd="+formObj.vsl_cd.value;	 			
				f_query += "&type_flag="+gFletCtrtTpCdAll; 
				
				var sXml = sheetObj.GetSearchData("FMS_COMGS.do",f_query);

	   			var varFletCtrtNo = ComGetEtcData(sXml, "flet_ctrt_no");
	   			
	   			if(typeof varFletCtrtNo != "undefined" && varFletCtrtNo != "" ) {
					formObj.flet_ctrt_no.value = varFletCtrtNo;
				}else{
					ComShowCodeMessage("FMS20001","Agreement");
					clearAll();
					return;
				}
				if(formObj.flet_ctrt_no.value != ""){
					contract_no_change();
				}
				break;

			
        }
    }
    /**
     * Handling by Event <br>
     * @param {String} flag     	Event Separator
     **/
    function inputReadOnly(flag) {
    	if(flag == "New") {
	    	form.vsl_cd.readOnly=false;
	    	form.eff_dt.readOnly=false;
	    	form.btn_vslpop.name="btn_vslpop";
	    	form.btn_vslpop.style.cursor="hand";
	    	form.btn_ctrtpop.name="btn_ctrtpop";
	    	form.btn_ctrtpop.style.cursor="hand";
	    	form.eff_dt_cal.name="eff_dt_cal";
	    	form.eff_dt_cal.style.cursor="hand";
	        setCsrDate();
    	} else {
	    	if(sheetObjects[0].RowCount()== 1 || flag == "Search") {
		    	form.vsl_cd.readOnly=true;
		    	form.eff_dt.readOnly=true;
		    	form.btn_vslpop.name="no_btn_vslpop";
		    	form.btn_vslpop.style.cursor="default";
		    	form.btn_ctrtpop.name="no_btn_ctrtpop";
		    	form.btn_ctrtpop.style.cursor="default";
		    	form.eff_dt_cal.name="no_eff_dt_cal";
		    	form.eff_dt_cal.style.cursor="default";
	    	}
    	}
		ComBtnEnable("btn_save");
		//Print Button Disable
		ComBtnDisable("btn_print");
    }
   /**
      * Event occurring after searching IBSheet
      */
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){
		if (sheetObj.RowCount()> 2) {//In case of Account Code 111431, can not modify
			sheetObj.SetCellEditable(2, prefix+"csr_amt",0);
		}

		setTotalAmount(sheetObj);
	}
     /**
      * Getting Total Amount of DR, CR after retrieving IBSheet
      */
    function setTotalAmount(sheetObj){
    	//UI개선(201408, 민정호)
    	var LastRow=sheetObj.LastRow();
    	var DrAmt=0;
    	var CrAmt=parseFloat(sheetObj.GetCellValue(2, prefix+"csr_amt"))*-1;
    	for (var i=4; i<=LastRow; i++) {
    		DrAmt=DrAmt + parseFloat(sheetObj.GetCellValue(i, prefix+"csr_amt"));
	    	i++;
	    }
		var formObj=document.form;
		formObj.dr_amt.value=ComAddComma(DrAmt.toFixed(2));
		formObj.cr_amt.value=ComAddComma(CrAmt.toFixed(2));
    }
     /**
      * Event occurring after saving IBSheet
      */
    function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		//CSR No. Setting
		
    	/*
    	var rtnCsrNo=sheetObj.GetEtcData("csr_no");
		if(typeof rtnCsrNo != "undefined" && rtnCsrNo != "" ) {
			var formObj=document.form;
			formObj.csr_no.value=rtnCsrNo; 
			//Save Button Disable 하기
			ComBtnDisable("btn_save");
			//Print Button Disable 하기
			ComBtnEnable("btn_print");
		}*/	
		//NYK Modify 2014.10.08
		/*
		var slpSerNo=sheetObj.GetEtcData("slp_ser_no");
		if(typeof slpSerNo != "undefined" && slpSerNo != "" ) {
			var formObj=document.form;
			formObj.csr_no.value=formObj.slp_tp_cd.value + formObj.slp_func_cd.value
			+ formObj.slp_ofc_cd.value + ComReplaceStr(formObj.slp_iss_dt.value,"-","").substring(2,6) + slpSerNo; 
			//Save Button Disable 하기
			ComBtnDisable("btn_save");
			//Print Button Disable 하기
			ComBtnEnable("btn_print");
		}	
		*/
	}
     /**
      * In case Inserted value is changed in IBSheet Object
      */
 	function sheet1_OnChange(sheetObj,Row, Col, Value)
	{
		if (Col == 7) {//CSR Amount
			setTotalAmount(sheetObj);
		}
	}
    /**
     *  Handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        if (!ComChkValid(formObj)) return false;
        if (sAction == IBSAVE) {
			var csr_desc=formObj.csr_desc.value;
			if (csr_desc.trim() == "") {
				ComAlertFocus(formObj.csr_desc, ComGetMsg("FMS01507"));
        		return false;
        	}
			var eff_dt=formObj.eff_dt.value;
			if (eff_dt.trim() == "") {
				ComAlertFocus(formObj.eff_dt, ComGetMsg("FMS01506"));
        		return false;
        	}
			var drAmt=parseFloat(ComReplaceStr(formObj.dr_amt.value,',',''));
			var crAmt=parseFloat(ComReplaceStr(formObj.cr_amt.value,',',''));
			if (drAmt != crAmt) {
				ComShowCodeMessage("FMS01508");
        		return false;
        	}
        	//Prepayment Hire No
			formObj.ppay_hir_no.value=sheetObj.GetCellValue(5, prefix+"org_slp_tp_cd");
        }
        return true;
    }

 	function rdOpen(formObject){
 		if(sheetObjects[0].RowCount()== 0) {
 			ComShowCodeMessage("FMS00015");
 			return;
 		}
		var rdParam = '/rv '+ RD_FormQueryString(formObject,1);
		var rdFile = 'apps/opus/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/ESM_FMS_031.mrd';

 		formObject.com_mrdPath.value = rdFile;
 		formObject.com_mrdArguments.value = rdParam;
 	    ComOpenRDPopup();
 	}
 	
 	function clearAll(flag){
 		//NYK Modify 2014.10.21
		switch(flag){
			case "CTRT" :
				var tmpVslCd = form.vsl_cd.value;
				var tmpVslEngNm = form.vsl_eng_nm.value;
				ComResetAll();
				form.vsl_cd.value = tmpVslCd;
				form.vsl_eng_nm.value = tmpVslEngNm;
				break;
			default :
				ComResetAll();
				break;
		}
 		//ComResetAll();
		initDefaultDate();
		
		inputReadOnly("New");
 	}
    /**
     * Conriem Save <br>
     * @return {boolean} okYn 
     **/
 	function saveConfirm() {
 		//setTotalAmount('S');
 		var okYn=ComShowConfirm(ComGetMsg("FMS00017"));
 		return okYn;
 	}
 	
    //NYK Modify 2014.10.16
    function initDefaultContractNo(){
  	  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);   
    }

    function resizeSheet(){
        for (i=0; i<sheetObjects.length; i++){
            ComResizeSheet(sheetObjects[i], 80);
        }
    }
    