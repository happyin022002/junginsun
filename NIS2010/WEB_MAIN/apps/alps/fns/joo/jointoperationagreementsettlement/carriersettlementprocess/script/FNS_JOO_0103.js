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
                case "btn_retrieve":                	
					if (formObj.etd_flg.checked) {
						doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);						
					}else{	
						doActionIBSheet(sheetObj, formObj, IBSEARCH);
					}
                    break;

                    
                case "btn_retrieve2":                	
					if (formObj.etd_flg.checked) {
						doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);						
					}else{	
						doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC10);
					}
                    break;                    
                    
                case "btn_retrieve3":                	
					if (formObj.etd_flg.checked) {
						doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);						
					}else{	
						doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC11);
					}
                    break;   
                    
                case "btn_retrieve4":                	
					if (formObj.etd_flg.checked) {
						doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);						
					}else{	
						doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC12);
					}
                    break;   

                case "btn_retrieve5":                	
					if (formObj.etd_flg.checked) {
						doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);						
					}else{	
						doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC13);
					}
                    break;
                    
                case "btn_new":
                	formObj.reset();
        			formObj.skd_dir_cd.Index2 = 0;
        			sheetObj.RemoveAll();        			        	
        			displayColumn("show");
                    break;

        		case "btn_downExcel":
        			doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
        			break;                    
        			
                case "btn_ratio":                	
  				    ComOpenPopup("/hanjin/FNS_JOO_0101.do", 1000, 420,"getFNS_JOO_0101", "1,0,1,1,1,1,1,1");					  					  
                    break;        			
                                        
                case "btn_downexcel":
         		   var columnSkipList = "sub_chk|all_wgt_c|all_teu|all_wgt|lane" +
         		   								  "|ttl_20|ttl_40|ttl_20_40|ttl_hc_20|add_hc_20|ttl_hc_40|ttl_hc_20_40" +
         		   								  "|add_hc_40|ttl_hc_45|ttl_hc_20_45|addu_hc_45|addo_hc_45|add_ttl_20|add_ttl_40|addu_ttl_45|addo_ttl_45" +
         		   							      "|mt_teu|mt_wt|teu_qty"+
         		   							      "|jo_20ft_sub_teu_qty|jo_20ft_n1st_rto|jo_40ft_sub_teu_qty|jo_40ft_n1st_rto"+
         		   							      "|jo_45ft_sub_teu_qty|jo_45ft_n1st_rto|jo_45ft_n2nd_rto|jo_rnd_rule_lvl"
         		   								  ;                					   				  
				   sheetObjects[0].Down2Excel(-1,false,false,true,"","",false,false,"ROB",false,columnSkipList);
				   
                   break;                    
                   
                case "btns_calendar_from": //달력버튼
                    var cal = new ComCalendar();
                    cal.select(formObj.pre_fr, 'yyyy-MM-dd');
                    break;

               case "btns_calendar_to": //달력버튼
                    var cal = new ComCalendar();
                    cal.select(formObj.pre_to, 'yyyy-MM-dd');
                    break;

               case "btn_show":
            	   displayGrid('show');
                   break;

               case "btn_hide":
            	   displayGrid('hide');
                   break;
                   
				case "etd_flg":
					if (formObj.etd_flg.checked) {
						displayColumn('hide');												
					}else{
	                	displayColumn("show");						
					}
					break;
					
				case "alloc_flg":
					if (formObj.alloc_flg.checked) {
						sheetObj.ColHidden("all_teu") = false;
						sheetObj.ColHidden("all_wgt") = false;																																										
					}else{
						sheetObj.ColHidden("all_teu") = true;
						sheetObj.ColHidden("all_wgt") = true						
					}
					break;
					
				case "btn_save": //SAVE
					doActionIBSheet(sheetObj, formObj, IBSAVE);
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
    	
    	sheetObjects[0].ColHidden("all_teu") = true;
    	sheetObjects[0].ColHidden("all_wgt") = true			    	
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

               case "btn_pre_from_back":
                   if (formObj.pre_fr.value != "" ){
                       formObj.pre_fr.value = ComGetDateAdd(formObj.pre_fr.value,"D",-1);
                   }
                   fnFormClear();
                   break;

              case "btn_pre_from_next":
                   if (formObj.pre_fr.value != "" ){
                      formObj.pre_fr.value = ComGetDateAdd(formObj.pre_fr.value,"D",+1);
                   }
                   fnFormClear();
                   break;

              case "btn_pre_to_back":
                  if (formObj.pre_to.value != "" ){
                      formObj.pre_to.value = ComGetDateAdd(formObj.pre_to.value,"D",-1);
                  }
                  fnFormClear();
                  break;

              case "btn_pre_to_next":
                  if (formObj.pre_to.value != "" ){
                      formObj.pre_to.value = ComGetDateAdd(formObj.pre_to.value,"D",+1);
                  }
                  fnFormClear();
                  break;

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
					
				// 높이 설정
				style.height = 440;
				
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
				
				var HeadTitle2 = "|sub chk|cal" +				
		        "|Lane|No.|Pass|VVD|VVD|VVD|ROB Port" +	
		        "|ROB Port|ROB Port|ROB Port|ETD" +
		        "|Allocation|Allocation" +		        
				"|20'|20'|20'|40'|40'|40'|40'|20'HC|20'HC|20'HC|20'HC|40'HC|40'HC|40'HC|40'HC|40'HC|45'|45'|45'|45'|45'|45'|Additional|Additional|Additional|Additional" +
				"|AK|VOID|DG|DG|RF|RF|RF ROB|RF ROB" +										
				"|EMPTY|EMPTY" +
				"|Total\nTEU|Total\nE.Weight|Over Used|Over Used" +										
				"|Final Used" +										
				"|TEU|20'HC|20'HC|40'HC|40'HC|45'|45'|45'|ROUND RULE|CLPT SEQ";
				var HeadTitle3 = "|sub chk|cal" +				
			    "|Lane|No.|Pass|VSL|VOY|DIR|Port" +		
		        "|Tml|Ind|RDR|ETD" +
		        "|TEU|WT" +		        
				"|Full|Empty|TTL|Full|Empty|TTL|TTL(TEU)|Full|Empty|TTL|ADD|Full|Empty|TTL|TTL(TEU)|ADD|Full|Empty|TTL|TTL(TEU)|ADD(U)|ADD(O)|20'HC|40'HC|45'(U)|45'(O)" +
				"|AK|VOID|20'|40'|20'|40'|20'|40'" +
				"|TEU|WEIGHT" +
				"|Total\nTEU|Total\nE.Weight|TEU|WT" +										
				"|OUS" +
				"|TEU|Sub-Allo|Ratio|Sub-Allo|Ratio|Sub-Allo|Ratio 1|Ratio 2|ROUND RULE|CLPT SEQ";						

				var headCount = ComCountHeadTitle(HeadTitle2);
				
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, false, false, true, false,false);
								
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]				
				InitHeadRow(0, HeadTitle2, true);
				InitHeadRow(1, HeadTitle3, true);
				
				// 데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,       COLMERGE,   SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++,  dtHiddenStatus,		  30, 	   daCenter,    true,   "ibflag");				
				InitDataProperty(0, cnt++ , dtHidden,   	  30,     daCenter,    true,    "sub_chk",        false,    "",    dfNumber,	 0, false, false);
				InitDataProperty(0, cnt++ , dtHidden,      30,     daRight,      false,   "all_wgt_c",      false,    "IF(|sub_chk|=2, |all_teu|*|all_wgt|, |all_wgt|)", dfNumber, 0, true, false);				
				InitDataProperty(0, cnt++ , dtHidden,      30,     daCenter,    true,    "lane",        		false,    "",    dfNone, 0, false, false);				
				InitDataProperty(0, cnt++ , dtData,		  40,	   daCenter,	 true,	"seq_no",       	false,    "",    dfNumber, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,      	  30,     daCenter,    true,    "pass",        		false,    "",    dfNone, 0, false, false);				
//				InitDataProperty(0, cnt++ , dtData,      	  80,     daCenter,    true,    "vvd",        		true,    "",    dfNone, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,      	  40,     daCenter,    true,    "vsl_cd",        	false,    "",    dfNone, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,      	  40,     daCenter,    true,    "skd_voy_no", 	false,    "",    dfNone, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,      	  40,     daCenter,    true,    "skd_dir_cd",   	false,    "",    dfNone, 0, false, false);				
				InitDataProperty(0, cnt++ , dtData,      	  50,     daCenter,    true,    "vps_port_cd",  false,    "",    dfNone, 0, false, false);					
				InitDataProperty(0, cnt++ , dtData,      	  30,     daCenter,    true,    "tml_cd",       	false,    "",    dfNone, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,      	  25,     daCenter,    true,    "split_no",       	false,    "",    dfNone, 0, false, false);
				InitDataProperty(0, cnt++ , dtCombo,   	  40,     daCenter,    true,    "rdr_flg",  		   	false,    "",    dfNone, 0, true, true);				
				InitDataProperty(0, cnt++ , dtData,      	  100,    daCenter,    true,    "vps_etd_dt",    false,    "",    dfUserFormat2, 0, false, false);
								
//--------------------------------------------------------				
				InitDataProperty(0, cnt++ , dtData,      50,     daRight,     false,    "all_teu",        false,    "",    	dfNumber, 0, true, false);
				InitDataProperty(0, cnt++ , dtData,      50,     daRight,     false,    "all_wgt",        false,    "", 		dfNumber, 0, true, false);
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
				
				InitDataProperty(0, cnt++ , dtData,         50,     daRight,     true,    "ak_unit",        false,    "",    dfNumber, 0, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtData,         50,     daRight,     true,    "ak_void",        false,    "",    dfNumber, 0, false, false,0,false,false);
				
				InitDataProperty(0, cnt++ , dtData,         40,     daRight,     true,    "dg_20",        false,    "",    dfNumber, 0, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtData,         40,     daRight,     true,    "dg_40",        false,    "",    dfNumber, 0, false, false);
				
				InitDataProperty(0, cnt++ , dtData,         40,     daRight,     true,    "rf_20_qty",      false,    "",    dfNumber, 0, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtData,         40,     daRight,     true,    "rf_40_qty",      false,    "",    dfNumber, 0, false, false);
				InitDataProperty(0, cnt++ , dtData,         40,     daRight,     true,    "rf_rdr_20",      false,    "",    dfNumber, 0, false, false,0,false,false);				
				InitDataProperty(0, cnt++ , dtData,         40,     daRight,     true,    "rf_rdr_40",      false,    "",    dfNumber, 0, false, false,0,false,false);				
				
				InitDataProperty(0, cnt++ , dtHidden,      50,     daRight,     true,    "mt_teu",         false,    "",    dfNumber, 0, false, false);
				InitDataProperty(0, cnt++ , dtHidden,      50,     daRight,     true,     "mt_wt",           false,    "",    dfNumber, 0, false, false);
				
				InitDataProperty(0, cnt++ , dtData,         80,     daRight,     true,    "grand_ttl_slot", false,    rule_grand_ttl_slot, dfFloat, 2, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtData,         80,     daRight,     true,    "grand_ttl_wgt",  false,    "",    dfFloat, 2, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,    "over_slot_c",    false,    rule_over_slot_c,    dfFloat, 2, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,    "over_wgt_c",     false,    rule_over_wgt_c,     dfFloat, 2, false, false,0,false,false);
				InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,    "fin_used",       	 false,    "",    dfFloat, 2, false, false,0,false,false);				
				
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
				 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	false,  "clpt_seq", 		false, "", dfNone, 2,  true, true);				 
				
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
				 
				InitUserFormat2(0, "vps_etd_dt",  "####-##-## ##:##", "-|:" );
				FrozenCols = 16;				
				
				ShowButtonImage = 1;
				CountPosition = 2;				 
				
				InitDataCombo(0, "rdr_flg",    " |R", " |R","");				
	        }
            break;
        }        	
    }
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
            case IBSEARCH:      //조회
                if (!validateForm(sheetObj,formObj,sAction)) {
                    return;
                }
                
				formObj.f_cmd.value = SEARCH;	               	               				
				var sXml = sheetObj.GetSearchXml("FNS_JOO_0103GS.do", FormQueryString(formObj));
				var key = ComGetEtcData(sXml,"key");
				
	            if (key.length > 0) {
	    			gRefresh = true; // 결과 file에서 조회해야함
	                formObj.key.value = key;
	                sheetObj.WaitImageVisible = false;
	                ComOpenWait(true);
	                sheetObj.RequestTimeOut = 10000;
	                timer = setInterval(UF_getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
	            }			
                break;
                
            case IBSEARCH_ASYNC10:      //조회
                if (!validateForm(sheetObj,formObj,sAction)) {
                    return;
                }
                
				formObj.f_cmd.value = SEARCH02;	               	               				
				var sXml = sheetObj.GetSearchXml("FNS_JOO_0103GS.do", FormQueryString(formObj));
				var key = ComGetEtcData(sXml,"key");
				
	            if (key.length > 0) {
	    			gRefresh = true; // 결과 file에서 조회해야함
	                formObj.key.value = key;
	                sheetObj.WaitImageVisible = false;
	                ComOpenWait(true);
	                sheetObj.RequestTimeOut = 10000;
	                timer = setInterval(UF_getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
	            }			
                break;             
                
            case IBSEARCH_ASYNC11:      //조회
                if (!validateForm(sheetObj,formObj,sAction)) {
                    return;
                }
                
				formObj.f_cmd.value = SEARCH03;	               	               				
				var sXml = sheetObj.GetSearchXml("FNS_JOO_0103GS.do", FormQueryString(formObj));
				var key = ComGetEtcData(sXml,"key");
				
	            if (key.length > 0) {
	    			gRefresh = true; // 결과 file에서 조회해야함
	                formObj.key.value = key;
	                sheetObj.WaitImageVisible = false;
	                ComOpenWait(true);
	                sheetObj.RequestTimeOut = 10000;
	                timer = setInterval(UF_getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
	            }			
                break;                    

            case IBSEARCH_ASYNC12:      //조회
                if (!validateForm(sheetObj,formObj,sAction)) {
                    return;
                }
                
				formObj.f_cmd.value = SEARCH04;	               	               				
				var sXml = sheetObj.GetSearchXml("FNS_JOO_0103GS.do", FormQueryString(formObj));
				var key = ComGetEtcData(sXml,"key");
				
	            if (key.length > 0) {
	    			gRefresh = true; // 결과 file에서 조회해야함
	                formObj.key.value = key;
	                sheetObj.WaitImageVisible = false;
	                ComOpenWait(true);
	                sheetObj.RequestTimeOut = 10000;
	                timer = setInterval(UF_getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
	            }			
                break;                    

            case IBSEARCH_ASYNC13:      //조회
                if (!validateForm(sheetObj,formObj,sAction)) {
                    return;
                }
                
				formObj.f_cmd.value = SEARCH05;	               	               				
				var sXml = sheetObj.GetSearchXml("FNS_JOO_0103GS.do", FormQueryString(formObj));
				var key = ComGetEtcData(sXml,"key");
				
	            if (key.length > 0) {
	    			gRefresh = true; // 결과 file에서 조회해야함
	                formObj.key.value = key;
	                sheetObj.WaitImageVisible = false;
	                ComOpenWait(true);
	                sheetObj.RequestTimeOut = 10000;
	                timer = setInterval(UF_getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
	            }			
                break;                   
                
                
            case IBSEARCH_ASYNC01:      //조회
                if (!validateForm(sheetObj,formObj,sAction)) {
                    return;
                }
                
				formObj.f_cmd.value = SEARCH01;	               	               				
				sheetObj.DoSearch("FNS_JOO_0103GS.do", FormQueryString(formObj));
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
                
        		//BackEndJob Status 조회
    		case IBSEARCH_ASYNC02: 			
    		    formObj.f_cmd.value = SEARCHLIST;
    		    var sXml = sheetObj.GetSearchXml("FNS_JOO_0103GS.do", FormQueryString(formObj));
    		    var jobState = ComGetEtcData(sXml, "jb_sts_flg")

    		    if (jobState == "3") {
    		        ComOpenWait(false);
    		        clearInterval(timer);
    		        ComShowCodeMessage("JOO00160");
    		        if (gRefresh){
    						doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
    		        }
    		    } else if (jobState == "4") {
    		        ComOpenWait(false);
    		        clearInterval(timer);
    		        // BackEndJob을 실패 하였습니다.
    		        ComShowCodeMessage('JOO00151');
    		    } else if (jobState == "5") {
    		        ComOpenWait(false);
    		        clearInterval(timer);
    		        // 이미 BackEndJob 결과 파일을 읽었습니다.
    		        ComShowCodeMessage('JOO00152');
    		    }                
    			break;
    			
    			//BackEndJob 결과 조회
    		case IBSEARCH_ASYNC03: 			
                sheetObj.WaitImageVisible = true;			
    		    formObj.f_cmd.value = SEARCHLIST03;
    		    var sXml = sheetObj.GetSearchXml("FNS_JOO_0103GS.do", FormQueryString(formObj));
    		    sheetObj.LoadSearchXml(sXml);
    			break;    			
    			
    			
    		case IBSAVE: //저장
    			formObj.f_cmd.value = MULTI;    			    			
           		sheetObj.DoSave("FNS_JOO_0103GS.do","f_cmd=7&rlane_cd="+formObj.rlane_cd.value+"&"+ComGetSaveString(sheetObj));
            	break;           		
    			
        }
    }
    
       
    /**
     * Sheet1의 OnSearchEnd 이벤트 처리
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var teu_qty = 0;
    	var over_slot_c = 0;
    	var over_wgt_c = 0;
    	    	
    	if(sheetObj.RowCount > 0){    		           		
    		for(var i=2; i<sheetObj.RowCount+2; i++){    			    		
	    		teu_qty = sheetObj.CellValue(i,"teu_qty");
	    		over_slot_c = sheetObj.CellValue(i,"over_slot_c");
	    		over_wgt_c = sheetObj.CellValue(i,"over_wgt_c");
	    		    		
	    		if(over_slot_c > over_wgt_c/teu_qty){
	    			sheetObj.CellValue2(i, "fin_used") =  over_slot_c;
	    		}else{
	    			sheetObj.CellValue2(i, "fin_used") =  over_wgt_c/teu_qty;
	    		}    		    			    			    	
	    			    		
	    		if(sheetObj.CellValue(i, "fin_used") < 0){
	    			sheetObj.CellValue2(i, "fin_used") = 0;
	    		}	    		
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
                 case IBSEARCH_ASYNC01:
                     if(!ComChkValid(formObj)){
                         return false;
                     }
                     break;
                     
         }
         return true;
     }
     
     /**
      * Back End Job 상태
      */     
     function UF_getBackEndJobStatus() {
    		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
   	 }
     
     
     /**
      * Rob가 없는 VVD 표시/삭제
      */          
     function displayGrid(sw){
    	 var k=1;
         var sheetObj = sheetObjects[0];
         
    	 if(sw == 'show'){
    		 for(var i =2; i<sheetObj.RowCount+2; i++){
    			  if (sheetObj.RowHidden(i)){
    				  sheetObj.RowHidden(i) = false
    			  }
 				 sheetObj.CellValue(i,"seq_no") = k++;    			  
    		 }
    	 }else{
    		 for(var i =2; i<sheetObj.RowCount+2; i++){    			     			    			 
    			 if(sheetObj.CellValue(i,"grand_ttl_slot") == 0 &&
    					 sheetObj.CellValue(i,"grand_ttl_wgt") == 0 &&
    					 sheetObj.CellValue(i,"over_slot_c") == 0 &&
    					 sheetObj.CellValue(i,"over_wgt_c") == 0 &&
    					 sheetObj.CellValue(i,"fin_used") == 0 ){
        			 sheetObj.RowHidden(i) = true;
    			 }else{    				 
    				 sheetObj.CellValue(i,"seq_no") = k++; 
    			 }    			 
    		 }    		 
    	 }    	 
     }
     
     /**
      * VVD의 ETD SKD 날짜 조회시 Columen 표시
      */          
     function displayColumn(sw){     
         var sheetObj = sheetObjects[0];
         var colName = "";
   		 for(var i=0; i<=sheetObj.LastCol ; i++){
   			    colName = sheetObj.ColSaveName(i);
   			    if(		colName == "full_20" ||       
   			    		colName == "mt_20" ||                 
   			    		colName == "full_40" ||       
   			    		colName == "mt_40" ||                      
   			    		colName == "hc_ld_20" ||      
   			    		colName == "hc_bsa_20" ||               
   			    		colName == "hc_ld_40" ||      
   			    		colName == "hc_bsa_40" ||          
   			    		colName == "hc_ld_45" ||      
   			    		colName == "hc_bsa_45" ||        			    	  
   			    		colName == "ak_unit" ||   
   			    		colName == "ak_void" ||   
   			    		colName == "dg_20" || 
   			    		colName == "dg_40" || 
   			    		colName == "rf_20_qty" ||
   			    		colName == "rf_40_qty" ||
   			    		colName == "rf_rdr_20" ||   			    		
   			    		colName == "rf_rdr_40" ||   			    		
   			    		colName == "grand_ttl_slot" || 
   			    		colName == "grand_ttl_wgt" ||  
   			    		colName == "over_slot_c" ||    
   			    		colName == "over_wgt_c" ||     
   			    		colName == "fin_used"    			    		   			    			
   			    		){
			   	   	    	 	if(sw=="hide"){
			   	   	    	 		sheetObj.ColHidden(i) = true;
			   	   	    	 	}else{
			   	   	    	 		sheetObj.ColHidden(i) = false;			   	   	    	 		
			   	   	    	 	}    		    			    	
   			    }
    	 }
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
		    		
		
		if(over_slot_c > over_wgt_c/teu_qty){
			sheetObj.CellValue2(i, "fin_used") =  over_slot_c;
		}else{
			sheetObj.CellValue2(i, "fin_used") =  over_wgt_c/teu_qty;
		}  
				
     }     
/* 개발자 작업  끝 */
