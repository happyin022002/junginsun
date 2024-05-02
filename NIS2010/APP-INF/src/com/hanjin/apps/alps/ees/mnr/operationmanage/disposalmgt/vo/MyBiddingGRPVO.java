/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MyBiddingGRPVO
*@FileTitle : My Bidding List
*Open Issues : 
*Change history :
*@LastModifyDate : 2009. 12.03
*@LastModifier : 
*@LastVersion : 1.0
*2009. 12.03. 김완규 
** 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo;

import java.util.List;

/**
 * MyBiddingGRPVO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *  
 * @author 김완규
 * @since J2EE 1.5 
 * @see ..
 */
public class MyBiddingGRPVO {
	//조회조건을 받기 위한
	private MyBiddingINVO myBiddingINVO = null;
	private CustomMyBiddingHdrVO customMyBiddingHdrVO = null;
	//조회결과을 받기 위한
	private  List <CustomMyBiddingHdrVO> listCustomMyBiddingHdrVO = null;
	private  List <CustomMyBiddingDtlVO> listEqCustomMyBiddingDtlVO = null;
	private  List <CustomMyBiddingDtlVO> listQtyCustomMyBiddingDtlVO = null;
	//CUD처리를 위한 
	private CustomMyBiddingDtlVO[] arrayCustomMyBiddingDtlVO = null;
	//저장후 리턴값을 위한
	private String dispNo = null;
	
	public MyBiddingINVO getMyBiddingINVO() {
		return myBiddingINVO;
	}
	public void setMyBiddingINVO(MyBiddingINVO myBiddingINVO) {
		this.myBiddingINVO = myBiddingINVO;
	}
	public CustomMyBiddingHdrVO getCustomMyBiddingHdrVO() {
		return customMyBiddingHdrVO;
	}
	public void setCustomMyBiddingHdrVO(CustomMyBiddingHdrVO customMyBiddingHdrVO) {
		this.customMyBiddingHdrVO = customMyBiddingHdrVO;
	}
	public List<CustomMyBiddingHdrVO> getListCustomMyBiddingHdrVO() {
		return listCustomMyBiddingHdrVO;
	}
	public void setListCustomMyBiddingHdrVO(
			List<CustomMyBiddingHdrVO> listCustomMyBiddingHdrVO) {
		this.listCustomMyBiddingHdrVO = listCustomMyBiddingHdrVO;
	}
	public List<CustomMyBiddingDtlVO> getListEqCustomMyBiddingDtlVO() {
		return listEqCustomMyBiddingDtlVO;
	}
	public void setListEqCustomMyBiddingDtlVO(
			List<CustomMyBiddingDtlVO> listEqCustomMyBiddingDtlVO) {
		this.listEqCustomMyBiddingDtlVO = listEqCustomMyBiddingDtlVO;
	}
	public List<CustomMyBiddingDtlVO> getListQtyCustomMyBiddingDtlVO() {
		return listQtyCustomMyBiddingDtlVO;
	}
	public void setListQtyCustomMyBiddingDtlVO(
			List<CustomMyBiddingDtlVO> listQtyCustomMyBiddingDtlVO) {
		this.listQtyCustomMyBiddingDtlVO = listQtyCustomMyBiddingDtlVO;
	}
	public CustomMyBiddingDtlVO[] getArrayCustomMyBiddingDtlVO() {
		return arrayCustomMyBiddingDtlVO;
	}
	public void setArrayCustomMyBiddingDtlVO(
			CustomMyBiddingDtlVO[] arrayCustomMyBiddingDtlVO) {
		this.arrayCustomMyBiddingDtlVO = arrayCustomMyBiddingDtlVO;
	}
	public String getDispNo() {
		return dispNo;
	}
	public void setDispNo(String dispNo) {
		this.dispNo = dispNo;
	}
}
