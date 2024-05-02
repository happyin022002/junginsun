/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0031Event.java
*@FileTitle : sub SubTrade
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.service.event;
 
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.SubTradeVO;


/**
 * BCM_CCD_0031 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0031HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0031HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0031Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
private String subTrdCd = null;
	
	private String trdCd = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SubTradeVO subTrdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SubTradeVO[] subTrdVOs = null;

	public BcmCcd0031Event(){}
	
	public void setSubTradeCd(String subTrdCd){
		this. subTrdCd = subTrdCd;
	}
	
	public void settrdCd(String trdCd){
		this. trdCd = trdCd;
	}
	
	public void setSubTradeVO(SubTradeVO subTrdVO){
		this. subTrdVO = subTrdVO;
	}

	public void setSubTradeVOS(SubTradeVO[] subTrdVOs){
		if(subTrdVOs != null){
			SubTradeVO[] tmpVOs = java.util.Arrays.copyOf(subTrdVOs, subTrdVOs.length);
			this.subTrdVOs = tmpVOs;
		}
	}

	public SubTradeVO getSubTradeVO(){
		return subTrdVO;
	}

	public SubTradeVO[] getSubTradeVOS(){
		SubTradeVO[] rtnVOs = null;
		if (this.subTrdVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(subTrdVOs, subTrdVOs.length);
		}
		return rtnVOs;
	}
	
	public String getSubTradeCd(){
		return subTrdCd;
	}
	
	public String gettrdCd(){
		return trdCd;
	}

}