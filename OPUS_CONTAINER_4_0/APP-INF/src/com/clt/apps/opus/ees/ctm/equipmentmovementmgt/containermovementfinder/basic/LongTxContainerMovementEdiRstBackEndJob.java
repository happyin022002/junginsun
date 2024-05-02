/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ChinaManifestListDownloadBackEndJob.java
 *@FileTitle : ChinaManifestListDownloadBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration.LongTxContainerMovementFinderDBDAO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEDIResultVO;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * handling business logic about OPUS-CustomsDeclaration
 *
 * @author 
 * @see ESM_BKG_0216EventResponse,ChinaManifestListDownloadBackEndJob DAO class reference
 * @since J2EE 1.4
 */
public class LongTxContainerMovementEdiRstBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318313L;

	private SearchEDIResultVO searchEDIResultVO;

	// Database Access Object
    private LongTxContainerMovementFinderDBDAO dbDao = new LongTxContainerMovementFinderDBDAO();

	/**
	 * DAO class reference
	 *
	 * @param SearchEDIResultVO ediErrVO
	 * @param account
	 */
	public void setSearchEDIResultVO(SearchEDIResultVO searchEDIResultVO, SignOnUserAccount account) {
		this.searchEDIResultVO = searchEDIResultVO;
	}

	/**
	 * BackEndJob Start
	 * @return List<SearchEDIResultVO>
	 */
	public List<SearchEDIResultVO> doStart() throws Exception {
		List<SearchEDIResultVO> list = null;
		try {
			list = searchEDIResultList(this.searchEDIResultVO);
	    } catch (DAOException de) {
	        log.error("err " + de.toString(), de);
	        throw new EventException(new ErrorHandler("CTM00001", new String[] {}).getMessage());
	    } catch (Exception e) {
	        log.error("err " + e.toString(), e);
	        throw new EventException(new ErrorHandler("CTM00001", new String[] {}).getMessage());
	    }
		return list;
	}

	/**
	 * calling BackEndJob for data retrieving 
	 *
	 * @param SearchEDIResultVO searchEDIResultVO
	 * @return List<SearchEDIResultVO>
	 * @throws Exception
	 */
	private List<SearchEDIResultVO> searchEDIResultList(SearchEDIResultVO searchEDIResultVO) throws Exception {
		List<SearchEDIResultVO> returnList = null;
		try {
			returnList = dbDao.searchEDIResultSumList(searchEDIResultVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return returnList;
	}

	/**
	 * returning BackEndJob result
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