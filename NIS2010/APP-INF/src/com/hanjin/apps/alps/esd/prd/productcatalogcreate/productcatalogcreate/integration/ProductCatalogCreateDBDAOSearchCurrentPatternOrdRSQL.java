/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchCurrentPatternOrdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOSearchCurrentPatternOrdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ProductCatalogCreateDBDAOSearchCurrentPatternOrdRSQL.Query
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSearchCurrentPatternOrdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_mapg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSearchCurrentPatternOrdRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("PCTL_NO, BKG_NO, COP_NO, CRNT_FLG, CNTR_NO, CNTR_TPSZ_CD, COP_OP_TP_CD," ).append("\n"); 
		query.append("OB_ITCHG_CTNT, MTY_PKUP_YD_CD, BKG_OP_RMK, MTY_RTN_YD_CD, IB_ITCHG_CTNT," ).append("\n"); 
		query.append("POR_NOD_CD, OCN_ITCHG_CTNT, POL_NOD_CD, BKG_RCV_TERM_CD, BKG_DE_TERM_CD," ).append("\n"); 
		query.append("OB_TRO_FLG, IB_TRO_FLG, COP_PATT_ORD_NO, COP_SO_KNT,COP_MAPG_SEQ" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT TRSP_MOD_CD FROM PRD_INLND_ROUT_MST WHERE ROUT_ORG_NOD_CD =SUBSTR(IRG_KEY,1,7)" ).append("\n"); 
		query.append("    AND ROUT_DEST_NOD_CD = SUBSTR(IRG_KEY,8,7)" ).append("\n"); 
		query.append("    AND ROUT_SEQ =SUBSTR(IRG_KEY,15)  " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(") COP_PC_OB_TRSP_MOD_CD" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT M.PCTL_NO, M.BKG_NO, M.COP_NO, CRNT_FLG, M.CNTR_NO, M.CNTR_TPSZ_CD, COP_OP_TP_CD," ).append("\n"); 
		query.append("    OB_ITCHG_CTNT, MTY_PKUP_YD_CD, BKG_OP_RMK, MTY_RTN_YD_CD, IB_ITCHG_CTNT," ).append("\n"); 
		query.append("    M.POR_NOD_CD, OCN_ITCHG_CTNT, M.POL_NOD_CD, BKG_RCV_TERM_CD, BKG_DE_TERM_CD," ).append("\n"); 
		query.append("    M.OB_TRO_FLG, M.IB_TRO_FLG, M.COP_PATT_ORD_NO, M.COP_SO_KNT,M.COP_MAPG_SEQ," ).append("\n"); 
		query.append("	row_number() over (partition by COP_PATT_ORD_NO order by COP_PATT_ORD_NO) rn," ).append("\n"); 
		query.append("	COUNT(*) OVER (PARTITION BY COP_PATT_ORD_NO) CNT" ).append("\n"); 
		query.append("	,H.PCTL_NO COP_PC" ).append("\n"); 
		query.append("    ,(SELECT ROUT_ORG_NOD_CD||ROUT_DEST_NOD_CD||ROUT_SEQ FROM PRD_PROD_CTL_ROUT_DTL D WHERE D.PCTL_NO =  H.PCTL_NO" ).append("\n"); 
		query.append("    AND  PCTL_IO_BND_CD = 'O'   " ).append("\n"); 
		query.append("    AND ROWNUM = 1 ) IRG_KEY" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	FROM PRD_BKG_COP_MAP M, SCE_COP_HDR H " ).append("\n"); 
		query.append("	WHERE COP_MAPG_SEQ=@[cop_mapg_seq]" ).append("\n"); 
		query.append("	AND M.COP_NO =H.COP_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("where rn =1 " ).append("\n"); 
		query.append("ORDER BY COP_PATT_ORD_NO,NVL(POL_NOD_CD,'AAAAA00'), CNT DESC" ).append("\n"); 

	}
}