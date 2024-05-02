/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0428Event.java
*@FileTitle : Territories Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.05.04 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.event;

import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.CimTerritoryVO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.MdmCountryVO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.MdmOrganizationVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CTM_0428 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CTM_0428HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see EES_CTM_0428HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesCtm0428Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CimTerritoryVO cimTerritoryVO = null;

	/** Table Value Object Multi Data 처리 */
	private CimTerritoryVO[] cimTerritoryVOs = null;

	/** Table Value Object 조회 조건 처리  */
	private MdmCountryVO mdmCountryVO = null;

	/** Table Value Object 조회 조건 처리  */
	private MdmOrganizationVO mdmOrganizationVO = null;

	public EesCtm0428Event(){}

	public void setCimTerritoryVO(CimTerritoryVO cimTerritoryVO){
		this. cimTerritoryVO = cimTerritoryVO;
	}

	public void setCimTerritoryVOS(CimTerritoryVO[] cimTerritoryVOs){
		if (cimTerritoryVOs != null) {
			CimTerritoryVO[] tmpVOs = new CimTerritoryVO[cimTerritoryVOs.length];
			System.arraycopy(cimTerritoryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cimTerritoryVOs = tmpVOs;
		}
	}

	public void setMdmCountryVO(MdmCountryVO mdmCountryVO){
		this. mdmCountryVO = mdmCountryVO;
	}

	public void setMdmOrganizationVO(MdmOrganizationVO mdmOrganizationVO){
		this. mdmOrganizationVO = mdmOrganizationVO;
	}

	public CimTerritoryVO getCimTerritoryVO(){
		return cimTerritoryVO;
	}

	public CimTerritoryVO[] getCimTerritoryVOS(){
		CimTerritoryVO[] tmpVOs = null;
		if (this.cimTerritoryVOs != null) {
			tmpVOs = new CimTerritoryVO[cimTerritoryVOs.length];
			System.arraycopy(cimTerritoryVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public MdmCountryVO getMdmCountryVO(){
		return mdmCountryVO;
	}

	public MdmOrganizationVO getMdmOrganizationVO(){
		return mdmOrganizationVO;
	}

}