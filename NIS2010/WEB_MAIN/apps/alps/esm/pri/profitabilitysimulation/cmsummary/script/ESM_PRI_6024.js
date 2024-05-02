/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6024.js
*@FileTitle : CM/OP Summary & Simulation- Contract Proposal
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.13 송민석
* 1.0 Creation
========================================================
* History 
* 2012.08.16 송호진 [CHM-201219512-01] Split 02-조직도 변경에 따른 S/C & RFA DATA 업데이트 요청 
*                  SELCGM -> SELCAM, HAMUKG, NYCNKG, SINWKG 권한 유지 적용 
* 2012.09.18 송호진 [CHM-201220261-01] S/C Approval office 목록 수정 요청
*                  HAMUKG, NYCNKG, SINWKG 권한 부여 제외
* 2013.06.14 송호진 [CHM-201325245] 조직코드 변경 및 병행 관리 관련 기존 코드에 신규 코드 추가. 6 월 말 기존 코드 삭제 예정 ( CAM -> CCM, CTA -> CCA, CTE,CTI -> CCE, COS -> CCS, CGS -> CCB )
* 2013.06.27 송호진 [CHM-201325462] 본사 조직 변경에 따른 PRICING MODULE 내에 기존 조직코드 삭제 요청 - CHM-201325245 변경시 남겨놓은 기존 코드 삭제 
* 2015.08.13 [CHM-201537109] Split19-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
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
     * @class ESM_PRI_6024 : ESM_PRI_6024 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6024() {
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

 var UNIT_TEXT = new Array();
 UNIT_TEXT["FEU"] = "[Unit: FEU/USD]";
 UNIT_TEXT["TEU"] = "[Unit: TEU/USD]";

 var SHEET_TITLE = new Array();
 SHEET_TITLE["C"] = "CM Summary";
 SHEET_TITLE["O"] = "OP Summary";
 
 // 공통전역변수

 var sheetObjects = new Array();
 var sheetCnt = 0;
 
 var BACKEND_JOB_ID  = "";
 var TIMER_ID = "";
 var ARRAY_BACKENDJOB_TYPE = new Array();

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
 				case "btn1_Retrieve":
 					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
                     break; 
 				case "btn1_New":
 					 resetAllObjects();
                     break; 
 				case "btn1_Revenue_Detail":
 					 doActionIBSheet(sheetObject1,document.form,IBSEARCH_ASYNC03);
                     break; 
 				case "btn1_Simulation":
 					 doActionIBSheet(sheetObject1,document.form,IBSEARCH_ASYNC02);
                     break; 
 				case "btn1_Chart":
					 doActionIBSheet(sheetObject1,document.form,IBSEARCH_ASYNC04);
                     break; 
 				case "btn1_Down_Excel":
 					var msgStr = ComGetMsg("PRI03002");
 			    	if(sheetObject1.RowCount == 0 )
 			    		return;
 			    	//vb script를 이용해서 버튼이 3개인 excel download 창을 띄운다.
 			     	execScript("rtn = Msgbox(\"" + ComReplaceStr(msgStr,"\n","\" & Chr(13) & \"") + "\", 3, \"Download Excel\")", "vbscript");
 			     	
 			     	// download excel에서 Quick Mode를 선택 했을때
 			    	if (rtn == 6) {
 			    		ComOpenWait(true);
 			    		// excel에서 추가로 보여줘야 할 컬럼들을 노출 시킨다.
 			    		showColumns(sheetObject1,"cust_tp_cd|prop_apro_ofc_cd|respb_srep_cd|ctrt_eff_dt|ctrt_exp_dt");
 			    		// simulation 후 download excel 이라면 sheet의 내용을 다르게 download한다.
 			    		if( formObject.is_simulation.value == "Y"){
 			    			// sheet가 2개가 되는데 1번 sheet는 Before로 simulation 전 sheet이다.
	 			    		sheetObject2.SpeedDown2Excel(-1, false, false,"","",false,false,getSheetNameOfExcel("BEFORE"));
	 			    		// sheet가 2개가 되는데 2번 sheet는 After로 simulation 후 sheet이다.
	 			    		sheetObject1.SpeedDown2Excel(-1, true, true,"","",false,false,getSheetNameOfExcel("AFTER"));
	 			    		var isNewSheet = true;
	 			    		for(var idx=0 ; idx < 5 ; idx++){
	 			    			if( sheetObjects[2+idx].RowCount != 0 ){
	 			    				//simulation한 내용들을 다른 sheet에 추가한다.
	 			    				sheetObjects[2+idx].SpeedDown2Excel(-1, true, isNewSheet,"","",false,false,"Simulation Data");
	 			    				isNewSheet = false;
	 			    			}
	 			    		}	 			    		
 			    		}else{
 			    			sheetObject1.SpeedDown2Excel(-1, false, false,"","",false,false,getSheetNameOfExcel(""));
 			    		}
 			    		// excel에서 추가로 보여주었던 컬럼들을 다시 숨긴다.
 			    		hideColumns(sheetObject1,"cust_tp_cd|prop_apro_ofc_cd|respb_srep_cd|ctrt_eff_dt|ctrt_exp_dt");
 			    		ComOpenWait(false);
 			    	// download excel에서 Standard Mode를 선택 했을때
 			    	} else if (rtn == 7) {
 			    		ComOpenWait(true);
 			    		showColumns(sheetObject1, "cust_tp_cd|prop_apro_ofc_cd|respb_srep_cd|ctrt_eff_dt|ctrt_exp_dt" );
 			    		// simulation 후 download excel 이라면 sheet의 내용을 다르게 download한다.
 			    		if( formObject.is_simulation.value == "Y"){
 			    			// sheet가 2개가 되는데 1번 sheet는 Before로 simulation 전 sheet이다.
	 			    		sheetObject2.Down2Excel(-1, false, false,true,"","",false,false,getSheetNameOfExcel("BEFORE"));
	 			    		// sheet가 2개가 되는데 2번 sheet는 After로 simulation 후 sheet이다.
	 			    		sheetObject1.Down2Excel(-1, true, true,true,"","",false,false,getSheetNameOfExcel("AFTER"));
	 			    		var isNewSheet = true;
	 			    		for(var idx=0 ; idx < 5 ; idx++){
	 			    			if( sheetObjects[2+idx].RowCount != 0 ){
	 			    				//simulation한 내용들을 다른 sheet에 추가한다.
	 			    				sheetObjects[2+idx].Down2Excel(-1, true, isNewSheet,true,"","",false,false,"Simulation input data");
	 			    				isNewSheet = false;
	 			    			}
	 			    		}
 			    		}else{
 			    			sheetObject1.Down2Excel(-1, false, false,true,"","",false,false,getSheetNameOfExcel(""));
 			    		}
 			    		hideColumns(sheetObject1,"cust_tp_cd|prop_apro_ofc_cd|respb_srep_cd|ctrt_eff_dt|ctrt_exp_dt");
 			    		ComOpenWait(false);
 			    	} 	
                     break; 
				case "btns_calendar1": //달력버튼
	            	var cal = ComCalendar();
	            	cal.select(formObject.frm_ctrt_eff_dt, 'yyyy-MM-dd');
	            	break;
                case "btns_calendar2":
                	var cal = ComCalendar();
                	cal.select(formObject.frm_ctrt_exp_dt, 'yyyy-MM-dd');
                    break;      
                case "btn_customer":
                	doActionIBSheet(sheetObject1,document.form,IBSEARCH_ASYNC01);
                	break;     
                case "btn_origin":
                	doActionIBSheet(sheetObject1,document.form,IBSEARCH_ASYNC05);
                	break;   
                case "btn_dest":
                	doActionIBSheet(sheetObject1,document.form,IBSEARCH_ASYNC06);
                	break;       
                case "btn_slane":
                	doActionIBSheet(sheetObject1,document.form,IBSEARCH_ASYNC07);
                	break;                   	
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e);
     		}
     		ComOpenWait(false);
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
    	  var formObj = document.form;
          for(i=0;i<sheetObjects.length;i++){
  			//khlee-시작 환경 설정 함수 이름 변경
              ComConfigSheet (sheetObjects[i] );
              initSheet(sheetObjects[i],i+1);
  			//khlee-마지막 환경 설정 함수 추가
              ComEndConfigSheet(sheetObjects[i]);
          }
          //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
          
          hideColumns(sheetObjects[0],"cust_tp_cd|svc_scp_cd|prop_apro_ofc_cd|respb_srep_cd|ctrt_eff_dt|ctrt_exp_dt");
          // event들의 등록
          initControl();
          // 초기 combo data를 세팅하고, properties 설정  
          initCombo();
          // 화면의 모든 값을 초기 default 값으로 바꾼다.
          resetAllObjects();
          // Profit View, Profit level의 값에 따라 sheet의 보여지는 column을 다르게 숨기거나 보여준다.
          changeColHidden(formObj.frm_summary_items,sheetObjects[0]);
          // Profit View, Profit level의 값에 따라 sheet의 보여지는 column을 다르게 숨기거나 보여준다.
          changeColHidden(formObj.frm_summary_items,sheetObjects[1]);
          // 조회 상태에 따라 버튼의 활성화/비활성화
          changeButtonStatus();
          // sheet오른쪽위의 Unit 관련 Text를 PFMC Unit 선택에 따라 TEU/FEU로 변경한다. 
  		  changeUnitText(ComPriGetCheckedRadioButtonValue(formObj.frm_pfmc_unit)) ;
  		  // 로긴 권한에 따라 버튼 제어와 request office code input box를 제어 한다.
  		  checkAuthRequestOffice();
  		  
          
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
          //Axon 이벤트 처리1. 이벤트catch(개발자변경)            
	    axon_event.addListener('change', 'frm_prop_ofc_cd_OnChange', 'frm_prop_ofc_cd');
          
	    axon_event.addListener('change', 'frm_ori_rout_cd_OnChange', 'frm_ori_rout_cd');
	    axon_event.addListener('change', 'frm_dest_rout_cd_OnChange', 'frm_dest_rout_cd');
	    
	    axon_event.addListener('click', 'frm_pfmc_unit_OnClick', 'frm_pfmc_unit');
        axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);               
  
	    axon_event.addListener('mouseover', 'frm_cust_nm_OnMouseOver', 'frm_cust_nm');  
        axon_event.addListener('mouseout', 'frm_cust_nm_OnMouseOut', 'frm_cust_nm');
        
        axon_event.addListener('blur', 'frm_ctrt_eff_dt_OnBlur', 'frm_ctrt_eff_dt');  
	    axon_event.addListener('blur', 'frm_ctrt_exp_dt_OnBlur', 'frm_ctrt_exp_dt');  
	    axon_event.addListener ('keydown', 'myKeyEnter', 'form');
	    
   }    
   /** 
    * document에서 Enter를 입력했을때 호출 된다.
    * 
    *
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @return 없음
    */          
   function myKeyEnter(){
	   
	   var name = event.srcElement.getAttribute("name");
	   //Origin, Dest.에서 Enter를 눌렀을 경우 origin, dest.관련 조회를 해야 하기 때문에 
	   //메인 화면 조회를 못하도록 한다.
	   if( name == "frm_ori_rout_cd" ||  name == "frm_dest_rout_cd"  ){
		   return;
	   }
	   ComKeyEnter();
   }
    var oPopup = null;
    
    /** 
     * frm_cust_nm 의 Mouse Over Event 시 호출 <BR>
     * customer list를 Tool tip 형태로 보여준다.
     *
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * 
     * @param {object} e, Evnet Object
     * @return 없음
     */         
    function frm_cust_nm_OnMouseOver(e){
    	var parentObj = document.getElementById("frm_cust_nm");
    	if( document.form.frm_cust_list.value != "" ){
    		openDynamicPopup(0,parentObj.clientHeight+3,parentObj);
    	}
    }
    
    /** 
    * frm_cust_nm 의 Mouse Out Event 시 호출 <BR>
    *  Tool tip 형태의 customer list를 감춘다.
    *
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @param {object} e, Evnet Object
    * @return 없음
    */         
    function frm_cust_nm_OnMouseOut(e){
    	if( oPopup != null){
    		oPopup.hide();
    	}
    }
    
    /** 
    * form에 모든 내용을 초기화 하고 default 선택을 한다.
    * 
    *
    * <br><b>Example :</b>
    * <pre>
    *         resetAllObjects();
    * </pre>
    *
    * @return 없음
    */         
    function resetAllObjects(){
    	var formObj = document.form;
    	formObj.reset();
    	formObj.frm_status.Index2="0";
		formObj.frm_profit_view.Index2=1;
		formObj.frm_profit_level.Index2="0";
		formObj.frm_summary_items.Index2="0";
		formObj.frm_svc_scp_cd.Index2=-1;
		formObj.frm_prop_apro_ofc_cd.Index2="0";
		formObj.frm_prop_srep_cd.Index2="0";
		formObj.frm_customer_type.Index2="0";
    	
    }
    
    /**  
     * 화면에 추가 정보를 보여주기 위해 DIV로 만들어진<BR>
     * popup을 화면에 띄워준다.
     *  
     * <br><b>Example :</b>
     * <pre>
     *      openDynamicPopup(0,parentObj.clientHeight+3,parentObj);
     * </pre>
     * 
     * @param {int} x 필수, parentObj로 부터 표시하고자 하는 x 좌표 offset
     * @param {int} y 필수, parentObj로 부터 표시하고자 하는 y 좌표 offset
     * @param {object} parentObj 필수, popup이 표시될 기준 위치가 되는 Object
     * @return 없음
     */          
     function openDynamicPopup(x,y,parentObj){
         if( oPopup == null){
             oPopup = window.createPopup(); 
             var oPopBody = oPopup.document.body;
             oPopBody.style.backgroundColor = "lightyellow";
             oPopBody.style.border = "solid black 1px";
             oPopBody.style.padding= "2px"
              oPopBody.style.fontFamily="Tahoma,verdana,arial,dotum,gulim";
             oPopBody.style.fontSize="12px"
             	 
         }
         var innerHTML = makeCustomerHTML();
         oPopup.document.body.innerHTML = innerHTML;
         oPopup.show(x,y,325,0,parentObj);
        
         oPopup.show(x,y,325,getHeightForCustomerHtml(),parentObj);
         
 

         return oPopup;

     } 
     /**  
      * customer list를 표현하고 있는 table의 height를 구한다.
      *  
      * <br><b>Example :</b>
      * <pre>
      *      oPopup.show(x,y,325,getHeightForCustomerHtml(),parentObj);
      * </pre>
      * 
      * @return int, customer list를 보여줄 table의 height값
      */      
     function getHeightForCustomerHtml(){
    	 var tName = oPopup.document.getElementById("t_name");
    	 
    	 return tName.clientHeight+8;
     }
     /**  
     * div에서 사용할 customer list를 html로 만들어 return한다.
     *  
     * <br><b>Example :</b>
     * <pre>
     *      var innerHTML = makeCustomerHTML(); 
     *      oPopup.document.body.innerHTML = innerHTML;
     * </pre>
     * 
     * @return string, div에서 이용할 customer list를 html로 만든 string 
     */           
     function makeCustomerHTML(){
    	 var html = "";
    	 var formObj = document.form;
    	 var cdList = formObj.frm_cust_list.value;
    	 var nmList = formObj.frm_cust_nm.value;
 
    	 if( cdList != "" ){
    		 var cdArr = cdList.split(";");
    		 var nmArr = nmList.split(";");
    		 for(var i=0 ; i < cdArr.length ; i++ ){
    			 html += "<tr><TD style='padding:1px; font-family: Tahoma,verdana,arial,dotum,gulim; font-size: 12px; word-spacing:-0px;border:solid black 1px'>" + cdArr[i] +"</TD><TD style='padding:1px; font-family: Tahoma,verdana,arial,dotum,gulim; font-size: 12px; word-spacing:-0px;border:solid black 1px'>" + nmArr[i]  +"</TD></tr>" ;
    		 }
    		 html = "<table style='padding:0px;border-collapse: collapse; width:100%;border:solid black 1px' id='t_name'>" + html +"</table>";
    		 
    	 }
    	 return html;
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
              case "sheet1":      // sheet1 init
              case "sheet2":      // simulation 후 download excel을 할 경우 Before sheet에 해당하는 값으로 초기 조회 값을 저장해 둔다.
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 220;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly+msPrevColumnMerge  ;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 15, 100);

                     var HeadTitle1 = "||Sel.|Seq.|Contract|Contract/Approval Office|Request\nOffice|Request\nOffice|Sales Rep.|Proposal No.|Customer Type|Customer Name|MQC\n(Target MVC)|Eff. Date|Exp. Date|Load (Performance)|Load (Performance)|Load (Performance)|Gross Revenue|Gross Revenue|Gross Revenue|Cost|Cost|Cost|Cost|Cost|Cost|Cost|Cost|Cost|Week|Week|Week|CMPB|CMPB|CMPB|CMPB|CMPB|CMPB|CM|CM|CM|CM|CM|CM|OPB|OPB|OPB|OP|OP|OP|amdt_seq|data_tp_cd";
 					var HeadTitle2  = "||Sel.|Seq.|Contract|Contract/Approval Office|Request\nOffice|Request\nOffice|Sales Rep.|Proposal No.|Customer Type|Customer Name|MQC\n(Target MVC)|Eff. Date|Exp. Date|Previous|New|Diff(%)|Previous|New|Diff(%)|Previous|Previous|Previous|New|New|New|Diff(%)|Diff(%)|Diff(%)|Previous|New|Diff(%)|Previous|Previous|New|New|Diff(%)|Diff(%)|Previous|Previous|New|New|Diff(%)|Diff(%)|Previous|New|Diff(%)|Previous|New|Diff(%)|amdt_seq|data_tp_cd";
 					var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 13, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
 					InitHeadRow(1, HeadTitle2, true);
 
 					
                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
 					InitDataProperty(0, cnt++ , dtSeq,				40,   	daCenter,  	true,		"dummy_seq",   		false,          "",      dfNone,      		0,			false,       false);
 	               
 	                InitDataProperty(0, cnt++ , dtCheckBox,				40,   	daCenter,  	true,		"sel_chk",   		false,          "",      dfNone,      		0,			true,       true );
 					InitDataProperty(0, cnt++ , dtSeq,				40,   	daCenter,  	true,		"seq",   		false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtData,    			60,   	daCenter,  	true,		"contract_nm",   			false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtData,    		80,   	daLeft,  	true,		"prop_apro_ofc_cd",   			false,          "",      dfNone,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtData,    			60,   	daCenter,  	true,		"prop_ofc_cd",   			false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtHidden,    			60,   	daLeft,  	true,		"prop_ofc_nm",   			false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtData,    		80,   	daLeft,  	true,		"respb_srep_cd",   			false,          "",      dfNone,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtData,    			80,   	daCenter,  	true,		"prop_no",   			false,          "",      dfNone,      		0,			false,       false);
 					InitDataProperty(0, cnt++ , dtData,    		80,   	daLeft,  	true,		"cust_tp_cd",   			false,          "",      dfNone,      	2,			false,       false);

 					InitDataProperty(0, cnt++ , dtData,    			140,   	daLeft,  	true,		"cust_nm",   	false,          "",      dfNone,      		0,			false,       false);

 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	true,		"prop_mqc_qty",   			false,          "",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtData,    		80,   	daCenter,  	true,		"ctrt_eff_dt",   			false,			"",      dfNone,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtData,    		80,   	daCenter,  	true,		"ctrt_exp_dt",   			false,			"",      dfNone,      	2,			false,       false);

 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"load_previous",   			false,			"",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"load_new",   			false,			"",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"load_diff",   			false,			"",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		105,   	daRight,  	false,		"g_rev_previous",   			false,			"",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		105,   	daRight,  	false,		"g_rev",   			false,			"",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"g_rev_diff",   			false,			"",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		105,   	daRight,  	false,		"cost_previous_cm_office",   			false,			"",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		105,   	daRight,  	false,		"cost_previous_cm_trade",   			false,			"",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		105,   	daRight,  	false,		"cost_previous_op_office",   			false,			"",      dfNullInteger,      	2,			false,       false);

 					InitDataProperty(0, cnt++ , dtAutoSum,			105,   	daRight,  	false,		"cost_new_cm_office",   			false,			"",		 dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,			105,   	daRight,  	false,		"cost_new_cm_trade",   			false,			"",		 dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,			105,   	daRight,  	false,		"cost_new_op_office",   			false,			"",		 dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"cost_diff_cm_office",   			false,			"",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"cost_diff_cm_trade",   			false,			"",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"cost_diff_op_office",   			false,			"",      dfNullFloat,      	2,			false,       false);

 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"week_previous",   			false,          "",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"week_new",   			false,          "",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"week_diff",   			false,          "",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"cmpb_previous_office",   			false,          "",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"cmpb_previous_trade",   			false,          "",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"cmpb_new_office",   			false,          "",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"cmpb_new_trade",   			false,          "",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"cmpb_diff_office",   			false,          "",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"cmpb_diff_trade",   			false,          "",      dfNullFloat,      	2,			false,       false);

 					InitDataProperty(0, cnt++ , dtAutoSum,    		105,   	daRight,  	false,		"cm_previous_office",   			false,			"",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		105,   	daRight,  	false,		"cm_previous_trade",   			false,			"",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,			105,   	daRight,  	false,		"cm_new_office",   			false,			"",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,			105,   	daRight,  	false,		"cm_new_trade",   			false,			"",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"cm_diff_office",   			false,			"",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"cm_diff_trade",   			false,			"",      dfNullFloat,      	2,			false,       false);

 					InitDataProperty(0, cnt++ , dtAutoSum,    		80,   	daRight,  	false,		"opb_previous",   			false,			"",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,			80,   	daRight,  	false,		"opb_new",   			false,			"",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"opb_diff",   			false,			"",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		105,   	daRight,  	false,		"op_previous",   			false,          "",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		105,   	daRight,  	false,		"op_new",   			false,          "",      dfNullInteger,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtAutoSum,    		60,   	daRight,  	false,		"op_diff",   			false,          "",      dfNullFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtHidden,    		80,   	daRight,  	false,		"amdt_seq",   			false,			"",      dfNone,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtHidden,    		80,   	daRight,  	false,		"data_tp_cd",   			false,			"",      dfNone,      	2,			false,       false);
 					CountPosition = 0;
 					ColHidden("dummy_seq") = true;


 				 
                }
                break;
                // Simulation을 할때 입력한 값들을 저장 해 두기 위한 sheet들로 화면에는 보이지 않는다.
                // Simulation 후 excel download시 사용한다.
     			case "sheet3":      //G.Revenue Simulation
       			case "sheet4":      //Rate Simulation
       			case "sheet5":      //Surcharge Simulation
       			case "sheet6":      //Cost Simulation
       			case "sheet7":      //Load Simulation
                with (sheetObj) {
                    // 높이 설정
                    style.height = 200;
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

                    var HeadTitle1 = "|Sel.|Seq.|Application|Approval\nOffice|Customer\nType|"+(sheetObj.id == "sheet5" ? "Surcharge\nCode|" : "")+"Cal.\n[+ , x(%)]|Amount\n[+/-]|Eff.Date|Exp.Date|score";
					var headCount = ComCountHeadTitle(HeadTitle1);
					
					var HeadTitle0 = "";
					var headerTitle = new Array();
					headerTitle["sheet3"] = "G.Revenue Simulation";
					headerTitle["sheet4"] = "Rate Simulation";
					headerTitle["sheet5"] = "Surcharge Simulation";
					headerTitle["sheet6"] = "Cost Simulation";
					headerTitle["sheet7"] = "Load Simulation";
					
					for(var idx=1 ; idx < headCount ; idx++){
						HeadTitle0 += "|"+ headerTitle[sheetObj.id]
					}
					
                    
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
                    
					InitDataProperty(0, cnt++ , dtHidden,			40,   	daCenter,  	true,		"sel_chk",   			false,          "",      dfNone,      		0,			true,       true);
					InitDataProperty(0, cnt++ , dtSeq,				40,   	daCenter,  	true,		"seq",   		false,          "",      dfNone,      		0,			true,       true);
					InitDataProperty(0, cnt++ , dtData,    		100,   	daCenter,  	true,		"application",   	true,          "",      dfNone,      		0,			true,       true);
					InitDataProperty(0, cnt++ , dtData,    		80,   	daCenter,  	true,		"apr_ofc_cd",   	false,          "",      dfNone,      		0,			true,       true);
					if( sheetObj.id == "sheet5" ){
	 					InitDataProperty(0, cnt++ , dtCombo,    		100,   	daCenter,  	true,		"chg_cd",   	true,          "",      dfNone,      		0,			true,       true);
					}
					InitDataProperty(0, cnt++ , dtCombo,    		80,   	daCenter,  	true,		"cust_tp_cd",   	false,          "",      dfNone,      		0,			true,       true);
					InitDataProperty(0, cnt++ , dtData,    		100,   	daCenter,  	true,		"calc_tp_cd",   	true,          "",      dfNone,      		0,			true,       true);
					InitDataProperty(0, cnt++ , dtData,				80,		daRight,	true,		"amount",				true,			"",		dfFloat,				2,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"eff_dt",				true,			"",		 dfDateYmd,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			0,		daCenter,	true,		"exp_dt",				true,			"",		 dfDateYmd,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"score",				false,			"",		 dfNumber,			0,			true,		true);
					
					
					InitDataCombo(0, "cust_tp_cd",  ComReplaceStr(customerTypeComboText,"ALL"," "), customerTypeComboValue);
					
					ColHidden("application") = true;
					
					PopupImage  =  "img/btns_calendar.gif";
					ShowButtonImage = 1;
					CountPosition = 0;
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
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				setSearchedValues(true)
   		        formObj.f_cmd.value = SEARCH;

				ComOpenWait(true);
				sheetObj.RemoveAll();
				sheetObjects[1].RemoveAll();

				// Backend job 실행
				var sXml = sheetObj.GetSearchXml("ESM_PRI_6024GS.do", FormQueryString(formObj) );
				// Backend job 실행 후 그 key를 return받는다.
				var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");		
				if (backendJobKey.length > 0) {
					// backend job key를 전역 변수에 저장해 둔다.
					BACKEND_JOB_ID = backendJobKey;
					// sheet의 time out 시간을 10초로 설정한다.
					sheetObjects[1].RequestTimeOut = 10000;
					//3초마다 getBackEndJobStatus를 호출해 backend job이 끝났는지 확인한다.
					TIMER_ID = setInterval(getBackEndJobStatus, 3000); // 3초 후에
					// 현재 backend job이 무었에서 호출 됐는지 저장해 둔다.(IBSEARCH)
					ARRAY_BACKENDJOB_TYPE[TIMER_ID] = sAction;
																 
				}else{
					ComOpenWait(false);
				}

				
 		 		
                 break;

 			case IBSEARCH_ASYNC01:        //Customer Search Popup
	        	var sUrl = "ESM_PRI_6029.do?";
 				var params = new Array();  	  		
	  	  		params["cust_list"] = formObj.frm_cust_list.value;
	  	  		window.Params = params;
	
				var rtnVal = ComOpenWindowCenter(sUrl, "ESM_PRI_6029", 900, 470, true);
				if( rtnVal != undefined ){
					formObj.frm_cust_list.value = rtnVal.custList;
					formObj.frm_cust_nm.value = rtnVal.custNameList;
				}
	        	break;
 			case IBSEARCH_ASYNC02:        //Simulation Popup

 				var iWidth = 825;
 				var iHeight = 450;
	        	var sUrl = "ESM_PRI_6032.do?";
 				var params = new Array();  	  		
	  	  		params["prop_no_list"] = getPropNoList(sheetObj,"S");
	  	  		params["rfa_prop_no_list"] = getPropNoList(sheetObj,"R");
		  	  	params["min_ctrt_eff_dt"] = getMinMaxData(sheetObj,"ctrt_eff_dt",true);
		  	  	params["max_ctrt_exp_dt"] = getMinMaxData(sheetObj,"ctrt_exp_dt",false);
		  	  	params["frm_svc_scp_cd"] = formObj.searched_svc_scp_cd.value;		
		  	  	params["frm_customer_type"] =formObj.searched_customer_type.value;		
		  	  	params["frm_prop_apro_ofc_cd"] = formObj.searched_prop_apro_ofc_cd.value;		
		  	  	
		  	  	params["frm_contract_type"] = formObj.searched_contract_type.value;
		  	  	params["frm_pfmc_unit"] = formObj.searched_pfmc_unit.value;
		  	  	params["frm_status"] = formObj.searched_status.value;
		  	  	params["frm_ctrt_eff_dt"] = formObj.searched_ctrt_eff_dt.value;
		  	  	params["frm_ctrt_exp_dt"] = formObj.searched_ctrt_exp_dt.value;
		  	  	params["frm_prop_ofc_cd"] = formObj.searched_prop_ofc_cd.value;
		  	  	params["frm_prop_srep_cd"] = formObj.searched_prop_srep_cd.value;
		  	  	params["frm_prop_srep_nm"] = formObj.searched_prop_srep_nm.value;
		  	  	
			  	params["frm_ori_rout_cd"] = formObj.searched_ori_rout_cd.value;
			  	params["frm_ori_loc_tp"] = formObj.searched_ori_loc_tp.value;
			  	params["frm_dest_rout_cd"] = formObj.searched_dest_rout_cd.value;
			  	params["frm_dest_loc_tp"] = formObj.searched_dest_loc_tp.value;
			  	params["frm_slane_cd"] = formObj.searched_slane_cd.value;
 
	  	  		window.Params = params;
	  	  		
	        	
				sUrl += "svc_scp_cd=" + formObj.searched_svc_scp_cd.value;		

 
	 			var leftpos = (screen.width - iWidth) / 2;
	
				if (leftpos < 0)
					leftpos = 0;
				var toppos = (screen.height - iHeight) / 2;
				if (toppos < 0)
					toppos = 0;
				window.SheetObj = sheetObjects[0];
				
				var simulSheet = new Array();
				simulSheet[0] = sheetObjects[2];
				simulSheet[1] = sheetObjects[3];
				simulSheet[2] = sheetObjects[4];
				simulSheet[3] = sheetObjects[5];
				simulSheet[4] = sheetObjects[6];
				window.SheetObj = sheetObjects[0];
				window.WeekSheetObj = sheetObjects[1];
				window.SimulSheetObj = simulSheet;
				
				
	 			var rtnVal = ComOpenWindow(sUrl, "ESM_PRI_6032",
						"scroll:auto;status:no;help:no;dialogWidth:" + iWidth
								+ "px;dialogHeight:" + iHeight + "px;dialogLeft:"
								+ leftpos + ";dialogTop:" + toppos, true);
	 			if ( rtnVal != undefined ){
	 				if( rtnVal.code == "SIMULATION"){
	 					formObj.is_simulation.value = "Y";
	 				}
	 			}
	 			changeSheetSumFontColor(sheetObj);
	        	break;
 			case IBSEARCH_ASYNC03:        //Revenue Detail Popup
 				formObj.f_cmd.value = "";
				var iWidth = 840;
				var iHeight = 550;
	        	var sUrl = "ESM_PRI_6052.do?";
	        	sUrl += FormQueryString(formObj);
				//sUrl +="frm_pfmc_unit="       + formObj.searched_pfmc_unit.value;

 
				var rtnVal = ComOpenWindowCenter(sUrl, "ESM_PRI_6052", 1020, 445, false);

        	break;
        	
 			case IBSEARCH_ASYNC04:        //Chart

			var iWidth = 100;
			var iHeight = 760;
        	var sUrl = "ESM_PRI_6025.do?";
        	 

			sUrl +="&frm_profit_view=" + formObj.frm_profit_view.Code;
			sUrl +="&frm_profit_level=" + formObj.frm_profit_level.Code;
			
			sUrl += "&"+FormQueryString(formObj);
	 

			var rtnVal = ComOpenWindowCenter(sUrl, "ESM_PRI_6025", 1000, 748, false);

			break;
			
 			case IBSEARCH_ASYNC05:        //origin popup
	 			/*
	 	 		 * "LGTCR"
	 			 L:Location
	 			 G:Group Location
	 			 T:State
	 			 C:Country
	 			 R:Region
	 	 		 */
 				if(!validateForm(sheetObj,formObj,sAction)) return;
	 	 		 var formObj = document.form;
	 	 		 var svc_scp_cd = formObj.frm_svc_scp_cd.Code;
	 		 
	 		 	 var sUrl = "ESM_PRI_4026.do?"  
	 			 sUrl += "&group_cmd=" + PRI_SP_SCP; 
	 		 	 
	 		 	 //입력한 SVC SCP가 미주 지역이라면
	 		 	 if( isUSArea( )){
	 		 		//미주 지역만 Region 선택가능
	 		 		sUrl += "&location_cmd=RC";
	 		 		sUrl += "&loc_tp_cd=C"; 	  	  		 
	 		 	 }else{
	 		 		//그외 지역은 Contry만 선택가능
	 		 		sUrl += "&location_cmd=C";
	 		 		sUrl += "&loc_tp_cd=C";
	 		 	 }
	 		 	// Please input region code only for US.
	 		 		
	 			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
	 			if (rtnVal != null){
	 				formObj.frm_ori_rout_cd.value = rtnVal.cd;
	 				formObj.frm_ori_loc_tp.value = rtnVal.tp;
	 				//popup에서 선택한 값이 선택가능한 route인지 검사한다. - Origin
	 				if( !validateRoute(rtnVal.cd,"POPUP" ,"O" ) ){
	 					//선택 불가능한 route를 선택했다면 그내용을 삭제
	 					formObj.frm_ori_rout_cd.value = "";
	 					formObj.frm_ori_loc_tp.value = "";
	 				}
	 			} 	  
 			break;
 			case IBSEARCH_ASYNC06:        //dest popup
	 			/*
	 	 		 * "LGTCR"
	 			 L:Location
	 			 G:Group Location
	 			 T:State
	 			 C:Country
	 			 R:Region
	 	 		 */
 				if(!validateForm(sheetObj,formObj,sAction)) return;
	 	 		 var formObj = document.form;
	 	 		 var svc_scp_cd = formObj.frm_svc_scp_cd.Code;
	 		 
	 		 	 var sUrl = "ESM_PRI_4026.do?"  
	 			 sUrl += "&group_cmd=" + PRI_SP_SCP; 
	 		 	 
	 		 	 if(isUSArea( )){
	 		 		sUrl += "&location_cmd=RC";
	 		 		sUrl += "&loc_tp_cd=C"; 	  	  		 
	 		 	 }else{
	 		 		sUrl += "&location_cmd=C";
	 		 		sUrl += "&loc_tp_cd=C";
	 		 	 }
	 		 	// Please input region code only for US.
	 		 		
	 			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
	 			if (rtnVal != null){
	 				formObj.frm_dest_rout_cd.value = rtnVal.cd;
	 				formObj.frm_dest_loc_tp.value = rtnVal.tp;
	 				//popup에서 선택한 값이 선택가능한 route인지 검사한다. - Dest
	 				if( !validateRoute(rtnVal.cd,"POPUP" ,"D" ) ){
	 					//선택 불가능한 route를 선택했다면 그내용을 삭제
	 					formObj.frm_dest_rout_cd.value = "";
	 					formObj.frm_dest_loc_tp.value = "";
	 				}
	 			} 	   			
 			break;
 			
 			case IBSEARCH_ASYNC07 : 	//Svc Lane
 				var formObj = document.form;
 				var svc_scp_cd = formObj.frm_svc_scp_cd.Code;
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 			
	        	//vsl cd를 |로 세팅
	        	//var vslCdList = makeVslCd(formObj.frm_slane_cd);
 				//이미 선택된 service lane을  popup창에서 다시 선택될수 있도록 파라메터 seperator를 ;에서 |로 변경
 				var vslCdList = ComReplaceStr(formObj.frm_slane_cd.value,";","|") ;
 				
	            var sUrl = "/hanjin/ESM_PRI_6039.do?svc_scp_cd=" + svc_scp_cd + "&svc_scp_nm=" + formObj.frm_svc_scp_cd.GetText(svc_scp_cd,1) +
	            			"&vslCdList=" + vslCdList;
 				var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6039", 600, 425, true);
 				
 			break;
 					
 			
         }
     }
      
      
   	/**
   	 * popup 창에서 선택한 row 를 hidden grid에 세팅<br>
       * <br><b>Example :</b>
       * <pre>
       *    setSheetXml(sXml, sheetNo)
       * </pre>
       * @param {sheetObj} sheetObj   
       * @param {String} sheetNo 쉬트 일련번호    
       * @return 없음
       * @version 2009.06.10
       */
   	function setSheetXml(sXml, sheetNo) {
          var formObj = document.form;
          var sCol = "";
          var sValue = "";
          var bAppendMode = 0;
          //xml 형태로 조회 해온 데이터를 array로 변환
          var slane_cd = ComPriXml2Array(sXml,"vsl_slan_cd");
           
          for(var i = 0 ; i < slane_cd.length ; i++ ){
        	  if( i > 0){
        		  sValue += ";" 
        	  }
        	  sValue +=   slane_cd[i];
          }
          formObj.frm_slane_cd.value = sValue;
          
          
      }
   	
   	
   	
    /** 
     * sheet의 모든 proposal number list를 '|'연결한 string을 만든다.
  	 * <br><b>Example :</b>
  	 * <pre>
  	 *      params["prop_no_list"] = getPropNoList(sheetObj,"S"); //결과 "AWN25607|AEF25900|AEF25903|AEF25905"
  	 * </pre>
  	 * 
  	 * @param {object} sheetObj 필수, sheet Object
  	 * @return string, sheet의 모든 proposal number list를 '|'연결한 string
  	 */    
   function getPropNoList(sheetObj,dataTpCd){
	   var list = "";	   
	   var checkRow = sheetObj.FindCheckedRow("sel_chk");
	   var arrRow = checkRow.split("|");
	   var cnt = 0;
	   for( var i = 0  ; i < arrRow.length - 1; i++ ){
		   if( dataTpCd ==  sheetObj.CellValue(arrRow[i] , "data_tp_cd")){
		   	   if( cnt != 0 ){
		   		   list += "|";
		   	   } 
		   	   cnt++;
		   	   list += sheetObj.CellValue(arrRow[i] , "prop_no");
		   }
	   }
	   return list;
   }
   
   /** 
    * sheet의 특정 컬럼의 최고 또는 최저값을 구한다.<BR>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *      params["min_ctrt_eff_dt"] = getMinMaxData(sheetObj,"ctrt_eff_dt",true);  //결과 "200910"
	 * 	  	params["max_ctrt_exp_dt"] = getMinMaxData(sheetObj,"ctrt_exp_dt",false); //결과 "200953"
 	 * </pre>
 	 * 
 	 * @param {object} sheetObj 필수, sheet Object
 	 * @param {string} col 필수, 최고,최저값을 구하고자하는 column name
 	 * @param {boolean} isMin 필수, true: 최저값, false 최고값
 	 * 
 	 * @return string, 최고값 또는 최저값
 	 */  
   function getMinMaxData(sheetObj,col,isMin){
	   var value = "";
	   var currValue = "";
	   for(var i = sheetObj.HeaderRows; i < sheetObj.LastRow ; i++){
		   currValue = sheetObj.CellValue(i,col);
		   if( i == sheetObj.HeaderRows ){
			   value = currValue;
		   }
		   
		   if( isMin == true ){
			   if(value > currValue){
				   value = currValue;
			   }
		   }else{
			   if(value < currValue){
				   value = currValue;
			   }
		   }
	   }
	   return value;
   }
   
   
   /**  
    * Combo에서 필요한 코드를 조회해서 Combo에 Assign한다.
    * 화면에 Setting 해 놓는다.
    *  
    * <br><b>Example :</b>
    * <pre>
    *   initCombo();
    * </pre>
    * 
    * @return 없음
    */          
   function initCombo(){
       var formObj = document.form;
       formObj.frm_summary_items.MultiSelect = true;

 
       summaryComboForCmText.replace("OP","");
       // Profit Level이 CM일때는 Summary Items에 OP,OPB를 표시 하지 않는다. 
       summaryComboForCmText= ComReplaceStr(summaryComboForCmText,"|B	OPB|O	OP","");  
       summaryComboForCmValue= ComReplaceStr(summaryComboForCmValue,"|B|O","");  
 
       summaryComboForCmValue= ComReplaceStr(summaryComboForCmValue,"|B|O","");  
   
       statusComboText = ComReplaceStr(statusComboText,"Both","");  
       
       // customer type에 BOTH를 white space로 표현 해달라는 요구 때문에 replace
       customerTypeComboValue = ComReplaceStr(customerTypeComboValue,"|M",""); 
       customerTypeComboText = ComReplaceStr(customerTypeComboText,"|M	BOTH","");  
       
	   ComPriTextCode2ComboItem(svcScpComboValue,svcScpComboText, formObj.frm_svc_scp_cd ,"|","\t" );
	   ComPriTextCode2ComboItem("|"+appOfcCdComboValue,"	|"+appOfcCdComboText, formObj.frm_prop_apro_ofc_cd ,"|","\t",0 );
	   
	   ComPriTextCode2ComboItem( statusComboValue, statusComboText, formObj.frm_status ,"|","\t" ,1);
	   ComPriTextCode2ComboItem(profitViewComboValue,profitViewComboText, formObj.frm_profit_view ,"|","\t",1 );
	   ComPriTextCode2ComboItem(cmOpComboValue,cmOpComboText, formObj.frm_profit_level ,"|","\t" ,1);
	   ComPriTextCode2ComboItem("M|"+customerTypeComboValue,"\t|"+customerTypeComboText, formObj.frm_customer_type ,"|","\t",0 );
	   ComPriTextCode2ComboItem(summaryComboForCmValue,summaryComboForCmText, formObj.frm_summary_items,"|","\t",1);
	   
	   formObj.frm_profit_view.Index = 1;
	   formObj.frm_profit_level.Index = 0;
	   formObj.frm_summary_items.Index = 0;
	   formObj.frm_status.Index = 0;
 
	   formObj.frm_summary_items.DropHeight = 200 

	   
	   with(formObj.frm_svc_scp_cd){
		   	DropHeight = 200;
		   	MultiSelect = false;
		   	MaxSelect = 1;
		   	UseAutoComplete = true;
		   	ValidChar(2,0);
	   }
	   with(formObj.frm_prop_apro_ofc_cd){
		   	DropHeight = 200;
		   	MultiSelect = false;
		   	MaxSelect = 1;
		   	UseAutoComplete = true;
		   	ValidChar(2,0);
	   }
	   with(formObj.frm_prop_srep_cd){
		   	DropHeight = 200;
		   	MultiSelect = false;
		   	MaxSelect = 1;
		   	UseAutoComplete = true;
            IMEMode = 0;
            ValidChar(2, 1);
            MaxLength = 5;		   	
	   }
	   
   }
   
   /**  
    * Request Office 값을 이용해 Sales Rep.을 조회함 
    *  
    * <br><b>Example :</b>
    * <pre>
    *   searchSalesRepOffice();
    * </pre>
    * 
    * @return 없음
    */     
   function searchSalesRepOffice(){
       var formObj = document.form;
       var cd = formObj.frm_prop_ofc_cd.value;

       var sParam = "f_cmd="+SEARCH15+"&"+ FormQueryString(formObj)+"&etc1="+cd;
       var sXml = sheetObjects[6].GetSearchXml("PRICommonGS.do", sParam);
       ComPriXml2ComboItem(sXml, formObj.frm_prop_srep_cd, "cd", "cd|nm");
       formObj.frm_prop_srep_cd.InsertItem(0,"","")
       formObj.frm_prop_srep_cd.focus();    
   }
   
   /**  
   *  Summary Item의 값에 따라 sheet의 특정필드들을 가변적으로 보여준다.<BR>
   *  
   * <br><b>Example :</b>
   * <pre>
   *   changeColHidden(formObj.frm_summary_items,sheetObjects[0]);
   * </pre>
   * @param {object} comboObj 필수, Summary Item IBMultiCombo Object
   * @param {object} sheetObj 필수, sheet Object
   * @return 없음
   */    
   function changeColHidden(comboObj,sheetObj){
	   var formObj = document.form;
	   var codes = comboObj.Code;
	   var arrCodes = codes.split(",")
	   var code="";
	   var colList = new Array( );
	   var profit_view = formObj.frm_profit_view.Code;
	   var profit_level = formObj.frm_profit_level.Code;
	   
	   
	   hideColumnsRange(sheetObj,"load_previous","op_diff");
	   
	   if( arrCodes.length == 0) return;
		var summaryComboForCmValue = "A|L|R|T|W|P|C|B|O";		
		var summaryComboForCmText = "A	All|L	Load|R	G.Revenue|T	Cost|W	Week|P	CMPB|C	CM|B	OPB|O	OP";
		
		

	   colList["L"] = "load_previous|load_new|load_diff"; //Load
	   colList["R"] = "g_rev_previous|g_rev|g_rev_diff"; //GREVENUE
	   colList["W"] = "week_previous|week_new|week_diff";//WEEK
	   if(profit_level== "C" ){ //CM
		   if( profit_view == "P"){ // Trade Profit
			   colList["T"] = "cost_previous_cm_trade|cost_new_cm_trade|cost_diff_cm_trade"; //COST
			   colList["P"] = "cmpb_previous_trade|cmpb_new_trade|cmpb_diff_trade";//CMPB
			   colList["C"] = "cm_previous_trade|cm_new_trade|cm_diff_trade"; //CM
			   colList["B"] = "";  //OPB
			   colList["O"] = ""; //OP
		   }else{ //"R" Office Profit
			   colList["T"] = "cost_previous_cm_office|cost_new_cm_office|cost_diff_cm_office"; //COST
			   colList["P"] = "cmpb_previous_office|cmpb_new_office|cmpb_diff_office"; //CMPB
			   colList["C"] = "cm_previous_office|cm_new_office|cm_diff_office";  //CM
			   colList["B"] = ""; //OPB
			   colList["O"] = ""; //OP
		   }
	   }else{//OP
		   if( profit_view == "P"){ // Trade Profit
			   colList["P"] = "cmpb_previous_trade|cmpb_new_trade|cmpb_diff_trade";//CMPB
		   	   colList["C"] = "cm_previous_trade|cm_new_trade|cm_diff_trade"; //CM
		   }else{ //"R" Office Profit
			   colList["P"] = "cmpb_previous_office|cmpb_new_office|cmpb_diff_office"; //CMPB
			   colList["C"] = "cm_previous_office|cm_new_office|cm_diff_office"; //CM
			   
		   }
		   colList["T"] = "cost_previous_op_office|cost_new_op_office|cost_diff_op_office"; //COST
		   colList["B"] = "opb_previous|opb_new|opb_diff"; //OPB
		   colList["O"] = "op_previous|op_new|op_diff"; //OP
	   }
	   
	   if( arrCodes[0] == "A"){
		   //var cnt = comboObj.GetCount();
		   var colNameList;
		   if( profit_level == "C"){
			   colNameList = summaryComboForCmValue
		   }else{
			   colNameList = summaryComboForOpValue
		   }
		   colNameList = colNameList.split("|");
		   var cnt = colNameList.length

		   for(var i = 0 ; i < cnt ; i++){
			   var name = colNameList[i];
			   if( name == "ALL ") continue;
			   showColumns(sheetObj,colList[name]);
		   }		   
	   }else{
		   for(var i = 0 ; i < arrCodes.length ; i++){
			   code = arrCodes[i];
			   showColumns(sheetObj,colList[code]);
		   }
	   }
   }
   
   /**  
   *  Summary Item의 값에 따라 sheet의 특정필드들을 가변적으로 보여준다.<BR>
   *  
   * <br><b>Example :</b>
   * <pre>
   *   hideColumnsRange(sheetObjects[0],"load_previous","op_diff");
   * </pre>
   * 
   * @param {object} sheetObj 필수, sheet Object
   * @param {string} col1 필수, 숨기고 싶은 column의 시작 culumn name
   * @param {string} col2 필수, 숨기고 싶은 column의 마지막 culumn name
   * @return 없음
   */      
   function hideColumnsRange(sheetObj,col1,col2){
	   var startCol ;
	   var endCol;
	   if( !col1.isNumber() ){
		   startCol = sheetObj.SaveNameCol(col1);
	   }else{
		   startCol = col1;
	   }
	   
	   if( !col2.isNumber() ){
		   endCol = sheetObj.SaveNameCol(col2);
	   }else{
		   endCol = col2;
	   }
	   for( var i = startCol ; i <= endCol ; i ++){
		   sheetObj.ColHidden(i) = true;
	   }	   
   }
   
   /**  
   *  '|'로 연결된 column명 list에 해당하는 sheet의 column들을<BR>
   *  보여준다.<BR>
   *  
   * <br><b>Example :</b>
   * <pre>
   *   showColumns(sheetObject1, "cust_tp_cd|prop_apro_ofc_cd|respb_srep_cd|ctrt_eff_dt|ctrt_exp_dt" );
   * </pre>
   * 
   * @param {object} sheetObj 필수, sheet Object
   * @param {string} strColList 필수, 보여주고 싶은 column을 '|'로 연결한 string
   * @return 없음
   */         
   function showColumns(sheetObj, strColList ){
	   showHideColumns(sheetObj, strColList,false )
   }
   
   /**  
   *  '|'로 연결된 column명 list에 해당하는 sheet의 column들을<BR>
   *  숨긴다.<BR>
   *  
   * <br><b>Example :</b>
   * <pre>
   *   hideColumns(sheetObject1, "cust_tp_cd|prop_apro_ofc_cd|respb_srep_cd|ctrt_eff_dt|ctrt_exp_dt" );
   * </pre>
   * 
   * @param {object} sheetObj 필수, sheet Object
   * @param {string} strColList 필수, 숨기고 싶은 column을 '|'로 연결한 string
   * @return 없음
   */       
   function hideColumns(sheetObj, strColList ){
	   showHideColumns(sheetObj, strColList,true )
   }
   
   
   /**  
   *  '|'로 연결된 column명 list에 해당하는 sheet의 column들을<BR>
   *  flg값에 따라 보여주거나 숨긴다.<BR>
   *  
   * <br><b>Example :</b>
   * <pre>
   *   showHideColumns(sheetObject1, "cust_tp_cd|prop_apro_ofc_cd|respb_srep_cd|ctrt_eff_dt|ctrt_exp_dt",false ); // 해당 컬럼들을 보여준다.
   *   showHideColumns(sheetObject1, "cust_tp_cd|prop_apro_ofc_cd|respb_srep_cd|ctrt_eff_dt|ctrt_exp_dt",true ); // 해당 컬럼들을 숨긴다.
   * </pre>
   * 
   * @param {object} sheetObj 필수, sheet Object
   * @param {string} strColList 필수, 숨기고 싶은 column을 '|'로 연결한 string
   * @param {boolean} flg 필수, true: 숨김, false : 보여줌
   * @return 없음
   */     
   function showHideColumns(sheetObj, strColList,flg ){
	   if( strColList == undefined) return;
	   if( strColList == "" ) return;
	   var arrColList = strColList.split("|");
	   for( var i = 0 ; i < arrColList.length ; i ++){
		   sheetObj.ColHidden(arrColList[i]) = flg;
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
    	  
    	  switch(sAction){
    	  case IBSEARCH :
    		if( formObj.frm_svc_scp_cd.Code == "" ){
				ComShowCodeMessage("PRI00316","SVC Scope");
				return false;
    		}
    		if( formObj.frm_ctrt_eff_dt.value == "" ){
				ComShowCodeMessage("PRI00316","Duration");
				return false;
    		}
    		var eff_dt = formObj.frm_ctrt_eff_dt.value.replace(/\/|\-|\./g,"");
    		var exp_dt = formObj.frm_ctrt_exp_dt.value.replace(/\/|\-|\./g,"");
 
    		if(exp_dt != "" && ComChkPeriod(eff_dt, exp_dt) < 1){
    			ComShowCodeMessage("PRI00306");
				return false;
    		}
    		break;
    		
    	  case IBSEARCH_ASYNC05:
    	  case IBSEARCH_ASYNC06:
    	  case IBSEARCH_ASYNC07:
	      	  if( formObj.frm_svc_scp_cd.Code == "" ){
					ComShowCodeMessage("PRI03028");
					return false;
	    	  }
    		  break;
    	  }

         return true;
     }	


    /**  
     * 화면에서 Key가 눌렸을경우의 이벤트처리
     *  
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * 
     * @return 없음
     */      
    function obj_keypress() {
        switch (event.srcElement.dataformat) {
            case "engup":
                ComKeyOnlyAlphabet('upper');
                break;
            case "int":
                ComKeyOnlyNumber(event.srcElement);
                break;
            case "float":
                ComKeyOnlyNumber(event.srcElement, ".");
                break;
            default:
        }
    }    
    
    /**  
    * frm_ctrt_exp_dt에서 focus를 잃었을 경우의 이벤트처리
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @return 없음
    */       
    function frm_ctrt_exp_dt_OnBlur(){
        switch (event.srcElement.dataformat) {
        case "ymd":
        	ComAddSeparator(event.srcElement,"ymd");
        	break;
        default:
        }
    }
    /**  
    * frm_ctrt_eff_dt에서 focus를 잃었을 경우의 이벤트처리
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @return 없음
    */           
    function frm_ctrt_eff_dt_OnBlur(){
        switch (event.srcElement.dataformat) {
        case "ymd":
        	ComAddSeparator(event.srcElement,"ymd");
        	break;
        default:
        }
    }
    
    /**  
    * frm_prop_ofc_cd의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @return 없음
    */   
 	function frm_prop_ofc_cd_OnChange(){
 		
 		clearPropSrepNm ();
 		searchSalesRepOffice();
 	}
 	
    
    /**  
    * frm_ori_rout_cd의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @return 없음
    */   
 	function frm_ori_rout_cd_OnChange(){
    	var formObj = document.form;
    	//Origin 의 입력값이 정상적인지 검사
		if( !validateRoute( formObj.frm_ori_rout_cd.value,"" ,"O" ) ){
			formObj.frm_ori_rout_cd.value = "";
			formObj.frm_ori_loc_tp.value = "";
		}else{
			// Origin code의 길이에 따라 contry인지 region인지 code를 hidden값에 저장해 둔다.
			if(formObj.frm_ori_rout_cd.value.length == 2 ){
				formObj.frm_ori_loc_tp.value = "C";
			}else{
				formObj.frm_ori_loc_tp.value = "R";
			}
		}
	 
 
 		 
 	}
    
    /**  
    * frm_dest_rout_cd의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @return 없음
    */   
 	function frm_dest_rout_cd_OnChange(){
    	var formObj = document.form;
		if( !validateRoute( formObj.frm_dest_rout_cd.value,"" ,"D" ) ){
			formObj.frm_dest_rout_cd.value = "";
			formObj.frm_dest_loc_tp.value = "";
		}else{
			if(formObj.frm_dest_rout_cd.value.length == 2 ){
				formObj.frm_dest_loc_tp.value = "C";
			}else{
				formObj.frm_dest_loc_tp.value = "R";
			}
		}
 	}
    
    
    /**  
    * 사용자가 입력한 Svc Scope가 USA에 속하는지 검사한다.
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @return boolean, true: US에 해당하는 SVC Scope임, false: 기타지역 SVC Scope임
    */   
    function isUSArea( ){
    	var svc_scp_cd = document.form.frm_svc_scp_cd.Code;
    	 if( svc_scp_cd == "TPE" || svc_scp_cd == "TPW" || svc_scp_cd == "TAE"|| svc_scp_cd == "ASE"|| svc_scp_cd == "TAW"|| svc_scp_cd == "ASW"|| svc_scp_cd == "MME"|| svc_scp_cd == "SAS"|| svc_scp_cd == "SAN" ){
    		 return true;
    	 }else{
    		 return false;
    	 }
    }
    /**  
    * 사용자가 입력한 route 가 유효한지 검사한다.
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @return boolean, true: 유효한 Route, false: 유효하지 않은 route
    */   
    function validateRoute(locCd,checkType,oriDestCd){
		var svc_scp_cd= document.form.frm_svc_scp_cd.Code;
		var sheetObj = sheetObjects[0]
		//미주 지역은 Region Code만 입력 가능한다.
		if( locCd == "US" &&  isUSArea( ) ){
			ComShowCodeMessage("PRI03014"); // Please input region code only for US
			return false;
		}else {
			//region code는 US region만 넣을수 있다. US region인지 검사 한다.
			if( locCd.length == 3 && isUSArea( ) ){
				var formObj = document.form;
				formObj.f_cmd.value = SEARCH02;
				var param = FormQueryString(formObj);
				param += "&cnt_cd=US";
				param += "&rgn_cd="+locCd;
				var sXml = sheetObj.GetSearchXml("ESM_PRI_6031GS.do", param );
				
				var is_success = ComGetEtcData(sXml, "IS_SUCCESS");
				//조회해온 값을 검사해 'F'이면 route가 적절하지 않은 route임.
				if (is_success.length <= 0 || is_success == "F") {
					ComShowCodeMessage("PRI03014"); // Please input region code only for US
					return false;
				}
			// checkType이 POPUP이란 얘기는 popup에서 입력해서 이 validateRoute가 호출 된 경우로 
		    // 이미 popup창에서 아래의 검사를 했기때문에 중복검사를 하지 않는다.
			}else if(checkType != "POPUP" && locCd.length == 2){//COUNTRY CODE
				var formObj = document.form;
				formObj.f_cmd.value = SEARCH02;
				var param = FormQueryString(formObj);
				param += "&cnt_cd="+locCd;
				var sXml = sheetObj.GetSearchXml("ESM_PRI_6031GS.do", param );
				var is_success = ComGetEtcData(sXml, "IS_SUCCESS");
				if (is_success.length <= 0 || is_success == "F") {
					ComShowCodeMessage("PRI03024"); // This is an invalid code. Please input country code except US(United states, Region code only)
					return false;
				}
			}else if(checkType != "POPUP" && locCd.length == 3){//REGION CODE
				var formObj = document.form;
				formObj.f_cmd.value = SEARCH02;
				var param = FormQueryString(formObj);
				param += "&rgn_cd="+locCd;
				var sXml = sheetObj.GetSearchXml("ESM_PRI_6031GS.do", param );
				var is_success = ComGetEtcData(sXml, "IS_SUCCESS");
				if (is_success.length <= 0 || is_success == "F") {
					ComShowCodeMessage("PRI03024"); // This is an invalid code. Please input country code except US(United states, Region code only)
					return false;
				}				
			}
			
			
			//Service Scope에서 선택 가능한 origin dest인지 확인 한다.
			var formObj = document.form;
			formObj.f_cmd.value = SEARCH02;
			var param = FormQueryString(formObj);
			if(  locCd.length == 3   ){
				param += "&loc_tp_cd=R";
				param += "&rgn_cd="+locCd;
			}else if( locCd.length == 2   ){
				param += "&loc_tp_cd=C";
				param += "&cnt_cd="+locCd;
			}
			param += "&ori_dest_cd="+oriDestCd;
			param += "&svc_scp_cd="+svc_scp_cd;
			
			var sXml = sheetObj.GetSearchXml("ESM_PRI_6032GS.do", param );
			var is_success = ComGetEtcData(sXml, "IS_SCOPE_SUCCESS");
			if (is_success.length <= 0 || is_success == "F") {
				ComShowCodeMessage("PRI03029"); // SVC Scope doesn’t cover  for origin or destination you inputted.
		         								// Please check input data.
				return false;
			}
			
			
			
		}
		return true;
    }    
 	
 	
    /**  
    * Sales Rep.의 값을 null로 만듦.
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @return 없음
    */   
 	function clearPropSrepNm(){
 		document.form.frm_prop_srep_nm.value="";
 	}
 	
    
    /**  
    * frm_prop_srep_cd에서 focus를 잃었을 경우의 이벤트처리
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {object} comboObj 필수, IBMultiCombo Object
    * @return 없음
    */  
    function frm_prop_srep_cd_OnBlur(comboObj) {
    	changeSrepText(comboObj);
    }   
    
    /**  
    * frm_prop_srep_cd의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @param {object} comboObj 필수, IBMultiCombo Object
    * @return 없음
    */       
    function frm_prop_srep_cd_OnChange(comboObj,code,text) {
        var formObj = document.form;
        var arrText = text.split("|");
    	if (arrText != null && arrText.length > 1) {
    		formObj.frm_prop_srep_nm.value = comboObj.GetText(code, 1);
    	}
    }   
    
    /**  
    * Combo에서 Sales Rep. 이름을 읽어 화면에 표시 해줌<BR>
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * 		changeSrepText(comboObj);
    * </pre>
    * 
    * @param {object} comboObj 필수, IBMultiCombo Object
    * @return 없음
    */   
    function changeSrepText(comboObj){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var text = comboObj.GetText(comboObj.Code,1);
        formObj.frm_prop_srep_nm.value = text;
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
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	// sheet의 모든 row을 check한다.
    	sheetObj.CheckAll2("sel_chk") = 1; 
    	// total row의 'Total' Text를 변경한다.
    	mergeTotalLine(sheetObj);
    	// 조회시 사용한 조회 조건들을 저장해 둔다.
 		setSearchedValues(false);
 		// 버튼의 상태를 바꾼다.
 		changeButtonStatus();
 		// Contract No.의 색깔을 link에 맞게 파란색으로 바꾸고 밑줄을 긋는다.
 		sheetObj.ColFontColor("prop_no") = sheetObj.RgbColor(100,100,255);
 		sheetObj.ColFontUnderline("prop_no") = true;
 		// total의 내용중 diff, cmpb 값은 단순 sum이 아니기 때문에 
 		// 계산에 의해서 바꿔준다.
 		changeSheetSumValues(sheetObj);
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
 	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
    	mergeTotalLine(sheetObj);
 		changeSheetSumValues(sheetObj);
     }
    /** 
    * sheet의 total line의 total text 부분을 merge한다. 
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @return 없음
    */   
    function mergeTotalLine(sheetObj){

		sheetObj.SumText(0, "seq") = "";
		sheetObj.SumText(0, "cust_nm") = "Total";
    }
 	
    
    /** 
    * CMPB,CM,REVEVNUE는 단순 SUM으로 계산하면 안되기 때문에<BR>
    * sheet의 내용이 변경된 후 Sum Row에 일부 컬럼의 Sum값을 재 계산한다<BR>
    * 
    * <br><b>Example :</b>
    * <pre>
    * 		changeSheetSumValues(sheetObj);
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * 
    * @return 없음
    */   
 	function changeSheetSumValues(sheetObj){
 		//Week 평균값을 보여준다.
 	
 		var COL_PREVIOUS_LOD = "load_previous";
 		var COL_PREVIOUS_CM_OFFICE = "cm_previous_office";
 		var COL_PREVIOUS_CMPB_OFFICE = "cmpb_previous_office";
 		var COL_PREVIOUS_CM_TRADE = "cm_previous_trade";
 		var COL_PREVIOUS_CMPB_TRADE = "cmpb_previous_trade"; 
 		var COL_PREVIOUS_G_REV = "g_rev_previous";
 		var COL_PREVIOUS_COST_CM_OFFICE = "cost_previous_cm_office"; 	 
 		var COL_PREVIOUS_COST_CM_TRADE = "cost_previous_cm_trade"; 	 
 		var COL_PREVIOUS_COST_OP_OFFICE = "cost_previous_op_office"; 	 
 		
 		var COL_NEW_LOD = "load_new";
 		var COL_NEW_CM_OFFICE = "cm_new_office";
 		var COL_NEW_CMPB_OFFICE = "cmpb_new_office";
 		var COL_NEW_CM_TRADE = "cm_new_trade";
 		var COL_NEW_CMPB_TRADE = "cmpb_new_trade"; 	 
 		var COL_NEW_G_REV = "g_rev";
 		var COL_NEW_COST_CM_OFFICE = "cost_new_cm_office"; 	 
 		var COL_NEW_COST_CM_TRADE = "cost_new_cm_trade"; 	 
 		var COL_NEW_COST_OP_OFFICE = "cost_new_op_office";  		
 		
 		var COL_DIFF_CMPB_OFFICE = "cmpb_diff_office"; 	 
 		var COL_DIFF_CMPB_TRADE = "cmpb_diff_trade"; 	 
 		var COL_PREVIOUS_WK = "week_previous"
 		var COL_NEW_WK = "week_new"
 		var COL_DIFF_WK = "week_diff"
 			
 	 	var COL_DIFF_CM_OFFICE = "cm_diff_office"; 	 
 		var COL_DIFF_CM_TRADE = "cm_diff_trade"; 	 
 		var COL_DIFF_LOAD = "load_diff"; 	 
 		
 		var COL_DIFF_REV = "g_rev_diff"; 	 
 		
 		var COL_DIFF_COST_CM_OFFICE = "cost_diff_cm_office"; 	 
 		var COL_DIFF_COST_CM_TRADE = "cost_diff_cm_trade"; 	 
 		var COL_DIFF_COST_OP_OFFICE = "cost_diff_op_office"; 	 
		
 		var COL_NEW_OP = "op_new";
 		var COL_NEW_OPB = "opb_new"; 	 
 		var COL_PREVIOUS_OP = "op_previous";
 		var COL_PREVIOUS_OPB = "opb_previous"; 
 		var COL_DIFF_OP = "op_diff"; 	
 		var COL_DIFF_OPB = "opb_diff"; 	
 		//OP
 		// Previous OP의 opb의 total 부분을 재 계산한다.
 		calcBottomCmpbOpb(sheetObj,COL_PREVIOUS_LOD,COL_PREVIOUS_OP,COL_PREVIOUS_OPB); 
 		// New OP의 opb의 total 부분을 재 계산한다.
 		calcBottomCmpbOpb(sheetObj,COL_NEW_LOD,COL_NEW_OP,COL_NEW_OPB);
 		// op에서의 Diff total 부분을 재 계산한다.
 		calcBottomDiff(sheetObj,COL_NEW_OP,COL_PREVIOUS_OP,COL_DIFF_OP)	;
 		// opb에서의 Diff total 부분을 재 계산한다.
 		calcBottomDiff(sheetObj,COL_NEW_OPB,COL_PREVIOUS_OPB,COL_DIFF_OPB);

 		//CM
 		// Previous CM의 CMPB의 total 부분을 재 계산한다.(Office)
 		calcBottomCmpbOpb(sheetObj,COL_PREVIOUS_LOD,COL_PREVIOUS_CM_OFFICE,COL_PREVIOUS_CMPB_OFFICE);
 		// Previous CM의 CMPB의 total 부분을 재 계산한다.(Trade)
 		calcBottomCmpbOpb(sheetObj,COL_PREVIOUS_LOD,COL_PREVIOUS_CM_TRADE,COL_PREVIOUS_CMPB_TRADE);
 		// New CM의 CMPB의 total 부분을 재 계산한다.(Office)
 		calcBottomCmpbOpb(sheetObj,COL_NEW_LOD,COL_NEW_CM_OFFICE,COL_NEW_CMPB_OFFICE);
 		// New CM의 CMPB의 total 부분을 재 계산한다.(Trace)
 		calcBottomCmpbOpb(sheetObj,COL_NEW_LOD,COL_NEW_CM_TRADE,COL_NEW_CMPB_TRADE);
 		//  CMPB에서의 Diff total 부분을 재 계산한다.(Office) 		
 		calcBottomDiff(sheetObj,COL_NEW_CMPB_OFFICE,COL_PREVIOUS_CMPB_OFFICE,COL_DIFF_CMPB_OFFICE);
 		// CMPB에서의 Diff total 부분을 재 계산한다.(Trade)
 		calcBottomDiff(sheetObj,COL_NEW_CMPB_TRADE,COL_PREVIOUS_CMPB_TRADE,COL_DIFF_CMPB_TRADE);
 		// Previous Week의 total을 재 계산한다.
 		calcBottomWeek(sheetObj,COL_PREVIOUS_WK)	;
 		// New Week의 total을 재 계산한다.
 		calcBottomWeek(sheetObj,COL_NEW_WK)	;
 		// Week의 Diff total을 재 계산한다.
 		calcBottomDiff(sheetObj,COL_NEW_WK,COL_PREVIOUS_WK,COL_DIFF_WK)	;
 		// CM Diff total을 재 계산한다.(Office)
 		calcBottomDiff(sheetObj,COL_NEW_CM_OFFICE,COL_PREVIOUS_CM_OFFICE,COL_DIFF_CM_OFFICE)	;
 		// CM Diff total을 재 계산한다.(Office)
 		calcBottomDiff(sheetObj,COL_NEW_CM_TRADE,COL_PREVIOUS_CM_TRADE,COL_DIFF_CM_TRADE)	;
 		// Load Diff total을 재 계산한다.
 		calcBottomDiff(sheetObj,COL_NEW_LOD,COL_PREVIOUS_LOD,COL_DIFF_LOAD)	;
 		// G.Rev Diff total을 재 계산한다.
 		calcBottomDiff(sheetObj,COL_NEW_G_REV,COL_PREVIOUS_G_REV,COL_DIFF_REV)	;
 		// Cost Diff를 재 계산한다.(Office Cost)
 		calcBottomDiff(sheetObj,COL_NEW_COST_CM_OFFICE,COL_PREVIOUS_COST_CM_OFFICE,COL_DIFF_COST_CM_OFFICE)	;
 		// Cost Diff를 재 계산한다.(Trade Cost) 		
 		calcBottomDiff(sheetObj,COL_NEW_COST_CM_TRADE,COL_PREVIOUS_COST_CM_TRADE,COL_DIFF_COST_CM_TRADE)	;
 		// Cost Diff를 재 계산한다.(OP Cost) 		
 		calcBottomDiff(sheetObj,COL_NEW_COST_OP_OFFICE,COL_PREVIOUS_COST_OP_OFFICE,COL_DIFF_COST_OP_OFFICE)	;
 		
 	}
 	
    /** 
    * Week는 단순 SUM으로 계산하면 안되기 때문에<BR>
    * sheet의 내용이 변경된 후 week를 재 계산한다<BR>
    * 그 공식은 (week의 sum) / (null이 아닌 row의 count)
    * 
    * <br><b>Example :</b>
    * <pre>
    * 		calcBottomWeek(sheetObj,COL_NEW_WK)	;
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @param {string} COL_WK 필수, week 컬럼명
    * 
    * @return 없음
    */   
    function calcBottomWeek(sheetObj,COL_WK){
	   var rowCnt =  getNotNullCellRowCount( sheetObj, COL_WK); 
   	   var wk =  eval(sheetObj.SumValue(0,COL_WK));
   	   var rslt = 0;
   	   if( rowCnt == 0 ){
   		   return;
   	   }else{
   		   rslt = wk / rowCnt;
   	   }
   	   sheetObj.SumValue(0,COL_WK) = rslt;
    }
    
    /** 
    * 특정 컬럼에 null이 아닌 데이터가 몇 row가 있는지 count한다.
    * 
    * <br><b>Example :</b>
    * <pre>
    * 		rowCnt =  getNotNullCellRowCount( sheetObj, COL_WK); 
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @param {string} COL_NM 필수, count할 컬럼명
    * 
    * @return int, not null인 row의 count 수
    */   
    function getNotNullCellRowCount(sheetObj, COL_NM){
    	var iCnt = 0;
    	var headRow = sheetObj.HeaderRows;
    	for(var i = 0 ; i < sheetObj.RowCount ; i++){
    		if(sheetObj.CellValue(i+headRow,COL_NM) != "" ){
    			iCnt++;
    		}
    	}
    	return iCnt;
    }
    
   	/** 
    * SUM ROW에 있는 CMPB, OPB 값을 계산해서 CELL에 넣어 준다.
	 * <br><b>Example :</b>
	 * <pre>
	 *      calcBottomCmpbOpb(sheetObj,COL_LOD,COL_CM,COL_CMPB)
	 * </pre>
	 * @param {object} sheetObj 필수, sheet Object
	 * @param {string} COL_LOD 필수, 계산에 사용할 load column name
	 * @param {string} COL_CM 필수, 변경시킬 CM,OP column name
	 * @param {string} COL_CMPB 필수, 계산에 사용할 CMPB,OPB column name
	 * @return 없음
	 */      
    function calcBottomCmpbOpb(sheetObj,COL_LOD,COL_CM,COL_CMPB){
   	   var lod_qty =  eval(sheetObj.SumValue(0,COL_LOD));
   	   var cm_amt =  eval(sheetObj.SumValue(0,COL_CM));
   	   var rslt = 0;
   	   if( lod_qty == 0 ){
   		   rslt = 0
   	   }else{
   		   rslt = cm_amt / lod_qty;
   	   }
   	   sheetObj.SumValue(0,COL_CMPB) = rslt;
      }    
    
    
   	/** 
    * SUM ROW에 있는 Diff값을 계산해서 CELL에 넣어 준다.
	 * <br><b>Example :</b>
	 * <pre>
	 *      calcBottomDiff(sheetObj,COL_NEW_COST_OP_OFFICE,COL_PREVIOUS_COST_OP_OFFICE,COL_DIFF_COST_OP_OFFICE)	;
	 * </pre>
	 * @param {object} sheetObj 필수, sheet Object
	 * @param {string} COL_A_CMPB 필수, 계산에 사용할 Actual column name
	 * @param {string} COL_E_CMPB 필수, 계산에 사용할 Estimate column name
	 * @param {string} COL_DIFF_CMPB 필수, 값을 바꿀 Diff. column name
	 * @return 없음
	 */     
    function calcBottomDiff(sheetObj,COL_A_CMPB,COL_E_CMPB,COL_DIFF_CMPB){
    	   var a_cmpb =  eval(sheetObj.SumValue(0,COL_A_CMPB));
    	   var e_cmpb =  eval(sheetObj.SumValue(0,COL_E_CMPB));
    	   var rslt = "0";
    	   if( e_cmpb == 0 ){
    		   rslt = "0"
    	   }else{
    		   rslt = (a_cmpb-e_cmpb) / Math.abs(e_cmpb)*100;
    	   }
    	   sheetObj.SumValue(0,COL_DIFF_CMPB) = rslt;
       }   
    
    /** 
    * sheet위를 마우스 포인터가 이동할경우 자동 호출됨 
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @param {int} shift 필수, Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
    * @param {int} x 필수, X 좌표
    * @param {int} y 필수, Y 좌표
    * @return 없음
    */   
 	function sheet1_OnMouseMove(sheetObj,button,shift,x,y){
 		switch(sheetObj.ColSaveName(sheetObj.MouseCol)){
 		case "prop_no" :
 			sheetObj.MousePointer = "Hand";

 			break;
 		default :
 			sheetObj.MousePointer = "Default";
 			break;
 		}
 	}
    /** 
     * sheet를 마우스 더블클릭 했을경우 자동 호출됨 
     * Proposal No를 double click했을때 해당 Main 화면 Popup을 띄워줌.
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {int} row 필수, 클릭된 row index
     * @param {int} col 필수, 클릭된 col index
     * @return 없음
     */           	
 	function sheet1_OnDblClick(sheetObj,row,col){
 		switch(sheetObj.ColSaveName(col)){
 		case "prop_no" :
 			var pgmNo = "";
 			var pgmUrl = "";
			var parentPgmNo = "";   
 			var src = "";
 			if( sheetObj.CellValue(row,"data_tp_cd") == "R" ){
 				//RFA Proposal & Amendment Creation
	 			pgmNo = "ESM_PRI_2003";
	 			pgmUrl = "/hanjin/ESM_PRI_2003.do"
				parentPgmNo = pgmNo.substring(0, 8)+'M001';   
	 			src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&cond_prop_no="+sheetObj.CellValue(row,col); 
 			}else{
 				//S/C Proposal & Amendment Creation
 				pgmNo = "ESM_PRI_0003";
	 			pgmUrl = "/hanjin/ESM_PRI_0003.do"
				parentPgmNo = pgmNo.substring(0, 8)+'M001';   
	 			src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&prop_no="+sheetObj.CellValue(row,col); 
 			}
			var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
			var winObj = window.open("alpsMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);   
			var parentPgmNo = pgmNo.substring(0, 8)+'M001';
			 
 			break;
 		}
 	}
     
     /** 
      * sheet를 이용해 조회를 했을경우 조회 완료후 자동 호출됨 <BR>
      *
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {object} sheetObj 필수, sheet Object
      * @param {String} row 필수, 수정된 row
      * @param {String} col 필수, 수정된 col
      * @param {String} value 필수, 수정된 value
      * @return 없음
      */        
     function sheet1_OnChange(sheetObj,row,col,value){
    	 
  		switch(sheetObj.ColSaveName(col)){
 		case "sel_chk" :  //TRI가 선택돼 있으면 Simulation을 하지 못하도록 버튼을 제어함
 			 var checkRow = sheetObj.FindCheckedRow(col);
 			 var arrRow = checkRow.split("|");
 			 var flg = ComIsBtnEnable("btn1_Simulation");
 			 if( arrRow.length == 1 ){
 				if( flg == true )
 					ComBtnDisable("btn1_Simulation");
 			 }else{
 				if( flg == false )
 					ComBtnEnable("btn1_Simulation");
 			 }
 			break;
 		}
 
     }
 	
     
    /** 
     * 조회 완료후 조회 할 당시의 조회 조건들을 다른 변수에 저장한다.<BR>
     * 만약 flag값이 true 일경우 조회 완료후 조건값을 초기화 한다.<BR> 
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *      setSearchedValues(false);
 	 * </pre>
 	 * 
 	 * @param {boolean} bClearValues 필수, true : 값을 초기화, false : 현재 화면의 값을 다른 변수에 저장해 놓는다.
 	 * @return 없음
 	 */
 	function setSearchedValues(bClearValues){
 		
 		var formObj = document.form;
 		if(bClearValues != true){
 			formObj.searched_svc_scp_cd.value = formObj.frm_svc_scp_cd.Code;
 			formObj.searched_prop_apro_ofc_cd.value = formObj.frm_prop_apro_ofc_cd.Code;
 			formObj.searched_customer_type.value = formObj.frm_customer_type.Code;
 			if(formObj.frm_contract_type_s.checked == true){
 				formObj.searched_contract_type_s.value =   formObj.frm_contract_type_s.value;
 				formObj.searched_contract_type.value = formObj.frm_contract_type_s.value;
 			}else{
 				formObj.searched_contract_type_s.value = "";
 			}
 			if(formObj.frm_contract_type_r.checked == true){
 				formObj.searched_contract_type_r.value =   formObj.frm_contract_type_r.value;
 				if(formObj.frm_contract_type_s.checked == true){
 					formObj.searched_contract_type.value = "B";
 				}else{
 					formObj.searched_contract_type.value = formObj.frm_contract_type_r.value;
 				}
 			}else{
 				formObj.searched_contract_type_r.value = "";
 			}
 			 

 			
 			formObj.searched_pfmc_unit.value =       ComPriGetCheckedRadioButtonValue(formObj.frm_pfmc_unit);
 			formObj.searched_status.value =          formObj.frm_status.Code;
 			formObj.searched_ctrt_eff_dt.value =     formObj.frm_ctrt_eff_dt.value;
 			formObj.searched_ctrt_exp_dt.value =     formObj.frm_ctrt_exp_dt.value;
 			formObj.searched_prop_ofc_cd.value =     formObj.frm_prop_ofc_cd.value;
 			formObj.searched_prop_srep_cd.value =    formObj.frm_prop_srep_cd.Code;
 			formObj.searched_cust_list.value =     formObj.frm_cust_list.value;
 			formObj.searched_crg_tp_dry.value =      (formObj.frm_crg_tp_dry.checked == true ? formObj.frm_crg_tp_dry.value : "" ) ;
 			formObj.searched_crg_tp_dg.value =       (formObj.frm_crg_tp_dg.checked == true ? formObj.frm_crg_tp_dg.value : "" ) ; 
 			formObj.searched_crg_tp_rf.value =       (formObj.frm_crg_tp_rf.checked == true ? formObj.frm_crg_tp_rf.value : "" ) ; 
 			formObj.searched_crg_tp_ak.value =       (formObj.frm_crg_tp_ak.checked == true ? formObj.frm_crg_tp_ak.value : "" ) ; 
 			formObj.searched_crg_tp_bb.value =       (formObj.frm_crg_tp_bb.checked == true ? formObj.frm_crg_tp_bb.value : "" ) ;
 			
 			formObj.searched_ori_rout_cd.value =     formObj.frm_ori_rout_cd.value;
 			formObj.searched_ori_loc_tp.value =     formObj.frm_ori_loc_tp.value;
 			formObj.searched_dest_rout_cd.value =     formObj.frm_dest_rout_cd.value;
 			formObj.searched_dest_loc_tp.value =     formObj.frm_dest_loc_tp.value;
 			formObj.searched_slane_cd.value =     formObj.frm_slane_cd.value;
 			formObj.is_simulation.value = "";
 			
 		}else{
 			formObj.searched_svc_scp_cd.value = "";
 			formObj.searched_prop_apro_ofc_cd.value = "";
 			formObj.searched_customer_type.value = "";
 			
 			formObj.searched_contract_type.value = "";
 			formObj.searched_contract_type_s.value = "";
 			formObj.searched_contract_type_r.value = "";
 			formObj.searched_pfmc_unit.value = "";
 			formObj.searched_status.value = "";
 			formObj.searched_ctrt_eff_dt.value = "";
 			formObj.searched_ctrt_exp_dt.value = "";
 			formObj.searched_prop_ofc_cd.value = "";
 			formObj.searched_prop_srep_cd.value = "";
 			formObj.searched_prop_srep_nm.value = "";
 			formObj.searched_cust_list.value = "";
 			formObj.searched_crg_tp_dry.value = "";
 			formObj.searched_crg_tp_dg.value = "";
 			formObj.searched_crg_tp_rf.value = "";
 			formObj.searched_crg_tp_ak.value = "";
 			formObj.searched_crg_tp_bb.value =  "";
 			
 			formObj.searched_ori_rout_cd.value =  "";
 			formObj.searched_ori_loc_tp.value =  "";
 			formObj.searched_dest_rout_cd.value =  "";
 			formObj.searched_dest_loc_tp.value =  "";
 			formObj.searched_slane_cd.value =  "";
 			
 			formObj.is_simulation.value = "";
 		}
 	}
 	
    /**  
    * frm_profit_view의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @param {object} comboObj 필수, IBMultiCombo Object
    * @param {string} code 필수, 선택된 Code값
    * @param {string} name 필수, 선택된 text값
    * @return 없음
    */        
 	function frm_profit_level_OnChange(comboObj,code,name){
 		//Propfit Level에 따라 선택할수 있는 summary Items의 내용을 바꾼다.
 		changeSummaryItems(code);
 		//Propfit Level에 따라 sheet의 column을 바꾼다.
 		changeColHidden(document.form.frm_summary_items,sheetObjects[0]);
 		//Propfit Level에 따라 sheet의 column을 바꾼다.
 		changeColHidden(document.form.frm_summary_items,sheetObjects[1]);
 		//Propfit Level에 따라 화면 title을 바꾼다.
 		changeTitle(code);
 		//Propfit Level에 따라 sheet의 title을 바꾼다.
 		changeSheetTitle(code);
 	}
    
    /**  
    * download excel에서 사용할 sheet의 이름을 구성한다.
    * 
    *  
    * <br><b>Example :</b>
    *  	sheetObject1.SpeedDown2Excel(-1, false, false,"","",false,false,getSheetNameOfExcel("BEFORE"));
 		sheetObject2.SpeedDown2Excel(-1, true, true,"","",false,false,getSheetNameOfExcel("AFTER"));
    * <pre>
    * </pre>
    * 
    * @param {string} type 필수, 필요한 이름이 simulation된것인지 아닌지 code값
    * @return string, 엑셀의 sheet의 이름
    */        
 	function getSheetNameOfExcel(type){
 		var sheetName = SHEET_TITLE[document.form.frm_profit_level.Code];
 		if( type == "BEFORE"){
 			sheetName += " (Before Simulation)";
 		}else if( type == "AFTER"){
 			sheetName += " (After Simulation)";
 		}
 		return sheetName;
 	}    
 	
    /**  
    * frm_pfmc_unit이 click 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @return 없음
    */   
 	function frm_pfmc_unit_OnClick(){
 		var obj = window.event.srcElement;
 		var value = ComPriGetCheckedRadioButtonValue(obj)
 		//PFMC Unit의 선택 내용에 따라 Sheet의 Unit(TEU/FEU) 내용을 바꾼다.
  		changeUnitText(value) ;
 	}
 	
    /**  
    *  Unit의 값(TEU,FEU)에 따라 화면의 title을 변경한다. 
    *  
    * <br><b>Example :</b>
    * <pre>
    * 	changeUnitText(value);
    * </pre>
    * 
    * @param {string} value 필수, Unit Value 
    * @return 없음
    */   
 	function changeUnitText(value){
  		document.getElementById("unit_text").innerText = UNIT_TEXT[value];
 	}
 	
    /**  
    *  Unit의 값(TEU,FEU)에 따라 화면의 title을 변경한다. 
    *  
    * <br><b>Example :</b>
    * <pre>
    * 		changeSheetTitle(value);
    * </pre>
    * 
    * @param {string} value 필수, Unit Value 
    * @return 없음
    */    	
 	function changeSheetTitle(value){
  		document.getElementById("sheet_title").innerText = SHEET_TITLE[value];
 	}
 	
    /**  
    * frm_profit_view의 값이 변경 되었을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @param {object} comboObj 필수, IBMultiCombo Object
    * @param {string} code 필수, 선택된 Code값
    * @param {string} name 필수, 선택된 text값
    * @return 없음
    */  
 	function frm_profit_view_OnChange(comboObj,code,name){
 		var formObj = document.form;
 		var oriCode = formObj.frm_profit_level.Code;
 		formObj.frm_profit_level.removeAll();
 		//Profit View가 Office Profit이면 
    	//Profit Level에 CM,OP가 보이고 Trade Profit이면 CM만 보이도록 한다.
 		if( code == "P"){//trade office
 			ComPriTextCode2ComboItem(ComReplaceStr(cmOpComboValue,"|O",""),ComReplaceStr(cmOpComboText,"|OP",""), formObj.frm_profit_level ,"|","\t" ,1);
 			formObj.frm_profit_level.Code = "C";
 		}else{
 			ComPriTextCode2ComboItem(cmOpComboValue,cmOpComboText, formObj.frm_profit_level ,"|","\t" ,1);
 			formObj.frm_profit_level.Code = oriCode;
 		}
 		//Profit View와 Profit Level의 값에 맞춰 sheet의 column 값을 다르게 보이도록 한다.
 		changeColHidden(document.form.frm_summary_items,sheetObjects[0]);
 		changeColHidden(document.form.frm_summary_items,sheetObjects[1]);
 	}
 	
    /**  
    * Code 값에 따라 summary items 의 list 값을 바꾼다.
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * 		changeSummaryItems(code)
    * </pre>
    * 
    * @param {string} code 필수, CM,OP 의 Code값
    * @return 없음
    */  
 	function changeSummaryItems(code){
 		var formObj = document.form;
 		var itemCombo = formObj.frm_summary_items;
 		var codes = itemCombo.Code;
 		itemCombo.RemoveAll();

 		if( code == "C"){
 			ComPriTextCode2ComboItem(summaryComboForCmValue,summaryComboForCmText, itemCombo,"|","\t",1);
 		}else{
 			ComPriTextCode2ComboItem(summaryComboForOpValue,summaryComboForOpText, itemCombo,"|","\t",1);
 		}
 		itemCombo.Code = codes;
 	}
 	
    /**  
    *  CM/OP 구분 Code에 따라 화면의 title을 변경한다. 
    *  
    * <br><b>Example :</b>
    * <pre>
    * 		changeTitle(code);
    * </pre>
    * 
    * @param {string} code 필수, CM/OP 구분 Code 
    * @return 없음
    */  
 	function changeTitle(code){
 		var titleText = document.getElementById("title").innerText;
 		
 		if(titleText.indexOf("CM/OP") >= 0){
 			titleText = titleText.substring(titleText.indexOf("CM/OP")+5 );
 		}else if(titleText.indexOf("CM") >= 0){
 			titleText = titleText.substring(titleText.indexOf("CM")+2 );
 		}else if(titleText.indexOf("OP") >= 0){
 			titleText = titleText.substring(titleText.indexOf("OP")+2 );
 		}
		if( code == "C"){
			titleText = "  CM" + titleText;
		}else{
			titleText = "  OP" + titleText;
		}
 		document.getElementById("title").innerText = titleText;
 	}
 	
   /**  
    * frm_summary_items의 check를 선택했을 경우의 이벤트처리
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * 
    * @param {object} comboObj 필수, IBMultiCombo Object
    * @param {string} index 필수, 클릭한 아이템의 인덱스 
    * @param {string} code 필수, 클릭한 아이템의 코드
    *
    * @return 없음
    */   
    function frm_summary_items_OnCheckClick(comboObj,index,code){
    	if( code == "A"){
    		comboObj.Code2 = -1;
    		comboObj.Code2 = "A";
    	}else{
    		// All이 아닌 값이 check되었다면 All은 uncheck한다.
    		comboObj.CheckCode("A") = false;
    	}
    	//summary items 값에 따라 다른 내용을 보여준다.
    	changeColHidden(comboObj,sheetObjects[0]);
    	changeColHidden(comboObj,sheetObjects[1]);
    }
    
    
    
 	/** 
    * 현재 화면의 데이터 상태를 고려해 버튼들의 상태를 바꾼다.
	 * <br><b>Example :</b>
	 * <pre>
	 *      changeButtonStatus();
	 * </pre>
	 * @return 없음
	 */  
    function changeButtonStatus(){
		ComBtnDisable("btn1_Simulation");
		ComBtnDisable("btn1_Revenue_Detail");
		ComBtnDisable("btn1_Chart");
		ComBtnDisable("btn1_Down_Excel");
    
    	var cnt =  sheetObjects[0].RowCount;
    	//조회된 내용이 없다면 버튼들을 비활성화 상태로 둔다.
    	if( cnt == 0 ){
    		return;
    	}
    	ComBtnEnable("btn1_Simulation");
    	ComBtnEnable("btn1_Chart");
    	ComBtnEnable("btn1_Down_Excel");
    	//revenue detail 화면은 특정 계약에 대한 상세 내용이기 때문에
    	//특정 row를 선택해야만 활성화 시킨다.
    	if( sheetObjects[0].SelectRow > 0 ){
    		ComBtnEnable("btn1_Revenue_Detail");
    	}
    }
    
 	/** 
    *  로그인 사용자의 권한을 체크해 버튼의 비활성화 활성화를 변경
    *  
	 * <br><b>Example :</b>
	 * <pre>
	 *      checkAuthRequestOffice();
	 * </pre>
	 * @return 없음
	 */  
    function checkAuthRequestOffice(){
        var formObj = document.form;
        var code = authCode;
        var obj = document.getElementById("frm_prop_ofc_cd");
        var reqOfcCd = formObj.req_ofc_cd.value;
        // 로그인한 사용자의 request office가 아래와 같으면 승인권자임.
        // SELCAM, HAMUKG, NYCNKG, SINWKG 코드 추가 2012.08.09 송호진
        // HAMUKG, NYCNKG, SINWKG 코드 제외 2012.09.18 송호진
        // CAM -> CCM, CTA -> CCA, CTE,CTI -> CCE, COS -> CCS, CGS -> CCB 코드 병행 관련 수정  2013.06.14 송호진
        if( reqOfcCd == "SELCGM"
            || reqOfcCd == "NYCRAS"
            || reqOfcCd == "HAMRUS"
            || reqOfcCd == "SHARCS"
            || reqOfcCd == "SINRSS"
            || reqOfcCd == "SELCMS"
            || reqOfcCd == "SELCMA"
            || reqOfcCd == "SELCMU"
            ){ // 승인권자
        	obj.setAttribute("className","input")
        	obj.readOnly = false
        	obj.value = "";
        }else if(code == "S"  || code == "A" ){
        	obj.setAttribute("className","input2")
        	obj.readOnly = true;
        	// sales rep 같은 경우 MDM_SLS_REP table의 OFC_CD값을 request office값으로 이용한다.
        	if(authReqOfcCd == "" ){
        		obj.value = reqOfcCd;
        	}else{        	
        		obj.value = authReqOfcCd;
        	}
        	searchSalesRepOffice();
        }else{
        	//일반사용자는 아무것도 조회 할수 없다.
           	disableButton("btn1_Simulation");
        	disableButton("btn1_Revenue_Detail");
        	disableButton("btn1_Chart");
        	disableButton("btn1_Down_Excel");
        	disableButton("btn1_Retrieve")
        	
        }
      
    }
	 
	 

    /** 
     * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
     * 
     * <br><b>Example :</b>
     * <pre>
     *      sheet6LoadEnd(sheetObj)
     * </pre>
     * 
     * 
     * @return 없음
     */              
    function getBackEndJobStatus() {
    	var form = document.form;	
		var sheetObj = sheetObjects[1];
    	form.f_cmd.value = SEARCH03;
    	//Backend job을 실행할때 저장해 놓은 key 값으로 해당 backend job의 상태를 조회한다.
    	var sXml = sheetObj.GetSearchXml("ESM_PRI_6024GS.do", "f_cmd="+SEARCH03+"&backendjob_key="+BACKEND_JOB_ID);
    	var jobStatus = ComGetEtcData(sXml, "jb_sts_flg");
    	//backend job의 성공
    	if (jobStatus == "3") { // Backend job 조회 성공
    		//조회된 xml을 로딩한다.
    		getBackEndJobLoadFile(TIMER_ID);
    		//더이상 getBackEndJobStatus이 반복 호출 되지 않도록 Interval을 clear한다. 
    		clearInterval(TIMER_ID);
    	} else if (jobStatus == "4") { // BackEndJob을 실패 하였습니다.
    		
    		ComShowCodeMessage("PRI00338"); //msgs['PRI00338'] = 'Failed to download. Please try again.';
    	    clearInterval(TIMER_ID);	
    		ComOpenWait(false);	
    	} else if (jobStatus == "5") {// Backend job 조회 및 download 성공
    		
    		ComShowCodeMessage("PRI00339"); //msgs['PRI00339'] = 'Data was downloaded successfully.';
    		clearInterval(TIMER_ID);
    		ComOpenWait(false);	
    	}
    }
    /** 
    * BackEndJob이 완료 된후 그 결과를 sheet에 loading한다.<BR>
    * 
    * <br><b>Example :</b>
    * <pre>
    *      getBackEndJobLoadFile(id)
    * </pre>
    * 
    * @param {string} objId 필수, backend job이 여러 종류이기 때문에 이 id에 따라 load할 sheet를 다르게 한다. 
    * @return 없음
    */          
    function getBackEndJobLoadFile(objId) {
		var form = document.form;
		var sheetObj = sheetObjects[0];
		var sheetObj1 = sheetObjects[1];
		form.f_cmd.value = SEARCHLIST;
		//backend job key를 이용해서 서버에 조회되어 있는 xml의 조회를 요청한다.
		var sXml = sheetObj1.GetSearchXml("ESM_PRI_6024GS.do", "f_cmd="+SEARCHLIST+"&backendjob_key="+BACKEND_JOB_ID);		
		switch(ARRAY_BACKENDJOB_TYPE[objId]) {
		case IBSEARCH:      //조회
			//조회된 xml을 loading한다.
			sheetObj.LoadSearchXml(sXml);
			// simulation 후 download excel시 Before sheet의 를 내려주기 위한 sheet
		 	sheetObjects[1].LoadSearchXml(sXml);	
			ComOpenWait(false);		
		 	
		 	break;
		}

    }	 
    
    
    
    /** 
     * sheet를 sort했을때 자동 호출됨 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {String} col 필수, sort된 col
     * @param {String} sortArrow 필수, 소트 방향 문자열, "ASC","DESC"
     * @return 없음
     */        
    function sheet1_OnSort(sheetObj,col,sortArrow){
    	var colName = sheetObj.ColSaveName(col);
    	//화면에서 sheet를 sort하면 excel download를 위해 숨겨둔 sheet도 동일하게 sort를 시켜 준다.
    	//그렇지 않으면 excel download시 sort가 불일치 한다.
    	sheetObjects[1].ColumnSort(colName, sortArrow)
    }
    
    
    /** 
    * IBSheet Bug로 인해 sum row의 font color를 변경시켜줘야 한다.
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @return 없음
    */        
    function changeSheetSumFontColor(sheetObj){
    	
 		sheetObj.CellFontColor(sheetObj.LastRow,"load_new") = sheetObj.RgbColor(37,35,65);//sum font color
 		sheetObj.CellFontColor(sheetObj.LastRow,"g_rev") = sheetObj.RgbColor(37,35,65);//sum font color
 		sheetObj.CellFontColor(sheetObj.LastRow,"cost_new_cm_office") = sheetObj.RgbColor(37,35,65);//sum font color
 		sheetObj.CellFontColor(sheetObj.LastRow,"cost_new_cm_trade") = sheetObj.RgbColor(37,35,65);//sum font color
 		sheetObj.CellFontColor(sheetObj.LastRow,"cost_new_op_office") = sheetObj.RgbColor(37,35,65);//sum font color
 		sheetObj.CellFontColor(sheetObj.LastRow,"cmpb_new_office") = sheetObj.RgbColor(37,35,65);//sum font color
 		sheetObj.CellFontColor(sheetObj.LastRow,"cmpb_new_trade") = sheetObj.RgbColor(37,35,65);//sum font color
 		sheetObj.CellFontColor(sheetObj.LastRow,"cm_new_office") = sheetObj.RgbColor(37,35,65);//sum font color
 		sheetObj.CellFontColor(sheetObj.LastRow,"cm_new_trade") = sheetObj.RgbColor(37,35,65);//sum font color
 		sheetObj.CellFontColor(sheetObj.LastRow,"opb_new") = sheetObj.RgbColor(37,35,65);//sum font color
 		sheetObj.CellFontColor(sheetObj.LastRow,"op_new") = sheetObj.RgbColor(37,35,65);//sum font color
    }
    
//    function frm_svc_scp_cd_OnChange(obj){
//    	alert("1")
//    	var formObj = document.form;
//	    if( !validateRoute(formObj.frm_ori_rout_cd.value,"POPUP") ){
//			formObj.frm_ori_rout_cd.value = "";
//			formObj.frm_ori_loc_tp.value = "";
//		}
//	    if( !validateRoute(formObj.frm_dest_rout_cd.value,"POPUP") ){
//			formObj.frm_dest_rout_cd.value = "";
//			formObj.frm_dest_loc_tp.value = "";
//		}	    
//    }

	/* 개발자 작업  끝 */