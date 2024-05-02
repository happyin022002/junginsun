/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VLVDDateUpdateMgtBCImpl.java
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

import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.integration.VLVDDateUpdateDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.vo.DmtVesselDateUpdateParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.vo.DmtVslDtUpdVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.vo.VslDtUpdListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * APLS-DMTExceptionMgt Business Logic Basic Command implementation<br>
 * - APLS-DMTExceptionMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Jae Jin
 * @see UI_DMT_2012EventResponse,VLVDDateUpdateMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class VLVDDateUpdateMgtBCImpl extends BasicCommandSupport implements VLVDDateUpdateMgtBC {

	// Database Access Object
	private transient VLVDDateUpdateDBDAO dbDao = null;

	/**
	 * VLVDDateUpdateMgtBCImpl 객체 생성<br>
	 * VLVDDateUpdateDBDAO 생성한다.<br>
	 */
	public VLVDDateUpdateMgtBCImpl() {
		dbDao = new VLVDDateUpdateDBDAO();
	}
	
    /**
    * [VL/VD Date Update 대상]을 [SEARCH] 합니다.<br>
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
    * [VL/VD Date Update 대상]을 [manage] 합니다.<br>
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
                    List<VslDtUpdListVO> list = dbDao.checkVvdIsExist( dmtVslDtUpdVOs[i].getVvd() , xMvmt , xPort, dmtVslDtUpdVOs[i].getClptIndSeq() );
                    int rsltCnt = list.size();
                    if ( rsltCnt == 1 ) {
                        dbDao.modifyDateByVvdCd( xMvmt , xPort , dmtVslDtUpdVOs[i].getVvd() , dmtVslDtUpdVOs[i].getVldaten() , dmtVslDtUpdVOs[i].getVldateb() , account, dmtVslDtUpdVOs[i].getClptIndSeq() );
                    } else {
                        dbDao.addDateByVvdCd( xMvmt , xPort , dmtVslDtUpdVOs[i].getVvd() , dmtVslDtUpdVOs[i].getVldaten() , dmtVslDtUpdVOs[i].getVldateb() , account, dmtVslDtUpdVOs[i].getClptIndSeq() );
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