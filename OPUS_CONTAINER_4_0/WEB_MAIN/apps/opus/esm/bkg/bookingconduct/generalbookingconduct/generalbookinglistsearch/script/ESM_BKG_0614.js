/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0614.js
*@FileTitle  : Work With Bookings 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// Common global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var comboObjects=new Array();
var comboCnt=0;
var sheetObjects=new Array();
var sheetCnt=0;
var dtOver =false;
var layList = null; 

// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         /* */
        var sheetObject1=sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
         /*******************************************************/
        var formObject=document.form;
        
        if(layList == undefined || layList == null) layList = document.getElementById("layList");
        
    	try {
    		var srcName=ComGetEvent("name");
    		
			switch(srcName) {
				case "btn_multBkgNo":	
					
					if($("#btn_multBkgNo").is(":disabled")) return;
					var stop = $("#bkg_no").offset().top;
				    var sleft = $("#bkg_no").offset().left;
				    layList.style.left = sleft + "px";
				    layList.style.top = (stop-40) + "px";
				    
					if($("#layList").is(":visible") == false){
						$("#layList").show();
					}else{
						$("#layList").hide();
					}
					
				break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"","");
					break;
				case "btn_New":
					doActionIBSheet(sheetObjects[0],document.form,IBCLEAR,"","");
					ComClearObject(document.form.bkg_from_dt);
					ComClearObject(document.form.bkg_to_dt);
					ComClearObject(document.form.bkg_ofc_cd);
					ComClearObject(document.form.bkg_stf_cd);
					ComClearObject(document.form.cust_cnt_cd);
					ComClearObject(document.form.si_via_cd_text);
					ComClearObject(document.form.bkg_via_cd_text);
					ComClearObject(document.form.bro_ken_route);
					document.form.mult_bkg_no.value = '';
					multiBkgTextArea(1);
					
					break;
				case "btn_DownExcel":
					if ( sheetObjects[0].GetTotalRows()> 0 ) {
						doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL,"","");
					}
					break;
				case "btn_BookingMain":
					if(sheetObjects[0].CheckedRows("slct_flg") < 1){
						ComShowCodeMessage("BKG00155");
						return false;
					}
					if(!validateForm(sheetObjects[0],formObject,"btn_BookingMain")) {
						return false;
					}
					var param="";
					var chkRowArr=sheetObjects[0].FindCheckedRow("slct_flg");
					var chkRow=chkRowArr.split("|");
					if ( chkRowArr != "" ) {
						ComBkgCall0079(sheetObjects[0].GetCellValue(chkRow[0], "bkg_no"));
					}
					break;
				case "btn_BKGCopy":
					if(sheetObjects[0].CheckedRows("slct_flg") < 1){
						ComShowCodeMessage("BKG00155");
						return false;
					}
					if(!validateForm(sheetObjects[0],formObject,"btn_BKGCopy")) {
						return false;
					}
					var param="";
					var chkRowArr=sheetObjects[0].FindCheckedRow("slct_flg");
					var chkRow=chkRowArr.split("|");
//					if ( sheetObjects[0].CellValue(chkRow[0], "st") == "X" ) {
//						ComShowMessage(msgs['BKG00090']);
//						return;
//					} else if ( sheetObjects[0].CellValue(chkRow[0], "bdr") == "YES" ) {
//						ComShowMessage(msgs['BKG00091']);
//						return;
//					}
					if ( chkRowArr != "" ) {
						param="?bkg_no="+sheetObjects[0].GetCellValue(chkRow[0], "bkg_no");
						ComOpenWindowCenter("/opuscntr/ESM_BKG_0077.do" + param, "PopupEsmBkg0614", 720, 650, false);
					}
					break;
				case "btn_BLCopy":
					if(sheetObjects[0].CheckedRows("slct_flg") < 1){
						ComShowCodeMessage("BKG00155");
						return false;
					}
					if(!validateForm(sheetObjects[0],formObject,"btn_BLCopy")) {
						return false;
					}
					if (sheetObjects[0].CheckedRows("slct_flg") > 0) {
						ComOpenWindowCenter("/opuscntr/ESM_BKG_0648_POP.do?isPop=Y", "PopupEsmBkg0648", 500, 440, false);
					}
					break;
				case "btn_Split":
					if(sheetObjects[0].CheckedRows("slct_flg") < 1){
						ComShowCodeMessage("BKG00155");
						return false;
					}
					if(!validateForm(sheetObjects[0],formObject,"btn_Split")) {
						return false;
					}
					var param="";
					var chkRowArr=sheetObjects[0].FindCheckedRow("slct_flg");
					var chkRow=chkRowArr.split("|");
					if ( sheetObjects[0].CheckedRows("slct_flg") > 1 ) {
						ComShowMessage(msgs['BKG00154']);
						return;
					}
					if ( chkRowArr != "" ) {
						var params="&bkg_no="+sheetObjects[0].GetCellValue(chkRow[0], "bkg_no")+"&popUpFlag=Y";
						params += "&pgmNo=ESM_BKG_0099";	  
						ComOpenPopup("/opuscntr/ESM_BKG_0099_P.do?mainPage=false" + params, 1200, 700, "", "1,0,1,1,1", true);
			        }
					break;
				case "btn_Combine":
					if(sheetObjects[0].CheckedRows("slct_flg") < 1){
						ComShowCodeMessage("BKG00155");
						return false;
					}
					if(!validateForm(sheetObjects[0],formObject,"btn_Combine")) {
						return false;
					}
					comBkgCallPop0974('callBack0974');
					break;
				case "btn_BLPrint":
					if(sheetObjects[0].CheckedRows("slct_flg") < 1){
						ComShowCodeMessage("BKG00155");
						return false;
					}
					if(!validateForm(sheetObjects[0],formObject,"btn_BLPrint")) {
						return false;
					}
					var param=bkgNos="";
					var arrRow=ComFindText(sheetObjects[0], "slct_flg", 1);
					if (arrRow && 0<arrRow.length) {
						for (var i=0; i<arrRow.length; i++) {
							bkgNos += sheetObjects[0].GetCellValue(arrRow[i],"bkg_no")+",";
						}
						if (0<bkgNos.indexOf(",")) bkgNos=bkgNos.substring(0,bkgNos.length-1);
					} else {
    					ComShowCodeMessage("COM12176");
						return false;
					}
					param="?bkg_no="+bkgNos;
					
					ComOpenWindowCenter("/opuscntr/ESM_BKG_0743_01.do"+param, "PopupEsmBkg074301", 900, 400, false);
					
					break;
				case "btns_calendar":
					var cal=new ComCalendarFromTo();
					cal.select(formObject.bkg_from_dt, formObject.bkg_to_dt,'yyyy-MM-dd');
					break;
				case "btn_ComEns041Pop": // com customer pop-up
					var custCntCd=formObject.cust_cnt_cd.value;
					var custSeq=formObject.cust_seq.value;
					var custNm=formObject.cust_nm.value;
	        		ComOpenPopup("/opuscntr/COM_ENS_041.do?pgmNo=COM_ENS_041&cust_cd="+ custCntCd+custSeq+"&cust_nm="+custNm, 770, 470, "callBackComEns041", '0,1,1,1,1,1,1', true);
	        		break;
	        		
				case "btn_multi_bkg":
					ComBtnEnable("btn_multBkgNo");
					sheetObject2.RemoveAll();
					sheetObject2.LoadExcel({ColumnMapping:'1'});
					break;
	        		
            } // end switch
    	} catch(e) {
//    		if (e == "[object Error]") {
//    			alert(e.description);
//    		} else {
//    			ComShowMessage(e);
//    		}
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
      * initializing Combo
      */
      function initCombo(comboObj) {
      	comboObj.SetMultiSelect(1);
      	comboObj.SetColAlign(0, "left");
      	comboObj.SetColAlign(1, "left");
      	comboObj.SetMultiSeparator("|");
      }
      /**
       * registering IBCombo Object as list
       * adding process for list in case of needing batch processing with other items
       * defining list on the top of source
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
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
   	    // initializing IBMultiCombo
   	    for(var j=0; j<comboObjects.length; j++){
   	        initCombo(comboObjects[j]);
   	    }      
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR,"","");
		initControl();
		
		jqueryEvent();
		
		// checkHtml5RDPass
		
    }
    
	function initControl() {
		var formObject=document.form;
		axon_event.addListenerForm('beforedeactivate', 'bkg0614_obj_deactivate', formObject); 
		axon_event.addListenerFormat('beforeactivate',   'bkg0614_activate', formObject); 
		axon_event.addListenerForm('blur', 'form1_blur', formObject);
		axon_event.addListener('keydown', 'ComKeyEnter', formObject);
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
						var HeadTitle1="|Sel.|Seq.|Booking No.|Shipper|T/VVD|CNTR Vol|POR|POR|POL|POL|T/S Port|T/S Port|T/S Port|T/S Port|POD|POD|DEL|DEL|ST|R|D|BDR|Special|Special|Special|Special|Special|Special|S/I|Via|Via";
						HeadTitle1 += "|Forwarder|Consignee / Notify|Customer Ref No.|S/Rep.|Commodity|Commodity|S/OFC|Contract|S/Rep Name|Commodity DESC|Cntr Vol|SHIPPER|BROKER|BKG OFC|bro_ken_route";
						var HeadTitle2="|Sel.|Seq.|Booking No.|Shipper|T/VVD|CNTR Vol|POR|POR|POL|POL|Pre|Pre|Port|Port|POD|POD|DEL|DEL|ST|R|D|BDR|DG|RF|AK|BB|RD|HG|S/I|BKG|S/I";
						HeadTitle2 += "|Forwarder|Consignee / Notify|Customer Ref No.|S/Rep.|Commodity|Commodity|S/OFC|Contract|S/Rep Name|Commodity DESC|Cntr Vol|SHIPPER|BROKER|BKG OFC|bro_ken_route";
						var headCount=ComCountHeadTitle(HeadTitle1);
						SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1} );
						
						var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
						var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
						InitHeaders(headers, info);
						
						var cols = [ 
						 {Type:"Status",    Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"slct_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
						 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
						 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:"shipper",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"tvvd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"cntr_vol",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"por",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"por_nod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 
						 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"pol_nod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pre_loc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"pre_yd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"pst_loc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"pst_yd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"pod_nod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_nod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:22,   Align:"Center",  ColMerge:1,   SaveName:"st",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:22,   Align:"Center",  ColMerge:1,   SaveName:"r",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 
						 {Type:"Text",      Hidden:0, Width:22,   Align:"Center",  ColMerge:1,   SaveName:"d",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bdr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:22,   Align:"Center",  ColMerge:1,   SaveName:"dg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:22,   Align:"Center",  ColMerge:1,   SaveName:"rf",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:22,   Align:"Center",  ColMerge:1,   SaveName:"awk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:22,   Align:"Center",  ColMerge:1,   SaveName:"bb",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:22,   Align:"Center",  ColMerge:1,   SaveName:"rd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:22,   Align:"Center",  ColMerge:1,   SaveName:"hg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"si",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bkg_via",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"si_via",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 
						 {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:"forwarder",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:"cn_nt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cust_ref_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"srep_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rep_cmdt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cmdt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sales_ofc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"sc_rfa",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"srep_nm" },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm" },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"cntr_vol_tot" },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"shipper_code" },
//						 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"del_nod_cd" },
//						 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"por_nod_cd" },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"broker" },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"bkg_ofc_cd" },
						 {Type:"Text",      Hidden:1, Width:50,    Align:"Left",    ColMerge:0,   SaveName:"bro_ken_route" }
						 ];
						   
						InitColumns(cols);
						SetMergeCell(0,8,2,2);
						SetMergeCell(0,14,2,2);
						SetMergeCell(0,34,2,2);
						SetEditable(1);
						SetSheetHeight(390);
						SetRangeBackColor(1,20,1,28,"#555555");
						SetRangeBackColor(1,29,1,31,"#555555");
					}
					break;
					
				case "sheet2":	
					with(sheetObj){			        
						var HeadTitle1="bkg_no";
//						var headCount = ComCountHeadTitle(HeadTitle1);
						SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1} );
						
						var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
						var headers = [ { Text:HeadTitle1, Align:"Center"}];
						InitHeaders(headers, info);
						
						var cols = [
						             {Type:"Text", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no", UpdateEdit:0, InsertEdit:1 }
						            ];
						   
						InitColumns(cols);
						SetEditable(1);
						SetSheetHeight(150);
						SetVisible(0);
					}
					break;
			}
	}
	// handling process for Sheet
	function doActionIBSheet(sheetObj,formObj,sAction,sCondParam,PageNo) {
		$("#layList").hide();
	    sheetObj.ShowDebugMsg(false);
	    switch(sAction) {
		    case IBCLEAR:      //retrieve		  
//			 	formObj.f_cmd.value = INIT;
//			  	var sXml = sheetObj.GetSaveXml("ESM_BKG_0614GS.do", FormQueryString(formObj));
		    	var sXml=formObj.sXml.value;
				var arrXml=sXml.split("|$$|");  
				// setting Combo
				if (arrXml.length > 0){	// BKG Via
					ComBkgXml2ComboItem2(arrXml[0], comboObjects[0], "val", "desc");				
				}             		
				if (arrXml.length > 1){	// S/I Via
					ComBkgXml2ComboItem2(arrXml[1], comboObjects[1], "val", "name");		
				}   
				if (arrXml.length > 1){	// E/Q Type
					ComBkgXml2ComboItem2(arrXml[2], comboObjects[2], "val", "name");		
				}   
			    formObj.sXml.value=null;
				// hiding Display T/S Port Info.
				sheetObj.SetColHidden(11,1);
				sheetObj.SetColHidden(12,1);
				sheetObj.SetColHidden(13,1);
				sheetObj.SetColHidden(14,1);
				ComClearObject(formObj.por_cd);
				ComClearObject(formObj.rf_flg);
				ComClearObject(bkg_via_cd);
				ComClearObject(formObj.cust_nm);
				ComClearObject(formObj.rd_cgo_flg);
				ComClearObject(formObj.hngr_flg);
				ComClearObject(formObj.bdr_flg);
				ComClearObject(formObj.bkg_sts_cd);
				ComClearObject(formObj.srep_cd);
				ComClearObject(formObj.pol_cd);
				ComClearObject(si_via_cd);
				ComClearObject(formObj.bb_cgo_flg);
				ComClearObject(formObj.sls_ofc_cd);
				ComClearObject(formObj.dcgo_flg);
				ComClearObject(formObj.bkg_cust_tp_cd);
				ComClearObject(formObj.si_cd);
				ComClearObject(formObj.bkg_ofc_cd);
				ComClearObject(formObj.cust_ref_no);
				ComClearObject(formObj.ts_port);
				ComClearObject(formObj.awk_cgo_flg);
				ComClearObject(formObj.del_cd);
				ComClearObject(formObj.cust_seq);
				ComClearObject(formObj.pod_cd);
				ComClearObject(formObj.vvd);
				ComClearObject(formObj.bkg_stf_cd);
				ComClearObject(formObj.cust_ref_tp_cd);
				ComClearObject(formObj.bkg_no);
				ComClearObject(formObj.sc_rfa_no);
				ComClearObject(formObj.pol_yd_cd);
				ComClearObject(formObj.pod_yd_cd);
				ComClearObject(formObj.dlv_ctnt_cd);
				ComClearObject(formObj.eq_tp_sz_cd);
				formObj.date_gbn[0].checked=true;
				formObj.sc_rfa_gbn[0].checked=true;
				formObj.bkg_from_dt.value=ComGetNowInfo();
				formObj.bkg_to_dt.value=ComGetNowInfo();
				formObj.bkg_ofc_cd.value=userOfc_cd;
				formObj.bkg_stf_cd.value=userId;
				formObj.bkg_cust_tp_cd.selectedIndex=1;
				sheetObj.RemoveAll();
				sheetObj.SetHeaderCheck(0, 1,1);
				sheetObj.SetHeaderCheck(1, 1,1);
				break;
		    case IBSEARCH:      //retrieve
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				
				/* 멀티 부킹 넘버가 100개 넘으면 오류 메세지 */
				if($('#rows').css("color").indexOf('255') > 0){
					ComShowMessage('You can input Booking No up to 100 Maximum. Please kindly check Booking No again.');
					$("#layList").show();
					return false;
				}
				
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
			   	formObj.f_cmd.value=SEARCH;
			   	sheetObj.DoSearch("ESM_BKG_0614GS.do", FormQueryString(formObj)+"&"+ "page_no=1",{Append:false} );
		        break;
		    case "run_combine":        //handling Combine
				formObj.f_cmd.value=MODIFY01;
				var params=FormQueryString(formObj);
				params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, 1), "sheet1_");
				var sXml=sheetObj.GetSaveData("ESM_BKG_0614GS.do", params);
				if(ComGetEtcData(sXml, "isSuccess") == "Y"){
					ComShowCodeMessage("BKG00166");
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					if("Y" == ComGetEtcData(sXml, "pre_checking")){
						comBkgCallPop0200(mst_bkg_no.value, "N");
					}
				} else {
	         		sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
				}
				break;
//			case IBSEARCHAPPEND:
//				sheetObj.DoSearch("ESM_BKG_0614GS.do", FormQueryString(formObj),"page_no=" + PageNo , false);
//		    	break;
		    case IBDOWNEXCEL:
		    	sheetObj.Down2Excel();
		//           	formObj.f_cmd.value = SEARCH;
		//           	ComOpenWait(true,true);
		//           	sheetObj.DoSearch("ESM_BKG_0614GS.do", FormQueryString(formObj) + "&excel_flg=Y"  );
		        break;
	    }
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	var result=false;
    	with(formObj){
			switch(sAction) {
				case IBSEARCH:
					result=checkMendatoryDt(formObj);
					if (dtOver) return false;
					if (!result) result=checkMendatoryVVD(formObj);
					if (!result) result=checkMendatoryBkgNo(formObj);
					if (!result) {
						ComShowCodeMessage("BKG00104","\nDate or\nVVD or\nBooking No.\n");
						return false;
					}		
					if (ComGetDaysBetween(formObj.bkg_from_dt,formObj.bkg_to_dt) > 1) {
						if((formObj.vvd.value == "" || ComIsNull(formObj.vvd)) 
								&& (formObj.pol_cd.value == "" || ComIsNull(formObj.pol_cd)) 
								&& (formObj.pod_cd.value == "" || ComIsNull(formObj.pod_cd))
								&& (formObj.por_cd.value == "" || ComIsNull(formObj.por_cd)) 
								&& (formObj.del_cd.value == "" || ComIsNull(formObj.del_cd)) 
								&& (ComGetObjValue(formObj.dlv_ctnt_cd) == "All" || ComGetObjValue(formObj.dlv_ctnt_cd) == null || ComGetObjValue(formObj.dlv_ctnt_cd) == "")
								&& (ComGetObjValue(formObj.bkg_sts_cd)  == "All" || ComGetObjValue(formObj.bkg_sts_cd)  == null || ComGetObjValue(formObj.bkg_sts_cd)  == "")
								&& (formObj.bkg_ofc_cd.value == "" || ComIsNull(formObj.bkg_ofc_cd)) 
								&& (formObj.bkg_stf_cd.value == "" || ComIsNull(formObj.bkg_stf_cd))
								&& (formObj.sls_ofc_cd.value == "" || ComIsNull(formObj.sls_ofc_cd))
								&& (formObj.srep_cd.value    == "" || ComIsNull(formObj.srep_cd))
								&& formObj.dcgo_flg.checked 	== false
								&& formObj.rf_flg.checked 		== false
								&& formObj.awk_cgo_flg.checked 	== false
								&& formObj.bb_cgo_flg.checked 	== false
								&& formObj.rd_cgo_flg.checked 	== false
								&& formObj.hngr_flg.checked 	== false
								&& (formObj.bkg_no.value       == "" || ComIsNull(formObj.bkg_no)) 
								&& (formObj.mult_bkg_no.value.trim()  == "" || ComIsNull(formObj.mult_bkg_no ))  
								&& (formObj.cust_cnt_cd.value  == "" || ComIsNull(formObj.cust_cnt_cd))
								&& (formObj.cust_seq.value     == "" || ComIsNull(formObj.cust_cnt_seq)) 
								&& (formObj.cust_nm.value      == "" || ComIsNull(formObj.cust_nm)) 	
								&& (ComGetObjValue(formObj.cust_ref_tp_cd) == "All" || ComGetObjValue(formObj.cust_ref_tp_cd) == null || ComGetObjValue(formObj.cust_ref_tp_cd) == "")
								&& (formObj.cust_ref_no.value == "" || ComIsNull(formObj.cust_ref_no))
								&& (formObj.sc_rfa_no.value   == "" || ComIsNull(formObj.sc_rfa_no))
								&& (ComGetObjValue(formObj.bdr_flg)    == "All" || ComGetObjValue(formObj.bdr_flg) == null || ComGetObjValue(formObj.bdr_flg) == "") 
								&& (ComGetObjValue(formObj.si_cd)      == "All" || ComGetObjValue(formObj.si_cd)   == null || ComGetObjValue(formObj.si_cd)   == "")
								&& (ComGetObjValue(bkg_via_cd) == "" || ComGetObjValue(bkg_via_cd) == null)
								&& (ComGetObjValue(si_via_cd)  == "" || ComGetObjValue(si_via_cd) == null)
								&& (ComGetObjValue(eq_tp_sz_cd)  == "" || ComGetObjValue(eq_tp_sz_cd) == null)
								){
							ComShowCodeMessage( "BKG00104", "at least one optional item");
							return false;		
						}
					}
					/* 멀티 부킹 중복 체크 */
					duplicateBkgNoCheck('mult_bkg_no');	
					
					return true;
					break;
				case IBDOWNEXCEL:
					result=checkMendatoryDt(formObj);
					if (dtOver) return false;
					if (!result) result=checkMendatoryVVD(formObj);
					if (!result) result=checkMendatoryBkgNo(formObj);
					if (!result) {
						ComShowCodeMessage("BKG00104","\nDate or\nVVD or\nBooking No.\n");
					}
					return result;
					break;
				case "btn_BookingMain":
					result=checkMendatoryDt(formObj);
					if (dtOver) return false;
					if (!result) result=checkMendatoryVVD(formObj);
					if (!result) result=checkMendatoryBkgNo(formObj);
					if (!result) {
						ComShowCodeMessage("BKG00104","\nDate or\nVVD or\nBooking No.\n");
					}
					return result;
					break;
				case "btn_BKGCopy":
					result=checkMendatoryDt(formObj);
					if (dtOver) return false;
					if (!result) result=checkMendatoryVVD(formObj);
					if (!result) result=checkMendatoryBkgNo(formObj);
					if (!result) {
						ComShowCodeMessage("BKG00104","\nDate or\nVVD or\nBooking No.\n");
					}
					return result;
					break;
				case "btn_BLCopy":
					result=checkMendatoryDt(formObj);
					if (dtOver) return false;
					if (!result) result=checkMendatoryVVD(formObj);
					if (!result) result=checkMendatoryBkgNo(formObj);
					if (!result) {
						ComShowCodeMessage("BKG00104","\nDate or\nVVD or\nBooking No.\n");
					}
					return result;
					break;
				case "btn_Split":
					result=checkMendatoryDt(formObj);
					if (dtOver) return false;
					if (!result) result=checkMendatoryVVD(formObj);
					if (!result) result=checkMendatoryBkgNo(formObj);
					if (!result) {
						ComShowCodeMessage("BKG00104","\nDate or\nVVD or\nBooking No.\n");
					}
					return result;
					break;
				case "btn_BLPrint":
					result=checkMendatoryDt(formObj);
					if (dtOver) return false;
					if (!result) result=checkMendatoryVVD(formObj);
					if (!result) result=checkMendatoryBkgNo(formObj);
					if (!result) {
						ComShowCodeMessage("BKG00104","\nDate or\nVVD or\nBooking No.\n");
					}
					return result;
					break;
				case "btn_Combine":
					var param="";
					var chkRowArr=sheetObj.FindCheckedRow("slct_flg");
					var chkRow=chkRowArr.split("|");
					var bdrBkgList="";
					if ( sheetObj.CheckedRows("slct_flg") > 1 ) {
						var bkgNo=sheetObj.GetCellValue(chkRow[0], "bkg_no").substring(0, 3);
						var shCd=sheetObj.GetCellValue(chkRow[0], "shipper_code");
						var vvdCd=sheetObj.GetCellValue(chkRow[0], "tvvd");
						var porCd=sheetObj.GetCellValue(chkRow[0], "por");
						var polCd=sheetObj.GetCellValue(chkRow[0], "pol");
						var podCd=sheetObj.GetCellValue(chkRow[0], "pod");
						var delCd=sheetObj.GetCellValue(chkRow[0], "del");
						var porNodCd=sheetObj.GetCellValue(chkRow[0], "por_nod_cd");
						var delNodCd=sheetObj.GetCellValue(chkRow[0], "del_nod_cd");
						var broker=sheetObj.GetCellValue(chkRow[0], "broker");
						var bkgOfcCd=sheetObj.GetCellValue(chkRow[0], "bkg_ofc_no");
						
						for (var idx=0;idx<chkRow.length;idx++) {
							if (bkgOfcCd != sheetObj.GetCellValue(chkRow[idx], "bkg_ofc_no")) {
	    						ComShowMessage(msgs['BKG00160']);
	    						return false;
							}
							if (shCd != sheetObj.GetCellValue(chkRow[idx], "shipper_code")) {
								ComShowMessage(msgs['BKG00157']);
								return false;
							}
							if (vvdCd != sheetObj.GetCellValue(chkRow[idx], "tvvd")) {
								ComShowMessage(msgs['BKG00998']);
								return false;
							}
							if (porCd != sheetObj.GetCellValue(chkRow[idx], "por")) {
								ComShowMessage(msgs['BKG00158']);
								return false;
							}
							if (polCd != sheetObj.GetCellValue(chkRow[idx], "pol")) {
								ComShowMessage(msgs['BKG00997']);
								return false;
							}
							if (podCd != sheetObj.GetCellValue(chkRow[idx], "pod")) {
								ComShowMessage(msgs['BKG03159']);
								return false;
							} 
							if (delCd != sheetObj.GetCellValue(chkRow[idx], "del")) {
								ComShowMessage(msgs['BKG00159']);
								return false;
							}
							if (porNodCd != sheetObj.GetCellValue(chkRow[idx], "por_nod_cd")) {
								ComShowMessage(msgs['BKG02014']);
							}
							if (delNodCd != sheetObj.GetCellValue(chkRow[idx], "del_nod_cd")) {
								ComShowMessage(msgs['BKG02015']);
							}
							if (broker != sheetObj.GetCellValue(chkRow[idx], "broker")) {
								ComShowMessage(msgs['BKG02015']);
								return false;
							}
							if(sheetObj.GetCellValue(chkRow[idx],"bdr")=="YES"){
								if(bdrBkgList ==""){
									bdrBkgList=sheetObj.GetCellValue(chkRow[idx], "bkg_no");
								} else {
									drBkgList=bdrBkgList + ", " + sheetObj.GetCellValue(chkRow[idx], "bkg_no");
								}
							}
						}
						if(bdrBkgList !=""){
							if (!ComShowCodeConfirm("BKG02038", bdrBkgList)) {
		        	    		return false;
							} 
						}
					}		
					break;
			}
		}	
        return true;
    }
    /**
     *  displayiing/hiding Port Info. in case of checking Display T/S Port
     * @return
     */
    function showTsPortInfo() {
    	var sheetObj=sheetObjects[0];
    	if ( document.form.ts_port.checked ) {
			sheetObj.SetColHidden(10,0);
			sheetObj.SetColHidden(11,0);
			sheetObj.SetColHidden(12,0);
			sheetObj.SetColHidden(13,0);
		} else {
			sheetObj.SetColHidden(10,1);
			sheetObj.SetColHidden(11,1);
			sheetObj.SetColHidden(12,1);
			sheetObj.SetColHidden(13,1);
		}
    }
	function sheet1_OnSearchEnd(sheetObj, Code, ErrMsg){
		ComOpenWait(false);
		sheetObj.SelectCell(0,0,false);
		sheetObj.SetColFontUnderline("bkg_no",1);
		sheetObj.SetColFontUnderline("srep_cd",1);
		sheetObj.SetColFontUnderline("rep_cmdt",1);
		sheetObj.SetColFontUnderline("cmdt",1);
		for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow();i++){
			if(sheetObj.GetCellValue(i, "bro_ken_route") != '0'){
				sheetObj.SetCellFontColor(i, "bkg_no","#FF0000");
			}else{
				sheetObj.SetCellFontColor(i, "bkg_no","#0000FF");
			}
			sheetObj.SetCellFontColor(i, "dg",getSpclCgoColor(sheetObj, sheetObj.GetCellValue(i, "dg")));
			sheetObj.SetCellFontColor(i, "rf",getSpclCgoColor(sheetObj, sheetObj.GetCellValue(i, "rf")));
			sheetObj.SetCellFontColor(i, "awk",getSpclCgoColor(sheetObj, sheetObj.GetCellValue(i, "awk")));
			sheetObj.SetCellFontColor(i, "bb",getSpclCgoColor(sheetObj, sheetObj.GetCellValue(i, "bb")));
		}
	}	
	function getSpclCgoColor(sheetObj, aproDspCd){
//		A:APPROVE -> Blue
//		N:REJECT  -> Red
// 		P:PENDING, R:RQST, OTHER:SPECIAL CARGO EXIST -> black
		if(aproDspCd=="A"){
			return "#0000FF";
		} else if(aproDspCd=="N" || aproDspCd=="X"){ 
			return "#FF0000";
		} else {
			return "#000000";
		}
	}

	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		with(sheetObj){
			Row=MouseRow();
			var colName=ColSaveName(MouseCol());
			if ("srep_cd" == colName) {
				SetMousePointer("Hand");
				sText=GetCellText(Row,"srep_nm");
				SetToolTipText(Row, "srep_cd", sText);
			} else if ("cmdt" == colName) {
				SetMousePointer("Hand");
				sText=GetCellText(Row,"cmdt_nm");
				SetToolTipText(Row, "cmdt", sText);
			}
		}
	}
    /**
     * double click event
     * @param row
     * @param col
     * @return
     */
    function sheet1_OnDblClick(sheetObj, row, col) {
		if ( col == 3 ) {
			var param="";
			var chkBkgNo = sheetObjects[0].GetCellValue(row, "bkg_no");
			if ( chkBkgNo != "" ) {	
				var param = 'pgm_no=ESM_BKG_0079';
				var sXml = sheetObjects[0].GetSearchData("ESM_Booking_UtilGS.do?f_cmd="+SEARCH16, param);
				var cnt = ComGetEtcData(sXml, "CNT");
				if(cnt > 0){
					ComBkgCall0079(chkBkgNo);
				}else{
					ComBkgCall0079Q(chkBkgNo);
				}
			}
		}
    }
    
	function bkg0614_activate(){
		//input Validation
		switch(ComGetEvent("name")){	
	    	case "bkg_from_dt":
	    		ComClearSeparator(ComGetEvent());
				break;
	    	case "bkg_to_dt":
	    		ComClearSeparator(ComGetEvent());
				break;
			default:
				ComGetEvent().onfocus=new Function("this.select()");
				break;
		}
	}
    function bkg0614_obj_deactivate(){
    	switch(ComGetEvent("name")){
	    	case "bkg_from_dt":
	    		ComAddSeparator(ComGetEvent());
    			break;
	    	case "bkg_to_dt":
	    		ComAddSeparator(ComGetEvent());
    			break;
	    	case "cust_seq":
	    		if ( ComGetEvent().value != '' && ComGetEvent().value.length < 6 ) {
	    			var fillZero="";
	    			for (var i=0;i<(6-ComGetEvent().value.length);i++) {
	    				fillZero += "0";
	    			}
	    			ComGetEvent().value=fillZero + ComGetEvent().value;
	    		}
    			break;
    		default:
    			break; 
    	}
    }
	function form1_blur(){
		ComChkObjValid(ComGetEvent(),null,null,false);
	}
	
   	function obj_keydown() {
   		var obj = ComGetEvent();
   		var vKeyCode = event.keyCode;
   		var formObj = document.form;
   		if ( vKeyCode == 13 ) {
   			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH,"page_no=1", false);
   		}
   	}
	function checkMendatoryDt(formObj){
		dtOver = false;
		if( formObj.bkg_from_dt.value == "" ){
//			ComShowCodeMessage( "COM12114", "Booking Create DT" );
//			formObj.bkg_from_dt.focus();
			return false;
		}
		if( formObj.bkg_to_dt.value == "" ){
//			ComShowCodeMessage( "COM12114", "Booking Create DT" );
//			formObj.bkg_to_dt.focus();
			return false;
		}
		if (formObj.bkg_from_dt.value != "" && formObj.bkg_to_dt.value != "") {
			if (ComGetDaysBetween(formObj.bkg_from_dt,formObj.bkg_to_dt) < 0) {
				dtOver = true;
				ComShowMessage(msgs['BKG00421']);
				return false;
			} 		
			if (ComGetDaysBetween(formObj.bkg_from_dt.value, formObj.bkg_to_dt.value)>31){
				dtOver = true;
				ComShowMessage(msgs['BKG50469']);
				return false;
			}
		} 				
		return true;
	}
	function checkMendatoryVVD(formObj){
		if( formObj.vvd.value == "" ){
//			ComShowCodeMessage('BKG00104');
//			formObj.vvd.focus();
			return false;
		}
		return true;
	}
	function checkMendatoryBkgNo(formObj){
		if( formObj.bkg_no.value == "" && formObj.mult_bkg_no.value.trim() == ""){
			return false;
		}
		return true;
	}
	
	String.prototype.trim = function() {
		return this.replace(/(^\s*)|(\s*$)/gi, "");
	}
	
    /**
    * callback function - Customer Inquiry(common Popup)
    */    	
   function callBackComEns041(rArray){
  		var formObj=document.form;
   		if(rArray != null){
   			ComSetObjValue(formObj.cust_cnt_cd, rArray[0][3].substring(0,2));
   			ComSetObjValue(formObj.cust_seq, ComLpad(rArray[0][3].substring(2),6,"0"));
   			ComSetObjValue(formObj.cust_nm, rArray[0][4]);    		    			   			
   		}
    }	
    function comBkgCallPop0974(callback_func){
		if (sheetObjects[0].CheckedRows("slct_flg") > 1) {
			var param="";
			var chkRowArr=sheetObjects[0].FindCheckedRow("slct_flg");
			var chkRow=chkRowArr.split("|");
			if ( sheetObjects[0].CheckedRows("slct_flg") > 1 ) {
				for(var idx=0;idx<chkRow.length;idx++) {
					if(idx == 0){
						param="ibflag=U&bkg_no=" + sheetObjects[0].GetCellValue(chkRow[idx], "bkg_no")
						+"&bdr_flg=" + sheetObjects[0].GetCellValue(chkRow[idx], "bdr");
					} else {
						param=param +"&ibflag=U&bkg_no=" + sheetObjects[0].GetCellValue(chkRow[idx], "bkg_no")
						+"&bdr_flg=" + sheetObjects[0].GetCellValue(chkRow[idx], "bdr");
					}
				}
			}
			ComOpenPopup("/opuscntr/ESM_BKG_0974.do?"+param, 800, 350, callback_func, "1,0", true);
		}
    }
    
    function setMessage(msg){
    	document.form.message.value = msg;
    }
    
    function callBack0974(rArray){
    	var formObj=document.form;
    	formObj.mst_bkg_no.value=rArray[0];
		var chkRowArr=sheetObjects[0].FindCheckedRow("slct_flg");
		var chkRow=chkRowArr.split("|");
		var bdrFlg="N";
		if ( sheetObjects[0].CheckedRows("slct_flg") > 1 ) {
			for(var idx=0;idx<chkRow.length-1;idx++) {
				if(sheetObjects[0].GetCellValue(chkRow[idx], "bdr") == "YES"){
					bdrFlg="Y";
					break;
		    	}
			}
			if(bdrFlg=="Y"){
				comBkgCallPop0708('setCAReasonCallBack', ComGetObjValue(formObj.mst_bkg_no), "C");
		 		doActionIBSheet(sheetObjects[0],formObj,"run_combine");
			} else {
				doActionIBSheet(sheetObjects[0],formObj,"run_combine");
			}
		}
    }         
	/**
    * callback function - CA Reason : CaReasonModify
    */ 
    function setCAReasonCallBack(arrPopupData) {
        var formObj=document.form;
    	//01. getting input value - CA ReasonCd, Remark
    	var strRsnCd=nullToBlank(arrPopupData[0][2]);
    	var strRemark=nullToBlank(arrPopupData[0][3]);
    	//02. modifyCaReason(e) call
        formObj.ca_rsn_cd.value=strRsnCd;
        formObj.ca_remark.value=strRemark;
    }
    /**
     * when inputting search condition
     */
    function obj_KeyUp() {
    	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
    	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
    	var srcValue=ComGetEvent("value");
    	if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
    }
    
    /* Multi BKG 기능 추가 함수 START */
    
    function sheet2_OnLoadExcel(result) {
    	var sheetObj = sheetObjects[1];
    	var formObj = document.form;
    	var multiBkgText = "";
    	for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++){
    		var bkgNo = sheetObj.GetCellValue(i, "bkg_no");
    		if(i == sheetObj.LastRow()){
    			multiBkgText += bkgNo;
    		}else{
    			multiBkgText += bkgNo + "\n";
    		}
    	}
    	formObj.mult_bkg_no.value = multiBkgText;
    	multiBkgTextArea('', 'mult_bkg_no');
    	$("#btn_multBkgNo").click();
    } 
    
    function jqueryEvent(){
    	$("#bkg_no").keyup(function(){
    		if($(this).val() != ""){
    			multiBkgTextArea(1, 'mult_bkg_no');
    		}
		});
    	$("#mult_bkg_no").keyup(function(){
    		multiBkgTextArea(2, 'mult_bkg_no');
		});
    }

