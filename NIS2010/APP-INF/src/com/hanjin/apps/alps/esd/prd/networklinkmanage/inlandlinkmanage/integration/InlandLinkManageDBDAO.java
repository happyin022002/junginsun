/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : InlandLinkManageDBDAO.java
 *@FileTitle : Inland Link 정보관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-19
 *@LastModifier : jungsunyong
 *@LastVersion : 1.0
 * 2006-09-19 jungsunyong
 * 1.0 최초 생성
 * 2010.11.03 채창호  CHM-201006834-01: Inland Link Management와 Route Management의 연동 Logic 변경요청.(2010년 8월 3일 이전버젼으로 원복 조치) 
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.basic.InlandLinkManageBCImpl;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.event.EsdPrd0009Event;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.vo.PrdInlndEachLnkVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.vo.SearchInlandLinkManageListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PRD_INLND_EACH_LNK;

/**
 * alps-PRD에 대한 DB 처리를 담당<br>
 * - alps-PRD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author jungsunyong
 * @see InlandLinkManageBCImpl 참조
 * @since J2EE 1.4
 */
public class InlandLinkManageDBDAO extends DBDAOSupport{

	/**
	 * InlandLinkManage의 모든 목록을 가져온다.<br>
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List<SearchInlandLinkManageListVO> searchInlandLinkManageList(SearchInlandLinkManageListVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchInlandLinkManageListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){

				String ctyCd = "";
				String agmtSeq = "";
				int iAgmtSeq = 0;

				if(vo.getAgmtNo() != null && vo.getAgmtNo().length() >= 3){
					ctyCd = vo.getAgmtNo().substring(0, 3);
					agmtSeq = vo.getAgmtNo().substring(3);
					iAgmtSeq = Integer.parseInt(agmtSeq);
					agmtSeq = Integer.toString(iAgmtSeq); // 앞에 0을 없엔 다음 스트링으로
				}

				vo.setCtyCd(ctyCd);
				vo.setAgmtSeq(agmtSeq.equals("0") ? "" : agmtSeq);

				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandLinkManageDBDAOSearchInlandLinkManageListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchInlandLinkManageListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;


	}

	/**
	 * InlandLinkManage의 모든 목록을 가져온다.<br>
	 * ★2009-08-14 kimkwijin 생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List<PrdInlndEachLnkVO> searchInlandLinkManageList(PrdInlndEachLnkVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		List<PrdInlndEachLnkVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				String ctyCd = "";
				String agmtSeq = "";
				int iAgmtSeq = 0;

				if(vo.getIAgmtNo() != null && vo.getIAgmtNo().length() >= 3){
					ctyCd = vo.getIAgmtNo().substring(0, 3);
					agmtSeq = vo.getIAgmtNo().substring(3);
					iAgmtSeq = Integer.parseInt(agmtSeq);
					agmtSeq = Integer.toString(iAgmtSeq); // 앞에 0을 없엔 다음 스트링으로
				}
				vo.setAgmtSeq(agmtSeq);
				vo.setCtyCd(ctyCd);

				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandLinkManageDBDAOPrdInlndEachLnkRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PrdInlndEachLnkVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;


	}

	/**
	 * ★추가
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int mergeInlandLink(SearchInlandLinkManageListVO vo) throws DAOException, Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new InlandLinkManageDBDAOInlandLinkMergeUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
			}

			return result;
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * ★수정
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int updateInlandLink(SearchInlandLinkManageListVO vo) throws DAOException, Exception{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new InlandLinkManageDBDAOInlandLinkUpdateUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00065")).getMessage() );
			}

			return result;
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * ★삭제
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int deleteInlandLink(SearchInlandLinkManageListVO vo) throws DAOException, Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new InlandLinkManageDBDAOInlandLinkDeleteUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00065")).getMessage() );
			}

			return result;
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * InlandLinkManageDBDAO's deleteInlndRoutMst
	 * @param lnk_org_nod_cd
	 * @param lnk_dest_nod_cd
	 * @param trsp_mod_cd
	 * @param usrId
	 * @throws DAOException void
	 * ★ 2009-08-13 kim kwijin 수정
	 */
	public void deleteInlndRoutMst(String lnk_org_nod_cd, String lnk_dest_nod_cd, String trsp_mod_cd, String usrId) throws DAOException{

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try{
			Map<String, String> mapVO = new HashMap();

			mapVO.put("lnk_org_nod_cd", lnk_org_nod_cd);
			mapVO.put("lnk_dest_nod_cd", lnk_dest_nod_cd);
			mapVO.put("trsp_mod_cd", trsp_mod_cd);
			mapVO.put("usrId", usrId);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new InlandLinkManageDBDAOdeleteInlandRoutMstUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00065")).getMessage() );
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}


	}

	/**
	 * InlandLinkManageDBDAO's pseudoTypeFromToCheck<br/>
	 * ★ 2009-08-13 kim kwijin 수정
	 * @param fromCd
	 * @param toCd
	 * @return
	 * @throws DAOException
	 */
	public String pseudoTypeFromToCheck(String fromCd, String toCd) throws DAOException{

		DBRowSet dbRowset = null;
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			Map<String, String> mapVO = new HashMap();
			mapVO.put("fromCd", fromCd);
			mapVO.put("toCd", toCd);

			param.putAll(mapVO);

			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandLinkManageDBDAOPseudoTypeFormToCheckRSQL(), param, velParam);
			if(dbRowset.next()){
				retVal = dbRowset.getString("ret");
			}else{
				retVal = "9"; //from,to 가 없을때
			}


		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}

	/**
	 * InlandLinkManageDBDAO's validationVendor
	 * PrdCommonManageDBDAO 에 있는 공통 소스 사용 
	 * ★ 2009-08-13 kim kwijin 수정
	 * @param chkData
	 * @return
	 * @throws DAOException
	 */
	public boolean validationVendor(String chkData) throws DAOException{
		DBRowSet dbRowset = null;
		boolean retVal = false;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			Map<String, String> mapVO = new HashMap();
			mapVO.put("chkData", chkData);

			param.putAll(mapVO);

			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandLinkManageDBDAOValidationVendorRSQL(), param, velParam);
			if(dbRowset.next()){
				retVal = true;
			}


		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;


	}

	/**
	 * InlandLinkManageDBDAO's multiAgmtNo
	 * AGMT NO 를 업데이트 처리 
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 * ★2009-08-17 kimkwijin
	 */
	public int multiAgmtNo(PrdInlndEachLnkVO vo) throws DAOException, Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new InlandLinkManageDBDAOMultiAgmtNoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00065")).getMessage() );
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * InlandLinkManageDBDAO's updateInlandRouteAgmtNo
	 * link MGR 에서 agmt no 를 update할때 irg에서 해당 each link를 찾아 update 해준다.
	 * @param orgCd
	 * @param destCd
	 * @param trspMod
	 * @param vndrSeq
	 * @param ctyCd
	 * @param iAgmtSeq
	 * @throws DAOException void
	 * ★2009-08-17 kim kwijin수정
	 */
	public void updateInlandRouteAgmtNo(String orgCd, String destCd, String trspMod, String vndrSeq, String ctyCd, int iAgmtSeq) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			param.put("org_cd", orgCd);
			param.put("dest_cd", destCd);
			param.put("trsp_mod", trspMod);
			param.put("cty_cd", ctyCd);
			param.put("vndr_seq", vndrSeq);
			param.put("i_agmt_seq", iAgmtSeq + "");

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new InlandLinkManageDBDAOUpdateInlandRouteAgmtNoUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00065")).getMessage() );
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * InlandLinkManageDBDAO's isAgmtNoRight
	 * @param ctyCd
	 * @param agmtSeq
	 * @param vndSeq
	 * @return
	 * @throws DAOException boolean
	 * ★2009-08-17 kimkwijin 수정
	 */
	public boolean isAgmtNoRight(String ctyCd, int agmtSeq, String vndSeq) throws DAOException{
		DBRowSet dbRowset = null;
		boolean retVal = false;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("cty_cd", ctyCd);
			param.put("agmt_seq", agmtSeq);
			param.put("vnd_seq", vndSeq);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandLinkManageDBDAOIsAgmtNoRightRSQL(), param, null);

			if(dbRowset.getRowCount() == 0){
				retVal = false;
			}else{
				retVal = true;
			}

		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return retVal;


	}
}
