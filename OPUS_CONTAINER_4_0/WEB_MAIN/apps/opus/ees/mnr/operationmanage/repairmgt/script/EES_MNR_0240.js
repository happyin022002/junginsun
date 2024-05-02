/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_MNR_0240.jsp
*@FileTitle : Repair Estimate EDI Auditing
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
/****************************************************************************************
  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* Developer's task	*/
// Common global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var DLCSheets=new Array();
var DLCSheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
//IBSAVE/IBBATCH for separate message
var saveType="";
//Retrieving or not (Can be deleted after retrieving)
var selCheck=false;
//Repair Work Type combo code
var rwTypedefCode="";
//Variable of upload file sequence
var uploadFileSeq="";
//Variable of onchange event processing
var enableOnChange=true;
//t1sheet1 event
var dummyEvent=false;
var sheetComboList=new Array();
//Variable for finding clicked row
var t1sheet1ClickRow=0;
var sXml_1 = "";
var offFlg = "";
// Defining event handler of button click */
document.onclick=processButtonClick;
// Event handler to diverge process by button name */
    function processButtonClick(){
        /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
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
					doActionIBSheet(sheetObjects[0],formObject,IBCLEAR);
					break;
				case "btn_Counteroffer":
					doActionIBSheet(sheetObjects[2],formObject,IBSEARCHAPPEND);
					break;
				case "btn_Reject":
					doActionIBSheet(sheetObjects[2],formObject,IBCREATE);
					break;
				case "btn_Approval":
					doActionIBSheet(sheetObjects[2],formObject,IBSAVE);
					break;
				case "btn_Later":
					doActionIBSheet(sheetObjects[2],formObject,IBRESET);
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
					file_Insert(t2_sheet8);
					break;
				case "btn_FileDel":
					file_Remove(t2_sheet8);
					break;
			 	case "btns_calendar":
                	var cal=new ComCalendar();
                	cal.select(formObject.eq_dmg_dt, 'yyyy-MM-dd');
                	break;
				//yard popup
				case "btn_popup":
					ComOpenPopup('/opuscntr/COM_ENS_061.do', 766, 550, 'getCOM_ENS_061', '1,0,1,1,1,1,1,1,1,1,1,1', true);
                    break;
				//EQ_INFO DETAIL information
				case "btn_detail":
					if(formObject.rqst_eq_no.value != ""){
						 ComOpenWindowCenter("EES_MNR_0191.do?eq_no=" + formObject.rqst_eq_no.value + "&mnr_wo_tp_cd=EST", "EES_MNR_0191", 901, 495, true);
					}
                    break;
				case "rpr_offh_flg_temp":
						doActionIBSheet(sheetObjects[2], formObject , IBSEARCH_ASYNC02);
					break;
				case "btn_Verify":
						doActionIBSheet(sheetObjects[2], formObject , IBBATCH);
					break;
				case "btn_Upload":
					ComOpenWindowCenter("/opuscntr/EES_MNR_0243.do?req_ui=EES_MNR_0240", "EES_MNR_0243", 850, 500, true);
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
    
    /**
     * Assigning array of IBSheet object
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
	/**
	 * Assigning array of IBTab object
	 * Array defined at the top of the source
	*/
	function setTabObject(tab_obj){
		tabObjects[tabCnt++]=tab_obj;
	}
	/**
	 * Assigning array of IBCombo object
	 * @param	{IBMultiCombo}	combo_obj
	 * Array defined at the top of the source
	 */
	function setComboObject(combo_obj){
    	comboObjects[comboCnt++]=combo_obj;
	}
    /**
     * Sheet default setting and initializing
     * To implement for onload event of body tag
     * After loading in your browser should display the ability to add pre-processing
     */
    function loadPage() {
		MnrWaitControl(true);
		initControl();
		//hidden data for retrieving
		initSheet(sheetObjects[0],1);
		DLCSheetCnt=0;
        for(i=1;i < sheetObjects.length;i++){
				ComConfigSheet(sheetObjects[i]);
				initSheet(sheetObjects[i],i + 1);
				ComEndConfigSheet(sheetObjects[i]);
				if(sheetObjects[i].id.substring(0,2) == "t2" && sheetObjects[i].id != "t2_sheet8"){
					DLCSheets[DLCSheetCnt++]=sheetObjects[i];
				}
        }
		for(k=0;k < tabObjects.length;k++){
			initTab(tabObjects[k],k + 1);
			tabObjects[k].SetSelectedIndex(0);
		}
		for(k=0;k < comboObjects.length;k++){
            initCombo(comboObjects[k],k + 1);
        }
		initUpload();
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }
    
    var pSheetObj, pRow, pCol ;
    function initUpload(){
 		upload1.Initialize({
 			SaveUrl:'/opuscntr/MNR_INTGS.do'
 			,Files:[]
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
		 		var sParam = "f_cmd="+COMMAND01;
		 		sParam+= "&mnr_grp_tp_cd=RPR";       // MNR Work Group Type Code
		 		sParam+= "&file_seq=" + file_seq;    // Existed file sequence
		 		sParam+= "&file_dtl_seq=" + file_dtl_seq;    // Existed file sequence
		 		sParam+= "&org_file_nm=" + fileName; // Fileupload file name
		 		sParam+= "&ibflag=" + ibflag;        // I : First time file upload, U : modify file
		 		paramToForm(sParam);
			 	return true;
			}
			,AfterSaveStatus : function(result) {
	      		var code = result.code;
	      		if( code == 0) {
	      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
	 				uploadFileSeq=ComGetEtcData(sXml,"seqValue");
					if(uploadFileSeq != "" && uploadFileSeq != undefined){
						var fileXml = SearchFileUpload(sheetObjects[10],uploadFileSeq);
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
				if(fileType != "GIF" && fileType != "BMP" && fileType != "TIFF" && fileType != "TIF" && fileType != "JPG"){
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
	 * Combo Setting default
	 * @param	{IBMultiCombo}	combo_obj.
	 * @param	{Number}	comboNo		Sequence number from combo object tag id
	 */
	function initCombo (comboObj, comboNo) {
	    var formObject=document.form
	    switch(comboNo) {
			   default :
		           with (comboObj) {
				       //SetColAlign("left");
					   //DropHeight = 160;
			       }
	           break;
	     }
	}
	/**
	 * Tab Setting default
	 * Setting tab's item
	 */
	function initTab(tabObj , tabNo) {
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
		}
	}
   /**
     * Initializing variable for IBSheet and defining header
     * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
        	case "sheet1":
        		with(sheetObj){
        			SetVisible(false);
        		}
        		break;
            case "sheet2": 
                with(sheetObj){
		             
		             var HeadTitle1="|Seq.|Service Provider Name|Status|Revise Count|EQ Type|EQ No.|TP/SZ|Input|Estimate No.|Office|T/Amount|Status DT";
		             var headCount=ComCountHeadTitle(HeadTitle1);
		
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:3, DataRowMerge:1 } );
		
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                 {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"vndr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Combo",     Hidden:0, Width:113,  Align:"Left",    ColMerge:1,   SaveName:"rpr_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"rpr_dtl_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eq_knd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Combo",     Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"mnr_inp_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"rqst_ref_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cost_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"total_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rpr_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"eq_dmg_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rpr_offh_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_rpr_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"file_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"apro_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rpr_rqst_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rpr_rqst_ver_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"auto_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"appoval_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"uppr_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trf_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"edi_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trsm_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"rpr_wrk_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"mnr_meas_ut_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		              
		             InitColumns(cols);
		             SetEditable(0);
		             SetColFontColor("TP","#FF0000");
		             SetSelectionMode(smSelectionRow);
		             SetSheetHeight(162);
             }
             break;


			case "t1sheet1":  
		        with(sheetObj){
               
		            var HeadTitle1="|Sel|Seq.|Mandatory Code|Mandatory Code|Mandatory Code|Mandatory Code|Option|Cost Code|Cost Code Name|Volume|Volume|Volume|Labor|Labor|Labor|Material|Amount|Verify Result|Tariff Labor|Tariff Labor|Tariff Labor|Tariff\nMaterial|Tariff\nAmount|Lessor Account|TPB Request|TPB Labor|TPB Labor|TPB Labor|TPB Material|TPB Amount";
		            var HeadTitle2="|Sel|Seq.|Location|Component|Damage|Repair|Division|Cost Code|Cost Code Name|Type|QTY|Size/Square|Hour|Rate|Cost|Material|Amount|Verify Result|Hour|Rate|Cost|Tariff\nMaterial|Tariff\nAmount|Lessor Account|TPB Request|Hour|Rate|Cost|TPB Material|TPB Amount";
		            var headCount=ComCountHeadTitle(HeadTitle1);
		
		            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		            var headers = [ { Text:HeadTitle1, Align:"Center"},
		                    { Text:HeadTitle2, Align:"Center"} ];
		            InitHeaders(headers, info);
		
		            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		             {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_loc_cd",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"ComboEdit", Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eq_cmpo_cd",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		             {Type:"ComboEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eq_dmg_cd",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		             {Type:"ComboEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eq_rpr_cd",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trf_div_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",   ColMerge:1,   SaveName:"cost_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",   ColMerge:1,   SaveName:"cost_cd_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Combo",     Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vol_tp_cd",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"rpr_qty",                  KeyField:0,   CalcLogic:"",  Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		             {Type:"Int",       Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"rpr_sz_no",                KeyField:0,   CalcLogic:"",  Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
		             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rpr_lbr_hrs",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		             {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rpr_lbr_rt",               KeyField:0,   CalcLogic:"",  Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"lbr_cost_amt",             KeyField:0,   CalcLogic:"|rpr_lbr_hrs|*|rpr_lbr_rt|",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"mtrl_cost_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		             {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"mnr_wrk_amt",              KeyField:0,   CalcLogic:"|lbr_cost_amt|+|mtrl_cost_amt|",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		             {Type:"Combo",     Hidden:0, Width:140,  Align:"Left",    ColMerge:1,   SaveName:"mnr_vrfy_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rpr_lbr_bzc_hrs",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rpr_lbr_bzc_rt",           KeyField:0,   CalcLogic:"",  Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"mnr_lbr_bzc_amt",          KeyField:0,   CalcLogic:"|rpr_lbr_bzc_hrs|*|rpr_lbr_bzc_rt|",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
		             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"lbr_mtrl_bzc_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"mnr_agmt_amt",             KeyField:0,   CalcLogic:"|mnr_lbr_bzc_amt|+|lbr_mtrl_bzc_amt|",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		             {Type:"CheckBox",  Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"mnr_lr_acct_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"n3pty_bil_lbr_hrs",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		             {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"n3pty_bil_lbr_rt",         KeyField:0,   CalcLogic:"",  Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"n3pty_lbr_cost_amt",       KeyField:0,   CalcLogic:"|n3pty_bil_lbr_hrs|*|n3pty_bil_lbr_rt|",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"n3pty_bil_mtrl_cost_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"n3pty_bil_amt",            KeyField:0,   CalcLogic:"|n3pty_lbr_cost_amt|+|n3pty_bil_mtrl_cost_amt|",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		             {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"eq_loc_cd_chk_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"eq_cmpo_cd_chk_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"eq_dmg_cd_chk_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"eq_rpr_cd_chk_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cost_dtl_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"rpr_dtl_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		             
		            InitColumns(cols);
		            SetEditable(1);
		            SetEditableColorDiff(1);
                    SetColFontColor("Component","#FF0000");
		            //conversion of function[check again]CLT 					InitDataValid(0,  "eq_loc_cd", vtEngUpOther,"0123456789");
		            //conversion of function[check again]CLT 					InitDataValid(0,  "eq_cmpo_cd", vtEngUpOther,"0123456789");
		            //conversion of function[check again]CLT 					InitDataValid(0,  "eq_rpr_cd", vtEngUpOther,"0123456789");
		            SetSelectionMode(smSelectionRow);
		            InitComboNoMatchText(true);
		            SetShowButtonImage(2);
		            SetSheetHeight(240);
            }
            break;

            case "t2_sheet1":
            case "t2_sheet2":
                with(sheetObj){
		             var HeadTitle1="";
		             if(sheetObj.id == 't2_sheet1')
		             HeadTitle1="|1|2|3|4";
		             else
		             HeadTitle1="|4|3|2|1";
		             var headCount=ComCountHeadTitle(HeadTitle1);
		             var leftHeaders = [{Text:"H|T|B|G", Align:"Left"}];
		             var RowText="H|T|B|G";
		             var RowVals=RowText.split("|");
		             var widthVals=new Array(21,21,21,21);
		             var ColVals=HeadTitle1.split("|");
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		             for(var i=0; i < 4 ; i++){
		            	 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		            	 var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		            	 var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		            	 InitHeaders(headers, info);
		
		            	 var cols = [ {Type:"Text",     Hidden:0,  Width:22,   Align:"Center",  ColMerge:0,   SaveName:"Left" } ];
		                 for(var j = 1 ; j < 5 ; j++){
		                      cols.push({Type:"CheckBox",  Hidden:0, Width:widthVals[j-1],Align:"Center",  ColMerge:1,   SaveName:"DLC" });
		                 }
	                 }

		             InitColumns(cols);
		             SetEditable(1);
		             InitHeadColumn(leftHeaders,sheetObj);
		             SetSelectionMode(smSelectionCol);
		             SetSheetHeight(132);
		             SetSheetWidth(116);
		             SetCountPosition(0);
		             SetFocusAfterProcess(0);
	             }
             break;


            case "t2_sheet3":
            case "t2_sheet4":
                with(sheetObj){
		             var HeadTitle1="";
		             if(sheetObj.id == 't2_sheet3')
		             HeadTitle1="|0|9|8|7|6|5|4|3|2|1";
		             else
		             HeadTitle1="|1|2|3|4|5|6|7|8|9|0";
		             var headCount=ComCountHeadTitle(HeadTitle1);
		             var leftHeaders = [{Text:"H|T|B|G", Align:"Left"}];
		             var RowText="H|T|B|G";
		             var RowVals=RowText.split("|");
		             var widthVals=new Array(20,30,30,20);
		             var ColVals=HeadTitle1.split("|");
		             for(var i=0; i < 4 ; i++){
		
		            	 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		             	 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             	 var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		             	 InitHeaders(headers, info);
		
		             	 var cols = [ {Type:"Text",     Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"Left" } ];
			             for(var j = 1 ; j < 11 ; j++){
			             	cols.push({Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"DLC" });
			             }
		             }
		             InitColumns(cols);
		             SetEditable(1);
		             InitHeadColumn(leftHeaders,sheetObj);
		             SetSelectionMode(smSelectionCol);
		             SetSheetHeight(132);
		             SetSheetWidth(230);
		             SetCountPosition(0);
		             SetFocusAfterProcess(0);
             }
             break;


            case "t2_sheet5":
            case "t2_sheet6":
            case "t2_sheet7":
                with(sheetObj){
	              var HeadTitle1="|1|2|3|4|5|6|7|8|9|0";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              var leftHeaders = [{Text:"L|R", Align:"Left"}];
	              var RowText="L|R";
	              var RowVals=RowText.split("|");
	              var ColVals=HeadTitle1.split("|");
	              for(var i=0; i < 2 ; i++){
	
	            	  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	            	  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            	  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	            	  InitHeaders(headers, info);
	
	            	  var cols = [ {Type:"Text",     Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"Left" } ];
	            	  for(var j = 1 ; j < 11 ; j++){
	            		  cols.push({Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"DLC" });
	            	  }
	              }
	              InitColumns(cols);
	              SetEditable(1);
	              InitHeadColumn(leftHeaders,sheetObj);
	              SetSelectionMode(smSelectionCol);
	              SetCountPosition(0);
	              SetSheetHeight(80);
	              SetSheetWidth(230);
	              SetFocusAfterProcess(0);
	              //SetSheetHeight(63);
              }
              break;


            case "t2_sheet8" :
            	  with(sheetObj){
		                var prefix="";
		               var HeadTitle1="|Photo Attachment|Photo Attachment|Photo Attachment";
		               var HeadTitle2="|Seq|File|Download";
		               var headCount=ComCountHeadTitle(HeadTitle1);
		
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		               var headers = [ { Text:HeadTitle1, Align:"Center"},
		                             { Text:HeadTitle2, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                         {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk" },
		                         {Type:"Popup",     Hidden:0, Width:180,  Align:"Center",  ColMerge:0,   SaveName:prefix+"org_file_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
		                         {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_dw",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"file_dtl_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		                
		               InitColumns(cols);
		               SetEditable(1);
		               SetImageList(0,"img/ico_attach.gif");
		               SetShowButtonImage(1);
		               SetSheetHeight(262);
               }
               break;


        }
    }
	//Sheet processing-related processes
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			 case IBSEARCH:      //Retrieving list   rqst_type
                 if(validateForm(sheetObj,formObj,sAction)){
				 	if(sheetObj.id =="sheet2"){
						var f_query='';
						f_query += 'f_cmd' + '=' + SEARCH + '&';
						f_query += 'apro_ofc_cd=' +  formObj.apro_ofc_cd.value  + '&';
						f_query += 'rqst_type=' +  formObj.rqst_type.value;
          				sheetObj.DoSearch("EES_MNR_0240GS.do",f_query );
					}
				  }
                break;
			case IBROWSEARCH:      //Retrieving detail
                 if(validateForm(sheetObj,formObj,sAction)){
					 	formObj.f_cmd.value=SEARCH01;
					    sParam="f_cmd=" + formObj.f_cmd.value +
								 "&rqst_eq_no=" + formObj.rqst_eq_no.value +
								 "&rpr_rqst_seq=" + formObj.rpr_rqst_seq.value +
						 		 "&rpr_rqst_ver_no=" + formObj.rpr_rqst_ver_no.value +
								 "&rpr_rqst_lst_ver_flg=" + formObj.rpr_rqst_lst_ver_flg.value;
 					    var sXml=sheetObj.GetSaveData("EES_MNR_0240GS.do", sParam);
 					    sXml_1 = sXml;
					    sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
						
				  }
                break;
			case IBSEARCHAPPEND:      //Counteroffer
                  if(validateForm(sheetObj,formObj,sAction)){
						formObj.f_cmd.value=COMMAND02;
						if(uploadFileSeq != undefined){
							formObj.file_seq.value=uploadFileSeq;
						}
						var sParam=sheetObj.GetSaveString(true, true);
						if(sParam == "" && sheetObj.IsDataModified()){
							return;
						}
						sParam=ComSetPrifix(sParam,"rqstDtl_");
					    sParam += "&" + FormQueryString(formObj);
 					    var sXml=sheetObj.GetSaveData("EES_MNR_0240GS.do", sParam);
 						sheetObjects[1].LoadSaveData(sXml);
						//Initializing
						selCheck=false;
						//Initializing form
						setEqInfoClear();
						formObj.reset();
						//Initializing combo
						for(var i=0; i < comboObjects.length;i++){
							comboObjects[i].SetSelectCode("-1");
						}
						eq_knd_cd.SetEnable(false)
						trsm_mod_cd.SetEnable(false)
						//Initializing sheet
						sheetObjects[2].RemoveAll();
 						sheetObjects[2].SetSumText(0,"eq_loc_cd","TOTAL");
				  }
				break;
			case IBCREATE:        //Reject
	              if(validateForm(sheetObj,formObj,sAction)){
						formObj.f_cmd.value=COMMAND03;
						if(uploadFileSeq != undefined){
							formObj.file_seq.value=uploadFileSeq;
						}
						var sParam=sheetObj.GetSaveString(true, true);
						if(sParam == "" && sheetObj.IsDataModified()){
							return;
						}
						sParam=ComSetPrifix(sParam,"rqstDtl_");
					    sParam += "&" + FormQueryString(formObj);
 					    var sXml=sheetObj.GetSaveData("EES_MNR_0240GS.do", sParam);
 						sheetObjects[1].LoadSaveData(sXml);
						MnrWaitControl(true);
						selCheck=false;
						//Initializing form
						setEqInfoClear();
						formObj.reset();
						//Initializing combo
						for(var i=0; i < comboObjects.length;i++){
							comboObjects[i].SetSelectCode("-1");
						}
						eq_knd_cd.SetEnable(false)
						trsm_mod_cd.SetEnable(false)
						//Initializing sheet
						sheetObjects[2].RemoveAll();
 						sheetObjects[2].SetSumText(0,"eq_loc_cd","TOTAL");
						MnrWaitControl(false);
				  }
				 break;
			case IBSAVE:        //Approval
	             if(validateForm(sheetObj,formObj,sAction)){
						formObj.f_cmd.value=COMMAND04;
						if(uploadFileSeq != undefined){
							formObj.file_seq.value=uploadFileSeq;
						}
						var sParam=sheetObj.GetSaveString(true, true);
						if(sParam == "" && sheetObj.IsDataModified()){
							return;
						}
						sParam=ComSetPrifix(sParam,"rqstDtl_");
					    sParam += "&" + FormQueryString(formObj);
 					    var sXml=sheetObj.GetSaveData("EES_MNR_0240GS.do", sParam);
 						sheetObjects[1].LoadSaveData(sXml);
						MnrWaitControl(true);
						selCheck=false;
						//Initializing form
						setEqInfoClear();
						formObj.reset();
						//Initializing combo
						for(var i=0; i < comboObjects.length;i++){
							comboObjects[i].SetSelectCode("-1");
						}
						eq_knd_cd.SetEnable(false)
						trsm_mod_cd.SetEnable(false)
						//Initializing sheet
						sheetObjects[2].RemoveAll();
 						sheetObjects[2].SetSumText(0,"eq_loc_cd","TOTAL");
						MnrWaitControl(false);
				  }
				 break;
			 case IBRESET:        //Audit it Later
	             if(validateForm(sheetObj,formObj,sAction)){
				  		saveType="IBRESET";
						formObj.f_cmd.value=COMMAND05;
						if(uploadFileSeq != undefined){
							formObj.file_seq.value=uploadFileSeq;
						}
						var sParam=sheetObj.GetSaveString(true, true);
						if(sParam == "" && sheetObj.IsDataModified()){
							return;
						}
						sParam=ComSetPrifix(sParam,"rqstDtl_");
						sParam += "&" + FormQueryString(formObj);
 						var sXml=sheetObj.GetSaveData("EES_MNR_0240GS.do", sParam);
 						sheetObjects[1].LoadSaveData(sXml);
						if(MnrComGetErrMsg(sXml) == null){
							var rqstEqNo=ComGetEtcData(sXml, "rqst_eq_no");
							var rprRqstSeq=ComGetEtcData(sXml, "rpr_rqst_seq");
							var rprRqstVerNo=ComGetEtcData(sXml, "rpr_rqst_ver_no");
							var targetRow=0;
							with(sheetObjects[1]){
								for(var j=1; j <= LastRow();j++){
									if(GetCellValue(j,"rqst_eq_no") == rqstEqNo && GetCellValue(j,"rpr_rqst_seq") == rprRqstSeq && GetCellValue(j,"rpr_rqst_ver_no") == rprRqstVerNo){
										targetRow=j;
									}
								}
							}
							if(targetRow != 0){
								sheetObjects[1].SelectCell(targetRow,1);
								sheet2_OnDblClick(sheetObjects[1],targetRow,1);
							}
						}
				  	}
					 break;
			 case IBBATCH:        //Verify
              if(validateForm(sheetObj,formObj,sAction)){
			  	 	saveType="IBBATCH";
					formObj.f_cmd.value=COMMAND01;
					var sParam=sheetObj.GetSaveString(true, true);
					if(sParam == "" && sheetObj.IsDataModified()){
						return;
					}
					sParam=ComSetPrifix(sParam,"rqstDtl_");
				    sParam += "&" + FormQueryString(formObj);
 				    var sXml=sheetObj.GetSaveData("EES_MNR_0240GS.do", sParam);
					if(MnrComGetErrMsg(sXml) == null){
						//Inserting verify and tariff value
						//0 vol_tp_cd|1 mnr_vrfy_tp_cd|2 rpr_sz_no|3 xch_mtrl_cost_amt|4 mnr_lr_acct_flg|5 n3pty_bil_lbr_hrs|6 n3pty_bil_mtrl_cost_amt|7 lbr_cost_amt|8 pagerows|9 eq_cmpo_cd_chk_flg|10 ibflag|11 n3pty_bil_lbr_rt|12 cre_dt|13 trf_opt_cd|14 rpr_rqst_lst_ver_flg|15 rpr_rqst_ver_no|16 rpr_rqst_dtl_seq|17 eq_loc_cd|18 rqst_eq_no|19 upd_usr_id|20 eq_loc_cd_chk_flg|21 n3pty_flg|22 rpr_lbr_bzc_hrs|23 rpr_lbr_hrs|24 cre_usr_id|25 cost_cd|26 lbr_mtrl_bzc_amt|27 eq_cmpo_cd|28 rpr_len_no|29 eq_rpr_cd_chk_flg|30 trf_div_cd|31 rpr_wdt_no|32 rpr_dtl_rmk|33 mnr_wrk_amt|34 eq_dmg_cd|35 cost_dtl_cd|36 rpr_lbr_rt|37 rpr_qty|38 n3pty_bil_amt|39 eq_dmg_cd_chk_flg|40 mtrl_reco_amt|41 eq_rpr_cd|42 rpr_lbr_bzc_rt|43 upd_dt|44 mnr_lbr_bzc_amt|45 n3pty_bil_lbr_cost_amt|46 mtrl_cost_amt|47 rpr_rqst_seq
						var arrResult=MnrXmlToArray(sXml);
						for(var i=0; i < arrResult.length; i++){
							sheetObj.SetCellValue(i + 2, "rpr_lbr_bzc_hrs",arrResult[i][22],0);
							sheetObj.SetCellValue(i + 2, "rpr_lbr_bzc_rt",arrResult[i][42],0);
							sheetObj.SetCellValue(i + 2, "mnr_lbr_bzc_amt",arrResult[i][44],0);
							sheetObj.SetCellValue(i + 2, "lbr_mtrl_bzc_amt",arrResult[i][26],0);
							sheetObj.SetCellValue(i + 2, "mnr_vrfy_tp_cd",arrResult[i][1],0);
						}
						//Verifying of value
						for(var j=2; j <= sheetObj.LastRow()- 1; j++) {
							if(formObj.rpr_offh_flg.value == 'Y'){
								sheetObj.SetCellEditable(j, "mnr_lr_acct_flg",1);
								sheetObj.SetCellValue(j, "mnr_vrfy_tp_cd","OF");
							} else {
								sheetObj.SetCellEditable(j, "mnr_lr_acct_flg",0);
							}
							var mnrVrfyTpCd=sheetObj.GetCellValue(j,  "mnr_vrfy_tp_cd");
							if(mnrVrfyTpCd == "SS" || mnrVrfyTpCd == "SL"){
 								sheetObj.SetCellFontColor(j,"mnr_vrfy_tp_cd","#0000FF");
							} else {
 								sheetObj.SetCellFontColor(j,"mnr_vrfy_tp_cd","#FF0000");
							}
						}
						if(sheetObj.RowCount()>= 1) {
							sheetObj.SelectCell(2,1);
						}
						if(MnrNullToBlank(ComGetEtcData(sXml,"RQST_EQ_NO")) != ''){
							//Calling pop-up when existed data
							var rqstEqNo=MnrNullToBlank(ComGetEtcData(sXml,"RQST_EQ_NO"));
							var rprRqstSeq=MnrNullToBlank(ComGetEtcData(sXml,"RPR_RQST_SEQ"));
							var rprRqstVerNo=MnrNullToBlank(ComGetEtcData(sXml,"RPR_RQST_VER_NO"));
							var eqKndCd=MnrNullToBlank(ComGetEtcData(sXml,"EQ_KND_CD"));
							var recentRprTpCd=MnrNullToBlank(ComGetEtcData(sXml,"RECENT_RPR_TP_CD"));
							ComOpenPopup('/opuscntr/EES_MNR_0192.do?rqst_eq_no='+rqstEqNo+"&rpr_rqst_seq="+rprRqstSeq+"&rpr_rqst_ver_no="+rprRqstVerNo+"&eq_knd_cd="+eqKndCd+"&recent_rpr_tp_cd="+recentRprTpCd, 1024, 768, '', '0,0', false);
						}
						ComShowCodeMessage("MNR00158");
					} else {
						ComShowCodeMessage("MNR00159",MnrComGetErrMsg1(sXml));
					}
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
 					sheetObj.SetSumText(0,"eq_loc_cd","TOTAL");
					//Editable
					setInitSheetEdit(sheetObj,Row);
					sheetObj.SelectCell(Row, 1);
				}
                break;
			 case IBDELETE:
			 		MnrRowDelete(sheetObj,  "del_chk");
			 	break;
			 case IBCLEAR:      //Initializing
				MnrWaitControl(true);
				selCheck=false;
				uploadFileSeq="";
				//Initializing form
				setEqInfoClear();
				formObj.reset();
				//Initializing sheet
				sheetObjects[2].RemoveAll();
				t2_sheet8.RemoveAll();
 				sheetObjects[2].SetSumText(0,"eq_loc_cd","TOTAL");
				for(var i=0; i < comboObjects.length;i++){
					comboObjects[i].SetSelectCode("-1");
					comboObjects[i].RemoveAll();
				}
				eq_knd_cd.SetEnable(false)
				trsm_mod_cd.SetEnable(false)
				//Retrieving combo data
				var sCondition=new Array (
					new Array("MnrGenCd","CD00016", "COMMON"),
					new Array("MnrGenCd","CD00018", "COMMON"),
					new Array("MnrGenCd",selfOfcCd,"CUSTOM9"),
					//sheetObjects[1] HDR LIST sheet Setting combo
					new Array("MnrGenCd","CD00008", "COMMON"),
					new Array("MnrGenCd","CD00019", "COMMON"),
					new Array("MnrGenCd","CD00002", "COMMON"),
					//sheetObjects[2] DTL LIST sheet Setting combo
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
						trsm_mod_cd.InsertItem(j, tempText[1] ,tempText[0]);
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
						eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
					}
				}
				eq_knd_cd.SetSelectCode("");
				//sheet1,sheet2  Setting combo
				var sheetComboCode="";
				var sheetComboText="";
				var sheetComboCodeText="";
				//Saving for DEF Value
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
				ComBtnDisable("btns_mvmt");
				setDLC(sheetObjects[2]);
				MnrWaitControl(false);
				break;
				case IBSEARCH_ASYNC01:	//Retrieving(Eq No. at inserting validation )
				if ( validateForm(sheetObj, formObj, sAction) ) {
					//Checking EQ_TYPE
					if(eq_knd_cd.GetSelectCode()== ""){
						ComShowCodeMessage("MNR00238",checkEqn,"EQ No.");
						ComSetObjValue(formObj.rqst_eq_no, "");
						formObj.eq_knd_cd.focus();
						return;
					} else {
						var checkEqn=formObj.rqst_eq_no.value;
						var retArray=MnrGeneralCodeCheck(sheetObj,"ESTEQN",checkEqn + "," + eq_knd_cd.GetSelectCode());
						if(retArray == null){
							ComShowCodeMessage("MNR00165",checkEqn,"EQ No.");
							ComSetObjValue(formObj.rqst_eq_no, "");
							ComSetFocus(formObj.rqst_eq_no);
							return;
						} else {
							//Displaying EQ_NUMBER Equipment information
							setEqInfo(sheetObj,eq_knd_cd.GetSelectCode(),formObj.rqst_eq_no.value,ComGetNowInfo("ymd"));
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
				case IBSEARCH_ASYNC02:	//In case of changing off_hire
					var endPoint=sheetObj.LastRow()- 1;
					for(var Row=2; Row <= endPoint;Row++){
						//Setting mnr_lr_acct_flg
						if(formObj.rpr_offh_flg_temp.checked == true){
							sheetObj.SetCellEditable(Row, "mnr_lr_acct_flg",1);
							formObj.rpr_offh_flg.value="Y";
							sheetObj.SetCellValue(Row ,"mnr_vrfy_tp_cd","",0);
						} else {
							sheetObj.SetCellValue(Row ,"mnr_lr_acct_flg","0");
							sheetObj.SetCellEditable(Row, "mnr_lr_acct_flg",0);
							formObj.rpr_offh_flg.value="N";
							sheetObj.SetCellValue(Row ,"mnr_vrfy_tp_cd","",0);
						}
						var checkCompCd=sheetObj.GetCellValue(Row,"eq_cmpo_cd").toUpperCase();
						if(ComGetObjValue(formObj.eq_tpsz_cd) != "" && checkCompCd != ""){
							var costCdSet=MnrGetCostCd(sheetObj,eq_knd_cd.GetSelectCode(),formObj.eq_tpsz_cd.value,checkCompCd, formObj.rpr_offh_flg.value);
							var arrCostCd = costCdSet.split("|");
							sheetObj.SetCellValue(Row,"cost_cd",arrCostCd[0],0);
							sheetObj.SetCellValue(Row,"cost_cd_nm",arrCostCd[1],0);
							if(formObj.rpr_offh_flg.value == "Y"){
								sheetObj.SetCellValue(Row,"cost_dtl_cd","OF",0);
							}else{
								sheetObj.SetCellValue(Row,"cost_dtl_cd","NR",0);
							}
						}
					}
				break;
				case IBSEARCH_ASYNC03:	//Retrieving(YARD at inserting validation )
					var checkYard=formObj.rpr_yd_cd.value;
					retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
					if(retArray == null){
						ComShowCodeMessage("MNR00165",checkYard,"YARD");
						ComSetObjValue(formObj.rpr_yd_cd, "");
						ComSetFocus(formObj.rpr_yd_cd);
					} else {
						return;
					}
				break;
		}
    }
	 /**
     * Adding row when adding file
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return {nothing}
     **/
	function file_Insert(sheetObj){
		//**** CAUTION : Modifying by header row count - CellValue(2,"file_seq")
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
     * Validating process for input form data
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
			case IBROWSEARCH:
				if (!ComChkValid(formObj)) return false;
			 	break;
			case IBCREATE: 	  //Reject
				if(!selCheck){
					ComShowCodeMessage("MNR00220");
					return false;
				}
				//In case of Service Provider = ""
				if(formObj.vndr_nm.value == ""){
					ComShowCodeMessage("MNR00036","Service Provider ");
					formObj.vndr_nm.value.focus();
					return false;
				}
				//In case of Repair Status = ""
				if(rpr_wrk_tp_cd.GetSelectCode()== ""){
					ComShowCodeMessage("MNR00036","Repair Status ");
					formObj.rpr_wrk_tp_cd.focus();
					return false;
				}
				//Checking Q'ty, Size/Square data of VolumnType of each sheet
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
						//Showing message in case of Verify Result = ""
						if(sheetObj.GetCellValue(j, "mnr_vrfy_tp_cd") == ""){
							ComShowCodeMessage("MNR00337");
							return false;
						}
					}
				} else {
					ComShowCodeMessage("MNR00207");
					return false;
				}
				//Checking mandatory input data
				if (!ComChkValid(formObj)) return false;
				//REJECT Question before Saving data
				if (!ComShowCodeConfirm("MNR00275","Estimate","Reject")){return false;}
				break;
			case IBSEARCHAPPEND: 	  //Counteroffer
				if(!selCheck){
					ComShowCodeMessage("MNR00219");
					return false;
				}
				//In case of Service Provider = ""
				if(formObj.vndr_nm.value == ""){
					ComShowCodeMessage("MNR00036","Service Provider ");
					formObj.vndr_nm.value.focus();
					return false;
				}
				//In case of Repair Status = ""
				if(rpr_wrk_tp_cd.GetSelectCode()== ""){
					ComShowCodeMessage("MNR00036","Repair Status ");
					formObj.rpr_wrk_tp_cd.focus();
					return false;
				}
				//Checking Q'ty, Size/Square data of VolumnType of each sheet
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
						//Showing message in case of Verify Result = ""
						if(sheetObj.GetCellValue(j, "mnr_vrfy_tp_cd") == ""){
							ComShowCodeMessage("MNR00337");
							return false;
						}
					}
				} else {
					ComShowCodeMessage("MNR00207");
					return false;
				}
				//Checking mandatory input data
				if (!ComChkValid(formObj)) return false;
				//COUNTEROFFER Question before Saving data
				if (!ComShowCodeConfirm("MNR00275","Estimate","Counteroffer")){return false;}
				break;
			case IBSAVE:     		//Approval
				if(!selCheck){
					ComShowCodeMessage("MNR00221");
					return false;
				}
				//In case of Service Provider = ""
				if(formObj.vndr_nm.value == ""){
					ComShowCodeMessage("MNR00036","Service Provider ");
					formObj.vndr_nm.value.focus();
					return false;
				}
				//In case of Repair Status = ""
				if(rpr_wrk_tp_cd.GetSelectCode()== ""){
					ComShowCodeMessage("MNR00036","Repair Status ");
					formObj.eq_knd_cd.focus();
					return false;
				}
				//Variable of upper office for checking
				var isUpperOfc=false;
				//Checking Q'ty, Size/Square data of VolumnType of each sheet
				if(sheetObj.RowCount()>= 1) {
					var totalAmt=0;
					for(var j=2; j <= sheetObj.LastRow()- 1; j++) {
						var volTpCd=sheetObj.GetCellValue(j, "vol_tp_cd");	//Type
						var rprQty=sheetObj.GetCellValue(j, "rpr_qty");		//Q'ty
						var rprSzNo=sheetObj.GetCellValue(j, "rpr_sz_no");	//Size/Square
						totalAmt +=  parseFloat(sheetObj.GetCellValue(j, "mnr_wrk_amt"));	//mnr_wrk_amt
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
						//Showing message in case of Verify Result = ""
						if(sheetObj.GetCellValue(j, "mnr_vrfy_tp_cd") == ""){
							ComShowCodeMessage("MNR00337");
							return false;
						}
					}
					//appoval_amt check
					if(MnrNullToBlank(formObj.uppr_ofc_cd.value) != ""){
						if(totalAmt > parseFloat(formObj.appoval_amt.value) ){
							isUpperOfc=true;
						}
					}
				} else {
					ComShowCodeMessage("MNR00207");
					return false;
				}
				//Checking mandatory input data
				if (!ComChkValid(formObj)) return false;
				//TPB Amount check
				if(!checkTpbAmount()) return false;
				//APPROVAL Question before Saving data
				if(isUpperOfc){
					if (!ComShowCodeConfirm("MNR00062",formObj.uppr_ofc_cd.value)){
						return false;
					} else {
						ComSetObjValue(formObj.apro_ofc_cd,formObj.uppr_ofc_cd.value);
					}
				} else {
					if (!ComShowCodeConfirm("MNR00275","Estimate","Approval")){return false;}
				}
				break;
			case IBRESET:     		//Audit it Later
				if(!selCheck){
					ComShowCodeMessage("MNR00248");
					return false;
				}
				//In case of Service Provider = ""
				if(formObj.vndr_nm.value == ""){
					ComShowCodeMessage("MNR00036","Service Provider ");
					formObj.vndr_nm.value.focus();
					return false;
				}
				//In case of Repair Status = ""
				if(rpr_wrk_tp_cd.GetSelectCode()== ""){
					ComShowCodeMessage("MNR00036","Repair Status ");
					formObj.eq_knd_cd.focus();
					return false;
				}
				//Checking Q'ty, Size/Square data of VolumnType of each sheet
				if(sheetObj.RowCount()>= 1) {
					var totalAmt=0;
					for(var j=2; j <= sheetObj.LastRow()- 1; j++) {
						var volTpCd=sheetObj.GetCellValue(j, "vol_tp_cd");	//Type
						var rprQty=sheetObj.GetCellValue(j, "rpr_qty");		//Q'ty
						var rprSzNo=sheetObj.GetCellValue(j, "rpr_sz_no");	//Size/Square
						totalAmt +=  parseFloat(sheetObj.GetCellValue(j, "mnr_wrk_amt"));	//mnr_wrk_amt
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
				//Checking mandatory input data
				if (!ComChkValid(formObj)) return false;
				//TPB Amount check
				if(!checkTpbAmount()) return false;
				// Question before Saving data
				if (!ComShowCodeConfirm("MNR00275","Estimate","Audit it Later")){return false;}
				break;
			case IBINSERT:
				if(MnrNullToBlank(ComGetObjValue(rqst_eq_no)) == ''){
					ComShowCodeMessage("MNR00226");
					return false;
				}
				break;
    	}
        return true;
    }
	//Event handling of OnDblClick of sheet2
	function sheet2_OnDblClick(sheetObj,Row,Col)
    {
		var formObj=document.form;
		with(sheetObj){
			formObj.trf_no.value=GetCellValue(Row,"trf_no");
			formObj.curr_cd.value=GetCellValue(Row,"curr_cd");
			formObj.edi_id.value=GetCellValue(Row,"edi_id");
			eq_knd_cd.SetSelectCode(GetCellValue(Row,"eq_knd_cd"));
			formObj.mnr_meas_ut_nm.value=GetCellValue(Row,"mnr_meas_ut_nm");
			trsm_mod_cd.SetSelectCode(GetCellValue(Row,"trsm_mod_cd"));
			formObj.vndr_seq.value=GetCellValue(Row,"vndr_seq");
			formObj.agmt_ofc_cty_cd.value=GetCellValue(Row,"agmt_ofc_cty_cd");
			formObj.agmt_seq.value=GetCellValue(Row,"agmt_seq");
			formObj.agmt_ver_no.value=GetCellValue(Row,"agmt_ver_no");
			formObj.cost_ofc_cd.value=GetCellValue(Row,"cost_ofc_cd");
			formObj.vndr_nm.value=GetCellValue(Row,"vndr_nm");
			//Setting header information
			//Setting key value for hide
			formObj.rpr_rqst_seq.value=GetCellValue(Row,"rpr_rqst_seq");
			formObj.rpr_rqst_ver_no.value=GetCellValue(Row,"rpr_rqst_ver_no");
			formObj.rpr_sts_cd.value=GetCellValue(Row,"rpr_sts_cd");
			formObj.rpr_dtl_sts_cd.value=GetCellValue(Row,"rpr_dtl_sts_cd");
			formObj.apro_ofc_cd.value=GetCellValue(Row,"apro_ofc_cd");
			ComSetObjValue(formObj.rqst_eq_no, GetCellValue(Row,"rqst_eq_no"));
			ComSetObjValue(formObj.rqst_ref_no, GetCellValue(Row,"rqst_ref_no"));
			ComSetObjValue(formObj.rpr_yd_cd, GetCellValue(Row,"rpr_yd_cd"));
			ComSetObjValue(formObj.mnr_inp_tp_cd, GetCellValue(Row,"mnr_inp_tp_cd"));
			//Repair Status
			rpr_wrk_tp_cd.SetSelectCode(GetCellValue(Row,"rpr_wrk_tp_cd"));
			ComSetObjValue(formObj.eq_dmg_dt, GetCellValue(Row,"eq_dmg_dt"));
			if(GetCellValue(Row,"rpr_offh_flg") == 'Y'){
				formObj.rpr_offh_flg.value='Y';
				formObj.rpr_offh_flg_temp.checked=true;
			} else {
				formObj.rpr_offh_flg.value='N';
				formObj.rpr_offh_flg_temp.checked=false;
			}
			ComSetObjValue(formObj.mnr_rpr_rmk, GetCellValue(Row,"mnr_rpr_rmk"));
			//Displaying EQ_NUMBER Equipment information
			setEqInfo(sheetObj,eq_knd_cd.GetSelectCode(),formObj.rqst_eq_no.value,ComGetNowInfo("ymd"));
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
			ComSetObjValue(formObj.auto_amt, GetCellValue(Row,"auto_amt"));
			ComSetObjValue(formObj.appoval_amt, GetCellValue(Row,"appoval_amt"));
			ComSetObjValue(formObj.uppr_ofc_cd, GetCellValue(Row,"uppr_ofc_cd"));
			//Status of retrieve of now
			selCheck=true;
			tabObjects[0].SetSelectedIndex(0);
			//Initializing sheet
			sheetObjects[2].RemoveAll();
			t2_sheet8.RemoveAll();
			//Retrieving file list
			var fileSeq=GetCellValue(Row,"file_seq");
			if(fileSeq != "" && fileSeq != null){
				var fileXml=SearchFileUpload(t2_sheet8,fileSeq);
				if(!MnrIsEmptyXml(fileXml)){
					t2_sheet8.LoadSearchData(fileXml,{Sync:1} );
				}
			}
			//Retrieving detail
			doActionIBSheet(sheetObjects[2],formObj,IBROWSEARCH);
			return;
		}
    }
	//************************* EVENT SECTION ************************//
	/**
	 * Event handling of changing tab
	 * Activating tab for selected
	 */
	function tab1_OnChange(tabObj , nItem){
		formObj=document.form;
		if(eq_knd_cd.GetSelectCode()== "U"){
			// sharing for between tab (S)
			var sp=sheetObjects[2].LastRow()- 1;
			for(var j=sp; j > 1;j--){
				if(sheetObjects[2].GetCellValue(j,"eq_loc_cd") == ""){
					sheetObjects[2].RowDelete(j, false);  	//Deleting
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
					if(serchRow == -1){
						var Row=sheetObjects[2].DataInsert(-1);
						//set Value Init
						sheetObjects[2].SetCellValue(Row, "eq_loc_cd",tDmgLocCds[i]);//Component
						sheetObjects[2].SetCellValue(Row, "eq_cmpo_cd","",0);//Component
						sheetObjects[2].SetCellValue(Row, "eq_dmg_cd","",0);//DMG
						sheetObjects[2].SetCellValue(Row, "eq_rpr_cd","",0);//Repair
						sheetObjects[2].SetCellValue(Row, "trf_div_cd"," ",0);//Div
						sheetObjects[2].SetCellValue(Row, "mnr_vrfy_tp_cd","",0);//Result
						//set Focus
 						sheetObjects[2].SetSumText(0,"eq_loc_cd","TOTAL");
						//Editable
						setInitSheetEdit(sheetObjects[2],Row);
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
			}
			// sharing for between tab (E)
		}
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
//		objs[beforetab].style.display="none";
		//--------------- Important logic --------------------------//
//		objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;

		for(var i = 0; i<objs.length; i++){
		  if(i != nItem){
		   objs[i].style.display="none";
		   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
		  }
		}	
		
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
				//Changing row status
				if(sheetObj.GetRowStatus(Row) != "R"){
					sheetObj.SetRowStatus(Row,"I");
				}
			} else if(sheetObj.ColSaveName(Col)  == "eq_cmpo_cd"){
				var checkCompCd=sheetObj.GetCellValue(Row,"eq_cmpo_cd");
				var checkRprCd=sheetObj.GetCellValue(Row,"eq_rpr_cd");
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
					//******************** Retrieving RPR code when changing component **************
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
					//Initializing DIV code
					dummyEvent=true;
					sheetObj.CellComboItem (Row, "trf_div_cd", " \t |", " |");
					dummyEvent=false;
					//******************** Retrieving RPR code when changing component END *************
					setDescripton(sheetObj,Row);
					if(ComGetObjValue(formObject.eq_tpsz_cd) != "" && checkCompCd != ""){
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
					}
				}
				//Changing row status
				if(sheetObj.GetRowStatus(Row) != "R"){
					sheetObj.SetRowStatus(Row,"I");
				}
			} else if(sheetObj.ColSaveName(Col)  == "vol_tp_cd"){
				if(sheetObj.GetCellValue(Row,"vol_tp_cd") == "Q"){
					sheetObj.SetCellEditable(Row, "rpr_qty",1);
					sheetObj.SetCellEditable(Row, "rpr_sz_no",0);
					sheetObj.SetCellValue(Row ,"rpr_sz_no","",0);
				} else {
					sheetObj.SetCellEditable(Row, "rpr_qty",0);
					sheetObj.SetCellValue(Row ,"rpr_qty","",0);
					sheetObj.SetCellEditable(Row, "rpr_sz_no",1);
				}
				//Changing row status
				if(sheetObj.GetRowStatus(Row) != "R"){
					sheetObj.SetRowStatus(Row,"I");
				}
			} else if(sheetObj.ColSaveName(Col) == "n3pty_flg"){
				if(sheetObj.GetCellValue(Row,"n3pty_flg") == "1"){
					sheetObj.SetCellEditable(Row, "n3pty_bil_lbr_hrs",1);
					sheetObj.SetCellEditable(Row, "n3pty_bil_lbr_rt",1);
					sheetObj.SetCellEditable(Row, "n3pty_bil_mtrl_cost_amt",1);
					sheetObj.SetCellValue(Row,"n3pty_bil_lbr_hrs",sheetObj.GetCellValue(Row,"rpr_lbr_hrs"),0);
					sheetObj.SetCellValue(Row,"n3pty_bil_lbr_rt",sheetObj.GetCellValue(Row,"rpr_lbr_rt"),0);
					sheetObj.SetCellValue(Row,"n3pty_lbr_cost_amt",sheetObj.GetCellValue(Row,"lbr_cost_amt"),0);
					sheetObj.SetCellValue(Row,"n3pty_bil_mtrl_cost_amt",sheetObj.GetCellValue(Row,"mtrl_cost_amt"),0);
					sheetObj.SetCellValue(Row,"n3pty_bil_amt",sheetObj.GetCellValue(Row,"mnr_wrk_amt"),0);
					document.form.n3pty_flg.value="Y";
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
						document.form.n3pty_flg.value="Y";
					} else {
						document.form.n3pty_flg.value="N";
					}
				}
			} else if(sheetObj.ColSaveName(Col) == "eq_rpr_cd" || sheetObj.ColSaveName(Col) == "eq_dmg_cd"){
				var ErrMsgTarget="";
				var isPossible=false;
				if(sheetObj.ColSaveName(Col) == "eq_rpr_cd"){
					ErrMsgTarget="Repair Code";
					var repairCd=sheetObj.GetCellValue(Row,"eq_rpr_cd");
					var sCode=sheetObj.GetComboInfo(Row,"eq_rpr_cd", "Code");
					var arrCode=sCode.split("|");
					for(var i=0;i < arrCode.length;i ++){
						if(arrCode[i] == repairCd){
							isPossible=true;
						}
					}
				} else if(sheetObj.ColSaveName(Col) == "eq_dmg_cd"){
					ErrMsgTarget="Demage Code";
					for(var i=0;i < sheetComboList[1].length;i++){
						var tempText=sheetComboList[1][i].split("|");
						if(tempText[0] == sheetObj.GetCellValue(Row,Col)){
							isPossible=true;
						}
					}
				}
				if(!isPossible){
					ComShowCodeMessage("MNR00010",ErrMsgTarget);
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					//In case of RPR
					if(sheetObj.ColSaveName(Col) == "eq_rpr_cd"){
						setDescripton(sheetObj,Row);
						var checkCompCd=sheetObj.GetCellValue(Row,"eq_cmpo_cd");
						var checkRprCd=sheetObj.GetCellValue(Row,"eq_rpr_cd");
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
							//TS type combo
							if(comboList[0] != null){
								for(var j=0; j < comboList[0].length;j++){
									var tempText=comboList[0][j].split("|");
									lbComboText +=  tempText[0] + "\t" + tempText[1] + "|";
									lbComboCode +=  tempText[0] + "|";
								}
							}
							dummyEvent=true;
							sheetObj.CellComboItem (Row, "trf_div_cd", lbComboText, lbComboCode);
							dummyEvent=false;
							sheetObj.SetCellValue(Row ,"trf_div_cd"," ",0);
						}
					}
				}
				//Changing row status
				if(sheetObj.GetRowStatus(Row) != "R"){
					sheetObj.SetRowStatus(Row,"I");
				}
			} else if(sheetObj.ColSaveName(Col) == "trf_div_cd"){
				setDescripton(sheetObj,Row);
				//Changing row status
				if(sheetObj.GetRowStatus(Row) != "R"){
					sheetObj.SetRowStatus(Row,"I");
				}
			} else if(sheetObj.ColSaveName(Col) == "del_chk"){
				MnrCheckRowColChange(sheetObj,sheetObj.GetCellValue(Row,"del_chk"),Row);
			} else if(sheetObj.ColSaveName(Col) == "rpr_lbr_hrs"){
				if(sheetObj.GetCellValue(Row ,"mnr_vrfy_tp_cd") == "SS" || sheetObj.GetCellValue(Row ,"mnr_vrfy_tp_cd") == "SL" || sheetObj.GetCellValue(Row ,"mnr_vrfy_tp_cd") == "UH"){
					getReVerifySuccItem(sheetObj,Row);
				}
			} else if(sheetObj.ColSaveName(Col) == "rpr_lbr_rt"){
				if(sheetObj.GetCellValue(Row ,"mnr_vrfy_tp_cd") == "SS" || sheetObj.GetCellValue(Row ,"mnr_vrfy_tp_cd") == "SL" || sheetObj.GetCellValue(Row ,"mnr_vrfy_tp_cd") == "UR"){
					getReVerifySuccItem(sheetObj,Row);
				}
			} else if(sheetObj.ColSaveName(Col) == "mtrl_cost_amt"){
				if(sheetObj.GetCellValue(Row ,"mnr_vrfy_tp_cd") == "SS" || sheetObj.GetCellValue(Row ,"mnr_vrfy_tp_cd") == "SL" || sheetObj.GetCellValue(Row ,"mnr_vrfy_tp_cd") == "UM"){
					getReVerifySuccItem(sheetObj,Row);
				}
			}
			var t=sheetObj.ColSaveName(Col);
			if(t == "eq_dmg_cd" || t == "rpr_qty" || t == "rpr_sz_no"){
				//Changing row status
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
	}
	function t1sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) != "eq_loc_cd") return;
		//Finding clicked row
		t1sheet1ClickRow=Row;
		ComOpenPopup('EES_MNR_0193.do?rec_eq_knd_cd=' + formObj.eq_knd_cd.value, 896, 498, 'setEES_MNR_0193', '0,1,1,1,1,1,1,1,1,1,1,1', true);
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
     * Event handling of click of sheet1 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	Selected row
     * @param {ibsheet} Col     	Selected column
     * @param {String} 	Value     	File name
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
			ComShowCodeMessage("MNR00023");
		} else {
			ComShowCodeMessage("MNR00008",ErrMsg);
			
		}
	}
	function t1sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			ComShowCodeMessage("MNR00334");
		} else {
			ComShowCodeMessage("MNR00159",ErrMsg);
		}
	}
	function t1sheet1_OnSearchEnd(sheetObj,ErrMsg){
		var arrResult=MnrXmlToArray(sXml_1);
		setCommonSheetEdit(sheetObj,arrResult);
		ComSetObjValue(formObj.rqst_dt, ComGetEtcData(sXml_1, "rqst_dt"));
		ComSetObjValue(formObj.eq_dmg_dt, ComGetEtcData(sXml_1, "eq_dmg_dt"));
		ComSetObjValue(formObj.rqst_usr_nm, ComGetEtcData(sXml_1, "rqst_usr_nm"));
		ComSetObjValue(formObj.rqst_usr_id, ComGetEtcData(sXml_1, "rqst_usr_id"));
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
		document.form.mnr_desc.value="";
		
		for(var i=sheetObj.HeaderRows(); i<sheetObj.LastRow(); i++){
			var mnrVrfyTpCd=sheetObj.GetCellValue(i,  "mnr_vrfy_tp_cd");
			if(mnrVrfyTpCd=="SS" || mnrVrfyTpCd=="SL"){
 				sheetObj.SetCellFontColor(i,"mnr_vrfy_tp_cd","#0000FF");
			} else {
 				sheetObj.SetCellFontColor(i,"mnr_vrfy_tp_cd","#FF0000");
			}
		}
		
	}
	
	function t2_sheet1_OnSearchEnd(sheetObj,ErrMsg){
//		if( sheetObj.RowCount() < 1){
//		      InitHeadColumn(leftHeaders,sheetObj);
//		    } else {
//		     InitHeadText(leftHeaders,sheetObj);
//		   }
	}
	
	//Event handling of combo
	function eq_knd_cd_OnChange(comboObj,Index_Code, Text){
		var formObj=document.form;
		formObj.eq_knd_cd.value=comboObj.GetSelectCode();
		if(formObj.eq_knd_cd.value == 'U'){
			var div1=document.all.item("t2_selection1");
			var div2=document.all.item("t2_selection2");
			div1.style.display="inline";
			div2.style.display="inline";
		} else {
			var div1=document.all.item("t2_selection1");
			var div2=document.all.item("t2_selection2");
			div1.style.display="none";
			div2.style.display="none";
		}
		//******************** Retrieving EQ_Type when changing component **************
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
				}
				sheetComboCode=MnrDelLastDelim(sheetComboCode);
		     	sheetComboText=MnrDelLastDelim(sheetComboText);
		        sheetComboCodeText=MnrDelLastDelim(sheetComboCodeText);
				sheetObjects[2].InitDataCombo (0, "eq_cmpo_cd", sheetComboCodeText, sheetComboCode ,sheetComboDefault);
			}
	 	}
		//******************** Retrieving EQ_Type when changing component *************
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
		if(sheetObj.GetCellValue(Row,"vol_tp_cd") == "Q"){
			sheetObj.SetCellEditable(Row, "rpr_qty",1);
			sheetObj.SetCellEditable(Row, "rpr_sz_no",0);
			sheetObj.SetCellValue(Row,"rpr_sz_no","");
		} else {
			sheetObj.SetCellEditable(Row, "rpr_qty",0);
			sheetObj.SetCellValue(Row,"rpr_qty","");
			sheetObj.SetCellEditable(Row, "rpr_sz_no",1);
		}
		//Setting mnr_lr_acct_flg
		if(formObj.rpr_offh_flg_temp.checked == true){
			sheetObj.SetCellEditable(Row, "mnr_lr_acct_flg",1);
			formObj.rpr_offh_flg.value="Y";
		} else {
			sheetObj.SetCellEditable(Row, "mnr_lr_acct_flg",0);
			formObj.rpr_offh_flg.value="N";
		}
		//Setting TPB
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
				sheetObj.SetCellValue(i,"rpr_sz_no","");
			} else {
				sheetObj.SetCellEditable(i, "rpr_qty",0);
				sheetObj.SetCellValue(i,"rpr_qty","");
				sheetObj.SetCellEditable(i, "rpr_sz_no",1);
			}
			//Setting mnr_lr_acct_flg
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
			//Setting Comp code
			sheetObj.SetCellValue(i,"eq_cmpo_cd",arrResult[i - 2][27],0);
			//Setting RPR combo
			var checkCompCd=sheetObj.GetCellValue(i,"eq_cmpo_cd");
			//******************** Retrieving RPR code when changing component **************
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
			//Setting RPR code
			sheetObj.SetCellValue(i,"eq_rpr_cd",arrResult[i - 2][41],0);
			//******************** Retrieving RPR code when changing component END *************
			//Div Setting combo
			var checkRprCd=sheetObj.GetCellValue(i,"eq_rpr_cd");
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
				//TS type combo
				if(comboList[0] != null){
					for(var j=0; j < comboList[0].length;j++){
						var tempText=comboList[0][j].split("|");
						lbComboText +=  tempText[0] + "\t" + tempText[1] + "|";
						lbComboCode +=  tempText[0] + "|";
					}
				}
				lbComboCode=MnrDelLastDelim(lbComboCode);
				lbComboText=MnrDelLastDelim(lbComboText);
				dummyEvent=true;
				sheetObj.CellComboItem (i, "trf_div_cd", lbComboText, lbComboCode);
				dummyEvent=false;
			}
			sheetObj.SetCellValue(i,"trf_div_cd",arrResult[i - 2][30],0);
			sheetObj.SetRowStatus(i,"R");
		}
		enableOnChange=true;
	}
	function setEqInfo(sheetObj,sEqType,sEqNo,sTotalLossDate){
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
			
			//In case of rpr_dt (rpr_type = retArr[0][30])
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
			//dv_value
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
			//Ru Division
			tagObj=document.getElementById("ruDiv");
			tagObj.innerHTML=retArr[0][44];
			//Ru Labal
			tagObj=document.getElementById("ruLabel");
			tagObj.innerHTML=retArr[0][45];
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
			formObj.rpr_yd_cd.value="";
		}
	}
	function setEqInfoClear(){
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
	}
	/**
	 * EES_MNR_0193 : Processing by received value of pop-up screen
	 */
	function setEES_MNR_0193(aryPopupData){
		var tagetSheet=sheetObjects[2];
		for(var i=0; i < aryPopupData.length;i++){
			tagetSheet.SetCellValue(t1sheet1ClickRow,"eq_loc_cd",aryPopupData[i],0);
		}
		setInitSheetEdit(tagetSheet,t1sheet1ClickRow);
		tagetSheet.SelectCell(t1sheet1ClickRow,1);
 		tagetSheet.SetSumText(0,"eq_loc_cd","TOTAL");
	}
	/**
	 * COM_ENS_061 : Processing by received value of pop-up screen
	 */
	function getCOM_ENS_061(aryPopupData, row, col, shhetIdx){
    	 var formObj=document.form;
		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "")
    	 	formObj.rpr_yd_cd.value=aryPopupData[0][3];
    }
	function initControl() {
	    //Axon event handling 1. Catching event
		var formObject=document.form;
//	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject);cc
//	    axon_event.addListenerFormat('focus',    'obj_activate',    formObject);
//	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);
		axon_event.addListenerFormat('blur',	 'obj_change',	formObject); 
	}
	//Axon event handling 2. Event handling function
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
				ComKeyOnlyAlphabet('uppernum');
	            break;
	    }
	}
	/**
	 * Setting sheet combo
	 * @param	{IBSheet}	sheetObj	sheet object
	 */
	function setSheet2Combo(sheetObj) {
		//Retrieving data of combo of sheet
		var sCondition=new Array (
			new Array("MnrCedexOthCd","RPR","COMMON"), 	//Demage
			new Array("MnrCedexOthCd","DMG","COMMON"), 	//Repair
			new Array("MnrGenCd","CD00013", "COMMON"),	//Type
			new Array("MnrGenCd","CD00004", "COMMON"),	//Error code
			new Array("MnrEqCmpoCd","3","COMMON")
		)
		sheetComboList=MnrComSearchCombo(sheetObjects[0],sCondition);
		var sheetComboText="";
		var sheetComboCode="";
		var sheetComboDefault=new Array();
		//combo of sheet SAVE_NAME
		var comboSaveNames=new Array();
		comboSaveNames[0]="eq_rpr_cd";
		comboSaveNames[1]="eq_dmg_cd";
		comboSaveNames[2]="vol_tp_cd";
		comboSaveNames[3]="mnr_vrfy_tp_cd";
		comboSaveNames[4]="eq_cmpo_cd";
		for(var i=0; i < sheetComboList.length;i++){
		 	if(sheetComboList[i] != null){
				//Initializing each combo of sheets
				sheetComboText="";
				sheetComboCode="";
				sheetComboCodeText="";
		 		for(var j=0; j < sheetComboList[i].length;j++){
					var tempText=sheetComboList[i][j].split("|");
					sheetComboText +=  tempText[1] + "|";
					sheetComboCode +=  tempText[0] + "|";
					sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
					if(j == 0){
						sheetComboDefault[i]=tempText[0];
					}
				}
	   	     	sheetComboText=MnrDelLastDelim(sheetComboText);
		        sheetComboCode=MnrDelLastDelim(sheetComboCode);
		        sheetComboCodeText=MnrDelLastDelim(sheetComboCodeText);
				//alert(sheetComboDefault[i]);
				if(comboSaveNames[i] == "vol_tp_cd"){
					sheetObjects[2].InitDataCombo (0, comboSaveNames[i], sheetComboText, sheetComboCode ,sheetComboDefault[i]);
				} else if(comboSaveNames[i] == "mnr_vrfy_tp_cd"){
					sheetObjects[2].InitDataCombo (0, comboSaveNames[i], sheetComboText, sheetComboCode ,sheetComboDefault[i]);
				} else {
					sheetObjects[2].InitDataCombo (0, comboSaveNames[i], sheetComboCodeText, sheetComboCode ,sheetComboDefault[i]);
				}
			}
		}
	}
	/**
	 * Setting description
	 * Component,Repair,Div sheet when changing combo Description
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 */
	function setDescripton(sheetObj,Row) {
		var formObj=document.form;
var componentCode=sheetObj.GetCellValue(Row,"eq_cmpo_cd");
		var componentDesc=getDescription(componentCode,4);
var divCode=sheetObj.GetCellValue(Row,"trf_div_cd");
		var divDescs=sheetObj.GetComboInfo(Row,"trf_div_cd","Text");
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
	 * Returning combo code
	 * Retrieving component and repair code
	 * @param	{String}	Val			Value
	 * @param	{Int}		comboSeq	Combo sequence
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
	 * Checking TPB amount over 0 when TPB Request
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
	/**
	 * Call back function of EDI Estimate Upload pop-up
	 */
	function callbackUploadConfirm(vComplexPK) {
        var formObject=document.form;
		doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
	}
	/* End of developer's task */
