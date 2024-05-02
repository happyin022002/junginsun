/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0045.js
*@FileTitle  : Refund Invoice File Import
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
// 부모창 관련 컨트롤(변수 및 함수 , 그리드 컨트롤)
var localopener=window.dialogArguments;
if (!localopener) localopener=parent;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
        	    case "btng_select":
        	        doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
        	        break;
                case "btng_toggle":
                        var findRow=sheetObject.FindText( "result" , "Good",sheetObject.HeaderRows());
                    	while(findRow>0){
                    	    sheetObject.SetCellValue( findRow , "sel2","1",0);
                    		findRow=sheetObject.FindText("result" , "Good",findRow+1);
                    	}
                    break;
        	    case "btng_verify":
                        chkVerify(sheetObject);
               	    break;
        	    case "btn_apply":
                    var chkrows=sheetObject.FindCheckedRow("sel2");
                    if (chkrows == "")
                    {
                        errMsg=ComGetMsg("COM12113" , "Select");
                        ComShowMessage(errMsg);
                        return;
                    }
                    var arrRow=chkrows.split("|");
                    for (idx=0; idx<arrRow.length; idx++){
                    	if ( ! (sheetObject.GetCellValue(arrRow[idx] , "result") =="Good")  )
                        {
                            errMsg=ComGetMsg("TRS90007");
                            ComShowMessage(errMsg);
                            return;
                        } 
                    }
                    moveSheetData(sheetObject ,localopener.sheet1 ,  'sel2');
                    localopener.fileflag=true;
                    ComClosePopup(); 
        	        break;
        	    case "btn_close":
        	    	ComClosePopup(); 
        	        break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('COM12111');
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
		//html컨트롤 이벤트초기화
		initControl();
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
		form.boo_bl_no.value="";
	    else
		form.boo_bl_no.value=form.hdn_boo_bl_no.value;
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
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
        	case 1:      //sheet1 init
		        with(sheetObj){
				           //no support[check again]CLT style.height=GetSheetHeight(13);
				           var HeadTitle="Seq.|S|A|Cost Mode|Trans Mode|EQ\nType/Size|Quantity|Unit Cost|Invoice Amount|Adjustment|Handling Period|Handling Period|Verify" ;
				           var HeadTitle1="Seq.|S|A|Cost Mode|Trans Mode|EQ\nType/Size|Quantity|Unit Cost|Invoice Amount|Adjustment|From Date|To Date|Verify" ;
				
				           SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
				
				           var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				           var headers = [ { Text:HeadTitle, Align:"Center"},
						         { Text:HeadTitle1, Align:"Center"} ];
						           InitHeaders(headers, info);
				
				           var cols = [ {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								         {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sel",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								         {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sel2",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								         {Type:"Combo",     Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"trsp_cost_dtl_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								         {Type:"Combo",     Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"trsp_crr_mod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								         {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								         {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"trsp_rfnd_qty",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
								         {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"trsp_rfnd_inv_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
								         {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"trsp_rfnd_uc_rt",       KeyField:0,   CalcLogic:"|trsp_rfnd_qty|*|trsp_rfnd_inv_amt|",Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								         {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"inv_nego_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
								         {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"hndl_prd_fm_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								         {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"hndl_prd_to_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								         {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"result",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				                        
				           InitColumns(cols);
				
				           SetEditable(1);
				           SetHeaderRowHeight(20);
				           SetHeaderRowHeight(21);
				           SetColProperty('trsp_cost_dtl_mod_cd', {ComboText:trsp_cost_dtl_mod_cdText, ComboCode:trsp_cost_dtl_mod_cdCode} );
				           SetColProperty('trsp_crr_mod_cd', {ComboText:trsp_crr_mod_cdText, ComboCode:trsp_crr_mod_cdCode} );
				           SetColProperty('eq_tpsz_cd',{ComboText:eq_tpszCode, ComboCode:eq_tpszCode} );
				           SetSheetHeight(ComGetSheetHeight(sheetObj, 13));
				    }       
		        break;
        	}
    }
  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
            case IBSAVE:        //저장
            break;
           case IBSEARCH:
               break;            
           case IBLOADEXCEL:        //엑셀 업로드
               sheetObj.LoadExcel();
              break;
        }
    }
    function chkVerify (sheetObj)
    {
        var eq_comboCode="";
        var cost_comboCode=sheetObj.GetComboInfo( 0 , "trsp_cost_dtl_mod_cd" ,  "Code");
        var crr_comboCode=sheetObj.GetComboInfo( 0 , "trsp_crr_mod_cd" ,  "Code");
        var flag=true;
        var dtflag=true;
        var vflag=true;
        if(sheetObj.CheckedRows('sel') == "0")  {
            errMsg=ComGetMsg("COM12113", 'Select' );
            ComShowMessage(errMsg);
            return false;
        } 
        var chkrows=sheetObj.FindCheckedRow("sel");
        var arrRow=chkrows.split("|");
        for (idx=0; idx<arrRow.length; idx++){ 
            row=arrRow[idx];
            sheetObj.SetRowBackColor(row,"#FFFFFF");
            if (cost_comboCode.indexOf(sheetObj.GetCellValue( row , "trsp_cost_dtl_mod_cd")) == 0 )
            {
                sheetObj.SetCellBackColor( row , "trsp_cost_dtl_mod_cd","#B5C9FD");
                sheetObj.SetCellBackColor( row , "eq_tpsz_cd", "#B5C9FD");
                flag=false;
            } else if (sheetObj.GetCellValue( row , "trsp_cost_dtl_mod_cd").charAt(0) == "H" )
            {
                sheetObj.CellComboItem ( row , "eq_tpsz_cd" , ch_tpszCode , ch_tpszCode);       
            } else if ( sheetObj.GetCellValue( row , "trsp_cost_dtl_mod_cd").charAt(0) == "G" )
            {
                 sheetObj.CellComboItem ( row , "eq_tpsz_cd" , gn_tpszCode , gn_tpszCode);       
            } else {
                sheetObj.CellComboItem ( row , "eq_tpsz_cd" , eq_tpszCode , eq_tpszCode);       
            }
            if (parseInt(crr_comboCode.indexOf(sheetObj.GetCellValue( row , "trsp_crr_mod_cd"))) == 0)
            {
                sheetObj.SetCellBackColor( row , "trsp_crr_mod_cd","#B5C9FD");
                flag=false;
            } 
            eq_comboCode=sheetObj.GetComboInfo( row , "eq_tpsz_cd" ,  "Code");
            if (parseInt(eq_comboCode.indexOf(sheetObj.GetCellText( row , "eq_tpsz_cd"))) == 0)
            {
                sheetObj.SetCellBackColor( row , "eq_tpsz_cd","#B5C9FD");
                flag=false;
            } else {
                sheetObj.SetCellValue( row , "eq_tpsz_cd",sheetObj.GetCellText(row , "eq_tpsz_cd"),0);
            }
            if(isNaN(sheetObj.GetCellValue( row , "trsp_rfnd_qty")) || sheetObj.GetCellValue( row , "trsp_rfnd_qty") == "" )
            {
                sheetObj.SetCellBackColor(row, "trsp_rfnd_qty","#B5C9FD");
                flag=false;
            } 
            if(isNaN(sheetObj.GetCellValue( row , "trsp_rfnd_inv_amt")) || sheetObj.GetCellValue( row , "trsp_rfnd_inv_amt") == "" )
            {
                sheetObj.SetCellBackColor(row, "trsp_rfnd_inv_amt","#B5C9FD");
                flag=false;
            } 
            //if (!checkDateFormat(sheetObj.CellText(row , "hndl_prd_fm_dt")))
            if (sheetObj.GetCellValue(row , "hndl_prd_fm_dt").replace(/-/gi,"").length != 8)
            {
                sheetObj.SetCellBackColor(row , "hndl_prd_fm_dt","#B5C9FD");
                flag=false;
                dtflag=false;
            }
            //if (!checkDateFormat(sheetObj.CellText(row , "hndl_prd_to_dt")))
            if (sheetObj.GetCellValue(row , "hndl_prd_to_dt").replace(/-/gi,"").length != 8)
            {
                sheetObj.SetCellBackColor(row , "hndl_prd_to_dt","#B5C9FD");
                flag=false;
                dtflag=false;
            }
            if (dtflag){
            	if (parseInt(sheetObj.GetCellValue(row , "hndl_prd_fm_dt").replace(/-/gi,"")) > parseInt(sheetObj.GetCellValue(row , "hndl_prd_to_dt").replace(/-/gi,"")))
                {
                   sheetObj.SetCellBackColor(row , "hndl_prd_fm_dt","#B5C9FD");
                   sheetObj.SetCellBackColor(row , "hndl_prd_to_dt","#B5C9FD");
                   flag=false;
                }
            }
            if ( flag)
            {
                sheetObj.SetCellValue(row , "result","Good",0);
            } else {
                sheetObj.SetCellValue(row , "result","Incorrect",0);
                vflag=false;
            }
            flag=true;
            dtflag=true;
        }
        var irow;
        var jrow;
        var dupflag=false;
        var selrows=sheetObj.FindCheckedRow("sel");
        var chkRow=selrows.split("|");
        var dupRow=chkRow;
        for (i=0; i<chkRow.length-1; i++){
        	dupflag=false;
        	if( dupRow[i] == 0 )  continue;
            irow=chkRow[i];
            for(j=i+1; j<chkRow.length-1; j++){
            	jrow=chkRow[j];
            	if( sheetObj.GetCellValue(irow , "trsp_cost_dtl_mod_cd") == sheetObj.GetCellValue(jrow , "trsp_cost_dtl_mod_cd") ){
            		if( sheetObj.GetCellValue(irow , "trsp_crr_mod_cd") == sheetObj.GetCellValue(jrow , "trsp_crr_mod_cd") ){
            			if( sheetObj.GetCellValue(irow , "eq_tpsz_cd") == sheetObj.GetCellValue(jrow , "eq_tpsz_cd") ){
            				sheetObj.SetRowBackColor(irow,"#EEFFE2");
                            sheetObj.SetRowBackColor(jrow,"#EEFFE2");
                            sheetObj.SetCellValue(irow , "result","Dup",0);
                            sheetObj.SetCellValue(jrow , "result","Dup",0);
                            dupflag=true;
            			}
            		}
            	}
            	if( dupflag )
            		dupRow[j]=0;            		
            }
        }       
    }
    function moveSheetData(fromSheet, toSheet, chkCol)  {
      //데이터 행의 개수 확인
      var toRow=toSheet.RowCount();
      fromSheet.RenderSheet(0);
      toSheet.RenderSheet(0);
      //원본에서 역순으로 Check 된 데이터를 확인하여 이동
      for (ir=fromSheet.RowCount(); ir>= 2; ir--) {
        //Check 되지 않은 경우 건너뜀
    	  if (fromSheet.GetCellValue(ir, chkCol) == '0') continue;
        //데이터 행 추가
        toRow=toSheet.DataInsert(-1);
        //데이터 옮기기
        for (ic=0; ic<=fromSheet.LastCol(); ic++) {
          //체크 컬럼은 빼고 옮김
          if (ic == chkCol) continue;
          var colName=toSheet.ColSaveName(ic);
          if (colName=="trsp_cost_dtl_mod_cd"||colName=="trsp_crr_mod_cd"||colName=="eq_tpsz_cd"||colName=="trsp_rfnd_qty"
              ||colName=="trsp_rfnd_inv_amt"||colName=="hndl_prd_fm_dt"||colName=="hndl_prd_to_dt" || colName=="inv_nego_amt")
          {
              if (colName == "eq_tpsz_cd")
              {
            	  if ( fromSheet.GetCellValue(ir,colName).charAt(0) == "G")
                   {
                       toSheet.CellComboItem ( toRow , "eq_tpsz_cd" , gn_tpszCode , gn_tpszCode);
                   } else if ( fromSheet.GetCellValue(ir,colName).charAt(0) == "H")
                   {
                       toSheet.CellComboItem ( toRow , "eq_tpsz_cd" , ch_tpszCode , ch_tpszCode);
                   } else {
                       toSheet.CellComboItem ( toRow , "eq_tpsz_cd" , eq_tpszCode , eq_tpszCode);
                   }
              }
              toSheet.SetCellValue(toRow,colName,fromSheet.GetCellValue(ir,colName),0);
            if (colName != "sel")
            {
                toSheet.SetCellEditable(toRow , colName,0);
            }
          }
        }
      }
      toSheet.RenderSheet(1);
      fromSheet.RenderSheet(1);
    } 
   function sheet1_OnChange(sheetObj, row , col, value)
   {
       if ( sheetObj.ColSaveName(col) == "trsp_cost_dtl_mod_cd")
       {
           if ( value.charAt(0) == "G")
           {
               sheetObj.CellComboItem ( row , "eq_tpsz_cd" , gn_tpszCode , gn_tpszCode);
               sheetObj.SetCellValue( row , "eq_tpsz_cd","",0);
           } else if ( value.charAt(0) == "H")
           {
               sheetObj.CellComboItem ( row , "eq_tpsz_cd" , ch_tpszCode , ch_tpszCode);
               sheetObj.SetCellValue( row , "eq_tpsz_cd","",0);
           } else {
               sheetObj.CellComboItem ( row , "eq_tpsz_cd" , eq_tpszCode , eq_tpszCode);
               sheetObj.SetCellValue( row , "eq_tpsz_cd","",0);
           }
       }
   }
	function checkDateFormat(dt){
		var date_regexp="^(\\d{4}-\\d{2}-\\d{2})$";
		if (!checkFormat(dt, date_regexp)){
			return false;
		}
		return true;
	}	
	function checkFormat(value, regexp){
		// 주어진 값이 정규식에 일치하는지 확인하고 맞으면 true를 틀릴경우 false를 return한다.
		if (value == null || value == ""){
			return false;
		} else {
			re=new RegExp(regexp,"gi"); //'gi'는 case-insensitive global match를 위함이다
			if (!re.test(value)){
				return false;
			}
		}
		return true;
	}

	function sheet1_OnSort(){
		sheet1.ReNumberSeq();
	}

	function sheet1_OnLoadExcel(sheetObj, result, code, msg){
	    if(isExceedMaxRow(msg))return;
	}
	