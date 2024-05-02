/*=========================================================
**Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_0005.js
 *@FileTitle  :  Standard Note Creation
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/04/28
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Standard Note Creation :  business script for Standard Note Creation 
     */
    // global variables
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var errMsg="";
    var eventStatus="";
    var eventStatus2="";
    var selectedMrow=-1;
    var selectedDrow=-1;
    var selectedGlineSeq="";
    // Event handler processing by button click event
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     */
    function processButtonClick(){
//        var sheetObject1 = sheetObjects[0];
//        var sheetObject2 = sheetObjects[1];
//        var sheetObject3 = sheetObjects[2];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
    		
            switch(srcName) {
                case "btn_retrieve":
                	ComOpenWait(true);
                    doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
                    ComOpenWait(false);
                    break;
                case "btn_new":
                	sheetObjects[0].RemoveAll();
                	sheetObjects[1].RemoveAll();
                	sheetObjects[2].RemoveAll();
                	sheetObjects[3].RemoveAll();
                	formObject.reset();$(formObject).find("input[type=hidden]").val("");
                    break;
                case "btn_save":
                    doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
                    break;
                case "btn_confirm":
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC01);
                    break;
                case "btn_cancel":
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC02);
                    break;
                case "btn_copy":
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC04);
                    break;  
                case "btn_add":
                    doActionIBSheet(sheetObjects[1], formObject, IBINSERT);
                    break;
                case "btn_add2":
                    doActionIBSheet(sheetObjects[2], formObject, IBINSERT);
                    break;  
                case "btn_delete":
                    doActionIBSheet(sheetObjects[1], formObject, IBDELETE);
                    break;
                case "btn_delete2":
                    doActionIBSheet(sheetObjects[2], formObject, IBDELETE);
                    break;
                case "btn_delete3":
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC03);
                    break;
                case "btns_calendar": 
                    if (comboObjects[0].GetSelectCode()== "") {
                        ComShowCodeMessage('PRI08002');
                        return false;
                    }
                    var cal=new ComCalendarFromTo();
                    cal.select(formObject.eff_dt, formObject.exp_dt, 'yyyy-MM-dd');
                    break;  
				case "btn_downexcel":
					doActionIBSheet(sheetObjects[3],document.form,IBDOWNEXCEL);
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
     * registering IBSheet Object as list <br>
     * adding process for list in case of needing batch processing with other items  <br>
     * defining list on the top of source <br>
     */ 
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * registering IBMulti Combo Object as array <br>
     * adding process for list in case of needing batch processing with other items  <br>
     * defining list on the top of source <br>
     */ 
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * Initializing and setting Sheet basics <br>
     * Setting body tag's onLoad event handler <br>
     * Adding pre-handling function after loading screen on the browser  <br>
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        //initializing IBMultiCombo
        for(var k=0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }
      //  axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerForm('focus', 'obj_activate', document.form);
        axon_event.addListenerForm('blur', 'obj_deactivate', document.form);
        toggleButtons("INIT");    
    /**
     * calling function when occurring LoadFinish event <br>
     */
        sheetObjects.WaitImageVisible=false;
        doActionIBSheet(sheetObjects[2], document.form, IBCLEAR);
        
    }
    
    /**
     * handling Onactivate event <br>
     */ 
    function obj_activate() {
    	var formObject=document.form;
	    var srcName=ComGetEvent("name");
//	    ComClearSeparator(ComGetEvent());
    	
	    //오직 calender 로 입력했을때 입력한 값을 콤보 박스에 넣어주기 위함.
	    if ((srcName == "eff_dt" || srcName == "exp_dt") && formObject.eff_dt.value != "") {
	    	formObject.gline_seq_text.value = formObject.eff_dt.value;
	    }
    }
    /**
     * handling OnDeactivate event <br>
     */ 
    function obj_deactivate() {
    	var formObject=document.form;
	    var srcName=ComGetEvent("name");
	    switch(srcName){    
	    	case "gline_seq_text": //콤보박스에 직접 입력했을 경우 숨겨진 eff_dt 값을 넣어주기 위함.  
	    		formObject.eff_dt.value = formObject.gline_seq_text.value;
	    		ComChkObjValid(ComGetEvent()); 
	    		break;
	    }
    	
    }
   
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     */  
    function initSheet(sheetObj,sheetNo) {
    	
        var cnt=0;        
		        
           switch(sheetObj.id) {
       		  case "sheet0":
	        	   with(sheetObj){//hidden
			           var HeadTitle="status";
			
			           SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );
			
			           var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			           var headers = [ { Text:HeadTitle, Align:"Center"} ];
			           InitHeaders(headers, info);
			
			           var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];		            
			           InitColumns(cols);
			           SetVisible(false);
	              }
            break; 
            case "sheet1":      //t1sheet1 init)
	                with(sheetObj){
			              var HeadTitle="|Sel.|Del Check|Seq.|Title|dp_seq|note_hdr_seq|note_seq|prc_cust_tp_cd|svc_scp_cd|note_tit_nm";
			
			              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			
			              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			              var headers = [ { Text:HeadTitle, Align:"Center"} ];
			              InitHeaders(headers, info);
			
			              var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			                     {Type:"DelCheck",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
			                     {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
			                     {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"note_tit_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"dp_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_hdr_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_cust_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];	               
			              InitColumns(cols);	
			              SetEditable(1);
			              SetWaitImageVisible(0);
			              SetColHidden("del_chk",1);
			              SetSheetHeight(220);
              	}
                break;
            case "sheet2":      //t1sheet1 init
	                with(sheetObj){
	                
		              var HeadTitle="|Sel.|Del Seq|Seq.|Content|Conversion|Conversion|dp_seq|note_hdr_seq|note_seq|note_ctnt_seq|prc_cust_tp_cd|svc_scp_cd|";
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                     {Type:"DelCheck",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
		                     {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                     {Type:"Text",      Hidden:0, Width:700,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"note_conv_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Popup",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"conversion_pop",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"dp_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_hdr_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_ctnt_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_cust_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_mapg_id" } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetWaitImageVisible(0);
		              SetShowButtonImage(2);
		              SetColHidden("del_chk",1);
		              SetAutoRowHeight(0);
		              SetSheetHeight(160);
              }
                break; 
            case "sheet3":      //DOWNEXCEL
            		with(sheetObj){
	                
		              var HeadTitle="Seq.|Title|Content|Conversion";
		
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"note_tit_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:700,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"note_conv_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(0);
		              SetWaitImageVisible(0);
		              //SetSheetHeight(220);
	            }
            break;
        }
	  
    }
    /**
     * occurring before clicking check button on the sheet <br>
     */
    function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
        var colName=sheetObj.ColSaveName(Col);
        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(1, 3), 0, Row, Col);
        }
    }
    /**
     * occurring before clicking check button on the sheet <br>
     */
    function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
        var colName=sheetObj.ColSaveName(Col);
        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(1, 3), 1, Row, Col);
        }
    } 
    /**
     * handling saveEnd event <br>
     */
    function sheet0_OnSaveEnd(sheetObj, ErrMsg)  {
        //if (ErrMsg != "") {
//        errMsg = ErrMsg;
        //}
    }
    /**
     * handling saveEnd event <br>
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
        //if (ErrMsg != "") {
//      errMsg = ErrMsg;
        //}
    }
    /**
     * handling saveEnd event <br>
     */
    function sheet2_OnSaveEnd(sheetObj, ErrMsg)  {
        var formObj=document.form;
        if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
            if(formObj.f_cmd.value == MULTI01) {
            	formObj.note_seq.value=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "note_seq");
            }
            doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
            //note_nm combo
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC05);
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);   
            //doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
            
            doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
        }
    }
    /**
     * calling function when clicking sheet's cell <br>
     */
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if(eventStatus == "IBSAVE") return;
        selectedDrow = Math.max(NewRow - sheetObj.RowCount("D"), sheetObj.HeaderRows());
    }
    /**
     * calling function when clicking sheet's cell <br>
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if(eventStatus == "IBSAVE") return;
        selectedMrow = Math.max(NewRow - sheetObj.RowCount("D"), sheetObj.HeaderRows());
        doRowChange(sheetObjects[1], sheetObjects[2], OldRow, NewRow, OldCol, NewCol, false);
    }
    var isFiredNested=false;
    var supressConfirm=false;
    /**
     * calling function when occurring sheet1_OnSelectCell event <br>
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
                var idx=sheetM.DataInsert();
                isFiredNested=false;
                return idx;
            } else {
            	formObj.note_seq.value=sheetM.GetCellValue(adjNewRow, "note_seq");
                if(formObj.note_seq.value == "undefined" || ComIsEmpty(formObj.note_seq.value)) {
                	formObj.note_seq.value=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"note_seq");
                }
                if(formObj.note_hdr_seq.value == "undefined" || ComIsEmpty(formObj.note_hdr_seq.value)) {
                    formObj.note_hdr_seq.value=getNoteNmCd();
                }
                isFiredNested=true;
                doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
                isFiredNested=false;
                showMemoPad(sheetM, NewRow, NewCol);
            }
        } 
    }
    /**
     * Handling sheet process <br>
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBCLEAR: 
                // when screen loading Service Scope retrieve
                formObj.f_cmd.value=SEARCH01;
                var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
                ComPriXml2ComboItem(sXml, svc_scp_cd, "cd", "cd|nm");
                // when screen loadingcustomer type retrieve
                formObj.f_cmd.value=SEARCH20;
                formObj.cd.value="CD01714";
                sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
                ComPriXml2ComboItem(sXml, prc_cust_tp_cd, "cd", "cd|nm");
                prc_cust_tp_cd.InsertItem(0,'','');
                break;  
            case IBCREATE: // when selecting Service Scope , Duration retrieve
            	var xdate = gline_seq.GetSelectText();
                formObj.f_cmd.value=SEARCH05;
                var sXml=sheetObj.GetSearchData("ESM_PRI_0005GS.do", FormQueryString(formObj));
                //ComPriXml2ComboItem(sXml, formObj.eff_dt, "eff_dt", "eff_dt|exp_dt");
                ComPriXml2ComboItem(sXml, gline_seq, "note_hdr_seq", "eff_dt|exp_dt|eff_dt");
                gline_seq.SetSelectText(xdate, false);
                break;  
            case IBSEARCH:      //retrieve
                if (validateForm(sheetObj, formObj, sAction)) {
                    try {
                        for (var i=0; i < sheetObjects.length; i++) {
                            sheetObjects[i].SetWaitImageVisible(0);
                        }    
                        if ( sheetObj.id == "sheet0") {
                            formObj.f_cmd.value=SEARCH01;
                            //formObj.note_hdr_seq.value = "";
                            var sXml=sheetObj.GetSearchData("ESM_PRI_0005GS.do", FormQueryString(formObj));
                            var arrData=ComPriXml2Array(sXml, "note_hdr_seq|prc_cust_tp_cd|cfm_flg|note_nm|note_ref_yr|eff_dt|exp_dt|svc_scp_cd");
                            if (arrData != null && arrData.length > 0) {
                                formObj.note_hdr_seq.value=arrData[0][0];
                                //formObj.prc_cust_tp_cd.value = arrData[0][1];
                                formObj.note_ref_yr.value=arrData[0][4];
                                comboObjects[3].SetSelectCode(arrData[0][1],false);
                                formObj.cfm_flg.value=arrData[0][2];
                                comboObjects[2].SetSelectCode(arrData[0][0],false);
                                formObj.svc_scp_cd_hidden.value=arrData[0][7];
                                formObj.note_nm_hidden.value=arrData[0][3];
                                formObj.note_ref_yr_hidden.value=arrData[0][4];
                                formObj.eff_dt_hidden.value=arrData[0][5];
                                formObj.exp_dt_hidden.value=arrData[0][6];
                                formObj.prc_cust_tp_cd_hidden.value=arrData[0][1];
                                comboObjects[1].SetSelectText(arrData[0][5],false);
                                formObj.exp_dt.value=arrData[0][6];
                            } else {
                                //comboObjects[2].Index = "-1";
                                formObj.note_hdr_seq.value="";
                                formObj.cfm_flg.value="";
                                formObj.note_nm.value="";
                                formObj.svc_scp_cd_hidden.value="";
                                formObj.note_nm_hidden.value="";
                                formObj.note_ref_yr_hidden.value="";
                                formObj.eff_dt_hidden.value="";
                                formObj.exp_dt_hidden.value="";
                                formObj.prc_cust_tp_cd_hidden.value="";
                            }
                            setConfirmButton();
                        } else if ( sheetObj.id == "sheet1") {
                            formObj.f_cmd.value=SEARCH02;
                            for (var i=0; i < sheetObjects.length; i++) {
                                sheetObjects[i].RemoveAll();
                            }
                            sheetObj.DoSearch("ESM_PRI_0005GS.do", FormQueryString(formObj), {Sync:1} );
                            setConfirmButton();
                        } else if ( sheetObj.id == "sheet2") {
                            formObj.f_cmd.value=SEARCH03;
                            sheetObj.DoSearch("ESM_PRI_0005GS.do", FormQueryString(formObj) , {Sync:1} );
                            setConfirmButton();
                        }   
                    } catch (e) {
                        if (e == "[object Error]") {
                            ComShowMessage(OBJECT_ERROR);
                        } else {
                            ComShowMessage(e);
                        }
                    } finally {
                    }
                }     
                break;
            case IBSAVE:        //save
                if(eventStatus == "IBCOPY") {
                    if (!validateForm(sheetObj,document.form,IBSEARCH_ASYNC04)) return;
                    if (ComShowCodeConfirm('PRI00012')) {
                        formObj.f_cmd.value=MULTI05;
                        formObj.note_nm.value=getNoteNmTxt();
                        var sParam=FormQueryString(formObj);
                        sParam += "&" + ComPriSetPrifix(sheetObjects[1].GetSaveString(), "sheet1_");
                        sParam += "&" + ComPriSetPrifix(sheetObjects[2].GetSaveString(), "sheet2_");
                        try {
                            ComOpenWait(true);
                            var sXml=sheetObj.GetSaveData("ESM_PRI_0005GS.do", sParam);
                            if(typeof ComGetEtcData(sXml, "note_hdr_seq") != "undefined" && ComGetEtcData(sXml, "note_hdr_seq") != "") {
                                formObj.note_hdr_seq.value=ComGetEtcData(sXml, "note_hdr_seq");
                            }
                            sheetObjects[2].LoadSaveData(sXml, {Sync:1});
                            sXml=ComDeleteMsg(sXml);
                            sheetObjects[1].LoadSaveData(sXml, {Sync:1});
                            ComOpenWait(false);
                        } catch (e) {
                            if (e == "[object Error]") {
                                ComShowMessage(OBJECT_ERROR);
                            } else {
                                ComShowMessage(e);
                            }
                        } finally {
                            ComOpenWait(false);
                        }
                    }
                    eventStatus="";
    	            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    	            doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
                } else {
                    try {
                        ComOpenWait(true);
                        if (!validateForm(sheetObj,document.form,sAction)) {
                            return false;
                        }
                        if (!supressConfirm && !ComPriConfirmSave()) {
                            return false;
                        }
                        eventStatus="IBSAVE";
                        formObj.f_cmd.value=MULTI01;
                        formObj.note_nm.value=getNoteNmTxt();
                        setDpSeq(sheetObjects[1]);
                        setDpSeq(sheetObjects[2]);
                        var sParam=FormQueryString(formObj);
                        sParam += "&" + ComPriSetPrifix(sheetObjects[1].GetSaveString(), "sheet1_");
                        sParam += "&" + ComPriSetPrifix(sheetObjects[2].GetSaveString(), "sheet2_");
                        var sXml=sheetObj.GetSaveData("ESM_PRI_0005GS.do", sParam);
                        if(typeof ComGetEtcData(sXml, "note_hdr_seq") != "undefined" && ComGetEtcData(sXml, "note_hdr_seq") != "") {
                            formObj.note_hdr_seq.value=ComGetEtcData(sXml, "note_hdr_seq");
                        }
                        sheetObjects[2].LoadSaveData(sXml, {Sync:1});
                        sXml=ComDeleteMsg(sXml);
                        sheetObjects[1].LoadSaveData(sXml, {Sync:1});
                        ComOpenWait(false);
                    } catch (e) {
                        if (e == "[object Error]") {
                            ComShowMessage(OBJECT_ERROR);
                        } else {
                            ComShowMessage(e);
                        }
                    } finally {
                        ComOpenWait(false);
                    }
                    eventStatus="";
                    eventStatus2="";
                }
                break;
            case IBSEARCH_ASYNC01:        //confirm
                if (validateForm(sheetObjects[0],document.form,IBSEARCH_ASYNC01)) {
                    if (ComPriConfirmConfirm()) {
                        try {
                            ComOpenWait(true);
                            formObj.f_cmd.value=MULTI02;
                            //formObj.cfm_flg.value = "Y";
                            var sParam=FormQueryString(formObj);
                            var sXml=sheetObj.GetSaveData("ESM_PRI_0005GS.do", sParam);
                            ComOpenWait(false);
                        } catch (e) {
                            if (e == "[object Error]") {
                                ComShowMessage(OBJECT_ERROR);
                            } else {
                                ComShowMessage(e);
                            }
                        } finally {
                            ComOpenWait(false);
                        }
                        ComPriConfirmCompleted();
                        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                    }   
                }
                break;  
            case IBSEARCH_ASYNC02:        //confirm CANCEL
                if (validateForm(sheetObjects[0],document.form,IBSEARCH_ASYNC02)) {
                    if (ComPriConfirmCancelConfirm()) {
                        try {
                            ComOpenWait(true);
                            formObj.f_cmd.value=MULTI03;
                            //formObj.cfm_flg.value = "N";
                            var sParam=FormQueryString(formObj);
                            var sXml=sheetObj.GetSaveData("ESM_PRI_0005GS.do", sParam);
                            ComOpenWait(false);
                        } catch (e) {
                            if (e == "[object Error]") {
                                ComShowMessage(OBJECT_ERROR);
                            } else {
                                ComShowMessage(e);
                            }
                        } finally {
                            ComOpenWait(false);
                        }
                        ComPriCancelConfirmCompleted();
                        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                    }   
                }
                break;  
            case IBSEARCH_ASYNC03:        //all delete
                if (validateForm(sheetObjects[0],document.form,IBSEARCH_ASYNC03)) {
                    if (ComPriConfirmDeleteAll()) {
                        try {
                            ComOpenWait(true);
                            formObj.f_cmd.value=MULTI04;
                            var sParam=FormQueryString(formObj);
                            var sXml=sheetObj.GetSaveData("ESM_PRI_0005GS.do", sParam);
                            sheetObj.LoadSaveData(sXml, {Sync:1});
        	  		        if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
        	  		        		removeAll2(formObj);
        	  		        }        	  				
                            ComOpenWait(false);
                        } catch (e) {
                            if (e == "[object Error]") {
                                ComShowMessage(OBJECT_ERROR);
                            } else {
                                ComShowMessage(e);
                            }
                        } finally {
                            ComOpenWait(false);
                        }
                    }   
                }
                break;          
            case IBINSERT: // Row Add
                if (validateForm(sheetObj,document.form,sAction)) {
                    if (sheetObj.id == "sheet1") {
//                      var idx = doRowChange(sheetObjects[1], sheetObjects[2], sheetObjects[1].SelectRow, 
//                      sheetObjects[1].SelectRow + 1, sheetObjects[1].SelectCol, true);
                        var idx=doRowChange(sheetObj, sheetObjects[2], sheetObj.GetSelectRow(), sheetObj.GetSelectRow()+ 1, sheetObj.GetSelectCol(), sheetObj.GetSelectCol(), true);
                        if (idx < 0) {
                            return false;
                        }
                        //service scoup
                        sheetObj.SetCellValue(idx, "svc_scp_cd",getSvcScpCd());
                        //customer type
                        sheetObj.SetCellValue(idx, "prc_cust_tp_cd",getCustTypeCd());
                        //header sequence
                        sheetObj.SetCellValue(idx, "note_hdr_seq",formObj.note_hdr_seq.value);
                        sheetObj.SetCellValue(idx, "note_seq",parseInt(ComPriGetMax(sheetObj, "note_seq")) + 1);
                        sheetObjects[2].RemoveAll();
                        sheetObj.SelectCell(idx, "note_tit_nm");
                    }
                    if (sheetObj.id == "sheet2") {
                        var idx=sheetObj.DataInsert();
                        //service scoup
                        sheetObj.SetCellValue(idx, "svc_scp_cd",getSvcScpCd());
                        //customer type
                        sheetObj.SetCellValue(idx, "prc_cust_tp_cd",getCustTypeCd());
                        //header sequence
                        sheetObj.SetCellValue(idx, "note_hdr_seq",formObj.note_hdr_seq.value);
                        var note_seq=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "note_seq");
                        sheetObj.SetCellValue(idx, "note_seq",note_seq);
                        sheetObj.SetCellValue(idx, "note_ctnt_seq",parseInt(ComPriGetMax(sheetObj, "note_ctnt_seq")) + 1);
                        sheetObj.SetCellValue(idx, "note_conv_flg","N");
                		sheetObj.SetCellValue(idx, "conversion_pop"," ");
                        sheetObj.SelectCell(idx, "note_ctnt");
                    }
                }
                break;
            case IBDELETE: // Delete
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                if (sheetObj.CheckedRows("chk") <= 0) {
                    sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1");
                }
//              var delCnt = deleteRowCheck(sheetObj, "chk");
//              if (delCnt > 0 && sheetObj.id == "sheet1") {
//              for (var i = sheetObjects[2].HeaderRows(); sheetObjects[2].RowCount() > 0 && i <= sheetObjects[2].LastRow(); i++) {
//              sheetObjects[2].CellValue(i, "chk") = "1";
//              }
//              deleteRowCheck(sheetObjects[2], "chk");
//              }
                if (sheetObj.id == "sheet1" && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "chk") == "1") {
                    sheetObjects[2].RemoveAll();
                }
                var delCnt=deleteRowCheck(sheetObj, "chk");
                if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "D") {
                    sheetObjects[2].RemoveAll();
                }
                break;
            case IBSEARCH_ASYNC04:        //COPY
                if (validateForm(sheetObjects[0],document.form,IBSEARCH_ASYNC04)) {
                    removeCopy(document.form);
                    eventStatus="IBCOPY";
                    toggleButtons(eventStatus);
                }
                break;  
            case IBSEARCH_ASYNC05:        //NOTE_NM COMBO SEARCH
                if (validateForm(sheetObjects[0],document.form,IBSEARCH)) {
                	var xText = note_nm_cd.GetSelectText();
                	formObj.f_cmd.value=SEARCH01;
                    formObj.note_hdr_seq.value="";
                    var sXml=sheetObj.GetSearchData("ESM_PRI_0005GS.do", FormQueryString(formObj));
                    ComPriXml2ComboItem(sXml, note_nm_cd, "note_hdr_seq", "note_nm");
                    note_nm_cd.SetSelectText(xText, false);
                    break;  
                }
                break;
			case IBDOWNEXCEL:
				try {
					if (validateForm(sheetObj,document.form,sAction)) {
		  				ComOpenWait(true);
						formObj.f_cmd.value=SEARCH06;
						sheetObj.DoSearch("ESM_PRI_0005GS.do", FormQueryString(formObj), {Sync: 2} );
						//sheetObj.SpeedDown2Excel(-1);
//						sheetObj.Down2Excel({ HiddenColumn:-1,URL:"apps/opus/esm/pri/scguideline/scbasicstandardnoteguideline/script/ESM_PRI_0005.xml"});
						//sheetObj.SetHeaderBackColor("#CCCCCC");
						sheetObj.Down2Excel({ SheetDesign:1,DownCols:makeHiddenSkipCol(sheetObj)});
						//sheetObj.SetHeaderBackColor("#333333");
					} else {
						ComShowCodeMessage('PRI08001');
					}
                } catch (e) {
                    if (e == "[object Error]") {
                        ComShowMessage(OBJECT_ERROR);
                    } else {
                        ComShowMessage(e);
                    }
                } finally {
                    ComOpenWait(false);
                }
				break;
        }
    }
    /**
     * loading IBSHEET COMBO<br>
     */ 
    function initCombo(comboObj, comboNo) {
        switch(comboObj.options.id) {
            case "svc_scp_cd":
                with(comboObj) {
                    SetDropHeight(260);
                    SetMultiSelect(0);
                    SetUseAutoComplete(1);
                    ValidChar(2);
                    SetMaxLength(3);
                }
                break;
            case "gline_seq":
                with(comboObj) {
                    SetDropHeight(260);
                    SetMultiSelect(0);
    	            SetMaxSelect(1);
    	            SetUseAutoComplete(1);
    	            SetUseEdit(1);
    	            // add 2014.07.28
    	            setComnoBySlineSeq(comboObj);  
                }
                break;
            case "note_nm_cd":
                with(comboObj) {
                    SetDropHeight(260);
                    SetMultiSelect(0);
//                    SetUseEdit(true);
//                  MaxSelect = 1;
                    SetUseAutoComplete(0);
                }
                break;      
            case "prc_cust_tp_cd":
                with(comboObj) {
                    SetDropHeight(260);
                    SetMultiSelect(0);
//                  MaxSelect = 1;
                    //no support[check again]CLT ValidChar(2, 0);
                    ValidChar(2);
                    SetMaxLength(1);
                    SetColWidth(0, "18");
                    SetColWidth(1, "170");
                }
                break;     
        }
    }
    
	
	function setComnoBySlineSeq(comboObj) {
		 with(comboObj) { 
                 SetColWidth(0, "80");
                 SetColWidth(1, "100");
                 SetColWidth(2, "0");
	       }
	}
	
    /**
     * checking validation process of inputed form data <br>
     */
    function validateForm(sheetObj,formObj,sAction){
        switch (sAction) {
            case IBCREATE: // when selecting service scope 
                if ( sheetObj.id == "sheet0") {
                    if (ComIsEmpty(formObj.note_ref_yr.value)) {
                        ComPriInputValueFailed("input","year",formObj.note_ref_yr);
                        return false;
                    }
                } else if( sheetObj.id == "sheet1") {
                    if (ComIsEmpty(formObj.note_ref_yr.value)) {
                        ComPriInputValueFailed("i","year",formObj.note_ref_yr);
                        return false;
                    }
                    if (ComIsEmpty(comboObjects[0].GetSelectText())) {
                        ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
                        return false;
                    }
                }
                return true;
                break;
            case IBSEARCH: // retrieve
                if ( sheetObj.id == "sheet0") {
                    if (ComIsEmpty(formObj.note_ref_yr.value)) {
                        ComPriInputValueFailed("input","year",formObj.note_ref_yr);
                        return false;
                    }   
//                  if(!ComIsNumber(document.form.note_ref_yr,'0123456789')) {
//                  ComShowCodeMessage('PRI00311');
//                  document.form.note_ref_yr.value = "";
//                  return;
//                  }
                    if (ComIsEmpty(comboObjects[0].GetSelectText())) {
                        ComShowCodeMessage('PRI08002');
                        return false;
                    }
                } else if ( sheetObj.id == "sheet1") {  
                    if (ComIsEmpty(formObj.note_ref_yr.value)) {
                        ComPriInputValueFailed("input","year",formObj.note_ref_yr);
                        return false;
                    }   
                    if (ComIsEmpty(comboObjects[0].GetSelectText())) {
                        ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
                        return false;
                    }
                    if (ComIsEmpty(comboObjects[1].GetSelectText())) {
                        ComPriInputValueFailed("input","Duration",comboObjects[1]);
                        return false;
                    }
                    if (ComIsEmpty(formObj.exp_dt.value)) {
                        ComPriInputValueFailed("input","Duration",formObj.exp_dt);
                        return false;
                    }
                    if (ComIsEmpty(comboObjects[2].GetSelectText())) {
                        ComPriInputValueFailed("input","Standard Note",comboObjects[2]);
                        return false;
                    }
                }
                return true;
                break;
            case IBSAVE: // save
                if (ComIsEmpty(formObj.note_ref_yr.value)) {
                    ComPriInputValueFailed("input","year",formObj.note_ref_yr);
                    return false;
                }       
                if (ComIsEmpty(comboObjects[0].GetSelectText())) {
                    ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
                    return false;
                }
                if (ComIsEmpty(comboObjects[1].GetSelectText())) {
                    ComPriInputValueFailed("input","Duration",comboObjects[1]);
                    return false;
                }
                if (ComIsEmpty(formObj.exp_dt.value)) {
                    ComPriInputValueFailed("input","Duration",formObj.exp_dt);
                    return false;
                }
                var eff_dt=removeDash(formObj.eff_dt.value);
                var exp_dt=removeDash(formObj.exp_dt.value);
                if (eff_dt > exp_dt) {
                    ComShowCodeMessage('PRI00305', '[Duration]');
                    return false;
                }
                var note_ref_year=formObj.note_ref_yr.value;
                if (note_ref_year != eff_dt.substr(0,4) && note_ref_year != exp_dt.substr(0,4)) {
                    ComShowCodeMessage('PRI00323');
                    formObj.note_ref_yr.focus();
                    return false;
                }
                if (ComIsEmpty(comboObjects[2].GetSelectText())) {
                    ComPriInputValueFailed("input","Standard Note",comboObjects[2]);
                    return false;
                }
                if (formObj.cfm_flg.value == "Yes" && eventStatus2 != "CONV") {
//                  ComShowCodeMessage('PRI00105');
                    return false;
                }
                if(!checkModified(formObj)) {
                    ComShowCodeMessage("PRI00301");
                    return false;
                }   
                if (sheetObjects[1].RowCount()<= 0 || sheetObjects[1].GetSelectRow()<= 0) {
                    ComPriInputValueFailed("input","Title","");
                    doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
                    return false;
                }
                if (!isDeleted(sheetObjects[1]) && getValidRowCount(sheetObjects[2]) <= 0) {
                    ComShowCodeMessage("PRI00319", "Content");
                    doActionIBSheet(sheetObjects[2], document.form, IBINSERT);
                    return false;
                }
                if (sheetObjects[1].IsDataModified()&& sheetObjects[1].GetSaveString() == "") {
                    return false;
                }
                if (sheetObjects[2].IsDataModified()&& sheetObjects[2].GetSaveString() == "") {
                    return false;
                }
                if (sheetObjects[1].IsDataModified()) {
                    var rowM=sheetObjects[1].ColValueDup("svc_scp_cd|prc_cust_tp_cd|note_hdr_seq|note_seq",false);
                    if (rowM >= 0) {
                        ComShowCodeMessage("PRI00303", "Sheet1", rowM);
                        return false;
                    }               
                }
                if (sheetObjects[2].IsDataModified()) {
                    var rowD=sheetObjects[2].ColValueDup("svc_scp_cd|prc_cust_tp_cd|note_hdr_seq|note_seq|note_ctnt_seq",false);
                    if (rowD >= 0) {
                        ComShowCodeMessage("PRI00303", "Sheet2", rowD);
                        return false;
                    }               
                }
//              if (sheetObjects[1].RowStatus(sheetObjects[1].SelectRow) != "D"
//              && getValidRowCount(sheetObjects[2]) <= 0) {
//              ComShowCodeMessage("PRI00319", "Title");
//              return false;
//              }
//                formObj.eff_dt.value=setDash(eff_dt);
//                formObj.exp_dt.value=setDash(exp_dt);
//                formObj.eff_dt.value=eff_dt;
//                formObj.exp_dt.value=exp_dt;
                return true;
                break;
            case IBINSERT: // Row Add
                if (ComIsEmpty(formObj.note_ref_yr.value)) {
                    ComPriInputValueFailed("input","year",formObj.note_ref_yr);
                    return false;
                }       
                if (ComIsEmpty(comboObjects[0].GetSelectText())) {
                    ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
                    return false;
                }
                if (ComIsEmpty(comboObjects[1].GetSelectText())) {
                    ComPriInputValueFailed("input","Duration",comboObjects[1]);
                    return false;
                }
                if (ComIsEmpty(formObj.exp_dt.value)) {
                    ComPriInputValueFailed("input","Duration",formObj.exp_dt);
                    return false;
                }
                if (ComIsEmpty(comboObjects[2].GetSelectText())) {
                    ComPriInputValueFailed("input","Standard Note",comboObjects[2]);
                    return false;
                }
                if (formObj.cfm_flg.value == "Yes") {
//                  ComShowCodeMessage('PRI00105');
                    return false;
                }
                return true;
                break;
            case IBSEARCH_ASYNC01: // CONFIRM
                if (eventStatus == "IBCOPY") {
                    return false;
                }
                if (ComIsEmpty(formObj.note_hdr_seq.value)) {
                    return false;
                }   
                if (ComIsEmpty(formObj.note_ref_yr.value)) {
                    ComPriInputValueFailed("input","year",formObj.note_ref_yr);
                    return false;
                }       
                if (ComIsEmpty(comboObjects[0].GetSelectText())) {
                    ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
                    return false;
                }
                if (ComIsEmpty(comboObjects[1].GetSelectText())) {
                    ComPriInputValueFailed("input","Duration",comboObjects[1]);
                    return false;
                }
                if (ComIsEmpty(formObj.exp_dt.value)) {
                    ComPriInputValueFailed("input","Duration",formObj.exp_dt);
                    return false;
                }
                if (ComIsEmpty(comboObjects[2].GetSelectText())) {
                    ComPriInputValueFailed("input","Standard Note",comboObjects[2]);
                    return false;
                }
                if (formObj.cfm_flg.value == "Yes") {
//                  ComShowCodeMessage('PRI00105');
                    return false;
                }
                if (sheetObjects[1].RowCount()<= 0 || sheetObjects[1].GetSelectRow()<= 0) {
                    ComPriInputValueFailed("input","Title","");
                    doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
                    return false;
                }
                if (!isDeleted(sheetObjects[1]) && getValidRowCount(sheetObjects[2]) <= 0) {
                    ComShowCodeMessage("PRI00319", "Content");
                    doActionIBSheet(sheetObjects[2], document.form, IBINSERT);
                    return false;
                }
                if (checkModified(formObj)) {
                    ComShowCodeMessage("PRI03009","");
                    return false;
                }
                return true;
                break;
            case IBSEARCH_ASYNC02: //CONFIRM cancel
                if (eventStatus == "IBCOPY") {
                    return false;
                }
                if (ComIsEmpty(formObj.note_hdr_seq.value)) {
                    return false;
                }
                if (ComIsEmpty(formObj.note_ref_yr.value)) {
                    ComPriInputValueFailed("input","year",formObj.note_ref_yr);
                    return false;
                }   
                if (ComIsEmpty(comboObjects[0].GetSelectText())) {
                    ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
                    return false;
                }
                if (ComIsEmpty(comboObjects[1].GetSelectText())) {
                    ComPriInputValueFailed("input","Duration",comboObjects[1]);
                    return false;
                }
                if (ComIsEmpty(formObj.exp_dt.value)) {
                    ComPriInputValueFailed("input","Duration",formObj.exp_dt);
                    return false;
                }
                if (ComIsEmpty(comboObjects[2].GetSelectText())) {
                    ComPriInputValueFailed("input","Standard Note",comboObjects[2]);
                    return false;
                }
                if (formObj.cfm_flg.value == "No") {
                    ComShowCodeMessage('PRI00106');
                    return false;
                }
                return true;
                break;  
            case IBSEARCH_ASYNC03: //All Delete
                if (eventStatus == "IBCOPY") {
                    return false;
                }
                if (ComIsEmpty(formObj.note_hdr_seq.value)) {
                    return false;
                }
                if (ComIsEmpty(formObj.note_ref_yr.value)) {
                    ComPriInputValueFailed("input","year",formObj.note_ref_yr);
                    return false;
                }   
                if (ComIsEmpty(comboObjects[0].GetSelectText())) {
                    ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
                    return false;
                }
                if (ComIsEmpty(comboObjects[1].GetSelectText())) {
                    ComPriInputValueFailed("input","Duration",comboObjects[1]);
                    return false;
                }
                if (ComIsEmpty(formObj.exp_dt.value)) {
                    ComPriInputValueFailed("input","Duration",formObj.exp_dt);
                    return false;
                }
                if (ComIsEmpty(comboObjects[2].GetSelectText())) {
                    ComPriInputValueFailed("input","Standard Note",comboObjects[2]);
                    return false;
                }
                if (formObj.cfm_flg.value == "Yes") {
//                  ComShowCodeMessage('PRI00105');
                    return false;
                }
                return true;
                break;      
            case IBDELETE: // Delete
                if (eventStatus == "IBCOPY") {
                    return false;
                }
                if (ComIsEmpty(formObj.note_hdr_seq.value)) {
                    return false;
                }
                if (ComIsEmpty(formObj.note_ref_yr.value)) {
                    ComPriInputValueFailed("input","year",formObj.note_ref_yr);
                    return false;
                }   
                if (ComIsEmpty(comboObjects[0].GetSelectText())) {
                    ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
                    return false;
                }
                if (ComIsEmpty(comboObjects[1].GetSelectText())) {
                    ComPriInputValueFailed("input","Duration",comboObjects[1]);
                    return false;
                }
                if (ComIsEmpty(formObj.exp_dt.value)) {
                    ComPriInputValueFailed("input","Duration",formObj.exp_dt);
                    return false;
                }
                if (ComIsEmpty(comboObjects[2].GetSelectText())) {
                    ComPriInputValueFailed("input","Standard Note",comboObjects[2]);
                    return false;
                }
                if (formObj.cfm_flg.value == "Yes") {
//                  ComShowCodeMessage('PRI00105');
                    return false;
                }
                return true;
                break;
            case IBSEARCH_ASYNC04: // COPY
                if (ComIsEmpty(formObj.note_hdr_seq.value)) {
                    ComShowCodeMessage('PRI08015');
                    return false;
                }
                if (ComIsEmpty(formObj.note_ref_yr.value)) {
                    ComPriInputValueFailed("input","year",formObj.note_ref_yr);
                    return false;
                }   
                if (ComIsEmpty(comboObjects[0].GetSelectText())) {
                    ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
                    return false;
                }
                if (ComIsEmpty(comboObjects[1].GetSelectText())) {
                    ComPriInputValueFailed("input","Duration",comboObjects[1]);
                    return false;
                }
                if (ComIsEmpty(formObj.exp_dt.value)) {
                    ComPriInputValueFailed("input","Duration",formObj.exp_dt);
                    return false;
                }
                if (formObj.eff_dt.value > formObj.exp_dt.value) {
                    ComShowCodeMessage('PRI00305', '[Duration]');
                    return false;
                }
                var note_ref_year=formObj.note_ref_yr.value;
                if (note_ref_year != formObj.eff_dt.value.substr(0,4) && note_ref_year != formObj.exp_dt.value.substr(0,4)) {
                    ComShowCodeMessage('PRI00323');
                    formObj.note_ref_yr.focus();
                    return false;
                }
                if (ComIsEmpty(comboObjects[2].GetSelectText())) {
                    ComPriInputValueFailed("input","Standard Note",comboObjects[2]);
                    return false;
                }
                return true;
                break; 
    		case IBDOWNEXCEL: 
    			if (formObj.svc_scp_cd.value == "" || gline_seq.value == "") {
    				return false;
    			}
    			break;
        }
        return true;
    }
    /**
     * activating when changing service scope combo <br>
     */ 
    function svc_scp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        if(comboObjects[0].GetItemCount() > 0 && comboObjects[0].GetSelectIndex()!= "-1") {
            if (validateForm(sheetObjects[0],document.form,IBCREATE)) {
                var formObj=document.form;                
                   if (newText != null && newText.length > 1) {	
                    formObj.svc_scp_nm.value=comboObj.GetText(newCode, 1);
                    searchConditionReset(formObj,"1");
                    if(eventStatus != "IBCOPY") 
                    	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
                    formObj.svc_scp_nm.focus();
                }
            } else {
                comboObjects[0].SetSelectIndex("-1");
            }
        }   
    }
    
   
    
    /**
     * initializing service scope combo<br>
     */
    function svc_scp_cd_OnClear(comboObj) {
        var formObject=document.form;
        formObject.svc_scp_nm.value="";
        comboObj.SetSelectIndex(-1,false);
    }
    /**
     * handling service scope combo focus out<br>
     */
    function svc_scp_cd_OnBlur(comboObj) {
        var formObj=document.form;
        if (!validateForm(sheetObjects[0],document.form,IBCREATE)) return;
//        var code=comboObj.FindItem(comboObj.GetSelectCode(), 0, 0);
        var code = comboObj.GetSelectCode();
        if (code != null && code != "") {
            var text=comboObj.GetText(code, 1);
            if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
                formObj.svc_scp_nm.value=comboObj.GetText(code, 1);
                searchConditionReset(formObj,"1");
                if(eventStatus != "IBCOPY") doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
                formObj.svc_scp_nm.focus();
            }
        }
    }
    /**
     * checking data in case of IBCombo<br>
     */
    function isDateIBCombo(comboObj) {
        if(ComIsEmpty(comboObj.GetSelectText())) return;
        if(!ComIsDate(comboObj.GetSelectText())) {
            ComPriDateFormatFailed("Effective Date");
            comboObj.SetSelectText("",false);
//            comboObj.focus();
            return false;
        }
        return true;
    }
    
    
    /**
     * activating when changing eff_dt combo<br>
     */ 
    
    function gline_seq_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
		
    	var formObj=document.form;
    	var selEffDt=comboObj.GetSelectText();
    	
		
    	if (selEffDt == null || selEffDt == "" || selEffDt == undefined) {
			return false;
		}

		if (ComIsDate(selEffDt)) {
			if(NewCod != "" ) { //select
				var effDt = comboObj.GetText(NewCod, 0);
//					effDt = effDt.replace(/-/gi, "");
//					effDt = effDt.substring(0, 4) + "-" + effDt.substring(4, 6) + "-" + effDt.substring(6, 8); 
				
				var expDt = comboObj.GetText(NewCod, 1);
//					expDt = expDt.replace(/-/gi, "");
//					expDt = expDt.substring(0, 4) + "-" + expDt.substring(4, 6) + "-" + expDt.substring(6, 8); 
				
				if(effDt != formObj.eff_dt.value) {
					formObj.eff_dt.value=effDt;
					formObj.exp_dt.value=expDt;
					setNoteNmCd();
				}
				
//				
			} else { //manual input
				
				var nIdx = comboObj.FindItem(selEffDt, 0, true);
				if( nIdx != -1) {
					comboObj.SetSelectIndex(nIdx, true);
				} else {
					selEffDt=selEffDt.replace(/-/gi, "");
					selEffDt=selEffDt.substring(0, 4) + "-" + selEffDt.substring(4, 6) + "-" + selEffDt.substring(6, 8); 
					document.form.eff_dt.value=selEffDt;
					document.form.gline_seq_text.value=selEffDt;
				}
				
//				
//				var nIdx = comboObj.FindItem(selEffDt, 0, true);
//				if( nIdx == -1) {
//					var itemCount = comboObj.GetItemCount();
//					comboObj.InsertItem(itemCount, document.form.eff_dt.value, "");
//					comboObj.SetSelectIndex(itemCount, false);
//				} else {
//					comboObj.SetSelectIndex(nIdx, false);
//				}
//				
			}
		} else {
			return false;
		}
		setComnoBySlineSeq(comboObj);
	}
    
    /**
     * activating eff_dt combo focus out<br>
     */ 
//    function gline_seq_OnBlur(comboObj) {
//        var formObj=document.form;
//        var glineSeq=formObj.note_hdr_seq.value;
//        var selEffDt=comboObj.GetSelectText();
//        if (selEffDt == null || selEffDt == "" || selEffDt == undefined) {
//            return false;
//        }
        
//        selEffDt=selEffDt.replace(/-/gi, "");
//        selEffDt=selEffDt.substring(0, 4) + "-" + selEffDt.substring(4, 6) + "-" + selEffDt.substring(6, 8); 
//        
//        var code=comboObj.FindItem(selEffDt, 0);
//        var expDt="";
//        if(code != "-1" && !ComIsEmpty(glineSeq)) {
//            expDt=comboObj.GetText(code, 1); 
//        }
//        //select
//        if(!ComIsEmpty(selectedGlineSeq)) {
//            comboObj.SetText(selectedGlineSeq, 0, selEffDt);
//            formObj.eff_dt.value=selEffDt;
//        }
//        if(ComIsEmpty(expDt)) { 
//            if(!isDateIBCombo(comboObj)) return;
//            var code=comboObj.FindItem("", 1);
//            
//            var txt="";
//            if(code != "-1") {
//            	comboObj.DeleteItem(code);
//            }else{
//            	//txt=setDash(comboObj.GetText(code,0));
//            }
//            //combo item insert
//            comboObj.InsertItem(-1,selEffDt + "|", selEffDt);
//            comboObj.SetSelectCode(selEffDt);
//            formObj.eff_dt.value=selEffDt;
//            comboObj.SetText(selEffDt,0,selEffDt);
//        } 
//        //auto search or select
//        else {
////          if(selectedGlineSeq != "") {
//            if(!isDateIBCombo(comboObj)) {
////                comboObj.focus();
//                return;
//            }
//            formObj.eff_dt.value=selEffDt;
////          }   
//        }
//        
//        setComnoBySlineSeq(comboObj);
//    }
    /**
     * retrieving NOTE NAME COMBO list<br>
     */
    function setNoteNmCd() {
        var formObj=document.form;
        if(eventStatus == "IBCOPY") return;
        formObj.note_hdr_seq.value="";
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC05);
        sheetObjects[1].RemoveAll();
        sheetObjects[2].RemoveAll();
        note_nm_cd.SetSelectIndex(-1,false);
        prc_cust_tp_cd.SetSelectIndex(-1,false);
//      formObj.exp_dt_hidden_select.value = "";
        formObj.cfm_flg.focus();
        return;
//      }
    }
    /**
     * activating when changing note_nm_cd combo <br>
     */ 
    function note_nm_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var formObj=document.form;
        
        if(newCode != "") { //select
	        if(eventStatus != "IBCOPY") {
	            if(comboObjects[2].GetItemCount() > 0 && comboObjects[2].GetSelectIndex()!= "-1") {
	                if (validateForm(sheetObjects[0],document.form,IBSEARCH)) {
	//                  formObj.eff_dt.value = setDash(formObj.eff_dt.value);
	//                  formObj.exp_dt.value = setDash(formObj.exp_dt.value);
	                    formObj.note_hdr_seq.value=newCode;
	                    formObj.note_nm.value=getNoteNmTxt(newCode);
	                    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	                    if(eventStatus != "IBSAVE")
	                        doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
	                } 
	            }   
	        }   
        }else{
        	var comboText=comboObj.GetSelectText();
            if (comboText == null || comboText == "" || comboText == undefined) {
    			return false;
    		}
        	
        	var nIdx = comboObj.FindItem(comboText, 0, true);
        	if( nIdx == -1) {
				comboObj.InsertItem(comboObj.GetItemCount(), comboText, "");
				comboObj.SetSelectIndex(comboObj.GetItemCount() - 1, false);
				
				/*resetObjectValue("2");
				sheetObj.SetCellValue(sheetObj.HeaderRows(), "trf_inlnd_nm", text, 0);
				sheetObj.SetCellValue(sheetObj.HeaderRows(), "trf_inlnd_sts_cd","I",0);*/
				
			} else {
				comboObj.SetSelectIndex(nIdx, false);
			}
        }
    }
    /**
     * resetting data after exp_dt <br>
     */
    function removeAll4(formObj) {
        comboObjects[3].SetSelectIndex(-1);
        comboObjects[2].SetSelectIndex(-1);
        comboObjects[2].RemoveAll();
//      formObj.reset();
        sheetObjects[1].RemoveAll();
        sheetObjects[2].RemoveAll();
        eventStatus="";
        toggleButtons("INIT");
    }
    /**
     * initializing screen except year <br>
     */
    function removeAll3(formObj) {
        var note_ref_yr=formObj.note_ref_yr.value;
        comboObjects[3].SetSelectIndex(-1);
        comboObjects[2].SetSelectIndex(-1);
        comboObjects[2].RemoveAll();
        comboObjects[1].SetSelectIndex(-1);
        comboObjects[1].RemoveAll();
        comboObjects[0].SetSelectIndex(-1);
        formObj.reset();$(formObj).find("input[type=hidden]").val("");
        sheetObjects[1].RemoveAll();
        sheetObjects[2].RemoveAll();
        eventStatus="";
        toggleButtons("INIT");
        formObj.note_ref_yr.value=note_ref_yr;
    }
    /**
     * initializing all screen(initializing after all Delete)<br>
     */
    function removeAll2(formObj) {
        var note_ref_yr=formObj.note_ref_yr.value;
        var svc_scp_nm=formObj.svc_scp_nm.value;
        comboObjects[3].SetSelectIndex("-1");
        comboObjects[2].SetSelectIndex("-1");
        comboObjects[2].RemoveAll();
        comboObjects[1].SetSelectIndex("-1");
        comboObjects[1].RemoveAll();
        formObj.reset();$(formObj).find("input[type=hidden]").val("");
        sheetObjects[1].RemoveAll();
        sheetObjects[2].RemoveAll();
        eventStatus="";
        toggleButtons("INIT");
        formObj.note_ref_yr.value=note_ref_yr;
        formObj.svc_scp_nm.value=svc_scp_nm;
        doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
        if(gline_seq.GetItemCount() <= 0) {
            comboObjects[0].SetSelectIndex("-1");
            formObj.reset();$(formObj).find("input[type=hidden]").val("");
        }
        formObj.note_ref_yr.focus();
    }
    /**
     * initializing all screen <br>
     * saving after changing data
     */
    function removeAll(formObj) {
        if (checkModified(formObj)) {
            if (ComShowCodeConfirm("PRI00006")) {
                supressConfirm=true;
                doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
                supressConfirm=false;
            } else {
                comboObjects[3].SetSelectIndex("-1");
                comboObjects[2].SetSelectIndex("-1");
                comboObjects[2].RemoveAll();
                comboObjects[1].SetSelectIndex("-1");
                comboObjects[1].RemoveAll();
                comboObjects[0].SetSelectIndex("-1");
                formObj.reset();
                $(formObj).find("input[type=hidden]").val("");
                sheetObjects[1].RemoveAll();
                sheetObjects[2].RemoveAll();
            }
        } else {    
            comboObjects[3].SetSelectIndex("-1");
            comboObjects[2].SetSelectIndex("-1");
            comboObjects[2].RemoveAll();
            comboObjects[1].SetSelectIndex("-1");
            comboObjects[1].RemoveAll();
            comboObjects[0].SetSelectIndex("-1");
            formObj.reset();$(formObj).find("input[type=hidden]").val("");
            sheetObjects[1].RemoveAll();
            sheetObjects[2].RemoveAll();
        }
        formObj.note_ref_yr.focus();
        eventStatus="";
        toggleButtons("INIT");
    }
    /**
     * resetting retrieve condition <br>
     * saving in case of changing data
     */
    function searchConditionReset(formObj,gubun) {
        if(eventStatus == "IBCOPY") return;
        //sc change
        if(gubun == "1") {
            comboObjects[1].SetSelectIndex("-1");
            comboObjects[1].RemoveAll();
            //alert(0)
            formObj.eff_dt.value="";
            formObj.exp_dt.value="";
            comboObjects[2].SetSelectIndex("-1");
            comboObjects[2].RemoveAll();
            comboObjects[3].SetSelectIndex("-1");
            formObj.cfm_flg.value="";
            formObj.note_nm.value="";
            sheetObjects[1].RemoveAll();
            sheetObjects[2].RemoveAll();
        } 
        //eff_dt change
        else if(gubun == "2") { 
            //formObj.exp_dt.value = "";
            comboObjects[2].SetSelectIndex("-1");
            comboObjects[2].RemoveAll();
            comboObjects[3].SetSelectIndex("-1");
            formObj.cfm_flg.value="";
            formObj.note_nm.value="";
            sheetObjects[1].RemoveAll();
            sheetObjects[2].RemoveAll();
        }
        toggleButtons("INIT");
    }
    /**
     * when copying, resetting retrieve condition after copying origin retrieve condition <br>
     */
    function removeCopy(formObj) {
        if (eventStatus == "IBCOPY") {
            return false;
        }
        //alert(1111)
        var svc_scp_cd_beforeCopy=comboObjects[0].GetSelectCode();
        var prc_cust_tp_cd_beforeCopy=comboObjects[2].GetSelectCode();
        var note_hdr_seq_beforeCopy=formObj.note_hdr_seq.value;
        comboObjects[0].SetSelectIndex("-1");
//      comboObjects[0].RemoveAll();
        comboObjects[1].SetSelectIndex("-1");
        comboObjects[1].RemoveAll();
        comboObjects[2].SetSelectIndex("-1");
        comboObjects[2].RemoveAll();
        comboObjects[3].SetSelectIndex("-1");
//      sheetObjects[1].RemoveAll();
//      sheetObjects[2].RemoveAll();
        formObj.reset();$(formObj).find("input[type=hidden]").val("");
        formObj.svc_scp_cd_copy.value=svc_scp_cd_beforeCopy;
        formObj.prc_cust_tp_cd_copy.value=prc_cust_tp_cd_beforeCopy;
        formObj.note_hdr_seq_copy.value=note_hdr_seq_beforeCopy;
        formObj.note_hdr_seq.value=note_hdr_seq_beforeCopy;
        formObj.note_ref_yr.focus();
    }
    /**
     * returning comboObjects[0]'s code <br>
     */
    function getSvcScpCd() {
        return comboObjects[0].GetSelectCode();
    }
    /**
     * returning comboObjects[1]'s code<br>
     */
    function getGlineSeq() {
        return comboObjects[1].GetSelectCode();
    }
    /**
     * returning comboObjects[1]'s Text <br>
     */
    function getGlineSeqTxt() {
        return comboObjects[1].GetSelectText();
    }
    /**
     * returning comboObjects[2]'s code <br>
     */
    function getNoteNmCd() {
        return comboObjects[2].GetSelectCode();
    }
    /**
     * returning comboObjects[2]'s Text<br>
     */
    function getNoteNmTxt() {
        //return comboObjects[2].GetText(code,0);
         return comboObjects[2].GetSelectText();
    }
    /**
     * returning comboObjects[3]'s Text<br>
     */
    function getCustTypeCd() {
        return comboObjects[3].GetSelectCode();
    }
    /**
     * returning eff_dt's value <br>
     */
    function getEffDt() {
        return document.form.eff_dt.value;
    }
    /**
     * returning exp_dt's value <br>
     */
    function getExpDt() {
        return document.form.exp_dt.value;
    }
    /**
     * returning true in case of existence of changing <br>
     */
    function checkModified(formObj) {
        isModified=false;
        if (formObj.note_ref_yr.value != formObj.note_ref_yr_hidden.value
            || formObj.eff_dt.value != formObj.eff_dt_hidden.value
            || formObj.exp_dt.value != formObj.exp_dt_hidden.value
            || getNoteNmTxt() != formObj.note_nm_hidden.value
            || getSvcScpCd() != formObj.svc_scp_cd_hidden.value
            || getCustTypeCd() != formObj.prc_cust_tp_cd_hidden.value
            || sheetObjects[1].IsDataModified()
            || sheetObjects[2].IsDataModified()) {
            isModified=true;
        }
        return isModified;
    }
    /**
     * setting YYYY-MM-DD date type <br>
     */
    function setDashIBCombo(obj) {
        if(obj.GetSelectText()== "" || obj.GetSelectText().length == 0) return;
        var date=obj.GetSelectText().replace(/-/g, "");
        if(!ComIsNumber(date,'0123456789')) {
            ComShowCodeMessage('PRI00311');
            obj.SetSelectText("",false);
            //obj.focus();
            return;
        }
        var str="";
        for(var i=0; i<date.length; i++) {
            if(i == 4 || i == 6) {
                str += "-" + date.substring(i,i+1);
            }
            else {
                str += date.substring(i,i+1);
            }
        }
        obj.SetSelectText(str,false);
    }
    /**
     * setting YYYY-MM-DD date type <br>
     */
    function setDash(value) {
        if(value == "" || value.length == 0) return;
        var date=ComTrimAll(value).replace(/-/g, "");
        var str="";
        for(var i=0; i<date.length; i++) {
            if(i == 4 || i == 6) {
                str += "-" + date.substring(i,i+1);
            }
            else {
                str += date.substring(i,i+1);
            }
        }
        return str;
    }
    /**
     * deleting "-" date type <br>
     */
    function removeDash(date) {
        if(date == "" || date.length == 0) return;
        date=date.replace(/-/g, "");
        return date;
    }
    /**
     * setting button activation by case<br>
     */
    function toggleButtons(mode) {
        switch (mode) {
            case "INIT":
                ComBtnEnable("btn_retrieve");
                ComBtnEnable("btn_new");
                ComBtnEnable("btn_save");
                ComBtnDisable("btn_confirm");
                ComBtnDisable("btn_cancel");
                ComBtnDisable("btn_delete3");
                ComBtnDisable("btn_copy");
                ComBtnEnable("btn_add");
                ComBtnEnable("btn_add2");
                ComBtnEnable("btn_delete");
                ComBtnEnable("btn_delete2");
                ComBtnDisable("btn_downexcel");
                sheetControl(true);
                break;
            case "CONF_YES":
                ComBtnEnable("btn_retrieve");
                ComBtnEnable("btn_new");
                ComBtnDisable("btn_save");
                ComBtnDisable("btn_confirm");
                ComBtnEnable("btn_cancel");
                ComBtnDisable("btn_delete3");
                ComBtnEnable("btn_copy");
                ComBtnDisable("btn_add");
                ComBtnDisable("btn_add2");
                ComBtnDisable("btn_delete");
                ComBtnDisable("btn_delete2");
                ComBtnEnable("btn_downexcel");
                sheetControl(false);
                break;
            case "CONF_NO":
                ComBtnEnable("btn_retrieve");
                ComBtnEnable("btn_new");
                ComBtnEnable("btn_save");
                ComBtnEnable("btn_confirm");
                ComBtnDisable("btn_cancel");
                ComBtnEnable("btn_delete3");
                ComBtnEnable("btn_copy");
                ComBtnEnable("btn_add");
                ComBtnEnable("btn_add2");
                ComBtnEnable("btn_delete");
                ComBtnEnable("btn_delete2");
                ComBtnEnable("btn_downexcel");
                sheetControl(true);
                break;
            case "IBCOPY":
                ComBtnEnable("btn_retrieve");
                ComBtnEnable("btn_new");
                ComBtnEnable("btn_save");
                ComBtnDisable("btn_confirm");
                ComBtnDisable("btn_cancel");
                ComBtnDisable("btn_delete3");
                ComBtnDisable("btn_copy");
                ComBtnDisable("btn_add");
                ComBtnDisable("btn_add2");
                ComBtnDisable("btn_delete");
                ComBtnDisable("btn_delete2");
                ComBtnDisable("btn_downexcel");                
                sheetControl(false);
                break;
            case "CONV":
                ComBtnEnable("btn_save");
                ComBtnEnable("btn_downexcel");                
                break;
        }
    }
    /**
     * setting  IBSheet's Cell activation by confrim<br>
     */
    function sheetControl(flag) {
        var sheetObj1=sheetObjects[1];
        var sheetObj2=sheetObjects[2];
        for (var i=1; i <= sheetObj1.RowCount();i++) {
            sheetObj1.SetCellEditable(i, "chk",flag);
//          sheetObj1.CellEditable(i, "note_tit_nm") = flag;
        }
        for (var i=1; i <= sheetObj2.RowCount();i++) {
            sheetObj2.SetCellEditable(i, "chk",flag);
        }
    }
    /**
     * setting  button activation by confrim<br>
     */
    function setConfirmButton()  {
        var cfm_flg=document.form.cfm_flg.value;
        if(cfm_flg == "Yes") toggleButtons("CONF_YES");
        else if(cfm_flg == "No") toggleButtons("CONF_NO");
    }
    /**
     * setting dp_seq when saving <br>
     */
    function setDpSeq(sheetObj)  {
        if(!sheetObj.IsDataModified()) return;
//        for(var i=1; i<=sheetObj.RowCount(); i++) {
//            sheetObj.CellValue2(i, "dp_seq") = i;
//
//            if(sheetObj.RowStatus(i) == "R") {
//                sheetObj.RowStatus(i) = "U";
//            }
//        }
        var idx=0;
        for (var i=sheetObj.HeaderRows(), n=sheetObj.HeaderRows()+sheetObj.RowCount(); i < n ; i++) {
            sheetObj.SetCellValue(i, "dp_seq",++idx);
        }
    }
    /**
     * calling when yesr OnKeyPress<br>
     */
    function searchDuration() {
        if(ComIsEmpty(document.form.note_ref_yr)) return;
        if(!ComIsNumber(document.form.note_ref_yr,'0123456789')) {
            ComShowCodeMessage('PRI00311');
            document.form.note_ref_yr.value="";
            return;
        }
        if(eventStatus == "IBCOPY") return;
        var formObj=document.form;
        var length=document.form.note_ref_yr.value.length;
        if(length == 4) {
            if(getSvcScpCd() != "" && getGlineSeq() == "") {
                removeAll3(document.form);
//              comboObjects[0].focus();
                return;
            }
        }
        if(length == 4) {
            var note_ref_year=formObj.note_ref_yr.value;
            if(!ComIsEmpty(formObj.note_hdr_seq.value)) {
                if (note_ref_year != formObj.eff_dt.value.substr(0,4) && note_ref_year != formObj.exp_dt.value.substr(0,4)) {
                    ComShowCodeMessage('PRI00323');
                    formObj.note_ref_yr.value=formObj.note_ref_yr_hidden.value;
                    formObj.note_ref_yr.focus();
                    return false;
                }
            }
        }
    }
    /**
     * showing memo pad when adding address <br>
     */
    function showMemoPad(sheetObj, Row, Col) {
        if(isFiredNested) return;
        var cfm_flg=document.form.cfm_flg.value;
        //showing memopad when clicking desc cell (MemoPad editable)
        var colname=sheetObj.ColSaveName(Col);
        switch(colname)
        {
            case "note_tit_nm":
                if(cfm_flg == "Yes")
                    ComShowMemoPad(sheetObj,Row,Col,true,892,200);
                else
                    ComShowMemoPad(sheetObj,Row,Col,false,892,200);
                break;
        }
    }
    /**
     * calling function when occurring OnClick Event <br>
     * showing memo pad when adding address <br>
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value) {
        if(isFiredNested) return;
        var cfm_flg=document.form.cfm_flg.value;
        //showing memopad when clicking desc cell (MemoPad editable)
        var colname=sheetObj.ColSaveName(Col);
        switch(colname)
        {
            case "note_tit_nm":
                if(cfm_flg == "Yes")
                    ComShowMemoPad(sheetObj,Row,Col,true,892,200);
                else
                    ComShowMemoPad(sheetObj,Row,Col,false,892,200);
                break;
        }
    }
    /**
     * calling function when occurring OnClick Event <br>
     * showing memo pad when adding address <br>
     */
    function sheet2_OnClick(sheetObj, Row, Col, Value) {
        var cfm_flg=document.form.cfm_flg.value;
        //showing memopad when clicking desc cell (MemoPad editable)
        var colname=sheetObj.ColSaveName(Col);
        switch(colname)
        {
            case "note_ctnt":
                if(cfm_flg == "Yes")
                    ComShowMemoPad(sheetObj,Row,Col,true,700,200);
                else
                    ComShowMemoPad(sheetObj,Row,Col,false,700,200);
                break;
        }
    }
    /**
     * calling function when occurring OnPopupClick Event <br>
     * calling Standard Note Conversion PopUp<br>
     */
    function sheet2_OnPopupClick(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        var effDt=formObj.eff_dt.value;
        var expDt=formObj.exp_dt.value;
        if (colName == "conversion_pop") {
        	if(!ComIsNull(sheetObj.GetCellValue(Row, "note_conv_mapg_id")))    {
                var sParam="";
                sParam += "svc_scp_cd=" + getSvcScpCd();
                sParam += "&note_conv_mapg_id=" + sheetObj.GetCellValue(Row, "note_conv_mapg_id");
                sParam += "&prc_ctrt_tp_cd=" + getCustTypeCd();
                sParam += "&note_hdr_seq=" + sheetObj.GetCellValue(Row, "note_hdr_seq");
                sParam += "&note_ctnt=" + encodeURIComponent(sheetObj.GetCellValue( Row, "note_ctnt"));
                sParam += "&eff_dt=" + effDt;
                sParam += "&exp_dt=" + expDt;
                var sUrl="ESM_PRI_0008.do?"+sParam;
                ComOpenPopup(sUrl, 825, 530, "setNoteConv", "1,0", true);
            } else {
                ComShowCodeMessage("PRI08015");
            }
        }
    }
    function setNoteConv(rtnVal) {
    	var sheetObj=sheetObjects[2];
    	var prevStatus=sheetObj.GetRowStatus(sheetObj.GetSelectRow());
    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "note_conv_flg", rtnVal, 0);
    	sheetObj.SetRowStatus(sheetObj.GetSelectRow(),prevStatus);
    	eventStatus2="CONV";
        toggleButtons("CONV");
    }
    /**
     * calling when finishing retrieve sheet<br>
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        sheetObj.SelectCell(selectedMrow, 1, false);
    }
    /**
     * calling when finishing retrieve sheet<br>
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
        sheetObj.SelectCell(selectedDrow, 1, false);
    }
