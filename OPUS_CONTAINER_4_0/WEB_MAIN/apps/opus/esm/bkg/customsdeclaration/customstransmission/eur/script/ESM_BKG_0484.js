﻿/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0484
*@FileTitle  : ESM_BKG_0484
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
=========================================================*/

var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var intervalId="";
var noDataXml = "<?xml version='1.0' ?><SHEET><ETC-DATA><ETC KEY='Exception'><![CDATA[]]></ETC><ETC KEY='TRANS_RESULT_KEY'><![CDATA[S]]></ETC></ETC-DATA><DATA  TOTAL='0'></DATA></SHEET>";
var resultJson = {};
var vvdExcelName = "";

document.onclick=processButtonClick;
	function processButtonClick(){
		var sheetObject1=sheetObjects[0];
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            if (!ComIsBtnEnable(srcName)) return;
            switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
				break;
				case "btn_DownExcel":
					doActionIBSheet(sheetObjects[0], formObject, IBDOWNEXCEL);
				break;
				case "btn_preview":
					formObject.edi_preview.value="Y";
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
				break;
				case "btn_sitpro":
					doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
				break;	
				case "p_option":
					if (formObject.p_option[1].checked) {
						p_pod_cd_temp.SetEnable(1);
						ComBtnDisable("btn_DownExcel");
						ComBtnDisable("btn_sitpro");
						ComBtnEnable("btn_DownENS");
						document.getElementById("mrn").disabled=false;
					} else {
						p_pod_cd_temp.SetEnable(0);
						ComBtnEnable("btn_DownExcel");
						ComBtnEnable("btn_sitpro");
						ComBtnDisable("btn_DownENS");
						document.getElementById("mrn").disabled=true;
						document.getElementById("mrn").checked=false;
					}
					sheetObjects[0].RemoveAll();
				break;
				case "btn_DownENS":
					doActionIBSheet(sheetObjects[0], formObject, "DownENS");
				break;
				case "btn_DownLDF":
					doActionIBSheet(sheetObjects[0], formObject, "DownLDF");
				break;					
            }
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
 
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
  
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
//    	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	axon_event.addListenerForm('change', 'bkg_change', document.form);
    	p_pod_cd_temp.SetEnable(0);
		ComBtnDisable("btn_DownENS");
    }
  
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
				var sheetID=sheetObj.id;
        switch(sheetID) {
        case "sheet1":
        	with(sheetObj){
        		var HeadTitle1="|Sel.|Seq.|BKG No.|STS|CGO|B/L No.|T.VVD|POR|B.POL|B.POD|DEL|BKG STAFF|act_vvd_cnt |slan_cd";
        		var headCount=ComCountHeadTitle(HeadTitle1);

        		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

        		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
        		InitHeaders(headers, info);

        		var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
        		             {Type:"DummyCheck", Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"check" },
        		             {Type:"Seq",       Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"Seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cgo_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"tvvd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"por_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"b_pol_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"b_pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"del_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"doc_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        		             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"act_vvd_cnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        		             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
             
        		InitColumns(cols);
        		SetEditable(1);
        		SetWaitImageVisible(0);
        		SetSheetHeight(472);
            }
        	break;
		case "sheet2":
		    with(sheetObj){
				var HeadTitle="|search_eu_1st_port_yd_cd|eu_1st_port_yd_cd|eu_1st_port_name|edi_mrn";
				var headCount=ComCountHeadTitle(HeadTitle);

				SetConfig( { SearchMode:2, Page:20, FrozenCol:0, DataRowMerge:1 } );

				var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"search_eu_1st_port_yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eu_1st_port_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eu_1st_port_name",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"edi_mrn",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
				InitColumns(cols);
				SetEditable(0);
        	}
		    break;
		case "sheet3":  //ENS Download
            with(sheetObj){
				var HeadTitle="";
				HeadTitle += "Number of items contained in the ENS"
				HeadTitle += "|Unique consignment reference number assigned to the goods";
				HeadTitle += "|Transport document number";
				HeadTitle += "|Consignor";
				HeadTitle += "|Shipper address";
				HeadTitle += "|Person lodging the ENS";
				HeadTitle += "|Consignee";
				HeadTitle += "|Cnee address";
				HeadTitle += "|Carrier";
				HeadTitle += "|Party to be notified at arrival of the goods";
				HeadTitle += "|Notify address";
				HeadTitle += "|Identity and nationality of active means of transport entering the EU";
				HeadTitle += "|Conveyance reference number";
				HeadTitle += "|Code for the first place of arrival in the EU";
				HeadTitle += "|Date and time of arrival at the first place in the EU";
				HeadTitle += "|Code(s) for the country(ies) of routing (including the countries of departure and destination) to the extent known";
				HeadTitle += "|Mode of transport at the border";
				HeadTitle += "|Code for the place of loading";
				HeadTitle += "|Code for the place of unloading";
				HeadTitle += "|Acceptable goods description (not necessary if the 4 digits HS code is provided)";
				HeadTitle += "|Code for the type of packages";
				HeadTitle += "|Number of packages";
				HeadTitle += "|Shipping marks for packaged goods (not necessary for containerised goods)";
				HeadTitle += "|Container identification marks";
				HeadTitle += "|Number of the item in relation to the total number of items";
				HeadTitle += "|C/M Description";
				HeadTitle += "|4 digit HS code (not necessary if a goods description is provided)";
				HeadTitle += "|Gross mass (kg)";
				HeadTitle += "|UN code for dangerous goods";
				HeadTitle += "|Seal number";
				HeadTitle += "|Code for the method of payment for transport charges (e.g. cash, credit card)";
				HeadTitle += "|Declaration date";
				HeadTitle += "|Signature/authentification";
				HeadTitle += "|Code for special circumstances (postal/express consignment, ship/aircraft supplies, road/rail transport, AOE) if applicable";
				var headCount=ComCountHeadTitle(HeadTitle);

				SetConfig( { SearchMode:2, Page:20, FrozenCol:0, DataRowMerge:1 } );

				var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"seq" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"bkg_no" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"trsp_doc_no" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"s_cust_nm" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"s_cust_addr" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"item5" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"c_cust_nm" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"c_cust_addr" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"item7" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"n_cust_nm" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"n_cust_addr" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"trans_mode" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"crn" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cstms_port_cd" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vps_eta_dt" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"route_country" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"item14" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"load_loc_cd" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"unload_loc_cd" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cstms_desc" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"pkg_type" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"pkg_count" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cm_ship_mark" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cntr_no" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"pck_qty" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cntr_mf_gds_desc" },
			             	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cmdt_hs_cd" },
					     	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"act_wgt" },
					     	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"imdg_un_no" },
					     	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"seal_nbr" },
					     	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"item27" },
					     	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"ddate" },
					     	{Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"item29" },
					    	 {Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"item30" } ];
					           
				InitColumns(cols);
				SetEditable(0);
            }
			break;
		case "sheet4":  //ENS Download2 - MRD항목 추가
		    with(sheetObj){
		      	var HeadTitle="";
		      	HeadTitle += "Number of\n items contained\n in the ENS"
	      		HeadTitle += "|Unique consignment\n reference number\n assigned to the goods";
		      	HeadTitle += "|Transport\n document\n number";
		      	HeadTitle += "|Consignor";
		      	HeadTitle += "|Shipper address";
		      	HeadTitle += "|Person lodging the ENS";
		      	HeadTitle += "|Consignee";
		      	HeadTitle += "|Cnee address";
		      	HeadTitle += "|Carrier";
		      	HeadTitle += "|Party to be notified\n at arrival of the goods";
		      	HeadTitle += "|Notify address";
		      	HeadTitle += "|Identity and nationality\n of active means\n of transport entering the EU";
		      	HeadTitle += "|Conveyance\n reference number";
		      	HeadTitle += "|Code for the first place\n of arrival in the EU";
		      	HeadTitle += "|Date and time of arrival\n at the first place in the EU";
		      	HeadTitle += "|Code(s) for the country(ies) of\n routing (including the countries of departure\n and destination) to the extent known";
		      	HeadTitle += "|Mode of transport\n at the border";
		      	HeadTitle += "|Code for the place\n of loading";
		      	HeadTitle += "|Code for the place\n of unloading";
		      	HeadTitle += "|Acceptable goods description\n (not necessary if the 4 digits HS code is provided)";
		      	HeadTitle += "|Code for\n the type\n of packages";
		      	HeadTitle += "|Number\n of packages";
		      	HeadTitle += "|Shipping marks for packaged goods\n (not necessary for containerised goods)";
		      	HeadTitle += "|Container\n identification marks";
		      	HeadTitle += "|Number of the item in\n relation\n to the total number of items";
		      	HeadTitle += "|C/M Description";
		      	HeadTitle += "|4 digit HS code (not necessary\n if a goods description is provided)";
		      	HeadTitle += "|Gross mass\n (kg)";
		      	HeadTitle += "|UN code for\n dangerous goods";
		      	HeadTitle += "|Seal number";
		      	HeadTitle += "|Code for the method\n of payment for transport charges\n (e.g. cash, credit card)";
		      	HeadTitle += "|Declaration date";
		      	HeadTitle += "|Signature\n/authentification";
		      	HeadTitle += "|Code for special circumstances (postal/express consignment,\n ship/aircraft supplies, road/rail transport, AOE) if applicable";
		      	HeadTitle += "|MRN";
		      	var headCount=ComCountHeadTitle(HeadTitle);

		      	SetConfig( { SearchMode:2, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      	var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		      	var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      	InitHeaders(headers, info);

		      	var cols = [ {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"seq" },
		      	             {Type:"Text",     Hidden:0,  Width:500,  Align:"Left",    ColMerge:1,   SaveName:"bkg_no" },
		      	             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"trsp_doc_no" },
		      	             {Type:"Text",     Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"s_cust_nm" },
		      	             {Type:"Text",     Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"s_cust_addr" },
		      	             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"item5" },
		      	             {Type:"Text",     Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"c_cust_nm" },
				             {Type:"Text",     Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"c_cust_addr" },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"item7" },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"n_cust_nm" },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"n_cust_addr" },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"trans_mode" },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"crn" },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cstms_port_cd" },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"vps_eta_dt" },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"route_country" },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"item14" },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"load_loc_cd" },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"unload_loc_cd" },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cstms_desc" },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"pkg_type" },
				             {Type:"Int",       Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"pkg_count",         KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cm_ship_mark" },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cntr_no" },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"pck_qty" },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cntr_mf_gds_desc" },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_hs_cd" },
				             {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"act_wgt",           KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"imdg_un_no" },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"seal_nbr" },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"item27" },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"ddate" },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"item29" },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"item30" },
				             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"mvmt_ref_no" } ];
				       
		      	InitColumns(cols);

		      	SetEditable(0);
            }
			break;
			
		case "sheet5":    // EDI Preview Sheet
			with (sheetObj) {
//			var HeadTitle  = "|Seq|Line|EDI Flatfile Contents";
			var HeadTitle  = "|Line|EDI Flatfile Contents";
    		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

    		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
    		var headers = [ { Text:HeadTitle, Align:"Center"} ];
    		InitHeaders(headers, info);
			var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
    		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq"},
//    		             {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"queue_nm"},
			             {Type:"Text",      Hidden:0, Width:395,   Align:"left",  ColMerge:1,   SaveName:"flat_file"}];


    		InitColumns(cols);
    		SetEditable(0);
    		
		}
		break;			

		case "sheet6":    // B/L Root
			with (sheetObj) {
				
				var HeadTitle = "|VVD|IB_CON_VVD|OB_CON_VVD|VSL_CALLSIGN|VSL_LLOYDCODE|VSL_FULLNAME|VSL_FLAG|PORT|PORTNAME|ETA|ETD"
				+ "|ATA|ATD|NEXTPORT|NEXTPORT_ETA|PREVPORT|PREVPORT_ETD|IO_IND|COMP_ID|MRN|BLNBR"
				+ "|BLPOL|POL_AMS|POL_FULLNAME|BLPOD|POD_AMS|POD_FULLNAME|BLPOR|POR_AMS|POR_FULLNAME|POR_YARD"
				+ "|BLDEL|DEL_AMS|DEL_FULLNAME|DEL_YARD|SVC_SCP|BL_CMPL_STS|BL_CMPL_TP|BLRLY|RLY_AMS|RLY_FULLNAME|BLPLACE|BLDATE|BLCOPY"
				+ "|BLORG|BLPKG|BLPKGU|BLWGT|BL_WGT_UNIT|BLMEA|BL_MEA_UNIT|RDTYPE|CARGOTYPE|COMMODITY"
				+ "|BLCMD|BLREPCMDCD|BLREPCMD|REMARK|AUS_QUAR|SRNBR|BKGNBR|RGN_BKGNBR|CVRD_BY|SCNO|RFANO|TW_SO_NO"
				+ "|WAYBILL_IND|CUSTREF_NUM|FINAL_ETA|FUNC_CODE|ONBOARD|INV_NO|BLTS|BLTP|MSN|MSNCFM"
				+ "|IND_AGREE|VALUE_AGREE|EU_MRN_SEQ|EU_MRN_VALUE|EU_PORT|EU_MRN_DATE|EU_MRN_SOURCE"
				+ "|HANTYPE|COUNT|ELNO|ELPK|ELPKU|ELWT|ELWTU|FND_DEST";

				
	    		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	    		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	    		var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    		InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"IB_CON_VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"OB_CON_VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"VSL_CALLSIGN" },
				             {Type:"Text",      Hidden:0, Width:110,   Align:"Center",  ColMerge:1,   SaveName:"VSL_LLOYDCODE" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"VSL_FULLNAME" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"VSL_FLAG" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PORT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PORTNAME" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ETA" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ETD" },
				             
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ATA" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ATD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"NEXTPORT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"NEXTPORT_ETA" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PREVPORT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PREVPORT_ETD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"IO_IND" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"COMP_ID" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"MRN" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLNBR" },
				             
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLPOL" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"POL_AMS" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"POL_FULLNAME" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLPOD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"POD_AMS" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"POD_FULLNAME" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLPOR" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"POR_AMS" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"POR_FULLNAME" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"POR_YARD" },
				             
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLDEL" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"DEL_AMS" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"DEL_FULLNAME" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"DEL_YARD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"SVC_SCP" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BL_CMPL_STS" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BL_CMPL_TP" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLRLY" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"RLY_AMS" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"RLY_FULLNAME" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLPLACE" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLDATE" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLCOPY" },
				             
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLORG" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLPKG" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLPKGU" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLWGT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BL_WGT_UNIT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLMEA" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BL_MEA_UNIT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"RDTYPE" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CARGOTYPE" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"COMMODITY" },
				             
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLCMD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLREPCMDCD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLREPCMD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"REMARK" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"AUS_QUAR" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"SRNBR" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BKGNBR" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"RGN_BKGNBR" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CVRD_BY" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"SCNO" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"RFANO" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"TW_SO_NO" },
				             
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"WAYBILL_IND" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CUSTREF_NUM" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"FINAL_ETA" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"FUNC_CODE" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ONBOARD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"INV_NO" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLTS" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLTP" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"MSN" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"MSNCFM" },
				             
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"IND_AGREE" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"VALUE_AGREE" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"EU_MRN_SEQ" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"EU_MRN_VALUE" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"EU_PORT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"EU_MRN_DATE" },
				             {Type:"Text",      Hidden:0, Width:110,   Align:"Center",  ColMerge:1,   SaveName:"EU_MRN_SOURCE" },
				             
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"HANTYPE" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"COUNT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ELNO" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ELPK" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ELPKU" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ELWT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ELWTU" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"FND_DEST" }
	    		           ];
	
	    		InitColumns(cols);
	    		SetEditable(0);
	    		
			}
			break;	

		case "sheet7":    // B/L Container
			with (sheetObj) {
				var HeadTitle = "|VVD|IB_CON_VVD|OB_CON_VVD|PORT|BLNBR|CNTRNBR|PUNIT"
					+ "|PKG|CNTRWGT|CNTRGWGT|CNTR_WGT_UNIT|CNTRTRW|CNTRTYPE|SEALNBR"
					+ "|FM_IND|RF_IND|DG_IND|AK_IND|BK_IND|PL_IND|TEMP|TUNIT"
					+ "|VENT|MEASURE|MEASURE_UNIT|RDTYPE|CMDT_DESC|CMDTCD|RF_REMARK|RFDRY_IND"
					+ "|OVF|OVR|OVH|OVLW|OVRW|OVWGT|OVWGT_UNIT|VOID_SLOT|STWG_REQ|SOCIND"
					+ "|HAULAGE|BKWGT|BKWGTU|BKW|BKH|BKL|CNTROWN|CNTRTRM|NOD_DEMURRAGE_FREETIME"
					+ "|SEALSEQ|SEALNBR|SEAL_PRINT_FLAG";
					
	    		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	    		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	    		var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    		InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:1, Width:0,     Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"VVD"},
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"IB_CON_VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"OB_CON_VVD" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PORT"},
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLNBR"},
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CNTRNBR"},
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PUNIT"},
	    		             
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PKG" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CNTRWGT" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CNTRGWGT" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CNTR_WGT_UNIT" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CNTRTRW" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CNTRTYPE" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"SEALNBR" },
	    		             
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"FM_IND" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"RF_IND" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"DG_IND" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"AK_IND" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BK_IND" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PL_IND" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"TEMP" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"TUNIT" },
	    		             
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"VENT" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"MEASURE" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"MEASURE_UNIT" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"RDTYPE" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CMDT_DESC" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CMDTCD" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"RF_REMARK" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"RFDRY_IND" },
	    		             
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"OVF" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"OVR" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"OVH" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"OVLW" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"OVRW" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"OVWGT" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"OVWGT_UNIT" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"VOID_SLOT" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"STWG_REQ" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"SOCIND" },
	    		             
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"HAULAGE" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BKWGT" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BKWGTU" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BKW" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BKH" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BKL" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CNTROWN" },
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CNTRTRM" },
	    		             {Type:"Text",      Hidden:0, Width:200,   Align:"Center",  ColMerge:1,   SaveName:"NOD_DEMURRAGE_FREETIME" },
	    		             
	    		             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"SEALSEQ"},
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"SEALNBR_CNTR"},
				             {Type:"Text",      Hidden:0, Width:110,   Align:"Center",  ColMerge:1,   SaveName:"PRN_FLG"}
	    		           ];
	    		InitColumns(cols);
	    		SetEditable(0);
	    		
			}
			break;	
			
		case "sheet8":    // B/L Freight
			with (sheetObj) {
				var HeadTitle  = "|VVD|IB_CON_VVD|OB_CON_VVD|PORT|BLNBR|PPDOFC|PPD_PAYER|CCTOFC|CCT_PAYER|THDOFC|SCNO|RFANO"
				    + "|FCTYPE|RATE|REVENUETON|PPD|CCT|CURRENCYCODE|EXCHRATE|TARIFF|PERTYPE|RATEOFC|PPD_TOTAL|CCT_TOTAL|TOTAL_CUR|PPD_USD|CCT_USD|3RD_PAYER"; 

	    		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	    		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	    		var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    		InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"IB_CON_VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"OB_CON_VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PORT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLNBR" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PPDOFC" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PPD_PAYER" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CCTOFC" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CCT_PAYER" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"THDOFC" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"SCNO" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"RFANO" },
				             
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"FCTYPE" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"RATE" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"REVENUETON" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PPD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CCT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CURRENCYCODE" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"EXCHRATE" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"TARIFF" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PERTYPE" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"RATEOFC" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PPD_TOTAL" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CCT_TOTAL" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"TOTAL_CUR" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PPD_USD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CCT_USD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"3RD_PAYER" }
	    		           ];
	    		InitColumns(cols);
	    		SetEditable(0);
	    		
			}
			break;
			
		case "sheet9":    // B/L Remarks
			with (sheetObj) {
				var HeadTitle  = "|VVD|IB_CON_VVD|OB_CON_VVD|BLNBR|BLPOL|BLPOD|BLPOR|BLDEL|MARKNO|DESC1|DESC2";
				
	    		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	    		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	    		var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    		InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"IB_CON_VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"OB_CON_VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLNBR" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLPOL" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLPOD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLPOR" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLDEL" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"MARKNO"},
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"DESC1" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"DESC2" }
	    		           ];
	    		InitColumns(cols);
	    		SetEditable(0);
	    		
			}
			break;	
			
		case "sheet10":    // Cargo
			with (sheetObj) {
				var HeadTitle  = "|VVD|IB_CON_VVD|OB_CON_VVD|PORT|BLNBR|SCNO|RFANO|CNTRNBR"
				+ "|UNNBR|CLASS|DG_DESC|CONTACT_NM|PHONE|PAGE|FLSH_TEMP|FLSH_UNIT|DG_REMARK|EMSNO"
				+ "|PSACLS|PKGGRP|MFAG1|MFAG2|MAR_POLL|LABEL_CD|LABEL_DESC|D_PKG|D_PKGUNIT"
				+ "|NWGT|NWGT_UNIT|GWGT|GWGT_UNIT|MEA|MEA_UNIT|HAZ_CONT|STWG|LABEL";
				
	    		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	    		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	    		var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    		InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"IB_CON_VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"OB_CON_VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PORT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLNBR" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"SCNO" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"RFANO" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CNTRNBR" },
				             
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"UNNBR" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CLASS" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"DG_DESC" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CONTACT_NM" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PHONE" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PAGE" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"FLSH_TEMP" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"FLSH_UNIT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"DG_REMARK" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"EMSNO" },
				             
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PSACLS" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PKGGRP" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"MFAG1" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"MFAG2" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"MAR_POLL" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"LABEL_CD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"LABEL_DESC" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"D_PKG" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"D_PKGUNIT" },
				             
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"NWGT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"NWGT_UNIT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"GWGT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"GWGT_UNIT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"MEA" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"MEA_UNIT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"HAZ_CONT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"STWG" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"LABEL" }
	    		           ];
	    		InitColumns(cols);
	    		SetEditable(0);
	    		
			}
			break;				

		case "sheet11":    // Cargo Packaging
			with (sheetObj) {
				var HeadTitle  = "|VVD|IB_CON_VVD|OB_CON_VVD|PORT|BLNBR|BLPOL|BLPOD|BLPOR|BLDEL|CNTRNBR"
				 +"|D_CMDT|D_PUNIT|D_PKG|D_WGT|D_MEAS|D_DESC|D_CTMS_REF|D_HTS_CD|D_HS_CD|D_NCM_CD";
				
	    		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	    		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	    		var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    		InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"IB_CON_VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"OB_CON_VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PORT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLNBR" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLPOL" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLPOD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLPOR" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLDEL" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CNTRNBR" },
				             
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"D_CMDT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"D_PUNIT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"D_PKG" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"D_WGT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"D_MEAS" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"D_DESC" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"D_CTMS_REF" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"D_HTS_CD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"D_HS_CD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"D_NCM_CD" }
	    		           ];
	    		InitColumns(cols);
	    		SetEditable(0);
	    		
			}
			break;	

		case "sheet12":    // Cargo Marks & Numbers
			with (sheetObj) {
				var HeadTitle  = "|VVD|IB_CON_VVD|OB_CON_VVD|BLNBR|BLPOL|BLPOD|BLPOR|BLDEL"
				 + "|CMDESC|LOCAL_IPI|EQREL|EQPICKDT|EQRTN|CNTRNBR|D_MARK";

	    		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	    		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	    		var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    		InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"IB_CON_VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"OB_CON_VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLNBR" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLPOL" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLPOD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLPOR" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLDEL" },
				             
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CMDESC" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"LOCAL_IPI" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"EQREL" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"EQPICKDT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"EQRTN" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CNTRNBR" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"D_MARK" }
	    		           ];
	    		InitColumns(cols);
	    		SetEditable(0);
	    		
			}
			break;	

		case "sheet13":    // B/L  Notify Party
			with (sheetObj) {
				var HeadTitle  = "|VVD|IB_CON_VVD|OB_CON_VVD|PORT|BLNBR|BLPOL|BLPOD|BLPOR|BLDEL"
					+ "|SHPRCN|SHPRCD|SHPR1|SHPR2|SHPR3|SHPR4|SHPR5|SHPRTXID"
					+ "|CNEECN|CNEECD|CNEE1|CNEE2|CNEE3|CNEE4|CNEE5|CNEETXID"
					+ "|NTFYCN|NTFYCD|NTFY1|NTFY2|NTFY3|NTFY4|NTFY5|NTFYTXID"
					+ "|NTFY2CN|NTFY2CD|NTFY21|NTFY22|NTFY23|NTFY24|NTFY25|NTFY2TXID"
					+ "|FFWDCN|FFWDCD|FFWD1|FFWD2|FFWD3|FFWD4|FFWD5|FFWDTXID"
					+ "|EXPOCN|EXPOCD|EXPO1|EXPO2|EXPO3|EXPO4|EXPO5|EXPOTXID";
				
	    		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	    		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	    		var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    		InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"IB_CON_VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"OB_CON_VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PORT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLNBR" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLPOL" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLPOD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLPOR" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLDEL" },

				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"SHPRCN" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"SHPRCD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"SHPR1" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"SHPR2" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"SHPR3" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"SHPR4" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"SHPR5" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"SHPRTXID" },
				             
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CNEECN" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CNEECD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CNEE1" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CNEE2" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CNEE3" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CNEE4" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CNEE5" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"CNEETXID" },
				             
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"NTFYCN" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"NTFYCD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"NTFY1" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"NTFY2" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"NTFY3" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"NTFY4" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"NTFY5" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"NTFYTXID" },
				             
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"NTFY2CN" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"NTFY2CD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"NTFY21" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"NTFY22" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"NTFY23" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"NTFY24" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"NTFY25" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"NTFY2TXID" },
				             
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"FFWDCN" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"FFWDCD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"FFWD1" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"FFWD2" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"FFWD3" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"FFWD4" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"FFWD5" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"FFWDTXID" },
				             
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"EXPOCN" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"EXPOCD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"EXPO1" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"EXPO2" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"EXPO3" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"EXPO4" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"EXPO5" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"EXPOTXID" }
	    		           ];
	    		InitColumns(cols);
	    		SetEditable(0);
	    		
			}
			break;	

		case "sheet14":    // B/L  Route
			with (sheetObj) {
				var HeadTitle  = "|VVD|IB_CON_VVD|OB_CON_VVD|PORT|PORTNAME|ETA|ETD|ATA|ATD|NEXTPORT|NEXTPORT_ETA|PREVPORT|PREVPORT_ETD" 
						 + "|BLNBR|BLPOL|BLPOD|BLPOR|BLDEL"
						 + "|VVDTYPE|LANE_CD|BVVD1|VSL_CALLSIGN1|VSL_LLOYDCODE1|VSL_FULLNAME1|VSL_FLAG1"
						 + "|BLPOL1|POL_YD|POL_FULLNAME1|BLPOD1|POD_YD|POD_FULLNAME1|POLETA1|POLETD1|PODETA1|PODETD1|OP_CODE"

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	    		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	    		var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    		InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"IB_CON_VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"OB_CON_VVD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PORT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PORTNAME" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ETA" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ETD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ATA" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ATD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"NEXTPORT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"NEXTPORT_ETA" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PREVPORT" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PREVPORT_ETD" },
				             
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLNBR" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLPOL" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLPOD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLPOR" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLDEL" },
				             
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"VVDTYPE" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"LANE_CD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BVVD1" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"VSL_CALLSIGN1" },
				             {Type:"Text",      Hidden:0, Width:110,   Align:"Center",  ColMerge:1,   SaveName:"VSL_LLOYDCODE1" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"VSL_FULLNAME1" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"VSL_FLAG1" },
				             
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLPOL1" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"POL_YD" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"POL_FULLNAME1" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"BLPOD1" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"POD_YD" },
				             {Type:"Text",      Hidden:0, Width:110,   Align:"Center",  ColMerge:1,   SaveName:"POD_FULLNAME1" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"POLETA1" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"POLETD1" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PODETA1" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"PODETD1" },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"OP_CODE" }
	    		           ];
	    		InitColumns(cols);
	    		SetEditable(0);
	    		
			}
			break;
        }
    }

    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:
				ComSetFocus(formObj.f_cmd);
				if(!validateForm(sheetObj,formObj,sAction))return;
				var ts_search_flag="";
				if(formObj.check_ts_search.checked) {
					formObj.ts_search_flag.value="T";
				} else {
					formObj.ts_search_flag.value="";
				}
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
 				var sXml=sheetObj.GetSearchData("ESM_BKG_0484GS.do", FormQueryString(formObj));
 				if (sXml == "" || sXml == null)
 					sXml = noDataXml;
				if (ComBkgErrMessage(sheetObj, sXml)) {
					sheetObj.LoadSearchData(sXml,{Sync:1} );
				}
				ComOpenWait(false);
				break;
			case IBSAVE:
	            if(!validateForm(sheetObj,formObj,sAction)) return false;
	            formObj.f_cmd.value=SEARCH04;
 				var sXml=sheetObj.GetSearchData("ESM_BKG_0484GS.do", FormQueryString(formObj));
				var existVvdPortYn=ComGetEtcData(sXml, "existVvdPortYn");
				if(existVvdPortYn == "N") {
					ComShowCodeMessage("BKG00651", "VVD + (POL or POD)");
					ComSetFocus(formObj.vvd_cd);
					return false;
				}
				if (formObj.edi_preview.value != "Y" && !ComShowConfirm(ComGetMsg("BKG95003", "Transmit"))) return false;
				setBndCd();
				var rowCnt=sheetObj.RowCount();
				for(var i=1; i<=rowCnt; i++) {
					if(sheetObj.GetCellValue(i, "check") == 1) {
						sheetObj.SetCellValue(i, "edi_preview",formObj.edi_preview.value,0);
						sheetObj.SetRowStatus(i,"I");
					} else {
						sheetObj.SetRowStatus(i,"");
					}
				}
				var sParam="";
				var sParamSheet=sheetObj.GetSaveString();
				if (sParamSheet != "") {
					sParam += "&" + sParamSheet;
				}
				formObj.f_cmd.value=MULTI;
				sParam += "&" + FormQueryString(formObj);
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true,true);
 				var sXml=sheetObj.GetSaveData("ESM_BKG_0484GS.do", sParam)
				var key=ComGetEtcData(sXml, "KEY");
				intervalId=setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
				break;
			case IBDOWNEXCEL:
				if (!validateForm(sheetObj,formObj,sAction)) return;
				ComOpenWait(true);
				if(sheetObj.RowCount() < 1){
					ComShowCodeMessage("COM132501");
				}else{
					sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
				}
				ComOpenWait(false);
				break;
			case SEARCH01 :
				sheetObj.RenderSheet(0);
				sheetObj.SetWaitImageVisible(1);
				ComSetObjValue(formObj.f_cmd, SEARCH01);
				ComSetObjValue(formObj.p_vvd_cd, ComGetObjValue(formObj.vvd_cd));
				var sParam="";  
				sParam += "p_type=ENS" +"&";
				sParam += "&" + FormQueryString(formObj);
 				var sXml=sheetObj.GetSearchData("ESM_BKG_1106GS.do", sParam);
				ComXml2ComboItem(sXml,p_pod_cd_temp, "search_eu_1st_port_yd_cd", "eu_1st_port_name");
				ComSetObjValue(formObj.p_pod_cd, "");
				ComSetObjValue(formObj.p_pod_yard_cd, "");
				sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
				sheetObj.RenderSheet(1);
				sheetObj.SetWaitImageVisible(0);
				break;
			case "DownENS":
				if (!validateForm(sheetObj,formObj,sAction)) return;
				ComOpenWait(true);
	            ComSetObjValue(formObj.f_cmd, SEARCH05);
				var inp;
				var len=formObj.elements.length;
				for (var i=0; i<len; i++) {
					if (formObj.elements[i] && formObj.elements[i].name) {
						if ("bkg_nos"==formObj.elements[i].name) {
							$("[name='"+formObj.elements[i--].name+"']").remove();
//							formObj.elements[i--].removeNode(true);
						}
					}
				}
				for (var i=1; i<=sheetObj.RowCount(); i++) {
					if(sheetObj.GetCellValue(i, "check") == 1) {
						inp=document.createElement("input");
						inp.type="hidden";
						inp.name="bkg_nos";
						inp.value=sheetObj.GetCellValue(i, "bkg_no");
						formObj.appendChild(inp);
					}
				}
 				var sXml=sheetObj.GetSearchData("ESM_BKG_0484GS.do", FormQueryString(formObj));
				sheetObjects[3].LoadSearchData(sXml,{Sync:1} );
				ComOpenWait(false);
				break;
			case "DownLDF":
				if(!validateForm(sheetObj,formObj,sAction)) return false;
	            formObj.f_cmd.value=SEARCH04;
 				var sXml=sheetObj.GetSearchData("ESM_BKG_0484GS.do", FormQueryString(formObj));
				var existVvdPortYn=ComGetEtcData(sXml, "existVvdPortYn");
				if(existVvdPortYn == "N") {
					ComShowCodeMessage("BKG00651", "VVD + (POL or POD)");
					ComSetFocus(formObj.vvd_cd);
					return false;
				}
				setBndCd();
				var rowCnt=sheetObj.RowCount();
				for(var i=1; i<=rowCnt; i++) {
					if(sheetObj.GetCellValue(i, "check") == 1) {
						sheetObj.SetCellValue(i, "edi_preview",formObj.edi_preview.value,0);
						sheetObj.SetRowStatus(i,"I");
					} else {
						sheetObj.SetRowStatus(i,"");
					}
				}
				var sParam="";
				var sParamSheet=sheetObj.GetSaveString();
				if (sParamSheet != "") {
					sParam += "&" + sParamSheet;
				}
				formObj.f_cmd.value=SEARCH06;
				sParam += "&" + FormQueryString(formObj);
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true,true);
 				var sXml=sheetObj.GetSaveData("ESM_BKG_0484GS.do", sParam)
				var key=ComGetEtcData(sXml, "KEY");
				intervalId=setInterval("doActionValidationResult2(sheetObjects[0], '" + key + "');", 3000);
				break;		
        }
    }

    function doActionValidationResult(sheetObj, sKey) {
     	var sXml=sheetObj.GetSearchData("ESM_BKG_0484GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
    	var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
    	if (!ComBkgErrMessage(sheetObj, sXml)) {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		return;
    	}
    	if (sJbStsFlg == "SUCCESS") {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		
			if (document.form.edi_preview.value == "Y") {
				sheetObjects[4].LoadSearchData(sXml);
			} else {
				// showing success message
				ComShowCodeMessage('BKG00101');
			}
			
    		return;
    	} else if (sJbStsFlg == "FAIL") {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		ComShowMessage(ComResultMessage(sXml));
    	}
    }

    function doActionValidationResult2(sheetObj, sKey) {
     	var sXml=sheetObj.GetSearchData("ESM_BKG_0484GS.do?f_cmd=" + SEARCH07 + "&key=" + sKey);
     	var result=ComGetEtcData(sXml, "result");
     	resultJson = JSON.parse(result)
     	
     	vvdExcelName = $("#vvd_cd").val();

    	var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");

    	if (!ComBkgErrMessage(sheetObj, sXml)) {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		return;
    	}
    	if (sJbStsFlg == "SUCCESS") {
    		clearInterval(intervalId);
    		ComOpenWait(false);

    		sheetObjects[5].LoadSearchData(resultJson.listBlRoot,{Sync:1} );
    		// 파일 하나에 여러 워크시트 처리
//    		sheetObjects[5].LoadSearchData(resultJson.listBlRoot,{Sync:1} );
//    		sheetObjects[6].LoadSearchData(resultJson.listBlCntr,{Sync:1} );
//    		sheetObjects[7].LoadSearchData(resultJson.listBlFrt,{Sync:1} );
//    		sheetObjects[8].LoadSearchData(resultJson.listBlRmk,{Sync:1} );
//    		sheetObjects[9].LoadSearchData(resultJson.listCgo,{Sync:1} );
//    		sheetObjects[10].LoadSearchData(resultJson.listCgoPck,{Sync:1} );
//    		sheetObjects[11].LoadSearchData(resultJson.listCgoMkNo,{Sync:1} );
//    		sheetObjects[12].LoadSearchData(resultJson.listBlNtfy,{Sync:1} );
//    		sheetObjects[13].LoadSearchData(resultJson.listBlRout,{Sync:1} );
//    		
//    		sheetObjects[5].Down2ExcelBuffer(true)
//    		sheetObjects[5].Down2Excel({ FileName : vvdExcelName, DownCols: makeHiddenSkipCol(sheetObjects[5]), SheetDesign:1, Merge:1, SheetName:'B/L Root'});
//    		sheetObjects[6].Down2Excel({ FileName : vvdExcelName, DownCols: makeHiddenSkipCol(sheetObjects[6]), SheetDesign:1, Merge:1, SheetName:'B/L Container'});
//    		sheetObjects[7].Down2Excel({ FileName : vvdExcelName, DownCols: makeHiddenSkipCol(sheetObjects[7]), SheetDesign:1, Merge:1, SheetName:'B/L Freight'});
//    		sheetObjects[8].Down2Excel({ FileName : vvdExcelName, DownCols: makeHiddenSkipCol(sheetObjects[8]), SheetDesign:1, Merge:1, SheetName:'B/L Remarks'});
//    		sheetObjects[9].Down2Excel({ FileName : vvdExcelName, DownCols: makeHiddenSkipCol(sheetObjects[9]), SheetDesign:1, Merge:1, SheetName:'Cargo'});
//    		sheetObjects[10].Down2Excel({ FileName : vvdExcelName, DownCols: makeHiddenSkipCol(sheetObjects[10]), SheetDesign:1, Merge:1, SheetName:'Cargo Packaging'});
//    		sheetObjects[11].Down2Excel({ FileName : vvdExcelName, DownCols: makeHiddenSkipCol(sheetObjects[11]), SheetDesign:1, Merge:1, SheetName:'Cargo Marks & Numbers'});
//    		sheetObjects[12].Down2Excel({ FileName : vvdExcelName, DownCols: makeHiddenSkipCol(sheetObjects[12]), SheetDesign:1, Merge:1, SheetName:'B/L Notify Party'});
//    		sheetObjects[13].Down2Excel({ FileName : vvdExcelName, DownCols: makeHiddenSkipCol(sheetObjects[13]), SheetDesign:1, Merge:1, SheetName:'B/L Route'});
//    		sheetObjects[5].Down2ExcelBuffer(false)
    		// 파일 하나에 여러 워크시트 처리

    		//return;
    	} else if (sJbStsFlg == "FAIL") {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		ComShowMessage(ComResultMessage(sXml));
    	}
    }
    
    function validateForm(sheetObj,formObj,sAction){
    	var sheet1RowCnt=sheetObj.RowCount();
    	 switch(sAction) {
			case IBSEARCH:
				if (!ComChkValid(formObj)) return false;
				var vvdCd=formObj.vvd_cd.value;
				var polVal=formObj.pol_cd.value;
				var podVal=formObj.pod_cd.value;
				var blNo=formObj.bl_no.value;
				var bkgNo=formObj.bkg_no.value;
//				if(bkgNo == "" && blNo == "") {
					if(vvdCd == "") {
						ComShowCodeMessage("BKG00251");
						ComSetFocus(formObj.vvd_cd);
						return false;
					}
					if(polVal == "" && podVal == "") {
						ComShowCodeMessage("BKG00378");
						ComSetFocus(formObj.pol_cd);
						return false;
					}
//				}
				var ofcCd=formObj.ofcCd.value;
				if(ofcCd.substring(0,3) == "ANR") {
					if(polVal != "BEANR" && podVal != "BEANR") {
						ComShowCodeMessage("BKG06066");
						ComSetFocus(formObj.pol_cd);
						return false;
					}
				}
				break;
			case IBSAVE:
				if(sheet1RowCnt == 0) {
	        		ComShowCodeMessage('BKG01096');
	        		return false;
				}
				var checkCnt=0;
				var manyActVvdFlag=false;
				for(var i=1; i <= sheet1RowCnt; i++) {
					if(sheetObj.GetCellValue(i, "check") == 1) {
		        		checkCnt++;
		        		if(formObj.vvd_cd.value != "" && (formObj.pol_cd.value != "" || formObj.pod_cd.value != "")) {
		        			continue;
		        		} else {
		        			if(sheetObj.GetCellValue(i, "act_vvd_cnt") > 1) {
		        				manyActVvdFlag=true;
		        				break;
		        			}
		        		}
		        	}
		        }
				if(checkCnt == 0) {
		        	ComShowCodeMessage('BKG01097');
		        	return false;
		        } else {
		        	if(manyActVvdFlag) {
		        		var msg1="";
		        		if(formObj.bl_no.value != "") {
		        			msg1="B/L No";
		        		} else if(formObj.bkg_no.value != "") {
		        			msg1="BKG No";
		        		}
		        		ComShowCodeMessage("BKG06115", msg1);
		        		return false
		        	}
		        }
				if (!ComChkValid(formObj)) return false;
				break;
			case IBDOWNEXCEL:
				if(sheet1RowCnt == 0) {
					ComShowCodeMessage("BKG00389");
					return false;
				}
				break;
			case "DownENS":
				if (!ComChkValid(formObj)) return false;
				if(sheet1RowCnt == 0) {
	        		ComShowCodeMessage('BKG00095');
	        		return false;
				}
				var arr=[formObj.vvd_cd,
				           formObj.pol_cd,
				           formObj.pod_cd,
				           formObj.bl_no,
				           formObj.bkg_no];
				if (ComIsEmpty(arr[3]) && ComIsEmpty(arr[4])) {
					if (ComIsEmpty(arr[0])) {
						ComShowCodeMessage("BKG00251");
						ComSetFocus(arr[0]);
						return false;
					}
					if(ComIsEmpty(arr[1]) && ComIsEmpty(arr[2])) {
						ComShowCodeMessage("BKG00378");
						ComSetFocus(arr[1]);
						return false;
					}
				}
				var checkCnt=0;
				for(var i=1; i <= sheet1RowCnt; i++) {
					if(sheetObj.GetCellValue(i, "check") == 1) {
		        		checkCnt++;
		        	}
		        }
				if(checkCnt == 0) {
		        	ComShowCodeMessage('BKG01097');
		        	return false;
		        }
				break;
			case "DownLDF":
				if(sheet1RowCnt == 0) {
	        		ComShowCodeMessage('BKG01096');
	        		return false;
				}
				var checkCnt=0;
				var manyActVvdFlag=false;
				for(var i=1; i <= sheet1RowCnt; i++) {
					if(sheetObj.GetCellValue(i, "check") == 1) {
		        		checkCnt++;
		        		if(formObj.vvd_cd.value != "" && (formObj.pol_cd.value != "" || formObj.pod_cd.value != "")) {
		        			continue;
		        		} else {
		        			if(sheetObj.GetCellValue(i, "act_vvd_cnt") > 1) {
		        				manyActVvdFlag=true;
		        				break;
		        			}
		        		}
		        	}
		        }
				if(checkCnt == 0) {
		        	ComShowCodeMessage('BKG01097');
		        	return false;
		        } else {
		        	if(manyActVvdFlag) {
		        		var msg1="";
		        		if(formObj.bl_no.value != "") {
		        			msg1="B/L No";
		        		} else if(formObj.bkg_no.value != "") {
		        			msg1="BKG No";
		        		}
		        		ComShowCodeMessage("BKG06115", msg1);
		        		return false
		        	}
		        }
				if (!ComChkValid(formObj)) return false;
				break;				
    	}
    	return true;
	}

    function setBndCd() {
    	var formObj=document.form;
    	var polCd=formObj.pol_cd.value;
    	if(polCd != "") {
    		if(polCd.substr(1,2) == "KR") {
    			formObj.bnd_cd.value="O";
    		} else {
    			formObj.bnd_cd.value="I";
    		}
    	} else {
    		formObj.bnd_cd.value="I";
    	}
    }

    function bkg_change() {
	    switch (ComGetEvent("name")) {
	    	case "vvd_cd":
	    		var formObj=document.form;
	    		sheetObjects[1].RemoveAll();
	    		p_pod_cd_temp.RemoveAll();
	    		ComSetObjValue(formObj.p_pod_yard_cd,"");
	    		ComSetObjValue(formObj.p_search_pofe_yard_cd,"");
	    		doActionIBSheet(sheetObjects[0],formObj,SEARCH01);
	    		if (0<p_pod_cd_temp.GetItemCount()) {
	    			p_pod_cd_temp.SetSelectIndex(0);
	    		}
	    		ComSetFocus(formObj.pol_cd);
				break;
	    }
    }

 	function p_pod_cd_temp_OnChange(comboObj, value, text) {
 		var formObj=document.form;
 		ComSetObjValue(formObj.p_pod_yard_cd, sheetObjects[1].GetCellValue(sheetObjects[1].FindText('eu_1st_port_name',text),"eu_1st_port_yd_cd"));
 		ComSetObjValue(formObj.p_search_pofe_yard_cd, sheetObjects[1].GetCellValue(sheetObjects[1].FindText('eu_1st_port_name',text),"search_eu_1st_port_yd_cd"));
 		if ("" != sheetObjects[1].GetCellValue(sheetObjects[1].FindText('eu_1st_port_name',text),"edi_mrn")) {
 			ComSetObjValue(formObj.p_ori_amd_cd, "A");
 		} else {
 			ComSetObjValue(formObj.p_ori_amd_cd, "O");
 		}
 	}

	function sheet4_OnSearchEnd(sheetObj, errMsg) {
		var frmObj=document.form;
		var excelCol = makeHiddenSkipCol(sheetObj);
		with (sheetObj) {
			if (0==RowCount()) {
				ComShowCodeMessage("BKG00389");
			} else {
				ComOpenWait(true);
                var exceptLines="";
                var colSkips="";
				if(!frmObj.mrn.checked) {
					colSkips="mvmt_ref_no";
					
					excelCol=ComReplaceStr(excelCol,"|"+sheetObj.SaveNameCol(colSkips),"");
				}
//                var xmlUrl="http://"+location.hostname +":"+ location.port + "/opuscntr/apps/opus/esm/bkg/customsdeclaration/customstransmission/script/ESM_BKG_0484.xml";        
//                RenderSheet(0);
//                Down2Excel( {DownCols: excelCol, SheetDesign:1,Merge:1 });
//                RenderSheet(1);
                Down2Excel( {DownCols: excelCol, SheetDesign:1,Merge:1, AutoSizeColumn:1,ExcelRowHeight:"auto", KeyFieldMark:0 });				
				ComOpenWait(false);
			}
		}
	}	
	
	/**
	 * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param {sheetObj} String : 해당 IBSheet Object
	 * @param {ErrMsg} String : 조회 후 메시지
	 */
	function sheet5_OnSearchEnd(sheetObj, Code, Msg) {
		ComOpenWait(true);
//		sheetObj.Down2Excel(-1);
		sheetObj.Down2Excel({FileName : "Excel.xlsx", DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1});
		ComOpenWait(false);
	}
	
	function sheet6_OnSearchEnd(sheetObj, Code, Msg) {
		//ComOpenWait(true);

		var formObj=document.form;
		var polVal=formObj.pol_cd.value;
		var podVal=formObj.pod_cd.value;
		
		if(polVal != "" && podVal != ""){
			sheetObj.SetColHidden("IB_CON_VVD",0);
			sheetObj.SetColHidden("OB_CON_VVD",0);
		}else if(polVal == "" && podVal != ""){
			sheetObj.SetColHidden("OB_CON_VVD",1);
			sheetObj.SetColHidden("IB_CON_VVD",0);			
		}else if(polVal != "" && podVal == ""){
			sheetObj.SetColHidden("OB_CON_VVD",0);			
			sheetObj.SetColHidden("IB_CON_VVD",1); 
		}
		sheetObj.SetDown2ExcelUrl("/opuscntr/js/ibsheet/jsp/Down2Excel.jsp");
		sheetObj.Down2Excel({FileName : vvdExcelName + '_ROOT.xls', DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1});
		//ComOpenWait(false);
	}

	function sheet6_OnDownFinish(downloadType, result) {
		sheetObjects[6].LoadSearchData(resultJson.listBlCntr,{Sync:1} );
	}
	
	function sheet7_OnSearchEnd(sheetObj, Code, Msg) {
		//ComOpenWait(true);
		var formObj=document.form;
		var polVal=formObj.pol_cd.value;
		var podVal=formObj.pod_cd.value;
		
		if(polVal != "" && podVal != ""){
			sheetObj.SetColHidden("IB_CON_VVD",0);
			sheetObj.SetColHidden("OB_CON_VVD",0);
		}else if(polVal == "" && podVal != ""){
			sheetObj.SetColHidden("OB_CON_VVD",1);
			sheetObj.SetColHidden("IB_CON_VVD",0);			
		}else if(polVal != "" && podVal == ""){
			sheetObj.SetColHidden("OB_CON_VVD",0);			
			sheetObj.SetColHidden("IB_CON_VVD",1);
		}
		sheetObj.SetDown2ExcelUrl("/opuscntr/js/ibsheet/jsp/Down2Excel2.jsp");
		sheetObj.Down2Excel({FileName : vvdExcelName + '_CNTR.xls', DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1});
		//ComOpenWait(false);
	}

	function sheet7_OnDownFinish(downloadType, result) {
		sheetObjects[7].LoadSearchData(resultJson.listBlFrt,{Sync:1} );
	}
	
	function sheet8_OnSearchEnd(sheetObj, Code, Msg) {
		//ComOpenWait(true);
		var formObj=document.form;
		var polVal=formObj.pol_cd.value;
		var podVal=formObj.pod_cd.value;
		
		if(polVal != "" && podVal != ""){
			sheetObj.SetColHidden("IB_CON_VVD",0);
			sheetObj.SetColHidden("OB_CON_VVD",0);
		}else if(polVal == "" && podVal != ""){
			sheetObj.SetColHidden("OB_CON_VVD",1);
			sheetObj.SetColHidden("IB_CON_VVD",0);			
		}else if(polVal != "" && podVal == ""){
			sheetObj.SetColHidden("OB_CON_VVD",0);			
			sheetObj.SetColHidden("IB_CON_VVD",1);
		}
		sheetObj.SetDown2ExcelUrl("/opuscntr/js/ibsheet/jsp/Down2Excel3.jsp");
		sheetObj.Down2Excel({FileName : vvdExcelName + '_FRT.xls', DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1});
		//ComOpenWait(false);
	}

	function sheet8_OnDownFinish(downloadType, result) {
		sheetObjects[8].LoadSearchData(resultJson.listBlRmk,{Sync:1} );
	}
	
	function sheet9_OnSearchEnd(sheetObj, Code, Msg) {
		//ComOpenWait(true);
		var formObj=document.form;
		var polVal=formObj.pol_cd.value;
		var podVal=formObj.pod_cd.value;
		
		if(polVal != "" && podVal != ""){
			sheetObj.SetColHidden("IB_CON_VVD",0);
			sheetObj.SetColHidden("OB_CON_VVD",0);
		}else if(polVal == "" && podVal != ""){
			sheetObj.SetColHidden("OB_CON_VVD",1);
			sheetObj.SetColHidden("IB_CON_VVD",0);			
		}else if(polVal != "" && podVal == ""){
			sheetObj.SetColHidden("OB_CON_VVD",0);			
			sheetObj.SetColHidden("IB_CON_VVD",1);
		}
		sheetObj.SetDown2ExcelUrl("/opuscntr/js/ibsheet/jsp/Down2Excel4.jsp");
		sheetObj.Down2Excel({FileName : vvdExcelName + '_RMK.xls', DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1});
		//ComOpenWait(false);
	}
	
	function sheet9_OnDownFinish(downloadType, result) {
		sheetObjects[9].LoadSearchData(resultJson.listCgo,{Sync:1} );
	}
	
	function sheet10_OnSearchEnd(sheetObj, Code, Msg) {
		//ComOpenWait(true);
		var formObj=document.form;
		var polVal=formObj.pol_cd.value;
		var podVal=formObj.pod_cd.value;
		
		if(polVal != "" && podVal != ""){
			sheetObj.SetColHidden("IB_CON_VVD",0);
			sheetObj.SetColHidden("OB_CON_VVD",0);
		}else if(polVal == "" && podVal != ""){
			sheetObj.SetColHidden("OB_CON_VVD",1);
			sheetObj.SetColHidden("IB_CON_VVD",0);			
		}else if(polVal != "" && podVal == ""){
			sheetObj.SetColHidden("OB_CON_VVD",0);			
			sheetObj.SetColHidden("IB_CON_VVD",1);
		}
		sheetObj.SetDown2ExcelUrl("/opuscntr/js/ibsheet/jsp/Down2Excel5.jsp");
		sheetObj.Down2Excel({FileName : vvdExcelName + '_CGO.xls', DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1});
		//ComOpenWait(false);
	}
	
	function sheet10_OnDownFinish(downloadType, result) {
		sheetObjects[10].LoadSearchData(resultJson.listCgoPck,{Sync:1} );
	}
	
	function sheet11_OnSearchEnd(sheetObj, Code, Msg) {
		//ComOpenWait(true);
		var formObj=document.form;
		var polVal=formObj.pol_cd.value;
		var podVal=formObj.pod_cd.value;
		
		if(polVal != "" && podVal != ""){
			sheetObj.SetColHidden("IB_CON_VVD",0);
			sheetObj.SetColHidden("OB_CON_VVD",0);
		}else if(polVal == "" && podVal != ""){
			sheetObj.SetColHidden("OB_CON_VVD",1);
			sheetObj.SetColHidden("IB_CON_VVD",0);			
		}else if(polVal != "" && podVal == ""){
			sheetObj.SetColHidden("OB_CON_VVD",0);			
			sheetObj.SetColHidden("IB_CON_VVD",1);
		}
		sheetObj.SetDown2ExcelUrl("/opuscntr/js/ibsheet/jsp/Down2Excel6.jsp");
		sheetObj.Down2Excel({FileName : vvdExcelName + '_PCK.xls', DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1});
		//ComOpenWait(false);
	}

	function sheet11_OnDownFinish(downloadType, result) {
		sheetObjects[11].LoadSearchData(resultJson.listCgoMkNo,{Sync:1} );
	}
	
	function sheet12_OnSearchEnd(sheetObj, Code, Msg) {
		//ComOpenWait(true);
		var formObj=document.form;
		var polVal=formObj.pol_cd.value;
		var podVal=formObj.pod_cd.value;
		
		if(polVal != "" && podVal != ""){
			sheetObj.SetColHidden("IB_CON_VVD",0);
			sheetObj.SetColHidden("OB_CON_VVD",0);
		}else if(polVal == "" && podVal != ""){
			sheetObj.SetColHidden("OB_CON_VVD",1);
			sheetObj.SetColHidden("IB_CON_VVD",0);			
		}else if(polVal != "" && podVal == ""){
			sheetObj.SetColHidden("OB_CON_VVD",0);			
			sheetObj.SetColHidden("IB_CON_VVD",1);
		}
		sheetObj.SetDown2ExcelUrl("/opuscntr/js/ibsheet/jsp/Down2Excel7.jsp");
		sheetObj.Down2Excel({FileName : vvdExcelName + '_CM.xls', DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1});
		//ComOpenWait(false);
	}
	
	function sheet12_OnDownFinish(downloadType, result) {
		sheetObjects[12].LoadSearchData(resultJson.listBlNtfy,{Sync:1} );
	}
	
	function sheet13_OnSearchEnd(sheetObj, Code, Msg) {
		//ComOpenWait(true);
		var formObj=document.form;
		var polVal=formObj.pol_cd.value;
		var podVal=formObj.pod_cd.value;
		
		if(polVal != "" && podVal != ""){
			sheetObj.SetColHidden("IB_CON_VVD",0);
			sheetObj.SetColHidden("OB_CON_VVD",0);
		}else if(polVal == "" && podVal != ""){
			sheetObj.SetColHidden("OB_CON_VVD",1);
			sheetObj.SetColHidden("IB_CON_VVD",0);			
		}else if(polVal != "" && podVal == ""){
			sheetObj.SetColHidden("OB_CON_VVD",0);			
			sheetObj.SetColHidden("IB_CON_VVD",1);
		}
		sheetObj.SetDown2ExcelUrl("/opuscntr/js/ibsheet/jsp/Down2Excel8.jsp");
		sheetObj.Down2Excel({FileName : vvdExcelName + '_CUST.xls', DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1});
		//ComOpenWait(false);
	}	

	function sheet13_OnDownFinish(downloadType, result) {
		sheetObjects[13].LoadSearchData(resultJson.listBlRout,{Sync:1} );
	}
	
	function sheet14_OnSearchEnd(sheetObj, Code, Msg) {
		//ComOpenWait(true);
		var formObj=document.form;
		var polVal=formObj.pol_cd.value;
		var podVal=formObj.pod_cd.value;
		
		if(polVal != "" && podVal != ""){
			sheetObj.SetColHidden("IB_CON_VVD",0);
			sheetObj.SetColHidden("OB_CON_VVD",0);
		}else if(polVal == "" && podVal != ""){
			sheetObj.SetColHidden("OB_CON_VVD",1);
			sheetObj.SetColHidden("IB_CON_VVD",0);			
		}else if(polVal != "" && podVal == ""){
			sheetObj.SetColHidden("OB_CON_VVD",0);			
			sheetObj.SetColHidden("IB_CON_VVD",1);
		}
		sheetObj.SetDown2ExcelUrl("/opuscntr/js/ibsheet/jsp/Down2Excel9.jsp");
		sheetObj.Down2Excel({FileName : vvdExcelName + '_ROUT.xls', DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1});
		//ComOpenWait(false);
	}
	