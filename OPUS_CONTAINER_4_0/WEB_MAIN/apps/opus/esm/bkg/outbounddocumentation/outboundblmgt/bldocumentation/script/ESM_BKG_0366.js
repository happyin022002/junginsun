/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_366.js
*@FileTitle  :  Marks And Number/Description of Goods
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class ESM_BKG_366 : ESM_BKG_366 
     */
    function ESM_BKG_0366() {
    	this.processButtonClick=processButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
   	/* developer's work*/
	// global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=checkLoad;
	function checkLoad(){	//'target' undefined error
		var readyState = document.readyState;
		if(readyState != 'interactive' && readyState != 'complete') {
			setTimeout("checkLoad()", 100);
		}
		else {
			processButtonClick();
		}
	}
	// Event handler processing by button name */
	function processButtonClick(){
		/***** using extra sheet valuable if there are more 2 sheets *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var sheetObject3=sheetObjects[2];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
    		if(srcName != "btn_splitPop"){
        		if(layList.style.display != "none"){
        			layList.style.display="none";
        		}    	    			
    		}
            switch(srcName) {
				case "btn_splitPop":			
					doActionIBSheet(sheetObject1,formObject,COMMAND04);					
				break;
				case "btn_split":
					var org_bl_no=formObject.org_bl_no.value;
					var org_cntr_mf_no=formObject.org_cntr_mf_no.value;
					var url="ESM_BKG_0959.do?func=callbackSplit&bkg_no="+org_bl_no+"&org_cntr_mf_no="+org_cntr_mf_no;
					ComOpenWindowCenter(url, "ESM_BKG_0959", 420, 180, true);
				break;
				case "btn_hbl_tmplt":
					var shpr_nm=formObject.shpr_nm.value;
					var cnee_nm=formObject.cnee_nm.value;
					var url="ESM_BKG_0399.do?func=callbackHblTmplt&shpr_nm="+shpr_nm+"&cnee_nm="+cnee_nm;
					ComOpenWindowCenter(url, "ESM_BKG_0399", 800, 630, true);
				break;
				case "btn_PCKPop":
					comBkgCallModal0696("callbackPckTp", formObject.pck_tp_cd.value   );
				break;
				case "btn_add":
					if(ComIsEmpty(formObject.cntr_mf_no.value)){
						ComShowMessage(ComGetMsg("BKG00237"));
						return;
					}
					if(sheetObject1.RowCount()> 0 && sheetObject1.GetSelectRow()> 0){
						// add row
						var bkg_no=formObject.bkg_no.value;
						var cntr_mf_no=formObject.cntr_mf_no.value;
						var cntr_no=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "cntr_no");
						var wgt_ut_cd=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "wgt_ut_cd");
						var meas_ut_cd=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "meas_ut_cd");
						var nrow=sheetObject2.DataInsert(-1);
						sheetObject2.SetCellValue(nrow, "bkg_no",bkg_no,0);
						sheetObject2.SetCellValue(nrow, "cntr_no",cntr_no,0);
						sheetObject2.SetCellValue(nrow, "cntr_mf_no",cntr_mf_no,0);
						sheetObject2.SetCellValue(nrow, "wgt_ut_cd",wgt_ut_cd,0);
						sheetObject2.SetCellValue(nrow, "meas_ut_cd",meas_ut_cd,0);
						// Set Seq
						var rseq=0;
						var rcnt=sheetObjects[1].RowCount();
						for(rn=1; rn <= rcnt; rn++){
						if(sheetObjects[1].GetRowStatus(rn) != 'D' &&
						sheetObjects[1].GetCellValue(rn, "cntr_no") == cntr_no &&
						sheetObjects[1].GetCellValue(rn, "cntr_mf_no") == cntr_mf_no) {
								rseq++;
							}
						}
						sheetObject2.SetCellValue(nrow, "seq",rseq,0);
						// recording modification
						formObject.dirty_flag.value='Y'
					} else {
						ComShowMessage(ComGetMsg("BKG08130"));
						return;
					} 
				break;
				case "btn_delete":
					ComRowDelete(sheetObject2, "sel", 1);
					// calculatePackage
					calculatePackage();
					// recording modification
					formObject.dirty_flag.value='Y'
				break;
				case "btn_t9CopyMnd":
					if(ComIsBtnEnable("btn_t9CopyMnd")){
						doActionIBSheet(sheetObject2,formObject,IBCOPYROW);
					}
				break;
				case "btn_retrieve":
					/* in case of modifying, showing the message "SAVE_CNFM" - in case of selecting Yes, calling save */
					if(formObject.dirty_flag.value == 'Y'){
						if(confirm(ComGetMsg("BKG00254"))){
							doActionIBSheet(sheetObject3, formObject, IBSAVE);
						}
					}				
					doActionIBSheet(sheetObject3, formObject, IBSEARCH) ;
				break;
				case "btn_save":
					/* in case of modifying, showing the message "SAVE_CNFM" - in case of selecting Yes, calling save */
//					if(formObject.dirty_flag.value == 'Y' && confirm(ComGetMsg("BKG00254"))){
					if(formObject.dirty_flag.value != "Y"){
						ComShowCodeMessage("BKG00233");
					}else if(confirm(ComGetMsg("BKG00254"))){
						var rflag=doActionIBSheet(sheetObject3, formObject, IBSAVE) ;
						if(rflag) {
							// success message
							ComShowMessage(ComGetMsg("BKG00166"));
						}
					}
				break;
				case "btn_addHBl":
					doActionIBSheet(sheetObject3, formObject, IBINSERT);
				break;
				case "btn_deleteHBl":
					doActionIBSheet(sheetObject3, formObject, IBDELETE);
				break;
				case "btn_copyHBl":
					if(sheetObjects[2].GetSelectRow()<= 0) {
//						alert("no selected row!");
						ComShowMessage(ComGetMsg("BKG00249"));
						return;
					}
					//alert("UI_BKG-0960");
					var url="ESM_BKG_0960.do?func=callbackCopyHbl";
					ComOpenWindowCenter(url, "ESM_BKG_0960", 370, 160, true);
				break;
				case "btn_copyCM":
					var selIdx=sheetObject1.GetSelectRow();
					if(selIdx > 0){
						var cntr_no=sheetObject1.GetCellValue(selIdx, "cntr_no");
						var cntr_tpsz_cd=sheetObject1.GetCellValue(selIdx, "cntr_tpsz_cd");
						var url="ESM_BKG_0176.do?cntr_no="+cntr_no+"&cntr_tpsz_cd="+cntr_tpsz_cd;
						ComOpenPopup(url,450, 300, "", "1,0", true);
					}else{
						ComShowMessage(ComGetMsg("BKG00188"));
					}
				break;
				case "btn_amsFileNoAssign":
					if(ComIsBtnEnable("btn_amsFileNoAssign")){
						if(confirm(ComGetMsg("BKG00240"))) {
							if(formObject.dirty_flag.value == 'Y'){
								var rflag=doActionIBSheet(sheetObject3, formObject, IBSAVE);
								if(!rflag) return;
							}					
							doActionIBSheet(sheetObject3, formObject, MULTI01) ;
						}
					}
				break;
			} // end switch
		}catch(e) {
			if( e.name == "TypeError") {
				return false;
			}else{
	    		ComShowMessage(e.message);
			}
		}
	}
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
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
    	     /*if (window.self != window.top) {
    	      document.getElementsByClassName('header_fixed')[0].style.display="none";
    	      document.getElementsByClassName('btn_gnb_hide ir')[0].style.display="none";
    	     }*/
        for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			//initSheet
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
			//
			sheetObjects[i].SetWaitImageVisible(0);
        }
		//iframe
//    	CofigIframe();
    	//------------------------------------------------>
    	//setInquiryDisableButton 
   		setInquiryDisableButton();
     	//------------------------------------------------>
        // set init-data
		if(document.form.bkg_no.value != ''){
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH) ;
		}
		initControl();
    }
	function initControl() {
        //add listener
		//axon_event.addListenerForm('focus', 'form1_focus', document.form);
        axon_event.addListenerForm('blur', 'form1_blur', document.form);
        //axon_event.addListenerForm('keypress', 'form1_keypress', document.form);		
        axon_event.addListenerForm('change', 'form1_change', document.form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');  
		applyShortcut();
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
	              var HeadTitle1="Seq.|HBL|Container|Container|C/M|Cfm";
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"hbl_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_flag",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"mf_cfm_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"wgt_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"meas_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	               
	              InitColumns(cols);
	              SetSheetHeight(152);
//	              resizeSheet();
	              SetEditable(0);
                    }


            break;
            case 2:      //sheet2 init
                with(sheetObj){
              var HeadTitle1="|Sel.|Seq.|BkgNo|MF Seq.|CntrNo|MF No|Package|Package|Package|Weight|Measure|Marks|Marks|Description|HTS Code|HTS Code|NCM Code|NCM Code|BB";
              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"sel",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"PCKPop",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_wgt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"meas_qty",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_mk_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Popup",     Hidden:0, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"MDPop",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_gds_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"hamo_trf_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"HTCPop",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ncm_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"NCMPop",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bb_cgo_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"wgt_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"meas_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
               
              InitColumns(cols);
              SetSheetHeight(152);
//              resizeSheet();
              SetEditable(1);
              SetShowButtonImage(2);
              SetAutoRowHeight(0);
              }


            break;
            case 3:      //sheet3 init
                with(sheetObj){

              (35, 0, 0, true);
              var HeadTitle1="|Seq.|BKG_NO|HBL_SEQ|HBL_NO|CNTR_MF_NO|ORG_CNTR_MF_NO|BL_MK_DESC|BL_MK_DESC|PCK_QTY|PCK_TP_CD|HBL_WGT|WGT_UT_CD|CMDT_MEAS_QTY|CMDT_MEAS_UT_CD|HBL_MF_TP_CD|IDA_IEC_NO|SHPR_NM|SHPR_ADDR|SHPR_CTY_NM|SHPR_STE_CD|SHPR_CNT_CD|SHPR_ZIP_CD|CNEE_NM|CNEE_ADDR|CNEE_CTY_NM|CNEE_STE_CD|CNEE_CNT_CD|CNEE_ZIP_CD|NOTI_NM|NOTI_ADDR|NOTI_CTY_NM|NOTI_STE_CD|NOTI_CNT_CD|NOTI_ZIP_CD";

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"Seq",       Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"hbl_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"hbl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"org_cntr_mf_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bl_mk_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bl_gds_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pck_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"hbl_wgt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_meas_qty",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_meas_ut_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"hbl_mf_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ida_iec_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"shpr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"shpr_addr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"shpr_cty_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"shpr_ste_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"shpr_cnt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"shpr_zip_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cnee_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cnee_addr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cnee_cty_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cnee_ste_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cnee_cnt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cnee_zip_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"noti_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"noti_addr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"noti_cty_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"noti_ste_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"noti_cnt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"noti_zip_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
               
              InitColumns(cols);
              sheetObj.SetVisible(false);
              SetEditable(1);
              SetAutoRowHeight(0);
              }


            break;
        }
    }
    
    function resizeSheet(){
    	ComResizeSheet(sheetObjects[0],75);
    	ComResizeSheet(sheetObjects[1],75);
   }
	// handling of Sheet 
	function doActionIBSheet(sheetObj,formObj,sAction) {
	//	sheetObj.ShowDebugMsg = 1;
		switch(sAction) {
			case IBSEARCH:      //search
				if(validateForm(sheetObj,formObj,sAction)){
				try {
					ComOpenWait(true); 
					formObj.f_cmd.value=SEARCH;
					var rXml=sheetObj.GetSearchData("ESM_BKG_0366GS.do", FormQueryString(formObj));
					if(rXml == '' || rXml.length < 7) return false;
					if(rXml.substring(1, 6) == "ERROR"){
						//alert(ComResultMessage(rXml).split('<||>').join('\n'));
						ComShowMessage(ComResultMessage(rXml));
						return false;
					}
                    var arrXml=rXml.split("|$$|");
                    if(arrXml.length==3){
						var hblXml=arrXml[0];
						var cntrXml=arrXml[1];
						var cmXml=arrXml[2];
						// Container Info
						sheetObjects[0].LoadSearchData(cntrXml,{Sync:1} );
						// Cntr MF Info
						sheetObjects[1].LoadSearchData(cmXml,{Sync:1} );
						// hbl Info
						sheetObjects[2].LoadSearchData(hblXml,{Sync:1} );
						// booking info
						ComEtcDataToForm(formObj, sheetObjects[2], "");
						//
						if(sheetObjects[2].GetTotalRows()> 0){
							//
							changeComboDataByHbl();
							// change View Data
							changeViewDataByHbl(sheetObjects[2].GetCellValue(1, "hbl_seq"));
							//calculatePackage
							calculatePackage();
						}else{
							//formObj.hbl_seq.value = '0';
							doActionIBSheet(sheetObjects[2], formObj, IBINSERT);		
						}
						// recording midification
						formObj.dirty_flag.value='N';
						// ca controll
						//alert("1. " +(parent.outerFrame != undefined)+ ", 2. " + (parent.outerFrame != "undefined") + ", 3. " + (typeof(parent.outerFrame) == "object"));
						if(parent.t12frame != undefined && typeof(parent.t12frame) == "object") {
							parent.initCAControl(formObj.bkg_no.value, formObj.corr_flg.value, formObj.bdr_flg.value, formObj.ca_exist_flg.value, formObj.bl_no.value);  
						}
//						if ("W"==formObj.bl_tp_cd.value) {
//							formObj.bl_no.value += "W";
//						} else if ("Y"==formObj.obl_iss_flg.value) {
//							formObj.bl_no.value += "S";
//						}
					}else{
						return false;
					}
				}finally{
					ComOpenWait(false);
				}
				}else{
					return false;
				}
			break;
			case IBSAVE:       
				if(document.form.isInquiry.value == "Y") return;
				if(validateForm(sheetObj,formObj,sAction)){
				try {
					ComOpenWait(true); 
					formObj.f_cmd.value=MULTI;
					// form param
					var sParam=FormQueryString(formObj);
					// Sheet2 param
					var sParamSheet1=sheetObjects[1].GetSaveString();
					if (sParamSheet1 != "") {
						sParam=sParam + "&sheet2_" + sParamSheet1.replace(/&/g, '&sheet2_');
					}
					// Sheet3 param
					var sParamSheet2=sheetObjects[2].GetSaveString();
					if (sParamSheet2 != "") {
						sParam=sParam + "&sheet3_" + sParamSheet2.replace(/&/g, '&sheet3_');
					}
					// return xML
					var rXml=sheetObj.GetSaveData("ESM_BKG_0366GS.do", sParam);
					var rMsg=ComResultMessage(rXml);
					if(rMsg == ''){
						// roll back Transaction 
						sheetObjects[1].LoadSaveData("<RESULT><TR-ALL>OK</TR-ALL><MESSAGE/></RESULT>");
						sheetObjects[2].LoadSaveData("<RESULT><TR-ALL>OK</TR-ALL><MESSAGE/></RESULT>");
						// success message
						//ComShowMessage(ComGetMsg("BKG00166"));
					} else {
						//alert(rMsg.split('<||>').join('\n'));
						ComShowMessage(rMsg);
						return false
					}
					// recording modification
					formObj.dirty_flag.value='N';
				}finally{
					ComOpenWait(false);
				}
				}else{
					return false;
				}
			break;
			case IBINSERT:
				if(validateForm(sheetObj,formObj,sAction)){
					var nrow=sheetObj.DataInsert(-1);
					var maxSeq=ComGetMaxValue(sheetObj, "hbl_seq");
					sheetObj.SetCellValue(nrow, "bkg_no",formObj.bkg_no.value,0);
					sheetObj.SetCellValue(nrow, "hbl_seq",maxSeq + 1,0);
					sheetObj.SetCellValue(nrow, "org_cntr_mf_no",formObj.org_cntr_mf_no.value,0);
					sheetObj.SetCellValue(nrow, "wgt_ut_cd",formObj.default_wgt_ut_cd.value,0);
					sheetObj.SetCellValue(nrow, "cmdt_meas_ut_cd",formObj.default_meas_ut_cd.value,0);
					// change Combo Data
					changeComboDataByHbl();			
					// change View Data
					changeViewDataByHbl(maxSeq + 1);
					//calculatePackage
					calculatePackage();
					// recording modification
					formObj.dirty_flag.value='Y';
				}else{
					return false;
				}
			break;
			case IBDELETE:
				if(validateForm(sheetObj,formObj,sAction)){
					// check Hbl Seq
					var hbl_seq=formObj.hbl_seq.options[formObj.hbl_seq.selectedIndex].value;
					//alert("hbl_seq -> "+hbl_seq)
					if(hbl_seq == undefined || hbl_seq == '') return false;
					// delete grid
					var seqArr=ComGetColumnData(sheetObj, "hbl_seq");
					var idxArr=ComFindText(sheetObj, "hbl_seq", hbl_seq);
					//alert(hbl_seq + "\n"+ seqArr +"\n"+ idxArr);
					sheetObj.SetRowHidden(idxArr[0],1);
					sheetObj.SetRowStatus(idxArr[0],'D');
					// change Combo Data
					changeComboDataByHbl();
					// change View Data
					if(seqArr.length > 0){
						var currIdx=-1;
						for(rn=0; rn < seqArr.length; rn++){
							//alert(hbl_seq +"="+ seqArr[rn]);
							if(hbl_seq == seqArr[rn]){
								currIdx=rn;
								break;
							}
						}
						//alert("currIdx : " + currIdx + " : " + (seqArr.length-1));
						if(currIdx < 0){
							changeViewDataByHbl(0);
						}else if(currIdx == (seqArr.length-1)){
							changeViewDataByHbl(seqArr[currIdx-1]);
						}else{
							changeViewDataByHbl(seqArr[currIdx+1]);
						}
					}
					//calculatePackage
					calculatePackage();
					// recording modification
					formObj.dirty_flag.value='Y';
				}else{
					return false;
				}
			break;
			case IBCOPYROW:
				if(sheetObj.RowCount()> 0 && sheetObj.GetSelectRow()> 0 && sheetObj.GetRowHidden(sheetObj.GetSelectRow())==false) {
					// quantity
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), "pck_qty",formObj.bkg_pck_qty.value,0);
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), "pck_tp_cd",formObj.bkg_pck_unit.value,0);
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cntr_mf_wgt",formObj.bkg_wgt_qty.value,0);
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), "wgt_ut_cd",formObj.bkg_wgt_unit.value,0);
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), "meas_qty",formObj.bkg_meas_qty.value,0);
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), "meas_ut_cd",formObj.bkg_meas_unit.value,0);
					// description
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cntr_mf_mk_desc",formObj.bkg_mk_desc.value,0);
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cntr_mf_gds_desc",formObj.bkg_cstms_desc.value,0);
					/* recording modification */
					formObj.dirty_flag.value='Y';
				}
			break;
			case MULTI01:
				if(validateForm(sheetObj,formObj,sAction)){
				try {
					ComOpenWait(true); 
					formObj.f_cmd.value=MULTI01;
					// return xML
					var rXml=sheetObj.GetSaveData("ESM_BKG_0366GS.do", FormQueryString(formObj));
					var rMsg=ComResultMessage(rXml);
					if(rMsg == ''){
						var mfNo=ComGetEtcData(rXml, "cntr_mf_no");
						if(mfNo == undefined || mfNo == ''){
							ComShowMessage(ComGetMsg("BKG06012", "Manifest File No."));
							return false
						}
						//alert("mfNo -> "+ mfNo);
						// handling success
						formObj.cntr_mf_no.value=mfNo;
						// set 'cntr_mf_no' 
						var hbl_seq=formObj.hbl_seq.options[formObj.hbl_seq.selectedIndex].value;
						var idxArr=ComFindText(sheetObj, "hbl_seq", hbl_seq);
						//alert("idxArr[0] -> "+ idxArr[0]);
						sheetObj.SetCellValue(idxArr[0], "cntr_mf_no",mfNo,0);
						// disable Assign. button
						ComBtnDisable("btn_amsFileNoAssign");
						//
						if(sheetObjects[0].RowCount()== 1){
							//
							var bkg_no=formObj.bkg_no.value;
							var cntr_no=sheetObjects[0].GetCellValue(1, "cntr_no");
							var pck_qty=formObj.pck_qty.value;
							var pck_tp_cd=formObj.pck_tp_cd.value;
							var cntr_mf_wgt=formObj.hbl_wgt.value;
							var meas_qty=formObj.cmdt_meas_qty.value;
							var wgt_ut_cd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "wgt_ut_cd");
							var meas_ut_cd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "meas_ut_cd");
							//alert("bkg_no="+bkg_no+", cntr_no="+cntr_no+", mfNo="+mfNo);
							var nrow=sheetObjects[1].DataInsert(-1);
							sheetObjects[1].SetCellValue(nrow, "bkg_no",bkg_no,0);
							sheetObjects[1].SetCellValue(nrow, "cntr_no",cntr_no,0);
							sheetObjects[1].SetCellValue(nrow, "cntr_mf_no",mfNo,0);
							sheetObjects[1].SetCellValue(nrow, "pck_qty",pck_qty,0);
							sheetObjects[1].SetCellValue(nrow, "pck_tp_cd",pck_tp_cd,0);
							sheetObjects[1].SetCellValue(nrow, "cntr_mf_wgt",cntr_mf_wgt,0);
							sheetObjects[1].SetCellValue(nrow, "meas_qty",meas_qty,0);
							sheetObjects[1].SetCellValue(nrow, "wgt_ut_cd",wgt_ut_cd,0);
							sheetObjects[1].SetCellValue(nrow, "meas_ut_cd",meas_ut_cd,0);
							// Set Seq
							var rseq=0;							
							var cm_cnt=sheetObjects[1].RowCount();
							for(rn=1; rn <= cm_cnt; rn++){
								if(sheetObjects[1].GetRowStatus(rn) != 'D' &&
										sheetObjects[1].GetCellValue(rn, "cntr_no") == cntr_no &&
										sheetObjects[1].GetCellValue(rn, "cntr_mf_no") == mfNo) {
									rseq++;
								}
							}
							sheetObjects[1].SetCellValue(nrow, "seq",rseq,0);
							// calculatePackage
							calculatePackage();
							// recording modification
							formObj.dirty_flag.value='Y'
						}
					} else {
						//alert(rMsg.split('<||>').join('\n'));
						ComShowMessage(rMsg);
						return false
					}
				}finally{
					ComOpenWait(false);
				}
				}else{
					return false;
				}
			break;
			case COMMAND04:      //searching booking split no  
				if(validateForm(sheetObj,formObj,sAction)) {
				//try {
				//	ComOpenWait(true); 
					sheetObj.SetWaitImageVisible(0);
					ComSetObjValue(formObj.f_cmd, COMMAND03);
					var sXml=sheetObj.GetSearchData("ESM_BKG_0079_01GS.do", FormQueryString(formObj));
					var bkg_split_no_list=ComGetEtcData(sXml, "bkg_split_no_list");
					bkgSplitNoListPop(formObj.bkg_no, bkg_split_no_list, 15); 
					sheetObj.SetWaitImageVisible(1);
				//}finally{
				//	ComOpenWait(false);
				//}
				}else{
					return false;
				}					
			break;			
		}
		return true;
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSEARCH:      
				// make empty
				ComMakeEmptyForm(formObj, "bkg_no,bl_no,bl_tp_cd,isInquiry");
			break;
			case IBSAVE:       
				if(document.form.isInquiry.value == "Y") return false;
				/*
				1. showing message [BKG00254] in case of modifying , calling Save in case of Yes
				2. checking BKG status  -  return after showing message [BKG00433], in case status="X" 
				3. checking BDR and CA  - return after showing message  [BKG00004] ,in case of BDR="Y", CA="N".  
				5. HB/L each  Mandatory Item Check
				5.a Actual Shipper Name/Address, Actual Consignee Name/Address, Package Quantity/Type, Weight Quantity/Type checking validation, if there is no data, return after showing the message [BKG00961] 
				5.b POD or DEL is CA, or if Canada is FROB, Shipper City/Country, Consignee City/Country checking mandatory, if there is no data, showing message [BKG00234], [BKG00236] 
				5.c POD or DEL is CA, or if Canada is FROB, in case of existing Actual Notify, checking mandatory of City/Country ,  if there is no data, showing message [BKG00234], [BKG00236]
				5.d POD or DEL is CA, or if Canada is FROB, if Country is US or CA , checking mandatory of State, ZipCode, if there is no data, showing message[BKG00235] 
				6. Container at  Mandatory Item Check
				6.a checking mandatory of Package Quantity/Type , if there is no data, showing message [BKG00961] 
				6.b if there is not the Description of Goods or HTS code, showing message  [BKG00961] 
				6.c POD is 'US',  DEL is not 'US', if there is not HTS code, showing message  [BKG00961] 
				6.d if POR/POL/POD/DEL is BR ,and  if there is not NCM code, showing message [BKG00961]
				*/
				with(formObj){
					if(bkg_sts_cd.value == 'X'){
						ComShowMessage(ComGetMsg("BKG00433"));
						return false;
					}
					if(bdr_flg.value == 'Y' && ca_flg.value == 'N'){
						ComShowMessage(ComGetMsg("BKG00004"));
						return false;
					}
					//if(cnd_cstms_file_cd.value != '1' && cnd_cstms_file_cd.value != '1'){
					//	ComShowMessage(ComGetMsg("BKG00960"));
					//	return false;
					//}
				}
				var rcnt=sheetObj.RowCount();
				for(rn=1;rn<=rcnt;rn++){
					if(sheetObj.GetRowStatus(rn) == 'D') continue;
					//shpr_nm shpr_addr cnee_nm cnee_addr pck_qty pck_tp_cd hbl_wgt wgt_ut_cd [BKG00961] return after searching
					if(ComIsEmpty(sheetObj.GetCellValue(rn, "shpr_nm"))){
						ComShowMessage(ComGetMsg("BKG00961", "Shipper Name [H.B/L Seq." + rn + "]"));
						return false;
					}
					if(ComIsEmpty(sheetObj.GetCellValue(rn, "shpr_addr"))){
						ComShowMessage(ComGetMsg("BKG00961", "Shipper Address [H.B/L Seq." + rn + "]"));
						return false;
					}
					if(ComIsEmpty(sheetObj.GetCellValue(rn, "cnee_nm"))){
						ComShowMessage(ComGetMsg("BKG00961", "Consignee Name [H.B/L Seq." + rn + "]"));
						return false;
					}
					if(ComIsEmpty(sheetObj.GetCellValue(rn, "cnee_addr"))){
						ComShowMessage(ComGetMsg("BKG00961", "Consignee Address [H.B/L Seq." + rn + "]"));
						return false;
					}
					if(ComIsNull(sheetObj.GetCellValue(rn, "pck_qty")) || sheetObj.GetCellValue(rn, "pck_qty") == '0'){
						ComShowMessage(ComGetMsg("BKG00961", "Package Quantity [H.B/L Seq." + rn + "]"));
						return false;
					}
					if(ComIsEmpty(sheetObj.GetCellValue(rn, "pck_tp_cd"))){
						ComShowMessage(ComGetMsg("BKG00961", "Package Type [H.B/L Seq." + rn + "]"));
						return false;
					}
					if(ComIsNull(sheetObj.GetCellValue(rn, "hbl_wgt")) || sheetObj.GetCellValue(rn, "hbl_wgt") == '0'){
						ComShowMessage(ComGetMsg("BKG00961", "Weight [H.B/L Seq." + rn + "]"));
						return false;
					}
					if(ComIsEmpty(sheetObj.GetCellValue(rn, "wgt_ut_cd"))){
						ComShowMessage(ComGetMsg("BKG00961", "Weight Unit [H.B/L Seq." + rn + "]"));
						return false;
					}			
				}
				var por_cnty=(formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty=(formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty=(formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty=(formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg=formObj.cnd_flg.value;
				//alert("* pod_cnty=" +pod_cnty+ ", del_cnty=" +del_cnty+ ", cnd_flg=" + cnd_flg);
				if(pod_cnty == 'CA' || del_cnty == 'CA'){
					for(rn=1;rn<=rcnt;rn++){
						if(sheetObj.GetRowStatus(rn) == 'D') continue;
						// if POD or DEL is CA, or if Canada is FROB
						if(cnd_flg == 'Y'){
							if(ComIsEmpty(sheetObj.GetCellValue(rn, "shpr_cty_nm"))){
								
								ComShowMessage(ComGetMsg("BKG00234", "Shipper City Name [H.B/L Seq." + rn + "]"));
								return false;
							}
							if(ComIsEmpty(sheetObj.GetCellValue(rn, "shpr_cnt_cd"))){
								ComShowMessage(ComGetMsg("BKG00236", "Shipper Country [H.B/L Seq." + rn + "]"));
								return false;
							}
							if(ComIsEmpty(sheetObj.GetCellValue(rn, "cnee_cty_nm"))){
								ComShowMessage(ComGetMsg("BKG00234", "Consignee City Name [H.B/L Seq." + rn + "]"));
								return false;
							}
							if(ComIsEmpty(sheetObj.GetCellValue(rn, "cnee_cnt_cd"))){
								ComShowMessage(ComGetMsg("BKG00236", "Consignee Country [H.B/L Seq." + rn + "]"));
								return false;
							}
							if(sheetObj.GetCellValue(rn, "shpr_cnt_cd") == "CA" || sheetObj.GetCellValue(rn, "shpr_cnt_cd") == "US"){
								if(ComIsEmpty(sheetObj.GetCellValue(rn, "shpr_ste_cd"))){
									ComShowMessage(ComGetMsg("BKG00235", "Shipper State [H.B/L Seq." + rn + "]"));
									return false;
								}
								if(ComIsEmpty(sheetObj.GetCellValue(rn, "shpr_zip_cd"))){
									ComShowMessage(ComGetMsg("BKG08238", "Shipper Zip Code [H.B/L Seq." + rn + "]"));
									return false;
								}
							}
							if(sheetObj.GetCellValue(rn, "cnee_cnt_cd") == "CA" || sheetObj.GetCellValue(rn, "cnee_cnt_cd") == "US"){
								if(ComIsEmpty(sheetObj.GetCellValue(rn, "cnee_ste_cd"))){
									ComShowMessage(ComGetMsg("BKG00235", "Consignee State [H.B/L Seq." + rn + "]"));
									return false;
								}
								if(ComIsEmpty(sheetObj.GetCellValue(rn, "cnee_zip_cd"))){
									ComShowMessage(ComGetMsg("BKG08238", "Consignee Zip Code [H.B/L Seq." + rn + "]"));
									return false;
								}
							}
							if(!ComIsEmpty(sheetObj.GetCellValue(rn, "noti_nm")) || !ComIsEmpty(sheetObj.GetCellValue(rn, "noti_addr"))){
								if(ComIsEmpty(sheetObj.GetCellValue(rn, "noti_cty_nm"))){
									ComShowMessage(ComGetMsg("BKG00234", "Notify City Name [H.B/L Seq." + rn + "]"));
									return false;
								}
								if(ComIsEmpty(sheetObj.GetCellValue(rn, "noti_cnt_cd"))){
									ComShowMessage(ComGetMsg("BKG00236", "Notify Country [H.B/L Seq." + rn + "]"));
									return false;
								}
								if(sheetObj.GetCellValue(rn, "noti_cnt_cd") == "CA" || sheetObj.GetCellValue(rn, "noti_cnt_cd") == "US"){
									if(ComIsEmpty(sheetObj.GetCellValue(rn, "noti_ste_cd"))){
										ComShowMessage(ComGetMsg("BKG00235", "Notify State [H.B/L Seq." + rn + "]"));
										return false;
									}
									if(ComIsEmpty(sheetObj.GetCellValue(rn, "noti_zip_cd"))){
										ComShowMessage(ComGetMsg("BKG08238", "Notify Zip Code [H.B/L Seq." + rn + "]"));
										return false;
									}
								}								
							}							
						}
					}
				}
				var xcnt=sheetObjects[1].RowCount();

				var cntr_no = "";
				var cntr_mf_no = "";
				var seq="";
				for(xn=1;xn<=xcnt;xn++){
					if(sheetObjects[1].GetRowStatus(xn) == 'D') continue;
					cntr_no = sheetObjects[1].GetCellValue(xn, "cntr_no");
					cntr_mf_no = sheetObjects[1].GetCellValue(xn, "cntr_mf_no");
					seq = sheetObjects[1].GetCellValue(xn, "seq");
					
					if(ComIsNull(sheetObjects[1].GetCellValue(xn, "pck_qty"))){
//						ComShowMessage(ComGetMsg("BKG00961", "Package Quantity [CM]"));
						ComShowMessage(ComGetMsg("BKG03035", "Package Quantity of cargo details.\n\nManifest File No : "+cntr_mf_no+"\nContainer No : "+cntr_no));
						return false;
					}
					if(sheetObjects[1].GetCellValue(xn, "bb_cgo_flg") != 'Y' && sheetObjects[1].GetCellValue(xn, "pck_qty") == '0'){
//						ComShowMessage(ComGetMsg("BKG00961", "Package Quantity [CM]"));
						ComShowMessage(ComGetMsg("BKG03035", "Package Quantity of cargo details.\n\nManifest File No : "+cntr_mf_no+"\nContainer No : "+cntr_no));
						return false;
					}					
					if(ComIsEmpty(sheetObjects[1].GetCellValue(xn, "pck_tp_cd"))){
//						ComShowMessage(ComGetMsg("BKG00961", "Package Type [CM]"));
						ComShowMessage(ComGetMsg("BKG03035", "Package Type of cargo details.\n\nManifest File No : "+cntr_mf_no+"\nContainer No : "+cntr_no));
						return false;
					}
					if(sheetObjects[1].GetCellValue(xn, "wgt_ut_cd") == '') {
						ComShowCodeMessage("BKG08179","Weight Unit Code");
						return false;
					}
					if(sheetObjects[1].GetCellValue(xn, "meas_ut_cd") == '') {
						ComShowCodeMessage("BKG08179","Measure Unit Code");
						return false;
					}
//					if(ComIsEmpty(sheetObjects[1].GetCellValue(xn, "cntr_mf_gds_desc")) && ComIsEmpty(sheetObjects[1].GetCellValue(xn, "hamo_trf_cd"))){
//						ComShowMessage(ComGetMsg("BKG00961", "Mark & Description [CM]"));
					if(ComIsEmpty(sheetObjects[1].GetCellValue(xn, "cntr_mf_gds_desc"))){
//						ComShowMessage(ComGetMsg("BKG00961", "Description [CM]"));
						ComShowMessage(ComGetMsg("BKG03035", "Description of cargo details.\n\nManifest File No : "+cntr_mf_no+"\nContainer No : "+cntr_no));
						return false;
					}
					if(formObj.hts_flg.value == 'Y' && sheetObjects[1].GetCellValue(xn, "hamo_trf_cd") == ''){
//						var cntr_mf_no=sheetObjects[1].GetCellValue(xn, "cntr_mf_no");
	//					var idxArr=ComFindText(sheetObjects[2], "cntr_mf_no", cntr_mf_no);
	//					var hbl_seq=sheetObjects[2].GetCellValue(idxArr[0], "hbl_seq");
//						ComShowMessage(ComGetMsg("BKG00961", "HTS Code [H.B/L Seq. "+hbl_seq+"]"));
						ComShowMessage(ComGetMsg("BKG03035", "HTS Code of cargo details.\n\nManifest File No : "+cntr_mf_no+"\nContainer No : "+cntr_no));
						return false;
					}					
					if(sheetObjects[1].GetCellValue(xn, "hamo_trf_cd") != '' && (sheetObjects[1].GetCellValue(xn, "hamo_trf_cd").length < 6 || sheetObjects[1].GetCellValue(xn, "hamo_trf_cd").length > 10)) {
//						var cntr_mf_no=sheetObjects[1].GetCellValue(xn, "cntr_mf_no");
	//					var idxArr=ComFindText(sheetObjects[2], "cntr_mf_no", cntr_mf_no);
	//					var hbl_seq=sheetObjects[2].GetCellValue(idxArr[0], "hbl_seq");
//						ComShowMessage(ComGetMsg("BKG06065", "HTS Code [H.B/L Seq. "+hbl_seq+"]"));
//						ComShowMessage(ComGetMsg("BKG06065", "HTS Code [H.B/L Seq. "+hbl_seq+"]"));
						ComShowMessage(ComGetMsg("BKG95001", "check the length of HTS Code.\n\nManifest File No : "+cntr_mf_no+"\nContainer No : "+cntr_no));
						return false;
					}
					if((por_cnty == 'BR' || pol_cnty == 'BR' || pod_cnty == 'BR' || del_cnty == 'BR') && ComIsEmpty(sheetObjects[1].GetCellValue(xn, "ncm_no"))){
//						var cntr_mf_no=sheetObjects[1].GetCellValue(xn, "cntr_mf_no");
	//					var idxArr=ComFindText(sheetObjects[2], "cntr_mf_no", cntr_mf_no);
	//					var hbl_seq=sheetObjects[2].GetCellValue(idxArr[0], "hbl_seq");
//						ComShowMessage(ComGetMsg("BKG00961", "NCM Code [H.B/L Seq. "+hbl_seq+"]"));
						ComShowMessage(ComGetMsg("BKG03035", "NCM Code of cargo details.\n\nManifest File No : "+cntr_mf_no+"\nContainer No : "+cntr_no));
						return false;
					}
						if(sheetObjects[1].GetCellValue(xn, "ncm_no") != '' && (sheetObjects[1].GetCellValue(xn, "ncm_no").length < 4 || sheetObjects[1].GetCellValue(xn, "ncm_no").length > 8)) {
//							var cntr_mf_no=sheetObjects[1].GetCellValue(xn, "cntr_mf_no");
	//					var idxArr=ComFindText(sheetObjects[2], "cntr_mf_no", cntr_mf_no);
	//					var hbl_seq=sheetObjects[2].GetCellValue(idxArr[0], "hbl_seq");
//						ComShowMessage(ComGetMsg("BKG06065", "NCM Code [H.B/L Seq. "+hbl_seq+"]"));
//						ComShowMessage(ComGetMsg("BKG06065", "NCM Code [H.B/L Seq. "+hbl_seq+"]"));
						ComShowMessage(ComGetMsg("BKG95001", "check the length of NCM Code.\n\nManifest File No : "+cntr_mf_no+"\nContainer No : "+cntr_no));
						return false;
					}
				}
				
				//Special character check....
				var strRmk = "";
				for(xn=1;xn<=xcnt;xn++){
					strRmk = sheetObjects[1].GetCellValue(xn, "cntr_mf_mk_desc");
					sheetObjects[1].SetCellValue(xn, "cntr_mf_mk_desc", chekcSpecialValue(strRmk), 0);
					strRmk = sheetObjects[1].GetCellValue(xn, "cntr_mf_gds_desc");
					sheetObjects[1].SetCellValue(xn, "cntr_mf_gds_desc", chekcSpecialValue(strRmk), 0);
				}
			break;
			case IBINSERT:
				if(sheetObjects[0].GetSelectRow()< 1 && sheetObjects[0].GetSelectRow() != -1){   
					ComShowMessage(ComGetMsg("BKG08019"));
					return false;
				}
				if(document.form.dirty_flag.value == 'Y'){
					if(confirm(ComGetMsg("BKG00962"))){
						var rflag=doActionIBSheet(sheetObjects[2], document.form, IBSAVE);
						return rflag;
					}else{
						return false;
					}
				}				
			break;
			case IBDELETE:
				// check empty
				if(formObj.hbl_seq.selectedIndex < 0){
					ComShowMessage(ComGetMsg("BKG04010 "));
					return false;
				}
				//
				return confirm(ComGetMsg("BKG00535"));
			break;
			case MULTI01:
				var hbl_seq=document.form.hbl_seq.options[document.form.hbl_seq.selectedIndex].value;
				var idx_arr=ComFindText(sheetObj, "hbl_seq", hbl_seq);
				var sts_cd=sheetObj.GetRowStatus(idx_arr[0]);
				if(sts_cd == 'I'){
					ComShowMessage(ComGetMsg("BKG00178"));
					return false;
				}
			break;
			case COMMAND04: 
				with (formObj) {
					if(ComIsEmpty(bkg_no.value)){
						ComShowMessage(ComGetMsg("BKG00463"));
						bkg_no.focus();
						return false;
					}
				}
			break;				
		}
        return true;
    }
	/* --------------------------------------------------------------------
	 * handling Event
	 ---------------------------------------------------------------------- */
	function form1_focus(){
		//ComClearSeparator(event.srcElement);
	}
    function form1_blur(){
		//ComChkObjValid(event.srcElement);
    }
//	function form1_keypress(){
//		if (event.srcElement.type == "text" && event.keyCode == 13 ) {
//   			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
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
//				//Alphabet upper case
//				ComKeyOnlyAlphabet("upper");
//			break;
//			case "engupnum":
//				//number+"Alphabet upper case"
//				ComKeyOnlyAlphabet("uppernum");
//			break;
//			case "engupnumspc":
//				//Alphabet upper case + number + space
//				//ComKeyOnlyAlphabet("uppernum", "32|45|95");
//				var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//				if(keyValue >= 97 && keyValue <= 122){                  //Alphabet lower case
//                	event.keyCode=keyValue + 65 - 97;
//				}
//				//event.returnValue = true;
//			break;
//		}	
//	}
	function form1_change(){
		// Alphabet upper case
		//if(event.srcElement.type =="text" || event.srcElement.type =="textarea") {
		//	event.srcElement.value = event.srcElement.value.toUpperCase();
		//}
        var srcName=ComGetEvent("name");	
        switch(srcName){
            case "hbl_seq":
            	var old_seq=sheetObjects[2].GetCellValue(sheetObjects[2].GetSelectRow(), "hbl_seq");
				var tgt_seq=ComGetEvent("value");
				//alert("* srcName -> " + srcName + ": old_seq=" + old_seq);
				//if(validateChange(old_seq, document.form.cntr_mf_no.value)){
				//	changeViewDataByHbl(event.srcElement.value);
				//}else{
				//	changeViewDataByHbl(old_seq);
				//}
				// check change
/*				
				if(document.form.dirty_flag.value == 'Y'){
					if(confirm(ComGetMsg("BKG00962"))){
						var rflag=doActionIBSheet(sheetObjects[2], document.form, IBSAVE);
						if(rflag){
							//
							changeViewDataByHbl(tgt_seq);
							//
							document.form.dirty_flag.value='N';							
						}else{
							changeViewDataByHbl(old_seq);
						}
					}else{
						//
						rollbackData();
						//
						changeViewDataByHbl(tgt_seq);
						//
						document.form.dirty_flag.value='N';
					}
				}else{
					changeViewDataByHbl(tgt_seq);
				}
*/				
				changeViewDataByHbl(tgt_seq);
				calculatePackage();
            break;
			case "cntr_mf_no":
			case "hbl_no":
			case "ida_iec_no":
			case "hbl_mf_tp_cd":
			case "shpr_nm":
			case "shpr_addr":
			case "shpr_cty_nm":
			case "shpr_ste_cd":
			case "shpr_cnt_cd":
			case "shpr_zip_cd":
			case "cnee_nm":
			case "cnee_addr":
			case "cnee_cty_nm":
			case "cnee_ste_cd":
			case "cnee_cnt_cd":
			case "cnee_zip_cd":
			case "noti_nm":
			case "noti_addr":
			case "noti_cty_nm":
			case "noti_ste_cd":
			case "noti_cnt_cd":
			case "noti_zip_cd":
			case "pck_qty":
			case "pck_tp_cd":
			case "hbl_wgt":
			case "wgt_ut_cd":
			case "cmdt_meas_qty":
			case "cmdt_meas_ut_cd":
			case "bl_mk_desc":
			case "bl_gds_desc":
				if(document.form.hbl_seq.selectedIndex < 0){
					ComShowMessage(ComGetMsg("BKG01105"));
					ComGetEvent("value")='';
					return;
				}				
				var hbl_seq=document.form.hbl_seq.options[document.form.hbl_seq.selectedIndex].value;
				//alert("-> hbl_seq : "+ hbl_seq);
				var idxArr=ComFindText(sheetObjects[2], "hbl_seq", hbl_seq);
				//alert("-> gridIdx : "+ idxArr[0]);
				sheetObjects[2].SetCellValue(idxArr[0], srcName,ComGetEvent("value"),0);
				// recording modification
				document.form.dirty_flag.value='Y';
			break;
        }
        //var srcName = event.srcElement.getAttribute("name");
        switch(srcName){
			case "shpr_cty_nm":
				var formObj=document.form;
				var por_cnty=(formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty=(formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty=(formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty=(formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg=formObj.cnd_flg.value;
				// if POD or  DEL is  CA, or if Canada is FROB
				if((pod_cnty == 'CA' || del_cnty == 'CA') && cnd_flg == 'Y' && ComIsEmpty(formObj.shpr_cty_nm.value)){
					ComShowMessage(ComGetMsg("BKG00234", "SHPR_CTY_NM"));
					formObj.shpr_cty_nm.select();
					return false;
				}
			break;
			case "shpr_ste_cd":
				var formObj=document.form;
				var por_cnty=(formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty=(formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty=(formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty=(formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg=formObj.cnd_flg.value;
				// if POD or  DEL is  CA, or if Canada is FROB
				if((pod_cnty == 'CA' || del_cnty == 'CA') && cnd_flg == 'Y'){
					if((formObj.shpr_cnt_cd.value == "CA" || formObj.shpr_cnt_cd.value == "US") && ComIsEmpty(formObj.shpr_ste_cd.value)){
						ComShowMessage(ComGetMsg("BKG00235", "SHPR_STE_CD"));
						formObj.shpr_ste_cd.select();
						return false;
					}
				}
			break;
			case "shpr_cnt_cd":
				var formObj=document.form;
				var por_cnty=(formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty=(formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty=(formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty=(formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg=formObj.cnd_flg.value;
				// if POD or  DEL is  CA, or if Canada is FROB
				if((pod_cnty == 'CA' || del_cnty == 'CA') && cnd_flg == 'Y' && ComIsEmpty(formObj.shpr_cnt_cd.value)){
//					alert("pod_cnty=" + pod_cnty + ", del_cnty=" + del_cnty + ", cnd_flg=" + cnd_flg + ", shpr_cnt_cd=" + formObj.shpr_cnt_cd.value);
					ComShowMessage(ComGetMsg("BKG00234", "SHPR_CNT_CD"));
					formObj.shpr_cnt_cd.select();
					return false;
				}
			break;
			case "shpr_zip_cd":
				var formObj=document.form;
				var por_cnty=(formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty=(formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty=(formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty=(formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg=formObj.cnd_flg.value;
				// if POD or  DEL is  CA, or if Canada is FROB
				if((pod_cnty == 'CA' || del_cnty == 'CA') && cnd_flg == 'Y'){
					if((formObj.shpr_cnt_cd.value == "CA" || formObj.shpr_cnt_cd.value == "US") && ComIsEmpty(formObj.shpr_zip_cd.value)){
						ComShowMessage(ComGetMsg("BKG08238", "SHPR_ZIP_CD"));
						formObj.shpr_zip_cd.select();
						return false;
					}
				}			
			break;
			case "cnee_cty_nm":
				var formObj=document.form;
				var por_cnty=(formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty=(formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty=(formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty=(formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg=formObj.cnd_flg.value;
				// if POD or  DEL is  CA, or if Canada is FROB
				if((pod_cnty == 'CA' || del_cnty == 'CA') && cnd_flg == 'Y'){
					if(ComIsEmpty(formObj.cnee_cty_nm.value)){
						ComShowMessage(ComGetMsg("BKG00234", "CNEE_CTY_NM"));
						formObj.cnee_cty_nm.select();
						return false;
					}
				}
			break;
			case "cnee_ste_cd":
				var formObj=document.form;
				var por_cnty=(formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty=(formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty=(formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty=(formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg=formObj.cnd_flg.value;
				// if POD or  DEL is  CA, or if Canada is FROB
				if((pod_cnty == 'CA' || del_cnty == 'CA') && cnd_flg == 'Y'){
					if((formObj.cnee_cnt_cd.value == "CA" || formObj.cnee_cnt_cd.value == "US") && ComIsEmpty(formObj.cnee_ste_cd.value)){
						ComShowMessage(ComGetMsg("BKG00235", "CNEE_STE_CD"));
						formObj.cnee_ste_cd.select();
						return false;
					}
				}
			break;
			case "cnee_cnt_cd":
				var formObj=document.form;
				var por_cnty=(formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty=(formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty=(formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty=(formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg=formObj.cnd_flg.value;
				// if POD or  DEL is  CA, or if Canada is FROB
				if((pod_cnty == 'CA' || del_cnty == 'CA') && cnd_flg == 'Y'){
					if(ComIsEmpty(formObj.cnee_cnt_cd.value)){
						ComShowMessage(ComGetMsg("BKG00236", "CNEE_CNT_CD"));
						formObj.cnee_cnt_cd.select();
						return false;
					}
				}
			break;
			case "cnee_zip_cd":
				var formObj=document.form;
				var por_cnty=(formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty=(formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty=(formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty=(formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg=formObj.cnd_flg.value;
				// if POD or  DEL is  CA, or if Canada is FROB
				if((pod_cnty == 'CA' || del_cnty == 'CA') && cnd_flg == 'Y'){
					if((formObj.cnee_cnt_cd.value == "CA" || formObj.cnee_cnt_cd.value == "US") && ComIsEmpty(formObj.cnee_zip_cd.value)){
						ComShowMessage(ComGetMsg("BKG08238", "CNEE_ZIP_CD"));
						formObj.cnee_zip_cd.select();
						return false;
					}
				}
			break;
			case "noti_cty_nm":
				var formObj=document.form;
				var por_cnty=(formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty=(formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty=(formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty=(formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg=formObj.cnd_flg.value;
				// if POD or  DEL is  CA, or if Canada is FROB
				if((pod_cnty == 'CA' || del_cnty == 'CA') && cnd_flg == 'Y'){
					if(!ComIsEmpty(formObj.noti_nm.value) || !ComIsEmpty(formObj.noti_addr.value)){
						if(ComIsEmpty(formObj.noti_cty_nm.value)){
							ComShowMessage(ComGetMsg("BKG00234", "NOTI_CTY_NM"));
							formObj.noti_cty_nm.select();
							return false;
						}
					}
				}
			break;
			case "noti_ste_cd":
				var formObj=document.form;
				var por_cnty=(formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty=(formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty=(formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty=(formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg=formObj.cnd_flg.value;
				// if POD or  DEL is  CA, or if Canada is FROB
				if((pod_cnty == 'CA' || del_cnty == 'CA') && cnd_flg == 'Y'){
					if(!ComIsEmpty(formObj.noti_nm.value) || !ComIsEmpty(formObj.noti_addr.value)){
						if(formObj.noti_cnt_cd.value == "CA" || formObj.noti_cnt_cd.value == "US"){
							if(ComIsEmpty(formObj.noti_ste_cd.value)){
								ComShowMessage(ComGetMsg("BKG00235", "NOTI_STE_CD"));
								formObj.noti_ste_cd.select();
								return false;
							}
						}
					}
				}
			break;
			case "noti_cnt_cd":
				var formObj=document.form;
				var por_cnty=(formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty=(formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty=(formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty=(formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg=formObj.cnd_flg.value;
				// if POD or  DEL is  CA, or if Canada is FROB
				if((pod_cnty == 'CA' || del_cnty == 'CA') && cnd_flg == 'Y'){
					if(!ComIsEmpty(formObj.noti_nm.value) || !ComIsEmpty(formObj.noti_addr.value)){
						if(ComIsEmpty(formObj.noti_cnt_cd.value)){
							ComShowMessage(ComGetMsg("BKG00236", "NOTI_CNT_CD"));
							formObj.noti_cnt_cd.select();
							return false;
						}
					}
				}
			break;			
			case "noti_zip_cd":
				var formObj=document.form;
				var por_cnty=(formObj.por_cd.value != '' && formObj.por_cd.value.length > 2) ? formObj.por_cd.value.substring(0, 2) : '';
				var pol_cnty=(formObj.pol_cd.value != '' && formObj.pol_cd.value.length > 2) ? formObj.pol_cd.value.substring(0, 2) : '';
				var pod_cnty=(formObj.pod_cd.value != '' && formObj.pod_cd.value.length > 2) ? formObj.pod_cd.value.substring(0, 2) : '';
				var del_cnty=(formObj.del_cd.value != '' && formObj.del_cd.value.length > 2) ? formObj.del_cd.value.substring(0, 2) : '';
				var cnd_flg=formObj.cnd_flg.value;
				// if POD or  DEL is  CA, or if Canada is FROB
				if((pod_cnty == 'CA' || del_cnty == 'CA') && cnd_flg == 'Y'){
					if(!ComIsEmpty(formObj.noti_nm.value) || !ComIsEmpty(formObj.noti_addr.value)){
						if(formObj.noti_cnt_cd.value == "CA" || formObj.noti_cnt_cd.value == "US"){
							if(ComIsEmpty(formObj.noti_zip_cd.value)){
								ComShowMessage(ComGetMsg("BKG08238", "NOTI_ZIP_CD"));
								formObj.noti_zip_cd.select();
								return false;
							}
						}
					}
				}
			break;
        }		
    }
	function sheet1_OnClick(sheetObj, row, col, val){
//		var col_name=sheetObj.ColSaveName(col);
//		switch(col_name) {
//			case "cntr_no":
				var hbl_seq=document.form.hbl_seq.options[document.form.hbl_seq.selectedIndex].value;
				var idxArr=ComFindText(sheetObjects[2], "hbl_seq", hbl_seq);
				var cntr_mf_no=sheetObjects[2].GetCellValue(idxArr[0], "cntr_mf_no");
				var cntr_no = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "cntr_no");
				//showAndHideCM
//				showAndHideCM(val, cntr_mf_no);
				showAndHideCM(cntr_no, cntr_mf_no);
				//calculatePackage
				calculatePackage();
//			break;
//		}
	}
	function sheet2_OnChange(sheetObj, row, col, val){
		// checking modification of data
		document.form.dirty_flag.value='Y'
		/* alphabet upper case */
		var data_type=sheetObj.GetCellProperty(row, col, "Type");
		if(data_type == "Text") {
			sheetObj.SetCellValue(row, col,sheetObj.GetCellValue(row, col).toUpperCase(),0);
		}
		//
		var col_name=sheetObj.ColSaveName(col);
		switch(col_name) {
			case "pck_qty":
				calculatePackage();
			break;
			case "cntr_mf_wgt":
				calculatePackage();
			break;
			case "meas_qty":
				calculatePackage();
			break;
		}
	}
	function sheet2_OnPopupClick(sheetObj, row, col){
		var col_name=sheetObj.ColSaveName(col);
		switch(col_name) {
			case "PCKPop":
				comBkgCallPop0696("callbackPckTp2", sheetObj.GetCellValue(row, "pck_tp_cd"));
			break;
			case "MDPop":
			   var frm=document.form2;
	           var param="?pgmNo=ESM_BKG_0706";
	           ComOpenPopup("ESM_BKG_0706.do"+param, 450,450, "callbackMFDesc", "1,0,1,1,1", true);
			break;
			case "HTCPop":
	           var param="?pgmNo=ESM_BKG_0607&hamo_tp_cd=T"+"&hamo_trf_cd="+sheetObj.GetCellValue(row, "hamo_trf_cd");
	           ComOpenPopup("ESM_BKG_0607_POP.do"+param, 1010,590, "callbackHTSCode", "1,0,1,1,1", true);
			break;
			case "NCMPop":
				// except in case BKG Commodity is F.A.K/Console/Mixed Cargo, calling  Pop-Up(ESM_BKG_0745) by 6 digit of BKG commodity 
//				var sUrl="ESM_BKG_0745_P.do?page_gubun=popup";
//	  			var rtnVal=ComOpenWindowCenter(sUrl, "ESM_BKG_0745_P", 1024, 530, true);
//	  			if (rtnVal != null){
//	  				sheetObj.SetCellValue(row, 'ncm_no',rtnVal.cd,0);
//	  			}
				var sUrl="ESM_BKG_0745_P.do?page_gubun=popup";
				ComOpenPopup(sUrl,1000, 650, "sheet1_SetValues", "1,0", true);  
	  			
			break;
		} // end switch
	}
	
	function sheet2_OnAfterEdit(sheetObj, Row, Col){
		var col_name=sheetObj.ColSaveName(Col);
		var strRmk = "";
		switch(col_name) {
			case "cntr_mf_mk_desc":
				strRmk = sheetObj.GetCellValue(Row, col_name);
				sheetObj.SetCellValue(Row, col_name, chekcSpecialValue(strRmk), 0);
			break;
			case "cntr_mf_gds_desc":
				strRmk = sheetObj.GetCellValue(Row, col_name);
				sheetObj.SetCellValue(Row, col_name, chekcSpecialValue(strRmk), 0);
			break;
		}
	}	
	
	
	function sheet1_SetValues(returnValue){
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow() , 'ncm_no', returnValue.cd);
	}
	/* --------------------------------------------------------------------
	 * Functions
	 ---------------------------------------------------------------------- */
	function changeComboDataByHbl(){
		var sheetObj=sheetObjects[2];
		var comboObj=document.form.hbl_seq;
		var ttlCount=document.form.hbl_ttl_knt;
		// remove all combo-data
		var clen=(comboObj==null) ? 0 : comboObj.length;
		for(ic=0;ic<clen;ic++){
			comboObj.remove(clen-1-ic);
		}
		var tcnt=0;
		var rkey='';
		var rval='';
		var rcnt=sheetObj.RowCount();
		for (ix=1; ix <= rcnt; ix++) {
			if(sheetObj.GetRowStatus(ix) != 'D'){
				rval=sheetObj.GetCellValue(ix, "seq");
				rkey=sheetObj.GetCellValue(ix, "hbl_seq");
				//alert(rval +" / "+ rkey);
				comboObj.add(new Option(rval, rkey));
				tcnt++;
			}
		}
		ttlCount.value=tcnt;
	}
	function changeViewDataByHbl(hbl_seq){	
		// make empty
		//ComMakeEmptyForm(document.form, "dirty_flag,bkg_sts_cd,bdr_flg,ca_flg,cnd_flg,org_cntr_mf_no,bkg_no,bl_no,bl_tp_cd,por_cd,pol_cd,pod_cd,del_cd,usa_cstms_file_cd,cnd_cstms_file_cd,hbl_ttl_knt");
		with (document.form) {
			cntr_mf_no.value='';
			hbl_no.value='';
			ida_iec_no.value='';
			hbl_mf_tp_cd.value='';
			shpr_nm.value='';
			shpr_addr.value='';
			shpr_cty_nm.value='';
			shpr_ste_cd.value='';
			shpr_cnt_cd.value='';
			shpr_zip_cd.value='';
			cnee_nm.value='';    
			cnee_addr.value='';  
			cnee_cty_nm.value='';
			cnee_ste_cd.value='';
			cnee_cnt_cd.value='';
			cnee_zip_cd.value='';
			noti_nm.value='';
			noti_addr.value='';
			noti_cty_nm.value='';
			noti_ste_cd.value='';
			noti_cnt_cd.value='';
			noti_zip_cd.value='';
			bl_mk_desc.value='';
			bl_gds_desc.value='';
			pck_qty.value='';
			pck_tp_cd.value='';
			hbl_wgt.value='';
			wgt_ut_cd.value='';
			cmdt_meas_qty.value='';
			cmdt_meas_ut_cd.value='';
			cm_pck_qty.value='';
			cm_wgt_qty.value='';
			cm_meas_qty.value='';		
			bk_pck_qty.value='';
			bk_pck_qty.value='';
			bk_pck_qty.value='';			
		}
		//
		if(hbl_seq>0){
			var idxArr=ComFindText(sheetObjects[2], "hbl_seq", hbl_seq);
			if(idxArr.length == 0) return; 
			// row number
			var row=idxArr[0];
			// set focus
			sheetObjects[2].SelectCell(row, 2, false);
			// Container Filtering
			//ComShowAndHideSheet(sheetObjects[0], "hbl_seq", sheetObjects[2].CellValue(row, "hbl_seq"));
			//ComRenumberSeq(sheetObjects[0], "seq");
			var cntr_mf_no=sheetObjects[2].GetCellValue(row, "cntr_mf_no");
			var cm_flg=0;
			var xcnt=sheetObjects[0].RowCount();
			for(xn=1; xn <= xcnt; xn++){
				cm_flg=getCMFlag(sheetObjects[0].GetCellValue(xn, "cntr_no"), cntr_mf_no);
				sheetObjects[0].SetCellValue(xn, "cntr_mf_flag",(cm_flg==0) ? 'N' : 'Y',0);
			}
			// Container Manifest Filtering
			var cntr_no='';
			if(sheetObjects[0].RowCount()> 0){
				sheetObjects[0].SelectCell(1, "cntr_no", false);
				cntr_no=sheetObjects[0].GetCellValue(1, "cntr_no");
			}
			//alert("cntr_no    ->" + cntr_no + "\ncntr_mf_no ->" + cntr_mf_no)
			showAndHideCM(cntr_no, cntr_mf_no);	
			//calculatePackage
			//calculatePackage();
			// set HBL Info.
			ComCopyRowToForm(sheetObjects[2], row, document.form, '');
			// Manifest File Assign Enable
			if(ComIsEmpty(document.form.cntr_mf_no.value) && document.form.isInquiry.value == "N"){
				ComBtnEnable("btn_amsFileNoAssign");
			}else{
				ComBtnDisable("btn_amsFileNoAssign");
			}
			//
			document.form.pck_qty.value=ComAddComma3(document.form.pck_qty.value, "#,###");
			document.form.hbl_wgt.value=ComAddComma3(document.form.hbl_wgt.value, "#,###.000");
			document.form.cmdt_meas_qty.value=ComAddComma3(document.form.cmdt_meas_qty.value, "#,###.000");			
			//if POD or DEL is “CA”, activating ACI Type 
			//   1) DEL=“CA”  24: Import
			//   2) POD=“CA”and  DEL≠“CA” ->  23: able to modify after setting In-Transit to default 
			var pod=document.form.pod_cd.value.length > 2 ? document.form.pod_cd.value.substring(0, 2) : '';
			var del=document.form.del_cd.value.length > 2 ? document.form.del_cd.value.substring(0, 2) : '';
			if(pod == "CA" || del == "CA"){
				document.form.hbl_mf_tp_cd.disabled=false;
				if(document.form.hbl_mf_tp_cd.value == ''){
					if(del == "CA"){
						document.form.hbl_mf_tp_cd.value="24";
					}else{
						document.form.hbl_mf_tp_cd.value="23";
					}
				}
			}else{
				document.form.hbl_mf_tp_cd.disabled=true;
			}			
		}
	}
	function showAndHideCM(cntr_no, cntr_mf_no){
		var rseq=1;
		var rsts='';
		var rcnt=sheetObjects[1].RowCount();
		for(rn=1; rn <= rcnt; rn++){
			rsts=sheetObjects[1].GetRowStatus(rn);
			if(sheetObjects[1].GetRowStatus(rn) != 'D' &&
					sheetObjects[1].GetCellValue(rn, "cntr_no") == cntr_no &&
					sheetObjects[1].GetCellValue(rn, "cntr_mf_no") == cntr_mf_no){
				sheetObjects[1].SetCellValue(rn, "seq",rseq++,0);
				sheetObjects[1].SetRowStatus(rn,rsts);
				sheetObjects[1].SetRowHidden(rn,0);
			}else{
				sheetObjects[1].SetRowHidden(rn,1);
			}
		}	
	}
	function getCMFlag(cntr_no, cntr_mf_no){
		var cm_cnt=0;
		var rcnt=sheetObjects[1].RowCount();
		for(rn=1; rn <= rcnt; rn++){
			rsts=sheetObjects[1].GetRowStatus(rn);
			if(sheetObjects[1].GetRowStatus(rn) != 'D' &&
					sheetObjects[1].GetCellValue(rn, "cntr_no") == cntr_no &&
					sheetObjects[1].GetCellValue(rn, "cntr_mf_no") == cntr_mf_no){
				cm_cnt=1;
				break;
			}
		}
		return cm_cnt;
	}
	function calculatePackage(){
		var sheetObj=sheetObjects[1];
		var formObj=document.form;
		var pSum=0;
		var wSum=0;
		var mSum=0;
		var pBkgSum=0;
		var wBkgSum=0;
		var mBkgSum=0;
		var icnt=sheetObj.RowCount();
		//var amount = Math.round(parseFloat(val1) * parseFloat(val2) * 100)/100;
		for (ix=1; ix <= icnt; ix++) {
			if(sheetObj.GetRowStatus(ix) != 'D') {
				if(sheetObj.GetRowHidden(ix) == false){
					pSum += parseInt(sheetObj.GetCellValue(ix, "pck_qty"));
					wSum += parseFloat(sheetObj.GetCellValue(ix, "cntr_mf_wgt"));
					mSum += parseFloat(sheetObj.GetCellValue(ix, "meas_qty"));
				}
				if(sheetObj.GetCellValue(ix, "cntr_mf_no") == formObj.cntr_mf_no.value) {
					pBkgSum += parseInt(sheetObj.GetCellValue(ix, "pck_qty"));
					wBkgSum += parseFloat(sheetObj.GetCellValue(ix, "cntr_mf_wgt"));
					mBkgSum += parseFloat(sheetObj.GetCellValue(ix, "meas_qty"));
				}
			}
		}
		/* related fixed point
		 *   
		 * */
		wSum=Math.round(parseFloat(wSum)* 1000)/1000;
		mSum=Math.round(parseFloat(mSum)* 1000)/1000;
		wBkgSum=Math.round(parseFloat(wBkgSum)* 1000)/1000;
		mBkgSum=Math.round(parseFloat(mBkgSum)* 1000)/1000;

		formObj.cm_pck_qty.value=ComAddComma3(''+pSum, "#,###");
		formObj.cm_wgt_qty.value=ComAddComma3(''+wSum, "#,###.000");
		formObj.cm_meas_qty.value=ComAddComma3(''+mSum, "#,###.000");
		formObj.bk_pck_qty.value=ComAddComma3(''+pBkgSum, "#,###");
		formObj.bk_wgt_qty.value=ComAddComma3(''+wBkgSum, "#,###.000");
		formObj.bk_meas_qty.value=ComAddComma3(''+mBkgSum, "#,###.000");
	}
	function rollbackData(){
		// CM Grid
		var rcnt=sheetObjects[1].RowCount();
		for(ir=1; ir <= rcnt; ir++){
			for(ic=0; ic <= sheetObjects[1].LastCol(); ic++){
				var orgVal=sheetObjects[1].CellSearchValue(ir, ic);
				if (orgVal != sheetObjects[1].GetCellValue(ir, ic)){
					sheetObjects[1].SetCellValue(ir, ic,orgVal,0);
				}							
			}		
		}
		// HBL Grid
		var ir=sheetObjects[2].GetSelectRow();
		for(ic=0; ic <= sheetObjects[2].LastCol(); ic++){
			var orgVal=sheetObjects[2].CellSearchValue(ir, ic);
			if (orgVal != sheetObjects[2].GetCellValue(ir, ic)){
				sheetObjects[2].SetCellValue(ir, ic,orgVal,0);
			}							
		}
	}
	//
	function bkgSplitNoList(split_list){
		document.form.bkg_no.value=split_list.options[split_list.selectedIndex].value;
		layList.style.display="none";
	}
	function callbackSplit(returnVal){
		//alert(returnVal);
		if(!ComIsEmpty(returnVal)){
			var hbl_seq=document.form.hbl_seq.options[document.form.hbl_seq.selectedIndex].value;
			var idxArr=ComFindText(sheetObjects[2], "hbl_seq", hbl_seq);
			sheetObjects[2].SetCellValue(idxArr[0], "org_cntr_mf_no",returnVal,0);
			document.form.org_cntr_mf_no.value=returnVal;
		}
	}
	function callbackPckTp(returnVal){
		//alert(returnVal[0][0] + "|" + returnVal[0][1] + "|" + returnVal[0][2] + "|" + returnVal[0][3])
		document.form.pck_tp_cd.value=returnVal.cd;
		var hbl_seq=document.form.hbl_seq.options[document.form.hbl_seq.selectedIndex].value;
		var idxArr=ComFindText(sheetObjects[2], "hbl_seq", hbl_seq);
		sheetObjects[2].SetCellValue(idxArr[0], "pck_tp_cd",returnVal.cd,0);
	}
	function callbackPckTp2(returnVal){
		//alert(returnVal[0][0] + "|" + returnVal[0][1] + "|" + returnVal[0][2] + "|" + returnVal[0][3])
//		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "pck_tp_cd",returnVal.cd,0);
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "pck_tp_cd",returnVal.cd,1); //Fire change event
	}
	function callbackMFDesc(mk_desc, gds_desc){
		//alert(mk_desc + "\n===================================\n" + gds_desc);
//		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "cntr_mf_mk_desc",mk_desc,0);
//		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "cntr_mf_gds_desc",gds_desc,0);
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "cntr_mf_mk_desc",mk_desc,1); //Fire change event
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "cntr_mf_gds_desc",gds_desc,1); //Fire change event
	}
	function callbackHTSCode(returnValue){
//		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "hamo_trf_cd",returnValue[0][3],0);
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "hamo_trf_cd",returnValue[0][3],1); //Fire change event
	}
	function callbackCopyHbl(returnVal){
		var sheetObj=sheetObjects[2];
		var sel_row=sheetObj.GetSelectRow();
		//alert("* Copy HBL : " + sel_row + " -> " + returnVal);
		for(ir=0;ir<returnVal;ir++){
			var max_seq=ComGetMaxValue(sheetObj, "hbl_seq");
			var new_row=sheetObj.DataInsert(-1);
			var col_name=''
			//alert("* Max Seq : " + max_seq + " -> " + (max_seq+1));
			for(ic=0;ic<=sheetObj.LastCol();ic++){
				col_name=sheetObj.ColSaveName(ic);
				if(col_name == "ibflag"         ||
				   col_name == "seq"            ||
				   col_name == "hbl_no"         ||
				   col_name == "cntr_mf_no"     ||
				   col_name == "org_cntr_mf_no" ||
				   col_name == "hbl_mf_tp_cd"   ||
				   col_name == "ida_iec_no") continue;
				if(col_name == "hbl_seq") sheetObj.SetCellValue(new_row, ic,max_seq + 1,0);
				else sheetObj.SetCellValue(new_row, ic,sheetObj.GetCellValue(sel_row, ic),0);
			}
		}
		//
		changeComboDataByHbl();
		// change View Data
		changeViewDataByHbl(sheetObj.GetCellValue(sel_row, "hbl_seq"));
		//calculatePackage
		calculatePackage();		
		// recording modification
		document.form.dirty_flag.value='Y';
	}
	function callbackHblTmplt(rd_target, cstm_arr, desc_cstm_arr){
		//alert("* target : " + rd_target + "\n " +
		//	  "* customer("+cstm_arr.length+") : " + cstm_arr + "\n" +
		//	  "* description("+desc_cstm_arr.length+") : " + desc_cstm_arr);
		var formObj=document.form;
		var hbl_seq=formObj.hbl_seq.options[formObj.hbl_seq.selectedIndex].value;
		var idxArr=ComFindText(sheetObjects[2], "hbl_seq", hbl_seq);
		var wgt_ut_cd = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "wgt_ut_cd");
		var meas_ut_cd = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "meas_ut_cd");
		if(cstm_arr != null && cstm_arr.length > 0){
			if(rd_target == 'B' || rd_target == 'S'){
				formObj.shpr_nm.value=cstm_arr[0];
				formObj.shpr_addr.value=cstm_arr[1];
				sheetObjects[2].SetCellValue(idxArr[0], "shpr_nm",cstm_arr[0],0);
				sheetObjects[2].SetCellValue(idxArr[0], "shpr_addr",cstm_arr[1],0);
			}
			if(rd_target == 'B' || rd_target == 'C'){
				formObj.cnee_nm.value=cstm_arr[2];
				formObj.cnee_addr.value=cstm_arr[3];
				sheetObjects[2].SetCellValue(idxArr[0], "cnee_nm",cstm_arr[2],0);
				sheetObjects[2].SetCellValue(idxArr[0], "cnee_addr",cstm_arr[3],0);
			}
			// recording modification
			formObj.dirty_flag.value='Y';
		}
		if(desc_cstm_arr != null && desc_cstm_arr.length > 0 && sheetObjects[0].GetSelectRow()> 0){
			for(rx=0;rx<desc_cstm_arr.length;rx++){
				var arr=desc_cstm_arr[rx];
				var nrow=sheetObjects[1].DataInsert(-1);
				sheetObjects[1].SetCellValue(nrow, "bkg_no",formObj.bkg_no.value,0);
				sheetObjects[1].SetCellValue(nrow, "cntr_no",sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "cntr_no"),0);
				sheetObjects[1].SetCellValue(nrow, "cntr_mf_no",formObj.cntr_mf_no.value,0);
				sheetObjects[1].SetCellValue(nrow, "cntr_mf_gds_desc",arr[0],0);
				sheetObjects[1].SetCellValue(nrow, "hamo_trf_cd",arr[1],0);
				sheetObjects[1].SetCellValue(nrow, "wgt_ut_cd",wgt_ut_cd,0);
				sheetObjects[1].SetCellValue(nrow, "meas_ut_cd",meas_ut_cd,0);
			}
			// recording modification
			formObj.dirty_flag.value='Y';
		}
	}
	function copyCm(fmCntr, toCntrArr){
		if(fmCntr == '' || toCntrArr == ''){
			return;
		}
		//alert(fmCntr + " => " + toCntrArr)
		var tgtCnt=toCntrArr.length;
		//alert("tgtCnt==>" + tgtCnt)
		var cArr=ComFindText(sheetObjects[1], "cntr_no", fmCntr);
		//alert("cArr==>" + cArr)
		for(ix=0;ix<tgtCnt;ix++){
			//alert("\ttgt" +ix+ ". "+ toCntrArr[ix]);
			for(ir=0;ir<cArr.length;ir++) {
				var nRow=sheetObjects[1].DataInsert(-1);
				sheetObjects[1].SetRowHidden(nRow,1);
				for(ic=0; ic <=  sheetObjects[1].LastCol(); ic++){
					if(sheetObjects[1].ColSaveName(ic) == "ibflag") continue;
					if(sheetObjects[1].ColSaveName(ic) == "cntr_no"){
						sheetObjects[1].SetCellValue(nRow, ic,toCntrArr[ix],0);
					}else{
						sheetObjects[1].SetCellValue(nRow, ic,sheetObjects[1].GetCellValue(cArr[ir], ic),0);
					}
				}
			}
		}
	}
	/*  checking data changing, in case of moving tab */
	function checkModify(){
		var formObj=document.form;
		if(ComGetObjValue(formObj.dirty_flag) == "Y"){
			if(ComShowCodeConfirm("BKG00350")){
//				ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.old_bkg_no));
				doActionIBSheet(sheetObjects[2], formObj, IBSAVE);
			}
		}
	}
	function searchData(bkgNo){
		var formObj=document.form;
		ComSetObjValue(formObj.bkg_no, bkgNo);
		ComSetObjValue(formObj.dirty_flag, "N");
		doActionIBSheet(sheetObjects[2], formObj, IBSEARCH);
	}
	function setInquiryDisableButton() {
		if(document.form.isInquiry.value == "Y"){
			// button
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_addHBl");
			ComBtnDisable("btn_deleteHBl");
			ComBtnDisable("btn_copyHBl");
			ComBtnDisable("btn_copyCM");
			ComBtnDisable("btn_amsFileNoAssign");
			ComBtnDisable("btn_hbl_tmplt");			
			ComBtnDisable("btn_add");			
			ComBtnDisable("btn_delete");			
			ComBtnDisable("btn_t9CopyMnd");			
		}
	}
	/**
	 *  onblur event of HTML Control <br>
	 **/
	function obj_deactivate() {
		var formObj=document.form;
		var srcName=ComGetEvent("name");
		var srcValue=ComGetEvent("value");
		if (srcName == "bkg_no" || srcName == "bl_no") {
			formObj.elements[srcName].value=srcValue.toUpperCase();
		}
	}
	
    /*
     * MOUSE PASTE 이벤트
     */
    function mousePaste(obj){
    	setTimeout(function(){
        	var updateString = checkSpecial(obj);	//특수문자 제외 로직
        	if(obj.value != updateString){
        		document.form.dirty_flag.value="Y";	//변경사항 체크
        	}
    	}, 100)
    }	
	/* the end of developer's work */
