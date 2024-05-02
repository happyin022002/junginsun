/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_TRS_0041.js
 *@FileTitle : Pool Chassis reposition cost 처리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2008-12-04
 *@LastModifier : ah young Han
 *@LastVersion : 1.0
 * 2008-12-04 ah young Han
 * 1.0 최초 생성
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0041 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0041() {
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

//공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;
var apflag = false;
var sflag = 'I';
var confirm_flag = false;
var isNew = true;


/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	isNew = true;
	
	//getChssPoolComboList(document.chss_pool_combo , chss_pool_cdCode , chss_pool_cdText , ''); // chassis Pool 멀티 콤보 (Chassis Pool) 설정
	initChssPoolCombo(document.chss_pool_cd);       // 공통스크립트 
	getChssPoolList();

	ComEnableObject(document.form.chss_pool_nm, false);
	ComEnableObject(document.form.paymt_sp, false);
	ComEnableObject(document.form.paymt_sp_nm, false);
	ComEnableObject(document.form.inv_bzc_amt, false);
	ComEnableObject(document.form.inv_vat_amt, false);
	ComEnableObject(document.form.inv_ttl_amt, false);
	ComEnableObject(document.form.ofc_cd, false);
	ComEnableObject(document.form.usr_id, false);

	var sheetObject = sheetObjects[0];
	sheetObject.DataInsert();	    
	sheetObject.DataInsert();
	sheetObject.DataInsert();
	sheetObject.DataInsert();
	sheetObject.DataInsert(); 

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

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;

	switch(sheetNo) {
	case 1:      //sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = GetSheetHeight(13);
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 2, 1, 7, 100);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(9, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, false, true, true, false,false)

			var HeadTitle = "Del.|STS|Sel.|Quantity|Invoice Amount|Tax Amount|Handling Period|Handling Period" ;
			var HeadTitle1 = "Del.|STS|Sel.|Quantity|Invoice Amount|Tax Amount|From Date|To Date" ;


			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			InitHeadRow(1, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHidden,       50, daCenter,  true, "del",                  false, "",                                    dfNone,   	0, true,  true  );
			InitDataProperty(0, cnt++ , dtHiddenStatus, 50, daCenter,  true, "ibflag",               false, "",                                    dfNone,   	0, false, true  );
			//InitDataProperty(0, cnt++ , dtStatus, 50, daCenter,  true, "ibflag",               false, "",                                    dfNone,   	0, false, true  );
			InitDataProperty(0, cnt++ , dtCheckBox,	    40,	daCenter,	 true, "sel",				           false,	"",			                               dfNone,		0, true,	true	);
			InitDataProperty(0, cnt++ , dtData,	        180,	daRight,	 true, "trsp_pool_chss_qty",				 false,	"",			                               dfInteger,		2, true,	true	);
			InitDataProperty(0, cnt++ , dtData,	        200,	daRight,	 true, "trsp_pool_chss_inv_amt",		 false,	"",			                               dfFloat,		2, true,	true	);
			InitDataProperty(0, cnt++ , dtData,	       180,	daRight,	 true, "trsp_pool_chss_tax_amt",			 false,	"",                             dfFloat,		2, true,	true	);
			InitDataProperty(0, cnt++ , dtData,	        185,	daCenter,	 true, "hndl_prd_fm_dt",			 false,	"",			                               dfDateYmd,	0, true,	true	);
			InitDataProperty(0, cnt++ , dtData,	        185,	daCenter,	 true, "hndl_prd_to_dt",			 false,	"",			                               dfDateYmd,	0, true,	true	);
			InitDataProperty(0, cnt++ , dtHidden,       50,	daCenter,	 true, "sub_inv_seq",				   false,	"",			                               dfNone,		0, true,	true	);


			RangeBackColor(1, 6, 1, 7) = RgbColor(222, 251, 248);   // ENIS
			HeadRowHeight = 20 ;
			HeadRowHeight = 21 ;
		}
		break;
	}
}



/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];

	/*******************************************************/
	var formObj = document.form;
	var comboObj = document.form.chss_pool_cd;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
		//'Minimize' Button Click  
		case "btn_minimize":
			Mincount = (Mincount+1)%2 ;
			Minimize(Mincount);
			break;

			//'Calendar1' Button Click  
		case "btns_calendar1":
			var cal = new ComCalendar();
			cal.select(formObj.inv_rcv_dt, 'yyyy-MM-dd');
			break;

			//'Calendar2' Button Click  
		case "btns_calendar2":
			var cal = new ComCalendar();
			cal.select(formObj.inv_iss_dt, 'yyyy-MM-dd');
			break;

			//'New' Button Click    
		case "btn_new":							
			sheetObject.RemoveAll() ;
			initSheet(sheetObject,1);

			//기본 5줄 표시
			sheetObject.DataInsert();
			sheetObject.DataInsert();
			sheetObject.DataInsert();
			sheetObject.DataInsert();
			sheetObject.DataInsert();		

			formObj.reset();

			formObj.chss_pool_cd.Code = "";
			formObj.chss_pool_cd.Text = "";	
			formObj.chss_pool_cd.Enable = true; 

			formObj.inv_no.disabled =false ; 

			//formObj.pool_chss_cost_yrmon.value = currentYearMonth;

			sflag = 'I';

			apflag = false;

			inv_flag = 0;
			isNew = true;
			confirm_flag = false;
			break;				


			//'Retrieve' Button Click
		case "btn_retrieve":        	    

			if(ComIsNull(formObj.pool_chss_cost_yrmon) || ComIsNull(formObj.pool_chss_cost_yrmon.value))
			{
				ComShowCodeMessage("COM12114","COST MONTH");
				formObj.pool_chss_cost_yrmon.focus();
				return false;
			}
			if(ComIsNull(formObj.chss_pool_nm) || ComIsNull(formObj.chss_pool_nm.value))
			{
				ComShowCodeMessage("COM12114","Pool Name");
				formObj.chss_pool_cd.focus();
				return false;
			}

			if(ComIsNull(formObj.paymt_sp_cd) || ComIsNull(formObj.paymt_sp_cd.value))
			{
				ComShowCodeMessage("COM12114","Payment Service Provider");            			
				formObj.chss_pool_cd.focus();
				return false;
			}

			if(ComIsNull(formObj.inv_no) || ComIsNull(formObj.inv_no.value))
			{
				ComShowCodeMessage("COM12114","Invoice No");
				formObj.inv_no.focus();
				return false;
			}


			doActionIBSheet(sheetObject,formObj,'RETRIVE');

			isNew = false;

			break;



			//'Row Add' Button Click  
		case "btng_rowadd":
			if(formObj.trsp_inv_aud_sts_cd.value == 'CF') confirm_flag = true;
			else confirm_flag = false;				

			if(!isNew && apflag){
				errMsg = ComGetMsg("TRS90380");
				ComShowMessage(errMsg);
				return false;				     
			}

			if (confirm_flag){
				errMsg = ComGetMsg("TRS90002" );
				ComShowMessage(errMsg);
				return false;
			}				   		

			doActionIBSheet(sheetObject,formObj,IBINSERT);	
			break;



			//'Save' Button Click  				
		case "btng_save":				

			var sheetTotal = 0.00 ;     

			if(formObj.trsp_inv_aud_sts_cd.value == 'CF') confirm_flag = true;
			else confirm_flag = false;

			if(confirm_flag){
				errMsg = ComGetMsg("TRS90059" );
				ComShowMessage(errMsg);
				return;                           			
			}

			if (checkInputSave(formObj)){               

				if(rowDelete(sheetObject)){ 
					
					setSheetTotalAmt('cell');
					
					if(ComShowConfirm(ComGetMsg("COM12147","Invoice"))){

						doActionIBSheet(sheetObject,formObj,IBSEARCH);  

						if (isNew && sflag == 'I'){   //신규 등록
							doActionIBSheet(sheetObject,formObj,IBSAVE);
							isNew = false;

						}else if (sflag=='U' && !confirm_flag && !isNew){ 
							doActionIBSheet(sheetObject,formObj,'UPDATE');

						}else if(sflag == 'U' && !apflag ){   //신규 등록
							errMsg = ComGetMsg("COM12115","Invoice No(Pool Name)");
							ComShowMessage(errMsg);
							return;       	                    	
						}
					}	
				} 
			} 
			break;


			//'Invoice Confirm' Button Click  				
		case "btng_invconfirm":				

			var sheetTotal = 0.00 ;     
			var sheetTotal2 = 0.00 ; 

			if(formObj.trsp_inv_aud_sts_cd.value == 'CF') confirm_flag = true;
			else confirm_flag = false;

			if(confirm_flag){
				errMsg = ComGetMsg("TRS90002" );
				ComShowMessage(errMsg);
				return;                           			
			}                


			if (checkInputConfirm(formObj)){ 

				if (checkInputData(sheetObject))                     
				{
					sel = sheetObject.FindCheckedRow ('sel') 
					if(sel != "")                            
					{
						arrRow = sel.split("|");             
						for (idx=0; idx<arrRow.length-1; idx++){        
							sheetTotal = Number(sheetTotal)+Number(sheetObject.CellValue(arrRow[idx] , "trsp_pool_chss_inv_amt"));
							sheetTotal =sheetTotal.toFixed(2);
							sheetTotal2 = Number(sheetTotal2)+Number(sheetObject.CellValue(arrRow[idx] , "trsp_pool_chss_tax_amt"));
							sheetTotal2 =sheetTotal2.toFixed(2);                                
						}
					}


					if(rowDelete(sheetObject)){

						setSheetTotalAmt('check'); //check한 셀에 대해서만 금액을 다시 계산
	
						doActionIBSheet(sheetObject,formObj,IBSEARCH);  


						if (isNew && sflag == 'I' && !confirm_flag){   
							doActionIBSheet(sheetObject,formObj,'INV_CONFIRM_INSERT');
							isNew = false;
						}else if (!isNew && !confirm_flag && sflag=='U'){	 	         	                    	
							doActionIBSheet(sheetObject,formObj,'INV_CONFIRM_UPDATE');
						}else if(sflag == 'U' && !apflag ){   //신규 등록
							errMsg = ComGetMsg("COM12115","Invoice No(Pool Name)");
							ComShowMessage(errMsg);
							return; 
						}
					}	

				}    
			} 
			break;        	            	        


			//'Invoice Confirm Cancel' Button Click  
		case "btng_invconfrimcancel":

			if(formObj.trsp_inv_aud_sts_cd.value == 'CF') confirm_flag = true;
			else confirm_flag = false;

			if (sflag=='U' && confirm_flag){	 	 
				doActionIBSheet(sheetObject,formObj,'INV_CONFIRM_CANCEL');
			}else{
				errMsg = ComGetMsg("TRS90041" );
				ComShowMessage(errMsg);        	    		        	    		
				return false;
			}
			break;   

			//'Invoice Delete Button Click  
		case "btng_invoicedelete":
			if(formObj.trsp_inv_aud_sts_cd.value == 'CF') confirm_flag = true;
			else confirm_flag = false;				

			if(!isNew && apflag){
				errMsg = ComGetMsg("TRS90383");
				ComShowMessage(errMsg);
				return false;				     
			}

			if(!isNew && sflag=='U'){
				if(ComShowConfirm(ComGetMsg("COM12165","Invoice No"))){
					doActionIBSheet(sheetObject,formObj,'INV_DELETE');
				}	
			}else{
				errMsg = ComGetMsg("TRS90390" );
				ComShowMessage(errMsg);        	    		        	    		
				return false;				 		   				  	
			}
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




//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {

	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
	// IBSheet Row Add
	case IBINSERT:      
		var row = sheetObj.DataInsert();
		break;

		//Payment SP 조회      
	case IBROWSEARCH:    			
		formObj.f_cmd.value = SEARCH10;

		sheetObj.RemoveEtcData();
		sheetObj.DoRowSearch("ESD_TRS_0041GS.do", TrsFrmQryString(formObj));

		ComEtcDataToForm(formObj ,sheetObj);

		var flag = sheetObj.EtcData("flag");

		sheetObj.ShowDebugMsg = false;
		break;                


		//'SAVE'버튼 클릭시 INVOICE NO 중복체크              
	case IBSEARCH:      

		formObj.f_cmd.value = SEARCH03;
		sheetObj.DoRowSearch("ESD_TRS_0041GS.do", TrsFrmQryString(formObj));
		inv_flag = sheetObj.EtcData("inv_flag");
		sheetObj.RemoveEtcData();                

		if ( parseInt(inv_flag) > 0 ) {
			apflag = false;   
			sflag = 'U';   
		}else{
			apflag = true; 
			sflag = 'I';    
		}	 

		break;

		//Inquiry 조회    
	case 'RETRIVE':
		if(ComIsNull(formObj.inv_no)){    
			return false;
		}

		formObj.f_cmd.value = SEARCH01;
		sheetObj.DoSearch4Post("ESD_TRS_0041GS.do", TrsFrmQryString(formObj));
		ComEtcDataToForm(formObj ,sheetObj);

		inv_flag = sheetObj.EtcData("inv_flag");

		if ( parseInt(inv_flag) > 0 ) {
			apflag = false;   
			sflag = 'U';   
		}else{
			apflag = true; 
			Sflag = 'I';    
			ComShowCodeMessage("TRS90390");  
		}	          

		formObj.chss_pool_cd.Enable = false; 
		formObj.inv_no.disabled =true ;   
		checkCurr(formObj.inv_curr_cd.value);

		break;

		//'SAVE'버튼 클릭시 INSERT 인경우                    
	case IBSAVE:                    
		//저장 Save
		formObj.f_cmd.value = MULTI01;  

		receive_dt = formObj.inv_rcv_dt.value.replace(/\/|\-|\./g , "");
		issue_dt = formObj.inv_iss_dt.value.replace(/\/|\-|\./g , "");
		formObj.inv_rcv_dt.value = receive_dt;                 
		formObj.inv_iss_dt.value = issue_dt;

		formObj.inv_bzc_amt.value = ComTrimAll(formObj.inv_bzc_amt.value,",");
		formObj.inv_vat_amt.value = ComTrimAll(formObj.inv_vat_amt.value,",");
		formObj.inv_ttl_amt.value = ComTrimAll(formObj.inv_ttl_amt.value,",");

		sheetObj.DoSave("ESD_TRS_0041GS.do", TrsFrmQryString(formObj), 'trsp_pool_chss_qty' , false); 

		formObj.chss_pool_cd.Enable = false; 
		formObj.inv_no.disabled =true ;                 

		break;


		//'SAVE'버튼 클릭시 UPDATE 인경우                    
	case 'UPDATE':        
		//저장 Save
		formObj.f_cmd.value = MULTI02;	

		receive_dt = formObj.inv_rcv_dt.value.replace(/\/|\-|\./g , "");
		issue_dt = formObj.inv_iss_dt.value.replace(/\/|\-|\./g , "");
		formObj.inv_rcv_dt.value = receive_dt;                 
		formObj.inv_iss_dt.value = issue_dt;

		formObj.inv_bzc_amt.value = ComTrimAll(formObj.inv_bzc_amt.value,",");
		formObj.inv_vat_amt.value = ComTrimAll(formObj.inv_vat_amt.value,",");
		formObj.inv_ttl_amt.value = ComTrimAll(formObj.inv_ttl_amt.value,",");

		sheetObj.DoSave("ESD_TRS_0041GS.do", TrsFrmQryString(formObj) , 'trsp_pool_chss_qty' , false);


		break;


		//'INVOICE CONFIRM'버튼 클릭                  
	case 'INV_CONFIRM_INSERT':     
		formObj.f_cmd.value = MULTI03;

		receive_dt = formObj.inv_rcv_dt.value.replace(/\/|\-|\./g , "");
		issue_dt = formObj.inv_iss_dt.value.replace(/\/|\-|\./g , "");
		formObj.inv_rcv_dt.value = receive_dt;                 
		formObj.inv_iss_dt.value = issue_dt;

		formObj.inv_bzc_amt.value = ComTrimAll(formObj.inv_bzc_amt.value,",");
		formObj.inv_vat_amt.value = ComTrimAll(formObj.inv_vat_amt.value,",");
		formObj.inv_ttl_amt.value = ComTrimAll(formObj.inv_ttl_amt.value,",");

		sheetObj.DoSave("ESD_TRS_0041GS.do", TrsFrmQryString(formObj) ,'sel', false);   

		formObj.chss_pool_cd.Enable = false; 
		formObj.inv_no.disabled =true ;

		formObj.trsp_inv_aud_sts_cd.value = 'CF';
		if(formObj.trsp_inv_aud_sts_cd.value == 'CF'){
			errMsg = ComGetMsg("TRS90002" );
			ComShowMessage(errMsg);
		}

		break;


		//'INVOICE CONFIRM'버튼 클릭                  
	case 'INV_CONFIRM_UPDATE':     
		formObj.f_cmd.value = MULTI04;

		receive_dt = formObj.inv_rcv_dt.value.replace(/\/|\-|\./g , "");
		issue_dt = formObj.inv_iss_dt.value.replace(/\/|\-|\./g , "");
		formObj.inv_rcv_dt.value = receive_dt;                 
		formObj.inv_iss_dt.value = issue_dt;

		formObj.inv_bzc_amt.value = ComTrimAll(formObj.inv_bzc_amt.value,",");
		formObj.inv_vat_amt.value = ComTrimAll(formObj.inv_vat_amt.value,",");
		formObj.inv_ttl_amt.value = ComTrimAll(formObj.inv_ttl_amt.value,",");  

		sheetObj.DoSave("ESD_TRS_0041GS.do", TrsFrmQryString(formObj) , 'sel' ,false);   

		formObj.trsp_inv_aud_sts_cd.value = 'CF';
		if(formObj.trsp_inv_aud_sts_cd.value == 'CF'){
			errMsg = ComGetMsg("TRS90002" );
			ComShowMessage(errMsg);
		}
		break;


		//'INVOICE CONFIRM CANCEL'버튼 클릭                       
	case 'INV_CONFIRM_CANCEL':   
		formObj.f_cmd.value = MODIFY02;
		sheetObj.DoAllSave("ESD_TRS_0041GS.do", TrsFrmQryString(formObj),false);
		formObj.trsp_inv_aud_sts_cd.value = 'SV';
		break;



		//'INVOICE DELETE'버튼 클릭                          
	case 'INV_DELETE':    
		formObj.f_cmd.value = REMOVE01;
		sheetObj.DoAllSave("ESD_TRS_0041GS.do", TrsFrmQryString(formObj),false);

		formObj.reset();
		sheetObj.RemoveAll(); 

		formObj.chss_pool_cd.Code = "";
		formObj.chss_pool_cd.Text = "";	
		formObj.chss_pool_cd.Enable = true; 

		formObj.inv_no.disabled =false ;   
		//formObj.pool_chss_cost_yrmon.value = currentYearMonth;

		sflag = 'I';
		apflag = false;
		inv_flag == 0;
		isNew = true;
		confirm_flag = false;


		break;                                					                						                



	}
}


/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}


function searchPaymentSP(combo) {

	if ( ! ComIsEmpty(document.form.editflag) ) return ;

	var formObj = document.form;
	document.chss_pool_cd.value = combo.GetText(combo.Text,1);

	if ( document.chss_pool_cd.Text != "")
	{

		doActionIBSheet(sheetObjects[0] , document.form , IBROWSEARCH);
	} else {
		document.form.paymt_sp.value = "";
		document.form.paymt_sp_cd.value = "";
		document.form.paymt_sp_nm.value = "";
	}
}


function checkInputSave(formObj)
{
	if(ComIsNull(formObj.pool_chss_cost_yrmon) || ComIsNull(formObj.pool_chss_cost_yrmon.value))
	{
		ComShowCodeMessage("COM12114","Cost Month");  
		formObj.pool_chss_cost_yrmon.focus();
		return false;
	}
	if(ComIsNull(formObj.chss_pool_nm) || ComIsNull(formObj.chss_pool_nm.value))
	{
		ComShowCodeMessage("COM12114","Pool Name");  
		formObj.chss_pool_cd.focus();
		return false;
	}

	if(ComIsNull(formObj.paymt_sp_cd) || ComIsNull(formObj.paymt_sp_cd.value))
	{
		ComShowCodeMessage("COM12114","Payment S/P");  
		formObj.chss_pool_cd.focus();
		return false;
	}

	if(ComIsNull(formObj.inv_no) || ComIsNull(formObj.inv_no.value))
	{
		ComShowCodeMessage("COM12114","Invoice No");  
		formObj.inv_no.focus();
		return false;
	}
	return true;       
}

function checkInputConfirm(formObj)
{
	if(ComIsNull(formObj.pool_chss_cost_yrmon) || ComIsNull(formObj.pool_chss_cost_yrmon.value))
	{
		ComShowCodeMessage("COM12114","Cost Month");  
		formObj.pool_chss_cost_yrmon.focus();
		return false;
	}
	if(ComIsNull(formObj.chss_pool_nm) || ComIsNull(formObj.chss_pool_nm.value))
	{
		ComShowCodeMessage("COM12114","Pool Name");  
		formObj.chss_pool_cd.focus();
		return false;
	}

	if(ComIsNull(formObj.paymt_sp_cd) || ComIsNull(formObj.paymt_sp_cd.value))
	{
		ComShowCodeMessage("COM12114","Payment S/P");  
		formObj.chss_pool_cd.focus();
		return false;
	}

	if(ComIsNull(formObj.inv_no) || ComIsNull(formObj.inv_no.value))
	{
		ComShowCodeMessage("COM12114","Invoice No");  
		formObj.inv_no.focus();
		return false;
	}

	if(ComIsNull(formObj.inv_rcv_dt) || ComIsNull(formObj.inv_rcv_dt.value))
	{
		ComShowCodeMessage("COM12114","Receive Date");  
		formObj.inv_rcv_dt.focus();
		return false;
	}

	if(ComIsNull(formObj.inv_iss_dt) || ComIsNull(formObj.inv_iss_dt.value))
	{
		ComShowCodeMessage("COM12114","Issue Date");  
		formObj.inv_iss_dt.focus();
		return false;
	}
	if(ComIsNull(formObj.inv_curr_cd) || ComIsNull(formObj.inv_curr_cd.value))
	{
		ComShowCodeMessage("COM12114","Currency");  
		formObj.inv_curr_cd.focus();
		return false;
	}
	if(ComIsNull(formObj.inv_bzc_amt) || ComIsNull(formObj.inv_bzc_amt.value))
	{
		ComShowCodeMessage("COM12114","Invoice Amount");  
		formObj.inv_bzc_amt.focus();
		return false;
	}

	if(ComIsNull(formObj.inv_vat_amt) || ComIsNull(formObj.inv_vat_amt.value))
	{
		ComShowCodeMessage("COM12114","Tax Amount");  
		formObj.inv_vat_amt.focus();
		return false;
	}

	return true;       
}

function sheet1_OnSaveEnd(sheetObj , ErrMsg)
{
	var formObj = document.form;
	if (ErrMsg != "") return;
	
	apflag = false;   
	sflag = 'U';          
	document.form.insflag.value = "false";        // 입력 상태를 수정 상태로 전환 

}



function checkInputData(sheetObj)
{


	var flag = true;
	var dtflag = true;
	var vflag = true;

	if(sheetObj.CheckedRows('sel') == "0")  {
		errMsg = ComGetMsg("TRS90215");
		ComShowMessage(errMsg);
		return false;
	} 
	var chkrows = sheetObj.FindCheckedRow("sel");

	var arrRow = chkrows.split("|");
	for (idx=0; idx<arrRow.length-1; idx++){ 
		row = arrRow[idx];

		sheetObj.RowBackColor(row) = sheetObj.RgbColor(255,255,255);
		

		if(isNaN(sheetObj.CellValue( row , "trsp_pool_chss_qty")) || parseInt(sheetObj.CellValue( row , "trsp_pool_chss_qty")) == 0)
		{
			sheetObj.CellBackColor(row, "trsp_pool_chss_qty")= sheetObj.RgbColor(255, 0, 0);
			flag = false;
		} 

		if(isNaN(sheetObj.CellValue( row , "trsp_pool_chss_inv_amt")) || sheetObj.CellValue( row , "trsp_pool_chss_inv_amt") == 0 )
		{
			sheetObj.CellBackColor(row, "trsp_pool_chss_inv_amt")= sheetObj.RgbColor(255, 0, 0);
			flag = false;
		} 

		if( sheetObj.CellValue(row , "hndl_prd_fm_dt").replace(/-/gi,"").length != 8 )
		//if (!checkDateFormat(sheetObj.CellText(row , "hndl_prd_fm_dt").replace(/-/gi,"")))
		{
			sheetObj.CellBackColor(row , "hndl_prd_fm_dt")= sheetObj.RgbColor(255, 0, 0);
			flag = false;
			dtflag = false;
		}
		if( sheetObj.CellValue(row , "hndl_prd_to_dt").replace(/-/gi,"").length != 8 )
		//if (!checkDateFormat(sheetObj.CellText(row , "hndl_prd_to_dt").replace(/-/gi,"")))
		{
			sheetObj.CellBackColor(row , "hndl_prd_to_dt")= sheetObj.RgbColor(255, 0, 0);
			flag = false;
			dtflag = false;
		}

		if (dtflag){
			if (parseInt(sheetObj.CellValue(row , "hndl_prd_fm_dt").replace(/-/gi,"")) > parseInt(sheetObj.CellValue(row , "hndl_prd_to_dt").replace(/-/gi,"")))
			{
				sheetObj.CellBackColor(row , "hndl_prd_fm_dt")= sheetObj.RgbColor(255, 0, 0);
				sheetObj.CellBackColor(row , "hndl_prd_to_dt")= sheetObj.RgbColor(255, 0, 0);
				flag = false;
			}
		}

		if (!flag){
			vflag = false;
		}

		flag = true;
		dtflag = true;
	}

	var findRow = 1;

	return vflag;

}

function rowDelete(sheetObj){
	var tCnt = 0;
	var rowCnt = sheetObj.RowCount;

	for ( var i= sheetObj.RowCount+1 ; i>1; i--){
		if(isNaN(sheetObj.CellValue( i, "trsp_pool_chss_qty")) || sheetObj.CellValue( i , "trsp_pool_chss_qty") == 0){
			tCnt = tCnt + 1;
		}
	}   

	if(tCnt == rowCnt){
		ComShowCodeMessage("TRS90036");
		return false;
	}else {
		for ( var i= sheetObj.RowCount+1 ; i>1; i--){
			if(isNaN(sheetObj.CellValue( i, "trsp_pool_chss_qty")) || sheetObj.CellValue( i , "trsp_pool_chss_qty") == 0){
				sheetObj.RowDelete(i, false);
			}          
		}

		return true;
	}				 
}



/**
 * 외부 콤보박스의 리스트 가져오기 Rail Road
 **/
function getChssPoolComboList( combo , code , text , option) {

	var chssPoolCdList = code;
	var chssPoolNmList = text;

	var chssPoolCdArray = new Array();
	var chssPoolNmArray = new Array();

	chssPoolCdArray = chssPoolCdList.split("|");
	chssPoolNmArray = chssPoolNmList.split("|");

	combo.RemoveAll();

	for(var i=0; i<chssPoolCdArray.length; i++)
	{
		combo.InsertItem(i, chssPoolCdArray[i]+'|'+chssPoolNmArray[i],  chssPoolCdArray[i]);
	}

	combo.InsertItem(0, option ,  option);
}


function initChssPoolCombo(comboObj)
{
	comboObj.DropHeight = 120; 
	comboObj.SetColAlign("left|left");
	comboObj.SetColWidth("40|230");
}




function chss_pool_cd_OnBlur (combo) {
	var finded = combo.FindIndex(combo.Text() , 0);

	if ( document.form.chss_pool_nm.value ==  combo.GetText(finded,1))  return;
	document.form.hidden_chss_pool_cd.value = combo.GetText(combo.Code,0);
	document.form.chss_pool_nm.value = combo.GetText(combo.Code , 1);
	searchPaymentSP(combo);
}



function chss_pool_cd_OnChange(combo, Index_Code, Text) {

	if ( document.form.chss_pool_nm.value == Text )  return;
	document.form.hidden_chss_pool_cd.value = combo.GetText(Index_Code,0);
	document.form.chss_pool_nm.value = combo.GetText(Index_Code,1);

	doActionIBSheet(sheetObjects[0] , document.form , IBROWSEARCH);

}




/**
 * MInimize 클릭시 이벤트 관련
 */
function Minimize(nItem)
{

	var objs = document.all.item("showMin");

	if ( nItem == "1" )
	{
		objs.style.display = "none";


		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(17);
		sheetObjects[0].focus();
		sheetObjects[0].ViewRows  =20;

	}
	else
	{
		objs.style.display = "inline";

		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(13);
		sheetObjects[0].focus();
		sheetObjects[0].ViewRows  =10;

	}

}

function checkDateFormat(dt){
	var date_regexp = "^(\\d{4}-\\d{2}-\\d{2})$";
	if (!checkFormat(dt, date_regexp)){
		return false;
	}
	return true;
}	

function BlurDate(obj){
	if (obj.value == "")
	{
		return;
	}
	if ( !ComIsDate(obj) ){
		errMsg = ComGetMsg("COM12179");
		ComShowMessage(errMsg);
		obj.focus();
		return ;
	} else {
		rsdate = addBar(obj.value);
		obj.value = rsdate;
	}
}



//날자포맷으로 yyyy-mm-dd
function addBar(dt) 
{
	var dat="";
	if( dt.length == 8 )
	{
		dat = dt.substr(0,4) + '-' + dt.substr(4,2) + '-' + dt.substr(6,2);
	}
	return dat; 
}

function fun_Focus_del(obj)
{
	date = obj.value.replace(/\/|\-|\./g , "");
	obj.value = date;
}
function checkFormat(object, regexp){
	// 주어진 값이 정규식에 일치하는지 확인하고 맞으면 true를 틀릴경우 false를 return한다.
	if (object == null || object == ""){
		return false;
	} else {
		re = new RegExp(regexp,"gi"); //'gi'는 case-insensitive global match를 위함이다
		if (!re.test(object)){
			return false;
		}
	}
	return true;
}



function isMon(obj, isChkFmt){
	//통화만 -> 숫자,.까지  + 소숫점 이하 2자리만 허용
	if (!ComIsNumber(obj,'-.,')){
		obj.value = '';
	}

	if (isChkFmt!=undefined && isChkFmt!=null && isChkFmt=='Y'){
		var src = deleteComma(obj.value);
		if (src.indexOf('.') != -1){
			if (src.length-1 > src.indexOf('.')+2){
				src = src.substring(0,src.indexOf('.')+3);
				obj.value = src;
			}
			if (src.indexOf('.') != src.lastIndexOf('.')){
				src = src.substring(0,src.lastIndexOf('.'));
				//obj.value = src;
				obj.value = chkAmtFmt(src);
			}
		}
	}
}

function chkAmtFmtObj(obj){

	if (obj==undefined || obj.value==null || ComTrim(obj.value)==''){
		return false;
	}
	obj.value = chkAmtFmt(obj.value);
}

function chkAmtFmt(src){

	if (src==undefined || src==null || ComTrim(src)==''){
		return "";
	}

	var src = deleteComma(src);

	if(document.form.inv_curr_cd.value == "KRW" || document.form.inv_curr_cd.value == "JPY" || document.form.inv_curr_cd.value == "TWD")
	{
		if (src.indexOf('.') != -1){
			src.value = "";
			ComShowCodeMessage("COM12136" , "KRW ,JPY","TWD");
			return "";
		}
	} else {
		if (src.indexOf('.') == -1){
			src = ComAddComma(src) + '.00'
		} else {
			var temp = src.split(".");
			if (temp.length == 2){
				if (temp[1]==null || ComTrim(temp[1])==''){temp[1] = '00';}
				if (temp[1].length == 1){temp[1] += '0';				
				} else if (temp[1].length == 2){
				} else if (temp[1].length > 2){temp[1] = temp[1].substring(0,2);  
				}
				src = ComAddComma(temp[0])+'.'+temp[1];
			} else if (temp.length > 2){
				// 두번째 .부터 .를 다 삭제하고 재계산하기 
				var tmp_str = '';
				for (var i=1; i<temp.length; i++){
					tmp_str += ComTrim(new String(temp[i]));
				}
				if (tmp_str==null || ComTrim(tmp_str)==''){tmp_str = '00';}
				if (tmp_str.length == 1){tmp_str += '0';				
				} else if (tmp_str.length == 2){
				} else if (tmp_str.length > 2){tmp_str = tmp_str.substring(0,2);  
				}
				src = ComAddComma(temp[0])+'.'+tmp_str;
			} else {
				return false;
			}
		}
	}
	return src;
}

function chkInput(obj) {
	if (obj.maxLength < getStrLen(obj.value)){
		obj.value = '';
		obj.focus();
		return false;
	}
}

function deleteComma(src){
	// comma를 제거
	var src = String(src);
	if (src==null || ComTrim(src)==''){
		return '';
	}
	return src.replace(/,/gi,'');
}

function addComma(src){
	// comma를 3자리마다 끼워넣기
	var src = String(src);
	if (src==null || ComTrim(src)==''){
		return '';
	}
	var re = /(-?\d+)(\d{3})/;
	while (re.test(src)) {
		src = src.replace(re, "$1,$2");
	}
	return  src;
}

function getStrLen(src) {
	// 한글 및 영문 str의 길이를 구함
	src = new String(src);
	var byteLength = 0;
	for (var inx = 0; inx < src.length; inx++) {
		var oneChar = escape(src.charAt(inx));
		if (oneChar.length == 1) {
			byteLength ++;
		} else if (oneChar.indexOf("%u") != -1) {
			byteLength += 2;
		} else if (oneChar.indexOf("%") != -1) {
			byteLength += oneChar.length/3;
		}
	}
	return byteLength;
}

function checkCurr(curr_value)
{
	if ( curr_value == "KRW" || curr_value == "JPY" || curr_value == "TWD")
	{
		sheetObjects[0].InitDataProperty(0, 4 , dtData,	 200,		daRight,			true,    "trsp_pool_chss_inv_amt",				false,			"",			dfInteger,			2,			true,			true	);
		sheetObjects[0].InitDataProperty(0, 5 , dtData,	 180,		daRight,			true,    "trsp_pool_chss_tax_amt",				false,			"",			dfInteger,			2,			true,			true	);
			
		///
		var sheetObj = sheetObjects[0];
		var formObj = document.form;

		var total_invoice_amt = 0;
		var total_tax_amt = 0;

		formObj.inv_bzc_amt.value = 0;
		formObj.inv_vat_amt.value = 0;


		
			for ( var i= sheetObj.RowCount+1 ; i>1; i--){
				total_invoice_amt += parseInt(sheetObj.CellValue(i, 'trsp_pool_chss_inv_amt'));		
				total_tax_amt += parseInt(sheetObj.CellValue(i, 'trsp_pool_chss_tax_amt'));
			}  	
		

		formObj.inv_bzc_amt.value = chkAmtPos(total_invoice_amt);
		formObj.inv_vat_amt.value = chkAmtPos(total_tax_amt);
		

		document.form.inv_bzc_amt.value = parseInt(document.form.inv_bzc_amt.value);   
		document.form.inv_vat_amt.value = parseInt(document.form.inv_vat_amt.value); 

	} else {
		sheetObjects[0].InitDataProperty(0, 4 , dtData,	 200,		daRight,			true,    "trsp_pool_chss_inv_amt",				false,			"",			dfFloat,			2,			true,			true	);
		sheetObjects[0].InitDataProperty(0, 5 , dtData,	 180,		daRight,			true,    "trsp_pool_chss_tax_amt",				false,			"",			dfFloat,			2,			true,			true	);

	}

	sumAmt();

}


String.prototype.trim = function()
{
	return this.replace(/(^\s*)|(\s*$)/g, "");
}


function getSaveString(params){
	var saveString = null;
	if(params == null){
		saveString = "";
	}else{
		saveString = params.join("&");
	}
	return saveString;
}


/**
 * 외부 콤보박스의 리스트 가져오기 Rail Road
 **/
function getChssPoolComboList( combo , code , text , option) {

	var chssPoolCdList = code;
	var chssPoolNmList = text;

	var chssPoolCdArray = new Array();
	var chssPoolNmArray = new Array();

	chssPoolCdArray = chssPoolCdList.split("|");
	chssPoolNmArray = chssPoolNmList.split("|");

	combo.RemoveAll();

	for(var i=0; i<chssPoolCdArray.length; i++)
	{
		combo.InsertItem(i, chssPoolCdArray[i]+'|'+chssPoolNmArray[i],  chssPoolCdArray[i]);
	}

	combo.InsertItem(0, option ,  option);
}


function initChssPoolCombo(comboObj)
{
	comboObj.DropHeight = 200; 
	comboObj.SetColAlign("left|left");
	comboObj.SetColWidth("60|300");
}




function chkYearMonth(obj){
	if (obj==undefined || obj.value==null || ComTrim(obj.value)==''){
		return;
	}


	obj.value = obj.value.replace('-',''); 



	if (!ComIsNumber(obj)){
		obj.value = '';
		obj.focus();
		return;
	}      
	if (obj.value.length != 6){ 
		obj.value = '';        	      
		obj.focus();
		return false;
	}	 


	if ( !ComIsDate(obj,"ym")){
		errMsg = ComGetMsg("COM12180");
		ComShowMessage(errMsg);
		obj.value = '';
		obj.focus();
		return;
	} 

}    

function isYearMonth(obj){


	obj.value = obj.value.replace('-',''); 

	if (!ComIsNumber(obj)){
		obj.value = '';
		obj.focus();
		return;
	}      


	if (obj.value.length != 6){         	      
		obj.focus();
		return;
	}	 

	if ( !ComIsDate(obj,"ym")  || !ComIsNumber(obj)){
		obj.value = '';
		obj.focus();
		return;
	} 

}    	



/**
 * sheet cell value 변경시 발생하는 이벤트
 **/
function sheet1_OnChange(sheetObj, row, col, value){
	var formObj = document.form;
	var colName = sheetObj.ColSaveName(col);
	switch(colName){
	case 'trsp_pool_chss_inv_amt':
	case 'trsp_pool_chss_tax_amt':
		setSheetTotalAmt('cell');
		break;
	}
}


function setSheetTotalAmt(flag){
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	var total_invoice_amt = 0.00;
	var total_tax_amt = 0.00;

	formObj.inv_bzc_amt.value = 0.00;
	formObj.inv_vat_amt.value = 0.00;


	//confirm 버튼 클릭시 check한 셀만 다시 계산
	if(flag == 'check'){
		var checkList = sheetObj.FindCheckedRow('sel');
		var checkArray = checkList.split('|');		

		for(var i=0; i<checkArray.length-1; i++){
			total_invoice_amt += Number(sheetObj.CellValue(checkArray[i], 'trsp_pool_chss_inv_amt'));
			total_tax_amt += Number(sheetObj.CellValue(checkArray[i], 'trsp_pool_chss_tax_amt'));
		}

		//셀 입력시 자동 계산	
	}else{
		for ( var i= sheetObj.RowCount+1 ; i>1; i--){
			total_invoice_amt += Number(sheetObj.CellValue(i, 'trsp_pool_chss_inv_amt'));		
			total_tax_amt += Number(sheetObj.CellValue(i, 'trsp_pool_chss_tax_amt'));
		}  	
	}

	formObj.inv_bzc_amt.value = chkAmtPos(total_invoice_amt);
	formObj.inv_vat_amt.value = chkAmtPos(total_tax_amt);

	checkCurr(formObj.inv_curr_cd.value);
	//sumAmt();

}



function sumAmt()
{
	var inv_amt = 0;
	var tax_amt = 0 ;
	
	if ( document.form.inv_bzc_amt.value != "")
	{
		inv_amt = deleteComma(document.form.inv_bzc_amt.value) ; 
		
	}

	if ( document.form.inv_vat_amt.value != "")
	{
		tax_amt = deleteComma(document.form.inv_vat_amt.value);
		
	}

	document.form.inv_ttl_amt.value = parseFloat(inv_amt)+parseFloat(tax_amt);

	var curr_value = document.form.inv_curr_cd.value;

    if ( !(curr_value == "KRW" || curr_value == "JPY" || curr_value == "TWD")){
    	document.form.inv_ttl_amt.value = ComAddComma(document.form.inv_ttl_amt.value);
    }
	chkAmtFmtObj(document.form.inv_ttl_amt);
}


function getChssPoolList() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	formObj.f_cmd.value = SEARCH11;
	var query = TrsFrmQryString(formObj);
	sheetObj.RemoveEtcData();
	sheetObj.DoSearch4Post("ESD_TRS_0041GS.do", query);
	var chss_pool_cd = sheetObj.EtcData('chss_pool_cd');
	var chss_pool_nm = sheetObj.EtcData('chss_pool_nm');
	var comboObj = document.chss_pool_cd;
	comboObj.RemoveAll();
	var chssPoolCdArray = chss_pool_cd.split('|');
	var chssPoolNmArray = chss_pool_nm.split('|');
	var k = 0;
	while(k < chssPoolCdArray.length-1 ){
		comboObj.InsertItem(k++, chssPoolCdArray[k]+'|'+chssPoolNmArray[k], chssPoolNmArray[k]);
	}

}



