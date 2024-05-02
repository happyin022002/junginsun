/*=========================================================
** 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0003_01.js
*@FileTitle  :  S/C Proposal Org/Dst Location Information - Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/04
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 // global variables
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1;
 var sheetObjects=new Array();
 var sheetCnt=0;
 var tabLoad=new Array();
 tabLoad[0]=0;
 tabLoad[1]=0;
 //Event handler processing by button click event */
 document.onclick=processButtonClick;
 /**
  * Event handler processing by button name  <br>
  */
     function processButtonClick(){
          var sheetObject1=sheetObjects[0];
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
 				case "btn_retrieve":
 					if(validateForm(sheetObject1,formObject,IBSEARCH)) {
 						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
 					} 
					break;
 				case "btn_save":
 					if(validateForm(sheetObject1,formObject,IBSAVE)) {
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
					}
					break;
 				case "btn_acceptall":
 					if(validateForm(sheetObject1,formObject,MODIFY01)) {
						doActionIBSheet(sheetObject1,formObject,MODIFY01);
					}
 					break;
 				case "btn_cancelall":
 					if(validateForm(sheetObject1,formObject,MODIFY02)) {
						doActionIBSheet(sheetObject1,formObject,MODIFY02);
					}
 					break;
 				case "btn_rowadd":
 					if(validateForm(sheetObject1,formObject,IBINSERT)) {
 						doActionIBSheet(sheetObject1,formObject,IBINSERT);
					}
					break;
 				case "btn_delete":
 					if(validateForm(sheetObject1,formObject,IBDELETE)) {
						doActionIBSheet(sheetObject1,formObject,IBDELETE);
					}
 					break;	
 				case "btn_amend":
 					if(validateForm(sheetObject1,formObject,COMMAND01)) {
						doActionIBSheet(sheetObject1,formObject,COMMAND01);
					}
 					break;
 				case "btn_amendcancel":
 					if(validateForm(sheetObject1,formObject,COMMAND02)) {
						doActionIBSheet(sheetObject1,formObject,COMMAND02);
					}
 					break;
 				case "btn_accept":
 					if(validateForm(sheetObject1,formObject,MODIFY03)) {
 						doActionIBSheet(sheetObject1,document.form,MODIFY03);
 					}
 					break;
 				case "btn_acceptcancel":
 					if(validateForm(sheetObject1,formObject,MODIFY04)) {
 						doActionIBSheet(sheetObject1,document.form,MODIFY04);
 					}
 					break;
             } // end switch
     	}catch(e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
     	}
     }
     /**
      * registering IBSheet Object as list <br>
      * adding process for list in case of needing batch processing with other items  <br>
      * defining list on the top of source <br>
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * Initializing and setting Sheet basics <br>
      * Setting body tag's onLoad event handler <br>
      * Adding pre-handling function after loading screen on the browser  <br>
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         resizeSheet();
         initControl();         
         buttonControl();
         parent.loadTabPage();
     }
     /**
      * setting sheet initial values and header <br>
      * adding case as numbers of counting sheets <br>
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 		 var sheetID=sheetObj.id;
         switch(sheetID) {
             case "sheet1":
            	    with(sheetObj){
		                 
		               var HeadTitle="|Sel.|Seq.|amdt_seq|rout_pnt_seq|Location Type|Location Code|Description|EFF Date|EXP Date|Source|Status" +
		               "|1|2|3|4|5|6";
		               var headCount=ComCountHeadTitle(HeadTitle);
		               (headCount, 0, 0, true);
		
		               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		               var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                      {Type:"DummyCheck", Hidden:0, Width:40,  Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                      {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq" },
		                      {Type:"Combo",     Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, ComboText:LOCATION_TYPE1[1], ComboCode:LOCATION_TYPE1[0]},
		                      {Type:"PopupEdit", Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		                      {Type:"Text",      Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Date",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Date",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ComboText:srcInfoCdComboText, ComboCode:srcInfoCdComboValue},
		                      {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ComboText:prcProgStsCdComboText, ComboCode:prcProgStsCdComboValue},
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd" },
		                      {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"src_info_dtl" },
		                      {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_dtl" },
		                      {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" } ];
		                
		               InitColumns(cols);
		               SetColProperty(0 ,"rout_pnt_loc_def_cd" 	, {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});		               
		               SetWaitImageVisible(0);
		               SetShowButtonImage(2);
		               resizeSheet(); //SetSheetHeight(280);
               }
                 break;
             case "sheet2":
                 with(sheetObj){
			                 
			              var HeadTitle="1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16";
			              var headCount=ComCountHeadTitle(HeadTitle);
			              (headCount, 0, 0, true);
			
			              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			
			              var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			              var headers = [ { Text:HeadTitle, Align:"Center"} ];
			              InitHeaders(headers, info);
			
			              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                  {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			                  {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd" },
			                  {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd" },
			                  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd" },
			                  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
			                  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
			                  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
			                  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" },
			                  {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"org_src_info_cd" },
			                  {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"org_prc_prog_sts_cd" },
			                  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"org_tp_cd" },
			                  {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"dest_src_info_cd" },
			                  {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dest_prc_prog_sts_cd" },
			                  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dest_tp_cd" } ];
			               
			              InitColumns(cols);
			              SetWaitImageVisible(0);
			              SetSheetHeight(270);
			              SetVisible(0);

                       }
                 break;
         }
     }
     
     function resizeSheet() {
  	   	ComResizeSheet(sheetObjects[0]);
  	  }
     
     /**
      * Handling sheet process <br>
      */
     function doActionIBSheet(sheetObj,formObj,sAction) {
    	 try{
	         switch(sAction) {
		         case IBSEARCH_ASYNC01: 
		  			ComOpenWait(true);
		        	 //1) calling from tabLoadSheet() when selecting TAB
		        	 //2) checking data existence when opening
		  			 //3)DEFAULT ROUTE TYPE is ORIGIN but selecting DESTINATION in case of DESTINATION only exist
		        	formObj.f_cmd.value=SEARCH02;	 	        
		        	var sXml=sheetObjects[1].GetSearchData("ESM_PRI_0003_01GS.do" , FormQueryString(formObj));
					var arrData=ComPriXml2Array(sXml, "org_tp_cd|dest_tp_cd");
					if(arrData != null && arrData.length > 0) {
						if(arrData[0][0] == "" && arrData[0][1] == "D" ) {
							formObj.org_dest_tp_cd[1].checked=true;
						} else {
							formObj.org_dest_tp_cd[0].checked=true;
						}
					}
					break;
		        case IBSEARCH: // retrieve
	  				ComOpenWait(true);
		        	//1) for setting ROUTE TYPE style (color, bold)
		        	//2) retrieve
			        formObj.f_cmd.value=SEARCH;
		     		var sParam=FormQueryString(formObj);
		     		var sXml=sheetObj.GetSearchData("ESM_PRI_0003_01GS.do" , sParam);
					var arrXml=sXml.split("|$$|");
					if ( arrXml[0] != null) {
						var arrData=ComPriXml2Array(arrXml[0], "org_src_info_cd|org_prc_prog_sts_cd|org_tp_cd|dest_src_info_cd|dest_prc_prog_sts_cd|dest_tp_cd");
						manageRouteRadioButton(arrData);
					}
					if ( arrXml[1] != null) {
						sheetObjects[0].LoadSearchData(arrXml[1],{Sync:0} );
					}
					buttonControl();
					break;
	 			case IBSAVE:        //save
		  			formObj.f_cmd.value=MULTI;
	  				var sParam=FormQueryString(formObj);
	  				var sParamSheet=sheetObj.GetSaveString();
	  				if (sParamSheet != "") {
	  					sParam=ComPriSetPrifix(sParamSheet, "") + "&" + sParam;
	  				} else {
	  				    return false;
	  				}
	  				if (!ComPriConfirmSave()) {
	  					return false;
	  				}
	  				ComOpenWait(true);
	  				var sXml=sheetObj.GetSaveData("ESM_PRI_0003_01GS.do", sParam);
					//1) for setting ROUTE TYPE style (color, bold)
	  				//2) calling before showing data save successful message
					searchRouteTypeColor();
					sheetObj.LoadSaveData(sXml);
					doActionIBSheet( sheetObj , formObj , IBSEARCH );
	  				buttonControl();
					break;
	 			case IBINSERT:       // Row Add				
		 			var prop_no=formObj.prop_no.value;
					var amdt_seq=formObj.amdt_seq.value; 
					var svc_scp_cd=formObj.svc_scp_cd.value;
					var eff_dt=formObj.eff_dt.value;
					var exp_dt=formObj.exp_dt.value;
					if(amdt_seq == 0){
						var rowCnt = sheetObj.RowCount();
						var idx=sheetObj.DataInsert(rowCnt+1);
						sheetObj.SetCellValue(idx, "org_dest_tp_cd",ComGetObjValue(formObj.org_dest_tp_cd),0);
						sheetObj.SetCellValue(idx, "prop_no",prop_no,0);
						sheetObj.SetCellValue(idx, "svc_scp_cd",svc_scp_cd,0);
						sheetObj.SetCellValue(idx, "amdt_seq",amdt_seq,0);
						sheetObj.SetCellValue(idx, "eff_dt",eff_dt,0);
						sheetObj.SetCellValue(idx, "exp_dt",exp_dt,0);
						sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",amdt_seq,0);
						sheetObj.SetCellValue(idx, "rout_pnt_seq",parseInt(ComPriGetMax(sheetObj, "rout_pnt_seq"))+ 1,0);
						sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I",0);
						sheetObj.SetCellValue(idx, "src_info_cd","NW",0);
						sheetObj.SelectCell(idx, "rout_pnt_loc_def_cd");
					}else{
						if(sheetObj.SearchRows()!=0 && sheetObj.GetCellValue(sheetObj.GetSelectRow(),"amdt_seq")!= amdt_seq ){
							ComShowCodeMessage("PRI01002");		
						 	return;
						}							
						var idx=sheetObj.DataInsert();	   // new row
						sheetObj.SetCellValue(idx, "org_dest_tp_cd",ComGetObjValue(formObj.org_dest_tp_cd),0);
						sheetObj.SetCellValue(idx, "prop_no",prop_no,0);
						sheetObj.SetCellValue(idx, "svc_scp_cd",svc_scp_cd,0);
						sheetObj.SetCellValue(idx, "amdt_seq",amdt_seq,0);
						sheetObj.SetCellValue(idx, "eff_dt",eff_dt,0);
						sheetObj.SetCellValue(idx, "exp_dt",exp_dt,0);
						sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",amdt_seq,0);
						sheetObj.SetCellValue(idx, "rout_pnt_seq",parseInt(ComPriGetMax(sheetObj, "rout_pnt_seq"))+ 1,0);
						sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I",0);
						sheetObj.SetCellValue(idx, "src_info_cd","NW",0);
						sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#FF0000");
						sheetObj.SelectCell(idx, "rout_pnt_loc_def_cd");
					}
	    			// hilighting
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
					break;
	 			case IBDELETE: // Delete
		 			var eff_dt=formObj.eff_dt.value;
					var amdt_seq=formObj.amdt_seq.value;
					var chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
					if(chkArr.length == 0){
						sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
					}	
					chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
					for(var i=0;i < chkArr.length;i++){
						if(sheetObj.GetCellValue(chkArr[i],"amdt_seq")!=amdt_seq
								||(sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq")==amdt_seq
										&& (sheetObj.GetCellValue(chkArr[i],"src_info_cd")=="AM" || sheetObj.GetCellValue(chkArr[i],"src_info_cd")=="AD" || sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd")!="I"))){
							ComShowCodeMessage("PRI01002");
							return;
						}
					}
					var sRow=0;				
					for(var j=0;j < chkArr.length;j++){
						if(sheetObj.GetCellValue(Number(chkArr[j])+sRow, "n1st_cmnc_amdt_seq")!= amdt_seq){
							comSheetAmendRow(sheetObj,formObj,Number(chkArr[j])+sRow,"D","rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd");			
							sRow++;								
						}
					}
					deleteRowCheck(sheetObj, "chk");
					break;
	 			case MODIFY01: // Accept All
		 			if(ComShowCodeConfirm("PRI01015")) {
						formObj.f_cmd.value=MULTI02;	
						//1)using extra function for setting ROUTE TYPE color
						//2)first, coloring and calling  ACCEPT message
						comSheetAcceptCheckedRowsRoute(sheetObj,document.form,true);
		 			}
					break;
	 			case MODIFY02: // Cancel All
		 			if(ComShowCodeConfirm("PRI01010")) {
						formObj.f_cmd.value=MULTI03;
						//1)using extra function for setting ROUTE TYPE color
						//2)first, coloring and calling  ACCEPT message
						comSheetAcceptCancelCheckedRowsRoute(sheetObjects[0],document.form,true);
		 			}
					break;		
	 	      	case MODIFY03: // Accept
	 	      		if(ComShowCodeConfirm("PRI00008")) {
		 				formObj.f_cmd.value=MULTI04;
						//1)using extra function for setting ROUTE TYPE color
						//2)first, coloring and calling  ACCEPT message
		 				comSheetAcceptCheckedRowsRoute(sheetObjects[0],document.form,false);
	 	      		}
	 				break;
	 	      	case MODIFY04: // Accept Cancel
		 	      	if(ComShowCodeConfirm("PRI00009")) {
						formObj.f_cmd.value=MULTI05;
						//1)using extra function for setting ROUTE TYPE color
						//2)first, coloring and calling  ACCEPT message
						comSheetAcceptCancelCheckedRowsRoute(sheetObjects[0],document.form,false);
		 	      	}
					break;			
				case COMMAND01: // Amend
					var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
					if(chkArr.length > 0){
						if(chkArr.length > 1){					
							ComShowCodeMessage("PRI00310");
						}else{			
							comSheetAmendRow(sheetObj,formObj,chkArr[0],"M","rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd");
						}
					}else{ 
						comSheetAmendRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M","rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd");
					}
					sheetObj.SelectCell(sheetObj.GetSelectRow(), "rout_pnt_loc_def_cd");
					break;		
				case COMMAND02: // Amend Cancel
					var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
					if(chkArr.length > 0){
						if(chkArr.length > 1){					
							ComShowCodeMessage("PRI00310");
						}else{
							comSheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", "rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd");
							setEditableFlag(sheetObj,chkArr[0],"rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd");
						}
					}else{ 
						comSheetAmendCancelRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M", "rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd");
						setEditableFlag(sheetObj,sheetObj.GetSelectRow(),"rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd");
					}
					break;
	         }
    	 }catch(e){
    		 if (e == "[object Error]") {
    			 ComShowMessage(OBJECT_ERROR);
    		 } else {
    			 ComShowMessage(e.message);
    		 }
    	 }finally {
    		 ComOpenWait(false);
    	 }
     }
   /**
  	* registering IBTab Object as array <br>
  	* adding process for list in case of needing batch processing with other items  <br>
  	* defining list on the top of source <br>
  	*/
     function setEditableFlag(sheetObj,sRow,sCols){
    	 var arrCols=sCols.split("|");    	          
         for(var i=0;arrCols != null && i<arrCols.length;i++){
             sheetObj.SetCellEditable(sRow, arrCols[i],0);
         }
     }
   /**
	* registering IBTab Object as array <br>
	* adding process for list in case of needing batch processing with other items  <br>
	* defining list on the top of source <br>
	*/
     function setTabObject(tab_obj){
         tabObjects[tabCnt++]=tab_obj;
     }
      /**
       * checking validation process of inputed form data <br>
       */
      function validateForm(sheetObj,formObj,sAction){
   		switch (sAction) {
  		case IBSEARCH: // retrieve		
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
  			break;
  		case IBSAVE: // save
			if (sheetObjects[0].IsDataModified()&& sheetObjects[0].GetSaveString() == "") {
				return false;
			}
            if (sheetObjects[0].IsDataModified()) {
                var dupRow=ComPriAmendDupCheck(sheetObjects[0], "rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd|n1st_cmnc_amdt_seq", formObj.amdt_seq.value);
                if (dupRow >= 0) {
                    sheetObjects[0].SetSelectRow(dupRow);
                     ComShowCodeMessage("PRI00302");
                     return false;
                }
            } else {   
                ComShowCodeMessage("PRI00301");
                return false;
            }
  			break;
  		case IBINSERT: // Row Add
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
  			break;
  		case IBDELETE: // Delete  	
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
  			break;
  		case MODIFY01: // Accept All
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
  			if (getValidRowCount(sheetObj) <= 0) {
                return false;
  			}
			break;
  		case MODIFY02: // Cancel
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
  			if (getValidRowCount(sheetObj) <= 0) {
	            return false;
			}
			break;	
		case MODIFY03: // Accept
			var chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
			if(chkArr.length == 0){
				if(formObj.amdt_seq.value != sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
				sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
			}	
			chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
			for(var i=0;i < chkArr.length;i++){
				if(formObj.amdt_seq.value != sheetObj.GetCellValue(chkArr[i], "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
				if(sheetObj.GetCellValue(chkArr[i], "prc_prog_sts_cd") == "A") {
					ComShowCodeMessage("PRI01037");
					return false;
				}
			}
			break;
		case MODIFY04: // Accept cancel
			var chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
			if(chkArr.length == 0){
				if(formObj.amdt_seq.value != sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
				sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
			}	
			chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
			for(var i=0;i < chkArr.length;i++){
				if(formObj.amdt_seq.value != sheetObj.GetCellValue(chkArr[i], "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
				if(sheetObj.GetCellValue(chkArr[i], "prc_prog_sts_cd") == "I") {
					ComShowCodeMessage("PRI01038");
					return false;
				}
			}
			break;	
  		case COMMAND01: // Amend	
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}			
			break;
  		case COMMAND02: // Amend Cancel	
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}			
			break;
  		}     
        return true;
      }
       /**
    	 * loading HTML Control event in the page <br>
    	 * initializing IBSheet Object calling from {@link #loadPage} function <br>
    	 **/
    	function initControl() {    
    		axon_event.addListenerForm  ('click', 'obj_OnClick', form); 
    	}
	    /**
    	 * checking validation on HTML Control's onClick event <br>
    	 **/
	   	function obj_OnClick(){
	   		var sheetObj=sheetObjects[0];
	   		var formObj=document.form;
	   		if (ComGetEvent("name") == "org_dest_tp_cd") {
	   			if (sheetObj.IsDataModified()) {
					var rslt=false;
					if (ComShowCodeConfirm("PRI00006")) {
						if(!validateForm(sheetObjects[0],document.form,IBSAVE)) {							
							ComSetObjValue(formObj.org_dest_tp_cd, sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "org_dest_tp_cd"));
							return false;
						}
						var sParamSheet=sheetObj.GetSaveString(false);
						sParamSheet += "&f_cmd="+MULTI;
						var sXml=sheetObj.GetSaveData("ESM_PRI_0003_01GS.do", sParamSheet);
						searchRouteTypeColor();
						sheetObj.LoadSaveData(sXml);
					}
				}
	   			formObj.org_dest_tp_cd.value=ComGetObjValue(formObj.org_dest_tp_cd);
	   			doActionIBSheet(sheetObj, formObj, IBSEARCH);
	   		}
	   	}
	    /**
	     * calling function when occurring OnSelectCell Event <br>
	     * Amend Row's Highlight color is different <br>
	     */         
	    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
	        if (OldRow != NewRow) {
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
	        }
	    }      
         /**
          * calling function when occurring OnChange Event <br>
          * when selecting multi comboBox, showing description <br>
          */  	
  		  function sheet1_OnChange(sheetObj, Row, Col, Value){
            	var colname=sheetObj.ColSaveName(Col);
            	var formObj=document.form
            	switch(colname){
        	    	case "rout_pnt_loc_def_cd":
        	    		var sOriDesGbCd=ComGetObjValue(formObj.org_dest_tp_cd);
        	    		var sLocType = sheetObj.GetCellValue(Row,"rout_pnt_loc_tp_cd");
        	    		var sSvcScpCd = formObj.svc_scp_cd.value;
        	    		if (Value.length==2){
        	    			
        	    			//2015.05.14
        	    			//Check
        	    			var sParam="f_cmd="+COMMAND32+"&svc_scp_cd="+sSvcScpCd+"&cd="+Value+"&etc1="+sLocType+"&etc2="+sOriDesGbCd;
        	    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
	      	  				var arrData=ComPriXml2Array(sXml, "cd|nm");
		      	  			if(arrData == null || arrData.length <= 0) {
			      	  			ComShowCodeMessage("PRI01139", "Country");
	  	  						locationCellClear(sheetObj,Row);
	  	  						return;
		      	  			}
        	    			
        	    			//Namming
        	    			formObj.f_cmd.value=SEARCH07;
        	    			formObj.cd.value=sheetObj.GetCellValue(Row,Col);   
        	    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
      	  					var arrData=ComPriXml2ComboString(sXml, "cd", "nm");	  				
        					if (arrData[1] != ""){
        						sheetObj.SetCellValue(Row,"rout_pnt_loc_def_nm",arrData[1],0);
        						sheetObj.SetCellValue(Row,"rout_pnt_loc_tp_cd","C" ,0);
        					}else{
        						locationCellClear(sheetObj,Row);
        					}	  				
        	    		} else if(Value.length==5){
        	    			//formObj.f_cmd.value=SEARCH05;
        	    			formObj.f_cmd.value=COMMAND31;
        	    			formObj.cd.value=sheetObj.GetCellValue(Row,Col);
            	    		var sParam=FormQueryString(formObj)+"&etc1="+sOriDesGbCd;
        	    			//var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
        	    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
        	    			var arrData=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");		  			
	      	  				if (arrData != null && arrData.length > 0) {
	      	  					sheetObj.SetCellValue(Row, "rout_pnt_loc_def_nm",arrData[0][1],0);
	      	  					sheetObj.SetCellValue(Row,"rout_pnt_loc_tp_cd","L" ,0);	
	      	  				}else{
	      	  					ComShowCodeMessage("PRI01137");
	        					locationCellClear(sheetObj,Row);
	        				}	
        	    		}else{
        	    			locationCellClear(sheetObj,Row);
        	    		}
        	    		break;
	       	    	case "rout_pnt_loc_tp_cd": 	    	
	       	    		sheetObj.SetCellValue(Row,"rout_pnt_loc_def_nm","",0);
	       	  	  		sheetObj.SetCellValue(Row,"rout_pnt_loc_def_cd","",0);
	       	  	  		sheetObj.SelectCell(Row,"rout_pnt_loc_def_cd",0);
	       	    		break;  	    		
            	}
            } 
  		/**
  	    * calling function when occurring OnSearchEnd Event <br>
  	    */ 
  	    function sheet1_OnSearchEnd(sheetObj, errMsg){
  			manageGetCellEditable(sheetObj);
  		} 
  	    /**
  	     * setting sheet's specific cell with blank <br>
  	     */  	    
  	  	function locationCellClear(sheetObj,Row){
  	    	sheetObj.SetCellValue(Row,"rout_pnt_loc_def_nm","",0);
  	  		sheetObj.SetCellValue(Row,"rout_pnt_loc_def_cd","",0);
  	  	    sheetObj.SetCellValue(Row,"rout_pnt_loc_tp_cd","",0);
  	  		sheetObj.SelectCell(Row,"rout_pnt_loc_def_cd",0);
  	  	}       	
  	    /**
  	     * calling function when occurring OnSaveEnd event  <br>
  	     * showing the save completion message in case of successful saving <br>
  	     */ 		
  	   	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
  	   		 var formObj=document.form;
	    	 manageGetCellEditable(sheetObj)
	    	 if(ComGetObjValue(formObj.org_dest_tp_cd)=="O") {
	    		 parent.comUpdateProposalStatusSummary("41", formObj.svc_scp_cd.value);
	    	 } else if(ComGetObjValue(formObj.org_dest_tp_cd)=="D") {
	    		 parent.comUpdateProposalStatusSummary("42", formObj.svc_scp_cd.value);
	    	 }
  		} 
  	     /**
 	    * calling function when occurring OnPopupClick Event <br>
 	    * calling Location PopUp <br>
 	    */  
  	   	var popupRow = 0;
	 	function sheet1_OnPopupClick(sheetObj, Row, Col)
	 	{
	 		var colName=sheetObj.ColSaveName(Col);
	 		var formObj=document.form;
	 		popupRow=Row;
	       	switch(colName)
	       	{
	   	    	case "rout_pnt_loc_def_cd":
	 	  	  		var sUrl="ESM_PRI_4026.do?";
	 	  	  		sUrl += "group_cmd=" + PRI_SG;
	 	  	  		sUrl += "&location_cmd=LC";
	 	  	  		sUrl += "&svc_scp_cd=" + formObj.svc_scp_cd.value;
	 	  	  		sUrl += "&loc_tp_cd=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "rout_pnt_loc_tp_cd");
	 	  	  		sUrl += "&loc_def_cd=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "rout_pnt_loc_def_cd");
	 	  	  		sUrl += "&loc_def_nm=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "rout_pnt_loc_def_nm");
	 	  	  		ComOpenPopup(sUrl, 700, 310, "sheet1_returnVal", "0,1", true);
	   	    		break;
	       	}
	 	}
	 	
	 	function sheet1_returnVal(rtnVal) {
  			if (rtnVal != null){
  				
  				sheet1.SetCellValue(popupRow, "rout_pnt_loc_def_nm", rtnVal.nm, 0);
  				sheet1.SetCellValue(popupRow, "rout_pnt_loc_tp_cd",  rtnVal.tp, 0);
  				sheet1.SetCellValue(popupRow, "rout_pnt_loc_def_cd", rtnVal.cd, 1);
  				
  			}
	 	}
 	 	/**
 	     * calling function when clicking parent's screen tab <br>
 	     * showing retrieved data<br>
 	     */ 
 		function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg, sLgcyIfFlg) {
 			var formObject=document.form;
 			if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd || formObject.pre_amdt_seq.value != sPreAmdtSeq ||
 				formObject.prop_sts_cd.value != sPropStsCd || formObject.eff_dt.value != sEffDt || formObject.pre_exp_dt.value != sPreExpDt || formObject.exp_dt.value != sExpDt) {
 				formObject.prop_no.value=sPropNo;
 				formObject.amdt_seq.value=sAmdtSeq;
 				formObject.svc_scp_cd.value=sSvcScpCd;
 				formObject.pre_amdt_seq.value=sPreAmdtSeq;
 				formObject.prop_sts_cd.value=sPropStsCd; 
 				formObject.eff_dt.value=sEffDt;
 				formObject.exp_dt.value=sExpDt;			
 				formObject.pre_exp_dt.value=sPreExpDt ;
 				formObject.req_usr_flg.value=sIsReqUsr ;
 				formObject.apro_usr_flg.value=sIsAproUsr ;	
 	 			formObject.lgcy_if_flg .value=sLgcyIfFlg ;
 	 			formObject.dur_dup_flg.value="Y" ;			
 				document.getElementById("org_dest_tp_cd1").style.fontWeight="";
	  			document.getElementById("org_dest_tp_cd1").style.color="black";  	  			
				document.getElementById("org_dest_tp_cd2").style.fontWeight="";
	  			document.getElementById("org_dest_tp_cd2").style.color="black";
 				buttonControl();
 				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01); 				
 				doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
 			}
 		}
 		/**
 	     * initializing parent's screen tab control <br>
 	     */ 
 		function tabClearSheet() {
 			var formObject=document.form;
 			formObject.prop_no.value="";
			formObject.amdt_seq.value="";
			formObject.svc_scp_cd.value="";
			formObject.pre_amdt_seq.value="";
			formObject.prop_sts_cd.value="";
			formObject.eff_dt.value="";
			formObject.exp_dt.value="";
			formObject.pre_exp_dt.value="";
			formObject.req_usr_flg.value="";
			formObject.apro_usr_flg.value="";
 			formObject.lgcy_if_flg .value="";
 			formObject.dur_dup_flg.value="";
 			sheetObjects[0].RemoveAll();
			document.getElementById("org_dest_tp_cd1").style.fontWeight="";
			document.getElementById("org_dest_tp_cd2").style.fontWeight="";
			document.getElementById("org_dest_tp_cd1").style.color="black";
			document.getElementById("org_dest_tp_cd2").style.color="black";
 			buttonControl("CLEAR");
 		}
 		var enableFlag=true;
 		/**
 	     * calling function from main screen <br>
 	     * prohibiting insert, update, delete in case or Confirmation = YES  <br>
 	     */
 		function tabEnableSheet(flag) {
 			var formObject=document.form;
 			enableFlag=flag;
 			sheetObjects[0].SetEditable(flag);
 		}
 		/**
	     * setting ROUTE RADIO button's font color  <br>
	     * 1) ALL ACCEPT : blue <br>
	     * 2) AMEND : red <br>
	     */
  	    function manageRouteRadioButton(arrData){
  	    	var formObj=document.form;
	    	var sLgcyIfFlg=formObj.lgcy_if_flg.value;
  			try {  				
  				if (arrData != null && arrData.length > 0) {
  					//ORG_TP_CD
	  				if(arrData[0][2] == "O") {
	  					document.getElementById("org_dest_tp_cd1").style.fontWeight="bold";
	  				} else if(arrData[0][2] == "") {
	  					document.getElementById("org_dest_tp_cd1").style.fontWeight="";
	  				} 
	  				//DEST_TP_CD
	  				if(arrData[0][5] =="D") {
	  					document.getElementById("org_dest_tp_cd2").style.fontWeight="bold";
	  				} else if(arrData[0][5] =="") {
	  					document.getElementById("org_dest_tp_cd2").style.fontWeight="";
	  				} 
  					//setting red
	  				//ORG_SRC_INFO_CD
  					if(arrData[0][0] == "AM" && sLgcyIfFlg != "Y") {
  						document.getElementById("org_dest_tp_cd1").style.color="red";
  					} else {
  						document.getElementById("org_dest_tp_cd1").style.color="black";
  					}
  					//DEST_SRC_INFO_CD
  					if(arrData[0][3] == "AM" && sLgcyIfFlg != "Y") {
  						document.getElementById("org_dest_tp_cd2").style.color="red";
  					} else {
  						document.getElementById("org_dest_tp_cd2").style.color="black";
  					}
  	  				//setting blue
  					//ORG_PRC_PROG_STS_CD
  	  				if(arrData[0][1] == "A" && sLgcyIfFlg != "Y") {
  	  					document.getElementById("org_dest_tp_cd1").style.color="blue";
  	  				} else if(arrData[0][1] == "I" && arrData[0][0] == "AM" && sLgcyIfFlg != "Y") {
  	  					document.getElementById("org_dest_tp_cd1").style.color="red";
  	  				} else {
  	  					document.getElementById("org_dest_tp_cd1").style.color="black";
  	  				}
  	  				//DEST_PRC_PROG_STS_CD
  	  				if(arrData[0][4] == "A" && sLgcyIfFlg != "Y") {
	  					document.getElementById("org_dest_tp_cd2").style.color="blue";
	  				} else if(arrData[0][4] == "I" && arrData[0][3] == "AM" && sLgcyIfFlg != "Y") {
	  					document.getElementById("org_dest_tp_cd2").style.color="red";
	  				} else {
	  					document.getElementById("org_dest_tp_cd2").style.color="black";
	  				}
  				} else {
  					document.getElementById("org_dest_tp_cd1").style.fontWeight="";
  					document.getElementById("org_dest_tp_cd2").style.fontWeight="";
  					document.getElementById("org_dest_tp_cd1").style.color="black";
  					document.getElementById("org_dest_tp_cd2").style.color="black";
  				}  			
  			}catch(e) {}
  		}
 		/**
	     * setting sheet's cell editable authority control function <br>
	     */
	     function manageGetCellEditable(sheetObj) {
	    	 var formObj=document.form;
	    	 var eff_dt=formObj.eff_dt.value;
	    	 var amdt_seq=formObj.amdt_seq.value;
	    	 var prop_sts_cd=formObj.prop_sts_cd.value;
	    	 var sLgcyIfFlg=formObj.lgcy_if_flg.value;
	    	 for (var i=sheetObj.HeaderRows(); sheetObj.RowCount()> 0 && i <= sheetObj.LastRow(); i++) {
	    		 if(sheetObj.GetCellValue(i,"amdt_seq") != amdt_seq){
	    			  sheetObj.SetCellFont("FontStrike", i, "chk", i, sheetObj.LastCol(), true);
	    			  sheetObj.SetRowEditable(i,0);
	    		  }
	    		 if(sheetObj.GetCellValue(i,"amdt_seq") == amdt_seq && amdt_seq > 0 && sheetObj.GetCellValue(i,"n1st_cmnc_amdt_seq") != amdt_seq){
	    			  sheetObj.SetCellEditable(i,"rout_pnt_loc_tp_cd",0);
	    			  sheetObj.SetCellEditable(i,"rout_pnt_loc_def_cd",0);
	    		  }
	    		 if(sheetObj.GetCellValue(i,"n1st_cmnc_amdt_seq") == amdt_seq && amdt_seq > 0 && sLgcyIfFlg != "Y"){
	    			 sheetObj.SetCellFont("FontColor", i, "chk", i, sheetObj.LastCol(),"#FF0000");
	    		  }
	    		 if(prop_sts_cd != "I" || sheetObj.GetCellValue(i,"prc_prog_sts_cd") != "I") {
	    			  sheetObj.SetCellEditable(i,"rout_pnt_loc_tp_cd",0);
	    			  sheetObj.SetCellEditable(i,"rout_pnt_loc_def_cd",0);
	    		  }
	    	 }
	     }
 		/**
	     * button authority control function <br>
	     */
	  	function buttonControl(mode){
	 		var formObj=document.form;
	 		var req_usr_flg=formObj.req_usr_flg.value;
	 		var apro_usr_flg=formObj.apro_usr_flg.value;
	 		var amdt_seq=formObj.amdt_seq.value;
	 		var sts=formObj.prop_sts_cd.value;
	 		var row_cnt=sheetObjects[0].RowCount();
	 		try{		
	 			ComBtnDisable("btn_retrieve");
	 			ComBtnDisable("btn_save");
	 			ComBtnDisable("btn_acceptall");
	 			ComBtnDisable("btn_cancelall");
	 			ComBtnDisable("btn_glinecopy");
				ComBtnDisable("btn_rowadd");
				ComBtnDisable("btn_delete");
				ComBtnDisable("btn_accept");
				ComBtnDisable("btn_acceptcancel");
				if(amdt_seq > 0){
					showButton("btn_amend");
					showButton("btn_amendcancel");
					ComBtnDisable("btn_amendcancel");
					ComBtnDisable("btn_amend");
				} else {
					hiddenButton("btn_amend");
					hiddenButton("btn_amendcancel");
				}
				if(mode == "CLEAR") {
					return;
				}
	 			switch(sts) {
	 				case 'I':   // Initial
			 			ComBtnEnable("btn_retrieve");
	 					if(apro_usr_flg== "true" || req_usr_flg== "true" ){
	 						ComBtnEnable("btn_save");
	 						ComBtnEnable("btn_rowadd");
	 						ComBtnEnable("btn_delete");
	 						ComBtnEnable("btn_amend");
	 						ComBtnEnable("btn_amendcancel");
	 						if(amdt_seq > 0){
	 							showButton("btn_amend");
	 							showButton("btn_amendcancel");
	 						}
	 					}				
	 					break;
	 				case 'Q':   // Requested
			 			ComBtnEnable("btn_retrieve");
	 					if(apro_usr_flg== "true"){
	 						ComBtnEnable("btn_acceptall");
	 						ComBtnEnable("btn_cancelall");
	 						ComBtnEnable("btn_accept");
	 						ComBtnEnable("btn_acceptcancel");
	 					}
	 					break;
	 				case 'R':   // Returned
			 			ComBtnEnable("btn_retrieve");
	 					if(apro_usr_flg== "true" || req_usr_flg== "true" ){
	 						ComBtnEnable("btn_accept");
	 						ComBtnEnable("btn_acceptcancel");
	 					}				
	 					break;
	 				case 'A':   // Approved
			 			ComBtnEnable("btn_retrieve");
	 				case 'F':   // Filed
			 			ComBtnEnable("btn_retrieve");
	 				case 'C':   // Cancled
			 			ComBtnEnable("btn_retrieve");
	 					break;		
	 			}	
	 		} catch (e) {
				if (e == "[object Error]") {
					ComShowMessage(OBJECT_ERROR);
				} else {
					ComShowMessage(e.message);
				}
	 		}
	 	}
	    /**
	     * retrieving for setting ROUTE TYPE color/bold
	     */	
	 	function searchRouteTypeColor() {
	 		var formObj=document.form;
	        formObj.f_cmd.value=SEARCH02;
	        var sXml=sheetObjects[1].GetSearchData("ESM_PRI_0003_01GS.do" , FormQueryString(formObj));
			var arrData=ComPriXml2Array(sXml, "org_src_info_cd|org_prc_prog_sts_cd|org_tp_cd|dest_src_info_cd|dest_prc_prog_sts_cd|dest_tp_cd");
			manageRouteRadioButton(arrData);
	 	}
      /**
      * accepting checked row
      */
      function comSheetAcceptCheckedRowsRoute(sheetObj,formObj,isAll){
      	var amdt_seq=formObj.amdt_seq.value;
          var prop_sts_cd=formObj.prop_sts_cd.value;
          var eff_dt=formObj.eff_dt.value;
          if(isAll == undefined || isAll ==""){
              isAll=false;
          }
          if(prop_sts_cd == "R") {
              if(isAll){
                  comChangeValue(sheetObj, "chk", "0");
                  comChangeValue(sheetObj, "chk", "1", "n1st_cmnc_amdt_seq|prc_prog_sts_cd", amdt_seq+"|R");
                  if(sheetObj.CheckedRows("chk") == 0) {
                      ComShowCodeMessage("PRI00301");
                      return false;
                  }
              }
              var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
              if(chkArr.length == 0){
                  sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
                  chkArr[0]=sheetObj.GetSelectRow();
              }
              for(i=0;i<chkArr.length;i++){
            	  if(sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd")!="R" || sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq")!=amdt_seq){
                      sheetObj.SetCellValue(chkArr[i],"chk","0",0);
                      ComShowCodeMessage("PRI00313");
                      return false;
                  }
              }
              comChangeValue(sheetObj, "prc_prog_sts_cd|prc_prog_sts_dtl|ibflag", "A|Accepted|U", "chk", "1");
              var sParam=FormQueryString(formObj);
              var sParamSheet=sheetObj.GetSaveString(false, false, "chk");
              if (sParamSheet != "") {
            	  sParam=ComPriSetPrifix(sParamSheet, "") + "&" + sParam;
              }
              var sXml=sheetObj.GetSaveData("ESM_PRI_0003_01GS.do", sParam);
              sheetObj.LoadSaveData(sXml, false, "chk");
              comChangeValue(sheetObj, "chk|ibflag", "0|R", "chk", "1");
          } else {
          if(isAll){
              comChangeValue(sheetObj, "chk", "0");
              comChangeValue(sheetObj, "chk", "1", "n1st_cmnc_amdt_seq|prc_prog_sts_cd", amdt_seq+"|I");
              if(sheetObj.CheckedRows("chk")==0){
                  ComShowCodeMessage("PRI00329");
                  return false;
              }
          }
          var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
          if(chkArr.length == 0){
              sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
              chkArr[0]=sheetObj.GetSelectRow();
          }
          for(i=0;i<chkArr.length;i++){
        	  if(sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd")!="I"){
                  sheetObj.SetCellValue(chkArr[i],"chk","0",0);
                  ComShowCodeMessage("PRI01037");
                  return false;
              }
        	  if(sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq")!=amdt_seq){
                  sheetObj.SetCellValue(chkArr[i],"chk","0",0);
                  ComShowCodeMessage("PRI00313");
                  return false;
              }
          }
          comChangeValue(sheetObj, "prc_prog_sts_cd|prc_prog_sts_dtl|ibflag", "A|Accepted|U", "chk", "1");
		  ComOpenWait(true);
          var sParam=FormQueryString(formObj);
          var sParamSheet=sheetObj.GetSaveString(false, false, "chk");
          if (sParamSheet != "") {
        	  sParam=ComPriSetPrifix(sParamSheet, "") + "&" + sParam;
          }
          var sXml=sheetObj.GetSaveData("ESM_PRI_0003_01GS.do", sParam);
          searchRouteTypeColor();
		  ComOpenWait(false);
		  sheetObj.LoadSaveData(sXml, false, "chk");
          comChangeValue(sheetObj, "chk|ibflag", "0|R", "chk", "1");
          }
          return true;
      }
      /**
      * accept canceling checked row
      */
      function comSheetAcceptCancelCheckedRowsRoute(sheetObj,formObj,isAll){
          var eff_dt=formObj.eff_dt.value;
          var amdt_seq=formObj.amdt_seq.value;
          if(isAll == undefined || isAll ==""){
              isAll=false;
          }
          if(isAll){
              comChangeValue(sheetObj, "chk", "0");
              comChangeValue(sheetObj, "chk", "1", "n1st_cmnc_amdt_seq|prc_prog_sts_cd", amdt_seq+"|A");
              if(sheetObj.CheckedRows("chk")==0){
                  ComShowCodeMessage("PRI00301");
                  return false;
              }
          }
          var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
          if(chkArr.length == 0){
              sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
              chkArr[0]=sheetObj.GetSelectRow();
          }
          for(i=0;i<chkArr.length;i++){
        	  if(sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd")!="A" || sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq")!=amdt_seq){
                  sheetObj.SetCellValue(chkArr[i],"chk","0",0);
                  ComShowCodeMessage("PRI00313");
                  return false;
              }
          }
          comChangeValue(sheetObj, "prc_prog_sts_cd|prc_prog_sts_dtl|ibflag", "I|Initial|U", "chk", "1");
		  ComOpenWait(true);
          var sParam=FormQueryString(formObj);
          var sParamSheet=sheetObj.GetSaveString(false, false, "chk");
          if (sParamSheet != "") {
        	  sParam=ComPriSetPrifix(sParamSheet, "") + "&" + sParam;
          }
          var sXml=sheetObj.GetSaveData("ESM_PRI_0003_01GS.do", sParam);
          searchRouteTypeColor();
		  ComOpenWait(false);          
		  sheetObj.LoadSaveData(sXml, false, "chk");
          comChangeValue(sheetObj, "chk|ibflag", "0|R", "chk", "1");
          return true;
      }
