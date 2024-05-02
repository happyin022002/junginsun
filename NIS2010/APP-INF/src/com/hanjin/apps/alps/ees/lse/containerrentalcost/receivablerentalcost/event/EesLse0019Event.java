/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0019Event.java
*@FileTitle : Receivable Charge & Invoice Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.08.24 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.event;

import java.text.SimpleDateFormat;
import java.util.Locale;

import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.SearchParamVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableChargeVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_LSE_0019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see EES_LSE_0019HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0019Event extends EventSupport {
	/*
	 * 객체직렬화 버젼 UID
	 */
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchParamVO searchParamVO = null;	
	
	/** Table Value Object Multi Data 처리 */
	public ReceivableChargeVO[] receivableChargeVOs = null;
	
	public ReceivableInvoiceVO[] receivableInvoiceVOs = null;
	
	/**
	 * Default Constructor.
	 */
	public EesLse0019Event(){}
	
	/**
	 * 단건처리 DataModel를 설정한다.
	 * @param searchParamVO
	 */
	public void setSearchParamVO(SearchParamVO searchParamVO){
		this.searchParamVO = searchParamVO;
	}
	
	public void setReceivableChargeVOs(ReceivableChargeVO[] receivableChargeVOs) {
		this.receivableChargeVOs = receivableChargeVOs; 
	}
	
	public void setReceivableInvoiceVOs(ReceivableInvoiceVO[] receivableInvoiceVOs) {
		this.receivableInvoiceVOs = receivableInvoiceVOs; 
	}
	
	/**
	 * 단건처리 DataModel를 반환한다.
	 * @return PlanSearchVO
	 */
	public SearchParamVO getSearchParamVO(){
		return searchParamVO;
	}
	
	public ReceivableChargeVO[] getReceivableChargeVOs() {
		return receivableChargeVOs;
	}
	
	public ReceivableInvoiceVO[] getReceivableInvoiceVOs() {
		return receivableInvoiceVOs;
	}
	
	/* QTY Year Month */
	private String qtyYrmon;
	
	/**
	 * @return the qtyYrmon
	 */
	public String getQtyYrmon() {
		return qtyYrmon;
	}

	/**
	 * @param qtyYrmon the qtyYrmon to set
	 */
	public void setQtyYrmon(String qtyYrmon) {
		this.qtyYrmon = qtyYrmon;
	}
	
	/* Agreement Seq */
	private String agmtSeq;
	
	/**
	 * @return the agmtSeq
	 */
	public String getAgmtSeq() {
		return agmtSeq;
	}

	/**
	 * @param agmtSeq the agmtSeq to set
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}

	/**
     * 서버의 현재일자에 개월수를 가감된 일자를 반환한다.
     * @param pattern 날짜포멧
     * @param addMonth 개월 수
     * @return String 가감일자
     * @throws Exception
     */
    public static String getCurrAddMonths(String pattern, int addMonth) throws Exception {
    	Locale locale = new Locale("ko", "KOREA");
               
 		java.text.SimpleDateFormat yearFormat = new java.text.SimpleDateFormat("yyyy", locale);
 		java.text.SimpleDateFormat monthFormat = new java.text.SimpleDateFormat("MM", locale);
 		java.text.SimpleDateFormat dayFormat = new java.text.SimpleDateFormat("dd", locale);
        int year = Integer.parseInt(yearFormat.format(new java.util.Date()));
        int month = Integer.parseInt(monthFormat.format(new java.util.Date()));
        int day = Integer.parseInt(dayFormat.format(new java.util.Date()));

        month += addMonth;
        if(addMonth > 0) {
            while (month > 12) {
                month -= 12;
                year += 1;
            }
        } else {
            while (month <= 0) {
                month += 12;
                year -= 1;
            }
        }
 		java.text.DecimalFormat fourDf = new java.text.DecimalFormat("0000");
 		java.text.DecimalFormat twoDf = new java.text.DecimalFormat("00");
        String tempDate = String.valueOf(fourDf.format(year))
                        + String.valueOf(twoDf.format(month))
                        + String.valueOf(twoDf.format(day));
        
        java.util.Date date = new SimpleDateFormat("yyyyMMdd", locale).parse(tempDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern, locale);        
        return dateFormat.format(date);
    }
}