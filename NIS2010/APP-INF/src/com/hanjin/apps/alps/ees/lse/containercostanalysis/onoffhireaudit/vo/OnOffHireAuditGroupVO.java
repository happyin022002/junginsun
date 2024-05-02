/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnOffHireAuditGroupVO.java
*@FileTitle : OnOffHireAuditGroupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.20
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.07.20 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.vo;

import java.util.List;

import org.apache.log4j.Logger;


/**
 * Search Param VO Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 장준우
 * @since J2EE 1.6
 * @see OnOffHireAuditDetailVO, OnOffHireAuditSearchVO
 */
public class OnOffHireAuditGroupVO {

	private static final long serialVersionUID = 1L;

	private Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.vo");


	/** Table Value Object Multi Data 처리 */
	private List<List<OnOffHireAuditSearchVO>> onOffHireAuditSearchVOs = null;

	private List<List<OnOffHireAuditDetailVO>> onOffHireAuditDetailVOs = null;

	/**
	 * @return the onOffHireAuditSearchVOs
	 */
	public List<List<OnOffHireAuditSearchVO>> getOnOffHireAuditSearchVOs() {
		return onOffHireAuditSearchVOs;
	}

	/**
	 * @param onOffHireAuditSearchVOs the onOffHireAuditSearchVOs to set
	 */
	public void setOnOffHireAuditSearchVOs(
			List<List<OnOffHireAuditSearchVO>> onOffHireAuditSearchVOs) {
		this.onOffHireAuditSearchVOs = onOffHireAuditSearchVOs;
	}

	/**
	 * @return the onOffHireAuditDetailVOs
	 */
	public List<List<OnOffHireAuditDetailVO>> getOnOffHireAuditDetailVOs() {
		return onOffHireAuditDetailVOs;
	}

	/**
	 * @param onOffHireAuditDetailVOs the onOffHireAuditDetailVOs to set
	 */
	public void setOnOffHireAuditDetailVOs(
			List<List<OnOffHireAuditDetailVO>> onOffHireAuditDetailVOs) {
		this.onOffHireAuditDetailVOs = onOffHireAuditDetailVOs;
	}
}
