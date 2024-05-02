/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6076.js
*@FileTitle : RFA Quotation-Rate CMPB View All
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.19 이승준
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
     * @extends Pri
     * @class ESM_PRI_6076 : ESM_PRI_6076 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6076() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }

    /* 개발자 작업   */


 // 공통전역변수
 var sheetObjects = new Array();
 var sheetCnt = 0;

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
 	
          
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

 				case "btn_retrieve":
 					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
 					break;
 	
 				case "btn1_Close":
 					window.close();
 					break;
 					
 				case "gen_spcl_rt_tp_cd":
 					obj_click();
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
 			//khlee-시작 환경 설정 함수 이름 변경
 			ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
 		}
 		
 		axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
 		
 		setBkgCmOp(document.form);
 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
                     // 높이 설정
                     style.height = 380;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                     //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 15, 100);

                     var HeadTitle1  = "|Seq.|CMDT|Route|Route|Route|Route|Per|CGO\nType|Cur.|Rate|Surcharge|Cost|Cost|CMPB|CMPB\nGuideline|OPB|Diff.";
 					 var HeadTitle2  = "|Seq.|CMDT|Origin|O.Via|D.Via|Dest.|Per|CGO\nType|Cur.|Rate|Surcharge|Cost|Cost|CMPB|CMPB\nGuideline|OPB|Diff.";
 					 var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
 					 InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus,		30,			daCenter,   true,   	"ibflag");

 					InitDataProperty(0, cnt++ , dtSeq,		40,	daCenter,	true,	"seq",						false,	"",	dfNone,		0,	true,true);	
 					InitDataProperty(0, cnt++ , dtData,		68, daLeft,		true,	"prc_cmdt_def_cd",			false,	"",	dfNone,		0,	true,true);	
 					InitDataProperty(0, cnt++ , dtData,		65,	daLeft,		true,	"ori_rout_pnt_loc_def_cd",	false,	"",	dfNone,		0,	true,true);	
 					InitDataProperty(0, cnt++ , dtData,		65,	daLeft,		true,	"ori_rout_via_port_def_cd",false,	"",	dfNone,		0,	true,true);	
 					InitDataProperty(0, cnt++ , dtData,		65,	daLeft,		true,	"dst_rout_via_port_def_cd",false,	"",	dfNone,		0,	true,true);	
 					InitDataProperty(0, cnt++ , dtData,		68,	daLeft,		true,	"dst_rout_pnt_loc_def_cd",	false,	"",	dfNone,		0,	true,true);	
 					
 					InitDataProperty(0, cnt++ , dtData,		40,	daCenter,	true,	"rat_ut_cd",				false,	"",	dfNone,		0,	true,true);	
 					InitDataProperty(0, cnt++ , dtData,		40,	daCenter,	true,	"prc_cgo_tp_cd",			false,	"",	dfNone,		0,	true,true);	
 					InitDataProperty(0, cnt++ , dtData,		40,	daCenter,	true,	"curr_cd",					false,	"",	dfNone,		0,	true,true);	
 					InitDataProperty(0, cnt++ , dtData,		72,	daRight,	true,	"qttn_rt_amt",				false,	"",	dfNullFloat,2,	true,true);	
 					
 					InitDataProperty(0, cnt++ , dtData,		72,	daRight,	true,	"prs_scg_amt",				false,	"",	dfNullFloat,2,	true,true);	//surcharge
 					InitDataProperty(0, cnt++ , dtData,		72,daRight,		true,   "prs_respb_cm_uc_amt",		false,	"",	dfNullFloat,2,	false,	false);//CM Cost
 					InitDataProperty(0, cnt++ , dtData,		72,daRight,		true,   "prs_respb_opfit_uc_amt",	false,	"",	dfNullFloat,2,	false,	false);//OP Cost
 					InitDataProperty(0, cnt++ , dtData,		72,daRight,		true,   "prs_respb_cmpb_amt",		false,	"",	dfNullFloat,2,	false,	false);//CMPB
 					InitDataProperty(0, cnt++ , dtData,		72,daRight,		true,   "prs_gid_cmpb_amt",  		false,	"",	dfNullFloat,2,	false,	false);//Guideline
 					InitDataProperty(0, cnt++ , dtData,		72,daRight,		true,   "prs_respb_opb_amt",  		false,	"",	dfNullFloat,2,	false,	false);//OPB											
 					InitDataProperty(0, cnt++ , dtData,		72,daRight,		true,   "diff",  					false,	"",	dfNullFloat,2,	false,	false);//diff		
					
 					CountPosition = 0;
// 					FrozenCols = 5;
 					Ellipsis = true;
 					ColHidden("prs_respb_opfit_uc_amt") = true;
 					ColHidden("prs_respb_opb_amt") = true;
 					WaitImageVisible = false;
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

            case IBSEARCH:      //조회
 				switch (sheetObj.id){
 					case "sheet1":
 						try {
 							ComOpenWait(true);
	 						formObj.f_cmd.value = SEARCH01;
		 	 				// ComGetPrefixParam("sheet1_"); 		 			
		 		            sheetObj.DoSearch("ESM_PRI_6076GS.do", FormQueryString(formObj));
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
 						break;
 				}
 				break;

         }
     }

     /**
      * radio버튼 click 이벤트 발생시 호출되는 function <br>
      * <br><b>Example :</b>
      * <pre>
      *     
      * </pre>
      * @param 없음
      * @returns 없음
      * @author 이승준
      * @version 2009.04.17
      */ 	
    function obj_click()
   	{	 		
   		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
   	}
   	
    /**
     * radio버튼 click 시 히든 값에 선택한 라디오 버튼의 값을 세팅한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     setBkgCmOp(formObj)
     * </pre>
     * @param {form} formObj 필수 html form object
     * @returns 없음
     * @author 이승준
     * @version 2009.04.17
     */ 	
   	function setBkgCmOp(formObj) {
   		
   		var bkgCmOp = formObj.bkg_cm_op.value;
   		
   		if(bkgCmOp == "CM") {
  			sheetObjects[0].ColHidden("prs_respb_cm_uc_amt")  = false;
  			sheetObjects[0].ColHidden("prs_gid_cmpb_amt")  = false;
  			sheetObjects[0].ColHidden("diff")  = false;

  			sheetObjects[0].ColHidden("prs_respb_opfit_uc_amt")  = true;
  			sheetObjects[0].ColHidden("prs_respb_opb_amt")  = true;
  		} else {
  			sheetObjects[0].ColHidden("prs_respb_cm_uc_amt")  = true;
  			sheetObjects[0].ColHidden("prs_gid_cmpb_amt")  = true;
  			sheetObjects[0].ColHidden("diff")  = true;

  			sheetObjects[0].ColHidden("prs_respb_opfit_uc_amt")  = false;
  			sheetObjects[0].ColHidden("prs_respb_opb_amt")  = false;
  		}
   		
  	}
  	
   	/**
     * sheet에서 조회가 끝난 후 호출됨.<br>
     * sheet의 특정 컬럼의 text을 tool tip으로 보여준다.<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet1_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
  	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
  		var sheetObj = sheetObjects[0];

        for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i < sheetObj.LastRow; i++) {
            for (var j = 4; j < 11; j++) {
                sheetObj.ToolTipText(i, j) = sheetObj.CellValue(i, j);
            }
        }
    }
    
    /* 개발자 작업  끝 */