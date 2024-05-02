/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOSearchTPBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.05 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOSearchTPBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TPB I/F 후 TPB 정보를 조회한다
	  * </pre>
	  */
	public EacMgtDBDAOSearchTPBRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOSearchTPBRSQL").append("\n"); 
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
		query.append("SELECT MAX(NVL(Y.STL_TO_CLT_CNG_OFC_CD, X.OFC_CD)) TPB_OFC_CD -- ROC office" ).append("\n"); 
		query.append("     , MAX(CASE WHEN Z.OTS_STS_CD IN ('R','T','J') THEN COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD02799',X.OTS_STS_DTL_CD)" ).append("\n"); 
		query.append("               ELSE COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00588',Z.OTS_STS_CD)" ).append("\n"); 
		query.append("           END) AS OTS_STS_NM -- TPB status" ).append("\n"); 
		query.append("     , SUM(TPB_GET_USD_AMT_FNC(D.CFM_AMT, D.CFM_CURR_CD,TPB_GET_LCL_DATE_FNC(D.CFM_DT,D.CFM_OFC_CD))) AS TPB_INV_AMT -- Recovery(US$)" ).append("\n"); 
		query.append("     , X.N3PTY_NO" ).append("\n"); 
		query.append(" FROM TPB_OTS_GRP X" ).append("\n"); 
		query.append("    , TPB_ADJ_STS Y" ).append("\n"); 
		query.append("    , TPB_OTS_GRP_STS Z" ).append("\n"); 
		query.append("    , TPB_OTS_DTL D" ).append("\n"); 
		query.append("WHERE X.N3PTY_NO = Y.N3PTY_NO(+)" ).append("\n"); 
		query.append("  AND Y.STL_STS_LST_FLG(+) = 'Y' " ).append("\n"); 
		query.append("  AND Y.N3PTY_STL_TP_CD(+) = 'O'" ).append("\n"); 
		query.append("  AND X.N3PTY_NO = Z.N3PTY_NO" ).append("\n"); 
		query.append("  AND Z.OTS_STS_LST_FLG = 'Y'   " ).append("\n"); 
		query.append("  AND X.N3PTY_NO = D.N3PTY_NO" ).append("\n"); 
		query.append("  AND X.N3PTY_NO = @[n3pty_no]" ).append("\n"); 
		query.append("  GROUP BY X.N3PTY_NO" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}