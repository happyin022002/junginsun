/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0020Event.java
*@FileTitle : MQC
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.13 변영주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.event;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo.CstAcceptMqcVO;
import com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo.CstMqcVO;
import com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo.GrpMqcVO;
import com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo.RsltPriSpSubMqcVO;
import com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo.SchPriSpScpMqcVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpMqcVO;
import com.clt.syscommon.common.table.PriSpScpMqcVO;
import com.clt.syscommon.common.table.PriSpSubMqcVO;


/**
 * ESM_PRI_0020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0020HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0020HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0020Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private CstAcceptMqcVO cstAcceptMqcVO = null;
	
	public CstAcceptMqcVO getCstAcceptMqcVO() {
		return cstAcceptMqcVO;
	}

	public void setCstAcceptMqcVO(CstAcceptMqcVO cstAcceptMqcVO) {
		this.cstAcceptMqcVO = cstAcceptMqcVO;
	}

	/** Table Value Object 조회시 사용되는 커스텀 VO */
	private RsltCdListVO rsltCdListVO = null;	
	
	/** Table Value Object 조회시 사용되는 커스텀 VO */
	private CstMqcVO cstMqcVO = null;	
	
	/** Container VO */
	private GrpMqcVO grpMqcVO = null;	
	public CstMqcVO getCstMqcVO() {
		return cstMqcVO;
	}

	public RsltCdListVO getRsltCdListVO() {
		return rsltCdListVO;
	}

	public void setRsltCdListVO(RsltCdListVO rsltCdListVO) {
		this.rsltCdListVO = rsltCdListVO;
	}

	public void setCstMqcVO(CstMqcVO cstMqcVO) {
		this.cstMqcVO = cstMqcVO;
	}

	public GrpMqcVO getGrpMqcVO() {
		return grpMqcVO;
	}

	public void setGrpMqcVO(GrpMqcVO grpMqcVO) {
		this.grpMqcVO = grpMqcVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriSpSubMqcVO rsltPriSpSubMqcVO = null;
	
	public RsltPriSpSubMqcVO getRsltPriSpSubMqcVO() {
		return rsltPriSpSubMqcVO;
	}

	public void setRsltPriSpSubMqcVO(RsltPriSpSubMqcVO rsltPriSpSubMqcVO) {
		this.rsltPriSpSubMqcVO = rsltPriSpSubMqcVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SchPriSpScpMqcVO schPriSpScpMqcVO = null;
	
	public SchPriSpScpMqcVO getSchPriSpScpMqcVO() {
		return schPriSpScpMqcVO;
	}

	public void setSchPriSpScpMqcVO(SchPriSpScpMqcVO schPriSpScpMqcVO) {
		this.schPriSpScpMqcVO = schPriSpScpMqcVO;
	}

	public SchPriSpScpMqcVO[] getSchPriSpScpMqcVOS() {
		SchPriSpScpMqcVO[] tmpVOs = null;
		if (this.schPriSpScpMqcVOS != null) {
			tmpVOs = new SchPriSpScpMqcVO[schPriSpScpMqcVOS.length];
			System.arraycopy(schPriSpScpMqcVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setSchPriSpScpMqcVOS(SchPriSpScpMqcVO[] schPriSpScpMqcVOS) {
		if (schPriSpScpMqcVOS != null) {
			SchPriSpScpMqcVO[] tmpVOs = new SchPriSpScpMqcVO[schPriSpScpMqcVOS.length];
			System.arraycopy(schPriSpScpMqcVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.schPriSpScpMqcVOS = tmpVOs;
		}
	}

	/** Table Value Object Multi Data 처리 */
	private SchPriSpScpMqcVO[] schPriSpScpMqcVOS = null;		
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpSubMqcVO priSpSubMqcVO = null;
	
	public PriSpSubMqcVO getPriSpSubMqcVO() {
		return priSpSubMqcVO;
	}

	public void setPriSpSubMqcVO(PriSpSubMqcVO priSpSubMqcVO) {
		this.priSpSubMqcVO = priSpSubMqcVO;
	}

	public PriSpSubMqcVO[] getPriSpSubMqcVOs() {
		PriSpSubMqcVO[] tmpVOs = null;
		if (this.priSpSubMqcVOs != null) {
			tmpVOs = new PriSpSubMqcVO[priSpSubMqcVOs.length];
			System.arraycopy(priSpSubMqcVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriSpSubMqcVOs(PriSpSubMqcVO[] priSpSubMqcVOs) {
		if (priSpSubMqcVOs != null) {
			PriSpSubMqcVO[] tmpVOs = new PriSpSubMqcVO[priSpSubMqcVOs.length];
			System.arraycopy(priSpSubMqcVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpSubMqcVOs = tmpVOs;
		}
	}

	/** Table Value Object Multi Data 처리 */
	private PriSpSubMqcVO[] priSpSubMqcVOs = null;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpMqcVO priSpMqcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpMqcVO[] priSpMqcVOs = null;	
	
	
	public PriSpMqcVO getPriSpMqcVO() {
		return priSpMqcVO;
	}

	public void setPriSpMqcVO(PriSpMqcVO priSpMqcVO) {
		this.priSpMqcVO = priSpMqcVO;
	}

	public PriSpMqcVO[] getPriSpMqcVOs() {
		PriSpMqcVO[] tmpVOs = null;
		if (this.priSpMqcVOs != null) {
			tmpVOs = new PriSpMqcVO[priSpMqcVOs.length];
			System.arraycopy(priSpMqcVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriSpMqcVOs(PriSpMqcVO[] priSpMqcVOs) {
		if (priSpMqcVOs != null) {
			PriSpMqcVO[] tmpVOs = new PriSpMqcVO[priSpMqcVOs.length];
			System.arraycopy(priSpMqcVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpMqcVOs = tmpVOs;
		}
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpMqcVO priSpScpMqcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpMqcVO[] priSpScpMqcVOs = null;

	public EsmPri0020Event(){}
	
	public void setPriSpScpMqcVO(PriSpScpMqcVO priSpScpMqcVO){
		this. priSpScpMqcVO = priSpScpMqcVO;
	}

	public void setPriSpScpMqcVOS(PriSpScpMqcVO[] priSpScpMqcVOs){
		if (priSpScpMqcVOs != null) {
			PriSpScpMqcVO[] tmpVOs = new PriSpScpMqcVO[priSpScpMqcVOs.length];
			System.arraycopy(priSpScpMqcVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpMqcVOs = tmpVOs;
		}
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

}