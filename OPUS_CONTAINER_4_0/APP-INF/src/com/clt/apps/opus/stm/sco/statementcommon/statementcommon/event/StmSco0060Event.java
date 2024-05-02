/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : StmSco0060Event.java
 *@FileTitle : AR Finance Direction Conversion
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.10.15
 *@LastModifier : Yoo
 *@LastVersion : 1.0
 * 2011.03.10 Yoo
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event;

import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.RevenuePortEachLaneVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 StatementCommonSC로 실행요청<br>
 * - StatementCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSco0060Event 참조
 * @since J2EE 1.4
 */
public class StmSco0060Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Slane Code */
	private String slanCd = "";

	/** Revenue Lane Direction code */
	private String rlaneCd = "";

	/** Sconti code */
	private String scontiCd = "";

	/** Revenue Port */
	private String revPortCd = "";

	/** Table Value Object 조회 조건 및 단건 처리 */
	private RevenuePortEachLaneVO revenuePortEachLaneVO = null;

	/** Table Value Object Multi Data 처리 */
	private RevenuePortEachLaneVO[] revenuePortEachLaneVOs = null;

	public String getScontiCd() {
		return scontiCd;
	}

	public void setScontiCd(String scontiCd) {
		this.scontiCd = scontiCd;
	}

	public String getRlaneCd() {
		return rlaneCd;
	}

	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}

	public String getSlanCd() {
		return slanCd;
	}

	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}

	public RevenuePortEachLaneVO getRevenuePortEachLaneVO() {
		return revenuePortEachLaneVO;
	}

	public void setRevenuePortEachLaneVO(
			RevenuePortEachLaneVO revenuePortEachLaneVO) {
		this.revenuePortEachLaneVO = revenuePortEachLaneVO;
		
	}

	public RevenuePortEachLaneVO[] getRevenuePortEachLaneVOs() {
		RevenuePortEachLaneVO[] rtnVOs = null;
		if (this.revenuePortEachLaneVOs != null) {
			rtnVOs = new RevenuePortEachLaneVO[revenuePortEachLaneVOs.length];
			System.arraycopy(revenuePortEachLaneVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setRevenuePortEachLaneVOs(
			RevenuePortEachLaneVO[] revenuePortEachLaneVOs) {
		if (revenuePortEachLaneVOs != null) {
			RevenuePortEachLaneVO[] tmpVOs = new RevenuePortEachLaneVO[revenuePortEachLaneVOs.length];
			System.arraycopy(revenuePortEachLaneVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.revenuePortEachLaneVOs = tmpVOs;
		}
	}

	public String getRevPortCd() {
		return revPortCd;
	}

	public void setRevPortCd(String revPortCd) {
		this.revPortCd = revPortCd;
	}

}
