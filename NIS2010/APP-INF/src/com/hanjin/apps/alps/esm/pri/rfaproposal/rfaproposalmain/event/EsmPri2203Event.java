/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri2003Event.java
 *@FileTitle : Proposal & Amendment Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.08
 *@LastModifier : 변영주
 *@LastVersion : 1.0
 * 2009.05.08 변영주
 * 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.CstApprovalVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.PriRpComVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropMnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropProgVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RfaGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropCmdtVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropRtVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RfaSummryAcceptAllVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltCnoteNoteConvListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRoutHdrSmryListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCmdtListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SchSaleLeadVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriRpDmdtVO;
import com.hanjin.syscommon.common.table.PriRpHdrVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpProgVO;
import com.hanjin.syscommon.common.table.PriRpScpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriRpScpDurVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpProgVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRnoteVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriRpScpRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriRpScpRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriRpScpRtVO;

/**
 * ESM_PRI_2003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_2003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Byeon Young Joo
 * @see ESM_PRI_2003HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri2203Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String saleLeadOri = "";

	private String cpPriMnFlag = "";

	public String getSaleLeadOri() {
		return saleLeadOri;
	}

	public void setSaleLeadOri(String saleLeadOri) {
		this.saleLeadOri = saleLeadOri;
	}

	/** Table Value Object 조회 조건 및 단건 처리 */
	private CstApprovalVO cstApprovalVO = null;

	public CstApprovalVO getCstApprovalVO() {
		return cstApprovalVO;
	}

	public void setCstApprovalVO(CstApprovalVO cstApprovalVO) {
		this.cstApprovalVO = cstApprovalVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리 */
	private SchSaleLeadVO schSaleLeadVO = null;

	public SchSaleLeadVO getSchSaleLeadVO() {
		return schSaleLeadVO;
	}

	public void setSchSaleLeadVO(SchSaleLeadVO schSaleLeadVO) {
		this.schSaleLeadVO = schSaleLeadVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriRpMnVO priRpMnVO = null;

	/** Table Value Object Multi Data 처리 */
	private PriRpMnVO[] priRpMnVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriRpScpMnVO priRpScpMnVO = null;

	/** Table Value Object Multi Data 처리 */
	private PriRpScpMnVO[] priRpScpMnVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriRpHdrVO priRpHdrVO = null;

	/** Table Value Object Multi Data 처리 */
	private PriRpHdrVO[] priRpHdrVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriRpAmdtSmryVO priRpAmdtSmryVO = null;

	/** Table Value Object Multi Data 처리 */
	private PriRpAmdtSmryVO[] priRpAmdtSmryVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriRpProgVO priRpProgVO = null;

	/** Table Value Object Multi Data 처리 */
	private PriRpProgVO[] priRpProgVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriRpScpProgVO priRpScpProgVO = null;

	/** Table Value Object Multi Data 처리 */
	private PriRpScpProgVO[] priRpScpProgVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriRpScpAmdtSmryVO priRpScpAmdtSmryVO = null;

	/** Table Value Object Multi Data 처리 */
	private PriRpScpAmdtSmryVO[] priRpScpAmdtSmryVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriRpScpDurVO priRpScpDurVO = null;

	/** Table Value Object Multi Data 처리 */
	private PriRpScpDurVO[] priRpScpDurVOs = null;

	/** PRI Rate 공통 변수로 사용 */
	private PriRpComVO priRpComVO = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private RfaPropMnVO rfaPropMnVO = null;

	private RfaPropProgVO rfaPropProgVO = null;
	
	/** Main 정보 이외의 탭 정보 **/
	
	private PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO = null;
	private PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO = null;
	private PriRpScpRtVO priRpScpRtVO = null;
	private PriRpScpRtCmdtHdrVO[] priRpScpRtCmdtHdrVOS = null;
	private PriRpScpRtCmdtRoutVO[] priRpScpRtCmdtRoutVOS = null;
	private PriRpScpRtVO[] priRpScpRtVOS = null;

	private RsltRoutHdrSmryListVO rsltRoutHdrSmryListVO = null;
	private RsltRtCmdtListVO rsltRtCmdtListVO = null;
	private RsltRtListVO rsltRtListVO = null;

	private RfaRtPropCmdtVO rfaRtPropCmdtVO = null;
	private RfaRtPropRtVO rfaRtPropRtVO = null;
	private RfaGlineCopyVO rfaGlineCopyVO = null;
	
	private RfaSummryAcceptAllVO rfaSummryAcceptAllVO = null;

	private PriRpScpRtCmdtRnoteVO[] priRpScpRtCmdtRnoteVOS = null;
	
	private PriRpScpRtRoutPntVO[] priRpScpRtRoutOrgPntVO = null;
	private PriRpScpRtRoutViaVO[] priRpScpRtRoutOrgViaVO = null;
	private PriRpScpRtRoutViaVO[] priRpScpRtRoutDestViaVO = null;
	private PriRpScpRtRoutPntVO[] priRpScpRtRoutDestPntVO = null;
	
	private String propNo = null;
	private String amdtSeq = null;
	private String svcScpCd = null;
	private String ficRtTpCd = null;
	private String noteConvMapgId = null;
	
	public EsmPri2203Event() {
	}

	public void setRfaPropMnVO(RfaPropMnVO rfaPropMnVO) {
		this.rfaPropMnVO = rfaPropMnVO;
	}

	public void setRfaPropProgVO(RfaPropProgVO rfaPropProgVO) {
		this.rfaPropProgVO = rfaPropProgVO;
	}

	public void setPriRpMnVO(PriRpMnVO priRpMnVO) {
		this.priRpMnVO = priRpMnVO;
	}

	public void setPriRpMnVOS(PriRpMnVO[] priRpMnVOs){
		if(priRpMnVOs != null){
			PriRpMnVO[] tmpVOs = new PriRpMnVO[priRpMnVOs.length];
			System.arraycopy(priRpMnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpMnVOs = tmpVOs;
		}
	}

	public void setPriRpScpMnVO(PriRpScpMnVO priRpScpMnVO) {
		this.priRpScpMnVO = priRpScpMnVO;
	}

	public void setPriRpScpMnVOS(PriRpScpMnVO[] priRpScpMnVOs){
		if(priRpScpMnVOs != null){
			PriRpScpMnVO[] tmpVOs = new PriRpScpMnVO[priRpScpMnVOs.length];
			System.arraycopy(priRpScpMnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpMnVOs = tmpVOs;
		}
	}

	public void setPriRpHdrVO(PriRpHdrVO priRpHdrVO) {
		this.priRpHdrVO = priRpHdrVO;
	}

	public void setPriRpHdrVOS(PriRpHdrVO[] priRpHdrVOs){
		if(priRpHdrVOs != null){
			PriRpHdrVO[] tmpVOs = new PriRpHdrVO[priRpHdrVOs.length];
			System.arraycopy(priRpHdrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpHdrVOs = tmpVOs;
		}
	}

	public void setPriRpAmdtSmryVO(PriRpAmdtSmryVO priRpAmdtSmryVO) {
		this.priRpAmdtSmryVO = priRpAmdtSmryVO;
	}

	public void setPriRpAmdtSmryVOS(PriRpAmdtSmryVO[] priRpAmdtSmryVOs){
		if(priRpAmdtSmryVOs != null){
			PriRpAmdtSmryVO[] tmpVOs = new PriRpAmdtSmryVO[priRpAmdtSmryVOs.length];
			System.arraycopy(priRpAmdtSmryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpAmdtSmryVOs = tmpVOs;
		}
	}

	public void setPriRpProgVO(PriRpProgVO priRpProgVO) {
		this.priRpProgVO = priRpProgVO;
	}

	public void setPriRpProgVOS(PriRpProgVO[] priRpProgVOs){
		if(priRpProgVOs != null){
			PriRpProgVO[] tmpVOs = new PriRpProgVO[priRpProgVOs.length];
			System.arraycopy(priRpProgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpProgVOs = tmpVOs;
		}
	}

	public void setPriRpScpProgVO(PriRpScpProgVO priRpScpProgVO) {
		this.priRpScpProgVO = priRpScpProgVO;
	}

	public void setPriRpScpProgVOS(PriRpScpProgVO[] priRpScpProgVOs){
		if(priRpScpProgVOs != null){
			PriRpScpProgVO[] tmpVOs = new PriRpScpProgVO[priRpScpProgVOs.length];
			System.arraycopy(priRpScpProgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpProgVOs = tmpVOs;
		}
	}

	public void setPriRpScpAmdtSmryVO(PriRpScpAmdtSmryVO priRpScpAmdtSmryVO) {
		this.priRpScpAmdtSmryVO = priRpScpAmdtSmryVO;
	}

	public void setPriRpScpAmdtSmryVOS(PriRpScpAmdtSmryVO[] priRpScpAmdtSmryVOs){
		if(priRpScpAmdtSmryVOs != null){
			PriRpScpAmdtSmryVO[] tmpVOs = new PriRpScpAmdtSmryVO[priRpScpAmdtSmryVOs.length];
			System.arraycopy(priRpScpAmdtSmryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpAmdtSmryVOs = tmpVOs;
		}
	}

	public void setPriRpScpDurVOS(PriRpScpDurVO[] priRpScpDurVOs){
		if(priRpScpDurVOs != null){
			PriRpScpDurVO[] tmpVOs = new PriRpScpDurVO[priRpScpDurVOs.length];
			System.arraycopy(priRpScpDurVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpDurVOs = tmpVOs;
		}
	}

	public RfaPropMnVO getRfaPropMnVO() {
		return rfaPropMnVO;
	}

	public RfaPropProgVO getRfaPropProgVO() {
		return rfaPropProgVO;
	}

	public PriRpMnVO getPriRpMnVO() {
		return priRpMnVO;
	}

	public PriRpMnVO[] getPriRpMnVOS() {
		PriRpMnVO[] rtnVOs = null;
		if (this.priRpMnVOs != null) {
			rtnVOs = new PriRpMnVO[priRpMnVOs.length];
			System.arraycopy(priRpMnVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public PriRpScpMnVO getPriRpScpMnVO() {
		return priRpScpMnVO;
	}

	public PriRpScpMnVO[] getPriRpScpMnVOS() {
		PriRpScpMnVO[] rtnVOs = null;
		if (this.priRpScpMnVOs != null) {
			rtnVOs = new PriRpScpMnVO[priRpScpMnVOs.length];
			System.arraycopy(priRpScpMnVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public PriRpHdrVO getPriRpHdrVO() {
		return priRpHdrVO;
	}

	public PriRpHdrVO[] getPriRpHdrVOS() {
		PriRpHdrVO[] rtnVOs = null;
		if (this.priRpHdrVOs != null) {
			rtnVOs = new PriRpHdrVO[priRpHdrVOs.length];
			System.arraycopy(priRpHdrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public PriRpAmdtSmryVO getPriRpAmdtSmryVO() {
		return priRpAmdtSmryVO;
	}

	public PriRpAmdtSmryVO[] getPriRpAmdtSmryVOS() {
		PriRpAmdtSmryVO[] rtnVOs = null;
		if (this.priRpAmdtSmryVOs != null) {
			rtnVOs = new PriRpAmdtSmryVO[priRpAmdtSmryVOs.length];
			System.arraycopy(priRpAmdtSmryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public PriRpScpAmdtSmryVO getPriRpScpAmdtSmryVO() {
		return priRpScpAmdtSmryVO;
	}

	public PriRpScpAmdtSmryVO[] getPriRpScpAmdtSmryVOS() {
		PriRpScpAmdtSmryVO[] rtnVOs = null;
		if (this.priRpScpAmdtSmryVOs != null) {
			rtnVOs = new PriRpScpAmdtSmryVO[priRpScpAmdtSmryVOs.length];
			System.arraycopy(priRpScpAmdtSmryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public PriRpProgVO getPriRpProgVO() {
		return priRpProgVO;
	}

	public PriRpProgVO[] getPriRpProgVOS() {
		PriRpProgVO[] rtnVOs = null;
		if (this.priRpProgVOs != null) {
			rtnVOs = new PriRpProgVO[priRpProgVOs.length];
			System.arraycopy(priRpProgVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public PriRpScpProgVO getPriRpScpProgVO() {
		return priRpScpProgVO;
	}

	public PriRpScpProgVO[] getPriRpScpProgVOS() {
		PriRpScpProgVO[] rtnVOs = null;
		if (this.priRpScpProgVOs != null) {
			rtnVOs = new PriRpScpProgVO[priRpScpProgVOs.length];
			System.arraycopy(priRpScpProgVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public PriRpScpDurVO getPriRpScpDurVO() {
		return priRpScpDurVO;
	}

	public PriRpScpDurVO[] getPriRpScpDurVOS() {
		PriRpScpDurVO[] rtnVOs = null;
		if (this.priRpScpDurVOs != null) {
			rtnVOs = new PriRpScpDurVO[priRpScpDurVOs.length];
			System.arraycopy(priRpScpDurVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public PriRpComVO getPriRpComVO() {
		return priRpComVO;
	}

	public void setPriRpComVO(PriRpComVO priRpComVO) {
		this.priRpComVO = priRpComVO;
	}

	public String getCpPriMnFlag() {
		return cpPriMnFlag;
	}

	public void setCpPriMnFlag(String cpPriMnFlag) {
		this.cpPriMnFlag = cpPriMnFlag;
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
	 * @return the rsltRoutHdrSmryListVO
	 */
	public RsltRoutHdrSmryListVO getRsltRoutHdrSmryListVO() {
		return rsltRoutHdrSmryListVO;
	}

	/**
	 * @param rsltRoutHdrSmryListVO the rsltRoutHdrSmryListVO to set
	 */
	public void setRsltRoutHdrSmryListVO(RsltRoutHdrSmryListVO rsltRoutHdrSmryListVO) {
		this.rsltRoutHdrSmryListVO = rsltRoutHdrSmryListVO;
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
	 * @return the rfaSummryAcceptAllVO
	 */
	public RfaSummryAcceptAllVO getRfaSummryAcceptAllVO() {
		return rfaSummryAcceptAllVO;
	}

	/**
	 * @param rfaSummryAcceptAllVO the rfaSummryAcceptAllVO to set
	 */
	public void setRfaSummryAcceptAllVO(RfaSummryAcceptAllVO rfaSummryAcceptAllVO) {
		this.rfaSummryAcceptAllVO = rfaSummryAcceptAllVO;
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

	/**
	 * @return the noteConvMapgId
	 */
	public String getNoteConvMapgId() {
		return noteConvMapgId;
	}

	/**
	 * @param noteConvMapgId the noteConvMapgId to set
	 */
	public void setNoteConvMapgId(String noteConvMapgId) {
		this.noteConvMapgId = noteConvMapgId;
	}
	
	/**
	 * @return the priRpScpRtCmdtRnoteVOS
	 */
	public PriRpScpRtCmdtRnoteVO[] getPriRpScpRtCmdtRnoteVOS() {
		PriRpScpRtCmdtRnoteVO[] rtnVOs = null;
		if (this.priRpScpRtCmdtRnoteVOS != null) {
			rtnVOs = new PriRpScpRtCmdtRnoteVO[priRpScpRtCmdtRnoteVOS.length];
			System.arraycopy(priRpScpRtCmdtRnoteVOS, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param priRpScpRtCmdtRnoteVOS the priRpScpRtCmdtRnoteVOS to set
	 */
	public void setPriRpScpRtCmdtRnoteVOS(PriRpScpRtCmdtRnoteVO[] priRpScpRtCmdtRnoteVOS){
		if(priRpScpRtCmdtRnoteVOS != null){
			PriRpScpRtCmdtRnoteVO[] tmpVOs = new PriRpScpRtCmdtRnoteVO[priRpScpRtCmdtRnoteVOS.length];
			System.arraycopy(priRpScpRtCmdtRnoteVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtCmdtRnoteVOS = tmpVOs;
		}
	}

	/**
	 * @return the priRpScpRtRoutOrgPntVO
	 */
	public PriRpScpRtRoutPntVO[] getPriRpScpRtRoutOrgPntVO() {
		PriRpScpRtRoutPntVO[] rtnVOs = null;
		if (this.priRpScpRtRoutOrgPntVO != null) {
			rtnVOs = new PriRpScpRtRoutPntVO[priRpScpRtRoutOrgPntVO.length];
			System.arraycopy(priRpScpRtRoutOrgPntVO, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param priRpScpRtRoutOrgPntVO the priRpScpRtRoutOrgPntVO to set
	 */
	public void setPriRpScpRtRoutOrgPntVO(PriRpScpRtRoutPntVO[] priRpScpRtRoutOrgPntVO){
		if(priRpScpRtRoutOrgPntVO != null){
			PriRpScpRtRoutPntVO[] tmpVOs = new PriRpScpRtRoutPntVO[priRpScpRtRoutOrgPntVO.length];
			System.arraycopy(priRpScpRtRoutOrgPntVO, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtRoutOrgPntVO = tmpVOs;
		}
	}

	/**
	 * @return the priRpScpRtRoutOrgViaVO
	 */
	public PriRpScpRtRoutViaVO[] getPriRpScpRtRoutOrgViaVO() {
		PriRpScpRtRoutViaVO[] rtnVOs = null;
		if (this.priRpScpRtRoutOrgViaVO != null) {
			rtnVOs = new PriRpScpRtRoutViaVO[priRpScpRtRoutOrgViaVO.length];
			System.arraycopy(priRpScpRtRoutOrgViaVO, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param priRpScpRtRoutOrgViaVO the priRpScpRtRoutOrgViaVO to set
	 */
	public void setPriRpScpRtRoutOrgViaVO(PriRpScpRtRoutViaVO[] priRpScpRtRoutOrgViaVO){
		if(priRpScpRtRoutOrgViaVO != null){
			PriRpScpRtRoutViaVO[] tmpVOs = new PriRpScpRtRoutViaVO[priRpScpRtRoutOrgViaVO.length];
			System.arraycopy(priRpScpRtRoutOrgViaVO, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtRoutOrgViaVO = tmpVOs;
		}
	}

	/**
	 * @return the priRpScpRtRoutDestViaVO
	 */
	public PriRpScpRtRoutViaVO[] getPriRpScpRtRoutDestViaVO() {
		PriRpScpRtRoutViaVO[] rtnVOs = null;
		if (this.priRpScpRtRoutDestViaVO != null) {
			rtnVOs = new PriRpScpRtRoutViaVO[priRpScpRtRoutDestViaVO.length];
			System.arraycopy(priRpScpRtRoutDestViaVO, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param priRpScpRtRoutDestViaVO the priRpScpRtRoutDestViaVO to set
	 */
	public void setPriRpScpRtRoutDestViaVO(PriRpScpRtRoutViaVO[] priRpScpRtRoutDestViaVO){
		if(priRpScpRtRoutDestViaVO != null){
			PriRpScpRtRoutViaVO[] tmpVOs = new PriRpScpRtRoutViaVO[priRpScpRtRoutDestViaVO.length];
			System.arraycopy(priRpScpRtRoutDestViaVO, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtRoutDestViaVO = tmpVOs;
		}
	}

	/**
	 * @return the priRpScpRtRoutDestPntVO
	 */
	public PriRpScpRtRoutPntVO[] getPriRpScpRtRoutDestPntVO() {
		PriRpScpRtRoutPntVO[] rtnVOs = null;
		if (this.priRpScpRtRoutDestPntVO != null) {
			rtnVOs = new PriRpScpRtRoutPntVO[priRpScpRtRoutDestPntVO.length];
			System.arraycopy(priRpScpRtRoutDestPntVO, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param priRpScpRtRoutDestPntVO the priRpScpRtRoutDestPntVO to set
	 */
	public void setPriRpScpRtRoutDestPntVO(PriRpScpRtRoutPntVO[] priRpScpRtRoutDestPntVO){
		if(priRpScpRtRoutDestPntVO != null){
			PriRpScpRtRoutPntVO[] tmpVOs = new PriRpScpRtRoutPntVO[priRpScpRtRoutDestPntVO.length];
			System.arraycopy(priRpScpRtRoutDestPntVO, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtRoutDestPntVO = tmpVOs;
		}
	}

}