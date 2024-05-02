/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0510.js
*@FileTitle  : Hold Notice Send
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var tabObjects=new Array();
    var tabCnt=0;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * 
     * @return 
     * @author 
     */
    function processButtonClick(){
        /***** using extra sheet valuable if there are more 2 sheets *****/
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
        var sheetObject4 = sheetObjects[3];
        /*******************************************************/
        var formObject = document.form;
        var sheetObj = sheetObjects[0];
        if (tabObjects[0].GetSelectedIndex() == 0) {
        	sheetObj= t1sheet1;
        }
		else if (tabObjects[0].GetSelectedIndex() == 1) {
			sheetObj= t2sheet1;
		}
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
            case "img_dt":
    	        ComSetObjValue(formObject.sch_tp_cd, "ETA");
    	        setMandantorySearchType();
    	        var cal=new ComCalendarFromTo();
    		    cal.select(formObject.dt_s, formObject.dt_e, 'yyyy-MM-dd');
//    		    var cal=new ComCalendar();
//                cal.select(formObject.dt_s, 'yyyy-MM-dd');
                

                break;
            case "btn_Retrieve":
            	doActionIBSheet(sheetObj,formObject,IBSEARCH);
                break;
            case "btn_CustomsResult":
            	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC03);
            	break;
            case "btn_Fax_Send":
            	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC04);
                break;
            case "btn_Email_Send":
            	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC05);
                break;
            case "btn_DownExcel":
            	doActionIBSheet(sheetObj,formObject,IBDOWNEXCEL);
            	break;
            case "btn_ListPrint":
            	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC06);
                break;
            case "btn_SentHistory":
            	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC15);
            	break;
            case "btn_t1Preview":
            case "btn_t2Preview":
            	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC11);
                break;
            case "btn_t1FormSetting":
            case "btn_t2FormSetting":
            	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC13);
                break;
            case "btn_t2GotoTPB":
            	if (tabObjects[0].GetSelectedIndex() == 0) break;
            	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC10);
            	break;
            case "btn_Close":
            	ComClosePopup();
            	break;
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }
    /**
     * registering IBSheet Object as list<br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * 
     * @param sheet_obj
     * @return 
     * @author 
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen. <br>
     * 
     * @return 
     * @author 
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++) {
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<tabObjects.length;k++) {
            initTab(tabObjects[k],k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
        if (document.form.flag.value == "ESM_BKG_0510-01") {
        	tabObjects[0].SetSelectedIndex(1);
        }
        initControl();
        initForm();
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC14);
    }
    /**
     * initializing form data
     * setting initial data after open screen and remove data
     * @return 
     * @author 
     */
    function initForm() {
 		with(document.form) {
 	        var endDay=ComGetNowInfo("ymd", "-");
 	        var startDay=ComGetDateAdd(endDay, "D", -14, "-");        
            dt_s.value=startDay;
            dt_e.value=endDay;
 			vvd.value="";
 			pod_cd.value="";
 			del_cd.value="";
 		    snd_rslt_cd.value="ALL";
 		    bl_no.value="";
 		    cntr_no.value="";
	        ComSetObjValue(sch_tp_cd, "VVD");
 			setMandantorySearchType();
 		}
    }
    /**
     * registering HTML tag event <br>
     * 
     * @return 
     * @author 
     */
    function initControl() {
    	//axon_event.addListenerFormat("keypress","obj_KeyPress", form);
       	axon_event.addListener("click","obj_click", "sch_tp_cd", "vvd", "dt_s", "dt_e", "bl_no");
       	axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
       	axon_event.addListenerForm ('focus', 'obj_activate', form);
    }
    
    function obj_activate()
    {
    	var formObj=document.form;
    	var srcName=ComGetEvent("name");
     	switch(srcName) {
     	case "sch_tp_cd":
     		setMandantorySearchType();
     		break;
     	case "vvd":
     		formObj.sch_tp_cd[0].checked=true;
     		break;
     	case "dt_s":
     	case "dt_e":
     		formObj.sch_tp_cd[1].checked=true;
     		break;
     	case "bl_no":
     		formObj.sch_tp_cd[2].checked=true;
     		break;
     	}
    }    
    /**
     * process Click event<br>
     * 
     * @return 
     * @author 
     */
    function obj_click() {
        var formObject=document.form;
     	switch(ComGetEvent("name")) {
     	case "sch_tp_cd":
     		setMandantorySearchType();
     		break;
     	case "vvd":
     		ComSetObjValue(formObject.sch_tp_cd, "VVD");
     		setMandantorySearchType();
     		break;
     	
     	case "bl_no":
     		ComSetObjValue(formObject.sch_tp_cd, "BL");
     		setMandantorySearchType();
     		break;
     	}
     }
     /**
      * setting sheet initial values and header
      * @param sheetObj
      * @param sheetNo
      * @return
      */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "t1sheet1":
                with(sheetObj){
					  var HeadTitle1="|Status| |WD|BKG No.|SEQ|Status|Form|Loc|BL No.|VVD|POD|DEL|Office|Cust.Cd|Cust.Seq|Cust. Code|Customer Name|H|Hold Date|B/L|TYPE|Fax|||E-mail|||Result Date|Remark(s)";
					  var headCount=ComCountHeadTitle(HeadTitle1);
					  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:10, DataRowMerge:1 } );
					  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					  InitHeaders(headers, info);
					  var cols = [ 
					         {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					         {Type:"Seq",       Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
					         {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
					         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ntc_wd_yn",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ntc_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hld_ntc_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cstms_hld_ntc_fom_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cstms_hld_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cust_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0, Width:230,  Align:"Left",    ColMerge:0,   SaveName:"cust_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
					         {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cstms_pre_hld_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"pre_hld_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"hld_eclz_obl_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					         {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_cntc_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fax_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
					         {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"hld_fax_snd_rslt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"hld_fax_snd_rslt_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"ntc_eml",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
					         {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"hld_eml_snd_rslt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"hld_eml_snd_rslt_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"hld_snd_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0, Width:340,  Align:"Left",    ColMerge:0,   SaveName:"hld_diff_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					  InitColumns(cols);
					  SetEditable(1);
					  //SetColProperty("pre_hld_dt", {Format:"####-##-####:##"} );
					  //SetColProperty("hld_snd_dt", {Format:"####-##-####:##"} );
					  SetColProperty("hld_eclz_obl_flg", {ComboText:"Yes|No", ComboCode:"Y|N"} );
					  SetEllipsis(1);
					  SetSheetHeight(420);
					  //SetAutoRowHeight(0);
					  // InitDataValid(0, "cust_cd", vtEngUpOther, "0123456789");
					  // InitDataValid(0, "fax_no", vtNumericOther, "-");
            	}
                break;
            case "t1sheet2":
                with(sheetObj){
            	      var HeadTitle1="|CHK|WD||BKG No.|SEQ|Status|Form|Loc|BL No.|VVD|POD|DEL|Office|||Cust. Code|Customer Name|H|Hold Date|B/L|TYPE|Fax|||E-mail|||Result Date|Remark(s)";
            	      var headCount=ComCountHeadTitle(HeadTitle1);
            	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
            	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            	      InitHeaders(headers, info);
            	      var cols = [ 
            	             {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            	             {Type:"Seq",       Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
            	             {Type:"CheckBox",	Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"chk",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ntc_wd_yn",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"ntc_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:15,   Align:"Center",  ColMerge:0,   SaveName:"hld_ntc_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:15,   Align:"Center",  ColMerge:0,   SaveName:"cstms_hld_ntc_fom_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:15,   Align:"Center",  ColMerge:0,   SaveName:"cstms_hld_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"vvd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cust_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cust_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cust_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
            	             {Type:"Text",      Hidden:0, Width:15,   Align:"Center",  ColMerge:0,   SaveName:"cstms_pre_hld_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pre_hld_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Combo",     Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"hld_eclz_obl_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cust_cntc_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fax_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
            	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"hld_fax_snd_rslt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"hld_fax_snd_rslt_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"ntc_eml",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
            	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"hld_eml_snd_rslt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"hld_eml_snd_rslt_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"hld_snd_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"hld_diff_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 } ];
            	       
            	      InitColumns(cols);
            	      SetEditable(1);
            	      //SetColProperty("pre_hld_dt", {Format:"####-##-####:##"} );
            	      //SetColProperty("hld_snd_dt", {Format:"####-##-####:##"} );
            	      SetColProperty("hld_eclz_obl_flg", {ComboText:"Yes|No", ComboCode:"Y|N"} );
            		  SetSheetFontSize(6);
            		  SetVisible(false);
            	      // InitDataValid(0, "cust_cd", vtEngUpOther, "0123456789");
            	      // InitDataValid(0, "fax_no", vtNumericOther, "-");
        	    }
                break;
            case "t2sheet1":
                with(sheetObj){
            	      var HeadTitle1="|WD| |BKG No.|SEQ|Status|Loc||BL No.|VVD|POD|DEL|Ofc|||Cust. Code|Customer Name|Form Type|H|Hold Date|C|Clear Date|TPB|B/L|TYPE|Fax|||E-mail|||Result Date|Remark(s)";
            	      var headCount=ComCountHeadTitle(HeadTitle1);
            	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:9, DataRowMerge:1 } );
            	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            	      var headers = [{ Text:HeadTitle1, Align:"Center"}];
            	      InitHeaders(headers, info);
            	      var cols = [ 
            	             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            	             {Type:"Seq",       Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
            	             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ntc_wd_yn",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ntc_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hld_ntc_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cstms_hld_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cust_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cust_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:230,  Align:"Left",    ColMerge:0,   SaveName:"cust_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cstms_hld_ntc_fom_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cstms_pre_hld_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"pre_hld_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cstms_cfm_hld_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cfm_hld_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_bil_no_yn",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hld_eclz_obl_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_cntc_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fax_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
            	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"hld_fax_snd_rslt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"hld_fax_snd_rslt_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"ntc_eml",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
            	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"hld_eml_snd_rslt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"hld_eml_snd_rslt_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"hld_snd_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:340,  Align:"Left",    ColMerge:0,   SaveName:"hld_diff_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
            	       
            	      InitColumns(cols);
            	      SetEditable(1);
	                  //SetColProperty("pre_hld_dt", {Format:"####-##-####:##"} );
            	      //SetColProperty("cfm_hld_dt", {Format:"####-##-####:##"} );
            	      //SetColProperty("hld_snd_dt", {Format:"####-##-####:##"} );
            	      SetColProperty("hld_eclz_obl_flg", {ComboText:"Yes|No", ComboCode:"Y|N"} );
                  	  SetColProperty("cstms_hld_ntc_fom_cd", {ComboText:"Event1|Event2|Event3|Event4|Event5", ComboCode:"E1|E2|E3|E4|E5"} );
                  	  SetSheetHeight(420);
            	      SetEllipsis(1);
            	      SetAutoRowHeight(1);
            	      //conversion of function[check again]CLT                     InitDataValid(0, "cust_cd", vtEngUpOther, "0123456789");
            	      //conversion of function[check again]CLT                     InitDataValid(0, "fax_no", vtNumericOther, "-");
    	      	}
                break;
            case "t2sheet2":
                with(sheetObj){
            	      var HeadTitle1="||CHK|WD|BKG No.|SEQ|Status|Loc|BL No.|VVD|POD|DEL|Ofc|||Cust. Code|Customer Name|Form|H|Hold Date|C|Clear Date|TPB|B/L|TYPE|Fax|||E-mail|||Result Date|Remark(s)";
            	      var headCount=ComCountHeadTitle(HeadTitle1);
            	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:9, DataRowMerge:1 } );
            	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            	      InitHeaders(headers, info);
            	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ntc_wd_yn",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ntc_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hld_ntc_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cstms_hld_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vvd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cust_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cust_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cust_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cstms_hld_ntc_fom_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0, Width:15,   Align:"Center",  ColMerge:0,   SaveName:"cstms_pre_hld_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pre_hld_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:15,   Align:"Center",  ColMerge:0,   SaveName:"cstms_cfm_hld_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cfm_hld_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_bil_no_yn",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"hld_eclz_obl_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cust_cntc_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fax_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
            	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"hld_fax_snd_rslt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"hld_fax_snd_rslt_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"ntc_eml",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
            	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"hld_eml_snd_rslt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"hld_eml_snd_rslt_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"hld_snd_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"hld_diff_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
            	       
            	      InitColumns(cols);
            	      SetEditable(1);
            	      //SetColProperty("pre_hld_dt", {Format:"####-##-####:##"} );
            	      //SetColProperty("cfm_hld_dt", {Format:"####-##-####:##"} );
            	      //SetColProperty("hld_snd_dt", {Format:"####-##-####:##"} );
            	      SetColProperty("hld_eclz_obl_flg", {ComboText:"Yes|No", ComboCode:"Y|N"} );
                  	  SetColProperty("cstms_hld_ntc_fom_cd", {ComboText:"Event1|Event2|Event3|Event4|Event5", ComboCode:"E1|E2|E3|E4|E5"} );
                  	  SetSheetFontSize(6);
                  	  SetVisible(false);
            	      //conversion of function[check again]CLT                     InitDataValid(0, "cust_cd", vtEngUpOther, "0123456789");
            	      //conversion of function[check again]CLT                     InitDataValid(0, "fax_no", vtNumericOther, "-");
            	}
                break;
        }
    }
    /**
     * handling sheet process
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return void
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        sheetObj.SetWaitImageVisible(0);
    	var trgSheetObj=sheetObjects[2];
    	if (sheetObj.id == "t1sheet1") trgSheetObj=sheetObjects[2];
    	else trgSheetObj=sheetObjects[3];
        switch(sAction) {
            //retrieve
            case IBSEARCH:              	
                if (validateForm(sheetObj,formObj,sAction) == false) break;
                ComOpenWait(true);
                if (sheetObj.id == "t1sheet1") {
                    formObj.f_cmd.value=SEARCH;
                    sheetObj.DoSearch("ESM_BKG_0510GS.do", FormQueryString(formObj) );
                } else if (sheetObj.id == "t2sheet1") {
                    formObj.f_cmd.value=SEARCH01;
                    sheetObj.DoSearch("ESM_BKG_0510_01GS.do", FormQueryString(formObj));
                }
                ComOpenWait(false);
                break;
            // Go To TPB
            case IBSEARCH_ASYNC10:
            	var iCheckRow=sheetObj.CheckedRows("chk");
            	if (iCheckRow < 1) {
            		ComShowCodeMessage("BKG40090", "TPB Issue");
            		break;
            	} else if (iCheckRow > 1) {
            		ComShowCodeMessage("BKG40075");
            		break;
            	}
            	var sCheckRow=sheetObj.FindCheckedRow("chk");
            	var arrRow=sCheckRow.split("|");
				var param="bkg_no="  + sheetObj.GetCellValue(arrRow, "bkg_no")  + "&" +
					"ntc_seq=" + sheetObj.GetCellValue(arrRow, "ntc_seq") + "&" +
					"bl_no="   + sheetObj.GetCellValue(arrRow, "bl_no")   + "&" +
					"cust_cd=" + sheetObj.GetCellValue(arrRow, "cust_cd") + "&" +
					"cust_nm=" + sheetObj.GetCellValue(arrRow, "cust_nm");
            	ComOpenPopupWithTarget('/opuscntr/ESM_BKG_1068.do?' + param, 605, 290, "", "none", false);
            	break;
            // Customs Result
            case IBSEARCH_ASYNC03:
            	var iCheckRow=sheetObj.CheckedRows("chk");
            	if (iCheckRow < 1) {
            		ComShowCodeMessage("BKG00149");
            		break;
            	} else if (iCheckRow > 1) {
            		ComShowCodeMessage("BKG40075");
            		break;
            	}
            	var sCheckRow=sheetObj.FindCheckedRow("chk");
            	var arrRow=sCheckRow.split("|");
            	var param="&bl_no=" + sheetObj.GetCellValue(arrRow, "bl_no");
            	ComOpenPopupWithTarget('/opuscntr/ESM_BKG_0034_POP.do?pgmNo=ESM_BKG_0034-03&open_tab=2' + param, 1100, 700, "", "none", false);
            	break;            	
            	// Fax 
            case IBSEARCH_ASYNC04:         
                if (validateForm(sheetObj,formObj,sAction) == false) break;
            	if (sheetObj.id == "t1sheet1") {
                    if (ComShowCodeConfirm("BKG40037", "Hold Notice") == false) {
                    	break;
                    }
            	} else {
                    if (ComShowCodeConfirm("BKG40037", "Hold Removal Notice") == false) {
                    	break;
                    }
            	}
                ComOpenWait(true);
                if (sheetObj.id == "t1sheet1") {
                    formObj.f_cmd.value=MULTI01;
                } else {
                    formObj.f_cmd.value=MULTI11;
                }
                var sParam=FormQueryString(formObj);
                var sParamSheet=sheetObj.GetSaveString(false, true, "chk");
                if (sParamSheet != "") {
                    sParam += "&" + ComSetPrifix(sParamSheet, "sheet1_");
                }                
            	var sXml="";
                if (sheetObj.id == "t1sheet1") {
                	sXml = sheetObj.GetSaveData("ESM_BKG_0510GS.do", sParam);
                } else {
                	sXml=sheetObj.GetSaveData("ESM_BKG_0510_01GS.do", sParam);
                }
                	sheetObj.LoadSaveData(sXml);
                ComOpenWait(false);
				if(ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
		    		doActionIBSheet(sheetObj,formObj,IBSEARCH);
				}
                break;
            	// Email
            case IBSEARCH_ASYNC05: 
                if (validateForm(sheetObj,formObj,sAction) == false) break;
            	if (sheetObj.id == "t1sheet1") {
                    if (ComShowCodeConfirm("BKG40038", "Hold Notice") == false) {
                    	break;
                    }
            	} else {
                    if (ComShowCodeConfirm("BKG40038", "Hold Removal Notice") == false) {
                    	break;
                    }
            	}
            	ComOpenWait(true);
                if (sheetObj.id == "t1sheet1") {
                    formObj.f_cmd.value=MULTI02;
                } else {
                    formObj.f_cmd.value=MULTI12;
                }                
                var sParam=FormQueryString(formObj);
                var sParamSheet=sheetObj.GetSaveString(false, true, "chk");
                if (sParamSheet != "") {
                    sParam += "&" + ComSetPrifix(sParamSheet, "sheet1_");
                }
            	var sXml="";
                if (sheetObj.id == "t1sheet1") {
                	sXml=sheetObj.GetSaveData("ESM_BKG_0510GS.do", sParam);
                } else {
                	sXml=sheetObj.GetSaveData("ESM_BKG_0510_01GS.do", sParam);
                }
                sheetObj.LoadSaveData(sXml);
                ComOpenWait(false);
				if(ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
		    		doActionIBSheet(sheetObj,formObj,IBSEARCH);
				}								
                break;
            // Preview
            case IBSEARCH_ASYNC11:            	
         	    if (sheetObj.RowCount()== 0) {
         	    	ComShowCodeMessage("BKG00395"); 
        	        break;
        	    }
         	    var sRowStr=sheetObj.GetSelectionRows("/");
            	var arr=sRowStr.split("/");
               	if (arr.length < 1) {
            		ComShowCodeMessage("BKG00149");
            		break;
            	} else if (arr.length > 1) {
            		ComShowCodeMessage("BKG40075");
            		break;
            	}
            	var vRow=arr[0];
    		    sheetObj.SetWaitImageVisible(0);
            	var vParam="f_cmd=" + COMMAND03 + 
					"&ofc_cd=" + sheetObj.GetCellValue(vRow, "ofc_cd") +
					"&pod_cd=" + sheetObj.GetCellValue(vRow, "pod_cd") +
					"&hld_ntc_tp_cd=" + sheetObj.GetCellValue(vRow, "hld_ntc_tp_cd");
            	var sXml=sheetObj.GetSearchData("ESM_BKG_0510GS.do", vParam);
    		    //sheetObj.WaitImageVisible = true;
    	        if (ComGetEtcData(sXml, "exist") == "no") {
					ComShowCodeMessage("BKG40077");
					sheetObj.SelectCell(vRow, "bl_no");
					break;
    	        }
				var bkg_no=sheetObj.GetCellValue(vRow, "bkg_no");
				var ntc_seq=sheetObj.GetCellValue(vRow, "ntc_seq");
				var cust_nm=sheetObj.GetCellValue(vRow, "cust_nm").replace("'","''");
				var remark=sheetObj.GetCellValue(vRow, "hld_diff_rmk").replace("'","''");
				var fom_cd=sheetObj.GetCellValue(vRow, "cstms_hld_ntc_fom_cd");
				var usr_id=formObj.usr_id.value;
				var ofc_cd=sheetObj.id == "t1sheet1" ? sheetObj.GetCellValue(vRow, "ofc_cd") : "";
                if (sheetObj.id == "t1sheet1") {
                	formObj.com_mrdTitle.value="Hold Notice";
                	formObj.com_mrdBodyTitle.value="Hold Notice";
                	formObj.com_mrdPath.value="apps/opus/esm/bkg/inbounddocumentation/inboundnoticemgt/inboundnotice/report/ESM_BKG_0761.mrd";
                	formObj.com_mrdArguments.value="/rv bkg_no['" + bkg_no + "'] ntc_seq['" + ntc_seq + "'] " + 
                	                                    "p_usr_id['" + usr_id + "'] p_ofc_cd['" + ofc_cd + "'] " + 
                	                                    "p_cust_nm['" + cust_nm + "'] p_remark['" + remark + "']";
                } else {
                	var ofc_cd = sheetObj.GetCellValue(vRow, "ofc_cd");
                	formObj.com_mrdTitle.value="Hold Notice";
                	formObj.com_mrdBodyTitle.value="Hold Removal Notice";
                	formObj.com_mrdPath.value="apps/opus/esm/bkg/inbounddocumentation/inboundnoticemgt/inboundnotice/report/ESM_BKG_0762.mrd";
                	formObj.com_mrdArguments.value="/rv bkg_no['" + bkg_no + "'] ntc_seq['" + ntc_seq + "'] " + 
                	                                    "p_usr_id['" + usr_id + "'] p_ofc_cd['" + ofc_cd + "'] p_fom_cd['" + fom_cd + "'] " +
                	                                    "p_cust_nm['" + cust_nm + "'] p_remark['" + remark + "']";
                }               
            	ComOpenRDPopup();
            	break;
            // EXCEL DOWNLOAD
     		case IBDOWNEXCEL:
     			var rowSkipList="";
     			for (var i=0; i<sheetObj.RowCount(); i++) {
     				if (sheetObj.GetCellValue(i+1,"chk") == "0") {
     					rowSkipList += (i+1) + "|";
     				}
     			}
     			//sheetObj.Down2Excel({ HiddenColumn:-1,TreeLevel:false});
     			if(sheetObj.RowCount() < 1){//no data
     				ComShowCodeMessage("COM132501");
     			}else{
     				 sheetObj.Down2Excel({ HiddenColumn:1});
     			}
     			break;
                // List Print
            case IBSEARCH_ASYNC06:
         	    if (sheetObj.RowCount()== 0) {
        		    ComShowCodeMessage("BKG00395"); 
        	        break;
        	    }
         	    var iCheckRow=sheetObj.CheckedRows("chk");
           	    if (iCheckRow < 1) {
            		ComShowCodeMessage("BKG00149");
            		break;
            	}
            	//trgSheetObj.RemoveAll();
            	//trgSheetObj.Copy2SheetCol(sheetObj,"","",-1,-1,-1,1,false,false, "chk", "");             	
            	sheetObj.DoPrint();
                break;
                // Form Setting
            case IBSEARCH_ASYNC13:
            	var iCheckRow=sheetObj.CheckedRows("chk");
            	if (iCheckRow < 1) {
            		ComShowCodeMessage("BKG00149");
            		break;
            	} else if (iCheckRow > 1) {
            		ComShowCodeMessage("BKG40075");
            		break;
            	}
            	var sCheckRow=sheetObj.FindCheckedRow("chk");
            	var arrRow=sCheckRow.split("|");
				var param="&popUp=Y&ofc_cd=" + sheetObj.GetCellValue(arrRow[0], "ofc_cd") +
						"&pod_cd=" + sheetObj.GetCellValue(arrRow[0], "pod_cd");
            	if (sheetObj.id == "t1sheet1")            	
            		ComOpenPopup('/opuscntr/ESM_BKG_0511_POP.do?pgmNo=ESM_BKG_0511' + param , 1100, 700, "PopupEsmBkg0511", "1,0,1,1,1,1,1", false);
            	else 
            		ComOpenPopup('/opuscntr/ESM_BKG_0760_POP.do?pgmNo=ESM_BKG_0760' + param, 1020, 700, "PopupEsmBkg0760", "1,0,1,1,1,1,1", false);
            	break;
            	// Cust Type retrieve
            case IBSEARCH_ASYNC14:
            	//sheetObj.WaitImageVisible = false;
            	var sXml=sheetObj.GetSearchData("ESM_BKG_0000GS.do", "f_cmd=" + SEARCHLIST01 + "&cm_code=CD02129");
        		if (sXml.length > 0) {
        			var arrCombo=ComXml2ComboString(sXml, "val", "name");
        			if (sheetObjects[0])
        				sheetObjects[0].SetColProperty("cust_cntc_tp_cd", {ComboText:arrCombo[1], ComboCode:arrCombo[0]} );
        			if (sheetObjects[1])
        				sheetObjects[1].SetColProperty("cust_cntc_tp_cd", {ComboText:arrCombo[1], ComboCode:arrCombo[0]} );
        			if (sheetObjects[2])
        				sheetObjects[2].SetColProperty("cust_cntc_tp_cd", {ComboText:arrCombo[1], ComboCode:arrCombo[0]} );
        			if (sheetObjects[3])
        				sheetObjects[3].SetColProperty("cust_cntc_tp_cd", {ComboText:arrCombo[1], ComboCode:arrCombo[0]} );
        		}
            	break;
            	// History
            case IBSEARCH_ASYNC15:
         	    if (sheetObj.RowCount()== 0) {
         	    	ComShowCodeMessage("BKG00395"); 
        	        break;
        	    }
         	    var sRowStr=sheetObj.GetSelectionRows("/");
            	var arr=sRowStr.split("/");
               	if (arr.length < 1) {
            		ComShowCodeMessage("BKG00149");
            		break;
            	} else if (arr.length > 1) {
            		ComShowCodeMessage("BKG40075");
            		break;
            	}
            	var arrRow=arr[0];
            	var param="&autoSearchFlg=Y&sch_tp=B&bl_no=" + sheetObj.GetCellValue(arrRow, "bl_no");
            	ComOpenPopupWithTarget('/opuscntr/ESM_BKG_0001_POP.do?pgmNo=ESM_BKG_0001_POP&mainPage=false' + param, 1024, 600, "", "none", true);
            	break;
         }
     }
    /**
      * registering IBTab Object as list<br>
      * adding process for list in case of needing batch processing with other items<br>
      * defining list on the top of source <br>
      * 
      * @param tab_obj
      * @return 
      * @author 
      */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * Tab option <br>
     * setting tab list <br>
     * 
     * @param tabObj
     * @param tabNo
     * @return 
     * @author 
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                 with (tabObj) {
                     var cnt=0 ;
					InsertItem( "Hold Notice" , "");
					InsertItem( "Hold Removal Notice" , "");
                 }
             break;
         }
     }
    /**
     * event in case of clicking tab <br>
     * activating selected tab <br>
     * 
     * @param tabObj
     * @param nItem
     * @return 
     * @author 
     */
    function tab1_OnChange(tabObj , nItem) {
        var objs = document.all.item("tabLayer");
     	objs[nItem].style.display="Inline";
     	objs[beforetab].style.display="none";
     	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
     	beforetab=nItem;
    }
    /**
     * event handling in case of changing Tab1 Sheet1<br>
     * 
     * @param  sheetObj
     * @param  Row
     * @param  Col
     * @param  Value
     * @return 
     * @author 
     */
    function t1sheet1_OnChange(sheetObj, Row, Col, Value) {
    	sheet_Change(sheetObj, Row, Col, Value);
    }
    /**
     * event handling in case of changing Tab2 Sheet1<br>
     * 
     * @param  sheetObj
     * @param  Row
     * @param  Col
     * @param  Value
     * @return 
     * @author 
     */
    function t2sheet1_OnChange(sheetObj, Row, Col, Value) {
    	sheet_Change(sheetObj, Row, Col, Value);
    }
    /**
     * event handling in case of changing Sheet<br>
     * checking mail form validation in case of changing e-mail
     * 
     * @param  sheetObj 
     * @param  Row      
     * @param  Col      
     * @param  Value    
     * @return 
     */
    function sheet_Change(sheetObj, Row, Col, Value) {
    	with(sheetObj) {
    		switch (ColSaveName(Col)) {
    		case "ntc_eml":
    			if (GetCellValue(Row, "chk") == "1") {
    				if (GetCellValue(Row, Col) != "" && ComIsEmailAddr(GetCellValue(Row, Col)) == false) {
    					ComShowCodeMessage("BKG40021", GetCellValue(Row, Col));
						SelectCell(Row, "ntc_eml");
						break;
		    		} 
				}
    			break;
    		}
    	}
    }
    /**
     * process Tab1 Sheet1 KewDown event<br>
     * 
     * @param  sheetObj
     * @param  Row
     * @param  Col
     * @param  Value
     * @return 
     * @author 
     */
//    function t1sheet1_OnKeyDown(sheetObj, Row, Col, Value) {
//    	sheet_KeyDown(sheetObj, Row, Col, Value);
//    }
    /**
     * process Tab2 Sheet1 KewDown event<br>
     * 
     * @param  sheetObj
     * @param  Row
     * @param  Col
     * @param  Value
     * @return 
     * @author 
     */
//    function t2sheet1_OnKeyDown(sheetObj, Row, Col, Value) {
//    	sheet_KeyDown(sheetObj, Row, Col, Value);
//    }
    /**
     * process Sheet Key down event<br>
     * @param  sheetObj 
     * @param  Row      
     * @param  Col      
     * @param  Value    
     * @return 
     */
//    function sheet_KeyDown(sheetObj, Row, Col, Value) {
//    	with(sheetObj) {
//    		switch(ColSaveName(Col)) {
//    		case "fax_no":
//    		case "ntc_eml":
//    			SetCellValue(Row, "chk",1,0);
//    			break;
//    		}
//    	}
//    }
    /**
     * process Tab1 Sheet1 Double Click event<br>
     * 
     * @param  sheetObj
     * @param  Row
     * @param  Col
     * @param  Value
     * @return 
     * @author 
     */
	function t1sheet1_OnDblClick(sheetObj, Row, Col) {
		sheet_DbClick(sheetObj, Row, Col);
	}
    /**
     * process Tab2 Sheet1 Double Click event<br>
     * 
     * @param  sheetObj  Sheet ID
     * @param      Row       Sheet Row
     * @param      Col       Sheet Col
     * @param   Value     Sheet 셀값
     * @return 
     * @author 
     */
	function t2sheet1_OnDblClick(sheetObj, Row, Col) {
		sheet_DbClick(sheetObj, Row, Col);
	}
	/**
	 * process in case of double clicking Sheet<br>
	 * @param  sheetObj 
	 * @param  Row      
	 * @param  Col      
	 * @return 
	 */
	function sheet_DbClick(sheetObj, Row, Col) {
    	with(sheetObj) {
    		switch (ColSaveName(Col)) {
    		case "hld_diff_rmk":
    			SetCellEditable(Row, Col,0);
    			ComShowMemoPad(sheetObj, Row, Col);
    			SetCellEditable(Row, Col,1);
    			break;
    		case "cust_nm":
    			if (GetRowHeight(Row) == 20) {
    				SetRowHeight(Row,0);
    			} else {
        			SetRowHeight(Row,20);
    			}
    			break;
    		}
    	}
	}
    /**
     * handling process for input validation <br>
     * 
     * @param  sheetObj
     * @param  formObj
     * @param  sAction
     * @return boolean
     */
    function validateForm(sheetObj,formObj,sAction){
        with(sheetObj) {
            switch(sAction) {
          	case IBSEARCH:
       	    	if (!ComChkValid(formObj)) return false;
              	if(ComGetObjValue(formObj.sch_tp_cd) == "ETA" && !ComBkgMonthsBetweenCheck(formObj.dt_s.value, formObj.dt_e.value, 3)) {
              		ComShowCodeMessage("BKG40013", "3");
              		ComSetFocus(formObj.dt_e);
              		return false;
              	}
          		break;
            	// Fax Send
            case IBSEARCH_ASYNC04:
            	var sCheckRow=FindCheckedRow("chk");
            	var arrRow=sCheckRow.split("|");
            	if (arrRow == "" || arrRow.length < 1) {
            		ComShowCodeMessage("BKG40018");
            		return false;
            	}
        		for (var i=0; i<arrRow.length; i++) {

        				if (GetCellValue(arrRow[i], "ntc_wd_yn") != "Y") {
    						ComShowCodeMessage("BKG40077");
    						SelectCell(arrRow[i], "bl_no");
    						return false;
    					}
        				if (GetCellValue(arrRow[i], "fax_no") == "") {
    						ComShowCodeMessage("BKG00577");
    						SelectCell(arrRow[i], "fax_no");
    						return false;
    					}
        		}
        		break;
            	// Email Send
            case IBSEARCH_ASYNC05:
            	var sCheckRow=FindCheckedRow("chk");
            	var arrRow=sCheckRow.split("|");
            	if (arrRow == "" ||arrRow.length < 1) {
            		ComShowCodeMessage("BKG40019");
            		return false;
            	}
            	for (var i=0; i<arrRow.length; i++) {
        				if (GetCellValue(arrRow[i], "ntc_wd_yn") != "Y") {
    						ComShowCodeMessage("BKG40077");
    						SelectCell(arrRow[i], "bl_no");
    						return false;
    					}
        				if (GetCellValue(arrRow[i], "ntc_eml") == "" || ComIsEmailAddr(GetCellValue(arrRow[i], "ntc_eml")) == false) {
    						ComShowCodeMessage("BKG00366");
    						SelectCell(arrRow[i], "ntc_eml");
    						return false;
    		    		} 
        		}
        		break;
          	}
        }
        return true;
    }
    /**
     * setting selected condition<br>
     * 
     * @return 
     */
    function setMandantorySearchType() {
    	with(document.form) {
    		setNotRequiredObject(vvd, dt_s, dt_e, bl_no);
    		var schVal=ComGetObjValue(sch_tp_cd);    		
        	if (schVal == "VVD") {
    			setRequiredObject(vvd);
    		} else if (schVal == "ETA") {
    			setRequiredObject(dt_s, dt_e);
        	} else if (schVal == "BL") {
    			setRequiredObject(bl_no);
    		} 
    	}
    }
    /**
     *  setting search condition
     * 
     * @param
     * @return 
     */
    function setRequiredObject() {
    	for(var i=0; i<arguments.length; i++) {
    		setRequiredMode(arguments[i], true);
    	}
    	if (arguments.length > 0) 
    		arguments[0].focus();
    }
    /**
     *  setting as no search condition<br>
     * 
     * @param
     * @return 
     */
    function setNotRequiredObject() {
    	for(var i=0; i<arguments.length; i++) {
    		setRequiredMode(arguments[i], false);
    	}
    }
    /**
     * setting Required attribute of Object<br>
     * 
     * @param  obj
     * @param  requireMode
     * @return 
     */
    function setRequiredMode(obj, requireMode) {    	
    	if (requireMode == true) {
    		obj.setAttribute("required", true);
    	} else {
    		obj.removeAttribute("required");
    	}
    }
