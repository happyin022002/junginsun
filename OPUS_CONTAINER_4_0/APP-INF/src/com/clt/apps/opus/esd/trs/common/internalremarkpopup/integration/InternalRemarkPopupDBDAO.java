/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : InternalRemarkPopupDBDAO.java
 *@FileTitle : Internal Remark 조회(공통 Popup)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015-05-07
 *@LastModifier : ChanWooPark
 *@LastVersion : 1.0
 * 2015-05-07 ChanWooPark
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.common.internalremarkpopup.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.trs.common.internalremarkpopup.event.EsdTrs0982Event;
import com.clt.apps.opus.esd.trs.common.internalremarkpopup.vo.InternalRemarkVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.utility.CheckUtilities;

/**
 * Internal Remark에 대한 DB 처리를 담당<br>
 * 
 * @author ChanWooPark
 * @see InternalRemarkPopupBCImpl 참조
 * @since J2EE 1.6
 */
public class InternalRemarkPopupDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 5472237710054750044L;

	/**
	 * TRS Internal Remark의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return List<InternalRemarkVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<InternalRemarkVO> searchInternalRemarkList(EsdTrs0982Event event) throws DAOException {
		List<InternalRemarkVO> list = null;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no", event.getBkg_no()); // Booking No.
			param.put("eq_no", event.getEq_no()); // Equipment No.
			param.put("so_no", event.getSo_no()); // S/O No.
			DBRowSet dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate) new InternalRemarkPopupDBDAOInternalRemarkVORSQL(), param, param);
			list = (List) RowSetUtil.rowSetToVOs(dbRowSet, InternalRemarkVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return list;
	}

	/**
	 * 신규 Internal Remark를 생성한다.
	 * 
	 * @param internalRemarkVO
	 * @param ofcCd : Office의 local time을 적용하기 위한 param
	 * @throws DAOException
	 */
	public void addInternalRemarkList(InternalRemarkVO internalRemarkVO, String ofcCd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (internalRemarkVO != null) {
				Map<String, String> mapVO = internalRemarkVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("ofc_cd", ofcCd);
				String interRmk = internalRemarkVO.getInterRmk();
				if (!CheckUtilities.isInBlank(interRmk)) {
					interRmk = JSPUtil.replaceForHTML(interRmk);
					int interRmkLength = interRmk.getBytes("utf-8").length;
					param.put("inter_rmk", new String(interRmk.getBytes("utf-8"), 0, interRmkLength > 3900 ? 3900 : interRmkLength, "utf-8"));
				}
				int updCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new InternalRemarkPopupDBDAOInternalRemarkVOCSQL(), param, velParam);
				if (updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException(new ErrorHandler("COM12240").getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 해당하는 TRS Internal Remark를 업데이트한다.<br>
	 * 
	 * @param internalRemarkVO
	 * @param status
	 * @param ofcCd : Office의 local time을 적용하기 위한 param
	 * @throws DAOException
	 */
	public void manageInternalRemarkList(InternalRemarkVO internalRemarkVO, String status, String ofcCd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (internalRemarkVO != null) {
				Map<String, String> mapVO = internalRemarkVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("status", status);
				param.put("ofc_cd", ofcCd);
				String interRmk = internalRemarkVO.getInterRmk();
				if (!CheckUtilities.isInBlank(interRmk)) {
					interRmk = JSPUtil.replaceForHTML(interRmk);
					int interRmkLength = interRmk.getBytes("utf-8").length;
					param.put("inter_rmk", new String(interRmk.getBytes("utf-8"), 0, interRmkLength > 3900 ? 3900 : interRmkLength, "utf-8"));
				}
				int updCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new InternalRemarkPopupDBDAOInternalRemarkVOUSQL(), param, velParam);
				if (updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException(new ErrorHandler("COM12240").getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * S/O No., W/O No.에 해당하는 TRS Internal Remark를 업데이트한다.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void manageInternalRemarkListbySoWo(EsdTrs0982Event event) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("so_no", event.getSo_no()); // S/O No.
			param.put("wo_no", event.getWo_no()); // W/O No.
			param.put("usr_ofc_cd", event.getOfc_cd());
			new SQLExecuter("").executeUpdate((ISQLTemplate) new InternalRemarkPopupDBDAOUpdateInternalRemarkVObySoWoUSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}
}
