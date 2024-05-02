/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : MultiDimensionRPTBCImpl.java
 *@FileTitle : 점소 Weekly 비정형 실적 분석 RPT조회
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-11-09
 *@LastModifier : Sangwook_nam
 *@LastVersion : 1.0
 * 2006-11-09 Sangwook_nam
 * 1.0 최초 생성    
 * 2008.04.03 전성진 N200803310003 물류레포트 파일 분리    
 * 2008.08.29 박상희 N200807298360 Expense Detail로 테이블 변경하면서 sales 디렉토리로 소스분리
 * 2008.10.20 전윤주 N200810200014 Expense Detail로 테이블 변경하면서 sales 디렉토리로 소스분리 [057]
 * 2008.10.21 박상희 N200810200009 Expense Detail로 테이블 변경하면서 sales 디렉토리로 소스분리 [078]
 * 2009.07.23 박수훈 New Framework 적용 [0130]  
 * 2009.09.21 김기식   New FrameWork 적용 [0063,0065,0066,0067]
 * 2010.02.05 임옥영 소스품질검토 결과 반영 (지역변수 소문자로 시작하게,
                    multiReportView의 UpdateVoListVO->updateVoListVO, UpdateVoListVO2->updateVoListVO2
 * 2010.09.01 김기종 CSR No. CHM-201005370-01 Inquiry by customized condition 기능 개선                    
 * 2012.06.25 이석준 [CHM-201218363-01] P&L by Lane Report data creation 기능 추가
 * 2012.10.15 이석준 [CHM-201220161-01] 실시간 영업현황 관련 UI
 * 2013.06.13 서미진 [CHM-201325024] 2주차씩 Creation이 되고 완료 되었을때 완료 메세지가 뜨게 수정
 * 2014.01.02 김수정 [CHM-201327858] [MAS] IAS P&L 추가
 * 2015.09.15 김성욱, 소스 보안 품질 작업
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.integration.MultiDimensionRPTDBDAO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.vo.MultiDimensionPfmcByOfficeListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.vo.MultiDimensionRptRtnVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.vo.RepoPfmcConditionVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.vo.SearchAdjCostDtlListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.vo.SearchIasSubCdListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.vo.SearchMultiDimension068ListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.vo.SearchReportViewListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.vo.SearchCondition0153VO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.vo.SearchCostSetUpListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MasRptAuthMgmtVO;
import com.hanjin.syscommon.common.table.MasUtCostCreStsVO;
import com.hanjin.syscommon.common.util.ScheduleUtil;

/**
 * ALPS-MAS Business Logic Basic Command implementation<br>
 * - ALPS-MAS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Sangwook_nam
 * @see multiDimensionRPTBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class MultiDimensionRPTBCImpl extends BasicCommandSupport implements
		MultiDimensionRPTBC {

	// Database Access Object
	private transient MultiDimensionRPTDBDAO dbDao = null;

	/**
	 * MultiDimensionRPTBCImpl 객체 생성<br>
	 * MultiDimensionRPTDBDAO를 생성한다.<br>
	 */
	public MultiDimensionRPTBCImpl() {
		dbDao = new MultiDimensionRPTDBDAO();
	}

	// /**
	// * 조회 이벤트 처리<br>
	// * MultiDimension화면에 대한 조회 이벤트 처리<br>
	// * @param e
	// *
	// * @return response ESM_MAS_062EventResponse
	// * @exception EventException
	// */
	// public EventResponse searchMultiDimensionRPT062List(Event e) throws
	// EventException {
	//
	// ESM_MAS_062Event event=(ESM_MAS_062Event)e; // PDTO(Data Transfer Object
	// including Parameters)
	// DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
	// //String strItem = "";
	// //int cnt = 0;
	// try {
	// //rowSet=dbDao.searchMultiDimensionRPT062List(event, strItem);
	// rowSet=dbDao.searchMultiDimensionRPT062List(event);
	// return new ESM_MAS_062EventResponse(rowSet,"SUCCESS");
	// } catch (DAOException de) {
	// log.error("err "+de.toString(),de);
	// throw new EventException(de.getMessage());
	// } catch (Exception et){
	// log.error("err "+et.toString(),et);
	// throw new EventException(et.getMessage());
	// }
	// }
	//
	// /**
	// * MAS 업무 시나리오 마감작업<br>
	// * MultiDimensionRPT업무 시나리오 종료시 관련 내부객체 해제<br>
	// */
	// public EventResponse searchMultiDimensionRPT062List2(Event e) throws
	// EventException {
	// ESM_MAS_062Event event = (ESM_MAS_062Event)e; // PDTO(Data Transfer
	// Object including Parameters)
	// // DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
	// String[] strItem = new String[2];
	// try {
	// String selGroup = event.getString("selGroup").trim();
	// log.debug("\n#### selGroup : " + selGroup);
	// if (!selGroup.equals("")) {
	// strItem = searchRptItem4(event);
	// } else {
	// strItem[0] = "";
	// strItem[1] = "";
	// }
	// // rowSet = dbDao.searchMultiDimensionRPT062List(event, strItem[1]);
	// return new ESM_MAS_062EventResponse(strItem[0], strItem[1], "SUCCESS");
	// // } catch (DAOException de) {
	// // log.error("err "+de.toString(),de);
	// // throw new EventException(de.getMessage());
	// } catch (Exception et){
	// log.error("err "+et.toString(),et);
	// throw new EventException(et.getMessage());
	// }
	// }

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RepoPfmcConditionVO repoPfmcConditionVO
	 * @return List<MultiDimensionPfmcByOfficeListVO>
	 * @exception EventException
	 */
	public List<MultiDimensionPfmcByOfficeListVO> searchMultiDimension0063List(
			RepoPfmcConditionVO repoPfmcConditionVO) throws EventException {

		try {
			return dbDao.searchMultiDimension0063List(repoPfmcConditionVO);
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e	 * 
	 * @return response ESM_MAS_063EventResponse
	 * @exception EventException
	 */
	// public EventResponse searchMultiDimension065List(Event e) throws
	// EventException {
	// DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
	// ESM_MAS_065Event event=(ESM_MAS_065Event)e;
	//
	// try {
	// rowSet=dbDao.searchMultiDimension065List(event);
	// return new ESM_MAS_065EventResponse(rowSet,"SUCCESS");
	// } catch (DAOException de) {
	// log.error("err "+de.toString(),de);
	// throw new EventException(de.getMessage());
	// }
	// }

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RepoPfmcConditionVO repoPfmcConditionVO
	 * @return MultiDimensionPfmcByOfficeListVO
	 * @exception EventException
	 */
	public MultiDimensionPfmcByOfficeListVO searchMultiDimension0066List(
			RepoPfmcConditionVO repoPfmcConditionVO) throws EventException {
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet hRs = null;
		MultiDimensionPfmcByOfficeListVO rtnVo = new MultiDimensionPfmcByOfficeListVO();
		List<String> cols = new ArrayList();

		try {
			String[] cArr = null;
			String[] rtoArr = null;
			hRs = dbDao.searchMultiDimension0066VarHeader(repoPfmcConditionVO);

			int i = 0;
			if (hRs != null) {
				cArr = new String[hRs.getRowCount()];
				rtoArr = new String[hRs.getRowCount()];
				while (hRs.next()) {
					cArr[i] = hRs.getString("cntr_tpsz_cd");
					rtoArr[i++] = hRs.getString("eq_repo_cr_rto");
					cols.add(hRs.getString("cntr_tpsz_cd"));
				}
			}
			if (cArr != null) {
				rowSet = dbDao.searchMultiDimension0066List(
						repoPfmcConditionVO, cols);
			}
			rtnVo.setCArr(cArr);
			rtnVo.setRtoArr(rtoArr);
			rtnVo.setRowSet(rowSet);

			// log.debug("rowSet.getRowCount()===="+ rowSet.getRowCount());

			return rtnVo;
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * 
	 * @return response ESM_MAS_067EventResponse
	 * @exception EventException
	 */
	// public EventResponse searchMultiDimension067List(Event e) throws
	// EventException {
	// DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
	// ESM_MAS_067Event event=(ESM_MAS_067Event)e;
	//
	// try {
	// rowSet=dbDao.searchMultiDimension067List(event);
	// return new ESM_MAS_067EventResponse(rowSet,"SUCCESS");
	// } catch (DAOException de) {
	// log.error("err "+de.toString(),de);
	// throw new EventException(de.getMessage());
	// }
	// }

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RepoPfmcConditionVO repoPfmcConditionVO
	 * @return List<SearchMultiDimension068ListVO>
	 * @exception EventException
	 */
	public List<SearchMultiDimension068ListVO> searchMultiDimension0068List(
			RepoPfmcConditionVO repoPfmcConditionVO) throws EventException {

		try {
			return dbDao.searchMultiDimension0068List(repoPfmcConditionVO);
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * 
	 * @return response ESM_MAS_068EventResponse
	 * @exception EventException
	 */
	/*
	 * public EventResponse searchMultiDimension0682List(Event e) throws
	 * EventException { DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
	 * DBRowSet hRs = null; ESM_MAS_068Event event=(ESM_MAS_068Event)e;
	 * ESM_MAS_068EventResponse res= new ESM_MAS_068EventResponse();
	 * 
	 * try {
	 * 
	 * hRs = dbDao.searchMultiDimension0682VarHeader(event); String[] cArr =
	 * null; String[] rtoArr = null;
	 * 
	 * int i = 0; if (hRs != null) { cArr = new String[hRs.getRowCount()];
	 * rtoArr = new String[hRs.getRowCount()]; while (hRs.next()) { cArr[i] =
	 * hRs.getString("cntr_tpsz_cd"); rtoArr[i++] =
	 * hRs.getString("eq_repo_cr_rto"); } }
	 * 
	 * if(cArr != null) { rowSet=dbDao.searchMultiDimension0682List(event,
	 * cArr); res = new ESM_MAS_068EventResponse(rowSet,"SUCCESS", cArr,
	 * rtoArr); }
	 * 
	 * return res;
	 * 
	 * } catch (DAOException de) { log.error("err "+de.toString(),de); throw new
	 * EventException(de.getMessage()); } catch (SQLException se){
	 * log.error("err "+se.toString(),se); throw new
	 * EventException(se.getMessage()); }
	 * 
	 * }
	 */

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @return List<MultiDimensionPfmcByOfficeListVO>
	 * @exception EventException
	 */
	public List<MultiDimensionPfmcByOfficeListVO> searchMultiDimension0069List(
			RepoPfmcConditionVO vo) throws EventException {
		try {
			return dbDao.searchMultiDimension0069List(vo);
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RepoPfmcConditionVO repoPfmcConditionVO
	 * @return MultiDimensionPfmcByOfficeListVO
	 * @exception EventException
	 */
	public MultiDimensionPfmcByOfficeListVO searchMultiDimension00692List(
			RepoPfmcConditionVO repoPfmcConditionVO) throws EventException {
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet hRs = null;
		MultiDimensionPfmcByOfficeListVO rtnVo = new MultiDimensionPfmcByOfficeListVO();
		List<String> cols = new ArrayList();

		try {
			String[] cArr = null;
			String[] rtoArr = null;
			hRs = dbDao.searchMultiDimension0066VarHeader(repoPfmcConditionVO);

			int i = 0;
			if (hRs != null) {
				cArr = new String[hRs.getRowCount()];
				rtoArr = new String[hRs.getRowCount()];
				while (hRs.next()) {
					cArr[i] = hRs.getString("cntr_tpsz_cd");
					rtoArr[i++] = hRs.getString("eq_repo_cr_rto");
					cols.add(hRs.getString("cntr_tpsz_cd"));
				}
			}
			if (cArr != null) {
				rowSet = dbDao.searchMultiDimension00692List(
						repoPfmcConditionVO, cols);
			}
			rtnVo.setCArr(cArr);
			rtnVo.setRtoArr(rtoArr);
			rtnVo.setRowSet(rowSet);

			return rtnVo;
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * 
	 * @return response ESM_MAS_067EventResponse
	 * @exception EventException
	 */
	// public EventResponse searchMultiDimension0672List(Event e) throws
	// EventException {
	// DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
	// ESM_MAS_067Event event=(ESM_MAS_067Event)e;
	//
	// try {
	// rowSet=dbDao.searchMultiDimension0672List(event);
	// return new ESM_MAS_067EventResponse(rowSet,"SUCCESS");
	// } catch (DAOException de) {
	// log.error("err "+de.toString(),de);
	// throw new EventException(de.getMessage());
	// }
	// }

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * 
	 * @return response ESM_MAS_063EventResponse
	 * @exception EventException
	 */
	// public EventResponse searchMultiDimension0632List(Event e) throws
	// EventException {
	// DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
	// ESM_MAS_063Event event=(ESM_MAS_063Event)e;
	//
	// try {
	// rowSet=dbDao.searchMultiDimension0632List(event);
	// return new ESM_MAS_063EventResponse(rowSet,"SUCCESS");
	// } catch (DAOException de) {
	// log.error("err "+de.toString(),de);
	// throw new EventException(de.getMessage());
	// }
	// }

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * ESM_MAS_0130화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchReportViewListVO searchReportViewListVO
	 * @return List<SearchReportViewListVO>
	 * @exception EventException
	 */
	public List<SearchReportViewListVO> searchReportViewList(
			SearchReportViewListVO searchReportViewListVO)
			throws EventException {
		try {
			return dbDao.searchReportViewList(searchReportViewListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * * ESM_MAS_0130화면에 대한 저장 이벤트 처리<br>
	 * 
	 * @param SearchReportViewListVO[] searchReportViewListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiReportView(
			SearchReportViewListVO[] searchReportViewListVO,
			SignOnUserAccount account) throws EventException {
		try {
			List<MasRptAuthMgmtVO> updateVoList = new ArrayList<MasRptAuthMgmtVO>();

			String usr_id = account.getUsr_id();

			for (int i = 0; i < searchReportViewListVO.length; i++) {
				if (searchReportViewListVO[i].getIbflag().equals("U")) {

					MasRptAuthMgmtVO updateVoListVO = new MasRptAuthMgmtVO();

					updateVoListVO.setPfitVwDfltCd((searchReportViewListVO[i]
							.getPfitDflt().equals("P")) ? "Y" : "N");
					updateVoListVO.setPfitVwSlctFlg(searchReportViewListVO[i]
							.getPfitCd1());
					updateVoListVO.setOfcVwDfltCd((searchReportViewListVO[i]
							.getOfcDflt().equals("C")) ? "Y" : "N");
					updateVoListVO.setOfcVwSlctFlg(searchReportViewListVO[i]
							.getOfcCd1());
					updateVoListVO.setPfitLvlDfltCd((searchReportViewListVO[i]
							.getLvlDflt().equals("C")) ? "Y" : "N");
					updateVoListVO.setPfitLvlSlctFlg(searchReportViewListVO[i]
							.getLvlCd1());
					updateVoListVO.setUpdUsrId(usr_id);
					updateVoListVO.setRptSeq(searchReportViewListVO[i]
							.getRptSeq());
					updateVoListVO.setOfcLvl(searchReportViewListVO[i]
							.getOfcLvl());
					updateVoList.add(updateVoListVO);

					MasRptAuthMgmtVO updateVoListVO2 = new MasRptAuthMgmtVO();
					updateVoListVO2.setPfitVwDfltCd((searchReportViewListVO[i]
							.getPfitDflt().equals("R")) ? "Y" : "N");
					updateVoListVO2.setPfitVwSlctFlg(searchReportViewListVO[i]
							.getPfitCd2());
					updateVoListVO2.setOfcVwDfltCd((searchReportViewListVO[i]
							.getOfcDflt().equals("L")) ? "Y" : "N");
					updateVoListVO2.setOfcVwSlctFlg(searchReportViewListVO[i]
							.getOfcCd2());
					updateVoListVO2.setPfitLvlDfltCd((searchReportViewListVO[i]
							.getLvlDflt().equals("O")) ? "Y" : "N");
					updateVoListVO2.setPfitLvlSlctFlg(searchReportViewListVO[i]
							.getLvlCd2());
					updateVoListVO2.setUpdUsrId(usr_id);
					updateVoListVO2
							.setRptSeq(String.valueOf(Integer
									.parseInt(searchReportViewListVO[i]
											.getRptSeq()) + 1));
					updateVoListVO2.setOfcLvl(searchReportViewListVO[i]
							.getOfcLvl());
					updateVoList.add(updateVoListVO2);

				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyMultiReportView(updateVoList);
			}
		} catch (DAOException ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 헤더 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 헤더 조회 이벤트 처리<br>
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3HeaderList(
			RepoPfmcConditionVO vo) throws EventException {
		DBRowSet[] rowSetArr = new DBRowSet[2]; // 데이터 전송을 위해 DB ResultSet을 구현한
												// 객체
		List<MultiDimensionRptRtnVO> rtnList = new ArrayList<MultiDimensionRptRtnVO>();
		MultiDimensionRptRtnVO rtnVo = new MultiDimensionRptRtnVO();

		String strDisplay = "O";

		try {
			vo.setFProVw("P");
			vo.setFProLvl("O");
			vo.setFProObj("P");

			// By Object
			// - P: Actual Operating Profit
			// - A: Trade Economical Profit
			// - B: Trade Grp Operating Profit
			// P->O:실적, A:항로, B:TS기여도
			if (vo.getFProObj().equals("P")) {
				strDisplay = "O";
			} else {
				strDisplay = vo.getFProObj();
			}
			vo.setStrDisplay(strDisplay);

			rowSetArr[0] = dbDao.searchLaneRgstList(vo);
			rowSetArr[1] = dbDao.searchPfitLssRptItmList(vo);

			rtnVo.setRowSets(rowSetArr);
			rtnList.add(rtnVo);
			return rtnList;
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased1List(
			RepoPfmcConditionVO vo) throws EventException {
		DBRowSet[] rowSetArr = new DBRowSet[2]; // 데이터 전송을 위해 DB ResultSet을 구현한
												// 객체
		List<MultiDimensionRptRtnVO> rtnList = new ArrayList<MultiDimensionRptRtnVO>();
		MultiDimensionRptRtnVO rtnVo = new MultiDimensionRptRtnVO();
		String strDisplay = "O";
		String fProVw = "";
		String fProLvl = "";
		String fProObj = "";
		List<String> cols = new ArrayList();

		try {
			// By Object
			// - P: Actual Operating Profit
			// - A: Trade Economical Profit
			// - B: Trade Grp Operating Profit
			// P->O:실적, A:항로, B:TS기여도
			fProVw = (vo.getFProVw() == null) ? "P" : vo.getFProVw();
			fProLvl = (vo.getFProLvl() == null) ? "O" : vo.getFProLvl();
			fProObj = (vo.getFProObj() == null) ? "P" : vo.getFProObj();
			vo.setFProVw(fProVw);
			vo.setFProLvl(fProLvl);
			vo.setFProObj(fProObj);

			if (fProObj.equals("P")) {
				strDisplay = "O";
			} else {
				strDisplay = vo.getFProObj();
			}
			vo.setStrDisplay(strDisplay);

			// Header
			rowSetArr[0] = dbDao.searchLaneRgstList(vo);
			if (rowSetArr[0] != null) {
				while (rowSetArr[0].next()) {
					cols.add(rowSetArr[0].getString("trd_cd"));
				}
			}
			rowSetArr[0].beforeFirst();

			// Data
			if ("OP6".equals(vo.getFOpView())) {
				rowSetArr[1] = dbDao
						.searchWeeklySalesByOffice3TEUBased1Op6List(vo, cols);
			} else if ("OP5".equals(vo.getFOpView())) {
				rowSetArr[1] = dbDao
						.searchWeeklySalesByOffice3TEUBased1Op5List(vo, cols);
			} else if ("OP4".equals(vo.getFOpView())) {
				rowSetArr[1] = dbDao
						.searchWeeklySalesByOffice3TEUBased1Op4List(vo, cols);
			} else {
				rowSetArr[1] = dbDao.searchWeeklySalesByOffice3TEUBased1List(
						vo, cols);
			}

			rtnVo.setRowSets(rowSetArr);
			rtnList.add(rtnVo);

			return rtnList;
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased2List(
			RepoPfmcConditionVO vo) throws EventException {
		DBRowSet[] rowSetArr = new DBRowSet[2]; // 데이터 전송을 위해 DB ResultSet을 구현한
												// 객체
		List<MultiDimensionRptRtnVO> rtnList = new ArrayList<MultiDimensionRptRtnVO>();
		MultiDimensionRptRtnVO rtnVo = new MultiDimensionRptRtnVO();
		String strDisplay = "O";
		String fProVw = "";
		String fProLvl = "";
		String fProObj = "";
		List<String> cols = new ArrayList();

		try {
			// By Object
			// - P: Actual Operating Profit
			// - A: Trade Economical Profit
			// - B: Trade Grp Operating Profit
			// P->O:실적, A:항로, B:TS기여도
			fProVw = (vo.getFProVw() == null) ? "P" : vo.getFProVw();
			fProLvl = (vo.getFProLvl() == null) ? "O" : vo.getFProLvl();
			fProObj = (vo.getFProObj() == null) ? "P" : vo.getFProObj();
			vo.setFProVw(fProVw);
			vo.setFProLvl(fProLvl);
			vo.setFProObj(fProObj);

			if (fProObj.equals("P")) {
				strDisplay = "O";
			} else {
				strDisplay = vo.getFProObj();
			}
			vo.setStrDisplay(strDisplay);

			// Header
			rowSetArr[0] = dbDao.searchPfitLssRptItmList(vo);
			if (rowSetArr[0] != null) {
				while (rowSetArr[0].next()) {
					cols.add(rowSetArr[0].getString("stnd_cost_cd"));
				}
			}
			rowSetArr[0].beforeFirst();

			// Data
			if ("OP6".equals(vo.getFOpView())) {
				rowSetArr[1] = dbDao
						.searchWeeklySalesByOffice3TEUBased2Op6List(vo, cols);
			} else if ("OP5".equals(vo.getFOpView())) {
				rowSetArr[1] = dbDao
						.searchWeeklySalesByOffice3TEUBased2Op5List(vo, cols);
			} else if ("OP4".equals(vo.getFOpView())) {
				rowSetArr[1] = dbDao
						.searchWeeklySalesByOffice3TEUBased2Op4List(vo, cols);
			} else {
				rowSetArr[1] = dbDao.searchWeeklySalesByOffice3TEUBased2List(
						vo, cols);
			}

			rtnVo.setRowSets(rowSetArr);
			rtnList.add(rtnVo);

			return rtnList;
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased3List(
			RepoPfmcConditionVO vo) throws EventException {
		DBRowSet[] rowSetArr = new DBRowSet[2]; // 데이터 전송을 위해 DB ResultSet을 구현한
												// 객체
		List<MultiDimensionRptRtnVO> rtnList = new ArrayList<MultiDimensionRptRtnVO>();
		MultiDimensionRptRtnVO rtnVo = new MultiDimensionRptRtnVO();
		String strDisplay = "O";
		String fProVw = "";
		String fProLvl = "";
		String fProObj = "";
		List<String> cols = new ArrayList();

		try {
			// By Object
			// - P: Actual Operating Profit
			// - A: Trade Economical Profit
			// - B: Trade Grp Operating Profit
			// P->O:실적, A:항로, B:TS기여도
			fProVw = (vo.getFProVw() == null) ? "P" : vo.getFProVw();
			fProLvl = (vo.getFProLvl() == null) ? "O" : vo.getFProLvl();
			fProObj = (vo.getFProObj() == null) ? "P" : vo.getFProObj();
			vo.setFProVw(fProVw);
			vo.setFProLvl(fProLvl);
			vo.setFProObj(fProObj);

			if (fProObj.equals("P")) {
				strDisplay = "O";
			} else {
				strDisplay = vo.getFProObj();
			}
			vo.setStrDisplay(strDisplay);

			// Header
			rowSetArr[0] = dbDao.searchPfitLssRptItmList(vo);
			if (rowSetArr[0] != null) {
				while (rowSetArr[0].next()) {
					cols.add(rowSetArr[0].getString("stnd_cost_cd"));
				}
			}
			rowSetArr[0].beforeFirst();

			// Data
			if ("OP6".equals(vo.getFOpView())) {
				rowSetArr[1] = dbDao
						.searchWeeklySalesByOffice3TEUBased3Op6List(vo, cols);
			} else if ("OP5".equals(vo.getFOpView())) {
				rowSetArr[1] = dbDao
						.searchWeeklySalesByOffice3TEUBased3Op5List(vo, cols);
			} else if ("OP4".equals(vo.getFOpView())) {
				rowSetArr[1] = dbDao
						.searchWeeklySalesByOffice3TEUBased3Op4List(vo, cols);
			} else {
				rowSetArr[1] = dbDao.searchWeeklySalesByOffice3TEUBased3List(
						vo, cols);
			}

			rtnVo.setRowSets(rowSetArr);
			rtnList.add(rtnVo);

			return rtnList;
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased4List(
			RepoPfmcConditionVO vo) throws EventException {
		DBRowSet[] rowSetArr = new DBRowSet[2]; // 데이터 전송을 위해 DB ResultSet을 구현한
												// 객체
		List<MultiDimensionRptRtnVO> rtnList = new ArrayList<MultiDimensionRptRtnVO>();
		MultiDimensionRptRtnVO rtnVo = new MultiDimensionRptRtnVO();
		String strDisplay = "O";
		String fProVw = "";
		String fProLvl = "";
		String fProObj = "";
		List<String> cols = new ArrayList<String>();

		try {
			// By Object
			// - P: Actual Operating Profit
			// - A: Trade Economical Profit
			// - B: Trade Grp Operating Profit
			// P->O:실적, A:항로, B:TS기여도
			fProVw = (vo.getFProVw() == null) ? "P" : vo.getFProVw();
			fProLvl = (vo.getFProLvl() == null) ? "O" : vo.getFProLvl();
			fProObj = (vo.getFProObj() == null) ? "P" : vo.getFProObj();
			vo.setFProVw(fProVw);
			vo.setFProLvl(fProLvl);
			vo.setFProObj(fProObj);

			if (fProObj.equals("P")) {
				strDisplay = "O";
			} else {
				strDisplay = vo.getFProObj();
			}
			vo.setStrDisplay(strDisplay);

			// Header
			rowSetArr[0] = dbDao.searchLaneRgstList(vo);
			if (rowSetArr[0] != null) {
				while (rowSetArr[0].next()) {
					cols.add(rowSetArr[0].getString("trd_cd"));
				}
			}
			rowSetArr[0].beforeFirst();

			// Data
			if ("OP6".equals(vo.getFOpView())) {
				rowSetArr[1] = dbDao
						.searchWeeklySalesByOffice3TEUBased4Op6List(vo, cols);
			} else if ("OP5".equals(vo.getFOpView())) {
				rowSetArr[1] = dbDao
						.searchWeeklySalesByOffice3TEUBased4Op5List(vo, cols);
			} else if ("OP4".equals(vo.getFOpView())) {
				rowSetArr[1] = dbDao
						.searchWeeklySalesByOffice3TEUBased4Op4List(vo, cols);
			} else {
				rowSetArr[1] = dbDao.searchWeeklySalesByOffice3TEUBased4List(
						vo, cols);
			}

			rtnVo.setRowSets(rowSetArr);
			rtnList.add(rtnVo);

			return rtnList;
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased5List(
			RepoPfmcConditionVO vo) throws EventException {
		DBRowSet[] rowSetArr = new DBRowSet[2]; // 데이터 전송을 위해 DB ResultSet을 구현한
												// 객체
		List<MultiDimensionRptRtnVO> rtnList = new ArrayList<MultiDimensionRptRtnVO>();
		MultiDimensionRptRtnVO rtnVo = new MultiDimensionRptRtnVO();
		String strDisplay = "O";
		String fProVw = "";
		String fProLvl = "";
		String fProObj = "";
		List<String> cols = new ArrayList<String>();

		try {
			// By Object
			// - P: Actual Operating Profit
			// - A: Trade Economical Profit
			// - B: Trade Grp Operating Profit
			// P->O:실적, A:항로, B:TS기여도
			fProVw = (vo.getFProVw() == null) ? "P" : vo.getFProVw();
			fProLvl = (vo.getFProLvl() == null) ? "O" : vo.getFProLvl();
			fProObj = (vo.getFProObj() == null) ? "P" : vo.getFProObj();
			vo.setFProVw(fProVw);
			vo.setFProLvl(fProLvl);
			vo.setFProObj(fProObj);

			if (fProObj.equals("P")) {
				strDisplay = "O";
			} else {
				strDisplay = vo.getFProObj();
			}
			vo.setStrDisplay(strDisplay);

			// Adjusted pl의 header 정보검색시 사용
			vo.setFTab("Y");

			// Header
			rowSetArr[0] = dbDao.searchPfitLssRptItmList(vo);
			if (rowSetArr[0] != null) {
				while (rowSetArr[0].next()) {
					cols.add(rowSetArr[0].getString("stnd_cost_cd"));
				}
			}
			rowSetArr[0].beforeFirst();

			// Data
			if ("OP6".equals(vo.getFOpView())) {
				rowSetArr[1] = dbDao
						.searchWeeklySalesByOffice3TEUBased5Op6List(vo, cols);
			} else if ("OP5".equals(vo.getFOpView())) {
				rowSetArr[1] = dbDao
						.searchWeeklySalesByOffice3TEUBased5Op5List(vo, cols);
			} else if ("OP4".equals(vo.getFOpView())) {
				rowSetArr[1] = dbDao
						.searchWeeklySalesByOffice3TEUBased5Op4List(vo, cols);
			} else {
				rowSetArr[1] = dbDao.searchWeeklySalesByOffice3TEUBased5List(
						vo, cols);
			}

			rtnVo.setRowSets(rowSetArr);
			rtnList.add(rtnVo);

			return rtnList;
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased6List(
			RepoPfmcConditionVO vo) throws EventException {
		DBRowSet[] rowSetArr = new DBRowSet[2]; // 데이터 전송을 위해 DB ResultSet을 구현한
												// 객체
		List<MultiDimensionRptRtnVO> rtnList = new ArrayList<MultiDimensionRptRtnVO>();
		MultiDimensionRptRtnVO rtnVo = new MultiDimensionRptRtnVO();
		String strDisplay = "O";
		String fProVw = "";
		String fProLvl = "";
		String fProObj = "";
		List<String> cols = new ArrayList<String>();

		try {
			// By Object
			// - P: Actual Operating Profit
			// - A: Trade Economical Profit
			// - B: Trade Grp Operating Profit
			// P->O:실적, A:항로, B:TS기여도
			fProVw = (vo.getFProVw() == null) ? "P" : vo.getFProVw();
			fProLvl = (vo.getFProLvl() == null) ? "O" : vo.getFProLvl();
			fProObj = (vo.getFProObj() == null) ? "P" : vo.getFProObj();
			vo.setFProVw(fProVw);
			vo.setFProLvl(fProLvl);
			vo.setFProObj(fProObj);

			if (fProObj.equals("P")) {
				strDisplay = "O";
			} else {
				strDisplay = vo.getFProObj();
			}
			vo.setStrDisplay(strDisplay);

			// Adjusted pl의 header 정보검색시 사용
			vo.setFTab("Y");

			// Header
			rowSetArr[0] = dbDao.searchPfitLssRptItmList(vo);
			if (rowSetArr[0] != null) {
				while (rowSetArr[0].next()) {
					cols.add(rowSetArr[0].getString("stnd_cost_cd"));
				}
			}
			rowSetArr[0].beforeFirst();

			// Data
			if ("OP6".equals(vo.getFOpView())) {
				rowSetArr[1] = dbDao
						.searchWeeklySalesByOffice3TEUBased6Op6List(vo, cols);
			} else if ("OP5".equals(vo.getFOpView())) {
				rowSetArr[1] = dbDao
						.searchWeeklySalesByOffice3TEUBased6Op5List(vo, cols);
			} else if ("OP4".equals(vo.getFOpView())) {
				rowSetArr[1] = dbDao
						.searchWeeklySalesByOffice3TEUBased6Op4List(vo, cols);
			} else {
				rowSetArr[1] = dbDao.searchWeeklySalesByOffice3TEUBased6List(
						vo, cols);
			}

			rtnVo.setRowSets(rowSetArr);
			rtnList.add(rtnVo);

			return rtnList;
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased7List(
			RepoPfmcConditionVO vo) throws EventException {
		DBRowSet[] rowSetArr = new DBRowSet[2]; // 데이터 전송을 위해 DB ResultSet을 구현한
												// 객체
		List<MultiDimensionRptRtnVO> rtnList = new ArrayList<MultiDimensionRptRtnVO>();
		MultiDimensionRptRtnVO rtnVo = new MultiDimensionRptRtnVO();
		String strDisplay = "O";
		String fProVw = "";
		String fProLvl = "";
		String fProObj = "";
		List<String> cols = new ArrayList();

		try {
			// By Object
			// - P: Actual Operating Profit
			// - A: Trade Economical Profit
			// - B: Trade Grp Operating Profit
			// P->O:실적, A:항로, B:TS기여도
			fProVw = (vo.getFProVw() == null) ? "P" : vo.getFProVw();
			fProLvl = (vo.getFProLvl() == null) ? "O" : vo.getFProLvl();
			fProObj = (vo.getFProObj() == null) ? "P" : vo.getFProObj();
			vo.setFProVw(fProVw);
			vo.setFProLvl(fProLvl);
			vo.setFProObj(fProObj);

			if (fProObj.equals("P")) {
				strDisplay = "O";
			} else {
				strDisplay = vo.getFProObj();
			}
			vo.setStrDisplay(strDisplay);

			// Header
			rowSetArr[0] = dbDao.searchPfitLssRptItmList(vo);
			if (rowSetArr[0] != null) {
				while (rowSetArr[0].next()) {
					cols.add(rowSetArr[0].getString("stnd_cost_cd"));
				}
			}
			rowSetArr[0].beforeFirst();

			// Data
			rowSetArr[1] = dbDao.searchWeeklySalesByOffice3TEUBased7List(vo,
					cols);

			rtnVo.setRowSets(rowSetArr);
			rtnList.add(rtnVo);

			return rtnList;
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased8List(
			RepoPfmcConditionVO vo) throws EventException {
		DBRowSet[] rowSetArr = new DBRowSet[2]; // 데이터 전송을 위해 DB ResultSet을 구현한
												// 객체
		List<MultiDimensionRptRtnVO> rtnList = new ArrayList<MultiDimensionRptRtnVO>();
		MultiDimensionRptRtnVO rtnVo = new MultiDimensionRptRtnVO();
		String strDisplay = "O";
		String fProVw = "";
		String fProLvl = "";
		String fProObj = "";
		List<String> cols = new ArrayList<String>();

		try {
			// By Object
			// - P: Actual Operating Profit
			// - A: Trade Economical Profit
			// - B: Trade Grp Operating Profit
			// P->O:실적, A:항로, B:TS기여도
			fProVw = (vo.getFProVw() == null) ? "P" : vo.getFProVw();
			fProLvl = (vo.getFProLvl() == null) ? "O" : vo.getFProLvl();
			fProObj = (vo.getFProObj() == null) ? "P" : vo.getFProObj();
			vo.setFProVw(fProVw);
			vo.setFProLvl(fProLvl);
			vo.setFProObj(fProObj);

			if (fProObj.equals("P")) {
				strDisplay = "O";
			} else {
				strDisplay = vo.getFProObj();
			}
			vo.setStrDisplay(strDisplay);

			// Adjusted pl의 header 정보검색시 사용
			vo.setFTab("Y");

			// Header
			rowSetArr[0] = dbDao.searchPfitLssRptItmList(vo);
			if (rowSetArr[0] != null) {
				while (rowSetArr[0].next()) {
					cols.add(rowSetArr[0].getString("stnd_cost_cd"));
				}
			}
			rowSetArr[0].beforeFirst();

			// Data
			rowSetArr[1] = dbDao.searchWeeklySalesByOffice3TEUBased8List(vo,
					cols);

			rtnVo.setRowSets(rowSetArr);
			rtnList.add(rtnVo);

			return rtnList;
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
     * 조회 이벤트 처리<br>
     * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
     * 
     * @param RepoPfmcConditionVO vo
     * @return List<MultiDimensionRptRtnVO>
     * @exception EventException
     */
    public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased9List(
            RepoPfmcConditionVO vo) throws EventException {
        DBRowSet[] rowSetArr = new DBRowSet[2]; // 데이터 전송을 위해 DB ResultSet을 구현한
                                                // 객체
        List<MultiDimensionRptRtnVO> rtnList = new ArrayList<MultiDimensionRptRtnVO>();
        MultiDimensionRptRtnVO rtnVo = new MultiDimensionRptRtnVO();
        String strDisplay = "O";
        String fProVw = "";
        String fProLvl = "";
        String fProObj = "";
        List<String> cols = new ArrayList<String>();

        try {
            // By Object
            // - P: Actual Operating Profit
            // - A: Trade Economical Profit
            // - B: Trade Grp Operating Profit
            // P->O:실적, A:항로, B:TS기여도
            fProVw = (vo.getFProVw() == null) ? "P" : vo.getFProVw();
            fProLvl = (vo.getFProLvl() == null) ? "O" : vo.getFProLvl();
            fProObj = (vo.getFProObj() == null) ? "P" : vo.getFProObj();
            vo.setFProVw(fProVw);
            vo.setFProLvl(fProLvl);
            vo.setFProObj(fProObj);

            if (fProObj.equals("P")) {
                strDisplay = "O";
            } else {
                strDisplay = vo.getFProObj();
            }
            vo.setStrDisplay(strDisplay);

            // Header
            rowSetArr[0] = dbDao.searchLaneRgstList(vo);
            if (rowSetArr[0] != null) {
                while (rowSetArr[0].next()) {
                    cols.add(rowSetArr[0].getString("trd_cd"));
                }
            }
            rowSetArr[0].beforeFirst();

            // Data
            rowSetArr[1] = dbDao.searchWeeklySalesByOffice3TEUBased9List(vo, cols);

            rtnVo.setRowSets(rowSetArr);
            rtnList.add(rtnVo);

            return rtnList;
        } catch (DAOException de) {
            throw new EventException(de.getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }
    
    /**
     * 조회 이벤트 처리<br>
     * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
     * 
     * @param RepoPfmcConditionVO vo
     * @return List<MultiDimensionRptRtnVO>
     * @exception EventException
     */
    public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased10List(
            RepoPfmcConditionVO vo) throws EventException {
        DBRowSet[] rowSetArr = new DBRowSet[2]; // 데이터 전송을 위해 DB ResultSet을 구현한
                                                // 객체
        List<MultiDimensionRptRtnVO> rtnList = new ArrayList<MultiDimensionRptRtnVO>();
        MultiDimensionRptRtnVO rtnVo = new MultiDimensionRptRtnVO();
        String strDisplay = "O";
        String fProVw = "";
        String fProLvl = "";
        String fProObj = "";
        List<String> cols = new ArrayList<String>();

        try {
            // By Object
            // - P: Actual Operating Profit
            // - A: Trade Economical Profit
            // - B: Trade Grp Operating Profit
            // P->O:실적, A:항로, B:TS기여도
            fProVw = (vo.getFProVw() == null) ? "P" : vo.getFProVw();
            fProLvl = (vo.getFProLvl() == null) ? "O" : vo.getFProLvl();
            fProObj = (vo.getFProObj() == null) ? "P" : vo.getFProObj();
            vo.setFProVw(fProVw);
            vo.setFProLvl(fProLvl);
            vo.setFProObj(fProObj);

            if (fProObj.equals("P")) {
                strDisplay = "O";
            } else {
                strDisplay = vo.getFProObj();
            }
            vo.setStrDisplay(strDisplay);

            // P&L by agreement의 header 정보검색시 사용
            vo.setFTab("G");

            // Header
            rowSetArr[0] = dbDao.searchPfitLssRptItmList(vo);
            if (rowSetArr[0] != null) {
                while (rowSetArr[0].next()) {
                    cols.add(rowSetArr[0].getString("stnd_cost_cd"));
                }
            }
            rowSetArr[0].beforeFirst();

            rowSetArr[1] = dbDao.searchWeeklySalesByOffice3TEUBased10List(vo, cols);

            rtnVo.setRowSets(rowSetArr);
            rtnList.add(rtnVo);

            return rtnList;
        } catch (DAOException de) {
            throw new EventException(de.getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }
    
    /**
     * 조회 이벤트 처리<br>
     * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
     * 
     * @param RepoPfmcConditionVO vo
     * @return List<MultiDimensionRptRtnVO>
     * @exception EventException
     */
    public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased11List(
            RepoPfmcConditionVO vo) throws EventException {
        DBRowSet[] rowSetArr = new DBRowSet[2]; // 데이터 전송을 위해 DB ResultSet을 구현한
                                                // 객체
        List<MultiDimensionRptRtnVO> rtnList = new ArrayList<MultiDimensionRptRtnVO>();
        MultiDimensionRptRtnVO rtnVo = new MultiDimensionRptRtnVO();
        String strDisplay = "O";
        String fProVw = "";
        String fProLvl = "";
        String fProObj = "";
        List<String> cols = new ArrayList<String>();

        try {
            // By Object
            // - P: Actual Operating Profit
            // - A: Trade Economical Profit
            // - B: Trade Grp Operating Profit
            // P->O:실적, A:항로, B:TS기여도
            fProVw = (vo.getFProVw() == null) ? "P" : vo.getFProVw();
            fProLvl = (vo.getFProLvl() == null) ? "O" : vo.getFProLvl();
            fProObj = (vo.getFProObj() == null) ? "P" : vo.getFProObj();
            vo.setFProVw(fProVw);
            vo.setFProLvl(fProLvl);
            vo.setFProObj(fProObj);

            if (fProObj.equals("P")) {
                strDisplay = "O";
            } else {
                strDisplay = vo.getFProObj();
            }
            vo.setStrDisplay(strDisplay);

            // P&L by agreement의 header 정보검색시 사용
            vo.setFTab("G");

            // Header
            rowSetArr[0] = dbDao.searchPfitLssRptItmList(vo);
            if (rowSetArr[0] != null) {
                while (rowSetArr[0].next()) {
                    cols.add(rowSetArr[0].getString("stnd_cost_cd"));
                }
            }
            rowSetArr[0].beforeFirst();

            // Data
            rowSetArr[1] = dbDao.searchWeeklySalesByOffice3TEUBased11List(vo, cols);

            rtnVo.setRowSets(rowSetArr);
            rtnList.add(rtnVo);

            return rtnList;
        } catch (DAOException de) {
            throw new EventException(de.getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }
    
	/**
	 * 조회 이벤트 처리<br>
	 * IAS 협의체별 Scop 조회 (ESM_MAS_0178)<br>
	 * 
	 * @param SearchIasSubCdListVO vo
	 * @return List<SearchIasSubCdListVO>
	 * @exception EventException
	 */
	public List<SearchIasSubCdListVO> searchIasSubCdList(SearchIasSubCdListVO vo)
			throws EventException {
		try {
			return dbDao.searchIasSubCdList(vo);
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * IAS 협의체별 Scop 관리화면 Save 이벤트 처리(ESM_MAS_0178)<br>
	 * 
	 * @param SearchIasSubCdListVO[] searchIasSubCdListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageIasSubCdList(
			SearchIasSubCdListVO[] searchIasSubCdListVOs,
			SignOnUserAccount account) throws EventException {
		try {
			for (int i = 0; i < searchIasSubCdListVOs.length; i++) {
				if (searchIasSubCdListVOs[i].getIbflag().equals("I")) {
					searchIasSubCdListVOs[i].setCreUsrId(account.getUsr_id());
					searchIasSubCdListVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.addIasSubCdList(searchIasSubCdListVOs[i]);
				} else if (searchIasSubCdListVOs[i].getIbflag().equals("U")) {
					searchIasSubCdListVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyIasSubCdList(searchIasSubCdListVOs[i]);
				} else if (searchIasSubCdListVOs[i].getIbflag().equals("D")) {
					dbDao.removeIasSubCdList(searchIasSubCdListVOs[i]);
				}
			}
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * P/L Creation batch가 실행중인지를 check 한다.
	 * 
	 * @param String ucCd
	 * @return String
	 * @throws EventException
	 */
	public String checkProfitLossCreateBatchStatus(String ucCd)
			throws EventException {

		String batchRunningStatus = "4";
		RepoPfmcConditionVO repoPfmcConditionVO = new RepoPfmcConditionVO();
		// 실행 전 해당 Batch 모듈이 실행 중인지 확인한다.
		try {
			repoPfmcConditionVO.setFSchMode("C"); // creation시에 check하는 것
			repoPfmcConditionVO.setFUcCd(ucCd);
			List<MasUtCostCreStsVO> list = dbDao
					.searchProfitLossCreationStatus(repoPfmcConditionVO);

			if (list.size() > 0) { // 돌고 있는 batch가 있다는 뜻
				batchRunningStatus = "6";
			}
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12213",
					new String[] { "P/L Summary Creation" }).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return batchRunningStatus;
	}

	/**
	 * Week 단위로 P/L Summary batch를 수행한다.
	 * 
	 * @param RepoPfmcConditionVO repoPfmcConditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createProfitLossSummary(
			RepoPfmcConditionVO repoPfmcConditionVO, SignOnUserAccount account)
			throws EventException {

		ScheduleUtil su = new ScheduleUtil();
		String params = "";
		try {

			params = repoPfmcConditionVO.getFYear() + "#"
					+ repoPfmcConditionVO.getFFmWk() + "#"
					+ "S" // Screen에서 실행시킨 배치라는 의미
					+ "#" + account.getUsr_id() + "#"
					+ repoPfmcConditionVO.getFToWk();

			su.directExecuteJob("ESM_MAS_B003", params);

		} catch (IOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12213",
					new String[] { "P/L Summary Creation" }).getMessage(), e);
		} catch (InterruptedException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12213",
					new String[] { "P/L Summary Creation" }).getMessage(), e);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12213",
					new String[] { "P/L Summary Creation" }).getMessage(), e);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12213",
					new String[] { "P/L Summary Creation" }).getMessage(), e);
		}
		return "4";// 실행 성공
	}

	/**
	 * PL BATCH CREATE TABLE로부터 현재 BATCH의 STATUS를 알아본다.
	 * 
	 * @param RepoPfmcConditionVO repoPfmcConditionVO
	 * @return List<MasUtCostCreStsVO>
	 * @exception EventException
	 */
	public List<MasUtCostCreStsVO> searchProfitLossCreationStatus(
			RepoPfmcConditionVO repoPfmcConditionVO) throws EventException {
		try {
			repoPfmcConditionVO.setFSchMode("R"); // Retrieve시에 check하는 것
			return dbDao.searchProfitLossCreationStatus(repoPfmcConditionVO);
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RepoPfmcConditionVO repoPfmcConditionVO
	 * @return List<SearchAdjCostDtlListVO>
	 * @exception EventException
	 */
	public List<SearchAdjCostDtlListVO> searchAdjCostDetail(
			RepoPfmcConditionVO repoPfmcConditionVO) throws EventException {

		try {
			return dbDao.searchAdjCostDetail(repoPfmcConditionVO);
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchCostSetUpListVO>
	 * @exception EventException
	 */
	public List<SearchCostSetUpListVO> searchCostStupMTAbcList(
			SearchConditionVO searchConditionVO) throws EventException {
		try {
			String[] arrSearch = searchConditionVO.getFCostYrmon().split("[-]");
			String cost_yrmon = arrSearch[0] + arrSearch[1];
			searchConditionVO.setFCostYrmon(cost_yrmon);

			return dbDao.searchCostStupMTAbcList(searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * PNL BATCH status 를 생성한다. <br>
	 * 
	 * @param RepoPfmcConditionVO repoPfmcConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addProfitLossSummaryBatchStatus(
			RepoPfmcConditionVO repoPfmcConditionVO, SignOnUserAccount account)
			throws EventException {
		int start_wk = 0;
		int end_wk = 0;
		String pnl_week = null;

		try {
			start_wk = Integer.parseInt(repoPfmcConditionVO.getFFmWk());
			end_wk = Integer.parseInt(repoPfmcConditionVO.getFToWk());
			// shipper 를 user id 담기 위해 사용
			repoPfmcConditionVO.setFShipper(account.getUsr_id());
			for (int i = start_wk; i < end_wk + 1; i++) {
				if (Integer.toString(i).length() == 1) {
					pnl_week = "0" + Integer.toString(i);
				} else {
					pnl_week = Integer.toString(i);
				}
				// Tab 을 week 대신 사용
				repoPfmcConditionVO.setFTab(pnl_week);
				dbDao.addProfitLossSummaryBatchStatus(repoPfmcConditionVO);
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchPlAdjustmentTotalList(
			RepoPfmcConditionVO vo) throws EventException {
		DBRowSet[] rowSetArr = new DBRowSet[1]; // 데이터 전송을 위해 DB ResultSet을 구현한
												// 객체
		List<MultiDimensionRptRtnVO> rtnList = new ArrayList<MultiDimensionRptRtnVO>();
		MultiDimensionRptRtnVO rtnVo = new MultiDimensionRptRtnVO();
//		List<String> cols = new ArrayList<String>();

		try {
			rowSetArr[0] = dbDao.searchPlAdjustmentTotalList(vo);

			rtnVo.setRowSets(rowSetArr);
			rtnList.add(rtnVo);
			return rtnList;
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchPlAdjustmentTradeList(
			RepoPfmcConditionVO vo) throws EventException {
		DBRowSet[] rowSetArr = new DBRowSet[2]; // 데이터 전송을 위해 DB ResultSet을 구현한
												// 객체
		List<MultiDimensionRptRtnVO> rtnList = new ArrayList<MultiDimensionRptRtnVO>();
		MultiDimensionRptRtnVO rtnVo = new MultiDimensionRptRtnVO();
		List<String> cols = new ArrayList<String>();

		try {
			// Header
			rowSetArr[0] = dbDao.searchLaneRgstList(vo);
			if (rowSetArr[0] != null) {
				while (rowSetArr[0].next()) {
					cols.add(rowSetArr[0].getString("trd_cd"));
				}
			}
			rowSetArr[0].beforeFirst();

			rowSetArr[1] = dbDao.searchPlAdjustmentTradeList(vo, cols);

			rtnVo.setRowSets(rowSetArr);
			rtnList.add(rtnVo);

			return rtnList;
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchPlAdjustmentVVDList(
			RepoPfmcConditionVO vo) throws EventException {
		DBRowSet[] rowSetArr = new DBRowSet[2]; // 데이터 전송을 위해 DB ResultSet을 구현한
												// 객체
		List<MultiDimensionRptRtnVO> rtnList = new ArrayList<MultiDimensionRptRtnVO>();
		MultiDimensionRptRtnVO rtnVo = new MultiDimensionRptRtnVO();
		List<String> cols = new ArrayList<String>();

		try {
			// Adjusted pl의 header 정보검색시 사용
			vo.setFTab("Y");
			vo.setFProVw("P");

			// Header
			rowSetArr[0] = dbDao.searchPfitLssRptItmList(vo);
			if (rowSetArr[0] != null) {
				while (rowSetArr[0].next()) {
					cols.add(rowSetArr[0].getString("stnd_cost_cd"));
				}
			}
			rowSetArr[0].beforeFirst();
			rowSetArr[1] = dbDao.searchPlAdjustmentVVDList(vo, cols);

			rtnVo.setRowSets(rowSetArr);
			rtnList.add(rtnVo);

			return rtnList;
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Week 단위로 P/L Summary batch를 수행한다.
	 * 
	 * @param RepoPfmcConditionVO repoPfmcConditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createProfitLossAdjustment(
			RepoPfmcConditionVO repoPfmcConditionVO, SignOnUserAccount account)
			throws EventException {

		ScheduleUtil su = new ScheduleUtil();
		String params = "";
		try {
			params = repoPfmcConditionVO.getFYear() + "#"
					+ repoPfmcConditionVO.getFFmWk() + "#"
					+ account.getUsr_id() + "#"
					+ repoPfmcConditionVO.getFUcCd() + "#"
					+ repoPfmcConditionVO.getFToWk() + "#"
					+ repoPfmcConditionVO.getFWkFlg();

			su.directExecuteJob("ESM_MAS_B011", params);

		} catch (IOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12213",
					new String[] { "P/L Adjustment Creation" }).getMessage(), e);
		} catch (InterruptedException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12213",
					new String[] { "P/L Adjustment Creation" }).getMessage(), e);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12213",
					new String[] { "P/L Adjustment Creation" }).getMessage(), e);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12213",
					new String[] { "P/L Adjustment Creation" }).getMessage(), e);
		}
		return "4";// 실행 성공
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_MAS_0153 MTY Rtn YD로 RHQ 구하기<br>
	 * @param String rtn_yd
	 * @return String
	 * @exception EventException
	 */
//	public String searchYdToRhq(String rtn_yd) throws EventException {
	public List<SearchCondition0153VO> searchYdToRhq(SearchCondition0153VO searchCondition0153VO) throws EventException {
		try {
			return dbDao.searchYdToRhq(searchCondition0153VO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
}
