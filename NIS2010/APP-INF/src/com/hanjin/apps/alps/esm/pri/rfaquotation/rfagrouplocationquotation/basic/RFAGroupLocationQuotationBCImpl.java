/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupLocationQuotationBCImpl.java
*@FileTitle : RFA Quotation Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.03 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.integration.RFAGroupLocationQuotationDBDAO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.vo.RFAGroupLocationQuotationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.vo.RsltPriRqGrpLocDtlVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.vo.RsltPriRqGrpLocVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToQuotationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltPriRqMnVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRqGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriRqGrpLocVO;
import com.hanjin.syscommon.common.table.PriRqHdrVO;

/**
 * ALPS-RFAQuotation Business Logic Command Interface<br>
 * - ALPS-RFAQuotation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seung-Jun,Lee
 * @see Esm_pri_6014_01EventResponse 참조
 * @since J2EE 1.6
 */
public class RFAGroupLocationQuotationBCImpl extends BasicCommandSupport implements RFAGroupLocationQuotationBC {

	// Database Access Object
	private transient RFAGroupLocationQuotationDBDAO dbDao = null;

	/**
	 * RFAGroupLocationQuotationBCImpl 객체 생성<br>
	 * RFAGroupLocationQuotationDBDAO를 생성한다.<br>
	 */
	public RFAGroupLocationQuotationBCImpl() {
		dbDao = new RFAGroupLocationQuotationDBDAO();
	}
	/**
	 * Group Location Detail 정보를 조회한다.<br>
	 * 
	 * @param PriRqGrpLocVO priRqGrpLocVO
	 * @return List<RsltPriRqGrpLocDtlVO>
	 * @exception EventException
	 */
	public List<RsltPriRqGrpLocDtlVO> searchGroupLocationDetailList(PriRqGrpLocVO priRqGrpLocVO) throws EventException {
		try {
			return dbDao.searchGroupLocationDetailList(priRqGrpLocVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
	}
	
	/**
	 * Group Location 정보를 조회한다.<br>
	 * 
	 * @param PriRqGrpLocVO priRqGrpLocVO
	 * @return List<RsltPriRqGrpLocVO>
	 * @exception EventException
	 */
	public List<RsltPriRqGrpLocVO> searchRfaGroupLocationQuotationList(PriRqGrpLocVO priRqGrpLocVO) throws EventException {
		try {
			return dbDao.searchRfaGroupLocationQuotationList(priRqGrpLocVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
	}
	
	
	
	
	/**
	 * PRI_SQ_GRP_LOC, PRI_SQ_GRP_LOC_DTL을 입력 수정 삭제한다<br>
	 * 
	 * @param RFAGroupLocationQuotationVO groupLocationQuotationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageRfaGroupLocationQuotation(RFAGroupLocationQuotationVO groupLocationQuotationVO, SignOnUserAccount account) 
		throws EventException{
		try {
			
			//컨테이너 vo에서 loc, detail을 뺀다
			PriRqGrpLocVO priRqGrpLocVO 			= groupLocationQuotationVO.getPriRqGrpLocVO();
			PriRqGrpLocVO[] priRqGrpLocVOs 			= groupLocationQuotationVO.getPriRqGrpLocVOs();
			PriRqGrpLocDtlVO[] priRqGrpLocDtlVOs 	= groupLocationQuotationVO.getPriRqGrpLocDtlVOs();
			
			//location
			List<PriRqGrpLocVO> insertVoList = new ArrayList<PriRqGrpLocVO>();
			List<PriRqGrpLocVO> updateVoList = new ArrayList<PriRqGrpLocVO>();
			List<PriRqGrpLocVO> deleteVoList = new ArrayList<PriRqGrpLocVO>();
			//location detail 
			List<PriRqGrpLocDtlVO> insertDtlVoList = new ArrayList<PriRqGrpLocDtlVO>();
			List<PriRqGrpLocDtlVO> updateDtlVoList = new ArrayList<PriRqGrpLocDtlVO>();
			List<PriRqGrpLocDtlVO> deleteDtlVoList = new ArrayList<PriRqGrpLocDtlVO>();

			
			
			////////////////////////////location / detail 저장/////////////////////////////////////	
			int max_loc_seq = -1;
			
			
			//Group Location
			for (int i = 0; priRqGrpLocVOs != null && i < priRqGrpLocVOs.length; i++) {
				
				if ( priRqGrpLocVOs[i].getIbflag().equals("I")){
					
//					if("".equals(priRqGrpLocVOs[i].getGrpLocSeq()) || priRqGrpLocVOs[i].getGrpLocSeq() == null) {
						max_loc_seq = dbDao.searchGroupLocationQuotationMaxGrpLocSeq(priRqGrpLocVO);
//					} 

					
					//loc seq
					priRqGrpLocVOs[i].setGrpLocSeq(String.valueOf(max_loc_seq+i));
					
					priRqGrpLocVOs[i].setCreUsrId(account.getUsr_id());
					priRqGrpLocVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priRqGrpLocVOs[i]);
				} else if ( priRqGrpLocVOs[i].getIbflag().equals("U")){
					priRqGrpLocVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priRqGrpLocVOs[i]);
				} else if ( priRqGrpLocVOs[i].getIbflag().equals("D")){
					priRqGrpLocVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(priRqGrpLocVOs[i]);
					//본문별 디테일 삭제
					dbDao.removeRfaGroupLocationQuotationDetail(priRqGrpLocVOs[i]);
					//디테일을 이미 삭제 했으므로 널로 세팅
					priRqGrpLocDtlVOs = null;
					
				}
				
			}
			
			//마스터가 신규인 경우
			if(max_loc_seq != -1)
				priRqGrpLocVO.setGrpLocSeq(String.valueOf(max_loc_seq));
			else
				max_loc_seq = Integer.parseInt(priRqGrpLocVO.getGrpLocSeq());
			
			int max_loc_dtl_seq = dbDao.searchGroupLocationQuotationMaxGrpLocDtlSeq(priRqGrpLocVO);
			
			//detail
			for (int i = 0; priRqGrpLocDtlVOs != null && i < priRqGrpLocDtlVOs.length; i++) {
				
				if ( priRqGrpLocDtlVOs[i].getIbflag().equals("I")) {
					//loc seq
					priRqGrpLocDtlVOs[i].setGrpLocSeq(String.valueOf(max_loc_seq));
					//loc dtl seq
					priRqGrpLocDtlVOs[i].setGrpLocDtlSeq(String.valueOf(max_loc_dtl_seq+i));
					priRqGrpLocDtlVOs[i].setCreUsrId(account.getUsr_id());
					priRqGrpLocDtlVOs[i].setUpdUsrId(account.getUsr_id());
					insertDtlVoList.add(priRqGrpLocDtlVOs[i]);
				} else if ( priRqGrpLocDtlVOs[i].getIbflag().equals("U")){
					//loc seq
					priRqGrpLocDtlVOs[i].setGrpLocSeq(String.valueOf(max_loc_seq));
					priRqGrpLocDtlVOs[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(priRqGrpLocDtlVOs[i]);
				} else if ( priRqGrpLocDtlVOs[i].getIbflag().equals("D")){
					//loc seq
					priRqGrpLocDtlVOs[i].setGrpLocSeq(String.valueOf(max_loc_seq));
					deleteDtlVoList.add(priRqGrpLocDtlVOs[i]);
				}
			}
			
			
			if (deleteDtlVoList.size() > 0) {
				dbDao.removeRfaGroupLocationQuotationDetailS(deleteDtlVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeRfaGroupLocationQuotationS(deleteVoList);
			}
			
			if (insertVoList.size() > 0) {
				dbDao.addRfaGroupLocationQuotationS(insertVoList);
			}
			if (insertDtlVoList.size() > 0) {
				dbDao.addRfaGroupLocationQuotationDetailS(insertDtlVoList);
			}
			
			if (updateVoList.size() > 0) {
				dbDao.modifyRfaGroupLocationQuotationS(updateVoList);
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifyRfaGroupLocationQuotationDetailS(updateDtlVoList);
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
	 * PRI_SQ_GRP_LOC, PRI_SQ_GRP_LOC_DTL 에 가이드라인 정보를 조회 입력한다<br>
	 * 
	 * @param RsltPriRqMnVO priRqHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void glineCopyRfaGroupLocationQuotation(RsltPriRqMnVO priRqHdrVO, SignOnUserAccount account) 
		throws EventException{
		try {
			priRqHdrVO.setCreUsrId(account.getUsr_id());
			priRqHdrVO.setUpdUsrId(account.getUsr_id());
			
			dbDao.addGlineCopyRfaGroupLocationQuotation(priRqHdrVO);
			dbDao.addGlineCopyRfaGroupLocationQuotationDetail(priRqHdrVO);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * COPY TO QUOTATION<br>
	 * 
	 * @param RsltCopyToQuotationVO rsltCopyToQuotationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void copyToQuotationRfaGroupLocationQuotaionReport(RsltCopyToQuotationVO rsltCopyToQuotationVO, SignOnUserAccount account) 
		throws EventException{
		try {
			rsltCopyToQuotationVO.setCreUsrId(account.getUsr_id());
			rsltCopyToQuotationVO.setUpdUsrId(account.getUsr_id());
			
			//office
			rsltCopyToQuotationVO.setQttnOfcCd(account.getOfc_cd());
			
			dbDao.addCopyToQuotationRfaGroupLocationQuotation(rsltCopyToQuotationVO);
			dbDao.addCopyToQuotationRfaGroupLocationQuotationDetail(rsltCopyToQuotationVO);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * Group Location REMOVE BY QTTN NO<br>
	 * 
	 * @param PriRqHdrVO priRqHdrVO
	 * @exception EventException
	 */
	public void removeRfaGroupLocationQuotation(PriRqHdrVO priRqHdrVO) throws EventException{
		try {
			dbDao.removeRfaGroupLocationQuotationDetail(priRqHdrVO);
			dbDao.removeRfaGroupLocationQuotation(priRqHdrVO);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * Rate에서 사용하는 Location 코드가 있는지 조회한다.
	 * @param RFAGroupLocationQuotationVO groupLocationQuotationVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkGroupLocationInUse(RFAGroupLocationQuotationVO groupLocationQuotationVO) throws EventException {
		try {
			List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();
			
			PriRqGrpLocVO[] priRqGrpLocVOs = groupLocationQuotationVO.getPriRqGrpLocVOs();
			PriRqGrpLocVO priRqGrpLocVO = groupLocationQuotationVO.getPriRqGrpLocVO();
			

			if(priRqGrpLocVOs != null) {
			
				for (int i = 0; i < priRqGrpLocVOs.length; i++) {
					
					PriRqGrpLocVO row = priRqGrpLocVOs[i];
	
					RsltCdListVO cdVO = dbDao.searchCheckGroupLocationInUse(row);
					
					if (cdVO != null) {						
						rslt.add(cdVO);
					}
	
				}
				
			} else {
				
				RsltCdListVO cdVO = dbDao.searchCheckGroupLocationInUse(priRqGrpLocVO);
				
				if (cdVO != null) {						
					rslt.add(cdVO);
				}
				
			}
			
			return rslt;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}	
	
}