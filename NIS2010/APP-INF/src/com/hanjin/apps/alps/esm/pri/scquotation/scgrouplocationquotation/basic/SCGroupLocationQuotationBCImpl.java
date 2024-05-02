/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupLocationQuotationBCImpl.java
*@FileTitle : S/C Quotation Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.09
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.09 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scgrouplocationquotation.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scgrouplocationquotation.integration.SCGroupLocationQuotationDBDAO;
import com.hanjin.apps.alps.esm.pri.scquotation.scgrouplocationquotation.vo.GroupLocationQuotationVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scgrouplocationquotation.vo.RsltPriSqGrpLocDtlVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scgrouplocationquotation.vo.RsltPriSqGrpLocVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToQuotationVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltPriSqMnVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSqGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriSqGrpLocVO;
import com.hanjin.syscommon.common.table.PriSqHdrVO;

/**
 * ALPS-SCQuotation Business Logic Basic Command implementation<br>
 * - ALPS-SCQuotation에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6005_1EventResponse,SCGroupLocationQuotationBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SCGroupLocationQuotationBCImpl extends BasicCommandSupport implements SCGroupLocationQuotationBC {

	// Database Access Object
	private transient SCGroupLocationQuotationDBDAO dbDao = null;

	/**
	 * SCGroupLocationQuotationBCImpl 객체 생성<br>
	 * SCGroupLocationQuotationDBDAO를 생성한다.<br>
	 */
	public SCGroupLocationQuotationBCImpl() {
		dbDao = new SCGroupLocationQuotationDBDAO();
	}
	/**
	 * PRI_SQ_GRP_LOC_DTL 테이블을 조회한다.<br>
	 * 
	 * @param PriSqGrpLocVO priSqGrpLocVO
	 * @return List<RsltPriSqGrpLocDtlVO>
	 * @exception EventException
	 */
	public List<RsltPriSqGrpLocDtlVO> searchGroupLocationDetailList(PriSqGrpLocVO priSqGrpLocVO) throws EventException {
		try {
			return dbDao.searchGroupLocationDetailList(priSqGrpLocVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
	}
	
	/**
	 * PRI_SQ_GRP_LOC 테이블을 조회한다.<br>
	 * 
	 * @param PriSqGrpLocVO priSqGrpLocVO
	 * @return List<RsltPriSqGrpLocVO>
	 * @exception EventException
	 */
	public List<RsltPriSqGrpLocVO> searchScGroupLocationQuotationList(PriSqGrpLocVO priSqGrpLocVO) throws EventException {
		try {
			return dbDao.searchScGroupLocationQuotationList(priSqGrpLocVO);
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
	 * @param GroupLocationQuotationVO groupLocationQuotationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageScGroupLocationQuotation(GroupLocationQuotationVO groupLocationQuotationVO, SignOnUserAccount account) 
		throws EventException{
		try {
			
			//컨테이너 vo에서 loc, detail을 뺀다
			PriSqGrpLocVO priSqGrpLocVO 			= groupLocationQuotationVO.getPriSqGrpLocVO();
			PriSqGrpLocVO[] priSqGrpLocVOs 			= groupLocationQuotationVO.getPriSqGrpLocVOs();
			PriSqGrpLocDtlVO[] priSqGrpLocDtlVOs 	= groupLocationQuotationVO.getPriSqGrpLocDtlVOs();
			
			//location
			List<PriSqGrpLocVO> insertVoList = new ArrayList<PriSqGrpLocVO>();
			List<PriSqGrpLocVO> updateVoList = new ArrayList<PriSqGrpLocVO>();
			List<PriSqGrpLocVO> deleteVoList = new ArrayList<PriSqGrpLocVO>();
			//location detail 
			List<PriSqGrpLocDtlVO> insertDtlVoList = new ArrayList<PriSqGrpLocDtlVO>();
			List<PriSqGrpLocDtlVO> updateDtlVoList = new ArrayList<PriSqGrpLocDtlVO>();
			List<PriSqGrpLocDtlVO> deleteDtlVoList = new ArrayList<PriSqGrpLocDtlVO>();

			
			
			////////////////////////////location / detail 저장/////////////////////////////////////	
			int max_loc_seq = -1;
			
			
			//Group Location
			for (int i = 0; priSqGrpLocVOs != null && i < priSqGrpLocVOs.length; i++) {
				
				if ( priSqGrpLocVOs[i].getIbflag().equals("I")){
					
//					if("".equals(priSqGrpLocVOs[i].getGrpLocSeq()) || priSqGrpLocVOs[i].getGrpLocSeq() == null) {
						max_loc_seq = dbDao.searchGroupLocationQuotationMaxGrpLocSeq(priSqGrpLocVO);
//					}

					
					//loc seq
					priSqGrpLocVOs[i].setGrpLocSeq(String.valueOf(max_loc_seq+i));
					
					priSqGrpLocVOs[i].setCreUsrId(account.getUsr_id());
					priSqGrpLocVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priSqGrpLocVOs[i]);
				} else if ( priSqGrpLocVOs[i].getIbflag().equals("U")){
					priSqGrpLocVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSqGrpLocVOs[i]);
				} else if ( priSqGrpLocVOs[i].getIbflag().equals("D")){
					priSqGrpLocVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(priSqGrpLocVOs[i]);
					//본문별 디테일 삭제
//					if(i==0) {
						dbDao.removeScGroupLocationQuotationDetail(priSqGrpLocVOs[i]);
						//디테일을 이미 삭제 했으므로 널로 세팅
						priSqGrpLocDtlVOs = null;
//					}
					
				}
				
			}
			
			//마스터가 신규인 경우
			if(max_loc_seq != -1)
				priSqGrpLocVO.setGrpLocSeq(String.valueOf(max_loc_seq));
			else
				max_loc_seq = Integer.parseInt(priSqGrpLocVO.getGrpLocSeq());
			
			int max_loc_dtl_seq = dbDao.searchGroupLocationQuotationMaxGrpLocDtlSeq(priSqGrpLocVO);
			
			//detail
			for (int i = 0; priSqGrpLocDtlVOs != null && i < priSqGrpLocDtlVOs.length; i++) {
				
				if ( priSqGrpLocDtlVOs[i].getIbflag().equals("I")) {
					//loc seq
					priSqGrpLocDtlVOs[i].setGrpLocSeq(String.valueOf(max_loc_seq));
					//loc dtl seq
					priSqGrpLocDtlVOs[i].setGrpLocDtlSeq(String.valueOf(max_loc_dtl_seq+i));
					priSqGrpLocDtlVOs[i].setCreUsrId(account.getUsr_id());
					priSqGrpLocDtlVOs[i].setUpdUsrId(account.getUsr_id());
					insertDtlVoList.add(priSqGrpLocDtlVOs[i]);
				} else if ( priSqGrpLocDtlVOs[i].getIbflag().equals("U")){
					//loc seq
					priSqGrpLocDtlVOs[i].setGrpLocSeq(String.valueOf(max_loc_seq));
					priSqGrpLocDtlVOs[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(priSqGrpLocDtlVOs[i]);
				} else if ( priSqGrpLocDtlVOs[i].getIbflag().equals("D")){
					//loc seq
					priSqGrpLocDtlVOs[i].setGrpLocSeq(String.valueOf(max_loc_seq));
					deleteDtlVoList.add(priSqGrpLocDtlVOs[i]);
				}
			}
			
			if (deleteDtlVoList.size() > 0) {
				dbDao.removeScGroupLocationQuotationDetailS(deleteDtlVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeScGroupLocationQuotationS(deleteVoList);
			}
			
			if (insertVoList.size() > 0) {
				dbDao.addScGroupLocationQuotationS(insertVoList);
			}
			if (insertDtlVoList.size() > 0) {
				dbDao.addScGroupLocationQuotationDetailS(insertDtlVoList);
			}
			
			if (updateVoList.size() > 0) {
				dbDao.modifyScGroupLocationQuotationS(updateVoList);
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifyScGroupLocationQuotationDetailS(updateDtlVoList);
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
	 * @param RsltPriSqMnVO priSqHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void glineCopyScGroupLocationQuotation(RsltPriSqMnVO priSqHdrVO, SignOnUserAccount account) 
		throws EventException{
		try {
			priSqHdrVO.setCreUsrId(account.getUsr_id());
			priSqHdrVO.setUpdUsrId(account.getUsr_id());
			
			dbDao.addGlineCopyScGroupLocationQuotation(priSqHdrVO);
			dbDao.addGlineCopyScGroupLocationQuotationDetail(priSqHdrVO);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * COPY TO QUOTATION PRI_SQ_GRP_LOC, PRI_SQ_GRP_LOC_DTL<br>
	 * 
	 * @param RsltCopyToQuotationVO rsltCopyToQuotationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void copyToQuotationScGroupLocationQuotaionReport(RsltCopyToQuotationVO rsltCopyToQuotationVO, SignOnUserAccount account) 
		throws EventException{
		try {
			rsltCopyToQuotationVO.setCreUsrId(account.getUsr_id());
			rsltCopyToQuotationVO.setUpdUsrId(account.getUsr_id());
			
			//office
			rsltCopyToQuotationVO.setQttnOfcCd(account.getOfc_cd());
			
			dbDao.addCopyToQuotationScGroupLocationQuotation(rsltCopyToQuotationVO);
			dbDao.addCopyToQuotationScGroupLocationQuotationDetail(rsltCopyToQuotationVO);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * REMOVE PRI_SQ_GRP_LOC, PRI_SQ_GRP_LOC_DTL BY QTTN NO<br>
	 * 
	 * @param PriSqHdrVO priSqHdrVO
	 * @exception EventException
	 */
	public void removeScGroupLocationQuotation(PriSqHdrVO priSqHdrVO) 
		throws EventException{
		try {
			dbDao.removeScGroupLocationQuotationDetail(priSqHdrVO);
			dbDao.removeScGroupLocationQuotation(priSqHdrVO);
			
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
	 * @param GroupLocationQuotationVO groupLocationQuotationVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkGroupLocationInUse(GroupLocationQuotationVO groupLocationQuotationVO) throws EventException {
		try {
			List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();
			
			PriSqGrpLocVO[] priSqGrpLocVOs = groupLocationQuotationVO.getPriSqGrpLocVOs();
			PriSqGrpLocVO priSqGrpLocVO = groupLocationQuotationVO.getPriSqGrpLocVO();
			
			if(priSqGrpLocVOs != null) {
			
				for (int i = 0; i < priSqGrpLocVOs.length; i++) {
					
					PriSqGrpLocVO row = priSqGrpLocVOs[i];
	
					RsltCdListVO cdVO = dbDao.searchCheckGroupLocationInUse(row);
					
					if (cdVO != null) {						
						rslt.add(cdVO);
					}
	
				}
			} else {
		
				RsltCdListVO cdVO = dbDao.searchCheckGroupLocationInUse(priSqGrpLocVO);
				
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