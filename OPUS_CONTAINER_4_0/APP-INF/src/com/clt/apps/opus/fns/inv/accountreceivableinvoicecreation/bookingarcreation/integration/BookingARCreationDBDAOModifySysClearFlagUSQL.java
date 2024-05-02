/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingARCreationDBDAOModifySysClearFlagUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOModifySysClearFlagUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INV_AR_Chg 테이블에 Update
	  * inv_iss_flg,inv_clr_flg 'Y'로 업데이트
	  * </pre>
	  */
	public BookingARCreationDBDAOModifySysClearFlagUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cancel_if_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("max_if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOModifySysClearFlagUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_CHG" ).append("\n"); 
		query.append("   SET INV_ISS_FLG = 'Y'," ).append("\n"); 
		query.append("       INV_CLR_FLG = 'Y'," ).append("\n"); 
		query.append("       UPD_USR_ID	 = @[upd_usr_id]," ).append("\n"); 
		query.append("	   UPD_DT      = SYSDATE" ).append("\n"); 
		query.append(" WHERE AR_IF_NO IN (@[max_if_no],@[cancel_if_no])" ).append("\n"); 
		query.append("   AND INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("   AND INV_CLR_FLG = 'N'" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 1" ).append("\n"); 
		query.append("                 FROM INV_AR_MN " ).append("\n"); 
		query.append("                WHERE AR_IF_NO = @[max_if_no]" ).append("\n"); 
		query.append("                  AND BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                  AND INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("                  AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("                  AND AR_OFC_CD IN (SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                                        FROM INV_AR_STUP_OFC" ).append("\n"); 
		query.append("                                       WHERE AR_OFC_CD = (SELECT AR_OFC_CD FROM INV_AR_MN WHERE AR_IF_NO = @[max_if_no])" ).append("\n"); 
		query.append("                                         AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                         AND OTS_SMRY_CD IN ('INV','CLR','BL')))" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("               FROM INV_AR_MN" ).append("\n"); 
		query.append("               WHERE AR_IF_NO IN (@[max_if_no],@[cancel_if_no])" ).append("\n"); 
		query.append("               GROUP BY AR_OFC_CD, BL_SRC_NO, ACT_CUST_CNT_CD, ACT_CUST_SEQ, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("               HAVING COUNT(*) = 2)" ).append("\n"); 

	}
}