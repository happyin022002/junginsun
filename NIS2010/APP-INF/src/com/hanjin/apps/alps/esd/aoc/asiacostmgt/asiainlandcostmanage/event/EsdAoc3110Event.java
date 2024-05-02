/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3110Event.java
*@FileTitle : Inland Cost Inquiry(Asia)
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.event;

import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostConditionVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlnadCostInquiryVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlnadCostSpeInquiryVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_AOC_3110 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_AOC_3110HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_AOC_3110HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdAoc3110Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AsiaInlnadCostInquiryVO asiaInlnadCostInquiryVO = null;
	private AsiaInlnadCostSpeInquiryVO asiaInlnadCostSpeInquiryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AsiaInlnadCostInquiryVO[] asiaInlnadCostInquiryVOs = null;
	private AsiaInlnadCostSpeInquiryVO[] asiaInlnadCostSpeInquiryVOs = null;
	private AsiaInlandCostConditionVO asiaInlandCostConditionVO = null;
	
	public EsdAoc3110Event(){}
	
	/* AsiaInlnadCostInquiryVO - start */
	public void setInlnadCostInquiryVO(AsiaInlnadCostInquiryVO asiaInlnadCostInquiryVO){
		this. asiaInlnadCostInquiryVO = asiaInlnadCostInquiryVO;
	}

	public void setInlnadCostInquiryVOS(AsiaInlnadCostInquiryVO[] inlnadCostInquiryVOs){
		if(inlnadCostInquiryVOs != null){
			AsiaInlnadCostInquiryVO[] tmpVOs = new AsiaInlnadCostInquiryVO[inlnadCostInquiryVOs.length];
			System.arraycopy(inlnadCostInquiryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.asiaInlnadCostInquiryVOs = tmpVOs;
		}
	}

	public AsiaInlnadCostInquiryVO getInlnadCostInquiryVO(){
		return asiaInlnadCostInquiryVO;
	}

	public AsiaInlnadCostInquiryVO[] getInlnadCostInquiryVOS(){
		AsiaInlnadCostInquiryVO[] rtnVOs = null;
		if (this.asiaInlnadCostInquiryVOs != null) {
			rtnVOs = new AsiaInlnadCostInquiryVO[asiaInlnadCostInquiryVOs.length];
			System.arraycopy(asiaInlnadCostInquiryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	/* AsiaInlnadCostInquiryVO - end */
	
	/* AsiaInlnadCostSpeInquiryVO - start */
	public void setInlnadCostSpeInquiryVO(AsiaInlnadCostSpeInquiryVO asiaInlnadCostSpeInquiryVO){
		this. asiaInlnadCostSpeInquiryVO = asiaInlnadCostSpeInquiryVO;
	}

	public void setInlnadCostSpeInquiryVOS(AsiaInlnadCostSpeInquiryVO[] inlnadCostSpeInquiryVOs){
		if(inlnadCostSpeInquiryVOs != null){
			AsiaInlnadCostSpeInquiryVO[] tmpVOs = new AsiaInlnadCostSpeInquiryVO[inlnadCostSpeInquiryVOs.length];
			System.arraycopy(inlnadCostSpeInquiryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.asiaInlnadCostSpeInquiryVOs = tmpVOs;
		}
	}

	public AsiaInlnadCostSpeInquiryVO getInlnadCostSpeInquiryVO(){
		return asiaInlnadCostSpeInquiryVO;
	}

	public AsiaInlnadCostSpeInquiryVO[] getInlnadCostSpeInquiryVOS(){
		AsiaInlnadCostSpeInquiryVO[] rtnVOs = null;
		if (this.asiaInlnadCostSpeInquiryVOs != null) {
			rtnVOs = new AsiaInlnadCostSpeInquiryVO[asiaInlnadCostSpeInquiryVOs.length];
			System.arraycopy(asiaInlnadCostSpeInquiryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	/* AsiaInlnadCostSpeInquiryVO - end */
	
	public void setInlandCostConditionVO(AsiaInlandCostConditionVO asiaInlandCostConditionVO) {
		this.asiaInlandCostConditionVO = asiaInlandCostConditionVO;
	}
	
	public AsiaInlandCostConditionVO getInlandCostConditionVO() {
		return asiaInlandCostConditionVO;
	}
}
