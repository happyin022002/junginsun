/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : SLTIntBCImpl.java
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
package com.clt.apps.opus.esm.coa.stdunitcost.sltint.basic;

import java.util.ArrayList;
import java.util.List;
import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.EqRepoCostVO;
import com.clt.apps.opus.esm.coa.stdunitcost.sltint.integration.SLTIntDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.apps.opus.esm.coa.stdunitcost.sltint.vo.SlotInternalPricingVO;

/**
 * OPUS-STDUnitCost Business Logic Command Interface<br>
 * - OPUS-STDUnitCost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Yeong-seok
 * @see SLTIntBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SLTIntBCImpl extends BasicCommandSupport implements SLTIntBC {

	// Database Access Object
	private transient SLTIntDBDAO dbDao = null;

	/**
	 * SLTIntBCImpl 객체 생성<br>
	 * SLTIntDBDAO를 생성한다.<br>
	 */
	public SLTIntBCImpl() {
		dbDao = new SLTIntDBDAO();
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4001 화면 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 * @author SJH.20140916.ADD
	 */
    public CommonCoaRsVO searchSlotIPList(SearchConditionVO searchVO) throws EventException {
        try {
        	CommonCoaRsVO retVo = new CommonCoaRsVO();
			            
			retVo = dbDao.searchSlotIPList(searchVO, retVo);
            return retVo;
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	
    
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4001 화면 대한 멀티 이벤트 처리<br>
     * 
     * @param SlotInternalPricingVO[] slotInternalPricingVO
     * @param SearchConditionVO searchConditionVO
     * @param SignOnUserAccount account 
     * @return String
     * @exception EventException
     * @author SJH.20140916.ADD
     */
    public String multiSlotIPInfo(SlotInternalPricingVO[] slotInternalPricingVO, SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException{
		try {
			String result = "S";
			int[] checkCnt = new int[] {0,0};
			//SJH.20141224.ADD
			List<SlotInternalPricingVO> insertVoList = new ArrayList<SlotInternalPricingVO>();
			List<SlotInternalPricingVO> updateVoList = new ArrayList<SlotInternalPricingVO>();
			List<SlotInternalPricingVO> deleteVoList = new ArrayList<SlotInternalPricingVO>();
			
			for ( int i=0; i<slotInternalPricingVO .length; i++ ) {				
				if ( slotInternalPricingVO[i].getIbflag().equals("I")){
					 slotInternalPricingVO[i].setCreUsrId(account.getUsr_id());
					 slotInternalPricingVO[i].setUpdUsrId(account.getUsr_id());	
					 checkCnt = dbDao.checkSltInt(slotInternalPricingVO[i]);		//Dup Check, get Max Seq 
//					 if(checkCnt[0] == 0){
						 slotInternalPricingVO[i].setrtSeq(String.valueOf(checkCnt[1]));						 
						 dbDao.addSlotInternalPricing(slotInternalPricingVO[i]);
						 insertVoList.add(slotInternalPricingVO[i]);
//					 }else{
//						result = "Dup";
//					 }
				} else if ( slotInternalPricingVO[i].getIbflag().equals("U")){
					slotInternalPricingVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(slotInternalPricingVO[i]);
				} else if ( slotInternalPricingVO[i].getIbflag().equals("D")){
					slotInternalPricingVO[i].setUpdUsrId(account.getUsr_id());	
					deleteVoList.add(slotInternalPricingVO[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifySlotInternalPricing(updateVoList, searchConditionVO);
			}

			if ( deleteVoList.size() > 0 ) {
				dbDao.removeSlotInternalPricing(deleteVoList);
			}
			
			//SJH.20141224.ADD : EFF_TO_YRMON 일괄 update
//			if (insertVoList.size() > 0 || updateVoList.size() > 0) { 
				dbDao.batchUpSltIntPrc();  // Effective date update 최종 한번만 실행
//				log.debug("######## batch update cnt : "+batCnt.length);
//			}			
			
			return result;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}     
	
}