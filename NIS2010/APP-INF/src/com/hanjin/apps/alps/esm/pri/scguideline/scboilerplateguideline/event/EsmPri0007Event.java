/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0007Event.java
*@FileTitle : Boiler Plate Guideline
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.04.27 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.event;

import com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.vo.RsltPriSgBlplHdrCopyVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.vo.ScBlplGlineVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSgBlplCtntVO;
import com.hanjin.syscommon.common.table.PriSgBlplHdrVO;
import com.hanjin.syscommon.common.table.PriSgBlplVO;


/**
 * ESM_PRI_0007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung Jun Lee
 * @see ESM_PRI_0007HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0007Event extends EventSupport {

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

	public EsmPri0007Event(){}
	
	public void setPriSgBlplVO(PriSgBlplVO priSgBlplVO){
		this. priSgBlplVO = priSgBlplVO;
	}

	public void setPriSgBlplVOS(PriSgBlplVO[] priSgBlplVOs){
		this. priSgBlplVOs = priSgBlplVOs;
	}

	public void setPriSgBlplCtntVO(PriSgBlplCtntVO priSgBlplCtntVO){
		this. priSgBlplCtntVO = priSgBlplCtntVO;
	}

	public void setPriSgBlplCtntVOS(PriSgBlplCtntVO[] priSgBlplCtntVOs){
		this. priSgBlplCtntVOs = priSgBlplCtntVOs;
	}

	public void setPriSgBlplHdrVO(PriSgBlplHdrVO priSgBlplHdrVO){
		this. priSgBlplHdrVO = priSgBlplHdrVO;
	}

	public void setPriSgBlplHdrVOS(PriSgBlplHdrVO[] priSgBlplHdrVOs){
		this. priSgBlplHdrVOs = priSgBlplHdrVOs;
	}

	public PriSgBlplVO getPriSgBlplVO(){
		return priSgBlplVO;
	}

	public PriSgBlplVO[] getPriSgBlplVOS(){
		return priSgBlplVOs;
	}

	public PriSgBlplCtntVO getPriSgBlplCtntVO(){
		return priSgBlplCtntVO;
	}

	public PriSgBlplCtntVO[] getPriSgBlplCtntVOS(){
		return priSgBlplCtntVOs;
	}

	public PriSgBlplHdrVO getPriSgBlplHdrVO(){
		return priSgBlplHdrVO;
	}

	public PriSgBlplHdrVO[] getPriSgBlplHdrVOS(){
		return priSgBlplHdrVOs;
	}

	public RsltPriSgBlplHdrCopyVO getRsltPriSgBlplHdrCopyVO() {
		return rsltPriSgBlplHdrCopyVO;
	}

	public void setRsltPriSgBlplHdrCopyVO(
			RsltPriSgBlplHdrCopyVO rsltPriSgBlplHdrCopyVO) {
		this.rsltPriSgBlplHdrCopyVO = rsltPriSgBlplHdrCopyVO;
	}
	
	

}