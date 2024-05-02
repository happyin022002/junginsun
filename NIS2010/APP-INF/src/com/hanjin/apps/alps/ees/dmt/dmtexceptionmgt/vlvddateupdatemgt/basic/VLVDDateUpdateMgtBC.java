/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VLVDDateUpdateMgtBC.java
*@FileTitle : VL/VD Date Update by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 김재진
*@LastVersion : 1.0
* 2009.08.26 김재진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.vo.DmtVesselDateUpdateParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.vo.DmtVslDtUpdVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.vo.VslDtUpdListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * APLS-Dmtexceptionmgt Business Logic Command Interface<br>
 * - APLS-Dmtexceptionmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Jae Jin
 * @see Ui_dmt_2012EventResponse 참조
 * @since J2EE 1.4
 */

public interface VLVDDateUpdateMgtBC {
    
    /**
    * [VL/VD DATE UPDATE 대상]을 [SEARCH] 합니다.<br>
    * 
    * @param DmtVesselDateUpdateParmVO   dmtVesselDateUpdateParmVO
    * @return List<VslDtUpdListVO>
    * @exception EventException
    */
	public List<VslDtUpdListVO> searchVLVDByVVDList ( DmtVesselDateUpdateParmVO   dmtVesselDateUpdateParmVO ) throws EventException;

    /**
    * [VL/VD DATE]을 [Update by VVD] 합니다.<br>
    * 
    * @param String xMvmt
    * @param String xPort
    * @param DmtVslDtUpdVO[] dmtVslDtUpdVOs
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String manageVLVDDate ( String xMvmt , String xPort , DmtVslDtUpdVO[] dmtVslDtUpdVOs , SignOnUserAccount account ) throws EventException;
}