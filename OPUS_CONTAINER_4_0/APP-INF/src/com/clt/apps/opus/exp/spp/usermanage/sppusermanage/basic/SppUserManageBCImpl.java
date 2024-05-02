/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SppUserManageBCImpl.java
*@FileTitle : SppUserManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 안준상
*@LastVersion : 1.0
* 2009.07.30 안준상
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.exp.spp.usermanage.sppusermanage.basic;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.exp.spp.usermanage.sppusermanage.integration.SppUserManageDBDAO;
import com.clt.apps.opus.exp.spp.usermanage.sppusermanage.vo.MnrPartnerGRPVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmVendorVO;
import com.clt.syscommon.common.table.MnrPartnerVO;
import com.clt.syscommon.common.table.MnrPrnrCntcPntVO;

/**
 * ALPS-usermanage Business Logic Basic Command implementation<br>
 * - ALPS-usermanage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author jsahn
 * @see SppUserManageEventResponse,SppUserManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SppUserManageBCImpl extends BasicCommandSupport implements SppUserManageBC {

	// Database Access Object
	private transient SppUserManageDBDAO dbDao = null;

	/**
	 * SppUserManageBCImpl 객체 생성<br>
	 * SppUserManageDBDAO를 생성한다.<br>
	 */
	public SppUserManageBCImpl() {
		dbDao = new SppUserManageDBDAO();
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param String sp_ptal_id
	 * @return List<MnrPartnerVO>
	 * @exception EventException
	 */
	public List<MnrPartnerVO> searchSppUserBidInfoBasic(String sp_ptal_id) throws EventException {
		try {
			return dbDao.searchSppUserBidInfoData(sp_ptal_id);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param sp_ptal_id String
	 * @return List<MnrPrnrCntcPntVO>
	 * @exception EventException
	 */
	public List<MnrPrnrCntcPntVO> searchSppUserBidInfosBasic(String sp_ptal_id) throws EventException {
		try {
			return dbDao.searchSppUserBidInfosData(sp_ptal_id);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * Vendor에 대한 데이타 모델목록을 조회합니다.<br>
	 * 
	 * @param vndrSeq String
	 * @return List<MdmVendorVO>
	 * @exception EventException
	 */
	public List<MdmVendorVO> searchMdmVendorInfoBasic(String vndrSeq) throws EventException {
		try {
			
			return dbDao.searchMdmVendorInfoData(vndrSeq);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 이벤트 처리<br>  
	 * Bid user 정보를 저장함.
	 * 
	 * @param MnrPartnerGRPVO mnrPartnerGRPVO
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */    
	public void insertSppUserBidInfoBasic(MnrPartnerGRPVO mnrPartnerGRPVO, SignOnUserAccount account) throws EventException{
		try {     
			    
			if ( mnrPartnerGRPVO !=null ) { 
				//seq 조회
				String mnrPrnrSeq = dbDao.addMnrPartnerSeqData();
				
				mnrPartnerGRPVO.getMnrPartnerVO().setMnrPrnrCreSeq(mnrPrnrSeq);
				
				MnrPartnerVO prnrVO = mnrPartnerGRPVO.getMnrPartnerVO();
				
				prnrVO.setMnrPrnrLglEngNm(URLDecoder.decode(prnrVO.getMnrPrnrLglEngNm(), "UTF-8"));
				prnrVO.setMnrPrnrLoclLangNm(URLDecoder.decode(prnrVO.getMnrPrnrLoclLangNm(), "UTF-8"));
				prnrVO.setMnrPrnrAddr(URLDecoder.decode(prnrVO.getMnrPrnrAddr(), "UTF-8"));
				prnrVO.setBankNm(URLDecoder.decode(prnrVO.getBankNm(), "UTF-8"));
				prnrVO.setBankAcctNo(URLDecoder.decode(prnrVO.getBankAcctNo(), "UTF-8"));
				prnrVO.setOwnrNm(URLDecoder.decode(prnrVO.getOwnrNm(), "UTF-8"));
				prnrVO.setBzctNm(URLDecoder.decode(prnrVO.getBzctNm(), "UTF-8"));
				prnrVO.setBztpNm(URLDecoder.decode(prnrVO.getBztpNm(), "UTF-8"));
				prnrVO.setBizRgstNo(URLDecoder.decode(prnrVO.getBizRgstNo(), "UTF-8"));
				prnrVO.setMnrPrnrCapiAmt(URLDecoder.decode(prnrVO.getMnrPrnrCapiAmt(), "UTF-8"));
				prnrVO.setEmpeKnt(URLDecoder.decode(prnrVO.getEmpeKnt(), "UTF-8"));
				prnrVO.setDptDesc(URLDecoder.decode(prnrVO.getDptDesc(), "UTF-8"));
				prnrVO.setBzetAddr(URLDecoder.decode(prnrVO.getBzetAddr(), "UTF-8"));
				
				dbDao.insertSppUserBidInfoData(prnrVO);
				
				//contact info Insert  
				List<MnrPrnrCntcPntVO> insertVoList = new ArrayList<MnrPrnrCntcPntVO>();
				     
				if(mnrPartnerGRPVO.getMnrPrnrCntcPntVOS() != null){
					
					MnrPrnrCntcPntVO[] mnrPrnrCntcPntVOS = mnrPartnerGRPVO.getMnrPrnrCntcPntVOS();
					
					for ( int i = 0; i< mnrPrnrCntcPntVOS.length; i++ ) {      
						mnrPrnrCntcPntVOS[i].setMnrPrnrCreSeq(mnrPrnrSeq);
						
						mnrPrnrCntcPntVOS[i].setMnrPrnrCreSeq(mnrPrnrSeq);
						mnrPrnrCntcPntVOS[i].setMnrCntcPrnrNm(URLDecoder.decode(mnrPrnrCntcPntVOS[i].getMnrCntcPrnrNm(),"UTF-8"));
						mnrPrnrCntcPntVOS[i].setMnrPrnrAddr(URLDecoder.decode(mnrPrnrCntcPntVOS[i].getMnrPrnrAddr(),"UTF-8"));
						insertVoList.add(mnrPrnrCntcPntVOS[i]);  
					}                 
					 	
					if ( insertVoList.size() > 0 ) {  
						dbDao.insertSppUserBidInfosData(insertVoList);
					}   
				}
			}   
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 이벤트 처리<br>  
	 * Bid user 정보를 수정함.
	 * 
	 * @param MnrPartnerGRPVO mnrPartnerGRPVO
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */    
	public void modifySppUserBidInfoBasic(MnrPartnerGRPVO mnrPartnerGRPVO, SignOnUserAccount account) throws EventException{
		try {     
			    
			if ( mnrPartnerGRPVO !=null ) { 
				
				MnrPartnerVO prnrVO = mnrPartnerGRPVO.getMnrPartnerVO();
				
				prnrVO.setMnrPrnrLglEngNm(URLDecoder.decode(prnrVO.getMnrPrnrLglEngNm(), "UTF-8"));
				prnrVO.setMnrPrnrLoclLangNm(URLDecoder.decode(prnrVO.getMnrPrnrLoclLangNm(), "UTF-8"));
				prnrVO.setMnrPrnrAddr(URLDecoder.decode(prnrVO.getMnrPrnrAddr(), "UTF-8"));
				prnrVO.setBankNm(URLDecoder.decode(prnrVO.getBankNm(), "UTF-8"));
				prnrVO.setBankAcctNo(URLDecoder.decode(prnrVO.getBankAcctNo(), "UTF-8"));
				prnrVO.setOwnrNm(URLDecoder.decode(prnrVO.getOwnrNm(), "UTF-8"));
				prnrVO.setBzctNm(URLDecoder.decode(prnrVO.getBzctNm(), "UTF-8"));
				prnrVO.setBztpNm(URLDecoder.decode(prnrVO.getBztpNm(), "UTF-8"));
				prnrVO.setBizRgstNo(URLDecoder.decode(prnrVO.getBizRgstNo(), "UTF-8"));
				prnrVO.setMnrPrnrCapiAmt(URLDecoder.decode(prnrVO.getMnrPrnrCapiAmt(), "UTF-8"));
				prnrVO.setEmpeKnt(URLDecoder.decode(prnrVO.getEmpeKnt(), "UTF-8"));
				prnrVO.setDptDesc(URLDecoder.decode(prnrVO.getDptDesc(), "UTF-8"));
				prnrVO.setBzetAddr(URLDecoder.decode(prnrVO.getBzetAddr(), "UTF-8"));
				
				dbDao.modifySppUserBidInfoData(prnrVO);
				//contact info update  
				List<MnrPrnrCntcPntVO> modifyVoList = new ArrayList<MnrPrnrCntcPntVO>();
				     
				if(mnrPartnerGRPVO.getMnrPrnrCntcPntVOS() != null){
					//contact info 정보삭제
					dbDao.deleteSppUserBidInfosData(mnrPartnerGRPVO.getMnrPartnerVO());
					
					MnrPrnrCntcPntVO[] mnrPrnrCntcPntVOS = mnrPartnerGRPVO.getMnrPrnrCntcPntVOS();
					
					for ( int i = 0; i< mnrPrnrCntcPntVOS.length; i++ ) {      
						//mnrPrnrCntcPntVOS[i].setMnrPrnrCreSeq(mnrPrnrSeq);
						
						mnrPrnrCntcPntVOS[i].setMnrCntcPrnrNm(URLDecoder.decode(mnrPrnrCntcPntVOS[i].getMnrCntcPrnrNm(),"UTF-8"));
						mnrPrnrCntcPntVOS[i].setMnrPrnrAddr(URLDecoder.decode(mnrPrnrCntcPntVOS[i].getMnrPrnrAddr(),"UTF-8"));
						
						modifyVoList.add(mnrPrnrCntcPntVOS[i]);  
					}                 
					 	
					if ( modifyVoList.size() > 0 ) {  
						dbDao.insertSppUserBidInfosData(modifyVoList);
					}   
				}
			} 
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 이벤트 처리<br>  
	 * Pso user 정보를 수정함.
	 * 
	 * @param MdmVendorVO mdmVendorVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */    
	public void modifySppUserPsoInfoBasic(MdmVendorVO mdmVendorVO, SignOnUserAccount account) throws EventException{
		try {     
			    
			if ( mdmVendorVO !=null ) { 
				dbDao.modifySppUserPsoInfoData(mdmVendorVO);
			}   
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
}