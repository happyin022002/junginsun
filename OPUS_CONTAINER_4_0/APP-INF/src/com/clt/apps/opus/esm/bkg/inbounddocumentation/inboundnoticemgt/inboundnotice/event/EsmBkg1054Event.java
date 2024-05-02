/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1054Event.java
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
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcInfoListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdEvaluationVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_1054 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1054HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_1054HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1054Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private ArrNtcSearchVO arrNtcSearchVO = null;
	private ArrNtcInfoListVO arrNtcVO = null;
	private ArrNtcInfoListVO[] arrNtcVOs = null;
	private CustCdEvaluationVO[] custCdEvaluationVO = null;
	
	//[672-02] 조회용
	private ArrNtcCustListVO[] arrNtcCustListVOS = null;


	public EsmBkg1054Event(){}


	public ArrNtcSearchVO getArrNtcSearchVO() {
		return arrNtcSearchVO;
	}


	public void setArrNtcSearchVO(ArrNtcSearchVO arrNtcSearchVO) {
		this.arrNtcSearchVO = arrNtcSearchVO;
	}


	public ArrNtcInfoListVO getArrNtcVO() {
		return arrNtcVO;
	}


	public void setArrNtcVO(ArrNtcInfoListVO arrNtcVO) {
		this.arrNtcVO = arrNtcVO;
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
	 * @param arrNtcVOs the arrNtcVOs to set
	 */
//	public void setArrNtcVOs(ArrNtcInfoListVO[] arrNtcVOs) {
//		this.arrNtcVOs = arrNtcVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setArrNtcVOs(ArrNtcInfoListVO[] arrNtcVOs) {
		if (arrNtcVOs != null) {
			ArrNtcInfoListVO[] tmpVOs = new ArrNtcInfoListVO[arrNtcVOs.length];
			System.arraycopy(arrNtcVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.arrNtcVOs = tmpVOs;
		}		
	} 
    
	/**
	 * @return the arrNtcVOs
	 */
//	public ArrNtcInfoListVO[] getArrNtcVOs() {
//		return arrNtcVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public ArrNtcInfoListVO[] getArrNtcVOs() {
		ArrNtcInfoListVO[] tmpVOs = null;
		if (this.arrNtcVOs != null) {
			tmpVOs = new ArrNtcInfoListVO[arrNtcVOs.length];
			System.arraycopy(arrNtcVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
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
	
}