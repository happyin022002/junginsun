/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0098.js
*@FileTitle  : Booking Receipt Notice (Fax/E-Mail)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
   /**
     * @fileoverview JavaScript is commonly used in business as a calendar-related functions have been defined.
     * @author  
     */
    /**
     * @extends 
     * @class ESM_BKG_0098 : ESM_BKG_0098 business script.
     */

   	/* Developer Work	*/
// global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var sheetObjects=new Array();
var sheetCnt=0;
var layList = null;
var remarkSeparator = "@#";

// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
 		var sheetObject = sheetObjects[0];
 		var sheetObject2 = sheetObjects[1];
         /*******************************************************/
 		var formObject=document.form;
 		
 		if(layList == undefined || layList == null) layList = document.getElementById("layList");
 		 
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
            	case "btn_multBkgNo":	
				
					if($("#btn_multBkgNo").is(":disabled")) return;
					var stop = $("#bkg_no").offset().top;
				    var sleft = $("#bkg_no").offset().left;
				    layList.style.left = sleft + "px";
				    layList.style.top = (stop+25) + "px";
				    
					if($("#layList").is(":visible") == false){
						$("#layList").show();
					}else{
						$("#layList").hide();
					}
					
				break;
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			break;
			case "btn_New":
				doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
				ComResetAll();
				ComClearObject(formObject.bkg_ofc_cd);
			break;
			case "btn_Print":
				if(!validateForm(sheetObjects[0],formObject,"btn_Print")) {
					return false;
				}
				rdOpen("print");
			break;
			case "btn_Preview":
				if(!validateForm(sheetObjects[0],formObject,"btn_Preview")) {
					return false;
				}
				rdOpen("preview");
			break;
			case "btn_EditFaxEmail":
				if(!validateForm(sheetObjects[0],formObject,"btn_EditFaxEmail")) {
					return false;
				}
	        	var width=355;
				var height=170;
				var left=(screen.width-width)/2;
				var top=(screen.height-height)/2;
				var url="ESM_BKG_0221.do";
				var url="ESM_BKG_0221.do?func=getCOM_Fax_Email_POPUP&send_hidden=Y";
				ComOpenWindowCenter(url, "ESM_BKG_0221", 400, 190, true);				
			break;
			case "btn_AssignEmail":
				if(!validateForm(sheetObjects[0],formObject,"btn_AssignEmail")) {
					return false;
				}
				doActionIBSheet(sheetObjects[0],formObject,"btn_AssignEmail");
			break;
			case "btn_EditRemark":
				if(!validateForm(sheetObjects[0],formObject,"btn_EditRemark")) {
					return false;
				}
				comBkgCallPop0384('callBack0384');
			break;
			case "btn_EditCCT":
				if(!validateForm(sheetObjects[0],formObject,"btn_EditCCT")) {
					return false;
				}
	        	//open popup 0934
	        	var width=500;
				var height=350;
				var left=(screen.width-width)/2;
				var top=(screen.height-height)/2;
				ComOpenPopup("ESM_BKG_0934.do", width, height, "callBack0934", "none", true);
			break;
			case "btn_Fax":
				if(!validateForm(sheetObjects[0],formObject,"btn_Fax")) {
					return false;
				}
				doActionIBSheet(sheetObjects[0],formObject,"btn_Fax");
			break;
			case "btn_Email":
				if(!validateForm(sheetObjects[0],formObject,"btn_Email")) {
					return false;
				}
				document.form.btnTp.value = "D";
				doActionIBSheet(sheetObjects[0],formObject,"btn_Email");
			break;
			case "btn_GroupEmail":
				if(!validateForm(sheetObjects[0],formObject,"btn_GroupEmail")) {
					return false;
				}
				document.form.btnTp.value = "G";
				doActionIBSheet(sheetObjects[0],formObject,"btn_GroupEmail");
			break;
			case "btn_EmailEdit":
				if(!validateForm(sheetObjects[0],formObject,"btn_EmailEdit")) {
					return false;
				}
				document.form.btnTp.value = "E";
				doActionIBSheet(sheetObjects[0],formObject,"btn_EmailEdit");
			break;
			case "btn_DownExcel":
				if(sheetObjects[0].RowCount() < 1){//no data
	                   ComShowCodeMessage("COM132501");
	              }else{
	            	  doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
	              }
				
			break;
			case "btns_calendar":
				var cal=new ComCalendarFromTo();
				cal.select(formObject.bkg_from_dt, formObject.bkg_to_dt,'yyyy-MM-dd');
			break;
			
			case "btn_multi_bkg":
				ComBtnEnable("btn_multBkgNo");
				sheetObject2.RemoveAll();
				sheetObject2.LoadExcel({ColumnMapping:'1'});
				break;
				
			case "btn_EmailCust":
				if(!validateForm(sheetObjects[0],formObject,"btn_EmailCust")) {
					return false;
				}
				document.form.btnTp.value = "C";
				doActionIBSheet(sheetObjects[0],formObject,"btn_EmailCust");
				break;
				
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
//    			ComShowMessage(OBJECT_ERROR);
    		} else {
//    			ComShowMessage(e);
    		}
    	}
    }
    
    function callBack0934(rtnVal) {
    	var sheetObj = sheetObjects[0]
    	if (rtnVal) {
    		if (rtnVal[0] != undefined && rtnVal[0] != "") {
    			sheetObj.SetCellValue(sheetObj.GetSelectRow(), 'cct', rtnVal[0]);
    		}
    		if (rtnVal[1] != undefined && rtnVal[1] != "") {
    			sheetObj.SetCellValue(sheetObj.GetSelectRow(), 'doc_cct', rtnVal[1]);
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
	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
//	sheet1.SetSheetHeight(320);
	jqueryEvent();
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
            with (sheetObj) {
                
                var HeadTitle1="|Sel.||Booking No.|S|AUTO EDI Hold|Kind|Shipper|Shipper|FF Code|Fax No.|Fax No.|E-mail|E-mail|Full Return Yard|Full Cargo CCT|Full Cargo CCT|Full Cargo CCT|Port CCT|Port CCT|Port CCT|Doc CCT|T/VVD|POR|EQ OFC|POL|POD|DEL|BKG Staff|Contact PIC|Fax Result|Fax Result|Fax Date|E-mail Result|E-mail Result|E-mail Date|Remark(s)|Rmk change Flg|new_flg|remark_backup";
                var HeadTitle2="|Sel.||Booking No.|S|AUTO EDI Hold|Kind|Code|Name|FF Code|Fax No.|Fax No.|E-mail|E-mail|Full Return Yard|Original|Current|Manual|Original|Current|Manual|Doc CCT|T/VVD|POR|EQ OFC|POL|POD|DEL|BKG Staff|Contact PIC|Fax Result|Fax Result|Fax Date|E-mail Result|E-mail Result|E-mail Date|Remark(s)|Rmk change Flg|new_flg|remark_backup";
                SetMergeCell(0,1,1,2);

                SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                       {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"slct_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Seq",       Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                       {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"status",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"edi_hld_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"kind",    		  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"shipper_code",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:160,  Align:"Left",    ColMerge:1,   SaveName:"shipper_name",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ff_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"fax",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Image",     Hidden:0, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"fax_btn",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:190,  Align:"Left",    ColMerge:0,   SaveName:"eml",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Image",     Hidden:0, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"eml_btn",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:105,  Align:"Center",  ColMerge:0,   SaveName:"full_rtn_yd_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0, Width:105,  Align:"Center",  ColMerge:0,   SaveName:"cargo_cct",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0, Width:105,  Align:"Center",  ColMerge:0,   SaveName:"cargo_cct_cng",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0, Width:105,  Align:"Center",  ColMerge:0,   SaveName:"cargo_cct_mnl",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:105,  Align:"Center",  ColMerge:0,   SaveName:"cct",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0, Width:105,  Align:"Center",  ColMerge:0,   SaveName:"cct_cng",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0, Width:105,  Align:"Center",  ColMerge:0,   SaveName:"cct_mnl",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:105,  Align:"Center",  ColMerge:0,   SaveName:"doc_cct",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"tvvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"por",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eq_ofc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pol",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pod",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"del",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_staff",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"contact_pic",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"fax_result",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Image",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"fax_his_btn",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"fax_date",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eml_result",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Image",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"eml_his_btn",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"eml_date",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:200,   Align:"Left",    ColMerge:1,   SaveName:"remark",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                       {Type:"Text",      Hidden:1, Width:200,   Align:"Left",    ColMerge:1,   SaveName:"rmk_change_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                       {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"new_flg" },
                       {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"remark_backup" } ];
                 
                InitColumns(cols);
                SetEditable(1);
                SetImageList(0,"img/btns_plus.gif");
                SetImageList(1,"img/btns_minus.gif");
                SetImageList(2,"img/btns_multisearch.gif");
                SetDataLinkMouse("fax_btn", 1);
                SetDataLinkMouse("eml_btn", 1);
                SetShowButtonImage(1);
                sheetObj.FrozenCols=4;
                updateSheetSize(sheetObj);
                SetHighlightAfterSort(0);

            }
            break;
            
            case "sheet2":	
				with(sheetObj){			        
					var HeadTitle1="bkg_no";
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
    
$(window).resize(function() {
		if(this.resizeTO) {
			clearTimeout(this.resizeTO);
		}
		this.resizeTO = setTimeout(function() {
			$(this).trigger('resizeEnd');
		}, 300);
});

$(window).on('resizeEnd', function() {
	 updateSheetSize(sheetObjects[0]);
});

function updateSheetSize(sheetObj){
  var obj = $("#" + sheetObj.id).offset();
  var marginDefault = 140;
  var marginHeight = obj.top + marginDefault;
  var height = $(window).height();

  with(sheetObj){
     SetSheetHeight(height - marginHeight);
  }
}        
    
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
		case IBCLEAR:      //Initialization
			ComClearObject(formObj.bkg_from_dt);
			ComClearObject(formObj.bkg_to_dt);
			//ComClearObject(formObj.bkg_ofc_cd);
//			ComClearObject(formObj.bkg_staff);
			ComClearObject(formObj.bkg_status);
			ComClearObject(formObj.bkg_kind);
			ComClearObject(formObj.vvd);
			ComClearObject(formObj.pol_cd);
			ComClearObject(formObj.pod_cd);
			ComClearObject(formObj.por_cd);
			ComClearObject(formObj.del_cd);
			ComClearObject(formObj.sales_ofc);
			ComClearObject(formObj.sales_rep);
			ComClearObject(formObj.bkg_no);
			ComClearObject(formObj.cust_tp_cd);
			ComClearObject(formObj.cust_seq);
			ComClearObject(formObj.cust_nm);
			ComClearObject(formObj.fax_proc_sts_cd);
			ComClearObject(formObj.eml_proc_sts_cd);
			formObj.bkg_from_dt.value=ComGetNowInfo();
			formObj.bkg_to_dt.value=ComGetNowInfo();
			formObj.cust_tp_cd.selectedIndex=1;
			if("Normal"!=ComGetObjValue(formObj.rtn_ofc_cd)){
//				ComBtnDisable("btn_EditCCT");
				ComBtnDisable("btn_EditRemark");
				sheetObj.SetColHidden("remark", 1);
			}
			ComSetObjValue(formObj.elements["defaultSort" ],"Y");
		break;
		case IBSEARCH:      //Retrieve
			if(!validateForm(sheetObj,formObj,sAction)) {
				return false;
			}
			
			/* 멀티 부킹 넘버가 100개 넘으면 오류 메세지 */
			if($('#rows').css("color").indexOf('255') > 0){
				ComShowMessage('You can input Booking No up to 100 Maximum. Please kindly check Booking No again.');
				$("#layList").show();
				return false;
			}else{
				$("#layList").hide();
			}
			
        	formObj.f_cmd.value=SEARCH;
        	var sXml=sheetObj.GetSearchData("ESM_BKG_0098GS.do", FormQueryString(formObj));
	       	var arrXml=sXml.split("|$$|");
	       	for(var i=0; i < arrXml.length; i++){ 
	       		sheetObjects[i].RenderSheet(0);
	       		if(i > 0) {
     				sheetObjects[i].SetWaitImageVisible(0);
	       		}  
	       		sheetObjects[i].LoadSearchData(arrXml[i],{Sync:0} );
	       		sheetObjects[i].RenderSheet(1);
	       	}
	       	for (var i=sheetObj.HeaderRows();i<sheetObj.Rows;i++) {
	       		sheetObjects[0].SetCellFontColor(i, 3,"#0000FF");
 	       		if("Normal"!=ComGetObjValue(formObj.rtn_ofc_cd)){
	       			sheetObj.SetCellEditable(i, "cct",0);
	       			sheetObj.SetCellEditable(i, "doc_cct",0);
 	       		}
	       	}
			formObj.fax_bkg_total.value=ComAddComma(ComGetEtcData(sXml, "faxBkgTotal"));
			formObj.eml_bkg_total.value=ComAddComma(ComGetEtcData(sXml, "emlBkgTotal"));
			formObj.fax_total.value=ComAddComma(ComGetEtcData(sXml, "faxTotal"));
			formObj.eml_total.value=ComAddComma(ComGetEtcData(sXml, "emlTotal"));
			formObj.fax_success.value=ComAddComma(ComGetEtcData(sXml, "faxSuccess"));
			formObj.eml_success.value=ComAddComma(ComGetEtcData(sXml, "emlSuccess"));
			formObj.fax_send.value=ComAddComma(ComGetEtcData(sXml, "faxSending"));
			formObj.eml_send.value=ComAddComma(ComGetEtcData(sXml, "emlSending"));
			formObj.fax_unsent.value=ComGetEtcData(sXml, "faxUnSent");
			formObj.eml_unsent.value=ComGetEtcData(sXml, "emlUnSent");

		break;
		case IBDOWNEXCEL:
			if (sheetObj.RowCount()> 0) {
				sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), Merge:1, SheetDesign:1 });
			} else {
				ComShowMessage("BKG00155");
			}
		break;
		case "btn_AssignEmail":
			var arrRow=ComFindText(sheetObj, "slct_flg", 1);
			var bkg_no="";
			if (arrRow && 0<arrRow.length) {
				for (var i=0; i<arrRow.length; i++) {
					bkg_no += sheetObj.GetCellValue(arrRow[i],"bkg_no")+'|';
				}
				if (0<bkg_no.indexOf("|")) bkg_no=bkg_no.substring(0,bkg_no.length-1);
			}
			var formObject5=document.form5;
			formObject5.elements["f_cmd" ].value=SEARCH03;
			formObject5.elements["bkg_no"].value=bkg_no;
			var sXml=sheetObj.GetSearchData("ESM_BKG_0218GS.do", FormQueryString(formObject5));
			var xmlDoc = ComGetXmlDoc(sXml);
	        if (xmlDoc == null)
	          return;
	        //xmlDoc.async="false";
	        //xmlDoc.loadXML(sXml);
	        var dataNode=xmlDoc.documentElement.getElementsByTagName("DATA").item(0);
			var sep=dataNode.getAttribute("COLSEPARATOR");
	        var dataChildNodes=dataNode.childNodes;
	        var succFlg=false;
	        if (0<dataChildNodes.length) {
	        	var agentEmail,agentBkgNo;
				for (var i=0; i<dataChildNodes.length; i++) {
					if(dataChildNodes.item(i).firstChild != null){
						agentEmail=dataChildNodes.item(i).firstChild.nodeValue.split(sep)[1];
						agentBkgNo=dataChildNodes.item(i).firstChild.nodeValue.split(sep)[2];
						if (""!=agentEmail) {
							if (arrRow && 0<arrRow.length) {
								for (var j=0; j<arrRow.length; j++) {
									if (agentBkgNo==sheetObj.GetCellValue(arrRow[j],"bkg_no")) {
										sheetObj.SetCellValue(arrRow[j],"eml",agentEmail,0);
										break;
									}
								}
							}
							succFlg=true;
						}
					}
				}
				if (succFlg) {
					ComShowCodeMessage("COM130405","BKG Agent E-mail");  //{?msg1} was retrieved successfully.
				}
	        }
	        if (!succFlg) {
	        	ComShowCodeMessage("COM130402","BKG Agent E-mail");  //{?msg1} doesn\'t exist
	        }
	    break;
		case "btn_Fax":
			formObj.f_cmd.value=MULTI01;
			var params=FormQueryString(formObj);
			var chkRowArr=sheetObjects[0].FindCheckedRow("slct_flg");
			var chkRow=chkRowArr.split("|");
			if ( sheetObjects[0].CheckedRows("slct_flg") > 0 ) {
				if (chkRow.length < 2) {
					sheetObjects[0].SetCellValue(chkRow[0],"remark_backup",sheetObjects[0].GetCellValue(chkRow[0],"remark"),0);
					sheetObjects[0].SetCellValue(chkRow[0],"remark",encodeRemark(sheetObjects[0].GetCellValue(chkRow[0],"remark")),0);
				}else {
					for (var idx=0;idx<chkRow.length;idx++) {
						sheetObjects[0].SetCellValue(chkRow[idx],"remark_backup",sheetObjects[0].GetCellValue(chkRow[idx],"remark"),0);
						sheetObjects[0].SetCellValue(chkRow[idx],"remark",encodeRemark(sheetObjects[0].GetCellValue(chkRow[idx],"remark")),0);
					}
				}
				params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, 1), "sheet1_");
				var sXml=sheetObj.GetSaveData("ESM_BKG_0098GS.do", params);
				for (var idx=0;idx<chkRow.length;idx++) {
					sheetObjects[0].SetCellValue(chkRow[idx],"remark",sheetObjects[0].GetCellValue(chkRow[idx],"remark_backup"),0);
					sheetObjects[0].SetCellValue(chkRow[idx],"remark_backup","",0);
				}
				if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
					ComShowCodeMessage("BKG00496");
				}
				if ("F"==ComGetEtcData(sXml,"TRANS_RESULT_KEY")) {
			    	var rmsg=ComGetEtcData(sXml,"Exception").split("<||>");
			     	if (rmsg[3] != undefined && 0 < rmsg[3].length) {
			     		ComShowMessage(rmsg[3]);
			     	} else {
			     		sheetObjects[0].LoadSaveData(sXml);
					}
				}
			}
		break;
		case "btn_Email":
			var chkRowArr = sheetObjects[0].FindCheckedRow("slct_flg");
			var chkRow = chkRowArr.split("|");
			if(chkRow != null && chkRow.length == 0) return;
			ComOpenWait(true);
			setTimeout("emailSend()", 500);
			
		break;
		case "btn_GroupEmail":
			formObj.f_cmd.value = MULTI03;
			sendGroupCustMail(formObj);
		break;
		case "btn_EmailEdit":
			var formObject=document.form;
			var arrRow=ComFindText(sheetObjects[0], "slct_flg", 1);
			var bkg_no_list="";
			var edt_to_eml="";
			if (arrRow && 0<arrRow.length) {
				for (var i=0; i<arrRow.length; i++) {
					bkg_no_list += sheetObjects[0].GetCellValue(arrRow[i],"bkg_no")+"|";
				}
				if (0<bkg_no_list.indexOf("|")) bkg_no_list=bkg_no_list.substring(0,bkg_no_list.length-1);
				edt_to_eml=sheetObjects[0].GetCellValue(arrRow[0],"eml");
				ComOpenWindowCenter("/opuscntr/ESM_BKG_1096.do?ui_id=ESM_BKG_0098&ntc_knd_cd=BK&bkg_no_list="+bkg_no_list+"&edt_to_eml="+edt_to_eml, "ESM_BKG_1096", 700, 700, true);
			}
		break;
		
			case "btn_EmailCust":
				ComOpenPopup("ESM_BKG_0100.do?pgmNo=ESM_BKG_0100", 700, 600, 'custMainContent', "0,0,0,0,0,0", true);
			break;
        }
    }
    
    function custMainContent(content){
    	var formObj = document.form;
    	if(content != ''){
    		ComOpenWait(true);
    		setTimeout(function(){
    			formObj.f_cmd.value = MULTI04;
    			formObj.custBody.value = content;
    			sendGroupCustMail(formObj);
    		}, 500)
    	}
    }
    
    /**
     * Group , Cust 메일 동일하게 사용한다. f_cmd 값만 틀리게 사용
     * @param formObj
     */
    function sendGroupCustMail(formObj){
    	var params = FormQueryString(formObj);
		var chkRowArr = sheetObjects[0].FindCheckedRow("slct_flg");
		var chkRow = chkRowArr.split("|");
		
		//comfirm change of remarks: if remark is changed, rmk_change_flg="Y"
		for (var i = 0; i < chkRow.length; i++) {
			if(sheetObjects[0].GetCellValue(chkRow[i],"remark") != sheetObjects[0].CellSearchValue(chkRow[i],"remark")){
				sheetObjects[0].SetCellValue(chkRow[i],"rmk_change_flg","Y",0);
			} else{
				sheetObjects[0].SetCellValue(chkRow[i],"rmk_change_flg","N",0);
			}
		}	 	
		if ( sheetObjects[0].CheckedRows("slct_flg") > 0 ) {
			if (chkRow.length < 2) {
				sheetObjects[0].SetCellValue(chkRow[0],"remark_backup",sheetObjects[0].GetCellValue(chkRow[0],"remark"),0);
				sheetObjects[0].SetCellValue(chkRow[0],"remark",encodeRemark(sheetObjects[0].GetCellValue(chkRow[0],"remark")),0);
			}else {
				for (var idx=0;idx<chkRow.length;idx++) {
					sheetObjects[0].SetCellValue(chkRow[idx],"remark_backup",sheetObjects[0].GetCellValue(chkRow[idx],"remark"),0);
					sheetObjects[0].SetCellValue(chkRow[idx],"remark",encodeRemark(sheetObjects[0].GetCellValue(chkRow[idx],"remark")),0);
				}
			}
			
			params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, 1), "sheet1_");
			var sXml = sheetObjects[0].GetSaveData("ESM_BKG_0098GS.do", params);
			ComOpenWait(false);
			for (var idx = 0; idx < chkRow.length; idx++) {
				sheetObjects[0].SetCellValue(chkRow[idx], "remark", sheetObjects[0].GetCellValue(chkRow[idx], "remark_backup"), 0);
				sheetObjects[0].SetCellValue(chkRow[idx], "remark_backup", "", 0);
			}
			if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
				ComSetObjValue(formObj.elements["edt_ntc_knd_cd" ],"");
				ComSetObjValue(formObj.elements["edt_bkg_no_list"],"");
				ComSetObjValue(formObj.elements["edt_to_eml"     ],"");
				ComSetObjValue(formObj.elements["edt_cc_eml"     ],"");
				ComSetObjValue(formObj.elements["edt_from_eml"   ],"");
				ComSetObjValue(formObj.elements["edt_subject"    ],"");
				ComSetObjValue(formObj.elements["edt_contents"   ],"");
				ComShowCodeMessage("BKG00497");
			} 
			if ("F" == ComGetEtcData(sXml,"TRANS_RESULT_KEY")) {
		    	var rmsg = ComGetEtcData(sXml,"Exception").split("<||>");
		     	if (rmsg[3] != undefined && 0 < rmsg[3].length) {
		     		ComShowMessage(rmsg[3]);
		     	} else {
		     		sheetObjects[0].LoadSaveData(sXml);
				}
			}
		}
    }
    
    /**
     * save received value from Remark <br>
     */
    function callBack0384(rArray){
    	var formObj=document.form;
    	if(rArray != null){
    		var chkRow=ComFindText(sheetObjects[0], "slct_flg", 1);
    		if ( sheetObjects[0].CheckedRows("slct_flg") > 0 ) {
    			for (var idx=0;idx<chkRow.length;idx++) {
    				sheetObjects[0].SetCellValue(chkRow[idx], "remark",rArray[0][6]);
    			}
    		}
    	}
    }
	function initControl() {
		var formObject=document.form;
		axon_event.addListenerForm('beforedeactivate', 'bkg0098_obj_deactivate', formObject);
		axon_event.addListenerFormat('beforeactivate',   'bkg0098_activate', formObject);
		axon_event.addListenerForm('blur', 'form1_blur', formObject);
	}
	 /**
	 * mouse IN 
	 */
	function bkg0098_activate(){
		//input Validation check
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
    function bkg0098_obj_deactivate(){
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
	function form1_blur(){
		//ComChkObjValid(event.srcElement);
	}
	
	
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	var result=false;
        with(formObj){
		switch(sAction) {
			case IBSEARCH:
				if(ComChkPeriod(formObj.bkg_from_dt, formObj.bkg_to_dt) <=	 0){
					ComShowMessage("BKG Start Date must be later than BKG End Date.");
					return false;
				}
				/* 멀티 부킹 중복 체크 */
				duplicateBkgNoCheck('mult_bkg_no');
				
				if ( ComIsNull(formObj.bkg_no) &&  ComIsNull(formObj.mult_bkg_no)) {
					if ( !ComIsNull(formObj.vvd) ) {
						if ( checkMendatoryPOR(formObj) || checkMendatoryPOL(formObj) || checkMendatoryPOD(formObj) || checkMendatoryDEL(formObj)||
							 checkMendatoryBkgOfcCd(formObj) || checkMendatoryBkgStfCd(formObj) ||
							 checkMendatorySalesOfcCd(formObj) || checkMendatorySrepCd(formObj) ) {
							result=true;
						} else {
							ComShowCodeMessage("BKG00104", "\n\tPOR or\n\tPOL or\n\tPOD or\n\tDEL or\n\tBKG Office or\n\tBKG Staff or\n\tSales Office or\n\tSales Rep\n");
						}
						return result;
					} else if ( !ComIsNull(formObj.bkg_from_dt) && !ComIsNull(formObj.bkg_to_dt) ) {
						if ( checkMendatoryDt(formObj) ){ 
							if ( checkMendatoryBkgOfcCd(formObj) || checkMendatoryBkgStfCd(formObj) || 
							     checkMendatorySalesOfcCd(formObj) || checkMendatorySrepCd(formObj) || 
							     checkMendatoryPOR(formObj) || checkMendatoryPOL(formObj) ) {
							    result=true;
							} else {
							    ComShowCodeMessage("BKG00104", "\n\tPOR or\n\tPOL or\n\tBKG Office or\n\tBKG Staff or\n\tSales Office or\n\tSales Rep");
							} 
						}
					} else if ( ComIsNull(formObj.vvd) || ComIsNull(formObj.bkg_from_dt) || ComIsNull(formObj.bkg_to_dt) ) {
						ComShowCodeMessage("BKG00104", "\n\tBKG DT or\n\tVVD\n");
					} else return result;
				} else return true;
				
			break;
		}
		if ( sAction=="btn_Print" || sAction=="btn_Preview" || sAction=="btn_EditFaxEmail" ||
             sAction=="btn_AssignEmail" || sAction=="btn_EditRemark" || sAction=="btn_EditCCT" ||
             sAction=="btn_Fax" || sAction=="btn_Email" || sAction=="btn_GroupEmail" || sAction=="btn_EmailEdit" || sAction=="btn_EmailCust") {
			if (sheetObj.RowCount()== 0) {
				ComShowCodeMessage("BKG00155");
				return false;
			}
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowCodeMessage("BKG00155");
				return false;
			}
			
			var arrRow=ComFindText(sheetObj, "slct_flg", 1);
			//Date format check
			if ( sAction=="btn_Print" || sAction=="btn_Preview" || 
		             sAction=="btn_Fax" || sAction=="btn_Email" || sAction=="btn_GroupEmail" || sAction=="btn_EmailEdit") {
				var fullCargoCct="";
				var portCct="";
				var docCct="";
				if (arrRow && 0<arrRow.length) {
					for (var i=0; i < arrRow.length; i++) {
						fullCargoCct=sheetObj.GetCellValue(arrRow[i],"cargo_cct_mnl");
						if(fullCargoCct!=""){
							if((!ComIsDateTime2(fullCargoCct,"ymdhm")) || (!validateDate(fullCargoCct))){
								ComShowCodeMessage("BKG00651", "Full Cargo CCT : " + fullCargoCct);
								sheetObj.SelectCell(arrRow[i], "cargo_cct_mnl", true);
								return false;
							}
						}
						portCct=sheetObj.GetCellValue(arrRow[i],"cct_mnl");
						if(portCct!=""){
							if((!ComIsDateTime2(portCct,"ymdhm")) || (!validateDate(portCct))){
								ComShowCodeMessage("BKG00651", "Port CCT : " + portCct);
								sheetObj.SelectCell(arrRow[i], "cct_mnl", true);
								return false;
							}
						}
						docCct=sheetObj.GetCellValue(arrRow[i],"doc_cct");
						if(docCct!=""){
							if((!ComIsDateTime2(docCct,"ymdhm")) || (!validateDate(docCct))){
								ComShowCodeMessage("BKG00651", "Doc CCT : " + docCct);
								sheetObj.SelectCell(arrRow[i], "doc_cct", true);
								return false;
							}
						}
					}
				}
			}
			
//			if (sAction == "btn_Preview") {
			if (sAction == "btn_Preview" || sAction=="btn_Print" || sAction=="btn_GroupEmail" || sAction=="btn_EmailEdit") {
				if (50<sheetObj.CheckedRows("slct_flg")) {
					ComShowCodeMessage("BKG08124",50);  //You select more than {?msg1} B/Ls for B/L print. Max is {?msg1} B/Ls one time
					return false;
				}

				//check whether total remark characters is less than 4000. 
				if(formObj.mrd.value=="ESM_BKG_5005G"){
					if (arrRow && 0<arrRow.length) {
						var remark_length = 0;  
						var cellRemark = "";
						for (var i=0; i < arrRow.length; i++) {
							cellRemark = sheetObj.GetCellValue(arrRow[i],"remark");
							if(cellRemark.indexOf(remarkSeparator, 0) != -1){ // check if separator(@#) exists in remarks
								ComShowCodeMessage("BKG03061",remarkSeparator + " in Remark(s)");
								sheetObj.SelectCell(arrRow[i], "remark", true);
								return false;
							}
							remark_length += encodeRemark(cellRemark + remarkSeparator).length;
							if(remark_length > 3994){
								ComShowCodeMessage("BKG95001","select less rows. ","Selected data have remark of over 4000 characters in total");
								sheetObj.SetSelectRow(arrRow[i]);
								return false;
							}
						}
					}
				}
			}
/*
			if (sAction == "btn_Preview") {
				if (sheetObj.CheckedRows("slct_flg") > 1) {
					ComShowCodeMessage("BKG00362");
					return false;
				}
			}
*/
			if(sAction=="btn_Fax"){
//				var arrRow=ComFindText(sheetObj, "slct_flg", 1);
				if (arrRow && 0<arrRow.length) {
					for (var i=0; i < arrRow.length; i++) {
						var fax=sheetObj.GetCellValue(arrRow[i],"fax");
						if(""==fax){
							ComShowCodeMessage("BKG00365");
							return false;
						}
					}
				}
			}
			if(sAction=="btn_Email"){
//				var arrRow=ComFindText(sheetObj, "slct_flg", 1);
				if (arrRow && 0<arrRow.length) {
					for (var i=0; i < arrRow.length; i++) {
						var email=sheetObj.GetCellValue(arrRow[i],"eml");
						if(""==email || !ComIsEmailAddr(email)){
							ComShowCodeMessage("BKG00366");
							return false;
						}
					}
				}
			}
			if (sAction == "btn_GroupEmail" || sAction=="btn_EmailEdit") {
				var returnFlg=true;
				var messageCd="";
//				var arrRow=ComFindText(sheetObj, "slct_flg", 1);
				if (arrRow && 0<arrRow.length) {
					var shpr_cd=sheetObj.GetCellValue(arrRow[0],"shipper_code");
					var email=sheetObj.GetCellValue(arrRow[0],"eml");
					var loop_shpr_cd;
					var loop_email;
					for (var i=0; i<arrRow.length; i++) {
						loop_shpr_cd=sheetObj.GetCellValue(arrRow[i],"shipper_code");
						loop_email=sheetObj.GetCellValue(arrRow[i],"eml");
						if(""==email  || !ComIsEmailAddr(email)){
							messageCd="BKG00366";  
							returnFlg=false;
							break;
						}
						if (""==loop_email || shpr_cd != loop_shpr_cd || email != loop_email) {
							messageCd="BKG00357";  
							returnFlg=false;
							break;
						}
					}
					if (!returnFlg) {
						var ff_cd=sheetObj.GetCellValue(arrRow[0],"ff_cd");
						var loop_ff_cd;
						var loop_email;
						for (var i=0; i<arrRow.length; i++) {
							loop_ff_cd=sheetObj.GetCellValue(arrRow[i],"ff_cd")
							loop_email=sheetObj.GetCellValue(arrRow[i],"eml");
							if (""!=email && ""!=loop_ff_cd && ff_cd == loop_ff_cd && email == loop_email) {
								returnFlg=true;
							} else {
								returnFlg=false;
								break;
							}
						}
					}
					if (!returnFlg && ""!=messageCd) {
						ComShowCodeMessage(messageCd);
					}
					return returnFlg;
				}
			}
			
			if (sAction == "btn_EmailCust") {
				var returnFlg = true;
				var messageCd = "";
				if (arrRow && 0 < arrRow.length) {
					for (var i=0; i<arrRow.length; i++) {
						var email = sheetObj.GetCellValue(arrRow[i], "eml");
						if("" == email  || !ComIsEmailAddr(email)){
							messageCd = "BKG00366";  
							returnFlg = false;
							sheetObj.SelectCell(arrRow[i], "eml");  
							break;
						}
					}
				}
				
				if (!returnFlg && "" != messageCd) {
					ComShowCodeMessage(messageCd);
				}
				return returnFlg;
			}
			
			
			return true;
		}
        }
        return result;
    }
    
	function checkMendatoryDt(formObj) {
		if( ComIsNull(formObj.bkg_from_dt) ) {
			return false;
		}
		if( ComIsNull(formObj.bkg_to_dt) ) {
			return false;
		}
		if (formObj.bkg_from_dt.value != "" && formObj.bkg_to_dt.value != "") {
			if (ComGetDaysBetween(formObj.bkg_from_dt,formObj.bkg_to_dt) < 0) {
				ComShowCodeMessage("BKG00112");
				return false;
			}			
			if (ComGetDaysBetween(formObj.bkg_from_dt,formObj.bkg_to_dt) > 31){
				ComShowMessage(msgs['BKG50469']);
				return false;
			}
		}
		return true;
	}
	function checkMendatoryVVD(formObj) {
		if( ComIsNull(formObj.vvd) ) {
			return false;
		}
		return true;
	}
	function checkMendatoryPOL(formObj) {
		if( ComIsNull(formObj.pol_cd) ) {
			return false;
		}
		return true;
	}
	function checkMendatoryPOD(formObj) {
		if( ComIsNull(formObj.pod_cd) ) {
			return false;
		}
		return true;
	}
	function checkMendatoryPOR(formObj) {
		if( ComIsNull(formObj.por_cd) ) {
			return false;
		}
		return true;
	}
	function checkMendatoryDEL(formObj) {
		if( ComIsNull(formObj.del_cd) ) {
			return false;
		}
		return true;
	}
	function checkMendatoryBkgOfcCd(formObj) {
		if( ComIsNull(formObj.bkg_ofc_cd) ) {
			return false;
		}
		return true;
	}
	function checkMendatorySalesOfcCd(formObj) {
		if( ComIsNull(formObj.sales_ofc) ) {
			return false;
		}
		return true;
	}
	function checkMendatoryBkgStfCd(formObj) {
		if( ComIsNull(formObj.bkg_staff) ) {
			return false;
		}
		return true;
	}
	function checkMendatorySrepCd(formObj) {
		if( ComIsNull(formObj.sales_rep) ) {
			return false;
		}
		return true;
	}
    /**
     * sheet Dbl Click Event Handling
     * @param row
     * @param col
     * @return
     */
    function sheet1_OnDblClick(sheetObj, row, col) {
	if ( col == 3 ) {
		var param="";
		var chkBkgNo=sheetObjects[0].GetCellValue(row, "bkg_no");
		if ( chkBkgNo != "" ) {
			param="?pgmNo=ESM_BKG_0079&bkg_no="+sheetObjects[0].GetCellValue(row, "bkg_no");
//			ComOpenWindowCenter("/opuscntr/ESM_BKG_0079.do" + param, "PopupEsmBkg0079", 1005, 650, false);			
			comBkgCallPopBkgDetail(sheetObjects[0].GetCellValue(row, "bkg_no"));
		}
	}
    }
	/**
	* Popup Click Event Handling
	*/
 	function sheet1_OnClick(sheetObj, Row, Col) {
		var formObject=document.form;
		var param="";
		if (sheetObj.ColSaveName(Col) == "fax_btn" || sheetObj.ColSaveName(Col) == "eml_btn") {
			if (sheetObj.GetCellValue(Row, "new_flg") == "Y" ) {
				sheetObj.SetRowHidden(Row,1);//2.Row Hidden
				sheetObj.SetRowStatus(Row,"D");//3.GetRowStatus=D
			} else {
				var Row=sheetObj.DataCopy();
				sheetObj.SetRowStatus(Row,"R");
				sheetObj.SetCellValue(Row, "fax","");
				sheetObj.SetCellValue(Row, "eml","");
				sheetObj.SetCellValue(Row, "cargo_cct_mnl","");
				sheetObj.SetCellValue(Row, "cct_mnl","");
				sheetObj.SetCellValue(Row, "doc_cct","");
				sheetObj.SetCellValue(Row, "fax_btn","");
				sheetObj.SetCellValue(Row, "eml_btn","");
				sheetObj.SetCellValue(Row, "new_flg","Y");
				sheetObj.SetCellValue(Row, "fax_result","");
				sheetObj.SetCellValue(Row, "fax_date","");
				sheetObj.SetCellValue(Row, "eml_result","");
				sheetObj.SetCellValue(Row, "eml_date","");
				sheetObj.SetCellValue(Row, "remark","");
				
				sheetObj.SetCellImage(Row, "eml_btn",1);
				sheetObj.SetCellImage(Row, "fax_btn",1);
			}
		} else if ("fax_his_btn"==sheetObj.ColSaveName(Col) && ""!=sheetObj.GetCellValue(Row,"fax_result")) {
	 		sheetMultiBtnClick(sheetObj, Row, Col);
		} else if ("eml_his_btn"==sheetObj.ColSaveName(Col) && ""!=sheetObj.GetCellValue(Row,"eml_result")) {
	 		sheetMultiBtnClick(sheetObj, Row, Col);
		}
	}
 	function sheetMultiBtnClick(sheetObject, Row, Col) {
		var formObject=document.form;
 		var bkgNo;
 		var ntcKndCd;
 		var ntcViaCd;
 		bkgNo=sheetObject.GetCellValue(Row,"bkg_no");
		ntcKndCd="BK";
 		if ("fax_his_btn"==sheetObject.ColSaveName(Col)) {
 			ntcViaCd="F";
 		} else if ("eml_his_btn"==sheetObject.ColSaveName(Col)) {
 			ntcViaCd="M";
 		}
 		ComOpenPopup("/opuscntr/ESM_BKG_1071.do?bkg_no="+bkgNo+"&ntc_knd_cd="+ntcKndCd+"&ntc_via_cd="+ntcViaCd, 715, 500, "", "1,0", true);
 	}
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
 		var bColor="#0000FF";
 		for(var i=2;i<=sheetObjects[0].RowCount()+1;i++) {
 			sheetObjects[0].SetCellFontColor(i, "bkg_no",bColor);
 		}
    	
		with(sheetObj)
		{
			SetColFontUnderline("bkg_no",1);
            for(i=2 ; i<=LastRow(); i++) {
            	if ("Failed"==GetCellValue(i,"fax_result")) {
            		SetCellFontUnderline(i,"fax_result",1);
            	} else if ("Failed"==GetCellValue(i,"eml_result")) {
            		SetCellFontUnderline(i,"eml_result",1);
                }
            	if (""!=GetCellValue(i,"fax_result")) {
            		SetCellImage(i, "fax_his_btn", 2);
                } else {
                    SetMergeCell(i,21,1,2);
                }
            	if (""!=GetCellValue(i,"eml_result")) {
                  SetCellImage(i, "eml_his_btn", 2);
                } else {
                    SetMergeCell(i,24,1,2);
                }
            	SetCellImage(i, "eml_btn", 0);
				SetCellImage(i, "fax_btn", 0);
            }
		}
		
		if(ComGetObjValue(document.form.defaultSort)=="Y"){
			sheetObj.ColumnSort("bkg_no", "ASC");
			ComSetObjValue(document.form.elements["defaultSort" ],"");
		}
	}

 	/**
 	 * RD 파라미터
 	 * @param viewType
 	 * @returns {Array}
 	 */
	function getRdData(viewType){
		var formObject = document.form;
		var sheetObj = sheetObjects[0];
		var chkRow = ComFindText(sheetObj, "slct_flg", 1);
		if ( sheetObj.GetCellValue(chkRow[0], "bkg_no") != "" ) {
			var bkgNos="";
			var bkgNos_no_quote="";
			var port_cct ="";
			var port_cct_cell ="";
			var cargo_cct ="";
			var cargo_cct_cell ="";
			var doc_cct ="";
			var remark ="";
			var por = "";
			for (var i=0; i<chkRow.length; i++) {
				if (0 > bkgNos.indexOf(sheetObj.GetCellValue(chkRow[i], "bkg_no"))) { //remove duplicate booking No. In case of duplicate, only first row can be previewed/printed.
					if(por == "") por = sheetObj.GetCellValue(chkRow[i], "por");
					
					bkgNos += "'"+sheetObj.GetCellValue(chkRow[i], "bkg_no")+"',";
					bkgNos_no_quote += sheetObj.GetCellValue(chkRow[i], "bkg_no")+",";
					
					if(sheetObj.GetCellValue(chkRow[i], "cct_mnl") !=""){
						port_cct_cell = sheetObj.GetCellValue(chkRow[i], "cct_mnl");
					}else if(sheetObj.GetCellValue(chkRow[i], "cct_cng") !=""){
						port_cct_cell = sheetObj.GetCellValue(chkRow[i], "cct_cng");
					}else{
						port_cct_cell = sheetObj.GetCellValue(chkRow[i], "cct");
					}

					port_cct += port_cct_cell+",";
	
					if(sheetObj.GetCellValue(chkRow[i], "cargo_cct_mnl") !=""){
						cargo_cct_cell = sheetObj.GetCellValue(chkRow[i], "cargo_cct_mnl");
					}else if(sheetObj.GetCellValue(chkRow[i], "cargo_cct_cng") !=""){
						cargo_cct_cell = sheetObj.GetCellValue(chkRow[i], "cargo_cct_cng");
					}else{
						cargo_cct_cell = sheetObj.GetCellValue(chkRow[i], "cargo_cct");
					}

					cargo_cct += cargo_cct_cell + ",";
					
					doc_cct += sheetObj.GetCellValue(chkRow[i], "doc_cct") +",";
					remark += sheetObj.GetCellValue(chkRow[i], "remark") + remarkSeparator;
				}
			}
			bkgNos=bkgNos.substring(0,bkgNos.length-1);
			port_cct=port_cct.substring(0,port_cct.length-1);
			doc_cct=doc_cct.substring(0,doc_cct.length-1);
			cargo_cct=cargo_cct.substring(0,cargo_cct.length-1);
			
			var rdParam=" /rp " + "["+bkgNos+"]["+formObject.usr_id.value+"][]"; //ESM_BKG_5005C needs only 3 parameters.
			if(formObject.mrd.value =="ESM_BKG_5005G"){
				rdParam +=  "["+port_cct+"]"
						  + "["+doc_cct+"]"
						  + "[Y]"						//maybe no use of this parameter
						  + "["+cargo_cct+"]"
						  + "["+bkgNos_no_quote+"]"     //the order of Booking No
						  + "[Y]"						//multi Booking No execution flag
						  + "["+encodeRemark(remark)+"]";
			}
			
			var rdUrl = "apps/opus/esm/bkg/bookingconduct/generalbookingconduct/generalbookinglistsearch/report/";
			
			var rdFile = formObject.mrd.value + ".mrd";
			var rdData = [];
			rdData.push({'rdParam' : rdParam, 'rdUrl' : rdUrl, 'rdFile' : rdFile, 'width' : 900, 'height' : 700});
		}
		
		return rdData;
	}

	   //called from edit fax/email popup
	    function getCOM_Fax_Email_POPUP(rowArray) {
	    	if (rowArray && 0<rowArray.length ) {
    	    	var faxno=rowArray[0].fax;
    	        var email=rowArray[0].email;
	 	    	var sheetObject=sheetObjects[0];
	 			var arrRow=ComFindText(sheetObject, "slct_flg", 1);
	 			if (arrRow && 0<arrRow.length) {
	 				for (var i=0; i<arrRow.length; i++) {
	 					sheetObject.SetCellValue(arrRow[i],"fax",faxno,0);
	 					sheetObject.SetCellValue(arrRow[i],"eml",email,0);
	 				}
	 			}
	     	}
	    }
	    
	    //called from edit CCT popup(0934)
	    function setCctValue(cctValue,docCctValue,cargoCctValue) {
 	    	var sheetObject=sheetObjects[0];
 			var arrRow=ComFindText(sheetObject, "slct_flg", 1);
 			if (arrRow && 0<arrRow.length) {
 				for (var i=0; i<arrRow.length; i++) {
 					if (""!=cctValue) {
 						sheetObject.SetCellValue(arrRow[i],"cct_mnl",cctValue,0);
 					}
 					if (""!=docCctValue) {
 						sheetObject.SetCellValue(arrRow[i],"doc_cct",docCctValue,0);
 					}
 					if (""!=cargoCctValue) {
 						sheetObject.SetCellValue(arrRow[i],"cargo_cct_mnl",cargoCctValue,0);
 					}
 				}
 			}
	    }
	    
	    //remark encoding
		function encodeRemark(remark) {
			return encodeURIComponent(remark).replace(/'/g,"%27");
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

	    /* Multi BKG 기능 추가 함수 END */

	    /**
	     * check if date format is yyyy-mm-dd hh:mi
	     */
	    function validateDate(strDate) {
	    	if (strDate.substr(4,1)!="-") return false;
	    	if (strDate.substr(7,1)!="-") return false;
	    	if (strDate.substr(10,1)!=" ") return false;
	    	if (strDate.substr(13,1)!=":") return false;
	    	return true;
	    }
	    
	    function sheet1_OnChange(sheetObj, row, col, val) {
	    	var col_name=sheetObj.ColSaveName(col);
	    	switch (col_name) {
		    	case "cargo_cct_mnl":
		    	case "cct_mnl":
		    	case "doc_cct":
		    		sheetObj.SetCellValue(row, col, changeDateFormat(val), 0);
		    		break;
		    		
		    	case "remark":
		    		val = rdParameterErrorCheckStr(val);
		    		sheetObj.SetCellValue(row, col, val, 0);
		    		break;
	    	}
	    }

	    /**
	     * change date format to YYYY-MM-DD HH24:MI
	     */
	    function changeDateFormat(strDate) {
	    	var retVal=strDate;
	    	if(strDate.match(/[0-9]+/)){
	    		if(strDate.length==8){
	    			retVal=strDate.substr(0,4)+"-"+strDate.substr(4,2)+"-"+strDate.substr(6,2)+" 00:00";
	    		}else if(strDate.length==12){
	    			retVal=strDate.substr(0,4)+"-"+strDate.substr(4,2)+"-"+strDate.substr(6,2)+" "+strDate.substr(8,2)+":"+strDate.substr(10,2);
	    		}
	    	}
	    	return retVal;
	    }
	    
	    function emailSend(){
	    	var formObj = document.form;
	    	formObj.f_cmd.value = MULTI02;
	    	try{
	    		var chkRowArr = sheetObjects[0].FindCheckedRow("slct_flg");
				var chkRow = chkRowArr.split("|");
				
				//comfirm change of remarks: if remark is changed, rmk_change_flg="Y"
				for (var i = 0; i < chkRow.length; i++) {
					if(sheetObjects[0].GetCellValue(chkRow[i],"remark") != sheetObjects[0].CellSearchValue(chkRow[i],"remark")){
						sheetObjects[0].SetCellValue(chkRow[i],"rmk_change_flg","Y",0);
					} else{
						sheetObjects[0].SetCellValue(chkRow[i],"rmk_change_flg","N",0);
					}
					
					sheetObjects[0].SetCellValue(chkRow[i],"remark", encodeRemark(sheetObjects[0].GetCellValue(chkRow[i],"remark")),0);
					var params = FormQueryString(formObj) + "&" + ComSetPrifix(sheetObjects[0].RowSaveStr(chkRow[i]), "sheet1_");
					sheetObjects[0].GetSaveData("ESM_BKG_0098GS.do", params);
				}
				ComShowCodeMessage("BKG00497");
				ComOpenWait(false);
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	    	}catch (e) {
	    		ComOpenWait(false);
			}
	    }