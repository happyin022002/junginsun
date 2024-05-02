/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : esm_bkg_0122.js
*@FileTitle : Wharfage Cargo Classification
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/30
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					          MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					          Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
     // public variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var vFreeRow=0;
    var vFreeCol=13;
    var vBulkWgt=0;
    var vBulkMea=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
         /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
		 var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
	            case "btn_add":
	            	doActionIBSheet(sheetObject1,formObject,COMMAND03);
	            	break;
	            case "btn_del":
	            	doActionIBSheet(sheetObject1,formObject,IBDELETE);
	            	break;	
	            case "btn_arif":
	            	doActionIBSheet(sheetObject1,formObject,COMMAND04);
	            	break;	
	            case "btn_blif":
	            	doActionIBSheet(sheetObject1,formObject,COMMAND05);
	            	break;	
	            case "btn_rateinquiry":
	            	doActionIBSheet(sheetObject1,formObject,COMMAND01);
	            	break;	
	            case "btn_blcheck":
	            	doActionIBSheet(sheetObject1,formObject,COMMAND02);
	            	break;	
	            case "btn_retrieve":
                	doActionIBSheet(sheetObject1,formObject,SEARCH01);
                	break;
            	case "btn_save":
            		doActionIBSheet(sheetObjects[0],formObject,MULTI);
            		doActionIBSheet(sheetObject1,formObject,SEARCH01);
            		break;				
            	case "btn_downexcel":
//            		sheetObjects[0].Down2Excel(-1, false, false, true, "", "", true);
            		 if(sheetObject1.RowCount() < 1){
            				ComShowCodeMessage("COM132501");

            			}else{
//            				sheetObjects[0].Down2Excel({ HiddenColumn:-1, Merge:1});
            				sheetObjects[0].Down2Excel({DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1,DownSum:1,KeyFieldMark:0});
            			}
             		
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
        initControl();
    }
    /**
     * load HTML Control event on the page <br>
     * {@link #loadPage}call the function and init IBSheet Object <br>
     * 
     * @param {ibsheet}
     *            sheetObj IBSheet Object
     * @param {int}
     *            sheetNo sheetObjects 
     */
    function initControl() {
    	var formObject=document.form;
//        axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
//    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
//    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	axon_event.addListenerForm('change', 'obj_Change', document.form);
//    	formObject.vvd.focus();
    }
    function searcgBySelect(){
    	doActionIBSheet(sheetObjects[0], document.form, SEARCH);
    	if( 'IN' ==  document.form.whf_bnd_cd.value ){
    		ComBtnDisable( "btn_save" );
    		ComBtnDisable( "btn_add" );
    		ComBtnDisable( "btn_del" );
    		ComBtnDisable( "btn_arif" );
    		ComBtnDisable( "btn_blif" );
    	}
    	else if( 'IT' == document.form.whf_bnd_cd.value ){
    		ComBtnEnable( "btn_save" );
    		ComBtnEnable( "btn_add" );
    		ComBtnEnable( "btn_del" );
    		ComBtnDisable( "btn_arif" );
    		ComBtnDisable( "btn_blif" );    	
    	}else{
    		ComBtnEnable( "btn_save" );
    		ComBtnEnable( "btn_add" );
    		ComBtnEnable( "btn_del" );
    		ComBtnEnable( "btn_arif" );
    		ComBtnEnable( "btn_blif" );
    	}
    }
    /**
     * process when you enter retrieve condition
     */
//    function obj_KeyUp() {
//    	var formObject=document.form;    	
//    	var srcName=ComGetEvent("name");
//    	//var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
//    	var srcMaxLength=ComGetEvent("maxlength");    	
//    	//var srcValue=window.event.srcElement.getAttribute("value");
//    	var srcValue=ComGetEvent("value");    	
//    	if (ComChkLen(srcValue, srcMaxLength) == "2") {    		
//    		ComSetNextFocus();
//    	}    	
//    }
    /*
     * In case of inputting retrieve conditnion, Auto retrieve
     */
//    function condition_KeyUp(){
//    	var formObject=document.form;
//    	if( (    ComChkLen(formObject.vvd.value, 9) == "2" ) 
//   				&& (ComChkLen(formObject.port_cd.value, 5) == "2" ) ){
//    			doActionIBSheet(sheetObjects[0], formObject, SEARCH);
//    	}
//    }
    /**
     * setting sheet initial values and header
     * 
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
				var sheetId=sheetObj.id;
        switch(sheetId) {
            case "sheet1":
                with(sheetObj){

            	                    	      
            	      SetAutoRowHeight(0);
            	      var HeadTitle1="|Sel.|Seq.|B/L No.|T|VVD|POL|POD|Commodity\nCode|Weight|Measure|Amount|Free|BZ No.|Shipper Name" +
            	      "|Export Ref.|Container Qty|Container Qty|Container Qty|CNTR Bulk Qty|CNTR Bulk Qty|CNTR Bulk Qty" +
            	      "|CNTR Bulk Qty|CNTR Bulk Qty|Booking Qty|Booking Qty|Booking Qty|Package\nType|Wharfage Rate|D/C" +
            	      "|Bulk Rton\nAppl Type|Bulk Rton|Bulk Whf\nAmount";
            	      var HeadTitle2="|Sel.|Seq.|B/L No.|T|VVD|POL|POD|Commodity\nCode|Weight|Measure|Amount|Free|BZ No.|Shipper Name" +
            	      "|Export Ref.|20’|40’|45’|20’|40’|45’|Weight|Measure|20’|40’|45’|Package\nType|Wharfage Rate|D/C" +
            	      "|Bulk Rton\nAppl Type|Bulk Rton|Bulk Whf\nAmount";
            	      var headCount=ComCountHeadTitle(HeadTitle1);
            	      var prefix="sheet1_";

            	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            	      var headers = [ { Text:HeadTitle1, Align:"Center"},
            	                  { Text:HeadTitle2, Align:"Center"} ];
            	      InitHeaders(headers, info);

            	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
            	             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Chk" },
            	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq." },
            	             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:12,	InputCaseSensitive:1,	AcceptKey:"E|N" },
            	             {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"t",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1,		InputCaseSensitive:1},
            	             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9,		InputCaseSensitive:1,	AcceptKey:"E|N" },
            	             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pol_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
            	             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
            	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cmdt_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6,		AcceptKey:"N" },
            	             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"wgt_qty",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
            	             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"meas_qty",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:22 },
            	             {Type:"Text",      Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"whf_amt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:22 },
            	             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"wfg_expt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
            	             {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_rgst_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20,	InputCaseSensitive:1,	AcceptKey:"E|N" },
            	             {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20,	InputCaseSensitive:1,	AcceptKey:"E|N" },
            	             {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"xpt_ref_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:500,	InputCaseSensitive:1,	AcceptKey:"E|N" },
            	             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"whf_cntr_20ft_qty",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
            	             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"whf_cntr_40ft_qty",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
            	             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"whf_cntr_45ft_qty",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
            	             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"whf_blk_20ft_qty",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
            	             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"whf_blk_40ft_qty",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
            	             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"whf_blk_45ft_qty",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
            	             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"blk_wgt_qty",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:22 },
            	             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"blk_meas_qty",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
            	             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"whf_bkg_20ft_qty",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:16 },
            	             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"whf_bkg_40ft_qty",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:16 },
            	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"whf_bkg_45ft_qty",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:16 },
            	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"whf_pck_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
            	             {Type:"Text",      Hidden:1, Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"whf_rt",               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
            	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dc_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
            	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bulk_rton_appl_type",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
            	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rton_wgt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
            	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bulk_wharfage_amount", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
            	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
            	             {Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"tax_teu_qty",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
            	             {Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"tax_feu_qty",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
            	             {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"tax_45ft_qty",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
            	             {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"expt_teu_qty",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:22 },
            	             {Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"expt_feu_qty",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
            	             {Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"expt_45ft_qty",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
            	             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"whf_bnd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
            	             {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"blk_wgt_qty2",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:22 },
            	             {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"blk_meas_qty2",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
            	             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"whf_amt_temp",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:22 } ];
            	       
            	      InitColumns(cols);

            	      SetEditable(1);
	                  SetWaitImageVisible(0);
                      SetSheetHeight(255);
                      SetColProperty(prefix+"whf_pck_tp_cd", {ComboText:"CNT|BLK", ComboCode:"CNT|BLK"} );
                      SetColProperty(prefix+"dc_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );                      
            	      }

				break;
            case "sheet2":
                with(sheetObj){
               
              var HeadTitle1="|Division|Imposed target|Correction target|Exempt shippers|Exempt shippers|Exempt shippers|T/S|IPO|Military|PPS|MTY|Total exemption|TOT\nAmount|correction\nAmount|Bulk|Bulk|Bulk";
              var HeadTitle2="|Division|Imposed target|Correction target|Dongbu Steel|HyunDai|Donggkuk|T/S|IPO|Military|PPS|MTY|Total exemption|TOT\nAmount|correction\nAmount|R.Ton|Rate|Amount";
              var headCount=ComCountHeadTitle(HeadTitle1);
              var prefix2='sheet2_';

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"ibflag" },
                     {Type:"Float",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"division",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",      Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix2+"levy",          KeyField:0,   CalcLogic:"",   AllowNull:false,  DefaultValue:0,  Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",      Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix2+"correction",    KeyField:0,   CalcLogic:"",   AllowNull:false,  DefaultValue:0,  Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",      Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix2+"dongbu",        KeyField:0,   CalcLogic:"",   AllowNull:false,  DefaultValue:0,  Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",      Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix2+"hyundai",       KeyField:0,   CalcLogic:"",   AllowNull:false,  DefaultValue:0,  Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",      Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix2+"donguk",        KeyField:0,   CalcLogic:"",   AllowNull:false,  DefaultValue:0,  Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"ts",            KeyField:0,   CalcLogic:"",   AllowNull:false,  DefaultValue:0,  Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",      Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"ipo",           KeyField:0,   CalcLogic:"",   AllowNull:false,  DefaultValue:0,  Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"military",      KeyField:0,   CalcLogic:"",   AllowNull:false,  DefaultValue:0,  Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",      Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"government",    KeyField:0,   CalcLogic:"",   AllowNull:false,  DefaultValue:0,  Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",      Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"mty",           KeyField:0,   CalcLogic:"",   AllowNull:false,  DefaultValue:0,  Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",      Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"sum",           KeyField:0,   CalcLogic:"",   AllowNull:false,  DefaultValue:0,  Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",      Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"totamount",     KeyField:0,   CalcLogic:"",   AllowNull:false,  DefaultValue:0,  Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"correctionamt", KeyField:0,   CalcLogic:"",   AllowNull:false,  DefaultValue:0,  Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",      Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"bulk_rton",     KeyField:0,   CalcLogic:"",   AllowNull:false,  DefaultValue:0,  Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",      Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"bulk_rate",     KeyField:0,   CalcLogic:"",   AllowNull:false,  DefaultValue:0,  Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",      Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"bulk_amount",   KeyField:0,   CalcLogic:"",   AllowNull:false,  DefaultValue:0,  Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 } ];
               
              InitColumns(cols);

              SetEditable(0);
              SetCountPosition(0);
              SetWaitImageVisible(0);
//              SetSheetHeight(140);
              resizeSheet();
                    }


				break;
        }
    }
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case SEARCH:
        		if( validateForm(sheetObj,formObj,sAction) ){
					formObj.f_cmd.value=SEARCH;   
					var aryPrefix=new Array("sheet1_"); 
 					var sXml=sheetObj.GetSearchData("ESM_BKG_0122GS.do",FormQueryString(formObj) );
					if (ComGetEtcData(sXml,"mf_ref_no")){
						formObj.mf_ref_no.value=ComGetEtcData(sXml,"mf_ref_no");
						formObj.sail_dt.value=ComGetEtcData(sXml,"sail_dt");
						formObj.whf_decl_no.value=ComGetEtcData(sXml,"whf_decl_no"); 
					}
        		}
        		break;
        	case SEARCH01:      //retrieve
        		if( validateForm(sheetObj,formObj,sAction) ){
        			var prefix2='sheet2_';
        			var prefix1='sheet1_';	
					formObj.f_cmd.value=SEARCH01;   
					var aryPrefix=new Array("sheet1_", "sheet2_" ); 
					ComOpenWait(true);
 					var sXml=sheetObj.GetSearchData("ESM_BKG_0122GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
					ComOpenWait(false);
					var arrXml=sXml.split("|$$|");
					if (arrXml[1] != "") {
						var vArry=ComXml2ComboString(arrXml[1],  prefix2 +"attr_ctnt1", prefix2 +"attr_ctnt5" );
						sheetObjects[0].InitDataCombo (0, prefix1 + "wfg_expt_cd", vArry[1]+'| ', vArry[0]+'| ' );
					}
					sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
					formObj.kr_whf_cntr_20ft_rt.value=ComGetEtcData(arrXml[0],"kr_whf_cntr_20ft_rt");
					formObj.kr_whf_cntr_40ft_rt.value=ComGetEtcData(arrXml[0],"kr_whf_cntr_40ft_rt");
					formObj.kr_whf_cntr_45ft_rt.value=ComGetEtcData(arrXml[0],"kr_whf_cntr_45ft_rt");
					formObj.kr_whf_blk_rt.value=ComGetEtcData(arrXml[0],"kr_whf_blk_rt");
					if( sheetObjects[0].RowCount()> 1 ){
						var vDcFlg=sheetObjects[0].GetCellValue(2, prefix1+'dc_flg');
						if( 'Y' == vDcFlg )
							formObj.dc_flg.checked=true ;
						else
							formObj.dc_flg.checked=false ;
					}
					//Activate the button
					searcgBySelect();
					//calling method making bottom grid data
					createData();
        		}
        		break;
			case COMMAND01 :
				if( validateForm(sheetObj,formObj,sAction) ){
					var checked=0;
					for (var i=2 ; i <= sheetObj.RowCount()+1 ; i++){
						if( sheetObj.GetCellValue(i,1) == '1' ){
							checked=i;
							break;
						}
					}
					if ( checked == 0 ) {
						ComShowCodeMessage('BKG00249');
					} else {
						ComOpenWindow2("ESM_BKG_0124.do?vvd=" + formObj.vvd.value + "&bl_no=" + sheetObj.GetCellValue(checked,3) + "&whf_bnd_cd=" + formObj.whf_bnd_cd.value, "", "width=900, height=630");
					}
				} 
				break;
			case COMMAND02 :
				if( validateForm(sheetObj,formObj,sAction) ){
					ComOpenWindow2("ESM_BKG_0125.do?vvd=" + formObj.vvd.value 
							                              + "&port_cd=" + formObj.port_cd.value 
							                              + "&whf_bnd_cd=" + formObj.whf_bnd_cd.value 
							                              + "&mrn_no=" + formObj.mf_ref_no.value, "", "width=800, height=580");
				} 
				break;
			case COMMAND03: 
				if( validateForm(sheetObj,formObj,sAction) ){
					var checked=0;
					for (var i=2 ; i <= sheetObj.RowCount()+1 ; i++){
						if( sheetObj.GetCellValue(i,1) == '1' ){
							checked=i;
							break;
						}
    				}
					if ( checked != 0 ){
						ComOpenWindow2("ESM_BKG_0123.do?popup=y&vvd=" + formObj.vvd.value 
	                            + "&port_cd="    + formObj.port_cd.value 
	                            + "&whf_bnd_cd=" + formObj.whf_bnd_cd.value 
								+ "&whf_rate="   + sheetObj.GetCellValue(checked,28)
								+ "&bl_no="   	 + sheetObj.GetCellValue(checked,3)
								+ "&bkg_no="   	 + sheetObj.GetCellValue(checked,33), "ESM_BKG_0123", "width=1000, height=610");
					}else {
						ComOpenWindow2("ESM_BKG_0123.do?popup=y&vvd=" + formObj.vvd.value 
	                            + "&port_cd="    + formObj.port_cd.value 
	                            + "&whf_bnd_cd=" + formObj.whf_bnd_cd.value , "ESM_BKG_0123", "width=1000, height=610");
					}
				} 
				break; 	
			case MULTI:        //Save
				if( validateForm(sheetObj,formObj,sAction) ){
					formObj.f_cmd.value=MULTI;
				    if (! sheetObjects[0].IsDataModified()){
				    	ComShowCodeMessage('BKG00233');
	    	        	return;
	    	        }
					ComOpenWait(true);
				    var sParam=ComGetSaveString(sheetObjects);
	    	        sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
 	    	        var SaveXml=sheetObj.GetSaveData("ESM_BKG_0122GS.do", sParam);
 	    	        sheetObj.LoadSaveData(SaveXml);  //체크
	    	        ComOpenWait(false);
				}    
    	    break;
			case COMMAND04:        //Save
				if( validateForm(sheetObj,formObj,sAction) ){
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					formObj.f_cmd.value=COMMAND05;
					var sParam=sheetObjects[0].GetSaveString(true);
					sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
					var SaveXml=sheetObj.GetSaveData("ESM_BKG_0122GS.do", sParam);
					if( ComBkgErrMessage(sheetObj, SaveXml) ){
						ComShowCodeMessage('BKG00204');
					}else{
						ComShowCodeMessage('BKG00205');
					}
					ComOpenWait(false);
				}    
				break;
			case COMMAND05:        //Save
				if( validateForm(sheetObj,formObj,sAction) ){
					ComOpenWait(true);
					formObj.f_cmd.value=COMMAND05;
					var sParam=sheetObjects[0].GetSaveString(false, true, "sheet1_Chk");
					sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
 					var SaveXml=sheetObj.GetSaveData("ESM_BKG_0122GS.do", sParam);
					if( ComBkgErrMessage(sheetObj, SaveXml) ){
						ComShowCodeMessage('BKG00204');
					}else{
						ComShowCodeMessage('BKG00205');
					}
					ComOpenWait(false);
				}    
				break;
			case COMMAND06: 
				if( validateForm(sheetObj,formObj,sAction) ){
					var bizNoObject=ComOpenWindowCenter('/opuscntr/ESM_BKG_0738.do?pgmNo=ESM_BKG_0738&country=KR&popup=Y', 'SearchBizNo' ,600,400, true);
					if (bizNoObject) {
						sheetObjects[0].SetCellValue(vFreeRow, vFreeCol,bizNoObject.vRgstNo.substring(0,3) + "-" +
																		 bizNoObject.vRgstNo.substring(3,5) + "-" +
																		 bizNoObject.vRgstNo.substring(5));
					}
				} 
				break; 		
			case IBDELETE:      // delete
				var checked=0;
				for (var i=2 ; i <= sheetObj.RowCount()+1 ; i++){
					if( sheetObj.GetCellValue(i,1) == '1' ){
						checked=1;
						if (sheetObj.GetCellValue(i,0) != "I"){
							//if( sheetObj.CellValue(i,1) == '1' ){
								sheetObj.SetRowHidden( i ,1);
								sheetObj.SetRowStatus( i ,"D");
							//}
						}else{
							//if( sheetObj.CellValue(i,1) == '1' ){
								sheetObj.SetRowStatus( i ,"U");
								sheetObj.SetRowStatus( i ,"D");
								i--;
							//}
						}
					}	
				}
				if ( checked == 0 ) ComShowCodeMessage('BKG00249');
			break;
			case IBDOWNEXCEL:
				if( sheetObj.RowCount()> 0 )
 					sheetObjects[0].Down2Excel({ HiddenColumn:-1});
				else
					ComShowCodeMessage('BKG00389');
			break;	
        }
    }
     /**
      * handling process for input validation
      */
    function validateForm(sheetObj,formObj,sAction){
    	var vvd=formObj.vvd.value;
    	var vpsPortCd=formObj.port_cd.value;
    	var ioBndCd=formObj.whf_bnd_cd.value;

    	switch (sAction) {
     		case SEARCH01:     			
     			if( ComChkLen(vvd, 9) != "2"  ){     				
     				ComShowCodeMessage('BKG00887', 'vvd');
//     				formObj.vvd.focus();     				
     				return false;
     			}     			
     			if( ComChkLen(vpsPortCd, 5) != "2"  ){     				
     				ComShowCodeMessage('BKG00887', 'Port');     				
//     				formObj.vps_port_cd.focus();
//     				formObj.port_cd.focus();     				
     				return false;
     			} 
     			return true;
     			break;
     		case SEARCH:
     			if ( ComChkLen(vvd, 9) != "2") {
     				ComShowCodeMessage('BKG00887', 'VVD');
     				return false;
     			}     			
     			if( ComChkLen(vpsPortCd, 5) != "2"  ){
     				ComShowCodeMessage('BKG00887', 'Port');
     				return false;
     			}
     			return true;
     			break;
	 		case MULTI: // Save
	 			if ( ComChkLen(vvd, 9) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'VVD');
//	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			else if ( ComChkLen(vpsPortCd, 5) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'Port');
//	 				formObj.port_cd.focus();
	 				return false;
	 			}
	 			return true;
	 			break;
	 		case COMMAND01: // Rate Inquiry
	 			return true;
	 			break;
	 		case COMMAND02: // Bl Check
	 			return true;
	 			break;
	 		case COMMAND03: // screen initialization
	 			return true;
     		break;
	 		case COMMAND04: // Save
	 			if ( ComChkLen(vvd, 9) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'VVD');
//	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			else if ( ComChkLen(vpsPortCd, 5) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'Port');
//	 				formObj.port_cd.focus();
	 				return false;
	 			}
	 			return true;
	 			break;
	 		case COMMAND05: // Save
	 			if ( ComChkLen(vvd, 9) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'VVD');
//	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			else if ( ComChkLen(vpsPortCd, 5) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'Port');
//	 				formObj.port_cd.focus();
	 				return false;
	 			}
	 			return true;
	 			break;	
	 		case COMMAND06: // Save
	 			if ( ComChkLen(vvd, 9) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'VVD');
//	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			else if ( ComChkLen(vpsPortCd, 5) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'Port');
//	 				formObj.port_cd.focus();
	 				return false;
	 			}
	 			return true;
	 			break;	
     	}
     }
    /**
     * Comma in numeric format with commas removed and return the result as a mistake.
     * @param targetNum
     * @return
     */
    function parseFloatWithoutComma( targetNum ){
    	return parseFloat( targetNum.split(",").join("") );
    }
    /**
     * Data processing methods.
     * 
     * @return
     */
    function createData(){
    	var prefix2='sheet2_';
		var prefix1='sheet1_';	
		var formObj=document.form; 
		var vBndCd=formObj.whf_bnd_cd.value ;
    	if( sheetObjects[0].RowCount()> 0 ) {
			/*
			 * Three columns at the top right of the grid generation
			 */
			var totalAmt=0;
			var total20Qty=0;
			var total40Qty=0;
			var total45Qty=0;
			var rtonWgt=0;
			var expt_ton_wgt=0;
			for(var i=2; i<=sheetObjects[0].RowCount()+1; i++){
				totalAmt=totalAmt + parseFloat( sheetObjects[0].GetCellValue(i,'sheet1_whf_amt') );
				//totalAmt = totalAmt + sheetObjects[0].CellValue(i,'sheet1_whf_amt');
//				total20Qty = total20Qty + parseFloat( sheetObjects[0].CellValue(i,'sheet1_whf_cntr_20ft_qty') ) +  parseFloat( sheetObjects[0].CellValue(i,'sheet1_whf_blk_20ft_qty') );
//				total40Qty = total40Qty + parseFloat( sheetObjects[0].CellValue(i,'sheet1_whf_cntr_40ft_qty') ) +  parseFloat( sheetObjects[0].CellValue(i,'sheet1_whf_blk_40ft_qty') );
//				total45Qty = total45Qty + parseFloat( sheetObjects[0].CellValue(i,'sheet1_whf_cntr_45ft_qty') ) +  parseFloat( sheetObjects[0].CellValue(i,'sheet1_whf_blk_45ft_qty') );
				total20Qty=total20Qty + parseFloat( sheetObjects[0].GetCellValue(i,'sheet1_whf_cntr_20ft_qty') );
				total40Qty=total40Qty + parseFloat( sheetObjects[0].GetCellValue(i,'sheet1_whf_cntr_40ft_qty') );
				total45Qty=total45Qty + parseFloat( sheetObjects[0].GetCellValue(i,'sheet1_whf_cntr_45ft_qty') );
				if( sheetObjects[0].GetCellValue(i, prefix1 + 'wfg_expt_cd') == ''  ||
				sheetObjects[0].GetCellValue(i, prefix1 + 'wfg_expt_cd') == 'N' ||
				sheetObjects[0].GetCellValue(i, prefix1 + 'wfg_expt_cd') == 'B'    ){ // 면제 사유가 없는
				rtonWgt=rtonWgt + parseFloat( sheetObjects[0].GetCellValue(i,'sheet1_rton_wgt') );
				} else {	                                                        // 면제 사유가 있는
					expt_ton_wgt=expt_ton_wgt + parseFloat( sheetObjects[0].GetCellValue(i,'sheet1_rton_wgt') );
				}	
			}
			/*
			 * Generated in the middle of the form data
			 */
			formObj.total_bl_count.value=sheetObjects[0].RowCount();
			formObj.total_wharfage.value=CommaInputWithPoint(sheetObjects[0].GetCellValue(2,'sheet1_whf_rt'), 2 );
			formObj.whf_rt_amt.value=ComGetMaskedValue( ComTrunc( String( totalAmt ), 0), 'int' ) ;  //CommaInputWithPoint( String( totalAmt ), 3);//CommaInputWithPoint( String( sheetObjects[0].GetSumValue(3,'sheet1_whf_amt') ), 3 );
			formObj.rtotal1.value=total20Qty;
			formObj.rtotal2.value=total40Qty;
			formObj.rtotal3.value=total45Qty;
			formObj.rton_wgt.value=rtonWgt;
			formObj.expt_ton_wgt.value=expt_ton_wgt;
			/*
			 * The bottom of the grid generation
			 */
			if( sheetObjects[1].RowCount()< 3 ){
				sheetObjects[1].DataInsert(-1);
				sheetObjects[1].DataInsert(-1);
				sheetObjects[1].DataInsert(-1);
				sheetObjects[1].SetCellValue(2, prefix2 + 'division','20' ,0);
				sheetObjects[1].SetCellValue(3, prefix2 + 'division','40' ,0);
				sheetObjects[1].SetCellValue(4, prefix2 + 'division','45' ,0);
			}
			var levy_division_20=0;
			var levy_division_40=0;
			var levy_division_45=0;
			var correction_division_20=0;
			var correction_division_40=0;
			var correction_division_45=0;
//			var hyosung_division_20 = 0;
//			var hyosung_division_40 = 0;
//			var hyosung_division_45 = 0;
//			var daewoo_division_20 = 0;
//			var daewoo_division_40 = 0;
//			var daewoo_division_45 = 0;
			var dongbu_division_20=0;
			var dongbu_division_40=0;
			var dongbu_division_45=0;
			var hyundai_division_20=0;
			var hyundai_division_40=0;
			var hyundai_division_45=0;
			var donguk_division_20=0;
			var donguk_division_40=0;
			var donguk_division_45=0;
			var ts_division_20=0;
			var ts_division_40=0;
			var ts_division_45=0;
			var ipo_division_20=0;
			var ipo_division_40=0;
			var ipo_division_45=0;
			// military
			var military_division_20=0;
			var military_division_40=0;
			var military_division_45=0;
			// government
			var government_division_20=0;
			var government_division_40=0;
			var government_division_45=0;
			// mty
			var mty_division_20=0;
			var mty_division_40=0;
			var mty_division_45=0;
			// sum
			var sum_division_20=0;
			var sum_division_40=0;
			var sum_division_45=0;
			// totamount
			var totamount_division_20=0;
			var totamount_division_40=0;
			var totamount_division_45=0;
			// correctionamt
			var correctionamt_division_20=0;
			var correctionamt_division_40=0;
			var correctionamt_division_45=0;
			// bulk_rton
			var bulk_rton_division_20=0;
			var bulk_rton_division_40=0;
			var bulk_rton_division_45=0;
			// bulk_rate
			var bulk_rate_division_20=0;
			var bulk_rate_division_40=0;
			var bulk_rate_division_45=0;
			// bulk_amount
			var bulk_amount_division_20=0;
			var bulk_amount_division_40=0;
			var bulk_amount_division_45=0;
			for( var i=0; i< sheetObjects[0].RowCount(); i++ ){
				// "Grid_1 retrieve on a 20 ', 40', 45 'there is no exemption Stars CNTR Bulk QTY Container Qty and the sum of"
				if( sheetObjects[0].GetCellValue(i+2, prefix1 + 'wfg_expt_cd') == ''  ||
				sheetObjects[0].GetCellValue(i+2, prefix1 + 'wfg_expt_cd') == 'N' ||
				sheetObjects[0].GetCellValue(i+2, prefix1 + 'wfg_expt_cd') == 'B'){
//					levy_division_20 = levy_division_20 + (    parseFloat((sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_20ft_qty')).split(",").join("")) 
//							                                 + parseFloat((sheetObjects[0].CellValue(i+2, prefix1 + 'whf_blk_20ft_qty')).split(",").join("")) );
//					levy_division_40 = levy_division_40 + ( parseFloat(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_40ft_qty').split(",").join("")) 
//												            +  parseFloat(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_blk_40ft_qty').split(",").join("")) );
//					levy_division_45 = levy_division_45 + ( parseFloat(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_45ft_qty').split(",").join("")) 
//												        + parseFloat(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_blk_45ft_qty').split(",").join(""))  );
					levy_division_20=levy_division_20 + ( parseFloat((sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_20ft_qty')).split(",").join("")));
					levy_division_40=levy_division_40 + ( parseFloat(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_40ft_qty').split(",").join("")) );
					levy_division_45=levy_division_45 + ( parseFloat(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_45ft_qty').split(",").join("")) );
				}
				//"Amount in Grid_1 retrieve the 20 ', 40', 45 'is less than zero by B / L reported the Type R is not T or CNTR Bulk QTY Container Qty and the sum of"
				if(  sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_amt') < 0
				&& sheetObjects[0].GetCellValue(i+2, prefix1 + 't') != 'T'
				&& sheetObjects[0].GetCellValue(i+2, prefix1 + 't') != 'R'){
				correction_division_20=correction_division_20 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_20ft_qty'))
				+ parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_blk_20ft_qty')));
				correction_division_40=correction_division_40 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_40ft_qty'))
				+ parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_blk_40ft_qty')));
				correction_division_45=correction_division_45 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_45ft_qty'))
				+ parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_blk_45ft_qty')));
				}
				//Retrieve the listed items to Grid_1 exempt shippers "Hyosung (105-81-59519)," The Container Qty Total
//				if( sheetObjects[0].CellValue(i+2, prefix1 + 'cust_rgst_no')  == '105-81-59519' ){
//					hyosung_division_20 = hyosung_division_20 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_20ft_qty')));
//					hyosung_division_40 = hyosung_division_40 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_40ft_qty'))); 
//					hyosung_division_45 = hyosung_division_45 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_45ft_qty'))); 
//				}
////				Retrieve the listed items to Grid_1 shippers exempt "treatment (401-85-04303 or 401-85-08615)," The Container Qty Total
//				var tempFree1 = sheetObjects[0].CellValue(i+2, prefix1 + 'cust_rgst_no') ;
//				if( tempFree1 == '401-85-04303' || tempFree1 == '401-85-08615' ){
//					daewoo_division_20 = daewoo_division_20 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_20ft_qty'))); 
//					daewoo_division_40 = daewoo_division_40 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_40ft_qty'))); 
//					daewoo_division_45 = daewoo_division_45 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_45ft_qty'))); 
//				}
//				Retrieve the listed items to Grid_1 exempt shippers "East (137-85-00522)," The Container Qty Total
				var tempFree2=sheetObjects[0].GetCellValue(i+2, prefix1 + 'cust_rgst_no') ;
				if( tempFree2 == '137-85-00522' && sheetObjects[0].GetCellValue(i+2, prefix1 + 'wfg_expt_cd') == 'S'){
				dongbu_division_20=dongbu_division_20 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_20ft_qty')));
				dongbu_division_40=dongbu_division_40 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_40ft_qty')));
				dongbu_division_45=dongbu_division_45 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_45ft_qty')));
				}
//				Retrieve the listed items to Grid_1 exempt shippers "Hyundai Hysco (416-85-06244)" Total volume of
				var tempFree3=sheetObjects[0].GetCellValue(i+2, prefix1 + 'cust_rgst_no') ;
				if( tempFree3 == '416-85-06244' && sheetObjects[0].GetCellValue(i+2, prefix1 + 'wfg_expt_cd') == 'S'){
				hyundai_division_20=hyundai_division_20 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_20ft_qty')));
				hyundai_division_40=hyundai_division_40 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_40ft_qty')));
				hyundai_division_45=hyundai_division_45 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_45ft_qty')));
				}
//				Retrieve the listed items to Grid_1 exempt shippers "Dongkuk (506-85-03346)," The Container Qty Total
				var tempFree4=sheetObjects[0].GetCellValue(i+2, prefix1 + 'cust_rgst_no') ;
				if( tempFree4 == '506-85-03346' && sheetObjects[0].GetCellValue(i+2, prefix1 + 'wfg_expt_cd') == 'S'){
				donguk_division_20=donguk_division_20 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_20ft_qty')));
				donguk_division_40=donguk_division_40 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_40ft_qty')));
				donguk_division_45=donguk_division_45 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_45ft_qty')));
								}
				/* 1111111 */
				if( sheetObjects[0].GetCellValue(i+2, prefix1 + 'wfg_expt_cd') == 'X' ){
					ts_division_20=ts_division_20 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_20ft_qty')));
					ts_division_40=ts_division_40 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_40ft_qty')));
					ts_division_45=ts_division_45 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_45ft_qty')));
				}
				if( sheetObjects[0].GetCellValue(i+2, prefix1 + 'wfg_expt_cd') == 'I' ){
					ipo_division_20=ipo_division_20 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_20ft_qty')));
					ipo_division_40=ipo_division_40 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_40ft_qty')));
					ipo_division_45=ipo_division_45 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_45ft_qty')));
				}
				if( sheetObjects[0].GetCellValue(i+2, prefix1 + 'wfg_expt_cd') == 'J' ){
					military_division_20=military_division_20 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_20ft_qty')));
					military_division_40=military_division_40 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_40ft_qty')));
					military_division_45=military_division_45 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_45ft_qty')));
				}
				if( sheetObjects[0].GetCellValue(i+2, prefix1 + 'wfg_expt_cd') == 'K' ){
					government_division_20=government_division_20 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_20ft_qty')));
					government_division_40=government_division_40 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_40ft_qty')));
					government_division_45=government_division_45 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_45ft_qty')));
				}
				if( sheetObjects[0].GetCellValue(i+2, prefix1 + 'wfg_expt_cd') == 'D' ){
					mty_division_20=mty_division_20 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_20ft_qty')));
					mty_division_40=mty_division_40 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_40ft_qty')));
					mty_division_45=mty_division_45 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_45ft_qty')));
				}
				var cntr_20ft_amt=0;
				var cntr_40ft_amt=0;
				var cntr_45ft_amt=0;
				if (sheetObjects[0].GetCellValue(i+2, prefix1 + 'wfg_expt_cd') == ''  ||
						sheetObjects[0].GetCellValue(i+2, prefix1 + 'wfg_expt_cd') == 'N' ||
						sheetObjects[0].GetCellValue(i+2, prefix1 + 'wfg_expt_cd') == 'B' )
				{
					cntr_20ft_amt=( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_20ft_qty'))
							* parseFloatWithoutComma(formObj.kr_whf_cntr_20ft_rt.value ));
					cntr_40ft_amt=( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_40ft_qty'))
							* parseFloatWithoutComma(formObj.kr_whf_cntr_40ft_rt.value ));
					cntr_45ft_amt=( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_45ft_qty'))
							* parseFloatWithoutComma(formObj.kr_whf_cntr_45ft_rt.value ));
				}
				totamount_division_20=totamount_division_20 + cntr_20ft_amt;
				totamount_division_40=totamount_division_40 + cntr_40ft_amt;
				totamount_division_45=totamount_division_45 + cntr_45ft_amt;
//				totamount_division_20 = totamount_division_20 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_20ft_qty')) 
//						* parseFloatWithoutComma(formObj.kr_whf_cntr_20ft_rt.value ));
//				totamount_division_40 = totamount_division_40 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_40ft_qty')) 
//						* parseFloatWithoutComma(formObj.kr_whf_cntr_40ft_rt.value ));
//				totamount_division_45 = totamount_division_45 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_45ft_qty')) 
//						* parseFloatWithoutComma(formObj.kr_whf_cntr_45ft_rt.value));
//				totamount_division_20 = totamount_division_20 + parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_amt')); 
//				totamount_division_40 = totamount_division_40 + parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_amt')); 
//				totamount_division_45 = totamount_division_45 + parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_amt')); 
				if(  sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_amt') < 0
						&& sheetObjects[0].GetCellValue(i+2, prefix1 + 't') != 'T'
							&& sheetObjects[0].GetCellValue(i+2, prefix1 + 't') != 'R'){
					correctionamt_division_20=correctionamt_division_20 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_20ft_qty'))
							* parseFloatWithoutComma(formObj.kr_whf_cntr_20ft_rt.value) );
					correctionamt_division_40=correctionamt_division_40 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_40ft_qty'))
							* parseFloatWithoutComma(formObj.kr_whf_cntr_40ft_rt.value) );
					correctionamt_division_45=correctionamt_division_45 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'whf_cntr_45ft_qty'))
							* parseFloatWithoutComma(formObj.kr_whf_cntr_45ft_rt.value) );
//					correctionamt_division_20 = correctionamt_division_20 + parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_amt')); 
//					correctionamt_division_40 = correctionamt_division_40 + parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_amt')); 
//					correctionamt_division_45 = correctionamt_division_45 + parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_amt')); 
				}
//				"[Grid_2.devision = ""20'"" OR Grid_2.devision = ""45'"" ] {
//				   0
//			     }
//			     [Grid_2.devision = ""45'""] {
//			         total amount of Grid_1.Bulk Rton
//		     	 }"
				bulk_rton_division_20=0;
				bulk_rton_division_40=bulk_rton_division_40 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'rton_wgt')));
				bulk_rton_division_45=0;
				bulk_rate_division_20=0;
				bulk_rate_division_40=formObj.kr_whf_blk_rt.value;
				bulk_rate_division_45=0;
				bulk_amount_division_20=0;
				bulk_amount_division_40=bulk_amount_division_40 + ( parseFloatWithoutComma(sheetObjects[0].GetCellValue(i+2, prefix1 + 'bulk_wharfage_amount')));
				bulk_amount_division_45=0;
			}	
//			Retrieve the exempt quantities listed items in Grid_1 WHF Total (exempt shippers ~ MTY)
			sum_division_20=//hyosung_division_20 
			                 //+ daewoo_division_20 
			                 dongbu_division_20 
			                 + hyundai_division_20 
			                 + donguk_division_20
			                 + ts_division_20 
			                 + ipo_division_20 
			                 + military_division_20 
			                 + government_division_20 
			                 + mty_division_20;
			sum_division_40=//hyosung_division_40 
			                 //+ daewoo_division_40 
			                 dongbu_division_40 
			                 + hyundai_division_40 
			                 + donguk_division_40
			                 + ts_division_40 
			                 + ipo_division_40 
			                 + military_division_40 
			                 + government_division_40 
			                 + mty_division_40;
			sum_division_45=//hyosung_division_45 
			                 //+ daewoo_division_45 
			                 dongbu_division_45 
			                 + hyundai_division_45 
			                 + donguk_division_45
			                 + ts_division_45 
			                 + ipo_division_45 
			                 + military_division_45 
			                 + government_division_45 
			                 + mty_division_45; 
			}
    		if( 'IT' != vBndCd ) {
				sheetObjects[1].SetCellValue(2, prefix2 + 'levy',levy_division_20 ,0);
				sheetObjects[1].SetCellValue(3, prefix2 + 'levy',levy_division_40 ,0);
				sheetObjects[1].SetCellValue(4, prefix2 + 'levy',levy_division_45 ,0);
    		} else {
    			sheetObjects[1].SetCellValue(2, prefix2 + 'levy','0' ,0);
    			sheetObjects[1].SetCellValue(3, prefix2 + 'levy','0' ,0);
    			sheetObjects[1].SetCellValue(4, prefix2 + 'levy','0' ,0);
    		}
			sheetObjects[1].SetCellValue(2, prefix2 + 'correction',correction_division_20 ,0);
			sheetObjects[1].SetCellValue(3, prefix2 + 'correction',correction_division_40 ,0);
			sheetObjects[1].SetCellValue(4, prefix2 + 'correction',correction_division_45 ,0);
//			sheetObjects[1].CellValue2(2, prefix2 + 'hyosung') = hyosung_division_20 ;
//			sheetObjects[1].CellValue2(3, prefix2 + 'hyosung') = hyosung_division_40 ;
//			sheetObjects[1].CellValue2(4, prefix2 + 'hyosung') = hyosung_division_45 ;
//			sheetObjects[1].CellValue2(2, prefix2 + 'daewoo') = daewoo_division_20 ;
//			sheetObjects[1].CellValue2(3, prefix2 + 'daewoo') = daewoo_division_40 ;
//			sheetObjects[1].CellValue2(4, prefix2 + 'daewoo') = daewoo_division_45 ;
			sheetObjects[1].SetCellValue(2, prefix2 + 'dongbu',dongbu_division_20 ,0);
			sheetObjects[1].SetCellValue(3, prefix2 + 'dongbu',dongbu_division_40 ,0);
			sheetObjects[1].SetCellValue(4, prefix2 + 'dongbu',dongbu_division_45 ,0);
			sheetObjects[1].SetCellValue(2, prefix2 + 'hyundai',hyundai_division_20 ,0);
			sheetObjects[1].SetCellValue(3, prefix2 + 'hyundai',hyundai_division_40 ,0);
			sheetObjects[1].SetCellValue(4, prefix2 + 'hyundai',hyundai_division_45 ,0);
			sheetObjects[1].SetCellValue(2, prefix2 + 'donguk',donguk_division_20 ,0);
			sheetObjects[1].SetCellValue(3, prefix2 + 'donguk',donguk_division_40 ,0);
			sheetObjects[1].SetCellValue(4, prefix2 + 'donguk',donguk_division_45 ,0);
			//TS
			if( 'IT' != vBndCd ) {
				sheetObjects[1].SetCellValue(2, prefix2 + 'ts',ts_division_20 ,0);
				sheetObjects[1].SetCellValue(3, prefix2 + 'ts',ts_division_40 ,0);
				sheetObjects[1].SetCellValue(4, prefix2 + 'ts',ts_division_45 ,0);
			} else {
				sheetObjects[1].SetCellValue(2, prefix2 + 'ts',levy_division_20 ,0);
				sheetObjects[1].SetCellValue(3, prefix2 + 'ts',levy_division_40 ,0);
				sheetObjects[1].SetCellValue(4, prefix2 + 'ts',levy_division_45 ,0);
			}
			//IPO
			sheetObjects[1].SetCellValue(2, prefix2 + 'ipo',ipo_division_20 ,0);
			sheetObjects[1].SetCellValue(3, prefix2 + 'ipo',ipo_division_40 ,0);
			sheetObjects[1].SetCellValue(4, prefix2 + 'ipo',ipo_division_45 ,0);
			//military
			sheetObjects[1].SetCellValue(2, prefix2 + 'military',military_division_20 ,0);
			sheetObjects[1].SetCellValue(3, prefix2 + 'military',military_division_40 ,0);
			sheetObjects[1].SetCellValue(4, prefix2 + 'military',military_division_45 ,0);
			//government
			sheetObjects[1].SetCellValue(2, prefix2 + 'government',government_division_20 ,0);
			sheetObjects[1].SetCellValue(3, prefix2 + 'government',government_division_40 ,0);
			sheetObjects[1].SetCellValue(4, prefix2 + 'government',government_division_45 ,0);
			//mty
			sheetObjects[1].SetCellValue(2, prefix2 + 'mty',mty_division_20 ,0);
			sheetObjects[1].SetCellValue(3, prefix2 + 'mty',mty_division_40 ,0);
			sheetObjects[1].SetCellValue(4, prefix2 + 'mty',mty_division_45 ,0);
			//sum
			sheetObjects[1].SetCellValue(2, prefix2 + 'sum',sum_division_20 ,0);
			sheetObjects[1].SetCellValue(3, prefix2 + 'sum',sum_division_40 ,0);
			sheetObjects[1].SetCellValue(4, prefix2 + 'sum',sum_division_45 ,0);
			//totamount
			sheetObjects[1].SetCellValue(2, prefix2 + 'totamount',totamount_division_20 ,0);
			sheetObjects[1].SetCellValue(3, prefix2 + 'totamount',totamount_division_40 ,0);
			sheetObjects[1].SetCellValue(4, prefix2 + 'totamount',totamount_division_45 ,0);
			//correctionamt
			sheetObjects[1].SetCellValue(2, prefix2 + 'correctionamt',correctionamt_division_20 ,0);
			sheetObjects[1].SetCellValue(3, prefix2 + 'correctionamt',correctionamt_division_40 ,0);
			sheetObjects[1].SetCellValue(4, prefix2 + 'correctionamt',correctionamt_division_45 ,0);
			//bulk_rton
			sheetObjects[1].SetCellValue(2, prefix2 + 'bulk_rton',bulk_rton_division_20 ,0);
			sheetObjects[1].SetCellValue(3, prefix2 + 'bulk_rton',bulk_rton_division_40 ,0);
			sheetObjects[1].SetCellValue(4, prefix2 + 'bulk_rton',bulk_rton_division_45 ,0);
			//bulk_rate
			sheetObjects[1].SetCellValue(2, prefix2 + 'bulk_rate',bulk_rate_division_20 ,0);
			sheetObjects[1].SetCellValue(3, prefix2 + 'bulk_rate',bulk_rate_division_40 ,0);
			sheetObjects[1].SetCellValue(4, prefix2 + 'bulk_rate',bulk_rate_division_45 ,0);
			//bulk_amount
			sheetObjects[1].SetCellValue(2, prefix2 + 'bulk_amount',0 ,0);
			sheetObjects[1].SetCellValue(3, prefix2 + 'bulk_amount',bulk_amount_division_40 ,0);
			sheetObjects[1].SetCellValue(4, prefix2 + 'bulk_amount',0 ,0);
    }
    /**
     * When there are changes in the value of the first sheet processing makes data back.
     * 
     * @param Row
     * @param Col
     * @param Value
     * @return
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value){    	 
    	var prefix1='sheet1_';
//    	if( Col == 12 ){
//    		if( '' != Value  && 'N' != Value && 'B' != Value)
//    			sheetObj.CellValue2(Row, prefix1+"whf_amt") = 0;
//    		else
//    			sheetObj.CellValue2(Row, prefix1+"whf_amt") = sheetObj.CellValue(Row, prefix1+"whf_amt_temp");   		
//    	}
    	// In case of  changing Weight and  Measure in Cntr Bulk Qty ..Amount can be changed
    	var Colnm=sheetObj.ColSaveName(Col);
    	if(  Colnm == 'sheet1_whf_amt' || Colnm == 'sheet1_whf_cntr_20ft_qty' || Colnm == 'sheet1_whf_cntr_40ft_qty' || 
    		 Colnm == 'sheet1_whf_cntr_45ft_qty' || Colnm == 'sheet1_blk_wgt_qty' || Colnm == 'sheet1_blk_meas_qty'){
    		if ( 'BLK' == sheetObj.GetCellValue(Row, prefix1 + 'whf_pck_tp_cd'))
    		{
    			sheetObj.SetCellValue(Row, prefix1 + 'whf_amt',Math.round(accountForBulkAmt(sheetObj, Row, Col, Value)) + Math.round(accountForWhfAmt(sheetObj, Row, Col, Value)),0);
    		}
    		else
    		{
    			sheetObj.SetCellValue(Row, prefix1 + 'whf_amt',Math.round(accountForWhfAmt(sheetObj, Row, Col, Value)),0);
    		}
    	}
    	// In case of changing CNT/BLK select box calculate AMOUT 
    	if( Col == 27 ){
    		//if('BLK' == Value){
				if('BLK' == sheetObj.GetCellValue(Row, prefix1 + 'whf_pck_tp_cd')){
				sheetObj.SetCellValue(Row, prefix1 + 'whf_blk_20ft_qty',sheetObj.GetCellValue(Row, prefix1 + 'whf_cntr_20ft_qty'),0);
				sheetObj.SetCellValue(Row, prefix1 + 'whf_blk_40ft_qty',sheetObj.GetCellValue(Row, prefix1 + 'whf_cntr_40ft_qty'),0);
				sheetObj.SetCellValue(Row, prefix1 + 'whf_blk_45ft_qty',sheetObj.GetCellValue(Row, prefix1 + 'whf_cntr_45ft_qty'),0);
    			sheetObj.SetCellValue(Row, prefix1 + 'whf_cntr_20ft_qty',0,0);
    			sheetObj.SetCellValue(Row, prefix1 + 'whf_cntr_40ft_qty',0,0);
    			sheetObj.SetCellValue(Row, prefix1 + 'whf_cntr_45ft_qty',0,0);
    			//sheetObj.CellValue2(Row, prefix1+'blk_wgt_qty')  = sheetObj.CellValue(Row, prefix1+'blk_wgt_qty2');
    			//sheetObj.CellValue2(Row, prefix1+'blk_meas_qty') = sheetObj.CellValue(Row, prefix1+'blk_meas_qty2');
				sheetObj.SetCellValue(Row, prefix1+'blk_wgt_qty',sheetObj.GetCellValue(Row, prefix1+'wgt_qty'),0);
				sheetObj.SetCellValue(Row, prefix1+'blk_meas_qty',sheetObj.GetCellValue(Row, prefix1+'meas_qty'),0);
    		}else{
				sheetObj.SetCellValue(Row, prefix1 + 'whf_cntr_20ft_qty',sheetObj.GetCellValue(Row, prefix1 + 'whf_blk_20ft_qty'),0);
				sheetObj.SetCellValue(Row, prefix1 + 'whf_cntr_40ft_qty',sheetObj.GetCellValue(Row, prefix1 + 'whf_blk_40ft_qty'),0);
				sheetObj.SetCellValue(Row, prefix1 + 'whf_cntr_45ft_qty',sheetObj.GetCellValue(Row, prefix1 + 'whf_blk_45ft_qty'),0);
    			sheetObj.SetCellValue(Row, prefix1 + 'whf_blk_20ft_qty',0,0);
    			sheetObj.SetCellValue(Row, prefix1 + 'whf_blk_40ft_qty',0,0);
    			sheetObj.SetCellValue(Row, prefix1 + 'whf_blk_45ft_qty',0,0);
    			sheetObj.SetCellValue(Row, prefix1+'blk_wgt_qty',0,0);
    			sheetObj.SetCellValue(Row, prefix1+'blk_meas_qty',0,0);
    		}
//    		sheetObj.CellValue2(Row, prefix1 + 'whf_amt') 
//    		= Math.round( accountForWhfAmt(sheetObj, Row, Col, Value) + accountForBulkAmt(sheetObj, Row, Col, Value) );
//    		
//    		if( 'BLK' != Value )
//    			sheetObj.CellValue2(Row, prefix1+'bulk_rton_appl_type') = '';
    	}
    	if ( 'BLK' == sheetObj.GetCellValue(Row,prefix1 + 'whf_pck_tp_cd'))
    	{
			sheetObj.SetCellValue(Row, prefix1 + 'whf_amt',Math.round(accountForBulkAmt(sheetObj, Row, Col, Value)) + Math.round(accountForWhfAmt(sheetObj, Row, Col, Value)),0);
    	}
    	else
    	{
    		sheetObj.SetCellValue(Row, prefix1 + 'rton_wgt',0,0);
    		sheetObj.SetCellValue(Row, prefix1 + 'bulk_wharfage_amount',0,0);
    		sheetObj.SetCellValue(Row, prefix1 + 'whf_amt',Math.round( accountForWhfAmt(sheetObj, Row, Col, Value)),0);
    	}
    	if( 'BLK' != sheetObj.GetCellValue(Row, prefix1 + 'whf_pck_tp_cd') )
			sheetObj.SetCellValue(Row, prefix1+'bulk_rton_appl_type','',0);
    	if ( document.form.whf_bnd_cd.value == 'IT' || document.form.whf_bnd_cd.value == 'OT')
    	{
    		sheetObj.SetCellValue(Row, prefix1 + 'whf_amt',0,0);
    	}
    	// Data generated at the bottom of the screen
    	if( Col != 1 ){
    		createData();
    	}
    }
    /**
     * CNTR Amount calculation
     * 
     * @param sheetObj
     * @param Row
     * @param Col
     * @param Value
     * @return
     */
    function accountForWhfAmt(sheetObj, Row, Col, Value){
    	var prefix1='sheet1_';
    	var formObj=document.form ;
    	var v20Rt=formObj.kr_whf_cntr_20ft_rt.value ;
    	var v40Rt=formObj.kr_whf_cntr_40ft_rt.value ;
    	var v45Rt=formObj.kr_whf_cntr_45ft_rt.value ;
    	var v20Amt=0;
    	var v40Amt=0;
    	var v45Amt=0;
		v20Amt=parseFloatWithoutComma(sheetObj.GetCellValue(Row, prefix1 + 'whf_cntr_20ft_qty')) * v20Rt;
		v40Amt=parseFloatWithoutComma(sheetObj.GetCellValue(Row, prefix1 + 'whf_cntr_40ft_qty')) * v40Rt;
		v45Amt=parseFloatWithoutComma(sheetObj.GetCellValue(Row, prefix1 + 'whf_cntr_45ft_qty')) * v45Rt;
    	//sheetObj.CellValue2(Row, prefix1 + 'whf_amt') = v20Amt + v40Amt + v45Amt ;
		if ( sheetObj.GetCellValue(Row,prefix1 + 'whf_amt') < 0 )
    	{
			return sheetObj.GetCellValue(Row,11);
    	}
		else if( '' != sheetObj.GetCellValue(Row, prefix1 + 'wfg_expt_cd')  && 'N' != sheetObj.GetCellValue(Row, prefix1 + 'wfg_expt_cd') && 'B' != sheetObj.GetCellValue(Row,prefix1 + 'wfg_expt_cd'))
    	{
			return 0;
    	}
		else
		{
			return v20Amt + v40Amt + v45Amt ;
		}
    }
    /**
     * BULK Amount calculation
     * 
     * @param sheetObj
     * @param Row
     * @param Col
     * @param Value
     * @return
     */
    function accountForBulkAmt(sheetObj, Row, Col, Value){
    	var prefix1='sheet1_';
    	var formObj=document.form ;
    	var vBlkRt=formObj.kr_whf_blk_rt.value ;
    	var vMRt=0.883 ;
		var vWgt=parseFloatWithoutComma(sheetObj.GetCellValue(Row, prefix1 + 'blk_wgt_qty')) ;
		var vMes=parseFloatWithoutComma(sheetObj.GetCellValue(Row, prefix1 + 'blk_meas_qty')) ;
    	var vRton=0 ;
    	if( vWgt >= vMes ) {
    		vRton=Math.ceil( vWgt );
    		sheetObj.SetCellValue(Row, prefix1 + 'bulk_rton_appl_type',"W",0);
    	} else {
    		vRton=Math.ceil( vMes * vMRt );
    		sheetObj.SetCellValue(Row, prefix1 + 'bulk_rton_appl_type',"E",0);
    	}
    	sheetObj.SetCellValue(Row, prefix1 + 'rton_wgt',vRton,0);
    	sheetObj.SetCellValue(Row, prefix1 + 'bulk_wharfage_amount',parseInt( vRton * vBlkRt ) ,0);
    	return vRton * vBlkRt ;
    }
    function sheet1_OnMouseDown(sheetObj, Button, Shifft, X, Y){
    	if( '2' == Button ){
    		var m_row=sheetObj.MouseRow();
    		var m_col=sheetObj.MouseCol();
    		vFreeRow=m_row ; 
    		if( vFreeCol == m_col )
    		  doActionIBSheet(sheetObjects[0],document.form,COMMAND06);
    	}	
    }
    function addRowSheet1( BlNo ,BkgNo ,Vvd ,PolCd ,PodCd, WhfBndCd ){
    	var formObject=document.form;
/*    	var vWbndCd=WhfBndCd.substr(0,1);
    	if( 'I' == vWbndCd )
    		formObject.port_cd.value=PodCd;
    	else if( 'O' == vWbndCd  )
    		formObject.port_cd.value=PolCd;
    	formObject.whf_bnd_cd.value=WhfBndCd;*/
    	doActionIBSheet(sheetObjects[0],formObject,SEARCH01);
    }
    /**
     * as changing retrieve condition , sheet initialization
     * @return
     */
    function obj_Change() {
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
    	if (srcName == "whf_bnd_cd") {
    		sheetObjects[0].RemoveAll();
    		sheetObjects[1].RemoveAll();
    		formObject.total_bl_count.value="";
    		formObject.total_wharfage.value="";
    		formObject.whf_rt_amt.value="";
    		formObject.rtotal1.value="";
    		formObject.rtotal2.value="";
    		formObject.rtotal3.value="";
    	}
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[1]);
    } 

