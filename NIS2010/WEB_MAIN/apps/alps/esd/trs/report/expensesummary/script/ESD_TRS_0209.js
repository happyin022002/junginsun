/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0209.js
*@FileTitle : Expense Summary by Office (Detail Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009-01-16
*@LastModifier : ay han
*@LastVersion : 1.6 
* 2009-02-27 ay han
* 1.0 ?? ?? 
* N200901080024  2009-02-27 'Report(Expense Summary by Office) ?? ?? ?? ' 
* 2011.07.20 민정호 [CHM-201112196] Expense Summary Report에 Invoice 상태코드를 조회조건에 추가
=========================================================*/ 

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0209 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0209() {
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
var Mincount = 0;

var comboObjects = new Array();
var comboCnt = 0 ; 

var rdObjects = new Array();
var rdCnt = 0;

/* ???????? ?? ???? ??????  ?? */
document.onclick = processButtonClick;

/* ?? ???? ???? ????? ?????? ?????? */
function processButtonClick(){
    var formObject = document.form; 
    var rdObject = rdObjects[0];
    try {
        var srcName = window.event.srcElement.getAttribute("name");
        switch(srcName) {
            case "btn_close":
                window.close();
                break;
            case "btng_print":          
                rdObject.PrintDialog();
                break;
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            errMsg = ComGetMsg("TRS90392" );
            ComShowMessage(errMsg);
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
    rdOpen(); 
    //rdObjects[0].PrintDialog();
    
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
    //Axon ??? ??1. ???catch
    /*
    axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
    axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
    axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
    axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
    axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
    axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리 
    axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
    */
}

//Axon ??? ??2. ??????? --- start
/**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 **/
function engnum_keypress() {
    //???? ????
//            ComKeyOnlyAlphabet('uppernum');
}

/**
 * BKG Creation?? manual? ???? ??? ????. <br>
 **/
function manual_click() {
    //manual이 체크된 경우만 Bkg_no를 편집 가능으로 한다.
//            form.boo_bkg_no.readOnly =!form.manual.checked;
}

/**
 * BKG Creation탭의 Booking No가 바뀐경우 기능을 처리한다. <br>
 **/
function bkgno_keyup() {
    //bkg_no를 수정해서 저장된값과 다른경우 bl_no를 지우고, 같은경우 bl_no를 살린다.
    /*
    if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
	form.boo_bl_no.value = "";
    else
	form.boo_bl_no.value = form.hdn_boo_bl_no.value;
	*/
}

/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 **/
function obj_blur(){
    //입력Validation 확인하기
//            return ComChkObjValid(event.srcElement);
}

/**
 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
 **/
function obj_focus(){
    //?????? ???
//            ComClearSeparator(event.srcElement);
}

/**
 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
 **/
function obj_keypress(){
    //???????
//            ComKeyOnlyNumber(event.srcElement);
}

//Axon 이벤트 처리2. 이벤트처리함수 --- end
  
function rdOpen(){
    var formObject = document.form; 
    rdObjects[0].AutoAdjust = true;
    //rdObjects[0].HideToolbar(); // ?????/??/?? ? TOOLBAR  ???
	rdObjects[0].SetSaveDialogEx("", "Expense Summary by Office", "EXCEL", "xls");   // ????? ?? (???, ?????)
	rdObjects[0].DisableToolbar(14); //MS-WORD TOOLBAR DISABLE
	rdObjects[0].DisableToolbar(15); //MS-PowerPoint TOOLBAR DISABLE
	rdObjects[0].DisableToolbar(16); //?? TOOLBAR DISABLE 
	rdObjects[0].DisableToolbar(17); //pdf TOOLBAR DISABLE 
    rdObjects[0].HideStatusbar();
    rdObjects[0].ViewShowMode(2); 
    rdObjects[0].setbackgroundcolor(255,255,255);
    rdObjects[0].SetPageLineColor(255,255,255); 

    rdObjects[0].AutoAdjust = 0;
    rdObjects[0].ZoomRatio  = 160; 
    
    var statusCdGubun = '';
    var statusCd = formObject.status_cd.value;
    var arrStatusCD = statusCd.split(',');    
    if(arrStatusCD[0] == ""){
    	statusCdGubun = "";
    }else{
    	statusCdGubun = "1";
    }     
    if(arrStatusCD[0] == undefined) arrStatusCD[0] = "";	// RC
    if(arrStatusCD[1] == undefined) arrStatusCD[1] = "";	// SV
    if(arrStatusCD[2] == undefined) arrStatusCD[2] = "";	// CF
    if(arrStatusCD[3] == undefined) arrStatusCD[3] = "";    // AR	
    if(arrStatusCD[4] == undefined) arrStatusCD[4] = "";	// DA
    if(arrStatusCD[5] == undefined) arrStatusCD[5] = "";	// IF
    if(arrStatusCD[6] == undefined) arrStatusCD[6] = "";	// RJ
    if(arrStatusCD[7] == undefined) arrStatusCD[7] = "";	// PD    	
    
    var ioBnd = formObject.io_bnd.value;       
    var arrIoBnd = ioBnd.split(','); 
        
    if(arrIoBnd[0] == undefined) arrIoBnd[0] = "";			
    if(arrIoBnd[1] == undefined) arrIoBnd[1] = "";	         
    if(arrIoBnd[2] == undefined) arrIoBnd[2] = "";	  
    if(arrIoBnd[3] == undefined) arrIoBnd[3] = "";
    
    url = RD_path + 'apps/alps/esd/trs/report/expensesummary/report/ESD_TRS_0104_DTL_RD.mrd';              
    var rdParam = "/rp ["+(formObject.period.value)+"]"        			// 1.Date??
                   + " ["+(formObject.from_date.value)+"]"            	// 2.From date
                   + " ["+(formObject.to_date.value)+"]"                // 3.To date              
                   + " ["+(formObject.wo_ofc_cd.value)+"]"          	// 4.w/o Office ??
                   + " ["+(formObject.inv_ofc_cd.value)+"]"          	// 5.invoice Office ??
                   + " ["+(formObject.costmode.value)+"]"           	// 6.Cost Mode
                   + " ["+(formObject.transmode.value)+"]"          	// 7.Trans Mode
                   + " ["+(formObject.sotype.value)+"]"                 // 8.S/O Type     
                   + " ["+(formObject.bkg_term.value)+"]"             	// 9.bkg_term               
                   + " ["+(formObject.fm_loc.value)+"]"                 // 10.FROM NODE
                   + " ["+(formObject.via_loc.value)+"]"                // 11.VIA NODE
                   + " ["+(formObject.to_loc.value)+"]"                 // 12.TO NODE
                   + " ["+(formObject.door_loc.value)+"]"             	// 13.DOOR NODE         
                   + " ["+(formObject.sotype_nm.value)+"]"          	// 14.S/O Type name  --????? ?? HEAD???
                   + " ["+(formObject.node_div.value)+"]"           	// 15.node_div   --????? ?? HEAD???
                   + " ["+(formObject.bkg_term_nm.value)+"]"      		// 16.bkg_term  name  --????? ?? HEAD???         
                   + " ["+(formObject.search_fm_loc.value)+"]"          // 17.FROM NODE  ?? ?? 
                   + " ["+(formObject.search_via_loc.value)+"]"         // 18.VIA NODE ?? ?? 
                   + " ["+(formObject.search_to_loc.value)+"]"          // 19.TO NODE ?? ?? 
                   + " ["+(formObject.search_door_loc.value)+"]"        // 20.DOOR NODE ?? ??
    			   + " ["+statusCdGubun+"]"        // 21,status_cd 구분 1: 존재, 0: 미존재
    			   + " ["+arrStatusCD[0]+"]"       // 22,RC
    			   + " ["+arrStatusCD[1]+"]"       // 23,SV
    			   + " ["+arrStatusCD[2]+"]"       // 24,CF
    			   + " ["+arrStatusCD[3]+"]"       // 25,AR
    			   + " ["+arrStatusCD[4]+"]"       // 26,DA
    			   + " ["+arrStatusCD[5]+"]"       // 27,IF
    			   + " ["+arrStatusCD[6]+"]"       // 28,RJ
    			   + " ["+arrStatusCD[7]+"]"       // 29,PD
    			   + " ["+arrIoBnd[0]+"]"       // 30.IO Bound
	   			   + " ["+arrIoBnd[1]+"]"       // 31.IO Bound  
	   			   + " ["+arrIoBnd[2]+"]"       // 32.IO Bound  
	   			   + " ["+arrIoBnd[3]+"]"       // 33.IO Bound
	   			   + " ["+(formObject.inv_curr.value)+"]";      // 34.INV_CURR_CD
 
    rdObjects[0].FileOpen( url, RDServer + rdParam);    
  }