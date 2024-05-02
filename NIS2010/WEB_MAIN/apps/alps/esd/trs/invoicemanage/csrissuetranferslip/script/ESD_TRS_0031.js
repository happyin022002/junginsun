/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0031.js
*@FileTitle : TRS invoice CSR Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.25
*@LastModifier : 조인영
*@LastVersion : 1.3
* 2009.02.23 조풍연
* 1.0 Creation
* ----------------------------------------------------------
* History
* 2013.01.25 조인영 [CHM-201322577-01] CSR creation approval step 로직 개선
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0031 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0031() {
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

/* ???????? ?? ???? ?????? ?? */
document.onclick = processButtonClick;

/* ?? ???? ???? ????? ?????? ?????? */
function processButtonClick(){
     /***** ?? ??? 2? ??? ??? ?? ???? ???? ??? *****/
     var sheetObject = sheetObjects[0];

     /*******************************************************/
     var formObject = document.form;
     var formObject1 = document.form1;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

    case "btn_retrieve":
		if (!checkCntCd(cnt_cd))  return;
        doActionIBSheet(sheetObject,formObject,IBSEARCH);
        break;

	case "btn_new":
        sheetObject.RemoveAll();
        formObject.reset();
        break;
    	         
    case "btng_provider":      	   
        rep_OnPopupClick();
		break;       

	case "btng_detail":
		
 		if(sheetObjects[0].SelectRow == 0){
            errMsg = ComGetMsg("TRS90036" );
            ComShowMessage(errMsg);
 			return false;	
 		}
				
      formObject1.vndr_seq.value  			= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "vndr_no");
      formObject1.vndr_seq_name.value		= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "vndr_seq_name"); 
      formObject1.curr_cd.value 			= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "curr_cd");
      formObject1.gen_pay_term_cd.value		= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "gen_pay_term_cd"); 
      formObject1.pay_term_tp_cd.value		= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "pay_term_tp_cd");
      formObject1.payment_due_dt.value		= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "payment_due_dt"); 
      formObject1.asanogb.value				= getElementValue(formObject, 'radio', 'asanogb');
      formObject1.cost_office_cd.value		= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "so_ofc_cd"); 
      formObject1.conti_cd.value 			= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "conti_cd"); 
      formObject1.form_inv_cfm_dt.value 	= formObject.inv_cfm_dt.value;
      formObject1.pgmNo.value				= "ESD_TRS_0032"; 
      /** Only 'SZPSC' + 'CANSO' */
      /** Only 'SZPBB' + 'CANBS' */
      formObject1.paymenttype.value 	  = getElementValue(formObject, 'radio', 'paymenttype'); 
      
      //jsk:alert(formObject1.paymenttype.value);return;
		//ComPostOpenWindow("ESD_TRS_0032.do", "noRtnPopup", "width=1030,height=550,menubar=0,status=0,scrollbars=0,resizable=0");
		//formObject1.target = 'noRtnPopup';
		//formObject1.submit();

//      formObject1.submit();

      //ComPostOpenWindow 에서 submit() 를 실행 하고 있어 중복 submit 실행 방지를 위해서 아래의 방식으로 처리
      window.open("", "noRtnPopup", "width=1030,height=550,menubar=0,status=0,scrollbars=0,resizable=0");
      formObject1.action = "ESD_TRS_0032.do";
      formObject1.target = "noRtnPopup";
      formObject1.method = "post";
      formObject1.submit();
	  break;

	case "btns_calendar1":
			var cal = new ComCalendar();
			cal.select(formObject.inv_cfm_dt, 'yyyy-MM-dd');
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

    for(i=0;i<sheetObjects.length;i++){

    //khlee-?? ?? ?? ?? ?? ??
        ComConfigSheet(sheetObjects[i]);

        initSheet(sheetObjects[i],i+1);
    //khlee-??? ?? ?? ?? ??
            ComEndConfigSheet(sheetObjects[i]);
        }

        doActionIBSheet2(sheetObjects[1] , document.form , IBSEARCH);

        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		//html컨트롤 이벤트초기화
//		initControl();
        
    }

        /**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
         * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
         * @param {ibsheet} sheetObj    IBSheet Object
         * @param {int}     sheetNo     sheetObjects 배열에서 순번
         **/
        function initControl() {
            //Axon ??? ??1. ???catch
//            axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
//            axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
//            axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
//            axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
//            axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
//            axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리 
//            axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
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
                style.height = GetSheetHeight(13);
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
                InitColumnInfo(11, 1, 0, true);

                // ???? ??? ? ?? ?? ??? ????
                InitHeadMode(true, true, false, true, false,false)

                var HeadTitle = "Seq.|Cost Office|S/P Code|S/P Name|No of Invoice|Invoice Currency|Total Amount" ;

                //?????[??][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //?????    [ROW, COL, DATATYPE,WIDTH, DATAALIGN, COLMERGE, 		SAVENAME,  						KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

				InitDataProperty(0, cnt++ , dtSeq,	 		30,		daCenter,			false,    "",										false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 	    80,		daCenter,			false,    "so_ofc_cd",							false,			"",			dfNone,			0,			false,			false	); 
				InitDataProperty(0, cnt++ , dtData,	 		80,	    daCenter,			false,    "vndr_no",						false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 		200,	daLeft,				false,    "vndr_seq_name",			false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 		120,	daCenter,			false,    "cnt_inv",						false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 		120,	daCenter,			false,    "curr_cd",						false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 		80,		daRight,			false,    "total_amt",					false,			"",			dfFloat,		2,			false,			false	); 
				InitDataProperty(0, cnt++ , dtHidden,	 	1,		daCenter,			false,    "gen_pay_term_cd",		false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtHidden,	 	1,		daCenter,			false,    "pay_term_tp_cd",		false,			"",			dfNone,			0,			false,			false	);
				
				InitDataProperty(0, cnt++ , dtHidden,	 	1,		daCenter,			false,    "payment_due_dt",		false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtHidden,	 	1,		daCenter,			false,    "conti_cd",		false,			"",			dfNone,			0,			false,			false	);
            }
            break;

			case 2:      //hidden sheet
					with (sheetObj) {
				// 높이 설정
				style.height= 0;
				//전체 너비 설정
				SheetWidth = 0;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(3, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				var HeadTitle1 = "Del.|STS|Liv" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				//?????    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,			FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,  false,		"",				false,    "",		  dfNone,		  0,		  true,		  true,		 0,				false,	 true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtHiddenStatus,     30,    daCenter,  false,		"ibflag",		false,    "",		  dfNone,		  0,		  false,      false,	 0,				false,	 true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtPopup,      40,    daLeft,  true,		"vndr_nm",		false,		"",			dfNone,         0,       false,     true,		100,			false,	 true,	   "",	  false);
		   }
			break;
    }
}

  // Sheet?? ???? ??
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {

       case IBSEARCH:      //??

             //if(validateForm(sheetObj,formObj,sAction))
           		formObj.f_cmd.value = SEARCHLIST;                  
            	sheetObj.DoSearch4Post("ESD_TRS_0031GS.do", TrsFrmQryString(formObj));
            break;

       case IBINSERT:      // ??
            sheetObj.DataInsert();
            break;

       case IBCOPYROW:        //? ??
          sheetObj.DataCopy();
          break;

       case IBDOWNEXCEL:        //?? ????
          sheetObj.Down2Excel(-1, false, false, true);

          break;

       case IBLOADEXCEL:        //?? ???
              sheetObj.LoadExcel();
              break;

        }
    }

  // Sheet?? ???? ??
function doActionIBSheet2(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {

       case IBSEARCH:      //??

             //if(validateForm(sheetObj,formObj,sAction))
           		formObj.f_cmd.value = SEARCH01;                  
            	sheetObj.DoSearch4Post("ESD_TRS_0031GS.do", TrsFrmQryString(formObj));
//				sheetObj.GetSearchXml("ESD_TRS_0031GS.do", TrsFrmQryString(formObj));	//ALPS ETCDATA 사용


                break;


        }
    }   

function sheet2_OnSearchEnd(sheetObj , ErrMsg)
{
    if ( ErrMsg != "") return;
  
   
    var asaFlag       = sheetObj.EtcData("asaFlag");   
    var cost_ofc_cd   = document.form.cost_ofc_cd.value;
    cost_ofc_cd       = cost_ofc_cd != undefined && cost_ofc_cd != null ? cost_ofc_cd : '';
    
    if (asaFlag == "O")      //  O : "Open"
    {
        if (cost_ofc_cd == 'SZPSC' || cost_ofc_cd == 'CANSO')
        {
    	    document.form.asanogb[0].disabled = false;
    	    document.form.asanogb[1].disabled = false;  
    	}else{
      	    document.form.asanogb[0].disabled = true;
      	    document.form.asanogb[1].disabled = false;
    	}
    	document.form.asanogb[1].checked  = true;    //JSK 2007-07-25
    	
    }else{
        document.form.asanogb[0].disabled = false;        
        document.form.asanogb[1].disabled = true;
        
        document.form.asanogb[0].checked  = true;    //JSK 2007-07-25
    }        
       
       
    if (cost_ofc_cd == 'SZPSC' || cost_ofc_cd == 'CANSO')
    {
	    document.form.asanogb[0].disabled = false;
	    document.form.asanogb[1].disabled = true;  
	}
    ////////////////////////////////////////////////////////////////
       
}
   
   /**
 * ?? ????? ?? ????? ???? ??
 */
function validateForm(sheetObj, formObj, sAction){
    with(formObj){
//            if (!ComIsNumber(iPage)) {
//
//                return false;
//            }
    }

    return true;
}

  /**
 * MInimize ??? ??? ??
 */
function Minimize(nItem)
{

    var objs = document.all.item("showMin");

    if ( nItem == "1" )
    {
	    objs.style.display = "none";


        sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(20);
		sheetObjects[0].focus();
		sheetObjects[0].ViewRows  =20;

	}
	else
	{
	    objs.style.display = "inline";

	    sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(10);
		sheetObjects[0].focus();
		sheetObjects[0].ViewRows  =10;

	}

}

function isNum(obj){
	//???..
	if (!ComIsNumber(obj)){
		obj.value = '';
	}
}

function isNum1(obj){
	//???..
	if (!isNumDash(obj)){
		obj.value = '';
	}
}		

function isDate1(obj){
	//???..
	if (!ComIsDate(obj)){
		obj.value = '';
 
			}
		}				    
		
function getVender(rowArray) {  
	var colArray = rowArray[0];
	document.form.vndr_seq.value = colArray[2];
	document.form.vndr_seq_name.value = colArray[4];
}		
    
function getElementCnt(formObject, eleTp, eleNm) {
	
		//form?? element??/element?? ???? ?? ??
	
	var cnt = 0;
	var element;
	var numOfEle = formObject.elements.length;
	for (var i = 0; i < numOfEle; i++){
		if (formObject.elements[i].type == eleTp && formObject.elements[i].name == eleNm){
			cnt++;
		}
	}

	return cnt;
}

function getElementValue(formObject, eleTp, eleNm) {

	var element;
	var numOfEle = formObject.elements.length;
	for (var i = 0; i < numOfEle; i++){
		if (formObject.elements[i].type == eleTp && formObject.elements[i].name == eleNm){
			if (formObject.elements[i].checked == true){ 
				var ele_value = formObject.elements[i].value;
				break;
			}			
		}
	}

	return ele_value;
}    

function checkCntCd(cnt_cd){
 		if(cnt_cd==""){
            errMsg = ComGetMsg("TRS90112" );
            ComShowMessage(errMsg);		
			return false;	
 		}
 		return true;
}			
	
/**
 * rep_commodity????
 */
function rep_OnPopupClick()
{

	var formObject = document.form;
	var cmdt_cd_val ="";   //?? ???? ????
	var rep_cmdt_cd_val ="";   //?? ???? ????
	var cmdt_desc_val ="";   //?? ???? ????
	var classId ="getCOM_ENS_rep";
	var xx1="";  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";

	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 612, 450, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');

}	

/**
 * rep_commodity???? : ???? ?? ??? ???..
 */
function getCOM_ENS_rep(rowArray) {

	var formObj = document.form;
	
	for(var i=0; i<rowArray.length; i++)
	{
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[4];
		
		formObj.combo_svc_provider.value = colArray2;
		formObj.svc_provider.value = colArray3;
	}
}

/**
 * enter check
 **/
function enterCheck(obj)
{   
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	if(event.keyCode == 13)
	{
		switch(obj.name){
		    
			case 'combo_svc_provider':
				getTextVendorSeq(sheetObj, formObj, obj.value);
				break;		    

		}
	}
}	