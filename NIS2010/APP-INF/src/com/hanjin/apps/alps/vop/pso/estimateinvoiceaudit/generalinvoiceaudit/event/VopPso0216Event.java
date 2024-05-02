/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VopPso0216Event.java
*@FileTitle : TPB Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.12
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.11.12 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TpbIfVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_PSO_0216 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO_0216HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Maria Chin
 * @see VOP_PSO_0216HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0216Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TpbIfVO tpbIfVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TpbIfVO[] tpbIfVOs = null;

	private String n3ptyVndrSeq = null;
	
	public TpbIfVO getTpbIfVO() {
		return tpbIfVO;
	}

	public void setTpbIfVO(TpbIfVO tpbIfVO) {
		this.tpbIfVO = tpbIfVO;
	}

	public TpbIfVO[] getTpbIfVOs(){
		TpbIfVO[] tmpVOs = null;
		if (this. tpbIfVOs != null) {
			tmpVOs = new TpbIfVO[tpbIfVOs .length];
			System.arraycopy(tpbIfVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setTpbIfVOs(TpbIfVO[] tpbIfVOs){
		if (tpbIfVOs != null) {
			TpbIfVO[] tmpVOs = new TpbIfVO[tpbIfVOs .length];
			System.arraycopy(tpbIfVOs, 0, tmpVOs, 0, tmpVOs.length);
			this. tpbIfVOs = tmpVOs;
		}
	}
	
	public String getN3ptyVndrSeq() {
		return n3ptyVndrSeq;
	}

	public void setN3ptyVndrSeq(String vndrSeq) {
		n3ptyVndrSeq = vndrSeq;
	}
	
}