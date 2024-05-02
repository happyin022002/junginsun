/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0074Event.java
*@FileTitle : S/C Boiler Plate Creation - Excel Import
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 서호열
*@LastVersion : 1.0
* 2009.07.06 서호열
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.BlplPropVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpBlplVO;
import com.hanjin.syscommon.common.table.PriSpBlplCtntVO;


/**
 * ESM_PRI_0074 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0074HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HoYeolSea
 * @see ESM_PRI_0074HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0074Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpBlplVO priSpBlplVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpBlplVO[] priSpBlplVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpBlplCtntVO priSpBlplCtntVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpBlplCtntVO[] priSpBlplCtntVOs = null;

	public EsmPri0074Event(){}
	
	public void setPriSpBlplVO(PriSpBlplVO priSpBlplVO){
		this. priSpBlplVO = priSpBlplVO;
	}

	public void setPriSpBlplVOS(PriSpBlplVO[] priSpBlplVOs){
		this. priSpBlplVOs = priSpBlplVOs;
	}

	public void setPriSpBlplCtntVO(PriSpBlplCtntVO priSpBlplCtntVO){
		this. priSpBlplCtntVO = priSpBlplCtntVO;
	}

	public void setPriSpBlplCtntVOS(PriSpBlplCtntVO[] priSpBlplCtntVOs){
		this. priSpBlplCtntVOs = priSpBlplCtntVOs;
	}

	public PriSpBlplVO getPriSpBlplVO(){
		return priSpBlplVO;
	}

	public PriSpBlplVO[] getPriSpBlplVOS(){
		return priSpBlplVOs;
	}

	public PriSpBlplCtntVO getPriSpBlplCtntVO(){
		return priSpBlplCtntVO;
	}

	public PriSpBlplCtntVO[] getPriSpBlplCtntVOS(){
		return priSpBlplCtntVOs;
	}

	/** container vo  */
	private BlplPropVO blplPropVO = null;

	/**
	 * @return the blplPropVO
	 */
	public BlplPropVO getBlplPropVO() {
		return blplPropVO;
	}

	/**
	 * @param blplPropVO the blplPropVO to set
	 */
	public void setBlplPropVO(BlplPropVO blplPropVO) {
		this.blplPropVO = blplPropVO;
	}

}