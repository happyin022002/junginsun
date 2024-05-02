/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_MNR_0096.js
*@FileTitle  : Total Loss Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
/****************************************************************************************
 Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
 COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class EES_MNR_0096 : EES_MNR_0096 - Defining a script used by screen
 */

	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var comboObjects=new Array();
	var comboCnt=0;
	var sheetObjects=new Array();
	var sheetCnt=0;
	//Using for upload file
	var uploadFileSeq="";
	//History Seq at Saving
	var historyMnrStsRefNo="";
	var sSaveRtnXml="";
	var nowLoad=0;
	var actionType="";
	var nowLoad=0;
	// Defining event handler of button click */
	document.onclick=processButtonClick;
	// Event handler to diverge process by button name */
    function processButtonClick(){
        /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var sheetObject3=sheetObjects[2];
		var sheetObject4=sheetObjects[3];
		var sheetObject5=sheetObjects[4];
		var sheetObject6=sheetObjects[5];
		var sheetObject7=sheetObjects[6];
		var sheetObject8=sheetObjects[7];
		var sheetObject9=sheetObjects[8];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
				switch(srcName) {
					case "btn_period" :
						var cal=new ComCalendarFromTo();
						cal.select(formObject.in_st_dt,  formObject.in_end_dt,  'yyyy-MM-dd');
						break;
					case "btn_ttl_lss_dt" :
						if(sheetObject3.RowCount()>0)
						{
							var cal=new ComCalendar();
							cal.select(formObject.ttl_lss_dt, 'yyyy-MM-dd');
						}
						break;
 					case "btn_iss_dt" :
						if(sheetObject3.RowCount()>0)
						{
							var cal=new ComCalendar();
							cal.select(formObject.ttl_lss_iss_dt, 'yyyy-MM-dd');
						}
						break;
					case "btn_Retrieve":
						doActionIBSheet(sheetObject2,formObject,IBSEARCH);
						break;
					case "btn_New":
						doActionIBSheet(sheetObject1,formObject,IBCLEAR);
						break;
					case "btn_Reject":
						doActionIBSheet(sheetObject1,formObject,IBSAVE,1);
						break;
					case "btn_Confirm":
						doActionIBSheet(sheetObject1,formObject,IBSAVE,2);
						break;
	                //Multi inserting
					case "btn_ttl_lss_no_multi":
						rep_Multiful_inquiry("in_ttl_lss_no");
						break;
					/** (Tab) D.V Expense (S) **/
					case "btn_t1EQAdd":
						ComOpenPopup('/opuscntr/EES_MNR_0097.do', 800, 385, 'setEES_MNR_0097', '1,0', true);
						break;
					case "btn_t1RowAdd":
						doActionIBSheet(sheetObject3,formObject,IBINSERT);
						break;
					case "btn_t1RowDel":
						doActionIBSheet(sheetObject3,formObject,IBDELETE);
						break;
					/** (Tab) D.V Expense (E) **/
					/** (Tab) 3rd Party (S) **/
					case "btn_t2RowAdd":
						doActionIBSheet(sheetObject4,formObject,IBINSERT);
						break;
					case "btn_t2RowDel":
						doActionIBSheet(sheetObject4,formObject,IBDELETE);
						break;
					/** (Tab) 3rd Party (E) **/
					/** (Tab) Disposal (S) **/
					case "btn_t3RowAdd":
						doActionIBSheet(sheetObject5,formObject,IBINSERT);
						break;
					case "btn_t3RowDel":
						doActionIBSheet(sheetObject5,formObject,IBDELETE);
						break;
					/** (Tab) Disposal (E) **/
					/** (Tab) Scrapping (S) **/
					case "btn_t4RowAdd":
						doActionIBSheet(sheetObject6,formObject,IBINSERT);
						break;
					case "btn_t4RowDel":
						doActionIBSheet(sheetObject6,formObject,IBDELETE);
						break;
					/** (Tab) Scrapping (E) **/
					/** (Tab) Insurance (S) **/
					case "btn_t5RowAdd":
						doActionIBSheet(sheetObject7,formObject,IBINSERT);
						break;
					case "btn_t5RowDel":
						doActionIBSheet(sheetObject7,formObject,IBDELETE);
						break;
					/** (Tab) Insurance (E) **/
					case "btn_RowAdd2":
						history_Insert(sheetObject8);
						break;
					case "btn_RowDel2":
						history_Remove(sheetObject8);
						break;
					case "btn_FileAdd":
						file_Insert(sheetObject9);
						break;
					case "btn_FileDel":
						file_Remove(sheetObject9);
						break;
					//RES Office. PopUp
					case "respb_ofc_cd_popup":
						if(MnrNullToBlank(formObject.search_ttl_lss_no.value) != ""){
							ComOpenPopup("COM_ENS_071.do", 810, 445, 'setPopUpParam_COM_ENS_071', '1,0', true);
						}
						break;
            } // end switch
    	}catch(e) {
    		if (e == "[object Error]") {
    			ComFuncErrMsg(e);
    		} else {
    			ComFuncErrMsg(e);
    		}
    	}
    }
    /**
     * Sheet default setting and initializing
     * To implement for onload event of body tag
     * After loading in your browser should display the ability to add pre-processing
     */
    function loadPage() {
    	//Setting button
    	MnrWaitControl(true);
    	nowLoad=1;
		//Axon Initializing event
		
		//IBMultiCombo Initializing
 	    for(var k=0; k < comboObjects.length; k++){
 	        initCombo(comboObjects[k], k + 1);
 	    }
    	// IBInitializing sheet
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        // IBTab Initializing
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k + 1);
            tabObjects[k].SetSelectedIndex(0);
        }
        initControl();
		//Initializing of file upload
        initUpload();
        doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 0);
        
        
    }
    
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
		 		sParam+= "&mnr_grp_tp_cd=TLL";               // MNR Work Group Type Code
		 		sParam+= "&file_seq=" + file_seq;            // File Sequence
		 		sParam+= "&file_dtl_seq=" + file_dtl_seq;    // File Sequence
		 		sParam+= "&org_file_nm=" + fileName;         // Fileupload : file name
		 		sParam+= "&ibflag=" + ibflag;                // I : First file upload,  U : Modify file
		 		paramToForm(sParam);
			 	return true;
			}
			,AfterSaveStatus : function(result) {
	      		var code = result.code;
	      		if( code == 0) {
	      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
	 				uploadFileSeq=ComGetEtcData(sXml,"seqValue");
	 				if(uploadFileSeq != "" && uploadFileSeq != undefined){
	 					var fileXml=SearchFileUpload(sheetObjects[8],uploadFileSeq);
	 					sheetObjects[8].LoadSearchData(fileXml,{Sync:1} );
					}
	      		}else {
					ComShowMessage(result.msg);
				}
			}
	 		,AfterAddFile:function(result){
				var files = result.files;
	 			var fileName= files[files.length-1].GetFileName();
	 			pSheetObj.SetCellValue(pRow, "org_file_nm",fileName,0);
				upload1.SaveStatus();
			}
 		});
 	}
    
    function sheet4_OnMouseMove(sheetObj, e) {
	  	  var row   = sheetObj.MouseRow(),
	        col     = sheetObj.MouseCol(),
	        info    = null;
	        if (row > 0 && sheetObj.ColSaveName(col) == "org_file_nm") {
	            info = sheetObj.GetCellElement(row, col, 1);
	    		pSheetObj = sheetObj;
				pRow = row;
				pCol = col;
	            upload1.SetFileUploadElement(info);
	        } 
	  }
    
    
  	/**
     * Initializing IBCombo
     * @param	{IBCombo}	comboObj	Object for initialized IBCombo
     * @param	{Number}	comboNo		Sequence number from combo object tag id
     */
    function initCombo(comboObj, comboNo) {
	    var cnt=0 ;
	    var formObject=document.form
	    switch(comboNo) {
	    	case 1:
			case 2:
	    	case 3:
	    	case 4:
	            with (comboObj) {
	    		SetColAlign(0, "left");
				   SetDropHeight(160);
		        }
	            break;
	     }
	}
    /**
     * Initializing variable for IBSheet and defining header
     * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":
			      with(sheetObj){	            
			         var HeadTitle1="||||||||||||";
			         var headCount=ComCountHeadTitle(HeadTitle1);
//			         (headCount, 0, 0, true);
			         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			         var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			         var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			         InitHeaders(headers, info);
		
			         var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_no" },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"rqst_ofc_cd" },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"rqst_dt" },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_sts_cd" },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_rsn_cd" },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_rsn_cd" },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dt" },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"apro_ofc_cd" },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"file_seq" },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mnr_sts_ref_no" },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"respb_ofc_cd" },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"respb_ofc_nm" } ];
			          
			         InitColumns(cols);
			         SetEditable(1);
			         SetVisible(false);
	               }
	            break;
			case "sheet2":
			      with(sheetObj){
	            
					         var HeadTitle1="|Seq.|TLL No.|REQ OFC|REQ User|REQ DT|Status|Main Reason|Sub Reason|TLL DT|APP OFC|Responsible OFC|D.V Exnpense|D.V Exnpense|D.V Exnpense|D.V Exnpense|3rd Party|3rd Party|Disposal|Disposal|Scrapping|Scrapping|Insurance|Insurance";
					         var HeadTitle2="|Seq.|TLL No.|REQ OFC|REQ User|REQ DT|Status|Main Reason|Sub Reason|TLL DT|APP OFC|Responsible OFC|EQ Q'ty|Expense|Recovery|Balance|EQ Q'ty|Amount|EQ Q'ty|Amount|EQ Q'ty|Amount|EQ Q'ty|Amount";
					         var headCount=ComCountHeadTitle(HeadTitle1);
//					         (headCount + 6, 0, 0, true);				
					         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );				
					         var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					         var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					         InitHeaders(headers, info);				
					         var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq",                 KeyField:0,   CalcLogic:"",   Format:"" },
					             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rqst_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rqst_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Combo",     Hidden:0, Width:125,  Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Combo",     Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_rsn_cd",      KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_dtl_rsn_nm",  KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"apro_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"PopupEdit", Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"respb_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"dv_eq_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"dv_exp",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"dv_recovery",         KeyField:0,   CalcLogic:"|tp_exp|+|ds_exp|+|sc_exp|+|ir_exp|",Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"dv_balance",          KeyField:0,   CalcLogic:"|dv_recovery|-|dv_exp|",Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"tp_eq_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"tp_exp",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"ds_eq_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"ds_exp",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"sc_eq_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"sc_exp",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"ir_eq_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"ir_exp",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_sts_ref_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ttl_lss_cfm_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ttl_lss_cfm_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ttl_lss_dtl_rsn_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ttl_lss_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"file_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
					          
					         InitColumns(cols);
					         SetEditable(1);
					         SetSheetHeight(180);
					         SetSheetWidth(870);
					         SetCountPosition(0);
	         
	                  }
                break;
            case "t1sheet1":
                with(sheetObj){
                
				             var HeadTitle1="|Sel.|Seq.|EQ Type|EQ No.|TP/SZ|Term|Yard|DV.Value|Lessor|Payee Code|Payee Name|Invoice No.|CURR|Pay Amount|Confirm Flag|Inv Status|Remark(s)";
				             var headCount=ComCountHeadTitle(HeadTitle1);
//				             (headCount + 17, 0, 0, true);				
				             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );				
				             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				             InitHeaders(headers, info);				
				             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
				                 {Type:"Combo",     Hidden:0, Width:85,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
				                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_yd_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
				                 {Type:"Float",     Hidden:0,  Width:95,   Align:"Right",   ColMerge:1,   SaveName:"dpc_val_amt",          KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				                 {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:1,   SaveName:"lessor_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Popup",     Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"payer_code",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"payer_name",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"inv_no",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				                 {Type:"Combo",     Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"AutoSum",   Hidden:0, Width:100,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_bil_amt",      KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				                 {Type:"CheckBox",  Hidden:0, Width:110,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_cfm_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Combo",     Hidden:0, Width:85,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
				                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_no" },
				                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_seq" },
				                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_inv_tp_cd" },
				                 {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_n3pty_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_prnr_cnt_cd" },
				                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_prnr_seq" },
				                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				                 {Type:"Text",      Hidden:1, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_expn_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				                 {Type:"Text",      Hidden:1, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_incm_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ar_chk_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				                 {Type:"Text",      Hidden:1, Width:65,   Align:"Left",    ColMerge:1,   SaveName:"bank_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Text",      Hidden:1, Width:65,   Align:"Left",    ColMerge:1,   SaveName:"bank_acct_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_plc_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"inv_rgst_no" },
				                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"csr_no" },
				                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cr_end_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:1, Width:130,  Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_bil_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				              
				             InitColumns(cols);
				             SetEditable(1);
				             SetSheetHeight(130);
				             SetCountPosition(0);
                      }
                break;
            case "t2sheet1":
                with(sheetObj){
               
			             var HeadTitle1="|Sel.|Seq.|EQ Type|EQ No.|TP/SZ|Term|Yard|DV.Value|Payer Type|Payer Code|Payer Name|CURR|3rd Amount|Issue Date|Remark(s)";
			             var headCount=ComCountHeadTitle(HeadTitle1);
//			             (headCount + 13, 0, 0, true);
			             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			             InitHeaders(headers, info);
			             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			                 {Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
			                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_yd_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
			                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"dpc_val_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			                 {Type:"Combo",     Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_n3pty_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Popup",     Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"payer_code",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"payer_name",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_bil_amt",      KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			                 {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_bil_dt",       KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_no" },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_seq" },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_inv_tp_cd" },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_prnr_cnt_cd" },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_prnr_seq" },
			                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"csr_no" },
			                 {Type:"Text",      Hidden:1, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_expn_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			                 {Type:"Text",      Hidden:1, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_incm_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"disp_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ar_chk_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_plc_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cr_end_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			              
			             InitColumns(cols);
			             SetEditable(1);
			             SetSheetHeight(130);
			             SetImageList(0,"img/btns_search.gif");
			             SetImageList(1,"img/btns_calendar.gif");
			             SetShowButtonImage(2);
			             SetColHidden("dpc_val_amt",1);
			             SetCountPosition(0);
				}
                break;
            case "t3sheet1":
                with(sheetObj){
               
			             var HeadTitle1="|Sel.|Seq.|EQ Type|EQ No.|TP/SZ|Term|Yard|Disposal No.|CURR|CSR No|Disposal AMT|Disposal Plan AMT|Remark(s)";
			             var headCount=ComCountHeadTitle(HeadTitle1);
//			             (headCount + 11, 0, 0, true);			
			             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );			
			             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			             InitHeaders(headers, info);			
			             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			                 {Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
			                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_yd_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"disp_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"csr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			                 {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_bil_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
			                 {Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_incm_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			                 {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_no" },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_seq" },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_inv_tp_cd" },
			                 {Type:"Text",      Hidden:1, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_expn_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			                 {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"inv_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			                 {Type:"Text",      Hidden:1, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"dpc_val_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ar_chk_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_plc_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"csr_no" },
			                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cr_end_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:1, Width:130,  Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_bil_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			              
			             InitColumns(cols);
			             SetEditable(1);
			             SetSheetHeight(130);
			             SetCountPosition(0);
                      }
                break;
            case "t4sheet1":
                with(sheetObj){
               
			             var HeadTitle1="|Sel.|Seq.|EQ Type|EQ No.|TP/SZ|Term|Yard|CURR|CSR No|Scrapping Income AMT|Scrapping Cost AMT|Remark(s)";
			             var headCount=ComCountHeadTitle(HeadTitle1);
//			             (headCount + 10, 0, 0, true);
			
			             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			             InitHeaders(headers, info);
			
			             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			                 {Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
			                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_yd_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
			                 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"csr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			                 {Type:"AutoSum",   Hidden:0, Width:150,  Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_incm_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			                 {Type:"AutoSum",   Hidden:0, Width:150,  Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_expn_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			                 {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_no" },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_seq" },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_inv_tp_cd" },
			                 {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"inv_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			                 {Type:"Text",      Hidden:1, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"dpc_val_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ar_chk_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_plc_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			                 {Type:"Text",      Hidden:1, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_bil_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cr_end_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:1, Width:130,  Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_bil_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			              
			             InitColumns(cols);
			             SetEditable(1);
			             SetSheetHeight(130);
			             SetCountPosition(0);
                      }
                break;
            case "t5sheet1":
                with(sheetObj){
                
			             var HeadTitle1="|Sel.|Seq.|EQ Type|EQ No.|TP/SZ|Term|Yard|DV.Value|Club Ref No|CURR|Insurance Co.|Request AMT|Notification Date|Remark(s)";
			             var headCount=ComCountHeadTitle(HeadTitle1);
//			             (headCount + 5, 0, 0, true);			
			             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );			
			             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			             InitHeaders(headers, info);			
			             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			                 {Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
			                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_yd_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
			                 {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"dpc_val_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			                 {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"inv_no",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			                 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_plc_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"AutoSum",   Hidden:0, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_expn_amt",  KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			                 {Type:"PopupEdit", Hidden:0, Width:115,  Align:"Center",  ColMerge:1,   SaveName:"cr_end_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_no" },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_seq" },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_inv_tp_cd" },
			                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"csr_no" },
			                 {Type:"Text",      Hidden:1, Width:130,  Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_bil_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			              
			             InitColumns(cols);
			             SetEditable(1);
			             SetSheetHeight(130);
			             SetColHidden("dpc_val_amt",1);
			             SetShowButtonImage(2);
			             SetCountPosition(0);
             }
            break;
			case "sheet3":
			    with(sheetObj){		        
					      var HeadTitle1="|Sel.|Date|Remark(s)|Creation Office|Creation User";
					      var headCount=ComCountHeadTitle(HeadTitle1);
//					      (headCount + 3, 0, 0, true);			
					      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );			
					      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					      InitHeaders(headers, info);			
					      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mnr_sts_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:"mnr_sts_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rqst_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_sts_ref_no" },
					             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_sts_dtl_seq" },
					             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_grp_tp_cd" } ];
					       
					      InitColumns(cols);
					      SetEditable(1);
					      SetSheetHeight(130);
					      SetShowButtonImage(2);
					      SetCountPosition(0);
		      }
             break;
			case "sheet4":
			      with(sheetObj){
		            	var prefix="";
				         var HeadTitle1="|Evidence Attachment|Evidence Attachment|Evidence Attachment";
				         var HeadTitle2="|Sel|File|Download";
				         var headCount=ComCountHeadTitle(HeadTitle1);			
				         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );			
				         var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				         var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
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
				         SetEditable(1);
				         SetSheetHeight(130);
				         SetImageList(0,"img/ico_attach.gif");
				         SetShowButtonImage(1);
				         SetCountPosition(0);
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
						InsertItem( "D.V Expense", "");
						InsertItem( "3rd Party", "");
						InsertItem( "Disposal", "");
                    //InsertTab( cnt++ , "Scrapping", -1 );
                    //InsertTab( cnt++ , "Insurance", -1 );
                }
                break;
         }
    }
	/**
	 * Defining event. <br>
	 **/
	function initControl() {
	    axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form);
	    //axon_event.addListenerFormat('focus',  		'obj_focus',    document.form);
	    //axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);
	    axon_event.addListenerFormat('change',	 	'obj_change',	document.form);
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

	function setPopUpParam_Sheet2_COM_ENS_071(array) {
		if(array == null)return;
		var formObj=document.form;
		var str=array + "";
		var arr=str.split(",");
	    var Row=sheetObjects[1].FindText("ttl_lss_no", formObj.search_ttl_lss_no.value);
		sheetObjects[1].SetCellValue(Row,"respb_ofc_cd",arr[3],0);
		if(MnrNullToBlank(ComGetObjValue(formObj.ttl_lss_no)) != ""){
			formObj.respb_ofc_cd.value=arr[3];
			formObj.respb_ofc_nm.value=arr[4];
		}
	}
	function setPopUpParam_COM_ENS_071(array) {
		if(array == null)return;
		var formObj=document.form;
		var str=array + "";
		var arr=str.split(",");
		formObj.respb_ofc_cd.value=arr[3];
		formObj.respb_ofc_nm.value=arr[4];
	    var Row=sheetObjects[1].FindText("ttl_lss_no", formObj.search_ttl_lss_no.value);
		sheetObjects[1].SetCellValue(Row,"respb_ofc_cd",formObj.respb_ofc_cd.value,0);
	}
	/**
     * Onblur event handling <br>
     **/
    function obj_blur(){
		ComChkObjValid(ComGetEvent());
	}
	/**
     * OnFocus event handling <br>
     **/
    function obj_focus(){
		ComClearSeparator(ComGetEvent());
    }
	/**
	 * OnKeypress event handling <br>
	 **/
//	function obj_keypress(){
//		obj=ComGetEvent();
//	    if(obj.dataformat == null) return;
//	    window.defaultStatus=obj.dataformat;
//		switch(obj.dataformat) {
//			case "ymd":
//				ComKeyOnlyNumber(ComGetEvent());
//				break;
//			case "engup":
//	         	if(obj.name == "in_ttl_lss_no"){
//					ComKeyOnlyAlphabet('uppernum','45|44');
//				} else {
//					ComKeyOnlyAlphabet('uppernum');
//				}
//	            break;
//	    }
//	}
	/**
	 * OnChange event handling <br>
	 **/
	function obj_change()
	{
		ComChkObjValid(ComGetEvent());
		var obj=ComGetEvent();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" )
		{
			switch(ComGetEvent("name"))
			{
			case "respb_ofc_cd":
				if(nowLoad != 0) return;
				respb_ofc_cd_Check();
				break;
			}
		}
	}
    /**
     * Event handling of OnLoadFinish of t1sheet1
     *
     * @param {Sheet}sheetObj Used sheet object
     */
    //no support[check again]CLT function t1sheet1_OnLoadFinish(sheetObj) {
//	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 0);
//    }
    /**
     * Event handling of changing tab
     * Activating tab for selected
     */
    function tab1_OnChange(tabObj , nItem) {
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	for(var i = 0; i<objs.length; i++){
		       if(i != nItem){
		        objs[i].style.display="none";
		        objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
		       }
		      }
    	beforetab=nItem;
		if(nowLoad!=1)
		{
			setCalculateTotalSum();
		}
    }
	/**
	 * Event handling of OnSearchEnd of sheet1
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj=document.form;
		//Setting value of header
		var ttlLssNo=sheetObj.GetCellValue(sheetObj.HeaderRows(), "ttl_lss_no");			//REQ OFC
		var rqstOfcCd=sheetObj.GetCellValue(sheetObj.HeaderRows(), "rqst_ofc_cd");			//REQ OFC
		var respbOfcCd=sheetObj.GetCellValue(sheetObj.HeaderRows(), "respb_ofc_cd");			//Responsible\nOFC
		var respbOfcNm=sheetObj.GetCellValue(sheetObj.HeaderRows(), "respb_ofc_nm");          //Responsible\nOFC NM
		var rqstDt=sheetObj.GetCellValue(sheetObj.HeaderRows(), "rqst_dt"); 				//REQ DT
		var ttlLssStsCd=sheetObj.GetCellValue(sheetObj.HeaderRows(), "ttl_lss_sts_cd");		//Status
		var ttlLssRsnCd=sheetObj.GetCellValue(sheetObj.HeaderRows(), "ttl_lss_rsn_cd");		//Main Reason
		var ttlLssDtlRsnCd=sheetObj.GetCellValue(sheetObj.HeaderRows(), "ttl_lss_dtl_rsn_cd");	//Sub Reason
		var ttlLssDt=sheetObj.GetCellValue(sheetObj.HeaderRows(), "ttl_lss_dt");			//TLL DT
		var aproOfcCd=sheetObj.GetCellValue(sheetObj.HeaderRows(), "apro_ofc_cd");			//APP OFC
		var fileSeq=sheetObj.GetCellValue(sheetObj.HeaderRows(), "file_seq");				//File Seq
		var mnrStsRefNo=sheetObj.GetCellValue(sheetObj.HeaderRows(), "mnr_sts_ref_no");		//mnr_sts_ref_no
		formObj.ttl_lss_no.value=ttlLssNo;			//TLL NO
		formObj.respb_ofc_cd.value=respbOfcCd;		//Responsible\nOFC
		formObj.respb_ofc_nm.value=respbOfcNm;		//Responsible\nOFC NM
		formObj.rqst_ofc_cd.value=rqstOfcCd;		//REQ OFC
		formObj.rqst_dt.value=rqstDt; 			//REQ DT
		formObj.ttl_lss_sts_cd.value=ttlLssStsCd; 		//Status
		formObj.ttl_lss_rsn_cd.value=ttlLssRsnCd; 		//Main Reason
		formObj.ttl_lss_dtl_rsn_cd.value=ttlLssDtlRsnCd;	//Sub Reason
		formObj.ttl_lss_dt.value=ttlLssDt;			//TLL DT
		formObj.apro_ofc_cd.value=aproOfcCd;		//APP OFC
		formObj.mnr_sts_ref_no.value=mnrStsRefNo;   	    //History key
		if(fileSeq != "" && fileSeq != null){
			var fileXml=SearchFileUpload(sheetObjects[1],fileSeq);
			if(!MnrIsEmptyXml(fileXml)){
				sheetObjects[8].LoadSearchData(fileXml,{Sync:1} );
			}
		}
		//Retrieving history list
		if(mnrStsRefNo != "" && mnrStsRefNo != null){
			historyMnrStsRefNo=mnrStsRefNo;
			var sXml=MnrStatusHistorySearch(sheetObjects[7], mnrStsRefNo);
			sheetObjects[7].LoadSearchData(sXml,{Sync:1} );
		}
		MnrWaitControl(false);
	}
	/**
	 * Header Retrieving
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		MnrWaitControl(false);
	}
	/**
	 * Event handling of OnSearchEnd of t1sheet1
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateTotalSum();
		 sheetObj.SetSumValue("eq_knd_cd", "Total");
		 for(var i=sheetObj.HeaderRows(); i < sheetObj.LastRow(); i++){
			 if(sheetObj.GetCellValue(i, "lstm_cd") == "OW"){
				 sheetObj.SetCellEditable(i, "inv_no", 0);
				 sheetObj.SetCellEditable(i, "payer_code", 0);
			 }
		 }
	}
	/**
	 * Event handling of OnSearchEnd of t2sheet1
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateTotalSum();
		 sheetObj.SetSumValue("eq_knd_cd", "Total");
	 }
	/**
	 * Event handling of OnSearchEnd of t3sheet1
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateTotalSum();
		 sheetObj.SetSumValue("eq_knd_cd", "Total");
	}
	/**
	 * Event handling of OnSearchEnd of t4sheet1
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function t4sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateTotalSum();
		 sheetObj.SetSumValue("eq_knd_cd", "Total");
	}
	/**
	 * Event handling of OnSearchEnd of t5sheet1
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function t5sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateTotalSum();
		 sheetObj.SetSumValue("eq_knd_cd", "Total");
	}
	/**
	 * Event handling of OnPopupClick of t1sheet1
	 * Calling pop-up of Payer Code, Responsible, OFC
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function t1sheet1_OnPopupClick(sheetObj, Row,Col){
		var colname=sheetObj.ColSaveName(Col);
		if(colname=="payer_code")
		{
			//service provider
			ComOpenPopup("/opuscntr/COM_ENS_0C1.do", 700, 450, 't1SetServiceProvider', '1,0', true);
		}
	}
	/**
	 * Event handling of OnPopupClick of t2sheet1
	 * Calling pop-up of Payer Code, Responsible, OFC
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function t2sheet1_OnPopupClick(sheetObj, Row,Col){
		if (sheetObj.ColSaveName(Col) == "ttl_lss_bil_dt"){
			var cal=new ComCalendarGrid();
        	cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
		} else {
			var ttlLssN3ptyTpCd=sheetObj.GetCellValue(Row, "ttl_lss_n3pty_tp_cd");
			//service provider
			if(ttlLssN3ptyTpCd == "S") {
				ComOpenPopup("/opuscntr/COM_ENS_0C1.do", 700, 450, 't2SetServiceProvider', '1,0', true);
			//coustomer
			} else if(ttlLssN3ptyTpCd == "C") {
				ComOpenPopup("/opuscntr/COM_ENS_041.do", 770, 520, 'setCustomer', '1,0', true);
			//office
			} else if(ttlLssN3ptyTpCd == "O") {
				ComOpenPopup("/opuscntr/COM_ENS_071.do", 770, 450, 'setCOM_ENS_071', '1,0', true);
			}
		}
	}
	/**
	 * Event handling of OnSelectCell of t2sheet1
	 * Calling pop-up of Payer Code
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function t2sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
		var ttlLssN3ptyTpCd=sheetObj.GetCellValue(NewRow, "ttl_lss_n3pty_tp_cd");
		//service provider
		if(ttlLssN3ptyTpCd == "O") {
			sheetObj.SetCellEditable(NewRow, "payer_code",0);
			sheetObj.SetCellEditable(NewRow, "respb_ofc_cd",1);
		}else if(ttlLssN3ptyTpCd == "N") {
			sheetObj.SetCellEditable(NewRow, "payer_code",0);
			sheetObj.SetCellEditable(NewRow, "respb_ofc_cd",0);
		}else{
			sheetObj.SetCellEditable(NewRow, "payer_code",1);
			sheetObj.SetCellEditable(NewRow, "respb_ofc_cd",0);
		}
	}
	/**
	 * Event handling of OnSelectCell of t3sheet1
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function t3sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
		var ttlLssBilAmt=sheetObj.GetCellValue(NewRow, "ttl_lss_bil_amt");
		//service provider
		if(ttlLssBilAmt == "" || ttlLssBilAmt == "0") {
			sheetObj.SetCellEditable(NewRow, "ttl_lss_incm_amt",1);
		}else{
			sheetObj.SetCellEditable(NewRow, "ttl_lss_incm_amt",0);
		}
	}
	/**
	 * Event handling of OnChange of t1sheet1
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t1sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname=ColSaveName(Col);
 			//EQ Type
			if(colname == 'eq_knd_cd') {
				sheetObj.SetCellValue(Row,"rqst_eq_no","",0);
				sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);
			}
			//EQ No
			else if(colname == 'rqst_eq_no') {
				setEqNoInfo(sheetObj,Row,Col);
			}
			//Yard Cd
		 	else if(colname == 'ttl_lss_yd_cd') {
				if(!ttl_lss_yd_cd_Check(Value))
				{
					ComShowCodeMessage("MNR00165",Value,"YARD");
					sheetObj.SetCellValue(Row,Col,"",0);
					sheetObj.SelectCell(Row,Col);
				}
		 	}
			//Pay Amount
			else if(colname == 'ttl_lss_bil_amt') {
				setCalculateTotalSum();
			}
		}
	}
	/**
	 * Event handling of OnChange of t2sheet1
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t2sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname=ColSaveName(Col);
 			//EQ Type
			if(colname == 'eq_knd_cd') {
				sheetObj.SetCellValue(Row,"rqst_eq_no","");
				sheetObj.SetCellValue(Row,"eq_tpsz_cd","");
			}
			//EQ No
			else if(colname == 'rqst_eq_no') {
				var chkRow=sheetObj.ColValueDup("rqst_eq_no");
				if(chkRow > 0 && sheetObj.GetRowStatus(chkRow) != "D"){
					ComShowCodeMessage("MNR00006",sheetObj.GetCellValue(Row,"rqst_eq_no"));
					sheetObj.SetCellValue(Row, "rqst_eq_no","",0);
					sheetObj.SelectCell(Row, "rqst_eq_no", true);
					return false;
				} else {
					var chkFlag=false;
					for(var j=sheetObjects[2].HeaderRows(); j <= sheetObjects[2].LastRow(); j++) {
						if(sheetObjects[2].GetRowStatus(j) != "D" && (sheetObjects[2].GetCellValue(j,"rqst_eq_no") == sheetObj.GetCellValue(Row,"rqst_eq_no"))){
							chkFlag=true;
						}
					}
					if(!chkFlag){
						ComShowCodeMessage("MNR00339");
						sheetObj.SetCellValue(Row, "rqst_eq_no","",0);
						sheetObj.SelectCell(Row, "rqst_eq_no", true);
						return false;
					}
				}
				setEqNoInfo(sheetObj,Row,Col);
			}
			//RES_OFC
			else if(colname == 'respb_ofc_cd') {
				setOfficeInfo(sheetObj,Row, Col, Value);
			}
			//Yard Cd
		 	else if(colname == 'ttl_lss_yd_cd') {
				if(!ttl_lss_yd_cd_Check(Value))
				{
					ComShowCodeMessage("MNR00165",Value,"YARD");
					sheetObj.SetCellValue(Row,Col,"",0);
					sheetObj.SelectCell(Row,Col);
				}
		 	}
			//Payer Type
			else if(colname=='ttl_lss_n3pty_tp_cd'){
				var payerCode=sheetObj.GetCellValue(Row, "payer_code");
				if(payerCode != '') {
					if(!ComShowCodeConfirm("MNR00192")) {
						sheetObj.ReturnCellData(Row,Col);
					    return;
					}
					sheetObj.SetCellValue(Row, "payer_code","");
					sheetObj.SetCellValue(Row, "payer_name","");
				}
				if(Value=="O")
				{
					sheetObj.SetCellValue(Row, "payer_code","");
					sheetObj.SetCellValue(Row, "payer_name","");
					sheetObj.SetCellEditable(Row, "payer_code",0);
				}else if(Value=="N") {
					sheetObj.SetCellValue(Row, "payer_code","");
					sheetObj.SetCellValue(Row, "payer_name","");
					sheetObj.SetCellEditable(Row, "payer_code",0);
				}else{
					sheetObj.SetCellValue(Row, "payer_code","");
					sheetObj.SetCellValue(Row, "payer_name","");
					sheetObj.SetCellEditable(Row, "payer_code",1);
				}
			}
			//Pay Amount
			else if(colname == 'ttl_lss_bil_amt') {
				setCalculateTotalSum();
			}
		}
	}
	/**
	 * Event handling of OnChange of t3sheet1
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t3sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname=ColSaveName(Col);
 			//EQ Type
			if(colname == 'eq_knd_cd') {
				sheetObj.SetCellValue(Row,"rqst_eq_no","",0);
				sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);
			}
			//EQ No
			else if(colname == 'rqst_eq_no') {
				setEqNoInfo(sheetObj,Row,Col);
			}
			//Yard Cd
		 	else if(colname == 'ttl_lss_yd_cd') {
				if(!ttl_lss_yd_cd_Check(Value))
				{
					ComShowCodeMessage("MNR00165",Value,"YARD");
					sheetObj.SetCellValue(Row,Col,"",0);
					sheetObj.SelectCell(Row,Col);
				}
		 	}
			//Disposal Amt
			else if(colname == 'ttl_lss_bil_amt') {
				setCalculateTotalSum();
			}
			//Disposal Plan Amt
			else if(colname == 'ttl_lss_incm_amt') {
				setCalculateTotalSum();
			}
		}
	}
	/**
	 * Event handling of OnChange of t4sheet1
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t4sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname=ColSaveName(Col);
 			//EQ Type
			if(colname == 'eq_knd_cd') {
				sheetObj.SetCellValue(Row,"rqst_eq_no","",0);
				sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);
			}
			//EQ No
			else if(colname == 'rqst_eq_no') {
				setEqNoInfo(sheetObj,Row,Col);
			}
			//Yard Cd
		 	else if(colname == 'ttl_lss_yd_cd') {
				if(!ttl_lss_yd_cd_Check(Value))
				{
					ComShowCodeMessage("MNR00165",Value,"YARD");
					sheetObj.SetCellValue(Row,Col,"",0);
					sheetObj.SelectCell(Row,Col);
				}
		 	}
			//Scrapping Income AMT
			else if(colname == 'ttl_lss_incm_amt') {
				setCalculateTotalSum();
			}
			//Scrapping Cost AMT
			else if(colname == 'ttl_lss_expn_amt') {
				setCalculateTotalSum();
			}
		}
	}
	/**
	 * Event handling of OnChange of t5sheet1
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t5sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname=ColSaveName(Col);
 			//EQ Type
			if(colname == 'eq_knd_cd') {
				sheetObj.SetCellValue(Row,"rqst_eq_no","",0);
				sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);
			}
			//EQ No
			else if(colname == 'rqst_eq_no') {
				setEqNoInfo(sheetObj,Row,Col);
			}
			//Yard Cd
		 	else if(colname == 'ttl_lss_yd_cd') {
				if(!ttl_lss_yd_cd_Check(Value))
				{
					ComShowCodeMessage("MNR00165",Value,"YARD");
					sheetObj.SetCellValue(Row,Col,"",0);
					sheetObj.SelectCell(Row,Col);
				}
		 	}
			//Request AMT
			else if(colname == 'ttl_lss_expn_amt') {
				setCalculateTotalSum();
			}
		}
	}
	/**
	 * Event handling of OnPopupClick of t5sheet1
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
    function t5sheet1_OnPopupClick(sheetObj, Row,Col,Value){
		 var formObject=document.form;
		   with(sheetObj) {
				var sName=ColSaveName(Col);
	        	switch (sName) {
					case "cr_end_dt":
					 var cal=new ComCalendarGrid("myCal");
				      cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
					break;
				}
	 		}
	}
	/**
	 *  Event handling of OnDblClick of sheet2
	 *
	 * @param {IBSheet}	sheetObj
	 * @param {Int} 	Row
	 * @param {String} 	Col
	 * @return
	 */
	function sheet2_OnDblClick(sheetObj,Row,Col)
    {
		MnrWaitControl(true);
		var formObj=document.form;
		with(sheetObj){
		formObj.search_ttl_lss_no.value=GetCellValue(Row,"ttl_lss_no");			//TLL NO
		formObj.ttl_lss_no.value=GetCellValue(Row,"ttl_lss_no");			//TLL NO
		formObj.ttl_lss_no_text.value=GetCellValue(Row,"ttl_lss_no");			//TLL NO
		formObj.rqst_ofc_cd.value=GetCellValue(Row,"rqst_ofc_cd");			//REQ OFC
			formObj.rqst_ofc_cd_nm.value=GetCellText(Row,"rqst_ofc_cd");			//REQ OFC
			formObj.rqst_dt.value=GetCellValue(Row,"rqst_dt"); 			//REQ DT
			var rqstDt=GetCellValue(Row,"rqst_dt");
			if(rqstDt.length>=8)
			{
				rqstDt=rqstDt.substring(0,4)+ "-" + rqstDt.substring(4,6)+ "-" + rqstDt.substring(6,8);
			}else{
				rqstDt="";
			}
			formObj.rqst_dt_text.value=rqstDt; 			//REQ DT
			formObj.ttl_lss_sts_cd.value=GetCellValue(Row,"ttl_lss_sts_cd");  	//Status
			formObj.ttl_lss_sts_cd_nm.value=GetCellText(Row,"ttl_lss_sts_cd");  	//Status
			formObj.ttl_lss_rsn_cd.value=GetCellValue(Row,"ttl_lss_rsn_cd");  	//Main Reason
			formObj.ttl_lss_rsn_cd_nm.value=GetCellText(Row,"ttl_lss_rsn_cd");  	//Main Reason
			formObj.ttl_lss_dtl_rsn_cd.value=GetCellValue(Row,"ttl_lss_dtl_rsn_cd");	//Sub Reason
			formObj.ttl_lss_dtl_rsn_cd_nm.value=GetCellText(Row,"ttl_lss_dtl_rsn_nm");	//Sub Reason
			formObj.ttl_lss_dt.readOnly=false;
			formObj.ttl_lss_dt.className="input";
			formObj.ttl_lss_dt.value=GetCellValue(Row,"ttl_lss_dt"); 			//TLL DT
			formObj.apro_ofc_cd.value=GetCellValue(Row,"apro_ofc_cd"); 		//APP OFC
			formObj.apro_ofc_cd_nm.value=GetCellText(Row,"apro_ofc_cd"); 		//APP OFC
			formObj.mnr_sts_ref_no.value=GetCellValue(Row,"mnr_sts_ref_no");   	//History key
			formObj.respb_ofc_cd.value=GetCellValue(Row,"respb_ofc_cd");   	//Responsible\nOFC
			uploadFileSeq=GetCellValue(Row,"file_seq");
			formObj.file_seq.value=GetCellValue(Row,"file_seq");   	//Responsible\nOFC
			if(MnrNullToBlank(formObj.search_ttl_lss_no.value) != ""){
				tabObjects[0].SetSelectedIndex(0);
				formObj.respb_ofc_cd.readOnly=false;
				formObj.respb_ofc_cd.className="input";
				formObj.ttl_lss_iss_dt.readOnly=false;
				formObj.ttl_lss_iss_dt.className="input";
				var toDay=ComGetNowInfo("ymd");
				ComSetObjValue(formObj.ttl_lss_iss_dt,toDay);
				doActionIBSheet(sheetObjects[0],formObj,IBROWSEARCH);
			}
			return;
		}
    }
	/**
	 * Event handling of OnChange of sheet2
	 *
	 * @param {IBSheet}	sheetObj
	 * @param {Int} 	Row
	 * @param {String} 	Col
	 * @return
	 */
	function sheet2_OnChange(sheetObj,Row, Col,Value)
    {
		if(nowLoad==1)
		{
			if(sheetObj.ColSaveName(Col)=="respb_ofc_cd")
			{
				nowLoad=0;
				sheetObj.SelectCell(Row, "respb_ofc_cd", true);
			}
		}else{
			nowLoad=1;
			var formObj=document.form;
			with(sheetObj){
				if(ColSaveName(Col)=="respb_ofc_cd")
				{
					if(GetCellValue(Row,"respb_ofc_cd")=="")return;
					var retArray=null;
					retArray=MnrGeneralCodeCheck(sheetObj,"OFC",GetCellValue(Row,"respb_ofc_cd"));
					if(retArray == null){
						ComShowCodeMessage("MNR00165",GetCellValue(Row,"respb_ofc_cd"),"OFFICE");
						SelectCell(Row, "respb_ofc_cd", true);
						SetCellValue(Row,"respb_ofc_cd","",0);
						formObj.respb_ofc_cd.value="";
						formObj.respb_ofc_nm.value="";
					} else {
						var retArray=retArray[0].split("|");
						if(MnrNullToBlank(ComGetObjValue(formObj.ttl_lss_no)) != "")
						{
							formObj.respb_ofc_cd.value=retArray[0];
							formObj.respb_ofc_nm.value=retArray[1];
						}
					}
					var sheetObj=sheetObjects[3];
					for(var i=sheetObj.HeaderRows();i<=sheetObj.LastRow();i++)
					{
						if(sheetObj.GetCellValue( i,"ttl_lss_n3pty_tp_cd")=="O")
						{
							sheetObj.SetCellValue( i,"payer_code",formObj.respb_ofc_cd.value);
							sheetObj.SetCellValue( i,"payer_name",formObj.respb_ofc_nm.value);
						}
					}
				}
			}
		}
		nowLoad=0;
    }
	/**
	 * Event handling of OnPopupClick of sheet2
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function sheet2_OnPopupClick(sheetObj,Row,Col){
        if (sheetObj.ColSaveName(Col) != "respb_ofc_cd") return;
        ComOpenPopup("COM_ENS_071.do", 810, 415, 'setPopUpParam_Sheet2_COM_ENS_071', '0,1', true);
	}
	/**
	 * Event handling of OnPopupClick of sheet3
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function sheet3_OnPopupClick(sheetObj,Row,Col){
        if (sheetObj.ColSaveName(Col) != "mnr_sts_dt") return;
        var cal=new ComCalendarGrid();
        cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
	}
	/**
	 * Showing result message after saving
	 * @param	{IBSheet}	sheetObj	target object
	 * @param	{String}	ErrMsg
	 */
	function sheet1_OnSaveEnd(sheetObj,ErrMsg)
	{
		var formObj=document.form;
		if (ErrMsg == "")
		{
			var Row=sheetObjects[1].FindText("ttl_lss_no", formObj.search_ttl_lss_no.value);
			if(actionType == "REJECT")
			{
				ComShowCodeMessage("MNR00291", actionType);
				sheetObjects[1].RowDelete(Row,false);
		    	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 8);
			}else if(actionType == "CONFIRM")
			{
				ComOpenWait(false,true);
				ComShowCodeMessage("MNR00292", actionType);
				sheetObjects[1].RowDelete(Row,false);
		    	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 8);
			}else{
				ComShowCodeMessage("MNR00154", actionType);
			    //Initializing form value
				formObj.rqst_ofc_cd.value="";
				formObj.rqst_dt.value="";
				formObj.ttl_lss_sts_cd.value="";
				formObj.ttl_lss_rsn_cd.value="";
				formObj.ttl_lss_dtl_rsn_cd.value="";
				formObj.ttl_lss_dt.value="";
				formObj.apro_ofc_cd.value="";
				formObj.ttl_lss_no.value="";
				formObj.mnr_sts_ref_no.value="";
				// Initializing all sheet
	    		for (i=2; i < sheetObjects.length; i++) {
	    			sheetObjects[i].RemoveAll();
	    		}
			}
		}
		ComOpenWait(false,true);
	}
	//Responsible\nOFC Check
	function respb_ofc_cd_Check(){
		nowLoad=1;
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		if(ComTrimAll(formObj.respb_ofc_cd.value," ")!="")
		{
			var retArray=MnrGeneralCodeCheck(sheetObj,"OFC",formObj.respb_ofc_cd.value);
		    var Row=sheetObjects[1].FindText("ttl_lss_no", formObj.search_ttl_lss_no.value);
			if(retArray == null){
				ComShowCodeMessage("MNR00165",formObj.respb_ofc_cd.value,"OFFICE");
				sheetObjects[1].SetCellValue(Row,"respb_ofc_cd","",0);
				formObj.respb_ofc_cd.value="";
				formObj.respb_ofc_nm.value="";
				ComSetFocus(formObj.respb_ofc_cd);
				nowLoad=0;
				return false;
			} else {
				var retArray=retArray[0].split("|");
				sheetObjects[1].SetCellValue(Row,"respb_ofc_cd",retArray[0],0);
				if(MnrNullToBlank(ComGetObjValue(formObj.ttl_lss_no)) != "")
				{
					formObj.respb_ofc_cd.value=retArray[0];
					formObj.respb_ofc_nm.value=retArray[1];
				}
			}
		}
		nowLoad=0;
		return true;
	}
	//YARD Check
	function ttl_lss_yd_cd_Check(checkYard){
		retArray=MnrGeneralCodeCheck(sheetObjects[0],"YARD",checkYard);
		if(retArray == null){
			return false;
		} else {
			return true;
		}
	}
    /**
     * Sheet related process processing
     *
     * @param {IBSheet}sheetObj Used sheet object
     * @param {Form}formObj Used form object
     * @param {Number}sAction Variable for diverge (Define from CoObject.js)
     */
    function doActionIBSheet(sheetObj,formObj,sAction,sActionIdx) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
	    	// Initializing
	    	case IBCLEAR:
	    		sheetObj.SetWaitImageVisible(0);
	    		MnrWaitControl(true);
	    		// Initializing all sheet
	    		for (i=0; i < sheetObjects.length; i++) {
	    			if(sActionIdx==8)
	    			{
		    			if(i==0 || i==1) continue
	    			}
	    			sheetObjects[i].RemoveAll();
	    		}
	    		var select_tp = "";
	    		if(sActionIdx==8){
	    			select_tp = in_search_dt_tp.GetSelectCode();
	    		}
	    		formObj.reset();
    			if(sActionIdx!=8)
    			{
		    		in_search_dt_tp.RemoveAll();
					in_search_dt_tp.SetEditFontBold(1);
					in_search_dt_tp.InsertItem(0, "Request DT","R");
					in_search_dt_tp.InsertItem(1, "TLL DT","T");
					in_search_dt_tp.SetSelectCode("R",false);
    			}else{
    				in_search_dt_tp.SetSelectCode(select_tp, false);
    			}
				setSheetCombo(sheetObj);
				
				//Value setting of initialize
				if(sActionIdx!=8)
				{
					formObj.in_ttl_lss_no.value="";
					formObj.ttl_lss_no.value="";  					//TLL No
				}
				//total AMTInitializing
//				for(var i=1;i<=5;i++)
//				{
//					eval("document.form.t"+ i + "LossTotal.value='';");
//					eval("document.form.t"+ i + "RecPlnTotal.value='';");
//					eval("document.form.t"+ i + "BalanceTotal.value='';");
//				}
				var toDay=ComGetNowInfo("ymd");
				formObj.respb_ofc_cd.readOnly=true;
				formObj.respb_ofc_cd.className="input2";
				formObj.ttl_lss_iss_dt.readOnly=true;
				formObj.ttl_lss_iss_dt.className="input2";
				formObj.ttl_lss_dt.readOnly=true;
				formObj.ttl_lss_dt.className="input2";
				//Value setting of initialize
				var threeBeforeMonth=ComGetDateAdd(toDay, "M", -3);
				ComSetObjValue(formObj.in_st_dt,threeBeforeMonth);
				ComSetObjValue(formObj.in_end_dt,toDay);
				uploadFileSeq="";
				historyMnrStsRefNo="";
	    		MnrWaitControl(false);
	    		sheetObj.SetWaitImageVisible(1);
	        	nowLoad=0;
	    		break;
	    	//Header Retrieving
            case IBSEARCH:
                if(validateForm(sheetObj,formObj,sAction)) {
                	MnrWaitControl(true);
    				formObj.f_cmd.value=SEARCH01;
    	    		// Initializing all sheet
    	    		for (i=2; i < sheetObjects.length; i++) {
    	    			sheetObjects[i].RemoveAll();
    	    		}
    				formObj.search_ttl_lss_no.value="";   //TLL NO
    				formObj.ttl_lss_no.value="";   //TLL NO
    				formObj.ttl_lss_no_text.value="";	//TLL NO
    				formObj.rqst_ofc_cd_nm.value="";	//REQ OFC
    				formObj.rqst_dt_text.value=""; 	//REQ DT
    				formObj.ttl_lss_sts_cd_nm.value="";  	//Status
    				formObj.ttl_lss_rsn_cd_nm.value="";  	//Main Reason
    				formObj.ttl_lss_dtl_rsn_cd_nm.value="";	//Sub Reason
					formObj.ttl_lss_dt.value=""; 	//TLL DT
    				formObj.ttl_lss_dt.readOnly=true;
    				formObj.ttl_lss_dt.className="input2";
    				formObj.apro_ofc_cd_nm.value=""; 	//APP OFC
    				formObj.respb_ofc_cd.value="";   //Responsible\nOFC
    				formObj.respb_ofc_cd.readOnly=true;
    				formObj.respb_ofc_cd.className="input2";
					formObj.ttl_lss_iss_dt.value="";   //Issue Date
    				formObj.ttl_lss_iss_dt.readOnly=true;
    				formObj.ttl_lss_iss_dt.className="input2";
					sParam=FormQueryString(formObj);
					var sXml=sheetObj.GetSaveData("EES_MNR_0098GS.do", sParam);
				    sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
	            }
                break;
        	//Detail Retrieving
            case IBROWSEARCH:
                if(validateForm(sheetObj,formObj,sAction)) {
    	    		// Initializing all sheet
    	    		for (i=2; i < sheetObjects.length; i++) {
    	    			sheetObjects[i].RemoveAll();
    	    		}
    				formObj.f_cmd.value=SEARCH;
					//Retrieving multi data
    				var sXml=sheetObj.GetSearchData("EES_MNR_0096GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
					for(var i=0; i < arrXml.length; i++){
						if(i == 0){
							sheetObjects[0].LoadSearchData(arrXml[i],{Sync:1} );
						} else {
							sheetObjects[i + 1].LoadSearchData(arrXml[i],{Sync:1} );
						}
					}
	            }
                break;
            //Saving
            case IBSAVE:
    			if(nowLoad != 0) return;
    			nowLoad=1;
    			MnrWaitControl(true);
            	if(validateForm(sheetObj,formObj,sAction,sActionIdx)) {
            		formObj.f_cmd.value=MULTI;
					tabObjects[0].SetSelectedIndex(0);
					sActionIdx != 1
					var sParam1=sheetObjects[2].GetSaveString(true, true);
					if(sParam1=="" && sheetObjects[2].RowCount()> 0 )
					{
		    			MnrWaitControl(false);
						nowLoad=0;
						return;
					}
					tabObjects[0].SetSelectedIndex(1);
					var sParam2=sheetObjects[3].GetSaveString(true, true);
					if(sParam2=="" && sheetObjects[3].RowCount()> 0 )
					{
		    			MnrWaitControl(false);
						nowLoad=0;
						return;
					}
					tabObjects[0].SetSelectedIndex(2);
					var sParam3=sheetObjects[4].GetSaveString(true, true);
					if(sParam3=="" && sheetObjects[4].RowCount()> 0  )
					{
		    			MnrWaitControl(false);
						nowLoad=0;
						return;
					}
					tabObjects[0].SetSelectedIndex(3);
					var sParam4=sheetObjects[5].GetSaveString(true, true);
					if(sParam4=="" && sheetObjects[5].RowCount()> 0 )
					{
		    			MnrWaitControl(false);
						nowLoad=0;
						return;
					}
					if(sheetObjects[5].IsDataModified()){
						for(var i=sheetObjects[5].HeaderRows();i<=sheetObjects[5].LastRow();i++)
						{
							var checkValue1=ComTrimAll(sheetObjects[5].GetCellValue(i, "ttl_lss_incm_amt")," ");
							var checkValue2=ComTrimAll(sheetObjects[5].GetCellValue(i, "ttl_lss_expn_amt")," ");
							if(checkValue1=="" && checkValue2=="")
							{
				    			MnrWaitControl(false);
								ComShowCodeMessage("MNR00172","at least one item amoung Scrapping Income AMT or Scrapping Cost Amt");
								sheetObjects[5].SelectCell(i, "ttl_lss_incm_amt",true);
								nowLoad=0;
								return false;
							}
						}
					}
					tabObjects[0].SetSelectedIndex(4);
					var sParam5=sheetObjects[6].GetSaveString(true, true);
					if(sParam5=="" && sheetObjects[6].RowCount()> 0 )
					{
						nowLoad=0;
		    			MnrWaitControl(false);
						return;
					}
					// Total Loss History
					var sParam6=sheetObjects[7].GetSaveString(true, true);
					sParam6=ComSetPrifix(sParam6,"statusHistory_");
            		formObj.file_seq.value=uploadFileSeq;
					//Reject
					if(sActionIdx == 1) {
						actionType="REJECT";
						formObj.ttl_lss_sts_cd.value="HJ";
						setRowStausByRequest();  //Occurring saving event
					}
					//Confirm
					else if (sActionIdx == 2) {
						ComOpenWait(true,true);
						tabObjects[0].SetSelectedIndex(0);
						actionType="CONFIRM";
						formObj.ttl_lss_sts_cd.value="HA";
						setRowStausByRequest();  //Occurring saving event
					}
					var sParam=sParam1 +"&"+ sParam2 +"&"+ sParam3 +"&"+ sParam4 +"&"+ sParam5 +"&"+ sParam6;
				    if (sParam == "" && sActionIdx != 1)
				    {
						nowLoad=0;
						ComOpenWait(false,true);
		    			MnrWaitControl(false);
				    	return;
				    }
				    sParam += "&" + FormQueryString(formObj);
//					ComDebug(sParam);
				    sSaveRtnXml=sheetObj.GetSaveData("EES_MNR_0096GS.do", sParam);
				    sheetObj.LoadSaveData(sSaveRtnXml);
					tabObjects[0].SetSelectedIndex(0);
            	}
    			nowLoad=0;
    			MnrWaitControl(false);
                break;
			case IBINSERT:
				if(validateForm(sheetObj,formObj,sAction)) {
					var Row=sheetObj.DataInsert(-1);
					sheetObj.SetCellValue(Row, "ttl_lss_no",ComGetObjValue(formObj.ttl_lss_no),0);
					if(sheetObj.id == 't1sheet1') {
						sheetObj.SetCellValue(Row, "mnr_inv_tp_cd","DV",0);
						sheetObj.SetCellValue(Row, "ttl_lss_dtl_sts_cd","",0);
					} else if (sheetObj.id == 't2sheet1') {
						sheetObj.SetCellValue(Row, "mnr_inv_tp_cd","TP",0);
						sheetObj.SetCellValue(Row, "ttl_lss_dtl_sts_cd","",0);
					} else if (sheetObj.id == 't3sheet1') {
						sheetObj.SetCellValue(Row, "mnr_inv_tp_cd","DS",0);
					} else if (sheetObj.id == 't4sheet1') {
						sheetObj.SetCellValue(Row, "mnr_inv_tp_cd","SC",0);
					} else if (sheetObj.id == 't5sheet1') {
						sheetObj.SetCellValue(Row, "mnr_inv_tp_cd","IR",0);
						sheetObj.SetCellValue(Row, "ttl_lss_plc_nm","",0);
					}
					sheetObj.SetCellValue(Row, "curr_cd","USD",0);//CURR
				}
                break;
			case IBDELETE:
			    if(validateForm(sheetObj,formObj,sAction)) {
					if(sheetObj.id != "sheet3"){
						if(sheetObj.id=="t1sheet1")
						{
							var tabSheetIndex=2;
				 			for(var i=sheetObjects[tabSheetIndex].HeaderRows(); i<=sheetObjects[tabSheetIndex].LastRow(); i++)
							{
				 				if(sheetObjects[tabSheetIndex].GetCellValue(i,"del_chk")==1)
				 				{
				 					var rqstEqNo=sheetObjects[tabSheetIndex].GetCellValue(i,"rqst_eq_no")
				 					for(var j=tabSheetIndex+1; j<=tabSheetIndex+4;j++)
						 			{
					 					var row=sheetObjects[j].FindText("rqst_eq_no", rqstEqNo);
					 					if(row > 0)
					 					{
						 					sheetObjects[j].SetCellValue(row,"del_chk","1");
						 					ComRowHideDelete(sheetObjects[j], "del_chk");
					 					}
						 			}
				 				}
							}
				 			ComRowHideDelete(sheetObjects[tabSheetIndex], "del_chk");
						}else{
							ComRowHideDelete(sheetObj, "del_chk");
						}
					} else {
						MnrRowDelete(sheetObj,"del_chk")
					}
					setCalculateTotalSum();
				}
				break;
        }
    }
    /**
     * Validating process for input form data
     */
    function validateForm(sheetObj,formObj,sAction, sActionIdx){
        var formObj=document.form;
		with(formObj){
			if (sAction == IBINSERT) {
				var dvTabRowCnt = sheetObjects[2].RowCount - sheetObjects[2].RowCount("D");
				var chkTabRowCnt = sheetObj.RowCount - sheetObj.RowCount("D");
				if(dvTabRowCnt <= chkTabRowCnt){
					ComShowCodeMessage("MNR00339");
					return false;
				}
			}
    		else if (sAction == IBSEARCH) {
    			// Dataformat
    			if (!ComChkValid(formObj)) {
    				return false;
    			}
    		}
			//Saving(Reject,Confirm)
			else if(sAction == IBSAVE) {
				//responsible Office check
				if(!respb_ofc_cd_Check()) {return false;}
				if(MnrNullToBlank(ComGetObjValue(formObj.ttl_lss_no)) == ""){
					ComShowCodeMessage("MNR00261");
					return false;
				}
				//Mandatory
				if(!checkMandatory(formObj.ttl_lss_rsn_cd)) {return false;}
				if(!checkMandatory(formObj.ttl_lss_dtl_rsn_cd)) {return false;}
				//if(!checkMandatory(formObj.ttl_lss_dt)) {return false;}
				if(!checkMandatory(formObj.apro_ofc_cd)) {return false;}
				//Checking grid row data
				if(!checkIsDetailRow()) {return false;}
				for (var i=2; i<6; i++){
					var Row=sheetObjects[i].ColValueDup("rqst_eq_no" ,false);
					if(sheetObjects[i].IsDataModified()){
						if(Row>0){
							ComShowCodeMessage("MNR00006",i + "th sheet of " + Row + " row ");
							sheetObjects[i].SelectCell(Row, "rqst_eq_no", true);
							return false;
						}
					}
				}
				if(sActionIdx == 1) {
					if (!ComShowCodeConfirm("MNR00275","Total Loss", "Reject")){return false;}
				} else if(sActionIdx == 2){
					if(formObj.ttl_lss_dt.value=="")
					{
						ComShowCodeMessage("MNR00172","TLL DT");
						ComSetFocus(formObj.ttl_lss_dt);
						return false;
					}
					var checkValue=ComTrimAll(formObj.ttl_lss_iss_dt.value," ");
					if(checkValue=="")
					{
						ComShowCodeMessage("MNR00172","Issue Date");
						ComSetFocus(formObj.ttl_lss_iss_dt);
						return false;
					}
					var checkValue=checkValue.split("-").join("");
					if(checkValue.length != 8)
					{
						ComShowCodeMessage("MNR00015");
						ComSetFocus(formObj.ttl_lss_iss_dt);
						return false;
					}
					var toDate=ComGetNowInfo().split("-").join("");
					if(parseInt(checkValue) > parseInt(toDate))
					{
						ComShowCodeMessage("MNR00233","Issue Date");
						ComSetFocus(formObj.ttl_lss_iss_dt);
						return false;
					}
					var sheetObj=sheetObjects[2];
					for(var i=sheetObj.HeaderRows();i<=sheetObj.LastRow();i++)
					{
						if(sheetObj.GetCellValue(i,"lstm_cd") != "OW"){
							var checkValue=ComTrimAll(sheetObj.GetCellValue(i,"payer_code")," ");
							if(checkValue=="" && sheetObj.GetCellValue(i,"seq")!=0)
							{
								tabObjects[0].SetSelectedIndex(0);
								ComShowCodeMessage("MNR00036","Payer Code");
								sheetObj.SelectCell(i, "payer_code", true);
								return false;
							}
						}
						
					}
					if (!ComShowCodeConfirm("MNR00275","Total Loss", "Confirm")){return false;}
				}
			}
        }
        return true;
    }
 	/**
 	 * Loss Total : Pay amount sum of DV
 	 * Recovery Plan Total : 3rd Amount + Disposal Amount + Scrapping Income AMT
 	 *                        + Scrapping Cost AMT + Request AMT
 	 * Balance Total = Recovery Plan Total - Loss Tota
 	 */
 	function setCalculateTotalSum(){
 	    var tabIndex=tabObjects[0].GetSelectedIndex()+ 1;
 	    var calFlag=false;
         var sheetIndex=2;
 		for(var i=sheetIndex;i<sheetIndex + 5;i++)
 		{
 			if(sheetObjects[i].RowCount()>0)
 			{
 				calFlag=true;
 				break;
 			}
 		}
 		if(calFlag==true)
 		{
 		    var tLossTotal=0;
 		    var thrdAmtTotal=0;
 		    var disposalAmtTotal=0;
		    var disposalPlanAmtTotal=0;
 		    var scrapIncomeAmtTotal=0;
            var scrapCostAmtTotal=0;
            var requestAmtTotal=0;
            for(var i=sheetIndex;i<sheetIndex + 5;i++)
            {
			    if(sheetObjects[i].RowCount()>0)
			    {
					for(var j=sheetObjects[i].HeaderRows();j<=sheetObjects[i].LastRow();j++)
					{
						if(sheetObjects[i].GetCellValue(j,"ibflag")!="D" && sheetObjects[i].GetCellValue(j,"seq")!="0")
						{
							if(sheetObjects[i].GetCellValue(j,"mnr_inv_tp_cd")=="DV"){
							if(sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt")!="")
							tLossTotal=getFloatSumData(tLossTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt"));
							} else if(sheetObjects[i].GetCellValue(j,"mnr_inv_tp_cd")=="TP"){
							if(sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt")!="")
							thrdAmtTotal=getFloatSumData(thrdAmtTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt"));
							} else if(sheetObjects[i].GetCellValue(j,"mnr_inv_tp_cd")=="DS"){
							if(sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt")!="")
							disposalAmtTotal=getFloatSumData(disposalAmtTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt"));
							if(sheetObjects[i].GetCellValue(j,"ttl_lss_incm_amt")!="")
							disposalPlanAmtTotal=getFloatSumData(disposalPlanAmtTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_incm_amt"));
							} else if(sheetObjects[i].GetCellValue(j,"mnr_inv_tp_cd")=="SC"){
							if(sheetObjects[i].GetCellValue(j,"ttl_lss_incm_amt")!="")
							scrapIncomeAmtTotal=getFloatSumData(scrapIncomeAmtTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt"));
							if(sheetObjects[i].GetCellValue(j,"ttl_lss_expn_amt")!="")
							scrapCostAmtTotal=getFloatSumData(scrapCostAmtTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt"));
							} else if(sheetObjects[i].GetCellValue(j,"mnr_inv_tp_cd")=="IR"){
							if(sheetObjects[i].GetCellValue(j,"ttl_lss_expn_amt")!="")
							requestAmtTotal=getFloatSumData(requestAmtTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt"));
							}
						}
					}
			    }
            }
//            var tempStr=ComAddComma2((tLossTotal + ""), "#,###");
//			eval("document.form.t"+ tabIndex + "LossTotal.value=tempStr;");
//			//Recovery Plan Total(tRecPlnTotal) expressed as negative
//		    var tRecPlnTotal=parseFloat(MnrMakeRound(parseFloat((thrdAmtTotal+disposalAmtTotal+disposalPlanAmtTotal+scrapIncomeAmtTotal+scrapCostAmtTotal+requestAmtTotal)*(-1)),2));
//			tempStr=ComAddComma2((tRecPlnTotal + ""), "#,###");
//			eval("document.form.t"+ tabIndex + "RecPlnTotal.value=tempStr;");
//			//Balance Total(tBalanceTotal)
//		    var tBalanceTotal=getFloatSumData(tRecPlnTotal,tLossTotal);
//			tempStr=ComAddComma2((tBalanceTotal + ""), "#,###");
//			eval("document.form.t"+ tabIndex + "BalanceTotal.value=tempStr;");
 		}
 	}
    /* ********* User Functions ************* */
	/**
	 * @param a
	 * @param b
	 * @return sumResult
	 */
	function getFloatSumData(a,b){
		var aFloat=parseFloat(a + "");
		var bFloat=parseFloat(b + "");
		var sumResult=MnrMakeRound(parseFloat(aFloat + bFloat),2);
		return  parseFloat(sumResult + "");
	}
	/**
	 * Processing return data of pop-up screen (EES_MNR_0195)
	 */
	function setEES_MNR_0195(aryPopupData, row, col, shhetIdx){
    	var formObj=document.form;
		if(aryPopupData[0][4] != null && aryPopupData[0][4] != "") {
			formObj.in_ttl_lss_no.value=aryPopupData[0][4];
		}
	}
	/**
	 * Setting sheet combo
	 * @param	{IBSheet}	sheetObj	sheet object
	 */
	function setSheetCombo(sheetObj) {
		var sCondition=new Array (
			new Array("MdmCurrency","", "COMMON")		//Currency
			,new Array("MnrGenCd","CD00071", "COMMON")  //The previous state CD00042
			,new Array("MnrGenCd","CD00043", "COMMON")  //Payer Type
			,new Array("MnrGenCd","CD00039", "COMMON")  //Total Loss Status
			,new Array("MnrGenCd","TR", "COMMON")		//Main Reason
			,new Array("MnrGenCd","CD00069", "COMMON")  //Insurance Co
			,new Array("MnrGenCd","SELHO","CUSTOM9")	//Eq Kind
		)
		var comboList=MnrComSearchCombo(sheetObj,sCondition);
		var sheetComboText="";
		var sheetComboCode="";
		var sheetComboCodeText="";
		var sheetComboDefault="";
		for(var i=0; i < comboList.length; i++) {
			//Initializing each combo of sheets
			sheetComboText="";
			sheetComboCode="";
			sheetComboCodeText="";
			sheetComboDefault="";
			for(var j=0; j < comboList[i].length; j++){
				var tempText=comboList[i][j].split("|");
				sheetComboText +=  tempText[1] + "|";
				sheetComboCode +=  tempText[0] + "|";
				sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
				if(j == 0){
					sheetComboDefault=tempText[0];
				}
			}
			//Setting combo of sheet of tab
			for(var k=1; k < 7; k++) {
				if(i == 0) {
					if(k != 1)
					{
						sheetObjects[k].InitDataCombo (0, "curr_cd", sheetComboCode, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 1) {
					if( k == 2) {
					    sheetObjects[k].InitDataCombo (0, "ttl_lss_dtl_sts_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 2) {
					if(k == 3) {
						sheetObjects[k].InitDataCombo (0, "ttl_lss_n3pty_tp_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 3) {
					if(k == 1)
					{
						sheetObjects[k].InitDataCombo (0, "ttl_lss_sts_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 4) {
					if(k == 1)
					{
						sheetObjects[k].InitDataCombo (0, "ttl_lss_rsn_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 5) {
					if(k == 6)
					{
						sheetObjects[k].InitDataCombo (0, "ttl_lss_plc_nm", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 6) {
					if(k != 1)
					{
						sheetObjects[k].InitDataCombo (0, "eq_knd_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				}
			}
		}
	}
	/**
	 * (Responsible Office) Checking existed of office code<br>
	 * @param
	 * @param Row The object is row index in case of IBSheet
	 * @param Col The object is column index in case of IBSheet
	 * @param Value The object is CellValue in case of IBSheet
	 */
	function setOfficeInfo(sheetObj,Row, Col, Value)
	{
		var retArray=null;
		if (Value!="")
		{
		    retArray=MnrGeneralCodeCheck(sheetObj,"OFC",Value);
			if(retArray == null)
			{
				ComShowCodeMessage("MNR00165",Value,"OFFICE");
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col,true);
			}
		}
	}
	/**
	 * (Service Provider) Function of processing for pop-up screen return value<br>
	 * @param {arry} returnedValues Returned value array of pop-up screen
	 * @param Row The object is row index in case of IBSheet
	 * @param Col The object is column index in case of IBSheet
	 */
	function t1SetServiceProvider(aryPopupData) {
		if ( aryPopupData.length > 0 ) {
			var Row=sheetObjects[2].GetSelectRow();
			var vndrSeq=aryPopupData[0][2];
			var vndrNm=aryPopupData[0][4];
			sheetObjects[2].SetCellValue(Row, "payer_code",vndrSeq);
			sheetObjects[2].SetCellValue(Row, "payer_name",vndrNm);
			sheetObjects[2].SetCellValue(Row, "mnr_prnr_seq",vndrSeq);
		}
	}
	/**
	 * (Service Provider) Function of processing for pop-up screen return value<br>
	 * @param {arry} returnedValues Returned value array of pop-up screen
	 * @param Row The object is row index in case of IBSheet
	 * @param Col The object is column index in case of IBSheet
	 */
	function t2SetServiceProvider(aryPopupData) {
		if ( aryPopupData.length > 0 ) {
			var Row=sheetObjects[3].GetSelectRow();
			var vndrSeq=aryPopupData[0][2];
			var vndrNm=aryPopupData[0][4];
			sheetObjects[3].SetCellValue(Row, "payer_code",vndrSeq);
			sheetObjects[3].SetCellValue(Row, "payer_name",vndrNm);
			sheetObjects[3].SetCellValue(Row, "mnr_prnr_seq",vndrSeq);
		}
	}
	/**
	 * function of receiving COM_ENS_071 screen data
	 */
	function setCOM_ENS_071(aryPopupData){
    	 var formObj=document.form;
    	 var Row=sheetObjects[3].GetSelectRow();
		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "") {
			sheetObjects[3].SetCellValue(Row, "respb_ofc_cd",aryPopupData[0][3]);
		 }
    }
	/**
	 * (Customer) Function of processing for pop-up screen return value<br>
	 * @param {arry} returnedValues Returned value array of pop-up screen
	 * @param Row The object is row index in case of IBSheet
	 * @param Col The object is column index in case of IBSheet
	 */
	function setCustomer(aryPopupData) {
		if ( aryPopupData.length > 0 ) {
			var Row=sheetObjects[3].GetSelectRow();
			var custCd=aryPopupData[0][3];
			var custNm=aryPopupData[0][4];
			var mnrPrnrCntCd=custCd.substring(0,2);
			var mnrPrnrSeq=custCd.substring(2);
			sheetObjects[3].SetCellValue(Row, "payer_code",custCd);
			sheetObjects[3].SetCellValue(Row, "payer_name",custNm);
			sheetObjects[3].SetCellValue(Row, "mnr_prnr_cnt_cd",mnrPrnrCntCd);
			sheetObjects[3].SetCellValue(Row, "mnr_prnr_seq",mnrPrnrSeq);
		}
	}
	 /**
     * Adding row for file upload <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return {nothing}
     **/
	function file_Insert(sheetObj){
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
	 /**
     * Deleting upload file <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return {nothing}
     **/
	function file_Remove(sheetObj) {
		if(sheetObj.FindCheckedRow("del_chk") != ""){
			RemoveFileUpload(sheetObj);
		} else {
			ComShowCodeMessage("MNR00150");
		}
	}
	
	/**
     * Event handling of click of sheet1 <br>
     * @param {ibsheet} sheetObj    IBSheet object
     * @param {ibsheet} Row     	Selected row
     * @param {ibsheet} Col     	Selected column
     * @param {String} 	Value     	File name
     **/
	function sheet4_OnClick(sheetObj,Row,Col,Value){
		var prefix="";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.GetRowStatus(Row)=="I")return;
		if(sheetObj.GetCellText(Row, prefix+"file_path_nm") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_path_nm");
		return;
	}
	/**
     * Checking mandatory data
     * @param	{Element}	obj : Form element for checking
     */
	function checkMandatory(obj) {
		if(ComIsEmpty(ComGetObjValue(obj))) {
		    ComShowCodeMessage("MNR00003");
		    return false;
		}
		return true;
	}
	/**
	 * In case of saving Checking grid row data
	 */
	function checkIsDetailRow(){
		var cnt=0;
		for (var i=2; i<7; i++) {
			if(sheetObjects[i].RowCount()> 0) {
				cnt++;
			}
		}
		if(cnt<1) { return false}
		return true;
	}
	function setRowStausByRequest(){
		for (var i=2; i < 7; i++) {
			if(sheetObjects[i].RowCount()> 0) {
				for(var j=sheetObjects[i].HeaderRows(); j<=sheetObjects[i].LastRow(); j++) {
					if(sheetObjects[i].GetRowStatus(j)== "R") {
					    sheetObjects[i].SetRowStatus(j,"U");
						return;
					}
				}
			}
		}
	}
	/**
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setEqNoInfo(sheetObj,Row,Col) {
		var eqKndCd=sheetObj.GetCellValue(Row, "eq_knd_cd");
		if(eqKndCd == ""){
			ComShowCodeMessage("MNR00119");
			sheetObj.SetCellValue(Row,"rqst_eq_no","",0);
			sheetObj.SelectCell(Row, "eq_knd_cd");
			return;
		}
		var rqstEqNo=sheetObj.GetCellValue(Row, "rqst_eq_no");
		var eqKndCd=sheetObj.GetCellValue(Row, "eq_knd_cd");
		var totalLossDate=ComGetNowInfo("ymd");
		var retArray=MnrGeneralCodeCheck(sheetObj,"EQN",rqstEqNo+","+eqKndCd);
		if(retArray == null){
			ComShowCodeMessage("MNR00165",rqstEqNo,"EQ No.");
			sheetObj.SetCellValue(Row,"rqst_eq_no","",0);
			sheetObj.SelectCell(Row, "rqst_eq_no");
			setEqNoInfoClear(sheetObj,Row,Col);
			return;
		}
		var formObj=document.form;
		var sCostType="";
		if(eqKndCd == "U"){
			sCostType="MRDRRC";
		} else if(eqKndCd == "G"){
			sCostType="MRGSRC";
		} else {
			sCostType="MRZSRC";
		}
		var sXml=MnrComEqGenInfoSearch(sheetObj,eqKndCd,rqstEqNo,totalLossDate,sCostType);
		var retArr=MnrXmlToArray(sXml);
		//0 imm_ext|1 mvmt_dt|2 dv_cur|3 rpr_yd|4 sp_name|5 flg_rmk|6 manu_dt|7 pagerows|8 dv_value|9 ibflag|10 off_hire|11 mvmt_cd|12 dsp_flag|13 hngr_flg_yd|14 lessor_nm|15 hngr_rck_cd|16 crnt_yd_cd|17 lstm_cd|18 eq_no|19 hngr_flg_dt|20 bar_atch_knt|21 status|22 bar_tp_cd|23 dmg_flag|24 cost|25 eq_type|26 rpr_type|27 eq_tpsz_cd|28 rpr_dt
		if(retArr == null){
			setEqNoInfoClear(sheetObj,Row,Col);
			return;
		}
		var eqTpszCd=retArr[0][31];	//TP/SZ
		var dpcValAmt=retArr[0][10];	//DV.Value
		var lessorNm=retArr[0][16];	//Lessor
		var lstmCd=retArr[0][19];	//Term
		var ydCd=retArr[0][18];	//Yard
		var lessorCd	= retArr[0][42];	//Lessor Code
		
		sheetObj.SetCellValue(Row,"eq_tpsz_cd",eqTpszCd,0);//TP/SZ
		sheetObj.SetCellValue(Row,"lstm_cd",lstmCd,0);//Term
		sheetObj.SetCellValue(Row,"ttl_lss_yd_cd",ydCd,0);//Yard
		if(sheetObj.id == "t1sheet1") {
			sheetObj.SetCellValue(Row,"dpc_val_amt",dpcValAmt,0);//DV.Value
			sheetObj.SetCellValue(Row,"lessor_nm",lessorNm,0);//Lessor
			sheetObj.SetCellValue(Row,"ttl_lss_bil_amt",dpcValAmt);//Pay Amount
			
			if(lstmCd == "OW"){
				sheetObj.SetCellValue(Row, "mnr_prnr_seq", "6256", 0);
				sheetObj.SetCellValue(Row, "payer_code", "6256", 0);
				sheetObj.SetCellValue(Row, "payer_name", "EQ Operation Team", 0);
				sheetObj.SetCellValue(Row, "inv_no", " ", 0);
			}else{
				sheetObj.SetCellValue(Row, "mnr_prnr_seq", lessorCd, 0);
				sheetObj.SetCellValue(Row, "payer_code", sheetObj.GetCellValue(Row, "mnr_prnr_seq"), 0);
				sheetObj.SetCellValue(Row, "payer_name", sheetObj.GetCellValue(Row, "lessor_nm"), 0);
				
				var invNo = sheetObj.GetCellValue(Row, "inv_no");
				var ofcCd = formObj.rqst_ofc_cd.value;
				var yymm  = totalLossDate.substring(2,7).split("-").join("");

				invNo = yymm+""+ofcCd.substring(0,3)+"-"+rqstEqNo+""+"D";
				sheetObj.SetCellValue(Row, "inv_no", invNo, 0);
			}
			
		} else if(sheetObj.id == "t2sheet1") {
			sheetObj.SetCellValue(Row,"dpc_val_amt",dpcValAmt,0);//DV.Value
			var invNo=sheetObj.GetCellValue(Row, "inv_no");
			var ofcCd=formObj.rqst_ofc_cd.value;
			var yymm=totalLossDate.substring(2,7).split("-").join("");
			invNo=yymm+""+ofcCd.substring(0,3)+"-"+rqstEqNo+""+"T";
				sheetObj.SetCellValue(Row, "inv_no",invNo);
		} else if(sheetObj.id == "t5sheet1") {
			sheetObj.SetCellValue(Row,"dpc_val_amt",dpcValAmt,0);//DV.Value
		}
	}
	/**
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setEqNoInfoClear(sheetObj,Row,Col){
		sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);//TP/SZ
		if(sheetObj.id == "t1sheet1") {
			sheetObj.SetCellValue(Row,"dpc_val_amt","",0);//DV.Value
			sheetObj.SetCellValue(Row,"lessor_nm","",0);//Lessor
		} else if(sheetObj.id == "t2sheet1") {
			sheetObj.SetCellValue(Row,"dpc_val_amt","",0);//DV.Value
		}else if(sheetObj.id == "t5sheet1") {
			sheetObj.SetCellValue(Row,"dpc_val_amt","",0);//DV.Value
		}
	}
	/**
	 * Adding row of Total Loss History
	 *
	 * @param sheetObj
	 * @return
	 */
	function history_Insert(sheetObj) {
		var Row=sheetObj.DataInsert(-1);
		if(historyMnrStsRefNo=="" || historyMnrStsRefNo==null){
			sheetObj.SetCellValue(Row, "mnr_sts_ref_no","NEW");
		} else {
			sheetObj.SetCellValue(Row, "mnr_sts_ref_no",historyMnrStsRefNo);
		}
		sheetObj.SetCellValue(Row, "mnr_grp_tp_cd","TLL");
		sheetObj.SetCellValue(Row, "mnr_sts_dt",ComGetNowInfo("ymd"));
		sheetObj.SetCellValue(Row, "rqst_ofc_cd",currOfcCd);
		sheetObj.SetCellValue(Row, "cre_usr_id",usrId);
	}
	/**
	 * Deleting row of Total Loss History
	 *
	 * @param sheetObj
	 * @return
	 */
    function history_Remove(sheetObj) {
    	ComRowHideDelete(sheetObj, "del_chk");
    }
	/**
	 * Processing return data of pop-up screen
	 */
	function getMnr_Multi(rowArray,rtn_val) {
		var formObj=document.form;
		var tempText="";
		//Initializing
		formObj.in_ttl_lss_no.value='';
		for(var i=0; i<rowArray.length; i++) {
			var colArray=rowArray[i];
			tempText +=  rowArray[i] + ',';
		}
		//Removing last comma
		tempText=MnrDelLastDelim(tempText);
		tempText=tempText.toUpperCase();
		eval("document.form." + rtn_val + ".value='" + tempText + "';");
	}
