// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;
var Radiocount = 0;

var comboObjects = new Array();
var comboCnt = 0 ;
var tax_no2_onchageFlg = ""; 
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
					
					if(formObject.h_type1.checked==false && formObject.h_type2.checked==false){
						ComShowMessage('전자계산서 혹은 종이계산서인지 선택하십시요.');		
						return false;			
					}
					
					if(ComIsNull(document.form.tax_no1.value)){
							ComShowMessage(ComGetMsg('TES24007','tax no.'));		
							return false;			
					}								
					if(tes_deleteComma(formObject.vat_amt_hdr.value) != tes_deleteComma(formObject.vat_amt.value)){
							ComShowMessage(ComGetMsg('TES25008'));
							return false;
					} 
					
					if(tes_deleteComma(formObject.total_amt_hdr.value) != tes_deleteComma(formObject.total_amt.value)){
							ComShowMessage(ComGetMsg('TES25009'));
							return false;
					}
					
					if(comboObjects[0].Code == ""){
							ComShowMessage(ComGetMsg('TES25010'));
							return false;
					}
					
					if(ComIsNull(ComGetObjValue(formObject.finance_flg))){
							ComShowMessage(ComGetMsg('TES25011'));		
							return false;			
					}
					
					if(tes_deleteComma(document.form.total_amt.value)>0){
							if(document.form.finance_flg[0].checked == false){
									ComShowMessage(ComGetMsg('TES25022'));
									return false;
							}
					}else if(tes_deleteComma(document.form.total_amt.value)<=0){
							if(document.form.finance_flg[1].checked == false){
									ComShowMessage(ComGetMsg('TES25023'));
									return false;
							}
					}
					if(tes_deleteComma(document.form.vat_amt.value)==0){
							if(document.form.tax_type[0].checked == false){
									ComShowMessage(ComGetMsg('TES25024'));
									return false;
							}
					}else if(tes_deleteComma(document.form.vat_amt.value)>0){		
							if(document.form.tax_type[1].checked == false){
									ComShowMessage(ComGetMsg('TES25025'));
									return false;
							}
					}
					if(ComIsNull(ComGetObjValue(formObject.tax_type))){
							ComShowMessage(ComGetMsg('TES25012'));		
							return false;
					}										
					
					var saupjano 	= formObject.comp_no1+formObject.comp_no2 + formObject.comp_no3;
					var saupjano1 	= formObject.comp_no1.value+formObject.comp_no2.value + formObject.comp_no3.value;						
					//ComShowMessage("1111"+isValidSaupja(saupjano));					
					/**
					if(!isValidSaupja(saupjano)){
							ComShowMessage("올바른 사업자 등록번호가 아닙니다. 다시 확인하세요.");		
							return false;			
					}
					**/
					
					if(!check_busino(saupjano1)){
							ComShowMessage(ComGetMsg('TES25013'));		
							return false;			
					}					
					
					if(sheetObjects[0].RowCount<1){
							ComShowMessage(ComGetMsg('TES25014'));
							return false;
					}
					
					if(sheetObjects[0].RowCount>0){
							for(var i=0;i<sheetObjects[0].RowCount;i++){
									if(sheetObjects[0].CellValue(i+1,3)==""){
											ComShowMessage(ComGetMsg('TES25026'));
											return false;
											break;
											return false;
									}
							}							
					}
					
					if(validateDateObj2(formObject.inv_dt)==false){
						ComShowMessage("발행일자를 입력해주세요..."); 
						return false;
					}
					
			       document.form.tax_no2.value = comboObjects[0].Code;
			       if(comboObjects[0].Code != ""){
				       document.form.f_cmd.value = SEARCH01; 
				       doActionIBSheet1(sheetObjects[1], document.form, IBSEARCH); 
			       }					
					
					document.form.f_cmd.value = SEARCH02; 
					doActionIBSheet1(sheetObjects[1], document.form, IBSEARCH);
					
					setOpenerInsertData();
					ComShowMessage(ComGetMsg('TES25015')); 
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
					formObject.tax_type[0].checked=false; 
					formObject.tax_type[1].checked=false;
					formObject.comp_no1.value="";
					formObject.comp_no2.value="";
					formObject.comp_no3.value="";
					formObject.inv_dt.value="";			
					sheetObjects[0].RemoveAll();					
					break;

				case "btng_add_k":
					if(ComIsNull(document.form.tax_no1.value)){
							ComShowMessage(ComGetMsg('TES24007','tax no.'));		
							return false;			
					}
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;

				case "btng_delete_k":
					var k = 0;
		    		var net_amt  = 0;
		     		var vat_amt  = 0;
		     		var total_amt= 0;						
				
			 	 	  for(var i=0;i<sheetObjects[0].RowCount;i++){ 	 	   		
			 	 				if(sheetObjects[0].CellValue(i+1,0)==1){
			 	 						sheetObjects[0].RowDelete(i+1, false);
			 	 						k++;
			 	 						i = i-k;
			 	 				}			 	 					
			 	 	  }
			 	 	  
		 				for(var i = 0;i<sheetObjects[0].RowCount;i++){
		 					net_amt = parseFloat(sheetObjects[0].CellValue(i+1,4)*100)+parseFloat((net_amt));
		 					vat_amt = parseFloat(sheetObjects[0].CellValue(i+1,5)*100)+parseFloat((vat_amt));
		 					total_amt = parseFloat(sheetObjects[0].CellValue(i+1,6)*100)+parseFloat((total_amt));     					
		 				}    		
		     		    		
		        document.form.net_amt.value 			= tes_addComma(net_amt/100);
		        document.form.vat_amt.value 			= tes_addComma(vat_amt/100);
		        document.form.total_amt.value 			= tes_addComma(total_amt/100); 			 	 	  					
					
					break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('TES21025'));
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
         
        for(p=0;p< comboObjects.length;p++){
            initCombo (comboObjects[p],p+1, '');
        }				
				
				ComEnableObject(document.form.vndr_seq_hdr, false);
				ComEnableObject(document.form.vat_amt_hdr, false); 
				ComEnableObject(document.form.total_amt_hdr, false);				
				//ComEnableObject(document.form.tax_no1); 
				ComEnableObject(document.form.tax_no3, false);
				ComEnableObject(document.form.volume, false);
				ComEnableObject(document.form.ho, false); 
				ComEnableObject(document.form.vndr_nm, false);
				ComEnableObject(document.form.bzct_nm, false);	
				ComEnableObject(document.form.vndr_addr, false);
				ComEnableObject(document.form.bzct_nm, false);	
				ComEnableObject(document.form.bztp_nm, false);	
				ComEnableObject(document.form.ceo_nm, false);
				ComEnableObject(document.form.vndr_seq, false);
				ComEnableObject(document.form.net_amt, false);
				ComEnableObject(document.form.vat_amt, false); 
				ComEnableObject(document.form.total_amt, false);	
				
				insertValue();					
				
				//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);			         
    }

	function validateDateObj(obj){//alert("start validateDateObj");
		obj.value = obj.value.trim();
		if (obj.value==null || obj.value.trim()==''){return false;}
		if (!checkPeriodFormat(obj.value) || !tes_isValidDateObject(obj.value.substring(0,4)+'-'+obj.value.substring(4,6)+'-01','-')){
			ComShowMessage(ComGetMsg('TES23011')); //ComShowMessage('날짜 형식이 잘못되었습니다.');
			obj.focus();
			return false;
		}
		return true;
	}

	function checkPeriodFormat(prd_dt){//alert("start checkPeriodFormat");
		var date_regexp = /(^\d{6}$)/;
		if (!tes_checkFormat2(prd_dt, date_regexp)){	return false;
		} else { return true;
		}
	}

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {//alert("start initSheet");

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
					 					InitColumnInfo(7, 1, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = " |STS|순번|품명|공급가액|세액|합계" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, 		DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
										InitDataProperty(0, cnt++ , dtCheckBox,   30,    	daCenter,  		false,  	"",     	false,          "",     dfNone,   		0,     	true,       true);
										InitDataProperty(0, cnt++ , dtHiddenStatus,     30,    	daCenter,  		false,    "",     	false,          "",     dfNone,   		0,     	false,      true);
										InitDataProperty(0, cnt++ , dtDataSeq,		30,			daCenter,			true,    	"",				false,					"",			dfNone,				0,			true,				true);
										InitDataProperty(0, cnt++ , dtData,				200,		daLeft,		    true,    	"",				false,					"",			dfNone,				0,			true,				true);
										InitDataProperty(0, cnt++ , dtData,				150,		daRight,			true,    	"",				false,					"",			dfInteger,			0,			true,				true);
										//InitDataProperty(0, cnt++ , dtData,				150,		daRight,			true,    	"",				false,	"Round(|4|*0.1,0)",			dfFloat,			2,			true,				true);
										InitDataProperty(0, cnt++ , dtData,				150,		daRight,			true,    	"",				false,					"",			dfInteger,			0,			true,				true);
										InitDataProperty(0, cnt++ , dtData,				100,		daRight,			true,    	"",				false,	 "|4|+|5|",			dfInteger,			0,			false,			false);																							
										
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
    function doActionIBSheet(sheetObj,formObj,sAction) {//alert("start doActionIBSheet");
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회
               	formObj.f_cmd.value = SEARCHLIST;                  
                sheetObj.DoSearch4Post("ESD_TES_0078GS.do", tesFrmQryStr(formObj));
                break; 
                
           case IBINSERT:      // 입력 
           			if(sheetObj.RowCount == 4){
           					ComShowMessage(ComGetMsg('TES25027'));
           			}else{
                		sheetObj.DataInsert();
                }
                break;

           case IBCOPYROW:        //행 복사
              sheetObj.DataCopy();
              break;
        }
    }
     
  // Sheet관련 프로세스 처리
    function doActionIBSheet1(sheetObj,formObj,sAction) {//alert("start doActionIBSheet1");
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회               	                 
                sheetObj.DoSearch4Post("ESD_TES_0078GS.do", tesFrmQryStr(formObj));
                break;
        }
    }     


   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!ComIsNumber(iPage)) {
//
//                return false;
//            }
        }

        return true;
    }


		function insertValue(){//alert("start insertValue");
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
						vat_amt		=	vat_amt+parseFloat(opener_sheet_obj.CellValue(checkRowArray[k], "vat_amt"));						
						total_amt	=	total_amt+parseFloat(opener_sheet_obj.CellValue(checkRowArray[k], "inv_total_amt"));						
				}
				document.form.vat_amt_hdr.value= tes_addComma(vat_amt);
				document.form.total_amt_hdr.value= tes_addComma(total_amt);				
				
				if(total_amt>0){
						document.form.finance_flg[0].checked = true;						
				}else if(total_amt<=0){
						document.form.finance_flg[1].checked = true;					
				}
				
				if(vat_amt==0){
						document.form.tax_type[0].checked = true;	
						document.form.tax_type[1].disabled = true;
						sheetObjects[0].InitDataProperty(0, 5 , dtData,				150,		daRight,			true,    	"",				false,					"",			dfInteger,			0,			false,				false);
				}else if(total_amt>0){											
						document.form.tax_type[1].checked = true;					
				}

				// 전자,종이 계산서 추가
				if(opener_obj.document.form.attr_ctnt8.value=="ELECTRONIC"){
					document.form.h_type1.checked=true;
				}else if(opener_obj.document.form.attr_ctnt8.value=="PAPER"){
					document.form.h_type2.checked=true;
				}				
				
		}
		
		function insertValueEvi(){//alert("start insertValueEvi");
				var opener_obj = window.dialogArguments;	
				//var opener_obj = opener;	
				var opener_sheet_obj =  opener_obj.document.sheet1;
				var k=0;	
				var total_amt = 0;		
				
				if(opener_obj.document.form.eviInputFlg.value=="Y"){								
						
						tax_no2_onchageFlg  = "Y";
						
						document.form.tax_no1.value = opener_obj.document.form.evi_tax_no.value.substring(0,6);
						if(opener_obj.document.form.evi_tax_no.value.length==16){
								comboObjects[0].Code2 = opener_obj.document.form.evi_tax_no.value.substring(6,12);
								document.form.tax_no3.value = opener_obj.document.form.evi_tax_no.value.substring(12,16);
						}else if(opener_obj.document.form.evi_tax_no.value.length==15){
								comboObjects[0].Code2 = opener_obj.document.form.evi_tax_no.value.substring(6,11);
								document.form.tax_no3.value = opener_obj.document.form.evi_tax_no.value.substring(11,16);							
						}							
									
						if(opener_obj.document.form.tax_naid_flg.value == "Y"){
								document.form.tax_naid_flg[0].checked=true;
								document.form.tax_naid_flg[1].checked=false;
						}else if(opener_obj.document.form.tax_naid_flg.value == "N"){
								document.form.tax_naid_flg[1].checked=true;
								document.form.tax_naid_flg[0].checked=false;
						}
						
						if(opener_obj.document.form.finance_flg.value == "Y"){
								document.form.finance_flg[0].checked=true;
								document.form.finance_flg[1].checked=false;
						}else if(opener_obj.document.form.finance_flg.value == "N"){
								document.form.finance_flg[1].checked=true;
								document.form.finance_flg[0].checked=false;
						}
						
						if(opener_obj.document.form.fa_flg.value == "Y"){
								document.form.fa_flg[0].checked=true;
								document.form.fa_flg[1].checked=false;
						}else if(opener_obj.document.form.fa_flg.value == "N"){
								document.form.fa_flg[1].checked=true;
								document.form.fa_flg[0].checked=false;
						}
						
						if(opener_obj.document.form.tax_type.value == "0"){
								document.form.tax_type[0].checked=true;
								document.form.tax_type[1].checked=false;
						}else if(opener_obj.document.form.tax_type.value == "10"){
								document.form.tax_type[1].checked=true;
								document.form.tax_type[0].checked=false;
						}
																								
						if(opener_obj.document.form.tax_nsl_flg.value == "Y"){
								document.form.tax_nsl_flg[0].checked=true;
								document.form.tax_nsl_flg[1].checked=false;
						}else if(opener_obj.document.form.tax_nsl_flg.value == "N"){
								document.form.tax_nsl_flg[1].checked=true;
								document.form.tax_nsl_flg[0].checked=false;
						}
						
						
						document.form.comp_no1.value = opener_obj.document.form.evi_comp_no.value.substring(0,3);
						document.form.comp_no2.value = opener_obj.document.form.evi_comp_no.value.substring(3,5);
						document.form.comp_no3.value = opener_obj.document.form.evi_comp_no.value.substring(5,10);
						taxInfo();						
						
						document.form.inv_dt.value = opener_obj.document.form.evi_inv_dt.value;						
						document.form.net_amt.value = tes_addComma(opener_obj.document.form.evi_total_net_amt.value);						
						document.form.vat_amt.value = tes_addComma(opener_obj.document.form.evi_total_tax_amt.value);							
						
						for(var i=0;i<4;i++){ 
								if(eval("opener_obj.document.form.evi_ctnt"+(k+1)).value != "" || eval("opener_obj.document.form.evi_ctnt"+(k+2)).value != "" || eval("opener_obj.document.form.evi_ctnt"+(k+3)).value != ""){
										sheetObjects[0].DataInsert(-1);
										k++;
										sheetObjects[0].CellValue2(i+1,3) = eval("opener_obj.document.form.evi_ctnt"+k).value;
										k++;
										sheetObjects[0].CellValue2(i+1,4) = eval("opener_obj.document.form.evi_ctnt"+k).value; 
										k++;
										sheetObjects[0].CellValue2(i+1,5) = eval("opener_obj.document.form.evi_ctnt"+k).value;
										
										total_amt = parseFloat(sheetObjects[0].CellValue(i+1,6)*100)+parseFloat(tes_deleteComma(total_amt));
								}
						}
						document.form.total_amt.value = tes_addComma(total_amt/100);			
				}
		}		
		/**
    function sheet1_OnChange(Row, Col,Value){//alert("start sheet1_OnChange");
     		var net_amt  = 0;
     		var vat_amt  = 0;
     		var total_amt= 0;

     		
				for(var i=0;i<sheetObjects[0].RowCount;i++){
						
				
				}
				
				if(Col==4){
						sheetObjects[0].CellValue(Row, 5) = parseFloat(sheetObjects[0].CellValue(i+1,4)*100)/10;
				}
     		
     		//if(Col == 4 || Col == 5){ 
 				for(var i = 0;i<sheetObjects[0].RowCount;i++){
 					net_amt = parseFloat(sheetObjects[0].CellValue(i+1,4)*100)+parseFloat(net_amt);
 					vat_amt = parseFloat(sheetObjects[0].CellValue(i+1,5)*100)+parseFloat(vat_amt);
 					total_amt = parseFloat(sheetObjects[0].CellValue(i+1,6)*100)+parseFloat(total_amt);     					
 				}
     		//} 
     		    		
        document.form.net_amt.value 			= net_amt/100;
        document.form.vat_amt.value 			= vat_amt/100;
        document.form.total_amt.value 			= total_amt/100;                   
    }	
    **/	
		
    function sheet1_OnSearchEnd(sheetObj,errMsg){//alert("start sheet1_OnSearchEnd");
        if(errMsg!=null){
            ComShowMessage(errMsg);
        }
       
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
 		var vndr_addr 			= sheetObj.EtcData("vndr_addr");
 		var ceo_nm 				= sheetObj.EtcData("ceo_nm");
 		var rgst_no				= sheetObj.EtcData("rgst_no");
 		var def_ofc				= sheetObj.EtcData("def_ofc");
 		
		 		         
        document.form.vndr_nm.value 			= vndr_nm;
        document.form.bzct_nm.value 			= bzct_nm;
        document.form.bztp_nm.value 			= bztp_nm; 
        document.form.vndr_addr.value 		    = vndr_addr; 
        document.form.ceo_nm.value 				= ceo_nm;
        comboObjects[0].Code = def_ofc;
        
        if(rgst_no!=""){
            document.form.comp_no1.value 			= rgst_no.substring(0,3); 
            document.form.comp_no2.value			= rgst_no.substring(3,5); 
            document.form.comp_no3.value 			= rgst_no.substring(5,10); 
        }

    }
     
    function sheet2_OnSearchEnd(sheetObj,errMsg){//alert("start sheet2_OnSearchEnd");
        if(errMsg!=null){
            ComShowMessage(errMsg);
        }        
        
        var gsFlg= sheetObj.EtcData("gsFlg");
        if(gsFlg=="COMMAND01"){		
	        var tax_no3= sheetObj.EtcData("tax_no3");	 	        		         
	        document.form.tax_no3.value 			= tax_no3;	         
	      }else if(gsFlg=="COMMAND02"){
	        var tax_code= sheetObj.EtcData("tax_code");	 	        		         
	        document.form.tax_code.value 			= tax_code;	
	      } 	       
    }     
        
    function initCombo (comboObj, comboNo, wkplc_nmstring){
        var cnt  = 0 ;
        var wkplcNmArray = wkplc_nmstring.split("|");	

         switch(comboNo){
            case 1:             
            	comboObj.RemoveAll();  
            	 
               with (comboObj){                	
			    	       SetColAlign("left");
			    	       SetColWidth("60");			    	       
// PUSBO 삭제 요청 			    	       
			    	       for(i=0 ;i<wkplcNmArray.length;i++){             
			    	    	   if(wkplcNmArray[i].trim() != "PUSBO"){
			    	    		   InsertItem(cnt++, wkplcNmArray[i], wkplcNmArray[i]);
			    	    	   }
			               } 			    	       
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
    
    function setComboObject(combo_obj){//alert("start setComboObject");
        comboObjects[comboCnt++] = combo_obj;
    }
     
		function getElementValue(formObject, eleTp, eleNm) {//alert("start getElementValue");
		
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
    
		function isNum(obj){
			//숫자만..
			if (!ComIsNumber(obj)){
				obj.value = '';
			}
		}
    
		function isNum1(obj){
			//숫자만..
			if (!ComIsNumber(obj, "-")){
				obj.value = '';
			}
		}		
		
		function isDate1(obj){
			//숫자만..
			if (!ComIsDate(obj)){
				obj.value = '';
 
				//ComShowMessage("잘못된 날짜 입력입니다. 다시 입력하세요.");
			}
		}		     	 
		
		function setOpenerInsertData(){//alert("start setOpenerInsertData");
				var opener_obj = window.dialogArguments;	
				//var opener_obj = opener;	
				var opener_sheet_obj =  opener_obj.document.sheet1;
				var k=0;				
				
				opener_obj.document.form.tax_naid_flg.value = getElementValue(document.form, 'radio', 'tax_naid_flg'); 
				opener_obj.document.form.finance_flg.value = getElementValue(document.form, 'radio', 'finance_flg'); 
				opener_obj.document.form.fa_flg.value = getElementValue(document.form, 'radio', 'fa_flg'); 
				opener_obj.document.form.tax_type.value = getElementValue(document.form, 'radio', 'tax_type');
				opener_obj.document.form.tax_nsl_flg.value = getElementValue(document.form, 'radio', 'tax_nsl_flg');				
				
				opener_obj.document.form.evi_inv_dt.value = document.form.inv_dt.value;
				opener_obj.document.form.evi_comp_no.value = document.form.comp_no1.value+ document.form.comp_no2.value+ document.form.comp_no3.value; 
				opener_obj.document.form.evi_total_net_amt.value = tes_deleteComma(document.form.net_amt.value);
				//opener_obj.document.form.evi_tax_no2.value = document.form.tax_no2.value;
				opener_obj.document.form.evi_tax_no2.value = comboObjects[0].Code;
				opener_obj.document.form.evi_total_tax_amt.value = tes_deleteComma(document.form.vat_amt.value);				
				
				for(var i=0;i<4;i++){
						if((sheetObjects[0].CellValue(i+1,3)!="" && sheetObjects[0].CellValue(i+1,3)!=undefined) && (sheetObjects[0].CellValue(i+1,4) != "" && sheetObjects[0].CellValue(i+1,4)!=undefined) && (sheetObjects[0].CellValue(i+1,5) !="" && sheetObjects[0].CellValue(i+1,4)!=undefined)){							
								k++;
								eval("opener_obj.document.form.evi_ctnt"+ k).value  = sheetObjects[0].CellValue(i+1,3);
								k++;
								eval("opener_obj.document.form.evi_ctnt"+ k).value  = sheetObjects[0].CellValue(i+1,4); 
								k++;
								eval("opener_obj.document.form.evi_ctnt"+ k).value  = sheetObjects[0].CellValue(i+1,5);					
						}else{							
								k++;
								eval("opener_obj.document.form.evi_ctnt"+ k).value  = "";
								k++;
								eval("opener_obj.document.form.evi_ctnt"+ k).value  = ""; 
								k++;
								eval("opener_obj.document.form.evi_ctnt"+ k).value  = "";
						}
				}
				
				opener_obj.document.form.evi_tax_no.value = document.form.tax_no1.value+comboObjects[0].Code+document.form.tax_no3.value;
				opener_obj.document.form.evi_tax_code.value = document.form.tax_code.value;
				opener_obj.document.form.eviInputFlg.value = "Y";			
				
				// 전자,종이 계산서 추가
				if(document.form.h_type1.checked==true){
					opener_obj.document.form.attr_ctnt8.value = document.form.h_type1.value;
				}else{
					opener_obj.document.form.attr_ctnt8.value = document.form.h_type2.value;
				}
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
						ComShowMessage(ComGetMsg('TES25010'));		
						return false;			
				}
				formObject.comp_no.value = saupjano1;
				
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);							
		}		
		
		function checkInvDt(obj){
				if(obj.value.length!=10){
					return false;
				}				

				var day_gab = ComGetDaysToToday(obj);
				if( day_gab<-31 || day_gab>365){
					ComShowMessage(ComGetMsg('TES25028'));
					obj.value = "";		
					obj.focus();
				}
		}		
    
		function isDateCheck(obj){
			if(obj.value.length==10){
				if(!ComIsDate(obj)){
					ComShowMessage(ComGetMsg('TES25029'));
					document.form.inv_dt.focus();
					return false;     			
				}
			}    
		}

		function validateDateObj2(obj){
			if (obj.readOnly==true){return false;}
			obj.value = obj.value.trim();
			if (obj.value==null || obj.value.trim()==''){return false;}
			if (!checkPeriodFormat2(obj.value) || !tes_isValidDateObject(obj.value,'-')){
				ComShowMessage(ComGetMsg('TES23011')); //ComShowMessage('날짜 형식이 잘못되었습니다.');
				obj.focus();
				return false;
			}
			return true;
		}

		function checkPeriodFormat2(prd_dt){
			var date_regexp = /(^\d{4}\-\d{2}\-\d{2}$)/;
			if (!tes_checkFormat2(prd_dt, date_regexp)){	return false;
			} else { return true;
			}
		}
		
		/** 1나만 값을 선택할수 있도록 **/
		function checkType(obj){
			if(obj.name=="h_type1"){
				document.form.h_type2.checked=false;
			}else{
				document.form.h_type1.checked=false;
			}
			
		}

