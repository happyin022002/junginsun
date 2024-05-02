/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0697.js
*@FileTitle  : Multi-Seal no input
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   	/* 개발자 작업	*/

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var opener_obj = (opener || parent);
	
	var seal_knd_str = opener_obj.seal_knd_str;
	var seal_pty_tp_str = opener_obj.seal_pty_tp_str;
	var saveChkFlg = "N";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_add":
					doActionIBSheet(sheetObject1, formObject, IBINSERT);
				break;
				case "btn_delete":
					doActionIBSheet(sheetObject1, formObject, IBDELETE);
				break;
				case "btn_save":
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
				//break;														
				case "btn_close":
                    ComClosePopup(); 
				break;										
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
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
        opener_obj = window.dialogArguments;
        if (!opener_obj) opener_obj=window.opener;  //이 코드 추가할것
    	if (!opener_obj) opener_obj=parent; //이 코드 추가할것
    	
		if(opener_obj.document.form.cn_flg.value == 'Y'){
			sheetObjects[0].SetColHidden("seal_knd_cd",0);
			sheetObjects[0].SetColHidden("seal_pty_tp_cd",0);
		}else{
			sheetObjects[0].SetColHidden("seal_knd_cd",1);
			sheetObjects[0].SetColHidden("seal_pty_tp_cd",1);
		}
		// do init action
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":      //sheet1 init
                with(sheetObj){
                    //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    var HeadTitle="|Sel.|bkg no|cntr no|Seal Seq.|Seal No|Kind/Code|Kind/Code|pty_nm|Via|Print|||";
                    
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                         {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sel" },
                         {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:250,  Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:15, AcceptKeys:"E|N|[~!@#$%^&*()--_+={}[]|\\:;<.>/? ]" , InputCaseSensitive:1},
                         {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seal_knd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, ComboText:seal_knd_str, ComboCode:seal_knd_str },
                         {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seal_pty_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, ComboText:seal_pty_tp_str, ComboCode:seal_pty_tp_str },                         
                         {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"seal_pty_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seal_inp_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prn_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",  Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"old_cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",  Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"old_cntr_seal_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",  Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"old_seal_inp_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
                    
                    InitColumns(cols);
                    
                    SetEditable(1);
                    SetSheetHeight(250);
                }
                

               break;
        }
    }
  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        var eur='';
        if(opener_obj.document.form.eur_flg != undefined)
        	eur=opener_obj.document.form.eur_flg.value;
        switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=SEARCH;
					//sheetObj.DoSearch("ESM_BKG_0697GS.do", FormQueryString(formObj));
					if(eur == undefined || eur == ''){
						opener_obj.ComFilteredSheetToSheet(opener_obj.sheetObjects[2], sheetObj, 'cntr_no', formObj.cntr_no.value);
					}else if(eur == 'Y'){
						opener_obj.ComFilteredSheetToSheet(opener_obj.sheetObjects[5], sheetObj, 'cntr_no', formObj.cntr_no.value);
					}
				}
			break;
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)){
					var cntrNo=formObj.cntr_no.value;
					opener_obj.ComRowDelete(sheetObj, "cntr_seal_no", '');
					if(eur == ''){
						opener_obj.ComRowDelete(opener_obj.sheetObjects[2], 'cntr_no', cntrNo);
						opener_obj.ComFilteredSheetToSheet(sheetObj, opener_obj.sheetObjects[2], 'cntr_no', cntrNo);
					}else if(eur == 'Y'){
						opener_obj.ComRowDelete(opener_obj.sheetObjects[5], 'cntr_no', cntrNo);
						opener_obj.ComFilteredSheetToSheet(sheetObj, opener_obj.sheetObjects[5], 'cntr_no', cntrNo);
					}
					opener_obj.setSealNo(cntrNo);
					opener_obj.saveSeal(saveChkFlg,cntrNo);
				}
			break;
			case IBINSERT:      // 입력
				//alert (" Insert .. ");
				var newRow=sheetObj.DataInsert(-1);
				//alert("* newRow : " + newRow);
				sheetObj.SetCellValue(newRow, "bkg_no",formObj.bkg_no.value);
				sheetObj.SetCellValue(newRow, "cntr_no",formObj.cntr_no.value);
				sheetObj.SetCellValue(newRow, "seal_inp_tp_cd","MAN");
				sheetObj.SetCellValue(newRow, "prn_flg",'Y');
				//sheetObj.CellValue(newRow, "cntr_seal_seq") = ComGetMaxSeq(sheetObj, "cntr_seal_seq");
			break;
			case IBDELETE:      // 삭제
				//alert (" Delete .. ");
				//opener_obj.ComRowDelete(sheetObj, 'sel', 1);
				var arrRow=opener_obj.ComFindText(sheetObj, 'sel', 1);
				sheetObj.RowDelete(arrRow.join("|"), false);
				saveChkFlg="Y"; //ESM_BKG_0697 에서 seal no 지우고 저장할때 Ibflag 박아줌
			break;
        }
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction){
        switch(sAction) {
			case IBSAVE:        //저장
				with(formObj){
				}
			break;
		}
        return true;
    }
        /**
         * Seal No 추가 입력 or 수정 or 삭제 시에 저장될 수 있도록 flag 로 구분시켜 줌 
         */
        function sheet1_OnAfterEdit(sheetObj, Row, Col, Value) {
        	saveChkFlg="Y";
        }
	/* 개발자 작업  끝 */

   function sheet1_OnChange(sheetObj, row, col, val) {
	    var col_save_name=sheetObj.ColSaveName(col);
		if (col_save_name == "cntr_seal_no") {
			if(val != sheetObj.GetCellValue(row, "old_cntr_seal_no")){
				sheetObj.SetCellValue(row, "seal_inp_tp_cd","MAN",0);
			}else{
				sheetObj.SetCellValue(row, "seal_inp_tp_cd",sheetObj.GetCellValue(row, "old_seal_inp_tp_cd"),0);
			}
			
		}
   }
