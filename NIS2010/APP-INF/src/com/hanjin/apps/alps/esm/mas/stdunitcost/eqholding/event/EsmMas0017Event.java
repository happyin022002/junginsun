/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EsmMas0017Event.java
*@FileTitle : Container PDM by Inventory
*Open Issues :
*Change history :
*@LastModifyDate : 2016-03-18
*@LastModifier : Young-Heon Lee
*@LastVersion : 
*  2016-03-18 Young-Heon Lee
*  1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.event;

import com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.vo.CntrPdmInvtVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_MAS_0017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Young-Heon Lee
 * @see ESM_MAS_0017HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0017Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private CntrPdmInvtVO cntrPdmInvtVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CntrPdmInvtVO[] cntrPdmInvtVOs = null;
	
	public CntrPdmInvtVO getCntrPdmInvtVO() {
		return cntrPdmInvtVO;
	}

	public void setCntrPdmInvtVO(CntrPdmInvtVO cntrPdmInvtVO) {
		this.cntrPdmInvtVO = cntrPdmInvtVO;
	}

	public CntrPdmInvtVO[] getCntrPdmInvtVOs() {
		CntrPdmInvtVO[] rtnVOs = null;
		if (this.cntrPdmInvtVOs != null) {
			rtnVOs = new CntrPdmInvtVO[cntrPdmInvtVOs.length];
			System.arraycopy(cntrPdmInvtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setCntrPdmInvtVOs(CntrPdmInvtVO[] cntrPdmInvtVOs) {
		if (cntrPdmInvtVOs != null) {
			CntrPdmInvtVO[] tmpVOs = new CntrPdmInvtVO[cntrPdmInvtVOs.length];
			System.arraycopy(cntrPdmInvtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cntrPdmInvtVOs = tmpVOs;
		}
	}
	
}
