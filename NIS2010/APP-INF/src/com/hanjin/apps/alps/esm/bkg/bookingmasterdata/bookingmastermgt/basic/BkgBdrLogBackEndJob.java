/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgBdrLogBackEndJob.java
*@FileTitle : BKG_BDR_LOG_PKG Background Job
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.04
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.06.04 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration.BookingProcessMgtDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * ALPS-BookingMaster Back End Job Business Logic Basic Command implementation<br>
 * - ALPS-BookingMaster BackEnd작업을 처리하는 Business Class
 * @author Kim KiJong
 * @see ESM_BKG_0073 참조
 * @since J2EE 1.6
 */
public class BkgBdrLogBackEndJob extends BackEndCommandSupport {

	/**
	 * serializable ID
	 */
	private static final long serialVersionUID = -3584808021250066053L;
	

	/**
	 * BDR LOG 위한 Value
	 */
	private BkgVvdBdrLogVO bkgVvdBdrLogVO;
	
	/**
	 * BDR LOG 위한 Value를 Setup 한다.
	 * @param BkgVvdBdrLogVO bkgVvdBdrLogVO
	 */
	public void setBkgVvdBdrLogVO(BkgVvdBdrLogVO bkgVvdBdrLogVO) {
		this.bkgVvdBdrLogVO = bkgVvdBdrLogVO;
	}

	/**
	 * BDR LOG 실행반영한다.<br>
	 * @return Object
	 */
	public Object doStart() throws Exception {
		manageBKGBDRLOG(this.bkgVvdBdrLogVO); 
		return null;
	}
	
	/**
	 * Activate 시점에 처음 만들어 Booking을 받을 수 있는 최종 시점을 관리 하는 BDR LOG 테이블을 관리할 목적<br>
	 * @param BkgVvdBdrLogVO vo
	 * @exception EventException
	 */
	private void manageBKGBDRLOG(BkgVvdBdrLogVO vo) throws EventException {
		try {
			BookingProcessMgtDBDAO dbDao = new BookingProcessMgtDBDAO();
			dbDao.manageBKGBDRLOG(vo);	
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		
	}
}
