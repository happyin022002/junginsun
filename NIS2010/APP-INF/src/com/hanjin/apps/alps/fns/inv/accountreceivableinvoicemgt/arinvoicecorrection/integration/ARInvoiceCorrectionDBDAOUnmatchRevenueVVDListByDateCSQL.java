/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOUnmatchRevenueVVDListByDateCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.03
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.11.03 박정진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOUnmatchRevenueVVDListByDateCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INV_REV_VVD_UMCH 테이블에 Insert
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOUnmatchRevenueVVDListByDateCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOUnmatchRevenueVVDListByDateCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_REV_VVD_UMCH" ).append("\n"); 
		query.append("( AR_IF_NO" ).append("\n"); 
		query.append(",BL_SRC_NO" ).append("\n"); 
		query.append(",AR_OFC_CD" ).append("\n"); 
		query.append(",REV_VSL_CD" ).append("\n"); 
		query.append(",REV_SKD_VOY_NO" ).append("\n"); 
		query.append(",REV_SKD_DIR_CD" ).append("\n"); 
		query.append(",REV_DIR_CD" ).append("\n"); 
		query.append(",NEW_REV_VSL_CD" ).append("\n"); 
		query.append(",NEW_REV_SKD_VOY_NO" ).append("\n"); 
		query.append(",NEW_REV_SKD_DIR_CD" ).append("\n"); 
		query.append(",NEW_REV_DIR_CD" ).append("\n"); 
		query.append(",INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append(",BL_INV_IF_DT" ).append("\n"); 
		query.append(",BL_INV_CFM_DT" ).append("\n"); 
		query.append(",INV_DELT_DIV_CD" ).append("\n"); 
		query.append(",REV_SRC_CD" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",ZN_IOC_CD" ).append("\n"); 
		query.append(",NEW_RLANE_CD" ).append("\n"); 
		query.append(",OLD_REV_VSL_CD" ).append("\n"); 
		query.append(",OLD_REV_SKD_VOY_NO" ).append("\n"); 
		query.append(",OLD_REV_SKD_DIR_CD" ).append("\n"); 
		query.append(",OLD_REV_DIR_CD" ).append("\n"); 
		query.append(",TRNK_VSL_CD" ).append("\n"); 
		query.append(",TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append(",TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append(",REV_VVD_MTCH_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("AR_IF_NO" ).append("\n"); 
		query.append(",BL_SRC_NO" ).append("\n"); 
		query.append(",AR_OFC_CD" ).append("\n"); 
		query.append(",REV_VSL_CD" ).append("\n"); 
		query.append(",REV_SKD_VOY_NO" ).append("\n"); 
		query.append(",REV_SKD_DIR_CD" ).append("\n"); 
		query.append(",REV_DIR_CD" ).append("\n"); 
		query.append(",SUBSTR(@[new_vvd], 1, 4)" ).append("\n"); 
		query.append(",SUBSTR(@[new_vvd], 5, 4)" ).append("\n"); 
		query.append(",SUBSTR(@[new_vvd], 9, 1)" ).append("\n"); 
		query.append(",SUBSTR(@[new_vvd], 10, 1)" ).append("\n"); 
		query.append(",INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append(",BL_INV_IF_DT" ).append("\n"); 
		query.append(",BL_INV_CFM_DT" ).append("\n"); 
		query.append(",INV_DELT_DIV_CD" ).append("\n"); 
		query.append(",REV_SRC_CD" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",ZN_IOC_CD" ).append("\n"); 
		query.append(",@[new_lane]" ).append("\n"); 
		query.append(",SUBSTR(@[old_vvd], 1, 4)" ).append("\n"); 
		query.append(",SUBSTR(@[old_vvd], 5, 4)" ).append("\n"); 
		query.append(",SUBSTR(@[old_vvd], 9, 1)" ).append("\n"); 
		query.append(",SUBSTR(@[old_vvd], 10, 1)" ).append("\n"); 
		query.append(",TRNK_VSL_CD" ).append("\n"); 
		query.append(",TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append(",TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append(",'N'" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append("FROM INV_AR_MN" ).append("\n"); 
		query.append("WHERE BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("AND REV_TP_CD IN ('B', 'C')" ).append("\n"); 
		query.append("AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND AR_IF_NO NOT IN (SELECT DISTINCT AR_IF_NO FROM INV_REV_VVD_UMCH WHERE BL_SRC_NO = @[bl_no])" ).append("\n"); 

	}
}