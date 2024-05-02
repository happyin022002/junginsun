/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FnsJoo0091Event.java
*@FileTitle : BSA Information Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.13
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2010.12.13 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event;

import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.BsaInformationEntryVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CusBzcAgmtVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0091 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0091HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0091HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0091Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BsaInformationEntryVO bsaInformationEntryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BsaInformationEntryVO[] bsaInformationEntryVOs = null;

	public FnsJoo0091Event(){}

	public BsaInformationEntryVO getBsaInformationEntryVO() {
		return bsaInformationEntryVO;
	}

	public void setBsaInformationEntryVO(BsaInformationEntryVO bsaInformationEntryVO) {
		this.bsaInformationEntryVO = bsaInformationEntryVO;
	}

	public BsaInformationEntryVO[] getBsaInformationEntryVOs() {
		BsaInformationEntryVO[] rtnVOs = null;
		if (this.bsaInformationEntryVOs != null) {
			rtnVOs = new BsaInformationEntryVO[bsaInformationEntryVOs.length];
			System.arraycopy(bsaInformationEntryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	public void setBsaInformationEntryVOs(
			BsaInformationEntryVO[] bsaInformationEntryVOs) {
		if (bsaInformationEntryVOs != null) {
			BsaInformationEntryVO[] tmpVOs = new BsaInformationEntryVO[bsaInformationEntryVOs.length];
			System.arraycopy(bsaInformationEntryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bsaInformationEntryVOs = tmpVOs;
		}		
	}
}