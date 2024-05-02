/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4027.js
*@FileTitle  : Commodity Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/


 /**
  * 
 
   *공통으로 사용하는 팝업입니다!!!!!
   *문제 발생시 parent 를 수정해 주세요!!
   *공통 팝업 수정금지!!!!
   *2014.09.02 김은진
   *
   *
   */    

// Global Variables
    var tabObjects=new Array();
    var tabCnt=0;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    // Define Event Handler that receive & process button click event 
    document.onclick=processButtonClick;
    
//다음의 화면들에서 호출됨
//ESM_PRI_0001_03
//ESM_PRI_00013_03
//ESM_PRI_0003_04
//ESM_PRI_0081
//ESM_PRI_0026
//ESM_PRI_0031
//ESM_PRI_0032
//ESM_PRI_0033
//ESM_PRI_0100
//ESM_PRI_0101
//ESM_PRI_0102
    
    /**
     * Event Handler : Define the Flow Control of process using button name
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return void
     * @author 
     * @version 2009.04.29
     */
    function processButtonClick() {
        /** When the number of sheet is two or more on each tab, additional sheet variable should be defined */
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        /** **************************************************** */
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            var radioType=ComGetObjValue(formObject.radio_type);
            switch (srcName) {
                case "btn_Retrieve":

                    switch(radioType) {
                        case "C":
                            doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                            break;
                        case "R":
                            doActionIBSheet(sheetObject2, formObject, IBSEARCH_ASYNC01);
                            break;
                        case "G":
                            doActionIBSheet(sheetObject3, formObject, IBSEARCH_ASYNC02);
                            break;
                    }
                    break;
                case "btn_New":

                    switch(radioType) {
                        case "C":
                            ComClearManyObjects(formObject.cmdt_cd, formObject.cmdt_nm);
                            sheetObject1.RemoveAll();
                            break;
                        case "R":
                            ComClearManyObjects(formObject.rep_cmdt_cd, formObject.rep_cmdt_nm);
                            sheetObject2.RemoveAll();
                            break;
                    }
                    break;
                case "btn_Ok":
                    if(formObject.multi_yn.value != "Y") {
                        returnObject(); // One Row Return
                    } else {
                        returnMultiObject(); // Multi Row Return
                    }

                    break;
                case "btn_Close":
                	ComClosePopup(); 
                    break;
            } // end switch
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
    
    /**
     * Register IBSheet Object as item of array 
     * Afterward, when other items should be process in batch, you could add process putting in array 
     * the array defined at the top of this page
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj Mandatory IBSheet Object
     * @return void
     * @author 
     * @version 2009.04.29
     */
    function setSheetObject(sheet_obj) {
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    
    /**
     * Register IBMultiCombo Object as item of array 
     * Afterward, when other items should be process in batch, you could add process putting in array 
     * the array defined at the top of this page
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_Obj);
     * </pre>
     * @param {ibcombo} combo_obj Mandatory IBMultiCombo Object
     * @return void
     * @author 
     * @version 2009.04.29
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
    }
    
    /**
     * Initialize and basic option setting Sheet
     * Implement body tag's onLoad event handler 
     * Adding the code that should be preprocessed after loading the screen in browser.
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return void
     * @author 
     * @version 2009.04.29
     */
    function loadPage() {
    	
    	 if (!opener) opener = window.dialogArguments;
    	 if (!opener) opener = window.opener;
    	 if (!opener) opener = parent;
   	 
        var formObj=document.form; 
        for (i=0; i < sheetObjects.length; i++) {
            // Modifying the Environment setting function name
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i + 1);
            // Adding the Environment Setting function
            ComEndConfigSheet(sheetObjects[i]);
        }
        // IBMultiCombo Initialize
        for(var k=0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }
        initControl();
        initRadioCheck();
    }
    
    /**
     * The function called when OnLoad event of page has finished
     * Initialize when page is Loding.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initRadioCheck();
     * </pre>
     * @return void
     * @author 
     * @version 2009.04.29
     */
    function initRadioCheck(){
        var formObj=document.form;
        var cmd=formObj.commodity_cmd.value;
        var prcCmdtTpCd=formObj.prc_cmdt_tp_cd.value;
        if(cmd == "C") {
            formObj.radio_type[0].checked=true;
            formObj.radio_type[1].disabled=true;
            formObj.radio_type[2].disabled=true;
            document.getElementById("radioLayer1").style.display='Inline';
            document.getElementById("radioLayer2").style.display='none';
            document.getElementById("radioLayer3").style.display='none';
            
            document.getElementById("sheet1Layer").style.display='Inline';
            document.getElementById("sheet2Layer").style.display='none';
            document.getElementById("sheet3Layer").style.display='none';
        } else if(cmd == "R") {
            formObj.radio_type[1].checked=true;
            formObj.radio_type[0].disabled=true;
            formObj.radio_type[2].disabled=true;
//          $("#radioLayer1").hide();
//          $("#radioLayer2").show();
//          $("#radioLayer3").hide();
            document.getElementById("radioLayer1").style.display='none';
            document.getElementById("radioLayer2").style.display='Inline';
            document.getElementById("radioLayer3").style.display='none';
            
            document.getElementById("sheet1Layer").style.display='none';
            document.getElementById("sheet2Layer").style.display='Inline';
            document.getElementById("sheet3Layer").style.display='none';
        } else if(cmd == "G") {
            formObj.radio_type[2].checked=true;
            formObj.radio_type[0].disabled=true;
            formObj.radio_type[1].disabled=true;
            document.getElementById("radioLayer1").style.display='none';
            document.getElementById("radioLayer2").style.display='none';
            document.getElementById("radioLayer3").style.display='Inline';
            
            document.getElementById("sheet1Layer").style.display='none';
            document.getElementById("sheet2Layer").style.display='none';
            document.getElementById("sheet3Layer").style.display='Inline';
            
        } else if(cmd == "CR") {
            formObj.radio_type[0].checked=true;
            formObj.radio_type[2].disabled=true;
            document.getElementById("radioLayer1").style.display='Inline';
            document.getElementById("radioLayer2").style.display='none';
            document.getElementById("radioLayer3").style.display='none';
            
            document.getElementById("sheet1Layer").style.display='Inline';
            document.getElementById("sheet2Layer").style.display='none';
            document.getElementById("sheet3Layer").style.display='none';
            
        } else if(cmd == "CG") {
            formObj.radio_type[0].checked=true;
            formObj.radio_type[1].disabled=true;
            document.getElementById("radioLayer1").style.display='Inline';
            document.getElementById("radioLayer2").style.display='none';
            document.getElementById("radioLayer3").style.display='none';
            
            document.getElementById("sheet1Layer").style.display='Inline';
            document.getElementById("sheet2Layer").style.display='none';
            document.getElementById("sheet3Layer").style.display='none';
            
        } else if(cmd == "RG") {
            formObj.radio_type[1].checked=true;
            formObj.radio_type[0].disabled=true;
            document.getElementById("radioLayer1").style.display='none';
            document.getElementById("radioLayer2").style.display='Inline';
            document.getElementById("radioLayer3").style.display='none';
            
            document.getElementById("sheet1Layer").style.display='none';
            document.getElementById("sheet2Layer").style.display='Inline';
            document.getElementById("sheet3Layer").style.display='none';
            
        } else if(cmd == "CRG") {
            formObj.radio_type[0].checked=true;
            document.getElementById("radioLayer1").style.display='Inline';
            document.getElementById("radioLayer2").style.display='none';
            document.getElementById("radioLayer3").style.display='none';
            
            document.getElementById("sheet1Layer").style.display='Inline';
            document.getElementById("sheet2Layer").style.display='none';
            document.getElementById("sheet3Layer").style.display='none';
            
        } else {
            formObj.radio_type[0].checked=true;
            formObj.radio_type[2].disabled=true;
            document.getElementById("radioLayer1").style.display='Inline';
            document.getElementById("radioLayer2").style.display='none';
            document.getElementById("radioLayer3").style.display='none';
            
            document.getElementById("sheet1Layer").style.display='Inline';
            document.getElementById("sheet2Layer").style.display='none';
            document.getElementById("sheet3Layer").style.display='none';
            
        }
        if(prcCmdtTpCd == "C") {
            formObj.radio_type[0].checked=true;
            document.getElementById("radioLayer1").style.display='Inline';
            document.getElementById("radioLayer2").style.display='none';
            document.getElementById("radioLayer3").style.display='none';
            
            document.getElementById("sheet1Layer").style.display='Inline';
            document.getElementById("sheet2Layer").style.display='none';
            document.getElementById("sheet3Layer").style.display='none';
            
            if(!ComIsNull(formObj.cmdt_nm.value)) {
                doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
            }
        } else if(prcCmdtTpCd == "R") {
            formObj.radio_type[1].checked=true;
            document.getElementById("radioLayer1").style.display='none';
            document.getElementById("radioLayer2").style.display='Inline';
            document.getElementById("radioLayer3").style.display='none';
            
            document.getElementById("sheet1Layer").style.display='none';
            document.getElementById("sheet2Layer").style.display='Inline';
            document.getElementById("sheet3Layer").style.display='none';
            
        } else if(prcCmdtTpCd == "G") {
            formObj.radio_type[2].checked=true;
            document.getElementById("radioLayer1").style.display='none';
            document.getElementById("radioLayer2").style.display='none';
            document.getElementById("radioLayer3").style.display='Inline';
            
            document.getElementById("sheet1Layer").style.display='none';
            document.getElementById("sheet2Layer").style.display='none';
            document.getElementById("sheet3Layer").style.display='Inline';
            
            doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC10);
        } else {
            formObj.radio_type[0].checked=true;
            document.getElementById("radioLayer1").style.display='Inline';
            document.getElementById("radioLayer2").style.display='none';
            document.getElementById("radioLayer3").style.display='none';
            
            document.getElementById("sheet1Layer").style.display='Inline';
            document.getElementById("sheet2Layer").style.display='none';
            document.getElementById("sheet3Layer").style.display='none';
            
            if(!ComIsNull(formObj.cmdt_nm.value)) {
                doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
            }
        }
    }
    
    /**
     * Sheet Initialize, Header Definition
     * When Sheet is plural, compose sheet initialize module via adding case-statement
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory Sequence No. of IBSheet Object Tag ID
     * @return void
     * @author 
     * @version 2009.04.29
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        var sheetid=sheetObj.id;
        switch (sheetid) {
            // Commodity
            case "sheet1":
                with(sheetObj){
                    var HeadTitle="|Sel.|Seq.|Code|Description|Rep. Code";
                    var headCount=ComCountHeadTitle(HeadTitle);
    
                    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
    
                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
                                 {Type:"DummyCheck", Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                                 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                    if(ComIsNull(document.form.commodity_cmd.value)) {
                        cols.push({Type:"Text",      Hidden:0,  Width:930,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                    } else {
                        cols.push({Type:"Text",      Hidden:0,  Width:350,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                    }
                    cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rep_cmdt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
             
                    InitColumns(cols);
    
                    SetEditable(1);
                    SetWaitImageVisible(0);
                    SetColProperty(0 ,"cmdt_cd" , {AcceptKeys:"N"});
                    SetAutoRowHeight(0);
                    if(ComIsNull(document.form.commodity_cmd.value)) {
                        SetSheetHeight(493);
                    } else {
                        SetSheetHeight(150);
                    }
                }
                break;
            // Rep Commodity
            case "sheet2":
                with(sheetObj){
                    var HeadTitle="|Sel.|Seq.|Code|Description";
//                    var headCount=ComCountHeadTitle(HeadTitle);

                    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
                                 {Type:"DummyCheck", Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                                 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rep_cmdt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
                                 {Type:"Text",      Hidden:0,  Width:280,  Align:"Left",    ColMerge:0,   SaveName:"rep_cmdt_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:40 } ];
               
                    InitColumns(cols);

                    SetEditable(1);
                    SetWaitImageVisible(0);
                    SetColProperty(0 ,"rep_cmdt_cd" , {AcceptKeys:"N"});
                    SetAutoRowHeight(0);
                    if(ComIsNull(document.form.commodity_cmd.value)) {
                        SetSheetHeight(493);
                    } else {
                        SetSheetHeight(150);
                    }

                }
                break;
            // Group Commodity
            case "sheet3":
                with(sheetObj){
                    var HeadTitle="|Sel.|Seq.|Code|Description";
                    var headCount=ComCountHeadTitle(HeadTitle);

                    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
                                 {Type:"DummyCheck", Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                                 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:280,  Align:"Left",    ColMerge:0,   SaveName:"nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:40 } ];
               
                    InitColumns(cols);

                    SetEditable(1);
                    SetWaitImageVisible(0);
                    SetAutoRowHeight(0);
                    SetSheetHeight(150);

                }
                break;
        }
    }
    
    /**
     * Loading event of HTML control on this page dynamically.
     * {@link #loadPage} function initialize IBSheet Object via calling this function. <br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
     * @return void
     * @author 
     * @version 2009.04.29
     **/
    function initControl() {
        //** Date Seperator **/
        DATE_SEPARATOR="/";
        //Axon Event Process 1. Event catch
        axon_event.addListenerForm  ('change',  'grp_cmdt_seq_OnChange', 'grp_cmdt_seq');
        axon_event.addListenerForm  ('click',   'obj_click',    form    );  
        //axon_event.addListener ('keydown', 'getKeyEnter', 'form');
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }
    
    /**
     * The function called when OnChange event on IBCombo triggered
     * when Group commodity Sequence ComboBox has changed, Show the list of selected group. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj Mandatory IBMultiCombo Object
     * @param {string} code Mandatory - Value of Selected Item
     * @param {string} text Mandatory - Text of Selected Item
     * @returns void
     * @author 
     * @version 2009.04.29
     */
    function grp_cmdt_seq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	if(ComIsNull(newCode)) {
            return;
        }
    	var formObj=document.form;
    	var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
    	if (code != -1) {
            var text=comboObj.GetText(code, 1);
            if (text != null && text != "") {
            	formObj.prc_grp_cmdt_desc.value=comboObj.GetText(code, 1);
            }
        } else {
            formObj.prc_grp_cmdt_desc.value="";
        }
    	
        formObj.f_cmd.value=SEARCH02;
        var sXml = sheetObjects[1].GetSearchData("ESM_PRI_4027GS.do", FormQueryString(formObj) );
        sheetObjects[1].LoadSearchData(sXml,{Sync:1})
        doActionIBSheet(sheetObjects[2], formObj, IBSEARCH_ASYNC02);
    }
    
    /**
     * The function called when OnBlur event triggered
     * It makes the 6 digit commodity code via appending leading zero.
     * <br><b>Example :</b>
     * <pre>
     *  
     * </pre>
     * @return void
     * @author 
     * @version 2009.04.29
     */
    function obj_deactivate() {

        var target = event.target || event.srcElement;
        if(target.name == "cmdt_cd") {
            if (!ComIsNull(target) && ComGetLenByByte(target) < 6) {
                target.value=ComLpad(target, 6, '0');
                return;
            }
        }
    }
    
    /**
     * The function called when OnClick event triggered
     * Open the page proper to radio type
     * <br><b>Example :</b>
     * <pre>
     *  
     * </pre>
     * @return void
     * @author 
     * @version 2009.04.29
     */
    function obj_click(){
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var formObj=document.form;
        var target = event.target || event.srcElement;

        if (target.name == "radio_type") {
            if (target.value == "C") {
                document.getElementById("radioLayer1").style.display='Inline';
                document.getElementById("radioLayer2").style.display='none';
                document.getElementById("radioLayer3").style.display='none';
                ComClearManyObjects(formObj.rep_cmdt_cd, formObj.rep_cmdt_nm, formObj.prc_grp_cmdt_desc);
                comboObjects[0].SetSelectCode(-1);
                sheetObjects[1].RemoveAll();
                sheetObjects[2].RemoveAll();
                
                document.getElementById("sheet1Layer").style.display='Inline';
                document.getElementById("sheet2Layer").style.display='none';
                document.getElementById("sheet3Layer").style.display='none';
                sheetObjects[0].SetVisible(true);
                sheetObjects[1].SetVisible(false);
                sheetObjects[2].SetVisible(false);
            } else if(target.value == "R") {
                document.getElementById("radioLayer1").style.display='none';
                document.getElementById("radioLayer2").style.display='Inline';
                document.getElementById("radioLayer3").style.display='none';
                ComClearManyObjects(formObj.cmdt_cd, formObj.cmdt_nm, formObj.prc_grp_cmdt_desc);
                comboObjects[0].SetSelectCode(-1);
                sheetObjects[0].RemoveAll();
                sheetObjects[2].RemoveAll();
                
                document.getElementById("sheet1Layer").style.display='none';
                document.getElementById("sheet2Layer").style.display='Inline';
                document.getElementById("sheet3Layer").style.display='none';
                sheetObjects[0].SetVisible(false);
                sheetObjects[1].SetVisible(true);
                sheetObjects[2].SetVisible(false);
            }  else if (target.value == "G") {
                document.getElementById("radioLayer1").style.display='none';
                document.getElementById("radioLayer2").style.display='none';
                document.getElementById("radioLayer3").style.display='Inline';
                ComClearManyObjects(formObj.cmdt_cd, formObj.cmdt_nm, formObj.rep_cmdt_cd, formObj.rep_cmdt_nm);
                sheetObjects[0].RemoveAll();
                sheetObjects[1].RemoveAll();
                
                document.getElementById("sheet1Layer").style.display='none';
                document.getElementById("sheet2Layer").style.display='none';
                document.getElementById("sheet3Layer").style.display='Inline';
                sheetObjects[0].SetVisible(false);
                sheetObjects[1].SetVisible(false);
                sheetObjects[2].SetVisible(true);
                doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC10);
            }
        }
    }
    

    

    /**
     * 
     *  The function called when OnDbClick event on Sheet1 triggered 
     * 
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTML Tag Object
     * @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
     * @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
     * @returns void
     * @author 
     * @version 2009.04.29
     */ 
    function sheet1_OnDblClick(sheetObj, Row, Col) {
        try{
            var formObj=document.form;
            var multiYn=formObj.multi_yn.value; 
            if(multiYn != "Y") {
            	returnObject();
            } else {
                returnMultiObject();
            }
            return false;
        }catch(e){}
    }
    
    /**
     *  The function called when OnDbClick event on Sheet2 triggered 
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTML Tag Object
     * @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
     * @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
     * @returns void
     * @author 
     * @version 2009.04.29
     */ 
    function sheet2_OnDblClick(sheetObj, Row, Col) {
        try{
            var formObj=document.form;
            var multiYn=formObj.multi_yn.value; 
            if(multiYn != "Y") {
            	returnObject();
            } else {
                returnMultiObject();
            }
            return false; 
        }catch(e){}
    }
    
    /**
     *  The function called when OnDbClick event on Sheet3 triggered 
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTML Tag Object
     * @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
     * @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
     * @returns void
     * @author 
     * @version 2009.04.29
     */ 
    function sheet3_OnDblClick(sheetObj, Row, Col) {
        try{
            var formObj=document.form;
            var multiYn=formObj.multi_yn.value; 
            if(multiYn != "Y") {
            	returnObject();
            } else {
                returnMultiObject();
            }
            return false;
        }catch(e){}
    }
    
    /**
     * Operate Sheet Process <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form} formObj Mandatory html form object
     * @param {int} sAction Mandatory Process Flag Constant
     * @return void
     * @author 
     * @version 2009.04.29
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch (sAction) {
            case IBSEARCH: // Commodity
                ComOpenWait(true);
                if (!validateForm(sheetObj, formObj, sAction)) {
                    ComOpenWait(false);
                    return false;
                }
                formObj.f_cmd.value=SEARCH01;
                sheetObj.DoSearch("ESM_PRI_4027GS.do", FormQueryString(formObj) );
                ComOpenWait(false);
                break;
            case IBSEARCH_ASYNC01: // Rep Commodity
                ComOpenWait(true);
                if (!validateForm(sheetObj, formObj, sAction)) {
                    ComOpenWait(false);
                    return false;
                }
                formObj.f_cmd.value=SEARCH04;
                sheetObj.DoSearch("ESM_PRI_4027GS.do", FormQueryString(formObj) );
                ComOpenWait(false);
                break;
            case IBSEARCH_ASYNC02: // Group Commodity
                ComOpenWait(true);
                if (!validateForm(sheetObj, formObj, sAction)) {
                    ComOpenWait(false);
                    return false;
                }
                formObj.f_cmd.value=SEARCH02;
                sheetObj.DoSearch("ESM_PRI_4027GS.do", FormQueryString(formObj) );
                ComOpenWait(false);
                break;
            case IBSEARCH_ASYNC10: // Retrieve
                formObj.f_cmd.value=SEARCH03;
                var sXml=sheetObj.GetSearchData("ESM_PRI_4027GS.do", FormQueryString(formObj));
                ComPriXml2ComboItem(sXml, grp_cmdt_seq, "seq", "cd|nm");
                break;
        }
    }
    
    /**
     * Operate validation process on user input value of form object <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         process;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {form} formObj Mandatory, html form object
     * @param {int} sAction Mandatory, process flag constant
     * @returns bool <br>
     *          true  : Pass the Validation Rule<br>
     *          false : Validation Rule violated
     * @author 
     * @version 2009.04.29
     */
    function validateForm(sheetObj, formObj, sAction) {
         switch (sAction) {
            case IBSEARCH: //Commodity Case
                if (ComIsNull(formObj.cmdt_cd) && ComIsNull(formObj.cmdt_nm)) {
                    ComShowCodeMessage("PRI04005","Code","Description");
                    ComSetFocus(formObj.cmdt_cd);
                    return false;
                }
                if (!ComIsNull(formObj.cmdt_cd) && ComGetLenByByte(formObj.cmdt_cd) < 2) {
                    ComShowCodeMessage("PRI04004","Code","2","6");
                    ComSetFocus(formObj.cmdt_cd);
                    return false;
                }
                if (!ComIsNull(formObj.cmdt_nm) && ComGetLenByByte(formObj.cmdt_nm) < 2) {
                    ComShowCodeMessage("PRI04004","Description","2","40");
                    ComSetFocus(formObj.cmdt_nm);
                    return false;
                }
                return true;
                break;
            case IBSEARCH_ASYNC01: //Rep Commodity Case

                if (ComIsNull(formObj.rep_cmdt_cd) && ComIsNull(formObj.rep_cmdt_nm)) {
                    ComShowCodeMessage("PRI04005","Code","Description");
                    ComSetFocus(formObj.rep_cmdt_cd);
                    return false;
                }
                if (!ComIsNull(formObj.rep_cmdt_cd) && ComGetLenByByte(formObj.rep_cmdt_cd) < 2) {
                    ComShowCodeMessage("PRI04004","Code","2","6");
                    ComSetFocus(formObj.rep_cmdt_cd);
                    return false;
                }
                if (!ComIsNull(formObj.rep_cmdt_nm) && ComGetLenByByte(formObj.rep_cmdt_nm) < 2) {
                    ComShowCodeMessage("PRI04004","Description","2","40");
                    ComSetFocus(formObj.rep_cmdt_nm);
                    return false;
                }
                return true;
                break;
            case IBSEARCH_ASYNC02: //Group Commodity Case
                if (ComIsNull(ComGetObjValue(grp_cmdt_seq))) {
                    ComShowCodeMessage("PRI04007","Code");
                    ComSetFocus(grp_cmdt_seq);
                    return false;
                }
                return true;
                break;
        }
        return true;
    }
    
    /**
     * Combobox Initialize, Header Definition
     * When Combobox is plural, compose combobox initialize module via adding case-statement <br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {object} comboObj Mandatory, IBMultiCombo Object
     * @param {int} comboNo Mandatory, Sequence No. of IBMultiCombo Object Tag's ID 
     * @return void
     * @author 
     * @version 2009.04.29
     */
    function initCombo(comboObj, comboNo) {
        switch(comboObj.options.id) {
            case "grp_cmdt_seq":
                var i=0;
                with(comboObj) {
                    //BackColor = "cyan";
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                }
                break;
        }
    }

    
    /**
     * The function returns single-selected item <br>
     * <br><b>Example :</b>
     * <pre>
     *    returnObject()
     * </pre>
     * @returns void
     * @author 
     * @version 2009.04.29
     */ 
    function returnObject() {
        var formObj=document.form;
        var radioType=ComGetObjValue(formObj.radio_type);
        var rtnArray=new Array();
        var rtnObject=new Object();
        if(radioType == "C") {
            var Row=sheetObjects[0].GetSelectRow();
            if(Row < 1) {
                ComShowCodeMessage("PRI04006");
                return false;
            }
            rtnObject.cd=sheetObjects[0].GetCellValue(Row, "cmdt_cd");
            rtnObject.nm=sheetObjects[0].GetCellValue(Row, "cmdt_nm");
            rtnObject.tp="C";
        } else if(radioType == "R") {
            var Row=sheetObjects[1].GetSelectRow();
            if(Row < 1) {
                ComShowCodeMessage("PRI04006");
                return false;
            }
            rtnObject.cd=sheetObjects[1].GetCellValue(Row, "rep_cmdt_cd");
            rtnObject.nm=sheetObjects[1].GetCellValue(Row, "rep_cmdt_nm");
            rtnObject.tp="R";
        } else if(radioType == "G") {
            if(comboObjects[0].GetSelectCode()== "") {
                ComShowCodeMessage("PRI04006");
                return false;
            }
            rtnObject.cd=comboObjects[0].GetSelectText();
            rtnObject.nm=formObj.prc_grp_cmdt_desc.value;
            rtnObject.tp="G";
        }
        ComPopUpReturnValue(rtnObject);
    }
    
    /**
     * The function returns multi-selected item <br>
     * <br><b>Example :</b>
     * <pre>
     *    returnObject()
     * </pre>
     * @returns void
     * @author 
     * @version 2009.04.29
     */ 
    function returnMultiObject() {
        var formObj=document.form;
        var radioType=ComGetObjValue(formObj.radio_type);
        var rtnArray=new Array();
        var arrayCnt=0;
        if(radioType == "C") { //Commodity
            var Row=sheetObjects[0].GetSelectRow();
     
            if(Row < 1) { //No Rows Selected
                ComShowCodeMessage("PRI04006");
                return false;
            }
            // Selected Row List
            var chkArr=ComPriSheetCheckedRows(sheetObjects[0], "chk");
            if(chkArr.length == 0){
                sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(),"chk","1",0);
            }
            chkArr=ComPriSheetCheckedRows(sheetObjects[0], "chk");
            for(var i=0; i<chkArr.length; i++) {
                var rtnObject=new Object();
                rtnObject.cd=sheetObjects[0].GetCellValue(chkArr[i], "cmdt_cd");
                rtnObject.nm=sheetObjects[0].GetCellValue(chkArr[i], "cmdt_nm");
                rtnObject.tp="C";
                rtnArray[arrayCnt]=rtnObject; //Return as Object List format
                arrayCnt++;
            }
        } else if(radioType == "R") {
            var Row=sheetObjects[1].GetSelectRow();
            if(Row < 1) {
                ComShowCodeMessage("PRI04006");
                return false;
            }
            // Selected Row List
            var chkArr=ComPriSheetCheckedRows(sheetObjects[1], "chk");
            if(chkArr.length == 0){
                sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(),"chk","1",0);
            }
            chkArr=ComPriSheetCheckedRows(sheetObjects[1], "chk");
            for(var i=0; i<chkArr.length; i++) {
                var rtnObject=new Object();
                rtnObject.cd=sheetObjects[1].GetCellValue(chkArr[i], "rep_cmdt_cd");
                rtnObject.nm=sheetObjects[1].GetCellValue(chkArr[i], "rep_cmdt_nm");
                rtnObject.tp="C";
                rtnArray[arrayCnt]=rtnObject; //Return as Object List format
                arrayCnt++;
            }
        } else if(radioType == "G") {
            if(comboObjects[0].GetSelectCode()== "") {
                ComShowCodeMessage("PRI04006");
                return false;
            }
            var rtnObject=new Object();
            rtnObject.cd=comboObjects[0].GetSelectText();
            rtnObject.nm=formObj.prc_grp_cmdt_desc.value;
            rtnObject.tp="G";
            rtnArray[arrayCnt]=rtnObject; //Return as Object List format
        }
        ComPopUpReturnValue(rtnArray);
    }
