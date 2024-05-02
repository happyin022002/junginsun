/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmAgt0009Event.java
*@FileTitle : Commission Unit Cost Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.08.13 추경원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement.agtothcomm.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.AgtOtrUtCostVO;


/**
 * ESM_AGT_0009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_AGT_0009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyung-won Chu
 * @see ESM_AGT_0009HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAgt0009Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgtOtrUtCostVO agtOtrUtCostVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AgtOtrUtCostVO[] agtOtrUtCostVOs = null;

	public EsmAgt0009Event(){}
	
	public void setAgtOtrUtCostVO(AgtOtrUtCostVO agtOtrUtCostVO){
		this. agtOtrUtCostVO = agtOtrUtCostVO;
	}

	public void setAgtOtrUtCostVOS(AgtOtrUtCostVO[] agtOtrUtCostVOs){
		this. agtOtrUtCostVOs = agtOtrUtCostVOs;
	}

	public AgtOtrUtCostVO getAgtOtrUtCostVO(){
		return agtOtrUtCostVO;
	}

	public AgtOtrUtCostVO[] getAgtOtrUtCostVOS(){
		return agtOtrUtCostVOs;
	}

}