/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StmSap0023Event.java
*@FileTitle : LocationList
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event;

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.LocationListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountPayableCommonSC 실행요청<br>
 * - AccountPayableCommonSC View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author ORKIM
 * @see AccountPayableCommonSC 참조
 * @since J2EE 1.4
 */

public class StmSap0023Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LocationListVO locationListVO = null;

	/** Table Value Object Multi Data 처리 */
	private LocationListVO[] locationListVOs = null;

	public StmSap0023Event() {}

	public LocationListVO getLocationListVO() {
		return locationListVO;
	}

	public void setLocationListVO(LocationListVO locationListVO) {
		this.locationListVO = locationListVO;
	}

	public LocationListVO[] getLocationListVOs() {
		LocationListVO[] rtnVOs = null;
		if(this.locationListVOs != null) {
			rtnVOs = new LocationListVO[locationListVOs.length];
			System.arraycopy(locationListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setLocationListVOs(LocationListVO[] locationListVOs) {
		if(locationListVOs != null) {
			LocationListVO[] tmpVOs = new LocationListVO[locationListVOs.length];
			System.arraycopy(locationListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.locationListVOs = tmpVOs;
		}
	}
}