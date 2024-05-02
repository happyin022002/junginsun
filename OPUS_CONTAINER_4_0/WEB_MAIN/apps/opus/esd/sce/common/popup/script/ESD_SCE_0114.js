/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : CESD_SCE_0114.js
*@FileTitle : Exception Inquiry/Office Mapping 
**Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0

=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    OTHER CASE  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

 var sheetObjects = new Array();
var sheetCnt = 0;
var selRow = 0;
var selCol = 0;
var selOfc = "";

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
 
function loadPage() {
	var dist=document.form.dist.value;
/*
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1,dist);

		ComEndConfigSheet(sheetObjects[i]);
	}
*/
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1,dist);
            ComEndConfigSheet(sheetObjects[i]);
        }

        var sheetObject = sheetObjects[0];
        var formObject = document.form;
      	doActionIBSheet(sheetObject,formObject,IBSEARCH);
}

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
function processButtonClick(){
	var sheetObject = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
        switch(srcName) {

    	    case "btn_retrieve":
    	    	//if( validateForm(formObject) ){
		            doActionIBSheet(sheetObject,formObject,IBSEARCH);
		        //}
    	        break;

    	    case "btn_new":
	            sheetObject.RemoveAll();
	            formObject.reset();
    	        break;

            case "btn_close":
	            self.close();
    	        break;

			case "btn_ok":
				PopupOK(sheetObject, formObject);
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
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo,dist) {
    var cnt = 0;

    switch(sheetNo) {
        case 1:      //IBSheet1 init
                with (sheetObj) {
                    // setting height
                    style.height = GetSheetHeight(10) ;
                    //setting width
                    SheetWidth = mainTable.clientWidth;

                    //setting Host information[HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //Merge kind[, Default msNone]
                    MergeSheet = msNone;

                    //Edit kind[, Default false]
                    Editable = true;

                    //setting Row information[HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 50);

                    //setting Column information[COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(6, 0, 0, true);

                    // setting function handling header
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|SEQ|Office|Mapping Office|Mapping Office Name|Mapping Location" ;


                    //setting function handling header Row[ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //Data attributes    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

	                InitDataProperty(0, cnt++ , dtRadioCheck,  30,    daCenter,  false,    "check",        false,          "",       dfNone,   	0,     true,       true);
	                InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,	    100,	daLeft,	true,	"ofc_cd",     false,          "",       dfNone,   	0,			false,       true);
					InitDataProperty(0, cnt++ , dtData,		100,	    daLeft,	false,	"mapg_ofc_cd", false,          "",       dfNone,   	0,			false,       true,		300);
					InitDataProperty(0, cnt++ , dtData,			250,	daLeft,		true,	"mapg_ofc_eng_nm",		false,          "",       dfEngKey,   0,			false,       true,		300);
                    InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		true,	"loc_cd",	false,          "",       dfEngKey,	0,			false,       true,		500);
               }
            break;
        case 9:      //IBSheet1 init
                with (sheetObj) {
                    // setting height
                    style.height = GetSheetHeight(10) ;
                    //setting width
                    SheetWidth = mainTable.clientWidth;

                    //setting Host information[HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //Merge kind[, Default msNone]
                    MergeSheet = msNone;

                    //Edit kind[, Default false]
                    Editable = true;

                    //setting Row information[HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 50);

                    //setting Column information[COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(6, 0, 0, true);

                    // setting function handling header
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|SEQ|Office|Mapping Office|Mapping Office Name|Mapping Location" ;


                    //setting function handling header Row[ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //Data attributes    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

	                InitDataProperty(0, cnt++ , dtRadioCheck,  30,    daCenter,  false,    "check",        false,          "",       dfNone,   	0,     true,       true);
	                InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,	    100,	daLeft,	true,	"ofc_cd",     false,          "",       dfNone,   	0,			false,       true);
					InitDataProperty(0, cnt++ , dtData,		100,	    daLeft,	false,	"mapg_ofc_cd", false,          "",       dfNone,   	0,			false,       true,		300);
					InitDataProperty(0, cnt++ , dtData,			250,	daLeft,		true,	"mapg_ofc_eng_nm",		false,          "",       dfEngKey,   0,			false,       true,		300);
                    InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		true,	"loc_cd",	false,          "",       dfEngKey,	0,			false,       true,		500);

 

           }
            break;

    }
}

function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case IBSEARCH:      
			formObj.f_cmd.value = SEARCH05;

			//delHypen(formObj.sdate);
			//delHypen(formObj.edate);
			sheetObj.DoSearch4Post("ESD_SCE_0114GS.do", SceFrmQryString(formObj));
			break;
	   case IBDOWNEXCEL:        
		  sheetObj.Down2Excel(-1, false, false, true);
		  break;

	}
}

/**
 * handling process for input validation
 */
/*--
function validateForm(formObj){
    with(formObj){
 	    if(formObj.sdate.value=="" || formObj.edate.value=="") {
  	        ComShowMessage("You must input period");

  	        if(formObj.sdate.value=="" || !chkDateValue(formObj.sdate.value) )  {
  	          //setFocus(formObj.sdate);
  	          formObj.sdate.focus() ;
  	          return false;
  	        }

  	        if(formObj.edate.value=="" || !chkDateValue(formObj.edate.value) ) {
  	          //setFocus(formObj.edate);
  	          formObj.edate.focus() ;
  	          return false;
  	        }
  	    }

  	    if( formObj.seletad.value == "ETA" ){
	  	    if(formObj.selpod.value=="") {
	  	        ComShowMessage("You must input POD");
	  	        //setFocus(formObj.selpod);
	  	        formObj.selpod.focus() ;
	  	        return false;
	  	    }
  	    } else{
	  	    if(formObj.selpol.value=="") {
	  	        ComShowMessage("You must input POL");
	  	        //setFocus(formObj.selpol);
	  	        formObj.selpol.focus() ;
	  	        return false;
	  	    }
  	    }

    }
    return true;

}
--*/

// Office POPUP OK button click &&&
function PopupOK(sheetObj, formObject){

	var rcc_val	   = "";	// Target Object  set
	var lcc_val	   = "";

	var rows = sheetObj.Rows;
	var iCheckRow = sheetObj.CheckedRows("check");

	if(rows==1 && iCheckRow == 0) {
		return null;
	}else if(rows > 1 && iCheckRow == 0) {
		ComShowMessage("Please check row") ;
		return null;
	}else {
		var ik = 0;
		for(var i = 0; i < rows; i++) {
			if(sheetObj.CellValue(i, "check") == 1) {
	  			if(ik == 0) {
	  				mstofc_val = sheetObj.CellValue(i, "ofc_cd");

	  			} else {
	  				mstofc_val = mstofc_val + "," + sheetObj.CellValue(i, "ofc_cd");
                }
                ik++;
     		}
  		}
	}

//  	opener.mst_ofc_code(mstofc_val);
	window.returnValue = mstofc_val;
  	self.close();
}

// Office popup &&&
function openOfcPopUp(multi, dist){
	var addpara = '&txtmstofccd='+document.form.mst_ofc_cd.value;
	var newWin = window.showModalDialog("ESD_SCE_0113.do?dist="+dist+addpara, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:600px;dialogHeight:600px");
//	window.open ("ESD_SCE_0113.do?dist="+dist+addpara, "list", "scrollbars=no,fullscreen=no,width=600,height=600");
}

// ESD_SCE_0113.js in the function call from the master office code Popup &&&
function popmst_ofc_code(strval) {
	document.form.mst_ofc_cd.value = strval;
}

