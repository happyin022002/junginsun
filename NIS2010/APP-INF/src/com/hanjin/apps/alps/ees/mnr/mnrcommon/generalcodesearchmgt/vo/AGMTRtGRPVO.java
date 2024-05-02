/**
 * 
 */
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo;

import java.util.List;


/**
 * @author zero
 *
 */
public class AGMTRtGRPVO {

	private AGMTRtINVO agmtRtINVO;
	private AGMTRtListVO agmtRtListVO ;
	private List<AGMTRtListVO>  agmtRtListVOS;
	
	
	
	public AGMTRtINVO getAGMTRtINVO() {
		return agmtRtINVO;
	}
	public void setAGMTRtINVO(
			AGMTRtINVO agmtRtINVO) {
		this.agmtRtINVO = agmtRtINVO;
	}
	public AGMTRtListVO getAGMTRtListVO() {
		return agmtRtListVO;
	}
	public void setCustomMdmVendorVO(AGMTRtListVO agmtRtListVO) {
		this.agmtRtListVO = agmtRtListVO;
	}
	public List<AGMTRtListVO> getAGMTRtListVOS() {
		return agmtRtListVOS;
	}
	public void setAGMTRtListVOS(List<AGMTRtListVO> agmtRtListVOS) {
		this.agmtRtListVOS = agmtRtListVOS;
	}
	
	
	
}
