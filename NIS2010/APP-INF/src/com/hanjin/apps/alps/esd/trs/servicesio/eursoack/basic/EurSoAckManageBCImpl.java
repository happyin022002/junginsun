/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EDI_ENS_002EventResponse.java
*@FileTitle : Eur S/O  정보
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2006-12-20 Lee Sang-Woo
* 1.0 최초 생성
* 2011.03.31  손은주 [CHM-201109814-01	] [TRS] W/O EDI 사용을 위한 setting 요청 (115133)
* 2011.04.13 김영철 [CHM-201110137-01] [TRS] W/O EDI 환경 구현 요청 (114745)
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.eursoack.basic;

import com.hanjin.apps.alps.esd.trs.servicesio.eursoack.integration.EurSoAckManageDBDAO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * eNIS-BIZCOMMON Business Logic Basic Command implementation<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Lee Sang-Woo
 * @see EDI_ENS_002EventResponse,EurSoAckManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class EurSoAckManageBCImpl   extends BasicCommandSupport implements EurSoAckManageBC {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Database Access Object
	private transient EurSoAckManageDBDAO dbDao=null;

	/**
	 * ContinentBCImpl 객체 생성<br>
	 * ContinentDBDAO를 생성한다.<br>
	 */
	public EurSoAckManageBCImpl(){
		dbDao = new EurSoAckManageDBDAO();
	}

	/**EDI Queue를 
	 * Receive 처리한다.<br>
	 * 중요 : queue-mapping.xml 에 정의되어야 서비스 받을 수 있음.  
	 * 
	 * @param str
	 * @return
	 * @throws EventException
	 */
	public int receiveEurSoAckManage(String str)  throws EventException {
		
		int resultCount = 0;
		boolean isEnis = false; 
		
		String ack1 = null; 
		String ack2 = null;
		String ack3 = null;
		String ack4 = null;
		String ack5 = null;
		String ack6 = null;
		String ack7 = null; //XPRESS
		String ack8 = null; //FREIGHTLINER
		String ack9 = null; //MARITIME
		String gubun = null;
		
		String eq_no = null; 
		String edi_rcv_rslt_cd = null;
		String r_edi_rcv_rslt_msg = null;
		String edi_rcv_rslt_msg = null;
		String trsp_so_seq = null;
		int rstr = str.length();  // 2007.05.10 수정.

		//String str = rstr.trim();
		ack1 = str.substring(0,3);
		ack2 = str.substring(0,7);
		ack3 = str.substring(0,8);
		ack4 = str.substring(21,22); //nis, enis
		ack5 = str.substring(0,7);
		ack6 = str.substring(0,9);
		ack7 = str.substring(0,6);  //XPRESS
		ack8 = str.substring(0,12); //FREIGHTLINER
		ack9 = str.substring(0,8);  //MARITIME
		log.debug("str   : " + str );
		log.debug("ack1. : " + ack1 );
		log.debug("ack2. : " + ack2 );
		log.debug("ack3. : " + ack3 );
		log.debug("ack4. nis or enis : " + ack4 );
		log.debug("ack5. : " + ack5 );
		log.debug("ack6. : " + ack6 );
		log.debug("ack7. : " + ack7 );
		log.debug("ack8. : " + ack8 );
		log.debug("ack9. : " + ack9 );
		for( int i = 0; i < 10; i++ ){							
			gubun = String.valueOf(i);	
			if (ack4.equals(gubun)){
				 isEnis = true; 
				 log.debug("This date is from nis system.");
				 break;
			}
		}			

		try {
			log.debug("int rstr  : " + rstr );
			if ( rstr > 76 && isEnis ) {
				if (ack1.equals("TFG") || ack2.equals("METRANS") || ack3.equals("MASTHAUL") || ack5.equals("INTRANS") || ack6.equals("UNIFEEDER") || ack7.equals("XPRESS") || ack8.equals("FREIGHTLINER") || ack9.equals("MARITIME")){
					if (ack1.equals("TFG")){	
						trsp_so_seq = str.substring(21,31);	
						log.debug("trsp_so_seq1 : " + trsp_so_seq );
						
						eq_no = str.substring(34,48);	
						log.debug("eq_no1 : " + eq_no );
						
						edi_rcv_rslt_cd = str.substring(33,34); 
						log.debug("edi_rcv_rslt_cd1 : " + edi_rcv_rslt_cd );
						
						r_edi_rcv_rslt_msg = str.substring(77, rstr);	  // 테이블 자리수 확인요.	 
						edi_rcv_rslt_msg = r_edi_rcv_rslt_msg.replaceAll(" \" " , "''" );
						log.debug("edi_rcv_rslt_msg1 : " + edi_rcv_rslt_msg );
									
						
					} else if (ack2.equals("METRANS") || ack5.equals("INTRANS")) {
						trsp_so_seq = str.substring(21,31);	
						log.debug("trsp_so_seq2 : " + trsp_so_seq );
						
						eq_no = str.substring(34,48);	
						log.debug("eq_no2 : " + eq_no );
						
						edi_rcv_rslt_cd = str.substring(33,34); 
						log.debug("edi_rcv_rslt_cd2 : " + edi_rcv_rslt_cd );
						
						r_edi_rcv_rslt_msg = str.substring(77, rstr);	  // 테이블 자리수 확인요.	 
						edi_rcv_rslt_msg = r_edi_rcv_rslt_msg.replaceAll(" \" " , "''" );
						log.debug("edi_rcv_rslt_msg2 : " + edi_rcv_rslt_msg );
						
					} else if (ack3.equals("MASTHAUL")){
						trsp_so_seq = str.substring(21,31);	
						log.debug("trsp_so_seq3 : " + trsp_so_seq );
						
						eq_no = str.substring(34,48);	
						log.debug("eq_no3 : " + eq_no );
						
						edi_rcv_rslt_cd = str.substring(33,34); 
						log.debug("edi_rcv_rslt_cd3 : " + edi_rcv_rslt_cd );
						
						r_edi_rcv_rslt_msg = str.substring(77, rstr);	  // 테이블 자리수 확인요.	 
						edi_rcv_rslt_msg = r_edi_rcv_rslt_msg.replaceAll(" \" " , "''" );
						log.debug("edi_rcv_rslt_msg3 : " + edi_rcv_rslt_msg );	

					} else if (ack6.equals("UNIFEEDER") || ack7.equals("XPRESS")) {
						trsp_so_seq = str.substring(21,31);	
						log.debug("trsp_so_seq3 : " + trsp_so_seq );
						
						eq_no = str.substring(34,48);	
						log.debug("eq_no3 : " + eq_no );
						
						edi_rcv_rslt_cd = str.substring(33,34); 
						log.debug("edi_rcv_rslt_cd3 : " + edi_rcv_rslt_cd );
						
						r_edi_rcv_rslt_msg = str.substring(77, rstr);	  // 테이블 자리수 확인요.	 
						edi_rcv_rslt_msg = r_edi_rcv_rslt_msg.replaceAll(" \" " , "''" );
						log.debug("edi_rcv_rslt_msg3 : " + edi_rcv_rslt_msg );
					} else if (ack8.equals("FREIGHTLINER")){
						trsp_so_seq = str.substring(21,31);	
						log.debug("FREIGHTLINER TRSP_SO_SEQ : " + trsp_so_seq );
						
						eq_no = str.substring(34,48);	
						log.debug("FREIGHTLINER EQ_NO : " + eq_no );
						
						edi_rcv_rslt_cd = str.substring(33,34); 
						log.debug("FREIGHTLINER EDI_RCV_RSLT_CD : " + edi_rcv_rslt_cd );
						
						r_edi_rcv_rslt_msg = str.substring(77, rstr);	  // 테이블 자리수 확인요.	 
						edi_rcv_rslt_msg = r_edi_rcv_rslt_msg.replaceAll(" \" " , "''" );
						log.debug("FREIGHTLINER EDI_RCV_RSLT_MSG : " + edi_rcv_rslt_msg );	
					} else if (ack9.equals("MARITIME")){
						trsp_so_seq = str.substring(21,31);	
						log.debug("MARITIME TRSP_SO_SEQ : " + trsp_so_seq );
						
						eq_no = str.substring(34,48);	
						log.debug("MARITIME EQ_NO : " + eq_no );
						
						edi_rcv_rslt_cd = str.substring(33,34); 
						log.debug("MARITIME EDI_RCV_RSLT_CD : " + edi_rcv_rslt_cd );
						
						r_edi_rcv_rslt_msg = str.substring(77, rstr);	  // 테이블 자리수 확인요.	 
						edi_rcv_rslt_msg = r_edi_rcv_rslt_msg.replaceAll(" \" " , "''" );
						log.debug("MARITIME EDI_RCV_RSLT_MSG : " + edi_rcv_rslt_msg );		
					} // exception 메세지.. 필요. String index out of range: 300
				} else {
					throw new DAOException("HEAD TYPE does not exist.");
				} 	
				
	        	resultCount = dbDao.addEurSoAckList(eq_no, edi_rcv_rslt_cd, edi_rcv_rslt_msg, trsp_so_seq);
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