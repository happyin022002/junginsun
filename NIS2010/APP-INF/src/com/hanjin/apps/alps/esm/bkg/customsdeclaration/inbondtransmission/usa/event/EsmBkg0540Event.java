/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0540Event.java
*@FileTitle : Entry Type Set-Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.08.19 이수빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.event;

import java.util.Arrays;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondManifestDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondManifestListCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0540 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0540HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Subin
 * @see ESM_BKG_0540HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0540Event extends EventSupport {

    private static final long serialVersionUID = 1L;
    
    private String strCustCntCd = null;
    private String strCustSeq = null;
    private String strCmdtCd = null;
    private String strLocCd = null;

    /** 조회 조건 및 단건 처리  */
    private InbondManifestListCondVO inbondManifestListCondVO = null;

    /** 저장 처리 */
    private InbondManifestDetailVO[] inbondManifestDetailVOs = null;


    public EsmBkg0540Event(){}



	/**
	 * @return the strCustCntCd
	 */
	public String getStrCustCntCd() {
		return strCustCntCd;
	}



	/**
	 * @param strCustCntCd the strCustCntCd to set
	 */
	public void setStrCustCntCd(String strCustCntCd) {
		this.strCustCntCd = strCustCntCd;
	}



	/**
	 * @return the strCustSeq
	 */
	public String getStrCustSeq() {
		return strCustSeq;
	}



	/**
	 * @param strCustSeq the strCustSeq to set
	 */
	public void setStrCustSeq(String strCustSeq) {
		this.strCustSeq = strCustSeq;
	}



	/**
	 * @return the strCmdtCd
	 */
	public String getStrCmdtCd() {
		return strCmdtCd;
	}


	/**
	 * @param strCmdtCd the strCmdtCd to set
	 */
	public void setStrCmdtCd(String strCmdtCd) {
		this.strCmdtCd = strCmdtCd;
	}


	/**
	 * @return the strLocCd
	 */
	public String getStrLocCd() {
		return strLocCd;
	}



	/**
	 * @param strLocCd the strLocCd to set
	 */
	public void setStrLocCd(String strLocCd) {
		this.strLocCd = strLocCd;
	}



	/**
	 * @return the inbondManifestListCondVO
	 */
	public InbondManifestListCondVO getInbondManifestListCondVO() {
		return inbondManifestListCondVO;
	}


	/**
	 * @param inbondManifestListCondVO the inbondManifestListCondVO to set
	 */
	public void setInbondManifestListCondVO(
			InbondManifestListCondVO inbondManifestListCondVO) {
		this.inbondManifestListCondVO = inbondManifestListCondVO;
	}


	/**
	 * @return the inbondManifestDetailVOs
	 */
	public InbondManifestDetailVO[] getInbondManifestDetailVOs() {
		InbondManifestDetailVO[] rtnVOs = null;
		if (this.inbondManifestDetailVOs != null) {
			rtnVOs = Arrays.copyOf(inbondManifestDetailVOs, inbondManifestDetailVOs.length);
		}
		return rtnVOs;
	}


	/**
	 * @param inbondManifestDetailVOs the inbondManifestDetailVOs to set
	 */
	public void setInbondManifestDetailVOs(InbondManifestDetailVO[] inbondManifestDetailVOs){
		if(inbondManifestDetailVOs != null){
			InbondManifestDetailVO[] tmpVOs = Arrays.copyOf(inbondManifestDetailVOs, inbondManifestDetailVOs.length);
			this.inbondManifestDetailVOs = tmpVOs;
		}
	}


}