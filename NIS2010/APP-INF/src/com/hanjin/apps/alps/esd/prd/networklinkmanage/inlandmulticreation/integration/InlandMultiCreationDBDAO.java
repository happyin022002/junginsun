/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : InlandRouteManageDBDAO.java
 *@FileTitle : Inland Route 정보관리화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-02-10
 *@LastModifier : noh seung bae
 *@LastVersion : 1.0
 * 2010-02-10 noh seung bae
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandmulticreation.integration;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandmulticreation.vo.SearchInlandRouteVO;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * alps-PRD에 대한 DB 처리를 담당<br>
 * - alps-PRD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author noh seung bae
 * @see InlandMultiCreationBCImpl 참조
 * @since J2EE 1.5
 */
public class InlandMultiCreationDBDAO extends DBDAOSupport{

	/**
	 *
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List searchInlandMultiList(SearchInlandRouteVO vo) throws DAOException{
//		DBRowSet dbRowset = null;
		List<SearchInlandRouteVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("org_node", vo.getOrgNode());
			param.put("dest_node", vo.getDestNode());
			param.put("io_type", vo.getIoType());
			param.put("node_type", vo.getNodeType());

			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new InlandMultiCreationDBDAOSearchInlandRouteRSQL(), param, null, SearchInlandRouteVO.class);

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
	 *
	 * @return
	 * @throws DAOException
	 */
	public String searchRouteSeq() throws DAOException{
		DBRowSet dbRowset = null;
		String result = "";

		try{

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandMultiCreationDBDAOSearchRouteSeqRSQL(), null, null);

			if(dbRowset.next()){
				result = dbRowset.getString("route_seq");
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
	 *
	 * @param route_org_node
	 * @param route_dest_node
	 * @param route_seq
	 * @param prio_seq
	 * @param inlnd_rout_inv_bil_patt_cd
	 * @param rout_pln_cd
	 * @param wrs_full_cmdt
	 * @param wrs_mty_cmdt_cd
	 * @param inlnd_rout_bkg_flg
	 * @param pctl_io_bnd_cd
	 * @param inlnd_rout_tmp_flg
	 * @param inlnd_rout_rmk
	 * @param hub_loc_cd
	 * @param user_id
	 * @return
	 * @throws DAOException
	 */
	public int insertRouteMaster(String route_org_node, String route_dest_node, String route_seq, String prio_seq, String inlnd_rout_inv_bil_patt_cd, String rout_pln_cd, String wrs_full_cmdt, String wrs_mty_cmdt_cd, String inlnd_rout_bkg_flg, String pctl_io_bnd_cd, String inlnd_rout_tmp_flg, String inlnd_rout_rmk, String hub_loc_cd, String user_id) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		int resultCount = 0;

		param.put("route_org_node", route_org_node);
		param.put("route_dest_node", route_dest_node);
		param.put("route_seq", route_seq);
		param.put("prio_seq", prio_seq);
		param.put("inlnd_rout_inv_bil_patt_cd", inlnd_rout_inv_bil_patt_cd);
		param.put("rout_pln_cd", rout_pln_cd);
		param.put("wrs_full_cmdt", wrs_full_cmdt.equals("1") ? "Y" : "N");
		param.put("wrs_mty_cmdt_cd", wrs_mty_cmdt_cd);
		param.put("inlnd_rout_bkg_flg", inlnd_rout_bkg_flg.equals("1") ? "Y" : "N");
		param.put("pctl_io_bnd_cd", pctl_io_bnd_cd);
		param.put("inlnd_rout_tmp_flg", inlnd_rout_tmp_flg.equals("1") ? "Y" : "N");
		param.put("inlnd_rout_rmk", inlnd_rout_rmk);
		param.put("hub_loc_cd", hub_loc_cd);
		param.put("user_id", user_id);
		log.debug("noh Master param = \n" + param);

		try{
			resultCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new InlandMultiCreationDBDAOInsertRouteMasterCSQL(), param, null);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultCount;

	}

	/**
	 *
	 * @param route_org_node
	 * @param route_dest_node
	 * @param route_seq
	 * @param org_node
	 * @param dest_node
	 * @param dtl_seq
	 * @param tm
	 * @param vndr
	 * @param com_flg
	 * @param junc_nm
	 * @param rd_crr_tp
	 * @param agmt_no
	 * @param user_id
	 * @return
	 * @throws DAOException
	 */
	public int insertRouteDetail(String route_org_node, String route_dest_node, String route_seq, String org_node, String dest_node, String dtl_seq, String tm, String vndr, String com_flg, String junc_nm, String rd_crr_tp, String agmt_no, String user_id) throws DAOException{

		Map<String, Object> param = new HashMap<String, Object>();
		int resultCount = 0;

		param.put("route_org_node", route_org_node);
		param.put("route_dest_node", route_dest_node);
		param.put("route_seq", route_seq);
		param.put("org_node", org_node);
		param.put("dest_node", dest_node);
		param.put("dtl_seq", dtl_seq);
		param.put("tm", tm);
		param.put("vndr", vndr);
		param.put("com_flg", com_flg.equals("1") ? "Y" : "N");
		param.put("junc_nm", junc_nm);
		param.put("rd_crr_tp", rd_crr_tp);
		param.put("agmt_no", agmt_no);
		param.put("user_id", user_id);
		log.debug("noh Detail param = \n" + param);

		try{
			resultCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new InlandMultiCreationDBDAOInsertRouteDetailCSQL(), param, null);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultCount;

	}

	/**
	 *
	 * @param orgNode
	 * @param destNode
	 * @param tm
	 * @param vndrSeq
	 * @param tztm
	 * @param rmk
	 * @param userId
	 * @return
	 * @throws DAOException
	 */
	public int insertEachLink(String orgNode, String destNode, String tm, String vndrSeq, String tztm, String rmk, String userId) throws DAOException{
//		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		int resultCount = 0;

		param.put("org_node", orgNode);
		param.put("dest_node", destNode);
		param.put("tm", tm);
		param.put("vndr_seq", vndrSeq);
		param.put("tztm", tztm);
		param.put("rmk", rmk);
		param.put("user_id", userId);
		log.debug("noh EachLink param = \n" + param);

		try{
			resultCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new InlandMultiCreationDBDAOInsertEachLinkCSQL(), param, null);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultCount;

	}

	/**
	 *
	 * @param orgNode
	 * @param destNode
	 * @param routeSeq
	 * @return
	 * @throws DAOException
	 */
	public int updateInlandMulti(String orgNode, String destNode, String routeSeq) throws DAOException{
//		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		int resultCount = 0;

		param.put("org_node", orgNode);
		param.put("dest_node", destNode);
		param.put("route_seq", routeSeq);

		try{
			resultCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new InlandMultiCreationDBDAOUpdateInlandRouteUSQL(), param, null);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultCount;
	}
}
