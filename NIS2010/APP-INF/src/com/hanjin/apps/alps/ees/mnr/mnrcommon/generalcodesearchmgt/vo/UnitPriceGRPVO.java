/*=========================================================
 *Copyright(c) 2009 CyberLogitec
*@FileName : UnitPriceGRPVO
*@FileTitle : 
*Open Issues :	
*Change history :
*@LastModifyDate : 2009. 10. 12
*@LastModifier : 
*@LastVersion : 1.0
*2009. 10. 12. 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo;
 
/** 
 * UnitPriceGRPVO <br> 
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 * 
 * @author 박명신   
 * @since J2EE 1.5 
 * @see	  ..   
 */
 
public class UnitPriceGRPVO {  
	private CustomUnitPriceVO inCustomUnitPriceVO = null; 
	private CustomUnitPriceVO outCustomUnitPriceVO = null;
	private CustomCurrXchRtVO customCurrXchRtVO = null;	
	
	
	
	public CustomUnitPriceVO getInCustomUnitPriceVO() {
		return inCustomUnitPriceVO;
	}
	public void setInCustomUnitPriceVO(CustomUnitPriceVO inCustomUnitPriceVO) {
		this.inCustomUnitPriceVO = inCustomUnitPriceVO;
	}
	public CustomUnitPriceVO getOutCustomUnitPriceVO() {
		return outCustomUnitPriceVO;
	}
	public void setOutCustomUnitPriceVO(CustomUnitPriceVO outCustomUnitPriceVO) {
		this.outCustomUnitPriceVO = outCustomUnitPriceVO;
	} 
	public CustomCurrXchRtVO getCustomCurrXchRtVO() {
		return customCurrXchRtVO;
	}
	public void setCustomCurrXchRtVO(CustomCurrXchRtVO customCurrXchRtVO) {
		this.customCurrXchRtVO = customCurrXchRtVO;
	} 
}
