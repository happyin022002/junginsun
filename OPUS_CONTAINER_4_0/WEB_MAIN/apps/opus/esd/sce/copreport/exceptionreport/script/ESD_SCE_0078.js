var sheetObjects = new Array();
var sheetCnt = 0;

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
function processButtonClick(){
	 var sheetObj = sheetObjects[0];
	 var formObj  = document.form;

	//try{
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_retrieve":

				if(validateForm(sheetObj, formObj, IBSEARCH)){
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
				}
				break;

			case "btn_new":
				sheetObj.RemoveAll();
				formObj.reset();
				break;

			case "btn_downexcel":
				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
				break;

			case "btn_fail_calendar":
				cal = new ComCalendarFromTo();
				cal.displayType = "date";
				cal.select(formObj.fail_fm_dt,formObj.fail_to_dt, 'yyyy-MM-dd');
				break ;

			case "btn_occur_calendar":
				cal = new ComCalendarFromTo();
				cal.displayType = "date";
				cal.select(formObj.occur_fm_dt, formObj.occur_to_dt, 'yyyy-MM-dd');
				break ;

			case "btn_bkg_calendar":
				cal = new ComCalendarFromTo();
				cal.displayType = "date";
				cal.select(formObj.bkg_fm_dt,formObj.bkg_to_dt, 'yyyy-MM-dd');
				break ;

			case "btn_occu_loc" :
//				window.open( 'ESD_SCE_0104.do',"occuPopup","width=800,height=630") ;
				var newWin = window.showModalDialog("ESD_SCE_0104.do", window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:450px");
				break;

			case "btn_scpopup" :
//				window.open('ESD_SCE_0105.do',"scPopup","width=500,height=600") ;
				var newWin = window.showModalDialog("ESD_SCE_0105.do", window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:500px;dialogHeight:420px");
				break;

			case "btn_occr_ofc" :

					var selofc_cd = formObj.cre_ofc_cd.value;
//					ComOpenWindow('ESD_SCE_0910.screen?sel_ofc_cd='+selofc_cd, 'ESD_SCE_0910', 'top=200, left=200, width=410, height=400, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
					var newWin = window.showModalDialog("ESD_SCE_0910.do?sel_ofc_cd="+selofc_cd, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:410px;dialogHeight:400px");
				break;

		}
/*	}catch(e){
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111')) ;
		} else {
			ComShowMessage(e);
		}
	}
*/
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {

	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	fun_getExptTP();

}

   /**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;

	switch(sheetNo) {
		case 1:	  //IBSheet1 init
			with (sheetObj) {

				style.height = GetSheetHeight(10);

				//setting width
                SheetWidth = mainTable.clientWidth;

				//setting Host information[HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//Merge kind[, Default msNone]
				MergeSheet = msHeaderOnly;

				//Edit kind[, Default false]
                Editable = true;

				//setting Row information[HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
				InitRowInfo( 2, 1, 10, 100);

				//setting Column information[COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(32, 6, 0, true);

				// setting function handling header
                InitHeadMode(true, true, true, true, false, false);


				var HeadTitle0 = "|Exception No.|BKG No.|B/L No.|COP No.|Container No.|Exception Type|Exception \nDetail Type|"
				+"Shipper|Consignee|Notify|VVD|POR|POL|POD|DEL|Occurred \nDate/Time|Occurred \nOffice|Occurred \nLocation|"
				+"Delay Time|Logistics Operation|Logistics Operation|Customer Service|Customer Service|US Rail Tracing|US Rail Tracing|From|From|To|To" ;
				var HeadTitle1 = "|Exception No.|BKG No.|B/L No.|COP No.|Container No.|Exception Type|Exception \nDetail Type|"
				+"Shipper|Consignee|Notify|VVD|POR|POL|POD|DEL|Occurred \nDate/Time|Occurred \nOffice|Occurred \nLocation|"
				+"Delay Time|Global ID|E-Mail|Global ID|E-Mail|Global ID|E-Mail|Activity|Actual Date/Time|Activity|Actual Date/Time" ;

				//setting function handling header Row[ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);

				//Data attributes	[	ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtCheckBox,  20,    daCenter,  true,    "check",           false,          "",       dfNone,   	0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"expt_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"bkg_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"bl_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"cop_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"cntr_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daLeft,	true,	"i_expt_type",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daLeft,	true,	"i_exptdtl_type",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				//InitDataProperty(0, cnt++ , dtData,		100,	daLeft,	true,	"expt_dtldesc",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"shipper",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"consignee",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"notify",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"vvd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"por_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"pol_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);

				InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"pod_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"del_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"occur_dt",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"cre_ofc_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"occr_nod_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"delay_dt",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"logi_gid",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daLeft,	true,	"logi_mail",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"cust_gid",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daLeft,	true,	"cust_mail",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"urt_gid",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daLeft,	true,	"urt_mail",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"f_act",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"f_actdt",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"t_act",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"t_actdt",				false,		  "",	   dfNone,   	0,	 		false,	   false);

                InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,   "r_act_cd1_nm",         false,        "",      dfNone,     	0,          false,     false);
                InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,   "r_act_cd2_nm",         false,        "",      dfNone,     	0,          false,     false);

				style.height = GetSheetHeight(12) ;
			//	DataLinkMouse = true;
		   }
			break;
	}
}

  // handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false ;

	switch(sAction) {
		case IBSEARCH:	  
			formObj.f_cmd.value = SEARCHLIST ;
			sheetObj.DoSearch4Post("ESD_SCE_0078GS.do", SceFrmQryString(formObj));

			//alert(sheetObj.GetSearchXml("ESD_SCE_0078GS.do", SceFrmQryString(formObj)));
				    // Exception Noti Failure Report  rowsize추가 &&&
                   if(sheetObj.EtcData("totcnt")>0){
                      //var rat = round(sheetObj.RowCount*100/sheetObj.EtcData("totcnt"));
                      //formObj.totcnt.value = " " + sheetObj.Rows + " / " + sheetObj.TotalRows;
                      formObj.totcnt.value = " " + sheetObj.EtcData("totcnt");
                   }
			break;

	   case IBDOWNEXCEL:
			  sheetObj.Down2Excel(-1, false, false, true);
			  break;
	}
}


/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
    var result = true;
	if(sAction == IBSEARCH) {

		if( !isInputField(formObj) ) {
			result = false ;
		
		}else if(!ComIsEmpty(formObj.bkg_no) ){
        	if(formObj.bkg_no.value.length<11 && !chkLenth(formObj.bkg_no, 11, "BKG No")){
        		result = false ;
        	}
		}else if(!ComIsEmpty(formObj.bl_no) ){
	    	if(formObj.bl_no.value.length<12 && !chkLenth(formObj.bl_no, 12, "BL No")){
	    		result = false ;
	    	}
		}else if(!ComIsEmpty(formObj.cntr_no) ){
	    	if(formObj.cntr_no.value.length<11 && !chkLenth(formObj.cntr_no, 11, "Container No")){
	    		result = false ;
	    	}
		}else if(!ComIsEmpty(formObj.cop_no) ){
	    	if(formObj.cop_no.value.length<14 && !chkLenth(formObj.cop_no, 14, "COP No")){
	    		result = false ;
	    	}
		}
	}
	return result;
}

function isInputField(formObj){
	var result    = false ;
	var fieldType = null ;

	for(i=0; i<formObj.length; i++){
		fieldType = formObj[i].type

		if((fieldType=="checkbox" || fieldType=="radio")){
			if(formObj[i].checked){
				result = true ;
				break ;
			}
		}
		else if(fieldType!="hidden" && !formObj[i].readOnly){
			if(!ComIsEmpty(formObj[i])){
				result = true ;
				break ;
			}
		}
	}

	if(!result){
		ComShowMessage(ComGetMsg('SCE90016')) ;
        formObj.bkg_no.focus() ;
	}

	return result ;
}


function sheet1_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
	var formObj = document.form ;
        //if (sheetObj.RowCount >= OnePageRow && sheetObj.TotalRows > sheetObj.RowCount){
        	selectVal = SceFrmQryString(formObj);
    		formObj.f_cmd.value = SEARCHLIST ;
    		PageNo = Math.ceil(sheetObj.SearchRows/10)+1;
        	sheetObj.DoSearch4Post("ESD_SCE_0078GS.do", selectVal, "i_page=" + PageNo, true);
        //}
    }


function chkLenth(obj, len, msg) {
	var result = true ;

	if(ComGetLenByByte(obj.value)!==len){
		ComShowMessage(ComGetMsg('SCE90026', msg, len));
        obj.focus() ;
        result = false ;
	}

	return result ;
}

function onEnterKey(textname) {
	if (event.keyCode == 13) {
		var formObj = document.form;
		if( validateForm(formObj) ) {
			formObj.f_cmd.value = "" ;
		}
	}
}



function CheckDigitSplit( obj, bitTarget, valueTarget){
	var cntrNo = obj.value;
	if (cntrNo.length < 10){
		document.getElementById(bitTarget).value = '';
		document.getElementById(valueTarget).value = cntrNo;
		return;
	}
	chkField(obj, 'eng_num', true, 10)
	var sum = 0;
 	cntrNo = cntrNo.toUpperCase();

	for(var i=0;i<10;i++){
		sum = sum + productValue( cntrNo.charAt(i),i);
	}
	var mod = sum % 11;

	if (mod == 10) mod =0;

	if( isNaN(mod)){
		document.getElementById(bitTarget).value = '';
		document.getElementById(valueTarget).value = obj.value;
	}else{
		document.getElementById(bitTarget).value = mod;
		document.getElementById(valueTarget).value = obj.value + mod;
	}
}

function getSCNO( so_no) {
	document.getElementById ("sc_no").value =so_no;
}

function getSelectedValue ( loc_cd) {
	document.getElementById("occr_nod_cd").value = loc_cd;
}

function rtn_vvd_code(strval) {
	document.form.vvd.value = strval;
}

function rtn_pol_code(strval) {
	document.form.pol_cd.value = strval;
}

function rtn_pod_code(strval) {
	document.form.pod_cd.value = strval;
}


function rtn_office_code(obj) {
	document.form.cre_ofc_cd.value = obj;
}

function openAddPaste(dist){
//	window.open ("ESD_SCE_0064.do?dist="+dist, "list", "scrollbars=no,fullscreen=no,width=400,height=400");
	var newWin = window.showModalDialog("ESD_SCE_0064.do?dist="+dist, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px");
}

function addValueNo(dist, multi_value){
	var multis = multi_value.split('\n');
	multi_value = '';
	for(var i = 0 ; i < multis.length ; i++){
		if(multis[i] != ''){
			if(i == 0){
				multi_value = multis[i];
			}else{
				multi_value = multi_value + ',' + multis[i];
			}
   		}
	}
	if(multi_value != ''){
//    		if(document.getElementById(dist).value != ''){
//    			document.getElementById(dist).value = document.getElementById(dist).value + ',' + multi_value;
//    		}else{
			document.getElementById(dist).value = multi_value;
//    		}
	}
}

function CheckDigit(obj){
    var rtnval = cntrCheckDigit(obj);
    obj.value  = rtnval;
}



function fun_chkOffice() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.cre_ofc_cd.value.toUpperCase(), " "); //input text
	if( prm_office == "" ) {
		doc_office.checked = false;
		document.form.cre_ofc_cd.value = "";
		ComShowMessage("Please input the 'Occurred Office'!!");
		return false;
	}
	if( doc_office.checked == true ) {

		var url = "ESD_SCE_0011GS.do?f_cmd="+SEARCH11+"&sel_ofc_cd="+prm_office;

		createHttpRequest();

		request.open("GET", url, false);

		request.onreadystatechange = subCntorlOffice;

		request.send(null);
	} else {
		document.form.cre_ofc_cd.value = prm_office;
	}
}


var request = null;
function createHttpRequest() {
	try{
		request = new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request = null;
			}
		}
	}
	if( request == null ) {
		ComShowMessage("Erroe Request XMLHttp");
	}
}


function subCntorlOffice() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			//var rowXml = docXml.getElementsByTagName("TR")[0];
			var subXml = null;
			var text_ofc = "";
			
			//alert(docXml.getElementsByTagName("TR").length);
			//alert(rowXml.firstChild.nodeValue.replace('☜',''));
			
			//var aaa = ComReplaceStr(rowXml.firstChild.nodeValue, "☜☞", "");
			//alert(docXml.xml);
			
			//for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
			//	subXml = docXml.getElementsByTagName("sub-office")[n];
			//	text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			//}
			
			for( var n = 0; n < docXml.getElementsByTagName("TR").length; n++ ) {
				var row = docXml.getElementsByTagName("TR")[n].firstChild.nodeValue;
				var val = ComReplaceStr(row, "☜☞", "");
				//alert(val);
				text_ofc = text_ofc+val+",";
			}
			
			if( text_ofc.length < 1 ) {
				ComShowMessage("No Data!");
			}else{
				document.form.cre_ofc_cd.value = text_ofc.substring(0, text_ofc.length-1);
			}
		}

	}

}



function fun_getExptTP() {

	var url = "ESD_SCE_0011GS.do?f_cmd="+SEARCH12;
	createHttpRequest();
	request.open("GET", url, true);

	request.onreadystatechange = subExptTp;

	request.send(null);

}



function subExptTp() {

	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			
			var dataXml = docXml.getElementsByTagName("DATA");
			var rowXml = docXml.getElementsByTagName("TR");
			
			
			var d_row = dataXml[0].getAttribute("COLORDER").split("|");
			
			//alert(d_row.length)
			
			var codeXml = null;
			var nameXml = null;

			var text_effS = "";
			var text_effM = "";
			var text_effE = "";

			text_effS = "<select style=\"width:150;\" name=\"i_expt_type\" onChange=\"fun_getExptDTLTP();\">";
			
					
			if( rowXml.length > 0 ){

				for( var i = 0; i < rowXml.length; i++ ) {

			
					var c_row = rowXml[i].childNodes[0].nodeValue.split("☜☞");
					//alert(c_row.length);
					
					var c_code="";
					var c_text="";
					
					for( var j = 0; j < d_row.length; j++ ) {
						if(d_row[j]=="expt_cd"){
							c_code =c_row[j]; 
						}
						if(d_row[j]=="expt_cd_nm"){
							c_text =c_row[j]; 
						}
					}
				
					if( i == 0){
						text_effM = "<OPTION value=\"\" selected >ALL</OPTION>";
						text_effM = text_effM + "<OPTION value=\"" + c_code + "\" >"+c_text+"</OPTION>";
					}else{
						text_effM = text_effM + "<OPTION value=\"" + c_code + "\" >"+c_text+"</OPTION>";
					}
				}
			}

			text_effE = "</SELECT>";

			if( text_effM.length < 1 ) {
				text_effM = "<OPTION value=\"\" selected >ALL</OPTION>";
			}

			document.form.all.ExptTPDiv.innerHTML = text_effS+text_effM+text_effE;
		}

	}

}



function fun_getExptDTLTP() {

	var expt_type = document.form.i_expt_type.value;

	var url = "ESD_SCE_0011GS.do?f_cmd="+SEARCH13+"&i_expt_type="+expt_type;
	createHttpRequest();
	request.open("GET", url, true);

	request.onreadystatechange = subExptDTLTp;

	request.send(null);

}



function subExptDTLTp() {

	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			
			var dataXml = docXml.getElementsByTagName("DATA");
			var rowXml = docXml.getElementsByTagName("TR");
			
			//if(rowXml==undefined){
				
			//var d_row = dataXml[0].getAttribute("COLORDER").split("|");
			
			//var d_row = dataXml[0].getAttribute("COLORDER");
			
			if(dataXml[0].getAttribute("COLORDER") != undefined){
				d_row = dataXml[0].getAttribute("COLORDER").split("|");
			}
			
			//alert(d_row.length)
			
			var codeXml = null;
			var nameXml = null;

			var text_effS = "";
			var text_effM = "";
			var text_effE = "";

			text_effS = "<select style=\"width:150;\" name=\"i_exptdtl_type\" >";
			
					
			if( rowXml.length > 0 ){

				for( var i = 0; i < rowXml.length; i++ ) {

			
					var c_row = rowXml[i].childNodes[0].nodeValue.split("☜☞");
					//alert(c_row.length);
					
					var c_text="";
					
					for( var j = 0; j < d_row.length; j++ ) {
						if(d_row[j]=="expt_cd_nm"){
							c_text =c_row[j]; 
						}
					}
				
					if( i == 0){
						text_effM = "<OPTION value=\"\" selected >ALL</OPTION>";
						text_effM = text_effM + "<OPTION value=\"" + c_text + "\" >"+c_text+"</OPTION>";
					}else{
						text_effM = text_effM + "<OPTION value=\"" + c_text + "\" >"+c_text+"</OPTION>";
					}
				}
			}

			text_effE = "</SELECT>";

			if( text_effM.length < 1 ) {
				text_effM = "<OPTION value=\"\" selected >ALL</OPTION>";
			}

			document.form.all.ExptDTLTPDiv.innerHTML = text_effS+text_effM+text_effE;
		}

	}

}

function sheet_OnMouseMove(sheetObj,buttonValue, shiftValue, x_pos, y_pos)
{
     if(sheetObj.MouseCol == sheetObj.SaveNameCol("f_act") || sheetObj.MouseCol == sheetObj.SaveNameCol("t_act")){
//alert("alert(OnMouseMove);");

           
//            sheetObj.MousePointer = "Default";  
              sheetObj.MousePointer = "Hand";     
              var sText="";
              if(sheetObj.MouseCol == sheetObj.SaveNameCol("f_act")) sText = sheetObj.CellText(sheetObj.MouseRow,"r_act_cd1_nm");
              else if(sheetObj.MouseCol == sheetObj.SaveNameCol("t_act")) sText = sheetObj.CellText(sheetObj.MouseRow,"r_act_cd2_nm");
           	  //sText = sheetObj.CellText(sheetObj.MouseRow,"d_act_cd1_nm");
           
          	  sheetObj.ToolTipText(sheetObj.MouseRow,sheetObj.MouseCol)  = sText;
     }

}