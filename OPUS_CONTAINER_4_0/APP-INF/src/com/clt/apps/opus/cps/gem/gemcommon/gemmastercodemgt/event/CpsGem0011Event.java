/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem0011Event.java
 *@FileTitle : Expense Office Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.07
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.05.07 최정미
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.event;

import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.GemOfficeVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.OfficeMgtVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * CPS_GEM_0011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CPS_GEM_0011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author choijungmi
 * @see CPS_GEM_0011HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem0011Event extends EventSupport {

	private static final long serialVersionUID = 1L;
/*
	private String sch_app_div_gbn = "";

	public String getSch_app_div_gbn() {
		return sch_app_div_gbn;
	}

	public void setSch_app_div_gbn(String sch_app_div_gbn) {
		this.sch_app_div_gbn = sch_app_div_gbn;
	}
*/
	/** Table Value Object 조회 조건 및 단건 처리 */
	private GemOfficeVO gemOfficeVO = null;
	private OfficeMgtVO officeMgtVO = null;

	/** Table Value Object Multi Data 처리 */
	private GemOfficeVO[] gemOfficeVOs = null;
	private OfficeMgtVO[] officeMgtVOs = null;

	public CpsGem0011Event() {
	}

	public GemOfficeVO getGemOfficeVO() {
		return gemOfficeVO;
	}

	public void setGemOfficeVO(GemOfficeVO gemOfficeVO) {
		this.gemOfficeVO = gemOfficeVO;
	}

	public OfficeMgtVO getOfficeMgtVO() {
		return officeMgtVO;
	}

	public void setOfficeMgtVO(OfficeMgtVO officeMgtVO) {
		this.officeMgtVO = officeMgtVO;
	}

	public GemOfficeVO[] getGemOfficeVOs() {
		return gemOfficeVOs;
	}

	public void setGemOfficeVOs(GemOfficeVO[] gemOfficeVOs) {
		this.gemOfficeVOs = gemOfficeVOs;
	}

	public OfficeMgtVO[] getOfficeMgtVOs() {
		return officeMgtVOs;
	}

	public void setOfficeMgtVOs(OfficeMgtVO[] officeMgtVOs) {
		this.officeMgtVOs = officeMgtVOs;
	}

}