/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6084.js
*@FileTitle : PRS-Cost Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.13 송민석
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
     * @class ESM_PRI_6084 : ESM_PRI_6084 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6084() {
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
 
 var isReqUsr = false;
 var isAproUsr = false;

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
 		 var sheetObject2 = sheetObjects[1];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }
                 
                                           
            switch(srcName) {

	            case "btn2_Simulation":
	            	doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC01);
	                break; 
	            case "btn1_OK":
	           	 	doActionIBSheet(sheetObject1, formObject, IBSAVE);
	                break; 	                
	                
	            case "btn1_Close":
	           	 	self.close();
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
        ComOpenWait(true);
        initParams(document.form);
        sheetObjects[1].InLineColor           = sheetObjects[1].RgbColor(188,196,206);  //안쪽선색
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		changeButtonStatus(sheetObjects[0]);
		ComOpenWait(false);

      }

      
  	  /**  
 	   * 팝업이 오픈될때 메인화면으로 부터 받은 초기 파라메터를<BR> 
 	   * 저장해 놓는다.
 	   *  
 	   * <br><b>Example :</b>
 	   * <pre>
 	   *   initParams(formObj)
 	   * </pre>
 	   *
 	   * @param {object} formObj 필수, html document form Object
 	   * @return 없음
 	   */             
      function initParams(formObj){
	   	 var is_req_usr = formObj.is_req_usr.value;
	   	 var is_apro_usr = formObj.is_apro_usr.value;
	   	 if( is_req_usr.toUpperCase() == "TRUE" ){
	   		 isReqUsr = true;
	   	 }
	   	 if( is_apro_usr.toUpperCase() == "TRUE" ){
	   		 isAproUsr = true;
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
         switch(sheetObj.id) {
              case "sheet1":      //sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 150;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 15, 100);

                     var HeadTitle1 = "|Sel.|Seq.|Route|Route|Route|Route|Route|Route|Route|R/D Term|SVC\nLane|T/Time\n(Day/Hour)|Total Cost|rout_sc_no|rout_cs_src_dt|tri_prop_no|amdt_seq|cost_tp";
 					var HeadTitle2 = "|Sel.|Seq.|POR|Inter Change|POL|T/S Route|POD|Inter Change|DEL|R/D Term|SVC\nLane|T/Time\n(Day/Hour)|Total Cost|rout_sc_no|rout_cs_src_dt|tri_prop_no|amdt_seq|cost_tp";
 					var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
 					InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
                     
 					InitDataProperty(0, cnt++ , dtRadioCheck,    	30,   	daCenter,  	true,		"usd_rout_cs_sel_flg",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtSeq,    			30,   	daCenter,  	true,		"seq",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			50,   	daCenter,  	true,		"por_cd",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			80,   	daCenter,  	true,		"ob_itchg_ctnt",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			40,   	daCenter,  	true,		"pol_cd",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			160,   	daCenter,  	true,		"ts_route",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			50,   	daCenter,  	true,		"pod_cd",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			80,   	daCenter,  	true,		"ib_itchg_ctnt",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			50,   	daCenter,  	true,		"del_cd",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			70,   	daCenter,  	true,		"rdterm",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			60,   	daCenter,  	true,		"svc_lane",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			70,   	daCenter,  	true,		"ttl_tztm_hrs",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			0,   	daCenter,  	true,		"respb_usd_ttl_amt",   			false,          "",      dfNullFloat,      		2,			true,       true);
 					
 					InitDataProperty(0, cnt++ , dtData,    			100,   	daCenter,  	true,		"rout_cs_no",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			100,   	daCenter,  	true,		"rout_cs_src_dt",   			false,          "",      dfNone,      		0,			true,       true);

 					InitDataProperty(0, cnt++ , dtData,    			100,   	daCenter,  	true,		"tri_prop_no",   			false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtData,    			100,   	daCenter,  	true,		"amdt_seq",   			false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtData,    			100,   	daCenter,  	true,		"cost_tp",   			false,          "",      dfNone,      		0,			false,       false);
 
 					
 					CountPosition = 0;
                }
                break;

 			   case "sheet2":      //sheet2 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 250;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 15, 100);

                     var HeadTitle1 = "|Node/Link|Activity Group|Cost Element|Amount|Source Data|Source Data|lvl";
 					var HeadTitle2 = "|Node/Link|Activity Group|Cost Element|Amount|Contract|Average|lvl";
 					var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, false, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
 					InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"Status");
                     
 					InitDataProperty(0, cnt++ , dtData,				250,   	daLeft,  	true,		"nod_cd",   			false,          "",      dfNone,      		0,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,    			150,   	daLeft,  	true,		"grp",   			false,          "",      dfNone,      		0,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,    			200,   	daLeft,  	true,		"stnd_cost_nm",   			false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtData,    			70,   	daRight,  	true,		"amt",   			false,          "",      dfNullFloat,      		2,			false,       false);
 					InitDataProperty(0, cnt++ , dtCheckBox,    	80,   	daCenter,  	true,		"ctrt_flg",   			false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtCheckBox,    	0,   	daCenter,  	true,		"avg_flg",   			false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtHidden,    			150,   	daRight,  	true,		"lvl",   			false,          "",      dfNone,      		0,			false,       false);
 					CountPosition = 0;
 					SelectionMode = 0
 					InitTreeInfo("stnd_cost_nm", "stnd_cost_nm", RgbColor(0,0,255), true);
 					
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
 				if ( sheetObj.id == "sheet1"){
 	 				if(!validateForm(sheetObj,formObj,sAction)) return false;
 		            formObj.f_cmd.value = SEARCH01;
 		            sheetObj.DoSearch("ESM_PRI_6084GS.do", FormQueryString(formObj)  );
 				
 				}
 				if ( sheetObj.id == "sheet2"){
 	 				if(!validateForm(sheetObj,formObj,sAction)) return false;
 		            formObj.f_cmd.value = SEARCH02;
 		            var param ="&rout_cs_no=" + sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"rout_cs_no") +"&rout_cs_src_dt="+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"rout_cs_src_dt")
 		            sheetObj.DoSearch("ESM_PRI_6084GS.do", FormQueryString(formObj) +param  );
 				}
 				ComOpenWait(false);
                break;
 			case IBSAVE:        //저장
				if( !validateForm(sheetObj,document.form,sAction) ){
					return false;
				}	
 				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				var r = sheetObj.DoSave("ESM_PRI_6084GS.do",  "f_cmd="+MULTI );
				if( r == true ){
					window.returnValue="SUCCESS";
					self.close();
				}		
				ComOpenWait(false);
				break;
 			case IBSEARCH_ASYNC01:
				var sUrl = "/hanjin/ESM_PRI_6023.do?";
				
				formObj.f_cmd.value = "";
				var param = FormQueryString(formObj) + "&popup_type=TP";
				//체크된 행의 번호를 읽어온다. 결과->"3|5|10|"
				var iCheckRow = sheetObjects[0].FindCheckedRow("usd_rout_cs_sel_flg");
			    //가져온 행을 배열로 반든다.
				var arrRow = iCheckRow.split("|");
				if ( 0 < arrRow.length-1 ){ 
					param = param + "&rout_cs_no=" + sheetObjects[0].CellValue(arrRow[0],"rout_cs_no") +"&rout_cs_src_dt="+sheetObjects[0].CellValue(arrRow[0],"rout_cs_src_dt")
				}
 				sUrl += param;
				var rtnVal = ComOpenWindowCenter(sUrl, "ESM_PRI_6023", 900, 760, true);
				if (rtnVal == "SUCCESS" ){
					window.returnValue="SUCCESS";
					self.close();
 	  			}
				
				break;				
				
				
         }
     }
      
   	/** 
   	 * 현재 화면의 데이터 상태를 고려해 버튼들의 상태를 바꾼다.
  	 * <br><b>Example :</b>
  	 * <pre>
  	 *      changeButtonStatus(sheetObjects[0]);
  	 * </pre>
  	 * @param {object} sheetObj 필수, sheet Object
  	 * @return 없음
  	 */  	      
 	function changeButtonStatus(sheetObj){
		var formObj = document.form;
 
		 
		 
   		if(formObj.prc_prop_sts_cd.value == "I"   ){
   	   		if(isReqUsr || isAproUsr ){   			
   				enableButton("btn2_Simulation");
   				enableButton("btn1_OK");
   	   		}else{
   				disableButton("btn2_Simulation");
   				disableButton("btn1_OK");
   	   		}
   		}else if(formObj.prc_prop_sts_cd.value == "R"){
   	   		if(isReqUsr ){   			
   				enableButton("btn2_Simulation");
   				enableButton("btn1_OK");
   	   		}else{
   				disableButton("btn2_Simulation");
   				disableButton("btn1_OK");
   	   		}
   		}else{
			disableButton("btn2_Simulation");
			disableButton("btn1_OK");
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
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }

         return true;
     }		
         
         
     /** 
      * sheet를 마우스 클릭 했을경우 자동 호출됨 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {object} sheetObj 필수, sheet Object
      * @param {int} row 필수, 클릭된 row index
      * @param {int} col 필수, 클릭된 col index
      * @param {string} value 필수, 클릭된 cell의 값
      * @return 없음
      */            
     function sheet1_OnClick(sheetObj,row, col, value){
    	 doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
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
    	 if( sheetObj.SearchRows != 0){
	    	 var row = sheetObj.FindCheckedRow("usd_rout_cs_sel_flg" ) ;
	    	 if( row != ""){
		    	 row = row.split("|")
		    	 if( row.length > 0 ){
		    		 sheetObj.SelectRow = row[0];
		    		 sheetObj.CellValue2(row[0],"usd_rout_cs_sel_flg") = 'Y';
		    		 doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
		    	 }
	    	 }
	    	 
	    	
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
    function sheet2_OnSearchEnd(sheetObj,ErrMsg){      
     	 //lvl이 0인 데이터의 row color 색깔을 바꿔준다.
     	 var i=sheetObj.HeaderRows;
     	 var offSet = 0;
     	 while( true ) {
     		 i = sheetObj.FindText("lvl", "0",i);
     		 if( i < 0 )
     			 break;
     		 offSet = i;
     		 i++
     	 }
     	 if( offSet != 0 ){
     		 sheetObj.RangeBackColor(sheetObj.HeaderRows, 1, offSet, 7) = sheetObj.RgbColor(255,255,180);
     	 }
      
    	sheetObj.ShowTreeLevel(1, 1);
    }
	/* 개발자 작업  끝 */