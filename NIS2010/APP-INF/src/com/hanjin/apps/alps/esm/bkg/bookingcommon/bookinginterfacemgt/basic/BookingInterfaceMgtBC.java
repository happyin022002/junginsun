/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingInterfaceMgtBC.java
*@FileTitle : 11111
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.10.22 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinginterfacemgt.basic;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinginterfacemgt.vo.SearchBkgInfoForINVVO;
import com.hanjin.framework.core.layer.event.EventException;


/**
 * NIS2010-Bookingcommon Business Logic Command Interface<br>
 * - NIS2010-Bookingcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Kim Youngchul
 * @see BookingInterfaceMgtBCImpl 참조
 * @since J2EE 1.4
 */
public interface BookingInterfaceMgtBC {

	/**
	 * BKG에서 INV로 INTERFACE할 정보를 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @return SearchBkgInfoForINVVO
	 * @exception EventException
	 */
	public SearchBkgInfoForINVVO searchBkgInfoForINVVO(String bkgNo) throws EventException;
	
}