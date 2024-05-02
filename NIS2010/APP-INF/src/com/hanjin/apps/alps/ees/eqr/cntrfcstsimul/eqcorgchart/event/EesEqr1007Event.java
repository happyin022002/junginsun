/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EES_EQR_1007Event.java
*@FileTitle : EQC Organization Chart
*Open Issues :
*Change history :
*@LastModifyDate : 2013-06-03
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.eqcorgchart.event;

import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.eqcorgchart.vo.EQCOrgChartListVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_1007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_EQR_1007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class EesEqr1007Event extends EventSupport {
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EQCOrgChartListVO	eQCOrgChartListVO = null;
	 
	/** Table Value Object Multi Data 처리 */
	public EQCOrgChartListVO[] eQCOrgChartListVOs = null;
	
	private String depth = "";
	private String chkDepth = "";
	
	/**
	 * Constructor<br>
	 */
	public EesEqr1007Event() {}
	
	/**
	 * Constructor<br>
	 * @param depth
	 * @param chkDepth
	 */
	public EesEqr1007Event(String depth, String chkDepth) {
		this.depth = depth;
		this.chkDepth = chkDepth;
	}

	/**
     * Event 명을 반환<br>
     * @return String
     */
	public String getEventName() {
		return "EesEqr1007Event";
	}

	/**
     * Class 명을 반환<br>
     * @return String
     */
	public String toString() {
		return "EesEqr1007Event";
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
	 * @return the eQCOrgChartListVO
	 */
	public EQCOrgChartListVO getEQCOrgChartListVO() {
		return eQCOrgChartListVO;
	}

	/**
	 * @param EQCOrgChartListVO eQCOrgChartListVO
	 */
	public void setEQCOrgChartListVO(EQCOrgChartListVO eQCOrgChartListVO) {
		this.eQCOrgChartListVO = eQCOrgChartListVO;
	}

	/**
	 * @return the eQCOrgChartListVOs
	 */
	public EQCOrgChartListVO[] getEQCOrgChartListVOs() {
		return eQCOrgChartListVOs;
	}

	/**
	 * @param EQCOrgChartListVO[] eQCOrgChartListVOs
	 */
	public void setEQCOrgChartListVOs(EQCOrgChartListVO[] eQCOrgChartListVOs) {
		this.eQCOrgChartListVOs = eQCOrgChartListVOs;
	}
	
}
