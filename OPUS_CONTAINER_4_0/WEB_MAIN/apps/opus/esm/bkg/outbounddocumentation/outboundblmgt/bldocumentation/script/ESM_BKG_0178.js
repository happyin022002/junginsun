/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0178.js
*@FileTitle  : C/M by Container 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/08
=========================================================
*/

/****************************************************************************************
Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class business script for esm_bkg_0178
     */
    function esm_bkg_0178() {
    	this.processButtonClick=processButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
	 /* developer job	*/
	 // common global variables
	var tabObjects = new Array();
	var tabCnt=0 ;
	var beforetab= 1;
	var sheetObjects= new Array();
	var sheetCnt=0;
	// Event handler processing by button click event
	document.onclick=processButtonClick;
	// Event handler processing by button name
    function processButtonClick(){
         var sheetObject1= sheetObjects[0];
         var sheetObject2= sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	 try {
    		var srcName = ComGetEvent("name");
            switch(srcName) {
				case "dcgo_flg":
				case "bb_cgo_flg":
				case "awk_cgo_flg":
				case "rc_flg":
				case "rd_cgo_flg":
				case "hngr_flg":
					return false;
				break;
				case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
				case "btn_new":
					resetPage();
				break;
				case "btn_save":
					doActionIBSheet(sheetObject2,formObject,IBSAVE);
				break;
				case "btn_cntrlist":
					var vvd=formObject.t_vvd.value;
					var ofc_cd=formObject.bkg_ofc_cd.value;
					var pol=formObject.pol_cd.value;
					var pod=formObject.pod_cd.value;
					var url="?func=callbackCntr&bkg_vvd="+vvd+"&bkg_ofc_cd="+ofc_cd+"&bkg_pol="+pol+"&bkg_pod="+pod;
//					ComOpenWindow(url, "ESM_BKG_0892", "dialogWidth:600px;dialogHeight:400px;", true);
				    ComOpenPopup("ESM_BKG_0892.do"+url, 600,400, "callbackCntr","1,0", true);
				break;
				case "btn_add":
					doActionIBSheet(sheetObject2,formObject,IBINSERT);
				break;
				case "btn_del":
					doActionIBSheet(sheetObject2,formObject,IBDELETE);
				break;
				case "btn_copy":
					doActionIBSheet(sheetObject2,formObject,IBCOPYROW);
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
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
    function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			//initSheet
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		// search init value
		if(document.form.cntr_no.value != ''){
			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
		}
        //add listener
		//axon_event.addListenerForm('focus', 'form1_focus', document.form);
        axon_event.addListenerForm('blur', 'form1_blur', document.form);
        //axon_event.addListenerForm('keypress', 'form1_keypress', document.form);		
        axon_event.addListenerForm('change', 'form1_change', document.form);
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');// Enter key
    }
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
	              var HeadTitle="|Sel.|Seq.|Booking No.|B/L No.|B/L No.|BDR|Issued|Cntr|Package|Package|Weight|Weight|Measure|Measure|Ratio|R/D|R/D|DG|AK|HG|POR|DEL|Commodity|Commodity";
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mf_cfm_flg" },
	                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	                     {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"bl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"bl_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bdr_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:46,   Align:"Center",  ColMerge:0,   SaveName:"obl_iss_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
	                     {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"cntr_wgt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
	                     {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"meas_qty",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
	                     {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"meas_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Float",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_vol_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
	                     {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"rcv_term_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"de_term_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,  TrueValue:"Y", FalseValue:"N" },
	                     {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,  TrueValue:"Y", FalseValue:"N" },
	                     {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"hngr_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,  TrueValue:"Y", FalseValue:"N" },
	                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:250,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		            InitColumns(cols);
		            SetEditable(1);
		            SetSheetHeight(122);
                }
			break;
			
            case 2:      //sheet2 init
                with(sheetObj){
	              var HeadTitle="|Sel.|Seq.|BkgNo|CntrNo|MF Seq.|RDTerm|RDTerm|Package|Package|Package|Weight|Weight|Measure|Measure|Marks|Marks|Description|DG|AK|HG";
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sel" },
	                     {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"rcv_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"de_term_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
	                     {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	                     {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"PCKPop",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Float",     Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_wgt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"wgt_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Float",     Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"meas_qty",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"meas_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0, Width:150,  Align:"Right",  ColMerge:0,   SaveName:"cntr_mf_mk_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"MDPop",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_gds_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,  TrueValue:"Y", FalseValue:"N"},
	                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,  TrueValue:"Y", FalseValue:"N"},
	                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hngr_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,  TrueValue:"Y", FalseValue:"N"} ];
				          
	              		  InitColumns(cols);
				          SetEditable(1);
				          SetShowButtonImage(2);
//				          SetSheetHeight(220);
				          updateSheetSize(sheetObj);
				          SetColProperty(0 ,"pck_tp_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
	            }
			break;
        }
    }
    
    $(window).resize(function() {
		if(this.resizeTO) {
			clearTimeout(this.resizeTO);
		}
		this.resizeTO = setTimeout(function() {
			$(this).trigger('resizeEnd');
		}, 300);
 });
 
 $(window).on('resizeEnd', function() {
	 updateSheetSize(sheetObjects[1]);
 });
 
 function updateSheetSize(sheetObj){
	 var obj = $("#" + sheetObj.id).offset();
	 var marginDefault = 60;
	 var marginHeight = obj.top + marginDefault;
    var height = $(window).height();

    with(sheetObj){
        SetSheetHeight(height - marginHeight); 
    }
 } 
 
    // handling of Sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      // retrieve
				if(validateForm(sheetObj,formObj,sAction)){
					ComOpenWait(true); 
                    formObj.f_cmd.value=SEARCH;
                    var rXml = sheetObj.GetSearchData("ESM_BKG_0178GS.do", FormQueryString(formObj));
					if(rXml == '' || rXml.length < 7) return;
					if(rXml.substring(1, 6) == "ERROR"){
						//alert(ComResultMessage(rXml).split('<||>').join('\n'));
						ComShowMessage(ComResultMessage(rXml));
						return;
					}
					ComOpenWait(false); 
                    var arrXml=rXml.split("|$$|");
					if(arrXml.length==2){
						var cmCntrXml=arrXml[0];
						var cmDescXml=arrXml[1];
						// CM Container Info
						sheetObjects[0].LoadSearchData(cmCntrXml,{Sync:1} );
						sheetObjects[1].LoadSearchData(cmDescXml,{Sync:1} );
						if(sheetObjects[0].GetTotalRows()> 0){
							// CM Booking Info
							ComEtcDataXmlToForm(cmCntrXml, formObj);
							formObj.pck_qty.value=ComAddComma3(formObj.pck_qty.value, "#,###");
							formObj.cntr_wgt.value=ComAddComma3(formObj.cntr_wgt.value, "#,###.000");
							formObj.meas_qty.value=ComAddComma3(formObj.meas_qty.value, "#,###.000");							
							//
							var sealNos=ComGetEtcData(cmCntrXml, "cntr_seal_no");
							if(sealNos != undefined && sealNos != ''){
								var seal_arr=(sealNos.indexOf(',') == -1) ? new Array(sealNos) : sealNos.split(',');
								ComArrayToOptions(seal_arr, formObj.cntr_seal_no);
							}
							// CM Cntr MF Info
							sheetObjects[1].LoadSearchData(cmDescXml,{Sync:1} );
							// bdr_flag = 'Y'
							var rcnt=sheetObjects[0].RowCount();
							for(rn=1;rn<=rcnt;rn++){
								if (sheetObjects[0].GetCellValue(rn, "bdr_flg") == 'Y') {
									sheetObjects[0].SetCellFontColor(rn, "bkg_no","#0000FF");
								}
							}							
							//sheetObjects[0].SelectCell(1, "bkg_no", false);
							formObj.bkg_no.value=sheetObjects[0].GetCellValue(1, "bkg_no");
							// change view/hide
							setCMInfo(1);
							//changeEditable
							changeEditable();								
						}
					}else{
						return;
					}
				}
			break;
			
			case IBSAVE:        // save
				if(validateForm(sheetObj,formObj,sAction)){
					ComOpenWait(true); 
					formObj.f_cmd.value=MULTI;
					// form param
					var sParam=FormQueryString(formObj);
					// Sheet1 param
					var sParamSheet1=sheetObjects[0].GetSaveString();
					if (sParamSheet1 != "") {
						sParam=sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
					}
					// Sheet2 param
					var sParamSheet2=sheetObjects[1].GetSaveString();
					if (sParamSheet2 != "") {
						sParam=sParam + "&sheet2_" + sParamSheet2.replace(/&/g, '&sheet2_');
					}
					// return xML
					var rXml=sheetObj.GetSaveData("ESM_BKG_0178GS.do", sParam);
					var rMsg=ComResultMessage(rXml);
					if(rMsg == ''){
						/* Transaction rollback */
						sheetObjects[0].LoadSaveData("<RESULT><TR-ALL>OK</TR-ALL><MESSAGE/></RESULT>");
						sheetObjects[1].LoadSaveData("<RESULT><TR-ALL>OK</TR-ALL><MESSAGE/></RESULT>");
						/* success Message */
						ComShowMessage(ComGetMsg("BKG00166"));
					} else {
						//alert(rMsg.split('<||>').join('\n'));
						ComShowMessage(rMsg);
					}
					ComOpenWait(false); 
				}
			break;
			
			case IBINSERT:      // insert
				if (sheetObjects[0].RowCount() > 0)
					{
						if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "bkg_no") == ''){
							return;
						}
						if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "bdr_flg") == 'Y'){
							ComShowMessage(ComGetMsg("BKG08003"));
							return;
						}
					}
				var nRow=sheetObj.DataInsert(-1);
				sheetObj.SetCellValue(nRow, "pck_qty", 1 ,0);
				sheetObj.SetCellValue(nRow, "meas_qty", "0.000",0);
				sheetObj.SetCellValue(nRow, "bkg_no", sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "bkg_no"), 0);
				sheetObj.SetCellValue(nRow, "cntr_no", sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "cntr_no"), 0);
				//changeEditable
				changeEditable();
				//setSeq
				setSeq();
			break;
			
			case IBDELETE:      // 삭제
				if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "bdr_flg") == 'Y'){
					ComShowMessage(ComGetMsg("BKG08003"));
					return;
				}
				ComRowHideDelete(sheetObj, "sel", true)
				//changeEditable
				//changeEditable();
				//setSeq
				setSeq();
			break;
			
			case IBCOPYROW:      // copy
				var cp_cnt=formObj.cp_cnt.value
				for(ix=0;ix<cp_cnt;ix++){
					sheetObj.DataCopy();
				}
				// setSeq
				setSeq();
			break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSEARCH:
				/*
				1. No exist Container No=[BKG00753] 
				2. No exist VVD=[BKG00754] 
				*/
				with(formObj){
					if(cntr_no.value == ''){
						ComShowMessage(ComGetMsg("BKG00753"));
//						cntr_no.focus();
						return false;
					}
					if(t_vvd.value == ''){
						ComShowMessage(ComGetMsg("BKG00754"));
//						t_vvd.focus();
						return false;
					}
				}
			break;
			
			case IBSAVE:
				/*
				1. No exist Container No=[BKG00753] 
				2. No exist VVD=[BKG00754] 
				*/
				with(formObj){
					if(cntr_no.value == ''){
						ComShowMessage(ComGetMsg("BKG00753"));
//						cntr_no.focus();
						return false;
					}
					if(t_vvd.value == ''){
						ComShowMessage(ComGetMsg("BKG00754"));
//						t_vvd.focus();
						return false;
					}
					// bdr flag
					//if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "bdr_flg")=='Y'){
					//	ComShowMessage(ComGetMsg("BKG00335"));
					//	return false;
					//}
				}
				var rCnt=sheetObjects[1].RowCount();
				for(rn=1;rn <= rCnt;rn++){
					if(sheetObjects[1].GetCellValue(rn, "pck_qty") == ''){
						ComShowMessage(ComGetMsg("BKG00504"));
						return false;
					}
					if(sheetObjects[1].GetCellValue(rn, "pck_tp_cd") == ''){
						ComShowMessage(ComGetMsg("BKG00505"));
						return false;
					}
					if(sheetObjects[1].GetCellValue(rn, "cntr_mf_gds_desc") == ''){
						ComShowMessage(ComGetMsg("BKG00510"));
						return false;
					}
					if(sheetObjects[1].GetCellValue(rn, "pck_qty") == 0 && !formObj.bb_cgo_flg.checked){
						ComShowMessage(ComGetMsg("BKG00504"));
						return false;
					}
				}
				if(sheetObjects[1].RowCount() == 0){
					ComShowMessage(ComGetMsg("BKG00012"));
					return false;
				}
			break;
		} // end switch
        return true;
    }
	/* --------------------------------------------------------------------
	 * Event 처리
	 ---------------------------------------------------------------------- */
	function form1_focus(){
		//ComClearSeparator(event.srcElement);
	}
    function form1_blur(){
		//ComChkObjValid(event.srcElement);
        var srcName= ComGetEvent("name");
        switch(srcName){
            case "bkg_no":
				//retrieveSplitNo();
            break;
        }
    }
//	function form1_keypress(){
//   		if (event.srcElement.type == "text" && event.keyCode == 13 ) {
//			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
//			//ComKeyEnter("search");
//		}
//		switch(event.srcElement.dataformat){
//			case "ymd":
//				ComKeyOnlyNumber(event.srcElement);
//				break;
//			case "ym":
//			case "yw":
//			case "jumin":
//			case "saupja":	//number + "-"
//				ComKeyOnlyNumber(event.srcElement, "-"); 
//			break;
//			case "hms":
//			case "hm":		//number + ":"
//				ComKeyOnlyNumber(event.srcElement, ":"); 
//			break;
//			case "int":		//number
//				ComKeyOnlyNumber(event.srcElement); 
//			break;
//			case "float":	//number+"."	            
//				ComKeyOnlyNumber(event.srcElement, "."); 
//			break;	    
//			case "engup":
//				//Upper Case
//				ComKeyOnlyAlphabet("upper");
//			break;
//			case "engupnum":
//				//number+"Upper Case"
//				ComKeyOnlyAlphabet("uppernum");
//			break;
//			case "engupnumspc":
//				//Upper Case + number + space
//				//ComKeyOnlyAlphabet("uppernum", "32|45|95");
//				var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//				if(keyValue >= 97 && keyValue <= 122){                  // lower Case
//                	event.keyCode=keyValue + 65 - 97;
//				}
//				//event.returnValue = true;
//			break;
//		}			
//	}
    
    function form1_change(){
        var srcName= ComGetEvent("name");
        switch(srcName){
            case "bkg_no":
            break;
        }
    }
	function sheet1_OnClick(sheetObj, row, col, val) {
		document.form.bkg_no.value=sheetObj.GetCellValue(row, "bkg_no");
        if(sheetObj.ColSaveName(col) != "mf_cfm_flg") {
			// change view/hide
			setCMInfo(row);
			//changeEditable
			changeEditable();
		}
	}
	function sheet1_OnChange(sheetObj, row, col, val){
		var data_type=sheetObj.GetCellProperty(row, col, "Type");
		if(data_type == "Text") {
			sheetObj.SetCellValue(row, col,sheetObj.GetCellValue(row, col).toUpperCase(),0);
		}
        var col_name=sheetObj.ColSaveName(col);
		switch(col_name) {
			case "mf_cfm_flg":
				// change view/hide
				setCMInfo(row);				
				//changeEditable
				changeEditable();
				// validation
				if(val == 1){
					//var bkg_pck_qty   = ComTrimAll(document.form.pck_qty.value, ",");
					//var bkg_wgt_qty   = ComTrimAll(document.form.cntr_wgt.value, ",");
					//var bkg_meas_qty  = ComTrimAll(document.form.meas_qty.value, ",");
					//var cm_pck_qty    = ComColumnSum(sheetObjects[1], "pck_qty");
					//var cm_wgt_qty    = ComColumnSum(sheetObjects[1], "cntr_mf_wgt");
					//var cm_meas_qty   = ComColumnSum(sheetObjects[1], "meas_qty");
					var bkg_pck_qty=sheetObjects[0].GetCellValue(row, "pck_qty");
					var bkg_wgt_qty=sheetObjects[0].GetCellValue(row, "cntr_wgt");
					var bkg_meas_qty=sheetObjects[0].GetCellValue(row, "meas_qty");
					var cm_pck_qty=ComColumnSum(sheetObjects[1], "pck_qty", true);
					var cm_wgt_qty=ComColumnSum(sheetObjects[1], "cntr_mf_wgt", true);
					var cm_meas_qty=ComColumnSum(sheetObjects[1], "meas_qty", true);
					if(bkg_pck_qty != cm_pck_qty || bkg_wgt_qty != cm_wgt_qty || bkg_meas_qty != cm_meas_qty){
						if(confirm(ComGetMsg("BKG00752"))) {
							sheetObjects[0].SetCellValue(row, "pck_qty",ComColumnSum(sheetObjects[1], "pck_qty", 1),0);
							sheetObjects[0].SetCellValue(row, "cntr_wgt",ComColumnSum(sheetObjects[1], "cntr_mf_wgt", 1),0);
							sheetObjects[0].SetCellValue(row, "meas_qty",ComColumnSum(sheetObjects[1], "meas_qty", 1),0);
							document.form.pck_qty.value=ComAddComma3(ComColumnSum(sheetObjects[1], "pck_qty"), "#,###");
							document.form.cntr_wgt.value=ComAddComma3(ComColumnSum(sheetObjects[1], "cntr_mf_wgt"), "#,###.000");
							document.form.meas_qty.value=ComAddComma3(ComColumnSum(sheetObjects[1], "meas_qty"), "#,###.000");
						}else{
							return false;
						}
					}
				}
			break;
		} // end switch
	}
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var rCnt=sheetObj.RowCount();
		//alert("rCnt : " + rCnt);
		for(ir=1;ir<=rCnt;ir++){
			//alert("bdr_flg : " + sheetObj.CellValue(ir, "bdr_flg") );
			if (sheetObj.GetCellValue(ir, "bdr_flg") == 'Y') {
				sheetObj.SetCellFontColor(ir, "bkg_no","#0000FF");
			}
		}		
		// BKG중 하나라도 BDR 또는 Issue 상태이면 Save Block
		var rcnt=sheetObjects[0].RowCount();
		var saveCheck=false;
		for(rn=1; rn <= rcnt; rn++){
			var bdrFlg=sheetObjects[0].GetCellValue(rn, "bdr_flg");//document.form.bdr_flg.value
			var issFlg=sheetObjects[0].GetCellValue(rn, "obl_iss_flg");
			if(bdrFlg == 'Y' || issFlg == 'Y'){
				saveCheck=true;
			}
		}
		if(saveCheck){
			ComBtnDisable("btn_save");
		} else {
			ComBtnEnable("btn_save");
		}
	}
	
	function sheet2_OnChange(sheetObj, row, col, val){
		// 'obl_iss_flg'= 'Y' : 'BKG08003'
		var data_type=sheetObj.GetCellProperty(row, col, "Type");
		if(data_type == "Text") {
			sheetObj.SetCellValue(row, col, (Number.isNaN(sheetObj.GetCellValue(row, col)) ? sheetObj.GetCellValue(row, col).toUpperCase() : sheetObj.GetCellValue(row, col)),0);
		}
        var col_name=sheetObj.ColSaveName(col);
		switch(col_name) {
			case "pck_qty":
				document.form.cm_pck_qty.value=ComAddComma3(ComColumnSum(sheetObj, "pck_qty", true), "#,###");
			break;
			case "cntr_mf_wgt":
				document.form.cm_cntr_wgt.value=ComAddComma3(ComColumnSum(sheetObj, "cntr_mf_wgt", true), "#,###.000");
			break;
			case "meas_qty":
				document.form.cm_meas_qty.value=ComAddComma3(ComColumnSum(sheetObj, "meas_qty", true), "#,###.000");
			break;
		} // end switch
	}
	
	function sheet2_OnPopupClick(sheetObj, row, col){
		//alert(sheetObj.id + " -> " + sheetObj.ColSaveName(col));
        var col_name=sheetObj.ColSaveName(col);
		switch(col_name) {
			case "PCKPop":
				//var url = "ESM_BKG_0696.do";
				//ComOpenWindow(url, "ESM_BKG_0696", "width=400,height=389", false);
				comBkgCallPop0696("callbackPckTp", sheetObj.GetCellValue(row, "pck_tp_cd"));
			break;
			
			case "MDPop":
//				var frm=document.form2;
//	            var param="?pgmNo=ESM_BKG_0706&gds_desc="+sheetObj.GetCellValue(row, "cntr_mf_gds_desc")+"&mk_desc="+sheetObj.GetCellValue(row, "cntr_mf_mk_desc");
//	            ComOpenPopup("ESM_BKG_0706.do"+param, 450,450, "callbackMFDesc","1,0", true);
	            
				var frm2 = document.form2;
				var width = 450;
				var height = 450;
				var left = (screen.width-width)/2;
				var top = (screen.height-height)/2;
				var win = window.open("", "ESM_BKG_0706", "width="+width+",height="+height+",left="+left+",toolbar=no,directories=no,status=no,scrollbars=no,resizable=no,modal=yes");
				frm2.mk_desc.value = sheetObj.GetCellValue(row, "cntr_mf_mk_desc");
				frm2.gds_desc.value = sheetObj.GetCellValue(row, "cntr_mf_gds_desc");
				frm2.func.value = "callbackMFDesc";
				frm2.action = "ESM_BKG_0706.do";
				frm2.method = "POST";
				frm2.target = "ESM_BKG_0706";
				frm2.submit();	
			break;
		} // end switch
	}
	function setCMInfo(row){
		//alert(row + ". BkgNo : " + sheetObjects[0].CellValue(row, "bkg_no"));
		if(row > 0) {
			// retrieve CM
			ComShowAndHideSheet(sheetObjects[1], "bkg_no", sheetObjects[0].GetCellValue(row, "bkg_no"));
			//setSeq
			setSeq();
			//get total
			document.form.cm_pck_qty.value=ComAddComma3(ComColumnSum(sheetObjects[1], "pck_qty", true), "#,###");
			document.form.cm_cntr_wgt.value=ComAddComma3(ComColumnSum(sheetObjects[1], "cntr_mf_wgt", true), "#,###.000");
			document.form.cm_meas_qty.value=ComAddComma3(ComColumnSum(sheetObjects[1], "meas_qty", true), "#,###.000");			
		}
	}
	function setSeq(){
		var rSeq=1;
		var rCnt=sheetObjects[1].RowCount();
		for (rn=1; rn <= rCnt; rn++) {
			var rsts=sheetObjects[1].GetRowStatus(rn);
			if(rsts != 'D' && sheetObjects[1].GetRowHidden(rn) == false){
				sheetObjects[1].SetCellValue(rn, "seq",rSeq++,0);
				sheetObjects[1].SetRowStatus(rn,rsts);
			}
		}
	}
	function changeEditable(){
		var dcFlg=(document.form.dcgo_flg != undefined && document.form.dcgo_flg.checked);
		var bbFlg=(document.form.bb_cgo_flg != undefined && document.form.bb_cgo_flg.checked);
		var akFlg=(document.form.awk_cgo_flg != undefined && document.form.awk_cgo_flg.checked);
		var rcFlg=(document.form.rc_flg != undefined && document.form.rc_flg.checked);
		var rdFlg=(document.form.rd_cgo_flg != undefined && document.form.rd_cgo_flg.checked);
		var hgFlg=(document.form.hngr_flg != undefined && document.form.hngr_flg.checked);
		document.form.dcgo_flg.disabled=!dcFlg;
		document.form.bb_cgo_flg.disabled=!bbFlg;
		document.form.awk_cgo_flg.disabled=!akFlg;
		document.form.rc_flg.disabled=!rcFlg;
		document.form.rd_cgo_flg.disabled=!rdFlg;
		document.form.hngr_flg.disabled=!hgFlg;
		var rcnt=sheetObjects[1].RowCount();
		for(rn=1; rn <= rcnt; rn++){
			sheetObjects[1].SetCellEditable(rn, "dcgo_flg",dcFlg);
			sheetObjects[1].SetCellEditable(rn, "awk_cgo_flg",akFlg);
			sheetObjects[1].SetCellEditable(rn, "hngr_flg",hgFlg);
		}
		var cfmFlg=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "mf_cfm_flg");
		var bdrFlg=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "bdr_flg");//document.form.bdr_flg.value
		var issFlg=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "obl_iss_flg");
		if(cfmFlg == 1){
			sheetObjects[1].SetEditable(0);
			ComBtnDisable("btn_add");
			ComBtnDisable("btn_del");
		}else{
			sheetObjects[1].SetEditable(1);
			ComBtnEnable("btn_add");
			ComBtnEnable("btn_del");
		}
	}
	
	function resetPage(){
		document.form.reset();
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		var comboObj=document.form.cntr_seal_no;
		var clen=(comboObj==null) ? 0 : comboObj.length;
		for(ic=0;ic<clen;ic++){
			comboObj.remove(clen-1-ic);
		}		
	}
	
	function callbackPckTp(returnVal){
		//alert(returnVal[0][0] + "|" + returnVal[0][1] + "|" + returnVal[0][2] + "|" + returnVal[0][3])
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "pck_tp_cd",returnVal.cd,0);
	}
	function callbackMFDesc(mk_desc, gds_desc){
		//alert(mk_desc + "\n===================================\n" + gds_desc);
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "cntr_mf_mk_desc",mk_desc,0);
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "cntr_mf_gds_desc",gds_desc,0);
	}
	function callbackCntr(cntr_no, t_vvd){
		/*
		var len=rtnArr.length;
		for(i=0;i<len;i++){
			//alert(rtnArr[i]);
			var cntr_no=rtnArr[i][0]; 
			var cntr_tp_sz=rtnArr[i][1]; 
			var cntr_mf_flg=rtnArr[i][2]; 
		}
		*/
		//alert(cntr_no +" / "+ t_vvd);
		document.form.cntr_no.value=cntr_no;
		document.form.t_vvd.value=t_vvd;
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
	}
