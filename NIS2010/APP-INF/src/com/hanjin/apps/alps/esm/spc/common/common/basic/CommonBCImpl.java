/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CommonBCImpl.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-11
*@LastModifier : 김원섭
*@LastVersion : 1.0
* 2006-10-11 김원섭
* 1.0 최초 생성
* 2008-06-03 서관영   
* CSR : N200805290010 - SLCSC 권한 조정 RHQ 레벨을 NYCRA로 상향조정  
* UI별로 권한 부여로 인해서 searchOfficeCond 로직 수정 - SPC_SCR_OFC_CONV_FNC포함
* 2008-08-22 임옥영 searchVesselSizeList() BC에 선언되지 않고 다른곳에서 호출되지도 않는 메소드 주석처리
* 2008-12-22 서관영 CSR:N200812080001
*   - SELSC시 SUB Office 팀코드별 조정 
* 2011.05.19 최성민 [CHM-201110711-01] Inquiry by Trade 화면 보완
* - TAGLIB를 MULTICOMBO로 변경작업하기 위한 메소드 추가
* 2011.07.26 김종준 [SRM-201118467] Daily F"cast Status 화면 alloc display 보완 searchUserRoleYn 메소드 추가
* 2011.11.10 김종준 [CHM-201114445-01] f"cast history 화면 RGN Office 창 활성화 searchUserRoleYn 화면명 세팅
* 2011.11.21 김종준 [CLT-111121290-01] R4J 패치 이후 발생한 결함 건 수정(Null dereference)
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.11.13 박은주 [CHM-201432794] SMP 사용 편의기능 보완 요청(RHQ 유효성 체크)
* 2015.09.15 이혜민 [CHM-201537538] SMP 오류 수정 건 및 Sub Trade Add 기능 추가
=========================================================*/

package com.hanjin.apps.alps.esm.spc.common.common.basic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.common.event.ComboxEventResponse;
import com.hanjin.apps.alps.esm.spc.common.common.event.EsmSpcCodEvent;
import com.hanjin.apps.alps.esm.spc.common.common.integration.CommonDBDAO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.CommonCodeVO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SearchOfficeCondVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-Common Business Logic Basic Command implementation<br>
 * - alps-Common에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 김원섭
 * @see ComboxEventResponse,CommonBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class CommonBCImpl extends BasicCommandSupport implements CommonBC {

	private transient CommonDBDAO dbDao = null;

	/**
	 * CommonBCImpl 객체를 생성<br>
	 * CommonDBDAO를  생성한다.<br>
	 */
	public CommonBCImpl() {
		dbDao = new CommonDBDAO();
	}

	/**
	 * Common 업무 시나리오 마감작업<br>
	 * Common업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String del
	 * @param Boolean isRepTrade
	 * @return EventResponse ComboxEventResponse
	 * @exception EventException
	 */
	public EventResponse searchTradeComboList(String del, Boolean isRepTrade) throws EventException {
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			// PDTO(Data Transfer Object including Parameters)
			rowSet = dbDao.searchTradeComboList(del, isRepTrade.booleanValue());
			return new ComboxEventResponse(rowSet, "SUCCESS");
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String del
	 * @param Boolean isRepTrade
	 * @return EventResponse ComboxEventResponse
	 * @exception EventException
	 */
	public EventResponse searchSvcLaneComboList(String del, Boolean isRepTrade) throws EventException {
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			// PDTO(Data Transfer Object including Parameters)
			rowSet = dbDao.searchSvcLaneComboList(del, isRepTrade.booleanValue());
			return new ComboxEventResponse(rowSet, "SUCCESS");
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String del
	 * @param Boolean isRepTrade
	 * @param Boolean isAll
	 * @return EventResponse ComboxEventResponse
	 * @exception EventException
	 */
	public EventResponse searchSubTradeComboList(String del, Boolean isRepTrade, Boolean isAll)
			throws EventException {
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			// PDTO(Data Transfer Object including Parameters)
			rowSet = dbDao.searchSubTradeComboList(del, isRepTrade.booleanValue(), isAll
					.booleanValue());
			return new ComboxEventResponse(rowSet, "SUCCESS");
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String del
	 * @return EventResponse ComboxEventResponse
	 * @exception EventException
	 */
	public EventResponse searchRLaneComboList(String del) throws EventException {
		return searchRLaneComboList(del, new Boolean(false));
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String del
	 * @param Boolean ipc
	 * @return EventResponse ComboxEventResponse
	 * @exception EventException
	 */
	public EventResponse searchRLaneComboList(String del, Boolean ipc) throws EventException {
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			// PDTO(Data Transfer Object including Parameters)
			rowSet = dbDao.searchRLaneComboList(del, ipc.booleanValue());
			return new ComboxEventResponse(rowSet, "SUCCESS");
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EsmSpcCodEvent
	 * @return EventResponse ESM_SPC_CODEventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse searchCommonCodeList(Event e) throws EventException {
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse response = null;
		if (e.getEventName().equals("EsmSpcCodEvent")) {
			// PDTO(Data Transfer Object including Parameters)
			EsmSpcCodEvent event = (EsmSpcCodEvent) e;
			String masterCode = event.getMasterCode();
			Method m;
			try {
				m = dbDao.getClass().getMethod("search" + masterCode + "List",
						new Class[] { HashMap.class });
				HashMap map = event.getParams();
				map.put("login_usr_id", event.getSignOnUserAccount().getUsr_id());
				map.put("login_usr_ofc_cd", event.getSignOnUserAccount().getOfc_cd());
				rowSet = (DBRowSet) m.invoke(dbDao, new Object[] { map });
			} catch (SecurityException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage());
			} catch (NoSuchMethodException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage());
			} catch (IllegalArgumentException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage());
			} catch (IllegalAccessException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage());
			} catch (InvocationTargetException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage());
			}
			response = new GeneralEventResponse();
			response.setRsVo(rowSet);
		}
		return response;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String method
	 * @param String del
	 * @return EventResponse ComboxEventResponse
	 * @exception EventException
	 */
	public EventResponse searchCodeList(String method, String del) throws EventException {
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		// PDTO(Data Transfer Object including Parameters)
		Method m;
		try {
			m = dbDao.getClass()
					.getMethod("search" + method + "List", new Class[] { String.class });
			Object[] objs = new Object[1];
			objs[0] = del;
			rowSet = (DBRowSet) m.invoke(dbDao, objs);
		} catch (SecurityException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (NoSuchMethodException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (IllegalArgumentException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (IllegalAccessException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (InvocationTargetException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return new ComboxEventResponse(rowSet, "SUCCESS");
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String code
	 * @param String del
	 * @return EventResponse ComboxEventResponse
	 * @exception EventException
	 */
	public EventResponse searchCommonCodeList(String code, String del) throws EventException {
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		// PDTO(Data Transfer Object including Parameters)
		try {
			rowSet = dbDao.searchCommonCodeList(code, del);
			return new ComboxEventResponse(rowSet, "SUCCESS");
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ComboxEvent
	 * @return EventResponse ComboxEventResponse
	 * @exception EventException
	 */
	/*
	public EventResponse searchVesselSizeList(String del) throws EventException {
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			// PDTO(Data Transfer Object including Parameters)
			rowSet = dbDao.searchVesselSizeList(del);
			return new ComboxEventResponse(rowSet, "SUCCESS");
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	*/

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String del
	 * @return EventResponse ComboxEventResponse
	 * @exception EventException
	 */
	public EventResponse searchRHQComboList(String del) throws EventException {
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			// PDTO(Data Transfer Object including Parameters)
			rowSet = dbDao.searchRHQComboList(del);
			return new ComboxEventResponse(rowSet, "SUCCESS");
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String module
	 * @param String rhq
	 * @param String del
	 * @return EventResponse ComboxEventResponse
	 * @exception EventException
	 */
	public EventResponse searchAQComboList(String module, String rhq, String del)
			throws EventException {
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			// PDTO(Data Transfer Object including Parameters)
			rowSet = dbDao.searchAQComboList(module, rhq, del);
			return new ComboxEventResponse(rowSet, "SUCCESS");
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String ofc
	 * @param String del
	 * @return EventResponse ComboxEventResponse
	 * @exception EventException
	 */
	public EventResponse searchTargetGroupComboList(String ofc, String del) throws EventException {
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			// PDTO(Data Transfer Object including Parameters)
			rowSet = dbDao.searchTargetGroupComboList(ofc, del);
			return new ComboxEventResponse(rowSet, "SUCCESS");
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String module
	 * @param String rhq
	 * @param String del
	 * @return EventResponse ComboxEventResponse
	 * @exception EventException
	 */
	public EventResponse searchRgnOfcComboList(String module, String rhq, String del)
			throws EventException {
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			// PDTO(Data Transfer Object including Parameters)
			rowSet = dbDao.searchRgnOfcComboList(module, rhq, del);
			return new ComboxEventResponse(rowSet, "SUCCESS");
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String del
	 * @return EventResponse ComboxEventResponse
	 * @exception EventException
	 */
	public EventResponse searchKAMerComboList(String del) throws EventException {
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			// PDTO(Data Transfer Object including Parameters)
			rowSet = dbDao.searchKAMerComboList(del);
			return new ComboxEventResponse(rowSet, "SUCCESS");
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

//	/**
//	 * 조회 이벤트 처리<br>
//	 * Common화면에 대한 조회 이벤트 처리<br>
//	 * 
//	 * @param e ESM_SAQ_116Event
//	 * @return EventResponse ESM_SAQ_116EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse searchOfficeCond(Event e) throws EventException {
//		EventResponse response = null;
//		try {
//			// PDTO(Data Transfer Object including Parameters)
//			String ofc_cd = e.getSignOnUserAccount().getOfc_cd();			
//			DBRowSet rowSet = dbDao.searchOfficeCond(ofc_cd, e.getEventName().substring(0, 11));
////		    DBRowSet rowSet = dbDao.searchOfficeCond(ofc_cd);
//			response = new ESM_SPC_CODEventResponse(rowSet, "SUCCESS");
//			return response;
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param Event e
	 * @param SignOnUserAccount account
	 * @return List<SearchOfficeCondVO>
	 * @exception EventException
	 */
	public List<SearchOfficeCondVO> searchOfficeCond(Event e, SignOnUserAccount account) throws EventException {
		try {
			String ofc_cd  = account.getOfc_cd();
			String ui_name = e.getEventName().substring(0, 10);
			return dbDao.searchOfficeCond(ofc_cd, ui_name);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse ESM_SAQ_116EventResponse
	 * @exception EventException
	 */
	public EventResponse searchChildOfficeList(Event e) throws EventException {
		GeneralEventResponse response = null;
		try {
			// PDTO(Data Transfer Object including Parameters)
			String ofc_cd = e.getSignOnUserAccount().getOfc_cd();
			HashMap map = new HashMap();
			map.put("ofc_cd", new String[]{ofc_cd});
			map.put("level1", new String[]{"4"});
			DBRowSet rowSet = dbDao.searchChildOfficeList(map);
			response = new GeneralEventResponse();
			response.setRsVo(rowSet);
			return response;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESM_SAQ_116Event
	 * @return EventResponse ESM_SAQ_116EventResponse
	 * @exception EventException
	 */
	public EventResponse searchChildTeamOfficeList(Event e) throws EventException {
		GeneralEventResponse response = null;
		try {
			// PDTO(Data Transfer Object including Parameters)
			String ofc_cd = e.getSignOnUserAccount().getOfc_cd();
			HashMap map = new HashMap();
			map.put("ofc_cd", new String[]{ofc_cd});
			map.put("level1", new String[]{"4"});
			DBRowSet rowSet = dbDao.searchChildTeamOfficeList(map);
			response = new GeneralEventResponse();
			response.setRsVo(rowSet);
			return response;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 *  YEAR 코드 리스트를 생성한다.<br>
	 * 
	 * @return List<CommonCodeVO>
	 * @exception EventException
	 */
    public List<CommonCodeVO> searchComboBoxYearList() throws EventException {
		try {
			int pre = 1;
			int post = 5;			
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
		
			List<CommonCodeVO> list = new ArrayList<CommonCodeVO>();
			CommonCodeVO vo = null;
			
			for (int i = year + pre; i > year - pre - post; i--) {
				vo = new CommonCodeVO();
				vo.setCode(String.valueOf(i));
				vo.setName(String.valueOf(i));
				list.add(vo);
			}
			
			return list;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 *  WEEK 코드 리스트를 생성한다.<br>
	 * 
	 * @return List<CommonCodeVO>
	 * @exception EventException
	 */
    public List<CommonCodeVO> searchComboBoxWeekList() throws EventException {
		try {
			
			List<CommonCodeVO> list = new ArrayList<CommonCodeVO>();
			CommonCodeVO vo = null;
			
			for (int i = 0; i < 54; i++) {
				vo = new CommonCodeVO();
				vo.setCode((i < 10 ? "0" : "") + i);
				vo.setName((i < 10 ? "0" : "") + i);
				list.add(vo);
			}
						
			return list;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{}).getMessage(), ex);
		}
	}
    
	
	/**
	 *  Bound 코드 리스트를 생성한다.<br>
	 * 
	 * @param CommonCodeVO commonCodeVO
	 * @return List<CommonCodeVO>
	 * @exception EventException
	 */
    public List<CommonCodeVO> searchComboBoxBoundList(CommonCodeVO commonCodeVO) throws EventException {
		try {		
			List<CommonCodeVO> list = new ArrayList<CommonCodeVO>();
			CommonCodeVO vo = null;

			String[][] bound1 = new String[][] { { "E", "E" }, { "W", "W" }, { "S", "S" }, { "N", "N" } };
			String[][] bound2 = new String[][] { { "E", "E" }, { "W", "W" } };
						
			//sn
			if(commonCodeVO.getSn().equals("Y")) {
				for(int i=0; i< bound1.length; i++) {
					vo = new CommonCodeVO();
					vo.setCode(bound1[i][0]);
					vo.setName(bound1[i][1]);
					list.add(vo);
				}				
			} else {
				for(int i=0; i< bound2.length; i++) {
					vo = new CommonCodeVO();
					vo.setCode(bound2[i][0]);
					vo.setName(bound2[i][1]);
					list.add(vo);
				}
			}
			
			return list;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{}).getMessage(), ex);
		}
	}


	/**
	 * 메소드별로 콤보 리스트를 조회한다.<br>
	 * 
	 * @param CommonCodeVO commonCodeVO
	 * @return List<CommonCodeVO>
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CommonCodeVO> searchCommonComboList(CommonCodeVO commonCodeVO) throws EventException {
		DBRowSet rowSet = null;
		List<CommonCodeVO> list = null;
		
		try {
			rowSet = dbDao.searchCommonComboList(commonCodeVO);
			list = (List)RowSetUtil.rowSetToVOs(rowSet, CommonCodeVO .class);	
			
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{}).getMessage(), ex);
        }

		return list;
	}

	/**
	 *  SPC01 유저 권한 체크한다.<br>
	 * 
	 * @param Event e
	 * @param SignOnUserAccount account
	 * @param String ui_name
	 * @return List<SearchOfficeCondVO>
	 * @exception EventException
	 */
	public List<SearchOfficeCondVO> searchUserRoleYn(Event e, SignOnUserAccount account, String ui_name) throws EventException {
		try {
			return dbDao.searchUserRoleYn(account, ui_name);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * 입력된 VVD를 체크한다.
	 * @param vvd
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkVvd(String vvd) throws EventException {
		try {
			return dbDao.checkVvd(vvd);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 입력한 OFC가 지정된 RHQ에 해당하는지 확인합니다.
	 * @param slsRhqCd
	 * @param slsRgnOfcCd
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkOfcRhq(String slsRhqCd, String slsRgnOfcCd) throws EventException {
		try {
			return dbDao.checkOfcRhq(slsRhqCd, slsRgnOfcCd);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 입력한 RLANE이 지정된 Trade, Sub Trade에 해당하는지 확인합니다.
	 * @param trdCd
	 * @param subTrdCd
	 * @param rlaneCd
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkLaneTrd(String trdCd, String subTrdCd, String rlaneCd) throws EventException {
		try {
			return dbDao.checkLaneTrd(trdCd, subTrdCd, rlaneCd);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * SMP용 role을 조회합니다.
	 * @param String usrId
	 * @return String[]
	 * @throws EventException
	 */
	public String[] searchSmpRole(String usrId) throws EventException {
		try {
			return dbDao.searchSmpRole(usrId);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * 입력한 RHQ의 유효성을 확인합니다.
	 * @param String slsRhqCd
	 * 
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkRhq(String slsRhqCd) throws EventException {
		try {
			return dbDao.checkRhq(slsRhqCd);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 입력한 Sub Trade의 유효성을 확인합니다.
	 * @param String trdCd
	 * @param String subTrdCd
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkSubTrdCd(String trdCd, String subTrdCd) throws EventException {
		try {
			return dbDao.checkSubTrdCd(trdCd, subTrdCd);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
}
