/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem0110Event.java
 *@FileTitle : Expense Office Maintenance - Expense Matrix per Office
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.15
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.05.15 최정미
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.event;

import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.OfficeInfoVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.OfficeMgtVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * CPS_GEM_0110 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CPS_GEM_0110HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author choijungmi
 * @see CPS_GEM_0110HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem000802Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private OfficeInfoVO officeInfoVO = null;
	private OfficeMgtVO officeMgtVO = null;

	/** Table Value Object Multi Data 처리 */
	private OfficeInfoVO[] officeInfoVOs = null;
	private OfficeMgtVO[] officeMgtVOs = null;

	public CpsGem000802Event() {
	}

	public OfficeInfoVO getOfficeInfoVO() {
		return officeInfoVO;
	}

	public void setOfficeInfoVO(OfficeInfoVO officeInfoVO) {
		this.officeInfoVO = officeInfoVO;
	}

	public OfficeMgtVO getOfficeMgtVO() {
		return officeMgtVO;
	}

	public void setOfficeMgtVO(OfficeMgtVO officeMgtVO) {
		this.officeMgtVO = officeMgtVO;
	}

	public OfficeInfoVO[] getOfficeInfoVOs() {
		return officeInfoVOs;
	}

	public void setOfficeInfoVOs(OfficeInfoVO[] officeInfoVOs) {
		this.officeInfoVOs = officeInfoVOs;
	}

	public OfficeMgtVO[] getOfficeMgtVOs() {
		return officeMgtVOs;
	}

	public void setOfficeMgtVOs(OfficeMgtVO[] officeMgtVOs) {
		this.officeMgtVOs = officeMgtVOs;
	}

}