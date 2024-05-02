/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingARCreationEAIDAO.java
*@FileTitle : Invoice Update by User ID
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.06.01 한동훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.List;

import org.apache.log4j.Logger;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExRateCountVO;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;

/**
 * BookingARCreationEAIDAO <br>
 * - BookingARCreation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Han Dong Hoon
 * @see BookingARCreationBCImpl 참조
 * @since J2EE 1.6
 */
public class BookingARCreationEAIDAO extends EAIDAOSupport{
	
	private transient Logger log = Logger.getLogger(BookingARCreationEAIDAO.class.getName());
	
	
	/**
	 * FNS_INV_0027<br>
	 * 경리환율, VVD 환율 등 환율 정보과 없는 경우 해당 테이블의 환율을 읽어 일괄 Update 하기 위한 BackEndJob의 LoadFile함수를 통해 결과를 조회한다.<br>
	 * 
	 * @param String key
	 * @return List<ExRateCountVO>
	 * @exception EventException, DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ExRateCountVO> getBackEndJobResutModifyExchangeRateList(String key) throws Exception, DAOException {
		try {
			return (List<ExRateCountVO>)BackEndJobResult.loadFromFile(key);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 특정 Interface Data 에 대한 Booking Interface data 를 생성하기 위한 BackEndJob의 LoadFile함수를 통해 결과를 조회한다.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException, DAOException
	 */
	public String getBackEndJobResutCreateBKGInvoice(String key) throws Exception, DAOException {
		try {
			return (String)BackEndJobResult.loadFromFile(key);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}
