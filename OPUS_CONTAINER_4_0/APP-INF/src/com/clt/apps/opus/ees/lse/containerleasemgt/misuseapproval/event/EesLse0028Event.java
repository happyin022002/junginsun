/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0028Event.java
*@FileTitle : Mis Use In & Out Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.14 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.event;

import java.text.SimpleDateFormat;
import java.util.Locale;

import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo.MisUseApprovalVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo.MisUseReqContainerVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo.MisUseRequestVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_LSE_0028 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0028HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see EES_LSE_0028HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0028Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MisUseRequestVO misUseRequestVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MisUseApprovalVO misUseApprovalVO = null;		
	
	/** Table Value Object Multi Data 처리 */
	private MisUseReqContainerVO[] misUseReqContainerVOs = null;

	public EesLse0028Event(){}
	
	public void setMisUseRequestVO(MisUseRequestVO misUseRequestVO){
		this. misUseRequestVO = misUseRequestVO;
	}
	
	public void setMisUseApprovalVO(MisUseApprovalVO misUseApprovalVO){
		this. misUseApprovalVO = misUseApprovalVO;
	}

	public void setMisUseReqContainerVOs(MisUseReqContainerVO[] misUseReqContainerVOs){
		if (misUseReqContainerVOs != null) {
			MisUseReqContainerVO[] tmpVOs = new MisUseReqContainerVO[misUseReqContainerVOs.length];
			System.arraycopy(misUseReqContainerVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.misUseReqContainerVOs = tmpVOs;
		}
	}

	public MisUseRequestVO getMisUseRequestVO(){
		return misUseRequestVO;
	}
	
	public MisUseApprovalVO getMisUseApprovalVO(){
		return misUseApprovalVO;
	}

	public MisUseReqContainerVO[] getMisUseReqContainerVOs(){
		MisUseReqContainerVO[] tmpVOs = null;
		if (this.misUseReqContainerVOs != null) {
			tmpVOs = new MisUseReqContainerVO[misUseReqContainerVOs.length];
			System.arraycopy(misUseReqContainerVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	/* Office Code */
	private String ofcCd;
	
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	public String getOfcCd() {
		return ofcCd;
	}
	
	/* Request Number */
	private String rqstNo;
	
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}
	
	public String getRqstNo() {
		return rqstNo;
	}
	
	/**
     * 서버의 현재일자를 반환한다.
     * @param pattern 날짜포멧
     * @return String 현재일자
     * @throws Exception
     */
    public static String getCurrentDate(String pattern) throws Exception {
        Locale locale = new Locale("ko", "KOREA");
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern, locale);
        String current  = dateFormat.format(new java.util.Date());

        return current;
    }
}