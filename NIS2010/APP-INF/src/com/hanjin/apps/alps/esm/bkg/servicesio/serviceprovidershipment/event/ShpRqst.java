/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ShpRqst.java
*@FileTitle : ShpRqst
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.10
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 2012.04.10 SEO MI JIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author SEO MI JIN
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ShpRqst {
	private String saveDvsn = null;
	private String bkgNo = null;
	private String cntrNo = null;
	private String cntrTpszCd = null;
	private String cntrSealNo = null;
	private double pckQty = 0;
	private String pckTpCd = null;
	private double cntrWgt = 0;
	private String wgtUtCd = null;
	private double measQty = 0;
	private String measUtCd = null;
	private double cntrVolQty = 0;
	private String polCd = null;
	private String vrfyRslt = null;
	private String updDtFrom = null;
	private String updDtTo = null;
	private String verifyMessage = null;
	private String slaneCd = null;
	private String vvd = null;	
	private int cntrSeq = 0;
	private int vndrSeq = 0; 
	private String verifySelect = null;

	public void setSaveDvsn(String saveDvsn) {
		this.saveDvsn = saveDvsn;
	}

	/**
     * get saveDvsn
     * 
     * @return String saveDvsn
     */
    public String getSaveDvsn() {
    	return saveDvsn;
    }
	
    /**
     * get bkgNo
     * 
     * @return String bkgNo
     */
    public String getBkgNo() {
    	return bkgNo;
    }
    
    /**
     * set bkgNo
     * 
     * @param bkgNo String
     */
    public void setBkgNo(String bkgNo) {
    	this.bkgNo = bkgNo;
    }
    
    /**
     * get cntrNo
     * 
     * @return String cntrNo
     */
    public String getCntrNo() {
    	return cntrNo;
    }
    
    /**
     * set CntrNo
     * 
     * @param CntrNo String
     */
    public void setCntrNo(String cntrNo) {
    	this.cntrNo = cntrNo;
    }
        
    /**
     * get cntrTpszCd
     * 
     * @return String cntrTpszCd
     */
    public String getCntrTpszCd() {
    	return cntrTpszCd;
    }
    
    /**
     * set cntrTpszCd
     * 
     * @param cntrTpszCd String
     */
    public void setCntrTpszCd(String cntrTpszCd) {
    	this.cntrTpszCd = cntrTpszCd;
    }
    
    /**
     * get cntrSealNo
     * 
     * @return String cntrSealNo
     */
    public String getCntrSealNo() {
    	return cntrSealNo;
    }
    
    /**
     * set cntrSealNo
     * 
     * @param cntrSealNo String
     */
    public void setCntrSealNo(String cntrSealNo) {
    	this.cntrSealNo = cntrSealNo;
    }
    
    
    public double getPckQty() {
		return pckQty;
	}

	public void setPckQty(double pckQty) {
		this.pckQty = pckQty;
	}

	/**
     * get pckTpCd
     * 
     * @return String pckTpCd
     */
    public String getPckTpCd() {
    	return pckTpCd;
    }
    
    /**
     * set pckTpCd
     * 
     * @param pckTpCd String
     */
    public void setPckTpCd(String pckTpCd) {
    	this.pckTpCd = pckTpCd;
    }
         
    /**
     * get cntrWgt
     * 
     * @return cntrWgt double
     */
    public double getCntrWgt() {
    	return cntrWgt;
    }
    
    /**
     * set cntrWgt
     * 
     * @param cntrWgt double
     */
    public void setCntrWgt(double cntrWgt) {
    	this.cntrWgt = cntrWgt;
    }
    
    /**
     * get wgtUtCd
     * 
     * @return String wgtUtCd
     */
    public String getWgtUtCd() {
    	return wgtUtCd;
    }
    
    /**
     * set wgtUtCd
     * 
     * @param wgtUtCd String
     */
    public void setWgtUtCd(String wgtUtCd) {
    	this.wgtUtCd = wgtUtCd;
    }
    
    /**
     * get measQty
     * 
     * @return double measQty
     */
    public double getMeasQty() {
    	return measQty;
    }
    
    /**
     * set measQty
     * 
     * @param measQty double
     */
    public void setMeasQty(double measQty) {
    	this.measQty = measQty;
    }
    
    /**
     * get measUtCd
     * 
     * @return String measUtCd
     */
    public String getMeasUtCd() {
    	return measUtCd;
    }
    
    /**
     * set measUtCd
     * 
     * @param measUtCd String
     */
    public void setMeasUtCd(String measUtCd) {
    	this.measUtCd = measUtCd;
    }
    
    /**
     * get cntrVolQty
     * 
     * @return double cntrVolQty
     */
    public double getCntrVolQty() {
    	return cntrVolQty;
    }
    
    /**
     * set cntrVolQty
     * 
     * @param cntrVolQty double
     */
    public void setCntrVolQty(double cntrVolQty) {
    	this.cntrVolQty =cntrVolQty;
    }
    
    /**
     * get polCd
     * 
     * @return String polCd
     */
    public String getPolCd() {
    	return polCd;
    }
    
    /**
     * set polCd
     * 
     * @param polCd String
     */
    public void setPolCd(String polCd) {
    	this.polCd = polCd;
    }
    
    /**
     * get vrfyRslt
     * 
     * @return String vrfyRslt
     */
    public String getVrfyRslt() {
    	return vrfyRslt;
    }
    
    /**
     * set vrfyRslt
     * 
     * @param vrfyRslt String
     */
    public void setVrfyRslt(String vrfyRslt) {
    	this.vrfyRslt = vrfyRslt;
    }
    
    /**
     * get updDtFrom
     * 
     * @return String updDtFrom
     */
    public String getUpdDtFrom() {
    	return updDtFrom;
    }
    
    /**
     * set updDtFrom
     * 
     * @param updDtFrom String
     */
    public void setUpdDtFrom(String updDtFrom) {
    	this.updDtFrom = updDtFrom;
    }
    
    /**
     * get updDtTo
     * 
     * @return String updDtTo
     */
    public String getUpdDtTo() {
    	return updDtTo;
    }
    
    /**
     * set updDtTo
     * 
     * @param updDtTo String
     */
    public void setUpdDtTo(String updDtTo) {
    	this.updDtTo = updDtTo;
    }

	public String getVerifyMessage() {
		return verifyMessage;
	}

	public void setVerifyMessage(String verifyMessage) {
		this.verifyMessage = verifyMessage;
	}

	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	public String getSlaneCd() {
		return slaneCd;
	}

	public void setSlaneCd(String slaneCd) {
		this.slaneCd = slaneCd;
	}

	public int getCntrSeq() {
		return cntrSeq;
	}

	public void setCntrSeq(int cntrSeq) {
		this.cntrSeq = cntrSeq;
	}

	public int getVndrSeq() {
		return vndrSeq;
	}

	public void setVndrSeq(int vndrSeq) {
		this.vndrSeq = vndrSeq;
	}	
	
	public String getVerifySelect() {
		return verifySelect;
	}

	public void setVerifySelect(String verifySelect) {
		this.verifySelect = verifySelect;
	}
	
}
