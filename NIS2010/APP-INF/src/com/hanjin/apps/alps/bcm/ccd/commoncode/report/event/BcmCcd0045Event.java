/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0045Event.java
*@FileTitle : activity
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.report.event;
 
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo.LocationReportConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0045 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0045HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0045HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0045Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LocationReportConditionVO locationReportConditionvo = null;
	
	/** Table Value Object Multi Data 처리 */
	private LocationReportConditionVO[] locationReportConditionvos = null;

	public BcmCcd0045Event(){}
	
	public void setLocationReportConditionVO(LocationReportConditionVO locationReportConditionvo){
		this. locationReportConditionvo = locationReportConditionvo;
	}

	public void setLocationReportConditionVOS(LocationReportConditionVO[] locationReportConditionvos){
		if(locationReportConditionvos != null){
			LocationReportConditionVO[] tmpVOs = java.util.Arrays.copyOf(locationReportConditionvos, locationReportConditionvos.length);
			this.locationReportConditionvos = tmpVOs;
		}
	}

	public LocationReportConditionVO getLocationReportConditionVO(){
		return locationReportConditionvo;
	}

	public LocationReportConditionVO[] getLocationReportConditionVOS(){
		LocationReportConditionVO[] rtnVOs = null;
		if (this.locationReportConditionvos != null) {
			rtnVOs = java.util.Arrays.copyOf(locationReportConditionvos, locationReportConditionvos.length);
		}
		return rtnVOs;
	}
	
}