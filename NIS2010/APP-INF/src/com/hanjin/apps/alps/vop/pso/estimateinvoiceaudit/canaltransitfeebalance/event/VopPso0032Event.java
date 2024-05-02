/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0032Event.java
*@FileTitle : Balance Diff. Account
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.08.25 정명훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.BalDiffAcctVO;


/**
 * VOP_PSO_0032 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO_0032HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeong Myounghun
 * @see VOP_PSO_0032HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0032Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BalDiffAcctVO balDiffAcctVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BalDiffAcctVO[] balDiffAcctVOs = null;

	public VopPso0032Event(){}
	
	public void setBalDiffAcctVO(BalDiffAcctVO balDiffAcctVO){
		this. balDiffAcctVO = balDiffAcctVO;
	}


	public void setBalDiffAcctVOS(BalDiffAcctVO[] balDiffAcctVOs){
		if (balDiffAcctVOs != null) {
			BalDiffAcctVO[] tmpVOs = new BalDiffAcctVO[balDiffAcctVOs .length];
			System.arraycopy(balDiffAcctVOs, 0, tmpVOs, 0, tmpVOs.length);
			this. balDiffAcctVOs = tmpVOs;
		}
	}

	public BalDiffAcctVO getBalDiffAcctVO(){
		return balDiffAcctVO;
	}

	public BalDiffAcctVO[] getBalDiffAcctVOS(){
		BalDiffAcctVO[] tmpVOs = null;
		if (this. balDiffAcctVOs != null) {
			tmpVOs = new BalDiffAcctVO[balDiffAcctVOs .length];
			System.arraycopy(balDiffAcctVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
}