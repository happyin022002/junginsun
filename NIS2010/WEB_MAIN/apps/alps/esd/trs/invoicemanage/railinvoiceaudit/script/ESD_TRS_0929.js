/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0929 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0929() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

// ??????
var sheetObjects = new Array();
var sheetCnt = 0;

// ??? ?? ???(?? ? ?? , ??? ???)
var opener = window.dialogArguments;

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

        	    case "btn_close":
        	        window.close();
        	        break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("TRS90392");
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

        // ?? ????? ?? ?? ??, ?? ?? ? ??
        fillFormData();  
  }

   /**
     * ?? ?????, ?? ??
     * param : sheetObj ==> ??????, sheetNo ==> ?????? ??? ???? ?? ????
     * ??? ??? ?? ?? ??? case? ???? ?? ?????? ????
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    // ?? ??
                    style.height = GetSheetHeight(8) ;
                    //?? ?? ??
                    SheetWidth = mainTable.clientWidth;

                    //Host?? ??[??][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //??Merge ?? [??, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //??Edit ?? ?? [??, Default false]
                    Editable = false;

                    //?????[??][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //??????[??][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(14, 0 , 0, true);

                    // ???? ??? ? ?? ?? ??? ????
                    InitHeadMode(true, true, false, true, false,false) ;

                    var HeadTitle = "Paid|From Node|From Node|To Node|To Node|Cargo|Vendor|Vendor|Rail Billing\nDate|Paid\nDate|Invoice\nCUR|Invoice\nAmount|Invoice\nNo.|Registration\nNo.";

                    //?????[??][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //?????    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,   false,    "paid",     false,          "",       dfNone,          0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   false,    "fm_nod_cd1",     false,          "",       dfNone,          0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       20,    daCenter,   false,    "fm_nod_cd2",     false,          "",       dfNone,          0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   false,    "to_nod_cd1",     false,          "",       dfNone,          0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       20,    daCenter,   false,    "to_nod_cd2",     false,          "",       dfNone,          0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,   false,    "bkg_cgo_tp_cd",     false,          "",       dfNone,          0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   false,    "vndr_seq",     false,          "",       dfNone,          0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   false,    "vndr_abbr_nm",     false,          "",       dfNone,          0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "rail_bil_dt",     false,          "",       dfDateYmd,          0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "pay_dt",     false,          "",       dfDateYmd,       0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCombo,      60,    daCenter,   false,    "inv_curr_cd",     false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daRight,   false,    "inv_amt",     false,          "",       dfInteger,          0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,    false,    "inv_no",     false,          "",       dfNone,         0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   false,    "rgst_no",     false,          "",       dfNone,          0,     true,       true);

					InitDataCombo(0, 'inv_curr_cd', " |"+inv_curr_cdText, " |"+inv_curr_cdCode);
               }
                break;
        }
    }

  // Sheet?? ???? ??
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //??
//                sheetObj.ShowDebugMsg = true;
                formObj.f_cmd.value = SEARCH;
                sheetObj.DoSearch4Post("ESD_TRS_0929GS.do", TrsFrmQryString(formObj));
                ComEtcDataToForm(formObj ,sheetObj);
                sheetObj.ShowDebugMsg = false;
                sheetObj.RemoveEtcData();
                break;

           case IBLOADEXCEL:        //?? ???
              sheetObj.LoadExcel();
              break;

        }
    }

    /**
     *  ?? road ? form ? Data? ????
     */
     function fillFormData()
     {
        document.form.cntr_no.value = opener.document.form.cntr_no.value ; 
        // ?? ????? ?? ?? ??, ?? ?? ? ??
        var sheetObject = sheetObjects[0];
        var formObject = document.form;
        doActionIBSheet(sheetObject,formObject,IBSEARCH);
      }
