/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EesDod0013Event.java
*@FileTitle : Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.04
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.11.04 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.vo.SearchDodDrpOffChgVO;


/**
 * EES_DOD_0013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DOD_0013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Son, Jin-Hwan
 * @see EES_DOD_0013HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDod0013Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SearchDodDrpOffChgVO searchDodDrpOffChgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	SearchDodDrpOffChgVO[] searchDodDrpOffChgVOs = null;

	/** BKG No. */
	private String bkgNo = "";
	
	/** CNTR No. */
	private String cntrNo = "";
	
	/** RTN CY */
	private String cntrRtnYdCd = "";
	
	/** 사후결재 진행을 위한 AUTH_APRO_RQST_NO */
	private String authAproRqstNo = "";
	
	/** Correction Popup을 호출한 부모 페이지 */
	private String opener = "";
	
	public EesDod0013Event(){}
	
	public void setSearchDodDrpOffChgVO(SearchDodDrpOffChgVO searchDodDrpOffChgVO){
		this. searchDodDrpOffChgVO = searchDodDrpOffChgVO;
	}

	public void setSearchDodDrpOffChgVOS(SearchDodDrpOffChgVO[] searchDodDrpOffChgVOs){
		if (searchDodDrpOffChgVOs != null) {
			SearchDodDrpOffChgVO[] tmpVOs = Arrays.copyOf(searchDodDrpOffChgVOs, searchDodDrpOffChgVOs .length);
			this. searchDodDrpOffChgVOs = tmpVOs;
		}
	}

	public SearchDodDrpOffChgVO getSearchDodDrpOffChgVO(){
		return searchDodDrpOffChgVO;
	}

	public SearchDodDrpOffChgVO[] getSearchDodDrpOffChgVOS(){
		SearchDodDrpOffChgVO[] tmpVOs = null;
		if (this. searchDodDrpOffChgVOs != null) {
			tmpVOs = Arrays.copyOf(searchDodDrpOffChgVOs, searchDodDrpOffChgVOs .length);
		}
		return tmpVOs;
	}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getCntrNo() {
		return cntrNo;
	}

	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	public String getCntrRtnYdCd() {
		return cntrRtnYdCd;
	}

	public void setCntrRtnYdCd(String cntrRtnYdCd) {
		this.cntrRtnYdCd = cntrRtnYdCd;
	}
	
	public String getAuthAproRqstNo() {
		return authAproRqstNo;
	}

	public void setAuthAproRqstNo(String authAproRqstNo) {
		this.authAproRqstNo = authAproRqstNo;
	}

	public String getOpener() {
		return opener;
	}

	public void setOpener(String opener) {
		this.opener = opener;
	}
	
}