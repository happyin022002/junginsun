/*=========================================================
 *Copyright(c) 2009 CyberLogitec 
 *@FileName : ChinaManifestListDownloadBackEndJob.java
 *@FileTitle : ChinaManifestListDownloadBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.25
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.08.25 이수빈
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.12.28 김상수 [CHM-201007850-01] [CTM] 업무 고도화 관련 소스 보완
 *                    Log 확인용 표준 출력 로그 제거
 *                    관련 대상 : 16개 file
 *                    변경 사항 : System.out.println => log.info 또는 제거
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration.LongTxContainerMovementFinderDBDAO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.MovementEDIReportVO;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Lee Subin
 * @see ESM_BKG_0216EventResponse,ChinaManifestListDownloadBackEndJob 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class LongTxContainerMovementFinderBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318313L;

	@SuppressWarnings("unused")
	private SignOnUserAccount account;
	private MovementEDIReportVO ediVO;
    // Database Access Object
    private LongTxContainerMovementFinderDBDAO dbDao = new LongTxContainerMovementFinderDBDAO();

	/**
	 * 다운로드 할 데이터 세팅
	 *
	 * @param manifestListDetailVOs
	 * @param account
	 */
	public void setMovementEDIReportVO(MovementEDIReportVO movementEDIReportVO, SignOnUserAccount account) {
		this.ediVO = movementEDIReportVO;
		this.account = account;
	}

	/**
	 * BackEndJob Start
	 *
	 * @return List<MovementEDIReportVO>
	 */
	public List<MovementEDIReportVO> doStart() throws Exception {

		try {
			return dbDao.searchEDIOnTimeDetailList(this.ediVO );
	    } catch (DAOException de) {
	        log.error("err " + de.toString(), de);
	        throw new EventException(new ErrorHandler("CTM00001", new String[] {}).getMessage());
	    } catch (Exception e) {
	        log.error("err " + e.toString(), e);
	        throw new EventException(new ErrorHandler("CTM00001", new String[] {}).getMessage());
	    }

	}

	/**
	 * BackEndJob 결과 Return.<br>
	 *
	 * @param String key
	 * @return List<DBRowSet>
	 */
	@SuppressWarnings("static-access")
	public List<DBRowSet> searchResultBC(String key) {
		BackEndJobResult backEndJobResult = new BackEndJobResult();
		List<DBRowSet> rowSets = new ArrayList<DBRowSet>();
		try {
			rowSets.add((DBRowSet)backEndJobResult.loadFromFile(key));
		} catch (Exception e) {
			log.info("ERR");
			log.error(e.getMessage(),e);
		}
		return rowSets;
	}

}