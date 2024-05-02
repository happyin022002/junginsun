/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0063.js
*@FileTitle  : GRI Group Commodity Guideline Select 
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
     * @
     * @author 
     */
    /**
     * @extends Pri
     * @class ESM_PRI_0063 : Business Script for ESM_PRI_0063
     */
    // common global variables
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
     * @version 2009.05.22
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
                case "btn_CheckAll":
                    sheetObject2.CheckAll("sel_chk",1);
                    break;
                case "btn_UncheckAll":
                    sheetObject2.CheckAll("sel_chk",0);
                    break;
                case "btn_OK":
                    addCheckedDetailData(sheetObject1, sheetObject2, sheetObject1.GetSelectRow());
                    if (checkedMdata.size() == 0) {
                        ComShowCodeMessage('PRI00011');
                        break;
                    }
                    var keys=checkedDdata.getKeys();
                    var master=new Array();
                    var detail=new Array();
                    for (var i=0, n=keys.length; i < n; i++) {
                        if (checkedMdata.get(keys[i]) != null) {
                            master.push(checkedMdata.get(keys[i]));
                            detail.push(checkedDdata.get(keys[i]));
                        }
                    }
                    var rtnVal=new Object();
                    rtnVal.master=master;
                    rtnVal.detail=detail;
                    ComPopUpReturnValue(rtnVal);
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
     * @version 2009.05.22
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
     * @version 2009.05.22
     */
    function loadPage() {
        try {
        	ComOpenWait(true);
            for(i=0;i<sheetObjects.length;i++){
                //Modify Environment Setting Function's name
                ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
                //Add Environment Setting Function
                ComEndConfigSheet(sheetObjects[i]);
            }
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
     * @version 2009.05.22
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      // sheet1 init
                with(sheetObj){
               
             var HeadTitle="|SEQ|||||Group Code|Description";
             var headCount=ComCountHeadTitle(HeadTitle);

             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
             var headers = [ { Text:HeadTitle, Align:"Center"} ];
             InitHeaders(headers, info);

             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                 {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"gline_seq" },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"prc_cust_tp_cd" },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"grp_cmdt_seq" },
                 {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"prc_grp_cmdt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_cmdt_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
              
             InitColumns(cols);

             SetEditable(1);
             SetWaitImageVisible(0);
             SetSheetHeight(160);
                      }


                break;
            case 2:      // sheet2 init
                with(sheetObj){
              
             var HeadTitle="|Sel.|SEQ|||||||Code|Description";
             var headCount=ComCountHeadTitle(HeadTitle);

             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
             var headers = [ { Text:HeadTitle, Align:"Center"} ];
             InitHeaders(headers, info);

             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                 {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"sel_chk" },
                 {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"gline_seq" },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"prc_cust_tp_cd" },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"grp_cmdt_seq" },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"grp_cmdt_dtl_seq" },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_tp_cd" },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"loc_des",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
              
             InitColumns(cols);

             SetEditable(1);
             SetWaitImageVisible(0);
             SetSheetHeight(160);
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
     * @version 2009.05.22
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH: // retrieving
                if (validateForm(sheetObj,formObj,sAction)) {
                    if (sheetObj.id == "sheet1") {
                        formObj.f_cmd.value=SEARCH01;
                        sheetObj.DoSearch("ESM_PRI_0063GS.do", FormQueryString(formObj) );
                    }else if (sheetObj.id == "sheet2") {
                        formObj.f_cmd.value=SEARCH02;
                        sheetObj.DoSearch("ESM_PRI_0063GS.do", FormQueryString(formObj) );
                    }
                }
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
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {form} formObj mandatory html form object
     * @param {int} sAction mandatory,Constant Variable
     * @returns bool <br>
     *          true  : valid<br>
     *          false : inValid
     * @author 
     * @version 2009.05.22
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }
        return true;
    }
    /**
     * Calling function in case of Onclick event <br>
     * Highlighting selected row<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col mandatory Onclick ,Cell's Column Index
     * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.05.19
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {
            try {
                if (OldRow != 0) {
                    addCheckedDetailData(sheetObj, sheetObjects[1], OldRow);
                }
                var formObj=document.form;
                formObj.gline_seq.value=sheetObj.GetCellValue(NewRow, "gline_seq");
                formObj.grp_cmdt_seq.value=sheetObj.GetCellValue(NewRow, "grp_cmdt_seq");
                doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
            } catch(e) {
                if( e == "[object Error]") {
                    ComShowMessage(OBJECT_ERROR);
                } else {
                    ComShowMessage(e.message);
                }
            } 
        }
    }
    /**
     * Calling Function in case of OnSearchEnd event <br>
     * <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {string} errMsg Mandatory Message
     * @return void
     * @author 
     * @version 2009.05.19
     */
    function sheet2_OnSearchEnd(sheetObj, errMsg){
        var sheetObj1=sheetObjects[0];
        var row=sheetObj1.GetSelectRow();
        var key=sheetObj1.GetCellValue(row, "svc_scp_cd")+","+sheetObj1.GetCellValue(row, "gline_seq")+","+sheetObj1.GetCellValue(row, "prc_cust_tp_cd")+","+sheetObj1.GetCellValue(row, "grp_cmdt_seq");
        var val=checkedDdata.get(key);
        if (val != null && val.length > 0) {
            for (var i=0, n=val.length; i < n; i++) {
                if (val[i] == "") {
                    continue;
                }
                for (var j=1 , k=sheetObj.RowCount(); j <= k; j++) {
                	if (sheetObj.GetCellValue(j, "grp_cmdt_dtl_seq") == val[i].grp_cmdt_dtl_seq) {
                        sheetObj.SetCellValue(j, "sel_chk",1);
                    }
                }
            }
        }
    }
    var checkedMdata=new HashMap();
    var checkedDdata=new HashMap();
    var checkedData=new HashMap();
    /**
     * Save Detail Grid's selected Data to HashMap. <br>
     * when the same key exists, overwrite it. <br>
     * <br><b>Example :</b>
     * <pre>
     *     addCheckedDetailData(sheetObjects[0], sheetObjects[1], 1);
     * </pre>
     * @param {ibsheet} msheetObj Mandatory HTML Tag(Object). Master Sheet
     * @param {ibsheet} dsheetObj Mandatory HTML Tag(Object). Detail Sheet
     * @param {int} OldRow Mandatory Master Grid's Row Index
     * @return void
     * @author 
     * @version 2009.05.22
     */
    function addCheckedDetailData(msheetObj, dsheetObj, OldRow) {
        var formObj=document.form;
        var chkd=dsheetObj.FindCheckedRow("sel_chk");
        var key=msheetObj.GetCellValue(OldRow, "svc_scp_cd")+","+msheetObj.GetCellValue(OldRow, "gline_seq")+","+msheetObj.GetCellValue(OldRow, "prc_cust_tp_cd")+","+msheetObj.GetCellValue(OldRow, "grp_cmdt_seq");
        if (chkd != "") {
            var arr=chkd.split("|");
            var vals=new StringBuffer();
            var valArr=new Array();
            var mobj=new Object();
            var dobj=new Object();
            mobj.prop_no=formObj.prop_no.value;
            mobj.amdt_seq=formObj.amdt_seq.value;
            mobj.svc_scp_cd=formObj.svc_scp_cd.value;
            mobj.gline_seq=msheetObj.GetCellValue(OldRow, "gline_seq");
            mobj.prc_cust_tp_cd=msheetObj.GetCellValue(OldRow, "prc_cust_tp_cd");
            mobj.grp_cmdt_seq=msheetObj.GetCellValue(OldRow, "grp_cmdt_seq");
            mobj.prc_grp_cmdt_cd=msheetObj.GetCellValue(OldRow, "prc_grp_cmdt_cd");
            mobj.prc_grp_cmdt_desc=msheetObj.GetCellValue(OldRow, "prc_grp_cmdt_desc");
            checkedMdata.put(key, mobj);
            for (var i=0, n=arr.length; i < n; i++) {
                if (arr[i] == "") {
                    continue;
                }
                dobj=new Object();
                dobj.prop_no=formObj.prop_no.value;
                dobj.amdt_seq=formObj.amdt_seq.value;
                dobj.svc_scp_cd=formObj.svc_scp_cd.value;
				dobj.gline_seq=msheetObj.GetCellValue(OldRow, "gline_seq");
				dobj.prc_cust_tp_cd=msheetObj.GetCellValue(OldRow, "prc_cust_tp_cd");
				dobj.grp_cmdt_seq=msheetObj.GetCellValue(OldRow, "grp_cmdt_seq");
				dobj.prc_cmdt_tp_cd=dsheetObj.GetCellValue(Number(arr[i]), "prc_cmdt_tp_cd");
				dobj.prc_cmdt_def_cd=dsheetObj.GetCellValue(Number(arr[i]), "prc_cmdt_def_cd");
				dobj.grp_cmdt_dtl_seq=dsheetObj.GetCellValue(Number(arr[i]), "grp_cmdt_dtl_seq");
                valArr.push(dobj);
            }
            checkedDdata.put(key, valArr);
        } else {
            checkedMdata.remove(key);
            checkedDdata.remove(key);
        }
    }
    /**
     * HashMap Object Creator<br>
     * Create the same object, like Hashmap in Java.<br>
     * <br><b>Example :</b>
     * <pre>
     *     hm = new HashMap();      // creation
     *     hm.put(key, value);      // Input
     *     val = hm.get(key);       // Output
     *     hm.remove(key);          // remove
     * </pre>
     * @return void
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
