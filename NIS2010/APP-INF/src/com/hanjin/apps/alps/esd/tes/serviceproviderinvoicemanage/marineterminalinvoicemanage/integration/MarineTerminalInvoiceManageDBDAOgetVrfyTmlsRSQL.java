/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOgetVrfyTmlsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.08
*@LastModifier : 
*@LastVersion : 1.0
* 2017.02.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOgetVrfyTmlsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getVrfyTmls
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOgetVrfyTmlsRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOgetVrfyTmlsRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    ATB_DT" ).append("\n"); 
		query.append("    /** " ).append("\n"); 
		query.append("        [CHM-201429211] (2014-05-16) calling port가 복수일 경우 port값과 calling이 되는 port의 모든 yard를 가져다가 " ).append("\n"); 
		query.append("                        Get CNTR List 화면의 combo에 뿌리고 사용자에 의해 선택가능하게 한단다. (구주 털보 아저씨 요청)" ).append("\n"); 
		query.append("    **/" ).append("\n"); 
		query.append("    , CLPT_IND_SEQ CURR_CLPT_IND_SEQ" ).append("\n"); 
		query.append("    , NVL((SELECT COUNT(DISTINCT V.YD_CD) " ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("            WHERE  V.VSL_CD      = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("            AND    V.SKD_VOY_NO  = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("            AND    V.SKD_DIR_CD  = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("            AND    V.VPS_PORT_CD = SUBSTR(@[yd_cd],1,5)),0) CLPT_YD_KNT" ).append("\n"); 
		query.append("    , " ).append("\n"); 
		query.append("    CASE " ).append("\n"); 
		query.append("    WHEN CLPT_IND_SEQ > 1 AND NVL((SELECT COUNT(DISTINCT V.YD_CD) " ).append("\n"); 
		query.append("                                    FROM VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                                    WHERE  V.VSL_CD      = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                                    AND    V.SKD_VOY_NO  = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                                    AND    V.SKD_DIR_CD  = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                                    AND    V.VPS_PORT_CD = SUBSTR(@[yd_cd],1,5)),0) > 1" ).append("\n"); 
		query.append("    THEN (" ).append("\n"); 
		query.append("        SELECT	LTRIM(MAX(SYS_CONNECT_BY_PATH(YD_CD,'|')),'|')" ).append("\n"); 
		query.append("        FROM	(" ).append("\n"); 
		query.append("                SELECT X.YD_CD, ROWNUM ROW_ID FROM (" ).append("\n"); 
		query.append("                    SELECT DISTINCT V.VPS_PORT_CD YD_CD" ).append("\n"); 
		query.append("                    FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                    WHERE  V.VSL_CD      = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                    AND    V.SKD_VOY_NO  = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                    AND    V.SKD_DIR_CD  = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                    AND    V.VPS_PORT_CD = SUBSTR(@[yd_cd],1,5)" ).append("\n"); 
		query.append("                    AND    ROWNUM = 1" ).append("\n"); 
		query.append("                ) X" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT V.YD_CD, ROWNUM +1 ROW_ID " ).append("\n"); 
		query.append("                FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                WHERE  V.VSL_CD      = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                AND    V.SKD_VOY_NO  = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                AND    V.SKD_DIR_CD  = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                AND    V.VPS_PORT_CD = SUBSTR(@[yd_cd],1,5)" ).append("\n"); 
		query.append("                ORDER BY YD_CD ASC" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 
		query.append("        START WITH ROW_ID = 1" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    ELSE ''" ).append("\n"); 
		query.append("    END VRFY_TERMINALS" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("		SELECT V.CLPT_IND_SEQ," ).append("\n"); 
		query.append("			   (SELECT DECODE(L.VSL_SVC_TP_CD,'O',DECODE((SELECT M.CRR_CD FROM MDM_VSL_CNTR M WHERE M.VSL_CD=S.VSL_CD),'SML','H','C'),'H')" ).append("\n"); 
		query.append("				FROM   VSK_VSL_SKD S, MDM_VSL_SVC_LANE L" ).append("\n"); 
		query.append("				WHERE  S.VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("				AND    S.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("				AND    S.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("				AND    S.VSL_SLAN_CD = L.VSL_SLAN_CD(+) )||'|'" ).append("\n"); 
		query.append("				||TO_CHAR(V.VPS_ETB_DT,'YYYY-MM-DD')||'|'||A.REV_YRMON||'|'||V.YD_CD ATB_DT --//정미화K 요청 [CHM-201428898]" ).append("\n"); 
		query.append("		FROM   VSK_VSL_PORT_SKD V, AR_MST_REV_VVD A" ).append("\n"); 
		query.append("		WHERE  V.VSL_CD      = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("		AND    V.SKD_VOY_NO  = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("		AND    V.SKD_DIR_CD  = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("		AND    V.VPS_PORT_CD = SUBSTR(@[yd_cd],1,5)" ).append("\n"); 
		query.append("		AND    V.VSL_CD  	  = A.VSL_CD(+)" ).append("\n"); 
		query.append("		AND    V.SKD_VOY_NO  = A.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("		AND    V.SKD_DIR_CD  = A.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("		ORDER BY V.CLPT_IND_SEQ DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM=1" ).append("\n"); 

	}
}