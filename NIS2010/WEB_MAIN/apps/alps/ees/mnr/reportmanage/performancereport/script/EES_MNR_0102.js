/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0102.js
*@FileTitle : Total Loss Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.10.06 민정호
* 1.0 Creation	
* --------------------------------------------------------
* 2012.02.27 신혜정 [CHM-201216419] 검색 조건 Payer Type 추가, 그리드 Payer Type 항목 추가
* 2012.04.17 신혜정 [CHM-201217368] 조회 조건 SCAC code 추가.
*                                   멀티 입력 가능 팝업창 호출.
*                                   Payer Type 조건 삭제
* 2012.04.25 신혜정 [CHM-201217484] Performance 조회 결과 3rd party 의 payer name 항목 추가  
* 2012.05.02 신혜정 [CHM-201217379] 검색조건 buyer Code 추가 , 그리드 buyer name 항목 추가 
* 2013.02.13 조경완 [CHM-201322896-01] ALPS MNR-Total Loss Logic 검토 및 수정 요청  
* 2013-12-31 한종희 [CHM-201328247] Total loss performance module 내 Insurance&scarp 항목 삭제 요청
* 2014-01-08 Jonghee HAN [CHM-201328248] Performance조회시 Recovery 금액 반영 수정 요청                                 
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
     * @class EES_MNR_0102 : EES_MNR_0102 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0102() {
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
 
 var HOOfc = "";	
 var initLoader = 0;
 
 //콤보용 변수
 var mainRsnCd = "";
 var closeTpAll = "";

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
 							doActionIBSheet(sheetObject1,formObject,IBSEARCH);
 							break;
 						case "btn_New":
 							doActionIBSheet(sheetObject1,formObject,IBCLEAR);
 							break;
 						case "btn_Excel":
 							doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
 							break;
	   					case "cre_dt_cal":
	   						var cal = new ComCalendarFromTo();
	   						cal.select(formObject.fm_dt, formObject.to_dt, 'yyyy-MM-dd');       						
	   						break; 				
	   					case "eq_no_multi": 
	   					    rep_Multiful_inquiry("eq_no"); 
	   						break;    			
	   					case "tln_multi": 
	   					    rep_Multiful_inquiry("total_loss_no"); 
	   						break;	   
	   					case "usa_edi_cd_multi": 
	   					    rep_Multiful_inquiry("usa_edi_cd"); 
	   						break;  	   						
						case "btn_vndr":		      
							ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 450, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
							break;			  		
						case "btn_Detail":
							if(sheetObjects[0].RowCount>0)
							{
								
								var Row=sheetObjects[0].SelectRow;
								var ttl_lss_no=sheetObjects[0].CellValue(Row,"ttl_lss_no");
								var rqst_ofc_cd=sheetObjects[0].CellValue(Row,"rqst_ofc_cd");
								var apro_ofc_cd=sheetObjects[0].CellValue(Row,"apro_ofc_cd");
								var respb_ofc_cd=sheetObjects[0].CellValue(Row,"respb_ofc_cd");	
								var ttl_lss_dt=sheetObjects[0].CellValue(Row,"ttl_lss_dt");	
									ttl_lss_dt=ttl_lss_dt.substring(0,4)+ "-" + ttl_lss_dt.substring(4,6)+ "-" + ttl_lss_dt.substring(6,8);
								var rqst_dt=sheetObjects[0].CellValue(Row,"rqst_dt");	
									rqst_dt=rqst_dt.substring(0,4)+ "-" + rqst_dt.substring(4,6)+ "-" + rqst_dt.substring(6,8);
								var ttl_lss_sts_nm=sheetObjects[0].CellValue(Row,"ttl_lss_sts_nm");	
								var ttl_lss_rsn_nm=sheetObjects[0].CellValue(Row,"ttl_lss_rsn_nm");	
								var ttl_lss_dtl_rsn_nm=sheetObjects[0].CellValue(Row,"ttl_lss_dtl_rsn_nm");	
								
								var params="?ttl_lss_no="+ttl_lss_no;
								    params+="&rqst_ofc_cd="+rqst_ofc_cd;
								    params+="&apro_ofc_cd="+apro_ofc_cd;
								    params+="&respb_ofc_cd="+respb_ofc_cd;
								    params+="&ttl_lss_dt="+ttl_lss_dt;
								    params+="&rqst_dt="+rqst_dt;
								    params+="&ttl_lss_sts_nm="+ttl_lss_sts_nm;
								    params+="&ttl_lss_rsn_nm="+ttl_lss_rsn_nm;
								    params+="&ttl_lss_dtl_rsn_nm="+ttl_lss_dtl_rsn_nm;
								    
								ComOpenPopup("EES_MNR_0234.do"+params, 1040, 620, '', '1,0', true);
							}
							break;	
						case "btn_payer":		      
							ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 450, 'setPopDataPayer', '1,0,1,1,1,1,1,1', true);
							break;			
						case "btn_buyer":		      
							ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 450, 'setPopDataBuyer', '1,0,1,1,1,1,1,1', true);
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
  	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
  	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  	 * 배열은 소스 상단에 정의
  	 */ 
  	function setComboObject(combo_obj){    
      	comboObjects[comboCnt++] = combo_obj;  
  	} 
  	
     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {
  	    initControl();    	  
        for(i=0;i<sheetObjects.length;i++){
        	 //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i + 1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
        }
        //IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){ 
	        initCombo(comboObjects[k],k + 1);  
	    }	         
 	    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
     }

      /**   
     	 * Combo 기본 설정    
     	 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트. 
     	 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호 
     	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
     	 */     
     	function initCombo (comboObj, comboNo) {        
     	    var formObject = document.form
     	    switch(comboNo) {          	    
     	        case 1: 
     	           	with (comboObj) { 
             	   	SetColAlign("left|left");        
     		       	SetColWidth("80|100");      
     			   	DropHeight = 160;  
     				UseAutoComplete = true;
     		    	}      
     	        	break;      
     	        case 2: 
     	           	with (comboObj) { 
     				MultiSeparator = "|";
     				SetTitle("Office Code|Office Name");
             	   	SetColAlign("left|left");        
     				//SetColWidth("100|150"); 
     			   	DropHeight = 160;  
     				UseAutoComplete = true;
     		    	}      
     	        	break;    
     	        case 4: 
     	           	with (comboObj) { 
     				MultiSeparator = "|";
     				SetTitle("Office Code|Office Name");
             	   	SetColAlign("left|left");        
     				//SetColWidth("100|150");
     			   	DropHeight = 160;  
     				UseAutoComplete = true;
     		    	}      
     	        	break;
     	        case 5: 
     	           	with (comboObj) { 
             	   	SetColAlign("left|left");        
     		       	SetColWidth("80|100");      
     			   	DropHeight = 160;  
     				UseAutoComplete = true;
     		    	}      
     	        	break;   
     	        case 6: 
     	           	with (comboObj) { 
     	        	MultiSelect = true;
             	   	SetColAlign("left|left");        
     		       	SetColWidth("80|100");      
     			   	DropHeight = 160;  
     				UseAutoComplete = false;
     		    	}      
     	        	break;
     	        case 7:
     	        	break;
     	        case 8: //status
     	        	with (comboObj) {
     	        	MultiSelect = true;
     	        	}
     	        	break;
     	        case 9: //close type
    	        	with (comboObj) {
    	        	MultiSelect = true;
    	        	}
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
         switch(sheetID) {
            case "sheet1":
            	with (sheetObj) {
                    // 높이 설정
                    style.height = 382; 
                    //전체 너비 설정 
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly ;       

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true; 

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]	
                    InitRowInfo(2, 1, 6, 100);
						
					var HeadTitle1 = "|Seq.|TLL No.|TLL DT|REQ OFC|RES OFC|REQ DT|Status|Completion\nDT|Main Reason|Sub Reason|SCAC Code|Payer Name|Payer Type|Buyer Name|D.V Expense|D.V Expense|D.V Expense|D.V Expense|D.V Expense|D.V Expense|D.V Expense|3rd Party|3rd Party|3rd Party|3rd Party|Disposal|Disposal|Disposal|Disposal|Scrapping|Scrapping|Insurance(TT Club)|Insurance(TT Club)|EQ No|Close Type\nBy EQ|Close Date\nBy EQ";
					var HeadTitle2 = "|Seq.|TLL No.|TLL DT|REQ OFC|RES OFC|REQ DT|Status|Completion\nDT|Main Reason|Sub Reason|SCAC Code|Payer Name|Payer Type|Buyer Name|EQ Q'ty|D.V Value|Expense|Balance|Recovery Plan Total|Collection|Actual Balance|EQ Q'ty|Curr.|Amount|Amount\n(USD)|EQ Q'ty|Curr.|Amount|Amount\n(USD)|EQ Q'ty|Amount|EQ Q'ty|Amount|EQ No|Close Type\nBy EQ|Close Date\nBy EQ"; 
					var headCount = ComCountHeadTitle(HeadTitle1);
					
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 2, 4, 0, true);  
							
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)
									
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);  
                    InitHeadRow(1, HeadTitle2, true);  
					
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++,  dtHiddenStatus,		 	0,      daCenter,  	true,  		"ibflag");
					InitDataProperty(0, cnt++ , dtData,       			50,    	daCenter,  	true,  		"tmpseq",     					false,  "",    	dfNone     );      
                    InitDataProperty(0, cnt++ , dtData,					110,	daCenter,	true,		"ttl_lss_no",				false,	"",		dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	true,		"ttl_lss_dt",				false,	"",		dfDateYmd,		0,	false,	false);
                    
                    InitDataProperty(0, cnt++ , dtData,					60,		daLeft,		true,		"rqst_ofc_cd",				false,	"",		dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					60,		daLeft,		true,		"respb_ofc_cd",				false,	"",		dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	true,		"rqst_dt",					false,	"",		dfDateYmd,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					110,	daCenter,	true,		"ttl_lss_sts_nm",			false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	true,		"ttl_lss_cfm_dt",			false,	"",		dfDateYmd,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					80,		daLeft,		true,		"ttl_lss_rsn_nm",			false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					110,	daLeft,		true,		"ttl_lss_dtl_rsn_nm",		false,	"",		dfNone,		0,	false,	false);
    				InitDataProperty(0, cnt++ , dtData,					80,		daCenter,	true,		"usa_edi_cd",				false,	"",		dfNone,			0,	false,	false, 4);                    
    				InitDataProperty(0, cnt++ , dtData,					130,	daLeft,		true,		"payer_name",				false,	"",		dfNone,			0,	false,	false);                    
    				InitDataProperty(0, cnt++ , dtCombo,				90, 	daLeft,		true,		"ttl_lss_n3pty_tp_cd",		false,	"",		dfNone,		0,	false,	false);
    				InitDataProperty(0, cnt++ , dtData,					130,	daLeft,		true,		"buyer_name",				false,	"",		dfNone,			0,	false,	false);
    				
					//반복부
					InitDataProperty(0, cnt++ , dtData,					50,		daRight,	true,		"dv_eq_qty",				false,	"",		dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"dv_dv_val",				false,	"",		dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"dv_exp",					false,	"",		dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"dv_bal",					false,	"",		dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					120,	daRight,	true,		"dv_recovery",				false,	"",		dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					100,	daRight,	true,		"clt_amt",					false,	"|tp_exp|+|ds_exp|+|sc_exp|+|ir_exp|",		dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					100,	daRight,	true,		"dv_balance",				false,	"|dv_recovery|-|dv_exp|",		dfFloat,		2,	false,	false);
					
					InitDataProperty(0, cnt++ , dtData,					60,		daRight,	true,		"tp_eq_qty",				false,	"",		dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,		"tp_curr_cd",				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"tp_exp",					false,	"",		dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"tp_usd_exp",				false,	"",		dfFloat,		2,	false,	false);
					 
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"ds_eq_qty",				false,	"",		dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,		"ds_curr_cd",				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"ds_exp",					false,	"",		dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"ds_usd_exp",				false,	"",		dfFloat,		2,	false,	false);
					// 미사용 Column Hidden  처리
					InitDataProperty(0, cnt++ , dtHidden,				75,		daRight,	true,		"sc_eq_qty",				false,	"",		dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,				75,		daRight,	true,		"sc_exp",					false,	"",		dfFloat,		2,	false,	false);
					// 미사용 Column Hidden  처리
					InitDataProperty(0, cnt++ , dtHidden,				75,		daRight,	true,		"ir_eq_qty",				false,	"",		dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,				75,		daRight,	true,		"ir_exp",					false,	"",		dfFloat,		2,	false,	false);
									
					InitDataProperty(0, cnt++ , dtData,					110,	daLeft,		false,		"rqst_eq_no",				false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					110,	daLeft,		false,		"ttl_lss_dtl_cmpl_nm",		false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					110,	daLeft,		false,		"ttl_lss_dtl_cmpl_dt",		false,	"",		dfNone,		0,	false,	false);											
					//히든 데이타	 	
					InitDataProperty(0, cnt++ , dtHidden,   			0,		daCenter,  	false,   	"apro_ofc_cd",    	 		false,  "",     dfNone,    		0,      true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   			0,		daCenter,  	false,   	"ttl_lss_dtl_rsn_cd",    	false,  "",     dfNone,    		0,      true,       true);
													
					CountPosition = 0;	
 			}
	        break;
         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
            case IBSEARCH:      //조회
 				if(validateForm(sheetObj,formObj,sAction))
   					if (sheetObj.id == "sheet1"){
   						formObj.f_cmd.value = SEARCH;     				
   						sheetObj.DoSearch("EES_MNR_0102GS.do",FormQueryString(formObj));
   					}
           		break;
           
  			case IBCLEAR:        //초기화
				MnrWaitControl(true);
			    sheetObj.WaitImageVisible = false;
				if(initLoader == 0){
					//콤보 초기화 
					for(var i = 0; i < comboObjects.length;i++){ 
						comboObjects[i].RemoveAll();       
					}
					
					var sCondition = new Array (
							new Array("MnrGenCd","TR", "COMMON")	 //Main Reason 
						   ,new Array("MnrGenCd","SELHO","CUSTOM9")  //EQ Type 
						   ,new Array("MdmOrganization","RHQ","FALSE") //Regional HQ
						   ,new Array("MnrGenCd","CD00072", "COMMON")  //Close Type
						   ,new Array("MnrGenCd", "CD00043", "COMMON")	// Payer Type						   
					);
					var comboList = MnrComSearchCombo(sheetObj,sCondition);
					var sheetComboText = "";
					var sheetComboCode = "";
					var sheetComboCodeText = "";
					var sheetComboDefault = "";		
					
					for(var i=0; i<comboList.length; i++)	
					{
						sheetComboText = " | ";
						sheetComboCode = " | ";
						sheetComboCodeText = "";
						sheetComboDefault = ""; 						
						if(comboList[i] != null)
						{
							for(var j = 0; j < comboList[i].length;j++)
							{   
								var xmlVal = comboList[i][j].split("|"); 
								
								sheetComboText +=  xmlVal[1] + "|";
								sheetComboCode +=  xmlVal[0] + "|";
								sheetComboCodeText +=  xmlVal[0] + "\t" + xmlVal[1] + "|";
								if(j ==0){	
									sheetComboDefault = xmlVal[0];      	
								}								
								
								if(i==0){
									formObj.rsn_cd.InsertItem(j, xmlVal[1] ,xmlVal[0]);
									if(mainRsnCd != ""){
										mainRsnCd += ","	
									}
									mainRsnCd += xmlVal[0];
								} else if(i==1){
									formObj.combo_eq_kind.InsertItem(j, xmlVal[1] , xmlVal[0]);
								} else if(i==2){
									formObj.combo_rhq.InsertItem(j, comboList[i][j], xmlVal[0]);
								} else if(i==3){
									formObj.ttl_lss_cmpl_cd.InsertItem(j, xmlVal[1] , xmlVal[0]);
									if(closeTpAll != ""){
										closeTpAll += ","	
									}
									closeTpAll += xmlVal[0];
								} 	
							}			
							if(i==0){
//								formObj.rsn_cd.InsertItem(0, "ALL" ,"A");
								formObj.rsn_cd.Code = mainRsnCd;
								formObj.rsn_cd_all_flg.value = "Y";
								var ttlLssDtlRsnCdObj = formObj.ttl_lss_dtl_rsn_cd;
								ttlLssDtlRsnCdObj.RemoveAll(); 	 	
								ttlLssDtlRsnCdObj.InsertItem(0, "ALL" ,"A");
								formObj.ttl_lss_dtl_rsn_cd.Code = "A";
							} else if(i==1){
								formObj.combo_eq_kind.InsertItem(0, "ALL" ,"A");
								formObj.combo_eq_kind.Code = "A";
								formObj.eq_kind.value = formObj.combo_eq_kind.Code;   
							} else if(i==2){
								formObj.combo_rhq.InsertItem(0, "ALL" ,"A");  
							} else if(i==3){
								formObj.ttl_lss_cmpl_cd.Code = closeTpAll;
								formObj.close_tp_all_flg.value = "Y";
							}
							
							sheetObjects[0].InitDataCombo (0, "ttl_lss_n3pty_tp_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
							
						}
						else
						{		
							if(i==0){	
								ComShowCodeMessage("MNR00005", "Main Reason");
							}else if(i==1){	
								ComShowCodeMessage("MNR00005", "EQ Type");
							}else if(i==2){
								ComShowCodeMessage("MNR00005", "Regional HQ");
							}else if(i==3){
								ComShowCodeMessage("MNR00005", "Close Type");
							}
						}
					}		
						
					formObj.combo_rhq.Code = "A";
					formObj.rhq.value = formObj.combo_rhq.Code;
					formObj.ofc_cd.value = formObj.combo_office.Code;	
					formObj.in_status_tp.RemoveAll();				  	
//					formObj.in_status_tp.InsertItem(0, "ALL","");					
					formObj.in_status_tp.InsertItem(0, "Save","S");
					formObj.in_status_tp.InsertItem(1, "Reject","J");
					formObj.in_status_tp.InsertItem(2, "Request","R");
					formObj.in_status_tp.InsertItem(3, "Processing","P");
					formObj.in_status_tp.InsertItem(4, "Complete","C");
					
					formObj.in_status_tp.Code = "S,J,R,P,C";
					
//					formObj.in_status_tp.Index = 0;
								
					initLoader = 1;	
				}

				//쉬트 초기화   
				for(i=0;i<sheetObjects.length;i++){   
					sheetObjects[i].RemoveAll();    
		        }  
				
		 		formObj.combo_eq_kind.Code = "A";
		 		formObj.combo_rhq.Code = "A";	
		 		formObj.combo_office.Code = "A";
//		 		formObj.rsn_cd.Code = "A";
		 		formObj.ttl_lss_cmpl_cd.Code = "A";		 
		 		
		 		formObj.eq_no.value = "";
		 		formObj.total_loss_no.value = "";
		 		
		 		formObj.vndr_seq.value = "";
		 		formObj.vndr_nm.value = "";
		 		
		 		formObj.payer_code.value = "";
		 		formObj.payer_nm.value = "";
		 		
				formObj.in_search_dt_tp.RemoveAll();			  	
				formObj.in_search_dt_tp.EditFontBold = true;		 										
				formObj.in_search_dt_tp.InsertItem(0, "Creation Date","R");
				formObj.in_search_dt_tp.InsertItem(1, "Total Loss Date","C");
				formObj.in_search_dt_tp.InsertItem(2, "Complete Date","E");		
				formObj.in_search_dt_tp.Code2 = "R";
				
				formObj.in_office_tp.RemoveAll();			  	
				formObj.in_office_tp.EditFontBold = true;		 										
				formObj.in_office_tp.InsertItem(0, "RES Office","S");
				formObj.in_office_tp.InsertItem(1, "REQ Office","Q");
				formObj.in_office_tp.InsertItem(2, "RES/REQ Office","A");		
				formObj.in_office_tp.Code2 = "S";
													    	
				formObj.fm_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "Y", -1);
				formObj.to_dt.value = ComGetNowInfo();
		 							   					
				sheetObj.WaitImageVisible = true;
				MnrWaitControl(false);    			
				break;
				
   			case IBDOWNEXCEL:
   				//2014-01-09 Excel Down시 Column Merge 유지
   			    sheetObj.Down2Excel(-1);   
   				break;	
				
			case IBSEARCH_ASYNC01:	//조회(Lessor. 입력시)
				if ( validateForm(sheetObj, formObj, sAction) ) { 
					if(Number(formObj.vndr_seq.value)){
						//서비스 프로바이더 조회     
						var sCondition = new Array ( 	 
							new Array("MdmVendor",formObj.vndr_seq.value,"COMMON")
						)  	                           
						//조회 값이 있다면 세팅	
						var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
						if(comboList[0] != null){	  
							var tempText = comboList[0][0].split("|");  
							formObj.vndr_nm.value  = tempText[1];   
						} else {		        
							ComShowCodeMessage("MNR00005", "Lessor");              
							ComSetObjValue(formObj.vndr_nm, "");  
							ComSetObjValue(formObj.vndr_seq, ""); 
							ComSetFocus(formObj.vndr_seq);	
						}
					} else {		        
						ComShowCodeMessage("MNR00005", "Lessor");              
						ComSetObjValue(formObj.vndr_nm, "");  
						ComSetObjValue(formObj.vndr_seq, ""); 
						ComSetFocus(formObj.vndr_seq);	
					}		  
				}			
				break;		
			case IBSEARCH_ASYNC02:	//조회(Payer Code. 입력시)
				if ( validateForm(sheetObj, formObj, sAction) ) { 
					if(Number(formObj.payer_code.value)){
						//서비스 프로바이더 조회     
						var sCondition = new Array ( 	 
							new Array("MdmVendor",formObj.payer_code.value,"COMMON")
						)  	                           
						//조회 값이 있다면 세팅	
						var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
						if(comboList[0] != null){	  
							var tempText = comboList[0][0].split("|");  
							formObj.payer_nm.value  = tempText[1];   
						} else {		        
							ComShowCodeMessage("MNR00005", "Payer Code");              
							ComSetObjValue(formObj.payer_nm, "");  
							ComSetObjValue(formObj.payer_code, ""); 
							ComSetFocus(formObj.payer_code);	
						}		  
					} else {		        
						ComShowCodeMessage("MNR00005", "Payer Code");              
						ComSetObjValue(formObj.payer_nm, "");  
						ComSetObjValue(formObj.payer_code, ""); 
						ComSetFocus(formObj.payer_code);	
					}		  
				}			
				break;	
			case IBSEARCH_ASYNC03:	//조회(Buyer Code. 입력시)
				if ( validateForm(sheetObj, formObj, sAction) ) { 
					if(Number(formObj.buyer_code.value)){
						//서비스 프로바이더 조회     
						var sCondition = new Array ( 	 
							new Array("MdmVendor",formObj.buyer_code.value,"COMMON")
						)  	                           
						//조회 값이 있다면 세팅	
						var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
						if(comboList[0] != null){	  
							var tempText = comboList[0][0].split("|");  
							formObj.buyer_nm.value  = tempText[1];   
						} else {		        
							ComShowCodeMessage("MNR00005", "Buyer Code");              
							ComSetObjValue(formObj.buyer_nm, "");  
							ComSetObjValue(formObj.buyer_code, ""); 
							ComSetFocus(formObj.buyer_code);	
						}		  
					} else {		        
						ComShowCodeMessage("MNR00005", "Buyer Code");              
						ComSetObjValue(formObj.buyer_nm, "");  
						ComSetObjValue(formObj.buyer_code, ""); 
						ComSetFocus(formObj.buyer_code);	
					}		  
				}			
				break;						
         }	
     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
         }
         return true;
     }
      
      /**
       * combo_eq_kind에서 OnChange가 발생하는 경우 이벤트처리
       * @param comboObj
       * @param Index_Code
       * @param Text
       * @return
       */   
      function comboOnChange(comboObj,Index_Code, Text){ 
      		var formObj = document.form;
      		formObj.combo_office.removeAll();

    		var sCondition = new Array (
    				new Array("MdmOrganization","SEARCH",Index_Code)   //Office
    			);   
    		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
       	
	       	if(comboList[0] != null){
	      	 	for(var i = 0; i < comboList[0].length;i++){ 
	      		 	   var code = comboList[0][i].substring(0, comboList[0][i].indexOf('|') );
	      	 		   formObj.combo_office.InsertItem(i, comboList[0][i] , code);			   
	      	 	}
	      	 	formObj.combo_office.InsertItem(0, "ALL" , "A");
	      	 	formObj.combo_office.Code = "A";
	       	}
      }         
     
      /**  
     	 * ttl_lss_cmpl_cd Blur 이벤트      
     	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
     	 * @param  {String}    Index_Code   Index 나 코드
     	 * @param  {String}    Text   텍스트
     	 */  
     function ttl_lss_cmpl_cd_OnBlur(comboObj){
     	var formObj  = document.form;
     		
     	if(comboObj.Code == closeTpAll){
     		formObj.close_tp_all_flg.value = "Y"
     	} else{
     		formObj.close_tp_all_flg.value = "";
     	}
     	
     }   
    
        
      
   	/**  
   	 * rsn_cd Blur 이벤트      
   	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
   	 * @param  {String}    Index_Code   Index 나 코드
   	 * @param  {String}    Text   텍스트
   	 */  
   	function rsn_cd_OnBlur(comboObj){
   		var formObj  = document.form;
   		
		//Sub Reason 초기화
		var ttlLssDtlRsnCdObj = formObj.ttl_lss_dtl_rsn_cd;
		ttlLssDtlRsnCdObj.RemoveAll(); 	 	
		ttlLssDtlRsnCdObj.InsertItem(0, "ALL" ,"A");    
				
		//Main Reason 체크	
		if(comboObj.Code == "A" || comboObj.Code == "" || comboObj.Code.length > 3) {
			if(comboObj.Code == mainRsnCd){
				formObj.rsn_cd_all_flg.value = "Y"
			} else{
				formObj.rsn_cd_all_flg.value = ""
			}
			ttlLssDtlRsnCdObj.Code = "A";	
			return;		
		} else {
			formObj.rsn_cd_all_flg.value = "";
		}
								
		//Sub Reason 조회 및 설정		
		var sCondition = new Array (	
			new Array("MnrGenCd",comboObj.Code, "COMMON") 		
		)      
			       
		sheetObjects[0].WaitImageVisible = false;	
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
		sheetObjects[0].WaitImageVisible = true; 	
		for(var j = 0; j < comboList[0].length;j++){ 	
			var tempText = comboList[0][j].split("|");   	  
			ttlLssDtlRsnCdObj.InsertItem(j + 1, tempText[1] ,tempText[0]);
		}	
		ttlLssDtlRsnCdObj.Code = "A";	 		 
   	}    
	/**  
	 * combo_eq_kind Change 이벤트      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  
	function combo_eq_kind_OnChange(comboObj,Index_Code, Text){ 
		var formObj  = document.form;        
		formObj.eq_kind.value = comboObj.Code;
	} 

   	/**  
   	 * combo_rhq Change 이벤트      
   	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
   	 * @param  {String}    Index_Code   Index 나 코드
   	 * @param  {String}    Text   텍스트
   	 */  	
   	function combo_rhq_OnChange(comboObj,Index_Code, Text){
		var formObj  = document.form;       
   		if(Index_Code==""){
   			comboObj.Code="A";
   		}
   		if(comboObj.Code=="A"){
   			formObj.rhq.value = ""; 
   		}else{
   			formObj.rhq.value = comboObj.Code; 
   		}
   		comboOnChange(comboObj,Index_Code, Text);   		 
   	}  	 
	   	
   	/**  
   	 * combo_office Change 이벤트      
   	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
   	 * @param  {String}    Index_Code   Index 나 코드
   	 * @param  {String}    Text   텍스트
   	 */  
   	function combo_office_OnChange(comboObj,Index_Code, Text){ 
 		var formObj  = document.form;     
 		if(Index_Code==""){
			comboObj.Code="A";
		}
		if(comboObj.Code=="A"){
			formObj.ofc_cd.value = ""; 
		}else{
			formObj.ofc_cd.value = comboObj.Code; 
		}
   	}   	   	
     	
 	function initControl() { 		 
	    //Axon 이벤트 처리1. 이벤트catch  
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',		form); 			//- 변경될때.
	}		 	 	         
					   
	/**
	 * HTML Control의 deactivate 이벤트 <br>
	 **/
	function obj_deactivate(){    
		obj = event.srcElement;       
	    ComChkObjValid(event.srcElement); 
	} 

	/**
	 * HTML Control의 activate 이벤트 <br>
	 **/
	function obj_activate(){   
	    ComClearSeparator(event.srcElement);
	}  
	
	function obj_change(){	     
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {				       
	    		case "vndr_seq":		  
					formObj.vndr_seq.value = ComLpad(formObj.vndr_seq.value,6,"0");  
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);	
				   	break;		
	    		case "payer_code":		  
					formObj.payer_code.value = ComLpad(formObj.payer_code.value,6,"0");  
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC02);	
				   	break;
	    		case "buyer_code":		  
					formObj.buyer_code.value = ComLpad(formObj.buyer_code.value,6,"0");  
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC03);	
				   	break;						   	
			}	 	      
	    } else {					
			switch(obj.name) {			      
	    		case "vndr_seq":    
					ComSetObjValue(formObj.vndr_nm,"")
				   	break;			
	    		case "payer_code":    
					ComSetObjValue(formObj.payer_nm,"")
				   	break;						
			}	 	 		
		}			
	} 		   
		 
	/**
	 * HTML Control의 keypress 이벤트 <br>
	 **/     
	function obj_keypress(){     
	    obj = event.srcElement;    
	    if(obj.dataformat == null) return; 
	    window.defaultStatus = obj.dataformat;
			              
	    switch(obj.dataformat) {  
	        case "ymd":   
	        case "int":    
				ComKeyOnlyNumber(obj); 
	            break;     
	        case "float":   
	            ComKeyOnlyNumber(obj, ".");
	            break; 
	        case "eng":   
	            ComKeyOnlyAlphabet();
				break;   
	        case "engup": 
	        	ComKeyOnlyAlphabet('uppernum');   
	        break;	  
	    }
	} 
				
	/**
	 * (Service Provider) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index 
	 */		
	function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form; 	    
		if ( aryPopupData.length > 0 ) {		 
			formObj.vndr_seq.value = ComLpad(aryPopupData[0][2],6,"0");   
			formObj.vndr_nm.value  = aryPopupData[0][4];	
		}			
	}	
	      
	/**
	 * (Service Provider) Payer Code Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index 
	 */		
	function setPopDataPayer(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form; 	    
		if ( aryPopupData.length > 0 ) {		 
			formObj.payer_code.value = ComLpad(aryPopupData[0][2],6,"0");   
			formObj.payer_nm.value  = aryPopupData[0][4];	
		}			
	}	

	/**
	 * (Service Provider Buyer) Payer Code Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index 
	 */		
	function setPopDataBuyer(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form; 	    
		if ( aryPopupData.length > 0 ) {		 
			formObj.buyer_code.value = ComLpad(aryPopupData[0][2],6,"0");   
			formObj.buyer_nm.value  = aryPopupData[0][4];	
		}			
	}		
	
 	/**
 	 * rep_Multiful_inquiry 사용시 받는부분  
 	 * 소스에 붙여서 사용하세요          
 	 * Location : 팝업에서 단일 선택을 한경우..     
 	 */      
 	function getMnr_Multi(rowArray,return_val) {
 		var formObj = document.form;  
 		var tempText = ""; 	
 		//초기화	   
 		if(return_val == "eq_no"){
 			formObj.eq_no.value = '';
 		}else if(return_val == "usa_edi_cd"){
 			formObj.usa_edi_cd.value = '';
 		}else{
 			formObj.total_loss_no.value = '';
 		}
 		for(var i=0; i<rowArray.length; i++) {   
 			var colArray = rowArray[i];     
 			tempText +=  rowArray[i] + ','; 	  
 		}      
 		//마지막에 ,를 없애기 위함     
 		tempText = MnrDelLastDelim(tempText);	 
 					 	    
 		tempText = tempText.toUpperCase(); 	            
 		eval("document.form." + return_val + ".value = '" + tempText + "';"); 
 	}  		 
	/* 개발자 작업  끝 */