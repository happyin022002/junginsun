/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0926Event.java
*@FileTitle : CM Data Check Set-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.23
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.04.23 이수빈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.SetupKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.SetupListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.SetupListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.SetupListModVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0926 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0926HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Subin
 * @see ESM_BKG_0926HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0926Event extends EventSupport {

    private static final long serialVersionUID = 1L;

    /** 조회 조건 및 단건 처리  */
    private SetupListCondVO setuplistcondvo = null;
    private SetupListDetailVO setuplistdetailvo = null;

    /** 저장 처리 */
    private SetupListModVO setupListModVO = null;

    /** 삭제여부 저장 처리 */
    private SetupKeyVO setupKeyVO = null;
    
    private String comboName = null; 
    
    private String cntCd = null; 

    public EsmBkg0926Event(){}
    
    public SetupListCondVO getSetupListCondVO() {
        return setuplistcondvo;
    }

    public void setSetupListCondVO(SetupListCondVO setuplistcondvo) {
        this.setuplistcondvo = setuplistcondvo;
    }

    public SetupListDetailVO getSetupListDetailVO() {
        return setuplistdetailvo;
    }

    public void setSetupListDetailVO(SetupListDetailVO setuplistdetailvo) {
        this.setuplistdetailvo = setuplistdetailvo;
    }

    public SetupListModVO getSetupListModVO() {
        return setupListModVO;
    }

    public void setSetupListModVO(SetupListModVO setupListModVO) {
        this.setupListModVO = setupListModVO;
    }

	public String getComboName() {
		return comboName;
	}

	public void setComboName(String comboName) {
		this.comboName = comboName;
	}

	public String getCntCd() {
		return cntCd;
	}

	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}

	public SetupKeyVO getSetupKeyVO() {
		return setupKeyVO;
	}

	public void setSetupKeyVO(SetupKeyVO setupKeyVO) {
		this.setupKeyVO = setupKeyVO;
	}

}