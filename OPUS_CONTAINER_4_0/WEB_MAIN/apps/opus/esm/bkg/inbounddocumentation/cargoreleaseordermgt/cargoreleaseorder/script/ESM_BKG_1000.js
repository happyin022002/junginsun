/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1000
*@FileTitle  : Attorney Register
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/15
=========================================================*/
    var sheetObjects=new Array();
    var sheetCnt=0;
    document.onclick=processButtonClick;
    function processButtonClick(){
            var sheetObject1=sheetObjects[0];
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn2_Row_Add":
                    doActionIBSheet(sheetObject1,formObject,IBINSERT);
                    break;
                case "btn2_Row_Delete":
                    if(sheetObject1.FindCheckedRow("sheet1_del_chk") ==''){
                        ComShowCodeMessage("BKG00546");
                        return;
                    }
                    var cnt=0;
                    for (var i=1; i<=sheetObject1.RowCount(); i++) {
                    	if( sheetObject1.GetCellValue(i, 'sheet1_child_record') > 0 && sheetObject1.GetCellValue(i, "sheet1_del_chk") == 1) {
                            cnt ++;
                        }
                    }
                    if(cnt > 0){
                        ComShowCodeMessage('BKG00795');
                        cnt=0;
                        return;
                    }
                    ComRowHideDelete(sheetObject1,"sheet1_del_chk");
                    break;
                case "btn1_Retrieve":
                    //check if the grid is changed
                    if(sheetObject1.IsDataModified()){
                        if(ComShowCodeConfirm("BKG00824")){
                            doActionIBSheet(sheetObject1,formObject,IBSAVE);
                            break;
                        }else{
                            doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                            break;
                        }
                    }else{
                        doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                        break;
                    }
                case "btn1_Save":
                    doActionIBSheet(sheetObject1,formObject,IBSAVE);
                    break;
                case "btn1_Close":
                    if(sheetObject1.IsDataModified()){
                        if(ComShowCodeConfirm("BKG00168")){
                        	ComClosePopup(); 
                        }
                    }else{
                    	ComClosePopup(); 
                    }
                    break;
            }
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
  
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
  
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
    }
    function initControl(){
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 
        axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form);
        axon_event.addListenerFormat('keypress',         'obj_keypress',    form); 
    }

    function obj_deactivate(){
        ComChkObjValid(ComGetEvent());
    }

    function obj_activate(){
        ComClearSeparator(ComGetEvent());
    }

    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
            case 'sheet1':      //sheet1 init
                with(sheetObj){
              
            		var HeadTitle1="|Sel.|Seq.|사업자명|사업자 등록 번호|User Name|Office|Update Date|User ID|Child Record";
            		var headCount=ComCountHeadTitle(HeadTitle1);
            		var prefix="sheet1_";

            		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

	             var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	             InitHeaders(headers, info);

	             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                          {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                          {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:160,  Align:"Center",  ColMerge:1,   SaveName:prefix+"atty_cust_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
	                          {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"atty_biz_no",  KeyField:1,   CalcLogic:"",   Format:"SaupNo",      PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",       KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"child_record", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	             InitColumns(cols);
	             SetEditable(1);
//	             SetCountPosition(0);
	             SetSheetHeight(262);
                      }
        }
    }

    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
            case IBSEARCH://retrieve
                if(!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }//end if
                ComClearSeparator(document.getElementById("atty_biz_no"), "saupja", "-")
                formObj.f_cmd.value=SEARCH;
                sheetObj.DoSearch("ESM_BKG_1000GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
            break;
            case IBSAVE://save
                if(!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }//end if
                formObj.f_cmd.value=MULTI;
                sheetObj.DoSave("ESM_BKG_1000GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"),-1, false);
            break;
            case IBINSERT:// input
            var idx=sheetObj.DataInsert(-1);
            sheetObj.SelectCell(sheetObj.GetSelectRow(), "sheet1_atty_cust_nm", true);
            sheetObj.SetCellValue(idx, "sheet1_upd_usr_nm",document.form.user_nm.value);
            sheetObj.SetCellValue(idx, "sheet1_upd_ofc_cd",document.form.ofc_cd.value);
            sheetObj.SetCellValue(idx, "sheet1_upd_usr_id",document.form.user_id.value);
            break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj, formObj, sAction){
        switch (sAction) {
            case IBSEARCH:
                if(ComIsEmpty(formObj.atty_cust_nm.value) && ComIsEmpty(formObj.atty_biz_no.value)){
                    ComShowCodeMessage('BKG00701');
                    formObj.atty_cust_nm.focus();
                    return;
                }
                return true;
                break;
            case IBSAVE:
                if(!sheetObj.IsDataModified()){
                    ComShowCodeMessage('BKG00743');
                    return false;
                }
                document.form.insertRow.value = sheetObj.RowCount("I");
                if(!mdtrNmByteCheck(sheetObj)){
                    return false;
                }else if(!validSaupjaCheck(sheetObj)){
                    return false;
                }else if(!dupSaupjaCheck(sheetObj)){
                    return false;
                }
                return true;
                break;
        }
    }
  
    
    function mdtrNmByteCheck(sheetObj) {
        for(var idx=1; idx <= sheetObj.RowCount(); idx++){
        	if(sheetObj.GetRowStatus(idx) =='I' && sheetObj.GetCellValue(idx, "sheet1_atty_cust_nm") !=''){
        		if( ComChkLenByByte(sheetObj.GetCellValue(idx, "sheet1_atty_cust_nm"),100) == 0){
                    ComShowCodeMessage("BKG40006");
                    sheetObj.SelectCell(idx, "sheet1_atty_cust_nm", true);
                    return false;
                    break;
                }
            }
        }
        return true;
    }
  
    function dupSaupjaCheck(sheetObj) {
        var dRow=sheetObj.ColValueDup("sheet1_atty_biz_no", false);
        if(ComIsEmpty(sheetObj.GetCellValue(dRow, "sheet1_atty_biz_no"))){
            return true;
        }
        if (dRow != -1) {
        	ComShowCodeMessage('COM12115', 'saupja: ['+sheetObj.GetCellValue(dRow, "sheet1_atty_biz_no")+']');
            sheetObj.SelectCell(dRow, sheetObj.SaveNameCol("sheet1_atty_biz_no"));
            return false;
        } else {
            return true;
        }
    }
    function validSaupjaCheck(sheetObj) {
        for(var idx=1; idx <= sheetObj.RowCount(); idx++){
        	if(sheetObj.GetRowStatus(idx) =='I' && sheetObj.GetCellValue(idx, "sheet1_atty_biz_no")!=''){
        		if(!ComIsSaupjaNo(sheetObj.GetCellValue(idx, "sheet1_atty_biz_no"))){
                    ComShowCodeMessage("BKG40001");
                    sheetObj.SelectCell(idx, "sheet1_atty_biz_no", true);
                    return false;
                    break;
                }
            }
        }
        return true;
    }

    function sheet1_OnSaveEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
            ComBkgSaveCompleted();  //server messege handling 
        }
    }
