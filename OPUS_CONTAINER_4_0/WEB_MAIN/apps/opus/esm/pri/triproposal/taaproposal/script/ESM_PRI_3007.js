/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3007.js
*@FileTitle  : TAA Creation & Amendment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
 =========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
               OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class ESM_PRI_3007 :business script for  ESM_PRI_3007
     */
    // Common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    // Event handler processing by button click event
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.11.20
     */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        /*******************************************************/
        var formObj=document.form;
        try { 
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheetObject1, formObj, IBSEARCH);
                    break;
                case "btn_Cancel":
                    doActionIBSheet(sheetObject1, formObj, IBRESET);
                    break;
                case "btn_Save":
                    doActionIBSheet(sheetObject1, formObj, IBSAVE);
                    break;
                case "btn_New":
                    doActionIBSheet(sheetObject1, formObj, IBCREATE);
                    break;
                case "btn_Confirm":
                    doActionIBSheet(sheetObject1, formObj, MODIFY01);
                    break;
                case "btn_ConfirmCancel":
                    doActionIBSheet(sheetObject1, formObj, MODIFY02);
                    break;
                case "btn_Amend":
                	var param="taa_no="+sheetObject1.GetCellValue(1,"taa_no")+"&amdt_seq="+sheetObject1.GetCellValue(1,"amdt_seq")+"&eff_dt="+formObj.eff_dt.value+"&exp_dt="+formObj.exp_dt.value;
                    ComOpenPopup("/opuscntr/ESM_PRI_3017.do?"+param, 800, 400, "callback_btn_Amend", "1,0", true);
                   
                    break;
                case "btn_RowAdd":
                    doActionIBSheet(sheetObject2, formObj, IBINSERT);
                    break;
                case "btn_RowDelete":
                    doActionIBSheet(sheetObject2, formObj, IBDELETE);
                    break;
                case "btns_calendar":
                    var cal=new ComCalendarFromTo();
                    cal.select(formObj.eff_dt, formObj.exp_dt, 'yyyy-MM-dd');
                    break;
                case "btn_taa_no":
                	ComOpenPopup("/opuscntr/ESM_PRI_3008.do",900, 380, "findVal", "1,0,1,1,1,1,1", true);
                    break;
                case "btn_ctrt_cust":
                    var param="is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+formObj.ctrt_cust_cnt_cd.value+"&cust_seq="+formObj.ctrt_cust_seq.value+ "&func=findCtrtCust";
                    ComOpenPopup("ESM_PRI_4014_POP.do?"+param, 640, 465, "findCtrtCust", "none", true);
                    break;
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        } finally {
            ComOpenWait(false);
        }
    }
    
    function callback_btn_Amend(rtnVal) {
    	if (rtnVal != null) {
    		var sheetObject1=sheetObjects[0];
    		var formObj=document.form;
    		doActionIBSheet(sheetObject1, formObj, IBSEARCH);
    	}
    }
    
    function findVal(rtnVal) {

    	var sheetObject1=sheetObjects[0];
        var formObj=document.form;

		 if (rtnVal != null){
             formObj.taa_no.value= rtnVal;
             getComboObject(comboObjects, "amdt_seq").RemoveAll();
             doActionIBSheet(sheetObject1, formObj, IBSEARCH);
         }
    }

	function findCtrtCust(rowArray) {
		var sheetObject1=sheetObjects[0];
	   	 var formObj=document.form;
		      if (rowArray != null){
	    	  formObj.ctrt_cust_cnt_cd.value=rowArray.custCntCd;
	    	  formObj.ctrt_cust_seq.value=rowArray.custSeq;
	    	  formObj.ctrt_cust_nm.value=rowArray.custNm;
		      custNameFind("ctrt_cust_cnt_cd");
		      formChangeSheet(sheetObject1, "ctrt_cust_cnt_cd");
		      formChangeSheet(sheetObject1, "ctrt_cust_seq");
		      //sale rep
		      setCustSaleRep();
		      getComboObject(comboObjects, "respb_srep_cd").SetSelectCode(sheetObject1.GetCellValue(1,"respb_srep_cd"),false);
	        }
	}
    /**
     * registering IBSheet Object as list <br>
     * adding process for list in case of needing batch processing with other items <br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj Mandatory, IBSheet Object
     * @return N/A
     * @author 
     * @version 2009.11.20
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * registering IBMultiCombo Object as list <br>
     * adding process for list in case of needing batch processing with other items <br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_Obj);
     * </pre>
     * @param {ibcombo} combo_obj Mandatory, IBMultiCombo Object
     * @return N/A
     * @author 
     * @version 2009.11.20
     */
    function setComboObject (combo_obj) {
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
     * @return N/A
     * @author 
     * @version 2009.11.20
     */
    function loadPage() {
        try {
            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            for(var k=0; k < comboObjects.length; k++){
                initCombo(comboObjects[k], k + 1);
            }
            initControl();
            var arrVal=svcScpTrfsValue.split("|");
            var arrText=svcScpTrfsText.split("|");
            // Trf Code by scope
            for (var i=0 , n=arrVal.length ; i < n ; i++) {
                hmap.put(arrVal[i], arrText[i]);
            }
            // Service Scope Combo creation
            initIBComboItem();
            var formObj=document.form;
            if (formObj.cond_taa_no.value != "") {
                formObj.taa_no.value=formObj.cond_taa_no.value;
                doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
            } else {
                doActionIBSheet(sheetObjects[0], formObj, IBCREATE);
            }
            
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        } finally {
            ComOpenWait(false);
        }
    }
    var hmap=new HashMap();  // Trf Code by scope
    var usrSrepAuth="Y";    // Save authority
    var usrOfcAuth="N";    // Save/Update/Confirm/Amend authority
    var usrAprvAuth="N";    // Sales Rep Code modification authority
    var naCapFlg="N";       // Confirm authority
    var cmpUsrIdFlg="N";   // Confirm authority
    /**
     * Checking user authority<br>
     * <br><b>Example :</b>
     * <pre>
     *     checkUserAuth();
     * </pre>
     * @param N/A
     * @return N/A
     * @author 
     * @version 2010.01.13
     */
    function checkUserAuth() {
        var formObj=document.form;
        // Checking registered authority : checking whether existing Srep Code
//        if (formObj.usr_srep_cd.value != "") {
//            usrSrepAuth="Y";
//        } else {
//            usrSrepAuth="N";
//        }
        // checking authority for modification : checking whether including Office Code 
        if (formObj.respb_sls_ofc_cd.value != "" && formObj.respb_sls_ofc_cd.value == formObj.usr_ofc_cd.value) {
            usrOfcAuth="Y";
        } else {
            usrOfcAuth="N";
        }
        // Checking authority for approval : checking Service Scope Code 
        if (getComboObject(comboObjects, "svc_scp_cd").GetSelectCode()!= "") {
            formObj.f_cmd.value=SEARCH05;
            var sXml=sheetObjects[0].GetSearchData("ESM_PRI_3007GS.do" , FormQueryString(formObj));
            usrAprvAuth=ComGetEtcData(sXml, "approvalAuth");
        } else {
            usrAprvAuth="N";
        }
        // Checking authority for confirm : checking NaCap
        formObj.f_cmd.value=SEARCH21;        
        var sParam=FormQueryString(formObj)+"&xtn_phn_no=PRICD0003";
        var sheetObj=sheetObjects[1];
        sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
        naCapFlg = ComGetEtcData(sXml,"isRole");
        
        // Checking authority for confirm : compare with login ID and taa_mn cre-usr ID
        if(formObj.usr_id.value == sheetObjects[0].GetCellValue(1, "cre_usr_id")){
        	cmpUsrIdFlg = "Y";
        }else{
        	cmpUsrIdFlg ="N";
        }
    }
    /**
     * Loading HTML control's event on page dynamically<br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl()
     * </pre>
     * @param N/A
     * @return N/A
     * @author 
     * @version 2009.11.30
     */
    function initControl () {
    	$("#eff_dt").on("blur", obj_deactivate);
    	$("#exp_dt").on("blur", obj_deactivate);
    	$("#ctrt_cust_cnt_cd").on("blur", obj_deactivate);
    	$("#ctrt_cust_seq").on("blur", obj_deactivate);
    	axon_event.addListenerFormat ('keyup', 'obj_keyup', document.form);
    }
    /**
     * Setting retrieved combo item when loading page to IBMultiCombo.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initIBComboItem ();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.11.20
     */
    function initIBComboItem () {
        ComPriTextCode2ComboItem(svcScpComboValue, svcScpComboText, getComboObject(comboObjects, 'svc_scp_cd'),"|","\t");
    }
    /**
     * Handling OnKeyPress event<br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_keypress();
     * </pre>
     * @param N/A
     * @return N/A
     * @author 
     * @version 2009.11.30
     */
    function obj_keypress () {
        switch (ComGetEvent("dataformat")) {
            case "engup":
                if (ComGetEvent("name") == "taa_no") {
                    ComKeyOnlyAlphabet('uppernum');
                } else {
                    ComKeyOnlyAlphabet('upper');
                }
                break;
            case "int":
                ComKeyOnlyNumber(ComGetEvent());
                break;
            case "float":
                ComKeyOnlyNumber(ComGetEvent(), ".");
                break;
            case "ymd":
                ComKeyOnlyNumber(ComGetEvent(), "-");
                break;
            default:
        }
        switch (ComGetEvent("name")) {
            case "taa_no":
                var formObj=document.form;
                formObj.taa_prop_no.value="";
                formObj.cond_taa_no.value="";
                formObj.eff_dt.value="";
                formObj.exp_dt.value="";
                formObj.cfm_nm.value="";
                formObj.svc_scp_nm.value="";
                formObj.ctrt_cust_cnt_cd.value="";
                formObj.ctrt_cust_seq.value="";
                formObj.ctrt_cust_nm.value="";
                formObj.respb_sls_ofc_cd.value="";
                formObj.respb_srep_nm.value="";
                formObj.org_pnt_loc_nm.value="";
                formObj.org_via_port_nm.value="";
                formObj.dest_via_port_nm.value="";
                formObj.dest_pnt_loc_nm.value="";
                sheetObjects[0].RemoveAll();
                sheetObjects[1].RemoveAll();
                getComboObject(comboObjects, "amdt_seq").RemoveAll();
                getComboObject(comboObjects, "respb_srep_cd").RemoveAll();
                sheetObjects[0].DataInsert();
                getComboObject(comboObjects, "svc_scp_cd").SetSelectCode("",false);
                sheetObjects[0].SetCellValue(1, "cfm_flg","N",0);
                break;
            default:
        }
    }
    /**
     * Handling OnKeyUp event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param N/A
     * @return N/A
     * @author 
     * @version 2010.03.12
     */       
    function obj_keyup(){
        //enter key
        var eleName=ComGetEvent("name");
        if (eleName == "taa_no"){
//            var keyValue = null;
//            if(event == undefined || event == null) {
//                keyValue = 13;
//            }else{
//                keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//            }
//            if (keyValue == 13){
//                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//            }
            if (event.keyCode == 13){
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            }
        }
    }
    /**
     * Handling OnChange event<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param N/A
     * @return N/A
     * @author 
     * @version 2009.11.20
     */
    function obj_change () {
        switch (ComGetEvent("name")) {
            case "taa_no":
                sheetObjects[0].SetCellValue(1, "amdt_seq","",0);
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
                break;
            default:
        }
    }
    /**
     * Handling deactivate Event <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_deactivate()
     * </pre>
     * @param N/A
     * @return N/A
     * @author 
     * @version 2009.11.20
     */
    function obj_deactivate () {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var eleName=ComGetEvent("name");
        switch (eleName) {
            case "taa_no":
                formChangeSheet(sheetObj, eleName);
                break;
            case "ctrt_cust_cnt_cd":
                //cust name find
                if (formObj.ctrt_cust_cnt_cd.value != "") {
                    custNameFind(eleName);
                    // sales rep
                    setCustSaleRep();
                    getComboObject(comboObjects, "respb_srep_cd").SetSelectCode(sheetObj.GetCellValue(1, "respb_srep_cd"),false);
                } else {
                    clearCustName();
                }
                ComChkObjValid(ComGetEvent());
                break;
            case "ctrt_cust_seq":
                var custSeq=ComTrim(formObj.ctrt_cust_seq.value);
                formObj.ctrt_cust_seq.value=custSeq;
                var re=new RegExp();
                re.compile("[\\D]");
                if (re.test(custSeq)) {
                    clearCustName();
                    return;
                }
                if (custSeq.length < 6 && custSeq.length != 0) {
                    formObj.ctrt_cust_seq.value=ComLpad(custSeq, 6, "0");
                }
                //cust name find
                if (ComParseInt(sheetObj.GetCellValue(1, "ctrt_cust_seq")) != ComParseInt(formObj.ctrt_cust_seq.value)) {
                    if (formObj.ctrt_cust_seq.value != "") {
                        custNameFind(eleName);
                        // sale rep
                        setCustSaleRep();
                        getComboObject(comboObjects, "respb_srep_cd").SetSelectCode(sheetObj.GetCellValue(1, "respb_srep_cd"),false);
                    } else {
                        clearCustName();
                    }
                }
                break;
            case "exp_dt":
            	if(!ComChkObjValid(event.srcElement, false, false, false)) return;
            	formChangeSheet(sheetObj, "exp_dt");
                break;
            case "eff_dt":
            	if(!ComChkObjValid(event.srcElement, false, false, false)) return;
                formChangeSheet(sheetObj, "eff_dt");
                break;
            default:
                ComChkObjValid(ComGetEvent());
                break;
        }
    }
    /**
     * Handling activate Event <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_activate()
     * </pre>
     * @param N/A
     * @return N/A
     * @author 
     * @version 2009.11.20
     */
    function obj_activate () {
        var formObj=document.form;
        var sElement=ComGetEvent();
        var srcName=sElement.getAttribute("name");
        ComClearSeparator(sElement);
        try{
            sElement.select();
        }catch(e){}
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {int} sheetNo Mandatory, IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     * @version 2009.11.20
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":  // hidden
				with(sheetObj){
					var HeadTitle="|TAA No|TAA Proposal No|Amdt Seq|Service Scope|Service Scope Name|Effective Date|Expire Date|Ctrt Cust Seq|Ctrt Cust Cnt Cd|prc-ctrt_cust_tp_cd|ctrt_cust_nm|ctrt_cust_val_sgm_cd|respb_srep_cd|respb_srep_nm|respb_sls_ofc_cd|cfm_flg|cfm_nm|cre_usr_id";
					var headCount=ComCountHeadTitle(HeadTitle);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"}];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"taa_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"taa_prop_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"amdt_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",                KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",                KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_cust_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:1,   SaveName:"ctrt_cust_cnt_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"prc_ctrt_cust_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_cust_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_cust_val_sgm_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"respb_srep_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"respb_srep_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"respb_sls_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Popup",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cfm_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Popup",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cfm_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
					   
					InitColumns(cols);
					SetSheetHeight(150);
					SetEditable(1);
					SetWaitImageVisible(0);
//					SetVisible(0);
				}
                break;
            case "sheet2":
				with(sheetObj){
					var HeadTitle="|Sel.|Seq.|taa_prop_no|amdt_seq|tri_prop_no|Tariff Rate Item\n(TRI)|Commodity|Commodity|Route|Route|Route|Route|Route nm|Route nm|Route nm|Route nm|Per|CGO\nType|Cur.|Rate|Note|note_conv_mapg_id|Duration|Duration|trf_pfx_cd|trf_no";
					var HeadTitle1="|Sel.|Seq.|taa_prop_no|amdt_seq|tri_prop_no|Tariff Rate Item\n(TRI)|Code|Description|Origin|Origin Via|Dest Via|Dest|Origin Nm|Origin Via Nm|Dest Via Nm|Dest Nm|Per|CGO\nType|Cur.|Rate|Note|note_conv_mapg_id|Effective|Expiration|trf_pfx_cd|trf_no";
					var headCount=ComCountHeadTitle(HeadTitle);
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"},{ Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					 {Type:"CheckBox",  Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Seq",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1,  Width:10,   Align:"Center",  ColMerge:1,   SaveName:"taa_prop_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1,  Width:10,   Align:"Center",  ColMerge:1,   SaveName:"amdt_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1,  Width:10,   Align:"Center",  ColMerge:1,   SaveName:"tri_prop_no",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"tri_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"org_pnt_loc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"org_via_port_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"dest_via_port_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"dest_pnt_loc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"org_pnt_loc_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"org_via_port_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"dest_via_port_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"dest_pnt_loc_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"prc_cgo_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:38,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"fnl_frt_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Popup",     Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"note_ctnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"note_conv_mapg_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"exp_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"trf_pfx_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"trf_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					   
					InitColumns(cols);
					SetSheetHeight(380);
					SetEditable(1);
					SetWaitImageVisible(0);
					SetEllipsis(1);
					SetAutoRowHeight(0);
					SetColProperty("tri_no", {Format:"######-####-###"} );
					SetShowButtonImage(2);
					SetRangeBackColor(1,6,1,12,"#555555");
					SetRangeBackColor(1,23,1,24,"#555555");
				}
                break;
        }
    }
    /**
     * setting intial combo value <br>
     * adding case as numbers of counting combos<br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {object} comboObj Mandatory, IBMultiCombo Object
     * @param {int} comboNo Mandatory, IBMultiCombo Object Tag's ID Serial No
     * @return N/A
     * @author 
     * @version 2009.11.20
     */
    function initCombo (comboObj, comboNo) {
        switch (comboObj.options.id) {
            case "svc_scp_cd":
                with (comboObj) {
                    SetDropHeight(260);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    SetMaxLength(3);
                    ValidChar(2);
                }
                break;
            case "amdt_seq":
                with (comboObj) {
                    SetDropHeight(100);
                    SetColWidth(0,"30");
                    SetColWidth(1,"160");
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(0);
                }
                break;
            case "respb_srep_cd":
                with (comboObj) {
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    SetMaxLength(5);
                }
                break;
        }
    }
    /**
     * Handling Sheet's process <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {form} formObj Mandatory, html form object
     * @param {int} sAction Mandatory, ,Process flag constant variable
     * @return N/A
     * @author 
     * @version 2009.11.20
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:      // Retrieve
                ComOpenWait(true);
                if (!validateForm(sheetObj,formObj,sAction)) {
                    return;
                }
                // Route Name 항목을 Clear
                formObj.org_pnt_loc_nm.value="";
                formObj.org_via_port_nm.value="";
                formObj.dest_via_port_nm.value="";
                formObj.dest_pnt_loc_nm.value="";
                formObj.f_cmd.value=SEARCH01;
                var sXml=sheetObj.GetSearchData("ESM_PRI_3007GS.do" , FormQueryString(formObj));
                var arrXml=sXml.split("|$$|");
                if (arrXml.length > 0) {
                    sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
                }
                if (arrXml.length > 1) {
                    sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
                }
                //sale rep
                doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
                ComOpenWait(false);
                buttonControl();
                break;
            case IBSAVE:        // Save
                ComOpenWait(true);
//                var items = formObj.elements;
//                var itemlen = items.length;
//                for (var i = 0 ; i < itemlen ; i++) {
//                    if (items[i].name == "") continue;
//                    formChangeSheet (sheetObjects[0], items[i].name);
//                }
                if (!validateForm(sheetObjects[0],formObj,sAction)) {
                    return false;
                }
                if (!ComPriConfirmSave()) {
                    return false;
                }
                formObj.f_cmd.value=MULTI01;
                var sParam="";
                var sParamSheet1=sheetObjects[0].GetSaveString();
                var sParamSheet2=sheetObjects[1].GetSaveString();
                if (sheetObjects[0].IsDataModified()&& sParamSheet1 == "") {
                    return;
                }
                if (sheetObjects[1].IsDataModified()&& sParamSheet2 == "") {
                    return;
                }
                if (sParamSheet1 == "" && sParamSheet2 == "") {
                    ComShowCodeMessage("PRI00301");
                    return;
                }
                if (sParamSheet1 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
                }
                if (sParamSheet2 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                }
                sParam += "&" + FormQueryString(formObj);
                var sXml=sheetObj.GetSaveData("ESM_PRI_3007GS.do", sParam);
                sheetObjects[0].LoadSaveData(sXml, {Sync:2});
                sXml=ComDeleteMsg(sXml);
                sheetObjects[1].LoadSaveData(sXml, {Sync:2});
                ComOpenWait(false);
                buttonControl();
                break;
            case IBINSERT:      // Row Add
                if (sheetObj.id == "sheet1") {
                    var row=sheetObj.DataInsert();
                } else if (sheetObj.id == "sheet2") {
                    if (!validateForm(sheetObj,formObj,sAction)) {
                        return false;
                    }
                    var param="svc_scp_cd="+getComboObject(comboObjects, "svc_scp_cd").GetSelectCode();
                    ComOpenPopup("ESM_PRI_3009.do?"+param, 1150, 550, "findTrifCd", "1,0", true);
                }
                break;
            case IBCREATE: // New
                // Form Object Reset
                formObj.f_cmd.value="";
                formObj.taa_prop_no.value="";
                formObj.cond_taa_no.value="";
                formObj.taa_no.value="";
                formObj.eff_dt.value="";
                formObj.exp_dt.value="";
                formObj.cfm_nm.value="";
                formObj.svc_scp_nm.value="";
                formObj.ctrt_cust_cnt_cd.value="";
                formObj.ctrt_cust_seq.value="";
                formObj.ctrt_cust_nm.value="";
                formObj.respb_sls_ofc_cd.value="";
                formObj.respb_srep_nm.value="";
                formObj.org_pnt_loc_nm.value="";
                formObj.org_via_port_nm.value="";
                formObj.dest_via_port_nm.value="";
                formObj.dest_pnt_loc_nm.value="";
                sheetObj.RemoveAll();
                sheetObjects[1].RemoveAll();
                getComboObject(comboObjects, "amdt_seq").RemoveAll();
                getComboObject(comboObjects, "respb_srep_cd").RemoveAll();
                sheetObj.DataInsert();
                getComboObject(comboObjects, "svc_scp_cd").SetSelectCode("",false);
                sheetObj.SetCellValue(1, "cfm_flg","N",0);
                buttonControl();
                break;
            case IBSEARCH_ASYNC01: // Retrieving Amdt SEQ combo when inputting TAA No 
                getComboObject(comboObjects, "amdt_seq").RemoveAll();
                formObj.f_cmd.value=SEARCH02;
                var sXml=sheetObj.GetSearchData("ESM_PRI_3007GS.do", FormQueryString(formObj));
                ComPriXml2ComboItem(sXml, amdt_seq, "amdt_seq", "cd|nm");
                break;
            case IBSEARCH_ASYNC02: // Setting Sale Rep
                setCustSaleRep();
                cboObj=comboObjects[2];
                var srepCd=sheetObj.GetCellValue(1,"respb_srep_cd");
        		if (srepCd !="" && cboObj.FindItem(srepCd, 0) == -1 ){
                	cboObj.InsertItem(0, srepCd + "|" +formObj.respb_srep_nm.value + "|" +formObj.respb_sls_ofc_cd.value, srepCd);
                }
                getComboObject(comboObjects, 'respb_srep_cd').SetSelectCode(sheetObj.GetCellValue(1,"respb_srep_cd"),false);
                break;
            case IBDELETE:  // Row Delete
                if (validateForm(sheetObj, formObj, sAction)) {
                    if (sheetObj.id == "sheet1") {
                    } else if (sheetObj.id == "sheet2") {
                        var delrow=deleteRowCheck(sheetObj, "chk" ,true);
                    }
                }
                break;
            case MODIFY01: // Confirm
                ComOpenWait(true);
                if (!validateForm(sheetObjects[0], formObj, sAction)) {
                    return false;
                }
                if (!ComPriConfirmConfirm()) {
                    return false;
                }
                formObj.f_cmd.value=MULTI02;
                sheetObj.DoAllSave("ESM_PRI_3007GS.do", FormQueryString(formObj));
                ComOpenWait(false);
                break;
            case MODIFY02: // Confirm Cancel
                ComOpenWait(true);
                if (!validateForm(sheetObjects[0], formObj, sAction)) {
                    return false;
                }
                if (!ComPriConfirmCancelConfirm()) {
                    return false;
                }
                formObj.f_cmd.value=MULTI03;
                sheetObj.DoAllSave("ESM_PRI_3007GS.do", FormQueryString(formObj));
                ComOpenWait(false);
                break;
            case IBRESET: // Cancel
                ComOpenWait(true);
                if (!validateForm(sheetObjects[0], formObj, sAction)) {
                    return false;
                }
                if (!ComPriConfirmDelete()) {
                    return false;
                }
                formObj.f_cmd.value=MULTI04;
                sheetObj.DoAllSave("ESM_PRI_3007GS.do", FormQueryString(formObj));
                ComOpenWait(false);
                break;
        }
    }
    /**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {form} formObj Mandatory, html form object
     * @param {int} sAction Mandatory, ,Process flag constant variable
     * @returns bool, <br>
     *          true  : Valid<br>
     *          false : Invalid
     * @author 
     * @version 2009.11.20
     */
    function validateForm(sheetObj,formObj,sAction){
        switch (sAction) {
            case IBSEARCH: 
                var taaNo=formObj.taa_no.value;
                if (taaNo == null) {
                    ComShowCodeMessage('PRI00316','TAA Number');
                    formObj.taa_no.focus();
                    return false;
                }
                break;
            case IBINSERT: // Row Add
                formChangeSheetAll(sheetObjects[0]);
                if (getComboObject(comboObjects, "svc_scp_cd").GetSelectCode()== "") {
                    ComShowCodeMessage("PRI01007");
                    return false;
                }
                break;
            case IBSAVE: // Save
                var formObj=document.form;
                formChangeSheetAll(sheetObjects[0]);
                if(!ComChkRequired(document.form)){
                    return false;
                }
                if (getComboObject(comboObjects, "svc_scp_cd").GetSelectCode()== "") {
                    ComShowCodeMessage('PRI00316','Service Scope');
                    getComboObject(comboObjects, "svc_scp_cd").focus();
                    return false;
                }
                if (getComboObject(comboObjects, "respb_srep_cd").GetSelectCode()== "") {
                    ComShowCodeMessage('PRI00316','Customer S.Rep.');
                    getComboObject(comboObjects, "respb_srep_cd").focus();
                    return false;
                }
                if(!sheetObjects[0].IsDataModified()&&!sheetObjects[1].IsDataModified()){
                    ComShowCodeMessage('PRI00301');
                    return false;
                }
                var rowM=sheetObjects[1].ColValueDup("tri_no", false);
                if (rowM >= 0) {
                	ComShowCodeMessage("PRI00303", "Sheet", sheetObjects[1].GetCellValue(rowM, "seq"));
                    sheetObjects[1].SetSelectRow(rowM);
                    return false;
                }
                // Duration Check
                var cnt=sheetObjects[1].RowCount()+ sheetObjects[1].HeaderRows();
                var taaEffDt=ComGetUnMaskedValue(formObj.eff_dt,"ymd");
                var taaExpDt=ComGetUnMaskedValue(formObj.exp_dt,"ymd");
                var triNos="";
                for (var i=sheetObjects[1].HeaderRows(); i < cnt ; i ++) {
                	if (sheetObjects[1].GetRowStatus(i) != "D" && (sheetObjects[1].GetCellValue(i, "eff_dt") > taaExpDt || sheetObjects[1].GetCellValue(i, "exp_dt") < taaEffDt)) {
                        triNos += sheetObjects[1].GetCellText(i, "tri_no")+", ";
                    }
                	if(sheetObjects[1].GetCellValue(i, "ibflag") == "I"){
	                	sheetObjects[1].SetCellValue(i, "taa_prop_no",sheetObjects[0].GetCellValue(1, "taa_prop_no"),0);
	                	sheetObjects[1].SetCellValue(i, "amdt_seq",sheetObjects[0].GetCellValue(1, "amdt_seq"),0);
                	}
                }
                if (triNos != "") {
                    triNos=triNos.substring(0, triNos.length - 2);
                    ComShowCodeMessage("PRI05001", triNos);
                    return false;
                }
                break;
            case MODIFY01: // Confirm
                var formObj=document.form;
//                var items = formObj.elements;
//                var itemlen = items.length;
//                for (var i = 0 ; i < itemlen ; i++) {
//                    if (items[i].name == "") continue;
//                    formChangeSheet (sheetObjects[0], items[i].name);
//                }
                formChangeSheetAll(sheetObjects[0]);
                if (sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()) {
                    ComShowCodeMessage('PRI03009', 'changed data');
                    return false;
                }
                if(!ComChkRequired(document.form)){
                    return false;
                }
                if (getComboObject(comboObjects, "amdt_seq").GetSelectCode()== "") {
                    ComShowCodeMessage('PRI00316','Amendment Sequence');
                    getComboObject(comboObjects, "amdt_seq").focus();
                    return false;
                }
                if (formObj.eff_dt.value > formObj.exp_dt.value){
                    ComShowCodeMessage('PRI00306');
                    formObj.eff_dt.focus();
                    return false;
                }
                var rowCnt=sheetObjects[1].RowCount();
//                if (rowCnt == 0) {
//                    ComShowCodeMessage("PRI05002");
//                    return false;
//                }
                var rowM=sheetObjects[1].ColValueDup("tri_prop_no", false);
                if (rowM >= 0) {
                	ComShowCodeMessage("PRI00303", "Sheet", sheetObjects[1].GetCellValue(rowM, "seq"));
                    return false;
                }
                var cnt=rowCnt + sheetObjects[1].HeaderRows();
                var taaEffDt=ComGetUnMaskedValue(formObj.eff_dt,"ymd");
                var taaExpDt=ComGetUnMaskedValue(formObj.exp_dt,"ymd");
                var triNos="";
                for (var i=sheetObjects[1].HeaderRows(); i < cnt ; i ++) {
                	if (sheetObjects[1].GetCellValue(i, "eff_dt") > taaExpDt || sheetObjects[1].GetCellValue(i, "exp_dt") < taaEffDt) {
                        triNos += sheetObjects[1].GetCellText(i, "tri_no")+", ";
                    }
                }
                if (triNos != "") {
                    triNos=triNos.substring(0, triNos.length - 2);
                    ComShowCodeMessage("PRI05001", triNos);
                    return false;
                }
                break;
            case MODIFY02:  // Confirm Cancel
                var formObj=document.form;
                // Checking whether TAA No for Confirm Calcel is used in booking already
                formObj.f_cmd.value=SEARCH03;
                var sXml=sheetObj.GetSearchData("ESM_PRI_3007GS.do", FormQueryString(formObj));
                var bkgNos=ComGetEtcData(sXml, "bkgNos");
                if (ComTrim(bkgNos) != "") {
                    ComShowCodeMessage("PRI05003", bkgNos);
                    return false;
                }
        }
        return true;
    }
  
    function findTrifCd(rtnVal) {
    	var sheetObj=sheetObjects[1];
    	sheetObj.LoadSearchData(rtnVal,{Event:0,Append:1});
        sheetObj.SetSelectRow(2);
    }
    
    /**
     * Calling function in case of OnSelectCell event <br>
     * Showing route name about selected TRI List<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {int} OldRow Mandatory, previous Selected Cell's Row Index
     * @param {int} OldCol Mandatory, previous Selected Cell's Column Index
     * @param {int} NewRow Mandatory, current Selected Cell's Row Index
     * @param {int} NewCol Mandatory, current Selected Cell's Column Index
     * @return N/A
     * @author 
     * @version 2009.11.30
     */
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	if(sheetObj.GetCellValue(NewRow,"tri_prop_no")!="" && OldRow != NewRow){
            var formObj=document.form;
			formObj.org_pnt_loc_nm.value=sheetObj.GetCellValue(NewRow, "org_pnt_loc_nm").replace(/\|/g, "\n");
			formObj.org_via_port_nm.value=sheetObj.GetCellValue(NewRow, "org_via_port_nm").replace(/\|/g, "\n");
			formObj.dest_via_port_nm.value=sheetObj.GetCellValue(NewRow, "dest_via_port_nm").replace(/\|/g, "\n");
			formObj.dest_pnt_loc_nm.value=sheetObj.GetCellValue(NewRow, "dest_pnt_loc_nm").replace(/\|/g, "\n");
        }
    }
    /**
     * Calling Function in case of OnSearchEnd event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {string} ErrMsg Selection,
     * @returns N/A
     * @author 
     * @version 2009.11.30
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (sheetObj.RowCount()== 0) {
            doActionIBSheet(sheetObj, document.form, IBCREATE);
            return;
        } else {
            var formObj=document.form;
            doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);  // amdt_seq combo
            getComboObject(comboObjects, "amdt_seq").SetSelectCode(sheetObj.GetCellValue(1, "amdt_seq"), false);
            getComboObject(comboObjects, "svc_scp_cd").SetSelectCode(sheetObj.GetCellValue(1, "svc_scp_cd"), false);
            IBS_CopyRowToForm(sheetObj, formObj, 1, "");
            
            
            formObj.respb_sls_ofc_cd.value=sheetObj.GetCellValue(1, "respb_sls_ofc_cd");
            formObj.respb_srep_nm.value=sheetObj.GetCellValue(1, "respb_srep_nm");
            formObj.cfm_nm.value=sheetObj.GetCellValue(1, "cfm_nm");
            formObj.svc_scp_nm.value=sheetObj.GetCellValue(1, "svc_scp_nm");            
            formObj.ctrt_cust_nm.value=sheetObj.GetCellValue(1, "ctrt_cust_nm");
            formObj.ctrt_cust_cnt_cd.value=sheetObj.GetCellValue(1, "ctrt_cust_cnt_cd");
            formObj.ctrt_cust_seq.value=ComLpad(sheetObj.GetCellValue(1, "ctrt_cust_seq"), 6, "0");
            formObj.eff_dt.value=sheetObj.GetCellText(1, "eff_dt");
            formObj.exp_dt.value=sheetObj.GetCellText(1, "exp_dt");
            formObj.old_svc_scp_cd.value=sheetObj.GetCellValue(1, "svc_scp_cd");
            formObj.taa_prop_no.value=sheetObj.GetCellValue(1, "taa_prop_no");
        }
    }
    /**
     * Making button Enable/Disable according to status<br>
     * <br><b>Example :</b>
     * <pre>
     *     buttonControl();
     * </pre>
     * @returns N/A
     * @author 
     * @version 2009.12.02
     */
    function buttonControl() {
        checkUserAuth();
        var formObj=document.form;
        if (sheetObjects[0].GetCellValue(1,"taa_no") == "") {  // New, No Data
            ComBtnDisable("btn_Amend");
            ComBtnDisable("btn_Confirm");
            ComSetDisplay("btn_ConfirmCancel",false);
            ComBtnDisable("btn_ConfirmCancel");
            ComSetDisplay("btn_Cancel",true);
            ComBtnDisable("btn_Cancel");
            if (usrSrepAuth == "Y") {
                ComBtnEnable("btn_Save");
                ComBtnEnable("btn_RowAdd");
                ComBtnEnable("btn_RowDelete");
                btnImgEnable(formObj.btns_calendar, true);
                btnImgEnable(formObj.btn_ctrt_cust, true);
                getComboObject(comboObjects, "svc_scp_cd").SetEnable(1);
                getComboObject(comboObjects, "respb_srep_cd").SetEnable(1);
                formObj.eff_dt.readOnly=false;
                formObj.exp_dt.readOnly=false;
                formObj.ctrt_cust_cnt_cd.readOnly=false;
                formObj.ctrt_cust_seq.readOnly=false;
            } else {
                ComBtnDisable("btn_Save");
                ComBtnDisable("btn_RowAdd");
                ComBtnDisable("btn_RowDelete");
                btnImgEnable(formObj.btns_calendar, false);
                btnImgEnable(formObj.btn_ctrt_cust, false);
                getComboObject(comboObjects, "svc_scp_cd").SetEnable(0);
                getComboObject(comboObjects, "respb_srep_cd").SetEnable(0);
                formObj.eff_dt.readOnly=true;
                formObj.exp_dt.readOnly=true;
                formObj.ctrt_cust_cnt_cd.readOnly=true;
                formObj.ctrt_cust_seq.readOnly=true;
            }
        } else {
        	if (sheetObjects[0].GetCellValue(1,"cfm_flg") == "Y") {    // Confirm
                if (getComboObject(comboObjects,"amdt_seq").GetSelectIndex()== 0) {  // max seq
                	if(usrOfcAuth == "Y") {
                		ComBtnEnable("btn_Amend");
                	}else{
                		ComBtnDisable("btn_Amend");
                	}
                	
                	if(usrOfcAuth == "Y" || naCapFlg=="Y" || cmpUsrIdFlg=="Y"){
                		ComSetDisplay("btn_ConfirmCancel",true);
                		ComBtnEnable("btn_ConfirmCancel");
                	}else{
                		ComSetDisplay("btn_ConfirmCancel",false);
                		ComBtnDisable("btn_ConfirmCancel");
                	}
                }else{
                	ComBtnDisable("btn_Amend");
                	ComSetDisplay("btn_ConfirmCancel",false);
                	ComBtnDisable("btn_ConfirmCancel");
                }
                ComBtnDisable("btn_Confirm");
                //ComSetDisplay("btn_Cancel",false);
                ComBtnDisable("btn_Cancel");
                ComBtnDisable("btn_RowAdd");
                ComBtnDisable("btn_RowDelete");
                btnImgEnable(formObj.btns_calendar, false);
                btnImgEnable(formObj.btn_ctrt_cust, false);
                getComboObject(comboObjects, "svc_scp_cd").SetEnable(0);
                if (usrAprvAuth == "Y" && getComboObject(comboObjects,"amdt_seq").GetSelectIndex()== 0) {   // Approver can Change SRep Code
                    ComBtnEnable("btn_Save");
                    getComboObject(comboObjects, "respb_srep_cd").SetEnable(1);
                } else {
                    ComBtnDisable("btn_Save");
                    getComboObject(comboObjects, "respb_srep_cd").SetEnable(0);
                }
                formObj.eff_dt.readOnly=true;
                formObj.exp_dt.readOnly=true;
                formObj.ctrt_cust_cnt_cd.readOnly=true;
                formObj.ctrt_cust_seq.readOnly=true;
            } else {    // Retrieve, Confirm Cancel
                ComBtnDisable("btn_Amend");
                ComSetDisplay("btn_ConfirmCancel",false);
                ComBtnDisable("btn_ConfirmCancel");
                ComSetDisplay("btn_Cancel",true);
                if (usrOfcAuth == "Y") {
                    ComBtnEnable("btn_Save");
                    ComBtnEnable("btn_Cancel");
                    ComBtnEnable("btn_RowAdd");
                    ComBtnEnable("btn_RowDelete");
                    btnImgEnable(formObj.btns_calendar, true);
                    formObj.eff_dt.readOnly=false;
                    formObj.exp_dt.readOnly=false;
                    var amdtSeq=sheetObjects[0].GetCellValue(1, "amdt_seq");
                    // Data with SEQ 0 not confirmed can be modified
                    if (!isNaN(amdtSeq) && Number(amdtSeq) > Number("0")) {
                        getComboObject(comboObjects, "svc_scp_cd").SetEnable(0);
                        if (usrAprvAuth == "Y") {   //  Approver can Change SRep Code
                            getComboObject(comboObjects, "respb_srep_cd").SetEnable(1);
                        } else {
                            getComboObject(comboObjects, "respb_srep_cd").SetEnable(0);
                        }
                        btnImgEnable(formObj.btn_ctrt_cust, false);
                        formObj.ctrt_cust_cnt_cd.readOnly=true;
                        formObj.ctrt_cust_seq.readOnly=true;
                    } else {    // amdt_seq=0
                        getComboObject(comboObjects, "svc_scp_cd").SetEnable(1);
                        getComboObject(comboObjects, "respb_srep_cd").SetEnable(1);
                        btnImgEnable(formObj.btn_ctrt_cust, true);
                        formObj.ctrt_cust_cnt_cd.readOnly=false;
                        formObj.ctrt_cust_seq.readOnly=false;
                    }
                } else {
                    if (usrAprvAuth == "Y" && getComboObject(comboObjects,"amdt_seq").GetSelectIndex()== 0) {
                        ComBtnEnable("btn_Save");
                        getComboObject(comboObjects, "respb_srep_cd").SetEnable(1);
                    } else {
                        ComBtnDisable("btn_Save");
                        getComboObject(comboObjects, "respb_srep_cd").SetEnable(0);
                    }
                    ComBtnDisable("btn_Cancel");
                    ComBtnDisable("btn_RowAdd");
                    ComBtnDisable("btn_RowDelete");
                    btnImgEnable(formObj.btns_calendar, false);
                    btnImgEnable(formObj.btn_ctrt_cust, false);
                    getComboObject(comboObjects, "svc_scp_cd").SetEnable(0);
                    formObj.eff_dt.readOnly=true;
                    formObj.exp_dt.readOnly=true;
                    formObj.ctrt_cust_cnt_cd.readOnly=true;
                    formObj.ctrt_cust_seq.readOnly=true;
                }
                if(usrOfcAuth == "Y" || naCapFlg=="Y" || cmpUsrIdFlg=="Y"){
                	ComBtnEnable("btn_Confirm");
                }else{
                	ComBtnDisable("btn_Confirm");
                }
            }
        }
    }
    /**
     * Calling function in case of OnPopupClick event <br>
     * Calling Note Conversion Popup <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {int} Row Mandatory, OnPopupClick ,Cell's Row Index
     * @param {int} Col Mandatory, OnPopupClick ,Cell's Column Index
     * @return N/A
     * @author 
     * @version 2009.12.07
     */      
    function sheet2_OnPopupClick(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        switch(colName) {
            case "note_ctnt":
                var sParam="";
                sParam += "note_conv_mapg_id=" + sheetObj.GetCellValue(Row, "note_conv_mapg_id");
                sParam += "&note_ctnt="+ encodeURIComponent(sheetObj.GetCellValue(Row, "note_ctnt"));
                var sUrl="/opuscntr/ESM_PRI_3003.do?" + sParam;
                ComOpenPopup(sUrl, 800, 500, "", "1,0", true);
                break;
        }
    }
    /**
     * Calling function in case of OnSaveEnd<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {string} ErrMsg Selection
     * @returns N/A
     * @author 
     * @version 2009.12.02
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        var formObj=document.form;
        if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
            if (formObj.taa_no.value == "" && sheetObj.GetEtcData("taa_no") != null && sheetObj.GetEtcData("taa_no") != "") {
                formObj.taa_no.value=sheetObj.GetEtcData("taa_no");
                getComboObject(comboObjects, "amdt_seq").RemoveAll();
            } else if (formObj.f_cmd.value == MULTI04) {
                // Retrieving with TAA No's Max Amdt SEQ in case of cancel
                getComboObject(comboObjects, "amdt_seq").RemoveAll();
            }
            doActionIBSheet(sheetObj,formObj,IBSEARCH);
        }
    }
    /**
     * Calling Function in case of OnSearchEnd event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {string} ErrMsg Selection
     * @returns N/A
     * @author 
     * @version 2009.12.02
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
        var formObj=document.form;
        for (var i=sheetObj.HeaderRows(), n=sheetObj.HeaderRows()+ sheetObj.RowCount(); i < n ; i++) {
        	sheetObj.SetToolTipText(i, "note_ctnt",sheetObj.GetCellValue(i, "note_ctnt"));
        }
    }
    /**
     * Calling Function in case of OnChange event  <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj Mandatory, IBMultiCombo Object
     * @param {string} code Mandatory, Selected value
     * @param {string} text Mandatory, Selected text
     * @returns N/A
     * @author 
     * @version 2009.11.20
     */
    function svc_scp_cd_OnChange (comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
        formChangeSheet(sheetObjects[0], "svc_scp_cd");
        var formObj=document.form;
        if (NewCod == "") {
            formObj.svc_scp_nm.value="";
        } else {
        	var indx=comboObj.FindItem(NewCod, 0);
            if (indx != -1) {
                formObj.svc_scp_nm.value=comboObj.GetText(indx, 1);
            } else {
                formObj.svc_scp_nm.value="";
            }
        }
    }
    /**
     * Calling function in case of OnClear event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj Mandatory, IBMultiCombo Object
     * @returns N/A
     * @author 
     * @version 2009.11.20
     */
    function svc_scp_cd_OnClear (comboObj) {
        var formObj=document.form;
        formObj.svc_scp_nm.value="";
        comboObj.SetSelectIndex(-1,false);
    }
    /**
     * Calling function in case of OnBlur event in IBMultiCombo <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj Mandatory, IBMultiCombo Object
     * @returns N/A
     * @author 
     * @version 2009.11.20
     */
    function svc_scp_cd_OnBlur(comboObj) {
        var formObj=document.form;
        if (sheetObjects[1].RowCount()> 0) {
            var trfCd=hmap.get(getComboObject(comboObjects, "svc_scp_cd").GetSelectCode());
            if (trfCd != "") {
            	if (trfCd != (sheetObjects[1].GetCellValue(2, "trf_pfx_cd")+";"+sheetObjects[1].GetCellValue(2, "trf_no"))) {
                    ComShowCodeMessage("PRI05010");
                    getComboObject(comboObjects, "svc_scp_cd").SetSelectCode(formObj.old_svc_scp_cd.value);
                    getComboObject(comboObjects, "svc_scp_cd").focus();
                    return false;
                }
            }
        }
        var code = getComboObject(comboObjects, "svc_scp_cd").GetSelectCode();
        var indx=comboObj.FindItem(code, 0);
        if (indx != -1) {
            formObj.svc_scp_nm.value=comboObj.GetText(code, 1);
        } else {
            formObj.svc_scp_nm.value="";
        }
        
        
        formObj.old_svc_scp_cd.value=code;
        formChangeSheet(sheetObjects[0], "svc_scp_cd");
    }
    /**
     * Calling Function in case of OnChange event  <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj Mandatory, IBMultiCombo Object
     * @param {string} code Mandatory, Selected value
     * @param {string} text Mandatory, Selected text
     * @returns N/A
     * @author 
     * @version 2009.11.30
     */
    function amdt_seq_OnChange (comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
        if (document.form.taa_no.value != "") {
            try {
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            } catch(e) {
                if( e == "[object Error]") {
                    ComShowMessage(OBJECT_ERROR);
                } else {
                    ComShowMessage(e.message);
                }
            } finally {
                ComOpenWait(false);
            }
        }
    }
    /**
     * Retrieving information related to Customer<br>
     * <br><b>Example :</b>
     * <pre>
     *       custNameFind(eleName);
     * </pre>
     * @param  {string} eleName Mandatory, Html Object Name
     * @return N/A
     * @author 
     * @version 2009.11.30
     */
    function custNameFind (eleName) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var ctrt_cust_cnt_cd=formObj.ctrt_cust_cnt_cd.value;
        var ctrt_cust_seq=formObj.ctrt_cust_seq.value;
        if (ctrt_cust_cnt_cd != "" && ctrt_cust_seq != "") {
            var sParam="f_cmd=" + SEARCH04 + "&cust_cnt_cd=" + ctrt_cust_cnt_cd + "&cust_seq=" + ctrt_cust_seq;
            var sXml=sheetObj.GetSearchData("ESM_PRI_3007GS.do", sParam);
            var arrText=ComPriXml2Array(sXml, "prc_ctrt_cust_tp_cd|ctrt_pty_nm|ctrt_cust_val_sgm|respb_srep_cd|respb_sls_ofc_cd|ctrt_cust_srep_nm|prc_ctrt_cust_tp_nm|ctrt_cust_val_sgm_cd");
            // CTRT_CUST_VAL_SGM_CD
            if (arrText == undefined) {
                clearCustName();
                formObj.ctrt_cust_cnt_cd.focus();
            } else {
                getComboObject(comboObjects,"respb_srep_cd").SetSelectCode("");
                sheetObj.SetCellValue(1, "prc_ctrt_cust_tp_cd",arrText[0][0],0);
                sheetObj.SetCellValue(1, "ctrt_cust_val_sgm_cd",arrText[0][7],0);
                sheetObj.SetCellValue(1, "respb_srep_cd",arrText[0][3],0);
                sheetObj.SetCellValue(1, "respb_sls_ofc_cd",arrText[0][4],0);
                formObj.ctrt_cust_nm.value=arrText[0][1];
                formObj.respb_sls_ofc_cd.value=arrText[0][4];
                formObj.respb_srep_nm.value=arrText[0][5];
            }
        }
        formChangeSheet(sheetObj, eleName);
    }
    /**
     * Clearing HTML Object's value related to Customer<br>
     * <br><b>Example :</b>
     * <pre>
     *       clearCustName();
     * </pre>
     * @param  N/A
     * @return N/A
     * @author 
     * @version 2009.11.30
     */
    function clearCustName () {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        sheetObj.SetCellValue(1, "ctrt_cust_cnt_cd","",0);
        sheetObj.SetCellValue(1, "ctrt_cust_seq","",0);
        sheetObj.SetCellValue(1, "prc_ctrt_cust_tp_cd","",0);
        sheetObj.SetCellValue(1, "ctrt_cust_val_sgm_cd","",0);
        sheetObj.SetCellValue(1, "respb_srep_cd","",0);
        sheetObj.SetCellValue(1, "respb_sls_ofc_cd","",0);
        formObj.ctrt_cust_cnt_cd.value="";
        formObj.ctrt_cust_seq.value="";
        formObj.ctrt_cust_nm.value="";
        formObj.respb_sls_ofc_cd.value="";
        getComboObject(comboObjects, "respb_srep_cd").RemoveAll();
        formObj.respb_srep_nm.value="";
    }
    /**
     * Setting retrieved Sales rep by customer sales office to IBmultiCombo<br>
     * <br><b>Example :</b>
     * <pre>
     *     setCustSaleRep();
     * </pre>
     * @param  N/A
     * @return N/A
     * @author 
     * @version 2009.11.30
     */
    function setCustSaleRep () {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        if (formObj.ctrt_cust_cnt_cd.value != "" && formObj.ctrt_cust_seq.value != "") {
            formObj.f_cmd.value=SEARCHLIST;
            var sParam=FormQueryString(formObj) + "&etc2=" + formObj.ctrt_cust_cnt_cd.value
                       + "&etc3=" + ComParseInt(formObj.ctrt_cust_seq.value);
            sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
            ComPriXml2ComboItem(sXml, respb_srep_cd, "cd", "cd|nm|etc1");
//            formObj.respb_srep_cd.InsertItem(0, "||","");
        }
    }
    /**
     * when selected item is modified in IBMulti Combo<br>
     * Modification apply to sheet by formChangeSheet() funciton. <br>
     * <br><b>Example :</b>
     * <pre>
     *    respb_srep_cd_OnChange(comboObj, code, text);
     * </pre>
     * @param   {IBMultiCombo} comboObj Mandatory, IBMultiCombo Object
     * @param   {string} code Mandatory
     * @param   {string} text Mandatory
     * @return N/A
     * @author 
     * @version 2009.11.30
     */
    function respb_srep_cd_OnChange (comboObj, OldIdx, OldText, OldCod, NewIdx, NewTxt, NewCod) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        if (NewTxt != null) {
            formObj.respb_srep_nm.value = comboObj.GetText(NewCod, 1);
            formObj.respb_sls_ofc_cd.value = comboObj.GetText(NewCod, 2);
        }
        formChangeSheet(sheetObj, "respb_srep_cd");
        formChangeSheet(sheetObj, "respb_sls_ofc_cd");
    }
    /**
     * applying all value of Html Object to hidden sheet when Html Object's value is modified<br>
     * <br><b>Example :</b>
     * <pre>
     *   formChangeSheet( sheetObj, colNm );
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {string} colNm Mandatory, Html Object의 name
     * @return N/A
     * @author 
     * @version 2009.11.30
     */
    function formChangeSheet(sheetObj, colNm) {
        var eleValue="";
        if(document.getElementById(colNm).type!==null && document.getElementById(colNm).type!==""){
            if (document.getElementById(colNm).type == "text") {
                switch (colNm) {
                    case "eff_dt":
                        eleValue=ComGetUnMaskedValue(document.getElementById(colNm).value, "ymd");
                        break;
                    case "exp_dt":
                        eleValue=ComGetUnMaskedValue(document.getElementById(colNm).value, "ymd");
                        break;
                    case "ctrt_cust_seq":
                        eleValue=ComParseInt(document.getElementById(colNm).value);
                        break;
                    default:
                        eleValue=document.getElementById(colNm).value;
                        break;
                }
                sheetObj.SetCellValue(1, colNm,eleValue,0);
            } else if (document.getElementById(colNm).type == "hidden" || document.getElementById(colNm).type == "button") {
                return;
            } else {
                sheetObj.SetCellValue(1, colNm,document.getElementById(colNm).GetSelectCode(),0);
            }
        }
    }
    /**
     * applying all value of Html Object to hidden sheet<br>
     * <br><b>Example :</b>
     * <pre>
     *   formChangeSheetAll(sheetObj, colNm);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @return N/A
     * @author 
     * @version 2010.03.17
     */
    function formChangeSheetAll(sheetObj) {
        var items=document.form.elements;
        var itemlen=items.length;
        for (var i=0 ; i < itemlen ; i++) {
        	if(items[i].id!="" && items[i].name!=""){
        		formChangeSheet(sheetObj, items[i].name);
        	}
        }
    }
    /**
     * Activating/Deactivating immage buttons<br>
     * <br><b>Example :</b>
     * <pre>
     *    btnImgEnable(obj, gb);
     * </pre>
     * @param  {form} obj Mandatory, Html Object
     * @param  {bool} gb  Mandatory, true : Activating false : Deactivating
     * @return N/A
     * @author 
     * @version 2009.12.92
     */ 
    function btnImgEnable(obj, gb) {
//        if(obj.constructor == String){
//            obj=document.getElementsByName(obj)[0];            
//        }
        //var btnStyle=obj.style;
        if (gb){           
            //obj.SetEnable(1);
            ComBtnEnable(obj.name);
            //btnStyle.cursor="hand";
            //btnStyle.filter="";
            //enableButton(obj.name); 
        } else {
            //obj.SetEnable(0);
        	ComBtnDisable(obj.name);
            //btnStyle.cursor="auto";
            //btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
            //disableButton(obj.name);    
        }
    }
    /**
     * HashMap Object creator.<br>
     * Creating same object with HashMap in JAVA<br>
     * <br><b>Example :</b>
     * <pre>     *     hm = new HashMap();      // creation
     *     hm.put(key, value);      // putting value
     *     val = hm.get(key);       // getting value
     *     hm.remove(key);          // deleting value
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.05.22
     */
    function HashMap() {
        this.mapVal={};
        this.pos=new Array();
    }
    HashMap.prototype.get=function get( key ) {
        return this.mapVal[ key ];
    }
    HashMap.prototype.getPos=function getPos( n ) {
        return this.mapVal[ this.pos[n] ];
    }
    HashMap.prototype.getKeys=function getKeys() {
        return this.pos;
    }
    HashMap.prototype.remove=function remove( n ) {
        var ary=new Array();
        var len=this.pos.length;
        if ((n + 0) == n) { // number
            for( var i=0; i < len; i++ ) {
                if( i != n ) {
                    ary.push( this.pos[i] );
                }
            }
            this.mapVal[ this.pos[n] ]=null;
        } else {    // string
            for( var i=0; i < len; i++ ) {
                if( this.pos[i] != n ) {
                    ary.push( this.pos[i] );
                }
            }
            this.mapVal[ n ]=null;
        }
        this.pos=ary;
    }
    HashMap.prototype.put=function put( key, val ) {
        this.mapVal[key]=val;
        var flg=true;
        for( var i=0; i < this.pos.length; i++ ) {
            if( key == this.pos[i] ) {
                flg=false;
                break;
            }
        }
        if( flg ) {
            this.pos.push( key );
        }
    }
    HashMap.prototype.size=function size() {
        return this.pos.length;
    }