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
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.eur.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.eur.integration.EurCustomsReportDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.eur.vo.EurSearchSendLogCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.SendLogCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.SendLogDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration business logic handling.<br>
 * 
 * @author Kyoung Jong Yun
 * @see each DAO class reference
 * @since J2EE 1.6
 */
public class EurCustomsReportBCImpl extends BasicCommandSupport implements EurCustomsReportBC {

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