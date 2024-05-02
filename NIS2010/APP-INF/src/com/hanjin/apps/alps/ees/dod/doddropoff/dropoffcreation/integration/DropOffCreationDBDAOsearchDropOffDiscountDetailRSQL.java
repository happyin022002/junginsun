/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DropOffCreationDBDAOsearchDropOffDiscountDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.13
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.01.13 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DropOffCreationDBDAOsearchDropOffDiscountDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR Approval 에서 Link되는 Detail Popup
	  * </pre>
	  */
	public DropOffCreationDBDAOsearchDropOffDiscountDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_apro_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.integration").append("\n"); 
		query.append("FileName : DropOffCreationDBDAOsearchDropOffDiscountDetailRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	 A.AUTH_APRO_RQST_NO" ).append("\n"); 
		query.append("	 , A.TRO_IB_CFM_OFC_CD" ).append("\n"); 
		query.append("     , A.BKG_NO" ).append("\n"); 
		query.append("     , TO_CHAR(A.TRO_IB_CFM_DT, 'YYYY-MM-DD') TRO_IB_CFM_DT" ).append("\n"); 
		query.append("     , A.CNTR_NO" ).append("\n"); 
		query.append("     , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , A.DEL_CD" ).append("\n"); 
		query.append("     , A.CNTR_RTN_YD_CD" ).append("\n"); 
		query.append("     , TO_CHAR(A.CNTR_RTN_DT, 'YYYY-MM-DD') CNTR_RTN_DT" ).append("\n"); 
		query.append("     , A.CUST_CNT_CD || LPAD(A.CUST_SEQ, 6, '0') CUSTOMER" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("        SELECT C.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_CUSTOMER C" ).append("\n"); 
		query.append("         WHERE A.CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND A.CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("       ) CUSTOMER_NM" ).append("\n"); 
		query.append("     , A.SPCL_CUST_CNT_CD || LPAD(A.SPCL_CUST_SEQ, 6, '0') SPCL_CUSTOMER" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("        SELECT C.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_CUSTOMER C" ).append("\n"); 
		query.append("         WHERE A.SPCL_CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND A.SPCL_CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("       ) SPCL_CUSTOMER_NM" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("        SELECT F.RFA_NO" ).append("\n"); 
		query.append("          FROM DOD_DRP_OFF_CHG_TRF F" ).append("\n"); 
		query.append("          WHERE F.DRP_OFF_CHG_TRF_SEQ = A.DRP_OFF_CHG_TRF_SPCL_SEQ " ).append("\n"); 
		query.append("       ) RFA_NO" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("        SELECT F.SC_NO" ).append("\n"); 
		query.append("          FROM DOD_DRP_OFF_CHG_TRF F" ).append("\n"); 
		query.append("         WHERE F.DRP_OFF_CHG_TRF_SEQ = A.DRP_OFF_CHG_TRF_SPCL_SEQ" ).append("\n"); 
		query.append("       ) SC_NO" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , A.GEN_TRF_AMT" ).append("\n"); 
		query.append("     , A.SPCL_TRF_AMT" ).append("\n"); 
		query.append("     , A.DC_AMT" ).append("\n"); 
		query.append("     , A.TTL_AMT" ).append("\n"); 
		query.append("     , A.DC_RMK" ).append("\n"); 
		query.append("	 , A.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("     , (SELECT COUNT(1) FROM DOD_ATCH_FILE WHERE ATCH_FILE_LNK_ID = A.ATCH_FILE_LNK_ID) ATCH_FILE_LNK_CNT -- Attach File Count" ).append("\n"); 
		query.append("  FROM DOD_DRP_OFF_CHG A" ).append("\n"); 
		query.append(" WHERE AUTH_APRO_RQST_NO = @[auth_apro_rqst_no]" ).append("\n"); 

	}
}