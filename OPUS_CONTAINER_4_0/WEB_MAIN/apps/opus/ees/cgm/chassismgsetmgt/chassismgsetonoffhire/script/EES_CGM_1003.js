/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1003.js
*@FileTitle  : Chassis Master Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================
*/

/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ees_cgm_1003 : ees_cgm_1003 business script for
 */

	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var IBSEARCH02=30;
	var tmp_eq_no = null;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		/** *** use additional sheet var in case of more than 2 tap each sheet *****/
	    var sheetObj=sheetObjects[0];
		/** *****************************************************/
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			var formObj=document.form;
			switch (srcName) {
			case "btn_retrieve":
				formObj.page_status.value="R";
				if(formObj.n2nd_chss_als_no.value == null || formObj.n2nd_chss_als_no.value == "")
				{
					if(formObj.chss_als_no.value == null || formObj.chss_als_no.value == ""){
						if(formObj.eq_no.value == null || formObj.eq_no.value == ""){
							ComShowCodeMessage("CGM20023", "Chassis No or Alias No");
							return;
						}
					}
				}
				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
				break;
				
			case "btn_mvmt":
				var param="";
			  	if(formObj.eq_no.value != '')
			  	{
			  		var pgmNo='EES_CGM_1105';
			  		var pgmUrl='/opuscntr/EES_CGM_1105.do';
			  		var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
			    	var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+formObj.eq_no.value ;   
			    	var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
			    	var winObj=window.open(pgmUrl+"?parentPgmNo="+parentPgmNo+src,"",sFeatures);
			    } else
			    	{
				  		var pgmNo='EES_CGM_1105';
				  		var pgmUrl='/opuscntr/EES_CGM_1105.do';
				  		var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
				    	var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo;   
				    	var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
				    	var winObj=window.open(pgmUrl+"?parentPgmNo="+parentPgmNo+src,"",sFeatures);
			    	}	
				break;	
				
			case "btn_status":
				var param="";
			  	if(formObj.eq_no.value != '')
			  	{
			  		var pgmNo='EES_CGM_1016';
			  		var pgmUrl='/opuscntr/EES_CGM_1016.do';
			  		var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
			    	var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+formObj.eq_no.value ;   
			    	var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
			    	var winObj=window.open(pgmUrl+"?parentPgmNo="+parentPgmNo+src,"",sFeatures);
			    }else
			    {
			  		var pgmNo='EES_CGM_1016';
			  		var pgmUrl='/opuscntr/EES_CGM_1016.do';
			  		var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
			    	var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo;   
			    	var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
			    	var winObj=window.open(pgmUrl+"?parentPgmNo="+parentPgmNo+src,"",sFeatures);
			    }	
				break;
				
			case "btn_spec":
				var param="";
			  	if(formObj.eq_no.value != '')
			  	{
			  		var pgmNo='EES_CGM_1002';
			  		var pgmUrl='/opuscntr/EES_CGM_1002.do';
			  		var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
			    	var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_spec_no="+formObj.eq_spec_no.value ;   
			    	var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
			    	var winObj=window.open(pgmUrl+"?parentPgmNo="+parentPgmNo+src,"",sFeatures);
			    } else
			    {
			    	var pgmNo='EES_CGM_1002';
			  		var pgmUrl='/opuscntr/EES_CGM_1002.do';
			  		var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
			    	var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo;   
			    	var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
			    	var winObj=window.open(pgmUrl+"?parentPgmNo="+parentPgmNo+src,"",sFeatures);
			    }	
				break;
				
			case "btn_mr":
				var param="";
			  	if(formObj.eq_no.value != '')
			  	{
			  		var pgmNo='EES_MNR_0028';
			  		var pgmUrl='/opuscntr/EES_MNR_0028.do';
			  		var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
			    	var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&from_sys=CGM&eq_type=Z&eq_no="+formObj.eq_no.value ;   
			    	var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
			    	var winObj=window.open(pgmUrl+"?parentPgmNo="+parentPgmNo+src,"",sFeatures);
			    } else
			    {
			  		var pgmNo='EES_MNR_0028';
			  		var pgmUrl='/opuscntr/EES_MNR_0028.do';
			  		var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
			    	var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&from_sys=CGM&eq_type=Z";   
			    	var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
			    	var winObj=window.open(pgmUrl+"?parentPgmNo="+parentPgmNo+src,"",sFeatures);
			    }	
				break;
				
			case "btn_print": 
				if(form.aciac_div_cd.value == "" 
					&& form.onh_dt.value == ""
					&& form.onh_ofc_cd.value == ""
					&& form.eq_tpsz_cd.value == ""
					&& form.mft_dt.value == ""
					&& form.chss_pool_cd.value == ""
					&& form.eq_spec_no.value == ""
					&& form.chss_tare_wgt.value == ""
					&& form.aciac_div_cd.value == ""
					&& form.aciac_div_cd.value == ""
					&& form.aciac_div_cd.value == ""
				)   {
						errMsg='No data found.';
						ComShowMessage(msgs["CGM10012"]);
						return;
					}
					formObj.f_cmd.value=IBSEARCH02;
					ComOpenPopupWithTarget('/opuscntr/EES_CGM_1004.do', 775, 800, "", "0,1,1,1,1,1,1", true);
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
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		var sheetObj=sheetObjects[0];
		formObj=document.form;
	    for(i=0;i<sheetObjects.length;i++){
	    	ComConfigSheet (sheetObjects[i] );
	    	initSheet(sheetObjects[i],i+1);
	    	ComEndConfigSheet(sheetObjects[i]);
	    }
	    axon_event.addListener ("click",	"obj_onClick",	"chss_rgst_prd_cd");
	//  axon_event.addListenerFormat("keypress",	"obj_keypress",		formObj);
	    axon_event.addListener('click', 'pop_atch_cntr', 'atch_cntr');			// atch_cntr popup
	    axon_event.addListener('click', 'pop_atch_mgs', 'atch_mgs');			// atch_mgs popup
	    if(formObj.eq_no.value != ""){
	    	formObj.page_status.value='R';
	    	doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
	    }
	}
	/**
	 * page init combo
	 */
	function initControl(){
		// chungpa 200900803 init impl
		formObj=document.form;
		formObj.eq_no.value="";
		formObj.aciac_div_cd.value="";
		formObj.onh_dt.value="";
		formObj.onh_ofc_cd.value="";
		formObj.eq_tpsz_cd.value="";
		formObj.mft_dt.value="";
		formObj.chss_pool_cd.value="";
		formObj.disp_flg.value="";
		formObj.eq_spec_no.value="";
		formObj.chss_tare_wgt.value="";
		formObj.chss_mvmt_sts_cd.value="";
		formObj.crnt_yd_cd.value="";
		formObj.chss_mvmt_dt.value="";
		formObj.agreement_no.value="";
		formObj.agreement_no.value="";
		formObj.agmt_lstm_cd.value="";
		formObj.act_onh_dt.value="";
		formObj.agmt_ref_no.value="";
		formObj.vndr_abbr_nm.value="";
		formObj.chss_als_no.value="";
		formObj.n2nd_chss_als_no.value="";
		formObj.chss_rgst_ste_cd.value="";
		formObj.chss_rgst_lic_no.value="";
		formObj.chss_rgst_yr.value="";
		formObj.chss_veh_id_no.value="";
		//formObj.chss_tit_no.value		= "";
		formObj.chss_rgst_exp_dt.value="";
		formObj.chss_rgst_upd_dt.value="";
		formObj.chss_rgst_upd_id.value="";
		formObj.upd_dt.value="";
		formObj.upd_usr_id.value="";
		// Disposal check
		form.disp_flg.checked=false;
		// Weight 
		formObj.chss_tare_wgt.value=""
		// CNTR check box
		formObj.cntr_chk.checked=false;
		// MGSET check box
		formObj.mgset_chk.checked=false;
		// BARE check box
		formObj.bare_chk.checked=false;
		// DAMAGE check box
		formObj.damage_chk.checked=false;
		// LSTAY check box
		formObj.lstay_chk.checked=false
		formObj.chss_rgst_prd_cd[0].checked=false;
		formObj.chss_rgst_prd_cd[1].checked=false;
		formObj.cntr_chk.disabled=false;
		formObj.mgset_chk.disabled=false;
		formObj.bare_chk.disabled=false;
		formObj.damage_chk.disabled=false;
		formObj.lstay_chk.disabled=false;
		formObj.disp_flg.disabled=false;
		// radio button ENABLE
		formObj.chss_rgst_prd_cd[0].disabled=false;
		formObj.chss_rgst_prd_cd[1].disabled=false;
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
			          var HeadTitle="|eq_no|eq_knd_cd|aciac_div_cd|onh_dt|onh_ofc_cd|eq_tpsz_cd|mft_dt|chss_pool_cd|disp_flg|eq_spec_no|chss_tare_wgt|chss_mvmt_sts_cd|crnt_yd_cd|chss_mvmt_dt|cntr_chk|mgset_chk|bare_chk|damage_chk|lstay_chk|agreement_no|agmt_lstm_cd|act_onh_dt|agmt_ref_no|vndr_abbr_nm|chss_als_no|n2nd_chss_als_no|chss_rgst_ste_cd|chss_rgst_lic_no|chss_rgst_yr|chss_veh_id_no|chss_tit_no|chss_rgst_prd_cd|chss_rgst_exp_dt|cre_dt|cre_usr_id|upd_dt|upd_usr_id|atch_cntr|atch_mgs";
			          var headCount=ComCountHeadTitle(HeadTitle);
			          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			          var headers = [ { Text:HeadTitle, Align:"Center"} ];
			          InitHeaders(headers, info);
			          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_knd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"aciac_div_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"onh_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"onh_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mft_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_pool_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"disp_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_spec_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_tare_wgt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_mvmt_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"crnt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_mvmt_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mgset_chk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bare_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"damage_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"lstay_chk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agreement_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agmt_lstm_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"act_onh_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agmt_ref_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vndr_abbr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_als_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n2nd_chss_als_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_rgst_ste_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_rgst_lic_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_rgst_yr",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_veh_id_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_tit_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_rgst_prd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_rgst_exp_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"atch_cntr",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"atch_mgs",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			          InitColumns(cols);
			          SetEditable(1);
			          SetSheetHeight(160);
	                }
	            break;
	            
	    	case 2:      //sheet2 init
	            with(sheetObj){
			          var HeadTitle="|eq_no|eq_knd_cd|aciac_div_cd|onh_dt|onh_ofc_cd|eq_tpsz_cd|mft_dt|chss_pool_cd|disp_flg|eq_spec_no|chss_tare_wgt|chss_mvmt_sts_cd|crnt_yd_cd|chss_mvmt_dt|cntr_chk|mgset_chk|bare_chk|damage_chk|lstay_chk|agreement_no|agmt_lstm_cd|act_onh_dt|agmt_ref_no|vndr_abbr_nm|chss_als_no|n2nd_chss_als_no|chss_rgst_ste_cd|chss_rgst_lic_no|chss_rgst_yr|chss_veh_id_no|chss_tit_no|chss_rgst_prd_cd|chss_rgst_exp_dt|cre_dt|cre_usr_id|upd_dt|upd_usr_id|atch_cntr|atch_mgs";
			          var headCount=ComCountHeadTitle(HeadTitle);
			          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			          var headers = [ { Text:HeadTitle, Align:"Center"} ];
			          InitHeaders(headers, info);
			          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_knd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"aciac_div_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"onh_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"onh_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mft_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_pool_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"disp_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_spec_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_tare_wgt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_mvmt_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"crnt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_mvmt_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mgset_chk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bare_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"damage_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"lstay_chk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agreement_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agmt_lstm_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"act_onh_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agmt_ref_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vndr_abbr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_als_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n2nd_chss_als_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_rgst_ste_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_rgst_lic_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_rgst_yr",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_veh_id_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_tit_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_rgst_prd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_rgst_exp_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"atch_cntr",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"atch_mgs",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			          InitColumns(cols);
			          SetEditable(1);
			          SetSheetHeight(160);
	                }
	            break;
	        
	    	case 3:      //sheet3 init
	            with(sheetObj){
			          var HeadTitle="|eq_no|eq_knd_cd|aciac_div_cd|onh_dt|onh_ofc_cd|eq_tpsz_cd|mft_dt|chss_pool_cd|disp_flg|eq_spec_no|chss_tare_wgt|chss_mvmt_sts_cd|crnt_yd_cd|chss_mvmt_dt|cntr_chk|mgset_chk|bare_chk|damage_chk|lstay_chk|agreement_no|agmt_lstm_cd|act_onh_dt|agmt_ref_no|vndr_abbr_nm|chss_als_no|n2nd_chss_als_no|chss_rgst_ste_cd|chss_rgst_lic_no|chss_rgst_yr|chss_veh_id_no|chss_tit_no|chss_rgst_prd_cd|chss_rgst_exp_dt|cre_dt|cre_usr_id|upd_dt|upd_usr_id|atch_cntr|atch_mgs";
			          var headCount=ComCountHeadTitle(HeadTitle);
			          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			          var headers = [ { Text:HeadTitle, Align:"Center"} ];
			          InitHeaders(headers, info);
			          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_knd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"aciac_div_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"onh_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"onh_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mft_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_pool_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"disp_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_spec_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_tare_wgt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_mvmt_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"crnt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_mvmt_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mgset_chk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bare_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"damage_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"lstay_chk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agreement_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agmt_lstm_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"act_onh_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agmt_ref_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vndr_abbr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_als_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n2nd_chss_als_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_rgst_ste_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_rgst_lic_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_rgst_yr",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_veh_id_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_tit_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_rgst_prd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_rgst_exp_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"atch_cntr",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"atch_mgs",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			          InitColumns(cols);
			          SetEditable(1);
			          SetSheetHeight(160);
	                }
	            break;
	    }
	}
	/**
	 * handling process for Sheet
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		switch (sAction) {
			// Search First
			case IBSEARCH_ASYNC01:
		 		sheetObj.SetWaitImageVisible(0);
		 		ComOpenWait(true);		 
				formObj.f_cmd.value=SEARCH;
//				prompt("IBSEARCH_ASYNC01", FormQueryString(formObj));
				sheetObjects[0].DoSearch("EES_CGM_1003GS.do",FormQueryString(formObj) );
				
				break;
			
			// Search Second
			case IBSEARCH_ASYNC02:
				formObj.f_cmd.value=SEARCH;
//				prompt("IBSEARCH_ASYNC02", FormQueryString(formObj));
				sheetObjects[1].DoSearch("EES_CGM_1003GS.do",FormQueryString(formObj) );
				
				break;
				
			// Search Third
			case IBSEARCH_ASYNC03:
				formObj.f_cmd.value=SEARCH;
//				prompt("IBSEARCH_ASYNC03", FormQueryString(formObj));
				sheetObjects[2].DoSearch("EES_CGM_1003GS.do",FormQueryString(formObj) );
				
				break;
				
		}
	}
	
	
	function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
			
		var formObj=document.form;
//		alert("sheet1 : " + sheetObj.RowCount("R"));
		
		if(sheetObj.RowCount("R") == 0) {
			//2차 retrieve
			tmp_eq_no = formObj.eq_no.value; // 전역변수
			formObj.eq_no.value = "";
			formObj.chss_als_no.value = tmp_eq_no;
			
			doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC02);
			
		} else {
			ComOpenWait(false);
			setValueFromSheetToForm(formObj, sheetObj);
		}
 		
	}
	
	function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
		
		var formObj=document.form;
//		alert("sheet2 : " + sheetObj.RowCount("R"));
		
		if(sheetObj.RowCount("R")== 0) {
			//3차 retrieve
			formObj.chss_als_no.value = "";
			formObj.n2nd_chss_als_no.value=tmp_eq_no;
			doActionIBSheet(sheetObjects[2], formObj, IBSEARCH_ASYNC03);
			
		} else {
			ComOpenWait(false);
			setValueFromSheetToForm(formObj, sheetObj);
		}
		
	}
	
	function sheet3_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
		
		var formObj=document.form;
//		alert("sheet3 : " + sheetObj.RowCount("R"));
		
		if(sheetObj.RowCount("R")== 0)
		{
			initControl();
			formObj.eq_no.value=tmp_eq_no;
			ComShowCodeMessage("CGM20023", formObj.eq_no.value);
	 		ComOpenWait(false);	
			return;
		} else {
			ComOpenWait(false);
			setValueFromSheetToForm(formObj, sheetObj);
		}
	}
	
	function setValueFromSheetToForm(formObj, sheetObj) {
		// setting text field by retrieved grid value
		//Basic Information Start
		formObj.eq_no.value=sheetObj.GetCellValue(1, "eq_no");
		formObj.eq_tpsz_cd.value=sheetObj.GetCellValue(1, "eq_tpsz_cd");
		formObj.eq_spec_no.value=sheetObj.GetCellValue(1, "eq_spec_no");
		formObj.mft_dt.value=sheetObj.GetCellValue(1, "mft_dt");
		formObj.chss_tare_wgt.value=ComAddComma(sheetObj.GetCellValue(1, "chss_tare_wgt")); //add comma each 3
		//Basic Information End
		// Current Status Start
		formObj.aciac_div_cd.value=sheetObj.GetCellValue(1, "aciac_div_cd");
		formObj.chss_pool_cd.value=sheetObj.GetCellValue(1, "chss_pool_cd");
		formObj.onh_dt.value=sheetObj.GetCellValue(1, "onh_dt");
		formObj.onh_ofc_cd.value=sheetObj.GetCellValue(1, "onh_ofc_cd");
		formObj.chss_mvmt_sts_cd.value=sheetObj.GetCellValue(1, "chss_mvmt_sts_cd");
		formObj.crnt_yd_cd.value=sheetObj.GetCellValue(1, "crnt_yd_cd");
		formObj.chss_mvmt_dt.value=sheetObj.GetCellValue(1, "chss_mvmt_dt");
		if(sheetObj.GetCellValue(1, "cntr_chk") == "Y"){ 			// CNTR check box
			formObj.cntr_chk.checked=true;
		} else {
			formObj.cntr_chk.checked=false;
		}
		if(sheetObj.GetCellValue(1, "mgset_chk") == "Y"){			// MGSET check box
			formObj.mgset_chk.checked=true;
		} else {
			formObj.mgset_chk.checked=false;
		}
		if(sheetObj.GetCellValue(1, "bare_chk") == "Y"){			// BARE check box
			formObj.bare_chk.checked=true;
		} else {
			formObj.bare_chk.checked=false;
		}
		if(sheetObj.GetCellValue(1, "damage_chk") == "Y"){			// DAMAGE check box
			formObj.damage_chk.checked=true;
		} else {
			formObj.damage_chk.checked=false;
		}
		formObj.disp_flg.value=sheetObj.GetCellValue(1, "disp_flg");			// Disposal check
		if(sheetObj.GetCellValue(1, "disp_flg") == "Y"){
			form.disp_flg.checked=true;
		} else {
			form.disp_flg.checked=false;
		}			
		if(sheetObj.GetCellValue(1, "lstay_chk") == "Y"){			// LSTAY check box
			formObj.lstay_chk.checked=true;
		} else {
			formObj.lstay_chk.checked=false
		}
		formObj.agreement_no.value=sheetObj.GetCellValue(1, "agreement_no");
		formObj.agmt_lstm_cd.value=sheetObj.GetCellValue(1, "agmt_lstm_cd");
		formObj.act_onh_dt.value=sheetObj.GetCellValue(1, "act_onh_dt");
		formObj.chss_als_no.value=sheetObj.GetCellValue(1, "chss_als_no");
		formObj.agmt_ref_no.value=sheetObj.GetCellValue(1, "agmt_ref_no");
		formObj.vndr_abbr_nm.value=sheetObj.GetCellValue(1, "vndr_abbr_nm");
		formObj.n2nd_chss_als_no.value=sheetObj.GetCellValue(1, "n2nd_chss_als_no");
		//Agreement End
		//Registration Start
		formObj.chss_rgst_ste_cd.value=sheetObj.GetCellValue(1, "chss_rgst_ste_cd");
		formObj.chss_rgst_yr.value=sheetObj.GetCellValue(1, "chss_rgst_yr");
		formObj.chss_rgst_lic_no.value=sheetObj.GetCellValue(1, "chss_rgst_lic_no");
		formObj.chss_veh_id_no.value=sheetObj.GetCellValue(1, "chss_veh_id_no");
		//Expiry radio button check
		if(sheetObj.GetCellValue(1, "chss_rgst_prd_cd") == "P"){
			formObj.chss_rgst_prd_cd[0].checked=true;
		} else {
			formObj.chss_rgst_prd_cd[1].checked=true;
		}			
		formObj.chss_rgst_exp_dt.value=sheetObj.GetCellValue(1, "chss_rgst_exp_dt");
		//formObj.chss_tit_no.value      = sheetObj.CellValue(1, "chss_tit_no"); 
		//Registration End
		//added item start  
		formObj.atch_cntr.value=sheetObj.GetCellValue(1, "atch_cntr");
		formObj.atch_mgs.value=sheetObj.GetCellValue(1, "atch_mgs");
		//added item end
		//basic info 2 start
		formObj.chss_rgst_upd_dt.value=sheetObj.GetCellValue(1, "cre_dt");
		formObj.chss_rgst_upd_id.value=sheetObj.GetCellValue(1, "cre_usr_id");
		formObj.upd_dt.value=sheetObj.GetCellValue(1, "upd_dt");
		formObj.upd_usr_id.value=sheetObj.GetCellValue(1, "upd_usr_id");
		//basic info 2 end
		if(formObj.page_status.value == "R"){
			//check box DISABLE
			formObj.cntr_chk.disabled=true;
			formObj.mgset_chk.disabled=true;
			formObj.bare_chk.disabled=true;
			formObj.damage_chk.disabled=true;
			formObj.lstay_chk.disabled=true;
			formObj.disp_flg.disabled=true;
			//radio button DISABLE
			formObj.chss_rgst_prd_cd[0].disabled=true;
			formObj.chss_rgst_prd_cd[1].disabled=true;
		} else {
			// check box ENABLE
			formObj.cntr_chk.disabled=false;
			formObj.mgset_chk.disabled=false;
			formObj.bare_chk.disabled=false;
			formObj.damage_chk.disabled=false;
			formObj.lstay_chk.disabled=false;
			formObj.disp_flg.disabled=false;
			// radio button ENABLE
			formObj.chss_rgst_prd_cd[0].disabled=false;
			formObj.chss_rgst_prd_cd[1].disabled=false;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
			// if (!isNumber(formObj.iPage)) {
			// return false;
			// }
		}
		return true;
	}
	/**
	 * ALIAS check box select (ALIAS NO 2 ->> ALIAS NO2 TEXT BOX ENABLE-DISABLE)
	 */
	function obj_onClick(sheetObj, Row, Col){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		// ALIAS CHECKBOX
//		if(formObj.n2nd_chss_als_no_chk.checked == true){
//			formObj.chss_als_no.disabled=false;
//		} else {
//			formObj.chss_als_no.disabled=true;
//		}
		// EXPIRY RADIO
		if(formObj.chss_rgst_prd_cd[0].checked == true){
			sheetObj.SetCellValue(1, "chss_rgst_prd_cd","P");
		} else {
			sheetObj.SetCellValue(1, "chss_rgst_prd_cd","F");
		}
	}
	/**
	 * ALIAS NO DISABLE
	 */
	function aliasDisable(){
		var formObj=document.form;
		formObj.chss_als_no.disabled=true;
	}
	/**
	 * key input limit
	 */
//	function obj_keypress(){
//		 obj=event.srcElement;
//		 if(obj.dataformat == null){
//			 return;
//		 }
//		 window.defaultStatus=obj.dataformat;
//		 switch(obj.dataformat) {
//	  	    case "engup":
//		        if(obj.name == "eq_no" || obj.name=="chss_als_no" || obj.name=="n2nd_chss_als_no"){
//		        	ComKeyOnlyAlphabet("uppernum");
//		        }
//		        break;
//		    case "isnum":
//		    	ComKeyOnlyNumber(obj);
//		    	break;
//		 }
//	 }
	/** 
	 * pop_atch_cntr  popup event handling  <br>
	 * @param  
	 * @return 
	 * @author 
	 * @version 
	 */
	 function pop_atch_cntr(){
		  var formObj=document.form;
		  if(formObj.atch_cntr.value != "")
		  {
			  var formObj=document.form;
			  if(formObj.atch_cntr.value != "")
			  {
					var param="?pgmNo=EES_CGM_1109";
		   		   	param=param + "&f_cmd=" + SEARCH; 
		   			param=param + "&p_cntrno=" + formObj.atch_cntr.value;   
		   		    ComOpenPopup('/opuscntr/EES_CGM_1109.do' + param, 1080, 600, "", "1,0", true, false);
			  }
		  }
	 }	 
	/** 
	 * pop_atch_mgs popup event handling  <br>
	 * @param  
	 * @return 
	 * @author 
	 * @version 
	 */
	 function pop_atch_mgs(){
		  var formObj=document.form;
		  if(formObj.atch_mgs.value != "")
		  {
				var param="?pgmNo=EES_CGM_2006";
	   		   	param=param + "&f_cmd=" + SEARCH; 
	   			param=param + "&eq_no=" + formObj.atch_mgs.value;   
	   		    ComOpenPopup('/opuscntr/EES_CGM_2006.do' + param, 1080, 600, "", "1,0", true, false);
		  }
	 }
	/* developer jop end */