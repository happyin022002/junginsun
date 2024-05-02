/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0588.js
*@FileTitle : Special cargo summary information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.08.05 김기종
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
     * @class ESM_BKG_0588 : ESM_BKG_0588 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0588() {
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
    var combo1 = null;
    var comboCnt = 0;


 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
		var porCd = formObject.por_cd.value;
		var porYdCd = formObject.por_nod_cd.value;
		var polCd = formObject.pol_cd.value;
		var polYdCd = formObject.pol_nod_cd.value;
		var podCd = formObject.pod_cd.value;
		var podYdCd = formObject.pod_nod_cd.value;
		var delCd = formObject.del_cd.value;
		var delYdCd = formObject.del_nod_cd.value;
		var spcl_cgo_type = "";
		var bkg_no = "";
		var vsl_cd = "";
		var skd_voy_no = "";
		var skd_dir_cd = "";
		
		
     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
     			
             switch(srcName) {
 		        case "btn_retrieve":
 		        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 		        	break;
 		        case "btn_0083PorPop":
 	        		comBkgCallPop0083('callBack0083','POR',porCd,porYdCd);
 	        		break;    		
 	        	case "btn_0083PolPop":
 	        		comBkgCallPop0083('callBack0083','POL',polCd,polYdCd);
 	        		break;    		
 	        	case "btn_0083PodPop":
 	        		comBkgCallPop0083('callBack0083','POD',podCd,podYdCd);
 	        		break;    		
 	        	case "btn_0083DelPop":
 	        		comBkgCallPop0083('callBack0083','DEL',delCd,delYdCd);                    		
 					break; 
 					
 		        case "btn_new":
 		        	sheetObject1.RemoveAll();
 		        	ComResetAll();
 		        	break;
 		       case "btn_DownExcel":
					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
					break;
 		       case "btn_certiDown":
 		    	   alert(srcName);
 		    	   break;	
                case "btn_request":
                	alert(srcName);
                	break;
 		        case "btn_application":
 		        	if (CheckGrid(sheetObjects[0],"Check","")){ 
 		        		var checkRow = getCheckedRow(sheetObjects[0],"Check");
 		        		
 		        		bkg_no = sheetObjects[0].CellValue(checkRow, "bkg_no");
 		        		spcl_cgo_type = sheetObjects[0].CellValue(checkRow, "spcl_cgo_type");
 		        		
 		        		if (spcl_cgo_type == ""){
 		        			ComShowCodeConfirm("BKG06012","Special Cargo Type");
 		        			return;
 		        		}
 		        		comBkgCallPopSpclAppication(spcl_cgo_type,bkg_no);
						break;
 					}	
 		        	break;
                case "btn_approval":
                	if (CheckGrid(sheetObjects[0],"Check","")){ 
                		var checkRow = getCheckedRow(sheetObjects[0],"Check");
                		bkg_no = sheetObjects[0].CellValue(checkRow, "bkg_no");
		 		        		spcl_cgo_type = sheetObjects[0].CellValue(checkRow, "spcl_cgo_type");
		 		        		
		 		        		vsl_cd = sheetObjects[0].CellValue(checkRow, "vsl_cd");
		 		        		skd_voy_no = sheetObjects[0].CellValue(checkRow, "skd_voy_no");
		 		        		skd_dir_cd = sheetObjects[0].CellValue(checkRow, "skd_dir_cd");
		 		       		
		 		        		if (spcl_cgo_type == ""){
		 		        			ComShowCodeConfirm("BKG06012","Special Cargo Type");
		 		        			return;
		 		        		}
		 		        		comBkgCallPopSpclAppResult(spcl_cgo_type,bkg_no,vsl_cd,skd_voy_no,skd_dir_cd);
										break;
				 					}
				 						
                	break;
                case "btn_print":
                	alert(srcName);
                	break;  
                case "btn_printfor":
                	goPrint();
                	break;
                case "btn_close":
                	window.close();
                	break;                           

             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111");
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

     function setComboObject(combo_obj){
       	comboObjects[comboCnt++] = combo_obj;
     }

    /*
	* RD 프린터 함수
	* @param string : 없음
	* @author 김경섭
	* @version 2009.09.14
	*/
    
    function goPrint()
 	{		
 		var sheetObj= sheetObjects[0];
 		var formObj = document.form;
 		var rdPath  = "apps/alps/esm/bkg/bookingreport/specialreport/report/ESM_BKG_5019.mrd";
 		var where   = "";
 		var param   = new Array("vvd_cd", "pol_cd", "pol_nod_cd", "chk_l_type", "chk_t_type", "zone_code", "spcl_cgo_type", "pod_cd", "pod_nod_cd", "por_cd", "por_nod_cd", "del_cd", "del_nod_cd", "bkg_ofc_cd", "ob_srep_cd", "bkg_staff_type", "bkg_staff", "bkg_sts_cd", "spcl_cgo_apro_cd");
 		if(!validateForm(sheetObj,formObj,IBSEARCH)) return;
 		if (sheetObj.RowCount < 1) {
			ComShowCodeMessage("BKG00495");
			return;
		}
 		//where  = "PERIOD_TYPE[]" + "FROM_DT[]" + "TO_DT[]" + "OFC_CD[]"+"STATUS_CD[]"+"PERIOD[]";
 		
 		where  = getParam(param);
 		
 		if((formObj.chk_l_type.checked == true && formObj.chk_t_type.checked == true) || (formObj.chk_l_type.checked == false && formObj.chk_t_type.checked == false)){
 			where += "cargo_type[ALL] "
 		}if(formObj.chk_l_type.checked == true ){
 			where += "cargo_type[L] "
 		}if(formObj.chk_t_type.checked == true ){
 			where += "cargo_type[T] "
 		} 
 		
		if(sheetObj.CheckedRows("Check") > 0 ){
 			var checkedRows = sheetObj.FindCheckedRow("Check");
			var arrRow = checkedRows.split("|");
			var selectRow = arrRow[0];
			where += "bkg_no["+sheetObj.CellValue(selectRow, "bkg_no")+"] ";
		}else{
			where += "bkg_no[] ";
		}
 		formObj.com_mrdPath.value 		= rdPath;
 		//alert(where);
 		//debug.innerHTML = where;
 		formObj.com_mrdArguments.value 	= "/rv "  + where + " /riprnmargin /rwait";
 		formObj.com_mrdTitle.value = "Special cargo summary";
 		formObj.com_mrdDisableToolbar.value = "";
		formObj.com_mrdBodyTitle.value = "<span style=&quot;color:red&quot;>Special cargo summary</span>";
		ComOpenRDPopup();
 	}

    /*
	* RD 프린터 넘겨주는 파라미터 가져오는 함수
	* @param string : 넘겨줄 Param Name
	* @return string : RD로 넘겨줄 RV방식의 PARAM 
	* @author 김기종
	* @version 2009.09.14
	*/
    function getParam(param){
    	var formObj = document.form;
    	var rParam = "";
    	for(i=0;i<param.length;i++){
    		rParam += param[i]+"["+ComTrim(ComGetObjValue(eval("document.form."+param[i]))) + "] ";
    	}
    	return rParam;
    }	
     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {

         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         } 
         initControl();
         //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
     /**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * 
      * @param {ibsheet}
      *            sheetObj IBSheet Object
      * @param {int}
      *            sheetNo sheetObjects 배열에서 순번
      */
     function initControl() {
     	//** Date 구분자 **/
     	DATE_SEPARATOR = "-";
     	
     	var formObject = document.form;
     	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
     	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
     	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
     	
     	combo1 = comboObjects[0];
 		comboCnt = comboObjects.length;

 		// IBMultiCombo초기화
 	    for(var k=0; k<comboObjects.length; k++){
 	        initCombo(comboObjects[k]);
 	    }
     	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
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
 				case "sheet1":      //sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 385;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msAll;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 3, 100);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     var HeadTitle1 = "||No.|SP|Booking number|ST|Seq.|Seq.|Appr|UM|A.POD|T/S|F.DEL|Container number|TP|Cargo\nWeight(KGS)|DG\nCLS|UN No|Temp(c)|Vent|AK-Over Dimension / BB-Cargo Dimension \nDG-Sub Label|Stow|DG Approval Reference No.|||";
                     var HeadTitle2 = "||No.|SP|Booking number|ST|CNT|CGO|Appr|UM|A.POD|T/S|F.DEL|Container number|TP|Cargo\nWeight(KGS)|DG\nCLS|UN No|Temp(c)|Vent|AK-Over Dimension / BB-Cargo Dimension \nDG-Sub Label|Stow|DG Approval Reference No.|||"; 
                     
                     var headCount = ComCountHeadTitle(HeadTitle1);
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);
                     
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     SetMergeCell(0,1,2,1);
                     SetMergeCell(0,2,2,1);
                     SetMergeCell(0,3,2,1);
                     SetMergeCell(0,4,2,1);
                     SetMergeCell(0,5,2,1);
                     SetMergeCell(0,6,1,1);
                     SetMergeCell(0,8,2,1);
                     SetMergeCell(0,9,2,1);
                     SetMergeCell(0,10,2,1);
                     SetMergeCell(0,11,2,1);
                     SetMergeCell(0,12,2,1);
                     SetMergeCell(0,13,2,1);
                     SetMergeCell(0,14,2,1);
                     SetMergeCell(0,15,2,1);
                     SetMergeCell(0,16,2,1);
                     SetMergeCell(0,17,2,1);
                     SetMergeCell(0,18,2,1);
                     SetMergeCell(0,19,2,1);
                     SetMergeCell(0,20,2,1);
                     SetMergeCell(0,21,2,1);
                     SetMergeCell(0,22,2,1);

                     //데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 40,   daCenter,  true,   "HidStatus");
                     InitDataProperty(0, cnt++ , dtRadioCheck,	 40,   daCenter,  false,  "Check",			false,			"",		 dfNone,   0,     true,        true);
                     InitDataProperty(0, cnt++ , dtData,      	 40,   daCenter,  false,  "no");       
                     InitDataProperty(0, cnt++ , dtData,   		 40,   daCenter,  false,  "spcl_cgo_type",  false,          "",      dfNone,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtData,       	 100,  daCenter,  true,   "bkg_no",  	 	false,          "",      dfNone,   0,     false,       true);
                     
                     InitDataProperty(0, cnt++ , dtData,       	 35,   daCenter,  false,  "bkg_sts_cd",     false,          "",      dfNone,   0,     false,       true);
                                                               	                   
                     InitDataProperty(0, cnt++ , dtData,       	 30,   daCenter,  false,  "spcl_cntr_seq",  false,          "",      dfNone,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtData,       	 30,   daCenter,  false,  "spcl_cgo_seq",   false,          "",      dfNone,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtData,       	 40,   daCenter,  false,  "auth_result_t",  false,          "",      dfNone,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtData,       	 40,   daCenter,  false,  "um",       	 	false,          "",      dfNone,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtData,       	 50,   daCenter,  false,  "pod_cd",     	false,          "",      dfNone,   0,     false,       true);
                                                                                    
                     InitDataProperty(0, cnt++ , dtData,       	 40,   daCenter,  false,  "ts",       	 	false,          "",      dfNone,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtData,       	 50,   daCenter,  false,  "del_cd",     	false,          "",      dfNone,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtData,       	 120,  daCenter,  false,  "cntr_no",	 	false,          "",      dfNone,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtData,       	 40,   daCenter,  false,  "tp_sz",       	false,          "",      dfNone,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtData,       	 90,   daRight,   false,  "wgt",    	 	false,          "",      dfNone,   0,     false,       true);
                                                                                    
                     InitDataProperty(0, cnt++ , dtData,       	 40,   daCenter,  false,  "dg_class",    	false,          "",      dfNone,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtData,       	 40,   daCenter,  false,  "un_no",     	 	false,          "",      dfNone,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtData,       	 60,   daCenter,  false,  "cdo_temp",     	false,          "",      dfNone,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtData,       	 40,   daCenter,  false,  "vent",     	 	false,          "",      dfNone,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtData,       	 280,  daLeft,	  false,  "over_size",   	false,          "",      dfNone,   0,     false,       true);
                                                                                    
                     InitDataProperty(0, cnt++ , dtData,       	 50,   daCenter,  false,  "stow",     	 	false,          "",      dfNone,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtData,       	 150,  daCenter,  false,  "dg_appr_ref",   	false,          "",      dfNone,   0,     false,       true);
                     
                     InitDataProperty(0, cnt++ , dtHidden,       150,  daCenter,  false,  "vsl_cd",   		false,          "",      dfNone,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtHidden,       150,  daCenter,  false,  "skd_voy_no",   	false,          "",      dfNone,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtHidden,       150,  daCenter,  false,  "skd_dir_cd",   	false,          "",      dfNone,   0,     false,       true);

                     CountPosition = 0;
                     FrozenCols = 6;

                }
                 break;


         }
     }

     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
	         case IBCLEAR: // 화면 로딩시 코드 조회
					formObj.f_cmd.value = INIT;
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0588GS.do", FormQueryString(formObj));
					
					var arrXml = sXml.split("|$$|");
					
					
					if (arrXml.length > 1) 
						ComXml2ComboItem(arrXml[1], formObj.bkg_sts_cd, "val", "name");
					if (arrXml.length > 0) 
						ComXml2ComboItem(arrXml[0], formObj.zone_code, "val", "desc");
					
					formObj.bkg_sts_cd.Index =0; 
					formObj.zone_code.Index =0; 

					break;
					
	         case IBSEARCH:      //조회
	     	   	if(validateForm(sheetObj,formObj,sAction)){
		        	  formObj.f_cmd.value = SEARCH;
		 	          	  sheetObj.DoSearch("ESM_BKG_0588GS.do", FormQueryString(formObj)
								+ "&" + ComGetPrefixParam(""));
		          	} 
	             break;
			  
	         case IBDOWNEXCEL:      // 다운로드
	  				sheetObj.SpeedDown2Excel(-1);
	  				break;		    
         }
     }

     /**
      * 콤보 초기설정값
      * @param {IBMultiCombo} comboObj  comboObj
      */
      function initCombo(comboObj) {
      	comboObj.DropHeight = 150;
      	
      }  
      /**
       * 화면 폼입력값에 대한 유효성검증 프로세스 처리
       */
      function validateForm(sheetObj,formObj,sAction){
     	 with(formObj){
          	switch(sAction) {
 		     	case IBSEARCH: // 조회시 확인
 			  		if (!ComChkValid(formObj)) return false;
 			  		break;
          	}	
          }		
          return true;
      }
      
     
      /**
       * Node Search 팝업에서 전달받은 값 저장 <br>
       * <br><b>Example :</b>
       * <pre>
       *     callBack0083(locTp, rArray);
       * </pre>
       * @param Popup에서 전달받은 값
       * @return 없음
       * @version 2009.05.14
       */
      function callBack0083(locTp, rArray){    	
      	var formObj = document.form;
      	if(rArray != null){
  	    	if(locTp == "POR"){
  	    		formObj.por_cd.value = rArray[0][4].substring(0,5);
  	    		formObj.por_nod_cd.value = rArray[0][4].substring(5,7);
  	    	}else if(locTp == "POL"){
  	    		formObj.pol_cd.value = rArray[0][4].substring(0,5);
  	    		formObj.pol_nod_cd.value = rArray[0][4].substring(5,7);
  	    	}else if(locTp == "POD"){
  	    		formObj.pod_cd.value = rArray[0][4].substring(0,5);
  	    		formObj.pod_nod_cd.value = rArray[0][4].substring(5,7);
  	    	}else{
  	    		formObj.del_cd.value = rArray[0][4].substring(0,5);
  	    		formObj.del_nod_cd.value = rArray[0][4].substring(5,7);	
  	    	}	    	
      	}
      }          

      function CheckGrid(sheetObject,colName,prefix){
  		var iCheckRow = sheetObject.FindCheckedRow(prefix + colName); 
  		if (iCheckRow== "") {
  			ComShowCodeMessage('BKG00249');
  			return false;
  		}
  		return true;
	  }	
	      
	  function getCheckedRow(sheetObj,colName) {
  		var checkRow;
  		for(var iRow = 0; iRow < sheetObj.Rows; iRow++) {
  			if(sheetObj.CellValue(iRow, colName) == 1) {					
  	  			return iRow;
       		}
    	}
  	  }

	  function sheet1_OnSort(sheetObj) {
		  setSeqNo(sheetObj);
	  }
	  function sheet1_OnSearchEnd(sheetObj) {
		  setSeqNo(sheetObj);
          with (sheetObj) {
	      	  ColFontUnderline("bkg_no") = true;
	          ColFontColor("bkg_no") = RgbColor(0,0,255);
          }
	  }
	  function setSeqNo(sheetObj) {
		  for (var i=2; i<sheetObj.RowCount+2; i++) {
			  sheetObj.CellValue2(i,"no") = i-1;
		  }
	  }

	function sheet1_OnClick(sheetObj, row, col) {
		if ("bkg_no"==sheetObj.ColSaveName(col)) {
			comBkgCallPopBkgDetail(sheetObj.CellValue(row, "bkg_no"));   
		}
	}
/* 개발자 작업  끝 */