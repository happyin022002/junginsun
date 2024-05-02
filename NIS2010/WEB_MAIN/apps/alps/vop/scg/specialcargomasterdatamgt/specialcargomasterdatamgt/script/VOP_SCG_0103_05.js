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
	function processButtonClick5(srcName){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		/*******************************************************/
		var formObj = document.form;

     	try {
     		switch(srcName) {
     		
     		case "btn5_1_Row_Add":
				var row = sheetObjects[7].DataInsert(-1);
				sheetObjects[7].SelectCell(row, 4);
				sheetObjects[7].CellValue2(row, "imdg_pck_instr_cd") = formObj.imdg_pck_instr_cd.value;
				sheetObjects[7].CellValue2(row, "imdg_pck_instr_seq") = formObj.imdg_pck_instr_seq.value;
				break;

			case "btn5_1_RowCopy":
				var row = sheetObjects[7].DataCopy();
				sheetObjects[7].SelectCell(row, 4);
				sheetObjects[7].CellValue2(row, "ibflag") = "I";
				break;
				
 			case "btn5_1_Row_Delete":
				ComRowHideDelete(sheetObjects[7], "del_chk");
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
     function initSheet5(sheetObj,sheetNo) {

    	 var cnt = 0;
    	 switch(sheetNo) {
  	 	 case 8:
	    	 	with (sheetObj) {
	
		 			// 높이 설정
		 			style.height = 400;
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
		 			InitColumnInfo(34, 0, 0, true);
	
		 			// 해더에서 처리할 수 있는 각종 기능을 설정한다
		 			InitHeadMode(true, true, false, true, false,false)
	
		 			var HeadTitle1 = "||||Chk.|SPP|Div|Prohibit/\nAllow|Condition|Condition|Condition|Condition|Condition|Packing\n Group-I\n Use|Packing Group-I|Packing Group-I|Packing\n Group-II\n Use|Packing Group-II|Packing Group-II|Packing\n Group-III\n Use|Packing Group-III|Packing Group-III|Max.Capa/Net mass|Max.Capa/Net mass|Max.Capa/Net mass|Max.Capa/Net mass|Applicable Rule|Applicable Rule|Applicable Rule|Applicable Rule|Applicable Rule|Applicable Rule|Applicable Rule|";
		 			var HeadTitle2 = "||||Chk.|SPP|Div|Prohibit/\nAllow|Packaging|Type|Material|Code|Name|Packing\n Group-I\n Use|WT|UOM|Packing\n Group-II\n Use|WT|UOM|Packing\n Group-III\n Use|WT|UOM|Use|Min.|Max.|UOM|Criteria|Packaging|Type|Material|Code|Name|Referable Text|";

		 			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		 			InitHeadRow(0, HeadTitle1, true);
		 			InitHeadRow(1, HeadTitle2, true);

		 			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		 			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	"ibflag");
		 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   "imdg_pck_instr_cd",  				false,  "",      dfNone,    0,     false,    	false);
		 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   "imdg_pck_instr_seq",  			false,  "",      dfNone,    0,     false,    	false);
		 			InitDataProperty(0, cnt++ , dtHidden,		30,    	daCenter,  	false,	"sub_seq");
		 			InitDataProperty(0, cnt++ , dtCheckBox, 	30,    	daCenter,   true,   "del_chk",				false,  "",      dfNone,	0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtPopupEdit,   	50,		daCenter,   true,   "spcl_pck_provi_cd", 				true,	"",      dfNone,	0,     false,		true);
//		 			InitDataProperty(0, cnt++ , dtPopupEdit,   	60,    	daCenter,	true,   "spp_sub_cd",  			false,  "",      dfNone,    0,     false,    	true);
		 			InitDataProperty(0, cnt++ , dtCombo,      	80,	    daCenter,  	true,   "spcl_pck_provi_div_cd",	  			false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtCombo,      	60,	    daCenter,  	true,   "prmt_chk_cd",	  		false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtCombo,      	50,	    daCenter,  	true,   "cond_pck_sty_cd",		false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtCombo,       	80,		daCenter,   true,   "cond_pck_tp_cd", 		false,	"",      dfNone,	0,     true,		true);
		 			InitDataProperty(0, cnt++ , dtCombo,       	80,		daCenter,   true,   "cond_pck_mtrl_tp_cd", 	false,	"",      dfNone,	0,     true,		true);
		 			InitDataProperty(0, cnt++ , dtCombo,       	70,    	daCenter,	true,   "cond_pck_cd",  		false, 	"",      dfNone,    0,     true,    	true,		5);
		 			InitDataProperty(0, cnt++ , dtData,      	200,	daCenter,  	true,   "cond_pck_cd_desc",  		false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtCombo,      	60,	    daCenter,  	true,   "grp_n1st_use_flg",		false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtHidden,      	80,	    daRight,  	true,   "grp_n1st_qty",			false,  "",      dfNone,    2,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   "grp_n1st_meas_ut_cd",  		false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtCombo,      	60,	    daCenter,  	true,   "grp_n2nd_use_flg",		false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtHidden,      	80,	    daRight,  	true,   "grp_n2nd_qty",			false,  "",      dfNone,    2,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   "grp_n2nd_meas_ut_cd",  		false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtCombo,      	60,	    daCenter,  	true,   "grp_n3rd_use_flg",		false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtHidden,      	80,	    daRight,  	true,   "grp_n3rd_qty",			false,  "",      dfNone,    2,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   "grp_n3rd_meas_ut_cd",  	false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtCombo,      	30,	    daCenter,  	true,   "capa_mass_use_flg",	false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtData,      	80,	    daRight,  	true,   "capa_mass_min_qty",  	false,  "",      dfNone,    2,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtData,      	80,	    daRight,  	true,   "capa_mass_max_qty",  	false,  "",      dfNone,    2,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtCombo,      	30,	    daCenter,  	true,   "capa_mass_meas_ut_cd",  	false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtCombo,      	50,	    daCenter,  	true,   "rule_aply_tp_cd",		false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtCombo,      	80,	    daCenter,  	true,   "pck_sty_cd",			false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtCombo,       	80,		daCenter,   true,   "pck_tp_cd", 			false,	"",      dfNone,	0,     true,		true);
		 			InitDataProperty(0, cnt++ , dtCombo,       	80,		daCenter,   true,   "pck_mtrl_tp_cd", 		false,	"",      dfNone,	0,     true,		true);
		 			InitDataProperty(0, cnt++ , dtCombo,       	70,    	daCenter,	true,   "imdg_pck_cd",  				false, 	"",      dfNone,    0,     true,    	true,		5);
		 			InitDataProperty(0, cnt++ , dtData,      	200,	daCenter,  	true,   "spcl_pck_desc",  				false,  "",      dfNone,    0,     true,    	true);
//		 			InitDataProperty(0, cnt++ , dtData,      	80,	    daCenter,  	true,   "rule_prd",  			false,  "",      dfNone,    0,     true,    	true,		4);
//		 			InitDataProperty(0, cnt++ , dtCombo,      	50,	    daCenter,  	true,   "rule_prd_meas_ut",		false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtData,      	300,    daLeft,  	true,   "spcl_pck_provi_desc",  			false,  "",      dfNone,    0,     true,    	true);
		 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   "delt_flg",  			false,  "",      dfNone,    0,     false,    	false);
		 			InitDataCombo(0, "spcl_pck_provi_div_cd", " |Weight/Capa|Pack.Class|PKG Code", " |W|C|P");
		 			InitDataCombo(0, "prmt_chk_cd", " |Allow|Prohibit|Not Required|Must", " |A|P|N|M");
		 			InitDataCombo(0, "pck_sty_cd", " |Inner|Intermediate|Outer|Combine|Single", " |I|M|O|C|S");
		 			InitDataCombo(0, "grp_n1st_use_flg", "|N|Y", "|N|Y");
		 			InitDataCombo(0, "grp_n2nd_use_flg", "|N|Y", "|N|Y");
		 			InitDataCombo(0, "grp_n3rd_use_flg", "|N|Y", "|N|Y");
		 			InitDataCombo(0, "capa_mass_use_flg", "|N|Y", "|N|Y");
		 			InitDataCombo(0, "rule_aply_tp_cd", "|Refer Text|Full Valid|Partial Valid", "|R|F|P");
//		 			InitDataCombo(0, "rule_prd_meas_ut", " |Year|Month|Week|Day", "|Y|M|W|D");
		 			InitDataCombo(0, "cond_pck_sty_cd", " |Inner|Intermediate|Outer|Combine|Single", " |I|M|O|C|S");
		 			
		 			InitDataValid(0, "spcl_pck_provi_cd", vtEngUpOther, "0123456789"); // 영대문자,숫자만 입력
		 			InitDataValid(0, "grp_n1st_qty", vtNumericOther, "."); // 숫자만 입력
		 			InitDataValid(0, "grp_n2nd_qty", vtNumericOther, "."); // 숫자만 입력
		 			InitDataValid(0, "grp_n2nd_qty", vtNumericOther, "."); // 숫자만 입력
		 			
		 			WordWrap = true;
		 		}
	    	 	break;
    	 }
     }

     // Sheet관련 프로세스 처리
     function doActionIBSheet5(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         
         case IBSEARCH:      //조회
	 		formObj.f_cmd.value = SEARCH;
	 	   	sheetObj.DoSearch("VOP_SCG_0103_05GS.do", FormQueryString(formObj));
	 	   	break;
		
		case IBSAVE:        //저장
 			formObj.f_cmd.value = MULTI;
		    var saveStr = "&"+sheetObj.GetSaveString(false, true, "ibflag");
		    if(saveStr != "&"){
				var sXml = sheetObj.GetSaveXml("VOP_SCG_0103_05GS.do", "f_cmd="+formObj.f_cmd.value+saveStr, false);
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
       * Sheet1 OnPopupClick 이벤트 처리  
       * @param sheetObj
       * @param Row
       * @param Col
       * @return
       */
      function t5sheet1_OnPopupClick(sheetObj, Row, Col)
    	{
    		with(sheetObj)
    		{
    		    if( sheetObj.ColSaveName(Col) == "spcl_pck_provi_cd" ){
    		        var imdg_pck_instr_cd = "";
    		        if(document.form.pck_div_cd_radio[0].checked == true){
    		        	imdg_pck_instr_cd = "PP";
    		        }else if(document.form.pck_div_cd_radio[1].checked == true){
    		        	imdg_pck_instr_cd = "B";
    				}else if(document.form.pck_div_cd_radio[2].checked == true){
    					imdg_pck_instr_cd = "L";
    				}
    				ComOpenPopup('/hanjin/VOP_SCG_0060Pop.do?imdg_pck_instr_cd='+imdg_pck_instr_cd, 1025, 693, "setT5sheet1_PopupCallback_SppCd", "0,1,0,1,1,1", true, false, Row, Col, 1);
    		    }
     		}
     	}
       
       function t5sheet1_OnChange(sheetObj, Row, Col)
	  	{
	  		with(sheetObj)
	  		{
	  			if( sheetObj.ColSaveName(Col) == "pck_tp_cd" || sheetObj.ColSaveName(Col) == "pck_mtrl_tp_cd" || sheetObj.ColSaveName(Col) == "pck_sty_cd"){
		   			var sXml = sheetObj.GetSearchXml("VOP_SCG_0103_02GS.do?f_cmd="+SEARCH02+"&pck_tp_cd="+CellValue(Row, "pck_tp_cd")+"&pck_mtrl_tp_cd="+CellValue(Row, "pck_mtrl_tp_cd")+"&pck_sty_cd="+CellValue(Row, "pck_sty_cd"));
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
	  		    if( sheetObj.ColSaveName(Col) == "cond_pck_tp_cd" || sheetObj.ColSaveName(Col) == "cond_pck_mtrl_tp_cd" || sheetObj.ColSaveName(Col) == "cond_pck_sty_cd"){
		   			var sXml = sheetObj.GetSearchXml("VOP_SCG_0103_02GS.do?f_cmd="+SEARCH02+"&pck_tp_cd="+CellValue(Row, "cond_pck_tp_cd")+"&pck_mtrl_tp_cd="+CellValue(Row, "cond_pck_mtrl_tp_cd")+"&pck_sty_cd="+CellValue(Row, "cond_pck_sty_cd"));
		   			if(ComGetTotalRows(sXml) > 0){
		   				ComSetIBCombo(sheetObj, sXml, "cond_pck_cd", true );
		   			}else{
		   				InitDataCombo(0, "cond_pck_cd", "", ""); 
		   			}
		   			CellValue(Row, "cond_pck_cd") = "";
	  		    }
	  		    if( sheetObj.ColSaveName(Col) == "cond_pck_cd"){
		   			var sXml = sheetObj.GetSearchXml("VOP_SCG_0103_02GS.do?f_cmd="+SEARCH03+"&imdg_pck_cd="+CellValue(Row, "cond_pck_cd"));
		   			
		   			CellValue(Row, "cond_pck_cd_desc") =  ComGetEtcData(sXml, "SPCL_PCK_DESC");
	  		    }
	   		}
	   	}
       
	   /**
	    * Sheet1 OnPopupClick 이벤트 처리에 대한 CallBack 함수 
	    * @param aryPopupData
	    * @param row
	    * @param col
	    * @param seetIdx 
	    * @return
	    */
	   function setT5sheet1_PopupCallback_SppCd(aryPopupData,row, col, seetIdx){
	    	sheetObjects[7].CellValue2(row, "spcl_pck_provi_cd") = aryPopupData[0][5];
//	    	sheetObjects[7].CellValue2(row, "spp_sub_cd") = aryPopupData[0][4];
	    	sheetObjects[7].CellValue2(row, "spcl_pck_provi_desc") = aryPopupData[0][8];
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
     function t5sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
    	 with(sheetObj){
    		 if(ColSaveName(Col) == "spcl_pck_provi_desc"){
    			 sheetObj.CellEditable(Row, Col) = false;
    			 ComShowMemoPad(sheetObj, Row, Col, false, 300, 150);
    			 sheetObj.CellEditable(Row, Col) = true;
    		 }
    	 }
     }
	/* 개발자 작업  끝 */