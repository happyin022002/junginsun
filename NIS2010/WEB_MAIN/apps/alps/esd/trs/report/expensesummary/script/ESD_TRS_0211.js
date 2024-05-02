/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0211.js
*@FileTitle : Expense Summary by S/P (Detail Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009-01-16
*@LastModifier : jh choi
*@LastVersion : 1.4
* 2009-01-16 jh choi
* 1.0 ?? ?? 
* @history
* N200901080023 2009-03-04 Expense Summary Report S/P ????
* 2011.07.20 민정호 [CHM-201112196] Expense Summary Report에 Invoice 상태코드를 조회조건에 추가
=========================================================*/ 

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0211 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0211() {
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

	rdObjects[0].SetSaveDialogEx("", "Expense Summary by SP", "EXCEL", "xls");   // ????? ?? (???, ?????)
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
	
	
	// Date ?? ???? ??
	var period = formObject.period.value;
	
	var period_so = "";
	var period_wo = "";
	var period_iv = "";
	var period_gl = "";
	
	if( period == "S") {
	    period_so = "T";
	}else if( period == "W") {
	    period_wo = "T";
	}else if( period == "I") {
	    period_iv = "T";
	}else if( period == "G") {
	    period_gl = "T";
	}
	
	var period_gb1 = "";
    var period_gb2 = "";

    //gl date와 나머지는 날짜의 데이타 타입이 다르므로 rd에서 인식 할 수 있도록 구분 필드를 넘겨준다.
    if (period == "S" || period == "W" || period == "I" ) {
    	period_gb1 = "Y";
    	period_gb2 = "";
    }else{
    	period_gb1 = "";
    	period_gb2 = "Y";
    }
    
    
    // Office ?? ???? ??
    var r_office = formObject.radio_office.value;
    var r_office_wo = "";
    var r_office_iv = "";
    
    if( r_office == "WO") {
        r_office_wo = "T";
    }else if( r_office == "IV") {
        r_office_iv = "T";
    }
    
    // Vender ?? ???? ??
    var r_vender = formObject.sp_tp.value;
    var r_vender_wo = "";
    var r_vender_iv = "";

    if( r_vender == "WO") {
        r_vender_wo = "T";
    }else if( r_vender == "IV") {
        r_vender_iv = "T";
    }

    var statusCdGubun = '';
    var tmpStatusCd0 = "";
    var tmpStatusCd1 = "";
    var tmpStatusCd2 = "";
    var tmpStatusCd3 = "";
    var tmpStatusCd4 = "";
    var tmpStatusCd5 = "";
    var tmpStatusCd6 = "";
    var tmpStatusCd7 = "";    
    var statusCd = formObject.status_cd.value;       
    var arrStatusCD = statusCd.split(','); 
    if(arrStatusCD[0] == "" || arrStatusCD[0] == "INV"){
    	statusCdGubun = "";
    }else{
    	statusCdGubun = "1";
    }      
    
    if(arrStatusCD[0] != "INV"){
    	tmpStatusCd0 = arrStatusCD[0];
    	tmpStatusCd1 = arrStatusCD[1];
    	tmpStatusCd2 = arrStatusCD[2];
    	tmpStatusCd3 = arrStatusCD[3];
    	tmpStatusCd4 = arrStatusCD[4];
    	tmpStatusCd5 = arrStatusCD[5];
    	tmpStatusCd6 = arrStatusCD[6];
    	tmpStatusCd7 = arrStatusCD[7];
    	    	
    	arrStatusCD[1] = tmpStatusCd0;
    	arrStatusCD[2] = tmpStatusCd1;
    	arrStatusCD[3] = tmpStatusCd2;
    	arrStatusCD[4] = tmpStatusCd3;
    	arrStatusCD[5] = tmpStatusCd4;
    	arrStatusCD[6] = tmpStatusCd5;
    	arrStatusCD[7] = tmpStatusCd6;
    	arrStatusCD[8] = tmpStatusCd7;
    	arrStatusCD[0] = "";    	    	
    }
        
    if(arrStatusCD[0] == undefined) arrStatusCD[0] = "";	// INV			
    if(arrStatusCD[1] == undefined) arrStatusCD[1] = "";	// RC         
    if(arrStatusCD[2] == undefined) arrStatusCD[2] = "";	// SV         
    if(arrStatusCD[3] == undefined) arrStatusCD[3] = "";	// CF         
    if(arrStatusCD[4] == undefined) arrStatusCD[4] = "";	// AR	      
    if(arrStatusCD[5] == undefined) arrStatusCD[5] = "";	// DA         
    if(arrStatusCD[6] == undefined) arrStatusCD[6] = "";	// IF         
    if(arrStatusCD[7] == undefined) arrStatusCD[7] = "";	// RJ         
    if(arrStatusCD[8] == undefined) arrStatusCD[8] = "";	// PD   	
    
    var ioBnd = formObject.io_bnd.value;       
    var arrIoBnd = ioBnd.split(','); 
        
    if(arrIoBnd[0] == undefined) arrIoBnd[0] = "";			
    if(arrIoBnd[1] == undefined) arrIoBnd[1] = "";	         
    if(arrIoBnd[2] == undefined) arrIoBnd[2] = "";	  
    if(arrIoBnd[3] == undefined) arrIoBnd[3] = "";	
    
    url = RD_path + 'apps/alps/esd/trs/report/expensesummary/report/ESD_TRS_0107_DTL_RD.mrd';
    var rdParam = "/rp ["+(formObject.period.value)+"]"        // 1.Date??
                   + " ["+(formObject.from_date.value)+"]"     // 2.From date
                   + " ["+(formObject.to_date.value)+"]"       // 3.To date
                   + " ["+(formObject.radio_office.value)+"]"  // 4.Office ??
                   + " ["+(formObject.ofc_cd.value)+"]"        // 5.Office ??
                   + " ["+(formObject.sp_tp.value)+"]"         // 6.Vender ??
                   + " ["+(formObject.vndr_seq.value)+"]"      // 7.Vender ??
                   + " ["+(formObject.costmode.value)+"]"      // 8.Cost Mode
                   + " ["+(formObject.transmode.value)+"]"     // 9.Trans Mode
                   + " ["+(formObject.sotype.value)+"]"        //10.S/O Type
                   + " ["+(formObject.sotype_nm.value)+"]"     //11.S/O Type name
                   + " ["+(formObject.node_div.value)+"]"      //12.node_div
                   + " ["+(formObject.row_fm_loc.value)+"]"        //13.FROM NODE
                   + " ["+(formObject.row_via_loc.value)+"]"       //14.VIA NODE
                   + " ["+(formObject.row_to_loc.value)+"]"        //15.TO NODE
                   + " ["+(formObject.row_door_loc.value)+"]"     //16.DOOR NODE
                   + " ["+(formObject.fm_loc.value)+"]"        //17.FROM NODE
                   + " ["+(formObject.via_loc.value)+"]"       //18.VIA NODE
                   + " ["+(formObject.to_loc.value)+"]"        //19.TO NODE
                   + " ["+(formObject.door_loc.value)+"]"     //20.DOOR NODE
    			   + " ["+period_gb1+"]"     				//21.날짜형이 date type
    			   + " ["+period_gb2+"]"				    //22.날짜형이 varchar2 type
	   			   + " ["+statusCdGubun+"]"        // 23,status_cd 구분 1: 존재, 0: 미존재	   			   
	   			   + " ["+arrStatusCD[0]+"]"    // 24,INV   
	   			   + " ["+arrStatusCD[1]+"]"	// 25,RC      
	   			   + " ["+arrStatusCD[2]+"]"    // 26,SV   
	   			   + " ["+arrStatusCD[3]+"]"    // 27,CF   
	   			   + " ["+arrStatusCD[4]+"]"    // 28,AR   
	   			   + " ["+arrStatusCD[5]+"]"    // 29,DA   
	   			   + " ["+arrStatusCD[6]+"]"    // 30,IF   
	   			   + " ["+arrStatusCD[7]+"]"    // 31,RJ        
	   			   + " ["+arrStatusCD[8]+"]"    // 32,PD  
                   + " ["+arrIoBnd[0]+"]"       // 33.IO Bound
                   + " ["+arrIoBnd[1]+"]"       // 34.IO Bound  
                   + " ["+arrIoBnd[2]+"]"       // 35.IO Bound  
                   + " ["+arrIoBnd[3]+"]"       // 36.IO Bound
                   + " ["+(formObject.inv_curr.value)+"]";      // 37.INV_CURR_CD
    
    rdObjects[0].FileOpen( url, RDServer + rdParam);
  }