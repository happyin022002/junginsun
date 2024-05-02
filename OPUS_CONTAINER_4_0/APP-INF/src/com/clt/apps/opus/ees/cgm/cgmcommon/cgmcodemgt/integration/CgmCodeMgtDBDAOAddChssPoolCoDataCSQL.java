/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : CgmCodeMgtDBDAORemoveChssPoolCoDataDSQL.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.10
 *@LastModifier :
 *@LastVersion : 1.0
 * 2012.04.10
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 * 
 * @author 
 * @see DAO
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOAddChssPoolCoDataCSQL implements ISQLTemplate {

	private StringBuffer query = new StringBuffer();

	Logger log = Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String, String[]> params = null;

	/**
	 * <pre>
	 * CGM_CHSS_POOL 등록
	 * </pre>
	 */
	public CgmCodeMgtDBDAOAddChssPoolCoDataCSQL() {
		setQuery();
		params = new HashMap<String, String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if (arrTmp.length != 2) {
			throw new IllegalArgumentException();
		}
		params.put("pool_mgmt_co_cd", new String[] { arrTmp[0], arrTmp[1] });

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if (arrTmp.length != 2) {
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id", new String[] { arrTmp[0], arrTmp[1] });

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if (arrTmp.length != 2) {
			throw new IllegalArgumentException();
		}
		params.put("pool_mgmt_co_nm", new String[] { arrTmp[0], arrTmp[1] });

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if (arrTmp.length != 2) {
			throw new IllegalArgumentException();
		}
		params.put("chss_pool_nm", new String[] { arrTmp[0], arrTmp[1] });

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if (arrTmp.length != 2) {
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id", new String[] { arrTmp[0], arrTmp[1] });

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if (arrTmp.length != 2) {
			throw new IllegalArgumentException();
		}
		params.put("chss_pool_cd", new String[] { arrTmp[0], arrTmp[1] });

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration").append("\n");
		query.append("FileName : CgmCodeMgtDBDAOAddChssPoolCoDataCSQL").append("\n");
		query.append("*/").append("\n");
	}

	public String getSQL() {
		return query.toString();
	}

	public HashMap<String, String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery() {
		query.append("INSERT INTO CGM_CHSS_POOL").append("\n");
		query.append("  (CHSS_POOL_CD,").append("\n");
		query.append("   CHSS_POOL_NM,").append("\n");
		query.append("   POOL_MGMT_CO_CD,").append("\n");
		query.append("   POOL_MGMT_CO_NM,").append("\n");
		query.append("   CRE_USR_ID,").append("\n");
		query.append("   CRE_DT,").append("\n");
		query.append("   UPD_USR_ID,").append("\n");
		query.append("   UPD_DT)").append("\n");
		query.append("VALUES").append("\n");
		query.append("  (@[chss_pool_cd],").append("\n");
		query.append("   @[chss_pool_nm],").append("\n");
		query.append("   @[pool_mgmt_co_cd],").append("\n");
		query.append("   @[pool_mgmt_co_nm],").append("\n");
		query.append("   @[cre_usr_id],").append("\n");
		query.append("   SYSDATE,").append("\n");
		query.append("   @[upd_usr_id],").append("\n");
		query.append("   SYSDATE)").append("\n");

	}
}