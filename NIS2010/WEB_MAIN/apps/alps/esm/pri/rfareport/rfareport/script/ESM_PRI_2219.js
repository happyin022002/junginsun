/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2219.js
*@FileTitle : S/C Performance Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2016-04-01
*@LastModifier : Jong-Ock KIM
*@LastVersion : 1.0
* 2016-04-01 Jong-Ock KIM
* 1.0 Creation
=========================================================*/
/**
 * @fileoverview S/C Performance Summary 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

    /**
     * @extends Pri
     * @class ESM_PRI_2219 : ESM_PRI_2219 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2219() {
        this.loadPage 				= loadPage;
        this.obj_click              = obj_click;
        this.processButtonClick		= processButtonClick;
    }

    //  ===================================================================================
    //  전역변수
    //  ===================================================================================
    var gBefRdoMasterType = "S";
    //  ===================================================================================
    //  페이지 초기화
    //  ===================================================================================
    /** 
     * IBSheet Object를 sheetObjects 배열로 등록 <br>
     */ 
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /** 
     * IBMultiCombo Object를 comboObjects 배열에 등록 <br>
     */ 
    function setComboObject(combo_obj) {
        comboObjects[comboCnt++] = combo_obj;
    }

    /** 
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     */ 
    function loadPage() {
        var form = document.form;	
        //html컨트롤 이벤트초기화    
        //initControl()
        axon_event.addListenerForm('click', 'obj_click', form);	 
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');	
    }

    //  ===================================================================================
    //  버튼 이벤트 처리
    //  ===================================================================================
    document.onclick = processButtonClick;

    /** 
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     */ 
    function processButtonClick(){
        var form = document.form;
        var subForm = subframe.document.form;
        var rdoDateObj = form.rdoDate;
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {

                case "btn_DoJob":
                    subframe.mainCallButtonClick(srcName);
                    break;

                case "btn_retrieve":
                    subframe.mainCallButtonClick(srcName);
                    break;

                case "btn_bl_list":
                    subframe.mainCallButtonClick(srcName);
                    break;

                case "btn_downexcel":
                    subframe.mainCallButtonClick(srcName);
                    break;

            } //end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }

    /** 
     * 2219_02화면에서 Type을 변경 후 Type변수에 변경된 값을 Setting한다. <br>
     */ 
    function setRdoMasterType(){
        gBefRdoMasterType = form.rdoMasterType[1].value; 
    }


    //  ===================================================================================
    //  Axson Event Handler
    //  ===================================================================================
    /**
     * Object 의 Onclick 이벤트핸들러 <br>
     */
    function obj_click(){
    	
        var form = document.form;
        var obj = event.srcElement;	
        switch(obj.name){
            case "rdoMasterType":
                if(gBefRdoMasterType == obj.value ) return;	 		
                if(obj.value == "D") {
                    form.action = "ESM_PRI_2219_02.do";
                    form.target = "subframe";
                    form.submit();
                }else{
                    form.action = "ESM_PRI_2219_01.do";
                    form.target = "subframe";
                    form.submit();
                }
                gBefRdoMasterType = obj.value; 
                break;
        }
        //if(obj.dataformat == null) return;
    }
