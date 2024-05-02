/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTrs3007Event.java
*@FileTitle : Cost Manage
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.event;

import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostConditionVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlnadCostInquiryVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlnadCostSpeInquiryVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_3007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TRS_3007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see ESD_TRS_3007HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTrs3007Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InlnadCostInquiryVO inlnadCostInquiryVO = null;
	private InlnadCostSpeInquiryVO inlnadCostSpeInquiryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InlnadCostInquiryVO[] inlnadCostInquiryVOs = null;
	private InlnadCostSpeInquiryVO[] inlnadCostSpeInquiryVOs = null;
	private InlandCostConditionVO inlandCostConditionVO = null;
	
	public EsdTrs3007Event(){}
	
	/* InlnadCostInquiryVO - start */
	public void setInlnadCostInquiryVO(InlnadCostInquiryVO inlnadCostInquiryVO){
		this. inlnadCostInquiryVO = inlnadCostInquiryVO;
	}

	public void setInlnadCostInquiryVOS(InlnadCostInquiryVO[] inlnadCostInquiryVOs){
		this. inlnadCostInquiryVOs = inlnadCostInquiryVOs;
	}

	public InlnadCostInquiryVO getInlnadCostInquiryVO(){
		return inlnadCostInquiryVO;
	}

	public InlnadCostInquiryVO[] getInlnadCostInquiryVOS(){
		return inlnadCostInquiryVOs;
	}
	/* InlnadCostInquiryVO - end */
	
	/* InlnadCostSpeInquiryVO - start */
	public void setInlnadCostSpeInquiryVO(InlnadCostSpeInquiryVO inlnadCostSpeInquiryVO){
		this. inlnadCostSpeInquiryVO = inlnadCostSpeInquiryVO;
	}

	public void setInlnadCostSpeInquiryVOS(InlnadCostSpeInquiryVO[] inlnadCostSpeInquiryVOs){
		this. inlnadCostSpeInquiryVOs = inlnadCostSpeInquiryVOs;
	}

	public InlnadCostSpeInquiryVO getInlnadCostSpeInquiryVO(){
		return inlnadCostSpeInquiryVO;
	}

	public InlnadCostSpeInquiryVO[] getInlnadCostSpeInquiryVOS(){
		return inlnadCostSpeInquiryVOs;
	}
	/* InlnadCostSpeInquiryVO - end */
	
	public void setInlandCostConditionVO(InlandCostConditionVO inlandCostConditionVO) {
		this.inlandCostConditionVO = inlandCostConditionVO;
	}
	
	public InlandCostConditionVO getInlandCostConditionVO() {
		return inlandCostConditionVO;
	}
}
