/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : EDI_ENS_004EventResponse.java
*@FileTitle : USATruck WO 신고 정보
*Open Issues :
*Change history :
*@LastModifyDate : 2008-07-08
*@LastModifier : Park Jun-Yong
*@LastVersion : 1.0
* 2008-07-08 Park Jun-Yong
* 1.0 최초 생성
* N200903270090_테스트 결과서(TD담당)_ AFTT 990 개발 및 204 보완 요청
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.usatruckediwoack.basic;

import com.clt.apps.opus.esd.trs.servicesio.usatruckediwoack.integration.USATruckEdiWoAckManageDBDAO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * eNIS-BIZCOMMON Business Logic Basic Command implementation<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Park Jun-Yong
 * @see EDI_ENS_004EventResponse,USARailWoAckManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class USATruckEdiWoAckManageBCImpl   extends BasicCommandSupport implements USATruckEdiWoAckManageBC {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Database Access Object
	private transient USATruckEdiWoAckManageDBDAO dbDao=null;

	/**
	 * USARailWoAckManageBCImpl 객체 생성<br>
	 * USARailWoAckManageDBDAO를 생성한다.<br>
	 */
	public USATruckEdiWoAckManageBCImpl(){
		dbDao = new USATruckEdiWoAckManageDBDAO();
	}

	/** MQueue를 
	 *  Receive 처리한다.<br>
	 * 중요 : Receive 경우임; queue-mapping.xml 에 정의되어야 서비스 받을 수 있음.  
	 *  - N200903270090_테스트 결과서(TD담당)_ AFTT 990 개발 및 204 보완 요청.
	 *  
	 * @param str
	 * @return
	 * @throws EventException
	 */
	public int receiveUSATruckEdiWoAckManageList(String str) throws EventException {
		
		int resultCount = 0;
		String ack = null;
		String ackhd = null;
		String edi_ctrl_seq = null;
		String edi_so_no = null; 
		String edi_rcv_rslt_cd = null;
		
		
		int len = (str.trim()).length();		
		log.debug("str: " + str );
		ack = str.substring(83,105);
		log.debug("ack: " + ack );
		ackhd = str.substring(52,55);
		log.debug("ackhd: " + ackhd );
	
		
		try {	
			if ( len > 63 ) { 
				if (ack.equals("IFEDI2NIS!USTRUCK_ACK!")){
					edi_ctrl_seq = str.substring(114,123);
					log.debug("bil_edi_ctrl_seq:" + edi_ctrl_seq );	
					edi_rcv_rslt_cd = str.substring(131,132);
					log.debug("bil_edi_rcv_rslt_cd:" + edi_rcv_rslt_cd );	
		        	resultCount = dbDao.addUSATruckEdiWoAckManageList(edi_ctrl_seq, edi_rcv_rslt_cd);										
				} else if (ackhd.equals("990")){
					edi_so_no = str.substring(106,117);
					log.debug("bil_edi_so_no:" + edi_so_no );
					edi_rcv_rslt_cd = str.substring(148,149);
					log.debug("bil_edi_rcv_rslt_cd:" + edi_rcv_rslt_cd );

					resultCount = dbDao.addUSATruckEdi990WoAckManageList(edi_so_no, edi_rcv_rslt_cd);				
				}else {				
					throw new DAOException("HEAD TYPE does not exist");  
				}
			}	        	
        } catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new EventException(e.getMessage());
		}
		return resultCount; 
	}	
		
	/** MQueue를 
	 *  Receive 처리한다.<br>
	 * 중요 : Receive 경우임; queue-mapping.xml 에 정의되어야 서비스 받을 수 있음.  
	 * @param msg
	 * @return
	 * @throws EAIException
	 */
	/*
	public int receiveUSATruckEdiWoAckManageList2(String str) throws EventException {
		
		/*
		int resultCount = 0;
		String ack = null;
		String ackhd = null;
		String edi_ctrl_seq = null;
		String edi_so_no = null; 
		String edi_rcv_rslt_cd = null;
		int len = (str.trim()).length();		
		log.debug("str: " + str );
		ack = str.substring(77,99);
		log.debug("ack: " + ack );
		ackhd = str.substring(52,55);
		log.debug("ackhd: " + ackhd );	
		
		try {	
			if ( len > 63 ) { 
				if (ack.equals("IFEDI2NIS!USTRUCK_ACK!")){
					edi_ctrl_seq = str.substring(108,117);
					log.debug("bil_edi_ctrl_seq: " + edi_ctrl_seq );
					edi_rcv_rslt_cd = str.substring(125,126);
					log.debug("bil_edi_rcv_rslt_cd: " + edi_rcv_rslt_cd );
		        	resultCount = dbDao.addUSATruckEdiWoAckManageList(edi_ctrl_seq, edi_rcv_rslt_cd);										
				} else if (ackhd.equals("990")){
					edi_so_no = str.substring(106,117);
					log.debug("bil_edi_so_no: " + edi_so_no );
					edi_rcv_rslt_cd = str.substring(148,149);
					log.debug("bil_edi_rcv_rslt_cd: " + edi_rcv_rslt_cd );
		        	resultCount = dbDao.addUSATruckEdi990WoAckManageList(edi_so_no, edi_rcv_rslt_cd);				
				}else {				
					throw new DAOException("HEAD TYPE does not exist");  
				}
			}	        	
        } catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new EventException(e.getMessage());
		}
		return resultCount; 
	
		String delim = "/n";
		StringTokenizer st = new StringTokenizer(str, delim);
		String [] arrStr = new String[ st.countTokens()];
		int cnt = 0;
		
	     while(st.hasMoreElements()){
	    	 arrStr[cnt++] =  (String) st.nextElement();
	     }
		
	     
	     
	     
	}	
	*/
	/**
	 * BIZCOMMON 업무 시나리오 마감작업<br>
	 * Continent업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}

}