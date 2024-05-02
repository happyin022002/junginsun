/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOremoveCustCdValInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2010.02.08 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOremoveCustCdValInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BKG_1054에서 주로 사용하고 Cusotmer Code Validation Information을 제거할 때 사용
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOremoveCustCdValInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOremoveCustCdValInfoUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CUSTOMER" ).append("\n"); 
		query.append("  SET  AN_SND_FLG = 'N'" ).append("\n"); 
		query.append("     , CHG_DP_FLG = 'N'" ).append("\n"); 
		query.append("     , CUST_CNT_CD = ORG_CUST_CNT_CD" ).append("\n"); 
		query.append("     , CUST_SEQ = ORG_CUST_SEQ" ).append("\n"); 
		query.append("     , MTCH_FLG = 'N'" ).append("\n"); 
		query.append("     , VAL_CD = DECODE(VAL_CD, 'A', 'X', NULL) -- Auto-Cancel인 경우 Match Flg는 N으로 Validation Code는 X로 처리한다" ).append("\n"); 
		query.append("     , VAL_USR_ID = NULL" ).append("\n"); 
		query.append("     , VAL_OFC_CD = NULL" ).append("\n"); 
		query.append("     , VAL_DT =  NULL" ).append("\n"); 
		query.append("     , UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("     , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND BKG_CUST_TP_CD = @[bkg_cust_tp_cd]" ).append("\n"); 

	}
}