/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0074.jsp
*@FileTitle  : S/C Boiler Plate Creation - Excel Import
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
=========================================================*/
    // Common Global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var sheet1;
    var errFlg=false; //Setting flag value
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
     * @version 2009.12.01
     */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            
            switch(srcName) {
                case "btn_new":
                    sheetObject1.RemoveAll();
                    ComBtnDisable("btn_check");
                    break;
                case "btn_openfile":
                    sheetObject1.SetWaitImageVisible(1);
                    sheetObject1.LoadExcel({ Mode:"HeaderMatch"});
                    sheetObject1.SetEditable(1);
                    ComBtnEnable("btn_check");
                    ComBtnDisable("btn_save");
                    break;
                case "btn_save":
                	if(validateForm(sheetObject1, formObject, IBSAVE)){
                        ComOpenWait(true);
                        doActionIBSheet(sheetObject1, formObject, IBSAVE);
                        ComOpenWait(false);
                    }
                    break;
                case "btn_check":
                	ComOpenWait(true);
                    if(validateForm(sheetObject1, formObject, IBSEARCH)) {
                        doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                    }
                    ComOpenWait(false);
                    break;
                case "btn_close":
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
     * registering IBSheet Object as list <br>
     * adding process for list in case of needing batch processing with other items  <br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj Mandatory IBSheet Object
     * @return N/A
     * @author 
     * @version 2009.12.01
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
     * @return N/A
     * @author 
     * @version 2009.12.01
     */
    function loadPage() {
    	
    	if (!opener) opener = window.dialogArguments;
    	if (!opener) opener = window.opener;
    	if (!opener) opener = parent;
   	 
        sheet1=sheetObjects[0];
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        ComBtnDisable("btn_check");
        ComBtnDisable("btn_save");
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
     * @version 2009.12.01
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
              
             var HeadTitle="|Seq.|Title|Contents|prop_no|amdt_seq|blpl_seq|prc_prog_sts_cd|src_info_cd|dp_seq|blpl_tit_nm|n1st_cmnc_amdt_seq|blpl_ctnt_seq|blpl_ctnt|dp_seq2";
             var headCount=ComCountHeadTitle(HeadTitle);

             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
             var headers = [ { Text:HeadTitle, Align:"Center"} ];
             InitHeaders(headers, info);

             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"Title",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"Content",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"prop_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"blpl_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"dp_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"blpl_tit_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"blpl_ctnt_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"blpl_ctnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"dp_seq2",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
              
             InitColumns(cols);

             SetEditable(1);
             SetCountPosition(0);
             SetSheetHeight(452);
                      }


                break;
            case "sheet2":
                with(sheetObj){
               
             var HeadTitle="|Seq.|Title|Content|prop_no|amdt_seq|blpl_seq|prc_prog_sts_cd|src_info_cd|n1st_cmnc_amdt_seq|dp_seq|blpl_tit_nm";
             var headCount=ComCountHeadTitle(HeadTitle);

             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
             var headers = [ { Text:HeadTitle, Align:"Center"} ];
             InitHeaders(headers, info);

             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"Title",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"Content",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"prop_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"blpl_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"dp_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"blpl_tit_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
              
             InitColumns(cols);

             SetEditable(1);
             SetCountPosition(0);
             SetSheetHeight(100);
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
     * @param {int} sAction Mandatory, ,process constant variable
     * @return N/A
     * @author 
     * @version 2009.12.01
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSAVE:     
                formObj.f_cmd.value=MULTI;
                var sParam=FormQueryString(formObj);
                var sParam2="";
                var sParamSheet1=sheetObjects[0].GetSaveString();
                var bBtm="";
                var bBs="";
                if (sParamSheet1 != "") {
                    for(i=1; i<=sheetObjects[0].RowCount();i++){
						if( bBtm != sheetObjects[0].GetCellValue(i,"blpl_tit_nm")
						&& bBs != sheetObjects[0].GetCellValue(i,"blpl_seq") ){
						sParam += "&sheet1_ibflag="+sheetObjects[0].GetRowStatus(i);
						sParam += "&sheet1_prop_no="+sheetObjects[0].GetCellValue(i,"prop_no");
						sParam += "&sheet1_amdt_seq="+sheetObjects[0].GetCellValue(i,"amdt_seq");
						sParam += "&sheet1_blpl_seq="+sheetObjects[0].GetCellValue(i,"blpl_seq");
						sParam += "&sheet1_prc_prog_sts_cd="+sheetObjects[0].GetCellValue(i,"prc_prog_sts_cd");
						sParam += "&sheet1_src_info_cd="+sheetObjects[0].GetCellValue(i,"src_info_cd");
						sParam += "&sheet1_dp_seq="+sheetObjects[0].GetCellValue(i,"dp_seq");
						sParam += "&sheet1_blpl_tit_nm="+encodeURIComponent(sheetObjects[0].GetCellValue(i,"blpl_tit_nm"));
						sParam += "&sheet1_n1st_cmnc_amdt_seq="+sheetObjects[0].GetCellValue(i,"n1st_cmnc_amdt_seq");
						                        }
						sParam2 += "&sheet2_ibflag="+sheetObjects[0].GetRowStatus(i);
						sParam2 += "&sheet2_prop_no="+sheetObjects[0].GetCellValue(i,"prop_no");
						sParam2 += "&sheet2_amdt_seq="+sheetObjects[0].GetCellValue(i,"amdt_seq");
						sParam2 += "&sheet2_blpl_seq="+sheetObjects[0].GetCellValue(i,"blpl_seq");
						sParam2 += "&sheet2_prc_prog_sts_cd="+sheetObjects[0].GetCellValue(i,"prc_prog_sts_cd");
						sParam2 += "&sheet2_src_info_cd="+sheetObjects[0].GetCellValue(i,"src_info_cd");
						sParam2 += "&sheet2_n1st_cmnc_amdt_seq="+sheetObjects[0].GetCellValue(i,"n1st_cmnc_amdt_seq");
						sParam2 += "&sheet2_blpl_ctnt_seq="+sheetObjects[0].GetCellValue(i,"blpl_ctnt_seq");
						sParam2 += "&sheet2_blpl_ctnt="+encodeURIComponent(sheetObjects[0].GetCellValue(i,"blpl_ctnt"));
						sParam2 += "&sheet2_dp_seq="+sheetObjects[0].GetCellValue(i,"dp_seq2");
						bBtm=sheetObjects[0].GetCellValue(i,"blpl_tit_nm");
						bBs=sheetObjects[0].GetCellValue(i,"blpl_seq");
                    }
                }
                //merge data
                sParam=sParam + sParam2;
                 var sXml=sheetObj.GetSaveData("ESM_PRI_0074GS.do", sParam);
                 sheetObjects[0].LoadSaveData(sXml);
                break;
        }
    }
    /**
     * sheet1_OnSaveEnd event handler <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {string} ErrMsg : 
     * @return N/A
     * @see #
     * @author 
     * @version 2009.12.07
     */
    function sheet1_OnSaveEnd(sheetObj, Code)  {
        if (Code >= 0) {
            ComPriSaveCompleted();
            ComPopUpReturnValue("Y");
        } 
    }
    
    /**
     * sheet1_OnLoadExcel event handler <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {string} code : 
     * @param  {string} ErrMsg : 
     * @return N/A
     * @see #
     * @author 
     * @version 2015.06.30
     */
    function sheet1_OnLoadExcel(sheetObj, result, code, msg){
		if(isExceedMaxRow(msg))return;
	}
    
    
    /**
     * handling process for input validation <br>
     * <br>
     * <b>Example :</b>
     * 
     * <pre>
     * validateForm(sheetObj, document.form, sAction)
     * </pre>
     * 
     * @param {ibsheet} sheetObj Mandatory HTML TAG(Object) Object
     * @param (object) formObj Mandatory Form Object
     * @param (string) sAction Mandatory
     * @return N/A
     * @author 
     * @version 2009.12.01
     */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
            case IBSEARCH:
                // Setting error cell color
                var color="#FF0000"; // red
                // chkecing error data
                var check=0;
                // previous title
                var bTitleNm="";
                // MAX blplSeq
                var mBlplSeq=parseInt(formObj.blplSeq.value, 10);
                // MAX blplSeq
                var mDpSeq=parseInt(formObj.dpSeq.value, 10);
                // blpl_seq
                var blplSeq=1;
                // dp_seq
                var dpSeq=1;
                var dpSeq2=1;
                // blpl_ctnt_seq
                var blplCtntSeq=1;
                if (!sheetObjects[0].IsDataModified()) {
                    ComShowCodeMessage("PRI00312");
                    return false;
                }
                // default : gray
                for ( var i=0; i < sheetObj.RowCount(); i++) {
                    sheetObj.SetRowBackColor(i + 1,"#FFFFFF");
                }
                clearTooltip();
                for ( var i=0; i < sheetObj.RowCount(); i++) {
                    // setting prop_no 
                    sheetObj.SetCellValue(i + 1, "prop_no",formObj.propNo.value,0);
                    // setting amdt_seq 
                    sheetObj.SetCellValue(i + 1, "amdt_seq",formObj.amdtSeq.value,0);
                    if (sheetObj.GetCellValue(i + 1, "Title") == "") {
                        sheetObj.SetCellBackColor(i + 1, "Title",color);
                        check++;
                    }
                    // setting title name
                    sheetObj.SetCellValue(i + 1, "blpl_tit_nm",sheetObj.GetCellValue(i + 1, "Title"),0);
                    if (sheetObj.GetCellValue(i + 1, "Content") == "") {
                        sheetObj.SetCellBackColor(i + 1, "Content",color);
                        check++;
                    }
                    // setting contents name
                    sheetObj.SetCellValue(i+1, "blpl_ctnt",sheetObj.GetCellValue(i + 1, "Content"),0);
                    if (bTitleNm == "" && blplSeq == 1) {
                    	bTitleNm=sheetObj.GetCellValue(i + 1, "Title");
                        blplSeq=blplSeq + mBlplSeq;
                        dpSeq=dpSeq + mDpSeq;
                    } else if (bTitleNm != "") {
                    	if (bTitleNm != sheetObj.GetCellValue(i + 1, "Title")) {
                            blplSeq=blplSeq + 1;
                            dpSeq=dpSeq + 1;
                            blplCtntSeq=1;
                            dpSeq2=1;
                    	} else if (bTitleNm == sheetObj.GetCellValue(i + 1, "Title")) {
                            blplCtntSeq++;
                            dpSeq2++;
                        }
                    }
                    // blpl_seq 
                    sheetObj.SetCellValue(i + 1, "blpl_seq",blplSeq,0);
                    // blpl_ctnt_seq 
                    sheetObj.SetCellValue(i + 1, "blpl_ctnt_seq",blplCtntSeq,0);
                    // previous title
                    bTitleNm=sheetObj.GetCellValue(i + 1, "Title");
                    // prc_prog_sts_cd
                    sheetObj.SetCellValue(i + 1, "prc_prog_sts_cd","I",0);
                    // src_info_cd
                    sheetObj.SetCellValue(i + 1, "src_info_cd","NW",0);
                    // dp_seq
                    sheetObj.SetCellValue(i + 1, "dp_seq",dpSeq,0);
                    sheetObj.SetCellValue(i + 1, "dp_seq2",dpSeq2,0);
                    // n1st_cmnc_dt 세팅
                    sheetObj.SetCellValue(i + 1, "n1st_cmnc_amdt_seq",formObj.amdtSeq.value,0);
                }
                if (check > 0) {
                    errFlg=true;
                    ComBtnDisable("btn_save");
                    return false;
                } else {
                    errFlg=false;
                    // readonly for all cell
                    sheetObj.SetEditable(0);
                    ComBtnEnable("btn_check");
                    ComBtnEnable("btn_save");
                }
                break;
            case IBSAVE: // 
                var check=0;
                var check2=0;
                if (formObj.propNo.value == "" || formObj.amdtSeq.value == "") {
                    ComShowCodeMessage('PRI01055');
                    check++;
                }
                for ( var i=0; i < sheetObj.RowCount(); i++) {
                	if (sheetObj.GetCellValue(i + 1, "blpl_seq") == "") {
                        check2++;
                    }
                }
                if (check > 0) {
                    ComBtnDisable("btn_save");
                    return false;
                } else if (check2 > 0) {
                    ComShowCodeMessage('PRI01058');
                    ComBtnDisable("btn_save");
                    return false;
                } else {
                    // readonly for all cell
                    sheetObj.SetEditable(0);
                    ComBtnEnable("btn_save");
                }
                break;
        }
        return true;
    }
    /**
     * Onkeyup event for sheet1 <br>
     * <br>
     * <b>Example :</b>
     * 
     * <pre>
     * </pre>
     * 
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {Long} Row Mandatory
     * @param {Long} Col Mandatory
     * @param {Integer} KeyCode Mandatory
     * @param {Integer} Shift Mandatory Shift: 1, Ctrl: 2, other : 0
     * @return N/A
     * @author 
     * @version 2009.12.22
     */
    function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
        if (errFlg && KeyCode == 9) {
            while (true) {
                if (Col > sheetObj.LastCol()) {
                    Row++;
                    Col=1;
                }
                if (Row > sheetObj.LastRow()) {
                    Row=sheetObj.HeaderRows();
                }
                var sVal = sheetObj.GetCellBackColor(Row, Col).toUpperCase();
				if (sVal == "#FF0000") {
                    sheetObj.SelectCell(Row, Col, true);
                    break;
                }
                Col++;
            }
        }
    }
    
    function clearTooltip() {
    	var sheetObj=sheetObjects[0];
    	if(sheetObj.RowCount() == 0) return;
    	
    	var eCol=sheetObj.LastCol();
    	var sRow=sheetObj.HeaderRows();
    	var eRow=sheetObj.LastRow();
    	var j=0;
        for (var i = sRow; i <= eRow; i++) {
            for (j=0 ; j <= eCol ; j++) {
                if (sheetObj.GetCellBackColor(i, j).toUpperCase() == "#FF0000") {
                    sheetObj.SetCellBackColor(i, j, sheetObj.GetEditableColor());
                }
            }
        }
    }
