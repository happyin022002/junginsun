/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0101.jsp
*@FileTitle  : Notified Subscriber - Search Inquiry
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
var selRow=0;
var selCol=0;
var selOfc="";
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick(){
	 var sheetObj=sheetObjects[0];
	 var formObj=document.form;
	try{
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_close":
				ComClosePopup(); 
    	        break;
		}
	}catch(e){
		if( e == "[object Error]") {
			ComShowMessage(getMsg('COM12111')) ;
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
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      //IBSheet1 init
            with (sheetObj) {
                //setting height
                //no support[check again]CLT style.height=GetSheetHeight(10) ;
                //setting width
        	(9, 0, 0, true);
        	var HeadTitle="STS|SEQ|Expt|Activity|VVD|Location|Estimated\nDate / Time|Actual\nDate / Time|Actual Data\nSource" ;

        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

        	var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
        	var headers = [ { Text:HeadTitle, Align:"Center"} ];
        	InitHeaders(headers, info);

        	var cols = [ {Type:"Status",    Hidden:1, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"r_dt_sts",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Seq",       Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"r_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cop_expt_sts",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0,  Width:220,  Align:"Left",    ColMerge:0,   SaveName:"act_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"nod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"estm_date",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"act_date",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"act_rcv_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
        	 
        	InitColumns(cols);
//        	SetSheetHeight(300);
        	resizeSheet();
        	SetEditable(1);
//        	SetSetImageList(0,"/opuscntr/img/opus/ico_b.gif"));
//        	SetSetImageList(1,"/opuscntr/img/opus/ico_g.gif"));
//        	SetSetImageList(2,"/opuscntr/img/opus/ico_r.gif"));
        	SetCountPosition(0);
           }
            break;
    }
}
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      //retrieving
			formObj.f_cmd.value=SEARCH01;
			var sXml = sheetObj.DoSearch("ESD_SCE_0101GS.do", SceFrmQryString(formObj) );
				//alert(sheetObj.EtcData("bkgno"));
			document.all.bkg_no.innerHTML=(sheetObj.GetEtcData("bkgno") != undefined) ? sheetObj.GetEtcData("bkgno") : "";
			document.all.bl_no.innerHTML=(sheetObj.GetEtcData("blno") != undefined) ? sheetObj.GetEtcData("blno") : "";
			document.all.rdterm.innerHTML=(sheetObj.GetEtcData("rdterm") != undefined) ? sheetObj.GetEtcData("rdterm") : "";
			document.all.cntr_no.innerHTML=(sheetObj.GetEtcData("cntr_no") != undefined) ? sheetObj.GetEtcData("cntr_no") : "";
			document.all.cop_no1.innerHTML=(sheetObj.GetEtcData("cop_no") != undefined) ? sheetObj.GetEtcData("cop_no") : "";
			document.all.vvd.innerHTML=(sheetObj.GetEtcData("tvvd") != undefined) ? sheetObj.GetEtcData("tvvd") : "";
			document.all.por.innerHTML=(sheetObj.GetEtcData("por") != undefined) ? sheetObj.GetEtcData("por") : "";
			document.all.pol.innerHTML=(sheetObj.GetEtcData("pol") != undefined) ? sheetObj.GetEtcData("pol") : "";
			document.all.pod.innerHTML=(sheetObj.GetEtcData("pod") != undefined) ? sheetObj.GetEtcData("pod") : "";
			document.all.del.innerHTML=(sheetObj.GetEtcData("del") != undefined) ? sheetObj.GetEtcData("del") : "";
			break;
	   case IBDOWNEXCEL:        //download to excel
 		  sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
		  break;
	}
}
function resizeSheet(){ // auto-sizing
    ComResizeSheet(sheetObjects[0]);
} 