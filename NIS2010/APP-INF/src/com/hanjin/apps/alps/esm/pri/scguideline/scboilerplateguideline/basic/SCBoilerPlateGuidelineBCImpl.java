/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBoilerPlateGuidelineBCImpl.java
*@FileTitle : Boiler Plate Guideline
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.04.27 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.integration.SCBoilerPlateGuidelineDBDAO;
import com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.vo.PriSgBlplExcelVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.vo.RsltPriSgBlplHdrCopyVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.vo.ScBlplGlineVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSgBlplCtntVO;
import com.hanjin.syscommon.common.table.PriSgBlplHdrVO;
import com.hanjin.syscommon.common.table.PriSgBlplVO;

/**
 * NIS2010-SCGuideline Business Logic Basic Command implementation<br>
 * - NIS2010-SCGuideline에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Seung Jun Lee
 * @see ESM_PRI_0007EventResponse,SCBoilerPlateGuidelineBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class SCBoilerPlateGuidelineBCImpl extends BasicCommandSupport implements SCBoilerPlateGuidelineBC {

	// Database Access Object
	private transient SCBoilerPlateGuidelineDBDAO dbDao = null;

	/**
	 * SCBoilerPlateGuidelineBCImpl 객체 생성<br>
	 * SCBoilerPlateGuidelineDBDAO를 생성한다.<br>
	 */
	public SCBoilerPlateGuidelineBCImpl() {
		dbDao = new SCBoilerPlateGuidelineDBDAO();
	}
	
	
	/**
	 * 보일러 헤더 항목을 조회한다<br>
	 * 
	 * @param PriSgBlplHdrVO priSgBlplHdrVO
	 * @return ScBlplGlineVO
	 * @exception EventException
	 */
	public ScBlplGlineVO searchBoilerPlateGuidelineHdrList(PriSgBlplHdrVO priSgBlplHdrVO) throws EventException {
		try {
			//컨테이너 vo
			ScBlplGlineVO scBlplGlineVO = new ScBlplGlineVO();
			//노트 헤드,타이틀, 바디
			List<PriSgBlplHdrVO> priSgBlplHdrVOList 	= new ArrayList<PriSgBlplHdrVO>();
			
			
			log.debug("*********************************************************");
			log.debug("priSgBlplHdrVO : " + priSgBlplHdrVO.getBlplRefYr());
			log.debug("*********************************************************");
				
			priSgBlplHdrVOList 		= dbDao.searchBoilerPlateHeader(priSgBlplHdrVO);
			scBlplGlineVO.setPriSgBlplHdrVOList(priSgBlplHdrVOList);
		
			return scBlplGlineVO;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * 보일러 타이틀, 본문 항목을 조회한다<br>
	 * 
	 * @param PriSgBlplVO priSgBlplVO
	 * @param String searchGubun
	 * @return ScBlplGlineVO
	 * @exception EventException
	 */
	public ScBlplGlineVO searchBoilerPlateGuidelineList(PriSgBlplVO priSgBlplVO, String searchGubun) throws EventException {
		try {
			//컨테이너 vo
			ScBlplGlineVO scBlplGlineVO = new ScBlplGlineVO();
			//노트 헤드,타이틀, 바디
			List<PriSgBlplHdrVO> priSgBlplHdrVOList 	= new ArrayList<PriSgBlplHdrVO>();
			List<PriSgBlplVO> priSgBlplVOList 		= new ArrayList<PriSgBlplVO>();
			List<PriSgBlplCtntVO> priSgBlplCtntVOList = new ArrayList<PriSgBlplCtntVO>();
			
			//각 리스트를 받아서 컨테이너 vo에 담는다
			if("1".equals(searchGubun)) {
				
				priSgBlplHdrVOList 		= dbDao.searchBoilerPlateHeader(priSgBlplVO);
				scBlplGlineVO.setPriSgBlplHdrVOList(priSgBlplHdrVOList);
			}	
			else if("2".equals(searchGubun)) {
				priSgBlplVOList 		= dbDao.searchBoilerPlateList(priSgBlplVO);
				scBlplGlineVO.setPriSgBlplVOList(priSgBlplVOList);
			}	
			else if("3".equals(searchGubun)) {				
				priSgBlplCtntVOList 	= dbDao.searchBoilerPlateContentList(priSgBlplVO);
				scBlplGlineVO.setPriSgBlplCtntVOList(priSgBlplCtntVOList);
			}
			//다 받는다
			else if("4".equals(searchGubun)) {
				
				priSgBlplVOList 		= dbDao.searchBoilerPlateList(priSgBlplVO);
				scBlplGlineVO.setPriSgBlplVOList(priSgBlplVOList);
				
				priSgBlplCtntVOList 	= dbDao.searchBoilerPlateContentList(priSgBlplVO);
				scBlplGlineVO.setPriSgBlplCtntVOList(priSgBlplCtntVOList);
			}
			
			return scBlplGlineVO;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * 보일러 플레이트 정보를 저장한다<br>
	 * 
	 * @param ScBlplGlineVO scBlplGlineVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBoilerPlateGuideline(ScBlplGlineVO scBlplGlineVO, SignOnUserAccount account) throws EventException{
		try {
		
			//vo
			PriSgBlplHdrVO    priSgBlplHdrVO = null;
			PriSgBlplVO[] 	  priSgBlplVOs = null;
			PriSgBlplCtntVO[] priSgBlplCtntVOs = null;
			
			//컨테이너 vo에서 헤더,타이틀,본문을 뺀다
			priSgBlplHdrVO 		= scBlplGlineVO.getPriSgBlplHdrVO();
			priSgBlplVOs 		= scBlplGlineVO.getPriSgBlplVOs();
			priSgBlplCtntVOs 	= scBlplGlineVO.getPriSgBlplCtntVOs();
			
			//타이틀
			List<PriSgBlplVO> insertVoList = new ArrayList<PriSgBlplVO>();
			List<PriSgBlplVO> updateVoList = new ArrayList<PriSgBlplVO>();
			List<PriSgBlplVO> deleteVoList = new ArrayList<PriSgBlplVO>();
			//본문
			List<PriSgBlplCtntVO> insertDtlVoList = new ArrayList<PriSgBlplCtntVO>();
			List<PriSgBlplCtntVO> updateDtlVoList = new ArrayList<PriSgBlplCtntVO>();
			List<PriSgBlplCtntVO> deleteDtlVoList = new ArrayList<PriSgBlplCtntVO>();
			
			////////////////////////////헤더 저장/////////////////////////////////////////////
			
			//헤더 시퀀스
			int blplHdrSeq = 1;
			
			//헤더
			if(priSgBlplHdrVO != null) {
				//입력이면 max seq를 조회한 후 등록
				if(priSgBlplHdrVO.getBlplHdrSeq() == null || "".equals(priSgBlplHdrVO.getBlplHdrSeq()) ) {
					
					/////////////////////////////년도체크///////////////////////////////////////////////
					int chk = dbDao.searchCheckBoilerPlateHdrCheckYear(priSgBlplHdrVO);
					
					if (chk > 0) {
						throw new EventException(new ErrorHandler("PRI08018").getMessage());
					}
					/////////////////////////////기간체크///////////////////////////////////////////////
					
					/////////////////////////////기간체크///////////////////////////////////////////////
					chk = dbDao.searchCheckBoilerPlateHdrCheckDate(priSgBlplHdrVO);
					
					if (chk > 0) {
						throw new EventException(new ErrorHandler("PRI08018").getMessage());
					}
					/////////////////////////////기간체크///////////////////////////////////////////////
					
					blplHdrSeq = dbDao.searchBoilerPlateHdrMaxSeq(priSgBlplHdrVO);
					
					priSgBlplHdrVO.setBlplHdrSeq(String.valueOf(blplHdrSeq));
					priSgBlplHdrVO.setCreUsrId(account.getUsr_id());
					priSgBlplHdrVO.setUpdUsrId(account.getUsr_id());
					
					dbDao.addBoilerPlateHeader(priSgBlplHdrVO);
				}
				//수정
				else {
					/////////////////////////////기간체크///////////////////////////////////////////////
					int chk = dbDao.searchCheckBoilerPlateHdrCheckDate(priSgBlplHdrVO);
					
					if (chk > 0) {
						throw new EventException(new ErrorHandler("PRI08018").getMessage());
					}
					/////////////////////////////기간체크///////////////////////////////////////////////
					
					//헤더 시퀀스
					blplHdrSeq = Integer.parseInt(priSgBlplHdrVO.getBlplHdrSeq());
					priSgBlplHdrVO.setCreUsrId(account.getUsr_id());
					priSgBlplHdrVO.setUpdUsrId(account.getUsr_id());
					dbDao.modifyBoilerPlateHeader(priSgBlplHdrVO);
				}
			}
			
			////////////////////////////헤더 저장/////////////////////////////////////////////
			
			////////////////////////////타이틀 / 본문 저장/////////////////////////////////////	
		
			//타이틀 
			for (int i = 0; priSgBlplVOs != null && i < priSgBlplVOs.length; i++) {
				if ( priSgBlplVOs[i].getIbflag().equals("I")){
					priSgBlplVOs[i].setBlplHdrSeq(String.valueOf(blplHdrSeq));
					
					priSgBlplVOs[i].setCreUsrId(account.getUsr_id());
					priSgBlplVOs[i].setUpdUsrId(account.getUsr_id());
					
					insertVoList.add(priSgBlplVOs[i]);
				} else if ( priSgBlplVOs[i].getIbflag().equals("U")){
					priSgBlplVOs[i].setCreUsrId(account.getUsr_id());
					priSgBlplVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSgBlplVOs[i]);
				} else if ( priSgBlplVOs[i].getIbflag().equals("D")){
					deleteVoList.add(priSgBlplVOs[i]);
					//본문별 디테일 삭제
					dbDao.removeBoilerPlateContent(priSgBlplVOs[i]);
					//디테일을 이미 삭제 했으므로 널로 세팅
					priSgBlplCtntVOs = null;
				}
			}
			
			//본문
			for (int i = 0; priSgBlplCtntVOs != null && i < priSgBlplCtntVOs.length; i++) {
				if ( priSgBlplCtntVOs[i].getIbflag().equals("I")){
					priSgBlplCtntVOs[i].setBlplHdrSeq(String.valueOf(blplHdrSeq));
					
					priSgBlplCtntVOs[i].setCreUsrId(account.getUsr_id());
					priSgBlplCtntVOs[i].setUpdUsrId(account.getUsr_id());
					
					insertDtlVoList.add(priSgBlplCtntVOs[i]);
				} else if ( priSgBlplCtntVOs[i].getIbflag().equals("U")){
					priSgBlplCtntVOs[i].setCreUsrId(account.getUsr_id());
					priSgBlplCtntVOs[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(priSgBlplCtntVOs[i]);
				} else if ( priSgBlplCtntVOs[i].getIbflag().equals("D")){
					deleteDtlVoList.add(priSgBlplCtntVOs[i]);
				}
			}
			
			if (deleteDtlVoList.size() > 0) {
				dbDao.removeBoilerPlateContent(deleteDtlVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeBoilerPlate(deleteVoList);
			}
			
			if (insertVoList.size() > 0) {
				dbDao.addBoilerPlate(insertVoList);
			}
			if (insertDtlVoList.size() > 0) {
				dbDao.addBoilerPlateContent(insertDtlVoList);
			}
			
			if (updateVoList.size() > 0) {
				dbDao.modifyBoilerPlate(updateVoList);
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifyBoilerPlateContent(updateDtlVoList);
			}
			
		} catch(EventException ex) {
			throw ex;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}	
	}
	
	/**
	 * 사용자가 노트를 컨폼한다<br>
	 * 
	 * @param PriSgBlplHdrVO priSgBlplHdrVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmBoilerPlateGuideline(PriSgBlplHdrVO priSgBlplHdrVO, SignOnUserAccount account) throws EventException{
		try {
			priSgBlplHdrVO.setCfmFlg("Y");
			priSgBlplHdrVO.setCfmUsrId(account.getUsr_id());
			priSgBlplHdrVO.setUpdUsrId(account.getUsr_id());
			
			dbDao.modifyConfirmBoilerPlate(priSgBlplHdrVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * 사용자가 노트를 컨폼 cancel한다<br>
	 * 
	 * @param PriSgBlplHdrVO priSgBlplHdrVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelBoilerPlateGuideline(PriSgBlplHdrVO priSgBlplHdrVO, SignOnUserAccount account) throws EventException{
		try {
			priSgBlplHdrVO.setCfmFlg("N");
			priSgBlplHdrVO.setCfmUsrId(account.getUsr_id());
			priSgBlplHdrVO.setUpdUsrId(account.getUsr_id());
			
			dbDao.modifyConfirmBoilerPlate(priSgBlplHdrVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	
	
	/**
	 * 보일러 플레이트 전체를 삭제한다<br>
	 * 
	 * @param PriSgBlplHdrVO priSgBlplHdrVO
	 * @exception EventException
	 */
	public void removeBoilerPlateGuideline(PriSgBlplHdrVO priSgBlplHdrVO) throws EventException{
		try {
			
			//헤더 별 모든 데이터를 삭제한다
			if(priSgBlplHdrVO != null) {
				
				dbDao.removeBoilerPlateContent(priSgBlplHdrVO);
				dbDao.removeBoilerPlate(priSgBlplHdrVO);
				dbDao.removeBoilerPlateHeader(priSgBlplHdrVO);
				
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
	 * 선택된 보일러 플레이트를 카피한다<br>
	 * 
	 * @param RsltPriSgBlplHdrCopyVO rsltPriSgBlplHdrCopyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyBoilerPlateGuideline(RsltPriSgBlplHdrCopyVO rsltPriSgBlplHdrCopyVO, SignOnUserAccount account) throws EventException{
		try {
			//header vo
			PriSgBlplHdrVO priSgBlplHdrVO  = new PriSgBlplHdrVO();
			
			priSgBlplHdrVO.setEffDt(rsltPriSgBlplHdrCopyVO.getEffDt());
			priSgBlplHdrVO.setExpDt(rsltPriSgBlplHdrCopyVO.getExpDt());
			priSgBlplHdrVO.setBlplRefYr(rsltPriSgBlplHdrCopyVO.getBlplRefYr());
			
			/////////////////////////////년도체크///////////////////////////////////////////////		
			int chk = dbDao.searchCheckBoilerPlateHdrCheckYear(priSgBlplHdrVO);
			
			if (chk > 0) {
				throw new EventException(new ErrorHandler("PRI08018").getMessage());
			}
			/////////////////////////////기간체크///////////////////////////////////////////////

			
			/////////////////////////////기간체크///////////////////////////////////////////////
			chk = dbDao.searchCheckBoilerPlateHdrCheckDate(priSgBlplHdrVO);
			
			if (chk > 0) {
				throw new EventException(new ErrorHandler("PRI08018").getMessage());
			}
			/////////////////////////////기간체크///////////////////////////////////////////////
			
			
			////////////////////////////헤더 저장/////////////////////////////////////////////
			
			//헤더 시퀀스
			int blplHdrSeq = 1;
			
			//헤더
			if(rsltPriSgBlplHdrCopyVO != null) {
				
				//max seq를 조회한 후 등록	
				blplHdrSeq = dbDao.searchBoilerPlateHdrMaxSeq(priSgBlplHdrVO);
				priSgBlplHdrVO.setBlplHdrSeq(String.valueOf(blplHdrSeq));
				
				priSgBlplHdrVO.setCfmFlg("N");
				
				priSgBlplHdrVO.setCreUsrId(account.getUsr_id());
				priSgBlplHdrVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addBoilerPlateHeader(priSgBlplHdrVO);
				
			}
			
			////////////////////////////헤더 저장/////////////////////////////////////////////
			
			////////////////////////////타이틀 저장/////////////////////////////////////////////
			
			//타이틀
			if(rsltPriSgBlplHdrCopyVO != null) {
				//header seq setting
				rsltPriSgBlplHdrCopyVO.setBlplHdrSeq(String.valueOf(blplHdrSeq));
				rsltPriSgBlplHdrCopyVO.setCfmFlg("N");
				
				rsltPriSgBlplHdrCopyVO.setCreUsrId(account.getUsr_id());
				rsltPriSgBlplHdrCopyVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addCopyBoilerPlate(rsltPriSgBlplHdrCopyVO);
				
			}
			
			////////////////////////////타이틀 저장/////////////////////////////////////////////
			
			
			////////////////////////////본문 저장/////////////////////////////////////////////
			
			//타이틀
			if(rsltPriSgBlplHdrCopyVO != null) {
				
				rsltPriSgBlplHdrCopyVO.setCreUsrId(account.getUsr_id());
				rsltPriSgBlplHdrCopyVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addCopyBoilerPlateContent(rsltPriSgBlplHdrCopyVO);
				
			}
			
			////////////////////////////본문 저장/////////////////////////////////////////////
			
		} catch(EventException ex) {
			throw ex;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}	
	}
	
	
	
	/**
	 *  Boiler Plate Guideline Header를 조회합니다.<br>
	 * 
	 * @param PriSgBlplHdrVO priSgBlplHdrVO
	 * @return ScBlplGlineVO
	 * @exception EventException
	 */
	public ScBlplGlineVO searchBoilerPlateGuidelineHdrInquiryList(PriSgBlplHdrVO priSgBlplHdrVO) throws EventException {
		try {
			//컨테이너 vo
			ScBlplGlineVO scBlplGlineVO = new ScBlplGlineVO();
			//노트 헤드,타이틀, 바디
			List<PriSgBlplHdrVO> priSgBlplHdrVOList 	= new ArrayList<PriSgBlplHdrVO>();
				
			priSgBlplHdrVOList 		= dbDao.searchBoilerPlateHeaderInquiry(priSgBlplHdrVO);
			scBlplGlineVO.setPriSgBlplHdrVOList(priSgBlplHdrVOList);
		
			return scBlplGlineVO;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 *  Boiler Plate Guideline List를 조회합니다.<br>
	 * 
	 * @param PriSgBlplVO priSgBlplVO
	 * @param String searchGubun
	 * @return ScBlplGlineVO
	 * @exception EventException
	 */
	public ScBlplGlineVO searchBoilerPlateGuidelineInquiryList(PriSgBlplVO priSgBlplVO, String searchGubun) throws EventException {
		try {
			//컨테이너 vo
			ScBlplGlineVO scBlplGlineVO = new ScBlplGlineVO();
			//노트 헤드,타이틀, 바디
			List<PriSgBlplHdrVO> priSgBlplHdrVOList 	= new ArrayList<PriSgBlplHdrVO>();
			List<PriSgBlplVO> priSgBlplVOList 		= new ArrayList<PriSgBlplVO>();
			List<PriSgBlplCtntVO> priSgBlplCtntVOList = new ArrayList<PriSgBlplCtntVO>();
			
			//각 리스트를 받아서 컨테이너 vo에 담는다
			if("1".equals(searchGubun)) {
				
				priSgBlplHdrVOList 		= dbDao.searchBoilerPlateHeaderInquiry(priSgBlplVO);
				scBlplGlineVO.setPriSgBlplHdrVOList(priSgBlplHdrVOList);
			}	
			else if("2".equals(searchGubun)) {
				priSgBlplVOList 		= dbDao.searchBoilerPlateInquiryList(priSgBlplVO);
				scBlplGlineVO.setPriSgBlplVOList(priSgBlplVOList);
			}	
			else if("3".equals(searchGubun)) {
				
				priSgBlplCtntVOList 	= dbDao.searchBoilerPlateContentInquiryList(priSgBlplVO);
				scBlplGlineVO.setPriSgBlplCtntVOList(priSgBlplCtntVOList);
			}
			//다 받는다
			else if("4".equals(searchGubun)) {
				
				priSgBlplVOList 		= dbDao.searchBoilerPlateInquiryList(priSgBlplVO);
				scBlplGlineVO.setPriSgBlplVOList(priSgBlplVOList);
				
				priSgBlplCtntVOList 	= dbDao.searchBoilerPlateContentInquiryList(priSgBlplVO);
				scBlplGlineVO.setPriSgBlplCtntVOList(priSgBlplCtntVOList);
			}
			
			return scBlplGlineVO;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
     * Boiler Plate Header Year를 조회합니다.<br>
	 * 
	 * @param PriSgBlplHdrVO priSgBlplHdrVO
	 * @return List<PriSgBlplHdrVO>
	 * @exception EventException
	 */
	public List<PriSgBlplHdrVO> searchBoilerPlateGuidelineInquiryYear(PriSgBlplHdrVO priSgBlplHdrVO) throws EventException {
		try {			
			return dbDao.searchBoilerPlateGuidelineInquiryYear(priSgBlplHdrVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	
	/**
     * Boiler Plate Header Duration을 조회합니다.<br>
	 * 
	 * @param PriSgBlplHdrVO priSgBlplHdrVO
	 * @return List<PriSgBlplHdrVO>
	 * @exception EventException
	 */
	public List<PriSgBlplHdrVO> searchBoilerPlateGuidelineInquiryDuration(PriSgBlplHdrVO priSgBlplHdrVO) throws EventException {
		try {			
			return dbDao.searchBoilerPlateGuidelineInquiryDuration(priSgBlplHdrVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	

    /**
     * Excel 로 저장할 Boiler Plate 정보를 조회합니다.<br>
     * 
     * @param PriSgBlplHdrVO priSgBlplHdrVO
     * @return List<PriSgBlplExcelVO>
     * @exception EventException
     */
    public List<PriSgBlplExcelVO> searchBoilerPlateGuidelineListExcel(PriSgBlplHdrVO priSgBlplHdrVO) throws EventException {
        try {
            return dbDao.searchBoilerPlateGuidelineListExcel(priSgBlplHdrVO);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), de);
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), de);
        }
    }
}