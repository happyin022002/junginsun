/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmPri7007Event.java
 *@FileTitle : Add-on(Ocean Feeder) tariff copying to other trade
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.10.11
 *@LastModifier : 서미진
 *@LastVersion : 1.0
 * 2012.10.11 서미진
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.event;

import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.FDRMainVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.CheckFDRCopyServiceScopeVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.CopyTariffFdrVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_7007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_7007HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author CHLOE MIJIN SEO
 * @see ESM_PRI_7007HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmPri7007Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private CheckFDRCopyServiceScopeVO checkFDRCopyServiceScopeVO;
	
	private CheckFDRCopyServiceScopeVO[] checkFDRCopyServiceScopeVOs;

	private FDRMainVO[] fDRMainVOs;

	private CopyTariffFdrVO[] copyTariffFdrVOs;

	
	
	public CheckFDRCopyServiceScopeVO getCheckFDRCopyServiceScopeVO() {
		return checkFDRCopyServiceScopeVO;
	}

	public void setCheckFDRCopyServiceScopeVO(
			CheckFDRCopyServiceScopeVO checkFDRCopyServiceScopeVO) {
		this.checkFDRCopyServiceScopeVO = checkFDRCopyServiceScopeVO;
	}

	public CheckFDRCopyServiceScopeVO[] getCheckFDRCopyServiceScopeVOs() {
		return checkFDRCopyServiceScopeVOs;
	}

	public void setCheckFDRCopyServiceScopeVOs(
			CheckFDRCopyServiceScopeVO[] checkFDRCopyServiceScopeVOs) {
		this.checkFDRCopyServiceScopeVOs = checkFDRCopyServiceScopeVOs;
	}

	public FDRMainVO[] getfDRMainVOs() {
		return fDRMainVOs;
	}

	public void setfDRMainVOs(FDRMainVO[] fDRMainVOs) {
		this.fDRMainVOs = fDRMainVOs;
	}

	public CopyTariffFdrVO[] getCopyTariffFdrVOs() {
		return copyTariffFdrVOs;
	}

	public void setCopyTariffFdrVOs(CopyTariffFdrVO[] copyTariffFdrVOs) {
		this.copyTariffFdrVOs = copyTariffFdrVOs;
	}

}
