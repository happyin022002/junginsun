/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DVFactorGRPVO
*@FileTitle : 
*Open Issues : 
*Change history :
*@LastModifyDate : 2009. 5. 20.
*@LastModifier : 
*@LastVersion : 1.0
*2009. 5. 20. 김완규 
** 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo;
import java.util.List;
/**
 * DVFactor GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *
 * @author 김완규
 * @since J2EE 1.5
 * @see
 */
public class DVFactorGRPVO {
	//조회조건을 받기위한
	private DVFactorINVO dVFactorINVO= null;
	//단건 조회결과를 받기위한
	private List<CustomMnrEqDpcVO> customMnrEqDpcVOs = null;
	//다중 조회 결과를 받기위한
	private List<List<CustomMnrEqDpcVO>> listCustomMnrEqDpcVOs = null;
	//CUD처리를 위한 
	private CustomMnrEqDpcVO[] arrayCustomMnrEqDpcVOs = null;
	
	
	public DVFactorINVO getDVFactorINVO() {
		return dVFactorINVO;
	}
	public void setDVFactorINVO(DVFactorINVO factorINVO) {
		dVFactorINVO = factorINVO;
	}
	
	public List<CustomMnrEqDpcVO> getCustomMnrEqDpcVOs() {
		return customMnrEqDpcVOs;
	}
	public void setCustomMnrEqDpcVOs(List<CustomMnrEqDpcVO> customMnrEqDpcVOs) {
		this.customMnrEqDpcVOs = customMnrEqDpcVOs;
	}
	
	public List<List<CustomMnrEqDpcVO>> getListCustomMnrEqDpcVOs() {
		return listCustomMnrEqDpcVOs;
	}
	public void setListCustomMnrEqDpcVOs(
			List<List<CustomMnrEqDpcVO>> listCustomMnrEqDpcVOs) {
		this.listCustomMnrEqDpcVOs = listCustomMnrEqDpcVOs;
	}
	
	public CustomMnrEqDpcVO[] getArrayCustomMnrEqDpcVOs() {
		return arrayCustomMnrEqDpcVOs;
	}
	public void setArrayCustomMnrEqDpcVOs(CustomMnrEqDpcVO[] arrayCustomMnrEqDpcVOs) {
		this.arrayCustomMnrEqDpcVOs = arrayCustomMnrEqDpcVOs;
	}
    
}
