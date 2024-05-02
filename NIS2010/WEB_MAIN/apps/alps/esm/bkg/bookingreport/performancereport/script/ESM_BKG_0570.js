/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0570.js
*@FileTitle : C/A B/L Inquery
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.09.28 강동윤
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
     * @class ESM_BKG_0570 : ESM_BKG_0570 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0570() {
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
          
          var sheetObject1 = sheetObjects[0];
          var sheetObject2 = sheetObjects[1];
          var sheetObject3 = sheetObjects[2];
          var sheetObject4 = sheetObjects[3];
  
          
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

 				case "btn_Retrieve":
 				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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

 				//doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
         }

         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         }
         
         initControl();
         
         document.form.bl_no.focus();
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
          
          axon_event.addListener ('keydown', 'ComKeyEnter', 'form');//Enter key 처리
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
                     style.height = 0;
                     //전체 너비 설정
                     SheetWidth = 0;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(20, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle = "||||||||||||||||";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                     InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		"corr_no",			false,		"",		dfNone,			0,		false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		"cust_ref_no",		false,		"",		dfNone,			0,		false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		"bkg_cgo_tp_cd",	false,		"",		dfNone,			0,		false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		"frt_term_cd",	false,		"",		dfNone,			0,		false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		"obl_iss_flg",		false,		"",		dfNone,			0,		false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		"vvd",				false,		"",		dfNone,			0,		false,		false);
                                                                                                                                           
                     InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		"vsl_eng_nm",		false,		"",		dfNone,			0,		false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		"pol_cd",			false,		"",		dfNone,			0,		false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		"por_cd",			false,		"",		dfNone,			0,		false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		"pod_cd",			false,		"",		dfNone,			0,		false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		"del_cd",			false,		"",		dfNone,			0,		false,		false);

                     InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		"eta",				false,		"",		dfNone,			0,		false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		"op_cntr_qty",		false,		"",		dfNone,			0,		false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		"pck_qty",			false,		"",		dfNone,			0,		false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		"pck_tp_cd",		false,		"",		dfNone,			0,		false,		false);                     
                     InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		"act_wgt",			false,		"",		dfNone,			0,		false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		"wgt_ut_cd",		false,		"",		dfNone,			0,		false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		"meas_qty",			false,		"",		dfNone,			0,		false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		"meas_ut_cd",		false,		"",		dfNone,			0,		false,		false);
//                     InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		"mk_desc",			false,		"",		dfNone,			0,		false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		"cmdt_desc",			false,		"",		dfNone,			0,		false,		false);

                }
                 break;
                 
             case 2:      //sheet1 init
             with (sheetObj) {
                 // 높이 설정
                 style.height = 0;
                 //전체 너비 설정
                 SheetWidth = 0;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msNone;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 3, 100);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(18, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, false, true, false,false)

                 var HeadTitle = "|||||||||||||||||";

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);


                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"bkg_cust_tp_cd");
                 InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"cust_cnt_cd");
                 InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"cust_seq");
                 InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"cust_nm");
                 InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"cust_addr");
                 InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"cust_tel");
                 InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"cust_fax_no");     
                 
            }
             break;
             
             case 3:      //sheet1 init
             with (sheetObj) {
                 // 높이 설정
                 style.height = 0;
                 //전체 너비 설정
                 SheetWidth = 0;

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
                 InitHeadMode(true, true, false, true, false,false)

                 var HeadTitle = "|Seq.|Container No.|Type|Seal No.|Partial|R|D|Empty / Full|Remark(s)";

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);


                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"mk_seq");
                 InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"loc_ts");
                 InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"mk_desc");
                 InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"cmdt_desc");
                 
            }
             break;
             
             case 4:      //sheet1 init
             with (sheetObj) {
                 // 높이 설정
                 style.height = 300;
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
                 InitColumnInfo(10, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, false, true, false,false)

                 var HeadTitle = "Seq.|Container No.|Type|Seal No.|Partial|R|D|Empty / Full|Remark(s)";

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);


                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 //InitDataProperty(0, cnt++ , dtHiddenStatus,			40,		daCenter,	true,		"ibflag");
                 InitDataProperty(0, cnt++ , dtSeq,						40,		daCenter,	true,		"Seq");
                 InitDataProperty(0, cnt++ , dtData,					150,	daCenter,	false,		"cntr_no",			false,		"",		dfNone,			0,		false,		false);
                 InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	false,		"cntr_tpsz_cd",		false,		"",		dfNone,			0,		false,		false);
                 InitDataProperty(0, cnt++ , dtComboEdit,				130,	daCenter,	true,		"com_seal_no",		false,		"",		dfNone,			0,		true,		true);
                                                                                                                                       
                 InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	false,		"cntr_prt_flg",		false,		"",		dfDateYmd,		0,		false,		false);
                 InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	false,		"rcv_term_cd",		false,		"",		dfNone,			0,		false,		false);
                 InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	false,		"de_term_cd",		false,		"",		dfNone,			0,		false,		false);
                 InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	false,		"bkg_cgo_tp_cd",	false,		"",		dfNone,			0,		false,		false);
                 InitDataProperty(0, cnt++ , dtData,					200,	daCenter,	false,		"diff_rmk",			false,		"",		dfNone,			0,		false,		false);
                 InitDataProperty(0, cnt++ , dtHidden,					40,		daCenter,	true,		"cntr_seal_no");


						//InitDataCombo(0, "SealNo", "H336722|", "1|");

            }
             break;

         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

         	case IBSEARCH:      //조회
		
         		if(validateForm(sheetObj,formObj,sAction))
        		
        		sheetObj.WaitImageVisible = false;
 				ComOpenWait(true);
 					 			
         		formObj.f_cmd.value = SEARCH;   
	        	    
				var searchXml = sheetObj.GetSearchXml("ESM_BKG_0570GS.do", FormQueryString(formObj));
					
				var sXml = searchXml.split("|$$|");
			
				sheetObjects[0].LoadSearchXml(sXml[0]);
				sheetObjects[1].LoadSearchXml(sXml[1]);
				sheetObjects[2].LoadSearchXml(sXml[2]);
				sheetObjects[3].LoadSearchXml(sXml[3]);

				setBlInq();
				
				ComOpenWait(false);
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

                     var cnt  = 0 ;
                     InsertTab( cnt++ , "Customer" , -1 );
                     InsertTab( cnt++ , "Marks & Desc." , -1 );
                     InsertTab( cnt++ , "CNTR Inquiry" , -1 );

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
         
    	 if (formObj.bl_no.value == ''){

         	ComShowCodeMessage("BKG00609");//Please, Check BL No !	  
         	formObj.bl_no.focus();    		  
   	   		return false;
    	 }
    	  
         return true;
     }

    // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
  	function setBlInq()
  	{
  		var formObj 	= document.form;

  		var sheet1		= sheetObjects[0];
  		var sheet2		= sheetObjects[1];
  		var sheet3		= sheetObjects[2];
  		var sheet4		= sheetObjects[3];
  		
  		var lastRow1 	= sheet1.LastRow;
  		var lastRow2 	= sheet2.LastRow;
  		var lastRow3 	= sheet3.LastRow;
  		var lastRow4 	= sheet4.LastRow;
  		
  	    //MAIN SETTING >>>>>>> Start
  		if (sheet1.CellValue(lastRow1, "corr_no").indexOf("There is no data") == -1)  			  	
  			formObj.corr_no.value 		= sheet1.CellValue(lastRow1, "corr_no");
  		
  		formObj.cust_ref_no.value 	= sheet1.CellValue(lastRow1, "cust_ref_no");	
  		formObj.obl_iss_flg.value 	= sheet1.CellValue(lastRow1, "obl_iss_flg");
  		formObj.frt_term_cd.value   = sheet1.CellValue(lastRow1, "frt_term_cd");
  		formObj.vvd.value 			= sheet1.CellValue(lastRow1, "vvd");
  		formObj.vsl_eng_nm.value 	= sheet1.CellValue(lastRow1, "vsl_eng_nm");
  		formObj.pod_cd.value 		= sheet1.CellValue(lastRow1, "pod_cd");
  		formObj.eta.value 			= sheet1.CellValue(lastRow1, "eta");
  		formObj.pol_cd.value 		= sheet1.CellValue(lastRow1, "pol_cd");
  		formObj.por_cd.value 		= sheet1.CellValue(lastRow1, "por_cd");
  		formObj.del_cd.value 		= sheet1.CellValue(lastRow1, "del_cd");
  		//formObj.op_cntr_qty.value 	= sheet1.CellValue(lastRow1, "op_cntr_qty");
  		formObj.pck_qty.value 		= sheet1.CellValue(lastRow1, "pck_qty");
  		formObj.pck_tp_cd.value 	= sheet1.CellValue(lastRow1, "pck_tp_cd");
  		formObj.act_wgt.value 		= sheet1.CellValue(lastRow1, "act_wgt");
  		formObj.wgt_ut_cd.value 	= sheet1.CellValue(lastRow1, "wgt_ut_cd");  		
  		formObj.meas_ut_cd.value 	= sheet1.CellValue(lastRow1, "meas_ut_cd");
  		formObj.meas_qty.value 		= sheet1.CellValue(lastRow1, "meas_qty");
//  		formObj.cust_ref_no.value 	= sheet1.CellValue(lastRow1, "mk_desc");
  		formObj.cus_desc.value 		= sheet1.CellValue(lastRow1, "cmdt_desc");

  		
  		if (sheet1.CellValue(lastRow1, "bkg_cgo_tp_cd") == "P"){

  			formObj.empty.checked = true;
  		}  		
  		//MAIN SETTING >>>>>>> End
  		
  		//CUSTOMER INFO. SETTING >>>>>>>>>>>> Start
  		if (sheet2.RowCount > 0){
	  		for (var i = 1 ; i <= lastRow2 ; i++){
		  		
	  			if (sheet2.CellValue(i, "bkg_cust_tp_cd") == "S"){
		  			
	  				formObj.s_cnt_cd.value 		= sheet2.CellValue(i, "cust_cnt_cd");
			  		formObj.s_seq.value 		= sheet2.CellValue(i, "cust_seq");
			  		formObj.s_nm.value 			= sheet2.CellValue(i, "cust_nm");
			  		formObj.s_addr.value 		= sheet2.CellValue(i, "cust_addr");
			  		formObj.s_fax.value 		= sheet2.CellValue(i, "cust_fax_no");
	  			}else if (sheet2.CellValue(i, "bkg_cust_tp_cd") == "C"){
			  		
	  				formObj.c_cnt_cd.value 		= sheet2.CellValue(i, "cust_cnt_cd");
			  		formObj.c_seq.value 		= sheet2.CellValue(i, "cust_seq");
			  		formObj.c_nm.value 			= sheet2.CellValue(i, "cust_nm");
			  		formObj.c_addr.value 		= sheet2.CellValue(i, "cust_addr");
			  		formObj.c_fax.value 		= sheet2.CellValue(i, "cust_fax_no");
	  			}else if (sheet2.CellValue(i, "bkg_cust_tp_cd") == "N"){
			  		
	  				formObj.n_cnt_cd.value 		= sheet2.CellValue(i, "cust_cnt_cd");
			  		formObj.n_seq.value 		= sheet2.CellValue(i, "cust_seq");
			  		formObj.n_nm.value 			= sheet2.CellValue(i, "cust_nm");
			  		formObj.n_addr.value 		= sheet2.CellValue(i, "cust_addr");
			  		formObj.n_fax.value 		= sheet2.CellValue(i, "cust_fax_no");
	  			}
	  		}
  		}
  		//CUSTOMER INFO. SETTING >>>>>>>>>>>> End
  		
  		//MARKS&DESC INFO. SETTING >>>>>>>>>>>> Start
  		if (sheet3.RowCount > 0){
	  		for (var i = 1 ; i <= lastRow3 ; i++){
				
	  			ComClearCombo(formObj.mk_seq);
	  			
	  			ComAddComboItem(formObj.mk_seq, sheet3.CellValue(i, "mk_seq"), sheet3.CellValue(i, "mk_seq"));
	  			
	  			if (i == 1){
	  				
	  				formObj.loc_ts.value 		= sheet3.CellValue(i, "loc_ts");
	  				formObj.mk_desc.value 		= sheet3.CellValue(i, "mk_desc");
	  				formObj.cmdt_desc.value 	= sheet3.CellValue(i, "cmdt_desc");
	  			}
			}  		
  		}
  		//MARKS&DESC INFO. SETTING >>>>>>>>>>>> End
  		
  		//CNTR Inquiry INFO. SETTING >>>>>>>>>>>> Start
  		if (sheet4.RowCount > 0){
  			
  			var sealNo = "";
  			
	  		for (var i = 1 ; i <= lastRow4 ; i++){
	  			
	  			sealNo = ComReplaceStr(sheet4.CellValue(i, "cntr_seal_no"), ",", "|");

	  			sheet4.CellComboItem(i, "com_seal_no", sealNo, sealNo);
	  		}
  		}  		
  		//CNTR Inquiry INFO. SETTING >>>>>>>>>>>> End
  	}
  	/*
  	 * Mark Seq Change
  	 */
  	function changeMkSeq(){
  		
  		var formObj = document.form;
  		
  		var sheet3  = sheetObjects[2];
  		
  		var idx 	= formObj.mk_seq.selectedIndex;
    	var mkSeq 	= formObj.mk_seq.options[idx].value;
    	
    	for (var i = 1 ; i <= sheet3.LastRow ; i++){
    		
    		if (sheet3.CellValue(i, "mk_seq") == mkSeq){
    			
    			formObj.loc_ts.value 		= sheet3.CellValue(i, "loc_ts");
  				formObj.mk_desc.value 		= sheet3.CellValue(i, "mk_desc");
  				formObj.cmdt_desc.value 	= sheet3.CellValue(i, "cmdt_desc");
    		}
    		
    		break;
    	}
  	}
    
	/* 개발자 작업  끝 */