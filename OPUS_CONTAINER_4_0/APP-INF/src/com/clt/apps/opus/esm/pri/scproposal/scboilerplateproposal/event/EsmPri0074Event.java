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
package com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.event;

import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.BlplPropVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpBlplCtntVO;
import com.clt.syscommon.common.table.PriSpBlplVO;


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
		if (priSpBlplVOs != null) {
			PriSpBlplVO[] tmpVOs = new PriSpBlplVO[priSpBlplVOs.length];
			System.arraycopy(priSpBlplVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpBlplVOs = tmpVOs;
		}
	}

	public void setPriSpBlplCtntVO(PriSpBlplCtntVO priSpBlplCtntVO){
		this. priSpBlplCtntVO = priSpBlplCtntVO;
	}

	public void setPriSpBlplCtntVOS(PriSpBlplCtntVO[] priSpBlplCtntVOs){
		if (priSpBlplCtntVOs != null) {
			PriSpBlplCtntVO[] tmpVOs = new PriSpBlplCtntVO[priSpBlplCtntVOs.length];
			System.arraycopy(priSpBlplCtntVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpBlplCtntVOs = tmpVOs;
		}
	}

	public PriSpBlplVO getPriSpBlplVO(){
		return priSpBlplVO;
	}

	public PriSpBlplVO[] getPriSpBlplVOS(){
		PriSpBlplVO[] tmpVOs = null;
		if (this.priSpBlplVOs != null) {
			tmpVOs = new PriSpBlplVO[priSpBlplVOs.length];
			System.arraycopy(priSpBlplVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PriSpBlplCtntVO getPriSpBlplCtntVO(){
		return priSpBlplCtntVO;
	}

	public PriSpBlplCtntVO[] getPriSpBlplCtntVOS(){
		PriSpBlplCtntVO[] tmpVOs = null;
		if (this.priSpBlplCtntVOs != null) {
			tmpVOs = new PriSpBlplCtntVO[priSpBlplCtntVOs.length];
			System.arraycopy(priSpBlplCtntVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
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