/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : FileUploadBCImpl.java
*@FileTitle : 3자구상 파일업로드 공통팝업
*Open Issues :
*Change history :
*@LastModifyDate : 2009-12-02
*@LastModifier : Sun, CHOI
*@LastVersion : 1.1
* 2009-08-20 O Wan-Ki  1.0 최초생성
* 2009-12-02 Sun, CHOI 1.1 ALPS Migration
=========================================================*/
package com.clt.apps.opus.esd.tpb.common.fileupload.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esd.tpb.common.fileupload.event.TPBFileUploadEvent;
import com.clt.apps.opus.esd.tpb.common.fileupload.event.TPBFileUploadEventResponse;
import com.clt.apps.opus.esd.tpb.common.fileupload.integration.TPBFileUploadDBDAO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomChtrPtyCfFileVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomChtrPtyFileVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomContractVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomHireVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomIdVslVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomOtrExpnVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomPayTermVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.FileCountVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.TCharterIOContractVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.TpbTtlFileMgmtVO;


/**
 * NIS-3rd Party Billing Business Logic Basic Command implementation<br>
 * - NIS-3rd Party Billing에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Sun, CHOI
 * @see TPBFileUploadEventResponse,FileUploadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class TPBFileUploadBCImpl   extends BasicCommandSupport implements TPBFileUploadBC {

	// Database Access Object
	private transient TPBFileUploadDBDAO dbDao=null;

	/**
	 * FileUploadBCImpl 객체 생성<br>
	 * FileUploadDBDAO를 생성한다.<br>
	 */
	public TPBFileUploadBCImpl(){
		dbDao = new TPBFileUploadDBDAO();
	}
	
	/**
	 * 해당 fileNo의 업로드된 파일정보 조회 이벤트 처리<br>
	 * @param e TPBFileUploadEvent
	 * @return response TPBFileUploadEvent
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse searchUploadFileInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		TPBFileUploadEvent event=(TPBFileUploadEvent)e;
		TPBFileUploadEventResponse tpbResponse = null;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			SignOnUserAccount sa = event.getSignOnUserAccount();
			event.getEventParams().put("user_ofc_cd", sa.getOfc_cd()); /// Add in 2007-04-05
			
			rowSet=dbDao.searchUploadFileInfo(event);
			
			tpbResponse = new TPBFileUploadEventResponse();
			tpbResponse.setRs(rowSet);
			
			if(event.getEventParams().get("fileNo")!=null){
				tpbResponse.setETCData("fileNo", event.getEventParams().get("fileNo").toString());
			}
			
			
			return tpbResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * FileUpload정보 저장(생성) 이벤트 처리<br>
	 * @param e TPBFileUploadEvent
	 * @return EventResponse TPBFileUploadEventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public String createUploadFileInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		TPBFileUploadEvent event=(TPBFileUploadEvent)e;
		TpbTtlFileMgmtVO[] tpbTtlFileMgmtVOs = null;
		List<String> keys = null;
		
		List<TpbTtlFileMgmtVO> addVoList    = new ArrayList<TpbTtlFileMgmtVO>();
		List<TpbTtlFileMgmtVO> modifyVoList = new ArrayList<TpbTtlFileMgmtVO>();
		List<TpbTtlFileMgmtVO> removeVoList = new ArrayList<TpbTtlFileMgmtVO>();
		
		try {
			SignOnUserAccount sa = event.getSignOnUserAccount();
			event.getEventParams().put("user_id", sa.getUsr_id());
			event.getEventParams().put("user_ofc_cd", sa.getOfc_cd());
			
			tpbTtlFileMgmtVOs = event.getTpbTtlFileMgmtVOs();
			
			keys = event.getKeys();

			int idx = 1;
			int cnt = keys == null ? 0 : keys.size();
			String fileNo = null;
			String sFileNoSeq   = null;
			
			if(event.getEventParams().get("fileNo")==null || "".equals(event.getEventParams().get("fileNo").toString())){
				fileNo  = dbDao.getNextFileNo();
			}else{
				fileNo = event.getEventParams().get("fileNo").toString();
			}
			
			int fileNoSeq = 1;
			boolean isFirst = true;
			
			for(int i=0; i<tpbTtlFileMgmtVOs.length; i++) {
				if(tpbTtlFileMgmtVOs[i].getIbflag().equals("I")) {
					//Setting attached file key value
					if(!"".equals(tpbTtlFileMgmtVOs[i].getFileLgcNm()) && null != keys) {
						tpbTtlFileMgmtVOs[i].setFilePhysNm(keys.get(cnt - idx++));
					}
					
					if(isFirst==true){
						sFileNoSeq   = dbDao.getFileNoSeq(fileNo);
						
						if(sFileNoSeq!=null && !"".equals(sFileNoSeq)){
							fileNoSeq = Integer.parseInt(sFileNoSeq);
						}
						
						isFirst = false;
					}
					
					tpbTtlFileMgmtVOs[i].setFileNo(fileNo);
					tpbTtlFileMgmtVOs[i].setFileNoSeq(fileNoSeq+"");
					tpbTtlFileMgmtVOs[i].setCreUsrId(event.getSignOnUserAccount().getUsr_id());
					tpbTtlFileMgmtVOs[i].setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					addVoList.add(tpbTtlFileMgmtVOs[i]);
					
					if(isFirst==false){
						fileNoSeq++;
					}					

				} else if(tpbTtlFileMgmtVOs[i].getIbflag().equals("U")) {
					if(!"".equals(tpbTtlFileMgmtVOs[i].getFileLgcNm()) && null != keys) {
						tpbTtlFileMgmtVOs[i].setFilePhysNm(keys.get(cnt - idx++));
					}					
					tpbTtlFileMgmtVOs[i].setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					
					modifyVoList.add(tpbTtlFileMgmtVOs[i]);
					
				} else if(tpbTtlFileMgmtVOs[i].getIbflag().equals("D")) {
					tpbTtlFileMgmtVOs[i].setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tpbTtlFileMgmtVOs[i].setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					removeVoList.add(tpbTtlFileMgmtVOs[i]);
				}
			}
			
			//Inserting data
			if(addVoList.size() > 0) {
				dbDao.createUploadFileInfo(addVoList);
			}
			
			//Modifying data
			if(modifyVoList.size() > 0) {
				dbDao.updateUploadFiles(modifyVoList);
			}
			
			//Deleting data
			if(removeVoList.size() > 0) {
				dbDao.removeUploadFiles(removeVoList);
			}
			
			return fileNo;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
   /** selectUploadFileCnt
	 * @param Event e
	 * @return int
	 * @exception EventException
    */
	public int selectUploadFileCnt(Event e) throws EventException {
		TPBFileUploadEvent event=(TPBFileUploadEvent)e;
		
		try{
			int fileCnt = dbDao.selectUploadFileCnt(event);
			if(fileCnt == 0){
				dbDao.updateFileNo(event);
			}
			
			return fileCnt;
		}catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	
	/**
	 * FileUpload정보 삭제(file system, db) 이벤트 처리<br>
	 * @param e TPBFileUploadEvent
	 * @return EventResponse TPBFileUploadEventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse removeUploadFiles(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		TPBFileUploadEvent event=(TPBFileUploadEvent)e;
		HashMap params = event.getEventParams(); 
		try {
			SignOnUserAccount sa = event.getSignOnUserAccount();
			params.put("user_id", sa.getUsr_id());
			params.put("user_ofc_cd", sa.getOfc_cd());
			
			boolean isSuccessFlag = dbDao.removeUploadFiles(event);

			String strSuccessFlag = "false";
			if ( isSuccessFlag ) {
				strSuccessFlag = "true";
			}

			return new TPBFileUploadEventResponse(strSuccessFlag);

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 3rd Party Billing 업무 시나리오 마감작업<br>
	 * FileUpload업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}