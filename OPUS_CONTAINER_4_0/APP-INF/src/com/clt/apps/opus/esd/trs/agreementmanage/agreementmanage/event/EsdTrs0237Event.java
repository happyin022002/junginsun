/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : EsdTrs0237Event.java
*@FileTitle      : Common Surcharge Management
*Open Issues     : 
*Change history  : 
*@LastModifyDate : 2014-11-05
*@LastModifier   : Hyungwook Choi
*@LastVersion    : 1.0
* 2014-11-05 Hyungwook Choi
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.TrsComScgMgmtTpSzVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0237 에 대한 PDTO(Data Transfer Object including Parameters)
 * - ESD_TRS_0237HTMLAction 에서 작성
 * - ServiceCommand Layer 로 전달하는 PDTO 로 사용
 * @author Hyungwook Choi
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0237Event extends EventSupport {

	private static final long serialVersionUID = 1L;
    private TrsComScgMgmtTpSzVO trsComScgMgmtTpSzVO = null;
    private TrsComScgMgmtTpSzVO[] trsComScgMgmtTpSzVOs = null;

    public TrsComScgMgmtTpSzVO getTrsComScgMgmtTpSzVO() {
        return trsComScgMgmtTpSzVO;
    }

    public void setTrsComScgMgmtTpSzVO(TrsComScgMgmtTpSzVO trsComScgMgmtTpSzVO) {
        this.trsComScgMgmtTpSzVO = trsComScgMgmtTpSzVO;
    }

    public TrsComScgMgmtTpSzVO[] getTrsComScgMgmtTpSzVOs() {
    	TrsComScgMgmtTpSzVO[] rtnVOs = null;
    	if (this.trsComScgMgmtTpSzVOs != null) {
    		rtnVOs = Arrays.copyOf(trsComScgMgmtTpSzVOs, trsComScgMgmtTpSzVOs.length);
    	} // end if
        return rtnVOs;
    }

    public void setTrsComScgMgmtTpSzVOs(TrsComScgMgmtTpSzVO[] trsComScgMgmtTpSzVOs) {
    	if (trsComScgMgmtTpSzVOs != null) {
    		TrsComScgMgmtTpSzVO[] tmpVOs = Arrays.copyOf(trsComScgMgmtTpSzVOs, trsComScgMgmtTpSzVOs.length);
            this.trsComScgMgmtTpSzVOs = tmpVOs;
    	} // end if
    }
}
