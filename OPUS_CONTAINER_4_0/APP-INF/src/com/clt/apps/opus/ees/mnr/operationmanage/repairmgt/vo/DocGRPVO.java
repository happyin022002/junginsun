/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DocGRPVO
*@FileTitle : DocGRPVO
*Open Issues : 
*Change history :
*@LastModifyDate : 2009. 8. 4
*@LastModifier : 
*@LastVersion : 1.0
*2009. 8. 4. 함형석 
** 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo;

import java.util.List;

/**
 * EstimateGRPVO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *  
 * @author 함형석
 * @since J2EE 1.5 
 * @see ..
 */ 
public class DocGRPVO { 
	//조회 결과를 받기 위한   	
	private List<CustomDocHeaderVO> customDocHeaderVOs = null; 
	//조회 조건을 받기 위한 
	private DocINVO docINVO = null;
	//다건 저장을 위한    	  
	private CustomDocHeaderVO[] arrcustomDocHeaderVOs = null; 	
	//단건 저장을 위한    	  
	private CustomDocHeaderVO customDocHeaderVO = null; 	
	//저장을 위한  
	private CustomMnrOrdHdrVO customMnrOrdHdrVO = null;
	public List<CustomDocHeaderVO> getCustomDocHeaderVOs() {
		return customDocHeaderVOs;
	}
	public void setCustomDocHeaderVOs(List<CustomDocHeaderVO> customDocHeaderVOs) {
		this.customDocHeaderVOs = customDocHeaderVOs;
	}
	public DocINVO getDocINVO() {
		return docINVO;
	}
	public void setDocINVO(DocINVO docINVO) {
		this.docINVO = docINVO;
	}
	public CustomDocHeaderVO[] getArrcustomDocHeaderVOs() {
		return arrcustomDocHeaderVOs;
	}
	public void setArrcustomDocHeaderVOs(CustomDocHeaderVO[] arrcustomDocHeaderVOs) {
		this.arrcustomDocHeaderVOs = arrcustomDocHeaderVOs;
	}
	public CustomDocHeaderVO getCustomDocHeaderVO() {
		return customDocHeaderVO;
	}
	public void setCustomDocHeaderVO(CustomDocHeaderVO customDocHeaderVO) {
		this.customDocHeaderVO = customDocHeaderVO;
	}
	public CustomMnrOrdHdrVO getCustomMnrOrdHdrVO() {
		return customMnrOrdHdrVO;
	}
	public void setCustomMnrOrdHdrVO(CustomMnrOrdHdrVO customMnrOrdHdrVO) {
		this.customMnrOrdHdrVO = customMnrOrdHdrVO;
	} 
}
