/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_PRI_0152_03.js
*@FileTitle : Korea MOF Filing (Base Table) - CNTR Type
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.07
*@LastModifier : 
*@LastVersion : 1.0
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
     * @class ESM_PRI_0152_02 : ESM_PRI_0152_02 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0152_02() {
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

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1; 

    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
   	
   	 /**
   	  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
   	  * <br><b>Example :</b>
   	  * <pre>
   	  *     processButtonClick();
   	  * </pre>
   	  * @return 없음
   	  * @author 이승준
   	  * @version 2009.04.17
   	  */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheet1 = sheetObjects[0];

        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {
			case "btn_add":
				doActionIBSheet(sheet1, formObject, IBINSERT);
           		break;

            case "btn_del":
            	doActionIBSheet(sheet1, formObject, IBDELETE);
				break;
                
            case "btn_retrieve":
           	 	doActionIBSheet(sheet1, formObject, IBSEARCH);
 				 break;

            case "btn_save":
           	if (validateForm(sheet1,formObject,IBSAVE)) {
  					doActionIBSheet(sheet1, formObject, IBSAVE);
  				}
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
     * @author 이승준
     * @version 2009.04.17
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
     * @author 이승준
     * @version 2009.04.17
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){

       	 //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);

        }
//        doActionIBSheet(sheetObjects[0], document.form ,IBSEARCH);
//        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');

    }
    
    /**
     * LoadFinish 이벤트 시 발생한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet1_OnLoadFinish(sheetObj) {
	   	 sheetObj.WaitImageVisible = false;
	   	 sheetObj.SelectHighLight = true;
		 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
     * @author 이승준
     * @version 2009.04.17
     */ 
    function initSheet(sheetObj,sheetNo) {
   		var cnt = 0;
        var sheetID = sheetObj.id;
        switch(sheetID) {
        case "sheet1":      
			with (sheetObj) {
			
			// 높이 설정
			style.height = 462;
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
			
			var HeadTitle = "|Sel.|Del Check|Seq.|||MOF Code|SML Code|Remark|Use Flag|DEL Flag|Creation\nOffice|Creation\nUser|Creation\nDate|Update\nOffice|Update\nUser|Update\nDate";
			
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false);
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성       ROW , 	COL   ,	DATATYPE   ,	WIDTH  ,DATAALIGN  ,COLMERGE,	SAVENAME	,	KEYFIELD	,CALCULOGIC	,DATAFORMAT    ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
			InitDataProperty(0,		cnt++,	dtHiddenStatus,	30,		daCenter,		true,	"ibflag");
			InitDataProperty(0,		cnt++,	dtDummyCheck,	40,		daCenter,		true,	"chk");
			InitDataProperty(0,		cnt++,	dtDelCheck,		40,		daCenter,		true,	"del_chk");
			InitDataProperty(0,		cnt++,	dtSeq,			40,		daCenter,		true,	"seq");
			InitDataProperty(0,		cnt++,	dtHidden,		40,		daCenter,		true,	"mapg_seq");
			InitDataProperty(0,		cnt++,	dtHidden,		40,		daCenter,		true,	"mapg_tp_cd");
			InitDataProperty(0,		cnt++,	dtData,	80,		daCenter,		false,	"mof_id",		true,		"",			dfInteger,			0,			true,		true, 	6 );
			InitDataProperty(0,		cnt++,	dtData,	80,		daCenter,		false,	"hjs_id",		true,		"",			dfEngUpKey,			0,			true,		true,		2 );
			InitDataProperty(0,		cnt++,	dtData,			80,		daCenter,		false,	"mapg_rmk",		false,		"",			dfNone,			0,			true,		true,   20 );
			InitDataProperty(0,		cnt++,	dtCheckBox,			60,	daCenter,		false,	"file_use_ony_flg",	false,	"",	dfNone,		0,	true,	true,	1,	false,	false,	"",	false );
			InitDataProperty(0,		cnt++,	dtCheckBox,			60,	daCenter,		false,	"delt_flg",					false,	"",	dfNone,		0,	true,	true,	1,	false,	false,	"",	false );
			InitDataProperty(0,		cnt++,	dtData,			70,		daCenter,		false,	"cre_ofc_cd",	false,		"",			dfNone,			0,			false,		false );
			InitDataProperty(0,		cnt++,	dtData,			90,		daCenter,		false,	"cre_usr_nm",	false,		"",			dfNone,			0,			false,		false );
			InitDataProperty(0,		cnt++,	dtData,			80,		daCenter,		false,	"cre_dt",		false,		"",			dfNone,			0,			false,		false );
			InitDataProperty(0,		cnt++,	dtData,			70,		daCenter,		false,	"upd_ofc_cd",	false,		"",			dfNone,			0,			false,		false );
			InitDataProperty(0,		cnt++,	dtData,			90,		daCenter,		false,	"upd_usr_nm",	false,		"",			dfNone,			0,			false,		false );
			InitDataProperty(0,		cnt++,	dtData,			80,		daCenter,		false,	"upd_dt",		false,		"",			dfNone,			0,			false,		false );
			
			ColHidden("del_chk") = true;
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
     * @author 이승준
     * @version 2009.04.17
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
  
        case IBSEARCH:      //조회
       	    try {
				ComOpenWait(true);
        	    formObj.f_cmd.value = SEARCH;
        	    sheetObj.SelectHighLight = true;
 			    sheetObj.DoSearch("ESM_PRI_0152GS.do", FormQueryString(formObj));
 				ComOpenWait(false);
				
			} catch (e) {
     	            if (e == "[object Error]") {
     	                ComShowMessage(OBJECT_ERROR);
     	            } else {
     	                ComShowMessage(e);
     	            }
     	       } finally {
     	    	   ComOpenWait(false);
     	    }
			break;
		
        case IBSAVE:        //저장
       	    formObj.f_cmd.value = MULTI;
			var sParam = FormQueryString(formObj);
			var sParamSheet1 = sheetObjects[0].GetSaveString();
			
			if (sheetObjects[0].IsDataModified && sParamSheet1 == "") {
				return;
			}
			
			sParam += "&" + sParamSheet1;
			
			if (!ComPriConfirmSave()) {
				return false;
			}
			
			try {
				ComOpenWait(true);
				
				var sXml = sheetObjects[0].GetSaveXml("ESM_PRI_0152GS.do", sParam);
				sheetObjects[0].LoadSaveXml(sXml);
				
				ComOpenWait(false);
				
			} catch (e) {
     	        if (e == "[object Error]") {
					ComShowMessage(OBJECT_ERROR);
     	        } else {
     	        	ComShowMessage(e);
     	        }
     	    } finally {
     	    	ComOpenWait(false);
			}
     	    
     	    break;
      		
     		
        case IBINSERT: // Row Add
        	var idx = sheetObj.DataInsert();
        	sheetObj.CellValue2(idx, "mapg_seq") = parseInt(ComPriGetMax(sheetObj, "mapg_seq")) + 1;
        	sheetObj.CellValue2(idx, "mof_id") = parseInt(ComPriGetMax(sheetObj, "mof_id")) + 1;
        	sheetObj.CellValue2(idx, "mapg_tp_cd") = formObj.mapg_tp_cd.value;
      		break;
      
      		
      	case IBDELETE: // Delete
      		deleteRowCheck(sheetObj, "chk", true);
      		break;	 
		}
	}


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @return bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 이승준
     * @version 2009.04.17
     */
	function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
		case IBSAVE: // 저장
    		//Duplication Check 
			if (sheetObj.IsDataModified ) {
    			clearTooltip();
    			
				var rowM = sheetObj.ColValueDup("mof_id|hjs_id",true);
				if (rowM >= 0) {
					 
					sheetObj.SelectHighLight = false;
					var msg = ComGetMsg("PRI00302");
					for (var i = sheetObj.LastRow; i >= 0; i--) {
	
			        	if(sheetObj.CellValue(i,"mof_id") == sheetObj.CellValue(rowM,"mof_id") &&
			            	sheetObj.CellValue(i,"hjs_id") == sheetObj.CellValue(rowM,"hjs_id")	 ) {
			             	add2Tooltip(i, "mof_id", msg);
			            }
			         }
					 
					 alert(msg);
					 
				     return false;
			    }	    		
			 
			 
		} else {
			ComShowCodeMessage("PRI00301");
			return false;
		}
		
		sheetObj.SelectHighLight = true;
		
		return true;
		break;
		
		}
        return true;
    }
  
    /**
     * tooltip을 제거한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     clearTooltip()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function clearTooltip() {
    	var sheetObj = sheetObjects[0];
    	
    	for (var i = sheetObj.HeaderRows, n = sheetObj.HeaderRows+sheetObj.RowCount ; i < n; i++) {
    		for (var j = 0; j <= sheetObj.LastCol; j++) {
    			sheetObj.CellBackColor(i, j) = sheetObj.EditableColor ;
    			sheetObj.ToolTipText(i, j) = "";
    			
    		}
    	}
    }
    
    /**
     * tooltip을 생성한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     add2Tooltip(row, col, msg)
     * </pre>
     * @param {int} row
     * @param {int} col
     * @param {String} msg 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function add2Tooltip(row, col, msg) {
    	var sheetObj = sheetObjects[0];

    	sheetObj.CellBackColor(row, col) = sheetObj.RgbColor(255,0,0);
    	sheetObj.ToolTipText(row, col) +="\n- " +  msg;
    }


	
	/**
    * sheet를 클릭시 발생한다.<br>
    * 체크박스를 언체크 한다.
    * <br><b>Example :</b>
    * <pre>
    *     sheet1_OnClick(sheetObj, Row, Col, Value)
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 
    * @param {int} Col   
    * @param {String} Value   
    * @return 없음
    * @author 이승준
    * @version 2009.06.10
    */
	function sheet1_OnClick(sheetObj, Row, Col, Value)  {
		var colName = sheetObj.ColSaveName(Col);
		if (colName == "chk") {
			if (Value == "0") {
				sheetObj.CellValue(Row, "del_chk") = "0";
			}
		}	
	}
	/**
    * OnSaveEnd 시 발생한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *     searchConditionReset(formObj,gubun)
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {String} ErrMsg    
    * @return 없음
    * @author 이승준
    * @version 2009.06.10
    */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
		if (ErrMsg == "") {
			ComPriSaveCompleted();
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
	}
	
  
	/* 개발자 작업  끝 */