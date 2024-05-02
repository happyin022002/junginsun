/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ModelManageDBDAOSearchNewAccountInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOSearchNewAccountInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 실적이 아예 없는 화주를 조회 후 Sub Trade Add 했을 경우 해당 Account 기본 정보를 조회합니다.
	  * </pre>
	  */
	public ModelManageDBDAOSearchNewAccountInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("season",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("version",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOSearchNewAccountInfoRSQL").append("\n"); 
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
		query.append("SELECT A.TRD_CD" ).append("\n"); 
		query.append("    , A.CUST_CNT_CD" ).append("\n"); 
		query.append("    , A.CUST_SEQ" ).append("\n"); 
		query.append("    , A.SC_NO" ).append("\n"); 
		query.append("    , NVL(A.RFA_NO, A.SC_NO) AS RFA_NO" ).append("\n"); 
		query.append("    , A.WK_MQC_QTY" ).append("\n"); 
		query.append("    , A.CUST_CTRL_CD" ).append("\n"); 
		query.append("    , NVL2(A.SC_NO, 'SC', 'RFA') AS SC_RFA_FLG" ).append("\n"); 
		query.append("    , CASE WHEN NVL(B.NEW_KEY_ACCT_FLG,'N') = 'Y' THEN 'CC'" ).append("\n"); 
		query.append("           WHEN NVL(B.GLO_ACCT_FLG,'N') = 'Y' THEN 'CC'" ).append("\n"); 
		query.append("           WHEN NVL(B.RGN_ACCT_FLG,'N') = 'Y' THEN 'RC'" ).append("\n"); 
		query.append("           ELSE 'LC'" ).append("\n"); 
		query.append("       END ACCT_CLSS_CD" ).append("\n"); 
		query.append("    , B.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("    , (SELECT MAX(OFC_CD)" ).append("\n"); 
		query.append("        FROM MDM_CUSTOMER M" ).append("\n"); 
		query.append("        WHERE M.CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("        AND   M.CUST_SEQ	= A.CUST_SEQ ) AS CTRT_OFC_CD" ).append("\n"); 
		query.append("    , NVL(C.CUST_GRP_NM, B.CUST_LGL_ENG_NM) AS CUST_GRP_NM                 " ).append("\n"); 
		query.append("FROM SPC_MDL_CUST_CTRL A, MDM_CUSTOMER B, MDM_CUST_PERF_GRP C" ).append("\n"); 
		query.append("WHERE A.TRD_CD      = @[trade]" ).append("\n"); 
		query.append("AND A.COST_YRWK     = @[season]" ).append("\n"); 
		query.append("AND A.VER_SEQ       = @[version]" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD||TRIM(TO_CHAR(A.CUST_SEQ, '000009')) = @[acct_cd]" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD   = B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.CUST_SEQ      = B.CUST_SEQ" ).append("\n"); 
		query.append("AND B.CUST_GRP_ID   = C.CUST_GRP_ID(+)" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}