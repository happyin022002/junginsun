/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem0013Event.java
 *@FileTitle : Expense Matrix per Office
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.13
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.05.13 최정미
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event;

import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.OfficeInfoVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.OfficeMgtVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * CPS_GEM_0013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CPS_GEM_0013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author choijungmi
 * @see CPS_GEM_0013HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem0013Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private OfficeInfoVO officeInfoVO = null;
	private OfficeMgtVO officeMgtVO = null;

	/** Table Value Object Multi Data 처리 */
	private OfficeInfoVO[] officeInfoVOs = null;
	private OfficeMgtVO[] officeMgtVOs = null;

	public CpsGem0013Event() {
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