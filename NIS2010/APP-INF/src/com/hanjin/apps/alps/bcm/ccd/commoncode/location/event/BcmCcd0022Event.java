/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0022Event.java
*@FileTitle : equipment ORG chart
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.location.event;

import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.EqOrgChartVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0022HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0022Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public BcmCcd0022Event(){}
	
	private String locType = null;
	
	private String location = null;
	
	private String deltFlg = null;
	
	private String locCd = null;
	
	private EqOrgChartVO eqOrgChartVO = null;
	
	private EqOrgChartVO[] eqOrgChartVOs = null;





	public String getLocType() {
		return locType;
	}

	public void setLocType(String locType) {
		this.locType = locType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDeltFlg() {
		return deltFlg;
	}

	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}

	public String getLocCd() {
		return locCd;
	}

	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	public EqOrgChartVO getEqOrgChartVO() {
		return eqOrgChartVO;
	}

	public void setEqOrgChartVO(EqOrgChartVO eqOrgChartVO) {
		this.eqOrgChartVO = eqOrgChartVO;
	}
	
	public EqOrgChartVO[] getEqOrgChartVOs() {
		return eqOrgChartVOs;
	}

	public void setEqOrgChartVOs(EqOrgChartVO[] eqOrgChartVOs) {
		this.eqOrgChartVOs = eqOrgChartVOs;
	}

/*	public EqOrgChartVO[] getEqOrgChartVOs() {
		EqOrgChartVO[] rtnVOs = null;
		if (this.eqOrgChartVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(eqOrgChartVOs, eqOrgChartVOs.length);
		}
		return rtnVOs;
	}

	public void setEqOrgChartVOs(EqOrgChartVO[] eqOrgChartVOs){
		if(eqOrgChartVOs != null){
			EqOrgChartVO[] tmpVOs = java.util.Arrays.copyOf(eqOrgChartVOs, eqOrgChartVOs.length);
			this.eqOrgChartVOs = tmpVOs;
		}
	}*/

}