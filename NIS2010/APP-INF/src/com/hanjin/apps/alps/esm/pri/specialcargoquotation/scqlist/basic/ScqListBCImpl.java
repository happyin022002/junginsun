/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqListBCImpl.java
*@FileTitle : Awkward and Break Bulk Cargo Quotation List
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.19
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.02.19 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.integration.ScqListDBDAO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.MdmCustVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.PriScqAtchFileVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.PriScqAwkBbVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.PriScqAwkMnVO;
import com.hanjin.framework.component.attachment.file.support.UpdateFileMetaInfo;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-SpecialCargoQuotation Business Logic Command Interface<br>
 * - ALPS-SpecialCargoQuotation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Dong-sun Moon
 * @since J2EE 1.6
 */
public class ScqListBCImpl extends BasicCommandSupport implements ScqListBC {

	// Database Access Object
	private transient ScqListDBDAO dbDao = null;

	/**
	 * ScqListBCImpl 객체 생성<br>
	 * ScqListDBDAO를 생성한다.<br>
	 */
	public ScqListBCImpl() {
		dbDao = new ScqListDBDAO();
	}
	
	/**
	 * Awkward & Break Bulk Quotation List 조회  
	 * 
	 * @param PriScqAwkBbVO priScqAwkBbVO
	 * @return List<PriScqAwkBbVO>
	 * @exception EventException
	 */
	public List<PriScqAwkBbVO> searchAwkBbCgoQlist(PriScqAwkBbVO priScqAwkBbVO) throws EventException {
		try {
			return dbDao.searchAwkBbCgoQlist(priScqAwkBbVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Awkward & Break Bulk Quotation List 에서 Awkward Case 의 Cargo Information 조회 <br>
	 * 
	 * @param PriScqAwkBbVO priScqAwkBbVO
	 * @return List<PriScqAwkBbVO>
	 * @exception EventException
	 */
	public List<PriScqAwkBbVO> searchAwkDtlCgoQlist(PriScqAwkBbVO priScqAwkBbVO) throws EventException {
		try {
			return dbDao.searchAwkDtlCgoQlist(priScqAwkBbVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Awkward & Break Bulk Quotation List 에서 Break Bulk Case 의 Detail Information 조회.<br>
	 * 
	 * @param PriScqAwkBbVO priScqAwkBbVO
	 * @return List<PriScqAwkBbVO>
	 * @exception EventException
	 */
	public PriScqAwkBbVO searchBbDtlCgoQlist(PriScqAwkBbVO priScqAwkBbVO) throws EventException {
		try {
			return dbDao.searchBbDtlCgoQlist(priScqAwkBbVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Awkward & Break Bulk Approval List 조회 
	 * 
	 * @param PriScqAwkBbVO priScqAwkBbVO
	 * @return List<PriScqAwkBbVO>
	 * @exception EventException
	 */
	public List<PriScqAwkBbVO> searchAwkBbCgoAlist(PriScqAwkBbVO priScqAwkBbVO) throws EventException {
		try {
			return dbDao.searchAwkBbCgoAlist(priScqAwkBbVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Awkward & Break Bulk Approval List 에서 Awkward Case 의 Cargo Information 조회  
	 * 
	 * @param PriScqAwkBbVO priScqAwkBbVO
	 * @return List<PriScqAwkBbVO>
	 * @exception EventException
	 */
	public List<PriScqAwkBbVO> searchAwkDtlCgoAlist(PriScqAwkBbVO priScqAwkBbVO) throws EventException {
		try {
			return dbDao.searchAwkDtlCgoAlist(priScqAwkBbVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Awkward & Break Bulk Approval List 에서 Break Bulk Case 의 Detail Information 조회.<br>
	 * 
	 * @param PriScqAwkBbVO priScqAwkBbVO
	 * @return List<PriScqAwkBbVO>
	 * @exception EventException
	 */
	public PriScqAwkBbVO searchBbDtlCgoAlist(PriScqAwkBbVO priScqAwkBbVO) throws EventException {
		try {
			return dbDao.searchBbDtlCgoAlist(priScqAwkBbVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Attachment File 조회.<br>
	 * 
	 * @param RestrictCmdtFileVO vo
	 * @return List<BkgImpImgStoVO>
	 * @exception EventException
	 */
	public List<PriScqAtchFileVO> searchPriScqAtchFile(PriScqAtchFileVO vo) throws EventException{
		
	try {
		return dbDao.searchPriScqAtchFile(vo);
		
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * 특수화물 Quotation 에서 Awkward, Break Bulk 양쪽에서 사용되는 Attachment File 관리 .<br>
	 * 
	 * @param RestrictCmdtFileVO priScqAtchFileVO
	 * @exception EventException
	 */
	public void managePriScqAtchFile(PriScqAtchFileVO[] priScqAtchFileVOs, String[] saveIds, SignOnUserAccount account) throws EventException{
		try {
			
			log.debug("[START:: BookingMasterMgtBCImpl == manageRestrictCmdtFile  ]==========");
//			BkgImpImgStoVO[] bkgImpImgStoVO = priScqAtchFileVO.getBkgImpImgStoVOs();
//			SignOnUserAccount account = priScqAtchFileVO.getAccount();
//			String[] fileSavId = priScqAtchFileVO.getKeys();
			String[] fileSavId = saveIds;
//			String rgnOfcCd = priScqAtchFileVO.getRgnOfcCd();
//			String locCd = priScqAtchFileVO.getLocCd();
//			String cntCd = priScqAtchFileVO.getCntCd();
//			String dpSeq = priScqAtchFileVO.getDpSeq();
			
			List<PriScqAtchFileVO> insertVoList = new ArrayList<PriScqAtchFileVO>();
			List<PriScqAtchFileVO> deleteVoList = new ArrayList<PriScqAtchFileVO>();
			List<PriScqAtchFileVO> updateVoList = new ArrayList<PriScqAtchFileVO>();
			int save_id_cnt = 0;
			
			if(priScqAtchFileVOs != null) {
				for ( int i=0; i<priScqAtchFileVOs.length; i++ ) {
					
					// 공통 파라미터 설정
//					bkgImpImgStoVO[i].setRgnOfcCd(rgnOfcCd);
//					bkgImpImgStoVO[i].setLocCd(locCd);
//					bkgImpImgStoVO[i].setCntCd(cntCd);
//					bkgImpImgStoVO[i].setDpSeq(dpSeq);
					if (priScqAtchFileVOs[i].getIbflag().equals("U")) {
						log.debug("[START:: BookingMasterMgtBCImpl]updateVoList=====" + priScqAtchFileVOs[i].getFileSavId());
						deleteVoList.add(priScqAtchFileVOs[i]);
						priScqAtchFileVOs[i].setIbflag("I");
					}
					
					if (priScqAtchFileVOs[i].getIbflag().equals("D")) {
						log.debug("[START:: BookingMasterMgtBCImpl]deleteVoList=====" + priScqAtchFileVOs[i].getFileSavId());
						deleteVoList.add(priScqAtchFileVOs[i]);
						UpdateFileMetaInfo.delete(priScqAtchFileVOs[i].getFileSavId());
						
					} else if (priScqAtchFileVOs[i].getIbflag().equals("I")) {
						log.debug("[START:: BookingMasterMgtBCImpl]insertVoList=====" + priScqAtchFileVOs[i].getFileSavId());
	
						if (priScqAtchFileVOs[i].getFileSavId() == null || priScqAtchFileVOs[i].getFileSavId().length() == 0) {
							priScqAtchFileVOs[i].setFileSavId(fileSavId[save_id_cnt++]);
						}
	
						priScqAtchFileVOs[i].setCreUsrId(account.getUsr_id());
						priScqAtchFileVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(priScqAtchFileVOs[i]);
					}
				}
			}
				
				if (deleteVoList.size() > 0) {
					dbDao.removePriScqAtchFile(deleteVoList);
				}
				if (insertVoList.size() > 0) {
					dbDao.addPriScqAtchFile(insertVoList);

					// insert 있는 경우만 마지막처리 com_upload 테이블과 sync 맞추기
//					updateVoList.add(bkgImpImgStoVO[0]);
//					dbDao.modifyPriScqAtchFile(updateVoList);
				}
            
		} catch(DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 *  Customer Input Popup List 조회 <br>
	 * 
	 * @param MdmCustVO mdmCustVO
	 * @return List<MdmCustVO>
	 * @exception EventException
	 */
	public List<MdmCustVO> searchCustomerList(MdmCustVO mdmCustVO) throws EventException {
		try {
			return dbDao.searchCustomerList(mdmCustVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
}