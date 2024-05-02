/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VLVDDateUpdateMgtBCImpl.java
*@FileTitle : VL/VD Date Update by VVD
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.integration.VLVDDateUpdateDBDAO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.vo.DmtVesselDateUpdateParmVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.vo.DmtVslDtUpdVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.vo.VslDtUpdListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * APLS-DMTExceptionMgt Business Logic Basic Command implementation<br>
 *
 * @author
 * @see reference DAO class of UI_DMT_2012EventResponse,VLVDDateUpdateMgtBC
 * @since J2EE 1.4
 */

public class VLVDDateUpdateMgtBCImpl extends BasicCommandSupport implements VLVDDateUpdateMgtBC {

	// Database Access Object
	private transient VLVDDateUpdateDBDAO dbDao = null;

	/**
	 * VLVDDateUpdateMgtBCImpl Create object<br>
	 * Create VLVDDateUpdateDBDAO<br>
	 */
	public VLVDDateUpdateMgtBCImpl() {
		dbDao = new VLVDDateUpdateDBDAO();
	}
	
    /**
    * SEARCH VL/VD Date for Update.<br>
    * 
    * @param DmtVesselDateUpdateParmVO dmtVesselDateUpdateParmVO
    * @return List<VslDtUpdListVO>
    * @exception EventException
    */
	public List<VslDtUpdListVO> searchVLVDByVVDList ( DmtVesselDateUpdateParmVO dmtVesselDateUpdateParmVO ) throws EventException {
		try {
			return dbDao.searchVLVDByVVDList ( dmtVesselDateUpdateParmVO );
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
	}

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
    public String manageVLVDDate ( String xMvmt , String xPort , DmtVslDtUpdVO[] dmtVslDtUpdVOs , SignOnUserAccount account ) throws EventException {
        try {
            for(int i = 0 ; i < dmtVslDtUpdVOs.length ; i++){
                String tVal = dmtVslDtUpdVOs[i].getVldateb();
                String tVal2 = dmtVslDtUpdVOs[i].getIbflag();
                log.debug("####### (" + i + ") VVD [" + dmtVslDtUpdVOs[i].getVvd() + "] TOBE [" + tVal + "] IBFLAG [" + tVal2 + "]");
                if ( !tVal.equals("") && !tVal.equals("null") && tVal.length() > 0 && tVal2.equals("U") ) {
                    List<VslDtUpdListVO> list = dbDao.checkVvdIsExist( dmtVslDtUpdVOs[i].getVvd() , xMvmt , xPort );
                    int rsltCnt = list.size();
                    if ( rsltCnt == 1 ) {
                        dbDao.modifyDateByVvdCd( xMvmt , xPort , dmtVslDtUpdVOs[i].getVvd() , dmtVslDtUpdVOs[i].getVldaten() , dmtVslDtUpdVOs[i].getVldateb() , account );
                    } else {
                        dbDao.addDateByVvdCd( xMvmt , xPort , dmtVslDtUpdVOs[i].getVvd() , dmtVslDtUpdVOs[i].getVldaten() , dmtVslDtUpdVOs[i].getVldateb() , account );
                    }
                }
            } // FOR            
            return "Success";
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }
	
}
