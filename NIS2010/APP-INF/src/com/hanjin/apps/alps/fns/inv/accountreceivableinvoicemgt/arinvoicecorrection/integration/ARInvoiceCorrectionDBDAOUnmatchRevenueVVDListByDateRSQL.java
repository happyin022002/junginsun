/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOUnmatchRevenueVVDListByDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.12.03 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi,Woo-Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOUnmatchRevenueVVDListByDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INV_AR_MN, INV_AR_CHG, INV_REV_VVD_UMCH 테이블에서 select
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOUnmatchRevenueVVDListByDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_if_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOUnmatchRevenueVVDListByDateRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("DECODE(NVL(REV_VVD_MTCH_FLG,'N'),'Y',1,0) REV_VVD_MTCH_FLG" ).append("\n"); 
		query.append(",AR_OFC_CD" ).append("\n"); 
		query.append(",AR_IF_NO" ).append("\n"); 
		query.append(",BL_SRC_NO" ).append("\n"); 
		query.append(",(REV_VSL_CD||REV_SKD_VOY_NO||REV_SKD_DIR_CD||REV_DIR_CD) REV_VVD" ).append("\n"); 
		query.append(",(NEW_REV_VSL_CD||NEW_REV_SKD_VOY_NO||NEW_REV_SKD_DIR_CD||NEW_REV_DIR_CD) NEW_VVD" ).append("\n"); 
		query.append(",INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append(",BL_INV_IF_DT" ).append("\n"); 
		query.append(",BL_INV_CFM_DT" ).append("\n"); 
		query.append(",INV_DELT_DIV_CD" ).append("\n"); 
		query.append(",REV_SRC_CD" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",ZN_IOC_CD" ).append("\n"); 
		query.append(",NEW_RLANE_CD" ).append("\n"); 
		query.append(",(OLD_REV_VSL_CD||OLD_REV_SKD_VOY_NO||OLD_REV_SKD_DIR_CD||OLD_REV_DIR_CD) OLD_VVD" ).append("\n"); 
		query.append(",(TRNK_VSL_CD||TRNK_SKD_VOY_NO||TRNK_SKD_DIR_CD) TRUNK_VVD" ).append("\n"); 
		query.append(",TO_CHAR(CRE_DT,'YYYY-MM-DD HH24:MI:SS') LOG_RGST_DT" ).append("\n"); 
		query.append("FROM INV_REV_VVD_UMCH" ).append("\n"); 
		query.append("#if (${bkg_if_flg} !='')" ).append("\n"); 
		query.append("WHERE NVL(REV_VVD_MTCH_FLG,'N') LIKE @[bkg_if_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY BKG_NO, BL_SRC_NO, AR_OFC_CD, AR_IF_NO" ).append("\n"); 

	}
}