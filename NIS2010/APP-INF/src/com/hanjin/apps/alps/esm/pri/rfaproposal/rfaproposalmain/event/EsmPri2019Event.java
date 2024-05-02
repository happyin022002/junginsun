/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri2019Event.java
*@FileTitle : RFA Proposal Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.10.08 공백진
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.CstShRInqVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropMnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropProgVO;
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
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;


/**
 * ESM_PRI_2019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_2019HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri2019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	//CstShRInqVO
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstShRInqVO cstShRInqVO = null;
	




	public CstShRInqVO getCstShRInqVO() {
		return cstShRInqVO;
	}

	public void setCstShRInqVO(CstShRInqVO cstShRInqVO) {
		this.cstShRInqVO = cstShRInqVO;
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
		PriRpDmdtVO[] rtnVOs = null;
		if (this.priRpDmdtVOs != null) {
			rtnVOs = new PriRpDmdtVO[priRpDmdtVOs.length];
			System.arraycopy(priRpDmdtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPriRpDmdtVOs(PriRpDmdtVO[] priRpDmdtVOs){
		if(priRpDmdtVOs != null){
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

	public EsmPri2019Event(){}
	
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
		if(priRpMnVOs != null){
			PriRpMnVO[] tmpVOs = new PriRpMnVO[priRpMnVOs.length];
			System.arraycopy(priRpMnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpMnVOs = tmpVOs;
		}
	}
	
	public void setPriRpScpMnVO(PriRpScpMnVO priRpScpMnVO){
		this. priRpScpMnVO = priRpScpMnVO;
	}

	public void setPriRpScpMnVOS(PriRpScpMnVO[] priRpScpMnVOs){
		if(priRpScpMnVOs != null){
			PriRpScpMnVO[] tmpVOs = new PriRpScpMnVO[priRpScpMnVOs.length];
			System.arraycopy(priRpScpMnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpMnVOs = tmpVOs;
		}
	}	

	public void setPriRpHdrVO(PriRpHdrVO priRpHdrVO){
		this. priRpHdrVO = priRpHdrVO;
	}

	public void setPriRpHdrVOS(PriRpHdrVO[] priRpHdrVOs){
		if(priRpHdrVOs != null){
			PriRpHdrVO[] tmpVOs = new PriRpHdrVO[priRpHdrVOs.length];
			System.arraycopy(priRpHdrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpHdrVOs = tmpVOs;
		}
	}
	
	public void setPriRpAmdtSmryVO(PriRpAmdtSmryVO priRpAmdtSmryVO){
		this. priRpAmdtSmryVO = priRpAmdtSmryVO;
	}

	public void setPriRpAmdtSmryVOS(PriRpAmdtSmryVO[] priRpAmdtSmryVOs){
		if(priRpAmdtSmryVOs != null){
			PriRpAmdtSmryVO[] tmpVOs = new PriRpAmdtSmryVO[priRpAmdtSmryVOs.length];
			System.arraycopy(priRpAmdtSmryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpAmdtSmryVOs = tmpVOs;
		}
	}
	
	public void setPriRpProgVO(PriRpProgVO priRpProgVO){
		this. priRpProgVO = priRpProgVO;
	}

	public void setPriRpProgVOS(PriRpProgVO[] priRpProgVOs){
		if(priRpProgVOs != null){
			PriRpProgVO[] tmpVOs = new PriRpProgVO[priRpProgVOs.length];
			System.arraycopy(priRpProgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpProgVOs = tmpVOs;
		}
	}
	
	public void setPriRpScpProgVO(PriRpScpProgVO priRpScpProgVO){
		this. priRpScpProgVO = priRpScpProgVO;
	}

	public void setPriRpScpProgVOS(PriRpScpProgVO[] priRpScpProgVOs){
		if(priRpScpProgVOs != null){
			PriRpScpProgVO[] tmpVOs = new PriRpScpProgVO[priRpScpProgVOs.length];
			System.arraycopy(priRpScpProgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpProgVOs = tmpVOs;
		}
	}	
	
	public void setPriRpScpAmdtSmryVO(PriRpScpAmdtSmryVO priRpScpAmdtSmryVO){
		this. priRpScpAmdtSmryVO = priRpScpAmdtSmryVO;
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
		PriRpMnVO[] rtnVOs = null;
		if (this.priRpMnVOs != null) {
			rtnVOs = new PriRpMnVO[priRpMnVOs.length];
			System.arraycopy(priRpMnVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public PriRpScpMnVO getPriRpScpMnVO(){
		return priRpScpMnVO;
	}

	public PriRpScpMnVO[] getPriRpScpMnVOS(){
		PriRpScpMnVO[] rtnVOs = null;
		if (this.priRpScpMnVOs != null) {
			rtnVOs = new PriRpScpMnVO[priRpScpMnVOs.length];
			System.arraycopy(priRpScpMnVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}	

	public PriRpHdrVO getPriRpHdrVO(){
		return priRpHdrVO;
	}

	public PriRpHdrVO[] getPriRpHdrVOS(){
		PriRpHdrVO[] rtnVOs = null;
		if (this.priRpHdrVOs != null) {
			rtnVOs = new PriRpHdrVO[priRpHdrVOs.length];
			System.arraycopy(priRpHdrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public PriRpAmdtSmryVO getPriRpAmdtSmryVO(){
		return priRpAmdtSmryVO;
	}
	
	public PriRpAmdtSmryVO[] getPriRpAmdtSmryVOS(){
		PriRpAmdtSmryVO[] rtnVOs = null;
		if (this.priRpAmdtSmryVOs != null) {
			rtnVOs = new PriRpAmdtSmryVO[priRpAmdtSmryVOs.length];
			System.arraycopy(priRpAmdtSmryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public PriRpScpAmdtSmryVO getPriRpScpAmdtSmryVO(){
		return priRpScpAmdtSmryVO;
	}
	
	public PriRpScpAmdtSmryVO[] getPriRpScpAmdtSmryVOS(){
		PriRpScpAmdtSmryVO[] rtnVOs = null;
		if (this.priRpScpAmdtSmryVOs != null) {
			rtnVOs = new PriRpScpAmdtSmryVO[priRpScpAmdtSmryVOs.length];
			System.arraycopy(priRpScpAmdtSmryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public PriRpProgVO getPriRpProgVO(){
		return priRpProgVO;
	}
	
	public PriRpProgVO[] getPriRpProgVOS(){
		PriRpProgVO[] rtnVOs = null;
		if (this.priRpProgVOs != null) {
			rtnVOs = new PriRpProgVO[priRpProgVOs.length];
			System.arraycopy(priRpProgVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}		
	
	public PriRpScpProgVO getPriRpScpProgVO(){
		return priRpScpProgVO;
	}
	
	public PriRpScpProgVO[] getPriRpScpProgVOS(){
		PriRpScpProgVO[] rtnVOs = null;
		if (this.priRpScpProgVOs != null) {
			rtnVOs = new PriRpScpProgVO[priRpScpProgVOs.length];
			System.arraycopy(priRpScpProgVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}		
	

	
	public PriRpScpDurVO getPriRpScpDurVO(){
		return priRpScpDurVO;
	}
	
	public PriRpScpDurVO[] getPriRpScpDurVOS(){
		PriRpScpDurVO[] rtnVOs = null;
		if (this.priRpScpDurVOs != null) {
			rtnVOs = new PriRpScpDurVO[priRpScpDurVOs.length];
			System.arraycopy(priRpScpDurVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}	
	

}