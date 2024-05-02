/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBasicStandardNoteGuidelineBCImpl.java
*@FileTitle : Standard Note Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.17
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.04.17 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.integration.SCBasicStandardNoteGuidelineDBDAO;
import com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.vo.RsltPriSgStndNoteCtntVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.vo.RsltPriSgStndNoteHdrCopyVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.vo.StndNoteGlineVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSgStndNoteCtntVO;
import com.hanjin.syscommon.common.table.PriSgStndNoteHdrVO;
import com.hanjin.syscommon.common.table.PriSgStndNoteVO;

/**
 * NIS2010-SCGuideline Business Logic Basic Command implementation<br>
 * - NIS2010-SCGuideline에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Seung Jun Lee
 * @see ui_pri_0005EventResponse,SCBasicStandardNoteGuidelineBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class SCBasicStandardNoteGuidelineBCImpl extends BasicCommandSupport implements SCBasicStandardNoteGuidelineBC {

	// Database Access Object
	private transient SCBasicStandardNoteGuidelineDBDAO dbDao = null;

	/**
	 * SCBasicStandardNoteGuidelineBCImpl 객체 생성<br>
	 * SCBasicStandardNoteGuidelineDBDAO를 생성한다.<br>
	 */
	public SCBasicStandardNoteGuidelineBCImpl() {
		dbDao = new SCBasicStandardNoteGuidelineDBDAO();
	}
	
	
	/**
	 * StndNote 헤더 정보를 조회한다.<br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
	 * @return StndNoteGlineVO
	 * @exception EventException
	 */
	public StndNoteGlineVO searchBasicStandardNoteGuidelineHdrList(PriSgStndNoteHdrVO priSgStndNoteHdrVO)throws EventException {
		try {
			//컨테이너 vo
			StndNoteGlineVO stndNoteGlineVO = new StndNoteGlineVO();
			//노트 헤드,타이틀, 바디
			List<PriSgStndNoteHdrVO> priSgStndNoteHdr 	= new ArrayList<PriSgStndNoteHdrVO>();
			
			//각 리스트를 받아서 컨테이너 vo에 담는다
			
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
	 * StndNote Duration을 조회한다.<br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
	 * @return StndNoteGlineVO
	 * @exception EventException
	 */
	public StndNoteGlineVO searchBasicStandardNoteGuidelineHdrDurationList(PriSgStndNoteHdrVO priSgStndNoteHdrVO)throws EventException {
		try {
			//컨테이너 vo
			StndNoteGlineVO stndNoteGlineVO = new StndNoteGlineVO();
			//노트 헤드,타이틀, 바디
			List<PriSgStndNoteHdrVO> priSgStndNoteHdr 	= new ArrayList<PriSgStndNoteHdrVO>();
			
			//각 리스트를 받아서 컨테이너 vo에 담는다
			
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
	 * StndNote 메인, 타이틀 바디 정보를 조회한다.<br>
	 * 
	 * @param PriSgStndNoteVO priSgStndNoteVO
	 * @param String searchGubun
	 * @return StndNoteGlineVO
	 * @exception EventException
	 */
	public StndNoteGlineVO searchBasicStandardNoteGuidelineList(PriSgStndNoteVO priSgStndNoteVO, String searchGubun) throws EventException {
		try {
			//컨테이너 vo
			StndNoteGlineVO stndNoteGlineVO = new StndNoteGlineVO();
			//노트 헤드,타이틀, 바디
			List<PriSgStndNoteHdrVO> priSgStndNoteHdr 	= new ArrayList<PriSgStndNoteHdrVO>();
			List<PriSgStndNoteVO> priSgStndNote 		= new ArrayList<PriSgStndNoteVO>();
			List<PriSgStndNoteCtntVO> priSgStndNoteCtnt = new ArrayList<PriSgStndNoteCtntVO>();
			
			//각 리스트를 받아서 컨테이너 vo에 담는다
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
			//다 받는다
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
	 * StndNote 메인, 타이틀 바디 정보를 다운로드한다.<br>
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
	 * StndNote 정보를 저장한다.<br>
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
			
			//컨테이너 vo에서 헤더,타이틀,본문을 뺀다
			priSgStndNoteHdrVO 		= stndNoteGlineVO.getPrisgstndnotehdrvo();
			priSgStndNoteVOs 		= stndNoteGlineVO.getPrisgstndnotevos();
			priSgStndNoteCtntVOs 	= stndNoteGlineVO.getPrisgstndnotectntvos();
			
			//타이틀
			List<PriSgStndNoteVO> insertVoList = new ArrayList<PriSgStndNoteVO>();
			List<PriSgStndNoteVO> updateVoList = new ArrayList<PriSgStndNoteVO>();
			List<PriSgStndNoteVO> deleteVoList = new ArrayList<PriSgStndNoteVO>();
			//본문
			List<PriSgStndNoteCtntVO> insertDtlVoList = new ArrayList<PriSgStndNoteCtntVO>();
			List<PriSgStndNoteCtntVO> updateDtlVoList = new ArrayList<PriSgStndNoteCtntVO>();
			List<PriSgStndNoteCtntVO> deleteDtlVoList = new ArrayList<PriSgStndNoteCtntVO>();
			
			/////////////////////////////기간체크///////////////////////////////////////////////
			int chk = dbDao.searchNoteHdrCheckDate(priSgStndNoteHdrVO);
			
			if (chk > 0) {
				throw new EventException(new ErrorHandler("PRI08018").getMessage());
			}
			/////////////////////////////기간체크///////////////////////////////////////////////
			
			////////////////////////////헤더 저장/////////////////////////////////////////////
			
			//헤더 시퀀스
			int noteHdrSeq = 1;
			
			//헤더
			if(priSgStndNoteHdrVO != null) {
				//입력이면 max seq를 조회한 후 등록
				if(priSgStndNoteHdrVO.getNoteHdrSeq() == null || "".equals(priSgStndNoteHdrVO.getNoteHdrSeq()) ) {
					
					noteHdrSeq = dbDao.searchNoteHdrMaxSeq(priSgStndNoteHdrVO);
					priSgStndNoteHdrVO.setNoteHdrSeq(String.valueOf(noteHdrSeq));
					priSgStndNoteHdrVO.setCreUsrId(account.getUsr_id());
					priSgStndNoteHdrVO.setUpdUsrId(account.getUsr_id());
					
					dbDao.addNoteHeader(priSgStndNoteHdrVO);
				}
				//수정
				else {
					noteHdrSeq = Integer.parseInt(priSgStndNoteHdrVO.getNoteHdrSeq());
					priSgStndNoteHdrVO.setCreUsrId(account.getUsr_id());
					priSgStndNoteHdrVO.setUpdUsrId(account.getUsr_id());
					dbDao.modifyNoteHeader(priSgStndNoteHdrVO);
				}
			}
			////////////////////////////헤더 저장/////////////////////////////////////////////
			
			////////////////////////////타이틀 / 본문 저장/////////////////////////////////////	
			
			//타이틀 
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
					//본문별 디테일 삭제
					dbDao.removeNoteContent(priSgStndNoteVOs[i]);
					//디테일을 이미 삭제 했으므로 널로 세팅
					priSgStndNoteCtntVOs = null;
				}
			}
			
			//본문
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
			
			//copy 후 생성된 SvcScpCd, noteHdrSeq 리턴
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
	 * 사용자가 노트를 컨폼한다<br>
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
	 * 사용자가 노트를 컨폼 cancel한다<br>
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
	 * 노트 전체를 삭제한다<br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
	 * @exception EventException
	 */
	public void removeBasicStandardNoteGuideline(PriSgStndNoteHdrVO priSgStndNoteHdrVO) throws EventException{
		try {
			
			//헤더 별 모든 데이터를 삭제한다
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
	 * 노트 전체를 복사한다<br>
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
			
			
			/////////////////////////////기간체크///////////////////////////////////////////////
			priSgStndNoteHdrVO.setSvcScpCd(rsltPriSgStndNoteHdrCopyVO.getSvcScpCd());
			priSgStndNoteHdrVO.setPrcCustTpCd(rsltPriSgStndNoteHdrCopyVO.getPrcCustTpCd());
			priSgStndNoteHdrVO.setEffDt(rsltPriSgStndNoteHdrCopyVO.getEffDt());
			priSgStndNoteHdrVO.setExpDt(rsltPriSgStndNoteHdrCopyVO.getExpDt());
			
			int chk = dbDao.searchNoteHdrCheckDate(priSgStndNoteHdrVO);
			
			if (chk > 0) {
				throw new EventException(new ErrorHandler("PRI08018").getMessage());
			}
			/////////////////////////////기간체크///////////////////////////////////////////////
			
			
			////////////////////////////헤더 저장/////////////////////////////////////////////
			
			//헤더 시퀀스
			int noteHdrSeq = 1;
			
			//헤더
			if(rsltPriSgStndNoteHdrCopyVO != null) {
				
				
				//max seq를 조회한 후 등록	
				noteHdrSeq = dbDao.searchNoteHdrMaxSeq(priSgStndNoteHdrVO);
				rsltPriSgStndNoteHdrCopyVO.setNoteHdrSeq(String.valueOf(noteHdrSeq));
				
				rsltPriSgStndNoteHdrCopyVO.setCreUsrId(account.getUsr_id());
				rsltPriSgStndNoteHdrCopyVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addCopyNoteHeader(rsltPriSgStndNoteHdrCopyVO);
				
				
			}
			
			////////////////////////////헤더 저장/////////////////////////////////////////////
			
			////////////////////////////타이틀 저장/////////////////////////////////////////////
			
			//타이틀
			if(rsltPriSgStndNoteHdrCopyVO != null) {
				//header seq setting
				rsltPriSgStndNoteHdrCopyVO.setNoteHdrSeq(String.valueOf(noteHdrSeq));
				
				rsltPriSgStndNoteHdrCopyVO.setCreUsrId(account.getUsr_id());
				rsltPriSgStndNoteHdrCopyVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addCopyNote(rsltPriSgStndNoteHdrCopyVO);
				
			}
			
			////////////////////////////타이틀 저장/////////////////////////////////////////////
			
			
			////////////////////////////본문 저장/////////////////////////////////////////////
			
			//타이틀
			if(rsltPriSgStndNoteHdrCopyVO != null) {
				
				rsltPriSgStndNoteHdrCopyVO.setCreUsrId(account.getUsr_id());
				rsltPriSgStndNoteHdrCopyVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addCopyNoteContent(rsltPriSgStndNoteHdrCopyVO);
				
			}
			
			////////////////////////////본문 저장/////////////////////////////////////////////
			
		    //copy 후 생성된 SvcScpCd, noteHdrSeq 리턴
			priSgStndNoteVO.setSvcScpCd(rsltPriSgStndNoteHdrCopyVO.getSvcScpCd());
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