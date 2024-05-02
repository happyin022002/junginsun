/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0005.js
*@FileTitle : ISO Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 김석준
*@LastVersion : 1.0
* 2009.04.28 김석준
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
     * @class ees_mst_0005 : ees_mst_0005 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mst_0005() {
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
    
    var strOfcCd = "";

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
       	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
       	 var sheetObject1 = sheetObjects[0];
       	 /*******************************************************/
       	 var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName)
                {
   				case "btn_add":
   					doActionIBSheet(sheetObject1,formObject,IBINSERT);
   				break; 
   				
   				case "btn_delete":
   					if(sheetObject1.FindCheckedRow("Sel")=="")
   					{
   						ComShowCodeMessage("MST00010");
   					}
   					else if(ComShowCodeConfirm("MST00005")) 
   					{ 
   						doActionIBSheet(sheetObject1,formObject,IBDELETE);
   					}
   				break;
   				
   				case "btn_save":
   					if(strOfcCd == "SELCON")
   					{
   						doActionIBSheet(sheetObject1,formObject,IBSAVE);
   					}
   				break;														
   				
   				case "btn_downexcel":
   					sheetObject1.Down2Excel(true);
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
            	ComConfigSheet (sheetObjects[i] );
	
            	initSheet(sheetObjects[i],i+1);
	            //khlee-마지막 환경 설정 함수 추가
            	ComEndConfigSheet(sheetObjects[i]);
            }
        }
         
     	function sheet1_OnLoadFinish(sheetObj){
            sheetObj.WaitImageVisible = false;
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            sheetObj.WaitImageVisible = true;      		
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
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 460;
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

                        var HeadTitle = "||Seq.|ISO Code|Description";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  daCenter, false, "ibflag");
    	                InitDataProperty(0, cnt++ , dtDummyCheck,	30,  daCenter, false, "Sel");
                        InitDataProperty(0, cnt++ , dtDataSeq,    	80,  daCenter, false, "Seq",			false, 	"", dfNone, 0, false,false, -1, false,false);
                        InitDataProperty(0, cnt++ , dtData, 		170, daCenter, false, "iso_cntr_tpsz_cd", true, "", dfNone, 0, false, true, 4, true);
                        InitDataProperty(0, cnt++ , dtData,     	200, daLeft,   false, "iso_cntr_tpsz_nm", true, "", dfNone, 0, true,  true, 50);
                        
                        // ISO 코드는 숫자와 대문자로 구성된다.
                        InitDataValid(0, "iso_cntr_tpsz_cd", vtEngUpOther, "1234567890");
                        // Desciption은 영문과 숫자로 구성된다.
                        InitDataValid(0, "iso_cntr_tpsz_nm", vtEngOther, "1234567890 -");
                   }
                    break;
            }
        }

        // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
			var selrow = sheetObj.SelectRow;
            switch(sAction) 
            {
   			case IBINSERT:      // 입력 : 현재 선택된 컬럼이후에 행추가 함.
   				if ( selrow > 0 )
   				{
   					sheetObj.DataInsert(selrow);
   					sheetObj.SelectCell(selrow+1, 3, true);
   				}
   				else
   				{
   					sheetObj.DataInsert(-1);
   				}
   				
   			break;

   			case IBSEARCH:      //조회
				if(sheetObj.id == "sheet1") {
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);					
					formObj.f_cmd.value = SEARCH;
	 				var xml = "";
	 				xml = sheetObj.GetSearchXml("EES_MST_0005GS.do", FormQueryString(formObj));
	 				sheetObj.LoadSearchXml(xml);
	 				ComOpenWait(false);
				}
   			break;
   			
   			case IBSAVE:        //저장
   					if(sheetObj.id == "sheet1") 
   					{
   						var sel_code = sheetObj.CellValue(selrow,"iso_cntr_tpsz_cd");
   						var cur_code = "";
   						sheetObj.WaitImageVisible=false;
   						ComOpenWait(true);	   						
   						formObj.f_cmd.value = MULTI;
   						if(sheetObj.DoSave("EES_MST_0005GS.do", FormQueryString(formObj)))
   						{
   	   						// 저장 성공시 refresh 처리.
   	   						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
   	   						
   	   						// 마지막 선택한 곳을 찾아서 focus 처리.
   	   		                for(var i=1; i<=sheetObj.RowCount; i++)
   	   		                {
   	   		   	            	cur_code = sheetObj.CellValue(i,"iso_cntr_tpsz_cd");
   	   		   	            	if(sel_code == cur_code)
   	   		   	            	{
   	   		   	            		sheetObj.SelectCell(i, 3, true);
   	   		   	            		ComOpenWait(false);
   	   		   	            		return;
   	   		   	            	}
   	   		                }		// End for
   						}
   						ComOpenWait(false);
   					}
   			break;
   	 		
   		 	case IBDELETE: // 삭제
   		 		ComRowHideDelete(sheetObj, "Sel");
				// 저장 성공시 refresh 처리.
//				doActionIBSheet(sheetObj,document.form,IBSEARCH);
   	   		 	sheetObj.SelectRow = selrow;
   		 		break;
            }
        }

        function sheet1_OnChange(sheetObj, row, col, value)
        {
			if(sheetObj.ColSaveName(col) == "iso_cntr_tpsz_cd")
			{
                if(value.length != 4 && value.length != 0) 
                {
                    // 오류메시지 : You Must Input 4 characters.
                    ComShowCodeMessage("MST01017");
                    sheetObj.CellValue(row,"iso_cntr_tpsz_cd") = "";
                    sheetObj.SelectCell(row, col-1, true);
                    return;
                }
                
                var cur_code = "";
                var sel_code = sheetObj.CellValue(row,"iso_cntr_tpsz_cd");
                
                // sheet내의 키 중복 체크.
                for(var i=1; i<=sheetObj.RowCount; i++)
                {
	               	 if(i != row)		// 자기자신이 아니면 중복체크를 한다.
	               	 {
	   	            	 cur_code = sheetObj.CellValue(i,"iso_cntr_tpsz_cd");
	   	            	 if(sel_code == cur_code)
	   	            	 {
	   	            		 // 오류메시지 : Please check up the ISO CODE. Duplicate ISO CODE !!!
	   	            		 ComShowCodeMessage("MST00002",cur_code);
	   	            		 sheetObj.CellValue(row,"iso_cntr_tpsz_cd") = "";
	   	            		 sheetObj.SelectCell(row, col-1, true);
	   	            		 return;
	   	            	 }
	               	 }
                }		// End for
			}
        }

	/* 개발자 작업  끝 */