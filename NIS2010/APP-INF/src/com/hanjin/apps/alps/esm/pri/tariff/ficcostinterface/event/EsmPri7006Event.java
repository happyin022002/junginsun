/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmPri7006Event.java
 *@FileTitle : IHC(Barge/Rail/Truck) tariff copying to other trade
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.10.11
 *@LastModifier : 서미진
 *@LastVersion : 1.0
 * 2012.10.11 서미진
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.event;

import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.CheckCopyServiceScopeVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.CopyTariffIhcVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.IHCCostTariffInterfaceListVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.IHCGuidelineMainVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_7006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_7006HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author CHLOE MIJIN SEO
 * @see ESM_PRI_7006HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmPri7006Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String svcScpCd;

	private String cntCd;
	
	private String rhq_cd;
	
	private String org_dest_tp_cd;
	
	private IHCCostTariffInterfaceListVO[] ihcCostTariffInterfaceListVOs;
	
	private CheckCopyServiceScopeVO checkCopyServiceScopeVO;
	
	private CheckCopyServiceScopeVO[] checkCopyServiceScopeVOs;
	
	private CopyTariffIhcVO[] copyTariffIhcVOs;

	private IHCGuidelineMainVO[] iHCGuidelineMainVOs;

	public String getSvcScpCd() {
		return svcScpCd;
	}

	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}

	public String getCntCd() {
		return cntCd;
	}

	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}

	public String getRhq_cd() {
		return rhq_cd;
	}

	public void setRhq_cd(String rhqCd) {
		rhq_cd = rhqCd;
	}

	public String getOrg_dest_tp_cd() {
		return org_dest_tp_cd;
	}

	public void setOrg_dest_tp_cd(String orgDestTpCd) {
		org_dest_tp_cd = orgDestTpCd;
	}

	public IHCCostTariffInterfaceListVO[] getIhcCostTariffInterfaceListVOs() {
		return ihcCostTariffInterfaceListVOs;
	}

	public void setIhcCostTariffInterfaceListVOs(IHCCostTariffInterfaceListVO[] ihcCostTariffInterfaceListVOs) {
		this.ihcCostTariffInterfaceListVOs = ihcCostTariffInterfaceListVOs;
	}

	public CheckCopyServiceScopeVO getCheckCopyServiceScopeVO() {
		return checkCopyServiceScopeVO;
	}

	public void setCheckCopyServiceScopeVO(
			CheckCopyServiceScopeVO checkCopyServiceScopeVO) {
		this.checkCopyServiceScopeVO = checkCopyServiceScopeVO;
	}

	public CheckCopyServiceScopeVO[] getCheckCopyServiceScopeVOs() {
		return checkCopyServiceScopeVOs;
	}

	public void setCheckCopyServiceScopeVOs(
			CheckCopyServiceScopeVO[] checkCopyServiceScopeVOs) {
		this.checkCopyServiceScopeVOs = checkCopyServiceScopeVOs;
	}

	public CopyTariffIhcVO[] getCopyTariffIhcVOs() {
		return copyTariffIhcVOs;
	}

	public void setCopyTariffIhcVOs(CopyTariffIhcVO[] copyTariffIhcVOs) {
		this.copyTariffIhcVOs = copyTariffIhcVOs;
	}

	public IHCGuidelineMainVO[] getiHCGuidelineMainVOs() {
		return iHCGuidelineMainVOs;
	}

	public void setiHCGuidelineMainVOs(IHCGuidelineMainVO[] iHCGuidelineMainVOs) {
		this.iHCGuidelineMainVOs = iHCGuidelineMainVOs;
	}

}
