/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0108.js
*@FileTitle : TDR Download by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.10
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.08.10 민정호
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
     * @class FNS_JOO_0108 : FNS_JOO_0108 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function FNS_JOO_0108() {
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

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
         var formObject = document.form;

         try {
             var srcName = window.event.srcElement.getAttribute("name");
             switch(srcName) {             
                 case "btn_Retrieve":
                      doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                      break;

                 case "btn_downexcel":
					  sheetObjects[0].Down2Excel(-1);                	 
                      break;

                 case "btns_calendar_from": //달력버튼
                     var cal = new ComCalendar();
                     cal.select(formObject.pre_fr, 'yyyy-MM-dd');
                     break;

                case "btns_calendar_to": //달력버튼
                     var cal = new ComCalendar();
                     cal.select(formObject.pre_to, 'yyyy-MM-dd');
                     break;
        			
        		case "crr_flg":
        			if (formObject.crr_flg.checked){
        				document.all.showCrr.style.display = "block";
        				document.all.showCrr.style.visibility = 'visible';        				
        			}else{
        				document.all.showCrr.style.display = "none";
        				document.all.showCrr.style.visibility = 'hidden';        				
        			}
        			break;

				case "detail_flg": //Detail check 20120615
					var sheetObj = sheetObjects[0];
					if (formObject.detail_flg.checked) {
						 sheetObj.ColHidden("ttl_20") = false;
						 sheetObj.ColHidden("ttl_40") = false;
						 sheetObj.ColHidden("ttl_20_40") = false;
						 sheetObj.ColHidden("ttl_hc_20") = false;
						 sheetObj.ColHidden("add_hc_20") = false;
						 sheetObj.ColHidden("ttl_hc_40") = false;
						 sheetObj.ColHidden("ttl_hc_20_40") = false;
						 sheetObj.ColHidden("add_hc_40") = false;
						 sheetObj.ColHidden("ttl_hc_45") = false;
						 sheetObj.ColHidden("ttl_hc_20_45") = false;
						 sheetObj.ColHidden("addu_hc_45") = false;
						 sheetObj.ColHidden("addo_hc_45") = false;
						 sheetObj.ColHidden("add_ttl_20") = false;
						 sheetObj.ColHidden("add_ttl_40") = false;
						 sheetObj.ColHidden("addu_ttl_45") = false;
						 sheetObj.ColHidden("addo_ttl_45") = false;
					} else {
						 sheetObj.ColHidden("ttl_20") = true;
						 sheetObj.ColHidden("ttl_40") = true;
						 sheetObj.ColHidden("ttl_20_40") = true;
						 sheetObj.ColHidden("ttl_hc_20") = true;
						 sheetObj.ColHidden("add_hc_20") = true;
						 sheetObj.ColHidden("ttl_hc_40") = true;
						 sheetObj.ColHidden("ttl_hc_20_40") = true;
						 sheetObj.ColHidden("add_hc_40") = true;
						 sheetObj.ColHidden("ttl_hc_45") = true;
						 sheetObj.ColHidden("ttl_hc_20_45") = true;
						 sheetObj.ColHidden("addu_hc_45") = true;
						 sheetObj.ColHidden("addo_hc_45") = true;
						 sheetObj.ColHidden("add_ttl_20") = true;
						 sheetObj.ColHidden("add_ttl_40") = true;
						 sheetObj.ColHidden("addu_ttl_45") = true;
						 sheetObj.ColHidden("addo_ttl_45") = true;
					}
					break;
					
				case "btn_save": //SAVE
					var sheetObj = sheetObjects[0];					
					doActionIBSheet(sheetObj, formObject, IBCREATE);
					break;						
					
				case "rmk_flg":
					if (formObject.rmk_flg.checked) {
	                	displayColumn("show");																		
					}else{
						displayColumn('hide');						
					}
					break;						

	             case "btn_new":
	            	formObject.reset();
	            	formObject.skd_dir_cd.Index2 = 0;	      	            	
	            	sheetObjects[0].RemoveAll();        			
	            	comboObjects[1].RemoveAll();
	            	comboObjects[2].RemoveAll();
	            	comboObjects[3].Code="-1";	            	
                    break;
	             case "btn_vvd_skd":
					var sheetObj = sheetObjects[0];
					var row = sheetObj.SelectRow;
					
					if(row > 0){
						var vsl_cd = sheetObj.CellValue(row,"vsl_cd");
						var skd_voy_no = sheetObj.CellValue(row,"skd_voy_no");
						var skd_dir_cd = sheetObj.CellValue(row,"skd_dir_cd");
				
						param = "vsl_cd="+vsl_cd+"&skd_voy_no="+skd_voy_no+"&skd_dir_cd="+skd_dir_cd;
						ComOpenPopup('/hanjin/VOP_VSK_0019.do?pgmNo=VOP_VSK_0019&'+param, 1000, 630, '', '0,0'); 
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
             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         // IBMultiCombo초기화
         for(var k=0; k<comboObjects.length; k++){
             initCombo(comboObjects[k], k + 1);
         }
         initControl();                
     }
      /**
       * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
       * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
       * @param {ibsheet} sheetObj    IBSheet Object

       * @param {int}     sheetNo     sheetObjects 배열에서 순번
       **/
      function initControl() {
          var formObject = document.form;
          axon_event.addListenerForm  ('keydown', 'ComKeyEnter',  formObject);
          axon_event.addListenerForm  ('keydown', "fnOnKeyDown",  formObject);

          axon_event.addListenerForm  ('keypress', 'fnObjKeyPress', formObject );
          axon_event.addListenerForm  ('change'  , 'fnObjChange', formObject );
          axon_event.addListenerForm  ('keyup'   , "fnObjKeyUp",  formObject);

          axon_event.addListenerFormat('deactivate',  'fnDeactivate',  formObject);
          axon_event.addListenerFormat('activate',  'fnActivate',  formObject);
          
          axon_event.addListenerFormat('change', 'obj_change',	formObject);		//- 변경될때
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
					 var rule_add_ttl_20 = "IF(|jo_20ft_n1st_rto|=1, 0, IF((|hc_ld_20|+|hc_bsa_20|-|jo_20ft_sub_teu_qty|)*(|jo_20ft_n1st_rto|-1)<0, 0, IF(|jo_rnd_rule_lvl|=1, Round((|hc_ld_20|+|hc_bsa_20|-|jo_20ft_sub_teu_qty|)*(|jo_20ft_n1st_rto|-1),0), IF(|jo_rnd_rule_lvl|=2, Ceiling((|hc_ld_20|+|hc_bsa_20|-|jo_20ft_sub_teu_qty|)*(|jo_20ft_n1st_rto|-1)), IF(|jo_rnd_rule_lvl|=3, Int((|hc_ld_20|+|hc_bsa_20|-|jo_20ft_sub_teu_qty|)*(|jo_20ft_n1st_rto|-1)), (|hc_ld_20|+|hc_bsa_20|-|jo_20ft_sub_teu_qty|)*(|jo_20ft_n1st_rto|-1))))))";
					 var rule_add_ttl_40 = "IF(|jo_40ft_n1st_rto|=1, 0, IF((|hc_ld_40|+|hc_bsa_40|-|jo_40ft_sub_teu_qty|)*(|jo_40ft_n1st_rto|-2)<0, 0, IF(|jo_rnd_rule_lvl|=1, Round((|hc_ld_40|+|hc_bsa_40|-|jo_40ft_sub_teu_qty|)*(|jo_40ft_n1st_rto|-2),0), IF(|jo_rnd_rule_lvl|=2, Ceiling((|hc_ld_40|+|hc_bsa_40|-|jo_40ft_sub_teu_qty|)*(|jo_40ft_n1st_rto|-2)), IF(|jo_rnd_rule_lvl|=3, Int((|hc_ld_40|+|hc_bsa_40|-|jo_40ft_sub_teu_qty|)*(|jo_40ft_n1st_rto|-2)), (|hc_ld_40|+|hc_bsa_40|-|jo_40ft_sub_teu_qty|)*(|jo_40ft_n1st_rto|-2))))))";					 					
					 var rule_addu_ttl_45 = "IF(|jo_45ft_n1st_rto|=2, IF(  |jo_45ft_n2nd_rto|=2, 0, IF( (|hc_ld_45|+|hc_bsa_45|)<=|jo_45ft_sub_teu_qty|, IF((|hc_ld_45|+|hc_bsa_45|)*(|jo_45ft_n1st_rto|-2)<0, 0, ROUND((|hc_ld_45|+|hc_bsa_45|)*(|jo_45ft_n1st_rto|-2),0)) , IF(|jo_45ft_sub_teu_qty|*(|jo_45ft_n1st_rto|-2)<0,0,ROUND(|jo_45ft_sub_teu_qty|*(|jo_45ft_n1st_rto|-2),0)))), IF( (|hc_ld_45|+|hc_bsa_45|)<=|jo_45ft_sub_teu_qty|, IF((|hc_ld_45|+|hc_bsa_45|)*(|jo_45ft_n1st_rto|-2)<0,0,ROUND((|hc_ld_45|+|hc_bsa_45|)*(|jo_45ft_n1st_rto|-2),0)), IF(|jo_45ft_sub_teu_qty|*(|jo_45ft_n1st_rto|-2)<0,0,ROUND(|jo_45ft_sub_teu_qty|*(|jo_45ft_n1st_rto|-2),0))))";
					 var rule_addo_ttl_45 = "IF(|jo_45ft_n1st_rto|=2, IF(|jo_45ft_n2nd_rto|=2, 0, IF((|hc_ld_45|+|hc_bsa_45|)<=|jo_45ft_sub_teu_qty|, 0, IF(((|hc_ld_45|+|hc_bsa_45|)-|jo_45ft_sub_teu_qty|)*(|jo_45ft_n2nd_rto|-2)<0,0,ROUND(((|hc_ld_45|+|hc_bsa_45|)-|jo_45ft_sub_teu_qty|)*(|jo_45ft_n2nd_rto|-2),0) ))), IF((|hc_ld_45|+|hc_bsa_45|)<=|jo_45ft_sub_teu_qty|, 0, IF(((|hc_ld_45|+|hc_bsa_45|)-|jo_45ft_sub_teu_qty|)*(|jo_45ft_n2nd_rto|-2)<0,0,ROUND(((|hc_ld_45|+|hc_bsa_45|)-|jo_45ft_sub_teu_qty|)*(|jo_45ft_n2nd_rto|-2),0))))";
					 
					 var rule_grand_ttl_slot = "|full_20|+|mt_20|+((|full_40|+|mt_40|)*2)+|hc_ld_20|+|hc_bsa_20|+((|hc_ld_40|+|hc_bsa_40|)*2)+((|hc_ld_45|+|hc_bsa_45|)*2)+(" + rule_add_ttl_20 + ")+(" + rule_add_ttl_40 + ")+(" + rule_addu_ttl_45 + ")+(" + rule_addo_ttl_45 +")+|ak_void|";
					 var rule_grand_ttl_slot2 =  "IF((|all_teu|) = 0, 0, "+rule_grand_ttl_slot+")";
					 					 
					 var rule_add_hc_20 = "IF(|jo_20ft_n1st_rto|=1, 0, IF(|ttl_hc_20|-|jo_20ft_sub_teu_qty|<0, 0, |ttl_hc_20|-|jo_20ft_sub_teu_qty|))";
					 var rule_add_hc_40 = "IF(|jo_40ft_n1st_rto|=2, 0, IF(|ttl_hc_40|-|jo_40ft_sub_teu_qty|<0, 0, |ttl_hc_40|-|jo_40ft_sub_teu_qty|))";
					 var rule_addu_hc_45 = "IF(|jo_45ft_n1st_rto|=2, IF(|jo_45ft_n2nd_rto|=2, 0, IF(|ttl_hc_45|<=|jo_45ft_sub_teu_qty|, |ttl_hc_45|, |jo_45ft_sub_teu_qty|)), IF(|ttl_hc_45|<=|jo_45ft_sub_teu_qty|, |ttl_hc_45|, |jo_45ft_sub_teu_qty|))";
					 var rule_addo_hc_45 = "IF(|jo_45ft_n1st_rto|=2, IF(|jo_45ft_n2nd_rto|=2, 0, IF(|ttl_hc_45|<=|jo_45ft_sub_teu_qty|, 0, |ttl_hc_45|-|jo_45ft_sub_teu_qty|)), IF(|ttl_hc_45|<=|jo_45ft_sub_teu_qty|, 0, |ttl_hc_45|-|jo_45ft_sub_teu_qty|))";
					 
					 var rule_over_slot_c = "IF((|grand_ttl_slot|-|all_teu|) < 0, 0, |grand_ttl_slot|-|all_teu|)";
					 var rule_over_slot_c2 =  "IF((|all_teu|) = 0, 0, "+rule_over_slot_c+")";
						 
					 var rule_over_wgt_c = "IF((|grand_ttl_wgt|-|all_wgt|) < 0, 0, |grand_ttl_wgt|-|all_wgt|)";
                     // 높이 설정
                     style.height = 406;

                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     // 전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;//msAll;                     
                     
                     // 전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 3, 100);

                     var HeadTitle2 = "STS|Target|Close|Lane|VVD|VVD|VVD|Port|Seq|ETD|Port\nStatus|Carrier|Trade|RDR" +
                     						 "|SUB_CHK|cal|Remark\nType|Remarks|Allocation|Allocation|Total Used|Total Used|Over Used|Over Used|Fin Used|TON/\nTEU" +
                     						 "|20'|20'|20'|40'|40'|40'|40'" +
                     						 "|20'HC|20'HC|20'HC|20'HC|40'HC|40'HC|40'HC|40'HC|40'HC|45'|45'|45'|45'|45'|45'|Additional|Additional|Additional|Additional|AK|AK|DG|DG|RF|RF|RF\nROB|EMPTY|EMPTY|Source"+
						 					 "|REV_YRMON|rev_yrmon_seq|STL_VVD_SEQ|RE_DIVR_CD"+                     
                     						 "|20'HC|20'HC|40'HC|40'HC|45'|45'|45'|ROUND RULE"+                     						 
     										 "|OUS\nAmount|R/F\nAmoun"+
                     						 "|REV_DIR_CD|RF_SCG_STL_TP_CD|yd_cd|clpt_ind_seq|slan_cd|acct_yrmon|stl_tgt_flg2|BSA";                     
                     var HeadTitle3 = "STS|Target|Close|Lane|VSL|VOY|DIR|Port|Seq|ETD|Port\nStatus|Carrier|Trade|RDR" +
                     						 "|SUB_CHK|cal|Remark\nType|Remarks|TEU|WT|TEU|WT|TEU|WT|OUS|TON/\nTEU" +
                     						 "|Full|Empty|TTL|Full|Empty|TTL|TTL(TEU)" +
                     						 "|Full|Empty|TTL|ADD|Full|Empty|TTL|TTL(TEU)|ADD|Full|Empty|TTL|TTL(TEU)|ADD(U)|ADD(O)|20'HC|40'HC|45'(U)|45'(O)|UNIT|VOID|20'|40'|20'|40'|RF\nROB|TEU|WEIGHT|Source"+
 					 						 "|REV_YRMON|rev_yrmon_seq|STL_VVD_SEQ|RE_DIVR_CD"+                     
                     						 "|Sub-Allo|Ratio|Sub-Allo|Ratio|Sub-Allo|Ratio 1|Ratio 2|ROUND RULE"+                     						 
     										 "|OUS\nAmount|R/F\nAmoun"+
     										 "|REV_DIR_CD|RF_SCG_STL_TP_CD|yd_cd|clpt_ind_seq|slan_cd|acct_yrmon|stl_tgt_flg2|BSA";
                     var headCount = ComCountHeadTitle(HeadTitle2);

                     // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 3, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

                     InitHeadRow(0, HeadTitle2, true);
                     InitHeadRow(1, HeadTitle3, true);

                     // 데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,       COLMERGE,   SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
     				 InitDataProperty(0, cnt++, dtStatus       ,30, daCenter, true, "ibflag"  );
    				 InitDataProperty(0, cnt++, dtCheckBox ,50, daCenter,  true, "stl_tgt_flg");		
     				 InitDataProperty(0, cnt++, dtCheckBox ,50, daCenter,  true, "stl_clz_flg");	    				
                     
     				 InitDataProperty(0, cnt++,  dtData,		  60, 		daCenter,   true, 	"rlane_cd",			false,    "", dfNone       ,0,false,true);     				                                        
     				 InitDataProperty(0, cnt++ , dtData,      	  40,     daCenter,    true,    "vsl_cd",        	false,    "",    dfNone, 0, false, false);
    				 InitDataProperty(0, cnt++ , dtData,      	  40,     daCenter,    true,    "skd_voy_no", 	false,    "",    dfNone, 0, false, false);
    				 InitDataProperty(0, cnt++ , dtData,      	  40,     daCenter,    true,    "skd_dir_cd",   	false,    "",    dfNone, 0, false, false);				
                                          
                     InitDataProperty(0, cnt++ , dtData,         60,     daCenter,    true,     "vps_port_cd",    	false,    "",    dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         40,     daCenter,    true,     "clpt_seq",    	false,    "",    dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         110,    daCenter,   true,     "vps_etd_dt",     	false,    "",    dfUserFormat2, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,      	  70,      daCenter,    true,    "port_skd_sts",    false,    "",    dfNone, 0, false, false);
                     
                     InitDataProperty(0, cnt++ , dtData,         50,     daCenter,    true,     "crr_cd",         		false,    "",    dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         50,     daCenter,    true,     "trd_cd",         		false,    "",    dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         50,     daCenter,    true,     "rdr_flg",         		false,    "",    dfNone, 0, false, false);                     
                                          
					 InitDataProperty(0, cnt++ , dtHidden,      30,     daCenter,   true,     "sub_chk",        	false,    "",    dfNumber, 0, false, false);
					 InitDataProperty(0, cnt++ , dtHidden,      60,     daRight,     false,    "all_wgt_c",      		false,    "IF(|sub_chk|=2, |all_teu|*|all_wgt|, |all_wgt|)", dfNumber, 0, true, false);
					 InitDataProperty(0, cnt++ , dtCombo,    100,    daLeft,    	 true,    "rmk_flg",  		   		false,    "",    dfNone, 0, true, true);
					 InitDataProperty(0, cnt++ , dtData,      	  200,    daLeft,     	 true,    "rmk", 		       		false,    "",    	dfNone, 0, true, true);									 
					 InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "all_teu",        		false,    "",    dfNumber, 0, false, false);
					 InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "all_wgt",        		false,    "", 	dfNumber, 0, false, false);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "grand_ttl_slot", 	false,    rule_grand_ttl_slot2, dfNumber, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "grand_ttl_wgt",  	false,    "",    dfNumber, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "over_slot_c",   	false,    rule_over_slot_c2,    dfNumber, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "over_wgt_c",    	false,    rule_over_wgt_c,     dfNumber, 0, false, false);
                     // 추가(Final Used OUS)
     				 InitDataProperty(0, cnt++ , dtData,         70,     daRight,     true,    "fin_used",       	 	false,    "",    dfFloat, 2, false, false,0,false,false);
     				 InitDataProperty(0, cnt++ , dtHidden,      50,     daRight,     true,    "teu_qty",         		false,    "",    dfFloat, 2, false, false);     				 
                                          
                     InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "full_20",        	false,    "",    dfNumber, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "mt_20",          	false,    "",    dfNumber, 0, false, false);
					 InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "ttl_20",         	false,    "|full_20|+|mt_20|",    dfNumber, 0, false, false); //20120615

                     InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "full_40",        	false,    "",    dfNumber, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "mt_40",          false,    "",    dfNumber, 0, false, false);
					 InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "ttl_40",         	false,    "|full_40|+|mt_40|",    dfNumber, 0, false, false); //20120615
					 InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "ttl_20_40",      false,    "|ttl_40|*2",    dfNumber, 0, false, false); //20120615

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "hc_ld_20",       		false,    "",    dfNumber, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "hc_bsa_20",      	false,    "",    dfNumber, 0, false, false);
					 InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "ttl_hc_20",      		false,    "|hc_ld_20|+|hc_bsa_20|",    dfNumber, 0, false, false); //20120615
					 InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "add_hc_20",      	false,    rule_add_hc_20, dfNumber, 0, false, false); //20120615

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "hc_ld_40",       		false,    "",    dfNumber, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "hc_bsa_40",      	false,    "",    dfNumber, 0, false, false);
					 InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "ttl_hc_40",      		false,    "|hc_ld_40|+|hc_bsa_40|",    dfNumber, 0, false, false); //20120615
					 InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "ttl_hc_20_40",   	false,    "(|hc_ld_40|+|hc_bsa_40|)*2",    dfNumber, 0, false, false); //20120615
					 InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "add_hc_40",      	false,    rule_add_hc_40, dfNumber, 0, false, false); //20120615

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "hc_ld_45",       false,    "",    dfNumber, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "hc_bsa_45",      false,    "",    dfNumber, 0, false, false);
					 InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "ttl_hc_45",      false,    "|hc_ld_45|+|hc_bsa_45|",    dfNumber, 0, false, false); //20120615
					 InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "ttl_hc_20_45",   false,    "|ttl_hc_45|*2",    dfNumber, 0, false, false); //20120615
					 
					 InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "addu_hc_45",     false, rule_addu_hc_45, dfNumber, 0, false, false); //20120615
					 InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "addo_hc_45",     false, rule_addo_hc_45, dfNumber, 0, false, false); //20120615
					 InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "add_ttl_20",     false, rule_add_ttl_20, dfNumber, 0, false, false); //20120615
					 InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "add_ttl_40",     false, rule_add_ttl_40, dfNumber, 0, false, false); //20120615
					 InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "addu_ttl_45",    false, rule_addu_ttl_45, dfNumber, 0, false, false); //20120615
					 InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "addo_ttl_45",    false, rule_addo_ttl_45, dfNumber, 0, false, false); //20120615

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "ak_unit",        false,    "",    dfNumber, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "ak_void",        false,    "",    dfNumber, 0, false, false);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "dg_20",        false,    "",    dfNumber, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "dg_40",        false,    "",    dfNumber, 0, false, false);
                     
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "rf_20_qty",      false,    "",    dfNumber, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "rf_40_qty",      false,    "",    dfNumber, 0, false, false);
     				 InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,    "rf_rdr_qty",      false,    "",    dfNumber, 0, false, false,0,false,false);
     				
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "mt_teu",         false,    "",    dfNumber, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "mt_wt",          false,    "",    dfNumber, 0, false, false);

                     InitDataProperty(0, cnt++ , dtHidden,         60,     daCenter,     true,    "source",         false,    "",    dfNone, 0, false, false);
					 
					 //2012.06.19추가
                    // 임시				 
    				 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	true,  "rev_yrmon", 		false, "", dfNone, 0,  false, false);
    				 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	true,  "rev_yrmon_seq", 	false, "", dfNone, 0,  false, false);    				 
    				 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	true,  "stl_vvd_seq",		false, "", dfNone, 0,  false, false);
    				 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	true,  "re_divr_cd",			false, "", dfNone, 0,  false, false);  				 
    				 
					 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	true,  "jo_20ft_sub_teu_qty",  false, "", dfInteger, 2,  true, true, 9);
					 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	true,  "jo_20ft_n1st_rto",  		 false, "", dfFloat, 2,  true, true, 5);
					 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	true,  "jo_40ft_sub_teu_qty",  false, "", dfInteger, 2,  true, true, 9);
					 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	true,  "jo_40ft_n1st_rto",     	 false, "", dfFloat, 2,  true, true, 5);
					 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	true,  "jo_45ft_sub_teu_qty",  false, "", dfInteger, 2,  true, true, 9);
					 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	true,  "jo_45ft_n1st_rto", 		 false, "", dfFloat, 2,  true, true, 5);
					 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	true,  "jo_45ft_n2nd_rto", 		 false, "", dfFloat, 2,  true, true, 5);
					 InitDataProperty(0, cnt++ , dtHidden,	80, daCenter,	true,  "jo_rnd_rule_lvl", 			 false, "", dfNone, 2,  true, true);
					 
					 InitDataProperty(0, cnt++ , dtHidden,	50, daRight,	true,  "ovr_usd_slt_amt",		false, "", dfNone, 0,  false, false);
					 InitDataProperty(0, cnt++ , dtHidden,	50, daRight,	true,  "rf_20ft_cntr_stl_amt",		false, "", dfNone, 0,  false, false);
					 
					 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	true,  "rev_dir_cd",		false, "", dfNone, 0,  false, false);
					 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	true,  "rf_scg_stl_tp_cd",		false, "", dfNone, 0,  false, false);					 
					 
					 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	true,  "yd_cd",		false, "", dfNone, 0,  false, false);					 
					 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	true,  "clpt_ind_seq",		false, "", dfNone, 0,  false, false);
					 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	true,  "slan_cd",		false, "", dfNone, 0,  false, false);				
					 InitDataProperty(0, cnt++ , dtHidden,	50, daRight,	true,  "acct_yrmon",		false, "", dfNone, 0,  false, false);
					 InitDataProperty(0, cnt++ , dtHidden,	50, daRight,	true,  "stl_tgt_flg2",		false, "", dfNone, 0,  false, false);					 
					 InitDataProperty(0, cnt++ , dtData,	30, daCenter,	true,  "bsa_flg",		false, "", dfNone, 0,  false, false);					 
					 					 
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
 					InitDataCombo(0, "rmk_flg", " |Price TBD|Contract Details TBD|Operational Issues|Mere Delay", " |1|2|3|4",""); 					
 					FrozenCols = 8;	
                 }
             break;


             case 3:      //sheet1 init
				cnt = 0;
				with (sheetObj) {
					// 높이 설정
					style.height = 240;
					//style.height = 180;

					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);

					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					var HeadTitle1 = "Carrier|20'HC|20'HC|40'HC|40'HC|45'|45'|45'|Round Type";
					var HeadTitle2 = "Carrier|Sub-Alloc|Over Ratio\n(TEU)|Sub-Alloc|Over Ratio\n(TEU)|Sub-Alloc|Under Ratio\n(TEU)|Over Ratio\n(TEU)|Round Type";

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,		80, daCenter,	true,    "jo_crr_cd", 			false, "", dfNone, 2,  false,  false);
					InitDataProperty(0, cnt++ , dtData,		80, daRight,	false,  "jo_20ft_sub_teu_qty",  false, "", dfInteger, 2,  true, true, 9);
					InitDataProperty(0, cnt++ , dtData,		80, daRight,	false,  "jo_20ft_n1st_rto",  	false, "", dfFloat, 2,  true, true, 5);
					InitDataProperty(0, cnt++ , dtData,		80, daRight,	false,  "jo_40ft_sub_teu_qty",  false, "", dfInteger, 2,  true, true, 9);
					InitDataProperty(0, cnt++ , dtData,		80, daRight,	false,  "jo_40ft_n1st_rto",     false, "", dfFloat, 2,  true, true, 5);
					InitDataProperty(0, cnt++ , dtData,		80, daRight,	false,  "jo_45ft_sub_teu_qty", 	false, "", dfInteger, 2,  true, true, 9);
					InitDataProperty(0, cnt++ , dtData,		80, daRight,	false,  "jo_45ft_n1st_rto", 	false, "", dfFloat, 2,  true, true, 5);
					InitDataProperty(0, cnt++ , dtData,		80, daRight,	false,  "jo_45ft_n2nd_rto", 	false, "", dfFloat, 2,  true, true, 5);
					InitDataProperty(0, cnt++ , dtCombo,	80, daCenter,	true,   "jo_rnd_rule_lvl", 		false, "", dfNone, 2,  true, true);
					InitDataCombo(0, "jo_rnd_rule_lvl", " |Round|Round Up|Round Down|No", " |1|2|3|4");
				}
             break;
         }
     }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
            case IBSEARCH:      //조회
                if (!validateForm(sheetObj,formObj,sAction)) {
                    return;
                }
				
                if(comboObjects[3].CheckIndex(0)){
                	formObj.opt_tgt.value = "T";
                }else{
                	formObj.opt_tgt.value = "";
                }
                	
                if(comboObjects[3].CheckIndex(1)){
                	formObj.opt_clz.value = "C";
                }else{
                	formObj.opt_clz.value = "";
                }
                
                if(comboObjects[3].CheckIndex(2)){                	
                	comboObjects[3].CheckIndex(0) = false;
                	comboObjects[3].CheckIndex(1) = false;
                	
                	formObj.opt_tgt.value = "N";                	
                	formObj.opt_clz.value = "N";
                }                
                                
				//Merge 체크되어있는 경우
//				if (formObj.sum_flg.checked){
//					formObj.f_cmd.value = SEARCH03;
//					
//                    var xmlStr = sheetObj.GetSearchXml("FNS_JOO_0108GS.do", "f_cmd=" + SEARCH03 
//					+ "&pre_to=" + formObj.pre_to.value
//					+ "&pre_fr=" + formObj.pre_fr.value
//					+ "&rlane_cd=" + formObj.rlane_cd.value
//					+ "&opr_cd=" + formObj.opr_cd.value
//					+ "&opt_tgt=" + formObj.opt_tgt.value
//					+ "&opt_clz=" + formObj.opt_clz.value					
//					);
//										
//					if (ComGetEtcData(xmlStr, "carrier_cnt") != "1") {
//						ComShowCodeMessage("JOO00195");	//"You should select one rep. carrier in ‘Sub Allocation and Ratio’."
//						return;
//					}
//				}
				
                formObj.f_cmd.value = SEARCHLIST01;
                sheetObj.DoSearch("FNS_JOO_0108GS.do", FormQueryString(formObj));
                break;

            case IBCLEAR:      //
                var param = "";
                var sXml = "";

                var code   =  "CD00593";
                formObj.f_cmd.value = SEARCH01;
                param = FormQueryString(formObj)+"&super_cd1="+code;
                sXml  = sheetObj.GetSearchXml("FNS_JOO_0108GS.do", param);

                //ComXml2ComboItem 생성후 ALL 항목을 맨앞에 추가시 index가 재설정이 안되어 아래 방식으로 적용 
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

//            case IBSEARCH_ASYNC01:      //
//                var code            =  formObj.rlane_cd.value;
//                formObj.f_cmd.value = SEARCH07;
//                var param           =  FormQueryString(formObj)+"&code="+code;
//                var sXml            =  sheetObj.GetSearchXml("JOOCommonGS.do", param);
//                var sTotal          =  ComGetTotalRows(sXml);
//                if (sTotal == "0") {
//                    ComShowCodeMessage("JOO00110");
//                    formObj.rlane_cd.value = '';
//                    formObj.rlane_cd.focus();
//                    //fnDeactivate 덕분에...아래와 같이 코딩함
//                } else {
//                    formObj.rlane_cd.value = code;
//                    formObj.skd_dir_cd.focus();
//                }
//                break;
				
    		case IBCREATE: //저장    			
    			var SaveStr = ComGetSaveString(sheetObj);    		

    			if (SaveStr == ""){
    				ComShowCodeMessage("JOO00036");
    				return false;
    			}

    			for(var i=2; i<sheetObj.RowCount+2; i++){
    				if(formObj.merge_crr.value != ""){		// Merge인 경우    					    				    					
        				if(
        						sheetObj.CellValue(i,"stl_tgt_flg2") == "1" &&
        						sheetObj.CellValue(i,"rmk").substring(0,5) != "Merge" && 
        						sheetObj.CellValue(i,"ibflag") == "U" 
        					){
	    					alert("There is targeted item in selected data");
	    					return false;        					
        				}
    				}    				    				
    			}
    			    			    			
    			if (!ComShowCodeConfirm("JOO00046")){
    				return false;
    			}        			
    			
    			formObj.f_cmd.value = MULTI01;
    			sheetObj.WaitImageVisible=false;
    			ComOpenWait(true);
    			var sXml = sheetObj.GetSaveXml("FNS_JOO_0108GS.do", SaveStr + "&" + FormQueryString(formObj));    			
    			ComOpenWait(false);
    			sheetObj.LoadSearchXml(sXml);
    			    			
//    			doActionIBSheet(sheetObj, formObj, IBSEARCH);    			
//				재조회가 속도가 느리므로
    	    	var stl_tgt_flg = 0;
    	    	var stl_clz_flg = 0;
    	    	var acct_yrmon = '';
    	    	
    	    	if(sheetObj.RowCount > 0){    		           		
    	    		for(var i=2; i<sheetObj.RowCount+2; i++){
    		    		stl_tgt_flg = sheetObj.CellValue(i,  "stl_tgt_flg");
    		    		stl_clz_flg = sheetObj.CellValue(i,  "stl_clz_flg");
    		    		acct_yrmon = sheetObj.CellValue(i,"acct_yrmon");
    		    		
    	    			if(stl_tgt_flg == "1"){
    	    				sheetObj.CellEditable(i, "stl_tgt_flg") = false;
    	    			}
    	    			
    	    			if(acct_yrmon != "999912"){
    						sheetObj.CellEditable(i, "stl_tgt_flg") = false;
    					}	    		    		
    		    		
    	    			sheetObj.CellValue2(i, "ibflag") =  '';    	    			
    	    		}
    	    	}
    			
            	break;           						
        }
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

            case "oprCdCombo":
                with (comboObj) {
                    MultiSelect = true;
                    DropHeight = 200;
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
     			
            case "mergeCombo":
                with (comboObj) {
                    MultiSelect = false;
                    DropHeight = 200;
                }
                break;     			                
        }
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
	    	oprCdCombo_clear();
	    	mergeCombo_clear();
			break;
		case "pre_to":
	    	oprCdCombo_clear();
	    	mergeCombo_clear();	    	
			break;
		case "rlane_cd":
	    	oprCdCombo_clear();
	    	mergeCombo_clear();
			break;
		}
	}
    
    //Period, Lane 변경시 Carrier 초기화
    function oprCdCombo_clear(){
    	document.form.oprCdCombo.Index2 = -1;
    	document.form.oprCdCombo.RemoveAll();
    	document.form.opr_cd.value = "";

    	sheetObjects[0].RemoveAll();
    }

    //Period, Lane 변경시 Merge 초기화
    function mergeCombo_clear(){
    	document.form.mergeCombo.Index2 = -1;
    	document.form.mergeCombo.RemoveAll();
    	document.form.merge_crr.value = "";

    	sheetObjects[0].RemoveAll();
    }
        
    function oprCdCombo_OnFocus(comboObj){
    	var formObj = document.form;
    	
    	if (formObj.pre_fr.value.length < 10){
    		ComShowCodeMessage("JOO00019", "Period");
    		formObj.pre_fr.focus();
    		return;
    	}

    	if (formObj.pre_to.value.length < 10){
    		ComShowCodeMessage("JOO00019", "Period");
    		formObj.pre_to.focus();
    		return;
    	}

    	if (formObj.rlane_cd.value.length < 3){
    		ComShowCodeMessage("JOO00019", "Lane");
    		formObj.rlane_cd.focus();
    		return;
    	}
    	
    	if (comboObj.GetCount() == 0){
    		comboObj.Enable = false;	
    		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, comboObj ,"oprCdCombo");
    		comboObj.Enable = true;	
    	}	    	
    	
    	sheetObjects[0].RemoveAll();
    }

    function mergeCombo_OnFocus(comboObj){
    	var formObj = document.form;
    	    	
    	
    	if(comboObjects[1].GetCount() > 0){    	
    		comboObjects[2].RemoveAll();
	    	for(var i=1; i<comboObjects[1].GetCount(); i++){
	    		if(comboObjects[1].CheckIndex(i) == true){
	    			comboObjects[2].InsertItem(-1,comboObjects[1].GetIndexText(i,0),comboObjects[1].GetIndexText(i,0));     			
	    		}
	    	}     	    
    	}
    	
    	sheetObjects[0].RemoveAll();
    }    
        
    // 조회조건필드인 Carrier 데이터 조회
    function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboKey) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:
    			if (sComboObj.id == "oprCdCombo") {
    				//콤보필드를 초기화시킨다.
    				sComboObj.RemoveAll();
    									
    				formObj.f_cmd.value = SEARCH02;
    				var sXml = sheetObj.GetSearchXml("FNS_JOO_0108GS.do", FormQueryString(formObj));
    				
                    var comboCodeList = ComGetEtcData(sXml, "comboCode").split("^#^");
                    var comboTextList = ComGetEtcData(sXml, "comboText").split("^#^");
                    formObj.oprCdCombo.RemoveAll();
                    formObj.oprCdCombo.InsertItem(-1, "[ALL]", "");
                    for (var w=0; w<comboCodeList.length-1; w++) {
                        formObj.oprCdCombo.InsertItem(-1, comboTextList[w], comboCodeList[w]);
                    }
                    formObj.oprCdCombo.Index2 = 0;
    			}
    	        break;
        }
    }

    /**
     * oprCdCombo의 MultiSelection OnCheckClick 이벤트 처리
     *  - MultiCombo(MultiSelection허용)의 MultiSelection OnCheckClick 이벤트 처리
     *  - 'ALL'을 선택하면 다른 Item의 Check해제
     *  - Item을 선택했을 경우 SQL의 In 조건에 사용가능한 "('A', 'B', 'C')" 형식을 setting
     */
    function oprCdCombo_OnCheckClick(comboObj, index, code) {
        var formObject = document.form
        // 선택된 Index가 없을 경우는 0번 Index 강제 선택
        if (comboObj.Text == null || comboObj.Text == "") {
            comboObj.CheckIndex(0) = true;
            if (formObject.opr_cd == "[object]") formObject.opr_cd.value = "";

        } else {
            // Index 0번이 선택된 경우는 다른 모든 Index체크를 해제
            if (index == 0) {
                for(var i=1; i<comboObj.GetCount(); i++) {
                    comboObj.CheckIndex(i) = false;
                }
                // Submit할 내용도 Clear
                formObject.opr_cd.value = "";

                comboObjects[2].RemoveAll();	 // Merge콤보
                formObject.merge_crr.value = "";                
                
            // 다른Index가 선택된 경우는 Index 0을 해제
            } else {
                comboObj.CheckIndex(0) = false;
                // Submit할 내용 Define
//                formObject.opr_cd.value = ("'" + ComReplaceStr(comboObj.Code, ",", "', '") + "'");
                formObject.opr_cd.value = comboObj.Code;                
            }
        }
    }

    /**
     * mergeCombo의 OnChange 이벤트 처리
     */
    function mergeCombo_OnBlur(comboObj, index, code) {
        var formObject = document.form
        
        if (comboObj.Text == null || comboObj.Text == "") {        	        	
            if (formObject.merge_crr == "[object]") formObject.merge_crr.value = "";        	
        }else{
            // Submit할 내용 Define
            formObject.merge_crr.value = comboObj.Code;        	
        }
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

                case  'engup':
                      ComKeyOnlyAlphabet( 'upper' );
                      break;
                case  'uppernum':
                       ComKeyOnlyAlphabet( 'uppernum' );
                       break;

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
//                     if( sheetObjects[0].RowCount > 0) {
//                           sheetObjects[0].RemoveAll();
//                     }
//                     var maxlength = obj.getAttribute("maxlength");
//                     if( obj.value.length != maxlength   ){
//                         return;
//                     }else{
////                         doActionIBSheet( sheetObjects[0], formObj, IBSEARCH_ASYNC01);
//                     }
                     break;
         }
     }
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){

         switch(sAction){
                 case IBSEARCH:

                     if(!ComChkValid(  formObj )){
                         return false;
                     }

                     break;
         }

         return true;
     }

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
	    		 	    		    			    		
	    		if(over_slot_c > over_wgt_c/teu_qty){
	    			sheetObj.CellValue2(i, "fin_used") =  over_slot_c;
	    		}else{
	    			sheetObj.CellValue2(i, "fin_used") =  over_wgt_c/teu_qty;
	    		}    		    			    			    	
	    			    		
	    		if(sheetObj.CellValue(i, "fin_used") < 0){
	    			sheetObj.CellValue2(i, "fin_used") = 0;
	    		}	    		
	    			    			    		
	    		stl_tgt_flg = sheetObj.CellValue(i,  "stl_tgt_flg");
	    		stl_clz_flg = sheetObj.CellValue(i,  "stl_clz_flg");	    		
	    		
    			if(stl_tgt_flg == "1"){
    				sheetObj.CellEditable(i, "stl_tgt_flg") = false;
    			}
    			
    			if(acct_yrmon != "999912"){
					sheetObj.CellEditable(i, "stl_tgt_flg") = false;
				}
    			
    			sheetObj.CellValue2(i, "ibflag") =  '';
    			    			
    			sheetObj.CellBackColor(i, "grand_ttl_slot") = sheetObj.RgbColor(255, 153, 153);    			
    			sheetObj.CellBackColor(i, "over_slot_c") = sheetObj.RgbColor(255, 255, 153);
    			sheetObj.CellBackColor(i, "fin_used") = sheetObj.RgbColor(153, 255, 153);
    			sheetObj.CellBackColor(i, "dg_20") = sheetObj.RgbColor(153, 153, 255);
    			sheetObj.CellBackColor(i, "dg_40") = sheetObj.RgbColor(153, 153, 255);
    			sheetObj.CellBackColor(i, "rf_20_qty") = sheetObj.RgbColor(204, 153, 255);
    			sheetObj.CellBackColor(i, "rf_40_qty") = sheetObj.RgbColor(204, 153, 255);
    			sheetObj.CellBackColor(i, "rf_rdr_qty") = sheetObj.RgbColor(255, 255, 153);
    			sheetObj.CellBackColor(i, "mt_teu") = sheetObj.RgbColor(153, 255, 153);    			
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