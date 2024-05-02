
var sheetObjects = new Array();
var sheetCnt = 0;

var optionflag = 'N';

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
                

        	    case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
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
            ComConfigSheet(sheetObjects[i]);

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
                    style.height =0;
                    SheetWidth = 0;

                    //setting host information[mandatory][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //setting kind of merge [selection, Default msNone]
                    MergeSheet = msNone;

                    //setting allowed to edit. [selection, Default false]
                    Editable = true;

                    //setting row information [mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //setting of column information [mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(10, 0, 0, true);

                    // setting function handling header
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "STS| |Container No.|COP No.|BKG No.|B/L No.|VVD|COP_EXPT_NO|NTFD_SUBC_ID|subsc_expt_no" ;

                    //setting header row information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //setting property of data [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    //InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,  false,    "",     false,          "",       dfNone,   		0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 10,  daCenter,  false,    "ibflag",        false);
                    InitDataProperty(0, cnt++ , dtCheckBox,   20,    daCenter,  false,    "dtcheck",        false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      120,    daCenter,  false,    "cntr_no",        false,          "",       dfNone,     	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      120,    daCenter,  false,    "cop_no",        false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      120,    daCenter,  false,    "bkg_no",        false,          "",       dfNone,     	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      120,    daCenter,  false,    "bl_no",        false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "vvd_no",        false,          "",       dfNone,     	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  false,    "cop_expt_no",        false,          "",       dfNone,     	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  false,    "ntfd_subsc_id",        false,          "",       dfNone,     	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  false,    "cop_expt_no_",        false,          "",       dfNone,     	0,     true,       true);

               }
                break;

        }
    }

  // handling process of sheet
    function doActionIBSheet(sheetObj,formObj,sAction,isAppend) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            
           case IBSEARCH:      //retrieving
                formObj.f_cmd.value = COMMAND01;
                sheetObj.DoSearch4Post("EDI_TESTGS.do", FormQueryString(formObj));                
                break;
           
        }
    }
