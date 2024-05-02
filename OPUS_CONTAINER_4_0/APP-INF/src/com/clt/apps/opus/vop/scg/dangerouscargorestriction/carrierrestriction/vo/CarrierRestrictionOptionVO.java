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

package com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.vo;

import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CarrierRestrictionOptionVO   {

	private static final long serialVersionUID = 1L;
	private VopScg0009ConditionVO condition = null;
	private CarrierRestrictionVO   classCarrierRestrictionVO = null;	
	private CarrierRestrictionVO[] classCarrierRestrictionVOs = null;
	
	private CarrierRestrictionVO   unnoCarrierRestrictionVO = null;	
	private CarrierRestrictionVO[] unnoCarrierRestrictionVOs = null;	
	
	private List<CarrierRestrictionVO> list = null;
	
	private String msgCode = null;
    private String msgCodeNm = null;
 
	/**
	 * @return the msgCode
	 */
	public String getMsgCode() {
		return msgCode;
	}
	/**
	 * @param msgCode the msgCode to set
	 */
	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}
	/**
	 * @return the list
	 */
	public List<CarrierRestrictionVO> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<CarrierRestrictionVO> list) {
		this.list = list;
	}
		
	
 
	/**
	 * @return the classCarrierRestrictionVO
	 */
	public CarrierRestrictionVO getClassCarrierRestrictionVO() {
		return classCarrierRestrictionVO;
	}
	/**
	 * @return the classCarrierRestrictionVOs
	 */
	public CarrierRestrictionVO[] getClassCarrierRestrictionVOs() {
		return classCarrierRestrictionVOs;
	}
	/**
	 * @return the unnoCarrierRestrictionVO
	 */
	public CarrierRestrictionVO getUnnoCarrierRestrictionVO() {
		return unnoCarrierRestrictionVO;
	}
	/**
	 * @return the unnoCarrierRestrictionVOs
	 */
	public CarrierRestrictionVO[] getUnnoCarrierRestrictionVOs() {
		return unnoCarrierRestrictionVOs;
	}
	/**
	 * @param classCarrierRestrictionVO the classCarrierRestrictionVO to set
	 */
	public void setClassCarrierRestrictionVO(
			CarrierRestrictionVO classCarrierRestrictionVO) {
		this.classCarrierRestrictionVO = classCarrierRestrictionVO;
	}
	/**
	 * @param classCarrierRestrictionVOs the classCarrierRestrictionVOs to set
	 */
	public void setClassCarrierRestrictionVOs(
			CarrierRestrictionVO[] classCarrierRestrictionVOs) {
		this.classCarrierRestrictionVOs = classCarrierRestrictionVOs;
	}
	/**
	 * @param unnoCarrierRestrictionVO the unnoCarrierRestrictionVO to set
	 */
	public void setUnnoCarrierRestrictionVO(
			CarrierRestrictionVO unnoCarrierRestrictionVO) {
		this.unnoCarrierRestrictionVO = unnoCarrierRestrictionVO;
	}
	/**
	 * @param unnoCarrierRestrictionVOs the unnoCarrierRestrictionVOs to set
	 */
	public void setUnnoCarrierRestrictionVOs(
			CarrierRestrictionVO[] unnoCarrierRestrictionVOs) {
		this.unnoCarrierRestrictionVOs = unnoCarrierRestrictionVOs;
	}
	/**
	 * @return the condition
	 */
	public VopScg0009ConditionVO getCondition() {
		return condition;
	}
	/**
	 * @param condition the condition to set
	 */
	public void setCondition(VopScg0009ConditionVO condition) {
		this.condition = condition;
	}
    /**
     * @return the msgCodeNm
     */
    public String getMsgCodeNm() {
        return msgCodeNm;
    }
    /**
     * @param msgCodeNm the msgCodeNm to set
     */
    public void setMsgCodeNm(String msgCodeNm) {
        this.msgCodeNm = msgCodeNm;
    }	
 
}
