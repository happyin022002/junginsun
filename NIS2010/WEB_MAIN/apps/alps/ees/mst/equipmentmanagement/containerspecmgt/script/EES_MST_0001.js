/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0001.js
*@FileTitle : Equipment Status Code Creation, Update & Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 김석준
*@LastVersion : 1.0
* 2009.05.06 김석준
* 1.0 Creation
* 2010.07.16 남궁진호 - Pre Sts 저장 후 초기화를 하지않아 Status가 남아있는
                                             현상이 있어 이를 수정함
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
     * @class ees_mst_0001 : ees_mst_0001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mst_0001() {
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

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;
 
 	 /**
 	  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 	  */
     function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];
    	var sheetObject2 = sheetObjects[1];
    	/*******************************************************/
    	var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) 
             {
				case "btn_downexcel":
					sheetObject1.Down2Excel(-1,false,false,true,"","",false,false,"",false,"1");
				break;
				
				case "btn_save":
   					if(strOfcCd == "SELCON")
   					{
   						// 변경여부 체크. : There is no contents to save.
   						if(sheetObject1.IsDataModified == false && sheetObject2.IsDataModified == false)
   						{
   							ComShowCodeMessage("MST00012");
   							return;
   						}
   						
   						doActionIBSheet(sheetObject1,formObject,IBSAVE);
   					}
				break;
				
				case "btn_add":
   					if(strOfcCd == "SELCON")
   					{
   						doActionIBSheet(sheetObject1,formObject,IBINSERT);
   					}
				break;
				
				case "btn_delete":
   					if(strOfcCd == "SELCON")
   					{
	   					if(sheetObject1.FindCheckedRow("Sel")=="")
	   					{
	   						ComShowCodeMessage("MST00010");
	   					}
	   					else if(ComShowCodeConfirm("MST00005")) 
	   					{ 
	   						doActionIBSheet(sheetObject1,formObject,IBDELETE);
	   					}
   					}
				break;
				
				case "btn_add2":
   					if(strOfcCd == "SELCON")
   					{
						if(ComIsEmpty(formObject.cntr_sts_cd)) {
							ComShowCodeMessage("MST01017");
						} else {
							doActionIBSheet(sheetObject2,formObject,IBINSERT);
						}
   					}
				break;
				
				case "btn_delete2":
   					if(strOfcCd == "SELCON")
   					{
	   					if(sheetObject2.FindCheckedRow("Sel")=="")
	   					{
	   						ComShowCodeMessage("MST00010");
	   					}
	   					else if(ComShowCodeConfirm("MST00005")) 
	   					{ 
	   						doActionIBSheet(sheetObject2,formObject,IBDELETE);
	   					}
   					}
				break;							

             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("MST00011",srcName+" Button Fail.");
     		} else {
     			ComShowCodeMessage("MST00011",e);
     		}
     	}
     }

     /**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setSheetObject(sheet_obj)
     {
        sheetObjects[sheetCnt++] = sheet_obj;
     }

     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() 
     {
         for(i=0;i<sheetObjects.length;i++)
         {
        	 //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i]);
             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
     }
      
	function sheet1_OnLoadFinish(sheetObj) 
	{
	    sheetObj.WaitImageVisible = false;
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
   		
   		// 첫번째 선택항목에 대한 cntr_sts_cd를 출력한다.
        var cntr_sts_cd = sheetObjects[0].CellValue(1, "cntr_sts_cd");
        document.form.cntr_sts_cd.value = cntr_sts_cd;
		SheetFiltering(1,cntr_sts_cd,"cntr_sts_cd");
	    sheetObj.WaitImageVisible = true; 		
	}
 	
 	/* ********* User Functions ************* */	
 	/** 
 	 * 클릭 이벤트 발생시 각시트 필터링      
 	 * @param	{Number}	sheetIdx		필터링할 쉬트 인덱스
 	 * @param 	{String}  	keyValue  		필터링할 조건값
 	 * @param 	{Form}  	foreginKey  	keyValue로 필터링될 컬럼 
 	 * 시트가 여러개일시 시트의 프라이머리키와 포린키가 동일한 패턴일 경우만 사용 
 	 */ 
 	function SheetFiltering(sheetIdx,keyValue,foreginKey){ 
		for (var idx=1; idx <= sheetObjects[sheetIdx].RowCount; idx++){
			if(sheetObjects[sheetIdx].CellValue(idx,foreginKey) == keyValue &&
					sheetObjects[sheetIdx].RowStatus(idx) != "D"){
				sheetObjects[sheetIdx].RowHidden(idx) = false;   
			} else {    
				sheetObjects[sheetIdx].RowHidden(idx) = true; 
			}     
		} 	 	    				  
 	}    
 	
	/** 
	 * preStsCd 에서 키값이 공백인 모든 코드를 삭제한다.
	 */
	function deleteInvalidCd()
	{
    	var cur_pre_sts_code = "";			// 현재 preStsCd

    	for(var i=1; i<=sheetObjects[1].RowCount; i++)
		{
			cur_pre_sts_code = sheetObjects[1].CellValue(i,"cntr_pre_sts_cd");
    		if(ComIsEmpty(ComTrim(cur_pre_sts_code)))
    		{
    			sheetObjects[1].CellValue(i,"Sel") = "Y";
    		}
		}
	}


 	/**
 	 * preStsCd 키값이 없는 컬럼을 찾고, 표시한다.
 	 */
    function findEmptyPreStsCd()
    {
    	var cur_sts_code = "";				// 현재 stsCd
    	var sel_sts_code = "";				// 선택된 stsCd
    	var cur_pre_sts_code = "";			// 현재 preStsCd
    	
    	// preStsCd sheet에서 preStsCd값이 empty인 컬럼을 찾는다.
    	for(var i=1; i<=sheetObjects[1].RowCount; i++)
    	{
    		cur_sts_code = sheetObjects[1].CellValue(i,"cntr_sts_cd");
    		cur_pre_sts_code = sheetObjects[1].CellValue(i,"cntr_pre_sts_cd");
    		
    		if(ComIsEmpty(ComTrim(cur_pre_sts_code)))
    		{
    			// 찾은 컬럼의 stsCd값으로 stsCd sheet의 해당위치를 찾는다.
    			for(var k=1; k<sheetObjects[0].RowCount; k++) 
    			{
    				sel_sts_code = sheetObjects[0].CellValue(k,"cntr_sts_cd");
    				
    				// preStsCd 가 empty인 stsCd를  선택하고 preStsCd를 출력한다.
    				if(sel_sts_code == cur_sts_code)
    				{
    					sheetObjects[0].SelectCell(k, 3, true);
    					document.form.cntr_sts_cd.value = cur_sts_code;
    					SheetFiltering(1,cur_sts_code,"cntr_sts_cd");
    					sheetObjects[1].SelectCell(i, 2, true);
    					return;
    				}
    			}
    			return;
    		}
    	}
    	return;
    }

   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) 
     {
         var cnt = 0;

         switch(sheetNo) 
         {
             case 1:      //sheet1 init
                 with (sheetObj) 
                 {
                     // 높이 설정
                     style.height = 419;
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
                     InitColumnInfo(5, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다 
                     InitHeadMode(true, true, true, true, false,false);

                     var HeadTitle = "||Seq.|Code|Description";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);
 					
                     //데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  daCenter, false, "ibflag");
                     InitDataProperty(0, cnt++ , dtDummyCheck,	30,   daCenter,  false,	"Sel");
                     InitDataProperty(0, cnt++ , dtDataSeq,		50,   daCenter,  false,	"Seq",		   false, "", dfNone, 0, false,false, -1, false,false);
                     InitDataProperty(0, cnt++ , dtData,		100,  daCenter,  false,	"cntr_sts_cd",  true, "", dfNone, 0, false, true, 3, true);
                     InitDataProperty(0, cnt++ , dtData,		250,  daLeft,	 false,	"cntr_sts_nm",  true, "", dfNone, 0, true,  true, 50);
                     
                     // CNTR_STS_CD 코드는  대문자로 구성된다.
                     InitDataValid(0, "cntr_sts_cd", vtEngUpOnly);
                     // CNTR_STS_NM 는  숫자와 영문 대문자로 구성된다.
                     InitDataValid(0, "cntr_sts_nm", vtEngUpOther, "1234567890 -");
                }
                 break;

             case 2:      //sheet2 init
                 with (sheetObj) 
                 {
                     // 높이 설정
                     style.height = 402;
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
                     InitColumnInfo(4, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     var HeadTitle = "||Pre Status";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  daCenter, false, "ibflag");
                     InitDataProperty(0, cnt++ , dtDummyCheck,	 30,  daCenter, false, "Sel");
                     InitDataProperty(0, cnt++ , dtData,     	 150, daCenter, false, "cntr_pre_sts_cd",  true, "", dfNone, 0, false, true, 3, true);
                     InitDataProperty(0, cnt++ , dtHidden,     	 50,  daCenter, false, "cntr_sts_cd",     false, "", dfNone, 0, false, true, 3, true);
                     
                     // CNTR_PRE_STS_CD 코드는  대문자로 구성된다.
                     InitDataValid(0, "cntr_pre_sts_cd", vtEngUpOnly);
                     
                     // 필수입력항목이 누락되었을 때의 메시지 처리.
                     sheetObj.MessageText("UserMsg16") = " Is essential to input the item.";
                     
                     CountPosition = 0;
                }
                 break;
         }
     }

      /**
      * Sheet관련 프로세스 처리
      */
     function doActionIBSheet(sheetObj,formObj,sAction) 
     {
         sheetObj.ShowDebugMsg = false;
         // 현재 선택된 row.
         var selrow = sheetObj.SelectRow;
         
         switch(sAction) 
         {
            case IBSEARCH:      //조회
	            sheetObj.WaitImageVisible=false;
	            ComOpenWait(true);
            	formObj.f_cmd.value = SEARCH;

            	var sXml = sheetObj.GetSearchXml("EES_MST_0001GS.do", FormQueryString(formObj));
            	var arrXml = sXml.split("|$$|");
            	
            	if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);
            	if (arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]);
            	ComOpenWait(false);
            break;

			case IBSAVE:        //저장
	            sheetObj.WaitImageVisible=false;
	            			
				formObj.f_cmd.value = MULTI;
				
				var sparam = "";
				
				var sParam1 = sheetObjects[0].GetSaveString(); 
				if (sheetObjects[0].IsDataModified && sParam1 == "") return;
				var sParam2 = sheetObjects[1].GetSaveString(); 
				if (sheetObjects[1].IsDataModified && sParam2 == "")
				{
					// prestatus 값이 없을때, 저장버튼을 선택했을경우 처리.
					findEmptyPreStsCd(sheetObjects[1]);
					return;
				}
				
				if(sheetObjects[0].IsDataModified == true)
				{
					sparam = sParam1 + "&";
				}
				if(sheetObjects[1].IsDataModified == true)
				{
					// 데이터를 구분하기 위해 prefix를 붙인다.
					sParam2 = ComSetPrifix(sParam2,"sub");
					sparam = sparam + sParam2 + "&";
				}
				sparam = sparam + FormQueryString(formObj);
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("EES_MST_0001GS.do", sparam);
				if(sheetObjects[0].IsDataModified == true){
					sheetObjects[0].LoadSaveXml(sXml);
				}else{
					sheetObjects[1].LoadSaveXml(sXml);
				}
            	ComOpenWait(false);
			break;

			case IBINSERT:      // 입력 : 현재 선택된 컬럼이후에 행추가 함.
   				if ( selrow > 0 )
   				{
   					sheetObj.DataInsert(selrow);
   					// 처음 데이터입력치 rowcount 초기화.
					if(sheetObj.RowCount==1) {
						selrow = 0;
					}
   					
   					if(sheetObj.id == "sheet1") {
   						sheetObj.SelectCell(selrow+1, 3, true);
   					} else if(sheetObj.id == "sheet2") {
   						// cntr_sts_cd 지정.
   						sheetObj.CellValue(selrow+1, "cntr_sts_cd") = document.form.cntr_sts_cd.value;
   						sheetObj.SelectCell(selrow+1, 2, true);
   					}
   				}
   				else
   				{
   					sheetObj.DataInsert(-1);
   				}
   			break;
        	 		
   		 	case IBDELETE: // 삭제
   		 		ComRowHideDelete(sheetObj, "Sel");
   		 		var nextrow = selrow + 1;
   		 		var bFind = false;
   		 		if(sheetObj.id == "sheet1")
   		 		{
	   		 		if(sheetObj.RowStatus(selrow) == "D")
	   		 		{
	   		 			// 선택된 row가 마지막 row가 아니면 다음 row를 검사한다.
	   		 			if(selrow != sheetObj.RowCount)
	   		 			{
		   		 			while(nextrow <= sheetObj.RowCount)
		   		 			{
		   		 				// 삭제상태가 아닌 row를 찾았을때.
		   		 				if(sheetObj.RowStatus(nextrow) != "D")
		   		 				{
		   		 					bFind = true;
		   		 					break;
		   		 				}
		   		 				nextrow++;
		   		 			}
	   		 			}
	   		 			
	   		 			// 현재 선택된 라인 이후로는 선택할 row가 없을 때 이전 row를 검사한다.
	   		 			if(bFind == false)
	   		 			{
	   		 				nextrow = selrow - 1;
		   		 			while(nextrow > 0)
		   		 			{
		   		 				if(sheetObj.RowStatus(nextrow) != "D")
		   		 				{
		   		 					break;
		   		 				}
		   		 				nextrow--;
		   		 			}
	   		 			}
	   		 		}
	   		 		else
	   		 		{
	   		 			nextrow--;		// 선택된 row는 현재 row임.
	   		 		}
	   		 		sheetObj.SelectCell(nextrow, 3, true);
	   		 		// preStsCd 에서 키값이 공백인 모든 코드를 삭제한다.
	   		 		deleteInvalidCd();
	   		   		// 삭제 다음항목에 대해 세부항목을 출력한다.
	   	            var cntr_sts_cd = sheetObj.CellValue(nextrow, "cntr_sts_cd");
	   	            document.form.cntr_sts_cd.value = cntr_sts_cd;
	   	            SheetFiltering(1,cntr_sts_cd,"cntr_sts_cd");
   		 		}
	 		break;
         }
     }

     /**
      * sheet1 에서 더블클릭했을 때의 처리
      */
     function sheet1_OnDblClick(sheetObj, row, col, value) 
     {
    	var cntr_sts_cd = sheetObj.CellValue(row, "cntr_sts_cd");
    	// 코드값이 없을때 더블클릭했을 때 오류메시지 처리.
		if(ComIsEmpty(cntr_sts_cd)) {
			ComShowCodeMessage("MST01017");
			sheetObj.SelectCell(row, 3, true);
			return;
		}

        // 선택된 SSC 코드를 넣는다.
        document.form.cntr_sts_cd.value = cntr_sts_cd;
		SheetFiltering(1,cntr_sts_cd,"cntr_sts_cd");
		
		// 선택상태로 변경.
		for (var idx=1; idx <= sheetObjects[1].RowCount; idx++){
			if(sheetObjects[1].RowHidden(idx) == false){
				sheetObjects[1].SelectCell(idx, 2, false);
				return;
			}     
		} 	 	    				  

     }

     /**
      * stsCd 값 체크.
      * @param sheetObj
      * @param row
      * @param col
      * @param value
      * @return
      */
     function sheet1_OnChange(sheetObj, row, col, value)
     {
		if(sheetObj.ColSaveName(col) == "cntr_sts_cd")
		{
             if(value.length != 3 && value.length != 0) 
             {
                 // 오류메시지 : Please check up the CODE.
                 ComShowCodeMessage("MST01017");
                 sheetObj.CellValue(row,"cntr_sts_cd") = "";
                 sheetObj.SelectCell(row, 3, true);
                 return;
             }
             
             var cur_code = "";
             var sel_code = sheetObj.CellValue(row,"cntr_sts_cd");
             
             // sheet내의 키 중복 체크.
             for(var i=1; i<=sheetObj.RowCount; i++)
             {
            	 if(i != row)		// 자기자신이 아니면 중복체크를 한다.
            	 {
            		 cur_code = sheetObj.CellValue(i,"cntr_sts_cd");
            		 if(sel_code == cur_code)
            		 {
            			 // 오류메시지 : 데이터가 중복됩니다.
            			 ComShowCodeMessage("MST00002",cur_code);
            			 sheetObj.CellValue(row,"cntr_sts_cd") = "";
            			 sheetObj.SelectCell(row, 2, true);
            			 return;
            		 }
            	 }
             }		// End for
		}
     }

     /**
     * preStsCd 값 체크.
     * @param sheetObj
     * @param row
     * @param col
     * @param value
     * @return
     */
     function sheet2_OnChange(sheetObj, row, col, value)
     {
    	 if(sheetObj.ColSaveName(col) == "cntr_pre_sts_cd")
    	 {
    		 if(value.length != 3 && value.length != 0) 
    		 {
    			 // 오류메시지 : Please check up the CODE.
                 ComShowCodeMessage("MST01017");
                 sheetObj.CellValue(row,"cntr_pre_sts_cd") = "";
                 sheetObj.SelectCell(row, 2, true);
                 return;
             }
             
             var cur_code = "";
             var sel_code = sheetObj.CellValue(row,"cntr_pre_sts_cd");
             
             // sheet내의 키 중복 체크.
             for(var i=1; i<=sheetObj.RowCount; i++)
             {
            	 if(sheetObj.RowHidden(i)==false && i != row)		// hidden이 아니고,자기자신이 아니면 중복체크를 한다.
            	 {
            		 cur_code = sheetObj.CellValue(i,"cntr_pre_sts_cd");
            		 if(sel_code == cur_code)
            		 {
            			 // 오류메시지 : 데이터가 중복됩니다.
            			 ComShowCodeMessage("MST00002",cur_code);
            			 sheetObj.CellValue(row,"cntr_pre_sts_cd") = "";
            			 sheetObj.SelectCell(row, 2, true);
            			 return;
            		 }
            	 }
             }		// End for
    	 }
     }

     /* 개발자 작업  끝 */