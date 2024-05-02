/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0170.js
*@FileTitle : Container Copy And Move
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.06.11 김영출
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
     * @class esm_bkg_0170 : esm_bkg_0170 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0170() {
        this.processButtonClick = processButtonClick;
        this.setSheetObject     = setSheetObject;
        this.loadPage           = loadPage;
        this.initSheet          = initSheet;
        this.initControl        = initControl;
        this.doActionIBSheet    = doActionIBSheet;
        this.setTabObject       = setTabObject;
        this.validateForm       = validateForm;
    }

       /* 개발자 작업    */

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
	var before_edit_val = '';
	var callback_func = '';
	var prefix1 = "sheet1_";
	var prefix2 = "sheet2_";

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_Add":
					doActionIBSheet(sheetObject1,formObject,IBINSERT);
				break;

                case "btn_Del":
					doActionIBSheet(sheetObject1,formObject,IBDELETE);
				break;

				case "radio_gubun":
					//var sheetObj = sheetObjects[0];
					//if(sheetObj.RowCount > 0){
					//	if(event.srcElement.value == 'C'){
					//		sheetObj.CellEditable(1, "tgt_cntr_vol") = true; 
					//	}else{
					//		sheetObj.CellValue2(1, "tgt_cntr_vol") = 0;
					//		sheetObj.CellEditable(1, "tgt_cntr_vol") = false; 
					//	}
					//}
					//
					
					if(window.event.srcElement.value == 'M'){
						setOpenerCntr("M");
					}else{
						setOpenerCntr("C");
					}
					sheet1_OnClick(sheetObject1, sheetObject1.SelectRow, "cntr_no");
					// calculate
//					calculateVolumn();
				break;
				
                case "btn_Apply":
					//alert("isCopy ? " + formObject.radio_gubun[0].checked);
					var rvol = 0;
					var rcopy = '';
					var rflag = false;
					if(formObject.radio_gubun[0].checked){
//						rvol  = formObject.cntr_vol.value;//sheetObject1.CellValue(1, "tgt_cntr_vol");
						rcopy = 'C';
						rflag = doActionIBSheet(sheetObject1,formObject,MULTI01);
					}else{
						rcopy = 'M';
                    	rflag = doActionIBSheet(sheetObject1,formObject,MULTI02);
					}
					if(!rflag) return false;
					
					if(!opener) opener = window.dialogArguments; 
//					if(callback_func != ''){
//						eval('opener.'+callback_func)(rcopy, rvol);
//					}		
					opener.doActionIBSheet(opener.sheetObjects[1], opener.document.form, IBSEARCH);
					//window.close();
                //break;

                case "btn_Close":
					window.close();
				break;

            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
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



    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

        //add listener
		axon_event.addListenerForm('change', 'form1_change', document.form);
		setOpenerCntr("C");
		
		// initialize 
		//var bkg_no = document.form.bkg_no.value;
//		var cntr_vol = document.form.cntr_vol.value;
//		document.form.cntr_vol.value = ComAddComma3(cntr_vol, "#,###.00");
		//document.getElementById("td_org_vol").innerText = ComAddComma3(cntr_vol, "#,###.00");
		//document.getElementById("td_sum_vol").innerText = ComAddComma3(cntr_vol, "#,###.00");
		
		//
		//var newRow = sheetObjects[0].DataInsert(-1);
		//sheetObjects[0].CellValue2(newRow, "tgt_bkg_no")   = bkg_no;
		//sheetObjects[0].CellValue2(newRow, "tgt_cntr_vol") = '';//cntr_vol;
		//sheetObjects[0].CellValue2(newRow, "origin_flg")   = "Y";
		//
		//sheetObjects[0].CellEditable(newRow, "sel") = false; 
		//sheetObjects[0].CellEditable(newRow, "tgt_bkg_no") = false;
		// change status
		//sheetObjects[0].RowStatus(newRow) = 'R';
	}


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;

        switch(sheetID) {
            case "sheet1":      //sheet1 init
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
                    InitRowInfo(1, 1, 2, 100);

					var HeadTitle1 = "|Sel.|Container No.|Target Booking No.|Vol.|Org";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,        KEYFIELD,  CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                    InitDataProperty(0, cnt++,  dtHiddenStatus, 30,     daCenter,   false,     "ibflag");
//                    InitDataProperty(0, cnt++,  dtCheckBox,     30,     daCenter,   false,     "sel");
//                    InitDataProperty(0, cnt++,  dtData,         180,    daCenter,   false,     "tgt_bkg_no",    false,     "",         dfNone,     0,        true,        true);
//                    InitDataProperty(0, cnt++,  dtData,         30,     daRight,    false,     "tgt_cntr_vol",  false,     "",         dfNullFloat,    2,        true,        true);
//                    InitDataProperty(0, cnt++,  dtHidden,       20,     daRight,    false,     "origin_flg",    false,     "",         dfNone,     0,        true,        true, 1);
                    
                    InitDataProperty(0, cnt++,  dtHiddenStatus, 30,     daCenter,   false,     prefix1+"ibflag");
                    InitDataProperty(0, cnt++,  dtCheckBox,     30,     daCenter,   false,     prefix1+"sel");
                    InitDataProperty(0, cnt++,  dtData,         130,    daCenter,   false,     prefix1+"cntr_no",    false,     "",         dfNone,     0,        true,        true);
                    InitDataProperty(0, cnt++,  dtData,         130,    daCenter,   false,     prefix1+"tgt_bkg_no",    false,     "",         dfNone,     0,        true,        true);
                    InitDataProperty(0, cnt++,  dtData,         30,     daRight,    false,     prefix1+"tgt_cntr_vol",  false,     "",         dfNullFloat,    2,        true,        true);
                    InitDataProperty(0, cnt++,  dtHidden,       20,     daRight,    false,     prefix1+"origin_flg",    false,     "",         dfNone,     0,        true,        true, 1);

                    CountPosition = 0;

               }
			break;
			
			
            case "sheet2":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

					var HeadTitle1 = "|Sel.|Source cntr No.|ORG Vol.|Partial Vol.|Org";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,        KEYFIELD,  CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtHiddenStatus, 30,     daCenter,   false,     prefix2+"ibflag");
                    InitDataProperty(0, cnt++,  dtCheckBox,     30,     daCenter,   false,     prefix2+"sel");
                    InitDataProperty(0, cnt++,  dtData,         180,    daCenter,   false,     prefix2+"cntr_no",       false,     "",        dfNone,    	   0,        true,        true);
                    InitDataProperty(0, cnt++,  dtData,         70,     daRight,    false,     prefix2+"cntr_vol",      false,     "",         dfNullFloat,    2,        true,        true);
                    InitDataProperty(0, cnt++,  dtData,         70,     daRight,    false,     prefix2+"cntr_vol_qty",  	   false,     "",         dfNullFloat,    2,        true,        true);
                    InitDataProperty(0, cnt++,  dtHidden,       20,     daRight,    false,     prefix2+"origin_flg",    false,     "",     dfNone,   	   0,        true,        true, 1);

                    CountPosition = 0;

               }
			break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        var aryPrefix = new Array(prefix1, prefix2);
        switch(sAction) {
			
			case MULTI01:      // copy
			case MULTI02:      // move
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = sAction;
					//sheetObj.DoSave("ESM_BKG_0170GS.do", FormQueryString(formObj));
					var rXml = sheetObj.GetSaveXml("ESM_BKG_0170GS.do", FormQueryString(formObj) + "&" + sheetObjects[0].GetSaveString() + "&" + sheetObjects[1].GetSaveString());
					var rMsg = ComResultMessage(rXml);
					if(rMsg == ''){
						/* Transaction 상태 초기화 */
						sheetObj.LoadSaveXml("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
						
						// show message
						var cstms_download = ComGetEtcData(rXml, "USA_CSTMS_DOWNLOAD");
						if(cstms_download == 'true'){
							ComShowMessage(ComGetMsg("BKG00166") + '\n\n' + ComGetMsg("BKG00087"));
						}else{
							ComShowMessage(ComGetMsg("BKG00166"));
						}

					} else {
						//alert(rMsg.split('<||>').join('\n'));
						ComShowMessage(rMsg);
						return false;
					}		
				}else{
					return false;
				}
			break;

			case IBINSERT:      // 입력
				var newRow = sheetObj.DataInsert();
//				if(formObj.radio_gubun[1].checked){
//					sheetObj.CellValue2(newRow, prefix1+"tgt_cntr_vol") = formObj.cntr_vol.value;
//					// calculate
//					calculateVolumn();
//				}
				sheet1_OnClick(sheetObj, newRow, "cntr_no");
			break;

			case IBDELETE:      // 삭제
				//ComRowHideDelete(sheetObj, "sel");
				var s_row = ComFindText(sheetObj, prefix1+"sel", 1);
				if(formObj.radio_gubun[0].checked)
					calculateVolumn(s_row,"D");
				ComRowDeleteComplete(sheetObj, prefix1+"sel", 1);

				  
			break;
        }
		return true;
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	var sourceCntrSheet = sheetObjects[1];
        switch(sAction) {

			case MULTI01:      // copy
			case MULTI02:      // move
				/*
				 * 1. BKG No. 입력 확인 - 에러메세지 [BKG00183] 표시하고
				 * 2. Original과 Partial Total의 값이 틀린경우 메시지 [BKG08008] 표시후 Copy 취소
				 * 3. 전체 Vol에 대해서 0 보다 큰 값만 가능함 - 0 이하의 값인 경우 메시지 [BKG08013] 표시
				 * 4. 입력한 Grid 전체 BKG로 Copy한다.
				*/
				with (formObj) {
					if(ComIsEmpty(bkg_no.value)){
						ComShowMessage(ComGetMsg("BKG00183"));
						return false;
					}
//					if(ComIsEmpty(cntr_no.value)){
//						ComShowMessage(ComGetMsg("BKG00753"));
//						return false;
//					}					
//					var par_sum = ComColumnSum(sheetObj, "tgt_cntr_vol") + BkgParseFloat(cntr_vol.value);
//					//alert("Volumn : " + par_sum +" -> "+ cntr_vol.value + " = " + BkgParseFloat(cntr_vol.value));
//					//if(cntr_vol.value != par_sum){
//					//	ComShowMessage(ComGetMsg("BKG08008"));
//					//	return false;
//					//}
//					//alert("par_sum : " + par_sum);
//					if(par_sum <= 0 || par_sum > 1){
//						ComShowMessage(ComGetMsg("BKG08129", par_sum));
//						return false;
//					}
				}
				
				if(sheetObj.RowCount < 1){
					return false;
				}
				
        		for(var i=sourceCntrSheet.HeaderRows;i<sourceCntrSheet.Rows;i++){
        			var s_row = sheetObj.FindText(2, sourceCntrSheet.CellValue(i, prefix2+"cntr_no"), 0)
					if(s_row==-1){
						ComShowMessage(ComGetMsg("BKG08315"));
						return false;
					}
					if(sourceCntrSheet.CellValue(i, prefix2+"cntr_vol_qty") == "" || sourceCntrSheet.CellValue(i, prefix2+"cntr_vol_qty") < 0){
						ComShowMessage(ComGetMsg("BKG08316", "CNTR :"+ sourceCntrSheet.CellValue(i, prefix2+"cntr_no")));
						return false;
					}
        		}
        		
//				var s_row = ComFindText(sheetObj, prefix1+"sel", 1);
				
				// check SheetData
				var initRow = 1;
				//if(formObj.radio_gubun[0].checked){
				//	initRow = 1;
				//}else{
				//	initRow = 2;
				//}
				for(rn=initRow ;rn<=sheetObj.LastRow ;rn++){
					
					//container화면에서 체크되지 않은 항목을 copy/move시에 validation
					var s_row = sourceCntrSheet.FindText(2, sheetObj.CellValue(rn, prefix1+"cntr_no"), 0)
					if(s_row==-1){
						ComShowMessage(ComGetMsg("BKG08315"));
						return false;
					}
					
					if(ComIsEmpty(sheetObj.CellValue(rn, prefix1+"cntr_no"))){
						ComShowMessage(ComGetMsg("BKG03035", "Container No."));
						return false;
					}
					if(ComIsEmpty(sheetObj.CellValue(rn, prefix1+"tgt_bkg_no"))){
						ComShowMessage(ComGetMsg("BKG03035", "Target Booking No."));
						return false;
					}
					if(sheetObj.CellValue(rn, prefix1+"tgt_cntr_vol") == "" || sheetObj.CellValue(rn, prefix1+"tgt_cntr_vol") <= 0 || sheetObj.CellValue(rn, prefix1+"tgt_cntr_vol") > 1){
						ComShowMessage(ComGetMsg("BKG08013"));
						return false;
					}
				}
			break;
        }

        return true;
    }

	/* --------------------------------------------------------------------
	 * Event 처리
	 ---------------------------------------------------------------------- */
	function sheet1_OnBeforeEdit(sheetObj, row, col, val) {
		//alert("OnBeforeEdit -> " + sheetObj.ColSaveName(col) + " = " + sheetObj.cellValue(row, col));
		before_edit_val = sheetObj.CellValue(row, col);
	}

	function sheet1_OnAfterEdit(sheetObj, row, col, val) {
		//alert("OnAfterEdit -> " + sheetObj.ColSaveName(col) + " = " + sheetObj.cellValue(row, col))
	}
	
	function sheet1_OnClick(sheetObj, row, col){
		var sourceCntrSheet = sheetObjects[1];
		if(sheetObj.CellValue(row, prefix1+"cntr_no")!=""){
			var f_row = sourceCntrSheet.FindText(2, sheetObj.CellValue(row, prefix1+"cntr_no"), 0);
			document.getElementById("cntr_no").innerText = sourceCntrSheet.CellValue(f_row, prefix2+"cntr_no");
			document.getElementById("td_org_vol").innerText = ComAddComma3(''+sourceCntrSheet.CellValue(f_row, prefix2+"cntr_vol"), "#,###.00");
			document.getElementById("td_sum_vol").innerText = ComAddComma3(''+sourceCntrSheet.CellValue(f_row, prefix2+"cntr_vol_qty"), "#,###.00");
		}else{
			document.getElementById("cntr_no").innerText = "";
			document.getElementById("td_sum_vol").innerText = "";
		}
	}
	
	function sheet1_OnChange(sheetObj, row, col, val){
		var formObject = document.form;
        var sourceCntrSheet = sheetObjects[1];
		/* 대문자 */
		var data_type = sheetObj.ReadDataProperty(row, col, 0);
		if(data_type == dtData) {
			sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase();
		}
		
		var col_name = sheetObj.ColSaveName(col);
		switch(col_name) {
			case prefix1+"sel":
				//sheetObj.RowStatus(row) = (val == 1) ? 'I' : 'R';
			break;
			case prefix1+"cntr_no":
				if(sheetObj.CellValue(row, prefix1+"tgt_cntr_vol")!=""){
					if(formObject.radio_gubun[0].checked)
						calculateVolumn(row,"I");
					sheet1_OnClick(sheetObj, row, col);
				}
					
			break;
			case prefix1+"tgt_cntr_vol":
				if(val <= 0 || val > 1){
					ComShowMessage(ComGetMsg("BKG08013"));
					sheetObj.CellValue2(row, col) = before_edit_val;
					sheetObj.SelectCell(row, col);
					return false;
				}

				if(sheetObj.CellValue(row, prefix1+"cntr_no")!=""){  
					if(formObject.radio_gubun[0].checked)
						calculateVolumn(row,"I");
					sheet1_OnClick(sheetObj, row, col);
				}
			break;		
		}
	}

//    function form1_change(){
//
//        var srcName = event.srcElement.getAttribute("name");
//        switch(srcName){
//            case "cntr_vol":
//				var vol = BkgParseFloat(event.srcElement.value);
//				if(vol <0 || vol >= 1){
//					ComShowMessage(ComGetMsg("BKG08013"));
//					event.srcElement.select();
//					return false;
//				}
//				// calculate
//				calculateVolumn();
//            break;
//        }
//    }

	function calculateVolumn(arrRows,gubun){
		var sheetObj = sheetObjects[0];
		var sourceCntrSheet = sheetObjects[1];
        var formObject = document.form;
        var rows = new Array();

		if(arrRows.length == undefined){
			rows.push(''+arrRows);
		}else{
			rows=arrRows;
		}
        for(var j=0;j<rows.length;j++){
    		var f_row = sourceCntrSheet.FindText(2, sheetObj.CellValue(rows[j], prefix1+"cntr_no"), 0);
    		
    		if(gubun=="D"){
    			sourceCntrSheet.CellValue(f_row, prefix2+"cntr_vol_qty") = parseFloat(sourceCntrSheet.CellValue(f_row, prefix2+"cntr_vol_qty")) + parseFloat(sheetObj.CellValue(rows[j], prefix1+"tgt_cntr_vol"));
    			
    		}else{
        		var sum = 0.00;
        		for(var i=sheetObj.HeaderRows;i<sheetObj.Rows;i++){
        			if(sheetObj.CellValue(rows[j], prefix1+"cntr_no")==sheetObj.CellValue(i, prefix1+"cntr_no")){
        				if(sheetObj.CellValue(i, prefix1+"tgt_cntr_vol")!=""){
    	    				sum = parseFloat(sum) + parseFloat(sheetObj.CellValue(i, prefix1+"tgt_cntr_vol"))
        				}
        			}
        		}

        		//copy
    			sourceCntrSheet.CellValue(f_row, prefix2+"cntr_vol_qty") = parseFloat(sourceCntrSheet.CellValue(f_row, prefix2+"cntr_vol"))-parseFloat(sum);

    		}
        }

	}

	function setOpenerCntr(gubun){
        var cntrSheet = sheetObjects[0];
        var sourceCntrSheet = sheetObjects[1];
        var formObj = document.form;
        
        cntrSheet.RemoveAll(); 
        sourceCntrSheet.RemoveAll(); 

        var arrCntr = formObj.cntr_nos.value.split(",");
        var arrVols = formObj.cntr_vols.value.split(",");

        for(var i=0;i<arrCntr.length;i++){
        	var newRow1 = cntrSheet.DataInsert(-1);
        	var newRow2 = sourceCntrSheet.DataInsert(-1);
        	
        	cntrSheet.CellValue2(newRow1, prefix1+"cntr_no") = arrCntr[i];
        	sourceCntrSheet.CellValue2(newRow2, prefix2+"cntr_no") = arrCntr[i];
        	sourceCntrSheet.CellValue2(newRow2, prefix2+"cntr_vol") = arrVols[i];
        	if(gubun=="M"){
        		sourceCntrSheet.CellValue2(newRow2, prefix2+"cntr_vol_qty") = 0;
        	}else{
        		sourceCntrSheet.CellValue2(newRow2, prefix2+"cntr_vol_qty") = arrVols[i];
        	}
        	
        }
        sheet1_OnClick(cntrSheet, cntrSheet.SelectRow, "cntr_no");

	}
    /* 개발자 작업  끝 */
