/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0103.js
*@FileTitle : ROB Container List Summary Table
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
    function fns_joo_0103() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject        	= setSheetObject;
        this.loadPage              		= loadPage;
        this.initSheet             		= initSheet;        
    	this.initControl 					= initControl;        
        this.doActionIBSheet       	= doActionIBSheet;
        this.validateForm				= validateForm;
    } 

/* 개발자 작업 */


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var gRefresh = true;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

        var sheetObj = sheetObjects[0];
        
        var formObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
	            case "btn_call_prc":                	
					doActionIBSheet(sheetObj, formObj, "CALLPRC");
	                break;
                case "btn_retrieve":                	
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
                    break;
                    
                case "btn_new":
                	formObj.reset();
        			formObj.skd_dir_cd.Index2 = 0;
        			sheetObj.RemoveAll();        			        	
                    break;
        			
                case "btn_ratio":                	
  				    ComOpenPopup("/hanjin/FNS_JOO_0101.do", 1000, 420,"getFNS_JOO_0101", "1,0,1,1,1,1,1,1");					  					  
                    break;        			
                                        
                case "btn_downexcel":
				   sheetObjects[0].Down2Excel(-1);	   
                   break;                    
                   
                case "btns_calendar_from": //달력버튼
                    var cal = new ComCalendar();
                    cal.select(formObj.pre_fr, 'yyyy-MM-dd');
                    break;

               case "btns_calendar_to": //달력버튼
                    var cal = new ComCalendar();
                    cal.select(formObj.pre_to, 'yyyy-MM-dd');
                    break;
                   					
				case "btn_rdr_save": //SAVE
					doActionIBSheet(sheetObj, formObj, IBSAVE);
					break;					

				case "btn_save": //SAVE
					doActionIBSheet(sheetObj, formObj, IBCREATE);
					break;					

				case "rmk_flg":
					if (formObj.rmk_flg.checked) {
	                	displayColumn("show");																		
					}else{
						displayColumn('hide');						
					}
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


    /**
     * IBCombo Object를 배열로 등록
     * param : combo_obj ==> 콤보오브젝트
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
     function setComboObject(combo_obj) {
        comboObjects[comboCnt++] = combo_obj;
     }    
    
     function sheet1_OnLoadFinish(sheetObj) {
         doActionIBSheet(sheetObjects[0],document.form, IBCLEAR);
         document.form.rlane_cd.focus();
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
        for(var k=0; k<comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }                
    	initControl();
    	
//        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC14);    	
    }

    /**
     * Combo 기본 설정
     * Combo의 항목을 설정한다.
     * @param comboObj
     * @param comboIndex Number
     */
     function initCombo(comboObj, comboNo ) {

         switch(comboObj.id) {
             case "skd_dir_cd":
                 with (comboObj) {
                     MultiSelect = false;
                     UseAutoComplete = true;
                     SetColAlign("left");
                     SetColWidth("60");
                     DropHeight = 200;
                     ValidChar(2,0);
                     MaxLength = 1;
                 }
                 break;
                 
     		case "srch_opt":
     			with (comboObj) {
     				MultiSelect = true;
     				UseAutoComplete = true;
     				SetColAlign("left");
     				SetColWidth("60");
     				DropHeight = 160;
     				ValidChar(2, 0);//영문대문자만 입력가능
     				MaxLength = 7;
     			}
     			var comboItems = "Target,T|Close,C|None,N";
     			UF_addComboItem(comboObj, comboItems.split("|"));
     			break;                 
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
        axon_event.addListenerForm  ('keypress', 'fnObjKeyPress', formObject );
        axon_event.addListenerForm  ('change'  , 'fnObjChange', formObject );
        axon_event.addListenerForm  ('keyup'   , "fnObjKeyUp",  formObject);    	
        axon_event.addListener      	('click',   'fnDocClick', "srch_rlane_cd");    	
        axon_event.addListenerFormat('deactivate',  'fnDeactivate',  formObject);
        axon_event.addListenerFormat('activate',  'fnActivate',  formObject);
        axon_event.addListenerFormat('change', 'obj_change',	formObject);		//- 변경될때               	
    }
    
        /**
         * <pre>
         *    form Element의 KeyPress Event 발생시 처리.
         *
         * </pre>
         * @return
         */
        function fnObjKeyPress(){
            var obj = event.srcElement;
            var formObj = document.form;
            var attr    = obj.getAttribute("dataformat");

            switch (attr){
                case  'ymd':
                      ComKeyOnlyNumber( obj );
                      break;

                case 'engup':
                      ComKeyOnlyAlphabet( 'upper' );
                      break;
                case 'uppernum':
                       ComKeyOnlyAlphabet( 'uppernum' );
                       break;

            }
        }    
    
        
     function fnObjKeyUp(){
         var formObj = document.form;
         var obj     = event.srcElement;

         switch (obj.name){
               case  'skd_dir_cd':
                     if( sheetObjects[0].RowCount > 0) {
                         sheetObjects[0].RemoveAll();
                     }
                     break;
               case  'rlane_cd':
                     formObj.skd_dir_cd.Code = "";
                     if( sheetObjects[0].RowCount > 0) {
                           sheetObjects[0].RemoveAll();
                     }
                     break;
         }
     }        
    
     
      /**
       * Period NAVI 처리 이벤트
       * @param void
       * @return void
       */
       function fnDocClick(){
           var obj = event.srcElement;
           var formObj = document.form;

           switch (obj.name){
              case "srch_rlane_cd"://Lane 팝업 조회
                    var lane_cd = formObj.rlane_cd.value;
                    var param = "?mode=svc&lane_cd="+lane_cd;
                    ComOpenPopup('/hanjin/COM_ENS_081.do' + param, 820, 460, 'getCOM_ENS_081_1', '1,0,1,1,1,1,1,1');
                    break;

           }
       }     
              
       function getCOM_ENS_081_1(aryPopupData){
           with(document.form){
                 rlane_cd.value  = aryPopupData[0][3];
           }
       }       
       
          /**
            * <pre>
            *     form element의 dataformat을 이용한 입력 Validate 처리,
            *     focus 잃었을때발생.
            * </pre>
            *
            * @return void
            */
           function fnDeactivate(){
                var obj = event.srcElement;
                var formObj = document.form;
                var attr   =  obj.getAttribute("dataformat");

                switch(obj.name){

                    case 'pre_fr':
                          ComAddSeparator(obj );
                          break;
                    case 'pre_to':
                          ComAddSeparator(obj );
                          break;
                }
           }

            /**
             * <pre>
             *     form element의 dataformat을 이용한 입력 Validate 처리,
             *     focus 얻었을때발생.
             * </pre>
             *
             * @return void
             */
            function fnActivate(){

                var obj = event.srcElement;
                var formObj = document.form;
                var attr   =  obj.getAttribute("dataformat");

                switch(attr){
                    case 'ymd':
                         ComClearSeparator(obj );
                         break;

                }
                ComSetFocus(obj);
            }       
       
        	/**
        	 * HTML Control의 onchange 이벤트에서 Validation을 체크한다. <br>
        	 **/
        	function obj_change()
        	{	     
        		//ComChkObjValid(event.srcElement);
        		var obj      = event.srcElement; 
        		var formObj  = document.form; 
        		var sheetObj = sheetObjects[0]; 
        	
        		switch(obj.name)
        		{      
        		case "pre_fr":
        			break;
        		case "pre_to":
        			break;
        		case "rlane_cd":
        			break;
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
        case "sheet1":      //sheet2 init
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
				
				
				var bkg_rule_add_ttl_20 = "IF(|jo_20ft_n1st_rto|=1, 0, IF((|bkg_hc_ld_20|+|bkg_hc_bsa_20|-|jo_20ft_sub_teu_qty|)*(|jo_20ft_n1st_rto|-1)<0, 0, IF(|jo_rnd_rule_lvl|=1, Round((|bkg_hc_ld_20|+|bkg_hc_bsa_20|-|jo_20ft_sub_teu_qty|)*(|jo_20ft_n1st_rto|-1),0), IF(|jo_rnd_rule_lvl|=2, Ceiling((|bkg_hc_ld_20|+|bkg_hc_bsa_20|-|jo_20ft_sub_teu_qty|)*(|jo_20ft_n1st_rto|-1)), IF(|jo_rnd_rule_lvl|=3, Int((|bkg_hc_ld_20|+|bkg_hc_bsa_20|-|jo_20ft_sub_teu_qty|)*(|jo_20ft_n1st_rto|-1)), (|bkg_hc_ld_20|+|bkg_hc_bsa_20|-|jo_20ft_sub_teu_qty|)*(|jo_20ft_n1st_rto|-1))))))";
				var bkg_rule_add_ttl_40 = "IF(|jo_40ft_n1st_rto|=1, 0, IF((|bkg_hc_ld_40|+|bkg_hc_bsa_40|-|jo_40ft_sub_teu_qty|)*(|jo_40ft_n1st_rto|-2)<0, 0, IF(|jo_rnd_rule_lvl|=1, Round((|bkg_hc_ld_40|+|bkg_hc_bsa_40|-|jo_40ft_sub_teu_qty|)*(|jo_40ft_n1st_rto|-2),0), IF(|jo_rnd_rule_lvl|=2, Ceiling((|bkg_hc_ld_40|+|bkg_hc_bsa_40|-|jo_40ft_sub_teu_qty|)*(|jo_40ft_n1st_rto|-2)), IF(|jo_rnd_rule_lvl|=3, Int((|bkg_hc_ld_40|+|bkg_hc_bsa_40|-|jo_40ft_sub_teu_qty|)*(|jo_40ft_n1st_rto|-2)), (|bkg_hc_ld_40|+|bkg_hc_bsa_40|-|jo_40ft_sub_teu_qty|)*(|jo_40ft_n1st_rto|-2))))))";
				 					 
				var bkg_rule_addu_ttl_45 = "IF(|jo_45ft_n1st_rto|=2, IF(|jo_45ft_n2nd_rto|=2, 0, IF((|bkg_hc_ld_45|+|bkg_hc_bsa_45|)<=|jo_45ft_sub_teu_qty|, IF((|bkg_hc_ld_45|+|bkg_hc_bsa_45|)*(|jo_45ft_n1st_rto|-2)<0, 0, ROUND((|bkg_hc_ld_45|+|bkg_hc_bsa_45|)*(|jo_45ft_n1st_rto|-2),0)) , IF(|jo_45ft_sub_teu_qty|*(|jo_45ft_n1st_rto|-2)<0,0,ROUND(|jo_45ft_sub_teu_qty|*(|jo_45ft_n1st_rto|-2),0)))), IF( (|bkg_hc_ld_45|+|bkg_hc_bsa_45|)<=|jo_45ft_sub_teu_qty|, IF((|bkg_hc_ld_45|+|bkg_hc_bsa_45|)*(|jo_45ft_n1st_rto|-2)<0,0,ROUND((|bkg_hc_ld_45|+|bkg_hc_bsa_45|)*(|jo_45ft_n1st_rto|-2),0)), IF(|jo_45ft_sub_teu_qty|*(|jo_45ft_n1st_rto|-2)<0,0,ROUND(|jo_45ft_sub_teu_qty|*(|jo_45ft_n1st_rto|-2),0))))";
				var bkg_rule_addo_ttl_45 = "IF(|jo_45ft_n1st_rto|=2, IF(|jo_45ft_n2nd_rto|=2, 0, IF((|bkg_hc_ld_45|+|bkg_hc_bsa_45|)<=|jo_45ft_sub_teu_qty|, 0, IF(((|bkg_hc_ld_45|+|bkg_hc_bsa_45|)-|jo_45ft_sub_teu_qty|)*(|jo_45ft_n2nd_rto|-2)<0,0,ROUND(((|bkg_hc_ld_45|+|bkg_hc_bsa_45|)-|jo_45ft_sub_teu_qty|)*(|jo_45ft_n2nd_rto|-2),0) ))), IF((|bkg_hc_ld_45|+|bkg_hc_bsa_45|)<=|jo_45ft_sub_teu_qty|, 0, IF(((|bkg_hc_ld_45|+|bkg_hc_bsa_45|)-|jo_45ft_sub_teu_qty|)*(|jo_45ft_n2nd_rto|-2)<0,0,ROUND(((|bkg_hc_ld_45|+|bkg_hc_bsa_45|)-|jo_45ft_sub_teu_qty|)*(|jo_45ft_n2nd_rto|-2),0))))";
				 
				var bkg_rule_grand_ttl_slot = "|bkg_full_20|+|bkg_mt_20|+((|bkg_full_40|+|bkg_mt_40|)*2)+|bkg_hc_ld_20|+|bkg_hc_bsa_20|+((|bkg_hc_ld_40|+|bkg_hc_bsa_40|)*2)+((|bkg_hc_ld_45|+|bkg_hc_bsa_45|)*2)+(" + bkg_rule_add_ttl_20 + ")+(" + bkg_rule_add_ttl_40 + ")+(" + bkg_rule_addu_ttl_45 + ")+(" + bkg_rule_addo_ttl_45 +")+|bkg_ak_void|";
				
				var bkg_rule_add_hc_20 = "IF(|jo_20ft_n1st_rto|=1, 0, IF(|bkg_ttl_hc_20|-|jo_20ft_sub_teu_qty|<0, 0, |bkg_ttl_hc_20|-|jo_20ft_sub_teu_qty|))";
				var bkg_rule_add_hc_40 = "IF(|jo_40ft_n1st_rto|=2, 0, IF(|bkg_ttl_hc_40|-|jo_40ft_sub_teu_qty|<0, 0, |bkg_ttl_hc_40|-|jo_40ft_sub_teu_qty|))";
				var bkg_rule_addu_hc_45 = "IF(|jo_45ft_n1st_rto|=2, IF(|jo_45ft_n2nd_rto|=2, 0, IF(|bkg_ttl_hc_45|<=|jo_45ft_sub_teu_qty|, |bkg_ttl_hc_45|, |jo_45ft_sub_teu_qty|)), IF(|bkg_ttl_hc_45|<=|jo_45ft_sub_teu_qty|, |bkg_ttl_hc_45|, |jo_45ft_sub_teu_qty|))";
				var bkg_rule_addo_hc_45 = "IF(|jo_45ft_n1st_rto|=2, IF(|jo_45ft_n2nd_rto|=2, 0, IF(|bkg_ttl_hc_45|<=|jo_45ft_sub_teu_qty|, 0, |bkg_ttl_hc_45|-|jo_45ft_sub_teu_qty|)), IF(|bkg_ttl_hc_45|<=|jo_45ft_sub_teu_qty|, 0, |bkg_ttl_hc_45|-|jo_45ft_sub_teu_qty|))";
				 
				var bkg_rule_over_slot_c = "IF((|bkg_grand_ttl_slot|-|all_teu|) < 0, 0, |bkg_grand_ttl_slot|-|all_teu|)";
				var bkg_rule_over_wgt_c = "IF((|bkg_grand_ttl_wgt|-|all_wgt|) < 0, 0, |bkg_grand_ttl_wgt|-|all_wgt|)";													
				var bkg_rule_fin =  "IF((("+bkg_rule_over_slot_c+") >= ("+  bkg_rule_over_wgt_c + "/ |teu_qty|)), "+bkg_rule_over_slot_c+","+  bkg_rule_over_wgt_c + "/ |teu_qty|)" ;

					
				// 높이 설정
				style.height = 440;
				
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet =  msHeaderOnly;
				
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;				
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 3, 100);
								
				var HeadTitle2 =
					"STS|Target |Close|Pass|Trade|RE_DIVR_CD|Carrier\nCode|Revenue\nLane" +
					"|sub chk|cal" +				
			        "|Lane|Yard|No.|VVD|VVD|VVD" +	
			        "|ROB Port|ROB Port|ROB Port|Fin\nDir|RDR|ETD|Port\nStatus" +
			        "|Remark\nType|Remarks|Allocation|Allocation|BSA" +
					"|Total\nTEU|Total\nE.Weight|Over Used|Over Used" +										
					"|Final Used" +													        
					"|20'|20'|20'|40'|40'|40'|40'|20'HC|20'HC|20'HC|20'HC|40'HC|40'HC|40'HC|40'HC|40'HC|45'|45'|45'|45'|45'|45'|Additional|Additional|Additional|Additional" +
					"|AK|VOID|DG|DG|RF|RF|RF ROB|RF ROB" +										
					"|EMPTY|EMPTY" +
					"|TON/\nTEU|20'HC|20'HC|40'HC|40'HC|45'|45'|45'|ROUND RULE|CLPT SEQ"+
					"|REV_YRMON|REV_YRMON_SEQ"+
					"|OUS\nAmount|R/F\nAmount|acct_yrmon|stl_tgt_flg2" + 
					"|Total TEU\n(BKG)|Total\nE.Weight\n(BKG)|Over Used\n(BKG)|Over Used\n(BKG)|RF\n(BKG)|RF\n(BKG)|RF ROB\n(BKG)|RF ROB\n(BKG)|DIFF|DIFF"+
					"||||||||||||||||||||||||||||";
					
					var HeadTitle3 =
					"STS|Target |Close|Pass|Trade|RE_DIVR_CD|Carrier\nCode|Revenue\nLane" +
					"|sub chk|cal" +													
				    "|Lane|Yard|No.|VSL|VOY|DIR" +		
			        "|Port|Tml|Ind|Fin\nDir|RDR|ETD|Port\nStatus" +
			        "|Remark\nType|Remarks|TEU|WT|BSA" +
					"|Total\nTEU|Total\nE.Weight|TEU|WT" +										
					"|OUS" +			        
					"|Full|Empty|TTL|Full|Empty|TTL|TTL(TEU)|Full|Empty|TTL|ADD|Full|Empty|TTL|TTL(TEU)|ADD|Full|Empty|TTL|TTL(TEU)|ADD(U)|ADD(O)|20'HC|40'HC|45'(U)|45'(O)" +
					"|AK|VOID|20'|40'|20'|40'|20'|40'" +
					"|TEU|WEIGHT" +
					"|TON/\nTEU|Sub-Allo|Ratio|Sub-Allo|Ratio|Sub-Allo|Ratio 1|Ratio 2|ROUND RULE|CLPT SEQ"+
					"|REV_YRMON|REV_YRMON_SEQ"+
					"|OUS\nAmount|R/F\nAmount|acct_yrmon|stl_tgt_flg2" + 
					"|Total TEU\n(BKG)|Total\nE.Weight\n(BKG)|TEU|WGT|20'|40'|20'|40'|20'|40'"+
					"||||||||||||||||||||||||||||";
									
				var headCount = ComCountHeadTitle(HeadTitle2);
				
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, false, true, true, false,false);
								
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]				
				InitHeadRow(0, HeadTitle2, true);
				InitHeadRow(1, HeadTitle3, true);
				
				// 데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,       COLMERGE,   SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++,  dtStatus       ,30, 		daCenter, true, "ibflag"  );
				InitDataProperty(0, cnt++,  dtCheckBox , 60, 		daCenter,  true, "stl_tgt_flg");		
				InitDataProperty(0, cnt++,  dtCheckBox , 60, 		daCenter,  true, "stl_clz_flg");
				InitDataProperty(0, cnt++,  dtData          ,35, 	daCenter,  true, "pass"         	   ,false, "", dfNone       ,0,false,true);
				InitDataProperty(0, cnt++ , dtData			  ,40, 	daCenter,		true,  "trd_cd",		false, "", dfNone, 0,  false, false);
				InitDataProperty(0, cnt++ , dtHidden		  ,80, 	daCenter,		true,  "re_divr_cd",		false, "", dfNone, 0,  false, false);				
				InitDataProperty(0, cnt++,  dtHidden       ,60, 	daCenter,  true, "crr_cd"         	   ,false, "", dfNone       ,0,false,true); 
				InitDataProperty(0, cnt++,  dtData          ,60, 	daCenter,  true, "rlane_cd"        		 ,false, "", dfNone       ,0,false,true); 
				InitDataProperty(0, cnt++ , dtHidden,   	  30,     daCenter,    true,    "sub_chk",        false,    "",    dfNumber,	 0, false, false);
				InitDataProperty(0, cnt++ , dtHidden,      30,     daRight,      true,   "all_wgt_c",      false,    "IF(|sub_chk|=2, |all_teu|*|all_wgt|, |all_wgt|)", dfNumber, 0, true, false);				
				InitDataProperty(0, cnt++ , dtHidden,      30,     daCenter,    true,    "lane",        		false,    "",    dfNone, 0, false, false);
				InitDataProperty(0, cnt++ , dtHidden,   	  30,     daCenter,    true,    "yd_cd",  	     	false,    "",    dfNone, 0, false, false);								
				InitDataProperty(0, cnt++ , dtHidden,	  40,	   daCenter,	 true,	"seq_no",       	false,    "",    dfNumber, 0, false, false);				
				InitDataProperty(0, cnt++ , dtData,      	  40,     daCenter,    true,    "vsl_cd",        	false,    "",    dfNone, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,      	  40,     daCenter,    true,    "skd_voy_no", 	false,    "",    dfNone, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,      	  40,     daCenter,    true,    "skd_dir_cd",   	false,    "",    dfNone, 0, false, false);				
				InitDataProperty(0, cnt++ , dtData,      	  50,     daCenter,    true,    "vps_port_cd",  false,    "",    dfNone, 0, false, false);					
				InitDataProperty(0, cnt++ , dtData,      	  30,     daCenter,    true,    "tml_cd",  	     	false,    "",    dfNone, 0, false, false);				
				InitDataProperty(0, cnt++ , dtData,      	  25,     daCenter,    true,    "clpt_ind_seq",  	false,    "",    dfNone, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,   	      30,     daCenter,    true,    "rev_dir_cd",	   	false,    "",    dfNone, 0, false, false);				
				InitDataProperty(0, cnt++ , dtCombo,   	  40,     daCenter,    true,    "rdr_flg",  		   	false,    "",    dfNone, 0, true, true);				
				InitDataProperty(0, cnt++ , dtData,      	  100,    daCenter,    true,    "vps_etd_dt",    false,    "",    dfUserFormat2, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,      	  70,      daCenter,    true,    "port_skd_sts",    false,    "",    dfNone, 0, false, false);
				
//--------------------------------------------------------				
				InitDataProperty(0, cnt++ , dtCombo,   	  100,   daLeft,    	true,    "rmk_flg",  		   	false,    "",    dfNone, 0, true, true);
				InitDataProperty(0, cnt++ , dtData,      	  200,   daLeft,     	true,    "rmk", 		       false,    "",    	dfNone, 0, true, true);				
				InitDataProperty(0, cnt++ , dtData,         50,     daRight,     false,    "all_teu",          false,    "",    	dfNumber, 0, true, false);
				InitDataProperty(0, cnt++ , dtData,         50,     daRight,     false,    "all_wgt",          false,    "", 		dfNumber, 0, true, false);
				InitDataProperty(0, cnt++ , dtData,         40,     daCenter,     true,    "bsa_flg",          false,    "", 		dfNone, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,         80,     daRight,     true,    "grand_ttl_slot", false,    rule_grand_ttl_slot, dfFloat, 2, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtData,         80,     daRight,     true,    "grand_ttl_wgt",  false,    "",    dfFloat, 2, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,    "over_slot_c",    false,    rule_over_slot_c,    dfFloat, 2, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,    "over_wgt_c",     false,    rule_over_wgt_c,     dfFloat, 2, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtData,         70,     daRight,     true,    "fin_used",       	 false,    "",    dfFloat, 2, false, false,0,false,false);								
//--------------------------------------------------------				
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "full_20",        false,    "",    dfNumber, 0, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "mt_20",          false,    "",    dfNumber, 0, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "ttl_20",         false,    "|full_20|+|mt_20|",    dfNumber, 0, false, false,0,false,false); 
				
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "full_40",        false,    "",    dfNumber, 0, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "mt_40",          false,    "",    dfNumber, 0, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "ttl_40",         false,    "|full_40|+|mt_40|",    dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "ttl_20_40",      false,    "|ttl_40|*2",    dfNumber, 0, false, false,0,false,false); 
				
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     true,     "hc_ld_20",       false,    "",    dfNumber, 0, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     true,     "hc_bsa_20",      false,    "",    dfNumber, 0, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "ttl_hc_20",      false,    "|hc_ld_20|+|hc_bsa_20|",    dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "add_hc_20",      false,    rule_add_hc_20, dfNumber, 0, false, false,0,false,false); 
				
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     true,     "hc_ld_40",       false,    "",    dfNumber, 0, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     true,     "hc_bsa_40",      false,    "",    dfNumber, 0, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "ttl_hc_40",      false,    "|hc_ld_40|+|hc_bsa_40|",    dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "ttl_hc_20_40",   false,    "(|hc_ld_40|+|hc_bsa_40|)*2",    dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "add_hc_40",      false,    rule_add_hc_40, dfNumber, 0, false, false,0,false,false); 
				
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     true,     "hc_ld_45",       false,    "",    dfNumber, 0, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     true,     "hc_bsa_45",      false,    "",    dfNumber, 0, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "ttl_hc_45",      false,    "|hc_ld_45|+|hc_bsa_45|",    dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "ttl_hc_20_45",   false,    "|ttl_hc_45|*2",    dfNumber, 0, false, false,0,false,false); 
				 
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "addu_hc_45",     false, rule_addu_hc_45, dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "addo_hc_45",     false, rule_addo_hc_45, dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "add_ttl_20",     false, rule_add_ttl_20, dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "add_ttl_40",     false, rule_add_ttl_40, dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "addu_ttl_45",    false, rule_addu_ttl_45, dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtData,         45,     daRight,     false,    "addo_ttl_45",    false, rule_addo_ttl_45, dfNumber, 0, false, false,0,false,false); 
				
				InitDataProperty(0, cnt++ , dtData,         50,     daRight,     true,    "ak_unit",        false,    "",    dfNumber, 0, false, false,0,false,false);	// AK
				InitDataProperty(0, cnt++ , dtData,         50,     daRight,     true,    "ak_void",        false,    "",    dfNumber, 0, false, false,0,false,false);	// VOID
				
				InitDataProperty(0, cnt++ , dtData,         40,     daRight,     true,    "dg_20",        false,    "",    dfNumber, 0, false, false,0,false,false);		// DG
				InitDataProperty(0, cnt++ , dtData,         40,     daRight,     true,    "dg_40",        false,    "",    dfNumber, 0, false, false);
				
				InitDataProperty(0, cnt++ , dtData,         40,     daRight,     true,    "rf_20_qty",      false,    "",    dfNumber, 0, false, false,0,false,false);	// RF
				InitDataProperty(0, cnt++ , dtData,         40,     daRight,     true,    "rf_40_qty",      false,    "",    dfNumber, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,         40,     daRight,     true,    "rf_rdr_qty",      false,    "",    dfNumber, 0, false, false,0,false,false);	// RF 20FT ROB			
				InitDataProperty(0, cnt++ , dtData,         40,     daRight,     true,    "rf_rdr_40_qty",      false,    "",    dfNumber, 0, false, false,0,false,false);	// RF 40FT ROB			
				
				InitDataProperty(0, cnt++ , dtHidden,      50,     daRight,     true,    "mt_teu",         false,    "",    dfNumber, 0, false, false);
				InitDataProperty(0, cnt++ , dtHidden,      50,     daRight,     true,     "mt_wt",           false,    "",    dfNumber, 0, false, false);
				
				 //2012.06.19추가								
				InitDataProperty(0, cnt++ , dtHidden,   50, daRight,   true,  "teu_qty",         			false, "", dfFloat, 2, false, false);								 				
				InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	true,  "jo_20ft_sub_teu_qty",  	false, "", dfInteger, 2,  true, true, 9);
				InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	true,  "jo_20ft_n1st_rto",  		false, "", dfFloat, 2,  true, true, 5);
				InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	true,  "jo_40ft_sub_teu_qty",  	false, "", dfInteger, 2,  true, true, 9);
				InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	true,  "jo_40ft_n1st_rto",     	false, "", dfFloat, 2,  true, true, 5);
				InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	true,  "jo_45ft_sub_teu_qty", 	false, "", dfInteger, 2,  true, true, 9);
				InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	true,  "jo_45ft_n1st_rto", 		false, "", dfFloat, 2,  true, true, 5);
				InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	true,  "jo_45ft_n2nd_rto", 		false, "", dfFloat, 2,  true, true, 5);
				InitDataProperty(0, cnt++ , dtHidden,	80, daCenter,	true,  "jo_rnd_rule_lvl", 			false, "", dfNone, 2,  true, true);
				InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	true,  "clpt_seq", 					false, "", dfNone, 2,  true, true);						 
				 // 2015년 jo신규 개발건
				InitDataProperty(0, cnt++ , dtHidden,	60, daRight,	true,  "rev_yrmon", 		false, "", dfNone, 0,  false, false);
				InitDataProperty(0, cnt++ , dtHidden,	60, daRight,	true,  "rev_yrmon_seq",		false, "", dfNone, 0,  false, false);

				InitDataProperty(0, cnt++ , dtHidden,	50, daRight,	true,  "ovr_usd_slt_amt",		false, "", dfNone, 0,  false, false);
				InitDataProperty(0, cnt++ , dtHidden,	50, daRight,	true,  "rf_20ft_cntr_stl_amt",		false, "", dfNone, 0,  false, false);
				InitDataProperty(0, cnt++ , dtHidden,	50, daRight,	true,  "acct_yrmon",		false, "", dfNone, 0,  false, false);				 
				InitDataProperty(0, cnt++ , dtHidden,	50, daRight,	true,  "stl_tgt_flg2",		false, "", dfNone, 0,  false, false);

				// 2016.04.19 추가사항 show
				InitDataProperty(0, cnt++ , dtData,     80, daRight,    true,  "bkg_grand_ttl_slot",false, bkg_rule_grand_ttl_slot,    dfFloat,  2, false, false);
				InitDataProperty(0, cnt++ , dtData,     80, daRight,    true,  "bkg_grand_ttl_wgt", false, "",    dfFloat,  2, false, false);
				InitDataProperty(0, cnt++ , dtData,     60, daRight,    true,  "bkg_over_slot_c",   false, bkg_rule_over_slot_c,    dfFloat,  2, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtData,     60, daRight,    true,  "bkg_over_wgt_c",    false, bkg_rule_over_wgt_c,    dfFloat,  2, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtData,     40, daRight,    true,  "bkg_rf_20_qty",     false, "",    dfNumber, 0, false, false,0,false,false);	// RF
				InitDataProperty(0, cnt++ , dtData,     40, daRight,    true,  "bkg_rf_40_qty",     false, "",    dfNumber, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,     40, daRight,    true,  "bkg_rf_rdr_qty",    false, "",    dfNumber, 0, false, false,0,false,false);	// RF 20FT ROB			
				InitDataProperty(0, cnt++ , dtData,     40, daRight,    true,  "bkg_rf_rdr_40_qty", false, "",    dfNumber, 0, false, false,0,false,false);	// RF 40FT ROB			
				InitDataProperty(0, cnt++ , dtData,     50, daRight,    true,  "bkg_20_df",         false, "(|rf_20_qty|-|bkg_rf_20_qty|)",    dfNumber, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,     50, daRight,    true,  "bkg_40_df",         false, "(|rf_40_qty|-|bkg_rf_40_qty|)",    dfNumber, 0, false, false);
				
				// 2016.04.19 추가사항 hidden
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     false,    "bkg_full_20",        false,    "",    dfNumber, 0, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     false,    "bkg_mt_20",          false,    "",    dfNumber, 0, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     false,    "bkg_ttl_20",         false,    "|bkg_full_20|+|bkg_mt_20|",    dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     false,    "bkg_full_40",        false,    "",    dfNumber, 0, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     false,    "bkg_mt_40",          false,    "",    dfNumber, 0, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     false,    "bkg_ttl_40",         false,    "|bkg_full_40|+|bkg_mt_40|",    dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     false,    "bkg_ttl_20_40",      false,    "|bkg_ttl_40|*2",    dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     true,     "bkg_hc_ld_20",       false,    "",    dfNumber, 0, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     true,     "bkg_hc_bsa_20",      false,    "",    dfNumber, 0, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     false,    "bkg_ttl_hc_20",      false,    "|bkg_hc_ld_20|+|bkg_hc_bsa_20|",    dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     false,    "bkg_add_hc_20",      false,    bkg_rule_add_hc_20, dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     true,     "bkg_hc_ld_40",       false,    "",    dfNumber, 0, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     true,     "bkg_hc_bsa_40",      false,    "",    dfNumber, 0, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     false,    "bkg_ttl_hc_40",      false,    "|bkg_hc_ld_40|+|bkg_hc_bsa_40|",    dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     false,    "bkg_ttl_hc_20_40",   false,    "(|bkg_hc_ld_40|+|bkg_hc_bsa_40|)*2",    dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     false,    "bkg_add_hc_40",      false,    bkg_rule_add_hc_40, dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     true,     "bkg_hc_ld_45",       false,    "",    dfNumber, 0, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     true,     "bkg_hc_bsa_45",      false,    "",    dfNumber, 0, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     false,    "bkg_ttl_hc_45",      false,    "|bkg_hc_ld_45|+|bkg_hc_bsa_45|",    dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     false,    "bkg_ttl_hc_20_45",   false,    "|bkg_ttl_hc_45|*2",    dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     false,    "bkg_addu_hc_45",     false, bkg_rule_addu_hc_45, dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     false,    "bkg_addo_hc_45",     false, bkg_rule_addo_hc_45, dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     false,    "bkg_add_ttl_20",     false, bkg_rule_add_ttl_20, dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     false,    "bkg_add_ttl_40",     false, bkg_rule_add_ttl_40, dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     false,    "bkg_addu_ttl_45",    false, bkg_rule_addu_ttl_45, dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtHidden,         45,     daRight,     false,    "bkg_addo_ttl_45",    false, bkg_rule_addo_ttl_45, dfNumber, 0, false, false,0,false,false); 
				InitDataProperty(0, cnt++ , dtHidden,         50,     daRight,     true,    "bkg_ak_unit",        false,    "",    dfNumber, 0, false, false,0,false,false);	// AK
				InitDataProperty(0, cnt++ , dtHidden,         50,     daRight,     true,    "bkg_ak_void",        false,    "",    dfNumber, 0, false, false,0,false,false);	// VOID
				

				 
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
				 ColHidden("rmk_flg") = true;
				 ColHidden("rmk") = true;
				 				 				 
				InitUserFormat2(0, "vps_etd_dt",  "####-##-## ##:##", "-|:" );
				FrozenCols = 23;				
				
				ShowButtonImage = 1;
				CountPosition = 2;				 
				
				InitDataCombo(0, "rdr_flg",  " |R", " |R","");
				InitDataCombo(0, "rmk_flg", " |Price TBD|Contract Details TBD|Operational Issues|Mere Delay", " |1|2|3|4","");
				
	        }
            break;
        }        	
    }
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
	        case "CALLPRC": // JOO_SLT_PRC 프로시저 실행 테스트용
	            if (!validateForm(sheetObj,formObj,sAction)) {
	                return;
	            }
				formObj.f_cmd.value = COMMAND21;
				var sXml = sheetObj.GetSearchXml("FNS_JOO_0105GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml, false);
				
	    		break;
	    		
            case IBSEARCH:      //조회
                if (!validateForm(sheetObj,formObj,sAction)) {
                    return;
                }
                                
                if(comboObjects[1].CheckIndex(0)){
                	formObj.opt_tgt.value = "T";
                }else{
                	formObj.opt_tgt.value = "";
                }
                	
                if(comboObjects[1].CheckIndex(1)){
                	formObj.opt_clz.value = "C";
                }else{
                	formObj.opt_clz.value = "";
                }
                
                if(comboObjects[1].CheckIndex(2)){
                	
                	comboObjects[1].CheckIndex(0) = false;
                	comboObjects[1].CheckIndex(1) = false;
                	
                	formObj.opt_tgt.value = "N";                	
                	formObj.opt_clz.value = "N";
                }
                                                
				formObj.f_cmd.value = SEARCH;	               	               				
				var sXml = sheetObj.GetSearchXml("FNS_JOO_0105GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml, false); //Append X			
				break;
							                                
            case IBCLEAR:      
                var param = "";
                var sXml = "";

                var code   =  "CD00593";
                formObj.f_cmd.value = SEARCH01;
                param = FormQueryString(formObj)+"&super_cd1="+code;
                sXml  = sheetObj.GetSearchXml("FNS_JOO_0057GS.do", param);

                var comboString = ComXml2ComboString(sXml, "code", "name");
                var comboCodeList = comboString[0].split('|');
                var comboTextList = comboString[1].split('|');
                formObj.skd_dir_cd.RemoveAll();
                formObj.skd_dir_cd.InsertItem(-1, "", "");
                for (var w=0; w<comboCodeList.length; w++) {
                    formObj.skd_dir_cd.InsertItem(-1, comboTextList[w], comboCodeList[w]);
                }
                formObj.skd_dir_cd.Index2 = 0;
                
                break;            
    			
    		case IBSAVE: //저장
    			formObj.f_cmd.value = MULTI;    			    			
           		sheetObj.DoSave("FNS_JOO_0103GS.do","f_cmd=7&"+formObj.rlane_cd.value+"&"+ComGetSaveString(sheetObj));
            	break;           		

    		case IBCREATE: //저장    			
    			var SaveStr = ComGetSaveString(sheetObj);
    			
    			if (SaveStr == ""){
    				ComShowCodeMessage("JOO00036");
    				return false;
    			}
    						
    			if (!ComShowCodeConfirm("JOO00046")){
    				return false;
    			}    			
    			
    			formObj.f_cmd.value = MULTI01;
    			sheetObj.WaitImageVisible=false;
    			ComOpenWait(true);
    			var sXml = sheetObj.GetSaveXml("FNS_JOO_0105GS.do", SaveStr + "&" + FormQueryString(formObj));    			
    			ComOpenWait(false);
    			sheetObj.LoadSearchXml(sXml);    		    			
    			doActionIBSheet(sheetObj, formObj, IBSEARCH);
    			
            	break;
            	
//            // Remark Code 자동 조회
//            case IBSEARCH_ASYNC14:
////            	var sXml = sheetObj.GetSearchXml("ESM_BKG_0000GS.do", "f_cmd=" + SEARCHLIST01 + "&cm_code=CD03477");
//            	var sXml = sheetObj.GetSearchXml("ESM_BKG_0000GS.do", "f_cmd=" + SEARCHLIST01 + "&cm_code=CD02129");            	
//            	
//            	alert(sXml);
//        		if (sXml.length > 0) {
//        			var arrCombo = ComXml2ComboString(sXml, "val", "name");
//        			sheetObjects[0].InitDataCombo(0, "rmk_flg", arrCombo[1], arrCombo[0]);
//        		}
//        		
//            	break;            	
        }
    }
    
       
    /**
     * Sheet1의 OnSearchEnd 이벤트 처리
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var teu_qty = 0;
    	var over_slot_c = 0;
    	var over_wgt_c = 0;
    	var stl_tgt_flg = 0;
    	var stl_clz_flg = 0;
    	var acct_yrmon = '';
    	    	
    	if(sheetObj.RowCount > 0){    		           		
    		for(var i=2; i<sheetObj.RowCount+2; i++){    			    		
	    		teu_qty = sheetObj.CellValue(i,"teu_qty");
	    		over_slot_c = sheetObj.CellValue(i,"over_slot_c");
	    		over_wgt_c = sheetObj.CellValue(i,"over_wgt_c");
	    		acct_yrmon = sheetObj.CellValue(i,"acct_yrmon");
	    		
// ROB에서는 Weight가 의미가 없으므로 OVER TEU가 FIN OUS가 된다. 	    		    			    		
	    		if(over_slot_c > over_wgt_c/teu_qty){
	    			sheetObj.CellValue2(i, "fin_used") =  over_slot_c;
	    		}else{
	    			sheetObj.CellValue2(i, "fin_used") =  over_wgt_c/teu_qty;
	    		}    		    			    			    	
	    			    		
	    		if(sheetObj.CellValue(i, "fin_used") < 0){
	    			sheetObj.CellValue2(i, "fin_used") = 0;
	    		}	    		
// 추가	    		
	    		stl_tgt_flg = sheetObj.CellValue(i,  "stl_tgt_flg");
	    		stl_clz_flg = sheetObj.CellValue(i,  "stl_clz_flg");	    		
	    		

//    			if(stl_tgt_flg == "1"){
//    				sheetObj.CellEditable(i, "stl_tgt_flg") = false;
//    			}
    			
    			if(acct_yrmon != "999912"){
					sheetObj.CellEditable(i, "stl_tgt_flg") = false;
				}	    		
	    			    		
    			sheetObj.CellValue2(i, "ibflag") =  '';

    			sheetObj.CellBackColor(i, "dg_20") = sheetObj.RgbColor(255, 153, 153);    			
    			sheetObj.CellBackColor(i, "dg_40") = sheetObj.RgbColor(255, 153, 153);    			
    			sheetObj.CellBackColor(i, "rf_20_qty") = sheetObj.RgbColor(255, 255, 153);
    			sheetObj.CellBackColor(i, "rf_40_qty") = sheetObj.RgbColor(255, 255, 153);
    			sheetObj.CellBackColor(i, "rf_rdr_qty") = sheetObj.RgbColor(153, 255, 153);
    			sheetObj.CellBackColor(i, "rf_rdr_40_qty") = sheetObj.RgbColor(153, 255, 153);
    			sheetObj.CellBackColor(i, "grand_ttl_slot") = sheetObj.RgbColor(153, 153, 255);
    			sheetObj.CellBackColor(i, "over_slot_c") = sheetObj.RgbColor(204, 153, 255);
    			sheetObj.CellBackColor(i, "fin_used") = sheetObj.RgbColor(255, 204, 153);		
    		}	    		
    	}    	    	
    }
    
    /**
     * Sub-Allocation and Ratio 닫힌 후 실행
     */
	 function getFNS_JOO_0101() {
	 }    
	 	 	 
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         switch(sAction){
                 case IBSEARCH:
                     if(!ComChkValid(formObj)){
                         return false;
                     }
                     break;                     
         }
         return true;
     }
               
 	/*
 	* Sheet1 OnChange 함수
 	* all_teu, all_wgt 변경하면
 	* over_slot_c, over_wgt_c 가 변경하여
 	* fin_used 가 변경
 	*/     
     function sheet1_OnChange(sheetObj, Row,Col,Value){    	     	 
    	 var sName = sheetObj.ColSaveName(Col); 
    	     	    	 
    	 if(sName == "all_teu" || sName == "all_wgt"){
        	 setFinalOus(Row);    		 
    	 }    	     	     	 
     }     
     
     /**
      * setFinalOus
      */
     function setFinalOus(i) {
    	 var sheetObj = sheetObjects[0];    	     	 
     	var teu_qty = 0;
     	var over_slot_c = 0;
     	var over_wgt_c = 0;
     	    	    			    		
		teu_qty = sheetObj.CellValue(i,"teu_qty");
		over_slot_c = sheetObj.CellValue(i,"over_slot_c");
		over_wgt_c = sheetObj.CellValue(i,"over_wgt_c");
		    		
		// ROB에서는 Weight가 의미가 없으므로 OVER TEU가 FIN OUS가 된다. 	    		  		
//		if(over_slot_c > over_wgt_c/teu_qty){
			sheetObj.CellValue2(i, "fin_used") =  over_slot_c;
//		}else{
//			sheetObj.CellValue2(i, "fin_used") =  over_wgt_c/teu_qty;
//		}  			
     }     
     
 	/*
 	* 그리드 OnBefore 이벤트처리
 	*/  
 	function sheet1_OnBeforeCheck(sheetObj,Row,Col){
 	}     
     
    /**
     * Remark Columen 표시
     */          
    function displayColumn(sw){     
        var sheetObj = sheetObjects[0];
        var colName = "";
  		 for(var i=0; i<=sheetObj.LastCol ; i++){
  			    colName = sheetObj.ColSaveName(i);
  			    if(		colName == "rmk_flg" ||       
  			    		colName == "rmk"                     			    		   			    			
  			    		){
			   	   	    	 	if(sw=="hide"){
			   	   	    	 		sheetObj.ColHidden(i) = true;
			   	   	    	 	}else{
			   	   	    	 		sheetObj.ColHidden(i) = false;			   	   	    	 		
 	   	   	    	 	}    		    			    	
  			    }
  		 }
    } 	
/* 개발자 작업  끝 */