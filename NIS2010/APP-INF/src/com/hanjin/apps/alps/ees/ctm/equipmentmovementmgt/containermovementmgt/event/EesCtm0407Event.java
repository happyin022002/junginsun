/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0407Event.java
*@FileTitle : Domestic MVMT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.07.20 우경민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CTM_0407 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CTM_0407HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyung Min Woo
 * @see EES_CTM_0407HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesCtm0407Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CusCtmMovementVO ctmMovementVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CusCtmMovementVO[] ctmMovementVOs = null;

	public EesCtm0407Event(){}
	
	public void setCtmMovementVO(CusCtmMovementVO ctmMovementVO){
		this. ctmMovementVO = ctmMovementVO;
	}

	public void setCtmMovementVOS(CusCtmMovementVO[] ctmMovementVOs){
		this. ctmMovementVOs = ctmMovementVOs;
	}

	public CusCtmMovementVO getCtmMovementVO(){
		return ctmMovementVO;
	}

	public CusCtmMovementVO[] getCtmMovementVOS(){
		return ctmMovementVOs;
	}
}