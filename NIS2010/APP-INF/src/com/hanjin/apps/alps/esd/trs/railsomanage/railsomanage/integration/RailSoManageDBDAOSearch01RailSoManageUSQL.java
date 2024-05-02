/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RailSoManageDBDAOSearch01RailSoManageUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.06
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.01.06 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOSearch01RailSoManageUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US Rail I/B SO 대상 수정 SQL
	  * </pre>
	  */
	public RailSoManageDBDAOSearch01RailSoManageUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_rail_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOSearch01RailSoManageUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("UPDATE TRS_TRSP_RAIL_BIL_ORD_TMP X" ).append("\n"); 
		query.append("SET (X.CUST_CNT_CD, X.CUST_SEQ, X.SHPR_CUST_NM) =" ).append("\n"); 
		query.append("(SELECT MAX(U.CUST_CNT_CD)," ).append("\n"); 
		query.append("MAX(U.CUST_SEQ)," ).append("\n"); 
		query.append("MIN(REPLACE(NVL(U.CUST_NM, ' '),CHR(13)||CHR(10),' '))" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_CUSTOMER U" ).append("\n"); 
		query.append("WHERE U.BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("AND   U.BKG_CUST_TP_CD = 'S')" ).append("\n"); 
		query.append(",(X.CNEE_CUST_NM) =" ).append("\n"); 
		query.append("(SELECT MIN(REPLACE(NVL(U.CUST_NM, ' '),CHR(13)||CHR(10),' '))" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_CUSTOMER U" ).append("\n"); 
		query.append("WHERE U.BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("AND   U.BKG_CUST_TP_CD = 'C')" ).append("\n"); 
		query.append(",(X.NTFY_CUST_NM) =" ).append("\n"); 
		query.append("(SELECT MIN(REPLACE(NVL(U.CUST_NM, ' '),CHR(13)||CHR(10),' '))" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_CUSTOMER U" ).append("\n"); 
		query.append("WHERE U.BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("AND   U.BKG_CUST_TP_CD = 'N')" ).append("\n"); 
		query.append("WHERE X.TRSP_RAIL_TMP_SEQ = @[trsp_rail_tmp_seq]" ).append("\n"); 

	}
}