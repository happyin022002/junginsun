/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSMSendBCImpl.java
*@FileTitle : CSM (Container Status Message) 미세관 전송 
*Open Issues :
*Change history :
*@LastModifyDate : 2009-02-05
*@LastModifier : Kim In-soo
*@LastVersion : 1.0
* 1.0 최초 생성
* 
* 2009-03-04 iskim
* 	(1) R200903040003	2월 소스품질 검토 결과 follow-up
=========================================================*/
package com.clt.apps.opus.esd.sce.csmsend.basic;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esd.sce.csmsend.integration.CSMSendDBDAO;
import com.clt.apps.opus.esd.sce.csmsend.integration.CSMSendEAIDAO;
import com.clt.apps.opus.esd.sce.csmsend.vo.CSMSendVO;
import com.clt.bizcommon.edi.broker.ReferenceNumberGeneratorBroker;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * SCEM Business Logic Basic Command implementation<br>
 * - SCEM에 대한 비지니스 로직을 처리한다.<br>
 * @author 2002701
 * @see
 * @since J2EE 1.4
 */
public class CSMSendBCImpl extends BasicCommandSupport implements CSMSendBC {
	CSMSendDBDAO dbDao = null;
	CSMSendEAIDAO eaiDao = null;
	
	/**
	 * Default Constructor
	 */
	public CSMSendBCImpl() {
		dbDao = new CSMSendDBDAO();
		eaiDao = new CSMSendEAIDAO();
	}

	

	/**
	 * booking 정보가 없어서 미주 행인지 판단 못한 건을 차후 판단
	 * @param cSMSendVO
	 * @return String
	 * @throws EventException
	 */
	public String searchBkgBound(CSMSendVO cSMSendVO)
			throws EventException {
		String rtnStr = null;
		try {
			rtnStr = dbDao.searchBkgBound(cSMSendVO);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return rtnStr;
	}
	
	/**
	 * movement data 의 처리 결과를 update 한다.
	 * 99 : 정상 발생, queue 전송 완료
	 * XX : process 진행 중
	 * 
	 * @param cSMSendVO
	 * @throws EventException
	 */
	public void updateActUmchTpCd(CSMSendVO cSMSendVO) throws EventException {
		try {
			dbDao.updateActUmchTpCd( cSMSendVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * movement data 의 처리 결과를 update 한다.
	 * 99 : 정상 발생, queue 전송 완료
	 * XX : process 진행 중
	 * 
	 * @param act_rcv_dt
	 * @param act_rcv_no
	 * @param act_umch_tp_cd
	 * @throws EventException
	 */
	public void updateActUmchTpCd(String act_rcv_dt, String act_rcv_no, String act_umch_tp_cd) throws EventException {
		try {
			dbDao.updateActUmchTpCd(act_rcv_dt, act_rcv_no, act_umch_tp_cd);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * 	불필요한 것으로 판단된 movement target data 를 삭제한다.
	 * (booking 정보가 없어서 미주 행인지 판단 못한 건을 차후 판단시 미주가 아니라고 판단되면 삭제)
	 * @param cSMSendVO
	 * @throws EventException
	 */
	public void deleteCSMTarget(CSMSendVO cSMSendVO) throws EventException {
		try {
			dbDao.deleteCSMTarget(cSMSendVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * movement 발생 건 별로 flat file 을 생성한다.
	 * @param CSMSendVO cSMSendVO
	 * @return int
	 * @throws EventException
	 */
	public int insertFlatFile(CSMSendVO cSMSendVO) throws EventException {
		int rowCnt = 0;
		try {
			dbDao.insertFlatFile(cSMSendVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return rowCnt;
	}
	
	/**
	 * 미 전송건 전부 QUEUE 로 전송
	 * @throws EventException
	 */
	public void sendFlatFileIntoQueue() throws EventException {
		
		try {
			DBRowSet rowSet = dbDao.searchFlatFileToBeSent();
			DBRowSet rowSet1 = rowSet.createShared();
			String ediSendFirstDesc = "";
			String ediSendDesc = "";
			String edi_snd_desc = "";
			String edi_snd_yrmondy = "";
			int edi_snd_seq = 0;
			String rslt = "";
			
			//FLAT FILE REFERENCE NUMBER 변경 20141219 IGKIM
			//String flt_file_ref_no = searchEdiHdSkd("NYK", "USCBP24", "CMS");
			String flt_file_ref_no = searchEdiHdSkdId();	
			String header = "$$$MSGSTART:" 
					   + StringUtils.rightPad(StringUtils.trimToEmpty("NYK"), 20, " ")
		               + StringUtils.rightPad(StringUtils.trimToEmpty("USCBP24"), 20, " ")
		               + StringUtils.rightPad(StringUtils.trimToEmpty("CSM"), 10, " ")
		               + flt_file_ref_no;
			//일괄 보내기ㅣ 위한 DATASET 만들기
			while (rowSet.next()) {				
				
				if (rowSet.isFirst()){
					
					ediSendDesc = ediSendDesc + header+"\n";	
					
					edi_snd_yrmondy = rowSet.getString("EDI_SND_YRMONDY");
					edi_snd_seq = rowSet.getInt("EDI_SND_SEQ");
					ediSendFirstDesc = dbDao.searchFlatFileCLOB(edi_snd_yrmondy, edi_snd_seq);
					
					edi_snd_desc = ediSendDesc + ediSendFirstDesc +"\n";
					
				} else {
					edi_snd_yrmondy = rowSet.getString("EDI_SND_YRMONDY");
					edi_snd_seq = rowSet.getInt("EDI_SND_SEQ");
					ediSendDesc = dbDao.searchFlatFileCLOB(edi_snd_yrmondy, edi_snd_seq);
					edi_snd_desc = edi_snd_desc + ediSendDesc +"\n";
				}		
			}
			log.debug("============================= edi_snd_desc message: "+edi_snd_desc);
			if (edi_snd_desc.length() > 0 ) {
				rslt = eaiDao.sendFlatFileIntoQueue(edi_snd_desc);			

				// 성공 여부에 따른 FLAG 처리
				while (rowSet1.next()) {
					
					edi_snd_yrmondy = rowSet1.getString("EDI_SND_YRMONDY");
					edi_snd_seq = rowSet1.getInt("EDI_SND_SEQ");
					
					String act_rcv_dt = rowSet1.getString("ACT_RCV_DT");
					String act_rcv_no = rowSet1.getString("ACT_RCV_NO");
					
					if (rslt.equalsIgnoreCase("SUCCESS")) {
						log.debug("============================= edi_snd_yrmondy : "+edi_snd_yrmondy);
						log.debug("============================= edi_snd_seq : "+edi_snd_seq);
						log.debug("============================= SUCCESS(Sent) ");
						
						dbDao.updateSendResultQuery(edi_snd_yrmondy, edi_snd_seq, "Y", "SUCCESS(Sent)", "F", flt_file_ref_no);
						dbDao.updateActUmchTpCd(act_rcv_dt, act_rcv_no, "99");
					} else {
						dbDao.updateSendResultQuery(edi_snd_yrmondy, edi_snd_seq, "N", "Sent Failed", "F", flt_file_ref_no);
						
						dbDao.updateActUmchTpCd(act_rcv_dt, act_rcv_no, "80");
					}
				}
			}
			/*
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
			}*/
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
	 * @param cSMSendVO
	 * @return boolean
	 */
	public boolean searchDupSndRslt(CSMSendVO cSMSendVO) throws EventException{
		boolean isExists = false;
		try {
			isExists = dbDao.searchDupSndRslt(cSMSendVO);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return isExists;
	}
	
	/**
	 * Empty container movement 를 대상으로 해당 mvmt 에 딸린 bkg 의 vvd 중 pod /del 도착까지 미주를 경유하는지 조회하여
	 * 대상이면 SCE_CNTR_STS_MSG_TGT 에 insert
	 * @return int
	 * @exception EventException
	 */
	public int addCSMSendTargetEmptyCntr () throws EventException {
		int rowCnt = 0;
		try {
			rowCnt = dbDao.addCSMTargetEmptyCntr();
			
		} catch (DAOException de) {
			log.error("err = " + de.toString(), de);
			throw new EventException (de.getMessage());
		}
		return rowCnt;
	}

    /**
     * Port Header 가져오기<br>
     * @param  JDBCWrapper wrapper
     * @param  String[] params
     * @return String
     * @throws Exception
     */
    /**
     * Header 가져오기<br>
     * @param  JDBCWrapper wrapper
     * @param  String[] params
     * @return String
     * @throws Exception
     * @since 2014.12.15
     */
	private String searchEdiHdSkdId() throws Exception {
		String refNumber = "";
		try{
		
			refNumber = ReferenceNumberGeneratorBroker.getKey("CSM","SCE_CNTR_STS_MSG_FLT_FILE_SEQ1");  //reference sequence number ???			
		} catch (Exception e){
			throw new Exception(new ErrorHandler(e).getMessage());
		}
		return refNumber;
	}	
}