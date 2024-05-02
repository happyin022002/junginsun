/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSelectFullRtnYdCctRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOSelectFullRtnYdCctRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SelectFullRtnYdCct
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSelectFullRtnYdCctRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_cargo_rtn_tm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSelectFullRtnYdCctRSQL").append("\n"); 
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
		query.append("WITH CCT AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	PRD_COMMON_PKG.PRD_GET_CCT_BY_PC_FNC(@[pctl_no])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--    SELECT DISTINCT PRD_GET_CCT_FNC(D.ORG_NOD_CD," ).append("\n"); 
		query.append("--                                    D.VSL_SLAN_CD," ).append("\n"); 
		query.append("--                                    D.SKD_DIR_CD," ).append("\n"); 
		query.append("--									CASE 	WHEN M.DG_SPCL_FLG 		= 'Y' THEN 'DG'" ).append("\n"); 
		query.append("--										 	WHEN M.RF_SPCL_FLG 		= 'Y' THEN 'RF'" ).append("\n"); 
		query.append("--											WHEN M.SPCL_AWK_CGO_FLG = 'Y' THEN 'AK'" ).append("\n"); 
		query.append("--											WHEN M.BB_SPCL_FLG 		= 'Y' THEN 'BB'" ).append("\n"); 
		query.append("--									     	--:2016-09-05:--WHEN M.SPCL_AWK_CGO_FLG = 'Y' OR M.BB_SPCL_FLG = 'Y' THEN 'AL'" ).append("\n"); 
		query.append("--										 	ELSE 'DR'" ).append("\n"); 
		query.append("--									END,   " ).append("\n"); 
		query.append("--                                    D.VSL_CD || D.SKD_VOY_NO || D.SKD_DIR_CD," ).append("\n"); 
		query.append("--                                    D.ORG_CLPT_IND_SEQ," ).append("\n"); 
		query.append("--                                    NVL(S.VPS_ETB_DT, D.ARR_ST_DT)," ).append("\n"); 
		query.append("--                                    NVL(S.VPS_ETD_DT, D.ARR_ST_DT)) CCT," ).append("\n"); 
		query.append("--                    M.DG_SPCL_FLG," ).append("\n"); 
		query.append("--                    M.RF_SPCL_FLG," ).append("\n"); 
		query.append("--                    m.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("--      FROM PRD_PROD_CTL_MST M, PRD_PROD_CTL_ROUT_DTL D, VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("--     WHERE M.PCTL_NO = [pctl_no]" ).append("\n"); 
		query.append("--       AND M.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("--       AND D.PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append("--       AND D.TRSP_MOD_CD IN ('WD', 'VD')" ).append("\n"); 
		query.append("--       AND SUBSTR(D.ORG_NOD_CD, 1, 5) = M.POL_CD" ).append("\n"); 
		query.append("--       AND S.VSL_CD(+) = D.VSL_CD" ).append("\n"); 
		query.append("--       AND S.SKD_VOY_NO(+) = D.SKD_VOY_NO" ).append("\n"); 
		query.append("--       AND S.SKD_DIR_CD(+) = D.SKD_DIR_CD" ).append("\n"); 
		query.append("--       AND S.CLPT_IND_SEQ(+) = D.ORG_CLPT_IND_SEQ" ).append("\n"); 
		query.append("--       AND S.YD_CD(+) = D.ORG_NOD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("select " ).append("\n"); 
		query.append("yd_cd yd_cd1,yd_cd," ).append("\n"); 
		query.append("CASE WHEN GEN IS NOT NULL AND L_N0 =1 AND SUBSTR(YD_CD,1,2) IN ('US','CA') " ).append("\n"); 
		query.append("        THEN DECODE (@[rail_cargo_rtn_tm], '','', TO_CHAR( TO_DATE(@[rail_cargo_rtn_tm],'yyyymmdd') ,'YYYY-MM-DD'))" ).append("\n"); 
		query.append("     WHEN GEN IS NOT NULL AND L_N0 =2 THEN TO_CHAR(TO_DATE(GEN, 'YYYY/MM/DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("     ELSE ''" ).append("\n"); 
		query.append("END " ).append("\n"); 
		query.append("GEN," ).append("\n"); 
		query.append("CASE WHEN  L_N0 =1 THEN 'FROM'" ).append("\n"); 
		query.append("     WHEN  L_N0 =2 THEN 'TO'" ).append("\n"); 
		query.append("     ELSE ''" ).append("\n"); 
		query.append("END txt," ).append("\n"); 
		query.append("CASE WHEN RF IS NOT NULL AND L_N0 =1 AND SUBSTR(YD_CD,1,2) IN ('US','CA') " ).append("\n"); 
		query.append("        THEN DECODE (@[rail_cargo_rtn_tm], '','', TO_CHAR( TO_DATE(@[rail_cargo_rtn_tm],'yyyymmdd') ,'YYYY-MM-DD'))" ).append("\n"); 
		query.append("     WHEN RF IS NOT NULL AND L_N0 =2 THEN TO_CHAR(TO_DATE(RF, 'YYYY/MM/DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("     ELSE ''" ).append("\n"); 
		query.append("END RF," ).append("\n"); 
		query.append("CASE WHEN DG IS NOT NULL AND L_N0 =1 AND SUBSTR(YD_CD,1,2) IN ('US','CA') " ).append("\n"); 
		query.append("        THEN DECODE (@[rail_cargo_rtn_tm], '','', TO_CHAR( TO_DATE(@[rail_cargo_rtn_tm],'yyyymmdd') ,'YYYY-MM-DD'))" ).append("\n"); 
		query.append("     WHEN DG IS NOT NULL AND L_N0 =2 THEN TO_CHAR(TO_DATE(DG, 'YYYY/MM/DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("     ELSE ''" ).append("\n"); 
		query.append("END DG,ORD,L_N0" ).append("\n"); 
		query.append("from " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  select distinct FULL_RTN_YD_CD yd_cd,GEN,RF,DG , ord" ).append("\n"); 
		query.append("  from" ).append("\n"); 
		query.append("  ( " ).append("\n"); 
		query.append("    SELECT FULL_RTN_YD_CD," ).append("\n"); 
		query.append("      DECODE(RF_SPCL_FLG,'Y',NULL,DECODE(DG_SPCL_FLG,'Y',NULL,to_char(CCT,'yyyy-mm-dd hh24:miss'))) GEN," ).append("\n"); 
		query.append("    DECODE(RF_SPCL_FLG,'Y', to_char(CCT,'yyyy-mm-dd HH24:MI')) RF, " ).append("\n"); 
		query.append("    DECODE(DG_SPCL_FLG,'Y', to_char(CCT,'yyyy-mm-dd HH24:MI')) DG, 1 ord " ).append("\n"); 
		query.append("      FROM CCT" ).append("\n"); 
		query.append("    union all" ).append("\n"); 
		query.append("    select FULL_RTN_YD_CD , '' gen, '' rf, '' dg, 2 ord" ).append("\n"); 
		query.append("    from prd_inlnd_rout_mst " ).append("\n"); 
		query.append("    where ROUT_ORG_NOD_CD LIKE @[por]||'%' and ROUT_DEST_NOD_CD = (SELECT POL_NOD_CD FROM PRD_PROD_CTL_MST WHERE PCTL_NO=@[pctl_no]) " ).append("\n"); 
		query.append("    AND PCTL_IO_BND_CD IN ('O','B') AND NVL(DELT_FLG,'N')='N'" ).append("\n"); 
		query.append("    and FULL_RTN_YD_CD not in (SELECT FULL_RTN_YD_CD FROM CCT  )" ).append("\n"); 
		query.append("      union all" ).append("\n"); 
		query.append("      select 'input' FULL_RTN_YD_CD , '' gen, '' rf, '' dg, 3 ord" ).append("\n"); 
		query.append("      from dual" ).append("\n"); 
		query.append("    )  where FULL_RTN_YD_CD  is not null" ).append("\n"); 
		query.append(") a," ).append("\n"); 
		query.append("(SELECT CPY_NO L_N0 FROM COM_CPY_NO WHERE CPY_NO IN (1,2))b" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("order by ord,YD_CD,L_N0" ).append("\n"); 

	}
}