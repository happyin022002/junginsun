/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0104.js
*@FileTitle : Expense Summary by Office 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.08
*@LastModifier : 최 선
*@LastVersion : 1.6
* 2009.02.27 한아영
* 1.0 최초 생성 
*----------------------------------------------------------
* History
* 2009.02.27 조풍연   1.1 [N200901080024] 'Report(Expense Summary by Office) 메뉴 개발 요청 ' 
* 2009.04.14 조풍연   1.2 [R200904140001] 검색 조건 오류 수정(BKG_TERM 그룹핑), reset 버튼 액션  ( sub combo reset)  수정
* 2010.10.08 최   선   1.3 [CHM-201006411] S/O DOOR NODE 팝업창의 RETURN VALUE 오류 수정
* 2010.10.27 최   선   1.4 [CHM-201006612] Expense Summary 조회 항목 추가 개발 요청
* 2010.12.17 손은주   1.5 [CHM-201007628] Report 화면에 Negotiated 값 반영 칼럼 추가 요청
* 2011.02.08 최   선   1.6 [CHM-201108757] W/O Amount 20' Sum, 40' Sum 컬럼 추가 
* 2011.05.23 박재흥   1.7 [CHM-201109770-01] MEXBB 에서 처리되는 Rail S/O 에 대한 exception logic 적용 (US Rail surcharge 기능 연계)
* 2011.07.20 민정호   1.8 [CHM-201112196] Expense Summary Report에 Invoice 상태코드를 조회조건에 추가
* 2012.02.15 금병주   1.6 [CHM-201216258] [TRS] Expense Summary Excel Down 버튼 추가
* 2012.05.29 신동일   1.7 [CHM-201217633] [TRS] 구주 Hinterland T/F 및 시스템 개발 Project(Distance 추가)
* 2012.11.19 변종건 [CHM-201221451-01, CHM-201221386-01] Report의 Bound column 추가, Report의 month로 구분 조회 조건 추가
* 2013.04.12 조인영 [CHM-201323766] Report Multiple select 조회 기능 추가
* 2013.08.22 조인영 [CHM-201326241] [TRS] Report data 개수 표시
* 2015.03.17 9014787 [CHM-201534219] Incentive Invoice 실적 추가 + Toll Fee
=========================================================*/ 

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0104 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0104() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/


/* 공통전역변수 */
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0 ;

/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
  sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화 
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
 
function loadPage() {
   var formObject = document.form;
   var input_office =formObject.input_office.value;
   
  for(i=0;i<sheetObjects.length;i++){
    //khlee-시작 환경 설정 함수 이름 변경
    ComConfigSheet(sheetObjects[i]);
    initSheet(sheetObjects[i],i+1);
    //khlee-마지막 환경 설정 함수 추가
    ComEndConfigSheet(sheetObjects[i]);
    
    //sheet를 화면에서 보이지 않게 한다.
    visibleSheet(sheetObjects[i],i+1);
  }
  
  if(input_office !="HAMSC" && input_office !="RTMSC" && input_office !="LEHSC" && input_office !="FXTSC"){
	  formObject.ets_yn.value="";
	  document.form.ets_yn.disabled = true;
  }
	//html컨트롤 이벤트초기화
	initControl();    
	distance_col_control();
	doActionIBSheet(sheetObjects[0],document.form,COMMAND01); 	
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
    //Axon ??? ??1. ???catch
    /*
    axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
    axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
    axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
    axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
    axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
    axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리 
    axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
    */
}

//Axon ??? ??2. ??????? --- start
/**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 **/
function engnum_keypress() {
    //???? ????
//            ComKeyOnlyAlphabet('uppernum');
}

/**
 * BKG Creation?? manual? ???? ??? ????. <br>
 **/
function manual_click() {
    //manual이 체크된 경우만 Bkg_no를 편집 가능으로 한다.
//            form.boo_bkg_no.readOnly =!form.manual.checked;
}

/**
 * BKG Creation탭의 Booking No가 바뀐경우 기능을 처리한다. <br>
 **/
function bkgno_keyup() {
    //bkg_no를 수정해서 저장된값과 다른경우 bl_no를 지우고, 같은경우 bl_no를 살린다.
    /*
    if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
	form.boo_bl_no.value = "";
    else
	form.boo_bl_no.value = form.hdn_boo_bl_no.value;
	*/
}

/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 **/
function obj_blur(){
    //입력Validation 확인하기
//            return ComChkObjValid(event.srcElement);
}

/**
 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
 **/
function obj_focus(){
    //?????? ???
//            ComClearSeparator(event.srcElement);
}

/**
 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
 **/
function obj_keypress(){
    //???????
//            ComKeyOnlyNumber(event.srcElement);
}

//Axon 이벤트 처리2. 이벤트처리함수 --- end

/**
 * Sheet 기본 설정 및 초기화 
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */ 
function visibleSheet(sheetObj,sheetNo) {
    switch(sheetNo) {
    	  case 2:
    	      sheetObj.visible = false;
    	      break;
    } 
}                                                                                    
                                                                                                      
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */                                                                      
document.onclick = processButtonClick;                                                                
                                                                                                               
/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */  
function processButtonClick(){
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    /******************************************************/
    var formObject = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");
        
        /***********************************************************************************************************
          이미지 클릭 이벤트 처리, popup도 역시 이곳에서 함
          공통코드: CoFormControl.js 에 정의 되어있습니다. 이 변수를 통하여 ServiceCommand에서 분기 합니다.    
         **********************************************************************************************************/

        switch(srcName) {
          case "btns_calendar":
        	var cal2 = new ComCalendarFromTo();
			cal2.displayType = "date";
			cal2.select(document.form.from_date, document.form.to_date, 'yyyyMMdd');
            break;
            
          case "btns_frmnode": //FromNode Popup창
            openHireYardPopup('getFromNode');
          break;
          
          case "btns_vianode": //ViaNode Popup창
            openHireYardPopup('getViaNode');
          break;
          
          case "btns_tonode": //ToNode Popup창
            openHireYardPopup('getToNode');
          break;
          
          case "btns_dorloc": //DoorLocation Popup창
            openHireYardPopup('getDorLoc');
          break;

          case "btn_reset":
            formObject.reset();
            sheetObject.RemoveAll();
            document.search_fm_yard.RemoveAll();						//sub combo reset;
            document.search_via_yard.RemoveAll();						//sub combo reset;
            document.search_to_yard.RemoveAll();						//sub combo reset;
            document.search_door_yard.RemoveAll();					//sub combo reset;
            formObject.status_cd.CheckIndex(0) = true;
            formObject.sel_costmode.CheckIndex(0) = true;
            formObject.sel_transmode.CheckIndex(0) = true;
            formObject.sel_sotype.CheckIndex(0) = true;
			for(var i = 1 ; i < formObject.status_cd.GetCount() ; i++) {
				formObject.status_cd.CheckIndex(i) = false;
			}            
			for(var i = 1 ; i < formObject.sel_costmode.GetCount() ; i++) {
				formObject.sel_costmode.CheckIndex(i) = false;
			}
			for(var i = 1 ; i < formObject.sel_transmode.GetCount() ; i++) {
				formObject.sel_transmode.CheckIndex(i) = false;
			}
			for(var i = 1 ; i < formObject.sel_sotype.GetCount() ; i++) {
				formObject.sel_sotype.CheckIndex(i) = false;
			}
			sheetObject.CountFormat = "[SELECTDATAROW / TOTALROWS]";
            break;
            
          case "btn_minimize":
            Mincount = (Mincount+1)%2 ;
            Minimize(Mincount);
            break;             
          
          case "btn_retrieve":
            if (ComIsNull(formObject.from_date) || ComIsEmpty(formObject.to_date)) {
              ComShowCodeMessage("TRS90124")+" (Date)";
              return false;
            }
            
            if (ComIsNull(formObject.input_office) || ComIsEmpty(formObject.input_office)) {
              ComShowCodeMessage("TRS90124")+" (Office Code)";
              return false;
            }
          
            var days_between = ComGetDaysBetween(formObject.from_date , formObject.to_date) ;  // 조회 기간
            if ( days_between > 365 ) {
              ComShowMessage(" Possible inquiry period is limited to 12 month.");
              return false;
            }
                  
            //이전 조회결과값을 clear 한다.
			      sheetObject.RemoveAll() ;		       
			      sheetObject.CountFormat = "[SELECTDATAROW / TOTALROWS]";

			      //Date선택에 따른 W/O,Invoice 항목 보이기/안보이기 설정 
          //  showHide_period(sheetObject);                     
               
            //Volume By Type/Size 의 show/hide action
            showHide_volume(sheetObject);
            
            //grid_flg 값 추가 2012.02.15 kbj
            formObject.hid_grid_flg.value = 'Y';
            
            doActionIBSheet(sheetObject,formObject,IBSEARCH);        

           break;    
          
           // xls Down 버튼 클릭시 action 추가 2012.02.15 kbj
          case "btng_rtv_downxls" :
        	  if (sheetObject.RowCount < 1) return;
        	  if (ComIsNull(formObject.from_date) || ComIsEmpty(formObject.to_date)) {
                  ComShowCodeMessage("TRS90124")+" (Date)";
                  return false;
                }
                
                if (ComIsNull(formObject.input_office) || ComIsEmpty(formObject.input_office)) {
                  ComShowCodeMessage("TRS90124")+" (Office Code)";
                  return false;
                }
              
                var days_between = ComGetDaysBetween(formObject.from_date , formObject.to_date) ;  // 조회 기간
                if ( days_between > 365 ) {
                  ComShowMessage(" Possible inquiry period is limited to 12 month.");
                  return false;
                }

                //Volume By Type/Size 의 show/hide action
                showHide_volume(sheetObject);

            	//grid_flg 값 추가 2012.02.15 kbj
                formObject.hid_grid_flg.value = 'N';
                
                doActionIBSheet(sheetObject,formObject,IBSEARCH);      
        	
          break;
          
          case "btng_downexcel":  
            //이전 조회결과값을 clear 한다.
			      sheetObject1.RemoveAll() ;		       
			
			      //Date선택에 따른 W/O,Invoice 항목 보이기/안보이기 설정 
            //showHide_period(sheetObject1);                     
               
            //Volume By Type/Size 의 show/hide action
            showHide_volume(sheetObject1);
                        
           //row 추가           
            for (i=0; i<sheetObject.RowCount; i++)
            {
                sheetObject1.DataInsert(-1);
            }
       
		      	//데이터 copy
            sheetObject.Copy2SheetCol(sheetObject1);
        
         
            //total row 삭제 
            for (i=sheetObject1.RowCount+2; i>0; i--)
            { 
                //if (sheetObject1.CellValue(i,'div') != "0000000000") {
            	if (sheetObject1.CellValue(i,'div') != "11") {  // SUB TOTAL, TOTAL 모두 제거
                	  sheetObject1.RowDelete(i, false);
                }
            }
                 
            sheetObject1.ColHidden("chk") = true; 
                 
            sheetObject1.ExcelPrint = "";    
            doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
      
          break;
          
          case "btns_office": //M CNTR
            if( validation_check() ) {
              var ofc_cd = formObject.input_office.value;
			  ComOpenWindow('ESD_TRS_0964.screen?ctrl_ofc_cd='+ofc_cd, 'ESD_TRS_0964', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:410px;dialogHeight:400px', true);
            break; }  

          case "btng_detailinquiry":
            formObject.hid_from_date.value = removeBar(formObject.from_date.value);
            formObject.hid_to_date.value = removeBar(formObject.to_date.value);
            formObject.hid_io_bnd.value = removeBar(formObject.io_bound.value);
            
            if (formObject.hid_io_bnd.value == 'P'){
            	formObject.hid_io_bnd.value = 'I,O'
            } else if (formObject.hid_io_bnd.value == 'A'){
            	formObject.hid_io_bnd.value = 'I,O,T,N'
            }
           
            var iCheckRow = sheetObject.CheckedRows("chk");
            if (iCheckRow < 1) ComShowCodeMessage('COM12114', 'Row');
          
            var Rows = sheetObject.FindCheckedRow("chk");
            var arrRow = Rows.split("|");
            
            // CHM-201534219 Incentive Invoice 실적 추가 + Toll Fee
            // Incentive Inv ( div 11, trsp_so_tp_cd '')
            for (idx=0; idx<arrRow.length-1; idx++)
            {
            	if(sheetObject.CellValue(arrRow[idx],"div") == "11" && sheetObject.CellValue(arrRow[idx],"trsp_so_tp_cd") == ""){
            		ComShowMessage('This Invoice is for Incentive.');
            		return;
            	}
            }
            // 해당 컬럼의 속성이 dtRadioCheck 이므로 한개만 선택 가능하다.
            // 따라서 팝업을 for문안에서 띄어도 한번밖에 뜨지 않는다. 
            for (idx=0; idx<arrRow.length-1; idx++)
            { 
            	formObject.row_wo_ofc_cd.value    = sheetObject.CellValue(arrRow[idx],"wo_ofc_cd");
            	formObject.row_inv_ofc_cd.value  = sheetObject.CellValue(arrRow[idx],"inv_ofc_cd");
            	formObject.row_costmode.value  = sheetObject.CellValue(arrRow[idx],"trsp_cost_dtl_mod_cd");
            	formObject.row_transmode.value = sheetObject.CellValue(arrRow[idx],"trsp_crr_mod_cd");
            	formObject.row_sotype.value    = sheetObject.CellValue(arrRow[idx],"trsp_so_tp_cd");
            	formObject.row_sotype_nm.value    = sheetObject.CellValue(arrRow[idx],"trsp_so_tp_nm");
            	formObject.row_bkg_term_cd.value    = sheetObject.CellValue(arrRow[idx],"bkg_term_cd");      
            	formObject.row_bkg_term_nm.value    = sheetObject.CellValue(arrRow[idx],"bkg_term_nm");         	
                formObject.row_fm_loc.value    = sheetObject.CellValue(arrRow[idx],"fm_nod_cd");
                formObject.row_via_loc.value   = sheetObject.CellValue(arrRow[idx],"via_nod_cd");
                formObject.row_to_loc.value    = sheetObject.CellValue(arrRow[idx],"to_nod_cd");
                formObject.row_door_loc.value  = sheetObject.CellValue(arrRow[idx],"dor_nod_cd");   
                formObject.row_inv_curr.value  = sheetObject.CellValue(arrRow[idx],"inv_curr_cd");
                formObject.row_status_cd.value = formObject.status_cd.Code;
                                
                //noRtnPopup('', 'width=825,height=560,menubar=0,status=0,scrollbars=0,resizable=0,top=45,left=260');
                //formObject.target = "noRtnPopup";
                //formObject.action = "ESD_TRS_0209.do";
                //formObject.submit();   
                formObject.f_cmd.value = "";
                ComPostOpenWindow("ESD_TRS_0209.do", "noRtnPopup", "width=825,height=560,menubar=0,status=0,scrollbars=0,resizable=0");
                formObject.target = 'noRtnPopup';
                formObject.submit();
             
            } 
              
            break;      
            
 
              
        } // end switch
    }catch(e) {     
        /*
          자바 스크립트 에러가 발생할시 오동작이 납니다. 고객에게 이 경우 아래의 메세지가 뿌려지게 해야합니다.
          물론 화면에서 다음의 메세지를 보시면 무조건 '자바스크립트 에러구나'라고 확인하실수 가 있습니다.
        */
        if( e == "[object Error]") {
          ComShowMessage(OBJECT_ERROR);
        } else {
          ComShowMessage(e);
        }
    }
}

/* Sheet관련 프로세스 처리 */
function doActionIBSheet(sheetObj,formObj,sAction) {
  sheetObj.ShowDebugMsg = false;

  switch(sAction) {  
  	 case COMMAND01:
  		 	formObj.f_cmd.value = COMMAND01;
		
  		 	var sXml = sheetObj.GetSearchXml("ESD_TRS_0104GS.do", FormQueryString(formObj));
  		 	var arrXml = sXml.split("|$$|");
  		 	if (arrXml.length > 0) 
  		 		ComXml2ComboItem(arrXml[0], formObj.status_cd, "val", "name");
  		 		ComXml2ComboItem(arrXml[1], formObj.sel_costmode, "val", "name");
  		 		ComXml2ComboItem(arrXml[2], formObj.sel_transmode, "val", "name");
  		 		ComXml2ComboItem(arrXml[3], formObj.sel_sotype, "val", "name");
  		 	
  		 	formObj.status_cd.MultiSelect = true;
  		 	formObj.sel_costmode.MultiSelect = true;
  		 	formObj.sel_transmode.MultiSelect = true;
  		 	formObj.sel_sotype.MultiSelect = true;
			formObj.status_cd.index = 0;						
			formObj.sel_costmode.index = 0;						
			formObj.sel_transmode.index = 0;						
			formObj.sel_sotype.index = 0;						
  		 break;
  		 
     case IBSEARCH:   //조회
      if(!validateForm(sheetObj,formObj,sAction)) {
        return false;
      }

      formObj.hid_from_date.value = removeBar(formObj.from_date.value);
      formObj.hid_to_date.value = removeBar(formObj.to_date.value);

			if(document.search_fm_yard.Code != '' || formObj.search_fm_loc.value != '') {
				formObj.hid_from_node.value = formObj.search_fm_loc.value+document.search_fm_yard.Code;
			}else{
				formObj.hid_from_node.value = '';
			}

			if(document.search_via_yard.Code != '' || formObj.search_via_loc.value != '') {
				formObj.hid_via_node.value = formObj.search_via_loc.value+document.search_via_yard.Code;
			}else{
				formObj.hid_via_node.value = '';
			}

			if(document.search_to_yard.Code != '' || formObj.search_to_loc.value != '') {
				formObj.hid_to_node.value = formObj.search_to_loc.value+document.search_to_yard.Code;
			}else{
				formObj.hid_to_node.value = '';
			}

			if(document.search_door_yard.Code != '' || formObj.search_door_loc.value != '') {
				formObj.hid_door_node.value = formObj.search_door_loc.value+document.search_door_yard.Code;
			}else{
				formObj.hid_door_node.value = '';
			}
			
			 formObj.f_cmd.value = SEARCH01;
			 
	  //grid flag 에 따라 retreive 와 xls down 인지 구분 2012.02.15 kbj
	  if(formObj.hid_grid_flg.value == 'Y'){
		  	sheetObj.DoSearch4Post("ESD_TRS_0104GS.do", TrsFrmQryString(formObj));
	  }else if(formObj.hid_grid_flg.value == 'N'){
		  	ComOpenWait(true);
		  	formObj.f_cmd.value = SEARCH01;
		    formObj.target = "_blank"
			formObj.action = "ESD_TRS_0244.do?" + TrsFrmQryString(formObj);
		    formObj.submit();
		    ComOpenWait(false);
	  }
      break;

    case IBCLEAR:    //Clear
      sheetObj.RemoveAll();
      break;
      
    case IBDOWNEXCEL:  //엑셀내려받기       
        //total값 없는 sheet 엑셀변환
        sheetObj.SpeedDown2Excel(true);  
        
        break;
  }
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
  with(formObj){
    /**
     * @TODO 개발자 분들께서 넣어 주셔야 합니다. 
     */
    //if (!ComIsNumber(formObj.iPage)) {
    //  return false;
     // }
  }
  
  return true;
}
  
/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet_OnSearchEnd(sheetObj,errMsg){
  if(errMsg!=null){
    ComShowMessage(errMsg);
  }
}

/**
 * 날짜구분 선택시 period
 */
function change_period(){
  var formObject = document.form;
  var sheetObject = formObject.sheet1;
  var val=""; 

  formObject.hid_period.value = formObject.sel_period.value ;
  
}


/**
 * 날짜구분 선택시 period
 */
function showHide_period(sheetObject){
  
  var formObject = document.form;
  
  for(i=0;i<2;i++){
   if (formObject.sel_period.value == "S"
      || formObject.sel_period.value == "W") {
    sheetObject.ColHidden("wrk_d2_amt") = false;
    sheetObject.ColHidden("wrk_d4_amt") = false;
    sheetObject.ColHidden("wrk_tot_amt") = false;
    sheetObject.ColHidden("wrk_d2_amt_usd") = false;
    sheetObject.ColHidden("wrk_d4_amt_usd") = false;
    sheetObject.ColHidden("wrk_tot_amt_usd") = false;
         
    sheetObject.ColHidden("inv_d2_amt") = true;         
    sheetObject.ColHidden("inv_d4_amt") = true;        
    sheetObject.ColHidden("inv_tot_amt") = true;    
    sheetObject.ColHidden("inv_d2_amt_usd") = true;    
    sheetObject.ColHidden("inv_d4_amt_usd") = true;   
    sheetObject.ColHidden("inv_tot_amt_usd") = true; 
    
   }else {          	
    sheetObject.ColHidden("wrk_d2_amt") = true;
    sheetObject.ColHidden("wrk_d4_amt") = true;
    sheetObject.ColHidden("wrk_tot_amt") = true;
    sheetObject.ColHidden("wrk_d2_amt_usd") = true;
    sheetObject.ColHidden("wrk_d4_amt_usd") = true;
    sheetObject.ColHidden("wrk_tot_amt_usd") = true;
      
      
    sheetObject.ColHidden("inv_d2_amt") = false;         
    sheetObject.ColHidden("inv_d4_amt") = false;        
    sheetObject.ColHidden("inv_tot_amt") = false;    
    sheetObject.ColHidden("inv_d2_amt_usd") = false;    
    sheetObject.ColHidden("inv_d4_amt_usd") = false;   
    sheetObject.ColHidden("inv_tot_amt_usd") = false;     
   } 
  }
  
}
    
/**
 * Volumn by Containner Type/Size visible / unvisible
 */

function showHide_volume(sheetObject){
  var formObject = document.form;  
  
  for(i=0;i<2;i++){
  if (formObject.vol_size[0].checked == true) {
    sheetObject.ColHidden("d2_cnt") = false;
    sheetObject.ColHidden("d4_cnt") = false;
    sheetObject.ColHidden("d5_cnt") = false;
    sheetObject.ColHidden("d7_cnt") = false;
    sheetObject.ColHidden("r2_cnt") = false;
    sheetObject.ColHidden("r4_cnt") = false;
    sheetObject.ColHidden("r5_cnt") = false;
    sheetObject.ColHidden("r7_cnt") = false;
    sheetObject.ColHidden("r8_cnt") = false;
    sheetObject.ColHidden("f2_cnt") = false;
    sheetObject.ColHidden("f4_cnt") = false;
    sheetObject.ColHidden("f5_cnt") = false;
    sheetObject.ColHidden("a2_cnt") = false;
    sheetObject.ColHidden("a4_cnt") = false;
    sheetObject.ColHidden("a5_cnt") = false;
    sheetObject.ColHidden("p2_cnt") = false;
    sheetObject.ColHidden("p4_cnt") = false;
    sheetObject.ColHidden("o2_cnt") = false;
    sheetObject.ColHidden("o4_cnt") = false;
	sheetObject.ColHidden("o5_cnt") = false; //20121022
	sheetObject.ColHidden("o7_cnt") = false; //2018.05.08 추가 [CSR #3841]
    sheetObject.ColHidden("s2_cnt") = false;
    sheetObject.ColHidden("s4_cnt") = false;
    sheetObject.ColHidden("t2_cnt") = false;
    sheetObject.ColHidden("t4_cnt") = false;
    sheetObject.ColHidden("dx_cnt") = false;
    sheetObject.ColHidden("dw_cnt") = false;
  }else if (formObject.vol_size[1].checked == true) {
    sheetObject.ColHidden("d2_cnt") = true;
    sheetObject.ColHidden("d4_cnt") = true;
    sheetObject.ColHidden("d5_cnt") = true;
    sheetObject.ColHidden("d7_cnt") = true;
    sheetObject.ColHidden("r2_cnt") = true;
    sheetObject.ColHidden("r4_cnt") = true;
    sheetObject.ColHidden("r5_cnt") = true;
    sheetObject.ColHidden("r7_cnt") = true;
    sheetObject.ColHidden("r8_cnt") = true;
    sheetObject.ColHidden("f2_cnt") = true;
    sheetObject.ColHidden("f4_cnt") = true;
    sheetObject.ColHidden("f5_cnt") = true;
    sheetObject.ColHidden("a2_cnt") = true;
    sheetObject.ColHidden("a4_cnt") = true;
    sheetObject.ColHidden("a5_cnt") = true;
    sheetObject.ColHidden("p2_cnt") = true;
    sheetObject.ColHidden("p4_cnt") = true;
    sheetObject.ColHidden("o2_cnt") = true;
    sheetObject.ColHidden("o4_cnt") = true;
	sheetObject.ColHidden("o5_cnt") = true; //20121022
	sheetObject.ColHidden("o7_cnt") = true; //2018.05.08 추가 [CSR #3841]
    sheetObject.ColHidden("s2_cnt") = true;
    sheetObject.ColHidden("s4_cnt") = true;
    sheetObject.ColHidden("t2_cnt") = true;
    sheetObject.ColHidden("t4_cnt") = true;
    sheetObject.ColHidden("dx_cnt") = true;
    sheetObject.ColHidden("dw_cnt") = true;
   }
  }
  
}


function Minimize(nItem)
{
	var objs = document.all.item("showMin");

	if ( nItem == "1" )
	{
		objs.style.display = "none";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(24);
	}
	else
	{
		objs.style.display = "inline";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(20);
	}
}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	
	function initSheet(sheetObj,sheetNo) {
    var cnt = 0;		
	
    var cnt = 0;
    if( sheetNo == 1 || sheetNo == 2 ) {
          with (sheetObj) {
                // 높이 설정
                if(sheetNo == 2){
                  style.height = 0;
                }else{
                	style.height = 360;
                }
                
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				 MergeSheet = msHeaderOnly;
				         
                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 2, 1, 9, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(108, 3, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다                                 
                InitHeadMode(true, false, false, true, false, false);
                
				        var HeadTitle = "Check\nbox|W/O\nOffice|Invoice\nOffice|Month|Cost\nMode|Trans\nMode|BND|S/O Type|Term|From|Via|To|Door|ETS|Distance|Distance|INV Curr|" +
				        "W/O Amount (Local)|W/O Amount (Local)|W/O Amount (Local)|W/O Amount (Local)|W/O Amount (Local)|W/O Amount (Local)|W/O Amount (Local)|W/O Amount (Local)|W/O Amount (Local)|W/O Amount (Local)|W/O Amount (Local)|W/O Amount (Local)|W/O Amount (Local)|W/O Amount (Local)|W/O Amount (Local)|W/O Amount (Local)|W/O Amount (Local)|W/O Amount (Local)|" +
				        "W/O Amount (USD)|W/O Amount (USD)|W/O Amount (USD)|W/O Amount (USD)|W/O Amount (USD)|W/O Amount (USD)|W/O Amount (USD)|W/O Amount (USD)|W/O Amount (USD)|W/O Amount (USD)|W/O Amount (USD)|W/O Amount (USD)|W/O Amount (USD)|W/O Amount (USD)|W/O Amount (USD)|W/O Amount (USD)|W/O Amount (USD)|W/O Amount (USD)|" +
				        "HJL Handling Fee|HJL Handling Fee|HJL Handling Fee|HJL Handling Fee|HJL Handling Fee|HJL Handling Fee|" +
				        "Invoice Amount (Local)|Invoice Amount (Local)|Invoice Amount (Local)|Invoice Amount (Local)|Invoice Amount (Local)|Invoice Amount (Local)|Invoice Amount (Local)|" +
				        "Invoice Amount (USD)|Invoice Amount (USD)|Invoice Amount (USD)|Invoice Amount (USD)|Invoice Amount (USD)|Invoice Amount (USD)|Invoice Amount (USD)|" +
				        "Volume|Volume|Volume|Volume|" +
				        "Volume By Container Type/Size|Volume By Container Type/Size|Volume By Container Type/Size|Volume By Container Type/Size|" +
				        "Volume By Container Type/Size|Volume By Container Type/Size|Volume By Container Type/Size|Volume By Container Type/Size|Volume By Container Type/Size|" +
				        "Volume By Container Type/Size|Volume By Container Type/Size|Volume By Container Type/Size|" + 
				        "Volume By Container Type/Size|Volume By Container Type/Size|Volume By Container Type/Size|" +
				        "Volume By Container Type/Size|Volume By Container Type/Size|" +
				        "Volume By Container Type/Size|Volume By Container Type/Size|Volume By Container Type/Size|Volume By Container Type/Size|" +
				        "Volume By Container Type/Size|Volume By Container Type/Size|" +
				        "Volume By Container Type/Size|Volume By Container Type/Size|" +
				        "Volume By Container Type/Size|Volume By Container Type/Size";
				        
		            
                var HeadTitle1 = "Check\nbox|W/O\nOffice|Invoice\nOffice|Month|Cost\nMode|Trans\nMode|BND|S/O Type|Term|From|Via|To|Door|ETS|Km|R.Link|INV Curr|" +
				        "20' Basic|20' FSC|20' Nego|20' TollFee|20' Additional|20' Sum|40' Basic|40' FSC|40' Nego|40' TollFee|40' Additional|40' Sum|Total (Basic)|Total (FSC)|Total (Nego)|Total (TollFee)|Total (Additional)|Total (Sum)|" +
				        "20' Basic|20' FSC|20' Nego|20' TollFee|20' Additional|20' Sum|40' Basic|40' FSC|40' Nego|40' TollFee|40' Additional|40' Sum|Total (Basic)|Total (FSC)|Total (Nego)|Total (TollFee)|Total (Additional)|Total (Sum)|" +
				        "20' (Local)|40' (Local)|Total(Local)|20' (USD)|40' (USD)|Total(USD)|" +
				        "20' Basic|20' Surcharge|40' Basic|40' Surcharge|Total (Basic)|Total (Surcharge)|Total (Sum)|" +
				        "20' Basic|20' Surcharge|40' Basic|40' Surcharge|Total (Basic)|Total (Surcharge)|Total (Sum)|" +
				        "20'|40'|Teu|Box|" +
				        "D2|D4|D5|D7|" +
				        "R2|R4|R5|R7|R8|" + 
				        "F2|F4|F5|" + 
				        "A2|A4|A5|" + 
				        "P2|P4|" +
				        "O2|O4|O5|O7|" + 
				        "S2|S4|" +
				        "T2|T4|" +
				        "DX|DW";
                 
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				InitHeadRow(1, HeadTitle1, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	            InitDataProperty(0, cnt++ , dtRadioCheck, 45,    daCenter, true,   "chk" 				 , false,   	   "",       dfNone,       0,     false,       false,false,false,false);
                InitDataProperty(0, cnt++ , dtData,       60,    daCenter, true,   "wo_ofc_cd"           , false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daCenter, true,   "inv_ofc_cd"          , false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daCenter, true,   "cre_month"           , false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       45,    daCenter, true,   "trsp_cost_dtl_mod_cd", false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       45,    daCenter, true,   "trsp_crr_mod_cd"     , false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       30,    daCenter, true,   "trsp_bnd_cd"     	 , false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       75,    daLeft,   true,   "trsp_so_tp_nm"  	 , false,          "",       dfNone,       0,     false,       false);                               
                InitDataProperty(0, cnt++ , dtData,       60,    daCenter, true,   "bkg_term_nm"         , false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daCenter, true,   "fm_nod_cd"           , false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daCenter, true,   "via_nod_cd"          , false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daCenter, true,   "to_nod_cd"           , false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daCenter, true,   "dor_nod_cd"          , false,          "",       dfNone,       0,     false,       false);
                //2012.08.16 Add ETS column by SHIN DONG IL
                InitDataProperty(0, cnt++ , dtData,       30,    daCenter, true,   "ets_yn"          	 , false,          "",       dfNone,       0,     false,       false);
				//2012.06.01 Add Distance column by SHIN DONG IL
				InitDataProperty(0, cnt++, dtData,  	  50, 	 daRight,  true, 	"ttl_dist"			 , false, 		   "", 	  dfInteger, 	   0, 	  false, 	   false);
				InitDataProperty(0, cnt++, dtData,  	  50, 	 daCenter, true, 	"lnk_dist_div_cd"	 , false, 		   "",       dfNone, 	   0, 	  false, 	   false);
				
                InitDataProperty(0, cnt++ , dtData,       60,    daCenter, true,   "inv_curr_cd"         , false,          "",       dfNone,       0,     false,       false);
                
                InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "bzc_d2_amt"          , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "fuel_scg_d2_amt"     , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "nego_d2_amt"     	 , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "toll_fee_d2_amt"     	 , false,          "",       dfFloat,      2,     false,       false);
                // 데이터 추가 W/O D2 Additional 2012.02.21 kbj
                InitDataProperty(0, cnt++ , dtData,       100,    daRight,  true,  "truk_etc_add_d2_amt" , false,          "",       dfFloat,      2,     false,       false);
               
                //InitDataProperty(0, cnt++ , dtData,	      70,    daRight,  true,   "scg_vat_d2_amt"     , false,          "",       dfFloat,      2,     false,       false);
                
                InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "d2_amt_sum"     	 , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "bzc_d4_amt"          , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "fuel_scg_d4_amt"     , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "nego_d4_amt"     	 , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "toll_fee_d4_amt"     	 , false,          "",       dfFloat,      2,     false,       false);
                //데이터 추가 W/O D4 Additional 2012.02.21 kbj
                InitDataProperty(0, cnt++ , dtData,       100,    daRight,  true,  "truk_etc_add_d4_amt"  , false,          "",       dfFloat,      2,     false,       false);
                //InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "scg_vat_d4_amt"     , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "d4_amt_sum"     	 , false,          "",       dfFloat,      2,     false,       false);
                
                InitDataProperty(0, cnt++ , dtData,       80,    daRight,  true,   "bzc_amt"             , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       80,    daRight,  true,   "fuel_scg_amt"        , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       80,    daRight,  true,   "nego_amt"        	 , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       100,    daRight,  true,   "toll_fee_amt"        	 , false,          "",       dfFloat,      2,     false,       false);
                // 데이터 추가 W/O Additional 2012.02.21 kbj
                InitDataProperty(0, cnt++ , dtData,       120,    daRight,  true,   "truk_etc_add_amt"        	 , false,          "",       dfFloat,      2,     false,       false);
                //InitDataProperty(0, cnt++ , dtData,       80,    daRight,  true,   "scg_vat_amt"        , false,          "",       dfFloat,      2,     false,       false);
                //데이터 추가 W/O D4 Additional 2012.02.21 kbj
                InitDataProperty(0, cnt++ , dtData,       80,    daRight,  true,   "tot_amt"             , false,          "",       dfFloat,      2,     false,       false);
                
                InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "bzc_d2_amt_usd"      , false,          "",       dfFloat,      2,     false,       false);
                //InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "scg_vat_d2_amt_usd" , false,          "",       dfFloat,      2,     false,       false);                
                InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "fuel_scg_d2_amt_usd" , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "nego_d2_amt_usd" 	 , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "toll_fee_d2_amt_usd" 	 , false,          "",       dfFloat,      2,     false,       false);
                //데이터 추가 W/O D Additional USD 2012.02.21 kbj
                InitDataProperty(0, cnt++ , dtData,       100,    daRight,  true,   "truk_etc_add_d2_amt_usd"     	 , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "d2_amt_sum_usd" 	 , false,          "",       dfFloat,      2,     false,       false);
                
                InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "bzc_d4_amt_usd"      , false,          "",       dfFloat,      2,     false,       false);
                //InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "scg_vat_d4_amt_usd" , false,          "",       dfFloat,      2,     false,       false);                
                InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "fuel_scg_d4_amt_usd" , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "nego_d4_amt_usd" 	 , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "toll_fee_d4_amt_usd" 	 , false,          "",       dfFloat,      2,     false,       false);
                //데이터 추가 W/O D4 Additional USD 2012.02.21 kbj
                InitDataProperty(0, cnt++ , dtData,       100,    daRight,  true,   "truk_etc_add_d4_amt_usd"     	 , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "d4_amt_sum_usd" 	 , false,          "",       dfFloat,      2,     false,       false);
                
                InitDataProperty(0, cnt++ , dtData,       80,    daRight,  true,   "bzc_amt_usd"         , false,          "",       dfFloat,      2,     false,       false);
                //InitDataProperty(0, cnt++ , dtData,       80,    daRight,  true,   "scg_vat_amt_usd"    , false,          "",       dfFloat,      2,     false,       false);                
                InitDataProperty(0, cnt++ , dtData,       80,    daRight,  true,   "fuel_scg_amt_usd"    , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       80,    daRight,  true,   "nego_amt_usd"    	 , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       100,    daRight,  true,   "toll_fee_amt_usd"    	 , false,          "",       dfFloat,      2,     false,       false);
                //데이터 추가 W/O Additional USD 2012.02.21 kbj
                InitDataProperty(0, cnt++ , dtData,       100,    daRight,  true,   "truk_etc_add_amt_usd"     	 , false,          "",       dfFloat,      2,     false,       false);
                //데이터 추가 W/O Additional USD 2012.02.21 kbj
                InitDataProperty(0, cnt++ , dtData,       100,    daRight,  true,   "tot_amt_usd"         , false,          "",       dfFloat,      2,     false,       false);
                
                // 2012.05.29 [CHM-201217633] [TRS] 구주 Hinterland T/F 및 시스템 개발 Project SHIN DONG IL
                InitDataProperty(0, cnt++ , dtData,       100,    daRight,  true,   "hjl_hndl_d2_amt"    	, false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       100,    daRight,  true,   "hjl_hndl_d4_amt"    	, false,          "",       dfFloat,      2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       120,    daRight,  true,   "hjl_hndl_amt"       	, false,          "",       dfFloat,      2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       100,    daRight,  true,   "hjl_hndl_d2_amt_usd"   , false,          "",       dfFloat,      2,     false,       false);                
				InitDataProperty(0, cnt++ , dtData,       100,    daRight,  true,   "hjl_hndl_d4_amt_usd"   , false,          "",       dfFloat,      2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       120,    daRight,  true,   "hjl_hndl_amt_usd"     	, false,          "",       dfFloat,      2,     false,       false);               
                
                InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "inv_bzc_d2_amt"      , false,          "",       dfFloat,      2,     false,       false);
                // data 추가 2012.02.20 kbj
                InitDataProperty(0, cnt++ , dtData,       100,   daRight,  true,   "inv_etc_add_d2_amt"  , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "inv_bzc_d4_amt"      , false,          "",       dfFloat,      2,     true,        false);
                //data 추가 2012.02.20 kbj
                InitDataProperty(0, cnt++ , dtData,       100,   daRight,  true,   "inv_etc_add_d4_amt"  , false,          "",       dfFloat,      2,     true,        false);
                InitDataProperty(0, cnt++ , dtData,       80,    daRight,  true,   "inv_bzc_amt"         , false,          "",       dfFloat,      2,     false,       false);
                // data 추가 2012.02.20 kbj
                InitDataProperty(0, cnt++ , dtData,       120,   daRight,  true,   "inv_etc_add_amt"     , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       80,    daRight,  true,   "inv_tot_amt"         , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "inv_bzc_d2_amt_usd"  , false,          "",       dfFloat,      2,     false,       false);
                //data 추가 2012.02.20 kbj
                InitDataProperty(0, cnt++ , dtData,       100,   daRight,  true,   "inv_etc_add_d2_amt_usd"     , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       70,    daRight,  true,   "inv_bzc_d4_amt_usd"  , false,          "",       dfFloat,      2,     false,       false);
                //data 추가 2012.02.20 kbj
                InitDataProperty(0, cnt++ , dtData,       100,   daRight,  true,   "inv_etc_add_d4_amt_usd"  , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       80,    daRight,  true,   "inv_bzc_amt_usd"     , false,          "",       dfFloat,      2,     false,       false);
                //data 추가 2012.02.20 kbj
                InitDataProperty(0, cnt++ , dtData,       120,   daRight,  true,   "inv_etc_add_amt_usd"     , false,          "",       dfFloat,      2,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       80,    daRight,  true,   "inv_tot_amt_usd"     , false,          "",       dfFloat,      2,     false,       false);                
                InitDataProperty(0, cnt++ , dtData,       80,    daRight,  true,   "cntn20"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "cntn40"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "cntn_teu"            , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "cntn_box"            , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "d2_cnt"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "d4_cnt"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "d5_cnt"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "d7_cnt"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "r2_cnt"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "r4_cnt"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "r5_cnt"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "r7_cnt"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "r8_cnt"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "f2_cnt"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "f4_cnt"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "f5_cnt"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "a2_cnt"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "a4_cnt"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "a5_cnt"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "p2_cnt"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "p4_cnt"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "o2_cnt"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "o4_cnt"              , false,          "",       dfNumber,    0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "o5_cnt"              , false,          "",       dfNumber,    0,     false,       false); //20121022
				InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "o7_cnt"              , false,          "",       dfNumber,    0,     false,       false); //2018.05.08 추가 [CSR #3841]
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "s2_cnt"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "s4_cnt"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "t2_cnt"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "t4_cnt"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "dx_cnt"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,       60,    daRight,  true,   "dw_cnt"              , false,          "",       dfNumber,    0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,     0,     daLeft,   true,   "trsp_so_tp_cd"       , false,          "",       dfNone,       0,     false,       false);                
                InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter, true,   "bkg_term_cd"         , false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter, true,   "div"                 , false,          "",       dfNone,       0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter, true,   "sort_sp"             , false,          "",       dfNone,       0,     false,       false);
                                                                                              
                RangeBackColor(1, 12, 1, 48) = RgbColor(222, 251, 248);  // ENIS                      
                HeadRowHeight= 10;     				                                                                                        
			 }								
				
		}
	}


/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
 */
function t1sheet1_OnSaveEnd(sheetObject, errMsg) {
	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {
}
}


/**
 * Volumn by Containner Type/Size visible / unvisible
 */
function change_volume(){
  var formObject = document.form;

  for (i=0; i<2; i++)               
  {                               
      var sheetObject = sheetObjects[i];
      if (formObject.vol_size[0].checked == true) {
        sheetObject.ColHidden("d2_cnt") = false;
        sheetObject.ColHidden("d4_cnt") = false;
        sheetObject.ColHidden("d5_cnt") = false;
        sheetObject.ColHidden("d7_cnt") = false;
        sheetObject.ColHidden("r2_cnt") = false;
        sheetObject.ColHidden("r4_cnt") = false;
        sheetObject.ColHidden("r5_cnt") = false;
        sheetObject.ColHidden("r7_cnt") = false;
        sheetObject.ColHidden("r8_cnt") = false;
        sheetObject.ColHidden("f2_cnt") = false;
        sheetObject.ColHidden("f4_cnt") = false;
        sheetObject.ColHidden("f5_cnt") = false;
        sheetObject.ColHidden("a2_cnt") = false;
        sheetObject.ColHidden("a4_cnt") = false;
        sheetObject.ColHidden("p2_cnt") = false;
        sheetObject.ColHidden("p4_cnt") = false;
        sheetObject.ColHidden("o2_cnt") = false;
        sheetObject.ColHidden("o4_cnt") = false;
		sheetObject.ColHidden("o5_cnt") = false; //20121022
		sheetObject.ColHidden("o7_cnt") = false; //2018.05.08 추가 [CSR #3841]
        sheetObject.ColHidden("s2_cnt") = false;
        sheetObject.ColHidden("s4_cnt") = false;
        sheetObject.ColHidden("t2_cnt") = false;
        sheetObject.ColHidden("t4_cnt") = false;
        sheetObject.ColHidden("dx_cnt") = false;
        sheetObject.ColHidden("dw_cnt") = false;
      }else if (formObject.vol_size[1].checked == true) {
        sheetObject.ColHidden("d2_cnt") = true;
        sheetObject.ColHidden("d4_cnt") = true;
        sheetObject.ColHidden("d5_cnt") = true;
        sheetObject.ColHidden("d7_cnt") = true;
        sheetObject.ColHidden("r2_cnt") = true;
        sheetObject.ColHidden("r4_cnt") = true;
        sheetObject.ColHidden("r5_cnt") = true;
        sheetObject.ColHidden("r7_cnt") = true;
        sheetObject.ColHidden("r8_cnt") = true;
        sheetObject.ColHidden("f2_cnt") = true;
        sheetObject.ColHidden("f4_cnt") = true;
        sheetObject.ColHidden("f5_cnt") = true;
        sheetObject.ColHidden("a2_cnt") = true;
        sheetObject.ColHidden("a4_cnt") = true;
        sheetObject.ColHidden("p2_cnt") = true;
        sheetObject.ColHidden("p4_cnt") = true;
        sheetObject.ColHidden("o2_cnt") = true;
        sheetObject.ColHidden("o4_cnt") = true;
		sheetObject.ColHidden("o5_cnt") = true; //20121022
		sheetObject.ColHidden("o7_cnt") = true; //2018.05.08 추가 [CSR #3841]
        sheetObject.ColHidden("s2_cnt") = true;
        sheetObject.ColHidden("s4_cnt") = true;
        sheetObject.ColHidden("t2_cnt") = true;
        sheetObject.ColHidden("t4_cnt") = true;
        sheetObject.ColHidden("dx_cnt") = true;
        sheetObject.ColHidden("dw_cnt") = true;
      } 
  }
}

/******* inquiryComm 추가 *******/
var ctMode = 0; //COST MODE, TRANS MODE 조합, 1-단일운송,DOOR제외, 2-복합운송,DOOR제외, 3-단일운송,DOOR, 4-복합운송,DOOR

/*
 * 멀티 달력 입력 Pop-Up
 */

function getCalendar() {
	var cal = new ComCalendarFromTo();
    cal.displayType = "date";
    cal.select(document.form.from_date, document.form.to_date, 'yyyyMMdd');
}

/*
* 외부 콤보박스의 리스트 가져오기 (ESD_TRS_0003.js에도 존재).
*/
function getComboList(obj, comObj, sep) { 
	var formObj = document.form;
	var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
	var charval = "Y";
	obj.value = lvobj;
	
	for (var i = 0; i < lvobj.length; i++) {
		var oneChar = lvobj.charAt(i)
		if (oneChar != "") {
			if (  (oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "A" && oneChar <= "Z" )    ){
			}else {
				charval ="N";
				break;
			}
		} else {
			charval ="N";
			break;
		}
	}
	
	if(charval=="Y") {
	} else {
		var errMessage = ComGetMsg('COM12130','Location','Node Code','');  
		ComShowMessage(errMessage);
		obj.value = "";
		obj.focus();
		return false;
	}
	
	if( lvobj == "" ) {
		obj.value = "";
		if(obj.name == 'search_fm_loc') yard_obj = document.search_fm_yard;
		else if(obj.name == 'search_via_loc') yard_obj = document.search_via_yard;
		else if(obj.name == 'search_to_loc') yard_obj = document.search_to_yard;
		else if(obj.name == 'search_door_loc') yard_obj = document.search_door_yard;

		var locValue = obj.value;
		if(ComTrim(locValue) == ''){
			yard_obj.RemoveAll();
			return;
		}
	} else if( lvobj.length != 5 ) {
		//ComShowCodeMessage("TRS90074");
		if(sep=="F"){
			formObj.search_fm_loc.select();
			formObj.search_fm_loc.focus();
		}else if(sep=="V"){
			formObj.search_via_loc.select();
			formObj.search_via_loc.focus();
		}else if(sep=="T"){
			formObj.search_to_loc.select();
			formObj.search_to_loc.focus();
		}else if(sep=="D"){
			formObj.search_door_loc.select();
			formObj.search_door_loc.focus();
		}else{
		}
	}else{
		if( sep == 'F' ) {
			lvFromNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else if( sep == 'V' ){
			lvViaNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else if( sep == 'T' ){
			lvToNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else if( sep == 'D' ){
			lvDoorLoc = getZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else{
		}
		comObj.focus();
	}
	
}
 
/*
* 포커스주기
*/
function fun_Focus(obj){
	var val = removeBar(obj.value);
	obj.value = val;
	obj.select();
}

/*
* '-' 없애기
*/
function fun_Focus_del(obj){
	var val = removeBar(obj.value);
	obj.value = val;
	obj.select();
}

/*
* string을 읽어들여 db 저장을 위해 하이픈('-')을 제거
*/
function removeBar(str) {
	var value = "";
	for ( var i = 0; i < str.length; i++ ) {
		var ch = str.charAt(i);
		if ( ch != '-' ) value = value + ch;
	}
	return value;
}

/**
* 공통 Node popup
*/
function openHireYardPopup(objName) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId = objName;
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	if( objName == "getDorLoc" ) {
		v6 = "zone"
	} else {
		v6 = "yard";
	}
	
	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&mode="+v6;
	ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 450, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
* From Node 팝업에 대한 리턴값
*/
function getFromNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_fm_loc.value = lvLoc;
	getYardCombo(document.search_fm_yard, sheetObjects[0], formObject, lvLoc);
	document.search_fm_yard.CODE = lvYard;
}

/**
* Via Node 팝업에 대한 리턴값
*/
function getViaNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_via_loc.value = lvLoc;
	getYardCombo(document.search_via_yard, sheetObjects[0], formObject, lvLoc);
	document.search_via_yard.CODE = lvYard;
}

/**
* To Node 팝업에 대한 리턴값
*/
function getToNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_to_loc.value = lvLoc;
	getYardCombo(document.search_to_yard, sheetObjects[0], formObject, lvLoc);
	document.search_to_yard.CODE = lvYard;
}

/**
* Door Location 팝업에 대한 리턴값
*/
function getDorLoc(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];

	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_door_loc.value = lvLoc;
	getZoneCombo(document.search_door_yard, sheetObjects[0], formObject, lvLoc);
	document.search_door_yard.CODE = lvYard;
}

/**
* blur시 데이타체크
*/
function BlurDate(obj) {
	var f =  document.form;
	var dt = obj.value;
	if( dt == ""){
	} else {
		if ( isValidDate(dt)) {
			if( dt.length == 8 ) {
				addBar(obj);
				return;
			} else {
				ComShowCodeMessage("TRS90070");
				obj.select();
				obj.focus();
				return;
			}
		}
		ComShowCodeMessage("TRS90070");
		obj.select();
		obj.focus();
		return;
	}
}

/**
* 유효 날짜 체크(2)
*/
function isValidDate(date) {
	var year = date.substring(0,4);
	var month = date.substring(4,6);
	var day = date.substring(6,8);

	if (isDatecheck(year, month, day) ) {
		return true;
	} else {
		return false;
	}
}
	 
/**
* 유효 날짜 체크(1)
*/
function isDatecheck( year,month,day ) {
	if ( parseInt( year ) >= 1900  && checkMonth( month ) && checkDay( year, month, day ) ) {
		return true;
	} else {
		return false;
	}
}

/**
* 월 체크
*/
function checkMonth( month ) {
	var intmonth = parseInt( month , 10 )
	if( intmonth >= 1  && intmonth <= 12 ) {
		return true;
	} else {
		return false;
	}
}

/**
* 유효 날짜 체크
*/
function checkDay( yyyy, mm, dd ) {
	var monthDD = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
	var im = parseInt(mm,10) - 1;
	if( ( (yyyy % 4 == 0) && (yyyy % 100 != 0)) || (yyyy % 400 == 0) ) {
		monthDD[1] = 29;
	}
	if( parseInt( dd , 10 ) <= 0 || parseInt( dd , 10 ) > monthDD[im] ) {
		return false;
	} else {
		return true;
	}
}

/**
* 날자포맷으로 yyyy-mm-dd
*/
function addBar(dt) {
	var dat="";
	if( dt.length == 8 ) {
		dat = dt.substr(0,4) + '-' + dt.substr(4,2) + '-' + dt.substr(6,2);
	}
	return dat; 
}

/**
* 날자포맷으로 yyyy-mm-dd
*/
function addBar_from(obj) {
	var formObject = document.form;
	var dt=obj.value;
	var dat=dt;
	if( dt.length == 8 ) {
		dat = dt.substr(0,4) + '-' + dt.substr(4,2) + '-' + dt.substr(6,2);
	}
	formObject.from_date.value= dat;
}

/**
* 날자포맷으로 yyyy-mm-dd
*/
function addBar_to(obj) {
	var formObject = document.form;
	var dt=obj.value;
	var dat=dt;

	if( dt.length == 8 ) {
		dat = dt.substr(0,4) + '-' + dt.substr(4,2) + '-' + dt.substr(6,2);
	}
	formObject.to_date.value= dat;
}

//Include Office를 처리하기 위한 Logic
var request = null;
function createHttpRequest() {
	try{
		request = new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request = null;
			}
		}
	}
	if( request == null ) {
		ComShowMessage("Erroe Request XMLHttp");
	}
}

//Include Check Bok를 Click했을 때
function fun_chkOffice() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.input_office.value.toUpperCase(), " "); //input text
	if( prm_office == "" ) {
		doc_office.checked = false;
		document.form.input_office.value = "";
		ComShowMessage("Please input the 'S/O Office'!!");
		return false;
	}
	if( doc_office.checked == true ) {
		var url = "ESD_TRS_0002GS.do?f_cmd="+SEARCH11+"&ctrl_so_office="+prm_office;
		document.form.old_ofc_cd.value = prm_office;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange = subCntorlOffice;
		request.send(null);
	} else {
		document.form.input_office.value = document.form.old_ofc_cd.value;
	}
}

//Office의 값을 가지고 온다.
function subCntorlOffice() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("row-count")[0];
			var subXml = null;
			var text_ofc = "";
			for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
				subXml = docXml.getElementsByTagName("sub-office")[n];
				text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			}
			if( text_ofc.length < 1 ) {
				ComShowMessage("No Data!");
			}
			document.form.input_office.value = text_ofc.substring(0, text_ofc.length-1);
		}
	}
}

//control s/o office code return value.
function rtn_office_code(obj) {
	document.form.input_office.value = obj;
}

function  vender_blur() {
	var formObj = document.form;
	var lvobj = formObj.combo_svc_provider.value;
	var error_val = "";

	if(lvobj !="") {
		for (var i = 0; i < lvobj.length; i++) {
			var oneChar = lvobj.charAt(i)
			if (oneChar != "") {
				if (  (oneChar >= "0" && oneChar <= "9" )  ){
				}else {
					error_val ="Y";
					break;
				}
			}
		}

		if(error_val !="Y" ){
			//vender value값을 가져온다(SHEET1)
			formObj.f_cmd.value = SEARCHLIST12;
			sheetObjects[0].DoSearch4Post("ESD_TRS_0065GS.do", TrsFrmQryString(formObj));

			//1개의 파라미터의 값을 조회후 가져온다.
			var x1 = sheetObjects[0].EtcData('CNT_CD1');
			if(x1 !="" || x1 !="undefined") {
				formObj.svc_provider.value =x1;
			}else{
				var errMessage = ComGetMsg('TRS90076','','','');  
				ComShowMessage(errMessage);
				formObj.combo_svc_provider.focus();
				formObj.svc_provider.value ="";
			}
		} else {
			var errMessage = ComGetMsg('TRS90076','','','');  
			ComShowMessage(errMessage);
			formObj.combo_svc_provider.focus();
			formObj.svc_provider.value ="";
		}
	}else{
		formObj.svc_provider.value ="";
	}
}

/**                                                                                                                                                                
* rep_commodity팝업호출                                                                                                                                           
*/                                                                                                                                                               
function rep_OnPopupClick() {                                                                                                                                      
	var formObject = document.form;                                                                                                                                  
	var cmdt_cd_val ="";   //향후 사용가능 예정변수                                                                                                                  
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수                                                                                                              
	var cmdt_desc_val ="";   //향후 사용가능 예정변수 
	
	var classId ="getCOM_ENS_rep";                                                                                                                                   
	var xx1="";  //CONTI                                                                                                                                             
	var xx2="";  //SUB CONTI                                                                                                                                         
	var xx3="";  //COUNTRY                                                                                                                                           
	var xx4="";  //STATE                                                                                                                                             
	var xx5= formObject.input_office.value;  //CONTROL OFFIC                                                                                                         
	var xx6="";  //LOC CODE                                                                                                                                          
	var xx7="";  //LOC NAME                                                                                                                                          
	var xx8="";                                                                                                                                                      
	var xx9="";                                                                                                                                                      
                                                                                                                                                                   
	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&ofc_cd="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 612, 450, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');                                                               
}      

/**
* rep_commodity팝업호출 : 팝업에서 단일 선택을 한경우..
*/
function getCOM_ENS_rep(rowArray) {
	var formObj = document.form;
	//var comboObj = document.combo_svc_provider;
	for(var i=0; i<rowArray.length; i++) {
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[3];
		var colArray4 = colArray[4];

		//comboObj.InsertItem(comboObj.GetCount(), colArray2+'|'+colArray3, colArray2);
		formObj.combo_svc_provider.value =colArray2;
		formObj.svc_provider.value =colArray4;
	}
}                                                                                                                                                            

/**
* 콤보박스 -cost
*/
function bound_OnChange_2(obj){
	//cost mode에 따른 화면정의!
	setKindEnabled(); 
}

/**
* 콤보박스 -trans
*/
function bound_OnChange_3(obj){
	//trans mode에 따른 화면정의!
	setKindEnabled();
}

/**
* COST MODE, TRANS MODE 선택에 따른 조회조건 enabled처리
**/
function setKindEnabled() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var obj = document.form;

	formObj.search_fm_loc.value = '';
	document.search_fm_yard.RemoveAll();
	formObj.search_via_loc.value = '';
	document.search_via_yard.RemoveAll();
	formObj.search_to_loc.value = '';
	document.search_to_yard.RemoveAll();
	formObj.search_door_loc.value = '';
	document.search_door_yard.RemoveAll();

	node_add();
	switch(ctMode) {
		case 1:
			obj.search_via_loc.disabled = true;
			obj.search_door_loc.disabled = true;
			document.search_via_yard.Enable = false;
			document.search_door_yard.Enable = false;
		break;

		case 2:
			obj.search_via_loc.disabled = false;
			obj.search_door_loc.disabled = true;
			document.search_via_yard.Enable = true;
			document.search_door_yard.Enable = false;
		break;

		case 3:
			obj.search_via_loc.disabled = true;
			obj.search_door_yard.disabled = false;
			document.search_via_yard.Enable = false;
			document.search_door_yard.Enable = true;
		break;

		case 4:
			obj.search_via_loc.disabled = false;
			obj.search_door_yard.disabled = false;
			document.search_via_yard.Enable = true;
			document.search_door_yard.Enable = true;
		break;
	}
}

/**
 * combo_node add
 */
function node_add() {
	var formObj = document.form;

	var costMode = formObj.sel_costmode.value;
	var tranMode = formObj.sel_transmode.value;

	//COST MODE에 따라 조회조건 활성/불활성화를 세팅하기 위한 네종류 조건 확인
	if((tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode != 'DR') ctMode = 1;
	else if(!(tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode != 'DR') ctMode = 2;
	else if((tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode == 'DR') ctMode = 3;
	else if(!(tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode == 'DR') ctMode = 4;
}

//Office-PopUp Validation Checked
function validation_check() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.input_office.value.toUpperCase(), " "); //input text
	var aoffice = prm_office.split(",");
	if( prm_office == "" ) {
		document.form.input_office.value = "";
		ComShowMessage("Please input the 'S/O Office'!!");
		return false;
	}
	if( doc_office.checked == true ) {
		ComShowMessage("You can inquire the 'Office Help' popup for one office code at a time");
		return false;
	} else {
		if( aoffice.length == 1 ) {
			return true;		
		} else {
			ComShowMessage("You can inquire the 'Office Help' popup for one office code at a time");
			return false;
		}
	}
}


function status_cd_OnCheckClick(comboObj, index, code) {
	if(index==0 || index==1) { 	    	
		var bChk = comboObj.CheckIndex(index);
		if(bChk){
			if(index ==0){
				comboObj.CheckIndex(1) = false;
			}else{
				comboObj.CheckIndex(0) = false;				
			}
			for(var i = 2 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = false;
			}
		}
	} else {
		comboObj.CheckIndex(0) = false;
		comboObj.CheckIndex(1) = false;		
	}
}

function sel_costmode_OnCheckClick(comboObj, index, code) {
	if(index==0) {
		var bChk = comboObj.CheckIndex(index);
		if(bChk){
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = false;
			}
		}
	} else {
		comboObj.CheckIndex(0) = false;
	}
} 

function sel_transmode_OnCheckClick(comboObj, index, code) {
	if(index==0) {
		var bChk = comboObj.CheckIndex(index);
		if(bChk){
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = false;
			}
		}
	} else {
		comboObj.CheckIndex(0) = false;
	}
} 

function sel_sotype_OnCheckClick(comboObj, index, code) {
	if(index==0) {
		var bChk = comboObj.CheckIndex(index);
		if(bChk){
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = false;
			}
		}
	} else {
		comboObj.CheckIndex(0) = false;
	}
} 

// 조회 결과가 2000건이 넘을 경우 위 down xls 버튼을 클릭하라는 메시지 추가 2012.02.16 kbj
function sheet1_OnSearchEnd(sheetObj,errMsg) {
	if ( sheetObj.SearchRows > 1999 ){   // 2000 Row 넘는 부분에 대해서는 메시지 출력.
		getCount(sheetObj,document.form);
		ComShowCodeMessage("TRS90362");
	}
}
/******** inquiryComm end *******/

/**조회 조건 By가 Yard일 경우에만 Distance관련 컬럼을 보여준다.
 * [CHM-201217633] [TRS] 구주 Hinterland T/F 및 시스템 개발 Project
 * 2012.06.19 SHIN DONG IL
 */
function distance_col_control(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	if(formObj.node_div[2].checked){
		sheetObj.ColHidden("ttl_dist") = false;
		sheetObj.ColHidden("lnk_dist_div_cd") = false;
	}else{
		sheetObj.ColHidden("ttl_dist") = true;
		sheetObj.ColHidden("lnk_dist_div_cd") = true;		
	}
}

/**                                                                                                                                                                
 * 조회된 건수가 2000건이 넘을 경우 갯수 표시
 */ 
function getCount(sheetObj, formObj){
	formObj.f_cmd.value = SEARCH02;
	var cnt = formObj.cnt.value;
	var sXml = sheetObjects[1].GetSearchXml("ESD_TRS_0104GS.do", TrsFrmQryString(formObj));
	cnt = ComGetEtcData(sXml, "cnt");
	var cntcomma = ComAddComma(cnt);
	sheetObj.CountFormat = "[SELECTDATAROW / TOTALROWS ("+cntcomma+")]";
}