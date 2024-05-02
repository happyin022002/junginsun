/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes9200Event.java
*@FileTitle : Volume Accumulate Method
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.09.24 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event;

import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.vo.TesAgreementManageCommonVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesTmlSoAccmCostVO;
import com.hanjin.syscommon.common.table.TesTmlSoAccmMzdVO;
import com.hanjin.syscommon.common.table.TesTmlSoAccmYdVO;


/**
 * ESD_TES_9200 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_9200HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author yOng hO lEE
 * @see ESD_TES_9200HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTes9200Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TesAgreementManageCommonVO 		tesAgreementManageCommonVO			= null;
//	private TesTmlAgmtHdrVO 				tesTmlAgmtHdrVO						= null;
	private TesTmlSoAccmYdVO 				tesTmlSoAccmYdVO					= null;
	private TesTmlSoAccmCostVO 				tesTmlSoAccmCostVO					= null;
	private TesTmlSoAccmMzdVO				tesTmlSoAccmMzdVO					= null;
	
	/** Table Value Object Multi Data 처리 */
	private TesAgreementManageCommonVO[]	tesAgreementManageCommonVOs			= null;
//	private TesTmlAgmtHdrVO[] 				tesTmlAgmtHdrVOs					= null;
	private TesTmlSoAccmYdVO[]				tesTmlSoAccmYdVOs					= null;
	private TesTmlSoAccmCostVO[] 			tesTmlSoAccmCostVOs					= null;
	private TesTmlSoAccmMzdVO[]				tesTmlSoAccmMzdVOs					= null;

	public EsdTes9200Event(){}

	public TesAgreementManageCommonVO getTesAgreementManageCommonVO() {
		return tesAgreementManageCommonVO;
	}

	public void setTesAgreementManageCommonVO(
			TesAgreementManageCommonVO tesAgreementManageCommonVO) {
		this.tesAgreementManageCommonVO = tesAgreementManageCommonVO;
	}

	public TesTmlSoAccmYdVO getTesTmlSoAccmYdVO() {
		return tesTmlSoAccmYdVO;
	}

	public void setTesTmlSoAccmYdVO(TesTmlSoAccmYdVO tesTmlSoAccmYdVO) {
		this.tesTmlSoAccmYdVO = tesTmlSoAccmYdVO;
	}

	public TesTmlSoAccmCostVO getTesTmlSoAccmCostVO() {
		return tesTmlSoAccmCostVO;
	}

	public void setTesTmlSoAccmCostVO(TesTmlSoAccmCostVO tesTmlSoAccmCostVO) {
		this.tesTmlSoAccmCostVO = tesTmlSoAccmCostVO;
	}

	public TesTmlSoAccmMzdVO getTesTmlSoAccmMzdVO() {
		return tesTmlSoAccmMzdVO;
	}

	public void setTesTmlSoAccmMzdVO(TesTmlSoAccmMzdVO tesTmlSoAccmMzdVO) {
		this.tesTmlSoAccmMzdVO = tesTmlSoAccmMzdVO;
	}

	public TesAgreementManageCommonVO[] getTesAgreementManageCommonVOs() {
		return tesAgreementManageCommonVOs;
	}

	public void setTesAgreementManageCommonVOs(
			TesAgreementManageCommonVO[] tesAgreementManageCommonVOs) {
		this.tesAgreementManageCommonVOs = tesAgreementManageCommonVOs;
	}

	public TesTmlSoAccmYdVO[] getTesTmlSoAccmYdVOs() {
		return tesTmlSoAccmYdVOs;
	}

	public void setTesTmlSoAccmYdVOs(TesTmlSoAccmYdVO[] tesTmlSoAccmYdVOs) {
		this.tesTmlSoAccmYdVOs = tesTmlSoAccmYdVOs;
	}

	public TesTmlSoAccmCostVO[] getTesTmlSoAccmCostVOs() {
		return tesTmlSoAccmCostVOs;
	}

	public void setTesTmlSoAccmCostVOs(TesTmlSoAccmCostVO[] tesTmlSoAccmCostVOs) {
		this.tesTmlSoAccmCostVOs = tesTmlSoAccmCostVOs;
	}

	public TesTmlSoAccmMzdVO[] getTesTmlSoAccmMzdVOs() {
		return tesTmlSoAccmMzdVOs;
	}

	public void setTesTmlSoAccmMzdVOs(TesTmlSoAccmMzdVO[] tesTmlSoAccmMzdVOs) {
		this.tesTmlSoAccmMzdVOs = tesTmlSoAccmMzdVOs;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

//	/** Key Parameters */
//	/// vndr_seq, accm_seq, accm_cost_seq, accm_dtl_seq, user_id 
//	private String vndr_seq = null; 
//	private String accm_seq = null;
//	private String accm_cost_seq = null;
//	private String accm_dtl_seq = null;
//	private String ofc_cd = null;
//	
//	/// user info 
//	private String user_id = null; /// getSignOnUserAccount로부터 
//	
//	/** tes_tml_so_accm_mzd Table  Value Object */
//	private TES_TML_SO_ACCM_MZD tes_tml_so_accm_mzd = null;
//	/** tes_tml_so_accm_mzds Multi Action을 위한 Collection */
//	private Collection tes_tml_so_accm_mzds = null;
//
//	/** tes_tml_so_accm_yd Table  Value Object */
//	private TES_TML_SO_ACCM_COST tes_tml_so_accm_cost = null;
//	/** tes_tml_so_accm_yds Multi Action을 위한 Collection */
//	private Collection tes_tml_so_accm_costs = null;
//	
//	/** tes_tml_so_accm_yd Table  Value Object */
//	private TES_TML_SO_ACCM_YD tes_tml_so_accm_yd = null;
//	/** tes_tml_so_accm_yds Multi Action을 위한 Collection */
//	private Collection tes_tml_so_accm_yds = null;
//
//	///===== constructors =========================================	
//	public EsdTes9200Event(){
//	}
//
//	public EsdTes9200Event(String[] params) {
//		if ( params!=null && params.length>=1 ) { this.vndr_seq = params[0]; }
//		if ( params!=null && params.length>=2 ) { this.accm_seq = params[1]; }
//		if ( params!=null && params.length>=3 ) { this.accm_cost_seq = params[2]; }
//		if ( params!=null && params.length>=4 ) { this.accm_dtl_seq = params[3]; }
//		if ( params!=null && params.length>=5 ) { this.user_id = params[4]; }
//		if ( params!=null && params.length>=6 ) { this.user_id = params[5]; }
//    }
//	public EsdTes9200Event(Collection tes_tml_so_accm_mzds, Collection tes_tml_so_accm_costs, Collection tes_tml_so_accm_yds) {
//		this.tes_tml_so_accm_mzds = tes_tml_so_accm_mzds;
//		this.tes_tml_so_accm_costs = tes_tml_so_accm_costs;
//		this.tes_tml_so_accm_yds = tes_tml_so_accm_yds;
//
//	}
//	public EsdTes9200Event(String[] params, Collection tes_tml_so_accm_mzds, Collection tes_tml_so_accm_costs, Collection tes_tml_so_accm_yds) {
//		if ( params!=null && params.length>=1 ) { this.vndr_seq = params[0]; }
//		if ( params!=null && params.length>=2 ) { this.accm_seq = params[1]; }
//		if ( params!=null && params.length>=3 ) { this.accm_cost_seq = params[2]; }
//		if ( params!=null && params.length>=4 ) { this.accm_dtl_seq = params[3]; }
//		if ( params!=null && params.length>=5 ) { this.user_id = params[4]; }
//		if ( params!=null && params.length>=6 ) { this.user_id = params[5]; }
//		this.tes_tml_so_accm_mzds = tes_tml_so_accm_mzds;
//		this.tes_tml_so_accm_costs = tes_tml_so_accm_costs; 
//		this.tes_tml_so_accm_yds = tes_tml_so_accm_yds;
//    }
//
//	///===== setters =========================================
//
//	
//	///===== getters =========================================
//	public TES_TML_SO_ACCM_MZD getTES_TML_SO_ACCM_MZD(){
//		return tes_tml_so_accm_mzd;
//	}
//
//	public Collection getTES_TML_SO_ACCM_MZDS(){
//		return tes_tml_so_accm_mzds;
//	}
//
//	public TES_TML_SO_ACCM_COST getTES_TML_SO_ACCM_COST(){
//		return tes_tml_so_accm_cost;
//	}
//
//	public Collection getTES_TML_SO_ACCM_COSTS(){
//		return tes_tml_so_accm_costs;
//	}
//	
//	public TES_TML_SO_ACCM_YD getTES_TML_SO_ACCM_YD(){
//		return tes_tml_so_accm_yd;
//	}
//
//	public Collection getTES_TML_SO_ACCM_YDS(){
//		return tes_tml_so_accm_yds;
//	}
//	
//	public String[] getParams(){
//		return new String[]{this.vndr_seq, this.accm_seq, this.accm_cost_seq, this.accm_dtl_seq, this.user_id, this.ofc_cd};
//	}
//	
//	///--- --- 
//	public String getEventName() {
//		return "ESD_TES_920Event";
//	}
//
//	public String toString() {
//		return "ESD_TES_920Event";
//	}

}
