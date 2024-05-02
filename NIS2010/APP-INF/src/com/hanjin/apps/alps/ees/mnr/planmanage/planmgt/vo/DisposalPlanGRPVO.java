/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DisposalPlanGRPVO
*@FileTitle : Disposal Planning
*Open Issues : 
*Change history :
*@LastModifyDate : 2009. 08. 19
*@LastModifier : 
*@LastVersion : 1.0
*2009. 08. 19. 김완규 
** 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo;

import java.util.List;
/**
 * DisposalPlanGRPVO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *  
 * @author 김완규
 * @since J2EE 1.5 
 * @see ..
 */ 
public class DisposalPlanGRPVO {
	//조회 조건을 받기 위한
	private DisposalPlanINVO disposalPlanINVO = null;
	//조회 결과를 받기 위한
    private  List <CustomMnrPlnHdrVO> listCustomMnrPlnHdrVO = null;
	private  List <CustomMnrPlnDtlVO> listCustomMnrPlnDtlVO = null;
	private  List<List<CustomMnrPlnTransVO>> listCustomMnrPlnTransVOs = null;
    //저장 처리를 위한
	private  CustomMnrPlnHdrVO[] arrayCustomMnrPlnHdrVOs = null;
	private  CustomMnrPlnDtlVO[] arrayCustomMnrPlnDtlVOs = null;
	private  CustomMnrPlnTransVO[] arrayCustomMnrPlnTransVOs = null;
	//저장 체크를 위한
	private String cnt = null;
	
	public DisposalPlanINVO getDisposalPlanINVO() {
		return disposalPlanINVO;
	}
	public void setDisposalPlanINVO(DisposalPlanINVO disposalPlanINVO) {
		this.disposalPlanINVO = disposalPlanINVO;
	}
	public List<CustomMnrPlnHdrVO> getListCustomMnrPlnHdrVO() {
		return listCustomMnrPlnHdrVO;
	}
	public void setListCustomMnrPlnHdrVO(
			List<CustomMnrPlnHdrVO> listCustomMnrPlnHdrVO) {
		this.listCustomMnrPlnHdrVO = listCustomMnrPlnHdrVO;
	}
	public List<CustomMnrPlnDtlVO> getListCustomMnrPlnDtlVO() {
		return listCustomMnrPlnDtlVO;
	}
	public void setListCustomMnrPlnDtlVO(
			List<CustomMnrPlnDtlVO> listCustomMnrPlnDtlVO) {
		this.listCustomMnrPlnDtlVO = listCustomMnrPlnDtlVO;
	}
	public List<List<CustomMnrPlnTransVO>> getListCustomMnrPlnTransVOs() {
		return listCustomMnrPlnTransVOs;
	}
	public void setListCustomMnrPlnTransVOs(
			List<List<CustomMnrPlnTransVO>> listCustomMnrPlnTransVOs) {
		this.listCustomMnrPlnTransVOs = listCustomMnrPlnTransVOs;
	}
	public CustomMnrPlnHdrVO[] getArrayCustomMnrPlnHdrVOs() {
		return arrayCustomMnrPlnHdrVOs;
	}
	public void setArrayCustomMnrPlnHdrVOs(
			CustomMnrPlnHdrVO[] arrayCustomMnrPlnHdrVOs) {
		this.arrayCustomMnrPlnHdrVOs = arrayCustomMnrPlnHdrVOs;
	}
	public CustomMnrPlnDtlVO[] getArrayCustomMnrPlnDtlVOs() {
		return arrayCustomMnrPlnDtlVOs;
	}
	public void setArrayCustomMnrPlnDtlVOs(
			CustomMnrPlnDtlVO[] arrayCustomMnrPlnDtlVOs) {
		this.arrayCustomMnrPlnDtlVOs = arrayCustomMnrPlnDtlVOs;
	}
	public CustomMnrPlnTransVO[] getArrayCustomMnrPlnTransVOs() {
		return arrayCustomMnrPlnTransVOs;
	}
	public void setArrayCustomMnrPlnTransVOs(
			CustomMnrPlnTransVO[] arrayCustomMnrPlnTransVOs) {
		this.arrayCustomMnrPlnTransVOs = arrayCustomMnrPlnTransVOs;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	
}
