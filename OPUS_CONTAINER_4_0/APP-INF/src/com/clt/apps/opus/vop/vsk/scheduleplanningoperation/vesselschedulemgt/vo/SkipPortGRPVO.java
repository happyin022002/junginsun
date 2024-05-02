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

package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

import java.util.List;

import com.clt.syscommon.common.table.VskVslPortSkdVO;


/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 정진우
 * @since J2EE 1.5
 */

public class SkipPortGRPVO {

	private static final long serialVersionUID = 1L;
	
	/* Column Info */
	private List<VskVslPortSkdVO> reasonPortList = null;
	/* Column Info */
	private List<VskVslPortSkdVO> tsPortList = null;
	
	public SkipPortGRPVO() {}

	/**
	 * @return the reasonPortList
	 */
	public List<VskVslPortSkdVO> getReasonPortList() {
		return reasonPortList;
	}

	/**
	 * @param reasonPortList the reasonPortList to set
	 */
	public void setReasonPortList(List<VskVslPortSkdVO> reasonPortList) {
		this.reasonPortList = reasonPortList;
	}

	/**
	 * @return the tsPortList
	 */
	public List<VskVslPortSkdVO> getTsPortList() {
		return tsPortList;
	}

	/**
	 * @param tsPortList the tsPortList to set
	 */
	public void setTsPortList(List<VskVslPortSkdVO> tsPortList) {
		this.tsPortList = tsPortList;
	}
}
