/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0001_07.js
*@FileTitle : SC Guideline Contract Clause
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.04.28 이승준
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
     * @class ESM_PRI_0001_07 : ESM_PRI_0001_07 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0001_07() {
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
    var enableFlg = true;
    
    var sChgCdVisiable = "";

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

            var sheetObject1 = sheetObjects[0];
            var sheetObject2 = sheetObjects[1];

             /*******************************************************/
            var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {
                
                case "btn_retrieve":
                	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;

				case "btn_Save":
					doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
					break;

				case "btn_RowAdd1":
					doActionIBSheet(sheetObjects[0],formObject,IBINSERT);
					break;

				case "btn_Delete1":
					doActionIBSheet(sheetObjects[0],formObject,IBDELETE);
					break;


				case "btn_RowAdd2":
					doActionIBSheet(sheetObjects[1],formObject,IBINSERT);
					break;

				case "btn_Delete2":
					doActionIBSheet(sheetObjects[1],formObject,IBDELETE);
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
         * @param 없음
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
//            doActionIBSheet(sheetObjects[0], document.form, IBCREATE);  
            
            axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
            toggleButtons("CLEAR");
            
            parent.loadTabPage();
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
        function sheet2_OnLoadFinish(sheetObj) {
	       	 doActionIBSheet(sheetObjects[1], document.form, IBCREATE); 
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
                    style.height = 322;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    var HeadTitle = "|Sel.|Del Check.|Seq.|Item|svc_scp_cd|gline_seq|ctrt_cluz_seq";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,		"ibflag");
                    InitDataProperty(0, cnt++ , dtDummyCheck,   40, 	daCenter,   	true,   	"chk",      	    false,  "", dfNone, 0, true,  true);
                    InitDataProperty(0, cnt++ , dtDelCheck,     30, 	daCenter,   	true,   	"del_chk",      	false,  "", dfNone, 0, true,  true);
            		InitDataProperty(0, cnt++ , dtDataSeq,		28,		daCenter,		false,		"Seq");
                    InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,		false,		"note_clss_cd",		true,   "",	dfNone,	0, true,  true);
                    InitDataProperty(0, cnt++,  dtHidden, 		90, 	daLeft,    		false, 		"svc_scp_cd", 		false,  "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++,  dtHidden, 		90, 	daLeft,     	false, 		"gline_seq", 		false,  "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++,  dtHidden, 		90, 	daLeft,    		false, 		"ctrt_cluz_seq", 	false,  "", dfNone, 0, false, false);
                    
					//InitDataCombo(0, "note_clss_cd", "GRI|SURCHARGE|DEM/DET|OTHERS", "1|2|3|4");
					ColHidden("del_chk") = true;
					CountPosition = 0;
					//AutoRowHeight = false;
					WaitImageVisible = false;
				}
                break;

            case "sheet2":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 322;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    var HeadTitle = "|Sel.|Del Check.|Seq.|Surcharge|Clause|svc_scp_cd|gline_seq|note_clss_cd|ctrt_cluz_dtl_seq";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,		"ibflag");
                    InitDataProperty(0, cnt++ , dtDummyCheck,   40, 	daCenter,   	true,   	"chk",      		false, "", dfNone, 0, true,  true);
                    InitDataProperty(0, cnt++ , dtDelCheck,     30, 	daCenter,   	true,   	"del_chk",      	false, "", dfNone, 0, true,  true);
            		InitDataProperty(0, cnt++ , dtDataSeq,		28,		daCenter,		false,		"Seq");
                    InitDataProperty(0, cnt++ , dtComboEdit,	120,	daLeft,			false,		"chg_cd",			false, "", dfNone, 0, true,	 true);
                    InitDataProperty(0, cnt++ , dtData,			100,	daLeft,			false,		"ctrt_cluz_ctnt",	true,  "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++,  dtHidden, 		90, 	daLeft,    		false, 		"svc_scp_cd", 		false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++,  dtHidden, 		90, 	daLeft,    		false, 		"gline_seq", 		false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++,  dtHidden, 		90, 	daLeft,    		false, 		"ctrt_cluz_seq", 	false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++,  dtHidden, 		90, 	daLeft,    		false, 		"ctrt_cluz_dtl_seq",false, "", dfNone, 0, false, false);
                    
					//InitDataCombo(0, "chg_cd", "BUC|CAF|CUC|PSS", "1|2|3|4");
					ColHidden("del_chk") = true;
					CountPosition = 0;
					AutoRowHeight = false;
					InitDataValid(0, "chg_cd", vtEngUpOnly);
					WaitImageVisible = false;
				}
                break;

            }
        }
        
        /*function sheet1_OnClick(sheetObj, Row, Col, Value)  {
     		var colName = sheetObj.ColSaveName(Col);
     		if (colName == "chk") {
     			if (Value == "0") {
     				sheetObj.CellValue(Row, "del_chk") = "0";
     			}
     			
     			// 좌측 그리드 체크박스 체크시, 우측도 체크
     			var sCols = "svc_scp_cd|gline_seq|ctrt_cluz_seq";
     			var sVals = sheetObj.CellValue(Row, "svc_scp_cd") + "|" + 
     						sheetObj.CellValue(Row, "gline_seq")  + "|" +
     						sheetObj.CellValue(Row, "ctrt_cluz_seq");
     			
     			var arrIdx = ComPriSheetFilterRows(sheetObjects[1], sCols, sVals);
     			
     			if (arrIdx == null || arrIdx.length == 0) {
     				return;
     			}
     			for (var i = 0; i < arrIdx.length; i++) {
     				sheetObjects[1].CellValue(arrIdx[i], "chk") = Value;
     				if (Value == "0") {
     					sheetObjects[0].CellValue(arrIdx[i], "del_chk") = Value;
     				}
     			}
     		}
     	}
        
     	
     	function sheet2_OnClick(sheetObj, Row, Col, Value)  {
     		var colName = sheetObj.ColSaveName(Col);
     		if (colName == "chk") {
     			if (Value == "0") {
     				sheetObj.CellValue(Row, "del_chk") = "0";
     			}
     		}
     	}*/
        
        /**
         * sheet에서 체크 버튼을 클릭하기 전에 발생한다. <br>
         * CheckBox를 선택했을때, 하위 sheet를 모두 check하고, 전체에서 1개가 해제된 상태라면 상위 check를 풀어준다. <br>
         * <br><b>Example :</b>
         * <pre>
         *     
         * </pre>
         * @param {ibsheet} sheetObj 필수 IBSheet Object
         * @param {String} Row 
         * @param {String} Col 
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */
        function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
    		var colName = sheetObj.ColSaveName(Col);

    		if (colName == "chk") {
    			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 0, Row, Col);
    		}
    	}
        /**
         * sheet에서 체크 버튼을 클릭하기 전에 발생한다. <br>
         * CheckBox를 선택했을때, 하위 sheet를 모두 check하고, 전체에서 1개가 해제된 상태라면 상위 check를 풀어준다. <br>
         * <br><b>Example :</b>
         * <pre>
         *     
         * </pre>
         * @param {ibsheet} sheetObj 필수 IBSheet Object
         * @param {String} Row 
         * @param {String} Col 
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */
    	function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
    		var colName = sheetObj.ColSaveName(Col);

    		if (colName == "chk") {
    			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 1, Row, Col);
    		}
    	}
        
    	/**
         * sheet에서 cell을 클릭한 경우 발생. <br>
         * <br><b>Example :</b>
         * <pre>
         *     sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
         * </pre>
         * @param {ibsheet} sheetObj 필수 IBSheet Object
         * @param {int} OldRow 
         * @param {int} OldCol 
         * @param {int} NewRow 
         * @param {int} NewCol 
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */
    	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
    		doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
    	}
     	
        var isFiredNested = false;
    	var supressConfirm = false;
    	/**
         * sheet1_OnSelectCell 이벤트 발생시 호출됨. <br>
         * 데이타를 변경한 경우 새로운 셀 선택 시 저장 메세지 호출 <br>
         * 저장을 하지 않으면 변경한 셀로 포커스를 강제 이동시킴.<br>
         * 
         * <br><b>Example :</b>
         * <pre>
         *     doRowChange(OldRow, NewRow, OldCol, NewCol, sAction)
         * </pre>
         * @param {ibsheet} sheetObj 필수 IBSheet Object
         * @param {int} OldRow 
         * @param {int} OldCol 
         * @param {int} NewRow 
         * @param {int} NewCol 
         * @param {String} sAction
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */
    	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
    		var formObj = document.form;
    		var adjNewRow = NewRow;
    		
    		if (!isFiredNested && (OldRow != NewRow)) {
    			if (sheetM.IsDataModified) {
    				isFiredNested = true;
    				sheetM.SelectCell(OldRow, OldCol, false);
    				isFiredNested = false;
    				
    				if (validateForm(sheetM,document.form,IBSAVE)) {
    					isFiredNested = true;
    					sheetM.SelectCell(NewRow, NewCol, false);
    					isFiredNested = false;
    				} else {
    					isFiredNested = true;
    					sheetM.SelectCell(OldRow, OldCol, false);
    					isFiredNested = false;
    					return -1;
    				}
    			}
    			
    			if (sheetD.IsDataModified) {
    				isFiredNested = true;
    				sheetM.SelectCell(OldRow, OldCol, false);
    				isFiredNested = false;
    				
    				var rslt = false;
    				if (ComShowCodeConfirm("PRI00006")) {
    					supressConfirm = true;
    					adjNewRow = Math.max(NewRow - sheetM.RowCount("D"), sheetM.HeaderRows);
    					var rslt = doActionIBSheet(sheetM,document.form,IBSAVE);
    					supressConfirm = false;
    				}
    				if (rslt) {
    					isFiredNested = true;
    					sheetM.SelectCell(adjNewRow, NewCol, false);
    					isFiredNested = false;
    				} else {
    					isFiredNested = true;
    					sheetM.SelectCell(OldRow, OldCol, false);
    					isFiredNested = false;
    					return -1;
    				}
    			}
    			
    			if (appendRow) {
    				isFiredNested = true;
    				var idx = sheetM.DataInsert();
    				isFiredNested = false;
    				return idx;
    			} else {
    				formObj.f_cmd.value = SEARCH02;
    				formObj.ctrt_cluz_seq.value = sheetM.CellValue(adjNewRow, "ctrt_cluz_seq");
    				if(formObj.ctrt_cluz_seq.value == "undefined" || ComIsEmpty(formObj.ctrt_cluz_seq.value)) {
                    	formObj.ctrt_cluz_seq.value = sheetM.CellValue(sheetM.SelectRow,"ctrt_cluz_seq");
                    }
    				
    				
    				// charge code
    				var sCd = sheetD.GetComboInfo(0,"chg_cd","Code");
    				var sNm = sheetD.GetComboInfo(0,"chg_cd","Text");				  						
    				////////////////////////////////////////////////////////////////////////////////	
      				formObj.f_cmd.value = SEARCH02;
      				var sXml = sheetD.GetSearchXml("ESM_PRI_0001_07GS.do", FormQueryString(formObj));
      				
      				var arrData = ComPriXml2Array(sXml, "chg_cd");			
      				
    				if (arrData != null && arrData.length > 0) {
    					
    					for(var i=0; i<arrData.length; i++){
    						
    						if (sCd.indexOf(arrData[i][0]) < 0) {
    							sCd += "|" + arrData[i][0];
    							sNm += "|" + arrData[i][0];
    						}
    					}					
    					sheetD.InitDataCombo(0,"chg_cd", sNm, sCd,"", "", 0, "", "", sChgCdVisiable);
    				}			
    				sheetD.LoadSearchXml(sXml);
    				
    				
    			}
    		}
    	}
     	
    	/**
         * 아이템 선택시 상태에 따라 surCharge 콤보 히든한다. <br>
         * 데이타를 변경한 경우 새로운 셀 선택 시 저장 메세지 호출 <br>
         * 저장을 하지 않으면 변경한 셀로 포커스를 강제 이동시킴.<br>
         * 
         * <br><b>Example :</b>
         * <pre>
         *     setSurchargeCombo()
         * </pre>
         * @param 없음
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */
     	function setSurchargeCombo()  {
    		//////////////아이템 선택시 surCharge 콤보로 변경////////////////////////////
    		var formObj = document.form;
     		var note_clss_cd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"note_clss_cd");
     		//alert(note_clss_cd)
     		
     		//마스터에서 SURCHARGE를 선택했으면 surcharge 컬럼을 보인다.
  	    	if(note_clss_cd == "S") {
  	    		sheetObjects[1].ColHidden("chg_cd") = false;
				
  	    	} else {
  	    		sheetObjects[1].ColHidden("chg_cd") = true;
  	    		
  	    		//for(var k = 1; k<=sheetObjects[1].RowCount;k++){
  	    			
  	    			//sheetObjects[1].InitDataCombo(0, "chg_cd", "|", "", "", "");
   	   		   // }
  	    		
  	    		
  	    		// Surcharge combo
//    			formObj.f_cmd.value = COMMAND12;
//    			formObj.etc1.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"note_clss_cd");
//				sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
//				setIBCombo(sheetObjects[1],sXml,"chg_cd",true,0);
  	    	}
  	    	//////////////////////////////////////////////////////////////////////////		
          	
    	}
     	
     	/**
         * sheet에서 데이터가 변경시 호출된다. <br>
         * <br><b>Example :</b>
         * <pre>
         *    
         * </pre>
         * @param {int} Row 
         * @param {int} Col 
         * @param {String} Value 
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */
     	function sheet1_OnChange(Row,Col,Value) {
     		//sheetObjects[1].removeAll();
     		setSurchargeCombo();
     	
     	}
     	/**
         * sheet에서 데이터가 변경시 호출된다. <br>
         * <br><b>Example :</b>
         * <pre>
         *    
         * </pre>
         * @param {int} Row 
         * @param {int} Col 
         * @param {String} Value 
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */
     	function sheet2_OnSearchEnd(ErrMsg) {
     		setSurchargeCombo();
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
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {
	    		case IBCREATE: // 화면 로딩시 코드 조회
	    			
	    			//공통
	    			formObj.f_cmd.value = SEARCH19;
	    			formObj.cd.value="CD01711";
	    			
	    			sheetObjects[0].WaitImageVisible = false;
                    
					var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
					setIBCombo(sheetObjects[0],sXml,"note_clss_cd",true,0);
					
//					// Surcharge combo
//	    			formObj.f_cmd.value = COMMAND12;
//					sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
//					setIBCombo(sheetObjects[1],sXml,"chg_cd",true,0);
	
					break;
   			
	    		case IBSEARCH:      //조회
   					
	    			if (validateForm(sheetObj,document.form,sAction)) {
	    				
	    				try {
	    					for (var i = 0; i < sheetObjects.length; i++) {
	                        	sheetObjects[i].WaitImageVisible = false;
	                        }
		        		    ComOpenWait(true);
		        		   
		   					if ( sheetObj.id == "sheet1") {
		   						
		   						for (var i = 0; i < sheetObjects.length; i++) {
		   							sheetObjects[i].RemoveAll();
		   						}
		   						
		 	            	   	formObj.f_cmd.value = SEARCH01;
		 	            	    sheetObjects[0].DoSearch("ESM_PRI_0001_07GS.do", FormQueryString(formObj));
			       				
			       		    }	
		   					
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
	    			}	
 				   
	                break;

    			case IBSAVE:        //저장
					
    				if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
    					return false;
    				}
    				
    				formObj.f_cmd.value = MULTI01;
    				var sParam = FormQueryString(formObj);
    				var sParamSheet1 = sheetObjects[0].GetSaveString();
    				
	 				if (sheetObjects[0].IsDataModified && sParamSheet1 == "") {
	 					return;
	 				}
    				
    				if (sParamSheet1 != "") {
    					sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
    				}
    				var sParamSheet2 = sheetObjects[1].GetSaveString();
    				
    				if (sheetObjects[1].IsDataModified && sParamSheet2 == "") {
	 					return;
	 				}
    				
    				if (sParamSheet2 != "") {
    					sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
    				}

    				//alert(sParam);
    				
    				
    				if (!supressConfirm && !ComPriConfirmSave()) {
    					return false;
    				}
    				
    				try {
        			    ComOpenWait(true);
	    				var sXml = sheetObj.GetSaveXml("ESM_PRI_0001_07GS.do", sParam);
	    				sheetObjects[1].LoadSaveXml(sXml);
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
    				
    				if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified) {
    					return false;
    				} else {
    					parent.setTabStyle();
    					ComPriSaveCompleted();
    					
    					if (getValidRowCount(sheetObjects[0]) >= 1 && getValidRowCount(sheetObjects[1]) <= 0) {
							doRowChange(sheetObjects[0], sheetObjects[1], -1, sheetObjects[0].SelectRow, sheetObjects[0].SelectCol, sheetObjects[0].SelectCol, false);
						}
    					return true;
    				}
    				break;
    	              
				case IBINSERT:      // 입력
					
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					if (sheetObj.id == "sheet1") {
						//var idx = doRowChange(sheetObj, sheetObjects[1], sheetObj.SelectRow, sheetObj.SelectRow + 1, sheetObj.SelectCol, true);
						var idx = doRowChange(sheetObj, sheetObjects[1], sheetObj.SelectRow, sheetObj.SelectRow + 1, sheetObj.SelectCol, sheetObj.SelectCol, true);
						if (idx < 0) {
							return false;
						}
						sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
						sheetObj.CellValue(idx, "gline_seq") = formObj.gline_seq.value;
						sheetObj.CellValue(idx, "ctrt_cluz_seq") = parseInt(ComPriGetMax(sheetObj, "ctrt_cluz_seq")) + 1;
						sheetObjects[1].RemoveAll();
						
						sheetObj.SelectCell(idx, "note_clss_cd");
						
					}
					if (sheetObj.id == "sheet2") {
						var idx = sheetObj.DataInsert();
						setSurchargeCombo();
						
						sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
						sheetObj.CellValue(idx, "gline_seq") = formObj.gline_seq.value;
						var ctrt_cluz_seq = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "ctrt_cluz_seq");
						sheetObj.CellValue(idx, "ctrt_cluz_seq") = ctrt_cluz_seq;
						sheetObj.CellValue(idx, "ctrt_cluz_dtl_seq") = parseInt(ComPriGetMax(sheetObj, "ctrt_cluz_dtl_seq")) + 1;
						
						if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "note_clss_cd") == "S") {
							sheetObj.SelectCell(idx, "chg_cd");
						} else {
							sheetObj.SelectCell(idx, "note_ctnt");
						}
					}
					break;
				case IBDELETE: // Delete
//					deleteRowCheck(sheetObj, "chk");
//					if (sheetObj.id == "sheet1") {
//						deleteRowCheck(sheetObjects[1], "chk");
//					} 
//					break;
					
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
		        	if (sheetObj.CheckedRows("chk") <= 0) {
		        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
		        	}

		        	var delCnt = deleteRowCheck(sheetObj, "chk");
					if (delCnt > 0 && sheetObj.id == "sheet1") {
						for (var i = sheetObjects[1].HeaderRows; sheetObjects[1].RowCount > 0 && i <= sheetObjects[1].LastRow; i++) {
							sheetObjects[1].CellValue(i, "chk") = "1";
						}
						deleteRowCheck(sheetObjects[1], "chk");
					}
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
    		case IBSEARCH: // 조회
    		
    			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
    				ComShowCodeMessage('PRI08001');
    				return false;
    			} 
    			return true;
    			break;
    	
    		case IBSAVE: // 저장
    			
    			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
    				ComShowCodeMessage('PRI08001');
    				return false;
    			} 
    			
    			if (!sheetObjects[0].IsDataModified && !sheetObjects[1].IsDataModified) {
        			ComShowCodeMessage("PRI00301");
        			return false;
        		}

				if (sheetObjects[0].IsDataModified ) {
					 var rowM = sheetObjects[0].ColValueDup("svc_scp_cd|gline_seq|note_clss_cd",false);
					 
					 if (rowM >= 0) {				 
						 ComShowCodeMessage("PRI00303", "Sheet1", rowM);
					     return false;
					 }
				}  
				
				if (sheetObjects[1].IsDataModified ) {
					 var rowM = sheetObjects[1].ColValueDup("svc_scp_cd|gline_seq|ctrt_cluz_seq|ctrt_cluz_dtl_seq",false);
					 
					 if (rowM >= 0) {				 
						 ComShowCodeMessage("PRI00303", "Sheet2", rowM);
					     return false;
					 }
				}   
				
				//sheet1에서 하나라도 저장했는지 체크
	       		if (sheetObjects[0].RowCount <= 0 || sheetObjects[0].SelectRow <= 0) {
	       			ComPriInputValueFailed("input","Item","");
	       			doActionIBSheet(sheetObjects[0], document.form, IBINSERT);
                    return false;
                }
	       		
	       		//sheet2에서 하나라도 저장했는지 체크
	       		if (getValidRowCount(sheetObjects[0]) >= 1 && (sheetObjects[1].RowCount <= 0 || sheetObjects[1].SelectRow <= 0)) {
	       			ComShowCodeMessage("PRI00319", "Clause");
	       			doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
                    return false;
                }
				
    			return true;
    			break;
    			
    		case IBINSERT: // Row Add
    			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
    				ComShowCodeMessage('PRI08001');
    				return false;
    			} else {
    				return true;
    			}
    			break;
    			
    		case IBDELETE: // Delete
    			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
    				ComShowCodeMessage('PRI08001');
    				return false;
    			} else {
    				return true;
    			}
    			break;
    		}        

            return true;
        }

  
     	
     	
    	/**
         * OnClick 이벤트 발생시 호출되는 function <br>
         * 주소입력시 메모장을 화면에 표시한다. <br>
         * <br><b>Example :</b>
         * <pre>
         *
         * </pre>
         * @param {ibsheet} sheetObj 필수 IBSheet Object
         * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
         * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
         * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
         * @return 없음
         * @author 공백진
         * @version 2009.06.03
         */  	           
         function sheet2_OnClick(sheetObj, Row, Col, Value) {
    	    //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
    	    var colname = sheetObj.ColSaveName(Col);  	 
    	     
         	switch(colname)
         	{
     	    	case "ctrt_cluz_ctnt":
     	    		ComShowMemoPad(sheetObj,Row,Col,false,678,200);
     	    		
     	    		break;
         	}    	 

         }
         
         
         function toggleButtons(mode) {
     		switch (mode) {
     		case "CLEAR":
     			ComBtnDisable("btn_Retrieve");
     			ComBtnDisable("btn_Save");
     			ComBtnDisable("btn_RowAdd1");
     			ComBtnDisable("btn_Delete1");
     			ComBtnDisable("btn_RowAdd2");
     			ComBtnDisable("btn_Delete2");
     			break;
     		case "INIT":
     			ComBtnEnable("btn_Retrieve");
     			ComBtnEnable("btn_Save");
     			ComBtnEnable("btn_RowAdd1");
     			ComBtnEnable("btn_Delete1");
     			ComBtnEnable("btn_RowAdd2");
     			ComBtnEnable("btn_Delete2");
     			break;
     		case "READONLY":
     			ComBtnEnable("btn_Retrieve");
     			ComBtnDisable("btn_Save");
     			ComBtnDisable("btn_RowAdd1");
     			ComBtnDisable("btn_Delete1");
     			ComBtnDisable("btn_RowAdd2");
     			ComBtnDisable("btn_Delete2");
     			break;
     		}
     	}
         
         
         
//         function tabLoadSheet(sSvcScpCd, sGlineSeq) {
//     		var formObject = document.form;
//     		
//     		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
//     			formObject.svc_scp_cd.value = sSvcScpCd;
//     			formObject.gline_seq.value = sGlineSeq;
//     			
//     			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
//     			
//     			if (enableFlag) {
//     				toggleButtons("INIT");
//     			} else {
//     				toggleButtons("READONLY");
//     			}
//     		}
//     	}
//     	
//     	function tabClearSheet() {
//     		var formObject = document.form;
//     		
//     		formObject.svc_scp_cd.value = "";
//     		formObject.gline_seq.value = "";
//     		
//     		sheetObjects[0].RemoveAll();
//     		sheetObjects[1].RemoveAll();
//     		
//     		toggleButtons("CLEAR");
//     	}
//     	
//     	var enableFlag = true;
//     	function tabEnableSheet(flag) {
//     		var formObject = document.form;
//     		
//     		enableFlag = flag;
//     		
//     		sheetObjects[0].Editable = flag;
//     		sheetObjects[1].Editable = flag;
//     		
//     		if (enableFlag) {
//     			toggleButtons("INIT");
//     		} else {
//     			toggleButtons("READONLY");
//     		}
//     	}
         
         /**
          * 메인화면에서 호출한다.<br>
          * 메인화면에서 탭화면을 활성화시킨다.<br>
          * <br><b>Example :</b>
          * <pre>
          *     tabLoadSheet(qttn_no, qttn_ver_no, svc_scp_cd, eff_dt, exp_dt, isAproUsr)
          * </pre>
          * @param {String} qttn_no   	
          * @param {String} qttn_ver_no 
          * @param {String} svc_scp_cd 
          * @param {String} eff_dt 
          * @param {String} exp_dt 
          * @param {boolean} isAproUsr  권한이 있는지 여부
          * @return 없음
          * @author 이승준
          * @version 2009.06.10
          */
         function tabLoadSheet(sSvcScpCd, sGlineSeq, isAproUsr) {
     		var formObject = document.form;
     		
     		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
     			formObject.svc_scp_cd.value = sSvcScpCd;
     			formObject.gline_seq.value = sGlineSeq;
     			
     			// Surcharge combo
//     			formObject.f_cmd.value = COMMAND12;
//     			formObject.etc1.value = sSvcScpCd;
//     			
//				var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObject));
//				setIBCombo(sheetObjects[1],sXml,"chg_cd",true,0,"","",true);
     			
     			formObject.etc1.value = sSvcScpCd;
     			initComboChargeCode(sheetObjects[1], formObject);
     			
				// Surcharge combo
     			
     			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
     			
     			if (enableFlag && isAproUsr) {
     				toggleButtons("INIT");
     			} else {
     				toggleButtons("READONLY");
     			}
     		}
     	}
         
         
         /**
          * SURCHARGE 코드를 초기세팅하는  function <br>
          * SCOPE CODE별로 SURCHARGE목록을 가져온다.  <br>
          * <br><b>Example :</b>
          * <pre>
          *	initComboChargeCode(sheetObj, formObj);
          * </pre>
          * @param {ibsheet} sheetObj 필수 IBSheet Object
          * @param {form} formObj	필수 form Object
          * @return 없음
          * @author 이승준
          * @version 2009.07.02
          */
      	function initComboChargeCode(sheetObj, formObj) {
      		var sCd = "";
      		var sNm = "";
      		formObj.f_cmd.value = COMMAND12;
      		var tXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + formObj.svc_scp_cd.value);
      		var arrData = ComPriXml2ComboString(tXml, "cd", "nm");
      		if (arrData != null){
      		    var arrCode = arrData[0].split("|");
      		    var arrName = arrData[1].split("|");
      		    var conData = "";

      		    for(i=0; i < arrName.length;i++){
      		        if(i==0){
      		            arrName[i] = arrCode[i]+"\t"+arrName[i];
      		        }else{
      		            arrName[i] = "|"+arrCode[i]+"\t"+arrName[i];
      		        }
      		        conData = conData.concat(arrName[i]);
      		    }
      		
      		    arrData[1] = conData;
      		}
      					
      		if (arrData != null){
      			sCd = " |" + arrData[0];
      			sNm = " |" + arrData[1];			        
      		} else {
      			sCd = " |";
      			sNm = " |";
      		}
      		
      		sChgCdVisiable = sNm;
      		
      		sheetObj.InitDataCombo(0,"chg_cd", sNm, sCd,"", "", 0, "", "", sChgCdVisiable);
      	}
         
      	
      	/**
 	    * OnChange 이벤트 발생시 호출되는 function <br>
 	    * COMMBO에 없는 코드를 입력할 경우 서버를 검색해서 데이터가 존재하면 코드값을 화면에 출력하는 function  <br>
 	    * <br><b>Example :</b>
 	    * <pre>
 	    *
 	    * </pre>
 	    * @param {ibsheet} sheetObj 필수 IBSheet Object
 	    * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 	    * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 	    * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
 	    * @return 없음
 	    * @author 이승준
 	    * @version 2009.04.17
 	    */  
 	    function sheet2_OnChange(sheetObj, Row, Col, Value) {
 			var colName = sheetObj.ColSaveName(Col);
 			var formObj = document.form;
 			
 			switch(colName)
 	    	{
 				case "chg_cd":					
 					if (Value != null && Value != "" && Value.length == 3) {
 						var sCode = sheetObj.GetComboInfo(0, "chg_cd", "Code");
 						var sText = sheetObj.GetComboInfo(0, "chg_cd", "Text");

 						if (sChgCdVisiable.indexOf("|"+Value) < 0) {
 							formObj.f_cmd.value = COMMAND09;
 							formObj.etc1.value = Value;
 							sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
 							
 							var arrData = ComPriXml2Array(sXml, "cd|nm");
 							if (arrData != null && arrData.length > 0) {
 								sCode += "|" + Value;
 								sText += "|" + Value;
 								sheetObj.InitDataCombo(0, "chg_cd", sText, sCode, "", "", 0, "", "", sChgCdVisiable);
 								
 								ComShowCodeMessage("PRI01110", formObj.svc_scp_cd.value);
 							} else {
 								sheetObj.CellValue2(Row, "chg_cd") = "";
 							}
 						}
 					} else {
 						sheetObj.CellValue2(Row, "chg_cd") = "";
 					}
 					break;
 	    	}
 			
 		}
      	
      	
         
         /**
          * 메인화면에서 호출한다.<br>
          * 메인화면에서 탭화면을 초기화시킨다.<br>
          * <br><b>Example :</b>
          * <pre>
          *     tabClearSheet()
          * </pre>
          * @param 없음 
          * @return 없음
          * @author 이승준
          * @version 2009.06.10
          */
     	function tabClearSheet() {
     		var formObject = document.form;
     		
     		formObject.svc_scp_cd.value = "";
     		formObject.gline_seq.value = "";
//     		formObject.grp_loc_seq.value = "";
     		
     		sheetObjects[0].RemoveAll();
     		sheetObjects[1].RemoveAll();
     		
     		toggleButtons("CLEAR");
     	}
     	
     	var enableFlag = true;
     	/**
         * 메인화면에서 호출한다.<br>
         * 메인화면에서 탭화면을 초기화시킨다.<br>
         * <br><b>Example :</b>
         * <pre>
         *     tabClearSheet(flag)
         * </pre>
         * @param {String} flag 
         * @return 없음
         * @author 이승준
         * @version 2009.06.10
         */
     	function tabEnableSheet(flag) {
     		var formObject = document.form;
     		
     		enableFlag = flag;
     		
     		sheetObjects[0].Editable = flag;
     		sheetObjects[1].Editable = flag;
     		
     		if (enableFlag) {
     			toggleButtons("INIT");
     		} else {
     			toggleButtons("READONLY");
     		}
     	}
    
    
	/* 개발자 작업  끝 */