/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMdmRejectCustBCImpl.java
 *@FileTitle : NIS2010 MDM ACCOUNT Interface
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2017-08-09
 *@LastModifier : JKLim
 *@LastVersion : 1.1
 * 2017-08-09 JKLim		1.0 ALPS 
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import com.hanjin.apps.alps.common.mdmSync.jms.vo.RejectMdmCustVO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmRejectCustDBDAO;

/**
 * NIS2010-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  NIS2010-MDM0020001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Sun, Choi
 * @see ReceiveQueueBC,MDM0020001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmRejectCustBCImpl extends BasicCommandSupport implements ReceiveQueueMdmRejectCustBC {

	private transient ReceiveQueueMdmRejectCustDBDAO dbDao = null;
	private String opCd = "";
	private String msgCreDt = "";

	/** MsgCreDt getter 메서드.<br>
	 */
	public String getMsgCreDt() {
		return msgCreDt;
	}
	
	/** MsgCreDt setter 메서드.<br>
	 * @param msgCreDt String
	 */
	public void setMsgCreDt(String msgCreDt) {
		this.msgCreDt = msgCreDt;
	}

	/** ReceiveQueueMDM_ACCOUNTBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmRejectCustBCImpl() {
		dbDao = new ReceiveQueueMdmRejectCustDBDAO();
	}

	/** opCd getter 메서드.<br>
	 */
	public String getOpCd() {
		return opCd;
	}

	/** opCd setter 메서드.<br>
	 * @param opCd String
	 */
	public void setOpCd(String opCd) {
		this.opCd = opCd;
	}

	/** DBDAO의 removeMDMACCOUNT메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	@Override
	public boolean removeMDMTB(Object vo) throws DAOException{
		boolean isSuccessful = false;
		int delCnt = 0;
		try {
			RejectMdmCustVO rejectMdmCustVO = (RejectMdmCustVO)vo;
			delCnt = dbDao.removeMdmRejectCust(rejectMdmCustVO);
			if( delCnt > 0 ) isSuccessful = true;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
	}
}