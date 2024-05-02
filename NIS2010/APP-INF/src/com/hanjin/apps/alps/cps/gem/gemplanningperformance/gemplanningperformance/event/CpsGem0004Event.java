/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem0004Event.java
 *@FileTitle : Actual Results for Subsidiaries
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.26
 *@LastModifier : 박창준
 *@LastVersion : 1.0
 * 2009.05.26 박창준
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.event;


import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.ActRsltSubsPerfVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.SubsPerfVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 *[CPS_GEM-0004] Actual Results for Subsidiaries
 * CPS_GEM_0004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CPS_GEM_0004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Park Changjune
 * @see CPS_GEM_0004HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String rsltYrmon = "";
	/**
	 * @return the rsltYrmon
	 */
	public String getRsltYrmon() {
		return rsltYrmon;
	}
	/**
	 * @param rsltYrmon the rsltYrmon to set
	 */
	public void setRsltYrmon(String rsltYrmon) { 
		this.rsltYrmon = rsltYrmon;
	}
	private  String ofcCd = "";
	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}
	/**
	 * @param ofcCd the ofcCd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	private  String langDiv = "";
	/**
	 * @return the langDiv
	 */
	public String getLangDiv() {
		return langDiv;
	}
	/**
	 * @param langDiv the langDiv to set
	 */
	public void setLangDiv(String langDiv) {
		this.langDiv = langDiv;
	}
	
	private ActRsltSubsPerfVO actRsltSubsPerfVO = null;
	/**
	 * @return the actRsltSubsPerfVO
	 */
	public ActRsltSubsPerfVO getActRsltSubsPerfVO() {
		return actRsltSubsPerfVO;
	}
	/**
	 * @param actRsltSubsPerfVO the actRsltSubsPerfVO to set
	 */
	public void setActRsltSubsPerfVO(ActRsltSubsPerfVO actRsltSubsPerfVO) {
		this.actRsltSubsPerfVO = actRsltSubsPerfVO;
	}
	
	private ActRsltSubsPerfVO[] actRsltSubsPerfVOs = null;
	/**
	 * @return the actRsltSubsPerfVOs
	 */
	public ActRsltSubsPerfVO[] getActRsltSubsPerfVOs() {
		return actRsltSubsPerfVOs;
	}
	/**
	 * @param actRsltSubsPerfVOs the actRsltSubsPerfVOs to set
	 */
	public void setActRsltSubsPerfVOs(ActRsltSubsPerfVO[] actRsltSubsPerfVOs) {
		this.actRsltSubsPerfVOs = actRsltSubsPerfVOs;
	}
	
	private SubsPerfVO subsPerfVO = null;
	/**
	 * @return the subsPerfVO
	 */
	public SubsPerfVO getSubsPerfVO() {
		return subsPerfVO;
	}
	/**
	 * @param subsPerfVO the subsPerfVO to set
	 */
	public void setSubsPerfVO(SubsPerfVO subsPerfVO) {
		this.subsPerfVO = subsPerfVO;
	}
	
	private SubsPerfVO[] subsPerfVOs = null;
	/**
	 * @return the subsPerfVOs
	 */
	public SubsPerfVO[] getSubsPerfVOs() {
		return subsPerfVOs;
	}
	/**
	 * @param subsPerfVOs the subsPerfVOs to set
	 */
	public void setSubsPerfVOs(SubsPerfVO[] subsPerfVOs) {
		this.subsPerfVOs = subsPerfVOs;
	}

}