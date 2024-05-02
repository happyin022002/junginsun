/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOSearchExistPortExpnDivRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.29 
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

public class GeneralInvoiceAuditDBDAOSearchExistPortExpnDivRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Exist Port Expn Div Data Search
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOSearchExistPortExpnDivRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOSearchExistPortExpnDivRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN COUNT(1) > 0 THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 'N'" ).append("\n"); 
		query.append("       END AS EXIST_YN" ).append("\n"); 
		query.append("  FROM PSO_PORT_EXPN_DIV D" ).append("\n"); 
		query.append("     , (SELECT DISTINCT B.VSL_CD" ).append("\n"); 
		query.append("             , B.SKD_VOY_NO" ).append("\n"); 
		query.append("             , B.SKD_DIR_CD" ).append("\n"); 
		query.append("             , A.TURN_PORT_FLG TURN" ).append("\n"); 
		query.append("             , A.SLAN_CD" ).append("\n"); 
		query.append("             , A.VPS_PORT_CD" ).append("\n"); 
		query.append("          FROM VSK_VSL_SKD B" ).append("\n"); 
		query.append("             , VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("         WHERE 1=1 " ).append("\n"); 
		query.append("           AND B.VSL_CD         = @[vsl_cd]" ).append("\n"); 
		query.append("           AND B.SKD_VOY_NO     = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND B.SKD_DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("           AND B.VSL_CD         = A.VSL_CD" ).append("\n"); 
		query.append("           AND B.SKD_VOY_NO     = A.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND B.SKD_DIR_CD     = A.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND A.YD_CD          = @[yd_cd]" ).append("\n"); 
		query.append("           AND NVL(A.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("           AND NVL(A.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/ " ).append("\n"); 
		query.append("           AND A.TURN_PORT_IND_CD IN ('N', 'Y')" ).append("\n"); 
		query.append("           AND A.CLPT_IND_SEQ = NVL(@[clpt_ind_seq],(SELECT MIN(P.CLPT_IND_SEQ) " ).append("\n"); 
		query.append("                                                       FROM VSK_VSL_PORT_SKD P " ).append("\n"); 
		query.append("                                                      WHERE 1=1" ).append("\n"); 
		query.append("                                                        AND P.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("                                                        AND P.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("                                                        AND P.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                                        AND P.YD_CD         = @[yd_cd]" ).append("\n"); 
		query.append("                                                        AND NVL(P.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("                                                        AND NVL(P.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/ " ).append("\n"); 
		query.append("                                                        AND P.TURN_PORT_IND_CD IN ('N', 'Y')" ).append("\n"); 
		query.append("                                                     )) " ).append("\n"); 
		query.append("       ) V" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND V.SLAN_CD        = D.SLAN_CD" ).append("\n"); 
		query.append("   AND V.SKD_DIR_CD     = D.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND V.VPS_PORT_CD    = D.LOC_CD" ).append("\n"); 

	}
}