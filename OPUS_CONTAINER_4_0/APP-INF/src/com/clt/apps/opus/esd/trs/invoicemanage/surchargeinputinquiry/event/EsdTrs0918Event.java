/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_918Event.java
*@FileTitle : surcharge 입력/수정/삭제화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-09
*@LastModifier : poong_yeon
*@LastVersion : 1.0 
* 2006-11-09 poong_yeon
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.event;

import java.util.Arrays;
import java.util.Collection;

import com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.vo.SurchargeVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo.searchWorkOrderIssueListVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TrsTrspScgDtlVO;


/**
 * ESD_TRS_918 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_918HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author poong_yeon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0918Event extends EventSupport {

	/** trs_trsp_scg_dtl Table  Value Object */
	private TrsTrspScgDtlVO trsTrspScgDtl = null;

	/** trs_trsp_scg_dtls Multi Action을 위한 Collection */
	private Collection trsTrspScgDtls = null;

	/** surchargeVO Collection */
	private SurchargeVO surchargeVO = null;
	private SurchargeVO[] surchargeVOs = null;

	public EsdTrs0918Event(){}

	String trspSoOfcCtyCd;
	String trspSoSeq;
	String formUsrOfcCd;
	String formCreUsrId;

    // 2014.11.22    Hyungwook Choi
    private searchWorkOrderIssueListVO singleVO = null;
    private searchWorkOrderIssueListVO[] multiVO = null;

    public searchWorkOrderIssueListVO getSingleVO()
    {
        return singleVO;
    }

    public void setSingleVO(searchWorkOrderIssueListVO singleVO)
    {
        this.singleVO = singleVO;
    }

    public searchWorkOrderIssueListVO[] getMultiVO()
    {
        searchWorkOrderIssueListVO[] rtnVOs = null;
		if (this.multiVO != null) {
			rtnVOs = Arrays.copyOf(this.multiVO, this.multiVO.length);
		} // end if
		return rtnVOs;
    }

    public void setMultiVO(searchWorkOrderIssueListVO[] multiVO)
    {
		if (multiVO != null) {
			searchWorkOrderIssueListVO[] tmpVOs = Arrays.copyOf(multiVO, multiVO.length);
			this.multiVO = tmpVOs;
		} // end if
    }

	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd){
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}
	public String getTrspSoOfcCtyCd(){
		return trspSoOfcCtyCd;
	} 
		
	public void setTrspSoSeq(String trspSoSeq){          
		this.trspSoSeq = trspSoSeq;
	}
	public String getTrspSoSeq(){
		return trspSoSeq;
	}
	public void setFormUsrOfcCd(String formUsrOfcCd){
		this.formUsrOfcCd = formUsrOfcCd;
	}
	public String getFormUsrOfcCd(){
		return formUsrOfcCd;
	}
	
	public void setFormCreUsrId(String formCreUsrId){
		this.formCreUsrId = formCreUsrId;
	}
	public String getFormCreUsrId(){
		return formCreUsrId;
	}

	/**
	 * @param trsTrspScgDtl
	 */
	public EsdTrs0918Event(TrsTrspScgDtlVO trsTrspScgDtl) {
		this.trsTrspScgDtl = trsTrspScgDtl;
    }

	/**
	 * @param tableSingle
	 * @param trsTrspScgDtls
	 */
	public EsdTrs0918Event(TrsTrspScgDtlVO tableSingle, Collection trsTrspScgDtls) {
		this.trsTrspScgDtl = tableSingle;
		this.trsTrspScgDtls = trsTrspScgDtls;
    }

	public TrsTrspScgDtlVO getTrsTrspScgDtl(){
		return trsTrspScgDtl;
	}

	public Collection getTrsTrspScgDtls(){
		return trsTrspScgDtls;
	}

	/**
	 * @return the surchargeVO
	 */
	public SurchargeVO getSurchargeVO() {
		return surchargeVO;
	}
	/**
	 * @param surchargeVO the surchargeVO to set
	 */
	public void setSurchargeVO(SurchargeVO surchargeVO) {
		this.surchargeVO = surchargeVO;
	}
	/**
	 * @return the surchargeVOs
	 */
	public SurchargeVO[] getSurchargeVOs() {
		SurchargeVO[] rtnVOs = null;
		if (this.surchargeVOs != null) {
			rtnVOs = Arrays.copyOf(this.surchargeVOs, this.surchargeVOs.length);
		} // end if
		return rtnVOs;
	}
	/**
	 * @param surchargeVOs the surchargeVOs to set
	 */
	public void setSurchargeVOs(SurchargeVO[] surchargeVOs) {
		if (surchargeVOs != null) {
			SurchargeVO[] tmpVOs = Arrays.copyOf(surchargeVOs, surchargeVOs.length);
			this.surchargeVOs = tmpVOs;
		} // end if
	}
	public String getEventName() {
		return "EsdTrs0918Event";
	}

	public String toString() {
		return "EsdTrs0918Event";
	}

}
