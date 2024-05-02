/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0063.js
*@FileTitle  : ESM_BKG-0063 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/05
=========================================================*/
/*******************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 *           MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
 * COMMAND01=11; ~ COMMAND20=30;
 ******************************************************************************/
    // public variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var comboCnt=0;
    var comboObjects=new Array();
    var sheetCnt=0;
    var blNo='' ;
    var kind='' ;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
         /** *** If sheets are more than 2 in one tab, use additional sheet variables **** */
		         var sheetObject1=sheetObjects[0];
		         var sheetObject2=sheetObjects[1]; 
		         var sheetObject4=sheetObjects[3]; 
         /** **************************************************** */
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
				break;
				case "btn_new":
					sheetObject1.RemoveAll();
 					sheetObject2.RemoveAll();
					formObject.reset();
					doActionIBSheet(sheetObjects[0],document.form,COMMAND11);
				break;
				case "btn_downexcel":
					if(sheetObject1.RowCount() < 1 && sheetObject2.RowCount()<1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheet1.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject1),  Merge:1});
					}

				break;							
				case "btn_cuscar":
					doActionIBSheet(sheetObject2,document.form,MULTI01);					
					break;
				break;							
				case "btn_view":
					doActionIBSheet(sheetObject2,document.form,MULTI02);
				break;				
				case "btn_transfer":
					doActionIBSheet(sheetObject4,document.form,MULTI03);
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
	 * initializing sheet implementing onLoad event handler in body tag 
	 */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++]=combo_obj;
    }
    
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        
        for ( var k=0 ; k < comboObjects.length ; k++ ) {
    		initCombo(comboObjects[k], k+1);
    	}
        
        doActionIBSheet(sheetObjects[0],document.form,COMMAND11);
        
        if( document.form.vvd.value != '' ){
        	var formObject=document.form;
        	var vvdValue=formObject.vvd.value;
        	var ssrNoValue=formObject.ssr_no.value;
        	document.form.f_cmd.value=SEARCH;
        	sheetObjects[2].DoSearch("ESM_BKG_0063GS.do?vvd="+vvdValue+"&ssr_no="+ssrNoValue, FormQueryString(document.form) );

        }
        if( document.form.popup.value == 'y' ){
        	//document.getElementById("navi").style.display = "none";
        	// document.getElementById("headtitle").innerHTML="<tr><td
			// class='title'><img src='img/icon_title_dot.gif'
			// align='absmiddle'><span id='title'></span></td></tr>"
        }
    }    
    function initControl() {
    	// Event needed for screen
//		axon_event.addListenerForm("keyup","obj_KeyUp", document.form);
//		axon_event.addListenerFormat("keypress","obj_KeyPress", document.form);
    	axon_event.addListenerForm("blur", "obj_blur", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');    	
		
    }
    /**
	 * process when you enter retrieve condition
	 */
    function obj_blur() {
    	var formObject=document.form;
    	var srcName=window.event.srcElement.getAttribute("name");
    	if (srcName == "vvd" || srcName == "ssr_no") {
        	var vvdValue=formObject.vvd.value;
        	var ssrNoValue=formObject.ssr_no.value;
        	if (ComChkLen(vvdValue, 9) == "2" || ComChkLen(ssrNoValue, 6) == "2" ) {
        		document.form.f_cmd.value=SEARCH;
        		sheetObjects[2].DoSearch("ESM_BKG_0063GS.do?vvd="+vvdValue+"&ssr_no="+ssrNoValue, FormQueryString(document.form));
            	if(vvdValue != '')
            		formObject.pol_cd.focus();
        	}
    	}
	}
    
    // 조회후 처리 함수    
    function sheet0_OnSearchEnd(Code, Msg) {
    	var formObject=document.form;
    	formObject.vvd.value=sheetObjects[2].GetCellValue( 1, 2 );
    	formObject.ssr_no.value=sheetObjects[2].GetCellValue( 1, 3 );
    	formObject.vsl_name.value=sheetObjects[2].GetCellValue( 1, 4);
    	formObject.eta.value=sheetObjects[2].GetCellValue( 1, 5 );

    }
    
    // 조회후 처리 함수    
    function sheet3_OnSearchEnd(sheetObj, Code, Msg) { 
    	var formObject = document.form
    	var vvdValue=sheetObjects[2].GetCellValue( 1, 2 );
    	var ssrNoValue=sheetObjects[2].GetCellValue( 1, 3 );
    	var vvdNm=sheetObjects[2].GetCellValue( 1, 4 );
    	var eta=sheetObjects[2].GetCellValue( 1, 5 );
    	if(vvdValue != "-1") formObject.vvd.value=vvdValue;
    	if(ssrNoValue != "-1") formObject.ssr_no.value=ssrNoValue; 
    	if(vvdNm != "-1") formObject.vsl_name.value=vvdNm; 
    	if(eta != "-1") formObject.eta.value=eta;
    	//if(vvdValue != "-1") doActionIBSheet( sheetObjects[0], document.form, IBSEARCH );
    }

     

    /**
	 * setting sheet initial values and header param : 
		 adding case as numbers of counting sheets
	 */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
        	case 1:      // sheet1 init
        	      with(sheetObj){
		             var HeadTitle1="|Seq.|POL|POL ATD|POD|BDR|BDR DATE|B/L|DNLD|ACPT|DIFF|CNTR|DNLD|ACPT|DIFF";
		             SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"SEQ",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pol",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"pol_atd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"bdr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"bdr_date",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"AutoSum",   Hidden:0, Width:45,   Align:"Right",   ColMerge:1,   SaveName:"bl",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"dnld",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"acpt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"diff",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"cntr",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"cntr_dnld",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"cntr_acpt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"cntr_diff",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		              
		             InitColumns(cols);
		             SetSheetHeight(185);
		             SetWaitImageVisible(0);
		             SetEditable(1);
		             SetColProperty("pol_atd", {Format:"YmdHms"} );
		             SetColProperty("bdr_date", {Format:"YmdHms"} );
		            
             }
                break;
            case 2:      // sheet2 init
                with(sheetObj){
                
		              var HeadTitle1="|Seq.|Kind|B/L No.|A|A|S|Last EDI|Last EDI|CNTR|A|A|S|Last EDI|Last EDI|TS|POR|POL|POD|DEL|PRE|POST|BDR|PKG|PKG|WGT|WGT|Description|Notify Name||";
		
		              SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"sStatus" },
		                     {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                     {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"kind",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"bl_ack2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"bl_ack",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"s1",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:400 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bl_last_edi2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bl_last_edi",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_ack2",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_ack",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"s2",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_last_edi2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_last_edi",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pre_rly_port_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pst_rly_port_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bdr_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"cntr_pck_qty",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"cntr_wgt_qty",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:350,  Align:"Left",    ColMerge:1,   SaveName:"mf_desc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:350,  Align:"Left",    ColMerge:1,   SaveName:"ntfy_name",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"svc_rqst_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cnee_addr",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"prev_docno",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cm_pck_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"anr_msg_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"lloyd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"pagerows",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cntr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"brth_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cntr_wgt_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"vvd_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cntr_pck_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"rd_term",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"vvd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"ntfy_name1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"decl_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"ibflag",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"act_wgt_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"shpr_addr",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cntr_mf_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cm_cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"anr_decl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"ntfy_addr",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cntr_anr_msg_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"act_wgt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cm_pck_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"sequence",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cntr_pck_qty22",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cntr_fm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"msg_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"msg_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"s3",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:400 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pck_qty",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:400 },
		                     {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"cntr_mf_wgt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		              SetSheetHeight(332);
		              SetWaitImageVisible(0);
		              SetEditable(1);
		              SetColProperty("kind", {ComboText:"Original|Cancel|", ComboCode:"O|C|N"} );
		              SetCountPosition(0);
				      
              	}
                break; 
            case 3:
                with(sheetObj){
		              var HeadTitle1="|SEQ|VVD|SSR_NO|VVD_NM|ETA_DT";
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"Seq",       Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"seq"},
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:155,  Align:"Center",  ColMerge:1,   SaveName:"ssr_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vvd_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"eta_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		              SetSheetHeight(100);
		              SetVisible(false);
		              SetEditable(1);
                    }


                break;    
            case 4:      // sheet2 init
                with(sheetObj){
             
		             var HeadTitle1="|Seq|Kind|B/L No|A|A|S|Last EDI|Last EDI|CNTR|A|A|S|Last EDI|Last EDI|TS|POR|POL|POD|DEL|PRE|POST|BDR|PKG|PKG|WGT|WGT|Description|Notify Name|S||";
		             var prefix4='sheet4_';
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Status",    Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"sStatus" },
		                 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                 {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"kind",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bl_ack2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bl_ack",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"CheckBox",  Hidden:0, Width:30,    Align:"Center",  ColMerge:1,   SaveName:"s1",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:400 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bl_last_edi2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bl_last_edi",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_ack2",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_ack",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"s2",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"cntr_last_edi2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"cntr_last_edi",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pre_rly_port_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pst_rly_port_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bdr_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"cntr_pck_qty",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"cntr_wgt_qty",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:250,  Align:"Left",    ColMerge:1,   SaveName:"mf_desc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:250,  Align:"Left",    ColMerge:1,   SaveName:"ntfy_name",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"svc_rqst_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cnee_addr",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"prev_docno",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cm_pck_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"anr_msg_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"lloyd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"pagerows",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cntr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"brth_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cntr_wgt_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"vvd_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cntr_pck_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"rd_term",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"vvd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"decl_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"ibflag",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"act_wgt_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"shpr_addr",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cntr_mf_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cm_cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"anr_decl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"ntfy_addr",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cntr_anr_msg_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"act_wgt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cm_pck_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"sequence",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cntr_pck_qty22",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cntr_fm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"msg_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"msg_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"s3",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:400 },
		                 {Type:"Text",      Hidden:0, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"flat_type",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"pck_qty",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"cntr_mf_wgt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
              
		             InitColumns(cols);
		             //SetSheetHeight(0);
		             SetVisible(false)
		             SetEditable(1);
		             SetColProperty("kind", {ComboText:"Original|Cancel|", ComboCode:"O|C|N"} );
            	}
           break;    
        }
    }
    function execSecondRetrive( pol, vvd ){
		if ( pol != '' || pol != null ){
	    	document.form.f_cmd.value=SEARCH02;
	    	var formObj = document.form;
	    	
	    	sheetObjects[1].DoSearch("ESM_BKG_0063GS.do?vvd="+vvd+"&pol_cd="+pol+"&is_cmdt=x"+"&pod="+form.pod.Code, FormQueryString(formObj));
	    	sheetObjects[3].DoSearch("ESM_BKG_0063GS.do?vvd="+vvd+"&pol_cd="+pol+"&is_cmdt=o"+"&pod="+form.pod.Code, FormQueryString(formObj));
//			var aryPrefix = new Array("sheet1_", "sheet2_", "sheet3_", "sheet4_"); //prefix 문자열 배열
//			var sXml = sheetObjects[3].GetSearchXml("ESM_BKG_0063GS.do?vvd="+vvd+"&pol_cd="+pol+"&is_cmdt=o", FormQueryString(document.form) + "&" + ComGetPrefixParam(aryPrefix));
//			alert();
//			var arrXml = sXml.split("|$$|");
//			alert();
//			sheetObjects[3].LoadSearchXml(arrXml[0]);
	    	//sheetObjects[3].DoSearch("ESM_BKG_0063GS.do?vvd="+vvd+"&pol_cd="+pol+"&is_cmdt=o", FormQueryString(document.form));
	    	//for(var i=1; i<sheetObjects[1].RowCount+1; i++ ){
	    	//	sheetObjects[1].CellValue2(i,'s3') = 1
 			//}
		}	
    }
    function doActionIBSheet(sheetObj,formObj,sAction) {
       sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      // Retrieve
				if(validateForm(sheetObj,formObj,sAction)) {
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH01;
					sheetObj.DoSearch("ESM_BKG_0063GS.do", FormQueryString(formObj) );
					// In case of retrieving the top of the sheet,retreive the second sheet by first row

				}
				break;
			case MULTI03:     
				if( validateForm(sheetObj,formObj,sAction) ) {
					formObj.f_cmd.value=MULTI03;
					sheetObj.DoSave("ESM_BKG_0063GS.do?flat_type=0063", FormQueryString(formObj),-1,false );

				}
				break;
			case MULTI01:
				if( validateForm(sheetObj,formObj,sAction) ){ 
					if( sheetObjects[1].RowCount()> 0 ){
					    ComOpenWindowCenter("ESM_BKG_0183_POP.do?pgmNo=ESM_BKG_0183&bl_no=" + blNo , "0183", 1020, 650);
					}
				}		
				break;
			case MULTI02:
				if( validateForm(sheetObj,formObj,sAction) ){
					if( sheetObjects[1].RowCount()> 0 ){
						ComOpenWindowCenter("ESM_BKG_0045_POP.do?pgmNo=ESM_BKG_0045&popup=y&bl_no=" + blNo + "&pKind=" + kind, "0045", 1020, 750);
					}
				}		
				break;
			
			case COMMAND11 : //  PORT 조회
				formObj.f_cmd.value = SEARCH11;
				ComOpenWait(true);
				
				var sXml = sheetObj.GetSearchData("ESM_BKG_0000_1GS.do", FormQueryString(formObj)+"&cnt_cd=BE&cstms_div_id=EUR_BE_PORT_LIST");
				var arrXml = sXml.split("|$$|");
				ComXml2ComboItem(arrXml[0], pod, "pod_cd", "pod_cd");
				formObj.pod.Code = formObj.in_pod.value;
				pod.SetSelectText(formObj.in_pod.value);
				if(pod.GetSelectIndex() < 0) pod.SetSelectIndex(0,true);
//				
				ComOpenWait(false);
				
				break;
		    }
        }
    /**
	 * handling process for input validation
	 */
    function validateForm(sheetObj,formObj,sAction){
        	switch (sAction) {
	 		case IBSEARCH: // Retrieve
	 			if (formObj.vvd.value == "" && (formObj.ssr_no.value == "" ) ) 
	 			{
	 				ComShowCodeMessage('BKG00626','VVD or SSR NO');
	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			return true;
	 		break;
	 		case MULTI03:
	 			var chkCnt=0;
	 			for(var i=1; i<sheetObj.RowCount()+1; i++ ){
	 				if( sheetObj.GetCellValue(i,6) == '1' ) {
	 					chkCnt ++;
	 				}	
	 			}
	 			
	 			if( chkCnt == 0 ) {
	 				ComShowCodeMessage('BKG00249','');
	 				return false;
	 			}
	 			
	 			//before transmitting, ask msg
	 			if (!ComShowCodeConfirm("BKG06200", "CUSCAR")){
    				return false;
    			}
	 			return true;
	 		break;
	 		case MULTI01:
	 			if (blNo == '' ) 
	 			{
	 				ComShowCodeMessage('BKG00249','');
	 				return false;
	 			}
	 			return true;
	 		break;
	 		case MULTI02:
	 			if (blNo == '' ) 
	 			{
	 				ComShowCodeMessage('BKG00249','');
	 				return false;
	 			}
	 			return true;
	 			break;
    	}
    }
    var searchCnt=0;
    function sheet1_OnSearchEnd(sheetObj, Code, Msg) {
    	ComOpenWait(false);
    	var pol=document.form.pol_cd.value;
    	var vvd=document.form.vvd.value;
    	sheetObj.SetSumText(0,"SEQ","TOTAL");
    	execSecondRetrive( pol, vvd );    	 
//    	if(searchCnt==0){
//    		doActionIBSheet( sheetObjects[0], document.form, IBSEARCH );
//    		searchCnt=1;
//    	}
    }
    
    function sheet1_OnDownFinish(sheetObj, downloadType, result){
    	sheet2.Down2Excel({DownCols: makeHiddenSkipCol(sheetObjects[1]),  Merge:1});
    }
    
    /**
	 * Process for click
	 */
    function sheet1_OnClick(sheetObj, row, col) {
//    	for(var i=1; i <= sheetObj.RowCount(); i++) {
//    		sheetObj.RowBackColor(i)=sheetObj.UnEditableColor;
//		}
    }
    /**
	 * move sheet with keyboard
	 */
    function sheet1_OnKeyUp(row, col, KeyCode, Shift) {
    	sheet1_OnClick(sheetObjects[0], col, 0);
    }
    
    /**
	 * Process for double click
	 * 
	 * @param row
	 * @param col
	 * @return
	 */    
    function sheet2_OnDblClick(sheetObj, row, col) {
    	doActionIBSheet(sheetObj,document.form,MULTI02);
    }     
    
    function sheet2_OnSearchEnd(sheetObj, Code, ErrMsg){
    	ComOpenWait(false);
    } 
    
    /**
	 * Process for double click
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
    function sheet2_OnClick(sheetObj, row, col) {
    	blNo=sheetObj.GetCellValue( row, "bl_no" );
    	kind=sheetObj.GetCellValue( row, "kind" );
//		for ( var i=1; i < sheetObj.RowCount()+ 1; i++) {
//			if (sheetObj.GetCellValue(i, "bl_no") == blNo) {
//				sheetObj.SetRowBackColor(i,"#E7FAF6");
//			} else {
//				sheetObj.SetRowBackColor(i,"#FFFFFF");
//			}
//		}
    }
    function sheet2_OnChange(sheetObj, Row, Col, Value) {
    	var blNo ;
    	kind=sheetObj.GetCellValue( Row, 2 );
    	if( Value == 'O' ) {
    		if( sheetObj.GetCellValue(Row,"bl_last_edi")  != 'ON' ){
    			blNo=sheetObj.GetCellValue(Row,"bl_no")
    			for(var i=1; i<=sheetObj.RowCount(); i++){
    				if( blNo == sheetObj.GetCellValue(i,"bl_no") ){
    					if( sheetObj.GetCellValue(i,"bl_last_edi")  != 'ON' ){
    						if( sheetObj.GetCellValue(i,"bl_last_edi")  == 'OA' ){
    							ComShowCodeMessage('BKG43031');
    							sheetObj.SetCellValue(i,"s1",'0' ,0);
    	    					sheetObj.SetCellValue(i,"s2",'0' ,0);
    							return false;
    						}	
	    					sheetObj.SetCellValue(i,"s1",'1' ,0);
	    					sheetObj.SetCellValue(i,"s2",'1' ,0);
	    					sheetObj.SetCellValue(i, "msg_tp_cd",'C',0);
	    					sheetObj.SetCellValue(i,"kind",'O',0);
    					}
    				}
    			}
    		}
    		sheet3Reflect(sheetObjects[3], blNo, Value);
    	} else if ( Value == 'C' ) {
    		if( sheetObj.GetCellValue(Row,"bl_last_edi")  != 'ON' ){
    			for(var i=1; i<sheetObj.RowCount()+1; i++){
    				blNo=sheetObj.GetCellValue(Row,"bl_no")
    				if( blNo == sheetObj.GetCellValue(i,"bl_no") ){
    					if( sheetObj.GetCellValue(i,"bl_last_edi")  != 'ON' ){
	    					sheetObj.SetCellValue(i,"s1",'1' ,0);
	    					sheetObj.SetCellValue(i,"s2",'1' ,0);
	    					sheetObj.SetCellValue(i, "msg_tp_cd",'C',0);
	    					sheetObj.SetCellValue(i,"kind",'C',0);
    					}
    				}
    			}
    		}
    		sheet3Reflect(sheetObjects[3], blNo, Value);
    	} else if ( Value == 'N' ){
    		for(var i=1; i<sheetObj.RowCount()+1; i++){
    			blNo=sheetObj.GetCellValue(Row,"bl_no")
    			if( blNo == sheetObj.GetCellValue(i,"bl_no") ){
    				sheetObj.SetCellValue(i,"s1",'0' ,0);
    				sheetObj.SetCellValue(i,"s2",'0' ,0);
    				sheetObj.SetCellValue(i,"kind",' ',0);
    				sheetObj.SetCellValue(i,"sStatus",' ',0);
				}
			}
    		sheet3Reflect(sheetObjects[3], blNo, Value);
    	}
    }
    function sheet3Reflect(sheetObj, blNo, Value) {
    	var blNo ;
    	var Row=0;
    	for(var i=1; i<=sheetObj.RowCount(); i++){
    		if( blNo == sheetObj.GetCellValue(i,"bl_no") )
    			Row=i;
    	}
    	if( Value == 'O' ) {
    		if( sheetObj.GetCellValue(Row,"bl_last_edi")  != 'ON' ){
    			blNo=sheetObj.GetCellValue(Row,"bl_no")
    			for(var i=1; i<=sheetObj.RowCount(); i++){
    				if( blNo == sheetObj.GetCellValue(i,"bl_no") ){
    					if( sheetObj.GetCellValue(i,"bl_last_edi")  != 'ON' ){
    						if( sheetObj.GetCellValue(i,"bl_last_edi")  == 'OA' ){
    							ComShowCodeMessage('BKG43031');
    							sheetObj.SetCellValue(i,"s1",'0' ,0);
    	    					sheetObj.SetCellValue(i,"s2",'0' ,0);
    	    					sheetObj.SetCellValue(i,"s3",'0' ,0);
    	    					sheetObj.SetCellValue(i,"flat_type",'0063',0);
    							return false;
    						}	
	    					sheetObj.SetCellValue(i,"s1",'1' ,0);
	    					sheetObj.SetCellValue(i,"s2",'1' ,0);
	    					sheetObj.SetCellValue(i,"s3",'1' ,0);
	    					sheetObj.SetCellValue(i, "msg_tp_cd",'C',0);
	    					sheetObj.SetCellValue(i,"kind",'O',0);
	    					sheetObj.SetCellValue(i,"flat_type",'0063',0);
    					}
    				}
    			}
    		}
    	} else if ( Value == 'C' ) {
    		if( sheetObj.GetCellValue(Row,"bl_last_edi")  != 'ON' ){
    			for(var i=1; i<sheetObj.RowCount()+1; i++){
    				blNo=sheetObj.GetCellValue(Row,"bl_no")
    				if( blNo == sheetObj.GetCellValue(i,"bl_no") ){
    					if( sheetObj.GetCellValue(i,"bl_last_edi")  != 'ON' ){
	    					sheetObj.SetCellValue(i,"s1",'1' ,0);
	    					sheetObj.SetCellValue(i,"s2",'1' ,0);
	    					sheetObj.SetCellValue(i,"s3",'1' ,0);
	    					sheetObj.SetCellValue(i, "msg_tp_cd",'C',0);
	    					sheetObj.SetCellValue(i,"kind",'C',0);
	    					sheetObj.SetCellValue(i,"flat_type",'0063',0);
    					}
    				}
    			}
    		}
    	} else if ( Value == 'N' ){
    		for(var i=1; i<sheetObj.RowCount()+1; i++){
    			blNo=sheetObj.GetCellValue(Row,"bl_no")
    			if( blNo == sheetObj.GetCellValue(i,"bl_no") ){
    				sheetObj.SetCellValue(i,"s1",'0' ,0);
    				sheetObj.SetCellValue(i,"s2",'0' ,0);
    				sheetObj.SetCellValue(i,"s3",'0' ,0);
    				sheetObj.SetCellValue(i,"kind",' ',0);
    				sheetObj.SetCellValue(i,"sStatus",' ',0);
				}
			}
    	}
    }
    function retrieve()
    {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    
    function initCombo(comboObj, comboId) {
    	var formObject=document.form
    	if (comboObj.options.id == "pod") {
    		BackColor = "#CCFFFD";
    	}
    }
    function sheet4_OnSaveEnd(sheetObj, ErrMsg){
    	state=sheetObj.GetEtcData("TRANS_RESULT_KEY");    	
		if (state == "S") {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
    } 
