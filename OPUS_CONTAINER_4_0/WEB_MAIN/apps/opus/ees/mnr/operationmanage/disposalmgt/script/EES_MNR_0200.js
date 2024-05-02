/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_MNR_0200.js
*@FileTitle : Disposal Detail Information Popup
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
     * @class EES_MNR_0200 : EES_MNR_0200 - Defining a script used by screen
     */
    function EES_MNR_0200() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
/* Developer's task	*/
// Common global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
//Sheet
var sheetObjects=new Array();
var sheetCnt=0;

//Combo object
var comboObjects=new Array();
var comboCnt=0;
var uploadFileSeq="";
var uTpSz=new Array();
var gTpSz=new Array();
var zTpSz=new Array();
var selCheck=false;
//Default value of combo
var eqKnddefCode="";
var dispTpdefCode="";
var appOfcdefCode="";
var actionType="";
var preEqKndCd="";
var preCurrCd="";
var preDispTpCd="";
var isNowInit=false;
// Defining event handler of button click */
document.onclick=processButtonClick;
// Event handler to diverge process by button name */
    function processButtonClick(){
         /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
				switch(srcName) {
					case "btn_New":
						doActionIBSheet(sheetObjects[0],formObject,IBCLEAR);
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
    /**
     * Sheet default setting and initializing
     * To implement for onload event of body tag
     * After loading in your browser should display the ability to add pre-processing
     */
    function loadPage() {
		MnrWaitControl(true);
		initControl();
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
//		for(k=0;k<tabObjects.length;k++){
//            initTab(tabObjects[k],k + 1);
//            tabObjects[k].SetSelectedIndex(0);
//        }
		for(k=0;k < comboObjects.length;k++){
            initCombo(comboObjects[k],k + 1);
        }
		 var formObject=document.form;
		 
		 initUpload();
		
		doActionIBSheet(sheetObjects[0],formObject,IBCLEAR);
		//Retrieving file list
		var fileSeq=formObject.fileSeq.value;
		if(fileSeq != "" && fileSeq != null){
			var fileXml=SearchFileUpload(sheetObjects[4],fileSeq);
			if(!MnrIsEmptyXml(fileXml)){
				sheetObjects[4].LoadSearchData(fileXml,{Sync:0} );
			}
		}
		//Retrieving detail
		doActionIBSheet(sheetObjects[0],formObject,IBROWSEARCH);
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
		 		var sParam = "f_cmd="+COMMAND01;
		 		sParam+= "&mnr_grp_tp_cd=DSP";       // MNR Work Group Type Code
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
						var fileXml=SearchFileUpload(sheetObjects[4],uploadFileSeq);
						sheetObjects[4].LoadSearchData(fileXml,{Sync:0} );
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
					badFile = true;
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
     * Tab Setting default
     * Setting tab's item
     */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {
                    var cnt=0 ;
                    InsertItem( "Unit Sale" , "");
                    InsertItem( "Bulk Sale" , "");
                }
                break;
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
     * Initializing variable for IBSheet and defining header
     * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
			case "sheet1":
                with (sheetObj) {
                    //Setting Host information[mandatory][HostIp, Port, PagePath]         
					SetVisible(0);
				}
            case "sheet2":
                with(sheetObj){                      
		             var HeadTitle1="|S|Disposal No.|EQ Type|Q'ty|Currency|Total Amount|Buyer Sel|Posting DT|Creation DT|Status"
		             var headCount=ComCountHeadTitle(HeadTitle1);
		
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"disp_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Combo",     Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"eq_knd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"disp_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"disp_st_prc",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"buyer_cnt",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"disp_bultn_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rqst_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Combo",     Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"disp_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"disp_eml_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"apro_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"file_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_disp_rmk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		              
		             InitColumns(cols);
		             SetEditable(1);
		             SetVisible(false);            
                }
                break;
			case "sheet3":
		          with(sheetObj){         
					   var HeadTitle1="|Sel|Buyer Code|Buyer Name|Buyer Type";			
					   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );			
					   var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					   var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					   InitHeaders(headers, info);			
					   var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//					 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq",              KeyField:0,   CalcLogic:"",   Format:"" },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"mnr_prnr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
					   SetSheetHeight(180);
					   SetCountPosition(0);
					   SetFocusAfterProcess(0);
					}
		          break;
			case "sheet4":
		        with(sheetObj){
					var prefix="";				  
					var HeadTitle1="|Seq.|File|Download";
					var headCount=ComCountHeadTitle(HeadTitle1);
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1};
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
					 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Popup",     Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"org_file_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
					 {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_dw",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"file_dtl_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					 
					InitColumns(cols);					
					SetEditable(1);				
					SetImageList(0,"img/ico_attach.gif");
		            SetShowButtonImage(1);
		            SetSheetHeight(130);
		            SetCountPosition(0);
					SetFocusAfterProcess(0);
					}	
					break;
					
			case "t1_sheet1":
		        with(sheetObj){             
           
					var HeadTitle1="|Sel|Seq.|EQ No.|Charge Code|TP/SZ|Term|Status|Yard|Material|Maker Name|Unit Model|U.Price|Sale Category|Price Verify Result|Remark";					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq",               KeyField:0,   CalcLogic:"",   Format:"" },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"eq_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"chg_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lstm_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"disp_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"mtrl_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Combo",     Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"mkr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"mdl_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"disp_ut_prc",       KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"disp_rsn_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Combo",     Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"dsp_vrfy_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"mnr_disp_dtl_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"disp_ut_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"disp_qty",          KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"trf_ut_prc",        KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
					 
					InitColumns(cols);
					SetEditable(1);          
					SetEditableColorDiff(1);
					SetSheetHeight(130);
					SetSelectionMode(smSelectionRow);
					SetCountPosition(0);
					SetFocusAfterProcess(0);
					 //conversion of function[check again]CLT 					InitDataValid(0,  "eq_no", vtEngUpOther,"0123456789");
					//conversion of function[check again]CLT 					InitDataValid(0,  "mdl_nm", vtEngUpOther,"0123456789!@#$%^&*()_+-=\][}{:;/.,?><~\"\'");
				}
			break;
			
			case "t2_sheet1":
		        with(sheetObj){              
          
					var HeadTitle1="|Sel|Seq.|TP/SZ|Q'ty|Location|U.Pirce|Remark(s)";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq",               KeyField:0,   CalcLogic:"",   Format:"" },
					 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"disp_qty",          KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"disp_yd_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"disp_ut_prc",       KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"mnr_disp_dtl_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"disp_ut_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					 
					InitColumns(cols);
					SetEditable(1);         
					SetEditableColorDiff(1);                   
					SetShowButtonImage(2);           
					SetSelectionMode(smSelectionRow);
					SetSheetHeight(100);
					//conversion of function[check again]CLT 					InitDataValid(0,  "disp_yd_cd", vtEngUpOther,"0123456789");
				}
			break;
        }
    }
    
	function initControl() {
	    //Axon event handling 1. Catching event
		var formObject=document.form;
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject);
	    axon_event.addListenerFormat('focus',    'obj_activate',    formObject);
//	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);
		axon_event.addListenerFormat('change',	 'obj_change',	formObject);
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
	//Axon event handling 2. Event handling function
	function obj_deactivate(){
	    ComChkObjValid(ComGetEvent());
	}
	function obj_activate(){
	    ComClearSeparator(ComGetEvent());
	}
	function obj_change(){
		var obj=event.srcElement;
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "disp_eml_flg_temp":
				   	break;
			}
	    }
	}
	
	 /**
     * Event handling of changing tab
     * Activating tab for selected
     */
    function tab1_OnChange(tabObj , nItem){
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	//--------------- Important logic --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
    	//------------------------------------------------------//
    	beforetab=nItem;
    }
	function t1_sheet1_OnChange(sheetObj,Row, Col, Value)	{
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) == "eq_no"){
			var checkEqn=sheetObj.GetCellValue(Row,Col);
			var checkEqType=eq_knd_cd.GetSelectCode();
			var dispNo=formObj.disp_no.value;
			var retArray=MnrGeneralCodeCheck(sheetObjects[0],"DSPEQN",checkEqn + "," + checkEqType + ","+ dispNo);
			if(retArray == null || retArray[0] == null){
				ComShowCodeMessage("MNR00165",checkEqn,"EQ No.");
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);
				sheetObj.SetCellValue(Row,"lstm_cd","",0);
				sheetObj.SetCellValue(Row,"mvmt_cd","",0);
				sheetObj.SetCellValue(Row,"disp_yd_cd","",0);
				sheetObj.SetCellValue(Row,"mtrl_nm","",0);
				sheetObj.SetCellValue(Row,"mkr_nm","",0);
				sheetObj.SetCellValue(Row,"mdl_nm","",0);
				sheetObj.SetCellValue(Row,"disp_ut_prc","0.00",0);
				sheetObj.SetCellValue(Row,"dsp_vrfy_tp_cd","",0);
				sheetObj.SetCellValue(Row,"trf_ut_prc","",0);
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
					sheetObj.SetCellValue(Row,"dsp_vrfy_tp_cd","",0);
					sheetObj.SetCellValue(Row,"trf_ut_prc","",0);
					sheetObj.SelectCell(Row,Col);
				} else  {
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
			if(sheetObj.GetCellValue(Row,"eq_no") != ""){
				//NOT Damage
				if(sheetObj.GetCellValue(Row,"disp_rsn_cd") == "C"){
					if(sheetObj.GetCellValue(Row,"trf_ut_prc") == "0"){
						sheetObj.SetCellValue(Row,"dsp_vrfy_tp_cd","NT",0);
					} else {
						var trfUtPrc=parseFloat(sheetObj.GetCellValue(Row,"trf_ut_prc"));
						var dispUtPrc=parseFloat(sheetObj.GetCellValue(Row,"disp_ut_prc"));
						if(dispUtPrc <= trfUtPrc){
							sheetObj.SetCellValue(Row,"dsp_vrfy_tp_cd","SS",0);
						} else {
							sheetObj.SetCellValue(Row,"dsp_vrfy_tp_cd","UP",0);
						}
					}
				//Damage
				} else {
					sheetObj.SetCellValue(Row,"dsp_vrfy_tp_cd","DA",0);
				}
			}
			reSetQtyAndPrice();
		} else if(sheetObj.ColSaveName(Col) == "disp_rsn_cd"){
			if(sheetObj.GetCellValue(Row,"eq_no") != ""){
				//NOT Damage
				if(sheetObj.GetCellValue(Row,"disp_rsn_cd") == "C"){
					if(sheetObj.GetCellValue(Row,"trf_ut_prc") == "0"){
						sheetObj.SetCellValue(Row,"dsp_vrfy_tp_cd","NT",0);
					} else {
						var trfUtPrc=parseFloat(sheetObj.GetCellValue(Row,"trf_ut_prc"));
						var dispUtPrc=parseFloat(sheetObj.GetCellValue(Row,"disp_ut_prc"));
						if(dispUtPrc <= trfUtPrc){
							sheetObj.SetCellValue(Row,"dsp_vrfy_tp_cd","SS",0);
						} else {
							sheetObj.SetCellValue(Row,"dsp_vrfy_tp_cd","UP",0);
						}
					}
				//Damage
				} else {
					sheetObj.SetCellValue(Row,"dsp_vrfy_tp_cd","DA",0);
				}
			}
		}
	}
	function t2_sheet1_OnChange(sheetObj,Row, Col, Value) {
		var formObj=document.form;
		if(sheetObj.ColSaveName(Col) == "del_chk"){
			MnrCheckRowColChange(sheetObj,sheetObj.GetCellValue(Row,"del_chk"),Row);
		} else if(sheetObj.ColSaveName(Col) == "disp_yd_cd"){
			var checkMdmLoc=sheetObj.GetCellValue(Row,Col);
			retArray=MnrGeneralCodeCheck(sheetObjects[0],"MLOC",checkMdmLoc);
			if(retArray == null){
				ComShowCodeMessage("MNR00165",checkMdmLoc,"Location");
				sheetObj.SetCellValue(Row ,Col,"",0);
				sheetObj.SelectCell(Row ,Col);
			} else {
				return;
			}
		} else if(sheetObj.ColSaveName(Col) == "disp_ut_prc"){
			reSetQtyAndPrice();
		} else if(sheetObj.ColSaveName(Col) == "disp_qty"){
			reSetQtyAndPrice();
		}
	}
	/**
	 * Event handling of OnPopupClick of t2_sheet1
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 */
	function t2_sheet1_OnPopupClick(sheetObj,Row,Col) {
		var sName=sheetObj.ColSaveName(Col);
		switch (sName) {
			case "disp_yd_cd":
				ComOpenPopup('/opuscntr/COM_ENS_051.do', 700, 460, 'setPopData_Loc', '1,0,1,1,0,0,0,0', false, false, Row, Col, 4);
				break;
	 	}
	}
	function sheet3_OnChange(sheetObj,Row, Col, Value)	{
		var formObj=document.form;
		if(sheetObj.ColSaveName(Col) == "del_chk"){
			var sRow=sheetObj.FindCheckedRow("del_chk");
			if(sRow != ""){
				var arrRow=sRow.split("|");
				if(arrRow.length > 2){
					//Initializing Buyer Selection
					initBuyerSelection();
					//Reselecting
					sheetObj.SetCellValue(Row,"del_chk","1",0);
				}
			}
			MnrCheckRowColChange(sheetObj,sheetObj.GetCellValue(Row,"del_chk"),Row);
		}
	}

	/**
     * Event handling of click of sheet1 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
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
	//Sheet processing-related processes
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
			case IBROWSEARCH:      //Retrieving
                 if(validateForm(sheetObj,formObj,sAction)){
					 	formObj.f_cmd.value=SEARCH01;
					    sParam=FormQueryString(formObj);
					    var sXml=sheetObj.GetSaveData("EES_MNR_0200GS.do", sParam);
					   	var arrXml=sXml.split("|$$|");
						for(var i=0; i < arrXml.length - 2; i++){
							sheetObjects[i + 2].LoadSearchData(arrXml[i],{Sync:0} );
						}
//						if(sheetObjects[3].RowCount()> 0){
//							tabObjects[0].SetSelectedIndex(0);
//						} else {
//							tabObjects[0].SetSelectedIndex(1);
//						}
				  }
                break;
			case IBCLEAR:      // Initializing
				MnrWaitControl(true);
				isNowInit=true;
				sheetObj.SetWaitImageVisible(0);
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
				//Initializing sheet
				for(var i=2; i < sheetObjects.length;i++){
					sheetObjects[i].RemoveAll();
				}
				//Initializing combo
				for(var i=0; i < comboObjects.length;i++){
					comboObjects[i].SetSelectCode("-1");
					comboObjects[i].RemoveAll();
				}
				//Retrieving combo data
				var sCondition=new Array (
					new Array("MdmCurrency","","COMMON"),       //CUR_CD
					new Array("MnrGenCd","CD00029", "COMMON"),  //DISP_STS_CD
					new Array("MnrGenCd",formObj.self_ofc_cd.value,"CUSTOM9"),
					new Array("MnrOfcGenInfo","","DISP"),
					//sheetObjects[1] combo
					new Array("MnrGenCd","CD00002", "COMMON"),	//EQ_KND_CD
					new Array("MdmCurrency","","COMMON"),       //CURR_CD
					new Array("MnrGenCd","CD00029", "COMMON"),  //DISP_STS_CD
					//sheetObjects[2] combo
					new Array("MnrGenCd","CD00034", "COMMON"),	//BYER TYPE
					//sheetObjects[3] combo
					new Array("MnrGenCd","CD00038", "COMMON"),	//DISP_RSN_CD
					new Array("MnrGenCd","CD00087", "COMMON"),  //MKR_NM
					new Array("MnrGenCd","CD00080", "COMMON")   //dsp_vrfy_tp_cd
				)
				var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
				//Setting currency
				if(comboList[0] != null){
					for(var j=0; j < comboList[0].length;j++){
						var tempText=comboList[0][j].split("|");
						curr_cd.InsertItem(j,tempText[0] ,tempText[0]);
					}
				}
				curr_cd.SetSelectCode(formObj.temp4.value);;
				//Setting DISP_STS_CD
				if(comboList[1] != null){
					for(var j=0; j < comboList[1].length;j++){
						var tempText=comboList[1][j].split("|");
						disp_sts_cd.InsertItem(j,tempText[1] ,tempText[0]);
					}
				}
				disp_sts_cd.SetSelectCode(formObj.temp3.value);;
				//Setting EQ_KND_CD
				if(comboList[2] != null){
					for(var j=0; j < comboList[2].length;j++){
						var tempText=comboList[2][j].split("|");
						eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
					}
				}
				eq_knd_cd.SetSelectCode(formObj.temp2.value);;
				//************ POP UP  ****************//
				curr_cd.SetEnable(0);
				disp_sts_cd.SetEnable(0);
				eq_knd_cd.SetEnable(0);
				//************ POP UP  ****************//
				//Setting combo of sheet
				var sheetComboCode="";
				var sheetComboText="";
				var sheetComboCodeText="";
				//Saving for DEF Value
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
				comboSaveNames[6]="dsp_vrfy_tp_cd";
				for(var i=5; i < comboList.length;i++){
					if(comboList[i] != null){
						sheetComboText="";
						sheetComboCode="";
						//sheetComboCodeText = "";
				 		for(var j=0; j < comboList[i].length;j++){
							var tempText=comboList[i][j].split("|");
							sheetComboCode +=  tempText[0] + "|";
							sheetComboText +=  tempText[1] + "|";
							if(j == 0){
								sheetComboDefault[i - 5]=tempText[0];
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
						} else if(comboSaveNames[i - 4] == "dsp_vrfy_tp_cd"){
							sheetObjects[3].InitDataCombo (0, comboSaveNames[i - 4], sheetComboText, sheetComboCode ,sheetComboDefault[i - 4]);
						}
					}
				}
				var toDay=ComGetNowInfo("ymd");
				//Value setting of initialize
				formObj.disp_eml_flg_temp.checked=false;
				//Setting combo of sheet
				sheetObj.SetWaitImageVisible(1);
				isNowInit=false;
				MnrWaitControl(false);
				break;
        }
    }
	/**
     * Validating process for input form data
     */
    function validateForm(sheetObj,formObj,sAction){
		with(formObj){
	    	switch(sAction) {
				//Retrieving detail
				case IBROWSEARCH:
					if(MnrNullToBlank(disp_no.value) == "" || MnrNullToBlank(disp_no.value) == "NEW"){
						ComShowCodeMessage("MNR00248","Disposal ");
						return false;
					}
					break;
			}
		}
        return true;
    }
	function reSetQtyAndPrice(){
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
		for(var x=1 ; x <= sheetObjects[4].RowCount();x++){
			sheetQtySum += parseInt(sheetObjects[4].GetCellValue(x,"disp_qty"),10);
			var price=parseFloat(sheetObjects[4].GetCellValue(x,"disp_ut_prc"));
			var qty=parseFloat(sheetObjects[4].GetCellValue(x,"disp_qty"));
			var sum=price * qty;
			sheet4PriceSum += sum;
		}
		formObj.disp_st_prc.value=ComAddComma2((sheet3PriceSum + sheet4PriceSum), "#,###");
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
		//0 imm_ext|1 mdl_nm|2 mvmt_dt|3 dv_cur|4 rpr_yd|5 sp_name|6 flg_rmk|7 manu_dt|8 mkr_nm|9 pagerows|10 dv_value|11 ibflag|12 off_hire|13 mvmt_cd|14 dsp_flag|15 hngr_flg_yd|16 lessor_nm|17 hngr_rck_cd|18 crnt_yd_cd|19 lstm_cd|20 eq_no|21 hngr_flg_dt|22 bar_atch_knt|23 status|24 bar_tp_cd|25 dmg_flag|26 cost|27 mtrl_cd|28 eq_type|29 mtrl_nm|30 rpr_type|31 eq_tpsz_cd|32 rpr_dt
		if(retArr != null){
			//In case of MVMT_CD = "XX"
			if(retArr[0][13] == 'XX'){
				ComShowCodeMessage("MNR00305");
				sheetObj.SetCellValue(Row,"eq_no","",0);
				sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);
				sheetObj.SetCellValue(Row,"lstm_cd","",0);
				sheetObj.SetCellValue(Row,"mvmt_cd","",0);
				sheetObj.SetCellValue(Row,"disp_yd_cd","",0);
				sheetObj.SetCellValue(Row,"mtrl_nm","",0);
				sheetObj.SetCellValue(Row,"mkr_nm","",0);
				sheetObj.SetCellValue(Row,"mdl_nm","",0);
				sheetObj.SetCellValue(Row,"dsp_vrfy_tp_cd","",0);
				sheetObj.SetCellValue(Row,"trf_ut_prc","0",0);
				sheetObj.SelectCell(Row,"eq_no");
				return;
			}
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
			var checkTpsz=MnrNullToBlank(sheetObj.GetCellValue(Row,"eq_tpsz_cd"));
			if(checkTpsz != '' && checkTpsz.substring(0,1) == 'R'){
				sheetObj.SetCellEditable(Row, "mkr_nm",1);
				sheetObj.SetCellEditable(Row, "mdl_nm",1);
			}  else {
				sheetObj.SetCellEditable(Row, "mkr_nm",0);
				sheetObj.SetCellEditable(Row, "mdl_nm",0);
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
			sheetObj.SetCellValue(Row,"dsp_vrfy_tp_cd","",0);
			sheetObj.SetCellValue(Row,"trf_ut_prc","0",0);
			return;
		}
		//Retrieving unit price
		var price=MnrGetDISPEQUnitPrice(sheetObjects[0],curr_cd.GetSelectCode(),sheetObj.GetCellValue(Row,"eq_tpsz_cd"),sheetObj.GetCellValue(Row,"disp_yd_cd"),formObj.rqst_dt.value);
		if(MnrNullToBlank(price) == "0"){
			sheetObj.SetCellValue(Row,"disp_ut_prc","0.00",0);
			//Not Found Tariff
			sheetObj.SetCellValue(Row,"dsp_vrfy_tp_cd","NT",0);
			sheetObj.SetCellValue(Row,"trf_ut_prc","0",0);
		}  else {
			sheetObj.SetCellValue(Row,"disp_ut_prc",price,0);
			sheetObj.SetCellValue(Row,"dsp_vrfy_tp_cd","SS",0);
			sheetObj.SetCellValue(Row,"trf_ut_prc",price,0);
		}
	}
	/**
	 * Location Function of processing for pop-up screen return value<br>
	 * @param {arry} returnedValues Returned value array of pop-up screen
	 * @param Row The object is row index in case of IBSheet
	 * @param Col The object is column index in case of IBSheet
	 * @param The object is sheet index in case of IBSheet
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
	 * Processing of returned pop-up screen data (EES_MNR_158)
	 * @param {arry} returnedValues Returned value array of pop-up screen
	 * @param Row The object is row index in case of IBSheet
	 * @param Col The object is column index in case of IBSheet
	 * @param The object is sheet index in case of IBSheet
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
						SetCellValue(Row,"lstm_cd",aryPopupData[i][11],0);
						SetCellValue(Row,"mvmt_cd",aryPopupData[i][12],0);
						SetCellValue(Row,"disp_yd_cd",aryPopupData[i][10],0);
						SetCellValue(Row,"mtrl_nm",aryPopupData[i][6],0);
						SetCellValue(Row,"mkr_nm",aryPopupData[i][7],0);
						SetCellValue(Row,"mdl_nm",aryPopupData[i][8],0);
						SetCellValue(Row,"disp_ut_prc",aryPopupData[i][16],0);
						tempRowCnt++;
					}
				}
			}
		}
	}
	function eq_knd_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode){		
		var tpSzComboStr="";
		if(comboObj.GetSelectCode()== "U"){
			tpSzComboStr=ComGetAryJoin(uTpSz,"|");
		} else if(comboObj.GetSelectCode()== "G"){
			tpSzComboStr=ComGetAryJoin(gTpSz,"|");
		} else {
			tpSzComboStr=ComGetAryJoin(zTpSz,"|");
		}
		sheetObjects[3].InitDataCombo (0, "eq_tpsz_cd", tpSzComboStr, tpSzComboStr ,"");
		sheetObjects[4].InitDataCombo (0, "eq_tpsz_cd", tpSzComboStr, tpSzComboStr ,"");
		preEqKndCd=comboObj.GetSelectCode();
	}
	/**
	* Initializing data of "Buyer Select" without conditions
     * Activating tab for selected
	*/
	function initBuyerSelection(){
		var checkVal="";
		checkVal="0";
		for(var x=1 ; x <= sheetObjects[2].RowCount();x++){
			sheetObjects[2].SetCellValue(x,"del_chk",checkVal,0);
			MnrCheckRowColChange(sheetObjects[2],sheetObjects[2].GetCellValue(x,"del_chk"),x);
		}
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
		var sXml=MnrComEqGenInfoSearch(sheetObj,sEqType,sEqNo,sTotalLossDate,sCostType);
		var retArr=MnrXmlToArray(sXml);
		//0 imm_ext|1 mvmt_dt|2 dv_cur|3 rpr_yd|4 sp_name|5 flg_rmk|6 manu_dt|7 pagerows|8 dv_value|9 ibflag|10 off_hire|11 mvmt_cd|12 dsp_flag|13 hngr_flg_yd|14 lessor_nm|15 hngr_rck_cd|16 crnt_yd_cd|17 lstm_cd|18 eq_no|19 hngr_flg_dt|20 bar_atch_knt|21 status|22 bar_tp_cd|23 dmg_flag|24 cost|25 eq_type|26 rpr_type|27 eq_tpsz_cd|28 rpr_dt
		if(retArr != null){
			//TpSz
			sheetObj.SetCellValue(Row,"eq_tpsz_cd",retArr[0][31],0);
			//Term
			sheetObj.SetCellValue(Row,"lstm_cd",retArr[0][19],0);
			//mvmt_cd
			sheetObj.SetCellValue(Row,"mvmt_cd",retArr[0][13],0);
			//current Yard
			sheetObj.SetCellValue(Row,"disp_yd_cd",retArr[0][18],0);
		} else {
			sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);
			sheetObj.SetCellValue(Row,"lstm_cd","",0);
			sheetObj.SetCellValue(Row,"mvmt_cd","",0);
			sheetObj.SetCellValue(Row,"disp_yd_cd","",0);
		}
	}
	/**
	 * Location Function of processing for pop-up screen return value<br>
	 * @param {arry} returnedValues Returned value array of pop-up screen
	 * @param Row The object is row index in case of IBSheet
	 * @param Col The object is column index in case of IBSheet
	 * @param The object is sheet index in case of IBSheet
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
/* End of developer's task */
