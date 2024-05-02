/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MenuDBDAO.java
*@FileTitle : 硫붾돱愿�由�
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-22
*@LastModifier : SeongWook Kim
*@LastVersion : 1.0
* 2006-08-11 SeongWook Kim
* 1.0 理쒖큹 �깮�꽦
=========================================================*/
package com.hanjin.syscommon.common.menu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration.GeneralBookingReceiptDBDAOSearchPoNoByCntrRSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.menu.MenuBean;
import com.hanjin.syscommon.management.alps.bookmark.integration.BookmarkManagementDAOcomBookmarkRSQL;
import com.hanjin.syscommon.management.alps.bookmark.vo.BookmarkListVO;


/**
 * 클래스 개요    : menu관련 DAO <BR>
 * @author SeongWook Kim
 * @see 
 * @since J2EE 1.4
 */
public class MenuDBDAO extends DBDAOSupport {

    /**
     * 해당 메뉴 리스트를 조회한다.
     * @param topPosition  지점, 영업점 구분
     * @param requestURI   업무구분
     * @return Collection 메뉴 리스트
     * @exception DAOException
     */
    public Collection getMenuList(String topPosition, String requestURI) throws
        DAOException {
        ArrayList menuList = new ArrayList();
        Connection con = null;
        DBRowSet dRs = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query =
            "      SELECT                                                                           "
            + "\n         m.lvl-1                                     as   menu_level,              "
            + "\n         NVL(REPLACE(p.\"PgmNo\", '.', '_'), ' ')    as   prog_id   ,              "
            + "\n         NVL(p.\"PgmNm\", ' ')                       as   prog_name ,              "
            + "\n         NVL(p.\"PgmLinkNm\", ' ')                   as   prog_link ,              "
            + "\n         DECODE(m.lvl-1, 2, REPLACE(m.\"UpPgmNo\", '.', '_'), ' ') as menu_parent, "
            + "\n         m.\"UpPgmNo\"                               as   prog_parent_id ,         "
            + "\n         m.\"EpsSeq\"                                as   menu_display_order ,     "
            + "\n         m.lvl                                       as   lvl       ,              "
            + "\n         p.\"PupYn\"                                 as   popup_yn                 "
            + "\n    FROM                                                                           "
            + "\n        ( SELECT \"LwrkPgmNo\",                                                    "
            + "\n                 \"UpPgmNo\",                                                      "
            + "\n                 \"EpsSeq\",                                                       "
            + "\n                 \"PgmLvl\",                                                       "
            + "\n                 level lvl                                                         "
            + "\n            FROM TSROISC06                                                         "
            //+ "\n           --WHERE \"MnuCcd\" = '001'  //center                                       "
            + "\n           START WITH \"LwrkPgmNo\" = ?                                            " //'PG10000'
            + "\n           CONNECT BY PRIOR \"LwrkPgmNo\" = \"UpPgmNo\"                            "
            + "\n        ) m, TSROISC05 p                                                           "
            + "\n  WHERE m.\"LwrkPgmNo\" = p.\"PgmNo\"                                              "
            + "\n  AND   p.\"PgmStsCcd\" = '002'                                                    "
            + "\n  AND   p.\"UsgYn\" = '1'                                                    "
            + "\n  ORDER BY m.lvl, m.\"EpsSeq\"                                                     ";


        log.debug(query);
        log.debug("topPosition" + ":" + topPosition);
        log.debug("requestURI" + ":" + requestURI);

        try {
            //topPosition = "center";
            //requestURI = "RL.NEWLOAN.LOANLIST";

            con = getConnection("SynapseDB");
            ps = con.prepareStatement(query);
            ps.setString(1, requestURI);
            rs = ps.executeQuery();
            dRs = new DBRowSet();
            dRs.populate(rs);
            
            int i = 0;
            while (dRs.next()) {
                i++;
                if (i > 1) {
                    //out.println( dRs.getString(1).trim()+":"+ dRs.getString(2).trim()+":"+ dRs.getString(3).trim()+":"+ dRs.getString(4).trim()+":"+ dRs.getString(5));
                    menuList.add(new MenuBean(dRs.getString("menu_level").trim(),
                                              dRs.getString("prog_id").trim(),
                                              dRs.getString("prog_name").trim(),
                                              dRs.getString("prog_link").trim(),
                                              dRs.getString("menu_parent").trim(),
                                              dRs.getString("popup_yn").trim()));
                }
            }
            return menuList;
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
            closeConnection(con);
        }
    }

    /**
     * 권한에 의한 메뉴 조회
     * @param systemId   시스템ID
     * @param programId  프로그램ID
     * @param userId      사용자 ID
     * @return Collection 메뉴 리스트
     * @throws DAOException
     */
    public Collection getMenuListWithAuth(String systemId, String programId, String userId, String ofcCd) throws
        DAOException {
    	return getMenuListWithAuth(systemId, programId, userId, ofcCd, 7);
    }

    /**
     * 권한에 의한 메뉴 조회
     * 시스템별,사용자별 특정메뉴 이하의 메뉴리스트를 특정레벨까지 조회
     * @param systemId   시스템ID
     * @param programId  프로그램ID
     * @param userId     사용자 ID
     * @param depth      레벨(시스템ID의 레벨을 기준으로)
     * @return Collection 메뉴 리스트
     * @throws DAOException
     */
    public Collection getMenuListWithAuth(String systemId, String programId, String userId, String ofcCd, int depth) throws
        DAOException {
		// PDTO(Data Transfer Object including Parameters)
		String mnu_cfg_cd = SiteConfigFactory.get("COM.HANJIN.MENU.CONFIG.CODE");
		if(systemId.length()==3){
			mnu_cfg_cd = systemId;
		}
		String top_pgm_no = programId;
		
        ArrayList menuList = new ArrayList();
        Connection con = null;
        DBRowSet dRs = null;
        PreparedStatement ps = null;
        ResultSet rs = null;


        log.info("MenuDBDAO : 1:MNU_CFG_CD : "+mnu_cfg_cd);
        log.info("MenuDBDAO : 2:USR_ID : "+userId);
        log.info("MenuDBDAO : 3:PRNT_PGM_NO : "+top_pgm_no);
        log.info("MenuDBDAO : 4:LEVEL : "+depth);
        try {
        	Map sqlData = new HashMap();
        	sqlData.put("usr_id", userId);
        	sqlData.put("ofc_cd", ofcCd);
        	sqlData.put("mnu_cfg_cd", mnu_cfg_cd);
        	sqlData.put("prnt_pgm_no", top_pgm_no);
        	sqlData.put("level", depth);
        	sqlData.put("roll_View", "Y");
        	dRs = new SQLExecuter("SynapseDB").executeQuery(new MenuDAO99RollViewRSQL(), sqlData,null);        
        	while (dRs.next()) {
        		sqlData.put("roll_View", dRs.getString("VIEW_FLG"));
        	}
        	
        	if(sqlData.get("roll_View").equals("N")){
        		dRs = new SQLExecuter("SynapseDB").executeQuery((ISQLTemplate)new MenuDAONoFULLMENURSQL(), sqlData, sqlData);
        	}else{
        		dRs = new SQLExecuter("SynapseDB").executeQuery((ISQLTemplate)new MenuDAOFULLMENURSQL(), sqlData, sqlData);
        	}
        	
            int i = 0;
            while (dRs.next()) {
                i++;
                if (i > 0) {
                    //out.println( rset.getString(1).trim()+":"+ rset.getString(2).trim()+":"+ rset.getString(3).trim()+":"+ rset.getString(4).trim()+":"+ rset.getString(5));
                    menuList.add(new MenuBean(dRs.getString("LVL").trim(),
                                              dRs.getString("CHD_PGM_NO").trim(),
                                              dRs.getString("PGM_NM").trim(),
                                              dRs.getString("PGM_URL").trim(),
                                              dRs.getString("PRNT_PGM_NO").trim(),
                                              dRs.getString("POPUP_FLG").trim(),
                                              dRs.getString("DP_SEQ").trim(),
                                              dRs.getString("CHILD_CNT").trim(),
                                              dRs.getString("CHILD_MAX_LEN").trim(),
                                              dRs.getString("AUTH_YN").trim()));
                }
            }
            log.info("MenuDBDAO : RESULT COUNT : "+i);
            return menuList;
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
            closeConnection(con);
        }
    }

    /**
     * 권한에 의한 좌측메뉴 조회
     * 시스템별,사용자별 특정메뉴 이하의 메뉴리스트를 특정레벨까지 조회
     * @param systemId   시스템ID
     * @param programId  프로그램ID
     * @param userId     사용자 ID
     * @param depth      레벨(시스템ID의 레벨을 기준으로)
     * @return Collection 메뉴 리스트
     * @throws DAOException
     */
    public Collection getLeftMenuListWithAuth(String systemId, String programId, String userId, int depth) throws
        DAOException {
		// PDTO(Data Transfer Object including Parameters)
		String mnu_cfg_cd = "001";
		if(systemId.length()==3){
			mnu_cfg_cd = systemId;
		}
		String top_pgm_no = programId;
		
        ArrayList menuList = new ArrayList();
        Connection con = null;
        DBRowSet dRs = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

		String queryStr = " /* 등록된 메뉴 목록 */ 						  " + "\n"
		+ "SELECT LEVEL,                       \n"
		+ "       CHD_PGM_NO,                  \n"
		+ "       PGM_NM,                      \n"
		+ "       DP_SEQ,                      \n"
		+ "       PRNT_PGM_NO,                 \n"
		+ "       PGM_URL,                     \n"
		+ "       POPUP_FLG                    \n"
		+ "FROM (SELECT A.MNU_CFG_CD,A.PRNT_PGM_NO,A.CHD_PGM_NO,A.PGM_LVL_VAL,A.DP_SEQ                            \n"
		+ "      ,B.PGM_NO,B.PGM_NM,B.PGM_URL,B.PGM_LVL_DIV_CD,B.POPUP_FLG                                       \n"
		+ "      FROM COM_MNU_CFG A, COM_PROGRAM B, COM_PGM_ROLE C, COM_USR_ROLE D, COM_USR_ROLE_MTCH E           \n"
		+ "      WHERE A.MNU_CFG_CD = ?                                                                           \n"
		+ "      AND A.CHD_PGM_NO = B.PGM_NO                                                                   \n"
		+ "      AND B.PGM_TP_CD = '00'                                                                        \n"
		+ "      AND NVL(B.USE_FLG,'N') = 'Y'                                                                           \n"
		+ "      AND NVL(B.POPUP_FLG,'N') != 'Y'                                                                      \n"
		+ "      AND B.PGM_NO = C.PGM_NO                                                                      \n"
		+ "      AND C.USR_ROLE_CD = D.USR_ROLE_CD                                                                      \n"
		+ "      AND D.USR_ROLE_CD = E.USR_ROLE_CD                                                                      \n"
		+ "      AND E.USR_ID = ?)                                                                      \n"
		+ "START WITH CHD_PGM_NO = ?                                                                             \n"
		+ "CONNECT BY PRIOR CHD_PGM_NO = PRNT_PGM_NO                                                              \n"
        + "AND LEVEL <= ?                                                                                         \n"
		+ "ORDER SIBLINGS BY DP_SEQ                                                                               \n";
		
        log.info("MenuDBDAO : "+queryStr);
        log.info("MenuDBDAO : MNU_CFG_CD : "+mnu_cfg_cd);
        log.info("MenuDBDAO : USR_ID : "+userId);
        log.info("MenuDBDAO : PRNT_PGM_NO : "+top_pgm_no);
        log.info("MenuDBDAO : LEVEL : "+depth);
        try {
            con = getConnection("SynapseDB");
            ps = con.prepareStatement(queryStr);
            
			ps.setString(1, mnu_cfg_cd);
			ps.setString(2, userId);
			ps.setString(3, top_pgm_no);
            ps.setInt(4, depth);
            
            rs = ps.executeQuery();

            dRs = new DBRowSet();
            dRs.populate(rs);
            
            int i = 0;
            while (dRs.next()) {
                i++;
                if (i > 0) {
                    menuList.add(new MenuBean(dRs.getString("LEVEL").trim(),
                                              dRs.getString("CHD_PGM_NO").trim(),
                                              dRs.getString("PGM_NM").trim(),
                                              dRs.getString("PGM_URL").trim(),
                                              dRs.getString("PRNT_PGM_NO").trim(),
                                              dRs.getString("POPUP_FLG").trim(),
                                              dRs.getString("DP_SEQ").trim()));
                }
            }
            log.info("MenuDBDAO : RESULT COUNT : "+i);
            return menuList;
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
            closeConnection(con);
        }
    }

	/**
	 * 화면의 타이틀과 네비게이션을 조회<br>
	 * 화면에 출력할 타이틀과 네비게이션 정보를 해당 URL로 검색<br>
	 * 
	 * @param pgmNo 사용자 요청한 URL
	 * @return Collection 메뉴 리스트
	 * @throws DAOException
	 */
	public String[] getUiInfo(String pgmNo)	throws DAOException {
		DBRowSet dbRowset = null;
		String[] menuInfo = new String[4];
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("pgm_no", pgmNo);
		param.put("rootPgmCd", SiteConfigFactory.get("COM.HANJIN.MENU.ROOT.PROGRAM.CODE"));
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MenuDBDAOUiTitleRSQL(), param, param);
			if (dbRowset.next()) {
				menuInfo[0] = dbRowset.getString("UI_TITLE") == null ? "" : dbRowset.getString("UI_TITLE").trim();
				menuInfo[1] = dbRowset.getString("UI_DESCRIPTION") == null ? "" : dbRowset.getString("UI_DESCRIPTION").trim();
				menuInfo[2] = dbRowset.getString("UI_NAVIGATION") == null ? "" : dbRowset.getString("UI_NAVIGATION").trim();
				menuInfo[3] = dbRowset.getString("UI_URL") == null ? "" : dbRowset.getString("UI_URL").trim();
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return menuInfo;
	}
	
	
	/**
	 * 화면의 타이틀과 네비게이션을 조회<br>
	 * 화면에 출력할 타이틀과 네비게이션 정보를 해당 URL로 검색<br>
	 * 네이게이션 child 정보가 두개가 있으면 첫번재 정보만 display 되서 sql 수정 해당 param 값 추가 parentsId 추가됨<br>
	 * @param pgmNo 사용자 요청한 URL
	 * @param parentsId 요청 메뉴의 부모 메뉴 번호
	 * @return Collection 메뉴 리스트
	 * @throws DAOException
	 */
	public String[] getUiInfo(String pgmNo, String parentsId)	throws DAOException {
		DBRowSet dbRowset = null;
		String[] menuInfo = new String[4];
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("pgm_no", pgmNo);
		if(parentsId != null && parentsId.trim().length() > 0){
			param.put("pid", parentsId);
		}
		param.put("rootPgmCd", SiteConfigFactory.get("COM.HANJIN.MENU.ROOT.PROGRAM.CODE"));
//		parentsId = (parentsId != null)?parentsId:"";
		try{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MenuDBDAOUiTitleRSQL(), param, param);
			if (dbRowset.next()) {
				menuInfo[0] = dbRowset.getString("UI_TITLE") == null ? "" : dbRowset.getString("UI_TITLE").trim();
				menuInfo[1] = dbRowset.getString("UI_DESCRIPTION") == null ? "" : dbRowset.getString("UI_DESCRIPTION").trim();
				menuInfo[2] = dbRowset.getString("UI_NAVIGATION") == null ? "" : dbRowset.getString("UI_NAVIGATION").trim();
				menuInfo[3] = dbRowset.getString("UI_URL") == null ? "" : dbRowset.getString("UI_URL").trim();
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return menuInfo;
	}
	
	
	
	
	
	/**
	 * 형제 모듈을 조회<br>
	 * 
	 * @param pgmNo 프로그램 번호
	 * @return Collection 메뉴 리스트
	 * @throws DAOException
	 */
	public ArrayList<MenuBean> getSiblingMenu(String pgmNo)	throws DAOException {
	
		DBRowSet dRs = null;
		ArrayList<MenuBean> menuList = new ArrayList<MenuBean>();
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("pgm_no", pgmNo);
		try {
			dRs = new SQLExecuter("").executeQuery(new MenuDAOgetSiblingRSQL(), param, null);
            int i = 0;
            while (dRs.next()) {
                i++;
                if (i > 0) {
                    menuList.add(new MenuBean("2",
                                              dRs.getString("CHD_PGM_NO").trim(),
                                              dRs.getString("PGM_NM").trim(),
                                              dRs.getString("PGM_URL").trim(),
                                              dRs.getString("PRNT_PGM_NO").trim(),
                                              dRs.getString("POPUP_FLG").trim(),
                                              dRs.getString("DP_SEQ").trim(),
                                              "0",
                                              "0",
                                              dRs.getString("AUTH_YN").trim()));
                }
            }
            return menuList;
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
	
	/**
	 * 
	 * @param usrId
	 * @return
	 * @throws DAOException
	 */
	public String getComRollMenuFlg(String usrId) throws DAOException {
		DBRowSet dRs = null;
		try{
 
			Map<String,Object> param = new HashMap<String, Object>();
			param.put("usr_id", usrId);
			
			dRs = new SQLExecuter("").executeQuery(new MenuDAO99RollViewRSQL(), param, null);
			 while (dRs.next()) {
				 return dRs.getString("VIEW_FLG");
			 }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return null;
	}
}

