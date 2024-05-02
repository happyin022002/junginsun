/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_3009.js
*@FileTitle  : TRI Creation & Amendment - TRI Select
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/23
=========================================================*/
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return void
     * @author 
     * @version 2009.12.03
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
                    doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                    break;
                case "btn_OK":
                    var rtnVal = new Object();
                    var checkedRowData = [];
                    for (var i=sheetObject1.HeaderRows(), n=sheetObject1.HeaderRows()+ sheetObject1.RowCount(); i < n ; i++) {
                    	if (sheetObject1.GetCellValue(i, "chk") == 1) {
                    		sheetObject1.SetCellValue(i, "ibflag","I");
                    		checkedRowData.push(sheetObject1.GetRowData(i));
                        }
                    }
                    rtnVal.data = checkedRowData;
                    ComPopUpReturnValue(rtnVal);
                    break;
                case "btn_Close":
                	ComClosePopup(); 
                    break;
                case "btn_cmdt":
                    var sUrl="/opuscntr/ESM_PRI_4027.do?grp_cd=" + PRI_SP_SCP + "&commodity_cmd=C" + "&func=findCmdt";
                    ComOpenPopup(sUrl,700, 320, "findCmdt", "1,0", false);
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
    
    function findCmdt(rtnVal) {
     	 var formObject=document.form;
  	      if (rtnVal != null){
	  	      formObject.frm_cmdt_cd.value=rtnVal.cd;
	  	      formObject.frm_cmdt_nm.value=rtnVal.nm;
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
     * @param {ibsheet} sheet_obj Mandatory, IBSheet Object
     * @return void
     * @author 
     * @version 2009.12.03
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
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
     * @version 2009.12.03
     */
    function loadPage() {
    	
    	if (!opener) opener = window.dialogArguments;
    	if (!opener) opener = window.opener;
   	 	if (!opener) opener = parent;
   	 
        try {
            for(i=0;i<sheetObjects.length;i++){
                //Modify Environment Setting Function's name
                ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
                //Add Environment Setting Function
                ComEndConfigSheet(sheetObjects[i]);
            }
            var formObj=document.form;
            initControl();
            // Retrieve
            doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
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
    /**
     * Catching events for Axon event.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl()
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.12.07
     */
    function initControl () {
        var formObj=document.form;
        // Process Axon Event No.1, Event Catch 
        axon_event.addListenerForm('change', 'obj_change', formObj);
        //axon_event.addListener('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerForm('beforeactivate', 'obj_activate', formObj);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObj);
    }
    /**
     * Process OnChange event. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.12.07
     */
    function obj_change () {
        var formObj=document.form;
        switch (event.srcElement.name) {
            case "frm_cmdt_cd":
                if (formObj.frm_cmdt_cd.value.length == 6) {
                    formObj.f_cmd.value=SEARCH08;
                    var param="&cd=" + formObj.frm_cmdt_cd.value;
	                var sXml=sheetObjects[1].GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
                    var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
                    if (arrData != null && arrData.length > 0 && arrData[1] != "") {
                        formObj.frm_cmdt_nm.value=arrData[1];
                    } else {
                        formObj.frm_cmdt_cd.value="";
                        formObj.frm_cmdt_nm.value="";
                        return false;
                    }
                } else {
                    formObj.frm_cmdt_cd.value="";
                    formObj.frm_cmdt_nm.value="";
                }
                break;
            case "frm_org_pnt_loc_cd":
                checkLocationCode(formObj, formObj.frm_org_pnt_loc_cd);
                break;
            case "frm_org_via_port_cd":
                checkLocationCode(formObj, formObj.frm_org_via_port_cd);
                break;
            case "frm_dest_via_port_cd":
                checkLocationCode(formObj, formObj.frm_dest_via_port_cd);
                break;
            case "frm_dest_pnt_loc_cd":
                checkLocationCode(formObj, formObj.frm_dest_pnt_loc_cd);
                break;
            default:
        }
    }
    /**
     * Process Onbeforedeactivate Event. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_deactivate();
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.12.08
     */
    function obj_deactivate () {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var ele=event.srcElement;
        var eleName=ele.name;
        switch (eleName) {
            case "frm_tri_no":
                // TRI No Format : 6 Digit-4 Digit-3 Digit
                var val=ele.value;
                if (val == "" || val.replace(/-/g,"").length != 13) {
                    ele.value="";
                    return;
                }
                var re=/(^[0-9]{6})+([0-9]{4})+([0-9]{3}$)/g;
                ele.value=val.replace(re, "$1-$2-$3");
                break;
        }
    }
    /**
     * Process OnBeforeActivate Event. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_activate();
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.12.08
     */
    function obj_activate () {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var eleName=event.srcElement.name;
        switch (eleName) {
            case "frm_tri_no":
                event.srcElement.value=event.srcElement.value.replace(/-/g,"");
                break;
        }
    }
    /**
     * Check the validation of Location Code. <br>
     * <br><b>Example :</b>
     * <pre>
     *     checkLocationCode(document.form, document.form.loc_cd);
     * </pre>
     * @param {object} frm Mandatory, Html Form Object
     * @param {object} src Mandatory, Html Object
     * @return void
     * @author 
     * @version 2009.12.03
     */
    function checkLocationCode(frm, src) {
        if (src.value.length == 5) {
            frm.f_cmd.value=SEARCH05;
            var param="&cd=" + src.value;
            var sXml=sheetObjects[1].GetSearchData("PRICommonGS.do", FormQueryString(frm) + param);
            var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
            // When the code is not exist in MDM_LOCATION. Clear it.
            if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
                src.value="";
                src.focus();
            }
        } else {
            // When length of code is not 5 digit. Clear it.
            src.value="";
            src.focus();
        }
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {int} sheetNo Mandatory, IBSheet Object ,Serial no for Tag's ID
     * @return void
     * @author 
     * @version 2009.12.03
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){               
		              var HeadTitle="status|Sel.|Seq.|tri_prop_no|Tariff Rate Item\n(TRI)|Commodity|Commodity|Route|Route|Route|Route|Route nm|Route nm|Route nm|Route nm|Per|CGO\nType|Cur.|Rate|Note|note_conv_mapg_id|Duration|Duration|trf_pfx_cd|trf_no";
		              var HeadTitle1="status|Sel.|Seq.|tri_prop_no|Tariff Rate Item\n(TRI)|Code|Description|Origin|Origin Via|Dest Via|Dest|Origin Nm|Origin Via Nm|Dest Via Nm|Dest Nm|Per|CGO\nType|Cur.|Rate|Note|note_conv_mapg_id|Effective|Expiration|trf_pfx_cd|trf_no";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              (headCount, 0, 0, true);
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"tri_prop_no",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"tri_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:77,   Align:"Left",    ColMerge:1,   SaveName:"org_pnt_loc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"org_via_port_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"dest_via_port_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:77,   Align:"Left",    ColMerge:1,   SaveName:"dest_pnt_loc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"org_pnt_loc_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"org_via_port_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"dest_via_port_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"dest_pnt_loc_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"prc_cgo_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0, Width:66,   Align:"Right",   ColMerge:1,   SaveName:"fnl_frt_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Popup",     Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"note_ctnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"note_conv_mapg_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"exp_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"trf_pfx_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"trf_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		              SetEditable(1);
		              SetWaitImageVisible(0);
		              SetEllipsis(1);
		              SetAutoRowHeight(0);
		              SetColProperty("tri_no", {Format:"######-####-###"} );
		              SetShowButtonImage(2);
		              SetSheetHeight(210);
              }
                break;
            case "sheet2":  // hidden
                with(sheetObj){                
		             var HeadTitle="status";
		             var headCount=ComCountHeadTitle(HeadTitle);
		             (headCount, 0, 0, true);
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];              
		             InitColumns(cols);
		             SetEditable(1);
		             SetWaitImageVisible(0);
		             SetVisible(false);
		             SetSheetHeight(182);
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
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {form} formObj Mandatory, html form object
     * @param {int} sAction Mandatory, ,Process Flag constant variable
     * @return void
     * @author 
     * @version 2009.12.03
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:      //Retrieving
                ComOpenWait(true);
                if (!validateForm(sheetObj,formObj,sAction)) {
                    return;
                }
                // Clear Route Name item
                formObj.frm_org_pnt_loc_nm.value="";
                formObj.frm_org_via_port_nm.value="";
                formObj.frm_dest_via_port_nm.value="";
                formObj.frm_dest_pnt_loc_nm.value="";
                formObj.f_cmd.value=SEARCH;
                sheetObj.DoSearch("ESM_PRI_3009GS.do", FormQueryString(formObj) );
                ComOpenWait(false);
                break;
        }
    }
    /**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *        handling logic
     *     }
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {form} formObj Mandatory, html form object
     * @param {int} sAction Mandatory, ,Process Flag constant variable
     * @returns bool, <br>
     *          true  : valid<br>
     *          false : inValid
     * @author 
     * @version 2009.12.03
     */
    function validateForm(sheetObj,formObj,sAction){
        switch (sAction) {
            case IBSEARCH:
                if (formObj.frm_trf_pfx_cd.value == '' && formObj.frm_trf_no.value == '') {
                    ComShowCodeMessage('PRI00316','Tariff Code');
                    return false;
                }
                break;
        }
        return true;
    }
    /**
     * calling function in case of OnSelectCell event <br>
     * Display Route Name proper to selected TRI List. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {int} OldRow Mandatory, ,Previous selected cell's Row Index
     * @param {int} OldCol Mandatory, ,Previous selected cell's Column Index
     * @param {int} NewRow Mandatory, ,current selected cell's Row Index
     * @param {int} NewCol Mandatory, ,current selected cell's Column Index
     * @return void
     * @author 
     * @version 2009.11.30
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        if(OldRow != NewRow){
            var formObj=document.form;
			formObj.frm_org_pnt_loc_nm.value=sheetObj.GetCellValue(NewRow, "org_pnt_loc_nm").replace(/\|/g, "\n");
			formObj.frm_org_via_port_nm.value=sheetObj.GetCellValue(NewRow, "org_via_port_nm").replace(/\|/g, "\n");
			formObj.frm_dest_via_port_nm.value=sheetObj.GetCellValue(NewRow, "dest_via_port_nm").replace(/\|/g, "\n");
			formObj.frm_dest_pnt_loc_nm.value=sheetObj.GetCellValue(NewRow, "dest_pnt_loc_nm").replace(/\|/g, "\n");
        }
    }
    /**
     * Calling function in case of OnPopupClick event<br>
     * Open Note Conversion Popup. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {int} Row Mandatory, Cell's Row Index
     * @param {int} Col Mandatory, Cell's Column Index
     * @return void
     * @author 
     * @version 2009.12.07
     */      
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        switch(colName) {
            case "note_ctnt":
                var sParam="";
                sParam += "note_conv_mapg_id=" + sheetObj.GetCellValue(Row, "note_conv_mapg_id");
                sParam += "&note_ctnt="+ encodeURIComponent(sheetObj.GetCellValue(Row, "note_ctnt"));
                var sUrl="/opuscntr/ESM_PRI_3003.do?" + sParam;
                ComOpenPopup(sUrl, 800, 500, "", "1,0", false);
                break;
        }
    }
    /**
     * Calling Function in case of OnSearchEnd event <br>
     * Applied Tooltip using Note Content after Sheet retrieve completely <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {string} ErrMsg selection
     * @returns void
     * @author 
     * @version 2009.12.07
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        var formObj=document.form;
        for (var i=sheetObj.HeaderRows(), n=sheetObj.HeaderRows()+ sheetObj.RowCount(); i < n ; i++) {
        	sheetObj.SetToolTipText(i, "note_ctnt",sheetObj.GetCellValue(i, "note_ctnt"));
        }
        formObj.frm_cmdt_cd.focus();
    }
