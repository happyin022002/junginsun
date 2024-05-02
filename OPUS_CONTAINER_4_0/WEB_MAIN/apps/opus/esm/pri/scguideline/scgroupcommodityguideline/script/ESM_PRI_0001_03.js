/*=========================================================
** 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0001_03.js
*@FileTitle  :  Commodity Group
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/04
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3; MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Commodity Group : business script for ESM_PRI_0001_03
     * 
     */
    // global variables 
    var sheetObjects=new Array();
 	var sheetCnt=0;
	var enableFlag=true;
	var isFiredNested=false;
	var supressConfirm=false;	
	// Event handler processing by button click event */
 	document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * @author 
     * @version 
     */
     function processButtonClick(){
          var sheetObject1=sheetObjects[0];
          var sheetObject2=sheetObjects[1];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_Retrieve":
					if (validateForm(sheetObject1,formObject,IBSEARCH)) {
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						fontChange();
					} else {
						ComShowCodeMessage('PRI08001');
					}
					break;
				case "btn_Save":				
					if (validateForm(sheetObject1,formObject,IBSAVE)) {
						if (ComPriConfirmSave()) {
							ComOpenWait(true);
							doActionIBSheet(sheetObject1,formObject,IBSAVE);
							fontChange();
							ComOpenWait(false);
						}
					}
					break;					
				case "btn_DownExcel":
					if (validateForm(sheetObject1,formObject,IBDOWNEXCEL)) {
						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					}
					break;
				case "btn_Add":		
					if (enableFlag && validateForm(sheetObject1,formObject,IBINSERT)) {
						doActionIBSheet(sheetObject1,formObject,IBINSERT);
					}
					break;					
				case "btn_Add2":
					if (enableFlag && validateForm(sheetObject2,formObject,IBINSERT)) {
						doActionIBSheet(sheetObject2,formObject,IBINSERT);
					}
					break;					
				case "btn_Del":			
					if (enableFlag && validateForm(sheetObject1,formObject,IBDELETE)) {
						doActionIBSheet(sheetObject1,formObject,IBDELETE);
					}
					break;					
				case "btn_Del2":			
					if (enableFlag && validateForm(sheetObject2,formObject,IBDELETE)) {
						doActionIBSheet(sheetObject2,formObject,IBDELETE);
					}
					break;					
				case "btn_Copy":
					if ( formObject.yn_data.value == "Y"){
						ComShowCodeMessage('PRI08004');
						return;
					}
					var sParam="svc_scp_cd=" + formObject.svc_scp_cd.value + "&gline_seq=" + formObject.gline_seq.value
								+"&prc_cust_tp_cd="+formObject.prc_cust_tp_cd.value;
					ComOpenPopup("ESM_PRI_0064.do?"+sParam, 550, 325, "ESM_PRI_0064_returnVal",  "1,0",true);      
					
					break;		
				case "prc_cust_cd":
			    	if (formObject.svc_scp_cd.value != "" && formObject.gline_seq.value != "") {
			    		obj_click();
			    	}
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
     
     function ESM_PRI_0064_returnVal(rtnVal) {
    	 if (rtnVal != null && rtnVal == "ok"){											
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				parent.setTabStyle();
				fontChange();
			}
     }
     /**
      * Registering IBSheet Object by array<br>
      * <br><b>Example :</b>
      * <pre>
      *     setSheetObject(sheetObj);
      * </pre>
      * @param {ibsheet} sheet_obj mandatory IBSheet Object
      * @return N/A
      * @author 
      * @version 
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * Initializing and setting Sheet basics<br> 
      * Setting body tag's onLoad event handler<br>
      * Adding pre-handling function after loading screen on the browser <br>
      * <br><b>Example :</b>
      * <pre>
      *     loadPage();
      * </pre>
      * @return N/A
      * @author 
      * @version 
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);           
             ComEndConfigSheet(sheetObjects[i]);
         }
         resizeSheet();
         toggleButtons("CLEAR");
         parent.loadTabPage();
     }
     /**
    * setting sheet initial values and header
    * param : sheetObj, sheetNo
    * adding case as numbers of counting sheets
    */
  function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 		 var sheetID=sheetObj.id; 
         switch(sheetID) {
             case "sheet1":
            	    with(sheetObj){
		                 
		               var HeadTitle="|Sel.|Seq.|svcscpcd|glineseq|prccusttpcd|grp_cmdtseq|Group Code|Description";
		               var headCount=ComCountHeadTitle(HeadTitle);
		               (headCount, 0, 0, true);
		
		               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                      {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                      {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"gline_seq" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"prc_cust_tp_cd" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"grp_cmdt_seq" },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_grp_cmdt_cd",    KeyField:1,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:5 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_cmdt_desc",  KeyField:1,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:1000 , ExceptKeys:"[/]" } ];
		                
		               InitColumns(cols);
		
		               SetEditable(1);
		               SetWaitImageVisible(0);
		               SetShowButtonImage(2);
		               resizeSheet(); //SetSheetHeight(340);
               }

                 break;
             case "sheet2":
            	    with(sheetObj){
		                 
		               var HeadTitle="|Sel.|Seq.|svcscpcd|glineseq|prccusttpcd|grpcmdtseq|grpcmdtdtlseq|Code|Description";
		               var headCount=ComCountHeadTitle(HeadTitle);
		               (headCount, 0, 0, true);
		
		               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                      {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                      {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"gline_seq" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"prc_cust_tp_cd" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"grp_cmdt_seq" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"grp_cmdt_dtl_seq" },
		                      {Type:"PopupEdit", Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                      {Type:"Text",      Hidden:0,  Width:280,  Align:"Left",    ColMerge:0,   SaveName:"loc_des",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:200} ];
		                
		               InitColumns(cols);
		
		               SetEditable(1);
		               SetWaitImageVisible(0);
		               SetShowButtonImage(2);
		               resizeSheet(); //SetSheetHeight(340);
               }
                 break;
             case "sheet3":
            	    with(sheetObj){
		                 
		               var HeadTitle="|Seq.|Group Code|Group Description|Code|Description";
		               var headCount=ComCountHeadTitle(HeadTitle);
		               (headCount, 0, 0, true);
		
		               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                      {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                      {Type:"Text",     Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"prc_grp_cmdt_cd" },
		                      {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_cmdt_desc" },
		                      {Type:"PopupEdit", Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd" },
		                      {Type:"Text",     Hidden:0,  Width:280,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm" } ];
		                
		               InitColumns(cols);		
		               SetEditable(1);
		               SetWaitImageVisible(0);
		               SetSheetHeight(260);
                     }
                 break;                 
         }
     }
  
  function resizeSheet(){
   	ComResizeSheet(sheetObjects[0]);
   	ComResizeSheet(sheetObjects[1]);
   	ComResizeSheet(sheetObjects[2]);
   }
  
  /**
   * Handling sheet process<br>
   * @author
   * @version 
   */
  function doActionIBSheet(sheetObj,formObj,sAction) {
          sheetObj.ShowDebugMsg(false);
          try{
              switch(sAction) {
		  		case IBSEARCH_ASYNC01: 	
					formObj.f_cmd.value=SEARCH10;
					var sXml=sheetObj.GetSearchData("ESM_PRI_0001_03GS.do" , FormQueryString(formObj));
					var arrData=ComPriXml2Array(sXml, "cd|nm|rcnt");
					var eleName="cust_tp";
					var j=1;
					var optCheck=0;
					for (var i=0; i < arrData.length; i++) {
						switch (arrData[i][0]){
						case "A":
							j="1";
							break;
						case "I":
							j="2";
							break;
						case "N":
							j="3";
							break;
						case "O":
							j="4";
							break;								
						}
						if (parseInt(arrData[i][2],10) > 0) {
							document.getElementById(eleName + j).style.fontWeight="bold";
							if (optCheck == 0){
								optCheck=j;
							}
						} else {
							document.getElementById(eleName + j).style.fontWeight="";
						}
					}
					if (optCheck <= 0){
						document.form.prc_cust_cd[0].checked=true;
					}else{
						document.form.prc_cust_cd[optCheck - 1].checked=true;	
					}					
					var obj=document.form;
					if (obj.prc_cust_cd[0].checked == true){
						obj.prc_cust_tp_cd.value="A";
					}else if (obj.prc_cust_cd[1].checked == true){
						obj.prc_cust_tp_cd.value="I";
					}else if (obj.prc_cust_cd[2].checked == true){
						obj.prc_cust_tp_cd.value="N";
					}else if (obj.prc_cust_cd[3].checked == true){
						obj.prc_cust_tp_cd.value="O";
					}	
					break;		  		
				case IBSEARCH:     
					ComOpenWait(true); //->waiting->start 
					if (validateForm(sheetObj,document.form,sAction)) {
						for (var i=0; i < sheetObjects.length; i++) {
							sheetObjects[i].RemoveAll();
						}						
						formObj.f_cmd.value=SEARCH01;
 						sheetObj.DoSearch("ESM_PRI_0001_03GS.do", FormQueryString(formObj) );
					} else {
						ComShowCodeMessage('PRI08001');
					}	 
					ComOpenWait(false); //->waiting->End
					break;
				case IBSEARCHAPPEND: 
					ComOpenWait(true); //->waiting->start 
					if (validateForm(sheetObj,document.form,sAction)) {
						formObj.f_cmd.value=SEARCH02;
 						var sXml = sheetObj.GetSearchData("ESM_PRI_0001_03GS.do", FormQueryString(formObj) );
 						if(sXml != null) sheetObj.LoadSearchData(sXml, {Sync:1})
 						
					}
					ComOpenWait(false); //->waiting->End
					break;
				case IBSAVE :
					formObj.f_cmd.value = MULTI;
					var sParam=FormQueryString(formObj);
					var sParamSheet1=sheetObjects[0].GetSaveString();
					if (sheetObjects[0].IsDataModified()&& sParamSheet1 == "") {
						return false;
					}
					sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");		
					var sParamSheet2=sheetObjects[1].GetSaveString();
					if (sheetObjects[1].IsDataModified()&& sParamSheet2 == "") {
						return false;
					}
					sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
 					var sXml=sheetObj.GetSaveData("ESM_PRI_0001_03GS.do", sParam);
 					sheetObjects[0].LoadSaveData(sXml, {Sync:1});
 					
 					sXml=ComDeleteMsg(sXml);
 					sheetObjects[1].LoadSaveData(sXml, {Sync:1});
					
 					
					
					if (sheetObjects[0].IsDataModified() || sheetObjects[1].IsDataModified()) {
						return false;
					} else {
						if (getValidRowCount(sheetObjects[1]) <= 0) {							
							doRowChange(sheetObjects[0], sheetObjects[1], -1, sheetObjects[0].GetSelectRow(), sheetObjects[0].GetSelectCol(), sheetObjects[0].GetSelectCol(), false);
						}						
						return true;
					}
					break;
				case IBINSERT:     
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					if (sheetObj.id == "sheet1") {						
						var idx=doRowChange(sheetObj, sheetObjects[1], -2, sheetObj.GetSelectRow(), sheetObj.GetSelectCol(), sheetObj.GetSelectCol, true);
						var maxCode=0;
						if (idx < 0) {
							return false;
						}
						sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
						sheetObj.SetCellValue(idx, "gline_seq",formObj.gline_seq.value);
						sheetObj.SetCellValue(idx, "prc_cust_tp_cd",formObj.prc_cust_tp_cd.value);
						sheetObjects[1].RemoveAll();
						sheetObj.SetCellValue(idx, "grp_cmdt_seq",parseInt(ComPriGetMax(sheetObj, "grp_cmdt_seq"),10) + 1);
						maxCode=parseInt(groupCodeGetMax(sheetObj, "prc_grp_cmdt_cd"),10) + 1 + "";
						sheetObj.SetCellValue(idx,"prc_grp_cmdt_desc","Group " + maxCode,0);
						maxCode=ComLpad(maxCode,   4, "0");
						sheetObj.SetCellValue(idx,"prc_grp_cmdt_cd","G"+ maxCode,0);
						sheetObj.SelectCell(idx, "prc_grp_cmdt_desc");
					}
					if (sheetObj.id == "sheet2") {
						var idx=sheetObj.DataInsert(-1);
						sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
						sheetObj.SetCellValue(idx, "gline_seq",formObj.gline_seq.value);
						sheetObj.SetCellValue(idx, "prc_cust_tp_cd",formObj.prc_cust_tp_cd.value);
						var grp_cmdt_seq=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "grp_cmdt_seq");
						sheetObj.SetCellValue(idx, "grp_cmdt_seq",grp_cmdt_seq);
						sheetObj.SetCellValue(idx, "grp_cmdt_dtl_seq",parseInt(ComPriGetMax(sheetObj, "grp_cmdt_dtl_seq"),10) + 1);
						sheetObj.SelectCell(idx, "prc_cmdt_def_cd");
					}
					break;				
				case IBDOWNEXCEL:      //excel		
					ComOpenWait(true); //->waiting->start 
					formObj.f_cmd.value=SEARCH03;
 					var sXml = sheetObjects[2].GetSearchData("ESM_PRI_0001_03GS.do", FormQueryString(formObj));
 					if(sXml != null) sheetObjects[2].LoadSearchData(sXml, {Sync:1})
					ComOpenWait(false); //->waiting->End
					break;
				case IBDELETE: // Delete		
		        	if (sheetObj.CheckedRows("chk") <= 0) {
		        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1");
		        	}	
		        	//prohibiting deletion data using on rate 
					if (sheetObj.id == "sheet1") {
						var arrChecked=sheetObj.FindCheckedRow("chk").split("|");
						for (var i=0; i < arrChecked.length; i++) {
							if (arrChecked[i] == null || arrChecked[i] == "" || arrChecked == undefined) {
								continue;
							}
							formObj.f_cmd.value=SEARCH11;
							var sParam=FormQueryString(formObj) + "&prc_grp_cmdt_cd=" + sheetObj.GetCellValue(arrChecked[i], "prc_grp_cmdt_cd");
 							var sXml=sheetObj.GetSearchData("ESM_PRI_0001_03GS.do", sParam);
							var arrTemp=ComPriXml2Array(sXml, "etc1");
							if (arrTemp != null && arrTemp[0] != null && arrTemp[0][0] != null) {
								var cntInUse=parseInt(arrTemp[0][0],10);
								if (cntInUse > 0) {
									ComShowCodeMessage("PRI08017");
									return false;
								}
							} else {
								return false;
							}
						}
					}		
					if (sheetObj.id == "sheet1" && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "chk") == "1") {
					    sheetObjects[1].RemoveAll();
					}
					var delCnt=deleteRowCheck(sheetObj, "chk");
					if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "D") {
					    sheetObjects[1].RemoveAll();
					}						
					//checking in case of selecting all rows in detail
					if (sheetObj.id == "sheet2" && getValidRowCount(sheetObj) < 1 ) {
//						if(ComShowCodeConfirm('PRI00021')){							
							sheetObjects[0].CheckAll("chk",0,1);
							formObj.f_cmd.value=SEARCH11;
							var sParam=FormQueryString(formObj) + "&prc_grp_cmdt_cd=" + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "prc_grp_cmdt_cd");
 							var sXml=sheetObj.GetSearchData("ESM_PRI_0001_03GS.do", sParam);
							var arrTemp=ComPriXml2Array(sXml, "etc1");							
							if (arrTemp != null && arrTemp[0] != null && arrTemp[0][0] != null) {
								var cntInUse=parseInt(arrTemp[0][0],10);
								if (cntInUse > 0) {
									ComShowCodeMessage("PRI08017");
									return false;
								}else{
									sheetObjects[1].RemoveAll();
									sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "chk","1");
									deleteRowCheck(sheetObjects[0], "chk");		
								}
							}
//						}
					}
					break;				
              }        	  
          } catch (e) {
          		if (e == "[object Error]") {
                    ComShowMessage(OBJECT_ERROR);
                } else {
                    ComShowMessage(e.message);
                }
          }finally{
	          	if (sAction == IBDELETE || sAction == IBINSERT
	          			|| sAction == IBSEARCH_ASYNC01) {
	          		return;
	          	}
	          	ComOpenWait(false); //->waiting->End
          }
      }
/**
 * calling function when occurring OnBeforeCheck event <br> 
 * calling ComPriCheckWithPnS function when click the check box
 */      
  	function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName=sheetObj.ColSaveName(Col);
		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 0, Row, Col);
		}
	}
  	/**
  	 * calling function when occurring OnBeforeCheck event <br> 
  	 * calling ComPriCheckWithPnS function when click the check box
  	 */  
	function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName=sheetObj.ColSaveName(Col);
		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 1, Row, Col);
		}
	}      
  	/**
  	 * calling function when occurring OnSelectCell event <br> 
  	 * calling doRowChange function when select the row
  	 */    	
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
	    doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
	}
	
	/**
	 * Calling function in case of Onclick event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2015.06.24 
	 */
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		var memoColWidth =	sheetObj.GetColWidth("prc_grp_cmdt_desc");
		
		if (colName == "prc_grp_cmdt_desc") {
			if (sheetObj.GetRowEditable(Row)) {
				ComShowMemoPad(sheetObj, Row, Col, false, memoColWidth, parseInt(sheetObj.GetDataRowHeight()) * 7, 1000, "X");
			} else {
				ComShowMemoPad(sheetObj, Row, Col, true, memoColWidth, parseInt(sheetObj.GetDataRowHeight()) * 7, 1000, "X");
			}
			
			//2015.06.24 
			//MemoPad 생성시점 후 에 이벤트 잡을 수 있음
			//keyup으로 하면 붙여넣기 했을때 대응방법이 없기때문에 focus나갈때 바꾼다
			$("#"+MEMO_TEXT_NAME).blur(function(event){
				$(this).val($(this).val().replace(/\//gi, "")); 
			});

		} 
	}
	
	 /**
	* calling function when occurring OnChange Event <br> 
	* when selecting multi comboBox, showing description<br>
	*/	
    function sheet2_OnChange(sheetObj, Row, Col, Value)
    {
    	var colname=sheetObj.ColSaveName(Col);
    	var formObj=document.form
    	switch(colname)
    	{
	    	case "prc_cmdt_def_cd":	    		
	    		if (Value.length==6){
	    			formObj.f_cmd.value=SEARCH08;
	    			formObj.cd.value=Value;
 	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
  					if (arrData[1] != ""){
  						sheetObj.SetCellValue(Row,"loc_des",arrData[1],0);
  					}else{
  						sheetObj.SetCellValue(Row,"loc_des","",0);
	  					sheetObj.SetCellValue(Row,"prc_cmdt_def_cd","",0);
	  					ComShowCodeMessage("PRI00315");
	  					sheetObj.SelectCell(Row,"prc_cmdt_def_cd")
  					}	  				
	    		}else{	   
	    			sheetObj.SetCellValue(Row,"loc_des","",0);
  					sheetObj.SetCellValue(Row, "prc_cmdt_def_cd","",0);
  					ComShowCodeMessage("PRI00315");
  					sheetObj.SelectCell(Row, "prc_cmdt_def_cd")
	    		}
	    		break;
    	}
    }    		
    /**
    * sheet1 OnPopupClick event function <br>
    * calling Location PopUp
    */  	      	 
    var popupRow = 0;
	function sheet2_OnPopupClick(sheetObj, Row, Col) {
		var colName=sheetObj.ColSaveName(Col);
		popupRow = Row;
		var formObj=document.form;
		if (colName == "prc_cmdt_def_cd"){
			var sUrl="ESM_PRI_4027.do?grp_cd="+ PRI_SG+"&commodity_cmd=C";
			ComOpenPopup(sUrl, 700, 350, "setCommodity",  "1,0", true);      
		}
	}
	
	function setCommodity(rtnVal) {
		if (rtnVal != null){
			var sheetObj=sheetObjects[1];
			sheetObj.SetCellValue(popupRow, "prc_cmdt_def_cd", rtnVal.cd, 0);
			sheetObj.SetCellValue(popupRow, "loc_des", rtnVal.nm, 0);
		}
	}
	/**
	 * handling function when chaging the sheet's Row <br>
	 */
	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj=document.form;
		var adjNewRow=NewRow;
		if (!isFiredNested && (OldRow != NewRow)) {
			if (sheetM.IsDataModified()) {
				isFiredNested=true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested=false;
				if (validateForm(sheetM,document.form,IBSAVE)) {
					isFiredNested=true;
					sheetM.SelectCell(NewRow, NewCol, false);
					isFiredNested=false;
				} else {
					isFiredNested=true;
					sheetM.SelectCell(OldRow, OldCol, false);
					isFiredNested=false;
					return -1;
				}
			}
			if (sheetD.IsDataModified()) {
				isFiredNested=true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested=false;
				var rslt=false;
				if (ComShowCodeConfirm("PRI00006")) {
					supressConfirm=true;
					adjNewRow = Math.max(NewRow - sheetM.RowCount("D"), sheetM.HeaderRows());
					var rslt=doActionIBSheet(sheetM,document.form,IBSAVE);
					supressConfirm=false;
					return false;
				}
				if (rslt) {
					isFiredNested=true;
					sheetM.SelectCell(adjNewRow, NewCol, false);
					isFiredNested=false;
				} else {
					isFiredNested=true;
					sheetM.SelectCell(OldRow, OldCol, false);
					isFiredNested=false;
					return -1;
				}
			}
			if (appendRow) {
				isFiredNested=true;
				var idx=sheetM.DataInsert(-1);
				isFiredNested=false;
				return idx;
			} else {
				formObj.grp_cmdt_seq.value=sheetM.GetCellValue(adjNewRow, "grp_cmdt_seq");
				doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
			}
		}
	}
	/**
	* checking validation process of inputted form data <br>
	*/
     function validateForm(sheetObj,formObj,sAction){
  		switch (sAction) {
			case IBSEARCH: 
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				}
				break;
			case IBSEARCHAPPEND: 
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				}
				break;				
			case IBDOWNEXCEL: // Excel Download
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					ComShowCodeMessage('PRI08001');
					return false;
				}
	        	if (sheetObjects[0].IsDataModified()== true || sheetObjects[1].IsDataModified()== true){
	        		ComShowCodeMessage('PRI00309','Commodity Group');
	        		return false;
	        	}			
				break;		
			case IBSAVE: 
				if (sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()) {
					if (sheetObjects[0].GetCellValue(sheetObjects[0].SelectRow, "ibflag") !="D" && getValidRowCount(sheetObjects[1]) <= 0
							&& sheetObjects[0].GetCellValue(sheetObjects[0].SelectRow, "ibflag") != -1) {

			              ComShowCodeMessage("PRI00007");
			              return false;
			       }
			       if (parent.document.form.cfm_flg.value =="Yes"){
			    	   ComShowCodeMessage("PRI00105");
			    	   return false;
			       }
					var rowM=sheetObjects[0].ColValueDup("prc_cust_tp_cd|prc_grp_cmdt_cd",false);
					if (rowM >= 0) {
						ComShowCodeMessage("PRI00303", "Group Code Sheet", rowM);
						sheetObjects[0].SelectCell(rowM, "prc_grp_cmdt_cd")
						return false;
					}					
					var rowD=sheetObjects[1].ColValueDup("prc_cust_tp_cd|grp_cmdt_seq|prc_cmdt_def_cd",false);
					if (rowD >= 0) {
						ComShowCodeMessage("PRI00303", "Commodity Sheet", rowD);
						sheetObjects[1].SelectCell(rowD, "prc_cmdt_def_cd")
						return false;
					}					
				} else {
					ComShowCodeMessage("PRI00301");
					return false;
				}				
				break;
			case IBINSERT: // Row Add
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				}
		       if (!getMainStatus()){
		    	   return false;
		       }	
				var rowCnt = getValidRowCount(sheetObjects[0]);
				if (sheetObj.id == "sheet2") {
					if (rowCnt <= 0){
						return false;
					}
				}					
				break;
			case IBDELETE: // Delete
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				}
		       if (!getMainStatus()){
		    	   return false;
		       }	
				break;
		}
  		return true;
     }
     /**
     * handling radio button Axon event <br>
     */ 	 
	function initControl() {
	    axon_event.addListener('click', 'obj_click', 'prc_cust_cd');
	}
    /**
    * calling function when occurring radio button click Event <br>
    */ 	
	function obj_click()
	{
		var obj=document.form;		
		if (sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()){
			if (ComPriConfirmSave()) {				
				if (validateForm(sheetObjects[0],obj,IBSAVE)) {					
					if (doActionIBSheet(sheetObjects[0],obj,IBSAVE)){
						fontChange();	
					}else{
						obj.prc_cust_cd[getCustTpCd()].checked=true;
						return;
					}
				}else{
					obj.prc_cust_cd[getCustTpCd()].checked=true;
					return;
				}
			}
		}
		if (obj.prc_cust_cd[0].checked == true){
			obj.prc_cust_tp_cd.value="A";
		}else if (obj.prc_cust_cd[1].checked == true){
			obj.prc_cust_tp_cd.value="I";
		}else if (obj.prc_cust_cd[2].checked == true){
			obj.prc_cust_tp_cd.value="N";
		}else if (obj.prc_cust_cd[3].checked == true){
			obj.prc_cust_tp_cd.value="O";
		}		
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}  
    /**
    * returning index of selected radio button when radio button clicked <br>
    */     
    function getCustTpCd(){
    	var formObj=document.form;
    	var tpCd=formObj.prc_cust_tp_cd.value;
    	var optIdx=0;
    	switch (tpCd){
    	case "A":
    		optIdx=0;
    		break;
    	case "I":
    		optIdx=1;
    		break;
    	case "N":
    		optIdx=2;
    		break;
    	case "O":
    		optIdx=3;
    		break;
    	}
    	return optIdx;
    }
    /**
     * changing function of radio button's font  <br>
     * existing the data, showing BOLD type  <br>
     */ 	     
    function fontChange(){
    	//SHEET ROW COUNT
		var row_count = getValidRowCount(sheetObjects[0]);
    	var formObj=document.form;
		var fontBold="";
    	var eleName="";
    	var tpCd=formObj.prc_cust_tp_cd.value;
    	var j=1;
    	switch (tpCd) {
	    	case "A":
	    		j=1;
	    		break;
	    	case "I":
	    		j=2;
	    		break;
	    	case "N":
	    		j=3;
	    		break;
	    	case "O":
	    		j=4;
	    		break;    		
    	}
    	eleName="cust_tp" + (j);
 		if (row_count > 0) {
 			fontBold="bold";
 		}    	
    	document.getElementById(eleName).style.fontWeight=fontBold;
    }         
     /**
      * calling function when occurring OnSearchEnd Event <br>
      */ 	       
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		var formObj=document.form;
		if( sheetObj.SearchRows()> 0){
			document.form.yn_data.value="Y"
		}else{
			document.form.yn_data.value="N"
		}
        tabEnableSheet(enableFlag);
	}
    /**
     * calling function when occurring OnSearchEnd Event <br>
     */ 	       
	function sheet2_OnSearchEnd(sheetObj, ErrMsg)
	{
       tabEnableSheet(enableFlag);
	}
    /**
     * calling function when occurring OnSaveEnd Event <br>
     * showing the save completion message in case of successful saving
     */ 		
	function sheet1_OnSaveEnd(sheetObj, ErrMsg)
	{
		var formObj=document.form;
    	if( sheetObj.RowCount()> 0){
			document.form.yn_data.value="Y"
		}else{
			document.form.yn_data.value="N"
		}
		parent.setTabStyle();
//		setCmdtGroupCopyBtn(sheetObj, formObj);
	}    
    /**
    * getting Max value from the column <br>
    */
   function groupCodeGetMax(sheetObj, sCol) {
       var max=0;
       for (var i=0; i <= sheetObj.LastRow(); i++) {
    	   if (parseInt(sheetObj.GetCellValue(i, sCol).substr(3,2),10) > max) {
    		   max=sheetObj.GetCellValue(i, sCol).substr(3,2);
           }
       }
       return max;
   }	
    /**
     * setting editable or not by parent screen's state <br>
     */    
    function getMainStatus(){
    	var mainStatus=parent.document.form.cfm_flg.value;
    	var editStatus=true;
    	if (mainStatus == "Yes"){
    		editStatus=false;
    	}
    	return editStatus;
    }      
     /**
      * setting activation by screen state <br>
      */       
 	function toggleButtons(mode) {
		switch (mode) {
		case "CLEAR":
			ComBtnDisable("btn_Retrieve");
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_DownExcel");
			ComBtnDisable("btn_Add");
			ComBtnDisable("btn_Del");
			ComBtnDisable("btn_Add2");
			ComBtnDisable("btn_Del2");
			ComBtnDisable("btn_Copy");
			break;
		case "INIT":
			ComBtnEnable("btn_Retrieve");
			if (getMainStatus()){
				ComBtnEnable("btn_Save");
			}else{
				ComBtnDisable("btn_Save");
			}
			ComBtnEnable("btn_DownExcel");
			ComBtnEnable("btn_Add");
			ComBtnEnable("btn_Del");
			ComBtnEnable("btn_Add2");
			ComBtnEnable("btn_Del2");
			ComBtnEnable("btn_Copy");
			break;
		case "READONLY":
			ComBtnEnable("btn_Retrieve");
			ComBtnDisable("btn_Save");
			ComBtnEnable("btn_DownExcel");			
			ComBtnDisable("btn_Add");
			ComBtnDisable("btn_Del");
			ComBtnDisable("btn_Add2");
			ComBtnDisable("btn_Del2");
			ComBtnDisable("btn_Copy");
			break;
		}
	}     	
    /**
    * calling function when click the tab of parent screen <br> 
    */ 		    	
 	function tabLoadSheet(sSvcScpCd, sGlineSeq, isAproUsr) {
		var formObject=document.form;
		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			formObject.svc_scp_cd.value=sSvcScpCd;
			formObject.gline_seq.value=sGlineSeq;
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC01);
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
            if (isAproUsr && parent.getCfmFlg() == "N") {
            	enableFlag=true;
            } else {
            	enableFlag=false;
            }
		}
	}
    /**
    * setting the "CLEAR" mode 
    * 
    */ 	 	 
	function tabClearSheet() {
		var formObject=document.form;		
		formObject.svc_scp_cd.value="";
		formObject.gline_seq.value="";		
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		toggleButtons("CLEAR");
		for (var i=1; i <5; i++){
			document.getElementById("cust_tp"+i).style.fontWeight="";	
		}
		formObject.prc_cust_cd[0].checked=true
	}     	 
    /**
     * calling from main screen <br>
     * prohibiting inputting, modifying, deleting in case of Confirmation is YES
     */ 			
	function tabEnableSheet(flag) {
		var formObject=document.form;
		enableFlag=flag;
		sheetObjects[0].SetEditable(flag);
		sheetObjects[1].SetEditable(flag);
		if (enableFlag) {
			toggleButtons("INIT");
		} else {
			toggleButtons("READONLY");
		}
	}
	
	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1, KeyFieldMark:0 });
	}    
