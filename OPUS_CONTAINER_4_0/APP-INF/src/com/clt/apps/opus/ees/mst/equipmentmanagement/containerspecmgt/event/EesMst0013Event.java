/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EesMst0013Event.java
 *@FileTitle : Equipment Organization Chart
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.28
 *@LastModifier : 김석준
 *@LastVersion : 1.0
 * 2009.04.28 김석준
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.event;

import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.EqOrgSccVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.EqOrgYardVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_MST_0013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_MST_0013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Suk Jun Kim
 * @see EES_MST_0013HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesMst0013Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private EqOrgSccVO mdmEqOrzChtVO = null;

	/** Table Value Object Multi Data 처리 */
	private EqOrgSccVO[] mdmEqOrzChtVOs = null;

	private EqOrgYardVO eqOrgYardVO = null;
	private EqOrgYardVO[] eqOrgYardVOs = null;

	public EqOrgYardVO getEqOrgYardVO() {
		return eqOrgYardVO;
	}

	public void setEqOrgYardVO(EqOrgYardVO eqOrgYardVO) {
		this.eqOrgYardVO = eqOrgYardVO;
	}

	public EqOrgYardVO[] getEqOrgYardVOs() {
		EqOrgYardVO[] tmpVOs = null;
		if (this.eqOrgYardVOs != null) {
			tmpVOs = new EqOrgYardVO[eqOrgYardVOs.length];
			System.arraycopy(eqOrgYardVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;

	}

	public void setEqOrgYardVOs(
			EqOrgYardVO[] eqOrgYardVOs) {
		  if (eqOrgYardVOs != null) {
			  EqOrgYardVO[] tmpVOs = new EqOrgYardVO[eqOrgYardVOs.length];
			  System.arraycopy(eqOrgYardVOs, 0, tmpVOs, 0, tmpVOs.length);
			  this.eqOrgYardVOs = tmpVOs;		
		  }
	}

	public EesMst0013Event() {
	}

	public void setMdmEqOrzChtVO(EqOrgSccVO mdmEqOrzChtVO) {
		this.mdmEqOrzChtVO = mdmEqOrzChtVO;
	}

	public void setMdmEqOrzChtVOS(EqOrgSccVO[] mdmEqOrzChtVOs){
		  if (mdmEqOrzChtVOs != null) {
			  EqOrgSccVO[] tmpVOs = new EqOrgSccVO[mdmEqOrzChtVOs.length];
			   System.arraycopy(mdmEqOrzChtVOs, 0, tmpVOs, 0, tmpVOs.length);
			   this.mdmEqOrzChtVOs = tmpVOs;
		  }
	}

	public EqOrgSccVO getMdmEqOrzChtVO() {
		return mdmEqOrzChtVO;
	}

	public EqOrgSccVO[] getMdmEqOrzChtVOS() {
		EqOrgSccVO[] tmpVOs = null;
		if (this.mdmEqOrzChtVOs != null) {
			tmpVOs = new EqOrgSccVO[mdmEqOrzChtVOs.length];
			System.arraycopy(mdmEqOrzChtVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;

	}

}