/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchFullRtnYdCctRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.18 
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
		params.put("to_time",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
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
		query.append("SELECT yd_cd1, yd_cd, DECODE(SPCL, 'GEN', CUT_OFF) GEN, DECODE(SPCL, 'DG', CUT_OFF) DG, DECODE(SPCL, 'RF', CUT_OFF) RF" ).append("\n"); 
		query.append("  FROM (SELECT RK" ).append("\n"); 
		query.append("              ,ORG_NOD_CD yd_cd1" ).append("\n"); 
		query.append("              ,(CASE WHEN TP LIKE '%RAIL%' THEN ORG_NOD_CD || '(rail)'" ).append("\n"); 
		query.append("                     ELSE ORG_NOD_CD" ).append("\n"); 
		query.append("               END) yd_cd" ).append("\n"); 
		query.append("              ,SPCL" ).append("\n"); 
		query.append("              ,(CASE WHEN TP LIKE '%RAIL%' THEN TO_CHAR(TO_DATE(@[from_time], 'YYYYMMDD'), 'YYYY-MM-DD HH24:MI') || ' - ' || TO_CHAR(TO_DATE(@[to_time], 'YYYYMMDD'), 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                    ELSE TO_CHAR(NVL(INLND_CCT_FNC, ARR_ST_DT), 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("               END) CUT_OFF" ).append("\n"); 
		query.append("          FROM (SELECT RANK() OVER(ORDER BY D.PCTL_SEQ) RK" ).append("\n"); 
		query.append("                      ,(CASE WHEN D.ORG_NOD_CD = M.FULL_RTN_YD_CD AND D.ORG_NOD_CD = M.HUB_NOD_CD AND SUBSTR(D.ORG_NOD_CD, 1, 2) IN('US', 'CA')  THEN 'FULL_CY_RAIL'" ).append("\n"); 
		query.append("                             WHEN D.ORG_NOD_CD = M.FULL_RTN_YD_CD AND D.ORG_NOD_CD <> M.HUB_NOD_CD THEN 'FULL_CY'" ).append("\n"); 
		query.append("                             WHEN D.ORG_NOD_CD = M.HUB_NOD_CD AND D.ORG_NOD_CD <> M.FULL_RTN_YD_CD THEN 'RAIL'" ).append("\n"); 
		query.append("                       END) TP" ).append("\n"); 
		query.append("                      ,D.ORG_NOD_CD" ).append("\n"); 
		query.append("                      ,D.ARR_ST_DT" ).append("\n"); 
		query.append("                      ,D.DEP_FSH_DT" ).append("\n"); 
		query.append("                      ,(CASE WHEN PC.RF_SPCL_FLG = 'Y' THEN 'RF'" ).append("\n"); 
		query.append("                             WHEN PC.DG_SPCL_FLG = 'Y' THEN 'DG'" ).append("\n"); 
		query.append("                             ELSE 'GEN'" ).append("\n"); 
		query.append("                       END) SPCL" ).append("\n"); 
		query.append("                      ,(LEAD(ARR_ST_DT, 1) OVER(ORDER BY D.PCTL_SEQ) - DEP_FSH_DT) * 24 TTIME" ).append("\n"); 
		query.append("                      ,PRD_GET_INLND_CCT_FNC(D.PCTL_NO) INLND_CCT_FNC" ).append("\n"); 
		query.append("                --M.FULL_RTN_YD_CD,M.HUB_NOD_CD, " ).append("\n"); 
		query.append("                  FROM PRD_PROD_CTL_ROUT_DTL D, PRD_INLND_ROUT_MST M, PRD_PROD_CTL_MST PC" ).append("\n"); 
		query.append("                 WHERE D.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                   AND D.PCTL_NO = PC.PCTL_NO" ).append("\n"); 
		query.append("                   AND D.ROUT_ORG_NOD_CD = M.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                   AND D.ROUT_DEST_NOD_CD = M.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                   AND D.ROUT_SEQ = M.ROUT_SEQ" ).append("\n"); 
		query.append("                   AND D.PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                   AND D.MTY_YD_FLG <> 'Y'" ).append("\n"); 
		query.append("                   AND D.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                   AND (D.ORG_NOD_CD = M.FULL_RTN_YD_CD OR D.ORG_NOD_CD = M.HUB_NOD_CD)" ).append("\n"); 
		query.append("				 )" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}