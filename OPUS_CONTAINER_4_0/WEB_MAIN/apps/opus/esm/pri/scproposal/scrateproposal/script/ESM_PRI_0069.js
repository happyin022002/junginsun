/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0069.js
*@FileTitle  : View All Rates
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/04
=========================================================*/
/**
 * @extends Pri
 * @class business script for ESM_PRI_0069:ESM_PRI_0069 
 */
function ESM_PRI_0069() {
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.processButtonClick=processButtonClick;
	this.doActionIBSheet=doActionIBSheet;
}
//global variables
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1;
var gPageNo=1;
var gCurrDate;
var svcScpCd;

//다음의 화면들에서 호출됨
//ESM_PRI_0003_08

/** 
* registering IBSheet Object as list  <br>
*/ 
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/** 
* Setting body tag's onLoad event handler <br>
* Adding pre-handling function after loading screen on the browser  <br> 
*/ 
function loadPage() {
    sheet1=sheetObjects[0];
    sheetCnt=sheetObjects.length;
    for(i=0;i<sheetCnt;i++){
        ComConfigSheet(sheetObjects[i]); 
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]); 
    }
    sheet1.SetWaitImageVisible(0);
    //doActionIBSheet(sheet1, form, IBSEARCH, "", "1"); 
    doActionIBSheet(sheet1, form, IBSEARCH_ASYNC01, "", "1"); 
    // SC NO : GLO90901
    // WHERE PROP_NO = 'PDX090072M'
    //	AND AMDT_SEQ = '13'
    //	AND SVC_SCP_CD = 'TPE'
    //	AND GEN_SPCL_RT_TP_CD = 'G'
}
/** 
* Initializing and setting Sheet basics <br>
* Adding pre-handling function after loading screen on the browser  <br>
* adding case as numbers of counting sheets <br> 
*/ 
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
		case "sheet1":
		    with(sheet1){
	       
	      //no support[check again]CLT 		            ScrollTrack=false;
	      //no support[check again]CLT 		            MassOfSearch=1;
	      var HeadTitle1="|||Seq.|Commodity|Actual\nCustomer|Origin|Origin|Origin|Origin|Destination|Destination|Destination|Destination|PER|CGO\nType|CUR|Rate";
	      var HeadTitle2="|||Seq.|Commodity|Actual\nCustomer|Location|Country|State|Via |Via|Location|Country|State|PER|CGO\nType|CUR|Rate"

	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"},
	                  { Text:HeadTitle2, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cmdt_hdr_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"rout_seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"rt_seq",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"prc_cmdt_def_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"cust_lgl_eng_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"org_rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"org_rout_pnt_loc_cnt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"org_rout_pnt_loc_ste_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"org_rout_via_port_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"dest_rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"dest_rout_pnt_loc_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"dest_rout_pnt_loc_cnt_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dest_rout_pnt_loc_ste_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"prc_cgo_tp_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"prop_frt_rt_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
	       
	      InitColumns(cols);

	      SetEditable(0);
	      SetCountFormat("[SELECTDATAROW / TOTALROWS]");
	      SetSheetHeight(460);
	      }


	      	break;
	}
}
document.onclick=processButtonClick;
/** 
* Event handler processing by button name  <br>
*/ 
function processButtonClick(){
	var form=document.form;
    try {
	    var srcName=ComGetEvent("name");
	    switch(srcName) {
	    	case "btn_retrieve":
	    		//doActionIBSheet(sheet1, form, IBSEARCH, "", "1");
	    		doActionIBSheet(sheet1, form, IBSEARCH_ASYNC01, "", "1");
	    		break;
	    	case "btn_close":
	    		ComClosePopup(); 
	    		break;
	    } //end switch
    }catch(e) {
    	if( e == "[object Error]") {
    		ComShowMessage(OBJECT_ERROR);
 		} else {
 			ComShowMessage(e.message);
 		}
 	}
}
//===================================================================================
//Axson Event Handler
//===================================================================================
//===================================================================================
//UI Object Event Handler
//===================================================================================
/** 
* calling function when occurring OnSearchEnd Event <br>
*/ 
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var form=document.form;
    if (errMsg == "") {
    	if(form.f_cmd.value == SEARCH) {
        	var pageRows=parseInt(form.pagerows.value, 10);
        	var totalRows=parseInt(sheet1.GetTotalRows(), 10);
        	var totalPage=totalRows / pageRows;
        	var bottoomRow=sheet1.LastRow()- sheet1.HeaderRows()+ 1;
        	totalPage=parseInt(totalPage, 10);
        	var totalMod=totalRows % pageRows;
        	if(totalMod > 0) {
        		totalPage=totalPage + 1;
        	}
    		//sheet1.CountFormat = "[" + ComAddComma2(pageRows, "#,###") + " row : " + ComAddComma2(bottoomRow, "#,###") + " bottom]" + "        " + "[" + gPageNo + " page / " + totalPage + " page]" + "        " + "[SELECTDATAROW / TOTALROWS]";
        	//sheet1.CountFormat = "[" + ComAddComma2(bottoomRow, "#,###") + " bottom]" + "        " + "[" + gPageNo + " page / " + totalPage + " page]" + "        " + "[SELECTDATAROW / TOTALROWS]";
    		//sheet1.CountFormat = "[SELECTDATAROW / TOTALROWS]" + "[" + sheet1.TotalRows + "]";
    		//alert(sheet1.TotalRows);
    	}
    }
}   
/**
 * calling function when occurring OnClick Event <br>
 */  	           
 function sheet1_OnClick(sheetObj, Row, Col, Value) {
   //showing memopad when clicking desc cell (MemoPad editable)
   var colname=sheetObj.ColSaveName(Col);
 	switch(colname) {
 		case "prc_cmdt_def_nm":
 		case "cust_lgl_eng_nm": 	    		
   		ComShowMemoPad(sheetObj, Row, Col, true, 450, 80);
   		break;
 	}    	 
}
/** 
* when double clicking sheet1 cell  <br>
*/ 
function sheet1_OnDblClick(sheetObj, Row, Col, Value) {
var cmdt_hdr_seq=sheet1.GetCellValue(Row, "cmdt_hdr_seq");
var rout_seq=sheet1.GetCellValue(Row, "rout_seq");
var rt_seq=sheet1.GetCellValue(Row, "rt_seq");
	opener.moveRowPosTo(cmdt_hdr_seq, rout_seq, rt_seq);
  ComClosePopup(); 
}
/**
 * Handling sheet process <br>
 */
function doActionIBSheet(sheetObj, formObj, sAction, condParam, PageNo) {
	sheet1.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH_ASYNC01:  
			ComOpenWait(true);
			sheet1.SetWaitImageVisible(0);
			formObj.f_cmd.value=SEARCHLIST;  
 			sheet1.SpeedOption="NOPROGRESSTICK,NOSTATUS,NOFIT,NOSUM,NOCALC,NOROWHEIGHT,NOMERGEROW,NOTRIM,NOTDTAG,NOCOMBO,NOFORMAT";
     		sheet1.DoSearch("ESM_PRI_0069GS.do", FormQueryString(formObj) );
			//sheet1.SpeedOption="NOPROGRESSTICK,NOSTATUS,NOFIT,NOSUM,NOCALC";
			//sheet1.DoSearch4Fx("ESM_PRI_0069GS.do", FormQueryString(formObj));
			//sheet1.SpeedOption="NOPROGRESSTICK,NOSTATUS,NOFIT,NOSUM,NOCALC,NOROWHEIGHT,NOMERGEROW,NOTRIM,NOTDTAG,NOCOMBO,NOFORMAT";
			//var sXml = sheet1.GetSearchXml("ESM_PRI_0069GS.do", FormQueryString(formObj));
			//sheet1.LoadSearchXml(sXml);
			ComOpenWait(false);
			break;
		case IBSEARCH: 
			ComOpenWait(true);
			sheet1.SetWaitImageVisible(0);
			formObj.f_cmd.value=SEARCH; // paging
        	gPageNo=1;
			//sheet1.SpeedOption="NOPROGRESSTICK,NOSTATUS,NOFIT,NOSUM,NOCALC,NOROWHEIGHT,NOMERGEROW,NOTRIM,NOTDTAG,NOCOMBO,NOFORMAT";
        	//sheet1.DoSearch("ESM_PRI_0069GS.do", FormQueryString(formObj), "page_no=" + PageNo);
 			sheet1.SpeedOption="NOPROGRESSTICK,NOSTATUS,NOFIT,NOSUM,NOCALC";
 			sheet1.DoSearchFx("ESM_PRI_0069GS.do", FormQueryString(formObj)+"&"+ "page_no=" + PageNo );
			ComOpenWait(false);
			break;
		case IBSEARCHAPPEND: 
			ComOpenWait(true);
			sheet1.SetWaitImageVisible(0);
            formObj.f_cmd.value=SEARCH; // paging
            gPageNo=PageNo;
			//sheet1.SpeedOption="NOPROGRESSTICK,NOSTATUS,NOFIT,NOSUM,NOCALC,NOROWHEIGHT,NOMERGEROW,NOTRIM,NOTDTAG,NOCOMBO,NOFORMAT";
            //sheet1.DoSearch("ESM_PRI_0069GS.do", FormQueryString(formObj), "page_no=" + PageNo, true);
 			sheet1.SpeedOption="NOPROGRESSTICK,NOSTATUS,NOFIT,NOSUM,NOCALC";
             sheet1.DoSearchFx("ESM_PRI_0069GS.do", FormQueryString(formObj)+"&"+ "page_no=" + PageNo,{Append:true} );
			ComOpenWait(false);
            break;
	}
}
