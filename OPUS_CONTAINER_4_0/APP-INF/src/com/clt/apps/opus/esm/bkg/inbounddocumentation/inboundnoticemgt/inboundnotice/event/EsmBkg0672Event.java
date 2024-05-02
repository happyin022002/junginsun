/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0672Event.java
*@FileTitle : Arrival Notice Code Validation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustUploadListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcInfoListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdEvaluationVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgArrNtcVO;

/**
 * esm_bkg_0672 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0672HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0672HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0672Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private ArrNtcSearchVO arrNtcSearchVO = null;
	private ArrNtcInfoListVO[] arrNtcInfos = null;
	private BkgArrNtcVO[] vos = null;
	
//	public ArrNtcInfoListVO[] getArrNtcInfos() {
//		return arrNtcInfos;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public ArrNtcInfoListVO[] getArrNtcInfos() {
		ArrNtcInfoListVO[] tmpVOs = null;
		if (this.arrNtcInfos != null) {
			tmpVOs = new ArrNtcInfoListVO[arrNtcInfos.length];
			System.arraycopy(arrNtcInfos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}

//	public void setArrNtcInfos(ArrNtcInfoListVO[] arrNtcInfos) {
//		this.arrNtcInfos = arrNtcInfos;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setArrNtcInfos(ArrNtcInfoListVO[] arrNtcInfos) {
		if (arrNtcInfos != null) {
			ArrNtcInfoListVO[] tmpVOs = new ArrNtcInfoListVO[arrNtcInfos.length];
			System.arraycopy(arrNtcInfos, 0, tmpVOs, 0, tmpVOs.length);
			this.arrNtcInfos = tmpVOs;
		}		
	} 

//	public BkgArrNtcVO[] getVos() {
//		return vos;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public BkgArrNtcVO[] getVos() {
		BkgArrNtcVO[] tmpVOs = null;
		if (this.vos != null) {
			tmpVOs = new BkgArrNtcVO[vos.length];
			System.arraycopy(vos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}
	
//	public void setVos(BkgArrNtcVO[] vos) {
//		this.vos = vos;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setVos(BkgArrNtcVO[] vos) {
		if (vos != null) {
			BkgArrNtcVO[] tmpVOs = new BkgArrNtcVO[vos.length];
			System.arraycopy(vos, 0, tmpVOs, 0, tmpVOs.length);
			this.vos = tmpVOs;
		}		
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

//	public CustCdEvaluationVO[] getCustCdEvaluationVO() {
//		return custCdEvaluationVO;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public CustCdEvaluationVO[] getCustCdEvaluationVO() {
		CustCdEvaluationVO[] tmpVOs = null;
		if (this.custCdEvaluationVO != null) {
			tmpVOs = new CustCdEvaluationVO[custCdEvaluationVO.length];
			System.arraycopy(custCdEvaluationVO, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}
	
//	public void setCustCdEvaluationVO(CustCdEvaluationVO[] custCdEvaluationVO) {
//		this.custCdEvaluationVO = custCdEvaluationVO;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setCustCdEvaluationVO(CustCdEvaluationVO[] custCdEvaluationVO) {
		if (custCdEvaluationVO != null) {
			CustCdEvaluationVO[] tmpVOs = new CustCdEvaluationVO[custCdEvaluationVO.length];
			System.arraycopy(custCdEvaluationVO, 0, tmpVOs, 0, tmpVOs.length);
			this.custCdEvaluationVO = tmpVOs;
		}		
	}


	/**
	 * 
	 * @return
	 */
//	public ArrNtcCustListVO[] getArrNtcCustListVOS() {
//		return arrNtcCustListVOS;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public ArrNtcCustListVO[] getArrNtcCustListVOS() {
		ArrNtcCustListVO[] tmpVOs = null;
		if (this.arrNtcCustListVOS != null) {
			tmpVOs = new ArrNtcCustListVO[arrNtcCustListVOS.length];
			System.arraycopy(arrNtcCustListVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}
	
	/**
	 * 
	 * @param arrNtcCustListVOS
	 */
//	public void setArrNtcCustListVOS(ArrNtcCustListVO[] arrNtcCustListVOS) {
//		this.arrNtcCustListVOS = arrNtcCustListVOS;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setArrNtcCustListVOS(ArrNtcCustListVO[] arrNtcCustListVOS) {
		if (arrNtcCustListVOS != null) {
			ArrNtcCustListVO[] tmpVOs = new ArrNtcCustListVO[arrNtcCustListVOS.length];
			System.arraycopy(arrNtcCustListVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.arrNtcCustListVOS = tmpVOs;
		}		
	}
/**
 * 
 * @return
 */
//	public ArrNtcCustUploadListVO[] getArrNtcCustUploadListVOS() {
//		// TODO Auto-generated method stub
//		return arrNtcCustUploadListVOS;
//	}
//	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public ArrNtcCustUploadListVO[] getArrNtcCustUploadListVOS() {
		ArrNtcCustUploadListVO[] tmpVOs = null;
		if (this.arrNtcCustUploadListVOS != null) {
			tmpVOs = new ArrNtcCustUploadListVO[arrNtcCustUploadListVOS.length];
			System.arraycopy(arrNtcCustUploadListVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}

/**
 * 
 * @param arrNtcCustUploadListVOS
 */
//	public void setArrNtcCustUploadListVOS(ArrNtcCustUploadListVO[] arrNtcCustUploadListVOS) {
//		this.arrNtcCustUploadListVOS = arrNtcCustUploadListVOS;
//	}
//	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setArrNtcCustUploadListVOS(ArrNtcCustUploadListVO[] arrNtcCustUploadListVOS) {
		if (arrNtcCustUploadListVOS != null) {
			ArrNtcCustUploadListVO[] tmpVOs = new ArrNtcCustUploadListVO[arrNtcCustUploadListVOS.length];
			System.arraycopy(arrNtcCustUploadListVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.arrNtcCustUploadListVOS = tmpVOs;
		}		
	}
	
}