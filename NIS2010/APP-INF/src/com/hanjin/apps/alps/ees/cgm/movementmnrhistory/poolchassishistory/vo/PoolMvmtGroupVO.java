/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PoolMvmtINVO.java
*@FileTitle : PoolMvmtINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.08.12 최민회 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo;

import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PoolMvmtGroupVO {
	
	public String[] getHead() {
		return head;
	}

	public void setHead(String[] head) {
		this.head = head;
	}
	
    private String[] head = null;

	List<PoolMvmtCompareSmryMGTVO>  poolmvmtcomparesmrymgtvo  = null;
	
	List<PoolMvmtCompareSmryMGTVO>  poolmvmtcomparesmrymgtvo2 = null;
	
	List<PoolMnrHistoryMGTVO>       poolmnrhistorymgtvo = null;
	
	List<PoolMnrHistoryMGTVO>       poolmnrhistorymgtvo2 = null;
	
	/**
	 * @return the poolmnrhistorymgtvo
	 */
	public List<PoolMnrHistoryMGTVO> getPoolmnrhistorymgtvo() {
		return poolmnrhistorymgtvo;
	}

	/**
	 * @param poolmnrhistorymgtvo the poolmnrhistorymgtvo to set
	 */
	public void setPoolmnrhistorymgtvo(List<PoolMnrHistoryMGTVO> poolmnrhistorymgtvo) {
		this.poolmnrhistorymgtvo = poolmnrhistorymgtvo;
	}

	/**
	 * @return the poolmnrhistorymgtvo2
	 */
	public List<PoolMnrHistoryMGTVO> getPoolmnrhistorymgtvo2() {
		return poolmnrhistorymgtvo2;
	}

	/**
	 * @param poolmnrhistorymgtvo2 the poolmnrhistorymgtvo2 to set
	 */
	public void setPoolmnrhistorymgtvo2(
			List<PoolMnrHistoryMGTVO> poolmnrhistorymgtvo2) {
		this.poolmnrhistorymgtvo2 = poolmnrhistorymgtvo2;
	}

	


	/**
	 * @return the poolmvmtcomparesmrymgtvo
	 */
	public List<PoolMvmtCompareSmryMGTVO> getPoolmvmtcomparesmrymgtvo() {
		return poolmvmtcomparesmrymgtvo;
	}

	/**
	 * @param poolmvmtcomparesmrymgtvo the poolmvmtcomparesmrymgtvo to set
	 */
	public void setPoolmvmtcomparesmrymgtvo(
			List<PoolMvmtCompareSmryMGTVO> poolmvmtcomparesmrymgtvo) {
		this.poolmvmtcomparesmrymgtvo = poolmvmtcomparesmrymgtvo;
	}

	/**
	 * @return the poolmvmtcomparesmrymgtvo2
	 */
	public List<PoolMvmtCompareSmryMGTVO> getPoolmvmtcomparesmrymgtvo2() {
		return poolmvmtcomparesmrymgtvo2;
	}

	/**
	 * @param poolmvmtcomparesmrymgtvo2 the poolmvmtcomparesmrymgtvo2 to set
	 */
	public void setPoolmvmtcomparesmrymgtvo2(
			List<PoolMvmtCompareSmryMGTVO> poolmvmtcomparesmrymgtvo2) {
		this.poolmvmtcomparesmrymgtvo2 = poolmvmtcomparesmrymgtvo2;
	}
}
