/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6017.js
*@FileTitle : S/C Proposal/Amendment Cost Detail by Trans. Mode
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.04 송민석
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
     * @class ESM_PRI_6017 : ESM_PRI_6017 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6017() {
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

 var comboObjects = new Array();
 var comboCnt = 0;
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

	 /** 
	  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	  * <br><b>Example :</b>
	  * <pre>
	  * </pre>
	  *
	  * @return 없음
	  */ 
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
          		case "rout_pnt" :
         			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        			break;
         		case "rate_type" :
         			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        			break;
        			
         		case "btn2_DownExcel":
         			ComPriShowDialogExcel(sheetObject1,ComGetMsg("PRI03002"));
    				break;        			


 				case "btn2_Close":
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
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      *
      * @param  {object}   sheet_obj 필수, sheet Object
      * @return 없음
      */ 
     function setSheetObject(sheet_obj){

        sheetObjects[sheetCnt++] = sheet_obj;

     }

     function setComboObject(combo_obj){
    		comboObjects[comboCnt++] = combo_obj;
     }


     /** 
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * 
      * @return 없음
      */ 
     function loadPage() {

         for(i=0;i<sheetObjects.length;i++){

         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         initControl();         
         initCombo(comboObjects[0])
 		 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

 			

     }
      
      /** 
      * document에서 일어나는 event들의 listener를 정의 한다.. <BR>
      * 
      *
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * 
      * @return 없음
      */  
     function initControl() {
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	    
   }         
     /**  
     * Combo에서 필요한 코드를 조회해서 Combo에 Assign한다.
     * 화면에 Setting 해 놓는다.
     *  
     * <br><b>Example :</b>
     * <pre>
     *   initCombo(comboObj);
     * </pre>
     * 
     * @param {object} comboObj 필수, IBMultiCombo Object
     * @return 없음
     */        
	function initCombo(comboObj) {
 	    switch(comboObj.id) {
 	        case "trans_mode":
 	            var i=0;
 	            with(comboObj) {
 	            	DropHeight = 260;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
 	            }
 	            var formObj = document.form;
 	            formObj.f_cmd.value = SEARCH20;	 			
	 	 		//공통  CD02071 SC RECEIVING TERM CODE
	 			var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do" , FormQueryString(formObj)+"&cd=CD02194");
	 			ComPriXml2ComboItem(sXml, formObj.trans_mode, "cd", "nm");
	 			formObj.trans_mode.InsertItem(0,'','');
 	            break;
 	    }
	}
    /** 
    * 시트 초기설정값, 헤더 정의
    * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @param {String} sheetNo 필수, sheet의 ID
    * @return 없음
    */ 
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;
         sheetObj.WaitImageVisible = false;
         switch(sheetNo) {
             case 1:      // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 240;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 7, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(13, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle1 = "Seq.|Rate Type|Rate Type|Route|Route|Route|Route|Per|CGO Type|Node Link|Trans.Mode|Cost Amount|GRP";
 					var HeadTitle2 = "Seq.|G/Rate|S/Rate|Origin|O. VIA|D. VIA|Dest.|Per|CGO Type|Node Link|Trans.Mode|Cost Amount|GRP";
 					var headCount = ComCountHeadTitle(HeadTitle1);
                    
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
 					
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                     


                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++ , dtData,	    30,     daCenter, 	true,  "seq",		false,	"",		dfNone,			0,		false,	false);
 					InitDataProperty(0, cnt++ , dtCheckBox,	50,		daCenter,	true,	"g_rate_type",		false,	"",		dfNone,			0,		false,	false);
 					InitDataProperty(0, cnt++ , dtCheckBox,	50,		daCenter,	true,	"s_rate_type",		false,	"",		dfNone,			0,		false,	false);
 					InitDataProperty(0, cnt++ , dtData,		75,	    daCenter,	true,	"por_cd",		false,	"",		dfNone,			0,		false,	false);
 					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	"pol_cd",		false,	"",		dfNone,			0,		false,	false); 
                                                                                         
 					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	"pod_cd",		false,	"",		dfNone,			0,		false,	false);
 					InitDataProperty(0, cnt++ , dtData,		75,		daCenter,	true,	"del_cd",			false,	"",		dfNone,			0,		false,	false);
 					InitDataProperty(0, cnt++ , dtData,		35,		daCenter,	true,	"cntr_tpsz_cd",			false,	"",		dfNone,			0,		false,	false);
 					InitDataProperty(0, cnt++ , dtData,		65,		daCenter,	true,	"cgo_tp_cd",		false,	"",		dfNone,			0,		false,	false);
 					InitDataProperty(0, cnt++ , dtData,		200,	daCenter,	true,	"nod",	false,	"",		dfNone,			0,		false,	false);

 					InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	true,	"act_grp_nm",				false,	"",		dfNone,			0,		false,	false);
 					InitDataProperty(0, cnt++ , dtData,		80,	    daRight,	true,	"tot_amt",		false,	"",		dfFloat,		2,		false,	false);
 					InitDataProperty(0, cnt++ , dtHidden,		80,	    daRight,	true,	"grp",		false,	"",		dfNone,		2,		false,	false);
 					

 			}
                 break;

         }
     }

     /** 
      * sheet에 관련된 실제 Action(Retrieve, Add, Delete)을 일으키는 함수
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {object} sheetObj 필수, sheet Object
      * @param {object} formObj 필수, html document form Object
      * @param {int} sAction 필수, action의 구분
      * @return 없음
      */    
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
 					
 			case IBSEARCH:      //조회
 				ComOpenWait(true);
 				if( !validateForm(sheetObj,formObj,sAction)){
 					ComOpenWait(false);
 					return;
 				}
	            formObj.f_cmd.value = SEARCH;
	            sheetObj.DoSearch("ESM_PRI_6017GS.do", FormQueryString(formObj) );
	            ComOpenWait(false);
                break;
 			break; 			
   
         }
     }

 
     /** 
      * sheet를 이용해 조회를 했을경우 조회 완료후 자동 호출됨 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {object} sheetObj 필수, sheet Object
      * @param {String} ErrMsg 필수, sheet의 결과 메시지
      * @return 없음
      */    
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){
   	 
   	 //GRP이 1인 데이터의 row color 색깔을 바꿔준다.
		var rowCount =  sheetObj.LastRow;
		for(var j = sheetObj.HeaderRows;  j <= rowCount; j++ ){
			j = sheetObj.FindText("grp","1",j);
			if( j < 0 ){
				break;
			}
			sheetObj.RangeBackColor(j, sheetObj.SaveNameCol("nod"), j, sheetObj.SaveNameCol("grp")) = sheetObj.RgbColor(255,255,180);
			sheetObj.RowMerge(j)=true // total이란 글자를 merge하기 위해서 사용했다.
		}
    }     
 	

    /** 
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    * <br><b>Example :</b>
    * <pre>
    *      if (!validateForm(sheetObj,document.form,sAction)) {
    *          return false;
    *       }
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @param {object} formObj 필수, html document form Object
    * @param {int} sAction 필수, action의 구분
    *
    * @return boolean, true: 유효, false: 비유효
    */  
     function validateForm(sheetObj,formObj,sAction){
 

         return true;
     }


	/* 개발자 작업  끝 */