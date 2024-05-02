/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MnrAudBC.java
*@FileTitle : Expense Audit case Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.mnraud.basic;




import java.util.List;

import com.hanjin.apps.alps.esd.eas.expnaud.mnraud.vo.HbarInquiryByBkgVO;
import com.hanjin.apps.alps.esd.eas.expnaud.mnraud.vo.HbarInquiryByHistoryVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Eac Business Logic Command Interface<br>
 * - ALPS-Eac에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author BAEK HYOUNG IN
 * @see  EacmgtEventResponse 참조
 * @since J2EE 1.6
 */

public interface MnrAudBC {

	/**
	 * H/Bar Inquiry by BKG 조회한다.<br>
	 * 
	 * @param HbarInquiryByBkgVO hbarInquiryByBkgVO
	 * @return List<HbarInquiryByBkgVO>
	 * @exception EventException
	 */
	public List<HbarInquiryByBkgVO> searchBkgHngrList(HbarInquiryByBkgVO hbarInquiryByBkgVO) throws EventException;

	/**
	 * HBar Inquiry by History 조회한다.<br>
	 * 
	 * @param HbarInquiryByHistoryVO hbarInquiryByHistoryVO
	 * @return List<HbarInquiryByHistoryVO>
	 * @exception EventException
	 */
	public List<HbarInquiryByHistoryVO> searchHngrHisList(HbarInquiryByHistoryVO hbarInquiryByHistoryVO) throws EventException;
}
