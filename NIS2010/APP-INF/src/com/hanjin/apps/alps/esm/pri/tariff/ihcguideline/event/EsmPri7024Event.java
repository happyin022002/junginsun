/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmPri7024Event.java
 *@FileTitle : IHC  Tariff Creation & Amendment - Special POPUP
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.08
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event;

import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.IHCGuidelineMainVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_7024 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_7024HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author LEE EUN SUP
 * @see ESM_PRI_7024HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri7024Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private IHCGuidelineMainVO iHCGuidelineMainVO;

	public IHCGuidelineMainVO getiHCGuidelineMainVO() {
		return iHCGuidelineMainVO;
	}

	public void setiHCGuidelineMainVO(IHCGuidelineMainVO iHCGuidelineMainVO) {
		this.iHCGuidelineMainVO = iHCGuidelineMainVO;
	}
	
}
