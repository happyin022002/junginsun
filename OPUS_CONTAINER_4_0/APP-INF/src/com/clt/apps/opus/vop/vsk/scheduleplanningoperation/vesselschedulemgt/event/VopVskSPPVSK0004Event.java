/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0027Event.java
*@FileTitle : Actual SKD Report Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.07.28 정진우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdMgtVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByVvdVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * SPP에서 입력한 Feeder VVD를 이용해 Feeder Schedule 조회
 *
 * @author 서창열
 * @see spp_vsk_0004HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVskSPPVSK0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstSkdByVvdVO cstSkdByVvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CstSkdByVvdVO[] cstSkdByVvdVOs = null;
	
	private List<CstSkdByVvdVO> cstSkdByVvdVOS = null;

	public VopVskSPPVSK0004Event(){
		cstSkdByVvdVO = new CstSkdByVvdVO();
		cstSkdByVvdVOS = new ArrayList<CstSkdByVvdVO>();
	}

	/**
	 * @return the cstSkdByVvdVO
	 */
	public CstSkdByVvdVO getCstSkdByVvdVO() {
		return cstSkdByVvdVO;
	}

	/**
	 * @param cstSkdByVvdVO the CstSkdByVvdVO to set
	 */
	public void setCstSkdByVvdVO(CstSkdByVvdVO cstSkdByVvdVO) {
		this.cstSkdByVvdVO = cstSkdByVvdVO;
	}

	/**
	 * @return the cstSkdByVvdVOs
	 */
	public CstSkdByVvdVO[] getCstSkdByVvdVOs() {
		CstSkdByVvdVO[] rtnVOs = null;
		if (this.cstSkdByVvdVOs != null) {
			rtnVOs = Arrays.copyOf(this.cstSkdByVvdVOs, this.cstSkdByVvdVOs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param cstSkdByVvdVOs the CstSkdByVvdVO to set
	 */
	public void setCstSkdByVvdVOs(CstSkdByVvdVO[] cstSkdByVvdVOs) {
		if (cstSkdByVvdVOs != null) {
			CstSkdByVvdVO[] tmpVOs = Arrays.copyOf(cstSkdByVvdVOs, cstSkdByVvdVOs.length);
			this.cstSkdByVvdVOs = tmpVOs;
		} // end if
	}
}