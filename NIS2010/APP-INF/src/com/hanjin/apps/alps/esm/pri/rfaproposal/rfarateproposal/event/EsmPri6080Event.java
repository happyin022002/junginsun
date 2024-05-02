/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6050Event.java
*@FileTitle : Surcharge Adjust-Commodity
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.08 송민석
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeAdjustCommodityDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeAdjustCommodityVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_6050 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6050HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6050HTMLAction 참조
 * @since J2EE 1.6
 */
 
public class EsmPri6080Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	 
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriSurchargeAdjustCommodityVO rsltPriSurchargeAdjustCommodityVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriSurchargeAdjustCommodityVO[] rsltPriSurchargeAdjustCommodityVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriSurchargeAdjustCommodityDetailVO rsltPriSurchargeAdjustCommodityDetailVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriSurchargeAdjustCommodityDetailVO[] rsltPriSurchargeAdjustCommodityDetailVOs = null;

	
	public EsmPri6080Event(){}
	
	public void setRsltPriSurchargeAdjustCommodityVO(RsltPriSurchargeAdjustCommodityVO rsltPriSurchargeAdjustCommodityVO){
		this. rsltPriSurchargeAdjustCommodityVO = rsltPriSurchargeAdjustCommodityVO;
	}

	public void setRsltPriSurchargeAdjustCommodityVOS(RsltPriSurchargeAdjustCommodityVO[] rsltPriSurchargeAdjustCommodityVOs){
		if(rsltPriSurchargeAdjustCommodityVOs != null){
			RsltPriSurchargeAdjustCommodityVO[] tmpVOs = new RsltPriSurchargeAdjustCommodityVO[rsltPriSurchargeAdjustCommodityVOs.length];
			System.arraycopy(rsltPriSurchargeAdjustCommodityVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltPriSurchargeAdjustCommodityVOs = tmpVOs;
		}
	}

	public RsltPriSurchargeAdjustCommodityVO getRsltPriSurchargeAdjustCommodityVO(){
		return rsltPriSurchargeAdjustCommodityVO;
	}

	public RsltPriSurchargeAdjustCommodityVO[] getRsltPriSurchargeAdjustCommodityVOS(){
		RsltPriSurchargeAdjustCommodityVO[] rtnVOs = null;
		if (this.rsltPriSurchargeAdjustCommodityVOs != null) {
			rtnVOs = new RsltPriSurchargeAdjustCommodityVO[rsltPriSurchargeAdjustCommodityVOs.length];
			System.arraycopy(rsltPriSurchargeAdjustCommodityVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setRsltPriSurchargeAdjustCommodityDetailVO(RsltPriSurchargeAdjustCommodityDetailVO rsltPriSurchargeAdjustCommodityDetailVO){
		this. rsltPriSurchargeAdjustCommodityDetailVO = rsltPriSurchargeAdjustCommodityDetailVO;
	}

	public void setRsltPriSurchargeAdjustCommodityDetailVOS(RsltPriSurchargeAdjustCommodityDetailVO[] rsltPriSurchargeAdjustCommodityDetailVOs){
		if(rsltPriSurchargeAdjustCommodityDetailVOs != null){
			RsltPriSurchargeAdjustCommodityDetailVO[] tmpVOs = new RsltPriSurchargeAdjustCommodityDetailVO[rsltPriSurchargeAdjustCommodityDetailVOs.length];
			System.arraycopy(rsltPriSurchargeAdjustCommodityDetailVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltPriSurchargeAdjustCommodityDetailVOs = tmpVOs;
		}
	}

	public RsltPriSurchargeAdjustCommodityDetailVO getRsltPriSurchargeAdjustCommodityDetailVO(){
		return rsltPriSurchargeAdjustCommodityDetailVO;
	}

	public RsltPriSurchargeAdjustCommodityDetailVO[] getRsltPriSurchargeAdjustCommodityDetailVOS(){
		RsltPriSurchargeAdjustCommodityDetailVO[] rtnVOs = null;
		if (this.rsltPriSurchargeAdjustCommodityDetailVOs != null) {
			rtnVOs = new RsltPriSurchargeAdjustCommodityDetailVO[rsltPriSurchargeAdjustCommodityDetailVOs.length];
			System.arraycopy(rsltPriSurchargeAdjustCommodityDetailVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}	
 
}