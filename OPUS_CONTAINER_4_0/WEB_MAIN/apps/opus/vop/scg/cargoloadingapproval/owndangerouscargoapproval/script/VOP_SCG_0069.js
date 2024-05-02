/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_0069.jsp
*@FileTitle  : Pre Checking Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/14
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
             MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
             OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*--------------------------------------------------------------------------------------------
 * PopUp modes                                         		popType     opener name
 * ***************                                     		*******     ***********
 * 1. basic(own) : Pre-Checking + Special Request      		N/A            	N/A
 * 2. basic(other) : Pre-Checking                        	"R"        		"partnerDG"
 * 3. retrieve(common) : Pre-Checking                       "R"            	N/A 
 * 4. background1: Pre-Checking + Popup window auto closing "B"            	N/A
 * 5. background2: Pre-Checking + Popup layer auto closing  "B2"           	N/A
 --------------------------------------------------------------------------------------------*/   	
    // common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var chkRslt=0;
    var chkFinish=0;
    var baseHeight=100;//100보다 작으면 min-value error발생
    var rowHeight=24;
    //var opener=window.dialogArguments;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
		var sheetObj1=sheetObjects[0];
		var sheetObj2=sheetObjects[1];
		var sheetObj3=sheetObjects[2];
		var sheetObj4=sheetObjects[3];
        /*******************************************************/
		var formObj=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_Close":
					ComClosePopup(); 
					break;	
				case "btn_Close1":
					ComClosePopup(); 
					break;	
				case "btn_add":
					sheetObj4.DataInsert(-1,0);
					sheetObj4.SelectCell(sheetObj4.GetSelectRow(), "spcl_cntr_seq");
					var cnt = sheetObj4.RowCount()+1;
					sheetObj4.SetSheetHeight((cnt * rowHeight) + baseHeight + (cnt * 2));
					//Control Button of Special Request
					if(sheetObj4.RowCount()== 0) ctlBtnSpRqt(false);
					else ctlBtnSpRqt(true);	
					break;
				case "btn_insert":
					sheetObj4.DataInsert();
					sheetObj4.SelectCell(sheetObj4.GetSelectRow(), "spcl_cntr_seq");
					var cnt = sheetObj4.RowCount()+1;
					sheetObj4.SetSheetHeight((cnt * rowHeight) + baseHeight + (cnt * 2));
					//Control Button of Special Request
					if(sheetObj4.RowCount()== 0) ctlBtnSpRqt(false);
					else ctlBtnSpRqt(true);
					break;
				case "btn_copy":
					sheetObj4.DataCopy();
					var cnt = sheetObj4.RowCount()+1;
					sheetObj4.SetSheetHeight((cnt * rowHeight) + baseHeight + (cnt * 2));
					//Control Button of Special Request
					if(sheetObj4.RowCount()== 0) ctlBtnSpRqt(false);
					else ctlBtnSpRqt(true);
					break;
				case "btn_delete":
					ComRowHideDelete(sheetObj4, "del_chk");
					var cnt = sheetObj4.RowCount()-1;
					sheetObj4.SetSheetHeight((cnt * rowHeight) + baseHeight + (cnt * 2));
					//Control Button of Special Request
					if(sheetObj4.RowCount()== 0) ctlBtnSpRqt(false);
					else ctlBtnSpRqt(true);
					break;
				case "btn_sp_request":
					doActionIBSheet(sheetObj4,formObj,IBSAVE);
					break;
            } 
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
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
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage(popType) {
    	var opener = window.dialogArguments;
    	if (!opener) opener = parent;
    	if(popType == 'B2') opener=parent;
        for(i=0;i<sheetObjects.length;i++){
			//
			ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
			//
            ComEndConfigSheet(sheetObjects[i]);		
        }	
        initControl();
        sheet4_OnLoadFinish(sheet4);
        //other : Special Request / just check : deactivate 
        if(opener.name == 'partnerDG' || popType == 'R') {
        	document.all.spLayer.style.display="none";
        	document.all.spBtnLayer1.style.display="none";
        	document.all.spBtnLayer2.style.display="";
//        	sheetObjects[0].SetSheetHeight(180);
//        	sheetObjects[1].SetSheetHeight(180);
//        	sheetObjects[2].SetSheetHeight(245);
        } else if(popType == 'SR') {
        	document.getElementById("spReq").disabled=true;
        }
        if(popType == 'B') {
        	//ComOpenWait(true, true);
        }
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
    	doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);
        sheetObjects[3].SetEnable(1);
    }
    // event Catch Listener
    function initControl() {
    	// Axon event handling1. event catch
    	axon_event.addListener('click', 'chkClick', 'spReq');
    }
    /**
     * Handling Sheet1 OnLoadFinish Event
     * param : sheetObj ==> sheet object
     * 
     */
    //no support[check again]CLT function sheet1_OnLoadFinish(sheetObj) {	    	
    //}
    /**
     * Handling Sheet2 OnLoadFinish Event
     * param : sheetObj ==> sheet object
     * 
     */
    //no support[check again]CLT function sheet2_OnLoadFinish(sheetObj) {	    	
    //}
    /**
     * Handling Sheet3 OnLoadFinish Event 
     * param : sheetObj ==> sheet object
     * 
     */
    //no support[check again]CLT function sheet3_OnLoadFinish(sheetObj) {	    	
    //}
    /**
     * Handling Sheet4 OnLoadFinish Event
     * param : sheetObj ==> sheet object
     * 
     */
    function sheet4_OnLoadFinish(sheetObj) {	
    	 //Special Request list Display
    	 setDisplaySpList(sheetObj);
    	 sheet4.SetEnable(0);
      	 ComBtnDisable("btn_add");
      	 ComBtnDisable("btn_insert");
      	 ComBtnDisable("btn_copy");
      	 ComBtnDisable("btn_delete");
      	 ComBtnDisable("btn_sp_request");
      	 var cnt = sheetObj.RowCount();
  		 if(cnt > 0) {
  			sheetObj.SetSheetHeight((cnt * rowHeight) + baseHeight + (cnt * 2));
    	 }
    }
    
    //Special Request list Display
    function setDisplaySpList(sheetObj) {
    	
    	//own : Special Request list Display
    	var opener 			= window.dialogArguments;
    	if (!opener) opener = parent;
    	var formObject		= document.form;
    	
    	////:2016-01-27:////if(popType == '' || popType == 'SR') {
    	
    	var isOpenerObj	= false;
    	var isFrom		= "";
    	if(opener.ComFuncCheck("getCgoSheet") == true){
    		isOpenerObj	= true;
    		isFrom		= "OWN";
    	}else if(opener.sheetObjects[1] != null && opener.sheetObjects[1] != undefined){
    		isOpenerObj	= true;
    		isFrom		= "PARTNER";
    	}
    	
    	//alert(opener);
    	//alert(opener.ComFuncCheck("getCgoSheet"));
    	//alert(opener.sheetObjects[1]);
    	//alert('null >>> '+opener.getCgoSheet() == null);
    	//alert('undefined >>> '+opener.getCgoSheet() == null);
    	//alert('isOpenerObj >>> '+isOpenerObj+' <<< --- ['+isFrom+']');
    	
		////:2016-01-28:////if (ComFuncCheck(opener.getCgoSheet())){
 		if (isOpenerObj){
 			
 			var cgoSheetObj;
 			//var cgoSheetObj	= opener.getCgoSheet();
 			
 			if(isFrom == "OWN"){
 				cgoSheetObj	= opener.getCgoSheet();
 			}else if(isFrom == "PARTNER"){
 				cgoSheetObj	= opener.sheetObjects[1];
 			}
 			
 			var spYn, cancelYn, reasonStr;
 			
 			for(var cgoCt=cgoSheetObj.HeaderRows(), spCt=sheetObj.HeaderRows(); cgoCt<=cgoSheetObj.LastRow(); cgoCt++) {
 				spYn		= cgoSheetObj.GetCellValue(cgoCt, "spcl_rqst_flg"	);
 				cancelYn	= cgoSheetObj.GetCellValue(cgoCt, "spcl_cgo_apro_cd");
 				reasonStr	= cgoSheetObj.GetCellValue(cgoCt, "spcl_rqst_desc"	);
 				
 				//alert('outer if ... segregation group ['+cgoSheetObj.GetCellValue(cgoCt, "imdg_segr_grp_no"	)+']     >>> spYn ['+spYn+'] cancelYn ['+cancelYn+'] reasonStr ['+reasonStr+']');
 			
 				if(spYn == 'Y' && cancelYn != 'C' && reasonStr != '') {
 					
 					sheetObj.DataInsert(-1,0);
 					sheetObj.SetCellValue(spCt, "spcl_cntr_seq"	, cgoSheetObj.GetCellValue(cgoCt, "dg_cntr_seq"		),0);
 					sheetObj.SetCellValue(spCt, "spcl_cgo_seq"	, cgoSheetObj.GetCellValue(cgoCt, "cntr_cgo_seq"	),0);
 					sheetObj.SetCellValue(spCt, "imdg_un_no"	, cgoSheetObj.GetCellValue(cgoCt, "imdg_un_no"		),0);
 					sheetObj.SetCellValue(spCt, "imdg_un_no_seq", cgoSheetObj.GetCellValue(cgoCt, "imdg_un_no_seq"	),0);
 					sheetObj.SetCellValue(spCt, "reason"		, cgoSheetObj.GetCellValue(cgoCt, "spcl_rqst_desc"	),0);
 					
 					//alert('segregation group ['+cgoSheetObj.GetCellValue(cgoCt, "imdg_segr_grp_no"	)+']');
 					//sheetObj.SetCellValue(spCt, "reason"		, cgoSheetObj.GetCellValue(cgoCt, "spcl_rqst_desc"	),0);
 					spCt++;
 					
 				}
 					
 			}
 			sheetObj.SelectCell(0,0);
 		}
 		
 		////:2016-01-27:////}
 		
    }
    
    /**
     * Handling Sheet1 OnSearchEnd Event
     * param : sheetObj ==> sheet object, ErrMsg ==> result Message
     * 
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) { 
      	with(sheetObj) {
      		var rsltStr="";
      		var cnt = RowCount();
      		if(cnt > 0) {
      			rsltStr='Load does not comply. Segregation is required between pairs of substances listed below.';
      			chkRslt++;
      			SetSheetHeight((cnt * rowHeight) + baseHeight + (cnt * 2));
      		} 
      		document.getElementById("rsltStr").innerText	= rsltStr;
      	}
      	chkFinish++;
    	setResultChecking();
    }
    
    /**
     * Handling Sheet2 OnSearchEnd Event
     * param : sheetObj ==> sheet object, ErrMsg ==> result Message
     * 
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) { 
    	
    	var sortCols=new Array();
 		sortCols[0]="spcl_cntr_seq";
 		sortCols[1]="spcl_cgo_seq";
 		
 		var sortDirs=new Array();
 		sortDirs[0]="ASC";
 		sortDirs[1]="ASC";
 		//::2015-09-08:by TOP:://sheetObj.ColumnSort(sortCols.join("|"),"ASC",sortDirs.join("|"),true);
 		
 		with(sheetObj) {
 			var cnt = RowCount();
      		if(cnt > 0) {
      			chkRslt++;
      			for(var i=HeaderRows(); i<=LastRow(); i++){
      				SetCellFontColor(i, "prohibition_desc","#FF0000");
    	        }
      			SetSheetHeight((cnt * rowHeight) + baseHeight + (cnt * 2));
      		}
      	}
 		chkFinish++;
    	setResultChecking();
    }
    
    /**
     * Handling Sheet3 OnSearchEnd Event
     * param : sheetObj ==> sheet object, ErrMsg ==> result Message
     * 
     */
    function sheet3_OnSearchEnd(sheetObj, ErrMsg) { 
    	
    	var rslt=0;
    	var rslt1=0;
    	var hRow='';
    	
 
 		
 		
    	with(sheetObj) {
    	   	var seqNo = 0;
     		var rqstSeq1=-1, rqstSeq2=-1;
     		var merge = 1;
	    	for(var i=HeaderRows(); i<=LastRow(); i++){
	    		if (GetCellValue( i, "imdg_cmptn_auth_desc") == "Prohibition" ||
	    				GetCellValue( i, "restriction_req") == "Permit") {
	    			if(GetCellValue( i, "imdg_cmptn_auth_desc") == "Prohibition"){
	    				SetCellFontColor(i, "imdg_cmptn_auth_desc","#FF0000");
	            	}else{
	            		SetCellFontColor(i, "restriction_req","#FF0000");
	            	}
	                 rslt++;
	            }
	    		if (GetCellValue( i, "port_type") == "T/S") {
	            	 hRow=i;
	                 rslt1++;
	            }	 

	    		rqstSeq1 = GetCellValue(i, "port_type")
						+ GetCellValue(i, "port_cd");

	    		if (rqstSeq1 != rqstSeq2) {
				//seqNo++;
				rqstSeq2 = rqstSeq1;
				if (merge > 1) {
					SetMergeCell(i - merge, 1, merge, 1); // BKG ref no.
					SetMergeCell(i - merge, 2, merge, 1); // BKG ref no.
				}
				merge = 1;
	    		} else {
				merge++;
	    		}

	        }
			// 마지막 행 처리
			if (merge > 1) {
				SetMergeCell(i - merge, 1, merge, 1); // 같은 no.행머지
				SetMergeCell(i - merge, 2, merge, 1); // BKG ref no.
			}	    	
	    	
	    	var cnt = RowCount();
      		if(cnt > 0) {
	    		SetSheetHeight((cnt * rowHeight) + baseHeight + (cnt * 2));
	    	}
    	}
    	if(rslt > 0) chkRslt++;
    	if(rslt1 > 1 && sheetObj.SetCellValue( hRow, "imdg_cmptn_auth_desc") == "") sheetObj.GetRowHidden(hRow,1);
    	chkFinish++;
    	setResultChecking();
    }
    /**
     * Handling Sheet1 OnMouseMove Event
     * param : sheetObj ==> sheet object
     * 
     */
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) { 
     	if (sheetObj.MouseCol()== 4 || sheetObj.MouseCol()== 10) {
     	} else {
     	}
    }
    /**
     * Handling sheet4 OnSelectCell Event 
     * param : sheetObj ==> sheet object, NewRow ==> changed Row, NewCol ==> changed Col
     * 
     */
    var lockKey=false;
    function sheet4_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
    	with(sheetObj) {
    		if(OldRow >= HeaderRows()) {
    			Value=GetCellValue(OldRow, OldCol);
				if(ColSaveName(OldCol) == "spcl_cntr_seq") {
					if(Value == '') {
		     			SetCellValue(OldRow, "spcl_cgo_seq","",0);
		     			SetCellValue(OldRow, "imdg_un_no","",0);
		     			SetCellValue(OldRow, "imdg_un_no_seq","",0);
					} else if(Value != '' && !filterUnNo(Value, GetCellValue(OldRow, "spcl_cgo_seq"), GetCellValue(OldRow, "imdg_un_no"), GetCellValue(OldRow, "imdg_un_no_seq"), "self", OldRow)) {
		     			lockKey=true;
		     			ComShowCodeMessage('SCG50010', 'Data');	//'{?msg1} is invalid.'
						SetCellValue(OldRow, "spcl_cntr_seq","",0);
						SetCellValue(OldRow, "spcl_cgo_seq","",0);
		     			SetCellValue(OldRow, "imdg_un_no","",0);
		     			SetCellValue(OldRow, "imdg_un_no_seq","",0);
						SelectCell(OldRow, "spcl_cntr_seq");
		     		}
				} else if(ColSaveName(OldCol) == "spcl_cgo_seq") {
					if(Value == '') {
		     			SetCellValue(OldRow, "imdg_un_no","",0);
		     			SetCellValue(OldRow, "imdg_un_no_seq","",0);
		     		} else if(Value != '') {
		     			if(GetCellValue(OldRow, "spcl_cntr_seq") != '') {
		     				if(!filterUnNo(GetCellValue(OldRow, "spcl_cntr_seq"), Value, GetCellValue(OldRow, "imdg_un_no"), GetCellValue(OldRow, "imdg_un_no_seq"), "self", OldRow)) {
				     			lockKey=true;
				     			ComShowCodeMessage('SCG50010', 'Data');	//'{?msg1} is invalid.'
								SetCellValue(OldRow, "spcl_cgo_seq","",0);
				     			SetCellValue(OldRow, "imdg_un_no","",0);
				     			SetCellValue(OldRow, "imdg_un_no_seq","",0);
								SelectCell(OldRow, "spcl_cgo_seq");
			     			}
		     			} else {
		     				ComShowCodeMessage('SCG50007', 'CNTR');	//'Please input {?msg1}.'
		     				SetCellValue(OldRow, "spcl_cgo_seq","",0);
		     				SelectCell(OldRow, "spcl_cntr_seq");
		     			}
		     		}
				} else if(ColSaveName(OldCol) == "imdg_un_no") {
					if(Value == '') {
		     			SetCellValue(OldRow, "imdg_un_no_seq","",0);
		     		} else if(Value != '') {
		     			if(GetCellValue(OldRow, "spcl_cgo_seq") != '') {
		     				if(!filterUnNo(GetCellValue(OldRow, "spcl_cntr_seq"), GetCellValue(OldRow, "spcl_cgo_seq"), Value, GetCellValue(OldRow, "imdg_un_no_seq"), "self", OldRow)) {
				     			lockKey=true;
				     			ComShowCodeMessage('SCG50010', 'Data');	//'{?msg1} is invalid.'
								SetCellValue(OldRow, "imdg_un_no","",0);
				     			SetCellValue(OldRow, "imdg_un_no_seq","",0);
								SelectCell(OldRow, "imdg_un_no");
			     			}
		     			} else {
		     				var chkCell="spcl_cgo_seq", chkMsg="CGO";
		     				if(GetCellValue(OldRow, "spcl_cntr_seq") == '') {
		     					chkCell="spcl_cntr_seq";
		     					chkMsg="CNTR";
		     				}
		     				ComShowCodeMessage('SCG50007', chkMsg);	//'Please input {?msg1}.'
		     				SetCellValue(OldRow, "imdg_un_no","",0);
		     				SelectCell(OldRow, chkCell);
		     			}
		     		}
		     	} else if(ColSaveName(OldCol) == "imdg_un_no_seq") {
		     		if(Value != '') {
		     			if(GetCellValue(OldRow, "imdg_un_no") != '') {
		     				if(!filterUnNo(GetCellValue(OldRow, "spcl_cntr_seq"), GetCellValue(OldRow, "spcl_cgo_seq"), GetCellValue(OldRow, "imdg_un_no"), Value, "self", OldRow)) {
				     			lockKey=true;
				     			ComShowCodeMessage('SCG50010', 'Data');	//'{?msg1} is invalid.'
								SetCellValue(OldRow, "imdg_un_no_seq","",0);
								SelectCell(OldRow, "imdg_un_no_seq");
			     			}
		     			} else {
		     				var chkCell="imdg_un_no", chkMsg="UN No.";
		     				if(GetCellValue(OldRow, "spcl_cgo_seq") == '') {
		     					chkCell="spcl_cgo_seq";
		     					chkMsg="CGO";
		     					if(GetCellValue(OldRow, "spcl_cntr_seq") == '') {
			     					chkCell="spcl_cntr_seq";
			     					chkMsg="CNTR";
			     				}
		     				}
		     				ComShowCodeMessage('SCG50007', chkMsg);	//'Please input {?msg1}'
		     				SetCellValue(OldRow, "imdg_un_no_seq","",0);
		     				SelectCell(OldRow, chkCell);
		     			}
		     		}
		     	}
    		}
		}
    }
    /**
     * Handling sheet4 OnKeyUp Event
     * param : sheetObj ==> sheet object, selected Row ==> Row, selected Col ==> Col
     * 
     */
    function sheet4_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
    	with(sheetObj) { 
			var len=GetEditText().length;
			if(!lockKey) {
				if(ColSaveName(Col) == "imdg_un_no") {
					if(len == 4) {
						//SelectCell(Row, "imdg_un_no_seq");
					}
				} else if(ColSaveName(Col) == "imdg_un_no_seq") {
					if(len == 4) {
						//SelectCell(Row, "reason");
					}
				}
			} else {
				lockKey=false;
			}
 		}
    }
	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt	= 0;
        
        switch(sheetObj.id) {
			case "sheet1":      //sheet1 init
			    with(sheetObj){
					var HeadTitle1="Sequence|Sequence|UN No. Seq||SG|Conflicts with|Sequence|Sequence|UN No. Seq||SG";
					var HeadTitle2="CNTR|CGO|||SG|Conflicts with|CNTR|CGO|||SG";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );

					var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cntr_seq1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_seq1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no_seq1",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"imdg_segr_grp_no1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:456,  Align:"Left",    ColMerge:1,   SaveName:"conflict_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, Wrap:1, MultiLineText:1},
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cntr_seq2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_seq2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no_seq2",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"imdg_segr_grp_no2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
					InitColumns(cols);
					SetSheetHeight(140);
					SetEditable(0);
					SetEditableColorDiff(0);
		            SetHeaderRowHeight(20);
		            SetDataRowHeight(rowHeight);
		            SetToolTipText(4, "imdg_segr_grp_no1","Segregation Group");
		            SetMergeCell(0, 2, 2, 2);
		            SetMergeCell(0, 8, 2, 2);
		            SetRangeBackColor(1,0,1,1,"#555555");
		            SetRangeBackColor(1,5,1,7,"#555555");
		      	}
                break;
                
			case "sheet2":      //sheet2 init
			    with(sheetObj){
					var HeadTitle1="Sequence|Sequence|UN No. Seq||VVD CD|Vessel\nOperator|Prohibition on|";
					var HeadTitle2="CNTR|CGO|||VVD CD|Vessel\nOperator|Prohibition on|";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
					
					var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cntr_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"crr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"prohibition_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, Wrap:1, MultiLineText:1},
		             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"chk_type",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
					InitColumns(cols);
					SetSheetHeight(140);
					SetEditable(0);
					SetEditableColorDiff(0);
		            SetHeaderRowHeight(20);
		            SetDataRowHeight(rowHeight);
		            SetMergeCell(0, 2, 2, 2);
		            SetRangeBackColor(1,0,1,1,"#555555");
		      	}
                break;
                
			case "sheet3":      //sheet3 init
			    with(sheetObj){
				var HeadTitle1="No.|Type|Port Code|Seq|Prohibition/Restriction|Restriction Required|Explanation|Sequence|Sequence|UN No. Seq|UN No. Seq";
				var HeadTitle2="No.|Type|Port Code|Seq|Prohibition/Restriction|Restriction Required|Explanation|CNTR|CGO|UN No. Seq|UN No. Seq";
				var headCount=ComCountHeadTitle(HeadTitle1);
				
				////::2015-01-27:by TOP::////SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
				
				var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"},
	                  { Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ 
				 {Type:"Seq",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seqNo",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },            
				 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"port_type",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  	Width:70,   Align:"Center"	,  ColMerge:1,   SaveName:"port_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, 	Width:30,   Align:"Center"	,  ColMerge:0,   SaveName:"seq",                   KeyField:0,   CalcLogic:"|spcl_cntr_seq|+|spcl_cgo_seq|" },
	             {Type:"Text",      Hidden:0,  	Width:140,  Align:"Center"	,  ColMerge:1,   SaveName:"imdg_cmptn_auth_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
	             {Type:"Text",      Hidden:0,  	Width:140,  Align:"Center"	,  ColMerge:1,   SaveName:"restriction_req",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  	Width:316,  Align:"Left"	,  ColMerge:1,   SaveName:"txt_desc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, Wrap:1, MultiLineText:1},
	             {Type:"Text",      Hidden:0,  	Width:40,   Align:"Center"	,  ColMerge:1,   SaveName:"spcl_cntr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  	Width:40,   Align:"Center"	,  ColMerge:1,   SaveName:"spcl_cgo_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  	Width:45,   Align:"Center"	,  ColMerge:1,   SaveName:"imdg_un_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  	Width:45,   Align:"Center"	,  ColMerge:1,   SaveName:"imdg_un_no_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	       
				InitColumns(cols);
				SetSheetHeight(200);
				SetEditable(0);
				SetHeaderRowHeight(20);
				SetDataRowHeight(rowHeight);
	            SetMergeCell(0, 9, 2, 2);
	            SetRangeBackColor(1,6,1,8,"#555555");
	      		}
                break;
                
			case "sheet4":
			    with(sheetObj){
		        	//keyFieldYn=true;

		        	var HeadTitle1="|Sel|Sequence|Sequence|UN No. Seq|UN No. Seq|Reason";
		        	var HeadTitle2="|Sel|CNTR|CGO|UN No. Seq|UN No. Seq|Reason";
		        	var headCount=ComCountHeadTitle(HeadTitle1);
		        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0, KeyFieldPosition:"Right" } );

		        	var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		        	var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
		        	InitHeaders(headers, info);

		        	var cols = [ 
		        	 {Type:"Status",    Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cntr_seq",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   AcceptKeys:"N" },
		             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_seq",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   AcceptKeys:"N" },
		             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4, AcceptKeys:"N" },
		             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no_seq",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4, AcceptKeys:"N" },
		             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"reason",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, Wrap:1, MultiLineText:1} ];
		       
		        	InitColumns(cols);
		        	SetSheetHeight(140);

		        	SetEditable(1);		
		        	SetDataRowHeight(rowHeight);
		            
		        	//SetKeyFieldImage("/opuscntr/img/opus/ico_star.gif");
		        	///opuscntr/img/ico_star.gif //sheetObjects[3].SetKeyFieldImage("/opuscntr/img/ico_star.gif");
		            
		        	SetMergeCell(0, 4, 2, 2);
		            SetRangeBackColor(1,1,1,3,"#555555");
		      	}
                break;   
                
			case "sheet5":    
			    with(sheetObj){

		        	var HeadTitle1="|Sel|Sequence|Sequence|UN No. Seq|UN No. Seq|Reason";
		        	var HeadTitle2="|Sel|CNTR|CGO|UN No. Seq|UN No. Seq|Reason";
		        	var headCount=ComCountHeadTitle(HeadTitle1);
		        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0, KeyFieldPosition:"Right" } );

		        	var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		        	var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
		        	InitHeaders(headers, info);

		        	var cols = [ 
		        	 {Type:"Status",    Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cntr_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   AcceptKeys:"N" },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   AcceptKeys:"N" },
		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4, AcceptKeys:"N" },
		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4, AcceptKeys:"N" },
		             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"reason",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, Wrap:1, MultiLineText:1} ];
		       
		        	InitColumns(cols);
		        	//SetSheetHeight(140);
		        	SetVisible(0);

		        	SetEditable(1);		
		        	SetDataRowHeight(rowHeight);
		            SetKeyFieldImage("/opuscntr/img/blank.gif");
		            SetMergeCell(0, 4, 2, 2);
		            SetRangeBackColor(1,1,1,3,"#555555");
		      	}
                break;       
                
        }
    }
    
    //Special Request Check Box Click
    function chkClick() {
    	var evtObj = ComGetEvent();
     	if(evtObj.checked) {
     		//sheetObjects[3].RemoveAll();
     		sheetObjects[3].SetKeyFieldImage("/opuscntr/img/ico_star.gif");
     		document.getElementById("spReqStr").innerHTML='* Please review checking  result again. If you still want to proceed booking, please check the <strong>"Checkbox"</strong> and enter a valid<p>   reason in the  <strong>"Reason for Special Request"</strong> then click <strong>"Special Request"</strong> button.';    		
//     		document.getElementById("spReqStr").value='* Please review checking  result again. If you still want to proceed booking, please check the <strong>"Checkbox"</strong> and enter a valid reason in the  <strong>"Reason for Special Request"</strong> then click <strong>"Special Request"</strong> button.';
     		sheetObjects[3].SetEnable(1);
     		ComBtnEnable("btn_add");
     		ComBtnEnable("btn_insert");
     		ComBtnEnable("btn_copy");
     		ComBtnEnable("btn_delete");
     		//Control Button of Special Request
			if(sheetObjects[3].RowCount()== 0) ctlBtnSpRqt(false);
			else ctlBtnSpRqt(true);	
			
     	} else {
     		document.getElementById("spReqStr").innerHTML="&nbsp;";
     		sheetObjects[3].RemoveAll();
     		sheetObjects[3].SetKeyFieldImage("/opuscntr/img/blank.gif");
     		//Special Request list Display
     		setDisplaySpList(sheetObjects[3]);
     		sheetObjects[3].SetEnable(0);
     		ComBtnDisable("btn_add");
          	ComBtnDisable("btn_insert");
          	ComBtnDisable("btn_copy");
          	ComBtnDisable("btn_delete");
          	ctlBtnSpRqt(false);	//Control Button of Special Request
     	}
    }
    
    //Control Button of Special Request
    function ctlBtnSpRqt(flg) {
    	if(flg) ComBtnEnable("btn_sp_request");
    	else ComBtnDisable("btn_sp_request");
    }
    
    //UN No. Validation
    function filterUnNo(spcl_cntr_seq, spcl_cgo_seq, un_no, un_no_seq, type, row) {
    	var sheetObj1=sheetObjects[0];
		var sheetObj2=sheetObjects[1];
		var sheetObj3=sheetObjects[2];
		var sheetObj4=sheetObjects[3];
		var sheetCntrSeq, sheetCgoSeq, sheetUnNo, sheetUnNoSeq;			
    	for(var idx1=sheetObj1.HeaderRows(); idx1<=sheetObj1.LastRow(); idx1++) {
    		sheetCntrSeq=sheetObj1.GetCellValue(idx1, "spcl_cntr_seq1");
    		sheetCgoSeq=sheetObj1.GetCellValue(idx1, "spcl_cgo_seq1");
    		sheetUnNo=sheetObj1.GetCellValue(idx1, "imdg_un_no1");
    		sheetUnNoSeq=sheetObj1.GetCellValue(idx1, "imdg_un_no_seq1");
    		if(checkUnNo(spcl_cntr_seq, spcl_cgo_seq, un_no, un_no_seq, sheetCntrSeq, sheetCgoSeq, sheetUnNo, sheetUnNoSeq, type)) {
    			if(type == 'self' && spcl_cntr_seq != '' && spcl_cgo_seq != '') {
    				sheetObj4.SetCellValue(row, "imdg_un_no",sheetObj1.GetCellValue(idx1, "imdg_un_no1"),0);
    				sheetObj4.SetCellValue(row, "imdg_un_no_seq",sheetObj1.GetCellValue(idx1, "imdg_un_no_seq1"),0);
    			}
    			return true;
    		}
    		sheetCntrSeq=sheetObj1.GetCellValue(idx1, "spcl_cntr_seq2");
    		sheetCgoSeq=sheetObj1.GetCellValue(idx1, "spcl_cgo_seq2");
    		sheetUnNo=sheetObj1.GetCellValue(idx1, "imdg_un_no2");
    		sheetUnNoSeq=sheetObj1.GetCellValue(idx1, "imdg_un_no_seq2");
    		if(checkUnNo(spcl_cntr_seq, spcl_cgo_seq, un_no, un_no_seq, sheetCntrSeq, sheetCgoSeq, sheetUnNo, sheetUnNoSeq, type)) {
    			if(type == 'self' && spcl_cntr_seq != '' && spcl_cgo_seq != '') {
    				sheetObj4.SetCellValue(row, "imdg_un_no",sheetObj1.GetCellValue(idx1, "imdg_un_no2"),0);
    				sheetObj4.SetCellValue(row, "imdg_un_no_seq",sheetObj1.GetCellValue(idx1, "imdg_un_no_seq2"),0);
    			}
    			return true;
    		}
    	}
    	for(var idx2=sheetObj2.HeaderRows(); idx2<=sheetObj2.LastRow(); idx2++) {
    		sheetCntrSeq=sheetObj2.GetCellValue(idx2, "spcl_cntr_seq");
    		sheetCgoSeq=sheetObj2.GetCellValue(idx2, "spcl_cgo_seq");
    		sheetUnNo=sheetObj2.GetCellValue(idx2, "imdg_un_no");
    		sheetUnNoSeq=sheetObj2.GetCellValue(idx2, "imdg_un_no_seq");
    		if(checkUnNo(spcl_cntr_seq, spcl_cgo_seq, un_no, un_no_seq, sheetCntrSeq, sheetCgoSeq, sheetUnNo, sheetUnNoSeq, type)) {
    			if(type == 'self' && spcl_cntr_seq != '' && spcl_cgo_seq != '') {
    				sheetObj4.SetCellValue(row, "imdg_un_no",sheetObj2.GetCellValue(idx2, "imdg_un_no"),0);
    				sheetObj4.SetCellValue(row, "imdg_un_no_seq",sheetObj2.GetCellValue(idx2, "imdg_un_no_seq"),0);
    			}
    			return true;
    		}
    	}
    	for(var idx3=sheetObj3.HeaderRows(); idx3<=sheetObj3.LastRow(); idx3++) {
    		sheetCntrSeq=sheetObj3.GetCellValue(idx3, "spcl_cntr_seq");
    		sheetCgoSeq=sheetObj3.GetCellValue(idx3, "spcl_cgo_seq");
    		sheetUnNo=sheetObj3.GetCellValue(idx3, "imdg_un_no");
    		sheetUnNoSeq=sheetObj3.GetCellValue(idx3, "imdg_un_no_seq");
    		if(checkUnNo(spcl_cntr_seq, spcl_cgo_seq, un_no, un_no_seq, sheetCntrSeq, sheetCgoSeq, sheetUnNo, sheetUnNoSeq, type)) {
    			if(type == 'self' && spcl_cntr_seq != '' && spcl_cgo_seq != '') {
    				sheetObj4.SetCellValue(row, "imdg_un_no",sheetObj3.GetCellValue(idx3, "imdg_un_no"),0);
    				sheetObj4.SetCellValue(row, "imdg_un_no_seq",sheetObj3.GetCellValue(idx3, "imdg_un_no_seq"),0);
    			}
    			return true;
    		}
    	}
    	return false;
    }
    //UN No. Validation
    function checkUnNo(spcl_cntr_seq, spcl_cgo_seq, un_no, un_no_seq, sheetCntrSeq, sheetCgoSeq, sheetUnNo, sheetUnNoSeq, type) {
    	if(spcl_cntr_seq == sheetCntrSeq) {
			if(spcl_cgo_seq != '' || type == 'all') {
				if(spcl_cgo_seq == sheetCgoSeq) {
					if(un_no != '' || type == 'all') {
			    		if(un_no == sheetUnNo) {
			    			if(un_no_seq != '' || type == 'all') {
			    				if(un_no_seq == sheetUnNoSeq) return true;
			    			} else {
			    				return true;
			    			}
			    		}
					} else {
						return true;
					}
				}
			} else {
				return true;
			}
		}
    	return false;
    }
    //Result Setter
    function setResultChecking() {
		if(chkFinish == 3) {
			var chkStr="N";
			if(chkRslt == 0) {
				chkStr="Y";
				if(popType == '') document.getElementById("spReq").disabled=true;
			} else if(chkRslt > 0) {
				chkStr="P";
				setCheckingList();	//Set checking list
			}
			var opener = window.dialogArguments;
			if (!opener) opener = parent;
			opener.setPreChkRslt(chkStr);
			if(popType == 'B') {
				ComOpenWait(false);
				window.returnValue=chkStr;
				ComClosePopup(); 
			} else if(popType == 'B2') {
				opener.closeProgressPop();
			}
		}
    }
    //Set checking list
    function setCheckingList() {
    	var stgSheetObj=sheetObjects[4];
    	var stgRowCt=stgSheetObj.HeaderRows()-1;
    	var dupRow=-1;
    	var sheetPrefix="";
    	for(var sheetCt=0; sheetCt<3; sheetCt++) {
	    	with(sheetObjects[sheetCt]) {
	    		if(RowCount()!= 0) {
		    		if(sheetCt == 0) sheetPrefix="1"; 
		    		else sheetPrefix="";
			    	for(var rowCt=HeaderRows(); rowCt<=LastRow(); rowCt++) {
			    		if(GetCellValue(rowCt, "imdg_un_no"+sheetPrefix) != '') {
				    		stgSheetObj.DataInsert(-1,0);stgRowCt++;
				    		stgSheetObj.SetCellValue(stgRowCt, "spcl_cntr_seq",GetCellValue(rowCt, "spcl_cntr_seq"+sheetPrefix),0);
				    		stgSheetObj.SetCellValue(stgRowCt, "spcl_cgo_seq",GetCellValue(rowCt, "spcl_cgo_seq"+sheetPrefix),0);
				    		stgSheetObj.SetCellValue(stgRowCt, "imdg_un_no",GetCellValue(rowCt, "imdg_un_no"+sheetPrefix),0);
				    		stgSheetObj.SetCellValue(stgRowCt, "imdg_un_no_seq",GetCellValue(rowCt, "imdg_un_no_seq"+sheetPrefix),0);
				    		dupRow=stgSheetObj.ColValueDup("spcl_cntr_seq|spcl_cgo_seq|imdg_un_no|imdg_un_no_seq");
				    		if(dupRow != -1) {
				    			stgSheetObj.RowDelete(stgRowCt, false);
				    			stgRowCt--;
				    		}
			    		}
			    		if(sheetCt == 0) {
			    			if(GetCellValue(rowCt, "imdg_un_no2") != '') {
					    		stgSheetObj.DataInsert(-1,0);stgRowCt++;
					    		stgSheetObj.SetCellValue(stgRowCt, "spcl_cntr_seq",GetCellValue(rowCt, "spcl_cntr_seq2"),0);
					    		stgSheetObj.SetCellValue(stgRowCt, "spcl_cgo_seq",GetCellValue(rowCt, "spcl_cgo_seq2"),0);
					    		stgSheetObj.SetCellValue(stgRowCt, "imdg_un_no",GetCellValue(rowCt, "imdg_un_no2"),0);
					    		stgSheetObj.SetCellValue(stgRowCt, "imdg_un_no_seq",GetCellValue(rowCt, "imdg_un_no_seq2"),0);
					    		dupRow=stgSheetObj.ColValueDup("spcl_cntr_seq|spcl_cgo_seq|imdg_un_no|imdg_un_no_seq");
					    		if(dupRow != -1) {
					    			stgSheetObj.RowDelete(stgRowCt, false);
					    			stgRowCt--;
					    		}
			    			}
			    		}
			    	}
	    		}
	    	}
    	}
    }
    
	// Sheet related process handling
    function doActionIBSheet(sheetObj, formObj, sAction) {
    	
        //sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        
			case IBSEARCH:      //retrieve
				/*------------------------------------------------------------------------------
				 * Parameter's naming (see makePreChkParam())
				 *******************************************************************************
				 * spcl_cntr_seq
				 * spcl_cgo_seq
				 * imdg_un_no
				 * imdg_un_no_seq
				 * imdg_clss_cd
				 * bkg_no
				 * pol_cd
				 * pod_cd
				 * vsl_cd
				 * skd_voy_no
				 * skd_dir_cd
				 * slan_cd
				 * imdg_lmt_qty_flg
				 * imdg_expt_qty_flg
				 * crr_cd
				 ------------------------------------------------------------------------------*/
			   	var opener = window.dialogArguments;
				if (!opener) opener = window.opener;
				if (!opener) opener = parent;
				var sParam			= opener.makePreChkParam();
				var formParams		= "";
				
				//alert('makePreChkParam   >>>>   [ '+sParam+' ]   <<< ');
				
				if ("sheet1" == sheetObj.id) {
					formObj.f_cmd.value	= SEARCH01;
					formParams			= "f_cmd="+ComGetObjValue(formObj.f_cmd)+"&pagerows="+ComGetObjValue(formObj.pagerows);
					sheetObj.DoSearch	("VOP_SCG_0069GS.do", formParams+"&"+sParam );
				}
				
				if ("sheet2" == sheetObj.id) {
					formObj.f_cmd.value	= SEARCH02;
					formParams			= "f_cmd="+ComGetObjValue(formObj.f_cmd)+"&pagerows="+ComGetObjValue(formObj.pagerows);
					sheetObj.DoSearch	("VOP_SCG_0069GS.do", formParams+"&"+sParam );
				}
				
				if ("sheet3" == sheetObj.id) {
					formObj.f_cmd.value	= SEARCH03;
					formParams			= "f_cmd="+ComGetObjValue(formObj.f_cmd)+"&pagerows="+ComGetObjValue(formObj.pagerows);
					sheetObj.DoSearch	("VOP_SCG_0069GS.do", formParams+"&"+sParam );
				}
				
            	break;
            	
			case IBSAVE:
				var opener = window.dialogArguments;
				if (!opener) opener = parent;
				//save(Special Request)
				if(validateForm(sheetObj,formObj,sAction)) {
					var returnSheetObj=makeSpReuqest(sheetObj);
					if(returnSheetObj != null) {
						opener.spRequest(returnSheetObj);
						ComClosePopup(); 
					}
				}
				break;
        }
    }
    
	//Request Special Cargo
    function makeSpReuqest(sheetObj) {
    	var stgSheetObj=sheetObjects[4];    	
    	with(stgSheetObj) {
    		if(RowCount()== 0) return null;
	    	for(var rowCt1=HeaderRows(); rowCt1<=LastRow(); rowCt1++) {
	    		for(var rowCt2=sheetObj.HeaderRows(); rowCt2<=sheetObj.LastRow(); rowCt2++) {
	    			if(GetCellValue(rowCt1, "spcl_cntr_seq") == sheetObj.GetCellValue(rowCt2, "spcl_cntr_seq")
	    					&& GetCellValue(rowCt1, "spcl_cgo_seq") == sheetObj.GetCellValue(rowCt2, "spcl_cgo_seq")
	    					&& GetCellValue(rowCt1, "imdg_un_no") == sheetObj.GetCellValue(rowCt2, "imdg_un_no")
	    					&& GetCellValue(rowCt1, "imdg_un_no_seq") == sheetObj.GetCellValue(rowCt2, "imdg_un_no_seq")
		    		  ) 
		    		{
	    				SetCellValue(rowCt1, "reason",sheetObj.GetCellValue(rowCt2, "reason"),0);
		    		}
		    	}
	    	}
    	}
    	return stgSheetObj;
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj, formObj, sAction) {
    	//1. compulsory check
    	if(ComGetSaveString(sheetObj)=="") return false;
    	//2. adjunstment check
    	var spcl_cntr_seq, spcl_cgo_seq, un_no, un_no_seq;	
        with(sheetObj){
        	for(var rowIdx=HeaderRows(); rowIdx<=LastRow(); rowIdx++) {
        		spcl_cntr_seq=sheetObj.GetCellValue(rowIdx, "spcl_cntr_seq");
        		spcl_cgo_seq=sheetObj.GetCellValue(rowIdx, "spcl_cgo_seq");
        		un_no=sheetObj.GetCellValue(rowIdx, "imdg_un_no");
        		un_no_seq=sheetObj.GetCellValue(rowIdx, "imdg_un_no_seq");
        		if(!filterUnNo(spcl_cntr_seq, spcl_cgo_seq, un_no, un_no_seq, "all", rowIdx)) {
        			ComShowCodeMessage('SCG50010', 'Data');	//'{?msg1} is invalid.'
					SelectCell(rowIdx, "spcl_cntr_seq");
					return false;
        		}
        	}
        }
		return true;
	}