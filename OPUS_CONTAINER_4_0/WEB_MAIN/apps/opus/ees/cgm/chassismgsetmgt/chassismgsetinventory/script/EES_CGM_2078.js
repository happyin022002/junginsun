/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2078.js
*@FileTitle  :Inventory by Lessor & Lease Term
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11

=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   	/* developer job	*/
 // common global variables
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1;
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var comboCnt=0;
 var oldCntrTypeSize = "";
 var sCntrTypeSize = "";
 
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
/**
 * Event handler processing by button name <br>
 * @param
 * @return 
 * @author 
 * @version 2009.09.11
 */ 
 function processButtonClick(){
      /***** use additional sheet var in case of more than 2 tap each sheet *****/
      var sheetObject=sheetObjects[0];
      /*******************************************************/
      var formObject=document.form;
 	try {
 		var srcName=ComGetEvent("name");
 		if(ComGetBtnDisable(srcName)) return false;
         switch(srcName) {
             case "btn_Retrieve":
        		if(validateForm(sheetObject,formObject,IBSEARCH) != false) {
        			doActionIBSheet(sheetObject, formObject, IBSEARCH);
        		}
        		if(combo_location.GetSelectCode()!= "ALL"){
        			formObject.crnt_loc_cd.focus(); //
         		}
				break;
             case "btn_new":
            	initControl();
				break;
            case "btn_downexcel":           	
            	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                break;
            case "btns_crnt_loc_cd":	// Location Popup
            	if(combo_location.GetSelectText()== "ALL")
            		return;
                var tmp=combo_location.GetSelectText();
            	if(tmp == "RCC"){
            		//ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 450,"rcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
            		ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
            		//ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 450, "callBackLocation", "0,1,1,1,1,1,1", true, false);
            	} else if(tmp == "LCC") {
            		//ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 450,"lcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
            		ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
            		//ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 450, "callBackLocation", "0,1,1,1,1,1,1", true, false);	            		
            	} else if(tmp == "SCC") {
            		//ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 450,"scc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
            		ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
            		//ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 450, "callBackLocation", "0,1,1,1,1,1,1", true, false);	            		
            	}
            	break;
            case "btns_crnt_yd_cd":		// Yard
            	//ComOpenPopupWithTarget('/opuscntr/COM_ENS_061.do', 1000, 450, "3:crnt_yd_cd", "1,0,1,1,1,1,1", true);
            	ComOpenPopup('/opuscntr/COM_ENS_061.do', 800, 540, "callBackYard", "0,1,1,1,1,1,1", true, false);
            	break;
            case "btns_vndr":
            	ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 555, "callBackVendor", "0,1,1,1,1,1", true, false);
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
 * registering IBSheet Object as list <br>
 * @param  {object} sheet_obj	
 * @return 
 * @author 
 * @version 
  */
 function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
 }
/**
* initializing sheet <br>
* implementing onLoad event handler in body tag <br>
* @param  
* @return 
* @author 
* @version 
 */
function loadPage() {
	var formObj=document.form;
	
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC07);

	for(i=0;i<sheetObjects.length;i++){
		//
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		//
		ComEndConfigSheet(sheetObjects[i]);
	}
	//sheetObj.SetWaitImageVisible(0);
	// axon event regist
//	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
//	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
	axon_event.addListener('change', 'obj_change' , 'crnt_loc_cd');  
	axon_event.addListener('change', 'obj_change' , 'crnt_yd_cd');  
	axon_event.addListener('focusout', 'obj_focusout', 'crnt_yd_cd');
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('keyup', 'obj_keyup', form);
  	 //Multi Combo reset
     comboObjects[comboCnt++]=combo_location;
	 comboObjects[comboCnt++]=agmt_lstm_cd;
	 for(var k=0;k<comboObjects.length;k++){
		 initCombo(comboObjects[k]);
     } 
	 /*
     // Location MultiCombo value setting
	 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
     // Lease Term MultiCombo value setting
     doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC05);
  	 document.combo_location.InsertItem(0, "ALL", "ALL");
	 */
	 doActionIBSheet(sheetObjects[0], document.form, IBRESET);
     initControl();
     //sheetObj.SetWaitImageVisible(1);
}
 /**
 * sheet setting and init in case of load finish <br>
 * @param  
 * @return 
 * @author 
 * @version 
 */     
  /**
   * init control of form <br>
   * @param  
   * @return 
   * @author 
   * @version
   */
 function initControl(){
  	 var formObj=document.form;
  	 var sheetObj=sheetObjects[0];
  	 // Form Object reset
  	 with(formObj){
  		 crnt_loc_cd.value="";
  		 crnt_yd_cd.value="";
  		 vndr_seq.value="";
  	 }
  	 // MultiCombo reset
  	 for(var i=0; i<comboObjects.length; i++){
  		 comboObjects[i].SetSelectText("",false);
  	 }
  	 // Sheet Object reset
  	 sheetObj.RemoveAll();
	 // init value setting
     comboObjects[0].SetSelectIndex(0);//
     formObj.crnt_loc_cd.disabled=true;
     formObj.crnt_loc_cd.className = "input2";
 }
 /**
  * setting sheet initial values and header <br>
  * adding case as numbers of counting sheets <br>
  * @param  {object} sheetObj		 Sheet Object
  * @param  {int} sheetNo
  * @return 
  * @author 
  * @version
  */
 function initSheet(sheetObj,sheetNo) {
     var cnt=0;
	 var sheetID=sheetObj.id;
     switch(sheetID) {
         case "sheet1":
             with (sheetObj) {

		             var HeadTitle="Lessor|Term|Total";
		             //making data as list for changing column
						oldCntrTypeSize = sCntrTypeSize;
						var arrCntrTypeSize = "";
						if(oldCntrTypeSize != ""){
							arrCntrTypeSize = oldCntrTypeSize.split("|");
						}
						
						//handling header title by changing column
						if (sCntrTypeSize != "") {
							HeadTitle += "|" + oldCntrTypeSize;
						}
		             
		             var headCount=ComCountHeadTitle(HeadTitle);
		             //(headCount, 0, 0, true);
		
		             SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:0 } );
		
		             var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"Text",      Hidden:0,  Width:240,  Align:"Center",  ColMerge:1,   SaveName:"vndr_lgl_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"agmt_lstm_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"AutoSum",   Hidden:0, Width:200,  Align:"Right",   ColMerge:0,   SaveName:"eq_tpsz_cd_total",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
		             
					  var sCount = "";
					  var x = 1;
                      var sumCount = 2;
	                  var sumNmVal = "";
					  
	 	              for ( var i = 0; i <= arrCntrTypeSize.length; i++) {
					 	  if (arrCntrTypeSize.length > 1) {
					 		  sCount = "eq_tpsz_cd" + x;
					 		  if(i != arrCntrTypeSize.length){
					 			 cols.push({Type:"AutoSum",   Hidden:0, Width:200,  Align:"Right",   ColMerge:0,   SaveName:sCount,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
					 		  	x++;
					 		  }

					 		  if(i == arrCntrTypeSize.length - 1){
								 sumNmVal += "|"+sumCount;
							  }else if(i == 0){
								 sumNmVal += sumCount;
							  }else{
								 sumNmVal += "|"+sumCount;
									
							  }
							  
					 		  sumCount++;

					 	  }
					  }		             
		              
		             InitColumns(cols);
		
		             SetEditable(1);
		             
		             SetEditableColorDiff(0);
		             
		             ShowSubSum([{StdCol:0, SumCols:sumNmVal, Sort:1, ShowCumulate:0, CaptionCol:0, CaptionText:"SubTotal"}]);
		             
//		             SetSheetHeight(520);	
		             resizeSheet();
                }
                 break;
         }
     }
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[sheetObjects.length-1]);
	}
/**
 * handling process for Sheet <br>
 * @param  {object} sheetObj		 Sheet Object
 * @param  {object} formObj	 Form Object
 * @param  {String} sAction	 Action Type
 * @return 
 * @author 
 * @version 
 */
 function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg(false);
     switch(sAction) {
        case IBSEARCH:      //retrieve
	        // Form Object value setting
	    	formObj.f_cmd.value=SEARCH;
	 		formObj.eq_knd_cd.value=EQ_KND_CD_MGSET;
	 		// retrieve
	 		if(validateForm(sheetObj,formObj,sAction))
	 		{
		 		sheetObj.SetWaitImageVisible(0);
		 		ComOpenWait(true);	 		 			
		 		var sXml=sheetObj.GetSearchData("EES_CGM_2078GS.do" , FormQueryString(formObj));
	 			sheetObj.LoadSearchData(sXml,{Sync:0} );
		 		ComOpenWait(false);	 		 			
	 		}
             break;
      case IBSEARCH_ASYNC01:	// Location Combo retrieve
	   		formObj.f_cmd.value=SEARCH;
	   		formObj.intg_cd_id.value=COM_CD_TYPE_CD02117;		// code type setting (Location)
	   		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
	   		var sStr=ComGetEtcData(sXml,"comboList");    			
	   		var arrStr=sStr.split("@");
	   		// combo control, result string, Text Index, Code Index
	   		makeComboObject(combo_location, arrStr, 1, 1, 0);
	   		break;
    	case IBSEARCH_ASYNC05:	// Term Code Combo retrieve
	       	formObj.f_cmd.value=SEARCH;
	       	formObj.intg_cd_id.value=COM_CD_TYPE_CD01948;		// code type setting ( AGREEMENT LEASE TERM CODE )
	       	var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
	   		var sStr=ComGetEtcData(sXml,"comboList");    			
	   		var arrStr=sStr.split("@");
	  		makeComboObject(agmt_lstm_cd, arrStr, 0, 0, 0);
	  		comboObjects[0].DeleteItem(0);
	       	break;

    	case IBSEARCH_ASYNC07:	// Sheet Head retrieve
        	formObj.f_cmd.value = SEARCH21;
    		formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
			var sXml = sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj),{Sync:1});
			sCntrTypeSize = ComGetEtcData(sXml,"cntrTypeSize");
			
			//getting changing column information from server
			oldCntrTypeSize = sCntrTypeSize;
			
			break;
	       	
        case IBSEARCH_ASYNC08:
	       	//formObj.f_cmd.value = SEARCH;
	       	//formObj.loc_cd.value = formObj.crnt_loc_cd.value;		//   ( combo_location)
	   		//var sXml = sheetObj.GetSearchXml("cgm_Check_LocationGS.do", FormQueryString(formObj));
	    	formObj.f_cmd.value=SEARCH17;
	    	var location=combo_location.GetSelectText();

	    	if(location == "RCC")
	    	{
	    		formObj.eq_orz_cht_chktype.value="RCC";
	    		formObj.eq_orz_cht_rcc_cd.value=formObj.crnt_loc_cd.value;
	    	}else if(location == "LCC")
	    	{
	    		formObj.eq_orz_cht_chktype.value="LCC";
	    		formObj.eq_orz_cht_lcc_cd.value=formObj.crnt_loc_cd.value;
	    	}else if(location == "SCC")
	    	{
	    		formObj.eq_orz_cht_chktype.value="SCC";
	    		formObj.eq_orz_cht_scc_cd.value=formObj.crnt_loc_cd.value;
	    	}else
	    	{
	    		formObj.eq_orz_cht_chktype.value="";
	    		formObj.eq_orz_cht_scc_cd.value="";
	    	}
	    	var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
	   		// data count
	        var dataCount=ComGetTotalRows(sXml);
	        if(dataCount==0){
	        	ComShowCodeMessage('CGM10009','location cd');
		   		formObj.crnt_loc_cd.value="";
	        }
	        formObj.crnt_loc_cd.focus(); //	        
	   		break;
    	case IBDOWNEXCEL:        //down excel
    		if(sheetObj.RowCount() < 1){//no data
    			ComShowCodeMessage("COM132501");
    			}else{
    				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
    			}
            break;
    	case IBRESET:
    		var idx=0
    		var sXml2=document.form2.sXml.value;
    		var arrXml=sXml2.split("|$$|");
    		//Location
    		if ( arrXml[idx] == null ) {return;}
    		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
    	    var arrStr1=new Array();
    		for ( var i=0; i < vArrayListData.length; i++) {
    		    vListData=vArrayListData[i];
    		    arrStr1[i]=vListData["code1"] + "|" + vListData["desc1"];
    		}
    		// combo control, result string, Text Index, Code Index
	  		makeComboObject(combo_location, arrStr1, 1, 1, 0);      
	  		combo_location.InsertItem(0, "ALL", "ALL");
	  		comboObjects[0].SetSelectIndex(0);//
    		idx++;        		
    		//Lease Term
    		if ( arrXml[idx] == null ) {return;}
    		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
    	    var arrStr3=new Array();
    		for ( var i=0; i < vArrayListData.length; i++) {
    		    vListData=vArrayListData[i];
    		    arrStr3[i]=vListData["code1"] + "|" + vListData["desc1"];
    		}
	  		makeComboObject(agmt_lstm_cd, arrStr3, 0, 0, 0);
//	  		comboObjects[7].DeleteItem(0); 
	  		idx++;
    		break;            
     }
 }
/**
 * handling process for input validation <br>
 * @param  {object} sheetObj		 Sheet Object
 * @param  {object} formObj	 Form Object
 * @param  {String} sAction	 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
 * @return {boolean}			false => validation check error, true => validation check succes
 * @author 
 * @version 
 */ 
function validateForm(sheetObj,formObj,sAction){
	switch(sAction){
		case IBSEARCH:
			if(combo_location.GetSelectText()!= "ALL")
			{
				if(formObj.crnt_loc_cd.value == ''){
					ComShowCodeMessage('CGM10004','Location');
					formObj.crnt_loc_cd.focus();
					return false;
				} else {
						if(formObj.crnt_loc_cd.value.length != 5) 
					{
						ComShowCodeMessage('CGM10044','Location(5)');
						formObj.crnt_loc_cd.focus();
						return false;
					}
				}
			}
			break;
	}
	return true;
}
/**
 * call back function. <br>
 * @param  {Array} aryPopupData	mandatory	 Array Object
 * @param  {Int} row				mandatoryselectedRow
 * @param  {Int} col				mandatoryselectedColumn
 * @param  {Int} sheetIdx			mandatory Sheet Index
 * @return 
 * @author 
 * @version
 */   
function callBackLocation(aryPopupData, row, col, sheetIdx){
    var formObj=document.form;
    var location=combo_location.GetSelectText();
    var crntLocCd="";
    var i=0;
    for(i=0; i < aryPopupData.length; i++){
    	if(location == 'RCC'){
    		crntLocCd=crntLocCd + aryPopupData[i][11];
    	} else if(location == 'LCC'){
    		crntLocCd=crntLocCd + aryPopupData[i][10];
    	} else if(location == 'SCC'){
    		crntLocCd=crntLocCd + aryPopupData[i][8];
    	}
    	if(i < aryPopupData.length - 1){
    		crntLocCd=crntLocCd + ",";
     	}
    }
    formObj.crnt_loc_cd.value=crntLocCd;
}
/**
 * call back function. <br>
 * @param  {Array} aryPopupData	mandatory	 Array Object
 * @param  {Int} row				mandatoryselectedRow
 * @param  {Int} col				mandatoryselectedColumn
 * @param  {Int} sheetIdx			mandatory Sheet Index
 * @return 
 * @author 
 * @version 
 */   
function callBackYard(aryPopupData, row, col, sheetIdx){
    var formObj=document.form;
    var crntYdCd="";
    var i=0;
    for(i=0; i < aryPopupData.length; i++){
    	crntYdCd=crntYdCd + aryPopupData[i][3];
    	if(i < aryPopupData.length - 1){
    		crntYdCd=crntYdCd + ",";
     	}
    }
    formObj.crnt_yd_cd.value=crntYdCd;
}
 function callBackVendor(aryPopupData, row, col, sheetIdx){
    	var formObj=document.form;
     var vndrSeq="";
     var i=0;
     for(i=0; i < aryPopupData.length; i++){
     	vndrSeq=vndrSeq + aryPopupData[i][2];
     	if(i < aryPopupData.length - 1){
     		vndrSeq=vndrSeq + ",";
     	}
     }
     formObj.vndr_seq.value=vndrSeq;
 }
/**
 * Sheet1  OnSearchEnd event handling <br>
 * @param  {object} sheetObj		 Sheet Object
 * @param  {string} ErrMsg		 String
 * @return 
 * @version 
 */ 
function sheet1_OnSearchEnd(sheetObj, ErrMsg)
{
	sheetObj.SetSumText(0, "TOTAL");
}
 /**
  * Sheet1 OnMouseDown event handling <br>
  * @param  {Integer} Button	mandatory Integer
  * @param  {integer} Shift	mandatory Integer
  * @param  {Integer} X	mandatory Integer
  * @param  {integer} Y	mandatory Integer
  * @return 
  * @author 
  * @version
  */ 
  function sheet1_OnMouseDown (Button, Shift, X, Y){
 	 var sheetObj=sheetObjects[0];
 	 var formObj=document.form;
 	 if(sheetObj.RowCount() + 1 == sheetObj.MouseRow())
 	 {
 		 //alert("ROWCNT:"+ sheetObj.RowCount()+"=>"+ sheetObj.MouseRow() +":"+sheetObj.MouseCol)	 
 		 //var groupValue1 = sheetObj.cellValue(sheetObj.MouseRow(), "vndr_lgl_eng_nm");
 		 //alert(groupValue1);
 		 sheet1_OnDblClick(sheetObj, sheetObj.MouseRow(), sheetObj.MouseCol(), 0, 0, 0, 0);
 	 }
  }
function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
	var eqKndCd=EQ_KND_CD_MGSET;
  	var location=comboObjects[0].GetSelectCode();
  	var crntLocCd=document.form.crnt_loc_cd.value;
  	var crntYdCd=document.form.crnt_yd_cd.value;
	var vndrSeq=document.form.vndr_seq.value;
	var agmtLstmCd=agmt_lstm_cd.GetSelectText();
	var s2_agmtLstmCd=""; 
	var group1="";
	var groupValue1=sheetObj.GetCellValue(Row, "vndr_lgl_eng_nm");
//	alert(groupValue1); return;
	if(groupValue1 != "SubTotal")
	{
		// groupValue1 = groupValue1.substring(0,6); // Lessor
		var dispText=groupValue1;
		if(dispText.length >=8)
		{
			groupValue1=dispText.substr(dispText.lastIndexOf('(')+1,6);
		}else
		{
			groupValue1=dispText;
		}
	}
	var s2_group1="";
	var s2_groupValue1="";
  	var s3_gtotal="";
	if(groupValue1 == "SubTotal")
	{
		s2_group1="SubSum";
		//s2_groupValue1 = groupValue1.substring(9);
		//s2_groupValue1 = sheetObj.CellValue(Row-1, "vndr_lgl_eng_nm");
		// s2_groupValue1 = sheetObj.CellValue(Row-1, "vndr_lgl_eng_nm").substring(0,6);
		var dispText=sheetObj.GetCellValue(Row-1, "vndr_lgl_eng_nm");
		if(dispText.length >=8)
		{
			s2_groupValue1=dispText.substr(dispText.lastIndexOf('(')+1,6);
		}else
		{
			s2_groupValue1=dispText;
		}
		s2_agmtLstmCd=sheetObj.GetCellValue(Row-1,"agmt_lstm_cd");
		//groupValue1 = groupValue1.substring(9); 
		groupValue1=s2_groupValue1;
	}else if(groupValue1 == "TOTAL"){
  		s3_gtotal="GTOTAL";
  	}else
	{
		s2_group1="";
		s2_groupValue1="";
		s2_agmtLstmCd=sheetObj.GetCellValue(Row,"agmt_lstm_cd");
	}
	if(groupValue1.lastIndexOf('(') != -1) {
		groupValue1=groupValue1.substring(groupValue1.lastIndexOf('(')+1, groupValue1.length-1);
	}
	//if(comboObjects[2].Code == "") 
	
	var colSaveName=sheetObj.ColSaveName(Col);
	var k = 1;
	oldCntrTypeSize = sCntrTypeSize;
	var arrCntrTypeSize = oldCntrTypeSize.split("|");

	for ( var i = 0; i < arrCntrTypeSize.length; i++) {
		if (arrCntrTypeSize.length > 1) {
			var gubun = "eq_tpsz_cd" + k;
			if(colSaveName == gubun){
				s2EqTpszCd = arrCntrTypeSize[i];
				break;
			}
			k++;
		}
	}

	if(parseInt(Col) == 2)s2EqTpszCd="TOTAL";

	var param="?program_id=2078";
	param=param + "&eq_knd_cd=" + eqKndCd;
  	param=param + "&s_location=" + location;
  	param=param + "&s_crnt_loc_cd=" + crntLocCd;
  	param=param + "&s_crnt_yd_cd=" + crntYdCd;
	param=param + "&s_vndr_seq=" + vndrSeq;
	param=param + "&s_agmt_lstm_cd=" + agmtLstmCd;
	param=param + "&s_group1=" + group1; 
	param=param + "&s_group1_val=" + groupValue1;
	param=param + "&s2_group1=" + s2_group1;
	param=param + "&s2_group1_val=" + s2_groupValue1;
  	param=param + "&s2_agmt_lstm_cd=" + s2_agmtLstmCd;
	param=param + "&s2_eq_tpsz_cd=" + s2EqTpszCd;
	param=param + "&s3_gtotal=" + s3_gtotal;
	//alert(param);
  	//var seq = sheetObj.cellValue(Row, "Seq");
  	if(Col >= 2)// && seq != '')
  	{
//		prompt('/opuscntr/EES_CGM_2084.do' , param);
  		ComOpenPopup('/opuscntr/EES_CGM_2084.do' + param, 900, 460, "", "1,0", true, false);
    }else
    {
    	ComShowCodeMessage('CGM10016');
    }
}    
/**
 * Location Multi-Combo OnChange event handling <br>
 * @param  {object} ComboObj	mandatory	 Sheet Object
 * @param  {int} 	Index_Code	mandatory
 * @param  {string} Text		mandatory
 * @return 
 * @version
 */ 
//Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)

function combo_location_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	document.form.crnt_loc_cd.value="";
	 var formObj=document.form;
	 var location=combo_location.GetSelectText();
	 if(newText == "ALL")
	 {
		 formObj.crnt_loc_cd.disabled=true;
		 formObj.crnt_loc_cd.className = "input2";
	    	
		 
	 }else
	 {
		 formObj.crnt_loc_cd.disabled=false;
		 formObj.crnt_loc_cd.className = "input1";
	 }
	 
     formObj.location.value = location;

//	 document.form.combo_location_text.value = newCode;
}
//function combo_location_OnBlur(comboObj) {
//	document.form.combo_location_text.value = combo_location.GetSelectCode();
//}
 /** 
  * Object activate event handling  <br>
  * @param  
  * @return 
  * @author 
  * @version 
  */
 function obj_activate(){
   	ComClearSeparator(event.srcElement);
 } 
/** 
  * Object deactivate event handling  <br>
  * @param  
  * @return 
  * @author 
  * @version 
  */
 function obj_deactivate(){
	//ComChkObjValid(event.srcElement);
 }
 
/** 
  * Object change event handling  <br>
  * @param  
  * @return 
  * @author 
  * @version 
  */  
 function obj_change(){
 	 var formObj=document.form;
 	 var sheetObj=sheetObjects[0]; 
 	 obj=event.srcElement;
 	 switch(ComGetEvent("name")){
	 	case "vndr_seq":
 	   		var vndrSeq=ComTrimAll(formObj.vndr_seq.value);
 	   		var arrVndrSeq=vndrSeq.split(",");
 	   		for(var i=0; i < arrVndrSeq.length; i++){
 	   		// 
 	 			if(arrVndrSeq[i] == ''){
 	 				ComShowCodeMessage('CGM10009','Lessor');
 	 				formObj.vndr_seq.value="";
     	 				ComSetFocus(formObj.vndr_seq);
     	 				break;
     	 			}
     	   		}	 
      	   	     	 break;
     	 }   
     }
/** 
 * Object obj_focusout event handling  <br>
 * @param  
 * @return 
 * @author 
 * @version 
 */  
function obj_focusout(){
	 var formObj=document.form;
	 var sheetObj=sheetObjects[0];
	 obj=event.srcElement;
	 switch(ComGetEvent("name")){
	 	case "crnt_loc_cd":
	 		break;
	 }
}
/** 
  * Combo Object reset  <br>
  * @param  {object} comboObj	Combo Object
  * @return 
  * @author 
  * @version 
  */ 
 function initCombo(comboObj) {
	 switch(comboObj.options.id) {
    	case "combo_location":
  	        with(comboObj) {
    			SetDropHeight(100);
  	            SetEnable(1);
  	            comboObj.SetUseAutoComplete(1);
  	        }
  	        break;
    	case "agmt_lstm_cd":
  	        with(comboObj) {
    			SetDropHeight(180);
  	            SetMultiSelect(1);
	            SetMaxLength(20);//
	            SetUseAutoComplete(1);
                SetMultiSeparator(",");
                Style=0;
  	        }
  	        break;
 	}
 }       
function makeComboObject(cmbObj, arrStr, txtCol, codeCol, opt) {
	cmbObj.RemoveAll();
 	if(opt == 0) {
 		for (var i=0; i < arrStr.length;i++ ) {
 			var arrCode=arrStr[i].split("|");
     		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
         }
 	} else if(opt == 1){
 		cmbObj.InsertItem(0,"","");
 		for (var i=0; i < arrStr.length;i++ ) {
 			var arrCode=arrStr[i].split("|");
     		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
         }
 	}
 	cmbObj.SetSelectIndex("" ,false);
} 
 function makeCPMultiCombo(cmbObj, arrStr, txtCol, codeCol) {
    	cmbObj.RemoveAll();
    	if(arrStr == undefined ){
    		cmbObj.InsertItem(0, "Include Pool Chassis", "I" );
			cmbObj.InsertItem(1, "Exclude Pool Chassis", "E" );
			cmbObj.InsertItem(2, "Only Pool Chassis", "O" );
    	} else {
        	var arrCode=arrStr[0].split("|");
      	var arrCode2=arrStr[1].split("|");
          	for (var i=0; i < arrCode.length;i++ ) {
          		var arrCode3=arrCode[i].split("|");
          		var arrCode4=arrCode2[i].split("|");
          		if(i==0)
          		{
          			cmbObj.InsertItem(0, "Include Pool Chassis", "I" );
          			cmbObj.InsertItem(1, "Exclude Pool Chassis", "E" );
          			cmbObj.InsertItem(2, "Only Pool Chassis", "O" );
          			cmbObj.InsertItem(i+3, arrCode4[txtCol], arrCode3[codeCol]);
          		}
          		else
          		{
          			cmbObj.InsertItem(i+3, arrCode4[txtCol], arrCode3[codeCol]);
          		}
          	}
    	}
    	cmbObj.SetSelectIndex("" ,false);
    } 
//   function enterFire() {
//	   var formObj=document.form;
//	   var sheetObj=sheetObjects[0];
//	   if(event.keyCode == 13)
//	   {
//		   if(validateForm(sheetObj,formObj,IBSEARCH))
//		   {
//			   ComKeyEnter('search');
//		   }
//	   }
//   }   
/**
 * 유효값체크 로직(자리수에 맞춰서)
 * @author 조재성 2009.09.30
 */
function obj_keyup(){
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0];
    	 obj = ComGetEvent();
    	 switch(ComGetEvent("name")){
	 	 	case "crnt_loc_cd":
		 		var crntLocCd = ComTrimAll(formObj.crnt_loc_cd.value);
		   		var arrCrntLocCd = crntLocCd.split(",");
		   		
		   		for(var i = 0; i < arrCrntLocCd.length; i++){
		   		// 입력오류 체크 (예> ,,)
		 			if(arrCrntLocCd[i] == ''){
		 				ComShowCodeMessage('CGM10009','Location');
		 				formObj.crnt_loc_cd.value = "";
		 				ComSetFocus(formObj.crnt_loc_cd);
		 				break;
		 			}else
		 			{
		    	 		//if(formObj.crnt_loc_cd.value != ''){
		    	 		if(formObj.crnt_loc_cd.value.length == 5){
		    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC08);
		    	 		}
		 			}
		   		}
		 		break; 
	 	   	case "crnt_yd_cd":
		   		var crntYdCd = ComTrimAll(formObj.crnt_yd_cd.value);
		   		if( formObj.crnt_yd_cd.value.search(',') > 0 || (formObj.crnt_yd_cd.value == '')) // 다중 yard code(,로 연결됨)이면 검사하지 않는다. 
		   		{
		   			break;
		   		}
		   		var arrCrntYdCd = crntYdCd.split(",");
		   		for(var i = 0; i < arrCrntYdCd.length; i++){
		   			// 입력오류 체크 (예> ,,)
		 			if(arrCrntYdCd[i] == ''){
		 				ComShowCodeMessage('CGM10009','Yard');
		 				formObj.crnt_yd_cd.value = "";
		 				ComSetFocus(formObj.crnt_yd_cd);
		 				break;
		 			}
		   		}
		   		
		 		//if(arrCrntYdCd.length == 1 && formObj.crnt_yd_cd.value != ''){
		 		if(arrCrntYdCd.length == 1 && formObj.crnt_yd_cd.value.length == 7){
		 			//chungpa 20091015 MULTI일경우 YD check안함			 		 			
		 			//doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
	 	 		} 
	 	 		break;
    	 }
}
 
 /* developer job end */