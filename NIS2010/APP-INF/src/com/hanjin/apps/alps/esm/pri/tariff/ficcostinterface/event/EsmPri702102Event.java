/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmPri702102Event.java
 *@FileTitle : Cost Table Interface - Add-on Tariff  TAB
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.5.08
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 * 2012.5.08 이은섭
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.event;

import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.IHCCostTariffInterfaceListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_7021_02 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_702102HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author LEE EUN SUP
 * @see ESM_PRI_7021_02HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmPri702102Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String svcScpCd;

	private String cntCd;
	
	private String rhq_cd;
	
	private String org_dest_tp_cd;
	
	private IHCCostTariffInterfaceListVO[] ihcCostTariffInterfaceListVOs;

	
	
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

}
