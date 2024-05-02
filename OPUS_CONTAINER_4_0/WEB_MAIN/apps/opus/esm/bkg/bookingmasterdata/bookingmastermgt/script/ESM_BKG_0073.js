/* =========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   esm_bkg_0073.jsp
*@FileTitle  : BDR Time Table 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
 ========================================================= */
/****************************************************************************************
   Event distinction code: [Initialization]INIT=0; [Input]ADD=1; [Retrieve]SEARCH=2; [Retrieving List]SEARCHLIST=3;
					[Modification]MODIFY=4; [Delete]REMOVE=5; [Deleting list]REMOVELIST=6 [Multi-Processing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
// Common global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 var IsFixed = false;
 //Event Handler definition for Button Click event */
 document.onclick=processButtonClick;
 //Event Handler for branch processing by judging button name */
     function processButtonClick(){
          /***** using extra sheet valuable if there are more 2 sheets *****/
          var sheetObject=sheetObjects[0];
          var sheetObject1=sheetObjects[1];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
 				switch(srcName) {
 						case "btn_RowAdd1":
 								doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
 								break;
 						case "btn_DeleteRow1":
 								doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
 								break;
 						case "btn_Retrieve":
 								doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
 								break;
 						case "btn_Save":
 								doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
 								break;
 						case "btn_Creation":
								doActionIBSheet(sheetObjects[0], formObject, IBCREATE);
								break;
 						case "btn_com_ens_ob2_pop":
 								openWindowVvd(formObject) 
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
	  * Registering IBSheet Object in to Array
	  * Afterwards, when other items need to be batch processed,it can add to the process that stores in to array
	  * The array is defined at upper part of source
	  * @param sheet_obj IBSheet Object
	  */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
	   /**
	    * Sheet basic setting & initializing
	    * onLoad Event HandlerImplementation of body tag
	    * After loading screen in the browser, add function in pre-processing
	    */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
         }
         doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
         axon_event.addListener('keydown', 'ComKeyEnter', 'form');
         initControl();
 		 checkOption();
 		$('#cb_slan_cd_text, #cb_skd_dir_cd_text, #cb_pol_cd_text, #pol_cd_text, #pod_cd_text').on('keypress', function(event) {
 			IsFixed = true;
            if(null !== String.fromCharCode(event.which).match(/[a-z]/g)) {
                event.preventDefault();
                $(this).val($(this).val() + String.fromCharCode(event.which).toUpperCase());                
            }
        });
     }
	/**
	 * Dynamic loading event of HTML Control in page.<br>
	 * @link Initializing IBSheet Object with calling on oadPage} function to this function <br>
	 * 
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {int}
	 *            sheetNo sheetObjects order in array
	 */
     function initControl() {
     	//var formObject=document.form;
     	//axon_event.addListenerForm  ('beforedeactivate',  formObject); //- 포커스 나갈때
     }
     function checkOption(){
    	 var formObject=document.form;
    	 var mainTable = document.all.item('mainTable');
    	 var flag=ComGetObjValue(formObject.opt_sel_bdr);
    	 if (flag == "VVD"){
			/* mandatory input item in case VVD */
    		 cb_slan_cd.SetRequired(false);
    		 cb_slan_cd.SetBackColor("white");
    		 cb_slan_cd.SetDropHeight(200);
    		 cb_slan_cd.SetColWidth(0 , 60);
    		 //cb_skd_dir_cd.required=null;
    		 cb_skd_dir_cd.SetRequired(false);
    		 cb_skd_dir_cd.SetBackColor("white");
    		 //cb_pol_cd.required=null;
    		 cb_pol_cd.SetRequired(false);
    		 cb_pol_cd.SetBackColor("white");
    		 formObject.vvd.required=true;
    		 formObject.vvd.className="input1";
    		 //formObject.pol_cd.required=true;
    		 pol_cd.SetRequired(true);
    		 pol_cd.SetBackColor("#CCFFFD");
    		 pol_cd.SetDropHeight(300);
    		 if(location.href.indexOf("Q")>0){
    			 $("#searchTb colgroup").remove();
    			 
    			 var colgroup = "<colgroup>"+
					"<col width='50px'>"+
					"<col width='50px'>"+
					"<col width='70px'>"+
					"<col width='50px'>"+
					"<col width='70px'>"+
					"<col width='50px'>"+
					"<col width='70px'>"+
					"<col width='70px'>"+
					"<col width='70px'>"+
					"<col width='40px'>"+
					"<col width='70px'>"+
					"<col width='*'>"+
					"</colgroup>";

    			 $("#searchTb tbody").before(colgroup);
    		 }
    		 $(".searchTb1").css("display","none");
    		 $(".searchTb2").css("display","");
    		 //ComSetObjValue(formObject.vvd,"");
    		 //ComSetObjValue(formObject.pol_cd,"");
    		 //ComSetObjValue(formObject.pod_cd,"");
    		 //ComSetObjValue(formObject.slan_cd,"");
    		 //ComSetObjValue(formObject.etd_cd,"");
    		 mainTable[0].style.display="none";
 	     	 mainTable[1].style.display="";
 	     	 if (location.href.indexOf("Q") < 0){
 	     		 rowButtonTable.style.display="none";
 	     		 //code goc khong mode dong nay
	 	     	 ComShowObject(getButtonTable("btn_Creation"),true);
 	     	 }
    	 }else{
			/* mandatory input item in case Lane */
    		 cb_slan_cd.SetRequired(true,"Lane");
    		 cb_slan_cd.SetBackColor("#CCFFFD");
    		 cb_slan_cd.SetDropHeight(200);
    		 cb_slan_cd.SetColWidth(0 , 60);

    		 //formObject.cb_skd_dir_cd.required=true;
    		 cb_skd_dir_cd.SetBackColor("#CCFFFD");
    		 //formObject.cb_pol_cd.required=true;
    		 cb_pol_cd.SetBackColor("#CCFFFD");
    		 formObject.vvd.required=null;
    		 formObject.vvd.className="input";
    		 //pol_cd.required=null;
    		 pol_cd.SetBackColor("white");
    		 pol_cd.SetColWidth(0 , 60);
    		 pol_cd.SetColWidth(1 , 40);
    		 pol_cd.SetColWidth(2 , 140);
    		 pol_cd.SetDropHeight(300);
    		 if(location.href.indexOf("Q")>0){
    			 $("#searchTb colgroup").remove();
    			 var colgroup = "<colgroup>"+
					"<col width='50px'>"+
					"<col width='50px'>"+
					"<col width='70px'>"+
					"<col width='50px'>"+
					"<col width='80px'>"+
					"<col width='50px'>"+
					"<col width='70px'>"+
					"<col width='*'>"+
					"</colgroup>";
    			 	$("#searchTb tbody").before(colgroup);
    		 }
    		 $(".searchTb1").css("display","");
    		 $(".searchTb2").css("display","none");
    		 mainTable[0].style.display="";
 	     	 mainTable[1].style.display="none";
 	     	if (location.href.indexOf("Q") < 0){
 	     		rowButtonTable.style.display="";
 	     		//code cu khong move dong nay.
 	     		ComShowObject(getButtonTable("btn_Creation"),false);
 	     	}
    	 }
    	 /*sheetObjects[0].RemoveAll();
    	 sheetObjects[1].RemoveAll();*/
     }
	 /**
	 * Definition for sheet initial setting value, header
	 * param : sheetObj ==> sheet object, sheetNo ==> If the serial number ID tag attached to the sheet are many,
	 * adding 'Case' clause as a number of sheets, configures initial module.
	 * @param sheetObj sheet object
	 * @param sheetNo Sheet object tag ID attached serial number
	 */
     function initSheet(sheetObj,sheetNo) {
    	 var prefix="";
         var cnt=0;
 				var sheetId=sheetObj.id;
         switch(sheetId) {
             case "sheet1":
            	 with(sheetObj){
	              	var HeadTitle1="|Sel.|POD|Trunk Time|FDR Time|User|Office|Date|||";
	              	var headCount=ComCountHeadTitle(HeadTitle1);
	              	(headCount, 0, 0, true);
	
	              	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	              	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              	InitHeaders(headers, info);
	
	              	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                      {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		                      {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		                      {Type:"Text",      Hidden:0, Width:210,  Align:"Center",  ColMerge:0,   SaveName:prefix+"trnk_bdr_dys", KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"N" , EditLen:3 },
		                      {Type:"Text",      Hidden:0, Width:180,  Align:"Center",  ColMerge:0,   SaveName:prefix+"fdr_bdr_dys",  KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"N" , EditLen:3 },
		                      {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:prefix+"slan_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:prefix+"skd_dir_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pol_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	             
	            		InitColumns(cols);
	
	            		SetEditable(1);
	                  SetFocusEditMode(-1);
	                  SetSelectionMode(smSelectionCol);
	                  SetSheetHeight(420);
             	}
				break;
             case "sheet2":
            	 with(sheetObj){
		              var HeadTitle1="|POD|Trunk-Base BDR|Trunk-Base BDR|Trunk-Base BDR|Trunk-Base BDR|Trunk-Base BDR|First-Base BDR|First-Base BDR|First-Base BDR|First-Base BDR|First-Base BDR|Update Date|||||";
		              var HeadTitle2="|POD|Original BDR|New BDR|BDR|A/M|Adjusted by|Original BDR|New BDR|BDR|A/M|Adjusted by|Update Date|||||";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              (headCount, 0, 0, true);
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"},
	                   { Text:HeadTitle2, Align:"Center"} ];
	         		InitHeaders(headers, info);
	
		             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"trnk_estm_bdr_dt",    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"trnk_mnl_bdr_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"trnk_bdr_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"trnk_auto_bdr_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"trnk_bdr_cre_usr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"fdr_estm_bdr_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"fdr_mnl_bdr_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"fdr_bdr_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"fdr_auto_bdr_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"fdr_bdr_cre_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fdr_bdr_upd_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_voy_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pol_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_clpt_ind_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	          
	         		InitColumns(cols);
	         		SetEditable(1);
	         		SetFocusEditMode(-1);
	         		SetSheetHeight(420);
             	}
				break;
         }
     }
   // Handling process about Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         var prefix=""; //sheetObj.id +"_";
         switch(sAction) {
			case IBCLEAR: //code retrieve when screen loading
				formObj.f_cmd.value=SEARCH02;
				var sXml=sheetObj.GetSearchData("ESM_BKG_0073GS.do", FormQueryString(formObj,true));
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 1) 
					ComBkgXml2ComboItem(arrXml[1], cb_skd_dir_cd, "val", "name");
				if (arrXml.length > 0) 
					ComBkgXml2ComboItem(arrXml[0], cb_slan_cd, "vsl_slan_cd", "vsl_slan_nm");
				cb_slan_cd.SetDropHeight(200);
				cb_slan_cd.SetUseAutoComplete(1);
				cb_slan_cd.SetColWidth(0 , 60);
				cb_skd_dir_cd.SetDropHeight(100);
				sheetObj.SetDataAutoTrim(1);
				cb_pol_cd.SetDropHeight(200);
				cb_pol_cd.SetUseAutoComplete(1);
				cb_slan_cd.SetRequired(true,"Lane");
				//cb_slan_cd.caption="Lane";
				//cb_skd_dir_cd.required=true;
				cb_skd_dir_cd.SetRequired(true,"Bound");
				//cb_skd_dir_cd.caption="Bound";
				//cb_pol_cd.required=true;
				cb_pol_cd.SetRequired(true,"POL");
				//cb_pol_cd.caption="POL";
				break;	
           case IBSEARCH:
	          if(validateForm(sheetObj,formObj,sAction)){
	        	  formObj.f_cmd.value=SEARCH;
	        	  var sXml=sheetObj.GetSearchData("ESM_BKG_0073GS.do", FormQueryString(formObj));
				  var arrXml=sXml.split("|$$|");
				  if (ComGetObjValue(formObj.opt_sel_bdr) == "VVD"){
					  sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
				  }else{
					  sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
				  }
	          }	
               	break;
	 		case IBSAVE:
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=MULTI;
//					var sParam = ComGetSaveString(sheetObj);
//					sParam += "&" + FormQueryString(formObj);
					var sParam=FormQueryString(formObj);
					if (ComGetObjValue(formObj.opt_sel_bdr) == "VVD"){
						var sheet1SaveString=sheetObjects[1].GetSaveString();
						if(sheet1SaveString == "") return;
						sParam += "&" + ComSetPrifix(sheet1SaveString, "sheet2_");
						sheetObjects[1].DoSave("ESM_BKG_0073GS.do", sParam);
//						doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
					}else{
						var sheet0SaveString=sheetObjects[0].GetSaveString();
						if(sheet0SaveString == "") return;
						var rowM=sheetObjects[0].ColValueDup("pod_cd");
						if (rowM >= 0) {
							 ComShowCodeMessage("BKG00828", "Sheet", rowM);
						     return false;
					    }
						sParam += "&" + ComSetPrifix(sheet0SaveString, "sheet1_");
						//sheetObjects[0].DoSave("ESM_BKG_0073GS.do", sParam);
						var sXml=sheetObjects[0].GetSaveData("ESM_BKG_0073GS.do", sParam);
						//sheetObjects[0].LoadSaveData(sXml);
						sheetObjects[0].LoadSaveData(sXml,{Sync:1} );       
//						doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
					}

				}
				break;
	 		case IBCREATE:        //BDR LOG CREATION
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=COMMAND01;
					var sXml=sheetObj.GetSaveData("ESM_BKG_0073GS.do", FormQueryString(formObj));
					sheetObjects[0].LoadSaveData(sXml);
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
				}
				break;	
			case IBINSERT:
				if(validateForm(sheetObj,formObj,sAction)){
					sheetObj.SetWaitImageVisible(1);
					getPortList(SEARCH05);
					//adding new row
	 				var cnt = sheetObj.DataInsert();
	 				sheetObj.SetCellValue(cnt, prefix +"slan_cd",ComGetObjValue(cb_slan_cd),0);
	 				sheetObj.SetCellValue(cnt, prefix +"skd_dir_cd",ComGetObjValue(cb_skd_dir_cd),0);
	 				sheetObj.SetCellValue(cnt, prefix +"pol_cd",ComGetObjValue(cb_pol_cd),0);
	 				sheetObj.SelectCell(sheetObj.RowCount(),"pod_cd");
	 				//sheetObj.SetWaitImageVisible(0);
	 				sheetObj.WaitImageVisible=false;
	 				
				}
				break;
			case IBDELETE:
				//sheetObj.CellValue2(sheetObj.SelectRow, prefix+"ibflag") = "D";
				ComRowHideDelete(sheetObj, prefix+"del_chk");
				break;	
         }
     }
    //[2:56:25 PM] Tuấn Lực Dương: OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
     function cb_skd_dir_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
    	 getPortList(SEARCH03);
     }
     function cb_pol_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
    	 sheetObjects[0].RemoveAll();
    	 getPortList(SEARCH05);
		 sheetObjects[0].SetDataAutoTrim(1);
		 
     }
     function getPortList(val){
    	var formObj=document.form;
    	if (ComGetObjValue(cb_slan_cd) == "" || ComGetObjValue(cb_skd_dir_cd) == ""){
    		return;
    	}
    	formObj.f_cmd.value=val;
    	var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0073GS.do", FormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		if (arrXml.length < 1) return; 
		if (val == SEARCH03 ){
			ComBkgXml2ComboItem(arrXml[0], cb_pol_cd, "port_cd", "port_cd");
		}else if (val == SEARCH05 ){
			arrXml[0]=ComReplaceStr(arrXml[0], "port_cd", "val");
			setIBCombo(sheetObjects[0], arrXml[0], "pod_cd", false, "", "","","val");
		}
     }
     function getVvdPortList(){
      	var formObj=document.form;
      	if (ComGetObjValue(formObj.vvd) == "" || ComGetObjValue(formObj.vvd).length != 9 ){
      		return;
      	}

      /*	switch( ComGetEvent("name")){
	  		case "vvd":
	  		case "btn_com_ens_ob2_pop":*/
	 	 		formObj.f_cmd.value=SEARCH04;
	 	 		var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0073GS.do", FormQueryString(formObj));
	 	 		var arrXml=sXml.split("|$$|");
	 	 		if (arrXml.length > 0) {
	 	 			ComBkgXml2ComboItem(arrXml[0], pol_cd, "vps_port_cd", "opt_disp");
	 	 			ComBkgXml2ComboItem(arrXml[0], pod_cd, "vps_port_cd", "vps_port_cd");
	 	 			//formObj.pol_cd.InsertItem(0, '', '');
		 	 		pod_cd.InsertItem(0, '', '');
	 	 			pol_cd.SetSelectIndex(0);
	 	 		}	
 		 /*	break;	
      	}	*/
     }
     function selVvdPortVal(){
    	 var formObj=document.form;
    	 var lane=pol_cd.GetText(ComGetObjValue(pol_cd),1);
    	 var etd=pol_cd.GetText(ComGetObjValue(pol_cd),2);
    	 if(lane != undefined){
    		 ComSetObjValue(formObj.slan_cd,lane);
    	 }
    	 if(etd != undefined){
    		 ComSetObjValue(formObj.etd_cd,etd);
    	 }    	 
     }
     function openWindowVvd(formObj) {
    	 var param;
   		param="loc_cd="+ComGetObjValue(pol_cd);
   		param=param + "&" + "pod_cd="+ComGetObjValue(pod_cd);
   		param=param + "&" + "lane_cd="+ComGetObjValue(formObj.slan_cd);
   		param=param + "&" + "vvd_cd="+formObj.vvd.value;
   		param=param + "&" + "etd_cd="+formObj.etd_cd.value;
   		ComOpenPopup('/opuscntr/COM_ENS_0B2.do?' + param, 750, 500, 'setCallBack0B2', '1,0,1,1,1,1,1,1', true);
  	 }
     /**
   	 * Vessel SKD & Code Inquiry부분.<br>
   	 * @param {arry} aryPopupData
   	 */
   	function setCallBack0B2(aryPopupData) {
   		var formObject=document.form;
   		formObject.vvd.value=aryPopupData[0][7];
   		formObject.slan_cd.value=aryPopupData[0][3];
   		pol_cd.value=aryPopupData[0][4];
   		formObject.etd_cd.value=ComGetMaskedValue(aryPopupData[0][5], "ymd");
   		getVvdPortList();
   	} 
     /**
      * Handling validity verification process about screen form input value.
      */
     function validateForm(sheetObj,formObj,sAction){
    	 switch(sAction) {
         	case IBSEARCH:
         		if (!ComChkValid(formObj)) return false;
         		break;
         	case IBINSERT:
	     		if (!ComChkValid(formObj)) return false;
	     		break;	
//         	case IBCREATE:
//	     		if (!ComChkValid(formObj)) return false;
//				if (ComGetObjValue(formObj.opt_sel_bdr) == "VVD"){
//					sheetObj=sheetObjects[1];
//				}
//	     		if(sheetObj.RowCount()== 0) {
//	     			ComShowCodeMessage("BKG00095");
//	     			return false;
//	     		}
//	     		break;	
    	 }
         return true;
     }
      function sheet1_OnSaveEnd(sheetObj, Code, ErrMsg){
  		with(sheetObj){
  			  for (i=HeaderRows(); i<= LastRow(); i++) {
  				SetCellEditable(i,"pod_cd",0);
  			  }
  			  var formObj=document.form;
			  doActionIBSheet(sheetObj,formObj,IBSEARCH);
  		}
      }
      function sheet2_OnSaveEnd(sheetObj, Code, ErrMsg){
    		with(sheetObj){
   			  var formObj=document.form;
			  doActionIBSheet(sheetObj,formObj,IBSEARCH);
    		}
        }
      function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	  with(sheetObj){
  			  for (i=HeaderRows(); i<= LastRow(); i++) {
  				SetCellEditable(i,"pod_cd",0);
  			  }
  		 }  
      }
	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
		with(sheetObj){
			  for (i=2; i<= LastRow(); i++) {
				  if (GetCellText(i,"trnk_bdr_flg") == 'Y'){
					  SetCellEditable(i,"trnk_mnl_bdr_dt",0);
				  }
				  if (GetCellText(i,"fdr_bdr_flg") == 'Y'){
					  SetCellEditable(i,"fdr_mnl_bdr_dt",0);
				  }
			  }
		}
	}
	 /**
	 * check input value in Combo.
	 **/
	 function checkKeyInCombo(obj){
		 var formObject=document.form;
		 if (!ComIsEmpty(obj.GetSelectText())){
			 IsFixed = false;
		 }
		 if (ComIsEmpty(obj.GetSelectText()) && IsFixed){
			 if (obj.FindItem(obj.GetSelectText(),0) == -1){
				 ComShowCodeMessage("BKG00657");
				 obj.SetSelectText("");
				 IsFixed = false;
				 obj.Focus();
			 }
		 }
	 }