/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0012Event.java
*@FileTitle : SPCL CGO Irregular List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.16 김현욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmLocationVO;
import com.hanjin.syscommon.common.table.ScgImdgClssCdVO;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.IrregularsVO;


/**
 * VOP_SCG_0012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HyunUk Kim
 * @see VOP_SCG_0012HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private IrregularsVO irregularsVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private IrregularsVO[] irregularsVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgClssCdVO scgImdgClssCdVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmLocationVO mdmLocationVO = null;

	public VopScg0012Event(){}
	
	public void setIrregularsVO(IrregularsVO irregularsVO){
		this. irregularsVO = irregularsVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setIrregularsVOS(IrregularsVO[] irregularsVOs){
		if (irregularsVOs != null) {
			IrregularsVO[] tmpVOs = new IrregularsVO[irregularsVOs.length];
			System.arraycopy(irregularsVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.irregularsVOs = tmpVOs;
		}
	}
	
	public void setScgImdgClssCdVO(ScgImdgClssCdVO scgImdgClssCdVO){
		this. scgImdgClssCdVO = scgImdgClssCdVO;
	}
	
	public void setMdmLocationVO(MdmLocationVO mdmLocationVO){
		this. mdmLocationVO = mdmLocationVO;
	}

	public IrregularsVO getIrregularsVO(){
		return irregularsVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public IrregularsVO[] getIrregularsVOS(){
		IrregularsVO[] rtnVOs = null;
		if (this.irregularsVOs != null) {
			rtnVOs = new IrregularsVO[irregularsVOs.length];
			System.arraycopy(irregularsVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public ScgImdgClssCdVO getScgImdgClssCdVO(){
		return scgImdgClssCdVO;
	}
	
	public MdmLocationVO getMdmLocationVO(){
		return mdmLocationVO;
	}

}