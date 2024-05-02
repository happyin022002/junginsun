/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0057.js
*@FileTitle : TDR Download by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.09.17 장강철
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.12.07 김상수 [CHM-201007318-01] JOO - TDR Inquiry 기능 보완 요청 - i-stowage 연계
*                    1. 조회조건에 Carrier Code를 Multi Select 할 수 있는 멀티콤보 추가
*                    2. Sheet에 컬럼 추가
*                      (※ Data 조회 Logic 보완)
*                      - 기존처럼  해당 VVD 와 Port를 선정할때  Upload Status가  N (증빙 가)일 경우
*                         해당 정보(20’, 40’, 20HC, 40HC, 45, AK, RF, EMPTY)를 I-Stowage에서 조회
*                      - Source 컬럼 추가
*                         OPF : OPF 모듈에서  Data 조회
*                         IST : I-Stowage에서 Data 조회
* 2011.02.08 이병훈 [CHM-201108610-01] JOO/TDR 보완 요청 - I-Stowage 전면 연계
* 2012.05.11 김창헌 [CHM-201217413-01]
*                  [ALPS JOO] TDR Inquiry by VVD 및 RDR Inquiry by Lane
*                   - Sum 기능 추가, 정렬순서 및 표시형식 변경
* 2013.02.21 이수진 [CHM-201323213] [JO] TDR Inquiry by VVD - 45f additional 칼럼 로직 추가요청
*                                  - Additional 45'(U), 45'(O) 항목 계산 로직 수정으로 최종 계산된 값을 Round 처리하여 결과값이 (-)인 경우에는 0 값으로 표시되도록 수정
* 2013.11.05 이수진  [CHM-201327425] R/F 로직 변경 - DG 20'/40' 추가        
* 2014.09.11 민정호  [CHM-201431612]BSA Information Entry & TDR Inquiry by VVD 연동                                           
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
     * @class FNS_JOO_0057 : FNS_JOO_0057 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function FNS_JOO_0057() {
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

                 case "btn_downexcel":
                      //sheetObject1.Down2Excel();
                      var paramObj = new Object();
                      paramObj.cols = 10;
                      var url = ComJooGetPgmTitle(sheetObjects[0], paramObj);
					  sheetObjects[2].Down2Excel(-1);
					  sheetObjects[0].Down2Excel(-1, true, false, true);
//					  sheetObjects[0].Down2Excel(-1, true, false, true, "", url);
                      break;

                 case "btn_ratio":
					  var vvd = formObject.vvd.value;
					  var slaneCd = formObject.rlane_cd.value;
					  var skdDirCd = formObject.skd_dir_cd.Code;
					  var preFr = formObject.pre_fr.value;
					  var preTo = formObject.pre_to.value;
					  var oprCd = formObject.opr_cd.value;
					  
					  if (preFr.length < 10){
						  ComShowCodeMessage("JOO00019", "Period");
						  formObject.pre_fr.focus();
						  return;
					  }

					  if (preTo.length < 10){
						  ComShowCodeMessage("JOO00019", "Period");
						  formObject.pre_to.focus();
						  return;
					  }

					  if (slaneCd.length < 3){
						  ComShowCodeMessage("JOO00019", "Lane");
						  formObject.rlane_cd.focus();
						  return;
					  }

					  var paramUrl = "pgmNo=FNS_JOO_0090&slane_cd="+slaneCd+"&pre_fr="+preFr+"&pre_to="+preTo+"&vvd="+vvd+"&skd_dir_cd="+skdDirCd+"&opr_cd="+oprCd;
  					  ComOpenPopup("/hanjin/FNS_JOO_0090.do?"+paramUrl, 835, 400,"getFNS_JOO_0090_1", "1,0,1,1,1,1,1,1"); //, true, false, 0, 0, 0, "pop1");
                      break;

                 case "btns_calendar_from": //달력버튼
                     var cal = new ComCalendar();
                     cal.select(formObject.pre_fr, 'yyyy-MM-dd');
                     break;

                case "btns_calendar_to": //달력버튼
                     var cal = new ComCalendar();
                     cal.select(formObject.pre_to, 'yyyy-MM-dd');
                     break;

        		case "sum_flg": //Sum 체크
        			if (formObject.sum_flg.checked){
        				formObject.sum_flg.value = "Y";
        			}else{
        				formObject.sum_flg.value = "N";
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

          axon_event.addListener      ('click',   'fnDocClick', "btn_pre_from_back"       );
          axon_event.addListener      ('click',   'fnDocClick', "btn_pre_from_next"       );
          axon_event.addListener      ('click',   'fnDocClick', "btn_pre_to_back"       );
          axon_event.addListener      ('click',   'fnDocClick', "btn_pre_to_next"       );
          axon_event.addListener      ('click',   'fnDocClick', "srch_rlane_cd"             );

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

//					 var rule_addu_ttl_45 = "IF(|jo_45ft_n1st_rto|=2, IF(|jo_45ft_n2nd_rto|=2, 0, IF((|hc_ld_45|+|hc_bsa_45|)<=|jo_45ft_sub_teu_qty|, IF(|jo_rnd_rule_lvl|=1, Round((|hc_ld_45|+|hc_bsa_45|)*(|jo_45ft_n1st_rto|-2),0), IF(|jo_rnd_rule_lvl|=2, Ceiling((|hc_ld_45|+|hc_bsa_45|)*(|jo_45ft_n1st_rto|-2)), IF(|jo_rnd_rule_lvl|=3, Int((|hc_ld_45|+|hc_bsa_45|)*(|jo_45ft_n1st_rto|-2)), (|hc_ld_45|+|hc_bsa_45|)*(|jo_45ft_n1st_rto|-2)))), IF(|jo_rnd_rule_lvl|=1, Round(|jo_45ft_sub_teu_qty|*(|jo_45ft_n1st_rto|-2),0), IF(|jo_rnd_rule_lvl|=2, Ceiling(|jo_45ft_sub_teu_qty|*(|jo_45ft_n1st_rto|-2)), IF(|jo_rnd_rule_lvl|=3, Int(|jo_45ft_sub_teu_qty|*(|jo_45ft_n1st_rto|-2)), |jo_45ft_sub_teu_qty|*(|jo_45ft_n1st_rto|-2)))))), IF((|hc_ld_45|+|hc_bsa_45|)<=|jo_45ft_sub_teu_qty|, IF(|jo_rnd_rule_lvl|=1, Round((|hc_ld_45|+|hc_bsa_45|)*(|jo_45ft_n1st_rto|-2),0), IF(|jo_rnd_rule_lvl|=2, Ceiling((|hc_ld_45|+|hc_bsa_45|)*(|jo_45ft_n1st_rto|-2)), IF(|jo_rnd_rule_lvl|=3, Int((|hc_ld_45|+|hc_bsa_45|)*(|jo_45ft_n1st_rto|-2)), (|hc_ld_45|+|hc_bsa_45|)*(|jo_45ft_n1st_rto|-2)))), IF(|jo_rnd_rule_lvl|=1, Round(|jo_45ft_sub_teu_qty|*(|jo_45ft_n1st_rto|-2),0), IF(|jo_rnd_rule_lvl|=2, Ceiling(|jo_45ft_sub_teu_qty|*(|jo_45ft_n1st_rto|-2)), IF(|jo_rnd_rule_lvl|=3, Int(|jo_45ft_sub_teu_qty|*(|jo_45ft_n1st_rto|-2)), |jo_45ft_sub_teu_qty|*(|jo_45ft_n1st_rto|-2))))))";
//					 var rule_addo_ttl_45 = "IF(|jo_45ft_n1st_rto|=2, IF(|jo_45ft_n2nd_rto|=2, 0, IF((|hc_ld_45|+|hc_bsa_45|)<=|jo_45ft_sub_teu_qty|, 0, IF(|jo_rnd_rule_lvl|=1, Round(((|hc_ld_45|+|hc_bsa_45|)-|jo_45ft_sub_teu_qty|)*(|jo_45ft_n2nd_rto|-2),0), IF(|jo_rnd_rule_lvl|=2, Ceiling(((|hc_ld_45|+|hc_bsa_45|)-|jo_45ft_sub_teu_qty|)*(|jo_45ft_n2nd_rto|-2)), IF(|jo_rnd_rule_lvl|=3, Int(((|hc_ld_45|+|hc_bsa_45|)-|jo_45ft_sub_teu_qty|)*(|jo_45ft_n2nd_rto|-2)), ((|hc_ld_45|+|hc_bsa_45|)-|jo_45ft_sub_teu_qty|)*(|jo_45ft_n2nd_rto|-2)))))), IF((|hc_ld_45|+|hc_bsa_45|)<=|jo_45ft_sub_teu_qty|, 0, IF(|jo_rnd_rule_lvl|=1, Round(((|hc_ld_45|+|hc_bsa_45|)-|jo_45ft_sub_teu_qty|)*(|jo_45ft_n2nd_rto|-2),0), IF(|jo_rnd_rule_lvl|=2, Ceiling(((|hc_ld_45|+|hc_bsa_45|)-|jo_45ft_sub_teu_qty|)*(|jo_45ft_n2nd_rto|-2)), IF(|jo_rnd_rule_lvl|=3, Int(((|hc_ld_45|+|hc_bsa_45|)-|jo_45ft_sub_teu_qty|)*(|jo_45ft_n2nd_rto|-2)), ((|hc_ld_45|+|hc_bsa_45|)-|jo_45ft_sub_teu_qty|)*(|jo_45ft_n2nd_rto|-2))))))";
					 					 
					 var rule_addu_ttl_45 = "IF(|jo_45ft_n1st_rto|=2, IF(  |jo_45ft_n2nd_rto|=2, 0, IF( (|hc_ld_45|+|hc_bsa_45|)<=|jo_45ft_sub_teu_qty|, IF((|hc_ld_45|+|hc_bsa_45|)*(|jo_45ft_n1st_rto|-2)<0, 0, ROUND((|hc_ld_45|+|hc_bsa_45|)*(|jo_45ft_n1st_rto|-2),0)) , IF(|jo_45ft_sub_teu_qty|*(|jo_45ft_n1st_rto|-2)<0,0,ROUND(|jo_45ft_sub_teu_qty|*(|jo_45ft_n1st_rto|-2),0)))), IF( (|hc_ld_45|+|hc_bsa_45|)<=|jo_45ft_sub_teu_qty|, IF((|hc_ld_45|+|hc_bsa_45|)*(|jo_45ft_n1st_rto|-2)<0,0,ROUND((|hc_ld_45|+|hc_bsa_45|)*(|jo_45ft_n1st_rto|-2),0)), IF(|jo_45ft_sub_teu_qty|*(|jo_45ft_n1st_rto|-2)<0,0,ROUND(|jo_45ft_sub_teu_qty|*(|jo_45ft_n1st_rto|-2),0))))";
					 var rule_addo_ttl_45 = "IF(|jo_45ft_n1st_rto|=2, IF(|jo_45ft_n2nd_rto|=2, 0, IF((|hc_ld_45|+|hc_bsa_45|)<=|jo_45ft_sub_teu_qty|, 0, IF(((|hc_ld_45|+|hc_bsa_45|)-|jo_45ft_sub_teu_qty|)*(|jo_45ft_n2nd_rto|-2)<0,0,ROUND(((|hc_ld_45|+|hc_bsa_45|)-|jo_45ft_sub_teu_qty|)*(|jo_45ft_n2nd_rto|-2),0) ))), IF((|hc_ld_45|+|hc_bsa_45|)<=|jo_45ft_sub_teu_qty|, 0, IF(((|hc_ld_45|+|hc_bsa_45|)-|jo_45ft_sub_teu_qty|)*(|jo_45ft_n2nd_rto|-2)<0,0,ROUND(((|hc_ld_45|+|hc_bsa_45|)-|jo_45ft_sub_teu_qty|)*(|jo_45ft_n2nd_rto|-2),0))))";
					 
					 var rule_grand_ttl_slot = "|full_20|+|mt_20|+((|full_40|+|mt_40|)*2)+|hc_ld_20|+|hc_bsa_20|+((|hc_ld_40|+|hc_bsa_40|)*2)+((|hc_ld_45|+|hc_bsa_45|)*2)+(" + rule_add_ttl_20 + ")+(" + rule_add_ttl_40 + ")+(" + rule_addu_ttl_45 + ")+(" + rule_addo_ttl_45 +")+|ak_void|";

					 var rule_add_hc_20 = "IF(|jo_20ft_n1st_rto|=1, 0, IF(|ttl_hc_20|-|jo_20ft_sub_teu_qty|<0, 0, |ttl_hc_20|-|jo_20ft_sub_teu_qty|))";
					 var rule_add_hc_40 = "IF(|jo_40ft_n1st_rto|=2, 0, IF(|ttl_hc_40|-|jo_40ft_sub_teu_qty|<0, 0, |ttl_hc_40|-|jo_40ft_sub_teu_qty|))";
					 var rule_addu_hc_45 = "IF(|jo_45ft_n1st_rto|=2, IF(|jo_45ft_n2nd_rto|=2, 0, IF(|ttl_hc_45|<=|jo_45ft_sub_teu_qty|, |ttl_hc_45|, |jo_45ft_sub_teu_qty|)), IF(|ttl_hc_45|<=|jo_45ft_sub_teu_qty|, |ttl_hc_45|, |jo_45ft_sub_teu_qty|))";
					 var rule_addo_hc_45 = "IF(|jo_45ft_n1st_rto|=2, IF(|jo_45ft_n2nd_rto|=2, 0, IF(|ttl_hc_45|<=|jo_45ft_sub_teu_qty|, 0, |ttl_hc_45|-|jo_45ft_sub_teu_qty|)), IF(|ttl_hc_45|<=|jo_45ft_sub_teu_qty|, 0, |ttl_hc_45|-|jo_45ft_sub_teu_qty|))";
					 
					 var rule_over_slot_c = "IF((|grand_ttl_slot|-|all_teu|) < 0, 0, |grand_ttl_slot|-|all_teu|)";
					 var rule_over_wgt_c = "IF((|grand_ttl_wgt|-|all_wgt|) < 0, 0, |grand_ttl_wgt|-|all_wgt|)";
                     // 높이 설정
                     style.height = 430;

                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     // 전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge + msHeaderOnly;//msAll;

                     // 전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 3, 100);

                     var HeadTitle2 = "VVD|Port|ETD|Carrier|Trade|SUB_CHK|cal|Allocation|Allocation|Total Used|Total Used|Over Used|Over Used|20'|20'|20'|40'|40'|40'|40'|20'HC|20'HC|20'HC|20'HC|40'HC|40'HC|40'HC|40'HC|40'HC|45'|45'|45'|45'|45'|45'|Additional|Additional|Additional|Additional|AK|AK|DG|DG|RF|RF|EMPTY|EMPTY|Source|20'HC|20'HC|40'HC|40'HC|45'|45'|45'|ROUND RULE";
                     var HeadTitle3 = "VVD|Port|ETD|Carrier|Trade|SUB_CHK|cal|TEU|WT|TEU|WT|TEU|WT|Full|Empty|TTL|Full|Empty|TTL|TTL(TEU)|Full|Empty|TTL|ADD|Full|Empty|TTL|TTL(TEU)|ADD|Full|Empty|TTL|TTL(TEU)|ADD(U)|ADD(O)|20'HC|40'HC|45'(U)|45'(O)|UNIT|VOID|20'|40'|20'|40'|TEU|WEIGHT|Source|Sub-Allo|Ratio|Sub-Allo|Ratio|Sub-Allo|Ratio 1|Ratio 2|ROUND RULE";
                     var headCount = ComCountHeadTitle(HeadTitle2);

                     // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 3, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

                     InitHeadRow(0, HeadTitle2, true);
                     InitHeadRow(1, HeadTitle3, true);

                     // 데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,       COLMERGE,   SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     //InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,    true,     "Status");

                     InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    true,     "vvd",            false,    "",    dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         60,     daCenter,    true,     "vps_port_cd",    false,    "",    dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         110,    daCenter,    true,     "vps_etd_dt",     false,    "",    dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         50,     daCenter,    true,     "opr_cd",         false,    "",    dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         50,     daCenter,    true,     "trd_cd",         false,    "",    dfNone, 0, false, false);                     
                     
					 InitDataProperty(0, cnt++ , dtHidden,       30,     daCenter,    true,     "sub_chk",        false,    "",    dfNumber, 0, false, false);
					 InitDataProperty(0, cnt++ , dtHidden,         60,     daRight,     false,    "all_wgt_c",      false,    "IF(|sub_chk|=2, |all_teu|*|all_wgt|, |all_wgt|)", dfNumber, 0, true, false);
					 InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "all_teu",        false,    "",    dfNumber, 0, true, false);
					 InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "all_wgt",        false,    "", dfNumber, 0, true, false);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "grand_ttl_slot", false,    rule_grand_ttl_slot, dfNumber, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "grand_ttl_wgt",  false,    "",    dfNumber, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "over_slot_c",    false,    rule_over_slot_c,    dfNumber, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "over_wgt_c",     false,    rule_over_wgt_c,     dfNumber, 0, false, false);

                     InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "full_20",        false,    "",    dfNumber, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "mt_20",          false,    "",    dfNumber, 0, false, false);
					 InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "ttl_20",         false,    "|full_20|+|mt_20|",    dfNumber, 0, false, false); //20120615

                     InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "full_40",        false,    "",    dfNumber, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "mt_40",          false,    "",    dfNumber, 0, false, false);
					 InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "ttl_40",         false,    "|full_40|+|mt_40|",    dfNumber, 0, false, false); //20120615
					 InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "ttl_20_40",      false,    "|ttl_40|*2",    dfNumber, 0, false, false); //20120615

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "hc_ld_20",       false,    "",    dfNumber, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "hc_bsa_20",      false,    "",    dfNumber, 0, false, false);
					 InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "ttl_hc_20",      false,    "|hc_ld_20|+|hc_bsa_20|",    dfNumber, 0, false, false); //20120615
					 InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "add_hc_20",      false,    rule_add_hc_20, dfNumber, 0, false, false); //20120615

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "hc_ld_40",       false,    "",    dfNumber, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "hc_bsa_40",      false,    "",    dfNumber, 0, false, false);
					 InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "ttl_hc_40",      false,    "|hc_ld_40|+|hc_bsa_40|",    dfNumber, 0, false, false); //20120615
					 InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "ttl_hc_20_40",   false,    "(|hc_ld_40|+|hc_bsa_40|)*2",    dfNumber, 0, false, false); //20120615
					 InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "add_hc_40",      false,    rule_add_hc_40, dfNumber, 0, false, false); //20120615

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

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "mt_teu",         false,    "",    dfNumber, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "mt_wt",          false,    "",    dfNumber, 0, false, false);

                     InitDataProperty(0, cnt++ , dtData,         60,     daCenter,     true,    "source",         false,    "",    dfNone, 0, false, false);
					 
					 //2012.06.19추가
					 InitDataProperty(0, cnt++ , dtHidden,	80,	daRight,	false,  "jo_20ft_sub_teu_qty",  false, "", dfInteger, 2,  true, true, 9);
					 InitDataProperty(0, cnt++ , dtHidden,	80,	daRight,	false,  "jo_20ft_n1st_rto",  	false, "", dfFloat, 2,  true, true, 5);
					 InitDataProperty(0, cnt++ , dtHidden,	80, daRight,	false,  "jo_40ft_sub_teu_qty",  false, "", dfInteger, 2,  true, true, 9);
					 InitDataProperty(0, cnt++ , dtHidden,	80,	daRight,	false,  "jo_40ft_n1st_rto",     false, "", dfFloat, 2,  true, true, 5);
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
					InitDataProperty(0, cnt++ , dtData,		80, daCenter,	true,  "jo_crr_cd", 			false, "", dfNone, 2,  false,  false);
					InitDataProperty(0, cnt++ , dtData,		80,	daRight,	false,  "jo_20ft_sub_teu_qty",  false, "", dfInteger, 2,  true, true, 9);
					InitDataProperty(0, cnt++ , dtData,		80,	daRight,	false,  "jo_20ft_n1st_rto",  	false, "", dfFloat, 2,  true, true, 5);
					InitDataProperty(0, cnt++ , dtData,		80, daRight,	false,  "jo_40ft_sub_teu_qty",  false, "", dfInteger, 2,  true, true, 9);
					InitDataProperty(0, cnt++ , dtData,		80,	daRight,	false,  "jo_40ft_n1st_rto",     false, "", dfFloat, 2,  true, true, 5);
					InitDataProperty(0, cnt++ , dtData,		80, daRight,	false,  "jo_45ft_sub_teu_qty", 	false, "", dfInteger, 2,  true, true, 9);
					InitDataProperty(0, cnt++ , dtData,		80, daRight,	false,  "jo_45ft_n1st_rto", 	false, "", dfFloat, 2,  true, true, 5);
					InitDataProperty(0, cnt++ , dtData,		80, daRight,	false,  "jo_45ft_n2nd_rto", 	false, "", dfFloat, 2,  true, true, 5);
					InitDataProperty(0, cnt++ , dtCombo,	80, daCenter,	true,  "jo_rnd_rule_lvl", 		false, "", dfNone, 2,  true, true);
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
				
				//Merge 체크되어있는 경우
				if (formObj.sum_flg.checked){
					formObj.f_cmd.value = SEARCH03;
					
                    var xmlStr = sheetObj.GetSearchXml("FNS_JOO_0057GS.do", "f_cmd=" + SEARCH03 
					+ "&pre_to=" + formObj.pre_to.value
					+ "&pre_fr=" + formObj.pre_fr.value
					+ "&rlane_cd=" + formObj.rlane_cd.value
					+ "&opr_cd=" + formObj.opr_cd.value);
					
					//alert(ComGetEtcData(xmlStr, "carrier_cnt"));
					
					if (ComGetEtcData(xmlStr, "carrier_cnt") != "1") {
						ComShowCodeMessage("JOO00195");	//"You should select one rep. carrier in ‘Sub Allocation and Ratio’."
						return;
					}
				}
				
                formObj.f_cmd.value = SEARCHLIST01;
                sheetObj.DoSearch("FNS_JOO_0057GS.do", FormQueryString(formObj));
                break;

            case IBCLEAR:      //
                var param = "";
                var sXml = "";

                var code   =  "CD00593";
                formObj.f_cmd.value = SEARCH01;
                param = FormQueryString(formObj)+"&super_cd1="+code;
                sXml  = sheetObj.GetSearchXml("FNS_JOO_0057GS.do", param);
                //ComXml2ComboItem(sXml, formObj.skd_dir_cd, "code", "name");

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

//                formObj.f_cmd.value = SEARCHLIST03;
//                param = FormQueryString(formObj);
//                sXml = sheetObj.GetSearchXml("JOOCommonGS.do", param);
//                var comboCodeList = ComGetEtcData(sXml, "comboCode").split("^#^");
//                var comboTextList = ComGetEtcData(sXml, "comboText").split("^#^");
//                formObj.oprCdCombo.RemoveAll();
//                formObj.oprCdCombo.InsertItem(-1, "[ALL]", "");
//                for (var w=0; w<comboCodeList.length-1; w++) {
//                    formObj.oprCdCombo.InsertItem(-1, comboTextList[w], comboCodeList[w]);
//                }
//                formObj.oprCdCombo.Index2 = 0;
                break;

            case IBSEARCH_ASYNC01:      //
                var code            =  formObj.rlane_cd.value;
                formObj.f_cmd.value = SEARCH07;
                var param           =  FormQueryString(formObj)+"&code="+code;
                var sXml            =  sheetObj.GetSearchXml("JOOCommonGS.do", param);
                var sTotal          =  ComGetTotalRows(sXml);
                if (sTotal == "0") {
                    ComShowCodeMessage("JOO00110");
                    formObj.rlane_cd.value = '';
                    formObj.rlane_cd.focus();
                    //fnDeactivate 덕분에...아래와 같이 코딩함
                } else {
                    formObj.rlane_cd.value = code;
                    formObj.skd_dir_cd.focus();
                }
                break;

			case IBSEARCH_ASYNC02:      //조회
				formObj.f_cmd.value = SEARCH01;
				formObj.slane_cd.value = formObj.rlane_cd.value;
				sheetObj.DoSearch("FNS_JOO_0090GS.do", FormQueryString(formObj));
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
			break;
		case "pre_to":
	    	oprCdCombo_clear();
			break;
		case "rlane_cd":
	    	oprCdCombo_clear();
			break;
		}
	}
    
    //Period, Lane 변경시 Carrier 초기화
    function oprCdCombo_clear(){
//    	comboObjects[1].Index2 = -1;
//    	comboObjects[1].RemoveAll();
    	document.form.oprCdCombo.Index2 = -1;
    	document.form.oprCdCombo.RemoveAll();
    	document.form.opr_cd.value = "";

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
    				var sXml = sheetObj.GetSearchXml("FNS_JOO_0057GS.do", FormQueryString(formObj));
    				
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

            // 다른Index가 선택된 경우는 Index 0을 해제
            } else {
                comboObj.CheckIndex(0) = false;
                // Submit할 내용 Define
                formObject.opr_cd.value = ("'" + ComReplaceStr(comboObj.Code, ",", "', '") + "'");
            }
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
//                    case 'rlane_cd':
//                        if( obj.value == ""){return;}
//                        if( !ComChkObjValid(obj  )){
//                             ComSetFocus(obj);
//                             return;
//                        }
//                        break;
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
        *
        * <pre>
        *    Form Clear 처리
        * </pre>
        *
        * @param
        * @return
        * @author jang kang cheol
        */
       function fnFormClear(){
           var formObj = document.form;
           ComClearObject(formObj.rlane_cd  );
           formObj.skd_dir_cd.Code = "";
           if( sheetObjects[0].RowCount > 0) {
               sheetObjects[0].RemoveAll();
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
                     var maxlength = obj.getAttribute("maxlength");
                     if( obj.value.length != maxlength   ){
                         return;
                     }else{
                         doActionIBSheet( sheetObjects[0], formObj, IBSEARCH_ASYNC01);
                     }
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
		if (ErrMsg == "") {            		
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC02);
		}
     }

	 function getFNS_JOO_0090_1() {
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	 }
	/* 개발자 작업  끝 */