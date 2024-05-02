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
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event;

import java.util.Arrays;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaAiBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlCustVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlCustomerSecondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlRemarkVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestSearchDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.DispoCdListCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Subin
 * @see ESM_BKG_0034HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0034Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 처리  */
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
	
	public EsmBkg0034Event(){}
	

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
	 * @param dispoCdListCondVO the dispoCdListCondVO to set
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
		if (this.usaAiBlInfoVOs != null) {
			rtnVOs = Arrays.copyOf(usaAiBlInfoVOs, usaAiBlInfoVOs.length);
		}
		return rtnVOs;
	}


	public void setUsaAiBlInfoVOs(UsaAiBlInfoVO[] usaAiBlInfoVOs){
		if(usaAiBlInfoVOs != null){
			UsaAiBlInfoVO[] tmpVOs = Arrays.copyOf(usaAiBlInfoVOs, usaAiBlInfoVOs.length);
			this.usaAiBlInfoVOs = tmpVOs;
		}
	}


	public UsaBlCustVO[] getUsaBlCustVOs() {
		UsaBlCustVO[] rtnVOs = null;
		if (this.usaBlCustVOs != null) {
			rtnVOs = Arrays.copyOf(usaBlCustVOs, usaBlCustVOs.length);
		}
		return rtnVOs;
	}


	public void setUsaBlCustVOs(UsaBlCustVO[] usaBlCustVOs){
		if(usaBlCustVOs != null){
			UsaBlCustVO[] tmpVOs = Arrays.copyOf(usaBlCustVOs, usaBlCustVOs.length);
			this.usaBlCustVOs = tmpVOs;
		}
	}


	public UsaBlCustomerSecondVO[] getUsaBlCustomerSecondVOs() {
		UsaBlCustomerSecondVO[] rtnVOs = null;
		if (this.usaBlCustomerSecondVOs != null) {
			rtnVOs = Arrays.copyOf(usaBlCustomerSecondVOs, usaBlCustomerSecondVOs.length);
		}
		return rtnVOs;
	}


	public void setUsaBlCustomerSecondVOs(UsaBlCustomerSecondVO[] usaBlCustomerSecondVOs){
		if(usaBlCustomerSecondVOs != null){
			UsaBlCustomerSecondVO[] tmpVOs = Arrays.copyOf(usaBlCustomerSecondVOs, usaBlCustomerSecondVOs.length);
			this.usaBlCustomerSecondVOs = tmpVOs;
		}
	}


	public UsaBlRemarkVO[] getUsaBlRemarkVOs() {
		UsaBlRemarkVO[] rtnVOs = null;
		if (this.usaBlRemarkVOs != null) {
			rtnVOs = Arrays.copyOf(usaBlRemarkVOs, usaBlRemarkVOs.length);
		}
		return rtnVOs;
	}


	public void setUsaBlRemarkVOs(UsaBlRemarkVO[] usaBlRemarkVOs){
		if(usaBlRemarkVOs != null){
			UsaBlRemarkVO[] tmpVOs = Arrays.copyOf(usaBlRemarkVOs, usaBlRemarkVOs.length);
			this.usaBlRemarkVOs = tmpVOs;
		}
	}


	public UsaBlRemarkVO getUsaBlRemarkVO() {
		return usaBlRemarkVO;
	}


	public void setUsaBlRemarkVO(UsaBlRemarkVO usaBlRemarkVO) {
		this.usaBlRemarkVO = usaBlRemarkVO;
	}


	public UsaAiBlInfoVO[] getOldAiBlInfoVOs() {
		UsaAiBlInfoVO[] rtnVOs = null;
		if (this.oldAiBlInfoVOs != null) {
			rtnVOs = Arrays.copyOf(oldAiBlInfoVOs, oldAiBlInfoVOs.length);
		}
		return rtnVOs;
	}


	public void setOldAiBlInfoVOs(UsaAiBlInfoVO[] oldAiBlInfoVOs){
		if(oldAiBlInfoVOs != null){
			UsaAiBlInfoVO[] tmpVOs = Arrays.copyOf(oldAiBlInfoVOs, oldAiBlInfoVOs.length);
			this.oldAiBlInfoVOs = tmpVOs;
		}
	}


	public UsaBlCustVO[] getOldBlCustVOs() {
		UsaBlCustVO[] rtnVOs = null;
		if (this.oldBlCustVOs != null) {
			rtnVOs = Arrays.copyOf(oldBlCustVOs, oldBlCustVOs.length);
		}
		return rtnVOs;
	}


	public void setOldBlCustVOs(UsaBlCustVO[] oldBlCustVOs){
		if(oldBlCustVOs != null){
			UsaBlCustVO[] tmpVOs = Arrays.copyOf(oldBlCustVOs, oldBlCustVOs.length);
			this.oldBlCustVOs = tmpVOs;
		}
	}


	public UsaBlCustomerSecondVO[] getOldBlCustomerSecondVOs() {
		UsaBlCustomerSecondVO[] rtnVOs = null;
		if (this.oldBlCustomerSecondVOs != null) {
			rtnVOs = Arrays.copyOf(oldBlCustomerSecondVOs, oldBlCustomerSecondVOs.length);
		}
		return rtnVOs;
	}


	public void setOldBlCustomerSecondVOs(UsaBlCustomerSecondVO[] oldBlCustomerSecondVOs){
		if(oldBlCustomerSecondVOs != null){
			UsaBlCustomerSecondVO[] tmpVOs = Arrays.copyOf(oldBlCustomerSecondVOs, oldBlCustomerSecondVOs.length);
			this.oldBlCustomerSecondVOs = tmpVOs;
		}
	}


	public UsaBlRemarkVO[] getOldBlRemarkVOs() {
		UsaBlRemarkVO[] rtnVOs = null;
		if (this.oldBlRemarkVOs != null) {
			rtnVOs = Arrays.copyOf(oldBlRemarkVOs, oldBlRemarkVOs.length);
		}
		return rtnVOs;
	}


	public void setOldBlRemarkVOs(UsaBlRemarkVO[] oldBlRemarkVOs){
		if(oldBlRemarkVOs != null){
			UsaBlRemarkVO[] tmpVOs = Arrays.copyOf(oldBlRemarkVOs, oldBlRemarkVOs.length);
			this.oldBlRemarkVOs = tmpVOs;
		}
	}


	public UsaManifestSearchDetailVO[] getUsaManifestSearchDetailVOS() {
		UsaManifestSearchDetailVO[] rtnVOs = null;
		if (this.usaManifestSearchDetailVOS != null) {
			rtnVOs = Arrays.copyOf(usaManifestSearchDetailVOS, usaManifestSearchDetailVOS.length);
		}
		return rtnVOs;
	}


	public void setUsaManifestSearchDetailVOS(UsaManifestSearchDetailVO[] usaManifestSearchDetailVOS){
		if(usaManifestSearchDetailVOS != null){
			UsaManifestSearchDetailVO[] tmpVOs = Arrays.copyOf(usaManifestSearchDetailVOS, usaManifestSearchDetailVOS.length);
			this.usaManifestSearchDetailVOS = tmpVOs;
		}
	}

}