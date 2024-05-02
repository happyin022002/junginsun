/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaManifestTransmitVO.java
*@FileTitle : ChinaManifestTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo.RussiaManifestListDetailVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;

/**
 * Container Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Container VO
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RussiaManifestTransmitVO extends ManifestTransmitVO {

	private static final long serialVersionUID = 1L;
	
	private RussiaManifestListDetailVO[] russiaManifestListDetailVOs = null;
	public RussiaManifestListDetailVO[] getRussiaManifestListDetailVOs() {
		return russiaManifestListDetailVOs;
	}
	public void setRussiaManifestListDetailVOs(
			RussiaManifestListDetailVO[] russiaManifestListDetailVOs) {
		this.russiaManifestListDetailVOs = russiaManifestListDetailVOs;
	}
	private RussiaBlInfoListVO[] russiaBlInfoListVOs = null;
	private TransKeyVO transKeyVO = null;
	private List<BkgNtcHisVO> bkgNtcHisVOs = null;
	private String ediRefId = null;
	
	/**
	 * @return the chinaBlInfoListVOs
	 */
	public RussiaBlInfoListVO[] getRussiaBlInfoListVOs() {
		return russiaBlInfoListVOs;
	}
	/**
	 * @param russiaBlInfoListVOs the russiaBlInfoListVOs to set
	 */
	public void setRussiaBlInfoListVOs(RussiaBlInfoListVO[] russiaBlInfoListVOs) {
		this.russiaBlInfoListVOs = russiaBlInfoListVOs;
	}
	/**
	 * @return the transKeyVO
	 */
	public TransKeyVO getTransKeyVO() {
		return transKeyVO;
	}
	/**
	 * @param transKeyVO the transKeyVO to set
	 */
	public void setTransKeyVO(TransKeyVO transKeyVO) {
		this.transKeyVO = transKeyVO;
	}
	/**
	 * @return the bkgNtcHisVOs
	 */
	public List<BkgNtcHisVO> getBkgNtcHisVOs() {
		return bkgNtcHisVOs;
	}
	/**
	 * @param bkgNtcHisVOs the bkgNtcHisVOs to set
	 */
	public void setBkgNtcHisVOs(List<BkgNtcHisVO> bkgNtcHisVOs) {
		this.bkgNtcHisVOs = bkgNtcHisVOs;
	}
	/**
	 * @return the ediRefId
	 */
	public String getEdiRefId() {
		return ediRefId;
	}
	/**
	 * @param ediRefId the ediRefId to set
	 */
	public void setEdiRefId(String ediRefId) {
		this.ediRefId = ediRefId;
	}
	
}
