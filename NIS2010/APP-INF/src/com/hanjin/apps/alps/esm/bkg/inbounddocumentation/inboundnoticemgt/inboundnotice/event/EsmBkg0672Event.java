/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0672Event.java
*@FileTitle : Arrival Notice Code Validation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2009.06.03 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustUploadListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcInfoListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdEvaluationVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgArrNtcVO;

/**
 * esm_bkg_0672 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0672HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Mangeon
 * @see ESM_BKG_0672HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0672Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private ArrNtcSearchVO arrNtcSearchVO = null;
	private ArrNtcInfoListVO[] arrNtcInfos = null;
	private BkgArrNtcVO[] vos = null;
	private String key = "";
	


	public ArrNtcInfoListVO[] getArrNtcInfos() {
		return arrNtcInfos;
	}


	public void setArrNtcInfos(ArrNtcInfoListVO[] arrNtcInfos) {
		this.arrNtcInfos = arrNtcInfos;
	}


	public BkgArrNtcVO[] getVos() {
		return vos;
	}


	public void setVos(BkgArrNtcVO[] vos) {
		this.vos = vos;
	}

	private CustCdEvaluationVO[] custCdEvaluationVO = null;
	private ArrNtcCustUploadListVO[] arrNtcCustUploadListVOS = null; 
	
	//[672-02] 조회용
	private ArrNtcCustListVO[] arrNtcCustListVOS = null;


	public EsmBkg0672Event(){}


	public ArrNtcSearchVO getArrNtcSearchVO() {
		return arrNtcSearchVO;
	}


	public void setArrNtcSearchVO(ArrNtcSearchVO arrNtcSearchVO) {
		this.arrNtcSearchVO = arrNtcSearchVO;
	}



	public CustCdEvaluationVO[] getCustCdEvaluationVO() {
		return custCdEvaluationVO;
	}


	public void setCustCdEvaluationVO(CustCdEvaluationVO[] custCdEvaluationVO) {
		this.custCdEvaluationVO = custCdEvaluationVO;
	}




	/**
	 * 
	 * @return
	 */
	public ArrNtcCustListVO[] getArrNtcCustListVOS() {
		return arrNtcCustListVOS;
	}

	/**
	 * 
	 * @param arrNtcCustListVOS
	 */
	public void setArrNtcCustListVOS(ArrNtcCustListVO[] arrNtcCustListVOS) {
		this.arrNtcCustListVOS = arrNtcCustListVOS;
	}

/**
 * 
 * @return
 */
	public ArrNtcCustUploadListVO[] getArrNtcCustUploadListVOS() {
		// TODO Auto-generated method stub
		return arrNtcCustUploadListVOS;
	}

/**
 * 
 * @param arrNtcCustUploadListVOS
 */
	public void setArrNtcCustUploadListVOS(ArrNtcCustUploadListVO[] arrNtcCustUploadListVOS) {
		this.arrNtcCustUploadListVOS = arrNtcCustUploadListVOS;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	public String getKey() {
		return key;
	}	
	
	
}