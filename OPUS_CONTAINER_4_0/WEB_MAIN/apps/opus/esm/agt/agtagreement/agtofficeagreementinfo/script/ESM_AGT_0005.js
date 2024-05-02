// Common Global Variables


var sheetObjects = new Array();
var sheetCnt = 0;
var IBDETAILSEARCH	 = 20;
/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
	function processButtonClick(){
		 /***** Setting the additional Sheet variable when each tab has more than 2 sheets *****/
		 var sheetObject = sheetObjects[0];
		 var sheetObject1 = sheetObjects[1];

		 /*******************************************************/
		 var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObject,IBDETAILSEARCH);
					break;

				case "btn_ok":
					  comPopupOK();
				  break;

				case "btn_close":
					  window.close();
				  break;

			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg("COM12111", "", "", ""));
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
	 * adding first-served functions after loading screen
	 */
	function loadPage() {

		for(i=0;i<sheetObjects.length;i++){

		//khlee-Changing Start Environment Setting Method's Name
			ComConfigSheet(sheetObjects[i]);

			initSheet(sheetObjects[i],i+1);
		//khlee-Adding Last Environment Setting method
			ComEndConfigSheet(sheetObjects[i]);
		}
		var sheetObject = sheetObjects[0];
        var formObject = document.form;
       	doActionIBSheet(sheetObject,formObject,IBSEARCH);
	}

   /**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;

		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					// setting height
					style.height = GetSheetHeight(11) ;
					//Whole setting width
					SheetWidth = mainTable.clientWidth;

					//setting Host information[mandatory][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//Whole Merge kind [Optional, Default msNone]
					MergeSheet = msHeaderOnly;

				   //Edit kind [Optional, Default false]
					if(document.form.pageType.value != "Inquiry"){
						Editable = true;
					}else{
						Editable = false;
					}

					//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 0, 1, 9, 100);

					//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(5, 0 , 0, true);

					// setting function handling header
					if(document.form.pageType.value != "Inquiry"){
						InitHeadMode(true, false, true, true, false,false) ;
					}else{
						InitHeadMode(true, false, false, true, false,false) ;
					}
					

					var HeadTitle = "STS|No|CHK|Code|Description";

					//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//Data  properties    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,30,    daCenter,  false,    "",     false,          "",       dfNone,   		0,     false,      true);
					InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,   false,    "",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtCheckBox,   40,    daCenter,   false,    "checkbox",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   false,    "rep_chg_cd",     false,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       50,    daLeft,   false,    "rep_chg_nm",     false,          "",       dfNone,          0,     false,       false);

					CountPosition = 0 ;
				}
				break;
			case 2:      //sheet1 init
				with (sheetObj) {
					// setting height
					style.height = GetSheetHeight(11) ;
					//Whole setting width
					SheetWidth = mainTable.clientWidth;

					//setting Host information[mandatory][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//Whole Merge kind [Optional, Default msNone]
					MergeSheet = msHeaderOnly;

				   //Edit kind [Optional, Default false]
					if(document.form.pageType.value != "Inquiry"){
						Editable = true;
					}else{
						Editable = false;
					}

					//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 0, 1, 9, 100);

					//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(9, 0 , 0, true);

					// setting function handling header
					if(document.form.pageType.value != "Inquiry"){
						InitHeadMode(true, false, true, true, false,false) ;
					}else{
						InitHeadMode(true, false, false, true, false,false) ;
					}

					var HeadTitle = "STS|No|CHK|Code|Description|Rep.chrg|Type|Class|Character";

					//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//Data  properties    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,30,    daCenter,  false,    "",     false,          "",       dfNone,   		0,     false,      true);
					InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,   false,    "",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtCheckBox,   40,    daCenter,   false,    "checkbox",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       40,    daCenter,   false,    "chg_cd",     false,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       90,    daLeft,   false,    "chg_nm",     false,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   false,    "rep_chg_cd",     false,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   false,    "frt_chg_tp_cd",     false,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       40,    daCenter,   false,    "chg_rev_tp_cd",     false,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   false,    "chg_aply_tp_cd",     false,          "",       dfNone,          0,     false,       false);


					CountPosition = 0 ;

			   }
				break;


		}
	}

    // handling process for Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {

		   case IBSEARCH:      //Rep.Charge Retrieve		        
				if(!validateForm(sheetObj,formObj,sAction)) return false;
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("ESM_AGT_0005GS.do", agtQryStr(formObj));
				var arrXml = sXml.split("|$$|");
				if(arrXml.length>0)sheetObjects[0].LoadSearchXml(arrXml[0]);
				if(arrXml.length>1)sheetObjects[1].LoadSearchXml(arrXml[1]);
				break;
				
			case IBDETAILSEARCH:  //Rep.Charge Optional Detail Charge Retrieve
			    if(!validateForm(sheetObj,formObj,sAction)) return false;
				formObj.f_cmd.value = SEARCHLIST;
        		var parameter = agtQryStr(formObj);
				parameter = parameter + '&rep_chg_cd='+chkdArgs(sheetObjects[0], 'checkbox', 'rep_chg_cd');
				var sXml = sheetObj.GetSearchXml("ESM_AGT_0005GS.do", parameter);
				var arrXml = sXml.split("|$$|");
				if(arrXml.length>1)sheetObjects[1].LoadSearchXml(arrXml[1]);
				break;
		}
	}

    // Rep.Charge sheet check box is clicked, then Detail Charge Uncheck

    function sheet1_OnClick(sheetObject, Row, Col, Value)
    {
		var sheetObject1 = sheetObjects[1];

        if ( sheetObject.colSaveName(Col)== "checkbox"){
            var checkValue = sheetObject.CellValue(Row, "rep_chg_cd");

            if(Value == 0){
                check_Process(sheetObject1, checkValue);
            }
    	}
    }
    
    // Detail Charge sheet check box is clicked, then Rep.Charge Uncheck

    function sheet2_OnClick(sheetObject1, Row, Col, Value)
    {
		var sheetObject = sheetObjects[0];

        if ( sheetObject1.colSaveName(Col)== "checkbox"){
            var checkValue = sheetObject1.CellValue(Row, "rep_chg_cd");

            if(Value == 0){
                check_Process(sheetObject, checkValue);
            }
    	}
    }

    function check_Process(sheetObj, Value){
        var rowCount = sheetObj.Rows;
        for(i=0; i<rowCount; i++){
            if(sheetObj.CellValue(i,"rep_chg_cd") == Value){
                sheetObj.CellValue(i,"checkbox") = 0;
            }
        }
    }
    
    // Rep.Charge sheet checkAll box is clicked then Detail Charge Uncheck

    function sheet1_OnMouseDown(sheetObject, Btn, Shift, X, Y)
    {
		var sheetObject1 = sheetObjects[1];

        if ( sheetObject.MouseRow == 0  && sheetObject.MouseCol == 2){            
              sheetObject1.CheckAll2(2) = 0;
    	}
    }
    
    // Detail Charge sheet checkAll box is clicked then Rep.Charge Uncheck

    function sheet2_OnMouseDown(sheetObject1, Btn, Shift, X, Y)
    {
		var sheetObject = sheetObjects[0];

        if ( sheetObject1.MouseRow == 0  && sheetObject1.MouseCol == 2){
            sheetObject.CheckAll2(2) = 0;
    	}
    }


   /**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
	    var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		
		switch(sAction) {

			case IBDETAILSEARCH:
        		if(sheetObject.CheckedRows("checkbox") < 1){
        	        ComShowMessage(ComGetMsg('COM12113','Rep. Charge CheckBox'));
        	        return false;
        		}
        		
        		break;
		}

		return true;
	}
	 function chkdArgs(sheetObj,chkCol,valCol,isNum)
	 {
	 	var rtn = '';
	 	with(sheetObj)
	 	{
	 		for (var i = 1; i <= LastRow; i ++)
	 		{
	 			if ("1" == CellValue(i, chkCol))
	 				rtn += (''!=rtn?',':'')+(isNum?'':'\'')+CellValue(i, valCol)+(isNum?'':'\'');
	 		}
	 	}
	 	return rtn;
	 }