/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


/**
 * @fileoverview 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0083 : 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TRS_0083() {
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
var Mincount = 0 ;

/* ???????? ?? ???? ?????? ?? */
document.onclick = processButtonClick;

/* ?? ???? ???? ????? ?????? ?????? */
function processButtonClick(){
    /***** ?? ??? 2? ??? ??? ?? ???? ???? ??? *****/
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var sheetObject2 = sheetObjects[2];
    //var sheetObject3 = sheetObjects[3];
    
    /*******************************************************/
    var formObject = document.form;
    
    try {
        var srcName = window.event.srcElement.getAttribute("name");
        switch(srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObject,formObject,IBSEARCH);
                //doActionIBSheet2(sheetObject1,formObject,IBSEARCH);
                //doActionIBSheet3(sheetObject2,formObject,IBSEARCH);
                break;
            case "btn_new":
                formObject.reset();
                sheetObject.RemoveAll();
                sheetObject1.RemoveAll();
                sheetObject2.RemoveAll();
                break;
            case "btn_socreation":
                if (sheetObject2.RowCount > 0) {
                   ComShowCodeMessage('TRS90386', 'S/O has already been created');
                }else{
                   doActionIBSheet2(sheetObject1,formObject,IBSAVE);
                }
                break;                   
            case "btn_apply":
                for(var i=3; i<sheetObject1.RowCount+3; i++) {
                	sheetObject1.CellValue(i, 'fctry_nm') = formObject.cust_nm.value;
                	sheetObject1.CellValue(i, 'act_cust_n1st_addr') = formObject.address.value;
                	sheetObject1.CellValue(i, 'act_cust_zip_cd') = formObject.zip_code.value;
                	sheetObject1.CellValue(i, 'cntc_pson_nm') = formObject.pic.value;
                	sheetObject1.CellValue(i, 'cntc_pson_phn_no') = formObject.tel.value;
                	sheetObject1.CellValue(i, 'cntc_pson_fax_no') = formObject.fax.value;
                	sheetObject1.CellValue(i, 'do_rmk') = formObject.remark.value;
                }
                break;
            case "btns_multibillno":
                openMultipleinquiry('BLN', 'B/L No');
                break;
           case "btns_multibookingno":
                openMultipleinquiry('BKG', 'BKG No');
                break;
           case "btns_consignee":
                var lvdor_node        = formObject.dor_loc_cd.value + formObject.zone_cd.value;
                var lv_act_cust_cd    = formObject.cust_cnt_cd.value + formObject.cust_seq.value;
                var lv_fctry_nm       = "";

            	var myOption = "dialogWidth:800px; dialogHeight:506px; help:no; status:no; resizable:no; scroll=no; ";
            	var url = 'ESD_TRS_0914.screen?act_loc='+lvdor_node+"&act_cust_cd="+lv_act_cust_cd+"&fctry_nm="+lv_fctry_nm;
            	window.showModalDialog(url, window, myOption);

                break;
			    case "btn_minimize":
			    	   Mincount = (Mincount+1)%2 ;
			    	   Minimize(Mincount);
			    	   break;
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowCodeMessage("TRS90384");		// 'The service is not available now'
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
        
        //sheet? ???? ??? ?? ??.
        visibleSheet(sheetObjects[i],i+1);
    }

	//html컨트롤 이벤트초기화
	initControl();    
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
    //Axon 이벤트 처리1. 이벤트catch
}

//Axon 이벤트 처리2. 이벤트처리함수 --- start
/**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 **/
function engnum_keypress() {
}

/**
 * BKG Creation?? manual? ???? ??? ????. <br>
 **/
function manual_click() {
}

/**
 * BKG Creation탭의 Booking No가 바뀐경우 기능을 처리한다. <br>
 **/
function bkgno_keyup() {
}

/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 **/
function obj_blur(){
}

/**
 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
 **/
function obj_focus(){
}

/**
 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
 **/
function obj_keypress(){
}

//Axon 이벤트 처리2. 이벤트처리함수 --- end
	
function visibleSheet(sheetObj,sheetNo) {
    switch(sheetNo) {
    	  case 1:
    	      sheetObj.visible = false;
    	      break;
    	  case 3:
    	      sheetObj.visible = false;
    	      break;
    } 
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
                style.height = 0;
                //?? ?? ??
                SheetWidth = mainTable.clientWidth;
    
                //Host?? ??[??][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    
                //??Merge ?? [??, Default msNone]
                MergeSheet = msHeaderOnly;
    
               //??Edit ?? ?? [??, Default false]
                Editable = true;
    
                //?????[??][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 9, 100);
    
                //??????[??][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(5, 0, 0, true);
    
                // ???? ??? ? ?? ?? ??? ????
                InitHeadMode(true, true, false, true, false,false)
                
                var HeadTitle0 = "cust_cnt_cd|cust_seq|cust_nm|dor_loc_cd|zone_cd" ;
    
                //?????[??][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle0, true);
    
                //?????    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtData,       90,    daCenter, true,    "cust_cnt_cd",    false,          "",       dfNone,       0,     true,       false);
                InitDataProperty(0, cnt++ , dtData,       90,    daCenter, true,    "cust_seq",       false,          "",       dfNone,       0,     true,       false);
                InitDataProperty(0, cnt++ , dtData,       90,    daCenter, true,    "cust_nm",        false,          "",       dfNone,       0,     true,       false);
                InitDataProperty(0, cnt++ , dtData,       90,    daCenter, true,    "dor_loc_cd",     false,          "",       dfNone,       0,     true,       false);
                InitDataProperty(0, cnt++ , dtData,       90,    daCenter, true,    "zone_cd",        false,          "",       dfNone,       0,     true,       false);
    
                HeadRowHeight= 10;
           }
           break;
        case 2:      //sheet2 init
            with (sheetObj) {
                // ?? ??
//                style.height = 240;
                style.height = 400;
                //?? ?? ??
                SheetWidth = mainTable.clientWidth;

                //Host?? ??[??][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //??Merge ?? [??, Default msNone]
                MergeSheet = msHeaderOnly;

               //??Edit ?? ?? [??, Default false]
                Editable = true;

                //?????[??][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 3, 1, 9, 100);

                //??????[??][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(17, 0, 0, true);

                // ???? ??? ? ?? ?? ??? ????
                InitHeadMode(true, true, false, true, false,false)
                
                var HeadTitle0 = "CNTR No.|TP/SZ | BKG No. |B/L No.|Door Information|Door Information|Door Information|Door Information|Door Information|Door Information|Door Information|PO\n#|BKG\nSPE|FULL\nPICK\nUP CY|MTY\nRTN CY|CMDT" ;
                var HeadTitle1 = "CNTR No.|TP/SZ | BKG No. |B/L No.|Factory\nName|Address|Zip\nCode|PIC|TEL|FAX|Remark\n(Special Instruction)|PO\n#|BKG\nSPE|FULL\nPICK\nUP CY|MTY\nRTN CY|CMDT" ;
                var HeadTitle2 = "CNTR No.|TP/SZ | BKG No. |B/L No.|Factory\nName|Address|Zip\nCode|PIC|TEL|FAX|Remark\n(Special Instruction)|PO\n#|BKG\nSPE|FULL\nPICK\nUP CY|MTY\nRTN CY|CMDT" ;

                //?????[??][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle0, true);
                InitHeadRow(1, HeadTitle1, true);
                InitHeadRow(2, HeadTitle2, true);

                //?????    [ROW, COL,  DATATYPE,  WIDTH,   DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtData,       90,    daCenter, true,   "eq_no",              false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       50,    daCenter, true,   "cntr_tpsz_cd",       false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       90,    daCenter, true,   "bkg_no",             false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       90,    daCenter, true,   "bl_no",              false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       80,    daLeft,   true,   "fctry_nm",           false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       100,   daLeft,   true,   "act_cust_n1st_addr", false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       50,    daLeft,   true,   "act_cust_zip_cd",    false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       40,    daLeft,   true,   "cntc_pson_nm",       false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       40,    daLeft,   true,   "cntc_pson_phn_no",   false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       40,    daLeft,   true,   "cntc_pson_fax_no",   false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,      120,    daLeft,   true,   "do_rmk",             false,          "",       dfNone,       0,     true,        false);
                InitDataProperty(0, cnt++ , dtData,       80,    daLeft,   true,   "po_no",              false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       80,    daLeft,   true,   "bkg_spe",            false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       80,    daLeft,   true,   "full_pickup_cy",     false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       80,    daLeft,   true,   "mty_rtn_cy",         false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       80,    daLeft,   true,   "cmdt",               false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  daCenter, false,   "ibflag");
                
                RangeBackColor(1, 4, 1, 13) = RgbColor(222, 251, 248);  // ENIS
                HeadRowHeight= 10;
           }
           break; 
        case 3:      //sheet3 init
            with (sheetObj) {
                // ?? ??
                style.height = 0;
                //?? ?? ??
                SheetWidth = mainTable.clientWidth;

                //Host?? ??[??][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    
                //??Merge ?? [??, Default msNone]
                MergeSheet = msHeaderOnly;
    
               //??Edit ?? ?? [??, Default false]
                Editable = true;
    
                //?????[??][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 9, 100);
    
                //??????[??][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(1, 0, 0, true);
    
                // ???? ??? ? ?? ?? ??? ????
                InitHeadMode(true, true, false, true, false,false)
                
                var HeadTitle0 = "trsp_so_seq" ;
    
                //?????[??][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle0, true);
    
                //?????    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtData,       90,    daCenter, true,    "trsp_so_seq",    false,          "",       dfNone,       0,     true,       false);

                HeadRowHeight= 10;
           }
           break;
        }
    }

var beforesheet = 0 ;
/**
 * Tab ??? ??? ??
 * ??? ?? ??? ??? ??.
 */
function ChangSheet(nItem)
{
    var objs = document.all.item("tabLayer");
    objs[nItem].style.display = "Inline";
    objs[beforesheet].style.display = "none";

    //--------------- ??? ?? --------------------------//
    objs[beforesheet].style.zIndex = objs[nItem].style.zIndex -1 ;
    //------------------------------------------------------//
    beforesheet= nItem;
}

// Sheet?? ???? ??
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;
    switch(sAction) {
       case IBSEARCH:      //??
            formObj.f_cmd.value = SEARCH;
            sheet1_Clear();
            sheetObj.DoSearch4Post("ESD_TRS_0083_01GS.do", TrsFrmQryString(formObj));               
            sheetObj.ExtendLastCol = false;
            break;
       case IBSAVE:        //??
            break;
       case IBINSERT:      // ??
            sheetObj.DataInsert();
            break;        
    }
}

// Sheet?? ???? ??
function doActionIBSheet2(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;
    switch(sAction) {
       case IBSEARCH:      //??
            formObj.f_cmd.value = SEARCH01;
            sheetObj.DoSearch4Post("ESD_TRS_0083_01GS.do", TrsFrmQryString(formObj));               
            sheetObj.ExtendLastCol = false;
            break;
       case IBSAVE:        //??
            formObj.f_cmd.value = MULTI;
            sheetObj.DoSave("ESD_TRS_0083_01GS.do", TrsFrmQryString(formObj),-1, false);
            //sheetObj.DoAllSave("ESD_TRS_0083_01GS.do", TrsFrmQryString(formObj));
            break;
    }
}

// Sheet?? ???? ??
function doActionIBSheet3(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;
    switch(sAction) {
       case IBSEARCH:      //??
            formObj.f_cmd.value = SEARCH02;
            sheetObj.DoSearch4Post("ESD_TRS_0083_01GS.do", TrsFrmQryString(formObj));               
            sheetObj.ExtendLastCol = false;
            break;            
    }
}

function Minimize(nItem)
{
	var objs = document.all.item("showMin");

	if ( nItem == "1" )
	{
		objs.style.display = "none";
		sheetObjects[1].style.height = sheetObjects[1].GetSheetHeight(28);
	}
	else
	{
		objs.style.display = "inline";
		sheetObjects[1].style.height = sheetObjects[1].GetSheetHeight(20);
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg)
{
    var sheetObject1 = sheetObjects[1];
    var sheetObject2 = sheetObjects[2];
    var formObject = document.form;
    
    //Consignee ?? ?? ?? ? ????? ????.
    if (sheetObj.RowCount > 0) {
        var preRowLoc = sheetObj.CellValue(1, 'dor_loc_cd');
        var curRowLoc = "";
        var errMessage = "";
        
        var naCd = preRowLoc.substr(0,2);
        if (!(naCd == 'US' || naCd == 'CA')) //??, ??? ??? ??? ?? ?? 
        {
            ComShowCodeMessage('TRS90386','System only accepts US and CA I/B Door');
            return; 
        }
        
        if (sheetObj.RowCount > 1) {
            for(var i=1; i<=sheetObj.RowCount; i++) {
                curRowLoc = sheetObj.CellValue(i, 'dor_loc_cd');
                if (curRowLoc != preRowLoc) {
                    ComShowCodeMessage('TRS90386','Multiple DEL are not allowed');
                    return; 
                }
                preRowLoc = curRowLoc;     
            }
        }

        document.form.cust_cnt_cd.value = sheetObj.CellValue(1, 'cust_cnt_cd');
        document.form.cust_seq.value = sheetObj.CellValue(1, 'cust_seq');
        document.form.cust_nm.value = sheetObj.CellValue(1, 'cust_nm');
        document.form.dor_loc_cd.value = sheetObj.CellValue(1, 'dor_loc_cd');
        document.form.zone_cd.value = sheetObj.CellValue(1, 'zone_cd');
    }else{
        sheet1_Clear();
    }
    doActionIBSheet2(sheetObject1,formObject,IBSEARCH);
    doActionIBSheet3(sheetObject2,formObject,IBSEARCH);
}

function sheet1_Clear()
{
    document.form.cust_cnt_cd.value = "";
    document.form.cust_seq.value = "";
    document.form.cust_nm.value = "";
    document.form.dor_loc_cd.value = "";
    document.form.zone_cd.value = "";
    
    document.form.address.value = "";
    document.form.zip_code.value = "";
    document.form.pic.value = "";
    document.form.tel.value = "";
    document.form.fax.value = "";
    document.form.remark.value = "";
    
    var sheetObject1 = sheetObjects[1];
    var sheetObject2 = sheetObjects[2];
    sheetObject1.RemoveAll();
    sheetObject2.RemoveAll();
}

/**
 * ????? ??? ???? ? ?????? ??
 * IBSheetConfig.js?? DataSheetObject.prototype.event_OnSearchEnd?? ??
 */
function sheet2_OnSaveEnd(sheetObj,errMsg){
		if(errMsg!=null){
			ComShowMessage(errMsg);
		}
}

function sheet3_OnSearchEnd(sheetObj, ErrMsg)
{
	var sheetObject2 = sheetObjects[2];
    if (sheetObject2.RowCount > 0) {
        ComShowCodeMessage('TRS90386','S/O has already been created');
    }
}

/*
 * type : 0 =?? ???
 *     : 1 =?? loc
 */
function displayType(type){
    with(document.form)
    {   
        if(type == 0){//load? 
        }else{
             if(type.value == '') {
             } else {
             }
        }
    }
}    
  
/**
 * ?? Trunk VVD popup
 */
function openMultipleinquiry(obj, obj2) {
    var formObject = document.form;
    var cmdt_cd_val ="";   //?? ???? ????
    var rep_cmdt_cd_val ="";   //?? ???? ????
    var cmdt_desc_val ="";   //?? ???? ????
    var xx1 = ""; //CONTI
    var xx2 = ""; //SUB CONTI
    var xx3 = ""; //COUNTRY
    var xx4 = ""; //STATE
    var xx5 = ""; //CONTROL OFFIC
    var xx6 = ""; //LOC CODE
    var xx7 = ""; //LOC NAME
    var xx8 = "";
    var xx9 = "";
    var classId = "getTRS_ENS_906";
    
    var param ="?returnval="+obj+"&returntitle="+obj2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
    ComOpenPopup('/hanjin/ESD_TRS_0906.do' + param, 400, 330, "getTRS_ENS_906", '1,0,1,1,1,1,1,1');
}

/**
 * Location : ???? ?? ??? ???..
 */
function getTRS_ENS_906(rowArray, obj) {
    var reObj = "";
    var formObject = document.form;
    for(var i=0; i<rowArray.length; i++) {
        var colArray = rowArray[i];
        if( i == rowArray.length-1 ) {
          reObj = reObj + colArray;
        } else {
          reObj = reObj + colArray + ",";
        }
    }
    if( obj == "BKG" ) {
        formObject.booking_no.value = reObj;	
    } else if( obj == "BLN" ) {
        formObject.bill_no.value = reObj;
    } else {
        ComShowCodeMessage('TRS90132');
    }
}

// Pop-Up? Return ? Actual Customer
/* 0. TARGET ROW
 * 1. ACTUAL CUSTOMER CODE
 * 2. ACTUAL CUSTOMER NAME
 * 3. FACTORY NAME
 * 4. FACTORY ZIP CODE
 * 5. FACTORY ADDRESS
 * 6. FACTORY ADDRESS SEQ.
 * 7. TEL NO
 * 8. FAX NO
 * 9. PIC NAME
 */
function applyAtualCustomer(winObj, selected_row, act_cust_cd, act_cust_cnt_cd, act_cust_seq, act_cust_addr_seq, act_cust_nm, factory_nm, factory_zip_code, factory_addr, factory_tel_no, factory_fax_no, pic_nm) {
    var formObject = document.form;
    formObject.cust_cnt_cd.value = act_cust_cnt_cd;
    formObject.cust_seq.value    = act_cust_seq;
    
    formObject.cust_nm.value  = factory_nm;
    formObject.address.value  = factory_addr;
    formObject.zip_code.value = factory_zip_code;
    formObject.pic.value      = pic_nm;
    formObject.tel.value      = factory_tel_no;
    formObject.fax.value      = factory_fax_no;

    winObj.close();
}