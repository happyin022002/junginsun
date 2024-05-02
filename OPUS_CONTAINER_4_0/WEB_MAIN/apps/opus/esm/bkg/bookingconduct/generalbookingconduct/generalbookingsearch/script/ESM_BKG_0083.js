/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0083.js
*@FileTitle  : Node Search
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					          MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					          Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

 // public variable

 var sheetObjects = new Array();
 var sheetCnt = 0;

 var tabObjects = new Array();
 var tabCnt = 0 ;
 var beforetab = 1;
 
 var comboObjects = new Array();
 var comboCnt = 0; 

 // Event handler processing by button click event */
 document.onclick = processButtonClick;

 // Event handler processing by button name */
 function processButtonClick(){
      /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
     var shtCnt=0;
     var sheet1=sheetObjects[0];
     var sheet2=sheetObjects[1];
     var sheet3=sheetObjects[2];
      /*******************************************************/ 
      var formObject=document.form;
      try {
 		var srcName=ComGetEvent("name");
         switch(srcName) {
             case "btn_t1Retrieve":
		         if(validateForm(formObject, SEARCH01)){
		        	 doActionIBSheet(formObject,SEARCH01); 
		         }else{
		        	 ComShowCodeMessage("BKG00625");
		         }	            	 
     	        break;
             case "btn_t1Close":
            	 ComClosePopup(); 
     	        break;
     	    case "btn_t1OK":
     	    	comPopupSend(formObject, 1);
     	        break;
     	    case "Code_Detail":
     	    	if(sheet1.RowCount()> 0){
	     	    	var row=sheet1.GetSelectRow();
	     	    	ComOpenWindowCenter("locationCodeInquiry.do?f_cmd=101&loc_cd="+sheet1.GetCellValue(row, "loc_cd") , "myWin", 580, 630, false);
     	    	}
     	        break;
			case "btn_t2Retrieve":
		         if(validateForm(formObject, SEARCH)){
		        	 doActionIBSheet(formObject,SEARCH); 
		         }else{
		        	 ComShowCodeMessage("BKG00625");
		         }
		         break; 
			case "btn_t2Select":
				comPopupSend(formObject, 2);
				break; 
			case "btn_t2Close":
				ComClosePopup(); 
				break; 
			case "btn_008301pop":
				ComOpenPopup('COM_ENS_0M1.do?pgmNo=COM_ENS_0M1', 600, 470, "setCallBack008301", '0,1,1,1,1,1,1', true);
				break; 				
			case "btn_008302pop":
				openComNodePop();
				break; 					
         } // end switch
 	}catch(e) {
 		if( e == "[object Error]") {
 			ComShowCodeMessage("COM12111");
 		} else {
 			ComShowMessage(e.message);
 		}
 	}
 }
 /**
  * registering IBTab Object as list
  * adding process for list in case of needing batch processing with other items
  * defining list on the top of source
  */
 function setTabObject(tab_obj){
     tabObjects[tabCnt++]=tab_obj;
 }     
	/**
	 * initializing Tab
	 * setting Tab items
	*/
	function initTab(tabObj , tabNo) {
		switch(tabNo) {
			case 1:
             with (tabObj) {
                var cnt=0 ;
                InsertItem( "Location" , "");
                InsertItem( "Node" , "");
                SetSelectedIndex(0);
             }
             break;   
      }
 }
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {    	 
    for(i=0;i<sheetObjects.length;i++){
 		//ComConfigSheet (sheetObjects[i] );
 		initSheet(sheetObjects[i],i+1);
 		ComEndConfigSheet(sheetObjects[i]);
    }         
    for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
    }         
 	for(var j=0; j<comboObjects.length; j++){
        initCombo(comboObjects[j]);
    }
	rcc_cd.SetDropHeight(250);
	select.SetDropHeight(250);
	doActionIBSheet(document.form,INIT);
	initControl();
}
/**
 * registering IBCombo Object as list
 * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
 **/
function setComboObject(combo_obj){
    comboObjects[comboCnt++]=combo_obj;
}
/**
 * setting combo initial values and header 
 * @param {IBMultiCombo} comboObj  comboObj
 */
function initCombo(comboObj) {
	comboObj.SetMultiSelect(0);
	comboObj.SetColAlign(0, "left");
	comboObj.SetColAlign(1, "left");
	comboObj.SetMultiSeparator("|");
}
 /**
  * load HTML Control event on the page <br>
  * {@link #loadPage}call the function and init IBSheet Object <br>
  * 
  * @param {ibsheet}
  *            sheetObj IBSheet Object
  * @param {int}
  *            sheetNo sheetObjects 
  */
 function initControl() {
 	var formObject=document.form;
     //axon_event.addListenerFormat('keypress', 'obj_KeyPress',    formObject); //- 키보드 입력할때
 	 axon_event.addListenerForm  ("keydown", 			"bkg0083_keydown", 		formObject);

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
    * setting sheet initial values and header
    * 
    * adding case as numbers of counting sheets
    */
   function initSheet(sheetObj,sheetNo) {
	   var cnt=0;
	   var sheetID=sheetObj.id;
	   switch(sheetID) {
	   		case "t1sheet1":      //sheet1 init
                with(sheetObj){
					var HeadTitle="Sel|Seq|Location|Location Name|Region|State|US Mode|SCC|ECC|LCC|RCC|S.OFC|EQ OFC|Country|UN|UNLoc|Hub Loc";
					
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:0 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"loc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"loc_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rgn_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"loc_state",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"scc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ecc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"lcc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rcc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"sls_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"eq_ctrl_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"un_loc_ind_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"un_loc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"hub_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
					
					InitColumns(cols);
					
	                SetSheetHeight(220);
	                SetWaitImageVisible(0);
	   			}
	   			break;         
	   		case "t2sheet1":      //sheet1 init
                with(sheetObj){
					var HeadTitle1="|Sel|Loc. Code|Loc. Name|Yard CD|Yard Name|EQ CTRL OFC|CY|CFS|Rail\nRamp|Pseudo\nYard|Marine\nTerminal|Address";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					             {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
					             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:1,   SaveName:"loc_nm",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"yd_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"yd_nm",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eq_ctrl_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"yd_fcty_tp_cy_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"yd_fcty_tp_cfs_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"yd_fcty_tp_rail_rmp_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"yd_fcty_tp_psdo_yd_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"yd_fcty_tp_mrn_tml_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"yd_addr",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
					
					InitColumns(cols);
					
					SetDataLinkMouse(true);
					SetSheetHeight(220);
	                SetWaitImageVisible(0);
				}

	   			break;
	   		case "t2sheet2":      //sheet2 init
                with(sheetObj){
					var HeadTitle1="||Loc. Code|Loc. Name|Zone CD|Zone Name|Postal CD|District|EQ CTRL OFC ";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					             {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
					             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"loc_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"zn_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:240,  Align:"Left",    ColMerge:1,   SaveName:"zn_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"pst_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"dstr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eq_ctrl_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
					
					InitColumns(cols);
					
					SetDataLinkMouse(true);
					SetSheetHeight(222);
	                SetWaitImageVisible(0);
				}


	   			break;

	   }
   }
   // handling sheet process
     function doActionIBSheet(formObj,sAction) {
         switch(sAction) {
         	case INIT:      //Default
	    		formObj.f_cmd.value=INIT;
	    		ComOpenWait(true);
	    		var sXml=sheetObjects[3].GetSearchData("ESM_BKG_0083GS.do", FormQueryString(formObj));
	    		var arrXml=sXml.split("|$$|");
	    		if (0 < arrXml.length) {
	    			ComBkgXml2ComboItem(arrXml[0], rcc_cd, "val", "name");
	    			rcc_cd.SetSelectIndex(0);
	    		}
	    		if (1 < arrXml.length) {
	    			ComBkgXml2ComboItem(arrXml[1], select, "val", "name");
	    			select.SetSelectIndex(0);
	    		}
	    		if (2 < arrXml.length) {
	    			ComBkgXml2ComboItem(arrXml[2], postal_cd, "val", "name");
	    			postal_cd.SetSelectIndex(0);
	    		}
	    		ComOpenWait(false);
	    		break;
         	case SEARCH:      //Retrieve
	    		ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				if(formObj.yz_flag[0].checked){		            	
					sheetObjects[1].DoSearch("ESM_BKG_0083GS.do", FormQueryString(formObj) );
				}else{
					sheetObjects[2].DoSearch("ESM_BKG_0083GS.do", FormQueryString(formObj) );
				}
			break;
			case SEARCH01:      //Retrieve
	    		ComOpenWait(true);
				formObj.f_cmd.value=SEARCH01;				
				sheetObjects[0].DoSearch("ESM_BKG_0083GS.do", FormQueryString(formObj) );
			break;			
         }
     }
     
     function t1sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	 if(sheetObj.LastRow() >= 1){
    		 sheetObj.SetCellValue(1,"chk",1);
    	 }
 		ComOpenWait(false);
     }

     function t2sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	 if(sheetObj.LastRow() >= 1){
    		 sheetObj.SetCellValue(1,"chk",1);
    	 }
 		ComOpenWait(false);
     }
     function t2sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	 if(sheetObj.LastRow() >= 1){
    		 sheetObj.SetCellValue(1,"chk",1);
    	 }
 		ComOpenWait(false);
     }

     /**
      * handling process for input validation
      */
     function validateForm(formObj,sAction){
    	  switch(sAction) {
    	  	case SEARCH:      //Retrieve
    	  		if(ComIsNull(formObj.country_cd) && ComIsNull(formObj.loc_cd)){
    	  			ComSetFocus(formObj.country_cd);
    	  			return false;
    	  		}else{
    	  			if(!ComIsNull(formObj.country_cd)){
	  					if(ComChkLen(formObj.country_cd,2) < 2){    	        		 
	  						ComSetFocus(formObj.country_cd);    
	  						return false;
	  					}    	  				
    	  			}
    	  		}
    	  		return true;
    	  		break;
			case SEARCH01:      //Retrieve
				if(ComIsNull(formObj.cnt_cd) && ComIsNull(formObj.location_cd) && formObj.loc_nm.value.length < 3){
		  			ComSetFocus(formObj.cnt_cd);
		  			return false;					
				}
				return true;
				break;			
    	  }    	  
     }
     
     function  bkg0083_keydown(){
		 var keyValue=ComGetEvent("keycode");
		 var formObject=document.form;
		 if(keyValue == 13){
			 if(beforetab == 0){	// Location Tab
		         if(validateForm(formObject, SEARCH01)){
		        	 doActionIBSheet(formObject,SEARCH01); 
		         }else{
		        	 ComShowCodeMessage("BKG00104");
		         }	         			 
			 }else{	// Node Tab
		         if(validateForm(formObject, SEARCH)){
		        	 doActionIBSheet(formObject,SEARCH); 
		         }else{
		        	 ComShowCodeMessage("BKG00104");
		         }    			 
			 }
		 }
	 }
 /**
  * sheet1 Event after onclick
  * @param {ibsheet}  
  * @param {long} row 
  * @param {long} col
  * @param {string} value 
 */
 function sheet1_OnClick(sheet , row, col, value) {  
	sheetObjects[0].SetCellValue(row,"chk",1);
 }     
  /**
   * sheet2 Event after onclick
   * @param {ibsheet}  
   * @param {long} row 
   * @param {long} col
   * @param {string} value 
  */
 function sheet2_OnClick(sheet , row, col, value) {  
	sheetObjects[1].SetCellValue(row,"chk",1);
 }          
 /**
 * sheet3 Event after onclick
 * @param {ibsheet}  
 * @param {long} row 
 * @param {long} col
 * @param {string} value 
*/
  function sheet3_OnClick(sheet , row, col, value) {  
 	sheetObjects[2].SetCellValue(row,"chk",1);
  }                   
   /**
    * Event when clicking Tab
    * activating selected tab items
    */
  function tab1_OnChange(tabObj , nItem)
  {
	  var objs=document.all.item("tabLayer");
	  objs[nItem].style.display="inline";
	  objs[beforetab].style.display="none";
	  
	  var objs2=document.all.item("tabLayer_btn");
//	  objs2[nItem].style.display="inline";
//	  objs2[beforetab].style.display="none";
	  $(objs2[nItem]).show();
	  $(objs2[beforetab]).hide();
	  if ($(objs2[0]).prop('style').display == 'none') {
		  $('.page_title_area').children('span').first().remove();
	  } else {
		  $('.page_title_area').children('tabLayer_btn').first().after('<span class="clear"></span>');
	  }
	  
	  //--------------- important --------------------------//
	  objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
	  //------------------------------------------------------//
	  //--------------- important --------------------------//
//	  objs2[beforetab].style.zIndex=objs2[nItem].style.zIndex -1 ;
	  //------------------------------------------------------//     	
	  beforetab=nItem;
   }
 /**	
  * whether to select Yard or Zone,change screen Layout 
  */     
 function setDisplayTp(displayTp){
	 if("Y" == displayTp){
		 // if Yard  select
		 document.getElementById("yardTable").style.display="block";
		 document.getElementById("zoneTable").style.display="none";
		 document.getElementById("ydCheck").style.display="block";
		 document.getElementById("znCombo").style.display="none";    		 
	 }else{
		 // If Zone select
		 document.getElementById("yardTable").style.display="none";
		 document.getElementById("zoneTable").style.display="block";
		 document.getElementById("ydCheck").style.display="none";
		 document.getElementById("znCombo").style.display="block";      		 
	 }
 }
 /**
  * end screen information to Main
  */     
 function comPopupSend(formObj, tab){
	 var calllFunc=formObj.calllFunc.value;
	 if(calllFunc != ''){
		 var locTp=formObj.locTp.value;
		 var nRow=formObj.row.value;
		 var nCol=formObj.col.value;
		 var nSheetIdx=formObj.sheetIdx.value;
		 var rArray=null;
		 if(tab == 1){
			 rArray=getCheckedRowByName(sheetObjects[0], "chk");
		 }else{
			 if(formObj.yz_flag[0].checked){
				 rArray=getCheckedRowByName(sheetObjects[1], "chk");
			 }else{
				 rArray=getCheckedRowByName(sheetObjects[2], "chk");
			 }				 
		 }
		 
		 if (ComFuncCheck("opener." + calllFunc)) ComFunc(locTp,tab,rArray, nRow, nCol, nSheetIdx);
		 else if (ComFuncCheck("parent." + calllFunc)) ComFunc(locTp,tab,rArray, nRow, nCol, nSheetIdx);
		 ComClosePopup(); 
	 }
 }
 // value from Node common Popup set on main
 function setYardSearch(aryPopupData, row, col, shhetIdx){
	 var formObj=document.form;
	 formObj.loc_cd.value=aryPopupData[0][3].substring(0,5);
	 formObj.loc_cd2.value=aryPopupData[0][3].substring(5,7);
 }
 // calling Node common Popup 
 function openComNodePop(){
	 var mode;
	 if(document.form.yz_flag[0].checked){
		 mode="yard";
	 }else{
		 mode="zone";
	 }
	 ComOpenPopup('COM_ENS_061.do?pgmNo=COM_ENS_061&mode='+mode, 800, 450, 'setCallBack008302','1,0,1,1,1', true);
 }
 function setCallBack008301(rArray){
		var formObject=document.form;
		if(rArray != null){
			formObject.country_cd.value=rArray[0][3];
		}  		    	 
 }
 function setCallBack008302(rArray){
	var formObject=document.form;		
	if(rArray != null){
		formObject.loc_cd.value=rArray[0][3].substring(0,5);
		formObject.loc_cd2.value=rArray[0][3].substring(5,7);
	}  		    	 
  }     
