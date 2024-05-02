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
				doActionIBSheet(sheetObj,formObj,IBCLEAR);
				break;
			case "btn_save":
				doActionIBSheet(sheetObj,formObj,IBSAVE);
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;
	  		case "btn_downexcel":
				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
				break;
    	    case "btns_calendar":
				//var cal = new calendarPopupFromTo();
        		//cal.select(formObj.act_dt1, 'act_dt1',formObj.act_dt2, 'act_dt2', 'yyyy-MM-dd');
				var cal = new ComCalendarFromTo();
				cal.displayType = "date";
				cal.select(formObj.act_dt1, formObj.act_dt2, 'yyyy-MM-dd');
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
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {

    var cnt = 0;

    switch(sheetNo) {
        case 1:      //IBSheet1 init
            with (sheetObj) {
                //setting width
                SheetWidth = mainTable.clientWidth;
                //setting host information[mandatory][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //setting kind of merge [selection, Default msNone]
                MergeSheet = msHeaderOnly;

                //setting allowed edit [selection, Default false]
                Editable = true;

                //setting row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 9, 100);

                //setting column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(7, 7, 0, true);

                // setting function handling header
                InitHeadMode(true, true, true, true, false, false)

                var HeadTitle0 = "Del|From|To|Subject|Note|Date" ;

                //setting header row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle0, true);


                //setting data property    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox, 40, 	  daCenter,  true, 	  "chk", 			false, 			"", 	  dfNone, 		0, 	   true, 		true);//check box
                InitDataProperty(0, cnt++ , dtData,	   90,    daCenter,  true,    "fm_m",     false,          "",       dfNone,		0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,	   160,    daCenter,  true,    "to_m",     	false,          "",       dfNone,     	0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,	   160,    daCenter,  true,    "sbjt",	false,          "",       dfNone,     	0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,    550,    daLeft,  true,    "note",     		false,          "",       dfNone,     	0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,	  100,    daCenter,  true,    "noti_date",     	false,          "",       dfNone,     	0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,	  0,    daCenter,  true,    "cop_expt_subsc_cs_seq",     	false,          "",       dfNone,     	0,     false,       true);

//                InitDataProperty(0, cnt++ , dtHidden,	  0,    daCenter,  true,    "ACT_RCV_DT",     	false,          "",       dfNone,     	0,     false,       true);
//                InitDataProperty(0, cnt++ , dtHidden,	  0,    daCenter,  true,    "ACT_RCV_NO",     	false,          "",       dfNone,     	0,     false,       true);

                style.height = GetSheetHeight(16) ;


           }
            break;

    }
}

//function sheet_OnDblClick(sheetObj, row, col, value) {
//	openESD_SCE_070(sheetObj);
//}
//function openESD_SCE_070(sheetObj){
//
//	var row = sheetObj.SelectRow  ;
//	var r_copNo = sheetObj.CellValue(row, "COP_NO") ;
//	var r_bkgRcvNo = sheetObj.CellValue(row, "BKG_RCV_NO") ;
//	var r_bkgRcvDt = sheetObj.CellValue(row, "BKG_RCV_DT") ;
//	var newWin  = window.open("ESD_SCE_070.do?f_cmd=3&cop_no="+r_copNo+"&bkg_rcv_no="+r_bkgRcvNo+"&bkg_rcv_dt="+r_bkgRcvDt,"aaa", "width=1000,height=350" );
//}


function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:	  //retrieving
			if( validateForm(formObj) ){
	            formObj.f_cmd.value = SEARCHLIST;
	            formObj.target = "_self" ;
	            sheetObj.DoSearch4Post("ESD_SCE_0076GS.do", SceFrmQryString(formObj));
            }
			break;
		case IBDOWNEXCEL:		// excel down
				sheetObj.SpeedDown2Excel();
			break;
		case IBCLEAR:
				sheetObj.RemoveAll();
				formObj.reset();
			break;
		case IBSAVE:
				if( sheetObj.CheckedRows("chk") < 1 ) {
					ComShowMessage("Please select at least one.");
					return false;
				} else {
					if( confirm("Are you sure you want to proceed?") ) {
						formObj.f_cmd.value = MODIFY01;
						sheetObj.DoSave("ESD_SCE_0076GS.do", SceFrmQryString(formObj), "chk", false, true);
//						formObj.f_cmd.value = SEARCHLIST;
//			            formObj.target = "_self" ;
//			            sheetObj.DoSearch4Post("ESD_SCE_076GS.do", SceFrmQryString(formObj));
					}
				}

			break;
	}
}

function validateForm(formObj){
	var result = true ;

	with(formObj){
		if(!ComIsDate(formObj.act_dt1)){
	        ComShowMessage(ComGetMsg('SCE90003','Duration')) ;
	        formObj.act_dt1.focus() ;
	        result = false ;
	    }
	    else if(!ComIsDate(formObj.act_dt2)){
	    	ComShowMessage(ComGetMsg('SCE90003','Duration')) ;
	        formObj.act_dt2.focus() ;
	        result = false ;
	    }
	}

	return result;
}
function sheet_OnMouseMove(sheetObj,buttonValue, shiftValue, x_pos, y_pos)
{
     if(sheetObj.MouseCol == sheetObj.SaveNameCol("NOTE") || sheetObj.MouseCol == sheetObj.SaveNameCol("SBJT")){


              //setting mouse pointer
//            sheetObj.MousePointer = "Default";  //default mouse pointer
              sheetObj.MousePointer = "Hand";     //hand

              if(sheetObj.MouseCol == sheetObj.SaveNameCol("NOTE")) sText = sheetObj.CellText(sheetObj.MouseRow,"NOTE");
              else if(sheetObj.MouseCol == sheetObj.SaveNameCol("SBJT")) sText = sheetObj.CellText(sheetObj.MouseRow,"SBJT");
              //handling help
          	  sheetObj.ToolTipText(sheetObj.MouseRow,sheetObj.MouseCol)  = sText;
     }

}

//function sheet1_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
//    var formObj = document.form ;
//    selectVal = SceFrmQryString(formObj);
//    sheetObj.DoSearch4Post("ESD_SCE_046GS.do", selectVal, "cur_page=" + PageNo, true);
//}
