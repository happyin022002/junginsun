/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VopOpf0074Event.java
*@FileTitle : VNOR Mail Setup
*Open Issues :
*Change history : 
*@LastModifyDate : 2015.04.21
*@LastModifier : 이병훈
*@LastVersion : 1.0 
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.OpfVnorEmlStupVO;

/**
 *  VOP_OPF_0071에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0071HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 이병훈
 * @see VOP_OPF_0071HTMLAction 참조 
 * @since J2EE 1.6
 */
public class VopOpf0074Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfVnorEmlStupVO opfVnorEmlStupVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OpfVnorEmlStupVO[] opfVnorEmlStupVOs = null;

	public VopOpf0074Event(){}
	
	public OpfVnorEmlStupVO getOpfVnorEmlStupVO(){
		return opfVnorEmlStupVO;
	}
	
	public OpfVnorEmlStupVO[] getOpfVnorEmlStupVOs() {
		OpfVnorEmlStupVO[] rtnVOs = null;
		if (this.opfVnorEmlStupVOs != null) {
			rtnVOs = new OpfVnorEmlStupVO[opfVnorEmlStupVOs.length];
			System.arraycopy(opfVnorEmlStupVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setOpfVnorEmlStupVO(OpfVnorEmlStupVO opfVnorEmlStupVO){
		this.opfVnorEmlStupVO = opfVnorEmlStupVO;
	}
	
	public void setOpfVnorEmlStupVOs(OpfVnorEmlStupVO[] opfVnorEmlStupVOs) {
		if (opfVnorEmlStupVOs != null) {
			OpfVnorEmlStupVO[] tmpVOs = new OpfVnorEmlStupVO[opfVnorEmlStupVOs.length];
			System.arraycopy(opfVnorEmlStupVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfVnorEmlStupVOs = tmpVOs;
		}
	}
}
