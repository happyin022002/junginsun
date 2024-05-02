/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : opfutil.js
*@FileTitle : OpfUtil Common
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.05.26 장석현
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
     * @class opfutil : opfutil 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function opfutil() {
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

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

	/**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;

    }

	/**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

    }

	/**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
	function setComboObject(combo_obj){
	   comboObjects[comboCnt++] = combo_obj;
	}


    function processButtonClick(){

         var sheetObject1 = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

/** tab [ Generat/Method ] (S) **/

						case "btn_t1RowAdd":
								sheetObject1.DataInsert(-1);
								break;
								
						case "btn_t1RowInsert":
								var row = sheetObject1.DataInsert();
								break;
								
						case "btn_t1Delete":
								ComRowHideDelete(sheetObject1,"t1sheet1_del_chk");
								break;
						
						case "btn_t1LoadExcel":
								if(sheetObject1.RowCount > 0){
									if(confirm("기존의 로드한 엑셀을 삭제 하시겠습니까?"))
										sheetObject1.RemoveAll();
								}
								sheetObject1.LoadExcel(1);
								break;
						case "btn_t1Generater":
								var xmlMapping = "";
								var xmlScreen = "";
								for(var chkRow = sheetObject1.HeaderRows; chkRow <= sheetObject1.RowCount; chkRow++){
									xmlMapping  +=	gerneraterXMLMappingData(sheetObject1, chkRow) + "\n";
									xmlScreen	+=	gerneraterXMLScreenData(sheetObject1, chkRow) + "\n";
								}
								
								formObject.map_rmk.value = xmlMapping;
								formObject.screen_rmk.value = xmlScreen;

								break;
						case "btn_t1CopyMapping":
							window.clipboardData.setData("Text", formObject.map_rmk.value);
							window.status = "Mapping Copy Done"
							break;

						case "btn_t1CopyScreen":
							window.clipboardData.setData("Text", formObject.screen_rmk.value);
							window.status = "Screen Copy Done"
							break;
/** tab [ Generat/Method ] (E) **/


						case "btn_Retrieve":
								doActionIBSheet(sheetObjects[beforetab], document.form, IBSEARCH);
								break;

						case "btn_New":
							var sParam = ComGetSaveString(sheetObjects);
							if(sParam != ""){
								var writeMsg = "";
								var first = true;
								for(var checkTab = 0; checkTab < marrPrefix.length; checkTab++){
									if(sParam.indexOf(marrPrefix[checkTab]) > -1){
										if(first){
											writeMsg = marrTabTitle[checkTab];
											first = false;
										}else{
											writeMsg = writeMsg + ", " + marrTabTitle[checkTab];
										}
									}	
								}

								if(confirm(writeMsg + "에 작성중인 데이터가 있습니다. 저장하시겠습니까?")){
									doActionIBSheet(sheetObjects[beforetab], document.form, IBSAVE);
								}
							}

							sheetObject1.RemoveAll();

							with(formObject){
								 loc_cd.value = "";
								 por_rhq.Code = "";

								 loc_cd.focus();
							}
							
							break;

						case "btn_Save":
								doActionIBSheet(sheetObjects[beforetab], document.form, IBSAVE);
								break;

				} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    
	/**
    * 초기 이벤트 등록 
    */
    function initControl() {
    	axon_event.addListener('change', 'gntr_rmk_onchange', 'gntr_rmk', '');		//Remark변경시에 처리되는 로직...
    	axon_event.addListener('change', 'fltg_rmk_onchange', 'fltg_rmk', '');		//Remark변경시에 처리되는 로직...
    	axon_event.addListener('change', 'loc_cd_onchange', 'loc_cd', '');			//Port Cd변경시에 처리되는 로직...
    	axon_event.addListener('keyup', 'loc_cd_onkeyup', 'loc_cd', '');			//Port Cd변경시에 처리되는 로직...
    	axon_event.addListener('keypress', 'loc_cd_onkeypress', 'loc_cd', '');			//Port Cd변경시에 처리되는 로직...
    	
		axon_event.addListenerForm  ('blur',			'obj_deactivate',	form); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('focus',			'obj_activate',		form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress',        'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
    }
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
     **/
    function obj_activate(){
        //마스크구분자 없애기
        ComClearSeparator(event.srcElement);
    }
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
     **/
	function obj_deactivate(){
		ComChkObjValid(event.srcElement);
	}
    /**
     * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

		for(k=0; k < tabObjects.length; k++){
            initTab(tabObjects[k],k+1);
        }
		
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}

		initControl();
    }
  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {

        var cnt = 0;
		var sheetID = sheetObj.id;

        switch(sheetID) {

            case "t1sheet1":
                with (sheetObj) {
										// 높이 설정
                    style.height = 260;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|Sel|Status|Create Date|Athor Nm|Title|SC|BC|Mapping \n Url|Remark";

					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					var prefix = "t1sheet1_";
					InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daLeft,	true,		prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,				30,		daCenter,	true,	prefix + "del_chk");
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,	prefix + "status",				false,		"",		dfNone,	0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	true,	prefix + "cre_dt",				true,		"",		dfDateYmd,	0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					100,	daLeft,	true,		prefix + "cre_id",				true,		"",		dfNone,	0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					120,	daLeft,	true,		prefix + "title",				true,		"",		dfNone,	3,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					120,	daLeft,	true,		prefix + "sc_nm",				true,		"",		dfNone,	2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					120,	daLeft,	true,		prefix + "bc_nm",				true,		"",		dfNone,	0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					120,	daLeft,	true,		prefix + "map_url",				true,		"",		dfNone,	0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					150,	daLeft,	true,		prefix + "remark",				true,		"",		dfNone,	2,		true,		true);
				}
				break;
        }
    }
    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {

         switch(tabNo) {
             case 1:
                with (tabObj) {

                    var cnt  = 0 ;
					InsertTab( ++cnt , "MapData" , -1 );

                }
             		break;

         }
    }
	
	
	function t1sheet1_OnLoadExcel(sheetObj){
		with(sheetObj){
			for(var Row = RowCount; Row >= HeaderRows; Row--){
				if(CellValue(Row, "t1sheet1_status") != ""){
					RowDelete(Row, false);
				}
			}
		}
	}
/*=========================================================
	예약어			예제)

	* Mappign
	author		:	"Jang Suk Hyun"
	create_dt	:	"Jang Suk Hyun"
	ui_nm		:	"VOP_OPF_0007"
	gsys_nm		:	"com.hanjin.apps.nis2010"
	sys_nm		:	"vop"
	sub_nm		:	"opf"
	sc_nm		:	"VesselOperationSupportMgt"
	bc_nm		:	"TerminalInformationMgt"
	sc_dir		:	$Sc_Nm.toLowerCase()
	bc_dir		:	$Sc_Nm.toLowerCase()
	actionnm	:	$Ui_Nm + "HTMLAction"
	eventnm		:	replace($Ui_Nm, "_", "") + "Event"
	
	<!-- $Author : $Create_Dt Start -->
    <url-mapping url="$Ui_Nm.do" screen="$Ui_Nm.screen" >
        <web-action-class>$GSys_nm.$Sys_Nm.$Sub_Nm.$Sc_Dir.$Bc_dir.event.$ActionNm</web-action-class>
    </url-mapping>

    <url-mapping url="$Ui_NmGS.do" screen="com.hanjin.framework.core.controller.DefaultViewAdapter" >
        <web-action-class>$GSys_nm.$Sys_Nm.$Sub_Nm.$Sc_Dir.$Bc_dir.event.$ActionNm</web-action-class>
    </url-mapping>

    <event-mapping>
        <event-class>$GSys_nm.$Sys_Nm.$Sub_Nm.$Sc_Nm.$Bc_Nm.event.$EventNm</event-class>
        <service-action-class>$GSys_nm.$Sys_Nm.$Sub_Nm.$Sc_Dir.$Sc_Nm</service-action-class>
    </event-mapping>
	<!-- $Author : $Create_Dt End -->
=========================================================*/	

	function gerneraterXMLMappingData(sheetObj, Row){
		var prefix = "t1sheet1_";
		var author		=	sheetObj.CellValue(Row, prefix + "cre_id");
		var createDt	=	sheetObj.CellText(Row, prefix + "cre_dt");
		var uiNm		=	sheetObj.CellValue(Row, prefix + "map_url").toUpperCase();
		var gsysNm		=	document.form.gsys_nm.value;
		var sysNm		=	document.form.sys_nm.value;
		var subNm		=	document.form.sub_nm.value;
		var scName		=	sheetObj.CellValue(Row, prefix + "sc_nm");
		var bcName		=	sheetObj.CellValue(Row, prefix + "bc_nm");
		var scDir		=	scName.toLowerCase();
		var bcDir		=	bcName.toLowerCase();
		var	actionnm	=	uiNm + "HTMLAction";
		var	eventnm		=	"";
		var	arrHtmlNm	=	uiNm.split("_");
		var returnStr	=	document.form.mappingData.value;


		for(var cnt = 0; cnt < arrHtmlNm.length; cnt++){
			eventnm += arrHtmlNm[cnt].substring(0, 1).toUpperCase() + arrHtmlNm[cnt].substring(1).toLowerCase();
		}

		eventnm += "Event";
		returnStr = ComReplaceStr(returnStr,	"$Author",		author		);
		returnStr = ComReplaceStr(returnStr,	"$Create_Dt",	createDt	);
		returnStr = ComReplaceStr(returnStr,	"$Ui_Nm",		uiNm		);
		returnStr = ComReplaceStr(returnStr,	"$GSys_nm",	    gsysNm		);
		returnStr = ComReplaceStr(returnStr,	"$Sys_Nm",		sysNm		);
		returnStr = ComReplaceStr(returnStr,	"$Sub_Nm",		subNm		);
		returnStr = ComReplaceStr(returnStr,	"$Sc_Nm",		scName		);
		returnStr = ComReplaceStr(returnStr,	"$Bc_Nm",		bcName		);
		returnStr = ComReplaceStr(returnStr,	"$Sc_Dir",		scDir		);
		returnStr = ComReplaceStr(returnStr,	"$Bc_dir",		bcDir		);
		returnStr = ComReplaceStr(returnStr,	"$ActionNm",	actionnm	);
		returnStr = ComReplaceStr(returnStr,	"$EventNm",	    eventnm		);

		return returnStr;
	}
/*=========================================================
	예약어			예제)
	* Screen
	title_nm	:	"Terminal Information"
	ui_nmlower	:	$Ui_Nm.toLowerCase() + ".jsp"

	<!-- $Author : $Create_Dt Start -->
    <screen name="$Ui_Nm">
        <parameter key="title"    value="$Title_Nm" direct="true"/>
        <parameter key="body"     value="$GSys_nm/$Sys_Nm/$Sub_Nm/$Sc_Dir/$Bc_Dir/jsp/$Ui_NmLower"/>
    </screen>
	<!-- $Author : $Create_Dt End -->

    <screen name="VOP_OPF_0007">
        <parameter key="title"    value="Terminal Information" direct="true"/>
        <parameter key="body"     value="apps/nis2010/vop/opf/vesseloperationsupportmgt/terminalinformationmgt/jsp/vop_opf_0007.jsp"/>
    </screen>

	필요 함수	:	ComReplaceStr
=========================================================*/	
	function gerneraterXMLScreenData(sheetObj, Row){
		var prefix = "t1sheet1_";
		var author		=	sheetObj.CellValue(Row, prefix + "cre_id");
		var createDt	=	sheetObj.CellText(Row, prefix + "cre_dt");
		var titleNm		=	sheetObj.CellText(Row, prefix + "title");
		var uiNm		=	sheetObj.CellValue(Row, prefix + "map_url").toUpperCase();
		var gsysNm		=	ComReplaceStr(ComReplaceStr(document.form.gsys_nm.value, "com.hanjin.", ""), ".", "/") ;
		var sysNm		=	document.form.sys_nm.value;
		var subNm		=	document.form.sub_nm.value;
		var scName		=	sheetObj.CellValue(Row, prefix + "sc_nm");
		var bcName		=	sheetObj.CellValue(Row, prefix + "bc_nm");
		var scDir		=	scName.toLowerCase();
		var bcDir		=	bcName.toLowerCase();
		var	jspName		=	uiNm.toLowerCase() + ".jsp";
		var returnStr	=	document.form.screenData.value;

		returnStr = ComReplaceStr(returnStr,	"$Author",		author		);
		returnStr = ComReplaceStr(returnStr,	"$Create_Dt",	createDt	);
		returnStr = ComReplaceStr(returnStr,	"$Title_Nm",	titleNm		);
		returnStr = ComReplaceStr(returnStr,	"$Ui_Nm",		uiNm		);
		returnStr = ComReplaceStr(returnStr,	"$GSys_nm",	    gsysNm		);
		returnStr = ComReplaceStr(returnStr,	"$Sys_Nm",		sysNm		);
		returnStr = ComReplaceStr(returnStr,	"$Sub_Nm",		subNm		);
		returnStr = ComReplaceStr(returnStr,	"$Sc_Dir",		scDir		);
		returnStr = ComReplaceStr(returnStr,	"$Bc_dir",		bcDir		);
		returnStr = ComReplaceStr(returnStr,	"$Jsp_Nm",		jspName		);

		return returnStr;
	}

	/* 개발자 작업  끝 */