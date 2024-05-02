/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : KorSoAckManageBCImpl.java
*@FileTitle : Kor  정보
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2006-12-20 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.korsoack.basic;

import com.hanjin.apps.alps.esd.trs.servicesio.korsoack.integration.KorSoAckManageDBDAO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * eNIS-BIZCOMMON Business Logic Basic Command implementation<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Lee Sang-Woo
 * @see EDI_ENS_003EventResponse,EurSoAckManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class KorSoAckManageBCImpl   extends BasicCommandSupport implements KorSoAckManageBC {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Database Access Object
	private transient KorSoAckManageDBDAO dbDao=null;

	/**
	 * ContinentBCImpl 객체 생성<br>
	 * ContinentDBDAO를 생성한다.<br>
	 */
	public KorSoAckManageBCImpl(){
		dbDao = new KorSoAckManageDBDAO();
	}

	/**EDI Queue를 
	 * Receive 처리한다.<br>
	 * 
	 * @param str
	 * @return
	 * @throws EventException
	 */
	public int receiveKorSoAckManage(String str)  throws EventException {
		
		int resultCount = 0;
		String ack1 = null; 
		
		String wo_edi_rcv_rslt_cd = null; 
		String r_wo_edi_rcv_rslt_msg = null;
		String wo_edi_rcv_rslt_msg = null;		
		String wo_edi_rcv_purp_cd = null;
		String trsp_wo_ofc_cty_cd = null; 
		String trsp_wo_seq = null;
		int len = (str.trim()).length();
		int len2 = str.trim().length();
		//String str = rstr.trim();
		ack1 = (str.trim()).substring(0,17);
		log.debug("int len  : " + len );
		log.debug("int len2  : " + len2 );
		log.debug("str   : " + str );
		log.debug("ack1. : " + ack1 );
        
		try {		
			if ( len > 112 ) {   
				if ( ack1.equals("IFHJT2SML!SO_RES!")) {				
					
					wo_edi_rcv_rslt_cd = str.substring(102,103);	//STATUS:NCK
					wo_edi_rcv_purp_cd = str.substring(53,54); 		//PURPOSE:X
					
					//WO_NO:PUS12312345678901000
					trsp_wo_ofc_cty_cd = str.substring(24,27);
					trsp_wo_seq = str.substring(30,44);	
					
					//ERRMSG:ALREADY HJT TRACKED
					r_wo_edi_rcv_rslt_msg = str.substring(113, len);	
					wo_edi_rcv_rslt_msg = r_wo_edi_rcv_rslt_msg.replaceAll(" \" " , "''" );
			
					log.debug("wo_edi_rcv_rslt_cd : " + wo_edi_rcv_rslt_cd );
					log.debug("wo_edi_rcv_purp_cd : " + wo_edi_rcv_purp_cd );
					log.debug("trsp_wo_ofc_cty_cd : " + trsp_wo_ofc_cty_cd );
					log.debug("trsp_wo_seq : " + trsp_wo_seq );
					log.debug("wo_edi_rcv_rslt_msg : " + wo_edi_rcv_rslt_msg );
					
				} else {
					throw new DAOException("HEAD TYPE does not exist.");
				} 	
				
	        	resultCount = dbDao.addKorSoAckList(wo_edi_rcv_rslt_cd, wo_edi_rcv_rslt_msg, wo_edi_rcv_purp_cd, trsp_wo_ofc_cty_cd, trsp_wo_seq );
	        	log.debug("==resultCount = " +resultCount);
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

	
	/**
	 * BIZCOMMON 업무 시나리오 마감작업<br>
	 * Continent업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}

}