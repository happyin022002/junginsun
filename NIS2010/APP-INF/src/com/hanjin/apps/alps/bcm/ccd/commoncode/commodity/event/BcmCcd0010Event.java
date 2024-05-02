/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0010Event.java
*@FileTitle : Representative Commodity
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.03
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2011.03.03 조인영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.commodity.event;
 
import com.hanjin.apps.alps.bcm.ccd.commoncode.commodity.vo.RepCommodityVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 조인영
 * @see BCM_CCD_0010HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0010Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Rep Commodity Code */
	private String repCmdtCd = "";

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RepCommodityVO repCmdtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RepCommodityVO[] repCmdtVOs = null;

	public BcmCcd0010Event(){}

	public void setRepCommodityVO(RepCommodityVO repCmdtVO){
		this. repCmdtVO = repCmdtVO;
	}
	
	public void setRepCommodityVOS(RepCommodityVO[] repCmdtVOs){
		if(repCmdtVOs != null){
			RepCommodityVO[] tmpVOs = java.util.Arrays.copyOf(repCmdtVOs, repCmdtVOs.length);
			this.repCmdtVOs = tmpVOs;
		}
	}

	public RepCommodityVO getRepCommodityVO(){
		return repCmdtVO;
	}

	public RepCommodityVO[] getRepCommodityVOS(){
		RepCommodityVO[] rtnVOs = null;
		if (this.repCmdtVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(repCmdtVOs, repCmdtVOs.length);
		}
		return rtnVOs;
	}

	public void setRepCmdtCd(String repCmdtCd) {
		this.repCmdtCd = repCmdtCd;
	}
	
	public String getRepCmdtCd() {
		return repCmdtCd;
	}

}