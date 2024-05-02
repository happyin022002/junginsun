/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_4003.js
 *@FileTitle  : Surcharge Creation
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/04
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
     * @extends
     * @class ESM_PRI_4003 : Business Script for ESM_PRI_4003
     */

    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var defaultPageRows = 100;
    var SearCondition = null;
    
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
     * @version 2009.06.04
     */
    function processButtonClick() {
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        var sheetObject4=sheetObjects[3];
        /** **************************************************** */
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch (srcName) {
                case "btn_loc_grp_pop":
                    var sUrl="/opuscntr/ESM_PRI_4028.do?is_popup=Y&pre_svc_scp_cd="
                        + comboObjects[0].GetSelectCode()+ "&pre_chg_cd="
                        + comboObjects[1].GetSelectCode();
                    ComOpenPopup(sUrl, 1200, 610, "", "1,0", true);
                    break;
                case "btn_retrieve":
                    doActionIBSheet(sheetObject2, formObject, IBSEARCH);
                    break;
                case "btn_new":
                    comboObjects[0].SetSelectCode('-1',false);
                    comboObjects[1].SetSelectCode('-1',false);
                    comboObjects[2].SetSelectCode('-1',false);
                    formObject.flt_pct_tp_cd[0].checked=true;
                    formObject.por_use_flg.Checked=true;
                    formObject.pol_use_flg.Checked=true;
                    formObject.pod_use_flg.Checked=true;
                    formObject.del_use_flg.Checked=true;
                    ComClearManyObjects(formObject.svc_scp_nm, formObject.chg_nm,
                            formObject.upd_dt, formObject.imdg_clss_use_flg,
                            formObject.sub_trd_use_flg, formObject.slan_use_flg,
                            formObject.ts_port_use_flg);
                    ComClearManyObjects(formObject.tml_use_flg,
                            formObject.trns_mod_use_flg,
                            formObject.usa_svc_mod_use_flg, formObject.cnl_tz_flg, 
                            formObject.rcv_de_term_use_flg, formObject.hngr_bar_use_flg);
                    ComClearManyObjects(formObject.dir_call_use_flg,
                            formObject.cgo_wgt_use_flg, formObject.cmdt_use_flg,
                            formObject.gri_cmdt_use_flg, formObject.soc_use_flg,
                            formObject.io_ga_use_flg);
                    ComClearManyObjects(formObject.por_def_cd, formObject.pol_def_cd,
                            formObject.pod_def_cd, formObject.del_def_cd,
                            formObject.eff_dt);
                    ComEnableManyObjects(true, formObject.por_use_flg,
                            formObject.pol_use_flg, formObject.pod_use_flg,
                            formObject.del_use_flg, formObject.imdg_clss_use_flg,
                            formObject.sub_trd_use_flg);
                    ComEnableManyObjects(true, formObject.sub_trd_use_flg,
                            formObject.slan_use_flg, formObject.ts_port_use_flg,
                            formObject.dir_call_use_flg, formObject.tml_use_flg,
                            formObject.trns_mod_use_flg);
                    ComEnableManyObjects(true, formObject.usa_svc_mod_use_flg,
                            formObject.rcv_de_term_use_flg, formObject.hngr_bar_use_flg,
                            formObject.cnl_tz_flg, formObject.cgo_wgt_use_flg, 
                            formObject.cmdt_use_flg);
                    ComEnableManyObjects(true, formObject.gri_cmdt_use_flg,
                            formObject.soc_use_flg, formObject.io_ga_use_flg, formObject.esvc_use_flg);
                    formObject.prc_cgo_tp_cd_1[0].checked=false;
                    formObject.prc_cgo_tp_cd_1[1].checked=false;
                    formObject.prc_cgo_tp_cd_1[2].checked=false;
                    formObject.prc_cgo_tp_cd_1[3].checked=false;
                    formObject.prc_cgo_tp_cd_1[4].checked=false;
                    comboObjects[3].SetSelectCode('-1',false);
                    sheet2_Reset();
                    sheetObjects[2].RemoveAll();
                    
                    sheetObjects[2].SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
                    break;
                case "btn_save":
                    doActionIBSheet(sheetObject2, formObject, IBSAVE);
                    break;
                case "btn_delete1":
                    doActionIBSheet(sheetObject2, formObject, IBDELETE);
                    break;
                case "btn_copy":
                    doActionIBSheet(sheetObject3, formObject, IBCOPYROW);
                    break;
                case "btn_add":
                    doActionIBSheet(sheetObject3, formObject, IBINSERT);
                    break;
                case "btn_delete2":
                    doActionIBSheet(sheetObject3, formObject, IBRESET);
                    break;
                case "btn_downexcel":
                    doActionIBSheet(sheetObject3, formObject, IBDOWNEXCEL);
                    break;
                case "btn_loadexcel":
                    doActionIBSheet(sheetObject3, formObject, IBLOADEXCEL);
                    break;
                case "btns_calendar": //Calendar Button
                    var cal=new ComCalendar();                
                    cal.select(formObject.eff_dt, 'yyyy-MM-dd');
                    break;
                    
                case "btn_select_all": 	//Select all
                	var header_all = "por_use_flg|pol_use_flg|pod_use_flg|del_use_flg|rcv_de_term_use_flg|imdg_clss_use_flg|cnl_tz_flg|cgo_wgt_use_flg|trns_mod_use_flg|hngr_bar_use_flg|sub_trd_use_flg|slan_use_flg|dir_call_use_flg|tml_use_flg|cmdt_use_flg|io_ga_use_flg|ts_port_use_flg|soc_use_flg|gri_cmdt_use_flg|usa_svc_mod_use_flg|"
                    var arrRow=header_all.split("|");                	
                	for(var i = 0 ; i < arrRow.length-1 ; i++){
                		var objName=eval("form." + arrRow[i]);
                		objName.checked=true;
                		
                		var sheetCellName = "";
                		var sheetCellName2 = "";
                		if(arrRow[i] == "por_use_flg"){
                			sheetCellName = "por_def_cd";                			
                		}else if(arrRow[i] == "pol_use_flg"){
                			sheetCellName = "pol_def_cd";
                		}else if(arrRow[i] == "pod_use_flg"){
                			sheetCellName = "pod_def_cd";
                		}else if(arrRow[i] == "del_use_flg"){
                			sheetCellName = "del_def_cd";
                		}else if(arrRow[i] == "imdg_clss_use_flg"){
                			sheetCellName = "scg_imdg_clss_cd";
                		}else if(arrRow[i] == "sub_trd_use_flg"){
                			sheetCellName = "sub_trd_cd";
                		}else if(arrRow[i] == "slan_use_flg"){
                			sheetCellName = "vsl_slan_cd";
                		}else if(arrRow[i] == "ts_port_use_flg"){
                			sheetCellName = "ts_port_cd";
                		}else if(arrRow[i] == "dir_call_use_flg"){
                			sheetCellName = "dir_call_flg";
                		}else if(arrRow[i] == "tml_use_flg"){
                			sheetCellName = "tml_cd";
                		}else if(arrRow[i] == "usa_svc_mod_use_flg"){
                			sheetCellName = "usa_svc_mod_cd";
                		}else if(arrRow[i] == "hngr_bar_use_flg"){
                			sheetCellName = "prc_hngr_bar_tp_cd";
                		}else if(arrRow[i] == "cmdt_use_flg"){
                			sheetCellName = "cmdt_cd";
                		}else if(arrRow[i] == "gri_cmdt_use_flg"){
                			sheetCellName = "scg_grp_cmdt_cd";
                		}else if(arrRow[i] == "soc_use_flg"){
                			sheetCellName = "soc_flg";                			
                		}else if(arrRow[i] == "io_ga_use_flg"){
                			sheetCellName = "io_ga_cd";                   			
                		}else if(arrRow[i] == "cnl_tz_flg"){
                			sheetCellName = "cnl_tz_cd";                 			
                		}else if(arrRow[i] == "trns_mod_use_flg"){
                			sheetCellName = "org_trsp_mod_cd";
                			sheetCellName2 = "dest_trsp_mod_cd";
                		}else if(arrRow[i] == "rcv_de_term_use_flg"){
                			sheetCellName = "prc_rcv_term_cd";
                			sheetCellName2 = "prc_de_term_cd";
                		}else if(arrRow[i] == "cgo_wgt_use_flg"){
                			sheetCellName = "min_cgo_wgt";
                			sheetCellName2 = "max_cgo_wgt";
                		}
                		else if(arrRow[i] == "esvc_use_flg"){
                			sheetCellName = "bkg_esvc_tp_cd";
                		}
                		mappingFormToSheet2(arrRow[i], sheetCellName);
                		if(sheetCellName2 != ""){
                			mappingFormToSheet2(arrRow[i], sheetCellName2);
                		}
                        mappingFormToSheet1(arrRow[i]);
                	}
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
     * @version 2009.06.04
     */
    function setSheetObject(sheet_obj) {
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * registering IBMultiCombo Object as list <br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_Obj);
     * </pre>
     * @param {ibcombo} combo_obj Mandatory IBMultiCombo Object
     * @return void
     * @author 
     * @version 2009.06.04
     */
    function setComboObject(combo_obj) {
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
     * @version 2009.06.04
     */
    function loadPage() {
        for (i=0; i < sheetObjects.length; i++) {
            // Modifying Environment Setting Function name
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i + 1);
            // Add Environment Setting Function 
            ComEndConfigSheet(sheetObjects[i]);
        }
        // IBMultiCombo Initialize
        for ( var k=0; k < comboObjects.length; k++) {
            initCombo(comboObjects[k], k + 1);
        }
        
        initControl();
        sheet2_Reset();
        initIBComboItem();  // Setting item to IBCombo
        ComBtnDisable("btn_loadexcel");
        form.eff_dt.value=ComGetNowInfo('ymd', '-');
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
     * @version 2009.06.04
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        var sheetid=sheetObj.id;
        switch (sheetid) {
            case "sheet0":
                with(sheetObj){
                    SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );
                    var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                    var headers = [ { Text:"", Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
                    InitColumns(cols);
                    
                    SetWaitImageVisible(0);
                }
               break;
            case "sheet1":
                with(sheetObj){
                    var HeadTitle="stat|flt_ptc_tp_cd|pct_bse_cd|por|pol|pod|del|rcv_de_term|imdg|canal|cgo_wgt|trns_mod|hngr_bar|sub|slan|dir_call|tml|cmdt|gauge|ts_port|soc|gri_cmdt|usa_svc|esvc_use";
                    var headCount=ComCountHeadTitle(HeadTitle);
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:defaultPageRows, DataRowMerge:1 } );
                    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                      var cols = [ {Type:"Status",    Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"flt_pct_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pct_bse_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"por_use_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_use_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_use_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_use_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rcv_de_term_use_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_use_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cnl_tz_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cgo_wgt_use_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trns_mod_use_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"hngr_bar_use_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_use_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"slan_use_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dir_call_use_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"tml_use_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_use_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"io_ga_use_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ts_port_use_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"soc_use_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"gri_cmdt_use_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"usa_svc_mod_use_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"esvc_use_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
                       
                    InitColumns(cols);
                    SetEditable(0);
                    SetWaitImageVisible(0);
                    SetAutoRowHeight(0);
                }
                break;
            case "sheet2":
                with(sheetObj){
                    var HeadTitle1="|Sel.|Seq|POR|POL|POD|DEL|PER|Cargo\nType|IMDG\nClass|Cur.|Amount|Pay Term|Effective\nDate|Expiration\nDate|Canal|Weight|Weight|Trans. Mode|Trans. Mode|R/D Term|R/D Term|Bar Type|Sub-trade|Lane|Direct Call|Terminal|Commodity|In/Out Gauge|T/S Port|Shipper's Own\nContainer(S.O.C)|Commodity\nGroup|US Service\nMode|S/I|Update\nDate|Remark(s)|||||||";
                    var HeadTitle2="|Sel.|Seq|POR|POL|POD|DEL|PER|Cargo\nType|IMDG\nClass|Cur.|Amount|Pay Term|Effective\nDate|Expiration\nDate|Canal|MIN <= TON|MAX > TON|Origin|Dest|Origin|Dest|Bar Type|Sub-trade|Lane|Direct Call|Terminal|Commodity|In/Out Gauge|T/S Port|Shipper's Own\nContainer(S.O.C)|Commodity\nGroup|US Service\nMode|S/I|Update\nDate|Remark(s)|||||||";
                    var headCount=ComCountHeadTitle(HeadTitle1);
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, ComboMaxHeight:250} );
                    //SetConfig( { SearchMode:2, MergeSheet:1, FrozenCol:1 ,Page:20, DataRowMerge:0} );
                    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                     {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"por_def_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,  AcceptKeys:"E", InputCaseSensitive:1 },
                     {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_def_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,  AcceptKeys:"E", InputCaseSensitive:1 },
                     {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_def_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,  AcceptKeys:"E", InputCaseSensitive:1 },
                     {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_def_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,  AcceptKeys:"E", InputCaseSensitive:1 },
                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"prc_cgo_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"scg_imdg_clss_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"scg_amt",             KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pay_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Date",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                     {Type:"Date",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnl_tz_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"min_cgo_wgt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"Float",     Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"max_cgo_wgt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"org_trsp_mod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dest_trsp_mod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"prc_rcv_term_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"prc_de_term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"prc_hngr_bar_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vsl_slan_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dir_call_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"tml_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
                     {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"io_ga_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ts_port_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                     {Type:"Combo",     Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"soc_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"scg_grp_cmdt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"usa_svc_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_esvc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Date",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:240,  Align:"Left",    ColMerge:1,   SaveName:"scg_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"chg_cd" },
                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"scg_seq" },
                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"por_tp_cd" },
                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pol_tp_cd" },
                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pod_tp_cd" },
                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_tp_cd" } ];
                       
                    InitColumns(cols);
                    resizeSheet(); //SetSheetHeight(250);
                    SetEditable(1);
                    SetWaitImageVisible(0);
                    SetColProperty(0 ,"por_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
                    SetColProperty(0 ,"pol_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
                    SetColProperty(0 ,"pod_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
                    SetColProperty(0 ,"del_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
                    SetColProperty("org_trsp_mod_cd", {ComboText:orgTrspModCdText, ComboCode:orgTrspModCdValue} );
                    SetColProperty("dest_trsp_mod_cd", {ComboText:destTrspModCdText, ComboCode:destTrspModCdValue} );
                    SetColProperty("usa_svc_mod_cd", {ComboText:usaSvcModCdText, ComboCode:usaSvcModCdValue} );
                    SetColProperty("prc_rcv_term_cd", {ComboText:prcRcvTermCdText, ComboCode:prcRcvTermCdValue} );
                    SetColProperty("prc_de_term_cd", {ComboText:prcDeTermCdText, ComboCode:prcDeTermCdValue} );
                    SetColProperty("prc_hngr_bar_tp_cd", {ComboText:prcHngrBarTpCdText, ComboCode:prcHngrBarTpCdValue} );
                    SetColProperty("pay_term_cd", {ComboText:payTermCdText, ComboCode:payTermCdValue} );
                    SetColProperty("rat_ut_cd", {ComboText:ratUtCdText, ComboCode:ratUtCdValue} );
                    SetColProperty("prc_cgo_tp_cd", {ComboText:prcCgoTpCdText, ComboCode:prcCgoTpCdValue} );
                    SetColProperty("scg_imdg_clss_cd", {ComboText:scgImdgClssCdText, ComboCode:scgImdgClssCdValue} );
                    SetColProperty("curr_cd", {ComboText:currCdText, ComboCode:currCdValue} );
                    SetColProperty("dir_call_flg", {ComboText:dirCallFlgText, ComboCode:dirCallFlgValue} );
                    SetColProperty("soc_flg", {ComboText:socFlgText, ComboCode:socFlgValue} );
                    SetColProperty("io_ga_cd", {ComboText:ioGaCdText, ComboCode:ioGaCdValue} );
                    SetColProperty("sub_trd_cd", {ComboText:subTrdCdText, ComboCode:subTrdCdValue} );
                    SetColProperty("cnl_tz_cd", {ComboText:cnlTzCdText, ComboCode:cnlTzCdValue} );
                    SetColProperty("bkg_esvc_tp_cd", {ComboText:bkgEsvcTpCdComboText, ComboCode:bkgEsvcTpCdComboValue} );
                    //SetAutoRowHeight(0);
                }
                break;
            case "sheet3": //Sheet to check duplication
                with(sheetObj){
                    var HeadTitle1="Seq|POR|POL|POD|DEL|PER|Cargo\nType|IMDG\nClass|Cur.|Pay Term|Canal|Weight|Weight|Trans. Mode|Trans. Mode|R/D Term|R/D Term|Bar Type|Sub-trade|Lane|Direct Call|Terminal|Commodity|In/Out Gauge|T/S Port|Shipper's Own\nContainer(S.O.C)|Commodity\nGroup|US Service\nMode|Del\nMark|Amount|Effective\nDate|Expiration\nDate|S/I";
                    var HeadTitle2="Seq|POR|POL|POD|DEL|PER|Cargo\nType|IMDG\nClass|Cur.|Pay Term|Canal|MIN <= TON|MAX > TON|Origin|Dest|Origin|Dest|Bar Type|Sub-trade|Lane|Direct Call|Terminal|Commodity|In/Out Gauge|T/S Port|Shipper's Own\nContainer(S.O.C)|Commodity\nGroup|US Service\nMode|Del\nMark|Amount|Effective\nDate|Expiration\nDate|S/I";
                    var headCount=ComCountHeadTitle(HeadTitle2);
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ 
                     {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"por_def_cd" },
                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_def_cd" },
                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_def_cd" },
                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_def_cd" },
                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd" },
                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"prc_cgo_tp_cd" },
                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"scg_imdg_clss_cd" },
                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd" },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pay_term_cd" },
                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnl_tz_cd" },
                     {Type:"Text",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"min_cgo_wgt" },
                     {Type:"Text",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"max_cgo_wgt" },
                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"org_trsp_mod_cd" },
                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dest_trsp_mod_cd" },
                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"prc_rcv_term_cd" },
                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"prc_de_term_cd" },
                     {Type:"Text",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"prc_hngr_bar_tp_cd" },
                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd" },
                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vsl_slan_cd" },
                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dir_call_flg" },
                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"tml_cd" },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd" },
                     {Type:"Text",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"io_ga_cd" },
                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ts_port_cd" },
                     {Type:"Text",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"soc_flg" },
                     {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"scg_grp_cmdt_cd" },
                     {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"usa_svc_mod_cd" },
                     {Type:"Text",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"scg_amt" },
                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt" },
                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt" },
                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_esvc_tp_cd" }];
                       
                    InitColumns(cols);
                    SetEditable(0);
                    SetWaitImageVisible(0);
                }
                break;
        }
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[2]);
    }

    function callbackpor(rtnVal) {
        if (rtnVal != null) {
            sheet2.SetCellValue(sheet2.GetSelectRow(), sheet2.GetSelectCol(),rtnVal.cd,0);
            sheet2.SetCellValue(sheet2.GetSelectRow(), "por_tp_cd",rtnVal.tp,0);
        }
    }

    function callbackpol(rtnVal) {
        if (rtnVal != null) {
            sheet2.SetCellValue(sheet2.GetSelectRow(), sheet2.GetSelectCol(),rtnVal.cd,0);
            sheet2.SetCellValue(sheet2.GetSelectRow(), "pol_tp_cd",rtnVal.tp,0);
        }
    }

    function callbackpod(rtnVal) {
        if (rtnVal != null) {
            sheet2.SetCellValue(sheet2.GetSelectRow(), sheet2.GetSelectCol(),rtnVal.cd,0);
            sheet2.SetCellValue(sheet2.GetSelectRow(), "pod_tp_cd",rtnVal.tp,0);
        }
    }

    function callbackdel(rtnVal) {
        if (rtnVal != null) {
            sheet2.SetCellValue(sheet2.GetSelectRow(), sheet2.GetSelectCol(),rtnVal.cd,0);
            sheet2.SetCellValue(sheet2.GetSelectRow(), "del_tp_cd",rtnVal.tp,0);
        }
    }

    function callbackts(rtnVal) {
        if (rtnVal != null) {
            sheet2.SetCellValue(sheet2.GetSelectRow(), sheet2.GetSelectCol(),rtnVal.cd,0);
        }
    }

    function callbackcmdt(rtnVal) {
        if (rtnVal != null) {
            sheet2.SetCellValue(sheet2.GetSelectRow(), sheet2.GetSelectCol(),rtnVal.cd,0);
            if (rtnVal.cd.length == 6) {
                tpCd="C";
            }
        }
    }

    /**
     * It calls when OnPopupClick event triggered on sheet2 <br>
     * calling popup window <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col mandatory Onclick ,Cell's Column Index
     * @return void
     * @author 
     * @version 2009.06.04
     */
    function sheet2_OnPopupClick(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        var sSvcScpCd=sheetObj.GetCellValue(Row, "svc_scp_cd");
        var sChgCd=sheetObj.GetCellValue(Row, "chg_cd");
        if (colName == "por_def_cd") { //POR
            var sUrl="/opuscntr/ESM_PRI_4026.do?group_cmd=" + PRI_SCG
                    + "&location_cmd=LGRC&svc_scp_cd=" + sSvcScpCd + "&chg_cd="
                    + sChgCd;
            ComOpenPopup(sUrl, 700, 310, "callbackpor", "1,0", true);
        } else if (colName == "pol_def_cd") { //POL
            var sUrl="/opuscntr/ESM_PRI_4026.do?group_cmd=" + PRI_SCG
                    + "&location_cmd=LGRC&svc_scp_cd=" + sSvcScpCd + "&chg_cd="
                    + sChgCd;
            ComOpenPopup(sUrl, 700, 310, "callbackpol", "1,0", true);
        } else if (colName == "pod_def_cd") { //POD
            var sUrl="/opuscntr/ESM_PRI_4026.do?group_cmd=" + PRI_SCG
                    + "&location_cmd=LGRC&svc_scp_cd=" + sSvcScpCd + "&chg_cd="
                    + sChgCd;
            ComOpenPopup(sUrl, 700, 310, "callbackpod", "1,0", true);
        } else if (colName == "del_def_cd") { //DEL
            var sUrl="/opuscntr/ESM_PRI_4026.do?group_cmd=" + PRI_SCG
                    + "&location_cmd=LGRC&svc_scp_cd=" + sSvcScpCd + "&chg_cd="
                    + sChgCd;
            ComOpenPopup(sUrl, 700, 310, "callbackdel", "1,0", true);
        } else if (colName == "ts_port_cd") { //ts port
            var sUrl="/opuscntr/ESM_PRI_4026.do?group_cmd=" + PRI_SCG
                    + "&location_cmd=L";
            ComOpenPopup(sUrl, 700, 310, "callbackts", "1,0", true);
        } else if (colName == "tml_cd") { //Terminal Code
            var tmlCd=sheetObj.GetCellValue(Row, Col);
//            var display='0,0,1,1,1,1,1,1,1,1,1,1';
            var param='?mode=yard&node_cd='+tmlCd;
            // Common Use Popup Calling
            ComPriOpenPopup('/opuscntr/COM_ENS_061.do' + param, 780, 530, 'callBackTerminalCode', "1,0,1,1,1", true);
        } else if (colName == "cmdt_cd") { //commodity
            var sUrl="/opuscntr/ESM_PRI_4027.do?grp_cd=" + PRI_SCG
                    + "&commodity_cmd=C&svc_scp_cd=" + sSvcScpCd + "&chg_cd="
                    + sChgCd;
            ComOpenPopup(sUrl, 700, 345, "callbackcmdt", "1,0", true);
        }
    }
    /**
     * Calling function when Terminal Code popup is closed. <br>
     * Display the code from popup. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {String} locTp Mandatory location classification (Not Use)
     * @param {array} rArray Code Value array
     * @return void
     * @author 
     * @version 2009.06.04
     */
    function callBackTerminalCode(rowArray){
         var colArray=rowArray[0];
         if(rowArray != null) {
             sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "tml_cd",colArray[3]);
         } else {
             sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "tml_cd","");
         }
    }
    /**
     * It calls when OnChange event triggered on sheet2 <br>
     * when selecting multi comboBox, showing description and retrieveing validation <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col mandatory Onclick ,Cell's Column Index
     * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.06.04
     */
    function sheet2_OnChange(sheetObj, Row, Col, Value) {
        var formObj=document.form;
        var sName=sheetObj.ColSaveName(Col);
        var sSvcScpCd=sheetObj.GetCellValue(Row, "svc_scp_cd");
        var sChgCd=sheetObj.GetCellValue(Row, "chg_cd");
        switch (sName) {
            case "por_def_cd":
                checkLocation(sheetObj, Row, "por_tp_cd", "por_def_cd");
                break;
            case "pol_def_cd":
                checkLocation(sheetObj, Row, "pol_tp_cd", "pol_def_cd");
                break;
            case "pod_def_cd":
                checkLocation(sheetObj, Row, "pod_tp_cd", "pod_def_cd");
                break;
            case "del_def_cd":
                checkLocation(sheetObj, Row, "del_tp_cd", "del_def_cd");
                break;
            case "ts_port_cd":
                checkTSPort(sheetObj, Row, Value);
                break;
            case "tml_cd":
                checkTerminalCode(sheetObj, Row, Value);
                break;
            case "cmdt_cd":
                checkCommodity(sheetObj, Row, Value);
                break;
            case "rat_ut_cd":
                checkPerType(sheetObj, Row, Value);

                break;
            case "prc_cgo_tp_cd":
                checkCargoType(sheetObj, Row, Value);
                break;
            case "scg_amt":
                if (Value == 0) {
                    sheetObj.InitCellProperty(Row, Col,{ Type:"Data",Align:"Right",Format:"dfInteger"} );
                } else {
                    sheetObj.InitCellProperty(Row, Col,{ Type:"Data",Align:"Right",Format:"dfFloat",PointCount:2,EditLen:11} );
                }
                break;
            case "eff_dt":
                checkDatePeriod(sheetObj, Row, "eff_dt");
                break;
            case "exp_dt":
                checkDatePeriod(sheetObj, Row, "exp_dt");
                break;
        }
    }

    
    /**
     * eff_dt & exp_dt Validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {String} colName Mandatory Onclick Cell's Column Name
     * @return void
     * @author 
     * @version 2009.06.04
     */
    function checkDatePeriod(sheetObj, Row, colName) {
        var effDt=sheetObj.GetCellValue(Row, "eff_dt");
        var expDt=sheetObj.GetCellValue(Row, "exp_dt");
        if(ComIsNull(effDt) || ComIsNull(expDt)) {
            return;
        }
        if(ComChkPeriod(sheetObj.GetCellValue(Row, "eff_dt"), sheetObj.GetCellValue(Row, "exp_dt")) < 1) {
            ComShowCodeMessage('PRI00306');
            sheetObj.SetCellValue(Row, colName,"",0);
            sheetObj.SelectCell(Row, colName);
        }
    }
    /**
     * Calling function in case of Onclick event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col mandatory Onclick ,Cell's Column Index
     * @param {string} Value Mandatory Value
     * @returns void
     * @author 
     * @version 2009.06.04
     */
    function sheet2_OnClick(sheetObj, Row, Col, Value) {
        //Showing Memopad in case of Clicking desc cell(MemoPad : Editable)
        var colname=sheetObj.ColSaveName(Col);
        switch (colname) {
        case "scg_rmk":
            ComShowMemoPad(sheetObj,Row, Col,false, 200, 200,1000,1);
            break;
        }
    }
    /**
     * Loading HTML control's event on page dynamically<br>
     * <br><b>Example :</b>
     * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
     * @return void
     * @author 
     * @version 2009.06.04
     **/
    function initControl() {
        //** Date delimiter **/
        DATE_SEPARATOR="/";
        axon_event.addListenerForm('click', 'obj_click', form);
        axon_event.addListenerForm('blur', 'obj_blur', form);
        axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
        axon_event.addListenerFormat('keypress', 'obj_keypress', form); 
    }
    /**
     * Setting retrieved items to IBMultiCombo<br>
     * <br><b>Example :</b>
     * <pre>
     *     initIBComboItem ();
     * </pre>
     * @return void
     * @author 
     * @version 2009.06.04
     */
    function initIBComboItem() {
        ComPriTextCode2ComboItem(svcScpComboValue, svcScpComboText, getComboObject(comboObjects, 'svc_scp_cd'),"|","\t");
        ComPriTextCode2ComboItem(chgCdComboValue, chgCdComboText, getComboObject(comboObjects, 'chg_cd'),"|","\t");
        ComPriTextCode2ComboItem(pctBseCdComboValue, pctBseCdComboText, getComboObject(comboObjects, 'pct_bse_cd'),"|","\t");
        ComPriTextCode2ComboItem(scgImdgClssCdComboValue, scgImdgClssCdComboText, getComboObject(comboObjects, 'scg_imdg_clss_cd'),"|","\t");
    }
    /**
     * Handling OnBeforeActivate event <br>
     * <br>
     * <b>Example :</b>
     * 
     * <pre>
     * obj_activate()
     * </pre>
     * 
     * @param  void
     * @return void
     * @author 
     * @version 2009.12.04
     */
    function obj_activate() {
        var formObj=document.form;
        var srcName=ComGetEvent("name");
        if(srcName == "eff_dt") {
            formObj.eff_dt.value=formObj.eff_dt.value.replace(RegExp(/-/ig), "");
//          } else if(srcName == "exp_dt") {
//              formObj.exp_dt.value = formObj.exp_dt.value.replace(RegExp(/-/ig), "");
        }
    }
    /**
     * Handling Onbeforedeactivate event<br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_deactivate()
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.12.04
     */
    function obj_deactivate() {
        var formObj=document.form;
        var srcName=ComGetEvent("name");
        if(srcName == "eff_dt") {
            var sEffDt=formObj.eff_dt.value;
            if (sEffDt.length >= 8) {
                formObj.eff_dt.value=sEffDt.substring(0, 4) + "-" + sEffDt.substring(4, 6) + "-" + sEffDt.substring(6, 8);
            }
//          } else if(srcName == "exp_dt") {
//              var sExpDt = formObj.exp_dt.value;
//              if (sExpDt.length >= 8) {
//                  formObj.exp_dt.value = sExpDt.substring(0, 4) + "-" + sExpDt.substring(4, 6) + "-" + sExpDt.substring(6, 8);
//              }
        } 
    }
    /**
     * Calling function in case of Onclick event <br>
     * <br><b>Example :</b>
     * <pre>
     *  
     * </pre>
     * @return void
     * @author 
     * @version 2009.06.04
     */
    function obj_click() {
        var sheetObj=sheetObjects[2];
        var formObj=document.form;
        // Select Application Type
        if(ComGetEvent("name") == "flt_pct_tp_cd") {
            setFltPctTpCd(ComGetEvent("value"));
        }
        if (ComGetEvent("name") == "por_use_flg") {
            //checkConfirm("por_use_flg", ComGetEvent("checked"));
            mappingFormToSheet2("por_use_flg", "por_def_cd");
            mappingFormToSheet1("por_use_flg");
        }
        if (ComGetEvent("name") == "pol_use_flg") {
            //checkConfirm("pol_use_flg", ComGetEvent("checked"));
            mappingFormToSheet2("pol_use_flg", "pol_def_cd");
            mappingFormToSheet1("pol_use_flg");
        }
        if (ComGetEvent("name") == "pod_use_flg") {
            //checkConfirm("pod_use_flg", ComGetEvent("checked"));
            mappingFormToSheet2("pod_use_flg", "pod_def_cd");
            mappingFormToSheet1("pod_use_flg");
        }
        if (ComGetEvent("name") == "del_use_flg") {
            //checkConfirm("del_use_flg", ComGetEvent("checked"));
            mappingFormToSheet2("del_use_flg", "del_def_cd");
            mappingFormToSheet1("del_use_flg");
        }
        if (ComGetEvent("name") == "imdg_clss_use_flg") {
            //checkConfirm("imdg_clss_use_flg", ComGetEvent("checked"));
            mappingFormToSheet2("imdg_clss_use_flg", "scg_imdg_clss_cd");
            mappingFormToSheet1("imdg_clss_use_flg");
        }
        if (ComGetEvent("name") == "sub_trd_use_flg") {
            mappingFormToSheet2("sub_trd_use_flg", "sub_trd_cd");
            mappingFormToSheet1("sub_trd_use_flg");
        }
        if (ComGetEvent("name") == "slan_use_flg") {
            mappingFormToSheet2("slan_use_flg", "vsl_slan_cd");
            mappingFormToSheet1("slan_use_flg");
        }
        if (ComGetEvent("name") == "ts_port_use_flg") {
            mappingFormToSheet2("ts_port_use_flg", "ts_port_cd");
            mappingFormToSheet1("ts_port_use_flg");
        }
        if (ComGetEvent("name") == "dir_call_use_flg") {
            mappingFormToSheet2("dir_call_use_flg", "dir_call_flg");
            mappingFormToSheet1("dir_call_use_flg");
        }
        if (ComGetEvent("name") == "tml_use_flg") {
            mappingFormToSheet2("tml_use_flg", "tml_cd");
            mappingFormToSheet1("tml_use_flg");
        }
        if (ComGetEvent("name") == "trns_mod_use_flg") {
            mappingFormToSheet2("trns_mod_use_flg", "org_trsp_mod_cd");
            mappingFormToSheet2("trns_mod_use_flg", "dest_trsp_mod_cd");
            mappingFormToSheet1("trns_mod_use_flg");
        }
        if (ComGetEvent("name") == "usa_svc_mod_use_flg") {
            mappingFormToSheet2("usa_svc_mod_use_flg", "usa_svc_mod_cd");
            mappingFormToSheet1("usa_svc_mod_use_flg");
        }
        if (ComGetEvent("name") == "rcv_de_term_use_flg") {
            mappingFormToSheet2("rcv_de_term_use_flg", "prc_rcv_term_cd");
            mappingFormToSheet2("rcv_de_term_use_flg", "prc_de_term_cd");
            mappingFormToSheet1("rcv_de_term_use_flg");
        }
        if (ComGetEvent("name") == "hngr_bar_use_flg") {
            mappingFormToSheet2("hngr_bar_use_flg", "prc_hngr_bar_tp_cd");
            mappingFormToSheet1("hngr_bar_use_flg");
        }
        if (ComGetEvent("name") == "cgo_wgt_use_flg") {
            mappingFormToSheet2("cgo_wgt_use_flg", "min_cgo_wgt");
            mappingFormToSheet2("cgo_wgt_use_flg", "max_cgo_wgt");
            mappingFormToSheet1("cgo_wgt_use_flg");
        }
        if (ComGetEvent("name") == "cmdt_use_flg") {
            mappingFormToSheet2("cmdt_use_flg", "cmdt_cd");
            mappingFormToSheet1("cmdt_use_flg");
        }
        if (ComGetEvent("name") == "gri_cmdt_use_flg") {
            mappingFormToSheet2("gri_cmdt_use_flg", "scg_grp_cmdt_cd");
            mappingFormToSheet1("gri_cmdt_use_flg");
        }
        if (ComGetEvent("name") == "soc_use_flg") {
            mappingFormToSheet2("soc_use_flg", "soc_flg");
            mappingFormToSheet1("soc_use_flg");
        }
        if (ComGetEvent("name") == "io_ga_use_flg") {
            mappingFormToSheet2("io_ga_use_flg", "io_ga_cd");
            mappingFormToSheet1("io_ga_use_flg");
        }
        if (ComGetEvent("name") == "cnl_tz_flg") {
            mappingFormToSheet2("cnl_tz_flg", "cnl_tz_cd");
            mappingFormToSheet1("cnl_tz_flg");
        }
        if (ComGetEvent("name") == "esvc_use_flg") {
            mappingFormToSheet2("esvc_use_flg", "bkg_esvc_tp_cd");
            mappingFormToSheet1("esvc_use_flg");
        }
    }
    /**
     * calling function in case of OnKeyPress event <br>
     * Only specified characters could input on onkeypress event of HTML Control. <br>
     * <br><b>Example :</b>
     * <pre>
     *  
     * </pre>
     * @return void
     * @author 
     * @version 2009.06.04
     */
    function obj_keypress() {
        switch (ComGetEvent("dataformat")) {
            case "int":
                ComKeyOnlyNumber(ComGetEvent()); // Numeric characters Only
                break;
            case "float":
                ComKeyOnlyNumber(ComGetEvent(), "."); // Numeric and Decimal Point (.) Only
                break;
            case "eng":
                ComKeyOnlyAlphabet('upper'); // Uppercase characters Only
                break;
            default:
                ComKeyOnlyNumber(ComGetEvent()); // Nurmeric Only
        }
    }
    /**
     * calling function in case of OnBlur event. <br>
     * Check validataion on onBlur event of HTML Control. <br>
     * <br><b>Example :</b>
     * <pre>
     *  
     * </pre>
     * @return void
     * @author 
     * @version 2009.06.04
     */
    function obj_blur() {
        var sName=ComGetEvent("name");
        var sValue=ComGetEvent("value");
        switch(sName) {
            case "por_def_cd":
                checkFormLocation(sName, sValue);
                break;
            case "pol_def_cd":
                checkFormLocation(sName, sValue);
                break;
            case "pod_def_cd":
                checkFormLocation(sName, sValue);
                break;
            case "del_def_cd":
                checkFormLocation(sName, sValue);
                break;
        }
    }
    /**
     * Initialize selected columns on sheet2 <br>
     * <br><b>Example :</b>
     * <pre>
     *  
     * </pre>
     * @return void
     * @author 
     * @version 2009.06.04
     */
    function sheet2_ResetCol(colName) {
        var rCnt=sheetObjects[2].RowCount()+ 1;
        for (i=2; i <= rCnt; i++) {
            sheetObjects[2].SetCellValue(i, colName,"",0);
        }
    }

    var iPageNo = 1;
    function sheet2_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
    	var lstTotal = sheetObj.GetEtcData("TOTAL");
    	if(lstTotal == undefined || lstTotal == null) {
    		lstTotal = 0;
    	}
    	if (vpos==oldvpos || !isBottom || sheetObj.RowCount() >= lstTotal || sheetObj.GetTotalRows() != lstTotal) return;
    	
    	if(!isChangeSearchCondition()){
    		ComShowCodeMessage("PRI02020");
    		sheetObj.RemoveAll();
    		sheetObj.SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
    		return;
    	}
    	
        // TODO:sheet에 해당하는 객체와 폼 오브젝트를 doActionIBSheet 함수에 보내 주어야합니다.
        doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo);
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
     * @version 2009.06.04
     */
    function doActionIBSheet(sheetObj, formObj, sAction, isPage, PageNo) {
        //sheetObj.ShowDebugMsg(0);
        try{
            switch (sAction) {
            case IBSEARCH: 
                
                if (!validateForm(sheetObj, formObj, sAction)) {
                    return false;
                } 
                
                //set the condition for SEARCH
                makeSearchCondition();
                
                ComOpenWait(true);
                
                formObj.f_cmd.value=SEARCH02;  
                var sXml=sheetObj.GetSearchData("ESM_PRI_4003GS.do",FormQueryString(formObj));                
                var arrDesc=ComPriXml2Array(
                        sXml,
                        "upd_dt|por_def_cnt|pol_def_cnt|pod_def_cnt|del_def_cnt|scg_imdg_clss_cnt|sub_trd_cnt|vsl_slan_cnt|ts_port_cnt"
                                + "|dir_call_cnt|tml_cnt|trns_mod_cnt|usa_svc_mod_cnt|rcv_de_term_cnt|hngr_bar_cnt|cgo_wgt_cnt|cmdt_cnt|gri_cmdt_cnt|soc_cnt|ig_ga_cnt|cnl_tz_cnt|esvc_cnt");
                
                if (arrDesc != null && arrDesc.length > 0) {
                    formObj.upd_dt.value=arrDesc[0][0];
                    formObj.por_use_flg.disabled=arrDesc[0][1] > 0 ? true:false;
                    formObj.pol_use_flg.disabled=arrDesc[0][2] > 0 ? true:false;
                    formObj.pod_use_flg.disabled=arrDesc[0][3] > 0 ? true:false;
                    formObj.del_use_flg.disabled=arrDesc[0][4] > 0 ? true:false;
                    formObj.imdg_clss_use_flg.disabled=arrDesc[0][5] > 0 ? true:false;
                    formObj.sub_trd_use_flg.disabled=arrDesc[0][6] > 0 ? true:false;
                    formObj.slan_use_flg.disabled=arrDesc[0][7] > 0 ? true:false;
                    formObj.ts_port_use_flg.disabled=arrDesc[0][8] > 0 ? true:false;
                    formObj.dir_call_use_flg.disabled=arrDesc[0][9] > 0 ? true:false;
                    formObj.tml_use_flg.disabled=arrDesc[0][10] > 0 ? true:false;
                    formObj.trns_mod_use_flg.disabled=arrDesc[0][11] > 0 ? true:false;
                    formObj.usa_svc_mod_use_flg.disabled=arrDesc[0][12] > 0 ? true:false;
                    formObj.rcv_de_term_use_flg.disabled=arrDesc[0][13] > 0 ? true:false;
                    formObj.hngr_bar_use_flg.disabled=arrDesc[0][14] > 0 ? true:false;
                    formObj.cgo_wgt_use_flg.disabled=arrDesc[0][15] > 0 ? true:false;
                    formObj.cmdt_use_flg.disabled=arrDesc[0][16] > 0 ? true:false;
                    formObj.gri_cmdt_use_flg.disabled=arrDesc[0][17] > 0 ? true:false;

                    formObj.soc_use_flg.disabled=arrDesc[0][18] > 0 ? true:false;
                    formObj.io_ga_use_flg.disabled=arrDesc[0][19] > 0 ? true:false;
                    formObj.cnl_tz_flg.disabled=arrDesc[0][20] > 0 ? true:false;
                    formObj.esvc_use_flg.disabled=arrDesc[0][21] > 0 ? true:false;
                } else {
                    formObj.upd_dt.value="";
                    ComEnableManyObjects(true, formObj.por_use_flg,
                            formObj.pol_use_flg, formObj.pod_use_flg,
                            formObj.del_use_flg, formObj.imdg_clss_use_flg,
                            formObj.sub_trd_use_flg, formObj.sub_trd_use_flg,
                            formObj.slan_use_flg, formObj.ts_port_use_flg,
                            formObj.dir_call_use_flg, formObj.tml_use_flg,
                            formObj.trns_mod_use_flg, formObj.usa_svc_mod_use_flg,
                            formObj.rcv_de_term_use_flg, formObj.hngr_bar_use_flg,
                            formObj.cgo_wgt_use_flg, formObj.cmdt_use_flg,
                            formObj.soc_use_flg, formObj.io_ga_use_flg, formObj.esvc_use_flg);
                }
             	                	
                sheetObj.LoadSearchData(sXml,{Sync:1} );
                
                
                
                               
                break;
            case IBSEARCHAPPEND:

                formObj.f_cmd.value=SEARCH03;
                var prcCgoTpCd="";
                var rCnt=formObj.prc_cgo_tp_cd_1.length;
                for (i=0; i < rCnt; i++) {
                    if (formObj.prc_cgo_tp_cd_1[i].checked) {
                        if (prcCgoTpCd != "") {
                            prcCgoTpCd += ",";
                        }
                        prcCgoTpCd += formObj.prc_cgo_tp_cd_1[i].value;
                    }
                }
                
                
                if(isPage == undefined || !isPage){
                	iPageNo = 1;
                	PageNo  = 1;
                	sheetObj.DoSearch("ESM_PRI_4003GS.do",FormQueryString(formObj) + "&prc_cgo_tp_cd=" + prcCgoTpCd + "&iPage="+PageNo,{Append:false});
                } else {
                	sheetObj.DoSearch("ESM_PRI_4003GS.do",FormQueryString(formObj) + "&prc_cgo_tp_cd=" + prcCgoTpCd + "&iPage="+PageNo,{Append:true});
                }
            	
        		
                break;
            case IBSAVE:

                if (!sheetObjects[2].IsDataModified()&& sheetObjects[1].GetRowStatus(1) == "R"){
                    ComShowCodeMessage("PRI00301");
                    return false;                   
                }
                if(sheetObjects[2].IsDataModified()
                        && sheetObjects[1].GetRowStatus(1) == "R") {
                    sheetObjects[1].SetRowStatus(1,"U");
                }
                if (!validateForm(sheetObj, formObj, sAction)) {
                    return false;
                }
                var sParam="";
                var sParamSheet1=sheetObjects[1].GetSaveString();
                if (sParamSheet1 != "") {
                    sParam += "&"+ ComPriSetPrifix(sParamSheet1 + "&svc_scp_cd="+ comboObjects[0].GetSelectCode()+"&chg_cd="+ comboObjects[1].GetSelectCode(), "sheet1_");
                }
                var sParamSheet2=sheetObjects[2].GetSaveString(true);
                if (sParamSheet2 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                }
                
                ComOpenWait(true);
                
                formObj.f_cmd.value=MULTI01;
                sXml=sheetObj.GetSaveData("ESM_PRI_4003GS.do", FormQueryString(formObj)+sParam);
                var sFlag=ComGetEtcData(sXml, "FLAG");
                var sDupIdx=ComGetEtcData(sXml, "DUP_INDEX");
                if(sFlag == "N") {
                    ComShowCodeMessage("PRI02017", sDupIdx);
                    ComOpenWait(false);
                    return false;
                }else{
                    sheetObjects[1].LoadSaveData(sXml);
                }

                break;      
            case IBDELETE:

                if (!validateForm(sheetObj, document.form, sAction)) {
                    return false;
                }
                sheetObjects[1].SetRowStatus(1,"D");
                var sParam="";
                var sParamSheet1=sheetObjects[1].GetSaveString();
                if (sParamSheet1 != "") {
                    sParam += "&"+ ComPriSetPrifix(sParamSheet1 + "&svc_scp_cd="+ comboObjects[0].GetSelectCode()+"&chg_cd="+ comboObjects[1].GetSelectCode(), "sheet1_");
                }
                var sParamSheet2=sheetObjects[2].GetSaveString();
                if (sParamSheet2 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                }
                
                ComOpenWait(true);
                
                formObj.f_cmd.value=MULTI01;
                sXml=sheetObj.GetSaveData("ESM_PRI_4003GS.do", FormQueryString(formObj)+sParam);
                sheetObj.LoadSaveData(sXml);
                
            	ComPriSaveCompleted();

                break;
            case IBINSERT: //Insert
                if (!validateForm(sheetObj, document.form, sAction)) {
                    return false;
                }
                var idx=sheetObj.DataInsert();
                sheetObj.SetCellValue(idx, "svc_scp_cd",comboObjects[0].GetSelectCode());
                sheetObj.SetCellValue(idx, "chg_cd",comboObjects[1].GetSelectCode());
                //sheetObj.CellValue(idx, "scg_seq") = parseInt(ComPriGetMax(sheetObj, "scg_seq")) + 1;
                if(ComGetObjValue(formObj.flt_pct_tp_cd) == "P") {
                    sheetObj.SetCellValue(idx, "rat_ut_cd","PC");
                    sheetObj.SetCellEditable(idx, "rat_ut_cd",0);
                    sheetObj.SetCellValue(idx, "curr_cd","USD");
                }
                break;
            case IBCOPYROW: // Row Copy
                if (!validateForm(sheetObj, document.form, sAction)) {
                    return false;
                }
                if(sheetObj.CheckedRows("chk") > 1) {
                    copyMultyRow(sheetObj);
                } else if(sheetObj.CheckedRows("chk") == 1){
                    var sRow=sheetObj.FindCheckedRow("chk");
                    var arrRow=sRow.split("|");
                    sheetObj.SetSelectRow(arrRow[0]);
                    copyMultyRow(sheetObj);
                }else{
                    ComShowCodeMessage("PRI00310");     
                    return false;   
                }
                break;
            case IBRESET: // Delete
                if (!validateForm(sheetObj, document.form, sAction)) {
                    return false;
                }
                deleteRowCheck(sheetObj, "chk");
                break;
            case IBDOWNEXCEL: //download excel
                if(sheetObj.RowCount() < 1){//no data
                       ComShowCodeMessage("COM132501");
                  }else{
//                	  /*makeHiddenPriSkipCol(sheetObj)*/"3|4|5|6|7|8|10|11|12|13|14|33|34|35"
                	  var params = { DownCols:makeHiddenPriSkipCol(sheetObj),HiddenColumn:true,Merge:true,KeyFieldMark:false, CheckBoxOnValue:'Y', CheckBoxOffValue:' '} ;
                      sheetObj.Down2Excel(params);
                  }
                break;
            case IBLOADEXCEL: //upload excel
                if (!validateForm(sheetObj, document.form, sAction)) {
                    return false;
                }
                var formObj=document.form;
                var svcScpCd=comboObjects[0].GetSelectCode();
                var chgCd=comboObjects[1].GetSelectCode();
                var fltPctTpCd=ComGetObjValue(form.flt_pct_tp_cd);
                var pctBseCd=comboObjects[2].GetSelectCode();
                var sUrl="/opuscntr/ESM_PRI_4016.do?svc_scp_cd="+svcScpCd+"&chg_cd="+chgCd+"&flt_pct_tp_cd="+fltPctTpCd+"&pct_bse_cd="+pctBseCd;
                ComOpenPopup(sUrl, 1100, 500, "callBackLoadExcel", "1,0", true);
                break;
            case IBSEARCH_ASYNC01: // slane combo
                formObj.f_cmd.value=COMMAND06;
                formObj.cd.value=getSvcScpCd();
                sXml=sheetObjects[2].GetSearchData("PRICommonGS.do",
                        FormQueryString(formObj));
                setIBCombo(sheetObjects[2], sXml, "vsl_slan_cd", true, 0, '', '', true);
                break;
            case IBSEARCH_ASYNC02: //Surcharge Group Commodity Code List : Retrieve using Service Scope
                var svcScpCd=comboObjects[0].GetSelectCode();
                formObj.f_cmd.value=COMMAND10;
                sXml=sheetObjects[2].GetSearchData("PRICommonGS.do",
                        FormQueryString(formObj) + "&etc1=" + svcScpCd);
                setIBCombo(sheetObjects[2], sXml, "scg_grp_cmdt_cd", true, 0);
                break;
            }           
        } catch (e) {
        	
        	ComOpenWait(false); //->waiting->End
        	
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }finally{
            if (sAction == IBINSERT || sAction == IBCOPYROW || sAction == IBRESET
                    || sAction == IBDOWNEXCEL || sAction == IBLOADEXCEL
                    || sAction == IBSEARCH_ASYNC01 || sAction == IBSEARCH_ASYNC02 ) {
                return;
            }
            
        }
    }
    
    function callBackLoadExcel (returnObj) {
    	if(returnObj != null && returnObj == "S"){
    		reloadExcelCopy();

        }  
    }
    
    /**
     * Calling Function in case of OnSearchEnd event <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2009.06.04
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
        
    	
    	if (errMsg == "") {
            formObj=document.form;
            sheetObjects[2].RemoveAll();
            // When there is not retrieved data on sheet, makes new one.
            if (sheetObj.RowCount()< 1) {
                form.flt_pct_tp_cd[0].checked=true;
                comboObjects[2].SetSelectCode(-1,false);
                sheet1RowAdd();
                ComBtnDisable("btn_loadexcel");
            } else {
                ComBtnEnable("btn_loadexcel");
            }
            ComSetObjValue(form.flt_pct_tp_cd, sheetObjects[1].GetCellValue(1, "flt_pct_tp_cd"));
            setFltPctTpCd(sheetObjects[1].GetCellValue(1, "flt_pct_tp_cd"));
            comboObjects[2].SetSelectCode(""+sheetObjects[1].GetCellValue(1, "pct_bse_cd"));
            // Mapping retrieve data on sheet1 and checkbox on form
            mappingSheet1ToForm("por_use_flg", "por_use_flg");
            mappingSheet1ToForm("pol_use_flg", "pol_use_flg");
            mappingSheet1ToForm("pod_use_flg", "pod_use_flg");
            mappingSheet1ToForm("del_use_flg", "del_use_flg");
            mappingSheet1ToForm("rcv_de_term_use_flg", "rcv_de_term_use_flg");
            mappingSheet1ToForm("imdg_clss_use_flg", "imdg_clss_use_flg");
            mappingSheet1ToForm("cnl_tz_flg", "cnl_tz_flg");
            mappingSheet1ToForm("cgo_wgt_use_flg", "cgo_wgt_use_flg");
            mappingSheet1ToForm("trns_mod_use_flg", "trns_mod_use_flg");
            mappingSheet1ToForm("hngr_bar_use_flg", "hngr_bar_use_flg");
            mappingSheet1ToForm("sub_trd_use_flg", "sub_trd_use_flg");
            mappingSheet1ToForm("slan_use_flg", "slan_use_flg");
            mappingSheet1ToForm("dir_call_use_flg", "dir_call_use_flg");
            mappingSheet1ToForm("tml_use_flg", "tml_use_flg");
            mappingSheet1ToForm("cmdt_use_flg", "cmdt_use_flg");
            mappingSheet1ToForm("io_ga_use_flg", "io_ga_use_flg");
            mappingSheet1ToForm("ts_port_use_flg", "ts_port_use_flg");
            mappingSheet1ToForm("soc_use_flg", "soc_use_flg");
            mappingSheet1ToForm("gri_cmdt_use_flg", "gri_cmdt_use_flg");
            mappingSheet1ToForm("usa_svc_mod_use_flg", "usa_svc_mod_use_flg");
            mappingSheet1ToForm("esvc_use_flg", "esvc_use_flg");
            // Mapping value of checkbox on form and content of sheet2
            mappingFormToSheet2('por_use_flg', 'por_def_cd');
            mappingFormToSheet2('pol_use_flg', 'pol_def_cd');
            mappingFormToSheet2('pod_use_flg', 'pod_def_cd');
            mappingFormToSheet2('del_use_flg', 'del_def_cd');
            mappingFormToSheet2('rcv_de_term_use_flg', 'prc_rcv_term_cd');
            mappingFormToSheet2('rcv_de_term_use_flg', 'prc_de_term_cd');
            mappingFormToSheet2('imdg_clss_use_flg', 'scg_imdg_clss_cd');
            mappingFormToSheet2('cnl_tz_flg', 'cnl_tz_cd');
            mappingFormToSheet2('cgo_wgt_use_flg', 'min_cgo_wgt');
            mappingFormToSheet2('cgo_wgt_use_flg', 'max_cgo_wgt');
            mappingFormToSheet2('trns_mod_use_flg', 'org_trsp_mod_cd');
            mappingFormToSheet2('trns_mod_use_flg', 'dest_trsp_mod_cd');
            mappingFormToSheet2('hngr_bar_use_flg', 'prc_hngr_bar_tp_cd');
            mappingFormToSheet2('sub_trd_use_flg', 'sub_trd_cd');
            mappingFormToSheet2('slan_use_flg', 'vsl_slan_cd');
            mappingFormToSheet2('dir_call_use_flg', 'dir_call_flg');
            mappingFormToSheet2('tml_use_flg', 'tml_cd');
            mappingFormToSheet2('cmdt_use_flg', 'cmdt_cd');
            mappingFormToSheet2('io_ga_use_flg', 'io_ga_cd');
            mappingFormToSheet2('ts_port_use_flg', 'ts_port_cd');
            mappingFormToSheet2('soc_use_flg', 'soc_flg');
            mappingFormToSheet2('gri_cmdt_use_flg', 'scg_grp_cmdt_cd');
            mappingFormToSheet2('usa_svc_mod_use_flg', 'usa_svc_mod_cd');
            mappingFormToSheet2('esvc_use_flg', 'bkg_esvc_tp_cd');
            doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
            doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
            doActionIBSheet(sheetObjects[2], formObj, IBSEARCHAPPEND);
        }
       
        
    }
    /**
     * Calling function in case of OnSaveEnd on sheet1 <br>
     * Showing saving confirmation message <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2009.06.04
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        var formObj=document.form;
        if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
            //ComPriSaveCompleted();
            doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
        }
        ComOpenWait(false);
    }
    /**
     * It calls when OnSearchEnd event triggered on sheet2 <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2009.05.20
     */
    function sheet2_OnSearchEnd(sheetObj, Code, errMsg) {
    	if(Code == 0) {
	    	setSheetDisplay(sheetObj); 
	    	
	    	//display sheet row's total count
	    	var lstTotal = sheetObj.GetEtcData("TOTAL");
	    	if(lstTotal == undefined || lstTotal == "") {
	    		sheetObj.SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
	    	} else {
	    		sheetObj.SetCountFormat("Total Row : (" + lstTotal + ") [SELECTDATAROW / ROWCOUNT]");
	    	}
	    	
    	}
        ComOpenWait(false);
        
        
    }
    /**
     * Calling function in case of OnSaveEnd on sheet2 <br>
     * Showing saving confirmation message <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2009.06.04
     */
    function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
        ComOpenWait(false);
    }

    /**
     * setting intial combo value <br>
     * adding case as numbers of counting combo<br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {object} comboObj Mandatory IBMultiCombo Object
     * @param {int} comboNo Mandatory IBMultiCombo Object ,Serial no for Tag's ID
     * @return void
     * @author 
     * @version 2009.06.04
     */
    function initCombo(comboObj, comboNo) {
        switch (comboObj.options.id) {
            case "svc_scp_cd":
                var i=0;
                with (comboObj) {
                    //BackColor = "cyan";
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    SetMaxLength(3);
                    ValidChar(2);
                    
                }
                break;
            case "chg_cd":
                var i=0;
                with (comboObj) {
                    //UseEdit = true;
                    // BackColor = "cyan";
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    SetMaxLength(3);
                    ValidChar(2);
                }
                break;
            case "pct_bse_cd":
                var i=0;
                with (comboObj) {
                    //UseEdit = true;
                    // BackColor = "cyan";
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetEnable(0);
                    SetUseAutoComplete(1);
                    SetMaxLength(20);
                }
                break;
            case "scg_imdg_clss_cd":
                var i=0;
                with (comboObj) {
                    //UseEdit = true;
                    // BackColor = "cyan";
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetEnable(1);
                    SetUseAutoComplete(1);
                    SetMaxLength(1);
                }
                break;
        }
    }

    
    /**
     * Calling Function in case of OnChange event <br>
     * Showing description by svc_scp_cd value <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj Mandatory IBMultiCombo Object
     * @param {string} value Mandatory, value of selected item
     * @param {string} text Mandatory selected item's text
     * @returns void
     * @author 
     * @version 2009.06.04
     */
    function svc_scp_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
        var formObj=document.form;
        if (NewTxt != null && NewTxt.length > 0) {
        	formObj.svc_scp_nm.value=comboObj.GetText(NewCod, 1);
        } else {
        	formObj.svc_scp_nm.value = "";        	
        }
        comboObjects[1].SetSelectCode('-1',false);
        form.chg_nm.value="";
    }

    /**
      * calling function in case of OnKeyDown event in IBMultiCombo   <br>
      * When Enter Key pressed, Retrieve again. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param   {object} comboObj Mandatory IBMultiCombo Object
      * @param   {string} KeyCode Mandatory Ascii code Value
      * @param   {string} Shift   Displaying whether Mandatory shift is keyup
      * @returns void
      * @author  
      * @version 2009.06.04
      */          
    function svc_scp_cd_OnKeyDown(comboObj,KeyCode, Shift) {
        if (KeyCode == 13){
            doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
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
     * @param {string} value Mandatory, value of selected item
     * @param {string} text Mandatory selected item's text
     * @returns void
     * @author 
     * @version 2009.06.04
     */
    function chg_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
        if (ComIsNull(getSvcScpCd())) {
            ComShowCodeMessage('PRI01007');
            comboObj.SetSelectCode('-1',false);
            form.chg_nm.value="";
            return;
        }
        var formObj=document.form;

        if (NewTxt != null && NewTxt.length > 0) {
            formObj.chg_nm.value=comboObj.GetText(NewCod, 1);
            doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
        } else {
        	formObj.chg_nm.value="";
        }
    }

    /**
      * calling function in case of OnKeyDown event in IBMultiCombo   <br>
      * When Enter Key pressed, Retrieve again. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param   {object} comboObj Mandatory IBMultiCombo Object
      * @param   {string} KeyCode Mandatory Ascii code Value
      * @param   {string} Shift   Displaying whether Mandatory shift is keyup
      * @returns void
      * @author  
      * @version 2009.06.04
      */     
    function chg_cd_OnKeyDown(comboObj,KeyCode, Shift) {
        if (KeyCode == 13){
            chg_cd_OnBlur(comboObj)
        }   
    }     
    /**
     * calling function in case of OnChange event in IBMultiCombo   <br>
     * Display the Description of selected code when the focus moves out of pcs_bse_cd combo. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj Mandatory IBMultiCombo Object
     * @param {string} value Mandatory, value of selected item
     * @param {string} text Mandatory selected item's text
     * @returns void
     * @author 
     * @version 2009.06.04
     */
    function pct_bse_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
        if (sheetObjects[1].RowCount()> 0) {
            sheetObjects[1].SetCellValue(1, 'pct_bse_cd',NewCod);
        }
    }
    /**
     * Create new row on sheet1 <br>
     * <br><b>Example :</b>
     * <pre>
     *      sheet1RowAdd()
     * </pre>
     * @returns void
     * @author 
     * @version 2009.06.04
     */
    function sheet1RowAdd() {
        var idx=sheetObjects[1].DataInsert();
        sheetObjects[1].SetCellValue(idx, "flt_pct_tp_cd",ComGetObjValue(form.flt_pct_tp_cd));
        sheetObjects[1].SetCellValue(idx, "pct_bse_cd",comboObjects[2].GetSelectCode());
        sheetObjects[1].SetCellValue(idx, "por_use_flg","Y");
        sheetObjects[1].SetCellValue(idx, "por_use_flg","Y");
        sheetObjects[1].SetCellValue(idx, "pol_use_flg","Y");
        sheetObjects[1].SetCellValue(idx, "pod_use_flg","Y");
        sheetObjects[1].SetCellValue(idx, "del_use_flg","Y");
        sheetObjects[1].SetCellValue(idx, "rcv_de_term_use_flg","N");
        sheetObjects[1].SetCellValue(idx, "imdg_clss_use_flg","N");
        sheetObjects[1].SetCellValue(idx, "cnl_tz_flg","N");
        sheetObjects[1].SetCellValue(idx, "cgo_wgt_use_flg","N");
        sheetObjects[1].SetCellValue(idx, "trns_mod_use_flg","N");
        sheetObjects[1].SetCellValue(idx, "hngr_bar_use_flg","N");
        sheetObjects[1].SetCellValue(idx, "sub_trd_use_flg","N");
        sheetObjects[1].SetCellValue(idx, "slan_use_flg","N");
        sheetObjects[1].SetCellValue(idx, "dir_call_use_flg","N");
        sheetObjects[1].SetCellValue(idx, "tml_use_flg","N");
        sheetObjects[1].SetCellValue(idx, "cmdt_use_flg","N");
        sheetObjects[1].SetCellValue(idx, "io_ga_use_flg","N");
        sheetObjects[1].SetCellValue(idx, "ts_port_use_flg","N");
        sheetObjects[1].SetCellValue(idx, "soc_use_flg","N");
        sheetObjects[1].SetCellValue(idx, "gri_cmdt_use_flg","N");
        sheetObjects[1].SetCellValue(idx, "usa_svc_mod_use_flg","N");
        sheetObjects[1].SetCellValue(idx, "esvc_use_flg","N");
    }
    /**
     * Initialize sheet2 <br>
     * <br><b>Example :</b>
     * <pre>
     *      sheet2_Reset()
     * </pre>
     * @returns void
     * @author 
     * @version 2009.06.04
     */
    function sheet2_Reset() {
        sheetObjects[2].SetColHidden("scg_imdg_clss_cd",1);
        sheetObjects[2].SetColHidden("sub_trd_cd",1);
        sheetObjects[2].SetColHidden("vsl_slan_cd",1);
        sheetObjects[2].SetColHidden("ts_port_cd",1);
        sheetObjects[2].SetColHidden("dir_call_flg",1);
        sheetObjects[2].SetColHidden("tml_cd",1);
        sheetObjects[2].SetColHidden("org_trsp_mod_cd",1);
        sheetObjects[2].SetColHidden("dest_trsp_mod_cd",1);
        sheetObjects[2].SetColHidden("usa_svc_mod_cd",1);
        sheetObjects[2].SetColHidden("prc_rcv_term_cd",1);
        sheetObjects[2].SetColHidden("prc_de_term_cd",1);
        sheetObjects[2].SetColHidden("prc_hngr_bar_tp_cd",1);
        sheetObjects[2].SetColHidden("min_cgo_wgt",1);
        sheetObjects[2].SetColHidden("max_cgo_wgt",1);
        sheetObjects[2].SetColHidden("cmdt_cd",1);
        sheetObjects[2].SetColHidden("scg_grp_cmdt_cd",1);
        sheetObjects[2].SetColHidden("soc_flg",1);
        sheetObjects[2].SetColHidden("io_ga_cd",1);
        sheetObjects[2].SetColHidden("cnl_tz_cd",1);
        sheetObjects[2].SetColHidden("bkg_esvc_tp_cd",1);
    }
    /**
     * Return the value of svc_scp_cd <br>
     * <br><b>Example :</b>
     * <pre>
     *      getSvcScpCd()
     * </pre>
     * @return (String)
     * @author 
     * @version 2009.06.04
     */
    function getSvcScpCd() {
        var sSvcScpCd=comboObjects[0].GetSelectCode();
        return sSvcScpCd;
    }
    /**
     * Retrieve value of chg_cd <br>
     * <br><b>Example :</b>
     * <pre>
     *      getSvcScpCd()
     * </pre>
     * @return (String)
     * @author 
     * @version 2009.06.04
     */
    function getChgCd() {
        return comboObjects[1].GetSelectCode();
    }
    /**
     * Copying multi-rows <br>
     * <br><b>Example :</b>
     * <pre>
     *    copyMultyRow(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @returns void
     * @author 
     * @version 2009.06.04
     */
    function copyMultyRow(sheetObj) {
        var checkArr=ComRtrim(sheetObj.FindCheckedRow("chk"), '|').split("|");
        if(checkArr != null && checkArr.length > 0) {
            for(var i=checkArr.length-1; i>=0; i--) {
                sheetObj.SetSelectRow(checkArr[i]);
                sheetObj.DataCopy();
                sheetObj.ReNumberSeq();
                sheetObj.SetCellValue(checkArr[i], "chk",0,0);
            }
        }
    }
    /**
     * Mapping data from form to sheet2 <br>
     * <br><b>Example :</b>
     * <pre>
     *    mappingFormToSheet2("gri_cmdt_use_flg", "scg_grp_cmdt_cd");
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @returns void
     * @author 
     * @version 2009.06.04
     */
    function mappingFormToSheet2(formObjName, sheetCellName) {
        var isChecked=eval("form." + formObjName + ".checked");
        if (isChecked) {
            sheetObjects[2].SetColHidden(sheetCellName,0);
        } else {
            sheetObjects[2].SetColHidden(sheetCellName,1);
        }
    }
    /**
     * Mapping data from form to sheet1 <br>
     * <br><b>Example :</b>
     * <pre>
     *    mappingFormToSheet1("io_ga_use_flg");
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @returns void
     * @author 
     * @version 2009.06.04
     */
    function mappingFormToSheet1(formObjName) {
        var isChecked=eval("form." + formObjName + ".checked");
        if (isChecked) {
            sheetObjects[1].SetCellValue(1, formObjName,"Y",0);
        } else {
            sheetObjects[1].SetCellValue(1, formObjName,"N",0);
        }
    }
    /**
     * Mapping data from sheet1 to form <br>
     * <br><b>Example :</b>
     * <pre>
     *    mappingSheet1ToForm("io_ga_use_flg", "io_ga_use_flg");
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @returns void
     * @author 
     * @version 2009.06.04
     */
    function mappingSheet1ToForm(sheetCellName, formObjName) {
        var objName=eval("form." + formObjName);
        if (sheetObjects[1].GetCellValue(1, sheetCellName) == 'Y') {
            objName.checked=true;
        } else {
            objName.checked=false;
        }
    }
    /**
     * Display confirm message when unchecked the data <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkConfirm("por_use_flg", event.srcElement.checked);
     * </pre>
     * @param {object} formObjName HTML form Object Name
     * @param {object} isCheck check or not
     * @return void
     * @author 
     * @version 2009.06.04
     */
    function checkConfirm(formObjName, isCheck) {
        var objName=eval("form." + formObjName);
        if(!isCheck) { // When it unchecked
            if(ComShowCodeConfirm('PRI02001')) {
                objName.checked=false;
            } else {
                objName.checked=true;
            }
        }
    }
    /**
     * flt_pct_tp_cd select function <br>
     * Modify the title of sheet. 
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @param (string)} code
     * @return void
     * @author 
     * @version 2009.06.04
     */
    function setFltPctTpCd(code) {
         if(code == 'F') {
        	 
        	var info = {Type:"Float", Align:"Right", Format:"Float", PointCount:2, EditLen:12 };
         	sheetObjects[2].SetColProperty(0, "scg_amt" ,info);

            comboObjects[2].SetSelectCode("");
            comboObjects[2].SetEnable(0);
            sheetObjects[2].SetCellValue(0, "scg_amt","Amount");
            sheetObjects[2].SetCellValue(1, "scg_amt","Amount");
            if(sheetObjects[1].RowCount()> 0) {
                sheetObjects[1].SetCellValue(1, "flt_pct_tp_cd","F",0);
                sheetObjects[1].SetCellValue(1, "pct_bse_cd","",0);
            }

        } else if(code == 'P') {
        	
        	var info = {Type:"Float", Align:"Right", Format:"Float", PointCount:4, EditLen:12 };
        	sheetObjects[2].SetColProperty(0, "scg_amt" ,info);

            comboObjects[2].SetEnable(1);
            sheetObjects[2].SetCellValue(0, "scg_amt","Percentage %");
            sheetObjects[2].SetCellValue(1, "scg_amt","Percentage %");
            if(sheetObjects[1].RowCount()> 0) {
                sheetObjects[1].SetCellValue(1, "flt_pct_tp_cd","P",0);
            }

        }
    }
    /**
     * Validating location code  <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkFormLocation(sName, sValue);
     * </pre>
     * @param (string) objName Selected object's name
     * @param (string) objValue Selected object's value
     * @return void
     * @author 
     * @version 2009.06.04
     */  
    function checkFormLocation(objName, objValue) {
        var formObj=document.form;
        var oName=eval("document.form." + objName);
        // Location
        if(objValue.length == 5) {
            formObj.f_cmd.value=SEARCH05;
            formObj.cd.value=objValue;
            var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
            var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
            if(arrDesc == undefined || arrDesc == null ) {
                oName.value="";
            }
        } 
        // Location Group
        else if (objValue.length == 4) {
            formObj.f_cmd.value=COMMAND11;
            formObj.cd.value=objValue;
            var param = "&etc1=" +comboObjects[0].GetSelectCode()+ "&etc2=" +comboObjects[1].GetSelectCode();
            var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
            var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
            if(arrData[1] == "" || arrData[1] == null) {
                oName.value="";
            }
        }
        // Region
        else if (objValue.length == 3) {
            formObj.f_cmd.value=COMMAND08;
            formObj.cd.value=objValue;
            var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
            var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
            if(arrData[1] == "" || arrData[1] == null) {
                oName.value="";
            }
        }
        // Country
        else if(objValue.length == 2) {
            formObj.f_cmd.value=SEARCH07;
            formObj.cd.value=objValue;
            var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
            var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
            if(arrData[1] == "" || arrData[1] == null) {
                oName.value="";
            }
        }
    }
    /**
     * Validating location code  <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkLocation(sheetObj, Row, "del_tp_cd", "del_def_cd");
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param (string) cellTpCdNm selected cell's tp code
     * @param (string) cellDefCdNm selected cell's def code
     * @return void
     * @author 
     * @version 2009.06.04
     */ 
    function checkLocation(sheetObj, Row, cellTpCdNm, cellDefCdNm) {
        var formObj=document.form;
        var locCd=sheetObj.GetCellValue(Row, cellDefCdNm);
        // Location
        if (locCd.length == 5) {
            formObj.f_cmd.value=SEARCH05;
            formObj.cd.value=locCd;
            var sXml=sheetObj.GetSearchData("PRICommonGS.do",
                    FormQueryString(formObj));
            var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
            if (arrDesc != null && arrDesc.length > 0) {
                sheetObj.SetCellValue(Row, cellTpCdNm,"L",0);
            } else {
                locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
                sheetObj.SelectCell(Row, cellDefCdNm);
            }
        }
        // Location Group
        else if (locCd.length == 4) {
            formObj.f_cmd.value=COMMAND11;
            formObj.cd.value=locCd;
            var param="&etc1=" + sheetObj.GetCellValue(Row, "svc_scp_cd") + "&etc2="
                + sheetObj.GetCellValue(Row, "chg_cd");
            var sXml=sheetObj.GetSearchData("PRICommonGS.do",
                    FormQueryString(formObj) + param);
            var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
            if (arrData[1] != "") {
                sheetObj.SetCellValue(Row, cellTpCdNm, "G");
            } else {
                locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
                sheetObj.SelectCell(Row, cellDefCdNm);
            }
        }
        // Country
        else if (locCd.length == 2) {
            formObj.f_cmd.value=SEARCH07;
            formObj.cd.value=locCd;
            var sXml=sheetObj.GetSearchData("PRICommonGS.do",
                    FormQueryString(formObj));
            var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
            if (arrData[1] != "") {
                sheetObj.SetCellValue(Row, cellTpCdNm, "C");
            } else {
                locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
                sheetObj.SelectCell(Row, cellDefCdNm);
            }
        }
        // Region
        else if (locCd.length == 3) {
            formObj.f_cmd.value=COMMAND08;
            formObj.cd.value=locCd;
            var sXml=sheetObj.GetSearchData("PRICommonGS.do",
                    FormQueryString(formObj));
            var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
            if (arrData[1] != "") {
                sheetObj.SetCellValue(Row, cellTpCdNm, "R");
            } else {
                locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
                sheetObj.SelectCell(Row, cellDefCdNm);
            }
        } else {
            locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
            sheetObj.SelectCell(Row, cellDefCdNm);
        }
    }
    /**
     * Re-setting location code <br>
     * <br><b>Example :</b>
     * <pre>
     *    locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param (string) cellTpCdNm selected cell's tp code
     * @param (string) cellDefCdNm selected cell's def code
     * @return void
     * @author 
     * @version 2009.06.04
     */ 
    function locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm) {
        sheetObj.SetCellValue(Row, cellTpCdNm,"",0);
        sheetObj.SetCellValue(Row, cellDefCdNm,"",0);
    }
    /**
     * tml_cd validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkTerminalCode(sheetObj, Row, Value);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.06.04
     */ 
    function checkTerminalCode(sheetObj, Row, Value) {
        if(ComIsNull(Value)) {
            return;
        }
        var formObj=document.form;
        if (Value.length == 7) {
            formObj.f_cmd.value=SEARCH;
            var sXml=sheetObjects[0].GetSearchData("COM_ENS_061GS.do" , FormQueryString(formObj)+"&node_cd="+Value);
            var arrDesc=ComPriXml2Array(sXml, "yd_cd");
            if(arrDesc == null || arrDesc.length < 1) {
                sheetObj.SetCellValue(Row, "tml_cd","",0);
            }
        } else {
            sheetObj.SetCellValue(Row, "tml_cd","",0);
        }
    }
    /**
     * ts_port_cd validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkTSPort(sheetObj, Row, Value);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.06.04
     */ 
    function checkTSPort(sheetObj, Row, Value) {
        if(ComIsNull(Value)) {
            return;
        }
        if (Value.length == 5) {
            formObj.f_cmd.value=SEARCH05;
            formObj.cd.value=Value;
            var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
            var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
            if(arrDesc == null || arrDesc.length < 1) {
                sheetObj.SetCellValue(Row, "ts_port_cd","",0);
            }
        } else {
            sheetObj.SetCellValue(Row, "ts_port_cd","",0);
        }
    }
    /**
     * cmdt_cd's validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkCommodity(sheetObj, Row, Value);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.06.04
     */ 
    function checkCommodity(sheetObj, Row, Value) {
        if(ComIsNull(Value)) {
            return;
        }
        if(Value.length == 6) {
            formObj.f_cmd.value=SEARCH01;
            var sXml=sheetObj.GetSearchData("ESM_PRI_4027GS.do", FormQueryString(formObj) + "&cmdt_cd=" + Value);
            var arrDesc=ComPriXml2Array(sXml, "cmdt_cd|cmdt_nm");
            if (arrDesc == null || arrDesc.length < 1) {
                sheetObj.SetCellValue(Row, "cmdt_cd", "");
                sheetObj.SelectCell(Row, "cmdt_cd");
            } else {
                sheetObj.SetCellValue(Row, "cmdt_cd", Value);
            }
        } else {
            sheetObj.SetCellValue(Row, "cmdt_cd", "");
            sheetObj.SelectCell(Row, "cmdt_cd");
        }
    }
    /**
     * rat_ut_cd validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkPerType(sheetObj, Row, Value);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.06.04
     */ 
    function checkPerType(sheetObj, Row, Value) {
        var validPerClass="A,F,O,Q,S,P";
        if(sheetObj.GetCellValue(Row, "prc_cgo_tp_cd") == "AK" &&
                (ComIsNull(Value) || (validPerClass.indexOf(Value.charAt(0)) < 0 && Value != "20" && Value != "40" && Value != "HC" && Value != "BX"))) {
            ComShowCodeMessage("PRI02011");
            sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","",0);
        }
    }
    /**
     * prc_cgo_tp_cd validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkCargoType(sheetObj, Row, Value);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.06.04
     */ 
    function checkCargoType(sheetObj, Row, Value) {
        if(Value == "AK") {
            var validPerClass="A,F,O,Q,S,P";
            var ratUtCd=sheetObj.GetCellValue(Row, "rat_ut_cd");
            //if(validPerClass.indexOf(ratUtCd.charAt(0)) < 0 || ComIsNull(ratUtCd)) {
            if((validPerClass.indexOf(ratUtCd.charAt(0)) < 0 && ratUtCd != "20" && ratUtCd != "40" && ratUtCd != "45" && ratUtCd != "HC" && ratUtCd != "BX") || ComIsNull(ratUtCd)) {
                ComShowCodeMessage("PRI02011");
                sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","",0);
            }
        } else if(Value == "DG") {
            sheetObj.SetCellEditable(Row, "scg_imdg_clss_cd",1);
        } else {
            sheetObj.SetCellValue(Row, "scg_imdg_clss_cd","",0);
            sheetObj.SetCellEditable(Row, "scg_imdg_clss_cd",0);
        }
    }
    /**
     * setting sheet's attribute function <br>
     * <br><b>Example :</b>
     * <pre>
     *    setSheetDisplay(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @return void
     * @author 
     * @version 2009.06.04
     */ 
    function setSheetDisplay(sheetObj) {
        var topRow=sheetObj.GetTopRow();
        var lastRow=sheetObj.LastRow();
        var rCnt=sheetObj.RowCount();
        var formObj=document.form;
        if(ComIsNull(formObj.upd_dt.value)) {
            ComBtnDisable("btn_delete1");
        } else if(rCnt > 0) {
            ComBtnDisable("btn_delete1");
            for(var i=topRow; i<=lastRow; i++) {
                // Cargo Type
                if (sheetObj.GetCellValue(i, "prc_cgo_tp_cd") == "DG") {
                    sheetObj.SetCellEditable(i, "scg_imdg_clss_cd",1);
                } else {
                    sheetObj.SetCellValue(i, "scg_imdg_clss_cd","");
                    sheetObj.SetCellEditable(i, "scg_imdg_clss_cd",0);
                }
                // Amount
                if (sheetObj.GetCellValue(i, "scg_amt") != 0) {
                    sheetObj.InitCellProperty(i, "scg_amt",{ Type:"Data",Align:"Right",Format:"dfNullFloat",PointCount:2,EditLen:11} );
                } else {
                    sheetObj.InitCellProperty(i, "scg_amt",{ Type:"Data",Align:"Right",Format:"dfNullInteger"} );
                }
                
                //PER(2015.05.07 ADD)
                if(ComGetObjValue(formObj.flt_pct_tp_cd) == "P") {
                    sheetObj.SetCellEditable(i, "rat_ut_cd",0);
                }
                
            }
        } else {
            ComBtnEnable("btn_delete1");
        }
        sheetObj.SetColBackColor("scg_rmk","#FFFFFF");
    }
    /**
     * Calling function after closing excel popup <br>
     * <br><b>Example :</b>
     * <pre>
     *    reloadExcelCopy()
     * </pre>
     * @return void
     * @author 
     * @version 2009.06.04
     */ 
    function reloadExcelCopy() {
        doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
    }
    /**
      * Array sort function <br>
      * <br><b>Example :</b>
      * <pre>
      *    sortNumber()
      * </pre>
      * @param {int} a Comparing Value - First
      * @param {int} b Comparing Value - Second
      * @return int
      * @author 
      * @version 2009.06.04
      */      
     function sortNumber(a,b){
         return a - b;
     }
    /**
     * Checking duplicate rows on sheet  <br>
     * <br><b>Example :</b>
     * <pre>
     *    setSheetDisplay(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @return void
     * @author 
     * @version 2009.06.04
     */ 
     function checkSheetRowDup(sheetObj) {
        var tempSheet=sheetObjects[3];
        var srcCols="";
        var destCols="";
        srcCols += "seq|por_def_cd|pol_def_cd|pod_def_cd|del_def_cd|rat_ut_cd|prc_cgo_tp_cd|scg_imdg_clss_cd|curr_cd|pay_term_cd|cnl_tz_cd|";
        srcCols += "min_cgo_wgt|max_cgo_wgt|org_trsp_mod_cd|dest_trsp_mod_cd|prc_rcv_term_cd|prc_de_term_cd|prc_hngr_bar_tp_cd|sub_trd_cd|vsl_slan_cd|dir_call_flg|tml_cd|";
        srcCols += "cmdt_cd|io_ga_cd|ts_port_cd|soc_flg|scg_grp_cmdt_cd|usa_svc_mod_cd|eff_dt|exp_dt|bkg_esvc_tp_cd";
        destCols += tempSheet.SaveNameCol("seq")+"|"+tempSheet.SaveNameCol("por_def_cd")+"|"+tempSheet.SaveNameCol("pol_def_cd")+"|"+tempSheet.SaveNameCol("pod_def_cd")+"|"+tempSheet.SaveNameCol("del_def_cd")+"|";
        destCols += tempSheet.SaveNameCol("rat_ut_cd")+"|"+tempSheet.SaveNameCol("prc_cgo_tp_cd")+"|"+tempSheet.SaveNameCol("scg_imdg_clss_cd")+"|"+tempSheet.SaveNameCol("curr_cd")+"|"+tempSheet.SaveNameCol("pay_term_cd")+"|";
        destCols += tempSheet.SaveNameCol("cnl_tz_cd")+"|"+tempSheet.SaveNameCol("min_cgo_wgt")+"|"+tempSheet.SaveNameCol("max_cgo_wgt")+"|"+tempSheet.SaveNameCol("org_trsp_mod_cd")+"|"+tempSheet.SaveNameCol("dest_trsp_mod_cd")+"|";
        destCols += tempSheet.SaveNameCol("prc_rcv_term_cd")+"|"+tempSheet.SaveNameCol("prc_de_term_cd")+"|"+tempSheet.SaveNameCol("prc_hngr_bar_tp_cd")+"|"+tempSheet.SaveNameCol("sub_trd_cd")+"|"+tempSheet.SaveNameCol("vsl_slan_cd")+"|";
        destCols += tempSheet.SaveNameCol("dir_call_flg")+"|"+tempSheet.SaveNameCol("tml_cd")+"|"+tempSheet.SaveNameCol("cmdt_cd")+"|"+tempSheet.SaveNameCol("io_ga_cd")+"|"+tempSheet.SaveNameCol("ts_port_cd")+"|";
        destCols += tempSheet.SaveNameCol("soc_flg")+"|"+tempSheet.SaveNameCol("scg_grp_cmdt_cd")+"|"+tempSheet.SaveNameCol("usa_svc_mod_cd")+"|"+tempSheet.SaveNameCol("eff_dt")+"|"+tempSheet.SaveNameCol("exp_dt")+"|"+tempSheet.SaveNameCol("bkg_esvc_tp_cd");
        tempSheet.RemoveAll();
        // Copy only object column to Duplicate Check
        sheetObj.Copy2SheetCol(tempSheet, srcCols, destCols, -1, -1, -1, 1);
         // Bring Scope Data as String. Use "|" and "^" as separator.
//      var compareStr = tempSheet.GetRangeText(2,2,tempSheet.LastRow,tempSheet.LastCol - 2,"|","^");
        var compareStr=tempSheet.GetRangeText(2,2,tempSheet.LastRow(),tempSheet.LastCol()- 2,"|","^");
        var arrBase=compareStr.split("^");
        var arrDest=arrBase;
        var srcEffDt="";
        var srcExpDt="";
        var trgtEffDt="";
        var trgtExpDt="";
        for (var i=0; i < arrBase.length  ; i++){           
            srcEffDt=tempSheet.GetCellValue(i + 2, "eff_dt");
            srcExpDt=tempSheet.GetCellValue(i + 2, "exp_dt");
            for (var j=0; j < arrDest.length ; j++){                
                if (tempSheet.GetCellValue(i + 2, "seq")!= tempSheet.GetCellValue(j + 2, "seq")
                        && arrBase[i] == arrDest[j]
                && sheetObj.GetCellValue(i + 2, "ibflag") !="D"
                    && sheetObj.GetCellValue(j + 2, "ibflag") !="D"
                        ){                  
                    trgtEffDt=tempSheet.GetCellValue(j + 2, "eff_dt");
                    trgtExpDt=tempSheet.GetCellValue(j + 2, "exp_dt");
                    // Show Message when row's item and duration is duplicate .
                    if(ComIsNull(srcExpDt) && ComIsNull(trgtExpDt)) {
                        if(srcEffDt == trgtEffDt) {
                            ComShowCodeMessage("PRI02016", sheetObj.GetCellValue(i + 2, "seq"), sheetObj.GetCellValue(j + 2, "seq"));
                            return false;
                        }
                        if (srcEffDt  <= trgtEffDt){
                            ComShowCodeMessage("PRI02016", sheetObj.GetCellValue(i + 2, "seq"), sheetObj.GetCellValue(j + 2, "seq"));
                            return false;
                        }
                    } else if(ComIsNull(srcExpDt)) {
                        if(trgtEffDt <= srcEffDt && srcEffDt <= trgtExpDt) {
                            ComShowCodeMessage("PRI02016", sheetObj.GetCellValue(i + 2, "seq"), sheetObj.GetCellValue(j + 2, "seq"));
                            return false;
                        }
                    } else if(ComIsNull(trgtExpDt)) {
                        if(srcEffDt <= trgtEffDt && trgtEffDt <= srcExpDt) {
                            ComShowCodeMessage("PRI02016", sheetObj.GetCellValue(i + 2, "seq"), sheetObj.GetCellValue(j + 2, "seq"));
                            return false;
                        }
                        if (trgtEffDt <= srcEffDt){
                            ComShowCodeMessage("PRI02016", sheetObj.GetCellValue(i + 2, "seq"), sheetObj.GetCellValue(j + 2, "seq"));
                            return false;
                        }
                    } else {
                        if((srcEffDt >= trgtEffDt && srcEffDt <= trgtExpDt) ||(srcExpDt >= trgtEffDt && srcExpDt <= trgtExpDt) || (srcEffDt <= trgtEffDt && srcExpDt >= trgtExpDt)) {
                            ComShowCodeMessage("PRI02016", sheetObj.GetCellValue(i + 2, "seq"), sheetObj.GetCellValue(j + 2, "seq"));
                            return false;
                        }
                    }                   
                }               
            }
        }
         return true;
     }
    /**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *    validateForm(sheetObj, document.form, sAction)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @return void
     * @author 
     * @version 2009.06.04
     */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
            case IBSEARCH: // Master Retrieve
                if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== ""|| comboObjects[0].GetSelectCode()== " " ||  comboObjects[1].GetSelectCode()== " ") {
                    ComShowCodeMessage('PRI02004');
                    return false;
                }
//                if (ComGetObjValue(formObj.flt_pct_tp_cd) == "P"
//                        && ComGetObjValue(comboObjects[2]) == "") {
//                    ComShowCodeMessage('PRI02005');
//                    return false;
//                }
                if (formObj.por_def_cd.value != ""
                        && formObj.por_def_cd.value.length < 2) {
                    ComShowCodeMessage('PRI02006', 'POR');
                    formObj.por_def_cd.value="";
                    formObj.por_def_cd.focus();
                    return false;
                }
                if (formObj.pol_def_cd.value != ""
                        && formObj.pol_def_cd.value.length < 2) {
                    ComShowCodeMessage('PRI02006', 'POL');
                    formObj.pol_def_cd.value="";
                    formObj.pol_def_cd.focus();
                    return false;
                }
                if (formObj.pod_def_cd.value != ""
                        && formObj.pod_def_cd.value.length < 2) {
                    ComShowCodeMessage('PRI02006', 'POD');
                    formObj.pod_def_cd.value="";
                    formObj.pod_def_cd.focus();
                    return false;
                }
                if (formObj.del_def_cd.value != ""
                        && formObj.del_def_cd.value.length < 2) {
                    ComShowCodeMessage('PRI02006', 'DEL');
                    formObj.del_def_cd.value="";
                    formObj.del_def_cd.focus();
                    return false;
                }
                break;
            case IBINSERT: //Row Add
                if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "") {
                    ComShowCodeMessage('PRI02007');
                    return false;
                }
                if (sheetObjects[1].RowCount()< 1) {
                    ComShowCodeMessage('PRI02008');
                    return false;
                }
                break;
            case IBSAVE: //DETAIL SAVE
                if (ComGetObjValue(formObj.flt_pct_tp_cd) == "P" && ComGetObjValue(comboObjects[2]) == "") {
                    ComShowCodeMessage('PRI02005');
                    return false;
                }
                // Check save when zero Amount exists
                var isConfirm=false;
                var rCnt=sheetObjects[2].RowCount()+ 1;
                for(var i=2; i<=rCnt; i++) {
                    if(sheetObjects[2].GetCellValue(i, "ibflag") != "D" && sheetObjects[2].GetCellValue(i, "scg_amt") == 0) {
                	//if(sheet2.GetCellValue(i, "ibflag") != "D" && sheet2.GetCellValue(i, "scg_amt") == 0) {
                        if(ComShowCodeConfirm('PRI02003')) {
                            isConfirm=true;
                            break;
                        } else {
                            sheetObjects[2].SelectCell(i, "scg_amt");
                            return false;
                        }
                    }
                }
                if(ComTrim(comboObjects[0].GetSelectCode()) == "" || ComTrim(comboObjects[1].GetSelectCode()) == "") {
                    ComShowCodeMessage('PRI02007');
                    return false;
                }
                if (!sheetObjects[1].IsDataModified()&& !sheetObjects[2].IsDataModified()) {
                    ComShowCodeMessage('PRI00301');
                    return false;
                }
                if (sheetObjects[1].IsDataModified()
                        && sheetObjects[1].GetSaveString() == "") {
                    return false;
                }
                if (sheetObjects[2].IsDataModified()
                        && sheetObjects[2].GetSaveString() == "") {
                    return false;
                }
                // Percentage case, Mandatory Field
                if (formObj.flt_pct_tp_cd[1].checked == true){
                    for (var i=2; i <= rCnt; i++){
                        if (sheetObjects[2].GetCellValue(i, "pay_term_cd") == ""){
                            ComShowCodeMessage('PRI00316',"Pay Term");
                            sheetObjects[2].SelectCell(i, "pay_term_cd");
                            return false;
                        }
                    }
                }
                if(!isConfirm) { //When it has already confirmed, proceed to next
                    if (!ComPriConfirmSave()) { // If there wasn't confirm popup before, ask confirm to save 
                        return false;
                    }
                }
                break;
            case IBDELETE:
                if (ComGetObjValue(formObj.flt_pct_tp_cd) == "P"
                    && ComGetObjValue(comboObjects[2]) == "") {
                    ComShowCodeMessage('PRI02005');
                    return false;
                }
                if(sheetObj.RowCount()< 1) {
                    ComShowCodeMessage('PRI00013'); // NO DATA FOUND
                    return false;
                }
                if(!ComShowCodeConfirm('PRI02018', comboObjects[1].GetSelectText(), comboObjects[0].GetSelectText())) {
                    return false;
                }
                break;
            case IBRESET: //Row Add
                if (ComGetObjValue(formObj.flt_pct_tp_cd) == "P"
                    && ComGetObjValue(comboObjects[2]) == "") {
                    ComShowCodeMessage('PRI02005');
                    return false;
                }
                if (sheetObj.RowCount()< 1 || sheetObj.CheckedRows("chk") < 1) {
                    ComShowCodeMessage('COM12189');
                    return false;
                }
                break;
            case IBLOADEXCEL:
                if (ComGetObjValue(formObj.flt_pct_tp_cd) == "P"
                    && ComGetObjValue(comboObjects[2]) == "") {
                    ComShowCodeMessage('PRI02005');
                    return false;
                }
                if(sheetObjects[2].IsDataModified()) {
                    ComShowCodeMessage('PRI01057');
                    return false;
                }
                break;
            }
            return true;
    }
    
    //EXCELDOWNLOAD SEQ 제거
    function makeHiddenPriSkipCol(sobj){
        var lc = sobj.LastCol();
        var rtnStr = "";
        for(var i=0;i<=lc;i++){
           if( ! ( 1==sobj.GetColHidden(i) || sobj.GetCellProperty(0,i,"Type") == "CheckBox" || sobj.GetCellProperty(0,i,"Type") == "DummyCheck" 
              || sobj.GetCellProperty(0,i,"Type") == "Radio"||  sobj.GetCellProperty(0,i,"Type") == "Status" 
              ||  sobj.GetCellProperty(0,i,"Type") =="DelCheck" || sobj.GetCellProperty(0,i,"Type") =="Seq")){
              rtnStr += "|"+ i;
           }
        }
        return rtnStr.substring(1);
    }
    
    /**
     * set the condition for search <br>
     * @version 2015.09.18
     */    
    function makeSearchCondition(){
    	
    	var formObj = document.form;
    	var vPor = formObj.por_def_cd.value;
    	var vPol = formObj.pol_def_cd.value;
    	var vPod = formObj.pod_def_cd.value;
    	var vDel = formObj.del_def_cd.value;
    	
    	var vIsChkDR = formObj.prc_cgo_tp_cd_1[0].checked;
    	var vIsChkRF = formObj.prc_cgo_tp_cd_1[1].checked;
    	var vIsChkDG = formObj.prc_cgo_tp_cd_1[2].checked;
    	var vIsChkAK = formObj.prc_cgo_tp_cd_1[3].checked;
    	var vIsChkBB = formObj.prc_cgo_tp_cd_1[4].checked;
    	
    	var vEffDt = ComGetUnMaskedValue(formObj.eff_dt.value,"ymd");
    	var vImdg = scg_imdg_clss_cd.GetSelectCode();
    	
    	SearCondition = new Object();
    	SearCondition.POR = vPor;
    	SearCondition.POL = vPol;
    	SearCondition.POD = vPod;
    	SearCondition.DEL = vDel;
    	SearCondition.CGO_DR = vIsChkDR;
    	SearCondition.CGO_RF = vIsChkRF;
    	SearCondition.CGO_DG = vIsChkDG;
    	SearCondition.CGO_AK = vIsChkAK;
    	SearCondition.CGO_BB = vIsChkBB;
    	SearCondition.EFF_DT = vEffDt;
    	SearCondition.IMDG = vImdg;

    }
    
    /**
     * check the condition data of search to the current condition data <br>
     * @version 2015.09.18
     */ 
    function isChangeSearchCondition(){

    	var result = true;
    	
    	var formObj = document.form;
    	var vPor = formObj.por_def_cd.value;
    	var vPol = formObj.pol_def_cd.value;
    	var vPod = formObj.pod_def_cd.value;
    	var vDel = formObj.del_def_cd.value;
    	
    	var vIsChkDR = formObj.prc_cgo_tp_cd_1[0].checked;
    	var vIsChkRF = formObj.prc_cgo_tp_cd_1[1].checked;
    	var vIsChkDG = formObj.prc_cgo_tp_cd_1[2].checked;
    	var vIsChkAK = formObj.prc_cgo_tp_cd_1[3].checked;
    	var vIsChkBB = formObj.prc_cgo_tp_cd_1[4].checked;
    	
    	var vEffDt = ComGetUnMaskedValue(formObj.eff_dt.value,"ymd");
    	var vImdg = scg_imdg_clss_cd.GetSelectCode();
    	
    	if(vPor != SearCondition.POR) return false;
    	if(vPol != SearCondition.POL) return false;
    	if(vPod != SearCondition.POD) return false;
    	if(vDel != SearCondition.DEL) return false;
    	if(vIsChkDR != SearCondition.CGO_DR) return false;
    	if(vIsChkRF != SearCondition.CGO_RF) return false;
    	if(vIsChkDG != SearCondition.CGO_DG) return false;
    	if(vIsChkAK != SearCondition.CGO_AK) return false;
    	if(vIsChkBB != SearCondition.CGO_BB) return false;
    	if(vEffDt != SearCondition.EFF_DT) return false;
    	if(vImdg != SearCondition.IMDG) return false;
	
    	return result;
    	
    }
