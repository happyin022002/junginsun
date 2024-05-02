var sheetObjects = new Array();
var sheetCnt = 0;
var row =0;
var col =0;
document.onclick = processButtonClick;

/* Event handler processing by button name */
function processButtonClick(){
	var sheetObj = sheetObjects[0];
	/*******************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_retrieve":
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
			break;

			case "btn_save":
				doActionIBSheet(sheetObj,formObj,IBSAVE);
			break;

			case "btn_downexcel":
				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
			break;

			case "btng_rowadd":
				doActionIBSheet(sheetObj,formObj,IBINSERT);
			break;

			case "btn_new":
				sheetObj.RemoveAll();
				formObj.reset();
			break;

		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111') ;
		} else {
			ComShowMessage(e);
		}
	}
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
	
	//fun_getOffcd();
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
				//setting width
				SheetWidth = mainTable.clientWidth;

				//setting Host information[HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//Merge kind[, Default msNone]
				MergeSheet = msNone;

				//Edit kind[, Default false]
				Editable = true;

				//setting Row information[HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, document.form.row_size.value);

				//setting Column information[COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(14, 3, 0, true);

				// setting function handling header
				//InitHeadMode(true, true, false, true, false,false)
				InitHeadMode(true, true, true, true, false,false);

				var HeadTitle = "Del.|STS|SEQ|Subscriber Group|Notification Office|Global ID|Name|E-Mail|Control Office|User ID|Updated Date|Active" ;

				//setting function handling header Row[ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, false);

				//Data attributes		[ROW, COL,	DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
        InitDataProperty(0, cnt++ , dtDelCheck,      0,	  daCenter,   false,    "sDelCheck",               false,     "",      dfNone,   	    0,      true,       true);
        InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,	  daCenter,   false,	"r_ibflag",			       false,	  "",	   dfNone,   		0,		true,	    true);
				InitDataProperty(0, cnt++ , dtSeq,	 		 0,	  daCenter,	  false,	"r_seq",				   false,     "",	   dfNone,   		0,		false,	    false);
				InitDataProperty(0, cnt++ , dtCombo,		 0,	  daLeft,  	  false,	"r_subsc_grp_cd",		   true,	  "",	   dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtPopupEdit,	 0,	  daCenter,	  false,	"r_ntfd_ofc_cd",		   false,	  "",	   dfEngUpKey,	 		0,		true,		true,		6);
				InitDataProperty(0, cnt++ , dtPopupEdit,     100, daCenter,   false,	"r_global_id",		       false,	  "",	   dfNone,   		0,		true,		true);
				InitDataProperty(0, cnt++ , dtData	,	     120, daCenter,   false,	"r_name",			       false,	  "",	   dfNone,   		0,		false,		true);
				InitDataProperty(0, cnt++ , dtData	,	     180, daCenter,   false,	"r_email",			       false,	  "",	   dfNone,   		0,		false,		true);
				InitDataProperty(0, cnt++ , dtPopupEdit,	 0,	  daCenter,   false,	"r_cnt_ofc",			   false,	  "",	   dfEngUpKey,   		0,		true,		true,       6);
				InitDataProperty(0, cnt++ , dtData	,	     0,	  daCenter,   false,	"r_usr_id",			       false,	  "",	   dfNone,   		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData	,	     0,	  daCenter,   false,	"r_upd_dt",			       false,	  "",	   dfDateYmd,   	0,		false,		false);
				InitDataProperty(0, cnt++ , dtCombo,	     0,	  daCenter,	  false,	"r_act",			       false,	  "",	   dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,	     0,	  daCenter,   false,	"cop_expt_subsc_cs_seq",   false,	  "",	   dfNone,   		0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,	     0,	  daCenter,   false,	"subsc_grp_ntfd_pty_cd",   false,	  "",	   dfNone,   		0,		false,		false);



				//setting Combo information[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
				InitDataCombo (0, "r_subsc_grp_cd"  , copSubscGrpCdText  , copSubscGrpCdCode );
				

				InitDataCombo (0, "r_act" , "Y|N", "Y|N");

				style.height = GetSheetHeight(15) ;
			}
		break;
	}
}

  // handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {

	switch(sAction) {

		case IBSEARCH:	  
			formObj.f_cmd.value = SEARCHLIST ;
			sheetObj.DoSearch4Post("ESD_SCE_0028GS.do", SceFrmQryString(formObj));
		break;

		case IBINSERT:	  
			var Row = sheetObj.DataInsert();
			sheetObj.CellValue(Row, "r_act") = getcomText(sheetObj, Row, 11);
		break;

		case IBSAVE:
//			var valueTF = false;
			if(validateForm(sheetObj,formObj,sAction)){
				formObj.f_cmd.value = MULTI ;
				sheetObj.DoAllSave("ESD_SCE_0028GS.do", SceFrmQryString(formObj));
//				valueTF = true;
//				if (valueTF == true) {
//					formObj.f_cmd.value = SEARCHLIST ;
//					sheetObj.DoSearch4Post("ESD_SCE_0028GS.do", SceFrmQryString(formObj));
//					ComShowMessage("Updated properly.");
//				}
			}
		break;

		case IBDOWNEXCEL:		
			sheetObj.SpeedDown2Excel(-1);
		break;
		
	}
	var rowCnt = sheetObj.RowCount('');
	for (var row = 1; row <= rowCnt; row++) {
		if(sheetObj.CellValue(row, "r_act") == 'N') {
			sheetObj.CellEditable(row,"r_subsc_grp_cd") = false;
			sheetObj.CellEditable(row,"r_ntfd_ofc_cd") = false;
			sheetObj.CellEditable(row,"r_global_id") = false;
			sheetObj.CellEditable(row,"r_name") = false;
			sheetObj.CellEditable(row,"r_email") = false;
			sheetObj.CellEditable(row,"r_cnt_ofc") = false;
		} else {
			sheetObj.CellEditable(row,"r_subsc_grp_cd") = true;
			sheetObj.CellEditable(row,"r_ntfd_ofc_cd") = true;
			sheetObj.CellEditable(row,"r_global_id") = true;
			sheetObj.CellEditable(row,"r_cnt_ofc") = true;
		}
	}
}

function getcomText(sheetObj, row, col){

	var sText = sheetObj.GetComboInfo(row,col, "Text");
	var sCode = sheetObj.GetComboInfo(row,col, "Code");

	var arrText = sText.split("|");
	var arrCode = sCode.split("|");

	var idx   = sheetObj.GetComboInfo(row,col, "SelectedIndex");

	return arrText[idx];
}

function sheet1_OnPopupClick(sheetObj, row, col){
	var colName = sheetObj.ColSaveName(col) ;

	if(colName=="r_ntfd_ofc_cd" ){
		openOfcPopSheet(sheetObj, row, false, "r_ntfd_ofc_cd") ;
	}
	else if(colName=="r_ntfd_subsc_id"){
		openStaffPopSheet(sheetObj, row, false, "r_ntfd_subsc_id", null, "r_ntfd_ofc_cd");
	}
	else if(colName=="r_global_id"){
		openStaffPopSheet(sheetObj, row, false, col)
	}
	else if(colName=="r_cnt_ofc"){
		openOfcPopSheet(sheetObj, row, false, "r_cnt_ofc") ;
		
		sheetObj.CellEditable(row, "r_global_id")  = false ;
		sheetObj.CellEditable(row, "r_name")  = false ;
		sheetObj.CellEditable(row, "r_email")  = false ;
	}
}


function getDisname(uname, umail, uid){
	var sheetObject = sheetObjects[0];

	sheetObject.CellValue2(sheetObject.SelectRow, "r_global_id") =  uid;
	sheetObject.CellValue2(sheetObject.SelectRow, "r_name") =  uname;
	sheetObject.CellValue2(sheetObject.SelectRow, "r_email") =  umail;

}

/**
 * @param rowArray 
 */
function setValFromStaffArray(collArray, gubun, i){


	var ofc = collArray[3];
	var uid = collArray[4];
	var uname =  collArray[5];
	var eml =  collArray[6];

	sheetObject.CellValue2(sheetObject.SelectRow, "r_global_id") =  uid;
	sheetObject.CellValue2(sheetObject.SelectRow, "r_name") =  uname;
	sheetObject.CellValue2(sheetObject.SelectRow, "r_email") =  eml;

}

function sheet1_OnChange(sheetObj, row, col){
	var colName = sheetObj.ColSaveName(col) ;
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	switch (sAction) {
		case IBSAVE:
			var row           = null ;
			var copExptTpCD   = null ;
			var chgRows       = sheetObj.FindStatusRow("I|U").split(";") ;
			var all_rowcnt = sheetObj.RowCount;

			for( var i = 1; i <= all_rowcnt; i++ ){

				if( i != 0 ) {

					if(sheetObj.CellValue(i, 'r_ntfd_ofc_cd') == "" ){
						ComShowMessage('Input Notification Office!');
						sheetObj.SelectCell(i, 'r_ntfd_ofc_cd');
						return false;
					}
				}

			}
	
			for( var cnti = 0; cnti < chgRows.length-1; cnti++ ){
				for( var i = 1; i <= all_rowcnt; i++ ){

		            if(  i != chgRows[cnti] ) {
						if(sheetObj.CellValue(i, 'r_ntfd_ofc_cd') == sheetObj.CellValue(chgRows[cnti], 'r_ntfd_ofc_cd') ){

							if(sheetObj.CellValue(i, 'r_email') == sheetObj.CellValue(chgRows[cnti], 'r_email') &&
								sheetObj.CellValue(i, 'r_subsc_grp_cd' == sheetObj.CellValue(chgRows[cnti], 'r_subsc_grp_cd') )){
								ComShowMessage('Duplicate Notification Office and E-Mail!');
								sheetObj.SelectCell(chgRows[cnti], 'r_ntfd_ofc_cd');
								return false;
							}
						}
		
                        if( sheetObj.CellValue(i, 'r_email') != "" ){
							if(sheetObj.CellValue(i, 'r_email') == sheetObj.CellValue(chgRows[cnti], 'r_email') &&
							   sheetObj.CellValue(i, 'r_subsc_grp_cd') == sheetObj.CellValue(chgRows[cnti], 'r_subsc_grp_cd') && 
							   sheetObj.CellValue(i, 'r_ntfd_ofc_cd') == sheetObj.CellValue(chgRows[cnti], 'r_ntfd_ofc_cd')){
								ComShowMessage('Duplicate Subscriber Group and Notification Office, E-Mail!');
								sheetObj.SelectCell(chgRows[cnti], 'r_email');
								return false;
							}
						}
													
					}

				}

				if(sheetObj.CellValue(chgRows[cnti], 'r_global_id') == "" && sheetObj.CellValue(chgRows[cnti], 'r_cnt_ofc') == "" ){
					if(sheetObj.CellValue(chgRows[cnti], 'r_email') == "" ){				
						ComShowMessage('Input Global ID or Control Office!');
						return false;
					}
				}else if(sheetObj.CellValue(chgRows[cnti], 'r_global_id') == "" ){
					if( sheetObj.CellValue(chgRows[cnti], 'r_cnt_ofc') == "" ){
						if(sheetObj.CellValue(chgRows[cnti], 'r_name') == "" ){				
							ComShowMessage('Input Name and E-Mail!');
							return false;
						}
					}
				}
		
				if(sheetObj.CellValue(chgRows[cnti], 'r_global_id') != "" ){
					if(sheetObj.CellValue(chgRows[cnti], 'r_name') == "" ){
						ComShowMessage('Input Name!');
						sheetObj.SelectCell(chgRows[cnti], 'r_name');
						return false;
					}					
					if(sheetObj.CellValue(chgRows[cnti], 'r_email') == ""  ){
						ComShowMessage('Input E-Mail!');
						sheetObj.SelectCell(chgRows[cnti], 'r_email');
						return false;
					}
					
				}
			
				if(sheetObj.CellValue(chgRows[cnti], 'r_email') != ""  ){
					if( chk_str_email(sheetObj.CellValue(chgRows[cnti], 'r_email')) == false) {
						ComShowMessage('Check E-Mail!'); 
						sheetObj.SelectCell(chgRows[cnti], 'r_email');					
						return false;				
					}
				}
				
			}

		break;

		default:
		break;
	}

	return true;
}

function sheet1_OnSaveEnd(sheetObj, errMsg){
	var formObj = document.form;

	if(errMsg==""){
		doActionIBSheet(sheetObj,formObj,IBSEARCH);
		ComShowCodeMessage('SCE90005') ;
	}
}

function sheet1_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
    var formObj = document.form ;
    selectVal = SceFrmQryString(formObj);
    sheetObj.DoSearch4Post("ESD_SCE_0028GS.do", selectVal, "cur_page=" + PageNo, true);
}

function comboChange(){

}

function sheet1_OnChange(sheetObj, row, col){
    var vcntCd = "";
	var chkVal =  sheetObj.CellValue(row, col);
	if( chkVal != "") {
	
		if( sheetObj.ColSaveName(col)=="r_ntfd_ofc_cd") {
		   vcntCd = this.get(chkVal);
	      if( vcntCd == ""){
			ComShowMessage('Check Notification Office!');
			sheetObj.CellValue(row, col) = "";
			return false;      
	      }	
		}else if( sheetObj.ColSaveName(col)=="r_cnt_ofc") {
		   vcntCd = this.get(chkVal);
	      if( vcntCd == ""){
			ComShowMessage('Check Control Office!');
			sheetObj.CellValue(row, col) = "";			
			  sheetObj.CellEditable(row, "r_global_id")  = true ;
			  sheetObj.CellEditable(row, "r_name")  = true ;
	         sheetObj.CellEditable(row, "r_email")  = true ;	
			
			return false;      
	      }else{
			  sheetObj.CellEditable(row, "r_global_id")  = false ;
			  sheetObj.CellEditable(row, "r_name")  = false ;
	         sheetObj.CellEditable(row, "r_email")  = false ;	      
	      }		

		      
		}
	
	}

}


//******************************************************************

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

/**

*/
function fun_getOffcd() {
		var url = "ESD_SCE_0028GS.do?f_cmd="+SEARCH12;
		createHttpRequest();
		request.open("GET", url, false);

		request.onreadystatechange = fncOffcd;
		
		request.send(null);

}

function fncOffcd() {

	Dictionary ();

	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("OFFCD");
			var skxml = docXml.getElementsByTagName("sub-sortKey");
			
			var sortKeyXml = null;
			var codeXml = null;
			var nameXml = null;
			
			var text_effS = "";
			var text_effM = "";
			var text_effE = "";

			
			if( rowXml.length > 0 ){
				for( var i = 0; i < rowXml.length; i++ ) {
							
					sortKeyXml = skxml[i].childNodes[0].nodeValue;
					
					put(sortKeyXml, sortKeyXml);
				}
				
			}
		}
	}
}

function chk_str_email( str ){
    if (ComTrim(str) != ""){
         //reg = /^[A-Za-z0-9_-]+([\.]{1}[A-Za-z0-9_-]+)*@[A-Za-z0-9-]+([\.]{1}[A-Za-z0-9-]+)+/i;
         reg=/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
         
        //if ( str.search(reg) >= 0) {
        if(reg.test(str)) {
            return true;
        }
    }
    
    return false;
}


//걍...내 맘데로...
function Dictionary () {
    this.nodeObject = new Object();
    this.put = put;
    this.get = get;
    this.keys = keys;
    this.del = del;
}

function put(key, value)
{
    obj = this.nodeObject;

    searchFlag = 0;

    for(var n in obj) {
        if(n == key) {
            obj[key] = value;
            searchFlag = 1;
        }
    }

    if(searchFlag == 0) {
        obj[key] = value;
    }
}

function get(key) {
    obj = this.nodeObject;
if(obj!=null)
    return obj[key]==null?"":obj[key];
}

function keys(){
    return this.nodeObject;
}

function del(key) {
    this.put(key, null);
}
//******************************************************************
