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
package com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.event;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.CstAcceptMqcVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.CstMqcVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.GrpMqcVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.RsltPriSpSubMqcVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.SchPriSpScpMqcVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpMqcVO;
import com.hanjin.syscommon.common.table.PriSpScpMqcVO;
import com.hanjin.syscommon.common.table.PriSpSubMqcVO;


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
		return schPriSpScpMqcVOS;
	}

	public void setSchPriSpScpMqcVOS(SchPriSpScpMqcVO[] schPriSpScpMqcVOS) {
		this.schPriSpScpMqcVOS = schPriSpScpMqcVOS;
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
		return priSpSubMqcVOs;
	}

	public void setPriSpSubMqcVOs(PriSpSubMqcVO[] priSpSubMqcVOs) {
		this.priSpSubMqcVOs = priSpSubMqcVOs;
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
		return priSpMqcVOs;
	}

	public void setPriSpMqcVOs(PriSpMqcVO[] priSpMqcVOs) {
		this.priSpMqcVOs = priSpMqcVOs;
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
		this. priSpScpMqcVOs = priSpScpMqcVOs;
	}

	public PriSpScpMqcVO getPriSpScpMqcVO(){
		return priSpScpMqcVO;
	}

	public PriSpScpMqcVO[] getPriSpScpMqcVOS(){
		return priSpScpMqcVOs;
	}

}