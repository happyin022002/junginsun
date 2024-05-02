/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : NetworkCostDBDAOCreateBunkerTariff2CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.06
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2012.02.06 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim jong jun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOCreateBunkerTariff2CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [CHM-201215754-01] [COA] Bunker Fee 화면 개발 건 쿼리 생성
	  * </pre>
	  */
	public NetworkCostDBDAOCreateBunkerTariff2CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOCreateBunkerTariff2CSQL").append("\n"); 
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
		query.append("-- FCM Cons 정보를 Create 후에 최근 12주차 중에서 가장 최근에 해당하는 Unit Cost를 업데이트 한다." ).append("\n"); 
		query.append("-- SKD_VOY_NO가 가장 큰 값" ).append("\n"); 
		query.append("MERGE INTO COA_BNK_TRF D1 USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" SELECT A.SLAN_CD" ).append("\n"); 
		query.append("      , A.RLANE_CD" ).append("\n"); 
		query.append("      , A.VSL_CD" ).append("\n"); 
		query.append("      , LPAD(MAX(TO_NUMBER(A.SKD_VOY_NO)),4,'0') SKD_VOY_NO" ).append("\n"); 
		query.append("      , A.DIR_CD" ).append("\n"); 
		query.append("      , MAX(B.FOIL_UC_AMT) KEEP(DENSE_RANK LAST ORDER BY A.SKD_VOY_NO ) FOIL_UC_AMT" ).append("\n"); 
		query.append("      , MAX(B.DOIL_UC_AMT) KEEP(DENSE_RANK LAST ORDER BY A.SKD_VOY_NO ) DOIL_UC_AMT" ).append("\n"); 
		query.append("   FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("                SELECT DISTINCT A1.SLAN_CD" ).append("\n"); 
		query.append("                      , A1.RLANE_CD" ).append("\n"); 
		query.append("                      , A1.DIR_CD" ).append("\n"); 
		query.append("                      , A1.VSL_CD" ).append("\n"); 
		query.append("                      , A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                   FROM COA_MON_VVD A1" ).append("\n"); 
		query.append("                      , COA_VSL_RGST A2" ).append("\n"); 
		query.append("                      , COA_LANE_RGST A3" ).append("\n"); 
		query.append("                      , (" ).append("\n"); 
		query.append("                                 SELECT PREV_WK_12" ).append("\n"); 
		query.append("                                      , PREV_WK_1" ).append("\n"); 
		query.append("                                   FROM" ).append("\n"); 
		query.append("                                        (" ).append("\n"); 
		query.append("                                                 SELECT LAG (COST_YR || COST_WK, 12) OVER (ORDER BY COST_YR || COST_WK)" ).append("\n"); 
		query.append("                                                        AS PREV_WK_12" ).append("\n"); 
		query.append("                                                      , LAG (COST_YR || COST_WK, 1) OVER (ORDER BY COST_YR || COST_WK)" ).append("\n"); 
		query.append("                                                        AS PREV_WK_1" ).append("\n"); 
		query.append("                                                   FROM COA_WK_PRD" ).append("\n"); 
		query.append("                                                  WHERE COST_YR || COST_WK <= SUBSTR(@[cost_yrmon],1,4) || @[cost_wk]" ).append("\n"); 
		query.append("                                               ORDER BY COST_YR || COST_WK DESC" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                  WHERE ROWNUM = 1" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                        A4" ).append("\n"); 
		query.append("                  WHERE A1.TRD_CD   = A3.TRD_CD" ).append("\n"); 
		query.append("                    AND A1.RLANE_CD = A3.RLANE_CD" ).append("\n"); 
		query.append("                    AND A1.IOC_CD   = A3.IOC_CD" ).append("\n"); 
		query.append("                    AND A1.DIR_CD   = A3.DIR_CD" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                    AND A1.RLANE_CD        = @[rlane_cd]" ).append("\n"); 
		query.append("                    AND A1.SLAN_CD         = @[slan_cd]" ).append("\n"); 
		query.append("                    AND A1.VSL_CD          = @[vsl_cd] " ).append("\n"); 
		query.append("                    AND A1.DIR_CD          = @[dir_cd]" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                    AND SUBSTR(A1.SLS_YRMON, 1, 4)||A1.COST_WK BETWEEN A4.PREV_WK_12 AND A4.PREV_WK_1" ).append("\n"); 
		query.append("                    AND A3.TRD_CD         <> 'COM'" ).append("\n"); 
		query.append("                    AND A3.VSL_LANE_TP_CD IN ('JO', 'SC')" ).append("\n"); 
		query.append("                    AND A1.VSL_CD          = A2.VSL_CD" ).append("\n"); 
		query.append("                    AND A1.N1ST_LODG_PORT_ETD_DT BETWEEN A2.VSL_APLY_FM_DT AND A2.VSL_APLY_TO_DT" ).append("\n"); 
		query.append("                    AND A2.VOP_CD   = 'HJS'" ).append("\n"); 
		query.append("                    AND A1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                    AND A2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                    AND A3.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        A" ).append("\n"); 
		query.append("      , COA_BNK_TRF B" ).append("\n"); 
		query.append("  WHERE A.SLAN_CD  = B.SLAN_CD" ).append("\n"); 
		query.append("    AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("    AND A.VSL_CD   = B.VSL_CD" ).append("\n"); 
		query.append("    AND A.SKD_VOY_NO   = B.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND A.DIR_CD   = B.DIR_CD" ).append("\n"); 
		query.append("    AND B.FOIL_UC_AMT > 0.00" ).append("\n"); 
		query.append("GROUP BY A.SLAN_CD" ).append("\n"); 
		query.append("      , A.RLANE_CD" ).append("\n"); 
		query.append("      , A.VSL_CD" ).append("\n"); 
		query.append("      , A.DIR_CD" ).append("\n"); 
		query.append(") D2 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ON (        D1.SLAN_CD          = D2.SLAN_CD " ).append("\n"); 
		query.append("        AND D1.RLANE_CD         = D2.RLANE_CD " ).append("\n"); 
		query.append("        AND D1.VSL_CD           = D2.VSL_CD " ).append("\n"); 
		query.append("	    AND D1.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("        AND D1.DIR_CD           = D2.DIR_CD )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("         UPDATE" ).append("\n"); 
		query.append("        SET D1.FOIL_UC_AMT      = D2.FOIL_UC_AMT" ).append("\n"); 
		query.append("          , D1.DOIL_UC_AMT      = D2.DOIL_UC_AMT" ).append("\n"); 
		query.append("          , D1.UPD_USR_ID       = @[cre_usr_id]" ).append("\n"); 
		query.append("          , D1.UPD_DT           = SYSDATE" ).append("\n"); 

	}
}