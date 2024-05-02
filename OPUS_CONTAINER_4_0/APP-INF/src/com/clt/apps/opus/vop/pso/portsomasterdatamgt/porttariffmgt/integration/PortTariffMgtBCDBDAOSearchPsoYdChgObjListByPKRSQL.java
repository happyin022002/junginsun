/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOSearchPsoYdChgObjListByPKRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.18 
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

public class PortTariffMgtBCDBDAOSearchPsoYdChgObjListByPKRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSO_YD_CHG_OBJ_LIST <select>
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOSearchPsoYdChgObjListByPKRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOSearchPsoYdChgObjListByPKRSQL").append("\n"); 
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
		query.append("SELECT X.OBJ_LIST_NO" ).append("\n"); 
		query.append("     ,X.OBJ_LIST_NM" ).append("\n"); 
		query.append("     ,X.PSO_OBJ_CD" ).append("\n"); 
		query.append("     ,X.PSO_OBJ_CD_DSP" ).append("\n"); 
		query.append("     ,X.PSO_MEAS_UT_CD" ).append("\n"); 
		query.append("     ,X.PSO_MEAS_UT_CD_DSP" ).append("\n"); 
		query.append("     ,A.DFLT_VAL" ).append("\n"); 
		query.append("     ,A.YD_CHG_NO" ).append("\n"); 
		query.append("     ,A.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("     ,A.DFLT_CTNT" ).append("\n"); 
		query.append("     ,A.DFLT_VAL" ).append("\n"); 
		query.append("     ,DECODE(X.PSO_MEAS_UT_CD, '12', A.DFLT_FLG, A.DFLT_VAL) REGULAR_VALUE" ).append("\n"); 
		query.append("     ,A.DFLT_FLG" ).append("\n"); 
		query.append("  FROM PSO_YD_CHG_OBJ_LIST A" ).append("\n"); 
		query.append("     ,( SELECT DISTINCT B.OBJ_LIST_NO" ).append("\n"); 
		query.append("             ,B.OBJ_LIST_NM" ).append("\n"); 
		query.append("             ,B.PSO_OBJ_CD PSO_OBJ_CD" ).append("\n"); 
		query.append("             ,B.OBJ_LIST_NM PSO_OBJ_CD_DSP" ).append("\n"); 
		query.append("             ,B.PSO_MEAS_UT_CD PSO_MEAS_UT_CD" ).append("\n"); 
		query.append("             ,C2.INTG_CD_VAL_DP_DESC PSO_MEAS_UT_CD_DSP" ).append("\n"); 
		query.append("          FROM PSO_OBJ_LIST B" ).append("\n"); 
		query.append("             ,COM_INTG_CD_DTL C2" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND B.PSO_MEAS_UT_CD = C2.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("           AND C2.INTG_CD_ID = 'CD01848'  ) X" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("         SELECT DISTINCT DECODE(Q.RNUM, 1, P.OBJ_LIST_NO, P.RT_OBJ_LIST_NO) OBJ_LIST_NO" ).append("\n"); 
		query.append("           FROM (SELECT BB.OBJ_LIST_NO" ).append("\n"); 
		query.append("                      , BB.RT_OBJ_LIST_NO    " ).append("\n"); 
		query.append("                   FROM (SELECT D.FOML_NO" ).append("\n"); 
		query.append("                              , D.COND_NO" ).append("\n"); 
		query.append("                           FROM PSO_YD_CHG      A" ).append("\n"); 
		query.append("                              , PSO_YD_CHG_XPR  B" ).append("\n"); 
		query.append("                              , PSO_CHG_XPR     C" ).append("\n"); 
		query.append("                              , PSO_CHG_XPR_DTL D" ).append("\n"); 
		query.append("                          WHERE A.YD_CHG_NO = B.YD_CHG_NO" ).append("\n"); 
		query.append("                            AND A.YD_CHG_VER_SEQ = B.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("                            AND C.CHG_XPR_NO = B.CHG_XPR_NO" ).append("\n"); 
		query.append("                            AND C.CHG_XPR_NO = D.CHG_XPR_NO" ).append("\n"); 
		query.append("                            AND A.YD_CHG_NO = @[yd_chg_no]" ).append("\n"); 
		query.append("                            AND A.YD_CHG_VER_SEQ = @[yd_chg_ver_seq]) A" ).append("\n"); 
		query.append("                      , PSO_FORMULA B" ).append("\n"); 
		query.append("                      , PSO_FOML_DTL BB" ).append("\n"); 
		query.append("                  WHERE 1 = 1" ).append("\n"); 
		query.append("                    AND A.FOML_NO = B.FOML_NO" ).append("\n"); 
		query.append("                    AND B.FOML_NO = BB.FOML_NO" ).append("\n"); 
		query.append("                    AND BB.OBJ_LIST_NO IS NOT NULL" ).append("\n"); 
		query.append("               ) P" ).append("\n"); 
		query.append("              ,(SELECT LEVEL RNUM FROM DUAL CONNECT BY LEVEL <= 2) Q  " ).append("\n"); 
		query.append("         WHERE DECODE(Q.RNUM, 1, P.OBJ_LIST_NO, P.RT_OBJ_LIST_NO) IS NOT NULL " ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("        SELECT DISTINCT DECODE(Q.RNUM, 1, P.OBJ_LIST_NO, P.RT_OBJ_LIST_NO) OBJ_LIST_NO" ).append("\n"); 
		query.append("          FROM (SELECT CC.OBJ_LIST_NO" ).append("\n"); 
		query.append("                     ,CC.RT_OBJ_LIST_NO" ).append("\n"); 
		query.append("                  FROM (SELECT D.FOML_NO" ).append("\n"); 
		query.append("                             ,D.COND_NO" ).append("\n"); 
		query.append("                          FROM PSO_YD_CHG A" ).append("\n"); 
		query.append("                             ,PSO_YD_CHG_XPR B" ).append("\n"); 
		query.append("                             ,PSO_CHG_XPR C" ).append("\n"); 
		query.append("                             ,PSO_CHG_XPR_DTL D" ).append("\n"); 
		query.append("                         WHERE A.YD_CHG_NO = B.YD_CHG_NO" ).append("\n"); 
		query.append("                           AND A.YD_CHG_VER_SEQ = B.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("                           AND C.CHG_XPR_NO = B.CHG_XPR_NO" ).append("\n"); 
		query.append("                           AND C.CHG_XPR_NO = D.CHG_XPR_NO" ).append("\n"); 
		query.append("                           AND A.YD_CHG_NO = @[yd_chg_no]" ).append("\n"); 
		query.append("                           AND A.YD_CHG_VER_SEQ = @[yd_chg_ver_seq]) A" ).append("\n"); 
		query.append("                     ,PSO_CONDITION C" ).append("\n"); 
		query.append("                     ,PSO_COND_DTL CC" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND A.COND_NO = C.COND_NO" ).append("\n"); 
		query.append("                   AND C.COND_NO = CC.COND_NO" ).append("\n"); 
		query.append("                   AND CC.OBJ_LIST_NO IS NOT NULL" ).append("\n"); 
		query.append("                   AND CC.OBJ_LIST_NO != -1) P" ).append("\n"); 
		query.append("             ,(SELECT LEVEL RNUM FROM DUAL CONNECT BY LEVEL <= 2) Q" ).append("\n"); 
		query.append("         WHERE DECODE(Q.RNUM, 1, P.OBJ_LIST_NO, P.RT_OBJ_LIST_NO) IS NOT NULL " ).append("\n"); 
		query.append("     ) Y" ).append("\n"); 
		query.append("     , PSO_OBJ_LIST Z" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND Y.OBJ_LIST_NO = X.OBJ_LIST_NO" ).append("\n"); 
		query.append("   AND Y.OBJ_LIST_NO = Z.OBJ_LIST_NO" ).append("\n"); 
		query.append("   AND Y.OBJ_LIST_NO = A.OBJ_LIST_NO(+)" ).append("\n"); 
		query.append("   AND A.YD_CHG_NO (+)= @[yd_chg_no]" ).append("\n"); 
		query.append("   AND A.YD_CHG_VER_SEQ (+)= @[yd_chg_ver_seq]" ).append("\n"); 
		query.append("   AND Z.PSO_OBJ_LIST_TP_CD IN ('A', 'M')" ).append("\n"); 
		query.append(" ORDER BY X.PSO_OBJ_CD_DSP" ).append("\n"); 

	}
}