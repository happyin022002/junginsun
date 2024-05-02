/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SwapCstGRPVO.java
*@FileTitle : SwapCstGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.06.22 정진우 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정진우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SwapCstGRPVO {

	private static final long serialVersionUID = 1L;
	
	private String vslCd = null;
	private String portCd = null;
	private String yardCd = null;
	private VskVslSkdVO vskVslSkdVO = null;
	private VskVslPortSkdVO vskVslPortSkdVO = null;

	private String[] vslCds = null;
	private String[] portCds = null;
	private String[] yardCds = null;
	private List<VskVslSkdVO> vskVslSkdVOList = null;
	private List<VskVslPortSkdVO> vskVslPortSkdVOList = null;
	
	public SwapCstGRPVO() {}

	/**
	 * @return the portCd
	 */
	public String getPortCd() {
		return portCd;
	}

	/**
	 * @param portCd the portCd to set
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	/**
	 * @return the yardCd
	 */
	public String getYardCd() {
		return yardCd;
	}

	/**
	 * @param yardCd the yardCd to set
	 */
	public void setYardCd(String yardCd) {
		this.yardCd = yardCd;
	}

	/**
	 * @return the portCds
	 */
	public String[] getPortCds() {
		return portCds;
	}

	/**
	 * @param portCds the portCds to set
	 */
	public void setPortCds(String[] portCds) {
		this.portCds = portCds;
	}

	/**
	 * @return the yardCds
	 */
	public String[] getYardCds() {
		return yardCds;
	}

	/**
	 * @param yardCds the yardCds to set
	 */
	public void setYardCds(String[] yardCds) {
		this.yardCds = yardCds;
	}

	/**
	 * @return the vslCd
	 */
	public String getVslCd() {
		return vslCd;
	}

	/**
	 * @param vslCd the vslCd to set
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	/**
	 * @return the vslCds
	 */
	public String[] getVslCds() {
		return vslCds;
	}

	/**
	 * @param vslCds the vslCds to set
	 */
	public void setVslCds(String[] vslCds) {
		this.vslCds = vslCds;
	}

	/**
	 * @return the vskVslSkdVO
	 */
	public VskVslSkdVO getVskVslSkdVO() {
		return vskVslSkdVO;
	}

	/**
	 * @param vskVslSkdVO the vskVslSkdVO to set
	 */
	public void setVskVslSkdVO(VskVslSkdVO vskVslSkdVO) {
		this.vskVslSkdVO = vskVslSkdVO;
	}

	/**
	 * @return the vskVslPortSkdVO
	 */
	public VskVslPortSkdVO getVskVslPortSkdVO() {
		return vskVslPortSkdVO;
	}

	/**
	 * @param vskVslPortSkdVO the vskVslPortSkdVO to set
	 */
	public void setVskVslPortSkdVO(VskVslPortSkdVO vskVslPortSkdVO) {
		this.vskVslPortSkdVO = vskVslPortSkdVO;
	}

	/**
	 * @return the vskVslSkdVOList
	 */
	public List<VskVslSkdVO> getVskVslSkdVOList() {
		return vskVslSkdVOList;
	}

	/**
	 * @param vskVslSkdVOList the vskVslSkdVOList to set
	 */
	public void setVskVslSkdVOList(List<VskVslSkdVO> vskVslSkdVOList) {
		this.vskVslSkdVOList = vskVslSkdVOList;
	}

	/**
	 * @return the vskVslPortSkdVOList
	 */
	public List<VskVslPortSkdVO> getVskVslPortSkdVOList() {
		return vskVslPortSkdVOList;
	}

	/**
	 * @param vskVslPortSkdVOList the vskVslPortSkdVOList to set
	 */
	public void setVskVslPortSkdVOList(List<VskVslPortSkdVO> vskVslPortSkdVOList) {
		this.vskVslPortSkdVOList = vskVslPortSkdVOList;
	}

	
}
