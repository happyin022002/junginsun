/*=========================================================
*Copyright(c) 2011 CyberLogitec
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
package com.clt.apps.opus.esm.sam.generalinfomanage.keymaninfomanage.basic;

import java.util.List;

import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchCustomerVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.keymaninfomanage.integration.KeyManInfoManageDBDAO;
import com.clt.apps.opus.esm.sam.generalinfomanage.keymaninfomanage.vo.SamKeyManInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-GeneralInfoManage Business Logic Command Interface<br>
 * - OPUS-GeneralInfoManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author NAMKOONGJINHO
 * @see KeyManInfoManageBCImpl
 * @since J2EE 1.6
 */
public class KeyManInfoManageBCImpl extends BasicCommandSupport implements KeyManInfoManageBC {

	// Database Access Object
	private transient KeyManInfoManageDBDAO dbDao = null;

	/**
	 * KeyManInfoManageBCImpl 객체 생성<br>
	 * KeyManInfoManageDBDAO를 생성한다.<br>
	 */
	public KeyManInfoManageBCImpl() {
		
		dbDao = new KeyManInfoManageDBDAO();
	}
	
	/**
	 * [ESM_SAM_0003] <br>
	 * KeyMan sheet 정보를 [조회] 합니다.<br>
	 * @param SearchCustomerVO  searchCustomerVO 
	 * @return List<SearchCustomerVO >
	 * @exception EventException
	 */
	
	public List<SearchCustomerVO> searchKeyManInfo(SearchCustomerVO searchCustomerVO) throws EventException {
		try {
			return dbDao.searchKeyManInfo(searchCustomerVO);
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
	
}