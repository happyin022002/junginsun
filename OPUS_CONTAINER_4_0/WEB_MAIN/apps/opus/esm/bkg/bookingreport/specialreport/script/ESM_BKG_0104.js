/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0104.js
*@FileTitle  : Report Template
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/10
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @fileoverview business script for esm_bkg_0104
     * @author 
     * @extends 
     * @class esm_bkg_0104  
     */
   	/* developer's work*/
     /**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
 // global variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 var prefix="";//IBSheet divider
 /*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt=0;
 	var comboObjects=new Array();
 /*********************** EDTITABLE MULIT COMBO END ********************/
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
	 	    setItemOptionHidden();//Item Option Hidden 
		    initControl();
		  //to prevent fail to load screen, give delay time 0.1 second
		    //setTimeout(function () { doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); },100);
	 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		    //form.cust_cnt_cd.focus();
	 		
	 		document.form.p_bkg_rpt_knd_cd.disabled = true;				//20150326.ADD
     }
    function initControl() {
    	var formObject=document.form;
//        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- keyboard
        axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- out of focus     
//        axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- focus in
//        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerForm ('change', 'bkg_change', formObject);
    }        
    function bkg_change(){   	
	    switch (ComGetEvent("name")) {
	    	case "p_bkg_rpt_knd_cd":
    			setItemOptionHidden();
					break;
				default:
					break;
	    }
	    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    /*
     *  if Report Kind is the Booking Status Report , Item Option should be hidden.  searching column is fixed 
     */ 
    function setItemOptionHidden(){    	//SJH.20150303.ADD
    	if(document.form.p_bkg_rpt_knd_cd.value =="B"||document.form.p_bkg_rpt_knd_cd.value =="V"){
			sheetObjects[0].SetColHidden(prefix + "search_option", false);
		}	else{
			sheetObjects[0].SetColHidden(prefix + "search_option", true);
    	}
    }   	
     /*
      * after searching if Type is Common and Shared, Editable = false; 
      */ 
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
      with (sheetObj) {
      		var blueColor="#0000FF";
   				var type_gubun;
	      	for (var i=HeaderRows(); i < GetTotalRows() + HeaderRows(); i++) {
	      		type_gubun=GetCellValue(i, prefix+"type_gubun");
		      		if( type_gubun == 'C' ){ // 'P'- Private , 'S' - Shared
		      			SetRowEditable(i,0);
		      		}else{
		      			sheetObj.SetCellFontColor(i,prefix+"type_nm",blueColor);
		      			sheetObj.SetCellFontUnderline(i,prefix+"type_nm",1);
		      			if( type_gubun == 'S' ){ // shared - cannot delete
		      				SetRowEditable(i,0);
		      				SetCellEditable(i,prefix+"vis_flg",1);
		      			}
		      		}
		      		// View is not available when Report Type is General(Awkward) or General(Break Bulk) or General(Dangerous) or General(Reefer) or General.
		      		if(document.form.p_bkg_rpt_knd_cd.value == "B" && (sheetObj.GetCellValue(i,prefix+"rpt_id") == "RTMBB00006" || sheetObj.GetCellValue(i,prefix+"rpt_id") == "RTMBB00004" 
		      			|| sheetObj.GetCellValue(i,prefix+"rpt_id") == "RTMBB00005" || sheetObj.GetCellValue(i,prefix+"rpt_id") == "RTMBB00007"|| sheetObj.GetCellValue(i,prefix+"rpt_id") == "RTMBB00002" )){
		      			sheetObj.SetCellValue(i,prefix+"search_option","");
		      			sheetObj.SetCellValue(i,prefix+"item_option","");
		      		}
	      			sheetObj.SetCellFontColor(i,prefix+"search_option",blueColor);
	      			sheetObj.SetCellFontUnderline(i,prefix+"search_option",1);
	      			sheetObj.SetCellFontColor(i,prefix+"item_option",blueColor);
	      			sheetObj.SetCellFontUnderline(i,prefix+"item_option",1);
	      	}
    	 }
     }
		/*
		 *  Search Option or Item Option Modify
		 * */
     function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
    	 if(sheetObj.GetCellValue(rowIdx, prefix+"ibflag") =="D" || sheetObj.GetCellValue(rowIdx, prefix+"ibflag") =="I") return;
    	 // Not allowed to link in case of General(Specail Cargo)
    	 if(sheetObj.GetCellValue(rowIdx, prefix+"search_option") == "" || sheetObj.GetCellValue(rowIdx, prefix+"item_option") == "") return;
     		if( colIdx == sheetObj.SaveNameCol(prefix + 	"type_nm") && sheetObj.GetCellValue(rowIdx, prefix+"type_nm") != "Common"){
						//if(sheetObj.CellValue(rowIdx, prefix+"ibflag") == 'I' || sheetObj.CellValue(rowIdx, prefix+"type_gubun") !="P") return;
     			var param="?rpt_id="+sheetObj.GetCellValue(rowIdx, prefix+"rpt_id")+"&bkg_rpt_knd_cd="+form.p_bkg_rpt_knd_cd.value;
     			if(sheetObj.GetCellValue(rowIdx, prefix+"ibflag") == 'I' || sheetObj.GetCellValue(rowIdx, prefix+"type_gubun") !="P"){
								param += "&edit_yn=N"; 
							}
						ComOpenPopup('/opuscntr/ESM_BKG_0896.do'+param, 450, 300, '', '0,1,1,1,1,1,1,1,1,1', false,false,0,0,0,"Shared");			
     		}else if( colIdx == sheetObj.SaveNameCol(prefix + 	"search_option")){
     					//if(sheetObj.CellValue(rowIdx, prefix+"type_gubun") =="C" || sheetObj.CellValue(rowIdx, prefix+"type_gubun") =="S") return;
     					selectedIndex=rowIdx;
     					var param="?rpt_nm="+sheetObj.GetCellValue(rowIdx, prefix+"rpt_nm")+"&rpt_index="+rowIdx;
     					if(sheetObj.GetCellValue(rowIdx, prefix+"type_gubun") =="C" || sheetObj.GetCellValue(rowIdx, prefix+"type_gubun") =="S"){
								param += "&edit_yn=N"; 
							}
						if(form.p_bkg_rpt_knd_cd.value == "V"){
 							ComOpenPopup('/opuscntr/ESM_BKG_0104_02.do'+param, 1148, 265, '', '1,0,1,1,1,1,1,1,1,1', false,false,0,0,0,"Search Option");
						}else if(form.p_bkg_rpt_knd_cd.value == "B"){
 							ComOpenPopup('/opuscntr/ESM_BKG_0104_01.do'+param, 1148, 640, '', '1,0,1,1,1,1,1,1,1,1', false,false,0,0,0,"Search Option");
						}
     			}	else if( colIdx == sheetObj.SaveNameCol(prefix + 	"item_option")){
							//if(sheetObj.CellValue(rowIdx, prefix+"type_gubun") =="C" || sheetObj.CellValue(rowIdx, prefix+"type_gubun") =="S")return;
						selectedIndex=rowIdx;
						var param="?rpt_id="+sheetObj.GetCellValue(rowIdx, prefix+"rpt_id")+"&bkg_rpt_knd_cd="+form.p_bkg_rpt_knd_cd.value;
						if(sheetObj.GetCellValue(rowIdx, prefix+"type_gubun") =="C" || sheetObj.GetCellValue(rowIdx, prefix+"type_gubun") =="S"){
							param += "&edit_yn=N"; 
							}
						ComOpenPopup('/opuscntr/ESM_BKG_0895.do'+param, 900, 640, '', '1,0', false,false,0,0,0,"Item Option");
     		}
     }				
  var selectedIndex;//selected Row Index
  /*
   *  setting condition for searching which is changed at pop up 
   * */
	function setSearchOption(str){
		if(selectedIndex == null){
			return;
		}
		var temp;
		sheetObjects[0].SetCellValue(selectedIndex, prefix + 	"bzc_cond_sql_ctnt",str);
		temp=sheetObjects[0].GetCellValue(selectedIndex, prefix + 	"bzc_cond_sql_ctnt");
	}
  /*
   * saving condition for searching which is changed at pop up
   * */
 function setSearchSaveOption(){
     var sheetObject1=sheetObjects[0];
	 var formObject=document.form;
	 	doActionIBSheet(sheetObject1,formObject,IBSAVE);
		if(opener == null || opener == undefined) return;	 					
		opener.location.reload(true);
 }
 function setTemplate(returnVal){
 		if(selectedIndex == null){
			return;
		}
		var temp="";
		sheetObjects[0].SetCellValue(selectedIndex, prefix + 	"modified_col_nm",returnVal);
		temp=sheetObjects[0].GetCellValue(selectedIndex, prefix + 	"modified_col_nm");
 }
/*********************** KEY EVENT END ********************/
// Event handler processing by button click event */
 		document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /***** using extra sheet valuable if there are more 2 sheets *****/
          var sheetObject1=sheetObjects[0];
					var comboObject1=comboObjects[0]; 
          /*******************************************************/
          var formObject=document.form;
	     	//try {
	     		var srcName=ComGetEvent("name");
		 			switch(srcName) {
		 				case "btn_Retrieve":
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;
		 				case "btn_Save":
		 					saveValidFlag=true; //initializing validation
		 					doActionIBSheet(sheetObject1,formObject,IBSAVE);
		 					break;
		 				case "btn_RowAdd":
		 					var addRow=sheetObject1.RowCount()+1;
			        // adding data row 
		 					var row=sheetObject1.DataInsert(addRow);
		 					sheetObject1.SetCellValue(row, prefix+"vis_flg",'Y');
		 					break;
		 				case "btn_RowDelete":
		 					ComRowHideDelete(sheetObject1,prefix+"del_chk");
		 					break;
		 				case "btn_New":
		 					form.reset();
		 					sheetObject1.RemoveAll();
		 					break;
		 				case "btn_DownExcel":
		 					
		 					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
		 					break;
		 				case "btn_Close":
							if(opener != undefined ){
								//opener.setParent();
							}		 				
								ComClosePopup(); 
		 					break;
		        } // end switch
//	     	}catch(e) {
//		     		if( e == "[object Error]") {
//		    			ComShowMessage(OBJECT_ERROR);
//		    		} else {
//		    			ComShowMessage(e);
//		    		}
//	     	}
    }
   // handling of Sheet 
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
 			case IBSEARCH:      
 				if(!validateForm(sheetObj,formObj,sAction)) return;
	 				formObj.f_cmd.value=SEARCH;
					var sXml = sheetObj.DoSearch("ESM_BKG_0104GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix) );
				break;
 			case SEARCH01:      
				break;
			case IBSEARCHAPPEND:  
			case IBINSERT:     				
				//sheetObj.DataInsert(-1);
				var Row=sheetObj.DataInsert(-1);
				//sheetObj.CellValue2(Row, prefix + "type_nm") = "Private";
				sheetObj.SetCellValue(Row, prefix + "search_option","Modify",0);
				sheetObj.SetCellValue(Row, prefix + "item_option","Modify",0);
				break;
			case IBSAVE:        
 				formObj.f_cmd.value=MULTI;
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				var sParam=sheetObj.GetSaveString();
				if (!sheetObj.IsDataModified()&& sParam == "")	return;
				sParam += "&" + FormQueryString(formObj);
				var sXml=sheetObj.GetSaveData("ESM_BKG_0104GS.do" , sParam);
				sheetObj.LoadSaveData(sXml);
				//window.returnValue = true;
			break;									
         }
     }
		 /**
     * calling function when OnSaveEnd is called <br>
     *  showing message of finishing to save <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg  message from server
     * @return 
     * @version 2009.05.17
     */ 	
		function sheet1_OnSaveEnd(sheetObj, Code, ErrMsg)  {
	 		var formObject=document.form;
	 		if (ErrMsg == "") {
				ComBkgSaveCompleted();
				opener.location.reload(true);
				sheetObj.RemoveAll();
				doActionIBSheet(sheetObj,formObject,IBSEARCH);
			}
		}    
 /*
  * handling paging
  * */
   function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
  }    
   /*
    * checking duplication of Report Name 
    * */
     function isRptNameDup(rowIdx,p_rpt_nm){
				with (sheetObjects[0]) {
	   				var rpt_nm;
		      	for (var i=HeaderRows(); i < HeaderRows()+RowCount()  ; i++) {
		      			if(rowIdx == i) continue;
		      			if(GetCellValue(i, prefix+"ibflag") == 'D')	continue;
		      			rpt_nm=GetCellValue(i, prefix+"rpt_nm");
			      		if( rpt_nm == p_rpt_nm ){
			      			return true;
			      		}
		      	}
	    	 } 
	    	return false;    			
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSEARCH:
	  			break;
    		case IBSAVE:
	    		with (sheetObj) {
    			for (var i=HeaderRows(); i < HeaderRows()+RowCount()  ; i++) {
    				if(GetCellValue(i, prefix+"ibflag") == 'R' || GetCellValue(i, prefix+"ibflag") == 'D')	continue;
    				if(GetCellValue(i, prefix + "rpt_nm")==""){
									ComShowCodeMessage("BKG03035", "Report Name"); 
		              sheetObj.SelectCell(i, prefix + 	"rpt_nm");
									return false;
    			}else	if (isRptNameDup(i,GetCellValue(i,prefix + "rpt_nm")))  {
    				ComShowCodeMessage("BKG03064",GetCellValue(i,prefix + "rpt_nm"));
		              sheetObj.SelectCell(i, prefix + 	"rpt_nm");
									return false;
								}
			      	}//end for
		    	 } //end with(sheetObject[0])
	  			break;
    	 }
         return true;
     }
 /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetObj.id) {
            case "sheet1":
              with (sheetObj) {
              
		                var HeadTitle1="ibflag|rpt_id|type gubun|sel col_nm|modi col_nm|sql ctnt| Del. |Report Name|Type|Display|Search Option|Item Option";
		                var headCount=ComCountHeadTitle(HeadTitle1);
		//                (headCount, 0, 0, true);
		
		                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		                InitHeaders(headers, info);
		
		                var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			                          {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rpt_id" },
			                          {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"type_gubun" },
			                          {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"selected_col_nm" },
			                          {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"modified_col_nm" },
			                          {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bzc_cond_sql_ctnt" },
			                          {Type:"DelCheck",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk", UpdateEdit:1,   InsertEdit:1 },
			                          {Type:"Text",      Hidden:0,  Width:210,  Align:"Left",    ColMerge:0,   SaveName:prefix+"rpt_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
			                          {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:0,   SaveName:prefix+"type_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                          {Type:"CheckBox",  Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vis_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 , TrueValue: "Y", FalseValue: "N"},
			                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"search_option",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                          {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"item_option",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		                 
		                InitColumns(cols);
		
		                SetEditable(1);
		                SetSheetHeight(282);
		       
				}
			break;
         }
     }
      /* version up 2010.1.22 */
	/* the end of developer's work */    
