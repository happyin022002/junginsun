/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri200307Event.java
 *@FileTitle : RFA Proposal Creation - Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.21
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.08.21 박성수
 * 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RfaGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropCmdtVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropRtVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCmdtListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriRpScpRtVO;

/**
 * UI_PRI_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_2003_07HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri200307Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO = null;
	private PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO = null;
	private PriRpScpRtVO priRpScpRtVO = null;
	private PriRpScpRtCmdtHdrVO[] priRpScpRtCmdtHdrVOS = null;
	private PriRpScpRtCmdtRoutVO[] priRpScpRtCmdtRoutVOS = null;
	private PriRpScpRtVO[] priRpScpRtVOS = null;

	private RsltRtCmdtListVO rsltRtCmdtListVO = null;
	private RsltRtListVO rsltRtListVO = null;

	private RfaRtPropCmdtVO rfaRtPropCmdtVO = null;
	private RfaRtPropRtVO rfaRtPropRtVO = null;
	private RfaGlineCopyVO rfaGlineCopyVO = null;
	
	private String propNo = null;
	private String amdtSeq = null;
	private String svcScpCd = null;
	private String ficRtTpCd = null;

	public EsmPri200307Event() {
	}

	/**
	 * @return the priRpScpRtCmdtHdrVO
	 */
	public PriRpScpRtCmdtHdrVO getPriRpScpRtCmdtHdrVO() {
		return priRpScpRtCmdtHdrVO;
	}

	/**
	 * @param priRpScpRtCmdtHdrVO the priRpScpRtCmdtHdrVO to set
	 */
	public void setPriRpScpRtCmdtHdrVO(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) {
		this.priRpScpRtCmdtHdrVO = priRpScpRtCmdtHdrVO;
	}

	/**
	 * @return the priRpScpRtCmdtRoutVO
	 */
	public PriRpScpRtCmdtRoutVO getPriRpScpRtCmdtRoutVO() {
		return priRpScpRtCmdtRoutVO;
	}

	/**
	 * @param priRpScpRtCmdtRoutVO the priRpScpRtCmdtRoutVO to set
	 */
	public void setPriRpScpRtCmdtRoutVO(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) {
		this.priRpScpRtCmdtRoutVO = priRpScpRtCmdtRoutVO;
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

	/**
	 * @return the priRpScpRtCmdtHdrVOS
	 */
	public PriRpScpRtCmdtHdrVO[] getPriRpScpRtCmdtHdrVOS() {
		PriRpScpRtCmdtHdrVO[] rtnVOs = null;
		if (this.priRpScpRtCmdtHdrVOS != null) {
			rtnVOs = new PriRpScpRtCmdtHdrVO[priRpScpRtCmdtHdrVOS.length];
			System.arraycopy(priRpScpRtCmdtHdrVOS, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param priRpScpRtCmdtHdrVOS the priRpScpRtCmdtHdrVOS to set
	 */
	public void setPriRpScpRtCmdtHdrVOS(PriRpScpRtCmdtHdrVO[] priRpScpRtCmdtHdrVOS){
		if(priRpScpRtCmdtHdrVOS != null){
			PriRpScpRtCmdtHdrVO[] tmpVOs = new PriRpScpRtCmdtHdrVO[priRpScpRtCmdtHdrVOS.length];
			System.arraycopy(priRpScpRtCmdtHdrVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtCmdtHdrVOS = tmpVOs;
		}
	}

	/**
	 * @return the priRpScpRtCmdtRoutVOS
	 */
	public PriRpScpRtCmdtRoutVO[] getPriRpScpRtCmdtRoutVOS() {
		PriRpScpRtCmdtRoutVO[] rtnVOs = null;
		if (this.priRpScpRtCmdtRoutVOS != null) {
			rtnVOs = new PriRpScpRtCmdtRoutVO[priRpScpRtCmdtRoutVOS.length];
			System.arraycopy(priRpScpRtCmdtRoutVOS, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param priRpScpRtCmdtRoutVOS the priRpScpRtCmdtRoutVOS to set
	 */
	public void setPriRpScpRtCmdtRoutVOS(PriRpScpRtCmdtRoutVO[] priRpScpRtCmdtRoutVOS){
		if(priRpScpRtCmdtRoutVOS != null){
			PriRpScpRtCmdtRoutVO[] tmpVOs = new PriRpScpRtCmdtRoutVO[priRpScpRtCmdtRoutVOS.length];
			System.arraycopy(priRpScpRtCmdtRoutVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtCmdtRoutVOS = tmpVOs;
		}
	}

	/**
	 * @return the priRpScpRtVOS
	 */
	public PriRpScpRtVO[] getPriRpScpRtVOS() {
		PriRpScpRtVO[] rtnVOs = null;
		if (this.priRpScpRtVOS != null) {
			rtnVOs = new PriRpScpRtVO[priRpScpRtVOS.length];
			System.arraycopy(priRpScpRtVOS, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param priRpScpRtVOS the priRpScpRtVOS to set
	 */
	public void setPriRpScpRtVOS(PriRpScpRtVO[] priRpScpRtVOS){
		if(priRpScpRtVOS != null){
			PriRpScpRtVO[] tmpVOs = new PriRpScpRtVO[priRpScpRtVOS.length];
			System.arraycopy(priRpScpRtVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtVOS = tmpVOs;
		}
	}

	/**
	 * @return the rsltRtCmdtListVO
	 */
	public RsltRtCmdtListVO getRsltRtCmdtListVO() {
		return rsltRtCmdtListVO;
	}

	/**
	 * @param rsltRtCmdtListVO the rsltRtCmdtListVO to set
	 */
	public void setRsltRtCmdtListVO(RsltRtCmdtListVO rsltRtCmdtListVO) {
		this.rsltRtCmdtListVO = rsltRtCmdtListVO;
	}

	/**
	 * @return the rsltRtListVO
	 */
	public RsltRtListVO getRsltRtListVO() {
		return rsltRtListVO;
	}

	/**
	 * @param rsltRtListVO the rsltRtListVO to set
	 */
	public void setRsltRtListVO(RsltRtListVO rsltRtListVO) {
		this.rsltRtListVO = rsltRtListVO;
	}

	/**
	 * @return the rfaRtPropCmdtVO
	 */
	public RfaRtPropCmdtVO getRfaRtPropCmdtVO() {
		return rfaRtPropCmdtVO;
	}

	/**
	 * @param rfaRtPropCmdtVO the rfaRtPropCmdtVO to set
	 */
	public void setRfaRtPropCmdtVO(RfaRtPropCmdtVO rfaRtPropCmdtVO) {
		this.rfaRtPropCmdtVO = rfaRtPropCmdtVO;
	}

	/**
	 * @return the rfaRtPropRtVO
	 */
	public RfaRtPropRtVO getRfaRtPropRtVO() {
		return rfaRtPropRtVO;
	}

	/**
	 * @param rfaRtPropRtVO the rfaRtPropRtVO to set
	 */
	public void setRfaRtPropRtVO(RfaRtPropRtVO rfaRtPropRtVO) {
		this.rfaRtPropRtVO = rfaRtPropRtVO;
	}

	/**
	 * @return the rfaGlineCopyVO
	 */
	public RfaGlineCopyVO getRfaGlineCopyVO() {
		return rfaGlineCopyVO;
	}

	/**
	 * @param rfaGlineCopyVO the rfaGlineCopyVO to set
	 */
	public void setRfaGlineCopyVO(RfaGlineCopyVO rfaGlineCopyVO) {
		this.rfaGlineCopyVO = rfaGlineCopyVO;
	}

	/**
	 * @return the propNo
	 */
	public String getPropNo() {
		return propNo;
	}

	/**
	 * @param propNo the propNo to set
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}

	/**
	 * @return the amdtSeq
	 */
	public String getAmdtSeq() {
		return amdtSeq;
	}

	/**
	 * @param amdtSeq the amdtSeq to set
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}

	/**
	 * @return the svcScpCd
	 */
	public String getSvcScpCd() {
		return svcScpCd;
	}

	/**
	 * @param svcScpCd the svcScpCd to set
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}

	/**
	 * @return the ficRtTpCd
	 */
	public String getFicRtTpCd() {
		return ficRtTpCd;
	}

	/**
	 * @param ficRtTpCd the ficRtTpCd to set
	 */
	public void setFicRtTpCd(String ficRtTpCd) {
		this.ficRtTpCd = ficRtTpCd;
	}
	
	

}