/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3310Event.java
*@FileTitle : Inland Cost Inquiry(Usa)
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2015.03.06 최성환 [CHM-201534710] AOC 2차 소스 보안 품질 진행 요청
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.event;

import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostConditionVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlnadCostInquiryVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlnadCostSpeInquiryVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_AOC_3310 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_AOC_3310HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_AOC_3310HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdAoc3310Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private UsaInlnadCostInquiryVO usaInlnadCostInquiryVO = null;
	private UsaInlnadCostSpeInquiryVO usaInlnadCostSpeInquiryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private UsaInlnadCostInquiryVO[] usaInlnadCostInquiryVOs = null;
	private UsaInlnadCostSpeInquiryVO[] usaInlnadCostSpeInquiryVOs = null;
	private UsaInlandCostConditionVO usaInlandCostConditionVO = null;
	
	public EsdAoc3310Event(){}
	
	/* UsaInlnadCostInquiryVO - start */
	public void setInlnadCostInquiryVO(UsaInlnadCostInquiryVO usaInlnadCostInquiryVO){
		this. usaInlnadCostInquiryVO = usaInlnadCostInquiryVO;
	}

	public void setInlnadCostInquiryVOS(UsaInlnadCostInquiryVO[] inlnadCostInquiryVOs){
		if(inlnadCostInquiryVOs != null){
			UsaInlnadCostInquiryVO[] tmpVOs = new UsaInlnadCostInquiryVO[inlnadCostInquiryVOs.length];
			System.arraycopy(inlnadCostInquiryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.usaInlnadCostInquiryVOs = tmpVOs;
		}
	}

	public UsaInlnadCostInquiryVO getInlnadCostInquiryVO(){
		return usaInlnadCostInquiryVO;
	}

	public UsaInlnadCostInquiryVO[] getInlnadCostInquiryVOS(){
		UsaInlnadCostInquiryVO[] rtnVOs = null;
		if (this.usaInlnadCostInquiryVOs != null) {
			rtnVOs = new UsaInlnadCostInquiryVO[usaInlnadCostInquiryVOs.length];
			System.arraycopy(usaInlnadCostInquiryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	/* UsaInlnadCostInquiryVO - end */
	
	/* UsaInlnadCostSpeInquiryVO - start */
	public void setInlnadCostSpeInquiryVO(UsaInlnadCostSpeInquiryVO usaInlnadCostSpeInquiryVO){
		this. usaInlnadCostSpeInquiryVO = usaInlnadCostSpeInquiryVO;
	}

	public void setInlnadCostSpeInquiryVOS(UsaInlnadCostSpeInquiryVO[] inlnadCostSpeInquiryVOs){
		if(inlnadCostSpeInquiryVOs != null){
			UsaInlnadCostSpeInquiryVO[] tmpVOs = new UsaInlnadCostSpeInquiryVO[inlnadCostSpeInquiryVOs.length];
			System.arraycopy(inlnadCostSpeInquiryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.usaInlnadCostSpeInquiryVOs = tmpVOs;
		}
	}

	public UsaInlnadCostSpeInquiryVO getInlnadCostSpeInquiryVO(){
		return usaInlnadCostSpeInquiryVO;
	}

	public UsaInlnadCostSpeInquiryVO[] getInlnadCostSpeInquiryVOS(){
		UsaInlnadCostSpeInquiryVO[] rtnVOs = null;
		if (this.usaInlnadCostSpeInquiryVOs != null) {
			rtnVOs = new UsaInlnadCostSpeInquiryVO[usaInlnadCostSpeInquiryVOs.length];
			System.arraycopy(usaInlnadCostSpeInquiryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	/* UsaInlnadCostSpeInquiryVO - end */
	
	public void setInlandCostConditionVO(UsaInlandCostConditionVO usaInlandCostConditionVO) {
		this.usaInlandCostConditionVO = usaInlandCostConditionVO;
	}
	
	public UsaInlandCostConditionVO getInlandCostConditionVO() {
		return usaInlandCostConditionVO;
	}
}
