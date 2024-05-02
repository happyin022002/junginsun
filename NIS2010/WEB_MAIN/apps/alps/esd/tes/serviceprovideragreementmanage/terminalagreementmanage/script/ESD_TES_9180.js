/*--==============================================================================
'주  시 스 템 : ESD_TES_918.jsp
'서브  시스템 : 자바스크립트
'프로그램 ID  : ESD_TES_918.js
'프로그램 명  : Thrp Cost List 및 데이터 Insert 처리							
'프로그램개요 : Thrp Cost List 및 데이터 Insert 처리				
'작   성   자 : 
'작   성   일 : 
*@FileName :  ESD_TES_9180.js ( 2009-09-10 )
*@ALPSModifyDate : 2009-09-10
*@ALPSModifier : yOng hO lEE
*@ALPSVersion : 1.0
* 2009.09.10 yOng hO lEE
==============================================================================--*/  

// 공통전역변수
var comboObjects = new Array();
var comboCnt = 0 ; 

var sheetObjects = new Array();
var sheetCnt = 0;

/** 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
	 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         /*******************************************************/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];

         var formObject = document.form;

    	 try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

         	    case "btn_retrieve":         	    
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);    	             
        	        break;

         	    case "btn_new":
    	            sheetObject.removeAll();
        	        break;

         	    case "btn_save":
    	            doActionIBSheet(sheetObject,formObject,IBSAVE);
        	        break;

         	    case "btn_ok":
    	            ComShowMessage("btn_ok button click");
        	        break;

         	    case "btn_close":
    	            window.close();
        	        break;

 
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('TES21025');
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * IBSheet Object를 배열로 등록.<br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다.<br>
     * 배열은 소스 상단에 정의.<br>
     * 
     * @param {sheet_obj}  	sheet_obj	Sheet Object
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화.<br>
     * body 태그의 onLoad 이벤트핸들러 구현.<br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다.<br>
     */
    function loadPage() {

    	for(i = 0; i < sheetObjects.length; i++) {

    		//khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet(sheetObjects[i]);

    		initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}

    	if(window.dialogArguments.document.form.lgs_cost_cd.value == "") {
    		document.form.lgs_cost_cd.value = "TPNDFL";  
    	}else{
    		document.form.lgs_cost_cd.value  = window.dialogArguments.document.form.lgs_cost_cd.value;
    	}

    	// THRP Cost Code Sheet 조회.
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);			
        
    	// Cost Code ComboBox 설정 초기화.
    	var lccvalue = sheetObjects[0].EtcData("lgsCostCDText");
    	for(p = 0; p < comboObjects.length; p++) {
    		initCombo(comboObjects[p], p+1, lccvalue);            
    	}	        						 
    }

   /**
     * 시트 초기설정값, 헤더 정의.<br>
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호.<br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다.<br>
     * @param{sheetObj}		sheetObj	Sheet Object
     * @param{sheetNo}		sheetNo		시트오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initSheet(sheetObj,sheetNo) {

    	var cnt = 0;

    	switch(sheetNo) {
             case 1:      //sheet1 init
            	 with (sheetObj) {
                    // 높이 설정
                    style.height = 300;
                                        
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
                    InitColumnInfo(4, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle = "Cost Code|Short Description|Select";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,			WIDTH, 	DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]                                        
                    InitDataProperty(0, cnt++, dtData,        	80,    daCenter,  true,   	"thrp_lgs_cost_cd",       false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,      	210,   daCenter,  true,   	"lgs_cost_full_nm",        								false,          "",       dfNone,    0,     true,       true);                     
                    InitDataProperty(0, cnt++, dtCheckBox,   	30,    daCenter,  true,    	"selCheck",        				false, 	        "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtHiddenStatus,  1,     daCenter,  true,    	"ibflag");
                    //InitDataProperty(0, cnt++, dtStatus,    1,     daCenter,  true,    	"ibflag");
                    
               }
                break;
                // 사용되지 않는 Sheet 설정 ( 2009-09-15 )
             case 2:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                                        
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
                    InitColumnInfo(1, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle = "Cost Code";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtData,	80,    daCenter,  true,    "",        false,          "",       dfNone,    0,     true,       true);                      
                }
                break;                
    	}
    }



	/**
	 *  Sheet관련 프로세스 처리.<br>
	 * 
	 * @param {sheetObj}	sheetObj	Sheet Object
	 * @param {formObj}		formObj		Form Object
	 * @param {sAction}		sAction		Action Command
	 */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;

    	switch(sAction) {
    	
    		case IBSEARCH:      //조회
    			formObj.f_cmd.value = SEARCH;
    			sheetObj.DoSearch4Post("ESD_TES_9180GS.do", tesFrmQryStr(formObj)); 
    			break;

    		case IBSAVE:      //저장
    			try{
    				document.form.loop_value.value	= sheetObjects[0].RowCount("U");												
    				formObj.f_cmd.value	= ADD; 						
    				var SaveStr = sheetObjects[0].GetSaveString(true);																		
    				var sXml = sheetObjects[0].GetSaveXml("ESD_TES_9180GS.do", tesFrmQryStr(formObj)+'&'+ SaveStr); 									
    				sheetObjects[0].LoadSaveXml(sXml,true);
							     
    				window.close();
    			}
    			catch (e){
    				ComShowCodeMessage ("TES50103", e.number, e.description); //"code:" + e.number +",설명:" + e.description);   	
    			} 	

    			break;
    	}
    }

	/**
	 * (인자: 현재창의 input sheet 객체, opener의 대상 sheet명)
	 * popup창의 sheet data를 opener의 특정 sheet로 넘기기 -> 단 동일한 saveName만 해당.<br>
	 * 사용하는곳 안보임 (2009-09-15).<br>
	 * @deprecated
	 * @param {ip_sht_obj}		ip_sht_obj		input sheet object
	 * @param {opr_sht_nm_str}	opr_sht_nm_str	opr_sht_nm_str
	 */
	function setDtaCurrSht2OprSht(ip_sht_obj, opr_sht_nm_str) {
		
		/*
			(인자: 현재창의 input sheet 객체, opener의 대상 sheet명)
			popup창의 sheet data를 opener의 특정 sheet로 넘기기 -> 단 동일한 saveName만 해당
		*/

		var sheetObject = ip_sht_obj;
		//var opener_sheet_obj = eval('window.dialogArguments.document.'+opr_sht_nm_str);  //COIN
		var opener_sheet_obj = window.dialogArguments.sheetObjects[6];  //COIN
		opener_sheet_obj.RemoveAll();
 
		for (i = 1; i < sheetObject.Rows; i++) //제목은 제외
		{
			if(sheetObject.CellValue(i,4) == "1") {
				var iRow = opener_sheet_obj.DataInsert(-1);			
				for(j = 0; j <= sheetObject.LastCol; j++)
				{
					if (sheetObject.ColSaveName(j) != "") 
					{   // 현재 SaveName이 없는것들을 걸러내기위한조건					
						for(k=0; k<=opener_sheet_obj.LastCol; k++)
						{
							if (opener_sheet_obj.ColSaveName(k) == sheetObject.ColSaveName(j))
							{
								opener_sheet_obj.CellValue2(iRow, opener_sheet_obj.ColSaveName(k)) = sheetObject.CellValue(i, sheetObject.ColSaveName(j)) ;
							}
						}
					}
				}
			}	
		}
	}

    /**
     * t1sheet1 Sheet에 있는 조회후 프로세스 처리. <br>
     * 
     * @param{sheetObj}		sheetObj	Sheet Object
     * @param{errMsg}		errMsg		Error Message
     */
	function t1sheet1_OnSearchEnd(sheetObj,errMsg){
		if(errMsg!=null){
			ComShowMessage(errMsg);
		}
		    
		var opener_obj =  window.dialogArguments;
		var thrpvalue = sheetObjects[0].EtcData("thrpCostCDText"); 
		var thrpArray = thrpvalue.split("|");      
		              
		for( k=0; k < sheetObjects[0].RowCount("R")+2;k++){
			for( j=0; j <thrpArray.length;j++){				
				if(sheetObjects[0].CellValue(k+1, 0) == thrpArray[j]) {							
					sheetObjects[0].CellValue(k+1, 2) = "1"; 
					sheetObjects[0].CellValue(k+1, 3) = "U";
					opener_obj.document.form.thrpFlg.value = "Y";							
				}	
			}	
		}		        
	} 
     
	/**
	 * t1sheet1 Sheet에 있는 저장후 프로세스 처리. <br>
	 * 
	 * @param{sheetObj}		sheetObj	Sheet Object
	 * @param{errMsg}		errMsg		Error Message
	 */
	function t1sheet1_OnSaveEnd(sheetObj, errMsg){      	
		if(errMsg != null){
			ComShowMessage(errMsg);
		}        
		var opener_obj =  window.dialogArguments;
		ComShowCodeMessage('TES10093');
		opener_obj.document.form.thrpFlg.value = "Y";      
	}     
    	
	/**
	 * Combo Box 설정 초기화. <br>
	 * 
	 * @param{comboObj}		comboObj	ComboBox Object
	 * @param{comboNo}		comboNo		ComboBox No
	 * @param{lccvalue}		lccvalue	lccvalue
	 */
	function initCombo (comboObj, comboNo,lccvalue) {
		var cnt  = 0 ;
		var lccArray = lccvalue.split("|");				
		var valueArray;        
		switch(comboNo) {
			case 1:             
				comboObj.RemoveAll();              	 
				with (comboObj) { 	               	
					SetColAlign("left");
					SetColWidth("40");			    	       
									    
					for(i=0 ;i<lccArray.length;i++){
						valueArray = lccArray[i].split("--");  
						if(valueArray[0] == ""){
							break;
						}              
						InsertItem(cnt++, valueArray[1] + '|' + valueArray[0], valueArray[0]);    
									  
						comboObj.Code = "TPNDFL";		
					}					    	
				}
				break;                                                                       
		}

	}
	
	/**
	 * ComboBox Object를 배열로 등록. <br>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다. <br>
	 * 배열은 소스 상단에 정의. <br>
	 * 
	 * @param {combo_obj}  	combo_obj	ComboBox Object
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	} 
  
	/**
	 * LGS Cost Code 변경시 프로세스 처리.<br>
	 * 
	 * @param {comObj}  	comObj		ComboBox Object
	 * @param {index}  		index		index
	 * @param {text}  		text		text
	 */
	function lgs_cost_cd_c_OnChange(comObj,index,text){  
		document.form.lgs_cost_cd.value = comObj.Code;                   
	} 