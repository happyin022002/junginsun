/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0003.js
*@FileTitle  : EQ Component
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/13
=========================================================*/
/****************************************************************************************
  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends Mnr
     * @class EES_MNR_0003 : EES_MNR_0003 - Defining a script used by screen
     */
   	/* Developer's task	*/
	// Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	//Saving status for clicked sheet
	var sheetClicks=new Array(0,0,0,0);
	//Retrieving or not
	var retrieveClick=0;
	// Office level by login user : HQ L1, RHQ L2, Office L3 (from MnrOfficeLevel function of CoMnr.js)
	var strMnrOfficeLevel="";
	// Defining event handler of button click */
	document.onclick=processButtonClick;
	/****************************************************************************************
	 ****************************************************************************************/
	/**
	 * Event handler to diverge process by button name
	 */
    function processButtonClick(){
         /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
         var sheetObject=sheetObjects[0];
		 var sheetObject1=sheetObjects[1];
		 var sheetObject2=sheetObjects[2];
		 var sheetObject3=sheetObjects[3];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
				switch(srcName) {
						case "btn_Retrieve":
			        			ComOpenWait(true);
								doActionIBSheet(sheetObject, formObject, IBSEARCH)
								break;
						case "btn_New":
								doActionIBSheet(sheetObject, formObject, IBCLEAR)
								setSaveBtnDisplay();
								break;
						case "btn_Save":
								doActionIBSheet(sheetObject, formObject, IBSAVE)
								break;
						case "btn_RowAdd1":
								doActionIBSheet(sheetObject, formObject, IBINSERT)
								break;
						case "btn_RowDel1":
								doActionIBSheet(sheetObject, formObject, IBDELETE)
								break;
						case "btn_Excel1":
								if(sheetObject.RowCount() < 1){//no data
									ComShowCodeMessage("COM132501");
								}else{
									sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1, DownRows:"Visible" });
								}
							break;
						case "btn_RowAdd2":
								doActionIBSheet1(sheetObject1, formObject, IBINSERT)
								break;
						case "btn_RowDel2":
								doActionIBSheet1(sheetObject1, formObject, IBDELETE)
								break;
						case "btn_Excel2":
								if(sheetObject1.RowCount() < 1){//no data
									ComShowCodeMessage("COM132501");
								}else{
									sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1, DownRows:"Visible" });
								}
			                    break;
						case "btn_RowAdd3":
								doActionIBSheet2(sheetObject2, formObject, IBINSERT)
								break;
						case "btn_RowDel3":
								doActionIBSheet2(sheetObject2, formObject, IBDELETE)
								break;
						case "btn_Excel3":
								if(sheetObject2.RowCount() < 1){//no data
									ComShowCodeMessage("COM132501");
								}else{
									sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:1,Merge:1, DownRows:"Visible" });
								}
								break;
						case "btn_RowAdd4":
								doActionIBSheet3(sheetObject3, formObject, IBINSERT)
	   							break;
						case "btn_RowDel4":
								doActionIBSheet3(sheetObject3, formObject, IBDELETE)
								break;
						case "btn_Excel4":
								if(sheetObject3.RowCount() < 1){//no data
									ComShowCodeMessage("COM132501");
								}else{
									sheetObject3.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject3), SheetDesign:1,Merge:1, DownRows:"Visible" });
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
     * Assigning array of IBSheet object
     * @param	{IBSheet}	sheet_obj	Setting button option
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
	/**
	 * Assigning array of IBCombo object
	 * @param	{IBMultiCombo}	combo_obj
	 * Array defined at the top of the source
	 */
	function setComboObject(combo_obj){
    	comboObjects[comboCnt++]=combo_obj;
	}
    /**
     * Sheet default setting and initializing
     * To implement for onload event of body tag
     * After loading in your browser should display the ability to add pre-processing
     */
    function loadPage() {
		// Retrieving and Setting for office level
		MnrOfficeLevel(currOfcCd, rhqOfcCd);
		MnrWaitControl(true);
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
			//Initializing status
			sheetClicks[i]=0;
        }
		//Initializing IBMultiCombo
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k + 1);
	    }
    	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    	setSaveBtnDisplay();
    }
	/**
	 * Combo Setting default
	 * @param	{IBMultiCombo}	combo_obj
	 * @param	{Number}	comboNo		Sequence number from combo object tag id
	 */
	function initCombo (comboObj, comboNo) {
		var formObject=document.form
	    switch(comboNo) {
	          case 1:
				  	with (comboObj) {
					//SetBackColor("#D4F4FA");
		    	}
	           break;
			  case 2:
			  	with (comboObj) {
					SetTitle("Code|Desc");
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetDropHeight(160);
					//SetBackColor("#D4F4FA");
		    	}
			   break;
	     }
	}
   /**
     * Initializing variable for IBSheet and defining header
     * @param	{IBSheet}	sheetObj
	 * @param	{Number}	sheetNo		Sequence number from sheet object tag id
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
				var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
	              var HeadTitle1="|Sel|Code|EQ Type|Description";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
			                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"eq_loc_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
			                     {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_knd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"eq_loc_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
			                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"eq_loc_cd_lvl",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"eq_loc_prnt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"eq_less_20ft_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	              
	              var sheetComboCode="";
	              var sheetComboText="";
	              var sheetComboDefault="";
	              var sCondition=new Array (  new Array("MnrGenCd","","CUSTOM9")   );		//Eq Kind
	           
	              var comboList=MnrComSearchCombo(sheetObj,sCondition);
	              for(var j = 0; j < comboList[0].length; j++){
		              var tempText = comboList[0][j].split("|");
		              sheetComboText +=  tempText[1] + "|";
		              sheetComboCode +=  tempText[0] + "|";
		              if(j == 0){
		            	  sheetComboDefault = tempText[0];
		              }
	         
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetColProperty(0,"eq_knd_cd", {ComboText:sheetComboText, ComboCode:sheetComboCode} );
		              SetCountPosition(0);
		              SetColProperty(0 ,"eq_loc_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
		                    //conversion of function[check again]CLT 					InitDataValid(0,  "eq_loc_cd", vtEngUpOther,"0123456789");
		              
	              }
	              sheetComboText=MnrDelLastDelim(sheetComboText);
	              sheetComboCode=MnrDelLastDelim(sheetComboCode);
	              MultiSelection=false;
	              SetSelectionMode(smSelectionRow);
	              SelectHighLight=true;
	              SelectFontBold=false;
//	              SetSheetHeight(510);
	              resizeSheet( sheetObj );
              }


			break;
            case "sheet2":
                with(sheetObj){
	              var HeadTitle1="|Sel|Code|Description";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_loc_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_loc_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_loc_cd_lvl",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_loc_prnt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_less_20ft_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	               
	              InitColumns(cols);
	
	              SetEditable(1);
	              SetCountPosition(0);
	              SetColProperty(0 ,"eq_loc_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
	                    //conversion of function[check again]CLT 					InitDataValid(0,  "eq_loc_cd", vtEngUpOther,"0123456789");
	              MultiSelection=false;
	              SetSelectionMode(smSelectionRow);
	              SelectHighLight=true;
	              SelectFontBold=false;
//	              SetSheetHeight(510);
	              resizeSheet( sheetObj );
              }


				break;
            case "sheet3":
                with(sheetObj){
	              var HeadTitle1="|Sel|Code|Less 20ft|Description";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_loc_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
	                     {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eq_less_20ft_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_loc_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_loc_cd_lvl",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_loc_prnt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	               
	              InitColumns(cols);
	
	              SetEditable(1);
	              SetCountPosition(0);
	              SetColProperty(0 ,"eq_loc_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
	              //conversion of function[check again]CLT 					InitDataValid(0,  "eq_loc_cd", vtEngUpOther,"0123456789");
	              MultiSelection=false;
	              SetSelectionMode(smSelectionRow);
	              SelectHighLight=true;
	              SelectFontBold=false;
//	              SetSheetHeight(510);
	              resizeSheet( sheetObj );
              }


				break;
				case "sheet4":
				    with(sheetObj){
			      var HeadTitle1="|Sel|Code|Less 20ft|Description";
			      var headCount=ComCountHeadTitle(HeadTitle1);

			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);

			      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_loc_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
			             {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eq_less_20ft_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"eq_loc_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"eq_loc_cd_lvl",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"eq_loc_prnt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			       
			      InitColumns(cols);

			      SetEditable(1);
			      SetCountPosition(0);
			      SetColProperty(0 ,"eq_loc_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
			            //conversion of function[check again]CLT 						InitDataValid(0,  "eq_loc_cd", vtEngUpOther,"0123456789");
			      SetSelectionMode(smSelectionRow);
//			      SetSheetHeight(510);
	              resizeSheet( sheetObj );
			      }


			        break;
        }
    }
	/**
	 * Sheet related process processing
	 * @param {IBSheet} sheetObj Used sheet object
	 * @param {Form}  formObj  Used form object
	 * @param {Number} sAction  Variable for diverge (Define from CoObject.js)
	 */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
		    case IBSEARCH:    //Retrieving
	          		if (sheetObj.id == 'sheet1') {
						for(i=0;i<sheetObjects.length;i++){
			            	sheetObjects[i].RemoveAll();
			         	}
	          			formObj.f_cmd.value=SEARCH;
	          			formObj.f_type.value='grid';
						//ComOpenWait(true);
						for(var i=1; i < sheetObjects.length; i++){
							sheetObjects[i].SetWaitImageVisible(0);
						}
						var sXml=sheetObj.GetSearchData("EES_MNR_0003GS.do", FormQueryString(formObj));
						var arrXml=sXml.split("|$$|");
						///sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
						for(var i=0; i < arrXml.length; i++){
							sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
							if ( i != 0 ) {
								MnrAllSheetHidden(sheetObjects[i]);
							}
						}
						for(var i=1; i <= sheetObj.RowCount(); i++){
							sheetObj.SetRowHidden(i,0);
						}
						retrieveClick=1;
					    sheetClicks=new Array(0,0,0,0);
	          		}
	            	ComOpenWait(false);
	          	break;
			case IBSAVE:  //Saving
					if (validateForm(sheetObj,formObj,sAction)) {
						formObj.f_cmd.value=MULTI;
						var sParam=ComGetSaveString(sheetObjects);
						if (sParam == "") return;
					    sParam += "&" + FormQueryString(formObj);
					    var sXml=sheetObjects[0].GetSaveData("EES_MNR_0003GS.do", sParam);
					    sheetObjects[0].LoadSaveData(sXml);
					    sheetObjects[1].LoadSaveData(sXml);
					    sheetObjects[2].LoadSaveData(sXml);
					    sheetObjects[3].LoadSaveData(sXml);
					}
	      		break;
			case IBINSERT:  // ROWADD
				if(validateForm(sheetObj,formObj,sAction)) {
		   	   		if (sheetObj.id == 'sheet1') {
			   	   		var Row=sheetObj.DataInsert(-1);
						sheetObj.SetCellValue(Row, "eq_loc_cd_lvl","1",0);
						sheetObj.SetCellValue(Row, "eq_loc_prnt_cd","",0);
						sheetObj.SetCellValue(Row, "eq_less_20ft_flg","N",0);
					}
				}
	      		break;
            case IBDELETE:  //Deleting
	   	   		if (sheetObj.id == 'sheet1') {
		   	   		if(sheetObj.FindCheckedRow("del_chk") != ""){
						ComRowHideDelete(sheetObj,"del_chk");
						for(var i=1; i < sheetObjects.length; i++){
							MnrAllSheetHidden(sheetObjects[i]);
						}
					} else {
						ComShowCodeMessage("MNR00150");
					}
				}
	      		break;
          	case IBCLEAR: //  Initializing all sheet and combo data
          		MnrWaitControl(true);
                sheetObj.SetWaitImageVisible(0);
	      	   	if (sheetObj.id == 'sheet1') {
					sheetClicks=new Array(0,0,0,0);
					retrieveClick=0;
				    //Initializing combo data
					for(var i=0; i < comboObjects.length;i++){
				 		 comboObjects[i].RemoveAll();
					}
					//Setting eq_knd_cd and EQ_TYPE
					var sCondition=new Array (
							new Array("MnrGenCd","","CUSTOM9") //EQ Kind
						   ,new Array("MnrEqLocCd",    "1","COMMON")   //1st Location Code
						);
					var comboList=MnrComSearchCombo(sheetObj,sCondition);
					for(var i=0; i<comboList.length; i++) {
						if(i==0)
						{
							eq_knd_cd.InsertItem(0,"ALL","ALL");
							for(var j=0; j < comboList[i].length;j++){
								var tempText=comboList[i][j].split("|");
								eq_knd_cd.InsertItem(j + 1, tempText[1] ,tempText[0]);
							}
							eq_knd_cd.SetSelectCode("ALL");
						}else if (i==1)
						{
							key_value.InsertItem(0, 'ALL|ALL retrieve' ,'ALL');
							if(comboList[i] != null){
								for(var j=0; j < comboList[i].length;j++){
									var tempText=comboList[i][j].split("|");
									key_value.InsertItem(j + 1, tempText[0] + '|' + tempText[1] ,tempText[0]);
								}
							}
							key_value.SetSelectCode("ALL");
						}
					}
					 //Initializing all sheet
					 for(i=0;i<sheetObjects.length;i++){
			            sheetObjects[i].RemoveAll();
						sheetClicks[i]=0;
			         }
	      	   	}
				retrieveClick=0;
		        sheetObj.SetWaitImageVisible(1);
                MnrWaitControl(false);
	      	   	break;
        }
    }
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
	/**
	 * Sheet2 related process processing
	 * @param {IBSheet} sheetObj Used sheet object
	 * @param {Form}  formObj  Used form object
	 * @param {Number} sAction  Variable for diverge (Define from CoObject.js)
	 */
    function doActionIBSheet1(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBINSERT:  // ROWADD
	   	   		if (sheetObj.id == 'sheet2') {
	   	   			if(sheetClicks[0] == 0 || (sheetObjects[0].GetCellValue(sheetClicks[0],"eq_loc_cd") == '')){
						ComShowCodeMessage("MNR00143","LOCATION CODE");
					} else {
						var Row=sheetObj.DataInsert(-1);
						sheetObj.SetCellValue(Row, "eq_loc_cd_lvl","2",0);
						sheetObj.SetCellValue(Row, "eq_loc_prnt_cd",sheetObjects[0].GetCellValue(sheetClicks[0], "eq_loc_cd"),0);
						sheetObj.SetCellValue(Row, "eq_knd_cd",sheetObjects[0].GetCellValue(sheetClicks[0], "eq_knd_cd"),0);
						sheetObj.SetCellValue(Row, "eq_less_20ft_flg","N",0);
						sheetObj.SetCellValue(Row, "eq_loc_cd",sheetObj.GetCellValue(Row, "eq_loc_prnt_cd"),0);
						sheetObj.SelectCell(Row, "eq_loc_cd",true);
					}
		   	   	}
	      		break;
            case IBDELETE:  //Deleting
	   	   		if (sheetObj.id == 'sheet2') {
		   	   		if(sheetObj.FindCheckedRow("del_chk") != ""){
						ComRowHideDelete(sheetObj,"del_chk");
						for(var i=2; i < sheetObjects.length; i++){
							MnrAllSheetHidden(sheetObjects[i]);
						}
					} else {
						ComShowCodeMessage("MNR00150");
					}
		   	   	}
	      		break;
        }
    }
	/**
	 * Sheet3 related process processing
	 * @param {IBSheet} sheetObj Used sheet object
	 * @param {Form}  formObj  Used form object
	 * @param {Number} sAction  Variable for diverge (Define from CoObject.js)
	 */
    function doActionIBSheet2(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBINSERT:  // ROWADD
	   	   		if (sheetObj.id == 'sheet3') {
	   	   			if(sheetClicks[1] == 0 || (sheetObjects[1].GetCellValue(sheetClicks[1], "eq_loc_cd") == '')){
						ComShowCodeMessage("MNR00143","LOCATION CODE");
					} else {
						var Row=sheetObj.DataInsert(-1);
						sheetObj.SetCellValue(Row, "eq_loc_cd_lvl","3",0);
						sheetObj.SetCellValue(Row, "eq_loc_prnt_cd",sheetObjects[1].GetCellValue(sheetClicks[1], "eq_loc_cd"),0);
						sheetObj.SetCellValue(Row, "eq_knd_cd",sheetObjects[0].GetCellValue(sheetClicks[0], "eq_knd_cd"),0);
						sheetObj.SetCellValue(Row, "eq_less_20ft_flg","N",0);
						sheetObj.SetCellValue(Row, "eq_loc_cd",sheetObj.GetCellValue(Row, "eq_loc_prnt_cd"),0);
						sheetObj.SelectCell(Row, "eq_loc_cd",true);
					}
		   	   	}
	      		break;
            case IBDELETE:  //Deleting
	   	   		if (sheetObj.id == 'sheet3') {
	   	   			if(sheetObj.FindCheckedRow("del_chk") != ""){
						ComRowHideDelete(sheetObj,"del_chk");
						for(var i=3; i < sheetObjects.length; i++){
							MnrAllSheetHidden(sheetObjects[i]);
						}
					} else {
						ComShowCodeMessage("MNR00150");
					}
		   	   	}
	      		break;
        }
    }
	/**
	 * Sheet4 related process processing
	 * @param {IBSheet} sheetObj Used sheet object
	 * @param {Form}  formObj  Used form object
	 * @param {Number} sAction  Variable for diverge (Define from CoObject.js)
	 */
    function doActionIBSheet3(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBINSERT:  // ROWADD
	   	   		if (sheetObj.id == 'sheet4') {
	   	   			if(sheetClicks[2] == 0 || (sheetObjects[2].GetCellValue(sheetClicks[2], "eq_loc_cd") == '')){
						ComShowCodeMessage("MNR00143","LOCATION CODE");
					} else {
						var Row=sheetObj.DataInsert(-1);
						sheetObj.SetCellValue(Row, "eq_loc_cd_lvl","4",0);
						sheetObj.SetCellValue(Row, "eq_loc_prnt_cd",sheetObjects[2].GetCellValue(sheetClicks[2], "eq_loc_cd"),0);
						sheetObj.SetCellValue(Row, "eq_knd_cd",sheetObjects[0].GetCellValue(sheetClicks[0], "eq_knd_cd"),0);
						sheetObj.SetCellValue(Row, "eq_less_20ft_flg","N",0);
						sheetObj.SetCellValue(Row, "eq_loc_cd",sheetObj.GetCellValue(Row, "eq_loc_prnt_cd"),0);
						sheetObj.SelectCell(Row, "eq_loc_cd",true);
					}
		   	   	}
	      		break;
            case IBDELETE:  //Deleting
	   	   		if (sheetObj.id == 'sheet4') {
					if(sheetObj.FindCheckedRow("del_chk") != ""){
						ComRowHideDelete(sheetObj,"del_chk");
					} else {
						ComShowCodeMessage("MNR00150");
					}
		   	   	}
	      		break;
        }
    }
	/**
     * Validating process for input form data
     * @param	{IBSheet}	sheetObj	Used sheet object
     * @param	{Form}		formObj		Used form object
     * @param	{Number}	sAction		Variable for diverge (Define from CoObject.js)
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if(sAction==IBSAVE) {
				//Duplicate checking when saving data
				for (var i=0; i<sheetObjects.length; i++){
					if(sheetObjects[i].IsDataModified()){
						var Row=sheetObjects[i].ColValueDup("eq_loc_cd");
						if(Row > 0){
							ComShowCodeMessage("MNR00006",i + 1 + "th sheet of " + Row + " row ");
							sheetObjects[i].SetCellValue(Row,"eq_loc_cd","",0);
							sheetObjects[i].SelectCell(Row, "eq_loc_cd", true);
							return false;
						}
					}
				}
			} else if(sAction==IBINSERT){
				//Checking retrieved status when inserting data
				if(retrieveClick==0){
					ComShowCodeMessage("MNR00147");
					return false;
				}
			}
        }
        return true;
    }
	/* ********* User Functions ************* */
	/**
	 * Filtering sheet when an event occurs
	 * @param	{Number}	sheetIdx		index of target sheet
	 * @param 	{String}  	keyValue  		Condition for filtering
	 * @param 	{Form}  	foreginKey  	Filtered column
	 */
	function MnrSheetFiltering(sheetIdx,keyValue,foreginKey){
		for (var idx=1; idx <= sheetObjects[sheetIdx].RowCount(); idx++){
			if(sheetObjects[sheetIdx].GetCellValue(idx,foreginKey) == keyValue && sheetObjects[sheetIdx].GetCellValue(idx,'ibflag') != 'D'){
				sheetObjects[sheetIdx].SetRowHidden(idx,0);
			} else {
				sheetObjects[sheetIdx].SetRowHidden(idx,1);
			}
		}
	}
	/**
	 * Hiding all sheet
	 * @param 	{IBSheet} 	sheetObj	Used sheet object
	 */
	function MnrAllSheetHidden(sheetObj){
		for (var idx=1; idx <= sheetObj.RowCount(); idx++){
			sheetObj.SetRowHidden(idx,1);
		}
	}
	//Showing message after saving
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			ComShowCodeMessage("MNR00023",'');
		} else {
			ComShowCodeMessage("MNR00008",ErrMsg);
		}
	}
	//Checking edited code
	function sheet2_OnAfterEdit(sheetObj,Row,Col){
		if((sheetObj.ColSaveName(Col) == 'eq_loc_cd') && sheetObj.GetCellEditable(Row, Col)){
			var checkLocCd=sheetObj.GetCellValue(Row,Col);
			if(checkLocCd.substring(0,checkLocCd.length - 1).toUpperCase() != sheetObj.GetCellValue(Row,"eq_loc_prnt_cd").toUpperCase()){
				ComShowCodeMessage("MNR00148");
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row, "eq_loc_cd", true);
			}
		}
	}
	//Checking edited code
	function sheet3_OnAfterEdit(sheetObj,Row,Col){
		if((sheetObj.ColSaveName(Col) == 'eq_loc_cd') && sheetObj.GetCellEditable(Row, Col)){
			var checkLocCd=sheetObj.GetCellValue(Row,Col);
			if(checkLocCd.substring(0,checkLocCd.length - 1).toUpperCase() != sheetObj.GetCellValue(Row,"eq_loc_prnt_cd").toUpperCase()){
				ComShowCodeMessage("MNR00148");
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row, "eq_loc_cd", true);
			}
		}
	}
	//Checking edited code
	function sheet4_OnAfterEdit(sheetObj,Row,Col){
		if((sheetObj.ColSaveName(Col) == 'eq_loc_cd') && sheetObj.GetCellEditable(Row, Col)){
			var checkLocCd=sheetObj.GetCellValue(Row,Col);
			if(checkLocCd.substring(0,checkLocCd.length - 1).toUpperCase() != sheetObj.GetCellValue(Row,"eq_loc_prnt_cd").toUpperCase()){
				ComShowCodeMessage("MNR00148");
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row, "eq_loc_cd", true);
			}
		}
	}
	/**
	 * sheet3 click event
	 * @param	{IBSheet}		sheetObj
	 * @param 	{Number} 		Row
	 * @param 	{Number} 		Col
	 * @param 	{String} 		Value
	 */
	function sheet3_OnClick(sheetObj,Row,Col,Value){
		sheetClicks[2]=Row;
		var keyValue=sheetObj.GetCellValue(Row,"eq_loc_cd");
		for(var i=3; i < sheetObjects.length; i++){
			MnrAllSheetHidden(sheetObjects[i]);
			sheetClicks[i]=0;
		}
		MnrSheetFiltering(3,keyValue,"eq_loc_prnt_cd");
	}
	/**
	 * sheet2 click event
	 * @param	{IBSheet}		sheetObj
	 * @param 	{Number} 		Row
	 * @param 	{Number} 		Col
	 * @param 	{String} 		Value
	 */
	function sheet2_OnClick(sheetObj,Row,Col,Value){
		sheetClicks[1]=Row;
		var keyValue=sheetObj.GetCellValue(Row,"eq_loc_cd");
		for(var i=2; i < sheetObjects.length; i++){
			MnrAllSheetHidden(sheetObjects[i]);
			sheetClicks[i]=0;
		}
		MnrSheetFiltering(2,keyValue,"eq_loc_prnt_cd");
	}
	/**
	 * sheet1 click event
	 * @param	{IBSheet}		sheetObj
	 * @param 	{Number} 		Row
	 * @param 	{Number} 		Col
	 * @param 	{String} 		Value
	 */
	function sheet1_OnClick(sheetObj,Row,Col,Value){
		sheetClicks[0]=Row;
		var keyValue=sheetObj.GetCellValue(Row,"eq_loc_cd");
		for(var i=1; i < sheetObjects.length; i++){
			MnrAllSheetHidden(sheetObjects[i]);
			sheetClicks[i]=0;
		}
		MnrSheetFiltering(1,keyValue,"eq_loc_prnt_cd");
	}
	/**
	 * Setting displayed of save button
	 * @return
	 */
	function setSaveBtnDisplay() {
		if(strMnrOfficeLevel=="L1") {
			ComBtnEnable("btn_Save");
		} else {
			ComBtnDisable("btn_Save");
		}
	}
	/* End of developer's task */
