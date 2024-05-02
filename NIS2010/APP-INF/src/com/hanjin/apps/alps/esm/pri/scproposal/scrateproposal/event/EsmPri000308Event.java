/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UiPri0030Event.java
 *@FileTitle : Guideline MQC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.05.25 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRtCmdtListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRtListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.ScGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.ScRtPropCmdtVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.ScRtPropRtVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriSpScpRtVO;

/**
 * UI_PRI_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_0003_08HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri000308Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO = null;
	private PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO = null;
	private PriSpScpRtVO priSpScpRtVO = null;
	private PriSpScpRtCmdtHdrVO[] priSpScpRtCmdtHdrVOS = null;
	private PriSpScpRtCmdtRoutVO[] priSpScpRtCmdtRoutVOS = null;
	private PriSpScpRtVO[] priSpScpRtVOS = null;

	private RsltRtCmdtListVO rsltRtCmdtListVO = null;
	private RsltRtListVO rsltRtListVO = null;

	private ScRtPropCmdtVO scRtPropCmdtVO = null;
	private ScRtPropRtVO scRtPropRtVO = null;
	private ScGlineCopyVO scGlineCopyVO = null;
	
	private String propNo = null;
	private String amdtSeq = null;
	private String svcScpCd = null;
	private String genSpclRtTpCd = null;

	public EsmPri000308Event() {
	}

	public PriSpScpRtCmdtHdrVO getPriSpScpRtCmdtHdrVO() {
		return priSpScpRtCmdtHdrVO;
	}

	public void setPriSpScpRtCmdtHdrVO(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) {
		this.priSpScpRtCmdtHdrVO = priSpScpRtCmdtHdrVO;
	}

	public PriSpScpRtCmdtRoutVO getPriSpScpRtCmdtRoutVO() {
		return priSpScpRtCmdtRoutVO;
	}

	public void setPriSpScpRtCmdtRoutVO(PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO) {
		this.priSpScpRtCmdtRoutVO = priSpScpRtCmdtRoutVO;
	}

	public PriSpScpRtVO getPriSpScpRtVO() {
		return priSpScpRtVO;
	}

	public void setPriSpScpRtVO(PriSpScpRtVO priSpScpRtVO) {
		this.priSpScpRtVO = priSpScpRtVO;
	}

	public PriSpScpRtCmdtHdrVO[] getPriSpScpRtCmdtHdrVOS() {
		return priSpScpRtCmdtHdrVOS;
	}

	public void setPriSpScpRtCmdtHdrVOS(PriSpScpRtCmdtHdrVO[] priSpScpRtCmdtHdrVOS) {
		this.priSpScpRtCmdtHdrVOS = priSpScpRtCmdtHdrVOS;
	}

	public PriSpScpRtCmdtRoutVO[] getPriSpScpRtCmdtRoutVOS() {
		return priSpScpRtCmdtRoutVOS;
	}

	public void setPriSpScpRtCmdtRoutVOS(PriSpScpRtCmdtRoutVO[] priSpScpRtCmdtRoutVOS) {
		this.priSpScpRtCmdtRoutVOS = priSpScpRtCmdtRoutVOS;
	}

	public PriSpScpRtVO[] getPriSpScpRtVOS() {
		return priSpScpRtVOS;
	}

	public void setPriSpScpRtVOS(PriSpScpRtVO[] priSpScpRtVOS) {
		this.priSpScpRtVOS = priSpScpRtVOS;
	}

	public RsltRtCmdtListVO getRsltRtCmdtListVO() {
		return rsltRtCmdtListVO;
	}

	public void setRsltRtCmdtListVO(RsltRtCmdtListVO rsltRtCmdtListVO) {
		this.rsltRtCmdtListVO = rsltRtCmdtListVO;
	}

	public RsltRtListVO getRsltRtListVO() {
		return rsltRtListVO;
	}

	public void setRsltRtListVO(RsltRtListVO rsltRtListVO) {
		this.rsltRtListVO = rsltRtListVO;
	}

	public ScRtPropCmdtVO getScRtPropCmdtVO() {
		return scRtPropCmdtVO;
	}

	public void setScRtPropCmdtVO(ScRtPropCmdtVO scRtPropCmdtVO) {
		this.scRtPropCmdtVO = scRtPropCmdtVO;
	}

	public ScRtPropRtVO getScRtPropRtVO() {
		return scRtPropRtVO;
	}

	public void setScRtPropRtVO(ScRtPropRtVO scRtPropRtVO) {
		this.scRtPropRtVO = scRtPropRtVO;
	}

	public ScGlineCopyVO getScGlineCopyVO() {
		return scGlineCopyVO;
	}

	public void setScGlineCopyVO(ScGlineCopyVO scGlineCopyVO) {
		this.scGlineCopyVO = scGlineCopyVO;
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
	 * @return the genSpclRtTpCd
	 */
	public String getGenSpclRtTpCd() {
		return genSpclRtTpCd;
	}

	/**
	 * @param genSpclRtTpCd the genSpclRtTpCd to set
	 */
	public void setGenSpclRtTpCd(String genSpclRtTpCd) {
		this.genSpclRtTpCd = genSpclRtTpCd;
	}

}