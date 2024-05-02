/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EesLse0104Event.java
*@FileTitle : Off-hirable Container List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.12
*@LastModifier : 길정권
*@LastVersion : 1.0
* 2014.05.12 길정권
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.event;

import java.text.SimpleDateFormat;
import java.util.Locale;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.event.EES_LSE_0104HTMLAction;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireContainerListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_LSE_0104 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0104HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see EES_LSE_0104HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesLse0104Event extends EventSupport {
	/*
	 * 객체직렬화 버젼 UID
	 */
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AvailableOffHireContainerListVO availableOffHireContainerListVO = null;

	/**
	 * Default Constructor.
	 */
	public EesLse0104Event(){}

	public void setAvailableOffHireContainerListVO(AvailableOffHireContainerListVO availableOffHireContainerListVO){
		this. availableOffHireContainerListVO = availableOffHireContainerListVO;
	}

	public AvailableOffHireContainerListVO getAvailableOffHireContainerListVO(){
		return availableOffHireContainerListVO;
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
