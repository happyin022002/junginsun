/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0060.js
*@FileTitle  :  Fleet Status
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/08
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class esm_fms_0060 : esm_fms_0060 definition of biz script for creation screen
     */
    //  common global variables 
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name  */
    function processButtonClick(){
    var sheetObject=sheetObjects[0];
    var sheetObject1=sheetObjects[1];
    var sheetObject2=sheetObjects[2];
    var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    	    switch(srcName) {
    	        case "btn_retrieve":
    	        	if(form.btn_periodFlag[0].checked) {
    	        		form.periodFlag.value="date";
    	        		form.schMonth.value="";
    	        		form.schMonthTo.value="";
    	        		form.schYear.value="";
    	        		form.schYearTo.value="";
    	        		form.schDt.value=form.schDate.value.replace(/-/g,"");
    	        		form.schDtTo.value=form.schDateTo.value.replace(/-/g,"");
    	        	} else if(form.btn_periodFlag[1].checked) {
    	        		form.periodFlag.value="month";
    	        		form.schDate.value="";
    	        		form.schDateTo.value="";
    	        		form.schYear.value="";
    	        		form.schYearTo.value="";
    	        		form.schDt.value=form.schMonth.value.replace("-","");
    	        		form.schDtTo.value=form.schMonthTo.value.replace("-","");
    	        	} else if(form.btn_periodFlag[2].checked) {
    	        		form.periodFlag.value="year";
    	        		form.schDate.value="";
    	        		form.schDateTo.value="";
    	        		form.schMonth.value="";
    	        		form.schMonthTo.value="";
    	        		form.schDt.value=form.schYear.value;
    	        		form.schDtTo.value=form.schYearTo.value;
    	        	}
    	        	if(form.vslSize1.value != '' && form.vslSize2.value != '') {
	    	        	if(form.btn_vslSizeFlag[0].checked) {
	     					form.vslSizeFlag.value="max";
	     				} else if(form.btn_vslSizeFlag[1].checked) {
	     					form.vslSizeFlag.value="14ton";
	     				}
    	    		} else {
    	    			form.vslSizeFlag.value="";
    	    		}
    	        	doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	            break;
    			case "btn_new":
    				ComResetAll();
    				initPeriod();
    				document.getElementById("style1").style.display="";
 					document.getElementById("style2").style.display="none";
 					document.getElementById("style3").style.display="none";
    				sheetObjects[1].SetVisible(false);
    	            break;
    			case "btn_DownExcel":
    				//sheetObject.SpeedDown2Excel(-1);
    				//sheetObject.Down2Excel(-1);
    				//Down2Excel();
    				sheetObject.Down2Excel({ SheetDesign:1, Merge:1, HiddenColumn:1 });
    	            break;
    			case "btn_print":
    				rdOpen(document.form);
    	            break;
    			case "btn_schDate":
    				var cal=new ComCalendar();
    				cal.setDisplayType('date');
					cal.select(form.schDate, 'yyyy-MM-dd');
    				break;
    			case "btn_schDateTo":
    				var cal=new ComCalendar();
    				cal.setDisplayType('date');
					cal.select(form.schDateTo, 'yyyy-MM-dd');
    				break;
    			case "btn_schMonth":
    				var cal=new ComCalendar();
    				cal.setDisplayType('month');
					cal.select(form.schMonth, 'yyyy-MM');
    				break;
    			case "btn_schMonthTo":
    				var cal=new ComCalendar();
    				cal.setDisplayType('month');
					cal.select(form.schMonthTo, 'yyyy-MM');
    				break;
    			case "btn_schYear":
    				var cal=new ComCalendar();
    				cal.setDisplayType('year');
 					cal.select(form.schYear, 'yyyy');
 					break;
    			case "btn_schYearTo":
    				var cal=new ComCalendar();
    				cal.setDisplayType('year');
 					cal.select(form.schYearTo, 'yyyy');
 					break;
    			case "btn_periodFlag":
    				initPeriod();
     				if(form.btn_periodFlag[0].checked) {
     					document.getElementById("style1").style.display="";
     					document.getElementById("style2").style.display="none";
     					document.getElementById("style3").style.display="none";     					
     				} else if(form.btn_periodFlag[1].checked) {
     					document.getElementById("style1").style.display="none";
     					document.getElementById("style2").style.display="";
     					document.getElementById("style3").style.display="none";
     				} else if(form.btn_periodFlag[2].checked) {
     					document.getElementById("style1").style.display="none";
     					document.getElementById("style2").style.display="none";
     					document.getElementById("style3").style.display="";
     				}
     				break;
    			case "btn_owner":
     				ComOpenPopup("ESM_FMS_0083.do", 500, 375, "setFromOwnerName", "1,0,1,1,1", true, false, null, null, null, "esm_fms_0083");
     				break;
    			case "btn_ownrClr":
     				form.ownrNm.value="";
     				form.ownrSeq.value="";
     				break;
    			case "btn_laneCd":
     				ComOpenPopup("ESM_FMS_0036.do", 620, 430, "setFromLaneCd", "1,0,1,1,1", true, false, null, null, null, "esm_fms_0036");
     				break;
    			case "btn_laneCdClr":
    				form.laneCd.value="";
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
    * Registering IBSheet Object as Array
    * In case there is needs to do batch processing, process saving as Array can be added
    * defining array on the top of source
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
    	sheet1_OnLoadFinish(sheet1);
    }
    /**
     * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
     * Adding first-served function
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.SetWaitImageVisible(0);
    	doActionIBSheet(sheetObj,document.form,IBSEARCH,"contractType");
		sheetObj.SetWaitImageVisible(1);
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	switch(sheetNo) {
        	case 1:      //sheet1 init
        	    with(sheetObj){
		              var HeadTitle1="Seq|Contract|Vessel\nCode|Vessel's \nFull Name|Owners|Flag|Built|Designed TEU|Designed TEU|Charter Period|Charter Period|Daily Hire Rate1|Daily Hire Rate1|Daily Hire Rate2|Daily Hire Rate2|Lane|Gear with|Reefer|Speed|Dead Weight|Gross Ton|Net|Period (+- Option)|Redelivery Range|Redelivery Notice";
		              var HeadTitle2="Seq|Contract|Vessel\nCode|Vessel's \nFull Name|Owners|Flag|Built|Max|14Ton|From|To|CURR|AMT|CURR|AMT|Lane|Gear with|Reefer|Speed|Dead Weight|Gross Ton|Net|Period (+- Option)|Redelivery Range|Redelivery Notice";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              (headCount, 5, 0, true);
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"},
		                          { Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Seq",       Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"flet_ctrt_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"vsl_eng_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:"ownr_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cnt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"vsl_bld_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"vsl_dznd_capa",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"bse_14ton_vsl_capa",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"hir_curr_n1st_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"hir_rt_n1st_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"hir_curr_n2nd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"hir_rt_n2nd_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"gr_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"rf_cntr_plg_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"shp_spd_qty",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ddwt_cgo_capa_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"grs_wgt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"nrt_wgt",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"chtr_prd_opt_ctnt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"rde_rng_ctnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"rde_ntc_ctnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		              SetEditable(1);
//		              SetSheetHeight(400);
			          SetCountPosition(0);
		              resizeSheet();
                    }
            	break;
        	case 2:      //sheet2 init
        	    with(sheetObj){
		              var HeadTitle1="Seq|Contract|Vessel\nCode|Vessel's \nFull Name|Owners|Flag|Built|Designed TEU|Designed TEU|Charter Period|Charter Period|Daily Hire Rate1|Daily Hire Rate1|Daily Hire Rate2|Daily Hire Rate2|Lane|Gear with|Reefer|Speed|Dead Weight|Gross Ton|Net|Period (+- Option)|Redelivery Range|Redelivery Notice";
		              var HeadTitle2="Seq|Contract|Vessel\nCode|Vessel's \nFull Name|Owners|Flag|Built|Max|14Ton|From|To|CURR|AMT|CURR|AMT|Lane|Gear with|Reefer|Speed|Dead Weight|Gross Ton|Net|Period (+- Option)|Redelivery Range|Redelivery Notice";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              (headCount, 5, 0, true);
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"},
		                          { Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Text",       Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"flet_ctrt_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"vsl_eng_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:"ownr_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cnt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"vsl_bld_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"vsl_dznd_capa",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"bse_14ton_vsl_capa",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"hir_curr_n1st_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"hir_rt_n1st_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"hir_curr_n2nd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"hir_rt_n2nd_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"gr_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"rf_cntr_plg_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"shp_spd_qty",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ddwt_cgo_capa_qty",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"grs_wgt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"nrt_wgt",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"chtr_prd_opt_ctnt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"rde_rng_ctnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"rde_ntc_ctnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		              SetEditable(1);
		              SetRowHidden(0, 1);
		              SetRowHidden(1, 1);
		              SetCountPosition(0);
		              SetVisible(false);
                    }
	        	break;
        	case 3:      //sheet3 init
        	    with(sheetObj){
		              var HeadTitle1="Seq|Contract|Vessel\nCode|Vessel's \nFull Name|Owners|Flag|Built|Designed TEU|Designed TEU|Charter Period|Charter Period|Daily Hire Rate1|Daily Hire Rate1|Daily Hire Rate2|Daily Hire Rate2|Lane|Gear with|Reefer|Speed|Dead Weight|Gross Ton|Net|Period (+- Option)|Redelivery Range|Redelivery Notice";
		              var HeadTitle2="Seq|Contract|Vessel\nCode|Vessel's \nFull Name|Owners|Flag|Built|Max|14Ton|From|To|CURR|AMT|CURR|AMT|Lane|Gear with|Reefer|Speed|Dead Weight|Gross Ton|Net|Period (+- Option)|Redelivery Range|Redelivery Notice";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              (headCount, 5, 0, true);
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"},
		                          { Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"Seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"flet_ctrt_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"vsl_eng_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:"ownr_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cnt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"vsl_bld_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"vsl_dznd_capa",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"bse_14ton_vsl_capa",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"hir_curr_n1st_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:0,   SaveName:"hir_rt_n1st_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"hir_curr_n2nd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"hir_rt_n2nd_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"gr_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"rf_cntr_plg_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"shp_spd_qty",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ddwt_cgo_capa_qty",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"grs_wgt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"nrt_wgt",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"chtr_prd_opt_ctnt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"rde_rng_ctnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"rde_ntc_ctnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		              SetEditable(1);
			          SetCountPosition(0);
		              SetVisible(false);
                    }
	        	break;
    	}
    }
    /**
     * Handling IBSheet's process(Retrieve, Save)<br>
     **/
    function doActionIBSheet(sheetObj,formObj,sAction,objNm) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
    		case IBSEARCH:
	    		if(objNm == "laneCd") {
		      		formObj.f_cmd.value=SEARCH05;
		      		var param=FormQueryString(formObj) + "&lane_cd=" + formObj.laneCd.value;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do", param);
		   			var laneNm=ComGetEtcData(sXml, "cdName");
		   			if(typeof laneNm != "undefined" && laneNm != "" ) {
		   				form.btn_laneCdClr.checked=true;
					} else {
						form.btn_laneCdClr.checked=false;
						formObj.laneCd.value="";
						ComAlertFocus(formObj.laneCd, ComGetMsg("FMS00006", "Lane Code"));
					}
	    		} else if(objNm == "contractType") {
	    			CoFmsGetCombo("FORM", formObj, sheetObj, "CD01513", "contractType", "contractTypeText");
	    		} else {
		      		if(validateForm(sheetObj,formObj,sAction)) {
		      			formObj.f_cmd.value=SEARCH;
						//sheetObj.DoSearch("ESM_FMS_0060GS.do", FormQueryString(formObj));
 						var sXml=sheetObj.GetSearchData("ESM_FMS_0060GS.do", FormQueryString(formObj));
	       	   	  		var arrXml=sXml.split("|$$|");
	       	   	  		if (arrXml.length > 0) {
	       	   	  			sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
	       	   	  			//sheetObjects[1].RemoveAll();
	       	   	  			sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
	       	   	  			var total=ComFmsGetAttr(arrXml[1], "DATA", "TOTAL");
	       	   	  			
	       	   	  			//UI 성능개선(201408 민정호)
	       	   	  			if(total > 0) {
	       	   	  				sheetObjects[1].SetSheetHeight(40 + (total * 20));
	       	   	  			}
	       	   	  			
//	       	   	  			if(total > 0) {
//	       	   	  				sheetObjects[1].SetSheetHeight(40 + (total * 20));
//	       	   	  			} else {
//	       	   	  				sheetObjects[1].SetVisible(false);
//	       	   	  			}
	       	   	  			sheetObjects[1].SetVisible(total > 0);
	       	   	  		} else {
	       	   	  			sheetObjects[1].SetVisible(false);
	       	   	  		}
		      		}
	    		}
		       	break;
    	}
    }
    /**
     * Handling process for input validation<br>
     */
    function validateForm(sheetObj,formObj,sAction){
    	var	exptElems="";
    	if(form.btn_periodFlag[0].checked) {
    		exptElems="schMonth|schYear|schMonthTo|schYearTo";
    	} else if(form.btn_periodFlag[1].checked) {
    		exptElems="schDate|schYear|schDateTo|schYearTo";
    	} else if(form.btn_periodFlag[2].checked) {
    		exptElems="schDate|schMonth|schDateTo|schMonthTo";
    	}
    	if (!ComFmsChkValid(formObj, exptElems)) {
    		return false;
    	}
    	if(form.btn_periodFlag[0].checked) {
	    	if(parseInt(formObj.schDate.value.trimAll('-')) > parseInt(formObj.schDateTo.value.trimAll('-'))) {
	    		formObj.schDate.value="";
				ComAlertFocus(formObj.schDate, ComGetMsg('FMS01715'));
				return;
			}
    	} else if(form.btn_periodFlag[1].checked) {
    		if(parseInt(formObj.schMonth.value.trimAll('-')) > parseInt(formObj.schMonthTo.value.trimAll('-'))) {
	    		formObj.schMonth.value="";
				ComAlertFocus(formObj.schMonth, ComGetMsg('FMS01715'));
				return;
			}
    	} else if(form.btn_periodFlag[2].checked) {
    		if(parseInt(formObj.schYear.value.trimAll('-')) > parseInt(formObj.schYearTo.value.trimAll('-'))) {
	    		formObj.schYear.value="";
				ComAlertFocus(formObj.schYear, ComGetMsg('FMS01715'));
				return;
			}
    	}
    	if((form.vslSize1.value == "") && (form.vslSize2.value == "")) {
    		form.vslSizeFlag.value="";
    	}
    	if((formObj.vslSize1.value == "") &&
 		   (formObj.vslSize2.value != "")) {
 			ComAlertFocus(formObj.vslSize1, ComGetMsg("FMS00011", "Vessel Size"));
 			return false;
 		}
 		if((formObj.vslSize1.value != "") &&
 		   (formObj.vslSize2.value == "")) {
 			ComAlertFocus(formObj.vslSize2, ComGetMsg("FMS00011", "Vessel Size"));
 			return false;
 		}
 		if(parseInt(formObj.vslSize1.value.replace(/,/g,"")) > parseInt(formObj.vslSize2.value.replace(/,/g,""))) {
 			vslSize2.value="";
 			ComAlertFocus(formObj.vslSize2, ComGetMsg("FMS00010", "To Vessel Size", "From Vessel Size"));
 			return false;
 		}
    	return true;
    }
	/**
	 * Setting Head Ownership Name and Sequence selected in Owner List PopUp into Form Item <br>
	 * @param {arry} aryPopupData
	 */
	function setFromOwnerName(aryPopupData){
        form.ownrSeq.value=aryPopupData[0][3];
        form.ownrNm.value=aryPopupData[0][4];
        form.btn_ownrClr.checked=true;
	}
	/**
	 * Setting Lane Code selected in Lane Code PopUp into Form Item <br>
	 * @param {arry} aryPopupData
	 */
	function setFromLaneCd(aryPopupData){
        form.laneCd.value=aryPopupData[0][3];
        form.btn_laneCdClr.checked=true;
	}
	/**
     * Loading Event of HTML_Control existing on page dynamically <br>
     * Calling the function from {@link #loadPage} to initialize IBSheet Object<br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sequence of sheetObjects array
     **/
	function initControl() {
		DATE_SEPARATOR="-";
		initPeriod();
		axon_event.addListenerForm  ('change', 'obj_change', form); 				//- Code Handling to OnChange Event of All Controls
	}
	/**
     * Checking Validation of Duration in onblur Event of HTML Control<br>
     **/
    function obj_deactivate(){
    	if((event.srcElement.name == "schDate") ||
    	   (event.srcElement.name == "schMonth") ||
    	   (event.srcElement.name == "schYear")) {
    		ComChkObjValid(event.srcElement);
    	} else {
    		ComChkObjValid(event.srcElement);
    	}
    }
    /**
     * Only insert English/Numeric by onkeypress Event of HTML Control<br>
     **/
	function obj_change() {
	  	if((event.srcElement.name == "laneCd")) {
	  		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"laneCd");
	   	}
	}
    
	
   function smartHscroll(){
      $(".GMHScrollMid:eq(1) div:first-child").scrollLeft($(".GMHScrollMid:eq(0) div:first-child").scrollLeft());
   }
   
   function smartHscroll1(){
      $(".GMHScrollMid:eq(0) div:first-child").scrollLeft($(".GMHScrollMid:eq(1) div:first-child").scrollLeft());
   }
		   
		   
    /**
     * Setting retrieved data's Font Bold when OnSearchEnd Event of sheet2 is occurred <br>
     */
    function sheet2_OnSearchEnd(sheetObj, errMsg) {
    	
        $(".GMHScrollMid:eq(0) div:first-child").bind( 'scroll', smartHscroll );
        $(".GMHScrollMid:eq(1) div:first-child").bind( 'scroll', smartHscroll1 );
        
        
    	sheetObj.SetVisible(sheetObj.RowCount() > 0);
    	$('#DIV_sheet2 div.GMFillRow').hide();
    	for(var row = 2; row <= sheetObj.LastRow(); row++) {
    		if(row == 2) {
    			sheetObj.SetCellText(row, "Seq" ,"Total Amount");
    		} else {
    			sheetObj.SetCellText(row, "Seq" ,"");
    		}
    		sheetObj.SetRowBackColor(row,"#FFE6FB");
     		sheetObj.SetCellFont("FontBold", row, "Seq",1);
     		sheetObj.SetCellFont("FontBold", row, "flet_ctrt_tp_cd",1);
     		sheetObj.SetCellFont("FontBold", row, "ownr_nm",1);
     		sheetObj.SetCellFont("FontBold", row, "vsl_dznd_capa",1);
     		sheetObj.SetCellFont("FontBold", row, "bse_14ton_vsl_capa",1);
     		sheetObj.SetCellFont("FontBold", row, "hir_curr_n1st_cd",1);
     		sheetObj.SetCellFont("FontBold", row, "hir_rt_n1st_amt",1);
     		sheetObj.SetCellFont("FontBold", row, "hir_curr_n2nd_cd",1);
     		sheetObj.SetCellFont("FontBold", row, "hir_rt_n2nd_amt",1);
     		sheetObj.SetCellFont("FontBold", row, "ddwt_cgo_capa_qty",1);
     		sheetObj.SetCellFont("FontBold", row, "grs_wgt",1);
     		sheetObj.SetCellFont("FontBold", row, "nrt_wgt",1);
    	}
    }
    /**
     * Controlling Scroll Bar automatically when retrieving data <br>
     **/
    function controlScrollBar() {
		try{
			top.syncHeight();
		} catch(err){ComFuncErrMsg(err.message);}
	}
 	/**
 	 * Printing retrieved data <br>
 	 */
 	function rdOpen(formObject){
 		if(sheetObjects[0].RowCount() == 0) {
 			ComShowCodeMessage("FMS00015");
 			return;
 		}
  		
 		var rdParam = '/rv '+ RD_FormQueryString(formObject,1);
 		//var rdParam = '/rv '+ rdParam;
		var rdFile = 'apps/opus/esm/fms/timecharterinoutfleetmanagement/tcharterioinquiry/report/ESM_FMS_061.mrd';

 		formObject.com_mrdPath.value = rdFile;
 		formObject.com_mrdArguments.value = rdParam;
 	    ComOpenRDPopup();
	}
 	/**
 	 * Moving data to temporary sheet to print data part and summary part together, then printing as Excel <br>
 	 */
 	function Down2Excel(){
 		if(sheetObjects[0].RowCount()== 0) {
 			ComShowCodeMessage("FMS00016");
 			return;
 		}
    	var targetSheetObj=sheetObjects[2];
    	for(var row=targetSheetObj.HeaderRows(); row<sheetObjects[0].LastRow(); row++) {
    		var currRow=targetSheetObj.DataInsert();
    		targetSheetObj.SetCellText(currRow,"Seq" ,sheetObjects[0].GetCellText(row,"Seq"));
			targetSheetObj.SetCellValue(currRow,"flet_ctrt_tp_cd",sheetObjects[0].GetCellValue(row,"flet_ctrt_tp_cd"),0);
			targetSheetObj.SetCellValue(currRow,"vsl_cd",sheetObjects[0].GetCellValue(row,"vsl_cd"),0);
			targetSheetObj.SetCellValue(currRow,"vsl_eng_nm",sheetObjects[0].GetCellValue(row,"vsl_eng_nm"),0);
			targetSheetObj.SetCellValue(currRow,"ownr_nm",sheetObjects[0].GetCellValue(row,"ownr_nm"),0);
			targetSheetObj.SetCellValue(currRow,"vsl_cnt_cd",sheetObjects[0].GetCellValue(row,"vsl_cnt_cd"),0);
			targetSheetObj.SetCellValue(currRow,"vsl_bld_dt",sheetObjects[0].GetCellValue(row,"vsl_bld_dt"),0);
			targetSheetObj.SetCellValue(currRow,"vsl_dznd_capa",sheetObjects[0].GetCellValue(row,"vsl_dznd_capa"),0);
			targetSheetObj.SetCellValue(currRow,"bse_14ton_vsl_capa",sheetObjects[0].GetCellValue(row,"bse_14ton_vsl_capa"),0);
			targetSheetObj.SetCellValue(currRow,"eff_dt",sheetObjects[0].GetCellValue(row,"eff_dt"),0);
			targetSheetObj.SetCellValue(currRow,"exp_dt",sheetObjects[0].GetCellValue(row,"exp_dt"),0);
			targetSheetObj.SetCellValue(currRow,"hir_curr_n1st_cd",sheetObjects[0].GetCellValue(row,"hir_curr_n1st_cd"),0);
			targetSheetObj.SetCellValue(currRow,"hir_rt_n1st_amt",sheetObjects[0].GetCellValue(row,"hir_rt_n1st_amt"),0);
			targetSheetObj.SetCellValue(currRow,"hir_curr_n2nd_cd",sheetObjects[0].GetCellValue(row,"hir_curr_n2nd_cd"),0);
			targetSheetObj.SetCellValue(currRow,"hir_rt_n2nd_amt",sheetObjects[0].GetCellValue(row,"hir_rt_n2nd_amt"),0);
			targetSheetObj.SetCellValue(currRow,"slan_cd",sheetObjects[0].GetCellValue(row,"slan_cd"),0);
			targetSheetObj.SetCellValue(currRow,"gr_flg",sheetObjects[0].GetCellValue(row,"gr_flg"),0);
			targetSheetObj.SetCellValue(currRow,"slan_cd",sheetObjects[0].GetCellValue(row,"slan_cd"),0);
			targetSheetObj.SetCellValue(currRow,"rf_cntr_plg_qty",sheetObjects[0].GetCellValue(row,"rf_cntr_plg_qty"),0);
			targetSheetObj.SetCellValue(currRow,"shp_spd_qty",sheetObjects[0].GetCellValue(row,"shp_spd_qty"),0);
			targetSheetObj.SetCellValue(currRow,"ddwt_cgo_capa_qty",sheetObjects[0].GetCellValue(row,"ddwt_cgo_capa_qty"),0);
			targetSheetObj.SetCellValue(currRow,"grs_wgt",sheetObjects[0].GetCellValue(row,"grs_wgt"),0);
			targetSheetObj.SetCellValue(currRow,"nrt_wgt",sheetObjects[0].GetCellValue(row,"nrt_wgt"),0);
			targetSheetObj.SetCellValue(currRow,"chtr_prd_opt_ctnt",sheetObjects[0].GetCellValue(row,"chtr_prd_opt_ctnt"),0);
			targetSheetObj.SetCellValue(currRow,"rde_rng_ctnt",sheetObjects[0].GetCellValue(row,"rde_rng_ctnt"),0);
			targetSheetObj.SetCellValue(currRow,"rde_ntc_ctnt",sheetObjects[0].GetCellValue(row,"rde_ntc_ctnt"),0);
    	}
    	for(var row=sheetObjects[1].HeaderRows(); row<sheetObjects[1].LastRow(); row++) {
    		var currRow=targetSheetObj.DataInsert();
    		if(row == 2) {
    			targetSheetObj.SetCellValue(currRow,"Seq","Total Amount",0);
    		}
			targetSheetObj.SetCellValue(currRow,"flet_ctrt_tp_cd",sheetObjects[1].GetCellValue(row,"flet_ctrt_tp_cd"),0);
			targetSheetObj.SetCellValue(currRow,"vsl_cd",sheetObjects[1].GetCellValue(row,"vsl_cd"),0);
			targetSheetObj.SetCellValue(currRow,"vsl_eng_nm",sheetObjects[1].GetCellValue(row,"vsl_eng_nm"),0);
			targetSheetObj.SetCellValue(currRow,"ownr_nm",sheetObjects[1].GetCellValue(row,"ownr_nm"),0);
			targetSheetObj.SetCellValue(currRow,"vsl_cnt_cd",sheetObjects[1].GetCellValue(row,"vsl_cnt_cd"),0);
			targetSheetObj.SetCellValue(currRow,"vsl_bld_dt",sheetObjects[1].GetCellValue(row,"vsl_bld_dt"),0);
			targetSheetObj.SetCellValue(currRow,"vsl_dznd_capa",sheetObjects[1].GetCellValue(row,"vsl_dznd_capa"),0);
			targetSheetObj.SetCellValue(currRow,"bse_14ton_vsl_capa",sheetObjects[1].GetCellValue(row,"bse_14ton_vsl_capa"),0);
			targetSheetObj.SetCellValue(currRow,"eff_dt",sheetObjects[1].GetCellValue(row,"eff_dt"),0);
			targetSheetObj.SetCellValue(currRow,"exp_dt",sheetObjects[1].GetCellValue(row,"exp_dt"),0);
			targetSheetObj.SetCellValue(currRow,"hir_curr_n1st_cd",sheetObjects[1].GetCellValue(row,"hir_curr_n1st_cd"),0);
			targetSheetObj.SetCellValue(currRow,"hir_rt_n1st_amt",sheetObjects[1].GetCellValue(row,"hir_rt_n1st_amt"),0);
			targetSheetObj.SetCellValue(currRow,"hir_curr_n2nd_cd",sheetObjects[1].GetCellValue(row,"hir_curr_n2nd_cd"),0);
			targetSheetObj.SetCellValue(currRow,"hir_rt_n2nd_amt",sheetObjects[1].GetCellValue(row,"hir_rt_n2nd_amt"),0);
			targetSheetObj.SetCellValue(currRow,"slan_cd",sheetObjects[1].GetCellValue(row,"slan_cd"),0);
			targetSheetObj.SetCellValue(currRow,"gr_flg",sheetObjects[1].GetCellValue(row,"gr_flg"),0);
			targetSheetObj.SetCellValue(currRow,"slan_cd",sheetObjects[1].GetCellValue(row,"slan_cd"),0);
			targetSheetObj.SetCellValue(currRow,"rf_cntr_plg_qty",sheetObjects[1].GetCellValue(row,"rf_cntr_plg_qty"),0);
			targetSheetObj.SetCellValue(currRow,"shp_spd_qty",sheetObjects[1].GetCellValue(row,"shp_spd_qty"),0);
			targetSheetObj.SetCellValue(currRow,"ddwt_cgo_capa_qty",sheetObjects[1].GetCellValue(row,"ddwt_cgo_capa_qty"),0);
			targetSheetObj.SetCellValue(currRow,"grs_wgt",sheetObjects[1].GetCellValue(row,"grs_wgt"),0);
			targetSheetObj.SetCellValue(currRow,"nrt_wgt",sheetObjects[1].GetCellValue(row,"nrt_wgt"),0);
			targetSheetObj.SetCellValue(currRow,"chtr_prd_opt_ctnt",sheetObjects[1].GetCellValue(row,"chtr_prd_opt_ctnt"),0);
			targetSheetObj.SetCellValue(currRow,"rde_rng_ctnt",sheetObjects[1].GetCellValue(row,"rde_rng_ctnt"),0);
			targetSheetObj.SetCellValue(currRow,"rde_ntc_ctnt",sheetObjects[1].GetCellValue(row,"rde_ntc_ctnt"),0);
    	}
     	targetSheetObj.Down2Excel({ HiddenColumn:-1});
    	targetSheetObj.RemoveAll();
    }
	/**
	 * Changing Font of vsl_cd
	 */
	function sheet1_OnSearchEnd(sheetObj, errMsg) {

	}
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0], 100);
	}
	
	function initPeriod(){	
		var formObj = document.form;
		if(form.btn_periodFlag[0].checked) {
			setToday(formObj.schDate,"ymd");
	    	setToday(formObj.schDateTo,"ymd");	    	     					
		} else if(form.btn_periodFlag[1].checked) {
			setToday(formObj.schMonth,"ym");
	    	setToday(formObj.schMonthTo,"ym");
		} else if(form.btn_periodFlag[2].checked) {
			setToday(formObj.schYear,"y");
	    	setToday(formObj.schYearTo,"y");
		}
	}
	
