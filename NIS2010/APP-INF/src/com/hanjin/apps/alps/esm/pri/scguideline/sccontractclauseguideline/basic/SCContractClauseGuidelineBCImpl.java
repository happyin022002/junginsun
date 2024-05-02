/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCContractClauseGuidelineBCImpl.java
*@FileTitle : SC Guideline Contract Clause
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.04.28 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.sccontractclauseguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.scguideline.sccontractclauseguideline.integration.SCContractClauseGuidelineDBDAO;
import com.hanjin.apps.alps.esm.pri.scguideline.sccontractclauseguideline.vo.CtrtCluzGlineVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSgCtrtCluzDtlVO;
import com.hanjin.syscommon.common.table.PriSgCtrtCluzVO;
import com.hanjin.syscommon.common.table.PriSgMnVO;

/**
 * NIS2010-SCGuideline Business Logic Basic Command implementation<br>
 * - NIS2010-SCGuideline에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Seung Jun Lee
 * @see ESM_PRI_0001_07EventResponse,SCContractClauseGuidelineBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class SCContractClauseGuidelineBCImpl extends BasicCommandSupport implements SCContractClauseGuidelineBC {

	// Database Access Object
	private transient SCContractClauseGuidelineDBDAO dbDao = null;

	/**
	 * SCContractClauseGuidelineBCImpl 객체 생성<br>
	 * SCContractClauseGuidelineDBDAO를 생성한다.<br>
	 */
	public SCContractClauseGuidelineBCImpl() {
		dbDao = new SCContractClauseGuidelineDBDAO();
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 *  SCBasicStandardNoteGuideline화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param PriSgCtrtCluzVO priSgCtrtCluzVO
	 * @param String searchGubun
	 * @return CtrtCluzGlineVO
	 * @exception EventException
	 */
	public CtrtCluzGlineVO searchContractClauseGuidelineList(PriSgCtrtCluzVO priSgCtrtCluzVO, String searchGubun) throws EventException {
		try {
			//컨테이너 vo
			CtrtCluzGlineVO ctrtCluzGlineVO = new CtrtCluzGlineVO();
			//타이틀, 바디
			List<PriSgCtrtCluzVO> priSgCtrtClusVOList 		= new ArrayList<PriSgCtrtCluzVO>();
			List<PriSgCtrtCluzDtlVO> priSgCtrtClusDtlVOList = new ArrayList<PriSgCtrtCluzDtlVO>();
	
			
			//각 리스트를 받아서 컨테이너 vo에 담는다
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
	 * 멀티 이벤트 처리<br>
	 * contract clause를 저장한다<br>
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
			
			//컨테이너 vo에서 타이틀,본문을 뺀다
			priSgCtrtCluzVOs 		= ctrtCluzGlineVO.getPriSgCtrtCluzVOs();
			priSgCtrtCluzDtlVOs 	= ctrtCluzGlineVO.getPriSgCtrtCluzDtlVOs();
			
			//타이틀
			List<PriSgCtrtCluzVO> insertVoList = new ArrayList<PriSgCtrtCluzVO>();
			List<PriSgCtrtCluzVO> updateVoList = new ArrayList<PriSgCtrtCluzVO>();
			List<PriSgCtrtCluzVO> deleteVoList = new ArrayList<PriSgCtrtCluzVO>();
			//본문
			List<PriSgCtrtCluzDtlVO> insertDtlVoList = new ArrayList<PriSgCtrtCluzDtlVO>();
			List<PriSgCtrtCluzDtlVO> updateDtlVoList = new ArrayList<PriSgCtrtCluzDtlVO>();
			List<PriSgCtrtCluzDtlVO> deleteDtlVoList = new ArrayList<PriSgCtrtCluzDtlVO>();
			
			////////////////////////////타이틀 / 본문 저장/////////////////////////////////////	
			
			//타이틀 
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
					log.debug("////////////////////////////타이틀 / 본문 저장/////////////////////////////////////");
					log.debug(priSgCtrtCluzVOs[i].toString());
					log.debug("////////////////////////////타이틀 / 본문 저장/////////////////////////////////////");
					
					deleteVoList.add(priSgCtrtCluzVOs[i]);
					//본문별 디테일 삭제
					dbDao.removeContractClauseDetailAll(priSgCtrtCluzVOs[i]);
					//디테일을 이미 삭제 했으므로 널로 세팅
					priSgCtrtCluzDtlVOs = null;
				}
				
			}
			
			//본문
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
					log.debug("////////////////////////////타이틀222 본문 저장/////////////////////////////////////");
					log.debug("getSvcScpCd " + priSgCtrtCluzDtlVOs[i].getSvcScpCd());
					log.debug("getGlineSeq " + priSgCtrtCluzDtlVOs[i].getGlineSeq());
					log.debug("getCtrtCluzDtlSeq " + priSgCtrtCluzDtlVOs[i].getCtrtCluzDtlSeq());
					log.debug("////////////////////////////타이틀 222 본문 저장/////////////////////////////////////");
					
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
	 * 멀티 이벤트 처리<br>
	 * contract clause  타이틀, 본문을 삭제한다<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriSgMnVO priSgMnVO) throws EventException{
		try {
			
			//헤더 별 모든 데이터를 삭제한다
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