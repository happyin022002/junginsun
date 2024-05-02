/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VslSkdXtraHisVO.java
*@FileTitle : VslSkdXtraHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.08  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정상기
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VslSkdXtraHisGroupVO {

	private static final long serialVersionUID = 1L;
	
	//private List<VskVslSkdVO>		vskVslSkdVOs		= null;
	private List<VslSkdXtraHisVO>	vslSkdXtraHisVOs	= null;
	private String					sFromEventSystem	= null;
	
	public VslSkdXtraHisGroupVO() {}

	/**
	 * @return the vskVslSkdVOs
	 */
	//public List<VskVslSkdVO> getVskVslSkdVOs() {
	//	return vskVslSkdVOs;
	//}
	
	/**
	 * @return the vslSkdCngHisDtlVOs
	 */
	public List<VslSkdXtraHisVO> getVslSkdXtraHisVOs() {
		return vslSkdXtraHisVOs;
	}
	
	/**
	 * @return the sFromEventSystem
	 */
	public String getFromEventSystem() {
		return sFromEventSystem;
	}

	/**
	 * @param vskVslSkdVOs the vskVslSkdVOs to set
	 */
	//public void setVskVslSkdVOs(List<VskVslSkdVO> vskVslSkdVOs) {
	//	this.vskVslSkdVOs = vskVslSkdVOs;
	//}
	/**
	 * @param vslSkdCngHisDtlVOs the vslSkdCngHisDtlVOs to set
	 */
	public void setVslSkdXtraHisVOs(List<VslSkdXtraHisVO> vslSkdXtraHisVOs) {
		this.vslSkdXtraHisVOs = vslSkdXtraHisVOs;
	}
	
	/**
	 * @param the sFromEventSystem
	 */
	public void setFromEventSystem(String sFromEventSystem) {
		this.sFromEventSystem	= sFromEventSystem;
	}
		
}