
var sheetObjects = new Array();
var sheetCnt = 0;
var sheetObject = null;

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
    function processButtonClick(){
          sheetObject = sheetObjects[0];
         var formObject = document.form;

    		 var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

              case "btn_retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);

                    break;

        	    case "btn_save":
    	          doActionIBSheet(sheetObject,formObject,IBSAVE);
        	        break;

    					case "btn_new":
    						sheetObject.RemoveAll();
    						formObject.reset();
    						break;

          	    case "btn_downexcel":
        	       doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
        	        break;

							case "btng_rowadd":
								doActionIBSheet(sheetObject,formObject,IBINSERT);
								break;
            } // end switch
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
    //document.all['h_expt_tp'].selectedIndex = document.form.expt_tp_selected_idx.value;

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
            case 1:      //IBSheet1 init
                with (sheetObj) {

	                style.height = GetSheetHeight(15);

                    //setting width
                    SheetWidth = mainTable.clientWidth;

                    //setting Host information[HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //Merge kind[, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //Edit kind[, Default false]
                    Editable = true;

                    //setting Row information[HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //setting Column information[COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(25, 0, 0, true);

                    // setting function handling header
                    //InitHeadMode(true, true, false, true, false,false);
                    InitHeadMode(true, true, true, true, false,false);

                    var HeadTitle = "|Del|Seq|Exception Type|Exception Type Detail|From-Activity|To-Activity|Subscriber Group|Notification Party|User ID|Updated Date|Active" ;

                    //setting function handling header Row[ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //Data attributes    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]


										InitDataProperty(0, cnt++ , dtHiddenStatus,	0,	daCenter,  false,		"r_ibflag",		          false,		  "",	    dfNone,   	0,	   true,	   true);
										InitDataProperty(0, cnt++ , dtDelCheck,     0,  daCenter,  false,   "sDelCheck",              false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtSeq,          0,  daCenter,  true,    "r_seq",                  false,          "",       dfNone,   	0,     true,       true);
										InitDataProperty(0, cnt++ , dtCombo,        0,  daLeft,    true,    "r_expt_tp",              false,          "",       dfNone,   	0,     false,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      150,  daLeft,    true,    "r_expt_tp_dtl",          false,          "",       dfNone,     0,     false,      true);
                    InitDataProperty(0, cnt++ , dtCombo,        0,  daLeft,    true,    "r_fm_act",               false,          "",       dfNone,     0,     false,      true);
                    InitDataProperty(0, cnt++ , dtCombo,        0,  daLeft,    true,    "r_to_act",               false,          "",       dfNone,     0,     false,      true);
                    InitDataProperty(0, cnt++ , dtCombo,        0,  daLeft,    true,    "r_subseq_grp",           false,          "",       dfNone,   	0,     true,       true);
										InitDataProperty(0, cnt++ , dtCombo,        0,  daLeft,    false,   "r_noti_prty",            false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,         0,  daCenter,  true,    "r_usr_id",               false,          "",       dfNone,     0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,         0,  daCenter,  true,    "r_upd_dt",               false,          "",       dfNone,     0,     false,      true);
										InitDataProperty(0, cnt++ , dtCombo,        0,  daCenter,  true,    "r_act",                   true,          "",       dfNone,     0,     true,       true);
										InitDataProperty(0, cnt++ , dtHidden,       0,  daCenter,  true,    "fm_act_desc",            false,          "",       dfNone,     0,     true,       true);
										InitDataProperty(0, cnt++ , dtHidden,       0,  daCenter,  true,    "to_act_desc",            false,          "",       dfNone,     0,     true,       true);
										InitDataProperty(0, cnt++ , dtHidden,       0,  daCenter,  true,    "cop_expt_tp_nm",         false,          "",       dfNone,     0,     true,       true);
										InitDataProperty(0, cnt++ , dtHidden,       0,  daCenter,  true,    "cop_expt_tp_dtl_nm",     false,          "",       dfNone,     0,     true,       true);
										InitDataProperty(0, cnt++ , dtHidden,       0,  daCenter,  true,    "cop_expt_tp_dtl_desc",   false,          "",       dfNone,     0,     true,       true);
										InitDataProperty(0, cnt++ , dtHidden,       0,  daCenter,  true,    "cop_expt_subsc_grp_nm",  false,          "",       dfNone,     0,     true,       true);
										InitDataProperty(0, cnt++ , dtHidden,       0,  daCenter,  true,    "subsc_grp_ntfd_pty_nm",  false,          "",       dfNone,     0,     true,       true);
										InitDataProperty(0, cnt++ , dtHidden,       0,  daCenter,  true,    "cop_expt_tp_desc",       false,          "",       dfNone,     0,     true,       true);
										InitDataProperty(0, cnt++ , dtHidden,       0,  daCenter,  true,    "fm_cd",                  false,          "",       dfNone,     0,     true,       true);
										InitDataProperty(0, cnt++ , dtHidden,       0,  daCenter,  true,    "to_cd",                  false,          "",       dfNone,     0,     true,       true);
										InitDataProperty(0, cnt++ , dtHidden,       0,  daCenter,  true,    "cop_expt_subsc_cs_seq",  false,          "",       dfNone,     0,     true,       true);

                    InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,   "r_act_cd1_nm",         false,        "",      dfNone,     	0,          false,     false);
                    InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,   "r_act_cd2_nm",         false,        "",      dfNone,     	0,          false,     false);


										//cop_expt_subsc_cs_seq
                		//setting Combo information[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
										InitDataCombo (0, "r_expt_tp" , r_expt_tpText , r_expt_tpCode);
										InitDataCombo (0, "r_expt_tp_dtl" , r_expt_tp_dtlText , r_expt_tp_dtlCode);
										InitDataCombo (0, "r_fm_act" , r_fm_actText , r_fm_actCode);
										InitDataCombo (0, "r_to_act" , r_to_actText , r_to_actCode);
					
										InitDataCombo (0, "r_subseq_grp" , r_subseq_grpText , r_subseq_grpCode);
					
										r_noti_prty_Code="1|2|3|4|5|6|7";
										r_noti_prty_Text="BKG Create Office|BKG POR Office|BKG POL Office|BKG POD Office|BKG DEL Office|Exception Office|US Rail Office";
										InitDataCombo (0, "r_noti_prty" , r_noti_prty_Text , r_noti_prty_Code);
					
										InitDataCombo (0, "r_act" , "Y|N" , "Y|N");

                    style.height = GetSheetHeight(16) ;
               }
                break;

        }
    }

  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      
    				sheetObj.InitDataCombo (0, "r_expt_tp_dtl" , r_expt_tp_dtlText , r_expt_tp_dtlCode);
						sheetObj.InitDataCombo (0, "r_fm_act" , r_fm_actText , r_fm_actCode);
						sheetObj.InitDataCombo (0, "r_to_act" , r_to_actText , r_to_actCode);

    				formObj.f_cmd.value = SEARCHLIST ;
    				sheetObj.DoSearch4Post("ESD_SCE_0049GS.do", SceFrmQryString(formObj));

                break;

            case IBDOWNEXCEL:        // excel down

                sheetObj.SpeedDown2Excel(-1);
                break;

    		case IBSAVE:
    			if(validateForm(sheetObj,formObj,sAction)){
    				//alert("sheetObj.CellValue(Row, 'r_fm_act') == " + sheetObj.CellValue(sheetObj.SelectRow, "r_fm_act"));
    				//alert("sheetObj.CellValue(Row, 'r_to_act') == " + sheetObj.CellValue(sheetObj.SelectRow, "r_to_act"));
    				formObj.f_cmd.value = MULTI ;
    				sheetObj.DoSave("ESD_SCE_0049GS.do", SceFrmQryString(formObj));
    				sheetObj.InitDataCombo (0, "r_expt_tp_dtl" , r_expt_tp_dtlText , r_expt_tp_dtlCode);
						sheetObj.InitDataCombo (0, "r_fm_act" , r_fm_actText , r_fm_actCode);
						sheetObj.InitDataCombo (0, "r_to_act" , r_to_actText , r_to_actCode);

    				formObj.f_cmd.value = SEARCHLIST ;
    				sheetObj.DoSearch4Post("ESD_SCE_0049GS.do", SceFrmQryString(formObj));
    			}
    			break;

		   case IBINSERT:      

				var Row = sheetObj.DataInsert();

				sheetObj.CellValue(Row, "r_usr_id") = formObj.usr_id.value;

				sheetObj.CellValue(Row, 4 ) = "";
				sheetObj.CellValue(Row, 5 ) = "";
				sheetObj.CellValue(Row, 6 ) = "";

				break;
        }
        var rowCnt = sheetObj.RowCount('');
				for (var row = 1; row < rowCnt; row++) {
					if(sheetObj.CellValue(row, "r_act") == 'N') {
						sheetObj.CellEditable(row,"r_subseq_grp") = false;
						sheetObj.CellEditable(row,"r_noti_prty") = false;
					}
				}
    }

function sheet1_OnMouseMove(sheetObj,Button, Shift, X, Y) {

       if (sheetObj.MouseCol == 10)
          MouseToolTipText = sheetObj.CellText(sheetObj.MouseRow,10);
      else
          MouseToolTipText = "";

          sheetObj.ToolTipText(sheetObj.MouseRow,sheetObj.MouseCol) = MouseToolTipText;
}

function getcomText(sheetObj, row, col){

  var sText = sheetObj.GetComboInfo(row,col, "Text");
  var sCode = sheetObj.GetComboInfo(row,col, "Code");

  var arrText = sText.split("|");
  var arrCode = sCode.split("|");

  var idx   = sheetObj.GetComboInfo(row,col, "SelectedIndex");

  return arrText[idx];
}

function sheet1_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
    var formObj = document.form ;
    selectVal = SceFrmQryString(formObj);
    sheetObj.DoSearch4Post("ESD_SCE_0049GS.do", selectVal, "cur_page=" + PageNo, true);
}

   /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){

    	var all_rowcnt = sheetObj.RowCount;

    	for( var i = 1; i <= all_rowcnt; i++ ){

    		if( i != 0 ) {

			    if(sheetObj.CellValue(i, 'r_expt_tp_dtl') == "" ){
			     ComShowMessage('Input Exception Type Detail!');
			     sheetObj.SelectCell(i, 'r_expt_tp_dtl');
			     return false;
			    }

			    if(sheetObj.CellValue(i, 'r_fm_act') == "" ){
			     ComShowMessage('Input From-Activity Code!');
			     sheetObj.SelectCell(i, 'r_fm_act');
			     return false;
			    }

		   }

    	}

    	var chgRows       = sheetObj.FindStatusRow("I|U").split(";")
			for( var cnti = 0; cnti < chgRows.length-1; cnti++ ){
	    	for( var i = 1; i <= all_rowcnt; i++ ){

	    	    if( chgRows[cnti] != i ){
	    	    	if(sheetObj.CellValue(i, 'r_fm_act') == sheetObj.CellValue(chgRows[cnti], 'r_fm_act') ){
								if(sheetObj.CellValue(i, 'r_to_act') == sheetObj.CellValue(chgRows[cnti], 'r_to_act') ){
					      	if(sheetObj.CellValue(i, 'r_subseq_grp') == sheetObj.CellValue(chgRows[cnti], 'r_subseq_grp') ){
						      	if(sheetObj.CellValue(i, 'r_noti_prty') == sheetObj.CellValue(chgRows[cnti], 'r_noti_prty') ){
							      	ComShowMessage('Duplicate Exception Type/Exception Type Detail/From-Activity/To-Activity/Subscriber Group/Notification Party!');
								     	sheetObj.SelectCell(chgRows[cnti], 'r_subseq_grp');
								     	return false;
							      }
						      }
					      }
					    }
	    	    }

			    var cost_cd = sheetObj.CellValue(chgRows[cnti], 'r_expt_tp');

			    if(cost_cd.substring(0,1) == '1' ){
				    if(sheetObj.CellValue(chgRows[cnti], 'r_to_act') == "" ){
				     ComShowMessage('Input To-Activity Code!');
				     sheetObj.SelectCell(i, 'r_to_act');
				     return false;
				    }
			    }
	    	}
		}


        return true;
    }

function sheet_OnMouseDown(sheetObj, Button, Shift, X, Y){
	var colName = sheetObj.ColSaveName(sheetObj.MouseCol);
	var row = sheetObj.MouseRow;
	var col = sheetObj.MouseCol;
	
	if( sheetObj.ColSaveName(col)=="r_expt_tp") {

		var chkVal =  sheetObj.CellValue(row, col);

		sheetObj.CellValue(row, 4 ) = "";
		sheetObj.CellValue(row, 5 ) = "";
		sheetObj.CellValue(row, 6 ) = "";

	}
	
}
function sheet_OnChange(sheetObj, row, col){

	if( sheetObj.ColSaveName(col)=="r_expt_tp") {

		var chkVal =  sheetObj.CellValue(row, col);

		sheetObj.CellValue(row, 4 ) = "";
		sheetObj.CellValue(row, 5 ) = "";
		sheetObj.CellValue(row, 6 ) = "";

	}
}

function sheet_OnKeyUp(sheetObj, row, col, KeyCode, Shift){
	if( sheetObj.ColSaveName(col)=="r_expt_tp_dtl") {

		var chkVal =  sheetObj.CellValue(row, col-1);

		var nCode = r_expt_tp_dtlCode.split("|");
		var nText = r_expt_tp_dtlText.split("|");
		var tmpCode="";
		var tmpText="";

		for( var i =0; i < nCode.length ; i++) {

			if( nCode[i].substring(0,1) == chkVal.substring(0,1)) {
				if( tmpCode.length != 0) {
					tmpCode = tmpCode+"|";
					tmpText = tmpText+"|";

				}
				tmpCode = tmpCode+nCode[i];
				tmpText = tmpText+nText[i];
			}
		}
		sheetObj.InitDataCombo (0, "r_expt_tp_dtl" , tmpText , tmpCode);

	}

	if( sheetObj.ColSaveName(col)=="r_fm_act") {

		var chkdtlcd = sheetObj.CellValue(row, col-1);

		var nCode = r_fm_actCode.split("|");
		var nText = r_fm_actText.split("|");
		var tmpCode="";
	    var tmpText="";

		for( var i =0; i < nCode.length ; i++) {

			if( nCode[i].substring(0,3) == chkdtlcd.substring(0,3) ) {

				if( tmpCode.length != 0) {
					tmpCode = tmpCode+"|";
					tmpText = tmpText+"|";

				}
				tmpCode = tmpCode+nCode[i];
				tmpText = tmpText+nText[i];
			}
		}
		sheetObj.InitDataCombo (0, "r_fm_act" , tmpText , tmpCode);

	}


	if( sheetObj.ColSaveName(col)=="r_to_act") {

		var chkdtlcd = sheetObj.CellValue(row, col-1);

		var nCode = r_to_actCode.split("|");
		var nText = r_to_actText.split("|");
		var tmpCode="";
		var tmpText="";

		for( var i =0; i < nCode.length ; i++) {

			if( nCode[i].substring(0,3)+nCode[i].substring(4,6)== chkdtlcd.substring(0,3)+chkdtlcd.substring(4,6) ) {
				if( tmpCode.length != 0) {
					tmpCode = tmpCode+"|";
					tmpText = tmpText+"|";

				}
				tmpCode = tmpCode+nCode[i];
				tmpText = tmpText+nText[i];
			}
		}
		sheetObj.InitDataCombo (0, "r_to_act" , tmpText , tmpCode);

	}
}

function sheet_OnClick(sheetObj, row, col){

	if( sheetObj.ColSaveName(col)=="r_expt_tp_dtl") {

		var chkVal =  sheetObj.CellValue(row, col-1);

		var nCode = r_expt_tp_dtlCode.split("|");
		var nText = r_expt_tp_dtlText.split("|");
		var tmpCode="";
		var tmpText="";

		for( var i =0; i < nCode.length ; i++) {

			if( nCode[i].substring(0,1) == chkVal.substring(0,1)) {
				if( tmpCode.length != 0) {
					tmpCode = tmpCode+"|";
					tmpText = tmpText+"|";

				}
				tmpCode = tmpCode+nCode[i];
				tmpText = tmpText+nText[i];
			}
		}
		sheetObj.InitDataCombo (0, "r_expt_tp_dtl" , tmpText , tmpCode);

	}

	if( sheetObj.ColSaveName(col)=="r_fm_act") {

		var chkdtlcd = sheetObj.CellValue(row, col-1);

		var nCode = r_fm_actCode.split("|");
		var nText = r_fm_actText.split("|");
		var tmpCode="";
	    var tmpText="";

		for( var i =0; i < nCode.length ; i++) {

			if( nCode[i].substring(0,3) == chkdtlcd.substring(0,3) ) {

				if( tmpCode.length != 0) {
					tmpCode = tmpCode+"|";
					tmpText = tmpText+"|";

				}
				tmpCode = tmpCode+nCode[i];
				tmpText = tmpText+nText[i];
			}
		}
		sheetObj.InitDataCombo (0, "r_fm_act" , tmpText , tmpCode);

	}


	if( sheetObj.ColSaveName(col)=="r_to_act") {

		var chkdtlcd = sheetObj.CellValue(row, col-1);

		var nCode = r_to_actCode.split("|");
		var nText = r_to_actText.split("|");
		var tmpCode="";
		var tmpText="";

		for( var i =0; i < nCode.length ; i++) {

			if( nCode[i].substring(0,3)+nCode[i].substring(4,6)== chkdtlcd.substring(0,3)+chkdtlcd.substring(4,6) ) {
				if( tmpCode.length != 0) {
					tmpCode = tmpCode+"|";
					tmpText = tmpText+"|";

				}
				tmpCode = tmpCode+nCode[i];
				tmpText = tmpText+nText[i];
			}
		}
		sheetObj.InitDataCombo (0, "r_to_act" , tmpText , tmpCode);

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



function fun_getExptTP() {

		var url = "ESD_SCE_0049GS.do?f_cmd="+SEARCH12;
		createHttpRequest();
		request.open("GET", url, true);

		request.onreadystatechange = subExptTp;

		request.send(null);

}



function subExptTp() {

	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			
			var text_effS = "";
			var text_effM = "";
			var text_effE = "";
			
			text_effS = "<select style=\"width:150;\" name=\"h_expt_tp\" onChange=\"fun_getExptDTLTP();\">";
			
			for( var n = 0; n < docXml.getElementsByTagName("TR").length; n++ ) {
				var row = docXml.getElementsByTagName("TR")[n].firstChild.nodeValue;
				var val = ComReplaceStr(row, "☜☞", "");
				var valLen = val.length;
				var val2 = val.substring(0, valLen-8);
				var valStr = val.substring(valLen-8, valLen-7);
				
				if( n == 0){
						text_effM = "<OPTION value=\"\" selected >ALL</OPTION>";
						text_effM = text_effM + "<OPTION value=\"" + valStr + "\" >"+val2+"</OPTION>";
					}else{
						text_effM = text_effM + "<OPTION value=\"" + valStr + "\" >"+val2+"</OPTION>";
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

		var expt_type = document.form.h_expt_tp.value;

		var url = "ESD_SCE_0049GS.do?f_cmd="+SEARCH13+"&expt_type="+expt_type;
		createHttpRequest();
		request.open("GET", url, true);

		request.onreadystatechange = subExptDTLTp;

		request.send(null);

}


function subExptDTLTp() {
	
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;

			var text_effS = "";
			var text_effM = "";
			var text_effE = "";
				
			text_effS = "<select style=\"width:150;\" name=\"h_expt_tp_dtl\" >";

			for( var n = 0; n < docXml.getElementsByTagName("TR").length; n++ ) {
				var row = docXml.getElementsByTagName("TR")[n].firstChild.nodeValue;
				var val = ComReplaceStr(row, "☜☞", "");		
				var valLen = val.length;
				var val2 = val.substring(0, valLen-8);
				var valStr = val.substring(valLen-8, valLen-5);
				
				if( n == 0){
					text_effM = "<OPTION value=\"\" selected >ALL</OPTION>";
					text_effM = text_effM + "<OPTION value=\"" + valStr + "\" >"+val2+"</OPTION>";
				}else{
					text_effM = text_effM + "<OPTION value=\"" + valStr + "\" >"+val2+"</OPTION>";
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
     if(sheetObj.MouseCol == sheetObj.SaveNameCol("r_fm_act") || sheetObj.MouseCol == sheetObj.SaveNameCol("r_to_act")){
//alert("alert(OnMouseMove);");

             
//            sheetObj.MousePointer = "Default"; 
              sheetObj.MousePointer = "Hand";     
              var sText="";
              if(sheetObj.MouseCol == sheetObj.SaveNameCol("r_fm_act")) sText = sheetObj.CellText(sheetObj.MouseRow,"r_act_cd1_nm");
              else if(sheetObj.MouseCol == sheetObj.SaveNameCol("r_to_act")) sText = sheetObj.CellText(sheetObj.MouseRow,"r_act_cd2_nm");
           	  //sText = sheetObj.CellText(sheetObj.MouseRow,"d_act_cd1_nm");
           
          	  sheetObj.ToolTipText(sheetObj.MouseRow,sheetObj.MouseCol)  = sText;
     }

}
