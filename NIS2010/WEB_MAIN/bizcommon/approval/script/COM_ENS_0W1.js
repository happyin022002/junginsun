// ??????


var sheetObjects = new Array();
var sheetCnt = 0;

/* ???????? ?? ???? ?????? ?? */
document.onclick = processButtonClick;

/* ?? ???? ???? ????? ?????? ?????? */
    function processButtonClick(){
         /***** ?? ??? 2? ??? ??? ?? ???? ???? ??? *****/
         var sheetObject = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

        	    case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;
				case "btn_Close":
					  window.close();
				  break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			alert("??? ???? ?? ????");
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * IBSheet Object? ??? ??
     * ?? ?? ???? ????? ??? ?? ? ??? ?? ????? ??? ? ??
     * ??? ?? ??? ??
     */
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;


    }

    /**
     * Sheet ?? ?? ? ???
     * body ??? onLoad ?????? ??
     * ??? ?????? ??? ?? ????? ?? ??? ????
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){

        //khlee-?? ?? ?? ?? ?? ??
            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-??? ?? ?? ?? ??
            ComEndConfigSheet(sheetObjects[i]);
        }

        // VVD? ??? ??, ?? ??               
        var sheetObject = sheetObjects[0];
        var formObject = document.form;
       	doActionIBSheet(sheetObject,formObject,IBSEARCH);
    }

   /**
     * ?? ?????, ?? ??
     * param : sheetObj ==> ??????, sheetNo ==> ?????? ??? ???? ?? ????
     * ??? ??? ?? ?? ??? case? ???? ?? ?????? ????
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with (sheetObj) {
                    // ?? ??
                    style.height = GetSheetHeight(6) ;
                    //?? ?? ??
                    SheetWidth = mainTable.clientWidth;

                    //Host?? ??[??][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //??Merge ?? [??, Default msNone]
                    MergeSheet = msNone;

                    //??Edit ?? ?? [??, Default false]
                    Editable = true;

                    //?????[??][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //??????[??][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(7, 0, 0, true);

                    // ???? ??? ? ?? ?? ??? ????
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "No.|Name|Office.|Title|APP. STS|App. Date|App. Remarks" ;

                    //?????[??][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //?????    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  false,   "apro_rqst_seq",        false,          "",       dfNone,	    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      120,    daCenter,  false,    "apro_usr_nm",        false,          "",       dfDateYmd,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "apro_ofc_cd",        false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,    100,    daCenter,  false,   "title",        false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "apro_cd",        false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      120,    daCenter,  false,   "apro_dt",        false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      125,    daCenter,  false,   "apro_rmk",        false,          "",       dfNone,   	0,     false,       false);
             }
                break;

        }
    }

  // Sheet?? ???? ??
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //??
               
                formObj.f_cmd.value = SEARCH;                
                selectVal = FormQueryString(formObj)
                sheetObj.DoSearch4Post("COM_ENS_0W1GS.do", selectVal);
                break;
        }
    }



   /**
     * ?? ????? ?? ????? ???? ??
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
