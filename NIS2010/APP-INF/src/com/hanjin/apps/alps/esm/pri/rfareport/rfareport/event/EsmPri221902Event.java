/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri221902Event.java
*@FileTitle : Copied RFA List
*Open Issues :
*Change history :
*@LastModifyDate : 2016-04-01
*@LastModifier : Jong-Ock KIM
*@LastVersion : 1.0
* 2016-04-01 Jong-Ock KIM
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfareport.rfareport.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.MasterRFAConditionVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltPriCopiedRFAVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_2219_02 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2219_02HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Day-Hoh Kim
 * @see ESM_PRI_2219_02HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri221902Event extends EventSupport {

	private static final long serialVersionUID = 2453667971767080933L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MasterRFAConditionVO masterRFAConditionVO = null;
	private RsltPriCopiedRFAVO rsltPriCopiedRFAVO = null;
	/** Table Value Object Multi Data 처리 */		
	private RsltPriCopiedRFAVO[] RsltPriCopiedRFAVOs = null;

	public MasterRFAConditionVO getMasterRFAConditionVO() {
		return masterRFAConditionVO;
	}

	public void setMasterRFAConditionVO(MasterRFAConditionVO masterRFAConditionVO) {
		this.masterRFAConditionVO = masterRFAConditionVO;
	}
	
	public RsltPriCopiedRFAVO getRsltPriCopiedRFAVO() {
		return rsltPriCopiedRFAVO;
	}

	public void setRsltPriCopiedRFAVO(RsltPriCopiedRFAVO rsltPriCopiedRFAVO) {
		this.rsltPriCopiedRFAVO = rsltPriCopiedRFAVO;
	}
	
	public RsltPriCopiedRFAVO[] getRsltPriCopiedRFAVOs() {
		RsltPriCopiedRFAVO[] rtnVOs = null;
		if (this.RsltPriCopiedRFAVOs != null) {
			rtnVOs = new RsltPriCopiedRFAVO[RsltPriCopiedRFAVOs.length];
			System.arraycopy(RsltPriCopiedRFAVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setRsltPriCopiedRFAVOs(RsltPriCopiedRFAVO[] RsltPriCopiedRFAVOs) {
		if(RsltPriCopiedRFAVOs != null){
			RsltPriCopiedRFAVO[] tmpVOs = Arrays.copyOf(RsltPriCopiedRFAVOs, RsltPriCopiedRFAVOs.length);
			this.RsltPriCopiedRFAVOs = tmpVOs;
		}
	}
}