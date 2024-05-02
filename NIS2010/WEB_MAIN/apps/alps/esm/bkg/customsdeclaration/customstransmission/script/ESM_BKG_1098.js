/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1098.js
*@FileTitle : Equalization Port 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.06.03 김기종
* 1.0 Creation
* 2010.06.09 채창호 CHM-201111494-01: Vessel stow plan alert setup 화면 보완
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
     * @class esm_bkg_1098 : esm_bkg_1098 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1098(){
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

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1; 

    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    		         var sheetObject = sheetObjects[0];
             /*******************************************************/
             var formObject = document.form;

        	try{
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName){
					case "btn_retrieve":
						doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
					
					case "btn_save":
						doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
					break;
					
					case "btn_downexcel":
						sheetObject.SpeedDown2Excel(-1);
					break;			
					
					case "btn_add":
						doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
					break;
					
					case "btn_del":
						doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
					break;
                }// end switch
        	}catch(e){
        		if(e == "[object Error]"){
        			ComShowMessage(OBJECT_ERROR);
        		}else{
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
        function loadPage(){
			for(i=0;i<sheetObjects.length;i++){
				ComConfigSheet(sheetObjects[i] );
				initSheet(sheetObjects[i],i+1);
				ComEndConfigSheet(sheetObjects[i]);
			}
			initControl();
			
	 		//화면에서 필요한 이벤트
	     	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
	     	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	    	
	    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	}


        /**
         * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
         *{@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
         * 
         * @param{ibsheet}
         *            sheetObj IBSheet Object
         * @param{int}
         *            sheetNo sheetObjects 배열에서 순번
         */
        function initControl(){
        	var formObject = document.form;
        	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
        	axon_event.addListenerFormat('keypress',  'obj_KeyPress',    formObject); //- 키보드 입력할때
        	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

        	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
        	//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
        
        /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo){
            var cnt = 0;
            switch(sheetNo){
                case 1:      //sheet1 init
                    with(sheetObj){
                        // 높이 설정
                        style.height = 400;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if(location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msPrevColumnMerge;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 2, 100);
                        
                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, true, true, false, false);

                        var HeadTitle1 = "|Sel.|Seq|User ID|User Email|User Name|Office|LANE|Last F. Port|Notice will be sent at|Notice will be sent at|Hidden User Email|Hodden LANE|Hidden Last F. Port";
						var headCount = ComCountHeadTitle(HeadTitle1);
						//alert(headCount);
						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                    	
                        //데이터속성	[ROW, COL,  DATATYPE,   	WIDTH,	DATAALIGN,	COLMERGE, SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus,	0,	daCenter,	true,	"ibflag");
 						//Sel.
						InitDataProperty(0,	cnt++,	dtCheckBox,		50, daCenter,	false,	"del_chk", 				false,	"",	dfNone,		0,	true,	true);                    
 						//Seq
						InitDataProperty(0, cnt++ , dtSeq,			40,	daCenter,	true,	"seq",					false,	"",	dfNone,		0,	true,	true);
						//User ID
						InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"eml_snd_usr_id",		false,	"",	dfNone,		0,	true,	true,		10);
						//User email
						InitDataProperty(0, cnt++ , dtData,			200,daCenter,	true,	"rcvr_eml",				true,	"",	dfNone,		0,	true,	true);
						//User Name
						InitDataProperty(0, cnt++ , dtData,			130,daCenter,	true,	"usr_nm",				false,	"",	dfNone,		0,	false,	false);
						//Office
						InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"ofc_cd",				false,	"",	dfNone,		0,	false,	false);
						//Lane
						InitDataProperty(0, cnt++ , dtData,			60,	daCenter,	true,	"slan_cd",				true,	"",	dfNone,		100,true,	true,	3);
						//Last F. Port
						InitDataProperty(0, cnt++ , dtData,			90,	daCenter,	true,	"lst_port_cd",			true,	"",	dfNone,		0,	true,	true,	5);
						//Notice will be sent at
						InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	false,	"etd",					false,	"",	dfNone,		0,	false,	false,	3);				
						//Notice will be sent at
						InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	true,	"eml_snd_hrs",			true,	"",	dfInteger,	0,	true,	true,	3);				
						//Hidden User email
						InitDataProperty(0, cnt++ , dtHidden,		150,daCenter,	true,	"hidden_rcvr_eml",		false,	"",	dfNone,		0,	false,	true);
						//Hidden Lane
						InitDataProperty(0, cnt++ , dtHidden,		100,daCenter,	true,	"hidden_slan_cd",		false,	"",	dfNone,		100,false,	true,	3);
						//Hidden Last F. Port
						InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	true,	"hidden_lst_port_cd",	false,	"",	dfNone,		0,	false,	true,	5);
						
						SelectionMode = smSelectionList;
						SelectHighLight = false;
						//CountPosition = 0;
						
						InitDataValid(0, "slan_cd", vtEngUpOther ,"1234567890");
						InitDataValid(0, "lst_port_cd", vtEngUpOnly);
                   }
                    break;

            }
        }
        /**
		 * IBSheet의 콤보 컬럼에 데이터를 setting한다. <br>
		 * <b>Example :</b>
		 * <pre>
		 * setIBMultiCombo(sheetObj,sXml,"rcv_de_term_cd",false,1);
		 * </pre>
		 * 
		 * @param{string}sheetObj 필수
		 * @param{string}sXml 필수, Combo에 채울 데이터(IBSheet를 통해 받아온 xml 문자열.)
		 * @param{string}title 필수, Combo field명(IBSheet SaveName).
		
		 */
		function setIBMultiCombo(sheetObj, sXml, title){
			var arrData = ComBkgXml2SheetMultiComboString(sXml, "vsl_slan_cd", "vsl_slan_cd|vsl_slan_nm");
			
			//sheetObj.InitDataCombo(0,title, arrData[1], arrData[0],dText, dCode, showCol);
			sheetObj.InitDataCombo(0,"slan_cd_disp", arrData[1], arrData[0],"","0");		
			sheetObj.InitComboNoMatchText(true, " ");
			sheetObj.InitDataValid(0, "loc_cd", vtEngUpOnly);
			sheetObj.InitDataValid(0, "eqlz_port_cd", vtEngUpOnly);

		}

		/**
		 * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
		 * IBSheet의 Combo에 연결할수 있는 문자열형태로 반환한다.(&quot;|&quot;로 연결된 문자열)<br>
		 * Return되는 배열의 0번째는 Code문자열, 1번째는 Text문자열이 담겨있다.
		 * <b>Example :</b>
		 * 
		 * <pre>
		 * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
		 * var arrData = ComBkgXml2SheetMultiComboString(xmlStr, &quot;cd&quot;, &quot;nm&quot;);
		 * 
		 * </pre>
		 * 
		 * @param{string}xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
		 * @param{string}codeCol 필수, Combo의 Code컬럼명.
		 * @param{string}textCol 필수, Combo의 Text컬럼명.
		 * @return array   Code연결 문자열과 Text연결 문자열이 담긴 배열.
		 */
		function ComBkgXml2SheetMultiComboString(xmlStr, codeCol, textCol){
			var rtnArr = new Array();
			
			if(xmlStr == null || xmlStr == ""){
				return;
			}
			if(codeCol == null || codeCol == "" || textCol == null || textCol == ""){
				return;
			}
		
			try{
				var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
				xmlDoc.loadXML(xmlStr);
		
				var xmlRoot = xmlDoc.documentElement;
				if(xmlRoot == null){
					return;
				}
		
				var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
				if(dataNode == null || dataNode.attributes.length < 3){
					return;
				}
		
				var col = dataNode.getAttribute("COLORDER");
				var colArr = col.split("|");
				var sep = dataNode.getAttribute("COLSEPARATOR");
				var total = dataNode.getAttribute("TOTAL");
		
				var dataChildNodes = dataNode.childNodes;
				if(dataChildNodes == null){
					return;
				}
				
				var colListIdx = Array();
				var arrText = textCol.split("|");
				for(var i = 0; i < colArr.length; i++){
					if(colArr[i] == codeCol){
						colListIdx[0] = i;
					}
					for(var j = 0; j < arrText.length; j++){
						if(colArr[i] == arrText[j]){
							colListIdx[j+1] = i;
						}
					}
				}
				
				var sCode = "";
				var sText = "";
				for(var i = 0; i < dataChildNodes.length; i++){
					if(dataChildNodes[i].nodeType != 1){
						continue;
					}
					var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
					
					sCode += arrData[colListIdx[0]];
					
					for(var j = 1; j < colListIdx.length; j++){
						sText += arrData[colListIdx[j]];
						if(j < colListIdx.length - 1){
							sText += "\t";
						}
					}
					if(i != dataChildNodes.length - 1){
						sCode += "|";
						sText += "|";
					}
				}
				rtnArr.push(sCode);
				rtnArr.push(sText);
			}catch(err){
				ComFuncErrMsg(err.message);
			}
		
			return rtnArr;
		}
        
		
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction, Row){
            sheetObj.ShowDebugMsg = false;
            switch(sAction){
	            case IBCLEAR: // 화면 로딩시 코드 조회
					formObj.f_cmd.value = SEARCHLIST10;
					var param = FormQueryString(formObj);
					param = param + "&comboCd=MDM0001";
					var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
					
					var arrXml = sXml.split("|$$|");
					/*
					vsl_slan_cd 
					vsl_slan_nm
					skd_dir_cd
					*/
					if(arrXml.length > 0) 
						//setIBMultiCombo(sheetObj,  arrXml[0], "vsl_slan_cd" );
					break;	
	           case IBSEARCH:      //조회
		          if(validateForm(sheetObj,formObj,sAction)){
		        	  formObj.f_cmd.value = SEARCH;
		        	  sheetObj.WaitImageVisible = false;
		        	  ComOpenWait(true);
		        	  sheetObj.DoSearch("ESM_BKG_1098GS.do", FormQueryString(formObj)
								+ "&" + ComGetPrefixParam(""));
		        	  
		        	  ComOpenWait(false);
		          }	
	               	break;
	           case SEARCH01:      //조회
		          if(validateForm(sheetObj,formObj,sAction)){
		        	  formObj.f_cmd.value = SEARCH01;
		        	  sheetObj.WaitImageVisible = false;
		        	  ComOpenWait(true);
		        	  var sXml = sheetObj.GetSaveXml("ESM_BKG_1098GS.do", FormQueryString(formObj));
		        	  var valResult = ComGetEtcData(sXml, "port_cd");
		        	  if(valResult == '' || valResult == 'INVALID'){
						  ComShowCodeMessage('BKG00068', 'Last F. Port');
						  sheetObj.CellValue2(sheetObj.RowCount, "lst_port_cd") = '';
					  }
		        	  ComOpenWait(false);
		          }	
	               	break;
	           case SEARCH02:      //조회
		          if(validateForm(sheetObj,formObj,sAction)){
		        	  formObj.f_cmd.value = SEARCH02;
		        	  sheetObj.WaitImageVisible = false;
		        	  ComOpenWait(true);
		        	  var sXml = sheetObj.GetSaveXml("ESM_BKG_1098GS.do", FormQueryString(formObj));
		        	  var valResult = ComGetEtcData(sXml, "slan_cd");
		        	  if(valResult == '' || valResult == 'INVALID'){
						  ComShowCodeMessage('BKG00068', 'LANE');
						  sheetObj.CellValue2(sheetObj.RowCount, "slan_cd") = '';
					  }
		        	  ComOpenWait(false);
		          }	
	               	break;
	           case SEARCH03:      //조회
		          if(validateForm(sheetObj,formObj,sAction)){
		        	  formObj.f_cmd.value = SEARCH03;
		        	  sheetObj.WaitImageVisible = false;
		        	  ComOpenWait(true);
		        	  var sXml = sheetObj.GetSaveXml("ESM_BKG_1098GS.do", FormQueryString(formObj));
		        	  var rcvr_eml = ComGetEtcData(sXml, "rcvr_eml");
		        	  var usr_nm = ComGetEtcData(sXml, "usr_nm");
		        	  var ofc_cd = ComGetEtcData(sXml, "ofc_cd");
		        	  //if(ofc_cd == '' || valResult == 'INVALID')  ComShowCodeMessage('BKG00068', 'User Info');
		        	  sheetObj.CellValue2(Row, "rcvr_eml") = rcvr_eml;
		        	  sheetObj.CellValue2(Row, "usr_nm") = usr_nm;
		        	  sheetObj.CellValue2(Row, "ofc_cd") = ofc_cd;
		        	  ComOpenWait(false);
		          }	
	               	break;
	           case IBSAVE:        //저장
					formObj.f_cmd.value = MULTI;
					var saveParam = ComGetSaveString(sheetObjects[0]);
					//alert(sheetObj.GetSaveString() + " : " + saveParam + " : " + sheetObjects[0].CellValue(2,3));
					if(sheetObj.isDataModified == false || saveParam == ""){
						ComShowCodeMessage('BKG00260');
						return;
					}
										
					//중복 확인 하는 부분 : rcvr_eml, slan_cd, lst_port_cd
					var dup = new Array();
					for(var i = 1; i <= sheetObjects[0].RowCount; i++){
						dup[i] = sheetObjects[0].CellValue(i, "rcvr_eml")+sheetObjects[0].CellValue(i, "slan_cd")+sheetObjects[0].CellValue(i, "lst_port_cd");
					}

					for(var i=1; i<=dup.length; i++){
						for(var j=1; j<=dup.length; j++){
							if((i < j) &&(i != j) &&(dup[i] == dup[j])){
								ComShowCodeMessage("BKG01126");
								return;
							}
						}
					}
					
					saveParam += "&" + FormQueryString(formObj);
					var SaveXml = sheetObj.GetSaveXml("ESM_BKG_1098GS.do", saveParam);
					
					sheetObjects[0].LoadSaveXml(SaveXml);
	                    
					break;
				case IBINSERT:      // 입력
					//신규행 추가
	 				sheetObj.DataInsert(-1);
					sheetObj.CellValue2(sheetObj.RowCount, "etd") = "ETD + ";
					break;
				case IBDELETE:      // 삭제
					//행 삭제 FLAG처리
					//sheetObj.CellValue2(sheetObj.SelectRow, "ibflag") = "D";
					//ComRowHideDelete(sheetObj, "del_chk");
				
					if(!validateForm(sheetObj, formObj, sAction))	return;
					
					if(ComShowCodeConfirm('BKG03037')){
						ComRowHideDelete(sheetObj, "del_chk");
	                	sheetObj.CheckAll2("del_chk") = 0;
					}
					break;	
            }
        }

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	switch(sAction){
	            case IBSEARCH: // 조회시 확인
	         		if(!ComChkValid(formObj)) return false;
	         		break;
	            case IBSAVE: // 저장시 확인
         		//if(!ComChkValid(formObj)) return false;
         		break;

				case IBDELETE : // Row Delete
					var sheet1RowCnt = sheetObj.RowCount;
				    var selCnt = 0;
				
					if(sheet1RowCnt == 0){
						ComShowCodeMessage('BKG00389');
						return false;
					}
	
					for(var i=1; i<=sheet1RowCnt; i++){
						
						if(sheetObj.CellValue(i, "del_chk") == 1){
							selCnt++;
						}
						
						if(selCnt > 0) break;
					}
					
					if(selCnt == 0){
						ComShowCodeMessage('BKG00442');
						return false;
					}
				
				break;
	            
            }
            return true;
        }
        
        function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    		with(sheetObj){
    			  for(i=1; i<= LastRow; i++){
					  CellEditable(i,"loc_cd") = false;
					  CellEditable(i,"eqlz_port_cd") = false;
					  CellEditable(i,"slan_cd_disp") = false;
    			  }
    		}
    	}
        
        /**
         * 시트에 키필드 Validation 체크 및 해당 코드의 description 조회
         */
        function sheet1_OnChange(sheetObj, Row, Col, Value){
        	var formObj = document.form;
        	// PORT 유효성 체크
        	if(sheetObj.ColSaveName(Col) == "lst_port_cd"){
        		formObj.f_cmd.value = SEARCH01;
        		formObj.strLocCd.value = sheetObj.CellValue(Row, Col);
        		if(formObj.strLocCd.value != ""){
        			doActionIBSheet(sheetObj, formObj, SEARCH01);
        		}
        	}
        	
        	// SLAN 유효성 체크
        	if(sheetObj.ColSaveName(Col) == "slan_cd"){
        		formObj.f_cmd.value = SEARCH02;
        		formObj.strSlanCd.value = sheetObj.CellValue(Row, Col);
        		if(formObj.strSlanCd.value != ""){
        			doActionIBSheet(sheetObj, formObj, SEARCH02);
        		}
        	}
        	
        	// USER ID유효성 체크
        	if(sheetObj.ColSaveName(Col) == "eml_snd_usr_id"){
        		formObj.f_cmd.value = SEARCH03;
        		formObj.strUsrId.value = sheetObj.CellValue(Row, Col);
        		if(formObj.strUsrId.value != ""){
        			//alert(formObj.strUsrId.value);
        			doActionIBSheet(sheetObj, formObj, SEARCH03, Row);
        		}
        	}    
        	
        	// USER Email수정시 User ID, User Name, Office정보 삭제
        	if(sheetObj.ColSaveName(Col) == "rcvr_eml"){
        		sheetObj.CellValue2(Row, 'eml_snd_usr_id') = '';
        		sheetObj.CellValue2(Row, 'usr_nm') = '';
        		sheetObj.CellValue2(Row, 'ofc_cd') = '';
        	}  
        	
        	// 48 이상 입력 시 자동 48로 세팅
        	if(sheetObj.ColSaveName(Col) == "eml_snd_hrs"){
        		if(sheetObj.CellValue(Row, "eml_snd_hrs") > 48){
        			sheetObj.CellValue2(Row, 'eml_snd_hrs') = '48';
        		}
        	}  
        }