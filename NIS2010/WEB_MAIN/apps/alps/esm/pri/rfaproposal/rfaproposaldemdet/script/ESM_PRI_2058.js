/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2058.js
*@FileTitle : RFA Proposal Creation [Amend] (DEM&DET)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.18 김재연
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
     * @class ESM_PRI_2058 : ESM_PRI_2058 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2058() {
    	this.processButtonClick		= tprocessButtonClick;
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
    var rtnValue = "N";

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.08.18
     */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];

    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }
    		
    		switch(srcName) {
	    		case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
					
	    		case "btn_save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					break;
					
	    		case "btn_amend":
					doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
					break;
					
				case "btn_amendcancel":
					doActionIBSheet(sheetObjects[0],document.form,COMMAND02);
					break;
					
				case "btn_accept":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY01);
					break;
					
				case "btn_acceptcancel":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY02);
					break;
					
				case "btn_close":
//					window.returnValue = rtnValue;
					self.close();
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
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 김재연
     * @version 2009.08.18
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.08.18
     */
    function loadPage() {
    	 for(i=0;i<sheetObjects.length;i++){
     		//khlee-시작 환경 설정 함수 이름 변경
     		ComConfigSheet (sheetObjects[i] );
 	
     		initSheet(sheetObjects[i],i+1);
     		//khlee-마지막 환경 설정 함수 추가
     		ComEndConfigSheet(sheetObjects[i]);
     	}
    	 
        pageOnLoadFinish(); 
    }
     
    /**
     * body 태그의 unonLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 닫힐때 처리해야 하는 기능을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     unloadPage();
     * </pre>
     * @return 없음
     * @author 공백진
     * @version 2009.08.17
     */      
    function unloadPage(){
    	window.returnValue = rtnValue;
    }        

    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 김재연
     * @version 2009.08.18
     */
    function initSheet(sheetObj,sheetNo) {

    	var cnt = 0;
    	var sheetId = sheetObj.id;

    	switch(sheetId) {

    		case "sheet1":
    			with (sheetObj) {
    				// 높이 설정
    				style.height = 62;
    				//전체 너비 설정
    				SheetWidth = mainTable.clientWidth;

    				//Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				//전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msHeaderOnly;

    				//전체Edit 허용 여부 [선택, Default false]
    				Editable = true;

    				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo(1, 1, 15, 100);

    				var HeadTitle = "Flag|prop_no|amdt_seq|n1st_cmnc_amdt_seq|Free Time|Effective Date|Expiration Date|Source|Status";
    				var headCount = ComCountHeadTitle(HeadTitle);

    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(headCount, 0, 0, true);

    				//해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(false, true, false, true, false, false);

    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle, true);

    				//데이터속성    [ROW, COL, DATATYPE, WIDTH, DATAALIGN,	COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter, 	false, "ibflag");
    				
    				InitDataProperty(0, cnt++, dtHidden, 	70,  daLeft,   	false, "prop_no",			true,  "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 	70,  daLeft,   	false, "amdt_seq", 			true,  "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtHidden,	150, daCenter,	false, "n1st_cmnc_amdt_seq",true,  "", dfNone,		0, false, false);
    				InitDataProperty(0, cnt++, dtCombo,		220, daCenter,	true,  "dmdt_ft_tp_cd",		false, "", dfNone,		0, false, false);
    				InitDataProperty(0, cnt++, dtData,		150, daCenter,	true,  "eff_dt",			false, "", dfDateYmd,	0, false, false);
    				InitDataProperty(0, cnt++, dtData,		150, daCenter,	true,  "exp_dt",			false, "", dfDateYmd,	0, false, false);
    				InitDataProperty(0, cnt++, dtCombo,		110, daCenter,	true,  "src_info_cd",		false, "", dfNone,		0, false, false);
    				InitDataProperty(0, cnt++, dtCombo,		110, daCenter,	true,  "prc_prog_sts_cd",	false, "", dfNone,		0, false, false);
    				
    				InitDataCombo(0, "dmdt_ft_tp_cd", dmdtFtTpCdText, dmdtFtTpCdValue);
    				InitDataCombo(0, "src_info_cd", srcInfoCdText, srcInfoCdValue);
    				InitDataCombo(0, "prc_prog_sts_cd", PrcProgStsCdText, PrcProgStsCdValue);
    				CountPosition = 0;
    				
    				AutoRowHeight = false;
    				WaitImageVisible = false;
    			}
    			break;
    	}
    }

    /**
     * Sheet관련 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @return 없음
     * @author 김재연
     * @version 2009.08.18
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {
    			
	    	case IBSEARCH:
	    		ComOpenWait(true);	
	    		if(!validateForm(sheetObj,formObj,sAction)) {
	    			ComOpenWait(false);
	    			return false;
	      		}
	    		
	    		formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch("ESM_PRI_2058GS.do", FormQueryString(formObj));
				ComOpenWait(false);
	    		break;
	
	    	case IBSAVE:
	    		ComOpenWait(true);
	    		if(!validateForm(sheetObj,formObj,sAction)) {
	    			ComOpenWait(false);
	    			return false;
	      		}
	    		
	    		formObj.f_cmd.value = MULTI01;
				sheetObj.DoSave("ESM_PRI_2058GS.do", FormQueryString(formObj), -1, false);
				ComOpenWait(false);
	    		break;
	
	    	case MODIFY01:	//Accept
	    		ComOpenWait(true);
	    		if (!validateForm(sheetObj, document.form, sAction)) {
	    			ComOpenWait(false);
	    			return false;
				}
	    	
				formObj.f_cmd.value = MULTI02;
				acceptRows(sheetObjects[0], document.form, "ESM_PRI_2058GS.do");
				ComOpenWait(false);
				break;
			
			case MODIFY02:	//Accept Cancel
				ComOpenWait(true);
				if (!validateForm(sheetObj, document.form, sAction)) {
					ComOpenWait(false);
					return false;
				}
				
				formObj.f_cmd.value = MULTI03;
				acceptCancelRows(sheetObjects[0], document.form, "ESM_PRI_2058GS.do");
				ComOpenWait(false);
				break;
				
			case COMMAND01:	//Amend
				var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
				if(chkArr.length > 0){
					if(chkArr.length > 1){					
						ComShowCodeMessage("PRI00310");
					}else{
						amendRow(sheetObjects[0], document.form, sheetObjects[0].SelectRow, "M", "dmdt_ft_tp_cd");
					}
				} else { 
					amendRow(sheetObjects[0], document.form, sheetObjects[0].SelectRow, "M", "dmdt_ft_tp_cd");					
				}
				break;
			
			case COMMAND02: // Amend Cancel
				var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
				if(chkArr.length > 0) {
					if(chkArr.length > 1){					
						ComShowCodeMessage("PRI00310");
					}else{
						amendCancelRow(sheetObjects[0], document.form, sheetObjects[0].SelectRow, "M", "dmdt_ft_tp_cd");
					}
				}else{ 
					amendCancelRow(sheetObjects[0], document.form, sheetObjects[0].SelectRow, "M", "dmdt_ft_tp_cd");
				}
				break;		
    	}
    }
    
    /**
     * 선택한 row 또는 check된 row를 Accpet 처리한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	acceptRows(sheetObjects[0], document.form, "ESM_PRI_0003_04GS.do")
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {object} formObj 필수 처리 대상 form object
     * @param (string) sUrl 필수
     * @return boolean
     * 		true  : 정상
     * 		false : 오류
     * @author 김재연
     * @version 2009.08.18
     */
 	function acceptRows(sheetObj,formObj,sUrl) {
     	var propStsCd = formObj.prop_sts_cd.value;
 		var effDt = formObj.eff_dt.value;
 		var amdtSeq = formObj.amdt_seq.value;
 		
 		if(sheetObj.CellValue(sheetObj.SelectRow,"n1st_cmnc_amdt_seq") != amdtSeq) {
			ComShowCodeMessage("PRI00313");
			return false;
		}
 		
 		if(sheetObj.CellValue(sheetObj.SelectRow, "prc_prog_sts_cd") == "A") {
 			ComShowCodeMessage("PRI01037");
			return false;
 		}
 		
 		sheetObj.CellValue(sheetObj.SelectRow, "prc_prog_sts_cd") = "A";
  		sheetObj.DoSave(sUrl, FormQueryString(formObj), -1, false);
  		return;
 	}
 	
 	/**
     * 선택한 row 또는 check된 row를 Accpet cancel 처리한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	acceptCancelRows(sheetObjects[0], document.form, "ESM_PRI_0003_04GS.do")
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {object} formObj 필수 처리 대상 form object
     * @param (string) sUrl 필수
     * @return boolean
     * 		true  : 정상
     * 		false : 오류
     * @author 김재연
     * @version 2009.08.18
     */
 	function acceptCancelRows(sheetObj, formObj, sUrl) {
    	var propStsCd = formObj.prop_sts_cd.value;
  		var effDt = formObj.eff_dt.value;
  		var amdtSeq = formObj.amdt_seq.value;

  		if(sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq") != amdtSeq) {
  			ComShowCodeMessage("PRI00313");
  			return false;
  		}
  		if(sheetObj.CellValue(sheetObj.SelectRow, "prc_prog_sts_cd") != "A") {
  			ComShowCodeMessage("PRI01038");
			return false;
  		}
  		sheetObj.CellValue(sheetObj.SelectRow, "prc_prog_sts_cd") = "I";
   		sheetObj.DoSave(sUrl, FormQueryString(formObj), -1, false);
   		return;
 	}
 	
 	/**
     * 선택한 row를 amend 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	amendRow(sheetObjects[0], document.form, Row, "M", "rout_pnt_loc_def_cd|prc_trsp_mod_cd")
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {object} formObj 필수 처리 대상 form object
     * @param (int) sRow 필수 row index
     * @param (string) sAction 필수 amend 인지 delete amend 인지 구분
     * @param (string) sCols 필수 column index
     * @return boolean
     * 		true  : 정상
     * 		false : 오류
     * @author 김재연
     * @version 2009.08.18
     */
    function amendRow(sheetObj,formObj,sRow,sAction,sCols) {
		var prop_no      = formObj.prop_no.value;
		var amdt_seq 	 = formObj.amdt_seq.value;
		var pre_amdt_seq = formObj.pre_amdt_seq.value;
		var eff_dt 		 = formObj.eff_dt.value;
		var exp_dt 		 = formObj.exp_dt.value;
		var pre_exp_dt 	 = formObj.pre_exp_dt.value;
		var arrCols      = sCols.split("|");
		var dur_dup_flg  = formObj.dur_dup_flg.value;
		
		// delete / modify Amend 중 이미 amend 된 과거 row 는 제외
		if(sheetObj.CellValue(sRow,"amdt_seq") != amdt_seq || sheetObj.CellValue(sRow,"n1st_cmnc_amdt_seq") == amdt_seq) {		
			ComShowCodeMessage("PRI01011");
		 	return false;
		}

		// DataCopy/ Insert 기준 row 를 잡기 위해 sRow 설정
		sheetObj.SelectRow = sRow;
		
		var idx = sheetObj.DataCopy();	   // 신규 row
		var idx2 = idx-1;  				   // 기존 row
		
		// A/M/D 공통 신규 row 생성
		if(sheetObj.CellValue(idx2, "dmdt_ft_tp_cd") == "E") {
			sheetObj.CellValue2(idx,"dmdt_ft_tp_cd") = "T";	
		} else {
			sheetObj.CellValue2(idx,"dmdt_ft_tp_cd") = "E";
		}
		sheetObj.CellValue2(idx,"eff_dt") = eff_dt;
		sheetObj.CellValue2(idx,"n1st_cmnc_amdt_seq") = amdt_seq;
		sheetObj.CellValue2(idx,"prc_prog_sts_cd") = "I";
		sheetObj.CellValue2(idx,"src_info_cd") = "AM";
//		sheetObj.CellValue2(idx,"ibflag") = "U";
		sheetObj.RowStatus(idx) = "U";
		sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol) = sheetObj.RgbColor(255,0,0);		
		sheetObj.CellFont("FontStrikethru", idx2, 1, idx2, sheetObj.LastCol) = true;
		
		sheetObj.CellValue2(idx2,"amdt_seq") = pre_amdt_seq;
		if(dur_dup_flg=="Y"){
            sheetObj.CellValue2(idx2,"exp_dt") = pre_exp_dt;        	
        }
//		sheetObj.CellValue2(idx2,"ibflag") = "R";
		sheetObj.RowStatus(idx2) = "R";
		sheetObj.RowEditable(idx2) = false;			
		
		// D, A 일 경우  신규 Row 를 update
		if(sAction == "D") {
			sheetObj.CellValue2(idx,"src_info_cd")= "AD";
			for(z=0;z<arrCols.length;z++){
				sheetObj.CellEditable(idx,arrCols[z]) = false;
			}			
		}
		changeSelectBackColor(sheetObj, sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
		return true;
	}
	
    /**
     * 선택한 row를 amend cancel 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	amendCancelRow(sheetObjects[0], document.form, Row, "M", "rout_pnt_loc_def_cd|prc_trsp_mod_cd")
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {object} formObj 필수 처리 대상 form object
     * @param (int) sRow 필수 row index
     * @param (string) sAction 필수 amend 인지 delete amend 인지 구분
     * @param (string) sCols 필수 column index
     * @return boolean
     * 		true  : 정상
     * 		false : 오류
     * @author 김재연
     * @version 2009.08.18
     */
	function amendCancelRow(sheetObj,formObj,sRow,sAction, sCols) {
		var eff_dt = formObj.eff_dt.value;
		var exp_dt = formObj.exp_dt.value;
		var arrCols = sCols.split("|");		
		var pre_amdt_seq = formObj.pre_amdt_seq.value;
		var amdt_seq = formObj.amdt_seq.value;
		var dur_dup_flg  = formObj.dur_dup_flg.value;
		
		// 	A/M/D 동일하게 n1st_cmnc_amdt_seq == amdt_seq 일 경우에만 처리해줌
		if(sheetObj.CellValue(sRow,"n1st_cmnc_amdt_seq")!= amdt_seq){
			ComShowCodeMessage("PRI01012");
		 	return false;
		}

		var idx  = sRow-1;
		var idx2 = sRow;

		if(sAction=="A"&&(sheetObj.CellValue(sRow,"src_info_cd")=="NW"||sheetObj.CellValue(sRow,"src_info_cd")=="GM"||sheetObj.CellValue(sRow,"src_info_cd")=="GC")){
//			sheetObj.CellValue(sRow,"ibflag")="D";
			sheetObj.RowStatus(sRow)="D";
			sheetObj.RowEditable(sRow)=false;
			sheetObj.RowHidden(sRow) = true;
			return false;
		} else {
			if(sheetObj.CellValue(sRow,"src_info_cd")!="AD"&&sheetObj.CellValue(sRow,"src_info_cd")!="AM"){
				ComShowCodeMessage("PRI01002");		
			 	return false;
			}
			if(dur_dup_flg=="Y"){
            	sheetObj.CellValue2(idx,"exp_dt") = exp_dt;
            }
			//sheetObj.CellValue2(idx,"exp_dt") = sheetObj.CellValue(idx2,"exp_dt");
			sheetObj.CellFont("FontStrikethru", idx, 1, idx, sheetObj.LastCol) = false;
			sheetObj.CellFont("FontItalic", idx, 1, idx, sheetObj.LastCol) = false;
			sheetObj.CellValue2(idx,"amdt_seq") = sheetObj.CellValue(idx2, "amdt_seq");
//			sheetObj.CellValue2(idx,"ibflag") = "U";
			sheetObj.RowStatus(idx) = "U";
			//sheetObj.RowEditable(idx) = true;
			
			sheetObj.CellValue2(idx2,"amdt_seq") = pre_amdt_seq;
//			sheetObj.CellValue(idx2,"ibflag") = "R";
			sheetObj.RowStatus(idx2) = "R";
			sheetObj.RowEditable(idx2) = false;
			//sheetObj.RowHidden(idx2) = true;
			sheetObj.RowDelete(idx2, false);
			//sheetObj.SelectCell(idx,"chk");
		}
		changeSelectBackColor(sheetObj, sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
		return true;
	}
	
    /**
  	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * Amend Row의 Highlight 색상을 다르게 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} OldRow 필수, 이전에 선택된 셀의 Row Index
     * @param {int} OldCol 필수, 이전에 선택된 셀의 Column Index
     * @param {int} NewRow 필수, 현재 선택된 셀의 Row Index
     * @param {int} NewCol 필수, 현재 선택된 셀의 Column Index
     * @return 없음
     * @author 김재연
     * @version 2009.08.18
     */         
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {
            changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
        }
    }
     
	/**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 김재연
     * @version 2009.08.18
     */
  	function sheet1_OnSearchEnd(sheetObj, errMsg) {
  		if (errMsg == "") {
  			var formObj = document.form;
 			setSheetDisplay(sheetObj);
// 			rtnValue = sheetObj.CellValue(sheetObj.LastRow, "dmdt_ft_tp_cd");
 		}
 	}   
  	
	/**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장완료 후 정상이면 저장완료 메세지를 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 김재연
     * @version 2009.08.18
     */ 	
 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	 if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
			var formObj = document.form;
			setSheetDisplay(sheetObj);
			dialogArguments.comUpdateProposalStatusSummary("08", "");
			rtnValue = "Y";
		}
	}

    /**
     * Page Loading시에 실행하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @returns 없음
     * @author 김재연
     * @version 2009.08.18
     */ 
    function pageOnLoadFinish() {
     	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     	buttonControl();
    }
  
    /**
     * sheet 의 속성을 설정하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    setSheetDisplay(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @return 없음
     * @author 김재연
     * @version 2009.08.18
     */ 
    function setSheetDisplay(sheetObj) {
 		var formObj = document.form;
 		var amdtSeq = formObj.amdt_seq.value;
 		var effDt = formObj.eff_dt.value;
 		var propStsCd = formObj.prop_sts_cd.value;
 		var aproUsrFlg = form.apro_usr_flg.value;
 		var rCnt = sheetObj.RowCount;
 		
 		if(amdtSeq == 0) {
 			return;
 		}
 		
 		for(var i=1 ; i<=rCnt; i++) {
 			if(sheetObj.CellValue(i ,"amdt_seq") != amdtSeq) { //이전회차는 줄긋고 전부 Edit불가 
 				sheetObj.CellFont("FontStrikethru", i, "dmdt_ft_tp_cd", i, "src_info_cd") = true;
 				continue;
 			}
 			if(sheetObj.CellValue(i, "n1st_cmnc_amdt_seq") != amdtSeq) { //Amend가 아닌 Row는 Edit 불가, 단 체크는 선택가능
 				sheetObj.RowEditable(i) = false;
 				continue;
 			}
 			
 			sheetObj.CellFont("FontColor", i, "dmdt_ft_tp_cd", i, sheetObj.LastCol) = sheetObj.RgbColor(255,0,0); //빨간색
 		}
 	}
    
	/**
	 * 버튼 권한 컨트롤 function <br>
	 * 버튼을 제어한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 		buttonControl()
	 * </pre>
	 * @return 없음
	 * @author 김재연
	 * @version 2009.08.18
	*/
	function buttonControl(){
		var formObj = document.form;
		var req_usr_flg = formObj.req_usr_flg.value;
		var apro_usr_flg = formObj.apro_usr_flg.value;
		var amdt_seq = formObj.amdt_seq.value;
		var sts = formObj.prop_sts_cd.value;
		var rCnt = sheetObjects[0].RowCount;
		
		try {			
			ComBtnEnable("btn_retrieve");
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_amend");
			ComBtnDisable("btn_amendcancel");
			ComBtnDisable("btn_accept");
			ComBtnDisable("btn_acceptcancel");
	
			if(amdt_seq > 0){
				showButton("btn_amend");
				showButton("btn_amendcancel");
				ComBtnDisable("btn_amendcancel");
				ComBtnDisable("btn_amend");
			} else {
				hiddenButton("btn_amend");
				hiddenButton("btn_amendcancel");
			}
			//alert("apro_usr_flg : "+apro_usr_flg+" | req_usr_flg : "+req_usr_flg);
			switch (sts) {
				case 'I':   // Initial
					if(apro_usr_flg == "true" || req_usr_flg == "true" ) {
						ComBtnEnable("btn_save");
						ComBtnEnable("btn_amend");
						ComBtnEnable("btn_amendcancel");
					}					
					break;
					
				case 'Q':   // Requested
					if(apro_usr_flg == "true" ){
						ComBtnDisable("btn_save");
						ComBtnEnable("btn_accept");
						ComBtnEnable("btn_acceptcancel");
						ComBtnDisable("btn_amend");
						ComBtnDisable("btn_amendcancel");
					}
					break;
					
				case 'R':   // Returned
					if(apro_usr_flg == "true") {
						ComBtnEnable("btn_accept");
						ComBtnEnable("btn_acceptcancel");
					} else if(req_usr_flg == "true") {
						ComBtnEnable("btn_accept");
					}
					ComBtnDisable("btn_amend");
					ComBtnDisable("btn_amendcancel");
					break;
					
				case 'P':   // Approved
					
				case 'F':   // Filed

				case 'C':   // Canceled
					break;		
			}	
			
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	 
	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *    validateForm(sheetObj, document.form, sAction)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param (object) formObj 필수 Form Object
     * @param (string) sAction 필수 
     * @return 없음
     * @author 김재연
     * @version 2009.08.18
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
	    	case IBSEARCH: // 조회			
				if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "") {
					ComShowCodeMessage('PRI08001');
					return false;
				}
				return true;
				break;
				
			case MODIFY01:	//Accept
	    		if(!ComShowCodeConfirm('PRI00008')) {
					return false;
				}
				return true;
				break;
			
			case MODIFY02:	//Accept Cancel
	    		if(!ComShowCodeConfirm('PRI00009')) {
					return false;
				}
				return true;
				break;
    	}	
		return true;
   	}
    
	/* 개발자 작업  끝 */