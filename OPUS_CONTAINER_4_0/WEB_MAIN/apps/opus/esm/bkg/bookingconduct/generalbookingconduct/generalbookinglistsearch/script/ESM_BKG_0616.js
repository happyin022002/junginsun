/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0616.jsp
*@FileTitle  : Booking EDI Transmit to Terminal 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

//global variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event  */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
    	/***** using extra sheet valuable if there are more 2 sheets *****/
	    var sheetObject1=sheetObjects[0];
	    var sheetObject2=sheetObjects[1];
         /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
    		var sheetObject=null;
    		if (formObject.search_type[0].checked) {
    			sheetObject=sheetObjects[0];
    		} else {
    			sheetObject=sheetObjects[1];
    		}
            switch(srcName) {
			case "btn2_BatchEDI":
				doActionIBSheet(sheetObject,document.form,"btn2_BatchEDI");
				break;
			case "btn2_EDITransmit":
				//alert("brac_cd:"+ComGetObjValue(formObject.brac_cd));
				if(!validateForm(sheetObject,formObject,"btn2_EDITransmit")) {
					return false;
				}
				doActionIBSheet(sheetObject,document.form,"btn2_EDITransmit");
				break;
			case "btn2_CheckAll":
				if (sheetObject.RowCount()== 0) {
					ComShowMessage(msgs['BKG00155']);
					return false;
				}
				sheetObject.CheckAll(1,1);
				break;
			case "btn2_UncheckAll":
				if (sheetObject.RowCount()== 0) {
					ComShowMessage(msgs['BKG00155']);
					return false;
				}
				sheetObject.CheckAll(1,0);
				break;
			case "btn2_Save":
				doActionIBSheet(sheetObject,document.form,IBSAVE);
				break;
			case "btn1_retrieve":
				doActionIBSheet(sheetObject,document.form,IBSEARCH);
				break;
			case "btn1_new":
				doActionIBSheet(sheetObject,document.form,IBCLEAR);
				ComClearObject(formObject.bkg_from_dt);
				ComClearObject(formObject.bkg_to_dt);
				break;
			case "btn1_DownExcel":
				doActionIBSheet(sheetObject,document.form,IBDOWNEXCEL);
				break;
			case "btns_calendar":
				var cal=new ComCalendarFromTo();
				cal.select(formObject.bkg_from_dt, formObject.bkg_to_dt,'yyyy-MM-dd');
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
     * @param sheet_obj IBSheet Object
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
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }
     /**
      * init control
      */
 	function initControl() {
 		var formObject=document.form;
//// 		axon_event.addListenerFormat('keydown',	'obj_keydown', formObject); //- Key down
//// 		axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); //- Key press
// 		axon_event.addListenerForm  ('beforedeactivate', 'bkg0616_obj_deactivate', formObject); //- blur focus
// 		axon_event.addListenerFormat('beforeactivate', 'bkg0616_activate', formObject); //- on focus
 		axon_event.addListenerForm	('blur', 'form1_blur', formObject);
 	}
 	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     * @param sheetObj sheet Object
     * @param sheetNo 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
        case 'sheet1':      //sheet1 init
            with(sheetObj){
          //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		          var HeadTitle1="|Sel|Seq.|Booking No.|ST|F/M|First VVD|ETB|Lane|POL|POL|FWDR CD|Voyage|CRN|UVI|BKG Date|BKG Staff|EDI Send Date|EDI Send ID|ACK|ACK Receive|Slot No|";
		          var headCount=ComCountHeadTitle(HeadTitle1);
		//          (headCount, 0, 0, true);
		
		          SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:5, Page:20, DataRowMerge:1, FrozelCol: 4 } );
		
		          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ 
		                 {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"slct_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"f_m",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"first_vvd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"etb",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lane",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"my_fwrd_ref_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"my_fwrd_vsl_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
		                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"crn",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"uvi",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bkg_date",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_staff",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"send_date",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"send_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ack",          	   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ack_date",     	   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_slt_no_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"bkg_staff_nm" }
	                     ];
		           
		          InitColumns(cols);
		          SetSheetHeight(420);
		          Editable=true;
		                //conversion of function[check again]CLT InitDataValid(0, "my_fwrd_ref_cd", vtEngUpOther, "1234567890 ");
		          //conversion of function[check again]CLT InitDataValid(0, "my_fwrd_vsl_desc", vtEngUpOther, "1234567890 ");
		        }
                break;
    
            case 'sheet2':      //sheet2 init
                with(sheetObj){
                
	              //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		              var HeadTitle1="|CHK|Seq|Booking No.|ST|F/M|FH|SP|T/VVD|VVD History|ETB|Lane|POL|POL|BKG Date|ACK|EDI Send Date|ACK Receive|EDI Send ID|Terminal Error Message|";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		           //   (headCount, 0, 0, true);
		
		              SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:5, Page:20, DataRowMerge:1, FrozelCol: 4} );
		
		              var info    = { Sort:1, ColMove:1, MergeSheet:5, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ 
		                     {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"slct_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"f_m",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"f_h",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sp",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"t_vvd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_history",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"etb",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lane",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_date",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ack",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"send_date",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ack_date",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"send_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"tml_err_msg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"send_usr_nm" } ];
		               
		              InitColumns(cols);
		              Editable=true;
		              SetVisible(0);
		           }
		           break;
    }

    }
    /**
     * Sheet process handling
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
		case IBCLEAR:      //Init
			ComClearObject(formObj.bkg_from_dt);
			ComClearObject(formObj.bkg_to_dt);
			ComClearObject(formObj.vvd);
			ComClearObject(formObj.pol_cd);
			ComClearObject(formObj.bkg_ofc_cd);
			ComClearObject(formObj.slan_cd);
			ComClearObject(formObj.bkg_no);
			ComClearObject(formObj.bkg_staff);
			ComClearObject(formObj.bkg_sts_cd);
			ComClearObject(formObj.edi_send_sts_cd);
			ComClearObject(formObj.ack);
			sheetObjects[0].SetColHidden("my_fwrd_ref_cd",1);
			sheetObjects[0].SetColHidden("my_fwrd_vsl_desc",1);
			sheetObjects[0].SetColHidden("crn",1);
			sheetObjects[0].SetColHidden("uvi",1);
			ComBtnDisable("btn2_Save");
			// Setting Grid Condition by User Location
			if (formObj.usr_cnt_cd.value == "US" || formObj.usr_cnt_cd.value == "CA") {
				formObj.search_type[1].checked=true;
			} else {
				formObj.search_type[0].checked=true;
			}
			clickSearchType();
		//	formObj.brac_cd.selectedIndex=1;
			formObj.bkg_from_dt.value=ComGetNowInfo();
			formObj.bkg_to_dt.value=ComGetNowInfo();
			sheetObj.RemoveAll();
		break;
		case IBSEARCH:      // Retrieve
			if(!validateForm(sheetObj,formObj,sAction)) {
				return false;
			}
			ComClearSeparator(formObj.bkg_from_dt);
			ComAddSeparator(formObj.bkg_from_dt);
			ComClearSeparator(formObj.bkg_to_dt);
			ComAddSeparator(formObj.bkg_to_dt);
			if (formObj.search_type[0].checked) {
	        	formObj.f_cmd.value=SEARCH;
	        	if ( formObj.pol_cd.value == "MYPGU" ) {
					sheetObj.SetColHidden("my_fwrd_ref_cd",0);
					sheetObj.SetColHidden("my_fwrd_vsl_desc",0);
					sheetObj.SetColHidden("crn",0);
					sheetObj.SetColHidden("uvi",1);
					ComBtnEnable("btn2_Save");
	        	} else if ( formObj.pol_cd.value.substring(0,2) == "GB" ) {
					sheetObj.SetColHidden("my_fwrd_ref_cd",1);
					sheetObj.SetColHidden("my_fwrd_vsl_desc",1);
					sheetObj.SetColHidden("crn",1);
					sheetObj.SetColHidden("uvi",0);
					ComBtnDisable("btn2_Save");
	        	} else {
					sheetObj.SetColHidden("my_fwrd_ref_cd",1);
					sheetObj.SetColHidden("my_fwrd_ref_cd",1);
					sheetObj.SetColHidden("crn",1);
					sheetObj.SetColHidden("uvi",1);
					ComBtnDisable("btn2_Save");
	        	}
			} else {
		        formObj.f_cmd.value=SEARCH01;
			}
	  		sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);       			
			var sXml=sheetObj.GetSearchData("ESM_BKG_0616GS.do", FormQueryString(formObj));
        	ComOpenWait(false);       			
        	sheetObj.RenderSheet(0);
        	sheetObj.LoadSearchData(sXml,{Sync:0} );
       		sheetObj.RenderSheet(1);
       		for (var i=sheetObj.HeaderRows();i<sheetObj.RowCount();i++) {
//				if (formObj.search_type[0].checked) {
//					if(i>sheetObj.HeaderRows){
//						sheetObj.CellFontColor(i, "bkg_no") = "#0000FF";
//					}
//				} else {
		       		if(i>sheetObj.HeaderRows()){
		       			if(sheetObj.GetCellValue(i, "bkg_no") == sheetObj.GetCellValue(i - 1, "bkg_no")){
		       				sheetObj.SetCellFontColor(i, "bkg_no","#F0F0F0");
//				       		sheetObj.CellFontColor(i, "bkg_no") = "#C0C0C0";
//				       		sheetObj.RangeBackColor(i, 3, i, 3) = "#C0C0C0";
		       			} else {
		       			sheetObj.SetCellFontColor(i, "bkg_no","#0000FF");
		       			}		       				
		       		} else {
		       			sheetObj.SetCellFontColor(i, "bkg_no","#0000FF");
		       		}
//		       	}
			}
			formObj.bkg_total.value=ComAddComma(ComGetEtcData(sXml, "bkgTotal"));
			formObj.crn.value=ComAddComma(ComGetEtcData(sXml, "crnTotal"));
			formObj.sent.value=ComAddComma(ComGetEtcData(sXml, "ediSent"));
			formObj.unsent.value=ComAddComma(ComGetEtcData(sXml, "ediUnSent"));
			formObj.ack_cnt.value=ComAddComma(ComGetEtcData(sXml, "ackRcv"));
			formObj.tml.value=ComAddComma(ComGetEtcData(sXml, "tmlErr"));			
//			if (formObj.search_type[0].checked) {
//				
//			} else {
//				sheetObj.SetMergeCell()
//			}
			
//			
		break;
		case IBSAVE:
			if(!validateForm(sheetObj,formObj,sAction)) {
			    return false;
			}
			ComOpenWait(true);       		
			formObj.f_cmd.value=MULTI;
			var params=FormQueryString(formObj);
			params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false,true,"slct_flg"),"sheet1_");
			var sXml=sheetObj.GetSaveData("ESM_BKG_0616GS.do", params);
			ComOpenWait(false);       		
			if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
				ComBkgSaveCompleted();
			} else {
				sheetObj.loadSaveXml(sXml);
			}
		break;
		case "btn2_EDITransmit":
			formObj.f_cmd.value=MULTI01;
			var chkRowArr=null;
			var chkRow=null;
			var params=FormQueryString(formObj);
			var bkgNo="";
			var sXml="";
    		if (formObj.search_type[0].checked) {
				chkRowArr=sheetObjects[0].FindCheckedRow("slct_flg");
				chkRow=chkRowArr.split("|");
				for (var idx=0;idx<chkRow.length;idx++) {
					bkgNo=sheetObjects[0].GetCellValue(chkRow[idx], "bkg_no");
					sXml=sheetObjects[0].GetSaveData("ESM_BKG_0616GS.do", params + "&sheet1_ibflag=U&sheet1_bkg_no="+ bkgNo);
					if(ComGetEtcData(sXml, "SuccessYn") != "Y"){
						break;
					}
				}
    		} else {
				chkRowArr=sheetObjects[1].FindCheckedRow("slct_flg");
				chkRow=chkRowArr.split("|");
				for (var idx=0;idx<chkRow.length;idx++) {
					bkgNo=sheetObjects[1].GetCellValue(chkRow[idx], "bkg_no");
					sXml=sheetObjects[1].GetSaveData("ESM_BKG_0616GS.do", params + "&sheet1_ibflag=U&&sheet1_bkg_no="+ bkgNo);
					if(ComGetEtcData(sXml, "SuccessYn") != "Y"){
						break;
					}
				}    			
    		}
    		// 기존 방식
//    		if (formObj.search_type[0].checked) {
//    			params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false,true,"slct_flg"), "sheet1_");
//    		} else {
//    			params = params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(false,true,"slct_flg"), "sheet1_");
//    		}
//			var sXml = sheetObj.GetSaveXml("ESM_BKG_0616GS.do", params);
			if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
				ComShowCodeMessage("BKG00693");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}else {
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		break;
		case "btn2_BatchEDI":
			ComOpenPopup("ESM_BKG_0618.do?pgmNo=ESM_BKG_0618", 600, 150, null, '0,0,0,0', true);
		break;
		case IBDOWNEXCEL:
			if (sheetObj.RowCount()> 0) {
				sheetObj.Down2Excel({ HiddenColumn:-1});
			} else {
				ComShowMessage(msgs['BKG00155']);
			}
		break;
        }
    }
  /**
    * handling process for input validation
    * @param sheetObj sheet Object
    * @param formObj  form Object
    * @param sAction 
    */
    function validateForm(sheetObj,formObj,sAction){
    	var result=false;
        with(formObj){
    		switch(sAction) {
    			case IBSEARCH:
    				if ( ComIsNull(formObj.bkg_no) ) {
    					var dateType = formObj.date_type.value;
    					var msg = 'BKG Date';
    					if(dateType == '1') msg = 'BKG Date';
    					else if(dateType == '2') msg = 'EDI Send Date';
    					
						if(!ComIsDate(formObj.bkg_from_dt.value) || !ComIsDate(formObj.bkg_to_dt.value)){
    						ComClearSeparator(formObj.bkg_from_dt);
    						ComAddSeparator(formObj.bkg_from_dt);
    						ComClearSeparator(formObj.bkg_to_dt);
    						ComAddSeparator(formObj.bkg_to_dt);
    						ComShowCodeMessage('BKG00801', msg);
    	    				return result;
    					}
						
    					if ( !ComIsNull(formObj.vvd) ) {
    						if ( checkMendatoryPOL(formObj) || checkMendatoryBkgOfcCd(formObj) ) {
    							result=true;
    						} else {
    							ComShowCodeMessage('BKG00801', msg);
    						}
    						return result;
    					} else if ( !ComIsNull(formObj.bkg_from_dt) && !ComIsNull(formObj.bkg_to_dt) ) {
    						if ( checkMendatoryDt(formObj)){
    							if ( checkMendatoryPOL(formObj) || checkMendatoryBkgOfcCd(formObj) ) {
    								result=true;
    							} else {
    								ComShowCodeMessage('BKG00801', msg);
    							}
    						}
    					} else return result;
    				} else return true;
    				break;
    			case IBSAVE:
    				if (sheetObj.RowCount()== 0) {
    					ComShowMessage(msgs['BKG00155']);
    					return false;
    				}
    				if (sheetObj.CheckedRows("slct_flg") == 0) {
    					ComShowMessage(msgs['BKG00155']);
    					return false;
    				}
    				result=true;
    				break;
    			case "btn2_EDITransmit":
    				if (sheetObj.RowCount()== 0) {
    					ComShowMessage(msgs['BKG00155']);
    					return false;
    				}
    				if (sheetObj.CheckedRows("slct_flg") == 0) {
    					ComShowMessage(msgs['BKG00155']);
    					return false;
    				}
    				result=true;
    				break;
    		}
        }
        return result;
    }
    /**
     * click search Type
     */
	function clickSearchType(){
		var formObj=document.form;
		if (formObj.search_type[0].checked) {
			sheetObjects[0].SetSheetHeight(420);
			sheetObjects[0].SetVisible(true);
//			sheetObjects[0].SheetWidth = mainTable.clientWidth;
//			sheetObjects[1].SetSheetHeight(0);
			sheetObjects[1].SetVisible(0);
			sheetObjects[1].SheetWidth = 0;
		} else {
//			sheetObjects[0].SetSheetHeight(0);
			sheetObjects[0].SetVisible(0);
			sheetObjects[0].SheetWidth=0;
			sheetObjects[1].SetSheetHeight(420);
			sheetObjects[1].SetVisible(true);
		//	sheetObjects[1].SheetWidth=mainTable.clientWidth;
		}
	}
	/**
	 * mouse in event handling
	 */
	function bkg0616_activate(){
		//입력Validation 확인하기\
		//event.srcElement.name
		switch(ComGetEvent("name")){	
	    	case "bkg_from_dt":
	    		ComClearSeparator(ComGetEvent());
				break;
	    	case "bkg_to_dt":
	    		ComClearSeparator(ComGetEvent());
				break;
			default:
				break;
		}
	}
	/**
	 * mouse out event handling
	 */
	function bkg0616_deactivate(){
		switch(ComGetEvent("name")){	
	    	case "bkg_from_dt":
				ComAddSeparator(ComGetEvent());
				break;
	    	case "bkg_to_dt":
				ComAddSeparator(ComGetEvent());
				break;
			default:
				break;
		}
	}
	/**
	 * form1 blur event handling
	 */
	function form1_blur(){
		//ComChkObjValid(event.srcElement);
	}
	/**
	 * obj keydown event handling
	 */
   	function obj_keydown() {
   		var obj=event.srcElement;
   		var vKeyCode=event.keyCode;
   		var formObj=document.form;
   		if ( vKeyCode == 13 ) {
    		if (formObj.search_type[0].checked) {
    			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
    		} else {
    			doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
    		}
   		}
   	}
   	/**
	 * obj key press event handling
	 */
//	function obj_keypress(){
//		var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//	    switch(event.srcElement.dataformat){
//	    	case "int":
//		        //only Number
//		        ComKeyOnlyNumber(event.srcElement);
//		        break;
//	        case "float":
//	            //only Number + "."
//	            ComKeyOnlyNumber(event.srcElement, ".");
//	            break;
//	        case "eng":
//	            //only Alphabet, Alphabet+Number -> ComKeyOnlyAlphabet('num');
//		        if(keyValue >= 97 && keyValue <= 122) { //lower case
//	                event.keyCode=keyValue + 65 - 97;
//	            }
//	            break;
//	        case "engdn":
//	            //only lower case of Alphabet, lower case of Alphabet+Number -> ComKeyOnlyAlphabet('lowernum');
//	            ComKeyOnlyAlphabet('lower');
//	            break;
//	        case "engup":
//	            //only upper case of Alphabet, upper case of Alphabet+Number -> ComKeyOnlyAlphabet('uppernum');
//	            ComKeyOnlyAlphabet('uppernum');
//	            break;
//	        case "uppernum":
//	            //only upper case of Alphabet, upper case of Alphabet+Number -> ComKeyOnlyAlphabet('uppernum');
//	        	ComKeyOnlyAlphabet('uppernum');
//	            break;
//	        case "engnum":
//	        	//only number, Alphabet
//		  	  	ComKeyOnlyAlphabet('num'); 
//	        	break;    
//	        case "etc": 
//	        	//except lower case of Alphabet
//		        if(keyValue >= 97 && keyValue <= 122) { //lower case
//	                event.keyCode=keyValue + 65 - 97;
//	            }
//	        	break;
//	        default:
//	            //only number (Decimal, Date, Time)
//	            ComKeyOnlyNumber(event.srcElement);
//	    }
//	}
	/**
	 * check mandatory condition(Date)
	 * @param formObj
	 */
	function checkMendatoryDt(formObj) {
		if( ComIsNull(formObj.bkg_from_dt) ) {
//			ComShowCodeMessage( "COM12114", "Booking Create DT" );
////			formObj.bkg_from_dt.focus();
			return false;
		}
		if( ComIsNull(formObj.bkg_to_dt) ) {
//			ComShowCodeMessage( "COM12114", "Booking Create DT" );
////			formObj.bkg_to_dt.focus();
			return false;
		}
		if (formObj.bkg_from_dt.value != "" && formObj.bkg_to_dt.value != "") {
			if (ComGetDaysBetween(formObj.bkg_from_dt,formObj.bkg_to_dt) < 0) {
				ComShowMessage(msgs['BKG00112']);
				return false;
			}			
			if (ComGetDaysBetween(formObj.bkg_from_dt,formObj.bkg_to_dt) > 31){
				ComShowMessage(msgs['BKG50469']);
				return false;
			}
		}
		return true;
	}
	/**
	 * check mandatory condition(VVD)
	 * @param formObj
	 */
	function checkMendatoryVVD(formObj) {
		if( ComIsNull(formObj.vvd) ) {
//			ComShowCodeMessage('BKG00104');
////			formObj.vvd.focus();
			return false;
		}
		return true;
	}
	/**
	 * check mandatory condition(POL)
	 * @param formObj
	 */
	function checkMendatoryPOL(formObj) {
		if( ComIsNull(formObj.pol_cd) ) {
//			ComShowCodeMessage('BKG00104');
////			formObj.pol_cd.focus();
			return false;
		}
		return true;
	}
	/**
	 * check mandatory condition(BkgOfcCd)
	 * @param formObj
	 */
	function checkMendatoryBkgOfcCd(formObj) {
		if( ComIsNull(formObj.bkg_ofc_cd) ) {
//			ComShowCodeMessage('BKG00104');
////			formObj.bkg_ofc_cd.focus();
			return false;
		}
		return true;
	}
	/**
     * Sheet1 double click event handling
     * @param sheetObj
     * @param row
     * @param col
     * @return
     */
    function sheet1_OnDblClick(val, row, col) {
    	var colName = sheetObjects[0].CellSaveName(row, col);
    	if ( colName == 'bkg_no' ) {
			var param="";
			var chkBkgNo=sheetObjects[0].GetCellValue(row, "bkg_no");
			if ( chkBkgNo != "" ) {
				param="?pgmNo=ESM_BKG_0079&bkg_no="+sheetObjects[0].GetCellValue(row, "bkg_no");
				comBkgCallPopBkgDetail(sheetObjects[0].GetCellValue(row, "bkg_no"));
			}
		}else if(colName == 'cntr_slt_no_ctnt') {
			ComShowMemoPad(sheetObjects[0], row, col, true, 800, null, null, 1);
		}
    }
    /**
     * Sheet2 double click event handling
     * @param sheetObj
     * @param row
     * @param col
     * @return
     */
    function sheet2_OnDblClick(val, row, col) {
		if ( col == 3 ) {
			var param="";
			var chkBkgNo=sheetObjects[1].GetCellValue(row, "bkg_no");
			if ( chkBkgNo != "" ) {
				param="?pgmNo=ESM_BKG_0079&bkg_no="+sheetObjects[1].GetCellValue(row, "bkg_no");
//				ComOpenWindowCenter("/opuscntr/ESM_BKG_0079.do" + param, "PopupEsmBkg0616", 1005, 650, false);
				//freezing related modify
				comBkgCallPopBkgDetail(sheetObjects[1].GetCellValue(row, "bkg_no"));
			}
		}
    }
    /**
	 * handling process after ending sheet1 retrieve
	 * 
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var wColor="#FFFFFF";
 		for(var i=1;i<=sheetObjects[0].RowCount();i++) {
 			
 			if(i>1) {
 				if(sheetObjects[0].GetCellValue(i, "bkg_no") == sheetObjects[0].GetCellValue(i-1, "bkg_no")) {
 					sheetObjects[0].SetCellFontColor(i, "bkg_no",wColor);
 				}
 			}
 		}
 		
		with(sheetObj){
			SetColFontUnderline("bkg_no",1);
		}			
	}
	/**
	 * handling process after ending sheet2 retrieve
	 * 
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */  
	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
		with(sheetObj){
			SetColFontUnderline("bkg_no",1);
		}			
	}

	function WaitImage(flg){
		ComOpenWait(flg);
	}
