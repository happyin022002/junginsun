/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : UI_MNR_0010.js
*@FileTitle  : Repair Approval Authority
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends 
	 * @class ees_mnr_0010 : business script for ui_mnr_0010.
	 */
/* developer job	*/
	var nowLoad=0;
	var regionalHQ="";
	var operationOfc="";
	var upperOfc="";
	var cost_cdCode="";
	var cost_cdDesc="";
	var equipmentKindCode="";
	var equipmentKindDesc="";
	var currencyKindCode="";
	var currencyKindDesc="";
	var HOOfc="";	
	var initLoader=0;
	var sheetObjects=new Array();
	var sheetCnt=0;
	document.onclick=processButtonClick;
    function processButtonClick(){
	      var sheetObject=sheetObjects[0];
	      /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
        	    case "btn_Retrive":
        	    	 doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
        	    	 break;
				case "btn_New":
					doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
					break;
				case "btn_Save":
					 doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
					 break;
				case "btn_RowAdd":
					doRowAdd(sheetObjects[0], formObject);
					break;
				case "btn_Delete":
					if(sheetObjects[0].FindCheckedRow("del_chk") == ""){
						ComShowCodeMessage("MNR00038","DELETE ");
						return false;             	   
					}
					if(ComShowCodeConfirm("MNR00026")){
						ComRowHideDelete(sheetObjects[0], "del_chk");
					}
					break;
				case "btn_Excel":
					if(sheetObjects[0].RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol( sheetObjects[0]), SheetDesign:1,Merge:1, AutoSizeColumn:1});
					}
					break;					
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {     
				ComFuncErrMsg(e);          
			} else {      
				ComFuncErrMsg(e);    
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
	  * initializing multi Combo 
	  * @return
	  */
	function initCombo() {
	     with (combo1) {
			   SetMultiSeparator("|");
			   SetTitle("Office Code|Office Name");
		       //MultiSelect = false;
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				SetColWidth(0, "100");
				SetColWidth(1, "150");
				SetTitleVisible(1);
			   SetDropHeight(160);
	     } 
		 with ( combo2) { 
			   SetMultiSeparator("|");
			   SetTitle("Office Code|Office Name");
		       //MultiSelect = false;
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				SetColWidth(0, "100");
				SetColWidth(1, "150");
				SetTitleVisible(1);
			   SetDropHeight(160);
	   } 
		 with ( combo3) { 
			   SetMultiSeparator("|");
			   //SetTitle("Equipment Code|Equipment Name");
		       //MultiSelect = false;
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				SetColWidth(0, "110");
				SetColWidth(1, "0");
			   SetDropHeight(160);
	   } 
	}
    /**
	  * initializing sheet
	  * implementing onLoad event handler in body tag
	  * adding first-served functions after loading screen.
	  */
    function loadPage() {
		MnrWaitControl(true);
		var formObject=document.form;
		for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		sheetObjects[0].SetWaitImageVisible(0);
		initCombo(); 
		MnrOfficeLevel(currOfcCd,rhqOfcCd);
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		sheetObjects[0].SetWaitImageVisible(1);
    }
      /**
	  * setting Operation Office on loading
	  * @return
	  */
    function initOperationOfc(){
		    var result="";
			var sCondition=new Array (
					new Array("MdmOrganization","SEARCH","NOTHQ")   //Office
				);   
			var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
		 	if(comboList[0] != null){
			 	for(var i=0; i < comboList[0].length;i++){ 
			 		   var code=comboList[0][i].substring(0, comboList[0][i].indexOf('|') );
			 		   result=result + code + "|";
			 	}
			 	result=result.substring(0, result.length - 1);
			 	sheetObjects[0].SetColProperty(0,sheetObjects[0].SaveNameCol("ofc_cd"), {ComboText:result, ComboCode:result} );
			 	sheetObjects[0].SetColProperty(0,sheetObjects[0].SaveNameCol("uppr_ofc_cd"), {ComboText:result, ComboCode:result} );
		 	}
	 }
    /**
	  * setting sheet initial values and header
	  * param : sheetObj, sheetNo
	  * adding case as numbers of counting sheets
	  */
    function initSheet(sheetObj,sheetNo) {
    	 var cnt=0;
		 var sheetId=sheetObj.id;
	     switch(sheetId) {
	         case "sheet1":
	        	    with(sheetObj){
		           var HeadTitle1="|Sel|Seq.|Regional\nH/Q|Operation\nOffice|Upper\nOffice|Equipment \nType|Currency|Effective\n From Date|After Effective Date|After Effective Date|Before Effective Date|Before Effective Date";
		           var HeadTitle2="|Sel|Seq.|Regional\nH/Q|Operation\nOffice|Upper\nOffice|Equipment \nType|Currency|Effective\n From Date|Group\nApproval|Self\nAuthority|Group\nApproval|Self\nAuthority";
	
		           SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		           var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		           var headers = [ { Text:HeadTitle1, Align:"Center"},
		                       { Text:HeadTitle2, Align:"Center"} ];
		           InitHeaders(headers, info);
	
		           var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                  {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
		                  {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                  {Type:"Text",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ar_hd_qtr_ofc_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Combo", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                  {Type:"Combo", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"uppr_ofc_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                  {Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cost_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",             KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"aft_auto_apro_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		                  {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"aft_self_auth_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		                  {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"bfr_auto_apro_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		                  {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"bfr_self_auth_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		                  {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"org_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"org_mnr_grp_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"org_cost_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
		            
		           InitColumns(cols);
	
		           SetEditable(1);
	               SetSelectionMode(smSelectionRow);
	
	               PopupImage="img/btns_calendar.gif";
		           SetShowButtonImage(2);
//		           SetSheetHeight(525);
		           resizeSheet( sheetObj );
	           }


         break;
        }
    }
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
  // 
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
     		case IBSEARCH:      //retrieving
   				doIBSEARCH(sheetObj,formObj,sAction);
     		break;
     		case IBSAVE:        //saving
     			doIBSAVE(sheetObj,formObj,sAction);
     		break;
		   case IBCLEAR:
			   doIBCLEAR(sheetObj,formObj,sAction);
           break;				
        }
    }
    /**
     * handling event when saving.
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return
     */
    function doIBSAVE(sheetObj,formObj,sAction){
       MnrWaitControl(true);
       if ( !sheetObj.RowCount() == 0 ) sheetObj.SelectCell(sheetObj.GetSelectRow(), "Seq") ;
       if(!doCheckApproval(sheetObj,formObj,sAction)){
    	   MnrWaitControl(false);
    	   return;
       }
 	   if(!validateForm(sheetObj,formObj,sAction)){
 		   MnrWaitControl(false);
 		   return;
 	   }
 	  if (!ComShowCodeConfirm("MNR00160","")){
 		 MnrWaitControl(false);
 		  return false;
	  }
 	  ///sheetObjects[0].RenderSheet(0);
	  sheetObjects[0].SetWaitImageVisible(0);
	  formObj.f_cmd.value=MULTI;
      var sParam=ComGetSaveString(sheetObjects);
       if (sParam == ""){
    	   sheetObjects[0].LoadSaveData(sXml);
     	   ///sheetObjects[0].RenderSheet(1);
     	   MnrWaitControl(false);
    	   return;
       }
       sParam += "&" + FormQueryString(formObj) ;
       // alert(sParam);
       var sXml=sheetObj.GetSaveData("EES_MNR_0010GS.do", sParam);
       sheetObjects[0].LoadSaveData(sXml);
 	   ///sheetObjects[0].RenderSheet(1);
 	   doIBSEARCH(sheetObj,formObj,sAction);
 	   MnrWaitControl(false);
    }
     /**
      *  aft_auto_apro_amt can not be larger than aft_self_auth_amt.
      *  bfr_auto_apro_amt can not be larger than bfr_self_auth_amt.
      * @param sheetObj
      * @param formObj
      * @param sAction
      * @return
      */
    function doCheckApproval(sheetObj,formObj,sAction){
    	//alert(sheetObjects[0].HeaderRows + " :::: "+ sheetObjects[0].LastRow );
    	for(i=sheetObjects[0].LastRow(); i > 0 ; i--){
    		// checking in case of ibflag in (I, U).
    		if ( (sheetObjects[0].GetRowStatus(i)  != "D" )
    				&&(sheetObjects[0].GetRowStatus(i)  != "R" ) ){
    			    //alert( sheetObjects[0].RowStatus(i) + " >>> "+  (sheetObj.CellValue(i, sheetObj.SaveNameCol("aft_auto_apro_amt") )) +"::::"+ parseFloat(sheetObj.CellValue(i, sheetObj.SaveNameCol("aft_self_auth_amt"))) )
    			var tmp3=sheetObj.GetCellValue(i, "aft_auto_apro_amt");
    			var tmp4=sheetObj.GetCellValue(i, "aft_self_auth_amt");
    			    if( parseFloat(tmp3) > parseFloat(tmp4) ){
		    			 ComShowCodeMessage("MNR00166");
						 sheetObjects[0].SetCellValue(i, sheetObjects[0].SaveNameCol("aft_auto_apro_amt"),"",0);
					     sheetObjects[0].SelectCell(i, sheetObjects[0].SaveNameCol("aft_auto_apro_amt"));
		    			 return false;
		    		}
		    		//alert( sheetObjects[0].RowStatus(i) + " >>> "+  sheetObj.CellValue(i, "bfr_auto_apro_amt") +"::::"+ sheetObj.CellValue(i, "bfr_self_auth_amt") );
    			    var tmp1=sheetObj.GetCellValue(i, "bfr_auto_apro_amt") ;
    			    var tmp2=sheetObj.GetCellValue(i, "bfr_self_auth_amt");
		    		//alert(tmp1 + " :::: "+ tmp2);
		    		if( parseFloat(tmp1) >  parseFloat(tmp2)  ){
		    			 ComShowCodeMessage("MNR00166");
		    			 sheetObjects[0].SetCellValue(i, sheetObjects[0].SaveNameCol("bfr_auto_apro_amt"),"",0);
					     sheetObjects[0].SelectCell(i, sheetObjects[0].SaveNameCol("bfr_auto_apro_amt"));
		    			return false;
		    		}
    		}
    	}
    	return true;
    }
    /**
     * handling process searching event
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return
     */
    function doIBSEARCH(sheetObj,formObj,sAction){
//    	 MnrWaitControl(true);
    	 if((sheetObj.RowCount("I") > 0)
    		||(sheetObj.RowCount("U") > 0)
    		||(sheetObj.RowCount("D") > 0)
    	 ){
    		 if(ComShowCodeConfirm("MNR00007")){
    				///sheetObjects[0].RenderSheet(0);
    		  		sheetObjects[0].SetWaitImageVisible(0);
    		 	    formObj.f_cmd.value=SEARCH;
    		 	    //alert(FormQueryString(formObj));
    		 	    var sXml=sheetObj.GetSearchData("EES_MNR_0010GS.do",  FormQueryString(formObj));
    		 	    //alert(sXml);
    		 		sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
    		 		///sheetObjects[0].RenderSheet(1);
    		 }
//    		 MnrWaitControl(false);
    	 }else{
	    	///sheetObjects[0].RenderSheet(0);
	  		sheetObjects[0].SetWaitImageVisible(0);
	 	    formObj.f_cmd.value=SEARCH;
	 	    //alert(FormQueryString(formObj));
	 	    var sXml=sheetObj.GetSearchData("EES_MNR_0010GS.do",  FormQueryString(formObj));
	 	    //alert(sXml);
	 		sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
	 		///sheetObjects[0].RenderSheet(1);
    	 }
    }
     function sheet1_OnSearchEnd(sheetObj, errMsg) {
    	 // setting Non-edit in case of ofc_cd is equal to currOfCd in loading data 
    	 for(i=sheetObjects[0].LastRow(); i > 0 ; i--){
    		 if(currOfcCd != sheetObj.GetCellValue(i, "ofc_cd")){
    			 //alert(HOOfc + " :: "+ currOfcCd + " :: "+rhqOfcCd);
    			 if(HOOfc != currOfcCd){
    				 if(strMnrOfficeLevel=="L2"){
    					 if(sheetObj.GetCellValue(i, "ar_hd_qtr_ofc_cd") != currOfcCd){
    						 sheetObj.SetRowEditable(i,0);
    		    			 sheetObj.SetCellEditable(i, "del_chk",0);
    		    			 sheetObj.SetCellEditable(i, "ofc_cd",0);
    					 }
    				 }else{
    					 sheetObj.SetRowEditable(i,0);
    	    			 sheetObj.SetCellEditable(i, "del_chk",0);
    	    			 sheetObj.SetCellEditable(i, "ofc_cd",0);
    				 }
    			 }
    		 }
    	 }
    	 sheetObj.CheckAll("del_chk",0);
//    	 MnrWaitControl(false);
     }
     /**
      * initializing sheetObject
      * @param sheetObj
      * @param formObj
      * @param sAction
      * @return
      */
    function doIBCLEAR(sheetObj,formObj,sAction){
    	MnrWaitControl(true);
    	ComOpenWait(true);
    	nowLoad=1;
		var btnFlag=false;
    	sheetObjects[0].SetWaitImageVisible(0);
    	//alert( formObj.combo1.GetCount() + " >>>>"+  formObj.combo2.GetCount() + ">>>>"+  formObj.combo3.GetCount());
    	if(initLoader == 0){
			//initializing Combo Data
			currencyKindCode="";
			currencyKindDesc="";
			cost_cdCode="";
			cost_cdDesc="";
			regionalHQ="";
			combo1.RemoveAll();
			combo2.RemoveAll();
			combo3.RemoveAll();
			//setting combo 
			var sCondition=new Array (
					new Array("MnrGenCd"   ,  "HOOFC", "COMMON") //HOofc 
				   ,new Array("MdmCurrency",       "", "COMMON") //currency combo
				   ,new Array("MnrGenCd"   ,"CD00015", "COMMON") //cost_cd combo
				   ,new Array("MdmOrganization","RHQ", "FALSE")  //RHQ
				);   
			var comboList=MnrComSearchCombo(sheetObj,sCondition);
			for(var i=0; i<comboList.length; i++)
			{	
				if(comboList[i] != null)
				{
					for(var j=0; j < comboList[i].length;j++)
					{   
						var xmlVal=comboList[i][j].split("|");  
						if(i==0){
							HOOfc=xmlVal[0];
						}else if(i==1){
		 		 		   currencyKindCode=currencyKindCode + xmlVal[0] + "|";
		 		 		   currencyKindDesc=currencyKindDesc + xmlVal[0]+"\t"+xmlVal[1] + "|";
		 		 		   
		 		 		   if(j==(comboList[i].length-1))
		 		 		   {
		 		 			   currencyKindCode = MnrDelLastDelim(currencyKindCode);
			 		 		   currencyKindDesc = MnrDelLastDelim(currencyKindDesc);
			 		 		   sheetObjects[0].SetColProperty(0,sheetObjects[0].SaveNameCol("curr_cd"), {ComboText:currencyKindDesc, ComboCode:currencyKindCode} );
		 		 		   }
						}else if(i==2){
							combo3.InsertItem(j, xmlVal[1] , xmlVal[0]);
		 		 		   cost_cdCode=cost_cdCode + xmlVal[0] + "|";
		 		 		   cost_cdDesc=cost_cdDesc + xmlVal[1] + "|";
		 		 		   
		 		 		   if(j==(comboList[i].length-1))
		 		 		   {
					 	 		combo3.InsertItem(0, "ALL" , "ALL");
							 	combo3.SetSelectCode("ALL");
							 	cost_cdCode = MnrDelLastDelim(cost_cdCode);
				 		 		cost_cdDesc = MnrDelLastDelim(cost_cdDesc);
							 	sheetObjects[0].SetColProperty(0,sheetObjects[0].SaveNameCol("cost_cd"), {ComboText:cost_cdDesc, ComboCode:cost_cdCode} );
		 		 		   }
						}else if(i==3){
						 	combo1.InsertItem(j, comboList[i][j] , xmlVal[0]);
						 	combo1.SetSelectCode(xmlVal[0]);
						 	regionalHQ=regionalHQ + xmlVal[0] + "|";
							if(xmlVal[0]==currOfcCd && btnFlag==false)
							{
								btnFlag=true
							}
						}
					}
					if(i==3){
						combo1.InsertItem(0, "ALL" , "ALL");
						regionalHQ=regionalHQ.substring(0, regionalHQ.length - 1);
						//alert(HOOfc + " :: "+ currOfcCd + " :: "+rhqOfcCd);
						if(HOOfc != currOfcCd){
							///combo1.SetEnable(0);
							combo1.SetSelectCode(rhqOfcCd);
							combo2.SetSelectCode("ALL");
							regionalHQ=currOfcCd ;
						}else{
							combo1.SetSelectCode("ALL");
							combo2.SetSelectCode("ALL");
						}	
					}
				}
				else
				{
					if(i==0){
						HOOfc="";
					}else if(i==1){
						ComShowCodeMessage("MNR00005", "Currency Code  ");
					}else if(i==2){
			 	 		ComShowCodeMessage("MNR00005", "Class Type (COST_CD) Code  ");
					}else if(i==3){
			 	 		ComShowCodeMessage("MNR00005", "RHQ Code  ");
					}
				}
			}			
			 comboOnChange(combo1,combo1.GetSelectText(), combo1.GetSelectText());
			 initLoader=1;		
    	}
		 //initializing sheet
		 sheetObj.RemoveAll();
	   //alert(regionalHQ);
//		 var info = {ComboText:regionalHQ, ComboCode:regionalHQ};
//         sheetObjects[0].InitCellProperty(0, "ar_hd_qtr_ofc_cd", info);
		 
		 initOperationOfc();
		 sheetObjects[0].SetWaitImageVisible(1);
		 combo2.SetSelectCode("ALL");
		 combo3.SetSelectCode("ALL");
		 nowLoad=0;     
		 ComOpenWait(false);
		 MnrWaitControl(false);
		 //showing message, disable button in case of or both Headquarters and RHQ Office 
		 if(HOOfc != currOfcCd && strMnrOfficeLevel=="L3"){
			 combo1.SetEnable(0);
			 combo2.SetEnable(0);
			 combo3.SetEnable(0);
//			 MnrWaitControl(true);
			 ComBtnDisable("btn_Save");
			 ComBtnDisable("btn_RowAdd");
			 ComBtnDisable("btn_Delete");
			 ComShowCodeMessage("MNR00312", "operate the Equipment Repair Approval Authority Creation");
		 }
    }
    /**
     * //handling event in case of clicking row add button
     * @param sheetObj
     * @param formObj
     * @return
     */
	 function doRowAdd(sheetObj, formObj){
		    nowLoad=1;
		    var iRow=sheetObjects[0].DataInsert(-1);
		    
			if(HOOfc != currOfcCd){ 
				   sheetObjects[0].SetCellValue(iRow,  sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd"),rhqOfcCd,0);
//				   sheetObj.SetCellValue(Row, sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd"),currOfcCd,0);
				   //cellSetItems(sheetObjects[0], iRow, sheetObjects[0].SaveNameCol("ofc_cd"),   sheetObjects[0].CellValue(iRow,  sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")));
				   sheetObjects[0].SetCellValue(iRow,  sheetObjects[0].SaveNameCol("ofc_cd"),"",0);
				   sheetObjects[0].SetCellValue(iRow,  sheetObjects[0].SaveNameCol("uppr_ofc_cd"),"",0);
				   sheetObjects[0].SetCellValue(iRow,  sheetObjects[0].SaveNameCol("curr_cd"),"USD",0);
				   if(combo3.GetSelectCode()== "ALL"){
					   sheetObjects[0].SetCellValue(iRow,  sheetObjects[0].SaveNameCol("cost_cd"),"MRD",0);
				   }else{
					   sheetObjects[0].SetCellValue(iRow,  sheetObjects[0].SaveNameCol("cost_cd"),combo3.GetSelectCode(),0);
				   }
			}else{
				   if( combo1.GetSelectCode()== "ALL"){
					   sheetObjects[0].SetCellValue(iRow,  sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd"),rhqOfcCd,0);
				   }else{
					   sheetObjects[0].SetCellValue(iRow,  sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd"),combo1.GetSelectCode(),0);
				   } 
				   //cellSetItems(sheetObjects[0], iRow, sheetObjects[0].SaveNameCol("ofc_cd"),   sheetObjects[0].CellValue(iRow,  sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")));
				   sheetObjects[0].SetCellValue(iRow,  sheetObjects[0].SaveNameCol("ofc_cd"),"",0);
				   sheetObjects[0].SetCellValue(iRow,  sheetObjects[0].SaveNameCol("uppr_ofc_cd"),"",0);
				   sheetObjects[0].SetCellValue(iRow,  sheetObjects[0].SaveNameCol("curr_cd"),"USD",0);
				   if(combo3.GetSelectCode()== "ALL"){
					   sheetObjects[0].SetCellValue(iRow,  sheetObjects[0].SaveNameCol("cost_cd"),"MRD",0);
				   }else{
					   sheetObjects[0].SetCellValue(iRow,  sheetObjects[0].SaveNameCol("cost_cd"),combo3.GetSelectCode(),0);
				   }
			}
			sheetObjects[0].SelectCell(iRow, sheetObjects[0].SaveNameCol("Seq")) ;
			nowLoad=0;
	 }	  
  /**
   * in case of onChange combo event
   * @param comboObj
   * @param Index_Code
   * @param Text
   * @return
   */
	//function combo1_OnChange(comboObj,Index_Code, Text){
	function combo1_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
		   if(nowLoad == 0){
			   comboOnChange(comboObj,NewCode, NewText);
		   }
	}
   /**
	 * in case of onChange combo event 
	 * @param comboObj
	 * @param Index_Code
	 * @param Text
	 * @return
	 */   
	function comboOnChange(comboObj,Index_Code, Text){ 
		//alert(comboObj +" :: "+ Index_Code + " :: "+ Text);
		var formObj=document.form;
		combo2.RemoveAll();
		sheetObjects[0].SetWaitImageVisible(0);
//	 	ComOpenWait(true);
		if(Index_Code=="ALL") Index_Code="%";
		var sCondition=new Array (
				new Array("MdmOrganization","SEARCH",Index_Code)   //Office
		);   
		var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
	 	if(comboList[0] != null){
		 	for(var i=0; i < comboList[0].length;i++){ 
			 	   var code=comboList[0][i].substring(0, comboList[0][i].indexOf('|') );
		 		   combo2.InsertItem(i, comboList[0][i] , code);
		 		   combo2.SetSelectCode(code);
		 	}
		 	combo2.InsertItem(0, "ALL" , "ALL");
		 	combo2.SetSelectCode("ALL");
	 	}
//    	ComOpenWait(false);
		sheetObjects[0].SetWaitImageVisible(1);
	} 
    /**
     * checking validation of operation office.
     * @param strhq
     * @param strofc
     * @param Row
     * @param Col
     * @return
     */
    function  checkOperationOfc(strhq, strofc, Row, Col){
	   var srchStr=strofc+","+strhq;
	   var retArray=MnrGeneralCodeCheck(sheetObjects[0],"OFC",srchStr);
	   if(retArray == null){
		   ComShowCodeMessage("MNR00010", "Office");
		   sheetObjects[0].SetCellValue(Row, sheetObjects[0].SaveNameCol("ofc_cd"),"",0);
	       sheetObjects[0].SelectCell(Row, sheetObjects[0].SaveNameCol("ofc_cd"));
	   }
    }
     /**
      * checking uppr_ofc_cd 
      * @param strofc
      * @param Row
      * @param Col
      * @return
      */
    function  checkUpprOfc(strofc, Row, Col){
	    //alert(strofc+"||"+Row+"||"+Col);
	    var result="";
		var sCondition=new Array (
				new Array("MdmOrganization","SEARCH","NOTHQ")   //Office
			);   
		var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
	 	var chkofc=false;
	 	if(comboList[0] != null){
		 	for(var i=0; i < comboList[0].length;i++){ 
				   var strcbo=comboList[0][i].split('|');
		 		   if(strcbo[0] == strofc ){
		 			   chkofc=true;
		 			   break;
		 		   }
		 	}
		 	if(chkofc != true){
		 		   ComShowCodeMessage("MNR00010", "Upper Office");
				   sheetObjects[0].SetCellValue(Row, sheetObjects[0].SaveNameCol("uppr_ofc_cd"),"",0);
			       sheetObjects[0].SelectCell(Row, sheetObjects[0].SaveNameCol("uppr_ofc_cd"));
		 	}else{
		 		var uppr=sheetObjects[0].GetCellValue(Row, "uppr_ofc_cd");
		 		var ofc=sheetObjects[0].GetCellValue(Row, "ofc_cd");
		 		 if( uppr == ofc  ){
			    	   ComShowCodeMessage("MNR00188");
					  //sheetObjects[0].CellValue2(Row, sheetObjects[0].SaveNameCol("uppr_ofc_cd")) = "";
				       sheetObjects[0].SelectCell(Row, "uppr_ofc_cd",true,"");
			       }
		 	}
	 	}
	}
    /**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
	        with(formObj){
				if(sAction==IBSAVE) {
					 if (!ComChkValid(formObj)) return false;
					//duplicate checking When saving 
				for (var i=0; i<sheetObjects.length; i++){
					var Row=sheetObjects[i].ColValueDup( "ofc_cd|uppr_ofc_cd|cost_cd");
					if(sheetObjects[i].IsDataModified()){
						if(Row>0){
								ComShowCodeMessage("MNR00006",i + 1 + "th sheet of " + Row + " row ");
								return false;
							}
						}
					else
						{
							ComShowCodeMessage("MNR00030","The data which to save");
							return false;
						}
					}
				}
	        }
	     return true;
	 }
	/**
    * setting combo of operation office.
    * @param sheetObj
    * @param Row
    * @param Col
    * @param Value
    * @return
    */
	function cellSetItems(sheetObj, Row, Col, Value){
		   // alert(sheetObj + " :: "+ Row + " :: "+ Col + " :: "+ Value);
		var sCondition=new Array (
				new Array("MdmOrganization","SEARCH",Value)   //Office
			);   
		var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
	 	if(comboList[0] != null){
		 	operationOfc="";
			sheetObjects[0].CellComboItem(Row,Col, {ComboText:operationOfc, ComboCode:operationOfc} );
		 	for(var i=0; i < comboList[0].length;i++){ 
		 		   var code=comboList[0][i].substring(0, comboList[0][i].indexOf('|') );
		 		   operationOfc=operationOfc + code + "|";
		 	}
		 	operationOfc=operationOfc.substring(0, operationOfc.length - 1);
		 	sheetObjects[0].CellComboItem(Row,Col, {ComboText:operationOfc, ComboCode:operationOfc} );
		 	if(sheetObj.GetCellValue(Row, Col) == ""){
		 		sheetObjects[0].SetCellValue(Row, Col, operationOfc.substring(0,operationOfc.indexOf("|")));
		 	}
	 	}else{
	 		 ComShowCodeMessage("MNR00010", "Regional H/Q Office"); 
	 		 sheetObjects[0].SelectCell(Row, sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd"));
		 	}
	}
   /**
    * handling OnChange event
    * @param sheetObj
    * @param Row
    * @param Col
    * @param Value
    * @return
    */
	function sheet1_OnChange(sheetObj,Row, Col, Value){
	    	if(nowLoad == 0){
			    	//alert("ONChange "+ "<<<<<"+ HOOfc + " >>>> "+ currOfcCd); 
			   if(sheetObj.ColSaveName(Col) == "ar_hd_qtr_ofc_cd"){
				   if(HOOfc != currOfcCd){
					   sheetObj.SetCellValue(Row, sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd"),currOfcCd,0);
					   cellSetItems(sheetObj, Row, sheetObjects[0].SaveNameCol("ofc_cd"), currOfcCd);
				   }else{
					   // setting value to Operation Office
				  	   cellSetItems(sheetObj, Row, sheetObjects[0].SaveNameCol("ofc_cd"), Value);
				   }  
			   }else if(sheetObj.ColSaveName(Col) == "ofc_cd"){
				   checkOperationOfc(sheetObj.GetCellValue(Row, sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")), sheetObj.GetCellValue(Row, Col), Row, Col);
			   }else if(sheetObj.ColSaveName(Col) == "uppr_ofc_cd"){
				   checkUpprOfc(sheetObj.GetCellValue(Row, Col), Row, Col);
				   }
	    	}
	}   
    function sheet1_OnPopupClick(sheetObj, Row,Col,Value){
		 var formObject=document.form;
		   with(sheetObj) {
				var sName=ColSaveName(Col);
	        	switch (sName) {
					case "eff_dt":
					 var cal=new ComCalendarGrid("myCal");
				      cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
					break;
				}
	 		}
	}
   /**
    * handling click event on sheet1.
    * @param sheetObj
    * @param Row
    * @param Col
    * @param Value
    * @return
    */
	function sheet1_OnClick(sheetObj,Row, Col, Value){
		       if(sheetObj.GetCellEditable(Row, Col) == false) return;
			   if(sheetObj.ColSaveName(Col) == "ofc_cd"){
			   nowLoad=1;
			   //alert("ONClick "+ "<<<<<"+ HOOfc + " >>>> "+ currOfcCd); 
			   if(HOOfc != currOfcCd){
//				   sheetObj.SetCellValue(Row, sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd"),currOfcCd,0);
				   cellSetItems(sheetObjects[0], Row, sheetObjects[0].SaveNameCol("ofc_cd"),   currOfcCd);
			   }else{
				   // setting value to Operation Office
				   cellSetItems(sheetObj, Row, sheetObjects[0].SaveNameCol("ofc_cd"), sheetObj.GetCellValue(Row, sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")));
			   }  
			   //alert("ONClick end"+ "<<<<<"+ HOOfc + " >>>> "+ currOfcCd); 
			   nowLoad=0;
		   }
	   }
   /**
    * loading message after saving
    * @param sheetObj
    * @param ErrMsg
    * @return
    */   
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	  	  if (ErrMsg == "") { 
	  		  ComShowCodeMessage("MNR00023");   
	  	  } else { 
	  		  //ComShowCodeMessage("MNR00008",ErrMsg);  
	  	  }       
	  	  MnrWaitControl(false);
	}
    
    function sheet1_OnMouseDown(sheetObj,Button, Shift, X, Y){
    	var Row=sheetObj.MouseRow();
		var Col=sheetObj.MouseCol();
		var ColSaveName=sheetObj.ColSaveName(Col);
		if(ColSaveName == "ar_hd_qtr_ofc_cd"){
			if(sheetObj.GetRowEditable(Row)){
				var orgValue = sheetObj.GetCellValue(Row, Col);
				var info = {Type:"Combo"};
				var comboInfo = {"ComboCode":regionalHQ, "ComboText":regionalHQ};
		    	sheetObj.InitCellProperty(Row, "ar_hd_qtr_ofc_cd", info);
		    	sheetObj.CellComboItem (Row, "ar_hd_qtr_ofc_cd", comboInfo);
		    	sheetObj.SetCellValue(Row, Col, orgValue);
			}
		}
    	
    }
    
    
/* developer job */
