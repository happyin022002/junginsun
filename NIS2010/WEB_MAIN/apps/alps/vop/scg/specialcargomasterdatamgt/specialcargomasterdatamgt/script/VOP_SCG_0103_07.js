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

var prefix4 = "t1_";
var prefix5 = "t23_";
var prefix6 = "t50_";

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick7(srcName){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		/*******************************************************/
		var formObj = document.form;

     	try {
     		switch(srcName) {
     		
     		case "btn7_1_Row_Add":
				var row = sheetObjects[11].DataInsert(-1);
				sheetObjects[11].SelectCell(row, 5);
				sheetObjects[11].CellValue2(row, prefix4+"imdg_pck_instr_cd") = "TNK00";
				sheetObjects[11].CellValue2(row, prefix4+"imdg_pck_instr_seq") = 0;
				sheetObjects[11].CellValue2(row, prefix4+"pck_ref_cd") = "TNK";
				break;

			case "btn7_1_RowCopy":
				var row = sheetObjects[11].DataCopy();
				sheetObjects[11].SelectCell(row, 5);
				sheetObjects[11].CellValue2(row, prefix4+"ibflag") = "I"
				break;
				
 			case "btn7_1_Row_Delete":
				ComRowHideDelete(sheetObjects[11], prefix4+"del_chk");
				break;
				
 			case "btn7_2_Row_Add":
				var row = sheetObjects[12].DataInsert(-1);
				sheetObjects[12].SelectCell(row, 6);
				sheetObjects[12].CellValue2(row, prefix5+"imdg_pck_instr_cd") = "TNK00";
				sheetObjects[12].CellValue2(row, prefix5+"imdg_pck_instr_seq") = 0;
				sheetObjects[12].CellValue2(row, prefix5+"ptb_tnk_instr_cd") = "T23";
				sheetObjects[12].CellValue2(row, prefix5+"pck_ref_cd") = "TNK";
				break;

			case "btn7_2_RowCopy":
				var row = sheetObjects[12].DataCopy();
				sheetObjects[12].SelectCell(row, 6);
				sheetObjects[12].CellValue2(row, prefix5+"ibflag") = "I"
				break;
				
 			case "btn7_2_Row_Delete":
				ComRowHideDelete(sheetObjects[12], prefix5+"del_chk");
				break;
				
 			case "btn7_3_Row_Add":
				var row = sheetObjects[13].DataInsert(-1);
				sheetObjects[13].SelectCell(row, 6);
				sheetObjects[13].CellValue2(row, prefix6+"imdg_pck_instr_cd") = "TNK00";
				sheetObjects[13].CellValue2(row, prefix6+"imdg_pck_instr_seq") = 0;
				sheetObjects[13].CellValue2(row, prefix6+"ptb_tnk_instr_cd") = "T50";
				sheetObjects[13].CellValue2(row, prefix6+"pck_ref_cd") = "TNK";
				break;

			case "btn7_3_RowCopy":
				var row = sheetObjects[13].DataCopy();
				sheetObjects[13].SelectCell(row, 6);
				sheetObjects[13].CellValue2(row, prefix6+"ibflag") = "I"
				break;
				
 			case "btn7_3_Row_Delete":
				ComRowHideDelete(sheetObjects[13], prefix6+"del_chk");
				break;
				
 			case "btn7_4_Row_Add":
				var row = sheetObjects[14].DataInsert(-1);
				sheetObjects[14].SelectCell(row, 5);
				sheetObjects[14].CellValue2(row, prefix+"imdg_pck_instr_cd") = "TNK00";
				sheetObjects[14].CellValue2(row, prefix+"imdg_pck_instr_seq") = 0;
				sheetObjects[14].CellValue2(row, prefix+"pck_ref_cd") = "TNK";
				break;

			case "btn7_4_RowCopy":
				var row = sheetObjects[14].DataCopy();
				sheetObjects[14].SelectCell(row, 5);
				sheetObjects[14].CellValue2(row, prefix+"ibflag") = "I"
				break;
				
 			case "btn7_4_Row_Delete":
				ComRowHideDelete(sheetObjects[14], prefix+"del_chk");
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
     function initSheet7(sheetObj,sheetNo) {

    	 var cnt = 0;
    	 switch(sheetNo) {
  	 	 case 12:
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
		 			InitColumnInfo(12, 0, 0, true);
	
		 			// 해더에서 처리할 수 있는 각종 기능을 설정한다
		 			InitHeadMode(true, true, false, true, false,false)
	
		 			var HeadTitle = "|||||Chk.|Portable\nTank\nInstruction|Minimum test\npressure|Minimum shell\nthickness\n(mm-reference steel)\n(see 6.7.2.4)|Pressure-relief\nprovisions\n(see 6.7.2.8)*|Bottom opening\nprovisions\n(see 6.7.2.6)**|";

		 			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		 			InitHeadRow(0, HeadTitle, true);

		 			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		 			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	prefix4+"ibflag");
		 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   prefix4+"imdg_pck_instr_cd",  					false,  "",      dfNone,    0,     false,    	false);
		 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   prefix4+"imdg_pck_instr_seq",  				false,  "",      dfNone,    0,     false,    	false);
		 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   prefix4+"pck_ref_cd",  					false,  "",      dfNone,    0,     false,    	false);
		 			InitDataProperty(0, cnt++ , dtHidden,		30,    	daCenter,  	false,	prefix4+"sub_seq");
		 			InitDataProperty(0, cnt++ , dtCheckBox, 	30,    	daCenter,   true,   prefix4+"del_chk",					false,  "",      dfNone,	0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtCombo,   		185,	daCenter,   true,   prefix4+"ptb_tnk_instr_cd", 		true,	"",      dfNone,	0,     false,		true);
		 			InitDataProperty(0, cnt++ , dtData,   		185,    daCenter,   true,   prefix4+"min_tst_prss",			false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtComboEdit,   	185,    daCenter,   true,   prefix4+"min_shl_thck_ctnt",				false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtComboEdit,   	185,    daCenter,   true,   prefix4+"prs_rlf_provi_ctnt",  		false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtComboEdit,  	185,    daCenter,   true,   prefix4+"btm_opn_provi_ctnt",  		false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   prefix4+"delt_flg",  				false,  "",      dfNone,    0,     false,    	false);
		 			
		 			InitDataCombo(0, prefix4+"ptb_tnk_instr_cd", "|T1|T2|T3|T4|T5|T6|T7|T8|T9|T10|T11|T12|T13|T14|T15|T16|T17|T18|T19|T20|T21|T22", "|T1|T2|T3|T4|T5|T6|T7|T8|T9|T10|T11|T12|T13|T14|T15|T16|T17|T18|T19|T20|T21|T22");
		 			InitDataCombo(0, prefix4+"min_shl_thck_ctnt", " |See 6.7.2.4.2", " |6.7.2.4.2");
		 			InitDataCombo(0, prefix4+"prs_rlf_provi_ctnt", " |See 6.7.2.8.3|Normal", " |6.7.2.8.3|N");
		 			InitDataCombo(0, prefix4+"btm_opn_provi_ctnt", " |See 6.7.2.6.2|See 6.7.2.6.3|Not allowed", " |6.7.2.6.2|6.7.2.6.3|P");
		 			InitDataValid(0, prefix4+"min_tst_prss", vtNumericOther, "."); // 숫자, '.'만 입력
		 			
		 			WordWrap = true;
		 		}
	    	 	break;
	    	 	
  	 	case 13:
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
	 			InitColumnInfo(21, 0, 0, true);

	 			// 해더에서 처리할 수 있는 각종 기능을 설정한다
	 			InitHeadMode(true, true, false, true, false,false)

	 			var HeadTitle = "||||||Chk.|UN No.|Substance|Substance|Substance|Minimum test\npressure|Minimum shell\nthickness\n(mm-reference steel)\n(see 6.7.2.4)|Bottom opening\nrequirements|Pressure-relief\nrequirements|Degree of\nfilling|Control\ntemperature|Control\ntemperature|Emergency\ntemperature|Emergency\ntemperature|";

	 			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	 			InitHeadRow(0, HeadTitle, true);

	 			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	 			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	prefix5+"ibflag");
	 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   prefix5+"imdg_pck_instr_cd",  					false,  "",      dfNone,    0,     false,    	false);
	 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   prefix5+"imdg_pck_instr_seq",  				false,  "",      dfNone,    0,     false,    	false);
	 			InitDataProperty(0, cnt++ , dtHidden,		30,    	daCenter,  	false,	prefix5+"ptb_tnk_instr_cd");
	 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   prefix5+"pck_ref_cd",  					false,  "",      dfNone,    0,     false,    	false);
	 			InitDataProperty(0, cnt++ , dtHidden,		30,    	daCenter,  	false,	prefix5+"sub_seq");
	 			InitDataProperty(0, cnt++ , dtCheckBox, 	30,    	daCenter,   true,   prefix5+"del_chk",					false,  "",      dfNone,	0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtData,       	60,		daCenter,   true,   prefix5+"imdg_un_no", 				true,	"",      dfNone,	0,     false,		true,		4);
	 			InitDataProperty(0, cnt++ , dtData,       	80,		daCenter,   true,   prefix5+"prp_shp_nm", 				false,	"",      dfNone,	0,     false,		false);
	 			InitDataProperty(0, cnt++ , dtData,       	100,	daCenter,   true,   prefix5+"sbst_desc", 			false,	"",      dfNone,	0,     false,		true);
	 			InitDataProperty(0, cnt++ , dtData,       	30,		daCenter,   true,   prefix5+"sbst_desc_ref_no", 		false,	"",      dfNone,	0,     false,		true,		4);
	 			InitDataProperty(0, cnt++ , dtData,        	100,    daCenter,   true,   prefix5+"min_tst_prss",			false,  "",      dfNone,    0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtComboEdit,   	130,    daCenter,   true,   prefix5+"min_shl_thck_ctnt",				false,  "",      dfNone,    0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtComboEdit,   	100,    daCenter,   true,   prefix5+"btm_opn_provi_ctnt",  		false,  "",      dfNone,    0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtComboEdit,  	100,    daCenter,   true,   prefix5+"prs_rlf_provi_ctnt",  		false,  "",      dfNone,    0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtComboEdit,   	80,    	daCenter,   true,   prefix5+"fill_dgr_ctnt",  				false,  "",      dfNone,    0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtData,        	50,    	daCenter,   true,   prefix5+"ctrl_tmp",  				false,  "",      dfNone,    0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtData,        	30,    	daCenter,   true,   prefix5+"ctrl_tmp_ref_no",  		false,  "",      dfNone,    0,     true,    	true,		4);
	 			InitDataProperty(0, cnt++ , dtData,        	50,    	daCenter,   true,   prefix5+"imdg_emer_temp",  				false,  "",      dfNone,    0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtData,        	30,    	daCenter,   true,   prefix5+"emer_tmp_ref_no",  		false,  "",      dfNone,    0,     true,    	true,		4);
	 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   prefix5+"delt_flg",  				false,  "",      dfNone,    0,     false,    	false);
	 			
	 			InitDataCombo(0, prefix5+"min_shl_thck_ctnt", " |See 6.7.2.4.2", " |6.7.2.4.2");
	 			InitDataCombo(0, prefix5+"prs_rlf_provi_ctnt", " |See 6.7.2.8.2|See 4.2.1.13.6|See 4.2.1.13.7|See 4.2.1.13.8", " |6.7.2.8.3|4.2.1.13.6|4.2.1.13.7|4.2.1.13.8");
	 			InitDataCombo(0, prefix5+"btm_opn_provi_ctnt", " |See 6.7.2.6.2|See 6.7.2.6.3|Not allowed", " |6.7.2.6.2|6.7.2.6.3|P");
	 			InitDataCombo(0, prefix5+"fill_dgr_ctnt", " |See 4.2.1.13.13|Not allowed", " |4.2.1.13.13|P");
	 			InitDataValid(0, prefix5+"min_tst_prss", vtNumericOther, "."); // 숫자, '.'만 입력
	 			InitDataValid(0, prefix5+"imdg_un_no", vtNumericOnly); // 숫자, '.'만 입력
	 			InitDataValid(0, prefix5+"ctrl_tmp", vtNumericOther, "+-."); // 숫자, '.'만 입력
	 			InitDataValid(0, prefix5+"imdg_emer_temp", vtNumericOther, "+-."); // 숫자, '.'만 입력
	 		}
    	 	break;
    	 	
  	 	case 14:
    	 	with (sheetObj) {

	 			// 높이 설정
	 			style.height = 260;
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
	 			InitColumnInfo(17, 0, 0, true);

	 			// 해더에서 처리할 수 있는 각종 기능을 설정한다
	 			InitHeadMode(true, true, false, true, false,false)

	 			var HeadTitle1 = "||||||Chk.|UN No.|Non-refigerated\nliquefied gases|Maximum allowable\nworking pressure(bar)***|Maximum allowable\nworking pressure(bar)***|Maximum allowable\nworking pressure(bar)***|Maximum allowable\nworking pressure(bar)***|Openings below\nliquid level|Pressure relief\nprovisions\n(see 6.7.3.7)****|Maximum\nfilling density(kg/l)|";
	 			var HeadTitle2 = "||||||Chk.|UN No.|Non-refigerated\nliquefied gases|Small|Bare|Sunshield|Insulated\nrespectively|Openings below\nliquid level|Pressure relief\nprovisions\n(see 6.7.3.7)****|Maximum\nfilling density(kg/l)|";
	 			

	 			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	 			InitHeadRow(0, HeadTitle1, true);
	 			InitHeadRow(1, HeadTitle2, true);

	 			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	 			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	prefix6+"ibflag");
	 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   prefix6+"imdg_pck_instr_cd",  					false,  "",      dfNone,    0,     false,    	false);
	 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   prefix6+"imdg_pck_instr_seq",  				false,  "",      dfNone,    0,     false,    	false);
	 			InitDataProperty(0, cnt++ , dtHidden,		30,    	daCenter,  	false,	prefix6+"ptb_tnk_instr_cd");
	 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   prefix6+"pck_ref_cd",  					false,  "",      dfNone,    0,     false,    	false);
	 			InitDataProperty(0, cnt++ , dtHidden,		30,    	daCenter,  	false,	prefix6+"sub_seq");
	 			InitDataProperty(0, cnt++ , dtCheckBox, 	30,    	daCenter,   true,   prefix6+"del_chk",					false,  "",      dfNone,	0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtData,       	70,		daCenter,   true,   prefix6+"imdg_un_no", 				true,	"",      dfNone,	0,     false,		true,		4);
	 			InitDataProperty(0, cnt++ , dtData,       	150,	daCenter,   true,   prefix6+"prp_shp_nm", 				false,	"",      dfNone,	0,     false,		false);
	 			InitDataProperty(0, cnt++ , dtData,       	80,		daCenter,   true,   prefix6+"max_alw_wrk_sml_prss",		false,	"",      dfNone,	0,     true,		true);
	 			InitDataProperty(0, cnt++ , dtData,       	80,		daCenter,   true,   prefix6+"max_alw_wrk_bare_prss",		false,	"",      dfNone,	0,     true,		true);
	 			InitDataProperty(0, cnt++ , dtData,       	80,		daCenter,   true,   prefix6+"max_alw_wrk_sun_shld_prss",	false,	"",      dfNone,	0,     true,		true);
	 			InitDataProperty(0, cnt++ , dtData,       	80,		daCenter,   true,   prefix6+"max_alw_wrk_inslt_prss",	false,	"",      dfNone,	0,     true,		true);
	 			InitDataProperty(0, cnt++ , dtComboEdit,   	135,	daCenter,   true,   prefix6+"opn_blw_lqd_lvl_cd", 		false,	"",      dfNone,	0,     true,		true);
	 			InitDataProperty(0, cnt++ , dtComboEdit,  	135,   	daRight,   	true,   prefix6+"prs_rlf_provi_ctnt",  		false,  "",      dfNone,    0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtData,  		135,   	daRight,   	true,   prefix6+"max_fill_dnst_ctnt",  			false,  "",      dfNone,    0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   prefix6+"delt_flg",  				false,  "",      dfNone,    0,     false,    	false);
	 			
	 			InitDataCombo(0, prefix6+"opn_blw_lqd_lvl_cd", "|Allowed|Not Allowed", "|A|P");
	 			InitDataCombo(0, prefix6+"prs_rlf_provi_ctnt", "|See 6.7.3.7.3|Normal", "|6.7.3.7.3|N");
	 			InitDataValid(0, prefix6+"max_alw_wrk_sml_prss", vtNumericOther, "."); // 숫자, '.'만 입력
	 			InitDataValid(0, prefix6+"max_alw_wrk_bare_prss", vtNumericOther, "."); // 숫자, '.'만 입력
	 			InitDataValid(0, prefix6+"max_alw_wrk_sun_shld_prss", vtNumericOther, "."); // 숫자, '.'만 입력
	 			InitDataValid(0, prefix6+"max_alw_wrk_inslt_prss", vtNumericOther, "."); // 숫자, '.'만 입력
	 			InitDataValid(0, prefix6+"max_fill_dnst_ctnt", vtNumericOther, "."); // 숫자, '.'만 입력
	 			InitDataValid(0, prefix6+"imdg_un_no", vtNumericOnly); // 숫자, '.'만 입력
	 		}
    	 	break;
	    	 	
  	 	case 15:
    	 	with (sheetObj) {
    	 		
	 			// 높이 설정
	 			style.height = 200;
	 			//전체 너비 설정
	 			SheetWidth = mainTable.clientWidth;

	 			//Host정보 설정[필수][HostIp, Port, PagePath]
	 			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	 			//전체Merge 종류 [선택, Default msNone]
	 			MergeSheet = msNone;

	 			//전체Edit 허용 여부 [선택, Default false]
	 			Editable = true;

	 			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	 			InitRowInfo( 1, 1, 3, 100);

	 			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	 			InitColumnInfo(8, 0, 0, true);

	 			// 해더에서 처리할 수 있는 각종 기능을 설정한다
	 			InitHeadMode(true, true, false, true, false,false)

	 			var HeadTitle = "|||||Chk.|Ref. No.|Description|";

	 			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	 			InitHeadRow(0, HeadTitle, true);

	 			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	 			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	prefix+"ibflag");
	 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   prefix+"imdg_pck_instr_cd",  			false,  "",      dfNone,    0,     false,    	false);
	 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   prefix+"imdg_pck_instr_seq",  		false,  "",      dfNone,    0,     false,    	false);
	 			InitDataProperty(0, cnt++ , dtHidden,		30,    	daCenter,  	false,	prefix+"pck_ref_cd");
	 			InitDataProperty(0, cnt++ , dtCheckBox, 	30,    	daCenter,   true,   prefix+"del_chk",			false,  "",      dfNone,	0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtData,        	80,		daCenter,   true,   prefix+"ref_div_no", 			true,	"",      dfNone,	0,     false,		true,		4);
	 			InitDataProperty(0, cnt++ , dtData,        	80,		daLeft,   	true,   prefix+"ref_desc", 			true,	"",      dfNone,	0,     true,		true,		500);
	 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   prefix+"delt_flg",  		false,  "",      dfNone,    0,     false,    	false);
	 		}
    	 	break;
    	 }
     }

     // Sheet관련 프로세스 처리
     function doActionIBSheet7(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         
         case IBSEARCH:      //조회
	 		formObj.f_cmd.value = SEARCH;
      		var aryPrefix = new Array( prefix4,prefix5,prefix6,prefix);                
	 	   	var sXml = sheetObj.GetSearchXml("VOP_SCG_0103_07GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam( aryPrefix ));
	 	   	var arrXml = sXml.split("|$$|");
	 	    sheetObjects[11].LoadSearchXml(arrXml[0]);
	 	    sheetObjects[12].LoadSearchXml(arrXml[1]);
	 	    sheetObjects[13].LoadSearchXml(arrXml[2]);
	 	    sheetObjects[14].LoadSearchXml(arrXml[3]);
	 	   	break;
		
		case IBSAVE:        //저장
			formObj.f_cmd.value = MULTI;
		    var saveStr = "&"+sheetObjects[11].GetSaveString(false, true, prefix4+"ibflag");
		    saveStr += "&"+sheetObjects[12].GetSaveString(false, true, prefix5+"ibflag");
		    saveStr += "&"+sheetObjects[13].GetSaveString(false, true, prefix6+"ibflag");
		    saveStr += "&"+sheetObjects[14].GetSaveString(false, true, prefix+"ibflag");
		    if(saveStr != "&&&&"){
				var sXml = sheetObj.GetSaveXml("VOP_SCG_0103_07GS.do", "f_cmd="+formObj.f_cmd.value+saveStr, false);
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

	/* 개발자 작업  끝 */