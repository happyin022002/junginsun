/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3010Event.java
*@FileTitle : Inland Cost Inquiry(EUR)
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2015.03.06 최성환 [CHM-201534710] AOC 2차 소스 보안 품질 진행 요청
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.event;

import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostConditionVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlnadCostInquiryVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlnadCostSpeInquiryVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_AOC_3010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_AOC_3010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_AOC_3010HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdAoc3010Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EurInlnadCostInquiryVO eurInlnadCostInquiryVO = null;
	private EurInlnadCostSpeInquiryVO eurInlnadCostSpeInquiryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EurInlnadCostInquiryVO[] eurInlnadCostInquiryVOs = null;
	private EurInlnadCostSpeInquiryVO[] eurInlnadCostSpeInquiryVOs = null;
	private EurInlandCostConditionVO eurInlandCostConditionVO = null;
	
	public EsdAoc3010Event(){}
	
	/* EurInlnadCostInquiryVO - start */
	public void setInlnadCostInquiryVO(EurInlnadCostInquiryVO eurInlnadCostInquiryVO){
		this. eurInlnadCostInquiryVO = eurInlnadCostInquiryVO;
	}

	public void setInlnadCostInquiryVOS(EurInlnadCostInquiryVO[] inlnadCostInquiryVOs){
		if(inlnadCostInquiryVOs != null){
			EurInlnadCostInquiryVO[] tmpVOs = new EurInlnadCostInquiryVO[inlnadCostInquiryVOs.length];
			System.arraycopy(inlnadCostInquiryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eurInlnadCostInquiryVOs = tmpVOs;
		}
	}

	public EurInlnadCostInquiryVO getInlnadCostInquiryVO(){
		return eurInlnadCostInquiryVO;
	}

	public EurInlnadCostInquiryVO[] getInlnadCostInquiryVOS(){
		EurInlnadCostInquiryVO[] rtnVOs = null;
		if (this.eurInlnadCostInquiryVOs != null) {
			rtnVOs = new EurInlnadCostInquiryVO[eurInlnadCostInquiryVOs.length];
			System.arraycopy(eurInlnadCostInquiryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	/* EurInlnadCostInquiryVO - end */
	
	/* EurInlnadCostSpeInquiryVO - start */
	public void setInlnadCostSpeInquiryVO(EurInlnadCostSpeInquiryVO eurInlnadCostSpeInquiryVO){
		this. eurInlnadCostSpeInquiryVO = eurInlnadCostSpeInquiryVO;
	}

	public void setInlnadCostSpeInquiryVOS(EurInlnadCostSpeInquiryVO[] inlnadCostSpeInquiryVOs){
		if(inlnadCostSpeInquiryVOs != null){
			EurInlnadCostSpeInquiryVO[] tmpVOs = new EurInlnadCostSpeInquiryVO[inlnadCostSpeInquiryVOs.length];
			System.arraycopy(inlnadCostSpeInquiryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eurInlnadCostSpeInquiryVOs = tmpVOs;
		}
	}

	public EurInlnadCostSpeInquiryVO getInlnadCostSpeInquiryVO(){
		return eurInlnadCostSpeInquiryVO;
	}

	public EurInlnadCostSpeInquiryVO[] getInlnadCostSpeInquiryVOS(){
		EurInlnadCostSpeInquiryVO[] rtnVOs = null;
		if (this.eurInlnadCostSpeInquiryVOs != null) {
			rtnVOs = new EurInlnadCostSpeInquiryVO[eurInlnadCostSpeInquiryVOs.length];
			System.arraycopy(eurInlnadCostSpeInquiryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	/* EurInlnadCostSpeInquiryVO - end */
	
	public void setInlandCostConditionVO(EurInlandCostConditionVO eurInlandCostConditionVO) {
		this.eurInlandCostConditionVO = eurInlandCostConditionVO;
	}
	
	public EurInlandCostConditionVO getInlandCostConditionVO() {
		return eurInlandCostConditionVO;
	}
}
