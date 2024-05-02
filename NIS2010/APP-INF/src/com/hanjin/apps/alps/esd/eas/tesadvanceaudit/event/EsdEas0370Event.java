/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : EsdEas0370Event.java
*@FileTitle : M&R Invoice Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-13
*@LastModifier : Jong-Ock Kim
*@LastVersion : 1.0
* 2015-04-13 Jong-Ock Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesAudCfgVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesAuditConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EsdEas0370Event PDTO(Data Transfer Object including Parameters)<br>
 * @author Jong-Ock Kim
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0370Event extends EventSupport {

	private static final long serialVersionUID = 2453667971767080933L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private TesAuditConditionVO tesAuditConditionVO = null;
	private TesAudCfgVO tesAudCfgVO = null;
	/** Table Value Object Multi Data 처리 */		
	private TesAudCfgVO[] TesAudCfgVOs = null;

	public TesAuditConditionVO getTesAuditConditionVO() {
		return tesAuditConditionVO;
	}

	public void setTesAuditConditionVO(TesAuditConditionVO tesAuditConditionVO) {
		this.tesAuditConditionVO = tesAuditConditionVO;
	}
	
	public TesAudCfgVO getTesAudCfgVO() {
		return tesAudCfgVO;
	}

	public void setTesAudCfgVO(TesAudCfgVO tesAudCfgVO) {
		this.tesAudCfgVO = tesAudCfgVO;
	}
	
	public TesAudCfgVO[] getTesAudCfgVOs() {
		TesAudCfgVO[] rtnVOs = null;
		if (this.TesAudCfgVOs != null) {
			rtnVOs = new TesAudCfgVO[TesAudCfgVOs.length];
			System.arraycopy(TesAudCfgVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setTesAudCfgVOs(TesAudCfgVO[] TesAudCfgVOs) {
		if(TesAudCfgVOs != null){
			TesAudCfgVO[] tmpVOs = Arrays.copyOf(TesAudCfgVOs, TesAudCfgVOs.length);
			this.TesAudCfgVOs = tmpVOs;
		}
	}
	
}
