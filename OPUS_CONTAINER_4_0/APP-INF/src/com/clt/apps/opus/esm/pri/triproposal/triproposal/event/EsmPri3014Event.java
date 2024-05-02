/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri3014Event.java
 *@FileTitle : EsmPri3014Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.30
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.11.30 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.triproposal.event;

import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.TriPropSendMailVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriTriRtVO;

/**
 * UI_PRI_3014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_3014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_3014HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri3014Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private TriPropSendMailVO triPropSendMailVO = null;
	
	private PriTriRtVO[] priTriRtVOs = null;
	
	public EsmPri3014Event() {
	}

    /**
     * @return the triPropSendMailVO
     */
    public TriPropSendMailVO getTriPropSendMailVO() {
        return triPropSendMailVO;
    }

    /**
     * @param triPropSendMailVO the triPropSendMailVO to set
     */
    public void setTriPropSendMailVO(TriPropSendMailVO triPropSendMailVO) {
        this.triPropSendMailVO = triPropSendMailVO;
    }

    /**
     * @return the priTriRtVOs
     */
    public PriTriRtVO[] getPriTriRtVOs() {
    	PriTriRtVO[] tmpVOs = null;
		if (this.priTriRtVOs != null) {
			tmpVOs = new PriTriRtVO[priTriRtVOs.length];
			System.arraycopy(priTriRtVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

    /**
     * @param priTriRtVOs the priTriRtVOs to set
     */
    public void setPriTriRtVOs(PriTriRtVO[] priTriRtVOs) {
		if (priTriRtVOs != null) {
			PriTriRtVO[] tmpVOs = new PriTriRtVO[priTriRtVOs.length];
			System.arraycopy(priTriRtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priTriRtVOs = tmpVOs;
		}
	}

}