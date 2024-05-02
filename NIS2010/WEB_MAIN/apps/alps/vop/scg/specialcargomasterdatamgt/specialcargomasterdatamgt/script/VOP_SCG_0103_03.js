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
	function processButtonClick3(srcName){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		/*******************************************************/
		var formObj = document.form;

     	try {
     		switch(srcName) {
     		
     		case "btn3_1_Row_Add":
				var row = sheetObjects[5].DataInsert(-1);
				sheetObjects[5].SelectCell(row, 7);
				sheetObjects[5].CellValue2(row, "imdg_pck_instr_cd") = formObj.imdg_pck_instr_cd.value;
				sheetObjects[5].CellValue2(row, "imdg_pck_instr_seq") = formObj.imdg_pck_instr_seq.value;
				sheetObjects[5].CellValue2(row, "pck_sty_cd") = "S";
				sheetObjects[5].CellValue2(row, "pck_ref_cd") = "PKG";
				break;

			case "btn3_1_RowCopy":
				var row = sheetObjects[5].DataCopy();
				sheetObjects[5].SelectCell(row, 7);
				sheetObjects[5].CellValue2(row, "ibflag") = "I"
				break;
				
 			case "btn3_1_Row_Delete":
				ComRowHideDelete(sheetObjects[5], "del_chk");
				break;
				
 			case "btn3_2_Row_Add":
				var row = sheetObjects[6].DataInsert(-1);
				sheetObjects[6].SelectCell(row, 5);
				sheetObjects[6].CellValue2(row, prefix+"imdg_pck_instr_cd") = formObj.imdg_pck_instr_cd.value;
				sheetObjects[6].CellValue2(row, prefix+"imdg_pck_instr_seq") = formObj.imdg_pck_instr_seq.value;
				sheetObjects[6].CellValue2(row, prefix+"pck_ref_cd") = "PKG";
				break;

			case "btn3_2_RowCopy":
				var row = sheetObjects[6].DataCopy();
				sheetObjects[6].SelectCell(row, 5);
				sheetObjects[6].CellValue2(row, prefix+"ibflag") = "I"
				break;
				
 			case "btn3_2_Row_Delete":
				ComRowHideDelete(sheetObjects[6], prefix+"del_chk");
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
     function initSheet3(sheetObj,sheetNo) {

    	 var cnt = 0;
    	 switch(sheetNo) {
  	 	 case 6:
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
		 			InitRowInfo( 2, 1, 3, 100);
	
		 			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		 			InitColumnInfo(22, 0, 0, true);
	
		 			// 해더에서 처리할 수 있는 각종 기능을 설정한다
		 			InitHeadMode(true, true, false, true, false,false)
	
		 			var HeadTitle1 = "||||||Chk.|Type|Material|Code|Name|Ref. No.|Packing Group-I|Packing Group-I|Packing Group-I|Packing Group-II|Packing Group-II|Packing Group-II|Packing Group-III|Packing Group-III|Packing Group-III|Packing Group-III|";
		 			var HeadTitle2 = "||||||Chk.|Type|Material|Code|Name|Ref. No.|Max Capa./Net mass|UOM|Ref. No.|Max Capa./Net mass|UOM|Ref. No.|Max Capa./Net mass|UOM|Ref. No.|";

		 			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		 			InitHeadRow(0, HeadTitle1, true);
		 			InitHeadRow(1, HeadTitle2, true);

		 			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		 			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	"ibflag");
		 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   "imdg_pck_instr_cd",  			false,  "",      dfNone,    0,     false,    	false);
		 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   "imdg_pck_instr_seq",  		false,  "",      dfNone,    0,     false,    	false);
		 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   "pck_ref_cd",  			false,  "",      dfNone,    0,     false,    	false);
		 			InitDataProperty(0, cnt++ , dtHidden,		30,    	daCenter,  	false,	"pck_sty_cd");
		 			InitDataProperty(0, cnt++ , dtHidden,		30,    	daCenter,  	false,	"sub_seq");
		 			InitDataProperty(0, cnt++ , dtCheckBox, 	30,    	daCenter,   true,   "del_chk",			false,  "",      dfNone,	0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtCombo,       	80,		daCenter,   true,   "pck_tp_cd", 		false,	"",      dfNone,	0,     false,		true);
		 			InitDataProperty(0, cnt++ , dtCombo,       	80,		daCenter,   true,   "pck_mtrl_tp_cd", 	false,	"",      dfNone,	0,     false,		true);
		 			InitDataProperty(0, cnt++ , dtCombo,       	70,    	daCenter,	true,   "imdg_pck_cd",  			true, 	"",      dfNone,    0,     false,    	true,		5);
		 			InitDataProperty(0, cnt++ , dtData,      	200,	daLeft,  	true,   "spcl_pck_desc",  			false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtData,      	50,	    daCenter,  	true,   "pck_ref_no",  		false,  "",      dfNone,    0,     true,    	true,		4);
		 			InitDataProperty(0, cnt++ , dtData,      	120,    daRight,  	true,   "grp_n1st_qty",		false,  "",      dfNone,    2,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtCombo,      	50,	    daCenter,  	true,   "grp_n1st_meas_ut_cd",  	false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtData,      	50,	    daCenter,  	true,   "grp_n1st_ref_no",  	false,  "",      dfNone,    0,     true,    	true,		4);
		 			InitDataProperty(0, cnt++ , dtData,      	120,    daRight,  	true,   "grp_n2nd_qty",		false,  "",      dfNone,    2,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtCombo,      	50,	    daCenter,  	true,   "grp_n2nd_meas_ut_cd",  	false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtData,      	50,	    daCenter,  	true,   "grp_n2nd_ref_no",  	false,  "",      dfNone,    0,     true,    	true,		4);
		 			InitDataProperty(0, cnt++ , dtData,      	120,    daRight,  	true,   "grp_n3rd_qty",		false,  "",      dfNone,    2,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtCombo,      	50,	    daCenter,  	true,   "grp_n3rd_meas_ut_cd", 	false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtData,      	50,	    daCenter,  	true,   "grp_n3rd_ref_no",  	false,  "",      dfNone,    0,     true,    	true,		4);
		 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   "delt_flg",  		false,  "",      dfNone,    0,     false,    	false);
		 			
		 			InitDataValid(0, "grp_n1st_qty", vtNumericOther, "."); // 숫자만 입력
		 			InitDataValid(0, "grp_n2nd_qty", vtNumericOther, "."); // 숫자만 입력
		 			InitDataValid(0, "grp_n2nd_qty", vtNumericOther, "."); // 숫자만 입력
		 			
		 			WordWrap = true;
		 		}
	    	 	break;
	    	 	
 	 	case 7:
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
		 			InitDataProperty(0, cnt++ , dtData,        	80,		daLeft,   	true,   prefix+"ref_desc", 			true,	"",      dfNone,	0,     true,		true);
		 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   prefix+"delt_flg",  		false,  "",      dfNone,    0,     false,    	false,		500);
		 			
		 			WordWrap = true;
		 		}
	    	 	break;
    	 }
     }

     // Sheet관련 프로세스 처리
     function doActionIBSheet3(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         
         case IBSEARCH:      //조회
	 		formObj.f_cmd.value = SEARCH;
      		var aryPrefix = new Array( "","scgPckRef_");                
	 	   	var sXml = sheetObj.GetSearchXml("VOP_SCG_0103_03GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam( aryPrefix ));
	 	   	var arrXml = sXml.split("|$$|");
	 	    sheetObjects[5].LoadSearchXml(arrXml[0]);
	 	    sheetObjects[6].LoadSearchXml(arrXml[1]);
	 	   	break;
		
		case IBSAVE:        //저장
			formObj.f_cmd.value = MULTI;
		    var saveStr = "&"+sheetObjects[5].GetSaveString(false, true, "ibflag");
		    saveStr += "&"+sheetObjects[6].GetSaveString(false, true, prefix+"ibflag");

		    if(saveStr != "&&"){
		    	var sXml = sheetObj.GetSaveXml("VOP_SCG_0103_03GS.do", "f_cmd="+formObj.f_cmd.value+saveStr, false);
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
      
      function t3sheet1_OnChange(sheetObj, Row, Col)
	  	{
	  		with(sheetObj)
	  		{
	  			if( sheetObj.ColSaveName(Col) == "pck_tp_cd" || sheetObj.ColSaveName(Col) == "pck_mtrl_tp_cd"){
		   			var sXml = sheetObj.GetSearchXml("VOP_SCG_0103_02GS.do?f_cmd="+SEARCH02+"&pck_tp_cd="+CellValue(Row, "pck_tp_cd")+"&pck_mtrl_tp_cd="+CellValue(Row, "pck_mtrl_tp_cd")+"&pck_sty_cd=O");
		   			if(ComGetTotalRows(sXml) > 0){
		   				ComSetIBCombo(sheetObj, sXml, "imdg_pck_cd", true );
		   			}else{
		   				InitDataCombo(0, "imdg_pck_cd", "", ""); 
		   			}
		   			CellValue(Row, "imdg_pck_cd") = "";
	  		    }
	  		    if( sheetObj.ColSaveName(Col) == "imdg_pck_cd"){
		   			var sXml = sheetObj.GetSearchXml("VOP_SCG_0103_02GS.do?f_cmd="+SEARCH03+"&imdg_pck_cd="+CellValue(Row, "imdg_pck_cd"));
		   			
		   			CellValue(Row, "spcl_pck_desc") =  ComGetEtcData(sXml, "SPCL_PCK_DESC");
	  		    }
	   		}
	   	}

	/* 개발자 작업  끝 */