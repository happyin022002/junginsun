// Common global variable 
var ipageNo =1 ;

var sheetObjects = new Array();
var sheetCnt = 0;
var selectVal;
/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
    function processButtonClick(){
         var sheetObject = sheetObjects[0];


         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

         	    case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;

       	    case "btn_new":
    	            sheetObject.RemoveAll();
    	            formObject.reset();
        	        break;

       	    case "btn_ok":
                    popupOK(sheetObject);
        	        break;

       	    case "btn_close":
    	            self.close();
        	        break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			alert(ComGetMsg('COM12111'));
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    function popupOK(sheetObject) {
          var openerSheet = window.opener.document.sheet1 ;
          if(sheetObject.CheckedRows("radio")>0) {
                var iRow = openerSheet.SelectRow;
                var iCheckRow = sheetObject.FindCheckedRow("radio");
                
                var arrRow = iCheckRow.split("|");
                var insertRow = arrRow[0];
                openerSheet.CellValue2( iRow, "vndr_seq"        ) = sheetObject.CellValue( insertRow , "vndr_seq") ;
                openerSheet.CellValue2( iRow, "vndr_name"        ) = sheetObject.CellValue( insertRow , "vndr_lgl_eng_nm") ;
           }
          window.close();            
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
            case 1:      //IBSheet1 init
                with (sheetObj) {
                    // setting height
                    style.height = GetSheetHeight(10) ;
                    //setting width
                    SheetWidth = mainTable.clientWidth;

                    //setting Host information[mandatory][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //Merge kind [optional, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //Edit kind [optional, Default false]
                    Editable = true;

                    //setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(9, 0, 0, true);

                    // setting function handling header
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "||Service Provider Code|Control Office|Service Provider Name" ;

                    //Header information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtRadioCheck,20,    daCenter,  false,    "radio",        false,          "",       dfNone,	    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,  20,    daCenter,  false,    "check",        false,          "",       dfNone,   	0,     true,       true);

                    InitDataProperty(0, cnt++ , dtData,     200,    daCenter,  false,    "vndr_seq",        false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,    "ofc_cd",        false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,     200,    daCenter,  false,    "vndr_lgl_eng_nm",        false,          "",       dfNone,       0,     true,       true);

                    InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "vndr_abbr_nm",        false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "prnt_vndr_seq",        false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "vndr_cnt_cd",        false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "org_vndr_seq",        false,          "",       dfNone,       0,     false,       true);
                    
                    WaitImageVisible=false;
               }
                break;
        }
    }



  // handling of Sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      
                if(validateForm(sheetObj,formObj,sAction));
           		ComOpenWait(true);
                formObj.f_cmd.value = SEARCH;   
                selectVal = PrdFQString(formObj)
                sheetObj.DoSearch4Post("ESD_PRD_0026GS.do", selectVal); 
                formObj.ofc_cd.value = sheetObj.EtcData("ofc_cd");               
                ComOpenWait(false);	
                break;

           case IBSEARCHAPPEND:  
           		ComOpenWait(true);
                formObj.f_cmd.value = SEARCH;
                sheetObj.DoSearch4Post("ESD_PRD_0026GS.do", selectVal, "iPage=" + PageNo, true);  
                ComOpenWait(false);
           break;  

        }
    }

//    function sheet_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
//        doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true, PageNo);
//    }   
    
   /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
        }

        return true;
    }
