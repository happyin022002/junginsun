/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : EES_MNR_0019.js
 *@FileTitle  : Repair Estimate Creation
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/13
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class EES_MNR_0019 : business script for EES_MNR_0019.
     */
   
/* developer job	*/
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var DLCSheets=new Array();
	var DLCSheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	//IBSAVE/IBBATCH
	var saveType="";
	//real data object of sp_name combo
	var sp_name=new spNameList();
	//for previous value of sp_name combo
	var preSpNameCode="";
	//retrieve whether or not
	var selCheck=false;
	//Repair Work Type combo code
	var rwTypedefCode="";
	//file sequence variable
	var uploadFileSeq="";
	//onchange event
	var enableOnChange=true;
	//t1sheet1 event
	var dummyEvent=false;
	var sheetComboList=new Array();
	//searching location popup clicked row
	var t1sheet1ClickRow=0;
	//multi checking whether to perform validation
	var isValidNeed=true;
	//Check Tariff Flag
	var tariffChk="";
	var before_dlc="";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	var sXml_1 = "";
	var sXml_2 = "";
	var sXml_3 = "";
	var newFlg = "Y";
	var offFlg = "";
	// Event handler processing by button name */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
					break;
				case "btn_New":
					for(var i=0; i < sheetObjects.length; i++){
						if(sheetObjects[i].IsDataModified()== true){
							if(!ComShowCodeConfirm("MNR00232"))
							{
								return false;
							}
						}
					}
					preSpNameCode = combo_sp_name.GetSelectCode();
					combo_sp_name.SetSelectIndex(-1);
					
					if(newFlg == "Y"){
						doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
					}
					break;
				case "btn_Delete":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCHAPPEND);
					break;
				case "btn_Save":
//					if(beforetab == 1){
//						tab1_OnChange(tabObjects[0] , 0);
//					}
					doActionIBSheet(sheetObjects[2],formObject,IBSAVE);
					break;
				case "btn_Request":
					doActionIBSheet(sheetObjects[2],formObject,IBCREATE);
					break;
				case "btn_Print":
					if(!selCheck){
						ComShowCodeMessage("MNR00243");
					} else {
						var eqno=ComGetObjValue(formObject.rqst_eq_no);
						var seq=ComGetObjValue(formObject.rpr_rqst_seq);
						var verNo=ComGetObjValue(formObject.rpr_rqst_ver_no);
						var rdParam='/rv rqst_eq_no[' + eqno + '] rpr_rqst_seq[' + seq + '] rpr_rqst_ver_no[' + verNo + '] is_tpb[N]';
						formObject.com_mrdArguments.value=rdParam;
						formObject.com_mrdBodyTitle.value="Repair Estimate";
						ComOpenRDPopup();
					}
					break;
				case "btn_RowDel":
					doActionIBSheet(sheetObjects[2],formObject,IBDELETE);
					break;
				case "btn_RowAdd":
					doActionIBSheet(sheetObjects[2],formObject,IBINSERT);
					break;
				case "btn_DownExcel":
					if(sheetObjects[2].RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObjects[2].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[2]), SheetDesign:1,Merge:1 });
					}					
					break;
				case "btn_FileAdd":
					file_Insert(sheetObjects[10]);
					break;
				case "btn_FileDel":
					file_Remove(sheetObjects[10]);
					break;
			 	case "btns_calendar":
                	var cal=new ComCalendar();
                	cal.select(formObject.eq_dmg_dt, 'yyyy-MM-dd');
                	break;
				//yard popup up
				case "btns_popup":
                    ComOpenPopup('/opuscntr/COM_ENS_061.do', 850, 540, 'getCOM_ENS_061', '1,0,1,1,1,1,1,1,1,1,1,1', true);
                    break;
				//EQ_INFO DETAIL
				case "btn_detail":
					if(formObject.rqst_eq_no.value != ""){
						 ComOpenWindowCenter("EES_MNR_0191.do?eq_no=" + formObject.rqst_eq_no.value + "&mnr_wo_tp_cd=EST", "EES_MNR_0191", 901, 495, true);
					}
                    break;
				case "rpr_offh_flg_temp":
						doActionIBSheet(sheetObjects[2], formObject , IBSEARCH_ASYNC02);
					break;
				case "btn_calc":
						doActionIBSheet(sheetObjects[2], formObject , IBBATCH);
					break;
				case "btns_mvmt":
					openPopupMVMT();
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
     * sp_name combo object list
     */
	function spNameList(){
		this.items=[];
	}
	/**
     * sp_name combo object list
     */
	function itemEntity(vndr_seq,vndr_nm,agmt_no,agmt_ver_no,eff_dt,exp_dt,trf_no,agmt_ref_no,eq_knd_cd,curr_cd,trsm_mod_cd,edi_id,mnr_meas_ut_nm){
		this.vndr_seq=vndr_seq;
		this.vndr_nm=vndr_nm;
		this.agmt_no=agmt_no;
		this.eff_dt=eff_dt;
		this.exp_dt=exp_dt;
		this.agmt_ref_no=agmt_ref_no;
		this.trf_no=trf_no;
		this.agmt_ver_no=agmt_ver_no;
		this.eq_knd_cd=eq_knd_cd;
		this.curr_cd=curr_cd;
		this.trsm_mod_cd=trsm_mod_cd;
		this.edi_id=edi_id;
		this.mnr_meas_ut_nm=mnr_meas_ut_nm;
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
	 * registering IBTab Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	*/
	function setTabObject(tab_obj){
		tabObjects[tabCnt++]=tab_obj;
	}
	/**
	 * registering IBCombo Object as list
	 * @param	{IBMultiCombo}	combo_obj	adding ComboObject.
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
    	
    	ComOpenWait(true);
        sheetObjects[0].SetWaitImageVisible(0);		
        
        MnrWaitControl(true);
		initControl();
		//'0 ' is For the hidden data retrieval
		setTimeout( function () {
			initSheet(sheetObjects[0],1);
			DLCSheetCnt=0;
		
	        for(i=1;i < sheetObjects.length;i++){
	        	
				ComConfigSheet (sheetObjects[i]);
				initSheet(sheetObjects[i],i + 1);
	
				if(sheetObjects[i].id.substring(0,2) == "t2" && sheetObjects[i].id != "t2_sheet8"){
					DLCSheets[DLCSheetCnt++]=sheetObjects[i];
				} else {
					ComEndConfigSheet(sheetObjects[i]);
				}
	        }
			for(k=0;k < tabObjects.length;k++){
				initTab(tabObjects[k],k + 1);
				tabObjects[k].SetSelectedIndex(0);
			}
			for(k=0;k < comboObjects.length;k++){
	            initCombo(comboObjects[k],k + 1);
	        }
			
			tariffChk=MnrGetTariffFlag(sheetObjects[0]);
			initUpload();
			doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);

			sheetObjects[0].SetWaitImageVisible(1);            
	        ComOpenWait(false);
		} , 2000);
    }
    
    var pSheetObj, pRow, pCol ;
    function initUpload(){
 		upload1.Initialize({
 			SaveUrl:'/opuscntr/MNR_INTGS.do'
 			,Files:[
 			]
	 		,BeforeAddFile : function(result){
			 	return true;
			}
			,BeforeSaveStatus : function(result){ 
				var files = result.files;
	 			var fileName= files[files.length-1].GetFileName();
 				var prefix="";
 				
				pSheetObj.SetCellValue(pRow, pCol,fileName,0);
				pSheetObj.SetCellValue(pRow, prefix+ "file_dw",'1',0);
				var file_seq=pSheetObj.GetCellValue(pRow, prefix+ "file_seq");
				var file_dtl_seq=pSheetObj.GetCellValue(pRow, prefix+ "file_dtl_seq");
				if(file_dtl_seq=="") file_dtl_seq=pRow;
				var ibflag='U';
				if(file_seq == "" || uploadFileSeq != "") ibflag='I'; // saving initially, in case of not existing saved file
				if(file_seq != "" && uploadFileSeq != "") ibflag='U';
				if(uploadFileSeq != "") {
					file_seq=uploadFileSeq;
				}
				var sParam="f_cmd="+COMMAND01;
		 		sParam+= "&mnr_grp_tp_cd=RPR";       // MNR Work Group Type Code
		 		sParam+= "&file_seq=" + file_seq;    // existing File Sequence
		 		sParam+= "&file_dtl_seq=" + file_dtl_seq;    // existing File Sequence
		 		sParam+= "&org_file_nm=" + fileName; // Fileupload file name
		 		sParam+= "&ibflag=" + ibflag;        // I : initial File Upload U : File change
		 		paramToForm(sParam);

			 	return true;
			}
 			,AfterSaveStatus : function(result) {
	      		var code = result.code;
	      		if( code == 0) {
	      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
	      			uploadFileSeq=ComGetEtcData(sXml,"seqValue");
					if(uploadFileSeq != "" && uploadFileSeq != undefined){
						var fileXml=SearchFileUpload(sheetObjects[10],uploadFileSeq);
						sheetObjects[10].LoadSearchData(fileXml,{Sync:1} );
					}
	      		}else {
					ComShowMessage(result.msg);
				}
 			}
	 		,AfterAddFile:function(result){
				var files = result.files;
	 			var fileName= files[files.length-1].GetFileName();
	 			
	 			var prefix="";
 				var badFile=false;
 				
	 			var fileType=fileName.substr(fileName.lastIndexOf(".") + 1);
				fileType=fileType.toUpperCase();
				//GIF, BMP, TIFF, JPG ,XLS ,DOC, XLSX
				if(fileType != "GIF" && fileType != "BMP" && fileType != "TIFF" && fileType != "TIF" && fileType != "JPG" && fileType != "ZIP"){
					badFile=true;
				}
 			 	if(!badFile) {
 		 			pSheetObj.SetCellValue(pRow, "org_file_nm",fileName,0);
 		 			upload1.SaveStatus();
 			 	} else {
 			 		files[files.length-1].DeleteFromList();
 					ComShowCodeMessage("MNR00217");
 					return false;
 				}
 			 	
 				
			}
 		});
 	}
    
    function t2_sheet8_OnMouseMove(sheetObj, e) {
	  	  var row     = sheetObj.MouseRow(),
	        col     = sheetObj.MouseCol(),
	        info    = null;
	        if (row > 0 &&sheetObj.ColSaveName(col) == "org_file_nm") {
	           
	            info = sheetObj.GetCellElement(row, col, 1);
	            
	    		pSheetObj = sheetObj;
				pRow = row;
				pCol = col;

	            upload1.SetFileUploadElement(info);
	            
	        } 
	  }
    
    
	/**
	 * setting combo basic info
	 * @param	{IBMultiCombo}	combo_obj	ComboObject.
	 * @param	{Number}	comboNo		ComboObject tag serial number
	 * adding case as numbers of counting combos
	 */
	function initCombo (comboObj, comboNo) {
	    var formObject=document.form
	    switch(comboNo) {
			   case 1:
		           with (comboObj) {
				   	    SetTitle("S/P Name|S/P|AGMT No|Office|EQ TYPE|Effective Date|Reference No|Tariff No");
						SetColAlign(0, "left");
						SetColAlign(1, "left");
						SetColAlign(2, "center");
						SetColAlign(3, "center");
						SetColAlign(4, "left");
						SetColAlign(5, "center");
						SetColAlign(6, "left");
						SetColAlign(7, "left");
						SetColWidth(0, "200");
						SetColWidth(1, "60");
						SetColWidth(2, "90");
						SetColWidth(3, "55");
						SetColWidth(4, "70");
						SetColWidth(5, "155");
						SetColWidth(6, "140");
						SetColWidth(7, "150");
					    SetDropHeight(160);
					    SetTitleVisible(true);
			       }
	           break;
			   default :
		           with (comboObj) {
			       }
	           break;
	     }
	}
	/**
	 * initializing Tab
	 * setting Tab items.
	 */
	function initTab(tabObj , tabNo){
		switch(tabNo) {
				case 1:
					with (tabObj) {
						var cnt=0 ;
						InsertItem( "Repair Info." , "");
						InsertItem( "Image Info." , "");
					}
					break;
		}
		var formObj=document.form;
		if(eq_knd_cd.GetSelectCode()== 'U'){
			var div1=document.all.item("t2_selection1");
			var div2=document.all.item("t2_selection2");
			div1.style.display="inline";
			div2.style.display="inline";
		} else {
			var div1=document.all.item("t2_selection1");
			var div2=document.all.item("t2_selection2");
			div1.style.display="none";
			div2.style.display="none";
//			div1.style.display="inline";
//			div2.style.display="inline";
		}
	}
   /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
	var leftHeaders = [{Text:"H|T|B|G", Align:"Center"}];
	var leftHeaders2= [{Text: "L|R", Align:"Center"}];
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
        	case "sheet1":
                with (sheetObj) {
                    //setting Host information[HostIp, Port, PagePath]
                    //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				}
            case "sheet2":      // sheet2 init
				with(sheetObj){
					var HeadTitle1="|Sel|Seq.|Status|EQ Type|EQ No.|TP/SZ|Input|S/P|Estimate No.|Office|T/Amount|Status DT";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, FrozenCol:6, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
					 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
					 {Type:"Combo",     Hidden:0, Width:113,  Align:"Left",    ColMerge:1,   SaveName:"rpr_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eq_knd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Combo",     Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"mnr_inp_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"vndr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"rqst_ref_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cost_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"total_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rpr_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"eq_dmg_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rpr_offh_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_rpr_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"file_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"apro_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rpr_rqst_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rpr_rqst_ver_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rpr_dtl_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"rpr_wrk_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"auto_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"appoval_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"uppr_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					   
					InitColumns(cols);
					SetSheetHeight(162);
					SetEditable(1);
					SetColFontColor("TP","#FF0000");
					SetSelectionMode(smSelectionRow);
					SetCountPosition(0);
					//FrozenCol(4);
				}
				break;
			case "t1sheet1":      // sheet1 init
			    with(sheetObj){
					var HeadTitle1="|Sel|Seq.|Mandatory Code|Mandatory Code|Mandatory Code|Mandatory Code|Option|Cost Code|Cost Code Name|Volume|Volume|Volume|Labor|Labor|Labor|Material|Amount|Verify Result|Lessor Account|TPB Request|TPB Labor|TPB Labor|TPB Labor|TPB Material|TPB Amount";
					var HeadTitle2="|Sel|Seq.|Location|Component|Damage|Repair|Division|Cost Code|Cost Code Name|Type|QTY|Size/Square|Hour|Rate|Cost|Material|Amount|Verify Result|Lessor Account|TPB Request|Hour|Rate|Cost|TPB Material|TPB Amount";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
					 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
					 {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_loc_cd",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
					 {Type:"ComboEdit", Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eq_cmpo_cd",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"ComboEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eq_dmg_cd",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
					 {Type:"ComboEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eq_rpr_cd",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
					 {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trf_div_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",   ColMerge:1,   SaveName:"cost_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:100,   Align:"Center",   ColMerge:1,   SaveName:"cost_cd_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Combo",     Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vol_tp_cd",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"rpr_qty",                  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
					 {Type:"Int",       Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"rpr_sz_no",                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
					 {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rpr_lbr_hrs",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
					 {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rpr_lbr_rt",               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
					 {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"lbr_cost_amt",             KeyField:0,   CalcLogic:"|rpr_lbr_hrs|*|rpr_lbr_rt|",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
					 {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"mtrl_cost_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
					 {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"mnr_wrk_amt",              KeyField:0,   CalcLogic:"|lbr_cost_amt|+|mtrl_cost_amt|",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
					 {Type:"Combo",     Hidden:0, Width:140,  Align:"Left",    ColMerge:1,   SaveName:"mnr_vrfy_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"CheckBox",  Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"mnr_lr_acct_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,TrueValue:"Y", FalseValue:"N"},
					 {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,TrueValue:"Y", FalseValue:"N"},
					 {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"n3pty_bil_lbr_hrs",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
					 {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"n3pty_bil_lbr_rt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
					 {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"n3pty_lbr_cost_amt",       KeyField:0,   CalcLogic:"|n3pty_bil_lbr_hrs|*|n3pty_bil_lbr_rt|",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
					 {Type:"Text",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"n3pty_bil_mtrl_cost_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
					 {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"n3pty_bil_amt",            KeyField:0,   CalcLogic:"|n3pty_lbr_cost_amt|+|n3pty_bil_mtrl_cost_amt|",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
					 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rpr_lbr_bzc_hrs",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rpr_lbr_bzc_rt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"mnr_lbr_bzc_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"lbr_mtrl_bzc_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"mnr_agmt_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"eq_loc_cd_chk_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"eq_cmpo_cd_chk_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"eq_dmg_cd_chk_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"eq_rpr_cd_chk_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cost_dtl_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"rpr_dtl_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
					   
					InitColumns(cols);
					SetSheetHeight(242);
					SetEditable(1);
					SetEditableColorDiff(1);
					SetColFontColor("Component","#FF0000");
					SetColProperty(0 ,"eq_loc_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,"eq_cmpo_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
					SetColProperty(0 ,"eq_dmg_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
					SetColProperty(0 ,"eq_rpr_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
					SetColProperty(0 ,"trf_div_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
					SetSelectionMode(smSelectionRow);
					InitComboNoMatchText(true);
					SetShowButtonImage(2);
					SetRangeBackColor(1,3,1,13,"#555555");
					SetRangeBackColor(1,19,1,21,"#555555");
				}
				break;
            case "t2_sheet1":
            	with(sheetObj){               
	              var HeadTitle1="";
	              if(sheetObj.id == 't2_sheet1')
	            	  HeadTitle1="|1|2|3|4";
	              else
	            	  HeadTitle1="|4|3|2|1";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              var RowText="H|T|B|G";
	              var RowVals=RowText.split("|");
	              var widthVals=new Array(30,30,30,30);
	              var ColVals=HeadTitle1.split("|");
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol:0 } );
	      		
	          	  var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
	          	  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	          	  InitHeaders(headers, info);
	
	          	  var cols = [ {Type:"Text",     Hidden:0,  Width:22,   Align:"Center",  ColMerge:0,   SaveName:"Left", Focus:0 } ];
	          	  //var cols=[];
	              for(var i=0; i < 4 ; i++){
	            	  cols.push({Type:"CheckBox",  Hidden:0, Width:30,Align:"Center",  ColMerge:1,   SaveName:"DLC", TrueValue:1, FalseValue:0 });                  
                  }
	              InitColumns(cols);
	              
                  SetEditable(1);
	              SetSheetHeight(132);
	              //SetSheetWidth(150);
	              SetCountPosition(0);
	              //InitHeadColumn("Left", RowText, daCenter);
	              SetExtendLastCol(0);
	              SetSelectionMode(smSelectionCol);
	              SetFocusAfterProcess(0);
	              InitHeadColumn(leftHeaders,sheetObj);
	            }
				break;
            case "t2_sheet2":
            	with(sheetObj){               
	              var HeadTitle1="";
	              if(sheetObj.id == 't2_sheet1')
	            	  HeadTitle1="|1|2|3|4";
	              else
	            	  HeadTitle1="|4|3|2|1";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              var RowText="H|T|B|G";
	              var RowVals=RowText.split("|");
	              var widthVals=new Array(30,30,30,30);
	              var ColVals=HeadTitle1.split("|");
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol:0 } );
	      		
	          	  var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
	          	  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	          	  InitHeaders(headers, info);
	
	          	  var cols = [ {Type:"Text",     Hidden:0,  Width:22,   Align:"Center",  ColMerge:0,   SaveName:"Left" , Focus:0 } ];
	          	  //var cols=[];
	              for(var i=0; i < 4 ; i++){
	            	  cols.push({Type:"CheckBox",  Hidden:0, Width:30,Align:"Center",  ColMerge:1,   SaveName:"DLC" , TrueValue:1, FalseValue:0});                
                  }
	              InitColumns(cols);
	              
	              SetEditable(1);
	              SetSheetHeight(132);
	              //SetSheetWidth(150);
	              SetCountPosition(0);
	              //InitHeadColumn("Left", RowText, daCenter);
	              SetExtendLastCol(0);
	              SetSelectionMode(smSelectionCol);
	              SetFocusAfterProcess(0);
	              InitHeadColumn(leftHeaders,sheetObj);

	            }
				break;
            case "t2_sheet3":
            	with(sheetObj){               
	              var HeadTitle1="";
	              if(sheetObj.id == 't2_sheet3')
	            	  HeadTitle1="|0|9|8|7|6|5|4|3|2|1";
	              else
	            	  HeadTitle1="|1|2|3|4|5|6|7|8|9|0";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              var RowText="H|T|B|G";
	              var RowVals=RowText.split("|");
	              var widthVals=new Array(30,30,30,30);
	              var ColVals=HeadTitle1.split("|");
	              
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol:0 } );
	          	
	          	  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	          	  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	          	  InitHeaders(headers, info);
	
	          	  var cols = [ {Type:"Text",     Hidden:0,  Width:22,   Align:"Center",  ColMerge:0,   SaveName:"Left" , Focus:0 } ];
	              for(var i=0; i < 10 ; i++){
	            	  cols.push({Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"DLC" , TrueValue:1, FalseValue:0});
	                	                
	              }
	              InitColumns(cols);
	          		
	              SetEditable(1);
	              //InitHeadColumn("Left", RowText, daCenter);
	              SetCountPosition(0);
	              SetSelectionMode(smSelectionCol);
	              SetSheetHeight(132);
	              SetFocusAfterProcess(0);
	              InitHeadColumn(leftHeaders,sheetObj);
	            }
				break;
				
            case "t2_sheet4":
            	with(sheetObj){               
	              var HeadTitle1="";
	              if(sheetObj.id == 't2_sheet3')
	            	  HeadTitle1="|0|9|8|7|6|5|4|3|2|1";
	              else
	            	  HeadTitle1="|1|2|3|4|5|6|7|8|9|0";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              var RowText="H|T|B|G";
	              var RowVals=RowText.split("|");
	              var widthVals=new Array(30,30,30,30);
	              var ColVals=HeadTitle1.split("|");
	              
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol:0 } );
	          	
	          	  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	          	  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	          	  InitHeaders(headers, info);
	
	          	  var cols = [ {Type:"Text",     Hidden:0,  Width:22,   Align:"Center",  ColMerge:0,   SaveName:"Left" , Focus:0 } ];
	              for(var i=0; i < 10 ; i++){
	            	  cols.push({Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"DLC" , TrueValue:1, FalseValue:0});
	                              
	              }
	              InitColumns(cols);
	          		
	              SetEditable(1);
	              //InitHeadColumn("Left", RowText, daCenter);
	              SetCountPosition(0);
	              SetSelectionMode(smSelectionCol);
	              SetSheetHeight(132);
	              SetFocusAfterProcess(0);
	              InitHeadColumn(leftHeaders,sheetObj);
	            }
				break;
				
            case "t2_sheet5":
            case "t2_sheet6":
            case "t2_sheet7":
                with(sheetObj){
		              var HeadTitle1="|1|2|3|4|5|6|7|8|9|0";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              var RowText="L|R";
		              var RowVals=RowText.split("|");
		              var ColVals=HeadTitle1.split("|");
		              for(var i=0; i < 2 ; i++){
			              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      		
			              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			              InitHeaders(headers, info);
			
			              var cols = [ {Type:"Text",     Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"Left" , Focus:0 } ];
			              for(var i=0; i < 10 ; i++){
			            	  cols.push({Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"DLC" , TrueValue:1, FalseValue:0});
			                    	
	                      }
		              }
		              InitColumns(cols);
		      		
		              SetEditable(1);
		              SetSheetHeight(80);
		              //InitHeadColumn("Left", RowText, daCenter);
		              SetSelectionMode(smSelectionCol);
		              SetCountPosition(0);
		              SetFocusAfterProcess(0);
		              InitHeadColumn(leftHeaders2,sheetObj);
              }
					break;
				//file upload
			    case "t2_sheet8" :
			    	with(sheetObj){
				       var prefix="";
				       var HeadTitle1="|Photo Attachment|Photo Attachment|Photo Attachment";
				       var HeadTitle2="|Seq.|File|Download";
				       var headCount=ComCountHeadTitle(HeadTitle1);
				       SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
				       var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				       var headers = [ { Text:HeadTitle1, Align:"Center"},
				                     { Text:HeadTitle2, Align:"Center"} ];
				       InitHeaders(headers, info);
	
				       var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
				                 {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk" },
				                 {Type:"Popup",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"org_file_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
				                 {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_dw",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"file_dtl_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				        
				       InitColumns(cols);
				       SetSheetHeight(250);
				       SetEditable(1);
				       SetImageList(0,"img/ico_attach.gif");
				       SetShowButtonImage(1);
				       SetRangeBackColor(1,0,1,3,"#555555");
			        }
					break;
        }
    }
    
    /**
     * 
     */
    function openPopupMVMT(){
    	  var formObj = document.form;
          var cnmv_dt = ComGetNowInfo("ymd"); //formObj.cnmv_dt.value;
          ComOpenPopupWithTarget("/opuscntr/EES_CTM_0408_POP.do?" +
                  "p_cntrno=" + formObj.rqst_eq_no.value.substr(0,10)+ "&" +
                  "check_digit=" + formObj.rqst_eq_no.value.substr(10,11) + "&" +
                  "ctnr_tpsz_cd=" + formObj.eq_tpsz_cd.value + "&" +
                  "p_date1=" + ComGetDateAdd(cnmv_dt, "M", -6, "-", true) + "&" +
                  "p_date2=" + ComGetDateAdd(cnmv_dt, "M", 0, "-", true), 1020, 682, "", "0,1", false);
          
       }
    
	// handling process for sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			 case IBSEARCH:      //retrieving list   rqst_type
                 if(validateForm(sheetObj,formObj,sAction)){
				 	if(sheetObj.id =="sheet2"){
						var f_query='';
						f_query += 'f_cmd' + '=' + SEARCH + '&';
						f_query += 'cost_ofc_cd=' +  formObj.cost_ofc_cd.value  + '&';
						f_query += 'rqst_type=' +  formObj.rqst_type.value;
						sheetObj.DoSearch("EES_MNR_0019GS.do",f_query );
					}
				  }
                break;
			case IBROWSEARCH:      //retrieving detail
                 if(validateForm(sheetObj,formObj,sAction)){
					 	formObj.f_cmd.value=SEARCH01;
					    sParam=FormQueryString(formObj);
					    var sXml=sheetObj.GetSaveData("EES_MNR_0019GS.do", sParam);
					    sXml_1 = sXml;
					    sheetObjects[2].LoadSearchData(sXml,{Sync:0} );
						
					    
				  }
                break;
			case IBSEARCHAPPEND:      //deleting logic
                 if(validateForm(sheetObj,formObj,sAction)){
				 		saveType="REMOVE";
					 	formObj.f_cmd.value=REMOVE;
					    sParam=FormQueryString(formObj);
					    var sXml=sheetObj.GetSaveData("EES_MNR_0019GS.do", sParam);
					    sheetObjects[1].LoadSaveData(sXml);
						//the same as IBCLEAR
						MnrWaitControl(true);
						selCheck=false;
						// initializing form
						setEqInfoClear();
						//does not initialize in case of existing eq_dmg_dt value.
						var tempEqDmgDt=MnrNullToBlank(ComGetObjValue(formObj.eq_dmg_dt));
						// Each
						formObj.reset();
						//resetting value
						//formObj.rqst_type.value = "rqst_cre";
						MnrFormSetReadOnly(formObj,false,"rqst_eq_no");
						//eq_dmg_dt
						if(tempEqDmgDt == ''){
							formObj.eq_dmg_dt.value=ComGetNowInfo("ymd");
						} else {
							formObj.eq_dmg_dt.value=tempEqDmgDt;
						}
						//rqst_dt    Input Date
						formObj.rqst_dt.value=ComGetNowInfo("ymd");
						//resetting value because not initialize
						setComboValue();
//						combo_sp_name.enable=true;
//						eq_knd_cd.enable=false;
//						trsm_mod_cd.enable=false;
						combo_sp_name.SetEnable(1);
						eq_knd_cd.SetEnable(0);
						trsm_mod_cd.SetEnable(0);
						
						formObj.rpr_rqst_seq.value="";
						formObj.rpr_rqst_ver_no.value="";
						formObj.rpr_sts_cd.value="";
						//initializing sheet
						sheetObjects[2].RemoveAll();
						MnrWaitControl(false);
				  }
                break;
			case IBSAVE:        //saving
	              if(validateForm(sheetObj,formObj,sAction)){
				  		saveType="IBSAVE";
						formObj.f_cmd.value=MODIFY;
						if(uploadFileSeq != undefined){
							formObj.file_seq.value=uploadFileSeq;
						}
						var sParam=sheetObj.GetSaveString(true, true);
						//checking mandatory
						if(sParam == "" && sheetObj.IsDataModified()){
							return;
						}
						sParam=ComSetPrifix(sParam,"rqstDtl_");
					    sParam += "&" + FormQueryString(formObj);
					    var sXml=sheetObj.GetSaveData("EES_MNR_0019GS.do", sParam);
					    sXml_3 = sXml;
					    sheetObjects[1].LoadSaveData(sXml);
						
				  }
                break;
			case IBCREATE:        //Request
	              if(validateForm(sheetObj,formObj,sAction)){
				  		saveType="REQUEST";
						formObj.f_cmd.value=COMMAND02;
						var sParam='f_cmd' + '=' + COMMAND02 + '&';
						sParam += sheetObjects[1].GetSaveString(false, false, "del_chk");
						var sXml=sheetObj.GetSaveData("EES_MNR_0019GS.do", sParam);
						sheetObjects[1].LoadSaveData(sXml);
						//the same as IBCLEAR
						MnrWaitControl(true);
						selCheck=false;
						// initializing form
						setEqInfoClear();
						//does not initialize in case of existing eq_dmg_dt value.
						var tempEqDmgDt=MnrNullToBlank(ComGetObjValue(formObj.eq_dmg_dt));
						// Each
						formObj.reset();
						//resetting value
						MnrFormSetReadOnly(formObj,false,"rqst_eq_no");
						//eq_dmg_dt
						if(tempEqDmgDt == ''){
							formObj.eq_dmg_dt.value=ComGetNowInfo("ymd");
						} else {
							formObj.eq_dmg_dt.value=tempEqDmgDt;
						}
						//rqst_dt    Input Date
						formObj.rqst_dt.value=ComGetNowInfo("ymd");
						//resetting value because not initialize
						setComboValue();
//						combo_sp_name.enable=true;
//						eq_knd_cd.enable=false;
//						trsm_mod_cd.enable=false;
						combo_sp_name.SetEnable(1);
						eq_knd_cd.SetEnable(0);
						trsm_mod_cd.SetEnable(0);
						formObj.rpr_rqst_seq.value="";
						formObj.rpr_rqst_ver_no.value="";
						formObj.rpr_sts_cd.value="";
						//initializing sheet
						sheetObjects[2].RemoveAll();
						MnrWaitControl(false);
				  }
                break;
			 case IBBATCH:        //calc
              if(validateForm(sheetObj,formObj,sAction)){
			  	 	saveType="IBBATCH";
					formObj.f_cmd.value=COMMAND01;
					var sParam=sheetObj.GetSaveString(true, true);
					//checking mandatory
					if(sParam == "" && sheetObj.IsDataModified()){
						return;
					}
					sParam=ComSetPrifix(sParam,"rqstDtl_");
				    sParam += "&" + FormQueryString(formObj);
				    var sXml=sheetObj.GetSaveData("EES_MNR_0019GS.do", sParam);
				    sXml_2 = sXml;
					sheetObj.LoadSaveData(sXml);
					
			  }
                break;
			 case IBINSERT:
			    if(validateForm(sheetObj,formObj,sAction)) {
				    var Row=sheetObj.DataInsert(-1);
					//set Value Init
					sheetObj.SetCellValue(Row, "eq_cmpo_cd","",0);//Component
					sheetObj.SetCellValue(Row, "eq_dmg_cd","",0);//DMG
					sheetObj.SetCellValue(Row, "eq_rpr_cd","",0);//Repair
					sheetObj.SetCellValue(Row, "trf_div_cd"," ",0);//Div
					sheetObj.SetCellValue(Row, "mnr_vrfy_tp_cd","",0);//Result
					
					//set Focus
					//Editable
					setInitSheetEdit(sheetObj,Row);
					sheetObj.SelectCell(Row, 1);
				}
                break;
			 case IBDELETE:
				 if(validateForm(sheetObj,formObj,sAction)) {	
					 MnrRowDelete(sheetObj,  "del_chk");
				 }
			 	break;
			 case IBCLEAR:      //initializing
			 	MnrWaitControl(true);
			 	//initializing variable
				selCheck=false;
				uploadFileSeq="";
				// initializing form
				setEqInfoClear();
				//does not initialize in case of existing eq_dmg_dt value.
				var tempEqDmgDt=MnrNullToBlank(ComGetObjValue(formObj.eq_dmg_dt));
				// Each
				formObj.reset();
				//resetting value
				MnrFormSetReadOnly(formObj,false,"rqst_eq_no");
				//initializing sheet
				sheetObjects[2].RemoveAll();
				sheetObjects[1].RemoveAll();
				sheetObjects[10].RemoveAll();
				//sheetObjects[2].SetSumText(0,"eq_loc_cd","TOTAL");
				for(var i=0; i < comboObjects.length;i++){
					if(i != 0){
						comboObjects[i].SetSelectCode("-1");
						comboObjects[i].RemoveAll();
					}
				}
//				combo_sp_name.enable=true;
//				eq_knd_cd.enable=false;
//				trsm_mod_cd.enable=false;
				combo_sp_name.SetEnable(1);
				eq_knd_cd.SetEnable(0);
				trsm_mod_cd.SetEnable(0);
				//retrieving common combo.
				var sCondition=new Array (
					new Array("MnrGenCd","CD00016", "COMMON"),
					new Array("MnrGenCd","CD00018", "COMMON"),
					new Array("MnrGenCd","","CUSTOM9"),
					//setting combo of sheetObjects[1] HDR LIST
					new Array("MnrGenCd","CD00008", "COMMON"),
					new Array("MnrGenCd","CD00019", "COMMON"),
					new Array("MnrGenCd","CD00002", "COMMON"),
					//setting combo of sheetObjects[2] HDR LIST
					new Array("MnrCedexOthCd","RPR","COMMON"), 	//Repair
					new Array("MnrCedexOthCd","DMG","COMMON"), 	//Demage
					new Array("MnrGenCd","CD00013", "COMMON"),	//Type
					new Array("MnrGenCd","CD00004", "COMMON"),	//Error code
					new Array("MnrEqCmpoCd","3","COMMON") 		//Component
				)
				var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
				//1	TRSM_MOD_CD
				if(comboList[0] != null){
					for(var j=0; j < comboList[0].length;j++){
						var tempText=comboList[0][j].split("|");
						trsm_mod_cd.InsertItem(j, tempText[1] ,tempText[0].toString());
					}
				}
				trsm_mod_cd.SetSelectCode("");
				//2	REPAIR WORK TYPE CODE
				if(rpr_wrk_tp_cd.GetItemCount() == 0){
					if(comboList[1] != null){
						for(var j=0; j < comboList[1].length;j++){
							var tempText=comboList[1][j].split("|");
							rpr_wrk_tp_cd.InsertItem(j, tempText[1] ,tempText[0]);
							if(j == 0){
								rwTypedefCode=tempText[0];
							}
						}
						rpr_wrk_tp_cd.SetSelectCode(rwTypedefCode);
			        }
				}
				//3	EQ_TYPE
				if(comboList[2] != null){
					for(var j=0; j < comboList[2].length;j++){
						var tempText=comboList[2][j].split("|");
						eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0].toString());
					}
				}
				eq_knd_cd.SetSelectCode("");
				//setting combo of sheet1,sheet2
				var sheetComboCode="";
				var sheetComboText="";
				var sheetComboCodeText="";
				//saving DEF value
				var sheetComboDefault=new Array();
				var comboSaveNames=new Array();
				//sheet1
				comboSaveNames[0]="rpr_sts_cd";
				comboSaveNames[1]="mnr_inp_tp_cd";
				comboSaveNames[2]="eq_knd_cd";
				//sheet2
				comboSaveNames[3]="eq_rpr_cd";
				comboSaveNames[4]="eq_dmg_cd";
				comboSaveNames[5]="vol_tp_cd";
				comboSaveNames[6]="mnr_vrfy_tp_cd";
				comboSaveNames[7]="eq_cmpo_cd";
				for(var i=3; i < comboList.length;i++){
					if(i >= 6){
						sheetComboList[i - 6]=comboList[i];
					}
					if(comboList[i] != null){
						sheetComboText="";
						sheetComboCode="";
						sheetComboCodeText="";
				 		for(var j=0; j < comboList[i].length;j++){
							var tempText=comboList[i][j].split("|");
							sheetComboCode +=  tempText[0] + "|";
							sheetComboText +=  tempText[1] + "|";
							sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
							if(j == 0){
								sheetComboDefault[i - 3]=tempText[0];
							}
						}
						sheetComboCode=MnrDelLastDelim(sheetComboCode);
				     	sheetComboText=MnrDelLastDelim(sheetComboText);
				        sheetComboCodeText=MnrDelLastDelim(sheetComboCodeText);
						if(comboSaveNames[i - 3] == "rpr_sts_cd"){
							sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 3], sheetComboText, sheetComboCode ,sheetComboDefault[i - 3]);
						} else if(comboSaveNames[i - 3] == "mnr_inp_tp_cd"){
							sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 3], sheetComboText, sheetComboCode ,sheetComboDefault[i - 3]);
						} else if(comboSaveNames[i - 3] == "eq_knd_cd"){
							sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 3], sheetComboText, sheetComboCode ,sheetComboDefault[i - 3]);
						} else if(comboSaveNames[i - 3] == "vol_tp_cd"){
							sheetObjects[2].InitDataCombo (0, comboSaveNames[i - 3], sheetComboText, sheetComboCode ,sheetComboDefault[i - 3]);
						} else if(comboSaveNames[i - 3] == "mnr_vrfy_tp_cd"){
							sheetObjects[2].InitDataCombo (0, comboSaveNames[i - 3], sheetComboText, sheetComboCode ,sheetComboDefault[i - 3]);
						} else if(comboSaveNames[i - 3] == "eq_rpr_cd"){
							//sheetObjects[2].InitDataCombo (0, comboSaveNames[i - 3], sheetComboCodeText, sheetComboCode ,sheetComboDefault[i - 3]);
						} else if(comboSaveNames[i - 3] == "eq_dmg_cd"){
							sheetObjects[2].InitDataCombo (0, comboSaveNames[i - 3], sheetComboCodeText, sheetComboCode ,sheetComboDefault[i - 3]);
						} else if(comboSaveNames[i - 3] == "eq_cmpo_cd"){
							//sheetObjects[2].InitDataCombo (0, comboSaveNames[i - 3], sheetComboCodeText, sheetComboCode ,sheetComboDefault[i - 3]);
						}
					}
				}
				//0 trsm_mod_cd|1 vndr_seq|2 agmt_ref_no|3 eq_type_name|4 agmt_ofc_cty_cd|5 agmt_dt|6 agmt_seq|7 agmt_rmk|8 vndr_nm|9 agmt_no|10 agmt_type_tpsz|11 pagerows|12 agmt_ver_no|13 eff_dt|14 curr_cd|15 exp_dt|16 ibflag|17 cre_dt|18 upd_usr_id|19 delt_flg|20 agmt_prifix|21 pay_term_dys|22 edi_id|23 cre_usr_id|24 agmt_lst_ver_flg|25 trf_no|26 isversionup|27 agmt_display_type|28 eq_knd_cd|29 mnr_meas_ut_nm|30 agmt_ofc_cd|31 upd_dt
				//Service Provider Combo
				//retrieving in case of not existing value
				if(combo_sp_name.GetItemCount() == 0){
					combo_sp_name.SetSelectCode("-1");
					combo_sp_name.RemoveAll();
					var sXml=MnrAGMTHdrCombo(sheetObj,formObj.cost_ofc_cd.value);
					var arrResult=MnrXmlToArray(sXml);
					if(arrResult != null){
						for(var i=0; i < arrResult.length;i ++){
							sp_name.items.push(
								new itemEntity(arrResult[i][1],arrResult[i][8],arrResult[i][9],arrResult[i][12],arrResult[i][13],arrResult[i][15],arrResult[i][25],arrResult[i][2],arrResult[i][28],arrResult[i][14],arrResult[i][0],arrResult[i][22],arrResult[i][29])
							);
							var tempComboText=arrResult[i][8] + "|" + arrResult[i][1] + "|" + arrResult[i][9] + "|" + arrResult[i][30] + "|" + arrResult[i][3] + "|" + arrResult[i][13] + " ~ " + arrResult[i][15] + "|" + arrResult[i][2] + "|" + " " + arrResult[i][25];
							combo_sp_name.InsertItem(i, tempComboText ,String(i));
						}
					} else {
						ComShowCodeMessage("MNR00056");
					}
					combo_sp_name.SetSelectCode("");
					preSpNameCode="";
				} else {
					var formObj=document.form;
					if(combo_sp_name.GetSelectCode()!= ""){
						var selectedIndex=parseInt(combo_sp_name.GetSelectCode());
						formObj.trf_no.value=sp_name.items[selectedIndex].trf_no;
						formObj.curr_cd.value=sp_name.items[selectedIndex].curr_cd;
						formObj.edi_id.value=sp_name.items[selectedIndex].edi_id;
						eq_knd_cd.SetSelectCode(sp_name.items[selectedIndex].eq_knd_cd);
						trsm_mod_cd.SetSelectCode(sp_name.items[selectedIndex].trsm_mod_cd);
						formObj.vndr_seq.value=sp_name.items[selectedIndex].vndr_seq;
						formObj.mnr_meas_ut_nm.value=sp_name.items[selectedIndex].mnr_meas_ut_nm;
						var agmtNo=sp_name.items[selectedIndex].agmt_no;
						formObj.agmt_ofc_cty_cd.value=agmtNo.substring(0,3);
						formObj.agmt_seq.value=parseInt(agmtNo.substring(3,agmtNo.length),10);
						formObj.agmt_ver_no.value=sp_name.items[selectedIndex].agmt_ver_no;
						preSpNameCode=combo_sp_name.GetSelectCode();
					}
				}
				//EQ_DMG_DT
				if(tempEqDmgDt == ''){
					formObj.eq_dmg_dt.value=ComGetNowInfo("ymd");
				} else {
					formObj.eq_dmg_dt.value=tempEqDmgDt;
				}
				//RQST_DT    Input Date
				formObj.rqst_dt.value=ComGetNowInfo("ymd");
				formObj.rpr_rqst_seq.value="";
				formObj.rpr_rqst_ver_no.value="";
				formObj.rpr_sts_cd.value="";
				setDLC(sheetObjects[2]);
				ComBtnDisable("btns_mvmt");
				MnrWaitControl(false);
				break;
				case IBSEARCH_ASYNC01:	//retrieving(validation in case of inputting EQ No)
				if ( validateForm(sheetObj, formObj, sAction) ) {
					// checing EQ_TYPE first
					if(eq_knd_cd.GetSelectCode()== ""){
						ComShowCodeMessage("MNR00198",checkEqn,"EQ No.");
						ComSetObjValue(formObj.rqst_eq_no, "");
						eq_knd_cd.focus();
						return;
					} else {
						var checkEqn=formObj.rqst_eq_no.value;
						var retArray=MnrGeneralCodeCheck(sheetObj,"ESTEQN",checkEqn + "," + eq_knd_cd.GetSelectCode());
						if(retArray == null){
							ComShowCodeMessage("MNR00165",checkEqn,"EQ No.");
							ComSetObjValue(formObj.rqst_eq_no, "");
							setEqInfoClear();
							ComSetFocus(formObj.rqst_eq_no);
							return;
						} else {
							// showing EQ_NUMBER Equipment Information
							setEqInfo(sheetObj,eq_knd_cd.GetSelectCode(),formObj.rqst_eq_no.value,ComGetNowInfo("ymd"),true);
							//WarrantyAlert
							if(eq_knd_cd.GetSelectCode()== "U"){
								var sXml=MnrWarrantyAlertInfo(sheetObj,formObj.rqst_eq_no.value);
								if(!MnrIsEmptyXml(sXml)){
									ComOpenWindowCenter("EES_MNR_0213.do?eq_no=" + formObj.rqst_eq_no.value, "EES_MNR_0213", 499, 258, true);
									document.getElementById("Warranty").innerHTML="Y";
								} else {
									document.getElementById("Warranty").innerHTML="N";
								}
							}
							return;
						}
					}
				}
				break;
				case IBSEARCH_ASYNC02:	// in case of changing off-hire
						var endPoint=sheetObj.LastRow()- 1;
						for(var Row=2; Row <= endPoint;Row++){
							//setting mnr_lr_acct_flg
							if(formObj.rpr_offh_flg_temp.checked == true){
								formObj.rpr_offh_flg.value="Y";
								setInitSheetEdit(sheetObj,Row);
								//Initialize all possible input values​​.
								sheetObj.SetCellValue(Row ,"rpr_lbr_hrs","",0);
								sheetObj.SetCellValue(Row ,"rpr_lbr_rt","",0);
								sheetObj.SetCellValue(Row ,"lbr_cost_amt","",0);
								sheetObj.SetCellValue(Row ,"mtrl_cost_amt","",0);
								sheetObj.SetCellValue(Row ,"mnr_wrk_amt","",0);
								sheetObj.SetCellValue(Row ,"n3pty_flg","0",0);
								sheetObj.SetCellValue(Row ,"n3pty_bil_lbr_hrs","",0);
								sheetObj.SetCellValue(Row ,"n3pty_bil_lbr_rt","",0);
								sheetObj.SetCellValue(Row ,"n3pty_lbr_cost_amt","",0);
								sheetObj.SetCellValue(Row ,"n3pty_bil_mtrl_cost_amt","",0);
								sheetObj.SetCellValue(Row ,"n3pty_bil_amt","",0);
								sheetObj.SetCellValue(Row ,"mnr_vrfy_tp_cd","",0);
								offFlg = "Y";
							} else {
								formObj.rpr_offh_flg.value="N";
								setInitSheetEdit(sheetObj,Row);
								//Initialize all possible input values​​.
								sheetObj.SetCellValue(Row ,"rpr_lbr_hrs","",0);
								sheetObj.SetCellValue(Row ,"rpr_lbr_rt","",0);
								sheetObj.SetCellValue(Row ,"lbr_cost_amt","",0);
								sheetObj.SetCellValue(Row ,"mtrl_cost_amt","",0);
								sheetObj.SetCellValue(Row ,"mnr_wrk_amt","",0);
								sheetObj.SetCellValue(Row ,"n3pty_flg","0",0);
								sheetObj.SetCellValue(Row ,"n3pty_bil_lbr_hrs","",0);
								sheetObj.SetCellValue(Row ,"n3pty_bil_lbr_rt","",0);
								sheetObj.SetCellValue(Row ,"n3pty_lbr_cost_amt","",0);
								sheetObj.SetCellValue(Row ,"n3pty_bil_mtrl_cost_amt","",0);
								sheetObj.SetCellValue(Row ,"n3pty_bil_amt","",0);
								sheetObj.SetCellValue(Row ,"mnr_vrfy_tp_cd","",0);
								offFlg = "N";
							}
							var checkCompCd=sheetObj.GetCellValue(Row,"eq_cmpo_cd").toUpperCase();
							if(ComGetObjValue(formObj.eq_tpsz_cd) != "" && checkCompCd != ""){
								var costCdSet=MnrGetCostCd(sheetObj,eq_knd_cd.GetSelectCode(),formObj.eq_tpsz_cd.value,checkCompCd, offFlg);
								var arrCostCd = costCdSet.split("|");
								sheetObj.SetCellValue(Row,"cost_cd",arrCostCd[0],0);
								sheetObj.SetCellValue(Row,"cost_cd_nm",arrCostCd[1],0);
								if(offFlg == "Y"){
									sheetObj.SetCellValue(Row,"cost_dtl_cd","OF",0);
								}else{
									sheetObj.SetCellValue(Row,"cost_dtl_cd","NR",0);
								}
							}
						}
				break;
				case IBSEARCH_ASYNC03:	//retrieving(validation in case of inputting YARD)
				if ( validateForm(sheetObj, formObj, sAction) ) {
						var checkYard=formObj.rpr_yd_cd.value;
						retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
						if(retArray == null){
							ComShowCodeMessage("MNR00165",checkYard,"YARD");
							ComSetObjValue(formObj.rpr_yd_cd, "");
							ComSetFocus(formObj.rpr_yd_cd);
						} else {
							return;
						}
				}
				break;
		}
    }
	 /**
     * adding row to tab of IBSheet. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return {nothing}
     **/
	function file_Insert(sheetObj){
		//**** Modify header, depending on the number of  CellValue(2,"file_seq");
		uploadFileSeq=sheetObj.GetCellValue(2,"file_seq");
		if(uploadFileSeq == undefined || uploadFileSeq == -1){
			uploadFileSeq="";
		}
		for(var j=2; j <= sheetObj.LastRow();j++){
			if (sheetObj.GetCellValue(j,"org_file_nm") == ""){
					ComShowMessage(ComGetMsg('MNR00024'));
					sheetObj.SelectCell(j,"org_file_nm");
					return;
			}
		}
		var row=sheetObj.DataInsert(-1);
	}
	function file_Remove(sheetObj) {
		if(sheetObj.FindCheckedRow("del_chk") != ""){
			RemoveFileUpload(sheetObj);
		} else {
			ComShowCodeMessage("MNR00150");
		}
	}
	/**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        if(isValidNeed == true){
	        	switch(sAction) {
					case IBROWSEARCH:
						if (!ComChkValid(formObj)) return false;
					 	break;
					//deleting
					case IBSEARCHAPPEND:
						setComboValue();
						if(!selCheck){
							ComShowCodeMessage("MNR00054");
							return false;
						}
						// in case of not selected Service Provider
						if(combo_sp_name.GetSelectCode()== ""){
							ComShowCodeMessage("MNR00036","Service Provider ");
							combo_sp_name.focus();
							return false;
						}
						if (!ComChkValid(formObj)) return false;
						//checking whether deleting
						if (!ComShowCodeConfirm("MNR00026")){return false;}
						break;
					case IBCREATE:	//request
						if(sheetObjects[1].FindCheckedRow("del_chk") == ""){
 							ComShowCodeMessage("MNR00036","Request");
							return false;
 						}
						//checking whether RUQUEST
						if (!ComShowCodeConfirm("MNR00275","Estimate","Request")){return false;}
						break;
					case IBSAVE:    //saving
						setComboValue();
						// in case of not selected Service Provider
						if(comboObjects[0].GetSelectCode()== ""){
							ComShowCodeMessage("MNR00036","Service Provider ");
							combo_sp_name.focus();
							return false;
						}
						// in case of not selected Repair Status
						if(rpr_wrk_tp_cd.GetSelectCode()== ""){
							ComShowCodeMessage("MNR00036","Repair Status ");
							rpr_wrk_tp_cd.focus();
							return false;
						}
						//checking Q'ty,Size/Square(per VolumnType of sheet)
						if(sheetObj.RowCount()>= 1) {
							for(var j=2; j <= sheetObj.LastRow()- 1; j++) {
								var volTpCd=sheetObj.GetCellValue(j, "vol_tp_cd");	//Type
								var rprQty=sheetObj.GetCellValue(j, "rpr_qty");		//Q'ty
								var rprSzNo=sheetObj.GetCellValue(j, "rpr_sz_no");	//Size/Square
								//Q'ty
								if(volTpCd == 'Q') {
									if(rprQty < 1){
										ComShowCodeMessage("MNR00175",(j - 1) + " row\'s Q'ty");
										sheetObj.SelectCell(j, "rpr_qty", true);
										return false;
									}
								}
								//Size/Square
								else {
									if(rprSzNo < 1){
										ComShowCodeMessage("MNR00175",(j - 1) + " row\'s Size/Square");
										sheetObj.SelectCell(j, "rpr_sz_no", true);
										return false;
									}
								}
								var n3ptyFlg=sheetObj.GetCellValue(j, "n3pty_flg");
								var n3mcost=sheetObj.GetCellValue(j, "n3pty_bil_mtrl_cost_amt");
								var n3rt=sheetObj.GetCellValue(j, "n3pty_bil_lbr_rt");
								var n3hrs=sheetObj.GetCellValue(j, "n3pty_bil_lbr_hrs");
								if(n3ptyFlg == "1"){
									if(n3mcost == ""){
										ComShowCodeMessage("MNR00003");
										sheetObj.SelectCell(j, "n3pty_bil_mtrl_cost_amt", true);
										return false;
									} else if(n3rt == ""){
										ComShowCodeMessage("MNR00003");
										sheetObj.SelectCell(j, "n3pty_bil_lbr_rt", true);
										return false;
									} else if(n3hrs == ""){
										ComShowCodeMessage("MNR00003");
										sheetObj.SelectCell(j, "n3pty_bil_lbr_hrs", true);
										return false;
									}
								}
							}
						} else {
							ComShowCodeMessage("MNR00207");
							return false;
						}
						if(sheetObjects[2].IsDataModified()){
							ComShowCodeMessage("MNR00333");
							return false;
						}
//						if(beforetab == 1){
//							var 
//							if(before_dlc != ComGetObjValue(form.damageLocationCode)){
//								
//								ComShowCodeMessage("MNR00370");
//								return false;
//							}
//						}
						//checking form mandatory
						if (!ComChkValid(formObj)) return false;
						//checking TPB Amount
						if(!checkTpbAmount()) return false;
						//checking whether saving
						if (!ComShowCodeConfirm("MNR00160","Estimate")){return false;}
						break;
					case IBBATCH:
						// in case of not selected Service Provider
						if(document.form.combo_sp_name_text.value== ""){
							ComShowCodeMessage("MNR00036","Service Provider ");
							combo_sp_name.focus();
							return false;
						}
						//checking Q'ty,Size/Square(per VolumnType of sheet)
						if(sheetObj.RowCount()>= 1) {
							for(var j=2; j <= sheetObj.LastRow()- 1; j++) {
								var volTpCd=sheetObj.GetCellValue(j, "vol_tp_cd");	//Type
								var rprQty=sheetObj.GetCellValue(j, "rpr_qty");		//Q'ty
								var rprSzNo=sheetObj.GetCellValue(j, "rpr_sz_no");	//Size/Square
								//Q'ty
								if(volTpCd == 'Q') {
									if(rprQty < 1){
										ComShowCodeMessage("MNR00175",(j - 1) + " row\'s Q'ty");
										sheetObj.SelectCell(j, "rpr_qty", true);
										return false;
									}
								}
								//Size/Square
								else {
									if(rprSzNo < 1){
										ComShowCodeMessage("MNR00175",(j - 1) + " row\'s Size/Square");
										sheetObj.SelectCell(j, "rpr_sz_no", true);
										return false;
									}
								}
							}
						} else {
							ComShowCodeMessage("MNR00207");
							return false;
						}
						//checking form mandatory
						if (!ComChkValid(formObj)) return false;
						break;
					case IBINSERT:
						if(MnrNullToBlank(ComGetObjValue(formObj.rqst_eq_no)) == ''){
							ComShowCodeMessage("MNR00226");
							return false;
						}
						break;
					case IBDELETE:
						if(sheetObj.RowCount()< 1) {
							ComShowCodeMessage("MNR00024");
							return;
						}
						break;
				}
		}
		return true;
    }
	//retrieving detail event
	function sheet2_OnDblClick(sheetObj,Row,Col)
    {
		var formObj=document.form;
		for(var i=0; i < sheetObjects.length; i++){
			if(sheetObjects[i].IsDataModified()== true){
				if(!ComShowCodeConfirm("MNR00007"))
				{
					return false;
				}
			}
		}
		with(sheetObj){
			//setting agreement number on the left
			combo_sp_name.SetEnable(0);
			var agmtNo=GetCellValue(Row,"agmt_ofc_cty_cd") + ComLpad(GetCellValue(Row,"agmt_seq"), 6, "0");
			var agmtVerNo=GetCellValue(Row,"agmt_ver_no");
			for(var i=0;i < sp_name.items.length; i++){
				if(sp_name.items[i].agmt_no == agmtNo){
					if(sp_name.items[i].agmt_ver_no != agmtVerNo){
						ComShowCodeMessage("MNR00218");
					}
					combo_sp_name.SetSelectCode(String(i));
					break;
				}
    		}
			//setting header
			//setting hiddein key value
			formObj.rpr_rqst_seq.value=GetCellValue(Row,"rpr_rqst_seq");
			formObj.rpr_rqst_ver_no.value=GetCellValue(Row,"rpr_rqst_ver_no");
			formObj.rpr_sts_cd.value=GetCellValue(Row,"rpr_sts_cd");
			formObj.apro_ofc_cd.value=GetCellValue(Row,"apro_ofc_cd");
			MnrFormSetReadOnly(formObj,true,"rqst_eq_no");
			ComSetObjValue(formObj.rqst_eq_no, GetCellValue(Row,"rqst_eq_no"));
			ComSetObjValue(formObj.rqst_ref_no, GetCellValue(Row,"rqst_ref_no"));
			ComSetObjValue(formObj.rpr_yd_cd, GetCellValue(Row,"rpr_yd_cd"));
			ComSetObjValue(formObj.rpr_dtl_sts_cd, GetCellValue(Row,"rpr_dtl_sts_cd"));
			ComSetObjValue(formObj.mnr_inp_tp_cd, GetCellValue(Row,"mnr_inp_tp_cd"));
			//Repair Status
			rpr_wrk_tp_cd.SetSelectCode(GetCellValue(Row,"rpr_wrk_tp_cd"));
			ComSetObjValue(rpr_wrk_tp_cd, GetCellValue(Row,"rpr_wrk_tp_cd"));
			ComSetObjValue(formObj.eq_dmg_dt, GetCellValue(Row,"eq_dmg_dt"));
			if(GetCellValue(Row,"rpr_offh_flg") == 'Y'){
				formObj.rpr_offh_flg.value='Y';
				formObj.rpr_offh_flg_temp.checked=true;
			} else {
				formObj.rpr_offh_flg.value='N';
				formObj.rpr_offh_flg_temp.checked=false;
			}
			ComSetObjValue(formObj.mnr_rpr_rmk, GetCellValue(Row,"mnr_rpr_rmk"));
			//for checking APPROVAL
			ComSetObjValue(formObj.auto_amt, GetCellValue(Row,"auto_amt"));
			ComSetObjValue(formObj.appoval_amt, GetCellValue(Row,"appoval_amt"));
			ComSetObjValue(formObj.uppr_ofc_cd, GetCellValue(Row,"uppr_ofc_cd"));
			// showing EQ_NUMBER Equipment Information
			setEqInfo(sheetObj,eq_knd_cd.GetSelectCode(),formObj.rqst_eq_no.value,ComGetNowInfo("ymd"),false);
			//WarrantyAlert
			if(eq_knd_cd.GetSelectCode()== "U"){
				var sXml=MnrWarrantyAlertInfo(sheetObj,formObj.rqst_eq_no.value);
				if(!MnrIsEmptyXml(sXml)){
					ComOpenWindowCenter("EES_MNR_0213.do?eq_no=" + formObj.rqst_eq_no.value, "EES_MNR_0213", 499, 258, true);
					document.getElementById("Warranty").innerHTML="Y";
				} else {
					document.getElementById("Warranty").innerHTML="N";
				}
			}
			//select status
			selCheck=true;
			tabObjects[0].SetSelectedIndex(0);
			//initializing sheet
			sheetObjects[2].RemoveAll();
			sheetObjects[10].RemoveAll();
			//retrieving file list
			var fileSeq=GetCellValue(Row,"file_seq");
			if(fileSeq != "" && fileSeq != null){
				var fileXml=SearchFileUpload(sheetObjects[10],fileSeq);
				if(!MnrIsEmptyXml(fileXml)){
					sheetObjects[10].LoadSearchData(fileXml,{Sync:1} );
				}
			}
			//retrieving detail
			doActionIBSheet(sheetObjects[2],formObj,IBROWSEARCH);
			return;
		}
    }
	//************************* EVENT SECTION ************************//
	function setComboValue(){
		var formObj=document.form;
		var selectedIndex=parseInt(combo_sp_name.GetSelectIndex());
		if(selectedIndex != -1){
			formObj.trf_no.value=sp_name.items[selectedIndex].trf_no;
			formObj.curr_cd.value=sp_name.items[selectedIndex].curr_cd;
			formObj.edi_id.value=sp_name.items[selectedIndex].edi_id;
			formObj.mnr_meas_ut_nm.value=sp_name.items[selectedIndex].mnr_meas_ut_nm;
			eq_knd_cd.SetSelectCode(sp_name.items[selectedIndex].eq_knd_cd);
			trsm_mod_cd.SetSelectCode(sp_name.items[selectedIndex].trsm_mod_cd);
			formObj.vndr_seq.value=sp_name.items[selectedIndex].vndr_seq;
			var agmtNo=sp_name.items[selectedIndex].agmt_no;
			formObj.agmt_ofc_cty_cd.value=agmtNo.substring(0,3);
			formObj.agmt_seq.value=parseInt(agmtNo.substring(3,agmtNo.length),10);
			formObj.agmt_ver_no.value=sp_name.items[selectedIndex].agmt_ver_no;
		} else {
			formObj.trf_no.value="";
			formObj.curr_cd.value="";
			formObj.edi_id.value="";
			eq_knd_cd.SetSelectCode("");
			trsm_mod_cd.SetSelectCode("");
  			formObj.vndr_seq.value="";
			formObj.agmt_ofc_cty_cd.value="";
			formObj.agmt_seq.value="";
			formObj.agmt_ver_no.value="";
			formObj.mnr_meas_ut_nm.value="";
		}
	}
	/**
	 * Event when clicking Tab
	 * activating selected tab items.
	 */
	function tab1_OnChange(tabObj , nItem){
		formObj=document.form;
		if(eq_knd_cd.GetSelectCode()== "U"){
			// deleting in case of not existing values
			var sp=sheetObjects[2].LastRow()- 1;
			for(var j=sp; j > 1;j--){
				if(sheetObjects[2].GetCellValue(j,"eq_loc_cd") == ""){
					sheetObjects[2].RowDelete(j, false);  	//completely delete
				} else {
					if(nItem == 0) {
						sheetObjects[2].SetCellValue(j,"del_chk","1",0);
					}
				}
			}
			if(nItem == 0) {
				var tDmgLocCds=ComGetObjValue(form.damageLocationCode).split("/");
				for(var i=0;i < tDmgLocCds.length;i++){
					var serchRow=sheetObjects[2].FindText("eq_loc_cd",tDmgLocCds[i]);
					//adding in case of not existing
					if(serchRow == -1){
						var Row=sheetObjects[2].DataInsert(-1);
						//set Value Init
						sheetObjects[2].SetCellValue(Row, "eq_loc_cd",tDmgLocCds[i]);//Component
						sheetObjects[2].SetCellValue(Row, "eq_cmpo_cd","",0);//Component
						sheetObjects[2].SetCellValue(Row, "eq_dmg_cd","",0);//DMG
						sheetObjects[2].SetCellValue(Row, "eq_rpr_cd","",0);//Repair
						sheetObjects[2].SetCellValue(Row, "trf_div_cd"," ",0);//Div
						sheetObjects[2].SetCellValue(Row, "mnr_vrfy_tp_cd","",0);//Result
						
						//Editable
						setInitSheetEdit(sheetObjects[2],Row);
						verifyCheck=false;
					} else {
						for(var j=2;j < sheetObjects[2].LastRow();j++ ){
							if(sheetObjects[2].GetCellValue(j,"eq_loc_cd") == tDmgLocCds[i])
							{
								sheetObjects[2].SetCellValue(j,"del_chk","0",0);
							}
						}
					}
				}
				MnrRowDelete(sheetObjects[2],"del_chk");
			} else {
				var tDmgLocCd="";
				for(var i=2;i < sheetObjects[2].LastRow();i++ ){
					var checkCompCd=sheetObjects[2].GetCellValue(i,"eq_loc_cd");
					tDmgLocCd += checkCompCd + "/";
				}
				tDmgLocCd=MnrDelLastDelim(tDmgLocCd);
				ComSetObjValue(form.damageLocationCode, tDmgLocCd);
				// deleting
				for(i=0;i < DLCSheets.length;i++){
					for(j=1;j <= DLCSheets[i].LastRow();j++){
						for(k=1;k <= DLCSheets[i].LastCol();k++){
							DLCSheets[i].SetCellValue(j,k,"0",0);
							
							var RowText = "";
							var HeadTitle = "";
							var DLCText = "";
							switch(DLCSheets[i].id){
								case "t2_sheet1":
									RowText="H|T|B|G";
									HeadTitle="|1|2|3|4";
									DLCText = "D";
						            break;
						            
								case "t2_sheet2":
									RowText="H|T|B|G";
									HeadTitle="|4|3|2|1";
									DLCText = "F";
									break;
									
								case "t2_sheet3":
									RowText = "H|T|B|G";
									HeadTitle = "|0|9|8|7|6|5|4|3|2|1";
									DLCText = "L";
									break;
									
								case "t2_sheet4":
									RowText = "H|T|B|G";
									HeadTitle = "|1|2|3|4|5|6|7|8|9|0";
									DLCText = "R";
									break;
									
								case "t2_sheet5":
									RowText = "L|R";
									HeadTitle = "|1|2|3|4|5|6|7|8|9|0";
									DLCText = "T";
									break;
									
								case "t2_sheet6":
									RowText = "L|R";
									HeadTitle = "|1|2|3|4|5|6|7|8|9|0";
									DLCText = "B";
									break;
									
								case "t2_sheet7":
									RowText = "L|R";
									HeadTitle = "|1|2|3|4|5|6|7|8|9|0";
									DLCText = "U";
									break;
									
							}
							var RowVals=RowText.split("|");
				            var ColVals = HeadTitle.split("|");
							DLCSheets[i].SetToolTipText(j,k, DLCText+ RowVals[j-1] + ColVals[k]);
						}
					}
				}
				setDLC();
				before_dlc=ComGetObjValue(form.damageLocationCode);
			}
		}
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		objs[beforetab].style.display="none";
		//--------------- important --------------------------//
		objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
		//------------------------------------------------------//
		beforetab=nItem;
	}
	function t1sheet1_OnClick(sheetObj,Row, Col, Value) {
		var formObj=document.form;
		formObj.mnr_desc.value=sheetObj.GetCellValue(Row ,"rpr_dtl_rmk");
	}
	function t1sheet1_OnChange(sheetObj,Row, Col, Value){
		if(!dummyEvent){
			var retArray=null;
			var checkLoc=sheetObj.GetCellValue(Row ,Col);
			if(sheetObj.ColSaveName(Col)  == "eq_loc_cd"){
				var checkLoc=sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"LOC",checkLoc);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkLoc,"LOC");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				}
				//changing row status
				if(sheetObj.GetRowStatus(Row) != "R"){
					sheetObj.SetRowStatus(Row,"I");
				}
			} else if(sheetObj.ColSaveName(Col)  == "eq_cmpo_cd"){
				var checkCompCd=sheetObj.GetCellValue(Row,"eq_cmpo_cd").toUpperCase();
				sheetObj.SetCellValue(Row, "eq_cmpo_cd", checkCompCd);
				var isPossible=false;
				var sCode=sheetObj.GetComboInfo(Row,"eq_cmpo_cd", "Code");
				var arrCode=sCode.split("|");
				for(var i=0;i < arrCode.length;i ++){
					if(arrCode[i] == checkCompCd){
						isPossible=true;
					}
				}
				var formObject=document.form;
				if(!isPossible){
					ComShowCodeMessage("MNR00010","Component Code");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					//******************** retrieving RPR code in case of changing Component. **************
					var sCondition=new Array (
			 			new Array("MnrRprCd",checkCompCd,"COMMON")
			 		)
					var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
					var sheetComboCode="";
					var sheetComboText="";
					var sheetComboCodeText="";
			 		var comboSaveNames=new Array();
					for(var i=0; i < comboList.length;i++){
					 	if(comboList[i] != null){
							sheetComboText="";
							sheetComboCode="";
							sheetComboCodeText="";
					 		for(var j=0; j < comboList[i].length;j++){
								var tempText=comboList[i][j].split("|");
								sheetComboCode +=  tempText[0] + "|";
								sheetComboText +=  tempText[1] + "|";
								sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
							}
							sheetComboCode=MnrDelLastDelim(sheetComboCode);
					     	sheetComboText=MnrDelLastDelim(sheetComboText);
					        sheetComboCodeText=MnrDelLastDelim(sheetComboCodeText);
					        var info = {"ComboCode":sheetComboCode, "ComboText":sheetComboCodeText};
							dummyEvent=true;
							sheetObjects[2].CellComboItem (Row, "eq_rpr_cd", info);
							dummyEvent=false;
						}
				 	}
					sheetObj.SetCellValue(Row ,"eq_rpr_cd","",0);
					//initializing DIV code
					dummyEvent=true;
					var info_sub = {"ComboCode":" |", "ComboText":" \t |"};
					sheetObj.CellComboItem (Row, "trf_div_cd", info_sub);
					dummyEvent=false;
					//******************** retrieving RPR code in case of changing Component. END *************
					setDescripton(sheetObj,Row);
					// checkpoint
					if(ComGetObjValue(formObject.eq_tpsz_cd) != "" && checkCompCd != ""){
						//if(sheetObj.RowStatus(Row) != "R"){
						if(formObj.rpr_offh_flg_temp.checked == true){
							offFlg = "Y";
						}else{ 
							offFlg = "N";
						}
						var costCdSet=MnrGetCostCd(sheetObjects[0],eq_knd_cd.GetSelectCode(),formObject.eq_tpsz_cd.value,checkCompCd, offFlg);
						var arrCostCd = costCdSet.split("|");
						sheetObj.SetCellValue(Row,"cost_cd",arrCostCd[0],0);
						sheetObj.SetCellValue(Row,"cost_cd_nm",arrCostCd[1],0);
						if(offFlg == "Y"){
							sheetObj.SetCellValue(Row,"cost_dtl_cd","OF",0);
						}else{
							sheetObj.SetCellValue(Row,"cost_dtl_cd","NR",0);
						}
						
						//}
					}
				}
				//changing row status
				if(sheetObj.GetRowStatus(Row) != "R"){
					sheetObj.SetRowStatus(Row,"I");
				}
			} else if(sheetObj.ColSaveName(Col)  == "vol_tp_cd"){
				if(sheetObj.GetCellValue(Row,"vol_tp_cd") == "Q"){
					sheetObj.SetCellBackColor(Row, "rpr_qty","#00D8FF");
					sheetObj.SetCellBackColor(Row, "rpr_sz_no","#FFFFFF");
					sheetObj.SetCellEditable(Row, "rpr_qty",1);
					sheetObj.SetCellEditable(Row, "rpr_sz_no",0);
					sheetObj.SetCellValue(Row ,"rpr_sz_no","",0);
				} else {
					sheetObj.SetCellBackColor(Row, "rpr_sz_no","#00D8FF");
					sheetObj.SetCellBackColor(Row, "rpr_qty","#FFFFFF");
					sheetObj.SetCellEditable(Row, "rpr_qty",0);
					sheetObj.SetCellValue(Row ,"rpr_qty","",0);
					sheetObj.SetCellEditable(Row, "rpr_sz_no",1);
				}
				//changing row status
				if(sheetObj.GetRowStatus(Row) != "R"){
					sheetObj.SetRowStatus(Row,"I");
				}
			} else if(sheetObj.ColSaveName(Col) == "n3pty_flg"){
				var formObject=document.form;
				if(sheetObj.GetCellValue(Row,"n3pty_flg") == "1"){
					sheetObj.SetCellEditable(Row, "n3pty_bil_lbr_hrs",1);
					sheetObj.SetCellEditable(Row, "n3pty_bil_lbr_rt",1);
					sheetObj.SetCellEditable(Row, "n3pty_bil_mtrl_cost_amt",1);
					sheetObj.SetCellValue(Row,"n3pty_bil_lbr_hrs",sheetObj.GetCellValue(Row,"rpr_lbr_hrs"),0);
					sheetObj.SetCellValue(Row,"n3pty_bil_lbr_rt",sheetObj.GetCellValue(Row,"rpr_lbr_rt"),0);
					sheetObj.SetCellValue(Row,"n3pty_lbr_cost_amt",sheetObj.GetCellValue(Row,"lbr_cost_amt"),0);
					sheetObj.SetCellValue(Row,"n3pty_bil_mtrl_cost_amt",sheetObj.GetCellValue(Row,"mtrl_cost_amt"),0);
					sheetObj.SetCellValue(Row,"n3pty_bil_amt",sheetObj.GetCellValue(Row,"mnr_wrk_amt"),0);
					formObject.n3pty_flg.value="Y";
				} else {
					sheetObj.SetCellEditable(Row, "n3pty_bil_lbr_hrs",0);
					sheetObj.SetCellEditable(Row, "n3pty_bil_lbr_rt",0);
					sheetObj.SetCellEditable(Row, "n3pty_bil_mtrl_cost_amt",0);
					sheetObj.SetCellValue(Row,"n3pty_bil_lbr_hrs","",0);
					sheetObj.SetCellValue(Row,"n3pty_bil_lbr_rt","",0);
					sheetObj.SetCellValue(Row,"n3pty_lbr_cost_amt","",0);
					sheetObj.SetCellValue(Row,"n3pty_bil_mtrl_cost_amt","",0);
					sheetObj.SetCellValue(Row,"n3pty_bil_amt","",0);
					var n3CheckFlag=false;
					for(var j=2; j <= sheetObj.LastRow()- 1;j++){
						if(sheetObj.GetCellValue(j,"n3pty_flg") == "1"){
							n3CheckFlag=true;
						}
					}
					if(n3CheckFlag){
						formObject.n3pty_flg.value="Y";
					} else {
						formObject.n3pty_flg.value="N";
					}
				}
			} else if(sheetObj.ColSaveName(Col) == "eq_rpr_cd" || sheetObj.ColSaveName(Col) == "eq_dmg_cd"){
				var ErrMsgTarget="";
				var isPossible=false;
				if(sheetObj.ColSaveName(Col) == "eq_rpr_cd"){
					ErrMsgTarget="Repair Code";
					var repairCd=sheetObj.GetCellValue(Row,"eq_rpr_cd").toUpperCase();
					sheetObj.SetCellValue(Row, "eq_rpr_cd", repairCd);
					var sCode=sheetObj.GetComboInfo(Row,"eq_rpr_cd", "Code");
					var arrCode=sCode.split("|");
					for(var i=0;i < arrCode.length;i ++){
						if(arrCode[i] == repairCd){
							isPossible=true;
						}
					}
				} else if(sheetObj.ColSaveName(Col) == "eq_dmg_cd"){
					ErrMsgTarget="Demage Code";
					var damageCd = sheetObj.GetCellValue(Row,Col).toUpperCase();
					sheetObj.SetCellValue(Row, "eq_dmg_cd", damageCd);
					for(var i=0;i < sheetComboList[1].length;i++){
						var tempText=sheetComboList[1][i].split("|");
						if(tempText[0] == damageCd){
							isPossible=true;
						}
					}
				}
				if(!isPossible){
					ComShowCodeMessage("MNR00010",ErrMsgTarget);
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					// if RPR
					if(sheetObj.ColSaveName(Col) == "eq_rpr_cd"){
						setDescripton(sheetObj,Row);
						var checkCompCd=sheetObj.GetCellValue(Row,"eq_cmpo_cd");
						var checkRprCd=sheetObj.GetCellValue(Row,"eq_rpr_cd");
						// setting DIV in case of existing COMP code
						if(checkCompCd != ""){
							var cosCdPrifix=sheetObj.GetCellValue(Row,"cost_cd");
							if(cosCdPrifix.length > 3){
								cosCdPrifix=cosCdPrifix.substring(0,3);
							}
							var compRprJoinStr=ComTrimAll(checkCompCd) + ComTrimAll(checkRprCd);
							var sCondition=new Array (
							 	new Array("MnrDivCd",compRprJoinStr + ',' +  cosCdPrifix,"COMMON1")
							)
							var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
							var lbComboText="";
							var lbComboCode="";
							if(comboList[0] != null){
								for(var j=0; j < comboList[0].length;j++){
									var tempText=comboList[0][j].split("|");
									lbComboText +=  tempText[0] + "\t" + tempText[1] + "|";
									lbComboCode +=  tempText[0] + "|";
								}
							}
							
							var info = {"ComboCode":lbComboCode, "ComboText":lbComboText};
							dummyEvent=true;
							sheetObj.CellComboItem (Row, "trf_div_cd", info);
							dummyEvent=false;
							sheetObj.SetCellValue(Row ,"trf_div_cd"," ",0);
						}
					}
				}
				//changing row status
				if(sheetObj.GetRowStatus(Row) != "R"){
					sheetObj.SetRowStatus(Row,"I");
				}
			} else if(sheetObj.ColSaveName(Col) == "trf_div_cd"){
				setDescripton(sheetObj,Row);
				//changing row status
				if(sheetObj.GetRowStatus(Row) != "R"){
					sheetObj.SetRowStatus(Row,"I");
				}
			} else if(sheetObj.ColSaveName(Col) == "del_chk"){
				MnrCheckRowColChange(sheetObj,sheetObj.GetCellValue(Row,"del_chk"),Row);
			//validation SS.
			} else if(sheetObj.ColSaveName(Col) == "rpr_lbr_hrs" && tariffChk != "N"){
				if(sheetObj.GetCellValue(Row ,"mnr_vrfy_tp_cd") == "SS" || sheetObj.GetCellValue(Row ,"mnr_vrfy_tp_cd") == "SL" || sheetObj.GetCellValue(Row ,"mnr_vrfy_tp_cd") == "UH"){
					getReVerifySuccItem(sheetObj,Row);
				}
			} else if(sheetObj.ColSaveName(Col) == "rpr_lbr_rt"){
				if(sheetObj.GetCellValue(Row ,"mnr_vrfy_tp_cd") == "SS" || sheetObj.GetCellValue(Row ,"mnr_vrfy_tp_cd") == "SL" || sheetObj.GetCellValue(Row ,"mnr_vrfy_tp_cd") == "UR"){
					getReVerifySuccItem(sheetObj,Row);
				}
			} else if(sheetObj.ColSaveName(Col) == "mtrl_cost_amt" && tariffChk != "N"){
				if(sheetObj.GetCellValue(Row ,"mnr_vrfy_tp_cd") == "SS" || sheetObj.GetCellValue(Row ,"mnr_vrfy_tp_cd") == "SL" || sheetObj.GetCellValue(Row ,"mnr_vrfy_tp_cd") == "UM"){
					getReVerifySuccItem(sheetObj,Row);
				}
			}
			//changing sheet whether to change.
			var t=sheetObj.ColSaveName(Col);
			if(t == "eq_dmg_cd" || t == "rpr_qty" || t == "rpr_sz_no"){
				//changing row status
				if(sheetObj.GetRowStatus(Row) != "R"){
					sheetObj.SetRowStatus(Row,"I");
				}
			}
			if(t != "eq_loc_cd" && t != "eq_cmpo_cd" && t != "eq_dmg_cd" && t != "eq_rpr_cd" && t != "vol_tp_cd" && t != "rpr_qty" && t != "rpr_sz_no"){
				if(sheetObj.GetRowStatus(Row) != "I"){
					sheetObj.SetRowStatus(Row,"R");
				}
			}
			if(t == "eq_loc_cd" || t == "eq_cmpo_cd" || t == "eq_dmg_cd" || t == "eq_rpr_cd" || t == "vol_tp_cd" || t == "rpr_qty" || t == "rpr_sz_no"){
				if(sheetObj.GetRowStatus(Row) != "R" && enableOnChange == true){
					setInitSheetEdit(sheetObj,Row);
					//Initialize all possible input values​​.
					sheetObj.SetCellValue(Row ,"rpr_lbr_hrs","",0);
					sheetObj.SetCellValue(Row ,"rpr_lbr_rt","",0);
					sheetObj.SetCellValue(Row ,"lbr_cost_amt","",0);
					sheetObj.SetCellValue(Row ,"mtrl_cost_amt","",0);
					sheetObj.SetCellValue(Row ,"mnr_wrk_amt","",0);
					sheetObj.SetCellValue(Row ,"n3pty_flg","0",0);
					sheetObj.SetCellValue(Row ,"n3pty_bil_lbr_hrs","",0);
					sheetObj.SetCellValue(Row ,"n3pty_bil_lbr_rt","",0);
					sheetObj.SetCellValue(Row ,"n3pty_lbr_cost_amt","",0);
					sheetObj.SetCellValue(Row ,"n3pty_bil_mtrl_cost_amt","",0);
					sheetObj.SetCellValue(Row ,"n3pty_bil_amt","",0);
					sheetObj.SetCellValue(Row ,"mnr_vrfy_tp_cd","",0);
				}
			}
		}
	}
	function getReVerifySuccItem(sheetObj,Row){
		var current=parseFloat(sheetObj.GetCellValue(Row ,"rpr_lbr_hrs"));
		var asis=parseFloat(sheetObj.GetCellValue(Row ,"rpr_lbr_bzc_hrs"));
		var current1=parseFloat(sheetObj.GetCellValue(Row ,"rpr_lbr_rt"));
		var asis1=parseFloat(sheetObj.GetCellValue(Row ,"rpr_lbr_bzc_rt"));
		var current2=parseFloat(sheetObj.GetCellValue(Row ,"mtrl_cost_amt"));
		var asis2=parseFloat(sheetObj.GetCellValue(Row ,"lbr_mtrl_bzc_amt"));
		if(tariffChk != "N"){
			if(current > asis){
				sheetObj.SetCellValue(Row ,"mnr_vrfy_tp_cd","UH",0);
				sheetObj.SetCellFontColor(Row,"mnr_vrfy_tp_cd","#FF0000");
			} else if(current1 > asis1){
				sheetObj.SetCellValue(Row ,"mnr_vrfy_tp_cd","UR",0);
				sheetObj.SetCellFontColor(Row,"mnr_vrfy_tp_cd","#FF0000");
			} else if(current2 > asis2){
				sheetObj.SetCellValue(Row ,"mnr_vrfy_tp_cd","UM",0);
				sheetObj.SetCellFontColor(Row,"mnr_vrfy_tp_cd","#FF0000");
			} else if(current < asis || current1 < asis1 || current2 < asis2){
				sheetObj.SetCellValue(Row ,"mnr_vrfy_tp_cd","SL",0);
				sheetObj.SetCellFontColor(Row,"mnr_vrfy_tp_cd","#0000FF");
			} else {
				sheetObj.SetCellValue(Row ,"mnr_vrfy_tp_cd","SS",0);
				sheetObj.SetCellFontColor(Row,"mnr_vrfy_tp_cd","#0000FF");
			}
		}else{
			if(current1 > asis1){
				sheetObj.SetCellValue(Row ,"mnr_vrfy_tp_cd","UR",0);
				sheetObj.SetCellFontColor(Row,"mnr_vrfy_tp_cd","#FF0000");
			} else if(current1 < asis1){
				sheetObj.SetCellValue(Row ,"mnr_vrfy_tp_cd","SL",0);
				sheetObj.SetCellFontColor(Row,"mnr_vrfy_tp_cd","#0000FF");
			} else {
				sheetObj.SetCellValue(Row ,"mnr_vrfy_tp_cd","SS",0);
				sheetObj.SetCellFontColor(Row,"mnr_vrfy_tp_cd","#0000FF");
			}
		}
	}
	function t1sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) != "eq_loc_cd") return;
		//clicked row
		t1sheet1ClickRow=Row;
		ComOpenPopup('EES_MNR_0193.do?rec_eq_knd_cd=' + eq_knd_cd.GetSelectCode(), 896, 498, 'setEES_MNR_0193', '0,1,1,1,1,1,1,1,1,1,1,1', true);
    }
	function t2_sheet1_OnChange(sheetObj, Row, Col, Value)
    {
		var dlcStr="";
        for(i=0;i < DLCSheets.length;i++){
    		dlcStr += getDLC(DLCSheets[i]);
    	}
    	dlcStr=dlcStr.substring(1,dlcStr.length)
		ComSetObjValue(form.damageLocationCode, dlcStr);
		if(Value == 1){
			sheetObj.SetCellBackColor(Row,Col,"#F7E5E1");
		} else {
			sheetObj.SetCellBackColor(Row,Col,"#FFFFFF");
		}
    }
	
	function t2_sheet2_OnChange(sheetObj, Row, Col, Value)
    {
		var dlcStr="";
        for(i=0;i < DLCSheets.length;i++){
    		dlcStr += getDLC(DLCSheets[i]);
    	}
    	dlcStr=dlcStr.substring(1,dlcStr.length)
		ComSetObjValue(form.damageLocationCode, dlcStr);
		if(Value == 1){
			sheetObj.SetCellBackColor(Row,Col,"#F7E5E1");
		} else {
			sheetObj.SetCellBackColor(Row,Col,"#FFFFFF");
		}
    }
	
	function t2_sheet3_OnChange(sheetObj, Row, Col, Value)
    {
		var dlcStr="";
        for(i=0;i < DLCSheets.length;i++){
    		dlcStr += getDLC(DLCSheets[i]);
    	}
    	dlcStr=dlcStr.substring(1,dlcStr.length)
		ComSetObjValue(form.damageLocationCode, dlcStr);
		if(Value == 1){
			sheetObj.SetCellBackColor(Row,Col,"#F7E5E1");
		} else {
			sheetObj.SetCellBackColor(Row,Col,"#FFFFFF");
		}
    }
	
	function t2_sheet4_OnChange(sheetObj, Row, Col, Value)
    {
		var dlcStr="";
        for(i=0;i < DLCSheets.length;i++){
    		dlcStr += getDLC(DLCSheets[i]);
    	}
    	dlcStr=dlcStr.substring(1,dlcStr.length)
		ComSetObjValue(form.damageLocationCode, dlcStr);
		if(Value == 1){
			sheetObj.SetCellBackColor(Row,Col,"#F7E5E1");
		} else {
			sheetObj.SetCellBackColor(Row,Col,"#FFFFFF");
		}
    }
	
	function t2_sheet5_OnChange(sheetObj, Row, Col, Value)
    {
		var dlcStr="";
        for(i=0;i < DLCSheets.length;i++){
    		dlcStr += getDLC(DLCSheets[i]);
    	}
    	dlcStr=dlcStr.substring(1,dlcStr.length)
		ComSetObjValue(form.damageLocationCode, dlcStr);
		if(Value == 1){
			sheetObj.SetCellBackColor(Row,Col,"#F7E5E1");
		} else {
			sheetObj.SetCellBackColor(Row,Col,"#FFFFFF");
		}
    }
	
	function t2_sheet6_OnChange(sheetObj, Row, Col, Value)
    {
		var dlcStr="";
        for(i=0;i < DLCSheets.length;i++){
    		dlcStr += getDLC(DLCSheets[i]);
    	}
    	dlcStr=dlcStr.substring(1,dlcStr.length)
		ComSetObjValue(form.damageLocationCode, dlcStr);
		if(Value == 1){
			sheetObj.SetCellBackColor(Row,Col,"#F7E5E1");
		} else {
			sheetObj.SetCellBackColor(Row,Col,"#FFFFFF");
		}
    }
	
	function t2_sheet7_OnChange(sheetObj, Row, Col, Value)
    {
		var dlcStr="";
        for(i=0;i < DLCSheets.length;i++){
    		dlcStr += getDLC(DLCSheets[i]);
    	}
    	dlcStr=dlcStr.substring(1,dlcStr.length)
		ComSetObjValue(form.damageLocationCode, dlcStr);
		if(Value == 1){
			sheetObj.SetCellBackColor(Row,Col,"#F7E5E1");
		} else {
			sheetObj.SetCellBackColor(Row,Col,"#FFFFFF");
		}
    }
	
	
	/**
     * downloading file <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Col     	selected Row of sheetObj
     * @param {ibsheet} Col     	selected Col of sheetObj
     * @param {String} 	Value     	file name
     **/
	function t2_sheet8_OnClick(sheetObj,Row,Col,Value){
		var prefix="";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.GetRowStatus(Row)=="I")return;
		if(sheetObj.GetCellText(Row, prefix+"file_path_nm") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_path_nm");
		return;
	}
	function sheet2_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "" || ErrMsg == undefined) {
			if(saveType == "REMOVE"){
				ComShowCodeMessage("MNR00020");
			} else if(saveType == "REQUEST") {
				ComShowCodeMessage("MNR00055");
			} else {
				ComShowCodeMessage("MNR00023");
			}
			
			if(MnrComGetErrMsg(sXml_3) == null){
				var rqstEqNo=ComGetEtcData(sXml_3, "rqst_eq_no");
				var rprRqstSeq=ComGetEtcData(sXml_3, "rpr_rqst_seq");
				var rprRqstVerNo=ComGetEtcData(sXml_3, "rpr_rqst_ver_no");
				var targetRow=0;
				with(sheetObjects[1]){
					for(var j=1; j <= LastRow();j++){
						if(GetCellValue(j,"rqst_eq_no") == rqstEqNo && GetCellValue(j,"rpr_rqst_seq") == rprRqstSeq && GetCellValue(j,"rpr_rqst_ver_no") == rprRqstVerNo){
							targetRow=j;
						}
					}
				}
				//selected as
				if(targetRow != 0){
					sheetObjects[1].SelectCell(targetRow,1);
					sheet2_OnDblClick(sheetObjects[1],targetRow,1);
				}
			}
		} else {
			// showing message after deleting
			if(saveType == "REMOVE"){
				//ComShowCodeMessage("MNR00027",ErrMsg);
			//REQUEST
			} else if(saveType == "REQUEST") {
				//ComShowCodeMessage("MNR00008",ErrMsg);
			// showing message after saving
			} else {
				ComShowCodeMessage("MNR00008",ErrMsg);
			}
		}
	}
	function t1sheet1_OnSearchEnd(sheetObj,ErrMsg){
		var arrResult=MnrXmlToArray(sXml_1);
		setCommonSheetEdit(sheetObjects[2],arrResult);
		//retrieving data
		ComSetObjValue(formObj.rqst_dt, ComGetEtcData(sXml_1, "rqst_dt"));
		ComSetObjValue(formObj.eq_dmg_dt, ComGetEtcData(sXml_1, "eq_dmg_dt"));
		ComSetObjValue(formObj.rqst_usr_nm, ComGetEtcData(sXml_1, "rqst_usr_nm"));
		ComSetObjValue(formObj.rqst_usr_id, ComGetEtcData(sXml_1, "rqst_usr_id"));
		formObj.mnr_desc.value="";
		var n3CheckFlag=false;
		for(var j=2; j <= sheetObj.LastRow()- 1;j++){
			if(sheetObj.GetCellValue(j,"n3pty_flg") == "1"){
				n3CheckFlag=true;
			}
		}
		if(n3CheckFlag){
			document.form.n3pty_flg.value="Y";
		} else {
			document.form.n3pty_flg.value="N";
		}
		formObj.mnr_desc.value="";
		for(var i=sheetObj.HeaderRows(); i<sheetObj.LastRow(); i++){
			var mnrVrfyTpCd=sheetObj.GetCellValue(i,  "mnr_vrfy_tp_cd");
			if(mnrVrfyTpCd=="SS" || mnrVrfyTpCd=="SL"){
				sheetObj.SetCellFontColor(i,"mnr_vrfy_tp_cd","#0000FF");
			} else {
				sheetObj.SetCellFontColor(i,"mnr_vrfy_tp_cd","#FF0000");
			}

		}
		
	}
	// showing message after varifying
	function t1sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "" || ErrMsg == undefined) {
			ComShowCodeMessage("MNR00334");
			var formObj = document.form;
			for(var i=sheetObj.HeaderRows(); i<sheetObj.LastRow(); i++){
				var mnrVrfyTpCd=sheetObj.GetCellValue(i,  "mnr_vrfy_tp_cd");
				if(mnrVrfyTpCd=="SS" || mnrVrfyTpCd=="SL"){
					sheetObj.SetCellFontColor(i,"mnr_vrfy_tp_cd","#0000FF");
				} else {
					sheetObj.SetCellFontColor(i,"mnr_vrfy_tp_cd","#FF0000");
				}
				
				
			}
			
			//setting mnr_lr_acct_flg in case of checking Off-hire
			//mnr_vrfy_tp_cd ==> OF
			if(formObj.rpr_offh_flg.value == 'Y'){
				for(var j=2; j <= sheetObj.LastRow()- 1;j++){
					sheetObj.SetCellEditable(j, "mnr_lr_acct_flg",1);
					sheetObj.SetCellValue(j, "mnr_vrfy_tp_cd","OF");
				}
			} else {
				for(var j=2; j <= sheetObj.LastRow()- 1;j++){
					sheetObj.SetCellEditable(j, "mnr_lr_acct_flg",0);
				}
			}
			if(sheetObj.RowCount()>= 1) {
				sheetObj.SelectCell(2,1);
			}
			var arrResult=MnrXmlToArray(sXml_2);
			setCommonSheetEdit(sheetObj,arrResult);

			if(MnrNullToBlank(ComGetEtcData(sXml_2,"RQST_EQ_NO")) != ''){
				// calling popup
				var rqstEqNo=MnrNullToBlank(ComGetEtcData(sXml_2,"RQST_EQ_NO"));
				var rprRqstSeq=MnrNullToBlank(ComGetEtcData(sXml_2,"RPR_RQST_SEQ"));
				var rprRqstVerNo=MnrNullToBlank(ComGetEtcData(sXml_2,"RPR_RQST_VER_NO"));
				var eqKndCd=MnrNullToBlank(ComGetEtcData(sXml_2,"EQ_KND_CD"));
				var recentRprTpCd=MnrNullToBlank(ComGetEtcData(sXml_2,"RECENT_RPR_TP_CD"));
				ComOpenPopup('/opuscntr/EES_MNR_0192.do?rqst_eq_no='+rqstEqNo+"&rpr_rqst_seq="+rprRqstSeq+"&rpr_rqst_ver_no="+rprRqstVerNo+"&eq_knd_cd="+eqKndCd+"&recent_rpr_tp_cd="+recentRprTpCd, 1024, 768, '', '0,0', false);
			}
		} else {
			//ComShowCodeMessage("MNR00159",ErrMsg);
		}
	}
	function combo_sp_name_OnChange(comboObj,Index_Code, Text){
		var formObj=document.form;
		var selectedIndex=parseInt(comboObj.GetSelectIndex());
		if(comboObj.GetEnable() == true && formObj.rqst_eq_no.value != ""){
			if (!ComShowCodeConfirm("MNR00232")){
				//The changed data is found. Are you sure to proceed ?
				// cancel button
				comboObj.SetSelectIndex(parseInt(preSpNameCode),false);
				newFlg = "N";
				return;
			} else {
				// confirm button
				preSpNameCode=comboObj.GetSelectCode();
				ComSetObjValue(formObj.rqst_eq_no,"");
				ComSetObjValue(formObj.rqst_ref_no,"");
				ComSetObjValue(formObj.mnr_desc,"");
				ComSetObjValue(formObj.mnr_rpr_rmk,"");
				setEqInfoClear();
				sheetObjects[2].RemoveAll();
				
				newFlg = "Y";
			}
		}
		if(selectedIndex != -1){
			formObj.trf_no.value=sp_name.items[selectedIndex].trf_no;
			formObj.curr_cd.value=sp_name.items[selectedIndex].curr_cd;
			formObj.edi_id.value=sp_name.items[selectedIndex].edi_id;
			eq_knd_cd.SetSelectCode(sp_name.items[selectedIndex].eq_knd_cd);
			trsm_mod_cd.SetSelectCode(sp_name.items[selectedIndex].trsm_mod_cd);
			formObj.vndr_seq.value=sp_name.items[selectedIndex].vndr_seq;
			formObj.mnr_meas_ut_nm.value=sp_name.items[selectedIndex].mnr_meas_ut_nm;
			var agmtNo=sp_name.items[selectedIndex].agmt_no;
			formObj.agmt_ofc_cty_cd.value=agmtNo.substring(0,3);
			formObj.agmt_seq.value=parseInt(agmtNo.substring(3,agmtNo.length),10);
			formObj.agmt_ver_no.value=sp_name.items[selectedIndex].agmt_ver_no;
			var eff_dt=sp_name.items[selectedIndex].eff_dt;
			var exp_dt=sp_name.items[selectedIndex].exp_dt;
			var today_dt=ComGetNowInfo();
			if(ComGetDaysBetween(today_dt,exp_dt) < 0 || ComGetDaysBetween(eff_dt,today_dt) < 0){
				ComShowCodeMessage("MNR00241");
			}
		} else {
			formObj.trf_no.value="";
			formObj.curr_cd.value="";
			formObj.edi_id.value="";
			eq_knd_cd.SetSelectCode("");
			trsm_mod_cd.SetSelectCode("");
			formObj.vndr_seq.value="";
			formObj.mnr_meas_ut_nm.value="";
			formObj.agmt_ofc_cty_cd.value="";
			formObj.agmt_seq.value="";
			formObj.agmt_ver_no.value="";
		}
	}
	//combo event
	function eq_knd_cd_OnChange(comboObj,OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod){
		if(comboObj.GetSelectCode()== 'U'){
			var div1=document.all.item("t2_selection1");
			var div2=document.all.item("t2_selection2");
			div1.style.display="inline";
			div2.style.display="inline";
		} else {
			var div1=document.all.item("t2_selection1");
			var div2=document.all.item("t2_selection2");
			div1.style.display="none";
			div2.style.display="none";
//			div1.style.display="inline";
//			div2.style.display="inline";
		}
		//******************** retrieving Component code in case of changing EQ Type. **************
		var sCondition=new Array (
 			new Array("MnrEqCmpoCdByEqType","3",eq_knd_cd.GetSelectCode())
 		)
		var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
		var sheetComboCode="";
		var sheetComboText="";
		var sheetComboCodeText="";
 		var sheetComboDefault="";
 		var comboSaveNames=new Array();
		for(var i=0; i < comboList.length;i++){
		 	if(comboList[i] != null){
				sheetComboText="";
				sheetComboCode="";
				sheetComboCodeText="";
		 		for(var j=0; j < comboList[i].length;j++){
					var tempText=comboList[i][j].split("|");
					sheetComboCode +=  tempText[0] + "|";
					sheetComboText +=  tempText[1] + "|";
					sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
					/*
					if(j ==0){
						sheetComboDefault=tempText[0];
					}
					*/
				}
				sheetComboCode=MnrDelLastDelim(sheetComboCode);
		     	sheetComboText=MnrDelLastDelim(sheetComboText);
		        sheetComboCodeText=MnrDelLastDelim(sheetComboCodeText);
		        
				sheetObjects[2].InitDataCombo (0, "eq_cmpo_cd", sheetComboCodeText, sheetComboCode ,sheetComboDefault);
			}
	 	}
		//******************** retrieving Component code in case of changing EQ Type.END *************
	}
	//************************* EVENT SECTION ************************//
    function setDLC()
    {
	    //DLCs = BL10,ABNN
    	var DLCs=ComGetObjValue(form.damageLocationCode).split("/");
    	var SheetChar="DFLRTBU";
        for(i=0;i < DLCs.length;i++){
			if(SheetChar.indexOf(DLCs[i].charAt(0)) != -1){
				checkDLC(DLCSheets[SheetChar.indexOf(DLCs[i].charAt(0))], DLCs[i]);
			}
    	}
    }
    function checkDLC(sheetObj, DLC)
    {
    	with(sheetObj){
    		for(var i=1 ; i <= LastRow();i++){
    			for(var j=1 ; j <= LastCol();j++){
					if(GetToolTipText(i,j).substring(0,3) == DLC.substring(0,3)){
						if(DLC.charAt(3) == 'N'){
							SetCellValue(i,j,"1",0);
							sheetObj.SetCellBackColor(i,j,"#F7E5E1");
						} else {
							var len=Math.abs(parseInt(DLC.charAt(3)) - parseInt(DLC.charAt(2)));
							if(GetToolTipText(i,j).substring(0,1) == "L" || GetToolTipText(i,j).substring(0,1) == "F"){
								if(DLC.substring(3,4) == "0"){
									var lflen=(10 - parseInt(DLC.charAt(2)));
									for(var k=0; k <= lflen ; k++){
										SetCellValue(i,1 + k,"1",0);
										sheetObj.SetCellBackColor(i,1 + k,"#F7E5E1");
									}
								} else 	{
									for(var k=0; k <= len ; k++){
										SetCellValue(i,j - k,"1",0);
										sheetObj.SetCellBackColor(i,j - k,"#F7E5E1");
									}
								}
							} else {
								if(DLC.substring(3,4) == "0"){
									var lflen=(10 - parseInt(DLC.charAt(2)));
									for(var k=0; k <= lflen ; k++){
										SetCellValue(i,j + k,"1",0);
										sheetObj.SetCellBackColor(i,j + k,"#F7E5E1");
									}
								} else {
									for(var k=0; k <= len ; k++){
										SetCellValue(i,j + k,"1",0);
										sheetObj.SetCellBackColor(i,j + k,"#F7E5E1");
									}
								}
							}
						}
					}
    			}
    		}
    	}
    }
    function getDLC(sheetObj)
    {
    	var DLC="";
    	var startPoint=0;
    	var endPoint=0;
    	var cont=true;
    	with(sheetObj){
    		for(var i=1 ; i <= LastRow();i++){
    			startPoint=0;
    			for(var j=1 ; j <= LastCol();j++){
    				startPoint=0;
    				if(GetCellValue(i,j) == '1'){
    					if(GetCellValue(i,j + 1) == '1'){
							startPoint=j;
							do {
								endPoint=j;
					          	j++;
							} while (GetCellValue(i,j) == '1' && j <= LastCol());
							if(GetToolTipText(i,j - 1).substring(0,1) == "L" || GetToolTipText(i,j - 1).substring(0,1) == "F"){
								DLC += "/"+GetToolTipText(i,j - 1).substring(0,2) + GetToolTipText(i,endPoint).substring(2,3) + GetToolTipText(i,startPoint).substring(2,3);
							} else {
								DLC += "/"+GetToolTipText(i,j - 1).substring(0,2) + GetToolTipText(i,startPoint).substring(2,3) + GetToolTipText(i,endPoint).substring(2,3);
							}
						}else{
							DLC += "/"+GetToolTipText(i,j) + "N";
						}
					}
    			}
    		}
    	}
    	return DLC;
    }
    function contCheck(sheetObj, Row, Col)
    {
    	var point="";
    	with(sheetObj){
    		for(var i=1 ; i <= LastRow();i++){
    			var firstFlag=0;
    			for(var j=1 ; j <= LastCol();j++){
    				if(GetCellValue(i,j) == '1'){
    					if(GetCellValue(i,j + 1) == '1'){
						}else{
							point += "|"+GetToolTipText(i,j)+"N";
						}
					}
    			}
    		}
    	}
    }
	function setInitSheetEdit(sheetObj,Row){
		var formObj=document.form;
		//setting according to vol_tp_cd
		if(sheetObj.GetCellValue(Row,"vol_tp_cd") == "Q"){
			sheetObj.SetCellBackColor(Row, "rpr_qty","#00D8FF");
			sheetObj.SetCellBackColor(Row, "rpr_sz_no","#FFFFFF");
			sheetObj.SetCellEditable(Row, "rpr_qty",1);
			sheetObj.SetCellEditable(Row, "rpr_sz_no",0);
			sheetObj.SetCellValue(Row,"rpr_sz_no","",0);
		} else {
			sheetObj.SetCellBackColor(Row, "rpr_sz_no","#00D8FF");
			sheetObj.SetCellBackColor(Row, "rpr_qty","#FFFFFF");
			sheetObj.SetCellEditable(Row, "rpr_qty",0);
			sheetObj.SetCellValue(Row,"rpr_qty","",0);
			sheetObj.SetCellEditable(Row, "rpr_sz_no",1);
		}
		sheetObj.SetCellEditable(Row, "rpr_lbr_hrs",0);
		sheetObj.SetCellEditable(Row, "rpr_lbr_rt",0);
		sheetObj.SetCellEditable(Row, "lbr_cost_amt",0);
		sheetObj.SetCellEditable(Row, "mtrl_cost_amt",0);
		sheetObj.SetCellEditable(Row, "mnr_wrk_amt",0);
		//setting mnr_lr_acct_flg
		if(formObj.rpr_offh_flg_temp.checked == true){
			sheetObj.SetCellEditable(Row, "mnr_lr_acct_flg",1);
			formObj.rpr_offh_flg.value="Y";
		} else {
			sheetObj.SetCellEditable(Row, "mnr_lr_acct_flg",0);
			formObj.rpr_offh_flg.value="N";
		}
		//setting TPB
		sheetObj.SetCellEditable(Row, "n3pty_flg",0);
		sheetObj.SetCellEditable(Row, "n3pty_bil_lbr_hrs",0);
		sheetObj.SetCellEditable(Row, "n3pty_bil_lbr_rt",0);
		sheetObj.SetCellEditable(Row, "n3pty_bil_mtrl_cost_amt",0);
	}
	function setCommonSheetEdit(sheetObj,arrResult){
		enableOnChange=false;
		var formObj=document.form;
		for(var i=2; i <= sheetObj.LastRow()- 1;i++){
			if(sheetObj.GetCellValue(i,"vol_tp_cd") == "Q"){
				sheetObj.SetCellEditable(i, "rpr_qty",1);
				sheetObj.SetCellEditable(i, "rpr_sz_no",0);
				sheetObj.SetCellValue(i,"rpr_sz_no","",0);
			} else {
				sheetObj.SetCellEditable(i, "rpr_qty",0);
				sheetObj.SetCellValue(i,"rpr_qty","",0);
				sheetObj.SetCellEditable(i, "rpr_sz_no",1);
			}
			//setting mnr_lr_acct_flg
			if(formObj.rpr_offh_flg_temp.checked == true){
				sheetObj.SetCellEditable(i, "mnr_lr_acct_flg",1);
				formObj.rpr_offh_flg.value="Y";
			} else {
				sheetObj.SetCellEditable(i, "mnr_lr_acct_flg",0);
				formObj.rpr_offh_flg.value="N";
			}
			if(sheetObj.GetCellValue(i,"n3pty_flg") == "1"){
				sheetObj.SetCellEditable(i, "n3pty_bil_lbr_hrs",1);
				sheetObj.SetCellEditable(i, "n3pty_bil_lbr_rt",1);
				sheetObj.SetCellEditable(i, "n3pty_bil_mtrl_cost_amt",1);
			} else {
				sheetObj.SetCellEditable(i, "n3pty_bil_lbr_hrs",0);
				sheetObj.SetCellEditable(i, "n3pty_bil_lbr_rt",0);
				sheetObj.SetCellEditable(i, "n3pty_bil_mtrl_cost_amt",0);
			}
			//resetting Comp code value
			sheetObj.SetCellValue(i,"eq_cmpo_cd",arrResult[i - 2][27],0);
			//setting RPR combo
			var checkCompCd=sheetObj.GetCellValue(i,"eq_cmpo_cd");
			//******************** retrieving RPR code in case of changing Component. **************
			var sCondition=new Array (
	 			new Array("MnrRprCd",checkCompCd,"COMMON")
	 		)
			var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
			var sheetComboCode="";
			var sheetComboText="";
			var sheetComboCodeText="";
	 		var comboSaveNames=new Array();
		 	if(comboList[0] != null){
				sheetComboText="";
				sheetComboCode="";
				sheetComboCodeText="";
		 		for(var j=0; j < comboList[0].length;j++){
					var tempText=comboList[0][j].split("|");
					sheetComboCode +=  tempText[0] + "|";
					sheetComboText +=  tempText[1] + "|";
					sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
				}
				sheetComboCode=MnrDelLastDelim(sheetComboCode);
		     	sheetComboText=MnrDelLastDelim(sheetComboText);
		        sheetComboCodeText=MnrDelLastDelim(sheetComboCodeText);
		        var info = {"ComboCode":sheetComboCode, "ComboText":sheetComboCodeText};
				dummyEvent=true;
				sheetObjects[2].CellComboItem (i, "eq_rpr_cd", info);
				dummyEvent=false;
			}
			//resetting RPR code value
			sheetObj.SetCellValue(i,"eq_rpr_cd",arrResult[i - 2][41],0);
			//******************** retrieving RPR code in case of changing Component. END *************
			//setting Div combo
			var checkRprCd=sheetObj.GetCellValue(i,"eq_rpr_cd");
			// setting DIV in case of existing COMP code
			if(checkCompCd != ""){
				var cosCdPrifix=sheetObj.GetCellValue(i,"cost_cd");
				if(cosCdPrifix.length > 3){
					cosCdPrifix=cosCdPrifix.substring(0,3);
				}
				var compRprJoinStr=ComTrimAll(checkCompCd) + ComTrimAll(checkRprCd);
				var sCondition=new Array (
				 	new Array("MnrDivCd",compRprJoinStr + ',' +  cosCdPrifix,"COMMON1")
				)
				var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
				var lbComboText="";
				var lbComboCode="";
				//TS combo type
				if(comboList[0] != null){
					for(var j=0; j < comboList[0].length;j++){
						var tempText=comboList[0][j].split("|");
						lbComboText +=  tempText[0] + "\t" + tempText[1] + "|";
						lbComboCode +=  tempText[0] + "|";
					}
				}
				lbComboCode=MnrDelLastDelim(lbComboCode);
				lbComboText=MnrDelLastDelim(lbComboText);
				var info = {"ComboCode":lbComboCode, "ComboText":lbComboText};
				dummyEvent=true;
				sheetObj.CellComboItem (i, "trf_div_cd", info);
				dummyEvent=false;
			}
			//resetting Div value
			sheetObj.SetCellValue(i,"trf_div_cd",arrResult[i - 2][30],0);
			sheetObj.SetRowStatus(i,"R");
		}
		enableOnChange=true;
	}
	function setEqInfo(sheetObj,sEqType,sEqNo,sTotalLossDate,isYardDisplay){
		var formObj=document.form;
		var sCostType="";
		if(eq_knd_cd.GetSelectCode()== "U"){
			sCostType="MRDRRC";
		} else if(eq_knd_cd.GetSelectCode()== "G"){
			sCostType="MRGSRC";
		} else {
			sCostType="MRZSRC";
		}
		var sXml=MnrComEqGenInfoSearch(sheetObj,sEqType,sEqNo,sTotalLossDate,sCostType);
		var retArr=MnrXmlToArray(sXml);
		//0 imm_ext|1 mdl_nm|2 mvmt_dt|3 dv_cur|4 rpr_yd|5 sp_name|6 flg_rmk|7 manu_dt|8 mkr_nm|9 pagerows|10 dv_value|11 ibflag|12 off_hire|13 mvmt_cd|14 dsp_flag|15 hngr_flg_yd|16 lessor_nm|17 hngr_rck_cd|18 crnt_yd_cd|19 lstm_cd|20 eq_no|21 hngr_flg_dt|22 bar_atch_knt|23 status|24 bar_tp_cd|25 dmg_flag|26 cost|27 mtrl_cd|28 eq_type|29 mtrl_nm|30 rpr_type|31 eq_tpsz_cd|32 rpr_dt
		if(retArr != null){
			
			if(eq_knd_cd.GetSelectCode() == "U"){
				formObj.mvmt_dt.value = retArr[0][2];
				ComBtnEnable("btns_mvmt");
			}
			
			//rpr_dt (in case of rpr_type = retArr[0][30] is equal to EST
			var tagObj=document.getElementById("Repair");
			if(MnrNullToBlank(retArr[0][30]) == 'EST'){
				tagObj.innerHTML=retArr[0][32];
			}
			//imm_ext
			tagObj=document.getElementById("ImmExit");
			tagObj.innerHTML=retArr[0][0];
			//off_hire
			tagObj=document.getElementById("OffHire");
			tagObj.innerHTML=retArr[0][12];
			//dsp_flag
			tagObj=document.getElementById("Disposal");
			tagObj.innerHTML=retArr[0][14];
			//DPP&nbsp
			tagObj=document.getElementById("DPP");
			if(retArr[0][35] != null && retArr[0][35] != ""){
				tagObj.innerHTML=ComAddCommaRun(retArr[0][35]);
			} else {
				tagObj.innerHTML=retArr[0][35];
			}
			//DvValue
			tagObj=document.getElementById("DvValue");
			if(retArr[0][10] != null && retArr[0][10] != ""){
				tagObj.innerHTML=ComAddCommaRun(retArr[0][10]);
			} else {
				tagObj.innerHTML=retArr[0][10];
			}
			//manu_dt
			tagObj=document.getElementById("ManuDt");
			tagObj.innerHTML=retArr[0][7];
			//eq_tpsz_cd
			tagObj=document.getElementById("TpSz");
			tagObj.innerHTML=retArr[0][31];
			formObj.eq_tpsz_cd.value=retArr[0][31];
			//lstm_cd
			tagObj=document.getElementById("Term");
			tagObj.innerHTML=retArr[0][19];
			//lessor_nm
			tagObj=document.getElementById("Lessor");
			tagObj.innerHTML=retArr[0][16];
			//Warranty
			tagObj=document.getElementById("Warranty");
			tagObj.innerHTML='';
			//crnt_yd_cd
			if(isYardDisplay == true){
				ComSetObjValue(formObj.rpr_yd_cd,retArr[0][18]);
			}
		} else {
			document.getElementById("Repair").innerHTML="";
			document.getElementById("ImmExit").innerHTML="";
			document.getElementById("OffHire").innerHTML="";
			document.getElementById("Disposal").innerHTML="";
			document.getElementById("DPP").innerHTML="";
			document.getElementById("DvValue").innerHTML="";
			document.getElementById("ManuDt").innerHTML="";
			document.getElementById("TpSz").innerHTML="";
			document.getElementById("Term").innerHTML="";
			document.getElementById("Lessor").innerHTML="";
			document.getElementById("Warranty").innerHTML="";
			document.getElementById("Repair").innerHTML="";
			if(isYardDisplay == true){
				ComSetObjValue(formObj.rpr_yd_cd,"");
			}
		}
	}
	function setEqInfoClear(){
			var formObj=document.form;
			document.getElementById("Repair").innerHTML="";
			document.getElementById("ImmExit").innerHTML="";
			document.getElementById("OffHire").innerHTML="";
			document.getElementById("Disposal").innerHTML="";
			document.getElementById("DPP").innerHTML="";
			document.getElementById("DvValue").innerHTML="";
			document.getElementById("ManuDt").innerHTML="";
			document.getElementById("TpSz").innerHTML="";
			document.getElementById("Term").innerHTML="";
			document.getElementById("Lessor").innerHTML="";
			document.getElementById("Warranty").innerHTML="";
			document.getElementById("Repair").innerHTML="";
			ComSetObjValue(formObj.rpr_yd_cd,"");
	}
	/**
	 * EES_MNR_0193 receiving function values ​​from Pop-up
	 */
	function setEES_MNR_0193(aryPopupData){
		var tagetSheet=sheetObjects[2];
		for(var i=0; i < aryPopupData.length;i++){
			tagetSheet.SetCellValue(t1sheet1ClickRow,"eq_loc_cd",aryPopupData[i],0);
		}
		setInitSheetEdit(tagetSheet,t1sheet1ClickRow);
		tagetSheet.SelectCell(t1sheet1ClickRow,1);
	}
	/**
	 * COM_ENS_061 receiving function values ​​from Pop-up
	 */
	function getCOM_ENS_061(aryPopupData, row, col, shhetIdx){
    	 var formObj=document.form;
		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "")
    	 	formObj.rpr_yd_cd.value=aryPopupData[0][3];
    }
	function initControl() {
	    //Axon handling event1. event catch
		var formObject=document.form;
//	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			
//	    axon_event.addListenerFormat('focus',    'obj_activate',    formObject);            
//	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            
		axon_event.addListenerFormat('change',	 'obj_change',	formObject); 
	}
	//Axon handling event2. handling event
	function obj_deactivate(){
	    ComChkObjValid(ComGetEvent());
	}
	function obj_activate(){
	    ComClearSeparator(ComGetEvent());
	}
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "rqst_eq_no":
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
				   	break;
				case "rpr_yd_cd":
					doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC03);
				   	break;
			}
	    } else {
			switch(ComGetEvent("name")) {
	    		case "rqst_eq_no":
					setEqInfoClear();
				   	break;
			}
		}
	}
	function obj_keypress(){
	    obj=ComGetEvent();
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat;
		//alert(event.keyCode);
	    switch(obj.dataformat) {
	        case "ymd":
	        case "int":
				ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "eng":
	            ComKeyOnlyAlphabet();
				break;
	        case "engup":
				if(obj.name == "rqst_ref_no"){
					ComKeyOnlyAlphabet('uppernum',"45");
				} else {
					ComKeyOnlyAlphabet('uppernum');
				}
	            break;
	    }
	}
	/**
	 * setting Description
	 * assign using a combination Description in case of changing Component,Repair,Div combo
	 * @param	{IBSheet}	sheetObj	sheetObject
	 * @param	{Int}		Row			Row
	 */
	function setDescripton(sheetObj,Row) {
		var formObj=document.form;
		var componentCode=sheetObj.GetCellValue(Row,"eq_cmpo_cd");
		var componentDesc=getDescription(componentCode,4);
		var divCode=sheetObj.GetCellValue(Row,"trf_div_cd");
		var divDescs=sheetObj.GetComboInfo(Row,"trf_div_cd","Text");
		//getting div Desc
		var arrDivDesc=divDescs.split("|");
		var idx=sheetObj.GetComboInfo(Row,"trf_div_cd", "SelectedIndex");
		var divDesc=MnrNullToBlank(arrDivDesc[idx]);
		if(divDesc != ""){
			var arrDiv=divDesc.split("\t");
			divDesc=arrDiv[1];
		}
		var repairCode=sheetObj.GetCellValue(Row,"eq_rpr_cd");
		var repairDesc=getDescription(repairCode,0);
		var temp="["+componentCode+"]"+componentDesc +" - ["+repairCode+"]"+ repairDesc+" - ["+divCode+"]" + divDesc;
		sheetObj.SetCellValue(Row ,"rpr_dtl_rmk",temp,0);
		formObj.mnr_desc.value=temp;
	}
	/**
	 * getting sheet combo value
	 * getting Component,Repair code name
	 * @param	{String}	Val			Value
	 * @param	{Int}		comboSeq	combo sequence
	 * @return  {String}    tempDesc    CodeName
	 */
	function getDescription(Value,comboSeq){
		var tempDesc="";
 		for(var j=0; j < sheetComboList[comboSeq].length;j++){
			var tempText=sheetComboList[comboSeq][j].split("|");
			if(tempText[0]==Value) {
				tempDesc=tempText[1];
				return tempDesc;
			}
		}
		return tempDesc;
	}
	/**
	 * Amount must be greater than or equal to 0 in case of checking TPB Request
	 * @return {Boolean}
	 */
	function checkTpbAmount() {
		for(var i=sheetObjects[2].HeaderRows(); i<sheetObjects[2].LastRow(); i++) {
			var n3ptyFlg=sheetObjects[2].GetCellValue(i,"n3pty_flg"); //TPB Request
			if(n3ptyFlg == "1") {
				var n3ptyBilAmt=sheetObjects[2].GetCellValue(i,"n3pty_bil_amt"); //TPB Amount
				if(n3ptyBilAmt <= 0) {
					ComShowCodeMessage("MNR00329"); //Third Party Amount must be greater than 0(Zero).
					sheetObjects[2].SelectCell(i, "n3pty_bil_amt", true);
					return false;
				}
			}
		}
		return true;
	}
	/* developer job */