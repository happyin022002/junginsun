/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0019Event.java
*@FileTitle : yard
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.location.event;
   
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.LocationVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0019HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public BcmCcd0019Event(){}
	
	private LocationVO locVO = null;
	
	private String locCd = null;

	private String scontiCd = null;

	private String cntCd = null;

	private String rgnCd = null;
	
	private String steCd = null;

	private String sccCd = null;

	private String repZnCd = null;
	
	private String slsOfcCd = null;

	private String eqCtrlOfcCd = null;

	private String fincCtrlOfcCd = null;

	private String mtyPkupYdCd = null;

	private String eqRtnYdCd = null;

	private String hubLocCd = null;
	
	private String rqstNo = null; 
	
	private MdmDatProcVO mdmDatProcVO = null;

	public LocationVO getLocVO() {
		return locVO;
	}

	public void setLocVO(LocationVO locVO) {
		this.locVO = locVO;
	}

	public String getLocCd() {
		return locCd;
	}

	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	public String getScontiCd() {
		return scontiCd;
	}

	public void setScontiCd(String scontiCd) {
		this.scontiCd = scontiCd;
	}

	public String getCntCd() {
		return cntCd;
	}

	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}

	public String getRgnCd() {
		return rgnCd;
	}

	public void setRgnCd(String rgnCd) {
		this.rgnCd = rgnCd;
	}

	public String getSteCd() {
		return steCd;
	}

	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}

	public String getSccCd() {
		return sccCd;
	}

	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}

	public String getRepZnCd() {
		return repZnCd;
	}

	public void setRepZnCd(String repZnCd) {
		this.repZnCd = repZnCd;
	}

	public String getSlsOfcCd() {
		return slsOfcCd;
	}

	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}

	public String getEqCtrlOfcCd() {
		return eqCtrlOfcCd;
	}

	public void setEqCtrlOfcCd(String eqCtrlOfcCd) {
		this.eqCtrlOfcCd = eqCtrlOfcCd;
	}

	public String getFincCtrlOfcCd() {
		return fincCtrlOfcCd;
	}

	public void setFincCtrlOfcCd(String fincCtrlOfcCd) {
		this.fincCtrlOfcCd = fincCtrlOfcCd;
	}

	public String getMtyPkupYdCd() {
		return mtyPkupYdCd;
	}

	public void setMtyPkupYdCd(String mtyPkupYdCd) {
		this.mtyPkupYdCd = mtyPkupYdCd;
	}

	public String getEqRtnYdCd() {
		return eqRtnYdCd;
	}

	public void setEqRtnYdCd(String eqRtnYdCd) {
		this.eqRtnYdCd = eqRtnYdCd;
	}

	public String getHubLocCd() {
		return hubLocCd;
	}

	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
	}
	
	public String getRqstNo() {
		return rqstNo;
	}
	
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}
	
	public MdmDatProcVO getMdmDatProcVO() {
		return mdmDatProcVO;
	}

	public void setMdmDatProcVO(MdmDatProcVO mdmDatProcVO) {
		this.mdmDatProcVO = mdmDatProcVO;
	}
}