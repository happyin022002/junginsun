/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchFullRtnYdCctRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.12
*@LastModifier : 조용인
*@LastVersion : 1.0
* 2010.05.12 조용인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author cho yong in
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOSearchFullRtnYdCctRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchFullRtnYdCct
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSearchFullRtnYdCctRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_time",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cct",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_time",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSearchFullRtnYdCctRSQL").append("\n"); 
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
		query.append("SELECT ARR_ST_DT -12/24 AS CCT, D.ORG_NOD_CD FULL_RTN_YD_CD,M.DG_SPCL_FLG,M.RF_SPCL_FLG" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL D, PRD_PROD_CTL_MST M" ).append("\n"); 
		query.append("WHERE D.PCTL_NO = @[pctl_no] --'B0912210000296960001'" ).append("\n"); 
		query.append("AND D.NOD_LNK_DIV_CD ='N'" ).append("\n"); 
		query.append("AND D.PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("AND D.ORG_NOD_CD =m.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("AND D.MTY_YD_FLG <> 'Y'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT yd_cd yd_cd1," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN GEN IS NOT NULL AND @[from_time] IS NOT NULL AND @[to_time] IS NOT NULL THEN yd_cd || ' (rail)'" ).append("\n"); 
		query.append("ELSE yd_cd" ).append("\n"); 
		query.append("END yd_cd," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN GEN IS NOT NULL AND yd_cd = @[port] THEN @[cct]" ).append("\n"); 
		query.append("WHEN GEN IS NOT NULL AND @[from_time] IS NOT NULL AND @[to_time] IS NOT NULL" ).append("\n"); 
		query.append("THEN TO_CHAR(TO_DATE(@[from_time] , 'YYYY/MM/DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI') || ' - ' || TO_CHAR(TO_DATE(@[to_time], 'YYYY/MM/DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("WHEN GEN IS NOT NULL THEN TO_CHAR(TO_DATE(GEN, 'YYYY/MM/DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END GEN," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN RF IS NOT NULL AND yd_cd = @[port] THEN @[cct]" ).append("\n"); 
		query.append("WHEN RF IS NOT NULL THEN TO_CHAR(TO_DATE(RF, 'YYYY/MM/DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END RF," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN DG IS NOT NULL AND yd_cd = @[port] THEN @[cct]" ).append("\n"); 
		query.append("WHEN DG IS NOT NULL THEN TO_CHAR(TO_DATE(DG, 'YYYY/MM/DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END DG, ORD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DISTINCT FULL_RTN_YD_CD yd_cd, GEN, RF, DG, ord" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT FULL_RTN_YD_CD," ).append("\n"); 
		query.append("DECODE(RF_SPCL_FLG,'Y',NULL,DECODE(DG_SPCL_FLG,'Y',NULL,to_char(CCT,'yyyy-mm-dd hh24:miss'))) GEN," ).append("\n"); 
		query.append("DECODE(RF_SPCL_FLG,'Y', to_char(CCT,'yyyy-mm-dd HH24:MI')) RF," ).append("\n"); 
		query.append("DECODE(DG_SPCL_FLG,'Y', to_char(CCT,'yyyy-mm-dd HH24:MI')) DG, 1 ord" ).append("\n"); 
		query.append("FROM CCT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT FULL_RTN_YD_CD , '' gen, '' rf, '' dg, 2 ord" ).append("\n"); 
		query.append("FROM prd_inlnd_rout_mst" ).append("\n"); 
		query.append("WHERE ROUT_ORG_NOD_CD LIKE @[por]||'%' AND ROUT_DEST_NOD_CD = (SELECT POL_NOD_CD FROM PRD_PROD_CTL_MST WHERE PCTL_NO = @[pctl_no])" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD IN ('O','B') AND NVL(DELT_FLG,'N')='N'" ).append("\n"); 
		query.append("AND FULL_RTN_YD_CD not in (SELECT FULL_RTN_YD_CD FROM CCT  )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'input' FULL_RTN_YD_CD , '' gen, '' rf, '' dg, 3 ord" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 
		query.append(") WHERE FULL_RTN_YD_CD  IS NOT NULL" ).append("\n"); 
		query.append(") a" ).append("\n"); 
		query.append("ORDER BY ord, yd_cd" ).append("\n"); 

	}
}