/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCContractClauseGuidelineBCImpl.java
*@FileTitle : SC Guideline Contract Clause
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.sccontractclauseguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.scguideline.sccontractclauseguideline.integration.SCContractClauseGuidelineDBDAO;
import com.clt.apps.opus.esm.pri.scguideline.sccontractclauseguideline.vo.CtrtCluzGlineVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSgCtrtCluzDtlVO;
import com.clt.syscommon.common.table.PriSgCtrtCluzVO;
import com.clt.syscommon.common.table.PriSgMnVO;

/**
 * SCGuideline Business Logic Basic Command implementation<br>
 * - handling biz logic about SCGuideline<br>
 *
 * @author  
 * @see ESM_PRI_0001_07EventResponse,SCContractClauseGuidelineBC reference each DAO class
 * @since J2EE 1.4
 */

public class SCContractClauseGuidelineBCImpl extends BasicCommandSupport implements SCContractClauseGuidelineBC {

	// Database Access Object
	private transient SCContractClauseGuidelineDBDAO dbDao = null;

	/**
	 * SCContractClauseGuidelineBCImpl object creation<br>
	 * creating SCContractClauseGuidelineDBDAO<br>
	 */
	public SCContractClauseGuidelineBCImpl() {
		dbDao = new SCContractClauseGuidelineDBDAO();
	}
	
	/**
	 * handling retrieving event<br>
	 * handling retrieving event about SCBasicStandardNoteGuideline <br>
	 * 
	 * @param PriSgCtrtCluzVO priSgCtrtCluzVO
	 * @param String searchGubun
	 * @return CtrtCluzGlineVO
	 * @exception EventException
	 */
	public CtrtCluzGlineVO searchContractClauseGuidelineList(PriSgCtrtCluzVO priSgCtrtCluzVO, String searchGubun) throws EventException {
		try {
			//container vo
			CtrtCluzGlineVO ctrtCluzGlineVO = new CtrtCluzGlineVO();
			//title, body
			List<PriSgCtrtCluzVO> priSgCtrtClusVOList 		= new ArrayList<PriSgCtrtCluzVO>();
			List<PriSgCtrtCluzDtlVO> priSgCtrtClusDtlVOList = new ArrayList<PriSgCtrtCluzDtlVO>();

			if("1".equals(searchGubun)) {
				priSgCtrtClusVOList 		= dbDao.searchContractClauseList(priSgCtrtCluzVO);
				ctrtCluzGlineVO.setPriSgCtrtClusVOList(priSgCtrtClusVOList);
			}	
			else if("2".equals(searchGubun)) {
				priSgCtrtClusDtlVOList 		= dbDao.searchContractClauseDetailList(priSgCtrtCluzVO);
				ctrtCluzGlineVO.setPriSgCtrtClusDtlVOList(priSgCtrtClusDtlVOList);
			}
			else if("3".equals(searchGubun)) {
				
				priSgCtrtClusVOList 		= dbDao.searchContractClauseList(priSgCtrtCluzVO);
				ctrtCluzGlineVO.setPriSgCtrtClusVOList(priSgCtrtClusVOList);
				
				priSgCtrtClusDtlVOList 		= dbDao.searchContractClauseDetailList(priSgCtrtCluzVO);
				ctrtCluzGlineVO.setPriSgCtrtClusDtlVOList(priSgCtrtClusDtlVOList);
			}
			
			return ctrtCluzGlineVO;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}

	
	/**
	 * handling multiple event<br>
	 * saving contract clause<br>
	 * 
	 * @param CtrtCluzGlineVO ctrtCluzGlineVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageContractClauseGuideline(CtrtCluzGlineVO ctrtCluzGlineVO, SignOnUserAccount account) throws EventException{
		try {
		
			//vo
			PriSgCtrtCluzVO[] 	  priSgCtrtCluzVOs= null;
			PriSgCtrtCluzDtlVO[]  priSgCtrtCluzDtlVOs = null;

			priSgCtrtCluzVOs 		= ctrtCluzGlineVO.getPriSgCtrtCluzVOs();
			priSgCtrtCluzDtlVOs 	= ctrtCluzGlineVO.getPriSgCtrtCluzDtlVOs();
			
			//title
			List<PriSgCtrtCluzVO> insertVoList = new ArrayList<PriSgCtrtCluzVO>();
			List<PriSgCtrtCluzVO> updateVoList = new ArrayList<PriSgCtrtCluzVO>();
			List<PriSgCtrtCluzVO> deleteVoList = new ArrayList<PriSgCtrtCluzVO>();
			//body
			List<PriSgCtrtCluzDtlVO> insertDtlVoList = new ArrayList<PriSgCtrtCluzDtlVO>();
			List<PriSgCtrtCluzDtlVO> updateDtlVoList = new ArrayList<PriSgCtrtCluzDtlVO>();
			List<PriSgCtrtCluzDtlVO> deleteDtlVoList = new ArrayList<PriSgCtrtCluzDtlVO>();
			
			////////////////////////////title / body save/////////////////////////////////////	
			
			//title 
			for (int i = 0; priSgCtrtCluzVOs != null && i < priSgCtrtCluzVOs.length; i++) {
				
				if ( priSgCtrtCluzVOs[i].getIbflag().equals("I")){
				
					priSgCtrtCluzVOs[i].setCreUsrId(account.getUsr_id());
					priSgCtrtCluzVOs[i].setUpdUsrId(account.getUsr_id());
					
					insertVoList.add(priSgCtrtCluzVOs[i]);
					
				} else if ( priSgCtrtCluzVOs[i].getIbflag().equals("U")){
					
					priSgCtrtCluzVOs[i].setCreUsrId(account.getUsr_id());
					priSgCtrtCluzVOs[i].setUpdUsrId(account.getUsr_id());
					
					updateVoList.add(priSgCtrtCluzVOs[i]);
					
				} else if ( priSgCtrtCluzVOs[i].getIbflag().equals("D")){

					log.debug(priSgCtrtCluzVOs[i].toString());
		
					deleteVoList.add(priSgCtrtCluzVOs[i]);

					dbDao.removeContractClauseDetailAll(priSgCtrtCluzVOs[i]);

					priSgCtrtCluzDtlVOs = null;
				}
				
			}
			
			//body
			for (int i = 0; priSgCtrtCluzDtlVOs != null && i < priSgCtrtCluzDtlVOs.length; i++) {
				
				if ( priSgCtrtCluzDtlVOs[i].getIbflag().equals("I")){

					priSgCtrtCluzDtlVOs[i].setCreUsrId(account.getUsr_id());
					priSgCtrtCluzDtlVOs[i].setUpdUsrId(account.getUsr_id());
					
					insertDtlVoList.add(priSgCtrtCluzDtlVOs[i]);
					
				} else if ( priSgCtrtCluzDtlVOs[i].getIbflag().equals("U")){
					
					priSgCtrtCluzDtlVOs[i].setCreUsrId(account.getUsr_id());
					priSgCtrtCluzDtlVOs[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(priSgCtrtCluzDtlVOs[i]);
					
				} else if ( priSgCtrtCluzDtlVOs[i].getIbflag().equals("D")){
					log.debug("getSvcScpCd " + priSgCtrtCluzDtlVOs[i].getSvcScpCd());
					log.debug("getGlineSeq " + priSgCtrtCluzDtlVOs[i].getGlineSeq());
					log.debug("getCtrtCluzDtlSeq " + priSgCtrtCluzDtlVOs[i].getCtrtCluzDtlSeq());
					
					deleteDtlVoList.add(priSgCtrtCluzDtlVOs[i]);
					
					
				}
				
			}
			
			
			if (deleteDtlVoList.size() > 0) {
				dbDao.removeContractClauseDetail(deleteDtlVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeContractClause(deleteVoList);
			}
			
			if (insertVoList.size() > 0) {
				dbDao.addContractClause(insertVoList);
			}
			if (insertDtlVoList.size() > 0) {
				dbDao.addContractClauseDetail(insertDtlVoList);
			}
			
			if (updateVoList.size() > 0) {
				dbDao.modifyContractClause(updateVoList);
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifyContractClauseDetail(updateDtlVoList);
			}
			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	
	/**
	 * handling multiple event<br>
	 * deleting contract clause title, body<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriSgMnVO priSgMnVO) throws EventException{
		try {
			
			if(priSgMnVO != null) {
				
				dbDao.removeContractClauseDetailAll(priSgMnVO);
				dbDao.removeContractClauseAll(priSgMnVO);
				
			}	
			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
}