/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ManualARCreationDBDAOsearchRHQNoGoodInvMaxInterfaceKorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.08
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.02.08 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualARCreationDBDAOsearchRHQNoGoodInvMaxInterfaceKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRHQNoGoodInvMaxInterfaceKor
	  * </pre>
	  */
	public ManualARCreationDBDAOsearchRHQNoGoodInvMaxInterfaceKorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOsearchRHQNoGoodInvMaxInterfaceKorRSQL").append("\n"); 
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
		query.append("SELECT A.BL_SRC_NO, A.BKG_NO, A.ACT_CUST_CNT_CD, " ).append("\n"); 
		query.append("       LPAD(A.ACT_CUST_SEQ, 6, '0') ACT_CUST_SEQ, A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD LCL_VVD, A.SVC_SCP_CD, A.IO_BND_CD, " ).append("\n"); 
		query.append("       TO_CHAR(TO_DATE(A.SAIL_ARR_DT, 'YYYYMMDD'), 'YYYY-MM-DD') SAIL_ARR_DT, A.INV_SVC_SCP_CD," ).append("\n"); 
		query.append("       A.TRNK_VSL_CD||A.TRNK_SKD_VOY_NO||A.TRNK_SKD_DIR_CD Trunk_VVD, A.POR_CD, A.POL_CD, A.POD_CD, " ).append("\n"); 
		query.append("	   A.DEL_CD, A.MST_BL_NO Master_INV, A.LOCL_CURR_CD, " ).append("\n"); 
		query.append("	   A.INV_CUST_CNT_CD, A.INV_CUST_SEQ, A.REV_TP_CD, A.REV_SRC_CD," ).append("\n"); 
		query.append("       TO_CHAR(TO_DATE(A.DUE_DT, 'YYYYMMDD'), 'YYYY-MM-DD') DUE_DT, A.BKG_TEU_QTY, A.BKG_FEU_QTY, " ).append("\n"); 
		query.append("       TO_CHAR(TO_DATE(A.GL_EFF_DT, 'YYYYMMDD'), 'YYYY-MM-DD') GL_EFF_DT," ).append("\n"); 
		query.append("	   A.CUST_CR_FLG, " ).append("\n"); 
		query.append("		SUBSTR(B.CUST_REF_NO_CTNT,1,50) CUST_REF_NO1, " ).append("\n"); 
		query.append("		SUBSTR(C.CUST_REF_NO_CTNT,1,50) CUST_REF_NO2, " ).append("\n"); 
		query.append("		SUBSTR(D.CUST_REF_NO_CTNT,1,50) CUST_REF_NO3" ).append("\n"); 
		query.append("  FROM INV_AR_MN A, BKG_REFERENCE B, BKG_REFERENCE C, BKG_REFERENCE D" ).append("\n"); 
		query.append(" WHERE A.AR_IF_NO = ( SELECT MAX(AR_IF_NO)" ).append("\n"); 
		query.append("                        FROM INV_AR_MN A, MDM_ORGANIZATION B" ).append("\n"); 
		query.append("                       WHERE A.BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("					     AND B.LOC_CD LIKE @[loc_cd]||'%'" ).append("\n"); 
		query.append("                         AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                         AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("                         AND A.BL_INV_CFM_DT IS NULL" ).append("\n"); 
		query.append("                         AND A.AR_OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("  AND A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("  AND A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("  AND A.BKG_NO = D.BKG_NO(+)" ).append("\n"); 
		query.append("  AND B.BKG_REF_TP_CD(+) = 'FINV'" ).append("\n"); 
		query.append("  AND C.BKG_REF_TP_CD(+) = 'EBRF'" ).append("\n"); 
		query.append("  AND D.BKG_REF_TP_CD(+) = 'ESRF'" ).append("\n"); 

	}
}