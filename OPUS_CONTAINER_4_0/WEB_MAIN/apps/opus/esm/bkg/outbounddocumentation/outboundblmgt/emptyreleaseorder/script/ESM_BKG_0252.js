/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0252.js
*@FileTitle  : Empty Container Release Order
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
=========================================================*/
/****************************************************************************************
Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_BKG_0252 : business script for ESM_BKG_0252
     */
    /* developer job	*/
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
	var from_hm;
	var to_hm;
	var fileType = "E";
	// Event handler processing by button click event
    document.onclick=processButtonClick;
	// Event handler processing by button name
        function processButtonClick(){
            var sheetObject = sheetObjects[0];
            /*******************************************************/
            var formObject=document.form;
            var param="";
        	try {
        		var obj = event.target || event.srcElement;
     		   if ($(obj).prop('disabled')) {
     			   return;
     		   }
        		var srcName=ComGetEvent("name");
                switch(srcName) {
                case "btn_CheckAll":
                	sheetObject.CheckAll("Check", 1);
					break;
				case "btn_UncheckAll":
					sheetObject.CheckAll("Check", 0);
					break;
				case "btn_Print":
					if (CheckGrid(sheetObject,"")){ 
						rdOpen("print");
					}
					break;
				case "btn_Preview":
					if (CheckGrid(sheetObject,"")){ 
						rdOpen("preview");
					}
					break;
				case "btn_EditFAXEmail":
					if (CheckGrid(sheetObject,"")){ 
			        	var width=355;
						var height=170;
						var left=(screen.width-width)/2;
						var top=(screen.height-height)/2;
						var url="ESM_BKG_0221.do";
						var url="ESM_BKG_0221.do?func=getCOM_Fax_Email_POPUP&send_hidden=Y";
						ComOpenWindowCenter(url, "ESM_BKG_0221", 400, 190, true);
					}
					break;
				case "btn_FAX":
					if (!ComShowCodeConfirm("BKG00734")) return;    
					if (CheckGrid(sheetObject,"")){ 
						makeRdParam(formObject,sheetObject);
						doActionIBSheet(sheetObject,formObject,"FAX");
					}
					break;  
				case "btn_EMail":
					if (!ComShowCodeConfirm("BKG00735")) return;
					if (CheckGrid(sheetObject,"")){
						makeRdParam(formObject,sheetObject);
						doActionIBSheet(sheetObject,formObject,"EMAIL");
					}
					break;  
				case "btn_EDI":
					if (!ComShowCodeConfirm("BKG00447")) return;    
					if (CheckGrid(sheetObject,"")){
						makeRdParam(formObject,sheetObject);
						doActionIBSheet(sheetObject,formObject,"EDI");
					}
					break;  
				case "btn_EmailEdit":
					if(!validateForm(sheetObject,formObject,"btn_EmailEdit")) {
						return false;
					}
					doActionIBSheet(sheetObject,formObject,"btn_EmailEdit");
					break;
				case "btn_Retrieve":
//					sheetObject.RenderSheet(0);
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
//					sheetObject.RenderSheet(1);
					break;  
				case "btn_New":
					backupHhmm(formObject);
					sheetObject.RemoveAll();
					ComResetAll();
			    	ComClearObject(formObject.elements["from_dt"]);
			    	ComClearObject(formObject.elements["end_dt"]);
			    	ComClearObject(formObject.elements["bkg_ofc_cd"]);
			    	break;
				case "btn_DownExcel":
 					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
 					break;
				case "btns_calendar":
					var cal=new ComCalendarFromTo();
					backupHhmm(formObject);
					cal.setEndFunction("restoreHhmm");
					cal.select(formObject.from_dt, formObject.end_dt,'yyyy-MM-dd hh:mm');
					break;
				case "btns_calendar2":
					var cal=new ComCalendarFromTo();
					cal.select(formObject.from_dt2, formObject.end_dt2,'yyyy-MM-dd');
					break;
				case "btn_Remark":
					if (CheckGrid(sheetObject,"")){ 
						var arrRow=ComFindText(sheetObject,"Check", 1);
						var rmk="";
						if (arrRow && 0<arrRow.length) {
							rmk=1==arrRow.length ? sheetObject.GetCellValue(arrRow[0],"diff_rmk") : "";
						}
						formObject.elements["inter_rmk"].value=rmk;
						var url="ESM_BKG_0913.do?screen_id=0252";
						ComOpenWindowCenter(url, "ESM_BKG_0913", 650, 400, true);
//						ComOpenWindow("ESM_BKG_0913.do?screen_id=0252","ESM_BKG_0913","toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=yes,alwaysRaised,dependent,titlebar=no,width=500,height=320",true);
					}
					break;
				case "btn_LdfDownExcel":
					fileType = "E";
					doActionIBSheet(sheetObject, formObject, "LDFDOW");
					break;
				case "btn_LdfDownCsv":
					fileType = "C";
					doActionIBSheet(sheetObject, formObject, "LDFDOW");
					break;
				case "btn_LdfLog":
					doActionIBSheet(sheetObject, formObject, "btn_LdfLog");
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
    	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
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
//    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//    		alert(document.form.cnt_cd.value);
    		if(document.form.cnt_cd.value =="US"){
    			document.form.ser_type[2].checked=true;
    			chkSerType(document.form.ser_type[2]);
    		}else{
    			chkSerType(document.form.ser_type[1]);
    		}
    	}
      	/**
         * Dynamically load HTML Control event in page. <br>
         * Initialize IBSheet Object by calling this function from {@link #loadPage} function.
         * @param {ibsheet} sheetObj    IBSheet Object
         * @param {int}     sheetNo     sheetObjects list in turn
         **/
        function initControl() {
        	DATE_SEPARATOR="-";
        	var formObject=document.form;
        	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- focus in
     	    axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- focus out
     	   axon_event.addListener('keydown', 'ComKeyEnter', 'form');// Enter key
//        	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- key input
//        	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
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
                    with (sheetObj) {
//	                    var HeadTitle1="|Seq.|Sel.|Booking No.|Booking No.|R|D|CNTR Qty|FH|POR|POL|E/Q OFC|SCC|P/UP CY|CY Name|Fax No.|E-mail|P/UP Date|VVD|T.VVD|VVD Name|RTN CY|Shipper|Commodity|Commodity Detail(s)|Loading Date|I/P|Empty/Full/Terminal|Empty/Full/Terminal|EDI Receiver|EDI Send Date|Fax Sent Date|Fax Result|E-mail Sent Date|E-mail Result|External Remark|Remark(s)|col_chk|tmpl_param|fax_snd_rslt_nm|eml_snd_rslt_nm";
	                    var HeadTitle1="|Seq.|Sel.|Booking No.|Booking No.|R|D|CNTR Qty|FH|POR|POL|E/Q OFC|SCC|P/UP CY|CY Name|Fax No.|E-mail|P/UP Date|VVD|T.VVD|VVD Name|RTN CY|Shipper|Commodity|Commodity Detail(s)|Loading Date|I/P|Empty/Full/Terminal|Yard|EDI Receiver|EDI Send Date|Fax Sent Date|Fax Result|E-mail Sent Date|E-mail Result|External Remark|Remark(s)|col_chk|tmpl_param|fax_snd_rslt_nm|eml_snd_rslt_nm";
	                    var headCount=ComCountHeadTitle(HeadTitle1);
	
	                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                    InitHeaders(headers, info);
	
	                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
	                              {Type:"CheckBox",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Check",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:1 },
	                              {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:1,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
	                              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
	                              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"rcv_term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
	                              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
	                              {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cntr_qty",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                              {Type:"Text",      Hidden:0,  Width:22,   Align:"Center",  ColMerge:1,   SaveName:"flex_hgt_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
	                              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
	                              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
	                              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eq_ctrl_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
	                              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"scc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
	                              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"mty_pkup_yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
	                              {Type:"Text",      Hidden:0,  Width:240,  Align:"Left",    ColMerge:1,   SaveName:"cy_name",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
	                              {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"ntc_fax_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
	                              {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:1,   SaveName:"ntc_eml",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
	                              {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"mty_pkup_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
	                              {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
	                              {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"tvvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
	                              {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:1,   SaveName:"vvd_name",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
	                              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"full_rtn_yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
	                              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
	                              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
	                              {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
	                              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lodg_due_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
	                              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ip",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
	                              {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"yard_type",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
	                              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"yard",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
	                              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"edi_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
	                              {Type:"Text",      Hidden:0,  Width:105,   Align:"Center",  ColMerge:1,   SaveName:"edi_snd_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
	                              {Type:"Text",      Hidden:0,  Width:105,   Align:"Center",  ColMerge:1,   SaveName:"fax_snd_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
	                              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fax_snd_rslt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
	                              {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:1,   SaveName:"eml_snd_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
	                              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eml_snd_rslt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
	                              {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"xter_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
	                              {Type:"Text",      Hidden:0,  Width:200,   Align:"Left",    ColMerge:1,   SaveName:"diff_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
	                              {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"col_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
	                              {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"tmpl_param",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4000 },
	                              {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"fax_snd_rslt_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
	                              {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eml_snd_rslt_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 } ];
	                     
	                    InitColumns(cols);
	
	                    SetEditable(1);
//	                    SetColProperty("edi_snd_dt", {Format:"####-##-####:##"} );
//	                    SetColProperty("fax_snd_dt", {Format:"####-##-####:##"} );
//	                    SetColProperty("eml_snd_dt", {Format:"####-##-####:##"} );
	                    SetAutoRowHeight(0);
	                    SetSheetHeight(340);
                    }
                    break;
                    
                case 2:
                    with(sheetObj){
        		        var HeadTitle="BOOKING NO|BOOKING DATE|BKG IND|TRUNK VESSEL LANE|VVD1 LANE|VVD1 VESSEL CODE|VVD1 LLOYD NO|VVD1 VESSEL NAME|VVD1 CALL SIGN|VVD1 VOYAGE|VVD1 DIR|CONS VOY|VVD1 POL ETD|VVD1 POD ETA|TRUNK VESSEL CODE|TRUNK VESSEL LLOYD NO|TRUNK VESSEL NAME|TRUNK VESSEL CALL SIGN|TVVD VOYAGE NO|TRUNK VESSEL VOYAGE DIR|POR NAME|POR OPUSCODE|POR UNCODE|POR YARD CODE|FIRST POL NAME|FIRST POL UNCODE|FIRST POL YARD|FIRST POL ETA|FIRST POD ETD|CUT OFF TIME FIRST POL|FINAL POD NAME|FINAL POD UNCODE|DEL OPUS CODE|DEL NAME|DEL UNCODE|REC DEL TYPE|REMARK FOR CUSTOMER|REMARK FOR VENDOR|COMMODITY CODE|COMMODITY CODE DESCRIPTION|MTY CNTR PICKUP CY|SHIPPER NAME|FORWARDER NAME|CONSIGNEE NAME|SHIPPER CODE|FWDR CODE|CONSIGNEE CODE|BKG STATUS|DRY IND|RFR IND|AWK IND|BBK IND|HAN IND|STOW IND|STOWAGE CODE|BKG OFFICE|BKG CONTACT POINT|SO NO|BLOCK STOW CODE|MTY PICKUP DATE|FULL RETURN DATE|MTY PICKUP CY COUNTRY|MTY PICKUP CY NAME|FULL RETURN YARD COUNTRY|FULL RETURN YARD NAME|STOW REMARK|EXPORT MRN NO.|SC NO|RFA NO|TAA NO";
        		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
        		        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
        		        InitHeaders(headers, info);
        		        var cols = [ 
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"bkg_no"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"bkg_cre_dt"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"status"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"slan_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"slan_cd1"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"vsl_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"vvd_lloyd_no"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"vsl_eng_nm"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"vvd_call_sign"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"skd_voy_no"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"skd_dir_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cons_voy"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"vps_etd_dt"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"vps_eta_dt"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"vsl_cd1"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"trunk_vessel_lloyd_no"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"vsl_eng_nm1"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"trunk_vessel_call_sign"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"skd_voy_no1"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"skd_dir_cd_t"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"loc_nm"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"por_opscode"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"un_loc_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"por_nod_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"loc_nm1"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"un_loc_cd1"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"pol_nod_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"vps_eta_dt1"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"vps_etd_dt1"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cut_off_time_first_pol"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"loc_nm2"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"un_loc_cd2"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"del_opus_code"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"loc_nm3"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"un_loc_cd3"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"rcv_term_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"xter_rmk"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"vndr_rmk"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cmdt_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cmdt_nm"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"mty_pkup_yd_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cust_nm"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cust_nm1"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cust_nm2"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cust_cnt_cd1"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cust_cnt_cd2"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cust_cnt_cd3"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"bkg_sts_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"rd_cgo_flg"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"rc_flg"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"awk_cgo_flg"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"bb_cgo_flg"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"hngr_flg"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"stwg_rmk"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"stwg_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"bkg_ofc_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"bkg_contact_point"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"twn_so_no"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"blck_stwg_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"mty_pkup_date"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"mty_pkup_date1"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"mty_pkup_yd_cd_t"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"full_return_yard_country"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"full_rtn_yd_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"full_return_yard_name"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"stow_remark"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cust_ref_no_ctnt"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"sc_no"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"rfa_no"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"taa_no"}
        		                    
        		                    ];
        		        InitColumns(cols);
             			SetEditable(0);
             			SetSheetHeight(120);
             			SetExtendLastCol(false);
                    }
        	 	break;
        	 		
                case 3:
                    with(sheetObj){
                	var HeadTitle="BOOKING NO|EQ TPSZ|ISO CODE|SPLIT COMB IND|MASTER BKG|BOOK EQ QTY|SOC IND|RD IND|CHS S|CHS D|CHS T|MHG";
    		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
    		        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
    		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
    		        InitHeaders(headers, info);
    		        var cols = [ 
    		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"bkg_no"},
    		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cntr_tpsz_cd"},
    		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cntr_tpsz_iso_cd"},
    		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"spilt_combine"},
    		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"master_bkg"},
    		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"op_cntr_qty"},
    		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"soc_ind"},
    		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"eq_subst_cntr_tpsz_cd"},
    		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"chs_s"},
    		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"chs_d"},
    		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"chs_t"},
    		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"mhg"}
    		                    ];
    		        InitColumns(cols);
         			SetEditable(0);
         			SetSheetHeight(120);
         			SetExtendLastCol(false);
                    }
        	 	break;
        	 	
                case 4:
                    with(sheetObj){
        		        var HeadTitle="BOOKING NO|CNTR NO|CNTR TPSZ|SEAL NO|RF IND|DG IND|AK IND|BB IND|SOC IND|WGT QTY|WGT TP|RF CMDT CD|RF CMDT DESC|RF NET WT|RF GRS WT|RF WGT UNIT|TEMP UF|TEMP F|TEMP UC|TEMP C|RF VOLTAGE|VENT TYPE|VENT OPEN|VENT CMH|HUMID PC|GENSET REQ|RF REMARK|RF DRY|RF DRAIN|OVL FRONT|OVL REAR|OVH HIGH|OVW LEFT|OVW RIGHT|MOVE STS|EVENT YARD|EVENT TIME|VGM WEIGHT|VGM WEIGHT UNIT COD";
        		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
        		        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
        		        InitHeaders(headers, info);
        		        var cols = [ 
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"bkg_no"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cntr_no"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cntr_tpsz_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"seal_no"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"rc_flg"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"dcgo_flg"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"awk_cgo_flg"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"bb_cgo_flg"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"soc_flg"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cntr_wgt"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"wgt_ut_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cmdt_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cmdt_desc"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"net_wgt"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"grs_wgt"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"wgt_ut_cd1"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"temp_uf"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"fdo_temp"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"temp_uc"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cdo_temp"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"vltg_no"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cntr_vent_tp_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"vent_rto"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"vent_cmh"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"humid_no"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"pwr_spl_cbl_flg"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"diff_rmk"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"rf_dry"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"rf_drain"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"ovr_fwrd_len"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"ovr_bkwd_len"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"ovr_hgt"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"ovr_lf_len"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"ovr_rt_len"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"move_sts"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"event_yard"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"event_time"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"vgm_wgt"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"vgm_wgt_ut_cd"}
        		                    ];
        		        InitColumns(cols);
             			SetEditable(0);
             			SetSheetHeight(120);
             			SetExtendLastCol(false);
                    }
        	 	break;
        	 	
                case 5:
                    with(sheetObj){
        		        var HeadTitle="BOOKING NO|LEG SEQ|TRANSPORT TYPE|LANE CODE|VESSEL CODE|LLOYD NO|VESSEL NAME|CALLSIGN|VOYAGE|VOY DIR|POL UNCODE|POL YARD|CALL SEQ|POL NAME|POL ETA|POL ETD|POD UNCODE|POD YARD|POD NAME|CONS VVD ARR|CONS VVD DEP";
        		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
        		        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
        		        InitHeaders(headers, info);
        		        var cols = [ 
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"bkg_no"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"leg_seq"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"vsl_pre_pst_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"slan_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"vsl_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"lloyd_no"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"vsl_eng_nm"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"callsign"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"skd_voy_no"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"skd_dir_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"un_loc_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"pol_yd_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"pol_clpt_ind_seq"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"loc_nm"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"vps_eta_dt"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"vps_etd_dt"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"un_loc_cd1"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"pod_yd_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"loc_nm1"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cons_vvd_arr"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cons_vvd_dep"}
        		                    ];
        		        InitColumns(cols);
             			SetEditable(0);
             			SetSheetHeight(120);
             			SetExtendLastCol(false);
                    }
        	 	break;
        	 	
                case 6:
                    with(sheetObj){
        		        var HeadTitle="BOOKING NO|CNTR SEQ|CNTR TPSZ|CGO SEQ|CNTR NO|UNNO|CLASS|PSN|EMC PHONE|UN PAGE NO|FLASH POINT|F.POINT C|DG REMARKS|EMS NO|PSA CLASS|PACK GRP|MFAG|M.POLLUTE|SUB RISK1|OUTER PKG QTY|OUTER PKG UNIT|NET WGT|UOM|GRS WGT|UOM (KGS)|HAZ. CONTENTS|SUB RISK2|LTD QTY";
        		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
        		        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
        		        InitHeaders(headers, info);
        		        var cols = [ 
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"bkg_no"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"dcgo_seq"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cntr_tpsz_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cntr_cgo_seq"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cntr_no"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"imdg_un_no"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"imdg_clss_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"prp_shp_nm"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"emer_cntc_phn_no_ctnt"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"un_page_no"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"flsh_pnt_cdo_temp"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"point_c"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"diff_rmk"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"ems_no"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"psa_no"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"imdg_pck_grp_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"mfag"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"mrn_polut_flg"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"imdg_subs_rsk_lbl_cd1"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"out_imdg_pck_qty1"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"out_imdg_pck_cd1"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"net_wgt"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"wgt_ut_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"grs_wgt"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"wgt_ut_cd1"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"hzd_ctnt"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"imdg_subs_rsk_lbl_cd2"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"imdg_lmt_qty_flg"}
        		                    ];
        		        InitColumns(cols);
             			SetEditable(0);
             			SetSheetHeight(120);
             			SetExtendLastCol(false);
                    }
        	 	break;
        	 	
                case 7:
                    with(sheetObj){
        		        var HeadTitle="BOOKING NO|CNTR NO|SEQ|PKG QTY|PKG UNIT|WGT QTY|WGT TP|MEASURE|MEA UNIT|COMMODITY";
        		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
        		        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
        		        InitHeaders(headers, info);
        		        var cols = [ 
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"bkg_no"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cntr_no"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cntr_mf_seq"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"pck_qty"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"pck_tp_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cntr_mf_wgt"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"wgt_ut_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"meas_qty"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"meas_ut_cd"},
        		                    {Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",   	ColMerge:0,   SaveName:"cntr_mf_gds_desc"}
        		                    ];
        		        InitColumns(cols);
             			SetEditable(0);
             			SetSheetHeight(120);
             			SetExtendLastCol(false);
                    }
        	 	break;
        	 	
                case 8:
                    with(sheetObj){
        		        var HeadTitle="BOOKING NO|CNTR SEQ|CNTR TPSZ|CNTR NO|CMDT CODE|COMMODITY|TEMP|TEMP UNIT|VENT|REEFER RMK|PKG COUNT|NET WGT|GRS WGT|LENGTH|WIDTH|HEIGHT|OL FRONT|OL REAR|OW RIGHT|OW LEFT|OVER HIGH|AWK RMK";
        		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
        		        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
        		        InitHeaders(headers, info);
        		        var cols = [ 
									{Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"bkg_no"},
									{Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"cntr_seq"},
									{Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"cntr_tpsz"},
									{Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"cntr_no"},
									{Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"cmdt_code"},
									{Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"commodity"},
									{Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"cdo_temp"},
									{Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"temp_unit"},
									{Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"vent_rto"},
									{Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"diff_rmk"},
									{Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"pck_qty"},
									{Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"net_wgt"},
									{Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"grs_wgt"},
									{Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"ttl_dim_len"},
									{Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"ttl_dim_wdt"},
									{Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"ttl_dim_hgt"},
									{Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"ovr_fwrd_len"},
									{Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"ovr_bkwd_len"},
									{Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"ovr_rt_len"},
									{Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"ovr_lf_len"},
									{Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"ovr_hgt"},
									{Type:"Text",     Hidden:0,  	Width:100,   Align:"Center",  	ColMerge:0,   SaveName:"awk_rmk"}
        		                    ];
        		        InitColumns(cols);
             			SetEditable(0);
             			SetSheetHeight(120);
             			SetExtendLastCol(false);
                    }
        	 	break;
                    
            }
        }
     // handling of Sheet process
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
	            case IBSEARCH:      // retrieve
	 	            if(validateForm(sheetObj,formObj,sAction)){
	 	        	    for(i=0;i< formObj.ser_type.length;i++){ 
	 	        		    if (formObj.ser_type[i].checked){ 
	 	        			    v_ser_type=formObj.ser_type[i].value; 
	 	        		    } 
	 	        	     }
		 	        	 if(v_ser_type=="simple"){	 	        		
		 	        		 formObj.f_cmd.value=SEARCH; 
		 	        	 }else if(v_ser_type=="detail"){
		 	        		 formObj.f_cmd.value=SEARCH01;
		 	        	 }else{
		 	        		 formObj.f_cmd.value=SEARCH02; 
		 	        	 }
		 	        	 var sXml=sheetObj.DoSearch("ESM_BKG_0252GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("") );
		 	        }	  
		            break;
	            case IBDOWNEXCEL:      // insert
	            	if(sheetObj.RowCount() < 1){//no data
	            		ComShowCodeMessage("COM132501");
	            		}else{
	            			sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), HiddenColumn:-1, SheetDesign:1,Merge:1  });
	            		}
	   				break;	
	            case "FAX":   
	            	if(validateForm(sheetObj,formObj,sAction)){
	            		formObj.f_cmd.value=MULTI01;
	            		sheetObj.DoSave("ESM_BKG_0252GS.do", FormQueryString(formObj)
								 + "&" + ComGetPrefixParam(""),2,false);
	            	}
	            	break;			
	            case "EMAIL": 
	        	    if(validateForm(sheetObj,formObj,sAction)){
		        	    formObj.f_cmd.value=MULTI02;
		        	    sheetObj.DoSave("ESM_BKG_0252GS.do", FormQueryString(formObj)
								 + "&" + ComGetPrefixParam(""),2,false);
	        	    }
	        	    break;
	            case "EDI": 
	        	    if(validateForm(sheetObj,formObj,sAction)){
	        	    	formObj.f_cmd.value=MULTI03;
		 	            sheetObj.DoSave("ESM_BKG_0252GS.do", FormQueryString(formObj)
								 + "&" + ComGetPrefixParam(""),2,false);
	        	    }
	        	    break;	
	    		case "btn_EmailEdit":
	    			var arrRow=ComFindText(sheetObjects[0], "Check", 1);
	    			var bkg_no_list="";
	    			if (arrRow && 0<arrRow.length) {
	    				for (var i=0; i<arrRow.length; i++) {
	    					bkg_no_list += sheetObjects[0].GetCellValue(arrRow[i],"bkg_no")+'|';
	    				}
	    				if (0<bkg_no_list.indexOf("|")) bkg_no_list=bkg_no_list.substring(0,bkg_no_list.length-1);
	    				ComOpenWindowCenter("/opuscntr/ESM_BKG_1096.do?ui_id=ESM_BKG_0252&ntc_knd_cd=CN&bkg_no_list="+bkg_no_list, "ESM_BKG_1096", 700, 670, true);
	    			}
	    			break;
	    		case "LDFDOW":
	    			formObj.f_cmd.value = SEARCH03;
	    			ComOpenWait(true);
	    			sheetObjects[1].DoSearch("ESM_BKG_0252GS.do", FormQueryString(formObj) + "&excel_seq=1");
	    			break;
				case "btn_LdfLog":
					var param="";
			 		ComOpenPopup("ESM_BKG_0236.do" + param, 825, 550, "", "1,0", true);
					break;
            }
        }
        
        function sheet2_OnSearchEnd(sheetObj, code, message) {
        	if (fileType == "E") {
            	sheetObj.Down2Excel({ FileName : "BKG_ROOT.xlsx"});        		
        	}else{
        		sheetObj.Down2Text({ ColDelim : ",", FileName : "BKG_ROOT.csv", DownHeader:true});        		
        	}
        }
        
        function sheet2_OnDownFinish(code, message) {
        	var formObj = document.form;
        	formObj.f_cmd.value = SEARCH03;
        	sheetObjects[2].DoSearch("ESM_BKG_0252GS.do", FormQueryString(formObj) + "&excel_seq=2");
        }
        
        function sheet3_OnSearchEnd(sheetObj, code, message) {
        	if (fileType == "E") {
            	sheetObj.SetDown2ExcelUrl("/opuscntr/js/ibsheet/jsp/Down2Excel2.jsp");
            	sheetObj.Down2Excel({ FileName : "BKG_QTY.xlsx"});    
        	}else{
            	sheetObj.SetDown2TextUrl("/opuscntr/js/ibsheet/jsp/Down2Text2.jsp");
        		sheetObj.Down2Text({ ColDelim : ",", FileName : "BKG_QTY.csv", DownHeader:true});        		
        	}
        }
    	function sheet3_OnDownFinish(code, message) {
    		var formObj = document.form;
        	formObj.f_cmd.value = SEARCH03;
        	sheetObjects[3].DoSearch("ESM_BKG_0252GS.do", FormQueryString(formObj) + "&excel_seq=3");
        }
        
		function sheet4_OnSearchEnd(sheetObj, code, message) {
        	if (fileType == "E") {
    			sheetObj.SetDown2ExcelUrl("/opuscntr/js/ibsheet/jsp/Down2Excel3.jsp");
    		    sheetObj.Down2Excel({ FileName : "CNTR.xlsx"});    
        	}else{
            	sheetObj.SetDown2TextUrl("/opuscntr/js/ibsheet/jsp/Down2Text3.jsp");
        		sheetObj.Down2Text({ ColDelim : ",", FileName : "CNTR.csv", DownHeader:true});        		
        	}
		}
		function sheet4_OnDownFinish(code, message) {
			var formObj = document.form;
        	formObj.f_cmd.value = SEARCH03;
        	sheetObjects[4].DoSearch("ESM_BKG_0252GS.do", FormQueryString(formObj) + "&excel_seq=4");
		}
		
		function sheet5_OnSearchEnd(sheetObj, code, message) {
        	if (fileType == "E") {
    			sheetObj.SetDown2ExcelUrl("/opuscntr/js/ibsheet/jsp/Down2Excel4.jsp");
    		    sheetObj.Down2Excel({ FileName : "BKG_VVD.xlsx"}); 
        	}else{
            	sheetObj.SetDown2TextUrl("/opuscntr/js/ibsheet/jsp/Down2Text4.jsp");
        		sheetObj.Down2Text({ ColDelim : ",", FileName : "BKG_VVD.csv", DownHeader:true});        		
        	}
		}
		function sheet5_OnDownFinish(code, message) {
			var formObj = document.form;
        	formObj.f_cmd.value = SEARCH03;
        	sheetObjects[5].DoSearch("ESM_BKG_0252GS.do", FormQueryString(formObj) + "&excel_seq=5");
		}
		
		function sheet6_OnSearchEnd(sheetObj, code, message) {
        	if (fileType == "E") {
    			sheetObj.SetDown2ExcelUrl("/opuscntr/js/ibsheet/jsp/Down2Excel5.jsp");
    		    sheetObj.Down2Excel({ FileName : "DG.xlsx"}); 
        	}else{
            	sheetObj.SetDown2TextUrl("/opuscntr/js/ibsheet/jsp/Down2Text5.jsp");
        		sheetObj.Down2Text({ ColDelim : ",", FileName : "DG.csv", DownHeader:true});        		
        	}
		}
		function sheet6_OnDownFinish(code, message) {
			var formObj = document.form;
        	formObj.f_cmd.value = SEARCH03;
        	sheetObjects[6].DoSearch("ESM_BKG_0252GS.do", FormQueryString(formObj) + "&excel_seq=6");
		}
		function sheet7_OnSearchEnd(sheetObj, code, message) {
        	if (fileType == "E") {
    			sheetObj.SetDown2ExcelUrl("/opuscntr/js/ibsheet/jsp/Down2Excel6.jsp");
    		    sheetObj.Down2Excel({ FileName : "CM.xlsx"}); 
        	}else{
            	sheetObj.SetDown2TextUrl("/opuscntr/js/ibsheet/jsp/Down2Text6.jsp");
        		sheetObj.Down2Text({ ColDelim : ",", FileName : "CM.csv", DownHeader:true});        		
        	}
		}
		function sheet7_OnDownFinish(code, message) {
			var formObj = document.form;
        	formObj.f_cmd.value = SEARCH03;
        	sheetObjects[7].DoSearch("ESM_BKG_0252GS.do", FormQueryString(formObj) + "&excel_seq=7");
		}
		function sheet8_OnSearchEnd(sheetObj, code, message) {
        	if (fileType == "E") {
    			sheetObj.SetDown2ExcelUrl("/opuscntr/js/ibsheet/jsp/Down2Excel7.jsp");
    		    sheetObj.Down2Excel({ FileName : "RF_OOG.xlsx"}); 
        	}else{
            	sheetObj.SetDown2TextUrl("/opuscntr/js/ibsheet/jsp/Down2Text7.jsp");
        		sheetObj.Down2Text({ ColDelim : ",", FileName : "RF_OOG.csv", DownHeader:true});        		
        	}
		}
		function sheet8_OnDownFinish(code, message) {
			ComOpenWait(false);
		}
		
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
        	with(formObj){
             	switch(sAction) {
					case IBSEARCH: // retrieve
		         		if (!ComChkValid(formObj)) return false;
						if(formObj.bkg_no.value==""&&formObj.vvd.value==""&&formObj.from_dt.value==""){
							ComShowCodeMessage("BKG00738");  //please Input Date or VVD or Booking NO.
			    			return false;
						}
						if(formObj.from_dt.value!=""||formObj.vvd.value!=""){
							if(formObj.bkg_ofc_cd.value==""&&formObj.eq_ctrl_ofc_cd.value==""&&formObj.por_cd.value==""&&formObj.pol_cd.value==""&&formObj.mty_pkup_yd_cd.value==""&&formObj.full_rtn_yd_cd.value==""){
								ComShowCodeMessage("BKG00739");  //please Input BKG OFC or EQ CTL OFC or POR or POL or P/U CY or FULL RTN CY.
    			    			return false;
							}
						}
		                if (ComGetDaysBetween(formObj.from_dt.value,formObj.end_dt.value) > 31 ) {
		                    ComShowCodeMessage("BKG00756","Duration","31Days");  //{?msg1} exceeds maximum duration {?msg2}.
		                    formObj.from_dt.focus();
		                    return false;
		                }
		                if (ComGetDaysBetween(formObj.from_dt2.value,formObj.end_dt2.value) > 31 ) {
		                    ComShowCodeMessage("BKG00756","Duration","31Days");  //{?msg1} exceeds maximum duration {?msg2}.
		                    formObj.from_dt2.focus();
		                    return false;
		                }
						break;
					case "FAX":
						with(sheetObj){
							for(var i=1; i <= LastRow(); i ++){
								if (GetCellValue(i, "Check") == "1"&&GetCellValue(i, "ntc_fax_no") == ""){
									ComShowCodeMessage("BKG00365");  //Fax No is either missing or not number!
        			    			return false;
								}
							}
						}
						break;
					case "EMAIL":
						with(sheetObj){
							for(var i=1; i <= LastRow(); i ++){
								if (GetCellValue(i, "Check") == "1"){
									if(GetCellValue(i, "ntc_eml") == ""){
    									ComShowCodeMessage("BKG00366");  //E-mail Address is missiong or not correct format
            			    			return false;
									}else{
										  reg=new RegExp("^[\\w\\-]+(\\.[\\w\\-_]+)*@[\\w\\-]+(\\.[\\w\\-]+)*(\\.[a-zA-Z]{2,3})$", "gi");
										  if (!reg.test(GetCellValue(i, "ntc_eml"))){
											  ComShowCodeMessage("BKG00366");  //E-mail Address is missiong or not correct format
											  return false;
										  }
									}
								}
							}
						}
						break;
					case "btn_EmailEdit":
						if (sheetObj.RowCount()== 0) {
							ComShowCodeMessage("BKG00155");
							return false;
						}
						if (sheetObj.CheckedRows("Check") == 0) {
							ComShowCodeMessage("BKG00155");
							return false;
						}
						break;
             	}	
             }
             return true;
        }
        function sheet1_OnMouseMove(sheetObj,Button, Shift, X, Y){	
        	//tooltip Msg
            if (sheetObj.ColSaveName(sheetObj.MouseCol())=="fax_snd_rslt_cd"){
            //no support[check again]CLT 	sheetObj.MouseToolTipText=sheetObj.GetCellText(sheetObj.MouseRow(),"fax_snd_rslt_nm");
            }else if(sheetObj.ColSaveName(sheetObj.MouseCol())=="eml_snd_rslt_cd"){
            //no support[check again]CLT 	sheetObj.MouseToolTipText=sheetObj.GetCellText(sheetObj.MouseRow(),"eml_snd_rslt_nm");
            }else{
            //no support[check again]CLT 	sheetObj.MouseToolTipText=sheetObj.GetCellText(sheetObj.MouseRow(),sheetObj.MouseCol());
            }
        }
        // mouse click event
        function sheet1_OnMouseDown(Button, Shift, X, Y) {
        	var sheetObj=sheetObjects[0];
        	var m_row=sheetObj.MouseRow();
        	var m_col=sheetObj.MouseCol();
        	try {
        		//Booking NO.
        		if (m_row > 0 && m_col == 3 && sheetObj.GetCellValue(m_row, m_col).length > 1) {
//        			ComOpenWindow("ESM_BKG_0079.do?pgmNo=ESM_BKG_0079&bkg_no="+sheetObj.CellValue(m_row, m_col), "ESM_BKG_0079", "width=1024,height=768", false);
        			comBkgCallPopBkgDetail(sheetObj.GetCellValue(m_row, m_col));
        		}
        	} catch (ex) {
        		bkg_error_alert(ex);
        		return false;
        	}
        }
        function getCOM_Fax_Email_POPUP(rowArray) {
        	if (rowArray && 0<rowArray.length ) {
    	    	var faxno=rowArray[0].fax;
    	        var email=rowArray[0].email;
    	    	var sheetObject=sheetObjects[0];
    			var arrRow=sheetObject.FindCheckedRow("Check").split("|");
    			if (arrRow && 0<arrRow.length) {
    				for (var i=0; i<arrRow.length; i++) {
     					sheetObject.SetCellValue(arrRow[i],"ntc_fax_no",faxno,0);
     					sheetObject.SetCellValue(arrRow[i],"ntc_eml",email,0);
    				}
    			}
        	}
        }
        //save complete Event
        function sheet1_OnSaveEnd(sheetObj, ErrMsg){
        	with(sheetObj) {
        		for(i=0;i< document.form.ser_type.length;i++){ 
 	        		if (document.form.ser_type[i].checked){ 
 	        			v_ser_type=document.form.ser_type[i].value; 
 	        		} 
 	        	}
    			if ("usa"==v_ser_type) {
    				for (var i=1; i<=LastRow(); i++) {
    					if ("1"!=GetCellValue(i,"col_chk")) {
	        				for (var j=1; j<=14; j++) {
		            			SetCellValue(i, j,"",0);
		            			SetCellBackColor(i, j-1,"#FFFFFF");
	        				}
	            		}
	    			}
				}
	    	}
			ComSetObjValue(document.form.elements["edt_ntc_knd_cd" ],"");
			ComSetObjValue(document.form.elements["edt_bkg_no_list"],"");
			ComSetObjValue(document.form.elements["edt_to_eml"     ],"");
			ComSetObjValue(document.form.elements["edt_cc_eml"     ],"");
			ComSetObjValue(document.form.elements["edt_from_eml"   ],"");
			ComSetObjValue(document.form.elements["edt_subject"    ],"");
			ComSetObjValue(document.form.elements["edt_contents"   ],"");
        }
        // retrieve complete Event
        function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        	var cnt=0;
        	var rownum=1;
        	with(sheetObj)
        	{
        		if (0==RowCount()) {
        			ComBtnDisable("btn_CheckAll");
        			ComBtnDisable("btn_UncheckAll");
        			ComBtnDisable("btn_Print");
        			ComBtnDisable("btn_Preview");
        			ComBtnDisable("btn_EditFAXEmail");
        			ComBtnDisable("btn_FAX");
        			ComBtnDisable("btn_EMail");
        			ComBtnDisable("btn_EDI");
        			ComBtnDisable("btn_Remark");
        			ComBtnDisable("btn_EmailEdit");
        		} else {
        			ComBtnEnable("btn_CheckAll");
	        		ComBtnEnable("btn_UncheckAll");
	        		ComBtnEnable("btn_Print");
	        		ComBtnEnable("btn_Preview");
	        		ComBtnEnable("btn_EditFAXEmail");
	        		ComBtnEnable("btn_FAX");
	        		ComBtnEnable("btn_EMail");
	        		ComBtnEnable("btn_EDI");
	        		ComBtnEnable("btn_Remark");
	        		ComBtnEnable("btn_EmailEdit");
        		}
        		for(i=0;i< document.form.ser_type.length;i++){ 
 	        		if (document.form.ser_type[i].checked){ 
 	        			v_ser_type=document.form.ser_type[i].value; 
 	        		} 
 	        	}
    			if (RowCount()== 0) return;;
    			var bef_yard_type="";
    			var bef_bkg_no="";
        		for(var i=1; i <= LastRow(); i ++){
        			if(v_ser_type=="usa"){
        				InitCellProperty(i, "Check",{ Type:"DummyCheck",Align:"Center"} );
        				if (GetCellValue(i, "col_chk") == "1"){
	        				SetCellValue(i, "Seq",rownum,0);
	        				rownum++;
	        			}else{
	        				if(GetCellValue(i, "yard_type")==bef_yard_type&&GetCellValue(i, "bkg_no")==bef_bkg_no){
	        					SetRowHidden(i,1 );
		            		}
	        				bef_yard_type=GetCellValue(i, "yard_type");
	        				bef_bkg_no=GetCellValue(i, "bkg_no");
	        				for(var j=1; j <= 14; j ++){
		            			SetCellValue(i, j,"",0);
		            			SetCellBackColor(i, j-1,"#FFFFFF");
		            		}
		            		SetRowMerge(i,1);
	        			}
        			}else{
        				InitCellProperty(i, "Check",{ Type:"DummyCheck",Align:"Center"} );
        				SetCellValue(i, "Seq",rownum,0);
        				rownum++;
        			}
					cnt=0 ;
				}
        	}
        	with (sheetObj) {
        		var color1="#810081";
        		SetColFontUnderline("bkg_no",1);
        		SetDataLinkMouse("bkg_no",1);
        		SetColFontColor("bkg_no",color1);
        	}
        }
    	function CheckGrid(sheetObject,prefix){
    		var iCheckRow=sheetObject.FindCheckedRow("Check");
    		if (iCheckRow== "") {
    			ComShowCodeMessage("BKG00249");
    			return false;
    		}
			if (50<sheetObject.CheckedRows("Check")) {
				ComShowCodeMessage("BKG08124",50);  //You select more than {?msg1} B/Ls for B/L print. Max is {?msg1} B/Ls one time
				return false;
			}
    		return true;
    	}
    	function chkSerType(serType){
    		sheetObjects[0].RemoveAll();
    		sheetObjects[0].RenderSheet(0);
        	if ("simple"==serType.value) {
        		sheetObjects[0].SetColHidden("Seq"            ,0);
        		sheetObjects[0].SetColHidden("Check"          ,0);
        		sheetObjects[0].SetColHidden("bkg_no"         ,0);
        		sheetObjects[0].SetColHidden("bkg_sts_cd"     ,1);
        		sheetObjects[0].SetColHidden("rcv_term_cd"    ,0);
        		sheetObjects[0].SetColHidden("de_term_cd"     ,0);
        		sheetObjects[0].SetColHidden("cntr_qty"       ,0);
        		sheetObjects[0].SetColHidden("flex_hgt_flg"   ,0);
        		sheetObjects[0].SetColHidden("por_cd"         ,0);
        		sheetObjects[0].SetColHidden("pol_cd"         ,0);
        		sheetObjects[0].SetColHidden("eq_ctrl_ofc_cd" ,1);
        		sheetObjects[0].SetColHidden("scc_cd"         ,0);
        		sheetObjects[0].SetColHidden("mty_pkup_yd_cd" ,0);
        		sheetObjects[0].SetColHidden("cy_name"        ,0);
        		sheetObjects[0].SetColHidden("ntc_fax_no"     ,0);
        		sheetObjects[0].SetColHidden("ntc_eml"        ,0);
        		sheetObjects[0].SetColHidden("mty_pkup_dt"    ,0);
        		sheetObjects[0].SetColHidden("vvd"            ,0);
        		sheetObjects[0].SetColHidden("tvvd"           ,1);
        		sheetObjects[0].SetColHidden("vvd_name"       ,0);
        		sheetObjects[0].SetColHidden("full_rtn_yd_cd" ,0);
        		sheetObjects[0].SetColHidden("cust_nm"        ,0);
        		sheetObjects[0].SetColHidden("cmdt_cd"        ,0);
        		sheetObjects[0].SetColHidden("cmdt_nm"        ,0);
        		sheetObjects[0].SetColHidden("lodg_due_dt"    ,1);
        		sheetObjects[0].SetColHidden("ip"             ,1);
        		sheetObjects[0].SetColHidden("yard_type"      ,1);
        		sheetObjects[0].SetColHidden("yard"           ,1);
        		sheetObjects[0].SetColHidden("edi_id"         ,1);
        		sheetObjects[0].SetColHidden("edi_snd_dt"     ,1);
        		sheetObjects[0].SetColHidden("fax_snd_dt"     ,1);
        		sheetObjects[0].SetColHidden("fax_snd_rslt_cd",1);
        		sheetObjects[0].SetColHidden("eml_snd_dt"     ,1);
        		sheetObjects[0].SetColHidden("eml_snd_rslt_cd",1);
        		sheetObjects[0].SetColHidden("xter_rmk"       ,0);
        		sheetObjects[0].SetColHidden("diff_rmk"       ,0);
        		sheetObjects[0].MoveColumnPos("Seq"            ,1 ,false);
        		sheetObjects[0].MoveColumnPos("Check"          ,2 ,false);
        		sheetObjects[0].MoveColumnPos("bkg_no"         ,3 ,false);
        		sheetObjects[0].MoveColumnPos("bkg_sts_cd"     ,4 ,false);
        		sheetObjects[0].MoveColumnPos("rcv_term_cd"    ,5 ,false);
        		sheetObjects[0].MoveColumnPos("de_term_cd"     ,6 ,false);
        		sheetObjects[0].MoveColumnPos("cntr_qty"       ,7 ,false);
        		sheetObjects[0].MoveColumnPos("flex_hgt_flg"   ,8 ,false);
                sheetObjects[0].MoveColumnPos("por_cd"         ,9 ,false);
                sheetObjects[0].MoveColumnPos("pol_cd"         ,10,false);
                sheetObjects[0].MoveColumnPos("scc_cd"         ,11,false);
                sheetObjects[0].MoveColumnPos("mty_pkup_yd_cd" ,12,false);
                sheetObjects[0].MoveColumnPos("cy_name"        ,13,false);
                sheetObjects[0].MoveColumnPos("ntc_fax_no"     ,14,false);
                sheetObjects[0].MoveColumnPos("ntc_eml"        ,15,false);
                sheetObjects[0].MoveColumnPos("mty_pkup_dt"    ,16,false);
                sheetObjects[0].MoveColumnPos("vvd"            ,17,false);
                sheetObjects[0].MoveColumnPos("vvd_name"       ,18,false);
                sheetObjects[0].MoveColumnPos("full_rtn_yd_cd" ,19,false);
                sheetObjects[0].MoveColumnPos("cust_nm"        ,20,false);
                sheetObjects[0].MoveColumnPos("cmdt_cd"        ,21,false);
                sheetObjects[0].MoveColumnPos("cmdt_nm"        ,22,false);
        		sheetObjects[0].MoveColumnPos("xter_rmk"       ,23,false);
        		sheetObjects[0].MoveColumnPos("diff_rmk"       ,24,false);
			} else if("detail"==serType.value) {
				sheetObjects[0].SetColHidden("Seq"            ,0);
				sheetObjects[0].SetColHidden("Check"          ,0);
				sheetObjects[0].SetColHidden("bkg_no"         ,0);
				sheetObjects[0].SetColHidden("bkg_sts_cd"     ,1);
				sheetObjects[0].SetColHidden("rcv_term_cd"    ,0);
				sheetObjects[0].SetColHidden("de_term_cd"     ,0);
				sheetObjects[0].SetColHidden("cntr_qty"       ,0);
        		sheetObjects[0].SetColHidden("flex_hgt_flg"   ,0);
				sheetObjects[0].SetColHidden("por_cd"         ,0);
				sheetObjects[0].SetColHidden("pol_cd"         ,0);
				sheetObjects[0].SetColHidden("eq_ctrl_ofc_cd" ,0);
				sheetObjects[0].SetColHidden("scc_cd"         ,0);
				sheetObjects[0].SetColHidden("mty_pkup_yd_cd" ,0);
				sheetObjects[0].SetColHidden("cy_name"        ,1);
				sheetObjects[0].SetColHidden("ntc_fax_no"     ,0);
				sheetObjects[0].SetColHidden("ntc_eml"        ,0);
				sheetObjects[0].SetColHidden("mty_pkup_dt"    ,0);
				sheetObjects[0].SetColHidden("vvd"            ,0);
				sheetObjects[0].SetColHidden("tvvd"           ,1);
				sheetObjects[0].SetColHidden("vvd_name"       ,1);
				sheetObjects[0].SetColHidden("full_rtn_yd_cd" ,0);
				sheetObjects[0].SetColHidden("cust_nm"        ,1);
				sheetObjects[0].SetColHidden("cmdt_cd"        ,1);
				sheetObjects[0].SetColHidden("cmdt_nm"        ,1);
				sheetObjects[0].SetColHidden("lodg_due_dt"    ,1);
				sheetObjects[0].SetColHidden("ip"             ,1);
				sheetObjects[0].SetColHidden("yard_type"      ,1);
				sheetObjects[0].SetColHidden("yard"           ,1);
				sheetObjects[0].SetColHidden("edi_id"         ,0);
				sheetObjects[0].SetColHidden("edi_snd_dt"     ,0);
				sheetObjects[0].SetColHidden("fax_snd_dt"     ,0);
				sheetObjects[0].SetColHidden("fax_snd_rslt_cd",0);
				sheetObjects[0].SetColHidden("eml_snd_dt"     ,0);
				sheetObjects[0].SetColHidden("eml_snd_rslt_cd",0);
				sheetObjects[0].SetColHidden("xter_rmk"       ,0);
				sheetObjects[0].SetColHidden("diff_rmk"       ,0);
				sheetObjects[0].MoveColumnPos("Seq"            ,1 ,false);
				sheetObjects[0].MoveColumnPos("Check"          ,2 ,false);
				sheetObjects[0].MoveColumnPos("bkg_no"         ,3 ,false);
				sheetObjects[0].MoveColumnPos("bkg_sts_cd"     ,4 ,false);
				sheetObjects[0].MoveColumnPos("rcv_term_cd"    ,5 ,false);
				sheetObjects[0].MoveColumnPos("de_term_cd"     ,6 ,false);
				sheetObjects[0].MoveColumnPos("cntr_qty"       ,7 ,false);
        		sheetObjects[0].MoveColumnPos("flex_hgt_flg"   ,8 ,false);
				sheetObjects[0].MoveColumnPos("por_cd"         ,9 ,false);
				sheetObjects[0].MoveColumnPos("pol_cd"         ,10,false);
				sheetObjects[0].MoveColumnPos("eq_ctrl_ofc_cd" ,11,false);
				sheetObjects[0].MoveColumnPos("scc_cd"         ,12,false);
				sheetObjects[0].MoveColumnPos("mty_pkup_yd_cd" ,13,false);
				sheetObjects[0].MoveColumnPos("mty_pkup_dt"    ,14,false);
				sheetObjects[0].MoveColumnPos("vvd"            ,15,false);
				sheetObjects[0].MoveColumnPos("full_rtn_yd_cd" ,16,false);
				sheetObjects[0].MoveColumnPos("edi_id"         ,17,false);
				sheetObjects[0].MoveColumnPos("edi_snd_dt"     ,18,false);
				sheetObjects[0].MoveColumnPos("ntc_fax_no"     ,19,false);
				sheetObjects[0].MoveColumnPos("fax_snd_dt"     ,20,false);
				sheetObjects[0].MoveColumnPos("fax_snd_rslt_cd",21,false);
				sheetObjects[0].MoveColumnPos("ntc_eml"        ,22,false);
				sheetObjects[0].MoveColumnPos("eml_snd_dt"     ,23,false);
				sheetObjects[0].MoveColumnPos("eml_snd_rslt_cd",24,false);
				sheetObjects[0].MoveColumnPos("xter_rmk"       ,25,false);
				sheetObjects[0].MoveColumnPos("diff_rmk"       ,26,false);
			} else {
				sheetObjects[0].SetColHidden("Seq"            ,0);
				sheetObjects[0].SetColHidden("Check"          ,0);
				sheetObjects[0].SetColHidden("bkg_no"         ,0);
				sheetObjects[0].SetColHidden("bkg_sts_cd"     ,1);
				sheetObjects[0].SetColHidden("rcv_term_cd"    ,0);
				sheetObjects[0].SetColHidden("de_term_cd"     ,0);
				sheetObjects[0].SetColHidden("cntr_qty"       ,1);
        		sheetObjects[0].SetColHidden("flex_hgt_flg"   ,1);
				sheetObjects[0].SetColHidden("por_cd"         ,0);
				sheetObjects[0].SetColHidden("pol_cd"         ,0);
				sheetObjects[0].SetColHidden("eq_ctrl_ofc_cd" ,0);
				sheetObjects[0].SetColHidden("scc_cd"         ,0);
				sheetObjects[0].SetColHidden("mty_pkup_yd_cd" ,1);
				sheetObjects[0].SetColHidden("cy_name"        ,1);
				sheetObjects[0].SetColHidden("ntc_fax_no"     ,0);
				sheetObjects[0].SetColHidden("ntc_eml"        ,0);
				sheetObjects[0].SetColHidden("mty_pkup_dt"    ,0);
				sheetObjects[0].SetColHidden("vvd"            ,1);
				sheetObjects[0].SetColHidden("tvvd"           ,0);
				sheetObjects[0].SetColHidden("vvd_name"       ,1);
				sheetObjects[0].SetColHidden("full_rtn_yd_cd" ,1);
				sheetObjects[0].SetColHidden("cust_nm"        ,1);
				sheetObjects[0].SetColHidden("cmdt_cd"        ,1);
				sheetObjects[0].SetColHidden("cmdt_nm"        ,1);
				sheetObjects[0].SetColHidden("lodg_due_dt"    ,0);
				sheetObjects[0].SetColHidden("ip"             ,0);
				sheetObjects[0].SetColHidden("yard_type"      ,0);
				sheetObjects[0].SetColHidden("yard"           ,0);
				sheetObjects[0].SetColHidden("edi_id"         ,0);
				sheetObjects[0].SetColHidden("edi_snd_dt"     ,0);
				sheetObjects[0].SetColHidden("fax_snd_dt"     ,0);
				sheetObjects[0].SetColHidden("fax_snd_rslt_cd",0);
				sheetObjects[0].SetColHidden("eml_snd_dt"     ,0);
				sheetObjects[0].SetColHidden("eml_snd_rslt_cd",0);
				sheetObjects[0].SetColHidden("xter_rmk"       ,1);
				sheetObjects[0].SetColHidden("diff_rmk"       ,0);
				sheetObjects[0].MoveColumnPos("Seq"            ,1 ,false);
				sheetObjects[0].MoveColumnPos("Check"          ,2 ,false);
				sheetObjects[0].MoveColumnPos("bkg_no"         ,3 ,false);
				sheetObjects[0].MoveColumnPos("bkg_sts_cd"     ,4 ,false);
				sheetObjects[0].MoveColumnPos("rcv_term_cd"    ,5 ,false);
				sheetObjects[0].MoveColumnPos("de_term_cd"     ,6 ,false);
				sheetObjects[0].MoveColumnPos("eq_ctrl_ofc_cd" ,7 ,false);
				sheetObjects[0].MoveColumnPos("scc_cd"         ,8 ,false);
				sheetObjects[0].MoveColumnPos("tvvd"           ,9 ,false);
				sheetObjects[0].MoveColumnPos("por_cd"         ,10,false);
				sheetObjects[0].MoveColumnPos("mty_pkup_dt"    ,11,false);
				sheetObjects[0].MoveColumnPos("pol_cd"         ,12,false);
				sheetObjects[0].MoveColumnPos("lodg_due_dt"    ,13,false);
				sheetObjects[0].MoveColumnPos("ip"             ,14,false);
				sheetObjects[0].MoveColumnPos("yard_type"      ,15,false);
				sheetObjects[0].MoveColumnPos("yard"           ,16,false);
				sheetObjects[0].MoveColumnPos("edi_id"         ,17,false);
				sheetObjects[0].MoveColumnPos("edi_snd_dt"     ,18,false);
				sheetObjects[0].MoveColumnPos("ntc_fax_no"     ,19,false);
				sheetObjects[0].MoveColumnPos("fax_snd_dt"     ,20,false);
				sheetObjects[0].MoveColumnPos("fax_snd_rslt_cd",21,false);
				sheetObjects[0].MoveColumnPos("ntc_eml"        ,22,false);
				sheetObjects[0].MoveColumnPos("eml_snd_dt"     ,23,false);
				sheetObjects[0].MoveColumnPos("eml_snd_rslt_cd",24,false);
				sheetObjects[0].MoveColumnPos("diff_rmk"       ,25,false);
			}
        	sheetObjects[0].RenderSheet(1);
    		if(serType.value=="usa"){
    			document.form.pi_type.disabled=false;
    			document.form.from_dt2.disabled=false;
    			document.form.end_dt2.disabled=false;
    			document.form.empty_full_chk.disabled=false;
    			ComEnableObject(document.form.btns_calendar2,true);
    			document.form.pi_type.className="input";
    			document.form.from_dt2.className="input";
    			document.form.end_dt2.className="input";			
    		}else{
    			document.form.pi_type.disabled=true;
    			document.form.from_dt2.disabled=true;
    			document.form.end_dt2.disabled=true;
    			document.form.empty_full_chk.disabled=true;
    			ComEnableObject(document.form.btns_calendar2,false);
    			document.form.pi_type.className="input2";
    			document.form.from_dt2.className="input2";
    			document.form.end_dt2.className="input2";		
    		}
    	}
    	
    	/**;
    	 * 
    	 * @param viewType
    	 * @returns {Array}
    	 */
    	function getRdData(viewType){
    		var ret = rdOpenCommon(document.form, sheetObjects[0]);
    		var rdData = [];
    		rdData.push({'rdParam' : ret[2], 'rdUrl' : ret[0], 'rdFile' : ret[1], 'width' : 800, 'height' : 600});
    		rdData.push(viewType);
    		return rdData;
    	}
    	
    	function makeRdParam(formObject, sheetObject){
    		var iCheckRow=sheetObject.FindCheckedRow("Check");
    		var strBkgNo="";
    		var strRemark="";
    		var strType="";
    		var strIsEncode="";
    		var strUsrId="";
    		var rdParam="";
    		var arrRow=iCheckRow.split("|");
    		for(var i=0;i< formObject.ser_type.length;i++){ 
        		if (formObject.ser_type[i].checked){ 
        			v_ser_type=formObject.ser_type[i].value; 
        		} 
        	}
    		if ("simple"==v_ser_type) {
    			for (var idx=0; idx<arrRow.length; idx++) {
    				strBkgNo += "'" + sheetObject.GetCellValue(arrRow[idx], "bkg_no") + "',";
    				strRemark += sheetObject.GetCellValue(arrRow[idx], "diff_rmk") + "@@";
        		}
    			strRemark=encodeRemark(strRemark);
        		strBkgNo=" bkg_no[( " + strBkgNo.substring(0, eval(strBkgNo.lengthByte()) - 1) + " )] ";
        		strRemark=" remark[" + strRemark + " ] ";
        		strUsrId=" usr_id[" + formObject.usr_id.value + "] ";  
        		strType=" type[simple] ";
        		strIsEncode=" isEncode[Y] ";
        		rdParam=" /rv "+ strBkgNo + strRemark + strUsrId + strType + strIsEncode;
        		for (var idx=0; idx<arrRow.length; idx++) {
        			sheetObject.SetCellValue(arrRow[idx], "tmpl_param",rdParam,0);
        		}
    		} else {
    			//check row loop
    			for (var idx=0; idx<arrRow.length; idx++) {
    				//exist bkg_no 
    				if (""!=sheetObject.GetCellValue(arrRow[idx], "bkg_no")) {
    					if (0 > strBkgNo.indexOf(sheetObject.GetCellValue(arrRow[idx], "bkg_no"))) {
    						strBkgNo=" bkg_no[(  '" + sheetObject.GetCellValue(arrRow[idx], "bkg_no") + "' )] ";
    						strRemark=" remark[" + encodeRemark(sheetObject.GetCellValue(arrRow[idx], "diff_rmk") + "@@") + " ] ";
		    	    		strUsrId=" usr_id[" + formObject.usr_id.value + "] ";
		    	    		strType=" type[detail] ";
		    	    		strIsEncode=" isEncode[Y] ";
		    	    		rdParam=" /rv "+ strBkgNo + strRemark + strUsrId + strType + strIsEncode;
		    	    		sheetObject.SetCellValue(arrRow[idx], "tmpl_param",rdParam,0);
    					}
    				//no exist bkg_no
    				} else {
    					for (var ii=arrRow[idx]-1; ii>0; ii--) {
    						if (""!=sheetObject.GetCellValue(ii, "bkg_no")) {
    							strBkgNo=" bkg_no[(  '" + sheetObject.GetCellValue(ii, "bkg_no") + "' )] ";
    							strRemark=" remark[" + encodeRemark(sheetObject.GetCellValue(ii, "diff_rmk") + "@@") + " ] ";
			    	    		strUsrId=" usr_id[" + formObject.usr_id.value + "] ";
			    	    		strType=" type[detail] ";
			    	    		strIsEncode=" isEncode[Y] ";
			    	    		rdParam=" /rv "+ strBkgNo + strRemark + strUsrId + strType + strIsEncode;
			    	    		sheetObject.SetCellValue(arrRow[idx], "tmpl_param",rdParam,0);
			    	    		sheetObject.SetCellValue(arrRow[idx], "bkg_no",sheetObject.GetCellValue(ii, "bkg_no"),0);
								break;
    						}
    					}
    				}
        		}
    		}
    	}
    function setRemark(remark) {
    	var sheetObject=sheetObjects[0];
		var arrRow=sheetObject.FindCheckedRow("Check").split("|");
		if (arrRow && 0<arrRow.length) {
			for (var i=0; i<arrRow.length; i++) {
				sheetObject.SetCellValue(arrRow[i],"diff_rmk",remark,0);
			}
		}
    }

    function rdOpenCommon() {
    	var formObject = document.form;
    	var sheetObject = sheetObjects[0];
		var iCheckRow = sheetObject.FindCheckedRow("Check");
		var strBkgNo = "";
		var strRemark = "";
		var strType = "";
		var strUsrId = "";
		var strIsEncode = "";
		var arrRow = iCheckRow.split("|");
		for (var idx=0; idx<arrRow.length; idx++) {
			if (""!=sheetObject.GetCellValue(arrRow[idx], "bkg_no")) {
				if (0 > strBkgNo.indexOf(sheetObject.GetCellValue(arrRow[idx], "bkg_no"))) {
					strBkgNo += "'" + sheetObject.GetCellValue(arrRow[idx], "bkg_no") + "',";
					strRemark += sheetObject.GetCellValue(arrRow[idx], "diff_rmk") + "@@";
				}
			} else {
				for (var ii=arrRow[idx]; ii>0; ii--) {
					if (""!=sheetObject.GetCellValue(ii, "bkg_no")) {
						if (0 > strBkgNo.indexOf(sheetObject.GetCellValue(ii, "bkg_no"))) {
							strBkgNo += "'" + sheetObject.GetCellValue(ii, "bkg_no") + "',";
							strRemark += sheetObject.GetCellValue(ii, "diff_rmk") + "@@";
						}
						break;
					}
				}
			}
		}
		strBkgNo=" bkg_no[( " + strBkgNo.substring(0, eval(strBkgNo.lengthByte()) - 1) + " )] ";
		strRemark=" remark[" + encodeRemark(strRemark) + " ] ";
		strUsrId=" usr_id[" + formObject.usr_id.value + "] ";
		strIsEncode=" isEncode[Y] ";
		for(var i=0;i< formObject.ser_type.length;i++){ 
			if (formObject.ser_type[i].checked){ 
				v_ser_type=formObject.ser_type[i].value; 
			} 
		}
		if(v_ser_type=='simple'){
			strType="type[simple]";
		}else{
			strType="type[detail]";
		}
		var rdParam = "/rv "+ strBkgNo + strRemark + strUsrId + strType + strIsEncode;
		var strPath = "apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/emptyreleaseorder/report/";
		var mrdFile = "ESM_BKG_0861.mrd";
		return [strPath, mrdFile, rdParam];
    }
    function backupHhmm(formObject) {
    	if (!ComIsEmpty(formObject.from_dt)) {
    		from_hm=formObject.from_dt.value.split(" ")[1];
    	}
    	if (!ComIsEmpty(formObject.end_dt)) {
    		to_hm=formObject.end_dt.value.split(" ")[1];
    	}
    }
    function restoreHhmm() {
        var formObject=document.form;
        formObject.from_dt.value=formObject.from_dt.value.split(" ")[0]+" "+from_hm;
        formObject.end_dt.value=formObject.end_dt.value.split(" ")[0]+" "+to_hm;
	}
	function encodeRemark(remark) {
		return encodeURIComponent(remark).replace(/'/g,"''");
	}
