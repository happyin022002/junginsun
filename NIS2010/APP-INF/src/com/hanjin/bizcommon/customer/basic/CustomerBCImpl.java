/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CustomerBCImpl.java
*@FileTitle : Customer
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-09
*@LastModifier : sangyool pak
*@LastVersion : 1.0
* 2006-08-09 sangyool pak
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.customer.basic;

import java.util.List;

import com.hanjin.bizcommon.customer.integration.CustomerDBDAO;
import com.hanjin.bizcommon.customer.vo.SearchCustomerVO;
import com.hanjin.bizcommon.customer.vo.SearchSrepVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ENIS-BIZCOMMON Business Logic Basic Command implementation<br>
 * - ENIS-BIZCOMMON에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author sangyool pak
 * @see COM_ENS_041EventResponse,CustomerBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CustomerBCImpl   extends BasicCommandSupport implements CustomerBC {

    // Database Access Object
    private transient CustomerDBDAO dbDao=null;

    /**
     * CustomerBCImpl 객체 생성<br>
     * CustomerDBDAO를 생성한다.<br>
     */ 
    public CustomerBCImpl(){
        dbDao = new CustomerDBDAO();
    }

	/**
	 * Customer List 조회<br>
	 * @param String custCd
	 * @param String custNm
	 * @param String ofcCd
	 * @param int iPage
	 * @param String include
	 * @param String cust
	 * @param String zipCd
	 * @return List<SearchCustomerVO>
	 * @throws EventException
	 */
    public List<SearchCustomerVO> searchCustomerList(String custCd, String custNm, String ofcCd, int iPage, String include, String cust, String zipCd) throws EventException {
        try {
			return  dbDao.searchCustomerList(custCd, custNm, ofcCd, iPage, include, cust, zipCd);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
		} catch (Exception e2) {
			log.error("err "+e2.toString(),e2);
            throw new EventException(e2.getMessage());
		}
    }
    
    public List<SearchSrepVO> searchSrepList(String srepCd, String srepNm, String ofcCd, String gloUsrId, int iPage) throws EventException {
        try {
			return  dbDao.searchSrepList(srepCd, srepNm, ofcCd, gloUsrId, iPage);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
		} catch (Exception e2) {
			log.error("err "+e2.toString(),e2);
            throw new EventException(e2.getMessage());
		}
    }

    /**
     * Customer업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        dbDao = null;
    }
}