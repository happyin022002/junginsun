/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem001402Event.java
 *@FileTitle : Request Information
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.23
 *@LastModifier : 박창준
 *@LastVersion : 1.0
 * 2009.06.23 박창준
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.event;


import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.RqstInfoVO;

/**
 *[CPS_GEM-0014_02] Request Information
 * CPS_GEM_0014_02 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CPS_GEM_0014_02HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Park Changjune
 * @see CPS_GEM_0014_02HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem001402Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private  String genExpnCd = "";

	/**
	 * @return the genExpnCd
	 */
	public String getGenExpnCd() {
		return genExpnCd;
	}

	/**
	 * @param genExpnCd the genExpnCd to set
	 */
	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
	}
	
	private  String plnYrmon = "";

	/**
	 * @return the plnYrmon
	 */
	public String getPlnYrmon() {
		return plnYrmon;
	}

	/**
	 * @param plnYrmon the plnYrmon to set
	 */
	public void setPlnYrmon(String plnYrmon) {
		this.plnYrmon = plnYrmon;
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
	
	private  String genExpnRqstTpCd = "";

	/**
	 * @return the genExpnRqstTpCd
	 */
	public String getGenExpnRqstTpCd() {
		return genExpnRqstTpCd;
	}

	/**
	 * @param genExpnRqstTpCd the genExpnRqstTpCd to set
	 */
	public void setGenExpnRqstTpCd(String genExpnRqstTpCd) {
		this.genExpnRqstTpCd = genExpnRqstTpCd;
	}
	
	private RqstInfoVO rqstInfoVO = null;
	/**
	 * @return the rqstInfoVO
	 */
	public RqstInfoVO getRqstInfoVO() {
		return rqstInfoVO;
	}
	/**
	 * @param rqstInfoVO the rqstInfoVO to set
	 */
	public void setRqstInfoVO(RqstInfoVO rqstInfoVO) {
		this.rqstInfoVO = rqstInfoVO;
	}

	/**
	 * @return the rqstInfoVO
	 */
	
	
	private RqstInfoVO[] rqstInfoVOs = null;
	/**
	 * @return the rqstInfoVOs
	 */
	public RqstInfoVO[] getRqstInfoVOs() {
		return rqstInfoVOs;
	}
	/**
	 * @param rqstInfoVOs the rqstInfoVOs to set
	 */
	public void setRqstInfoVOs(RqstInfoVO[] rqstInfoVOs) {
		this.rqstInfoVOs = rqstInfoVOs;
	}


}