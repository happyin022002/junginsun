/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_0002_03.js
 *@FileTitle  : Commodity Group Guideline Inquiry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/06
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Commodity Group : business script for Commodity Group
     */
    function ESM_PRI_0002_03() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    // global variables
    var sheetObjects=new Array();
 	var sheetCnt=0;
	var enableFlag=true;
	var isFiredNested=false;
	var supressConfirm=false;	
 //Event handler processing by button click event */
 	document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
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
				case "btn_DownExcel":
					if(sheetObject1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						if (validateForm(sheetObject1,formObject,IBDOWNEXCEL)) {
							doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
						} else {
							ComShowCodeMessage('PRI08001');
						}
					}
					break;
				case "prc_cust_cd":
			    	if (formObject.svc_scp_cd.value != "" && formObject.gline_seq.value != "") {
			    		obj_click();
			    	}
					break;							
            } // end switch
     	}catch(e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
     	}
     }
     /**
      * registering IBSheet Object as list <br>
      * adding process for list in case of needing batch processing with other items  <br>
      * defining list on the top of source <br>
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * Initializing and setting Sheet basics <br>
      * Setting body tag's onLoad event handler <br>
      * Adding pre-handling function after loading screen on the browser  <br>
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);           
             ComEndConfigSheet(sheetObjects[i]);
         }
         resizeSheet();
         parent.loadTabPage();
     }
     /**
      * setting sheet initial values and header <br>
      * adding case as numbers of counting sheets <br>
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 		 var sheetID=sheetObj.id; 		 
         switch(sheetID) {
             case "sheet1":

                 with (sheetObj) {
            	 var HeadTitle="|Sel.|Seq.|svcscpcd|glineseq|prccusttpcd|grp_cmdtseq|Group Code|Description";
	               var headCount=ComCountHeadTitle(HeadTitle);
	               (headCount, 0, 0, true);
	
	               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	               var headers = [ { Text:HeadTitle, Align:"Center"} ];
	               InitHeaders(headers, info);
	
	               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                      {Type:"DummyCheck", Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	                      {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",	Sort:0 },
	                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd" },
	                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"gline_seq" },
	                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"prc_cust_tp_cd" },
	                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"grp_cmdt_seq" },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_grp_cmdt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_cmdt_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                
	               InitColumns(cols);
	
	               SetEditable(0);
	               SetWaitImageVisible(0);
	               SetShowButtonImage(2);
	               resizeSheet(); //SetSheetHeight(355);
                }

                 break;
             case "sheet2":
                 with (sheetObj) {
            	 var HeadTitle="|Sel.|Seq.|svcscpcd|glineseq|prccusttpcd|grpcmdtseq|grpcmdtdtlseq|Code|Description";
	               var headCount=ComCountHeadTitle(HeadTitle);
	               (headCount, 0, 0, true);
	
	               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	               var headers = [ { Text:HeadTitle, Align:"Center"} ];
	               InitHeaders(headers, info);
	
	               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                      {Type:"DummyCheck", Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	                      {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",   Sort:0 },
	                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd" },
	                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"gline_seq" },
	                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"prc_cust_tp_cd" },
	                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"grp_cmdt_seq" },
	                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"grp_cmdt_dtl_seq" },
	                      {Type:"Text", Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
	                      {Type:"Text",      Hidden:0,  Width:280,  Align:"Left",    ColMerge:0,   SaveName:"loc_des",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:200 } ];
	                
	               InitColumns(cols);
	
	               SetEditable(0);
	               SetWaitImageVisible(0);
	               SetShowButtonImage(2);
	               resizeSheet(); //SetSheetHeight(355);			 
                }

                 break;
             case "sheet3":
                 with (sheetObj) {
            	 var HeadTitle="|Seq.|Group Code|Group Description|Code|Description";
	               var headCount=ComCountHeadTitle(HeadTitle);
	               (headCount, 0, 0, true);
	
	               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	               var headers = [ { Text:HeadTitle, Align:"Center"} ];
	               InitHeaders(headers, info);
	
	               var cols = [ {Type:"Status",    	Hidden:1, 	Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                            {Type:"Seq",       	Hidden:0, 	Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	                            {Type:"Text",     	Hidden:0,  	Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_grp_cmdt_cd" },
	                            {Type:"Text",     	Hidden:0,  	Width:150,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_cmdt_desc" },
	                            {Type:"Text", 		Hidden:0, 	Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd" },
	                            {Type:"Text",    	Hidden:0,  	Width:400,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm" } ];
	                
	               InitColumns(cols);		
	               SetEditable(1);
	               SetWaitImageVisible(0);
	               resizeSheet(); //SetSheetHeight(260); 				 
                }
                 break;                 
         }
     }
     
     function resizeSheet() {
 	   	ComResizeSheet(sheetObjects[0]);
 		ComResizeSheet(sheetObjects[1]);
 		ComResizeSheet(sheetObjects[2]);
 	  }
     
     function sheet1_OnSort(sheetObj ,Col, SortArrow){
    	  sheet1.ReNumberSeq();   
    	 }
     
     function sheet2_OnSort(sheetObj ,Col, SortArrow){
    	  sheet2.ReNumberSeq();   
    	 }
     /**
      * Handling sheet process <br>
      */
      function doActionIBSheet(sheetObj,formObj,sAction) {
    	  try {
	          sheetObj.ShowDebugMsg(false);
	          switch(sAction) {
		          case IBSEARCH_ASYNC01: //  retrieving Customer Type again when loading screen 
		  			ComOpenWait(true);
					formObj.f_cmd.value=SEARCH10;
					var sXml=sheetObj.GetSearchData("ESM_PRI_0002_03GS.do" , FormQueryString(formObj));
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
						if (parseInt(arrData[i][2]) > 0) {
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
					ComOpenWait(false);
					break;
	 				case IBSEARCH:      //retrieve
						if (validateForm(sheetObj,document.form,sAction)) {
				  			ComOpenWait(true);
							for (var i=0; i < sheetObjects.length; i++) {
								sheetObjects[i].RemoveAll();
							}
							formObj.f_cmd.value=SEARCH01;
							sheetObj.DoSearch("ESM_PRI_0002_03GS.do", FormQueryString(formObj) );
							ComOpenWait(false);
						} else {
							ComShowCodeMessage('PRI08001');
						}	 
	 					break;
	 				case IBSEARCHAPPEND: // retrieve
						if (validateForm(sheetObj,document.form,sAction)) {
				  			ComOpenWait(true);
							formObj.f_cmd.value=SEARCH02;
							sheetObj.DoSearch("ESM_PRI_0002_03GS.do", FormQueryString(formObj) );
							ComOpenWait(false);
						}
						break;
					case IBDOWNEXCEL:      //excel		
			  			ComOpenWait(true);			
						formObj.f_cmd.value=SEARCH03; 
						var sXml=sheetObjects[2].GetSearchData("ESM_PRI_0002_03GS.do", FormQueryString(formObj) );
						if(sXml.length>0){
							sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
							sheetObjects[2].Down2Excel({DownCols: makeHiddenSkipCol(sheetObjects[2]), SheetDesign:1,Merge:-1 });
						}
						ComOpenWait(false);                					
						break;
	          }
    	  }catch(e){
    			if (e == "[object Error]") {
    				ComShowMessage(OBJECT_ERROR);
    			} else {
    				ComShowMessage(e.message);
    			}
    		}finally {
    			 ComOpenWait(false);
    		}
      }
    /**
     * calling function when occurring OnSelectCell Event <br>
     * calling doRowChange function <br>
     */  	
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
	    doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
	}	
     /**
      * calling function when clicking sheet row <br>
      */
	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj=document.form;
		var adjNewRow=NewRow;
		if (!isFiredNested && (OldRow != NewRow)) {
			formObj.grp_cmdt_seq.value=sheetM.GetCellValue(adjNewRow, "grp_cmdt_seq");
			doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
		}
	}
    /**
    * checking validation process of inputed form data <br>
    */
     function validateForm(sheetObj,formObj,sAction){
  		switch (sAction) {
			case IBSEARCH: // retrieve
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				}
				break;
			case IBSEARCHAPPEND: // retrieve
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				}
				break;				
			case IBDOWNEXCEL: // Excel Download
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
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
    * calling function when clicking radio button <br>
    */ 	
	function obj_click()
	{
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
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}  
    /**
     * setting radio button's font <br>
     * showing bold when data exist <br>
     */ 	     
    function fontChange(){
    	//SHEET ROW COUNT
		var row_count = getValidRowCount(sheetObjects[0]);
    	var formObj=document.form;
		var fontBold="";
    	var eleName="";
    	for (var i=0; i <4; i++){
    		if (formObj.prc_cust_cd[i].checked == true){
    			eleName="cust_tp" + (i+1);
    		}
    	}
 		if (row_count > 0) {
 			fontBold="bold";
 		}    	
    	document.getElementById(eleName).style.fontWeight=fontBold;
    }         
     /**
      * calling function when occurring OnSearchEnd Event <br>
      */
	function sheet1_OnSearchEnd(sheetObj, Code,ErrMsg)
	{
		var formObj=document.form;
		if( sheetObj.SearchRows()> 0){
			document.form.yn_data.value="Y"
		}else{
			document.form.yn_data.value="N"
		}
		/*
		if (formObj.svc_scp_cd.value == "TPW" || formObj.svc_scp_cd.value == "ACE" || formObj.svc_scp_cd.value =="MXW"){
			if (sheetObj.RowCount()<= 0){
				ComBtnEnable("btn_Copy");
			}else{
				ComBtnDisable("btn_Copy");
			}
		}else{
			ComBtnDisable("btn_Copy");
		}
		*/
	}    
    /**
      * button control function <br>
      */
 	function toggleButtons(mode) {
		switch (mode) {
		case "CLEAR":
			ComBtnDisable("btn_Retrieve");
			ComBtnDisable("btn_DownExcel");
			break;
		case "INIT":
			ComBtnEnable("btn_Retrieve");
			ComBtnEnable("btn_DownExcel");
			break;
		case "READONLY":
			ComBtnEnable("btn_Retrieve");
			ComBtnEnable("btn_DownExcel");
			break;
		}
	}     	
    /**
    * calling function when clicking parent's screen tab <br>
    * showing retrieved data<br>
    */ 		    	
 	function tabLoadSheet(sSvcScpCd, sGlineSeq) {
		var formObject=document.form;
		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			formObject.svc_scp_cd.value=sSvcScpCd;
			formObject.gline_seq.value=sGlineSeq;
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC01);
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
			if (enableFlag) {
				toggleButtons("INIT");
			} else {
				toggleButtons("READONLY");
			}				
		}
	}
    /**
    * initializing parent's screen tab control <br>
    */ 	 	 
	function tabClearSheet() {
		var formObject=document.form;
		formObject.svc_scp_cd.value="";
		formObject.gline_seq.value="";
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		toggleButtons("CLEAR");
	}     	 
    /**
     * calling function from main screen <br>
     * prohibiting insert, update, delete in case or Confirmation = YES  <br>
     */ 			
	function tabEnableSheet(flag) {
		var formObject=document.form;
		enableFlag=flag;
		if (enableFlag) {
			toggleButtons("INIT");
		} else {
			toggleButtons("READONLY");
		}		
	}