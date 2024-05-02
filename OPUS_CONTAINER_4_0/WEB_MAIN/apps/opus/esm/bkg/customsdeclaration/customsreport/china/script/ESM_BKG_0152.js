/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0152.js
*@FileTitle  : : Delivery Mode
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class Delivery Mode : business script for  Delivery Mode
 */


var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event  */
document.onclick=processButtonClick;

// Event handler processing by button name */
	function processButtonClick(){
	    var sheetObject1=sheetObjects[0];
	    var formObject=document.form;
	 	try {
	 		var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_RowAdd":
					doActionIBSheet(sheetObjects[0],formObject,IBINSERT);
				break;
				case "btn_Delete":
					doActionIBSheet(sheetObjects[0],formObject,IBDELETE);
				break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
				break;
				case "btn_New":
					doActionIBSheet(sheetObjects[0],formObject,IBRESET);
				break;
				case "btn_Save":
					doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
				break;
				case "btn_DownExcel":
					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
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
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
    	doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	//setting  button Enable or Disable
    	if(document.form.btn_chk.value == "N"){
    		ComBtnDisable("btn_Save");
    	}else if(document.form.btn_chk.value == "Y"){
    		ComBtnEnable("btn_Save");
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
            case "sheet1":      //sheet1 init
            	with(sheetObj){                
                	
					var HeadTitle1="|Sel.|Seq.|POD|Province|DEL|DEL MODE|Remark(s)||||";
				  	var headCount=ComCountHeadTitle(HeadTitle1);

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, FrozenCol:0, DataRowMerge:1 } );

					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);

  					var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					{Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
					{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5,  AcceptKeys:"E" , InputCaseSensitive:1  },
					{Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"area_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100,  AcceptKeys:"E|N" , InputCaseSensitive:1  },
					{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5,  AcceptKeys:"E" , InputCaseSensitive:1  },
					{Type:"Combo",     Hidden:0, Width:180,  Align:"Left",    ColMerge:0,   SaveName:"trsp_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"diff_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000,  AcceptKeys:"E|N" , InputCaseSensitive:1  },
					{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
	              	InitColumns(cols);
	
	              	SetEditable(1);
	              	SetSheetHeight(410);
				}
			break;
        }
    }
    
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
    	sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
			case IBCREATE:      //retrieve combo data
				formObj.f_cmd.value=INIT;
				var sXml=sheetObj.GetSearchData("ESM_BKG_0152GS.do", FormQueryString(formObj));
				var arrCombo;
				arrCombo=ComXml2ComboString(sXml, "name", "val");
				sheetObj.SetColProperty("trsp_mod_cd", {ComboText:arrCombo[0], ComboCode:arrCombo[1]} );
	    	break;
	        case IBSEARCH:      
    			if(!validateForm(sheetObj,formObj,sAction)) return false;
    			ComOpenWait(true);
    			formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESM_BKG_0152GS.do", FormQueryString(formObj), {Sync:2} );
    			ComOpenWait(false);
    		break;
	        case IBRESET:        
    	    	formObj.reset();
    	    	sheetObj.RemoveAll();
    	    	break;
			case IBSAVE:        
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				ComOpenWait(true);
		    	//formObj.f_cmd.value=MULTI;
		    	//sheetObj.DoSave("ESM_BKG_0152GS.do", FormQueryString(formObj), -1, false);
				
				var sParam="&f_cmd=" + MULTI+"&"+ComGetSaveString(sheetObj)		
				var sXml=sheetObj.GetSaveData("ESM_BKG_0152GS.do", sParam);
				var state=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				
				if(state == "S"){
		        	ComOpenWait(false);
			   		ComShowCodeMessage("BKG00166"); // Data Saved Successfully!!
		        }else{
		        	ComOpenWait(false);
		        	ComShowMessage(ComResultMessage(sXml));
		        }
				
				break;
			case IBINSERT:      //Row Add
				var row=sheetObj.DataInsert(-1);
				sheetObj.SetCellEditable(row, "Chk",0);
				sheetObj.SetCellEditable(row, "pod_cd",1);
				sheetObj.SetCellEditable(row, "area_nm",1);
				sheetObj.SetCellEditable(row, "del_cd",1);
				sheetObj.SetCellEditable(row, "trsp_mod_cd",1);
				sheetObj.SetCellEditable(row, "diff_rmk",1);
				break;
			case IBDELETE:     //Row Delete
				if(ComShowCodeConfirm('BKG03037')){
					ComRowHideDelete(sheetObj,"Chk");
				}
				break;
			case IBDOWNEXCEL:   //Down Excel
				ComOpenWait(true);
				sheetObj.Down2Excel({DownCols:makeHiddenSkipCol(sheetObj), Merge:1, SheetDesign:1, KeyFieldMark:0});
				ComOpenWait(false);
			break;
			case SEARCH01: // check validation of POD Location Code Validation in grid
				if(!validateForm(sheetObj,formObj,IBSEARCH))return false;
				formObj.f_cmd.value=SEARCH01;
	            sheetObj.SetWaitImageVisible(0);
	            var Row=sheetObj.GetSelectRow();
				var params=FormQueryString(formObj)+"&loc_cd="+sheetObj.GetCellValue(Row, "pod_cd");
				var sXml=sheetObj.GetSearchData("ESM_BKG_0152GS.do", params);
	    		var loc_cd=ComGetEtcData(sXml, "locCd");
		        if(loc_cd == undefined || loc_cd == ""){
	    			ComShowCodeMessage("BKG06012", sheetObj.GetCellText(Row, "pod_cd"));
	    			sheetObj.SetCellValue(Row, "pod_cd","",0);
	    			sheetObj.SelectCell(Row, "pod_cd");
	    		}else{
					sheetObj.SetCellValue(Row, "pod_cd",loc_cd,0);
	    		}
				break;
			case SEARCH02: // check validation of DEL Location Code Validation in grid
				if(!validateForm(sheetObj,formObj,IBSEARCH))return false;
				formObj.f_cmd.value=SEARCH01;
	            sheetObj.SetWaitImageVisible(0);
	            var Row=sheetObj.GetSelectRow();
				var params=FormQueryString(formObj)+"&loc_cd="+sheetObj.GetCellValue(Row, "del_cd");
				var sXml=sheetObj.GetSearchData("ESM_BKG_0152GS.do", params);
	    		var loc_cd=ComGetEtcData(sXml, "locCd");
		        if(loc_cd == undefined || loc_cd == ""){
	    			ComShowCodeMessage("BKG06012", sheetObj.GetCellText(Row, "del_cd"));
	    			sheetObj.SetCellValue(Row, "del_cd","",0);
	    			sheetObj.SelectCell(Row, "del_cd");
	    		}else{
					sheetObj.SetCellValue(Row, "del_cd",loc_cd,0);
	    		}
			break;
	    }
    }
	
    /**
     * handling process for input validation
     */
     function validateForm(sheetObj,formObj,sAction){
    	 switch (sAction) {
    	    case IBSEARCH: 
    			if(!ComChkRequired(formObj)) return false;
    	        break;
    	    case IBSAVE: 
    	    	var pod_cd;
    	    	var del_cd;
    			for(var i=1; i<sheetObj.RowCount()+1; i++){
					if(sheetObj.GetRowStatus(i) == "I"){
						pod_cd=sheetObj.GetCellValue(i,"pod_cd");
						del_cd=sheetObj.GetCellValue(i,"del_cd");
						if( pod_cd != "" && del_cd != "" ){
							for(var j=1; j<sheetObj.RowCount()+1; j++){
								if( sheetObj.GetRowStatus(j) == "I" ) continue;
								if( sheetObj.GetCellValue(j,"pod_cd") == pod_cd &&
										sheetObj.GetCellValue(j,"del_cd") == del_cd )
		    		    		{
									ComShowCodeMessage('BKG06028',sheetObj.GetCellValue(j,"Seq"));
		    		    			return false;
		    		    		}
		    		    	}
	    		    	}
    		    	}
    	    	}
    			break;
    	 }
         return true;
     }
     
 	/**
 	 * handler save complete
 	 * @param sheetObj
 	 * @param ErrMsg
 	 * @return
 	 */
     function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
     	var formObj=document.form;
     	var saveGubun=formObj.f_cmd.value;
 		if (ErrMsg == "") {
 			ComShowCodeMessage("BKG00166"); // Data Saved Successfully!!
 			doActionIBSheet(sheetObj,formObj,IBSEARCH);
 		} 
     }
     
  	/**
  	 * handler save complete : check validation POD and DEL  (OnChange)
  	 * @param sheetObj
  	 * @param ErrMsg
  	 * @return
  	 */
    function sheet1_OnChange(sheetObj, row, col, val){
    	if (sheetObj.ColSaveName(col) == "pod_cd"){
			doActionIBSheet(sheetObj,document.form,SEARCH01);
		}
		if (sheetObj.ColSaveName(col) == "del_cd"){
			doActionIBSheet(sheetObj,document.form,SEARCH02);
		}
    }
