/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0269Event.java
*@FileTitle : Freight & Charge_S/C Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.26 이진서
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScInformInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0269 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0269HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see ESM_BKG_0269HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0269Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	ScInformInVO scInformInVO =null;

	private String bkgNo = "";
	private String caflag = "";
	private String scpcd = "";
	private String cmdtcd = "";
	private String ctrtTpCd ="";
	private String rtAplyDt ="";
	private String fnlFrtAmt = "";
	private String rtAudTpCd = "";
	private String scNo = "";
	private String frtTermCd = "";
	
	/** Table Value Object Multi Data 처리 */
	private ScInformInVO[] scInformInVOS = null;
	
	private SearchScOftAutoratingListVO[] searchScOftAutoratingListVOS = null;
	/**
	 * @return the bkg_no
	 */
	public String getBkg_no() {
		return bkgNo;
	}

	/**
	 * @param bkg_no the bkg_no to set
	 */
	public void setBkg_no(String bkg_no) {
		this.bkgNo = bkg_no;
	}

	/**
	 * @return the caflag
	 */
	public String getCaflag() {
		return caflag;
	}

	/**
	 * @param caflag the caflag to set
	 */
	public void setCaflag(String caflag) {
		this.caflag = caflag;
	}

	/**
	 * @return the scpcd
	 */
	public String getScpcd() {
		return scpcd;
	}

	/**
	 * @param scpcd the scpcd to set
	 */
	public void setScpcd(String scpcd) {
		this.scpcd = scpcd;
	}

	/**
	 * @return the cmdtcd
	 */
	public String getCmdtcd() {
		return cmdtcd;
	}

	/**
	 * @param cmdtcd the cmdtcd to set
	 */
	public void setCmdtcd(String cmdtcd) {
		this.cmdtcd = cmdtcd;
	}
	
	/**
	 * @return the ctrtTpCd
	 */
	public String getctrtTpCd() {
		return ctrtTpCd;
	}
	/**
	 * @return the rtAudTpCd
	 */
	public String getRtAudTpCd() {
		return rtAudTpCd;
	}
	
	/**
	 * @param rtAudTpCd
	 */
	public void setRtAudTpCd(String rtAudTpCd) {
		this.rtAudTpCd = rtAudTpCd;
	}
	
	/**
	 * @param ctrtTpCd the ctrtTpCd to set
	 */
	public void setctrtTpCd(String ctrtTpCd) {
		this.ctrtTpCd = ctrtTpCd;
	}
	
	/**
	 * @return the rtAplyDt
	 */
	public String getrtAplyDt() {
		return rtAplyDt;
	}
	
	/**
	 * @return the fnlFrtAmt
	 */
	public String getfnlFrtAmt() {
		return fnlFrtAmt;
	}
	/**
	 * @param rtAplyDt
	 */
	public void setrtAplyDt(String rtAplyDt) {
		this.rtAplyDt = rtAplyDt;
	}
	/**
	 * @param fnlFrtAmt
	 */
	public void setfnlFrtAmt(String fnlFrtAmt) {
		this.fnlFrtAmt = fnlFrtAmt;
	}
	
	/**
	 * @return the scNo
	 */
	public String getscNo() {
		return scNo;
	}
	/**
	 * @param scNo
	 */
	public void setscNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * @return the frtTermCd
	 */
	public String getfrtTermCd() {
		return frtTermCd;
	}
	/**
	 * @param frtTermCd
	 */
	public void setfrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
	}
	
	
	
	
	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * @return the scInformInVO
	 */
	public ScInformInVO getScInformInVO() {
		return scInformInVO;
	}

	/**
	 * @param scInformInVO the scInformInVO to set
	 */
	public void setScInformInVO(ScInformInVO scInformInVO) {
		this.scInformInVO = scInformInVO;
	}
	
	public ScInformInVO[] getScInformInVOS() {
		ScInformInVO[] rtnVOs = null;
		if (this.scInformInVOS != null) {
			rtnVOs = Arrays.copyOf(scInformInVOS, scInformInVOS.length);
		}
		return rtnVOs;
	}

	public void setScInformInVOS(ScInformInVO[] scInformInVOS) {
		if (scInformInVOS != null) {
			ScInformInVO[] tmpVOs = Arrays.copyOf(scInformInVOS, scInformInVOS.length);
			this.scInformInVOS = tmpVOs;
		}
	}

	public SearchScOftAutoratingListVO[] getSearchScOftAutoratingListVOS() {
		SearchScOftAutoratingListVO[] rtnVOs = null;
		if (this.searchScOftAutoratingListVOS != null) {
			rtnVOs = Arrays.copyOf(searchScOftAutoratingListVOS,searchScOftAutoratingListVOS.length);
		}
		return rtnVOs;
	}

	public void setSearchScOftAutoratingListVOS(SearchScOftAutoratingListVO[] searchScOftAutoratingListVOS) {
		if (searchScOftAutoratingListVOS != null) {
			SearchScOftAutoratingListVO[] tmpVOs = Arrays.copyOf(searchScOftAutoratingListVOS,searchScOftAutoratingListVOS.length);
			this.searchScOftAutoratingListVOS = tmpVOs;
		}
	}




}