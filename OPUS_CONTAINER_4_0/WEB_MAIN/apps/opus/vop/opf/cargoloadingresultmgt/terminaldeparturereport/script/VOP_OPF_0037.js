/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_opf_0037.js
*@FileTitle  : Excludefrom TPR Save
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/19
=========================================================*/
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         　
        var sheetObject1=sheetObjects[0];   //t1sheet1
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_Save":
					doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
					break;
				case "btn_Delete":
					doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
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
        var formObj=document.form;
        if( formObj.status1.value == "R"){
            document.all.btn_save_table.style.display="none";
        }
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
		             var HeadTitle1="|No|Reason Cd|key_of_remark|Reason for Excluding from TPR|Check";
		             var headCount=ComCountHeadTitle(HeadTitle1);
		
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"No" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"tml_prod_rpt_rsn_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"key_of_remark",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:370,  Align:"Left",    ColMerge:1,   SaveName:"tml_prod_rpt_rsn_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"tdr_rpt_rsn_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		              
		             InitColumns(cols);
		
		             SetEditable(1);
		             SetCountPosition(0);
		             SetSheetHeight(230);
            }
			break;
		}
    }
  // handling process related Sheet
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      //Retrieve
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObj.GetSearchData("VOP_OPF_0037GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(""));
				sheetObj.RenderSheet(0);
				sheetObj.SetWaitImageVisible(0);
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				sheetObj.RenderSheet(1);
				for(var idxRow=sheetObj.HeaderRows(); idxRow <= sheetObj.LastRow(); idxRow++){
					if(sheetObj.GetCellValue(idxRow, "tdr_rpt_rsn_cd") == "1"){
						var arrData=sheetObj.GetCellValue(idxRow, "key_of_remark").split("_/");
						formObj.tml_prod_rpt_rsn_rmk.value=arrData[arrData.length - 1];
					}
				}
				break;
			case IBSAVE:        //save
				var checkedRow=false;
				var delRow=0; 
				var classNm="";
				for(var idxRow=sheetObj.HeaderRows(); idxRow <= sheetObj.LastRow(); idxRow++){
					if(sheetObj.GetCellValue(idxRow, "tdr_rpt_rsn_cd") == "1"){
						if(sheetObj.GetCellValue(idxRow, "tml_prod_rpt_rsn_cd") == "OTH"){
							if(formObj.tml_prod_rpt_rsn_rmk.value == ""){
								ComShowCodeMessage("COM130201", "Remark");
								formObj.tml_prod_rpt_rsn_rmk.focus();
								return;
							}
						}
						checkedRow=true;
						var keyValue=formObj.vsl_cd.value + "_/" +
									    formObj.skd_voy_no.value + "_/" + 
									    formObj.skd_dir_cd.value + "_/" + 
									    formObj.clpt_ind_seq.value + "_/" + 
									    formObj.port_cd.value + "_/" + 
									    formObj.tml_prod_rpt_rsn_rmk.value + "_/";
						sheetObj.SetCellValue(idxRow, "key_of_remark",keyValue);
						sheetObj.SetRowStatus(idxRow,"U");
						classNm="#e41010";
					}else if(sheetObj.GetCellValue(idxRow, "key_of_remark") != "" && sheetObj.GetCellValue(idxRow, "tdr_rpt_rsn_cd") == "0"){
						delRow=idxRow;
					}
				}
				if(!checkedRow){
					if( delRow > 0 ){
						var keyValue=formObj.vsl_cd.value + "_/" +
									    formObj.skd_voy_no.value + "_/" + 
									    formObj.skd_dir_cd.value + "_/" + 
									    formObj.clpt_ind_seq.value + "_/" + 
									    formObj.port_cd.value + "_/" + 
									    formObj.tml_prod_rpt_rsn_rmk.value + "_/";
						sheetObj.SetCellValue(delRow, "key_of_remark",keyValue);
						sheetObj.SetRowStatus(delRow,"D");
						classNm="#514747";
					}else{
						ComShowCodeMessage("COM12113", "Code"); 
						return;
					}
				}
				formObj.f_cmd.value=MULTI01;
				var sParam=ComGetSaveString(sheetObjects);
				if (sParam == "") return;
				sParam +=  "&" + FormQueryString(formObj);
				var sXml=sheetObj.GetSaveData("VOP_OPF_0037GS.do", sParam);
				sheetObj.LoadSaveData(sXml);
				if(sXml.indexOf("<TR-ALL>OK</TR-ALL>") > 0){
					
					if(opener == null){
						opener = parent;
					}
					
					opener.exTPR(classNm);
//					window.dialogArguments.document.all("btn_ExcludefromTPR").style.color=classNm;
					ComClosePopup(); 
				}
				break;
			case IBDELETE:        //save
				var checkedRow=false;
				for(var idxRow=sheetObj.HeaderRows(); idxRow <= sheetObj.LastRow(); idxRow++){
					if(sheetObj.GetCellValue(idxRow, "tdr_rpt_rsn_cd") == "1"){
						var keyValue=formObj.vsl_cd.value + "_/" +
									    formObj.skd_voy_no.value + "_/" + 
									    formObj.skd_dir_cd.value + "_/" + 
									    formObj.clpt_ind_seq.value + "_/" + 
									    formObj.port_cd.value + "_/" ;
						sheetObj.SetCellValue(idxRow, "key_of_remark",keyValue);
						checkedRow=true;
						sheetObj.SetRowStatus(idxRow,"D");
					}
				}
				formObj.f_cmd.value=MULTI01;
				var sParam=ComGetSaveString(sheetObjects);
				if (sParam == "") return;
				sParam +=  "&" + FormQueryString(formObj);
				var sXml=sheetObj.GetSaveData("VOP_OPF_0037GS.do", sParam);
				sheetObj.LoadSaveData(sXml);
				if(sXml.indexOf("OK") > 0){
					window.dialogArguments.document.all("btn_ExcludefromTPR").className="btn1";
					ComClosePopup(); 
				}
				break;
        }
    }
    /**
    * setting initial event
    */
    function initControl() {
		axon_event.addListener('keypress', 'net_work_keypress', 'net_work', '');		
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }
        return true;
    }
	function sheet1_OnChange(sheetObj, Row, Col, Value){
		if(sheetObj.ColSaveName(Col) ==  "tdr_rpt_rsn_cd"){
			if(sheetObj.GetCellValue(Row, "tdr_rpt_rsn_cd") == "1"){
				for(var idxRow=sheetObj.HeaderRows(); idxRow <= sheetObj.LastRow(); idxRow++){
					if(Row != idxRow){
						sheetObj.SetCellValue(idxRow, "tdr_rpt_rsn_cd","0");
					}
				}
				if(sheetObj.GetCellValue(Row, "tml_prod_rpt_rsn_cd") == "OTH"){
					document.form.tml_prod_rpt_rsn_rmk.className="textarea1";
				}else{
					document.form.tml_prod_rpt_rsn_rmk.className="textarea";
				}
			}else{
				document.form.tml_prod_rpt_rsn_rmk.className="textarea";
			}
			document.form.tml_prod_rpt_rsn_rmk.value="";
		}
	}
