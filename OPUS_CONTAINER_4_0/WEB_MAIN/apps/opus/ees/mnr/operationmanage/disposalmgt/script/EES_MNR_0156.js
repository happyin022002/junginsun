﻿/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0156.js
*@FileTitle  : Disposal Request
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class EES_MNR_0156 : business script for EES_MNR_0156.
     */
  
/* developer job	*/
// common global variables
//sheet
var sheetObjects=new Array();
var sheetCnt=0;
//combo Object
var comboObjects=new Array();
var comboCnt=0;
//file sequence variable(in case of adding)
var uploadFileSeq="";
var uTpSz=new Array();
var gTpSz=new Array();
var zTpSz=new Array();
//retrieve whether or not
var selCheck=false;
//combo default value
var eqKnddefCode="";
var appOfcdefCode="";
//for message
var actionType="";
//previous value
var preEqKndCd="";
var preCurrCd="";
//IBCLEAR
var isNowInit=false;
var selectedRow = "";
var sXml_1 = "";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
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
					case "btn_Delete":
						doActionIBSheet(sheetObjects[0],formObject,IBDELETE);
					break;
					case "btn_Save":
						doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
					break;
					case "btn_Request":
						doActionIBSheet(sheetObjects[0],formObject,IBBATCH);
					break;
					case "btn_RowAdd":
						doActionIBSheet(sheetObjects[0],formObject,IBINSERT);
					break;
					case "btn_RowDelete":
						doActionIBSheet(sheetObjects[0],formObject,IBCOPYROW);
					break;
					case "btn_Excel":
						if(sheetObjects[3].RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
							}else{
								sheetObjects[3].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[3]), SheetDesign:1,Merge:1 });
							}
					break;
					case "btn_Inquiry":
						ComOpenPopup('/opuscntr/EES_MNR_0158.do?cost_ofc_cd=' + formObject.self_ofc_cd.value + "&eq_knd_cd=" + eq_knd_cd.GetSelectCode(), 900, 440, 'setPopData_DSPC', '0,1,1,1,1,1,1,1', false, false, 1, 1, 3);
					break;
					case "btn_FileAdd":
						file_Insert(sheetObjects[4]);
					break;
					case "btn_FileDelete":
						file_Remove(sheetObjects[4]);
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
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
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
		MnrWaitControl(true);
		initControl();
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
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
		 		sParam+= "&mnr_grp_tp_cd=DSP";       // MNR Work Group Type Code
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
						var fileXml=SearchFileUpload(sheetObjects[4],uploadFileSeq);
						sheetObjects[4].LoadSearchData(fileXml,{Sync:1} );
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
				if(fileType != "GIF" && fileType != "BMP" && fileType != "TIFF" && fileType != "TIF" && fileType != "JPG" && fileType != "XLS" && fileType != "DOC" && fileType != "XLSX"){
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
    function sheet4_OnMouseMove(sheetObj, e) {
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
                    //setting Host information[HostIp, Port, PagePath]
                    //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					SetVisible(false);
				}
            case "sheet2":
                with(sheetObj){
		              var HeadTitle1="|S|Disposal No.|EQ Type|Q'ty|Currency|Total Amount|Creation DT|Status"
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              (headCount + 4, 0, 0, true);
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"disp_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"eq_knd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"disp_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"disp_st_prc",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"rqst_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"disp_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"disp_eml_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"apro_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"file_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_disp_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		               
		              InitColumns(cols);
		              SetCountPosition(0);
		              SetEditable(1);
		              SetSheetHeight(142);
            }
			break;
			case "sheet3":
				with(sheetObj){
			         var HeadTitle1="|Sel|Seq|Buyer Code|Buyer Name|Buyer Type";
			         (12, 0, 0, true);
		
			         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
			         var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			         var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			         InitHeaders(headers, info);
		
			         var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Radio",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq",              KeyField:0,   CalcLogic:"",   Format:"" },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"mnr_prnr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:135,  Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"mnr_prnr_knd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"disp_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_prnr_eml",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"part_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_prnr_cnt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_prnr_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			          
			         InitColumns(cols);
		
		         	SetEditable(1);
		         	SetEditableColorDiff(1);
		            SetSelectionMode(smSelectionRow);
		            SetCountPosition(0);
		            SetSheetHeight(122);
	         }
			break;
			case "sheet4":
			    with(sheetObj){
		        	var prefix="";
		        	var HeadTitle1="|Seq.|File|Download";
		        	var headCount=ComCountHeadTitle(HeadTitle1);
		        	(8, 0, 0, true);
	
		        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
		        	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		        	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		        	InitHeaders(headers, info);
	
		        	var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk" },
			             {Type:"Popup",     Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"org_file_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
			             {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_dw",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"file_dtl_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			       
		        	InitColumns(cols);
	
		        	SetEditable(1);
		        	SetImageList(0,"img/ico_attach.gif");
		        	SetShowButtonImage(1);
		        	SetCountPosition(0);
		        	SetSheetHeight(80);
		    }
			break;
			case "t1_sheet1":
                with (sheetObj) {
		            var HeadTitle1="|Sel|Seq.|EQ No.|TP/SZ|Term|MVNT|Yard|Material|Maker Name|Unit Model|U.Price|MNR Cost(USD)|Sale Category|Price Verify Result|Remark(s)";
		            (19, 0, 0, true);
	
		            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
		            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		            InitHeaders(headers, info);
	
		            var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
		                {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq",               KeyField:0,   CalcLogic:"",   Format:"" },
		                {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"eq_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14, InputCaseSensitive:1 },
		                {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lstm_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"disp_yd_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"mtrl_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                {Type:"Combo",     Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"mkr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"mdl_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"disp_ut_prc",       KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		                {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rpr_cost_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                {Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"disp_rsn_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Combo",     Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"disp_vrfy_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"mnr_disp_dtl_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
		                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"disp_ut_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"disp_qty",          KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"disp_trf_ut_prc",   KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		             
		            InitColumns(cols);
	
		            SetEditable(1);
		            SetEditableColorDiff(1);
	                SetSelectionMode(smSelectionRow);
		            SetSheetHeight(122);
			}
			break;
        }
    }
 	// handling process for sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      //retrieving
				if(validateForm(sheetObj,formObj,sAction)){
					//retrieving header list
					formObj.f_cmd.value=SEARCH;
				    sParam=FormQueryString(formObj);
				    var sXml=sheetObj.GetSaveData("EES_MNR_0156GS.do", sParam);
				    sheetObjects[1].LoadSearchData(sXml,{Sync:0} );
				}
				break;
			case IBINSERT:      // adding row
				var sheetObj;
				var dispUtTpCd="";
				sheetObj=sheetObjects[3];
				dispUtTpCd="E";
			    var Row=sheetObj.DataInsert(-1);
				sheetObj.SetCellValue(Row,"disp_ut_tp_cd",dispUtTpCd,0);
				sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);
				sheetObj.SetCellValue(Row,"disp_qty","1",0);
				sheetObj.SetCellValue(Row,"mkr_nm","",0);
				sheetObj.SetCellValue(Row,"disp_vrfy_tp_cd","",0);
				sheetObj.SetCellValue(Row,"disp_trf_ut_prc","",0);
				sheetObj.SetCellEditable(Row, "disp_yd_cd",0);
                break;
			case IBCOPYROW:     // deleting row
				var sheetObj;
				sheetObj=sheetObjects[3];
				MnrRowDelete(sheetObj,  "del_chk");
				reSetQtyAndPrice();
				break;
			case IBSAVE:        //saving
              if(validateForm(sheetObj,formObj,sAction)){
			  		actionType="IBSAVE";
					formObj.f_cmd.value=MODIFY;
					
					if(uploadFileSeq != undefined){
						formObj.file_seq.value=uploadFileSeq;
					}
					var sParam1=sheetObjects[3].GetSaveString(true, true);
					//checking mandatory
					if(sParam1 == "" && sheetObjects[3].IsDataModified()){
						return;
					}
					sParam1=ComSetPrifix(sParam1,"rqstDtl_");
					var sParam3=sheetObjects[2].GetSaveString(false, true, "del_chk");
					//checking mandatory
					if(sParam3 == "" && sheetObjects[2].IsDataModified()){
						return;
					}
					sParam3=ComSetPrifix(sParam3,"rqstPart_");
				    if (!ComShowCodeConfirm("MNR00160")){return;}
				    disp_sts_cd.SetSelectCode("HS");
					var sParam=sParam1 + "&" + sParam3 + "&" + FormQueryString(formObj);
					var sXml=sheetObjects[0].GetSaveData("EES_MNR_0156GS.do", sParam);
					sXml_1 = sXml;
					sheetObjects[1].LoadSaveData(sXml);
					
				}
				break;
			case IBBATCH:        //request
              if(validateForm(sheetObj,formObj,sAction)){
			  		actionType="IBBATCH";
					formObj.f_cmd.value=MODIFY;
					//request
					
					if(uploadFileSeq != undefined){
						formObj.file_seq.value=uploadFileSeq;
					}
					var sParam1=sheetObjects[3].GetSaveString(true, true);
					//checking mandatory
					if(sParam1 == "" && sheetObjects[3].IsDataModified()){
						return;
					}
					sParam1=ComSetPrifix(sParam1,"rqstDtl_");
					var sParam3=sheetObjects[2].GetSaveString(false, true, "del_chk");
					//checking mandatory
					if(sParam3 == "" && sheetObjects[2].IsDataModified()){
						return;
					}
					sParam3=ComSetPrifix(sParam3,"rqstPart_");
					if (!ComShowCodeConfirm("MNR00275","Disposal","Request")){return;}
					disp_sts_cd.SetSelectCode("HR");
				    var sParam=sParam1 + "&" + sParam3 + "&" +FormQueryString(formObj);
				    var sXml=sheetObjects[0].GetSaveData("EES_MNR_0156GS.do", sParam);
				    sheetObjects[1].LoadSaveData(sXml);
					MnrWaitControl(true);
					//IBCLEAR START
					isNowInit=true;
					uploadFileSeq="";
					selCheck=false;
					actionType="";
					// Each
					formObj.reset();
					//initializing sheet
					for(var i=2; i < sheetObjects.length;i++){
						sheetObjects[i].RemoveAll();
					}
					//retrieving common combo.
					//setting eq_knd_cd  EQ_TYPE
					eq_knd_cd.SetSelectCode(eqKnddefCode);
					curr_cd.SetSelectCode("USD");
					disp_sts_cd.SetSelectCode(-1);
//					disp_sts_cd.SetEnable(0);
					apro_ofc_cd.SetSelectCode(appOfcdefCode);
					var toDay=ComGetNowInfo("ymd");
					//setting initial value
					ComSetObjValue(formObj.rqst_dt,toDay);
					ComSetObjValue(formObj.disp_no,"NEW");
					ComSetObjValue(formObj.disp_qty,"0");
					ComSetObjValue(formObj.disp_st_prc,"0");
//					formObj.disp_eml_flg_temp.checked=true;
					//retrieving partner
					formObj.f_cmd.value=INIT;
				    sParam=FormQueryString(formObj);
				    var sXml=sheetObj.GetSaveData("EES_MNR_0156GS.do", sParam);
				    sheetObjects[2].LoadSearchData(sXml,{Sync:0} );
					isNowInit=false;
					//IBCLEAR END
					MnrWaitControl(false);
				}
				break;
			case IBROWSEARCH:      //retrieving detail
                 if(validateForm(sheetObj,formObj,sAction)){
					 	formObj.f_cmd.value=SEARCH01;
					    sParam=FormQueryString(formObj);
					    var sXml=sheetObj.GetSaveData("EES_MNR_0156GS.do", sParam);
					   	var arrXml=sXml.split("|$$|");
						for(var i=0; i < arrXml.length; i++){
							sheetObjects[i + 2].LoadSearchData(arrXml[i],{Sync:0} );
						}
						//showing Highlight
						for(var x=1 ; x <= sheetObjects[2].RowCount();x++){
							MnrCheckRowColChange(sheetObjects[2],sheetObjects[2].GetCellValue(x,"del_chk"),x);
						}
						for(var x=1 ; x <= sheetObjects[3].RowCount();x++){
							//1. add the Repair Cost next to 'Sale Category'. 2. If damage can be input
							var checkRsnCd=MnrNullToBlank(sheetObjects[3].GetCellValue(x,"disp_rsn_cd"));
							if(checkRsnCd == 'C'){
								sheetObjects[3].SetCellValue(x,"rpr_cost_amt","",0);
								sheetObjects[3].SetCellEditable(x, "rpr_cost_amt",0);
							} else {
								sheetObjects[3].SetCellEditable(x, "rpr_cost_amt",1);
							}
						}
				  }
                break;
			case IBDELETE:
				if(validateForm(sheetObj,formObj,sAction)){
						actionType="IBDELETE";
					 	formObj.f_cmd.value=REMOVE01;
					    sParam=FormQueryString(formObj);
					    var sXml=sheetObj.GetSaveData("EES_MNR_0156GS.do", sParam);
						sheetObjects[1].RemoveAll();
						sheetObjects[1].LoadSaveData(sXml);
						MnrWaitControl(true);
						//IBCLEAR START
						isNowInit=true;
						uploadFileSeq="";
						selCheck=false;
						actionType="";
						// Each
						formObj.reset();
						//initializing sheet
						for(var i=2; i < sheetObjects.length;i++){
							sheetObjects[i].RemoveAll();
						}
						//retrieving partner
						formObj.f_cmd.value=INIT;
					    sParam=FormQueryString(formObj);
					    var sXml=sheetObj.GetSaveData("EES_MNR_0156GS.do", sParam);
					    sheetObjects[2].LoadSearchData(sXml,{Sync:0} );
						//retrieving common combo.
						//in_eq_knd_cd,setting eq_knd_cd  EQ_TYPE
						eq_knd_cd.SetSelectCode(eqKnddefCode);
						curr_cd.SetSelectCode("USD");
						disp_sts_cd.SetSelectCode("HS");
						disp_sts_cd.enable=false;
						apro_ofc_cd.SetSelectCode(appOfcdefCode);
						var toDay=ComGetNowInfo("ymd");
						//setting initial value
						ComSetObjValue(formObj.rqst_dt,toDay);
						ComSetObjValue(formObj.disp_no,"NEW");
						ComSetObjValue(formObj.disp_qty,"0");
						ComSetObjValue(formObj.disp_st_prc,"0");
//						formObj.disp_eml_flg_temp.checked=true;
						isNowInit=false;
						//IBCLEAR END
						MnrWaitControl(false);
				 }
				break;
			case IBCLEAR:      // initializing
				MnrWaitControl(true);
				isNowInit=true;
				sheetObj.WaitImageVisible = false;
				//making data as list for retrieving type size per EQ_TYPE
				var arrXml=MnrComSearchGrid(sheetObj,"type_size_search_ind");
				if(arrXml != null){
	 			    for(var i=0; i < arrXml.length; i++){
						if(i == 0){
							uTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
						} else if(i == 1){
							zTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
						} else if(i == 2){
							gTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
						}
				    }
				}
				uploadFileSeq="";
				selCheck=false;
				actionType="";
				// initializing form
				formObj.reset();
				//initializing sheet
				for(var i=1; i < sheetObjects.length;i++){
					sheetObjects[i].RemoveAll();
				}
				//initializing combo
				for(var i=0; i < comboObjects.length;i++){
					comboObjects[i].SetSelectCode("-1");
					comboObjects[i].RemoveAll();
				}
				
				var HOOfc = getMnrHOOffice();
				//retrieving common combo.
				var sCondition=new Array (
					//form combo
					new Array("MdmCurrency","","COMMON"),       //CUR_CD
					new Array("MnrGenCd","CD00029", "COMMON"),  //DISP_STS_CD
					new Array("MnrGenCd",formObj.self_ofc_cd.value,"CUSTOM9"),
					new Array("MnrOfcGenInfo",HOOfc,"DISP"),
					//sheetObjects[1] combo
					new Array("MnrGenCd","CD00002", "COMMON"),	//EQ_KND_CD
					new Array("MdmCurrency","","COMMON"),       //CURR_CD
					new Array("MnrGenCd","CD00029", "COMMON"),  //DISP_STS_CD
					//sheetObjects[2] combo
					new Array("MnrGenCd","CD00034", "COMMON"),	//BYER TYPE
					//sheetObjects[3] combo
					new Array("MnrGenCd","CD00038", "COMMON"),	//DISP_RSN_CD
					new Array("MnrGenCd","CD00087", "COMMON"),  //MKR_NM
					new Array("MnrGenCd","CD00080", "COMMON")   //disp_vrfy_tp_cd
				)
				var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
				//setting CURRENCY
				if(comboList[0] != null){
					for(var j=0; j < comboList[0].length;j++){
						var tempText=comboList[0][j].split("|");
						curr_cd.InsertItem(j,tempText[0] ,tempText[0]);
					}
				}
					curr_cd.SetSelectCode("USD");
				//setting DISP_STS_CD
				if(comboList[1] != null){
					for(var j=0; j < comboList[1].length;j++){
						var tempText=comboList[1][j].split("|");
						disp_sts_cd.InsertItem(j,tempText[1] ,tempText[0]);
					}
				}
					disp_sts_cd.SetSelectCode(-1);
					disp_sts_cd.SetEnable(0);
				//setting EQ_KND_CD
				if(comboList[2] != null){
					for(var j=0; j < comboList[2].length;j++){
						var tempText=comboList[2][j].split("|");
							eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
						if(j == 0){
							eqKnddefCode=tempText[0];
						}
					}
				}
					eq_knd_cd.SetSelectCode(eqKnddefCode);
				//APP OFFICE
				if(comboList[3] != null){
					for(var j=0; j < comboList[3].length;j++){
						var tempText=comboList[3][j].split("|");
							apro_ofc_cd.InsertItem(j, tempText[0] ,tempText[0]);
						if(j == 0){
							appOfcdefCode=tempText[0];
						}
					}
				}
					apro_ofc_cd.SetSelectCode(appOfcdefCode);
				//setting sheet combo
				var sheetComboCode="";
				var sheetComboText="";
				var sheetComboCodeText="";
				//saving DEF value
				var sheetComboDefault=new Array();
				var comboSaveNames=new Array();
				//------ sheetObjects[1]
				comboSaveNames[0]="eq_knd_cd";
				comboSaveNames[1]="curr_cd";
				comboSaveNames[2]="disp_sts_cd";
				//------ sheetObjects[2]
				comboSaveNames[3]="mnr_prnr_knd_cd";
				//------ sheetObjects[3]
				comboSaveNames[4]="disp_rsn_cd";
				comboSaveNames[5]="mkr_nm";
				comboSaveNames[6]="disp_vrfy_tp_cd";
				for(var i=4; i < comboList.length;i++){
					if(comboList[i] != null){
						sheetComboText="";
						sheetComboCode="";
						//sheetComboCodeText = "";
				 		for(var j=0; j < comboList[i].length;j++){
							var tempText=comboList[i][j].split("|");
							sheetComboCode +=  tempText[0] + "|";
							sheetComboText +=  tempText[1] + "|";
							//sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
							if(j == 0){
								sheetComboDefault[i - 4]=tempText[0];
							}
						}
						sheetComboCode=MnrDelLastDelim(sheetComboCode);
				     	sheetComboText=MnrDelLastDelim(sheetComboText);
						if(comboSaveNames[i - 4] == "eq_knd_cd"){
							sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 4], sheetComboText, sheetComboCode ,sheetComboDefault[i - 4]);
						} else if(comboSaveNames[i - 4] == "curr_cd"){
							sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 4], sheetComboCode, sheetComboCode ,sheetComboDefault[i - 4]);
						} else if(comboSaveNames[i - 4] == "disp_sts_cd"){
							sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 4], sheetComboText, sheetComboCode ,sheetComboDefault[i - 4]);
						} else if(comboSaveNames[i - 4] == "mnr_prnr_knd_cd"){
							sheetObjects[2].InitDataCombo (0, comboSaveNames[i - 4], sheetComboText, sheetComboCode ,sheetComboDefault[i - 4]);
						} else if(comboSaveNames[i - 4] == "disp_rsn_cd"){
							sheetObjects[3].InitDataCombo (0, comboSaveNames[i - 4], sheetComboText, sheetComboCode ,sheetComboDefault[i - 4]);
						} else if(comboSaveNames[i - 4] == "mkr_nm"){
							sheetObjects[3].InitDataCombo (0, comboSaveNames[i - 4], sheetComboText, sheetComboCode ,sheetComboDefault[i - 4]);
						} else if(comboSaveNames[i - 4] == "disp_vrfy_tp_cd"){
							sheetObjects[3].InitDataCombo (0, comboSaveNames[i - 4], sheetComboText, sheetComboCode ,sheetComboDefault[i - 4]);
						}
					}
				}
				//retrieving partner
				formObj.f_cmd.value=INIT;
			    sParam=FormQueryString(formObj);
			    var sXml=sheetObj.GetSaveData("EES_MNR_0156GS.do", sParam);
			    sheetObjects[2].LoadSearchData(sXml,{Sync:0} );
				//setting form initial value
				var toDay=ComGetNowInfo("ymd");
				ComSetObjValue(formObj.rqst_dt,toDay);
				ComSetObjValue(formObj.disp_no,"NEW");
				ComSetObjValue(formObj.disp_qty,"0");
				ComSetObjValue(formObj.disp_st_prc,"0");
//				formObj.disp_eml_flg_temp.checked=true;
				sheetObj.SetWaitImageVisible(1);
				isNowInit=false;
				MnrWaitControl(false);
				break;
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
			   default :
		           with (comboObj) {
				       //SetColAlign("left");
					   //DropHeight = 160;
			       }
	           break;
	     }
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
		with(formObj){
	    	switch(sAction) {
				//saving
				case IBSAVE:
					var Row=sheetObjects[3].ColValueDup("eq_no");
					if(Row > 0){
						ComShowCodeMessage("MNR00006","EQ No ");
						sheetObjects[3].SetCellValue(Row,"eq_no","",0);
						sheetObjects[3].SetCellValue(Row,"eq_tpsz_cd","",0);
						sheetObjects[3].SetCellValue(Row,"lstm_cd","",0);
						sheetObjects[3].SetCellValue(Row,"mvmt_cd","",0);
						sheetObjects[3].SetCellValue(Row,"disp_yd_cd","",0);
						sheetObjects[3].SetCellValue(Row,"mtrl_nm","",0);
						sheetObjects[3].SetCellValue(Row,"mkr_nm","",0);
						sheetObjects[3].SetCellValue(Row,"mdl_nm","",0);
						sheetObjects[3].SetCellValue(Row,"disp_ut_prc","0.00",0);
						sheetObjects[3].SetCellValue(Row,"disp_vrfy_tp_cd","",0);
						sheetObjects[3].SetCellValue(Row,"disp_trf_ut_prc","",0);
						sheetObjects[3].SetCellValue(Row,"rpr_cost_amt","",0);
						sheetObjects[3].SelectCell(Row,"eq_no");
						return false;
					}
//					if(disp_eml_flg_temp.checked == true){
//						formObj.disp_eml_flg.value="Y";
//					} else {
//						formObj.disp_eml_flg.value="N";
//					}
					if (!ComChkValid(formObj)) return false;
					//price and qty is greater than zero..
					for(var x=1 ; x <= sheetObjects[3].RowCount();x++){
						if(parseFloat(sheetObjects[3].GetCellValue(x,"disp_ut_prc")) == 0){
							ComShowCodeMessage("MNR00245","Disposal ");
							sheetObjects[3].SelectCell(x,"disp_ut_prc");
							return false;
						}
					}
					//Buyer Selection is One or more 
					if(sheetObjects[2].FindCheckedRow("del_chk") == ""){
						ComShowCodeMessage("MNR00246","Buyer");
						return false;
					}
					// price and qty are One or more 
					if((sheetObjects[3].RowCount()) < 1){
						ComShowCodeMessage("MNR00247","Detail");
						return false;
					}
					break;
				//request
				case IBBATCH:
					var Row=sheetObjects[3].ColValueDup("eq_no");
					if(Row > 0){
						ComShowCodeMessage("MNR00006","EQ No ");
						sheetObjects[3].SetCellValue(Row,"eq_no","",0);
						sheetObjects[3].SetCellValue(Row,"eq_tpsz_cd","",0);
						sheetObjects[3].SetCellValue(Row,"lstm_cd","",0);
						sheetObjects[3].SetCellValue(Row,"mvmt_cd","",0);
						sheetObjects[3].SetCellValue(Row,"disp_yd_cd","",0);
						sheetObjects[3].SetCellValue(Row,"mtrl_nm","",0);
						sheetObjects[3].SetCellValue(Row,"mkr_nm","",0);
						sheetObjects[3].SetCellValue(Row,"mdl_nm","",0);
						sheetObjects[3].SetCellValue(Row,"disp_ut_prc","0.00",0);
						sheetObjects[3].SetCellValue(Row,"disp_vrfy_tp_cd","",0);
						sheetObjects[3].SetCellValue(Row,"disp_trf_ut_prc","",0);
						sheetObjects[3].SetCellValue(Row,"rpr_cost_amt","",0);
						sheetObjects[3].SelectCell(Row,"eq_no");
						return false;
					}
//					if(disp_eml_flg_temp.checked == true){
//						formObj.disp_eml_flg.value="Y";
//					} else {
//						formObj.disp_eml_flg.value="N";
//					}
					if (!ComChkValid(formObj)) return false;
					//price and qty is greater than zero..
					for(var x=1 ; x <= sheetObjects[3].RowCount();x++){
						if(parseFloat(sheetObjects[3].GetCellValue(x,"disp_ut_prc")) == 0){
							ComShowCodeMessage("MNR00245","Disposal ");
							sheetObjects[3].SelectCell(x,"disp_ut_prc");
							return false;
						}
					}
					//Buyer Selection is One or more 
					if(sheetObjects[2].FindCheckedRow("del_chk") == ""){
						ComShowCodeMessage("MNR00246","Buyer");
						return false;
					}
					//Please input more than one
					if((sheetObjects[3].RowCount()) < 1){
						ComShowCodeMessage("MNR00247","Detail");
						return false;
					}
					break;
				//retrieving detail
				case IBROWSEARCH:
					if(MnrNullToBlank(disp_no.value) == "" || MnrNullToBlank(disp_no.value) == "NEW"){
						ComShowCodeMessage("MNR00248","Disposal ");
						return false;
					}
					break;
				case IBDELETE:
					if(!selCheck){
						ComShowCodeMessage("MNR00132");
						return false;
					}
					if (!ComShowCodeConfirm("MNR00275","Disposal","Delete")){return false;}
					break;
			}
		}
        return true;
    }
	function sheet2_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			if(actionType == "IBSAVE"){
				ComShowCodeMessage("MNR00129");
				if(MnrComGetErrMsg(sXml_1) == null){
					var dispNo=ComGetEtcData(sXml_1, "disp_no");
					var targetRow=0;
					with(sheetObjects[1]){
						for(var j=1; j <= LastRow();j++){
							if(GetCellValue(j,"disp_no") == dispNo){
								targetRow=j;
							}
						}
					}
					
					doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
					//selected as
					if(targetRow != 0){
						sheetObjects[1].SelectCell(targetRow,1);
						sheet2_OnDblClick(sheetObjects[1],targetRow,1);
					}
				}
			} else if(actionType == "IBBATCH") {
				ComShowCodeMessage("MNR00131");
				doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
			} else {
				ComShowCodeMessage("MNR00020");
				doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
			}
		}
	}
	/********************************SHEET EVENT *******************************/
	function sheet2_OnDblClick(sheetObj,Row,Col)
    {
		var formObj=document.form;
		with(sheetObj){
			//setting header
			isNowInit=true;
			formObj.disp_no.value=GetCellValue(Row,"disp_no");
			eq_knd_cd.SetSelectCode(GetCellValue(Row,"eq_knd_cd"));
			formObj.disp_qty.value=ComAddComma2(GetCellValue(Row,"disp_qty"), "#,###");
			formObj.disp_st_prc.value=ComAddComma2(GetCellValue(Row,"disp_st_prc"), "#,###");
			formObj.rqst_dt.value=GetCellValue(Row,"rqst_dt");
			disp_sts_cd.SetSelectCode(GetCellValue(Row,"disp_sts_cd"));
			apro_ofc_cd.SetSelectCode(GetCellValue(Row,"apro_ofc_cd"));
			curr_cd.SetSelectCode(GetCellValue(Row,"curr_cd"));
			formObj.mnr_disp_rmk.value=GetCellValue(Row,"mnr_disp_rmk");
//			if(GetCellValue(Row,"disp_eml_flg") == 'Y'){
//				formObj.disp_eml_flg.value='Y';
//				formObj.disp_eml_flg_temp.checked=true;
//			} else {
//				formObj.disp_eml_flg.value='N';
//				formObj.disp_eml_flg_temp.checked=false;
//			}
			isNowInit=false;
			//select status
			selCheck=true;
			//initializing sheet
			sheetObjects[2].RemoveAll();
			sheetObjects[3].RemoveAll();
			sheetObjects[4].RemoveAll();
			
			selectedRow = Row;
			//retrieving detail
			doActionIBSheet(sheetObjects[0],formObj,IBROWSEARCH);
			return;
		}
    }
	function sheet3_OnChange(sheetObj,Row, Col, Value)	{
		var formObj=document.form;
		if(sheetObj.ColSaveName(Col) == "del_chk"){
			var sRow=sheetObj.FindCheckedRow("del_chk");
			if(sRow != ""){
				var arrRow=sRow.split("|");
				if(arrRow.length > 2){
					//Buyer Selection initializing unconditionally
					initBuyerSelection();
					//reselect
					sheetObj.SetCellValue(Row,"del_chk","1",0);
				}
			}
			MnrCheckRowColChange(sheetObj,sheetObj.GetCellValue(Row,"del_chk"),Row);
		}
	}
	function t1_sheet1_OnChange(sheetObj,Row, Col, Value)	{
		var formObj=document.form;
		
		if (sheetObj.ColSaveName(Col) == "eq_no"){
			var checkEqn=sheetObj.GetCellValue(Row,Col);
			var checkEqType=eq_knd_cd.GetSelectCode();
			var dispNo=formObj.disp_no.value;
			var retArray=MnrGeneralCodeCheck(sheetObjects[0],"DSPEQN",checkEqn + "," + checkEqType + ","+ dispNo);

			if(retArray == null || retArray[0] == null){

				ComShowCodeMessage("MNR00385",checkEqn,"EQ No.");
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);
				sheetObj.SetCellValue(Row,"lstm_cd","",0);
				sheetObj.SetCellValue(Row,"mvmt_cd","",0);
				sheetObj.SetCellValue(Row,"disp_yd_cd","",0);
				sheetObj.SetCellValue(Row,"mtrl_nm","",0);
				sheetObj.SetCellValue(Row,"mkr_nm","",0);
				sheetObj.SetCellValue(Row,"mdl_nm","",0);
				sheetObj.SetCellValue(Row,"disp_ut_prc","0.00",0);
				sheetObj.SetCellValue(Row,"disp_vrfy_tp_cd","",0);
				sheetObj.SetCellValue(Row,"disp_trf_ut_prc","",0);
				sheetObj.SetCellValue(Row,"rpr_cost_amt","",0);
				sheetObj.SetCellEditable(Row, "disp_yd_cd",0);
				sheetObj.SelectCell(Row,Col);

			} else {

				var tempText=retArray[0].split("|");
				if(tempText[1] != 'OK'){

					ComShowCodeMessage("MNR00302",tempText[0]);
					sheetObj.SetCellValue(Row,Col,"",0);
					sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);
					sheetObj.SetCellValue(Row,"lstm_cd","",0);
					sheetObj.SetCellValue(Row,"mvmt_cd","",0);
					sheetObj.SetCellValue(Row,"disp_yd_cd","",0);
					sheetObj.SetCellValue(Row,"mtrl_nm","",0);
					sheetObj.SetCellValue(Row,"mkr_nm","",0);
					sheetObj.SetCellValue(Row,"mdl_nm","",0);
					sheetObj.SetCellValue(Row,"disp_ut_prc","0.00",0);
					sheetObj.SetCellValue(Row,"disp_vrfy_tp_cd","",0);
					sheetObj.SetCellValue(Row,"disp_trf_ut_prc","",0);
					sheetObj.SetCellValue(Row,"rpr_cost_amt","",0);
					sheetObj.SetCellEditable(Row, "disp_yd_cd",0);
					sheetObj.SelectCell(Row,Col);

				} else {

					sheetObj.SetCellEditable(Row, "disp_yd_cd",1);
					setEqInfo(sheetObj,eq_knd_cd.GetSelectCode(),sheetObj.GetCellValue(Row,Col),ComGetNowInfo("ymd"),Row,Col);
					if(sheetObjects[3].GetCellEditable(Row, "mkr_nm")){
						sheetObj.SelectCell(Row,"mkr_nm");
					} else {
						sheetObj.SelectCell(Row,"disp_ut_prc");
					}

				}
			}

			reSetQtyAndPrice();
			
		} else if(sheetObj.ColSaveName(Col) == "del_chk"){
			MnrCheckRowColChange(sheetObj,sheetObj.GetCellValue(Row,"del_chk"),Row);
		} else if(sheetObj.ColSaveName(Col) == "disp_ut_prc"){
			//in case of existing EQ Number
			if(sheetObj.GetCellValue(Row,"eq_no") != ""){
				//NOT Damage
				if(sheetObj.GetCellValue(Row,"disp_rsn_cd") == "C"){
					if(sheetObj.GetCellValue(Row,"disp_trf_ut_prc") == "0" || sheetObj.GetCellValue(Row,"disp_trf_ut_prc") == ""){
						sheetObj.SetCellValue(Row,"disp_vrfy_tp_cd","NT",0);
					} else {
						var trfUtPrc=parseFloat(sheetObj.GetCellValue(Row,"disp_trf_ut_prc"));
						var dispUtPrc=parseFloat(sheetObj.GetCellValue(Row,"disp_ut_prc"));
						//setting 'Success' in case of Greater than or equal to Tariff.
						if(dispUtPrc >= trfUtPrc){
							sheetObj.SetCellValue(Row,"disp_vrfy_tp_cd","SS",0);
						} else {
							sheetObj.SetCellValue(Row,"disp_vrfy_tp_cd","UP",0);
						}
					}
				//Damage
				} else {
					sheetObj.SetCellValue(Row,"disp_vrfy_tp_cd","DA",0);
				}
			}
			reSetQtyAndPrice();
		} else if(sheetObj.ColSaveName(Col) == "disp_rsn_cd"){
			//in case of existing EQ Number
			if(sheetObj.GetCellValue(Row,"eq_no") != ""){
				//NOT Damage
				if(sheetObj.GetCellValue(Row,"disp_rsn_cd") == "C"){
					if(sheetObj.GetCellValue(Row,"disp_trf_ut_prc") == "0" || sheetObj.GetCellValue(Row,"disp_trf_ut_prc") == ""){
						sheetObj.SetCellValue(Row,"disp_vrfy_tp_cd","NT",0);
					} else {
						var trfUtPrc=parseFloat(sheetObj.GetCellValue(Row,"disp_trf_ut_prc"));
						var dispUtPrc=parseFloat(sheetObj.GetCellValue(Row,"disp_ut_prc"));
						//setting 'Success' in case of Greater than or equal to Tariff.
						if(dispUtPrc >= trfUtPrc){
							sheetObj.SetCellValue(Row,"disp_vrfy_tp_cd","SS",0);
						} else {
							sheetObj.SetCellValue(Row,"disp_vrfy_tp_cd","UP",0);
						}
					}
					sheetObj.SetCellValue(Row,"rpr_cost_amt","",0);
					//1. add the Repair Cost next to 'Sale Category'. 2. If damage can be input.
					sheetObj.SetCellEditable(Row, "rpr_cost_amt",0);
				//Damage
				} else {
					sheetObj.SetCellValue(Row,"disp_vrfy_tp_cd","DA",0);
					//1. add the Repair Cost next to 'Sale Category'. 2. If damage can be input.
					sheetObj.SetCellEditable(Row, "rpr_cost_amt",1);
				}
			}
		} else if(sheetObj.ColSaveName(Col) == "disp_yd_cd"){
			var checkYard=sheetObj.GetCellValue(Row,"disp_yd_cd");
			retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
			if(retArray == null){
				ComShowCodeMessage("MNR00165",checkYard,"YARD");
				sheetObj.SetCellValue(Row,"disp_yd_cd","",0);
				sheetObj.SelectCell(Row,"disp_yd_cd");
			} else {
				//getting unit price
				var price=MnrGetDISPEQUnitPrice(sheetObjects[0],curr_cd.GetSelectCode(),sheetObj.GetCellValue(Row,"eq_tpsz_cd"),sheetObj.GetCellValue(Row,"disp_yd_cd"),formObj.rqst_dt.value);
				if(MnrNullToBlank(price) == "0" || MnrNullToBlank(price) == ""){
					sheetObj.SetCellValue(Row,"disp_ut_prc","0.00",0);
					//Not Found Tariff
					sheetObj.SetCellValue(Row,"disp_vrfy_tp_cd","NT",0);
					sheetObj.SetCellValue(Row,"disp_trf_ut_prc","0",0);
				}  else {
					sheetObj.SetCellValue(Row,"disp_ut_prc",price,0);
					sheetObj.SetCellValue(Row,"disp_trf_ut_prc",price,0);
					//NOT Damage
					if(sheetObj.GetCellValue(Row,"disp_rsn_cd") == "C"){
						if(sheetObj.GetCellValue(Row,"disp_trf_ut_prc") == "0" || sheetObj.GetCellValue(Row,"disp_trf_ut_prc") == ""){
							sheetObj.SetCellValue(Row,"disp_vrfy_tp_cd","NT",0);
						} else {
							sheetObj.SetCellValue(Row,"disp_vrfy_tp_cd","SS",0);
						}
						sheetObj.SetCellValue(Row,"rpr_cost_amt","",0);
						//1. add the Repair Cost next to 'Sale Category'. 2. If damage can be input.
						sheetObj.SetCellEditable(Row, "rpr_cost_amt",0);
					//Damage
					} else {
						sheetObj.SetCellValue(Row,"disp_vrfy_tp_cd","DA",0);
						//1. add the Repair Cost next to 'Sale Category'. 2. If damage can be input.
						sheetObj.SetCellEditable(Row, "rpr_cost_amt",1);
					}
				}
				return;
			}
		}
	}
	
	
	
	function t1_sheet1_OnSearchEnd(sheetObj, errMsg) {
		//retrieving file list
		var fileSeq=sheetObjects[1].GetCellValue(selectedRow,"file_seq");
		uploadFileSeq=fileSeq;
		if(fileSeq != "" && fileSeq != null){
			var fileXml=SearchFileUpload(sheetObjects[4],fileSeq);
			if(!MnrIsEmptyXml(fileXml)){
				sheetObjects[4].LoadSearchData(fileXml);
			}
		}
	}

	/**
     * downloading file <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Col     	selected Row of sheetObj
     * @param {ibsheet} Col     	selected Col of sheetObj
     * @param {String} 	Value     	file name
     **/
	function sheet4_OnClick(sheetObj,Row,Col,Value){
		var prefix="";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.GetRowStatus(Row)=="I")return;
		if(sheetObj.GetCellText(Row, prefix+"file_path_nm") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_path_nm");
		return;
	}
	function reSetQtyAndPrice(){
		//getting QTY Price
		var formObj=document.form;
		var sheetQtySum=0;
		var sheet3PriceSum=0;
		var sheet4PriceSum=0;
		for(var x=1 ; x <= sheetObjects[3].RowCount();x++){
			if(sheetObjects[3].GetCellValue(x,"eq_no") != ""){
				sheetQtySum++;
				sheet3PriceSum += parseFloat(sheetObjects[3].GetCellValue(x,"disp_ut_prc"));
			}
		}
		formObj.disp_st_prc.value=ComAddComma2((sheet3PriceSum), "#,###");
		formObj.disp_qty.value=ComAddComma2(sheetQtySum, "#,###");
	}
	function setEqInfo(sheetObj,sEqType,sEqNo,sTotalLossDate,Row,Col){
		var formObj=document.form;
		var sCostType="";
		if(sEqType == "U"){
			sCostType="MRDRRC";
		} else if(sEqType == "G"){
			sCostType="MRGSRC";
		} else {
			sCostType="MRZSRC";
		}
		var sXml=MnrComEqGenInfoSearch(sheetObjects[0],sEqType,sEqNo,sTotalLossDate,sCostType);
		var retArr=MnrXmlToArray(sXml);
		//0 imm_ext|1 mdl_nm|2 mvmt_dt|3 dv_cur|4 rpr_yd|5 sp_name|6 flg_rmk|7 manu_dt|8 mkr_nm|9 pagerows|10 dv_value|11 ibflag|12 off_hire|13 mvmt_cd|14 dsp_flag|15 hngr_flg_yd|16 lessor_nm|17 hngr_rck_cd|18 crnt_yd_cd|19 lstm_cd|20 eq_no|21 hngr_flg_dt|22 bar_atch_knt|23 status|24 bar_tp_cd|25 dmg_flag|26 cost|27 mtrl_cd|28 eq_type|29 mtrl_nm|30 rpr_type|31 eq_tpsz_cd|32 rpr_dt|33 total_loss_date|34 rpr_cost_amt
		if(retArr != null){
			//TpSz
			sheetObj.SetCellValue(Row,"eq_tpsz_cd",retArr[0][31],0);
			//Term
			sheetObj.SetCellValue(Row,"lstm_cd",retArr[0][19],0);
			//mvmt_cd
			sheetObj.SetCellValue(Row,"mvmt_cd",retArr[0][13],0);
			//current Yard
			sheetObj.SetCellValue(Row,"disp_yd_cd",retArr[0][18],0);
			//Material
			sheetObj.SetCellValue(Row,"mtrl_nm",retArr[0][29],0);
			//Maker Name
			sheetObj.SetCellValue(Row,"mkr_nm",retArr[0][8],0);
			//Unit Model
			sheetObj.SetCellValue(Row,"mdl_nm",retArr[0][1],0);
			//RPR_COST_AMT
			sheetObj.SetCellValue(Row,"rpr_cost_amt","",0);//retArr[0][34];
			sheetObjects[3].SetCellValue(Row,"rpr_cost_amt","",0);
			var checkRsnCd=MnrNullToBlank(sheetObjects[3].GetCellValue(Row,"disp_rsn_cd"));
			if(checkRsnCd == 'C'){
				sheetObjects[3].SetCellEditable(Row, "rpr_cost_amt",0);
			} else {
				sheetObjects[3].SetCellEditable(Row, "rpr_cost_amt",1);
			}
		} else {
			ComShowCodeMessage("MNR00318");
			sheetObj.SetCellValue(Row,"eq_no","",0);
			sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);
			sheetObj.SetCellValue(Row,"lstm_cd","",0);
			sheetObj.SetCellValue(Row,"mvmt_cd","",0);
			sheetObj.SetCellValue(Row,"disp_yd_cd","",0);
			sheetObj.SetCellValue(Row,"mtrl_nm","",0);
			sheetObj.SetCellValue(Row,"mkr_nm","",0);
			sheetObj.SetCellValue(Row,"mdl_nm","",0);
			sheetObj.SetCellValue(Row,"disp_vrfy_tp_cd","",0);
			sheetObj.SetCellValue(Row,"disp_trf_ut_prc","",0);
			sheetObj.SetCellValue(Row,"rpr_cost_amt","",0);
			return;
		}
		//getting unit price
		var price=MnrGetDISPEQUnitPrice(sheetObjects[0],curr_cd.GetSelectCode(),sheetObj.GetCellValue(Row,"eq_tpsz_cd"),sheetObj.GetCellValue(Row,"disp_yd_cd"),formObj.rqst_dt.value);
		if(MnrNullToBlank(price) == "0" || MnrNullToBlank(price) == ""){
			sheetObj.SetCellValue(Row,"disp_ut_prc","0.00",0);
			//Not Found Tariff
			sheetObj.SetCellValue(Row,"disp_vrfy_tp_cd","NT",0);
			sheetObj.SetCellValue(Row,"disp_trf_ut_prc","0",0);
		}  else {
			sheetObj.SetCellValue(Row,"disp_ut_prc",price,0);
			sheetObj.SetCellValue(Row,"disp_vrfy_tp_cd","SS",0);
			sheetObj.SetCellValue(Row,"disp_trf_ut_prc",price,0);
		}
	}
	/**
	 * Location handling Pop-up Return Value<br>
	 * @param {arry} Return value array of returnedValues Pop-up
	 * @param Row IBSheet Row index
	 * @param Col IBSheet Col index
	 * @param Sheet Array index
	 */
	function setPopData_Loc(aryPopupData, Row, Col, sheetIdx) {
		if ( aryPopupData.length > 0 ) {
			with(sheetObjects[sheetIdx]) {
				var sName=ColSaveName(Col);
				switch(sName) {
					case "disp_yd_cd":
						SetCellValue(Row,Col,aryPopupData[0][10],0);
					break;
				}
			}
		}
	}
	/**
	 * EES_MNR_158 function return result from popup <br>
	 * @param {arry} Return value array of returnedValues Pop-up
	 * @param Row IBSheet Row index
	 * @param Col IBSheet Col index
	 * @param Sheet Array index
	 */
	function setPopData_DSPC(aryPopupData, Row, Col, sheetIdx) {
		var formObj=document.form;
		var tempRowCnt=0;
		var firstInsRow=0;
		if ( aryPopupData.length > 0 ) {
			with(sheetObjects[3]) {
				for(var i=0; i < aryPopupData.length; i++){
					if(FindText("eq_no",aryPopupData[i][4]) == -1){
						var Row=DataInsert(-1);
						if(tempRowCnt == 0){
							firstInsRow=Row;
						}
						SetCellValue(Row,"disp_ut_tp_cd","E",0);
						SetCellValue(Row,"disp_qty","1",0);
						SetCellValue(Row,"eq_no",aryPopupData[i][4],0);
						SetCellValue(Row,"eq_tpsz_cd",aryPopupData[i][5],0);
						SetCellValue(Row,"lstm_cd",aryPopupData[i][6],0);
						SetCellValue(Row,"mvmt_cd",aryPopupData[i][7],0);
						SetCellValue(Row,"disp_yd_cd",aryPopupData[i][8],0);
						SetCellValue(Row,"mtrl_nm",aryPopupData[i][12],0);
						SetCellValue(Row,"mkr_nm",aryPopupData[i][13],0);
						SetCellValue(Row,"mdl_nm",aryPopupData[i][14],0);
						SetCellValue(Row,"rpr_cost_amt","",0);//aryPopupData[i][20];
						//getting unit price
						var price=MnrGetDISPEQUnitPrice(sheetObjects[0],curr_cd.GetSelectCode(),aryPopupData[i][5],aryPopupData[i][8],formObj.rqst_dt.value);
						if(MnrNullToBlank(price) == "0" || MnrNullToBlank(price) == ""){
							SetCellValue(Row,"disp_ut_prc","0.00",0);
							//Not Found Tariff
							SetCellValue(Row,"disp_vrfy_tp_cd","NT",0);
							SetCellValue(Row,"disp_trf_ut_prc","0",0);
						}  else {
							SetCellValue(Row,"disp_ut_prc",price,0);
							SetCellValue(Row,"disp_vrfy_tp_cd","SS",0);
							SetCellValue(Row,"disp_trf_ut_prc",price,0);
						}
						tempRowCnt++;
					}
				}
			}
		}
	}
	function eq_knd_cd_OnChange(comboObj,Index_Code, Text){
		var totDTLRowCnt=sheetObjects[3].RowCount();
		if(!isNowInit && totDTLRowCnt > 0){
			if (!ComShowCodeConfirm("MNR00249")){
				comboObj.SetSelectCode(preEqKndCd,false);
				return;
			}
			sheetObjects[3].RemoveAll();
		}
		var tpSzComboStr="";
		if(comboObj.GetSelectCode()== "U"){
			tpSzComboStr=ComGetAryJoin(uTpSz,"|");
		} else if(comboObj.GetSelectCode()== "G"){
			tpSzComboStr=ComGetAryJoin(gTpSz,"|");
		} else {
			tpSzComboStr=ComGetAryJoin(zTpSz,"|");
		}
		sheetObjects[3].InitDataCombo (0, "eq_tpsz_cd", tpSzComboStr, tpSzComboStr ,"");
		preEqKndCd=comboObj.GetSelectCode();
	}
	function curr_cd_OnChange(comboObj,Index_Code, Text){
		var totDTLRowCnt=sheetObjects[3].RowCount();
		if(!isNowInit && totDTLRowCnt > 0){
			if (!ComShowCodeConfirm("MNR00249")){
				comboObj.SetSelectCode(preCurrCd,false);
				return;
			}
			sheetObjects[3].RemoveAll();
		}
		preCurrCd=comboObj.GetSelectCode();
	}
	/**
	* Buyer Selection initializing unconditionally
     * activating selected tab items.
	*/
	function initBuyerSelection(){
		//Buyer Selection initializing unconditionally
		var checkVal="";
		checkVal="0";
		for(var x=1 ; x <= sheetObjects[2].RowCount();x++){
			sheetObjects[2].SetCellValue(x,"del_chk",checkVal,0);
			MnrCheckRowColChange(sheetObjects[2],sheetObjects[2].GetCellValue(x,"del_chk"),x);
		}
	}
    /**
     * adding row to tab of IBSheet. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return {nothing}
     **/
	function file_Insert(sheetObj){
		//**** Modify header, depending on the number of  CellValue(1,"file_seq");
		uploadFileSeq=sheetObj.GetCellValue(1,"file_seq");
		if(uploadFileSeq == undefined || uploadFileSeq == -1){
			uploadFileSeq="";
		}
		for(var j=2; j <= sheetObj.LastRow();j++){
			if (sheetObj.GetCellValue(j,"org_file_nm") == ""){
					//ComShowMessage('MNR00024');
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
	function initControl() {
	    //Axon handling event1. event catch
		var formObject=document.form;
	    //axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  
	    //axon_event.addListenerFormat('focus',    'obj_activate',    formObject);                     
		//axon_event.addListenerFormat('change',	 'obj_change',	formObject); 
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
	    		case "disp_eml_flg_temp":
				   	break;
			}
	    }
	}
	
/* developer job */