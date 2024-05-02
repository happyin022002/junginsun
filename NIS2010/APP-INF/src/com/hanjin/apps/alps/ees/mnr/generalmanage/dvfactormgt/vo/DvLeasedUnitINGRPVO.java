/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DvLeasedUnitINGRPVO.java
*@FileTitle : DV Leased Unit GROUP VO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.01
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2011.04.01 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo;
import java.util.List;
/**
 * DV Leased Unit GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *
 * @author 김영오
 * @since J2EE 1.6
 * @see
 */
public class DvLeasedUnitINGRPVO {
	//조회조건을 받기위한
	private DvLeasedUnitINVO dvLeasedUnitINVO= null;
	//단건 조회결과를 받기위한
	private List<DvLeasedUnitVO> dvLeasedUnitVOs = null;
	//다중 조회 결과를 받기위한
	private List<List<DvLeasedUnitVO>> listDvLeasedUnitVOs = null;
	//CUD처리를 위한 
	private DvLeasedUnitVO[] arrayDvLeasedUnitVOs = null;
	
	
	
	public DvLeasedUnitINVO getDvLeasedUnitINVO() {
		return dvLeasedUnitINVO;
	}
	public void setDvLeasedUnitINVO(DvLeasedUnitINVO dvLeasedUnitINVO) {
		this.dvLeasedUnitINVO = dvLeasedUnitINVO;
	}
	public List<DvLeasedUnitVO> getDvLeasedUnitVOs() {
		return dvLeasedUnitVOs;
	}
	public void setDvLeasedUnitVOs(List<DvLeasedUnitVO> dvLeasedUnitVOs) {
		this.dvLeasedUnitVOs = dvLeasedUnitVOs;
	}
	public List<List<DvLeasedUnitVO>> getListDvLeasedUnitVOs() {
		return listDvLeasedUnitVOs;
	}
	public void setListDvLeasedUnitVOs(
			List<List<DvLeasedUnitVO>> listDvLeasedUnitVOs) {
		this.listDvLeasedUnitVOs = listDvLeasedUnitVOs;
	}
	public DvLeasedUnitVO[] getArrayDvLeasedUnitVOs() {
		return arrayDvLeasedUnitVOs;
	}
	public void setArrayDvLeasedUnitVOs(DvLeasedUnitVO[] arrayDvLeasedUnitVOs) {
		this.arrayDvLeasedUnitVOs = arrayDvLeasedUnitVOs;
	}
}
