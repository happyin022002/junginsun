/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_PRI_9251_01.js
*@FileTitle : RFA Auth Hardcoding Management (Retro) - Office Level
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.02
*@LastModifier : Min-Gyung Lee
*@LastVersion : 1.0
=========================================================                                                                                                                                                                                                                                                                                                                                                                                                               
* History                                                                                                                                                                                                                                                                                                                                                                                                                                                               
                                                                                                                                                                                                                                                                                                                                                        
=========================================================*/                                                                                                                                                                                                                                                                                                                                                                                                             
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
function ESM_PRI_9251_01() {
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

var is_save_ok = false; // row 추가를 저장이 성공하면 하지 않기 위해서
var is_upd_dt_chk = false; //update date check가 성공했는지

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

	 /** 
	  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	  * <br><b>Example :</b>
	  * <pre>
	  * </pre>
	  *
	  * @return 없음
	  */ 
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         
		var sheetObject1 = sheetObjects[0];	
         
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
        	
				case "btn_retrieve":
					if(validateForm(sheetObject1,formObject,IBSEARCH)) {
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					} 
					break;

				case "btn_save":
					if(validateForm(sheetObject1,formObject,IBSAVE)) {
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
				}
				break;

				case "btn_rowadd":
					if(validateForm(sheetObject1,formObject,IBINSERT)) {
						doActionIBSheet(sheetObject1,formObject,IBINSERT);
				}
				break;

				case "btn_delete":
					if(validateForm(sheetObject1,formObject,IBDELETE)) {
					doActionIBSheet(sheetObject1,formObject,IBDELETE);
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     *
     * @param  {object}   sheet_obj 필수, sheet Object
     * @return 없음
     */ 
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }
    /** 
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * 
     * @return 없음
     */ 
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

		

    }


   /** 
   * 시트 초기설정값, 헤더 정의
   * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
   * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
   * <br><b>Example :</b>
   * <pre>
   * </pre>
   * @param {object} sheetObj 필수, sheet Object
   * @param {String} sheetNo 필수, sheet의 ID
   * @return 없음
   */ 
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        sheetObj.WaitImageVisible = false; 
        switch(sheetObj.id) {
        
			case "sheet1":      // sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 300;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    var HeadTitle1  = "|Seq.|Office|Description|Y/N";
					var headCount = ComCountHeadTitle(HeadTitle1);
                    
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN,	COLMERGE,	SAVENAME,				KEYFIELD,	CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,   true,   	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,		    80, 	daCenter,  	true,		"seq",   				false,   	"",      	dfNone,     0,			false,       	false);
					InitDataProperty(0, cnt++ , dtPopupEdit,    150,	daCenter,  	true,		"auth_apro_ofc_cd", 	true,    	"",      	dfEngUpKey,     0,			false,       	true,	6);
					InitDataProperty(0, cnt++ , dtData,    		600,	daLeft,  	true,		"auth_apro_ofc_nm",   	false,     	"",      	dfNone,     0,			false,       	false);
					InitDataProperty(0, cnt++ , dtCombo,        100,	daCenter,   false,   	"auth_apro_use_flg",    true,  		"",  	 	dfNone,     0, 			true,   		false);
					
					WaitImageVisible = false;
                    InitDataCombo(0,    "auth_apro_use_flg", "YES|NO",    "Y|N"   ,"YES",   "Y");

			   }
			break;
        }
    }
    

    /** 
     * sheet에 관련된 실제 Action(Retrieve, Add, Delete)을 일으키는 함수
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {object} formObj 필수, html document form Object
     * @param {int} sAction 필수, action의 구분
     * @return 없음
     */   
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        case IBSEARCH:      //조회
        	formObj.f_cmd.value = SEARCH01;
        	ComOpenWait(true);   
        	sheetObj.RemoveAll();
        	var sXml = sheetObj.GetSearchXml("ESM_PRI_9251_01GS.do", FormQueryString(formObj) );
        	sheetObj.LoadSearchXml(sXml);	
        	ComOpenWait(false);
        	break;

		 case IBSAVE:        //저장
			//저장시 Row Add 대상으로 기존 것과 중복이 있는지 확인.
		 	ComOpenWait(true);   
		 	formObj.f_cmd.value = MULTI;
		 	if (sheetObj.IsDataModified) {
		 	   sheetObj.DoSave("ESM_PRI_9251_01GS.do",FormQueryString(formObj) );			 	   
		 	} else {
		 	   ComShowCodeMessage('PRI00115');  
		 	}
		 	ComOpenWait(false);
            break;
        
		case IBINSERT: // Row Add
	    	sheetObj.Redraw = false;
	        var idx = sheetObj.DataInsert();
    		sheetObj.Redraw = true;
    		break;
    
    	case IBDELETE: // Delete
    		deleteSelectedRow(sheetObj);
			break;     
        }
    }


    /** 
     * sheet를 이용해 조회를 했을경우 조회 완료후 자동 호출됨 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {String} ErrMsg 필수, sheet의 결과 메시지
     * @return 없음
     */  
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){

    }
     
     /** 
      * sheet를 이용해 조회를 했을경우 조회 완료후 자동 호출됨 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {object} sheetObj 필수, sheet Object
      * @param {String} ErrMsg 필수, sheet의 결과 메시지
      * @return 없음
      */  
 	function sheet1_OnSaveEnd(sheetObj, ErrMsg){
 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }         
 	
 	/**
    * OnPopupClick 이벤트 발생시 호출되는 function <br>
    * Scope Duration,Scope MQC, G/L Copy 를 호출한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
    * @return 없음
    * @author 공백진
    * @version 2009.05.07
    */      
    function sheet1_OnPopupClick(sheetObj, Row, Col){
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;
        switch(colName)
        {
            case "auth_apro_ofc_cd": 
                ComOpenPopup('/hanjin/COM_ENS_071.do?ofc_pts_cd=ALL', 780, 535, 'getCOM_ENS_071_1', '1,0,1,1,1,1,1,1',true, true);
                break;    	                    	         
        }
    }     
	    
    /**
     * 유저 아이디 선택 후 해당 그리드로 셋팅
     */
    function getCOM_ENS_071_1(rowArray) {
    	var sheetObject1 = sheetObjects[0];	
    	var colArray = rowArray[0];
    	//if(colArray[4]가Authority에 있으면)
    	//셋팅하지 않고 팝업!
      	sheetObject1.CellValue(sheetObject1.SelectRow,"auth_apro_ofc_cd") 		= colArray[3]	;
      	sheetObject1.CellValue(sheetObject1.SelectRow,"auth_apro_ofc_nm") 		= colArray[4]	;
      	                                                 
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
    	case IBSAVE: 
    		//중복검사
    		if (sheetObj.IsDataModified ) {
    			
    			clearTooltip();
    			
				 var rowM = sheetObj.ColValueDup("auth_apro_ofc_cd",true);
				 if (rowM >= 0) {
					 
					 sheetObj.SelectHighLight = false;
					 
					 var msg = ComGetMsg("PRI00302");
					 
					 for (var i = sheetObj.LastRow; i >= 0; i--) {

			             if(sheetObj.CellValue(i,"auth_apro_ofc_cd") == sheetObj.CellValue(rowM,"auth_apro_ofc_cd")) {
			             	add2Tooltip(i, "auth_apro_ofc_cd", msg);
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
    		
    	case IBDELETE:
    		var selRow = sheetObj.SelectRow;
    		var selRowSts = sheetObj.RowStatus(selRow);
    		//신규 입력이 아닐 경우 삭제 불가
    		if(selRowSts!="I"){
 		 	    ComShowCodeMessage('PRI01166');
    			return false;
    		}
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
     * sheet1 더블 클릭시 발생하는 sheet1_OnDblClick 이벤트핸들러 <br>
     */
    function sheet1_OnDblClick(sheetObj, Row, Col) {
    	var formObj = document.form;
    	//신규 행의 경우 History 연결 X
    	if(sheetObj.RowStatus(Row) == "I"){
    		return;
    	}
        var prc_ctrt_tp_cd = formObj.prc_ctrt_tp_cd.value;
        var prc_ofc_auth_tp_cd = formObj.prc_ofc_auth_tp_cd.value;
        var auth_apro_ofc_cd = sheetObj.CellValue(Row, "auth_apro_ofc_cd");
        var popParams = "title=RFA Auth Hardcoding Management (Retro) - Office Level (History)&prc_ctrt_tp_cd="+prc_ctrt_tp_cd+"&prc_ofc_auth_tp_cd="+prc_ofc_auth_tp_cd+"&auth_apro_ofc_cd="+auth_apro_ofc_cd;
        ComPriOpenWindowCenter("/hanjin/ESM_PRI_9451.do?"+popParams, "ESM_PRI_9451",900, 320, true);
    }
    

    /**
     * 현재 선택된 row를 삭제한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     deleteRowCheck(sheetObj);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return ComRowHideDelete() 함수 return 값
     * @author 문동규
     * @version 2009.04.22
     */
    function deleteSelectedRow(sheetObj) {
    	var isSelectDel = true;

        var checkRow = ""
        var selRow = sheetObj.SelectRow;
        var delRowCount = 0;
        var nextVisibleRow = sheetObj.SelectRow;
        var fireEventPostDelete = false;

        // 삭제대상중에 현재 로우가 포함되어있는지 체크
        fireEventPostDelete = true;
        // IBSheet의 마지막 로우를 Delete하면(중간 Row를 Delete하는 경우와는 다르게) 이벤트가 발생한다.
        // X같은 IBSheet의 넘치는 버그 중 하나... 따라서 이런 경우 이벤트를 강제로 발생시키지 않도록 처리.
        if (sheetObj.RowStatus(selRow) == "I" && sheetObj.SelectRow == sheetObj.LastRow) {
            fireEventPostDelete = false;
        }
        
        nextVisibleRow = sheetObj.SelectRow;
        
        sheetObj.RowHidden(selRow)= true;		//2.행 숨기기
		sheetObj.RowStatus(selRow)= "D";		//3.트랜잭션 상태 "삭제"로 만들기

        
            if (sheetObj.RowStatus(sheetObj.SelectRow) == "D" && sheetObj.RowHidden(sheetObj.SelectRow)) {
                nextVisibleRow = -1;
//              for (var i = sheetObj.SelectRow; i <= sheetObj.LastRow; i++) {
//                  if (!sheetObj.RowHidden(i) && sheetObj.RowStatus(i) != "D") {
//                      nextVisibleRow = i;
//                      break;
//                  }
//              }
//              if (nextVisibleRow < 0) {
//                  for (var i = sheetObj.SelectRow; i >= sheetObj.HeaderRows; i--) {
//                      if (!sheetObj.RowHidden(i) && sheetObj.RowStatus(i) != "D") {
//                          nextVisibleRow = i;
//                          break;
//                      }
//                  }
//              }
// IBSheet 버그가 해결될때까지 Row를 삭제 후,아래 행이 아닌 윗 행으로 이동한다. 2010-01-05.
                for (var i = sheetObj.SelectRow; i >= sheetObj.HeaderRows; i--) {
                    if (!sheetObj.RowHidden(i) && sheetObj.RowStatus(i) != "D") {
                        nextVisibleRow = i;
                        break;
                    }
                }
                if (nextVisibleRow < 0) {
                    for (var i = sheetObj.SelectRow; i <= sheetObj.LastRow; i++) {
                        if (!sheetObj.RowHidden(i) && sheetObj.RowStatus(i) != "D") {
                            nextVisibleRow = i;
                            break;
                        }
                    }
                }
            }
            
            if (fireEventPostDelete && nextVisibleRow > 0) {
                try {
                    eval(sheetObj.id + "_OnSelectCell(sheetObj, -2, " + sheetObj.SelectCol + ", " + nextVisibleRow + ", " + sheetObj.SelectCol + ")");
                } catch (err) {
                }
            }

          nextVisibleRow = nextVisibleRow > sheetObj.LastRow ? sheetObj.LastRow : nextVisibleRow;
// IBSheet 버그가 해결될때까지 Row를 삭제 후,아래 행이 아닌 윗 행으로 이동한다. 2010-01-05.
//            nextVisibleRow = nextVisibleRow < sheetObj.HeaderRows ? sheetObj.HeaderRows : nextVisibleRow;
            if (nextVisibleRow > 0) {
                sheetObj.SelectRow = nextVisibleRow;
            }
        
        return delRowCount;
    }
    
    
    /**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * 콤보의 SVC Scope명칭을 INPUT BOX에 채운고 조회를 한다.. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */  	
   	function sheet1_OnChange(sheetObj, Row, Col) {
	   	  var colName = sheetObj.ColSaveName(Col);
	      var formObj = document.form;
    		
    		switch(colName){
    		case "auth_apro_ofc_cd":
    			var ofc_cd = sheetObj.CellValue(Row,Col);
    			ofc_cd = ofc_cd.toUpperCase();
    			if(ofc_cd !="") {
    	            var sParam = "ofc_cd="+ofc_cd+"&f_cmd="+SEARCH;
    	            var sXml = sheetObj.GetSearchXml("ESM_PRI_4023GS.do", sParam);
    	            var arrText = ComPriXml2Array(sXml, "ofc_eng_nm|ibflag|loc_cd|ofc_tp_cd|prnt_ofc_cd|ofc_cd");
    	            if(arrText==undefined){
    	            	sheetObj.CellValue2(Row,"auth_apro_ofc_cd") = "";
    	            	sheetObj.CellValue2(Row,"auth_apro_ofc_nm") = "";
    	            }else{        	            	
    	            	sheetObj.CellValue2(Row,"auth_apro_ofc_cd") = arrText[0][5];
    	            	sheetObj.CellValue2(Row,"auth_apro_ofc_nm") = arrText[0][0];
    	            }
    	        }else{
    	        	sheetObj.CellValue2(Row,"auth_apro_ofc_cd") = "";
    	        	sheetObj.CellValue2(Row,"auth_apro_ofc_nm") = "";
    	        }
    		}
   	}
   	
/* 개발자 작업  끝 */
            