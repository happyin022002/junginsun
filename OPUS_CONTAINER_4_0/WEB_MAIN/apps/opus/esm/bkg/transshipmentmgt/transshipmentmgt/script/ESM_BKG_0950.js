/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0950.js
*@FileTitle : Relay Vessel Group Assign by Relay Port
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var sheetObjects=new Array();
var sheetCnt=0;
var prefix1="sheet1_";
var prefix2="sheet2_";
var prefix3="sheet3_";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
				switch(srcName) {
					case "btn_retrieve":
						if (validateForm(sheetObject,formObject,IBSEARCH)) {
							doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
						}
					break;
					case "btn_downexcel":
							doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
					break;
					case "btn_selectall":
							ComSetDisplay("btn_CheckAll",false);
							ComSetDisplay("btn_UnCheckAll",true);
						CellCheckAll(sheetObjects[0],true,prefix1+"chk");
					break;
					case "btn_CheckAll":
 						if (sheetObjects[0].RowCount() < 1) return;
						ComSetDisplay("btn_CheckAll",false);
						ComSetDisplay("btn_UnCheckAll",true);
						CellCheckAll(sheetObjects[0],1,prefix1+"chk");
					break; 
					case "btn_UnCheckAll":
						ComSetDisplay("btn_CheckAll",true);
						ComSetDisplay("btn_UnCheckAll",false);
						CellCheckAll(sheetObjects[0],0,prefix1+"chk");
					break;  
					case "btn_vvdassign":
						if (CheckRowGridBy0950(sheetObjects[0],prefix1+"chk")){ 
							var sRow=sheetObjects[0].FindCheckedRow(prefix1+ "chk");
						    var arrRow=sRow.split("|");
							if (arrRow.length == 0){
								ComShowCodeMessage("BKG00155"); 
								return;
							} 
						    var formerFlg="";
							var nextFlg="";
                            sheetObjects[1].RemoveAll();
							sheetObjects[2].RemoveAll();
							for(var i=0;i<arrRow.length;i++){
								var iRow=sheetObjects[1].DataInsert(-1);
								sheetObjects[1].SetCellValue(iRow,prefix2+"bkg_no",sheetObjects[0].GetCellValue(arrRow[i],prefix1+"bkg_no"));
								sheetObjects[1].SetCellValue(iRow,prefix2+"pol_cd",sheetObjects[0].GetCellValue(arrRow[i],prefix1+"pol_cd"));
								sheetObjects[1].SetCellValue(iRow,prefix2+"pod_cd",sheetObjects[0].GetCellValue(arrRow[i],prefix1+"pod_cd"));
								sheetObjects[1].SetCellValue(iRow,prefix2+"former_vvd",sheetObjects[0].GetCellValue(arrRow[i],prefix1+"former_vvd"));
								sheetObjects[1].SetCellValue(iRow,prefix2+"next_vvd",sheetObjects[0].GetCellValue(arrRow[i],prefix1+"next_vvd"));
								sheetObjects[1].SetCellValue(iRow,prefix2+"rownum",arrRow[i]);
								if(sheetObjects[0].GetCellValue(arrRow[i],prefix1+"former_vsl_pre_pst_cd")=="T"){
									formerFlg="Y";
								}
								if(sheetObjects[0].GetCellValue(arrRow[i],prefix1+"next_vsl_pre_pst_cd")=="T"){
									nextFlg="Y";
								}
							}
							var param="?formerTrnkFlg="+formerFlg;
							param+="&nextTrnkFlg="+nextFlg;
							param+="&pgmNo=ESM_BKG_1015";
							ComOpenPopup("/opuscntr/ESM_BKG_1015.do"+param, 320, 270, 'callback_0950', '0,1,1,1,1,1,1,1,1,1,1,1', true);
						}
					break;
					case "btn_duration":
						if(formObject.btn_duration.disabled)return;
						var cal=new ComCalendarFromTo();
						cal.select(formObject.dur_from, formObject.dur_to,'yyyy-MM-dd');
					break;
					case "btn_relay":
						if(formObject.btn_relay.disabled)return;
					    var param="?pgmNo=COM_ENS_051";
						ComOpenPopup("COM_ENS_051.do"+param, 800, 460,"setPolCd", "1,0,1,1,1", false);
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
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
        }	
		initDate(document.form);
		ComSetDisplay("btn_UnCheckAll",false);
//		axon_event.addListenerFormat('keypress','bkg0950_keypress',document.form); 
//		axon_event.addListenerForm  ('beforedeactivate', 'bkg0950_deactivate',  document.form);
//		axon_event.addListenerFormat('beforeactivate',   'bkg0950_activate',    document.form);
		//doActionIBSheet(sheetObjects[0],document.form,COMMAND02);
    }
	/*
	* remove Sheet screen Flashing
	*/
//no support[check again]CLT 	function sheet1_OnLoadFinish(sheetObj) {   
//		sheetObj.SetWaitImageVisible(0);
//		doActionIBSheet(sheetObj,document.form,COMMAND02);   
//		sheetObj.SetWaitImageVisible(1);
//	}   
	/**
	 * setting sheet initial values and header
	 * @param sheetObj
	 * @param sheetNo
	 * @return
	 */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetId=sheetObj.id;
        switch(sheetId) {
            case "sheet1":
                with(sheetObj){
                
		              var HeadTitle="|No.|Sel.|BKG No.|B/L No.|POL|POD|Former VVD|Lane|ETB|Relay|Yard|Next VVD|Lane|ETD|Yard|Special|||";
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"ibflag" },
		                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"seq" },
		                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"chk",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"pol_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"pod_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"former_vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"former_slan_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"etb",                   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"relay",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"former_yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"next_vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"next_slan_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"etd",                   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"next_yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"spcl",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"former_vsl_pre_pst_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"next_vsl_pre_pst_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"assign",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		              SetEditable(1);
		              SetImageList(0,"js/ibsheet/Main/popup.gif");
		              SetSheetHeight(480);
                    }
			break;
			 case "sheet2":
				    with(sheetObj){
					      var HeadTitle="|BKG No.|POL|POD|Former VVD|Next VVD|OLD VVD|";
		
					      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
					      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					      var headers = [ { Text:HeadTitle, Align:"Center"} ];
					      InitHeaders(headers, info);
		
					      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"ibflag" },
					             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"bkg_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"pol_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"pod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"former_vvd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"next_vvd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"old_vvd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"rownum",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					       
					      InitColumns(cols);
					      SetVisible(0);
					      SetEditable(1);
			            }
			break;
			case "sheet3":
			    with(sheetObj){
				      var HeadTitle="|BKG No.|POL|POD|Former VVD|Next VVD|OLD VVD|";
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"ibflag" },
				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix3+"bkg_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"pol_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"pod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix3+"former_vvd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix3+"next_vvd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix3+"old_vvd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix3+"rownum",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				       
				      InitColumns(cols);
				      SetVisible(0);
				      SetEditable(1);
		            }
			break;
        }
    }
    /**
     * handling sheet process
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return void
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
		var arrPreFix=sheetObj.id+"_"; 
        switch(sAction) {
          case IBSEARCH:      //retrieve

		       formObj.f_cmd.value=SEARCH;
			   var sXml=sheetObj.GetSearchData("ESM_BKG_0950GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
			   sheetObj.RenderSheet(0);
			   sheetObj.LoadSearchData(sXml,{Sync:0} );
			   sheetObj.RenderSheet(1);
			   //if (sheetObj.Rows>1)sheetObj.SelectRow =1;
            break;
		  case COMMAND02:			//Relay Port
				formObj.f_cmd.value=COMMAND02; 
				var params=FormQueryString(formObj);  
 				var sXml=sheetObj.GetSaveData("ESM_BKG_0950GS.do", params);
				 formObj.loc_cd.value=ComGetEtcData(sXml,"relayPort"); 
				break;
		  case IBDOWNEXCEL:     
			var rowSkip="";
			if (typeof(sheetObj.GetCellValue(i,arrPreFix+"chk").length) !="undefined"){
						rowSkip+=i;
					}else{
						rowSkip+=i+"|";
					}
			if(sheetObj.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{
				sheetObj.Down2Excel({ HiddenColumn:1,TreeLevel:false});
			}
 			
			break;
        	}	
        }
    
    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj=document.form;
		   sheetObj.RenderSheet(0);
		   for(var i=1; i<=sheetObj.RowCount();i++) {
			   if (!ComIsEmpty(sheetObj.GetCellValue(i,prefix1+"spcl"))){
					sheetObj.SetCellImage(i,prefix1+"spcl",0);
			   }
		   }
		   ComSetDisplay("btn_UnCheckAll",false);
		   ComClearObject(formObj.assignFlag);
		   sheetObj.SetSelectionMode(smSelectionList);
		   sheetObj.RenderSheet(1);
		   //if (sheetObj.Rows>1)sheetObj.SelectRow =1;
    }
    
    
    
    
    /**
     * handling process for input validation <br>
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return boolean
     */
    function validateForm(sheetObj,formObj,sAction) {
        with(formObj){
        	switch (sAction) {
	    		case IBSEARCH: {
					if(ComIsEmpty(loc_cd) || ((ComIsEmpty(dur_from)||ComIsEmpty(dur_to))&&ComIsEmpty(formerVVD))) {
						ComShowCodeMessage("BKG00704");
						return false;
					}
					if (ComGetDaysBetween(dur_from.value, dur_to.value) > 30) {
						ComShowCodeMessage("BKG00756", "Duration", "30Days");
						dur_from.focus();
						return false;
					}
					break;
	    		}
	    	}
        }
        return true;
    }
	/*
	* Relay Port Setting
	*/
	function setPolCd(aryPopupData) {
	   document.form.loc_cd.value=aryPopupData[0][3];
	}
	/*
	* calling Sheet onMouseUP
	*/
   function sheet1_OnMouseUp(sheetObj,Button, Shift, X, Y){ 
	var sRowStr=sheetObj.GetSelectionRows("/");
	  var arr=sRowStr.split("/");
	  if (Shift==1){
			  for (var i=0; i<arr.length; i++) {
				  if (sheetObj.ColSaveName(sheetObj.GetSelectCol()) !=prefix1+"chk" && sheetObj.GetCellValue(arr[i],prefix1+"chk")=="0"){
				sheetObj.SetCellValue(arr[i],prefix1+"chk","1",0);
				  }else if (sheetObj.ColSaveName(sheetObj.GetSelectCol()) !=prefix1+"chk" && sheetObj.GetCellValue(arr[i],prefix1+"chk")=="1"){
				sheetObj.SetCellValue(arr[i],prefix1+"chk","0",0);
			 }
		  }
	  }
	  /*else{
if (sheetObj.ColSaveName(sheetObj.GetSelectCol()) !=prefix1+"chk" && sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix1+"chk")=="0"){
			sheetObj.SetCellValue(sheetObj.GetSelectRow(),prefix1+"chk","1",0);
}else if (sheetObj.ColSaveName(sheetObj.GetSelectCol()) !=prefix1+"chk" && sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix1+"chk")=="1"){
			sheetObj.SetCellValue(sheetObj.GetSelectRow(),prefix1+"chk","0",0);
		}
	  }*/
   }
	/*
	* calling Sheet OnClick
	*/
	function sheet1_OnClick(sheetObj, row, col, value) {
		var col_name=sheetObj.ColSaveName(col);
		var formObject=document.form; 
		var param="";   
		if (col_name==prefix1+"spcl"){
			param="?bkg_no="+sheetObj.GetCellValue(row,prefix1+"bkg_no");
			switch(sheetObj.GetCellValue(row,col).toUpperCase()) {
				case "DG":
					param+="&pgmNo=ESM_BKG_0200";
					ComOpenWindowCenter("ESM_BKG_0200.do"+param, "popup0200" , 1050, 500, false);
				break;
				case "RF":
					param+="&pgmNo=ESM_BKG_0055";
					ComOpenWindowCenter("ESM_BKG_0055.do"+param, "popup0055" , 1050, 500, false);
				break;
				case "AK":
					param+="&pgmNo=ESM_BKG_0498";
					ComOpenWindowCenter("ESM_BKG_0498.do"+param, "popup0498" , 1050, 580, false);
				break;
				case "BB":
					param+="&pgmNo=ESM_BKG_0106";
					ComOpenWindowCenter("ESM_BKG_0106.do"+param, "popup0106" , 1050, 580, false);
				break;
			}
		} 
	}
	/**
      *  initializing date input form
      */
     function initDate(formObj){
    	 with(formObj){
    		 dur_from.value=ComGetDateAdd(ComGetNowInfo(),"D", -10);
    		 dur_to.value=ComGetNowInfo();
    	 }
     }
	 /*
	 * KeyPress Event handling
	 */
//    function bkg0950_keypress(){
//		obj=event.srcElement;
//	    if(obj.dataformat == null) return;
//	    window.defaultStatus=obj.dataformat; 
//	    switch(obj.dataformat){ 
//	        case "num": 
//	        	ComKeyOnlyNumber(event.srcElement);
//	            break;	 
//			 case "engup": 
//				 ComKeyOnlyAlphabet('uppernum'); 
//	            break; 
//	    }
//	}
	/*
	 * Activate Event handling
	 */
//	function bkg0950_activate(){
//    	//checking input Validation
//    	switch(ComGetEvent('name')){ 
//	    	case "dur_from":
//	    		ComClearSeparator(ComGetEvent());
//    			break;
//	    	case "dur_to":
//	    		ComClearSeparator(ComGetEvent());
//    			break; 
//    		default:
//    			break;
//    	}
//    }
	/*
	 * Deactivate Event handling
	 */
//	function bkg0950_deactivate(){ 
//    	switch(ComGetEvent('name')){ 
//	    	case "dur_from":
//	    		ComAddSeparator(ComGetEvent());
//    			break;
//	    	case "dur_to":
//	    		ComAddSeparator(ComGetEvent());
//    			break; 
//    		default:
//    			break; 
//    	}
//    }
	/*
	* handling CallBack after VVD Assign handling
	*/
	function callback_0950(){
		var formObject=document.form;  
		if (!ComIsEmpty(formObject.assignFlag)){
			formContrlEnabled(false);
			var State="";
			formObject.f_cmd.value=COMMAND01; 
		    var params=FormQueryString(formObject);
		    for(var iRow=1;iRow<=sheetObjects[1].RowCount();iRow++){	
               sheetObjects[2].RemoveAll();
			   sheetObjects[1].Copy2SheetCol(sheetObjects[2],"","",iRow,iRow,-1,2);	
			   sheetObjects[0].SelectCell(sheetObjects[2].GetCellValue(1,prefix3+"rownum"),prefix1+"chk");
			   var param=params + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true));
			   var sXml=sheetObjects[2].GetSaveData("ESM_BKG_0950GS.do", param);
			   State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
               if(State == "S"){
            	   if (ComIsEmpty(sheetObjects[0].GetCellValue(sheetObjects[2].GetCellValue(1,prefix3+"rownum"),prefix1+"assignFlag"))){
						sheetObjects[0].GetRowFontColor(sheetObjects[2].SetCellValue(1,prefix3+"rownum"),"#0033FF");
						sheetObjects[0].GetCellFont("FontBold",sheetObjects[2].SetCellValue(1,prefix3+"rownum"),3,sheetObjects[2].GetCellValue(1,prefix3+"rownum"),14,1);
						sheetObjects[0].SetCellValue(sheetObjects[2].GetCellValue(1,prefix3+"rownum"),prefix1+"assign","T",0);
				    }else{
						sheetObjects[0].GetRowFontColor(sheetObjects[2].SetCellValue(1,prefix3+"rownum"),"#000000");
						sheetObjects[0].GetCellFont("FontBold",sheetObjects[2].SetCellValue(1,prefix3+"rownum"),3,sheetObjects[2].GetCellValue(1,prefix3+"rownum"),14,0);
						sheetObjects[0].SetCellValue(sheetObjects[2].GetCellValue(1,prefix3+"rownum"),prefix1+"assign","",0);
					}
			   }else{
				    sheetObjects[2].LoadSearchData(sXml,{Sync:0} );
					break;
			   } 
			}
			if(State == "S"){
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
			}
			formContrlEnabled(true);
		}
	}
	/*
	* control-related objects form
	*/
	function formContrlEnabled(flag){
		var objs=document.form;  
		sheetObjects[1].SetEnable(flag);
		for(var i=0;i<objs.length; i++) { 
			if(objs[i].getAttribute("classid")==null){
				 try {
					switch( objs[i].getAttribute("type") ) { 
						case "text" :
							 objs[i].readOnly=!flag;
							  if (!flag){
								objs[i].style.background="#E8E7EC";
							  }else{
								if(objs[i].name=="loc_cd" || objs[i].name=="loc_yd_cd"
								   ||objs[i].name=="dur_from"||objs[i].name=="dur_to"
								){
									objs[i].style.background="#CCFFFD";
								}else{
									objs[i].style.background="white";
								}
							  }
							 break;
						default:
					} // end switch
				} catch(err) { alert(err.message); }
			} 
		}
		if (flag){
			ComBtnEnable("btn_vvdassign");
			ComBtnEnable("btn_downexcel");
//			ComBtnEnable("btn_retrieve");
			ComBtnEnable("btn_CheckAll");
			ComBtnEnable("btn_UnCheckAll");
			objs.btn_relay.disabled=!flag;
			objs.btn_duration.disabled=!flag;
		}else{
			ComBtnDisable("btn_vvdassign");
			ComBtnDisable("btn_downexcel");
//			ComBtnDisable("btn_retrieve");
			ComBtnDisable("btn_CheckAll");
			ComBtnDisable("btn_UnCheckAll");
			objs.btn_relay.disabled=flag;
			objs.btn_duration.disabled=flag;
		}
	}
	
	function CheckRowGridBy0950(sheetObject,prefix){
        var iCheckRow=sheetObject.FindCheckedRow(prefix);
        if (iCheckRow < 1) {
             ComShowCodeMessage("BKG00155");
            return false;
        }
        return true;
    }
