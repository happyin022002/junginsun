/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf2019Event.java
*@FileTitle : CBF Summary Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.05.27 우지석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event;

import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFPartnerEDIVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFPartnerConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_OPF_2024 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_2024HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see VOP_OPF_2024HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf2024Event extends EventSupport {
	

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CBFPartnerEDIVO cBFPartnerEDIVO = null;
	
	
	/** Table Value Object Multi Data 처리 */
	private CBFPartnerEDIVO[] cBFPartnerEDIVOs = null;

   
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CBFPartnerConditionVO  cBFPartnerConditionVO = null;
	
	public VopOpf2024Event(){}
	
	public void setCBFPartnerEDIVO(CBFPartnerEDIVO cBFPartnerEDIVO){
		this. cBFPartnerEDIVO = cBFPartnerEDIVO;
	}
	
	public void setCBFPartnerConditionVO(CBFPartnerConditionVO cBFPartnerConditionVO){
		this. cBFPartnerConditionVO = cBFPartnerConditionVO;
	}


	public void setCBFPartnerEDIVOS(CBFPartnerEDIVO[] cBFPartnerEDIVOs){
		if (cBFPartnerEDIVOs != null) {
			CBFPartnerEDIVO[] tmpVOs = new CBFPartnerEDIVO[cBFPartnerEDIVOs.length];
			System.arraycopy(cBFPartnerEDIVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cBFPartnerEDIVOs = tmpVOs;
		}		
	}



	public CBFPartnerEDIVO getCBFPartnerEDIVO(){
		return cBFPartnerEDIVO;
	}

	public CBFPartnerConditionVO getCBFPartnerConditionVO(){
		return cBFPartnerConditionVO;
	}

	public CBFPartnerEDIVO[] getCBFPartnerEDIVOS(){
		CBFPartnerEDIVO[] rtnVOs = null;
		
		if (this.cBFPartnerEDIVOs != null) {
			rtnVOs = new CBFPartnerEDIVO[cBFPartnerEDIVOs.length];
			System.arraycopy(cBFPartnerEDIVOs, 0, rtnVOs, 0, rtnVOs.length);
		}		
		return rtnVOs;	
	}


}