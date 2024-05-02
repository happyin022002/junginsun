/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : EsmPri2055Event.java
 *@FileTitle : RFA Proposal Creation - Rate [M/B]
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.04.20
 *@LastModifier : 전지예
 *@LastVersion : 1.0
 * 2015.04.20 전지예
 * 1.0 Creation
 =========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtRouteMBListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpScpRtVO;

/**
 * ESM_PRI_2055 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2055HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JEON JEE YE
 * @see ESM_PRI_2055HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri2055Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	private PriRpScpRtVO priRpScpRtVO = null;
	private RsltRtRouteMBListVO[] rsltRtRouteMBListVOs = null;
	
	private String orgDestTpCd;
	private String cntrTpszCd;
	private String fcntrEccCd;
	
	public EsmPri2055Event(){
		
	}
	
	/**
	 * @return the priRpScpRtVO
	 */
	public PriRpScpRtVO getPriRpScpRtVO() {
		return priRpScpRtVO;
	}

	/**
	 * @param priRpScpRtVO the priRpScpRtVO to set
	 */
	public void setPriRpScpRtVO(PriRpScpRtVO priRpScpRtVO) {
		this.priRpScpRtVO = priRpScpRtVO;
	}

	public RsltRtRouteMBListVO[] getRsltRtRouteMBListVOs() {
		RsltRtRouteMBListVO[] rtnVOs = null;
		if (this.rsltRtRouteMBListVOs != null) {
			rtnVOs = new RsltRtRouteMBListVO[rsltRtRouteMBListVOs.length];
			System.arraycopy(rsltRtRouteMBListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setRsltRtRouteMBListVOs(RsltRtRouteMBListVO[] rsltRtRouteMBListVOs){
		if(rsltRtRouteMBListVOs != null){
			RsltRtRouteMBListVO[] tmpVOs = new RsltRtRouteMBListVO[rsltRtRouteMBListVOs.length];
			System.arraycopy(rsltRtRouteMBListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltRtRouteMBListVOs = tmpVOs;
		}
	}

	public String getOrgDestTpCd() {
		return orgDestTpCd;
	}

	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}

	public String getCntrTpszCd() {
		return cntrTpszCd;
	}

	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	public String getFcntrEccCd() {
		return fcntrEccCd;
	}

	public void setFcntrEccCd(String fcntrEccCd) {
		this.fcntrEccCd = fcntrEccCd;
	}
	
}