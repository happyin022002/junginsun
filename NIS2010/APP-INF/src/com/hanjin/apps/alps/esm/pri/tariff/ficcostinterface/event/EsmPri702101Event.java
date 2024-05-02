/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmPri702101Event.java
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

import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.AddOnCostTraiffListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_7021_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_702101HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author LEE EUN SUP
 * @see ESM_PRI_7021_01HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmPri702101Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String svcScpCd;
	
	private String rhq_cd;
	
	private String org_dest_tp_cd;

	private AddOnCostTraiffListVO[] addOnCostTraiffListVOs;

	public String getSvcScpCd() {
		return svcScpCd;
	}

	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
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

	public AddOnCostTraiffListVO[] getAddOnCostTraiffListVOs() {
		return addOnCostTraiffListVOs;
	}

	public void setAddOnCostTraiffListVOs(AddOnCostTraiffListVO[] addOnCostTraiffListVOs) {
		this.addOnCostTraiffListVOs = addOnCostTraiffListVOs;
	}

}
