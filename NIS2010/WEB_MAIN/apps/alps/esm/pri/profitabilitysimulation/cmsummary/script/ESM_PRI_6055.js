/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6055.js
*@FileTitle : Revenue Lane Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.29 이승준
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
     * @class ESM_PRI_6055 : ESM_PRI_6055 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6055() {
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

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
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
 					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
 					break;
 	
 				case "btn_OK":
 					returnButtonSheetData(formObject);
 					break;

 				case "btn_Close":
 					window.close();
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
      */
     function setSheetObject(sheet_obj){

        sheetObjects[sheetCnt++] = sheet_obj;

     }
 	
 	function loadPage() {
 		for(i=0;i<sheetObjects.length;i++){
 			//khlee-시작 환경 설정 함수 이름 변경
 			ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
 			
 		}
 		axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
 		
 		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
 		
 		setRevCd(sheetObjects[0],document.form);
     }
 	
   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
         switch(sheetObj.id) {
             case "sheet1":      // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 140;
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

                     var HeadTitle1  = "|Sel.|Seq.|Code|Description";
 					 var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false, false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		
                     //KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, 
                     //SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,   false,  "ibflag");
 					 InitDataProperty(0, cnt++ , dtCheckBox,	 40,	daCenter,	true,	"chk",			  false,	"",	dfNone,	0,	true, true);	
 					 InitDataProperty(0, cnt++ , dtSeq,			 40,	daCenter,	true,	"seq",	  		  false,	"",	dfNone,	0,	false,false);	
 					 InitDataProperty(0, cnt++ , dtData,70, daCenter,true,"rlane_cd",false,"",dfNone,0,false,false);	
 					 InitDataProperty(0, cnt++ , dtData,100,daLeft,	 true,"rlane_nm",false,"",dfNone,0,false,false);	
 					
// 					
// 					 CountPosition = 0;
//
// 					 PopupImage  =  "img/btns_search.gif";
// 					 ShowButtonImage = 1;
 			   }
                break;
         }
     }

  // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         
	        case IBCLEAR:      //온로딩시 조회
	     		
	     		if (validateForm(sheetObj,formObj,sAction)) {
	     			formObj.f_cmd.value = SEARCH;
    			    //alert(FormQueryString(formObj));
    			    sheetObj.DoSearch("ESM_PRI_6055GS.do", FormQueryString(formObj));
    			  
	        	}    
	     	    break;
                
         	case IBSEARCH:      //조회
         		
         		if (validateForm(sheetObj,formObj,sAction)) {
         			formObj.f_cmd.value = SEARCH;
    			    //alert(FormQueryString(formObj));
    			    sheetObj.DoSearch("ESM_PRI_6055GS.do", FormQueryString(formObj));
    			  
 	        	}    
         	    break;
         	
         }
         
     }


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	  switch (sAction) {
    	  
    	  	case IBCLEAR: //온로딩시 조회
	 			
    	  		if (ComIsEmpty(formObj.trd_cd) && ComIsEmpty(formObj.sub_trd_cd)) {
					return false;
		 		}

				return true;
	 			break;
    	  
	 		case IBSEARCH: // 조회
	 			
//	 			if (ComIsEmpty(formObj.rlane_cd) && ComIsEmpty(formObj.rlane_nm)) {
//	 				ComPriInputValueFailed("input","Code or Description",formObj.rlane_cd);
//					return false;
//		 		} 
		 	
				return true;
	 			break;
	 	
	 			 			
	 	 }

         return true;
     }

     /**
      * SHEET에서 선택된 값을 부모창으로 리턴한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     returnButtonSheetData(formObj);
      * </pre>
      * @return 없음
      * @author 이승준
      * @version 2009.05.19
      */
      function returnButtonSheetData(formObj) {
     	  
    	    var returnData = "";
    	  
//    	    sheetObjects[0].ColumnSort("rlane_cd|rlane_nm","ASC","ASC|ASC"); 
			
			if ( sheetObjects[0].RowCount != 0 ) {

				for (var k = sheetObjects[0].HeaderRows; k <= sheetObjects[0].LastRow; k++) {
	 	               
	 	            if(sheetObjects[0].CellValue(k, "chk") == "1") {
	 	            	if(returnData != "")
	 	            		returnData = returnData + ";" + sheetObjects[0].CellValue(k, "rlane_cd");
	 	            	else
	 	            		returnData = returnData + sheetObjects[0].CellValue(k, "rlane_cd");
	 	            }
	 	        }
				
			}
//			alert(returnData)
			try {
				var obj = new Object();
				
				obj.cd = returnData;
							
				window.returnValue = obj;
				self.close();
			} catch ( e ){}
      }
      
      
      /**
       * opener로 값을 리턴하는 기능 구
       * opener의 폼 element로 리턴하는 경우는 settingData함수를 사용하고,
       * opener의 IBSheet로 리턴하는 경우는 settingDataIBSheet를 사용합니다.
       * 사용방법은 동일하지만 두 함수 내에서 처리하는 로직만 다릅니다.
       * 둘중 하나만 사용한다 .
       */
      function sheet1_OnDblClick(sheetObj, Row, Col) {

      	try{    	
      	   	 var obj = new Object(); 
      	   	   
      	   	 obj.cd = sheetObj.CellValue(Row, "rlane_cd");
      	   	 obj.nm = sheetObj.CellValue(Row, "rlane_nm");
      	   	
      	   	 window.returnValue = obj;
      	   	 self.close();

      	   }catch(e){}    
      }
     
      
      //cd Blur
      function rlane_cd_OnBlur(obj) {
      	
      		if(ComIsEmpty(obj.value)) return;
      	
			var rlane_cd = obj.value.toUpperCase();
			//alert(bl_no)
			obj.value = rlane_cd;
			
			
     } 
      
      
      //desc Blur
      function rlane_nm_OnBlur(obj) {
      	
      		if(ComIsEmpty(obj.value)) return;
      	
			var rlane_nm = obj.value.toUpperCase();
			//alert(bl_no)
			obj.value = rlane_nm;
			
			
     }  
      
      
      /**
       * ; 로 연결된 param을 조회된 리스트와 비교하여 같으면 체크해줌 <br>
       * <br><b>Example :</b>
       * <pre>
       *     setRevCd(sheetObj,formObj)
       * </pre>
       * @param {ibsheet} sheetObj 필수 IBSheet Object
       * @param {form} formObj 필수 html form object
       * @return 없음<br>
       * @author 이승준
       * @version 2009.04.17
       */
   	  function setRevCd(sheetObj,formObj) {
   		 //arr
   		 var revCdList = formObj.revCdList.value.split(";");
          
   		 for (var i = 0; i < revCdList.length; i++) {
   			 
   			 var revCd = revCdList[i];
   			//alert(revCd);
 	         for (var k = sheetObj.HeaderRows; k <= sheetObj.LastRow; k++) {
 	               
 	             if(revCd == sheetObj.CellValue(k, "rlane_cd")) {
 	            	 sheetObj.CellValue(k, "chk") = "1";
 	             }
 	         }
   		 }    
     } 

	/* 개발자 작업  끝 */