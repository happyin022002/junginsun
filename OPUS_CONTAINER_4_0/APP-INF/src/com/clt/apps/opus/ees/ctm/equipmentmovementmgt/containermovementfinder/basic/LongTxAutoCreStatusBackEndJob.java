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
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.AutoCreStsListVO;
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
public class LongTxAutoCreStatusBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318313L;

	@SuppressWarnings("unused")
	private SignOnUserAccount account;
	private AutoCreStsListVO autoCreStsListVO;

	// Database Access Object
    private LongTxContainerMovementFinderDBDAO dbDao = new LongTxContainerMovementFinderDBDAO();

	/**
	 * DAO class reference
	 *
	 * @param SearchEDIErrorVO ediErrVO
	 * @param account
	 */
	public void setSearchAutoCreStatus(AutoCreStsListVO autoCreStsListVO, SignOnUserAccount account) {
		this.account = account;
		this.autoCreStsListVO = autoCreStsListVO;
		log.info("VO 세팅" + autoCreStsListVO.getLocCd());
	}

	/**
	 * BackEndJob Start
	 * @return List<SearchEDIErrorVO>
	 * @throws Exception
	 */
	public List<AutoCreStsListVO> doStart() throws Exception {
		List<AutoCreStsListVO> list = null;
		try {
			list = getAutoCreSts(this.autoCreStsListVO);
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
	 * @param SearchEDIErrorVO searchEDIErrorVO
	 * @return List<SearchEDIErrorVO>
	 * @throws Exception
	 */
	public List<AutoCreStsListVO> getAutoCreSts(AutoCreStsListVO autoCreStsListVO) throws Exception {
		List<AutoCreStsListVO> returnList = null;
		try {
			returnList = dbDao.getAutoCreSts(autoCreStsListVO);
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