/**
 * TESCommonJSP.js 
 * Arch 표준 규칙 준수를 위해서 파일명 변경
 */

	/***************************************************************************************
		
		이 JS FILE은 TESCommon.jsp의 내부에서 사용하는 function을 구성 : 외부용이 아님당

	***************************************************************************************/

	var sheetObjects = new Array();
	var sheetCnt = 0;

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }

	/**
	 * TES Common 콤보박스 만들기. 
	 * 
	 * @param {String}		combo_val  	combo value
	 * @param {int,string}	idx  		idx
	 * @param {string}		def_val  	def value
	 **/
	function tes_makeCombo(combo_val, idx, def_val){
		var formObj = document.form;
		var parentObj = eval("parent.comboObjects["+(idx-1)+"]");
		if (parentObj!=null){
			parentObj.RemoveAll(); 
			parent.initCombo(parentObj, parseInt(idx,10), combo_val, def_val);
			if (formObj.functionName.value!=undefined && formObj.functionName.value!=null && formObj.functionName.value.trim()!=''){
				eval("parent."+formObj.functionName.value+"()");
			}
			/**********************************************************************************************************************************************
				2009-08-17: 내부적인 iframe사용 완료 후 바로 제거하는 기능을 호출한다.
							iframe제거용 function은 TESCommon.js만 include하면 된다. TESCommon을 반드시 화면에서 include해야한다.
			 **********************************************************************************************************************************************/
			try {
				parent.tes_removeTESCommonIframe(document.form.ifrId.value);	
			} catch(e){
			}
		}
	}
	 
	/**
	 * TES Common 콤보박스 만들기. 
	 * 
	 * @param {string}		combo_val  	ComboBox value
	 * @param {string}		org_val  	original value
	 **/
	function tes_makeCombo2(idx, org_val){
		var formObj = document.form;
		var parentObj = eval("parent.comboObjects["+(idx-1)+"]");
		
		if (parentObj!=null){
			parentObj.RemoveAll(); 

			var tmp = null;
			if (org_val!=null){
				tmp = org_val.split('--');
			}
			
			var tmp2 = null;
			var keyArr = new Array();
			var valueArr = new Array();
							
			for( var i=0; i< tmp.length; i++ ){
				tmp2 = tmp[i].split('|');
				
				if( tmp2[0]!=undefined && tmp2[0]!=null ) keyArr[i] = tmp2[0];
				else  keyArr[i] = '';
				
				if( tmp2[1]!=undefined && tmp2[1]!=null ) valueArr[i] = tmp2[1];
				else  valueArr[i] = tmp2[1];
			}
			
			parent.initCombo(parentObj, parseInt(idx,10), keyArr, valueArr);
			
			if (formObj.functionName.value!=undefined && formObj.functionName.value!=null && formObj.functionName.value.trim()!=''){
				eval("parent."+formObj.functionName.value+"()");
			}
			/**********************************************************************************************************************************************
				2009-08-17: 내부적인 iframe사용 완료 후 바로 제거하는 기능을 호출한다.
							iframe제거용 function은 TESCommon.js만 include하면 된다. TESCommon을 반드시 화면에서 include해야한다.
			 **********************************************************************************************************************************************/
			try {
				parent.tes_removeTESCommonIframe(document.form.ifrId.value);	
			} catch(e){
			}
		}
	}	 

	/**
	 * TES Common Input Value 설정. 
	 * 
	 * @param {string}		ret_val  	return value
	 **/
	function tes_setInputValue(ret_val){
		var formObj = document.form;
		var parentObj = eval("parent.document.all."+formObj.coid.value);
		if (parentObj!=undefined && parentObj!=null){
			parentObj.value = ret_val;
			if (formObj.functionName.value!=undefined && formObj.functionName.value!=null && formObj.functionName.value.trim()!=''){
				eval("parent."+formObj.functionName.value+"()");
			}
			/**********************************************************************************************************************************************
				2009-08-17: 내부적인 iframe사용 완료 후 바로 제거하는 기능을 호출한다.
							iframe제거용 function은 TESCommon.js만 include하면 된다. TESCommon을 반드시 화면에서 include해야한다.
			 **********************************************************************************************************************************************/
			try {
				parent.tes_removeTESCommonIframe(document.form.ifrId.value);
			} catch(e){
			}
		}
	}
	 
//	 
//	 function tes_makeComboCntrBkg(combo_val, idx, def_val, sheetObj) {
//			var formObj = document.form;
//			var parentObj = eval("parent.sheetObjects[0]");
//			if (parentObj!=null){
//				parent.sheetObjects[0].CellComboItem(idx, 'bkg_no', combo_val, def_val);
//				parent.sheetObjects[0].CellValue2(idx, 'bkg_no_list_ctnt') = combo_val;	// 컬럼 추가 했을 경우 변경.
//				if (formObj.functionName.value!=undefined && formObj.functionName.value!=null && formObj.functionName.value.trim()!=''){
//					eval("parent."+formObj.functionName.value+"()");
//				}
//				/**********************************************************************************************************************************************
//					2009-08-17: 내부적인 iframe사용 완료 후 바로 제거하는 기능을 호출한다.
//								iframe제거용 function은 TESCommon.js만 include하면 된다. TESCommon을 반드시 화면에서 include해야한다.
//				 **********************************************************************************************************************************************/
//				try {
//					parent.tes_removeTESGuaranteeCommonIframe(document.form.ifrId.value);	
//				} catch(e){
//				}
//			}
//		}
	 
	 
   /**
	 * TES Common Input Value 설정. 
	 * 
	 * @param {string}		ret_val  	return value
	 * @param {idx}  		idx
	 **/
	function tes_setInputValueNew(ret_val, idx){
		var formObj = document.form;
		var parentObj = eval("parent.document.all."+formObj.coid.value);
		var tmp = '';
		if (parentObj!=undefined && parentObj!=null){
			parentObj.value = ret_val;
			tmp = ret_val.split('|');
			parent.sheetObjects[0].CellValue2(idx, "rvis_cntr_tpsz_cd") = tmp[1];
			parent.sheetObjects[0].CellValue2(idx, "rvis_bkg_no") = tmp[2];
			if (formObj.functionName.value!=undefined && formObj.functionName.value!=null && formObj.functionName.value.trim()!=''){
				eval("parent."+formObj.functionName.value+"("+idx+")");
			}
			/**********************************************************************************************************************************************
				2009-08-17: 내부적인 iframe사용 완료 후 바로 제거하는 기능을 호출한다.
							iframe제거용 function은 TESCommon.js만 include하면 된다. TESCommon을 반드시 화면에서 include해야한다.
			 **********************************************************************************************************************************************/
			try {
				parent.tes_removeTESCommonIframe(document.form.ifrId.value);
			} catch(e){
			}
		}
	}

	/**
	 * TES Common Input Value 설정. 
	 * 
	 * @param {string}		ret_val  	return value
	 * @param {idx}  		idx
	 **/
	function tes_setInputValueNew2(ret_val, idx){
		var formObj = document.form;
		var parentObj = eval("parent.document.all."+formObj.coid.value);
		var tmp = '';
//		alert("111 : "+ret_val);
//		alert("222 : "+idx);
		if (parentObj!=undefined && parentObj!=null){
			parentObj.value = ret_val;
			tmp = ret_val.split('|');
			parent.sheetObjects[0].CellValue2(idx, "cntr_tpsz_cd") = tmp[1];
			parent.sheetObjects[0].CellValue2(idx, "bkg_no") = tmp[2];
			if (formObj.functionName.value!=undefined && formObj.functionName.value!=null && formObj.functionName.value.trim()!=''){
				eval("parent."+formObj.functionName.value+"("+idx+")");
			}

			/**********************************************************************************************************************************************
				2009-08-17: 내부적인 iframe사용 완료 후 바로 제거하는 기능을 호출한다.
							iframe제거용 function은 TESCommon.js만 include하면 된다. TESCommon을 반드시 화면에서 include해야한다.
			 **********************************************************************************************************************************************/
			try {
				parent.tes_removeTESCommonIframe(document.form.ifrId.value);
			} catch(e){
			}
		}
	}

	/**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * 
     * @param {ibsheet}		sheet_obj  	sheet object
     */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
    }

	/**
     * 시트 초기설정값, 헤더 정의
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다.
     * 
     * @param {ibsheet}		sheetObj  	Sheet Object
     * @param {int,string}	sheetNo  	Sheet Object 태그의 아이디에 붙인 일련번호
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetNo) {
            case 1:   //t1sheet1 init
                with (sheetObj) {

                    style.height=GetSheetHeight(10);
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1 , 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(1, 0, 0, true);

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,        80,    daLeft,  false,    "",     false,          "",       dfNone,   		0,     false,      false, 3);
				}
                break;
		}
	}

    
	/**
     * Sheet Action 
     * 
     * @param {ibsheet}		sheetObj  	Sheet Object
     * @param {Object}		formObj}  	Form Object
     * @param {String}		sAction  	Action Command
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {

        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
        	case IBSEARCH:      //조회
        		var sXml = sheetObj.GetSearchXml("TESCommonGS.do", tesFrmQryStr(formObj));
        		sheetObj.LoadSearchXml(sXml);
        		var sxml0 = sheetObj.EtcData(formObj.coid.value.trim());
        		sXml=null; sxml0=null;
        		
        		break;
        }
    }


	/**
	 * Sheet 조회후 처리. 
	 * 
	 * @param {ibsheet}		sheet		sheet Objcet
	 * @param {String}		ErrMsg 		Error Message
	 **/
	function sheet_OnSearchEnd(sheet, ErrMsg){
		var formObj = document.form;
		var org_val = sheet.EtcData(formObj.coid.value); 
		var ret_val = org_val;
		if (formObj.mode.value!=undefined && formObj.mode.value.toUpperCase()=='COMBO'){
			var def_val	= formObj.def.value;
			var idx		= formObj.idx.value;
			if (ret_val!=null){
				tmp = ret_val.split('--');
			}
			if ((tmp[0]!=undefined && tmp[0]!=null && tmp[0].trim()!='') && (def_val==undefined || def_val==null || def_val.trim()=='')){
				def_val = tmp[0];
			}
			if (tmp[1]!=undefined && tmp[1]!=null && tmp[1].trim()!=''){
				ret_val = tmp[1];
			}
			
			//[ESD_TES_0027]GET MDM Account
			if ( document.getElementById("f_cmd").value == 35) tes_makeCombo2(idx, org_val);
			else tes_makeCombo(ret_val, idx, def_val);
			
		} else if (formObj.mode.value!=undefined && formObj.mode.value.toUpperCase()=='INPUT'){
			var idx		= formObj.idx.value;
			if ( document.getElementById("f_cmd").value == 130 && document.getElementById("rfmo")!=null && document.getElementById("rfmo").value == "Y"){
				tes_setInputValueNew(ret_val, idx);				
			} else if ( document.getElementById("f_cmd").value == 131 && document.getElementById("rfmo")!=null && document.getElementById("rfmo").value == "Y"){
				tes_setInputValueNew2(ret_val, idx);				
			} else {
				tes_setInputValue(ret_val);	
			}
		} else {
			//combo이외의 것에 대해 작업하려면 여기에 추가...
		}
	}
