/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0034Event.java
 *@FileTitle : B/L INQUIRY_Customs Result
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.05.04 이수빈
 * 1.0 Creation
 * -----------------------------------------------------
 * History
 * 2012.05.10 김보배 [CHM-201217461] [BKG] [ACE M1] US AMS 전송후 1J 이후 Diversion 요청 기능 추가
 * 2012.06.11 김보배 [CHM-201218037] [BKG] [ACE M1] US AMS Client Authority Set up 컬럼 추가 
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaAiBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlCustVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlCustomerSecondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlRemarkVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestSearchDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.DispoCdListCondVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Lee Subin
 * @see ESM_BKG_0034HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0034Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 처리 */
	private String blNo = null;
	private String divCd = null;
	private String blCstms = null;

	private BlCondVO blCondVO = null;
	private BlDetailVO blDetailVO = null;
	private DispoCdListCondVO dispoCdListCondVO = null;

	private UsaAiBlInfoVO usaAiBlInfoVO = null;
	private UsaBlCustVO usaBlCustVO = null;
	private UsaBlCustomerSecondVO usaBlCustomerSecondVO = null;
	private UsaBlRemarkVO usaBlRemarkVO = null;

	private UsaAiBlInfoVO[] usaAiBlInfoVOs = null;
	private UsaBlCustVO[] usaBlCustVOs = null;
	private UsaBlCustomerSecondVO[] usaBlCustomerSecondVOs = null;
	private UsaBlRemarkVO[] usaBlRemarkVOs = null;

	private UsaAiBlInfoVO[] oldAiBlInfoVOs = null;
	private UsaBlCustVO[] oldBlCustVOs = null;
	private UsaBlCustomerSecondVO[] oldBlCustomerSecondVOs = null;
	private UsaBlRemarkVO[] oldBlRemarkVOs = null;

	/** Transmit AI Value Object */
	private UsaManifestSearchDetailVO[] usaManifestSearchDetailVOS = null;

	public EsmBkg0034Event() {
	}

	public String getBlNo() {
		return blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	public String getDivCd() {
		return divCd;
	}

	public void setDivCd(String divCd) {
		this.divCd = divCd;
	}

	public String getBlCstms() {
		return blCstms;
	}

	public void setBlCstms(String blCstms) {
		this.blCstms = blCstms;
	}

	public BlCondVO getBlCondVO() {
		return blCondVO;
	}

	public void setBlCondVO(BlCondVO blCondVO) {
		this.blCondVO = blCondVO;
	}

	public BlDetailVO getBlDetailVO() {
		return blDetailVO;
	}

	public void setBlDetailVO(BlDetailVO blDetailVO) {
		this.blDetailVO = blDetailVO;
	}

	/**
	 * @return the dispoCdListCondVO
	 */
	public DispoCdListCondVO getDispoCdListCondVO() {
		return dispoCdListCondVO;
	}

	/**
	 * @param dispoCdListCondVO
	 *            the dispoCdListCondVO to set
	 */
	public void setDispoCdListCondVO(DispoCdListCondVO dispoCdListCondVO) {
		this.dispoCdListCondVO = dispoCdListCondVO;
	}

	public UsaAiBlInfoVO getUsaAiBlInfoVO() {
		return usaAiBlInfoVO;
	}

	public void setUsaAiBlInfoVO(UsaAiBlInfoVO usaAiBlInfoVO) {
		this.usaAiBlInfoVO = usaAiBlInfoVO;
	}

	public UsaBlCustVO getUsaBlCustVO() {
		return usaBlCustVO;
	}

	public void setUsaBlCustVO(UsaBlCustVO usaBlCustVO) {
		this.usaBlCustVO = usaBlCustVO;
	}

	public UsaBlCustomerSecondVO getUsaBlCustomerSecondVO() {
		return usaBlCustomerSecondVO;
	}

	public void setUsaBlCustomerSecondVO(UsaBlCustomerSecondVO usaBlCustomerSecondVO) {
		this.usaBlCustomerSecondVO = usaBlCustomerSecondVO;
	}

	public UsaAiBlInfoVO[] getUsaAiBlInfoVOs() {
		UsaAiBlInfoVO[] rtnVOs = null;
		if (usaAiBlInfoVOs != null)
			rtnVOs = Arrays.copyOf(usaAiBlInfoVOs, usaAiBlInfoVOs.length);
		return rtnVOs;
	}

	public void setUsaAiBlInfoVOs(UsaAiBlInfoVO[] usaAiBlInfoVOs) {
		if (usaAiBlInfoVOs != null)
			this.usaAiBlInfoVOs = Arrays.copyOf(usaAiBlInfoVOs, usaAiBlInfoVOs.length);
	}

	public UsaBlCustVO[] getUsaBlCustVOs() {
		UsaBlCustVO[] rtnVOs = null;
		if (usaBlCustVOs != null)
			rtnVOs = Arrays.copyOf(usaBlCustVOs, usaBlCustVOs.length);
		return rtnVOs;
	}

	public void setUsaBlCustVOs(UsaBlCustVO[] usaBlCustVOs) {
		if (usaBlCustVOs != null)
			this.usaBlCustVOs = Arrays.copyOf(usaBlCustVOs, usaBlCustVOs.length);
	}

	public UsaBlCustomerSecondVO[] getUsaBlCustomerSecondVOs() {
		UsaBlCustomerSecondVO[] rtnVOs = null;
		if (usaBlCustomerSecondVOs != null)
			rtnVOs = Arrays.copyOf(usaBlCustomerSecondVOs, usaBlCustomerSecondVOs.length);
		return rtnVOs;
	}

	public void setUsaBlCustomerSecondVOs(UsaBlCustomerSecondVO[] usaBlCustomerSecondVOs) {
		if (usaBlCustomerSecondVOs != null)
			this.usaBlCustomerSecondVOs = Arrays.copyOf(usaBlCustomerSecondVOs, usaBlCustomerSecondVOs.length);
	}

	public UsaBlRemarkVO[] getUsaBlRemarkVOs() {
		UsaBlRemarkVO[] rtnVOs = null;
		if (usaBlRemarkVOs != null)
			rtnVOs = Arrays.copyOf(usaBlRemarkVOs, usaBlRemarkVOs.length);
		return rtnVOs;
	}

	public void setUsaBlRemarkVOs(UsaBlRemarkVO[] usaBlRemarkVOs) {
		if (usaBlRemarkVOs != null)
			this.usaBlRemarkVOs = Arrays.copyOf(usaBlRemarkVOs, usaBlRemarkVOs.length);
	}

	public UsaBlRemarkVO getUsaBlRemarkVO() {
		return usaBlRemarkVO;
	}

	public void setUsaBlRemarkVO(UsaBlRemarkVO usaBlRemarkVO) {
		this.usaBlRemarkVO = usaBlRemarkVO;
	}

	public UsaAiBlInfoVO[] getOldAiBlInfoVOs() {
		UsaAiBlInfoVO[] rtnVOs = null;
		if (oldAiBlInfoVOs != null)
			rtnVOs = Arrays.copyOf(oldAiBlInfoVOs, oldAiBlInfoVOs.length);
		return rtnVOs;
	}

	public void setOldAiBlInfoVOs(UsaAiBlInfoVO[] oldAiBlInfoVOs) {
		if (oldAiBlInfoVOs != null)
			this.oldAiBlInfoVOs = Arrays.copyOf(oldAiBlInfoVOs, oldAiBlInfoVOs.length);
	}

	public UsaBlCustVO[] getOldBlCustVOs() {
		UsaBlCustVO[] rtnVOs = null;
		if (oldBlCustVOs != null)
			rtnVOs = Arrays.copyOf(oldBlCustVOs, oldBlCustVOs.length);
		return rtnVOs;
	}

	public void setOldBlCustVOs(UsaBlCustVO[] oldBlCustVOs) {
		if (oldBlCustVOs != null)
			this.oldBlCustVOs = Arrays.copyOf(oldBlCustVOs, oldBlCustVOs.length);
	}

	public UsaBlCustomerSecondVO[] getOldBlCustomerSecondVOs() {
		UsaBlCustomerSecondVO[] rtnVOs = null;
		if (oldBlCustomerSecondVOs != null)
			rtnVOs = Arrays.copyOf(oldBlCustomerSecondVOs, oldBlCustomerSecondVOs.length);
		return rtnVOs;
	}

	public void setOldBlCustomerSecondVOs(UsaBlCustomerSecondVO[] oldBlCustomerSecondVOs) {
		if (oldBlCustomerSecondVOs != null)
			this.oldBlCustomerSecondVOs = Arrays.copyOf(oldBlCustomerSecondVOs, oldBlCustomerSecondVOs.length);
	}

	public UsaBlRemarkVO[] getOldBlRemarkVOs() {
		UsaBlRemarkVO[] rtnVOs = null;
		if (oldBlRemarkVOs != null)
			rtnVOs = Arrays.copyOf(oldBlRemarkVOs, oldBlRemarkVOs.length);
		return rtnVOs;
	}

	public void setOldBlRemarkVOs(UsaBlRemarkVO[] oldBlRemarkVOs) {
		if (oldBlRemarkVOs != null)
			this.oldBlRemarkVOs = Arrays.copyOf(oldBlRemarkVOs, oldBlRemarkVOs.length);
	}

	public UsaManifestSearchDetailVO[] getUsaManifestSearchDetailVOS() {
		UsaManifestSearchDetailVO[] rtnVOs = null;
		if (usaManifestSearchDetailVOS != null)
			rtnVOs = Arrays.copyOf(usaManifestSearchDetailVOS, usaManifestSearchDetailVOS.length);
		return rtnVOs;
	}

	public void setUsaManifestSearchDetailVOS(UsaManifestSearchDetailVO[] usaManifestSearchDetailVOS) {
		if (usaManifestSearchDetailVOS != null)
			this.usaManifestSearchDetailVOS = Arrays.copyOf(usaManifestSearchDetailVOS, usaManifestSearchDetailVOS.length);
	}

}