/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_3005.js
*@FileTitle : UN No. Help
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.06
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.06 장강철 jkc
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
     * @class vop_scg_3005 : vop_scg_3005 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_3005() {
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
 var ipageNo =1 ;
 var sheetObjects = new Array();
 var sheetCnt = 0;


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

             switch(srcName) {

 				case "btn_ok":
                    comPopupOK();
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
 		// doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

     }
      function sheet1_OnLoadFinish(sheetObj) {
 
          doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
      }
      
      function sheet1_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRows) {
        // alert("PageNo : "+ PageNo+"  OnePageRows : "+OnePageRows );
         doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND,  PageNo);
      } 
    
   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 250;
                     // 전체 너비 설정z
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 9, 100);

                     var HeadTitle = "||UN No./Seq.|UN No./Seq.|Class|Class|Proper Shipping Name|Technical Name|Sub\nRisks|Packing\nGroup|SML Restrictions|imdg_comp_grp_cd";
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo( HeadTitle.split("|").length , 4, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)


                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	"ibflag");
 					InitDataProperty(0, cnt++ , dtRadioCheck,	20,	daCenter,	false,	"checkbox",				    false,	"",		dfNone,			0,			true,		false); 					
 					InitDataProperty(0, cnt++ , dtData,			45,	daCenter,	false,	"imdg_un_no",				false,	"",		dfNone,			0,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,			25,	daCenter,	false,	"imdg_un_no_seq",			false,	"",		dfNone,			0,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	false,	"imdg_clss_cd",				false,	"",		dfNone,			0,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,			20,	daCenter,	false,	"imdg_comp_grp_cd",			false,	"",		dfNone,			0,			false,		false); 					
 					InitDataProperty(0, cnt++ , dtData,			350,daLeft,	    false,	"prp_shp_nm",			    false,	"",		dfNone,			0,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,			150,daLeft,		false,	"imdg_tec_nm",				false,	"",		dfNone,			0,			false,		false);
                    InitDataProperty(0, cnt++ , dtData,         55, daCenter,   false,  "imdg_subs_rsk_lbl_cd",     false,  "",     dfNone,         0,          false,      false); 
 					InitDataProperty(0, cnt++ , dtData,			55,	daCenter,	false,	"imdg_pck_grp_cd",			false,	"",		dfNone,			0,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,			125,daLeft,		false,	"imdg_crr_rstr_expt_nm",	false,	"",		dfNone,			0,			false,		false);
 					InitDataProperty(0, cnt++ , dtHidden,		10, daCenter,	false,	"imdg_comp_grp_cd",	        false,	"",		dfNone,			0,			false,		false); 					
 					
 					SelectionMode = smSelectionRow;
 					ScrollTrack = false;
 					MassOfSearch = true;
 					
 					//SelectBackColor =  RgbColor(255,255,192)

 			   }
                 break;

         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction, PageNo) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

            case IBSEARCH:      //조회
                  if(validateForm(sheetObj,formObj,sAction))

 					   if ( sheetObj.id == "sheet1"){
 							 formObj.f_cmd.value =  SEARCH05; 	
 				             var param           =  FormQueryString(formObj);
 							 var sXml            =  sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", param, "ipage=1", true);
 							 sheetObj.LoadSearchXml(sXml);
 					   }
                 break;

            case IBSEARCHAPPEND:  // 페이징 조회
                 formObj.f_cmd.value = SEARCH05;  
                 var param =  FormQueryString(formObj);
                 sheetObj.DoSearch4Post("SCG_COM_INTERNALGS.do", param, "ipage=" + PageNo, true);
                 break;
         }
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


 	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
 		var k = 0;
 		for(var i=0; i<sheetObj.RowCount; i++) {
 			if (sheetObj.CellValue(i+1, "imdg_pck_grp_cd") == 1) {
 				sheetObj.CellValue(i+1, "imdg_pck_grp_cd") = "I";
 			}else if (sheetObj.CellValue(i+1, "imdg_pck_grp_cd") == 2) {
 				sheetObj.CellValue(i+1, "imdg_pck_grp_cd") = "II";
 			}else if (sheetObj.CellValue(i+1, "imdg_pck_grp_cd") == 3) {
 				sheetObj.CellValue(i+1, "imdg_pck_grp_cd") = "III";
 			}
 			if (sheetObj.CellValue(i+1, "imdg_tec_nm") != "") {
 				k++;
 			}
 		}

 		if (k < 1) {
 			sheetObj.ColHidden("imdg_tec_nm") 	= true;
 			sheetObj.ColWidth("prp_shp_nm") 	= 500;
 		}else{
 			sheetObj.ColHidden("imdg_tec_nm") 	= false;
 			sheetObj.ColWidth("prp_shp_nm") 	= 350;
 			sheetObj.ColWidth("imdg_tec_nm") 	= 150;
 		}
 	}
 	
 
	/* 개발자 작업  끝 */