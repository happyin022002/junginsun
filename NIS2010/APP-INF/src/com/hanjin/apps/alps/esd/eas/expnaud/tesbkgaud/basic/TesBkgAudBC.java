/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TesBkgAudBC.java
*@FileTitle : Rehandling(BKG COD)
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.12
*@LastModifier : 김현주
*@LastVersion : 1.0
* 2015.03.12 김현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.tesbkgaud.basic;




import java.util.List;

import com.hanjin.apps.alps.esd.eas.expnaud.tesbkgaud.vo.RehandlingBkgCodVO;
import com.hanjin.apps.alps.esd.eas.expnaud.testoraud.vo.RehandlingExpenseTorVsTpbVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Eac Business Logic Command Interface<br>
 * - ALPS-Eac에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author BAEK HYOUNG IN
 * @see  EacmgtEventResponse 참조
 * @since J2EE 1.6
 */

public interface TesBkgAudBC {

	 /**
	  * Rehandling(BKG COD) 조회한다.<br>
	  * 
	  * @param RehandlingBkgCodVO rehandlingBkgCodVO
	  * @return List<RehandlingBkgCodVO>
	  * @exception EventException
	  */
	 @SuppressWarnings("unchecked")
	 public List<RehandlingBkgCodVO> searchCodCostList(RehandlingBkgCodVO rehandlingBkgCodVO) throws EventException;

}