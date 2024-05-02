/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0022Event.java
*@FileTitle : Off-Hire Confirm from Lessor
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.10.08 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.event;

import java.text.SimpleDateFormat;
import java.util.Locale;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.event.EES_LSE_0022HTMLAction;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireConfirmVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.SearchParamVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_LSE_0022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see EES_LSE_0022HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesLse0022Event extends EventSupport {
	/*
	 * 객체직렬화 버젼 UID
	 */
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchParamVO searchParamVO = null;

	/** Table Value Object Multi Data 처리 */
	public AvailableOffHireConfirmVO[] availableOffHireConfirmVOs = null;

	/**
	 * Default Constructor.
	 */
	public EesLse0022Event(){}

	public void setSearchParamVO(SearchParamVO searchParamVO){
		this. searchParamVO = searchParamVO;
	}

	public void setAvailableOffHireConfirmVOs(AvailableOffHireConfirmVO[] availableOffHireConfirmVOs){
		this. availableOffHireConfirmVOs = availableOffHireConfirmVOs;
	}

	public SearchParamVO getSearchParamVO(){
		return searchParamVO;
	}

	public AvailableOffHireConfirmVO[] getAvailableOffHireConfirmVOs(){
		return availableOffHireConfirmVOs;
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
