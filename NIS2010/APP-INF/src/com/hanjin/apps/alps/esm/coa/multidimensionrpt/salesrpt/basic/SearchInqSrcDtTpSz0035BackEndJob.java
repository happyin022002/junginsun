/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SearchInqSrcDtTpsz0035BackEndJob.java
 *@FileTitle : SearchInqSrcDtTpsz0035BackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.07.12
 *@LastModifier : 김상수
 *@LastVersion : 1.0
 * 2011.07.12 김상수
 * 1.0 Creation
 *===========================================================
 * History :
 * 2011.07.26 김상수 [CHM-201112106-01] Retrieve, File Download 기능을 Back end job 으로 기능 수정
 * 2011.08.10 김상수 [소스품질관리] searchInqSrcDtTpSz0035List 메소드 주석 수정
 * 2012.07.19 전윤주 [CHM-201219149] OPMS에 위배된 method name 변경 (searchResultBC-> searchResult) 
 *=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.integration.SalesRPTDBDAO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SalesOffiRepoConditionVO;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author KIM Sang-Soo
 * @see ESM_COAG_0035 EventResponse, SearchInqSrcDtTpsz0035BackEndJob 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SearchInqSrcDtTpSz0035BackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318313L;

	@SuppressWarnings("unused")
	private SignOnUserAccount account;
	private SalesOffiRepoConditionVO salesOffiRepoConditionVO;

	// Database Access Object
	private SalesRPTDBDAO dbDao = new SalesRPTDBDAO();

	/**
	 * 다운로드 할 데이터 세팅
	 *
	 * @param SalesOffiRepoConditionVO ediErrVO
	 * @param account
	 */
	public void setSalesOffiRepoConditionVO(SalesOffiRepoConditionVO salesOffiRepoConditionVO, SignOnUserAccount account) {
		this.account = account;
		this.salesOffiRepoConditionVO = salesOffiRepoConditionVO;
	}

	/**
	 * BackEndJob Start
	 * @return List<SalesOffiRepoConditionVO>
	 * @throws Exception
	 */
	public List<Object> doStart() throws Exception {
		List<Object> list = null;
		try {
			list = searchInqSrcDtTpSz0035List(this.salesOffiRepoConditionVO);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler(e).getMessage());
		}
		return list;
	}

	/**
	 * ESM_COA_035 : 조회 이벤트 처리<br>
	 * Inquiry By Source Data : Type Size 화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param SalesOffiRepoConditionVO salesOffiRepoConditionVO
	 * @return List<Object>
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Object> searchInqSrcDtTpSz0035List(SalesOffiRepoConditionVO salesOffiRepoConditionVO) throws EventException {
		DBRowSet rowSetHD = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet = null;
		List<Object> sList = new ArrayList();
		String[] sTitle = null; // 엑셀의 컬럼헤더
		String[] sColum = null; //컬럼헤더와 매핑되는 DB 컬럼명
		int colCnt = 0;
		List<String> cols  = new ArrayList();

		try {
			rowSetHD = dbDao.searchCntrTpSzList(salesOffiRepoConditionVO);
			if (rowSetHD != null) {
				while (rowSetHD.next()) {
					cols.add(rowSetHD.getString("spcl_cntr_tpsz_cd"));
				}
			}

			rowSet = dbDao.searchInqSrcDtTpsz0035List(salesOffiRepoConditionVO, cols);
			sList.add( rowSet );

			//엑셀다운 로드시 헤더 세팅..
			if("Y".equals(salesOffiRepoConditionVO.getFExcel())){
				rowSet.next();
				colCnt = rowSet.getMetaData().getColumnCount();
				sTitle = new String[colCnt];
				sColum = new String[colCnt];

				for(int k=1; k<=rowSet.getMetaData().getColumnCount(); k++){
					sTitle[k-1] = JSPUtil.getNull(rowSet.getString(k));
					sColum[k-1] = rowSet.getMetaData().getColumnLabel(k);
				}
				sList.add( sTitle );
				sList.add( sColum );
			}
			return sList;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BackEndJob 결과 Return<br>
	 *
	 * @param String key
	 * @return List<DBRowSet>
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	public List<DBRowSet> searchResult(String key) throws Exception {
		BackEndJobResult backEndJobResult = new BackEndJobResult();
		List<DBRowSet> rowSets = new ArrayList<DBRowSet>();
		try {
			rowSets.add((DBRowSet)backEndJobResult.loadFromFile(key));
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler(e).getMessage());
		}
		return rowSets;
	}

}