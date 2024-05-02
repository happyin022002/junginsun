/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RailSoManageDBDAOSearch06RailSoManageUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.22
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2015.07.22 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOSearch06RailSoManageUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US Rail O/B SO 대상 수정 SQL
	  * </pre>
	  */
	public RailSoManageDBDAOSearch06RailSoManageUSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOSearch06RailSoManageUSQL").append("\n"); 
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
		query.append("	SET (X.CUST_CNT_CD, X.CUST_SEQ, X.SHPR_CUST_NM) = " ).append("\n"); 
		query.append("                   (SELECT MAX(U.CUST_CNT_CD)," ).append("\n"); 
		query.append("                           MAX(U.CUST_SEQ)," ).append("\n"); 
		query.append("                           MIN(REPLACE(REPLACE(U.CUST_NM, CHR (13),' '), CHR (10), ' '))" ).append("\n"); 
		query.append("                    FROM" ).append("\n"); 
		query.append("			BKG_CUSTOMER U" ).append("\n"); 
		query.append("                    WHERE U.BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("                    AND   U.BKG_CUST_TP_CD = 'S')" ).append("\n"); 
		query.append("	    ,(X.CNEE_CUST_NM) = " ).append("\n"); 
		query.append("                   (SELECT MIN(REPLACE(REPLACE(U.CUST_NM, CHR (13),' '), CHR (10), ' '))" ).append("\n"); 
		query.append("                    FROM " ).append("\n"); 
		query.append("			BKG_CUSTOMER U" ).append("\n"); 
		query.append("                    WHERE U.BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("                    AND   U.BKG_CUST_TP_CD = 'C')" ).append("\n"); 
		query.append("WHERE X.TRSP_RAIL_TMP_SEQ = @[trsp_rail_tmp_seq]" ).append("\n"); 

	}
}