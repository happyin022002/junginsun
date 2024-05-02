/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_0031.js
*@FileTitle : Carrier Code Creation/Retrieve
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
				 [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// global variable
var sheetObjects=new Array();
var sheetCnt=0;
var Mincount=0;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
	function processButtonClick(){
		 /***** using extra sheet valuable if there are more 2 sheets *****/
		 var sheetObject=sheetObjects[0];
		 /*******************************************************/
		 var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_save":					
					for(var i=1;i<=sheetObjects[0].RowCount();i++){
						if(sheetObjects[0].GetRowStatus(i)=="I" && sheetObjects[0].GetCellValue(i,"tml_crr_cd")==""){
									ComShowMessage(getMsg('TES15010'));
									return false;								
						}else if(sheetObjects[0].GetRowStatus(i)=="I" && sheetObjects[0].GetCellValue(i,"crr_desc")==""){
									ComShowMessage(getMsg('TES15011'));
									return false;									
							}
					}
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
				case "btng_rowadd":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(getMsg('TES21025'));
			} else {
				ComShowMessage(e.message);
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
	 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
	 * @return
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
	/**
	 * setting sheet initial values and header
	 * @param {ibsheet} sheetObj 	IBSheet Object
	 * @param {int} sheetNo 	 
	 * 							adding case as numbers of counting sheets
	 * @return
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:	  //sheet1 init
			    with(sheetObj){

		      var HeadTitle="Carrier Code|Carrier Full Name" ;

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:1, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:0,   SaveName:"crr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
		             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"crr_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		       
		      InitColumns(cols);

		      SetEditable(1);
		    //no support[check again]CLT 					style.height=GetSheetHeight(22);
//		      SetSheetHeight(ComGetSheetHeight(sheetObj, 22));
			  resizeSheet();
		            }
				break;
		}
	}
	/**
	 * handling sheet process
	 * @param {ibsheet} sheetObj 	IBSheet Object
	 * @param {form} 	formObj		Form Object
	 * @param {int}		sAction		
	 * @return
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
            case IBSEARCH:	  //Retrieve
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=SEARCH;
 					sheetObj.DoSearch("ESD_TES_0031GS.do", tesFrmQryStr(formObj) );
					//sheetObj.DoSearch4Post("com.clt.apps.bms.bms.pfm.managemarketstatus.UIBMSPFM001Action.do", tesFrmQryStr(formObj));
				}
				break;
			case IBSAVE:		//Save
				if(validateForm(sheetObj,formObj,sAction)) { 
					//ComShowMessage (" Save .. ");
					formObj.f_cmd.value=MULTI;
				    sheetObj.DoSave("ESD_TES_031GS.do", tesFrmQryStr(formObj),-1,false);
				}
				break;
			case IBINSERT:	 
				sheetObj.DataInsert();
				break;
            case IBCOPYROW:	
			  sheetObj.DataCopy();
			  break;
		   case IBDOWNEXCEL:
			   if(sheetObj.RowCount() < 1){
					ComShowCodeMessage("COM132501");
				}else{
					 sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
				} 			 
			  break;
		   case IBLOADEXCEL:
 			  sheetObj.LoadExcel();
			  break;
		}
	}
   /**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
//			if (!isNumber(iPage)) {
//
//				return false;
//			}
		}
		return true;
	}
	/**
	 * MInimize click event
	 * @param {string}	nItem	display 여부
	 * @return
	 */
	function Minimize(nItem)
	{
		var objs=document.all.item("showMin");
		if ( nItem == "1" )
		{
			objs.style.display="none";
//no support[check again]CLT 			sheetObjects[0].style.height=sheetObjects[0].GetSheetHeight(20);
			sheetObjects[0].SetSheetHeight(ComGetSheetHeight(sheetObj, 20));
			sheetObjects[0].focus();
//no support[check again]CLT 			sheetObjects[0].ViewRows=20;
		}
		else
		{
			objs.style.display="inline";
//no support[check again]CLT 			sheetObjects[0].style.height=sheetObjects[0].GetSheetHeight(10);
			sheetObjects[0].SetSheetHeight(ComGetSheetHeight(sheetObj, 10));
			sheetObjects[0].focus();
//no support[check again]CLT 			sheetObjects[0].ViewRows=10;
		}
	}
	// UI 표준화관련 하단 여백 설정
	function resizeSheet() {
		    ComResizeSheet(sheetObjects[0]);
	}