/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VLVDDateUpdateMgtBC.java
*@FileTitle : VL/VD Date Update by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.vo.DmtVesselDateUpdateParmVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.vo.DmtVslDtUpdVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.vo.VslDtUpdListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * APLS-Dmtexceptionmgt Business Logic Command Interface<br>
 *
 * @author
 * @see reference Ui_dmt_2012EventResponse
 * @since J2EE 1.4
 */

public interface VLVDDateUpdateMgtBC {
    
    /**
    * SEARCH VL/VD Date for Update.<br>
    * 
    * @param DmtVesselDateUpdateParmVO   dmtVesselDateUpdateParmVO
    * @return List<VslDtUpdListVO>
    * @exception EventException
    */
	public List<VslDtUpdListVO> searchVLVDByVVDList ( DmtVesselDateUpdateParmVO   dmtVesselDateUpdateParmVO ) throws EventException;

    /**
    *  Update VL/VD Date by VVD.<br>
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
