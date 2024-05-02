/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TrsCommonBCImpl.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.19
*@LastModifier : 유선오
*@LastVersion : 1.6
* 2011.02.10 민정호
* 1.0 Creation
* -----------------------------------------------------------------
* History
* 1.0 2011.02.10 민정호 [CHM-201108602] [TRS]미주지역 Appt./Deli. time update 기능 추가
* 1.2 2011.02.18  손은주 [CHM-201108834-01]	[TRS] Rail performance Report 부분의 주 단위 data 조회기능 추가 요청- 월별 주차별 검색기간 추가
* 1.3 2011.03.28 손은주 [CHM-201109560-01]    Split 04-Intra - Europe Business 관련 VAT 기능 개발 - 대륙코드 조회
* 1.4 2011.06.27 손은주  [CHM-201111573-01]	[TRS] S/O history function 추가 요청
* 1.6 2011.10.19 유선오  [CHM-201112874]   	[TRS] OTHER S/O Creation 화면 상 오류 수정요청
* 2011.11.17 변종건[CHM-201114528-01] TRS 시스템 담당자용 버튼 개발
* 2012.01.06 김종호 [CHM-201109410] [TRS] CNTR No. 유효성에 대한 Validation 절차 추가요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.trscommon.basic;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.esd.trs.common.fileattach.vo.TrsFileVO;
import com.hanjin.apps.alps.esd.trs.common.trscommon.event.EsdTrs0999Event;
import com.hanjin.apps.alps.esd.trs.common.trscommon.integration.TrsCommonDBDAO;
import com.hanjin.apps.alps.esd.trs.common.trscommon.vo.TrsSOHistoryVO;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.framework.component.attachment.file.support.UpdateFileMetaInfo;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-Common Business Logic Command Interface<br>
 * - ALPS-Common에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Min Jung Ho
 * @see ESD_TRS_0999EventResponse 참조
 * @since J2EE 1.6
 */
public class TrsCommonBCImpl extends BasicCommandSupport implements TrsCommonBC {

	// Database Access Object
	private transient TrsCommonDBDAO dbDao = null;

	/**
	 * TrsCommonBCImpl 객체 생성<br>
	 * TrsCommonDBDAO를 생성한다.<br>
	 */
	public TrsCommonBCImpl() {
		dbDao = new TrsCommonDBDAO();
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Office Change시 변경된 국가코드를 조회<br>
	 *
	 * @param e ESD_TRS_0999Event
	 * @return EventResponse ESD_TRS_0999EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContiCd(Event e) throws EventException {
		
		EsdTrs0999Event 	event	= (EsdTrs0999Event)e;
		DBRowSet 			rowSet	= null;
		FormCommand formcommand = e.getFormCommand();

		try {
			rowSet	= dbDao.searchContiCd(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			
			if(rowSet.next()){				
				if(formcommand.isCommand(FormCommand.SEARCH01))
					eventResponse.setETCData("CNT_CD", rowSet.getString("CNT_CD"));
			}
			return eventResponse;			
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());						
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}	
	
	/**
	 * Office Change시 변경된 국가코드를 조회
	 * N200905040013 2009-05-11: Office Change 개념의 모듈적용
	 * 
	 * @param sOfficeCd
	 * @return String
	 * @exception EventException
	 */
	public String searchContiCd(String sOfficeCd) throws EventException 
	{
		String 		cnt_cd 	= "";
		try {
			cnt_cd = dbDao.searchContiCd(sOfficeCd);	
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
		return cnt_cd;
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * 월별,주차별 검색기간 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_0999EventResponse
	 * @exception EventException
	 */
	public EventResponse searchPeriod(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0999Event event=(EsdTrs0999Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FormCommand formcommand = e.getFormCommand();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchPeriod(event);
			eventResponse.setRsVo(rowSet);
			
			if( rowSet.next() ){				
				if( formcommand.isCommand(FormCommand.SEARCH02) || formcommand.isCommand(FormCommand.SEARCH08) ){
					eventResponse.setETCData("FM_DATE", rowSet.getString("FM_DATE"));
					eventResponse.setETCData("TO_DATE", rowSet.getString("TO_DATE"));
				}
			}
			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());						
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Office의 대륙코드를 조회<br>
	 *
	 * @param e ESD_TRS_0999Event
	 * @return EventResponse ESD_TRS_0999EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContiCode(Event e) throws EventException {
		
		EsdTrs0999Event 	event	= (EsdTrs0999Event)e;
		DBRowSet 			rowSet	= null;
		FormCommand formcommand = e.getFormCommand();

		try {
			rowSet	= dbDao.searchContiCode(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			
			if(rowSet.next()){				
				if(formcommand.isCommand(FormCommand.SEARCH03))
					eventResponse.setETCData("CONTI_CD", rowSet.getString("CONTI_CD"));
			}
			return eventResponse;			
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());						
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}

	/**
	 * 입력 이벤트 처리<br>
	 * TRS CY/DOOR S/O와 관련된 각 이벤트 별로 S/O HISTORY를 입력<br>
	 *
	 * @param soHisVo TrsSOHistoryVO
	 * @exception EventException
	 */
	public void multiSoHistory(TrsSOHistoryVO soHisVo) throws EventException{
		
		try {
			dbDao.multiSoHistory(soHisVo);
		
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}
	}
	

	/**
	 * 입력 이벤트 처리<br>
	 * TRS CY/DOOR S/O와 관련된 각 이벤트 별로 S/O HISTORY를 입력<br>
	 *
	 * @param trsStsVO SingleTransportationVO
	 * @exception EventException
	 */
	public void multiSceSoHistory(SingleTransportationVO trsStsVO) throws EventException{
		try {
			dbDao.multiSceSoHistory(trsStsVO);
		
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}
	}
	/**
	 * Other s/o 의 Commodity Code를 조회<br>
	 * TRS CY/DOOR S/O와 관련된 각 이벤트 별로 Commodity Code를 입력<br>
	 *
	 * @param e ESD_TRS_0999Event
	 * @return EventResponse ESD_TRS_0999EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchCmdtCd(Event e) throws EventException {
		DBRowSet rowSet=null; 
		EsdTrs0999Event event=(EsdTrs0999Event)e;
		FormCommand formcommand = e.getFormCommand();	
		try {
			rowSet=dbDao.searchCmdtCd(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			if(formcommand.isCommand(FormCommand.SEARCH04)){
				if(rowSet.next()){		
					eventResponse.setETCData("cmdt_cd",  rowSet.getString("CMDT_CD"));
					eventResponse.setETCData("cmdt_nm",   rowSet.getString("CMDT_NM"));
				}
			}
			
			return eventResponse;

		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());									
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}
	/**
	 * Other s/o 의 Customer Code를 조회<br>
	 * TRS CY/DOOR S/O와 관련된 각 이벤트 별로 Customer Code를 입력<br>
	 *
	 * @param e ESD_TRS_0999Event
	 * @return EventResponse ESD_TRS_0999EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchCustCd(Event e) throws EventException {
		DBRowSet rowSet=null;
		EsdTrs0999Event event=(EsdTrs0999Event)e;
		FormCommand formcommand = e.getFormCommand();	
		try {
			rowSet=dbDao.searchCustCd(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			if(formcommand.isCommand(FormCommand.SEARCH05)){
				if(rowSet != null && rowSet.next()){
					eventResponse.setRsVo(rowSet);
					eventResponse.setETCData("input_cust_cd",  rowSet.getString("CUST_CD"));
					eventResponse.setETCData("input_cust_nm",   rowSet.getString("CUST_NM"));
				}
			}			
			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());									
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
		
	}
	
	/**
	 * 버튼 권한 조회 이벤트 처리
	 * 
	 * @param account
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchBtnAuthority(SignOnUserAccount account)throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();			
		DBRowSet rowSet=null;

		try {
			rowSet = dbDao.searchBtnAuthority(account.getUsr_id());
			if(rowSet != null && rowSet.next()){
				eventResponse.setRsVo(rowSet);
				eventResponse.setETCData("authFlg",  rowSet.getString("AUTH_FLG"));
			}
			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());									
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}
		
	
	/**
	 * 조회 이벤트 처리<br>
	 * 컨테이너 유효성을 검사한다<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_0999EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntrEqNo(Event e) throws EventException {
		DBRowSet rowSet			= null; 
		EsdTrs0999Event event	= (EsdTrs0999Event)e;
		FormCommand formcommand = e.getFormCommand();	
		try {
			rowSet = dbDao.searchCntrEqNo(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);	
			if(rowSet.next()){
				if(formcommand.isCommand(FormCommand.SEARCH07)){
				eventResponse.setETCData("ROW", event.getRow());
				eventResponse.setETCData("EQ_NO", rowSet.getString("EQ_NO"));
				eventResponse.setETCData("EQ_TPSZ_CD", rowSet.getString("EQ_TPSZ_CD"));
				}
			}

			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}
	
	/**
	 * RHQ Office 조회 : ESD_TRS_3004화면의 SEARCH01 이벤트 처리<br>
	 * 
	 * @param ofcCd
	 * @return
	 * @throws EventException
	 */
	public String searchRHQOfficeCode(String ofcCd) throws EventException{    
		String rhqCd = "";

		try {
			rhqCd = dbDao.searchRHQOfficeCode(ofcCd);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return rhqCd;
	}
	
	/**
	 * Country Code Verify<br>
	 * 
	 * @param cntCd
	 * @return
	 * @throws EventException
	 */
	public String verifyCountryCode(String cntCd) throws EventException{    
		String errFlg = "N";

		try {
			errFlg = dbDao.verifyCountryCode(cntCd);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return errFlg;
	}
	
	/**
	 * Agreement Number Verify<br>
	 * 
	 * @param agmt_no
	 * @return
	 * @throws EventException
	 */
	public String searchTrsAgmtNoData(String agmt_no) throws EventException{    
		String errFlg = "";

		try {
			errFlg = dbDao.searchTrsAgmtNoData(agmt_no);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return errFlg;
	}
	
	/**
	 * Search Local Time<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchLocalTime(Event e) throws EventException{  
		EsdTrs0999Event event=(EsdTrs0999Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String rtnVal = "";

		try {
			rtnVal = dbDao.searchLocalTime(event);
			eventResponse.setETCData("locl_dt_tm", rtnVal);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Container type - Active<br>
	 * 
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchMdmCntrTpActive() throws EventException{
		DBRowSet 			rowSet	= null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			rowSet	= dbDao.searchMdmCntrTpActive();
			eventResponse.setRsVo(rowSet);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 해당 오피스가 Multi More Candidate 필수 대상 인지 확인 (미국, 캐나다)
	 * 
	 * @param sOfficeCd
	 * @return String
	 * @exception EventException
	 */
	public String searchMltMorOnyFlg(String sOfficeCd) throws EventException 
	{
		String 		mlt_mor_ony_flg 	= "";
		try {
			mlt_mor_ony_flg = dbDao.searchMltMorOnyFlg(sOfficeCd);	
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
		return mlt_mor_ony_flg;
	}
	
	
	public List<TrsFileVO> searchTrsFile(TrsFileVO trsFileVO) throws EventException {
		try {
			// 조회
			return dbDao.searchTrsFile(trsFileVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	public String manageTrsFile(TrsFileVO[] trsFileVOs, SignOnUserAccount account) throws EventException {
		String use_id = account.getUsr_id();// user id
		String ofc_cd = account.getOfc_cd();// user office code
		String fileSavId = "";
		String atchFileLnkId = "";
		try {
			for (int i = 0; i < trsFileVOs.length; i++) {
				fileSavId = trsFileVOs[i].getFileSavId();
				trsFileVOs[i].setCreUsrId(use_id);
				trsFileVOs[i].setCreOfcCd(ofc_cd);
				trsFileVOs[i].setUpdUsrId(use_id);				
				atchFileLnkId = trsFileVOs[0].getAtchFileLnkId();
				
				if (atchFileLnkId.equals("")) {
					atchFileLnkId = dbDao.makeTrsFileNo(trsFileVOs[i]);
					trsFileVOs[i].setAtchFileLnkId(atchFileLnkId);
				} else {
					trsFileVOs[i].setAtchFileLnkId(atchFileLnkId);
				}
				
				if (trsFileVOs[i].getIbflag().equals("D")) {
					UpdateFileMetaInfo.delete(fileSavId);
					dbDao.removeTrsFile(trsFileVOs[i]);
				} else if (trsFileVOs[i].getIbflag().equals("I")) {
					if (trsFileVOs[i].getFileSavId().equals(""))
						throw new EventException(new ErrorHandler("TRS00099", new String[]{"The file is open."}).getMessage());
					dbDao.addTrsFile(trsFileVOs[i]);
				}
			}
			
			if(trsFileVOs[0].getCallMenuId().equals("ESD_TRS_0087")) {
				dbDao.changeTrs0087File(trsFileVOs[0]);
			}			
			
			return atchFileLnkId;
		} catch (DAOException ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		}
	}
	
    public void removeTrsFileAll(TrsFileVO trsFileVO) throws EventException {
        List<TrsFileVO> list = null;
        String fileSavId = "";
        try {
            list = dbDao.searchTrsFileAll(trsFileVO);
            for (int i = 0; i < list.size(); i++) {
                fileSavId = list.get(i).getFileSavId();
                UpdateFileMetaInfo.delete(fileSavId);
                dbDao.removeTrsFile(list.get(i));
            }

        } catch (DAOException ex) {
            // log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        } catch (Exception ex) {
            // log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        }
    }
	
	
}