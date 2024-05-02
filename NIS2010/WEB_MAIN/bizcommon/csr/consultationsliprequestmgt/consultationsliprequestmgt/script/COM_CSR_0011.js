/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COM_CSR_0011.js
*@FileTitle : Invoice List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.07.20 함대성
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class COM_CSR_0011 : COM_CSR_0011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function COM_CSR_0011() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

	// 공통전역변수
    //var sXml = '';
	var sheetObjects = new Array();
	var sheetCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
		 var sheetObject1 = sheetObjects[1];

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
    			showErrMessage(getMsg('CSR23028')); //showErrMessage("지금은 사용하실 수가 없습니다 ");
    		}
    	}
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
     function setSheetObject(sheet_obj) {
     	sheetObjects[sheetCnt++] = sheet_obj;
     }
     
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
      	for (i = 0; i < sheetObjects.length; i++) {

     		//khlee-시작 환경 설정 함수 이름 변경
     		ComConfigSheet(sheetObjects[i]);

     		initSheet(sheetObjects[i], i + 1);
     		//khlee-마지막 환경 설정 함수 추가
     		ComEndConfigSheet(sheetObjects[i]);
     	}

		var formObj = document.form;
		//csr_isNumD(formObj.due_dt,"Y"); 
		//formObj.csr_amt.value = csr_chkAmtFmt(formObj.csr_amt.value);

    	var sheetObject = sheetObjects[0];
        var sheetObject1 = sheetObjects[1]; 
		
		if(!isNull2(csr_no)){
			doActionIBSheet1(sheetObject1,formObj,IBSEARCH);	//searchCSRSOhdr 조회 sheet2
			doActionIBSheet(sheetObject,formObj,IBSEARCH);		//searchCSRSOlist 조회 sheet1
        } else {
			showErrMessage(getMsg('CSR40015','CSR No.')); //showErrMessage('CSR No.가 누락되었습니다.');
		}
		
		disableObject(formObj.csr_no);		
		disableObject(formObj.vndr_no);
		disableObject(formObj.inv_desc);
		
		disableObject(formObj.no_of_inv[0]);
		disableObject(formObj.csr_curr_cd[0]);
		disableObject(formObj.csr_amt[0]);
		disableObject(formObj.attr_ctnt2[0]);
		disableObject(formObj.ofc_cd[0]);

		disableObject(formObj.no_of_inv[1]);
		disableObject(formObj.csr_curr_cd[1]);
		disableObject(formObj.csr_amt[1]);
		disableObject(formObj.attr_ctnt2[1]);
		disableObject(formObj.ofc_cd[1]);
		
		disableObject(formObj.iss_dt);
		disableObject(formObj.rcv_dt);
		disableObject(formObj.vndr_term_nm);
		disableObject(formObj.due_dt);

    }


   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        var pnt = 0;
        var currCd = document.form.curr_cd.value;
        if(currCd == "KRW" || currCd == "JPY" ){
        	pnt = 0;
        }else{
        	pnt = 2;
        }
        
        switch(sheetNo) {
            case 1: 
                with (sheetObj) {
                    style.height=GetSheetHeight(11);
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1,11, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(11, 0, 0, true);

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Seq.|Invoice No.|Net Amount|Tax Amount|W.H.T.|Total Amount|Issue Date|Receive Date|Confirm Date|GL Date" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,       20,     daCenter , false,   "ibflag",     false,          "");
					InitDataProperty(0, cnt++ , dtDataSeq,       30,   daCenter,     false,    "",               false,          "",         dfNone,         0,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,       80,   daLeft,     false,    "inv_no",               false,          "",         dfNone,         0,          false,          false   );
                    
 					if(pnt == 0){	//KRW, TWD, JPY
 	                    InitDataProperty(0, cnt++ , dtData,       80,   daRight,      false,    "ttl_inv_amt",           false,          "",         dfInteger,          0,          false,          false   );
						InitDataProperty(0, cnt++ , dtData,       80,   daRight,      false,    "vat_amt",               false,          "",         dfInteger,          0,          false,          false   );
						InitDataProperty(0, cnt++ , dtData,       80,   daRight,      false,    "whld_tax_amt",          false,          "",         dfInteger,          0,          false,          false   );
						InitDataProperty(0, cnt++ , dtData,       85,   daRight,      false,    "total_amt",             false,          "",         dfInteger,          0,          false,          false   );
 					}else{	//USD
 	                    InitDataProperty(0, cnt++ , dtData,       80,   daRight,      false,    "ttl_inv_amt",           false,          "",         dfFloat,          2,          false,          false   );
						InitDataProperty(0, cnt++ , dtData,       80,   daRight,      false,    "vat_amt",               false,          "",         dfFloat,          2,          false,          false   );
						InitDataProperty(0, cnt++ , dtData,       80,   daRight,      false,    "whld_tax_amt",          false,          "",         dfFloat,          2,          false,          false   );
						InitDataProperty(0, cnt++ , dtData,       85,   daRight,      false,    "total_amt",             false,          "",         dfFloat,          2,          false,          false   );
 					}
                    
                    
					InitDataProperty(0, cnt++ , dtData,       75,   daCenter,     false,    "iss_dt",               false,          "",         dfNone,         0,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,       80,   daCenter,     false,    "rcv_dt",               false,          "",         dfNone,         0,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,       80,   daCenter,     false,    "inv_cfm_dt",               false,          "",         dfNone,         0,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,       80,   daCenter,     false,    "gl_dt",               false,          "",         dfNone,         0,          false,          false   );
					//InitDataProperty(0, cnt++ , dtHidden,       100,   daCenter,     false,    "so_ofc_cty_cd",               false,          "",         dfNone,         0,          false,          false   );
					//InitDataProperty(0, cnt++ , dtHidden,       100,   daCenter,     false,    "so_seq",               false,          "",         dfNone,         0,          false,          false   );

                }
                break;

             case 2: 
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
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(21, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

					var HeadTitle1 = "|CSR No.|Payment S/P|Payment S/P|I/F\nStatus|I/F Status\nUpdated Time|Error Reason|No of\n Invoice|Currency|Total\nAmount|Payment\nDue Date|ASA No." ;


					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,       20,     daCenter , false,   "ibflag",     false,          "");
					InitDataProperty(0, cnt++ , dtData,	150, daCenter,			false,    "csr_no",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	80, daCenter,			false,    "vndr_no",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData, 150, daLeft,			false,    "inv_desc",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	40, daCenter,			false,    "no_of_inv",				false,			"",			dfNone,			0,			false,			false	);					

					InitDataProperty(0, cnt++ , dtData,	60, daCenter,			false,    "csr_curr_cd",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	80, daRight,			false,    "csr_amt",				false,			"",			dfFloat,			2,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	100, daLeft,		    false,    "due_dt",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	100, daLeft,			false,    "attr_ctnt2",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	50, daLeft,			false,    "iss_dt",				false,			"",			dfNone,			0,			false,			false	);
					
					InitDataProperty(0, cnt++ , dtData,	100, daLeft,		    false,    "so_if_cd",				false,			"",			dfNone,			0,			false,			false	);
					
					InitDataProperty(0, cnt++ , dtHidden,	50, daLeft,			false,    "rcv_dt",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	50, daLeft,			false,    "vndr_term_nm",				false,			"",			dfNone,			0,			false,			false	);
			   }
                break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
           case IBSEARCH:      //조회
           if (!validateForm(sheetObj,formObj,sAction)){
		        return false;
		    }
			formObj.f_cmd.value = SEARCHLIST;
			sheetObj.DoSearch4Post("COM_CSR_0011GS.do", FormQueryString(formObj)); 
		    break; 
        }
    }

    function doActionIBSheet1(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
           case IBSEARCH:      //조회
                if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }
    			formObj.f_cmd.value = SEARCHLIST01;
    			sheetObj.DoSearch4Post("COM_CSR_0011GS.do", FormQueryString(formObj)); 
    			//sXml = sheetObj.GetSearchXml("COM_CSR_0011GS.do" , FormQueryString(form)); 
			    break;
        }
    }

	function sheet2_OnSearchEnd(sheet2, ErrMsg){
		if (sheet2.RowCount > 0){	
			document.form.vndr_no.value      = csr_lpad(sheet2.CellValue(1,'vndr_no'),6,"0") ;
			document.form.inv_desc.value     = sheet2.CellValue(1,'inv_desc');	//ComGetEtcData(sXml,"inv_desc"); //
			
			document.form.no_of_inv[0].value    = sheet2.CellValue(1,'no_of_inv');
			document.form.csr_curr_cd[0].value  = sheet2.CellValue(1,'csr_curr_cd');
			//document.form.csr_amt[0].value = ComAddComma(sheet2.CellValue(1,'csr_amt'));
			document.form.attr_ctnt2[0].value   = sheet2.CellValue(1,'attr_ctnt2');
			
			document.form.no_of_inv[1].value    = sheet2.CellValue(1,'no_of_inv');
			document.form.csr_curr_cd[1].value  = sheet2.CellValue(1,'csr_curr_cd');
			//document.form.csr_amt[1].value = ComAddComma(sheet2.CellValue(1,'csr_amt'));
			document.form.attr_ctnt2[1].value   = sheet2.CellValue(1,'attr_ctnt2');
			
			document.form.iss_dt.value       = sheet2.CellValue(1,'iss_dt');
			document.form.rcv_dt.value       = sheet2.CellValue(1,'rcv_dt');
			document.form.vndr_term_nm.value = sheet2.CellValue(1,'vndr_term_nm');
			document.form.due_dt.value       = sheet2.CellValue(1,'due_dt');
			document.form.so_if_cd.value     = sheet2.CellValue(1,'so_if_cd');
			//csr_isNumD(document.form.due_dt,"Y"); 
	        var pre_curr_cd = document.form.csr_curr_cd[0].value;
	        
			if(pre_curr_cd=="KRW" || pre_curr_cd=="JPY" || pre_curr_cd=="TWD"){
				document.form.csr_amt[0].value  = ComAddComma(sheet2.CellValue(1,'csr_amt'));
				document.form.csr_amt[1].value  = ComAddComma(sheet2.CellValue(1,'csr_amt'));
			}else{
				document.form.csr_amt[0].value = csr_chkAmtFmt(sheet2.CellValue(1,'csr_amt'));
				document.form.csr_amt[1].value = csr_chkAmtFmt(sheet2.CellValue(1,'csr_amt'));
			}
			
			var so_if_cd = document.form.so_if_cd.value;
	    	if(so_if_cd=="O"){	//ASA
	    		  document.all.item("srLayer")[0].style.display = "inline";
	    		  document.all.item("srLayer")[1].style.display = "none";  
	    	}else{
	    		  document.all.item("srLayer")[0].style.display = "none";
	    		  document.all.item("srLayer")[1].style.display = "inline";  
	    	}
		}
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }

        return true;
    }

	/* 개발자 작업  끝 */