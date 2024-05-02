/*=========================================================
 *Copyright(c) 2009 CyberLogitec
*@FileName : EtcInfoGRPVO
*@FileTitle : 
*Open Issues :	
*Change history :
*@LastModifyDate : 2011. 01. 19
*@LastModifier : 
*@LastVersion : 1.0
*2011. 01. 19. 박명신
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo;

/** 
 * EtcInfoGRPVO <br> 
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 * 
 * @author 박명신   
 * @since J2EE 1.5 
 * @see	  ..   
 */

public class EtcInfoGRPVO {
	//로칼 데이트 조회용			
	private CustomLocalDateVO inCustomLocalDateVO = null; 
	private CustomLocalDateVO outCustomLocalDateVO = null;
	
	public CustomLocalDateVO getInCustomLocalDateVO() {
		return inCustomLocalDateVO;
	}
	public void setInCustomLocalDateVO(CustomLocalDateVO inCustomLocalDateVO) {
		this.inCustomLocalDateVO = inCustomLocalDateVO;
	}
	public CustomLocalDateVO getOutCustomLocalDateVO() {
		return outCustomLocalDateVO;
	}
	public void setOutCustomLocalDateVO(CustomLocalDateVO outCustomLocalDateVO) {
		this.outCustomLocalDateVO = outCustomLocalDateVO;
	}
	
	//SPP OFC조회용			
	private CustomSPPOFCVO inCustomSPPOFCVO = null; 
	private CustomSPPOFCVO outCustomSPPOFCVO = null;
	
	public CustomSPPOFCVO getInCustomSPPOFCVO() {
		return inCustomSPPOFCVO;
	}
	public void setInCustomSPPOFCVO(CustomSPPOFCVO inCustomSPPOFCVO) {
		this.inCustomSPPOFCVO = inCustomSPPOFCVO;
	}
	public CustomSPPOFCVO getOutCustomSPPOFCVO() {
		return outCustomSPPOFCVO;
	}
	public void setOutCustomSPPOFCVO(CustomSPPOFCVO outCustomSPPOFCVO) {
		this.outCustomSPPOFCVO = outCustomSPPOFCVO;
	}
}
