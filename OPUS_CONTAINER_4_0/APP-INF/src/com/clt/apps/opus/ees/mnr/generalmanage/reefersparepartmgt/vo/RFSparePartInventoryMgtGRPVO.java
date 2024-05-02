/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFSparePartInventoryMgtGRPVO
*@FileTitle : 
*Open Issues : 
*Change history :
*@LastModifyDate : 2009. 5. 14.
*@LastModifier : 권영법 
*@LastVersion : 1.0
*2009. 5. 14. 권영법 
** 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.vo;

import java.util.List;
/**
 * GeneralCodeMgt GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *
 * @author 권영법
 * @since J2EE 1.5
 * @see
 */
public class RFSparePartInventoryMgtGRPVO  {
	//콤보조회를 위한 리스트
	private List<RFSparePartInventoryListVO> rfSparePartInventoryListVOs = null;
	//조회조건을 받기위한
	private RFSparePartInventoryMgtINVO rfSparePartInventoryMgtINVO= null;
	//CUD처리를 위한 
	private RFSparePartInventoryListVO[] arrayRFSparePartInventoryListVOs = null;
	//다중조회 처리를 위한
	private List<List<RFSparePartInventoryListVO>> listRFSparePartInventoryListVOs = null;
	
	public List<RFSparePartInventoryListVO> getRFSparePartInventoryListVOs() {
		return rfSparePartInventoryListVOs;
	}
	public void setRFSparePartInventoryListVOs(List<RFSparePartInventoryListVO> rfSparePartInventoryListVOs) {
		this.rfSparePartInventoryListVOs = rfSparePartInventoryListVOs;
	}
	
	public RFSparePartInventoryMgtINVO getRFSparePartInventoryMgtINVO() {
		return rfSparePartInventoryMgtINVO;
	}
	public void setRFSparePartInventoryMgtINVO(RFSparePartInventoryMgtINVO rfSparePartInventoryMgtINVO) {
		this.rfSparePartInventoryMgtINVO = rfSparePartInventoryMgtINVO;
	}
	
	public RFSparePartInventoryListVO[] getArrayRFSparePartInventoryListVOs() {
		return arrayRFSparePartInventoryListVOs;
	}
	public void setArrayRFSparePartInventoryListVOs(RFSparePartInventoryListVO[] arrayRFSparePartInventoryListVOs) {
		this.arrayRFSparePartInventoryListVOs = arrayRFSparePartInventoryListVOs;
	}
	
	public List<List<RFSparePartInventoryListVO>> getListRFSparePartInventoryListVOs() {
		return listRFSparePartInventoryListVOs;
	}
	public void setListRFSparePartInventoryListVOs(
			List<List<RFSparePartInventoryListVO>> listRFSparePartInventoryListVOs) {
		this.listRFSparePartInventoryListVOs = listRFSparePartInventoryListVOs;
	}

	

}
