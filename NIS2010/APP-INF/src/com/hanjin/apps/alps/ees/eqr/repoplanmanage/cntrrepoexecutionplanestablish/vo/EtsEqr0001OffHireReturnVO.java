/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EtsEqr0001OffHireReturnVO.java
*@FileTitle : ETS <-> EQR 직반납
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.10.21 정은호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo;


/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정은호
 * @since J2EE 1.6
 */

public class EtsEqr0001OffHireReturnVO {

	
	/* Column Info */
	private String repoPlnId = null;
	/* Column Info */
	private String chdToYdCd = null;
	/* Column Info */
	private String cntrNo	= null;
	/* Column Info */
	private String refSeq	= null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String refId = null;
	/* Column Info */
	private String chdCntrQty = null;
	/* Column Info */
	private String plnYrwk = null;
	/* Column Info */
	private String trspSoStsCd = null;
	
	
	public EtsEqr0001OffHireReturnVO() {}

	
	/**
	 * Column Info
	 * @return repoPlnId
	 */
	public String getRepoPlnId() {
		return this.repoPlnId;
	}
	
	/**
	 * Column Info
	 * @return chdToYdCd
	 */
	public String getChdToYdCd() {
		return this.chdToYdCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 * 사용하지 않음
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return refId
	 */
	public String getRefId() {
		return this.refId;
	}
	
	/**
	 * Column Info
	 * @return chdCntrQty
	 */
	public String getChdCntrQty() {
		return this.chdCntrQty;
	}
	
	/**
	 * Column Info
	 * @return plnYrwk
	 */
	public String getPlnYrwk() {
		return this.plnYrwk;
	}
	
	/**
	 * Column Info
	 * @return trspSoStsCd
	 */
	public String getTrspSoStsCd() {
		return this.trspSoStsCd;
	}
	

	/**
	 * Column Info
	 * @return refSeq
	 */

	public String getRefSeq() {
		return refSeq;
	}

	/**
	 * Column Info
	 * @param repoPlnId
	 */
	public void setRepoPlnId(String repoPlnId) {
		this.repoPlnId = repoPlnId;
	}
	

	/**
	 * Column Info
	 * @param chdToYdCd
	 */
	public void setChdToYdCd(String chdToYdCd) {
		this.chdToYdCd = chdToYdCd;
	}

	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param refId
	 */
	public void setRefId(String refId) {
		this.refId = refId;
	}
	
	/**
	 * Column Info
	 * @param chdCntrQty
	 */
	public void setChdCntrQty(String chdCntrQty) {
		this.chdCntrQty = chdCntrQty;
	}
	
	/**
	 * Column Info
	 * @param plnYrwk
	 */
	public void setPlnYrwk(String plnYrwk) {
		this.plnYrwk = plnYrwk;
	}
	
	/**
	 * Column Info
	 * @param trspSoStsCd
	 */
	public void setTrspSoStsCd(String trspSoStsCd) {
		this.trspSoStsCd = trspSoStsCd;
	}

	/**
	 * Column Info
	 * @param refSeq
	 */
	public void setRefSeq(String refSeq) {
		this.refSeq = refSeq;
	}
	
	
	
}
