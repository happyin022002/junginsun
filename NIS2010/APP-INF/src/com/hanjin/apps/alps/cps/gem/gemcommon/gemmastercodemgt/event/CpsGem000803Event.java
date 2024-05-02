/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem000803Event.java
 *@FileTitle : Expense Office Maintenance –Office Matrix per Office
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.05.13 최정미
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event;

import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.OfficeExptVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.OfficeMgtVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * CPS_GEM_0008_03 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CPS_GEM_0008_03HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author choijungmi
 * @see CPS_GEM_0008_03HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem000803Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private OfficeExptVO officeExptVO = null;
	private OfficeMgtVO officeMgtVO = null;

	/** Table Value Object Multi Data 처리 */
	private OfficeExptVO[] officeExptVOs = null;
	private OfficeMgtVO[] officeMgtVOs = null;

	public OfficeExptVO getOfficeExptVO() {
		return officeExptVO;
	}

	public void setOfficeExptVO(OfficeExptVO officeExptVO) {
		this.officeExptVO = officeExptVO;
	}

	public OfficeMgtVO getOfficeMgtVO() {
		return officeMgtVO;
	}

	public void setOfficeMgtVO(OfficeMgtVO officeMgtVO) {
		this.officeMgtVO = officeMgtVO;
	}

	public OfficeExptVO[] getOfficeExptVOs() {
		return officeExptVOs;
	}

	public void setOfficeExptVOs(OfficeExptVO[] officeExptVOs) {
		this.officeExptVOs = officeExptVOs;
	}

	public OfficeMgtVO[] getOfficeMgtVOs() {
		return officeMgtVOs;
	}

	public void setOfficeMgtVOs(OfficeMgtVO[] officeMgtVOs) {
		this.officeMgtVOs = officeMgtVOs;
	}

}