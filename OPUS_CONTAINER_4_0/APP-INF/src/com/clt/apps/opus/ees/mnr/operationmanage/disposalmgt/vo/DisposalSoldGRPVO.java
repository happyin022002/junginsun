/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DisposalSoldGRPVO
*@FileTitle : Disposal Sold Creation
*Open Issues : 
*Change history :
*@LastModifyDate : 2009. 09.28
*@LastModifier : 
*@LastVersion : 1.0
*2009. 09.28. 김완규 
** 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo;

import java.util.List;

/**
 * DisposalSoldGRPVO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *  
 * @author 김완규
 * @since J2EE 1.5 
 * @see ..
 */
public class DisposalSoldGRPVO {
	//조회조건을 받기 위한
	private DisposalSoldINVO disposalSoldINVO = null;
	//조회결과을 받기 위한
	private  List <CustomMnrDispHdrVO> listCustomMnrDispHdrVO = null;
	private  List <CustomMnrDispDtlVO> listCustomMnrDispDtlVO = null;
	//CUD처리를 위한 
	private CustomMnrDispHdrVO[] arrayCustomMnrDispHdrVO = null;
	private CustomMnrDispDtlVO[] arrayCustomMnrDispDtlVO = null;
	//Release No 생성조회 결과를 받기 위한 
	private String dispRlseNo = null;

	public DisposalSoldINVO getDisposalSoldINVO() {
		return disposalSoldINVO;
	}
	public void setDisposalSoldINVO(DisposalSoldINVO disposalSoldINVO) {
		this.disposalSoldINVO = disposalSoldINVO;
	}
	public List<CustomMnrDispHdrVO> getListCustomMnrDispHdrVO() {
		return listCustomMnrDispHdrVO;
	}
	public void setListCustomMnrDispHdrVO(
			List<CustomMnrDispHdrVO> listCustomMnrDispHdrVO) {
		this.listCustomMnrDispHdrVO = listCustomMnrDispHdrVO;
	}
	public List<CustomMnrDispDtlVO> getListCustomMnrDispDtlVO() {
		return listCustomMnrDispDtlVO;
	}
	public void setListCustomMnrDispDtlVO(
			List<CustomMnrDispDtlVO> listCustomMnrDispDtlVO) {
		this.listCustomMnrDispDtlVO = listCustomMnrDispDtlVO;
	}
	public CustomMnrDispHdrVO[] getArrayCustomMnrDispHdrVO() {
		return arrayCustomMnrDispHdrVO;
	}
	public void setArrayCustomMnrDispHdrVO(
			CustomMnrDispHdrVO[] arrayCustomMnrDispHdrVO) {
		this.arrayCustomMnrDispHdrVO = arrayCustomMnrDispHdrVO;
	}
	public CustomMnrDispDtlVO[] getArrayCustomMnrDispDtlVO() {
		return arrayCustomMnrDispDtlVO;
	}
	public void setArrayCustomMnrDispDtlVO(
			CustomMnrDispDtlVO[] arrayCustomMnrDispDtlVO) {
		this.arrayCustomMnrDispDtlVO = arrayCustomMnrDispDtlVO;
	}
	public String getDispRlseNo() {
		return dispRlseNo;
	}
	public void setDispRlseNo(String dispRlseNo) {
		this.dispRlseNo = dispRlseNo;
	} 
}
