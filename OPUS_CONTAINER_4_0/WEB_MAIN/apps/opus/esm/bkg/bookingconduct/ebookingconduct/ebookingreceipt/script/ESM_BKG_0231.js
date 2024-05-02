/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0231.js
*@FileTitle  : e-Booking & SI Process - Copy Option
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
var tabNameAll="Customer|Container|M&D|C/M|TRO/O|Reefer|Danger|Awkward|House B/L 1|House B/L 2";
var loanYn = "N";
document.onclick=processButtonClick;

function processButtonClick(){
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "btn_ok":
			if(!validateForm(sheetObject,formObject,"btn_ok")) {
				return false;
			}
			doActionIBSheet(sheetObject,formObject,"btn_ok");
			break;
		case "btn_uncheckall":
			document.all.btn_checkall.style.display="";
			document.all.btn_uncheckall.style.display="none";
			sheetObjects[0].CheckAll("checkbox",0);
			break;
		case "btn_checkall":
			document.all.btn_checkall.style.display="none";
			document.all.btn_uncheckall.style.display="";
			sheetObjects[0].CheckAll("checkbox",1);
			break;
		case "btn_close":
			ComClosePopup(); 
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

function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}

function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
}

function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetId=sheetObj.id;
	switch(sheetId) {
	case "sheet1":
		with (sheetObj) {        
	        var HeadTitle1="|Tab|Data|Data|Copy Select";
	        var HeadTitle2="|Tab|OPUS|e-Service|Copy Select";
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"},
	                        { Text:HeadTitle2, Align:"Center"} ];
	        InitHeaders(headers, info);
	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	               {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"tab_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
	               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"opus_sel",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
	               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"esvc_sel",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
	               {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"checkbox",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 } ];
	        InitColumns(cols);
	        SetEditable(1);
	        SetRangeBackColor(1,2,1,3,"#555555");
	        SetSheetHeight(345);
		}
		break;
	}
}

function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	var opener=window.dialogArguments;
    if (!opener) opener=parent;
	switch(sAction) {
	case IBCLEAR:      //초기화
		if(!validateForm(sheetObj,formObj,sAction)) return;
		var t1 = opener.document.t1frame.form
		var includeTroRfDgAk=true;
		if (t1.doc_tp_cd.value == "S" &&
				(t1.save_tro_flag.value == "Y" ||
				 t1.save_rf_flag.value  == "Y" ||
				 t1.save_dg_flag.value  == "Y"||
				 t1.save_ak_flag.value  == "Y")) {
			includeTroRfDgAk=false;
		}
		var opusDataAll=t1.opus_data_yn_flag.value;
		var esvcDataAll=t1.xter_data_yn_flag.value;
		var tabName=tabNameAll.split("|");
		var opusData=opusDataAll.split("|");
		var esvcData=esvcDataAll.split("|");
		var insertXml="<?xml version='1.0'  ?>\n";
		insertXml += "<SHEET>\n";
		insertXml += "  <DATA TOTAL='"+tabName.length+"'>\n";
		for (var i=0;i<tabName.length;i++) {
			insertXml += " <TR>\n";
			insertXml += "   <TD>R</TD>\n";
			insertXml += "   <TD><![CDATA[" + tabName[i] + "]]></TD>\n";	
			if(includeTroRfDgAk == false){
				if(tabName[i]=="TRO/O"||tabName[i]=="Reefer"||tabName[i]=="Danger"||tabName[i]=="Awkward"){
					if ( opusData[i] == "Y" ) insertXml += "   <TD>Yes</TD>\n"; else insertXml += "   <TD>No</TD>\n";
					if ( esvcData[i] == "Y" ) insertXml += "   <TD>Yes</TD>\n"; else insertXml += "   <TD>No</TD>\n";
					if ( esvcData[i] == "Y" ) insertXml += "   <TD>0</TD>\n";
					insertXml += " </TR>\n";
					continue;
				}
			}
			
			if ( opusData[i] == "Y" ) insertXml += "   <TD>Yes</TD>\n"; else insertXml += "   <TD>No</TD>\n";
			if ( esvcData[i] == "Y" ) insertXml += "   <TD>Yes</TD>\n"; else insertXml += "   <TD>No</TD>\n";
			if(t1.doc_tp_cd.value == 'B' && (tabName[i] == 'C/M' || tabName[i] == 'Container')){
				insertXml += "   <TD>0</TD>\n";
			}else{
				if ( esvcData[i] == "Y" ) insertXml += "   <TD>1</TD>\n"; else insertXml += "   <TD>0</TD>\n";
			}
			insertXml += " </TR>\n";
		}
		insertXml += "  </DATA>\n";
		insertXml += "</SHEET>";
		
		ComOpenWait(true);
		
		sheetObjects[0].LoadSearchData(insertXml,{Sync:1} );
		
		for (var time = 1000; time <= 20000; time+= 500) {
		    setTimeout(function(time) {
		        for (var i=2; i <= sheetObjects[0].LastRow(); i ++) {
		    		if (sheetObjects[0].GetCellValue(i,"opus_sel") == "Yes" || sheetObjects[0].GetCellValue(i,"esvc_sel") == "Yes") {
		    			if (parent.document.getElementById("t" + (i) + "load").value == "Y") {
		    				loanYn = "Y";
		    			}else{
		    				loanYn = "N";
		    			}
		    		}
		    	}
		        if (loanYn == "Y") { 
		    		ComOpenWait(false);
		        }
		    }, time);
		  }
		
		break;
	case "btn_ok":      // OK
		var var_callFunc=formObj.callFunc.value;
		var t2=opener.document.t2frame;
		var t3=opener.document.t3frame;
		var t4=opener.document.t4frame;
		var t5=opener.document.t5frame;
		var t6=opener.document.t6frame;
		var t7=opener.document.t7frame;
		var t8=opener.document.t8frame;
		var t9=opener.document.t9frame;
		var t10=opener.document.t10frame;
		var t11=opener.document.t11frame;
		var t1frame_form=opener.document.t1frame.form;
		var copyTabStr=new Array();
		if ( sheetObjects[0].GetCellValue(2, "checkbox") == 1
				&& t1frame_form.save_cust_flag.value == "Y" ) {
			copyTabStr[0]="COPY"; 
		} else {
			copyTabStr[0]="N/A";		
		}
		if ( sheetObjects[0].GetCellValue(3, "checkbox") == 1
				&& t1frame_form.save_cntr_flag.value == "Y" ) {
			copyTabStr[1]="COPY"; 
		} else {
			copyTabStr[1]="N/A";
		}				
		if ( sheetObjects[0].GetCellValue(4, "checkbox") == 1
				&&  t1frame_form.save_mnd_flag.value == "Y" ) {
			copyTabStr[2]="COPY"; 
		} else {
			copyTabStr[2]="N/A";
		}		
		if ( sheetObjects[0].GetCellValue(5, "checkbox") == 1
				&&  t1frame_form.save_cm_flag.value == "Y" ) {
			copyTabStr[3]="COPY"; 
		} else {
			copyTabStr[3]="N/A";
		}		
		if ( sheetObjects[0].GetCellValue(6, "checkbox") == 1
				&&  t1frame_form.save_tro_flag.value == "Y" ) {
			copyTabStr[4]="COPY"; 
		} else {
			copyTabStr[4]="N/A";
		}		
		if ( sheetObjects[0].GetCellValue(7, "checkbox") == 1
				&&  t1frame_form.save_rf_flag.value == "Y" ) {
			copyTabStr[5]="COPY"; 
		} else {
			copyTabStr[5]="N/A";
		}		
		if ( sheetObjects[0].GetCellValue(8, "checkbox") == 1
				&&  t1frame_form.save_dg_flag.value == "Y" ) {
			copyTabStr[6]="COPY"; 
		} else {
			copyTabStr[6]="N/A";
		}		
		if ( sheetObjects[0].GetCellValue(9, "checkbox") == 1
				&&  t1frame_form.save_ak_flag.value == "Y" ) {
			copyTabStr[7]="COPY"; 
		} else {
			copyTabStr[7]="N/A";
		}		
		if ( sheetObjects[0].GetCellValue(10, "checkbox") == 1
				&&  t1frame_form.save_hbl_flag.value == "Y" ) {
			copyTabStr[8]="COPY"; 
		} else {
			copyTabStr[8]="N/A";
		}		
		if ( sheetObjects[0].GetCellValue(11, "checkbox") == 1
				&& t1frame_form.save_hbl2_flag.value == "Y" ) {
			copyTabStr[9]="COPY"; 
		} else {
			copyTabStr[9]="N/A";
		}
//		eval(new String( opener + "." + var_callFunc))(copyTabStr);
		
		var func = opener[var_callFunc];
		if (typeof func === 'function')
			func.apply(this, [copyTabStr]);
		
		ComClosePopup(); 
		break;
	}
}

function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction) {
//		case "btn_Delete":
//			if (sheetObj.CheckedRows("checkbox") == 0) {
//				ComShowMessage(msgs['COM12189']);
//				return false;
//			} else if (sheetObj.CheckedRows("checkbox") > 0) {
//				ComShowMessage(msgs['COM12188']);
//				return true;
//			}
//			break;
		}
	}
	return true;
}
