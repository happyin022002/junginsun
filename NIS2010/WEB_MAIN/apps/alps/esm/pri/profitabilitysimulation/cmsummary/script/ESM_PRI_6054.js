/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6054.js
*@FileTitle : CM/OP Summary & Simulation History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.13 송민석
* 1.0 Creation
=========================================================
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
     * @class ESM_PRI_6054 : ESM_PRI_6054 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6054() {
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
 var SHEET_TITLE = new Array();
 UNIT_TEXT["FEU"] = "[Unit: FEU/USD]";
 UNIT_TEXT["TEU"] = "[Unit: TEU/USD]";
 SHEET_TITLE["C"] = "CM Summary History";
 SHEET_TITLE["O"] = "OP Summary History";
 
 // 공통전역변수

 var sheetObjects = new Array();
 var sheetCnt = 0;

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

            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }
            
 			switch(srcName) {
 				case "btn1_Retrieve":
 					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
                     break; 
 				case "btn1_Down_Excel":
 					var msgStr = ComGetMsg("PRI03002");
 			    	if(sheetObject1.RowCount == 0 )
 			    		return;
 			 
 			     	execScript("rtn = Msgbox(\"" + ComReplaceStr(msgStr,"\n","\" & Chr(13) & \"") + "\", 3, \"Download Excel\")", "vbscript");
 			    	if (rtn == 6) {
 			    		showColumns(sheetObject1,"cust_tp_cd|prop_apro_ofc_cd|respb_srep_cd");
 			    		sheetObject1.SpeedDown2Excel(-1, false, false);
 			    		hideColumns(sheetObject1,"cust_tp_cd|prop_apro_ofc_cd|respb_srep_cd");
 			    	} else if (rtn == 7) {
 			    		showColumns(sheetObject1, "cust_tp_cd|prop_apro_ofc_cd|respb_srep_cd" );
 			    		sheetObject1.Down2Excel(-1, false, false, true);
 			    		hideColumns(sheetObject1,"cust_tp_cd|prop_apro_ofc_cd|respb_srep_cd");
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
         		case "btn2_DownExcel":
         			ComPriShowDialogExcel(sheetObject1,ComGetMsg("PRI03002"));
                	break;      
                	
 				case "btn1_New":
					 resetAllObjects();
					changeButtonStatus();
					checkAuthRequestOffice();
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
    	  var formObj = document.form;
          for(i=0;i<sheetObjects.length;i++){
  			//khlee-시작 환경 설정 함수 이름 변경
              ComConfigSheet (sheetObjects[i] );
              initSheet(sheetObjects[i],i+1);
  			//khlee-마지막 환경 설정 함수 추가
              ComEndConfigSheet(sheetObjects[i]);
          }

          hideColumns(sheetObjects[0],"cust_tp_cd|svc_scp_cd|prop_apro_ofc_cd|respb_srep_cd");
          initControl();
          initCombo();
          resetAllObjects();
          changeColHidden(sheetObjects[0]);
          changeButtonStatus();
  		  changeUnitText(ComPriGetCheckedRadioButtonValue(formObj.frm_pfmc_unit)) ;
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
	    axon_event.addListener('click', 'frm_pfmc_unit_OnClick', 'frm_pfmc_unit');
        axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);               
  
	    axon_event.addListener('mouseover', 'frm_cust_nm_OnMouseOver', 'frm_cust_nm');  
        axon_event.addListener('mouseout', 'frm_cust_nm_OnMouseOut', 'frm_cust_nm');
        
        axon_event.addListener('blur', 'frm_ctrt_eff_dt_OnBlur', 'frm_ctrt_eff_dt');  
	    axon_event.addListener('blur', 'frm_ctrt_exp_dt_OnBlur', 'frm_ctrt_exp_dt');  
	    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	    
	    
   }    
    var oPopup = null;
    /** 
     * frm_cust_nm 의 Mouse Over Event 시 호출 <BR>
     * 
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
    * 
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
		formObj.frm_profit_view.Index2=1;
		formObj.frm_profit_level.Index2="0";
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
         switch(sheetObj.id) {
              case "sheet1":      //sheet1 init
                 with (sheetObj) {
                  // 높이 설정
                  style.height = 220;
                 //전체 너비 설정
                  SheetWidth = mainTable.clientWidth;

                  //Host정보 설정[필수][HostIp, Port, PagePath]
                  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                  //전체Merge 종류 [선택, Default msNone]
                  MergeSheet = msPrevColumnMerge;

                 //전체Edit 허용 여부 [선택, Default false]
                  Editable = true;

                  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                  InitRowInfo(1, 1, 15, 100);

                  var HeadTitle1 = "|Seq.|PROP_NO|Contract|Customer Name|Customer Type|Approval Office|Request\nOffice|Sales Rep.|Contract Basis|Contract No.|Duration|MQC/Target MVC\n(Contract)|Load/Performance\n(Estimate)|Est. CMPB|Est. CMPB|Est. CM|Est. CM|Est. OPB|Est. OP|amdt_seq|sc_no";
					var headCount = ComCountHeadTitle(HeadTitle1);
                  
		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                  InitColumnInfo(headCount, 5, 0, true);

                  // 해더에서 처리할 수 있는 각종 기능을 설정한다
                  InitHeadMode(true, true, false, true, false,false)

                  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                  InitHeadRow(0, HeadTitle1, true);

                  //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
                  
                 
	                
					InitDataProperty(0, cnt++ , dtData,		40,   	daCenter,  	true,	"seq",   false,  "",      dfNone,    0,false,       true);
					InitDataProperty(0, cnt++ , dtHidden,    	60,   	daLeft,  	true,	"prop_no",   	false,   "",      dfNone,    0,false,       true);

					InitDataProperty(0, cnt++ , dtData,    	60,   	daLeft,  	true,	"contract_nm",   	false,   "",      dfNone,    0,false,       true);
					InitDataProperty(0, cnt++ , dtData,    	200,   	daLeft,  	true,	"cust_nm",   	false,   "",      dfNone,    0,false,       true);

					InitDataProperty(0, cnt++ , dtData,    	60,   	daLeft,  	true,	"cust_tp_cd",   	false,   "",      dfNone,    0,false,       true);

					InitDataProperty(0, cnt++ , dtData,    	140,   	daLeft,  	true,	"prop_apro_ofc_cd",   	false,   "",      dfNone,    0,false,       true);

					InitDataProperty(0, cnt++ , dtData,    	140,   	daLeft,  	true,	"prop_ofc_cd",   	false,   "",      dfNone,    0,false,       true);
					InitDataProperty(0, cnt++ , dtData,    	140,   	daLeft,  	true,	"respb_srep_cd",   	false,   "",      dfNone,    0,false,       true);

					InitDataProperty(0, cnt++ , dtData,    	100,   	daLeft,  	false,	"contract_basis",   	false,   "",      dfNone,    0,false,       true);
					InitDataProperty(0, cnt++ , dtData,    	100,   	daLeft,  	false,	"contract_no",   	false,	"",      dfNone,     2,false,       true);
					InitDataProperty(0, cnt++ , dtData, 	160,   	daCenter,  	false,	"duration",   	false,	"",      dfNone,     2,false,       true);
					
					InitDataProperty(0, cnt++ , dtAutoSum,   130,   daRight,  	false,	"prop_mqc_qty",   	false,	"",  	dfNullFloat, 1,false,       true);
					InitDataProperty(0, cnt++ , dtAutoSum,   130,   daRight,  	false,	"load",   	false,	"",  	dfNullFloat, 1,false,       true);
					InitDataProperty(0, cnt++ , dtAutoSum,   130,   daRight,  	false,	"cmpb_office",   	false,	"",  	dfNullFloat, 2,false,       true);
					InitDataProperty(0, cnt++ , dtAutoSum,   100,   daRight,  	false,	"cmpb_trade",   	false,	"",  	dfNullFloat, 2,false,       true);
					InitDataProperty(0, cnt++ , dtAutoSum,   100,   daRight,  	false,	"cm_office",   	false,	"",  	dfNullInteger, 2,false,       true);
					InitDataProperty(0, cnt++ , dtAutoSum,   100,   daRight,  	false,	"cm_trade",   	false,	"",  	dfNullInteger, 2,false,       true);
					InitDataProperty(0, cnt++ , dtAutoSum,   100,   daRight,  	false,	"opb",   	false,	"",  	dfNullFloat, 2,false,       true);
					InitDataProperty(0, cnt++ , dtAutoSum,   100,   daRight,  	false,	"op",   	false,	"",  	dfNullInteger, 2,false,       true);
					InitDataProperty(0, cnt++ , dtHidden,   100,   daRight,  	false,	"amdt_seq",   	false,	"",  	dfNone, 2,false,       true);
					InitDataProperty(0, cnt++ , dtHidden,   100,   daRight,  	false,	"sc_no",   	false,	"",  	dfNone, 2,false,       true);
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
   		        sheetObj.DoSearch("ESM_PRI_6054GS.do", FormQueryString(formObj) );
                 break;

 			case IBSEARCH_ASYNC01:        //Customer Search Popup
	        	var sUrl = "ESM_PRI_6029.do?";
 				var params = new Array();  	  		
	  	  		params["cust_list"] = formObj.frm_cust_list.value;
	  	  		window.Params = params;
				var rtnVal = ComOpenWindowCenter(sUrl, "ESM_PRI_6029", 900, 450, true);
				if( rtnVal != undefined ){
					formObj.frm_cust_list.value = rtnVal.custList;
					formObj.frm_cust_nm.value = rtnVal.custNameList;
				}
	        	break;
	
 			
         }
     }
    /** 
     * sheet의 모든 proposal number list를 '|'연결한 string을 만든다.
	 * <br><b>Example :</b>
	 * <pre>
	 *      params["prop_no_list"] = getPropNoList(sheetObj); //결과 "AWN25607|AEF25900|AEF25903|AEF25905"
	 * </pre>
	 * 
	 * @param {object} sheetObj 필수, sheet Object
	 * @return string, sheet의 모든 proposal number list를 '|'연결한 string
	 */    
   function getPropNoList(sheetObj){
	   var list = "";
	   for( var i = sheetObj.HeaderRows  ; i < sheetObj.LastRow; i++ ){
		   
	   	   if( i != sheetObj.HeaderRows ){
	   		list += "|";
	   	   } 
	   	   list += sheetObj.CellValue(i , "prop_no");
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
    * @param {object} formObj 필수, html document form Object
    * @return 없음
    */   
   function initCombo(){
       var formObj = document.form; 
 
   
       
       
       customerTypeComboValue = ComReplaceStr(customerTypeComboValue,"|M",""); 
       customerTypeComboText = ComReplaceStr(customerTypeComboText,"|M	BOTH","");  
       
	   ComPriTextCode2ComboItem(svcScpComboValue,svcScpComboText, formObj.frm_svc_scp_cd ,"|","\t" );
	   ComPriTextCode2ComboItem("|"+appOfcCdComboValue,"	|"+appOfcCdComboText, formObj.frm_prop_apro_ofc_cd ,"|","\t",0 );
	   
	   ComPriTextCode2ComboItem(profitViewComboValue,profitViewComboText, formObj.frm_profit_view ,"|","\t",1 );
	   ComPriTextCode2ComboItem(cmOpComboValue,cmOpComboText, formObj.frm_profit_level ,"|","\t" ,1);
	   ComPriTextCode2ComboItem("M|"+customerTypeComboValue,"\t|"+customerTypeComboText, formObj.frm_customer_type ,"|","\t",1 );
	   
	   formObj.frm_profit_view.Index = 1;
	   formObj.frm_profit_level.Index = 0;
 
  
	   
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
       var sheetObj = sheetObjects[0];
       formObj.f_cmd.value = SEARCH15;
       sheetObj.WaitImageVisible = false;
       var sParam = FormQueryString(formObj)+"&etc1="+cd;
       sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
       ComPriXml2ComboItem(sXml, formObj.frm_prop_srep_cd, "cd", "cd|nm");
       formObj.frm_prop_srep_cd.InsertItem(0,"","");
       sheetObj.WaitImageVisible = true;
       formObj.frm_prop_srep_cd.focus();
   }
   
   
   
   /**  
   *  Summary Item의 값에 따라 sheet의 특정필드들을 가변적으로 보여준다.<BR>
   *  
   * <br><b>Example :</b>
   * <pre>
   *   changeColHidden(formObj.frm_summary_items,sheetObjects[0]);
   * </pre>
   * @param {object} sheetObj 필수, sheet Object
   * @return 없음
   */    
   function changeColHidden(sheetObj){
	   var formObj = document.form;
	   var colList = "";
	   var profit_view = formObj.frm_profit_view.Code;
	   var profit_level = formObj.frm_profit_level.Code;
	   
	   
	   hideColumnsRange(sheetObjects[0],"cmpb_office","op");
	   
 
	   if(profit_level== "C" ){ //CM
		   if( profit_view == "P"){ // Trade Profit
			   colList = "cm_trade|cmpb_trade"; 
		   }else{ //"R" Office Profit
			   colList = "cm_office|cmpb_office"; 
		   }
	   }else{//OP
		   if( profit_view == "P"){ // Trade Profit
			   colList = "cm_trade|cmpb_trade|opb|op"; 
		   }else{ //"R" Office Profit
			   colList = "cm_office|cmpb_office|opb|op"; 
		   }
	   }
	 
	   
	   showColumns(sheetObjects[0],colList);
		 
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
        
    	//changeSrepText(comboObj);
    }   
    /**  
    * Combo에서 Sales Rep. 이름을 읽어 화면에 표시 해줌<BR>
    * 
    *  
    * <br><b>Example :</b>
    * <pre>
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
 		with(sheetObj){
 			/*토탈 라인 합쳐지기. */
     		var row = LastRow;
 			var startCol = SaveNameCol("seq");
 			var endCol = SaveNameCol("Customer");
 				
 			for (var j = startCol; j <= endCol; j ++){
 				SumText(0, j) = "Total";
 			}
 			RowMerge(row) = true;
     	}
 		changeButtonStatus();
 		setSearchedValues(false);
 		changeSheetSumValues(sheetObj);
 		sheetObj.ColFontColor("contract_no") = sheetObj.RgbColor(100,100,255);
 		sheetObj.ColFontUnderline("contract_no") = true;
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
 		case "contract_no" :
 			sheetObj.MousePointer = "Hand";

 			break;
 		default :
 			sheetObj.MousePointer = "Default";
 			break;
 		}
 	}
 	
    /** 
    * sheet를 마우스 더블클릭 했을경우 자동 호출됨 
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
 		case "contract_no" :
 			var contract_nm = sheetObj.CellValue(row,"contract_nm");
 			var contract_basis = sheetObj.CellValue(row,"contract_basis");
 			var parentPgmNo = "";
 			var src = "";
 			if(contract_nm =="SC"){
 				if(contract_basis == "Quotation"){
 		 			var pgmNo = "ESM_PRI_6005";
 		 			var contract_no = sheetObj.CellValue(row,"contract_no");
 		 			var qttn_ver_no = contract_no.substring(10);
 		 			var qttn_no = contract_no.substring(0,10)
 		 			var pgmUrl = "/hanjin/ESM_PRI_6005.do"
 					parentPgmNo = pgmNo.substring(0, 8)+'M001';   
 		 			src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&qttn_no="+qttn_no;
 				}else if(contract_basis == "Proposal"){
 		 			var pgmNo = "ESM_PRI_0003";
 		 			var prop_no = sheetObj.CellValue(row,"prop_no");
 		 			var amdt_seq = sheetObj.CellValue(row,"amdt_seq");
 		 			var pgmUrl = "/hanjin/ESM_PRI_0003.do"
 					parentPgmNo = pgmNo.substring(0, 8)+'M001';   
 		 			src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&prop_no="+prop_no; 					
 				}else if(contract_basis == "Amendment"){
 		 			var pgmNo = "ESM_PRI_0057";
 		 			var sc_no  = sheetObj.CellValue(row,"sc_no");
 		 			var pgmUrl = "/hanjin/ESM_PRI_0057.do"
 					parentPgmNo = pgmNo.substring(0, 8)+'M001';   
 		 			src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&sc_no_0062="+sc_no;
 				}
 			}else if(contract_nm =="RFA"){
 				if(contract_basis == "Quotation"){
 		 			var pgmNo = "ESM_PRI_6014";
 		 			var contract_no = sheetObj.CellValue(row,"contract_no");
 		 			var qttn_ver_no = contract_no.substring(10);
 		 			var qttn_no = contract_no.substring(0,10)
 		 			var pgmUrl = "/hanjin/ESM_PRI_6014.do"
 					parentPgmNo = pgmNo.substring(0, 8)+'M001';   
 		 			src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&qttn_no="+qttn_no;
 				}else if(contract_basis == "Proposal"){
 		 			var pgmNo = "ESM_PRI_2003";
 		 			var prop_no = sheetObj.CellValue(row,"prop_no");
 		 			var amdt_seq = sheetObj.CellValue(row,"amdt_seq");
 		 			var pgmUrl = "/hanjin/ESM_PRI_2003.do"
 					parentPgmNo = pgmNo.substring(0, 8)+'M001';   
 		 			src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&cond_prop_no="+prop_no; 					
 				}else if(contract_basis == "Amendment"){
 		 			var pgmNo = "ESM_PRI_2041";
 		 			var sc_no  = sheetObj.CellValue(row,"sc_no");
 		 			var pgmUrl = "/hanjin/ESM_PRI_2041.do"
 					parentPgmNo = pgmNo.substring(0, 8)+'M001';   
 		 			src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&rfa_no_2043="+sc_no;
 				}
 			}
			var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
			var winObj = window.open("alpsMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);   
			var parentPgmNo = pgmNo.substring(0, 8)+'M001';
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
 			
 			formObj.searched_contract_type.value =   ComPriGetCheckedRadioButtonValue(formObj.frm_contract_type);
 			formObj.searched_pfmc_unit.value =       ComPriGetCheckedRadioButtonValue(formObj.frm_pfmc_unit);
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
 			
 		}else{
 			formObj.searched_svc_scp_cd.value = "";
 			formObj.searched_prop_apro_ofc_cd.value = "";
 			formObj.searched_customer_type.value = "";
 			
 			formObj.searched_contract_type.value = "";
 			formObj.searched_pfmc_unit.value = "";
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
 		}
 	}
 	
    /**  
    * frm_profit_level의 값이 변경 되었을 경우의 이벤트처리
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
 		
 		changeColHidden(sheetObjects[0]);
 		changeTitle(code);
 		changeSheetTitle(code)
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
 		if( code == "P"){//trade office
 			ComPriTextCode2ComboItem(ComReplaceStr(cmOpComboValue,"|O",""),ComReplaceStr(cmOpComboText,"|OP",""), formObj.frm_profit_level ,"|","\t" ,1);
 		formObj.frm_profit_level.Code = "C";
 		}else{
 			ComPriTextCode2ComboItem(cmOpComboValue,cmOpComboText, formObj.frm_profit_level ,"|","\t" ,1);
 			formObj.frm_profit_level.Code = oriCode;
 		}    	
 		changeColHidden(sheetObjects[0]);
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
    * 현재 화면의 데이터 상태를 고려해 버튼들의 상태를 바꾼다.
	 * <br><b>Example :</b>
	 * <pre>
	 *      changeButtonStatus(sheetObjects[0]);
	 * </pre>
	 * @param {object} sheetObj 필수, sheet Object
	 * @return 없음
	 */  
    function changeButtonStatus(){
    	disableButton("btn1_Down_Excel");
    
    	var cnt =  sheetObjects[0].RowCount;
    	if( cnt == 0 ){
    		return;
    	}
    	enableButton("btn1_Down_Excel");
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
 	
 		var COL_LOD = "load";
 		var COL_CM_OFFICE = "cm_office";
 		var COL_CMPB_OFFICE = "cmpb_office";
 		var COL_CM_TRADE = "cm_trade";
 		var COL_CMPB_TRADE = "cmpb_trade";		
 	 	var COL_OP = "op";
 		var COL_OPB = "opb"; 
 		
 		
 		//OP
 		calcBottomCmpbOpb(sheetObj,COL_LOD,COL_OP,COL_OPB);
 		
 		//CM
 		calcBottomCmpbOpb(sheetObj,COL_LOD,COL_CM_OFFICE,COL_CMPB_OFFICE);
 		calcBottomCmpbOpb(sheetObj,COL_LOD,COL_CM_TRADE,COL_CMPB_TRADE);
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
   	   if( lod_qty == 0 || lod_qty == ""){
   		   rslt = 0
   	   }else{
   		   rslt = cm_amt / lod_qty;
   	   }
   	   //alert("load="+lod_qty+",cm_amt="+cm_amt+",rslt="+rslt)
   	   sheetObj.SumValue(0,COL_CMPB) = rslt;
      }    
    
	/* 개발자 작업  끝 */