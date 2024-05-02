/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_LSE_0056.js
 *@FileTitle : Invoice File import
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
          MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
          OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * @extends
 * @class EES_LSE_0056 : business script for EES_LSE_0056
 */
function EES_LSE_0056() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject     = setSheetObject;
	this.loadPage           = loadPage;
	this.initSheet          = initSheet;
	this.initControl        = initControl;
	this.doActionIBSheet    = doActionIBSheet;
	this.setTabObject       = setTabObject;
	this.validateForm       = validateForm;
}

/* developer job */

// common global variables

var sheetObjects = new Array();
var sheetCnt = 0;

var vLeaseTermCd = "";
var vCntrTpszCd  = "";
var arryLeaseTermCd = new Array();
var arryCntrTpszCd  = new Array();

var verifyYN = "";

//Event handler processing by button click event */
document.onclick = processButtonClick;

function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm('click','obj_click',formObj);         
	axon_event.addListenerForm('change','obj_change',formObj);       	
	axon_event.addListenerFormat('keypress','obj_keypress',formObj); 
	axon_event.addListenerFormat('blur','obj_blur',formObj);         
	axon_event.addListenerFormat('focus','obj_focus',formObj);       
}

//Event handler processing by button name */
function processButtonClick(){
	/**********/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		var srcObj  = window.event.srcElement;
		switch(srcName) {

		case "btn_LoadFile":
			sheetObject1.RemoveAll();
			sheetObject2.RemoveAll();
			loadFile();
			break;

		case "btn_DownExcel":			
			sheetObject1.Down2Excel();
			break;

		case "btn_Save":			
			//ComBtnDisable("btn_Save");
			doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
			break;

		case "btn_Close":
			window.close();
			break;

		case "btn_New": 
			//ComBtnEnable("btn_Save"); 
			verifyYN = "";
			sheetObject1.RemoveAll();
			break;
		case "btn_LoadExcel":
			if ( srcObj.style.filter == "" ) {				
				//sheetObject1.RemoveAll();
				//sheetObject2.RemoveAll();
				loadExcelFile();
			}
			break;			
		case "btn_verify":			
			if(sheetObjects[0].RowCount <= 0){
                ComShowCodeMessage("LSE01048");
                break;
                return;
            }
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);			
			break;
		} // end switch

	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
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

		
		ComConfigSheet (sheetObjects[i] );

		initSheet(sheetObjects[i],i+1);
		
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();		
}

/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
*/
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch(sheetID) {
	case "sheet1":      //sheet1 init
	with (sheetObj) {

		//setting height
		style.height = 248;
		//setting width
		SheetWidth = 750;//mainTable.clientWidth;

		//setting Host information [mandatory][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//Merge kind [optional, Default msNone]
		MergeSheet = msPrevColumnMerge;

		//Edit kind [optional, Default false]
		Editable = true;

		//setting Row information [mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(1, 1, 3, 100);

		var HeadTitle1 = "Seq.|AGMT No.|Contract No.|CNTR No.|TP/SZ|Lease Term|On Hire Date|On Hire LOC|Off Hire Date|Off Hire LOC|agmt_cty_cd|agmt_seq|vndr_seq|";

		var headCount = ComCountHeadTitle(HeadTitle1);

		//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);

		// setting function handling header
		InitHeadMode(true, true, false, true, false,false);

		//setting header Row information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);

		//data property    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		
		InitDataProperty(0, cnt++ , dtSeq,            35, daCenter, true,   "seq");
		InitDataProperty(0, cnt++ , dtData,           85, daCenter, true,   "agmt_no",        false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtData,           85, daCenter, true,   "contract_no",    false, "",   dfNone,   0,  false,    false);		
		InitDataProperty(0, cnt++ , dtData,           85, daCenter, true,   "cntr_no",        false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtData,           45, daCenter, true,   "cntr_tpsz_cd",   false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtData,           75, daCenter, true,   "lstm_cd",        false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtData,           80, daCenter, true,   "lr_onh_dt",      false, "",   dfDateYmd,0,  false,    false);
		InitDataProperty(0, cnt++ , dtData,           80, daCenter, true,   "lr_onh_loc_cd",  false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtData,           80, daCenter, true,   "lr_offh_dt",     false, "",   dfDateYmd,0,  false,    false);
		InitDataProperty(0, cnt++ , dtData,           80, daCenter, true,   "lr_offh_loc_cd", false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtHidden,         0,  daCenter, true,   "agmt_cty_cd",    false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtHidden,         0,  daCenter, true,   "agmt_seq",       false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtHidden,         0,  daCenter, true,   "vndr_seq",       false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtHiddenStatus,   0,  daCenter, true,   "ibflag");
		SelectBackColor = LSE_SELECT_BACK_COLOR;
	}
	break;

	case "sheet2":  
		with (sheetObj) {

			//setting height
			style.height = 318;
			//setting width
			SheetWidth = mainTable.clientWidth;

			//setting Host information [mandatory][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//Merge kind [optional, Default msNone]
			MergeSheet = msPrevColumnMerge;

			//Edit kind [optional, Default false]
			Editable = true;

			//setting Row information [mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "txt";

			var headCount = ComCountHeadTitle(HeadTitle1);

			//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// setting function handling header
			InitHeadMode(true, true, false, true, false,false)

			//setting header Row information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//data property    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

			InitDataProperty(0, cnt++ , dtData,           35, daLeft, true,   "txt");
		}
		break;
	}
}

// handling process for Sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	
	switch(sAction) {
	case IBSEARCH:      //verify
	formObj.f_cmd.value = SEARCH;
	sheetObj.WaitImageVisible = false;
	ComOpenWait(true);
	var sXml2 = sheetObj.GetSearchXml("EES_LSE_0056GS.do", FormQueryString(formObj));
	var contract_no    = ComGetEtcData(sXml2, "contract_no")
    
	if(contract_no == "F" || sXml2 == "" || sXml2 == null){    	
    	ComShowCodeMessage("LSE01096");   	    	
    }else{
    	loadFileVerify();
    }
	ComOpenWait(false);
	sheetObj.WaitImageVisible = true;
	break;

	case IBSAVE:	  
	
	if(validateForm(sheetObj,formObj,sAction)){
		formObj.f_cmd.value = MULTI;	
		var sParam = sheetObj.GetSaveString(true);			
		sParam += "&" + FormQueryString(formObj);	
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		var sXml   = sheetObj.GetSaveXml("EES_LSE_0056GS.do", sParam);	
		ComOpenWait(false);
		sheetObj.WaitImageVisible = true;
		var strAudVerSeq = "";
		if(sXml != null && sXml != ""){			
			strAudVerSeq = ComGetEtcData(sXml, "aud_ver_seq");
			opener.document.form.aud_ver_seq.InsertItem(0 , strAudVerSeq ,strAudVerSeq);	
			ComSetObjValue(opener.document.form.aud_ver_seq , strAudVerSeq);
			opener.searchForSave();			
			window.close();
		}
	}
	break;

	case IBCREATE:
		formObj.f_cmd.value = SEARCH01;		
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));
		sheetObj.WaitImageVisible = true;
		if ( sXml != "" ) {
			vLeaseTermCd = ComGetEtcData(sXml, "lease_term_cd");
			arryLeaseTermCd =  vLeaseTermCd.split("|");
		}

		sXml = "";
		formObj.f_cmd.value = SEARCH02;
		sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));		

		if ( sXml != "" ) {
			vCntrTpszCd = ComGetEtcData(sXml, "cntr_tpsz_cd");
			arryCntrTpszCd = vCntrTpszCd.split("|");
		}
		break;
	}
}

/**
* handling process for input validation
*/
function validateForm(sheetObj,formObj,sAction){
    with(sheetObj){
        with(formObj){
            switch(sAction){
            case IBSAVE:      //저장
                if(sheetObjects[0].RowCount == 0 ){                	
                	ComShowCodeMessage("LSE01048"); 
                	return false;
                }else if(verifyYN == "" || verifyYN == "N" ){
                	ComShowCodeMessage("LSE01084"); 
                	return false;
                }            
                return true;
            break; // case end
            }
        }        
    }
}            

/**
* handling process from file import
*/
function loadFile(){
	
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var strFilePath = sheetObject2.OpenFileDialog("*.txt");	
	if(strFilePath == "<USER_CANCEL>"){		
		return;
	}	
	var strIdx = strFilePath.lastIndexOf("\\");
	var strFileName = strFilePath.substr(strIdx + 1 );

	var arryFileName = strFileName.split(".");
	if(arryFileName != null){
		strFileName = arryFileName[0];
	}
	sheetObject1.RemoveAll();
	sheetObject2.RemoveAll();
	sheetObject2.LoadText(false , "" , strFilePath);

	var itmTxt = "";
	var contractNo = "";
	ComOpenWait(true);
	for (var i = 1 ; i <= sheetObject2.RowCount; i++ ){

		if(i == 1){			    	
			itmTxt = sheetObject2.CellValue(i,0);
			itmTxt.substr(0 , 3);  //vendor Code
			itmTxt.substr(3 ,14);  //Invoce No
			itmTxt.substr(17,15);  //Contract Reference Number

		}else{
			sheetObject1.DataInsert(-1);
			itmTxt = sheetObject2.CellValue(i,0);
			sheetObject1.CellValue2( i-1 , "contract_no" ) = strFileName;          //contract_no
			sheetObject1.CellValue2( i-1 , "cntr_no" )     = itmTxt.substr(0,11);  //Container No			    	
			sheetObject1.CellValue2( i-1 , "onh_dt" )      = itmTxt.substr(30,8);  //On-hire date
			sheetObject1.CellValue2( i-1 , "onh_loc_cd" )  = itmTxt.substr(38,5);  //onh_loc_cd
			sheetObject1.CellValue2( i-1 , "offh_dt" )     = itmTxt.substr(43,8);  //offh_dt
			sheetObject1.CellValue2( i-1 , "offh_loc_cd" ) = itmTxt.substr(51,5);  //offh_loc_cd

		}
	}
	document.form.ref_no.value = strFileName;
	ComOpenWait(false);
}

function loadExcelFile(){
	verifyYN = "";
	var sheetObject1 = sheetObjects[0];
	var lRow = 1
	if(sheetObject1.RowCount > 0){
	    lRow = sheetObject1.LastRow + 1;
	}
	var strFilePath = sheetObject1.OpenFileDialog("" , "");	
	if(strFilePath == "<USER_CANCEL>"){		
		return;
	}		
	var strIdx = strFilePath.lastIndexOf("\\");
	var strFileName = strFilePath.substr(strIdx + 1 );		
	var strNameIdx = strFileName.lastIndexOf(".");				
	strFileName = strFileName.substr(0 , strNameIdx );			
	var vAppendFlag = sheetObject1.LoadExcel(1, 1, strFilePath);		
	ComOpenWait(true);
	var strAgmtSeq  = "";
	var strAgmtSeqs = "";
	var iAgmtSeq    = 0;
	
 	for(var i = lRow  ; i <= sheetObject1.LastRow ; i++){
		sheetObject1.CellValue( i , "contract_no" ) = strFileName;	
		if(sheetObject1.CellValue( i , "agmt_no" ) != null && sheetObject1.CellValue( i , "agmt_no" ) != ""){
		   sheetObject1.CellValue( i , "agmt_cty_cd" ) = sheetObject1.CellValue( i , "agmt_no" ).substr(0,3);
		   strAgmtSeq  = sheetObject1.CellValue( i , "agmt_no" ).substr(3);
		   strAgmtSeq  = strAgmtSeq.trim(); 
           if(strAgmtSeq.length > 6){
        	   iAgmtSeq = Number(strAgmtSeq.substr(0,6));
           }else{
        	   iAgmtSeq = Number(strAgmtSeq);
           }
           
           sheetObject1.CellValue( i , "agmt_seq" )  = iAgmtSeq;
	    }
      
		if( strAgmtSeqs.indexOf(iAgmtSeq + "")  < 0 ){		
		    if(i == 1){
				strAgmtSeqs = iAgmtSeq + "";
		    }else{
				strAgmtSeqs = strAgmtSeqs + "," + iAgmtSeq;	    	
		    }
	    }
		sheetObject1.CellValue( i , "vndr_seq" ) = opener.document.form.vndr_seq.value;
	}
	document.form.ref_no.value      = strAgmtSeqs;	
	document.form.contract_no.value = sheetObject1.CellValue( 1 , "contract_no" );
	document.form.vndr_seq.value    = sheetObject1.CellValue( 1 , "vndr_seq" );
	ComOpenWait(false);
}

function loadFileVerify(){
	var cntrNo      = "";
	var cntrNo2     = "";
	var onhDt       = "";
	var onhLocCd    = "";
	var lstmCd      = "";
	var cntrTpszCd  = "";
	var lrOffhLocCd = "";
	var agmtNo      = "";

	//cntr_no validation
	var returnMsg = sheetObjects[0].ColValueDupRows("cntr_no");
	var arryIdx =  returnMsg.split(",");
	
	if(returnMsg != ""){
		ComShowCodeMessage("LSE01092");
		sheetObjects[0].SelectCell(arryIdx[0],"cntr_no");
		return;
	}
	
	for(var i = 1 ; i <= sheetObjects[0].LastRow ; i++){
		cntrNo      = sheetObjects[0].CellValue( i , "cntr_no" );
		onhDt       = sheetObjects[0].CellValue( i , "lr_onh_dt" );
		onhLocCd    = sheetObjects[0].CellValue( i , "lr_onh_loc_cd" );
		lstmCd      = sheetObjects[0].CellValue( i , "lstm_cd" );
		cntrTpszCd  = sheetObjects[0].CellValue( i , "cntr_tpsz_cd" );
		lrOffhLocCd = sheetObjects[0].CellValue( i , "lr_offh_loc_cd" );
		agmtNo      = sheetObjects[0].CellValue( i , "agmt_no" );				
		
		if(agmtNo.length == ""){
		    ComShowCodeMessage("LSE01006");
		    verifyYN = "N";
		    sheetObjects[0].SelectCell(i , "agmt_no");	
		    return ;
		}else if(agmtNo.length < 4){
			ComShowCodeMessage("LSE01039");
			verifyYN = "N";
			sheetObjects[0].SelectCell(i , "agmt_no");	
			return ;
		
		}else if(lstmCd.length == ""){
			ComShowCodeMessage("LSE01009");
			verifyYN = "N";
			sheetObjects[0].SelectCell(i , "lstm_cd");	
			return ;
		}else if(lstmCd.length > 2){
		    ComShowCodeMessage("LSE01056");
		    verifyYN = "N";
		    sheetObjects[0].SelectCell(i , "lstm_cd");	
		    return ;
	    }else if( cntrNo == null || cntrNo == "" ){
			ComShowCodeMessage("LSE01064");
			verifyYN = "N";
			sheetObjects[0].SelectCell(i , "cntr_no");	
			return ;
		}else if(cntrNo.length != 11){
			ComShowCodeMessage("LSE01074");
			verifyYN = "N";
			sheetObjects[0].SelectCell(i , "cntr_no");	
			return ;
		}else if(cntrTpszCd.length == ""){
			ComShowCodeMessage("LSE01015");
			verifyYN = "N";
			sheetObjects[0].SelectCell(i , "cntr_tpsz_cd");	
			return ;				
		}else if(cntrTpszCd.length > 2){
			ComShowCodeMessage("LSE01038");
			verifyYN = "N";
			sheetObjects[0].SelectCell(i , "cntr_tpsz_cd");	
			return ;
		}else if( onhDt == null || ComGetMaskedValue(onhDt, "ymd") == "" ){
			ComShowCodeMessage("LSE01020");
        	verifyYN = "N";
        	sheetObjects[0].SelectCell(i , "lr_onh_dt");	
        	return;        
		}else if( onhLocCd == null || onhLocCd == "" ){
        	ComShowCodeMessage("LSE01037");                
            verifyYN = "N";
            sheetObjects[0].SelectCell(i , "lr_onh_loc_cd");	
            return;       
     
        }
	}	
	
	verifyYN = "Y";
	ComShowCodeMessage("LSE01083");  
}

/* end of developer job */