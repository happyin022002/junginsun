/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0020Event.java
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
 
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.YardVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0020HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0020HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0020Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public BcmCcd0020Event(){}
	
	public YardVO ydVO = null;
	
	public String ydCd = null;
	
	public String n1stVndrSeq = null;
	
	public String n2ndVndrSeq = null;
	
	public String n3rdVndrSeq = null;
	
	public String ofcCd = null;
	
	public String dmdtOfcCd = null;
	
	public String repZnCd = null;
	
	public String locCd = null;
	
	public String sccCd = null;
	
	private String rqstNo = null; 
	
	private MdmDatProcVO mdmDatProcVO = null;

	public YardVO getYdVO() {
		return ydVO;
	}

	public void setYdVO(YardVO ydVO) {
		this.ydVO = ydVO;
	}

	public String getYdCd() {
		return ydCd;
	}

	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}

	public String getN1stVndrSeq() {
		return n1stVndrSeq;
	}

	public void setN1stVndrSeq(String vndrSeq) {
		n1stVndrSeq = vndrSeq;
	}

	public String getN2ndVndrSeq() {
		return n2ndVndrSeq;
	}

	public void setN2ndVndrSeq(String vndrSeq) {
		n2ndVndrSeq = vndrSeq;
	}

	public String getN3rdVndrSeq() {
		return n3rdVndrSeq;
	}

	public void setN3rdVndrSeq(String vndrSeq) {
		n3rdVndrSeq = vndrSeq;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getDmdtOfcCd() {
		return dmdtOfcCd;
	}

	public void setDmdtOfcCd(String dmdtOfcCd) {
		this.dmdtOfcCd = dmdtOfcCd;
	}

	public String getRepZnCd() {
		return repZnCd;
	}

	public void setRepZnCd(String repZnCd) {
		this.repZnCd = repZnCd;
	}

	public String getLocCd() {
		return locCd;
	}

	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	public String getSccCd() {
		return sccCd;
	}

	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
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