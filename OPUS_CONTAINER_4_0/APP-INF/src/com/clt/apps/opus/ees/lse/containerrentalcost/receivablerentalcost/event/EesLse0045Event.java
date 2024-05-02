/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0045Event.java
*@FileTitle : Receivable Invoice Inquiry and Cancel
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.09.15 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.event;

import java.text.SimpleDateFormat;
import java.util.Locale;

import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceInquiryVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo.SearchParamVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * UI_LSE_0045 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0045HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see EES_LSE_0045HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0045Event extends EventSupport {
	/*
	 * 객체직렬화 버젼 UID
	 */
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchParamVO searchParamVO = null;	
	
	/** Table Value Object Multi Data 처리 */
	private ReceivableInvoiceInquiryVO[] receivableInvoiceInquiryVOs = null;
	
	/**
	 * Default Constructor.
	 */
	public EesLse0045Event(){}
	
	/**
	 * 단건처리 DataModel를 설정한다.
	 * @param searchParamVO
	 */
	public void setSearchParamVO(SearchParamVO searchParamVO){
		this.searchParamVO = searchParamVO;
	}
	
	public void setReceivableInvoiceInquiryVOs(ReceivableInvoiceInquiryVO[] receivableInvoiceInquiryVOs) {
		if (receivableInvoiceInquiryVOs != null) {
			ReceivableInvoiceInquiryVO[] tmpVOs = new ReceivableInvoiceInquiryVO[receivableInvoiceInquiryVOs.length];
			System.arraycopy(receivableInvoiceInquiryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.receivableInvoiceInquiryVOs = tmpVOs;
		}
	}
		
	/**
	 * 단건처리 DataModel를 반환한다.
	 * @return PlanSearchVO
	 */
	public SearchParamVO getSearchParamVO(){
		return searchParamVO;
	}
	
	public ReceivableInvoiceInquiryVO[] getReceivableInvoiceInquiryVOs() {
		ReceivableInvoiceInquiryVO[] tmpVOs = null;
		if (this.receivableInvoiceInquiryVOs != null) {
			tmpVOs = new ReceivableInvoiceInquiryVO[receivableInvoiceInquiryVOs.length];
			System.arraycopy(receivableInvoiceInquiryVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
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