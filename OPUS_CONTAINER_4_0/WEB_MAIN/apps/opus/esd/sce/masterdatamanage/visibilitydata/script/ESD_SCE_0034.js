var sheetObjects = new Array();
var sheetCnt = 0;

document.onclick = processButtonClick;

function processButtonClick(){

	var sheetObj = sheetObjects[0];
	var formObj  = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_retrieve":
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;

			case "btn_new":
				sheetObj.RemoveAll();
				formObj.reset();
				break;

	  		case "btn_downexcel":
				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
				break;
		}
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(getMsg('COM12111')) ;
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
				MergeSheet = msHeaderOnly;

				//Edit kind[, Default false]
				Editable = true;

				//setting Row information[HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, document.form.row_size.value);

				//setting Column information[COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(14, 3, 0, true);

				// setting function handling header
				InitHeadMode(true, true, false, true, false,false)

				var HeadTitle = "SEQ|Customer\nCode|S/C No.|Customer\nType|contient|sub\ncontient|country|POR/DEL|Location|Contact Person|Telephone No|E-Mail Address|Fax No.|Sendng Cycle" ;

				//setting function handling header Row[ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//Data attributes	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE,	   SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtSeq,		30,	daCenter,  true,	 "r_seq",			false,		  "",	   dfNone,   		0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  false,	"r_crm_cust_cd",	false,		  "",	   dfNone,	 	0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  true,	 "r_sn_no",		  false,		  "",	   dfNone,	 	0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  true,	 "r_cust_tp_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  true,	 "r_conti_cd",	   false,		  "",	   dfNone,	 	0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  true,	 "r_sconti_cd",	  false,		  "",	   dfNone,	 	0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  true,	 "r_cnt_cd",		 false,		  "",	   dfNone,	 	0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   60,	daCenter,  true,	 "por_del_div_cd",   false,		  "",	   dfNone,	 	0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   60,	daCenter,  true,	 "loc_cd",		   false,		  "",	   dfNone,  		0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	  120,	daLeft,	   false,	"cntc_pson_id",	 false,		  "",	   dfNone,		 0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  false,	"phn_no",		   false,		  "",	   dfNone,	 	0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	  120,	daCenter,  false,	"vis_eml",		  false,		  "",	   dfNone,	 	0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  false,	"fax_no",		   false,		  "",	   dfNone,	 	0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	 "snd_cyc_hr",	   false,		  "",	   dfNone,	 	0,	 false,	   false);

				style.height = GetSheetHeight(16) ;
		   }
			break;
	}
}

function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {

	   case IBSEARCH:
	   		formObj.f_cmd.value = SEARCHLIST ;
			sheetObj.DoSearch4Post("ESD_SCE_0034GS.do", SceFrmQryString(formObj))
			break ;

		case IBDOWNEXCEL:		// excel down
			sheetObj.SpeedDown2Excel();
			break;
	}
}

function sheet_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
    var formObj = document.form ;
    selectVal = SceFrmQryString(formObj);
    sheetObj.DoSearch4Post("ESD_SCE_0034GS.do", selectVal, "cur_page=" + PageNo, true);
}