/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFSparePartCodeMgtGRPVO
*@FileTitle : 
*Open Issues : 
*Change history :
*@LastModifyDate : 2009. 5. 14.
*@LastModifier : 권영법 
*@LastVersion : 1.0
*2009. 5. 14. 권영법 
** 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo;

import java.util.List;
/**
 * GeneralCodeMgt GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *
 * @author 권영법
 * @since J2EE 1.5
 * @see
 */
public class RFSparePartCodeMgtGRPVO  {
	private String workType = null;
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	//콤보조회를 위한 리스트
	private List<MnrReeferSparePartCodeVO> mnrReeferSparePartCodeVOs = null;
	//조회조건을 받기위한
	private RFSparePartCodeMgtINVO rfSparePartCodeMgtINVO= null;
	//CUD처리를 위한 
	private MnrReeferSparePartCodeVO[] arrayMnrReeferSparePartCodeVOs = null;
	//다중조회 처리를 위한
	private List<List<MnrReeferSparePartCodeVO>> listMnrReeferSparePartCodeVOs = null;
	
	public List<MnrReeferSparePartCodeVO> getMnrReeferSparePartCodeVOs() {
		return mnrReeferSparePartCodeVOs;
	}
	public void setMnrReeferSparePartCodeVOs(List<MnrReeferSparePartCodeVO> mnrReeferSparePartCodeVOs) {
		this.mnrReeferSparePartCodeVOs = mnrReeferSparePartCodeVOs;
	}
	
	public RFSparePartCodeMgtINVO getRFSparePartCodeMgtINVO() {
		return rfSparePartCodeMgtINVO;
	}
	public void setRFSparePartCodeMgtINVO(RFSparePartCodeMgtINVO rfSparePartCodeMgtINVO) {
		this.rfSparePartCodeMgtINVO = rfSparePartCodeMgtINVO;
	}
	
	public MnrReeferSparePartCodeVO[] getArrayMnrReeferSparePartCodeVOs() {
		return arrayMnrReeferSparePartCodeVOs;
	}
	public void setArrayMnrReeferSparePartCodeVOs(MnrReeferSparePartCodeVO[] arrayMnrReeferSparePartCodeVOs) {
		this.arrayMnrReeferSparePartCodeVOs = arrayMnrReeferSparePartCodeVOs;
	}
	
	public List<List<MnrReeferSparePartCodeVO>> getListMnrReeferSparePartCodeVOs() {
		return listMnrReeferSparePartCodeVOs;
	}
	public void setListMnrReeferSparePartCodeVOs(
			List<List<MnrReeferSparePartCodeVO>> listMnrReeferSparePartCodeVOs) {
		this.listMnrReeferSparePartCodeVOs = listMnrReeferSparePartCodeVOs;
	}

	

}
