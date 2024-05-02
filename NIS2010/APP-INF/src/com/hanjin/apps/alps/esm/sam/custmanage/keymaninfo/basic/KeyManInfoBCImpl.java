/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : KeyManInfoManageBCImpl.java
*@FileTitle : KeyMan Info Management
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.05.09 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.keymaninfo.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.sam.custmanage.keymaninfo.integration.KeyManInfoDBDAO;
import com.hanjin.apps.alps.esm.sam.custmanage.keymaninfo.vo.SamKeyManInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS Business Logic Command Interface<br>
 * - ALPS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author JKLIM
 * @see KeyManInfoBCImpl
 * @since J2EE 1.6 
 */
public class KeyManInfoBCImpl extends BasicCommandSupport implements KeyManInfoBC {

	// Database Access Object
	private transient KeyManInfoDBDAO dbDao = null;

	/**
	 * KeyManInfoManageBCImpl 객체 생성<br>
	 * KeyManInfoManageDBDAO를 생성한다.<br>
	 */
	public KeyManInfoBCImpl() {
		
		dbDao = new KeyManInfoDBDAO();
	}
	
	/**
	 * [ESM_SAM_0302] <br>
	 * KeyMan sheet 정보를 [조회] 합니다.<br>
	 * @param SearchCustomerVO  searchCustomerVO 
	 * @return List<SearchCustomerVO >
	 * @exception EventException
	 */
	
	public List<SamKeyManInfoVO> searchKeyManInfo(String custCntCd, String custSeq) throws EventException {
		try {
			return dbDao.searchKeyManInfo(custCntCd, custSeq);
		}catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * [ESM_SAM_0003]조회<br>
	 * Key man Detail Info을 [조회] 합니다.<br>
	 * @param SamKeyManInfoVO samKeyManInfoVO
	 * @return List<SamKeyManInfoVO>
	 * @exception EventException
	 */
	public List<SamKeyManInfoVO> searchKeyManDetailInfo(SamKeyManInfoVO samKeyManInfoVO) throws EventException{
		try {
			return dbDao.searchKeyManDetailInfo(samKeyManInfoVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SAM_0003] KeyManInfo를 [수정], [추가]합니다.<br>
	 * 
	 * @param SamKeyManInfoVO samKeyManInfoVO
	 * @exception EventException
	 */
	public void manageKeyManInfo(SamKeyManInfoVO samKeyManInfoVO) throws EventException {
		try {
			if(samKeyManInfoVO != null ){
				if("I".equals(samKeyManInfoVO.getIbflag())){
					dbDao.addKeyManInfo(samKeyManInfoVO);
				}else if("U".equals(samKeyManInfoVO.getIbflag())){
					dbDao.modifyKeyManInfo(samKeyManInfoVO);
				}
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SAM_0003] KeyManInfo를 [삭제]합니다.<br>
	 * 
	 * @param SamKeyManInfoVO[] samKeyManInfoVOs
	 * @exception EventException
	 */
	public void deleteKeyManInfo(SamKeyManInfoVO[] samKeyManInfoVOs) throws EventException {
		try {
			if(samKeyManInfoVOs != null ){
				for(int i=0; i<samKeyManInfoVOs.length; i++){
					if("D".equals(samKeyManInfoVOs[i].getIbflag())){
						dbDao.removeKeyManInfo(samKeyManInfoVOs[i]);
					}
				}
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Modify/save/delete event process<br>
	 * Customer Address (ESM_SAM_0302.do)<br>
	 * 
	 * @param SamKeyManInfoVO[] custAddrVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageKeyManCust(SamKeyManInfoVO[] samKeyManInfoVOs, SignOnUserAccount account) throws EventException {

		try {	
			if(samKeyManInfoVOs!=null){
				for(int i=0; i < samKeyManInfoVOs.length; i++) {
//	                int ld_addr_seq = 0;
					if(samKeyManInfoVOs[i].getIbflag().equals("U")){
						samKeyManInfoVOs[i].setCreUsrId(account.getUsr_id());
						samKeyManInfoVOs[i].setUpdUsrId(account.getUsr_id());
						dbDao.modifyKeyManInfo(samKeyManInfoVOs[i]);
			        }else if(samKeyManInfoVOs[i].getIbflag().equals("I")){
			        	samKeyManInfoVOs[i].setCreUsrId(account.getUsr_id());
			        	samKeyManInfoVOs[i].setUpdUsrId(account.getUsr_id());
	                    dbDao.addKeyManInfo(samKeyManInfoVOs[i]);
			        }else if(samKeyManInfoVOs[i].getIbflag().equals("D")){
			        	samKeyManInfoVOs[i].setCreUsrId(account.getUsr_id());
			        	samKeyManInfoVOs[i].setUpdUsrId(account.getUsr_id());
			        	//samKeyManInfoVOs[i].setDeltFlg("Y");
			        	dbDao.removeKeyManInfo(samKeyManInfoVOs[i]);
			        }
				}
			}
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

	}
	
	/**
	 * [ESM_SAM_0307]조회<br>
	 * Key man List를 [조회] 합니다.<br>
	 * @param SamKeyManInfoVO samKeyManInfoVO
	 * @return List<SamKeyManInfoVO>
	 * @exception EventException
	 */
	public List<SamKeyManInfoVO> searchKeyManList(SamKeyManInfoVO samKeyManInfoVO) throws EventException{
		try {
			return dbDao.searchKeyManList(samKeyManInfoVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * KeyManList 저장(insert OR update)<br>
	 * Customer Address (ESM_SAM_0308.do)<br>
	 * 
	 * @param SamKeyManInfoVO samKeyManInfoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageKeyManList(SamKeyManInfoVO samKeyManInfoVO, SignOnUserAccount account) throws EventException {

		try {	
			if(samKeyManInfoVO!=null){
//	                int ld_addr_seq = 0;
					if(samKeyManInfoVO.getIbflag().equals("U")){
						samKeyManInfoVO.setCreUsrId(account.getUsr_id());
						samKeyManInfoVO.setUpdUsrId(account.getUsr_id());
						dbDao.modifyKeyManInfo(samKeyManInfoVO);
			        }else if(samKeyManInfoVO.getIbflag().equals("I")){
			        	samKeyManInfoVO.setCreUsrId(account.getUsr_id());
			        	samKeyManInfoVO.setUpdUsrId(account.getUsr_id());
	                    dbDao.addKeyManInfo(samKeyManInfoVO);
			        }
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

	}
	
	
	
}