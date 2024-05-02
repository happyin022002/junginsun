/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchMarkingReverseChargeByIfNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.27
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.05.27 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOSearchMarkingReverseChargeByIfNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchMarkingReverseChargeByIfNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchMarkingReverseChargeByIfNoRSQL").append("\n"); 
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
		query.append("SELECT M.AR_IF_NO" ).append("\n"); 
		query.append("      ,ACT_CUST_CNT_CD||LPAD(ACT_CUST_SEQ,6,0) ACT_CUST_CD" ).append("\n"); 
		query.append("      ,REV_TP_CD||REV_SRC_CD REV_TP_SRC" ).append("\n"); 
		query.append("      ,BL_INV_IF_DT" ).append("\n"); 
		query.append("      ,BL_INV_CFM_DT" ).append("\n"); 
		query.append("      ,INV_NO" ).append("\n"); 
		query.append("      ,C.CURR_CD" ).append("\n"); 
		query.append("      ,SUM(C.CHG_AMT) CHG_AMT" ).append("\n"); 
		query.append("      ,C.INV_XCH_RT" ).append("\n"); 
		query.append("      ,ROUND(SUM(C.CHG_AMT)*C.INV_XCH_RT,2) LOCL_AMT" ).append("\n"); 
		query.append("      ,NVL(M.RVS_CHG_FLG,'N') RVS_CHG_FLG" ).append("\n"); 
		query.append("	  ,M.AR_IF_NO MERGE_CHK" ).append("\n"); 
		query.append("  FROM INV_AR_MN M" ).append("\n"); 
		query.append("      ,INV_AR_CHG C" ).append("\n"); 
		query.append(" WHERE M.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("   AND M.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("   AND M.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("   AND NVL(M.INV_CLR_FLG,'N') = 'N'" ).append("\n"); 
		query.append(" GROUP BY M.AR_IF_NO" ).append("\n"); 
		query.append("      ,ACT_CUST_CNT_CD||LPAD(ACT_CUST_SEQ,6,0)" ).append("\n"); 
		query.append("      ,REV_TP_CD" ).append("\n"); 
		query.append("      ,REV_SRC_CD" ).append("\n"); 
		query.append("      ,BL_INV_IF_DT" ).append("\n"); 
		query.append("      ,BL_INV_CFM_DT" ).append("\n"); 
		query.append("      ,INV_NO" ).append("\n"); 
		query.append("      ,C.CURR_CD" ).append("\n"); 
		query.append("      ,C.INV_XCH_RT" ).append("\n"); 
		query.append("      ,LOCL_CURR_CD" ).append("\n"); 
		query.append("      ,NVL(M.RVS_CHG_FLG,'N')" ).append("\n"); 
		query.append("      ,M.CRE_DT" ).append("\n"); 
		query.append(" ORDER BY DECODE(REV_TP_CD,'M',1,0), AR_IF_NO, DECODE(CURR_CD, 'USD', 1, LOCL_CURR_CD, 2, 3), CURR_CD, M.CRE_DT" ).append("\n"); 

	}
}