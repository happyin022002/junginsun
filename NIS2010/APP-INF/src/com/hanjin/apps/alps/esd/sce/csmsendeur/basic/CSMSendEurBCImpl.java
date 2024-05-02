/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSMSendBCImpl.java
*@FileTitle : CSM (Container Status Message) 구주세관 전송 
*Open Issues :
*Change history :
*@LastModifyDate : 2016-06-15
*@LastModifier :
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.csmsendeur.basic;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.hanjin.apps.alps.esd.sce.csmsendeur.integration.CSMSendEurDBDAO;
import com.hanjin.apps.alps.esd.sce.csmsendeur.integration.CSMSendEurEAIDAO;
import com.hanjin.apps.alps.esd.sce.csmsendeur.vo.CSMSendEurVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * ENIS-SCEM Business Logic Basic Command implementation<br>
 * - ENIS-SCEM에 대한 비지니스 로직을 처리한다.<br>
 * @author 2002701
 * @see
 * @since J2EE 1.4
 */
public class CSMSendEurBCImpl extends BasicCommandSupport implements CSMSendEurBC {
	CSMSendEurDBDAO dbDao = null;
	CSMSendEurEAIDAO eaiDao = null;
	
	/**
	 * Default Constructor
	 */
	public CSMSendEurBCImpl() {
		dbDao = new CSMSendEurDBDAO();
		eaiDao = new CSMSendEurEAIDAO();
	}
	
	/**
	 * Movement data 의 처리 결과를 Update 한다.
	 * 99 : 정상 발생, queue 전송 완료
	 * XX : process 진행 중
	 * 
	 * @param cSMSendEurVO
	 * @throws EventException
	 */
	public void updateActUmchTpCd(CSMSendEurVO cSMSendEurVO) throws EventException {
		try {
			dbDao.updateActUmchTpCd(cSMSendEurVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	
	/**
	 * Movement 발생 건 별로 Flat File 을 생성한다.
	 * @param CSMSendEurVO cSMSendEurVO
	 * @return int
	 * @throws EventException
	 */
	public int insertFlatFile(CSMSendEurVO cSMSendEurVO) throws EventException {
		int rowCnt = 0;
		try {
			dbDao.insertFlatFile(cSMSendEurVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return rowCnt;
	}
	
	
	/**
	 * 미 전송 건 전부 QUEUE 로 전송
	 * @param CSMSendEurVO cSMSendEurVO
	 * @throws EventException
	 */
	public void sendFlatFileIntoQueue(CSMSendEurVO cSMSendEurVO) throws EventException {
		
		try {
			DBRowSet rowSet = dbDao.searchFlatFileToBeSent(cSMSendEurVO);
			
			while (rowSet.next()) {
				StringBuffer output = new StringBuffer();
				String edi_snd_desc = "";
				
				Reader input = null;				
				
				String edi_snd_yrmondy = rowSet.getString("EDI_SND_YRMONDY");
				int edi_snd_seq = rowSet.getInt("EDI_SND_SEQ");
				
				String act_rcv_dt = rowSet.getString("ACT_RCV_DT");
				String act_rcv_no = rowSet.getString("ACT_RCV_NO");
				
				input = rowSet.getClob("EDI_SND_DESC").getCharacterStream();
				
				char[] buffer = new char[1024];
                int byteRead;

                while((byteRead=input.read(buffer,0,1024))!=-1){
                  output.append(buffer,0,byteRead);
                }
                input.close();
                edi_snd_desc = output.toString();
                
				String rslt = eaiDao.sendFlatFileIntoQueue(edi_snd_desc);
				
				if (rslt.equalsIgnoreCase("SUCCESS")) {
					log.debug("============================= edi_snd_yrmondy : "+edi_snd_yrmondy);
					log.debug("============================= edi_snd_seq : "+edi_snd_seq);
					log.debug("============================= SUCCESS(Sent) ");
					
					dbDao.updateSendResultQuery(edi_snd_yrmondy, edi_snd_seq, "Y", "SUCCESS(Sent)", "F");
					dbDao.updateActUmchTpCd(act_rcv_dt, act_rcv_no, "99");
				} else {
					dbDao.updateSendResultQuery(edi_snd_yrmondy, edi_snd_seq, "N", "Sent Failed", "F");
					dbDao.updateActUmchTpCd(act_rcv_dt, act_rcv_no, "80");
				}
			}
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());
		} catch (IOException ie) {
			log.error("err "+ie.toString(),ie);
			throw new EventException(ie.getMessage());
		} catch (Exception e) {
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * parameter 에 해당 되는 전송 성공 log 가 존재하는 지를 확인한다.
	 * 존재한다면 해당 전송은 skip 된다.
	 * 
	 * @param cSMSendEurVO
	 * @return boolean
	 */
	public boolean searchDupSndRslt(CSMSendEurVO cSMSendEurVO) throws EventException{
		boolean isExists = false;
		try {
			isExists = dbDao.searchDupSndRslt(cSMSendEurVO);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return isExists;
	}

}