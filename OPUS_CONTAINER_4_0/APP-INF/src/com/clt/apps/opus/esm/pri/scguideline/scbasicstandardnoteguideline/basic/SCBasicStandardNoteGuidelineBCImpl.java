/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBasicStandardNoteGuidelineBCImpl.java
*@FileTitle : Standard Note Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.integration.SCBasicStandardNoteGuidelineDBDAO;
import com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.vo.RsltPriSgStndNoteCtntVO;
import com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.vo.RsltPriSgStndNoteHdrCopyVO;
import com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.vo.StndNoteGlineVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSgStndNoteCtntVO;
import com.clt.syscommon.common.table.PriSgStndNoteHdrVO;
import com.clt.syscommon.common.table.PriSgStndNoteVO;

/**
 * SCGuideline Business Logic Basic Command implementation<br>
 * - handling biz logic about SCGuideline<br>
 *
 * @author 
 * @see ui_pri_0005EventResponse,SCBasicStandardNoteGuidelineBC reference each DAO class 
 * @since J2EE 1.4
 */

public class SCBasicStandardNoteGuidelineBCImpl extends BasicCommandSupport implements SCBasicStandardNoteGuidelineBC {

	// Database Access Object
	private transient SCBasicStandardNoteGuidelineDBDAO dbDao = null;

	/**
	 * SCBasicStandardNoteGuidelineBCImpl object creation <br>
	 * creating SCBasicStandardNoteGuidelineDBDAO<br>
	 */
	public SCBasicStandardNoteGuidelineBCImpl() {
		dbDao = new SCBasicStandardNoteGuidelineDBDAO();
	}
	
	
	/**
	 * Retrieving StndNote header information <br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
	 * @return StndNoteGlineVO
	 * @exception EventException
	 */
	public StndNoteGlineVO searchBasicStandardNoteGuidelineHdrList(PriSgStndNoteHdrVO priSgStndNoteHdrVO)throws EventException {
		try {

			StndNoteGlineVO stndNoteGlineVO = new StndNoteGlineVO();

			List<PriSgStndNoteHdrVO> priSgStndNoteHdr 	= new ArrayList<PriSgStndNoteHdrVO>();

				priSgStndNoteHdr 	= dbDao.searchNoteHeader(priSgStndNoteHdrVO);
				stndNoteGlineVO.setPriSgStndNoteHdr(priSgStndNoteHdr);	
			
			return stndNoteGlineVO;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving StndNote Duration<br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
	 * @return StndNoteGlineVO
	 * @exception EventException
	 */
	public StndNoteGlineVO searchBasicStandardNoteGuidelineHdrDurationList(PriSgStndNoteHdrVO priSgStndNoteHdrVO)throws EventException {
		try {

			StndNoteGlineVO stndNoteGlineVO = new StndNoteGlineVO();

			List<PriSgStndNoteHdrVO> priSgStndNoteHdr 	= new ArrayList<PriSgStndNoteHdrVO>();
			
				priSgStndNoteHdr 	= dbDao.searchNoteHeaderDuration(priSgStndNoteHdrVO);
				stndNoteGlineVO.setPriSgStndNoteHdr(priSgStndNoteHdr);
						
			return stndNoteGlineVO;
			
		}  catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving StndNote main, title and body information <br>
	 * 
	 * @param PriSgStndNoteVO priSgStndNoteVO
	 * @param String searchGubun
	 * @return StndNoteGlineVO
	 * @exception EventException
	 */
	public StndNoteGlineVO searchBasicStandardNoteGuidelineList(PriSgStndNoteVO priSgStndNoteVO, String searchGubun) throws EventException {
		try {

			StndNoteGlineVO stndNoteGlineVO = new StndNoteGlineVO();

			List<PriSgStndNoteHdrVO> priSgStndNoteHdr 	= new ArrayList<PriSgStndNoteHdrVO>();
			List<PriSgStndNoteVO> priSgStndNote 		= new ArrayList<PriSgStndNoteVO>();
			List<PriSgStndNoteCtntVO> priSgStndNoteCtnt = new ArrayList<PriSgStndNoteCtntVO>();
			
			if("1".equals(searchGubun)) {
				priSgStndNoteHdr 	= dbDao.searchNoteHeader(priSgStndNoteVO);
				stndNoteGlineVO.setPriSgStndNoteHdr(priSgStndNoteHdr);
			}	
			else if("2".equals(searchGubun)) {
				priSgStndNote 		= dbDao.searchNoteList(priSgStndNoteVO);
				stndNoteGlineVO.setPriSgStndNote(priSgStndNote);
			}	
			else if("3".equals(searchGubun)) {
				priSgStndNoteCtnt 	= dbDao.searchNoteContentList(priSgStndNoteVO);
				stndNoteGlineVO.setPriSgStndNoteCtnt(priSgStndNoteCtnt);
			}

			else if("4".equals(searchGubun)) {
				
				priSgStndNote 		= dbDao.searchNoteList(priSgStndNoteVO);
				stndNoteGlineVO.setPriSgStndNote(priSgStndNote);
				
				priSgStndNoteCtnt 	= dbDao.searchNoteContentList(priSgStndNoteVO);
				stndNoteGlineVO.setPriSgStndNoteCtnt(priSgStndNoteCtnt);
			}
			
			return stndNoteGlineVO;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving StndNote main, title and body information <br>
	 * 
	 * @param RsltPriSgStndNoteCtntVO rsltPriSgStndNoteCtntVO
	 * @return List<RsltPriSgStndNoteCtntVO>
	 * @exception EventException
	 */
	public List<RsltPriSgStndNoteCtntVO> searchBasicStandardNoteGuidelineExcelList(RsltPriSgStndNoteCtntVO rsltPriSgStndNoteCtntVO) throws EventException{
		try {
			return dbDao.searchBasicStandardNoteGuidelineExcelList(rsltPriSgStndNoteCtntVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
		
	
	
	
	/**
	 * Saving StndNote information<br>
	 * 
	 * @param StndNoteGlineVO stndNoteGlineVO
	 * @param SignOnUserAccount account
	 * @return PriSgStndNoteVO 
	 * @exception EventException
	 */
	public PriSgStndNoteVO manageBasicStandardNoteGuideline(StndNoteGlineVO stndNoteGlineVO, SignOnUserAccount account) throws EventException{
		try {
		
			PriSgStndNoteVO priSgStndNoteVO = new PriSgStndNoteVO();
			
			//vo
			PriSgStndNoteHdrVO    priSgStndNoteHdrVO = null;
			PriSgStndNoteVO[] 	  priSgStndNoteVOs = null;
			PriSgStndNoteCtntVO[] priSgStndNoteCtntVOs = null;

			priSgStndNoteHdrVO 		= stndNoteGlineVO.getPrisgstndnotehdrvo();
			priSgStndNoteVOs 		= stndNoteGlineVO.getPrisgstndnotevos();
			priSgStndNoteCtntVOs 	= stndNoteGlineVO.getPrisgstndnotectntvos();

			List<PriSgStndNoteVO> insertVoList = new ArrayList<PriSgStndNoteVO>();
			List<PriSgStndNoteVO> updateVoList = new ArrayList<PriSgStndNoteVO>();
			List<PriSgStndNoteVO> deleteVoList = new ArrayList<PriSgStndNoteVO>();

			List<PriSgStndNoteCtntVO> insertDtlVoList = new ArrayList<PriSgStndNoteCtntVO>();
			List<PriSgStndNoteCtntVO> updateDtlVoList = new ArrayList<PriSgStndNoteCtntVO>();
			List<PriSgStndNoteCtntVO> deleteDtlVoList = new ArrayList<PriSgStndNoteCtntVO>();
			
			int chk = dbDao.searchNoteHdrCheckDate(priSgStndNoteHdrVO);
			
			if (chk > 0) {
				throw new EventException(new ErrorHandler("PRI08018").getMessage());
			}

			int noteHdrSeq = 1;
			
			if(priSgStndNoteHdrVO != null) {

				if(priSgStndNoteHdrVO.getNoteHdrSeq() == null || "".equals(priSgStndNoteHdrVO.getNoteHdrSeq()) ) {
					
					noteHdrSeq = dbDao.searchNoteHdrMaxSeq(priSgStndNoteHdrVO);
					priSgStndNoteHdrVO.setNoteHdrSeq(String.valueOf(noteHdrSeq));
					priSgStndNoteHdrVO.setCreUsrId(account.getUsr_id());
					priSgStndNoteHdrVO.setUpdUsrId(account.getUsr_id());
					
					dbDao.addNoteHeader(priSgStndNoteHdrVO);
				}

				else {
					noteHdrSeq = Integer.parseInt(priSgStndNoteHdrVO.getNoteHdrSeq());
					priSgStndNoteHdrVO.setCreUsrId(account.getUsr_id());
					priSgStndNoteHdrVO.setUpdUsrId(account.getUsr_id());
					dbDao.modifyNoteHeader(priSgStndNoteHdrVO);
				}
			}

			for (int i = 0; priSgStndNoteVOs != null && i < priSgStndNoteVOs.length; i++) {
				if ( priSgStndNoteVOs[i].getIbflag().equals("I")){
					priSgStndNoteVOs[i].setNoteHdrSeq(String.valueOf(noteHdrSeq));
					priSgStndNoteVOs[i].setCreUsrId(account.getUsr_id());
					priSgStndNoteVOs[i].setUpdUsrId(account.getUsr_id());
					
					insertVoList.add(priSgStndNoteVOs[i]);
				} else if ( priSgStndNoteVOs[i].getIbflag().equals("U")){
					priSgStndNoteVOs[i].setCreUsrId(account.getUsr_id());
					priSgStndNoteVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSgStndNoteVOs[i]);
				} else if ( priSgStndNoteVOs[i].getIbflag().equals("D")){
					deleteVoList.add(priSgStndNoteVOs[i]);
			
					dbDao.removeNoteContent(priSgStndNoteVOs[i]);
				
					priSgStndNoteCtntVOs = null;
				}
			}

			for (int i = 0; priSgStndNoteCtntVOs != null && i < priSgStndNoteCtntVOs.length; i++) {
				if ( priSgStndNoteCtntVOs[i].getIbflag().equals("I")){
					priSgStndNoteCtntVOs[i].setNoteHdrSeq(String.valueOf(noteHdrSeq));
					priSgStndNoteCtntVOs[i].setCreUsrId(account.getUsr_id());
					priSgStndNoteCtntVOs[i].setUpdUsrId(account.getUsr_id());
					
					insertDtlVoList.add(priSgStndNoteCtntVOs[i]);
				} else if ( priSgStndNoteCtntVOs[i].getIbflag().equals("U")){
					priSgStndNoteCtntVOs[i].setCreUsrId(account.getUsr_id());
					priSgStndNoteCtntVOs[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(priSgStndNoteCtntVOs[i]);
				} else if ( priSgStndNoteCtntVOs[i].getIbflag().equals("D")){
					deleteDtlVoList.add(priSgStndNoteCtntVOs[i]);
				}
			}
			
			if (deleteDtlVoList.size() > 0) {
				dbDao.removeNoteContents(deleteDtlVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeNotes(deleteVoList);
			}
			
			if (insertVoList.size() > 0) {
				dbDao.addNotes(insertVoList);
			}
			if (insertDtlVoList.size() > 0) {
				dbDao.addNoteContents(insertDtlVoList);
			}
			
			if (updateVoList.size() > 0) {
				dbDao.modifyNotes(updateVoList);
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifyNoteContents(updateDtlVoList);
			}
			
			priSgStndNoteVO.setNoteHdrSeq(String.valueOf(noteHdrSeq));
			
			return priSgStndNoteVO;
			
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
	 * Confirming Note <br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmBasicStandardNoteGuideline(PriSgStndNoteHdrVO priSgStndNoteHdrVO, SignOnUserAccount account) throws EventException{
		try {
			priSgStndNoteHdrVO.setCfmFlg("Y");
			priSgStndNoteHdrVO.setCfmUsrId(account.getUsr_id());
			priSgStndNoteHdrVO.setUpdUsrId(account.getUsr_id());
			
			dbDao.modifyNoteConfirm(priSgStndNoteHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Cancel Confirming Note <br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelBasicStandardNoteGuideline(PriSgStndNoteHdrVO priSgStndNoteHdrVO, SignOnUserAccount account) throws EventException{
		try {
			priSgStndNoteHdrVO.setCfmFlg("N");
			priSgStndNoteHdrVO.setCfmUsrId(account.getUsr_id());
			priSgStndNoteHdrVO.setUpdUsrId(account.getUsr_id());
			
			dbDao.modifyNoteConfirm(priSgStndNoteHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	
	
	/**
	 * Deleting all Notes <br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
	 * @exception EventException
	 */
	public void removeBasicStandardNoteGuideline(PriSgStndNoteHdrVO priSgStndNoteHdrVO) throws EventException{
		try {
			
			if(priSgStndNoteHdrVO != null) {
				dbDao.removeNoteContent(priSgStndNoteHdrVO);
				dbDao.removeNote(priSgStndNoteHdrVO);
				dbDao.removeNoteHeader(priSgStndNoteHdrVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * Copying all Notes <br>
	 * 
	 * @param RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO
	 * @param SignOnUserAccount account
	 * @return PriSgStndNoteVO
	 * @exception EventException
	 */
	public PriSgStndNoteVO copyBasicStandardNoteGuideline(RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO, SignOnUserAccount account) throws EventException{
		try {
			//header vo
			PriSgStndNoteHdrVO priSgStndNoteHdrVO = new PriSgStndNoteHdrVO();
			PriSgStndNoteVO priSgStndNoteVO = new PriSgStndNoteVO();
			
			priSgStndNoteHdrVO.setSvcScpCd(rsltPriSgStndNoteHdrCopyVO.getSvcScpCd());
			priSgStndNoteHdrVO.setPrcCustTpCd(rsltPriSgStndNoteHdrCopyVO.getPrcCustTpCd());
			priSgStndNoteHdrVO.setEffDt(rsltPriSgStndNoteHdrCopyVO.getEffDt());
			priSgStndNoteHdrVO.setExpDt(rsltPriSgStndNoteHdrCopyVO.getExpDt());
			
			int chk = dbDao.searchNoteHdrCheckDate(priSgStndNoteHdrVO);
			
			if (chk > 0) {
				throw new EventException(new ErrorHandler("PRI08018").getMessage());
			}

			int noteHdrSeq = 1;

			if(rsltPriSgStndNoteHdrCopyVO != null) {

				noteHdrSeq = dbDao.searchNoteHdrMaxSeq(priSgStndNoteHdrVO);
				rsltPriSgStndNoteHdrCopyVO.setNoteHdrSeq(String.valueOf(noteHdrSeq));
				
				rsltPriSgStndNoteHdrCopyVO.setCreUsrId(account.getUsr_id());
				rsltPriSgStndNoteHdrCopyVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addCopyNoteHeader(rsltPriSgStndNoteHdrCopyVO);
				
				//header seq setting
				rsltPriSgStndNoteHdrCopyVO.setNoteHdrSeq(String.valueOf(noteHdrSeq));
				
				rsltPriSgStndNoteHdrCopyVO.setCreUsrId(account.getUsr_id());
				rsltPriSgStndNoteHdrCopyVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addCopyNote(rsltPriSgStndNoteHdrCopyVO);
				
				//#####
				rsltPriSgStndNoteHdrCopyVO.setCreUsrId(account.getUsr_id());
				rsltPriSgStndNoteHdrCopyVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addCopyNoteContent(rsltPriSgStndNoteHdrCopyVO);
				
				//#####
				priSgStndNoteVO.setSvcScpCd(rsltPriSgStndNoteHdrCopyVO.getSvcScpCd());
				
				
			}

			priSgStndNoteVO.setNoteHdrSeq(String.valueOf(noteHdrSeq));
			
			return priSgStndNoteVO;
			
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


	
}