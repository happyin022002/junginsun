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
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.VLVDUpdateStatusVO;
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
public class LongTxVLVDUpdateStatusBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318313L;

	private VLVDUpdateStatusVO ediVO;
    // Database Access Object
    private LongTxContainerMovementFinderDBDAO dbDao = new LongTxContainerMovementFinderDBDAO();

	/**
	 * setting for downloading
	 *
	 * @param manifestListDetailVOs
	 * @param account
	 */
	public void setVLVDUpdateStatusVO(VLVDUpdateStatusVO vLVDUpdateStatusVO, SignOnUserAccount account) {
		this.ediVO = vLVDUpdateStatusVO;
	}

	/**
	 * BackEndJob Start
	 *
	 * @return List<VLVDUpdateStatusVO>
	 */
	public List<VLVDUpdateStatusVO> doStart() throws Exception {

		try {
			return dbDao.searchVLVDUpdateStatus(this.ediVO );
	    } catch (DAOException de) {
	        log.error("err " + de.toString(), de);
	        throw new EventException(new ErrorHandler("CTM00001", new String[] {}).getMessage());
	    } catch (Exception e) {
	        log.error("err " + e.toString(), e);
	        throw new EventException(new ErrorHandler("CTM00001", new String[] {}).getMessage());
	    }

	}

	/**
	 * returning BackEndJob result
	 *
	 * @param String key
	 * @return List<DBRowSet
	 * @throws EventException
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