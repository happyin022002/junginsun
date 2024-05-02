/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4004.js
*@FileTitle  : Surcharge Location Group Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/6/24

=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @.
     * @author 
     */
    /**
     * @extends 
     * @class ESM_PRI_4004 : Business Script for ESM_PRI_4004
     */
    // common global variables
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1; 
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    // new button or window reset flag
    // var isNew = false;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    var eventStatus="";
    /**
	  * Event handler processing by button name  <br>
	  * <br><b>Example :</b>
	  * <pre>
	  *     processButtonClick();
	  * </pre>
	  * @return void
	  * @author 
	  * @version 2009.04.17
	  */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            
            switch(srcName) {
                case "btn_add":
                    doActionIBSheet(sheetObjects[1], formObject, IBINSERT);
                    break;
                case "btn_del":
                    doActionIBSheet(sheetObjects[1], formObject, IBDELETE);
                    break;
                case "btn_add2":
                    doActionIBSheet(sheetObjects[2], formObject, IBINSERT);
                    break;
                case "btn_del2":
                    doActionIBSheet(sheetObjects[2], formObject, IBDELETE);
                    break;      
                case "btn_retrieve":
                    doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
                    break;
                case "btn_new":
                    removeAll(document.form);
                    break;
                case "btn_save":
                    doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
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
     * @version 2009.04.17
     */ 
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * registering IBMultiCombo Object as list
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_obj);
     * </pre>
     * @param {ibCombo} combo_obj Mandatory IBMulti Combo Object
     * @return void
     * @author 
     * @version 2009.04.17
     */ 
    function setComboObject(combo_obj){
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
     * @return void
     * @author 
     * @version 2009.04.17
     */
    function loadPage() {
    	
    	if (!opener) opener = window.dialogArguments;
    	if (!opener) opener = window.opener;
    	if (!opener) opener = parent;
    	
    	 for(i=0;i<sheetObjects.length;i++){
            //Modify Environment Setting Function's name
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //Add Environment Setting Function
            ComEndConfigSheet(sheetObjects[i]);
        }
        //Initializing IBMultiCombo
        for(var k=0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');

        sheet2_OnLoadFinish(sheet2);
        
     }
    /**
     * It calls at LoadFinish event triggered. <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @return void
     * @author 
     * @version 2009.04.17
     */
    function sheet2_OnLoadFinish(sheetObj) {
	   	 sheetObj.SetWaitImageVisible(0);
	   	 doActionIBSheet(sheetObjects[2], document.form, IBCLEAR);
//	   	 sheetObj.WaitImageVisible = true; 
    }
    /**
     * IBSHEET COMBO Loading Function.<br>
     * <br><b>Example :</b>
     * <pre>
     * 		initCombo(comboObj, comboNo)
     * </pre>
     * @return void
     * @author 
     * @version 2009.06.10
     */ 
    function initCombo(comboObj, comboNo) {
        switch(comboObj.options.id) {
            case "svc_scp_cd":
                var i=0;
                with(comboObj) {
                    Style=0;
                    //BackColor = "cyan";
                    SetDropHeight(260);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    ValidChar(2);
                    SetMaxLength(3);
                }
                break;
            case "chg_cd":
                var i=0;
                with(comboObj) {
                    Style=0;
                    SetDropHeight(260);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    ValidChar(2);
                    SetMaxLength(3);
                }
                break;
        }
    }
    /**
     * Return Code value of comboObjects[0]<br>
     * <br><b>Example :</b>
     * <pre>
     * 		var code = getSvcScpCd();
     * </pre>
     * @return String <br>
     * @author 
     * @version 2009.06.10
     */ 
    function getSvcScpCd() {
        return comboObjects[0].GetSelectCode();
    }
    /**
     * Return Code value of comboObjects[1]<br>
     * <br><b>Example :</b>
     * <pre>
     * 		var code = getChgCd();
     * </pre>
     * @return String <br>
     * @author 
     * @version 2009.06.10
     */ 
    function getChgCd() {
        return comboObjects[1].GetSelectCode();
    } 
    /**
     * Calling Function in case of OnChange event <br>
     * Showing description by svc_scp_cd value <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {object} comboObj Mandatory IBMultiCombo Object
     * @param {string} code Mandatory selected item's value
     * @param {string} text Mandatory selected item's text
     * @returns void
     * @author 
     * @version 2009.06.05
     */
    //Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)
    function svc_scp_cd_OnChange (comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	var formObj=document.form;
//      var arrText=newIndex.split("|");
      if (newCode != null && newCode.length > 1) {
          formObj.svc_scp_nm.value=comboObj.GetText(newCode, 1);
          formObj.chg_nm.value="";
          doActionIBSheet(sheet0, document.form, IBSEARCH);
      }
    }
    /**
     * calling function in case of OnBlur event of IBMultiCombo <br>
     * Showing description of selected code when focus move out from svc_scp_cd <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {object} comboObj Mandatory IBMultiCombo Object
     * @returns void
     * @author 
     * @version 2009.06.02
     */
    function svc_scp_cd_OnBlur (comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var formObj=document.form;
        var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
        if (code != -1) {
            var text=comboObj.GetText(code, 1);
            if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
                formObj.svc_scp_nm.value=text;
                doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
            }
        } else {
            formObj.svc_scp_nm.value="";
            comboObj.SetSelectCode(-1,false);
        }
    }
    /**
     * Calling Function in case of OnChange event <br>
     * Display the Description of selected code when chg_cd combo modified. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {object} comboObj Mandatory IBMultiCombo Object
     * @param {string} code Mandatory selected item's value
     * @param {string} text Mandatory selected item's text
     * @returns void
     * @author 
     * @version 2009.07.20
     */
    function chg_cd_OnChange (comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var formObj=document.form;
//        var arrText=text.split("|");
        if (newCode != null && newCode.length > 1) {
            formObj.chg_nm.value=comboObj.GetText(newCode, 1);
            doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
        }
    }
    /**
     * calling function in case of OnBlur event of IBMultiCombo <br>
     * Display the Description of selected code when the focus moves out of chg_cd combo. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {object} comboObj Mandatory IBMultiCombo Object
     * @returns void
     * @author 
     * @version 2009.07.20
     */
    function chg_cd_OnBlur (comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var formObj=document.form;
        var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
        if (code != -1) {
            var text=comboObj.GetText(code, 1);
            if (text != null && text != "" && text != formObj.chg_nm.value) {
                formObj.chg_nm.value=text;
                doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
            }
        } else {
            formObj.chg_nm.value="";
            comboObj.SetSelectCode(-1,false);
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
     * @version 2009.04.17
     */ 
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         var sheetID=sheetObj.id;
         switch(sheetID) {
            case "sheet0":      //hidden 
                 break; 
            case "sheet1":      //sheet1 init
                 with (sheetObj) {
	                var HeadTitle="|Sel.|Seq.|Group\nCode|Description|Creation\nDate|svc_scp_cd|chg_cd|grp_loc_seq";
	                var headCount=ComCountHeadTitle(HeadTitle);
	
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
	                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"scg_grp_loc_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	                 {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"scg_grp_loc_desc",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
	                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"chg_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                resizeSheet(); //SetSheetHeight(390);
	                
	                //AS-IS:InitDataValid(0, "scg_grp_loc_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
	                SetColProperty(0 ,"scg_grp_loc_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
                }
                 break;
            case "sheet2":      //sheet2 init
                 with (sheetObj) {
	                var HeadTitle="|Sel.|Seq.|Location\nType|Code|Description|Effective\nDate|Expiration\nDate|Update\nDate|svc_scp_cd|chg_cd|scg_grp_loc_cd|grp_loc_dtl_seq";
	                var headCount=ComCountHeadTitle(HeadTitle);
	
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
	                 {Type:"Combo",     Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"dtl_loc_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"dtl_loc_def_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	                 {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"loc_des",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",           KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"chg_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_dtl_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetShowButtonImage(2);
	                resizeSheet(); //SetSheetHeight(390);
	                SetColProperty(0 ,"dtl_loc_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
                }
                 break;
         }
     }
     
     function resizeSheet(){
    	 ComResizeSheet(sheetObjects[1]);
    	 ComResizeSheet(sheetObjects[2]);
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
      * @version 2009.04.17
      */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBCLEAR:
                //alert()
                // Retrieve Service Scope when screen is loading
                formObj.f_cmd.value=SEARCH01;
                var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
                ComPriXml2ComboItem(sXml,svc_scp_cd, "cd", "cd|nm");
                //common - type
                sheetObjects[2].SetColProperty("dtl_loc_tp_cd", {ComboText:LOCATION_TYPE3[1] ,ComboCode:LOCATION_TYPE3[0]} );
                if(formObj.pre_svc_scp_cd.value != "") {
	                comboObjects[0].SetSelectCode(formObj.pre_svc_scp_cd.value);
	                //var formObj = document.form;
	                var code=comboObjects[0].FindItem(comboObjects[0].GetSelectCode(), 0);
	                if (code != -1) {
	                    var text=comboObjects[0].GetText(code, 1);
	                    if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
	                        formObj.svc_scp_nm.value=text;
	                        doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	                    }
	                } else {
	                    formObj.svc_scp_nm.value="";
	                    comboObjects[0].SetSelectCode(-1,false);
	                }
	                formObj.pre_svc_scp_cd.value="";
                }
                break;  
            case IBSEARCH:      //Retrieving
            	try {
     			    for (var i=0; i < sheetObjects.length; i++) {
					 	sheetObjects[i].SetWaitImageVisible(0);
				    }
				    ComOpenWait(true);
	                if (sheetObj.id == "sheet0") {
	                    // Surcharge combo
	                    formObj.f_cmd.value=COMMAND12;
	                    formObj.etc1.value=getSvcScpCd();
	                    sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	                    ComPriXml2ComboItem(sXml, chg_cd, "cd", "cd|nm");
	                } else {
	                    if (validateForm(sheetObj,document.form,sAction)) {
	                        if ( sheetObj.id == "sheet1") {
	                            for (var i=0; i < sheetObjects.length; i++) {
	                                sheetObjects[i].RemoveAll();
	                            }    
	                            formObj.f_cmd.value=SEARCH01;
	                            if (formObj.pre_svc_scp_cd.value != "") {
	                            	sheetObj.DoSearch("ESM_PRI_4028GS.do", FormQueryString(formObj) );
	                            } else {
	                            	sheetObj.DoSearch("ESM_PRI_4004GS.do", FormQueryString(formObj) );
	                            }
	                        }       
	                        else if ( sheetObj.id == "sheet2") {
	                            formObj.f_cmd.value=SEARCH02;
	                            if (formObj.pre_svc_scp_cd.value != "") {
	                            	sheetObj.DoSearch("ESM_PRI_4028GS.do", FormQueryString(formObj) );
	                            } else {
	                            	sheetObj.DoSearch("ESM_PRI_4004GS.do", FormQueryString(formObj) );
	                            }
	                        }
	                    }
	                }
		            if(formObj.pre_chg_cd.value != "") {
			            comboObjects[1].SetSelectCode(formObj.pre_chg_cd.value);
			            var code=comboObjects[1].FindItem(comboObjects[1].GetSelectCode(), 0);
			            if (code != -1) {
			                var text=comboObjects[1].GetText(code, 1);
			                if (text != null && text != "" && text != formObj.chg_nm.value) {
			                    formObj.chg_nm.value=text;
			                }
			            } else {
			                formObj.chg_nm.value="";
			                comboObjects[1].SetSelectCode(-1,false);
			            }
			            formObj.pre_chg_cd.value="";
			            doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
		            }
		            ComOpenWait(false);
				 } catch (e) {
     	            if (e == "[object Error]") {
     	                ComShowMessage(OBJECT_ERROR);
     	            } else {
     	                ComShowMessage(e.message);
     	            }
     	       } finally {
     	    	   ComOpenWait(false);
     	       }	
                break;
            case IBSAVE:        
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return;
                }
                eventStatus="IBSAVE";
                formObj.f_cmd.value=MULTI01;
                var sParam=FormQueryString(formObj);
                var sParamSheet1=sheetObjects[1].GetSaveString();
                if (sheetObjects[1].IsDataModified()&& sParamSheet1 == "") {
                    return;
                }
                sParam += "&" + ComPriSetPrifix(sheetObjects[1].GetSaveString(), "sheet1_");
                var sParamSheet2=sheetObjects[2].GetSaveString();
                if (sheetObjects[2].IsDataModified()&& sParamSheet2 == "") {
                    return;
                }
                sParam += "&" + ComPriSetPrifix(sheetObjects[2].GetSaveString(), "sheet2_");
                if (!supressConfirm && !ComPriConfirmSave()) {
                    return false;
                }
                try {
     			    for (var i=0; i < sheetObjects.length; i++) {
					 	sheetObjects[i].SetWaitImageVisible(0);
				    }
				    ComOpenWait(true);
	                var sXml="";
	                if (formObj.pre_svc_scp_cd.value != "") {
	                	sXml=sheetObj.GetSaveData("ESM_PRI_4028GS.do", sParam);
	                } else {
	                	sXml=sheetObj.GetSaveData("ESM_PRI_4004GS.do", sParam);
	                }
	                //sheetObjects[0].LoadSaveXml(sXml);
	                sheetObjects[2].LoadSaveData(sXml);
	                sheetObjects[1].LoadSaveData(sXml);
	                ComOpenWait(false);
				} catch (e) {
     	            if (e == "[object Error]") {
     	                ComShowMessage(OBJECT_ERROR);
     	            } else {
     	                ComShowMessage(e.message);
     	            }
     	        } finally {
     	    	    ComOpenWait(false);
     	        }	
                if (sheetObjects[1].IsDataModified()|| sheetObjects[2].IsDataModified()) {
                    return false;
                } else {
                    ComPriSaveCompleted();
//                    doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
                    if (getValidRowCount(sheetObjects[1]) >= 1 && getValidRowCount(sheetObjects[2]) <= 0) {
                        doRowChange(sheetObjects[1], sheetObjects[2], -1, sheetObjects[1].GetSelectRow(), sheetObjects[1].GetSelectCol(), sheetObjects[1].GetSelectCol(), false);
                    }
                    return true;
                }
                eventStatus="";
                break;
            case IBINSERT: // Row Add
                if (validateForm(sheetObj,document.form,sAction)) {
                	if (sheetObj.id == "sheet1") {
//                      var idx = doRowChange(sheetObjects[1], sheetObjects[2], sheetObjects[1].SelectRow, 
//                                            sheetObjects[1].SelectRow + 1, sheetObjects[1].SelectCol, true);
                        var idx=doRowChange(sheetObj, sheetObjects[1], sheetObj.GetSelectRow(), sheetObj.GetSelectRow()+ 1, sheetObj.GetSelectCol(), sheetObj.GetSelectCol(), true);
                        if (idx < 0) {
                            return false;
                        }
                        //service scoup
                        sheetObj.SetCellValue(idx, "svc_scp_cd",getSvcScpCd());
                        sheetObj.SetCellValue(idx, "chg_cd",getChgCd());
                        // Setting Max Sequence
                        sheetObj.SetCellValue(idx, "grp_loc_seq",parseInt(formObj.max_seq.value) + 1);
                        // max 1 increase
                        formObj.max_seq.value=sheetObj.GetCellValue(idx, "grp_loc_seq");
                        //sheetObjects[1].RemoveAll();  수정전 아래 추가
                        sheetObjects[2].RemoveAll();
                        sheetObj.SelectCell(idx,"scg_grp_loc_cd");
                    
                    }
                	else if (sheetObj.id == "sheet2") {
                        var idx=sheetObj.DataInsert();
                        sheetObj.SetCellValue(idx, "svc_scp_cd",getSvcScpCd());
                        sheetObj.SetCellValue(idx, "chg_cd",getChgCd());
                        var grp_loc_seq=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "grp_loc_seq");
                        sheetObj.SetCellValue(idx, "grp_loc_seq",grp_loc_seq);
                        sheetObj.SetCellValue(idx, "grp_loc_dtl_seq",parseInt(ComPriGetMax(sheetObj, "grp_loc_dtl_seq")) + 1);
                        sheetObj.SelectCell(idx,"dtl_loc_def_cd");
                    }
                }
                break;
            case IBDELETE: // Delete
                
            	if (!validateForm(sheetObj,document.form,sAction)) {
                    return;
                }
            	var chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
                if(chkArr.length==0) {
                	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk", 1, false);
                	chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
                }
                
                for(var i=chkArr.length ; i >= 0 ; i--){
 					if ( sheetObj.id == "sheet1" )sheetObjects[2].RemoveAll();
 					sheetObj.SetCellValue( chkArr[i] , "ibflag","D", false);
 					sheetObj.SetCellValue( chkArr[i] , "chk", 0, false);
 					sheetObj.SetRowHidden( chkArr[i] ,1);  //.SetRowHidden(Row,Hidden) Get : 1 이면 숨기 상태, 0이면 보이는 상태)
	 			}
               
                formObj.max_seq.value=ComPriGetMaxExceptDelete(sheetObj, "grp_loc_seq");
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
     * @return bool <br>
     *          true  : valid<br>
     *          false : inValid
     * @author 
     * @version 2009.04.17
     */
     function validateForm(sheetObj,formObj,sAction){
          switch (sAction) {
            case IBSEARCH: // retrieving
            	if(sheetObjects[0].IsDataModified()|| sheetObjects[2].IsDataModified()){
            		if ( ComShowCodeConfirm("PRI00010") ) {
                		return true;
    				}           	
		            return false;       
	            }	
                if (comboObjects[0].GetSelectCode()== "") {
                    ComShowCodeMessage('PRI08002');
                    return false;
                }
                if (comboObjects[1].GetSelectCode()== "") {
                    ComPriInputValueFailed("select","Charge","");
                    return false;
                }   
                return true;
                break;
            case IBSAVE: // Saving
                if (comboObjects[0].GetSelectCode()== "") {
                    ComShowCodeMessage('PRI08002');
                    return false;
                }
                if (comboObjects[1].GetSelectCode()== "") {
                    ComPriInputValueFailed("select","Charge","");
                    return false;
                }   
                if (!sheetObjects[1].IsDataModified()&& !sheetObjects[2].IsDataModified()) {
                    ComShowCodeMessage("PRI00301");
                    return false;
                }
               // Check whether data saved at sheet1
                if (!sheetObjects[1].IsDataModified() && ( sheetObjects[1].RowCount()<= 0 || sheetObjects[1].GetSelectRow()<= 0 )) {
                    ComPriInputValueFailed("input","Group Code","");
                    doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
                    return false;
                }
                if (!isDeleted(sheetObjects[1]) && !isDeleted(sheetObjects[2]) && getValidRowCount(sheetObjects[2]) <= 0) {
                	ComShowCodeMessage("PRI00319", "Location Type");
                    doActionIBSheet(sheetObjects[2], document.form, IBINSERT);
					return false;
				}
                for( var i=1 ; i<=sheetObjects[2].RowCount(); i++){
                	if(sheetObjects[2].GetCellValue(i,"ibflag")=='I' || (sheetObjects[2].GetCellValue(i,"ibflag")=='U')){
                		if(sheetObjects[2].GetCellValue(i, "dtl_loc_tp_cd")==null || sheetObjects[2].GetCellValue(i, "dtl_loc_tp_cd")==""){
		        			ComShowCodeMessage('COM130403', 'Location Type');//key field missing
		        			sheetObjects[2].SelectCell(i, "dtl_loc_tp_cd");
							return false;
							break;
                		}else if(sheetObjects[2].GetCellValue(i, "dtl_loc_def_cd")==null || sheetObjects[2].GetCellValue(i, "dtl_loc_def_cd")==""){
							ComShowCodeMessage('COM130403', 'Location Code');//key field missing
							sheetObjects[2].SelectCell(i, "dtl_loc_def_cd");
							return false;
							break; 
                		}else if(sheetObjects[2].GetCellValue(i, "eff_dt")==null ||sheetObjects[2].GetCellValue(i, "eff_dt")==""){
							ComShowCodeMessage('COM130403', 'Effective Date');//key field missing
							sheetObjects[2].SelectCell(i, "eff_dt");
							return false;
							break; 				
						}
		        	}
                }
                if (sheetObjects[1].IsDataModified()) {
                     var rowM=sheetObjects[1].ColValueDup("svc_scp_cd|chg_cd|scg_grp_loc_cd",false);
                     if (rowM >= 0) {
                         ComShowCodeMessage("PRI00303", "Sheet", rowM);
                         return false;
                    }               
                }
                if (sheetObjects[2].IsDataModified()) {
                     var rowD=sheetObjects[2].ColValueDup("svc_scp_cd|chg_cd|grp_loc_seq|dtl_loc_tp_cd|dtl_loc_def_cd",false);
                     if (rowD >= 0) {
                         ComShowCodeMessage("PRI00303", "Sheet", rowD);
                         return false;
                    }               
                }
                // Check whether data saved at sheet2
//                if (getValidRowCount(sheetObjects[1]) >= 1 && (sheetObjects[2].RowCount <= 0 || sheetObjects[2].SelectRow <= 0)) {
//                    ComShowCodeMessage("PRI00319", "Location Type");
//                    doActionIBSheet(sheetObjects[2], document.form, IBINSERT);
//                    return false;
//                }
                return true;
                break;
            case IBINSERT: // Row Add
                if (comboObjects[0].GetSelectCode()== "") {
                    ComShowCodeMessage('PRI08002');
                    return false;
                }
                if (comboObjects[1].GetSelectCode()== "") {
                    ComPriInputValueFailed("select","Charge","");
                    return false;
                }   
                return true;
                break;
            case IBDELETE: // Delete
                if (comboObjects[0].GetSelectCode()== "") {
                    ComShowCodeMessage('PRI08002');
                    return false;
                }
                if (comboObjects[1].GetSelectCode()== "") {
                    ComPriInputValueFailed("select","Charge","");
                    return false;
                }   
                return true;
                break;
            }
         return true;
     }
       /**
        * Calling function in case of OnPopupClick event<br>
        * Calling Location PopUp <br>
        * <br><b>Example :</b>
        * <pre>
        *
        * </pre>
        * @param {ibsheet} sheetObj mandatory IBSheet Object
        * @param {int} Row Mandatory OnPopupClick ,Cell's Row Index
        * @param {int} Col Mandatory OnPopupClick 'Cell's Column Index
        * @return void
        * @author 
        * @version 2009.04.17
        */               
        function sheet2_OnPopupClick(sheetObj, Row, Col)
        {
            var colName=sheetObj.ColSaveName(Col);
            var formObj=document.form;
            var locTpCd=sheetObj.GetCellValue(Row,"dtl_loc_tp_cd");
            switch(colName)
            {
                case "dtl_loc_def_cd":
                    var sUrl="ESM_PRI_4026.do?group_cmd=" + PRI_SG + "&location_cmd=LCR&svc_scp_cd=" + getSvcScpCd() + "&chg_cd=" + getChgCd()+"&loc_tp_cd="+ locTpCd;
                    ComOpenPopup(sUrl, 700, 310, "findDtlLocDefCd", "1,0,1,1,1,1,1", true);
                    break;
            }
        }   
        
        function findDtlLocDefCd(rtnVal) {   
        	var formObj = document.form;
      		var sheetObj=sheetObjects[2];
        	var tpCd="C";
            if (rtnVal != null){
                sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),rtnVal.cd,0);
                sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol() + 1,rtnVal.nm,0);
                if (rtnVal.cd.length == 5){
                    tpCd="L";
                } else if (rtnVal.cd.length == 2){
                    tpCd="C";
                }else if (rtnVal.cd.length == 3){
                    tpCd="R";
                }
                sheetObj.SetCellValue(sheetObj.GetSelectRow(), "dtl_loc_tp_cd",tpCd,0);
            }
            //break;
        }
        
        /**
         * Execute when data of sheet changed. <br>
         * <br><b>Example :</b>
         * <pre>
         *    
         * </pre>
         * @param {ibsheet} sheetObj mandatory IBSheet Object
         * @param {int} Row 
         * @param {int} Col 
         * @param {String} Value 
         * @return void
         * @author 
         * @version 2009.04.17
         */
        function sheet1_OnChange(sheetObj, Row, Col, Value) {
    		var formObj=document.form;
    		var sName=sheetObj.ColSaveName(Col);
    		if (sName == "scg_grp_loc_cd") {
    			if (Value != "" && Value.length != 4) {
    				sheetObj.SetCellValue(Row, "scg_grp_loc_cd","",0);
    				sheetObj.SelectCell(Row, "scg_grp_loc_cd", true);
    			}
    		}
    	}
        /**
         * Execute when data of sheet changed. <br>
         * <br><b>Example :</b>
         * <pre>
         *    
         * </pre>
         * @param {ibsheet} sheetObj mandatory IBSheet Object
         * @param {int} Row 
         * @param {int} Col 
         * @param {String} Value 
         * @return void
         * @author 
         * @version 2009.04.17
         */
        function sheet2_OnChange(sheetObj, Row, Col, Value){
            var colname=sheetObj.ColSaveName(Col);
            var formObj=document.form
            switch(colname)
            {
                case "dtl_loc_def_cd":
                    if (Value.length==2){
                        formObj.f_cmd.value=SEARCH07;
                        formObj.cd.value=sheetObj.GetCellValue(Row,Col);                       
                        // sheetObj.WaitImageVisible = false; // While processing, Set the waiting image show option to false. 
                        var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
                        var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
                        //alert(arrData[0]+"/"+arrData[1])
                        if (arrData != null && arrData.length > 0 && !ComIsEmpty(arrData[1])){
                            sheetObj.SetCellValue(Row,"loc_des",arrData[1],0);
                            sheetObj.SetCellValue(Row,"dtl_loc_tp_cd","C" ,0);
                        }else{
//                            ComShowCodeMessage("PRI00315");
                            locationCellClear(sheetObj,Row);
                        }   
                    }else if(Value.length==5){
                        formObj.f_cmd.value=SEARCH05;
                        formObj.cd.value=sheetObj.GetCellValue(Row,Col);   
                        // sheetObj.WaitImageVisible = false; // While processing, Set the waiting image show option to false.
                        var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
                        var arrData=ComPriXml2ComboString(sXml, "cd", "nm");                  
                        if (arrData != null && arrData.length > 0 && !ComIsEmpty(arrData[1])) {
                            sheetObj.SetCellValue(Row,"loc_des",arrData[1],0);
                            sheetObj.SetCellValue(Row,"dtl_loc_tp_cd","L" ,0);
                        }else{      
//                            ComShowCodeMessage("PRI00315");
                            locationCellClear(sheetObj,Row);
                        }           
                    }else if(Value.length==3){
                        formObj.f_cmd.value=COMMAND08;
                        formObj.cd.value=sheetObj.GetCellValue(Row,Col);   
                        // sheetObj.WaitImageVisible = false; // While processing, Set the waiting image show option to false.
                        var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
                        var arrData=ComPriXml2ComboString(sXml, "cd", "nm");                  
                        if (arrData != null && arrData.length > 0 && !ComIsEmpty(arrData[1])) {
                            sheetObj.SetCellValue(Row,"loc_des",arrData[1],0);
                            sheetObj.SetCellValue(Row,"dtl_loc_tp_cd","R" ,0);
                        }else{      
//                            ComShowCodeMessage("PRI00315");
                            locationCellClear(sheetObj,Row);
                        }                               
                    }else{
//                        ComShowCodeMessage("PRI00315");
                        locationCellClear(sheetObj,Row);
                    }
                    break;
//              case "rout_pnt_loc_def_cd":
//                  if (Value.length==2){
//                      formObj.f_cmd.value = SEARCH07;
//                      formObj.cd.value=sheetObj.Cellvalue(Row,Col);                       
//                      //sheetObj.WaitImageVisible = false; // Don't show wait image while processing 
//                      var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));               
//                      var arrData = ComPriXml2ComboString(sXml, "cd", "nm");                  
//                      if (arrData[1] != ""){
//                          sheetObj.CellValue2(Row,"loc_des") = arrData[1];
//                          sheetObj.CellValue2(Row,"rout_pnt_loc_tp_cd") = "C" ;
//                      }else{
//                          ComShowCodeMessage("PRI00315");
//                          locationCellClear(sheetObj,Row);
//                      }                   
//                  }else if(Value.length==5){
//                      formObj.f_cmd.value = SEARCH05;
//                      formObj.cd.value=sheetObj.Cellvalue(Row,Col);   
//                      var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));               
//                      var arrData = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");                 
//                      if (arrData != null && arrData.length > 0) {
//                          sheetObj.CellValue2(Row, "loc_des") = arrData[0][1];
//                          sheetObj.CellValue2(Row,"rout_pnt_loc_tp_cd") = "L" ;
//                      }else{      
//                          ComShowCodeMessage("PRI00315");
//                          locationCellClear(sheetObj,Row);
//                      }   
//                  }else{
//                      ComShowCodeMessage("PRI00315");
//                      locationCellClear(sheetObj,Row);
//              
//                  }
//                  break;
//              case "rout_pnt_loc_tp_cd":          
//                  locationCellClear(sheetObj,Row);
//                  break;      
            }
        }  
        /**
         * Initializing sheet's specific cell value <br>
         * <br><b>Example :</b>
         * <pre>
         *      locationCellClear(sheetObj,Row)
         * </pre>
         * @param {ibsheet} sheetObj mandatory IBSheet Object
         * @param {int} Row Mandatory ,Cell Row Index    
         * @return void
         * @author 
         * @version 2009.04.17
         */         
        function locationCellClear(sheetObj,Row){
            sheetObj.SetCellValue(Row,"dtl_loc_def_cd","",0);
            sheetObj.SetCellValue(Row,"loc_des","",0);
            sheetObj.SetCellValue(Row,"dtl_loc_tp_cd","",0);
            sheetObj.SelectCell(Row,"dtl_loc_def_cd");
        }    
        /**
         * Reset Whole objects in screen.<br>
         * Save in case of modified data.
         * <br><b>Example :</b>
         * <pre>
         *     searchConditionReset(formObj,gubun)
         * </pre>
         * @param {form} formObj 
         * @param {String} gubun    
         * @return void
         * @author 
         * @version 2009.06.10
         */
        function removeAll(formObj) {
            if (sheetObjects[1].IsDataModified()|| sheetObjects[2].IsDataModified()) {
                if (ComShowCodeConfirm("PRI00006")) {
                    supressConfirm=true;
                    doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
                    supressConfirm=false;
                } else {
                    comboObjects[0].SetSelectIndex("-1");
                    comboObjects[1].SetSelectIndex("-1");
                    formObj.reset();
                    sheetObjects[1].RemoveAll();
                    sheetObjects[2].RemoveAll();
                }
            } else {    
                comboObjects[0].SetSelectIndex("-1");
                comboObjects[1].SetSelectIndex("-1");
                formObj.reset();
                sheetObjects[1].RemoveAll();
                sheetObjects[2].RemoveAll();
            }
        }
        /**
         * Reset the search condition. <br>
         * Save in case of modified data.
         * <br><b>Example :</b>
         * <pre>
         *     searchConditionReset(formObj,gubun)
         * </pre>
         * @param {form} formObj 
         * @param {String} gubun    
         * @return void
         * @author 
         * @version 2009.06.10
         */
        function searchConditionReset(formObj) {
            comboObjects[1].SetSelectIndex("-1");
            formObj.chg_nm.value="";  
            sheetObjects[1].RemoveAll();
            sheetObjects[2].RemoveAll();
        }
        /**
         * Execute when cell on sheet clicked. <br>
         * <br><b>Example :</b>
         * <pre>
         *     sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
         * </pre>
         * @param {ibsheet} sheetObj mandatory IBSheet Object
         * @param {int} OldRow 
         * @param {int} OldCol 
         * @param {int} NewRow 
         * @param {int} NewCol 
         * @return void
         * @author 
         * @version 2009.04.17
         */
        function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
            doRowChange(sheetObjects[1], sheetObjects[2], OldRow, NewRow, OldCol, NewCol, false);
        }
        var isFiredNested=false;
        var supressConfirm=false;
        /**
         * It calls when OnSelectCell event triggered on sheet1. <br>
         * when you had modified data and tried to move focus to other cells, it shows save-notice message <br>
         * When you don't save yet, Move the focus to modified Cell by forced.<br>
         * 
         * <br><b>Example :</b>
         * <pre>
         *     doRowChange(OldRow, NewRow, OldCol, NewCol, sAction)
         * </pre>
         * @param {ibsheet} sheetObj mandatory IBSheet Object
         * @param {int} OldRow 
         * @param {int} OldCol 
         * @param {int} NewRow 
         * @param {int} NewCol 
         * @param {String} sAction
         * @return void
         * @author 
         * @version 2009.04.17
         */
        function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
            var formObj=document.form;
            var adjNewRow=NewRow;
            if (!isFiredNested && (OldRow != NewRow)) {
                if (sheetM.IsDataModified()) {
                    isFiredNested=true;
                    sheetM.SelectCell(OldRow, OldCol, false);
                    isFiredNested=false;
                    if (validateForm(sheetM,document.form,IBSAVE)) {
                        isFiredNested=true;
                        sheetM.SelectCell(NewRow, NewCol, false);
                        isFiredNested=false;
                    } else {
                        isFiredNested=true;
                        sheetM.SelectCell(OldRow, OldCol, false);
                        isFiredNested=false;
                        return -1;
                    }
                }
                if (sheetD.IsDataModified()) {
                    isFiredNested=true;
                    sheetM.SelectCell(OldRow, OldCol, false);
                    isFiredNested=false;
                    var rslt=false;
                    if (ComShowCodeConfirm("PRI00006")) {
                        supressConfirm=true;
                        adjNewRow = Math.max(NewRow - sheetM.RowCount("D"), sheetM.HeaderRows());
                        var rslt=doActionIBSheet(sheetM,document.form,IBSAVE);
                        supressConfirm=false;
                    }
                    if (rslt) {
                        isFiredNested=true;
                        sheetM.SelectCell(adjNewRow, NewCol, false);
                        isFiredNested=false;
                    } else {
                        isFiredNested=true;
                        sheetM.SelectCell(OldRow, OldCol, false);
                        isFiredNested=false;
                        return -1;
                    }
                }
                if (appendRow) {
                    isFiredNested=true;
                    var idx=sheetM.DataInsert(-1);
                    isFiredNested=false;
                    return idx;
                } else {
                    formObj.f_cmd.value=SEARCH02;
                    formObj.grp_loc_seq.value=sheetM.GetCellValue(NewRow,"grp_loc_seq");
                    if(formObj.grp_loc_seq.value == "undefined" || ComIsEmpty(formObj.grp_loc_seq.value)) {
                    	formObj.grp_loc_seq.value=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"grp_loc_seq");
                    }
                    try {
         			  	ComOpenWait(true);
	                    if (formObj.pre_svc_scp_cd.value != "") {
	                    	sheetD.DoSearch("ESM_PRI_4028GS.do", FormQueryString(formObj), {Sync:2} );
	                    } else {
	                    	sheetD.DoSearch("ESM_PRI_4004GS.do", FormQueryString(formObj), {Sync:2} );
	                    }
	                    ComOpenWait(false);
   				   } catch (e) {
         	            if (e == "[object Error]") {
         	                ComShowMessage(OBJECT_ERROR);
         	            } else {
         	                ComShowMessage(e.message);
         	            }
         	       } finally {
         	    	   ComOpenWait(false);
         	       }	
                }
            }
        }
        /**
	     * Execute before click the check button on sheet. <br>
	     * 
	     * <br><b>Example :</b>
	     * <pre>
	     *     
	     * </pre>
	     * @param {ibsheet} sheetObj mandatory IBSheet Object
	     * @param {String} Row 
	     * @param {String} Col 
	     * @return void
	     * @author 
	     * @version 2009.04.17
	     */
        function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
            var colName=sheetObj.ColSaveName(Col);
            if (colName == "chk") {
                ComPriCheckWithPnS(sheetObjects.slice(1, 3), 0, Row, Col);
            }
        }
        /**
	     * Execute before click the check button on sheet. <br>
	     * 
	     * <br><b>Example :</b>
	     * <pre>
	     *     
	     * </pre>
	     * @param {ibsheet} sheetObj mandatory IBSheet Object
	     * @param {String} Row 
	     * @param {String} Col 
	     * @return void
	     * @author 
	     * @version 2009.04.17
	     */
        function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
            var colName=sheetObj.ColSaveName(Col);
            if (colName == "chk") {
                ComPriCheckWithPnS(sheetObjects.slice(1, 3), 1, Row, Col);
            }
        } 
        /**
         * When retrieves data, set the max sequence from etc-data. <br>
         * <br><b>Example :</b>
         * <pre>
         *     
         * </pre>
         * @param {String} ErrMsg 
         * @return void
         * @author 
         * @version 2009.04.17
         */
        function sheet1_OnSearchEnd(sheetObj, Code, ErrMsg)  {
            if (Code == 0) {
                var formObj=document.form;
                formObj.max_seq.value=sheetObjects[1].GetEtcData("max_seq");
            }
        }
        
        /**
         * calling function when occurring OnSaveEnd event <br>
         * @param {ibsheet} sheetObj mandatory IBSheet Object
         * @param {string} ErrMsg mandatory from server
         * @return void
         * @author 
         * @version 2014.12.19
         */ 	
     	function sheet2_OnSaveEnd(sheetObj, Code, ErrMsg)  {
         	if(Code >= 0) {
         		 doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
         	}
        }     	        
