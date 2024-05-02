/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_SCG_0103.jsp
*@FileTitle : Packing Instruction & Special Packing Provision-Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.22
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2010.01.27 나상보
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

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick1(srcName){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		/*******************************************************/
		var formObj = document.form;

     	try {
     		switch(srcName) {
     		
     		case "btn1_Row_Add":
				var row = sheetObjects[0].DataInsert(-1);
				sheetObjects[0].SelectCell(row, 4);
				sheetObjects[0].CellValue2(row, "imdg_pck_instr_cd") = formObj.imdg_pck_instr_cd.value;
				sheetObjects[0].CellValue2(row, "imdg_pck_instr_seq") = formObj.imdg_pck_instr_seq.value;
				sheetObjects[0].CellValue2(row, "regu_pck_cd_flg") = "Max QTY";
				sheetObjects[0].CellValue2(row, "regu_ibc_flg") = "Proper IBCs";
				sheetObjects[0].CellValue2(row, "regu_pck_org_prx_flg") = "Org. Peroxide/IBC";
				sheetObjects[0].CellValue2(row, "regu_pck_mzd_flg") = "OP Method";
				sheetObjects[0].CellValue2(row, "regu_img_flg") = "Image";
//				sheetObjects[0].CellImage(row,"regu_pkg_cd_flg_popup") = 1;
//				sheetObjects[0].CellImage(row,"regu_pkg_ibc_flg_popup") = 1;
				sheetObjects[0].CellImage(row,"regu_pkg_org_flg_popup") = 1;
				sheetObjects[0].CellImage(row,"regu_pkg_mzd_flg_popup") = 1;
				sheetObjects[0].CellImage(row,"regu_img_flg_popup") = 1;
				break;
				
 			case "btn1_Row_Delete":
				ComRowHideDelete(sheetObjects[0], "del_chk");
				break;
				
     		}
     	}catch(e) {
     		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
     	}
	}

     /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet1(sheetObj,sheetNo) {

    	 var cnt = 0;
	 		with (sheetObj) {

	 			// 높이 설정
	 			style.height = 200;
	 			//전체 너비 설정
	 			SheetWidth = mainTable.clientWidth;

	 			//Host정보 설정[필수][HostIp, Port, PagePath]
	 			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	 			//전체Merge 종류 [선택, Default msNone]
	 			MergeSheet = msHeaderOnly;

	 			//전체Edit 허용 여부 [선택, Default false]
	 			Editable = true;

	 			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	 			InitRowInfo( 1, 1, 3, 100);

	 			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	 			InitColumnInfo(17, 0, 0, true);

	 			// 해더에서 처리할 수 있는 각종 기능을 설정한다
	 			InitHeadMode(true, true, false, true, false,false)

	 			var HeadTitle = "|||Chk.|Display No.|Regulation|Definition by Specific Type|Definition by Specific Type|Definition by Specific Type|Definition by Specific Type|Definition by Specific Type|Definition by Specific Type|Definition by Specific Type|Definition by Specific Type|Definition by Specific Type|Definition by Specific Type|";

	 			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	 			InitHeadRow(0, HeadTitle, true);

	 			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	 			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	"ibflag");
	 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   "imdg_pck_instr_cd",  			false,  "",      dfNone,    0,     false,    	false);
	 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   "imdg_pck_instr_seq",  			false,  "",      dfNone,    0,     false,    	false);
	 			InitDataProperty(0, cnt++ , dtCheckBox, 	30,    	daCenter,   true,   "del_chk",				false,  "",      dfNone,	0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtData,        	80,		daCenter,   true,   "regu_dp_no", 				true,	"",      dfNone,	0,     false,		true);
	 			InitDataProperty(0, cnt++ , dtData,        	350,    daLeft,	   	true,   "regu_mn_desc",  		false,  "",      dfEngKey,    0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtHidden,      	80,	    daCenter,  	true,   "regu_pck_cd_flg",  			false,  "",      dfNone,    0,     false,    	false);
	 			InitDataProperty(0, cnt++ , dtHidden,    20,	    daCenter,  	true,   "regu_pkg_cd_flg_popup",		false,  "",      dfNone,    0,     false,    	false);
	 			InitDataProperty(0, cnt++ , dtHidden,      	80,	    daCenter,  	true,   "regu_ibc_flg",  			false,  "",      dfNone,    0,     false,    	false);
	 			InitDataProperty(0, cnt++ , dtHidden,    20,	    daCenter,  	true,   "regu_pkg_ibc_flg_popup",  		false,  "",      dfNone,    0,     false,    	false);
	 			InitDataProperty(0, cnt++ , dtData,      	100,   	daCenter,  	true,   "regu_pck_org_prx_flg",  			false,  "",      dfNone,    0,     false,    	false);
	 			InitDataProperty(0, cnt++ , dtImageText,    20,    	daCenter,  	true,   "regu_pkg_org_flg_popup",  		false,  "",      dfNone,    0,     false,    	false);
	 			InitDataProperty(0, cnt++ , dtData,      	170,	    daCenter,  	true,   "regu_pck_mzd_flg",  				false,  "",      dfNone,    0,     false,    	false);
	 			InitDataProperty(0, cnt++ , dtImageText,    20,	    daCenter,  	true,   "regu_pkg_mzd_flg_popup",  		false,  "",      dfNone,    0,     false,    	false);
	 			InitDataProperty(0, cnt++ , dtData,      	170,	    daCenter,  	true,   "regu_img_flg",  				false,  "",      dfNone,    0,     false,    	false);
	 			InitDataProperty(0, cnt++ , dtImageText,    20,	    daCenter,  	true,   "regu_img_flg_popup",  			false,  "",      dfNone,    0,     false,    	false);
	 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   "delt_flg",  			false,  "",      dfNone,    0,     false,    	false);
	 			
	 			InitDataValid(0, "regu_dp_no", vtNumericOnly); // 숫자, '.'만 입력
	 			ImageList(0) = "img/btns_search.gif";
                ImageList(1) = "img/btns_search.gif";
                
                WordWrap = true;
	 		}
     }

     // Sheet관련 프로세스 처리
     function doActionIBSheet1(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         
         	case IBSEARCH:      //조회
        		formObj.f_cmd.value = SEARCH;
        	   	sheetObj.DoSearch("VOP_SCG_0103_01GS.do", FormQueryString(formObj));
        	   	break;
			
			case IBSAVE:        //저장
        		formObj.f_cmd.value = MULTI;
			    var saveStr = "&"+sheetObj.GetSaveString(false, true, "ibflag");
			    if(saveStr != "&"){
					var sXml = sheetObj.GetSaveXml("VOP_SCG_0103_01GS.do", "f_cmd="+formObj.f_cmd.value+saveStr, false);
					sheetObj.LoadSaveXml(sXml);
					return true;
			    }else{
			    	return false;
			    }
				break;
			
         }
     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 if (sAction == IBSAVE) {
  			var dupRow = sheetObj.ColValueDupRows("usr_id", false, true);
 			if(dupRow != "") {
				ComShowCodeMessage('SCG50005', 'Data');
				if (sheetObj.RowStatus(dupRow.split("|")[0])=="R") {
					sheetObj.SelectCell(dupRow.split("|")[1], 2);
				}else{
					sheetObj.SelectCell(dupRow.split("|")[0], 2);					
				}
				return;
 			}    		 
    	 }
         return true;
     }
      
     function t1sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	 with(sheetObj){
    		 for(var i = 1; i <= LastRow; i++){
//    			sheetObjects[0].CellImage(i,"regu_pkg_cd_flg_popup") = 1;
// 				sheetObjects[0].CellImage(i,"regu_pkg_ibc_flg_popup") = 1;
 				sheetObjects[0].CellImage(i,"regu_pkg_org_flg_popup") = 1;
 				sheetObjects[0].CellImage(i,"regu_pkg_mzd_flg_popup") = 1;
 				sheetObjects[0].CellImage(i,"regu_img_flg_popup") = 1;
    		 }
    	 }
     }
     
     /**
      * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
      * @param {sheetObj} String : 해당 IBSheet셀
      * @param {Row} Long : 해당 셀의 Row Index
      * @param {Col} Long : 해당 셀의 Column Index
      * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
      * @param {CellX} Long : 해당셀의 X좌표
      * @param {CellY} Long : 해당셀의 Y좌표
      * @param {CellW} Long : 해당셀의 가로 넓이값
      * @param {CellH} Long : 해당셀의 세로 높이값
      */
     function t1sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
    	 var param = "?imdg_pck_instr_cd="+document.form.imdg_pck_instr_cd.value+"&imdg_pck_instr_seq="+document.form.imdg_pck_instr_seq.value+"&regu_dp_no="+sheetObj.CellValue(Row, "regu_dp_no");
    	 with(sheetObj){
    		 if(ColSaveName(Col).indexOf("_popup") != -1 && CellValue(Row, "ibflag") == "I"){
    			 if(!ComShowCodeConfirm('SCG50037', 'data')) return;
    			 doActionIBSheet1(sheetObjects[0],document.form,IBSAVE);
    		 }else if(ColSaveName(Col) == "regu_mn_desc"){
    			 sheetObj.CellEditable(Row, Col) = false;
    			 ComShowMemoPad(sheetObj, Row, Col, false, 300, 150);
    			 sheetObj.CellEditable(Row, Col) = true;
    		 }else{
				 if(ColSaveName(Col) == "regu_pkg_cd_flg_popup"){
					 ComOpenWindowCenter("/hanjin/VOP_SCG_0104.do"+param, "VOP_SCG_0104", 500, 450, true);
				 }else if(ColSaveName(Col) == "regu_pkg_ibc_flg_popup"){
					 ComOpenWindowCenter("/hanjin/VOP_SCG_0105.do"+param, "VOP_SCG_0105", 500, 450, true);
				 }else if(ColSaveName(Col) == "regu_pkg_org_flg_popup"){
					 ComOpenWindowCenter("/hanjin/VOP_SCG_0106.do"+param, "VOP_SCG_0106", 880, 500, true);
				 }else if(ColSaveName(Col) == "regu_pkg_mzd_flg_popup"){
					 ComOpenWindowCenter("/hanjin/VOP_SCG_0107.do"+param, "VOP_SCG_0107", 700, 700, true);
				 }else if(ColSaveName(Col) == "regu_img_flg_popup"){
					 ComOpenWindowCenter("/hanjin/VOP_SCG_0108.do"+param, "VOP_SCG_0108", 500, 450, true);
				 }
    		 }
    	 }
     }

	/* 개발자 작업  끝 */