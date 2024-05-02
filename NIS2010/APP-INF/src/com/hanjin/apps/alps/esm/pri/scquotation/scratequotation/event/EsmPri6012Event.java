/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6012Event.java
*@FileTitle : S/C Quotation - Rate Adjust
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.19 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event;

import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.InPriCommodityRouteVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.InPriQuotationRateAdjustSetVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriCommodityRouteAreaVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriCommodityRouteVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_6012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6012HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InPriQuotationRateAdjustSetVO inPriQuotationRateAdjustSetVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InPriQuotationRateAdjustSetVO[] inPriQuotationRateAdjustSetVOs = null;
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InPriCommodityRouteVO inPriCommodityRouteVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InPriCommodityRouteVO[] inPriCommodityRouteVOs = null;
	
	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriCommodityRouteVO rsltPriCommodityRouteVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriCommodityRouteVO[] rsltPriCommodityRouteVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriCommodityRouteAreaVO rsltPriCommodityRouteAreaVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriCommodityRouteAreaVO[] rsltPriCommodityRouteAreaVOs = null;

	public EsmPri6012Event(){}
	
	public void setInPriQuotationRateAdjustSetVO(InPriQuotationRateAdjustSetVO inPriQuotationRateAdjustSetVO){
		this. inPriQuotationRateAdjustSetVO = inPriQuotationRateAdjustSetVO;
	}

	public void setInPriQuotationRateAdjustSetVOS(InPriQuotationRateAdjustSetVO[] inPriQuotationRateAdjustSetVOs){
		this. inPriQuotationRateAdjustSetVOs = inPriQuotationRateAdjustSetVOs;
	}
	
	public void setInPriCommodityRouteVO(InPriCommodityRouteVO inPriCommodityRouteVO){
		this. inPriCommodityRouteVO = inPriCommodityRouteVO;
	}

	public void setInPriCommodityRouteVOS(InPriCommodityRouteVO[] inPriCommodityRouteVOs){
		this. inPriCommodityRouteVOs = inPriCommodityRouteVOs;
	}
	
	public void setRsltPriCommodityRouteVO(RsltPriCommodityRouteVO rsltPriCommodityRouteVO){
		this. rsltPriCommodityRouteVO = rsltPriCommodityRouteVO;
	}

	public void setRsltPriCommodityRouteVOS(RsltPriCommodityRouteVO[] rsltPriCommodityRouteVOs){
		this. rsltPriCommodityRouteVOs = rsltPriCommodityRouteVOs;
	}

	public void setRsltPriCommodityRouteAreaVO(RsltPriCommodityRouteAreaVO rsltPriCommodityRouteAreaVO){
		this. rsltPriCommodityRouteAreaVO = rsltPriCommodityRouteAreaVO;
	}

	public void setRsltPriCommodityRouteAreaVOS(RsltPriCommodityRouteAreaVO[] rsltPriCommodityRouteAreaVOs){
		this. rsltPriCommodityRouteAreaVOs = rsltPriCommodityRouteAreaVOs;
	}
	public InPriQuotationRateAdjustSetVO getInPriQuotationRateAdjustSetVO(){
		return inPriQuotationRateAdjustSetVO;
	}

	public InPriQuotationRateAdjustSetVO[] getInPriQuotationRateAdjustSetVOS(){
		return inPriQuotationRateAdjustSetVOs;
	}
	
	public InPriCommodityRouteVO getInPriCommodityRouteVO(){
		return inPriCommodityRouteVO;
	}

	public InPriCommodityRouteVO[] getInPriCommodityRouteVOS(){
		return inPriCommodityRouteVOs;
	}

	public RsltPriCommodityRouteVO getRsltPriCommodityRouteVO(){
		return rsltPriCommodityRouteVO;
	}

	public RsltPriCommodityRouteVO[] getRsltPriCommodityRouteVOS(){
		return rsltPriCommodityRouteVOs;
	}

	public RsltPriCommodityRouteAreaVO getRsltPriCommodityRouteAreaVO(){
		return rsltPriCommodityRouteAreaVO;
	}

	public RsltPriCommodityRouteAreaVO[] getRsltPriCommodityRouteAreaVOS(){
		return rsltPriCommodityRouteAreaVOs;
	}

}