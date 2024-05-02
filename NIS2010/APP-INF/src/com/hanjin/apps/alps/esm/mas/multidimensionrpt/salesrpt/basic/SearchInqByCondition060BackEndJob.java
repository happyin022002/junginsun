/*=========================================================
 *Copyright(c) 2009 CyberLogitec 
 *@FileName : SearchInqByCondition060BackEndJob.java
 *@FileTitle : SearchInqByCondition060BackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.01.10
 *@LastModifier : 김수정
 *@LastVersion : 1.0
 * 2014.01.10 김수정
 * 1.0 Creation
 *=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration.SalesRPTDBDAO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.SalesOffiRepoConditionVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.SalesRPTCommonVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.SearchRptItemVO;
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
 * @author KIM SuJung
 * @see ESM_MASG_0060 EventResponse, searchInqByCondition060BackEndJob 각 DAO 클래스 참조 
 * @since J2EE 1.6
 */
public class SearchInqByCondition060BackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318313L;

	@SuppressWarnings("unused")
	private String userId;
	private SearchConditionVO searchConditionVO;
	private SalesRPTCommonVO salesRPTCommonVO;

	// Database Access Object
	private SalesRPTDBDAO dbDao = new SalesRPTDBDAO();

	/**
	 * 다운로드 할 데이터 세팅
	 *
	 * @param SearchConditionVO searchVo
	 * @param SalesRPTCommonVO vo
	 * @param String userId
	 */
	public void setSearchConditionVO(SearchConditionVO searchVo, SalesRPTCommonVO vo, String userId) {
		this.userId = userId;
		this.searchConditionVO = searchVo;
		this.salesRPTCommonVO = vo;
	}

	/**
	 * BackEndJob Start
	 * @return List<SalesRPTCommonVO>
	 * @throws Exception
	 */
	public List<Object> doStart() throws Exception {
		List<Object> list = null;
		try {
			list = searchInqByCondition060List(this.searchConditionVO, this.salesRPTCommonVO, this.userId);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler(e).getMessage());
		}
		return list;
	}

	/**
	 * ESM_MAS_0060 : Excel Down 이벤트 처리<br>
	 *
	 * @param SearchConditionVO searchVo
	 * @param SalesRPTCommonVO vo
	 * @param String userId
	 * @return List<Object>
	 * @exception EventException
	 */
	public List<Object> searchInqByCondition060List(SearchConditionVO searchVo, SalesRPTCommonVO vo, String userId) throws EventException {
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		SalesRPTCommonVO retVo = new SalesRPTCommonVO();
		List<Object> sList = new ArrayList();

		try {
			retVo = dbDao.searchInqByCondition060List(vo);
			rowSet = retVo.getRowSet();
			sList.add(rowSet);

			return sList;
		} catch(DAOException ex) {
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