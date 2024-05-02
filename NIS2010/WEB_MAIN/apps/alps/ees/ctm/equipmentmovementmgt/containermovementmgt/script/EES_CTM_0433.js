/*========================================================= 
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_ctm_04.js
*@FileTitle : Container No. Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.12
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.07.12
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
     * @class ees_ctm_0433 : ees_ctm_0433 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_ctm_0433() {
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

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject = sheetObjects[0];


          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {


 		        case "btn_ok":
                     setCntrNo();
                     break;

                 case "btn_close":
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

         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
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
             case 1:      //t1sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 182;
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

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(8, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle = "|Seq.||Container No.|TP/SZ|Event Date|STS|RCV_TERM";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]



                     InitDataProperty(0, cnt++ , dtHiddenStatus,      0,    daLeft,  false,     "Sta" );
                     InitDataProperty(0, cnt++ , dtDataSeq,      40,    daCenter,  false,     "SEQ");
                     InitDataProperty(0, cnt++ , dtDummyCheck,     30,    daCenter,  false,     "del_chk",     	true,          "",      dfNone, true, true      );
                     InitDataProperty(0, cnt++ , dtData,      120,    daCenter,  false,     "cntr_no",     false,          "",      dfNone, false, false      );
                     InitDataProperty(0, cnt++ , dtData,      45,    daCenter,  false,     "cntr_tpsz_cd",     false,          "",      dfNone, false, false      );
                     InitDataProperty(0, cnt++ , dtData,      120,    daCenter,  false,     "cnmv_evnt_dt",     false,          "",      dfNone, false, false      );

                     InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  false,     "mvmt_sts_cd",     false,          "",      dfNone, false, false      );
                     InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  false,     "rcv_term_cd",     false,          "",      dfNone, false, false      );

                     ScrollBars = 2;


                }
                 break;



         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;


          switch(sAction)
         {

            case IBSEARCH:      //조회
	          	  sheetObj.RemoveAll();
				  ComOpenWait(true);
				  sheetObj.WaitImageVisible = false;
	          	  formObj.f_cmd.value = SEARCH01;
	          	  xml = sheetObj.DoSearch("EES_CTM_0433GS.do", FormQueryString(formObj));
				  ComOpenWait(false);
				  sheetObj.WaitImageVisible = true;
                break;
         }
     }

     function sheet_OnSearchEnd(sheetObj, ErrMsg) {

    	 var opener = window.dialogArguments;
    	 var pSheet = opener.document.form.sheet;
    	 var data1 = pSheet.GetRangeText(pSheet.HeaderRows, 3, pSheet.LastRow, 3);

   		 for(var i = 0; i <= sheetObj.LastRow; i++){
   			 if(data1.indexOf(sheetObj.CellValue(i, "cntr_no").substring(0,10)) != -1){
//   	   			 alert (i + ":::" + arrData0[i] + ":" + data1.indexOf(arrData0[i].substring(0,10)))

   				 sheetObj.CellValue(i, "del_chk") = "1";
   				 sheetObj.RowEditable(i) =  false;
   				 sheetObj.RowBackColor(i) = sheetObj.RgbColor(192,192,192);
   			 }
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
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }

         return true;
     }


 function sheet_OnPopupClick(sheetObj, Row,Col)
 {
     alert("Popup [" + Row + ", " + Col + "]");
 }


 /**
  * 컨테이너 정보를 되돌려주기 위한 메소드.  부모창에 직접 데이타를 세팅하고 팝업이 닫히면 부모창에서 
  * 화면으로 넘겨준다
  */
 function setCntrNo() {

	 var sRowStr = sheetObjects[0].FindCheckedRow("del_chk");
	 var opener = window.dialogArguments;


	 var arr = sRowStr.split("|");
	 var pSheet = opener.document.form.sheet;
	 var evntDt = opener.document.form.p_date0.value;

	 var sheetObj  = sheetObjects[0];
	 var addRow = -1;
	 var iRow = iRow;
	 for (i=0; i<arr.length - 1; i++) {

		 if (sheetObj.RowEditable(arr[i]) ==  false) {
			 if (i == 0 && pSheet.CellValue(pSheet.SelectRow, "cntr_no") == '') {
				 iRow = pSheet.SelectRow;
				 pSheet.RowDelete(pSheet.SelectRow , false);
				 pSheet.SelectRow = iRow - 1;
			 }
			 continue;
		 }
		 if (i != 0)
			 addRow =  pSheet.DataInsert();
		 cntrNo = sheetObj.CellValue(arr[i], "cntr_no");

		 pSheet.CellValue2(addRow, "cntr_no") = cntrNo.substring(0, cntrNo.length-1);
		 pSheet.CellValue2(addRow, "check_digit") = cntrNo.substring(cntrNo.length -1, cntrNo.length);
		 pSheet.CellValue2(addRow, "cntr_tpsz_cd") = sheetObj.CellValue(arr[i], "cntr_tpsz_cd");
		 pSheet.CellValue2(addRow, "prev_sts_cd") = sheetObj.CellValue(arr[i], "mvmt_sts_cd");
		 pSheet.CellValue2(addRow, "bkg_no") = document.form.bkg_no.value;
		 pSheet.CellValue2(addRow, "rcv_term_cd") = sheetObj.CellValue(arr[i], "rcv_term_cd");
		 pSheet.CellValue2(addRow, "cnmv_evnt_dt") = evntDt;
		 pSheet.CellValue2(addRow, "org_yd_cd") = opener.document.form.p_yard1.value + opener.document.form.p_yard2.Code
		 pSheet.CellValue2(addRow, "mvmt_sts_cd") = opener.document.form.p_status.value;
		 pSheet.CellValue2(addRow, "cnmv_yr") = evntDt.substring(0,4);
	 }
//	 opener.ComBtnDisable("btn_select");
	 window.close();
 }
	/* 개발자 작업  끝 */