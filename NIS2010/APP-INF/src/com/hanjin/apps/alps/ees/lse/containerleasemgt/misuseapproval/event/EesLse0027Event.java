/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0027Event.java
*@FileTitle : Mis Use In & Out Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.14 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.event;

import java.text.SimpleDateFormat;
import java.util.Locale;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.MisUseReqContainerVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.MisUseRequestVO;


/**
 * EES_LSE_0027 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0027HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see EES_LSE_0027HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0027Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MisUseRequestVO misUseRequestVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public MisUseReqContainerVO[] misUseReqContainerVOs = null;

	public EesLse0027Event(){}
	
	public void setMisUseRequestVO(MisUseRequestVO misUseRequestVO){
		this. misUseRequestVO = misUseRequestVO;
	}

	public void setMisUseReqContainerVOs(MisUseReqContainerVO[] misUseReqContainerVOs){
		this. misUseReqContainerVOs = misUseReqContainerVOs;
	}

	public MisUseRequestVO getMisUseRequestVO(){
		return misUseRequestVO;
	}

	public MisUseReqContainerVO[] getMisUseReqContainerVOs(){
		return misUseReqContainerVOs;
	}
	
	/* Office Code */
	private String ofcCd;
	
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	public String getOfcCd() {
		return ofcCd;
	}
	
	/* Container Number */
	private String cntrNo;
	
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	public String getCntrNo() {
		return cntrNo;
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