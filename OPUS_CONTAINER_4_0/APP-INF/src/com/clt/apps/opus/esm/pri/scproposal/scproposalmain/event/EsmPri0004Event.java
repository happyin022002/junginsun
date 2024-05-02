/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0004Event.java
*@FileTitle : Proposal & Amendment Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.25 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.event;

import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.CstShInqVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPerformanceVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.ScPropMnVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.ScPropProgVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SchSaleLeadVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ComBakEndJbVO;
import com.clt.syscommon.common.table.PriSpAmdtSmryVO;
import com.clt.syscommon.common.table.PriSpCtrtPtyVO;
import com.clt.syscommon.common.table.PriSpHdrVO;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpProgVO;
import com.clt.syscommon.common.table.PriSpScpAmdtSmryVO;
import com.clt.syscommon.common.table.PriSpScpDurVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;
import com.clt.syscommon.common.table.PriSpScpMqcVO;
import com.clt.syscommon.common.table.PriSpScpProgVO;


/**
 * ESM_PRI_0004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0004HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	//SchSaleLeadVO
	
	private RsltPerformanceVO rsltPerformanceVO = null;	
	public RsltPerformanceVO getRsltPerformanceVO() {
		return rsltPerformanceVO;
	}

	public void setRsltPerformanceVO(RsltPerformanceVO rsltPerformanceVO) {
		this.rsltPerformanceVO = rsltPerformanceVO;
	}

	public ComBakEndJbVO getComBakEndJbVO() {
		return comBakEndJbVO;
	}

	public void setComBakEndJbVO(ComBakEndJbVO comBakEndJbVO) {
		this.comBakEndJbVO = comBakEndJbVO;
	}

	public ComBakEndJbVO[] getComBakEndJbVOs() {
		ComBakEndJbVO[] tmpVOs = null;
		if (this.comBakEndJbVOs != null) {
			tmpVOs = new ComBakEndJbVO[comBakEndJbVOs.length];
			System.arraycopy(comBakEndJbVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setComBakEndJbVOs(ComBakEndJbVO[] comBakEndJbVOs) {
		if (comBakEndJbVOs != null) {
			ComBakEndJbVO[] tmpVOs = new ComBakEndJbVO[comBakEndJbVOs.length];
			System.arraycopy(comBakEndJbVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.comBakEndJbVOs = tmpVOs;
		}
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	/** Table Value Object Multi Data 처리 */
	private ComBakEndJbVO[] comBakEndJbVOs = null;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SchSaleLeadVO schSaleLeadVO = null;
	
	
	public SchSaleLeadVO getSchSaleLeadVO() {
		return schSaleLeadVO;
	}

	public void setSchSaleLeadVO(SchSaleLeadVO schSaleLeadVO) {
		this.schSaleLeadVO = schSaleLeadVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstShInqVO cstShInqVO = null;
	
	public CstShInqVO getCstShInqVO() {
		return cstShInqVO;
	}

	public void setCstShInqVO(CstShInqVO cstShInqVO) {
		this.cstShInqVO = cstShInqVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpMnVO priSpMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpMnVO[] priSpMnVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpMnVO priSpScpMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpMnVO[] priSpScpMnVOs = null;	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpHdrVO priSpHdrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpHdrVO[] priSpHdrVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpAmdtSmryVO priSpAmdtSmryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpAmdtSmryVO[] priSpAmdtSmryVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpProgVO priSpProgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpProgVO[] priSpProgVOs = null;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpProgVO priSpScpProgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpProgVO[] priSpScpProgVOs = null;		
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpAmdtSmryVO[] priSpScpAmdtSmryVOs = null;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpDurVO priSpScpDurVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpDurVO[] priSpScpDurVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpMqcVO priSpScpMqcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpMqcVO[] priSpScpMqcVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpCtrtPtyVO priSpCtrtPtyVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScPropMnVO scPropMnVO = null;
	
	private ScPropProgVO scPropProgVO = null;	
	
	public EsmPri0004Event(){}
	
	public void setScPropMnVO(ScPropMnVO scPropMnVO){
		this. scPropMnVO = scPropMnVO;
	}
	
	public void setScPropProgVO(ScPropProgVO scPropProgVO){
		this. scPropProgVO = scPropProgVO;
	}	
	
	public void setPriSpMnVO(PriSpMnVO priSpMnVO){
		this. priSpMnVO = priSpMnVO;
	}

	public void setPriSpMnVOS(PriSpMnVO[] priSpMnVOs){
		if (priSpMnVOs != null) {
			PriSpMnVO[] tmpVOs = new PriSpMnVO[priSpMnVOs.length];
			System.arraycopy(priSpMnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpMnVOs = tmpVOs;
		}
	}
	
	public void setPriSpScpMnVO(PriSpScpMnVO priSpScpMnVO){
		this. priSpScpMnVO = priSpScpMnVO;
	}

	public void setPriSpScpMnVOS(PriSpScpMnVO[] priSpScpMnVOs){
		if (priSpScpMnVOs != null) {
			PriSpScpMnVO[] tmpVOs = new PriSpScpMnVO[priSpScpMnVOs.length];
			System.arraycopy(priSpScpMnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpMnVOs = tmpVOs;
		}
	}

	public void setPriSpHdrVO(PriSpHdrVO priSpHdrVO){
		this. priSpHdrVO = priSpHdrVO;
	}

	public void setPriSpHdrVOS(PriSpHdrVO[] priSpHdrVOs){
		if (priSpHdrVOs != null) {
			PriSpHdrVO[] tmpVOs = new PriSpHdrVO[priSpHdrVOs.length];
			System.arraycopy(priSpHdrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpHdrVOs = tmpVOs;
		}
	}
	
	public void setPriSpAmdtSmryVO(PriSpAmdtSmryVO priSpAmdtSmryVO){
		this. priSpAmdtSmryVO = priSpAmdtSmryVO;
	}

	public void setPriSpAmdtSmryVOS(PriSpAmdtSmryVO[] priSpAmdtSmryVOs){
		if (priSpAmdtSmryVOs != null) {
			PriSpAmdtSmryVO[] tmpVOs = new PriSpAmdtSmryVO[priSpAmdtSmryVOs.length];
			System.arraycopy(priSpAmdtSmryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpAmdtSmryVOs = tmpVOs;
		}
	}
	
	public void setPriSpProgVO(PriSpProgVO priSpProgVO){
		this. priSpProgVO = priSpProgVO;
	}

	public void setPriSpProgVOS(PriSpProgVO[] priSpProgVOs){
		if (priSpProgVOs != null) {
			PriSpProgVO[] tmpVOs = new PriSpProgVO[priSpProgVOs.length];
			System.arraycopy(priSpProgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpProgVOs = tmpVOs;
		}
	}
	
	public void setPriSpScpProgVO(PriSpScpProgVO priSpScpProgVO){
		this. priSpScpProgVO = priSpScpProgVO;
	}

	public void setPriSpScpProgVOS(PriSpScpProgVO[] priSpScpProgVOs){
		if (priSpScpProgVOs != null) {
			PriSpScpProgVO[] tmpVOs = new PriSpScpProgVO[priSpScpProgVOs.length];
			System.arraycopy(priSpScpProgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpProgVOs = tmpVOs;
		}
	}
	
	public void setPriSpScpAmdtSmryVO(PriSpScpAmdtSmryVO priSpScpAmdtSmryVO){
		this. priSpScpAmdtSmryVO = priSpScpAmdtSmryVO;
	}

	public void setPriSpScpAmdtSmryVOS(PriSpScpAmdtSmryVO[] priSpScpAmdtSmryVOs){
		if (priSpScpAmdtSmryVOs != null) {
			PriSpScpAmdtSmryVO[] tmpVOs = new PriSpScpAmdtSmryVO[priSpScpAmdtSmryVOs.length];
			System.arraycopy(priSpScpAmdtSmryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpAmdtSmryVOs = tmpVOs;
		}
	}
	
	public void setPriSpScpMqcVOS(PriSpScpMqcVO[] priSpScpMqcVOs){
		if (priSpScpMqcVOs != null) {
			PriSpScpMqcVO[] tmpVOs = new PriSpScpMqcVO[priSpScpMqcVOs.length];
			System.arraycopy(priSpScpMqcVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpMqcVOs = tmpVOs;
		}
	}
	
	public void setPriSpScpDurVOS(PriSpScpDurVO[] priSpScpDurVOs){
		if (priSpScpDurVOs != null) {
			PriSpScpDurVO[] tmpVOs = new PriSpScpDurVO[priSpScpDurVOs.length];
			System.arraycopy(priSpScpDurVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpDurVOs = tmpVOs;
		}
	}
	
	public void setPriSpCtrtPtyVO(PriSpCtrtPtyVO priSpCtrtPtyVO){
		this. priSpCtrtPtyVO = priSpCtrtPtyVO;
	}	

	public ScPropMnVO getScPropMnVO(){
		return scPropMnVO;
	}
	
	public ScPropProgVO getScPropProgVO(){
		return scPropProgVO;
	}	
	
	public PriSpMnVO getPriSpMnVO(){
		return priSpMnVO;
	}

	public PriSpMnVO[] getPriSpMnVOS(){
		PriSpMnVO[] tmpVOs = null;
		if (this.priSpMnVOs != null) {
			tmpVOs = new PriSpMnVO[priSpMnVOs.length];
			System.arraycopy(priSpMnVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public PriSpScpMnVO getPriSpScpMnVO(){
		return priSpScpMnVO;
	}

	public PriSpScpMnVO[] getPriSpScpMnVOS(){
		PriSpScpMnVO[] tmpVOs = null;
		if (this.priSpScpMnVOs != null) {
			tmpVOs = new PriSpScpMnVO[priSpScpMnVOs.length];
			System.arraycopy(priSpScpMnVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PriSpHdrVO getPriSpHdrVO(){
		return priSpHdrVO;
	}

	public PriSpHdrVO[] getPriSpHdrVOS(){
		PriSpHdrVO[] tmpVOs = null;
		if (this.priSpHdrVOs != null) {
			tmpVOs = new PriSpHdrVO[priSpHdrVOs.length];
			System.arraycopy(priSpHdrVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public PriSpAmdtSmryVO getPriSpAmdtSmryVO(){
		return priSpAmdtSmryVO;
	}
	
	public PriSpAmdtSmryVO[] getPriSpAmdtSmryVOS(){
		PriSpAmdtSmryVO[] tmpVOs = null;
		if (this.priSpAmdtSmryVOs != null) {
			tmpVOs = new PriSpAmdtSmryVO[priSpAmdtSmryVOs.length];
			System.arraycopy(priSpAmdtSmryVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public PriSpScpAmdtSmryVO getPriSpScpAmdtSmryVO(){
		return priSpScpAmdtSmryVO;
	}
	
	public PriSpScpAmdtSmryVO[] getPriSpScpAmdtSmryVOS(){
		PriSpScpAmdtSmryVO[] tmpVOs = null;
		if (this.priSpScpAmdtSmryVOs != null) {
			tmpVOs = new PriSpScpAmdtSmryVO[priSpScpAmdtSmryVOs.length];
			System.arraycopy(priSpScpAmdtSmryVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public PriSpProgVO getPriSpProgVO(){
		return priSpProgVO;
	}
	
	public PriSpProgVO[] getPriSpProgVOS(){
		PriSpProgVO[] tmpVOs = null;
		if (this.priSpProgVOs != null) {
			tmpVOs = new PriSpProgVO[priSpProgVOs.length];
			System.arraycopy(priSpProgVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}		
	
	public PriSpScpProgVO getPriSpScpProgVO(){
		return priSpScpProgVO;
	}
	
	public PriSpScpProgVO[] getPriSpScpProgVOS(){
		PriSpScpProgVO[] tmpVOs = null;
		if (this.priSpScpProgVOs != null) {
			tmpVOs = new PriSpScpProgVO[priSpScpProgVOs.length];
			System.arraycopy(priSpScpProgVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public PriSpScpMqcVO getPriSpScpMqcVO(){
		return priSpScpMqcVO;
	}
	
	public PriSpScpMqcVO[] getPriSpScpMqcVOS(){
		PriSpScpMqcVO[] tmpVOs = null;
		if (this.priSpScpMqcVOs != null) {
			tmpVOs = new PriSpScpMqcVO[priSpScpMqcVOs.length];
			System.arraycopy(priSpScpMqcVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public PriSpScpDurVO getPriSpScpDurVO(){
		return priSpScpDurVO;
	}
	
	public PriSpScpDurVO[] getPriSpScpDurVOS(){
		PriSpScpDurVO[] tmpVOs = null;
		if (this.priSpScpDurVOs != null) {
			tmpVOs = new PriSpScpDurVO[priSpScpDurVOs.length];
			System.arraycopy(priSpScpDurVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public PriSpCtrtPtyVO getPriSpCtrtPtyVO(){
		return priSpCtrtPtyVO;
	}
}