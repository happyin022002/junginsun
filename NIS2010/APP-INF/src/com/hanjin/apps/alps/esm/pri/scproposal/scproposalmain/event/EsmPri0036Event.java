/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0036Event.java
*@FileTitle : Amendment Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.13 변영주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpHdrVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;


/**
 * ESM_PRI_0036 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0036HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0036HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0036Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpHdrVO priSpHdrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpHdrVO[] priSpHdrVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpMnVO priSpMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpMnVO[] priSpMnVOs = null;	

	public EsmPri0036Event(){}
	
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