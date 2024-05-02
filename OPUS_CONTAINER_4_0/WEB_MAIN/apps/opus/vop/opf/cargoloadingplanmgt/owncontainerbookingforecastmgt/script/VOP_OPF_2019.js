/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_opf_2019.jsp
*@FileTitle  : CBF Summary Preview
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
	/* Developer performance	*/
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var IBSEARCH02=30;
	var IBSEARCH03=33;
	var IBSEARCH11=31;
	var IBSEARCH12=32;
	var stwgNmList;	
	var uid;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {	
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {	
				case "btn1_WGC":
					openWgcPopup(formObj);
					break;
				case "btn1_Close":
					ComClosePopup(); 
					break;
			}
		} catch (e) {
			if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
		}
	}
	/** 
	 * in case of clicking Weight Group (Creation) button call pop-up
	 */
	function openWgcPopup(formObj) {
		var vSlanCd=ComGetObjValue(formObj.vsl_slan_cd);
		var vSkdDirCd=ComGetObjValue(formObj.skd_dir_cd);
		var vYdCd=ComGetObjValue(formObj.yd_cd);
		var vPolCd=vYdCd.substr(0, 5);
		sUrl="/opuscntr/VOP_OPF_3019.do?slan_cd=" + vSlanCd + "&skd_dir_cd=" + vSkdDirCd + "&pol_cd=" + vPolCd;
		ComOpenPopupWithTarget(sUrl, 700, 480, "yd_cd:yd_cd", "0,0", true);
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
	 * registering IBTab Object as list
	 * adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
	function setTabObject(tab_obj) {
		tabObjects[tabCnt++]=tab_obj;
	}
	/**
	 * Setting Tab
	 * Set item of Tab
	 */
	function initTab(tabObj, tabNo) {
		switch (tabNo) {
			case 1:
				with (tabObj) {
					var cnt=0;
					InsertItem( "Volume/Weight", "");
					InsertItem( "Special Cargo", "");
				}
				break;	
		}
	}
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage(bkgShprOwnrFlg) {		
		for (var k=0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
		}
		for (var i=0; i < sheetObjects.length-1; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]); 
		}
        if(bkgShprOwnrFlg == 'N') {
        	document.all.cbfIndLayer.style.display="none";
        }
        tabObjects[0].SetSelectedIndex(0);
        t1sheet1_OnLoadFinish(t1sheet1);
        t2sheet1_OnLoadFinish(t2sheet1);
        t2sheet2_OnLoadFinish(t2sheet2);
	}
	/**
     * Sheet1 OnLoadFinish Event 
     * param : sheetObj
     * 
     */
	function t1sheet1_OnLoadFinish(sheetObj) {	
    	doActionIBSheet(sheetObj, document.form, IBSEARCH);
    }
    /**
     * Sheet2 OnLoadFinish Event 
     * param : sheetObj
     * 
     */
	function t2sheet1_OnLoadFinish(sheetObj) {	
 		doActionIBSheet(sheetObj, document.form, IBSEARCH02);
    }
 	/**
     * Sheet3 OnLoadFinish Event 
     * param : sheetObj
     * 
     */
	function t2sheet2_OnLoadFinish(sheetObj) {	
    	ComConfigSheet(sheetObj);
    	initSheet(sheetObj, 3);
		ComEndConfigSheet(sheetObj);
 		doActionIBSheet(sheetObj, document.form, IBSEARCH03);
    }
     /** 
 	 * resize column
 	 */
 	function resizeCols(sheetObj) {
 		with (sheetObj) {
//	 		var startCol  = SaveNameCol("opr1");	 		
//	 		var headColLen = 0, dataColCt = 0;
//	 		for(var colCt=0; colCt<=LastCol; colCt++) {
//	 			if(!ColHidden(colCt)) {
//	 				if(colCt > startCol) {
//	 					dataColCt++;
//	 				} else {
//	 					headColLen += ColWidth(colCt);
//	 				}
//	 			}
//	 		}
//	 		
//	 		var contArea  = SheetWidth - headColLen;
//	 		var divColLen = contArea/dataColCt;
//	 		for(var colCt=startCol+1; colCt<=LastCol; colCt++) {
//	 			if(!ColHidden(colCt)) ColWidth(colCt) = divColLen;
//	 		}
 		}
 	}
	/**
	 * setting sheet initial values and header param : sheetObj, sheetNo
	 * 　 adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo, headTitleList) {
		var cnt=0;
		var sheetID=sheetObj.id;
		var formObj=document.form;
		switch (sheetID) {	
			case "t1sheet1":
			    with(sheetObj){
		        
				      var crrCd=ComGetObjValue(formObj.crr_cd);
				      var HeadTitle1="|  |  |  |  ";
				      HeadTitle1=HeadTitle1 + "|OPR|" + crrCd + "|" + crrCd + "|" + crrCd + "|" + crrCd + "|" + crrCd + "|" + crrCd + "|" + crrCd;
				      HeadTitle1=HeadTitle1 + "|Full Units Av.Weight (Ton)|Full Units Av.Weight (Ton)";
				      var HeadTitle2="|POD >>|MLB  |Weight Group >>|Weight Group >>";
				      HeadTitle2=HeadTitle2 + "|OPR|20'|20HC|40'|40HC|45'|TTL|TEU";
				      HeadTitle2=HeadTitle2 + "|20|40";
				      var headCount=ComCountHeadTitle(HeadTitle1);
		
				      SetConfig( { SearchMode:0, MergeSheet:7, Page:20, DataRowMerge:0 } );
		
				      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"},
				                  { Text:HeadTitle2, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"hdnStauts" },
				             {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:1,   SaveName:"pod",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"mlb",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:104,  Align:"Left",    ColMerge:1,   SaveName:"fm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:70,   Align:"Left",    ColMerge:0,   SaveName:"wg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"opr1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Int",       Hidden:0,  Width:61,   Align:"Right",   ColMerge:0,   SaveName:"opr1_qty_2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Int",       Hidden:0,  Width:61,   Align:"Right",   ColMerge:0,   SaveName:"opr1_qty_2h",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Int",       Hidden:0,  Width:61,   Align:"Right",   ColMerge:0,   SaveName:"opr1_qty_4",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Int",       Hidden:0,  Width:61,   Align:"Right",   ColMerge:0,   SaveName:"opr1_qty_4h",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Int",       Hidden:0,  Width:61,   Align:"Right",   ColMerge:0,   SaveName:"opr1_qty_45",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"tot_ttl",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"opr1_teu",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Float",     Hidden:0,  Width:61,   Align:"Right",   ColMerge:0,   SaveName:"av_wgt_2",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Float",     Hidden:0,  Width:61,   Align:"Right",   ColMerge:0,   SaveName:"av_wgt_4",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1,   InsertEdit:1 } ];
				       
				      InitColumns(cols);
		
				      SetEditable(0);
				      SetSheetHeight(382);
		            }
				break;
			case "t2sheet1":
			    with(sheetObj){		        
			      var crrCd=ComGetObjValue(formObj.crr_cd);
			      var HeadTitle0="|  |  ";
			      HeadTitle0=HeadTitle0 + "|OPR|" + crrCd + "|" + crrCd + "|" + crrCd + "|" + crrCd + "|" + crrCd + "";
			      HeadTitle0=HeadTitle0 + "|" + crrCd + "|" + crrCd + "|" + crrCd + "|" + crrCd + "|" + crrCd + "";
			      HeadTitle0=HeadTitle0 + "|" + crrCd + "|" + crrCd + "|" + crrCd + "|" + crrCd + "";
			      HeadTitle0=HeadTitle0 + "|" + crrCd + "|" + crrCd + "";
			      var HeadTitle1="|  |  ";
			      HeadTitle1=HeadTitle1 + "|OPR|DG|DG|DG|DG|DG";
			      HeadTitle1=HeadTitle1 + "|RF|RF|RF|RF|RF";
			      HeadTitle1=HeadTitle1 + "|AK|AK|AK|AK";
			      HeadTitle1=HeadTitle1 + "|BB|BB";
			      var HeadTitle2="|POD >>|MLB";
			      HeadTitle2=HeadTitle2 + "|OPR|20'|20HC|40'|40HC|45'";
			      HeadTitle2=HeadTitle2 + "|20'|20HC|40'|40HC|45'";
			      HeadTitle2=HeadTitle2 + "|20'|40'|40HC|45'";
			      HeadTitle2=HeadTitle2 + "|20'|40'";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      (headCount, 1, 0, true);
	
			      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
	
			      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
			      var headers = [ { Text:HeadTitle0, Align:"Center"},
			                  { Text:HeadTitle1, Align:"Center"},
			                  { Text:HeadTitle2, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"hdnStauts" },
			             {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:1,   SaveName:"pod",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"mlb",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"opr1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"dg_20_opr1",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"dg_2h_opr1",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"dg_40_opr1",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"dg_4h_opr1",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"dg_45_opr1",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"rf_20_opr1",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"rf_2h_opr1",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"rf_40_opr1",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"rf_4h_opr1",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"rf_45_opr1",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"ak_20_opr1",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"ak_40_opr1",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"ak_4h_opr1",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"ak_45_opr1",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"bb_20_opr1",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"bb_40_opr1",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			       
			      InitColumns(cols);
	
			      SetEditable(0);
			      SetImageList(0,"img/btng_minus.gif");
			      SetImageList(1,"img/btng_plus.gif");
			      SetMergeCell(0, 1, 2, 2);
			      SetSheetHeight(362);
		      	}

				break;
			case "t2sheet2":
			    with(sheetObj){		        
				      var crrCd=ComGetObjValue(formObj.crr_cd);
				      formObj.f_cmd.value=SEARCH16;
				      var headerXml =  sheetObj.GetSearchData("VOP_OPF_2019GS.do", FormQueryString(formObj));
				      var stwgStr=ComGetEtcData(headerXml, "stwgCdList");
				      var stwgList=ComTrim(stwgStr).split("|");
				      var stwgNmCt=0;
				      stwgNmList=new Array();
				      var headTitles=new Array();
				      headTitles[0]="|  |  |OPR";
				      if(ComTrim(stwgStr) != "") {
				    	  headTitles[1]="|  |  |OPR";
				    	  headTitles[2]="|POD >>|MLB|OPR";
				    	  for ( var colCt=0; colCt < stwgList.length; colCt++) {
				    		  var stwgCd=stwgList[colCt].split("+")[1];
				    		  stwgNmList[stwgNmCt++]=stwgList[colCt].split("+")[1]+"+"+stwgList[colCt].split("+")[2];
				    		  headTitles[0] += "|"+crrCd+"|"+crrCd+"|"+crrCd+"|"+crrCd+"|"+crrCd+"";
				    		  headTitles[1] += "|" + stwgCd + "|" + stwgCd + "|" + stwgCd + "|" + stwgCd + "|" + stwgCd;
				    		  headTitles[2] += "|20'|20HC|40'|40HC|45'";
				    		  ComSetObjValue(eval("formObj.st_"+(colCt+1)), stwgCd);
				    	  }
				      } else {
				    	  headTitles[0] += "|"+crrCd+"|"+crrCd+"|"+crrCd+"|"+crrCd+"|"+crrCd+"";
				    	  headTitles[1]="|POD >>|MLB|OPR";
				    	  headTitles[1] += "|20'|20HC|40'|40HC|45'";
				      }
				      var headCount=ComCountHeadTitle(headTitles[0]);
				      
				      var headers = [];
				      var x;
				      for(var headCt=0; headCt<headTitles.length; headCt++) {
				    	 x= {Text:headTitles[headCt], Align:"Center"};
				    	 headers.push(x);
				      }
		
				      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
		
				      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
				      //var headers = [ { Text:headTitles[0], Align:"Center"},{ Text:headTitles[1], Align:"Center"}];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"hdnStauts" },
				             {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:1,   SaveName:"pod",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"mlb",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"opr1",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				      	if(ComTrim(stwgStr) != "") {
				    	  for ( var colCt=1; colCt <= stwgList.length; colCt++) {
					    	  var stwgCd=stwgList[colCt-1];
					    	  cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"st"+colCt+"_20_opr1",KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					    	  cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"st"+colCt+"_2h_opr1",KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					    	  cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"st"+colCt+"_40_opr1",KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					    	  cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"st"+colCt+"_4h_opr1",KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					    	  cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"st"+colCt+"_45_opr1",KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      		}
		      			}else {
					      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"st1_20_opr1",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"st1_2h_opr1",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"st1_40_opr1",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"st1_4h_opr1",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"st1_45_opr1",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		      			}
				      if(ComTrim(stwgStr) != "") {
				    	  SetMergeCell(0, 1, 2, 2);
				      }
				 
				      InitColumns(cols);
				      SetEditable(0);
				      SetSheetHeight(362);
		            }

				break;
		}
	}
	//handling process related Sheet
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSEARCH:		// Volume Summary	
//				sheetObj.RenderSheet(0);
				formObj.f_cmd.value=SEARCH;				
				sheetObj.DoSearch("VOP_OPF_2019GS.do", FormQueryString(formObj) );
				break;
			case IBSEARCH02:	//Special Cargo
				formObj.f_cmd.value=SEARCH02;
				sheetObj.DoSearch("VOP_OPF_2019GS.do", FormQueryString(formObj) );
				break;
			case IBSEARCH03:	//Stowage Request
				formObj.f_cmd.value=SEARCH03;
				sheetObj.DoSearch("VOP_OPF_2019GS.do", FormQueryString(formObj) );
				break;
		}
	}
	/**
	 * expand Sheet1 MLB column
	 * @param sheetObj
	 * @param what
	 */
	function spreadMlbCols(sheetObj) {
		with(sheetObj) {
			var podVal="", mlbVal="", fmVal="", wgVal="";
			var colVal1=GetCellValue(1, "pod");
			var colVal2=GetCellValue(1, "fm");
			var foldYn=false;
			RenderSheet(0);
			if(colVal1.indexOf(">") != -1) {						
				SetCellValue(1,"pod",colVal1.replaceStr(">", "<"),0);
			} else {
				foldYn=true;
				SetCellValue(1,"pod",colVal1.replaceStr("<", ">"),0);
			}	
			SetColHidden("mlb",foldYn);
            if(colVal2.indexOf("<") != -1) {
            	for(var rowCt=HeaderRows(); rowCt<=LastRow(); rowCt++) {
            		podVal=GetCellValue(rowCt, "pod");
            		mlbVal=GetCellValue(rowCt, "mlb");
            		fmVal=GetCellValue(rowCt, "fm");
            		wgVal=GetCellValue(rowCt, "wg");
	            	if (                           mlbVal == "Sub WG"                                       ||	
					   (podVal == "Grand Total" &&                    fmVal == "Empty" && wgVal == "Total")) 	
					{
						SetRowHidden(rowCt,!foldYn);
					}
	            	if ((mlbVal != "Sub WG" && fmVal == "Full"  && wgVal != "Total" && wgVal != "Total Weight") ||	
						(mlbVal != "Sub WG" && fmVal == "Empty" && wgVal != "Total" && wgVal != "Total Weight") || 
						(                      fmVal == "Total"      || fmVal == "Total Weight"               ) ||  
						(                      fmVal == "Full Total" || fmVal == "Empty Total"                ) || 
						(podVal == "Grand Total" &&                     fmVal == "Empty" && wgVal == ""))	       
					{
						SetRowHidden(rowCt,foldYn);
					}
	            	if ((podVal == "Grand Total" && fmVal == "Full"  && wgVal != "Total" && wgVal != "Total Weight")) {	
	            		SetRowHidden(rowCt,0);
	            	}
            	}
            } else {
				for(var rowCt=HeaderRows(); rowCt<=LastRow(); rowCt++) {
					podVal=GetCellValue(rowCt, "pod");
					mlbVal=GetCellValue(rowCt, "mlb");
					fmVal=GetCellValue(rowCt, "fm");
					wgVal=GetCellValue(rowCt, "wg");
                	if ((podVal != "Grand Total" &&                       fmVal == "Full"  && wgVal == "Total") ||
						(podVal != "Grand Total" &&                       fmVal == "Empty" && wgVal == "Total") ||
						(                           mlbVal != ""       && fmVal == "Total"                     ) ||
						(                           mlbVal != ""       && fmVal == "Total Weight"              ))
					{
						SetRowHidden(rowCt,foldYn);
					}
                	if (foldYn && (fmVal == "Total" || fmVal == "Total Weight")) {	
	            		SetRowHidden(rowCt,1);
	            	}
				}	
            }
			RenderSheet(1);
		}
	}
	/**
	 * expand Sheet1 Weight Group column
	 * @param sheetObj
	 * @param what
	 */
	function spreadWGCols(sheetObj) {
		with(sheetObj) {
			var podVal="", mlbVal="", fmVal="", wgVal="";
			var colVal1=GetCellValue(1, "pod");
			var colVal2=GetCellValue(1, "fm");
			var foldYn=false;
			RenderSheet(0);
			if(colVal2.indexOf(">") != -1) {					
				SetCellValue(1,"fm",colVal2.replaceStr(">", "<"),0);
				SetCellValue(1,"wg",colVal2.replaceStr(">", "<"),0);
			} else {
				foldYn=true;
				SetCellValue(1,"fm",colVal2.replaceStr("<", ">"),0);
				SetCellValue(1,"wg",colVal2.replaceStr("<", ">"),0);
			}	
			SetColHidden("wg",foldYn);
			for (var rowCt=HeaderRows(); rowCt<=LastRow(); rowCt++) {
				podVal=GetCellValue(rowCt, "pod");
				mlbVal=GetCellValue(rowCt, "mlb");
				fmVal=GetCellValue(rowCt, "fm");
				wgVal=GetCellValue(rowCt, "wg");
                if(colVal1.indexOf(">") != -1) {	
                	if ((podVal == "Grand Total" && fmVal == "Full" && wgVal == "Total") ||		
                		(                           fmVal == "Full Total"              ) ||		
                		(                           fmVal == "Empty Total"             )) 		
                	{						
						SetRowHidden(rowCt,!foldYn);
					}
					if (                           mlbVal == "Sub WG"                                                                 ||	
					   (podVal == "Grand Total" &&                    fmVal == "Full" && wgVal != "Total" && wgVal != "Total Weight")) 		
					{
						SetRowHidden(rowCt,foldYn);
					}
                } else {							
                	if ((mlbVal != "Sub WG" && fmVal == "Full"  && wgVal == "Total")  ||	
						(mlbVal != "Sub WG" && fmVal == "Empty" && wgVal == "Total"))		
					{
						SetRowHidden(rowCt,!foldYn);
					}
					if ((mlbVal != "Sub WG" && fmVal == "Full"  && wgVal != "Total" && wgVal != "Total Weight") ||	
						(mlbVal != "Sub WG" && fmVal == "Empty" && wgVal != "Total" && wgVal != "Total Weight"))	
					{
						SetRowHidden(rowCt,foldYn);
					}
                }
			}	
			sheetObj.RenderSheet(1);
		}
	}
	/**
	 * t1sheet1_OnMouseDown
	 */
	function t1sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
		with (sheetObj) {
			if(MouseCol()== SaveNameCol("pod") && MouseRow()== (HeaderRows()-1)) {
				spreadMlbCols(sheetObj);
			} else if((MouseCol()== SaveNameCol("fm") || MouseCol()== SaveNameCol("wg")) && MouseRow()== (HeaderRows()-1)) {
				spreadWGCols(sheetObj);
			}
		}
	}
	/**
	 * t2sheet1_OnMouseDown
	 */
	function t2sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {		
		with(sheetObj) {
			if(MouseCol()== SaveNameCol("pod") && MouseRow()== (HeaderRows()-1)) {
				RenderSheet(0);
				var foldYn=false;		
				var colVal=GetCellValue(2, "pod");
				if(colVal.indexOf(">") != -1) {
					SetCellValue(2, "pod",colVal.replaceStr(">", "<"),0);
				} else {
					foldYn=true;
					SetCellValue(2, "pod",colVal.replaceStr("<", ">"),0);
				}
				SetColHidden("mlb",foldYn);
				//fold, unfold by MLB
				for (var checkRow=HeaderRows(); checkRow<=LastRow(); checkRow++) {
					if(SetCellValue(checkRow, "pod") != "G.Total" && GetCellValue(checkRow, "mlb") != "S.Total") GetRowHidden(checkRow,foldYn);
				}
				var subRow=FindText("mlb", "S.Total");
				for (var checkRow=subRow; subRow!=-1 && checkRow<=LastRow();) {
					if(foldYn) SetRowBackColor(checkRow++,"#FFFFFF");
					else SetRowBackColor(checkRow++,"#F7E1EC");
					subRow=FindText("mlb", "S.Total", checkRow);
					if(subRow != -1) {
						checkRow=subRow;
					} else {
						checkRow=LastRow()+1;
					}
				}
				RenderSheet(1);
			}
		}
	}
	/**
	 * t2sheet2_OnMouseDown
	 */
	function t2sheet2_OnMouseDown(sheetObj, Button, Shift, X, Y) {
		with (sheetObj) {
			if(MouseCol()== SaveNameCol("pod") && MouseRow()== (HeaderRows()-1)) {
				RenderSheet(0);
				var foldYn=false;		
				var colVal=GetCellValue(HeaderRows()-1, "pod");
				if(colVal.indexOf(">") != -1) {
					SetCellValue(HeaderRows()-1, "pod",colVal.replaceStr(">", "<"),0);
				} else {
					foldYn=true;
					SetCellValue(HeaderRows()-1, "pod",colVal.replaceStr("<", ">"),0);
				}
				SetColHidden("mlb",foldYn);
				//fold, unfold by MLB
				for (var checkRow=HeaderRows(); checkRow<=LastRow(); checkRow++) {
					if(SetCellValue(checkRow, "pod") != "G.Total" && GetCellValue(checkRow, "mlb") != "S.Total") GetRowHidden(checkRow,foldYn);
				}
				var subRow=FindText("mlb", "S.Total");
				for (var checkRow=subRow; subRow!=-1 && checkRow<=LastRow();) {
					if(foldYn) SetRowBackColor(checkRow++,"#FFFFFF");
					else SetRowBackColor(checkRow++,"#F7E1EC");
					subRow=FindText("mlb", "S.Total", checkRow);
					if(subRow != -1) {
						checkRow=subRow;
					} else {
						checkRow=LastRow()+1;
					}
				}
				RenderSheet(1);
			}
		}
	}
	/**
     * Sheet1 OnMouseMove Event 
     * param : sheetObj
     * 
     */
    function t1sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) { 
    	with (sheetObj) {
	     	if (MouseRow()== (HeaderRows()-1) && (MouseCol()== SaveNameCol("pod") || MouseCol()== SaveNameCol("fm") || MouseCol()== SaveNameCol("wg"))) {
	     		SetMousePointer("Hand");
	     	} else {
	     		SetMousePointer("Default");
	     	}
    	}
    }
    /**
     * Sheet2 OnMouseMove Event 
     * param : sheetObj
     * 
     */
    function t2sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) { 
     	with (sheetObj) {
 	     	if (MouseRow()== (HeaderRows()-1) && MouseCol()== SaveNameCol("pod")) {
 	     		SetMousePointer("Hand");
 	     	} else {
 	     		SetMousePointer("Default");
 	     	}
     	}
    }
    /**
     * Sheet3 OnMouseMove Event 
     * param : sheetObj
     * 
     */
    function t2sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y) { 
     	with (sheetObj) {
 	     	if (MouseRow()== (HeaderRows()-1) && MouseCol()== SaveNameCol("pod")) {
 	     		SetMousePointer("Hand");
 	     	} else {
 	     		SetMousePointer("Default");
 	     	}
 	     	if (MouseRow()== 1 && MouseCol()> SaveNameCol("mlb")) {
  	     		for(var i=0; i<stwgNmList.length; i++) {
  	     			if(GetCellText(MouseRow(), MouseCol()) == stwgNmList[i].split("+")[0]) {
  //no support[check again]CLT 	     				MouseToolTipText=stwgNmList[i].split("+")[1];
  	     				break;
  	     			}
  	     		}
  	     	}
     	}
    }
    /**
     * t1sheet1 OnSelectCell Event 
     * param : sheetObj, OldRow, OldCol, NewRow, NewCol 
     * 
     */
    function t1sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	window.status=sheetObj.GetRowLevel(OldCol);
    }
	/**
	 * In case of clicking Tab event relation
	 * activate element of Tab chosen
	 */
	function tab1_OnChange(tabObj, nItem) {
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		// --------------- important --------------------------//
		for(var i = 0; i<objs.length; i++){
			  if(i != nItem){
			   objs[i].style.display="none";
			   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
			  }
			}
		// ------------------------------------------------------//
		beforetab=nItem;
	}
	/**
	 * handling after retrieving t1sheet1
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {		
		with (sheetObj) {	
			if (RowCount()> 0) {
				var grandRow=FindText("fm", "Grand Total");
				for(var colCt=SaveNameCol("opr1_qty_2"); grandRow!=-1 && colCt<=SaveNameCol("opr1_teu"); colCt++) {
					//if(CellValue(grandRow, colCt) == 0) ColHidden(colCt) = true;
				}
				var subRow=FindText("fm", "Sub Total");
				for (var checkRow=subRow; subRow!=-1 && checkRow<=LastRow();) {
					SetRowBackColor(checkRow++,"#F7E1EC");
					SetRowBackColor(checkRow,"#F7E1EC");
					subRow=FindText("fm", "Sub Total", checkRow);
					if(subRow != -1) {
						checkRow=subRow;
					} else {
						checkRow=LastRow()+1;
					}
				}
				//change color Grand line
				SetRowBackColor(grandRow,"#F7E1EC");
				SetRowBackColor(++grandRow,"#F7E1EC");
				//set basic folded type
				for (var checkRow=HeaderRows(); checkRow<=LastRow(); checkRow++) {
					if (GetCellValue(checkRow, "fm") == "Full Total" || GetCellValue(checkRow, "fm") == "Empty Total" ||
							GetCellValue(checkRow, "fm") == "Sub Total"  || GetCellValue(checkRow, "fm") == "Sub Weight"  ||
							(GetCellValue(checkRow, "pod") == "Grand Total" && GetCellValue(checkRow, "fm") == "Full"  && GetCellValue(checkRow, "wg") == "Total") ||
							(GetCellValue(checkRow, "pod") == "Grand Total" && GetCellValue(checkRow, "fm") == "Empty" && GetCellValue(checkRow, "wg") == "Total") ||
							GetCellValue(checkRow, "fm") == "Grand Total"  || GetCellValue(checkRow, "fm") == "Grand Weight") {
					} else {
						//SetRowHidden(checkRow,1);
					}	
				}
				resizeCols(sheetObj);
			}
			RenderSheet(1);
		}
	}
	/**
	 * set basic folded type
	 */
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with (sheetObj) {
			if (RowCount()> 0) {
				//hide column which is 'G.Total is 0'
				var gRow=FindText("pod", "G.Total");
				for(var colCt=SaveNameCol("dg_20_opr1"); gRow!=-1 && colCt<=SaveNameCol("bb_40_opr1"); colCt++) {
					//if(CellValue(gRow, colCt) == 0) ColHidden(colCt) = true;
				}
				//folded state
				for (var checkRow=HeaderRows(); checkRow<=LastRow(); checkRow++) {
					if(GetCellValue(checkRow, "pod") != "G.Total" && GetCellValue(checkRow, "mlb") != "S.Total"){
						SetRowHidden(checkRow,1);
					}
				}
				//change color G.Total line
				SetRowBackColor(gRow,"#F7E1EC");
			}
		}
	}
	/**
	 * handling after retrieving t2sheet2
	 */
	function t2sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		with (sheetObj) {
			if (RowCount()> 0) {
				//hide column which is 'G.Total is 0'
				var gRow=FindText("pod", "G.Total");
				for(var colCt=SaveNameCol("st1_20_opr1"); gRow!=-1 && colCt<=LastCol(); colCt++) {
					//if(CellValue(gRow, colCt) == 0) ColHidden(colCt) = true;
				}
				//folded state
				for (var checkRow=HeaderRows(); checkRow<=LastRow(); checkRow++) {
					if(SetCellValue(checkRow, "pod") != "G.Total" && GetCellValue(checkRow, "mlb") != "S.Total") GetRowHidden(checkRow,"pod");
				}
				//change color G.Total line
				SetRowBackColor(gRow,"#F7E1EC");
			}
		}
	}
/* Developer performance  end */
