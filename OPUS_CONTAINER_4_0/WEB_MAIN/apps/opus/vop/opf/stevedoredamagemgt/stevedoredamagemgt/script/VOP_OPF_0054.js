/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_opf_0054.js
*@FileTitle  : Stevedore Damage History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/21
=========================================================*/
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
	   　
	         var sheetObject1=sheetObjects[0];
	     /*******************************************************/
	     var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false; 
	        switch(srcName) {
				case "btn_Print":
					//ComOpenPopup("VOP_OPF_1054.do", 800, 550, "", "0,0", true, false, null,null,null,"HistoryReportPop");
					rdOpen();
					break;
				case "btn_Close":
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
    //RD common pop-up  
    function rdOpen(){
    	var formObject=document.form;
    	var rdParam="/rp ["+formObject.stv_dmg_no.value+"]";
    	var strPath="apps/opus/vop/opf/stevedoredamagemgt/stevedoredamagemgt/report/VOP_OPF_1054.mrd";
    	formObject.com_mrdPath.value=strPath;
    	formObject.com_mrdArguments.value=rdParam;
    	ComOpenRDPopupModal();
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
	        //change start configuration method name 
				ComConfigSheet (sheetObjects[i] );
				initSheet(sheetObjects[i],i+1);
	        //add last configuration method 
				ComEndConfigSheet(sheetObjects[i]);
			}
			doActionIBSheet(sheetObjects[0],document.form, IBSEARCH);
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
	    var cnt=0;
		var sheetID=sheetObj.id;
	    switch(sheetID) {
	        case "sheet1":
	            with(sheetObj){	            
			          var HeadTitle1="|No.||Date|Time|Office|ID|Name|Requirement\nCategory|Process|Process|Process";
			          var HeadTitle2="|No.||Date|Time|Office|ID|Name|Requirement\nCategory|Repair|Compen.|Settle";
			          var headCount=ComCountHeadTitle(HeadTitle1);
			          var prefix="sheet1_";
		
			          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
			          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			          var headers = [ { Text:HeadTitle1, Align:"Center"},
			                      { Text:HeadTitle2, Align:"Center"} ];
			          InitHeaders(headers, info);
		
			          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
			                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",                         KeyField:0,   CalcLogic:"",   Format:"Integer" },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_step_his_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_time",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cre_usr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_proc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rpr_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cmpn_sts_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stl_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			           
			          InitColumns(cols);
			          SetEditable(1);
			          SetRangeBackColor(1,8,1,11,"#555555");
			          SetSheetHeight(300);
	                }

	            break;
	    	}
	}
	/**
	 * set Damage info
	 */
	function setDamageData(sheetObj, formObj, dataXml){
		//var dataXml = sheetObj.GetSearchXml("VOP_OPF_0054GS.do" , FormQueryString(formObj));
		formObj.vsl_cd.value=ComGetEtcData(dataXml, "vsl_cd");
		formObj.skd_voy_no.value=ComGetEtcData(dataXml, "skd_voy_no");
		formObj.skd_dir_cd.value=ComGetEtcData(dataXml, "skd_dir_cd");
		formObj.vps_port_cd.value=ComGetEtcData(dataXml, "vps_port_cd");
		formObj.stv_dmg_evnt_dt.value=ComGetEtcData(dataXml, "stv_dmg_evnt_dt");
		formObj.slan_cd.value=ComGetEtcData(dataXml, "slan_cd");
		formObj.stv_dmg_ref_no.value=ComGetEtcData(dataXml, "stv_dmg_ref_no");
		formObj.clm_hndl_ofc_cd.value=ComGetEtcData(dataXml, "clm_hndl_ofc_cd");
	}
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
	    switch(sAction) {
	      case IBSEARCH:
	        formObj.f_cmd.value=SEARCH;
	        //sheetObj.DoSearch("VOP_OPF_0054GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
	        var dataXml=sheetObj.GetSearchData("VOP_OPF_0054GS.do" , FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
	        if (dataXml != ""){
	        	sheetObj.LoadSearchData(dataXml,{Sync:1} );
		        setDamageData(sheetObj, formObj, dataXml);
	        }
	        break;
	    }
	}
	/**
	 * handling process for input validation
	 */
//	function validateForm(sheetObj,formObj,sAction){
//	    with(formObj){
//	    }
//	    return true;
//	}
	/* Developer performance  end */
