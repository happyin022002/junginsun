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
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.event;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.PriParaCdDtlVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.PriParaCdVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.CstApprovalVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropMnVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropProgVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SchSaleLeadVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRpAmdtSmryVO;
import com.clt.syscommon.common.table.PriRpDmdtVO;
import com.clt.syscommon.common.table.PriRpHdrVO;
import com.clt.syscommon.common.table.PriRpMnVO;
import com.clt.syscommon.common.table.PriRpProgVO;
import com.clt.syscommon.common.table.PriRpScpAmdtSmryVO;
import com.clt.syscommon.common.table.PriRpScpDurVO;
import com.clt.syscommon.common.table.PriRpScpMnVO;
import com.clt.syscommon.common.table.PriRpScpProgVO;
import com.clt.syscommon.common.table.PriSpCtrtPtyVO;


/**
 * ESM_PRI_2003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_2003HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri2003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String saleLeadOri = "";
	
	public String getSaleLeadOri() {
		return saleLeadOri;
	}

	public void setSaleLeadOri(String saleLeadOri) {
		this.saleLeadOri = saleLeadOri;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstApprovalVO cstApprovalVO = null;
	
	public CstApprovalVO getCstApprovalVO() {
		return cstApprovalVO;
	}

	public void setCstApprovalVO(CstApprovalVO cstApprovalVO) {
		this.cstApprovalVO = cstApprovalVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SchSaleLeadVO schSaleLeadVO = null;
	
	public SchSaleLeadVO getSchSaleLeadVO() {
		return schSaleLeadVO;
	}

	public void setSchSaleLeadVO(SchSaleLeadVO schSaleLeadVO) {
		this.schSaleLeadVO = schSaleLeadVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpMnVO priRpMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpMnVO[] priRpMnVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpMnVO priRpScpMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpScpMnVO[] priRpScpMnVOs = null;	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpHdrVO priRpHdrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpHdrVO[] priRpHdrVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpAmdtSmryVO priRpAmdtSmryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpAmdtSmryVO[] priRpAmdtSmryVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpProgVO priRpProgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpProgVO[] priRpProgVOs = null;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpProgVO priRpScpProgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpScpProgVO[] priRpScpProgVOs = null;		
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpAmdtSmryVO priRpScpAmdtSmryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpScpAmdtSmryVO[] priRpScpAmdtSmryVOs = null;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpDurVO priRpScpDurVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpScpDurVO[] priRpScpDurVOs = null;
	
	//2014.10.13 ADD <start> ----
	private PriParaCdVO priParaCdVO = null;
	private PriParaCdVO[] priParaCdVOS = null;
		
	private PriParaCdDtlVO priParaCdDtlVO = null;
	private PriParaCdDtlVO[] priParaCdDtlVOS = null;
	//2014.10.13 ADD <end> ----

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RfaPropMnVO rfaPropMnVO = null;
	
	private RfaPropProgVO rfaPropProgVO = null;	
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpCtrtPtyVO priSpCtrtPtyVO = null;
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpDmdtVO priRpDmdtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpDmdtVO[] priRpDmdtVOs = null;
	
	public PriRpDmdtVO getPriRpDmdtVO() {
		return priRpDmdtVO;
	}

	public void setPriRpDmdtVO(PriRpDmdtVO priRpDmdtVO) {
		this.priRpDmdtVO = priRpDmdtVO;
	}

	public PriRpDmdtVO[] getPriRpDmdtVOs() {
		PriRpDmdtVO[] tmpVOs = null;
		if (this.priRpDmdtVOs != null) {
			tmpVOs = new PriRpDmdtVO[priRpDmdtVOs.length];
			System.arraycopy(priRpDmdtVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriRpDmdtVOs(PriRpDmdtVO[] priRpDmdtVOs) {
		if (priRpDmdtVOs != null) {
			PriRpDmdtVO[] tmpVOs = new PriRpDmdtVO[priRpDmdtVOs.length];
			System.arraycopy(priRpDmdtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpDmdtVOs = tmpVOs;
		}
	}

	public PriSpCtrtPtyVO getPriSpCtrtPtyVO() {
		return priSpCtrtPtyVO;
	}

	public void setPriSpCtrtPtyVO(PriSpCtrtPtyVO priSpCtrtPtyVO) {
		this.priSpCtrtPtyVO = priSpCtrtPtyVO;
	}

	public EsmPri2003Event(){}
	
	public void setRfaPropMnVO(RfaPropMnVO rfaPropMnVO){
		this. rfaPropMnVO = rfaPropMnVO;
	}
	
	public void setRfaPropProgVO(RfaPropProgVO rfaPropProgVO){
		this. rfaPropProgVO = rfaPropProgVO;
	}	
	
	public void setPriRpMnVO(PriRpMnVO priRpMnVO){
		this. priRpMnVO = priRpMnVO;
	}

	public void setPriRpMnVOS(PriRpMnVO[] priRpMnVOs){
		if (priRpMnVOs != null) {
			PriRpMnVO[] tmpVOs = new PriRpMnVO[priRpMnVOs.length];
			System.arraycopy(priRpMnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpMnVOs = tmpVOs;
		}
	}
	
	public void setPriRpScpMnVO(PriRpScpMnVO priRpScpMnVO){
		this. priRpScpMnVO = priRpScpMnVO;
	}

	public void setPriRpScpMnVOS(PriRpScpMnVO[] priRpScpMnVOs){
		if (priRpScpMnVOs != null) {
			PriRpScpMnVO[] tmpVOs = new PriRpScpMnVO[priRpScpMnVOs.length];
			System.arraycopy(priRpScpMnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpMnVOs = tmpVOs;
		}
	}	

	public void setPriRpHdrVO(PriRpHdrVO priRpHdrVO){
		this. priRpHdrVO = priRpHdrVO;
	}

	public void setPriRpHdrVOS(PriRpHdrVO[] priRpHdrVOs){
		if (priRpHdrVOs != null) {
			PriRpHdrVO[] tmpVOs = new PriRpHdrVO[priRpHdrVOs.length];
			System.arraycopy(priRpHdrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpHdrVOs = tmpVOs;
		}
	}
	
	public void setPriRpAmdtSmryVO(PriRpAmdtSmryVO priRpAmdtSmryVO){
		this. priRpAmdtSmryVO = priRpAmdtSmryVO;
	}

	public void setPriRpAmdtSmryVOS(PriRpAmdtSmryVO[] priRpAmdtSmryVOs){
		if (priRpAmdtSmryVOs != null) {
			PriRpAmdtSmryVO[] tmpVOs = new PriRpAmdtSmryVO[priRpAmdtSmryVOs.length];
			System.arraycopy(priRpAmdtSmryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpAmdtSmryVOs = tmpVOs;
		}
	}
	
	public void setPriRpProgVO(PriRpProgVO priRpProgVO){
		this. priRpProgVO = priRpProgVO;
	}

	public void setPriRpProgVOS(PriRpProgVO[] priRpProgVOs){
		if (priRpProgVOs != null) {
			PriRpProgVO[] tmpVOs = new PriRpProgVO[priRpProgVOs.length];
			System.arraycopy(priRpProgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpProgVOs = tmpVOs;
		}
	}
	
	public void setPriRpScpProgVO(PriRpScpProgVO priRpScpProgVO){
		this. priRpScpProgVO = priRpScpProgVO;
	}

	public void setPriRpScpProgVOS(PriRpScpProgVO[] priRpScpProgVOs){
		if (priRpScpProgVOs != null) {
			PriRpScpProgVO[] tmpVOs = new PriRpScpProgVO[priRpScpProgVOs.length];
			System.arraycopy(priRpScpProgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpProgVOs = tmpVOs;
		}
	}	
	
	public void setPriRpScpAmdtSmryVO(PriRpScpAmdtSmryVO priRpScpAmdtSmryVO){
		this. priRpScpAmdtSmryVO = priRpScpAmdtSmryVO;
	}

	public void setPriRpScpAmdtSmryVOS(PriRpScpAmdtSmryVO[] priRpScpAmdtSmryVOs){
		if (priRpScpAmdtSmryVOs != null) {
			PriRpScpAmdtSmryVO[] tmpVOs = new PriRpScpAmdtSmryVO[priRpScpAmdtSmryVOs.length];
			System.arraycopy(priRpScpAmdtSmryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpAmdtSmryVOs = tmpVOs;
		}
	}	
	

	
	public void setPriRpScpDurVOS(PriRpScpDurVO[] priRpScpDurVOs){
		if (priRpScpDurVOs != null) {
			PriRpScpDurVO[] tmpVOs = new PriRpScpDurVO[priRpScpDurVOs.length];
			System.arraycopy(priRpScpDurVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpDurVOs = tmpVOs;
		}
	}	
	
	

	public RfaPropMnVO getRfaPropMnVO(){
		return rfaPropMnVO;
	}
	
	public RfaPropProgVO getRfaPropProgVO(){
		return rfaPropProgVO;
	}	
	
	public PriRpMnVO getPriRpMnVO(){
		return priRpMnVO;
	}

	public PriRpMnVO[] getPriRpMnVOS(){
		PriRpMnVO[] tmpVOs = null;
		if (this.priRpMnVOs != null) {
			tmpVOs = new PriRpMnVO[priRpMnVOs.length];
			System.arraycopy(priRpMnVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public PriRpScpMnVO getPriRpScpMnVO(){
		return priRpScpMnVO;
	}

	public PriRpScpMnVO[] getPriRpScpMnVOS(){
		PriRpScpMnVO[] tmpVOs = null;
		if (this.priRpScpMnVOs != null) {
			tmpVOs = new PriRpScpMnVO[priRpScpMnVOs.length];
			System.arraycopy(priRpScpMnVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}	

	public PriRpHdrVO getPriRpHdrVO(){
		return priRpHdrVO;
	}

	public PriRpHdrVO[] getPriRpHdrVOS(){
		PriRpHdrVO[] tmpVOs = null;
		if (this.priRpHdrVOs != null) {
			tmpVOs = new PriRpHdrVO[priRpHdrVOs.length];
			System.arraycopy(priRpHdrVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public PriRpAmdtSmryVO getPriRpAmdtSmryVO(){
		return priRpAmdtSmryVO;
	}
	
	public PriRpAmdtSmryVO[] getPriRpAmdtSmryVOS(){
		PriRpAmdtSmryVO[] tmpVOs = null;
		if (this.priRpAmdtSmryVOs != null) {
			tmpVOs = new PriRpAmdtSmryVO[priRpAmdtSmryVOs.length];
			System.arraycopy(priRpAmdtSmryVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public PriRpScpAmdtSmryVO getPriRpScpAmdtSmryVO(){
		return priRpScpAmdtSmryVO;
	}
	
	public PriRpScpAmdtSmryVO[] getPriRpScpAmdtSmryVOS(){
		PriRpScpAmdtSmryVO[] tmpVOs = null;
		if (this.priRpScpAmdtSmryVOs != null) {
			tmpVOs = new PriRpScpAmdtSmryVO[priRpScpAmdtSmryVOs.length];
			System.arraycopy(priRpScpAmdtSmryVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public PriRpProgVO getPriRpProgVO(){
		return priRpProgVO;
	}
	
	public PriRpProgVO[] getPriRpProgVOS(){
		PriRpProgVO[] tmpVOs = null;
		if (this.priRpProgVOs != null) {
			tmpVOs = new PriRpProgVO[priRpProgVOs.length];
			System.arraycopy(priRpProgVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}		
	
	public PriRpScpProgVO getPriRpScpProgVO(){
		return priRpScpProgVO;
	}
	
	public PriRpScpProgVO[] getPriRpScpProgVOS(){
		PriRpScpProgVO[] tmpVOs = null;
		if (this.priRpScpProgVOs != null) {
			tmpVOs = new PriRpScpProgVO[priRpScpProgVOs.length];
			System.arraycopy(priRpScpProgVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}		
	

	
	public PriRpScpDurVO getPriRpScpDurVO(){
		return priRpScpDurVO;
	}
	
	public PriRpScpDurVO[] getPriRpScpDurVOS(){
		PriRpScpDurVO[] tmpVOs = null;
		if (this.priRpScpDurVOs != null) {
			tmpVOs = new PriRpScpDurVO[priRpScpDurVOs.length];
			System.arraycopy(priRpScpDurVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}	
	
	//2014.10.13 ADD <start> ----
	public PriParaCdVO getPriParaCdVO() {
		return priParaCdVO;
	}

	public void setPriParaCdVO(PriParaCdVO priParaCdVO) {
		this.priParaCdVO = priParaCdVO;
	}

	public PriParaCdVO[] getPriParaCdVOS() {
		PriParaCdVO[] tmpVOs = null;
		if (this.priParaCdVOS != null) {
			tmpVOs = new PriParaCdVO[priParaCdVOS.length];
			System.arraycopy(priParaCdVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriParaCdVOS(PriParaCdVO[] priParaCdVOS) {
		if (priParaCdVOS != null) {
			PriParaCdVO[] tmpVOs = new PriParaCdVO[priParaCdVOS.length];
			System.arraycopy(priParaCdVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.priParaCdVOS = tmpVOs;
		}
	}

	public PriParaCdDtlVO getPriParaCdDtlVO() {
		return priParaCdDtlVO;
	}

	public void setPriParaCdDtlVO(PriParaCdDtlVO priParaCdDtlVO) {
		this.priParaCdDtlVO = priParaCdDtlVO;
	}

	public PriParaCdDtlVO[] getPriParaCdDtlVOS() {
		PriParaCdDtlVO[] tmpVOs = null;
		if (this.priParaCdDtlVOS != null) {
			tmpVOs = new PriParaCdDtlVO[priParaCdDtlVOS.length];
			System.arraycopy(priParaCdDtlVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriParaCdDtlVOS(PriParaCdDtlVO[] priParaCdDtlVOS) {
		if (priParaCdDtlVOS != null) {
			PriParaCdDtlVO[] tmpVOs = new PriParaCdDtlVO[priParaCdDtlVOS.length];
			System.arraycopy(priParaCdDtlVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.priParaCdDtlVOS = tmpVOs;
		}
	}
	//2014.10.13 ADD <end> ----
}