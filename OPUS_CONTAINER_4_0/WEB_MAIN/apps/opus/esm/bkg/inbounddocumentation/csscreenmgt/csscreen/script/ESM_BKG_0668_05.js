/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0668_05.js
*@FileTitle  : In-bound C/S Screen US(Customs Result)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var sheetObjects=new Array();
    var sheetCnt=0;
    var t4sheet1_num=0;
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
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
            var sheetID=sheetObj.id;
            switch(sheetID) {
   				case "t4sheet1":      //t4sheet1 init
   			      with(sheetObj){
	   		         var HeadTitle="Seq.|C|Code|Q'ty|Type|ENTRY NUMBER|RECEIVE DATE/TIME|CUS|Remark(s)";
	
	   		         SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	   		         var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
	   		         var headers = [ { Text:HeadTitle, Align:"Center"} ];
	   		         InitHeaders(headers, info);
	
	   		         var cols = [ {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"seq",           Wrap:1 },
	   		             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cstms_clr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
	   		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dspo_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
	   		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"cntr_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
	   		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"entr_tp_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
	   		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"entr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
	   		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"arr_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
	   		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rcv_loc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
	   		             {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"cstms_rmk1",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 } ];
	   		          
	   		         InitColumns(cols);
	
	   		         SetEditable(1);
	   		         SetColProperty("arr_dt", {Format:"####-##-####:##"} );
	   		         SetCountPosition(0);
	   		         SetSheetHeight(390);
   				   }
                    break;
            }
        }
      // handling process for Sheet
        function doActionIBSheet(sheetObj,formObj,sAction) {
            switch(sAction) {
               case IBSEARCH:      //retrieve
                	ComOpenWait(true);
	           		sheetObjects[t4sheet1_num].SetWaitImageVisible(0);
   	                formObj.f_cmd.value=SEARCH;
  		            sheetObj.DoSearch("ESM_BKG_0668_05GS.do", FormQueryString(formObj) );
		            sheetObjects[t4sheet1_num].SetWaitImageVisible(1);
	         		ComOpenWait(false);
                    break;
            }
        }
    function fnSearch() {
   		doActionIBSheet(sheetObjects[t4sheet1_num],document.form,IBSEARCH);        						
    }
    function fnQueryExec(bkg_no) {
    	if (bkg_no != "") {
    		document.form.bkg_no.value=bkg_no;
    		fnSearch();
        }     	
    }    
