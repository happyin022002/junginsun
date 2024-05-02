/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchScpLimitCodeVO.java
*@FileTitle : SearchScpLimitCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.02  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.bcm.ccd.commoncode.location.vo;

import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ZoneGroupVO {

	//private static final long serialVersionUID = 1L;
	
	//private Collection<ZoneGroupVO> models = new ArrayList<ZoneGroupVO>();
	
	/* Column Info */
//	private String rgnCd = null;
//	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
//	private String ibflag = null;
//	/* Page Number */
//	private String pagerows = null;
	
	private String usrId = null;
	
	private ZoneVO zoneVO = null;
	
	private List<ZoneDtlVO> zoneDtlVOS = null;

	private ZoneDtlVO[] zoneDtlVOs = null;
	
	public ZoneVO getZoneVO() {
		return zoneVO;
	}

	public void setZoneVO(ZoneVO zoneVO) {
		this.zoneVO = zoneVO;
	}

	public List<ZoneDtlVO> getZoneDtlVOS() {
		return zoneDtlVOS;
	}

	public void setZoneDtlVOS(List<ZoneDtlVO> zoneDtlVOS) {
		this.zoneDtlVOS = zoneDtlVOS;
	}

	public ZoneDtlVO[] getZoneDtlVOs() {
		return zoneDtlVOs;
	}

	public void setZoneDtlVOs(ZoneDtlVO[] zoneDtlVOs) {
		this.zoneDtlVOs = zoneDtlVOs;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

}
