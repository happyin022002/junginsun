/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FnsInv0016Event.java
 *@FileTitle : Invoice Item Correction(General)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.04
 *@LastModifier : 김세일
 *@LastVersion : 1.0
 * 2009.06.04 김세일
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARCreditInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARInvoiceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvNewCustVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARCorrectionCkVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceChargeCorrectionVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCorrectionVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArCntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceChargeSumVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceContainerVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * FNS_INV_0016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - FNS_INV_0016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author saeil kim
 * @see FNS_INV_0016HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0016Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private ARInvoiceCorrectionVO aRInvoiceCorrectionVO = null;

	/** Table Value Object Multi Data 처리 */
	private ARInvoiceCorrectionVO[] aRInvoiceCorrectionVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private DueDateInputVO dueDateInputVO = null;

	/** Table Value Object Multi Data 처리 */
	private DueDateInputVO[] dueDateInputVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private DueDateVO dueDateVO = null;

	/** Table Value Object Multi Data 처리 */
	private DueDateVO[] dueDateVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private ARCorrectionCkVO arCorrectionCkVO = null;

	/** Table Value Object Multi Data 처리 */
	private ARCorrectionCkVO[] arCorrectionCkVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private ARInvoiceCreationVO arInvoiceCreationVO = null;

	/** Table Value Object Multi Data 처리 */
	private ARInvoiceCreationVO[] arInvoiceCreationVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private InvNewCustVO invNewCustVO = null;

	/** Table Value Object Multi Data 처리 */
	private InvNewCustVO[] invNewCustVOs = null;

	private ARInvoiceChargeSumVO aRInvoiceChargeSumVO = null;

	private ARInvoiceChargeSumVO[] aRInvoiceChargeSumVOs = null;

	private ARInvoiceChargeCorrectionVO aRInvoiceChargeCorrectionVO = null;

	private ARInvoiceChargeCorrectionVO[] aRInvoiceChargeCorrectionVOs = null;

	private ARInvoiceContainerVO aRInvoiceContainerVO = null;

	private ARInvoiceContainerVO[] aRInvoiceContainerVOs = null;

	private InvArCntrVO invArCntrVO = null;

	private InvArCntrVO[] invArCntrVOs = null;

	private InvArMnVO invArMnVO = null;

	private InvArMnVO[] invArMnVOs = null;

	private ARCreditInputVO aRCreditInputVO = null;

	private String ofcCd = null;

	private String blNo = null;

	private String invNo = null;

	private String ifNo = null;

	private String splitFlg = null;

	private String actInvFlag = null;

	private String otherFlag = null;

	private String blSrcNo = null;

	private String classId = null;

	private String arOfcCd = null;

	private String otsSmryCd = null;

	private String modFlag = null;

	private String invCustFlg = null;
	
	private String blSrchFlg = null;

	public FnsInv0016Event() {
	}

	public void setARInvoiceCorrectionVO(ARInvoiceCorrectionVO aRInvoiceCorrectionVO) {
		this.aRInvoiceCorrectionVO = aRInvoiceCorrectionVO;
	}

	public void setARInvoiceCorrectionVOS(ARInvoiceCorrectionVO[] aRInvoiceCorrectionVOs) {
		if (aRInvoiceCorrectionVOs != null) {
			ARInvoiceCorrectionVO[] tmpVOs = new ARInvoiceCorrectionVO[aRInvoiceCorrectionVOs.length];
			System.arraycopy(aRInvoiceCorrectionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.aRInvoiceCorrectionVOs = tmpVOs;
		}
	}

	public ARInvoiceCorrectionVO getARInvoiceCorrectionVO() {
		return aRInvoiceCorrectionVO;
	}

	public ARInvoiceCorrectionVO[] getARInvoiceCorrectionVOS() {
		ARInvoiceCorrectionVO[] rtnVOs = null;
		if (this.aRInvoiceCorrectionVOs != null) {
			rtnVOs = new ARInvoiceCorrectionVO[aRInvoiceCorrectionVOs.length];
			System.arraycopy(aRInvoiceCorrectionVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @return the aRCreditInputVO
	 */
	public ARCreditInputVO getARCreditInputVO() {
		return aRCreditInputVO;
	}

	/**
	 * @param creditInputVO the aRCreditInputVO to set
	 */
	public void setARCreditInputVO(ARCreditInputVO creditInputVO) {
		aRCreditInputVO = creditInputVO;
	}

	/**
	 * @return the invCustFlg
	 */
	public String getInvCustFlg() {
		return invCustFlg;
	}

	/**
	 * @param invCustFlg the invCustFlg to set
	 */
	public void setInvCustFlg(String invCustFlg) {
		this.invCustFlg = invCustFlg;
	}

	/**
	 * @return the modFlag
	 */
	public String getModFlag() {
		return modFlag;
	}

	/**
	 * @param modFlag the modFlag to set
	 */
	public void setModFlag(String modFlag) {
		this.modFlag = modFlag;
	}

	/**
	 * @return the dueDateInputVO
	 */
	public DueDateInputVO getDueDateInputVO() {
		return dueDateInputVO;
	}

	/**
	 * @param dueDateInputVO the dueDateInputVO to set
	 */
	public void setDueDateInputVO(DueDateInputVO dueDateInputVO) {
		this.dueDateInputVO = dueDateInputVO;
	}

	/**
	 * @return the dueDateInputVOs
	 */
	public DueDateInputVO[] getDueDateInputVOs() {
		DueDateInputVO[] rtnVOs = null;
		if (this.dueDateInputVOs != null) {
			rtnVOs = new DueDateInputVO[dueDateInputVOs.length];
			System.arraycopy(dueDateInputVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param dueDateInputVOs the dueDateInputVOs to set
	 */
	public void setDueDateInputVOs(DueDateInputVO[] dueDateInputVOs) {
		if (dueDateInputVOs != null) {
			DueDateInputVO[] tmpVOs = new DueDateInputVO[dueDateInputVOs.length];
			System.arraycopy(dueDateInputVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.dueDateInputVOs = tmpVOs;
		}
	}

	/**
	 * @return the dueDateVO
	 */
	public DueDateVO getDueDateVO() {
		return dueDateVO;
	}

	/**
	 * @param dueDateVO the dueDateVO to set
	 */
	public void setDueDateVO(DueDateVO dueDateVO) {
		this.dueDateVO = dueDateVO;
	}

	/**
	 * @return the dueDateVOs
	 */
	public DueDateVO[] getDueDateVOs() {
		DueDateVO[] rtnVOs = null;
		if (this.dueDateVOs != null) {
			rtnVOs = new DueDateVO[dueDateVOs.length];
			System.arraycopy(dueDateVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param dueDateVOs the dueDateVOs to set
	 */
	public void setDueDateVOs(DueDateVO[] dueDateVOs) {
		if (dueDateVOs != null) {
			DueDateVO[] tmpVOs = new DueDateVO[dueDateVOs.length];
			System.arraycopy(dueDateVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.dueDateVOs = tmpVOs;
		}
	}

	/**
	 * @return the arCorrectionCkVO
	 */
	public ARCorrectionCkVO getArCorrectionCkVO() {
		return arCorrectionCkVO;
	}

	/**
	 * @param arCorrectionCkVO the arCorrectionCkVO to set
	 */
	public void setArCorrectionCkVO(ARCorrectionCkVO arCorrectionCkVO) {
		this.arCorrectionCkVO = arCorrectionCkVO;
	}

	/**
	 * @return the arCorrectionCkVOs
	 */
	public ARCorrectionCkVO[] getArCorrectionCkVOs() {
		ARCorrectionCkVO[] rtnVOs = null;
		if (this.arCorrectionCkVOs != null) {
			rtnVOs = new ARCorrectionCkVO[arCorrectionCkVOs.length];
			System.arraycopy(arCorrectionCkVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param arCorrectionCkVOs the arCorrectionCkVOs to set
	 */
	public void setArCorrectionCkVOs(ARCorrectionCkVO[] arCorrectionCkVOs) {
		if (arCorrectionCkVOs != null) {
			ARCorrectionCkVO[] tmpVOs = new ARCorrectionCkVO[arCorrectionCkVOs.length];
			System.arraycopy(arCorrectionCkVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.arCorrectionCkVOs = tmpVOs;
		}
	}

	/**
	 * @return the arInvoiceCreationVO
	 */
	public ARInvoiceCreationVO getArInvoiceCreationVO() {
		return arInvoiceCreationVO;
	}

	/**
	 * @param arInvoiceCreationVO the arInvoiceCreationVO to set
	 */
	public void setArInvoiceCreationVO(ARInvoiceCreationVO arInvoiceCreationVO) {
		this.arInvoiceCreationVO = arInvoiceCreationVO;
	}

	/**
	 * @return the arInvoiceCreationVOs
	 */
	public ARInvoiceCreationVO[] getArInvoiceCreationVOs() {
		ARInvoiceCreationVO[] rtnVOs = null;
		if (this.arInvoiceCreationVOs != null) {
			rtnVOs = new ARInvoiceCreationVO[arInvoiceCreationVOs.length];
			System.arraycopy(arInvoiceCreationVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param arInvoiceCreationVOs the arInvoiceCreationVOs to set
	 */
	public void setArInvoiceCreationVOs(ARInvoiceCreationVO[] arInvoiceCreationVOs) {
		if (arInvoiceCreationVOs != null) {
			ARInvoiceCreationVO[] tmpVOs = new ARInvoiceCreationVO[arInvoiceCreationVOs.length];
			System.arraycopy(arInvoiceCreationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.arInvoiceCreationVOs = tmpVOs;
		}
	}

	/**
	 * @return the invNewCustVO
	 */
	public InvNewCustVO getInvNewCustVO() {
		return invNewCustVO;
	}

	/**
	 * @param invNewCustVO the invNewCustVO to set
	 */
	public void setInvNewCustVO(InvNewCustVO invNewCustVO) {
		this.invNewCustVO = invNewCustVO;
	}

	/**
	 * @return the invNewCustVOs
	 */
	public InvNewCustVO[] getInvNewCustVOs() {
		InvNewCustVO[] rtnVOs = null;
		if (this.invNewCustVOs != null) {
			rtnVOs = new InvNewCustVO[invNewCustVOs.length];
			System.arraycopy(invNewCustVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param invNewCustVOs the invNewCustVOs to set
	 */
	public void setInvNewCustVOs(InvNewCustVO[] invNewCustVOs) {
		if (invNewCustVOs != null) {
			InvNewCustVO[] tmpVOs = new InvNewCustVO[invNewCustVOs.length];
			System.arraycopy(invNewCustVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invNewCustVOs = tmpVOs;
		}
	}

	/**
	 * @return the aRInvoiceCorrectionVOs
	 */
	public ARInvoiceCorrectionVO[] getARInvoiceCorrectionVOs() {
		ARInvoiceCorrectionVO[] rtnVOs = null;
		if (this.aRInvoiceCorrectionVOs != null) {
			rtnVOs = new ARInvoiceCorrectionVO[aRInvoiceCorrectionVOs.length];
			System.arraycopy(aRInvoiceCorrectionVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param invoiceCorrectionVOs the aRInvoiceCorrectionVOs to set
	 */
	public void setARInvoiceCorrectionVOs(ARInvoiceCorrectionVO[] aRInvoiceCorrectionVOs) {
		if (aRInvoiceCorrectionVOs != null) {
			ARInvoiceCorrectionVO[] tmpVOs = new ARInvoiceCorrectionVO[aRInvoiceCorrectionVOs.length];
			System.arraycopy(aRInvoiceCorrectionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.aRInvoiceCorrectionVOs = tmpVOs;
		}
	}

	/**
	 * @return the aRInvoiceChargeSumVO
	 */
	public ARInvoiceChargeSumVO getARInvoiceChargeSumVO() {
		return aRInvoiceChargeSumVO;
	}

	/**
	 * @param invoiceChargeSumVO the aRInvoiceChargeSumVO to set
	 */
	public void setARInvoiceChargeSumVO(ARInvoiceChargeSumVO invoiceChargeSumVO) {
		aRInvoiceChargeSumVO = invoiceChargeSumVO;
	}

	/**
	 * @return the aRInvoiceChargeSumVOs
	 */
	public ARInvoiceChargeSumVO[] getARInvoiceChargeSumVOs() {
		ARInvoiceChargeSumVO[] rtnVOs = null;
		if (this.aRInvoiceChargeSumVOs != null) {
			rtnVOs = new ARInvoiceChargeSumVO[aRInvoiceChargeSumVOs.length];
			System.arraycopy(aRInvoiceChargeSumVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param invoiceChargeSumVOs the aRInvoiceChargeSumVOs to set
	 */
	public void setARInvoiceChargeSumVOs(ARInvoiceChargeSumVO[] aRInvoiceChargeSumVOs) {
		if (aRInvoiceChargeSumVOs != null) {
			ARInvoiceChargeSumVO[] tmpVOs = new ARInvoiceChargeSumVO[aRInvoiceChargeSumVOs.length];
			System.arraycopy(aRInvoiceChargeSumVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.aRInvoiceChargeSumVOs = tmpVOs;
		}
	}

	/**
	 * @return the aRInvoiceChargeCorrectionVO
	 */
	public ARInvoiceChargeCorrectionVO getARInvoiceChargeCorrectionVO() {
		return aRInvoiceChargeCorrectionVO;
	}

	/**
	 * @param invoiceChargeCorrectionVO the aRInvoiceChargeCorrectionVO to set
	 */
	public void setARInvoiceChargeCorrectionVO(ARInvoiceChargeCorrectionVO invoiceChargeCorrectionVO) {
		aRInvoiceChargeCorrectionVO = invoiceChargeCorrectionVO;
	}

	/**
	 * @return the aRInvoiceChargeCorrectionVOs
	 */
	public ARInvoiceChargeCorrectionVO[] getARInvoiceChargeCorrectionVOs() {
		ARInvoiceChargeCorrectionVO[] rtnVOs = null;
		if (this.aRInvoiceChargeCorrectionVOs != null) {
			rtnVOs = new ARInvoiceChargeCorrectionVO[aRInvoiceChargeCorrectionVOs.length];
			System.arraycopy(aRInvoiceChargeCorrectionVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param invoiceChargeCorrectionVOs the aRInvoiceChargeCorrectionVOs to set
	 */
	public void setARInvoiceChargeCorrectionVOs(ARInvoiceChargeCorrectionVO[] aRInvoiceChargeCorrectionVOs) {
		if (aRInvoiceChargeCorrectionVOs != null) {
			ARInvoiceChargeCorrectionVO[] tmpVOs = new ARInvoiceChargeCorrectionVO[aRInvoiceChargeCorrectionVOs.length];
			System.arraycopy(aRInvoiceChargeCorrectionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.aRInvoiceChargeCorrectionVOs = tmpVOs;
		}
	}

	/**
	 * @return the invArCntrVO
	 */
	public InvArCntrVO getInvArCntrVO() {
		return invArCntrVO;
	}

	/**
	 * @param invArCntrVO the invArCntrVO to set
	 */
	public void setInvArCntrVO(InvArCntrVO invArCntrVO) {
		this.invArCntrVO = invArCntrVO;
	}

	/**
	 * @return the invArCntrVOs
	 */
	public InvArCntrVO[] getInvArCntrVOs() {
		InvArCntrVO[] rtnVOs = null;
		if (this.invArCntrVOs != null) {
			rtnVOs = new InvArCntrVO[invArCntrVOs.length];
			System.arraycopy(invArCntrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param invArCntrVOs the invArCntrVOs to set
	 */
	public void setInvArCntrVOs(InvArCntrVO[] invArCntrVOs) {
		if (invArCntrVOs != null) {
			InvArCntrVO[] tmpVOs = new InvArCntrVO[invArCntrVOs.length];
			System.arraycopy(invArCntrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invArCntrVOs = tmpVOs;
		}
	}

	/**
	 * @return the aRInvoiceContainerVO
	 */
	public ARInvoiceContainerVO getARInvoiceContainerVO() {
		return aRInvoiceContainerVO;
	}

	/**
	 * @param invoiceContainerVO the aRInvoiceContainerVO to set
	 */
	public void setARInvoiceContainerVO(ARInvoiceContainerVO invoiceContainerVO) {
		aRInvoiceContainerVO = invoiceContainerVO;
	}

	/**
	 * @return the aRInvoiceContainerVOs
	 */
	public ARInvoiceContainerVO[] getARInvoiceContainerVOs() {
		ARInvoiceContainerVO[] rtnVOs = null;
		if (this.aRInvoiceContainerVOs != null) {
			rtnVOs = new ARInvoiceContainerVO[aRInvoiceContainerVOs.length];
			System.arraycopy(aRInvoiceContainerVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param invoiceContainerVOs the aRInvoiceContainerVOs to set
	 */
	public void setARInvoiceContainerVOs(ARInvoiceContainerVO[] aRInvoiceContainerVOs) {
		if (aRInvoiceContainerVOs != null) {
			ARInvoiceContainerVO[] tmpVOs = new ARInvoiceContainerVO[aRInvoiceContainerVOs.length];
			System.arraycopy(aRInvoiceContainerVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.aRInvoiceContainerVOs = tmpVOs;
		}
	}

	/**
	 * @return the otsSmryCd
	 */
	public String getOtsSmryCd() {
		return otsSmryCd;
	}

	/**
	 * @param otsSmryCd the otsSmryCd to set
	 */
	public void setOtsSmryCd(String otsSmryCd) {
		this.otsSmryCd = otsSmryCd;
	}

	/**
	 * @return the blSrcNo
	 */
	public String getBlSrcNo() {
		return blSrcNo;
	}

	/**
	 * @param blSrcNo the blSrcNo to set
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}

	/**
	 * @return the classId
	 */
	public String getClassId() {
		return classId;
	}

	/**
	 * @param classId the classId to set
	 */
	public void setClassId(String classId) {
		this.classId = classId;
	}

	/**
	 * @return the arOfcCd
	 */
	public String getArOfcCd() {
		return arOfcCd;
	}

	/**
	 * @param arOfcCd the arOfcCd to set
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}

	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}

	/**
	 * @param ofcCd the ofcCd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * @return the blNo
	 */
	public String getBlNo() {
		return blNo;
	}

	/**
	 * @param blNo the blNo to set
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * @return the invNo
	 */
	public String getInvNo() {
		return invNo;
	}

	/**
	 * @param invNo the invNo to set
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	/**
	 * @return the ifNo
	 */
	public String getIfNo() {
		return ifNo;
	}

	/**
	 * @param ifNo the ifNo to set
	 */
	public void setIfNo(String ifNo) {
		this.ifNo = ifNo;
	}

	/**
	 * @return the splitFlg
	 */
	public String getSplitFlg() {
		return splitFlg;
	}

	/**
	 * @param splitFlg the splitFlg to set
	 */
	public void setSplitFlg(String splitFlg) {
		this.splitFlg = splitFlg;
	}

	/**
	 * @return the actInvFlag
	 */
	public String getActInvFlag() {
		return actInvFlag;
	}

	/**
	 * @param actInvFlag the actInvFlag to set
	 */
	public void setActInvFlag(String actInvFlag) {
		this.actInvFlag = actInvFlag;
	}

	/**
	 * @return the otherFlag
	 */
	public String getOtherFlag() {
		return otherFlag;
	}

	/**
	 * @param otherFlag the otherFlag to set
	 */
	public void setOtherFlag(String otherFlag) {
		this.otherFlag = otherFlag;
	}

	/**
	 * @return the invArMnVO
	 */
	public InvArMnVO getInvArMnVO() {
		return invArMnVO;
	}

	/**
	 * @param invArMnVO the invArMnVO to set
	 */
	public void setInvArMnVO(InvArMnVO invArMnVO) {
		this.invArMnVO = invArMnVO;
	}

	/**
	 * @return the invArMnVOs
	 */
	public InvArMnVO[] getInvArMnVOs() {
		InvArMnVO[] rtnVOs = null;
		if (this.invArMnVOs != null) {
			rtnVOs = new InvArMnVO[invArMnVOs.length];
			System.arraycopy(invArMnVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param invArMnVOs the invArMnVOs to set
	 */
	public void setInvArMnVOs(InvArMnVO[] invArMnVOs) {
		if (invArMnVOs != null) {
			InvArMnVO[] tmpVOs = new InvArMnVO[invArMnVOs.length];
			System.arraycopy(invArMnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invArMnVOs = tmpVOs;
		}
	}

	public String getBlSrchFlg() {
		return blSrchFlg;
	}

	public void setBlSrchFlg(String blSrchFlg) {
		this.blSrchFlg = blSrchFlg;
	}
}