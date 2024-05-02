/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0100.js
*@FileTitle : ROB Container List Inquiry 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.30
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.01.30 민정호
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
     * @class ees_ctm_0408 : ees_ctm_0408 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_joo_0100() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject        	= setSheetObject;
        this.loadPage              		= loadPage;
        this.initSheet             		= initSheet;        
    	this.initControl 					= initControl;        
        this.doActionIBSheet       	= doActionIBSheet;
    } 

/* 개발자 작업 */


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

        var sheetObj = sheetObjects[0];
        var sheetObj2 = sheetObjects[1];
        
        var formObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_retrieve":                	
        			doActionIBSheet(sheetObj, formObj, IBSEARCH);
                    break;

                case "btn_retrieve2":                	
        			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
                    break;
                    
                case "btn_retrieve3":                	
        			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
                    break;
                    
                case "btn_retrieve4":                	
        			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
                    break;                    

                case "btn_retrieve5":                	
        			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04);
                    break;                    
                    
                case "btn_new":
        			document.form.reset();
        			sheetObj.RemoveAll();
        			sheetObj2.RemoveAll();
        			comboObjects[0].RemoveAll();        			
        			formObj.in_vvd_cd.focus();        	
                    break;

        		case "btn_downExcel":
        			doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
        			break;                    
        			
                case "btn_ratio":
  				    ComOpenPopup("/hanjin/FNS_JOO_0101.do", 1000, 420,"getFNS_JOO_0101", "1,0,1,1,1,1,1,1");					  					  
                    break;        			
                    
                case "btn_downexcel":
/*                	
				   sheetObjects[1].Down2Excel(-1);				   
				   sheetObjects[0].Down2Excel(-1, true, false, true);
*/				                   	
         		   var columnSkipList = "sub_chk|all_wgt_c|all_teu|all_wgt" +
         		   								  "|ttl_20|ttl_40|ttl_20_40|ttl_hc_20|add_hc_20|ttl_hc_40|ttl_hc_20_40" +
         		   								  "|add_hc_40|ttl_hc_45|ttl_hc_20_45|addu_hc_45|addo_hc_45|add_ttl_20|add_ttl_40|addu_ttl_45|addo_ttl_45" +
         		   							      "|mt_teu|mt_wt|teu_qty"+
         		   							      "|jo_20ft_sub_teu_qty|jo_20ft_n1st_rto|jo_40ft_sub_teu_qty|jo_40ft_n1st_rto"+
         		   							      "|jo_45ft_sub_teu_qty|jo_45ft_n1st_rto|jo_45ft_n2nd_rto|jo_rnd_rule_lvl"
         		   								  ;                					   				  
				   sheetObjects[1].Down2Excel(1,false,false,true,"","",false,false,"ROB",false,columnSkipList);
				   sheetObjects[0].Down2Excel(-1, true, false, true);
				   
                   break;                    
            } // end switch
        } catch(e) {
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

    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++] = combo_obj;
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
            initSheet(sheetObjects[i], i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
    	// IBMultiCombo초기화
    	for ( var k = 0; k < comboObjects.length; k++) {
    	    initCombo(comboObjects[k],k+1);
    	}
    	
    	initControl();    	
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
    	// ** Date 구분자 **/
    	DATE_SEPARATOR = "-";

    	var formObject = document.form;
    	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
    	axon_event.addListenerForm('blur', 'obj_deactivate', formObject); // - 포커스
    	// 나갈때
    	axon_event.addListenerFormat('focus', 'obj_activate', formObject); // - 포커스
    	// 들어갈때
    	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // -
    	// 키보드
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
    	
    	document.form.in_vvd_cd.focus();
    }

    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	var formObject = document.form;
        var obj     = event.srcElement;    	
    	    	                
        switch (obj.name){
	        case  'in_vvd_cd':
	        	     	
	              if( obj.value.length == 9   ){
	                  doActionIBSheet(sheetObjects[0], formObject, SEARCHLIST01);
	              }else{
	                  sheetObjects[0].RemoveAll();
	                  sheetObjects[1].RemoveAll();
 	            	  comboObjects[0].RemoveAll();
	            	  formObject.in_pol_yd_cd.value = '';
	            	  formObject.clpt_ind_seq.value = '';
	            	  formObject.in_pol_yd.value = '';
	              }	        	
	              break;
	        }    	
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
     */
    function obj_keypress() {
    	switch (event.srcElement.dataformat) {
    	case "uppernum":
    		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
    		ComKeyOnlyAlphabet('uppernum');
    		break;
    	case "upper":
    		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
    		ComKeyOnlyAlphabet('upper');
    		break;
    	case "uppernum2":
    		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
    		ComKeyAlphabetNChar('uppernum');
    		break;
        case "engupspecial": // 영문대문자 + Space + &-,.
        	ComKeyOnlyAlphabet('uppernum', "32|38|45|44|46");
    	    break;
    	default:
    		// 숫자만입력하기(정수,날짜,시간)
    		ComKeyOnlyNumber(event.srcElement);
    	}
    }
    
    /**
     * 콤보 초기설정값
     * 
     * @param {IBMultiCombo}
     *            comboObj comboObj
     */
    function initCombo(comboObj, comboNo) {
        var formObj = document.form
        
        switch(comboNo) {       		
        	case 1: 
                with (comboObj) { 
        		    UseCode = false;
     				MultiSelect = false; 
     				UseAutoComplete = true;
     				SetColAlign("left|left|left|left|left|left");        
     				SetColWidth("50|70|50|50|130|130"); 				 				
      				DropHeight = 160;
     				ValidChar(2,0);//영문대문자
    				SetTitle("Seq.|Port|Yard|Ind|ETA DT|ETD DT");     				
    				ShowCol(1);
      		    }
      			break;      	
     	} 
    }
    
    /**
     * ROB Port 세팅, Yard 세팅
     * 
     */    
    function rob_port_cd_OnChange(comboObj) {
        var formObj = document.form
        
        if(comboObjects[0].GetCount() > 0){                        
	        formObj.in_pol_cd.value = comboObj.GetText (comboObj.Index,1);   
	        formObj.in_pol_yd_cd.value = comboObj.GetText (comboObj.Index,2);
	        formObj.clpt_ind_seq.value = comboObj.GetText (comboObj.Index,3);
	        if(comboObj.GetText (comboObj.Index,3) == 1){
	        	formObj.in_pol_yd.value = comboObj.GetText (comboObj.Index,2);	
	        }else{
	        	formObj.in_pol_yd.value = comboObj.GetText (comboObj.Index,2)+'('+comboObj.GetText (comboObj.Index,3)+')';
	        }
	        
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
    	
    	switch (sheetID) {
    	case "sheet1": // sheet1 init
    		with (sheetObj) {	
			// 높이 설정
			style.height = 302;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 5, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)
			
			// 틀고정 설정
			//FrozenCols = 14;
			
			var HeadTitle1 = "ibflag|cntr_no2|Seq.|Sel.|VVD CD|Container No.|" +
									"TP|Seal No.|Kind/Code|Kind/Code|W/O|WGT|WGT (T)|E.WGT (T)|" +
									"PKG|PKG|Booking No.|B/L No.|POR|POR|POR|" +
									"A/POL|A/POL|A/POL|A/POD|A/POD|A/POD|B/POL|B/POL|B/POL|B/POD|B/POD|B/POD|DEL|DEL|DEL|" +
									"BS|R|D|TS|CTP|Hot|Special Cargo|Special Cargo|" +
									"Former Lane|Former VVD|Customer|Customs Description|Yard|Discharging Date|S.O.C|" +
									"STOW|Rail Hub|HTS Code|HS Code|Meas|" +
									"Pre1.VVD|Pre2.VVD|Pre3.VVD|Pre4.VVD|Trunk VVD|Post1.VVD|Post2.VVD|Post3.VVD|Post4.VVD|" +
									"Pre1.POL|Pre2.POL|Pre3.POL|Pre4.POL|Post1.POL|Post2.POL|Post3.POL|Post4.POL";			
			
			
					
			var headCount = ComCountHeadTitle(HeadTitle1);	
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]										
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cntr_no2", false, "", dfNone, 0, false, true, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true, "seq", false, "", dfNone, 0, false, true, false);
			InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false, "del_chk");
			InitDataProperty(0, cnt++, dtHidden, 170, daCenter, false, "out_vvd_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cntr_no", false, "", dfNone, 0, false, true);
			
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "cntr_tpsz_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, "cntr_seal_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "seal_knd_cd", false, "", dfNone, 0, false, true, 1);
			InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false, "seal_pty_tp_cd", false, "", dfNone, 0, false, true, 2);
			InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false, "wo_flg", false, "", dfNone, 0, false, true, 2);
			InitDataProperty(0, cnt++, dtData, 90, daRight, false, "a_cntr_wgt", false, "", dfFloat, 2, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daRight, false, "cntr_wgt", false, "", dfFloat, 2, false, true);
			InitDataProperty(0, cnt++, dtData, 65, daRight, false, "e_cntr_wgt", false, "", dfFloat, 2, false, true);
			
			InitDataProperty(0, cnt++, dtHidden, 40, daRight, false, "pck_qty", false, "", dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 25, daRight, false, "pck_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 95, daLeft, false, "bkg_no", false, "", dfNone, 0, false, true);
			InitDAtaProperty(0, cnt++, dtData, 95, daLeft, false, "bl_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 45, daCenter, false, "por_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 25, daCenter, false, "por_nod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "por_nm");
			
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "pol_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 35, daCenter, false, "pol_yd_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "bpol_nm");

			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "pod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 35, daCenter, false, "pod_yd_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "bpod_nm");
			
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "a_pol_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 25, daCenter, false, "pol_nod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "apol_nm");
			
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "a_pod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 25, daCenter, false, "pod_nod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "apod_nm");
			
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "del_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 25, daCenter, false, "del_nod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "del_nm");

			InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false, "blck_stwg_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, false, "rcv_term_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, false, "de_term_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "ts_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "bkg_cgo_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "hot_de_flg", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "spcl_cgo_desc_type", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "spcl_cgo_desc", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, "slan_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "vvd_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 370, daLeft, false, "cust_nm", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "cstms_desc");
			
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "org_yd_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "cnmv_evnt_dt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "soc_flg", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtHidden, 65, daCenter, false, "stwg_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 55, daCenter, false, "blck_stwg_hub_loc_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 65, daCenter, false, "hamo_trf_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "cmdt_hs_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "meas_qty", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "prevvd1", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "prevvd2", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "prevvd3", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "prevvd4", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "trunkvvd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "postvvd1", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "postvvd2", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "postvvd3", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "postvvd4", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "pre1pol", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "pre2pol", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "pre3pol", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "pre4pol", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "post1pol", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "post2pol", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "post3pol", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "post4pol", false, "", dfNone, 0, false, true);	
								
			ShowButtonImage = 1;
			CountPosition = 0;
		}
		break;
		
        case "sheet2":      //sheet2 init
	        	with (sheetObj) {
				var rule_add_ttl_20 = "IF(|jo_20ft_n1st_rto|=1, 0, IF((|hc_ld_20|+|hc_bsa_20|-|jo_20ft_sub_teu_qty|)*(|jo_20ft_n1st_rto|-1)<0, 0, IF(|jo_rnd_rule_lvl|=1, Round((|hc_ld_20|+|hc_bsa_20|-|jo_20ft_sub_teu_qty|)*(|jo_20ft_n1st_rto|-1),0), IF(|jo_rnd_rule_lvl|=2, Ceiling((|hc_ld_20|+|hc_bsa_20|-|jo_20ft_sub_teu_qty|)*(|jo_20ft_n1st_rto|-1)), IF(|jo_rnd_rule_lvl|=3, Int((|hc_ld_20|+|hc_bsa_20|-|jo_20ft_sub_teu_qty|)*(|jo_20ft_n1st_rto|-1)), (|hc_ld_20|+|hc_bsa_20|-|jo_20ft_sub_teu_qty|)*(|jo_20ft_n1st_rto|-1))))))";
				var rule_add_ttl_40 = "IF(|jo_40ft_n1st_rto|=1, 0, IF((|hc_ld_40|+|hc_bsa_40|-|jo_40ft_sub_teu_qty|)*(|jo_40ft_n1st_rto|-2)<0, 0, IF(|jo_rnd_rule_lvl|=1, Round((|hc_ld_40|+|hc_bsa_40|-|jo_40ft_sub_teu_qty|)*(|jo_40ft_n1st_rto|-2),0), IF(|jo_rnd_rule_lvl|=2, Ceiling((|hc_ld_40|+|hc_bsa_40|-|jo_40ft_sub_teu_qty|)*(|jo_40ft_n1st_rto|-2)), IF(|jo_rnd_rule_lvl|=3, Int((|hc_ld_40|+|hc_bsa_40|-|jo_40ft_sub_teu_qty|)*(|jo_40ft_n1st_rto|-2)), (|hc_ld_40|+|hc_bsa_40|-|jo_40ft_sub_teu_qty|)*(|jo_40ft_n1st_rto|-2))))))";
				 					 
				var rule_addu_ttl_45 = "IF(|jo_45ft_n1st_rto|=2, IF(  |jo_45ft_n2nd_rto|=2, 0, IF( (|hc_ld_45|+|hc_bsa_45|)<=|jo_45ft_sub_teu_qty|, IF((|hc_ld_45|+|hc_bsa_45|)*(|jo_45ft_n1st_rto|-2)<0, 0, ROUND((|hc_ld_45|+|hc_bsa_45|)*(|jo_45ft_n1st_rto|-2),0)) , IF(|jo_45ft_sub_teu_qty|*(|jo_45ft_n1st_rto|-2)<0,0,ROUND(|jo_45ft_sub_teu_qty|*(|jo_45ft_n1st_rto|-2),0)))), IF( (|hc_ld_45|+|hc_bsa_45|)<=|jo_45ft_sub_teu_qty|, IF((|hc_ld_45|+|hc_bsa_45|)*(|jo_45ft_n1st_rto|-2)<0,0,ROUND((|hc_ld_45|+|hc_bsa_45|)*(|jo_45ft_n1st_rto|-2),0)), IF(|jo_45ft_sub_teu_qty|*(|jo_45ft_n1st_rto|-2)<0,0,ROUND(|jo_45ft_sub_teu_qty|*(|jo_45ft_n1st_rto|-2),0))))";
				var rule_addo_ttl_45 = "IF(|jo_45ft_n1st_rto|=2, IF(|jo_45ft_n2nd_rto|=2, 0, IF((|hc_ld_45|+|hc_bsa_45|)<=|jo_45ft_sub_teu_qty|, 0, IF(((|hc_ld_45|+|hc_bsa_45|)-|jo_45ft_sub_teu_qty|)*(|jo_45ft_n2nd_rto|-2)<0,0,ROUND(((|hc_ld_45|+|hc_bsa_45|)-|jo_45ft_sub_teu_qty|)*(|jo_45ft_n2nd_rto|-2),0) ))), IF((|hc_ld_45|+|hc_bsa_45|)<=|jo_45ft_sub_teu_qty|, 0, IF(((|hc_ld_45|+|hc_bsa_45|)-|jo_45ft_sub_teu_qty|)*(|jo_45ft_n2nd_rto|-2)<0,0,ROUND(((|hc_ld_45|+|hc_bsa_45|)-|jo_45ft_sub_teu_qty|)*(|jo_45ft_n2nd_rto|-2),0))))";
				 
				var rule_grand_ttl_slot = "|full_20|+|mt_20|+((|full_40|+|mt_40|)*2)+|hc_ld_20|+|hc_bsa_20|+((|hc_ld_40|+|hc_bsa_40|)*2)+((|hc_ld_45|+|hc_bsa_45|)*2)+(" + rule_add_ttl_20 + ")+(" + rule_add_ttl_40 + ")+(" + rule_addu_ttl_45 + ")+(" + rule_addo_ttl_45 +")+|ak_void|";
				
				var rule_add_hc_20 = "IF(|jo_20ft_n1st_rto|=1, 0, IF(|ttl_hc_20|-|jo_20ft_sub_teu_qty|<0, 0, |ttl_hc_20|-|jo_20ft_sub_teu_qty|))";
				var rule_add_hc_40 = "IF(|jo_40ft_n1st_rto|=2, 0, IF(|ttl_hc_40|-|jo_40ft_sub_teu_qty|<0, 0, |ttl_hc_40|-|jo_40ft_sub_teu_qty|))";
				var rule_addu_hc_45 = "IF(|jo_45ft_n1st_rto|=2, IF(|jo_45ft_n2nd_rto|=2, 0, IF(|ttl_hc_45|<=|jo_45ft_sub_teu_qty|, |ttl_hc_45|, |jo_45ft_sub_teu_qty|)), IF(|ttl_hc_45|<=|jo_45ft_sub_teu_qty|, |ttl_hc_45|, |jo_45ft_sub_teu_qty|))";
				var rule_addo_hc_45 = "IF(|jo_45ft_n1st_rto|=2, IF(|jo_45ft_n2nd_rto|=2, 0, IF(|ttl_hc_45|<=|jo_45ft_sub_teu_qty|, 0, |ttl_hc_45|-|jo_45ft_sub_teu_qty|)), IF(|ttl_hc_45|<=|jo_45ft_sub_teu_qty|, 0, |ttl_hc_45|-|jo_45ft_sub_teu_qty|))";
				 
				var rule_over_slot_c = "IF((|grand_ttl_slot|-|all_teu|) < 0, 0, |grand_ttl_slot|-|all_teu|)";
				var rule_over_wgt_c = "IF((|grand_ttl_wgt|-|all_wgt|) < 0, 0, |grand_ttl_wgt|-|all_wgt|)";													
				var rule_fin =  "IF((("+rule_over_slot_c+") >= ("+  rule_over_wgt_c + "/ |teu_qty|)), "+rule_over_slot_c+","+  rule_over_wgt_c + "/ |teu_qty|)" ;
					
				// 높이 설정
				style.height = 102;
				
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 3, 100);
					
				var HeadTitle2 = "|cal|Allocation|Allocation" +
								         "|Lane|Pass|VVD|ROB Port" +				
										"|20'|20'|20'|40'|40'|40'|40'|20'HC|20'HC|20'HC|20'HC|40'HC|40'HC|40'HC|40'HC|40'HC|45'|45'|45'|45'|45'|45'|Additional|Additional|Additional|Additional" +
										"|AK|VOID|DG|DG|RF|RF|RF ROB|RF ROB" +										
										"|EMPTY|EMPTY" +
										"|Total\nTEU|Total\nE.Weight|Over Used|Over Used" +										
										"|Final Used" +										
										"|TEU|20'HC|20'HC|40'HC|40'HC|45'|45'|45'|ROUND RULE";
				var HeadTitle3 = "|cal|TEU|WT" +
		         					    "|Lane|Pass|VVD|ROB Port" +				
										"|Full|Empty|TTL|Full|Empty|TTL|TTL(TEU)|Full|Empty|TTL|ADD|Full|Empty|TTL|TTL(TEU)|ADD|Full|Empty|TTL|TTL(TEU)|ADD(U)|ADD(O)|20'HC|40'HC|45'(U)|45'(O)" +
										"|AK|VOID|20'|40'|20'|40'|20'|40'" +
										"|TEU|WEIGHT" +
										"|Total\nTEU|Total\nE.Weight|TEU|WT" +										
										"|OUS" +
										"|TEU|Sub-Allo|Ratio|Sub-Allo|Ratio|Sub-Allo|Ratio 1|Ratio 2|ROUND RULE";
				
				
				var headCount = ComCountHeadTitle(HeadTitle2);
				
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);
								
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]				
				InitHeadRow(0, HeadTitle2, true);
				InitHeadRow(1, HeadTitle3, true);
				
				// 데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,       COLMERGE,   SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHidden,      30,     daCenter,    true,    "sub_chk",        false,    "",    dfNumber, 0, false, false);
				InitDataProperty(0, cnt++ , dtHidden,      50,     daRight,     false,    "all_wgt_c",      false,    "IF(|sub_chk|=2, |all_teu|*|all_wgt|, |all_wgt|)", dfNumber, 0, true, false);
				InitDataProperty(0, cnt++ , dtHidden,         50,     daRight,     false,    "all_teu",        false,    "",    dfNumber, 0, true, false);
				InitDataProperty(0, cnt++ , dtHidden,         50,     daRight,     false,    "all_wgt",        false,    "", dfNumber, 0, true, false);
				
				InitDataProperty(0, cnt++ , dtData,         40,     daCenter,    true,    "lane",        		false,    "",    dfNone, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,         40,     daCenter,    true,    "pass",        		false,    "",    dfNone, 0, false, false);								
				InitDataProperty(0, cnt++ , dtHidden,      30,     daCenter,    true,    "vvd",        		false,    "",    dfNone, 0, false, false);
				InitDataProperty(0, cnt++ , dtHidden,      30,     daCenter,    true,    "rob_port",       false,    "",    dfNone, 0, false, false);				
								
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "full_20",        false,    "",    dfNumber, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "mt_20",          false,    "",    dfNumber, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "ttl_20",         false,    "|full_20|+|mt_20|",    dfNumber, 0, false, false); //20120615
				
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "full_40",        false,    "",    dfNumber, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "mt_40",          false,    "",    dfNumber, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "ttl_40",         false,    "|full_40|+|mt_40|",    dfNumber, 0, false, false); //20120615
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "ttl_20_40",      false,    "|ttl_40|*2",    dfNumber, 0, false, false); //20120615
				
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     true,     "hc_ld_20",       false,    "",    dfNumber, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     true,     "hc_bsa_20",      false,    "",    dfNumber, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "ttl_hc_20",      false,    "|hc_ld_20|+|hc_bsa_20|",    dfNumber, 0, false, false); //20120615
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "add_hc_20",      false,    rule_add_hc_20, dfNumber, 0, false, false); //20120615
				
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     true,     "hc_ld_40",       false,    "",    dfNumber, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     true,     "hc_bsa_40",      false,    "",    dfNumber, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "ttl_hc_40",      false,    "|hc_ld_40|+|hc_bsa_40|",    dfNumber, 0, false, false); //20120615
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "ttl_hc_20_40",   false,    "(|hc_ld_40|+|hc_bsa_40|)*2",    dfNumber, 0, false, false); //20120615
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "add_hc_40",      false,    rule_add_hc_40, dfNumber, 0, false, false); //20120615
				
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     true,     "hc_ld_45",       false,    "",    dfNumber, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     true,     "hc_bsa_45",      false,    "",    dfNumber, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "ttl_hc_45",      false,    "|hc_ld_45|+|hc_bsa_45|",    dfNumber, 0, false, false); //20120615
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "ttl_hc_20_45",   false,    "|ttl_hc_45|*2",    dfNumber, 0, false, false); //20120615
				 
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "addu_hc_45",     false, rule_addu_hc_45, dfNumber, 0, false, false); //20120615
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "addo_hc_45",     false, rule_addo_hc_45, dfNumber, 0, false, false); //20120615
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "add_ttl_20",     false, rule_add_ttl_20, dfNumber, 0, false, false); //20120615
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "add_ttl_40",     false, rule_add_ttl_40, dfNumber, 0, false, false); //20120615
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "addu_ttl_45",    false, rule_addu_ttl_45, dfNumber, 0, false, false); //20120615
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "addo_ttl_45",    false, rule_addo_ttl_45, dfNumber, 0, false, false); //20120615
				
				InitDataProperty(0, cnt++ , dtData,         50,     daRight,     true,    "ak_unit",        false,    "",    dfNumber, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,         50,     daRight,     true,    "ak_void",        false,    "",    dfNumber, 0, false, false);
				
				InitDataProperty(0, cnt++ , dtData,         40,     daRight,     true,    "dg_20",        false,    "",    dfNumber, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,         40,     daRight,     true,    "dg_40",        false,    "",    dfNumber, 0, false, false);
				
				InitDataProperty(0, cnt++ , dtData,         40,     daRight,     true,    "rf_20_qty",      false,    "",    dfNumber, 0, false, false);				
				InitDataProperty(0, cnt++ , dtData,         40,     daRight,     true,    "rf_40_qty",      false,    "",    dfNumber, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,         40,     daRight,     true,    "rf_rdr_20",      false,    "",    dfNumber, 0, false, false);				
				InitDataProperty(0, cnt++ , dtData,         40,     daRight,     true,    "rf_rdr_40",      false,    "",    dfNumber, 0, false, false);				
				
				InitDataProperty(0, cnt++ , dtHidden,      50,     daRight,     true,    "mt_teu",         false,    "",    dfNumber, 0, false, false);
				InitDataProperty(0, cnt++ , dtHidden,      50,     daRight,     true,     "mt_wt",           false,    "",    dfNumber, 0, false, false);
				
				InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,    "grand_ttl_slot", false,    rule_grand_ttl_slot, dfFloat, 2, false, false);
				InitDataProperty(0, cnt++ , dtData,         65,     daRight,     true,    "grand_ttl_wgt",  false,    "",    dfFloat, 2, false, false);
				InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,    "over_slot_c",    false,    rule_over_slot_c,    dfFloat, 2, false, false);
				InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,    "over_wgt_c",     false,    rule_over_wgt_c,     dfFloat, 2, false, false);
				InitDataProperty(0, cnt++ , dtData,         65,     daRight,     true,    "fin_used",       	 false,    "",    dfFloat, 2, false, false);				
				
				InitDataProperty(0, cnt++ , dtHidden,      50,     daRight,     true,    "teu_qty",         false,    "",    dfFloat, 2, false, false);				
				 
				 //2012.06.19추가
				 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	false,  "jo_20ft_sub_teu_qty",  false, "", dfInteger, 2,  true, true, 9);
				 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	false,  "jo_20ft_n1st_rto",  	false, "", dfFloat, 2,  true, true, 5);
				 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	false,  "jo_40ft_sub_teu_qty",  false, "", dfInteger, 2,  true, true, 9);
				 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	false,  "jo_40ft_n1st_rto",     false, "", dfFloat, 2,  true, true, 5);
				 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	false,  "jo_45ft_sub_teu_qty", 	false, "", dfInteger, 2,  true, true, 9);
				 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	false,  "jo_45ft_n1st_rto", 	false, "", dfFloat, 2,  true, true, 5);
				 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	false,  "jo_45ft_n2nd_rto", 	false, "", dfFloat, 2,  true, true, 5);
				 InitDataProperty(0, cnt++ , dtHidden,	80, daCenter,	false,  "jo_rnd_rule_lvl", 		false, "", dfNone, 2,  true, true);
				
				 ColHidden("ttl_20") = true;
				 ColHidden("ttl_40") = true;
				 ColHidden("ttl_20_40") = true;
				 ColHidden("ttl_hc_20") = true;
				 ColHidden("add_hc_20") = true;
				 ColHidden("ttl_hc_40") = true;
				 ColHidden("ttl_hc_20_40") = true;
				 ColHidden("add_hc_40") = true;
				 ColHidden("ttl_hc_45") = true;
				 ColHidden("ttl_hc_20_45") = true;
				 ColHidden("addu_hc_45") = true;
				 ColHidden("addo_hc_45") = true;
				 ColHidden("add_ttl_20") = true;
				 ColHidden("add_ttl_40") = true;
				 ColHidden("addu_ttl_45") = true;
				 ColHidden("addo_ttl_45") = true;
				 
				ShowButtonImage = 1;
				CountPosition = 0;				 
				// 틀고정 설정
				FrozenCols = 5;						
	        }
            break;
        }        	
    }
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
            case IBSEARCH:      //조회            	               		
               		if( formObj.in_vvd_cd.value.length != 9){
        				ComShowCodeMessage("JOO00031");
               			return;
               		}
            		 
               		if( formObj.in_pol_cd.value.length <= 0){
        				ComShowCodeMessage("JOO00200");
               			return;
               		}
            		
               		if( formObj.in_pol_yd_cd.value.length <= 0){
        				ComShowCodeMessage("JOO00200");
               			return;
               		}
            	
                    sheetObjects[0].WaitImageVisible = false;
                    sheetObjects[1].WaitImageVisible = false;
                    ComOpenWait(true);
                    
	    			if (formObj.in_dcgo_flg.checked)
	    				formObj.in_dcgo_flg.value = "Y";
	    			else
	    				formObj.in_dcgo_flg.value = "";
	
	    			if (formObj.in_rc_flg.checked)
	    				formObj.in_rc_flg.value = "Y";
	    			else
	    				formObj.in_rc_flg.value = "";
	
	    			if (formObj.in_awk_cgo_flg.checked)
	    				formObj.in_awk_cgo_flg.value = "Y";
	    			else
	    				formObj.in_awk_cgo_flg.value = "";
	
	    			if (formObj.in_bb_cgo_flg.checked)
	    				formObj.in_bb_cgo_flg.value = "Y";
	    			else
	    				formObj.in_bb_cgo_flg.value = "";
	
	    			if (formObj.in_stwg_cd.checked)
	    				formObj.in_stwg_cd.value = "Y";
	    			else
	    				formObj.in_stwg_cd.value = "";
	
	    			if (formObj.in_hot_de_flg.checked)
	    				formObj.in_hot_de_flg.value = "Y";
	    			else
	    				formObj.in_hot_de_flg.value = "";
	
	    			if (formObj.in_rd_cgo_flg.checked)
	    				formObj.in_rd_cgo_flg.value = "Y";
	    			else
	    				formObj.in_rd_cgo_flg.value = "";
	
	    			if (formObj.in_soc_flg.checked)
	    				formObj.in_soc_flg.value = "Y";
	    			else
	    				formObj.in_soc_flg.value = "";
	
	    			if (formObj.in_prct_flg.checked)
	    				formObj.in_prct_flg.value = "Y";
	    			else
	    				formObj.in_prct_flg.value = "";
	    			
	    			if (formObj.in_hngr_flg.checked)
	    				formObj.in_hngr_flg.value = "Y";
	    			else
	    				formObj.in_hngr_flg.value = "";
	    			
	    			formObj.pol_split_no.value = formObj.clpt_ind_seq.value;	    			
	                formObj.f_cmd.value = SEARCH;
	                
                    var xml = sheetObj.GetSearchXml("FNS_JOO_0100GS.do", FormQueryString(formObj));
                    var rtnValue = xml.split("|$$|");
                    sheetObjects[0].LoadSearchXml(rtnValue[0]);
                    sheetObjects[1].LoadSearchXml(rtnValue[1]);
                break;
                
                
            case IBSEARCH_ASYNC01:      //조회            	               		
           		if( formObj.in_vvd_cd.value.length != 9){
    				ComShowCodeMessage("JOO00031");
           			return;
           		}
        		 
           		if( formObj.in_pol_cd.value.length <= 0){
    				ComShowCodeMessage("JOO00200");
           			return;
           		}
        		
           		if( formObj.in_pol_yd_cd.value.length <= 0){
    				ComShowCodeMessage("JOO00200");
           			return;
           		}
        	
                sheetObjects[0].WaitImageVisible = false;
                sheetObjects[1].WaitImageVisible = false;
                ComOpenWait(true);
                
    			if (formObj.in_dcgo_flg.checked)
    				formObj.in_dcgo_flg.value = "Y";
    			else
    				formObj.in_dcgo_flg.value = "";

    			if (formObj.in_rc_flg.checked)
    				formObj.in_rc_flg.value = "Y";
    			else
    				formObj.in_rc_flg.value = "";

    			if (formObj.in_awk_cgo_flg.checked)
    				formObj.in_awk_cgo_flg.value = "Y";
    			else
    				formObj.in_awk_cgo_flg.value = "";

    			if (formObj.in_bb_cgo_flg.checked)
    				formObj.in_bb_cgo_flg.value = "Y";
    			else
    				formObj.in_bb_cgo_flg.value = "";

    			if (formObj.in_stwg_cd.checked)
    				formObj.in_stwg_cd.value = "Y";
    			else
    				formObj.in_stwg_cd.value = "";

    			if (formObj.in_hot_de_flg.checked)
    				formObj.in_hot_de_flg.value = "Y";
    			else
    				formObj.in_hot_de_flg.value = "";

    			if (formObj.in_rd_cgo_flg.checked)
    				formObj.in_rd_cgo_flg.value = "Y";
    			else
    				formObj.in_rd_cgo_flg.value = "";

    			if (formObj.in_soc_flg.checked)
    				formObj.in_soc_flg.value = "Y";
    			else
    				formObj.in_soc_flg.value = "";

    			if (formObj.in_prct_flg.checked)
    				formObj.in_prct_flg.value = "Y";
    			else
    				formObj.in_prct_flg.value = "";
    			
    			if (formObj.in_hngr_flg.checked)
    				formObj.in_hngr_flg.value = "Y";
    			else
    				formObj.in_hngr_flg.value = "";
    			
    			formObj.pol_split_no.value = formObj.clpt_ind_seq.value;	    			
                formObj.f_cmd.value = SEARCH01;
                
                var xml = sheetObj.GetSearchXml("FNS_JOO_0100GS.do", FormQueryString(formObj));
                var rtnValue = xml.split("|$$|");
                sheetObjects[0].LoadSearchXml(rtnValue[0]);
                sheetObjects[1].LoadSearchXml(rtnValue[1]);
            break;                
                                            
            case IBSEARCH_ASYNC02:      //조회            	               		
           		if( formObj.in_vvd_cd.value.length != 9){
    				ComShowCodeMessage("JOO00031");
           			return;
           		}
        		 
           		if( formObj.in_pol_cd.value.length <= 0){
    				ComShowCodeMessage("JOO00200");
           			return;
           		}
        		
           		if( formObj.in_pol_yd_cd.value.length <= 0){
    				ComShowCodeMessage("JOO00200");
           			return;
           		}
        	
                sheetObjects[0].WaitImageVisible = false;
                sheetObjects[1].WaitImageVisible = false;
                ComOpenWait(true);
                
    			if (formObj.in_dcgo_flg.checked)
    				formObj.in_dcgo_flg.value = "Y";
    			else
    				formObj.in_dcgo_flg.value = "";

    			if (formObj.in_rc_flg.checked)
    				formObj.in_rc_flg.value = "Y";
    			else
    				formObj.in_rc_flg.value = "";

    			if (formObj.in_awk_cgo_flg.checked)
    				formObj.in_awk_cgo_flg.value = "Y";
    			else
    				formObj.in_awk_cgo_flg.value = "";

    			if (formObj.in_bb_cgo_flg.checked)
    				formObj.in_bb_cgo_flg.value = "Y";
    			else
    				formObj.in_bb_cgo_flg.value = "";

    			if (formObj.in_stwg_cd.checked)
    				formObj.in_stwg_cd.value = "Y";
    			else
    				formObj.in_stwg_cd.value = "";

    			if (formObj.in_hot_de_flg.checked)
    				formObj.in_hot_de_flg.value = "Y";
    			else
    				formObj.in_hot_de_flg.value = "";

    			if (formObj.in_rd_cgo_flg.checked)
    				formObj.in_rd_cgo_flg.value = "Y";
    			else
    				formObj.in_rd_cgo_flg.value = "";

    			if (formObj.in_soc_flg.checked)
    				formObj.in_soc_flg.value = "Y";
    			else
    				formObj.in_soc_flg.value = "";

    			if (formObj.in_prct_flg.checked)
    				formObj.in_prct_flg.value = "Y";
    			else
    				formObj.in_prct_flg.value = "";
    			
    			if (formObj.in_hngr_flg.checked)
    				formObj.in_hngr_flg.value = "Y";
    			else
    				formObj.in_hngr_flg.value = "";
    			
    			formObj.pol_split_no.value = formObj.clpt_ind_seq.value;	    			
                formObj.f_cmd.value = SEARCH02;
                
                var xml = sheetObj.GetSearchXml("FNS_JOO_0100GS.do", FormQueryString(formObj));
                var rtnValue = xml.split("|$$|");
                sheetObjects[0].LoadSearchXml(rtnValue[0]);
                sheetObjects[1].LoadSearchXml(rtnValue[1]);
            break;               
            
            case IBSEARCH_ASYNC03:      //조회            	               		
           		if( formObj.in_vvd_cd.value.length != 9){
    				ComShowCodeMessage("JOO00031");
           			return;
           		}
        		 
           		if( formObj.in_pol_cd.value.length <= 0){
    				ComShowCodeMessage("JOO00200");
           			return;
           		}
        		
           		if( formObj.in_pol_yd_cd.value.length <= 0){
    				ComShowCodeMessage("JOO00200");
           			return;
           		}
        	
                sheetObjects[0].WaitImageVisible = false;
                sheetObjects[1].WaitImageVisible = false;
                ComOpenWait(true);
                
    			if (formObj.in_dcgo_flg.checked)
    				formObj.in_dcgo_flg.value = "Y";
    			else
    				formObj.in_dcgo_flg.value = "";

    			if (formObj.in_rc_flg.checked)
    				formObj.in_rc_flg.value = "Y";
    			else
    				formObj.in_rc_flg.value = "";

    			if (formObj.in_awk_cgo_flg.checked)
    				formObj.in_awk_cgo_flg.value = "Y";
    			else
    				formObj.in_awk_cgo_flg.value = "";

    			if (formObj.in_bb_cgo_flg.checked)
    				formObj.in_bb_cgo_flg.value = "Y";
    			else
    				formObj.in_bb_cgo_flg.value = "";

    			if (formObj.in_stwg_cd.checked)
    				formObj.in_stwg_cd.value = "Y";
    			else
    				formObj.in_stwg_cd.value = "";

    			if (formObj.in_hot_de_flg.checked)
    				formObj.in_hot_de_flg.value = "Y";
    			else
    				formObj.in_hot_de_flg.value = "";

    			if (formObj.in_rd_cgo_flg.checked)
    				formObj.in_rd_cgo_flg.value = "Y";
    			else
    				formObj.in_rd_cgo_flg.value = "";

    			if (formObj.in_soc_flg.checked)
    				formObj.in_soc_flg.value = "Y";
    			else
    				formObj.in_soc_flg.value = "";

    			if (formObj.in_prct_flg.checked)
    				formObj.in_prct_flg.value = "Y";
    			else
    				formObj.in_prct_flg.value = "";
    			
    			if (formObj.in_hngr_flg.checked)
    				formObj.in_hngr_flg.value = "Y";
    			else
    				formObj.in_hngr_flg.value = "";
    			
    			formObj.pol_split_no.value = formObj.clpt_ind_seq.value;	    			
                formObj.f_cmd.value = SEARCH03;
                
                var xml = sheetObj.GetSearchXml("FNS_JOO_0100GS.do", FormQueryString(formObj));
                var rtnValue = xml.split("|$$|");
                sheetObjects[0].LoadSearchXml(rtnValue[0]);
                sheetObjects[1].LoadSearchXml(rtnValue[1]);
            break;               


            case IBSEARCH_ASYNC04:      //조회            	               		
           		if( formObj.in_vvd_cd.value.length != 9){
    				ComShowCodeMessage("JOO00031");
           			return;
           		}
        		 
           		if( formObj.in_pol_cd.value.length <= 0){
    				ComShowCodeMessage("JOO00200");
           			return;
           		}
        		
           		if( formObj.in_pol_yd_cd.value.length <= 0){
    				ComShowCodeMessage("JOO00200");
           			return;
           		}
        	
                sheetObjects[0].WaitImageVisible = false;
                sheetObjects[1].WaitImageVisible = false;
                ComOpenWait(true);
                
    			if (formObj.in_dcgo_flg.checked)
    				formObj.in_dcgo_flg.value = "Y";
    			else
    				formObj.in_dcgo_flg.value = "";

    			if (formObj.in_rc_flg.checked)
    				formObj.in_rc_flg.value = "Y";
    			else
    				formObj.in_rc_flg.value = "";

    			if (formObj.in_awk_cgo_flg.checked)
    				formObj.in_awk_cgo_flg.value = "Y";
    			else
    				formObj.in_awk_cgo_flg.value = "";

    			if (formObj.in_bb_cgo_flg.checked)
    				formObj.in_bb_cgo_flg.value = "Y";
    			else
    				formObj.in_bb_cgo_flg.value = "";

    			if (formObj.in_stwg_cd.checked)
    				formObj.in_stwg_cd.value = "Y";
    			else
    				formObj.in_stwg_cd.value = "";

    			if (formObj.in_hot_de_flg.checked)
    				formObj.in_hot_de_flg.value = "Y";
    			else
    				formObj.in_hot_de_flg.value = "";

    			if (formObj.in_rd_cgo_flg.checked)
    				formObj.in_rd_cgo_flg.value = "Y";
    			else
    				formObj.in_rd_cgo_flg.value = "";

    			if (formObj.in_soc_flg.checked)
    				formObj.in_soc_flg.value = "Y";
    			else
    				formObj.in_soc_flg.value = "";

    			if (formObj.in_prct_flg.checked)
    				formObj.in_prct_flg.value = "Y";
    			else
    				formObj.in_prct_flg.value = "";
    			
    			if (formObj.in_hngr_flg.checked)
    				formObj.in_hngr_flg.value = "Y";
    			else
    				formObj.in_hngr_flg.value = "";
    			
    			formObj.pol_split_no.value = formObj.clpt_ind_seq.value;	    			
                formObj.f_cmd.value = SEARCH04;
                
                var xml = sheetObj.GetSearchXml("FNS_JOO_0100GS.do", FormQueryString(formObj));
                var rtnValue = xml.split("|$$|");
                sheetObjects[0].LoadSearchXml(rtnValue[0]);
                sheetObjects[1].LoadSearchXml(rtnValue[1]);
            break;               
            
            case SEARCHLIST01:      //ROB Port 조회
            	formObj.f_cmd.value = SEARCHLIST01;            
                var param =  FormQueryString(formObj);
                var sXml  =  sheetObj.GetSearchXml("FNS_JOO_0100GS.do", param);
                                
				var clptSeqList = ComGetEtcData(sXml, "clpt_seq").split("|");
				var portCdList = ComGetEtcData(sXml, "vps_port_cd").split("|");
				var tmlCdlList = ComGetEtcData(sXml, "tml_cd").split("|");			
				var clptIndSeqList = ComGetEtcData(sXml, "clpt_ind_seq").split("|");
				var etaDtList = ComGetEtcData(sXml, "eta_dt").split("|");
				var etdDtList = ComGetEtcData(sXml, "etd_dt").split("|");				
                
				comboObjects[0].RemoveAll();
		        formObj.in_pol_cd.value = "";				
				formObj.in_pol_yd_cd.value = '';
				formObj.clpt_ind_seq.value = '';
				formObj.in_pol_yd.value = '';
												
				for(var i=0; i < clptSeqList.length; i++){
					if(clptSeqList[i] != ''){
						comboObjects[0].InsertItem(i, clptSeqList[i]+"|"+portCdList[i]+"|"+tmlCdlList[i]+"|"+clptIndSeqList[i]+"|"+etaDtList[i]+"|"+etdDtList[i], portCdList[i]);
					}
				}
				
                break;                      
        }
    }
    
    /**
     * Sheet1의 OnSearchEnd 이벤트 처리
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        ComOpenWait(false);
        sheetObjects[1].WaitImageVisible = true;
        sheetObjects[0].WaitImageVisible = true;
    }
    
    
    /**
     * Sheet2의 OnSearchEnd 이벤트 처리
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
    	var teu_qty = 0;
    	var over_slot_c = 0;
    	var over_wgt_c = 0;
    	    	
    	if(sheetObj.RowCount > 0){
    		
    		teu_qty = sheetObj.CellValue(2,"teu_qty");
    		over_slot_c = sheetObj.CellValue(2,"over_slot_c");
    		over_wgt_c = sheetObj.CellValue(2,"over_wgt_c");
    		    		
    		if(over_slot_c > over_wgt_c/teu_qty){
    			sheetObj.CellValue2(2,"fin_used") = over_slot_c;
    		}else{
    			sheetObj.CellValue2(2,"fin_used") =  over_wgt_c/teu_qty;
    		}    		
    		
			sheetObj.CellValue2(2,"lane") = sheetObjects[0].CellValue(2,"slan_cd"); 
			sheetObj.CellValue2(2,"vvd") =  form.in_vvd_cd.value;
			sheetObj.CellValue2(2,"rob_port") =  form.in_pol_cd.value;
    	}    	
    }
    
    /**
     * Sub-Allocation and Ratio 닫힌 후 실행
     */
	 function getFNS_JOO_0101() {
//	        var sheetObj = sheetObjects[0];
//	        var sheetObj2 = sheetObjects[1];
//			sheetObj.RemoveAll();
//			sheetObj2.RemoveAll();			
	 }    
	 
/* 개발자 작업  끝 */
