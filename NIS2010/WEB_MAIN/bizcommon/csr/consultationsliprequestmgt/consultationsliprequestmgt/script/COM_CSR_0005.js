/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COM_CSR_0005.js
*@FileTitle : 세금계산서입력화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.07.09 함대성
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
     * @class COM_CSR_0005 : COM_CSR_0005 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function COM_CSR_0005() {
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
var Radiocount = 0;

var comboObjects = new Array();
var comboCnt = 0 ;

var tax_no2_count = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
			 var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");


			switch(srcName) {

				case "btng_ok_k":

					if(isNull2(document.form.tax_no1.value)){
							showErrMessage(getMsg('CSR24007','tax no.'));
							return false;
					}

					if(csr_deleteComma(formObject.total_amt_hdr.value) != csr_deleteComma(formObject.total_amt.value)){
							showErrMessage(getMsg('CSR25009'));
							return false;
					}

					if(isNull2(comboObjects[0].Code)){
							showErrMessage(getMsg('CSR25030'));
							return false;
					}

					if(isNull2(getRadioValue(formObject.finance_flg))){
							showErrMessage(getMsg('CSR25011'));
							return false;
					}
					
					if(!isCheckedOnlyOne(document.form.attr_ctnt8)){
						showErrMessage(getMsg('CSR25033'));
						return false;
					}

					if(csr_deleteComma(document.form.total_amt.value)>0){
							if(document.form.finance_flg[0].checked == false){
									showErrMessage(getMsg('CSR25022'));
									return false;
							}
					}else if(csr_deleteComma(document.form.total_amt.value)<=0){
							if(document.form.finance_flg[1].checked == false){
									showErrMessage(getMsg('CSR25023'));
									return false;
							}
					}

					var saupjano = formObject.comp_no1.value+formObject.comp_no2.value + formObject.comp_no3.value;

					if(!check_busino(saupjano)){
							showErrMessage(getMsg('CSR25013'));
							return false;
					}

					if(sheetObjects[0].RowCount<1){
							showErrMessage(getMsg('CSR25031'));
							return false;
					}

					if(sheetObjects[0].RowCount>0){
							for(var i=0;i<sheetObjects[0].RowCount;i++){
									if(sheetObjects[0].CellValue(i+1,3)==""){
											showErrMessage(getMsg('CSR25026'));
											break;
											return false;
									}
							}
					}

    		        document.form.tax_no2.value = comboObjects[0].Code;
    		        if(comboObjects[0].Code != ""){
    				   form.f_cmd.value = SEARCH02;
    				   sheetObjects[0].WaitImageVisible = false;
    				   sXml1 = sheetObjects[0].GetSearchXml("COM_CSR_0004GS.do" , FormQueryString(form));
 	    		       var tax_no3 = ComGetEtcData(sXml1,"tax_no3");
		    	       document.form.tax_no3.value = tax_no3;
    		        }
    		        /*
    		        form.f_cmd.value = SEARCH04;
    		        var sXml2 = sheetObjects[0].GetSearchXml("COM_CSR_0004GS.do" , FormQueryString(form));
    		        //콤보코드와 콤보텍스트 가져오기
    		        var ap_tax_nm = ComGetEtcData(sXml2,"ap_tax_nm");
    		        document.form.tax_code.value  = ap_tax_nm;
    		        */
					setOpenerInsertData();
					showErrMessage(getMsg('CSR25015'));
					window.close();

					break;

				case "btng_cancel_k":
					window.close();
					break;

				case "btng_new_k":
					comboObjects[0].Code = "";
					formObject.tax_no3.value="";
					formObject.finance_flg[0].checked=false;
					formObject.finance_flg[1].checked=false;
					formObject.comp_no1.value="";
					formObject.comp_no2.value="";
					formObject.comp_no3.value="";
					formObject.inv_dt.value="";
					sheetObjects[0].RemoveAll();
					break;

				case "btng_add_k":
					if(isNull2(document.form.tax_no1.value)){
							showErrMessage(getMsg('CSR24007','tax no.'));
							return false;
					}
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;

				case "btng_delete_k":
						var k = 0;
			 	 	  for(var i=0;i<sheetObjects[0].RowCount;i++){
			 	 				if(sheetObjects[0].CellValue(i+1,0)==1){
			 	 						sheetObjects[0].RowDelete(i+1, false);
			 	 						k++;
			 	 						i = i-k;
			 	 				}
			 	 	  }

		     		var net_amt  = 0;
		     		var total_amt= 0;

		 				for(var i = 0;i<sheetObjects[0].RowCount;i++){
		 					net_amt = parseFloat(sheetObjects[0].CellValue(i+1,4)*100)+parseFloat(csr_deleteComma(net_amt));
		 				}

		        document.form.net_amt.value 			= csr_addComma(net_amt/100);
		        document.form.total_amt.value 		= csr_addComma(net_amt/100);
					break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			showErrMessage(getMsg('CSR21025'));
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

      	for (i = 0; i < sheetObjects.length; i++) {
     		//khlee-시작 환경 설정 함수 이름 변경
     		ComConfigSheet(sheetObjects[i]);
     		initSheet(sheetObjects[i], i + 1);
     		//khlee-마지막 환경 설정 함수 추가
     		ComEndConfigSheet(sheetObjects[i]);

     	}

     	//combo 초기화
     	for(var k=0;k<comboObjects.length;k++){
     	    initCombo(comboObjects[k], k+1);
     	}

		disableObject(document.form.vndr_seq_hdr);
		disableObject(document.form.total_amt_hdr);
		//disableObject(document.form.tax_no1);
		disableObject(document.form.tax_no3);
		disableObject(document.form.volume);
		disableObject(document.form.ho);
		disableObject(document.form.vndr_nm);
		disableObject(document.form.bzct_nm);
		disableObject(document.form.vndr_addr);
		disableObject(document.form.bzct_nm);
		disableObject(document.form.bztp_nm);
		disableObject(document.form.ceo_nm);
		disableObject(document.form.vndr_seq);
		disableObject(document.form.net_amt);
		disableObject(document.form.total_amt);
		insertValue();

		//MNR, PSO 모듈이 아닌경우
		if(document.form.inv_sub_sys_cd.value != "MNR" && document.form.inv_sub_sys_cd.value != "PSO"){
			disableObject(document.form.comp_no1);
			disableObject(document.form.comp_no2);
			disableObject(document.form.comp_no3);
		}

		//tax_no2 콤보
	 	doActionIBCombo(sheetObjects[0] , document.form ,IBSEARCH , comboObjects[0], SEARCHLIST01 ,"tax_no2");
	 	taxInfo();
    }

     function sheet1_OnLoadFinish(sheetObj) {
    	 //rgst_no 조회
         doActionIBSheet(sheetObjects[0],document.form, IBCLEAR);
     }

	function validateDateObj(obj){
		obj.value = obj.value.trim();
		if (obj.value==null || obj.value.trim()==''){return false;}
		if (!checkPeriodFormat(obj.value) || !csr_isValidDateObject(obj.value.substring(0,4)+'-'+obj.value.substring(4,6)+'-01','-')){
			showErrMessage(getMsg('CSR23011')); //showErrMessage('날짜 형식이 잘못되었습니다.');
			obj.focus();
			return false;
		}
		return true;
	}

	function checkPeriodFormat(prd_dt){
		var date_regexp = /(^\d{6}$)/;
		if (!csr_checkFormat2(prd_dt, date_regexp)){	return false;
		} else { return true;
		}
	}

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
                    style.height = GetSheetHeight(8);
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					 					InitColumnInfo(5, 1, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = " |STS|순번|품명|공급가액" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
										InitDataProperty(0, cnt++ , dtCheckBox,   		30,    	daCenter,  		false,    	"",     	false,     	"",       dfNone,   			0,     	true,       true);
										InitDataProperty(0, cnt++ , dtHiddenStatus,     30,    	daCenter,  		false,    	"",     	false,      "",       dfNone,   			0,     	false,      true);
										InitDataProperty(0, cnt++ , dtSeq, 	 			30,		daCenter,		true,    	"",			false,		"",		  dfNone,				0,			true,				true);
										InitDataProperty(0, cnt++ , dtData,				350,	daLeft,		    true,   	"",			false,		"",		  dfNone,				0,			true,				true);
										InitDataProperty(0, cnt++ , dtData,				150,	daRight,		true,    	"",			false,		"",		  dfInteger,			0,			true,				true);

										CountFormat = "[SELECTDATAROW / ROWCOUNT]";

               }
                break;

            case 2:      //sheet1 init
                with (sheetObj) {
	                // 높이 설정
                    style.height = GetSheetHeight(8);
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					 					InitColumnInfo(1, 1, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = "순번" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, 		DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
										InitDataProperty(0, cnt++ , dtData,				150,		daRight,			true,    	"",				false,					"",			dfNone,			0,			false,				false);


               }
                break;
        }
    }


  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBINSERT:      // 입력
           			if(sheetObj.RowCount == 4){
           				showErrMessage(getMsg('CSR25027'));	//showErrMessage("더 이상 생성이 불가능합니다.");
           			}else{
                		sheetObj.DataInsert();
                }
                break;

           case IBCOPYROW:        //행 복사
              sheetObj.DataCopy();
              break;

           case IBCLEAR:		//RGST_NO 조회
			    form.f_cmd.value = SEARCH03;
				sheetObjects[0].WaitImageVisible = false;
			    var sXml = sheetObjects[0].GetSearchXml("COM_CSR_0004GS.do" , FormQueryString(form));

			    //사업자등록번호
			    var compNo   = ComGetEtcData(sXml,"comp_no");

				document.form.comp_no1.value = compNo.substring(0,3);
				document.form.comp_no2.value = compNo.substring(3,5);
				document.form.comp_no3.value = compNo.substring(5,10);

				//taxInfo();
			break;
        }
    }


    function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey) {
   	   switch(sAction) {

   	      case IBSEARCH:
   			if (sComboObj.id == "tax_no2") {
   				//콤보필드를 초기화시킨다.
   				sComboObj.RemoveAll();

   				formObj.f_cmd.value = sComboAction;
   				var sXml = sheetObj.GetSearchXml("COM_CSR_0004GS.do", FormQueryString(formObj));

   				//Trade setting
   				var comboItems = ComGetEtcData(sXml, sComboKey).split("|");
   				addComboItem(sComboObj,comboItems);

	            try {
	            	/** [CHM-201222183] PORT SO 증빙내 접수 공급받는자 점소 관련 추가 사항 **/
	            	if (document.form.inv_sub_sys_cd.value == "PSO"){
	            		if (comboObjects[0].Code==null || comboObjects[0].Code==''){
	            			
	            			formObj.f_cmd.value = SEARCH05;
		            		var sXml = sheetObjects[0].GetSearchXml("COM_CSR_0004GS.do",FormQueryString(form));
		            		var def_ofc	= ComGetEtcData(sXml,"def_ofc"); //값설정한다
	            			//alert('def_ofc:'+def_ofc);
			            	if (def_ofc!=null && def_ofc!=''){
				            	comboObjects[0].Code = def_ofc;
				            }
	            		}
	            	}
	            } catch(e){
	            }
   			}

   	        break;
   	   }
    }

    /**
     * 콤보필드에 데이터를 추가해준다.
     */
    function addComboItem(comboObj,comboItems) {
    	for (var i = 0 ; i < comboItems.length ; i++) {
    		var comboItem = comboItems[i].split(",");
    		comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);
    	}
    }

   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
        }

        return true;
    }


		function insertValue(){
				var opener_obj = window.dialogArguments;
				//var opener_obj = opener;
				var opener_sheet_obj =  opener_obj.document.sheet1;

				document.form.vndr_seq.value= opener_obj.document.form.vndr_seq.value;
				document.form.vndr_seq_hdr.value= opener_obj.document.form.vndr_seq.value;

				var k = 0;
				var vat_amt = 0;
				var total_amt = 0;
				var checkRow = opener_sheet_obj.FindCheckedRow(1);
				var checkRowArray = checkRow.split("|");

				for(k=0;k<checkRowArray.length-1;k++){
						total_amt	=	total_amt+parseFloat(opener_sheet_obj.CellValue(checkRowArray[k], "inv_ttl_amt"));
				}
				document.form.total_amt_hdr.value= csr_addComma(total_amt);

				if(total_amt>0){
						document.form.finance_flg[0].checked = true;
				}else if(total_amt<=0){
						document.form.finance_flg[1].checked = true;
				}
		}

		function insertValueEvi(){
				var opener_obj = window.dialogArguments;
				//var opener_obj = opener;
				var opener_sheet_obj =  opener_obj.document.sheet1;
				var k=0;

				if(opener_obj.document.form.s_eviInputFlg.value=="Y"){

						tax_no2_onchageFlg  = "Y";
						
						//전자/종이계산서
						if(opener_obj.document.form.attr_ctnt8.value == "ELECTRONIC"){
							document.form.attr_ctnt8[0].checked = true;
							document.form.attr_ctnt8[1].checked = false;
						}else if(opener_obj.document.form.attr_ctnt8.value == "PAPER"){
							document.form.attr_ctnt8[0].checked = false;
							document.form.attr_ctnt8[1].checked = true;
						}

						document.form.tax_no1.value = opener_obj.document.form.s_evi_tax_no.value.substring(0,6);
						if(opener_obj.document.form.s_evi_tax_no.value.length==16){
								comboObjects[0].Code2 = opener_obj.document.form.s_evi_tax_no.value.substring(6,12);
								document.form.tax_no3.value = opener_obj.document.form.s_evi_tax_no.value.substring(12,16);
						}else if(opener_obj.document.form.s_evi_tax_no.value.length==15){
								comboObjects[0].Code2 = opener_obj.document.form.s_evi_tax_no.value.substring(6,11);
								document.form.tax_no3.value = opener_obj.document.form.s_evi_tax_no.value.substring(11,16);
						}

						if(opener_obj.document.form.s_finance_flg.value == "Y"){
								document.form.finance_flg[0].checked=true;
								document.form.finance_flg[1].checked=false;
						}else if(opener_obj.document.form.s_finance_flg.value == "N"){
								document.form.finance_flg[1].checked=true;
								document.form.finance_flg[0].checked=false;
						}

						document.form.comp_no1.value = opener_obj.document.form.s_evi_comp_no.value.substring(0,3);
						document.form.comp_no2.value = opener_obj.document.form.s_evi_comp_no.value.substring(3,5);
						document.form.comp_no3.value = opener_obj.document.form.s_evi_comp_no.value.substring(5,10);
						//taxInfo();

						document.form.inv_dt.value = opener_obj.document.form.s_evi_inv_dt.value;
						document.form.net_amt.value = csr_addComma(opener_obj.document.form.s_evi_total_net_amt.value);
						//document.form.vat_amt.value = opener_obj.document.form.s_evi_total_tax_amt.value;

						for(var i=0;i<4;i++){
								if(eval("opener_obj.document.form.s_evi_ctnt"+(k+1)).value != "" || eval("opener_obj.document.form.s_evi_ctnt"+(k+2)).value != "" ){
										sheetObjects[0].DataInsert(-1);
										k++;
										sheetObjects[0].CellValue(i+1,3) = eval("opener_obj.document.form.s_evi_ctnt"+k).value;
										k++;
										sheetObjects[0].CellValue(i+1,4) = eval("opener_obj.document.form.s_evi_ctnt"+k).value;
										k++;

								}
						}
				}
		}

    function sheet1_OnChange(Row,Col,Value){
     		var net_amt  = 0;
     		var total_amt= 0;

     		//if(Col == 4 || Col == 5){
 				for(var i = 0;i<sheetObjects[0].RowCount;i++){
 					net_amt = parseFloat(sheetObjects[0].CellValue(i+1,4)*100)+parseFloat(csr_deleteComma(net_amt));
 				}
     		//}

        document.form.net_amt.value 			= csr_addComma(net_amt/100);
        document.form.total_amt.value 		= csr_addComma(net_amt/100);
    }

    function sheet2_OnSearchEnd(sheetObj,errMsg){
        if(errMsg!=null){
            showErrMessage(errMsg);
        }

        var tax_no3= sheetObj.EtcData("tax_no3");
        document.form.tax_no3.value 			= tax_no3;
    }

    function sheet1_OnSearchEnd(sheetObj,errMsg){
        if(errMsg!=null){
            showErrMessage(errMsg);
        }
        /*
		if(tax_no2_count==0){
				var wkplc_nmstring= sheetObj.EtcData("wkplc_nmstring");

				for(p=0;p< comboObjects.length;p++){
				  	initCombo (comboObjects[p],p+1, wkplc_nmstring);
				}
				tax_no2_count = comboObjects[0].GetCount();
		}

 		var vndr_nm 			= sheetObj.EtcData("vndr_nm");
 		var bzct_nm 			= sheetObj.EtcData("bzct_nm");
 		var bztp_nm 			= sheetObj.EtcData("bztp_nm");
 		var vndr_addr 		= sheetObj.EtcData("vndr_addr");
 		var ceo_nm 				= sheetObj.EtcData("ceo_nm");

        document.form.vndr_nm.value 			= vndr_nm;
        document.form.bzct_nm.value 			= bzct_nm;
        document.form.bztp_nm.value 			= bztp_nm;
        document.form.vndr_addr.value 		= vndr_addr;
        document.form.ceo_nm.value 				= ceo_nm;
         */
    }

    /**
     * Combo 기본 설정
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
  // combo object 초기화
     // combo object 초기화
     function initCombo(comboObj, comboNo) {
         var formObject = document.form
         switch(comboNo) {
         	case 1:
                 with (comboObj) {
      				MultiSelect = false;
      				UseAutoComplete = true;
      				SetColAlign("left|left");
      				SetColWidth("0|30");
       				DropHeight = 160;
       		    }
       			break;

         	case 2:
                 with (comboObj) {
      				MultiSelect = false;
      				UseAutoComplete = true;
      				SetColAlign("left|left");
      				SetColWidth("0|30");
       				DropHeight = 160;
       		    }
       			break;
         }
     }

    function tax_no2_OnChange(comObj,index,text)
    {
       document.form.tax_no2.value = comObj.Code;
        /**
       if(comObj.Code != "" || tax_no2_onchageFlg != "Y"){
	       document.form.f_cmd.value = COMMAND01;
	       doActionIBSheet1(sheetObjects[1], document.form, IBSEARCH);
       }
        **/
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj) {
    	sheetObjects[sheetCnt++] = sheet_obj;
    }

    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }

		function isNum(obj){
			//숫자만..
			if (!isNumber(obj)){
				obj.value = '';
			}
		}

		function isNum1(obj){
			//숫자만..
			if (!isNumDash(obj)){
				obj.value = '';
			}
		}

		function isDate1(obj){
			//숫자만..
			if (!isDate(obj)){
				obj.value = '';

				//showErrMessage("잘못된 날짜 입력입니다. 다시 입력하세요.");
			}
		}

		function setOpenerInsertData(){
				var opener_obj = window.dialogArguments;
				//var opener_obj = opener;
				var opener_sheet_obj =  opener_obj.document.sheet1;
				var k=0;
				//전자계산서/종이계산서 
				opener_obj.document.form.attr_ctnt8.value = getElementValue(document.form, 'checkbox', 'attr_ctnt8');
				opener_obj.document.form.s_evi_inv_dt.value = document.form.inv_dt.value;
				opener_obj.document.form.s_evi_comp_no.value = document.form.comp_no1.value+ document.form.comp_no2.value+ document.form.comp_no3.value;
				opener_obj.document.form.s_evi_total_net_amt.value = csr_deleteComma(document.form.net_amt.value);
				opener_obj.document.form.s_evi_tax_no2.value = comboObjects[0].Code;

				for(var i=0;i<sheetObjects[0].RowCount;i++){
						if((sheetObjects[0].CellValue(i+1,3)!="" && sheetObjects[0].CellValue(i+1,3)!=undefined) && (sheetObjects[0].CellValue(i+1,4) != "" && sheetObjects[0].CellValue(i+1,4)!=undefined)){
								k++;
								eval("opener_obj.document.form.s_evi_ctnt"+ k).value  = sheetObjects[0].CellValue(i+1,3);
								k++;
								eval("opener_obj.document.form.s_evi_ctnt"+ k).value  = sheetObjects[0].CellValue(i+1,4);
								k++;
								eval("opener_obj.document.form.s_evi_ctnt"+ k).value  = "";
						}else{
								k++;
								eval("opener_obj.document.form.s_evi_ctnt"+ k).value  = "";
								k++;
								eval("opener_obj.document.form.s_evi_ctnt"+ k).value  = "";
								k++;
								eval("opener_obj.document.form.s_evi_ctnt"+ k).value  = "";
						}
				}

				opener_obj.document.form.s_evi_tax_no.value = document.form.tax_no1.value+comboObjects[0].Code+document.form.tax_no3.value;
				opener_obj.document.form.s_eviInputFlg.value = "Y";

		}
		
		function getElementValue(formObject, eleTp, eleNm) {

			var element;
			var numOfEle = formObject.elements.length;
			for (var i = 0; i < numOfEle; i++){
				if (formObject.elements[i].type == eleTp && formObject.elements[i].name == eleNm){
					if (formObject.elements[i].checked == true){
						var ele_value = formObject.elements[i].value;
						break;
					}
				}
			}

			return ele_value;
		}

		function check_busino(vencod) {
				var sum = 0;
				var getlist =new Array(10);
				var chkvalue =new Array("1","3","7","1","3","7","1","3","5");
				for(var i=0; i<10; i++) { getlist[i] = vencod.substring(i, i+1); }
				for(var i=0; i<9; i++) { sum += getlist[i]*chkvalue[i]; }
				sum = sum + parseInt((getlist[8]*5)/10);
				sidliy = sum % 10;
				sidchk = 0;
				if(sidliy != 0) { sidchk = 10 - sidliy; }
				else { sidchk = 0; }
				if(sidchk != getlist[9]) { return false; }
				return true;
		}

		function taxInfo(){
			var formObject  = document.form;
			var saupjano1 = formObject.comp_no1.value+formObject.comp_no2.value + formObject.comp_no3.value;

			if(!check_busino(saupjano1)){
				/*
		    	formObject.vndr_nm.value  = "";
		    	formObject.bzct_nm.value  = "";
		    	formObject.bztp_nm.value  = "";
		    	formObject.vndr_addr.value  = "";
		    	formObject.ceo_nm.value  = "";
		    	*/
				showErrMessage(getMsg('CSR25010'));
				return false;
			}
			formObject.comp_no.value = saupjano1;

		    form.f_cmd.value = SEARCH01;
			sheetObjects[0].WaitImageVisible = false;
		    var sXml = sheetObjects[0].GetSearchXml("COM_CSR_0004GS.do" , FormQueryString(form));

		    //콤보코드와 콤보텍스트 가져오기[상호, 업태, 종목, 주소, VENDOR CODE, 대표자명]
		    
		    var vndr_nm   = ComGetEtcData(sXml,"vndr_nm");
		    var bzct_nm   = ComGetEtcData(sXml,"bzct_nm");
		    var bztp_nm   = ComGetEtcData(sXml,"bztp_nm");
		    var vndr_addr = ComGetEtcData(sXml,"vndr_addr");
		    var ceo_nm    = ComGetEtcData(sXml,"ceo_nm");
		    
		    if(vndr_nm == "null"){
		    	/*
		    	formObject.vndr_nm.value  = "";
		    	formObject.bzct_nm.value  = "";
		    	formObject.bztp_nm.value  = "";
		    	formObject.vndr_addr.value  = "";
		    	formObject.ceo_nm.value  = "";
			    */
		    }else{
		    	formObject.vndr_nm.value  = vndr_nm;
		    	formObject.bzct_nm.value  = bzct_nm;
		    	formObject.bztp_nm.value  = bztp_nm;
		    	formObject.vndr_addr.value  = vndr_addr;
		    	formObject.ceo_nm.value  = ceo_nm;
		    }
		}

		function checkInvDt(obj){
				if(obj.value.length!=10){
						return false;
				}
				var day_gab = getDaysToToday(obj);
				if(day_gab>365){
						showErrMessage(getMsg('CSR25028'));
						obj.value = "";
						obj.focus();
				}
		}

		function isDateCheck(obj){
				if(obj.value.length==10){
						if(!isDate(obj)){
								showErrMessage(getMsg('CSR25029'));
								document.form.inv_dt.focus();
								return false;
						}
				}
		}

		function validateDateObj2(obj){
			if (obj.readOnly==true){return false;}
			obj.value = obj.value.trim();
			if (obj.value==null || obj.value.trim()==''){return false;}
			if (!checkPeriodFormat2(obj.value) || !csr_isValidDateObject(obj.value,'-')){
				showErrMessage(getMsg('CSR23011')); //showErrMessage('날짜 형식이 잘못되었습니다.');
				obj.focus();
				return false;
			}
			return true;
		}

		function checkPeriodFormat2(prd_dt){
			var date_regexp = /(^\d{4}\-\d{2}\-\d{2}$)/;
			if (!csr_checkFormat2(prd_dt, date_regexp)){	return false;
			} else { return true;
			}
		}
		
		/** 하나만 값을 선택할수 있도록 **/
		function checkType(i){
			if(i == 0){
				document.form.attr_ctnt8[1].checked = false;
			}
			if(i == 1){
				document.form.attr_ctnt8[0].checked = false;
			}
		}
