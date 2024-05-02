/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0441Event.java
*@FileTitle : Doc Center Office Hour
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.21
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.05.25 김태경
* 1.0 Creation
* 2011.10.21 조원주 [CHM-201113594-01] DPCS-SI Turn Time레포트 및 Draft B/L전송후 Amendment S/I PIC변경관련 Doc Center Office Hour 개발
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgDpcsOfcTmVO;


/**
 * ESM_BKG_0441 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0441HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author tae kyoung kim
 * @see ESM_BKG_0441HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0441Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String bkgOfcCd = null;
	private String dpcsWrkGrpCd = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgDpcsOfcTmVO bkgDpcsOfcTmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgDpcsOfcTmVO[] bkgDpcsOfcTmVOs = null;

	public EsmBkg0441Event(){}
	
	/**
	 * @return the bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return bkgOfcCd;
	}
	/**
	 * @param bkgOfcCd the bkgOfcCd to set
	 */
	public void setBkgOfcCd(String bkg_ofc_cd) {
		this.bkgOfcCd = bkg_ofc_cd;
	}
	
	/**
	 * @return the dpcsWrkGrpCd
	 */
	public String getDpcsWrkGrpCd() {
		return dpcsWrkGrpCd;
	}
	/**
	 * @param dpcsWrkGrpCd the dpcsWrkGrpCd to set
	 */
	public void setDpcsWrkGrpCd(String dpcs_wrk_grp_cd) {
		this.dpcsWrkGrpCd = dpcs_wrk_grp_cd;
	}
	
	public void setBkgDpcsOfcTmVO(BkgDpcsOfcTmVO bkgDpcsOfcTmVO){
		this. bkgDpcsOfcTmVO = bkgDpcsOfcTmVO;
	}

	public void setBkgDpcsOfcTmVOS(BkgDpcsOfcTmVO[] bkgDpcsOfcTmVOs){
		if(bkgDpcsOfcTmVOs != null){
			BkgDpcsOfcTmVO[] tmpVOs = Arrays.copyOf(bkgDpcsOfcTmVOs, bkgDpcsOfcTmVOs.length);
			this.bkgDpcsOfcTmVOs = tmpVOs;
		}
	}

	public BkgDpcsOfcTmVO getBkgDpcsOfcTmVO(){
		return bkgDpcsOfcTmVO;
	}

	public BkgDpcsOfcTmVO[] getBkgDpcsOfcTmVOS(){
		BkgDpcsOfcTmVO[] rtnVOs = null;
		if (this.bkgDpcsOfcTmVOs != null) {
			rtnVOs = Arrays.copyOf(bkgDpcsOfcTmVOs, bkgDpcsOfcTmVOs.length);
		}
		return rtnVOs;
	}

}