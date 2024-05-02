// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;
var asaDetailFlg = "";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");


			switch(srcName) {

				case "btn_retrieve":  	     		
						doActionIBSheet(sheetObject,formObject,IBSEARCH);
						break;

				case "btn_new":
						sheetObject.RemoveAll();
						sheetObject1.RemoveAll();
						formObject.reset();
						break;
							 
				case "btn_vndr":   	    		  
						var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
						var classId = "COM_ENS_0C1";

						var param = '?classId='+classId;
					  
						var chkStr = dispaly.substring(0,3)
						
						 // radio PopUp  
						 if(chkStr == "1,0") {
							 ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 620, 450, 'getVender', dispaly);
						} else {
							 ComShowMessage(ComGetMsg('TES10004'));
							 return;
						}
						break;          	         

				case "btng_detail":
						/* 2008-11-17 : 부산의 요청에 의해 자동 조회 기능 추가를 위해 조회기능의 function화 */
						pre_ret_cond_val = getPreviousRetreiveCondition();  
						retrieve_detail();
						break;

				case "btns_calendar1":
						var cal = new ComCalendar();
						cal.select(formObject.inv_cfm_dt, 'yyyy-MM-dd');
						break;


            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('TES21025'));
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    
    /**
     * 화면 상단의 retrieve button click시 detail 조회 시
     * Invoice전체 Data를 조회한다.
     */
	function retrieve_detail(){
		/* 2008-11-17 : 부산의 요청에 의해 자동 조회 기능 추가 */

		if(sheetObjects[0].SelectRow ==0){
			ComShowMessage(ComGetMsg('TES25017'))
			return false;	
		}
		if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 0) == "" || sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 1) =="" || sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 2) =="" || sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 3) ==""){ 
			ComShowMessage(ComGetMsg('TES25017'))
			return false;
		}
		
		var inv_cfm_dt 			= document.form.inv_cfm_dt.value; 
		var vndr_seq  			= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 2);
		var vndr_seq_name 		= encodeURI(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 3)); 
		var cnt_inv 			= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 4);
		var curr_cd 			= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 5);
		var total_amt 			= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 6);
		var iss_dt 				= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 7);
		var rcv_dt 				= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 8);
		var gen_pay_term_cd		= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 9);
		var gen_pay_term_desc	= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 10);  
		var payment_due_dt		= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 11);
		var pay_term_tp_cd		= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 12);
		var ASANOGB 			= getElementValue(document.form, 'radio', 'asanogb');
		var pay_group_cd 		= getElementValue(document.form, 'radio', 'pay_group_cd');
		var cost_ofc_cd	 		= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 1);  //혼돈되서 변수명 재정의

		var detailUrl = "ESD_TES_0024.do?pgmNo=ESD_TES_0024&inv_cfm_dt="+inv_cfm_dt+
						"&vndr_seq="+vndr_seq+
						"&vndr_seq_name="+vndr_seq_name+ 
						"&cnt_inv="+cnt_inv+ 
						"&curr_cd="+curr_cd+
						"&total_amt="+total_amt+
						"&iss_dt="+iss_dt+ 
						"&rcv_dt="+rcv_dt+ 
						"&gen_pay_term_cd="+gen_pay_term_cd+
						"&gen_pay_term_desc="+gen_pay_term_desc+  
						"&payment_due_dt="+payment_due_dt+
						"&pay_term_tp_cd="+pay_term_tp_cd+
						//"&asanogb="+ASANOGB; 
						"&cost_ofc_cd="+cost_ofc_cd+
						"&asanogb="+ASANOGB+ 
						"&pay_group_cd="+(pay_group_cd!=undefined&&pay_group_cd!=null?pay_group_cd:'')+
						((pre_ret_cond_val!=null&pre_ret_cond_val.trim()!=''?'&':'')+pre_ret_cond_val)+
						"&sysCommUiTitle=CSR Creation(Detail)&sysCommUiNavigation=TML S/O > Invoice > CSR Creation(Detail)";	

		location.href = detailUrl;
	}

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param {ibsheet}	sheet_obj   sheet object
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;

    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
         
		document.form.f_cmd.value = SEARCH01; 
		document.form.sel_ofc_cd.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 1);                  

		/**
 		 * 	2013-03-05 CSR Creation 화면에서 이동해 왔을 경우 Main 버튼을 통해 다시 CSR Creation 화면으로 돌아갔을때 이전 조회 조건들로 자동 조회하기 위함
 		 */
 		 try {
 			 pre_ret_cond_val = '';
 			 var retrieve_tf = false;
 			 var formObj = document.form;
 			 for (var i = 0; i < formObj.elements.length; i++){
 				 if (formObj.elements[i].name != null && formObj.elements[i].name.trim() != '' && 
 				     formObj.elements[i].name.substring(0,9) == 'pre_cond_')
 				 {
 					 with (formObj) {
 						 if (eval((elements[i].name)).value != null && eval((elements[i].name)).value != '') {
 							 eval(elements[i].name.substring('pre_cond_'.length,elements[i].name.length)).value = eval(elements[i].name).value;
						 
 							 if (!retrieve_tf) {retrieve_tf = true;}
 						 }
 					 }
 				 }
 			 } 			 
 			//if (retrieve_tf) {retrieve();}
 		 } catch(e){}
 		 
		/**
		 * 2008-11-17 : 
		 * LOGIN OFFICE CODE로 MDM에서 SO_IF_CD(AR_OFC_CD)를 조회해서 대리점 여부를 파악한다.
		 * 부산지역 보완 사항으로 자동 조회 기능을 심다가 결국 SHEET를 분리한다. 
		 * SHEET를 분리하지 않을 경우 동일한 ONSEARCHEND EVENT를 사용하게 됨으로써 무한 처리 됨에 따라서...
		 */
      	sheetObjects[1].DoSearch4Post("ESD_TES_0023GS.do", tesFrmQryStr(document.form));      	
    }
 	
   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param {ibsheet} sheetObj 	==> 시트오브젝트, 
     * @param {int} 	sheetNo 	==> 시트오브젝트 태그의 아이디에 붙인 일련번호
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
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(13, 1, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "SEQ|Cost Office|S/P Code|S/P Name|No of Invoice|Invoice Currency|Total Amount" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL, DATATYPE,WIDTH, DATAALIGN, COLMERGE, 		SAVENAME,  						KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtSeq,	 		30,		daCenter,			false,    "",										false,			"",			dfNone,			0,			false,			false	); 
					InitDataProperty(0, cnt++ , dtData,	 		80,		daCenter,			false,    "cost_ofc_cd",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 		80,		daCenter,			false,    "vndr_no",						false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 		300,	daLeft,				false,    "vndr_seq_name",			false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 		80,		daCenter,			false,    "cnt_inv",						false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 		130,	daCenter,			false,    "curr_cd",						false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 		80,		daRight,			false,    "total_amt",					false,			"",			dfFloat,		2,			false,			false	); 
					InitDataProperty(0, cnt++ , dtHidden,	 	1,		daCenter,			false,    "iss_dt",							false,			"",			dfNone,			0,			false,			false	); 
					InitDataProperty(0, cnt++ , dtHidden,	 	1,		daCenter,			false,    "rcv_dt",							false,			"",			dfNone,			0,			false,			false	); 
					InitDataProperty(0, cnt++ , dtHidden,	 	1,		daCenter,			false,    "gen_pay_term_cd",		false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	 	1,		daCenter,			false,    "gen_pay_term_desc",	false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	 	1,		daCenter,			false,    "payment_due_dt",			false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	 	1,		daCenter,			false,    "pay_term_tp_cd",			false,			"",			dfNone,			0,			false,			false	);


               }
                break;

            case 2:      //sheet1 init
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
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(1, 1, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL, DATATYPE,WIDTH, DATAALIGN, COLMERGE, 		SAVENAME,  						KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,	 		80,		daCenter,			false,    "inv_ofc_cd",				false,			"",			dfNone,			0,			false,			false	);


               }
                break;
		
		}
    }


    /**
     * Sheet관련 프로세스 처리
     * 
     * @param	{ibsheet} 	sheetObj	sheet object
     * @param 	{form}		formObj		form object
     * @param 	{String}	sAction		Action value
     * @return
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
			case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCHLIST01;                  
				sheetObj.DoSearch4Post("ESD_TES_0023GS.do", tesFrmQryStr(formObj));
				break;
		}
    }



    /**
     * MInimize 클릭시 이벤트 관련
     * @param {Strig}	nItem			
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
    
    /** 
     * sheet1 doble click 시 타는 메소드
     * 
     * @param sheetObj
     * @param row
     * @param col
     * @return
     */ 
	function sheet1_OnDblClick (sheetObj, row, col){
		/* 2008-11-17 : 부산의 요청에 의해 자동 조회 기능 추가 */
		retrieve_detail(sheetObj);
	}
	
	/**
	 * sheet1 검색후 타는 이벤트
	 * @param {ibsheet}	sheetObj	IBsheet object
	 * @param {String}	errMsg		err message
	 * @return
	 */
	function sheet1_OnSearchEnd(sheetObj,errMsg){
        if(errMsg!=null){
            ComShowMessage(errMsg);
        }
        
        if (sheetObj.RowCount > 0) {
    		/**
    		 * 조회 조건으로 조회가 성공적으로 된 경우만 pre_cond 조건에 넣는다.
    		 */
    		pre_ret_cond_val = getPreviousRetreiveCondition();   
    	}
    }

	/**
	 * sheet2 검색후 타는 이벤트
	 * @param {ibsheet}	sheetObj	IBsheet object
	 * @param {String}	errMsg		err message
	 * @return
	 */
    function sheet2_OnSearchEnd(sheetObj,errMsg){
        if(errMsg!=null){
            ComShowMessage(errMsg);
        }

        asaDetailFlg  = "";
        
		/**********************************************************************************************************************************************
		# 2008-03-24 이전 :
		SO_IF_CD가 'O'이면 외국지역은 ASA MODE만 허용 - 예외) 한국이라도 OFC_CD가 'SZPBB'이거나 'XMNBB'인 경우만 두 MODE다 허용한다.
		SO_IF_CD -> (예) B:지점(branch) O:상계 정산 대리점(operational) S:분리 정산 대리점(separate) 

		# 2008-03-28 이후 :
		남중국('SZPBB','XMNBB','CANBS')는 더 이상 ASA로 넘길 수 없으며 PAY_GROUP을 선택하여 넘기게 한다.

		# 2009-01-01 이후 : 
		XMNBB 조직변경으로 인해 XMNBB는 더 이상 PAY_GROUP을 선택하지 않고 일반적인 다른 OFFICE와 동일하게 처리한다.
		
		2015-08-03 그룹사 조직 코드 변경 SZPBB->SZPSC,CANBS->CANSO
		
		# 2015-12-04 VVOBA(블라디보스톡)인 경우 To A/P로 처리되기 위해서  'O'(상계정산대리점)가 아닌 B(지점)으로 처리 
		CHM-201539164 블라디보스토크(VVOBA)의 경우 To ASA가 아닌 To AP로 선택되도록 조치
		
		# 2017-04-07 
		Invoice Office 혹은 Cost Office가 아래의 특정 Office에 해당되는 경우에는 CSR I/F type을 (시스템이 자동으로 ‘To ASA’ 지정 후) User가 ‘To AP’로 변경 가능
		Office : DLCSC, NBOSC, TAOSC, XMNSC, FOCSO
		
		# 2018-06-12 TAOSC 제외(MDM에도 B로 수정 완료) 
        **********************************************************************************************************************************************/
		var so_if_cd = sheetObj.EtcData("so_if_cd");
		var inv_ofc_cd = document.form.inv_ofc_cd.value;
		
		inv_ofc_cd = inv_ofc_cd!=undefined&&inv_ofc_cd!=null?inv_ofc_cd:'';
		// CHM-201539164 블라디보스토크(VVOBA)의 경우 To ASA가 아닌 To AP로 선택되도록 조치 - (20151204 조아영D)
		if ( 'VVOBA' == inv_ofc_cd) {
			so_if_cd	= 'B';
		}
		
		if (inv_ofc_cd=='SZPSC' || inv_ofc_cd=='CANSO'){
			document.form.asanogb[0].disabled = false;
			document.form.asanogb[0].checked = true;
			document.form.asanogb[1].disabled = true;
			document.form.pay_group_cd[0].checked = true;
			document.form.pay_group_cd[0].disabled = false;
			document.form.pay_group_cd[1].disabled = false;
		} else {
			if (so_if_cd=="O"){
				document.form.asanogb[0].disabled = true;
				document.form.asanogb[1].checked = true;
				document.form.asanogb[1].disabled = false;
			}
		}
		
		if(inv_ofc_cd=='DLCSC' || inv_ofc_cd=='NBOSC' || inv_ofc_cd=='XMNSC' || inv_ofc_cd=='FOCSO'){
			document.form.asanogb[0].disabled = false;			
			document.form.asanogb[1].disabled = false;
			document.form.asanogb[1].checked = true;
		}

		/* 2008-11-17 : 부산의 요청에 의해 자동 조회 기능 추가 */
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
    
    /**
     * 숫자체크
     * @param {Object}	obj		object	
     * @return	
     */
	function isNum(obj){
		//숫자만..
		if (!ComIsNumber(obj)){
			obj.value = '';
		}
	}
	
	/**
	 * - 삭제
	 * @param {Object}	obj		object	
	 * @return
	 */
	function isNum1(obj){
		//숫자만..
		if (!ComIsNumber(obj,"-")){
			obj.value = '';
		}
	}		
	
	/**
	 * 날짜 체크
	 * 
	 * @param {Object}	obj		object	
	 * @return
	 */
	function isDate1(obj){
		//숫자만..
		if (!ComIsDate(obj)){
			obj.value = '';

			//ComShowMessage("잘못된 날짜 입력입니다. 다시 입력하세요.");
		}
	}				    
	
	/**
	 *  Grid에서 Vender Pop으로 값을 가져오는 함수
	 *  @param(rowArray) 로우배열
	 */
    function getVender(rowArray) {  
    	var colArray = rowArray[0];
    	document.all.vndr_seq.value = colArray[2];
    	document.all.vndr_seq_name.value = colArray[4];
    }		
    
    /**
     * form에서 element유형/element명과 일치하는 갯수 파악
     * 
     * @param {form} 	formObject		form object
     * @param {String}	eleTp			element type
     * @param {String}	eleNm			element name
     * @return
     */
	function getElementCnt(formObject, eleTp, eleNm) {
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
	
	/**
	 * form에서 element유형/element명과 일치하는 value 
	 * 
     * @param {form} 	formObject		form object
     * @param {String}	eleTp			element type
     * @param {String}	eleNm			element name
	 * @return
	 */
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
	
	/**
	 *  입력된 vndr_seq값을 Validation하는 함수
	 */
	function validateVendorCode() {			
		var formObj = document.form;	
		if (formObj.vndr_seq.value==null || formObj.vndr_seq.value.trim() == '')	
		{				
			formObj.vndr_seq_hidden.value = '';
			formObj.is_valid_vndr_seq.value = '';
			formObj.vndr_seq_name.value = '';
			return false;
		}
		
		if ((formObj.vndr_seq_hidden.value==null || formObj.vndr_seq_hidden.value.trim()=='') || formObj.vndr_seq.value.trim()!=formObj.vndr_seq_hidden.value.trim())
		{
			formObj.vndr_seq_hidden.value = '';
			formObj.is_valid_vndr_seq.value = '';
			tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq', 'checkValidVendorCode');
		}			
	}
	
	/**
	 *	vendor code 값 검사 
	 */
	function checkValidVendorCode(){		
		var formObj = document.form;		
		var tmp = '';
		if (formObj.is_valid_vndr_seq.value!=undefined && formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value.trim()!=''){
			tmp = formObj.is_valid_vndr_seq.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_vndr_seq.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value == 'Y'){
					formObj.vndr_seq_name.value = (tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');
					formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;					
				} else {
					formObj.is_valid_vndr_seq.value = '';
					formObj.vndr_seq_hidden.value = '';
				
					//formObj.vndr_seq.value = '';
					formObj.vndr_seq_name.value = '';					
					ComShowMessage(ComGetMsg('TES10067'));
				}
			} else {
				formObj.is_valid_vndr_seq.value = '';
				formObj.vndr_seq_hidden.value = '';				
				//formObj.vndr_seq.value = '';
				formObj.vndr_seq_name.value = '';
				ComShowMessage(ComGetMsg('TES10067'));
			}
		} else {
			formObj.is_valid_vndr_seq.value = '';
			formObj.vndr_seq_hidden.value = '';			
			//formObj.vndr_seq.value = '';
			formObj.vndr_seq_name.value = '';
			ComShowMessage(ComGetMsg('TES10067'));
		}	
	} 	 		
	
	/**
	 * cnt code 검사
	 * 
	 * @param cnt_cd
	 * @return
	 */
	function checkCntCd(cnt_cd){
		if(cnt_cd==""){
			ComShowMessage(ComGetMsg('TES25018')); 
			return false;	
		}
	}
	
	/**
	 * enter key 체크  
	 */
	function enter(){
		if (event.keyCode==13){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
	}		
	 
    /**
     * 2013-03-05 CSR Creation 화면에서 이동해 왔을 경우 Main 버튼을 통해 다시 CSR Creation 화면으로 돌아갔을때 이전 조회 조건들로 자동 조회하기 위함
     * @return 
     */
    function getPreviousRetreiveCondition(){
    	var retval = '';
    
    	if (document.form.inv_ofc_cd!=undefined && document.form.inv_ofc_cd.value!=null && document.form.inv_ofc_cd.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_inv_ofc_cd="+document.form.inv_ofc_cd.value;
    	}
    	if (document.form.inv_cfm_dt!=undefined && document.form.inv_cfm_dt.value!=null && document.form.inv_cfm_dt.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_inv_cfm_dt="+document.form.inv_cfm_dt.value;
    	}
    	if (document.form.vndr_seq!=undefined && document.form.vndr_seq.value!=null && document.form.vndr_seq.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_vndr_seq="+document.form.vndr_seq.value;
    	}    	
    	if (document.form.vndr_seq_name!=undefined && document.form.vndr_seq_name.value!=null && document.form.vndr_seq_name.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_vndr_seq_name="+document.form.vndr_seq_name.value;
    	}
    	return retval;
    }	 
