/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6039.js
*@FileTitle : CMPB Guideline- SVC Lane
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.07 이승준
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
     * @class ESM_PRI_6001 : ESM_PRI_6001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6039() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
//    	this.validateForm 			= validateForm;
    }
    
    /* 개발자 작업	*/


    // 공통전역변수
 var sheetObjects = new Array();
 var sheetCnt = 0;

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
          
 		    
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

 				case "btn1_OK":
 					//window.returnValue = "C";
 					doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
 					//if (sheetObjects[0].IsDataModified) {
 	            		window.returnValue = "O";
 	    			//}
					window.close();
 					break;

 				case "btn1_Close":  
 	            	window.returnValue = "C";
 	            	if (sheetObjects[0].IsDataModified) {
 	            		window.returnValue = "O";
 	    			}
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
 			ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
 			
 		}
 		
 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 		setVslCd(sheetObjects[0],document.form);
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
         switch(sheetObj.id) {
             case "sheet1":      // sheet1 init
                 with (sheetObj) {
                     
                     style.height = 250;
                     
                     SheetWidth = mainTable.clientWidth;

                     
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     
                     MergeSheet = msHeaderOnly;

                     
                     Editable = true;

                     
                     InitRowInfo(1, 1, 15, 100);

                     var HeadTitle1  = "|Sel.|Seq.|Code|Description|svc_scp_cd|cre_ofc_cd|gline_seq|prs_cust_tp_cd|bse_seq";
 					 var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					
                     InitColumnInfo(headCount, 0, 0, true);

                     
                     InitHeadMode(true, true, true, true, false,false)

                     
                     InitHeadRow(0, HeadTitle1, true);

                     // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
 	 				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
 	 				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
 	 				// SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,   false,  "ibflag");
 					 InitDataProperty(0, cnt++ , dtCheckBox,	 40,	daCenter,	true,	"chk",			  false,	"",	dfNone,	0,	true, true);	
 					 InitDataProperty(0, cnt++ , dtSeq,			 40,	daCenter,	true,	"seq",	  		  false,	"",	dfNone,	0,	false,false);	
 					 InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,	true,	"vsl_slan_cd",	  false,	"",	dfNone,	0,	false,false);
 					 InitDataProperty(0, cnt++ , dtData,		 160,	daLeft,		true,	"vsl_slan_nm",	  false,	"",	dfNone,	0,	false,false);
 					 InitDataProperty(0, cnt++,  dtHidden, 		 90, 	daLeft, 	false,  "svc_scp_cd", 	  true, 	"", dfNone, 0,  false, false);
	   				 InitDataProperty(0, cnt++,  dtHidden, 		 90, 	daLeft, 	false,  "cre_ofc_cd", 	  true, 	"", dfNone, 0,  false, false);
	   				 InitDataProperty(0, cnt++,  dtHidden, 		 90, 	daLeft, 	false,  "gline_seq", 	  true, 	"", dfNone, 0,  false, false);
	   				 InitDataProperty(0, cnt++,  dtHidden, 		 90, 	daLeft, 	false,  "prs_cust_tp_cd", true, 	"", dfNone, 0,  false, false);
	   				 InitDataProperty(0, cnt++,  dtHidden, 		 90, 	daLeft, 	false,  "bse_seq", 		  true, 	"", dfNone, 0,  false, false);
	   				 
 					 CountPosition = 0;

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
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         
	       	case IBSEARCH:      
         		
     			formObj.f_cmd.value = SEARCH;
			    sheetObj.DoSearch("ESM_PRI_6039GS.do", FormQueryString(formObj));
    			  
         	    break;
         	
	       	case IBSAVE:        
        		
				sheetObjects[0].ColumnSort("vsl_slan_cd|vsl_slan_nm","ASC","ASC|ASC"); 
				
				if ( sheetObjects[0].RowCount != 0){

					 var sXml = ComMakeSearchXml(sheetObj, false, "chk", "svc_scp_cd|cre_ofc_cd|gline_seq|prs_cust_tp_cd|bse_seq|vsl_slan_cd", true);
					 dialogArguments.setSheetXml(sXml, 4);
					
				}
	            break; 		
         }
         
     }


     /**
      * | 로 연결된 param을 조회된 리스트와 비교하여 같으면 체크해줌 <br>
      * <br><b>Example :</b>
      * <pre>
      *     setVslCd(sheetObj,formObj)
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {form} formObj 필수 html form object
      * @return 없음<br>
      * @author 이승준
      * @version 2009.04.17
      */
  	function setVslCd(sheetObj,formObj) {
  		 //arr
  		 var vslCdList = formObj.vslCdList.value.split("|");
         
  		 for (var i = 0; i < vslCdList.length; i++) {
  			 
  			 vslCd = vslCdList[i];
  			
	         for (var k = sheetObj.HeaderRows; k <= sheetObj.LastRow; k++) {
	               
	             if(vslCd == sheetObj.CellValue(k, "vsl_slan_cd")) {
	            	 sheetObj.CellValue(k, "chk") = "1";
	             }
	         }
  		 }    
          
     }

	