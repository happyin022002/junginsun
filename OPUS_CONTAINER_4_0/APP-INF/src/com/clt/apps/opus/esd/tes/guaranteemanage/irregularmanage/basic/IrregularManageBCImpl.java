/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IrregularManageBCImpl.java
*@FileTitle : Irregular Creation & Adjustment
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.tes.common.guaranteecommon.basic.GuaranteeCommonBC;
import com.clt.apps.opus.esd.tes.common.guaranteecommon.basic.GuaranteeCommonBCImpl;
import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.integration.IrregularManageDBDAO;
import com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.vo.SearchGuaranteeIrregularCntrListVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.vo.SearchIrregularCntrListVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.vo.SearchIrregularHdrVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.vo.SearchIrregularListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.TesGnteCntrListVO;
import com.clt.syscommon.common.table.TesIrrHdrVO;

/**
 * IrregularManage Business Logic Command Interface<br>
 *
 * @author yOng hO lEE
 * @see GuarnateeManageSC
 * @since J2EE 1.6
 */
public class IrregularManageBCImpl extends BasicCommandSupport implements IrregularManageBC {

	// Database Access Object
	private transient IrregularManageDBDAO dbDao = null;

	/**
	 * IrregularManageBCImpl object creation<br>
	 * IrregularManageDBDAO creation<br>
	 */
	public IrregularManageBCImpl() {
		dbDao = new IrregularManageDBDAO();
	}

	
	/**
	 * [Irregular Header Info]retrieve<br>
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
	 * [Irregular Header Info] [Insert]<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @param SignOnUserAccount account 
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
	 * [Irregular Header Info] [Update]<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @param SignOnUserAccount account 
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
	 * [Irregular Header Info ] [Delete]<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @param SignOnUserAccount account
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
	 * [Irregular Container List] [Inquiry]<br>
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
	 * [Irregular Container List] [Insert/Update/Delete]<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @param TesGnteCntrListVO[] tesGnteCntrListVOs
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @param SignOnUserAccount account
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
				tesGnteCntrListVOs[i].setGnteProcTpCd("I");	
				
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
	 * [Irregular Header Info]retrieve<br>
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
	 * [Guarantee Irregular Container List] Info [Select]<br>
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
	 * [Irregular Header & Container List] [Select]<br>
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