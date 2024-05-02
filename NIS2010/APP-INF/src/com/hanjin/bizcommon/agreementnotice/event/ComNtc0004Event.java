/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ComNtc0004Event.java
*@FileTitle : Agreement notice
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.27
*@LastModifier : YJ Jeon
*@LastVersion : 1.0
* 2014.01.27 YJ Jeon
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.agreementnotice.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * AgreementNotice 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  COM_NTC_0004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author YJ Jeon
 * @see COM_NTC_0004HTMLAction 참조
 * @since J2EE 1.6
 */

public class ComNtc0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private String pgmNo  = "";
	
	/** Table Value Object Multi Data 처리 */
//	AgreementNoticeDAOtestRSQL[] agreementNoticeDAOtestRSQLs = null;

	public ComNtc0004Event(){}
	
	/**
     * pgm_no
     * @param pgm_no
     */
    public ComNtc0004Event(String pgm_no) {
        this.pgmNo = pgm_no;
    }
    
    /**
	 * pgm_no 코드 Get method
	 * @return
	 */
	public String getPgm_no() {
		return pgmNo;
	}

	/**
	 * pgm_no 코드 Set method
	 * @param Pgm_no
	 */
		public void setPgm_no(String pgm_no) {
		this.pgmNo = pgm_no;
	}
	
}