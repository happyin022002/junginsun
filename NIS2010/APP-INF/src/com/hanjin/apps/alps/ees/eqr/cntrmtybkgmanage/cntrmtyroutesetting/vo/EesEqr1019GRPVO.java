/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TContainerStatusCodeVO.java
*@FileTitle : Equipment Status Code Creation, Update & Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 김석준
*@LastVersion : 1.0
* 2009.05.06 김석준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.vo;

import java.util.List;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 두기민
 * @since J2EE 1.5
 * @see
 */
public class EesEqr1019GRPVO 
{
	// 조회 결과값을 받기위한 테이블 VO리스트
	private List<EesEqr1019RouteSettingVO> eesEqr1019RouteSettingVO = null;
	// CRUD 변경값을 입력 받기위한 array
	private EesEqr1019RouteSettingVO[] eesEqr1019RouteSettingVOS = null;

	public EesEqr1019GRPVO() 
	{
	}

	public List<EesEqr1019RouteSettingVO> getEesEqr1019RouteSettingVO() {
		return eesEqr1019RouteSettingVO;
	}

	public void setEesEqr1019RouteSettingVO(List<EesEqr1019RouteSettingVO> eesEqr1019RouteSettingVO) {
		this.eesEqr1019RouteSettingVO = eesEqr1019RouteSettingVO;
	}

	public EesEqr1019RouteSettingVO[] getEesEqr1019RouteSettingVOS() {
		return eesEqr1019RouteSettingVOS;
	}

	public void setEesEqr1019RouteSettingVOS(EesEqr1019RouteSettingVO[] eesEqr1019RouteSettingVOS) {
		this.eesEqr1019RouteSettingVOS = eesEqr1019RouteSettingVOS;
	}
	
}
