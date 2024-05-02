/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0126.js
*@FileTitle  : JO TPB Invoice Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
    /* Global Variables */
    //var calPop = new calendarPopupGrid();
    var curTab=1;
    var beforetab=0;
    var sheetObjects=new Array();
    var tabObjects=new Array();
    var sheetCnt=0;
    var tabCnt=0;
    /**
	 * Setting IBTab Object Initial.
	 * Tab ID is tab1,tab2,...
	 * InitTab() function is called before the loadPage() function call from setupPage() function.
	 */
  	function InitTab() {
  		try{
  			with(document.all.tab1){
				InsertItem( "Dry Index" , "");
				InsertItem( "Tanker Index" , "");
				InsertItem( "Time Charter" , "");
				InsertItem( "Bunker Price" , "");
				InsertItem( "Ship Price" , "");
				InsertItem( "FFA Index" , "");
  			}
  		}catch(e){
  			ComShowMessage(e.message);
  		}
  	}
  	/**
  	 * onChange event of tab1
  	 * Implementing defined function from IBSheetConfig.js
  	 */
  	function tab1_OnChange(nItem){
  		ChangeTab(document.all.tab1,nItem);
  	}
  	/**
  	 * Showing tab contents in case of clicking IBTab Object
  	 * ID of Grouped each tab DIV TAG defined "tabLayer"
  	 */
  	function ChangeTab(tabObj,nItem){
  		var tabObj=document.all.tab1;
		var nItem=0;
		tabObj.SetBackColor("#FFFFFF");
		beforetab=nItem;
  	}
  	/**
  	 * Register as an IBSheet Object array
  	 * This is called from comSheetObject(id)
  	 * Process can add in case of future necessity to process other items
  	 * Array defined at the top of the source
  	 */
  	function setSheetObject(sheet_obj){
  		sheetObjects[sheetCnt++]=sheet_obj;
  	}
  	function setTabObject(tab_obj){
 		tabObjects[tabCnt++]=tab_obj;	
 	}
  	/**
  	 * Initializing sheet
  	 * To implement onLoad event of body tag
  	 * Add functionality to after loading screen.
  	 */
  	function loadPage() {
  		for(i=0;i<sheetObjects.length;i++){
  		   //Setting startup environment. Change the name of the function
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//Setting final environment.
  			ComEndConfigSheet(sheetObjects[i]);
  			sheetObjects[i].SetVisible(0);
  		}
  		getCurrencyList(sheetObjects[0]);
		ComOpenWait(true);
  		//Retrieving hidden sheet the billing case info of n3pty_no
  		doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,IBSEARCH);
  		ComOpenWait(false);
  	}
  	/**
  	 * Initializing sheet. Defining header
  	 * param : sheetObj ==> sheet object, sheetNo ==> sheet No.
  	 * Composition a initial module in case of multi sheet
  	 */
  	function initSheet(sheetObj,sheetNo) {
  		sheetObj.UseUtf8=true;
  		//switch(sheetNo) {
  			//case 1:	  //IBSheet1 init
  			if(sheetNo != sheetObjects.length){ 
  			    with(sheetObj){
  			    	      var cnt=0;
  			    	      var HeadTitle="Seq.|TPB No.|Billing Case|Billing Case Name|EQ Kind|EQ No.|TP/SZ|BKG No.|B/L No.|VVD|VVD|MG Set No.|Location|Route|New EQ No.|New Seal No.|Citation No.|Weight|UOM|Waiting Time(Hr)|Occured Date|New VVD|New BKG No.|Damaged Date|Repair Location|Last Free Date|Pick-up Date|Over Day|CSR No.|GL Date|Original AMT|Invoice AMT||||||||||||||||||||||||VAT|VAT AMT";
  			    	      sheetNo="";

  			    	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

  			    	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
  			    	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
  			    	      InitHeaders(headers, info);

  			    	      var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
  			    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"n3pty_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  			    	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"n3pty_bil_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  			    	             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"n3pty_bil_tp_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  			    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"eq_knd_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  			    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"eq_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  			    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"eq_tpsz_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  			    	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"bkg_no_all",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  			    	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"bl_no_all",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  			    	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"vvd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"vvd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  			    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"mgset_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"yd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  			    	             {Type:"Text",      Hidden:0,  Width:230,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"route",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  			    	             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"new_eq_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
  			    	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"new_cntr_seal_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
  			    	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"cita_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
  			    	             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"cntr_wgt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
  			    	             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"n3pty_cntr_wgt_ut_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
  			    	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"wt_hrs",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
  			    	             {Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"occr_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"new_vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
  			    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"new_bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
  			    	             {Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"damage_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"repair_location",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"lst_free_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"pkup_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ft_ovr_dys",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"csr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"gl_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  			    	             {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"ots_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  			    	             {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"inv_dtl_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:17 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"eq_knd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"fm_nod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"via_nod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"to_nod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dor_nod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"bkg_no_split",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"bl_no_tp",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"bl_no_chk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"vsl_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"skd_voy_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"skd_dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"estm_svr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"original_inv_dtl_amt", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"so_if_seq",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"lgs_cost_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"acct_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"so_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"finc_dir_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"rev_amt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ots_dtl_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			    	             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ibflag" },
  			    	             {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"vat_dtl_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
  			    	             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"vat_dtl_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:17 } ];
  			    	       
  			    	      InitColumns(cols);

  			    	      SetEditable(1);
  			    	      SetImageList(0,"/opuscntr/img/opus/button/btns_calendar.gif");
		    	          SetColProperty(sheetNo+"n3pty_cntr_wgt_ut_cd", {ComboText:combo01Text, ComboCode:combo01Code} );
		    	          SetSheetHeight(120);
		    	          //no support[check again]CLT 					PopupButtonImage(0, sheetNo+"lst_free_dt")=0; //last_free_dt
  			    	      //no support[check again]CLT 					PopupButtonImage(0, sheetNo+"pkup_dt")=0; //pick_up_dt
  			    	      //no support[check again]CLT 					PopupButtonImage(0, sheetNo+"occr_dt")=0; //occur_dt
  			    	      //no support[check again]CLT 					PopupButtonImage(0, sheetNo+"damage_dt")=0; //damage_dt
		    	      }

  			}else{
  				//break;
  			//case 2:	  //IBSheet2 init
  			    with(sheetObj){
  			        var cnt=0;
  			        var HeadTitle="Seq.|3rd Party No|Billing Case|Billing Case Name|EQ Kind|EQ No.|TP/SZ|BKG No.|B/L No.|MG Set No.|VVD|Location|Route|Citation No.|Weight|UOM|Waiting Time(Hr)|Occured Date|New VVD|New BKG No.|Damaged Date|Repair Location|Last Free Date|Pick-up Date|Over Day|New EQ No.|New Seal No.|OTS AMT|Invoice AMT||||||||||||||||||||||||VAT|VAT AMT";
  			        sheetNo="";

  			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

  			        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
  			        var headers = [ { Text:HeadTitle, Align:"Center"} ];
  			        InitHeaders(headers, info);

  			        var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"seq" },
  			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"n3pty_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"n3pty_bil_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"n3pty_bil_tp_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"eq_knd_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"eq_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"eq_tpsz_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"bkg_no_all",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"bl_no_all",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"vvd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"vvd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"mgset_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"yd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"route",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"new_eq_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"new_cntr_seal_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Date",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"cita_no",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Date",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"cntr_wgt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"n3pty_cntr_wgt_ut_cd", KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"wt_hrs",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Date",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"occr_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Popup",     Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"new_vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"new_bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Date",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"damage_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Popup",     Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"repair_location",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Date",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"lst_free_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Date",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"pkup_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"ft_ovr_dys",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"csr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"gl_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  			             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"ots_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"inv_dtl_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"eq_knd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"fm_nod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"via_nod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"to_nod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"dor_nod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"bkg_no_split",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"bl_no_tp",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"bl_no_chk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"vsl_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"skd_voy_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"skd_dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"estm_svr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"original_inv_dtl_amt", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"so_if_seq",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"lgs_cost_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"acct_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"so_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"finc_dir_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"rev_amt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ots_dtl_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ibflag" },
  			             {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"vat_dtl_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
  			             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"vat_dtl_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:17 } ];
  			       
  			        InitColumns(cols);

  			        SetEditable(0);
  			        SetSheetHeight(120);
  			            }


  				//break;
  		}
  	}
  	/* Event handler defined process to button click event */
  	document.onclick=processButtonClick;
  	/* Event handler is branch processing by name of button */
  	function processButtonClick(){
  		 /***** Assignment sheet in case of over 2 by tab ****/
  		 var sheetObject=sheetObjects[curTab-1];
  		 /******************************************************/
  		 var formObject=document.form;
  		 if(curTab == 2)
  			formObject=document.form2;
  		try {
  			var srcName=ComGetEvent("name");
  			switch(srcName) {
  				case "bttn_add":
  					doActionIBSheet(sheetObject,formObject,IBINSERT);
  					break;
  				case "bttn_cancel":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "bttn_save":
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
  					break;
  				case "bttn_remove":
  					break;
  				case "btn_preview":
  					if(formObject.s_n3pty_inv_no.value == ''){
  						ComShowCodeMessage("COM12150","Invoice","","");
  						return;
  					}
					var s_dao_n3pty_bil_tp_cd=formObject.s_dao_n3pty_bil_tp_cd.value;
					var s_n3pty_inv_no=formObject.s_n3pty_inv_no.value;
					var s_n3pty_inv_his_seq=formObject.s_n3pty_inv_his_seq.value;
					var s_n3pty_inv_rmd_cd=formObject.s_n3pty_inv_rmd_cd.value;
					openInvoicePreviewPopupWin(formObject, s_dao_n3pty_bil_tp_cd, s_n3pty_inv_no, s_n3pty_inv_his_seq, s_n3pty_inv_rmd_cd);
  					break;
  				case "bttn_excel":
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "bttn_print":
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "bttn_search":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btn_confirm":
  					if(document.form.btn_confirm.disabled){
  						ComShowCodeMessage('TPB90010','Confirm ','','');
  					}else{
      				    var tot_amt=ComGetUnMaskedValue(document.form.s_total_amt.value,"float");
      				    if ( tot_amt < 0.00 ) {
      				        ComShowCodeMessage('TPB90033','Total Amount','0.00');
      				    } else {
            				doActionIBSheet(sheetObject,formObject,IBSAVE);
      				    }
  					}
  					break;
//  				case "btn_revisiondetail":
//  				    gotoRevisionDetail();
//  					break;
  				case "btn_invoicesheetset":
  					openInvoiceSheetSetPopupWin(formObject);
  					amtReCalculate();
  					break;
  				case "btn_erpInterface":
  					if( ComShowConfirm(ComGetMsg("TPB90008","","","")) ){	
  						doActionIBSheet(sheetObject,formObject,ADD);
  					}					
  					break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowCodeMessage('COM12111');
  			} else {
  				ComShowMessage(e.message);
  			}
  		}
  	}
  	/* Processing Sheet */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg(false);
  		switch(sAction) {
  		   case IBSEARCH:	  //Retrieve
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				//Retrieving hidden sheet
  				formObj.f_cmd.value=SEARCH;
   				var x=sheetObj.GetSearchData("ESD_TPB_0126GS.do", tpbFrmQryStr(formObj));
  				sheetObj.LoadSearchData(x,{Sync:1} );
  				//Showing sheet of billing case by category
  				var bilArr=tpb_getBillingCase(sheet0);	//Billing case array
  				tpb_makeTabLoad(formObj, sheetObjects, bilArr[0], x);
  				//Saving strings separated by ',' of n3pty_bil_tp_cd
  				formObj.s_dao_n3pty_bil_tp_cd.value=bilArr[1].join("','");
  				//Setting currency value in case of the initial screen
  				if(document.form.s_from_curr_cd.value == ""){
  					document.form.s_from_curr_cd.value=document.form.s_curr_cd.value;
  				}else{
  					//in case of changed currency
  					if(document.form.s_from_curr_cd.value != ""){
  						for(var i=0;i<sheetObjects.length-1;i++){
  							for(var j=1;j<=sheetObjects[i].RowCount();j++){
  								sheetObjects[i].SetRowStatus(j,"U");
  							}
  						}
  						//Re-calculation VAT
  						var sumInvAmt=sheetObj.ComputeSum("|31|");
  						//tpb_vatAmountReCalculate(sumInvAmt);
  						amtReCalculate();
  					}
  				}
  				break;
  			case IBSAVE:		//Save
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				if(formObj.s_curr_cd.value == ""){
  					ComShowCodeMessage("COM12113","Currency","","");
  					return false;
  				}
  				//Total Amt(KRW, JPY, VND) must be an integer
  				if( (formObj.s_curr_cd.value == "KRW" || formObj.s_curr_cd.value == "JPY" || formObj.s_curr_cd.value == "VND") ){
  					var totAmt=ComGetUnMaskedValue(formObj.s_total_amt.value,"float");
  					if(parseFloat(totAmt) - parseInt(totAmt) > 0){
  						ComShowCodeMessage("TPB90024","","","");
  						return false;
  					}
  				}
  				//checking the existence of a Invoice Sheet Set
  				if(document.form.s_sheet_set_count.value < 1){
  					//ComShowCodeMessage("COM12150","Invoice Sheet Set","","");
  					alert('JO TPB Invoice Settings is not setup for this office, \nplease update settings before confirmation');
  					return;
  				}
  				if( ComShowConfirm(ComGetMsg("TPB90055")) ){	
  					var s_h_vndr_cust_div_cd=formObj.s_h_vndr_cust_div_cd.value;
  					var s_trd_party_code=formObj.s_trd_party_code.value;
  					//Calculating total SaveString of all sheet and Invoice Amount of all sheet
  					var sum_save_string="";
  					var sum_inv_amt=0;
  					for(var i=0;i<sheetObjects.length-1;i++){
  						for(var j=1;j<=sheetObjects[i].RowCount();j++){
  							var tmp_ots_amt=parseFloat(sheetObjects[i].GetCellValue(j, 30)); //ots_amt
  							var tmp_inv_dtl_amt=parseFloat(sheetObjects[i].GetCellValue(j, 31)); //inv_dtl_amt
  							// Checking OTS_AMT > INV_AMT
  							if( tmp_inv_dtl_amt > 0 ){
  								if(tmp_ots_amt < tmp_inv_dtl_amt){
//  									ComShowCodeMessage("COM12133","Invoice Amout","OTS AMT","small value");
//  									return false;
  								}
  							}
  							//ComShowMessage(sheetObjects[i].id+','+tmp_inv_dtl_amt+','+sheetObjects[i].CellValue(j, 31));// Changed From 28 To 31 By O Wan-Ki In 2007-08-14
  							sum_inv_amt += tmp_inv_dtl_amt;
  						}
  						sum_save_string += sheetObjects[i].GetSaveString();
  						sum_save_string += "&";
  					}
  					formObj.s_sum_inv_amt.value=ComGetUnMaskedValue(document.form.s_total_amt.value,"float");
  					// ComShowMessage('sum='+formObj.s_sum_inv_amt.value); //return;
                      // TOTAL INVOICE AMOUNT CHECK -----  
  					var sum_inv_amt=formObj.s_sum_inv_amt.value;
  					try {
  					    sum_inv_amt=sum_inv_amt - 0.00;
  					} catch (e){
  					    ComShowCodeMessage('COM12111');
  					    return;
  					}
  					if ( sum_inv_amt <= 0.0 ){
  					    ComShowCodeMessage('TPB90035', 'Total Amount ', '0.00 ');
  					    return;
  					}
//  					if( document.form.cnt_cd.value == 'IN'&& (document.form.indiaTaxForm.value == "Y" ){
//						if (document.form.lst_tax.value.length != 0 ){
//							document.form.s_vat_amt.value=ComGetUnMaskedValue(document.form.lst_tax.value,"float") ;
//						}
//					}else{
						document.form.s_ida_tax_seq.value="0";
//					}
  					// ComShowMessage( " final sum_inv_amt ; " + sum_inv_amt );  return;
  					// / TOTAL INVOICE AMOUNT CHECK -----  
  					formObj.f_cmd.value=MULTI;
   					var sXml=sheetObjects[sheetObjects.length-1].GetSaveData("ESD_TPB_0126GS.do", sum_save_string + tpbFrmQryStr(formObj));
   					sheetObjects[sheetObjects.length-1].LoadSaveData(sXml);
  				}
  				break;
  			case ADD: //ERP I/F
  				formObj.f_cmd.value=ADD;
  				div_processing_show(); // show processing image
   				var sXml=sheetObjects[sheetObjects.length-1].GetSaveData("ESD_TPB_0126GS.do", tpbFrmQryStr(formObj));
   				sheetObjects[sheetObjects.length-1].LoadSaveData(sXml);
  				div_processing_hide(); // hide processing image
  				break;
  			case IBINSERT:	  //Insert
  				var Row=sheetObj.DataInsert();
  				break;
  			case IBCLEAR:	   //Clear
  				sheetObj.RemoveAll();
  				break;
  			case IBDOWNEXCEL:  //Excel download
  				sheetObj.Down2Excel(TPBDown2ExcelOptions);
  				break;
  		}
  	}
  	/**
  	 * Checking validation of input value
  	 */
  	function validateForm(sheetObj,formObj,sAction){
  		with(formObj){
  			if(!ComChkValid(formObj)) return false;
  		}
  		return true;
  	}
  	/**
  	 * Processing function in case of error to result of retrieve
  	 * Defined by DataSheetObject.prototype.event_OnSearchEnd
  	 */
  	function sheet0_OnSearchEnd(sheetObj,errMsg){
  		var formObj=document.form;
  		//ComEtcDataToForm(document.form, sheetObj);
  		formObj.s_bil_loc.value=sheetObj.GetEtcData("s_bil_loc");
		formObj.s_phn_no.value=sheetObj.GetEtcData("s_phn_no");
		formObj.s_vndr_cnt_cd.value=sheetObj.GetEtcData("s_vndr_cnt_cd");
		//formObj.s_vndr_cust_addr2.value = sheetObj.EtcData("s_vndr_cust_addr2");
		formObj.s_cust_seq.value=sheetObj.GetEtcData("s_cust_seq");
		formObj.s_sheet_set_count.value=sheetObj.GetEtcData("s_sheet_set_count");
		formObj.s_trd_party_code_detail.value=sheetObj.GetEtcData("s_trd_party_code_detail");
		formObj.s_vat_xch_rt.value=sheetObj.GetEtcData("s_vat_xch_rt");
		//formObj.tax_rgst_no.value = sheetObj.EtcData("tax_rgst_no");
		//formObj.svc_cate_rmk.value = sheetObj.EtcData("svc_cate_rmk");
		//formObj.pmnt_acct_no.value = sheetObj.EtcData("pmnt_acct_no");
		formObj.s_vndr_cust_nm.value=sheetObj.GetEtcData("s_vndr_cust_nm");
		if(ComParseInt(sheetObj.GetEtcData("length_n3pty_bil_tp_cd"))>0){
			formObj.s_length_n3pty_bil_tp_cd.value=sheetObj.GetEtcData("length_n3pty_bil_tp_cd");
		}
		//formObj.high_edu_tax.value = sheetObj.EtcData("high_edu_tax");
		//formObj.edu_tax.value = sheetObj.EtcData("edu_tax");
		formObj.s_vndr_cust_addr.value=sheetObj.GetEtcData("s_vndr_cust_addr");
		formObj.s_curr_cd.value=sheetObj.GetEtcData("s_curr_cd");
		formObj.prcs_cnt.value=sheetObj.GetEtcData("s_prcs_cnt");
		formObj.s_fax_no.value=sheetObj.GetEtcData("s_fax_no");
		formObj.s_vndr_seq.value=sheetObj.GetEtcData("s_vndr_seq");
		formObj.s_cust_cnt_cd.value=sheetObj.GetEtcData("s_cust_cnt_cd");
		// s_ida_tax_seq  <==  ida_tax_seq
		//formObj.s_ida_tax_seq.value = sheetObj.EtcData("ida_tax_seq");
		formObj.s_ida_tax_seq.value="0";
		//formObj.expn_tax.value = sheetObj.EtcData("expn_tax");
		formObj.s_vndr_cust_eml.value=sheetObj.GetEtcData("s_vndr_cust_eml");
		formObj.s_rgst_no.value=sheetObj.GetEtcData("s_rgst_no");
		/*
		if(formObj.indiaTaxForm.value == "Y"){
			document.getElementById('tax_rgst_no_text').innerText=sheetObj.GetEtcData("tax_rgst_no");
    		document.getElementById('svc_cate_rmk_text').innerText=sheetObj.GetEtcData("svc_cate_rmk");
    		document.getElementById('pmnt_acct_no_text').innerText=sheetObj.GetEtcData("pmnt_acct_no");
			document.getElementById('expn_tax_text').innerText=sheetObj.GetEtcData("expn_tax");
			document.getElementById('edu_tax_text').innerText=sheetObj.GetEtcData("edu_tax");
			document.getElementById('high_edu_tax_text').innerText=sheetObj.GetEtcData("high_edu_tax");
		}
		*/
  		var s_rhq_cd=sheetObj.GetEtcData("s_rhq_cd");
  		//Possible to VAT No. input in case of only EU region
  		// ComShowMessage(s_rhq_cd);
  		//if(s_rhq_cd == "HAMUR"){ // HAMHQ => HAMUR
  		if(OfficeCodeMgr.checkContainOfficeCode('000006','TPB',s_rhq_cd)){
  			document.form.s_rgst_no.readOnly=false;
  			document.form.s_rgst_no.className="";
  		}else{
  			document.form.s_rgst_no.readOnly=true;
  			document.form.s_rgst_no.className="noinput";
  		}
  		//Calculating VAT
  		var sumInvAmt=sheetObj.ComputeSum("|31|");
  		tpb_vatAmountReCalculate(sumInvAmt);
  	}
  	/**
  	 * Defined by DataSheetObject.prototype.event_OnSaveEnd
  	 */
  	function sheet0_OnSaveEnd(sheetObj,errMsg){
  		if(errMsg==null || errMsg == ''){
              if(document.form.f_cmd.value == MULTI){
      			//Initializing currency
      			document.form.s_from_curr_cd.value="";
                //Setting input form after process
      			ComEtcDataToForm(document.form, sheetObj);
          		//After process 
          		var tpb_no=document.all.s_n3pty_inv_no.value;
          		if ( tpb_no!=undefined && tpb_no.length==11 ){ //in case of normally process
              		//document.all.btn_confirm_t.disabled = true;
                    btn_confirm.style.display="none";
                    btn_erpInterface.style.display="";
          		}
      			ComShowCodeMessage('COM12149','Invoice','','');
  			} else if(document.form.f_cmd.value == ADD){
                btn_erpInterface.style.display="none";
  				ComShowCodeMessage('COM12149','AR Interface','','');
  			}
  		} else {
  		    ComShowMessage(errMsg);
  		}
  	}
  	//Loading Tab data
  	function tpb_makeTabLoad(formObj, sheetObjects, bilArr, x){
  		for(var i=0;i<sheetObjects.length-1;i++){
  			//Setting TAB title
  			//document.getElementById("tab_title"+(i+1)).innerHTML = bilArr[i];
  			//Data load
  			var title=bilArr[i];
  			if(formObj.load_num.value == "0"){
				tabObjects[i].InsertItem( title, "");
			}
  			sheetObjects[i].LoadSearchData(x,{Sync:1} );
  			//Removing different n3pty_bil_tp_cd by TAB
  			for(var j=1;j<=sheetObjects[i].RowCount();j++){
  				if(sheetObjects[i].GetCellValue(j, 3) != bilArr[i]){   //n3pty_bil_tp_nm
  					sheetObjects[i].RowDelete(j, false);
  					--j;
  				}
  				if(j != 0 ) sheetObjects[i].SetCellValue(j, 0,j);//seq
  				sheetObjects[i].SetTotalRows(j);//Setting Row count
  				//Checking  Auto Upate of Outstanding Amount
  				tpb_chgColor_ots_amt(sheetObjects[i], 44, 27, j);
  				sheetObjects[i].SetVisible(1);
  			}
  			//Setting different form by Billing Case Code
  			tpb_setSheetByBillingCase(sheetObjects[i], sheetObjects[i].GetCellValue(1, 2), i+1);  //n3pty_bil_tp_cd
  		}
  		formObj.load_num.value="1";
  	}
  	//Getting duplicated array of Billing case
  	function tpb_getBillingCase(sheetObject){
  		var bilArrNm=new Array(); //Billing case Name array
  		var bilArrCd=new Array(); //Billing case CD array
  		for(var i=1;i<=sheetObject.RowCount();i++){
  			bilArrNm[bilArrNm.length]=sheetObject.GetCellValue(i, 3);  //n3pty_bil_tp_nm
  			bilArrCd[bilArrCd.length]=sheetObject.GetCellValue(i, 2);  //n3pty_bil_tp_cd
  		}
  		for(var i=0;i<bilArrNm.length;i++){
  			var dbl=0;
  			for(var j=0;j<bilArrNm.length;j++){
  				if(bilArrNm[i] != bilArrNm[j]){
  					continue;
  				}else{
  					dbl++;
  					if(dbl>1){
  						bilArrNm.splice(j,1);
  						bilArrCd.splice(j,1);
  						j--;
  					}
  				}
  			}
  		}
  		return new Array(bilArrNm,bilArrCd);
  	}
  	
  	
  	/**
	 * IBSheet 개체 Cell의 입력값을 onchange 이벤트 발생시에 대문자로 변환하는 함수 (extends CoTpb.js) 
	 * @param : sheet object
	 * @param : Row
	 * @param : Col
	 */	
	function _sheet_onchange() { /// sheetObj, Row, Col
		var argv=_sheet_onchange.arguments;
		var argc=argv.length; 
		var sheetObj=argv[0];
		if ( argc > 0 && sheetObj!=undefined && sheetObj!=null ) {
			var Row=argv[1];
			var Col=argv[2];
			if ( Row!=undefined && Row!=null && Row >=0 && Col!=undefined && Col!=null && Col >=0 ) {
				if ( !_exceptCheck("sheet", sheetObj.ColSaveName(Col) ) ) {
		if ( sheetObj.GetCellProperty(0, sheetObj.ColSaveName(Col), dpDataType)  == dtData ) {
			sheetObj.SetCellValue(Row, Col, ( isNaN(sheetObj.GetCellValue(Row, Col)) ? sheetObj.GetCellValue(Row, Col).toUpperCase() : sheetObj.GetCellValue(Row, Col)) ,0);
					}
				}
			}
		}
		argv=null;
	}
  	
  	function changeCurrency(val){
  		doActionIBSheet(sheetObjects[sheetObjects.length-1], document.form, IBSEARCH);
  	}
//  	
//  	function s_curr_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode)
//  	{
//  		doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,IBSEARCH)
//  		form.s_curr_cd_text.value = comboObj.GetText(parseInt(newindex), 0);
//	}
  	
  	// show processing image 
  	function div_processing_show(){
  		div_processing.style.display=" "; 
  		// setTimeout("div_processing_hide();", 1000);
  	}
  	// hide processing image 
  	function div_processing_hide(){
  		div_processing.style.display='none'; 
  	}	
  	//Setting dirrrent form by Billing Case Code
  	function tpb_setSheetByBillingCase(sheetObj, cd, idx){
  		idx="";
  		//cd = prompt('TL/ST/DR/OW/FU/CI/RO/RH/CP/BB/FL/AW \nVD/GD/TR/CY/JO/RF/DG/SL/CC/WT/CD/ZD/CH/EE');
  		switch(cd){
  			case "TL":
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"yd_cd",1);//yd_cd
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"occr_dt",1);//occur_dt
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  			case "ST":
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_cntr_seal_no
  				sheetObj.SetColHidden(idx+"route",1);//route
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"occr_dt",1);//occur_dt
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  			case "DR":
  				sheetObj.SetColHidden(idx+"yd_cd",1);//yd_cd
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_seal_no
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"occr_dt",1);//occur_dt
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  			case "OW":
  				sheetObj.SetColHidden(idx+"yd_cd",1);//yd_cd
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_seal_no
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"occr_dt",1);//occur_dt
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  			case "FU":
  				sheetObj.SetColHidden(idx+"route",1);//route
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_seal_no
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  			case "CI":
  				sheetObj.SetColHidden(idx+"route",1);//route
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_seal_no
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"occr_dt",1);//occur_dt
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  			case "RO":
  				sheetObj.SetColHidden(idx+"route",1);//route
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_seal_no
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"occr_dt",1);//occur_dt
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  			case "RH":
  				sheetObj.SetColHidden(idx+"route",1);//route
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_seal_no
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"occr_dt",1);//occur_dt
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  			case "CP":
  				sheetObj.SetColHidden(idx+"route",1);//route
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_seal_no
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"occr_dt",1);//occur_dt
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  			case "BB":
  				sheetObj.SetColHidden(idx+"route",1);//route
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_seal_no
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"occr_dt",1);//occur_dt
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  			case "FL":
  				sheetObj.SetColHidden(idx+"route",1);//route
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_seal_no
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"occr_dt",1);//occur_dt
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  			case "AW":
  				sheetObj.SetColHidden(idx+"route",1);//route
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_seal_no
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"occr_dt",1);//occur_dt
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  			case "VD":
  				sheetObj.SetColHidden(idx+"eq_knd_nm",1);//eq_knd_nm
  				sheetObj.SetColHidden(idx+"eq_no",1);//eq_no
  				sheetObj.SetColHidden(idx+"eq_tpsz_cd",1);//eq_tpsz_cd
  				sheetObj.SetColHidden(idx+"bkg_no_all",1);//bkg_no_all
  				sheetObj.SetColHidden(idx+"bl_no_all",1);//bl_no_all
  				sheetObj.SetColHidden(idx+"route",1);//route
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_seal_no
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"occr_dt",1);//occur_dt
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  			case "GD":
  				sheetObj.SetColHidden(idx+"bkg_no_all",1);//bkg_no_all
  				sheetObj.SetColHidden(idx+"bl_no_all",1);//bl_no_all
  				sheetObj.SetColHidden(idx+"vvd",1);//vvd
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"route",1);//route
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_seal_no
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"occr_dt",1);//occur_dt
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  			case "TR":
  				sheetObj.SetColHidden(idx+"yd_cd",1);//yd_cd
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_seal_no
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"occr_dt",1);//occur_dt
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  			case "CY":
  				sheetObj.SetColHidden(idx+"route",1);//route
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_seal_no
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"occr_dt",1);//occur_dt
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  			case "JO":
  				sheetObj.SetColHidden(idx+"bkg_no_all",1);//bkg_no_all
  				sheetObj.SetColHidden(idx+"bl_no_all",1);//bl_no_all
  				sheetObj.SetColHidden(idx+"route",1);//route
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_seal_no
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"occr_dt",1);//occur_dt
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
//  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no 
  				sheetObj.SetColHidden(idx+"vvd",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",0);//vvd_cd (actual vvd)
//  				for(var i=1;i<=sheetObj.RowCount(); i++)
//  				{ 
//  					sheetObj.SetCellEditable(i, idx+"inv_dtl_amt",false); 
//  				}    // JO Case inv_dtl_amt Blocking ... Added By O Wan-Ki In 2007-10-29
  				break;
  			case "RF":
  				sheetObj.SetColHidden(idx+"bkg_no_all",1);//bkg_no_all
  				sheetObj.SetColHidden(idx+"bl_no_all",1);//bl_no_all
  				sheetObj.SetColHidden(idx+"route",1);//route
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_seal_no
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"occr_dt",1);//occur_dt
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  			case "DG":
  				sheetObj.SetColHidden(idx+"bkg_no_all",1);//bkg_no_all
  				sheetObj.SetColHidden(idx+"bl_no_all",1);//bl_no_all
  				sheetObj.SetColHidden(idx+"route",1);//route
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_seal_no
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"occr_dt",1);//occur_dt
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  			case "SL":
  				sheetObj.SetColHidden(idx+"bkg_no_all",1);//bkg_no_all
  				sheetObj.SetColHidden(idx+"bl_no_all",1);//bl_no_all
  				sheetObj.SetColHidden(idx+"route",1);//route
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_seal_no
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"occr_dt",1);//occur_dt
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  			case "CC":
  				sheetObj.SetColHidden(idx+"route",1);//route
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_seal_no
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  			case "WT":
  				sheetObj.SetColHidden(idx+"yd_cd",1);//yd_cd
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_seal_no
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"occr_dt",1);//occur_dt
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  			case "CD":
  				sheetObj.SetColHidden(idx+"bkg_no_all",1);//bkg_no_all
  				sheetObj.SetColHidden(idx+"bl_no_all",1);//bl_no_all
  				sheetObj.SetColHidden(idx+"bl_no_all",1);//bl_no_all
  				sheetObj.SetColHidden(idx+"vvd",1);//vvd
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"route",1);//route
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_seal_no
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"occr_dt",1);//occur_dt
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  			case "ZD":
  				sheetObj.SetColHidden(idx+"bkg_no_all",1);//bkg_no_all
  				sheetObj.SetColHidden(idx+"bl_no_all",1);//bl_no_all
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//vvd
  				sheetObj.SetColHidden(idx+"route",1);//route
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_seal_no
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"occr_dt",1);//occur_dt
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  			case "CH":
  				sheetObj.SetColHidden(idx+"yd_cd",1);//yd_cd
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_seal_no
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"occr_dt",1);//occur_dt
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  			case "EE":
  				sheetObj.SetColHidden(idx+"bkg_no_all",1);//bkg_no_all
  				sheetObj.SetColHidden(idx+"bl_no_all",1);//bl_no_all
  				sheetObj.SetColHidden(idx+"bl_no_all",1);//bl_no_all
  				sheetObj.SetColHidden(idx+"vvd",1);//vvd
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"route",1);//route
  				sheetObj.SetColHidden(idx+"mgset_no",1);//mgset_no
  				sheetObj.SetColHidden(idx+"new_eq_no",1);//new_eq_no
  				sheetObj.SetColHidden(idx+"new_cntr_seal_no",1);//new_seal_no
  				sheetObj.SetColHidden(idx+"cita_no",1);//citation_no
  				sheetObj.SetColHidden(idx+"cntr_wgt",1);//weight
  				sheetObj.SetColHidden(idx+"n3pty_cntr_wgt_ut_cd",1);//uom
  				sheetObj.SetColHidden(idx+"wt_hrs",1);//waiting_tm
  				sheetObj.SetColHidden(idx+"occr_dt",1);//occur_dt
  				sheetObj.SetColHidden(idx+"new_vsl_cd",1);//new_vvd
  				sheetObj.SetColHidden(idx+"new_bkg_no",1);//new_bkg_all
  				sheetObj.SetColHidden(idx+"damage_dt",1);//damage_dt
  				sheetObj.SetColHidden(idx+"repair_location",1);//repair_location
  				sheetObj.SetColHidden(idx+"lst_free_dt",1);//last_free_dt
  				sheetObj.SetColHidden(idx+"pkup_dt",1);//pick_up_dt
  				sheetObj.SetColHidden(idx+"ft_ovr_dys",1);//over_day
  				sheetObj.SetColHidden(idx+"csr_no",1);//csr_no
  				sheetObj.SetColHidden(idx+"gl_dt",1);//gl_dt
  				sheetObj.SetColHidden(idx+"vvd_cd",1);//vvd_cd (actual vvd)
  				break;
  		}
  	}
	/**
	 * Calling Invoice Preview pop-up
	 *
	 * @param : formObject - formObject
	 * @param : s_dao_n3pty_bil_tp_cd - s_dao_n3pty_bil_tp_cd
	 * @param : s_n3pty_inv_no - s_n3pty_inv_no
	 * @param : s_n3pty_inv_his_seq - s_n3pty_inv_his_seq
	 * @param : s_n3pty_inv_rmd_cd - s_n3pty_inv_rmd_cd
	 */
	function openInvoicePreviewPopupWin(formObject, s_dao_n3pty_bil_tp_cd, s_n3pty_inv_no, s_n3pty_inv_his_seq, s_n3pty_inv_rmd_cd) {
		var theURL="ESD_TPB_0112.do?pgmNo=ESD_TPB_0112&parentPgmNo=ESD_TPB_M001&f_cmd="+SEARCH+"&s_dao_n3pty_bil_tp_cd="+s_dao_n3pty_bil_tp_cd+"&s_n3pty_inv_no="+s_n3pty_inv_no+"&s_n3pty_inv_his_seq="+s_n3pty_inv_his_seq+"&s_n3pty_inv_rmd_cd="+s_n3pty_inv_rmd_cd;
	    //ComShowMessage( theURL );
		var features="scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:768px";
		var rtnValue =  ComOpenWindow(theURL,  window,  features , true);
	}
  	/**
 	 * Setting combobox the currency of Available at user office
 	 */
 	function getCurrencyList() {
 		var sheetObj=sheetObjects[0];
 		var formObj=document.form;
 		formObj.f_cmd.value=SEARCH01;
 		var query=tpbFrmQryStr(formObj);
 		var otherObjs=new Array("s_ofc_cd", "s_rhq_cd", "s_cnt_cd");
 		query=query+"&id=s_curr_cd&method=searchInvoiceCurrency&mode=F&obj=&all=2";
 		sheetObj.RemoveEtcData();
  		var xmls = sheetObj.GetSearchData("TPBCommonCodeGS.do", query );
 		var bil_curr_cd=ComGetEtcData(xmls,'BIL_CURR_CD');
 		var bilCurrCdArray=bil_curr_cd.split('|');
 		var comboObj=eval("document.all.s_curr_cd");
 		if(comboObj != undefined) {
 			ComClearCombo(comboObj);
 		}
 		
 		//ComAddComboItem(comboObj, "", "<<Select>>"); // server test
 		ComAddComboItem(comboObj, "<<Select>>", "" ); // local test
			var k=0;
 		while(k < bilCurrCdArray.length-1 ){
 			k++;
 			ComAddComboItem(comboObj, bilCurrCdArray[k], bilCurrCdArray[k]);
 		}
 	}
 	
	/* Finishing work */
