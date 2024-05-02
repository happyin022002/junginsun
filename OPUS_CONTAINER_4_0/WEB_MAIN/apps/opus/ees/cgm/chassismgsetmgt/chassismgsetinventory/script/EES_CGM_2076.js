/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2076.js
*@FileTitle  : General Inventory 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class EES_CGM_2076 : EES_CGM_2076 business script for
     */
   	/* developer job	*/
 // common global variables
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1;
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var comboCnt=0;
 var IBSEARCH02=30;
 
 var oldCntrTypeSize = "";
 var sCntrTypeSize = "";
 
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
/**
 * Event handler processing by button name <br>
 * @param
 * @return 
 * @author 
 * @version 
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
             case "btn_retrieve":
        		if(validateForm(sheetObject,formObject,IBSEARCH) != false) {
        			doActionIBSheet(sheetObject, formObject, IBSEARCH);
        		}
        		formObject.crnt_loc_cd.focus(); //         		
				break;
             case "btn_new":
            	initControl();
				break;
            case "btn_downexcel":
            	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                break;
            case "btn_print":
				if(sheetObjects[0].RowCount() == 0) {
					errMsg='No data found.';
					ComShowMessage(msgs["CGM10012"]);
					return;
				}
				formObject.f_cmd.value=IBSEARCH02;
				formObject.head_eq_tpsz_cd.value = sCntrTypeSize;
				ComOpenPopupWithTarget('/opuscntr/EES_CGM_2205.do', 775, 680, "", "0,1,1,1,1,1,1", true);
                break;
            case "btns_crnt_loc_cd":	// Location Popup
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
            	ComOpenPopup('/opuscntr/COM_ENS_061.do', 800, 475, "callBackYard", "0,1,1,1,1,1,1", true, false);
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
     sheet1_OnLoadFinish(sheet1);
 }
 function sheet1_OnLoadFinish(sheetObj) {
	   	// axon event regist
	 sheetObj.SetWaitImageVisible(0);
//     axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
//     axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
     axon_event.addListener('change', 'obj_change' , 'crnt_loc_cd');  
   	axon_event.addListener('change', 'obj_change' , 'crnt_yd_cd');  
   	axon_event.addListener('focusout', 'obj_focusout', 'crnt_yd_cd');
//   	axon_event.addListener('keyup', 'enterFire', 'crnt_loc_cd');
//   	axon_event.addListener('keyup', 'enterFire', 'crnt_yd_cd');
  	// Multi Combo reset
  	comboObjects[comboCnt++]=combo_location;
  	comboObjects[comboCnt++]=aciac_div_cd;
  	comboObjects[comboCnt++]=group1;
  	comboObjects[comboCnt++]=eq_tpsz_cd;
  	comboObjects[comboCnt++]=atch_bare;
  	comboObjects[comboCnt++]=dmg_snd;
   	for(var k=0;k<comboObjects.length;k++){
         initCombo(comboObjects[k]);
     } 
   	// Active St. MultiCombo value reset
   	var arrActive=new Array();
   	arrActive[0]="A|Active";
   	arrActive[1]="I|In-active";
   	makeComboObject(aciac_div_cd, arrActive, 1, 0, 0);
   	//Group MultiCombo value reset
   	var arrGroup=new Array();
   	arrGroup[0]="1|LCC[Location]";
   	arrGroup[1]="2|SCC[Location]";
   	arrGroup[2]="3|Yard";
   	arrGroup[3]="4|Lessor";
   	arrGroup[4]="5|Agreement";
   	makeComboObject(group1, arrGroup, 1, 0, 1);
   	// Attach/Bare value reset
   	var arrActive=new Array();
   	arrActive[0]="ATTACHED|Attached";
   	arrActive[1]="BARE|Bare";
   	makeComboObject(atch_bare, arrActive, 1, 0, 1);
   	// Damage/Sound value reset
   	var arrActive=new Array();
   	arrActive[0]="DAMAGE|Damage";
   	arrActive[1]="SOUND|Sound";
   	makeComboObject(dmg_snd, arrActive, 1, 0, 1);
   	/*
   	// Location MultiCombo value setting
  	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
 	// Type Size MultiCombo value setting
 	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);
 	*/
 	doActionIBSheet(sheetObjects[0], document.form, IBRESET);
 	initControl();    
     sheetObj.SetWaitImageVisible(1);
 }

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
  	 }
  	 // MultiCombo reset
  	 for(var i=0; i<comboObjects.length; i++){
  		 comboObjects[i].SetSelectText("",false);
  	 }
  	 // Sheet Object reset
  	 sheetObj.RemoveAll();
//  	 sheetObj.SetColHidden("group1",1);
	 // init value setting
	 combo_location.SetSelectIndex(0);
	 group1.SetSelectIndex(1);
	 aciac_div_cd.SetSelectIndex(0);
	 formObj.crnt_loc_cd.focus(); //	 
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

	             var HeadTitle="|Lease Term|TOTAL";
	             
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
	
	             SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
	
	             var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	             var headers = [ { Text:HeadTitle, Align:"Center"} ];
	             InitHeaders(headers, info);
	
	             var cols = [ 
	                    {Type:"Text",      Hidden:0, Width:220,  Align:"Center",  ColMerge:1,   SaveName:"group1",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                    {Type:"Text",      Hidden:0, Width:220,  Align:"Center",  ColMerge:0,   SaveName:"agmt_lstm_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                    {Type:"AutoSum",   Hidden:0, Width:180,  Align:"Right",   ColMerge:0,   SaveName:"eq_tpsz_cd_total",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
	             
				  var sCount = "";
				  var x = 1;
                  var sumCount = 2;
                  var sumNmVal = "";
				  
	 	              for ( var i = 0; i <= arrCntrTypeSize.length; i++) {
				 	  if (arrCntrTypeSize.length > 1) {
				 		  sCount = "eq_tpsz_cd" + x;
				 		  if(i != arrCntrTypeSize.length){
			 			  	cols.push({Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:0,   SaveName:sCount,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				 		  
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
		         
//		         SetSheetHeight(520);
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
	 		//attached / bare
	    	if(formObj.rdo_atch_bare[0].checked)
	    	{
	    		atch_bare.value=formObj.rdo_atch_bare[0].value;
	    	}else
	    	{
	    		atch_bare.value=formObj.rdo_atch_bare[1].value;
	    	}
	    	//damage / sound
	    	if(formObj.rdo_dmg_snd[0].checked)
	    	{
	    		dmg_snd.value=formObj.rdo_dmg_snd[0].value;
	    	}else
	    	{
	    		dmg_snd.value=formObj.rdo_dmg_snd[1].value;
	    	}
	    	
	    	if(!ComIsEmpty(combo_location.GetSelectText())) {
	    		formObj.location.value = combo_location.GetSelectText();
	    	}
	    	
	 		if(validateForm(sheetObj,formObj,sAction))
	 		{
		 		sheetObj.WaitImageVisible = false;
		 		ComOpenWait(true);	 				 			
 	 			var sXml=sheetObj.GetSearchData("EES_CGM_2076GS.do" , FormQueryString(formObj));
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
	   /* 
       case IBSEARCH_ASYNC02:	// Yard  Validation check 
		   	formObj.f_cmd.value=COMMAND01;
		   	formObj.yd_cd.value=formObj.crnt_yd_cd.value;
 		   	var sXml=sheetObj.GetSearchData("Check_YardGS.do", FormQueryString(formObj));
		   	var sCheckResult=ComGetEtcData(sXml,"checkResult");    	
		   	if(sCheckResult == COM_VALIDATION_FALSE){
		   		ComShowCodeMessage('CGM10009','Yard');
		   		formObj.crnt_yd_cd.value="";
		   		formObj.crnt_yd_cd.focus();
		   	}
		   	break;  
		*/
	   	case IBSEARCH_ASYNC04:	// Type Size Combo retrieve
			formObj.f_cmd.value=SEARCH04;
			formObj.eq_knd_cd.value=EQ_KND_CD_MGSET;
 			var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
			var sStr=ComGetEtcData(sXml,"comboList");
			var arrStr=sStr.split("@");
			makeComboObject(eq_tpsz_cd, arrStr, 0, 0, 0);
			//comboObjects[6].DeleteItem(1);
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
	    	var location=formObj.combo_location_text.value;
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
    	    var j = 0;
    		for ( var i=0; i < vArrayListData.length; i++) {
    		    vListData=vArrayListData[i];
//    		    arrStr1[i]=vListData["code1"] + "|" + vListData["desc1"];
    		    if (vListData != undefined && vListData != null) {
    		    	arrStr1[j++] = vListData['code1'] + "|" + vListData["desc1"];
    		    }
    		}
    		// combo control, result string, Text Index, Code Index
	  		makeComboObject(combo_location, arrStr1, 1, 1, 0);       
    		idx++;        		
    		//Type/Size
    		if ( arrXml[idx] == null ) {return;}
    		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
    	    var arrStr2=new Array();
    	    var q=0;
    		for ( var i=0; i < vArrayListData.length; i++) {
    		    vListData=vArrayListData[i];
//    		    arrStr3[i]=vListData["code1"] + "|" + vListData["desc1"];
    		    if (vListData != undefined && vListData != null) {
    		    	arrStr2[q++] = vListData['code1'] + "|" + vListData["desc1"];
    		    }
    		}
    		makeComboObject(eq_tpsz_cd, arrStr2, 0, 0, 0);
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
	with(formObj){
		switch(sAction){
			case IBSEARCH:
				if(crnt_loc_cd.value == ''){
					ComShowCodeMessage('CGM10004','Location');
					crnt_loc_cd.focus();
					return false;
				} else {
					if(crnt_loc_cd.value.length != 5) 
					{
						ComShowCodeMessage('CGM10044','Location(5)');
						crnt_loc_cd.focus();
						return false;
					}
    			}
				break;
		}
		return true;
	}
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
function callBackLocation(aryPopupData){
    var formObj=document.form;
    var location= combo_location.GetSelectCode();
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
 function sheet1_OnChangeSum(sheetObj, Row)
 {
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
	with(sheetObj)
	{
        with(sheetObj)
        {
        	SetSumText(0, "group1","Total");
        }
	}
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
	 if(sheetObj.rowcount + 1 == sheetObj.mouseRow)
	 {
		 //alert("ROWCNT:"+ sheetObj.rowcount+"=>"+ sheetObj.MouseRow +":"+sheetObj.MouseCol)	 
		 //var groupValue1 = sheetObj.GetCellValue(sheetObj.MouseRow, "group1");
		 //alert(groupValue1);
		 sheet1_OnDblClick(sheetObj, sheetObj.MouseRow(), sheetObj.MouseCol(), 0, 0, 0, 0);
	 }
 }
  function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
  	var eqKndCd=EQ_KND_CD_MGSET;
  	var location=comboObjects[0].GetSelectCode();
  	var crntLocCd=document.form.crnt_loc_cd.value;
  	var crntYdCd=document.form.crnt_yd_cd.value;
  	var aciacDivCd=comboObjects[1].GetSelectCode();
  	var eqTpszCd=comboObjects[3].GetSelectText();
  	var sGrpByCd=comboObjects[2].GetSelectCode();
  	var groupValue1=sheetObj.GetCellValue(Row, "group1");
  	if(group1.GetSelectIndex()== 4 && groupValue1 != "SubTotal") {
  		var dispText=groupValue1;
  		if(dispText.length >=8)
  		{
  			// groupValue1 = dispText.substring(0,6);
  			groupValue1=dispText.substr(dispText.lastIndexOf('(')+1,6);
  		}
  		else
  		{
  			groupValue1=dispText;
  		}
  	}
  	if(group1.GetSelectIndex()== 5 && groupValue1 != "SubTotal")
  	{
  		var dispText=groupValue1;
  		if(dispText.length >=10)
  		{
  			groupValue1=dispText.substring(0,9);
  		}
  		else
  		{
  			groupValue1=dispText;
  		}
  	}
  	var s2_group1="";
  	var s2_groupValue1="";
  	var s3_gtotal="";
  	
  	if(groupValue1.substring(0,9) == "SubTotal")
  	{
  		//s2_group1 = "SubSum";
  		//s2_groupValue1 = groupValue1.substring(9);
		s2_group1="SubSum";
		
		
  		if(group1.GetSelectIndex()== 4)
  		{
  			var dispText=sheetObj.GetCellValue(Row-1, "group1");
  			
  			if(dispText.length >= 8)
  			{
  				//기존 s2_groupValue1 = dispText.substring(0,6);
  				s2_groupValue1=dispText.substr(dispText.lastIndexOf('(')+1,6);
  			}
  			else
  			{
  				s2_groupValue1=dispText;
  			}
  		}
  		else if(group1.GetSelectIndex()== 5){
  			var dispText=sheetObj.GetCellValue(Row-1, "group1");
  			alert(dispText);
  			if(dispText.length >= 8)
  			{
  				s2_groupValue1=dispText.substr(0,dispText.indexOf('(')-1);
  			}
  			else
  			{
  				s2_groupValue1=dispText;
  			}  			
  		}
  		else 
  		{
  			s2_groupValue1=sheetObj.GetCellValue(Row-1, "group1");
  		}
  		groupValue1=s2_groupValue1;
  	}else if(groupValue1 == "Total"){
  		s3_gtotal="GTOTAL";
  	}else{
  		s2_group1="";
  		s2_groupValue1="";
  	}
  	var agmtLstmCd=sheetObj.GetCellValue(Row, "agmt_lstm_cd");
  	var s2EqTpszCd="";

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

  	if(parseInt(Col) == 2) s2EqTpszCd="TOT";

	//attached / bare
	var sAtchBare=atch_bare.GetSelectCode();
	/* 
	if(document.form.rdo_atch_bare[0].checked)
	{
		atch_bare=document.form.rdo_atch_bare[0].value;
	}else
	{
		atch_bare=document.form.rdo_atch_bare[1].value;
	}
	*/
	//damage / sound
	var sDmgSnd=dmg_snd.GetSelectCode();
	/*
	if(document.form.rdo_dmg_snd[0].checked)
	{
		dmg_snd=document.form.rdo_dmg_snd[0].value;
	}else
	{
		dmg_snd=document.form.rdo_dmg_snd[1].value;
	}
	*/
  	var param="?program_id=2076";
  	param=param + "&eq_knd_cd=" + eqKndCd;
  	param=param + "&s_location=" + location;
  	param=param + "&s_crnt_loc_cd=" + crntLocCd;
  	param=param + "&s_crnt_yd_cd=" + crntYdCd;
  	param=param + "&s_aciac_div_cd=" + aciacDivCd;
  	param=param + "&s_eq_tpsz_cd=" + eqTpszCd;
  	param=param + "&s_group1=" + sGrpByCd; 
  	param=param + "&s_group1_val=" + groupValue1;
  	param=param + "&s2_group1=" + s2_group1;
  	param=param + "&s2_group1_val=" + s2_groupValue1;
  	param=param + "&s2_agmt_lstm_cd=" + agmtLstmCd;
  	param=param + "&s2_eq_tpsz_cd=" + s2EqTpszCd;
  	param=param + "&s3_gtotal=" + s3_gtotal;
  	param=param + "&atch_bare=" + sAtchBare;
  	param=param + "&dmg_snd=" + sDmgSnd;
  	//alert(param);
  	//var seq = sheetObj.GetCellValue(Row, "Seq");
  	if(Col >= 2)// && seq != '')
  	{
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
}
/**
 * Group1 Multi-Combo OnChange event handling <br>
 * @param  {object} ComboObj	mandatory	 Sheet Object
 * @param  {int} 	Index_Code	mandatory
 * @param  {string} Text		mandatory
 * @return 
 * @version
 */ 
function group1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	//Group MultiCombo value reset
  	var arrGroup=new Array();
	var sheetObj=sheetObjects[0];
  	// Sheet Object title value setting
  	sheetObj.RemoveAll();
  	sheetObj.SetCellValue(0,"group1",comboObj.GetSelectText());
//  	sheetObj.SetCellValue(1,"group1",comboObj.GetSelectText());
  	if(sheetObj.GetCellValue(0,"group1") == ""){
  		sheetObj.SetColHidden("group1",1);
  	} else {
  		sheetObj.SetColHidden("group1",0);
  	}
}
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
  * aciac_div_cd change event handling  <br>
  * @param  
  * @return 
  * @author 
  * @version
  */
  function aciac_div_cd_change(){
	  var formObj=document.form;
	  if(aciac_div_cd.GetSelectText()!= "Active")
	  {
          // Active
	  }
	  else
	  {
          // InActive
	  }
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
 	 obj=ComGetEvent();
 	 switch(ComGetEvent("name")){
	 	case "crnt_loc_cd":
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
	 obj=ComGetEvent();
	 switch(ComGetEvent("name")){
	 	case "crnt_yd_cd":
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
 	 		var cnt=0;
  	        with(comboObj) {
  	        	Code="";
  	            Text="";
  	            SetDropHeight(100);
  	            SetMultiSelect(0);
  	            SetMaxSelect(1);
  //no support[check again]CLT 	            UseCode=true;
  	            SetEnable(1);
  	            comboObj.SetUseAutoComplete(1);
  	        }
  	        break;
    	case "aciac_div_cd":
 	 		var cnt=0;
  	        with(comboObj) {
  	        	Code="";
  	            Text="";
  	            SetDropHeight(100);
  	            SetMultiSelect(0);
  	            SetMaxSelect(1);
  //no support[check again]CLT 	            UseCode=true;
  	            SetEnable(1);
  	            comboObj.SetUseAutoComplete(1);
  	        }
  	        break;
    	case "group1":
 	 		var cnt=0;
  	        with(comboObj) {
  	        	Code="";
  	            Text="";
  	            SetDropHeight(170);
  	            SetMultiSelect(0);
  	            SetMaxSelect(1);
  //no support[check again]CLT 	            UseCode=true;
  	            SetEnable(1);
  	            comboObj.SetUseAutoComplete(1);
  	        }
  	        break;    
    	case "eq_tpsz_cd":
 	 		var cnt=0;
  	        with(comboObj) {
  	        	Code="";
  	            Text="";
  	            SetDropHeight(150);
  	            SetMultiSelect(1);
  	            SetMaxSelect(100);
  //no support[check again]CLT 	            UseCode=true;
  	            SetEnable(1);
//no support[check again]CLT 	        	ValidChar(2,3);        
//no support[check again]CLT 	            IMEMode=0;           
	            SetMaxLength(20);
  	        }
  	        break;
    	case "atch_bare":
 	 		var cnt=0;
  	        with(comboObj) {
  	        	Code="";
  	            Text="";
  	            SetDropHeight(170);
  	            SetMultiSelect(0);
  	            SetMaxSelect(1);
  //no support[check again]CLT 	            UseCode=true;
  	            SetEnable(1);
  	        }
  	        break;    
    	case "dmg_snd":
 	 		var cnt=0;
  	        with(comboObj) {
  	        	Code="";
  	            Text="";
  	            SetDropHeight(170);
  	            SetMultiSelect(0);
  	            SetMaxSelect(1);
  //no support[check again]CLT 	            UseCode=true;
  	            SetEnable(1);
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
   function enterFire() {
	   var formObj=document.form;
	   var sheetObj=sheetObjects[0];
	   if(event.keyCode == 13)
	   {
		   if(validateForm(sheetObj,formObj,IBSEARCH))
		   {
			   ComKeyEnter('search');
		   }
	   }
   }   
