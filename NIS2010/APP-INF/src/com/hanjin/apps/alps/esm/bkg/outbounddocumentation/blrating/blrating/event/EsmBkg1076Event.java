/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1076Event.java
*@FileTitle : Freight & Charge_TAA Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.27
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.12.27 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.TaaInformInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1076 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1076HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see ESM_BKG_1076HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1076Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	TaaInformInVO taaInformInVO = null;

	private String bkgNo = "";
	private String caflag = "";
	private String scpcd = "";
	private String cmdtcd = "";
	private String ctrtTpCd ="";
	private String rtAplyDt ="";
	private String fnlFrtAmt = "";
	private String rtAudTpCd = "";
	private String taaNo = "";
	private String frtTermCd = "";
	
	/** Table Value Object Multi Data 처리 */
	private TaaInformInVO[] taaInformInVOs = null;
	
	private SearchScOftAutoratingListVO[] searchScOftAutoratingListVOs = null;
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
	 * @return the taaNo
	 */
	public String gettaaNo() {
		return taaNo;
	}
	/**
	 * @param taaNo
	 */
	public void settaaNo(String taaNo) {
		this.taaNo = taaNo;
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
	 * @return the taaInformInVO
	 */
	public TaaInformInVO getTaaInformInVO() {
		return taaInformInVO;
	}

	/**
	 * @param taaInformInVO the taaInformInVO to set
	 */
	public void setTaaInformInVO(TaaInformInVO taaInformInVO) {
		this.taaInformInVO = taaInformInVO;
	}

	/**
	 * @return the taaInformInVOs
	 */
	public void setTaaInformInVOS(TaaInformInVO[] TaaInformInVOs){
		if(TaaInformInVOs != null){
			TaaInformInVO[] tmpVOs = Arrays.copyOf(TaaInformInVOs, TaaInformInVOs.length);
			this.taaInformInVOs = tmpVOs;
		}
	}

	/**
	 * @param taaInformInVOs the taaInformInVOs to set
	 */
	public TaaInformInVO[] getTaaInformInVOS(){
		TaaInformInVO[] rtnVOs = null;
		if (this.taaInformInVOs != null) {
			rtnVOs = Arrays.copyOf(taaInformInVOs, taaInformInVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param the SearchScOftAutoratingListVOs
	 */
	public void setSearchScOftAutoratingListVOS(SearchScOftAutoratingListVO[] SearchScOftAutoratingListVOs){
		if(SearchScOftAutoratingListVOs != null){
			SearchScOftAutoratingListVO[] tmpVOs = Arrays.copyOf(SearchScOftAutoratingListVOs, SearchScOftAutoratingListVOs.length);
			this.searchScOftAutoratingListVOs = tmpVOs;
		}
	}

	/**
	 * @return SearchScOftAutoratingListVOs
	 */
	public SearchScOftAutoratingListVO[] getSearchScOftAutoratingListVOS(){
		SearchScOftAutoratingListVO[] rtnVOs = null;
		if (this.searchScOftAutoratingListVOs != null) {
			rtnVOs = Arrays.copyOf(searchScOftAutoratingListVOs, searchScOftAutoratingListVOs.length);
		}
		return rtnVOs;
	}



}