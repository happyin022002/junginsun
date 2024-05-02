/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1041.js
*@FileTitle  : LT ST OW Plan and Approval
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/09
=========================================================*/
    var sheetObjects=new Array();
    var sheetCnt=0;
    var HeadTitleCnt=0;
    var yyyyMm="";
    var comboObjects=new Array();
    var comboCnt=0 ;
    var rowInsertSeq=0; // Row Merge 
    var rccCdList=""; 
	var lccCdList=""; 
	var searchFlag=false; // sheet flag 
	var save_flag=false;  // save flag
    // -- Cntr Tpsz -- //     
    var tpszallText="D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|S2|S4|F2|F4|F5|A2|A4"; 
    var tpszallCode="D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|S2|S4|F2|F4|F5|A2|A4"; 
    var tpszdryText="D2|D4|D5|D7";    // DRY TYPE SIZE
    var tpszdryCode="D2|D4|D5|D7";
    var tpszrfrText="R2|R5|R9";       // RFR TYPE SIZE
    var tpszrfrCode="R2|R5|R9";
    var tpszotText="O2|O4|O5|S2|S4"; // OT  TYPE SIZE 
    var tpszotCode="O2|O4|O5|S2|S4";
    var tpszfrText="F2|F4|F5|A2|A4"; // FR  TYPE SIZE 
    var tpszfrCode="F2|F4|F5|A2|A4";    
    var consTpsz="D2,D4,D5,D7,R2,R5,R9,O2,O4,O5,S2,S4,F2,F4,F5,A2,A4";
    var consTpszArr=consTpsz.split(',');
    var consTpszDry="D2,D4,D5,D7";
    var consTpszRfr="R2,R5,R9";
    var consTpszOt="O2,O4,O5,S2,S4";
    var consTpszFr="F2,F4,F5,A2,A4";
    document.onclick=processButtonClick;
    function processButtonClick(){
        var shtCnt=0;
        var sheet1=sheetObjects[shtCnt];
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
                break;
			case "btn_new":
                sheetObjects[0].RemoveAll();
				doActionIBSheet(sheetObjects[0],formObject,SEARCH02);
                break;	
            case "btn_save":
                doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
                break;
			case "btn_request":
                doActionIBSheet(sheetObjects[0], formObject, MULTI02);
                break;	
			case "btn_cancel":
                doActionIBSheet(sheetObjects[0], formObject, MULTI03);
                break;	
            case "btn_downExcel":
            	if(sheetObjects[0].RowCount()>0){
            		sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
    			}else{
    				ComShowCodeMessage("EQR01104");
    			}
                break;
			case "btn_rowadd":
			    var newRow=sheetObjects[0].DataInsert(-1);
				if (document.form.div_flag[0].checked == true) { // WK
				    sheetObjects[0].SetCellValue(newRow,"onh_pln_yrwk",document.form.yrwk.value,0);
				}
				if(lcc_cd.GetSelectCode()!= "" && lcc_cd.GetSelectCode()!= "ALL"){ // LCC
				    sheetObjects[0].SetCellValue(newRow,"rcc_cd",rdd_cd.GetSelectCode(),0);
					sheetObjects[0].SetCellValue(newRow,"lcc_cd",lcc_cd.GetSelectCode(),0);
				}
				if(formObject.pop_mode.value == "Y"){
					sheetObjects[0].SetCellEditable(newRow,"onh_pln_yrwk",0);
					if(sheetObjects[0].GetCellValue(newRow,"lcc_cd")!=""){
					    sheetObjects[0].SetCellEditable(newRow,"lcc_cd",0);
					}
				}
				break;
			case "btn_rowdel":
			    var delStr=sheetObjects[0].FindCheckedRow("delchk");
				if(delStr != ""){
					var delArr=delStr.split("|");
					for(var i=0; i<delArr.length; i++){ // STS_CD 
						if(delArr[i]!="" && !(sheetObjects[0].GetCellValue(delArr[i],"sts_cd")=="S"
							|| sheetObjects[0].GetCellValue(delArr[i],"sts_cd")=="")){
							ComShowCodeMessage("EQR01024"); // 'Only New row and Saved row can be Deleted.'
							sheetObjects[0].SelectCell(delArr[i],"lse_rqst_no");
							return false;
						}
					}
					for(var i=delArr.length-1; i>=0; i--){ // RowDelete
						if(delArr[i]!=""){
							if(sheetObjects[0].GetCellValue(delArr[i],"ibflag")=="I"){
	                            sheetObjects[0].RowDelete(delArr[i], false);
	                        }else{                                // ibflag=D
	                            sheetObjects[0].SetCellValue(delArr[i],"ibflag","D");
	                            sheetObjects[0].SetRowHidden(delArr[i],1);
	                        }
						}
                    }
				}
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
     * Initial event
     */
    function initControl() {
         axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);                 //OnBeforeActivate
         axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);               //OnBeforeDeactivate
         axon_event.addListener('keydown', 'ComKeyEnter', 'form');                             //
         axon_event.addListenerFormat('keypress', 'obj_keypress'  , form);                     //
         axon_event.addListenerForm('change','form_change',form);
    }    
    /**
     * IBSheet Object
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * IBCombo Object <br>
     * @param {object}  combo_obj - Combo Object
     * @version 
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * body onLoad 
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        for(p=0;p< comboObjects.length;p++){
            initCombo (comboObjects[p],p+1);
        }
		var level_cd=document.form.level_cd.value;
        doActionIBSheet(sheetObjects[0],document.form,SEARCH02); // RCC 
		if(document.form.pop_mode.value == "Y"){ 
			// popup mode 
		    ComBtnDisable("btn_new");      // NEW button 
		    document.form.div_flag[2].checked=true;
			document.form.div_flag[0].disabled=true;
            document.form.div_flag[1].disabled=true; 
            document.form.div_flag[2].disabled=true; 
            document.form.div_flag[3].disabled=true;    
			document.form.yrwk.className="input2";
            document.form.fmperiod.className="input2";
            document.form.toperiod.className="input2";
			document.form.yrwk_pkup.className="input2";
            document.form.fmperiod_pkup.className="input2";
            document.form.toperiod_pkup.className="input2";            
			document.form.yrwk.readOnly=true;
            document.form.fmperiod.readOnly=true;
            document.form.toperiod.readOnly=true;
			document.form.yrwk_pkup.readOnly=true;
            document.form.fmperiod_pkup.readOnly=true;
            document.form.toperiod_pkup.readOnly=true;            
			document.form.periodtp.className="input2";
			document.form.periodtp.disabled=true;			
			document.form.periodtp_pkup.className="input2";
			document.form.periodtp_pkup.disabled=true;
			document.form.sts_cd.className="input2";			
			document.form.sts_cd.disabled=true;
			comboObjects[0].enable=false;
			comboObjects[1].enable=false;
			if (document.form.pop_lcc.value != "") {
				var sXml=sheetObjects[0].GetSearchData("EES_EQR_1041GS.do", "f_cmd=" + SEARCH02 + "&loc_grp_cd=R" + "&loc_cd=" + document.form.pop_lcc.value);
				if (ComGetTotalRows(sXml) > 0) {
					var tmpRccCd=ComXml2ComboString(sXml, "code", "name")[0].split('|')[0];
					comboObjects[0].SetSelectText(tmpRccCd);
					comboObjects[1].SetSelectText(document.form.pop_lcc.value);
				}
				else {
					comboObjects[0].SetSelectText("ALL");
					comboObjects[1].SetSelectText("ALL");
				}
			}else if (document.form.pop_rcc.value != "") {
				comboObjects[1].SetSelectText(document.form.pop_rcc.value);
			}else{
			    comboObjects[0].SetSelectText("ALL");
                comboObjects[1].SetSelectText("ALL");
			}
			document.form.cntrTpsz.selectedIndex=1; // Dry 
			tpsztype.SetSelectText(document.form.pop_tpsz.value);
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
		}else{
            document.form.cntrTpsz.selectedIndex=1; // Dry 
            tpszChange('D'); // Dry 
        }
    }
    /**
     * param : sheetObj 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var shtID=sheetObj.id;
        switch(shtID) {
            case "sheet1":      //sheet1 init
                with(sheetObj){
		             var HeadTitle1="ibflag|Del.|Request No.|Order\nYear|Approval\nWK|Pick-up\nWK|RCC|LCC|Term|lse_pln_seq|TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|O5|S4|F2|A2|F4|A4|F5|Auth No.|M/Year|AGMT No.|Lessor|sts_cd|Status|request_flag";
		             HeadTitleCnt=ComCountHeadTitle(HeadTitle1);
		             (HeadTitleCnt, 0, 0, true);
		             sheetObj.FrozenCols=3;
		
		             SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		             var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                 {Type:"DummyCheck", Hidden:0, Width:28,   Align:"Center",  ColMerge:1,   SaveName:"delchk" },
		                 {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"lse_rqst_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"onh_ord_yr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4, AcceptKeys:"N" },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"onh_pln_yrwk",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6, AcceptKeys:"N" },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"onh_pkup_yrwk",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6, AcceptKeys:"N" },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rcc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"lcc_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
		                 {Type:"Combo",     Hidden:0, Width:48,   Align:"Center",  ColMerge:1,   SaveName:"eq_lstm_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, ComboText:"|LT|ST|OW", ComboCode:"|LT|ST|OW" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"lse_pln_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Int",       Hidden:0,  Width:46,   Align:"Right",   ColMerge:0,   SaveName:"ttl",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"d2_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"d4_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"d5_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"d7_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"r2_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"r5_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"r9_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"o2_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"s2_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"o4_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"o5_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"s4_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"f2_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"a2_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"f4_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"a4_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"f5_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cntr_onh_auth_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"mft_yr",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"onh_loc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"sts_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sts_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"request_flag",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		              
		             InitColumns(cols);
		             SetWaitImageVisible(0);
		             SetCountPosition(0);
		             SetAutoRowHeight(0);
		             //no support[check again]CLT SetSortDialog(false);     // Ctrl+S
		             //SetSelectDialog(false);   // Ctrl+H
		             //no support[check again]CLT SetExcelColDialog(false); // Ctrl+P
		             InitComboNoMatchText(true); // Combo
		             //no support[check again]CLT 				   MultiSelection=false;
		             SetSelectionMode(smSelectionRow);
		             SetSheetHeight(438);
             	}
            break;
        }
    }
      // Sheet
    function doActionIBSheet(sheetObj,formObj,sAction,initFlag) {
        switch(sAction) {
           case IBSAVE:        //Save
	            if (validateForm(sheetObj, formObj, sAction)) {
					var SaveStr=sheetObj.GetSaveString(false,true,"ibflag");
					if (SaveStr == "") {
						return;
					}
					ComOpenWait(true);
                    var insRowStr=sheetObj.FindStatusRow("I");
					var insRowArr=insRowStr.split(";");
					sParam="f_cmd=" + MULTI + "&" + SaveStr;
                    var sXml=sheetObj.GetSaveData("EES_EQR_1041GS.do", sParam);
					var newLsePlnSeqStr=ComGetEtcData(sXml, "new_lse_pln_seq_str");
					if(ComGetEtcData(sXml,"TRANS_RESULT_KEY")=="S"){ 
						if(newLsePlnSeqStr!=""){ // insert row 
							var newLsePlnSeqArr=newLsePlnSeqStr.split(",");
							for(var i=0; i<insRowArr.length; i++){
								if(insRowArr[i]!=""){
									sheetObj.SetCellValue(insRowArr[i],"lse_pln_seq",newLsePlnSeqArr[i],0);
									sheetObj.SetCellValue(insRowArr[i],"sts_cd","S",0);
									sheetObj.SetCellValue(insRowArr[i],"sts_nm","Saved",0);
									sheetObj.SetCellValue(insRowArr[i],"ibflag","R",0);
								}
							}
						}
						save_flag=true;
						ComShowCodeMessage("EQR01020","Saved"); // '{?msg1} Successfully.'
					}else{
						save_flag=false;
					}
					sheetObj.LoadSaveData(sXml);
					ComOpenWait(false);
				}
                break;
		   case MULTI02:        // Request
                if (validateForm(sheetObj, formObj, sAction) && ComShowCodeConfirm("EQR01028")) {
                    ComOpenWait(true);
					var selRow=sheetObj.GetSelectRow();
					sheetObj.SetCellValue(selRow, "sts_cd","R",0);// Request
					sheetObj.SetCellValue(selRow, "request_flag","Y",0);
					var sParam="f_cmd="+MULTI02;
                    sParam=sParam+"&"+sheetObj.GetSaveString(false,true,"request_flag");
                    var sXml=sheetObj.GetSaveData("EES_EQR_1041GS.do", sParam);
					var newLseRqstNoStr=ComGetEtcData(sXml, "new_lse_rqst_no_str");
					if(ComGetEtcData(sXml,"TRANS_RESULT_KEY")=="S" 
					    && newLseRqstNoStr!="" ){ 
						var newLseRqstNoArr=newLseRqstNoStr.split(",");
						sheetObj.SetCellValue(selRow,"lse_rqst_no",newLseRqstNoArr[0],0);
                        sheetObj.SetCellValue(selRow,"sts_cd","R",0);
                        sheetObj.SetCellValue(selRow,"sts_nm","Requested",0);
						sheetObj.SetCellValue(selRow, "request_flag","",0);
                        sheetObj.SetCellValue(selRow,"ibflag","R",0);
						sheetObj.SetRowEditable(selRow,0);
						ComShowCodeMessage("EQR01020","Requested"); // '{?msg1} Successfully.'
					}else{
						sheetObj.SetCellValue(selRow, "sts_cd","S",0);
                        sheetObj.SetCellValue(selRow, "request_flag","",0);
					}
                    ComOpenWait(false);
                }
                break;
		   case MULTI03:        // Request Cancel 
                if (validateForm(sheetObj, formObj, sAction) && ComShowCodeConfirm("EQR01028")) {
                    ComOpenWait(true);
                    var selRow=sheetObj.GetSelectRow();
                    sheetObj.SetCellValue(selRow, "sts_cd","S",0);// Request Cancel --> S
                    sheetObj.SetCellValue(selRow, "request_flag","Y",0);
                    var sParam="f_cmd="+MULTI02;
                    sParam=sParam+"&"+sheetObj.GetSaveString(false,true,"request_flag");
                    var sXml=sheetObj.GetSaveData("EES_EQR_1041GS.do", sParam);
                    var newLseRqstNoStr=ComGetEtcData(sXml, "new_lse_rqst_no_str");
					if(ComGetEtcData(sXml,"TRANS_RESULT_KEY")=="S"){ 
                        sheetObj.SetCellValue(selRow,"lse_rqst_no","",0);
                        sheetObj.SetCellValue(selRow,"sts_cd","S",0);
                        sheetObj.SetCellValue(selRow,"sts_nm","Saved",0);
						sheetObj.SetCellValue(selRow, "request_flag","",0);
                        sheetObj.SetCellValue(selRow,"ibflag","R",0);
						sheetObj.SetRowEditable(selRow,1);
						ComShowCodeMessage("EQR01020","Request Canceled"); // '{?msg1} Successfully.'
                    }else{
						sheetObj.SetCellValue(selRow, "sts_cd","R",0);
                        sheetObj.SetCellValue(selRow, "request_flag","",0);
					}
                    ComOpenWait(false);
                }
                break;
           case IBSEARCH:        
                if (validateForm(sheetObj, formObj, sAction)) {
                	ComOpenWait(true); 
					formObj.f_cmd.value=SEARCH;
					var sXml=sheetObj.GetSearchData("EES_EQR_1041GS.do", FormQueryString(formObj));
					sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
				}
                break;
			 case SEARCH02: // RCC_CD 
			     formObj.f_cmd.value=SEARCH02;
				 var sXml=sheetObj.GetSearchData("EES_EQR_1041GS.do" , FormQueryString(formObj)+"&loc_grp_cd=R");
				 ComXml2ComboItem(sXml, rcc_cd, "code", "name");
				 rccCdList=ComXml2ComboString(sXml,"code","name")[0];
				 rcc_cd.InsertItem(0,"ALL","ALL");
				 rcc_cd.SetSelectText('ALL');
				 formObj.sts_cd.value="";
				 formObj.periodtp.value="W";
				 formObj.periodtp_pkup.value="W";
				 formObj.yrwk.value=formObj.tempWeek.value;
				 formObj.yrwk_pkup.value=formObj.tempWeek.value;
				 formObj.div_flag.value="1";
				 radioToggle();
				 break;
			case SEARCH03: // LCC_CD 
                 formObj.f_cmd.value=SEARCH02; 
                 var sXml=sheetObj.GetSearchData("EES_EQR_1041GS.do" , FormQueryString(formObj)+"&loc_grp_cd=L"+"&loc_cd="+rcc_cd.GetSelectCode());
                 ComXml2ComboItem(sXml, lcc_cd, "code", "name");
				 if(ComGetTotalRows(sXml)*1>0){
				    lccCdList=ComXml2ComboString(sXml,"code","name")[0];	
				 }
				 lcc_cd.InsertItem(0,"ALL","ALL");
				 lcc_cd.SetSelectText('ALL');
				 break;	 
        }
    }
    /**
     * sheet1 
     */
    function sheet1_OnSearchEnd(sheetObj, codr, ErrMsg){
    	ComOpenWait(false);
		if(sheetObj.RowCount("R")>0){
			for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
				if(sheetObj.GetCellValue(i,"sts_cd") != "S"){
					sheetObj.rowEditable(i)=false;
				}
			}
			// Col TTL 
			calcColTtl(sheetObj);
		}
    }
    /**
     * onchange sheet1 
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value){
		 var formObj=document.form;
		 with (sheetObj) {
		 	  var colName=ColSaveName(Col);
		 	  switch (colName) {
			  	case "lcc_cd":
					  if(Value == ""){
					       sheetObj.SetCellValue(Row, "lcc_cd","",0);
                           sheetObj.SetCellValue(Row, "rcc_cd","",0);
					  }else{
						   formObj.f_cmd.value=SEARCH02;
                           var sXml=sheetObj.GetSearchData("EES_EQR_1041GS.do" , "f_cmd="+SEARCH02+"&loc_grp_cd=R"+"&loc_cd="+Value);
                           if (ComGetTotalRows(sXml) > 0) {
						   	  var tmpRccCd=ComXml2ComboString(sXml, "code", "name")[0].split('|')[0];
						      sheetObj.SetCellValue(Row, "rcc_cd",tmpRccCd,0);
							  if(rcc_cd.GetSelectCode()!="" && rcc_cd.GetSelectCode()!="ALL"){
							  	  if(rcc_cd.GetSelectCode()!= tmpRccCd){
									  ComShowCodeMessage("EQR01027",rcc_cd.GetSelectCode()); // 'LCC code is invalid.'
									  sheetObj.SetCellValue(Row, "rcc_cd","",0);
									  return false;
								  }
							  }
						   }else{
							  ComShowCodeMessage("EQR01005"); // 'LCC code is invalid.'
						   	  sheetObj.SetCellValue(Row, "lcc_cd","",0);
						      sheetObj.SetCellValue(Row, "rcc_cd","",0);
						   }
					  }
				      break;   
				default:
				    if(sheetObj.RowCount()> 0){
			            // Col TTL 
			            calcColTtl(sheetObj);
			        } 
					break;
			  }
         }
     }
     /**
      * save end event
      */
     function sheet1_OnSaveEnd(sheetObj, ErrMsg){
	 	var formObj=document.form;
	 	if(formObj.pop_mode.value == "Y"){ // popup mode 
	 	 if (ErrMsg == "") {
	 		if (save_flag) {
	 			var opener_obj=window.opener;
	 			var week_seq=formObj.dp_seq.value;
	 			var sheet_row=formObj.row.value;
	 			for (var j=9; j <= 24; j++) { // QTY
						if (sheetObjects[0].rowCount > 0) {
							var tmpSum=sheetObj.ComputeSum("|"+j+"|");
							opener_obj.setRepoInValue(week_seq, sheet_row, sheetObjects[0].ColSaveName(j).substr(0, 2), tmpSum);
						}
						else { //sheet_num
							opener_obj.setRepoInValue(week_seq, sheet_row, sheetObjects[0].ColSaveName(j).substr(0, 2), 0);
						}
					}
				}
				ComShowCodeMessage("EQR70002");
			}
		}
     }	 
    /**
     * Initialize combo  <br>
     * @param {object}  comboObj - Combo Object
     * @param {Number}  comboNo  - Combo Number
     * @version 2009.01.01
     */
    function initCombo (comboObj, comboNo) {
        var cnt=0 ;
        switch(comboObj.options.id) {   
            case "rcc_cd":
                with (comboObj) {              
                    SetMultiSelect(0);
                }
                break;
            case "lcc_cd":
                with (comboObj) {               
                    SetMultiSelect(0);
                }
                break;
            case "tpsztype":
                with (comboObj) {               
                    SetDropHeight(200);
                    var menuname=tpszallText.split('|'); 
                    var menucode=tpszallCode.split('|'); 
                    SetMultiSelect(1);
                    SetMaxSelect(menuname.length);
                    SetMultiSeparator(",");
                    for(i=0; i<menuname.length; i++) {
                        InsertItem(cnt++, menuname[i], menucode[i]);                            
                    } 
                }
                break;
        }
    }
    /**
     * validate input value
     */
    function validateForm(sheetObj,formObj,sAction) {
        with(sheetObj){
            switch (sAction) {
            case IBSAVE:
			    // WK  
				var trnRowStr=FindStatusRow("U|I");
				if(trnRowStr != ""){
	                var trnRowArr=trnRowStr.split(";");
					for(var i=0; i<trnRowArr.length; i++){
						if (trnRowArr[i] != "") {
							var tmpWeek=GetCellValue(trnRowArr[i], "onh_pln_yrwk");
							if (tmpWeek == "" ||
							tmpWeek.length != 6 ||
							!ComIsWeek(tmpWeek.substr(4, 2))) {
								ComShowCodeMessage("EQR01101", "right WK (YYYYMM)"); // 'Please input {?msg1}.';
								SelectCell(trnRowArr[i], "onh_pln_yrwk");
								return false;
							}
						}
					}
				}else if(FindStatusRow("U|I|D")==""){
                    ComShowCodeMessage("EQR01107"); // 'There is no data to save.'
				}
				break;
			case MULTI02:
				var selRow=sheetObj.GetSelectRow();
				if(selRow == ""){
					ComShowCodeMessage("EQR01101", "row"); //'Please select {?msg1}.'
					return false;
				}else if(sheetObj.GetCellValue(selRow,"sts_cd")!="S"){
					ComShowCodeMessage("EQR01021"); //'Only Saved row can be Requested.'
					return false;
				}
			    break;
			case MULTI03:
                var selRow=sheetObj.GetSelectRow();
                if(selRow == ""){
                    ComShowCodeMessage("EQR01101", "row"); //'Please select {?msg1}.'
                    return false;
                }else if(sheetObj.GetCellValue(selRow,"sts_cd")!="R"){
                    ComShowCodeMessage("EQR01022"); //'Only Requested row can be Request Canceled.'
                    return false;
                }
                break;
			case IBSEARCH:
				if (document.form.div_flag[0].checked == true) { // Approval WK 
                    if(formObj.yrwk.value == ""
					   || formObj.yrwk.value.length != 6
					   || !ComIsWeek(formObj.yrwk.value.substr(4,2))){
						ComShowCodeMessage("EQR01101", "Approval WK (YYYYWW)"); // 'Please input {?msg1}.';
                        return false;
					}
				}else if (document.form.div_flag[2].checked == true) { // Pick-up WK 
                        if(formObj.yrwk_pkup.value == ""
    					   || formObj.yrwk_pkup.value.length != 6
    					   || !ComIsWeek(formObj.yrwk_pkup.value.substr(4,2))){
    						ComShowCodeMessage("EQR01101", "Pick-up  WK (YYYYWW)"); // 'Please input {?msg1}.';
                            return false;
    					}                    
				}else if (document.form.div_flag[1].checked == true) { // Approval WK - Period
					if(formObj.periodtp.value == "W"){ // yyyyww
						if(formObj.fmperiod.value == "" || formObj.fmperiod.value.length != 6
	                       || !ComIsWeek(formObj.fmperiod.value.substr(4,2))){
	                        ComShowCodeMessage("EQR01101", "From Period (YYYYWW)"); // 'Please input {?msg1}.';
							return false;
	                    }
						if(formObj.toperiod.value == ""
                           || formObj.toperiod.value.length != 6
                           || !ComIsWeek(formObj.toperiod.value.substr(4,2))){
                            ComShowCodeMessage("EQR01101", "To Period (YYYYWW)"); // 'Please input {?msg1}.';
                            return false;
                        }
						if(formObj.fmperiod.value > formObj.toperiod.value){
							ComShowCodeMessage("EQR01101", "right Period"); // 'Please input {?msg1}.';
							return false;
						}
						if((((formObj.toperiod.value.substr(0,4)*1-formObj.fmperiod.value.substr(0,4)*1)*52)
						    +(formObj.toperiod.value.substr(4,2)*1-formObj.fmperiod.value.substr(4,2)*1)) > 11){
							ComShowCodeMessage("EQR01106", "12 Weeks"); // 'Maximum period is {?msg1}.'
                            return false;
						}
					}else{ // yyyymm
						if(formObj.fmperiod.value == ""
                           || formObj.fmperiod.value.length != 6
                           || !ComIsMonth(formObj.fmperiod.value.substr(4,2))){
                            ComShowCodeMessage("EQR01101", "From Period (YYYYMM)"); // 'Please input {?msg1}.';
                            return false;
                        }
                        if(formObj.toperiod.value == ""
                           || formObj.toperiod.value.length != 6
                           || !ComIsMonth(formObj.toperiod.value.substr(4,2))){
                            ComShowCodeMessage("EQR01101", "To Period (YYYYMM)"); // 'Please input {?msg1}.';
                            return false;
                        }
						if(formObj.fmperiod.value > formObj.toperiod.value){
                            ComShowCodeMessage("EQR01101", "right Period"); // 'Please input {?msg1}.';
                            return false;
                        }
                        if((((formObj.toperiod.value.substr(0,4)*1-formObj.fmperiod.value.substr(0,4)*1)*12)
                            +(formObj.toperiod.value.substr(4,2)*1-formObj.fmperiod.value.substr(4,2)*1)) > 11){
                            ComShowCodeMessage("EQR01106", "12 Months"); // 'Maximum period is {?msg1}.'
                            return false;
                        }
					}
				}else if (document.form.div_flag[3].checked == true) { // Pick-up WK - Period
					if(formObj.periodtp_pkup.value == "W"){ // yyyyww
						if(formObj.fmperiod_pkup.value == "" || formObj.fmperiod_pkup.value.length != 6
	                       || !ComIsWeek(formObj.fmperiod_pkup.value.substr(4,2))){
	                        ComShowCodeMessage("EQR01101", "From Period (YYYYWW)"); // 'Please input {?msg1}.';
							return false;
	                    }
						if(formObj.toperiod_pkup.value == ""
                           || formObj.toperiod_pkup.value.length != 6
                           || !ComIsWeek(formObj.toperiod_pkup.value.substr(4,2))){
                            ComShowCodeMessage("EQR01101", "To Period (YYYYWW)"); // 'Please input {?msg1}.';
                            return false;
                        }
						if(formObj.fmperiod_pkup.value > formObj.toperiod_pkup.value){
							ComShowCodeMessage("EQR01101", "right Period"); // 'Please input {?msg1}.';
							return false;
						}
						if((((formObj.toperiod_pkup.value.substr(0,4)*1-formObj.fmperiod_pkup.value.substr(0,4)*1)*52)
						    +(formObj.toperiod_pkup.value.substr(4,2)*1-formObj.fmperiod_pkup.value.substr(4,2)*1)) > 11){
							ComShowCodeMessage("EQR01106", "12 Weeks"); // 'Maximum period is {?msg1}.'
                            return false;
						}
					}else{ // yyyymm
						if(formObj.fmperiod_pkup.value == ""
                           || formObj.fmperiod_pkup.value.length != 6
                           || !ComIsMonth(formObj.fmperiod_pkup.value.substr(4,2))){
                            ComShowCodeMessage("EQR01101", "From Period (YYYYMM)"); // 'Please input {?msg1}.';
                            return false;
                        }
                        if(formObj.toperiod_pkup.value == ""
                           || formObj.toperiod_pkup.value.length != 6
                           || !ComIsMonth(formObj.toperiod_pkup.value.substr(4,2))){
                            ComShowCodeMessage("EQR01101", "To Period (YYYYMM)"); // 'Please input {?msg1}.';
                            return false;
                        }
						if(formObj.fmperiod_pkup.value > formObj.toperiod_pkup.value){
                            ComShowCodeMessage("EQR01101", "right Period"); // 'Please input {?msg1}.';
                            return false;
                        }
                        if((((formObj.toperiod_pkup.value.substr(0,4)*1-formObj.fmperiod_pkup.value.substr(0,4)*1)*12)
                            +(formObj.toperiod_pkup.value.substr(4,2)*1-formObj.fmperiod_pkup.value.substr(4,2)*1)) > 11){
                            ComShowCodeMessage("EQR01106", "12 Months"); // 'Maximum period is {?msg1}.'
                            return false;
                        }
					}
				}
            }
        }
        return true;
    }  
    /**
     * TP/SZ <br>
     * @param {String}  key - tpsz Combo Value('' - ALL, D - Dry, R - Refer, O - O/T, F - F/R)
     * @version 2009.01.01
     */
    function tpszChange(key){
    	comboObjects[2].SetSelectCode(-1);
        switch (key) {
        case "":
            tpsztype.SetSelectCode(consTpsz);
            break;
        case "D":
            tpsztype.SetSelectCode(consTpszDry);
            break;
        case "R":
            tpsztype.SetSelectCode(consTpszRfr);
            break;
        case "O":
            tpsztype.SetSelectCode(consTpszOt);
            break;
        case "F":
            tpsztype.SetSelectCode(consTpszFr);
            break;
        }
    }
    /**
     * Form Object Change Event <br>
     * @version 2009.01.01
     */
    function form_change(){
        var srcName=ComGetEvent("name");
        switch(srcName){
            case "cntrTpsz":
                var index=document.form.cntrTpsz.selectedIndex;
                tpszChange(document.form.cntrTpsz.options[index].value);
		        break;
		}
    }
    function rcc_cd_OnChange() {
        doActionIBSheet(sheetObjects[0],document.form,SEARCH03);
    }    
    function tpsztype_OnChange(){
        setGridHidden(tpsztype.GetSelectText());
		// Col TTL 
        calcColTtl(sheetObjects[0]);
    }
    /*
     * Container Type/Siz --> Hidden
     * OnloadPage,OnSearchEnd event
     * @param {String} tpsz_cd
     * DESC : Container Type/Size
     */
    function setGridHidden(tpsz_cd){
        var sheetObj=sheetObjects[0]; 
        var arr_tpsz=tpsz_cd.split(",");
        for(var i=0;i<consTpszArr.length;i++){ // Container Type/Size       
            for(var j=0;j<arr_tpsz.length;j++){ 
                if(consTpszArr[i] == arr_tpsz[j]){
                    sheetObj.SetColHidden(consTpszArr[i].toLowerCase()+"_qty",0);
                    break;
                }else if(j==arr_tpsz.length-1){ 
                    sheetObj.SetColHidden(consTpszArr[i].toLowerCase()+"_qty",1);
                }
            }       
        }  
    }    
	function radioToggle(){
        var formObj=document.form;
        if(document.form.div_flag[0].checked == true){ // Approval WK 
            formObj.yrwk.className="input1";
            formObj.periodtp.className="input";
            formObj.fmperiod.className="input";
            formObj.toperiod.className="input";
            formObj.yrwk_pkup.className="input";
            formObj.periodtp_pkup.className="input";
            formObj.fmperiod_pkup.className="input";
            formObj.toperiod_pkup.className="input";
        }else if(document.form.div_flag[1].checked == true){ // Approval WK - Period 
            formObj.yrwk.className="input";
            formObj.periodtp.className="input1";
            formObj.fmperiod.className="input1";
            formObj.toperiod.className="input1";
            formObj.yrwk_pkup.className="input";
            formObj.periodtp_pkup.className="input";
            formObj.fmperiod_pkup.className="input";
            formObj.toperiod_pkup.className="input";
        }else if(document.form.div_flag[2].checked == true){ // Pick-up WK  
            formObj.yrwk.className="input";
            formObj.periodtp.className="input";
            formObj.fmperiod.className="input";
            formObj.toperiod.className="input";
            formObj.yrwk_pkup.className="input1";
            formObj.periodtp_pkup.className="input";
            formObj.fmperiod_pkup.className="input";
            formObj.toperiod_pkup.className="input";
        }else if(document.form.div_flag[3].checked == true){ // Pick-up WK -period  
            formObj.yrwk.className="input";
            formObj.periodtp.className="input";
            formObj.fmperiod.className="input";
            formObj.toperiod.className="input";
            formObj.yrwk_pkup.className="input";
            formObj.periodtp_pkup.className="input1";
            formObj.fmperiod_pkup.className="input1";
            formObj.toperiod_pkup.className="input1";
        } 
    }
    // Column TTL 
	function calcColTtl(sheetObj){
		if(tpsztype.GetSelectText()== ""){// TPSZ
			for (var i=sheetObj.HeaderRows(); i < sheetObj.HeaderRows()+ sheetObj.RowCount(); i++) {
				var rowSts=sheetObj.GetCellValue(i,"ibflag"); // ibflag
			    sheetObj.SetCellValue(i,"ttl",0,0);
				sheetObj.SetCellValue(i,"ibflag",rowSts,0);
			}
		}else{
			var arr_tpsz=tpsztype.GetSelectText().split(","); //  TP/SZ
			for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
				var rowSts=sheetObj.GetCellValue(i,"ibflag"); // ibflag
				var tmpSum=0;
				for(var t=0; t<arr_tpsz.length; t++){
					tmpSum=tmpSum + sheetObj.GetCellValue(i,arr_tpsz[t].toLowerCase()+"_qty")*1;
				}
				sheetObj.SetCellValue(i,"ttl",tmpSum,0);
				sheetObj.SetCellValue(i,"ibflag",rowSts,0);
			}
		}
	}	
