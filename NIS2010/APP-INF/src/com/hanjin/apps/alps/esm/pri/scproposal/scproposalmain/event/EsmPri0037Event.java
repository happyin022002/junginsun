/*=========================================================
*Copyright(c) 2017 Hiplus Card
*@FileName : EsmPri0037Event.java
*@FileTitle : Amendment Effective Date
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.26
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.09.26 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpHdrVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;


/**
 * ESM_PRI_0037 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0037HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0037HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0037Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpHdrVO priSpHdrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpHdrVO[] priSpHdrVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpMnVO priSpMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpMnVO[] priSpMnVOs = null;	

	public EsmPri0037Event(){}
	
	public void setPriSpHdrVO(PriSpHdrVO priSpHdrVO){
		this. priSpHdrVO = priSpHdrVO;
	}

	public void setPriSpHdrVOS(PriSpHdrVO[] priSpHdrVOs){
		this. priSpHdrVOs = priSpHdrVOs;
	}

	public PriSpHdrVO getPriSpHdrVO(){
		return priSpHdrVO;
	}

	public PriSpHdrVO[] getPriSpHdrVOS(){
		return priSpHdrVOs;
	}
	
	public void setPriSpMnVO(PriSpMnVO priSpMnVO){
		this. priSpMnVO = priSpMnVO;
	}

	public void setPriSpMnVOS(PriSpMnVO[] priSpMnVOs){
		this. priSpMnVOs = priSpMnVOs;
	}

	public PriSpMnVO getPriSpMnVO(){
		return priSpMnVO;
	}

	public PriSpMnVO[] getPriSpMnVOS(){
		return priSpMnVOs;
	}	

}