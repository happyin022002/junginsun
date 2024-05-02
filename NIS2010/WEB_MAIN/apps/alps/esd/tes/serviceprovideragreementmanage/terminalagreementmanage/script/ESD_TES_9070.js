/*--==============================================================================
'주  시 스 템 : ESD_TES_9070.jsp
'서브  시스템 : 자바스크립트
'프로그램 ID  : ESD_TES_9070.js
'프로그램 명  : Terminal / Storage Agreement Rate List Search 및 Agreement 데이터 부모창으로 Copy 처리
'프로그램개요 : Terminal / Storage Agreement Rate List Search 및 Agreement 데이터 부모창으로 Copy 처리	
'작   성   자 : 2009-09-08
'작   성   일 : 
==================================================================================
==============================================================================--*/  


// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;

/** 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

	/** 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		/*******************************************************/
		var sheetObject = sheetObjects[0];

		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);

					break;

				case "btn_yard": 
					var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
					var classId = "COM_ENS_061";

					var param = '?classId='+classId;
        			  
					var chkStr = dispaly.substring(0,3)
                      
                   // radio PopUp  
					if(chkStr == "1,0") {
						ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 430, 'getYard', dispaly, true);
					} else {
						ComShowCodeMessage('TES10001');
						return;
					}
					break;  
        	        
				case "btn_vndr":        	    		 	   	    
					var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
					var classId = "COM_ENS_0C1";

					var param = '?classId='+classId;
        			  
					var chkStr = dispaly.substring(0,3)
                      
                       // radio PopUp  
					if(chkStr == "1,0") {
						ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 400, 'getVender', dispaly, true);
					} else {
						ComShowCodeMessage('TES10001');
						return;
					}
					break; 

				case "btng_select": 
					var opener_obj = window.dialogArguments;
					if( sheetObjects[0].SelectRow == 1 || sheetObjects[0].SelectRow == 0 ) {
						ComShowCodeMessage('TES10084');
						return false;	
					}
					
					if( sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "tml_agmt_ofc_cty_cd"	) == "" || 
						sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "tml_agmt_ver_no"		) == "" || 
						sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "yd_cd"				) == "" ||
						sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "vndr_seq"				) == "" ) { 
						ComShowCodeMessage('TES10081');
						return false;
					}
         	     		
					if( opener_obj.document.form.tml_agmt_ofc_cty_cd.value	== "" || 
						opener_obj.document.form.tml_agmt_ver_no.value		== " " ) {
						ComShowCodeMessage('TES10085');
						return false;         	     			
					}
         	     		
					opener_obj.document.form.tml_agmt_ofc_cty_cd.value	= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "tml_agmt_ofc_cty_cd");
					opener_obj.document.form.tml_agmt_ver_no.value		= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "tml_agmt_ver_no"); 
					opener_obj.document.form.copy_tml_agmt_ofc_cty_cd.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "tml_agmt_ofc_cty_cd");	             	  	                      
					opener_obj.AgreementCopy();
					window.close();
					break;

				case "btn_close":
					window.close();
					break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('TES21025');
			} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * IBSheet Object를 배열로 등록.<br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다.<br>
     * 배열은 소스 상단에 정의.<br>
     * @param{ibsheet}	sheet_obj	Sheet Object
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

	/**
	 * Sheet 기본 설정 및 초기화.<br>
	 * body 태그의 onLoad 이벤트핸들러 구현.<br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다.<br>
	 */
	function loadPage() {

		for(i=0;i<sheetObjects.length;i++){
			
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);

			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
         
		document.form.yd_cd.value = window.dialogArguments.document.form.yd_cd.value;
	}

	/**
	 * 시트 초기설정값, 헤더 정의.<br>
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호.<br>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다.<br>
	 * @param{ibsheet}		sheetObj	IBSheet Object
	 * @param{int,String}	sheetNo		Sheet No
	 */
	function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
             case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 240;
                                        
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(6, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle1 = "Agreement\nNo.|Agreement\nVersion|Yard Code|Vendor Code|Effective Date|Effective Date";
                    var HeadTitle2 = "Agreement\nNo.|Agreement\nVersion|Yard Code|Vendor Code|From|To";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    
                    //데이터속성   [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtData,      90,    daCenter,  true,    "tml_agmt_ofc_cty_cd",       false,          "",    dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,      90,    daCenter,  true,    "tml_agmt_ver_no"	,       false,          "",    dfNone,    2,     true,       true);
                    InitDataProperty(0, cnt++, dtData,      80,    daCenter,  true,    "yd_cd"				,       false,          "",    dfNone,    0,     true,       true); 
                    InitDataProperty(0, cnt++, dtData,      80,    daCenter,  true,    "vndr_seq"			,       false,          "",    dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,      80,    daCenter,  true,    "eff_fm_dt"			,       false,          "",    dfNone,    0,     true,       true);                    
                    InitDataProperty(0, cnt++, dtData,      80,    daCenter,  true,    "eff_to_dt"			,       false,          "",    dfNone,    0,     true,       true);

                    CellBackColor(1,4) = RgbColor(222, 251, 248);   // ENIS
                    CellBackColor(1,5) = RgbColor(222, 251, 248);   // ENIS
                }
                break;
        }
    }



 	/**
 	 * Sheet관련 프로세스 처리. <br>
 	 * @param {ibsheet}  	sheetObj	Sheet Object
 	 * @param {Object}  	formObj		Form Object
 	 * @param {String}  	sAction		Action Command
 	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {

			case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESD_TES_9070GS.do", tesFrmQryStr(formObj))                   
				break;
		}
	}


    /**
     * Yard 정보( Code, Name) 셋팅. <br>
     * 
     * @param{Array}	rowArray	Yard 정보 Array Object
     */
	function getYard(rowArray) {  
		var colArray = rowArray[0];
		document.all.yd_cd.value = colArray[3];
	} 
    
    
	/**
	 * Vendor 정보( Code, Name) 셋팅. <br>
	 * 
	 * @param{Array}	rowArray	Vendor 정보 Array Object
	 */
	function getVender(rowArray) {  
		var colArray = rowArray[0];
		// colArray[2].substr(2,6) 에서 수정 (예전 KR123456 과 같은 정보를 VNDROR만 가져오기 위한것이 아닌가 추측.(2010-03-15)
		document.all.vndr_seq.value = colArray[2];
	}
    
	/**
	 * Yard Code  Validate Check. <br>
	 **/
	function validateYardCode() {			
		var formObj = document.form;	
		if (formObj.yd_cd.value==null || formObj.yd_cd.value.trim() == '')	
		{				
			formObj.yd_cd_hidden.value = '';
			formObj.is_valid_yd_cd.value = '';
			return false;
		}
		
		if ((formObj.yd_cd_hidden.value==null || formObj.yd_cd_hidden.value.trim()=='') || formObj.yd_cd.value.trim()!=formObj.yd_cd_hidden.value.trim())
		{
			formObj.yd_cd_hidden.value = '';
			formObj.is_valid_yd_cd.value = '';
			tes_getInputValue('is_valid_yd_cd', SEARCH05, 'yd_cd', 'checkValidYardCode');
		}			
	}
		
	/**
	 * Yard Code  Validate Check. <br>
	 **/
	function checkValidYardCode(){	
		var formObj = document.form;
		var tmp = '';
		if (formObj.is_valid_yd_cd.value!=undefined && formObj.is_valid_yd_cd.value!=null && formObj.is_valid_yd_cd.value.trim()!=''){
			tmp = formObj.is_valid_yd_cd.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_yd_cd.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_yd_cd.value!=null && formObj.is_valid_yd_cd.value == 'Y'){					
					formObj.yd_cd_hidden.value = formObj.yd_cd.value; 					
				} else {
					formObj.yd_cd.value = '';
					formObj.is_valid_yd_cd.value = '';
					formObj.yd_cd_hidden.value = '';					
					ComShowCodeMessage('TES10066');
				}
			} else {
				formObj.yd_cd.value = '';
				formObj.is_valid_yd_cd.value = '';
				formObj.yd_cd_hidden.value = '';				
				ComShowCodeMessage('TES10066');
			}
		} else { 
			formObj.yd_cd.value = '';
			formObj.is_valid_yd_cd.value = '';
			formObj.yd_cd_hidden.value = '';			
			ComShowCodeMessage('TES10066');
		}	
	}
	
	
	/**
     * Vendor Code  Validate. <br>
     **/
	function validateVendorCode() {			
		var formObj = document.form;	
		if (formObj.vndr_seq.value==null || formObj.vndr_seq.value.trim() == '')	
		{				
			formObj.vndr_seq_hidden.value = '';
			formObj.is_valid_vndr_seq.value = '';
			return false;
		}
			
		if ((formObj.vndr_seq_hidden.value==null || formObj.vndr_seq_hidden.value.trim()=='') || formObj.vndr_seq.value.trim()!=formObj.vndr_seq_hidden.value.trim())
		{
			formObj.vndr_seq_hidden.value = '';
			formObj.is_valid_vndr_seq.value = '';
		}			
	}
		
	/**
     * Vendor Code  Validate Check. <br>
     **/
	function checkValidVendorCode(){		
		var formObj = document.form;
		var tmp = '';
		if (formObj.is_valid_vndr_seq.value!=undefined && formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value.trim()!=''){
			tmp = formObj.is_valid_vndr_seq.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_vndr_seq.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value == 'Y'){					
					formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;					
				} else {
					formObj.vndr_seq.value = '';
					formObj.is_valid_vndr_seq.value = '';
					formObj.vndr_seq_hidden.value = '';					
					ComShowCodeMessage('TES10067');
				}
			} else {
				formObj.vndr_seq.value = '';
				formObj.is_valid_vndr_seq.value = '';
				formObj.vndr_seq_hidden.value = '';
				
				ComShowCodeMessage('TES10067');
			}
		} else {
			formObj.vndr_seq.value = '';
			formObj.is_valid_vndr_seq.value = '';
			formObj.vndr_seq_hidden.value = '';			
			ComShowCodeMessage('TES10067');
		}	
	}     

	/**
	 * Input Value Check. <br>
     * @param {Object}	obj    Text Object
	 **/
	function chkInput(obj) {
		if (obj.maxLength < getStrLen(obj.value))
		{
			obj.value = '';//substring(obj.value,0,obj.maxLength);
			obj.focus();
			return false;
		}
	}	
	
	/**
     * 숫자만.. <br>
     * @param {Object}	obj    Text Object
     **/
	function isNum(obj){
		//숫자만..
		if (!ComIsNumber(obj)){
			obj.value = '';
		}
	}
		
	/**
     * 숫자만.. <br>
     * @param {Object}	obj    Text Object
     **/
	function isNum1(obj){
		//숫자만..
		if (!ComIsNumber(obj,'-')){
			obj.value = '';
		}
	}		
	
	/**
     * 영문(대문자)과 숫자만.. <br>
     * @param {Object}	obj    Text Object
     **/
	function isApNum(obj){
		//영문과 숫자만..			
		if (!ComIsAlphabet(obj,'u')){
			obj.value = '';
		}
	}
		
	/**
     * 영문과 숫자만.. <br>
     * @param {Object}	obj    Text Object
     **/
	function isApNum1(obj){
		//영문과 숫자만..			
		if (!ComIsAlphabet(obj,'n')){
			obj.value = '';
		}
	} 
		
	/**
     * 영문과 숫자만.. <br>
     * @param {Object}	obj    Text Object
     **/
	function isApNum2(obj){
		//영문과 숫자만..
		if (!ComIsAlphabet(obj,'n')){
			obj.value = '';
		}	
		obj.value = obj.value.toUpperCase();		
	} 				 
		
	/**
     * 한글 및 영문 str의 길이를 구함.. <br>
     * @param {String}	src    Text String
     **/
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