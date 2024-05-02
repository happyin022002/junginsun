/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0080.js
*@FileTitle : (N.China)I/B Agent Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.06.09 김세일
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
     * @class fns_inv_0080 : fns_inv_0080 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_inv_0080() {
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
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
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

                 case "btn_retrive":
                  	  for (var i = 0; i < formObject.option.length ; i++) {
                        	if (formObject.option[i].checked) {
                        		if (formObject.option[i].value == "V") {
                                    doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                        		} else {
                                    doActionIBSheet(sheetObject2,formObject,IBSEARCH);
                        		}
                        		
                        	}
                        	
                        }
                     break;

                 case "btn_new":

                	 form.ar_ofc_cd.Text = form.ar_ofc_cd2.value;
                	  for (var i = 0; i < formObject.option.length ; i++) {
                     	if (formObject.option[i].checked) {
                     		if (formObject.option[i].value == "V") {
                                sheetObject1.RemoveAll();
                     		} else {
                                sheetObject2.RemoveAll();
                     		}
                     		
                     	}
                     	
                     }
                     
                     break;

 		        case "btn_downExcel":

                 	  for (var i = 0; i < formObject.option.length ; i++) {
                      	if (formObject.option[i].checked) {
                      		if (formObject.option[i].value == "V") {
                      			sheetObject1.Down2Excel();
                      		} else {
                      			sheetObject2.Down2Excel();
                      		}
                      		
                      	}
                      	
                      }
                     
                     break;

                  case "btn_print":
                     alert("btn_print");
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
      * IBSheet Object를 sheetObjects 배열로 등록 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj IBSheet Object
      * @return 없음
      * @see #
      * @author Choi Do Soon
      * @version 2009.11.16
      */
     function setSheetObject(sheet_obj){

        sheetObjects[sheetCnt++] = sheet_obj;

     }



     /** 
      * body 태그의 onLoad 이벤트핸들러 구현 <br>
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  없음
      * @return 없음
      * @see #
      * @author Choi Do Soon
      * @version 2009.11.16
      */
     function loadPage() {

         for(i=0;i<sheetObjects.length;i++){

         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
 			
         }

//         for(k=0;k<tabObjects.length;k++){
//             initTab(tabObjects[k],k+1);
//         }

     }
	
     /** 
      * OnLoadFinish 이벤트 발생시 호출되는 function <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object        
      * @return 없음
      * @see #
      * @author Choi Do Soon
      * @version 2009.11.16
      */  	
     function sheet1_OnLoadFinish(sheetObj) {
     	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01); 		
     }

     /** 
      * Sheet 기본 설정 및 초기화 <br>
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {IBSheet} sheetObj : 시트오브젝트
      * @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
      * @return 없음
      * @see #
      * @author Choi Do Soon
      * @version 2009.11.16
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      //t1sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 440;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(7, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle = "Office|Agent|Vessel|Vessel Name|Customer|Vendor|Update Date";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtData,    110,    daCenter,  true,    "ar_ofc_cd",     false,          "",      dfNone);
                     InitDataProperty(0, cnt++ , dtData,    110,    daCenter,  true,    "agn_cd",     false,          "",      dfNone);
                     InitDataProperty(0, cnt++ , dtData,    110,    daCenter,  true,    "vsl_cd",     false,          "",      dfNone);
                     InitDataProperty(0, cnt++ , dtData,    280,    daLeft,  true,    "vsl_eng_nm",     false,          "",      dfNone);
                     InitDataProperty(0, cnt++ , dtData,    140,    daCenter,  true,    "cust_cd",     false,          "",      dfNone);
                     InitDataProperty(0, cnt++ , dtData,    140,    daCenter,  true,    "vndr_cd",     false,          "",      dfNone);

                     InitDataProperty(0, cnt++ , dtData,    80,    daCenter,  true,    "upd_dt",     false,          "",      dfDateYmd);


                }
                 break;

             case 2:      //t1sheet2 init
             with (sheetObj) {

                 // 높이 설정
                 style.height = 380;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msNone;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = false;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 3, 100);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(7, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, true, true, false,false)

                 var HeadTitle = "Office|Agent|POD|Lane|Customer|Vendor|Update Date";

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtData,    110,    daCenter,  true,    "ar_ofc_cd",     false,          "",      dfNone);
                 InitDataProperty(0, cnt++ , dtData,    110,    daCenter,  true,    "agn_cd",     false,          "",      dfNone);
                 InitDataProperty(0, cnt++ , dtData,    110,    daCenter,  true,    "fdr_pod_cd",     false,          "",      dfNone);
                 InitDataProperty(0, cnt++ , dtData,    280,    daCenter,  true,    "lane_cd",     false,          "",      dfNone);
                 InitDataProperty(0, cnt++ , dtData,    140,    daCenter,  true,    "cust_cd",     false,          "",      dfNone);
                 InitDataProperty(0, cnt++ , dtData,    140,    daCenter,  true,    "vndr_cd",     false,          "",      dfNone);

                 InitDataProperty(0, cnt++ , dtData,    80,    daCenter,  true,    "upd_dt",     false,          "",      dfDateYmd);


            }
             break;

         }
     }

     /** 
      * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj : 시트오브젝트  
      * @param  {object} formObj : 폼 오브젝트
      * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
      * @return 없음
      * @see #
      * @author Choi Do Soon
      * @version 2009.11.16
      */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
	 		case IBSEARCH_ASYNC01: // 화면 로딩시 AR_OFFICE_LIST 조회

			formObj.f_cmd.value = SEARCH02;
	 		//alert(FormQueryString(formObj));
			var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
			//alert(sXml);			
			
			var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
			//alert(sStr);
			var arrStr = sStr.split("|");
			
			MakeComboObject(formObj.ar_ofc_cd, arrStr);
			
			var arrStr2 = arrStr[1].split("^");
			var ar_ofc_cd = arrStr2[3];
	        //alert(ar_ofc_cd);
	        formObj.ar_ofc_cd.text = ar_ofc_cd;
	        formObj.ofc.value = ar_ofc_cd;
	        formObj.ar_ofc_cd2.value = ar_ofc_cd;
	        
	        break;

            case IBSEARCH:      //조회
   			formObj.f_cmd.value = SEARCH01;
            
            formObj.ofc.value = formObj.ar_ofc_cd.text

                if(validateForm(sheetObj,formObj,sAction))

   	 			 sheetObj.DoSearch("FNS_INV_0080GS.do",FormQueryString(formObj)); 

                 break;

 			 case IBSAVE:        //저장
               if(validateForm(sheetObj,formObj,sAction))
                   alert (" Save .. ");
                 break;

 			case IBINSERT:      // 입력
                 break;
         }
     }




     /**
      * IBTab Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++] = tab_obj;

     }


     /**
      * Tab 기본 설정
      * 탭의 항목을 설정한다.
      */
     function initTab(tabObj , tabNo) {
          switch(tabNo) {
              case 1:
                 with (tabObj) {

                 }
              break;

          }
     }

     /**
      * Tab 클릭시 이벤트 관련
      * 선택한 탭의 요소가 활성화 된다.
      */
     function tab1_OnChange(tabObj , nItem)
     {


         var objs = document.all.item("tabLayer");

     	objs[nItem].style.display = "Inline";
     	objs[beforetab].style.display = "none";

     	//--------------- 요기가 중요 --------------------------//
     	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
     	//------------------------------------------------------//
     	beforetab= nItem;
 		

     }



      /** 
       * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
       * <br><b>Example :</b>
       * <pre>
       * </pre>
       * @param  {IBSheet} sheetObj : 시트오브젝트  
       * @param  {object} formObj : 폼 오브젝트
       * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
       * @return true, false
       * @see #
       * @author Choi Do Soon
       * @version 2009.11.16
       */
     function validateForm(sheetObj,formObj,sAction){
          with(formObj){
        	  for (var i = 0; i < formObj.option.length ; i++) {
              	if (formObj.option[i].checked) {
              		if (formObj.option[i].value == "V") {
                        document.getElementById('vessel').style.display='block';
                        document.getElementById('lane').style.display='none';
              		} else {
                        document.getElementById('vessel').style.display='none';
                        document.getElementById('lane').style.display='block';
              			
              		}
              		
              	}
              	
              }
          }

         return true;
     }

      	 function MakeComboObject(cmbObj, arrStr) {
      	 	
   			cmbObj.InsertItem(0,"ALL","ALL");			 
      		 for (var i = 1; i < arrStr.length;i++ ) {
     			var arrStr2 = arrStr[i].split("^");
     			var ar_ofc_cd = arrStr2[1];
     			cmbObj.InsertItem(i, ar_ofc_cd, arrStr[i]);			 
     		}
     		
     		cmbObj.DropHeight = 190;
     	 }       


	/* 개발자 작업  끝 */