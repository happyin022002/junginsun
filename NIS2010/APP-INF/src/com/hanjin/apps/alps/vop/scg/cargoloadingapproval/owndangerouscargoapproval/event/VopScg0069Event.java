/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0069Event.java
*@FileTitle : Pre Checking Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.07.23 김현욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstCgoVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SpecialRequestVO;


/**
 * VOP_SCG_0069 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0069HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Hyun Uk
 * @see VOP_SCG_0069HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0069Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PreRestrictionInputVO preRestrictionInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PreRestrictionInputVO[] preRestrictionInputVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgPrnrAproRqstCgoVO scgPrnrAproRqstCgoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgPrnrAproRqstCgoVO[] scgPrnrAproRqstCgoVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpecialRequestVO specialRequestVO = null;

	public VopScg0069Event(){}
	
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
	
	public void setScgPrnrAproRqstCgoVO(ScgPrnrAproRqstCgoVO scgPrnrAproRqstCgoVO){
		this. scgPrnrAproRqstCgoVO = scgPrnrAproRqstCgoVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgPrnrAproRqstCgoVOS(ScgPrnrAproRqstCgoVO[] scgPrnrAproRqstCgoVOs){
		if (scgPrnrAproRqstCgoVOs != null) {
			ScgPrnrAproRqstCgoVO[] tmpVOs = new ScgPrnrAproRqstCgoVO[scgPrnrAproRqstCgoVOs.length];
			System.arraycopy(scgPrnrAproRqstCgoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgPrnrAproRqstCgoVOs = tmpVOs;
		}
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
	
	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgPrnrAproRqstCgoVO[] getScgPrnrAproRqstCgoVOS(){
		ScgPrnrAproRqstCgoVO[] rtnVOs = null;
		if (this.scgPrnrAproRqstCgoVOs != null) {
			rtnVOs = new ScgPrnrAproRqstCgoVO[scgPrnrAproRqstCgoVOs.length];
			System.arraycopy(scgPrnrAproRqstCgoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public ScgPrnrAproRqstCgoVO getScgPrnrAproRqstCgoVO(){
		return scgPrnrAproRqstCgoVO;
	}

}