/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : StmSco0100Event.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.OfficeInfoVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.OfficeComboListVO;

/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 StatementCommonSC로 실행요청<br>
 * - StatementCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author
 * @see StmSco0020Event 참조
 * @since J2EE 1.4
 */

public class StmSco0100Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private OfficeInfoVO[] officeInfoVOs = null;
	private OfficeComboListVO[] officeComboListVOs = null;

	private String mdmOfcCd = "";
	private String ofcEntrLvlCd = "";

	public String getMdmOfcCd() {
		return mdmOfcCd;
	}

	public void setOfcCd(String mdmOfcCd) {
		this.mdmOfcCd = mdmOfcCd;
	}

	public String getOfcEntrLvlCd() {
		return ofcEntrLvlCd;
	}

	public void setOfcEntrLvlCd(String ofcEntrLvlCd) {
		this.ofcEntrLvlCd = ofcEntrLvlCd;
	}

	public OfficeInfoVO[] getOfficeInfoVOs() {
		OfficeInfoVO[] rtnVOs = null;
		if (this.officeInfoVOs != null) {
			rtnVOs = new OfficeInfoVO[officeInfoVOs.length];
			System.arraycopy(officeInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setOfficeInfoVOs(OfficeInfoVO[] officeInfoVOs) {
		if (officeInfoVOs != null) {
			OfficeInfoVO[] tmpVOs = new OfficeInfoVO[officeInfoVOs.length];
			System.arraycopy(officeInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.officeInfoVOs = tmpVOs;
		}
	}

	public OfficeComboListVO[] getOfficeComboListVOs() {
		OfficeComboListVO[] rtnVOs = null;
		if (this.officeComboListVOs != null) {
			rtnVOs = new OfficeComboListVO[officeComboListVOs.length];
			System.arraycopy(officeComboListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setOfficeComboListVOs(OfficeComboListVO[] officeComboListVOs) {
		if (officeComboListVOs != null) {
			OfficeComboListVO[] tmpVOs = new OfficeComboListVO[officeComboListVOs.length];
			System.arraycopy(officeComboListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.officeComboListVOs = tmpVOs;
		}
	}

}