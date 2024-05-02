/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SCE_9998.js
*@FileTitle : Bkg Cop Manage Admin
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

//Event handler processing by button click event */
document.onclick = processButtonClick;

//Event handler processing by button name */
function processButtonClick(){
	 var sheetObj = sheetObjects[0];
	 var formObj  = document.form;

	try{
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btns_calendar1":
				//cal = new calendarPopupFromTo();
				//cal.displayType = "date";
				//cal.select(formObj.bkg_cre_dt1, 'bkg_cre_dt1',formObj.bkg_cre_dt2, 'bkg_cre_dt2', 'yyyy-MM-dd');
				var cal = new ComCalendarFromTo();
				cal.displayType = "date";
				cal.select(formObj.fm_dt, formObj.to_dt, 'yyyy-MM-dd');						
			  break;
		
			case "btn_retrieve":
				ComClearSeparator(document.form.fm_dt);
				ComClearSeparator(document.form.to_dt);
				alert("tabCnt = " + tabCnt);
				//if(validateForm(sheetObj, formObj, IBSEARCH)){
					doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC16);
				//}
				break;

			case "btn_new":
				sheetObj.RemoveAll();
				formObj.reset();
				break;

			case "btn_downexcel":
				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
				break;
				
			case "btn_create":
				doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);
				break;	
				
			case "btn_update":
				doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC02);
				break;					
				
			case "btn_split":
				doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC03);
				break;
				
			case "btn_combine":
				doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC04);
				break;
				
			case "btn_cntrAttach":
				doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC09);
				break;
			case "btn_cntrDetach":
				doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC10);
				break;
				
			case "btn_moveCntr":
				doActionIBSheet(sheetObj,formObj, IBSEARCH_ASYNC11);
				break;
			case "btn_replan":
				doActionIBSheet(sheetObj,formObj, IBSEARCH_ASYNC12);
				break;
			case "btn_confirmTro":
				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC13);				
				break;
			case "btn_cntrCnfm":
				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC15);
				break;
			case "btn_genPc" :
				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC16);
		}
	}catch(e){
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111')) ;
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
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function loadPage() {

	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	 for(k=0;k<tabObjects.length;k++){
         initTab(tabObjects[k],k+1);
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

				//setting Host information[mandatory][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//setting kind of merge [selection, Default msNone]
				MergeSheet = msHeaderOnly;

				//setting allowed to edit부 [selection, Default false]
                Editable = false;

				//setting row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
				InitRowInfo( 1, 1, 9, 100);

				//setting column information [mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(15, 8, 0, true);

				// setting function handling header
                InitHeadMode(true, true, true, true, false, false);


				var HeadTitle0 = "Date|No|Vsl|Voy|Dir|Vps Port|Clpt|Node|COP No|Status|Err Msg|Cre Usr Id|Cre Dt|Upd Usr Id|Upd Dt" ;

				//setting header row information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);

				//setting property of data	[	ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,  	100,	daCenter,	true,	"act_rcv_dt",		false,		  "",	   dfNone,   	0,	 		false ,	   false );
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"act_rcv_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	70,	daCenter,	true,	"vsl_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	60,	daCenter,	true,	"skd_voy_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	40,	daCenter,	true,	"skd_dir_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	80,	daCenter,	true,	"vps_port_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	40,	daCenter,	true,	"clpt_ind_seq",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	80,	daCenter,	true,	"nod_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	120,	daCenter,	true,	"cop_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	60,		daCenter,	true,	"tml_if_dtl_sts_cd",	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		110,	daLeft	,	true,	"err_msg",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"cre_usr_id",			false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	  	100,	daCenter,	true,	"cre_dt",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"upd_usr_id",		false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	  	100,	daCenter,	true,	"upd_dt",			false,		  "",	   dfNone,   	0,	 		false,	   false);

				style.height = GetSheetHeight(20) ;
			//	DataLinkMouse = true;
		   }
			break;
			
			
		case 2:	  //IBSheet1 init
			with (sheetObj) {

				//setting width
                SheetWidth = mainTable.clientWidth;

				//setting host information [mandatory][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//setting kind of merge [selection, Default msNone]
				MergeSheet = msHeaderOnly;

				//setting allowed to edit [selection, Default false]
                Editable = false;

				//setting row information [mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
				InitRowInfo( 1, 1, 9, 100);

				//setting column information [mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(15, 8, 0, true);

				// setting function handling header
                InitHeadMode(true, true, true, true, false, false);


				var HeadTitle0 = "Date|No|Vsl|Voy|Dir|Vps Port|Clpt|Node|COP No|Status|Err Msg|Cre Usr Id|Cre Dt|Upd Usr Id|Upd Dt" ;

				//setting header row information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);

				//setting property of data	[	ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,  	100,	daCenter,	true,	"act_rcv_dt",		false,		  "",	   dfNone,   	0,	 		false ,	   false );
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"act_rcv_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	70,	daCenter,	true,	"vsl_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	60,	daCenter,	true,	"skd_voy_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	40,	daCenter,	true,	"skd_dir_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	80,	daCenter,	true,	"vps_port_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	40,	daCenter,	true,	"clpt_ind_seq",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	80,	daCenter,	true,	"nod_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	120,	daCenter,	true,	"cop_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	60,		daCenter,	true,	"tml_if_dtl_sts_cd",	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		110,	daLeft	,	true,	"err_msg",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"cre_usr_id",			false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	  	100,	daCenter,	true,	"cre_dt",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"upd_usr_id",		false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	  	100,	daCenter,	true,	"upd_dt",			false,		  "",	   dfNone,   	0,	 		false,	   false);

				style.height = GetSheetHeight(20) ;
			//	DataLinkMouse = true;
		   }
			break;
			
		case 3:	  //IBSheet1 init
			with (sheetObj) {

				//setting width
                SheetWidth = mainTable.clientWidth;

				//setting host information [mandatory][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//setting kind of merge [selection, Default msNone]
				MergeSheet = msHeaderOnly;

				//setting allowed to edit [selection, Default false]
                Editable = false;

				//setting row information [mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
				InitRowInfo( 1, 1, 9, 100);

				//setting column information [mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(15, 8, 0, true);

				// setting function handling header
                InitHeadMode(true, true, true, true, false, false);


				var HeadTitle0 = "Date|No|Vsl|Voy|Dir|Vps Port|Clpt|Node|COP No|Status|Err Msg|Cre Usr Id|Cre Dt|Upd Usr Id|Upd Dt" ;

				//setting header information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);

				//setting property of data	[	ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,  	100,	daCenter,	true,	"act_rcv_dt",		false,		  "",	   dfNone,   	0,	 		false ,	   false );
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"act_rcv_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	70,	daCenter,	true,	"vsl_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	60,	daCenter,	true,	"skd_voy_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	40,	daCenter,	true,	"skd_dir_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	80,	daCenter,	true,	"vps_port_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	40,	daCenter,	true,	"clpt_ind_seq",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	80,	daCenter,	true,	"nod_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	120,	daCenter,	true,	"cop_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	60,		daCenter,	true,	"tml_if_dtl_sts_cd",	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		110,	daLeft	,	true,	"err_msg",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"cre_usr_id",			false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	  	100,	daCenter,	true,	"cre_dt",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"upd_usr_id",		false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	  	100,	daCenter,	true,	"upd_dt",			false,		  "",	   dfNone,   	0,	 		false,	   false);

				style.height = GetSheetHeight(20) ;
			//	DataLinkMouse = true;
		   }
			break;
			
		case 4:	  //IBSheet1 init
			with (sheetObj) {

				//setting width
                SheetWidth = mainTable.clientWidth;

				//setting host information [mandatory][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//setting kind of merge [mandatory, Default msNone]
				MergeSheet = msHeaderOnly;

				//setting allowed to edit. [selection, Default false]
                Editable = false;

				//setting row information [mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
				InitRowInfo( 1, 1, 9, 100);

				//setting column information [mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(15, 8, 0, true);

				// setting function handling header
                InitHeadMode(true, true, true, true, false, false);


				var HeadTitle0 = "Date|No|Vsl|Voy|Dir|Vps Port|Clpt|Node|COP No|Status|Err Msg|Cre Usr Id|Cre Dt|Upd Usr Id|Upd Dt" ;

				//setting header row information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);

				//setting property of data	[	ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,  	100,	daCenter,	true,	"act_rcv_dt",		false,		  "",	   dfNone,   	0,	 		false ,	   false );
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"act_rcv_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	70,	daCenter,	true,	"vsl_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	60,	daCenter,	true,	"skd_voy_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	40,	daCenter,	true,	"skd_dir_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	80,	daCenter,	true,	"vps_port_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	40,	daCenter,	true,	"clpt_ind_seq",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	80,	daCenter,	true,	"nod_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	120,	daCenter,	true,	"cop_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	60,		daCenter,	true,	"tml_if_dtl_sts_cd",	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		110,	daLeft	,	true,	"err_msg",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"cre_usr_id",			false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	  	100,	daCenter,	true,	"cre_dt",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"upd_usr_id",		false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	  	100,	daCenter,	true,	"upd_dt",			false,		  "",	   dfNone,   	0,	 		false,	   false);

				style.height = GetSheetHeight(20) ;
			//	DataLinkMouse = true;
		   }
			break;
			
		case 5:	  //IBSheet1 init
			with (sheetObj) {

				//setting width
                SheetWidth = mainTable.clientWidth;

				//setting host infromation [mandatory][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//setting kind of merge [selection, Default msNone]
				MergeSheet = msHeaderOnly;

				//setting allowed to edit. [selection, Default false]
                Editable = false;

				//setting row information [mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
				InitRowInfo( 1, 1, 9, 100);

				//setting column information [mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(15, 8, 0, true);

				// setting function handling header
                InitHeadMode(true, true, true, true, false, false);


				var HeadTitle0 = "Date|No|Vsl|Voy|Dir|Vps Port|Clpt|Node|COP No|Status|Err Msg|Cre Usr Id|Cre Dt|Upd Usr Id|Upd Dt" ;

				//setting header row information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);

				//setting property of data	[	ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,  	100,	daCenter,	true,	"act_rcv_dt",		false,		  "",	   dfNone,   	0,	 		false ,	   false );
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"act_rcv_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	70,	daCenter,	true,	"vsl_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	60,	daCenter,	true,	"skd_voy_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	40,	daCenter,	true,	"skd_dir_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	80,	daCenter,	true,	"vps_port_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	40,	daCenter,	true,	"clpt_ind_seq",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	80,	daCenter,	true,	"nod_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	120,	daCenter,	true,	"cop_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	60,		daCenter,	true,	"tml_if_dtl_sts_cd",	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		110,	daLeft	,	true,	"err_msg",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"cre_usr_id",			false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	  	100,	daCenter,	true,	"cre_dt",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"upd_usr_id",		false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	  	100,	daCenter,	true,	"upd_dt",			false,		  "",	   dfNone,   	0,	 		false,	   false);

				style.height = GetSheetHeight(20) ;
			//	DataLinkMouse = true;
		   }
			break;
	}
}

 
    
  // setting process of the sheet.
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false ;

	switch(sAction) {
		case IBSEARCH:	  //retrieving 
//			formObj.f_cmd.value = MULTI01 ;
//			sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
	
			break;

	   case IBDOWNEXCEL:
//			  formObj.f_cmd.value = MULTI01 ;
//			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;
	   case IBSEARCH_ASYNC01: // booking create
			  formObj.f_cmd.value = MULTI01 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;
			  
	   case IBSEARCH_ASYNC02: // booking update
			  formObj.f_cmd.value = MULTI02 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;			  
	   
	   case IBSEARCH_ASYNC03: // booking split
			  formObj.f_cmd.value = MULTI03 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;
	   case IBSEARCH_ASYNC04: // booking combine
			  formObj.f_cmd.value = MULTI04 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;
	   case IBSEARCH_ASYNC03: // booking cancel 
			  formObj.f_cmd.value = MULTI05 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;	
	   case IBSEARCH_ASYNC09: // attach container
			  formObj.f_cmd.value = MULTI09 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;
	   case IBSEARCH_ASYNC10: // attach container
			  formObj.f_cmd.value = MULTI10 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;
	   case IBSEARCH_ASYNC11: // move container
			  formObj.f_cmd.value = MULTI11 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;			
	   case IBSEARCH_ASYNC12: // replan
			  formObj.f_cmd.value = MULTI12 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;
	   case IBSEARCH_ASYNC13: // tro confirm
			  formObj.f_cmd.value = MULTI13 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;
	   case IBSEARCH_ASYNC14: // tro unconfirm
			  formObj.f_cmd.value = MULTI14 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;
	   case IBSEARCH_ASYNC15: // tro unconfirm
			  formObj.f_cmd.value = MULTI15 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;	
	   case IBSEARCH_ASYNC16: // Terminal change 결과 조회
			  formObj.f_cmd.value = MULTI16 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;			  
	}
}


/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
    var result = true;
	if(sAction == IBSEARCH) {
		// checing input the search option
		if( !isInputField(formObj) ) {
			result = false ;
		//} else if( !ComIsEmpty(formObj.bkg_no) && !ComChkObjValid(formObj.bkg_no, 11, "BKG No")) { // BKG No
	    } else if( !ComIsEmpty(formObj.bkg_no) && ! ComChkObjValid(formObj.bkg_no, 11, "BKG No")) { // BKG No		
			result = false ;
		//} else if( !ComIsEmpty(formObj.bkg_no_split) && !ComChkObjValid(formObj.bkg_no_split, 2, "BKG No Split") ) { // BKG NO Split
		//	result = false ;
		} else if( !ComIsEmpty(formObj.bl_no) && !ComChkObjValid(formObj.bl_no, 12, "BL No") ) { // BL No
			result = false ;
		} else if( !ComIsEmpty(formObj.cntr_no) && !ComChkObjValid(formObj.cntr_no, 11, "Container No") ) { // Container No
			result = false ;
		} else if( !ComIsEmpty(formObj.cop_no) && !ComChkObjValid(formObj.cop_no, 14, "COP No") ) { // Cop No
			result = false ;
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

function sheet1_OnSearchEnd(sheetObj) {
	var totalCnt = sheetObj.CellValue(3, "totcnt");
	
	if(sheetObj.TotalRows > 0){
		sheetObj.TotalRows = totalCnt;
	}
	ComAddSeparator(document.form.fm_dt, "-");
	ComAddSeparator(document.form.to_dt, "-");
}


function sheet1_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
	var formObj = document.form ;
	selectVal = SceFrmQryString(formObj);
	sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", selectVal, "cur_page=" + PageNo, true);
}

function ComChkObjValid(obj, len, msg) {
	var result = true ;

	if(getLenByByte(obj.value)!==len){
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

function CheckDigit(obj){
    var rtnval = cntrCheckDigit(obj);
    obj.value  = rtnval;
}

// setting checkDigit of container No.
function CheckDigitSplit( obj, bitTarget, valueTarget){
	var cntrNo = obj.value;
	if (cntrNo.length < 10){
		document.getElementById(bitTarget).value = '';
		document.getElementById(valueTarget).value = cntrNo;
		return;
	}
	ComChkObjValid(obj, 'eng_num', true, 10);
	var sum = 0;
 	cntrNo = cntrNo.toUpperCase();

	//for(var i=0;i<10;i++){
	//	sum = sum + ComGetCntrChkDgt( cntrNo.charAt(i),i);
	//}
	sum = ComGetCntrChkDgt( cntrNo.substr(0,10));
 
	var mod = sum % 11;

	if (mod == 10) mod =0;

	if( isNaN(mod)){
		document.getElementById(bitTarget).value = '';
		document.getElementById(valueTarget).value = obj.value;
	}else{
		obj.value = 	cntrNo.substr(0,10);		
		document.getElementById(bitTarget).value = mod;
		document.getElementById(valueTarget).value = obj.value + mod;
	}
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

/**
 * registering IBTab Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setTabObject(tab_obj){

    tabObjects[tabCnt++] = tab_obj;

}

 /**
  * initializing Tab
  * setting Tab items
  */
function initTab(tabObj , tabNo) {

     var cnt  = 0 ;

     switch(tabNo) {
         case 1:
            with (tabObj) {
                InsertTab( cnt++, "TmlChgRslt" , -1 );
                InsertTab( cnt++, "CopReplan Fail" , -1 );
                InsertTab( cnt++, "MST_COP_NO Diff" , -1 );
                InsertTab( cnt++, "CntrDiff" , -1 );
                InsertTab( cnt++, "TRO Val" , -1 );
            }
         break;

    }
}

/**
 * Event when clicking Tab
 * activating selected tab items
 */
function tab1_OnChange(tabObj , nItem)
{


    var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	//--------------- important --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	//------------------------------------------------------//
	beforetab= nItem;

}