/**
 * 
 */
package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo;

import java.util.List;

/**
 * @author zero
 *
 */
public class GuidelineGRPVO {
	
	private GuidelineINVO guidelineINVO = null;
	
	private  CustomMnrGuidelineVO[] customMnrGuidelineVOs = null;
	
    private  List <CustomMnrGuidelineVO> customMnrGuidelineLst = null;

	/**
	 * @return the guidelineINVO
	 */
	public GuidelineINVO getGuidelineINVO() {
		return guidelineINVO;
	}

	/**
	 * @param guidelineINVO the guidelineINVO to set
	 */
	public void setGuidelineINVO(GuidelineINVO guidelineINVO) {
		this.guidelineINVO = guidelineINVO;
	}

	/**
	 * @return the customMnrGuidelineVOs
	 */
	public CustomMnrGuidelineVO[] getCustomMnrGuidelineVOs() {
		return customMnrGuidelineVOs;
	}

	/**
	 * @param customMnrGuidelineVOs the customMnrGuidelineVOs to set
	 */
	public void setCustomMnrGuidelineVOs(
			CustomMnrGuidelineVO[] customMnrGuidelineVOs) {
		this.customMnrGuidelineVOs = customMnrGuidelineVOs;
	}

	/**
	 * @return the customMnrGuidelineLst
	 */
	public List<CustomMnrGuidelineVO> getCustomMnrGuidelineLst() {
		return customMnrGuidelineLst;
	}

	/**
	 * @param customMnrGuidelineLst the customMnrGuidelineLst to set
	 */
	public void setCustomMnrGuidelineLst(
			List<CustomMnrGuidelineVO> customMnrGuidelineLst) {
		this.customMnrGuidelineLst = customMnrGuidelineLst;
	}

}
