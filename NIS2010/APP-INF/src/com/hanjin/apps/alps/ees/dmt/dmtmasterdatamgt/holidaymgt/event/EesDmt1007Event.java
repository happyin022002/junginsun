/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiDmt1007Event.java
*@FileTitle : Holiday by Country Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.04.27 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.holidaymgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.holidaymgt.vo.HolidayMgtVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * UI_DMT_1007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_DMT_1007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SungHoon, Lee
 * @see EES_DMT_1007HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesDmt1007Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private HolidayMgtVO holidayMgtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private HolidayMgtVO[] holidayMgtVOS = null;

	public EesDmt1007Event(){}
	
	public void setHolidayMgtVO(HolidayMgtVO holidayMgtVO){
		this. holidayMgtVO = holidayMgtVO;
	}

	public void setHolidayMgtVOS(HolidayMgtVO[] holidayMgtVOS){
		this. holidayMgtVOS = holidayMgtVOS;
	}

	public HolidayMgtVO getHolidayMgtVO(){
		return holidayMgtVO;
	}

	public HolidayMgtVO[] getHolidayMgtVOS(){
		return holidayMgtVOS;
	}

}