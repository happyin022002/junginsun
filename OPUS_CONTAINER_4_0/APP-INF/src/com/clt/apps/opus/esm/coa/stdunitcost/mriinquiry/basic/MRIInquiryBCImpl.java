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
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.mriinquiry.basic;

import java.util.ArrayList;
import java.util.List;
import com.clt.apps.opus.esm.coa.common.vo.GetCodeSelectVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mriinquiry.integration.MRIInquiryDBDAO;
import com.clt.apps.opus.esm.coa.stdunitcost.mriinquiry.vo.SearchMRIInquiryListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaMonMiscRevPreTeuVO;

/**
 * OPUS-STDUnitCost Business Logic Command Interface<br>
 * - OPUS-STDUnitCost에 대한 비지니스 로직에 대한 인터페이스<br>
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
			List<CoaMonMiscRevPreTeuVO> deleteVoList = new ArrayList<CoaMonMiscRevPreTeuVO>();
			
			for ( int i=0; i<coaMonMiscRevPreTeuVO .length; i++ ) {
				if ( coaMonMiscRevPreTeuVO[i].getIbflag().equals("I")){
					 coaMonMiscRevPreTeuVO[i].setCreUsrId(account.getUsr_id());
					 coaMonMiscRevPreTeuVO[i].setUpdUsrId(account.getUsr_id());	
					 insertVoList.add(coaMonMiscRevPreTeuVO[i]);
				} else if ( coaMonMiscRevPreTeuVO[i].getIbflag().equals("U")){
					coaMonMiscRevPreTeuVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(coaMonMiscRevPreTeuVO[i]);
				} else if ( coaMonMiscRevPreTeuVO[i].getIbflag().equals("D")){
					deleteVoList.add(coaMonMiscRevPreTeuVO[i]);
				} 
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addCoaMonMiscRevPreTeu(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCoaMonMiscRevPreTeu(updateVoList, searchConditionVO);
			}

			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCoaMonMiscRevPreTeu(deleteVoList);
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
	 * 조회 이벤트 처리<br>
	 * ESM_COA_0152 화면 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchMRIInquiryListVO[] searchMRIInquiryListVO
	 * @return List<GetCodeSelectVO>
	 * @exception EventException
	 */
	public List<GetCodeSelectVO> searchMRIInquiryCheck(SearchMRIInquiryListVO[] searchMRIInquiryListVO) throws EventException {
		try {
			List<GetCodeSelectVO> list = new ArrayList<GetCodeSelectVO>();
			GetCodeSelectVO vo = new GetCodeSelectVO();
			GetCodeSelectVO rowVo = null;
			
			//COMBO 별 조회
			for ( int i=0; i<searchMRIInquiryListVO.length; i++ ) {				
				vo = dbDao.searchMRIInquiryCheck(searchMRIInquiryListVO[i]);
				if (vo == null) {
					rowVo = new GetCodeSelectVO();
					rowVo.setCode(searchMRIInquiryListVO[i].getRlaneCd());
					rowVo.setName("rlane_cd");				// 컬럼명
					rowVo.setKey(String.valueOf(i));		// Row index
					list.add(rowVo);
             	}
			}
			return list;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
}