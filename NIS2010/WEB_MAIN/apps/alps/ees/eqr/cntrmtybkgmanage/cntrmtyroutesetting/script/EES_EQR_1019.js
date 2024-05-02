/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0001.js
*@FileTitle : Equipment Status Code Creation, Update & Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 김석준
*@LastVersion : 1.0
* 2009.05.06 김석준
* 1.0 Creation
* 2010.07.16 남궁진호 - Pre Sts 저장 후 초기화를 하지않아 Status가 남아있는
                                             현상이 있어 이를 수정함
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
     * @class ees_mst_0001 : ees_mst_0001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_eqr_1019() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnKeyDown   = sheet1_OnKeyDown;
    	this.sheet1_OnChange   = sheet1_OnChange;
    	this.sheet1_OnSaveEnd   = sheet1_OnSaveEnd;
    }
    
   	/* 개발자 작업	*/

 // 공통전역변수

 var sheetObjects = new Array();
 var sheetCnt = 0;
 
 var comboObjects = new Array();
 var comboCnt = 0 ;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;
 
 	 /**
 	  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 	  */
     function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];
    	var sheetObject2 = sheetObjects[1];
    	/*******************************************************/
    	var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) 
             {
             
     	        case "btn_retrieve":
	                doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    	        break;
    	        
				case "btn_downexcel":
					sheetObject1.Down2Excel(-1,false,false,true,"","",false,false,"",false,"1");
				break;
				
				case "btn_save":
					
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
/*   					if(strOfcCd == "SELOPE")
   					{
   						// 변경여부 체크. : There is no contents to save.
   						if(sheetObject1.IsDataModified == false && sheetObject2.IsDataModified == false)
   						{
   							ComShowCodeMessage("MST00012");
   							return;
   						}
   						
   						doActionIBSheet(sheetObject1,formObject,IBSAVE);
   					}*/
				break;
				
				case "btn_tp_save":
					
					doActionIBSheet(sheetObject2,formObject,IBINSERT);

				break;
				
				case "btn_add":
					var selrow = sheetObject1.SelectRow;
					
	   				if ( selrow > 0 )
	   				{
	   					sheetObject1.DataInsert(selrow);
	   					sheetObject1.SelectCell(selrow+1, 3, true);
	   					sheetObject1.CellEditable(selrow+1 ,"mty_split_bkg_dsabil_flg") = false;
	   				}
	   				else
	   				{
	   					sheetObject1.DataInsert(-1);
	   					sheetObject1.CellEditable(1,"mty_split_bkg_dsabil_flg") = false;
	   				}
	   				

				break;
				
				case "btn_new":
					formObject.p_rcc_cd.value = 'ALL';
					formObject.s_rcc_cd.Code = 'ALL';
					formObject.s_loc_cd.value = '';
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
				break;
				
				case "btn_delete":
   					if(strOfcCd == "SELCTY")
   					{
	   					if(sheetObject1.FindCheckedRow("Sel")=="")
	   					{
	   						ComShowCodeMessage("MST00010");
	   					}
	   					else if(ComShowCodeConfirm("MST00005")) 
	   					{ 
	   						doActionIBSheet(sheetObject1,formObject,IBDELETE);
	   					}
   					}
				break;
				
				case "btn_add2":
   					if(strOfcCd == "SELCTY")
   					{
						if(ComIsEmpty(formObject.cntr_sts_cd)) {
							ComShowCodeMessage("MST01017");
						} else {
							doActionIBSheet(sheetObject2,formObject,IBINSERT);
						}
   					}
				break;
				
				case "btn_delete2":
   					if(strOfcCd == "SELCTY")
   					{
	   					if(sheetObject2.FindCheckedRow("Sel")=="")
	   					{
	   						ComShowCodeMessage("MST00010");
	   					}
	   					else if(ComShowCodeConfirm("MST00005")) 
	   					{ 
	   						doActionIBSheet(sheetObject2,formObject,IBDELETE);
	   					}
   					}
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
     
     function initControl(){
    	 axon_event.addListenerFormat( 'keypress' , 'obj_keypress'   , document.form );
        // axon_event.addListenerForm  ( 'change'   , 'obj_change'     , document.form );
         axon_event.addListener('keyup', 's_loc_cd_onkeyUp', 's_loc_cd');
     }
     
     /**
      * Period TO  keyup 이벤트 처리
      * Period TO  keyup YYYY-MM 포멧 처리
      */
      function s_loc_cd_onkeyUp() {

			var formObjects = document.form;
				if(obj.value.trim() == ""){
					return;
				}
				
				var rccCd = formObjects.s_rcc_cd.Code;
				var value = obj.value;
				
				formObjects.p_rcc_cd.value = rccCd;

				if(value.length >= 5){
					validLocationCode(-1, rccCd, value);
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
      * 설  명 : IBCombo Object를 배열로 등록 <br>
      *          향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
      *          배열은 소스 상단에 정의<br>
      * <br><b>Example : </b>
      * <pre>
      *     setComboObject(combo_obj)
      * </pre>
      * @param {object}  combo_obj - Combo Object
      * @see #링크연결
      * @author 작성자
      * @version 
      */
     function setComboObject(combo_obj){
         comboObjects[comboCnt++] = combo_obj;
     }
     
     /**
      * RCC Combo code 변경시 
      * Loc code초기화
      */
     function change_rcc(){
     	var formObj = document.form;
     	if(formObj.s_rcc_cd.value !=""){
     		formObj.s_loc_grp_cd.value = "";
     		formObj.s_loc_cd.value = "";
     	}
     }
     
 	/**
 	 * @param row
 	 * @param rccCd
 	 * @param locGrpCd
 	 * @param locCd
 	 */
 	function validLocationCode(row, rccCd, locCd){
 		var param = new Array();
 		param[0] = "f_cmd=" + SEARCH02;
 		param[1] = "rcccd=" + rccCd;
 		param[2] = "loccd=" + locCd;
 		var sXml = sheetObjects[0].GetSearchXml("EES_EQR_1019GS.do",param.join("&"));
 		var count = ComGetEtcData(sXml, "count");
 		var err_msg = "";
 		if(count == "0"){
 			if(row==-1){
 				document.form.s_loc_cd.value = "";
 				document.form.s_loc_cd.focus();
 			} else {
 				sheetObjects[0].CellValue2(row, "loc_cd") = "";
 			}
 			
 			ComShowCodeMessage("EQR01103", "Location");

 			return;
 		}
 	}
 	
 	function obj_keypress(){
		obj = event.srcElement;
		if(obj.dataformat == null) return;
	
		window.defaultStatus = obj.dataformat;
	
		switch(obj.dataformat) {
			case "ym": case "ymd":
				ComKeyOnlyNumber(obj);
				break;
			case "num":
				if(obj.name=="vndr_seq"){
					//ComKeyOnlyNumber(obj,",");
					ComKeyOnlyNumber(obj);	//[2009.08.24:jmh]
				} else {
					ComKeyOnlyNumber(obj);
				}
				break;
	        case "int":
	            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
	            else ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;	
			case "eng":
				ComKeyOnlyAlphabet(); 
				break;
			case "engup":
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "engdn":
				if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
				else ComKeyOnlyAlphabet('lower');
				break;
			case "uppernum":
				ComKeyOnlyAlphabet('uppernum');
				break;
		}
	} 

     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() 
     {
         for(i=0;i<sheetObjects.length;i++)
         {
        	 //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i]);
             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         
         initControl();
         
         for(p=0;p< comboObjects.length;p++){
             initCombo (comboObjects[p],p+1);
         }
         
		doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
		
		setSheetCombo(sheetObjects[0]); // sheet 의 콤보 Item 세팅
     }
     
     /**
      * 설  명 :  Combo 기본 설정 <br>
      * <br><b>Example : </b>
      * <pre>
      *     initCombo(comboObj,comboNo)
      * </pre>
      * @param {object}  comboObj - Combo Object
      * @param {Number}  comboNo  - Combo Number
      * @see #링크연결
      * @author 작성자
      * @version 2009.01.01
      */
     function initCombo (comboObj, comboNo) {
         var cnt  = 0 ;

         switch(comboNo) {   
 		    // RCC_CD
             case 1:
                 with (comboObj) {               
                 DropHeight = 12 * 20;
                 MultiSelect = false;
             }
             break;
         }
     }
     
/*     function sheet1_OnChange(sheetObj,Row, Col, Value){
    	 alert(Value);
     }*/
      
/*	function sheet1_OnLoadFinish(sheetObj) 
	{
	    sheetObj.WaitImageVisible = false;
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
   		
   		// 첫번째 선택항목에 대한 cntr_sts_cd를 출력한다.
        var cntr_sts_cd = sheetObjects[0].CellValue(1, "vvdname");
        document.form.cntr_sts_cd.value = cntr_sts_cd;
		SheetFiltering(1,cntr_sts_cd,"vvdname");
	    sheetObj.WaitImageVisible = true; 		
	}*/
 	
 	/* ********* User Functions ************* */	
 	/** 
 	 * 클릭 이벤트 발생시 각시트 필터링      
 	 * @param	{Number}	sheetIdx		필터링할 쉬트 인덱스
 	 * @param 	{String}  	keyValue  		필터링할 조건값
 	 * @param 	{Form}  	foreginKey  	keyValue로 필터링될 컬럼 
 	 * 시트가 여러개일시 시트의 프라이머리키와 포린키가 동일한 패턴일 경우만 사용 
 	 */ 
 	function SheetFiltering(sheetIdx,keyValue,foreginKey){ 
		for (var idx=1; idx <= sheetObjects[sheetIdx].RowCount; idx++){
			if(sheetObjects[sheetIdx].CellValue(idx,foreginKey) == keyValue &&
					sheetObjects[sheetIdx].RowStatus(idx) != "D"){
				sheetObjects[sheetIdx].RowHidden(idx) = false;   
			} else {    
				sheetObjects[sheetIdx].RowHidden(idx) = true; 
			}     
		} 	 	    				  
 	}    
 	
	/** 
	 * preStsCd 에서 키값이 공백인 모든 코드를 삭제한다.
	 */
	function deleteInvalidCd()
	{
    	var cur_pre_sts_code = "";			// 현재 preStsCd

    	for(var i=1; i<=sheetObjects[1].RowCount; i++)
		{
			cur_pre_sts_code = sheetObjects[1].CellValue(i,"cntr_pre_sts_cd");
    		if(ComIsEmpty(ComTrim(cur_pre_sts_code)))
    		{
    			sheetObjects[1].CellValue(i,"Sel") = "Y";
    		}
		}
	}
	
	function sheet1_OnChange(sheetObj,Row, Col, Value ){

		if(Value.length == 5){
			//alert(Value);
			
	 		var param = new Array();
	 		param[0] = "f_cmd=" + SEARCH03;
	 		param[1] = "loccd=" + Value;
	 		param[2] = "dcflg=" + sheetObj.CellValue(Row, "lodg_dchg_div_cd");
	 		var sXml = sheetObjects[0].GetSearchXml("EES_EQR_1019GS.do",param.join("&"));
	 		var rcc = ComGetEtcData(sXml, "rcc");
	 		
	 		
	 		if(rcc == 'N'){
	 			ComShowCodeMessage("EQR01103", "Location");
	 			sheetObj.CellValue(Row, "loc_nm") = '';
	 		}else if(rcc == 'M'){
	 			ComShowCodeMessage("EQR90009");
	 			sheetObj.CellValue(Row, "loc_nm") = '';
	 		}else{
	 			sheetObj.CellValue(Row, "rcc_nm") = rcc;
	 		}

/*	 		var err_msg = "";
	 		if(count == "0"){
	 			if(row==-1){
	 				document.form.s_loc_cd.value = "";
	 				document.form.s_loc_cd.focus();
	 			} else {
	 				sheetObjects[0].CellValue2(row, "loc_cd") = "";
	 			}
	 			
	 			ComShowCodeMessage("EQR01103", "Location");

	 			return;
	 		}*/
			
		}
/*		if(sheetObj.ColSaveName(Col) == "loc_nm") { 
			if(sheetObj.CellValue(Row , Col).length == 4){
				alert(sheetObj.CellValue(Row , Col));
			}
		}*/
		
	}
	

	function sheet1_OnKeyDown(sheetObj,Row, Col, keyCode ){
		var formObj  = document.form;
		

		if(sheetObj.ColSaveName(Col) == "lodg_dchg_div_cd") { 
			if("D" == sheetObj.CellValue(Row , Col)){
				sheetObj.CellValue(Row , "mty_bkg_dsabil_flg") = 0;
				sheetObj.CellEditable(Row ,"mty_bkg_dsabil_flg") = false;
				sheetObj.CellEditable(Row ,"mty_split_bkg_dsabil_flg") = true;
			}else{
				sheetObj.CellValue(Row , "mty_split_bkg_dsabil_flg") = 0;
				sheetObj.CellEditable(Row ,"mty_bkg_dsabil_flg") = true;
				sheetObj.CellEditable(Row ,"mty_split_bkg_dsabil_flg") = false;
			}
		}
		
/*		if(sheetObj.ColSaveName(Col) == "loc_nm") { 
			alert(1);
			//if(sheetObj.CellValue(Row , Col).length > 3){
				alert(sheetObj.CellValue(Row , Col));
			//}
	 		var param = new Array();
	 		param[0] = "f_cmd=" + SEARCH02;
	 		param[1] = "rcccd=" + rccCd;
	 		param[2] = "loccd=" + locCd;
	 		var sXml = sheetObjects[0].GetSearchXml("EES_EQR_1019GS.do",param.join("&"));
	 		var count = ComGetEtcData(sXml, "count");
	 		var err_msg = "";
	 		if(count == "0"){
	 			if(row==-1){
	 				document.form.s_loc_cd.value = "";
	 				document.form.s_loc_cd.focus();
	 			} else {
	 				sheetObjects[0].CellValue2(row, "loc_cd") = "";
	 			}
	 			
	 			ComShowCodeMessage("EQR01103", "Location");

	 			return;
	 		}
		}*/
	}


 	/**
 	 * preStsCd 키값이 없는 컬럼을 찾고, 표시한다.
 	 */
    function findEmptyPreStsCd()
    {
    	var cur_sts_code = "";				// 현재 stsCd
    	var sel_sts_code = "";				// 선택된 stsCd
    	var cur_pre_sts_code = "";			// 현재 preStsCd
    	
    	// preStsCd sheet에서 preStsCd값이 empty인 컬럼을 찾는다.
    	for(var i=1; i<=sheetObjects[1].RowCount; i++)
    	{
    		cur_sts_code = sheetObjects[1].CellValue(i,"cntr_sts_cd");
    		cur_pre_sts_code = sheetObjects[1].CellValue(i,"cntr_pre_sts_cd");
    		
    		if(ComIsEmpty(ComTrim(cur_pre_sts_code)))
    		{
    			// 찾은 컬럼의 stsCd값으로 stsCd sheet의 해당위치를 찾는다.
    			for(var k=1; k<sheetObjects[0].RowCount; k++) 
    			{
    				sel_sts_code = sheetObjects[0].CellValue(k,"cntr_sts_cd");
    				
    				// preStsCd 가 empty인 stsCd를  선택하고 preStsCd를 출력한다.
    				if(sel_sts_code == cur_sts_code)
    				{
    					sheetObjects[0].SelectCell(k, 3, true);
    					document.form.cntr_sts_cd.value = cur_sts_code;
    					SheetFiltering(1,cur_sts_code,"cntr_sts_cd");
    					sheetObjects[1].SelectCell(i, 2, true);
    					return;
    				}
    			}
    			return;
    		}
    	}
    	return;
    }

   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) 
     {
         var cnt = 0;

         switch(sheetNo) 
         {
             case 1:      //sheet1 init
                 with (sheetObj) 
                 {
                     // 높이 설정
                     style.height = 419;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(8, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다 
                     InitHeadMode(true, true, true, true, false,false);

                     var HeadTitle = "Del.||RCC|Load/Disc|Location|Type/Size|Booking|VD Split";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);
 					
                     //데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtDelCheck,     50,  daCenter,  true, "check");
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 100,  daCenter, false, "ibflag");
                     InitDataProperty(0, cnt++ , dtData,     	 111,  daCenter, false, "rcc_nm",  false,          "",      dfNone,			0,     false,       false, 5); 
                     InitDataProperty(0, cnt++ , dtCombo,     	 111,  daCenter, false, "lodg_dchg_div_cd",  true,          "",      dfNone,			0,     false,       true); 
                     InitDataProperty(0, cnt++ , dtData,     	 111,  daCenter, false, "loc_nm",  true,          "",      dfNone,			0,     false,       true, 5);
                     InitDataProperty(0, cnt++ , dtImage,        111,  daCenter,  true,  "cntr_img", false,     "",       dfNone,   	    0,     false,      false,       8);
                     InitDataProperty(0, cnt++ , dtCheckBox,	 111,  daCenter,	 false,	"mty_bkg_dsabil_flg",  true, "", dfNone, 0, true,  true, 50);
                     InitDataProperty(0, cnt++ , dtCheckBox,	 111,  daCenter,	 false,	"mty_split_bkg_dsabil_flg",  true, "", dfNone, 0, true,  true, 50);

                     //cntr_img 이미지 셋팅
                     ImageList(0) = "/hanjin/img/button/btns_cntr.gif";  // data 0 일때 이미지 표현, CNTR NO존재
                     ImageList(1) = "/hanjin/img/button/btns_cntr_c.gif";// data 1 일때 이미지 표현, CNTR NO존재안함
                     
                     InitDataCombo(0, "lodg_dchg_div_cd", "Load|Disc", "L|D");
                     
                     InitDataValid(0, "rcc_nm", vtEngUpOnly);
                     InitDataValid(0, "loc_nm", vtEngUpOnly);
                     
/*                     // CNTR_STS_CD 코드는  대문자로 구성된다.
                     InitDataValid(0, "cntr_sts_cd", vtEngUpOnly);
                     // CNTR_STS_NM 는  숫자와 영문 대문자로 구성된다.
                     InitDataValid(0, "cntr_sts_nm", vtEngUpOther, "1234567890 -");*/
                }
                 break;

             case 2:      //sheet2 init
                 with (sheetObj) 
                 {
                     // 높이 설정
                     style.height = 402;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(5, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     var HeadTitle = "|Sel|Type/Size||";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  daCenter, false, "ibflag");
                     InitDataProperty(0, cnt++ , dtCheckBox,	 50,  daCenter,	 false,	"chk_flg",  false, "", dfNone, 0, true,  true, 50);
                     InitDataProperty(0, cnt++ , dtData,     	 150,  daCenter, false, "cntr_tpsz_cd",  false,          "",      dfNone,			0,     false,       true, 2); 
                     InitDataProperty(0, cnt++ , dtHidden,     	 150,  daCenter, false, "lodg_dchg_div_cd",     false, "", dfNone, 0, false, true, 3, true);
                     InitDataProperty(0, cnt++ , dtHidden,     	 150,  daCenter, false, "loc_nm",     false, "", dfNone, 0, false, true, 3, true);
                     
/*                     // CNTR_PRE_STS_CD 코드는  대문자로 구성된다.
                     InitDataValid(0, "cntr_pre_sts_cd", vtEngUpOnly);
                     
                     // 필수입력항목이 누락되었을 때의 메시지 처리.
                     sheetObj.MessageText("UserMsg16") = " Is essential to input the item.";*/
                     
                     CountPosition = 0;
                }
                 break;
         }
     }

      /**
      * Sheet관련 프로세스 처리
      */
     function doActionIBSheet(sheetObj,formObj,sAction) 
     {
         sheetObj.ShowDebugMsg = false;
         // 현재 선택된 row.
         var selrow = sheetObj.SelectRow;
         
         switch(sAction) 
         {
            case IBSEARCH:      //조회
            	
	            sheetObj.WaitImageVisible=false;
	            ComOpenWait(true);
            	formObj.f_cmd.value = SEARCHLIST;
             	formObj.p_rcc_cd.value = formObj.s_rcc_cd.Code;
             	
            	var sXml = sheetObj.GetSearchXml("EES_EQR_1019GS.do", FormQueryString(formObj));
            	var arrXml = sXml.split("|$$|");
            	
            	if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);
            	//if (arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]);
            	ComOpenWait(false);
             	
            	break;
            
			 case SEARCH01: 
				 
		          sheetObj.WaitImageVisible=false;
	              ComOpenWait(true);
	              formObj.f_cmd.value = SEARCH01;
	              formObj.p_rcc_cd.value = formObj.s_rcc_cd.Code;
          	
	              var sXml = sheetObj.GetSearchXml("EES_EQR_1019GS.do", FormQueryString(formObj));
	              var arrXml = sXml.split("|$$|");
         	
	              if (arrXml.length > 0) sheetObjects[1].LoadSearchXml(arrXml[0]);
	                //if (arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]);
	              ComOpenWait(false);
	              break;
            
			 case SEARCH02: // RCC_CD 콤보 리스트 조회
			     formObj.f_cmd.value = SEARCH04;
				 var sXml = sheetObj.GetSearchXml("EES_EQR_1019GS.do" , FormQueryString(formObj)+"&loc_grp_cd=R");
				 ComXml2ComboItem(sXml, formObj.s_rcc_cd, "code", "name");
				 rccCdList = ComXml2ComboString(sXml,"code","name")[0];
				 formObj.s_rcc_cd.InsertItem(0,"ALL","ALL");
				 formObj.s_rcc_cd.Text = 'ALL';
				 break;

			case IBSAVE:        //저장
				
  				var sRow = sheetObj.FindStatusRow("I|U");
  				var arRow = sRow.split(";");

         		formObj.f_cmd.value = MULTI;
         		sheetObj.DoSave("EES_EQR_1019GS.do", eqrFormQryStr(formObj));
				
                break;				

			case IBINSERT:      // 입력 : 현재 선택된 컬럼이후에 행추가 함.
  				var sRow = sheetObj.FindStatusRow("I|U");
  				var arRow = sRow.split(";");

         		formObj.f_cmd.value = MULTI01;
         		sheetObj.DoSave("EES_EQR_1019GS.do", eqrFormQryStr(formObj));
				
                break;
   			break;
        	 		
   		 	case IBDELETE: // 삭제
   		 		ComRowHideDelete(sheetObj, "Sel");
   		 		var nextrow = selrow + 1;
   		 		var bFind = false;
   		 		if(sheetObj.id == "sheet1")
   		 		{
	   		 		if(sheetObj.RowStatus(selrow) == "D")
	   		 		{
	   		 			// 선택된 row가 마지막 row가 아니면 다음 row를 검사한다.
	   		 			if(selrow != sheetObj.RowCount)
	   		 			{
		   		 			while(nextrow <= sheetObj.RowCount)
		   		 			{
		   		 				// 삭제상태가 아닌 row를 찾았을때.
		   		 				if(sheetObj.RowStatus(nextrow) != "D")
		   		 				{
		   		 					bFind = true;
		   		 					break;
		   		 				}
		   		 				nextrow++;
		   		 			}
	   		 			}
	   		 			
	   		 			// 현재 선택된 라인 이후로는 선택할 row가 없을 때 이전 row를 검사한다.
	   		 			if(bFind == false)
	   		 			{
	   		 				nextrow = selrow - 1;
		   		 			while(nextrow > 0)
		   		 			{
		   		 				if(sheetObj.RowStatus(nextrow) != "D")
		   		 				{
		   		 					break;
		   		 				}
		   		 				nextrow--;
		   		 			}
	   		 			}
	   		 		}
	   		 		else
	   		 		{
	   		 			nextrow--;		// 선택된 row는 현재 row임.
	   		 		}
	   		 		sheetObj.SelectCell(nextrow, 3, true);
	   		 		// preStsCd 에서 키값이 공백인 모든 코드를 삭제한다.
	   		 		deleteInvalidCd();
	   		   		// 삭제 다음항목에 대해 세부항목을 출력한다.
	   	            var cntr_sts_cd = sheetObj.CellValue(nextrow, "cntr_sts_cd");
	   	            document.form.cntr_sts_cd.value = cntr_sts_cd;
	   	            SheetFiltering(1,cntr_sts_cd,"cntr_sts_cd");
   		 		}
	 		break;
         }
     }

     /**
      * sheet1 에서 더블클릭했을 때의 처리
      */
     function sheet1_OnClick(sheetObj, Row, Col, Val) 
     {
    	 
    	 sheetObjects[1].RemoveAll();
    	 
    	 if(sheetObj.ColSaveName(Col) == "cntr_img") { 
    		 if(sheetObj.CellValue(Row , Col) != "-1") { 
        		 var formObject = document.form; 
        		 
        		 formObject.p_loc_cd.value = sheetObj.CellValue(Row,"loc_nm");
        		 var flag = sheetObj.CellValue(Row,"lodg_dchg_div_cd");
        		 
        		 formObject.plodg_dchg_div_cd.value = flag;
        		     		
        		 var sheetObject2 = sheetObjects[1];
        		 doActionIBSheet(sheetObject2,formObject,SEARCH01); 
    		 }
    	 }
    	 	 	    				  
     }
     
     function sheet1_OnSearchEnd(sheetObj, msg){
 	   	for(var i=1; i<=sheetObj.LastRow; i++){
 	   		if(sheetObj.CellValue(i,"lodg_dchg_div_cd") == 'L'){
 	   		  sheetObj.CellEditable(i ,"mty_split_bkg_dsabil_flg") = false;
 	   		}else{
 	   		  sheetObj.CellEditable(i ,"mty_bkg_dsabil_flg") = false;
 	   		}
	   	}  
     }
     
     /**
      * sheet1_OnSaveEnd
      * 그리드 저장후 이벤트 처리
      * 그리드 agmt no 변경시 정합성 체크 및 Lessro ABBR 조회
      */
     function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	 doActionIBSheet(sheetObj,document.form,IBSEARCH);
     }

     /**
      * stsCd 값 체크.
      * @param sheetObj
      * @param row
      * @param col
      * @param value
      * @return
      *//*
     function sheet1_OnChange(sheetObj, row, col, value)
     {
    	 if(sheetObj.ColSaveName(Col) == "cntr_img") { 
    		 alert(sheetObj.CellValue(Row,"loc_nm"));
    	 }
    	 
    	 
    	 
		if(sheetObj.ColSaveName(col) == "cntr_sts_cd")
		{
             if(value.length != 3 && value.length != 0) 
             {
                 // 오류메시지 : Please check up the CODE.
                 ComShowCodeMessage("MST01017");
                 sheetObj.CellValue(row,"cntr_sts_cd") = "";
                 sheetObj.SelectCell(row, 3, true);
                 return;
             }
             
             var cur_code = "";
             var sel_code = sheetObj.CellValue(row,"cntr_sts_cd");
             
             // sheet내의 키 중복 체크.
             for(var i=1; i<=sheetObj.RowCount; i++)
             {
            	 if(i != row)		// 자기자신이 아니면 중복체크를 한다.
            	 {
            		 cur_code = sheetObj.CellValue(i,"cntr_sts_cd");
            		 if(sel_code == cur_code)
            		 {
            			 // 오류메시지 : 데이터가 중복됩니다.
            			 ComShowCodeMessage("MST00002",cur_code);
            			 sheetObj.CellValue(row,"cntr_sts_cd") = "";
            			 sheetObj.SelectCell(row, 2, true);
            			 return;
            		 }
            	 }
             }		// End for
		}
     }
*/
     /**
     * preStsCd 값 체크.
     * @param sheetObj
     * @param row
     * @param col
     * @param value
     * @return
     */
     function sheet2_OnChange(sheetObj, row, col, value)
     {
    	 if(sheetObj.ColSaveName(col) == "cntr_pre_sts_cd")
    	 {
    		 if(value.length != 3 && value.length != 0) 
    		 {
    			 // 오류메시지 : Please check up the CODE.
                 ComShowCodeMessage("MST01017");
                 sheetObj.CellValue(row,"cntr_pre_sts_cd") = "";
                 sheetObj.SelectCell(row, 2, true);
                 return;
             }
             
             var cur_code = "";
             var sel_code = sheetObj.CellValue(row,"cntr_pre_sts_cd");
             
             // sheet내의 키 중복 체크.
             for(var i=1; i<=sheetObj.RowCount; i++)
             {
            	 if(sheetObj.RowHidden(i)==false && i != row)		// hidden이 아니고,자기자신이 아니면 중복체크를 한다.
            	 {
            		 cur_code = sheetObj.CellValue(i,"cntr_pre_sts_cd");
            		 if(sel_code == cur_code)
            		 {
            			 // 오류메시지 : 데이터가 중복됩니다.
            			 ComShowCodeMessage("MST00002",cur_code);
            			 sheetObj.CellValue(row,"cntr_pre_sts_cd") = "";
            			 sheetObj.SelectCell(row, 2, true);
            			 return;
            		 }
            	 }
             }		// End for
    	 }
     }

     /* 개발자 작업  끝 */