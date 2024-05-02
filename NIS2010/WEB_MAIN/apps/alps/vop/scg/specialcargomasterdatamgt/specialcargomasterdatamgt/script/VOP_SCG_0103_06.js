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
	function processButtonClick6(srcName){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		/*******************************************************/
		var formObj = document.form;

     	try {
     		switch(srcName) {
     		
     		case "btn6_1_Row_Add":
				var row = sheetObjects[8].DataInsert(-1);
				sheetObjects[8].SelectCell(row, 5);
				sheetObjects[8].CellValue2(row, "imdg_pck_instr_cd") = formObj.imdg_pck_instr_cd.value;
				sheetObjects[8].CellValue2(row, "imdg_pck_instr_seq") = formObj.imdg_pck_instr_seq.value;
				sheetObjects[8].CellValue2(row, "pck_ref_cd") = "GAS";
				break;

			case "btn6_1_RowCopy":
				var row = sheetObjects[8].DataCopy();
				sheetObjects[8].SelectCell(row, 5);
				sheetObjects[8].CellValue2(row, "ibflag") = "I"
				break;
				
 			case "btn6_1_Row_Delete":
				ComRowHideDelete(sheetObjects[8], "del_chk");
				break;
				
 			case "btn6_2_Row_Add":
				var row = sheetObjects[9].DataInsert(-1);
				sheetObjects[9].SelectCell(row, 5);
				sheetObjects[9].CellValue2(row, prefix+"imdg_pck_instr_cd") = formObj.imdg_pck_instr_cd.value;
				sheetObjects[9].CellValue2(row, prefix+"imdg_pck_instr_seq") = formObj.imdg_pck_instr_seq.value;
				sheetObjects[9].CellValue2(row, prefix+"pck_ref_cd") = "GAS";
				break;

			case "btn6_2_RowCopy":
				var row = sheetObjects[9].DataCopy();
				sheetObjects[9].SelectCell(row, 5);
				sheetObjects[9].CellValue2(row, prefix+"ibflag") = "I"
				break;
				
 			case "btn6_2_Row_Delete":
				ComRowHideDelete(sheetObjects[9], prefix+"del_chk");
				break;
				
 			case "btn6_3_Row_Add":
				var row = sheetObjects[10].DataInsert(-1);
				sheetObjects[10].SelectCell(row, 5);
				sheetObjects[10].CellValue2(row, prefix+"imdg_pck_instr_cd") = formObj.imdg_pck_instr_cd.value;
				sheetObjects[10].CellValue2(row, prefix+"imdg_pck_instr_seq") = formObj.imdg_pck_instr_seq.value;
				sheetObjects[10].CellValue2(row, prefix+"pck_ref_cd") = "GAS";
				break;

			case "btn6_3_RowCopy":
				var row = sheetObjects[10].DataCopy();
				sheetObjects[10].SelectCell(row, 5);
				sheetObjects[10].CellValue2(row, prefix+"ibflag") = "I"
				break;
				
 			case "btn6_3_Row_Delete":
				ComRowHideDelete(sheetObjects[10], prefix+"del_chk");
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
     function initSheet6(sheetObj,sheetNo) {

    	 var cnt = 0;
    	 switch(sheetNo) {
  	 	 case 9:
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
		 			InitColumnInfo(24, 0, 0, true);
	
		 			// 해더에서 처리할 수 있는 각종 기능을 설정한다
		 			InitHeadMode(true, true, false, true, false,false)
	
		 			var HeadTitle = "||||Chk.|Table No.|UN No.|PSN|LC50_VAL ml/㎥|Cylinders|Tubes|Pressure\ndrums|Bundles of\ncylinders|MEGCs|Test period\n(years)|Test pressure\n(bar)*|Maximum working\npressure(bar)**|Filling\nratio|Ref. No.|Special packing\nProvisions Ref. No.|Special packing\nProvisions Ref. No.|Special packing\nProvisions Ref. No.|Special packing\nProvisions Ref. No.|";

		 			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		 			InitHeadRow(0, HeadTitle, true);

		 			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		 			InitDataProperty(0, cnt++ , dtHiddenStatus,	0,    	daCenter,  	false,	"ibflag");
		 			InitDataProperty(0, cnt++ , dtHidden,      	0,	    daCenter,  	true,   "imdg_pck_instr_cd",  		false,  "",      dfNone,    0,     false,    	false);
		 			InitDataProperty(0, cnt++ , dtHidden,      	0,	    daCenter,  	true,   "imdg_pck_instr_seq",  		false,  "",      dfNone,    0,     false,    	false);
		 			InitDataProperty(0, cnt++ , dtHidden,      	0,	    daCenter,  	true,   "pck_ref_cd",  				false,  "",      dfNone,    0,     false,    	false);
		 			InitDataProperty(0, cnt++ , dtCheckBox, 	30,    	daCenter,   true,   "del_chk",					false,  "",      dfNone,	0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtCombo,       	70,		daCenter,   true,   "gas_tp_cd", 				true,	"",      dfNone,	0,     false,		true);
		 			InitDataProperty(0, cnt++ , dtData,        	70,    	daCenter,  	true,   "imdg_un_no",				true,  	"",      dfNone,    0,     false,    	true,		4);
		 			InitDataProperty(0, cnt++ , dtData,        	100,    daLeft,   	true,   "prp_shp_nm",  				false,  "",      dfNone,    0,     false,    	false);
		 			InitDataProperty(0, cnt++ , dtData,        	70,    	daCenter,  	true,   "lc50_val",  					false,  "",      dfNone,    2,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtCheckBox,     70,	    daCenter,  	true,   "clnd_chk_flg", 				false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtCheckBox,     70,	    daCenter,  	true,   "tub_chk_flg", 					false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtCheckBox,     70,	    daCenter,  	true,   "prss_drm_chk_flg", 			false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtCheckBox,     70,	    daCenter,  	true,   "clnd_bdl_chk_flg", 			false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtCheckBox,     70,	    daCenter,  	true,   "megc_chk_flg", 			false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtData,      	70,	    daCenter,  	true,   "tst_prd_yr",				false,  "",      dfNone,    0,     true,    	true,		4);
		 			InitDataProperty(0, cnt++ , dtData,      	90,    daCenter,  	true,   "tst_prss",  				false,  "",      dfNone,    2,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtData,      	110,    daCenter,  	true,   "max_wrk_prss",  			false,  "",      dfNone,    2,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtData,      	80,	    daCenter,  	true,   "gas_fill_rto",  			false,  "",      dfNone,    3,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtHidden,      	0,	    daCenter,  	true,   "ref_div_no",  				false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtData,      	50,	    daCenter,  	true,   "gas_spcl_pck_provi_n1st_ctnt",	false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtData,      	50,	    daCenter,  	true,   "gas_spcl_pck_provi_n2nd_ctnt",	false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtData,      	50,	    daCenter,  	true,   "gas_spcl_pck_provi_n3rd_ctnt",	false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtData,      	20,	    daCenter,  	true,   "gas_spcl_pck_provi_n4th_ctnt",	false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtHidden,      	0,	    daCenter,  	true,   "delt_flg",  				false,  "",      dfNone,    0,     false,    	false);
		 			InitDataCombo(0, "gas_tp_cd", "TB1|TB2|TB3", "1|2|3");  
		 			
		 			InitDataValid(0, "imdg_un_no", vtNumericOnly); // 숫자, '.'만 입력
		 			InitDataValid(0, "lc50_val", vtNumericOther, "."); // 숫자, '.'만 입력
		 			InitDataValid(0, "tst_prd_yr", vtNumericOnly); // 숫자만 입력
		 			InitDataValid(0, "tst_prss", vtNumericOther, "."); // 숫자, '.'만 입력
		 			InitDataValid(0, "max_wrk_prss", vtNumericOther, "."); // 숫자, '.'만 입력
		 			InitDataValid(0, "gas_fill_rto", vtNumericOther, "."); // 숫자, '.'만 입력
		 			
		 			WordWrap = true;
		 		}
	    	 	break;
	    	 	
  	 	case 10:
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

	 			var HeadTitle = "||||Chk.|Ref. No.|Description|";

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
    	 	
  	 	case 11:
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

	 			var HeadTitle = "||||Chk.|Ref. No.|Description|";

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
     function doActionIBSheet6(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         
         case IBSEARCH:      //조회
	 		formObj.f_cmd.value = SEARCH;
   			var aryPrefix = new Array( "",prefix,prefix);                
	 	   	var sXml = sheetObj.GetSearchXml("VOP_SCG_0103_06GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam( aryPrefix ));
	 	   	var arrXml = sXml.split("|$$|");
	 	    sheetObjects[8].LoadSearchXml(arrXml[0]);
	 	    sheetObjects[9].LoadSearchXml(arrXml[1]);
	 	    sheetObjects[10].LoadSearchXml(arrXml[2]);
	 	   	break;
		
		case IBSAVE:        //저장
			formObj.f_cmd.value = MULTI;
		    var saveStr = "&"+sheetObjects[8].GetSaveString(false, true, "ibflag");
		    saveStr += "&"+sheetObjects[9].GetSaveString(false, true, prefix+"ibflag");
		    saveStr += "&"+sheetObjects[10].GetSaveString(false, true, prefix+"ibflag");
		    if(saveStr != "&&&"){
				var sXml = sheetObj.GetSaveXml("VOP_SCG_0103_06GS.do", "f_cmd="+formObj.f_cmd.value+saveStr, false);
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
      function t6sheet3_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
     	 with(sheetObj){
     		 if(ColSaveName(Col) == prefix+"ref_desc"){
     			 sheetObj.CellEditable(Row, Col) = false;
     			 ComShowMemoPad(sheetObj, Row, Col, false, 300, 150);
     			 sheetObj.CellEditable(Row, Col) = true;
     		 }
     	 }
      }

	/* 개발자 작업  끝 */