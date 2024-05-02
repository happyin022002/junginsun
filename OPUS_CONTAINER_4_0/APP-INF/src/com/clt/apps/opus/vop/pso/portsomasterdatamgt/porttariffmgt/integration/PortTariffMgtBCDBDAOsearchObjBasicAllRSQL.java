/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOsearchObjBasicAllRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.08 
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

public class PortTariffMgtBCDBDAOsearchObjBasicAllRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PortTariffMgtBCDBsearchObjBasicAll
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOsearchObjBasicAllRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obj_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOsearchObjBasicAllRSQL").append("\n"); 
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
		query.append("WITH V_YD_CHG AS (" ).append("\n"); 
		query.append("    SELECT D.FOML_NO" ).append("\n"); 
		query.append("         , D.COND_NO" ).append("\n"); 
		query.append("      FROM (SELECT A.YD_CHG_NO" ).append("\n"); 
		query.append("                 , MAX(A.YD_CHG_VER_SEQ) AS YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("              FROM PSO_YD_CHG A" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND A.EFF_DT <= SYSDATE" ).append("\n"); 
		query.append("               AND A.EXP_DT >= SYSDATE" ).append("\n"); 
		query.append("               AND A.LST_FLG = 'Y'" ).append("\n"); 
		query.append("             GROUP BY A.YD_CHG_NO ) A" ).append("\n"); 
		query.append("         , PSO_YD_CHG_XPR B" ).append("\n"); 
		query.append("         , PSO_CHG_XPR C" ).append("\n"); 
		query.append("         , PSO_CHG_XPR_DTL D" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND A.YD_CHG_NO = B.YD_CHG_NO" ).append("\n"); 
		query.append("       AND A.YD_CHG_VER_SEQ = B.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("       AND C.CHG_XPR_NO = B.CHG_XPR_NO" ).append("\n"); 
		query.append("       AND C.CHG_XPR_NO = D.CHG_XPR_NO " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("--SELECT * FROM V_YD_CHG" ).append("\n"); 
		query.append(", V_YD_LINK AS (" ).append("\n"); 
		query.append("    SELECT DISTINCT DECODE(Q.RNUM, 1, P.OBJ_LIST_NO, P.RT_OBJ_LIST_NO) OBJ_LIST_NO" ).append("\n"); 
		query.append("              FROM (SELECT BB.OBJ_LIST_NO" ).append("\n"); 
		query.append("                         , BB.RT_OBJ_LIST_NO" ).append("\n"); 
		query.append("                      FROM V_YD_CHG A" ).append("\n"); 
		query.append("                         , PSO_FORMULA B" ).append("\n"); 
		query.append("                         , PSO_FOML_DTL BB" ).append("\n"); 
		query.append("                     WHERE 1 = 1" ).append("\n"); 
		query.append("                       AND A.FOML_NO = B.FOML_NO" ).append("\n"); 
		query.append("                       AND B.FOML_NO = BB.FOML_NO" ).append("\n"); 
		query.append("                       AND (BB.OBJ_LIST_NO IS NOT NULL OR BB.RT_OBJ_LIST_NO IS NOT NULL) ) P" ).append("\n"); 
		query.append("                 ,(SELECT LEVEL RNUM FROM DUAL CONNECT BY LEVEL <= 2 ) Q" ).append("\n"); 
		query.append("             WHERE DECODE(Q.RNUM, 1, P.OBJ_LIST_NO, P.RT_OBJ_LIST_NO) IS NOT NULL" ).append("\n"); 
		query.append("    UNION " ).append("\n"); 
		query.append("    SELECT DISTINCT DECODE(Q.RNUM, 1, P.OBJ_LIST_NO, P.RT_OBJ_LIST_NO) OBJ_LIST_NO" ).append("\n"); 
		query.append("      FROM (SELECT CC.OBJ_LIST_NO" ).append("\n"); 
		query.append("                 , CC.RT_OBJ_LIST_NO" ).append("\n"); 
		query.append("              FROM V_YD_CHG A" ).append("\n"); 
		query.append("                 , PSO_CONDITION C" ).append("\n"); 
		query.append("                 , PSO_COND_DTL CC" ).append("\n"); 
		query.append("             WHERE 1 = 1" ).append("\n"); 
		query.append("               AND A.COND_NO = C.COND_NO" ).append("\n"); 
		query.append("               AND C.COND_NO = CC.COND_NO" ).append("\n"); 
		query.append("               AND (CC.OBJ_LIST_NO IS NOT NULL OR CC.RT_OBJ_LIST_NO IS NOT NULL)" ).append("\n"); 
		query.append("               AND CC.OBJ_LIST_NO != -1) P" ).append("\n"); 
		query.append("         ,(SELECT LEVEL RNUM FROM DUAL CONNECT BY LEVEL <= 2) Q" ).append("\n"); 
		query.append("     WHERE DECODE(Q.RNUM, 1, P.OBJ_LIST_NO, P.RT_OBJ_LIST_NO) IS NOT NULL " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("--SELECT * FROM V_YD_LINK;" ).append("\n"); 
		query.append(", V_FOMLULA AS (" ).append("\n"); 
		query.append("    SELECT DISTINCT DECODE(Q.RNUM, 1, P.OBJ_LIST_NO, P.RT_OBJ_LIST_NO) OBJ_LIST_NO" ).append("\n"); 
		query.append("      FROM (SELECT BB.OBJ_LIST_NO" ).append("\n"); 
		query.append("                 , BB.RT_OBJ_LIST_NO" ).append("\n"); 
		query.append("              FROM PSO_FORMULA B" ).append("\n"); 
		query.append("                 , PSO_FOML_DTL BB" ).append("\n"); 
		query.append("             WHERE 1 = 1" ).append("\n"); 
		query.append("               AND B.UPD_MNU_NO = '2' /*신규 Object 등록시에는 무조건 1 로만 등록한다.*/" ).append("\n"); 
		query.append("               AND B.FOML_NO = BB.FOML_NO" ).append("\n"); 
		query.append("               AND (BB.OBJ_LIST_NO IS NOT NULL OR BB.RT_OBJ_LIST_NO IS NOT NULL) ) P" ).append("\n"); 
		query.append("         ,(SELECT LEVEL RNUM FROM DUAL CONNECT BY LEVEL <= 2 ) Q" ).append("\n"); 
		query.append("     WHERE DECODE(Q.RNUM, 1, P.OBJ_LIST_NO, P.RT_OBJ_LIST_NO) IS NOT NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("--SELECT * FROM V_FOMLULA;" ).append("\n"); 
		query.append(", V_CONDITION AS (" ).append("\n"); 
		query.append("    SELECT DISTINCT DECODE(Q.RNUM, 1, P.OBJ_LIST_NO, P.RT_OBJ_LIST_NO) OBJ_LIST_NO" ).append("\n"); 
		query.append("      FROM (SELECT CC.OBJ_LIST_NO" ).append("\n"); 
		query.append("                 , CC.RT_OBJ_LIST_NO" ).append("\n"); 
		query.append("              FROM PSO_CONDITION C" ).append("\n"); 
		query.append("                 , PSO_COND_DTL CC" ).append("\n"); 
		query.append("             WHERE 1 = 1" ).append("\n"); 
		query.append("               AND C.COND_NO = CC.COND_NO" ).append("\n"); 
		query.append("               AND (CC.OBJ_LIST_NO IS NOT NULL OR CC.RT_OBJ_LIST_NO IS NOT NULL)" ).append("\n"); 
		query.append("               AND CC.OBJ_LIST_NO != -1) P" ).append("\n"); 
		query.append("         ,(SELECT LEVEL RNUM FROM DUAL CONNECT BY LEVEL <= 2) Q" ).append("\n"); 
		query.append("     WHERE DECODE(Q.RNUM, 1, P.OBJ_LIST_NO, P.RT_OBJ_LIST_NO) IS NOT NULL " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("--SELECT * FROM V_CONDITION;" ).append("\n"); 
		query.append("SELECT OB.OBJ_LIST_NO" ).append("\n"); 
		query.append("     , OB.OBJ_LIST_NM" ).append("\n"); 
		query.append("     , OB.PSO_OBJ_LIST_TP_CD" ).append("\n"); 
		query.append("     , OB.PSO_OBJ_CD" ).append("\n"); 
		query.append("     , OB.PSO_MEAS_UT_CD" ).append("\n"); 
		query.append("     , OB.OBJ_LIST_ABBR_NM" ).append("\n"); 
		query.append("     , OB.DFLT_CTNT" ).append("\n"); 
		query.append("     , OB.DIFF_RMK" ).append("\n"); 
		query.append("     , DECODE(VY.OBJ_LIST_NO,NULL,'N','Y') YD_LINK_YN" ).append("\n"); 
		query.append("     , DECODE(VF.OBJ_LIST_NO,NULL,'N','Y') FOML_USED_YN" ).append("\n"); 
		query.append("     , DECODE(VC.OBJ_LIST_NO,NULL,'N','Y') COND_USED_YN" ).append("\n"); 
		query.append("  FROM PSO_OBJ_LIST OB" ).append("\n"); 
		query.append("     , V_YD_LINK VY" ).append("\n"); 
		query.append("     , V_FOMLULA VF" ).append("\n"); 
		query.append("     , V_CONDITION VC" ).append("\n"); 
		query.append(" WHERE 1 =1" ).append("\n"); 
		query.append("   AND OB.OBJ_LIST_NO = VY.OBJ_LIST_NO(+)" ).append("\n"); 
		query.append("   AND OB.OBJ_LIST_NO = VF.OBJ_LIST_NO(+)" ).append("\n"); 
		query.append("   AND OB.OBJ_LIST_NO = VC.OBJ_LIST_NO(+)" ).append("\n"); 
		query.append("#if(${obj_nm} != '')" ).append("\n"); 
		query.append("AND UPPER (OB.OBJ_LIST_NM) LIKE UPPER('%' || @[obj_nm] || '%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY OB.OBJ_LIST_NO" ).append("\n"); 

	}
}