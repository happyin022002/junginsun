/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_0O1Event.java
*@FileTitle : EQ Organization Chart
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-11
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-10-11 Hyung Choon_Roh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.eqorgchart.event;

import com.hanjin.bizcommon.eqorgchart.vo.EQQrgChartListVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * COM_ENS_0O1 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - COM_ENS_0O1HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hyung Choon_Roh
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class ComEns0O1Event extends EventSupport {
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EQQrgChartListVO	eQQrgChartListVO = null;
	 
	/** Table Value Object Multi Data 처리 */
	private EQQrgChartListVO[] eQQrgChartListVOs = null;
	
	private String depth = "";
	private String chkDepth = "";
	
	/**
	 * Constructor<br>
	 */
	public ComEns0O1Event() {}
	
	/**
	 * Constructor<br>
	 * @param depth
	 * @param chkDepth
	 */
	public ComEns0O1Event(String depth, String chkDepth) {
		this.depth = depth;
		this.chkDepth = chkDepth;
	}

	/**
     * Event 명을 반환<br>
     * @return String
     */
	public String getEventName() {
		return "ComEns0O1Event";
	}

	/**
     * Class 명을 반환<br>
     * @return String
     */
	public String toString() {
		return "ComEns0O1Event";
	}

	/**
	 * Depth 반환<br>
	 * @return
	 */
	public String getDepth() {
		return depth;
	}

	/**
	 * Depth 세팅<br>
	 * @param depth
	 */
	public void setDepth(String depth) {
		this.depth = depth;
	}

	/**
	 * Check Depth 반환<br>
	 * @return
	 */
	public String getChkDepth() {
		return chkDepth;
	}

	/**
	 * Check Depth 세팅<br>
	 * @param chkDepth
	 */
	public void setChkDepth(String chkDepth) {
		this.chkDepth = chkDepth;
	}

	/**
	 * @return the eQQrgChartListVO
	 */
	public EQQrgChartListVO getEQQrgChartListVO() {
		return eQQrgChartListVO;
	}

	/**
	 * @param qrgChartListVO the eQQrgChartListVO to set
	 */
	public void setEQQrgChartListVO(EQQrgChartListVO qrgChartListVO) {
		eQQrgChartListVO = qrgChartListVO;
	}

	/**
	 * @return the eQQrgChartListVOs
	 */
	public EQQrgChartListVO[] getEQQrgChartListVOs() {
		return eQQrgChartListVOs;
	}

	/**
	 * @param qrgChartListVOs the eQQrgChartListVOs to set
	 */
	public void setEQQrgChartListVOs(EQQrgChartListVO[] qrgChartListVOs) {
		eQQrgChartListVOs = qrgChartListVOs;
	}
	
}
