/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetCntNextPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.26 
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

public class GeneralInvoiceAuditDBDAOgetCntNextPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getCntNextPort
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
	  * [2016.09.26] 다른 VVD && 동일 PORT는 제외
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetCntNextPortRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetCntNextPortRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN DATA IS NULL THEN NULL" ).append("\n"); 
		query.append("            ELSE ''''||DATA||''''" ).append("\n"); 
		query.append("       END" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT NVL(SUBSTR(MIN(B.VPS_ETD_DT||B.YD_CD ),-7, 2), NULL) AS DATA" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("                     , TO_CHAR(B.VPS_ETD_DT,'YYYYMMDDHH24MI') VPS_ETD_DT" ).append("\n"); 
		query.append("                     , B.YD_CD" ).append("\n"); 
		query.append("                     , CASE WHEN B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD <> @[vvd] AND B.YD_CD = @[yd_cd] THEN 'N' /*2016.09.26 다른 VVD && 동일 PORT는 제외*/" ).append("\n"); 
		query.append("                            ELSE 'Y'" ).append("\n"); 
		query.append("                       END AS CHK_FLG" ).append("\n"); 
		query.append("                  FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("                     , VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND A.VSL_CD        = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO    = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD    = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("                   AND A.YD_CD         = @[yd_cd]" ).append("\n"); 
		query.append("                   AND A.CLPT_IND_SEQ  = @[clpt_ind_seq] /*2016.03.23 Add*/" ).append("\n"); 
		query.append("                   AND NVL(A.SKD_CNG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("                   AND NVL(A.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("                   AND A.VSL_CD        = B.VSL_CD" ).append("\n"); 
		query.append("                   AND A.VPS_ETD_DT    < B.VPS_ETD_DT" ).append("\n"); 
		query.append("                   AND NVL(B.SKD_CNG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("                   AND NVL(B.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("                 ORDER BY B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD, B.VPS_ETD_DT, B.CLPT_SEQ" ).append("\n"); 
		query.append("               ) B" ).append("\n"); 
		query.append("         WHERE 1=1    " ).append("\n"); 
		query.append("           AND CHK_FLG = 'Y'" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}