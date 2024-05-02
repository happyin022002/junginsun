/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetRevLaneDirRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.24 
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

public class GeneralInvoiceAuditDBDAOgetRevLaneDirRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getRevLaneDir
	  * [2016.03.18]Rev. Lane 수정처리.
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetRevLaneDirRSQL(){
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
		query.append("FileName : GeneralInvoiceAuditDBDAOgetRevLaneDirRSQL").append("\n"); 
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
		query.append("WITH V_PARAM AS (    " ).append("\n"); 
		query.append("    SELECT @[vsl_cd]        AS VSL_CD" ).append("\n"); 
		query.append("         , @[skd_voy_no]    AS SKD_VOY_NO" ).append("\n"); 
		query.append("         , @[skd_dir_cd]    AS SKD_DIR_CD" ).append("\n"); 
		query.append("         , @[yd_cd]         AS YD_CD" ).append("\n"); 
		query.append("         , NVL(@[clpt_ind_seq], (SELECT MIN(PS.CLPT_IND_SEQ) " ).append("\n"); 
		query.append("                       FROM VSK_VSL_PORT_SKD PS " ).append("\n"); 
		query.append("                      WHERE 1=1" ).append("\n"); 
		query.append("                        AND PS.VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("                        AND PS.SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("                        AND PS.SKD_DIR_CD   = @[skd_dir_cd] " ).append("\n"); 
		query.append("                        AND PS.YD_CD        = @[yd_cd]" ).append("\n"); 
		query.append("                        AND NVL(PS.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("                        AND NVL(PS.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("                      )) AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("      FROM DUAL                     " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", V_PORT_SKD AS (" ).append("\n"); 
		query.append("    /*디폴트로 1건이 나타나도록 처리 함.*/" ).append("\n"); 
		query.append("    SELECT A.*" ).append("\n"); 
		query.append("         , (SELECT MAX(L.RLANE_CD) ||'|'|| MAX(L.RLANE_DIR_CD) ||'|'|| MAX(L.REV_YRMON) AS REV_DATA" ).append("\n"); 
		query.append("              FROM AR_MST_REV_VVD L" ).append("\n"); 
		query.append("                 , V_PARAM P" ).append("\n"); 
		query.append("             WHERE L.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("               AND L.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND L.SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND L.DELT_FLG   = 'N' /*2015.09.11 Add*/" ).append("\n"); 
		query.append("               AND ROWNUM       = 1 /*Default AR REV VVD 1건만 잡는다.*/) AS DFLT_REV_DATA" ).append("\n"); 
		query.append("      FROM (               " ).append("\n"); 
		query.append("            SELECT *" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                    SELECT '1' AS ORD" ).append("\n"); 
		query.append("                         , VPS.TURN_PORT_FLG" ).append("\n"); 
		query.append("                         , VPS.VSL_CD" ).append("\n"); 
		query.append("                         , VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("                         , VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("                         , VPS.YD_CD" ).append("\n"); 
		query.append("                      FROM VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("                         , V_PARAM P" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       AND NVL(VPS.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("                       AND NVL(VPS.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("                       AND VPS.VSL_CD = P.VSL_CD" ).append("\n"); 
		query.append("                       AND VPS.TURN_SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND VPS.TURN_SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                       AND VPS.YD_CD = P.YD_CD" ).append("\n"); 
		query.append("                       AND VPS.TURN_CLPT_IND_SEQ = P.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                       AND ROWNUM = 1 /*무조건 1건 나오지만 혹시 몰라서*/  " ).append("\n"); 
		query.append("                   UNION " ).append("\n"); 
		query.append("                   SELECT '2' AS ORD" ).append("\n"); 
		query.append("                         , 'N' AS TURN_PORT_FLG" ).append("\n"); 
		query.append("                         , P.VSL_CD" ).append("\n"); 
		query.append("                         , P.SKD_VOY_NO" ).append("\n"); 
		query.append("                         , P.SKD_DIR_CD" ).append("\n"); 
		query.append("                         , P.YD_CD" ).append("\n"); 
		query.append("                      FROM V_PARAM P" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("            WHERE ROWNUM = 1  " ).append("\n"); 
		query.append("          ) A" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("--SELECT * FROM V_PORT_SKD;" ).append("\n"); 
		query.append(", V_NORMAL_PORT AS (" ).append("\n"); 
		query.append("    SELECT COUNT(L.RLANE_DIR_CD) AS CNT" ).append("\n"); 
		query.append("         , MAX(L.RLANE_CD) ||'|'|| MAX(L.RLANE_DIR_CD) ||'|'|| MAX(L.REV_YRMON) AS REV_DATA" ).append("\n"); 
		query.append("      FROM AR_MST_REV_VVD L" ).append("\n"); 
		query.append("         , V_PARAM P" ).append("\n"); 
		query.append("     WHERE L.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("       AND L.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND L.SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND L.DELT_FLG   = 'N' /*2015.09.11 Add*/" ).append("\n"); 
		query.append("       AND L.RLANE_CD   = NVL(PSO_GET_REV_LANE_FNC(P.VSL_CD, P.SKD_VOY_NO, P.SKD_DIR_CD, SUBSTR (P.YD_CD, 1, 5)), L.RLANE_CD)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("--SELECT * FROM V_NORMAL_PORT;" ).append("\n"); 
		query.append(", V_TURNING_PORT AS (" ).append("\n"); 
		query.append("    SELECT COUNT(L.RLANE_DIR_CD) AS CNT" ).append("\n"); 
		query.append("         , MAX(A.RLANE_CD) ||'|'|| MAX(L.RLANE_DIR_CD) ||'|'|| MAX(L.REV_YRMON) AS REV_DATA" ).append("\n"); 
		query.append("      FROM (SELECT MAX(L.RLANE_CD) RLANE_CD" ).append("\n"); 
		query.append("              FROM AR_MST_REV_VVD L" ).append("\n"); 
		query.append("                 , V_PORT_SKD VPK" ).append("\n"); 
		query.append("             WHERE L.VSL_CD     = VPK.VSL_CD" ).append("\n"); 
		query.append("               AND L.SKD_VOY_NO = VPK.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND L.SKD_DIR_CD = VPK.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND L.DELT_FLG   = 'N' /*2015.09.11 Add*/" ).append("\n"); 
		query.append("               AND L.RLANE_CD   = NVL(PSO_GET_REV_LANE_FNC(VPK.VSL_CD, VPK.SKD_VOY_NO, VPK.SKD_DIR_CD, SUBSTR (VPK.YD_CD, 1, 5)), L.RLANE_CD) ) A" ).append("\n"); 
		query.append("         , AR_MST_REV_VVD L" ).append("\n"); 
		query.append("         , V_PARAM P" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND L.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("       AND L.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND L.SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND L.RLANE_CD   = A.RLANE_CD" ).append("\n"); 
		query.append("       AND L.DELT_FLG   = 'N' /*2015.09.11 Add 2016.03.22*/" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--SELECT * FROM V_TURNING_PORT;" ).append("\n"); 
		query.append("SELECT DECODE(NVL(PK.TURN_PORT_FLG,'N'),'Y', (SELECT DECODE(TP.CNT, 0, PK.DFLT_REV_DATA, TP.REV_DATA) FROM V_TURNING_PORT TP)" ).append("\n"); 
		query.append("                                           , (SELECT DECODE(NP.CNT, 0, PK.DFLT_REV_DATA, NP.REV_DATA) FROM V_NORMAL_PORT NP)" ).append("\n"); 
		query.append("       ) AS REV_DATA" ).append("\n"); 
		query.append("  FROM V_PORT_SKD PK" ).append("\n"); 

	}
}