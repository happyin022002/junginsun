/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOsearchUseStatusFormulaDetaillRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOsearchUseStatusFormulaDetaillRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * formula 조회
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOsearchUseStatusFormulaDetaillRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("descript",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOsearchUseStatusFormulaDetaillRSQL").append("\n"); 
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
		query.append("SELECT A.ID" ).append("\n"); 
		query.append("     , A.DESCRIPT" ).append("\n"); 
		query.append("     , CASE WHEN A.LINK = 'Y' THEN ( CASE WHEN SUM(A.VENDOR_CNT) > 0 THEN 'Y' ELSE 'N' END )" ).append("\n"); 
		query.append("         ELSE 'N'" ).append("\n"); 
		query.append("       END AS LINK" ).append("\n"); 
		query.append("     , A.CRE_DATE" ).append("\n"); 
		query.append("     , A.CRE_USR" ).append("\n"); 
		query.append("     , A.UPD_MNU_NO_FOML" ).append("\n"); 
		query.append("     , A.FOML_SYS_DESC" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT DISTINCT T1.FOML_NO                  AS ID" ).append("\n"); 
		query.append("             , T1.FOML_DESC                         AS DESCRIPT" ).append("\n"); 
		query.append("             , DECODE(T3.FOML_NO, NULL, 'N', 'Y')   AS LINK" ).append("\n"); 
		query.append("             , TO_CHAR(T1.UPD_DT, 'YYYY-MM-DD')     AS CRE_DATE" ).append("\n"); 
		query.append("             , T1.UPD_USR_ID                        AS CRE_USR" ).append("\n"); 
		query.append("             , T1.UPD_MNU_NO                        AS UPD_MNU_NO_FOML" ).append("\n"); 
		query.append("             , T1.FOML_SYS_DESC                     AS FOML_SYS_DESC" ).append("\n"); 
		query.append("             ,( SELECT COUNT(MV.VNDR_LGL_ENG_NM)" ).append("\n"); 
		query.append("                  FROM PSO_YD_CHG YC" ).append("\n"); 
		query.append("                     , MDM_VENDOR MV" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND YC.YD_CHG_NO         = T4.YD_CHG_NO" ).append("\n"); 
		query.append("                   AND YC.YD_CHG_VER_SEQ    = T4.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("                   --AND YC.YD_CHG_VER_SEQ    = (SELECT MAX(YD_CHG_VER_SEQ) FROM PSO_YD_CHG WHERE YD_CHG_NO = T4.YD_CHG_NO ) /*최신버전은 항상 Max Version*/" ).append("\n"); 
		query.append("                   AND YC.VNDR_SEQ          = MV.VNDR_SEQ" ).append("\n"); 
		query.append("                   AND MV.DELT_FLG          = 'N' ) AS VENDOR_CNT" ).append("\n"); 
		query.append("          FROM PSO_FORMULA T1" ).append("\n"); 
		query.append("             , PSO_FOML_DTL T2" ).append("\n"); 
		query.append("             , PSO_CHG_XPR_DTL T3" ).append("\n"); 
		query.append("             , PSO_YD_CHG_XPR T4" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND T1.FOML_NO               = T2.FOML_NO" ).append("\n"); 
		query.append("           AND T2.PSO_FOML_DTL_TP_CD    = 'O'" ).append("\n"); 
		query.append("           AND EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                          FROM PSO_OBJ_LIST S1" ).append("\n"); 
		query.append("                         WHERE (T2.OBJ_LIST_NO = S1.OBJ_LIST_NO" ).append("\n"); 
		query.append("                                    OR T2.RT_OBJ_LIST_NO = S1.OBJ_LIST_NO) " ).append("\n"); 
		query.append("#if (${combo3} != '') " ).append("\n"); 
		query.append("			               AND S1.OBJ_LIST_NO   = @[combo3]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("           AND T1.FOML_NO               = T3.FOML_NO(+)" ).append("\n"); 
		query.append("           AND T3.CHG_XPR_NO            = T4.CHG_XPR_NO(+) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${caller} != '') " ).append("\n"); 
		query.append("AND T1.UPD_MNU_NO IN (1, 2)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("#if (${combo1} != '') " ).append("\n"); 
		query.append("AND T1.FOML_NO      = @[combo1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND T1.FOML_NO = T3.FOML_NO(+)" ).append("\n"); 
		query.append("AND T3.CHG_XPR_NO = T4.CHG_XPR_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${combo2} != '') " ).append("\n"); 
		query.append("AND T4.PSO_CHG_TP_CD = @[combo2]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cre_usr} != '') " ).append("\n"); 
		query.append("AND UPPER(T1.UPD_USR_ID)   LIKE '%'||UPPER(@[cre_usr])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${descript} != '') " ).append("\n"); 
		query.append("AND UPPER(T1.FOML_DESC) LIKE '%'||UPPER(@[descript])||'%'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append(" GROUP BY A.ID" ).append("\n"); 
		query.append("     , A.DESCRIPT" ).append("\n"); 
		query.append("     , A.LINK" ).append("\n"); 
		query.append("     , A.CRE_DATE" ).append("\n"); 
		query.append("     , A.CRE_USR" ).append("\n"); 
		query.append("     , A.UPD_MNU_NO_FOML" ).append("\n"); 
		query.append("     , A.FOML_SYS_DESC" ).append("\n"); 
		query.append(" ORDER BY A.ID" ).append("\n"); 

	}
}