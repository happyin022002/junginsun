/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EurCustomsReportBCImpl.java
 *@FileTitle : EurCustomsReportBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.20
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.07.20 경종윤
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.eur.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.basic.CustomsReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.eur.integration.EurCustomsReportDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.eur.vo.EurSearchSendLogCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.SendLogCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.SendLogDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kyoung Jong Yun
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class EurCustomsReportBCImpl extends CustomsReportBCImpl {

	// Database Access Object
	private transient EurCustomsReportDBDAO dbDao = null;

	/**
	 * EurCustomsReportBCImpl 객체 생성<br>
	 * EurCustomsReportDBDAO 생성한다.<br>
	 */
	public EurCustomsReportBCImpl() {
		dbDao = new EurCustomsReportDBDAO();
	}

	/**
	 * EUR 전송 로그를 조회한다.
	 * 
	 * @param SendLogCondVO sendLogCondVO
	 * @return List<SendLogDetailVO>
	 * @throws EventException
	 */
	public List<SendLogDetailVO> searchSendLog(SendLogCondVO sendLogCondVO) throws EventException {
		try {
			return dbDao.searchSendLog((EurSearchSendLogCondVO)sendLogCondVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

}