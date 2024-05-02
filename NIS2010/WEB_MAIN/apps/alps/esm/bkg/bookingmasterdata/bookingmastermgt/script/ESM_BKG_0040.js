/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0040.js
*@FileTitle : BookingMaster
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.05.21 강동윤
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
     * @class esm_bkg_0040 : esm_bkg_0040 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0040() {
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
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setSheetObject(sheet_obj){

        sheetObjects[sheetCnt++] = sheet_obj;

     }



     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {

         for(i=0;i<sheetObjects.length;i++){

         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
 			//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 			
 			initControl();
     }
      
     /**
      * 조회조건 입력할 때 처리
      */
     function obj_KeyUp() {
	     var formObject = document.form;
	     var srcName = window.event.srcElement.getAttribute("name");
	     var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	     var srcValue = window.event.srcElement.getAttribute("value");
	     if (ComChkLen(srcValue, srcMaxLength) == "2") {
	     	ComSetNextFocus();
	     }
     }
          /**
       * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
       * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
       * 
       * @param {ibsheet}
       *            sheetObj IBSheet Object
       * @param {int}
       *            sheetNo sheetObjects 배열에서 순번
       */
      function initControl() {
      	var formObject = document.form;
      	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
          axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
          axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
          axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- 키보드 입력할때
          
          axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
          axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
      }
      
     /**
	 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
	 **/
     function obj_keypress(){
		switch(event.srcElement.dataformat){
	    	case "int":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
		        break;
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "engupnum":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
	    }
	}


   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      //sheet1 init
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
                     InitRowInfo( 1, 1, 3, 100);

                     var HeadTitle1 = "flag|Sel|Seq.|SCAC|Name|Auto|Update|Remark|user_id";
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(8, 0, 0, true);
                     
                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)
                     
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     
                     var prefix="sheet1_";
                     
                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,  	0,     daCenter,    true,     prefix + "ibflag");
                     InitDataProperty(0, cnt++ , dtDelCheck,  		0,     daCenter,    true,     prefix + "del_chk");
                     InitDataProperty(0, cnt++ , dtSeq,	            40,	   daCenter,	true,	  prefix +	"Seq",	            false,	 "",	  dfNone,	    0,	   false,       false);
                     InitDataProperty(0, cnt++ , dtData,	 		70,    daLeft,      true,     prefix + "scac_cd",     		true,    "",      dfEngUpKey, 	0,     false,		true,		4,		true);
                     InitDataProperty(0, cnt++ , dtData,      		400,   daLeft,      true,     prefix + "scac_nm",     		false,    "",      dfNone, 		0,     true,		true);
                     InitDataProperty(0, cnt++ , dtCombo, 	 		40,    daCenter,    true,     prefix + "usa_cstms_file_cd", false,    "",      dfNone, 		0,     true,		true);
                     InitDataProperty(0, cnt++ , dtData,      		100,   daCenter,    true,     prefix + "upd_dt",      		false,    "",      dfDateYmd, 	0,     false,		true);
                     //InitDataProperty(0, cnt++ , dtData, 			70,    daCenter,    true,     prefix + "diff_rmk",    		false,    "",      dfNone, 		0,     true,		true);
                     InitDataProperty(0, cnt++ , dtPopupEdit, 		70,    daCenter,    true,     prefix + "diff_rmk",    		false,    "",      dfNone, 		0,     true,		true);
                     //InitDataProperty(0, cnt++ , dtHidden,  		0,     daCenter,    true,     prefix + "user_id");
                     //InitDataProperty(0, cnt++ , dtHidden,  		0,     daCenter,    true,     prefix + "port_cd");
                     
                     InitDataValid(0, 	3, vtEngUpOther," ");
                     InitDataValid(0, 	4, vtEngUpOther," '-_1234567890/()!@#$%^&*.,");
                     InitDataCombo(0,	prefix + "usa_cstms_file_cd",	"Y|N","Y|N");
                 
                }
                 break;


         }
     }
     
      
   // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
      function processButtonClick(){
           /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
  		         var sheetObject1 = sheetObjects[0];
           /*******************************************************/
           var formObject = document.form;

      	try {
      		var srcName = window.event.srcElement.getAttribute("name");

              switch(srcName) {

  							case "btn_Retrieve":
  								doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  							break;
  							
  							case "btn_new":
  								sheetObject1.RemoveAll();
  								formObject.reset();
  							break;
  							
  							case "btn_save":
  								doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
  							break;				

  							case "btn_add":
  								sheetObject1.DataInsert(-1);
  								//addRowEdit(sheetObjects[0],document.form);
  							break;
  							
  							case "btn_del":
  								doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
  							break;	
  							
  							case "btn_downexcel":
  								sheetObject1.SpeedDown2Excel(-1);
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
      
   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

 					case IBSEARCH:      //조회
						
 						formObj.f_cmd.value = SEARCH;   
 						sheetObj.WaitImageVisible = false;
 						ComOpenWait(true);
						sheetObj.DoSearch("ESM_BKG_0040GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
						
						formObj.tot_count.value = sheetObj.RowCount;											
 					break;
 					
 					case IBSAVE:        //저장
 					
	     				if(!validateForm(sheetObj,formObj,sAction)) {
	    		            return;
	    		        }//end if
	    		        
	    		        formObj.f_cmd.value = MULTI;		        
	    		        sheetObj.WaitImageVisible = false;
 						ComOpenWait(true);
	    		        var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");

	                    sheetObj.DoSave("ESM_BKG_0040GS.do", sParam);
	                    
 					break;
 					
 					case IBDELETE:      // 삭제	 					
	        	        					
	 					ComRowHideDelete(sheetObj, "sheet1_del_chk");	
 					break;
         }
         		ComOpenWait(false);
     }




     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	  
    	for (var i = 1 ; i < sheetObj.RowCount +1 ; i++){
	
	    	if (sheetObj.CellValue(i,2) == ''){
	    						
	    		ComShowCodeMessage("BKG00307");//Please, select & save specific commodity code.
	
	    		sheetObj.SelectCell(i, 1, true, ' '); 
	    						
	    		return false;
	    	}
    					
    	}
    	        
    	if (! sheetObj.IsDataModified){
    	        	
    		ComShowCodeMessage("BKG00249");//No Selected Row
    	        	
    	    return false;
    	}
    	
        return true;
    }

     /**
      * addrow시   데이터 타입설정
     */    
     function addRowEdit(sheetObj,formObj){
   
    	 var Row = sheetObj.SelectRow;
    	 
    	 sheetObj.CellValue2(Row,1) = "1";
    	 
    	 sheetObj.CellEditable(Row, 5) = false;

     }
 
  	/**
      * Insert value check
     */ 
     function chkInsertVal(sheetObj,formObj,Row){
    	 
    	  var Row = sheetObj.SelectRow;
    	  var Col = sheetObj.SelectCol;
	  	
    	  if (sheetObj.CellValue(Row,2) == ''){
    				 
    		  ComShowCodeMessage("BKG00249");//No Selected Row
    				 
    		  sheetObj.SelectCell(Row, 1, true, ' '); 
    				 
    		  return true;
    	  }
 
    	  return false;
     }
     
      /**
       * 조회후  이벤트 처리 >>> 셀 칼라변경
      */ 
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	 
    		with (sheetObj) {
    			var color1 = RgbColor(204, 255, 253);
    			ColBackColor(3) = color1;
    		}
     }
      
      /**
       * popup test
      */ 
      function testPopup(uiNo){
    	  
    	  if (uiNo == '0895'){
    		  var param = ""
    	      var pWin = ComOpenWindow("/hanjin/ESM_BKG_0895.do" + param,"open0895", "statebar=no,width=500,height=520,left=200,top=0");
    	  }else if (uiNo == '0896'){
	    	  var param = "?usrrId=NIS2010&reportId=champ&reportKind=1"
	    	  var pWin = ComOpenWindow("/hanjin/ESM_BKG_0896.do" + param,"open0896", "statebar=no,width=400,height=250,left=200,top=0");
    	  }else if (uiNo == '0753'){
    		  var param = ""
    	      var pWin = ComOpenWindow("/hanjin/ESM_BKG_0753.do" + param,"open0753", "statebar=no,width=920,height=380,left=200,top=0");
    	  }else if (uiNo == '0767'){
    		  var param = ""
    	      var pWin = ComOpenWindow("/hanjin/ESM_BKG_0767.do" + param,"open0767", "statebar=no,width=700,height=570,left=200,top=0");
    	  }
    	  else if (uiNo == '0741'){
    		  var param = ""
    	      var pWin = ComOpenWindow("/hanjin/ESM_BKG_0741.do" + param,"open0741", "statebar=no,width=515,height=335,left=200,top=0");
    	  }
  
      }
       
      
        /**
         * 시트에서 Biz 공통 팝업 호출
         * - comPopupInSheet() 호출 : row, col 정보를 Parameter로 전달  
         */
        function sheet1_OnPopupClick(sheetObj, row, col){   
            if ( sheetObj.ColSaveName(col) == "sheet1_diff_rmk" ){
            	
            	var param = "?row=" + row + "&col=" + col;
                var pWin = ComOpenWindow("/hanjin/ESM_BKG_0934.do" + param,"open0934", "statebar=no,width=300,height=160,left=200,top=0");
            }
        }

        function setCctValue(row,col,value){

        	sheetObjects[0].CellValue2(row,col) = value;
        }
	/* 개발자 작업  끝 */