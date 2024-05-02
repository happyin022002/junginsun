package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
*
* 관련 VO List
*
* @author 최영희
* @since J2EE 1.6
* @see AbstractValueObject
*/
public class YardAssignVO {
	private BkgInfoForYardAssignVO bkgInfoForYardAssignVO = null;
	private List<QtyInfoVO>qtyInfoVOList =null;
	private QtyInfoVO[] qtyInfoVOs =null;
	
	public BkgInfoForYardAssignVO getBkgInfoForYardAssignVO() {
		return bkgInfoForYardAssignVO;
	}
	public void setBkgInfoForYardAssignVO(
			BkgInfoForYardAssignVO bkgInfoForYardAssignVO) {
		this.bkgInfoForYardAssignVO = bkgInfoForYardAssignVO;
	}
	public List<QtyInfoVO> getQtyInfoVOList() {
		return qtyInfoVOList;
	}
	public void setQtyInfoVOList(List<QtyInfoVO> qtyInfoVOList) {
		this.qtyInfoVOList = qtyInfoVOList;
	}
	public QtyInfoVO[] getQtyInfoVOs() {
		return qtyInfoVOs;
	}
	public void setQtyInfoVOs(QtyInfoVO[] qtyInfoVOs) {
		this.qtyInfoVOs = qtyInfoVOs;
	}
	 
	
	
}
