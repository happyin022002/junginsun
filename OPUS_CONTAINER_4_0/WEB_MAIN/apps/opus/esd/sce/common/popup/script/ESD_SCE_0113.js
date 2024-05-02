/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : CESD_SCE_0113.js
*@FileTitle : Exception Office Mapping/Office Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                      COMMAND01=11; ~ COMMAND20=30;
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
                    if(dist=="popmstofccd"){
                        var HeadTitle = "|SEQ|Office|Office Name|Location" ;
                    }else if(dist=="mstofccd"){
                        var HeadTitle = "|SEQ|Office|Office Name|Location" ;
                    }else if(dist=="mapgofccd"){
                        var HeadTitle = "|SEQ|Office|Office Name|Location" ;
                    }

                    //setting function handling header Row[ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //Data attributes    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					if(dist=="popmstofccd"){
	                    InitDataProperty(0, cnt++ , dtRadioCheck,  30,    daCenter,  false,    "check",        false,          "",       dfNone,   	0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     false,       true);                    
                        InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "ofc_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      200,    daCenter,  false,    "ofc_eng_nm",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "loc_cd",        false,          "",       dfNone,       0,     false,       true);
                    	InitDataProperty(0, cnt++ , dtHidden,      10,    daCenter,  true,    "mst_ofc_cd",        false,          "",       dfNone,       0,     false,       false);
					}else if(dist=="mstofccd"){
	                    InitDataProperty(0, cnt++ , dtRadioCheck,  30,    daCenter,  false,    "check",        false,          "",       dfNone,   	0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     false,       true);                    
                        InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "ofc_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      200,    daCenter,  false,    "ofc_eng_nm",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "loc_cd",        false,          "",       dfNone,       0,     false,       true);
                    	InitDataProperty(0, cnt++ , dtHidden,      116,    daCenter,  true,    "mst_ofc_cd",        false,          "",       dfNone,       0,     false,       false);
                    }else if(dist=="mapgofccd"){
	                    InitDataProperty(0, cnt++ , dtCheckBox,  30,    daCenter,  false,    "check",        false,          "",       dfNone,   	0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     false,       true);                    
                        InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "ofc_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      200,    daCenter,  false,    "ofc_eng_nm",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "loc_cd",        false,          "",       dfNone,       0,     false,       true);
                    	InitDataProperty(0, cnt++ , dtHidden,      116,    daCenter,  true,    "mapg_ofc_cd",        false,          "",       dfNone,       0,     false,       false);
                    }               
                    


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
                if(dist=="popmstofccd"){
                    var HeadTitle = "|SEQ|Office|Office Name|Location" ;
                }else if(dist=="mstofccd"){
                    var HeadTitle = "|SEQ|Office|Office Name|Location" ;
                }else if(dist=="mapgofccd"){
                    var HeadTitle = "|SEQ|Office|Office Name|Location" ;
                }

                //setting function handling header Row[ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, false);

                //Data attributes    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtCheckBox,  30,    daCenter,  false,    "check",        false,          "",       dfNone,   	0,     true,       true);
                InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     false,       true);
                    if(dist=="popmstofccd"){
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "ofc_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "ofc_eng_nm",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "loc_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      116,    daCenter,  true,    "mst_ofc_cd",        false,          "",       dfNone,       0,     false,       false);
                    }else if(dist=="mstofccd"){
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "ofc_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "ofc_eng_nm",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "loc_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      116,    daCenter,  true,    "mst_ofc_cd",        false,          "",       dfNone,       0,     false,       false);
                    }else if(dist=="mapgofccd"){
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "ofc_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "ofc_eng_nm",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "loc_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      116,    daCenter,  true,    "mapg_ofc_cd",        false,          "",       dfNone,       0,     false,       false);
                    }  
                

           }
            break;

    }
}

function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case IBSEARCH:      
			formObj.f_cmd.value = SEARCH04;

			//delHypen(formObj.sdate);
			//delHypen(formObj.edate);
			sheetObj.DoSearch4Post("ESD_SCE_0113GS.do", SceFrmQryString(formObj));
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


function PopupOK(sheetObj, formObject){

	var rcc_val	   = "";	
	var lcc_val	   = "";
	
	var rows = sheetObj.Rows;
	var iCheckRow = sheetObj.CheckedRows("check");
	//var dist = sheetObj.ColSaveName(5);	
	var dist=document.form.dist.value;
	var opener = window.dialogArguments;
	
	if(rows==1 && iCheckRow == 0) {
		return null;
	}else if(rows > 1 && iCheckRow == 0) {
		ComShowMessage("Please check row") ;
		return null;
	}
	else {
		var ik = 0;
  		if(dist=="popmstofccd"){
			for(var i = 0; i < rows; i++) {
				if(sheetObj.CellValue(i, "check") == 1) {
		  			if(ik == 0) {
		  				popmstofc_val = sheetObj.CellValue(i, "ofc_cd");
	
		  			} else {
		  				popmstofc_val = popmstofc_val + "," + sheetObj.CellValue(i, "ofc_cd");
	                }
	                ik++;
	     		}
	  		}
		}else if(dist=="mstofccd"){
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
		}else if(dist=="mapgofccd"){
			for(var i = 0; i < rows; i++) {
				if(sheetObj.CellValue(i, "check") == 1) {
		  			if(ik == 0) {
		  				mapgofc_val = sheetObj.CellValue(i, "ofc_cd");
		  				mapgofcnm_val = sheetObj.CellValue(i, "ofc_eng_nm");
		  				mapgloccd_val = sheetObj.CellValue(i, "loc_cd");
	
		  			} else {
		  				mapgofc_val = mapgofc_val + "," + sheetObj.CellValue(i, "ofc_cd");
		  				mapgofcnm_val = mapgofcnm_val + "|" + sheetObj.CellValue(i, "ofc_eng_nm");
		  				mapgloccd_val = mapgloccd_val + "," + sheetObj.CellValue(i, "loc_cd");		  				
	                }
	                ik++;
	     		}
	  		}		
		}							
  	}
  	
  	if(dist=="popmstofccd"){
  	  	opener.popmst_ofc_code(popmstofc_val);
  	}else if(dist=="mstofccd"){
   	  	opener.mst_ofc_code(mstofc_val); 	  	  	   	  	
  	}else if(dist=="mapgofccd"){
   	  	opener.mapg_ofc_code(mapgofc_val,mapgofcnm_val,mapgloccd_val,iCheckRow); 	  	  	   	  	
  	}
  	self.close();

}