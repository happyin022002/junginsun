/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.1
*@FileName   : esm_bkg_0566.js
*@FileTitle  : Booking History (B/L Data)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var rdObjects=new Array();
    var rdCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
        /***** using extra sheet valuable if there are more 2 sheets *****/
        sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			switch(srcName) {
 
				case "d_type1": // when selecting Declration (Discharging)
				case "d_type2": // when selecting Declration (Trasit)
				case "d_type3": // when selecting Declration (Loading)
				case "d_type4": // when selecting Declration (Pre-Carriage)
				case "d_type5": // when selecting Declration (On-Carriage)
					var dTypeVal=declarationCheckValue();  // getting value of selected check box
					dTypeCheckValidate(dTypeVal,srcName);	// validation
					document.form.eur_dg_decl_tp_cd.value=declarationCheckValue();
					break;			
				case "btn_retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
				case "btn_close":
					ComClosePopup(); 
					break;
            } // end switch
    	}catch(e) {
    		ComShowMessage(e);
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
     * registering the created IBCombo Object at page as comboObjects list
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
    }

    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);         	
            ComEndConfigSheet(sheetObjects[i]);            
        }
        initControl();

        //---------------

    	axon_event.addListenerForm('change', 'obj_change', document.form); // change
        //initParam();

    	if("ESM_BKG_0965"==document.form.originPgm.value){
    		changeDeclareCheckBox();
    	}else{
        	changeDeclareRadio();
    	}
    		
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); 
        

    }

    function initControl() {
    	var formObject=document.form;
    }
    /**
     * setting sheet initial values and header
     * @param sheetObj
     * @param sheetNo
     * @return
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		switch(sheetObj.id) {
	        case "sheet1":      //sheet1 init
	            with(sheetObj){
	        		if("ESM_BKG_0965"==document.form.originPgm.value){
	        			var HeadTitle =	"Seq|Container|TP/SZ|Cell\nPosition|Class|UN No|Outer Package|Outer Package|Outer Package|Inner Package|Inner Package|Inner Package|Flash\nPoint/℃|Package\nGroup|" +
									   	"Marine\nPollutant|Limited\nquantity|High\nConsequence|EMS No|Mfag|Net\nWeight|Gross\nWeight|Net Exp\nWeight|" +
									   	"Package|Substance|Technical Name|Berth|Berth|Extended Stay\nPermit|Remark(s)|" +
									   	"Forwarder|On-Carriage\nDate|Belgian\nCodes|Carriage Type|SSR|Feeder VVD|Feeder Name|Lloyd No|" +
									   	"Cargo\nOperator|Reference|User ID|Update Date";
									   	
	        			var HeadTitle2=	"Seq|Container|TP/SZ|Cell\nPosition|Class|UN No|Qty|Code|Desccription"                 +"|Qty|Code|Desccription"                 +"|Flash\nPoint/℃|Package\nGroup|" + 
									   	"Marine\nPollutant|Limited\nquantity|High\nConsequence|EMS No|Mfag|Net\nWeight|Gross\nWeight|Net Exp\nWeight|" +
									   	"Package|Substance|Technical Name|Code|Name|Extended Stay\nPermit|Remark(s)|" +
									   	"Forwarder|On-Carriage\nDate|Belgian\nCodes|Carriage Type|SSR|Feeder VVD|Feeder Name|Lloyd No|" +
									   	"Cargo\nOperator|Reference|User ID|Update Date";
						
			//			SetConfig( { SearchMode:0, MergeSheet:7, Page:20, FrozenCol:3, DataRowMerge:1 } );
						SetConfig( { SearchMode:0, MergeSheet:7, Page:20, FrozenCol:1, DataRowMerge:0 } );
						
						var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
						var headers = [ { Text:HeadTitle, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
						InitHeaders(headers, info);
						
						var cols = [ 	{Type:"Int",	Hidden:0, 	Width:40,  	Align:"Center",	ColMerge:1,	SaveName:"his_seq",        			KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
						             	{Type:"Text",	Hidden:0, 	Width:110,	Align:"Left",	ColMerge:1,	SaveName:"cntr_no",       			KeyField:0,	CalcLogic:"", 	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:50,	Align:"Center",	ColMerge:1,	SaveName:"cntr_tpsz_cd",  			KeyField:0,	CalcLogic:"", 	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:70,	Align:"Center",	ColMerge:1,	SaveName:"cell_psn_no",  			KeyField:0,	CalcLogic:"", 	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:60,	Align:"Center",	ColMerge:0,	SaveName:"imdg_clss_cd",      		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:60,	Align:"Center",	ColMerge:0,	SaveName:"imdg_un_no",       		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Float",	Hidden:0, 	Width:70,	Align:"Right",	ColMerge:0,	SaveName:"out_imdg_pck_qty1",		KeyField:0,	CalcLogic:"",	Format:"###,###,###.###",	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:50,	Align:"Center",	ColMerge:0,	SaveName:"out_imdg_pck_cd1",		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:150,	Align:"Left",	ColMerge:0,	SaveName:"eur_outr_pck_desc",  		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Float",	Hidden:0, 	Width:70,	Align:"Right",	ColMerge:0,	SaveName:"in_imdg_pck_qty1",		KeyField:0,	CalcLogic:"",	Format:"###,###,###.###",	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:50,	Align:"Center",	ColMerge:0,	SaveName:"in_imdg_pck_cd1",			KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:150,	Align:"Left",	ColMerge:0,	SaveName:"eur_inr_pck_desc",  		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:50,	Align:"Right",	ColMerge:0,	SaveName:"flsh_pnt_cdo_temp",		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:60,	Align:"Center",	ColMerge:0,	SaveName:"imdg_pck_grp_cd",    		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:60,	Align:"Center",	ColMerge:0,	SaveName:"eur_dcgo_mrn_polut_cd",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:60,	Align:"Center",	ColMerge:0,	SaveName:"imdg_lmt_qty_flg",   		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:60,	Align:"Center",	ColMerge:0,	SaveName:"hcdg_flg",				KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:80,	Align:"Center",	ColMerge:0,	SaveName:"ems_no",		    		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:80,	Align:"Left",	ColMerge:0,	SaveName:"mfag_no",		    		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Float",	Hidden:0, 	Width:90,	Align:"Right",	ColMerge:0,	SaveName:"net_wgt",					KeyField:0,	CalcLogic:"",	Format:"NullFloat",	PointCount:3,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Float",	Hidden:0, 	Width:90,	Align:"Right",	ColMerge:0,	SaveName:"grs_wgt",					KeyField:0,	CalcLogic:"",	Format:"NullFloat",	PointCount:3,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Float",	Hidden:0, 	Width:90,	Align:"Right",	ColMerge:0,	SaveName:"net_explo_wgt",			KeyField:0,	CalcLogic:"",	Format:"NullFloat",	PointCount:3,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:200,	Align:"Left",	ColMerge:0,	SaveName:"eur_pck_desc",			KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:200,	Align:"Left",	ColMerge:0,	SaveName:"prp_shp_nm",				KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:200,	Align:"Left",	ColMerge:0,	SaveName:"hzd_desc",				KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:80,	Align:"Left",	ColMerge:0,	SaveName:"brth_yd_cd",				KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:150,	Align:"Left",	ColMerge:0,	SaveName:"brth_yd_nm",				KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:100,	Align:"Left",	ColMerge:0,	SaveName:"xtd_stay_prmt_no",		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:150,	Align:"Left",	ColMerge:0,	SaveName:"diff_rmk",				KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:80,	Align:"Left",	ColMerge:0,	SaveName:"anr_fwrd_id",				KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:100,	Align:"Center",	ColMerge:0,	SaveName:"crr_dt",					KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:80,	Align:"Center",	ColMerge:0,	SaveName:"anr_spcl_tp_id",			KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:100,	Align:"Left",	ColMerge:0,	SaveName:"anr_crr_tp_cd",			KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:120,	Align:"Left",	ColMerge:0,	SaveName:"fdr_svc_rqst_no",			KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:100,	Align:"Left",	ColMerge:0,	SaveName:"fdr_vvd_id",				KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:200,	Align:"Left",	ColMerge:0,	SaveName:"fdr_vsl_nm",				KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:100,	Align:"Left",	ColMerge:0,	SaveName:"fdr_vsl_lloyd_no",		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:80,	Align:"Center",	ColMerge:0,	SaveName:"cgo_opr_cd",				KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:150,	Align:"Left",	ColMerge:0,	SaveName:"aply_no",					KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:100,	Align:"Center",	ColMerge:0,	SaveName:"upd_usr_id",				KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:130,	Align:"Center",	ColMerge:0,	SaveName:"upd_dt",					KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:1, 	Width:130,	Align:"Center",	ColMerge:0,	SaveName:"pol_cd",					KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:1, 	Width:130,	Align:"Center",	ColMerge:0,	SaveName:"pod_cd",					KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 }
						            ];
			   
						InitColumns(cols);
						
						SetEditable(0);
						SetCountPosition(0);
						SetSheetHeight(390);
						SetHighlightAfterSort(0);

	        		} else{
	        			var HeadTitle =	"Seq|Container|TP/SZ|Cell\nPosition|Class|UN No|Outer Package|Outer Package|Outer Package|Inner Package|Inner Package|Inner Package|Flash\nPoint/℃|Package\nGroup|" +
									   	"Marine\nPollutant|Limited\nquantity|High\nConsequence|EMS No|Mfag|Net\nWeight|Gross\nWeight|Net Exp\nWeight|" +
									   	"Package|Substance|Technical Name|Berth|Berth|Extended Stay\nPermit|Remark(s)|Cargo\nOperator|Reference|" +
									   	"User ID|Update Date";
						var HeadTitle2=	"Seq|Container|TP/SZ|Cell\nPosition|Class|UN No|Qty|Code|Desccription"                 +"|Qty|Code|Desccription"                 +"|Flash\nPoint/℃|Package\nGroup|" + 
									   	"Marine\nPollutant|Limited\nquantity|High\nConsequence|EMS No|Mfag|Net\nWeight|Gross\nWeight|Net Exp\nWeight|" +
									   	"Package|Substance|Technical Name|Code|Name|Extended Stay\nPermit|Remark(s)|Cargo\nOperator|Reference|" +
									   	"User ID|Update Date";
						
//						SetConfig( { SearchMode:0, MergeSheet:7, Page:20, FrozenCol:3, DataRowMerge:1 } );
						SetConfig( { SearchMode:0, MergeSheet:7, Page:20, FrozenCol:1, DataRowMerge:0 } );
						
						var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
						var headers = [ { Text:HeadTitle, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
						InitHeaders(headers, info);
						
						var cols = [ 	{Type:"Int",	Hidden:0, 	Width:40,  	Align:"Center",	ColMerge:1,	SaveName:"his_seq",        			KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
						             	{Type:"Text",	Hidden:0, 	Width:110,	Align:"Left",	ColMerge:1,	SaveName:"cntr_no",       			KeyField:0,	CalcLogic:"", 	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:50,	Align:"Center",	ColMerge:1,	SaveName:"cntr_tpsz_cd",  			KeyField:0,	CalcLogic:"", 	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:70,	Align:"Center",	ColMerge:1,	SaveName:"cell_psn_no",  			KeyField:0,	CalcLogic:"", 	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:60,	Align:"Center",	ColMerge:0,	SaveName:"imdg_clss_cd",      		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:60,	Align:"Center",	ColMerge:0,	SaveName:"imdg_un_no",       		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Float",	Hidden:0, 	Width:70,	Align:"Right",	ColMerge:0,	SaveName:"out_imdg_pck_qty1",		KeyField:0,	CalcLogic:"",	Format:"###,###,###.###",	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:50,	Align:"Center",	ColMerge:0,	SaveName:"out_imdg_pck_cd1",		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:150,	Align:"Left",	ColMerge:0,	SaveName:"eur_outr_pck_desc",  		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Float",	Hidden:0, 	Width:70,	Align:"Right",	ColMerge:0,	SaveName:"in_imdg_pck_qty1",		KeyField:0,	CalcLogic:"",	Format:"###,###,###.###",	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:50,	Align:"Center",	ColMerge:0,	SaveName:"in_imdg_pck_cd1",			KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:150,	Align:"Left",	ColMerge:0,	SaveName:"eur_inr_pck_desc",  		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:50,	Align:"Right",	ColMerge:0,	SaveName:"flsh_pnt_cdo_temp",		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:60,	Align:"Center",	ColMerge:0,	SaveName:"imdg_pck_grp_cd",    		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:60,	Align:"Center",	ColMerge:0,	SaveName:"eur_dcgo_mrn_polut_cd",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:60,	Align:"Center",	ColMerge:0,	SaveName:"imdg_lmt_qty_flg",   		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:60,	Align:"Center",	ColMerge:0,	SaveName:"hcdg_flg",				KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:80,	Align:"Center",	ColMerge:0,	SaveName:"ems_no",		    		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:80,	Align:"Left",	ColMerge:0,	SaveName:"mfag_no",		    		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Float",	Hidden:0, 	Width:90,	Align:"Right",	ColMerge:0,	SaveName:"net_wgt",					KeyField:0,	CalcLogic:"",	Format:"NullFloat",	PointCount:3,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Float",	Hidden:0, 	Width:90,	Align:"Right",	ColMerge:0,	SaveName:"grs_wgt",					KeyField:0,	CalcLogic:"",	Format:"NullFloat",	PointCount:3,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Float",	Hidden:0, 	Width:90,	Align:"Right",	ColMerge:0,	SaveName:"net_explo_wgt",			KeyField:0,	CalcLogic:"",	Format:"NullFloat",	PointCount:3,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:200,	Align:"Left",	ColMerge:0,	SaveName:"eur_pck_desc",			KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:200,	Align:"Left",	ColMerge:0,	SaveName:"prp_shp_nm",				KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:200,	Align:"Left",	ColMerge:0,	SaveName:"hzd_desc",				KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:80,	Align:"Left",	ColMerge:0,	SaveName:"brth_yd_cd",				KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:150,	Align:"Left",	ColMerge:0,	SaveName:"brth_yd_nm",				KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:100,	Align:"Left",	ColMerge:0,	SaveName:"xtd_stay_prmt_no",		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:150,	Align:"Left",	ColMerge:0,	SaveName:"diff_rmk",				KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:80,	Align:"Center",	ColMerge:0,	SaveName:"cgo_opr_cd",				KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:150,	Align:"Left",	ColMerge:0,	SaveName:"aply_no",					KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:100,	Align:"Center",	ColMerge:0,	SaveName:"upd_usr_id",				KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:0, 	Width:130,	Align:"Center",	ColMerge:0,	SaveName:"upd_dt",					KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:1, 	Width:130,	Align:"Center",	ColMerge:0,	SaveName:"pol_cd",					KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
								       	{Type:"Text",	Hidden:1, 	Width:130,	Align:"Center",	ColMerge:0,	SaveName:"pod_cd",					KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 }
						            ];
						   
						InitColumns(cols);
						
						SetEditable(0);
						SetCountPosition(0);
						SetSheetHeight(390);
						SetHighlightAfterSort(0);
	        		}
	        	}

		    break;
		}
	}
    // handling sheet process
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
      	    case IBSEARCH: 
    			if(!validateForm(sheetObj,formObj,sAction))return;
      	    	formObj.f_cmd.value=SEARCH;
      			var sXml= sheetObj.GetSearchData("ESM_BKG_1605GS.do", FormQueryString(formObj));
      			var rowCount = ComGetEtcData(sXml, "rowCount");
      			sheetObj.LoadSearchData(sXml, {Sync:1});
      	    	if(sheetObj.RowCount() > 0){
      	    		formObj.pol_cd.value=sheetObj.GetCellValue(2,"pol_cd");
      	    		formObj.pod_cd.value=sheetObj.GetCellValue(2,"pod_cd");
      	    	}else{
          	    	formObj.pol_cd.value="";
          	    	formObj.pod_cd.value="";      	    		
      	    	}
                break;	
        }
    }
 

	function obj_change() {
		var formObject=document.form;
		var srcName=ComGetEvent("name");
		var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
		var srcValue=window.event.srcElement.getAttribute("value");
		switch(srcName) {
			case "d_type_radio":
				formObject.eur_dg_decl_tp_cd.value=srcValue;
				break;
		}
	}
	
	
	function changeDeclareRadio() {
		var formObject=document.form;
		var dType=formObject.eur_dg_decl_tp_cd.value;
		if (dType == "D" || dType == "") {
			formObject.d_type_radio[0].checked= true;
		} else if (dType == "T") {
			formObject.d_type_radio[1].checked= true;
		} else if (dType == "L") {
			formObject.d_type_radio[2].checked= true;
		}
	}
	
	/**
	 * Check before action
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
			case IBSEARCH :
				if(formObj.eur_dg_decl_tp_cd.value==""){
					ComShowCodeMessage("BKG95031", "Declaration Type");
					return false;
				}
				if(formObj.vvd_cd.value==""){
					ComShowCodeMessage("BKG00887", "VVD");
					ComSetFocus(formObj.vvd_cd);
					return false;
				}
				if(formObj.port_cd.value==""){
					ComShowCodeMessage("BKG00887", "Port");
					ComSetFocus(formObj.port_cd);
					return false;
				}
				if(formObj.bl_no.value==""){
					ComShowCodeMessage("BKG00887", "B/L No.");
					ComSetFocus(formObj.bl_no);
					return false;
				}
				if(formObj.cntr_no.value==""){
					ComShowCodeMessage("BKG00887", "Container No.");
					ComSetFocus(formObj.cntr_no);
					return false;
				}

				break;
		}
		return true;
	}
	
	function changeDeclareCheckBox() {
		var formObj=document.form;
		var dType=formObj.eur_dg_decl_tp_cd.value;
		if(dType.indexOf("D")>=0){
			formObj.d_type1.checked=true;
		}
		if(dType.indexOf("T")>=0){
			formObj.d_type2.checked=true;
		}
		if(dType.indexOf("L")>=0){
			formObj.d_type3.checked=true;
		}
		if(dType.indexOf("P")>=0){
			formObj.d_type4.checked=true;
		}
		if(dType.indexOf("O")>=0){
			formObj.d_type5.checked=true;
		}
	}
	
	/**
	 * returning selected declaration field value
	 * 
	 * @return
	 */
	function declarationCheckValue() {
		var formObj=document.form;
		var retVal="";
		for ( var i=1; i <= 5; i++) {
			var dTypeFlag = "formObj.d_type" + i + ".checked";		
			var dTypeValue = "formObj.d_type" + i + ".value";
			if (eval(dTypeFlag)) {
				retVal += eval(dTypeValue);
			}
		} // end for(i)
		return retVal;
	}
	/**
	 * checking Validation of Declaration 
	 * @return
	 */
	function dTypeCheckValidate(dTypeVal, srcName) {
		var formObj=document.form;
		//alert("srcName : " + srcName + "\ndTypeVal : " + dTypeVal);
		switch (srcName) {
			case "d_type1" :	// Discharging 
				switch (dTypeVal) {
					case "DT" :
					case "DL" :
					case "DP" :
					case "DLP" :
						formObj.d_type1.checked=false;
				}
				break;
			case "d_type2" : 	// Transit
				switch (dTypeVal) {
					case "DT" :
					case "TL" :
					case "TP" :
					case "TO" :
					case "TLP" :
					case "DTO" :
						formObj.d_type2.checked=false;
				}
				break;
			case "d_type3" : 	// Loading
				switch (dTypeVal) {
					case "DL" :
					case "TL" :
					case "LO" :
					case "DLO" :
						formObj.d_type3.checked=false;
				}
				break;
			case "d_type4" : 	// Pre-Carriage
				switch (dTypeVal) {
					case "DP" :
					case "TP" :
					case "PO" :
					case "DPO" :
						formObj.d_type4.checked=false;
				}
				break;
			case "d_type5" : 	// On-Carriage
				switch (dTypeVal) {
					case "TO" :
					case "LO" :
					case "PO" :
					case "LPO" :
						formObj.d_type5.checked=false;
				}
				break;
			default : 
				formObj.d_type1.checked=false;
				break;
		} // end switch
	}

