/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_gem_0030.jsp
 *@FileTitle : Expense Code Maintenance for subsidiary
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.06
 *@LastModifier : 이준범
 *@LastVersion : 1.0
 * 2012.04.06 이준범
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event;

import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.OfficeMgtVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.SubsidiaryAccountMatrixInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * CPS_GEM_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CPS_GEM_0008_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author choijungmi
 * @see CPS_GEM_0008_01HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem0030Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private OfficeMgtVO officeMgtVO = null;

	/** Table Value Object Multi Data 처리 */
	private OfficeMgtVO[] officeMgtVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리 */
	private SubsidiaryAccountMatrixInfoVO SubsidiaryAccountMatrixInfoVO = null;

	/** Table Value Object Multi Data 처리 */
	private SubsidiaryAccountMatrixInfoVO[] SubsidiaryAccountMatrixInfoVOs = null;

	public CpsGem0030Event() {
	}

	public OfficeMgtVO getOfficeMgtVO() {
		return officeMgtVO;
	}

	public void setOfficeMgtVO(OfficeMgtVO officeMgtVO) {
		this.officeMgtVO = officeMgtVO;
	}

	public OfficeMgtVO[] getOfficeMgtVOs() {
		return officeMgtVOs;
	}

	public void setOfficeMgtVOs(OfficeMgtVO[] officeMgtVOs) {
		this.officeMgtVOs = officeMgtVOs;
	}
    
	public SubsidiaryAccountMatrixInfoVO getSubsidiaryAccountMatrixInfoVO() {
		return SubsidiaryAccountMatrixInfoVO;
	}

	public void setSubsidiaryAccountMatrixInfoVO(
			SubsidiaryAccountMatrixInfoVO subsidiaryAccountMatrixInfoVO) {
		SubsidiaryAccountMatrixInfoVO = subsidiaryAccountMatrixInfoVO;
	}

	public SubsidiaryAccountMatrixInfoVO[] getSubsidiaryAccountMatrixInfoVOs() {
		return SubsidiaryAccountMatrixInfoVOs;
	}

	public void setSubsidiaryAccountMatrixInfoVOs(
			SubsidiaryAccountMatrixInfoVO[] subsidiaryAccountMatrixInfoVOs) {
		SubsidiaryAccountMatrixInfoVOs = subsidiaryAccountMatrixInfoVOs;
	}
}