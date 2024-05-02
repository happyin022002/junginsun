/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_918Event.java
*@FileTitle : Register Throughput Cost Code
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-19
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-09-19 jongbaemoon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event;

import com.hanjin.apps.alps.esd.tes.common.vo.TesCommonVO;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.vo.TesAgreementManageCommonVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesTmlAgmtHdrVO;
import com.hanjin.syscommon.common.table.TesTmlAgmtThrpCostVO;


/**
 * ESD_TES_9180 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_9180HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jongbaemoon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 * 
 * @ALPSModifyDate	: 2009-09-10
 * @author yOng hO lEE
 * @see ESD_TES_9180HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTes9180Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TesCommonVO 					tesCommonVO							= null;
	private TesAgreementManageCommonVO 		tesAgreementManageCommonVO			= null;
	private TesTmlAgmtThrpCostVO 			tesTmlAgmtThrpCostVO				= null;
	private TesTmlAgmtHdrVO 				tesTmlAgmtHdrVO						= null;
	
	/** Table Value Object Multi Data 처리 */
	private TesCommonVO[]					tesCommonVOs						= null;
	private TesAgreementManageCommonVO[]	tesAgreementManageCommonVOs			= null;
	private TesTmlAgmtThrpCostVO[] 			tesTmlAgmtThrpCostVOs				= null;
//	private TesTmlAgmtHdrVO[] 				tesTmlAgmtHdrVOs					= null;

	public EsdTes9180Event(){}

	public TesCommonVO getTesCommonVO() {
		return tesCommonVO;
	}

	public void setTesCommonVO(TesCommonVO tesCommonVO) {
		this.tesCommonVO = tesCommonVO;
	}

	public TesAgreementManageCommonVO getTesAgreementManageCommonVO() {
		return tesAgreementManageCommonVO;
	}

	public void setTesAgreementManageCommonVO(
			TesAgreementManageCommonVO tesAgreementManageCommonVO) {
		this.tesAgreementManageCommonVO = tesAgreementManageCommonVO;
	}

	public TesTmlAgmtThrpCostVO getTesTmlAgmtThrpCostVO() {
		return tesTmlAgmtThrpCostVO;
	}

	public void setTesTmlAgmtThrpCostVO(TesTmlAgmtThrpCostVO tesTmlAgmtThrpCostVO) {
		this.tesTmlAgmtThrpCostVO = tesTmlAgmtThrpCostVO;
	}

	public TesTmlAgmtHdrVO getTesTmlAgmtHdrVO() {
		return tesTmlAgmtHdrVO;
	}

	public void setTesTmlAgmtHdrVO(TesTmlAgmtHdrVO tesTmlAgmtHdrVO) {
		this.tesTmlAgmtHdrVO = tesTmlAgmtHdrVO;
	}

	public TesCommonVO[] getTesCommonVOs() {
		return tesCommonVOs;
	}

	public void setTesCommonVOs(TesCommonVO[] tesCommonVOs) {
		this.tesCommonVOs = tesCommonVOs;
	}

	public TesAgreementManageCommonVO[] getTesAgreementManageCommonVOs() {
		return tesAgreementManageCommonVOs;
	}

	public void setTesAgreementManageCommonVOs(
			TesAgreementManageCommonVO[] tesAgreementManageCommonVOs) {
		this.tesAgreementManageCommonVOs = tesAgreementManageCommonVOs;
	}

	public TesTmlAgmtThrpCostVO[] getTesTmlAgmtThrpCostVOs() {
		return tesTmlAgmtThrpCostVOs;
	}

	public void setTesTmlAgmtThrpCostVOs(
			TesTmlAgmtThrpCostVO[] tesTmlAgmtThrpCostVOs) {
		this.tesTmlAgmtThrpCostVOs = tesTmlAgmtThrpCostVOs;
	}



	public static long getSerialVersionUID() {
		return serialVersionUID;
	}


	
//	/** tes_tml_agmt_thrp_cost Table  Value Object */
//	private TES_TML_AGMT_THRP_COST tes_tml_agmt_thrp_cost = null;
//
//	/** tes_tml_agmt_thrp_costs Multi Action을 위한 Collection */
//	private Collection tes_tml_agmt_thrp_costs = null;
//
////	public EsdTes9180Event(){}
//
//	public EsdTes9180Event(TES_TML_AGMT_THRP_COST tes_tml_agmt_thrp_cost) {
//		this.tes_tml_agmt_thrp_cost = tes_tml_agmt_thrp_cost;
//    }
//
//	public EsdTes9180Event(TES_TML_AGMT_THRP_COST tes_tml_agmt_thrp_cost, Collection tes_tml_agmt_thrp_costs) {
//		this.tes_tml_agmt_thrp_cost = tes_tml_agmt_thrp_cost;
//		this.tes_tml_agmt_thrp_costs = tes_tml_agmt_thrp_costs;
//    }
//
//	public TES_TML_AGMT_THRP_COST getTES_TML_AGMT_THRP_COST(){
//		return tes_tml_agmt_thrp_cost;
//	}
//
//	public Collection getTES_TML_AGMT_THRP_COSTS(){
//		return tes_tml_agmt_thrp_costs;
//	}
//
//	public String getEventName() {
//		return "ESD_TES_918Event";
//	}
//
//	public String toString() {
//		return "ESD_TES_918Event";
//	}

}
