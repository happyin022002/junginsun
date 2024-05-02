/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1050.js
*@FileTitle : Container Vol. Adjustment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.09.04 김영출
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
     * @class ESM_BKG_1050 : ESM_BKG_1050 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1050() {
    	this.processButtonClick		= processButtonClick;
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
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var callback_func = '';
	var before_edit_val = '';
	
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

				case "btn_Ok":
					var rflag = doActionIBSheet(sheetObject1, formObject, IBSAVE);
					if(rflag) window.close();
                break;																				

				case "btn_close":
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
			//initSheet
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
        }
		
		// init data
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		
		// add listener
		
    }


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
					InitRowInfo( 2, 1, 3, 100);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(8, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)
					
					var HeadTitle1 = "|Cntr No.|Booking No.|Vol.|Container Vol.|Container Vol.|S/O|Special CGO";
					var HeadTitle2 = "|Cntr No.|Booking No.|Vol.|Current|Adjusted|S/O|Special CGO";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,      WIDTH, DATAALIGN, COLMERGE, SAVENAME,      KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 20,    daCenter,  true,  "ibflag");
                    InitDataProperty(0, cnt++, dtHidden,       60,    daCenter,  true,  "cntr_no",       false,    "",         dfNone,     0,          false,     false);
                    InitDataProperty(0, cnt++, dtData,         100,   daCenter,  true,  "bkg_no",        false,    "",         dfNone,     0,          false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,    daRight,   true,  "bkg_vol",       false,    "",         dfFloat,    2,          false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,    daRight,   true,  "cntr_vol_qty",  false,    "",         dfFloat,    2,          false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,    daRight,   true,  "adj_vol_qty",   false,    "",         dfFloat,    2,          true,      true);

                    InitDataProperty(0, cnt++, dtData,         60,    daCenter,  true,  "spcl_flg",      false,    "",         dfNone,     0,          false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,    daCenter,  true,  "so_flg",        false,    "",         dfNone,     0,          false,     false);

				}
			break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
                    //sheetObj.DoSearch("ESM_BKG_1051GS.do", FormQueryString(formObj));
                    var rXml = sheetObj.GetSearchXml("ESM_BKG_1050GS.do", FormQueryString(formObj));
					//alert(rXml);
					if(rXml == '' || rXml.length < 7) return false;
					if(rXml.substring(1, 6) == "ERROR"){
						//alert(ComResultMessage(rXml).split('<||>').join('\n'));
						ComShowMessage(ComResultMessage(rXml));
						return false;
					}
					sheetObj.LoadSearchXml(rXml, false);
					
					/* update on 2010.02.23 */
					for(ir=sheetObj.HeaderRows ;ir<=sheetObj.LastRow ;ir++){
						if(formObj.bkg_no.value == sheetObj.CellValue(ir, "bkg_no")){
							//sheetObj.CellValue2(ir, "adj_vol_qty") = formObj.cntr_vol.value;
							sheetObj.SelectCell(ir, "adj_vol_qty", true, formObj.cntr_vol.value);
							break;
						}
					}
				}else{
					return false;
				}
			break;
			
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)) {
					var cntr_no = formObj.cntr_no.value;
					var returnArr = new Array();
					for(ir=sheetObj.HeaderRows ;ir<=sheetObj.LastRow ;ir++){
						var rowArr = new Array();
						for(ic=0 ;ic<=sheetObj.LastCol ;ic++){
							rowArr.push(sheetObj.CellValue(ir, ic));
						}
						returnArr.push(rowArr);
					}
					//alert("check.4\n\n" + returnArr);
					
					if(!opener) opener = window.dialogArguments; 
					if(callback_func != ''){
						eval('opener.'+callback_func)(cntr_no, returnArr);
					}
				}else{
					return false;
				}
			break;
			
		}
		return true;
    }




    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		
		switch(sAction) {
			
			case IBSEARCH:      //조회

			break;
			
			case IBSAVE:        //저장
				/*
				 * 1. Adjusted의 Total이 1이 되는지 확인 한다. - 1이 아닌 경우 메시지 [BKG08009] 표시 후 리턴(팝업창유지)
				 * 2. Source BKG 이외에 Vol.이 0이 있는 경우 메시지 [BKG08012] 표시 후 Yes를 선택하면 아래 진행 No를 선택하면 리턴(팝업창 유지)
				 * 3. 부모창 (UI_BKG-0079-04) 의 Container Vol. Grid에 현재 Container의 Data를 지우고 booking 별 Adjust 및 partial flag 값을 화면의 값으로 변경한다.
				 */
				var ttl = ComColumnSum(sheetObj, "adj_vol_qty");
				/* 부동 소수점 문제 해결
				 * 2013.07.09
				 */
				ttl = Math.round(parseFloat(ttl) * 1000)/1000;
				//alert("total : " + ttl);
				if(ttl != 1){
					ComShowMessage(ComGetMsg("BKG08009"));
					return false;
				}
				//
				for(ir=sheetObj.HeaderRows ;ir<=sheetObj.RowCount ;ir++){
					//alert(ir + " > " + sheetObj.CellValue(ir, "adj_vol_qty") + " ["+ sheetObj.CellValue(ir, "bkg_no")+"]");
					if(sheetObj.CellValue(ir, "adj_vol_qty") == '0' && !confirm(ComGetMsg("BKG08012", sheetObj.CellValue(ir, "bkg_no")))) {
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

	function sheet1_OnChange(sheetObj, row, col, val) {
				//
		var col_save_name = sheetObj.ColSaveName(col);
		if(col_save_name == "adj_vol_qty"){
			/*
			 * 1. 0에서 1 사이의 값만 입력가능 - 이외의 값을 입력한 경우 메시지 [BKG08013] 표시 후 값 원복
			 * 2. Special Flag가 Y인 경우 0으로 입력 불가능하게 처리함. 0 입력시 이전값으로 원복 처리
			 * 3. S/O가 Y인 경우 0으로 입력 불가능하게 처리함. 0 입력시 이전값으로 원복 처리
			 * 4. Vol.이 1이 되는 BKG는 Partial flag를 'N'으로 변경
			 * 5. adjusted가 0 인 경우 해당 bkg에서 container 삭제
			*/
			// 0 <= vol <= 1
			if(val < 0 || val > 1 ){
				ComShowMessage(ComGetMsg("BKG08013"));
				sheetObj.CellValue2(row, "adj_vol_qty") = before_edit_val;
				sheetObj.SelectCell(row, "adj_vol_qty");
				return false;
			}
			//
			if(sheetObj.CellValue(row, "spcl_flg") == 'Y' && val == 0){
				sheetObj.CellValue2(row, "adj_vol_qty") = before_edit_val;
				sheetObj.SelectCell(row, "adj_vol_qty");
				return false;
			}
			//
			if(sheetObj.CellValue(row, "so_flg") == 'Y' && val == 0){
				sheetObj.CellValue2(row, "adj_vol_qty") = before_edit_val;
				sheetObj.SelectCell(row, "adj_vol_qty");
				return false;
			}
		}
	}
	/* 개발자 작업  끝 */