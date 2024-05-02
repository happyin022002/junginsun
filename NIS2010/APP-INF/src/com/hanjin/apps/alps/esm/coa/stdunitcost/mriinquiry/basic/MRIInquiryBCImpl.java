/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : MRIInquiryBCImpl.java
*@FileTitle      : MRI 운임수입 단가 생성
*Open Issues     :
*@LastModifyDate : 2009-09-17
*@LastModifier   : PEJ
*				        장영석
*@LastVersion    : 1.4
* 2008-04-30 PEJ
* 1.0 최초 생성
* Change history  :
* 2009-09-17 장영석  New Framework 적용 [0152]
* 2010.02.05 임옥영 품질검토 결과 반영
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.mriinquiry.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mriinquiry.integration.MRIInquiryDBDAO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mriinquiry.vo.SearchMRIInquiryListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.CoaMonMiscRevPreTeuVO;


/**
 * ALPS-STDUnitCost Business Logic Command Interface<br>
 * - ALPS-STDUnitCost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Yeong-seok
 * @see MRIInquiryBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class MRIInquiryBCImpl extends BasicCommandSupport implements MRIInquiryBC {

	// Database Access Object
	private transient MRIInquiryDBDAO dbDao = null;

	/**
	 * MRIInquiryBCImpl 객체 생성<br>
	 * MRIInquiryDBDAO를 생성한다.<br>
	 */
	public MRIInquiryBCImpl() {
		dbDao = new MRIInquiryDBDAO();
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_0152 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchMRIInquiryListVO searchMRIInquiryListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMRIInquiryListVO>
	 * @exception EventException
	 */
	public List<SearchMRIInquiryListVO> searchMRIInquiryList(SearchMRIInquiryListVO searchMRIInquiryListVO 
													   ,SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchMRIInquiryList(searchMRIInquiryListVO, searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_COA_0152 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param CoaMonMiscRevPreTeuVO[] coaMonMiscRevPreTeuVO
	 * @param SearchConditionVO searchConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiMRIInquiry(CoaMonMiscRevPreTeuVO[] coaMonMiscRevPreTeuVO, SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<CoaMonMiscRevPreTeuVO> insertVoList = new ArrayList<CoaMonMiscRevPreTeuVO>();
			List<CoaMonMiscRevPreTeuVO> updateVoList = new ArrayList<CoaMonMiscRevPreTeuVO>();
			for ( int i=0; i<coaMonMiscRevPreTeuVO .length; i++ ) {
				if ( coaMonMiscRevPreTeuVO[i].getIbflag().equals("I")){
					 coaMonMiscRevPreTeuVO[i].setCreUsrId(account.getUsr_id());
					 coaMonMiscRevPreTeuVO[i].setUpdUsrId(account.getUsr_id());	
					 insertVoList.add(coaMonMiscRevPreTeuVO[i]);
				} else if ( coaMonMiscRevPreTeuVO[i].getIbflag().equals("U")){
					coaMonMiscRevPreTeuVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(coaMonMiscRevPreTeuVO[i]);
				} 
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addCoaMonMiscRevPreTeu(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCoaMonMiscRevPreTeu(updateVoList, searchConditionVO);
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
}