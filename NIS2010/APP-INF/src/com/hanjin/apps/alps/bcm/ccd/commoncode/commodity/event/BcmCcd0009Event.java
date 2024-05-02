/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0009Event.java
*@FileTitle : Group Commodity
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.25
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2011.02.25 조인영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.commodity.event;
 
import com.hanjin.apps.alps.bcm.ccd.commoncode.commodity.vo.GrpCommodityVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 조인영
 * @see BCM_CCD_0009HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0009Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Grp Commodity Code */
	private String grpCmdtCd = "";

	/** Table Value Object 조회 조건 및 단건 처리  */
	private GrpCommodityVO grpCmdtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private GrpCommodityVO[] grpCmdtVOs = null;

	public BcmCcd0009Event(){}

	public void setGrpCommodityVO(GrpCommodityVO grpCmdtVO){
		this. grpCmdtVO = grpCmdtVO;
	}
	
	public void setGrpCommodityVOS(GrpCommodityVO[] grpCmdtVOs){
		if(grpCmdtVOs != null){
			GrpCommodityVO[] tmpVOs = java.util.Arrays.copyOf(grpCmdtVOs, grpCmdtVOs.length);
			this.grpCmdtVOs = tmpVOs;
		}
	}

	public GrpCommodityVO getGrpCommodityVO(){
		return grpCmdtVO;
	}

	public GrpCommodityVO[] getGrpCommodityVOS(){
		GrpCommodityVO[] rtnVOs = null;
		if (this.grpCmdtVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(grpCmdtVOs, grpCmdtVOs.length);
		}
		return rtnVOs;
	}

	public void setGrpCmdtCd(String grpCmdtCd) {
		this.grpCmdtCd = grpCmdtCd;
	}
	
	public String getGrpCmdtCd() {
		return grpCmdtCd;
	}

}