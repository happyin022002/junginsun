/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : CustGroupBCImpl.java
*@FileTitle : CustGroup
*Open Issues :
*Change history :
*@LastModifyDate : 2017-07-12
*@LastModifier : Lim Jaekwan
*@LastVersion : 1.0
* 2017-07-12 Lim Jaekwan
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custgroup.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custgroup.integration.CustGroupDBDAO;
import com.hanjin.apps.alps.esm.sam.custmanage.custgroup.vo.CustomerGroupCodeVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custgroup.vo.SearchCustGroupVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.basic.CustMainBC;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.basic.CustMainBCImpl;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.integration.CustMainDBDAO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.integration.CustMainEAIDAO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerPerformanceVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.ConvertUtils;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * CustGroupBCImpl Business Logic Basic Command implementation<br>
 * - CustGroupBCImpl에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Lim Jaekwan
 * @see ESM_SAM_0306EventResponse,CustGroupBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CustGroupBCImpl   extends BasicCommandSupport implements CustGroupBC {

    // Database Access Object
    private transient CustGroupDBDAO dbDao=null;
    private transient CustMainDBDAO dbDaoMain=null;
    private transient CustMainEAIDAO eaiDao = null;

    /**
     * CustGroupBCImpl 객체 생성<br>
     * CustGroupDBDAO를 생성한다.<br>
     */
    public CustGroupBCImpl(){
        dbDao = new CustGroupDBDAO();
        dbDaoMain = new CustMainDBDAO();
        eaiDao = new CustMainEAIDAO();
    }
    
	/**
	 * Customer Coderetrieve.(ESM_SAM_0306)<br>
	 * 
	 * @param String custCd
	 * @return CustomerPerformanceVO
	 * @exception EventException
	 */
	public CustomerPerformanceVO searchCustPerfCode(String custCd) throws EventException {
		CustomerPerformanceVO customerPerformanceVO = null;
		try {
			customerPerformanceVO = dbDao.searchCustPerfCode(custCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return customerPerformanceVO;
	}


	/**
	 * CustGroup List 조회<br>
	 * @param String custGrpId
	 * @param String custGrpNm
	 * @param String ofcCd
	 * @param int iPage
	 * @param String mdmYn
	 * @param String deltFlg
	 * @param String custGrpAbbrNm
	 * @return List<SearchCustGroupVO>
	 * @throws EventException
	 */
    public List<SearchCustGroupVO> searchCustGroupList(String custGrpId, String custGrpNm, String ofcCd, int iPage, String mdmYn, String deltFlg, String custGrpAbbrNm) throws EventException {
        try {
			return  dbDao.searchCustGroupList(custGrpId, custGrpNm, ofcCd, iPage, mdmYn, deltFlg, custGrpAbbrNm);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
		} catch (Exception e2) {
			log.error("err "+e2.toString(),e2);
            throw new EventException(e2.getMessage());
		}
    }
    
	/**
	 * ESM_SAM_0306 : Retrieve<br>
	 * Group Code에 해당하는 Customer Detail 정보를 조회합니다.<br>
	 * 
	 * @param CustomerGroupCodeVO customerGroupCodeVO
	 * @return List<CustomerGroupCodeVO>
	 * @exception EventException
	 */	
	public List<CustomerGroupCodeVO> searchCustGroupDetail(String custCd)throws EventException {
		try {
			return dbDao.searchCustomerGroupCodeDetail(custCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
	}
	
	/**
	 * Modify/save/delete event process<br>
	 * Customer Performance Group  (ESM_SAM_0306.do)<br>
	 * 
	 * @param CustomerPerformanceVO customerPerformanceVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustPerfCode(CustomerPerformanceVO customerPerformanceVO, SignOnUserAccount account) throws EventException {
		try {		
			if(customerPerformanceVO.getIbflag().equals("U")){
				customerPerformanceVO.setUpdUsrId(account.getUsr_id());
			    dbDao.modifyCustPerfCode(customerPerformanceVO);
			    
			    sendCustGroupToMdm(customerPerformanceVO.getCustGrpId(), account.getUsr_id(), "N");
			   
			/*}else if(customerPerformanceVO.getIbflag().equals("I")){
				customerPerformanceVO.setCreUsrId(account.getUsr_id());
				customerPerformanceVO.setUpdUsrId(account.getUsr_id());
		
				dbDao.addCustPerfCode(customerPerformanceVO);
				
				dbDao.modifyCustGroupRepCode(customerPerformanceVO.getCustGrpId(), customerPerformanceVO.getCustCd(), account.getUsr_id());*/
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

	}
	
	/**
	 * Customer 정보를 EAI로 전송한다. <BR>
	 * @param String eaiIfTp
	 * @param String eaiIfMsg
	 * @param CustomerVO customerVo
	 */
	public void sendCustGroupToMdm(String custGrpId, String usrId, String creFlag) throws EventException {
		CustomerPerformanceVO customerPerformanceVO = null;
		CustomerVO customerVo = new CustomerVO();
		try{
			customerPerformanceVO = dbDao.searchCustPerfCode(custGrpId);
			log.debug("Customer EAI Start : ");		
			if (customerPerformanceVO != null){
				customerVo.setCustStsCd(customerPerformanceVO.getCustStsCd());
				customerVo.setGrpIndivDiv(customerPerformanceVO.getGrpIndivDiv());
				customerVo.setOfcCd(customerPerformanceVO.getOfcCd());
				customerVo.setSrepCd(customerPerformanceVO.getSrepCd());
				customerVo.setDeltFlg(customerPerformanceVO.getDeltFlg());
				
				customerVo.setCustCd(customerPerformanceVO.getCustGrpId());
				customerVo.setCustLglEngNm(customerPerformanceVO.getCustGrpNm());
				
				customerVo.setCreUsrId(customerPerformanceVO.getCreUsrId());
				customerVo.setUpdUsrId(customerPerformanceVO.getUpdUsrId());
				//customerVo = (CustomerVO) ConvertUtils.hashMapToVO(customerPerformanceVO.getColumnValues(), customerVo);
				eaiDao.sendCustomerToMdm(customerVo, usrId, creFlag);
			}
		}catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
	}
	
	/**
	 * Add event process<br>
	 * Group customer (ESM_SAM_0306.do)<br>
	 * 
	 * @param CustomerAddressVO[] custAddrVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustGroupCode(CustomerGroupCodeVO[] custGroupVOs, SignOnUserAccount account) throws EventException {
		CustMainBC 	CustMainBC	        = new CustMainBCImpl();

		try {	
			if(custGroupVOs!=null){
				for(int i=0; i < custGroupVOs.length; i++) {
			        if(custGroupVOs[i].getIbflag().equals("I") || custGroupVOs[i].getIbflag().equals("D")){
			        	custGroupVOs[i].setUpdUsrId(account.getUsr_id());
			        	Integer ld_cust_his_seq = searchCntCustHisSeq(custGroupVOs[i].getCustCd().substring(0,2), custGroupVOs[i].getCustCd().substring(2,8));
						
						if (ld_cust_his_seq==0) {
							dbDaoMain.addCustHistMig(custGroupVOs[i].getCustCd().substring(0,2), custGroupVOs[i].getCustCd().substring(2,8), account.getUsr_id());
						}
						
	                    dbDao.modifyCustGroupCode(custGroupVOs[i]);
	                    
	                    CustMainBC.sendCustomerToMdm(custGroupVOs[i].getCustCd().substring(0,2), custGroupVOs[i].getCustCd().substring(2,8), account.getUsr_id(), "N");
	                    
	                    dbDaoMain.addCustHist(custGroupVOs[i].getCustCd().substring(0,2), custGroupVOs[i].getCustCd().substring(2,8), account.getUsr_id());
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
	 * Customer Address(MDM_CUST_ADDR) 테이블의 MAX ADDR_SEQ 를 가져온다.(ESM_SAM_0302)<br>
	 * Customer Address Max Seq retrieve.<br>
	 * 
	 * @param  String custcntcd
	 * @param  String custseq
	 * @return int
	 * @exception EventException
	 */
	public int searchCntCustHisSeq(String custcntcd, String custseq) throws EventException{
		DBRowSet rowSet = null;
		int ld_addr_seq = 0;

        try {
            rowSet=dbDaoMain.searchCntCustHisSeq(custcntcd, custseq);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		ld_addr_seq = rowSet.getInt(1);
            	}
            }
            return ld_addr_seq;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}


    /**
     * BIZCOMMON 업무 시나리오 마감작업<br>
     * Customer업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        dbDao = null;
    }
}