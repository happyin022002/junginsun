/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_TRS_033Event.java
 *@FileTitle : Service provider로부터 접수한 Invoice를 Container 단위로 Audit하고 수정하여 Confirm하는 화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-01-03
 *@LastModifier : poong_yeon
 *@LastVersion : 1.0 
 * 2007-01-03 poong_yeon
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.event;

import java.util.Arrays;
import java.util.List;

import com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.vo.InvoiceAuditVO;
import com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.vo.SearchInvoiceAuditVO;
import com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.vo.SurchargeVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;
import com.clt.syscommon.common.table.TrsTrspWrkOrdVO;

/**
 * ESD_TRS_033 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_033HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author poong_yeon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0033Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String trspSoOfcCtyCd;

	private String trspSoSeq;

	private String ofcCd;

	private String trspInvCalcLgcTpCd;

	private String invXchRt;

	private String comboSvcProvider = null;

	private String applyCurrency = null;

	private String formCreUsrId = null;

	private String formUsrOfcCd = null;

	private String paymentVndrCd = null;

	private String woVndrCd = null;

	private String ref_seq = null;

	/** TrsTrspWrkOrdVO Table Value Object */
	private TrsTrspWrkOrdVO trsTrspWrkOrdVO = null;

	/** TrsTrspWrkOrdVO Table Value Object */
	private TrsTrspSvcOrdVO trsTrspSvcOrdVO = null;

	private InvoiceAuditVO invoiceAuditVO = null;

	/** TrsTrspWrkOrdVOs Multi Action을 위한 Array */
	private TrsTrspWrkOrdVO[] trsTrspWrkOrdVOs = null;

	private List<TrsTrspWrkOrdVO> trsTrspWrkOrdVoList = null;

	private List<TrsTrspSvcOrdVO> trsTrspSvcOrdVoList = null;

	/** TrsTrspSvcOrdVOs Multi Action을 위한 Array */
	private TrsTrspSvcOrdVO[] trsTrspSvcOrdVOs = null;

	/** TrsTrspSvcOrdVOs Multi Action을 위한 Array */
	private TrsTrspSvcOrdVO[] openerTrsTrspSvcOrdVOs = null;

	private List<TrsTrspSvcOrdVO> openerTrsTrspSvcOrdVoList = null;

	/** InvoiceAuditVO Multi Action을 위한 Array */
	private InvoiceAuditVO[] invoiceAuditVOs = null;

	private List<InvoiceAuditVO> invoiceAuditVoList = null;

	/** TrsTrspSvcOrdVOs Multi Action을 위한 Array */
	private SurchargeVO[] surchargeVOs = null;

	private SurchargeVO surchargeVO = null;

	private List<SurchargeVO> surchargeVoList = null;

	private SearchInvoiceAuditVO searchInvoiceAuditVO = null;

	public EsdTrs0033Event() {
	}

	/**
	 * @param TrsTrspWrkOrdVO TrsTrspWrkOrdVO
	 */
	public EsdTrs0033Event(TrsTrspWrkOrdVO TrsTrspWrkOrdVO) {
		this.trsTrspWrkOrdVO = TrsTrspWrkOrdVO;
	}

	/**
	 * @param TrsTrspWrkOrdVO TrsTrspWrkOrdVO
	 * @param TrsTrspWrkOrdVOs TrsTrspWrkOrdVOs
	 */
	public EsdTrs0033Event(TrsTrspWrkOrdVO TrsTrspWrkOrdVO, TrsTrspWrkOrdVO[] TrsTrspWrkOrdVOs) {
		this.trsTrspWrkOrdVO = TrsTrspWrkOrdVO;
		this.trsTrspWrkOrdVOs = TrsTrspWrkOrdVOs;
	}

	public InvoiceAuditVO getInvoiceAuditVO() {
		return this.invoiceAuditVO;
	}

	public void setInvoiceAuditVO(InvoiceAuditVO invoiceAuditVOValue) {
		this.invoiceAuditVO = invoiceAuditVOValue;
	}

	public TrsTrspWrkOrdVO getTrsTrspWrkOrdVO() {
		return trsTrspWrkOrdVO;
	}

	public TrsTrspSvcOrdVO getTrsTrspSvcOrdVO() {
		return trsTrspSvcOrdVO;
	}

	public TrsTrspWrkOrdVO[] getTrsTrspWrkOrdVOS() {
		TrsTrspWrkOrdVO[] rtnVOs = null;
		if (this.trsTrspWrkOrdVOs != null) {
			rtnVOs = Arrays.copyOf(this.trsTrspWrkOrdVOs, this.trsTrspWrkOrdVOs.length);
		} // end if
		return rtnVOs;
	}

	public TrsTrspSvcOrdVO[] getTrsTrspSvcOrdVOS() {
		TrsTrspSvcOrdVO[] rtnVOs = null;
		if (this.trsTrspSvcOrdVOs != null) {
			rtnVOs = Arrays.copyOf(this.trsTrspSvcOrdVOs, this.trsTrspSvcOrdVOs.length);
		} // end if
		return rtnVOs;
	}

	public TrsTrspSvcOrdVO[] getOPENER_TrsTrspSvcOrdVOS() {
		TrsTrspSvcOrdVO[] rtnVOs = null;
		if (this.openerTrsTrspSvcOrdVOs != null) {
			rtnVOs = Arrays.copyOf(this.openerTrsTrspSvcOrdVOs, this.openerTrsTrspSvcOrdVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setTrsTrspSvcOrdVO(TrsTrspSvcOrdVO TrsTrspSvcOrdVO_value) {
		this.trsTrspSvcOrdVO = TrsTrspSvcOrdVO_value;
	}

	public void setTrsTrspSvcOrdVOS(TrsTrspSvcOrdVO[] TrsTrspSvcOrdVOs_value) {
		if (TrsTrspSvcOrdVOs_value != null) {
			TrsTrspSvcOrdVO[] tmpVOs = Arrays.copyOf(TrsTrspSvcOrdVOs_value, TrsTrspSvcOrdVOs_value.length);
			this.trsTrspSvcOrdVOs = tmpVOs;
		} // end if
	}

	public void setOPENER_TrsTrspSvcOrdVOS(TrsTrspSvcOrdVO[] TrsTrspSvcOrdVOs_value) {
		if (TrsTrspSvcOrdVOs_value != null) {
			TrsTrspSvcOrdVO[] tmpVOs = Arrays.copyOf(TrsTrspSvcOrdVOs_value, TrsTrspSvcOrdVOs_value.length);
			this.openerTrsTrspSvcOrdVOs = tmpVOs;
		} // end if
	}

	public String getEventName() {
		return "EsdTrs0033Event";
	}

	public String toString() {
		return "EsdTrs0033Event";
	}

	public void setCombo_svc_provider(String comboSvcProvider) {
		this.comboSvcProvider = comboSvcProvider;
	}

	public String getCombo_svc_provider() {
		return comboSvcProvider;
	}

	public void setTrsTrspWrkOrdVOS(TrsTrspWrkOrdVO[] TrsTrspWrkOrdVOs_value) {
		if (TrsTrspWrkOrdVOs_value != null) {
			TrsTrspWrkOrdVO[] tmpVOs = Arrays.copyOf(TrsTrspWrkOrdVOs_value, TrsTrspWrkOrdVOs_value.length);
			this.trsTrspWrkOrdVOs = tmpVOs;
		} // end if
	}

	public void setInvoiceAuditVOs(InvoiceAuditVO[] invoiceAuditVOs) {
		if (invoiceAuditVOs != null) {
			InvoiceAuditVO[] tmpVOs = Arrays.copyOf(invoiceAuditVOs, invoiceAuditVOs.length);
			this.invoiceAuditVOs = tmpVOs;
		} // end if
	}

	public InvoiceAuditVO[] getInvoiceAuditVOs() {
		InvoiceAuditVO[] rtnVOs = null;
		if (this.invoiceAuditVOs != null) {
			rtnVOs = Arrays.copyOf(this.invoiceAuditVOs, this.invoiceAuditVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setSurchargeVOs(SurchargeVO[] surchargeVOs) {
		if (surchargeVOs != null) {
			SurchargeVO[] tmpVOs = Arrays.copyOf(surchargeVOs, surchargeVOs.length);
			this.surchargeVOs = tmpVOs;
		} // end if
	}

	public SurchargeVO[] getSurchargeVOs() {
		SurchargeVO[] rtnVOs = null;
		if (this.surchargeVOs != null) {
			rtnVOs = Arrays.copyOf(this.surchargeVOs, this.surchargeVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setSearchInvoiceAuditVO(SearchInvoiceAuditVO searchInvoiceAuditVO) {
		this.searchInvoiceAuditVO = searchInvoiceAuditVO;
	}

	public SearchInvoiceAuditVO getSearchInvoiceAuditVO() {
		return searchInvoiceAuditVO;
	}

	public void setSurchargeVO(SurchargeVO surchargeVO) {
		this.surchargeVO = surchargeVO;
	}

	public SurchargeVO getSurchargeVO() {
		return surchargeVO;
	}

	public void setTrsTrspSvcOrdVoList(List<TrsTrspSvcOrdVO> trsTrspSvcOrdVoList) {
		this.trsTrspSvcOrdVoList = trsTrspSvcOrdVoList;
	}

	public List<TrsTrspSvcOrdVO> getTrsTrspSvcOrdVoList() {
		return trsTrspSvcOrdVoList;
	}

	public void setOpener_TrsTrspSvcOrdVoList(List<TrsTrspSvcOrdVO> openerTrsTrspSvcOrdVoList) {
		this.openerTrsTrspSvcOrdVoList = openerTrsTrspSvcOrdVoList;
	}

	public List<TrsTrspSvcOrdVO> getOpener_TrsTrspSvcOrdVoList() {
		return openerTrsTrspSvcOrdVoList;
	}

	public void setSurchargeVoList(List<SurchargeVO> surchargeVoList) {
		this.surchargeVoList = surchargeVoList;
	}

	public List<SurchargeVO> getSurchargeVoList() {
		return surchargeVoList;
	}

	public void setInvoiceAuditVoList(List<InvoiceAuditVO> invoiceAuditVoList) {
		this.invoiceAuditVoList = invoiceAuditVoList;
	}

	public List<InvoiceAuditVO> getInvoiceAuditVoList() {
		return invoiceAuditVoList;
	}

	public void setTrsTrspWrkOrdVoList(List<TrsTrspWrkOrdVO> trsTrspWrkOrdVoList) {
		this.trsTrspWrkOrdVoList = trsTrspWrkOrdVoList;
	}

	public List<TrsTrspWrkOrdVO> getTrsTrspWrkOrdVoList() {
		return trsTrspWrkOrdVoList;
	}

	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}

	public String getTrspSoOfcCtyCd() {
		return trspSoOfcCtyCd;
	}

	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}

	public String getTrspSoSeq() {
		return trspSoSeq;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setTrspInvCalcLgcTpCd(String trspInvCalcLgcTpCd) {
		this.trspInvCalcLgcTpCd = trspInvCalcLgcTpCd;
	}

	public String getTrspInvCalcLgcTpCd() {
		return trspInvCalcLgcTpCd;
	}

	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}

	public String getInvXchRt() {
		return invXchRt;
	}

	public void setApply_currency(String applyCurrency) {
		this.applyCurrency = applyCurrency;
	}

	public String getApply_currency() {
		return applyCurrency;
	}

	public void setFORM_CRE_USR_ID(String formCreUsrId) {
		this.formCreUsrId = formCreUsrId;
	}

	public String getFORM_CRE_USR_ID() {
		return formCreUsrId;
	}

	public void setFORM_USR_OFC_CD(String formUsrOfcCd) {
		this.formUsrOfcCd = formUsrOfcCd;
	}

	public String getFORM_USR_OFC_CD() {
		return formUsrOfcCd;
	}

	public void setPayment_vndr_cd(String paymentVndrCd) {
		this.paymentVndrCd = paymentVndrCd;
	}

	public String getPayment_vndr_cd() {
		return paymentVndrCd;
	}

	public void setWo_vndr_cd(String woVndrCd) {
		this.woVndrCd = woVndrCd;
	}

	public String getWo_vndr_cd() {
		return woVndrCd;
	}

	public String getRef_seq() {
		return ref_seq;
	}

	public void setRef_seq(String ref_seq) {
		this.ref_seq = ref_seq;
	}
}
