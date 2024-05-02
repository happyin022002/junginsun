/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1064.jsp
*@FileTitle  : Pick up Upload
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event  */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     */
    function processButtonClick(){
        var sheetObj=sheetObjects[0];
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
            case "btn_FileImport":
            	doActionIBSheet(sheetObjects[1],formObject,IBSEARCH_ASYNC01);
            	break;
            case "btn_New":
            	doActionIBSheet(sheetObj,formObject,IBRESET);
            	break;
            case "btn_DownExcel":
            	doActionIBSheet(sheetObj,formObject,IBDOWNEXCEL);
            	break;
            case "btn_Verify":
            	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC02);
            	break;
            case "btn_Close":
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
     * registering IBSheet Object as list<br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * 
     * @param {IBSheet} sheet_obj
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen <br>
     * 
     */
    function loadPage() {
        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initForm();
    }
    /**
     * initialize Form data. set initial value after open screen or data delete
     */
    function initForm() {
 		with(document.form) {
 			//file_name.value="";
 		    ComSetObjValue(rail_cd, "BN");
 		}
    }
    /**
     * setting sheet initial values and header<br>
     * adding case as numbers of counting sheets <br>
     * 
     * @param {ibsheet} sheetObj
     * @param {number}  sheetNo
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
        case "sheet1":
            with (sheetObj) {
            
            var HeadTitle1="|Sel.|Seq.|Container|B/L No.|Pick up No.|AVL DT|FRE DT|PICK YD|Remark(s)||CNTR USE||BL_CHCK||YD_CHECK||AVL_CHECK||FRE_CHECK";
            var headCount=ComCountHeadTitle(HeadTitle1);            
            SetAutoRowHeight(0);

            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                   {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
                   {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pkup_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pkup_aval_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lst_free_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pkup_yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
                   {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"remark",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no_chk_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no_chk_msg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bl_no_chk_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no_chk_msg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pkup_yd_cd_chk_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pkup_yd_cd_chk_msg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pkup_aval_dt_chk_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pkup_aval_dt_chk_msg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lst_free_dt_chk_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"lst_free_dt_chk_msg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
             
            InitColumns(cols);

            SetEditable(1);
            SetColProperty("pkup_aval_dt", {Format:"####-##-##"} );
            SetColProperty("lst_free_dt", {Format:"####-##-##"} );
            SetSheetHeight(350);

           }
        break;
        case "sheet2":
            with (sheetObj) {
            var HeadTitle1="1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|";
            var headCount=ComCountHeadTitle(HeadTitle1);

            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

            var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Text",     Hidden:0,  Width:270,  Align:"Left",    ColMerge:0,   SaveName:"col1" },
                   {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"col2" },
                   {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"col3" },
                   {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"col4" },
                   {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"col5" },
                   {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"col6" },
                   {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"col7" },
                   {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"col8" },
                   {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"col9" },
                   {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"col10" },
                   {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"col11" },
                   {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"col12" },
                   {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"col13" },
                   {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"col14" },
                   {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"col15" },
                   {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"col16" },
                   {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"col17" },
                   {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"col18" },
                   {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"col19" },
                   {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"col20" },
                   {Type:"Status",    Hidden:0, Width:3,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
             
            InitColumns(cols);

            SetEditable(1);
            SetCountPosition(0);
            SetVisible(false);

           }
        break;
        case "sheet3":
            with (sheetObj) {
            var HeadTitle1="Chk|Bkg No|B/L No.|CNTR PRT FLG|Container|TP|AVL DT|FRE DT|Pick up No.|PICK YD|RTN YD|F|O|C|CRE DT|CRE OFC|CRE USER|SN|POD|C LOC|DEL|Filer|TERM|ROUTE GUIDE|RAIL MOVE|TRUCK MOVE|ETA DT||||VSL|DEP DT|ARR DT|";
            var headCount=ComCountHeadTitle(HeadTitle1);

            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk_yn",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_prt_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pkup_aval_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"lst_free_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pkup_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pkup_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rtn_yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
                   {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"frt_clt_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"obl_rdem_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cstms_clr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pkup_cre_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pkup_cre_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"pkup_ntc_snd_knt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ibd_trsp_hub_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"usa_cstms_file_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"de_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"route_guide",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rail_move",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"truck_move",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"ata_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rail_dep_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rail_arr_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
             
            InitColumns(cols);

            SetEditable(1);
            SetColProperty("pkup_aval_dt", {Format:"####-##-####:##"} );
            SetColProperty("lst_free_dt", {Format:"####-##-####:##"} );
            SetColProperty("pkup_cre_dt", {Format:"####-##-####:##:##"} );
            SetColProperty("ata_dt", {Format:"####-##-####:##:##"} );
            SetColProperty("rail_dep_dt", {Format:"####-##-####:##:##"} );
            SetColProperty("rail_arr_dt", {Format:"####-##-####:##:##"} );
            SetVisible(false);

            }
        	break;
        }
    }
    
    
    function sheet2_OnLoadExcel(sheetObj , result){
    	if(result){
    		var formObj=document.form;
    		 if(validateForm(sheetObj,formObj,"IBSEARCH_ASYNC01") == false) {
                 ComOpenWait(false);
             	break;
             }
             if (sheetObj.RowCount()< 1) {
                 ComOpenWait(false);
             	break;
             }
             formObj.f_cmd.value=COMMAND01;
             var sParam=FormQueryString(formObj);
             var sParamSheet1=sheetObjects[1].GetSaveString();
             if (sParamSheet1 != "") {
                 sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
             }
             var sXml=sheetObj.GetSearchData("ESM_BKG_1064GS.do", sParam);
 			sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
 			sheetObjects[0].ColumnSort("bl_no|cntr_no");
 			fncRemoveFileInfoDup();
    	}
    	ComOpenWait(false);
    }
    
    function sheet2_OnLoadText(sheetObj , result) { 
    	if(result){
    		var formObj=document.form;
    		if (type == "CN") funcWrapFileData();
    		
    		if(validateForm(sheetObj,formObj,"IBSEARCH_ASYNC01") == false) {
                 ComOpenWait(false);
             	break;
             }
             if (sheetObj.RowCount()< 1) {
                 ComOpenWait(false);
             	break;
             }
             formObj.f_cmd.value=COMMAND01;
             var sParam=FormQueryString(formObj);
             var sParamSheet1=sheetObjects[1].GetSaveString();
             if (sParamSheet1 != "") {
                 sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
             }
             var sXml=sheetObj.GetSearchData("ESM_BKG_1064GS.do", sParam);
 			sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
 			sheetObjects[0].ColumnSort("bl_no|cntr_no");
 			fncRemoveFileInfoDup();
    	}
    	ComOpenWait(false);
    	
    }

    
    /**
     * handling sheet process <br>
     * 
     * @param {ibsheet} sheetObj
     * @param {object}  formObj
     * @param {string}  sAction 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
        // File Import
        case IBSEARCH_ASYNC01:
        	var type=ComGetObjValue(formObj.rail_cd);
        	var file="";
/*    	    if (type == "CY" || type == "NS") {
    	    	file=sheetObj.ShowDialog("", "", "", "*.xls|*.xls|*.xlsx|*xlsx");	
    	    } else {
    	    	file=sheetObj.ShowDialog("", "", "", "*.xls|*.xls|*.xlsx|*xlsx");
//    	    	file=sheetObj.ShowDialog("", "", "", "*.txt");	
    	    }
        	if (file == "" || file == "<USER_CANCEL>") break;
*/            ComOpenWait(true);
        	for (var i=0; i<sheetObjects.length; i++) {
            	sheetObjects[i].RemoveAll();
        	}
       		//formObj.file_name.value=file;
    	    if (type == "CY" || type == "NS") {
    	    	sheetObj.LoadExcel({ Mode:"NoHeader",WorkSheetNo:"1", FileExt:"xls|xlsx"});
    	    } else {
    	    	sheetObj.LoadText({ Mode:"NoHeader",Deli:"",FileExt:"txt" })
    	    	
    	    }
    	    ComOpenWait(false);
    	   /* // load parsing result after send file content to server
            if(validateForm(sheetObj,formObj,sAction) == false) {
                ComOpenWait(false);
            	break;
            }
            if (sheetObj.RowCount()< 1) {
                ComOpenWait(false);
            	break;
            }
            formObj.f_cmd.value=COMMAND01;
            var sParam=FormQueryString(formObj);
            var sParamSheet1=sheetObjects[1].GetSaveString();
            if (sParamSheet1 != "") {
                sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
            }
            var sXml=sheetObj.GetSearchData("ESM_BKG_1064GS.do", sParam);
			sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
			sheetObjects[0].ColumnSort("bl_no|cntr_no");
			fncRemoveFileInfoDup();
			ComOpenWait(false);*/
            break;
        case IBSEARCH_ASYNC02:
        	if (sheetObj.RowCount()== 0) {
        		ComShowCodeMessage("BKG40055");
        		break;
        	}
            if (sheetObj.CheckedRows("chk")  < 1) {
        		ComShowCodeMessage("BKG00249");
        		break;
            }
            ComOpenWait(true);
            formObj.f_cmd.value=COMMAND02;
            var sParam=FormQueryString(formObj);
            var sParamSheet1=sheetObj.GetSaveString(true);
            if (sParamSheet1 != "") {
                sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
            }
            var sXml=sheetObj.GetSearchData("ESM_BKG_1064GS.do", sParam);
            var arrXml=sXml.split("|$$|");
            sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
            sheetObjects[2].LoadSearchData(arrXml[1],{Sync:1} );
            fncVerifyAfter();
            ComOpenWait(false);
            if (sheetObjects[0].RowCount()== 0) {
            	ComClosePopup(); 
            }
        	break;
        	// New
        case IBRESET:
        	if (ComIsModifiedSheets(sheetObj) == true) {
            	if (ComShowCodeMessage("BKG00254") == true) {
            		doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC02);
                	break;
            	}
        	}
        	for (var i=0; i<sheetObjects.length; i++) {
            	sheetObjects[i].RemoveAll();
        	}
        	initForm();
        	break;
        	// Dow Excel
        case IBDOWNEXCEL:
        	if(sheetObj.RowCount() < 1){//no data
        		ComShowCodeMessage("COM132501");
        	}else{
        		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
        	}
        	
        	break;
        }
    }
    /**
     *  add seperator email contents front and back. after File upload (only Text file) <br>
     * 
     */
    function funcWrapFileData() {
    	var sheetObj=sheetObjects[1];
    	var iRow=0;
    	var val="";
    	with(sheetObj) {
        	for (var i=0; i<RowCount(); i++) {
        		iRow=i+1;
        		val=GetCellValue(iRow, "col1");
        		SetCellValue(iRow, "col1","[" + val + "]",0);
        	}
    	}
    }    
    /**
     * handling delete duplicate data (compare Container No.) <br>
     */
    function fncRemoveFileInfoDup() {
    	with(sheetObjects[0]) {
			if (ColValueDup("bl_no|cntr_no") > 0) {
				var len=RowCount();
				for (var i=0; i<len; i++) {
					for (var j=len-1; j>i; j--) {
						if ( (GetCellValue(i+1, "bl_no") == GetCellValue(j+1, "bl_no")) &&
								(GetCellValue(i+1, "cntr_no") == GetCellValue(j+1, "cntr_no")) )
						{
							RowDelete(j+1, false);
						}
					}
					len=RowCount();
				}
			}
    	}
    }
    /**
     * call after Verify complete
     */
    function fncVerifyAfter() {
		with(sheetObjects[0]) {
			for(var i=RowCount(); i>0; i--) {
				if (GetCellValue(i, "chk") == "1" &&
						GetCellValue(i, "cntr_no_chk_flg")      == "Y" &&
						GetCellValue(i, "bl_no_chk_flg")        == "Y" &&
						GetCellValue(i, "pkup_aval_dt_chk_flg") == "Y" &&
						GetCellValue(i, "lst_free_dt_chk_flg")  == "Y" &&
						GetCellValue(i, "pkup_yd_cd_chk_flg")   == "Y")
				{
					RowDelete(i, false);
				}
			}
		}
    	dialogArguments.fncSetPkupNo(fncGetPkupNo(sheetObjects[2]));     
    }
    /**
     * move valid data to main page
     * 
     * @param {ibsheet}
     */
    function fncGetPkupNo(sheetObj) {
    	var resultList=new Array();
    	var obj=null;
    	var cnt=0;
    	with (sheetObj) {	
    		var idx=0;
        	for (var i=0; i<RowCount(); i++) {
    			idx=i+1;
				obj=new Object(); 
				obj.chk=GetCellValue(idx, "chk_yn")=="Y"?"1":"0";
				obj.bkg_no=GetCellValue(idx, "bkg_no");
				obj.bl_no=GetCellValue(idx, "bl_no");
				obj.cntr_prt_flg=GetCellValue(idx, "cntr_prt_flg");
				obj.cntr_no=GetCellValue(idx, "cntr_no");
				obj.cntr_tpsz_cd=GetCellValue(idx, "cntr_tpsz_cd");
				obj.pkup_aval_dt=GetCellValue(idx, "pkup_aval_dt");
				obj.lst_free_dt=GetCellValue(idx, "lst_free_dt");
				obj.pkup_no=GetCellValue(idx, "pkup_no");
				obj.pkup_yd_cd=GetCellValue(idx, "pkup_yd_cd");
				obj.rtn_yd_cd=GetCellValue(idx, "rtn_yd_cd");
				obj.frt_clt_flg=GetCellValue(idx, "frt_clt_flg");
				obj.obl_rdem_flg=GetCellValue(idx, "obl_rdem_flg");
				obj.cstms_clr_cd=GetCellValue(idx, "cstms_clr_cd");
				obj.pkup_cre_dt=GetCellValue(idx, "pkup_cre_dt");
				obj.ofc_cd=GetCellValue(idx, "ofc_cd");
				obj.pkup_cre_usr_id=GetCellValue(idx, "pkup_cre_usr_id");
				obj.pkup_ntc_snd_knt=GetCellValue(idx, "pkup_ntc_snd_knt");
				obj.pod_cd=GetCellValue(idx, "pod_cd");
				obj.ibd_trsp_hub_cd=GetCellValue(idx, "ibd_trsp_hub_cd");
				obj.del_cd=GetCellValue(idx, "del_cd");
				obj.usa_cstms_file_cd=GetCellValue(idx, "usa_cstms_file_cd");
				obj.de_term_cd=GetCellValue(idx, "de_term_cd");
				obj.route_guide=GetCellValue(idx, "route_guide");
				obj.rail_move=GetCellValue(idx, "rail_move");
				obj.truck_move=GetCellValue(idx, "truck_move");
				obj.ata_dt=GetCellValue(idx, "ata_dt");
				obj.vsl_cd=GetCellValue(idx, "vsl_cd");
				obj.skd_voy_no=GetCellValue(idx, "skd_voy_no");
				obj.skd_dir_cd=GetCellValue(idx, "skd_dir_cd");
				obj.vvd=GetCellValue(idx, "vvd");
				obj.rail_dep_dt=GetCellValue(idx, "rail_dep_dt");
				obj.rail_arr_dt=GetCellValue(idx, "rail_arr_dt");
				resultList[cnt++]=obj;
    		}
    	}
    	return resultList;
    }
    /**
    * handling Sheet1 Click event<br>
    * 
    * @param {ibsheet} sheetObj
    * @param {int}     Row 
    * @param {int}     Col  
    * @author 
    */
    function sheet1_OnClick(sheetObj, row, col) {
        switch(sheetObj.ColSaveName(col)) {
        case "remark":
        	if (sheetObj.GetCellValue(row, col) != "") {
            	ComShowMemoPad(sheetObj, row, col, true, 300, 100, 200 );
            }
        	break;
        }
    }
    /**
     * handling process for input validation <br>
     * 
     * @param {ibsheet} sheetObj
     * @param {object}  formObj
     * @param {string}  sAction 
     * @return boolean 
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }
        return true;
    }
