/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0011Event.java
*@FileTitle : Boiler Plate Guideline
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.27 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.event;

import com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.vo.RsltPriSgBlplHdrCopyVO;
import com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.vo.ScBlplGlineVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSgBlplCtntVO;
import com.clt.syscommon.common.table.PriSgBlplHdrVO;
import com.clt.syscommon.common.table.PriSgBlplVO;


/**
 * ESM_PRI_0011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung Jun Lee
 * @see ESM_PRI_0011HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0011Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSgBlplVO priSgBlplVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSgBlplVO[] priSgBlplVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSgBlplCtntVO priSgBlplCtntVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSgBlplCtntVO[] priSgBlplCtntVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSgBlplHdrVO priSgBlplHdrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSgBlplHdrVO[] priSgBlplHdrVOs = null;
	
	/** container vo */
	private ScBlplGlineVO scBlplGlineVO = null;
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriSgBlplHdrCopyVO rsltPriSgBlplHdrCopyVO = null;

	public ScBlplGlineVO getScBlplGlineVO() {
		return scBlplGlineVO;
	}

	public void setScBlplGlineVO(ScBlplGlineVO scBlplGlineVO) {
		this.scBlplGlineVO = scBlplGlineVO;
	}

	public EsmPri0011Event(){}
	
	public void setPriSgBlplVO(PriSgBlplVO priSgBlplVO){
		this. priSgBlplVO = priSgBlplVO;
	}

	public void setPriSgBlplVOS(PriSgBlplVO[] priSgBlplVOs){
		if (priSgBlplVOs != null) {
			PriSgBlplVO[] tmpVOs = new PriSgBlplVO[priSgBlplVOs.length];
			System.arraycopy(priSgBlplVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSgBlplVOs = tmpVOs;
		}
	}

	public void setPriSgBlplCtntVO(PriSgBlplCtntVO priSgBlplCtntVO){
		this. priSgBlplCtntVO = priSgBlplCtntVO;
	}

	public void setPriSgBlplCtntVOS(PriSgBlplCtntVO[] priSgBlplCtntVOs){
		if (priSgBlplCtntVOs != null) {
			PriSgBlplCtntVO[] tmpVOs = new PriSgBlplCtntVO[priSgBlplCtntVOs.length];
			System.arraycopy(priSgBlplCtntVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSgBlplCtntVOs = tmpVOs;
		}
	}

	public void setPriSgBlplHdrVO(PriSgBlplHdrVO priSgBlplHdrVO){
		this. priSgBlplHdrVO = priSgBlplHdrVO;
	}

	public void setPriSgBlplHdrVOS(PriSgBlplHdrVO[] priSgBlplHdrVOs){
		if (priSgBlplHdrVOs != null) {
			PriSgBlplHdrVO[] tmpVOs = new PriSgBlplHdrVO[priSgBlplHdrVOs.length];
			System.arraycopy(priSgBlplHdrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSgBlplHdrVOs = tmpVOs;
		}
	}

	public PriSgBlplVO getPriSgBlplVO(){
		return priSgBlplVO;
	}

	public PriSgBlplVO[] getPriSgBlplVOS(){
		PriSgBlplVO[] tmpVOs = null;
		if (this.priSgBlplVOs != null) {
			tmpVOs = new PriSgBlplVO[priSgBlplVOs.length];
			System.arraycopy(priSgBlplVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PriSgBlplCtntVO getPriSgBlplCtntVO(){
		return priSgBlplCtntVO;
	}

	public PriSgBlplCtntVO[] getPriSgBlplCtntVOS(){
		PriSgBlplCtntVO[] tmpVOs = null;
		if (this.priSgBlplCtntVOs != null) {
			tmpVOs = new PriSgBlplCtntVO[priSgBlplCtntVOs.length];
			System.arraycopy(priSgBlplCtntVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PriSgBlplHdrVO getPriSgBlplHdrVO(){
		return priSgBlplHdrVO;
	}

	public PriSgBlplHdrVO[] getPriSgBlplHdrVOS(){
		PriSgBlplHdrVO[] tmpVOs = null;
		if (this.priSgBlplHdrVOs != null) {
			tmpVOs = new PriSgBlplHdrVO[priSgBlplHdrVOs.length];
			System.arraycopy(priSgBlplHdrVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public RsltPriSgBlplHdrCopyVO getRsltPriSgBlplHdrCopyVO() {
		return rsltPriSgBlplHdrCopyVO;
	}

	public void setRsltPriSgBlplHdrCopyVO(
			RsltPriSgBlplHdrCopyVO rsltPriSgBlplHdrCopyVO) {
		this.rsltPriSgBlplHdrCopyVO = rsltPriSgBlplHdrCopyVO;
	}
	
	

}