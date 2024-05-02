/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운 
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0040 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0040() {
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

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;
var apflag = false;
var fileflag = false;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;
         var comboObj = document.paymt_sp_combo;
         
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

        	    case "btn_apply":
        	    
        	       if(chkComfirm())  return false;
        	       if (checkInput(formObject))
        	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;
        	        
				case "btn_reset":
			
					comboObj.RemoveAll();
	  	            sheetObject.RemoveAll();
    	            formObject.reset(); 
    	            
                    ComEnableObject(document.form.inv_no, true);
                    ComEnableObject(document.form.inv_curr_cd, true);
                    document.form.combo_svc_provider.Enable  = true;
                    document.form.combo_svc_provider.Text = "";
                    
                    fileflag = false;
                    apflag = false;
        	        break;

				case "btn_minimize":
                    Mincount = (Mincount+1)%2 ;
                    Minimize(Mincount);
					break;

				case "btns_calendar1":
        	         var cal = new ComCalendar();
        	         cal.select(formObject.inv_rcv_dt, 'yyyy-MM-dd');
            		 //cal.select(formObject.inv_rcv_dt, 'inv_rcv_dt', 'yyyy-MM-dd');            		 
        	        break;

				case "btns_calendar2":
        	         var cal = new ComCalendar();
            		 cal.select(formObject.inv_iss_dt, 'yyyy-MM-dd');
            		// cal.select(formObject.inv_iss_dt, 'inv_iss_dt', 'yyyy-MM-dd');
        	        break;

				case "btng_invoicefileimport":
				   if (! apflag)
				   {
                        errMsg = ComGetMsg("TRS90080" );
                        ComShowMessage(errMsg);
				       return false;
				   }
            	   if(fileflag)
            	   {
                        errMsg = ComGetMsg("TRS90008" );
                        ComShowMessage(errMsg);
                        return false;
            	   }
        	        if(chkComfirm())  return false;
                    window.showModelessDialog('ESD_TRS_0045.do', window, "scroll:no;status:no;help:no;dialogWidth:900px;dialogHeight:470px");
        	        break;


				case "btng_rowadd":
				   if (! apflag)
				   {
                        errMsg = ComGetMsg("TRS90080" );
                        ComShowMessage(errMsg);
				       return false;
				   }
        	        if(chkComfirm())  return false;
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;

				case "btng_delete":
				   if (! apflag)
				   {
                        errMsg = ComGetMsg("TRS90080" );
                        ComShowMessage(errMsg);
				       return false;
				   }
        	        if(chkComfirm())  return false;
        	        var chkrow = sheetObject.FindCheckedRow ("sel");
        	        var arrRow = chkrow.split("|");
                    for (idx=arrRow.length-2; idx >= 0; idx--){ 
                        sheetObject.RowDelete (arrRow[idx] , false);
                    }
					break;
					
				case "btng_confirm":
				   if (! apflag)
				   {
                        errMsg = ComGetMsg("TRS90080" );
                        ComShowMessage(errMsg);
				       return false;
				   }
        	       if(chkComfirm())  return false;
        	       
                    var sheetTotal = 0.00 ; 
  
                    if (checkInputData(sheetObject))                     
                    {
                        sel = sheetObject.FindCheckedRow ('sel') 
                        if(sel != "")                            
                        {
                            arrRow = sel.split("|");             
                            for (idx=0; idx<arrRow.length-1; idx++){        
                                sheetTotal = Number(sheetTotal)+Number(sheetObject.CellValue(arrRow[idx] , "trsp_rfnd_uc_rt"));
                                sheetTotal =sheetTotal.toFixed(2);
                            }
                        }
						
                        if (parseFloat(ComTrimAll(formObject.inv_bzc_amt.value,",")) == sheetTotal)     
                        {
       	                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                        } else { 
                            errMsg = ComGetMsg("TRS90006");
                            ComShowMessage(errMsg);
                            return;
                        }
                    }
        	         
        	        break;
                
    			case "btng_provider":
    				rep_OnPopupClick();
    				break;
                
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			  errMsg = ComGetMsg("TRS90392" );
                  ComShowMessage(errMsg);

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

        ComEnableObject(document.form.inv_ttl_amt, false);
        ComEnableObject(document.form.paymt_sp_cd, false);
        ComEnableObject(document.form.paymt_sp_combo, false);
        ComEnableObject(document.form.svc_provider, false);

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
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(13);
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
                    InitColumnInfo(14, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, true, true, false,false)

                    var HeadTitle = "Del.|STS|Sel.|Cost Mode|Trans Mode|EQ\nType/Size|Quantity|Unit Cost|Invoice Amount|Adjustment|Handling Period|Handling Period||Verify" ;
                    var HeadTitle1 = "Del.|STS|Sel.|Cost Mode|Trans Mode|EQ\nType/Size|Quantity|Unit Cost|Invoice Amount|Adjustment|From Date|To Date||Verify" ;


                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  true,    "del",     false,          "",       dfNone,   		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHiddenStatus,     30,    daCenter,    true,    "ibflag",     false,          "",       dfNone,   		0,     false,      true);
					InitDataProperty(0, cnt++ , dtCheckBox,	  30,	daCenter,			true,    "sel",				false,			"",			dfNone,			0,			true,		true	);
					InitDataProperty(0, cnt++ , dtCombo,	 120,	daLeft,			    true,    "trsp_cost_dtl_mod_cd",				false,			"",			dfNone,			0,			true,			true	);
					InitDataProperty(0, cnt++ , dtCombo,	 100,	daCenter,			true,    "trsp_crr_mod_cd",				false,			"",			dfNone,			0,			true,			true	);
					InitDataProperty(0, cnt++ , dtCombo,	 70,	daCenter,			true,    "eq_tpsz_cd",				false,			"",			dfNone,			0,			true,			true	);
					InitDataProperty(0, cnt++ , dtData,	 70,		daRight,			true,    "trsp_rfnd_qty",				false,			"",			dfFloat,			2,			true,			true	);

					InitDataProperty(0, cnt++ , dtData,	 70,		daRight,			true,    "trsp_rfnd_inv_amt",			false,			"",			dfFloat,			2,			true,			true	);
					
					InitDataProperty(0, cnt++ , dtData,	100,		daRight,			true,    "trsp_rfnd_uc_rt",				false,			"|trsp_rfnd_qty|*|trsp_rfnd_inv_amt|+|inv_nego_amt|",			dfFloat,			2,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 70,		daRight,			true,    "inv_nego_amt",			false,			"",			dfFloat,			2,			true,			true	);
					InitDataProperty(0, cnt++ , dtData,	 70,		daCenter,			true,    "hndl_prd_fm_dt",				false,			"",			dfDateYmd,			0,			true,			true	);
					InitDataProperty(0, cnt++ , dtData,	 70,		daCenter,			true,    "hndl_prd_to_dt",				false,			"",			dfDateYmd,			0,			true,			true	);
					InitDataProperty(0, cnt++ , dtHidden,	 70,	daCenter,			true,    "sub_inv_seq",				false,			"",			dfNone,			0,			true,			true	);
					InitDataProperty(0, cnt++ , dtData,	 70,		daCenter,			true,    "result",				false,			"",			dfNone,			0,			false,			false	);

                    InitDataCombo(0, 'trsp_cost_dtl_mod_cd', trsp_cost_dtl_mod_cdText, trsp_cost_dtl_mod_cdCode);
                    InitDataCombo(0, 'trsp_crr_mod_cd', trsp_crr_mod_cdText, trsp_crr_mod_cdCode);

                  	RangeBackColor(1, 8, 1, 10) = RgbColor(222, 251, 248);   // ENIS
                  	HeadRowHeight = 20 ;
					HeadRowHeight = 21 ;
               }
                break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBROWSEARCH:      //조회

                formObj.f_cmd.value = SEARCH01;
                sheetObj.DoRowSearch("ESD_TRS_0040GS.do", TrsFrmQryString(formObj));
                ComEtcDataToForm(document.form ,sheetObj);
                sheetObj.RemoveEtcData();
                break;
                
           case IBSEARCH:      //조회

                formObj.f_cmd.value = SEARCH02;
                sheetObj.DoRowSearch("ESD_TRS_0040GS.do", TrsFrmQryString(formObj));
                inv_flag = sheetObj.EtcData("inv_flag");
                sheetObj.RemoveEtcData();
                
                if ( parseInt(inv_flag) > 0 )
                  {
        			  errMsg = ComGetMsg("TRS90126" );
                      ComShowMessage(errMsg);
                      formObj.inv_no.value = "";
                      formObj.inv_no.focus();
                  } else {
                      ComEnableObject(document.form.inv_no, false);
                      ComEnableObject(document.form.inv_curr_cd, false);
                      document.form.combo_svc_provider.Enable  = false;
                      apflag = true;
                  }
                break;
                
            case IBSAVE:        //저장
                formObj.f_cmd.value = MULTI;
                sheetObj.DoSave("ESD_TRS_0040GS.do", TrsFrmQryString(formObj) , "sel" , false);
                break;

           case IBINSERT:      // 입력
                var row = sheetObj.DataInsert();

                break;

           case IBCOPYROW:        //행 복사
              sheetObj.DataCopy();
              break;

           case IBDOWNEXCEL:        //엑셀 다운로드
              sheetObj.Down2Excel(-1, false, false, true);

              break;

           case IBLOADEXCEL:        //엑셀 업로드
              sheetObj.LoadExcel();
              break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet2(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
                
           case IBSEARCH:      //조회
                formObj.f_cmd.value = SEARCHLIST;
                sheetObj.DoSearch4Post("ESD_TRS_0040GS.do", TrsFrmQryString(formObj));
                break;
        }
    }

   function checkInput(fromObj)
   {
        if(ComIsNull(fromObj.svc_provider) || ComIsNull(fromObj.svc_provider.value))
        {
            ComShowMessage(ComGetMsg("TRS90124"));
            return false;
        }
      
        if(ComIsNull(fromObj.paymt_sp_cd) || ComIsNull(fromObj.paymt_sp_cd.value))
        {
            ComShowMessage(ComGetMsg("TRS90124"));
            return false;
        }

        if(ComIsNull(fromObj.inv_no) || ComIsNull(fromObj.inv_no.value))
        {
             ComShowMessage(ComGetMsg("TRS90124"));
             return false;
        }

        if(ComIsNull(fromObj.inv_rcv_dt) || ComIsNull(fromObj.inv_rcv_dt.value))
        {
            ComShowMessage(ComGetMsg("TRS90124"));
            return false;
        }

        if(ComIsNull(fromObj.inv_iss_dt) || ComIsNull(fromObj.inv_iss_dt.value))
        {
            ComShowMessage(ComGetMsg("TRS90124"));
            return false;
        }
        

        if(ComIsNull(fromObj.inv_curr_cd) || ComIsNull(fromObj.inv_curr_cd.value) || (fromObj.inv_curr_cd.value == 'ALL') )
        {
            ComShowMessage(ComGetMsg("TRS90124"));
            return false;
        }

        if(ComIsNull(fromObj.inv_bzc_amt) || ComIsNull(fromObj.inv_bzc_amt.value))
        {
            ComShowMessage(ComGetMsg("TRS90124"));
            return false;
        }

        if(ComIsNull(fromObj.inv_vat_amt) || ComIsNull(fromObj.inv_vat_amt.value))
        {
            ComShowMessage(ComGetMsg("TRS90124"));
            return false;
        }

        if(ComIsNull(fromObj.inv_whld_tax_amt) || ComIsNull(fromObj.inv_whld_tax_amt.value))
        {
            ComShowMessage(ComGetMsg("TRS90124"));
            return false;
        }
     
     return true;       
   }
   
   function chkComfirm()
   {
       var insflag = document.form.insflag.value;
       if (insflag == "false") 
       {
            errMsg = ComGetMsg("TRS90002" );
            ComShowMessage(errMsg);
            return true;
       }
       return false;
   }
/**
 * rep_commodity팝업호출
 */
    function rep_OnPopupClick()
    {
    
    		var formObject = document.form;
    		var cmdt_cd_val ="";   //향후 사용가능 예정변수
    		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
    		var cmdt_desc_val ="";   //향후 사용가능 예정변수
    		var classId ="getCOM_ENS_rep";
    		var xx1="";  //CONTI
    		var xx2="";  //SUB CONTI
    		var xx3="";  //COUNTRY
    		var xx4="";  //STATE
    		var xx5="";  //CONTROL OFFIC
    		var xx6="";  //LOC CODE
    		var xx7="";  //LOC NAME
    		var xx8="";
    		var xx9="";
    
    		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
    		ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 612, 450, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
    
    }

    function sheet1_OnSaveEnd(sheetObj , ErrMsg)
    {
        if (ErrMsg != "") return;
        
        errMsg = ComGetMsg("TRS90002" );
        ComShowMessage(errMsg);
        
        document.form.insflag.value = "false";        // 입력 상태를 수정 상태로 전환 

    //    doActionIBSheet2(sheetObjects[0] , document.form , IBSEARCH);
    }
    
   function sheet1_OnChange(sheetObj, row , col, value)
   {
       if ( sheetObj.ColSaveName(col) == "trsp_cost_dtl_mod_cd")
       {
           if ( value.charAt(0) == "G")
           {
              sheetObj.CellComboItem ( row , "eq_tpsz_cd" , gn_tpszCode , gn_tpszCode);
              sheetObj.CellValue2 ( row , "eq_tpsz_cd") ="";
           } else if ( value.charAt(0) == "H")
           {
               sheetObj.CellComboItem ( row , "eq_tpsz_cd" , ch_tpszCode , ch_tpszCode);
               sheetObj.CellValue2 ( row , "eq_tpsz_cd") ="";
           } else {
               sheetObj.CellComboItem ( row , "eq_tpsz_cd" , eq_tpszCode , eq_tpszCode);
               sheetObj.CellValue2 ( row , "eq_tpsz_cd") ="";
           }
       } 
   }
   
   function checkInputData(sheetObj)
   {
        var eq_comboCode = "";
        var cost_comboCode =  sheetObj.GetComboInfo ( 0 , "trsp_cost_dtl_mod_cd" ,  "Code");
        var crr_comboCode =  sheetObj.GetComboInfo ( 0 , "trsp_crr_mod_cd" ,  "Code");
        
        var flag = true;
        var dtflag = true;
        var vflag = true;
        
        if(sheetObj.CheckedRows('sel') == 0 || sheetObj.CheckedRows('sel') == null )  {
            ComShowCodeMessage('TRS90215');
            return false;
        } 
        var chkrows = sheetObj.FindCheckedRow("sel");
          
        var arrRow = chkrows.split("|");
        for (idx=0; idx<arrRow.length-1; idx++){ 
            row = arrRow[idx];

            sheetObj.RowBackColor(row) = sheetObj.RgbColor(255,255,255);
            if (cost_comboCode.indexOf(sheetObj.CellValue( row , "trsp_cost_dtl_mod_cd")) == 0 )
            {
                sheetObj.CellBackColor ( row , "trsp_cost_dtl_mod_cd") = sheetObj.RgbColor (255, 0, 0);
                sheetObj.CellBackColor ( row , "eq_tpsz_cd") = sheetObj.RgbColor (255, 0, 0);
                flag = false;

            } 

            if (parseInt(crr_comboCode.indexOf(sheetObj.CellValue( row , "trsp_crr_mod_cd"))) == 0)
            {
                sheetObj.CellBackColor ( row , "trsp_crr_mod_cd") = sheetObj.RgbColor (255, 0, 0);
                flag = false;

            } 
            
            eq_comboCode = " |"+sheetObj.GetComboInfo ( row , "eq_tpsz_cd" ,  "Code");
            if (parseInt(eq_comboCode.indexOf(sheetObj.CellText( row , "eq_tpsz_cd"))) == 0)
            {
                sheetObj.CellBackColor ( row , "eq_tpsz_cd") = sheetObj.RgbColor (255, 0, 0);
                flag = false;

            }
            
            if(isNaN(sheetObj.CellValue( row , "trsp_rfnd_qty")) || sheetObj.CellValue( row , "trsp_rfnd_qty") == "" )
            {
                sheetObj.CellBackColor(row, "trsp_rfnd_qty")= sheetObj.RgbColor(255, 0, 0);
                flag = false;

            } 

            if(isNaN(sheetObj.CellValue( row , "trsp_rfnd_inv_amt")) || sheetObj.CellValue( row , "trsp_rfnd_inv_amt") == "" )
            {
                sheetObj.CellBackColor(row, "trsp_rfnd_inv_amt")= sheetObj.RgbColor(255, 0, 0);
                flag = false;

            } 
            
            //if (!checkDateFormat(sheetObj.CellText(row , "hndl_prd_fm_dt")))
            if( sheetObj.CellValue(row , "hndl_prd_fm_dt").replace(/-/gi,"").length != 8 )
            {
                sheetObj.CellBackColor(row , "hndl_prd_fm_dt")= sheetObj.RgbColor(255, 0, 0);
                flag = false;
                dtflag = false;

            }
            
            //if (!checkDateFormat(sheetObj.CellText(row , "hndl_prd_to_dt")))
            if (sheetObj.CellValue(row , "hndl_prd_to_dt").replace(/-/gi,"").length != 8)
            {
                sheetObj.CellBackColor(row , "hndl_prd_to_dt")= sheetObj.RgbColor(255, 0, 0);
                flag = false;
                dtflag = false;

            }

            if (dtflag){
                if (parseInt(sheetObj.CellValue(row , "hndl_prd_fm_dt").replace(/-/gi,"")) > parseInt(sheetObj.CellValue(row , "hndl_prd_to_dt").replace(/-/gi,"")))
                {
                   sheetObj.CellBackColor(row , "hndl_prd_fm_dt")= sheetObj.RgbColor(255, 0, 0);
                   sheetObj.CellBackColor(row , "hndl_prd_to_dt")= sheetObj.RgbColor(255, 0, 0);
                   flag = false;

                }
            }

            if ( flag)
            {
                sheetObj.CellValue2(row , "result") = "Good";
            } else {
                sheetObj.CellValue2(row , "result") = "Incorrect";
                vflag = false;
            }
            flag = true;
            dtflag = true;
        }

        var irow;
        var jrow;
        var dupflag = false;
        var selrows = sheetObj.FindCheckedRow("sel");
        
        var chkRow = selrows.split("|");
        
        var dupRow = chkRow;
        
        for (i=0; i<chkRow.length-1; i++){
        	dupflag = false;
        	if( dupRow[i] == 0 )  continue;

            irow = chkRow[i];
            for(j=i+1; j<chkRow.length-1; j++){

            	jrow = chkRow[j];
            	
            	if( sheetObj.CellValue(irow , "trsp_cost_dtl_mod_cd") == sheetObj.CellValue(jrow , "trsp_cost_dtl_mod_cd") ){
            		if( sheetObj.CellValue(irow , "trsp_crr_mod_cd") == sheetObj.CellValue(jrow , "trsp_crr_mod_cd") ){ 
            			if( sheetObj.CellValue(irow , "eq_tpsz_cd") == sheetObj.CellValue(jrow , "eq_tpsz_cd") ){ 
            				sheetObj.RowBackColor(irow) = sheetObj.RgbColor(238,255,226);
                            sheetObj.RowBackColor(jrow) = sheetObj.RgbColor(238,255,226);
                            sheetObj.CellValue2(irow , "result") = "Dup";
                            sheetObj.CellValue2(jrow , "result") = "Dup";
                            dupflag = true;
                            vflag = false;
            			}
                			
            		}
            	}
            	if( dupflag )
            		dupRow[j] = 0;            		
            }
        } 
        return vflag;
    }
      
   
/**
 * rep_commodity팝업호출 : 팝업서 단일 선택을 한경우..
 */
    function getCOM_ENS_rep(rowArray) {
    
    	var formObj = document.form;
    	var comboObj = document.combo_svc_provider;
    	
    	for(var i=0; i<rowArray.length; i++)
    	{
    		var colArray = rowArray[0];
    		var colArray2 = colArray[2];
    		var colArray3 = colArray[4];
    		
    		comboObj.InsertItem(comboObj.GetCount(), colArray2+'|'+colArray3, colArray2);
    
    		comboObj.Text = colArray2;
    		document.form.svc_provider.value = comboObj.GetText(comboObj.Text, 1);
    	}
    }

 
 /**
  * 외부 콤보박스의 리스트 가져오기
  **/
     function getVendorComboList()
     {
      var formObj = document.form;
      var vendorNo = formObj.combo_svc_provider.Text ;
    
      getVendorCombo(document.combo_svc_provider, sheetObjects[0], formObj, vendorNo);
     }


    
     function wo_vndr_seq_OnKeyDown(combo, keycode,shift)
     {
      if(keycode == 13)
      {
       searchVendorName(combo);
      }
     }

     function searchVendorName(combo)
     {
      var formObject = document.form;
      formObject.f_cmd.value = SEARCH11;
      formObject.hid_provider.value = combo.Text
    
      document.form.svc_provider.value = combo.GetText(combo.Text,1);
     }


 /**
  * service provider combo 선택시 textfield의 값 변경하는 이벤트
  **/
     function wo_vndr_seq_OnChange(combo, Index_Code, Text)
     {
      var formObj = document.form;
      document.form.svc_provider.value = combo.GetText(Index_Code,1);
      formObj.hid_svc_provider.value = (formObj.combo_svc_provider.Code).toUpperCase();
      }
 

    function wo_vndr_seq_OnBlur (combo) {
       if ( document.form.svc_provider.value == "") return ;
       doActionIBSheet(sheetObjects[0] , document.form , IBROWSEARCH);
    }
    
	  /**
     * MInimize 클릭시 이벤트 관련
     */
    function Minimize(nItem)
    {

        var objs = document.all.item("showMin");

        if ( nItem == "1" )
        {
    	    objs.style.display = "none";


            sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(17);
			sheetObjects[0].focus();
			sheetObjects[0].ViewRows  =20;

		}
    	else
    	{
    	    objs.style.display = "inline";

    	    sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(13);
			sheetObjects[0].focus();
			sheetObjects[0].ViewRows  =10;

    	}

    }
    
	function checkDateFormat(dt){
		var date_regexp = "^(\\d{4}-\\d{2}-\\d{2})$";
		if (!checkFormat(dt, date_regexp)){
			return false;
		}
		return true;
	}	
	
	function BlurDate(obj){
	   if (obj.value == "")
	   {
	       return;
	   }
	   if ( !ComIsDate(obj) ){
            errMsg = ComGetMsg("COM12179");
            ComShowMessage(errMsg);
            obj.focus();
            return ;
		} else {
		   rsdate = addBar(obj.value);
		   obj.value = rsdate;
		}
	}
	

	//날자포맷으로 yyyy-mm-dd
	function addBar(dt) 
	{
		var dat="";
		if( dt.length == 8 )
	  {
		dat = dt.substr(0,4) + '-' + dt.substr(4,2) + '-' + dt.substr(6,2);
	  }
		 return dat; 
	}
	
	function fun_Focus_del(obj)
	{
	    date = obj.value.replace(/\/|\-|\./g , "");
	    obj.value = date;
	}
	function checkFormat(object, regexp){
		// 주어진 값이 정규식에 일치하는지 확인하고 맞으면 true를 틀릴경우 false를 return한다.
		if (object == null || object == ""){
			return false;
		} else {
			re = new RegExp(regexp,"gi"); //'gi'는 case-insensitive global match를 위함이다
			if (!re.test(object)){
				return false;
			}
		}
		return true;
	}
	
	
	function sumAmt()
	{

	    var bac_amt = 0;
	    var vat_amt = 0;
	    var wht_amt = 0 ;
	    if ( document.form.inv_bzc_amt.value != "")
	    {
	    	
	       //  bac_amt = deleteComma(document.form.inv_bzc_amt.value) ; 
	         bac_amt = ComReplaceStr(document.form.inv_bzc_amt.value, '.', '');
	    }
	    if ( document.form.inv_vat_amt.value != "")
	    {
	        // vat_amt = deleteComma(document.form.inv_vat_amt.value);
	         vat_amt = ComReplaceStr(document.form.inv_vat_amt.value, '.', '');
	    }
	    if ( document.form.inv_whld_tax_amt.value != "")
	    {
	        // wht_amt = deleteComma(document.form.inv_whld_tax_amt.value);
	         wht_amt = ComReplaceStr(document.form.inv_whld_tax_amt.value, '.', '');
	    }
	    
	    document.form.inv_ttl_amt.value = parseFloat(bac_amt)+parseFloat(vat_amt)-parseFloat(wht_amt);
	    var curr_value = document.form.inv_curr_cd.value;
	    if ( !(curr_value == "KRW" || curr_value == "JPY" || curr_value == "TWD")){
	    	document.form.inv_ttl_amt.value = addComma1(document.form.inv_ttl_amt.value);
	    }
	    chkAmtFmtObj(document.form.inv_ttl_amt);

	}
	
	function isMon(obj, isChkFmt){
		//통화만 -> 숫자,.까지  + 소숫점 이하 2자리만 허용
		if (!ComIsNumber(obj,'-.,')){
			obj.value = '';
		}

		if (isChkFmt!=undefined && isChkFmt!=null && isChkFmt=='Y'){
			var src = deleteComma(obj.value);
			if (src.indexOf('.') != -1){
				if (src.length-1 > src.indexOf('.')+2){
					src = src.substring(0,src.indexOf('.')+3);
					obj.value = src;
				}
				if (src.indexOf('.') != src.lastIndexOf('.')){
					src = src.substring(0,src.lastIndexOf('.'));
					//obj.value = src;
					obj.value = chkAmtFmt(src);
				}
			}
		}
	}

	function chkAmtFmtObj(obj){
		
		//var obj = document.form.inv_bzc_amt;

		//if (obj==undefined || obj.value==null || ComTrim(obj.value)==''){
		if(obj.value==null || obj.value.trim()==''){
			return false;
		}
		obj.value = chkAmtFmt(obj.value);
	}
	
	function chkAmtFmt(src){

		if (src==undefined || src==null || ComTrim(src)==''){
			return "";
		}
		/*
		else{
			src = src.substring(0,src.indexOf('.'));

			var src = ComReplaceStr(src, '.', '');

		}*/
		/*
		var src = deleteComma(src);
		if (src==null || ComTrim(src)==''){
			return '';
		}
		return ComReplaceStr(src, '.', '');
		

		*/


		if(document.form.inv_curr_cd.value == "KRW" || document.form.inv_curr_cd.value == "JPY" || document.form.inv_curr_cd.value == "TWD")
        {
            if (src.indexOf('.') != -1){
       			src.value = "";
                ComShowMessage(ComGetMsg("COM12136" , "KRW, JPY, TWD"));
    			return "";
    		}
        } else {
    		if (src.indexOf('.') == -1){
    			//src = addComma(src,true,true,true) + '.00'
    			src = src + '.00';
    		} else {
    			var temp = src.split(".");
    			if (temp.length == 2){
    				if (temp[1]==null || ComTrim(temp[1])==''){temp[1] = '00';}
    				if (temp[1].length == 1){temp[1] += '0';				
    				} else if (temp[1].length == 2){
    				} else if (temp[1].length > 2){temp[1] = temp[1].substring(0,2);  
    				}
    				//src = addComma(temp[0])+'.'+temp[1];
    				src = temp[0]+'.'+temp[1];
    			} else if (temp.length > 2){
    				// 두번째 .부터 .를 다 삭제하고 재계산하기 
    				var tmp_str = '';
    				for (var i=1; i<temp.length; i++){
    					tmp_str += ComTrim(new String(temp[i]));
    				}
    				if (tmp_str==null || ComTrim(tmp_str)==''){tmp_str = '00';}
    				if (tmp_str.length == 1){tmp_str += '0';				
    				} else if (tmp_str.length == 2){
    				} else if (tmp_str.length > 2){tmp_str = tmp_str.substring(0,2);  
    				}
    				//src = addComma(temp[0])+'.'+tmp_str;
    				src = temp[0]+'.'+tmp_str;
    			} else {
    				return false;
    			}
    		}
        }
		return src;
	}
	
	function chkInput(obj) {
		if (obj.maxLength < getStrLen(obj.value)){
			obj.value = '';
			obj.focus();
			return false;
		}
	}
	
	function deleteComma(src){
		// comma를 제거
		//var src = String(src);
		if (src==null || ComTrim(src)==''){
			return '';
		}
		return ComReplaceStr(src, '.', '');
	}
	
	function addComma1(src){
		// comma를 3자리마다 끼워넣기
		var src = String(src);
		if (src==null || ComTrim(src)==''){
			return '';
		}
		var re = /(-?\d+)(\d{2})/;
		if (re.test(src)) {
			src = src.replace(re, "$1.$2");
		}
		return  src;
	}
/*
	function ComChkObjValid(src){
		// comma를 3자리마다 끼워넣기
		var src = String(src);
		if (src==null || ComTrim(src)==''){
			return '';
		}
		var re = /(-?\d+)(\d{3})/;
		while (re.test(src)) {
			//src = src.replace(re, "$1,$2");
			src = ComReplaceStr(src, re, "$1,$2");
		}
		return  src;
	}
*/
	function getStrLen(src) {
		// 한글 및 영문 str의 길이를 구함
		src = new String(src);
		var byteLength = 0;
		for (var inx = 0; inx < src.length; inx++) {
			var oneChar = escape(src.charAt(inx));
			if (oneChar.length == 1) {
				byteLength ++;
			} else if (oneChar.indexOf("%u") != -1) {
				byteLength += 2;
			} else if (oneChar.indexOf("%") != -1) {
				byteLength += oneChar.length/3;
			}
		}
		return byteLength;
	}
	
	function checkCurr(curr_value)
	{

	    if ( curr_value == "KRW" || curr_value == "JPY" || curr_value == "TWD")
	    {
			sheetObjects[0].InitDataProperty(0, 6 , dtData,	 70,		daRight,			true,    "trsp_rfnd_qty",				false,			"",			dfInteger,			2,			true,			true	);
			sheetObjects[0].InitDataProperty(0, 7 , dtData,	 70,		daRight,			true,    "trsp_rfnd_inv_amt",				false,			"",			dfInteger,			2,			true,			true	);
			sheetObjects[0].InitDataProperty(0, 8 , dtData,	100,		daRight,			true,    "trsp_rfnd_uc_rt",				false,			"|trsp_rfnd_qty|*|trsp_rfnd_inv_amt|+|inv_nego_amt|",			dfInteger,			2,			true,			false	);
			sheetObjects[0].InitDataProperty(0, 9 , dtData,	 70,		daRight,			true,    "inv_nego_amt",				false,			"",			dfInteger,			2,			true,			true	);
			
	       document.form.inv_bzc_amt.value = parseInt(document.form.inv_bzc_amt.value);   
	       document.form.inv_vat_amt.value = parseInt(document.form.inv_vat_amt.value); 
	       document.form.inv_whld_tax_amt.value = parseInt(document.form.inv_whld_tax_amt.value); 
	       document.form.inv_ttl_amt.value = parseInt(document.form.inv_ttl_amt.value); 
	    } else {
			sheetObjects[0].InitDataProperty(0, 6 , dtData,	 70,		daRight,			true,    "trsp_rfnd_qty",				false,			"",			dfFloat,			2,			true,			true	);
			sheetObjects[0].InitDataProperty(0, 7 , dtData,	 70,		daRight,			true,    "trsp_rfnd_inv_amt",				false,			"",			dfFloat,			2,			true,			true	);
			sheetObjects[0].InitDataProperty(0, 8 , dtData,	100,		daRight,			true,    "trsp_rfnd_uc_rt",				false,			"|trsp_rfnd_qty|*|trsp_rfnd_inv_amt|+|inv_nego_amt|",			dfFloat,			2,			true,			false	);
			sheetObjects[0].InitDataProperty(0, 9 , dtData,	 70,		daRight,			true,    "inv_nego_amt",				false,			"",			dfFloat,			2,			true,			true	);
			
	    }

	       sumAmt();

	}
	String.prototype.trim = function()
	{
		return this.replace(/(^\s*)|(\s*$)/g, "");
	}
	
	function getSaveString(params){
	var saveString = null;
	if(params == null){
		saveString = "";
	}else{
		saveString = params.join("&");
	}
	return saveString;
}

/**
  * WO Vendor 조회 
  **/
	function getVendorSeq(){
		var sheetObj = sheetObjects[0];  //docObjects[0];
		var formObj = document.form;
		var vndr_seq = formObj.combo_svc_provider.value;

	
		//formObj.f_cmd.value = SEARCH11;
		formObj.f_cmd.value = SEARCH03;  //ESD_TRS_0040 로  event 변경
		//입력된 vendor값중 숫자만 가지고 조회를 해온다. 문자는 무시

		formObj.TRSP_SO_VNDR_NO.value = get_only_num(vndr_seq);

		//조회 결과를 담는 sheet의 EtcData를 초기화한다.
		sheetObj.RemoveEtcData();
		//Vendor에 해당되는 내용을 조회해온다.

		sheetObj.DoRowSearch("ESD_TRS_0040GS.do", TrsFrmQryString(formObj));

		//조회된 vendor를 EtcData에서 꺼내 변수에 담는다.
		var vendorNoList = sheetObj.EtcData('vndr_no');
		var vendorNmList = sheetObj.EtcData('vndr_nm_eng');
		//payment vendor combo
		var comboObj = document.paymt_sp_combo;
		//조회된 값이 존재하지 않는다면 화면을 초기화	
		if (vendorNoList == undefined || vendorNoList == ''){
			formObj.combo_svc_provider.value = '';
			formObj.svc_provider.value = '';
	
			formObj.paymt_sp_cd.value = '';
			formObj.paymt_sp_nm.value = '';
			comboObj.RemoveAll();
			return false;
		}
		//vendor code를 6자리로 맞춘다. 000001형태
		formObj.combo_svc_provider.value = lpad(vendorNoList, 6, '0') ;
		formObj.svc_provider.value = vendorNmList;
		
		//payment vendor를 조회할 function
		searchPaymentSP(sheetObjects[0], formObj, vendorNoList);
		return true;
	}

/**** WO SP에 대한 PAYMENT SP를 찾는다. ****/
	function searchPaymentSP(sheetObj, formObj, wo_sp_value) {

		formObj.f_cmd.value = SEARCH02;
		//form 내용을 query string으로 묶는다. "?A=1&B=2" 형태
		var query = TrsFrmQryString(formObj);
		//sheet의 EtcData를 초기화 한다.
		sheetObj.RemoveEtcData();
		//payment vendor를 조회해 온다.

		sheetObj.DoRowSearch("ESD_TRS_0033GS.do", query);
		//조회된 값을 변수에 넣는다.
		var prnt_vndr_seq = sheetObj.EtcData('prnt_vndr_seq');
		var prnt_vndr_nm = sheetObj.EtcData('prnt_vndr_nm');
		var comboObj = document.paymt_sp_combo;
		//payment vendor combo list를 모두 지운다.

		comboObj.RemoveAll();
		//combo를 조회한 값으로 재 초기화 한다.
		comboObj.InsertItem(-1, formObj.combo_svc_provider.value, formObj.svc_provider.value);
		//조회된 값이 없는 경우 에러메세지
		if(prnt_vndr_seq == null || prnt_vndr_seq == ''){
			ComShowMessage(ComGetMsg('TRS90065'));
		//조회된 payment vendor가 wo vendor와 동일하지 않는 경우 Payment vendor를 List에 추가한다.
		}else if(lpad(prnt_vndr_seq, 6,'0') !=  lpad(wo_sp_value,6,'0')) {
			comboObj.InsertItem(-1, lpad(prnt_vndr_seq, 6, '0'), prnt_vndr_nm);
		}

		//onchange event를 발생시키지 않기위해 index2 = 0 으로 변경한다.
		comboObj.Index2 = 0;
		formObj.paymt_sp_cd.value = comboObj.Text;
		formObj.paymt_sp_nm.value = comboObj.Code;

	}
	
/****
** payment vendor 값을 변경했을때 발생되는 evnet 정의
****/	
	
	function paymt_sp_combo_OnChange(comboObj, index_code, text){

		var formObj = document.form;
		formObj.paymt_sp_cd.value = comboObj.Text;
		formObj.paymt_sp_nm.value = comboObj.Code;
	}
   
/**
 * rep_commodity팝업호출 : 팝업에서 단일 선택을 한경우..
 */
function getCOM_ENS_rep(rowArray) {

	var formObj = document.form;
	
	for(var i=0; i<rowArray.length; i++)
	{
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[4];
	
		formObj.combo_svc_provider.value = colArray2;
		formObj.svc_provider.value = colArray3;
	}
	searchPaymentSP(sheetObjects[0],formObj,formObj.combo_svc_provider.value);
}