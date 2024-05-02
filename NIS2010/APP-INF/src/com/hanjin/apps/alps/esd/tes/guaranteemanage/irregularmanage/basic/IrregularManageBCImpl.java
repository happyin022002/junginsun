/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IrregularManageBCImpl.java
*@FileTitle : Irregular Creation & Adjustment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.28 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.tes.common.guaranteecommon.basic.GuaranteeCommonBC;
import com.hanjin.apps.alps.esd.tes.common.guaranteecommon.basic.GuaranteeCommonBCImpl;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.integration.IrregularManageDBDAO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.vo.SearchGuaranteeIrregularCntrListVO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.vo.SearchIrregularCntrListVO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.vo.SearchIrregularHdrVO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.vo.SearchIrregularListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.TesGnteCntrListVO;
import com.hanjin.syscommon.common.table.TesIrrHdrVO;

/**
 * ALPS-IrregularManage Business Logic Command Interface<br>
 * - ALPS-IrregularManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author yOng hO lEE
 * @see GuarnateeManageSC 참조
 * @since J2EE 1.6
 */
public class IrregularManageBCImpl extends BasicCommandSupport implements IrregularManageBC {

	// Database Access Object
	private transient IrregularManageDBDAO dbDao = null;

	/**
	 * IrregularManageBCImpl 객체 생성<br>
	 * IrregularManageDBDAO를 생성한다.<br>
	 */
	public IrregularManageBCImpl() {
		dbDao = new IrregularManageDBDAO();
	}

	
	/**
	 * [Irregular Header Info]를 조회합니다.<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @return List<SearchIrregularHdrVO>
	 * @exception EventException
	 */
	public List<SearchIrregularHdrVO> searchIrregularHdr(TesIrrHdrVO tesIrrHdrVO) throws EventException {
		try {
			return dbDao.searchIrregularHdr(tesIrrHdrVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	
	/**
	 * [Irregular Header Info]을 [Insert] 합니다.<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @param account SignOnUserAccount
	 * @return String Irregular No. 
	 * @exception EventException
	 */
	public String addIrregularHdr(TesIrrHdrVO tesIrrHdrVO, SignOnUserAccount account) throws EventException{
		String		irrNo	= "";
		
		try {
			
			irrNo	= dbDao.searchIrregularHdrSeq( account.getOfc_cd() );
			
			if ( !"".equals( irrNo ) ) {
				tesIrrHdrVO.setIrrNo(irrNo);
			}
			tesIrrHdrVO.setIrrTtlAmt(tesIrrHdrVO.getIrrTtlAmt().replaceAll("\\,", "") );
			
			dbDao.addIrregularHdr( tesIrrHdrVO );
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return irrNo;
	}
	
	
	/**
	 * [Irregular Header Info]을 [Update] 합니다.<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyIrregularHdr(TesIrrHdrVO tesIrrHdrVO, SignOnUserAccount account) throws EventException{
		try {
			tesIrrHdrVO.setIrrTtlAmt(tesIrrHdrVO.getIrrTtlAmt().replaceAll("\\,", "") );
			tesIrrHdrVO.setUpdUsrId( account.getUsr_id() );
			dbDao.modifyIrregularHdr( tesIrrHdrVO );
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [Irregular Header Info ]을 [Delete] 합니다.<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void deleteIrregular(TesIrrHdrVO tesIrrHdrVO, SignOnUserAccount account) throws EventException{
		try {
			tesIrrHdrVO.setUpdUsrId( account.getUsr_id() );
			dbDao.removeIrregular( tesIrrHdrVO);	
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [Irregular Container List]을 [Inquiry] 합니다.<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @return List<SearchIrregularCntrListVO>
	 * @exception EventException
	 */
	public List<SearchIrregularCntrListVO> searchIrregularCntrList(TesIrrHdrVO tesIrrHdrVO) throws EventException {
		try {
			return dbDao.searchIrregularCntrList(tesIrrHdrVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	
	
	/**
	 * [Irregular Container List]를 [Insert/Update/Delete] 합니다.<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @param TesGnteCntrListVO[] tesGnteCntrListVOs
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiIrregularCntrList(TesIrrHdrVO tesIrrHdrVO, TesGnteCntrListVO[] tesGnteCntrListVOs, GuaranteeCommonVO guaranteeCommonVO, SignOnUserAccount account) throws EventException{

		List<TesGnteCntrListVO> insertVoList = new ArrayList<TesGnteCntrListVO>();
		List<TesGnteCntrListVO> updateVoList = new ArrayList<TesGnteCntrListVO>();
		List<TesGnteCntrListVO> deleteVoList = new ArrayList<TesGnteCntrListVO>();

		GuaranteeCommonBC		commandCom			= new GuaranteeCommonBCImpl();
		GuaranteeCommonVO		guaranteeCommonVOCntr	= null;

		int			maxCntrSeq	= 0;
		
		try {
			maxCntrSeq	= dbDao.searchIrregularCntrListSeq(tesIrrHdrVO);
			
			for ( int i = 0; tesGnteCntrListVOs != null && i < tesGnteCntrListVOs .length; i++ ) {
				tesGnteCntrListVOs[i].setGnteProcTpCd("I");	// Irregular 인 경우에 "I" 만 등록.
				
				if ( "I".equals( tesGnteCntrListVOs[i].getIbflag() ) ) {
					// Container No. Duplication Check.
					guaranteeCommonVOCntr	= new GuaranteeCommonVO();
					guaranteeCommonVOCntr.setGnteNo		( tesIrrHdrVO.getGnteNo());
					guaranteeCommonVOCntr.setOfcCd		( tesIrrHdrVO.getOfcCd() );
					guaranteeCommonVOCntr.setGnteTpCd	( tesIrrHdrVO.getGnteTpCd());
					guaranteeCommonVOCntr.setCntrNo		( tesGnteCntrListVOs[i].getCntrNo() );
					guaranteeCommonVOCntr.setBkgNo		( tesGnteCntrListVOs[i].getBkgNo() );
					
					if ( !commandCom.checkDupCntr(guaranteeCommonVOCntr) ) {
						throw new DAOException(new ErrorHandler("TES00071", new String[]{ guaranteeCommonVO.getCntrNo() }).getMessage());
//						throw new EventException("\n [Container No. Dup] Container No. : " + guaranteeCommonVOCntr.getCntrNo() + " exists already.");
					}

					tesGnteCntrListVOs[i].setGnteNo		( tesIrrHdrVO.getGnteNo() );
					tesGnteCntrListVOs[i].setIrrNo		( tesIrrHdrVO.getIrrNo() );
					tesGnteCntrListVOs[i].setTmlGnteCntrListSeq( String.valueOf( maxCntrSeq++) );
					tesGnteCntrListVOs[i].setCreUsrId	( account.getUsr_id() );
					tesGnteCntrListVOs[i].setUpdUsrId	( account.getUsr_id() );
					insertVoList.add(tesGnteCntrListVOs[i]);
					
				} else if ( "U".equals( tesGnteCntrListVOs[i].getIbflag() ) ) {
					tesGnteCntrListVOs[i].setGnteNo		( tesIrrHdrVO.getGnteNo() );
					tesGnteCntrListVOs[i].setIrrNo		( tesIrrHdrVO.getIrrNo() );
					tesGnteCntrListVOs[i].setCreUsrId	( account.getUsr_id() );
					tesGnteCntrListVOs[i].setUpdUsrId	( account.getUsr_id() );
					updateVoList.add(tesGnteCntrListVOs[i]);
					
				} else if ( "D".equals( tesGnteCntrListVOs[i].getIbflag() ) ) {
					tesGnteCntrListVOs[i].setGnteNo		( tesIrrHdrVO.getGnteNo() );
					tesGnteCntrListVOs[i].setIrrNo		( tesIrrHdrVO.getIrrNo() );
					tesGnteCntrListVOs[i].setCreUsrId	( account.getUsr_id() );
					tesGnteCntrListVOs[i].setUpdUsrId	( account.getUsr_id() );
					deleteVoList.add(tesGnteCntrListVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addIrregularCntrList(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyIrregularCntrList(updateVoList, guaranteeCommonVO);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeIrregularCntrList(deleteVoList);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [Irregular Header Info]를 조회합니다.<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @return List<SearchIrregularHdrVO>
	 * @exception EventException
	 */
	public List<SearchIrregularHdrVO> searchGuaranteeIrregularHdr(TesIrrHdrVO tesIrrHdrVO) throws EventException {
		try {
			return dbDao.searchGuaranteeIrregularHdr(tesIrrHdrVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	
	/**
	 * [Guarantee 에서 Irregular 등록할 Container List] 정보를 [Select] 합니다.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchGuaranteeIrregularCntrListVO>
	 * @exception EventException
	 */
	public List<SearchGuaranteeIrregularCntrListVO> searchGuaranteeIrregularCntrList(GuaranteeCommonVO guaranteeCommonVO) throws EventException {
		try {
			return dbDao.searchGuaranteeIrregularCntrList(guaranteeCommonVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}

	
	/**
	 * [Irregular Header & Container List]을 [Select]합니다.<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchIrregularListVO>
	 * @exception EventException
	 */
	public List<SearchIrregularListVO> searchIrregularList(TesIrrHdrVO tesIrrHdrVO, GuaranteeCommonVO guaranteeCommonVO) throws EventException {
		try {
			
			return dbDao.searchIrregularList(tesIrrHdrVO, guaranteeCommonVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
}