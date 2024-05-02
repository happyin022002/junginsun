/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchPrdCnstInfoLinkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.22 
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

public class ProductCatalogCreateDBDAOSearchPrdCnstInfoLinkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 생성된 PC의 해당되는 prd_lnk_cnst_mgmt를 조회한다.
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSearchPrdCnstInfoLinkRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSearchPrdCnstInfoLinkRSQL").append("\n"); 
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
		query.append("SELECT NVL(C.SVC_USE_FLG, 'Y') SVC_USE_FLG" ).append("\n"); 
		query.append("      , C.LNK_ORG_NOD_CD || ' - ' || C.LNK_DEST_NOD_CD NTWK_UT_NM" ).append("\n"); 
		query.append("      , C.PCTL_CNST_ITM_NM ITM_NM" ).append("\n"); 
		query.append("      , C.TRSP_MOD_CD" ).append("\n"); 
		query.append("      , C.VSL_SLAN_CD" ).append("\n"); 
		query.append("      , C.VSL_CD || C.SKD_VOY_NO || C.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("      , C.CNTR_TP_CD" ).append("\n"); 
		query.append("      , C.CMDT_CD" ).append("\n"); 
		query.append("      , C.LNK_CNST_RMK CNST_RMK" ).append("\n"); 
		query.append("      , C.CRE_OFC_CD" ).append("\n"); 
		query.append("      , C.CRE_USR_ID" ).append("\n"); 
		query.append(" FROM PRD_LNK_CNST_MGMT C, PRD_PROD_CTL_QTY Q , PRD_PROD_CTL_ROUT_DTL D   " ).append("\n"); 
		query.append(" ,PRD_PROD_CTL_MST M   " ).append("\n"); 
		query.append(" , MDM_VSL_SVC_LANE S" ).append("\n"); 
		query.append(" WHERE d.pctl_no = @[pctl_no]  " ).append("\n"); 
		query.append(" AND M.PCTL_NO = D.PCTL_NO    " ).append("\n"); 
		query.append(" AND D.NOD_LNK_DIV_CD = 'L'   " ).append("\n"); 
		query.append(" and D.PCTL_NO = Q.PCTL_NO   " ).append("\n"); 
		query.append(" AND D.ORG_NOD_CD LIKE C.LNK_ORG_NOD_CD||'%'   " ).append("\n"); 
		query.append(" AND D.DEST_NOD_CD LIKE C.LNK_DEST_NOD_CD||'%'   " ).append("\n"); 
		query.append(" AND DECODE(D.TRSP_MOD_CD, 'VD', 'WD', D.TRSP_MOD_CD) = DECODE(C.TRSP_MOD_CD, 'AL' ,DECODE(D.TRSP_MOD_CD, 'VD', 'WD', D.TRSP_MOD_CD), C.TRSP_MOD_CD )  " ).append("\n"); 
		query.append(" AND D.VSL_SLAN_CD || ',' || DECODE(S.VSL_SVC_TP_CD, 'O', 'FDR') LIKE '%' || C.VSL_SLAN_CD || '%'" ).append("\n"); 
		query.append(" AND NVL(D.VSL_CD || D.SKD_VOY_NO || D.SKD_DIR_CD, '#') = DECODE(C.VSL_CD || C.SKD_VOY_NO || C.SKD_DIR_CD, NULL, NVL(D.VSL_CD || D.SKD_VOY_NO || D.SKD_DIR_CD, '#'), C.VSL_CD || C.SKD_VOY_NO || C.SKD_DIR_CD)" ).append("\n"); 
		query.append(" AND NVL(M.CMDT_CD,'X')  = NVL(C.CMDT_CD, NVL(M.CMDT_CD,'X'))    " ).append("\n"); 
		query.append(" AND NVL(C.DELT_FLG, 'N') <> 'Y'   " ).append("\n"); 
		query.append(" AND NVL(C.CNTR_TP_CD, Q.CNTR_TPSZ_CD)   " ).append("\n"); 
		query.append("	= DECODE(C.CNTR_TP_CD, NULL, Q.CNTR_TPSZ_CD, DECODE(SUBSTR(Q.CNTR_TPSZ_CD, 1, 1), 'T', 'T', 'O', 'S', 'F', 'S',   " ).append("\n"); 
		query.append("														--'D',DECODE(Q.CNTR_TPSZ_CD, 'D5', 'D5', 'D7', 'D7', Q.CNTR_TPSZ_CD)," ).append("\n"); 
		query.append("														--'R',DECODE(Q.CNTR_TPSZ_CD, 'R2', 'R2', 'R5', 'R5', Q.CNTR_TPSZ_CD)) )" ).append("\n"); 
		query.append("														'D',Q.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("														'R',Q.CNTR_TPSZ_CD) )" ).append("\n"); 
		query.append(" AND (   " ).append("\n"); 
		query.append("                -- 사용자 요청으로 PC생성일 기준으로 변경		" ).append("\n"); 
		query.append("			TRUNC(TO_DATE(NVL(C.EFF_FM_DT,'19000101'),'yyyy/mm/dd hh24:mi:ss')) <= M.CRE_DT AND   " ).append("\n"); 
		query.append("			M.CRE_DT < TRUNC(TO_DATE(NVL(C.EFF_TO_DT,'25000101'),'yyyy/mm/dd hh24:mi:ss')+1)   " ).append("\n"); 
		query.append("     ) " ).append("\n"); 
		query.append("AND S.VSL_SLAN_CD(+) = D.VSL_SLAN_CD" ).append("\n"); 
		query.append("ORDER BY NVL(C.SVC_USE_FLG, 'Y')" ).append("\n"); 

	}
}