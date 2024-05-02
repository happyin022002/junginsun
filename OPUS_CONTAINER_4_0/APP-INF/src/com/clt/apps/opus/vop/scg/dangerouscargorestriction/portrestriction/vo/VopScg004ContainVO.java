/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchScgImdgPortRstrVO.java
*@FileTitle : SearchScgImdgPortRstrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.05.28 장강철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.vo;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.syscommon.common.table.ScgImdgPortRstrDtlVO;
import com.clt.syscommon.common.table.ScgImdgPortRstrVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VopScg004ContainVO   {

	private static final long serialVersionUID = 1L;
	private PortRestrictonOptionVO condition = null;	
	/**  Prohibition  */	
	private PortRestrictionVO[]  ProhscgImdgPortRstrVOs = null;
	/**  Direct Load  */	
	private PortRestrictionVO[]  DirectLosdScgImdgPortRstrVOs  = null;
	/**  Competent   */	
	private SearchScgImdgPortRstrDtlVO[]  CompetScgImdgPortRstrDtlVOs = null;
	/**  Max Quantity   */	
	private SearchScgImdgPortRstrDtlVO[]  QuantiScgImdgPortRstrDtlVOs = null;
	/**  Text Explanation   */	
	private SearchScgImdgPortRstrDtlVO[]  ExplanScgImdgPortRstrDtlVOs = null;
	
    /**
	 * @return the rstrRmk
	 */
	public String getRstrRmk() {
		return RstrRmk;
	}
	/**
	 * @param rstrRmk the rstrRmk to set
	 */
	public void setRstrRmk(String rstrRmk) {
		RstrRmk = rstrRmk;
	}
	private String RstrRmk = "";
 
 
 
	/**
	 * @return the prohscgImdgPortRstrVOs
	 */
	public PortRestrictionVO[] getProhscgImdgPortRstrVOs() {
		return ProhscgImdgPortRstrVOs;
	}
	/**
	 * @param prohscgImdgPortRstrVOs the prohscgImdgPortRstrVOs to set
	 */
	public void setProhscgImdgPortRstrVOs(
			PortRestrictionVO[] prohscgImdgPortRstrVOs) {
		ProhscgImdgPortRstrVOs = prohscgImdgPortRstrVOs;
	}
	/**
	 * @return the directLosdScgImdgPortRstrVOs
	 */
	public PortRestrictionVO[] getDirectLosdScgImdgPortRstrVOs() {
		return DirectLosdScgImdgPortRstrVOs;
	}
	/**
	 * @param directLosdScgImdgPortRstrVOs the directLosdScgImdgPortRstrVOs to set
	 */
	public void setDirectLosdScgImdgPortRstrVOs(
			PortRestrictionVO[] directLosdScgImdgPortRstrVOs) {
		DirectLosdScgImdgPortRstrVOs = directLosdScgImdgPortRstrVOs;
	}
	/**
	 * @return the competScgImdgPortRstrDtlVOs
	 */
	public SearchScgImdgPortRstrDtlVO[] getCompetScgImdgPortRstrDtlVOs() {
		return CompetScgImdgPortRstrDtlVOs;
	}
	/**
	 * @param competScgImdgPortRstrDtlVOs the competScgImdgPortRstrDtlVOs to set
	 */
	public void setCompetScgImdgPortRstrDtlVOs(
			SearchScgImdgPortRstrDtlVO[] competScgImdgPortRstrDtlVOs) {
		CompetScgImdgPortRstrDtlVOs = competScgImdgPortRstrDtlVOs;
	}
	/**
	 * @return the quantiScgImdgPortRstrDtlVOs
	 */
	public SearchScgImdgPortRstrDtlVO[] getQuantiScgImdgPortRstrDtlVOs() {
		return QuantiScgImdgPortRstrDtlVOs;
	}
	/**
	 * @param quantiScgImdgPortRstrDtlVOs the quantiScgImdgPortRstrDtlVOs to set
	 */
	public void setQuantiScgImdgPortRstrDtlVOs(
			SearchScgImdgPortRstrDtlVO[] quantiScgImdgPortRstrDtlVOs) {
		QuantiScgImdgPortRstrDtlVOs = quantiScgImdgPortRstrDtlVOs;
	}
	/**
	 * @return the explanScgImdgPortRstrDtlVOs
	 */
	public SearchScgImdgPortRstrDtlVO[] getExplanScgImdgPortRstrDtlVOs() {
		return ExplanScgImdgPortRstrDtlVOs;
	}
	/**
	 * @param explanScgImdgPortRstrDtlVOs the explanScgImdgPortRstrDtlVOs to set
	 */
	public void setExplanScgImdgPortRstrDtlVOs(
			SearchScgImdgPortRstrDtlVO[] explanScgImdgPortRstrDtlVOs) {
		ExplanScgImdgPortRstrDtlVOs = explanScgImdgPortRstrDtlVOs;
	}
    /**
     * @return the condition
     */
    public PortRestrictonOptionVO getCondition() {
        return condition;
    }
    /**
     * @param condition the condition to set
     */
    public void setCondition(PortRestrictonOptionVO condition) {
        this.condition = condition;
    }
}
