/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0668_08.js
*@FileTitle  : In-bound C/S Screen US
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var sheetObjects=new Array();
    var sheetCnt=0;
    var t5sheet1_num=0;
    var t5sheet2_num=1;
    var t5sheet3_num=2;
    var t5sheet4_num=3;
    var comboFlg=null;
    var cntrQtySum=0;
    var chgFlag=null;
    var frt_term_cd=null;
    var t6previewSheet=1;
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
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
		if (document.form.bkg_no.value != "") {
			fnSearch();
		}
    }
     /**
      * setting sheet initial values and header
      * @param sheetObj
      * @param sheetNo
      * @return
      */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "t5sheet1":      //t5sheet1 init
            	with(sheetObj){
	              var HeadTitle="|Seq.|Container No.|TP/SZ|Bound|S/O\nRequire|S/O\nIssued|POD|DEL|Delivery\nTerm|Last S/O Status";
	              var prefix="t5sheet1_";
	
	              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	              var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_tpsz_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bnd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"req_cnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"iss_cnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"de_term_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	               
	              InitColumns(cols);
	
	              SetEditable(1);
	              SetCountPosition(0);
	              SetSheetHeight(140);
                }


				break;
            case "t5sheet2":      //t5sheet2 init
                with(sheetObj){
	             var HeadTitle="|TP/SZ|CNTR Q'ty|Hidden\nColumn";
	             prefix="t5sheet2_";
	
	             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	             var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	             var headers = [ { Text:HeadTitle, Align:"Center"} ];
	             InitHeaders(headers, info);
	
	             var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_tpsz_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_qty",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"hidden",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 } ];
	              
	             InitColumns(cols);
	
	             SetEditable(1);
	             SetCountPosition(0);
	             SetSheetHeight(140);
                      //no support[implemented common]CLT ScrollBar=2;
             }


                break;
        	case "t5sheet3":      //t5sheet3 init
        	    with(sheetObj){
	              var HeadTitle="|Seq.|S/P Code|S/P Name|S/P Tel No|Cost Mode|From-To|S/O Status|Office|User ID|S/O No|S/O Date|W/O No|W/O Date|Container No.";
	              var prefix="t5sheet3_";
	
	              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:8, DataRowMerge:1 } );
	
	              var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag",    Wrap:1 },
	                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq",       Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sp_code",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"sp_name",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sp_tel_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cost_mode", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"nod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"so_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"so_date",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"wo_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"wo_date",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
	               
	              InitColumns(cols);
	
	              SetEditable(1);
	              SetCountPosition(0);
	              SetSheetHeight(220);
                    //no support[check again]CLT 					ToolTipOption="balloon:true;width:320;forecolor:#0000FF;icon:1";
              }


				break;
        	case "t5sheet4":      //t5sheet4 init
        	    with(sheetObj){
	              var HeadTitle="|Seq.|S/P Code|S/P Name|S/P Tel No|Cost Mode|From-To|S/O Status|Office|User ID|S/O No|S/O Date|W/O No|W/O Date|Container No.|User Name";
	              var prefix="t5sheet4_";
	
	              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	              var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sp_code",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sp_name",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sp_tel_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cost_mode", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"nod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"so_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"so_date",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"wo_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"wo_date",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"usr_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	               
	              InitColumns(cols);
	
	              SetEditable(1);
	              SetCountPosition(0);
	              SetVisible(0);
                }


				break;
        }
    }
    /**
     * handling sheet process
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return void
     */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            switch(sAction) {
               case IBSEARCH:      //retrieve
                	ComOpenWait(true);
           			sheetObjects[t5sheet1_num].SetWaitImageVisible(0);
           			formObj.f_cmd.value=SEARCH;
           			var aryPrefix=new Array("t5sheet1_", "t5sheet2_", "t5sheet4_"); //prefix 문자열 배열
                     var sXml=sheetObj.GetSearchData("ESM_BKG_0668_08GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	         		var arrXml=sXml.split("|$$|");
         			//sheetObjects[t5sheet1_num].RenderSheet(0);
         			sheetObjects[t5sheet1_num].SetWaitImageVisible(0);
         			sheetObjects[t5sheet1_num].LoadSearchData(arrXml[0],{Sync:1} );
         			//sheetObjects[t5sheet1_num].RenderSheet(1);
         			//sheetObjects[t5sheet2_num].RenderSheet(0);
         			sheetObjects[t5sheet2_num].SetWaitImageVisible(0);
         			sheetObjects[t5sheet2_num].LoadSearchData(arrXml[1],{Sync:1} );
         			//sheetObjects[t5sheet2_num].RenderSheet(1);
         			//sheetObjects[t5sheet4_num].RenderSheet(0);
         			sheetObjects[t5sheet4_num].SetWaitImageVisible(0);
         			sheetObjects[t5sheet4_num].LoadSearchData(arrXml[2],{Sync:1} );
         			//sheetObjects[t5sheet4_num].RenderSheet(1);
         			ComOpenWait(false);
                    break;
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
      * displaying at t5sheet3 as information corresponding to the first row of the Container as reading t5sheet4 in case of value of t5sheet4
      */
    function t5sheet4_OnSearchEnd(sheetObj, Code,ErrMsg){
    	var cntrNo=null;
    	var emptyXml="<SHEET>	<DATA  TOTAL='0'> </DATA> </SHEET>";
        if (ErrMsg == "") {
        	if(sheetObj.RowCount()> 0){
        		cntrNo=sheetObjects[t5sheet1_num].GetCellValue(1, "t5sheet1_cntr_no");
        	 	//t5sheet4에 값이 존재하는지를 체크한다. 값이 없는 경우에는 t5sheet3를 모두 지운다.
        	 	if (sheetObjects[t5sheet4_num].RowCount()> 0) {
        	 		copySoInfoDetail(cntrNo);
        	 	} else {
        	 		sheetObjects[t5sheet3_num].LoadSearchData(emptyXml,{Sync:1} );
       	 		}
            } else {
            	sheetObjects[t5sheet3_num].LoadSearchData(emptyXml,{Sync:1} );
            }
        }
    }
  /**
   * showing at t5sheet4 after reading at t5sheet in case of clicking row of t5sheet1
   */
    function t5sheet1_OnDblClick(sheetObj, row, col){
 	    if (sheetObj.RowCount()> 0) {
 	    	var cntrNo=sheetObj.GetCellValue(row, "t5sheet1_cntr_no");
 		    copySoInfoDetail(cntrNo);        	 
 	    }
    }
    function copySoInfoDetail(cntrNo) {
       	sheetObjects[t5sheet3_num].RemoveAll();
       	var prefix1="t5sheet3_";
       	var prefix2="t5sheet4_";
       	var row=0;
       	for(i=0;i<sheetObjects[t5sheet4_num].RowCount();i++){
       		if (sheetObjects[t5sheet4_num].GetCellValue(i+1,prefix2+ "cntr_no") == cntrNo) {
           		row=sheetObjects[t5sheet3_num].DataInsert(-1);
           		sheetObjects[t5sheet3_num].SetCellValue(row,prefix1+ "sp_code",sheetObjects[t5sheet4_num].GetCellValue(i+1,prefix2+ "sp_code"),0);
           		sheetObjects[t5sheet3_num].SetCellValue(row,prefix1+ "sp_name",sheetObjects[t5sheet4_num].GetCellValue(i+1,prefix2+ "sp_name"),0);
           		sheetObjects[t5sheet3_num].SetCellValue(row,prefix1+ "sp_tel_no",sheetObjects[t5sheet4_num].GetCellValue(i+1,prefix2+ "sp_tel_no"),0);
           		sheetObjects[t5sheet3_num].SetCellValue(row,prefix1+ "cost_mode",sheetObjects[t5sheet4_num].GetCellValue(i+1,prefix2+ "cost_mode"),0);
           		sheetObjects[t5sheet3_num].SetCellValue(row,prefix1+ "nod_cd",sheetObjects[t5sheet4_num].GetCellValue(i+1,prefix2+ "nod_cd"),0);
           		sheetObjects[t5sheet3_num].SetCellValue(row,prefix1+ "sts_cd",sheetObjects[t5sheet4_num].GetCellValue(i+1,prefix2+ "sts_cd"),0);
           		sheetObjects[t5sheet3_num].SetCellValue(row,prefix1+ "ofc_cd",sheetObjects[t5sheet4_num].GetCellValue(i+1,prefix2+ "ofc_cd"),0);
           		sheetObjects[t5sheet3_num].SetCellValue(row,prefix1+ "usr_id",sheetObjects[t5sheet4_num].GetCellValue(i+1,prefix2+ "usr_id"),0);
           		sheetObjects[t5sheet3_num].SetCellValue(row,prefix1+ "so_no",sheetObjects[t5sheet4_num].GetCellValue(i+1,prefix2+ "so_no"),0);
           		sheetObjects[t5sheet3_num].SetCellValue(row,prefix1+ "so_date",sheetObjects[t5sheet4_num].GetCellValue(i+1,prefix2+ "so_date"),0);
           		sheetObjects[t5sheet3_num].SetCellValue(row,prefix1+ "wo_no",sheetObjects[t5sheet4_num].GetCellValue(i+1,prefix2+ "wo_no"),0);
           		sheetObjects[t5sheet3_num].SetCellValue(row,prefix1+ "wo_date",sheetObjects[t5sheet4_num].GetCellValue(i+1,prefix2+ "wo_date"),0);
           		sheetObjects[t5sheet3_num].SetCellValue(row,prefix1+ "cntr_no",sheetObjects[t5sheet4_num].GetCellValue(i+1,prefix2+ "cntr_no"),0);
           		sheetObjects[t5sheet3_num].SetToolTipText(row,prefix1+ "usr_id",sheetObjects[t5sheet4_num].GetCellValue(i+1, prefix2+ "usr_nm"));
           	}
        }
    }
    /**
     * t5sheet2_OnSearchEnd check logic
     */
    function t5sheet2_OnSearchEnd(sheetObj, ErrMsg){
    	cntrQtySum=0;
    	if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
            	for(var i=1; i<=sheetObj.RowCount(); i++) {
            		if (isFloat(sheetObj.GetCellValue(i,"t5sheet2_cntr_qty")) == true) {
             			sheetObj.SetCellFont("FontBold", i, "t5sheet2_cntr_qty", i, "t5sheet2_cntr_qty", 1);
             			sheetObj.SetCellFontColor(i, "t5sheet2_cntr_qty" ,"#FF0000");
            		}
            	}
            }
    	}
    }
    /** 
     * isFloat(str) : Check if the numeric value
     */ 
     function isFloat(fVal) {
     	var temp=0;
     	var sVal=null;
     	var sIdx=fVal.toString().indexOf(".");
     	if (sIdx > 0) {
        	var sTemp=fVal.toString();
     		sVal=sTemp.substring(parseInt(sIdx) + 1);
        	if (parseInt(sVal) > 0 ) {
        		return true;
        	} else {
        		return false;
        	}
     	} else {
     		return false;
     	}
     }
    
    /**
     *  t5sheet1_OnSearchEnd event handling
     */
     function t5sheet1_OnSearchEnd(sheetObj,Code, ErrMsg){
    	 if (ErrMsg != "") {
        	 fnSoInfoClear();
         }
     }
    function fnSoInfoClear() {
    	sheetObjects[t5sheet1_num].RemoveAll();
    	sheetObjects[t5sheet2_num].RemoveAll();
    	sheetObjects[t5sheet3_num].RemoveAll();
    	sheetObjects[t5sheet4_num].RemoveAll();
    }	 	   
    //retrieve Processing modules are managed in an integrated way.
    function fnSearch() {
		doActionIBSheet(sheetObjects[t5sheet1_num],document.form,IBSEARCH);
    }
    function fnQueryExec(bkg_no) {
    	if (bkg_no != "") {
    		document.form.bkg_no.value=bkg_no;
    		fnSearch();
        }     	
    }    
