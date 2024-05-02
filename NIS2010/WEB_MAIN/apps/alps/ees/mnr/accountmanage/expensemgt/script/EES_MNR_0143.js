/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0143.js
*@FileTitle : Invoice Creation File Import Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.09.03 함형석
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
     * @class EES_MNR_0143 : EES_MNR_0143 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0143() {
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

var combo1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;    

var comboValue = "";  
//검증작업을 한데이타만 부모화면으로 이동가능
var verifyCheck = false;      
var retComboVal = "";   

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;  

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) { 
		        case "btn_new":  
                    doActionIBSheet(sheetObject, formObject, IBCLEAR);
                    break;   

		        case "btn_downExcel":  
					var cnt=sheetObject.RowCount;
					if(cnt<=0)
						var Row = sheetObject.DataInsert(-1); 
					sheetObject.SpeedDown2Excel(-1, false,false,"", "",false,false,"",false,"0|1|2|3|6"); 
                     break;   

                 case "btn_loadExcel": 
				 	sheetObject.LoadExcel(0, 1, "", -1, -1, "", false,false,"1=>4|2=>5");
					
					for(var i = 1; i <= sheetObject.RowCount; i++){  
					    //헤더 Title 있을때 삭제 
						if(i==1 && sheetObject.CellValue(1,"inp_msg1").indexOf("W/O")!=-1){
							sheetObject.RowDelete(1, false); 
						}
						sheetObject.RowStatus(i) = "R";  
						sheetObject.CellEditable(i,"checkbox") = false;          
					}                  
                    break;          		     
 	 
		        case "btn_ok":
                    if(sheetObject.FindCheckedRow("checkbox") == ""){ 
						ComShowCodeMessage("MNR00038","SELECT ");             	   
					} else if(!verifyCheck){  
						ComShowCodeMessage("MNR00157");          		 	  
					} else {     
						comPopupOK_143(sheetObject,formObject); 	
					}                                   
					break;         

		        case "btn_Save":    
                    doActionIBSheet(sheetObject, formObject, IBSAVE); 
                    break;        
					   
		        case "btn_RowAdd":                  
                    doActionIBSheet(sheetObject, formObject, IBINSERT);        
                    break; 
					      
		        case "btn_RowDel":                     
                    doActionIBSheet(sheetObject, formObject, IBDELETE);        
                    break;        

		        case "btn_close":    
                    self.close();  
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() { 
		MnrWaitControl(true); 
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k + 1);
        }   
        //IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){ 
	        initCombo(comboObjects[k],k + 1);  
	    }			
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);		
    }  

    /**
     * IBCombo 기본 설정
     * @param	{IBCombo}	comboObj	초기설정될 콤보오브젝트 
     * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initCombo(comboObj, comboNo) {
  		var cnt  = 0 ;
  	    var formObject = document.form
  	   
  	    switch(comboNo) {  
			case 1: 
		    	with (comboObj) {   
					SetTitle("S/P Name|S/P Code|AGMT No|EQ TYPE|Effective Date|Reference No|Tariff No"); 
				    SetColAlign("left|left|center|left|center|left|left");   
					SetColWidth("180|80|90|80|170|180|180");                        
					DropHeight = 160;           
			    }  	 
	        break;   
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
            case 1:      //t1sheet1 init
                with (sheetObj) { 

                    // 높이 설정  
                    style.height = 242;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;  

                    //전체Edit 허용 여부 [선택, Default false] 
                    Editable = true;             
  
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100); 

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(9, 0, 0, true);        
						 
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
					   
                    var HeadTitle = "|Sel.|Del.|Seq.|W/O No|G.Amount|System Verify Result";
 									 	
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true); 
    											                
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	 	50,    	daCenter,  	false,   "ibflag"); 
                    InitDataProperty(0, cnt++ , dtCheckBox,   		40,    	daCenter,  	false,   "checkbox",     	false,          "",      dfNone,		0,			true,		true);           
                    InitDataProperty(0, cnt++ , dtDummyCheck,   	40,    	daCenter,  	false,   "del_check",     	false,          "",      dfNone,		0,			true,		true);               
					InitDataProperty(0, cnt++ , dtDataSeq,    		40,    	daCenter,  	true,    "Seq",     		false,          "",      dfNone);
					InitDataProperty(0, cnt++ , dtData,      		90,    	daCenter,  	false,   "inp_msg1",     	true,          	"",      dfNone,		0,			true,		true,	11,	false);      
                    //InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,     "inp_msg2",     true,        "",      dfDateYmd,		0,			true,		true,	7,	true); 
                    InitDataProperty(0, cnt++ , dtData,      		170,    daCenter,  	false,   "inp_msg3",     	true,       	"",      dfFloat,		2,			true,		true);    
                    InitDataProperty(0, cnt++ , dtData,      		65,    	daLeft,     false,   "inp_msg5",     	false,        	"",      dfNone,		0,			false,		false);               
                    InitDataProperty(0, cnt++ , dtHidden,	 		80,		daLeft,		true,	 "inp_msg4",	   	false,			"",		 dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,	 		80,		daLeft,		true,	 "inp_msg6",	   	false,			"",		 dfNone,		0,			false,		false);
					                         
					InitDataValid(0,  "inp_msg1", vtEngUpOther,"0123456789"); 
        	     	   
					//SELECT 로우 배경색                  
					//SelectionMode MultiSelection=false이면 1개의 행만 선택 가능           
					EditableColorDiff = false;     
					MultiSelection = true;                                    
					SelectionMode = smSelectionRow;  
					//선택시 하이라이트사용하지 않음            
					SelectHighLight = false;           
					//선택시 볼드 사용하지 않음             
					CountPosition = 0;             
               }
               break;  
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
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj){     
    	comboObjects[comboCnt++] = combo_obj;  
	}     
	
 	/**  
	 * combo1 체인지 이벤트      
	 * @param	{IBMultiCombo}		comboObj	콤보오브젝트  
	 * @param 	{Number} 			Index_Code 	선택된 row 
	 * @param 	{String} 			Text 		선택된 Text  
	 */  
	function combo1_OnChange(comboObj,Index_Code, Text){ 
		comboValue = comboObj.Code;   
		form.vndr_seq.value = combo1.items[comboValue].vndr_seq;
	}     

	/**  
	 * combo1 체크박스 이벤트      
	 * @param	{IBSheet}		sheetObj	콤보오브젝트  
	 * @param 	{String} 			Row 		Row 
	 * @param 	{String} 			Col 		Col 
	 */  
	function sheet1_OnBeforeCheck(sheetObj,Row,Col){  
		if(sheetObj.ColSaveName(Col) == 'checkbox')    
		{
			if(sheetObj.CellValue(Row,Col) != 1){                   
				sheetObj.RowBackColor(Row) = sheetObj.RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);
				
			} else {                            
				sheetObj.RowBackColor(Row) = sheetObj.RgbColor(SheetEditBackColorR,SheetEditBackColorG,SheetEditBackColorB);  
				sheetObj.CellValue2(Row,"inp_msg5") = "";            
				sheetObj.CellEditable(Row,"checkbox") = false;                
				sheetObj.CellEditable(Row,"inp_msg1") = true; 
				sheetObj.CellEditable(Row,"inp_msg2") = true; 
				sheetObj.CellEditable(Row,"inp_msg3") = true;       
				verifyCheck = false;        
			} 
		}				
	} 
	
	//저장후 결과메세지 표시
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){ 
		if (ErrMsg == "") {   
			ComShowCodeMessage("MNR00158");         
		} else { 
			ComShowCodeMessage("MNR00159",ErrMsg);   
		}       
	}

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {

        switch(sAction) {
			 case IBSAVE:        //저장
              		formObj.f_cmd.value = MULTI;   
					vndrSeq = form.vndr_seq.value;
					
					for(var i = 1; i <= sheetObj.RowCount; i++){
						sheetObj.CellValue2(i,"inp_msg6") = vndrSeq;      
					}    
					
					       	   
					for(var i = 1; i <= sheetObj.RowCount; i++){
						sheetObj.RowStatus(i) = "I";      
					}          
					var sParam = sheetObj.GetSaveString(false, true); 
					if (sParam == "") return;
				    sParam += "&" + FormQueryString(formObj);  
				    var sXml = sheetObj.GetSaveXml("EES_MNR_0143GS.do", sParam);
				    sheetObj.LoadSaveXml(sXml); 
								 
					//체크된 로우에 색상을 입힌다.     
					for(var i = 1; i <= sheetObj.RowCount; i++){  
						if(sheetObj.CellValue(i,"checkbox") == 1){    
							sheetObj.RowBackColor(i) = sheetObj.RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);	
							//success 된것은 수정하지 못하게 한다.
							sheetObj.CellEditable(i,"inp_msg1") = false;
							sheetObj.CellEditable(i,"inp_msg2") = false;
							sheetObj.CellEditable(i,"inp_msg3") = false; 
						} else {                 
							sheetObj.RowBackColor(i) = sheetObj.RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);         
							//실패한건은 선택할수 없다. 
							sheetObj.CellEditable(i,"checkbox") = false;  
						}                          
					}         
					verifyCheck = true;
					//verifyCheck에 사용된 eqtype을 저장한다. 
					retComboVal = vndrSeq;         
                break;      
					        
			case IBINSERT:  // ROWADD                   
					var Row = sheetObj.DataInsert(-1); 
					sheetObj.CellValue2(Row,"inp_msg2") = ComGetNowInfo("ymd"); 
					sheetObj.CellEditable(Row,"checkbox") = false; 
					verifyCheck = false;                       
	      		break; 
				
			case IBDELETE:  // ROWDELETE   
					for(var i = sheetObj.RowCount; i > 0; i--){  
						if(sheetObj.CellValue(i,"del_check") == 1){
							sheetObj.RowDelete(i, false);                     	
						}     	
					}           
				break;
			
			case IBCLEAR: //  콤보 데이터 조회 및 모든 쉬트를 초기화 
					MnrWaitControl(true);
					sheetObj.WaitImageVisible=false;
					//콤보데이타 초기화  
					for(var i = 0; i < comboObjects.length;i++){ 
						comboObjects[i].RemoveAll(); 	
					}     
					
					combo1 = new combo1List();	  

					if(woOfcCd=="") woOfcCd=currOfcCd;
					var sXml = MnrAGMTHdrCombo(sheetObj,woOfcCd);
					var arrResult = MnrXmlToArray(sXml);		
					if(arrResult != null){	 	     
						for(var i = 0; i < arrResult.length;i ++){ 		
							combo1.items.push(new combo1AGMT(arrResult[i][1],arrResult[i][8],arrResult[i][9],arrResult[i][12],arrResult[i][13],arrResult[i][15],arrResult[i][25],arrResult[i][2],arrResult[i][28],arrResult[i][14],arrResult[i][0],arrResult[i][22],arrResult[i][21]));		
							var tempComboText = arrResult[i][8] + "|" + arrResult[i][1] + "|" + arrResult[i][9] + "|" + arrResult[i][3] + "|" + arrResult[i][13] + " ~ " + arrResult[i][15] + "|" + arrResult[i][2] + "|" + " " + arrResult[i][25];  					
							formObj.combo1.InsertItem(i, tempComboText ,String(i));                 
							if(formObj.vndr_seq.value==arrResult[i][1]){
								if(vndrSeq!=""){
									formObj.combo1.Code = String(i);
									formObj.combo1.Enable = false; 
								}else{
									formObj.vndr_seq.value="";
								}
							}
						}				 				 						
					} else {					
						ComShowCodeMessage("MNR00056");
					}
					if(formObj.strAccess_system.value=="SPP"){
						formObj.vndr_seq.value = ComLpad(formObj.strVndr_seq.value,6,"0");
						var idx = formObj.combo1.FindIndex ( formObj.vndr_seq.value, 1); 
						formObj.combo1.Code2 = idx;
						formObj.combo1.Enable = false; 
					}
					//쉬트 초기화
					sheetObj.RemoveAll();  
					verifyCheck = false;  
					sheetObj.WaitImageVisible=true;
                  	MnrWaitControl(false);  
    
	      	   	break; 	
        } 
    }  
     
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */ 
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){  

        }       
        return true; 
    }   
	
	/**
     * combo1 사용을 위한 객체배열 
     */
	function combo1List(){
		this.items = [];		
	}
	
	/**
     * combo1 사용을 위한 객체 
     */
	function combo1AGMT(vndr_seq,vndr_nm,agmt_no,agmt_ver_no,eff_dt,exp_dt,trf_no,agmt_ref_no,eq_knd_cd,curr_cd,trsm_mod_cd,edi_id,pay_term_dys){
		this.vndr_seq           = vndr_seq;         
		this.vndr_nm	        = vndr_nm;	        
		this.agmt_no            = agmt_no;         
		this.eff_dt	        	= eff_dt;	        
		this.exp_dt             = exp_dt;          
		this.agmt_ref_no		= agmt_ref_no;      
		this.trf_no             = trf_no;          
		this.agmt_ver_no        = agmt_ver_no;     
		this.eq_knd_cd	        = eq_knd_cd;	
		this.curr_cd            = curr_cd;         
		this.trsm_mod_cd		= trsm_mod_cd; 
		this.edi_id				= edi_id;  
		this.pay_term_dys		= pay_term_dys; 
	}		
	
	/**
     * 추가로 넘겨야 될값이 많아서 따로 구현한다.
     */
	function comPopupOK_143(sheetObj,formObject) {
		var formObject = document.form; 
         
		var rArray = new Array(); //행데이터를 담고 있는 배열
		var ret_val = new Array(); 
		if(comboValue=="") comboValue=0;
		ret_val[0] = retComboVal;    
		ret_val[1] = combo1.items[comboValue].vndr_nm;	
        ret_val[2] = combo1.items[comboValue].pay_term_dys;	
		ret_val[3] = combo1.items[comboValue].curr_cd;	
		     
	    var sRow = sheetObj.FindCheckedRow("checkbox");
	    //가져온 행을 배열로 반든다.          
	    var arrRow = sRow.split("|");   

	    for (idx=0; idx < arrRow.length - 1; idx++){     
			var cArray = new Array(); //열데이터를 담고 있는 배열
			cArray[0] = sheetObj.CellValue(arrRow[idx], "inp_msg1");
			cArray[1] = sheetObj.CellValue(arrRow[idx], "inp_msg2"); 
			cArray[2] = sheetObj.CellValue(arrRow[idx], "inp_msg3"); 
			cArray[3] = sheetObj.CellValue(arrRow[idx], "inp_msg6"); 
			rArray[idx] = cArray;                           
		}   

		opener.getEES_MNR_0143(rArray,ret_val);  //호출하는 부모js에 getMnr_Multi 붙여넣으면됩니다.
		self.close();         
	}   	
	/* 개발자 작업  끝 */