/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MST_0022.js
*@FileTitle : Container Specification Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 김석준
*@LastVersion : 1.0
* 2009.05.11 김석준
* 1.0 Creation
* 2011.03.29 나상보
* Ticket No :CHM-201109717-01
* 개발자 : 나상보
* Title  : [MST] Specification Inquiry 화면 항목 추가
* Description : 1.sheet column 15개 추가
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
     * @class ees_mst_0022 : ees_mst_0022 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mst_0022() { 
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
		this.initCombo 				= initCombo;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
 
	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick()
     {
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 		  var sheetObject1 = sheetObjects[0];
          /*******************************************************/
          var formObject = document.form;

     	try 
     	{
     		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) 
			{
				case "btn_close":
					window.close();
					break;
					
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
				
				case "btn_ok":
					comPopupOK();
					break;
				
				case "btn_spec":	// SPEC 버튼을 선택시 팝업호출.
		         	// 현재 선택된 row.
		        	var selrow = sheetObj.SelectRow;
					if ( selrow > 0 )
					{
		    			document.form.cntr_spec_no.value = sheetObj.CellValue(selrow,"cntr_spec_no");
		    			openPopupSpec();
					}
					break;
				
				case "btn_Popup":  // AGMT NO. popup버튼.
					ComOpenPopupWithTarget('/hanjin/EES_LSE_0091.do', 800, 445, "agmt_no:agmt_no", "0,0,1", true);
					break;

				case "btn_new":
					sheetObject1.RemoveAll();
					formObject.own_cntr_flg[0].checked = false;
					formObject.own_cntr_flg[1].checked = false;
					comboObjects[0].Text = "";
					formObject.from_spec_yr.value = "";
					formObject.to_spec_yr.value = "";
					formObject.agmt_no.value = "";
					break;
				
				case "own_cntr_flg":
					var HeadTitle = '';
					if(formObject.own_cntr_flg[0].checked){
	                     HeadTitle = "|Seq.|SPEC No.|F. SPEC No.|AGMT No.|Term|Lot No.|TP/SZ||Manufacturer|Material|Serial Range";						
					}else{
	                     HeadTitle = "|Seq.|SPEC No.|F. SPEC No.|AGMT No.|Term|Lot No.|TP/SZ||Lessor|Material|Serial Range";												
					}
					sheetObject1.InitHeadRow(0, HeadTitle, true);					
					break;
					
				case "btn_downexcel":
					sheetObject1.Down2Excel(-1);
					break;

			} // end switch
 				
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("MST00011",srcName+" Button Fail.");
     		} else {
     			ComShowCodeMessage("MST00011",e);
     		}
     	}
     }

     /**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setSheetObject(sheet_obj)
     {
        sheetObjects[sheetCnt++] = sheet_obj;
     }

 	/**
 	 * IBMultiCombo Object를 배열로 등록
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
     function loadPage() 
     {
    	 if(document.form.active_flag.value=="")	// 메인으로 실행되었을 때는 OWN이 기본값으로. 초기조회 안함.
       	 {
       		document.form.own_cntr_flg[0].checked = true;
       	 }
    	 
         for(i=0;i<sheetObjects.length;i++)
         {
        	 //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
             
         }
         
 	    //Axon 이벤트 처리1. 이벤트catch
  	   axon_event.addListenerForm('blur',    'obj_deactivate', form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBlur이벤트에 코드 처리
  	   axon_event.addListenerFormat('focus', 'obj_activate',   form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnFocus이벤트에 코드 처리
  	   axon_event.addListenerFormat('keypress',    'obj_keypress',   form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
  	   axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
     }
      
	 function sheet1_OnLoadFinish(sheetObj){
        sheetObj.WaitImageVisible = false;
  		
  		for ( k = 0 ; k < comboObjects.length ; k++ ) {
  	        initCombo(comboObjects[k], k+1);
  	    }
         
  		// 호출타입이 1이면 Term 라디오버튼을 디스에이블 시킨다.
     	if(document.form.active_flag.value=="1")			// EES_MST_0016.do에서 팝업으로 호출시 처리.
     	{
     		document.form.own_cntr_flg[0].disabled = true;
     		document.form.own_cntr_flg[1].disabled = true;
     		
         	if(document.form.lot_no.value!="")		// lot_no 값이 있으면 고치지 못하도록 한다.
         	{
         		comboObjects[0].Enable = false;
         	}
         	else
         	{
         		document.form.agmt_no.value = "";
         	}         	
     	}
     	else if(document.form.active_flag.value=="2")	// EES_MST_0021.do에서 팝업으로 호출시 처리.
  		{
  			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  		}
     	else if(document.form.active_flag.value=="3")	// EES_LSE_0001.do에서 팝업으로 호출시 처리.
  		{
     		document.form.own_cntr_flg[0].disabled = true;
     		document.form.own_cntr_flg[1].disabled = true;
     		comboObjects[0].Enable = false;
     		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  		}

        sheetObj.WaitImageVisible = true; 
		
	}
   	
   	//Axon 이벤트 처리2. 이벤트처리함수
   	function obj_deactivate(){
   	    ComChkObjValid(event.srcElement);
   	}
   	
   	function obj_activate(){
   	    ComClearSeparator(event.srcElement);
   	}
   	
   	function obj_keypress(){
   	    obj = event.srcElement;
   	    if(obj.dataformat == null) return;
   	    window.defaultStatus = obj.dataformat;
   	
   	    switch(obj.dataformat) {
   	        case "ymd":
   	        case "ym":
   	        case "hms":
   	        case "hm":
   	        case "jumin":
   	        case "saupja":
   	            ComKeyOnlyNumber(obj);
   	            break;
   	        case "int":
   	            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
   	            else ComKeyOnlyNumber(obj);
   	            break;
   	        case "float":
   	            ComKeyOnlyNumber(obj, "-.");
   	            break;
   	        case "eng":
   	            ComKeyOnlyAlphabet(); break;
   	        case "engup":
   	            if(obj.name=="agmt_no") ComKeyOnlyAlphabet('uppernum')
   	            else if(obj.name=="from_spec_yr" || obj.name=="to_spec_yr") ComKeyOnlyNumber(obj)
   	            else ComKeyOnlyAlphabet('upper');
   	            break;
   	        case "engdn":
   	            if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
   	            else ComKeyOnlyAlphabet('lower');
   	            break;
   	    }
   	}

   /**
   * 시트 초기설정값, 헤더 정의
   * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
   * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
   */
   function initSheet(sheetObj,sheetNo) 
     {
    	 var formObject = document.form;    	  
         var cnt = 0;
		 var sheetID = sheetObj.id;
         switch(sheetID) 
         {
             case "sheet1":
                 with (sheetObj) 
                 {
                     // 높이 설정
                     style.height = 420;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     var HeadTitle = "";
                     
 					if(formObject.own_cntr_flg[0].checked){
	                     HeadTitle = "|Seq.|SPEC No.|F. SPEC No.|AGMT No.|Term|Lot No.|TP/SZ||Manufacturer|Material|Serial Range|Qty|Active Qty|Unit Kind|Hanger Rack|P.Floor|Maker|Model No.|Refrigerant|Max Setting Temp.(℃)|Capacity|Gross Weight|Tare Weight|Pay Load|External Length|External Width|External Height|Internal Length|Internal Width|Internal Height|Open Door Width|Open Door Height|Reefer Cargo Loadable Capacity|Reefer Cargo Loadable Height|Tank Capacity";						
					}else{
	                     HeadTitle = "|Seq.|SPEC No.|F. SPEC No.|AGMT No.|Term|Lot No.|TP/SZ||Lessor|Material|Serial Range|Qty|Active Qty|Unit Kind|Hanger Rack|P.Floor|Maker|Model No.|Refrigerant|Max Setting Temp.(℃)|Capacity|Gross Weight|Tare Weight|Pay Load|External Length|External Width|External Height|Internal Length|Internal Width|Internal Height|Open Door Width|Open Door Height|Reefer Cargo Loadable Capacity|Reefer Cargo Loadable Height|Tank Capacity";												
					}                     
                     
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(36, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	100,	daCenter,	false,	"ibflag");
                     InitDataProperty(0, cnt++ , dtDataSeq,			40,		daCenter,	false,	"SEQNo",		false,	"",		dfNone,		0,  false,		false, 		-1, 	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"cntr_spec_no",	false,	"",		dfNone,		0,	false,		false);                     
                     InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	"fctry_spec_no",false,	"",		dfNone,		0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"agmt_no",		false,	"",		dfNone,		0,	false,		false);                     
                     InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"lstm_cd",		false,	"",		dfNone,		0,	false,		false);
                                                                                                                                 
                     InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	false,	"lot_no",		false,	"",		dfNone,		0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"cntr_tpsz_cd",	false,	"",		dfNone,		0,	false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,			80,		daLeft,		false,	"vndr_seq",		false,	"",		dfNone,		0,	false,		false);                     
                     InitDataProperty(0, cnt++ , dtData,			90,		daLeft,		false,	"vndr_abbr_nm",	false,	"",		dfNone,		0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"cntr_mtrl_cd",	false,	"",		dfNone,		0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			130,	daCenter,	false,	"ser_range",	false,	"",		dfNone,		0,	false,		false);
                     
                     InitDataProperty(0, cnt++ , dtData,			70,		daRight,	false,	"ttl_lot_qty",	false,	"",		dfNone,		0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			70,		daRight,	false,	"ttl_act_qty",	false,	"",		dfNone,		0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"rf_tp_cd",	false,	"",		dfNone,		0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			80,	 	daCenter,	false,	"cntr_hngr_rck_flg",	false,	"",		dfNone,		0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"plst_flr_flg",	false,	"",		dfNone,		0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		false,	"rf_mkr_seq",	false,	"",		dfNone,		0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		false,	"rf_mdl_nm",	false,	"",		dfNone,		0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	false,	"rf_rfr_no",	false,	"",		dfNone,		0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			150,	daCenter,	false,	"max_temp",	    false,	"",		dfNone,		0,	false,		false);                     
                     InitDataProperty(0, cnt++ , dtData,			70,		daRight,	false,	"lod_capa",	    false,	"",		dfFloat,	1,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			110,	daRight,	false,	"cntr_grs_wgt",	false,	"",		dfInteger,	0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			110,	daRight,	false,	"tare_wgt",		false,	"",		dfInteger,	0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			110,	daRight,	false,	"pay_load",		false,	"|cntr_grs_wgt| - |tare_wgt|",		dfNone,		0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			110,	daRight,	false,	"xter_len",		false,	"",		dfInteger,	0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			110,	daRight,	false,	"xter_wdt",		false,	"",		dfInteger,	0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			110,	daRight,	false,	"xter_hgt",		false,	"",		dfInteger,	0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			110,	daRight,	false,	"inter_len",	false,	"",		dfInteger,	0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			110,	daRight,	false,	"inter_wdt",	false,	"",		dfInteger,	0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			110,	daRight,	false,	"inter_hgt",	false,	"",		dfInteger,	0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			110,	daRight,	false,	"opn_dor_wdt",	false,	"",		dfInteger,	0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			110,	daRight,	false,	"opn_dor_hgt",	false,	"",		dfInteger,	0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			190,	daRight,	false,	"rc_ldb_capa",	false,	"",		dfFloat,	1,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			190,	daRight,	false,	"rc_ldb_hgt",	false,	"",		dfInteger,	0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,			80,		daRight,	false,	"tnk_capa",		false,	"",		dfFloat,	1,	false,		false);
                }
                 break;
         }
    }

  	/**
  	 * 콤보 초기설정값, 헤더 정의
  	 * param : comboObj ==> 콤보오브젝트, sheetNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
  	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  	 */
  	function initCombo(comboObj, comboNo) {
  	    switch(comboObj.id) {
  	        case "combo1":
  	        	with(comboObj) {
  	            	DropHeight = 200;
  	            	MultiSelect = false;
  	            	MaxSelect = 1;
  	            	MultiSeparator = ",";
  	            	// 컴보박스의 배경색을 필수로 바꾸려면 -> BackColor = "#CCFFFD";
  	            	// 초기에 빈컬럼 넣기.
  	            	comboObj.InsertItem(0, 'ALL', '');
  	            	Style = 0;
  	            	UseAutoComplete = true;
 	            	
 	            	ValidChar(2,1);		// 영어대문자 사용, 숫자포함
 	            	IMEMode = 0;		// 영문
 	            	MaxLength = 2;		// 2자까지 입력
  	            }
  	        	
  	        	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
  	        	
  	        	break;
  	    }
  	}

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) 
    {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) 
         {
			case IBCREATE:
	      		formObj.f_cmd.value = SEARCH02;
	         	sheetObj.WaitImageVisible = false;
	         	var sXml = sheetObj.GetSearchXml("EES_MST_COMGS.do", FormQueryString(formObj)+"&eq_knd_cd=U");
		        sheetObj.WaitImageVisible = true;
			    var chk = sXml.indexOf("ERROR");
				if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
				   sheetObj.LoadSearchXml(sXml);
				   return;
			    }

	            if ( sXml != "" ) {
		            var sCntrTpSzCd = ComGetEtcData(sXml,"cntr_tpsz_cd");
		            var arrCntrTpSzCd = sCntrTpSzCd.split("|");
			            
		            MstMakeComboObject(comboObjects[0], arrCntrTpSzCd, arrCntrTpSzCd);
		            
		            // 초기 기본값 설정.
		            if(formObj.cntr_tpsz_cd.value!="")
		            {
		            	comboObjects[0].Index = comboObjects[0].FindIndex(formObj.cntr_tpsz_cd.value,0); 
		            	
		            }
		            else
		            {
		            	comboObjects[0].Index = 0;
		            	formObj.cntr_tpsz_cd.value = ComGetObjValue(comboObjects[0]);
		            }
		            comboObjects[0].Text = formObj.cntr_tpsz_cd.value;
	            }

	            break;

			case IBSEARCH:      //조회
		 			if(sheetObj.id == "sheet1") 
		 			{
		 				//sheetObj.WaitImageVisible=false;
		 				//ComOpenWait(true);		 				
		 				formObj.f_cmd.value = SEARCH;
		 				var xml = "";
		 				xml = sheetObj.GetSearchXml("EES_MST_0022GS.do", FormQueryString(formObj));
		 				sheetObj.LoadSearchXml(xml);
		 				//ComOpenWait(false);		 				
		 			}
			break;
         }
    }
    
    /**
     * 더블클릭 처리.
     * @param SheetObj
     * @param Row
     * @param Col
     * @return
     */
	function sheet1_OnDblClick(SheetObj, Row, Col){
	}
  	
    /**
    * Pop-up Open 부분<br>
    */
    function openPopupSpec() 
    {
 		var formObj = document.form;
 		
 		var sUrl    = '/hanjin/EES_MST_0021.do';
 		var iWidth  = 1010;
 		var iHeight = 610;
 		var sTargetObjList = "cntr_spec_no:cntr_spec_no";
 		var sDisplay = "0,1";
 		
 		var param = "?cntr_spec_no="+formObj.cntr_spec_no.value+"&popflag=1";

 		ComOpenPopupWithTarget(sUrl+param, iWidth, iHeight, sTargetObjList, sDisplay, true);
    } 	
     
  	/**
  	 * combo1_OnChange
  	 */
  	function combo1_OnChange(comboObj, Index_Code, Text) {
  		var formObj = document.form;
  		formObj.cntr_tpsz_cd.value = ComGetObjValue(comboObj);
  	}
  	
  	/**
  	 * combo1_OnKeyDown
  	 */
  	function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
  		with(comboObj) {
  			if ( KeyCode == 8 || KeyCode == 46 ) {
  				for ( i = 0 ; i < GetCount() ; i++ ) {
  					if ( CheckIndex(i) ) {
  						CheckIndex(i) = false;
  					}
  				}
  			}
  		}
  	}
	/* 개발자 작업  끝 */