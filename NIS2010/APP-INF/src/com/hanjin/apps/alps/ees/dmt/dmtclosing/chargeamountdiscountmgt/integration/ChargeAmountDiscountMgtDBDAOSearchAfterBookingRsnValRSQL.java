/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingRsnValRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOSearchAfterBookingRsnValRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOSearchAfterBookingRsnVal
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchAfterBookingRsnValRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingRsnValRSQL").append("\n"); 
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
		query.append("    NVL((" ).append("\n"); 
		query.append("        SELECT MAX(NVL(A.UCLM_FLG,'N'))||'|'||" ).append("\n"); 
		query.append("             MAX(NVL(( SELECT BB.INV_NO" ).append("\n"); 
		query.append("                FROM MNR_TTL_LSS_RQST_HDR AA, MNR_TTL_LSS_RQST_DTL BB" ).append("\n"); 
		query.append("                WHERE BB.RQST_EQ_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                AND AA.TTL_LSS_NO = BB.TTL_LSS_NO" ).append("\n"); 
		query.append("                AND BB.MNR_INV_TP_CD = 'DV' ),' '))" ).append("\n"); 
		query.append("         FROM DMT_CHG_CALC A, DMT_CHG_BKG_CNTR B" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("        AND A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("        AND A.CNTR_CYC_NO = B.CNTR_CYC_NO" ).append("\n"); 
		query.append("        AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND B.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("        AND A.DMDT_TRF_CD = @[dmdt_trf_cd] ),'N|N')||'|'||" ).append("\n"); 
		query.append("     NVL((" ).append("\n"); 
		query.append("        SELECT BKG_STS_CD FROM BKG_BOOKING" ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         ),' ')||'|'" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}