/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_7009.js
*@FileTitle : Exception Cost by Yard
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.03
*@LastModifier : Kim Hyun Hwa
*@LastVersion : 1.0
* 2012.08.03 Kim Hyun Hwa
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
     * @class EES_DMT_7009 : EES_DMT_7009 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_7009() {
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

var comboObjects = new Array();
var comboCnt = 0;

    //  업무전역변수
    var COUNTRY     = "CNT";
    var LOCATION    = "LOC";
    var YARD        = "YD";
    
    var ROWMARK     = "|";
    var FIELDMARK   = "=";
    
    var ORIGIN = "Origin";
    var DESTINATION = "Destination";
    
   var IBSEARCH_YD  = 101;
   var IBSEARCH_DUP = 102;
   var IBCONFRIM = 103;
   var IBSEARCH_YARD  = 104;
   var IBCANCEL = 105;
   

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

                    case "btn_retrieve":
                   	
                        doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                        break;

                    case "btn_new":
	                    ComResetAll();
	                    formObject.cfm_cancel.value ="N";
	                    doActionIBCombo(sheetObject1,formObject,comboObjects[0],SEARCHLIST02);
	                    doActionIBCombo(sheetObject1,formObject,comboObjects[1],SEARCH02);
	                    DmtComEnableManyBtns(true,  "btn_new", "btn_retrieve", "btn_confirm","btn_save", "btn_cancel" ); 
                        break;
                        
                    case "btn_save":
                    	doActionIBSheet(sheetObject1,formObject,IBSAVE);

                    	break;
                    	
                    case "btn_confirm":
                    	doActionIBSheet(sheetObject1,formObject,IBCONFRIM);
                    	break;
                    	
                    case "btn_cancel":
                    	doActionIBSheet(sheetObject1,formObject,IBCANCEL);
                   	    break;	

                    case "btn_downExcel":
                    	sheetObject1.speedDown2Excel(-1);
                        break;
                          
                    case "btn_upLoadExcel":
                    	if(sheetObject1.RowCount == 1 && sheetObject1.CellValue(sheetObject1.LastRow ,"seq") != "1") sheetObject1.RemoveAll();

                     	 sheetObject1.LoadExcel();
                     	 setAmountSum(sheetObject1);
                        break;
                         
        			case "btn_add":	
        				if(sheetObject1.RowCount == 1 && sheetObject1.CellValue(sheetObject1.LastRow ,"seq") != "1") sheetObject1.RemoveAll();
        				var insrow = sheetObject1.DataInsert(-1);
        				
        				sheetObject1.CellValue2(insrow, "cre_usr_id") = formObject.cre_usr_id.value;
        				sheetObject1.CellValue2(insrow, "cre_ofc_cd") = formObject.cre_ofc_cd.value;
        				sheetObject1.CellValue2(insrow, "upd_usr_id") = formObject.upd_usr_id.value;
        				sheetObject1.CellValue2(insrow, "upd_ofc_cd") = formObject.upd_ofc_cd.value;
        				sheetObject1.CellValue2(insrow, "curr_cd")    = "USD";
        				sheetObject1.CellValue2(insrow, "dmdt_calc_tp_cd") = ""
        				break;							
        	
        			case "btn_delete":
        				ComRowHideDelete(sheetObject1, "chk_box");
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

    //페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
      
        // IBMultiCombo초기화 
        for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);
        }
       
        //html컨트롤 이벤트초기화
        initControl();
        
        document.form.chk_current_flg.checked = true;
        document.form.chk_current.value ="Y";
        document.form.chk_tobe_flg.checked = true;
        document.form.chk_tobe.value ="Y";
        document.form.chk_expired_flg.checked = false;
        document.form.chk_expired.value ="N";

    }

   // 이벤트 처리 함수 선언
    function initControl() {
        axon_event.addListenerFormat('keypress','obj_keypress', document.form);         //- 키보드 입력할때
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
       // axon_event.addListener('click', 'incl_cntr_click', 'incl_cntr');    // 'Incl. CNTR Column' CheckBox 클릭시
    }
     
    //포커스가 나갈 때
    function obj_blur(){
        
        //입력Validation 확인하기 + 마스크구분자 넣기
        var obj = event.srcElement;
       
        if(obj.value.length > 0 && obj.value.length < 5) {
            ComShowCodeMessage('DMT00110', 'Location');
            ComClearObject(obj);
            ComSetFocus(obj);
        }        
        ComChkObjValid(obj);
    }
    
    /**
     * HTML Control Foucs in
     */
    function obj_focus(){
        var obj = event.srcElement;
        ComClearSeparator(obj);
        
        //글자가 있는 경우 블럭으로 선택할수 있도록 한다.
        if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
    }
    
    //업무 자바스크립트 OnKeyPress 이벤트 처리
    function obj_keypress() {
         switch(event.srcElement.dataformat){
            case "engup":
                // 영문대
                ComKeyOnlyAlphabet('upper');
                break;
    	 	case "engnum":
		    	// 영대문자+숫자 
         		ComKeyOnlyAlphabet('uppernum');
		        break;
            case "int":
                //숫자 만입력하기
                ComKeyOnlyNumber(event.srcElement);
                break;
            default:
                // 숫자만입력하기(정수,날짜,시간)
                ComKeyOnlyNumber(event.srcElement);
         }
     }
    
    /*
     * 다중선택된 DEM/DET Office의 하위점소(Sub Office) 조회기능 
     */
    function doInclSubOfc() {
          var formObj = document.form;
    
          if (formObj.chk_sub_ofc.checked) { // Sub Office 포함
              if (ComIsEmpty(comboObjects[0].Code)) {
                  ComShowCodeMessage('COM12113', "DEM/DET Office");
                  formObj.chk_sub_ofc.checked = false;
                  return;
              }

              formObj.ofc_cd.value = ComGetObjValue(comboObjects[0]);
              formObj.tmp_ofc_cd.value = ComGetObjValue(comboObjects[0]);
              doActionIBCombo( sheetObjects[0] , formObj , comboObjects[0] , IBSEARCH_ASYNC03);
          } else {
              ComSetObjValue(comboObjects[0], formObj.tmp_ofc_cd.value);
          }
    }     

    
     
  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
                var sheetID = sheetObj.id;
        switch(sheetID) {

            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 400;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(3, 1, 7, 100);

                   // var HeadTitle1 = "Seq.|DMT OFC|I/B|O/B|YD Code|Yard Name|Del.|Character|Marine|CY|CFS|Rail|Barge|Pseudo|CTRL OFC";
                    var HeadTitle1 ="||Seq.|cfm|Cost\nStatus|DMT OFC|I/B|YD\nCode|Yard\nName|DMT Type|Del.|Curr.|TMNL Cost|TMNL Cost|EQ Cost|EQ Cost|EQ Cost|CHZ Cost|CHZ Cost|Others|Others|DEM Total|DEM Total|DEM Total|DEM Total|DET Total|DET Total|DET Total|DET Total|Effective\nDate|Expire\nDate|Confirmation|Confirmation|1|2|3|4|5|6" ;
                    var HeadTitle2 ="||Seq.|cfm|Cost\nStatus|DMT OFC|I/B|YD\nCode|Yard\nName|DMT Type|Del.|Curr.|TMNL Cost|TMNL Cost|PDM|PDM|Stock|CHZ Cost|CHZ Cost|Others|Others|DEM Total|DEM Total|DEM Total|DEM Total|DET Total|DET Total|DET Total|DET Total|Effective\nDate|Expire\nDate|Confirmation|Confirmation|1|2|3|4|5|6";
                    var HeadTitle3 ="||Seq.|cfm|Cost\nStatus|DMT OFC|I/B|YD\nCode|Yard\nName|DMT Type|Del.|Curr.|20'|40'|20'|40'|Stock|CY|Door|20'|40'|CY 20'|CY 40'|Door 20'|Door 40'|CY 20'|CY 40'|Door 20'|Door 40'|Effective\nDate|Expire\nDate|Date|User|1|2|3|4|5|6";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true, false);
                    InitHeadRow(1, HeadTitle2, true, false);
                    InitHeadRow(2, HeadTitle3, true, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty( 0,  cnt++ , dtHiddenStatus, 30,	daCenter,	true,	"ibflag");
                    InitDataProperty( 0,  cnt++ , dtDummyCheck,	20,		daCenter,	true,	"chk_box");
                    InitDataProperty( 0 , cnt++ , dtSeq       , 35  , daCenter , true , "seq",                   false ,  "" , dfNone );
                    InitDataProperty( 0 , cnt++ , dtHidden    , 45  , daCenter , true , "cfm_flg",               false ,  "" , dfNone ,  0, false,	false);
                    InitDataProperty( 0 , cnt++ , dtData      , 70  , daCenter , true , "cost_sts",              false ,  "" , dfNone ,  0, false,	false);
                    InitDataProperty( 0 , cnt++ , dtData      , 60  , daCenter , true , "dmdt_ofc_cd",           false ,  "" , dfNone ,  0, false,	false);
                    InitDataProperty( 0 , cnt++ , dtData      , 30  , daCenter , true , "dem_ib_clt_flg",        false ,  "" , dfNone ,  0, false,	false);
                    InitDataProperty( 0 , cnt++ , dtData      , 55  , daCenter , true , "yd_cd",                 true ,   "" , dfNone ,     true,	true);
                    InitDataProperty( 0 , cnt++ , dtData      , 250 , daCenter , true , "yd_nm",                 false ,  "" , dfNone , 0,  false,	false);
                    InitDataProperty( 0 , cnt++ , dtCombo     , 60  , daCenter , true , "dmdt_calc_tp_cd",       false ,  "" , dfNone, 	0,  false,	false);
                    InitDataProperty( 0 , cnt++ , dtData      , 30  , daCenter , true , "delt_flg",              false ,  "" , dfNone , 0,  false,	false);
                    InitDataProperty( 0 , cnt++ , dtData      , 45  , daCenter , true , "curr_cd",               false ,  "" , dfNone,  0,  false,	false);
                    InitDataProperty( 0 , cnt++ , dtData      , 50  , daCenter , true , "tml_cost_20ft_rt_amt",  false ,  "" , dfNullFloat,	2,	true,	true);
                    InitDataProperty( 0 , cnt++ , dtData      , 50  , daCenter , true , "tml_cost_40ft_rt_amt",  false ,  "" , dfNullFloat,	2,	true,	true);
                    InitDataProperty( 0 , cnt++ , dtData      , 50  , daCenter , true , "cntr_cost_20ft_rt_amt", false ,  "" , dfNullFloat,	2,	true,	true);
                    InitDataProperty( 0 , cnt++ , dtData      , 50  , daCenter , true , "cntr_cost_40ft_rt_amt", false ,  "" , dfNullFloat,	2,	true,	true);
                    InitDataProperty( 0 , cnt++ , dtData      , 50  , daCenter , true , "cntr_cost_stk_amt",     false ,  "" , dfNullFloat,	2,	true,	true);
                    InitDataProperty( 0 , cnt++ , dtData      , 50  , daCenter , true , "chg_cost_cy_rt_amt",    false ,  "" , dfNullFloat,	2,	true,	true);
                    InitDataProperty( 0 , cnt++ , dtData      , 50  , daCenter , true , "chg_cost_dor_rt_amt",   false ,  "" , dfNullFloat,	2,	true,	true);
                    InitDataProperty( 0 , cnt++ , dtData      , 50  , daCenter , true , "otr_cost_20ft_rt_amt",  false ,  "" , dfNullFloat,	2,	true,	true);
                    InitDataProperty( 0 , cnt++ , dtData      , 50  , daCenter , true , "otr_cost_40ft_rt_amt",  false ,  "" , dfNullFloat,	2,	true,	true);
                    InitDataProperty( 0 , cnt++ , dtData      , 50  , daCenter , true , "dem_cy_20ft",           false ,  "" , dfNullFloat,	2,	false,	false);
                    InitDataProperty( 0 , cnt++ , dtData      , 50  , daCenter , true , "dem_cy_40ft",           false ,  "" , dfNullFloat,	2,	false,	false);
                    InitDataProperty( 0 , cnt++ , dtData      , 60  , daCenter , true , "dem_dor_20ft",          false ,  "" , dfNullFloat,	2,	false,	false);
                    InitDataProperty( 0 , cnt++ , dtData      , 60  , daCenter , true , "dem_dor_40ft",          false ,  "" , dfNullFloat,	2,	false,	false);
                    InitDataProperty( 0 , cnt++ , dtData      , 50  , daCenter , true , "det_cy_20ft",           false ,  "" , dfNullFloat,	2,	false,	false);
                    InitDataProperty( 0 , cnt++ , dtData      , 50  , daCenter , true , "det_cy_40ft",           false ,  "" , dfNullFloat,	2,	false,	false);
                    InitDataProperty( 0 , cnt++ , dtData      , 60  , daCenter , true , "det_dor_20ft",          false ,  "" , dfNullFloat,	2,	false,	false);
                    InitDataProperty( 0 , cnt++ , dtData      , 60  , daCenter , true , "det_dor_40ft",          false ,  "" , dfNullFloat,	2,	false,	false);
                    InitDataProperty( 0 , cnt++ , dtPopupEdit , 90  , daCenter , true , "eff_dt",                false , "" , dfDateYmd, true,	true);
                    InitDataProperty( 0 , cnt++ , dtPopupEdit , 90  , daCenter , true , "exp_dt",                false , "" , dfDateYmd, true,	true);
                    InitDataProperty( 0 , cnt++ , dtData      , 80  , daCenter , true , "cfm_dt",                false , "" , dfDateYmd , 0, false,	false);
                    InitDataProperty( 0 , cnt++ , dtData      , 60  , daCenter , true , "cfm_usr_id",            false , "" , dfNone    , 0, false,	false);
                    InitDataProperty( 0 , cnt++ , dtHidden    , 60  , daCenter , true , "yd_expt_cost_seq",      false ,  "" , dfNone );
                    InitDataProperty( 0 , cnt++ , dtHidden    , 60  , daCenter , true , "cre_usr_id",      false ,  "" , dfNone );
                    InitDataProperty( 0 , cnt++ , dtHidden    , 60  , daCenter , true , "cre_ofc_cd",      false ,  "" , dfNone );
                    InitDataProperty( 0 , cnt++ , dtHidden    , 60  , daCenter , true , "upd_usr_id",      false ,  "" , dfNone );
                    InitDataProperty( 0 , cnt++ , dtHidden    , 60  , daCenter , true , "upd_ofc_cd",      false ,  "" , dfNone );
                    InitDataProperty( 0 , cnt++ , dtHidden    , 60  , daCenter , true , "cfm_ofc_cd",      false ,  "" , dfNone );

                      
                    InitDataValid(0,    "cfm_flg",   vtEngUpOnly);
                   // InitDataValid(0,    "curr_cd",   vtEngUpOnly);
                    InitDataValid(0,    "yd_cd",     vtEngUpOther, "0123456789");
                    InitDataCombo(0, "dmdt_calc_tp_cd", "Dual|Combine|", "D|C|");
                    SetMergeCell(0, 12, 2, 2); 
                    SetMergeCell(0, 17, 2, 2); 
                    SetMergeCell(0, 19, 2, 2); 
                    SetMergeCell(0, 21, 2, 4); 
                    SetMergeCell(0, 25, 2, 4);
                    
                   // CountPosition = 0;
                }
            break;
            

        }
    }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
            case IBSEARCH:      //조회
    	    
                if(!validateForm(sheetObj,formObj,sAction)) return;
                formObj.f_cmd.value = SEARCH;
                
                sheetObj.RemoveAll();
                sheetObj.DoSearch("EES_DMT_7009GS.do", FormQueryString(formObj));

                DmtComEnableManyBtns(true,  "btn_new", "btn_retrieve", "btn_confirm","btn_save" , "btn_cancel"); 

            	for (var row = sheetObj.HeaderRows ; row <= sheetObj.LastRow  ; row++) {
           		 
            		if ( sheetObj.CellValue(row, "cfm_flg") == "Y"){
            			 // sheetObj.RowEditable(row) = false;
            			 sheetObj.CellEditable(row, "yd_cd") = false;
                     	 sheetObj.CellEditable(row, "eff_dt") = false;
                     	 //sheetObj.CellEditable(row, "curr_cd") = false;
                     	 sheetObj.CellEditable(row, "tml_cost_20ft_rt_amt") = false;
                     	 sheetObj.CellEditable(row, "tml_cost_40ft_rt_amt") = false;
                     	 sheetObj.CellEditable(row, "cntr_cost_20ft_rt_amt") = false;
                     	 sheetObj.CellEditable(row, "cntr_cost_40ft_rt_amt") = false;
                     	 sheetObj.CellEditable(row, "chg_cost_cy_rt_amt") = false;
                     	 sheetObj.CellEditable(row, "chg_cost_dor_rt_amt") = false;
                     	 sheetObj.CellEditable(row, "otr_cost_20ft_rt_amt") = false;
                     	 sheetObj.CellEditable(row, "otr_cost_40ft_rt_amt") = false;
                     	 sheetObj.CellEditable(row, "cntr_cost_stk_amt") = false;
            			 
            		}
            		if ( sheetObj.CellValue(row, "yd_expt_cost_seq") == ""){
            			  sheetObj.RowStatus(row) = "I";
            			  sheetObj.CellValue2(row, "cre_usr_id") = formObj.cre_usr_id.value;
            			  sheetObj.CellValue2(row, "cre_ofc_cd") = formObj.cre_ofc_cd.value; 
            			  sheetObj.CellValue2(row, "upd_usr_id") = formObj.upd_usr_id.value;
            			  sheetObj.CellValue2(row, "upd_ofc_cd") = formObj.upd_ofc_cd.value;
            		}else{
                    	sheetObj.CellEditable(row, "yd_cd") = false;
                    	//sheetObj.CellEditable(row, "eff_dt") = false;
                    	//sheetObj.CellEditable(row, "exp_dt") = false;
           		    }
				}
                formObj.cfm_cancel.value ="N"; 
                
            break;
            
            case IBSEARCH_YD:      //YARD Code check.
			//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
               formObj.f_cmd.value = COMMAND20;
			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************

				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
				var chk_yd_cd = ComGetEtcData(sXml, "chk_yd_cd");

				ComSetObjValue(formObj.chk_yd_cd, chk_yd_cd);
				break;
				
            case IBSEARCH_YARD:      //YARD 정보 조회
			//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
               formObj.f_cmd.value = SEARCH21;
			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************

				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
								
				var yd_info = ComGetEtcData(sXml,"yd_nm");
				
				ComSetObjValue(formObj.yd_info, yd_info);
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
				//var chk_yd_cd = ComGetEtcData(sXml, "chk_yd_cd");

				//ComSetObjValue(formObj.chk_yd_cd, chk_yd_cd);
			break;		
				
            case IBSEARCH_DUP:      //YARD 조회
			//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
               formObj.f_cmd.value = SEARCH01;
			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************

				var sXml = sheetObj.GetSearchXml("EES_DMT_7009GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
				var chk_peiod = ComGetEtcData(sXml, "chk_period");

				ComSetObjValue(formObj.chk_peiod, chk_peiod);
				break;	
            
            case IBSAVE:      //저장
               
	            if(!validateForm(sheetObj,formObj,sAction)) return;
	            formObj.f_cmd.value = COMMAND01;
	            ComOpenWait(true);
	            
	           // sheetObj.DoSave("EES_DMT_7009GS.do", FormQueryString(formObj),-1,false);
	            
				var sXml = sheetObj.GetSaveXml("EES_DMT_7009GS.do", FormQueryString(formObj) + "&" +ComSetPrifix(sheetObj.GetSaveString(false),"sheet1_"));
				sheetObj.LoadSaveXml(sXml);
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
	            ComOpenWait(false);

	           break;
        
            case IBCONFRIM:      //confrim
	            if(!validateForm(sheetObj,formObj,sAction)) return;
	            formObj.f_cmd.value = COMMAND02;
	            ComOpenWait(true);
	            
             	var sXml = sheetObj.GetSaveXml("EES_DMT_7009GS.do",FormQueryString(formObj) + "&" + ComSetPrifix(sheetObj.GetSaveString(false,true,"chk_box"),"sheet1_"));
      
				sheetObj.LoadSaveXml(sXml);
            
	            doActionIBSheet(sheetObj, formObj, IBSEARCH);
	            ComOpenWait(false);
	            break;
            case IBCANCEL:      //confrim cancel
	            if(!validateForm(sheetObj,formObj,sAction)) return;
	            formObj.f_cmd.value = COMMAND02;
	            //alert("cancel");
	            
	            formObj.cfm_cancel.value ="Y";
	            ComOpenWait(true);
	            
	         	var sXml = sheetObj.GetSaveXml("EES_DMT_7009GS.do",FormQueryString(formObj) + "&" + ComSetPrifix(sheetObj.GetSaveString(false,true,"chk_box"),"sheet1_"));
	  
				sheetObj.LoadSaveXml(sXml);
	        
	            doActionIBSheet(sheetObj, formObj, IBSEARCH);
	            ComOpenWait(false);
	        break;

                
         }
     }
     
     /**
     * Combo 기본 설정 
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
     */ 
    function initCombo(comboObj, comboNo) {
        var formObj = document.form;
        
        switch(comboObj.id) {  
        
            case "office": 
                with (comboObj) { 
                    //MultiSelect = false;
                    UseAutoComplete = true;
                    SetColAlign("left");
                    DropHeight = 160;
                    ColBackColor(0) = "white";
                    ColBackColor(1) = "white";
                    ValidChar(2); // 영어대문자 사용
                    MaxLength = 5;
                }
                doActionIBCombo(sheetObjects[0], formObj, comboObj, SEARCHLIST02);
                
            break;
            
            case "combo3":
                with (comboObj) {
                    MultiSelect = false;
                    UseAutoComplete = true;
                    SetColAlign("left|left");        
                    SetColWidth("30|300");
                    DropHeight = 160;
                    ValidChar(2,0);     //영문 대문자
                    IMEMode = 0;
                    MaxLength = 2;
                    ColBackColor(0) = "white";
                    ColBackColor(1) = "white";
                }
                doActionIBCombo(sheetObjects[0],formObj,comboObj,SEARCH02);
                
            break;
            
            case "combo5":
                with (comboObj) {
                    MultiSelect = false; 
                    UseAutoComplete = true;    
                    SetColAlign("left");
                    SetColWidth("50");
                    DropHeight = 160;
                    ValidChar(2,1);     //영문 대문자, 숫자
                    MaxLength = 2;
                }
                comboObj.InsertItem(0, "", "");
            break;
        }
    }
   
   
    // IBCombo 데이터 조회 및 세팅
    function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
         sheetObj.ShowDebugMsg = false;
         sheetObj.WaitImageVisible = false;
         
         formObj.f_cmd.value = formCmd;
         
         switch(formCmd) {
            case COMMAND06: // RHQ
                with (comboObj) { 
                    RemoveAll();
                    MultiSelect = false;
                    SetColWidth("45");
                    ValidChar(2);   // 영대문자만 사용
                    //MaxLength = 6;
                }
            
            	var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
                var data = ComGetEtcData(sXml, "common_cd");
                if (data != undefined && data != '') {
                    var comboItems = data.split("|");
                    comboObj.InsertItem(0, "All", "All");
                    
                    for (var i = 0 ; i < comboItems.length ; i++) {
                        comboObj.InsertItem(i+1, comboItems[i], comboItems[i]);     
                    }
                }
//                break;
         
            case SEARCHLIST02: // Office
                with (comboObj) { 
                    RemoveAll();
                    MultiSelect = true;
                    SetColWidth("95");
                    ValidChar(2, 2); // 영대문자, 특수문자만 가능
                }
               
            	var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
                var data = ComGetEtcData(sXml, "OFC_CD");
                
                if (data != undefined && data != '') {
					var usrOfcCd = ComGetObjValue(formObj.h_user_office);
 					var idx = 0;
 					
 					// 로그인 Office가 멀티콤보 리스트에 없을 경우, 리스트 최상단에 추가
 					if(data.indexOf(usrOfcCd) == -1) {
 						comboObj.InsertItem(0, usrOfcCd, usrOfcCd);
 						idx = 1;
 					}
 					 
 		    	    var comboItems = data.split("|");
 		    	    for (var i=0 ; i < comboItems.length ; i++) {
 		    	    	comboObj.InsertItem(idx+i, comboItems[i], comboItems[i]);
 		         	}
 	    	  		
 	    	  		// 로그인 User Office를 Default로 설정
	    	  		comboObj.Code = usrOfcCd;
				}
                
                break;
                
            case COMMAND01: // Incl. Sub Office
            	var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
            	var subOfcCds = ComGetEtcData(sXml, "OFC_CD");
	    	 	
		 		if (subOfcCds != undefined && subOfcCds != '') {
		 			var usrOfcCd = ComGetObjValue(formObj.h_user_office);
					
					if(comboObj.Code.indexOf(usrOfcCd) != -1 && subOfcCds.indexOf(usrOfcCd)==-1)
						subOfcCds = usrOfcCd + ',' + subOfcCds;
	    	   			
					comboObj.Code = subOfcCds;
		 		}
		 		break;
                
            //Yard 입력완료시 Yard List 조회
            case SEARCH14:
            	var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

                //Continent 콤보 Empty 상태로 초기화
            	comboObjects[2].Code = "-1";
            	comboObjects[2].RemoveAll();                      
            	
            	var comboDatas = ComGetEtcData(sXml, YARD);

                if (comboDatas == undefined ||comboDatas == "") {
                	ComShowCodeMessage('DMT00110','Location');
                    ComClearObject(formObj.yd_cd1);
                    ComSetFocus(formObj.yd_cd1);
                }else{
                    
                    var comboItems = comboDatas.split(ROWMARK);
                    addComboItem1(comboObjects[2],comboItems);    
                    setComboItem(comboObjects[2],comboItems);
                    
                }
                break;
                            
			//2. COUNTRY LIST
			case SEARCH02:
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
                var comboDatas = ComGetEtcData(sXml, COUNTRY);
                if (comboDatas != undefined ||comboDatas != "") {
                    var comboItems = comboDatas.split(ROWMARK);
                    addComboItem(comboObjects[1],comboItems); //COUNTRY
                }else{
                    ComShowCodeMessage("DMT06001");
                    clearObjectValue(sObj);
                }
                //comboObjects[1].Code = document.form.usr_cnt_cd.value;
                break;
                            
            case IBSEARCH_ASYNC03:      
                //3. Sub Office comboList
                formObj.f_cmd.value = COMMAND01;
                var sXml2 = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
                var subOfcCds = ComGetEtcData(sXml2, "OFC_CD");
	    	 	
		 		if (subOfcCds != undefined && subOfcCds != '') {
		 			var usrOfcCd = ComGetObjValue(formObj.h_user_office);
					
					if(comboObj.Code.indexOf(usrOfcCd) != -1 && subOfcCds.indexOf(usrOfcCd)==-1)
						subOfcCds = usrOfcCd + ',' + subOfcCds;
	    	   			
					comboObj.Code = subOfcCds;
		 		}
		 		break;
        }
         
         sheetObj.WaitImageVisible = true;
    }
    
    // 'Incl. Sub Office' 체크박스가 체크된 상태에서  Office 멀티콤보를 선택하지 못하도록 한다.
    function office_OnCheckClick(comboObj, index, code) {
        var formObj = document.form;
        
        if(formObj.chk_sub_ofc.checked) {
   			if(comboObj.CheckIndex(index))
   				comboObj.CheckIndex(index) = false;
   			else
   				comboObj.CheckIndex(index) = true;
   			
   			ComShowCodeMessage('DMT00107');
   		}
    }
    
	// 멀티콤보 KeyDown Event Catch
 	function office_OnKeyDown(comboObj, keycode, shift) {
		var formObj = document.form;
		
   		if(formObj.chk_sub_ofc.checked) {
   			ComShowCodeMessage('DMT00107');
   		}
 	}
     
 	
    function keyPress() {
        var eventKey = window.event.keyCode ;
        if( eventKey == 13 ) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
    document.onkeypress = keyPress ; 


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
         	switch(sAction) {
               	case IBSEARCH:      //조회 	
               	
               	
 		            formObj.ofc_cd.value = ComGetObjValue(formObj.office);
		            formObj.cnt_cd.value = ComGetObjValue(formObj.combo3);
		
		            var yard = ComGetObjValue(formObj.combo5);
		            if (yard =='' ||yard ==' ') {
		            	formObj.yd_cd.value = ComGetObjValue(formObj.yd_cd1);	
		            }else {
		                formObj.yd_cd.value = ComGetObjValue(formObj.combo5);
		            } 
		            
		            var ck_curt = document.form.chk_current.value
		            var ck_tobe = document.form.chk_tobe.value;
		            var ck_expr = document.form.chk_expired.value;
		     	    if (ck_curt =='N' && ck_tobe =='N' && ck_expr =='N') {
		     	    	ComShowCodeMessage("DMT01163");
                 		return;	
		     	    }
		            
	        	break; 
              	case IBSAVE:
              		              		
              		if (sheetObj.RowCount < 0) {
                 		ComShowCodeMessage("DMT00128");
                 		return;
                 	}
              		var save_row = 0;
              		for (var j= sheetObj.HeaderRows ; j <= sheetObj.LastRow  ; j++) {
              			 
              		    var yd = sheetObj.CellValue(j, "yd_cd");
                        var effdt = sheetObj.CellValue(j, "eff_dt"); 
                        var expdt = sheetObj.CellValue(j, "exp_dt");
                        var rowseq = sheetObj.CellValue(j, "seq")
                        var curr = sheetObj.CellValue(j, "curr_cd")
                        
                        formObj.yd_cd.value = yd;
                        formObj.eff_dt.value = effdt;
                        formObj.exp_dt.value = expdt;
              			//if (sheetObj.RowStatus(j) == "D") continue; //삭제기능추가
 					   
					   	if( sheetObj.RowStatus(j) == "I" || (sheetObj.RowStatus(j) == "U" && sheetObj.CellValue(j, "cfm_flg") == "N" )) {
			 					   // local time 
							    formObj.f_cmd.value = SEARCH23;
						 	    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
							    var lclTime = ComGetEtcData(sXml, "LCL_TIME").substring(0, 8);
							    
							    if( ComGetDaysBetween( effdt, lclTime) > 0 ){	
					    		   ComShowCodeMessage("DMT01164");
        	    			       return false;
					    	    }
						}

					    
                        var dem_cy_20ft = parseFloat(sheetObj.CellValue(j, "dem_cy_20ft"));
                        var dem_cy_40ft = parseFloat(sheetObj.CellValue(j, "dem_cy_40ft"));
                        var dem_dor_20ft = parseFloat(sheetObj.CellValue(j, "dem_dor_20ft"));
                        var dem_dor_40ft = parseFloat(sheetObj.CellValue(j, "dem_dor_40ft"));
                        var det_cy_20ft = parseFloat(sheetObj.CellValue(j, "det_cy_20ft"));
                        var det_cy_40ft = parseFloat(sheetObj.CellValue(j, "det_cy_40ft"));
                        var det_dor_20ft = parseFloat(sheetObj.CellValue(j, "det_dor_20ft"));
                        var det_dor_40ft = parseFloat(sheetObj.CellValue(j, "det_dor_40ft"));
                         
                        
                        var tot_amt = dem_cy_20ft + dem_cy_40ft + dem_dor_20ft + dem_dor_40ft 
                                    + det_cy_20ft + det_cy_40ft + det_dor_20ft + det_dor_40ft  ;
                        

                        if (tot_amt != 0 && effdt == "") {
         					ComShowCodeMessage("DMT00108", rowseq, "Effective Date");
         					return false;
         				 }
              			
              			if (sheetObj.RowStatus(j) == "U"){
              				sheetObj.CellValue2(j, "upd_usr_id") = formObj.upd_usr_id.value;
              				sheetObj.CellValue2(j, "upd_ofc_cd") = formObj.upd_ofc_cd.value;
              				
              			}
              			
              			if (sheetObj.RowStatus(j) == "I"){
              				sheetObj.CellValue2(j, "cre_usr_id") = formObj.cre_usr_id.value;
              				sheetObj.CellValue2(j, "cre_ofc_cd") = formObj.cre_ofc_cd.value;
              				sheetObj.CellValue2(j, "upd_usr_id") = formObj.upd_usr_id.value;
              				sheetObj.CellValue2(j, "upd_ofc_cd") = formObj.upd_ofc_cd.value;
             			}
              			
              			if (curr == ""){
              				sheetObj.CellValue2(j, "curr_cd") = "USD";
              			}
                         
                         if (yd == "") {
           					ComShowCodeMessage("DMT00108", rowseq, "YARD");
           					return false;
           				 }
                         if (tot_amt > 0 && curr == "") {
            					ComShowCodeMessage("DMT00108", rowseq, "Curr.");
            					return false;
            			 }
                      
                         if (effdt != "" && expdt == "") {
                        	 expdt ='9999-12-31';
           				 } 

                         if (tot_amt == 0 && effdt == "" && sheetObj.RowStatus(j)=="I" ) {
                           
 	              			sheetObj.RowStatus(j) = "R";
 	              		}
 
		       			if (sheetObj.RowStatus(j) == "I" ){    
               			  doActionIBSheet(sheetObj,document.form, IBSEARCH_DUP);
		               			 if (ComGetObjValue(document.form.chk_peiod) != "N" ) {
									 ComShowCodeMessage("DMT00138", rowseq );
									 return false;
								  }
               			    
             			}
	              		
                         
         				if (ComGetDaysBetween( expdt, effdt) > 0) {
        	    			ComShowCodeMessage("COM12133", "'Effective Date'", "'Expire Date'", "earlier");
        	    			return false;	    			
        	    		}

                  		// 중복 check
                         for (var i= j+1 ; i <= sheetObj.LastRow  ; i++) {
                		     var yd_c = sheetObj.CellValue(i, "yd_cd");
                             var effdt_c = sheetObj.CellValue(i, "eff_dt"); 
                             var expdt_c = sheetObj.CellValue(i, "exp_dt");
                             var rowseq_c = sheetObj.CellValue(i, "seq")
                             if(expdt_c == "") {
                            	 expdt_c ='9999-12-31';
               				 } 

                             if (yd_c == yd){
                            	 if(  (ComGetDaysBetween( effdt_c, effdt) >= 0 && ComGetDaysBetween( effdt, expdt_c) >= 0 && ComGetDaysBetween( expdt_c, expdt ) >= 0)
                            		||(ComGetDaysBetween( effdt, effdt_c) >= 0 && ComGetDaysBetween( expdt_c, expdt) >= 0 )
                            		||(ComGetDaysBetween( effdt_c, effdt) >= 0 && ComGetDaysBetween( expdt, expdt_c) >= 0)
                            		||(ComGetDaysBetween( effdt, effdt_c) >= 0 && ComGetDaysBetween( effdt_c, expdt) >= 0 && ComGetDaysBetween( expdt, expdt_c) >= 0 )){
                            		
                            		 ComShowCodeMessage("DMT00138", rowseq, rowseq_c);
                            		 return false;
                            	 }
                             }
                         }
                  		
 	               		if (sheetObj.RowStatus(j) == "R") {
 	               			continue; 
 	               		}else{
 	               			save_row = save_row + 1 ;
 	               		}
              		
              		}
              	
                    	if (save_row < 1) {
                     		ComShowCodeMessage("DMT00128");
                     		return;
                     	}
                    	
                    	
              		
              	break;
              	case IBCONFRIM:
     	        	var chkRow = sheetObj.FindCheckedRow("chk_box");
					if(chkRow == "") {
						ComShowCodeMessage('DMT00009');
						return false;
					}
					for (var j= sheetObj.HeaderRows ; j <= sheetObj.LastRow  ; j++) {
						if (sheetObj.CellValue(j, "chk_box") ==  1){
					     	sheetObj.CellValue2(j, "upd_usr_id") = formObj.upd_usr_id.value;
	      				    sheetObj.CellValue2(j, "upd_ofc_cd") = formObj.upd_ofc_cd.value;
	      				    sheetObj.CellValue2(j, "cfm_usr_id") = formObj.upd_usr_id.value;
	    				    sheetObj.CellValue2(j, "cfm_ofc_cd") = formObj.upd_ofc_cd.value;
						}
					}
					
              	break;
              	case IBCANCEL:
     	        	var chkRow = sheetObj.FindCheckedRow("chk_box");
					if(chkRow == "") {
						ComShowCodeMessage('DMT00009');
						return false;
					}
					   // local time 
					    formObj.f_cmd.value = SEARCH23;
				 	    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
					    var lclTime = ComGetEtcData(sXml, "LCL_TIME").substring(0, 8);

					for (var k= sheetObj.HeaderRows ; k <= sheetObj.LastRow  ; k++) {
						if (sheetObj.CellValue(k, "chk_box") ==  1){
							var effDt = sheetObj.CellValue(k, "eff_dt"); 
							if( ComGetDaysBetween( effDt, lclTime) >= 0){
								ComShowCodeMessage("COM12133", "'Effective Date'", "Today", "later");
	        	    			return false;	    			
							}

					     	sheetObj.CellValue2(k, "upd_usr_id") = formObj.upd_usr_id.value;
	      				    sheetObj.CellValue2(k, "upd_ofc_cd") = formObj.upd_ofc_cd.value;
	      				    sheetObj.CellValue2(k, "cfm_usr_id") = "";
	    				    sheetObj.CellValue2(k, "cfm_ofc_cd") = "";
						}
					}
      				
              	break;
         	}
        }
        return true;
    }
    
    // 마우스가 Sheet 위에서 움직일 때 발생하는 Event
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y)
    {
        with(sheetObj)
        {
            var colName = ColSaveName(MouseCol);        // SaveName을 가져온다.
            var msg = "";
            switch(colName)
            {
                case "dmtofc":
                    msg = "DEM/DET Office";
                    break;
                
                case "ib":
                    msg = "I/B Collection";
                    break;
                    
                case "ob":
                    msg = "O/B Collection";
                    break;
                    
                case "del":
                    msg = "Yard Delete Flag";
                    break;
                
                default:
                    msg = "";
                    break;
            }
            
            MouseToolTipText = msg;     // ToolTip의 내용 설정
            
        }
    }
    
    /*
     * yd_cd1 조회필드에서 LOCATION에 해당하는 YARD 정보를 조회하는 함수
     */     
    function checkYard1(obj) {
        if(isAlphaNum()) {
            checkYard1_sub2(obj);
        }
    }
    
    /*
     * yd_cd1 입력시 yd_cd list를 조회한다.
     */
    function checkYard1_sub2(obj) {
        var formObj = document.form;
        var yardCd1 = ComTrim(ComGetObjValue(obj));
        if (yardCd1.length == 5) {
            doActionIBCombo(sheetObjects[0],formObj,comboObjects[1],SEARCH14);
        }
    }
    
function combo3_OnBlur(){
//     alert( ComGetObjValue(comboObjects[1]) );
}
     
    /**
     * 콤보필드에 데이터를 추가해준다.
     */ 
    function addComboItem(comboObj, comboItems) {
        for (var i = 0 ; i < comboItems.length ; i++) {
            var comboItem = comboItems[i].split(FIELDMARK);
            comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[0]);        
        }           
    }
     
    /**
     * 콤보필드에 첫번째 항목을 선택해준다.
     */ 
    function setComboItem(comboObj,comboItems) {
        var checkedItem = comboItems[0].split(FIELDMARK);
        comboObj.Text = checkedItem[0];
    }
    
    /**
     * 콤보필드에 데이터를 추가해준다.
     */ 
    function addComboItem1(comboObj, comboItems) {
        for (var i = 0 ; i < comboItems.length ; i++) {
            var comboItem = comboItems[i].split(FIELDMARK);
            comboObj.InsertItem(i, comboItem[1], comboItem[0]);     
        }           
    }
     
 	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj 	= document.form;
		var sheetObj 	= sheetObjects[0];
		var tml_20ft  = 0;
		var cntr_20ft = 0;
		var otr_20ft  = 0;
		var tml_40ft  = 0;
		var cntr_40ft = 0;
		var otr_40ft  = 0;
		var cy_rt     = 0;
		var dor_rt    = 0;
		var stk_amt   = 0;
		
		var dem_cy_20ft = 0;
		var dem_cy_40ft = 0;
		var dem_dor_20ft = 0;
		var dem_dor_40ft = 0;
		var det_cy_20ft = 0;
		var det_cy_40ft = 0;
		var det_dor_20ft = 0;
		var det_dor_40ft = 0;
		
		with(sheetObj) {
			switch(ColSaveName(Col)) {
				case "tml_cost_20ft_rt_amt":
				case "cntr_cost_20ft_rt_amt": 
				case "otr_cost_20ft_rt_amt" : 
					  tml_20ft  = sheetObj.CellValue(Row, "tml_cost_20ft_rt_amt");
	                  cntr_20ft = sheetObj.CellValue(Row, "cntr_cost_20ft_rt_amt");
	                  otr_20ft  = sheetObj.CellValue(Row, "otr_cost_20ft_rt_amt");
	                  cy_rt     = sheetObj.CellValue(Row, "chg_cost_cy_rt_amt");
	                  dor_rt    = sheetObj.CellValue(Row, "chg_cost_dor_rt_amt");
	                  stk_amt   = sheetObj.CellValue(Row, "cntr_cost_stk_amt");

	                 if(tml_20ft=="") tml_20ft = 0;
	                 if(cntr_20ft=="") cntr_20ft = 0;
	                 if(otr_20ft=="") otr_20ft = 0;
	                 if(cy_rt=="")  cy_rt = 0;
	                 if(dor_rt=="") dor_rt = 0;
	                 if(stk_amt=="") stk_amt = 0;
	                
					 dem_cy_20ft  = parseFloat(tml_20ft) + parseFloat(cntr_20ft) + 
					                parseFloat(otr_20ft) + parseFloat(cy_rt) + parseFloat(stk_amt) ;
					 dem_dor_20ft = parseFloat(tml_20ft) + parseFloat(cntr_20ft) + 
		                            parseFloat(otr_20ft) + parseFloat(dor_rt) + parseFloat(stk_amt) ;
					 det_cy_20ft =  parseFloat(cntr_20ft) + 
		                            parseFloat(otr_20ft) + parseFloat(cy_rt)  + parseFloat(stk_amt) ;
					 det_dor_20ft = parseFloat(cntr_20ft) + 
		                            parseFloat(otr_20ft) + parseFloat(dor_rt)  + parseFloat(stk_amt) ;
				
					sheetObj.CellValue2(Row, "dem_cy_20ft")  = dem_cy_20ft;
					sheetObj.CellValue2(Row, "dem_dor_20ft") = dem_dor_20ft;
					sheetObj.CellValue2(Row, "det_cy_20ft")  = det_cy_20ft;
					sheetObj.CellValue2(Row, "det_dor_20ft") = det_dor_20ft;
					
				    break;
				case "tml_cost_40ft_rt_amt":
				case "cntr_cost_40ft_rt_amt":  
				case "otr_cost_40ft_rt_amt" : 
					tml_40ft  = sheetObj.CellValue(Row, "tml_cost_40ft_rt_amt");
	                cntr_40ft = sheetObj.CellValue(Row, "cntr_cost_40ft_rt_amt");
	                otr_40ft  = sheetObj.CellValue(Row, "otr_cost_40ft_rt_amt");
	                cy_rt     = sheetObj.CellValue(Row, "chg_cost_cy_rt_amt");
	                dor_rt    = sheetObj.CellValue(Row, "chg_cost_dor_rt_amt");
	                stk_amt   = sheetObj.CellValue(Row, "cntr_cost_stk_amt");
	                
	                if(tml_40ft=="") tml_40ft = 0;
	                if(cntr_40ft=="") cntr_40ft = 0;
	                if(otr_40ft=="") otr_40ft = 0;
	                if(cy_rt=="")  cy_rt = 0;
	                if(dor_rt=="") dor_rt = 0;
	                if(stk_amt=="") stk_amt = 0;
	              
					 dem_cy_40ft  = parseFloat(tml_40ft) + parseFloat(cntr_40ft) +
		                            parseFloat(otr_40ft) + parseFloat(cy_rt) + parseFloat(stk_amt) ;
					 dem_dor_40ft = parseFloat(tml_40ft) + parseFloat(cntr_40ft) + 
			                        parseFloat(otr_40ft) + parseFloat(dor_rt) + parseFloat(stk_amt) ;
					 det_cy_40ft =  parseFloat(cntr_40ft)+ 
			                        parseFloat(otr_40ft) + parseFloat(cy_rt) + parseFloat(stk_amt) ;
					 det_dor_40ft = parseFloat(cntr_40ft)+ 
			                        parseFloat(otr_40ft) + parseFloat(dor_rt) + parseFloat(stk_amt) ;
				
					sheetObj.CellValue2(Row, "dem_cy_40ft")  = dem_cy_40ft;
					sheetObj.CellValue2(Row, "dem_dor_40ft") = dem_dor_40ft;
					sheetObj.CellValue2(Row, "det_cy_40ft")  = det_cy_40ft;
					sheetObj.CellValue2(Row, "det_dor_40ft") = det_dor_40ft;
					
					
				break;
					    
				case "chg_cost_cy_rt_amt": 
					  tml_20ft  = sheetObj.CellValue(Row, "tml_cost_20ft_rt_amt");
	                  cntr_20ft = sheetObj.CellValue(Row, "cntr_cost_20ft_rt_amt");
	                  otr_20ft  = sheetObj.CellValue(Row, "otr_cost_20ft_rt_amt");
					  tml_40ft  = sheetObj.CellValue(Row, "tml_cost_40ft_rt_amt");
		              cntr_40ft = sheetObj.CellValue(Row, "cntr_cost_40ft_rt_amt");
		              otr_40ft  = sheetObj.CellValue(Row, "otr_cost_40ft_rt_amt");
		              cy_rt     = sheetObj.CellValue(Row, "chg_cost_cy_rt_amt");
		              stk_amt   = sheetObj.CellValue(Row, "cntr_cost_stk_amt");

	                   if(tml_20ft=="") tml_20ft = 0;
	                   if(cntr_20ft=="") cntr_20ft = 0;
	                   if(otr_20ft=="") otr_20ft = 0;
		               if(tml_40ft=="") tml_40ft = 0;
		               if(cntr_40ft=="") cntr_40ft = 0;
		               if(otr_40ft=="") otr_40ft = 0;
	                   if(cy_rt=="")  cy_rt = 0;
	                   if(stk_amt=="") stk_amt = 0;
	                   
					 dem_cy_20ft  = parseFloat(tml_20ft) + parseFloat(cntr_20ft) + 
					                parseFloat(otr_20ft) + parseFloat(cy_rt) + parseFloat(stk_amt) ;
					 det_cy_20ft =  parseFloat(cntr_20ft) + 
		                            parseFloat(otr_20ft) + parseFloat(cy_rt) + parseFloat(stk_amt) ;
					 dem_cy_40ft  = parseFloat(tml_40ft) + parseFloat(cntr_40ft) +
                                    parseFloat(otr_40ft) + parseFloat(cy_rt) + parseFloat(stk_amt) ;
		             det_cy_40ft =  parseFloat(cntr_40ft)+ 
                                    parseFloat(otr_40ft) + parseFloat(cy_rt) + parseFloat(stk_amt) ;
				
					sheetObj.CellValue2(Row, "dem_cy_20ft") = dem_cy_20ft;
					sheetObj.CellValue2(Row, "det_cy_20ft") = det_cy_20ft;
					sheetObj.CellValue2(Row, "dem_cy_40ft") = dem_cy_40ft;
					sheetObj.CellValue2(Row, "det_cy_40ft") = det_cy_40ft;
					
					break;
				case "chg_cost_dor_rt_amt": 
					  tml_20ft  = sheetObj.CellValue(Row, "tml_cost_20ft_rt_amt");
	                  cntr_20ft = sheetObj.CellValue(Row, "cntr_cost_20ft_rt_amt");
	                  otr_20ft  = sheetObj.CellValue(Row, "otr_cost_20ft_rt_amt");
					  tml_40ft  = sheetObj.CellValue(Row, "tml_cost_40ft_rt_amt");
		              cntr_40ft = sheetObj.CellValue(Row, "cntr_cost_40ft_rt_amt");
		              otr_40ft  = sheetObj.CellValue(Row, "otr_cost_40ft_rt_amt");
		              dor_rt    = sheetObj.CellValue(Row, "chg_cost_dor_rt_amt");
		              stk_amt   = sheetObj.CellValue(Row, "cntr_cost_stk_amt");
		              
	                   if(tml_20ft=="") tml_20ft = 0;
	                   if(cntr_20ft=="") cntr_20ft = 0;
	                   if(otr_20ft=="") otr_20ft = 0;
		               if(tml_40ft=="") tml_40ft = 0;
		               if(cntr_40ft=="") cntr_40ft = 0;
		               if(otr_40ft=="") otr_40ft = 0;
	                   if(dor_rt=="") dor_rt = 0;
	                   if(stk_amt=="") stk_amt = 0;
	                   
					  dem_dor_20ft = parseFloat(tml_20ft) + parseFloat(cntr_20ft) + 
			                         parseFloat(otr_20ft) + parseFloat(dor_rt) + parseFloat(stk_amt) ;
 					  det_dor_20ft = parseFloat(cntr_20ft) + 
			                         parseFloat(otr_20ft) + parseFloat(dor_rt) + parseFloat(stk_amt) ;
			          dem_dor_40ft = parseFloat(tml_40ft) + parseFloat(cntr_40ft) + 
			                         parseFloat(otr_40ft) + parseFloat(dor_rt) + parseFloat(stk_amt) ;
			          det_dor_40ft = parseFloat(cntr_40ft)+ 
			                         parseFloat(otr_40ft) + parseFloat(dor_rt) + parseFloat(stk_amt) ;
			          
						sheetObj.CellValue2(Row, "dem_dor_20ft") = dem_dor_20ft;
						sheetObj.CellValue2(Row, "det_dor_20ft") = det_dor_20ft;
						sheetObj.CellValue2(Row, "dem_dor_40ft") = dem_dor_40ft;
						sheetObj.CellValue2(Row, "det_dor_40ft") = det_dor_40ft;
					break;	
				case "cntr_cost_stk_amt": 
					  tml_20ft  = sheetObj.CellValue(Row, "tml_cost_20ft_rt_amt");
	                  cntr_20ft = sheetObj.CellValue(Row, "cntr_cost_20ft_rt_amt");
	                  otr_20ft  = sheetObj.CellValue(Row, "otr_cost_20ft_rt_amt");
					  tml_40ft  = sheetObj.CellValue(Row, "tml_cost_40ft_rt_amt");
		              cntr_40ft = sheetObj.CellValue(Row, "cntr_cost_40ft_rt_amt");
		              otr_40ft  = sheetObj.CellValue(Row, "otr_cost_40ft_rt_amt");
		              dor_rt    = sheetObj.CellValue(Row, "chg_cost_dor_rt_amt");
		              cy_rt     = sheetObj.CellValue(Row, "chg_cost_cy_rt_amt");
		              stk_amt   = sheetObj.CellValue(Row, "cntr_cost_stk_amt");
		              
	                   if(tml_20ft=="") tml_20ft = 0;
	                   if(cntr_20ft=="") cntr_20ft = 0;
	                   if(otr_20ft=="") otr_20ft = 0;
		               if(tml_40ft=="") tml_40ft = 0;
		               if(cntr_40ft=="") cntr_40ft = 0;
		               if(otr_40ft=="") otr_40ft = 0;
	                   if(dor_rt=="") dor_rt = 0;
	                   if(cy_rt=="")  cy_rt = 0;
	                   if(stk_amt=="") stk_amt = 0;
	                   
					   dem_dor_20ft = parseFloat(tml_20ft) + parseFloat(cntr_20ft) + 
			                          parseFloat(otr_20ft) + parseFloat(dor_rt) + parseFloat(stk_amt) ;
					   det_dor_20ft = parseFloat(cntr_20ft) + 
			                          parseFloat(otr_20ft) + parseFloat(dor_rt) + parseFloat(stk_amt) ;
			           dem_dor_40ft = parseFloat(tml_40ft) + parseFloat(cntr_40ft) + 
			                          parseFloat(otr_40ft) + parseFloat(dor_rt) + parseFloat(stk_amt) ;
			           det_dor_40ft = parseFloat(cntr_40ft)+ 
			                          parseFloat(otr_40ft) + parseFloat(dor_rt) + parseFloat(stk_amt) ;
			          
						sheetObj.CellValue2(Row, "dem_dor_20ft") = dem_dor_20ft;
						sheetObj.CellValue2(Row, "det_dor_20ft") = det_dor_20ft;
						sheetObj.CellValue2(Row, "dem_dor_40ft") = dem_dor_40ft;
						sheetObj.CellValue2(Row, "det_dor_40ft") = det_dor_40ft;
						
						 dem_cy_20ft  = parseFloat(tml_20ft) + parseFloat(cntr_20ft) + 
			                            parseFloat(otr_20ft) + parseFloat(cy_rt) + parseFloat(stk_amt) ;
			             det_cy_20ft =  parseFloat(cntr_20ft) + 
                                        parseFloat(otr_20ft) + parseFloat(cy_rt) + parseFloat(stk_amt) ;
			             dem_cy_40ft  = parseFloat(tml_40ft) + parseFloat(cntr_40ft) +
                                        parseFloat(otr_40ft) + parseFloat(cy_rt) + parseFloat(stk_amt) ;
                         det_cy_40ft =  parseFloat(cntr_40ft)+ 
                                        parseFloat(otr_40ft) + parseFloat(cy_rt) + parseFloat(stk_amt) ;
		
						sheetObj.CellValue2(Row, "dem_cy_20ft") = dem_cy_20ft;
						sheetObj.CellValue2(Row, "det_cy_20ft") = det_cy_20ft;
						sheetObj.CellValue2(Row, "dem_cy_40ft") = dem_cy_40ft;
						sheetObj.CellValue2(Row, "det_cy_40ft") = det_cy_40ft;
					break;

				case "yd_cd":
					   var yd = sheetObj.CellValue(Row,  "yd_cd");
					   formObj.yd_cd.value = yd;
				       doActionIBSheet(sheetObj,document.form, IBSEARCH_YARD);
				       var sStr = formObj.yd_info.value;
				       if (sStr ==""){
				    	   ComShowCodeMessage("DMT00110", "Yard");
							 sheetObj.CellValue2(Row, "yd_cd") = "";
							 return false; 
				       }
				       
				       var arrStr = sStr.split("|");
				       var yd_nm = arrStr[0];
				       var dmdt_ofc_cd = arrStr[1];
				       var dem_ib_clt_flg = arrStr[2];  // DEM_OB_CLT_FLG = arrStr[3]
				       var dem_calc_tp = arrStr[4];
				       sheetObj.CellValue2(Row, "yd_nm") = yd_nm;
				       sheetObj.CellValue2(Row, "dmdt_ofc_cd") = dmdt_ofc_cd;
				       sheetObj.CellValue2(Row, "dem_ib_clt_flg") = dem_ib_clt_flg; 
				       sheetObj.CellValue2(Row, "dmdt_calc_tp_cd") = dem_calc_tp; 
				       
				break;
			}
		}
	 }
 	
	function sheet1_OnPopupClick(sheetObj, row,col){
		if (sheetObj.ColSaveName(col) == "eff_dt") {
			var cal = new ComCalendarGrid("eff_dt");
			cal.select(sheetObj, row, col, 'yyyy-MM-dd');
	
		}
		if (sheetObj.ColSaveName(col) == "exp_dt") {
			var cal2 = new ComCalendarGrid("exp_dt");
			cal2.select(sheetObj, row, col, 'yyyy-MM-dd');
		}
	
	}
	

	
    /*
    * Validity 선택시 Value 지정
    */
   function doValidity1() {
         var formObj = document.form;
   
         if (formObj.chk_current_flg.checked) {
        	 formObj.chk_current.value ="Y";
         } else {
        	 formObj.chk_current.value ="N";
         }
   }
   
   function doValidity2() {
       var formObj = document.form;
 
       if (formObj.chk_tobe_flg.checked) {
      	 formObj.chk_tobe.value ="Y";
       } else {
      	 formObj.chk_tobe.value ="N";
       }
   }  
   function doValidity3() {
       var formObj = document.form;
 
       if (formObj.chk_expired_flg.checked) {
      	 formObj.chk_expired.value ="Y";
       } else {
      	 formObj.chk_expired.value ="N";
       }
    }  	
   function setAmountSum(sheetObj) {

	   for (var j= sheetObj.HeaderRows ; j <= sheetObj.LastRow  ; j++) {
			var tml_20ft  = 0;
			var cntr_20ft = 0;
			var otr_20ft  = 0;
			var tml_40ft  = 0;
			var cntr_40ft = 0;
			var otr_40ft  = 0;
			var cy_rt     = 0;
			var dor_rt    = 0;
			var stk_amt   = 0;
			
			var dem_cy_20ft = 0;
			var dem_cy_40ft = 0;
			var dem_dor_20ft = 0;
			var dem_dor_40ft = 0;
			var det_cy_20ft = 0;
			var det_cy_40ft = 0;
			var det_dor_20ft = 0;
			var det_dor_40ft = 0;
  		
	        tml_20ft  = sheetObj.CellValue(j, "tml_cost_20ft_rt_amt");
	        tml_40ft  = sheetObj.CellValue(j, "tml_cost_40ft_rt_amt");
	        cntr_20ft = sheetObj.CellValue(j, "cntr_cost_20ft_rt_amt");
	        cntr_40ft = sheetObj.CellValue(j, "cntr_cost_40ft_rt_amt");
	        cntr_stk  = sheetObj.CellValue(j, "cntr_cost_stk_amt");
	        cy_rt     = sheetObj.CellValue(j, "chg_cost_cy_rt_amt");
	        dor_rt    = sheetObj.CellValue(j, "chg_cost_dor_rt_amt");
	        otr_20ft  = sheetObj.CellValue(j, "otr_cost_20ft_rt_amt");
	        otr_40ft  = sheetObj.CellValue(j, "otr_cost_40ft_rt_amt");
	        stk_amt   = sheetObj.CellValue(j, "cntr_cost_stk_amt");
	        
	        if(tml_20ft == "" ) tml_20ft = 0;
	        if(cntr_20ft=="") cntr_20ft = 0;
	        if(otr_20ft=="") otr_20ft = 0;
	        if(cy_rt=="") cy_rt = 0;
	        if(dor_rt=="") dor_rt = 0;
	        if(tml_40ft=="") tml_40ft = 0;
	        if(cntr_40ft=="") cntr_40ft = 0;
	        if(otr_40ft=="") otr_40ft = 0;
	        if(stk_amt=="") stk_amt = 0;
	        
			 dem_cy_20ft  = parseFloat(tml_20ft) + parseFloat(cntr_20ft) + 
                            parseFloat(otr_20ft) + parseFloat(cy_rt) + parseFloat(stk_amt) ;
             dem_dor_20ft = parseFloat(tml_20ft) + parseFloat(cntr_20ft) + 
                            parseFloat(otr_20ft) + parseFloat(dor_rt) + parseFloat(stk_amt) ;
             det_cy_20ft =  parseFloat(cntr_20ft) + 
                            parseFloat(otr_20ft) + parseFloat(cy_rt) + parseFloat(stk_amt) ;
             det_dor_20ft = parseFloat(cntr_20ft) + 
                            parseFloat(otr_20ft) + parseFloat(dor_rt) + parseFloat(stk_amt) ;
 			
			 dem_cy_40ft  = parseFloat(tml_40ft) + parseFloat(cntr_40ft) +
                            parseFloat(otr_40ft) + parseFloat(cy_rt) + parseFloat(stk_amt) ;
			 dem_dor_40ft = parseFloat(tml_40ft) + parseFloat(cntr_40ft) + 
			                parseFloat(otr_40ft) + parseFloat(dor_rt) + parseFloat(stk_amt) ;
			 det_cy_40ft =  parseFloat(cntr_40ft)+ 
			                parseFloat(otr_40ft) + parseFloat(cy_rt) + parseFloat(stk_amt) ;
			 det_dor_40ft = parseFloat(cntr_40ft)+ 
			                parseFloat(otr_40ft) + parseFloat(dor_rt) + parseFloat(stk_amt) ;		
             
            sheetObj.CellValue2(j, "dem_cy_20ft")  = dem_cy_20ft;
			sheetObj.CellValue2(j, "dem_dor_20ft") = dem_dor_20ft;
			sheetObj.CellValue2(j, "det_cy_20ft")  = det_cy_20ft;
			sheetObj.CellValue2(j, "det_dor_20ft") = det_dor_20ft;
			
			sheetObj.CellValue2(j, "dem_cy_40ft")  = dem_cy_40ft;
			sheetObj.CellValue2(j, "dem_dor_40ft") = dem_dor_40ft;
			sheetObj.CellValue2(j, "det_cy_40ft")  = det_cy_40ft;
			sheetObj.CellValue2(j, "det_dor_40ft") = det_dor_40ft;

	   } 
   }
	   
    /* 개발자 작업  끝 */