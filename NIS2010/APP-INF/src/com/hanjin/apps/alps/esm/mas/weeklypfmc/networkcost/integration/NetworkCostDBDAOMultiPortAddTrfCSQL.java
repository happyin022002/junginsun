/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NetworkCostDBDAOMultiPortAddTrfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOMultiPortAddTrfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 배부된 항비정보를 입력한다.
	  * </pre>
	  */
	public NetworkCostDBDAOMultiPortAddTrfCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wk_vsl_dtrb_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wk_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wk_vsl_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOMultiPortAddTrfCSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_PORT_ADD_TRF A" ).append("\n"); 
		query.append("USING (SELECT @[slan_cd] SLAN_CD," ).append("\n"); 
		query.append("              @[vsl_cd] VSL_CD," ).append("\n"); 
		query.append("              @[skd_voy_no] SKD_VOY_NO," ).append("\n"); 
		query.append("              @[skd_dir_cd] SKD_DIR_CD," ).append("\n"); 
		query.append("              @[cnt_cd] CNT_CD," ).append("\n"); 
		query.append("              @[wk_vsl_dtrb_amt] WK_VSL_DTRB_AMT," ).append("\n"); 
		query.append("              @[wk_vsl_rt] WK_VSL_RT," ).append("\n"); 
		query.append("              @[wk_ttl_amt] WK_TTL_AMT," ).append("\n"); 
		query.append("              ${user_id} USR_ID" ).append("\n"); 
		query.append("         FROM DUAL) B" ).append("\n"); 
		query.append("   ON (    A.SLAN_CD    = B.SLAN_CD" ).append("\n"); 
		query.append("       AND A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND A.CNT_CD     = B.CNT_CD)" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("      INSERT (A.SLAN_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CNT_CD, A.WK_VSL_DTRB_AMT, A.WK_VSL_RT, A.WK_TTL_AMT, A.CRE_USR_ID, A.CRE_DT, A.UPD_USR_ID, A.UPD_DT)" ).append("\n"); 
		query.append("      VALUES (B.SLAN_CD, B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, B.CNT_CD, B.WK_VSL_DTRB_AMT, B.WK_VSL_RT, B.WK_TTL_AMT, B.USR_ID    , SYSDATE , B.USR_ID    , SYSDATE)" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append("      UPDATE" ).append("\n"); 
		query.append("         SET A.WK_VSL_DTRB_AMT = B.WK_VSL_DTRB_AMT," ).append("\n"); 
		query.append("             A.WK_VSL_RT       = B.WK_VSL_RT," ).append("\n"); 
		query.append("             A.WK_TTL_AMT      = B.WK_TTL_AMT," ).append("\n"); 
		query.append("             A.UPD_USR_ID      = B.USR_ID," ).append("\n"); 
		query.append("             A.UPD_DT          = SYSDATE" ).append("\n"); 

	}
}