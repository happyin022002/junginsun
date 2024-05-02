/*
 =========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0588.js
*@FileTitle  : Special cargo summary information 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_BKG_0588 : business script for ESM_BKG_0588
     */
    
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var combo1=null;
    var comboCnt=0;
	 // Event handler processing by button click event */
      document.onclick=processButtonClick;
	 // Event handler processing by button name */
     function processButtonClick(){
		/***** using extra sheet valuable if there are more 2 sheets *****/
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		var porCd=formObject.por_cd.value;
		var porYdCd=formObject.por_nod_cd.value;
		var polCd=formObject.pol_cd.value;
		var polYdCd=formObject.pol_nod_cd.value;
		var podCd=formObject.pod_cd.value;
		var podYdCd=formObject.pod_nod_cd.value;
		var delCd=formObject.del_cd.value;
		var delYdCd=formObject.del_nod_cd.value;
		var spcl_cgo_type="";
		var bkg_no="";
		var vsl_cd="";
		var skd_voy_no="";
		var skd_dir_cd="";
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
 		        case "btn_retrieve":
 		        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 		        	break;
 		        case "btn_0083PorPop":
 	        		comBkgCallPop0083('callBack0083','POR',porCd,porYdCd);
 	        		break;    		
 	        	case "btn_0083PolPop":
 	        		comBkgCallPop0083('callBack0083','POL',polCd,polYdCd);
 	        		break;    		
 	        	case "btn_0083PodPop":
 	        		comBkgCallPop0083('callBack0083','POD',podCd,podYdCd);
 	        		break;    		
 	        	case "btn_0083DelPop":
 	        		comBkgCallPop0083('callBack0083','DEL',delCd,delYdCd);                    		
 					break; 
 		        case "btn_new":
 		        	sheetObject1.RemoveAll();
 		        	ComResetAll();
 		        	break;
 		        case "btn_DownExcel":
 		        	if(sheetObjects[0].RowCount() < 1){//no data
 		        	     ComShowCodeMessage("COM132501");
 		        	    } else{
 		        	    	doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
 		        	    }
					break;
 		        case "btn_certiDown":
	 		        alert(srcName);
	 		        break;	
                case "btn_request":
                	alert(srcName);
                	break;
 		        case "btn_application":
 		        	if (CheckGrid(sheetObjects[0],"Check","")){ 
 		        		var checkRow=getCheckedRow(sheetObjects[0],"Check");
 		        		bkg_no=sheetObjects[0].GetCellValue(checkRow, "bkg_no");
 		        		spcl_cgo_type=sheetObjects[0].GetCellValue(checkRow, "spcl_cgo_type");
 		        		if (spcl_cgo_type == ""){
 		        			ComShowCodeConfirm("BKG06012","Special Cargo Type");
 		        			return;
 		        		}
 		        		comBkgCallPopSpclAppication(spcl_cgo_type,bkg_no);
						break;
 					}	
 		        	break;
                case "btn_approval":
                	if (CheckGrid(sheetObjects[0],"Check","")){ 
                		var checkRow=getCheckedRow(sheetObjects[0],"Check");
						bkg_no=sheetObjects[0].GetCellValue(checkRow, "bkg_no");
						spcl_cgo_type=sheetObjects[0].GetCellValue(checkRow, "spcl_cgo_type");
						vsl_cd=sheetObjects[0].GetCellValue(checkRow, "vsl_cd");
						skd_voy_no=sheetObjects[0].GetCellValue(checkRow, "skd_voy_no");
						skd_dir_cd=sheetObjects[0].GetCellValue(checkRow, "skd_dir_cd");
		        		if (spcl_cgo_type == ""){
		        			ComShowCodeConfirm("BKG06012","Special Cargo Type");
		        			return;
		        		}
		        		comBkgCallPopSpclAppResult(spcl_cgo_type,bkg_no,vsl_cd,skd_voy_no,skd_dir_cd);
							break;
		 				}
                	break;
                case "btn_print":
                	alert(srcName);
                	break;  
                case "btn_printfor":
                	goPrint();
                	break;
                case "btn_close":
                	ComClosePopup(); 
                	break;                           
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111");
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
     function setComboObject(combo_obj){
       	comboObjects[comboCnt++]=combo_obj;
     }
     function zone_code_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode)
     {
    	var t_cd = comboObjects[0].GetSelectCode();
    	if (comboObj.GetText(parseInt(newindex), 0) != undefined)
    		form.zone_code_text.value = comboObj.GetText(parseInt(newindex), 0);
     }
     function bkg_sts_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode)
     {
    	var t_cd = comboObjects[0].GetSelectCode();
    	if (comboObj.GetText(parseInt(newindex), 0) != undefined)
    		form.bkg_sts_cd_text.value = comboObj.GetText(parseInt(newindex), 0);
     }
    /*
	* RD printer function
	* @param 
	*/
    function goPrint()
 	{		
 		var sheetObj=sheetObjects[0];
 		var formObj=document.form;
 		var rdPath="apps/opus/esm/bkg/bookingreport/specialreport/report/ESM_BKG_5019.mrd";
 		var where="";
 		var param=new Array("vvd_cd", "pol_cd", "pol_nod_cd", "chk_l_type", "chk_t_type", "zone_code", "spcl_cgo_type", "pod_cd", "pod_nod_cd", "por_cd", "por_nod_cd", "del_cd", "del_nod_cd", "bkg_ofc_cd", "ob_srep_cd", "bkg_staff_type", "bkg_staff", "bkg_sts_cd", "spcl_cgo_apro_cd");
 		if(!validateForm(sheetObj,formObj,IBSEARCH)) return;
 		if (sheetObj.RowCount()< 1) {
			ComShowCodeMessage("BKG00495");
			return;
		}
 		//where  = "PERIOD_TYPE[]" + "FROM_DT[]" + "TO_DT[]" + "OFC_CD[]"+"STATUS_CD[]"+"PERIOD[]";
 		where=getParam(param);
 		if((formObj.chk_l_type.checked == true && formObj.chk_t_type.checked == true) || (formObj.chk_l_type.checked == false && formObj.chk_t_type.checked == false)){
 			where += "cargo_type[ALL] "
 		}if(formObj.chk_l_type.checked == true ){
 			where += "cargo_type[L] "
 		}if(formObj.chk_t_type.checked == true ){
 			where += "cargo_type[T] "
 		} 
		if(sheetObj.CheckedRows("Check") > 0 ){
 			var checkedRows=sheetObj.FindCheckedRow("Check");
			var arrRow=checkedRows.split("|");
			var selectRow=arrRow[0];
			where += "bkg_no["+sheetObj.GetCellValue(selectRow, "bkg_no")+"] ";
		} else{
			where += "bkg_no[] ";
		}
 		formObj.com_mrdPath.value=rdPath;
 		//alert(where);
 		//debug.innerHTML = where;
 		formObj.com_mrdArguments.value="/rv "  + where + " /riprnmargin /rwait";
 		formObj.com_mrdTitle.value="Special cargo summary";
 		formObj.com_mrdDisableToolbar.value="";
		formObj.com_mrdBodyTitle.value="<span style=&quot;color:red&quot;>Special cargo summary</span>";
		ComOpenRDPopup();
 	}
    /*
	* getting RD printer parameter
	* @param param
	* @return rParam
	*/
    function getParam(param){
    	var formObj=document.form;
    	var rParam="";
    	for(i=0;i<param.length;i++){
    		rParam += param[i]+"["+ComTrim(ComGetObjValue(eval("document.form."+param[i]))) + "] ";
    	}
    	return rParam;
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
         initControl();
         //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         bkg_sts_cd.SetSelectIndex(0);
         zone_code.SetSelectIndex(0);
     }
     /**
      * loading HTML Control event<br>
      */
     function initControl() {
     	DATE_SEPARATOR="-";
     	var formObject=document.form;
//     	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- in case of typing keyboard

     	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
     	combo1=comboObjects[0];
 		comboCnt=comboObjects.length;
 		// initializing IBMultiCombo
 	    for(var k=0; k<comboObjects.length; k++){
 	       initCombo(comboObjects[k]);
 	       
 	    }
     	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
     }
      /**
       * setting sheet initial values and header
       * @param sheetObj
       * @param sheetNo
       * @return
       */
     function initSheet(sheetObj,sheetNo) {
        var cnt=0;
 		var sheetID=sheetObj.id;
         switch(sheetID) {
			case "sheet1":      //sheet1 init
			    with(sheetObj)
			    {
 			      var HeadTitle1="||No.|SP|Booking number|ST|Seq.|Seq.|Appr|UM|A.POD|T/S|F.DEL|Container number|TP|Cargo\nWeight(KGS)|DG\nCLS|UN No|Temp(c)|Vent|Vent|AK-Over Dimension / BB-Cargo Dimension \nDG-Sub Label|Stow|DG Approval Reference No.|||";
 			      var HeadTitle2="||No.|SP|Booking number|ST|CNT|CGO|Appr|UM|A.POD|T/S|F.DEL|Container number|TP|Cargo\nWeight(KGS)|DG\nCLS|UN No|Temp(c)|Value|TP|AK-Over Dimension / BB-Cargo Dimension \nDG-Sub Label|Stow|DG Approval Reference No.|||";
 			      var headCount=ComCountHeadTitle(HeadTitle1);
 			      (headCount, 0, 0, true);
// 			      SetMergeCell(0,1,2,1);
// 			      SetMergeCell(0,2,2,1);
// 			      SetMergeCell(0,3,2,1);
// 			      SetMergeCell(0,4,2,1);
// 			      SetMergeCell(0,5,2,1);
// 			      SetMergeCell(0,6,1,1);
// 			      SetMergeCell(0,8,2,1);
// 			      SetMergeCell(0,9,2,1);
// 			      SetMergeCell(0,10,2,1);
// 			      SetMergeCell(0,11,2,1);
// 			      SetMergeCell(0,12,2,1);
// 			      SetMergeCell(0,13,2,1);
// 			      SetMergeCell(0,14,2,1);
// 			      SetMergeCell(0,15,2,1);
// 			      SetMergeCell(0,16,2,1);
// 			      SetMergeCell(0,17,2,1);
// 			      SetMergeCell(0,18,2,1);
// 			      SetMergeCell(0,19,2,1);
// 			      SetMergeCell(0,20,2,1);
// 			      SetMergeCell(0,21,2,1);
// 			      SetMergeCell(0,22,2,1);
 			      SetConfig( { SearchMode:2, FrozenCol:6, MergeSheet:8, Page:20, DataRowMerge:0 } );
 			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
 			      var headers = [ { Text:HeadTitle1, Align:"Center"},
 			                      { Text:HeadTitle2, Align:"Center"} ];
 			      InitHeaders(headers, info);
 			      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"HidStatus" },
 			             {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Check",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 			             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"no" },
 			             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_type",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"bkg_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0, 	SaveName:"spcl_cntr_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,  SaveName:"spcl_cgo_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"auth_result_t",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"um",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ts",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"tp_sz",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"wgt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dg_class",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"un_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cdo_temp",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vent",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			            {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_vent_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"Text",      Hidden:0, Width:280,  Align:"Left",    ColMerge:0,   SaveName:"over_size",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"stow",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"dg_appr_ref",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
 			      InitColumns(cols);
 			      SetEditable(1);
 			      FrozenCols=6;
 			      SetSheetHeight(385);
 			      SetRangeBackColor(1,6,1,7,"#555555");
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
         switch(sAction)
         {
	         case IBCLEAR: // retrieve in case of loading page
					formObj.f_cmd.value=INIT;
					var sXml=sheetObj.GetSearchData("ESM_BKG_0588GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
					if (arrXml.length > 1) 
						ComXml2ComboItem(arrXml[1], bkg_sts_cd, "val", "name");
					if (arrXml.length > 0) 
						ComXml2ComboItem(arrXml[0], zone_code, "val", "desc");
					bkg_sts_cd.SetSelectIndex(0);
					zone_code.SetSelectIndex(0);
					break;
					
	         case IBSEARCH:      //retrieve
	     	   	if(validateForm(sheetObj,formObj,sAction)){
		        	  formObj.f_cmd.value=SEARCH;
		        	  sheetObj.DoSearch("ESM_BKG_0588GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(""));
		          	} 
	             break;
	             
	         case IBDOWNEXCEL:      
	        	 sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
	        	 break;		    
         }
     }
     /**
      * combo initial setting data
      * @param comboObj
      */
      function initCombo(comboObj) {
      	comboObj.SetDropHeight(150);
      }  
      /**
       * handling process for input validation
       */
      function validateForm(sheetObj,formObj,sAction){
     	 with(formObj){
          	switch(sAction) {
 		     	case IBSEARCH: 
 			  		if (!ComChkValid(formObj)) return false;
 			  		break;
          	}	
          }		
          return true;
      }
      /**
       * save data getting data from Node Search popup<br>
       * @param locTp
       * @param rArray
       * @return 
       */
      function callBack0083(locTp, tab, rArray){    	
      	var formObj=document.form;
      	if(rArray != null){
      		switch(tab) {
		        case 2:
		  	    	if(locTp == "POR"){
		  	    		formObj.por_cd.value=rArray[0][4].substring(0,5);
		  	    		formObj.por_nod_cd.value=rArray[0][4].substring(5,7);
		  	    	}else if(locTp == "POL"){
		  	    		formObj.pol_cd.value=rArray[0][4].substring(0,5);
		  	    		formObj.pol_nod_cd.value=rArray[0][4].substring(5,7);
		  	    	}else if(locTp == "POD"){
		  	    		formObj.pod_cd.value=rArray[0][4].substring(0,5);
		  	    		formObj.pod_nod_cd.value=rArray[0][4].substring(5,7);
		  	    	}else{
		  	    		formObj.del_cd.value=rArray[0][4].substring(0,5);
		  	    		formObj.del_nod_cd.value=rArray[0][4].substring(5,7);	
		  	    	}	    	
		  	    	break;
		        case 1:
		        	if(locTp == "POR"){
		  	    		formObj.por_cd.value=rArray[0][2].substring(0,5);
		  	    		formObj.por_nod_cd.value=rArray[0][2].substring(5,7);
		  	    	}else if(locTp == "POL"){
		  	    		formObj.pol_cd.value=rArray[0][2].substring(0,5);
		  	    		formObj.pol_nod_cd.value=rArray[0][2].substring(5,7);
		  	    	}else if(locTp == "POD"){
		  	    		formObj.pod_cd.value=rArray[0][2].substring(0,5);
		  	    		formObj.pod_nod_cd.value=rArray[0][2].substring(5,7);
		  	    	}else{
		  	    		formObj.del_cd.value=rArray[0][2].substring(0,5);
		  	    		formObj.del_nod_cd.value=rArray[0][2].substring(5,7);	
		  	    	}
		        	break;
      		}
      	}
      }          
      function CheckGrid(sheetObject,colName,prefix){
  		var iCheckRow=sheetObject.FindCheckedRow(prefix + colName);
  		if (iCheckRow== "") {
  			ComShowCodeMessage('BKG00249');
  			return false;
  		}
  		return true;
	  }	
	  function getCheckedRow(sheetObj,colName) {
  		var checkRow = sheetObj.FindCheckedRow(colName);
  		var arrRow = checkRow.split("|");
  		if(sheetObj.GetCellValue(arrRow[0], colName) == 1) {
  	  			return arrRow[0];
       		}
	  }
	  function sheet1_OnSort(sheetObj) {
		  setSeqNo(sheetObj);
	  }
	  function sheet1_OnSearchEnd(sheetObj) {
		  setSeqNo(sheetObj);
          with (sheetObj) {
	      	  SetColFontUnderline("bkg_no",1);
	          SetColFontColor("bkg_no","#0000FF");
          }
	  }
	  function setSeqNo(sheetObj) {
		  for (var i=2; i<sheetObj.RowCount()+2; i++) {
			  sheetObj.SetCellValue(i,"no",i-1,0);
		  }
	  }
	  function sheet1_OnClick(sheetObj, row, col) {
		if ("bkg_no"==sheetObj.ColSaveName(col)) {
			comBkgCallPopBkgDetail(sheetObj.GetCellValue(row, "bkg_no"));
		}
	}
