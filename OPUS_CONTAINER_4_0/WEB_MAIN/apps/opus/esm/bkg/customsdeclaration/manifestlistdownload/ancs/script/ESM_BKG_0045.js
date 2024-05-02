﻿/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0045.js
*@FileTitle  : Customer Code Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/09
=========================================================*/

    // global variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var deleteRowIndex=-1;
    var selCntrNo='';
    var sheet3Cnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
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
            switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
				break;
				
				case "btn_new":
					doActionIBSheet(sheetObject1,document.form,COMMAND04);
				break;
				
				case "btn_save":
					doActionIBSheet(sheetObject1,document.form,IBSAVE);
					//doActionIBSheet(sheetObject1,document.form,IBSAVE);
				break;
				
				case "btn_cuscar":
					doActionIBSheet(sheetObject1,formObject,SEARCHLIST01);
				break;							
				
				case "btn_transfer":
					doActionIBSheet(sheetObject1,formObject,MULTI02);
				break;
				
				case "btn_RowAdd":
 					doActionIBSheet(sheetObject3,formObject,IBINSERT);
 					break;
 				case "btn_RowDelete":
 					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
 					//hideNchangeStatByD( sheetObject3, deleteRowIndex );
 					break;
 				case "btn_shipper":
 					doActionIBSheet(sheetObject3,formObject,SEARCHLIST02);
 					break;
 				case "btn_cnee":
 					doActionIBSheet(sheetObject3,formObject,SEARCHLIST03);
 					break;
 				case "btn_noty":
 					doActionIBSheet(sheetObject3,formObject,SEARCHLIST04);
 					break;	
 				case "btn_contact":
 					ComOpenWindowCenter("ESM_BKG_0240_POP.do?pgmNo=ESM_BKG_0240", "ESM_BKG_0240", 1024, 620, false);
				break;	
 				
 				case "btn_close":
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
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl()
        if( document.form.popup.value == 'y' ){
        //	document.getElementById("navi").style.display = "none";
        }
        if( document.form.bl_no.value != '' ){
        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	}
        // set 'U' to FLAG in sheet in Flat file data
        var kind=document.form.kind.value;
        document.form.transmit.value=kind;
        for(var i=1; i<sheetObjects[0].RowCount()+1; i++ ){
        	sheetObjects[0].SetCellValue( i, 0 ,'U',0);
        	sheetObjects[0].SetCellValue( i, 2 ,kind,0);
        	if( kind == 'O' || kind == 'C' )
        		sheetObjects[0].SetCellValue( i, 'sheet1_msg_tp_cd' ,'C',0);
        	else if(  kind == 'N'  )
        		sheetObjects[0].SetCellValue( i, 'sheet1_msg_tp_cd' ,'',0);
        	else
        		sheetObjects[0].SetCellValue( i, 'sheet1_msg_tp_cd' ,'',0);
        }
    }
    function initControl() {
    	var formObject=document.form;
    	//axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	//axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
        var sheetId=sheetObj.id;
        switch(sheetId) {
        case "sheet1":
        	with(sheetObj){
        		var HeadTitle1="|Seq|kind| bl_no| bl_ack2| bl_ack| S1| bl_last_edi2| bl_last_edi| cntr_no| cntr_ack2|"+"cntr_ack| S2| cntr_last_edi2| cntr_last_edi| cntr_tpsz_cd| por_cd| pol_cd|"+"pod_cd| del_cd| pre_rly_port_cd| pst_rly_port_cd| bdr_flg| pck_tp_cd| pck_qty|" +"wgt_ut_cd| cntr_mf_wgt| mf_desc| ntfy_name| svc_rqst_no| cnee_addr| prev_docno|" +"cm_pck_qty| anr_msg_sts_cd| lloyd_cd| pagerows| cntr_seq| brth_desc|" +"cntr_wgt_ut_cd| vvd_seq| cntr_pck_tp_cd| rd_term| vvd| bkg_no| ntfy_addr|"+"decl_flg| ibflag| act_wgt_ut_cd| shpr_addr| cntr_mf_desc| cm_cntr_no|"+"anr_decl_no| cntr_anr_msg_sts_cd| act_wgt| cm_pck_tp_cd| sequence| cntr_pck_qty|"+"cntr_fm| msg_tp_cd| msg_seq| shpr_name| cnee_name| fax_no| ntfy_eml| S3 |";
				var prefix='sheet1_';

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"sStatus" },
						 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"kind",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_ack2",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_ack",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"s1",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:400 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_last_edi2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_last_edi",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_ack2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_ack",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"s2",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_last_edi2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_last_edi",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"por_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pol_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pre_rly_port_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pst_rly_port_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bdr_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pck_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:prefix+"cntr_wgt_qty",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"wgt_ut_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:prefix+"cntr_mf_wgt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"mf_desc",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ntfy_name",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"svc_rqst_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cnee_addr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"prev_docno",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cm_pck_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"anr_msg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"lloyd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pagerows",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cntr_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"brth_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cntr_wgt_ut_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vvd_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cntr_pck_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"rd_term",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vvd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"bkg_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ntfy_addr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"decl_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ibflag",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"act_wgt_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"shpr_addr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cntr_mf_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cm_cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"anr_decl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cntr_anr_msg_sts_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"act_wgt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cm_pck_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"sequence",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pck_qty",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cntr_fm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"msg_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"msg_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"shpr_name",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cnee_name",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ntfy_eml",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"s3",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:400 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"flat_type",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:prefix+"cntr_pck_qty",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetEditable(1);
				SetVisible(0); 
        	}
            break;

        case "sheet2":
        	with(sheetObj){
        		var HeadTitle1="|S|CNTR No.|A|A|RCV|DEL|Last EDI|Last EDI|TP/SZ|Package|Package|Weight|Weight";
        		var prefix='sheet2_';
        		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
        		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
        		InitHeaders(headers, info);
        		var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
        		             {Type:"CheckBox",  Hidden:0, Width:50,    Align:"Center",  ColMerge:0,   SaveName:prefix+"Chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:400 },
        		             {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"anr_msg_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_ack",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        		             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"org_rcv_term_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        		             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dest_de_term_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_last_edi",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        		             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_last_edi2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2,AcceptKeys:"E|N" , InputCaseSensitive:1 },
        		             {Type:"Float",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pck_qty",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
        		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pck_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 , AcceptKeys:"E|N" , InputCaseSensitive:1},
        		             {Type:"Float",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_wgt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:22 },
        		             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"wgt_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
        		InitColumns(cols);
        		SetColProperty("sheet2_org_rcv_term_cd", {ComboText:"FCL|LCL", ComboCode:"FCL|LCL"} );
        		SetColProperty("sheet2_dest_de_term_cd", {ComboText:"FCL|LCL", ComboCode:"FCL|LCL"} );
        		SetColProperty("sheet2_wgt_ut_cd", {ComboText:"KGS|LBS", ComboCode:"KGS|LBS"} );
        		SetEditable(1);
        		SetSheetHeight(125);
                }
        	break;
        case "sheet3":
        	with(sheetObj){
        		var HeadTitle1="|Seq.|T1 Ind|Package|Package|Weight|Weight|DESCRIPTION";
        		var prefix='sheet3_';
        		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
        		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
        		InitHeaders(headers, info);
        		
        		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
        		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"SEQ2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        		             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"decl_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        		             {Type:"Float",     Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pck_qty",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
        		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pck_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 ,  AcceptKeys:"E|N" , InputCaseSensitive:1},
        		             {Type:"Float",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_mf_wgt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:22 },
        		             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"wgt_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_mf_desc", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000,  AcceptKeys:"E|N|[!@#$%^&*()-_+=|{}[];:'.,/<>? ]" , InputCaseSensitive:1 },
        		             {Type:"Text",      Hidden:1, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        		             {Type:"Text",      Hidden:1, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        		             {Type:"Text",      Hidden:1, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        		             {Type:"Text",      Hidden:1, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        		             {Type:"Text",      Hidden:1, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_voy_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        		             {Type:"Text",      Hidden:1, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"chk_cmdt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:400 } ];
        		
        		InitColumns(cols);
        		SetColProperty("sheet3_decl_flg", {ComboText:"YES|NO", ComboCode:"Y|N"} );
        		SetColProperty("sheet3_wgt_ut_cd", {ComboText:"KGS|LBS", ComboCode:"KGS|LBS"} );	
        		SetEditable(1);
        		SetSheetHeight(150);
        	    }
        	break;
        }
    }
    
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(validateForm(sheetObj,formObj,sAction)) {
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH;
					var aryPrefix=new Array("sheet1_", "sheet2_", "sheet3_", "frm_sheet1_"); //prefix string array
					var sXml=sheetObj.GetSearchData("ESM_BKG_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
					var arrXml=sXml.split("|$$|");
					if ( arrXml.length > 2 ){
    					sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
    					sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
    					sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
					}
					if(sheetObjects[0].RowCount()> 0) {
		   	  			IBS_CopyRowToForm(sheetObjects[0], formObj, 1, "frm_");
		   	  		}
					if (formObj.frm_sheet1_act_wgt.value != ""){
						AddComma(formObj.frm_sheet1_act_wgt, "#,###.#");
					}
					sheet2_OnClick(sheetObjects[1], 1, 2, '');
					on_transmission();
					formObj.frm_article_chk.checked=0
					ComOpenWait(false);
				}
				
				break;
			case IBSAVE:        //save
				IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
				if( validateForm(sheetObj,formObj,sAction) ){
					formObj.f_cmd.value=MULTI;
					var sParam1=sheetObjects[0].GetSaveString();
					var sParam2=sheetObjects[1].GetSaveString();
					var sParam3=sheetObjects[2].GetSaveString();
					if ((sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()|| sheetObjects[2].IsDataModified()) && sParam == "") {
						return; 
					}
					var totalCntrPckQty = 0;
					var totalCntrWgt = 0;
					var vSheet1_PckQty=Number(formObj.frm_sheet1_pck_qty.value);
					var vSheet1_CntrWgt=unComma(formObj.frm_sheet1_act_wgt.value); // 콤마 제거
					var vSheet1_pck_tp_cd=formObj.frm_sheet1_pck_tp_cd.value;
					var vSheet1_wgt_ut_cd =formObj.frm_sheet1_act_wgt_ut_cd.value;
					sheetObjects[0].SetCellValue(1,'sheet1_act_wgt',vSheet1_CntrWgt);
					sheetObjects[0].SetCellValue(1,'sheet1_act_wgt_ut_cd',vSheet1_wgt_ut_cd);
					sheetObjects[0].SetCellValue(1,'sheet1_pck_qty',vSheet1_PckQty); 
					sheetObjects[0].SetCellValue(1,'sheet1_pck_tp_cd',vSheet1_pck_tp_cd);
					
					for( var i=1; i<=sheetObjects[1].RowCount(); i++ ){
						totalCntrWgt += Number( sheetObjects[1].GetCellValue(i, "sheet2_cntr_wgt") );
						totalCntrPckQty += Number( sheetObjects[1].GetCellValue(i, "sheet2_pck_qty") );
					}
					if(vSheet1_PckQty != totalCntrPckQty){
						ComShowCodeMessage('BKG01123',"Please check B/L and CNTR's package quantity."); // "Total Package QTY does not match ![{?msg1}]"
						return false;
					}
					if(vSheet1_CntrWgt != totalCntrWgt){
						ComShowCodeMessage('BKG01124',"Please check B/L and CNTR's weight."); // "Total Weight does not match ![{?msg1}]"
						return false;
					}
					
					/*
					 * Packgae Qty Weigth value check
					 */
					for( var i=1; i<=sheetObjects[1].RowCount(); i++ ){
						var vSheet2_CntrNo=sheetObjects[1].GetCellValue(i, "sheet2_cntr_no");
						var vSheet2_PckQty=Number( sheetObjects[1].GetCellValue(i, "sheet2_pck_qty") );
						//alert(vSheet2_PckQty);
						var vSheet3_PckQty=0 ;
						var vSheet2_CntrWgt=Number( sheetObjects[1].GetCellValue(i, "sheet2_cntr_wgt") );
						var vSheet3_CntrWgt=0 ;
						for( var i=1; i<=sheetObjects[2].RowCount(); i++ ){
							if( vSheet2_CntrNo == sheetObjects[2].GetCellValue(i, "sheet3_cntr_no") && sheetObjects[2].GetCellValue(i, "sheet3_ibflag") != "D" ){
								vSheet3_PckQty=vSheet3_PckQty + Number( sheetObjects[2].GetCellValue(i, "sheet3_pck_qty") );
								vSheet3_CntrWgt=vSheet3_CntrWgt + Number( sheetObjects[2].GetCellValue(i, "sheet3_cntr_mf_wgt") );
							}
						}
						
						//alert(vSheet3_PckQty);
						if( vSheet2_PckQty != vSheet3_PckQty ){
							ComShowCodeMessage('BKG01123', vSheet2_CntrNo );
							return false;
						}
						if( vSheet2_CntrWgt != vSheet3_CntrWgt ){
							ComShowCodeMessage('BKG01124', vSheet2_CntrNo );
							return false;
						}	
						vSheet2_PckQty=0;
						vSheet3_CntrWgt=0;
					}
					
					var aryPrefix=new Array("sheet1_", "sheet2_", "sheet3_");    //prefix string array
					var sParam=ComGetSaveString(sheetObjects);
	                    sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam( aryPrefix );
					var sXml=sheetObj.GetSaveData("ESM_BKG_0045GS.do",sParam);
					sheetObjects[0].LoadSaveData(sXml);
					sXml=ComDeleteMsg(sXml);  
					sheetObjects[1].LoadSaveData(sXml);
					sheetObjects[2].LoadSaveData(sXml);
				}	
				break;
			case IBINSERT:      // insert
				sheetObj.DataInsert(-1);
				sheetObj.SetCellValue( sheetObj.RowCount(), 8 ,selCntrNo);
				if ( sheetObj.RowCount()== 1 )
					sheetObj.SetCellValue( sheetObj.RowCount(), 9 ,1);
				else
					sheetObj.SetCellValue( sheetObj.RowCount(), 9 ,(sheetObj.GetCellValue( sheetObj.RowCount()-1, 9 ) + 1));
					//alert(sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "bkg_no"));
					//alert(sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "bkg_no"));
					sheetObj.SetCellValue( sheetObj.RowCount(), 10 ,sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "sheet2_bkg_no"));//sheetObj.GetCellValue( sheetObj.RowCount()-1, 10 );
					sheetObj.SetCellValue( sheetObj.RowCount(), 11 ,formObj.frm_sheet1_vvd.value.substring(0,4));//sheetObj.GetCellValue( sheetObj.RowCount()-1, 11 );
					sheetObj.SetCellValue( sheetObj.RowCount(), 12 ,formObj.frm_sheet1_vvd.value.substring(4,8));//sheetObj.GetCellValue( sheetObj.RowCount()-1, 12 );
					sheetObj.SetCellValue( sheetObj.RowCount(), 13 ,formObj.frm_sheet1_vvd.value.substring(8));//sheetObj.GetCellValue( sheetObj.RowCount()-1, 13 );
					makeSeq();
				break;
			case IBDELETE:      // delete
				var checked=0;
				if (sheetObjects[2].GetCellValue(deleteRowIndex,0) != "I"){
					sheetObjects[2].SetRowHidden( deleteRowIndex ,1);
					sheetObjects[2].SetRowStatus( deleteRowIndex ,"D");
				} else {
					sheetObjects[2].SetRowStatus( deleteRowIndex ,"D");
				}
				if ( deleteRowIndex == -1 ) ComShowCodeMessage('BKG00249');
				makeSeq();
			case SEARCHLIST02:
				if(validateForm(sheetObj,formObj,sAction)) 
					ComOpenWindow2("ESM_BKG_0728.do?popup=y&keyAddr=" + formObj.frm_sheet1_shpr_name.value  , "", "width=900, height=620");
				break;
			case SEARCHLIST03:
				if(validateForm(sheetObj,formObj,sAction)) 
					ComOpenWindow2("ESM_BKG_0728.do?popup=y&keyAddr=" + formObj.frm_sheet1_cnee_name.value  , "", "width=900,height=620");
				break;
			case SEARCHLIST04:
				if(validateForm(sheetObj,formObj,sAction)) {
					ComOpenWindow2("ESM_BKG_0728.do?popup=y&keyAddr=" + formObj.frm_sheet1_ntfy_name.value  , "", "width=900,height=620");
				}	
				break;	
			case COMMAND04:
				if (confirm("Do you really want to clear this?")) {
					ComResetAll();
				}
//				if( !sheetObjects[0].IsDataModified()&& !sheetObjects[1].IsDataModified()&& !sheetObjects[2].IsDataModified()){
//					ComResetAll();
//				} else {
//					if (ComShowCodeConfirm("BKG00386")) {
//						doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
//						ComResetAll();
//					} else {
//						ComResetAll();
//					}
//				}
				break;
			case SEARCHLIST01:
				if(validateForm(sheetObj,formObj,sAction)){ 
					var vBlNo=formObj.bl_no.value;
					//ComOpenWindow2("ESM_BKG_0183_POP.do?popup=y&bl_no=" + vBlNo  , "", "width=1024,height=650");
					ComOpenWindowCenter("ESM_BKG_0183_POP.do?pgmNo=ESM_BKG_0183&popup=y&bl_no=" + vBlNo  , "", 1024, 680);
					
				}
				break;    
	        case MULTI02:
	        	if(validateForm(sheetObj,formObj,sAction)){ 
	        		sheetObj.SetWaitImageVisible(0);
	        		ComOpenWait(true);
					formObj.f_cmd.value=MULTI02;
		        	var shprAddr=formObj.frm_sheet1_shpr_name.value + '@@' + formObj.frm_sheet1_shpr_addr.value ;
		        	var cneeAddr=formObj.frm_sheet1_cnee_name.value + '@@' + formObj.frm_sheet1_cnee_addr.value ;
		        	for( var i=1; i<sheetObjects[0].RowCount()+1; i++ ){
		        		sheetObjects[0].SetCellValue(i, 'sheet1_shpr_addr',shprAddr,0);
		        		sheetObjects[0].SetCellValue(i, 'sheet1_cnee_addr',cneeAddr,0);
		        		sheetObjects[0].SetCellValue(i, 'sheet1_ntfy_addr',formObj.frm_sheet1_ntfy_addr.value,0);
		        		sheetObjects[0].SetCellValue(i, 'sheet1_ntfy_name',formObj.frm_sheet1_ntfy_name.value,0);
		        		sheetObjects[0].SetCellValue(i, 'sheet1_fax_no',formObj.frm_sheet1_fax_no.value,0);
		        		sheetObjects[0].SetCellValue(i, 'sheet1_ntfy_eml',formObj.frm_sheet1_ntfy_eml.value,0);
		        		sheetObjects[0].SetCellValue(i, 'sheet1_flat_type','0045',0);
		        	}
		        	//wait-image display
		        	//sheetObjects[0].DoSave("ESM_BKG_0045GS.do", FormQueryString(formObj));
		        	var aryPrefix=new Array("sheet1_", "sheet2_", "sheet3_");    //prefix string array
					var sParam=ComGetSaveString(sheetObjects);
	                    sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam( aryPrefix );
					var sXml=sheetObj.GetSaveData("ESM_BKG_0045GS.do",sParam);
					sheetObjects[0].LoadSaveData(sXml);
					//sXml = ComDeleteMsg(sXml);   
					//sheetObjects[1].LoadSaveXml(sXml);
					//sheetObjects[2].LoadSaveXml(sXml);
		        	ComOpenWait(false);		
		        	if(!document.form.mainPageFlag.value)opener.retrieve();
//			        	if ( opener != null )
//			        		opener.retrieve();
		        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	        	}
				break;   
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
	 		case IBSEARCH: // Retrieve
	 			if (formObj.bl_no.value == "" ) 
	 			{
	 				ComShowCodeMessage('BKG00266'); 
	 				return false;
	 			}
	 			return true;
	 		break;
	 		case IBSAVE:
	 			if( !formObj.IsDataModified && !sheetObjects[0].IsDataModified()&& !sheetObjects[1].IsDataModified()&& !sheetObjects[2].IsDataModified())
	 			{
	 				ComShowCodeMessage('BKG00233');
	 				return false;
				} 
	 			return true;
	 		break;
	 		case SEARCHLIST02: // Retrieve
	 			if (formObj.frm_sheet1_shpr_name.value == "" )
	 			{
	 				ComShowCodeMessage('BKG00395');
	 				return false;
	 			}
	 			return true;
	 		break;
	 		case SEARCHLIST03: // Retrieve
	 			if (formObj.frm_sheet1_cnee_name.value == "" ) 
	 			{
	 				ComShowCodeMessage('BKG00395');
	 				return false;
	 			}
	 			return true;
	 		break;
	 		case SEARCHLIST04: // Retrieve
	 			if (formObj.frm_sheet1_ntfy_name.value == "" ) 
	 			{
	 				ComShowCodeMessage('BKG00395');
	 				return false;
	 			}
	 			return true;
	 		break;
	 		case MULTI01:
	 			return true;
	 		break;
	 		case SEARCHLIST01:
	 			return true;
	 		break;
	 		case MULTI02: 
	 			var vIsCheck=false;
	 			// alert(sheetObj.RowCount);
		 			for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
		 				if (sheetObjects[1].GetCellValue(i, "sheet2_Chk") == 1) {
	 					vIsCheck=true;
	 					break;
	 				}
	 			}
	 			if (!vIsCheck && !formObj.frm_article_chk.checked ) {
	 				ComShowCodeMessage('BKG00333', '');
	 				return false;
	 			}
	 			var trnasSelVal=document.form.transmit.value ;
	 			if( "" == trnasSelVal || "N" == trnasSelVal ){
	 				ComShowCodeMessage('BKG43030');
	 				return false;
	 			}
	 			
	 			if (!ComShowCodeConfirm("BKG06200", "CUSCAR")){
    				return false;
    			}
	 			return true;
	 		break;
    	}
    }
    function hideNchangeStatByD(sheetObj,Row){
		sheetObj.SetRowHidden(Row,0);//2.GetRowHidden
		sheetObj.SetRowStatus(Row,"D");//3.GetRowStatus=D
	}
    function sheet3_OnClick(SheetObj, Row, Col){
    	deleteRowIndex=Row ;
    }
    function sheet2_OnClick(SheetObj, Row, Col, Value){
    	selCntrNo=SheetObj.GetCellValue( Row, 2 );
    	makeSeq( Row, Col, SheetObj.GetCellValue(Row, 1) );
    	var vCntrNo=SheetObj.GetCellValue( Row, 'sheet2_cntr_no' );
    	if( Col == 1 && Value == 0){
    		for( var i=1; i<= sheetObjects[0].RowCount(); i++ ){
    			if( vCntrNo == sheetObjects[0].GetCellValue(i,'sheet1_cntr_no') )
    				sheetObjects[0].SetCellValue(i,'sheet1_s2',0 ,0);
    		}
    	}else if( Col == 1 && Value == 1){
    		for( var i=1; i<= sheetObjects[0].RowCount(); i++ ){
    			if( vCntrNo == sheetObjects[0].GetCellValue(i,'sheet1_cntr_no') )
    				sheetObjects[0].SetCellValue(i,'sheet1_s2',1 ,0);
    		}
    	}
    }
    function makeSeq(Row, Col, isChk){
    	sheet3Cnt=0;
    	//alert(Col);
    	for(var i=0; i<sheetObjects[2].RowCount(); i++){
    		var cmCntrNo=sheetObjects[2].GetCellValue( i+1, 8 );
    		if ( selCntrNo != cmCntrNo ){
    			sheetObjects[2].SetRowHidden(i+1,1);//2.GetRowHidden
    			//sheetObjects[2].CellValue2(i+1,0) = '';
    			//if( sheetObjects[2].CellValue(i+1,14) != 'O' )
    			//	sheetObjects[2].CellValue2(i+1,0) = '';
    		} else {
    			sheetObjects[2].SetRowHidden(i+1,0);
    			sheetObjects[2].SetCellValue(i+1,1,sheet3Cnt + 1,0);
    			if( sheetObjects[2].GetCellValue(i+1,0) != 'D' )
    				sheet3Cnt ++;
    			if( sheetObjects[2].GetCellValue(i+1,0) == 'D' )
    				sheetObjects[2].SetRowHidden(i+1,1);
//        			if(Col == 1 ){
//        				if(isChk != 1){
//        					sheetObjects[2].CellValue2(i+1,14) = 'O';
//        				} else {
//        					sheetObjects[2].CellValue2(i+1,14) = '';
//        				}	
//        			}
//        			if( sheetObjects[2].CellValue(i+1,14) != 'O' )
//        				sheetObjects[2].CellValue2(i+1,0) = '';
    		}
    	}	
    }
    /**
     * CNTR Receive operation for creating a data file is created.
     * 
     * @param SheetObj
     * @param Row
     * @param Col
     * @param Value
     * @return
     */
    function sheet2_OnChange(SheetObj, Row, Col, Value){
    	/*
    	 * FLAT file items
    	 * CNTR_NO -- not editable
    	 * CNTR_TS -- editable
    	 * CNTR_FM -- not
    	 * CNTR_WGT -- editable
    	 * RD_TERM 
    	 */
		var cntrNo=sheetObjects[2].GetCellValue(Row,2);
    	var s1Row;
    	var s1Col;
    	if( Col == 9 ){
    		for( var i=1; i<sheetObjects[0].RowCount()+1; i++ ){
		if( cntrNo == sheetObjects[0].GetCellValue(i,9) ){
    				s1Row=i;
    				s1Col=15; //CNTR_TPSZ_CD COL number
    			}
    		}
    		sheetObjects[0].SetCellValue(s1Row,s1Col,Value,0);
    	} else if( Col == 12 ){
    		for( var i=1; i<sheetObjects[0].RowCount()+1; i++ ){
		if( cntrNo == sheetObjects[0].GetCellValue(i,9) ){
    				s1Row=i;
    				s1Col=26; //CNTR_TPSZ_CD COL number
    			}
    		}
    		sheetObjects[0].SetCellValue(s1Row,s1Col,Value,0);
    	}else if( Col == 5 || Col == 6 ){
    		for( var i=1; i<sheetObjects[0].RowCount()+1; i++ ){
		if( cntrNo == sheetObjects[0].GetCellValue(i,9) ){
    				s1Row=i;
    				s1Col=41; //CNTR_TPSZ_CD COL number
    			}
    		}
		sheetObjects[0].SetCellValue(s1Row,s1Col,sheetObjects[1].GetCellValue(Row,5) + sheetObjects[1].GetCellValue(Row,6),0);
    	}
    }
    /**
     * CMDT Receive operation for creating a data file is created.
     * 
     * @param SheetObj
     * @param Row
     * @param Col
     * @param Value
     * @return
     */
    function sheet3_OnChange(SheetObj, Row, Col, Value){
    	/*
    	 * CM_SEQ    - not
    	 * CM_PKG_NO - editable
    	 * CM_PKG_CD - editable
    	 * CM_DESC   - editable
    	 * CM_WGT    - editable
    	 * CM_WGT_U  - editable
    	 * CM_CNTR_NO - not
    	 * T1_IND    - editable
    	 */
		var cntrNo=sheetObjects[2].GetCellValue(Row,8);
    	var s1Row;
    	var s1Col;
    	if( Col == 2 ){
    		for( var i=1; i<sheetObjects[0].RowCount()+1; i++ ){
		if( cntrNo == sheetObjects[0].GetCellValue(i,9) ){
    				s1Row=i;
    				s1Col=45; 
    			}
    		}
    		if( 'Y' == Value )
    			sheetObjects[0].SetCellValue(s1Row,s1Col,'T1',0);
    		else
    			sheetObjects[0].SetCellValue(s1Row,s1Col,'C',0);
    	} else if( Col == 3 ){
    		for( var i=1; i<sheetObjects[0].RowCount()+1; i++ ){
				if( cntrNo == sheetObjects[0].GetCellValue(i,9) ){
    				s1Row=i;
    				s1Col=32; 
    			}
    		}
    		sheetObjects[0].SetCellValue(s1Row,s1Col,Value,0);
    	} else if( Col == 4 ){
    		for( var i=1; i<sheetObjects[0].RowCount()+1; i++ ){
				if( cntrNo == sheetObjects[0].GetCellValue(i,9) ){
    				s1Row=i;
    				s1Col=40; 
    			}
    		}
    		sheetObjects[0].SetCellValue(s1Row,s1Col,Value,0);
    	}else if( Col == 5 ){
    		for( var i=1; i<sheetObjects[0].RowCount()+1; i++ ){
				if( cntrNo == sheetObjects[0].GetCellValue(i,9) ){
    				s1Row=i;
    				s1Col=26; //CNTR_TPSZ_CD COL number
    			}
    		}
    		sheetObjects[0].SetCellValue(s1Row,s1Col,Value,0);
    	}else if( Col == 6 ){
    		for( var i=1; i<sheetObjects[0].RowCount()+1; i++ ){
				if( cntrNo == sheetObjects[0].GetCellValue(i,9) ){
    				s1Row=i;
    				s1Col=25; //CNTR_TPSZ_CD COL number
    			}
    		}
    		sheetObjects[0].SetCellValue(s1Row,s1Col,Value,0);
    	}else if( Col == 7 ){
    		for( var i=1; i<sheetObjects[0].RowCount()+1; i++ ){
				if( cntrNo == sheetObjects[0].GetCellValue(i,9) ){
    				s1Row=i;
    				s1Col=49; //CNTR_TPSZ_CD COL number
    			}
    		}
    		sheetObjects[0].SetCellValue(s1Row,s1Col,Value,0);
    	}
    }
    /**
     * when Transmission selectBox Seleted, Action.
     * 
     * @return
     */
    function on_transmission(){
    	var trnasSelVal=document.form.transmit.value ;
    	for( var i=1; i<sheetObjects[0].RowCount()+1; i++ ){
    		if( trnasSelVal == "O" ){
    			sheetObjects[0].SetCellValue(i, "sheet1_kind",'O',0);
    			sheetObjects[0].SetCellValue( i, 'sheet1_msg_tp_cd' ,'C',0);
    		}else if( trnasSelVal == "T" ){
    			sheetObjects[0].SetCellValue(i, "sheet1_kind",'T',0);
    			sheetObjects[0].SetCellValue( i, 'sheet1_msg_tp_cd' ,'C',0);
    		}else if( trnasSelVal == "C" ){
    			sheetObjects[0].SetCellValue(i, "sheet1_kind",'C',0);
    			sheetObjects[0].SetCellValue( i, 'sheet1_msg_tp_cd' ,'C',0);
    		}else{ 
    			sheetObjects[0].SetCellValue(i, "sheet1_kind",'N',0);
    			sheetObjects[0].SetCellValue( i, 'sheet1_msg_tp_cd' ,'',0);
    		}
    		sheetObjects[0].SetCellValue(i, "sheet1_s1",'1',0);
    	}
    }
    function chkCmt(){
    	if( true == document.form.frm_article_chk.checked ){
    		for( var i=1; i<= sheetObjects[0].RowCount(); i++ ){
   				sheetObjects[0].SetCellValue(i,'sheet1_s3',1 ,0);
    		}
    	}else{
    		for( var i=1; i<= sheetObjects[0].RowCount(); i++ ){
   				sheetObjects[0].SetCellValue(i,'sheet1_s3',0 ,0);
    		}
    	}	
    }   
    
  //콤마풀기
    function unComma(str) {
//        str = String(str);
//        return str.replace(/[^\d]+/g, '');
    	str = "" + str.replace(/,/gi,''); // 콤마 제거
    	 str = str.replace(/(^\s*)|(\s*$)/g, ""); // trim
    	 return (new Number(str));
    }

    /**
     * Add Comma Function
     */
    function AddComma(obj, sFormat, len) {
    	try {
    		var sVal=obj.value.replace(/\,/g, "");
    		switch (sFormat) {
    		case "#,###":
    			obj.value=ComAddComma(sVal);
    			break;
    		case "#,###.#":
    			if (sVal == ".")
    				sVal="0.";
    			p=sVal.split(".");
    			p[0]=ComAddComma(p[0]);
    			if (p.length <= 1)
    				obj.value=p[0] + ".000";
    			else if (p.length == 2)
    				obj.value=p[0] + "." + p[1].substr(0, 3);
    			else if (p.length > 2)
    				obj.value=p[0] + "." + p[1].substr(0, 3);
    			else
    				sVal="";
    			break;
    		case "#,###.##":
    			if (sVal == ".")
    				sVal="0.";
    			p=sVal.split(".");
    			p[0]=ComAddComma(p[0]);
    			if (p.length <= 1) {
    				if (p[0].length > len - 3) {
    					sVal=p[0].substr(0, len - 3).replace(/\,/g, "");
    					p[0]=ComAddComma(sVal);
    				}
    				obj.value=p[0];
    			} else if (p.length == 2)
    				obj.value=p[0] + "." + p[1].substr(0, 2);
    			else if (p.length > 2)
    				obj.value=p[0] + "." + p[1].substr(0, 2);
    			else
    				sVal="";
    			break;
    		case "#,###.###":
    			if (sVal == ".")
    				sVal="0.";
    			p=sVal.split(".");
    			p[0]=ComAddComma(p[0]);
    			if (p.length <= 1) {
    				if (p[0].length > len - 4) {
    					sVal=p[0].substr(0, len - 3).replace(/\,/g, "");
    					p[0]=ComAddComma(sVal);
    				}
    				obj.value=p[0];
    			} else if (p.length == 2)
    				obj.value=p[0] + "." + p[1].substr(0, 3);
    			else if (p.length > 2)
    				obj.value=p[0] + "." + p[1].substr(0, 3);
    			else
    				sVal="";
    			break;
    		}
    	} catch (err) {
    		ComFuncErrMsg(err.message);
    	}
    }
    
    