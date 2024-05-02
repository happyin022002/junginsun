/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_2008.js
*@FileTitle : Guarantee TPB I/F
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESD_TES_2008 : business script for ESD_TES_2008
     */
    function ESD_TES_2008() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
// global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab1=1;
var beforetab2=1
var sheetObjects=new Array();
var sheetCnt=0;
/**
 * Event handler processing by button click event 
 */
document.onclick=processButtonClick;
	/**
	 * Event handler processing by button name
	 **/
	function processButtonClick(){
		/***** using extra sheet valuable if there are more 2 sheets *****/
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_ok":
					doActionIBSheet(sheetObject1, document.form, IBSAVE);
					ComClosePopup(); 
					break; 
				case "btn_save":
					doActionIBSheet(sheetObject1, document.form, IBSAVE);
					break;
				case "btn_close":
					ComClosePopup(); 
					break; 
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('TES21025');   //The service is not available now
			} else {
				ComShowMessage(e.message);
			}
	 	}
	}
	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source. <br>
	 * @param{ibsheet}		sheet_obj		IBSheet Object
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;	
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
		document.getElementById("curr_cd").value=document.getElementById("gnte_curr_cd").value;
		document.getElementById("curr_cd").disabled=true; 
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	/**
	 * setting sheet initial values and header
	 * adding case as numbers of counting sheets
	 * 
	 * @param {ibsheet}  	sheetObj	Sheet Object
	 * @param {int,string}  sheetNo		Sheet Object 
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetObj.id) {
			case "sheet1":      //sheet1 init
			    with(sheetObj){

		     
		      var HeadTitle1="||Seq|BKG No.|Container No.|VVD|Amount|3rd Party|3rd Party|Remarks|IF OFC|IF Seq|Billing CD|BL No.|Cntr TpSz";
		      var headCount=ComCountHeadTitle(HeadTitle1);

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"tml_gnte_cntr_list_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"if_amt",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"gnte_cust_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"gnte_cust_cd_name",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_desc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"tml_if_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"tml_if_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"gnte_tp_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);

		      SetEditable(1);
		      SetCountPosition(0);
		      SetShowButtonImage(2);
		      SetSheetHeight(162);
		      }


				break;
		}
	}
	/**
	 * handling IBSheet ( Header ) process <br>
	 * 
	 * @param {ibsheet}		sheetObj	IBSheet Object
	 * @param {Object}		formObj		Form Object
	 * @param {String}		sAction		Action Command
	 */
	function doActionIBSheet( sheetObj, formObj, sAction ) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //Retrieve
	    		formObj.f_cmd.value=SEARCH;
 		 		sheetObj.DoSearch("ESD_TES_2008GS.do", tesFrmQryStr(formObj)  );
				break;
			case IBSAVE:        //Save
            	if (sheetObj.CheckedRows('chk') < 1){
            		ComShowCodeMessage('TES21009'); 
            		return false;
            	}
            	var notIfCnt=0;
            	for ( var i=sheetObj.HeaderRows(); i < sheetObj.HeaderRows()+ sheetObj.RowCount(); i++ ) {
            		if ( !ComIsNull( sheetObj.GetCellValue(i, "if_amt") ) && sheetObj.GetCellValue(i, "if_amt") < 0 ) {
            			notIfCnt++;
            		}
            		if ( !ComIsNull( sheetObj.GetCellValue(i, "tml_if_ofc_cd") ) && !ComIsNull( sheetObj.GetCellValue(i, "tml_if_seq") ) ) {
						sheetObj.SetCellEditable(i, 'chk',0);
						sheetObj.SetCellValue(i, "chk",0,0);
					} else {
						if (sheetObj.GetCellValue(i, 'chk') == '1'){
							if (sheetObj.GetCellValue(i, 'tml_if_ofc_cd') == null ||
									sheetObj.GetCellValue(i, 'tml_if_ofc_cd') == '' ) {
								sheetObj.SetCellValue(i, 'ibflag',"I");
							} else {
								sheetObj.SetCellValue(i, 'ibflag',"U");
							}
						}
					}
				}
            	if ( notIfCnt > 0 ) {
            		ComShowCodeMessage('TES70801');	// You can't I/F minus amount.
            		return false;
            	}
            	document.getElementById("curr_cd").disabled=false;
				formObj.f_cmd.value=ADD;
				var	 param=sheetObj.GetSaveString();
 				var	 savexml=sheetObj.GetSaveData("ESD_TES_2008GS.do", tesFrmQryStr(formObj) + '&' + param);
 				sheetObj.LoadSaveData(savexml, true);
				break;
		}
	}
	/**
	 * search end event<br>
	 * 
	 * @param {ibsheet}		sheetObj	IBSheet Object
	 * @param {int,String}	row			Row Index
	 * @param {int,String}	col			Column Index
	 */
	function sheet1_OnSearchEnd(sheetObj, row, col) {
		for ( var i=sheetObj.HeaderRows(); i < sheetObj.HeaderRows()+ sheetObj.RowCount(); i++ ) {
			if ( !ComIsNull( sheetObj.GetCellValue(i, "tml_if_ofc_cd") ) && !ComIsNull( sheetObj.GetCellValue(i, "tml_if_seq") ) ) {
				sheetObj.SetCellEditable(i, 'chk',0);
				sheetObj.SetCellValue(i, 'chk',0,0);
			} else {
				sheetObj.SetCellEditable(i, 'chk',1);
				sheetObj.SetCellValue(i, 'chk',1,0);
			}
		}
	}
	/**
	 * IBSheet save end event <br>
	 * 
	 * @param{ibsheet}		sheetObj	Sheet Object
	 * @param{string}		errMsg		Error Message
	 */
	function sheet1_OnSaveEnd(sheetObj, errMsg){
	    if( errMsg == '' ) {
	    	
	    	var opener=window.dialogArguments;
			
			if (!opener) opener=window.opener;  //이 코드 추가할것
			if (!opener) opener=parent;         // 기존 가이드 부분
			
			opener.tpbRetrive();
	    	ComClosePopup(); 
	    } else {
			ComShowMessage( errMsg );
	    }
	}
