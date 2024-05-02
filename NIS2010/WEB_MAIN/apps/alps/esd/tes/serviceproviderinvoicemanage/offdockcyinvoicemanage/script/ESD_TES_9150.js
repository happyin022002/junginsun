	/**
	 * @fileoverview Off-Dock CY Container - Cost Calc.(SP by FP) 에서 File Upload 화면에서 사용하는 업무 스크립트를 정의한다.
	 * @author SM LINE
	 */
	
	/**
	 * @extends Tes
	 * @class ESD_TES_9150 : Off-Dock CY Container List - Cost Calc.(SP by FP) 에서 File Upload 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_TES_9150() {
		this.processButtonClick = processButtonClick;
		this.setSheetObject = setSheetObject;
		this.setComboObject = setComboObject;
		this.setTabObject = setTabObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.initTab = initTab;
		this.doActionIBSheet = doActionIBSheet;
		this.validateForm = validateForm;
	}
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var verify_done = false;
	var isMonthly = false;
	var opr_fm_prd_dt;
	var opr_to_prd_dt; 
	var opener_obj = window.dialogArguments;
	var insCnt = 0;

	/**
	 * Monthly 또는 Daily 선택 시 보여줄 sheet 선택 함수  
	 * @return
	 */
	function setMonthlyOrDaily(){

		var formObj = document.form;

		if (formObj.mode[1].checked == true){ //Monthly
			isMonthly = true;
			document.all.monthly.style.display = 'inline';
			document.all.daily.style.display = 'none';
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
		} else { //Daily + ELSE
			isMonthly = false;
			document.all.monthly.style.display = 'none';
			document.all.daily.style.display = 'inline';
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
		}
	}


	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 * @return
	 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         /*******************************************************/
         var sheetObject  = sheetObjects[0];  //daily
		 var sheetObject1 = sheetObjects[1];  //monthly

         var formObj = document.form;

    	 try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
         	    case "btn_loadexcel":
					if (!chkOprShtData()){
						return false;
					}
					if (!isMonthly)	
					{ //Daily
						sheetObject.RemoveAll();
						verify_done = false;
						doActionIBSheet(sheetObject,formObj,IBLOADEXCEL);
					} else {
						sheetObject1.RemoveAll();
						verify_done = false;
						doActionIBSheet(sheetObject1,formObj,IBLOADEXCEL);
					}
        	        break;

         	    case "btn_verify":
					if (!chkOprShtData()){
						return false;
					}
					if (!isMonthly)	
					{ //Daily
						if (sheetObject.RowCount > 0)
						{
							if (formObj.vndr_seq.value==undefined || formObj.vndr_seq.value==null || formObj.vndr_seq.value.trim()=='' || 
								formObj.yd_cd.value==undefined || formObj.yd_cd.value==null || formObj.yd_cd.value.trim()=='') 
							{
								ComShowMessage(ComGetMsg('TES23050','VNDR Code/YD_CD')); //ComShowMessage('VNDR Code/YD_CD에 오류가 발생하여 더 이상 진행할 수 없습니다. ');
								return false;
							}
							if (formObj.fm_prd_dt.value==undefined || formObj.fm_prd_dt.value==null || formObj.fm_prd_dt.value.trim()=='' ||
								formObj.to_prd_dt.value==undefined || formObj.to_prd_dt.value==null || formObj.to_prd_dt.value.trim()=='')
							{
								ComShowMessage(ComGetMsg('TES24016')); //ComShowMessage('Period 시작일과 종료일을 입력하십시오.');
							}
							if (!verify_done)
							{
								if (rmvInvRow(sheetObject)){
									doActionIBSheet(sheetObject,formObj,IBSEARCH);
								} 
							} else {
								ComShowMessage(ComGetMsg('TES23052')); //ComShowMessage('verify 완료 상태');
							}
						} else {
							ComShowMessage(ComGetMsg('TES23057')); //ComShowMessage('data를 upload하십시오.'); 
							return false;
						}
					} else {
						if (sheetObject1.RowCount > 0)
						{
							if (formObj.vndr_seq.value==undefined || formObj.vndr_seq.value==null || formObj.vndr_seq.value.trim()=='' || 
								formObj.yd_cd.value==undefined || formObj.yd_cd.value==null || formObj.yd_cd.value.trim()=='') 
							{
								ComShowMessage(ComGetMsg('TES23050','VNDR Code/YD_CD')); //ComShowMessage('VNDR Code/YD_CD에 오류가 발생하여 더 이상 진행할 수 없습니다. ');
								return false;
							}
							if (formObj.fm_prd_dt.value==undefined || formObj.fm_prd_dt.value==null || formObj.fm_prd_dt.value.trim()=='' ||
								formObj.to_prd_dt.value==undefined || formObj.to_prd_dt.value==null || formObj.to_prd_dt.value.trim()=='')
							{
								ComShowMessage(ComGetMsg('TES24016')); //ComShowMessage('Period 시작일과 종료일을 입력하십시오.');
							}
							if (!verify_done)
							{
								if (rmvInvRow(sheetObject1)){
									doActionIBSheet(sheetObject1,formObj,IBSEARCH);
								} 
							} else {
								ComShowMessage(ComGetMsg('TES23052')); //ComShowMessage('verify 완료 상태');
							}
						} else {
							ComShowMessage(ComGetMsg('TES23057')); //ComShowMessage('data를 upload하십시오.'); 
							return false;
						}
					}
        	        break;

         	    case "btn_close":
    	            window.close();
        	        break;
 
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
				verify_done = false;
    			ComShowMessage(ComGetMsg('TES23028')); //ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * @param {ibsheet} sheet_obj 	IBSheet Object
	 * @return
	 */   
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
    * Sheet 기본 설정 및 초기화
    * body 태그의 onLoad 이벤트핸들러 구현
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    * @return
    */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
		}
		chkOprShtData();
	}

    /**
    * 특정 작업을 하기 전에 sheet 에 데이터가 있을경우 삭제가 필요할때 사용하는 함수.
    * @return
    */
	function chkOprShtData(){
		opr_fm_prd_dt = opener_obj.document.form.fm_prd_dt.value;
		opr_to_prd_dt = opener_obj.document.form.to_prd_dt.value; 
		opr_fm_prd_dt = opr_fm_prd_dt.replace(/\/|\-|\./g,"");
		opr_to_prd_dt = opr_to_prd_dt.replace(/\/|\-|\./g,"");

		if (hasOprShtData()){
			//if (!confirm('Cost Calc.(SR by FP) Tab의 모든 Data를 삭제할까요?')){
			if (!confirm(ComGetMsg('TES40012'))){
				window.close();
			} else {
				//window.dialogArguments.removeOffdockCYInvoice02();
				opener_obj.removeOffdockCYInvoice02();
				window.focus();
			}
			return false;
		}
		return true;
	}

	/**
	 * Coincidence, Discrepancy, CalcTMNL, CalcByDay sheet의 data가 존재하는지 확인하는 함수
	 * @return
	 */		
	function hasOprShtData(){
		var opener_sheet_obj;
		/* CALC.ByPool sheet의 data를 존재여부 확인... */
		opener_sheet_obj = opener_obj.document.t5sheet1;
		if (opener_sheet_obj!=null && opener_sheet_obj.RowCount > 0){
			return true;
		}
		return false;
	}


	/**
	 * 시트 초기설정값, 헤더 정의
	 * @param {ibsheet}sheetObj 	IBSheet Object
	 * @param {int} 	sheetNo 	시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 							시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * @return
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
                    InitRowInfo(1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(7, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

                    var HeadTitle = "|Seq. No.|Date|Volume";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus,     30,    daCenter,  true,    "ibflag");
                    InitDataProperty(0, cnt++, dtSeq,        80,    daCenter,  true,    "",        false,          "",       dfNone,    0,     false,       false,         5);
                    InitDataProperty(0, cnt++, dtData,       150,   daCenter,  true,    "wrk_dt",        false,          "",    dfDateYmd,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "inv_vol_qty",        false,          "",    dfFloat,    2,     false,       false);
					InitDataProperty(0, cnt++, dtHidden,       20,    daCenter,  true,    "valid_chk",        false,          "",    dfNone,    0,     false,       false);

					InitDataProperty(0, cnt++, dtHidden,       10,    daCenter,  true,    "dup_chk_conf",        false,          "",    dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtHidden,       5,    daCenter,  true,    "curr_chk",        false,          "",    dfNone,    0,     false,       false);

					CountFormat = "[SELECTDATAROW / ROWCOUNT]";
			   }
                break;

             case 2:      //sheet1 init
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
                    InitRowInfo(1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(7, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

                    var HeadTitle = "|Seq. No.|Date|Volume";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus,     30,    daCenter,  true,    "ibflag");
                    InitDataProperty(0, cnt++, dtSeq,        80,    daCenter,  true,    "",        false,          "",       dfNone,    0,     false,       false,         5);
                    InitDataProperty(0, cnt++, dtData,       150,   daCenter,  true,    "wrk_dt",        false,          "",    dfDateYm,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "inv_vol_qty",        false,          "",    dfFloat,    2,     false,       false);
					InitDataProperty(0, cnt++, dtHidden,       20,    daCenter,  true,    "valid_chk",        false,          "",    dfNone,    0,     false,       false);
					
					InitDataProperty(0, cnt++, dtHidden,       10,    daCenter,  true,    "dup_chk_conf",        false,          "",    dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtHidden,       5,    daCenter,  true,    "curr_chk",        false,          "",    dfNone,    0,     false,       false);
	
					CountFormat = "[SELECTDATAROW / ROWCOUNT]";
			   }
                break;
        }
    }


    /**
     * Sheet 관련 프로세스 처리
     * @param {ibsheet} sheetObj 	IBSheet Object
     * @param {form} 	formObj		Form Object
     * @param {int}		sAction		실행할 액션 구분 값
     * @return
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회
                if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }
			    formObj.f_cmd.value = SEARCHLIST;
				var param = sheetObj.GetSaveString(false,false);
				
				var sXml = sheetObj.GetSearchXml("ESD_TES_9150Popup.do", param+'&'+tesFrmQryStr(formObj),"",true);
				sheetObj.LoadSearchXml(sXml, true); 
				break;

           case IBLOADEXCEL:      //엑셀 올리기
                sheetObj.LoadExcel(-1);
                break;
        }
    }

     /**
      * daily 또는 monthly 선택시 호출되는 함수
      * @param {ibsheet}sheetObj 	IBSheet Object
      * @param {string}	colnm		column name
      * @param {string}	toFormat	data format
      * @return
      */
	function setColDataFormat(sheet, colnm, toFormat) {
		setMonthlyOrDaily();
		if (sheet.RowCount > 0)
		{
			val_chk(sheet);
		}
	}

	/**
	 * daily sheet 클릭 시 발생하는 이벤트
	 * @param {ibsheet}	sheetObj 	IBSheet Object
	 * @param {int}		Row			선택된 Row index
	 * @param {int}		Col			선택된 Column Index
	 * @param {String}	Value		변경된 값
	 * @return
	 */
	function sheet_OnClick(sheet,Row,Col,Value){
		//val_chk(sheet);
		return true;
	}

	/**
	 * monthly sheet 클릭 시 발생하는 이벤트
	 * @param {ibsheet}	sheetObj 	IBSheet Object
	 * @param {int}		Row			선택된 Row index
	 * @param {int}		Col			선택된 Column Index
	 * @param {String}	Value		변경된 값
	 * @return
	 */	 
	function sheet1_OnClick(sheet1,Row,Col,Value){
		//val_chk(sheet1);
		return true;
	}

	/**
	 * verify 정상 완료 유무 체크 함수 
	 * @param {ibsheet}	sheetObj 	IBSheet Object
	 * @return
	 */
	function currChkOnly(sheetObj){
		for (var i=sheetObj.HeaderRows; sheetObj.RowCount>0 && i<(sheetObj.HeaderRows + sheetObj.RowCount); i++){
			if (sheetObj.CellValue(i,'curr_chk')=='N'){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * [Daily] 조회가 완료되고 실행되는 이벤트
	 * @param {ibsheet}	sheet		IBSheet Object
	 * @param {string}	ErrMsg		error message
	 * @return
	 */	
	function sheet_OnSearchEnd(sheet, ErrMsg){
		//Daily
		if (sheet.RowCount > 0){

			verify_done = true;

			opener_obj.retrievePoolDtlList();
			insCnt = sheet.EtcData("insCnt");
			sheet.RemoveEtcData();
			//insCnt = opener_obj.document.t5sheet1.RowCount;
			insCnt = (insCnt!=undefined&&insCnt!=null&insCnt!=''?insCnt:0);

			window.focus();
			/*
			if (!currChkOnly(sheet)){
				ComShowMessage(ComGetMsg('TES23058',insCnt)); //ComShowMessage(insCnt + '건의 List가 verify완료되었습니다.');
			} else {
				ComShowMessage('입력하신 Currency Code는 Agreement의 currency 와 일치하지 않아Calculation Data를 삭제합니다. 확인 후 다시 계산해주십시오.');
				opener_obj.removeAutoCalcData2();
			}
			*/
			ComShowMessage(ComGetMsg('TES23058',insCnt)); //ComShowMessage(insCnt + '건의 List가 verify완료되었습니다.');
			window.close();
		}
	}

	/**
	 * [Monthly] 조회가 완료되고 실행되는 이벤트
	 * @param {ibsheet}	sheet1		IBSheet Object
	 * @param {string}	ErrMsg		error message
	 * @return
	 */		
	function sheet1_OnSearchEnd(sheet1, ErrMsg){
		//Monthly
		if (sheet1.RowCount > 0){
			verify_done = true;
			opener_obj.retrievePoolDtlList();
			insCnt = sheet1.EtcData("insCnt");
			sheet1.RemoveEtcData();
			//insCnt = opener_obj.document.t5sheet1.RowCount;
			insCnt = (insCnt!=undefined&&insCnt!=null&insCnt!=''?insCnt:0);

			window.focus();
			/*
			if (!currChkOnly(sheet1)){
				ComShowMessage(ComGetMsg('TES23058',insCnt)); //ComShowMessage(insCnt + '건의 List가 verify완료되었습니다.');
			} else {
				ComShowMessage('입력하신 Currency Code는 Agreement의 currency 와 일치하지 않아Calculation Data를 삭제합니다. 확인 후 다시 계산해주십시오.');
				opener_obj.removeAutoCalcData2();
			}
			*/
			ComShowMessage(ComGetMsg('TES23058',insCnt)); //ComShowMessage(insCnt + '건의 List가 verify완료되었습니다.');
			window.close();
		}
	}

	/**
	 * [Daily] 엑셀 로드 후 실행되는 이벤트
	 * @param {ibsheet}	sheet		IBSheet Object
	 * @return
	 */
	function sheet_OnLoadExcel(sheet){
		val_chk(sheet);
		chkDupRow(sheet);
		rmvInvRow(sheet);
	}

	/**
	 * [Monthly] 엑셀 로드 후 실행되는 이벤트
	 * @param {ibsheet}	sheet1		IBSheet Object
	 * @return
	 */	
	function sheet1_OnLoadExcel(sheet1){
		val_chk(sheet1);
		chkDupRow(sheet1);
		rmvInvRow(sheet1);
	}

	/**
	 * 중복검사
	 * @param {ibsheet}	sheet	IBSheet Object
	 * @return
	 */	
	function chkDupRow(sheet){
		var idx = 0;
		var Rows;
		Rows = sheet.ColValueDupRows("wrk_dt|dup_chk_conf");
		var arr_rows = Rows.split(',');
		for (var i=0; arr_rows!=null && i<arr_rows.length; i++){
			sheet.RowFontColor(arr_rows[i]) = sheet.RgbColor(255, 0, 0);
			sheet.CellValue2(arr_rows[i],"dup_chk_conf") = ++idx;
		}
	}

	/**
	 * 엑셀 로드한 데이터의 유효성 체크 함수
	 * @param {ibsheet}	sheet	IBSheet Object
	 * @return
	 */	
	function rmvInvRow(sheet){
		var inval_row = false;
		if (sheet.RowCount > 0)
		{
			var delRows = '';
			var cnt = 0;
			for (var i=1; i<=sheet.RowCount; i++)
			{
				if ( (sheet.CellValue(i,'valid_chk')!=undefined && sheet.CellValue(i,'valid_chk').trim()=='X') ||
					 (sheet.CellValue(i,'dup_chk_conf')!=undefined && sheet.CellValue(i,'dup_chk_conf')!=null && sheet.CellValue(i,'dup_chk_conf').trim()!='') )
				{
					delRows = delRows + (cnt>0?"|":"") + (new String(i));
					inval_row = true; cnt++;
				}
			}
			if (inval_row)
			{
				/*
				if (confirm('유효하지 않는 row가 발견되었습니다. 지우겠습니까?'))
				{
					delInvalRow(sheet, delRows);
					return true;
				} else {
					return false;
				}
				*/
				ComShowMessage(ComGetMsg('TES23055',cnt)); //ComShowMessage(cnt + '개의 잘못된 data가 발견되었습니다. file에서 수정하고 다시 올려주십시오.');
			} else {
				return true;
			}
		}
	}

	 /**
	  * 선택 row 삭제 함수
	  * @param {ibsheet}sheet	IBSheet Object
	  * @param {int}	delRows	선택된 row index
	  * @return
	  */	
	function delInvalRow(sheet, delRows){
		if (sheet.RowCount > 0)
		{
			var arr = delRows.split('|');
			for (var i=(arr.length-1); arr!=null && i>=0; i--)
			{
				sheet.RowDelete(arr[i], false);
			}
			return true;
		}
	}

	/**
	 * 데이터 유효성 체크 함수
	 * @param {ibsheet}sheet	IBSheet Object
	 * @return
	 */	
	function val_chk(sheet) {
		if (sheet.RowCount > 0) {
			if (document.form.mode[1].checked == true) { //M
				for (var i=1; i<=sheet.RowCount; i++) {
					if (!isValidYYYYMM(sheet.CellValue(i,'wrk_dt'))){
						sheet.CellValue2(i,'valid_chk') = 'X';
						//sheet.CellBackColor(i,'wrk_dt') = sheet.RgbColor(255, 0, 0);
						sheet.RowFontColor(i) = sheet.RgbColor(255, 0, 0);
					} else {
						if (!isBetweenPeriodMonthly(sheet.CellValue(i,'wrk_dt'))){
							sheet.CellValue2(i,'valid_chk') = 'X';
							//sheet.CellBackColor(i,'wrk_dt') = sheet.RgbColor(255, 0, 255);
							sheet.RowFontColor(i) = sheet.RgbColor(255, 0, 0);
						} else {
							sheet.CellValue2(i,'valid_chk') = '';
							//sheet.CellBackColor(i,'wrk_dt') = sheet.RgbColor(0, 0, 0);
						}
					}
				}
			} else {
				for (var i=1; i<=sheet.RowCount; i++) {
					if (!isValidYYYYMMDD(sheet.CellValue(i,'wrk_dt'))){
						sheet.CellValue2(i,'valid_chk') = 'X';
						//sheet.CellBackColor(i,'wrk_dt') = sheet.RgbColor(255, 0, 0);
						sheet.RowFontColor(i) = sheet.RgbColor(255, 0, 0);
					} else {
						if (!isBetweenPeriodDaily(sheet.CellValue(i,'wrk_dt'))){
							sheet.CellValue2(i,'valid_chk') = 'X';
							//sheet.CellBackColor(i,'wrk_dt') = sheet.RgbColor(255, 0, 255);
							sheet.RowFontColor(i) = sheet.RgbColor(255, 0, 0);
						} else {
							sheet.CellValue2(i,'valid_chk') = '';
							//sheet.CellBackColor(i,'wrk_dt') = sheet.RgbColor(0, 0, 0);
						}
					}
				}
			}
		}
	}

	/**
	 * [Monthly] 시작과 종료일의 유효성 체크 함수
	 * @param {string}	src	wrk_dt
	 * @return
	 */
	function isBetweenPeriodMonthly(src){
		if (src!=undefined && src!=null && src!='' && 
			opr_fm_prd_dt!=undefined && opr_fm_prd_dt!=null && opr_fm_prd_dt!='' && 
			opr_to_prd_dt!=undefined && opr_to_prd_dt!=null && opr_to_prd_dt!='' && 
			!(src >= opr_fm_prd_dt.substring(0,6) && src <= opr_to_prd_dt.substring(0,6) )) {
			return false;					
		} 
		return true;
	}

	/**
	 * [Daily] 시작과 종료일의 유효성 체크 함수
	 * @param {string}	src	wrk_dt
	 * @return
	 */	
	function isBetweenPeriodDaily(src){
		if (src!=undefined && src!=null && src!='' && 
			opr_fm_prd_dt!=undefined && opr_fm_prd_dt!=null && opr_fm_prd_dt!='' && 
			opr_to_prd_dt!=undefined && opr_to_prd_dt!=null && opr_to_prd_dt!='' && 
			!(src >= opr_fm_prd_dt && src <= opr_to_prd_dt)) {
			return false;					
		} 
		return true;
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 함수
	 * @param {ibsheet}	sheetObj	IBSheet Object
	 * @param {form}	formObj		화면 폼
	 * @param {int}		sAction		실행할 액션 구분 값
	 * @return
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

	/**
	 * 날짜형식 체크
	 * @param {string}	src		날짜
	 * @return
	 */
  function checkDateFormat(src){
		var date_regexp = /(^\d{4}-\d{2}-\d{2}$)/;
		if (src.search(date_regexp) != -1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 년월 유효성 체크 함수
	 * @param {String}	str		YYYYMM
	 * @return
	 */		
    function isValidYYYYMM(src) {
		var str = new String(src);
        var str = src.replace(/\/|\-|\./g,"");
		
		if (!ComIsNumber(src)) { return false; }
		
		if (str.length != 6) { return false; }

        var year  = str.substring(0,4);
        var month = str.substring(4,6);

        if ( ComParseInt( year ) >= 1900  && isMonth( month ))
            return true;
        else {
            return false;
        }
    }

	/**
	 * 년월일 유효성 체크 함수
	 * @param {String}	str		YYYYMMDD
	 * @return
	 */		
    function isValidYYYYMMDD (src) {
		var str = new String(src);
        var str = src.replace(/\/|\-|\./g,"");
		
		if (!ComIsNumber(src)) { return false; }
		
		if (str.length != 8) { return false; }

        var year  = str.substring(0,4);
        var month = str.substring(4,6);
        var day   = str.substring(6,8);

		if (ComParseInt( year ) >= 1900  && isMonth( month ) && isDay(year, month, day) )
            return true;
        else {
            return false;
        }
    }

	/**
	 * 월 유효성 체크 함수
	 * @param {String}	month	MM
	 * @return
	 */    
    function isMonth(month) {
        if (month.length > 2) return false;
        month = parseInt(month,10);
        if ((month <= 0) || (month > 12)) return false;
        return true;
    }

    /**
    * 날짜 유효성 체크 함수
    * @param {String}	year	YYYY
    * @param {String}	month	MM
    * @param {String}	day		DD
    * @return
    */    
    function isDay(year, month, day) {
        if (day.length > 2) return false;
        year  = parseInt(year, 10);
        month = parseInt(month, 10);
        day   = parseInt(day, 10);
        if ((day <= 0) || (day > ComGetLastDay(year, month))) return false;
        return true;
    }

	/**
	 * 일 유효성 체크 함수
	 * @param {String}	day	DD
	 * @return
	 */    
    function isDay2(day) {
        if (day.length > 2) return false;
        day = parseInt(day, 10);
        if ((day <= 0) || (day > 31)) return false;
        return true;
    }


