/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GuaranteeManageBCImpl.java
*@FileTitle : Guarantee Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.13 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.tes.common.guaranteecommon.basic.GuaranteeCommonBC;
import com.hanjin.apps.alps.esd.tes.common.guaranteecommon.basic.GuaranteeCommonBCImpl;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.integration.GuaranteeManageDBDAO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.integration.GuaranteeManageEAIDAO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.SearchUSGuaranteeCntrListVO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.SearchUSGuaranteeHdrVO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.SearchUSGuaranteeListVO;
import com.hanjin.framework.component.fax.FaxSendException;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.TesGnteCntrListVO;
import com.hanjin.syscommon.common.table.TesGnteHdrVO;

/**
 * ALPS-GuaranteeManage Business Logic Command Interface<br>
 * - ALPS-GuaranteeManage 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author yOng hO lEE
 * @see GuarnateeManageSC 참조
 * @since J2EE 1.6
 */
public class GuaranteeManageBCImpl extends BasicCommandSupport implements GuaranteeManageBC {

	// Database Access Object
	private transient GuaranteeManageDBDAO dbDao = null;
	private transient GuaranteeManageEAIDAO eaiDao = null;

	/**
	 * GuaranteeManageBCImpl 객체 생성<br>
	 * GuaranteeManageDBDAO를 생성한다.<br>
	 */
	public GuaranteeManageBCImpl() {
		dbDao = new GuaranteeManageDBDAO();
		eaiDao = new GuaranteeManageEAIDAO();
	}
	
	/**
	 * [Guarantee Header Info]를 조회합니다.<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @return List<SearchUSGuaranteeHdrVO>
	 * @exception EventException
	 */
	public List<SearchUSGuaranteeHdrVO> searchUSGuaranteeHdr(TesGnteHdrVO tesGnteHdrVO) throws EventException {
		try {
			return dbDao.searchUSGuaranteeHdr(tesGnteHdrVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	
	/**
	 * [Guarantee Header Info]을 [Insert] 합니다.<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String addUSGuaranteeHdr(TesGnteHdrVO tesGnteHdrVO, SignOnUserAccount account) throws EventException{
		
		String			gnteNo		= "";
		
		try {
			if ( "".equals( tesGnteHdrVO.getDmyFlg() ) ) {
				tesGnteHdrVO.setDmyFlg("N");	// Y 인 경우는 IRR생성으로 DUMMY GUARANTEE를 생성해야하는 경우
			}
			gnteNo	= dbDao.searchUSGuaranteeHdrSeq( account.getOfc_cd() );
		
			if ( !"".equals( gnteNo ) ) {
				tesGnteHdrVO.setGnteNo(gnteNo);
			}
			
			tesGnteHdrVO.setTtlAmt(tesGnteHdrVO.getTtlAmt().replaceAll("\\,", "") );
			dbDao.addUSGuaranteeHdr( tesGnteHdrVO );	
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return gnteNo;
	}

	/**
	 * [Guarantee Header Info]을 [Update] 합니다.<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyUSGuaranteeHdr(TesGnteHdrVO tesGnteHdrVO, SignOnUserAccount account) throws EventException{
		try {
			tesGnteHdrVO.setTtlAmt(tesGnteHdrVO.getTtlAmt().replaceAll("\\,", "") );
			tesGnteHdrVO.setUpdUsrId( account.getUsr_id() );
			dbDao.modifyUSGuaranteeHdr( tesGnteHdrVO );
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [Irregular Header Save 할때 Guarantee Header Info]을 [Update] 합니다.<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyUSGuaranteeHdr(TesGnteHdrVO tesGnteHdrVO, GuaranteeCommonVO guaranteeCommonVO, SignOnUserAccount account) throws EventException{
		try {
			tesGnteHdrVO.setUpdUsrId( account.getUsr_id() );
			dbDao.modifyUSGuaranteeHdr( tesGnteHdrVO, guaranteeCommonVO );
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [Guarantee Header Info ]을 [Delete] 합니다.<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void deleteUSGuarantee(TesGnteHdrVO tesGnteHdrVO, SignOnUserAccount account) throws EventException{
		try {
			tesGnteHdrVO.setUpdUsrId( account.getUsr_id() );
			dbDao.removeUSGuarantee( tesGnteHdrVO);	
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * [Guarantee Container List]를 [Insert/Update/Delete] 합니다.<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @param TesGnteCntrListVO[] tesGnteCntrListVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiUSGuaranteeCntrList(TesGnteHdrVO tesGnteHdrVO, TesGnteCntrListVO[] tesGnteCntrListVOs, SignOnUserAccount account) throws EventException{

		List<TesGnteCntrListVO> insertVoList	= new ArrayList<TesGnteCntrListVO>();
		List<TesGnteCntrListVO> updateVoList	= new ArrayList<TesGnteCntrListVO>();
		List<TesGnteCntrListVO> deleteVoList	= new ArrayList<TesGnteCntrListVO>();
		
		GuaranteeCommonBC		commandCom			= new GuaranteeCommonBCImpl();
		GuaranteeCommonVO		guaranteeCommonVO	= null;
		
		int			maxCntrSeq	= 0;
		
		try {
			maxCntrSeq	= dbDao.searchUSGuaranteeCntrListSeq(tesGnteHdrVO);
			
			for ( int i = 0; tesGnteCntrListVOs != null && i < tesGnteCntrListVOs .length; i++ ) {
				if ( "I".equals( tesGnteCntrListVOs[i].getIbflag() ) ) {
					// Container No. Duplication Check.
					guaranteeCommonVO	= new GuaranteeCommonVO();
					guaranteeCommonVO.setGnteNo		( tesGnteHdrVO.getGnteNo());
					guaranteeCommonVO.setOfcCd		( tesGnteHdrVO.getOfcCd() );
					guaranteeCommonVO.setGnteTpCd	( tesGnteHdrVO.getGnteTpCd());
					guaranteeCommonVO.setCntrNo		( tesGnteCntrListVOs[i].getCntrNo() );
					guaranteeCommonVO.setBkgNo		( tesGnteCntrListVOs[i].getBkgNo() );
					
					if ( !commandCom.checkDupCntr(guaranteeCommonVO) ) {
						throw new DAOException(new ErrorHandler("TES00071", new String[]{ guaranteeCommonVO.getCntrNo() }).getMessage());
//						throw new EventException("\n [Container No. Dup] Container No. : " + guaranteeCommonVO.getCntrNo() + " exists already.");
					}

					tesGnteCntrListVOs[i].setGnteNo		( tesGnteHdrVO.getGnteNo() );
					tesGnteCntrListVOs[i].setTmlGnteCntrListSeq( String.valueOf( maxCntrSeq++) );
					tesGnteCntrListVOs[i].setGnteAmt	( tesGnteCntrListVOs[i].getGnteAmt().replaceAll("\\,", "") );
					tesGnteCntrListVOs[i].setCreUsrId	( account.getUsr_id() );
					tesGnteCntrListVOs[i].setUpdUsrId	( account.getUsr_id() );
					insertVoList.add(tesGnteCntrListVOs[i]);
					
				} else if ( "U".equals( tesGnteCntrListVOs[i].getIbflag() ) ) {
					if ("".equals(tesGnteCntrListVOs[i].getTmlIfOfcCd()) &&
						"".equals(tesGnteCntrListVOs[i].getTmlIfOfcCd()) &&
						"".equals(tesGnteCntrListVOs[i].getIrrNo() ) ) {
						tesGnteCntrListVOs[i].setGnteNo		( tesGnteHdrVO.getGnteNo() );
						tesGnteCntrListVOs[i].setGnteAmt	( tesGnteCntrListVOs[i].getGnteAmt().replaceAll("\\,", "") );
						tesGnteCntrListVOs[i].setCreUsrId	( account.getUsr_id() );
						tesGnteCntrListVOs[i].setUpdUsrId	( account.getUsr_id() );
						updateVoList.add(tesGnteCntrListVOs[i]);
					}
					
				} else if ( "D".equals( tesGnteCntrListVOs[i].getIbflag() ) ) {
					tesGnteCntrListVOs[i].setGnteNo		( tesGnteHdrVO.getGnteNo() );
					tesGnteCntrListVOs[i].setCreUsrId	( account.getUsr_id() );
					tesGnteCntrListVOs[i].setUpdUsrId	( account.getUsr_id() );
					deleteVoList.add(tesGnteCntrListVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addUSGuaranteeCntrList(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyUSGuaranteeCntrList(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeUSGuaranteeCntrList(deleteVoList);
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
	 * [Guarantee Container List]을 [Inquiry] 합니다.<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @return List<SearchUSGuaranteeListVO>
	 * @exception EventException
	 */
	public List<SearchUSGuaranteeCntrListVO> searchUSGuaranteeCntrList(TesGnteHdrVO tesGnteHdrVO) throws EventException {
		try {
			return dbDao.searchUSGuaranteeCntrList(tesGnteHdrVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	
	/**
	 * [Guarantee Header & Container List]을 [Select]합니다.<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchUSGuaranteeListVO>
	 * @exception EventException
	 */
	public List<SearchUSGuaranteeListVO> searchUSGuaranteeList(TesGnteHdrVO tesGnteHdrVO, GuaranteeCommonVO guaranteeCommonVO) throws EventException {
		try {
			
			return dbDao.searchUSGuaranteeList(tesGnteHdrVO, guaranteeCommonVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

	
	/**
	 * ESD_TES_2003 Guarantee RD eMail Send.<br>
	 * 
	 * @param commonVO GuaranteeCommonVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void sendEmail(GuaranteeCommonVO commonVO, SignOnUserAccount account) throws EventException{
		try{
			eaiDao.sendEmail(commonVO, account);
		}catch(MailerAppException me){
			log.error("err "+me.toString(),me);
			throw new EventException(me.getMessage());
		}catch(Exception e){
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * ESD_TES_2003 Guarantee RD FAX Send.<br>
	 * 
	 * @param commonVO GuaranteeCommonVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void sendFax(GuaranteeCommonVO commonVO, SignOnUserAccount account) throws EventException{
		try{
			eaiDao.sendFax(commonVO, account);
			
		}catch(FaxSendException fe){
			log.error("err "+fe.toString(),fe);
			throw new EventException(fe.getMessage());
		}catch(Exception e){
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
	}
}