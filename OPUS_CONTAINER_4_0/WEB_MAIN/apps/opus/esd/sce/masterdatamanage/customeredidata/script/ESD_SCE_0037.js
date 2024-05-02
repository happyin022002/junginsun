
var sheetObjects = new Array();
var sheetCnt = 0;

//Event handler processing by button click event */
document.onclick = processButtonClick;

//Event handler processing by button name */
    function processButtonClick(){
    	/***** Setting variable over two sheet at tab *****/
         var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_close" :
                    window.close();
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
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){

        	//changing initializing function name
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //adding last function name
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

                    //setting host information [mandatory][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //setting kind of merge [selection, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //setting allowed to edit [selection, Default false]
                    Editable = true;

                    //setting row information [mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //setting column information [mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(12, 0, 0, true);

                    //changing initializing function name
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "Seq|Standard\n EDI Status|Customer\n EDI Status|BKG No.|BKG No.|B/L No.|Truck\nVVD|Location/\nYard|Event Date|Send Date|Result|Remarks" ;

                    //setting header row information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //setting property of data   [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,     50,    daCenter,  false,    "",        false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,     75,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,     75,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,     90,    daCenter,  false,    "",        false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,     20,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,     90,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     true,       true);
                                                                                                                                               
                    InitDataProperty(0, cnt++ , dtData,     70,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,     80,    daCenter,  false,    "",        false,          "",       dfNone, 0,     true,       true);
                    
                    InitDataProperty(0, cnt++ , dtData,     130,    daCenter,  false,    "",        false,          "",       dfNone, 0,     true,       true);
                    
                    InitDataProperty(0, cnt++ , dtData,     130,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     true,       true);                                                                                                                           
                    InitDataProperty(0, cnt++ , dtData,     50,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,     60,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     true,       true);
                    style.height = GetSheetHeight(10) ;
                    
                    //DoSearch("ESD_SCE_0037GS.do");
                    
                     
               }
                break;

        }
    }

    // handling process of sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
           case IBSEARCH:      //retrieving
                // if(validateForm(formObj)){
    		        formObj.f_cmd.value = SEARCH01;
    			    sheetObj.DoSearch4Post("ESD_SCE_0037GS.do", SceFrmQryString(formObj));
			    // }
                break;
        }
    }


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
