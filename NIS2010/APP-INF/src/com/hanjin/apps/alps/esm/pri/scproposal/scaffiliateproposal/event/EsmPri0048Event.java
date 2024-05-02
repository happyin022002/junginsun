/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0048Event.java
*@FileTitle : Proposal Affiliate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.06.02 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.vo.CstPriSpAfilVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.vo.RsltPriSpAfilVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpAfilVO;


/**
 * ESM_PRI_0048 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0048HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kong Back Jin
 * @see ESM_PRI_0048HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0048Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	//CstPriSpAfilVO
	//RsltPriSpAfilVO
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstPriSpAfilVO cstPriSpAfilVO = null;	
	
	public CstPriSpAfilVO getCstPriSpAfilVO() {
		return cstPriSpAfilVO;
	}

	public void setCstPriSpAfilVO(CstPriSpAfilVO cstPriSpAfilVO) {
		this.cstPriSpAfilVO = cstPriSpAfilVO;
	}

	/** Table Value Object Multi Data 처리 */
	private RsltPriSpAfilVO[] rsltPriSpAfilVO = null;
	
	
	public RsltPriSpAfilVO[] getRsltPriSpAfilVO() {
		return rsltPriSpAfilVO;
	}

	public void setRsltPriSpAfilVO(RsltPriSpAfilVO[] rsltPriSpAfilVO) {
		this.rsltPriSpAfilVO = rsltPriSpAfilVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpAfilVO priSpAfilVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpAfilVO[] priSpAfilVOs = null;

	public EsmPri0048Event(){}
	
	public void setPriSpAfilVO(PriSpAfilVO priSpAfilVO){
		this. priSpAfilVO = priSpAfilVO;
	}

	public void setPriSpAfilVOS(PriSpAfilVO[] priSpAfilVOs){
		this. priSpAfilVOs = priSpAfilVOs;
	}

	public PriSpAfilVO getPriSpAfilVO(){
		return priSpAfilVO;
	}

	public PriSpAfilVO[] getPriSpAfilVOS(){
		return priSpAfilVOs;
	}

}