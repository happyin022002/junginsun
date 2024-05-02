/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0110Event.java
*@FileTitle : Packing Instruction Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.04
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.06.04 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SpecialRequestVO;


/**
 * VOP_SCG_0110 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0110HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Hyun Uk
 * @see VOP_SCG_0110HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0110Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PreRestrictionInputVO preRestrictionInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PreRestrictionInputVO[] preRestrictionInputVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpecialRequestVO specialRequestVO = null;
	
    private String imdgPckTpCd = null;
    private String imdgPckCd = null;

	public VopScg0110Event(){}
	
	public void setPreRestrictionInputVO(PreRestrictionInputVO preRestrictionInputVO){
		this. preRestrictionInputVO = preRestrictionInputVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setPreRestrictionInputVOS(PreRestrictionInputVO[] preRestrictionInputVOs){
		if (preRestrictionInputVOs != null) {
			PreRestrictionInputVO[] tmpVOs = new PreRestrictionInputVO[preRestrictionInputVOs.length];
			System.arraycopy(preRestrictionInputVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.preRestrictionInputVOs = tmpVOs;
		}
	}
	
	public void setSpecialRequestVO(SpecialRequestVO specialRequestVO){
		this. specialRequestVO = specialRequestVO;
	}

	public PreRestrictionInputVO getPreRestrictionInputVO(){
		return preRestrictionInputVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public PreRestrictionInputVO[] getPreRestrictionInputVOS(){
		PreRestrictionInputVO[] rtnVOs = null;
		if (this.preRestrictionInputVOs != null) {
			rtnVOs = new PreRestrictionInputVO[preRestrictionInputVOs.length];
			System.arraycopy(preRestrictionInputVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public SpecialRequestVO getSpecialRequestVO(){
		return specialRequestVO;
	}

	public String getImdgPckTpCd() {
		return imdgPckTpCd;
	}

	public void setImdgPckTpCd(String imdgPckTpCd) {
		this.imdgPckTpCd = imdgPckTpCd;
	}

	public String getImdgPckCd() {
		return imdgPckCd;
	}

	public void setImdgPckCd(String imdgPckCd) {
		this.imdgPckCd = imdgPckCd;
	}
	
	

}