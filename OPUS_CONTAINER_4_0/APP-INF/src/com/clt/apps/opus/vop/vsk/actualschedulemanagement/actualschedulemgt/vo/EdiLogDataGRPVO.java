/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SkipPortGRPVO.java
*@FileTitle : SkipPortGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : Jung Jinwoo
*@LastVersion : 1.0
* 2009.05.26 Jung Jinwoo
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo;

import java.util.List;

import com.clt.syscommon.common.table.VskActPortSkdEdiLogVO;
import com.clt.syscommon.common.table.VskActPortSkdVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 정진우
 * @since J2EE 1.5
 */

public class EdiLogDataGRPVO {

	private static final long serialVersionUID = 1L;
	
	/* Column Info */
	private List<VskActPortSkdEdiLogVO> vskActPortSkdEdiLogVOs = null;
	/* Column Info */
	private List<VskVslPortSkdVO> vskVslPortSkdVOs = null;
	/* Column Info */
	private List<VskActPortSkdVO> vskActPortSkdVOs = null;
	
	int value1 = 0;
	int value2 = 0;
	
	public EdiLogDataGRPVO() {}

	/**
	 * @return the vskActPortSkdEdiLogVOs
	 */
	public List<VskActPortSkdEdiLogVO> getVskActPortSkdEdiLogVOs() {
		return vskActPortSkdEdiLogVOs;
	}

	/**
	 * @param vskActPortSkdEdiLogVOs the vskActPortSkdEdiLogVOs to set
	 */
	public void setVskActPortSkdEdiLogVOs(
			List<VskActPortSkdEdiLogVO> vskActPortSkdEdiLogVOs) {
		this.vskActPortSkdEdiLogVOs = vskActPortSkdEdiLogVOs;
	}

	/**
	 * @return the vskVslPortSkdVOs
	 */
	public List<VskVslPortSkdVO> getVskVslPortSkdVOs() {
		return vskVslPortSkdVOs;
	}

	/**
	 * @param vskVslPortSkdVOs the vskVslPortSkdVOs to set
	 */
	public void setVskVslPortSkdVOs(List<VskVslPortSkdVO> vskVslPortSkdVOs) {
		this.vskVslPortSkdVOs = vskVslPortSkdVOs;
	}
	
	
	/**
	 * @return the vskActPortSkdVOs
	 */
	public List<VskActPortSkdVO> getVskActPortSkdVOs() {
		return vskActPortSkdVOs;
	}

	/**
	 * @param vskActPortSkdVOs the vskActPortSkdVOs to set
	 */
	public void setVskActPortSkdVOs(List<VskActPortSkdVO> vskActPortSkdVOs) {
		this.vskActPortSkdVOs = vskActPortSkdVOs;
	}
	

	/**
	 * @return the value1
	 */
	public int getValue1() {
		return value1;
	}

	/**
	 * @param value1 the value1 to set
	 */
	public void setValue1(int value1) {
		this.value1 = value1;
	}

	/**
	 * @return the value2
	 */
	public int getValue2() {
		return value2;
	}

	/**
	 * @param value2 the value2 to set
	 */
	public void setValue2(int value2) {
		this.value2 = value2;
	}


}
