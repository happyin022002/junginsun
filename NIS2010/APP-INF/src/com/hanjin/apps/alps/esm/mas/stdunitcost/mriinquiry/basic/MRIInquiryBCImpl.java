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
package com.hanjin.apps.alps.esm.mas.stdunitcost.mriinquiry.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.demdet3rd.vo.DemDet3rdVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mriinquiry.integration.MRIInquiryDBDAO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mriinquiry.vo.SearchMRIInquiryListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MasMonMiscRevPreTeuVO;


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
	 * ESM_MAS_0152 화면에 대한 조회 이벤트 처리<br>
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
	 * ESM_MAS_0152 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param MasMonMiscRevPreTeuVO[] masMonMiscRevPreTeuVO
	 * @param SearchConditionVO searchConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiMRIInquiry(MasMonMiscRevPreTeuVO[] masMonMiscRevPreTeuVO, SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<MasMonMiscRevPreTeuVO> insertVoList = new ArrayList<MasMonMiscRevPreTeuVO>();
			List<MasMonMiscRevPreTeuVO> updateVoList = new ArrayList<MasMonMiscRevPreTeuVO>();
	        List<MasMonMiscRevPreTeuVO> deleteVoList = new ArrayList<MasMonMiscRevPreTeuVO>();

			for ( int i=0; i<masMonMiscRevPreTeuVO .length; i++ ) {
				if ( masMonMiscRevPreTeuVO[i].getIbflag().equals("I")){
					 masMonMiscRevPreTeuVO[i].setCreUsrId(account.getUsr_id());
					 masMonMiscRevPreTeuVO[i].setUpdUsrId(account.getUsr_id());	
					 insertVoList.add(masMonMiscRevPreTeuVO[i]);
				} else if ( masMonMiscRevPreTeuVO[i].getIbflag().equals("U")){
					masMonMiscRevPreTeuVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(masMonMiscRevPreTeuVO[i]);
                }else if ( masMonMiscRevPreTeuVO[i].getIbflag().equals("D")){
                    masMonMiscRevPreTeuVO[i].setUpdUsrId(account.getUsr_id());
                    deleteVoList.add(masMonMiscRevPreTeuVO[i]);
                    
                }
			}
	        if ( deleteVoList.size() > 0 ) {
	            dbDao.removeMasMonMiscRevPreTeu(deleteVoList, searchConditionVO);
	        }
			if ( insertVoList.size() > 0 ) {
				dbDao.addMasMonMiscRevPreTeu(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMasMonMiscRevPreTeu(updateVoList, searchConditionVO);
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
     * [비즈니스대상]을 [행위] 합니다.<br>
     * 
     * @param SearchConditionVO conditionVO
     * @return List<MRIInquiryVO>
     * @exception EventException
     */
    public Integer searchMRIInquiryMonthCount(SearchConditionVO conditionVO) throws EventException{
        conditionVO.unDataFormat();

        try {
            return dbDao.searchMRIInquiryMonthCount(conditionVO);
        } catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }
    
    public void createMRIInquiryMonthCopy(SearchConditionVO conditionVO, SignOnUserAccount account)throws EventException{
        HashMap<String, String> param = new HashMap<String, String>();

        try {
            //파라미터 세팅
            param.put("f_src_mon"       , conditionVO.getFSrcMon().replaceAll("-", ""));
            param.put("f_tar_mon"       , conditionVO.getFTarMon().replaceAll("-", ""));
            param.put("user_id"         , account.getUsr_id());

            //1. TARGET 해당월을 삭제한다.
            dbDao.removeMRIInquiryMonth(param);
            //2. CSOURCE 해당월을 복사해서  TARGET 데이타를 생성한다. 
            dbDao.addMRIInquiryMonthCopy(param);
            dbDao.addMRIInquiryStatusMonthCopy(param);

         } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
        }       
    }
 
	
}