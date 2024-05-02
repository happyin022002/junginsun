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
package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration.EmptyReleaseRedeliveryOrderMgtDBDAO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.CimCStockVO;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * handling business logic for OPUS-EmptyReleaseRedeliveryOrderMgt
 *
 * @author 
 * @see ESM_BKG_0216EventResponse,ChinaManifestListDownloadBackEndJob DAO class reference
 * @since J2EE 1.4
 */
public class EmptyReleaseRedeliveryOderMgtSettledOrderBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318313L;

	@SuppressWarnings("unused")
	private SignOnUserAccount account;
	private CimCStockVO cimCStockVO;

	// Database Access Object
    private EmptyReleaseRedeliveryOrderMgtDBDAO dbDao = new EmptyReleaseRedeliveryOrderMgtDBDAO();

	/**
	 * setting data for downloading
	 *
	 * @param CimCStockVO ediErrVO
	 * @param account
	 */
	public void setCimCStockVO(CimCStockVO cimCStockVO, SignOnUserAccount account) {
		this.account = account;
		this.cimCStockVO = cimCStockVO;
	}

	/**
	 * BackEndJob Start
	 * @return List<CimCStockVO>
	 * @throws Exception
	 */
	public List<CimCStockVO> doStart() throws Exception {
		List<CimCStockVO> list = null;
		try {
			list = searchSettledOrderList(this.cimCStockVO);
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
	 * calling BackEndJob for retrieving data
	 *
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @throws Exception
	 */
	private List<CimCStockVO> searchSettledOrderList(CimCStockVO cimCStockVO) throws Exception {
		List<CimCStockVO> returnList = null;
		try {
			returnList = dbDao.searchSettledOrderList(cimCStockVO);
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
	 * returning result of BackEndJob
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