/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetDoubleCallRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetDoubleCallRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 177 Double Call
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetDoubleCallRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetDoubleCallRSQL").append("\n"); 
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
		query.append("SELECT ''''||DBL_CALL_FLG||''''" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT CASE WHEN COUNT(A.CLPT_IND_SEQ) > 1 THEN 'Y'" ).append("\n"); 
		query.append("                    ELSE 'N'" ).append("\n"); 
		query.append("               END DBL_CALL_FLG" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A.VSL_CD        = SUBSTR(@[vvd] , 1, 4)" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO    = SUBSTR(@[vvd] , 5, 4)" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD    = SUBSTR(@[vvd] , 9)" ).append("\n"); 
		query.append("           AND A.VPS_PORT_CD   = SUBSTR(@[yd_cd]   , 1, 5)" ).append("\n"); 
		query.append("           --AND A.CLPT_IND_SEQ  = '1' /*2016.03.23 Add*/" ).append("\n"); 
		query.append("           AND NVL(A.SKD_CNG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("           AND NVL(A.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("           AND A.TURN_PORT_IND_CD NOT IN ('D','V','F')" ).append("\n"); 
		query.append("         ORDER BY A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD, A.CLPT_SEQ" ).append("\n"); 
		query.append("       ) " ).append("\n"); 

	}
}