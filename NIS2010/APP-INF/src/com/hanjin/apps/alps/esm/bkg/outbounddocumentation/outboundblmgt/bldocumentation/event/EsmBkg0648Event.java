/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0648Event.java
*@FileTitle : BL Copy
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.08.20 이일민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import java.util.List;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlCopyInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlCopyOutVO;


/**
 * ESM_BKG_0648 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0648HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ilmin Lee
 * @see ESM_BKG_0648HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0648Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BlCopyOutVO blCopyOutVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<BlCopyOutVO> blCopyOutVOs = null;

	/** Table Value Object Multi Data 처리 */
	private BlCopyInVO[] blCopyIns = null;

	/* Column Info */
	private String bkgNo = null;
	private String custNm = null;
	private String cmdtCd = null;
	private String custSeq = null;
	private String cmdtNm = null;
	private String repCmdtCd = null;
	private String custCntCd = null;
	private String copyBkgNo = null;
	private String custFlg = null;
	private String markFlg = null;
	private String descFlg = null;
	private String bkgStatus = null;
	private String bdrFlg = null;
	private String shprCd = null;

	public EsmBkg0648Event(){}
	
	public BlCopyOutVO getBlCopyOutVO(){
		return blCopyOutVO;
	}

	public void setBlCopyOutVO(BlCopyOutVO blCopyOutVO){
		this. blCopyOutVO = blCopyOutVO;
	}

	public List<BlCopyOutVO> getBlCopyOutVOs(){
		return blCopyOutVOs;
	}

	public void setBlCopyOutVOs(List<BlCopyOutVO> blCopyOutVOs){
		this. blCopyOutVOs = blCopyOutVOs;
	}

	public BlCopyInVO[] getBlCopyIns(){
		return blCopyIns;
	}

	public void setBlCopyIns(BlCopyInVO[] blCopyIns){
		this. blCopyIns = blCopyIns;
	}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getCoptBkgNo() {
		return copyBkgNo;
	}

	public void setCopyBkgNo(String copyBkgNo) {
		this.copyBkgNo = copyBkgNo;
	}

	public String getCustNm() {
		return custNm;
	}

	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}

	public String getCmdtCd() {
		return cmdtCd;
	}

	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}

	public String getCustSeq() {
		return custSeq;
	}

	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	public String getCmdtNm() {
		return cmdtNm;
	}

	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}

	public String getRepCmdtCd() {
		return repCmdtCd;
	}

	public void setRepCmdtCd(String repCmdtCd) {
		this.repCmdtCd = repCmdtCd;
	}

	public String getCustCntCd() {
		return custCntCd;
	}

	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	public String getCustFlg() {
		return custFlg;
	}

	public void setCustFlg(String custFlg) {
		this.custFlg = custFlg;
	}

	public String getMarkFlg() {
		return markFlg;
	}

	public void setMarkFlg(String markFlg) {
		this.markFlg = markFlg;
	}

	public String getDescFlg() {
		return descFlg;
	}

	public void setDescFlg(String descFlg) {
		this.descFlg = descFlg;
	}

	public String getBkgStatus() {
		return this.bkgStatus;
	}

	public void setBkgStatus(String bkgStatus) {
		this.bkgStatus = bkgStatus;
	}

	public String getBdrFlg() {
		return this.bdrFlg;
	}

	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}

	public String getShprCd() {
		return this.shprCd;
	}

	public void setShprCd(String shprCd) {
		this.shprCd = shprCd;
	}

}
