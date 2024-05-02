/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemDet3rdBCImpl.java
*@FileTitle : DEM/DET 3RD조회수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.08.25 송호진
* 1.0 Creation
* 2017.05.15 송민석 ERP MAS의 Phase out에 따라 영향 받는 화면에 대한 수정 프로젝트 1차
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.demdet3rd.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.mas.stdunitcost.demdet3rd.integration.DemDet3rdDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esm.mas.stdunitcost.demdet3rd.vo.DemDet3rdVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;

/**
 * ALPS-STDUnitCost Business Logic Command Interface<br>
 * - ALPS-STDUnitCost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Song Ho Jin
 * @see DemDet3rdBC 참조
 * @since J2EE 1.6
 */
public class DemDet3rdBCImpl extends BasicCommandSupport implements DemDet3rdBC {

	// Database Access Object
	private transient DemDet3rdDBDAO dbDao = null;

	/**
	 * DemDet3rdBCImpl 객체 생성<br>
	 * DemDet3rdDBDAO를 생성한다.<br>
	 */
	public DemDet3rdBCImpl() {
		dbDao = new DemDet3rdDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO conditionVO
	 * @return List<DemDet3rdVO>
	 * @exception EventException
	 */
	public List<DemDet3rdVO> searchDEMDET3RDList(SearchConditionVO conditionVO) throws EventException {
		
		conditionVO.unDataFormat();

		try {
			return dbDao.searchDEMDET3RDList(conditionVO);
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
	 * @param DemDet3rdVO[] demDet3rdVO
	 * @param SearchConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiDEMDET3RD(DemDet3rdVO[] demDet3rdVO, SearchConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {			
			List<DemDet3rdVO> updateVoList = new ArrayList<DemDet3rdVO>();
	        List<DemDet3rdVO> deleteVoList = new ArrayList<DemDet3rdVO>();
	        List<DemDet3rdVO> insertVoList = new ArrayList<DemDet3rdVO>();

			for ( int i=0; i<demDet3rdVO .length; i++ ) {
				 if ( demDet3rdVO[i].getIbflag().equals("U")){
					demDet3rdVO[i].setUpdUsrId(account.getUsr_id());
					demDet3rdVO[i].setCostYrmon(conditionVO.getFCostYrmon().replaceAll("-", ""));
					updateVoList.add(demDet3rdVO[i]);
				}else if ( demDet3rdVO[i].getIbflag().equals("I")){
                    demDet3rdVO[i].setCreUsrId(account.getUsr_id());
                    demDet3rdVO[i].setUpdUsrId(account.getUsr_id());
                    demDet3rdVO[i].setCostYrmon(conditionVO.getFCostYrmon().replaceAll("-", ""));
                    insertVoList.add(demDet3rdVO[i]);				    
				}else if ( demDet3rdVO[i].getIbflag().equals("D")){
                    demDet3rdVO[i].setUpdUsrId(account.getUsr_id());
                    demDet3rdVO[i].setCostYrmon(conditionVO.getFCostYrmon().replaceAll("-", ""));
                    deleteVoList.add(demDet3rdVO[i]);
				    
				}
			}			
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeDEMDET3RD(deleteVoList);
			}			
 
            if ( updateVoList.size() > 0 ) {
                dbDao.modifyDEMDET3RD(updateVoList);
            }   
            if ( insertVoList.size() > 0 ) {
                dbDao.addDEMDET3RD(insertVoList);
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
     * @return List<DemDet3rdVO>
     * @exception EventException
     */
    public Integer searchDemDet3rdMonthCount(SearchConditionVO conditionVO) throws EventException{
        conditionVO.unDataFormat();

        try {
            return dbDao.searchDemDet3rdMonthCount(conditionVO);
        } catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }
    
    public void createDemDet3rdMonthCopy(SearchConditionVO conditionVO, SignOnUserAccount account)throws EventException{
        HashMap<String, String> param = new HashMap<String, String>();

        try {
            //파라미터 세팅
            param.put("f_src_mon"       , conditionVO.getFSrcMon().replaceAll("-", ""));
            param.put("f_tar_mon"       , conditionVO.getFTarMon().replaceAll("-", ""));
            param.put("user_id"         , account.getUsr_id());

            //1. TARGET 해당월을 삭제한다.
            dbDao.removeDemDet3rdMonth(param);
            //2. CSOURCE 해당월을 복사해서  TARGET 데이타를 생성한다. 
            dbDao.addDemDet3rdMonthCopy(param);
            dbDao.addDemDet3rdStatusMonthCopy(param);

         } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
        }       
    }
 
	
}