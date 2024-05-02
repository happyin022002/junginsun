/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAExceptionGRPVO.java
*@FileTitle : RFAExceptionGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.06.19 이성훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이성훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class RFAExceptionGRPVO {

	private List<BeforeExceptionVO> beforeExceptionVOS = null;
	
	private List<RFAExceptionCoverageVO> rFAExceptionCoverageVOS = null;
	
	private List<RFAExceptionRateAdjustVO> rFAExceptionRateAdjustVOS = null;
	
	private RFAProgressVO rFAProgressVO = null;
	
	private BeforeExceptionDeleteVO beforeExceptionDeleteVO = null;
	
	private BeforeExceptionVersionVO beforeExceptionVersionVO = null;
	
	public void setBeforeExceptionVOS(List<BeforeExceptionVO> beforeExceptionVOS) {
		this.beforeExceptionVOS = beforeExceptionVOS;
	}
	
	public void setRFAProgressVO(RFAProgressVO rFAProgressVO) {
		this.rFAProgressVO = rFAProgressVO;
	}
	
	public void setBeforeExceptionDeleteVO(BeforeExceptionDeleteVO beforeExceptionDeleteVO) {
		this.beforeExceptionDeleteVO = beforeExceptionDeleteVO;
	}	
	
	public void setBeforeExceptionVersionVO(BeforeExceptionVersionVO beforeExceptionVersionVO) {
		this.beforeExceptionVersionVO = beforeExceptionVersionVO;
	}	
	
	public void setRFAExceptionCoverageVOS(List<RFAExceptionCoverageVO> rFAExceptionCoverageVOS) {
		this.rFAExceptionCoverageVOS = rFAExceptionCoverageVOS;
	}
	
	public void setRFAExceptionRateAdjustVOS(List<RFAExceptionRateAdjustVO> rFAExceptionRateAdjustVOS) {
		this.rFAExceptionRateAdjustVOS = rFAExceptionRateAdjustVOS;
	}
	
	public void setBeforeExceptionVOS(BeforeExceptionVO[] beforeExceptionVOList) {
		if (beforeExceptionVOList != null && beforeExceptionVOList.length > 0) {
			beforeExceptionVOS = new ArrayList<BeforeExceptionVO>();
			for (int i = 0 ; i < beforeExceptionVOList.length ; i++) {
				beforeExceptionVOS.add(beforeExceptionVOList[i]);
			}
		}
	}
	
	public void setRFAExceptionCoverageVOS(RFAExceptionCoverageVO[] rFAExceptionCoverageVOList) {
		if (rFAExceptionCoverageVOList != null && rFAExceptionCoverageVOList.length > 0) {
			rFAExceptionCoverageVOS = new ArrayList<RFAExceptionCoverageVO>();
			for (int i = 0 ; i < rFAExceptionCoverageVOList.length ; i++) {
				rFAExceptionCoverageVOS.add(rFAExceptionCoverageVOList[i]);
			}
		}
	}
	
	public void setRFAExceptionRateAdjustVOS(RFAExceptionRateAdjustVO[] rFAExceptionRateAdjustVOList) {
		if (rFAExceptionRateAdjustVOList != null && rFAExceptionRateAdjustVOList.length > 0) {
			rFAExceptionRateAdjustVOS = new ArrayList<RFAExceptionRateAdjustVO>();
			for (int i = 0 ; i < rFAExceptionRateAdjustVOList.length ; i++) {
				rFAExceptionRateAdjustVOS.add(rFAExceptionRateAdjustVOList[i]);
			}
		}		
	}	
	
	public List<BeforeExceptionVO> getBeforeExceptionVOS() {
		return beforeExceptionVOS;
	}
	
	public List<RFAExceptionCoverageVO> getRFAExceptionCoverageVOS() {
		return rFAExceptionCoverageVOS;
	}	
	
	public List<RFAExceptionRateAdjustVO> getRFAExceptionRateAdjustVOS() {
		return rFAExceptionRateAdjustVOS;
	}	

	public RFAProgressVO getRFAProgressVO() {
		return rFAProgressVO;
	}
	
	public BeforeExceptionDeleteVO getBeforeExceptionDeleteVO() {
		return beforeExceptionDeleteVO;
	}
	
	public BeforeExceptionVersionVO getBeforeExceptionVersionVO() {
		return beforeExceptionVersionVO;
	}
}
