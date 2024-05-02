/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0496.js
*@FileTitle : T/S Remain Status by Location
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.26 최영희
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
     * @class esm_bkg_0496 : esm_bkg_0496 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0496() {
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
var prefix1="sheet1_";
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

							case "btn_retrieve":  
								if (validateForm(sheetObject,formObject,IBSEARCH)) {
									formObject.cnmv_sts_cds.value="";
									formObject.cntr_tpsz_cds.value="";
									if (!ComIsEmpty(formObject.cnmv_sts_cd1.value)){
										formObject.cnmv_sts_cds.value=formObject.cnmv_sts_cd1.value+"|";
									}
									if (!ComIsEmpty(formObject.cnmv_sts_cd2.value)){
										formObject.cnmv_sts_cds.value+=formObject.cnmv_sts_cd2.value+"|";
									}
									if (!ComIsEmpty(formObject.cnmv_sts_cd3.value)){
										formObject.cnmv_sts_cds.value+=formObject.cnmv_sts_cd3.value+"|";
									}
									if (ComIsEmpty(formObject.cnmv_sts_cd1.value) && ComIsEmpty(formObject.cnmv_sts_cd2.value)
										&& ComIsEmpty(formObject.cnmv_sts_cd3.value)){
										formObject.cnmv_sts_cds.value="TS|TN|EN|";
									}
									if (!ComIsEmpty(formObject.cntr_tpsz_cd1.value)){
										formObject.cntr_tpsz_cds.value=formObject.cntr_tpsz_cd1.value+"|";
									}
									if (!ComIsEmpty(formObject.cntr_tpsz_cd2.value)){
										formObject.cntr_tpsz_cds.value+=formObject.cntr_tpsz_cd2.value+"|";
									}
									if (!ComIsEmpty(formObject.cntr_tpsz_cd3.value)){
										formObject.cntr_tpsz_cds.value+=formObject.cntr_tpsz_cd3.value+"|";
									}
									if (!ComIsEmpty(formObject.cntr_tpsz_cd4.value)){
										formObject.cntr_tpsz_cds.value+=formObject.cntr_tpsz_cd4.value+"|";
									}
									if (!ComIsEmpty(formObject.cntr_tpsz_cd5.value)){
										formObject.cntr_tpsz_cds.value+=formObject.cntr_tpsz_cd5.value+"|";
									}
									doActionIBSheet(sheetObject,document.form,IBSEARCH);
								}
							break; 
							
							case "btn_downExcel":
								 doActionIBSheet(sheetObject,document.form,IBDOWNEXCEL);
							break; 

							case "btn_VVDAssign": 
							    var param="?pgmNo=ESM_BKG_0387&relay="+formObject.loc_cd.value+formObject.loc_yd_cd.value;
								param+="&etbFrom="+formObject.vps_etb_dt.value+"&etbTo="+formObject.vps_etd_dt.value;
								param+="&nextVvd="+ComGetObjValue(formObject.next_vvd);
								param+="&pgmNo=ESM_BKG_0387";
							   
								if (ComChkLen(formObject.loc_cd,5)!=2){
									ComShowCodeMessage("BKG00461");
								}else{ 
									ComOpenWindowCenter("/hanjin/ESM_BKG_0387Pop.do"+param, "myWin", 1010,680, true);
								}
							break;
							
							case "btn_loc_cd":
								var param="?loc_cd="+formObject.loc_cd.value; 
							    param+="&pgmNo=COM_ENS_061";
						        ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 780, 470, 'getCOM_ENS_061', '1,0,1,1,1,1,1,1,1,1,1,1', true);

							break;

							case "btns_calendar":
								var cal = new ComCalendarFromTo();
								cal.select(formObject.vps_etb_dt, formObject.vps_etd_dt,'yyyy-MM-dd');
							break;

							case "btn_yard_sum":
								formObject.cnmv_sts_cds.value="";
								formObject.cntr_tpsz_cds.value="";
								if (!ComIsEmpty(formObject.cnmv_sts_cd1.value)){
									formObject.cnmv_sts_cds.value=formObject.cnmv_sts_cd1.value+"|";
								}
								if (!ComIsEmpty(formObject.cnmv_sts_cd2.value)){
									formObject.cnmv_sts_cds.value+=formObject.cnmv_sts_cd2.value+"|";
								}
								if (!ComIsEmpty(formObject.cnmv_sts_cd3.value)){
									formObject.cnmv_sts_cds.value+=formObject.cnmv_sts_cd3.value+"|";
								}
								if (ComIsEmpty(formObject.cnmv_sts_cd1.value) && ComIsEmpty(formObject.cnmv_sts_cd2.value)
										&& ComIsEmpty(formObject.cnmv_sts_cd3.value)){
										formObject.cnmv_sts_cds.value="TS|TN|EN|";
									}

								if (!ComIsEmpty(formObject.cntr_tpsz_cd1.value)){
									formObject.cntr_tpsz_cds.value=formObject.cntr_tpsz_cd1.value+"|";
								}
								if (!ComIsEmpty(formObject.cntr_tpsz_cd2.value)){
									formObject.cntr_tpsz_cds.value+=formObject.cntr_tpsz_cd2.value+"|";
								}
								if (!ComIsEmpty(formObject.cntr_tpsz_cd3.value)){
									formObject.cntr_tpsz_cds.value+=formObject.cntr_tpsz_cd3.value+"|";
								}
								if (!ComIsEmpty(formObject.cntr_tpsz_cd4.value)){
									formObject.cntr_tpsz_cds.value+=formObject.cntr_tpsz_cd4.value+"|";
								}
								if (!ComIsEmpty(formObject.cntr_tpsz_cd5.value)){
									formObject.cntr_tpsz_cds.value+=formObject.cntr_tpsz_cd5.value+"|";
								}	
								var nextvvd="";
								if (formObject.next_vvd[0].checked){
									nextvvd=formObject.next_vvd[0].value;
								}else if (formObject.next_vvd[1].checked){
									nextvvd=formObject.next_vvd[1].value;
								}else if (formObject.next_vvd[2].checked){
									nextvvd=formObject.next_vvd[2].value;
								}
								var param="?loc_cd="+formObject.loc_cd.value+"&loc_yd_cd="+formObject.loc_yd_cd.value+"&date="+ComGetNowInfo()
									+"&vps_etb_dt="+formObject.vps_etb_dt.value+"&vps_etd_dt="+formObject.vps_etd_dt.value
								    +"&cnmv_sts_cds="+formObject.cnmv_sts_cds.value+"&cntr_tpsz_cds="+formObject.cntr_tpsz_cds.value
									+"&vps_eta_dt="+formObject.vps_eta_dt.value+"&next_vvd="+nextvvd; 
								param+="&pgmNo=ESM_BKG_0924";
								
								if (ComChkLen(ComTrim(formObject.loc_cd),5)!=2){ 
									ComShowCodeMessage("BKG00461");
								}else if(ComChkLen(ComTrim(formObject.loc_yd_cd),1)==2){ //1자리만입력시 
									ComShowCodeMessage("BKG00269");
								//}else if(ComIsEmpty(formObject.vps_etb_dt)||ComIsEmpty(formObject.vps_etd_dt)){
								//	ComShowCodeMessage("BKG00755"); 
								//}else if(ComGetDaysBetween(formObject.vps_etb_dt.value,formObject.vps_etd_dt.value)>31){ //10일이상시 
								//	ComShowCodeMessage("BKG00756");
								}else{
									ComOpenWindowCenter("/hanjin/ESM_BKG_0924.do"+param, "myWin", 900,420, true);
								}
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
		
		initControl();
		//initDate(document.form);  
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
                    style.height = 335;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(21, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

//                    var HeadTitle1 = "|Sel.|Seq.|Yard CD|Container No.|T/S|F/M|MV|B/L No.|POL|POD|Next\nPort|Former VVD|Lane|ACT Date|Next VVD|Lane|ETD Date|Special|S/Days|Shipper|Consignee";
                    var HeadTitle1 = "|Seq.|Yard CD|Container No.|T/S|F/M|MV|Event Date|B/L No.|POL|POD|Next\nPort|Former VVD|Lane|Next VVD|Lane|ETD Date|Special|S/Days|Shipper|Consignee";


                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++ , dtHiddenStatus,			60,		daCenter,	true,		prefix1+"ibflag");
//					InitDataProperty(0, cnt++ , dtCheckBox,					30,		daCenter,	false,		prefix1+"del_chk",		false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtDataSeq,				30 ,	daCenter,	false,		prefix1+"Seq",				false,			"",      dfNone,			0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtData,					75,		daCenter,	false,		prefix1+"pod_yd_cd",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	false,		prefix1+"cntr_no",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					28,		daCenter,	false,		prefix1+"cntr_tpsz_cd",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					28,		daCenter,	false,		prefix1+"fm",				false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					28,		daCenter,	false,		prefix1+"cnmv_sts_cd",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	false,		prefix1+"act",				false,			"",      dfNone,			0,		false,		true);

					InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	false,		prefix1+"bl_no",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	false,		prefix1+"pol_cd",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	false,		prefix1+"pod_cd",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	false,		prefix1+"next_port",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					95,		daCenter,	false,		prefix1+"frmr_vvd",			false,			"",      dfNone,			0,		false,		true);

					InitDAtaProperty(0, cnt++ , dtData,					50,		daCenter,	false,		prefix1+"frmr_lane",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					90,		daCenter,	false,		prefix1+"next_vvd",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	false,		prefix1+"next_lane",		false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	false,		prefix1+"etd",				false,			"",      dfNone,			0,		false,		true);

					InitDataProperty(0, cnt++ , dtData,					60,		daCenter,	false,		prefix1+"special",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					55,		daRight,	false,		prefix1+"stay_day",			false,			"",      dfInteger,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					240,	daLeft,		false,		prefix1+"sh_nm",			false,			"",      dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,					230,	daLeft,		false,		prefix1+"cn_nm",			false,			"",      dfNone,			0,		false,		true);
					
					Ellipsis = true; //말줄임표시
				}
				break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
		var arrPreFix = new Array("sheet1_");
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

					case IBSEARCH:      //조회
						formObj.f_cmd.value = SEARCH; 
						var sXml = sheetObj.GetSearchXml("ESM_BKG_0496GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
						sheetObj.Redraw = false; 
						sheetObj.LoadSearchXml(sXml); 
						sheetObj.Redraw = true;  
						formObj.cntr_qty.value=ComAddComma(sheetObj.RowCount);
					break;  
					case IBDOWNEXCEL:      // 엑셀다운  
//						sheetObj.SpeedDown2Excel(-1,false,false,"","",false,false,"",false,prefix1+"del_chk|");
						sheetObj.SpeedDown2Excel(-1,false,false,"","",false,false,"",false,"");
					break; 
					 
        }
    }

     /**
      *  화면 날짜 입력폼 초기화 처리
      */
     function initDate(formObj){
    	 with(formObj){
    		 vps_etb_dt.value=ComGetNowInfo();
    		 vps_etd_dt.value=ComGetNowInfo();
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
 	    axon_event.addListenerFormat('keypress','bkg0496_keypress',formObject);  
	    axon_event.addListenerForm  ('beforedeactivate', 'bkg0496_obj_deactivate',  formObject); //- 포커스 나갈때
	    axon_event.addListenerFormat('beforeactivate',   'bkg0496_obj_activate',    formObject); //- 포커스 들어갈때
	    
       
    }        
    
    /*
	 * Activate Event 처리
	 */
	function bkg0496_obj_activate(){
    	//입력Validation 확인하기
    	switch(event.srcElement.name){
    	
	    	case "vps_etb_dt":
	    		ComClearSeparator(event.srcElement);
    			break;
	    	case "vps_etd_dt":
	    		ComClearSeparator(event.srcElement);
    			break; 
    		default:
    			break;
    			 
    	}
    }
	
	/*
	 * Deactivate Event 처리
	 */
    function bkg0496_obj_deactivate(){ 
    	switch(event.srcElement.name){ 
	    	case "vps_etb_dt":
	    		ComAddSeparator(event.srcElement);
    			break;
	    	case "vps_etd_dt":
	    		ComAddSeparator(event.srcElement);
    			break; 
    		default:
    			break; 
    	}
    }


	 /*
	 * KeyPress Event 처리
	 */
    function bkg0496_keypress(){
		obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat; 
	    switch(obj.dataformat){ 
	        case "num": 
	        	ComKeyOnlyNumber(event.srcElement);
	            break;	 
			 case "engup":
                if(obj.name=="cntr_tpsz_cd1" || obj.name=="cntr_tpsz_cd2" 
				 || obj.name=="cntr_tpsz_cd3" ||obj.name=="cntr_tpsz_cd4" 
				 ||obj.name=="cntr_tpsz_cd5" || obj.name=="loc_yd_cd")  
				 ComKeyOnlyAlphabet('uppernum') 
				 else ComKeyOnlyAlphabet('upper');
	            break; 
	    }
	}    
    
	 /*
	 * Location 정보를 가져오는 함수
	 */
	function getCOM_ENS_061(rowArray){
		var formObject = document.form;
		var colArray = rowArray[0]; 
		formObject.loc_cd.value= colArray[3].substring(0,5);
        formObject.loc_yd_cd.value = colArray[3].substring(5); 
	}
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction) {
        with(formObj){
        	switch (sAction) {
        		case IBSEARCH: {
					if (ComChkLen(ComTrim(loc_cd),5)!=2){ 
						ComShowCodeMessage("BKG00461");
						return false;
					}else if(ComChkLen(ComTrim(loc_yd_cd),1)==2){ //1자리만입력시 
						ComShowCodeMessage("BKG00269");
						return false;
					}else if(ComIsEmpty(vps_etb_dt)&&!ComIsEmpty(vps_etd_dt)) {
						ComShowCodeMessage("BKG00156");  //Invalid duration
						vps_etb_dt.focus();
						return false;
					}else if(!ComIsEmpty(vps_etb_dt)&&ComIsEmpty(vps_etd_dt)) {
						ComShowCodeMessage("BKG00156");  //Invalid duration
						vps_etd_dt.focus();
						return false;
					}else if(!ComIsEmpty(vps_etb_dt)&&!ComIsEmpty(vps_etd_dt)&&ComGetDaysBetween(vps_etb_dt.value,vps_etd_dt.value)>30){
						ComShowCodeMessage("BKG00756", "Duration", "30Days");
						vps_etb_dt.focus();
						return false;
					}
					break;
        		}
        	}
        }
        return true;
    }

	/*
	* 체크박스 선택시 같은 B/L 선택
	*/
	function sheet1_OnChange(sheetObj,Row,Col,Value){ 
		CheckSame(sheetObj,Row,Col,Value,prefix1+"del_chk",prefix1+"bl_no");
	} 
	/*
    function CheckSame(sheetObj,Row,Col,Value,ChkCol,SameCol){
		if (sheetObj.ColSaveName(Col)==ChkCol){  
			 var sblNO = sheetObj.CellValue(Row,SameCol);  
			 for (i=1;i<sheetObj.Rows;i++ ){
				 if (sblNO == sheetObj.CellValue(i,SameCol)){
					  sheetObj.CellValue2(i,ChkCol)=Value; 
			     }else{
					 sheetObj.CellValue2(i,ChkCol)=0;
				 }
			 }

		}
	}*/

	/* 개발자 작업  끝 */