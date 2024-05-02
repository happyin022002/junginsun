package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.event;
 
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * BCM_CCD_0053에 대한 DTOP(Data Transfer Object including Parameter)<br>
 * BCM_CCD_0053HTMLAction에서 작성<br>
 * ServiceCommand Layer로 전달하는 DTOP로 사용<br>
 * 
 * @author HA DAE SUNG
 * @see HTMLAction 참조
 */
public class BcmCcd0053Event extends EventSupport{

	private String rqstNo = "";
	private String vndrNm = "";
	private String ofcCd = "";
	private String deltFlg = "";
	private String rqstFmDt = "";
	private String rqstToDt = "";
	int 	iPage	= 0;
	private VendorVO mdmVendorVO = null;
	private VendorVO[] mdmVendorVOs = null;
	/**
	 * Constructor<br>
	 */
	public BcmCcd0053Event() {}
	
	public String getEventName() {
		return "BcmCcd0053Event";
	}
	
	public String toString() {
		return "BcmCcd0053Event";
	}
	
	public String getRqstNo() {
		return rqstNo;
	}
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}
	public String getVndrNm() {
		return vndrNm;
	}
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	public String getOfcCd() {
		return ofcCd;
	}
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	public String getDeltFlg() {
		return deltFlg;
	}
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	public String getRqstFmDt() {
		return rqstFmDt;
	}
	public void setRqstFmDt(String rqstFmDt) {
		this.rqstFmDt = rqstFmDt;
	}
	public String getRqstToDt() {
		return rqstToDt;
	}
	public void setRqstToDt(String rqstToDt) {
		this.rqstToDt = rqstToDt;
	}
	public int getIPage() {
		return iPage;
	}
	public void setIPage(int iPage) {
		this.iPage = iPage;
	}
	
	public VendorVO getMdmVendorVO() {
		return mdmVendorVO;
	}

	public void setMdmVendorVO(VendorVO mdmVendorVO) {
		this.mdmVendorVO = mdmVendorVO;
	}

	public VendorVO[] getMdmVendorVOs() {
		return mdmVendorVOs;
	}

	public void setMdmVendorVOs(VendorVO[] mdmVendorVOs) {
		this.mdmVendorVOs = mdmVendorVOs;
	}	
}
