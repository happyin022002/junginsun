/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBoilerPlateGuidelineBCImpl.java
*@FileTitle : Boiler Plate Guideline
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.integration.SCBoilerPlateGuidelineDBDAO;
import com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.vo.PriSgBlplExcelVO;
import com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.vo.RsltPriSgBlplHdrCopyVO;
import com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.vo.ScBlplGlineVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSgBlplCtntVO;
import com.clt.syscommon.common.table.PriSgBlplHdrVO;
import com.clt.syscommon.common.table.PriSgBlplVO;

/**
 * SCGuideline Business Logic Basic Command implementation<br>
 * - handling biz logic about SCGuideline<br>
 *
 * @author  
 * @see ESM_PRI_0007EventResponse,SCBoilerPlateGuidelineBC reference each DAO class
 * @since J2EE 1.4
 */

public class SCBoilerPlateGuidelineBCImpl extends BasicCommandSupport implements SCBoilerPlateGuidelineBC {

	// Database Access Object
	private transient SCBoilerPlateGuidelineDBDAO dbDao = null;

	/**
	 * SCBoilerPlateGuidelineBCImpl object creation<br>
	 * creating SCBoilerPlateGuidelineDBDAO<br>
	 */
	public SCBoilerPlateGuidelineBCImpl() {
		dbDao = new SCBoilerPlateGuidelineDBDAO();
	}
	
	
	/**
	 * Boiler Plate Guide Line Header  retrieving<br>
	 * 
	 * @param PriSgBlplHdrVO priSgBlplHdrVO
	 * @return ScBlplGlineVO
	 * @exception EventException
	 */
	public ScBlplGlineVO searchBoilerPlateGuidelineHdrList(PriSgBlplHdrVO priSgBlplHdrVO) throws EventException {
		try {
			//container vo
			ScBlplGlineVO scBlplGlineVO = new ScBlplGlineVO();

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
	 * retrieving Boiler Plate to save excel file<br>
	 * 
	 * @param PriSgBlplVO priSgBlplVO
	 * @param String searchGubun
	 * @return ScBlplGlineVO
	 * @exception EventException
	 */
	public ScBlplGlineVO searchBoilerPlateGuidelineList(PriSgBlplVO priSgBlplVO, String searchGubun) throws EventException {
		try {
			//container vo
			ScBlplGlineVO scBlplGlineVO = new ScBlplGlineVO();
			
			List<PriSgBlplHdrVO> priSgBlplHdrVOList 	= new ArrayList<PriSgBlplHdrVO>();
			List<PriSgBlplVO> priSgBlplVOList 		= new ArrayList<PriSgBlplVO>();
			List<PriSgBlplCtntVO> priSgBlplCtntVOList = new ArrayList<PriSgBlplCtntVO>();
			
			
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
     * check to S/C(PRI_SP_MN Table) in use <br>
     *
     * @param PriSgBlplHdrVO priSgBlplHdrVO
     * @return int
     * @exception EventException
     * @LastModifyDate : 2014.10.07
     */
	public int checkBoilerPlateGuidelineUse(PriSgBlplHdrVO priSgBlplHdrVO) throws EventException {
		int chk = 0;
		try {
			chk = dbDao.checkBoilerPlateGuidelineUse(priSgBlplHdrVO);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
		return chk;
	}
	
	/**
	 * Boiler Plate Guideline saving <br>
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
			
			
			priSgBlplHdrVO 		= scBlplGlineVO.getPriSgBlplHdrVO();
			priSgBlplVOs 		= scBlplGlineVO.getPriSgBlplVOs();
			priSgBlplCtntVOs 	= scBlplGlineVO.getPriSgBlplCtntVOs();
			
			//title
			List<PriSgBlplVO> insertVoList = new ArrayList<PriSgBlplVO>();
			List<PriSgBlplVO> updateVoList = new ArrayList<PriSgBlplVO>();
			List<PriSgBlplVO> deleteVoList = new ArrayList<PriSgBlplVO>();
			//body
			List<PriSgBlplCtntVO> insertDtlVoList = new ArrayList<PriSgBlplCtntVO>();
			List<PriSgBlplCtntVO> updateDtlVoList = new ArrayList<PriSgBlplCtntVO>();
			List<PriSgBlplCtntVO> deleteDtlVoList = new ArrayList<PriSgBlplCtntVO>();
			
			////////////////////////////saving header/////////////////////////////////////////////
			
			//header sequence
			int blplHdrSeq = 1;
			
			//header
			if(priSgBlplHdrVO != null) {
		
				if(priSgBlplHdrVO.getBlplHdrSeq() == null || "".equals(priSgBlplHdrVO.getBlplHdrSeq()) ) {
					
					/////////////////////////////checking year///////////////////////////////////////////////
					int chk = dbDao.searchCheckBoilerPlateHdrCheckYear(priSgBlplHdrVO);
					
					if (chk > 0) {
						throw new EventException(new ErrorHandler("PRI08018").getMessage());
					}
					/////////////////////////////checking date///////////////////////////////////////////////
					
					/////////////////////////////checking date///////////////////////////////////////////////
					chk = dbDao.searchCheckBoilerPlateHdrCheckDate(priSgBlplHdrVO);
					
					if (chk > 0) {
						throw new EventException(new ErrorHandler("PRI08018").getMessage());
					}
					/////////////////////////////checking date///////////////////////////////////////////////
					
					blplHdrSeq = dbDao.searchBoilerPlateHdrMaxSeq(priSgBlplHdrVO);
					
					priSgBlplHdrVO.setBlplHdrSeq(String.valueOf(blplHdrSeq));
					priSgBlplHdrVO.setCreUsrId(account.getUsr_id());
					priSgBlplHdrVO.setUpdUsrId(account.getUsr_id());
					
					dbDao.addBoilerPlateHeader(priSgBlplHdrVO);
				}
				//modifying
				else {
					/////////////////////////////checking date///////////////////////////////////////////////
					int chk = dbDao.searchCheckBoilerPlateHdrCheckDate(priSgBlplHdrVO);
					
					if (chk > 0) {
						throw new EventException(new ErrorHandler("PRI08018").getMessage());
					}
					/////////////////////////////checking date///////////////////////////////////////////////
					
					//header sequence
					blplHdrSeq = Integer.parseInt(priSgBlplHdrVO.getBlplHdrSeq());
					priSgBlplHdrVO.setCreUsrId(account.getUsr_id());
					priSgBlplHdrVO.setUpdUsrId(account.getUsr_id());
					dbDao.modifyBoilerPlateHeader(priSgBlplHdrVO);
				}
			}
			
			////////////////////////////saving header/////////////////////////////////////////////
			
			////////////////////////////title / saving body/////////////////////////////////////	
		
			//title 
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
					
					dbDao.removeBoilerPlateContent(priSgBlplVOs[i]);

					priSgBlplCtntVOs = null;
				}
			}
			
			//body
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
	 * Note confirming <br>
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
	 * Note confirming cancel <br>
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
	 * deleting all Boiler Plate<br>
	 * 
	 * @param PriSgBlplHdrVO priSgBlplHdrVO
	 * @exception EventException
	 */
	public void removeBoilerPlateGuideline(PriSgBlplHdrVO priSgBlplHdrVO) throws EventException{
		try {

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
	 * copying selected Boiler Plate<br>
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
			
			/////////////////////////////checking year///////////////////////////////////////////////		
			int chk = dbDao.searchCheckBoilerPlateHdrCheckYear(priSgBlplHdrVO);
			
			if (chk > 0) {
				throw new EventException(new ErrorHandler("PRI08018").getMessage());
			}
			/////////////////////////////checking date///////////////////////////////////////////////

			
			/////////////////////////////checking date///////////////////////////////////////////////
			chk = dbDao.searchCheckBoilerPlateHdrCheckDate(priSgBlplHdrVO);
			
			if (chk > 0) {
				throw new EventException(new ErrorHandler("PRI08018").getMessage());
			}
			/////////////////////////////checking date///////////////////////////////////////////////
			
			
			////////////////////////////saving header/////////////////////////////////////////////
			
			//header sequence
			int blplHdrSeq = 1;
			
			//header
			if(rsltPriSgBlplHdrCopyVO != null) {

				blplHdrSeq = dbDao.searchBoilerPlateHdrMaxSeq(priSgBlplHdrVO);
				priSgBlplHdrVO.setBlplHdrSeq(String.valueOf(blplHdrSeq));
				
				priSgBlplHdrVO.setCfmFlg("N");
				
				priSgBlplHdrVO.setCreUsrId(account.getUsr_id());
				priSgBlplHdrVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addBoilerPlateHeader(priSgBlplHdrVO);
				
			}
			
			////////////////////////////saving header/////////////////////////////////////////////
			
			////////////////////////////saving title/////////////////////////////////////////////
			
			//title
			if(rsltPriSgBlplHdrCopyVO != null) {
				//header seq setting
				rsltPriSgBlplHdrCopyVO.setBlplHdrSeq(String.valueOf(blplHdrSeq));
				rsltPriSgBlplHdrCopyVO.setCfmFlg("N");
				
				rsltPriSgBlplHdrCopyVO.setCreUsrId(account.getUsr_id());
				rsltPriSgBlplHdrCopyVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addCopyBoilerPlate(rsltPriSgBlplHdrCopyVO);
				
			}
			
			////////////////////////////saving title/////////////////////////////////////////////
			
			
			////////////////////////////saving body/////////////////////////////////////////////
			
			//title
			if(rsltPriSgBlplHdrCopyVO != null) {
				
				rsltPriSgBlplHdrCopyVO.setCreUsrId(account.getUsr_id());
				rsltPriSgBlplHdrCopyVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addCopyBoilerPlateContent(rsltPriSgBlplHdrCopyVO);
				
			}
			
			////////////////////////////saving body/////////////////////////////////////////////
			
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
	 *  Boiler Plate Guideline Header retrieving<br>
	 * 
	 * @param PriSgBlplHdrVO priSgBlplHdrVO
	 * @return ScBlplGlineVO
	 * @exception EventException
	 */
	public ScBlplGlineVO searchBoilerPlateGuidelineHdrInquiryList(PriSgBlplHdrVO priSgBlplHdrVO) throws EventException {
		try {
			//container vo
			ScBlplGlineVO scBlplGlineVO = new ScBlplGlineVO();
			
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
	 *  Boiler Plate Guideline List retrieving<br>
	 * 
	 * @param PriSgBlplVO priSgBlplVO
	 * @param String searchGubun
	 * @return ScBlplGlineVO
	 * @exception EventException
	 */
	public ScBlplGlineVO searchBoilerPlateGuidelineInquiryList(PriSgBlplVO priSgBlplVO, String searchGubun) throws EventException {
		try {
			//container vo
			ScBlplGlineVO scBlplGlineVO = new ScBlplGlineVO();
			
			List<PriSgBlplHdrVO> priSgBlplHdrVOList 	= new ArrayList<PriSgBlplHdrVO>();
			List<PriSgBlplVO> priSgBlplVOList 		= new ArrayList<PriSgBlplVO>();
			List<PriSgBlplCtntVO> priSgBlplCtntVOList = new ArrayList<PriSgBlplCtntVO>();
			
			
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
     * Boiler Plate Header Year retrieving<br>
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
     * Boiler Plate Header Duration  retrieving<br>
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
     * retrieving Boiler Plate to save excel file<br>
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