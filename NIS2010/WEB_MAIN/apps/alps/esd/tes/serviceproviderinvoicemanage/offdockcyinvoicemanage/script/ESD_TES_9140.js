/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESD_TES_9140.js
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion :
===============================================================================
 History
 2012.08.09 변종건 [CHM-201219313-01] [TES] Invoice data 입력시 Container Verification에서의 Date format 추가 요청
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

	/**
	 * @fileoverview Off-Dock CY Container - Coincidence 에서 File Upload 화면에서 사용하는 업무 스크립트를 정의한다.
	 * @author SM LINE
	 */
	
	/**
	 * @extends Tes
	 * @class ESD_TES_9140 : Off-Dock CY Container List - Coincidence 에서 File Upload 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_TES_9140() {
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
	var opener_obj = window.dialogArguments;
	var insCnt = 0;
	var jb_sts_flg = 0;

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 * @return
	 */
    function processButtonClick(){

         var sheetObject = sheetObjects[0];

         var formObj = document.form;

    	 try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

         	    case "btn_loadexcel":
					// eBilling - B
					//if (window.dialogArguments.document.form.edi_flg.value == 'Y'){
					//	return false;
					//}
					// eBilling - E
					if (ComGetObjValue(formObj.manual_input_yn) == "Y"){ 
						return false;
        	        }
					if (!chkOprShtData()){
						return false;
					}
					sheetObject.RemoveAll();
					doActionIBSheet(sheetObject,formObj,IBLOADEXCEL);
        	        break;

         	    case "btn_chkdigit":
        	        if(sheetObject.RowCount > 0){
        	            doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC01);
                    }
        	        break;

         	    case "btn_verify":
					if (!chkOprShtData()){
						return false;
					}
					if (sheetObject.RowCount > 0){
						delBlkRows(sheetObject);
						if (ComGetObjValue(formObj.manual_input_yn) != "Y"){ 
						    // 2008-07-11 추가 start - CHK Digit 후 CNTR 오류 check 초기화됨 그래서 CNTR 오류 다시 check
						    val_chk(sheetObject);
		                    chkDupRow(sheetObject);
		                    rmvInvRow(sheetObject);
		                    getMinMaxFilepuploadDate(sheetObject);
						    // 2008-07-11 추가 end
							// 자동 mode

							if (!verify_done){
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
								
								if (rmvInvRow(sheetObject)){
									if (sheetObject.RowCount > 0){
										doActionIBSheet(sheetObject,formObj,IBSEARCH);
									} else {
										ComShowMessage(ComGetMsg('TES23051')); //ComShowMessage('verify할 data가 없습니다.');
										break;
									}
								}
							} else {
								ComShowMessage(ComGetMsg('TES23052')); //ComShowMessage('verify 완료 상태');
							}
						} else {
							// 수동 mode
							for (var i=1; sheetObject!=null && i<=sheetObject.RowCount; i++){
								// 수동 mode시 verify마다 초기화하고 다시 전부 검사한다...
								sheetObject.CellValue2(i,'valid_chk') = '';
								sheetObject.CellValue2(i,'dup_chk_conf') = '';
								sheetObject.RowFontColor(i) = sheetObject.RgbColor(0, 0, 0);
							}
							val_chk(sheetObject);
							chkDupRow(sheetObject);
							if (rmvInvRow(sheetObject)){
								getMinMaxFilepuploadDate(sheetObject);
								if (sheetObject.RowCount > 0){
									doActionIBSheet(sheetObject,formObj,IBSEARCH);
								} else {
									ComShowMessage(ComGetMsg('TES23051')); //ComShowMessage('verify할 data가 없습니다.');
									break;
								}
							}
						}
					}
        	        break;
				
				case "btn_rowadd":
        	        if (ComGetObjValue(formObj.manual_input_yn) != "Y"){ 
						return false;
        	        }
        	        
                    // CHM-201641075 Get CNTR List화면에서 Multi-Row Add기능 추가 - 2016-04-15
					for (var i = 0; i < formObj.rowsadd.value; i++) {
	        	        var row = sheetObject.DataInsert(-1);
						setShtCellsEditable(sheetObject,row,'cntr_no|cntr_sty_cd|cntr_tpsz_cd|inv_gate_in_dt|inv_gate_out_dt|valid_chk|dup_chk_conf');
						formObj.manual_input_yn[0].disabled = true;
						formObj.manual_input_yn[1].disabled = true;
						sheetObject.CellValue(row,'cntr_sty_cd') = '';
						sheetObject.CellValue(row,'cntr_tpsz_cd') = '';
						verify_done = false;
					}
        	        break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
				verify_done = false;
				ComShowMessage(ComGetMsg('TES23028')); //ComShowMessage("The service is not available now.");
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * 수동입력시 rowadd 할때 editable 컬럼 지정
     * @param {ibsheet} sheetObj 	IBSheet Object
     * @param {int}		rownum		특정 셀의 Row Index
     * @param {int}		colnms		editable 설정할 커럼들
     * @return
     */
	function setShtCellsEditable(sheetObj, rownum, colnms) {
		// 수동입력 rowadd를 할때마다 실행..
		if (rownum==null || rownum==undefined || colnms==null || colnms==undefined){return false;
		}

		var arr_colnms = colnms.split('|');
		for (var i=0; arr_colnms!=null && i<arr_colnms.length; i++){
			sheetObj.CellEditable(rownum,arr_colnms[i]) = true;
		}
	}

 	/**
 	* sts_column 을 to_sts 로 값 세팅
 	* @param {ibsheet}	sheetObj	IBSheet Object
 	* @param {int}		sts_colnm	특정 셀의 Column Index 
 	* @param {int}		to_sts		특정 셀의 Column Index 
 	* @return
 	*/
	function setShtStatus(sheetObj, sts_colnm, to_sts) {
		if (sheetObj.RowCount > 0)
		{
			if (sts_colnm!=null && sts_colnm!=undefined && sts_colnm.trim()!='' &&
				to_sts!=null && to_sts!=undefined && to_sts.trim()!='')
			{
				for (i=1; i<sheetObj.Rows; i++) //제목은 제외
				{
					sheetObj.CellValue2(i,sts_colnm) = to_sts;
				}
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

		//호출하는 본 page의 Period날짜에 변경이 있을 경우 먼저 저장을 하게 하고 File Upload를 하게 한다.
		if (document.form.fm_prd_dt.value != window.dialogArguments.document.main_hidden.CellValue(1,'fm_prd_dt') || 
			document.form.to_prd_dt.value != window.dialogArguments.document.main_hidden.CellValue(1,'to_prd_dt'))
		{
			ComShowMessage(ComGetMsg('TES23038'));
			window.close();
		}

		chkOprShtData();
		document.form.manual_input_yn[1].checked = true;

		// eBilling - B
		//if (window.dialogArguments.document.form.edi_flg.value == 'Y'){
		//	document.form.manual_input_yn[0].disabled = true;
		//	document.form.manual_input_yn[1].disabled = true;
		//	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
		//}
		// eBilling - E
    }

    /**
     * 특정 작업을 하기 전에 sheet 에 데이터가 있을경우 삭제가 필요할때 사용하는 함수.
     * @return
     */
	function chkOprShtData(){
		if (hasOprShtData()){
			//if (!confirm('Coincidence, Discrepancy, Cost Calc.(TMNL), Cost Calc.(SR by FD) Tab의 모든 Data를 삭제할까요?')){
			if (!confirm(ComGetMsg('TES23053'))){
				window.close();
			} else {
				opener_obj.removeOffdockCYInvoice01();
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

		// Coincidence, Discrepancy, CalcTMNL, CalcByDay sheet의 data가 존재하는지 확인 
		for (var i=1; i<=4; i++){
			opener_sheet_obj = opener_obj.eval('document.t'+i+'sheet1');
			if (opener_sheet_obj!=null && opener_sheet_obj.RowCount > 0){
				return true;
			}
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
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(9, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

                    var HeadTitle = "|Seq.No.|CNTR No.|F/M|Type/Size|Gate In|Gate Out|Stay Days";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    
                    //데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, 	dtHiddenStatus,     30, daCenter,  	true,    	"ibflag");
                    InitDataProperty(0, cnt++, 	dtSeq,        		60, daCenter,  	true,    	"",        						false,      "",       	dfNone,    		0,     	false,      false,		5);
                    InitDataProperty(0, cnt++, 	dtData,      	   100, daCenter,  	true,    	"cntr_no",        				false,      "",       	dfNone,    		0,     	false,      false,		14);
					InitDataProperty(0, cnt++, 	dtCombo,       		60, daCenter,  	true,    	"cntr_sty_cd",        			false,      "",       	dfNone,    		0,     	false,      false,		1);
					InitDataProperty(0, cnt++, 	dtCombo,       		70, daCenter,  	true,    	"cntr_tpsz_cd",        			false,      "",       	dfNone,    		0,     	false,      false,		2);
					InitDataProperty(0, cnt++, 	dtData,      	   110, daCenter,  	true,    	"inv_gate_in_dt",        		false,      "", 		dfUserFormat2,  0,     	false,      false);
					InitDataProperty(0, cnt++, 	dtData,      	   110, daCenter,  	true,    	"inv_gate_out_dt",        		false,      "", 		dfUserFormat2,  0,     	false,      false);
					InitDataProperty(0, cnt++, 	dtHidden,       	70, daCenter,  	true,    	"valid_chk",        			false,      "",       	dfNone,    		0,     	false,      false);
					InitDataProperty(0, cnt++, 	dtHidden,       	10, daCenter,  	true,    	"dup_chk_conf",        			false,      "",       	dfNone,    		0,     	false,      false);

                    InitUserFormat2(0, "inv_gate_in_dt", "####-##-## ##:##", "-|:" ); 
                    InitUserFormat2(0, "inv_gate_out_dt", "####-##-## ##:##", "-|:" );

					InitDataCombo(0 , "cntr_sty_cd" , cntr_sty_cdCode, cntr_sty_cdCode);
					InitDataCombo(0 , "cntr_tpsz_cd" , document.form.cntr_tpsz_cd.value, document.form.cntr_tpsz_cd.value);
					InitDataValid(0, "cntr_no", vtEngUpOther, "0123456789");
					
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
                     InitRowInfo( 1, 1, 9, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(9, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false, false);

                     var HeadTitle = "|Seq.No.|CNTR No.|F/M|Type/Size|Gate In|Gate Out|Stay Days";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);
                     
                     //데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++, 	dtHiddenStatus,     30, daCenter,  	true,    	"ibflag");
                     InitDataProperty(0, cnt++, 	dtSeq,        		60, daCenter,  	true,    	"",        						false,      "",       	dfNone,    		0,     	false,      false,		5);
                     InitDataProperty(0, cnt++, 	dtData,      	   100, daCenter,  	true,    	"cntr_no",        				false,      "",       	dfNone,    		0,     	false,      false,		14);
 					InitDataProperty(0, cnt++, 	dtCombo,       		60, daCenter,  	true,    	"cntr_sty_cd",        			false,      "",       	dfNone,    		0,     	false,      false,		1);
 					InitDataProperty(0, cnt++, 	dtCombo,       		70, daCenter,  	true,    	"cntr_tpsz_cd",        			false,      "",       	dfNone,    		0,     	false,      false,		2);
 					InitDataProperty(0, cnt++, 	dtData,      	   110, daCenter,  	true,    	"inv_gate_in_dt",        		false,      "", 		dfUserFormat2,  0,     	false,      false);
 					InitDataProperty(0, cnt++, 	dtData,      	   110, daCenter,  	true,    	"inv_gate_out_dt",        		false,      "", 		dfUserFormat2,  0,     	false,      false);
 					InitDataProperty(0, cnt++, 	dtHidden,       	70, daCenter,  	true,    	"valid_chk",        			false,      "",       	dfNone,    		0,     	false,      false);
 					InitDataProperty(0, cnt++, 	dtHidden,       	10, daCenter,  	true,    	"dup_chk_conf",        			false,      "",       	dfNone,    		0,     	false,      false);

                     InitUserFormat2(0, "inv_gate_in_dt", "####-##-## ##:##", "-|:" ); 
                     InitUserFormat2(0, "inv_gate_out_dt", "####-##-## ##:##", "-|:" );

 					InitDataCombo(0 , "cntr_sty_cd" , cntr_sty_cdCode, cntr_sty_cdCode);
 					InitDataCombo(0 , "cntr_tpsz_cd" , document.form.cntr_tpsz_cd.value, document.form.cntr_tpsz_cd.value);

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
				getMinMaxFilepuploadDate(sheetObj);

				formObj.f_cmd.value = SEARCHLIST;
				var param = sheetObj.GetSaveString(true,false);
				var sXml = sheetObj.GetSearchXml("ESD_TES_9140Popup.do", param+'&'+tesFrmQryStr(formObj),"",true);
				sheetObj.LoadSearchXml(sXml, true); 
				break;

           case IBSEARCH_ASYNC01:
                formObj.f_cmd.value = SEARCH01;
                var param = sheetObj.GetSaveString(true,false);
                var searchXml = sheetObj.GetSearchXml("ESD_TES_9140Popup.do", param+'&'+tesFrmQryStr(formObj),"",true);
                sheetObj.RemoveAll();
				if (searchXml!=null && searchXml!='') sheetObj.LoadSearchXml(searchXml);
				break;

           case IBSEARCH_ASYNC02:
               formObj.f_cmd.value = SEARCH03;
               var param = sheetObjects[1].GetSaveString(true,false);
               var searchXml = sheetObjects[1].GetSearchXml("ESD_TES_9140Popup.do", param+'&'+tesFrmQryStr(formObj),"",true);
               sheetObjects[1].RemoveAll();
				if (searchXml!=null && searchXml!='') sheetObjects[1].LoadSearchXml(searchXml);
				break;				
				
		   // eBilling - B
           //case IBSEARCH_ASYNC02:
           //     formObj.f_cmd.value = SEARCH02;
           //     var searchXml = sheetObj.GetSearchXml("ESD_TES_914Popup.do", tesFrmQryStr(formObj),"",true);
           //     sheetObj.RemoveAll();
			//	if (searchXml!=null && searchXml!='') sheetObj.LoadSearchXml(searchXml);
            //    break;
		   // eBilling - E

		   case IBLOADEXCEL:
                sheetObj.LoadExcel(-1); // false -> 엑셀로부터 무조건 읽어오기
                break;
        }
    }

	/**
	 * 조회가 완료되고 실행되는 이벤트
	 * @param {ibsheet}	sheet		IBSheet Object
	 * @param {string}	ErrMsg		error message
	 * @return
	 */	
	function sheet_OnSearchEnd(sheet, ErrMsg){
		var id;
		
		if (sheet.RowCount > 0){
			if (document.form.f_cmd.value == SEARCHLIST){
				verify_done = true;
				
				key = sheet.EtcData("key");
				jb_sts_flg = sheet.EtcData("jb_sts_flg");
				document.form.resultStr.value = key ;
				
				sheet.RemoveEtcData();
				insCnt = (insCnt!=undefined&&insCnt!=null&insCnt!=''?insCnt:0);
				jb_sts_flg = (jb_sts_flg!=undefined&&jb_sts_flg!=null&jb_sts_flg!=''?jb_sts_flg:0);
				
				window.focus();
				if(jb_sts_flg==3){
					opener_obj.retrieveCntrList();
					insCnt += opener_obj.document.t1sheet1.RowCount;
					insCnt += opener_obj.document.t2sheet1.RowCount;
					
					ComShowMessage(ComGetMsg('TES23058',insCnt)); //ComShowMessage(insCnt + '건의 List가 verify완료되었습니다.');
					window.close();
					
				}else{
//					alert("Please Wait just a moment");
					id = setInterval("chkStatus()", 2000); // 1초마다 good 메세지를 띄웁니다.
				}
					
			}
		}

	}
	
	function chkStatus(){
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC02);
	}

	/**
	 * 조회가 완료되고 실행되는 이벤트
	 * @param {ibsheet}	sheet		IBSheet Object
	 * @param {string}	ErrMsg		error message
	 * @return
	 */	
	function main_hidden_OnSearchEnd(sheet, ErrMsg){
		var id;
		
			if (document.form.f_cmd.value == SEARCH03){
				jb_sts_flg = sheet.EtcData("jb_sts_flg");
				sheet.RemoveEtcData();
				jb_sts_flg = (jb_sts_flg!=undefined&&jb_sts_flg!=null&jb_sts_flg!=''?jb_sts_flg:0);
				window.focus();
				
				if(jb_sts_flg==3){
					clearInterval(id);
					window.close();
					opener_obj.retrieveCntrList();
					insCnt += opener_obj.document.t1sheet1.RowCount;
					insCnt += opener_obj.document.t2sheet1.RowCount;
					ComShowMessage(ComGetMsg('TES23058',insCnt)); //ComShowMessage(insCnt + '건의 List가 verify완료되었습니다.');
					
					
				}else{//

				}
		}

	}
	
	/**
	 * 엑셀 로드 후 실행되는 이벤트
	 * @param {ibsheet}	sheet		IBSheet Object
	 * @return
	 */
	function sheet_OnLoadExcel(sheet){
		if (sheet.RowCount > 0){
			document.form.manual_input_yn[0].disabled = true;
			document.form.manual_input_yn[1].disabled = true;
		}
		delBlkRows(sheet);
		
		for( var idx = parseInt(sheet.HeaderRows); idx <= sheet.LastRow; idx++ ){
			sheet.CellValue(idx, "cntr_tpsz_cd")	= sheet.CellText(idx, "cntr_tpsz_cd").toUpperCase();
			sheet.CellValue(idx, "cntr_sty_cd")	= sheet.CellText(idx, "cntr_sty_cd").toUpperCase();

			if( sheet.CellValue(idx,"inv_gate_in_dt").length == 8 ){
				sheet.CellValue2(idx,"inv_gate_in_dt") = sheet.CellValue(idx,"inv_gate_in_dt") + "0000";
			} else if( sheet.CellValue(idx,"inv_gate_in_dt").length > 8 && sheet.CellValue(idx,"inv_gate_in_dt").length < 12 ){
				sheet.CellValue2(idx,"inv_gate_in_dt") = sheet.CellValue(idx,"inv_gate_in_dt").substr(0,8) + "0000";
			}
			
			if( sheet.CellValue(idx,"inv_gate_out_dt").length == 8 ){
				sheet.CellValue2(idx,"inv_gate_out_dt") = sheet.CellValue(idx,"inv_gate_out_dt") + "0000";
			} else if( sheet.CellValue(idx,"inv_gate_out_dt").length > 8 && sheet.CellValue(idx,"inv_gate_out_dt").length < 12 ){
				sheet.CellValue2(idx,"inv_gate_out_dt") = sheet.CellValue(idx,"inv_gate_out_dt").substr(0,8) + "0000";
			}
		}
		
		val_chk(sheet);
		chkDupRow(sheet);
		rmvInvRow(sheet);
		getMinMaxFilepuploadDate(sheet);
		verify_done = false;
	}

	/**
	 * Sheet 수정 시 실행되는 이벤트
	 * @param {ibsheet}	sheet		IBSheet Object
	 * @param {int}		row			특정 셀의 Row Index
	 * @param {int}		col			특정 셀의 Column Index
	 * @param {int}		val			변경된 값
	 * @return
	 */
	function sheet_OnChange(sheet, row, col, val){
		var sName = null;
		if (sheet.RowCount > 0){
			sName = sheet.ColSaveName(col);
			if (sName!=undefined && sName!=null && (sName=='cntr_sty_cd' || sName=='cntr_tpsz_cd')) {
				sheet.CellValue2(row,col) = sheet.CellValue(row,col).toUpperCase();
			}
		}
		
		if( sheet.RowCount > 0 ){
 			if( sheet.ColSaveName(col) == "inv_gate_in_dt" ){
 				if( sheet.CellValue(row,"inv_gate_in_dt").length == 8 ){
 					sheet.CellValue2(row,"inv_gate_in_dt") = sheet.CellValue(row,"inv_gate_in_dt") + "0000";
 				} else if( sheet.CellValue(row,"inv_gate_in_dt").length > 8 && sheet.CellValue(row,"inv_gate_in_dt").length < 12 ){
 					sheet.CellValue2(row,"inv_gate_in_dt") = sheet.CellValue(row,"inv_gate_in_dt").substr(0,8) + "0000";
 				}
 			}
 			
 			if( sheet.ColSaveName(col) == "inv_gate_out_dt" ){
 				if( sheet.CellValue(row,"inv_gate_out_dt").length == 8 ){
 					sheet.CellValue2(row,"inv_gate_out_dt") = sheet.CellValue(row,"inv_gate_out_dt") + "0000";
 				} else if( sheet.CellValue(row,"inv_gate_out_dt").length > 8 && sheet.CellValue(row,"inv_gate_out_dt").length < 12 ){
 					sheet.CellValue2(row,"inv_gate_out_dt") = sheet.CellValue(row,"inv_gate_out_dt").substr(0,8) + "0000";
 				}
 			}
 		}
	}

	/**
	 * Sheet 에 있는 데이터중 가장 작은 날짜와 가장 큰 날짜 구하는 함수
	 * @param {ibsheet}	sheet		IBSheet Object
	 * @return
	 */
	function getMinMaxFilepuploadDate(sheet){
		var formObj = document.form;
		var fileup_min_gt_in_dt;
		var fileup_max_gt_out_dt;
		for (var i=1; i<=sheet.RowCount; i++){
			if (fileup_min_gt_in_dt==null || fileup_min_gt_in_dt.trim()==''){
				fileup_min_gt_in_dt = (!isNaN(sheet.CellValue(i,'inv_gate_in_dt'))?sheet.CellValue(i,'inv_gate_in_dt'):'');
			} else {
				if (!isNaN(sheet.CellValue(i,'inv_gate_in_dt')) && sheet.CellValue(i,'inv_gate_in_dt') < fileup_min_gt_in_dt){
					fileup_min_gt_in_dt = sheet.CellValue(i,'inv_gate_in_dt');
				}
			}
			if (fileup_max_gt_out_dt==null || fileup_max_gt_out_dt.trim()==''){
				fileup_max_gt_out_dt = (!isNaN(sheet.CellValue(i,'inv_gate_out_dt'))?sheet.CellValue(i,'inv_gate_out_dt'):'');
			} else {
				if (!isNaN(sheet.CellValue(i,'inv_gate_out_dt')) && sheet.CellValue(i,'inv_gate_out_dt') > fileup_max_gt_out_dt){
					fileup_max_gt_out_dt = sheet.CellValue(i,'inv_gate_out_dt');
				}
			}
		}
		if (!chkGtOutDt()){
			var opr_to_prd_dt = opener_obj.document.form.to_prd_dt.value.trim().replace(/-/gi,'');
			var curr_to_prd_dt = formObj.to_prd_dt.value.trim().replace(/-/gi,'');
			if (opr_to_prd_dt!=undefined && opr_to_prd_dt!=null && opr_to_prd_dt!=''){
				if (opr_to_prd_dt != curr_to_prd_dt){
					ComShowMessage(ComGetMsg('TES23064')); //ComShowMessage('Period의 마지막 값과 일치하지 않습니다. 진행불가');
					sheetObjects[0].RemoveAll();
					return false;
				}
			} else {
				ComShowMessage(ComGetMsg('TES23065')); //ComShowMessage('Period의 값에 오류가 발생했습니다. 진행불가');
				sheetObjects[0].RemoveAll(); 
				return false;
			}
			fileup_max_gt_out_dt = formObj.to_prd_dt.value.trim().replace(/-/gi,'');
		}
		formObj.fileup_min_gt_in_dt.value = (fileup_min_gt_in_dt.length>=8?fileup_min_gt_in_dt.substring(0,8):'');
		formObj.fileup_max_gt_out_dt.value = (fileup_max_gt_out_dt.length>=8?fileup_max_gt_out_dt.substring(0,8):'');
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
//            if (!ComIsNumber(iPage)) {
//
//                return false;
//            }
        }

        return true;
    }

	/**
	 * 중복검사
	 * @param {ibsheet}	sheet	IBSheet Object
	 * @return
	 */
	function chkDupRow(sheet){
		var idx = 0;
		var Rows;
		Rows = sheet.ColValueDupRows("cntr_no|inv_gate_in_dt|inv_gate_out_dt");
		var arr_rows = null;
		if (Rows!=null && Rows.trim()!=''){
			arr_rows = Rows.split(',');
		}
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

		if (sheet.RowCount > 0){
			var delRows = '';
			var cnt = 0;
			
			for (var i=1; i<=sheet.RowCount; i++){
				if ( (sheet.CellValue(i,'valid_chk')!=undefined && sheet.CellValue(i,'valid_chk').trim()=='X') ||
					 (sheet.CellValue(i,'dup_chk_conf')!=undefined && sheet.CellValue(i,'dup_chk_conf')!=null && sheet.CellValue(i,'dup_chk_conf').trim()!='') )
				{
					delRows = delRows + (cnt>0?"|":"") + (new String(i));
					inval_row = true;
					cnt++;
				}
			}

			if (inval_row){
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
	function delInvalRow(sheet, delRows) {
		if (sheet.RowCount > 0){
			var arr = delRows.split('|');
			for (var i=(arr.length-1); arr!=null && i>=0; i--)
			{
				sheet.RowDelete(arr[i], false);
			}
			return true;
		}
	}

	/**
	 * 셀에 값이 없을경우 row 삭제 함수
	 * @param {ibsheet}sheet	IBSheet Object
	 * @return
	 */
	function delBlkRows(sheet) {
		if (sheet.RowCount > 0){
			for (var i=sheet.RowCount; sheet!=null && i>=0; i--){
				if ((sheet.CellValue(i,'cntr_no')==null ||sheet.CellValue(i,'cntr_no')=='') &&
					(sheet.CellValue(i,'cntr_sty_cd')==null ||sheet.CellValue(i,'cntr_sty_cd')=='') &&
					(sheet.CellValue(i,'cntr_tpsz_cd')==null ||sheet.CellValue(i,'cntr_tpsz_cd')=='') &&
					(sheet.CellValue(i,'inv_gate_in_dt')==null ||sheet.CellValue(i,'inv_gate_in_dt')=='') && 
					(sheet.CellValue(i,'inv_gate_out_dt')==null ||sheet.CellValue(i,'inv_gate_out_dt')=='')) 
				{
					sheet.RowDelete(i, false);
				}
			}
		}
	}

	/**
	 * 데이터 유효성 체크 함수
	 * @param {ibsheet}sheet	IBSheet Object
	 * @return
	 */
	function val_chk(sheet) {
		if (sheet.RowCount > 0) {
			var isValid = true;
			for (var i=1; i<=sheet.RowCount; i++) {

				if (!isValidYYYYMMDDHHMI(sheet.CellValue(i,'inv_gate_in_dt'))) {
					isValid = false;
				} else {
					if (isValid){isValid = true;}
				}
				
				if (!chkGtOutDt() && (sheet.CellValue(i,'inv_gate_out_dt')==null || sheet.CellValue(i,'inv_gate_out_dt').trim()=='')) {
					sheet.CellValue(i,'inv_gate_out_dt') = sheet.CellValue(i,'inv_gate_out_dt').trim();
					if (isValid){isValid = true;}
				} else  {
					if (!isValidYYYYMMDDHHMI(sheet.CellValue(i,'inv_gate_out_dt'))) {
						isValid = false;
					} else {
						if (isValid){isValid = true;}
					}
				}

				/*  2008-03-24 : 김부장님 요청 ~ GATE_IN_DT가 GATE_OUT_DT보다 이전이여야(작아야) 한다.  */
				if (sheet.CellValue(i,'inv_gate_in_dt')!=null && sheet.CellValue(i,'inv_gate_in_dt').trim()!='' && 
					sheet.CellValue(i,'inv_gate_out_dt')!=null && sheet.CellValue(i,'inv_gate_out_dt').trim()!='') {
					if (!(parseInt(sheet.CellValue(i,'inv_gate_out_dt'),10) - parseInt(sheet.CellValue(i,'inv_gate_in_dt'),10) > 0)){
						isValid = false;
					} else {
						if (isValid){isValid = true;}
					}
				}
				
				/*  
					2008-03-24 : 김부장님 요청 ~ GATE_IN_DT은 어떤 경우에도 TO_PERIOD보다 이전이여야(작아야) 한다.  
					2008-04-01 : 전과장님 요청 ~ 단, GATE_IN_DT은 어떤 경우에도 TO_PERIOD 날 자체를 포함하여 이전이여야(작아야) 한다.  
												 -> TO_PERIOD가 2008년 02월 29일이면 20080229 23:59:59까지는 포함해야한다
												 -> 결국 하루를 더하여 2008년 03월 01일 00:00보다 이전이면 된다. 비교할 때는 하루를 더하고 00시 00분 이전으로 비교하면 된다.
				*/
				if (sheet.CellValue(i,'inv_gate_in_dt')!=null && sheet.CellValue(i,'inv_gate_in_dt').trim()!='' && document.form.to_prd_dt.value!=null) {
					if (!(parseInt((tes_getDiffDate(new String(document.form.to_prd_dt.value).trim().replace(/-/gi,''),1,null)+'0000'),10) - parseInt(sheet.CellValue(i,'inv_gate_in_dt'),10) > 0)) {
						isValid = false;
					} else {
						if (isValid){isValid = true;}
					}
				}
						
				/*  2008-03-24 : 김부장님 요청 ~ GATE_OUT_DT값이 null이 아니라면 GATE_OUT_DT은 어떤 경우에도 FM_PERIOD보다 이후이여야(커야) 한다.  */
				if (sheet.CellValue(i,'inv_gate_out_dt')!=null && sheet.CellValue(i,'inv_gate_out_dt').trim()!='' && document.form.fm_prd_dt.value!=null) {
					if (!(parseInt(sheet.CellValue(i,'inv_gate_out_dt'),10) - parseInt((document.form.fm_prd_dt.value.trim().replace(/-/gi,'')+'0000'),10) > 0)) {
						isValid = false;
					} else {
						if (isValid){isValid = true;}
					}
				}
				
				if (sheet.CellValue(i,'cntr_sty_cd')==null || sheet.CellValue(i,'cntr_sty_cd').trim()==''){
					isValid = false;
				}

				if (!isValid){
					sheet.RowFontColor(i) = sheet.RgbColor(255, 0, 0);
					sheet.CellValue2(i,'valid_chk') = 'X';
				} else {
					sheet.CellValue2(i,'valid_chk') = '';
				}

				isValid = true; //초기화
			}
		}
	}

	/**
	 * Gate Out Date 유효성 체크 필요성 유무 확인 함수
	 * @return
	 */
	function chkGtOutDt(){
		var formObj = document.form;
		var tml_cost_grp_cd = formObj.tml_cost_grp_cd.value;
		var tml_calc_ind_cd = formObj.tml_calc_ind_cd.value;
		var sto_dys_ind_cd  = formObj.sto_dys_ind_cd.value;
		
		if (tml_calc_ind_cd!=undefined && tml_calc_ind_cd.trim().length == 2) {
			if (tml_calc_ind_cd.trim() == 'SP') {return false;} //확인 안한다
		}
		if (sto_dys_ind_cd!=undefined && sto_dys_ind_cd.trim().length == 2) {
			if (sto_dys_ind_cd.trim() == 'DT') {return false;} //확인 안한다
		}

		return true; //확인한다
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
        var str = src.replace(/\/|\-|\./g,"");
/*
		if (!isNumSlash(src) && !isNumPeriod(src) && !isNumDash(src)) {
			return false;
		}
*/
		if (str.length != 6) {
            return false;
        }

        var year  = str.substring(0,4);
        var month = str.substring(4,6);

        if ( ComParseInt( year ) >= 1900  && isMonth( month ))
            return true;
        else {
            return false;
        }
    }

	/**
	 * 날짜+시간 유효성 체크 함수
	 * @param {String}	str		YYYYMMDDHHMI
	 * @return
	 */	
    function isValidYYYYMMDDHHMI (str) {
    	str = new String(str);    	
        str = str.replace(/\/|\-|\./g,"");
        
		if (!ComIsNumber(str)) { return false; }		
		
		if (str.length != 12) { return false; }

        var sDate  = str.substring(0,8);
		var sHour  = str.substring(8,10);
		var sMin   = str.substring(10,12);
		
		if( ComIsDate(sDate) && ComIsTime(sHour+":"+sMin, "hm") ) {
            return true;
        } else {
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
 	 * 시간 유효성 체크 함수
 	 * @param {String}	hh	HH
 	 * @return
 	 */     
	function isHour(hh) {
		var h = parseInt(hh,10);
		return (h >= 0 && h < 24);
	}

 	/**
	 * 분 유효성 체크 함수
	 * @param {String}	mi	MI
	 * @return
	 */	
	function isMin(mi) {
		var m = parseInt(mi,10);
		return (m >= 0 && m < 60);
	}

	/**
	 * ComConfigSheet 제정의 함수
	 * @param {sheet}	sheet_obj	ibsheet
	 * @return
	 */
    function TesComConfigSheet(sheet_obj)
    {

    	ComConfigSheet(sheet_obj);
    	try{
    		with(sheet_obj){

//			  var arr = GetSelectionRows("/").split("/");
//
//			  if( arr.length > 0 ){
//				  SelectBackColor       = RgbColor(255,245,228);
//				  RowFontColor(arr[0]) = RgbColor(255, 0, 0);
//			  }
				SelectHighLight       = false;
				SelectFontBold        = true;
    		}
    	} catch(err) { ComFuncErrMsg(err.message); }
    }

