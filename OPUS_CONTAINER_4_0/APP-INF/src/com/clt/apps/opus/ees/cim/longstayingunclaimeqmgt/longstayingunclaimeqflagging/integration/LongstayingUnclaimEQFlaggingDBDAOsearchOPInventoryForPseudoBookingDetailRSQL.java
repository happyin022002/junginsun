/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : LongstayingUnclaimEQFlaggingDBDAOsearchOPInventoryForPseudoBookingDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.27
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LongstayingUnclaimEQFlaggingDBDAOsearchOPInventoryForPseudoBookingDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OP Inventory for Pseudo Booking  - Detail
	  * </pre>
	  */
	public LongstayingUnclaimEQFlaggingDBDAOsearchOPInventoryForPseudoBookingDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration").append("\n"); 
		query.append("FileName : LongstayingUnclaimEQFlaggingDBDAOsearchOPInventoryForPseudoBookingDetailRSQL").append("\n"); 
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
		query.append("SELECT   O.AR_HD_QTR_OFC_CD RHQ_CD" ).append("\n"); 
		query.append("        ,B.BKG_OFC_CD BKG_OFC_CD" ).append("\n"); 
		query.append("        ,B.OB_SREP_CD" ).append("\n"); 
		query.append("        ,C.CUST_CNT_CD||LPAD(C.CUST_SEQ,6,0) CUST_CD" ).append("\n"); 
		query.append("        ,T.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("        ,A.BKG_NO" ).append("\n"); 
		query.append("        ,A.CNTR_NO" ).append("\n"); 
		query.append("        ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,A.CRNT_YD_CD YD_CD" ).append("\n"); 
		query.append("        ,(SELECT Y.YD_NM" ).append("\n"); 
		query.append("          FROM MDM_YARD Y" ).append("\n"); 
		query.append("          WHERE Y.YD_CD = A.CRNT_YD_CD" ).append("\n"); 
		query.append("          ) YD_NM" ).append("\n"); 
		query.append("        ,ROUND(CEIL(GLOBALDATE_PKG.TIME_LOCAL_FNC(A.RCC_CD) - A.CNMV_DT), 1) STAY_DAYS" ).append("\n"); 
		query.append("   FROM MST_CONTAINER A, BKG_BOOKING B, MDM_ORGANIZATION O, BKG_CUSTOMER C, MDM_CUSTOMER T " ).append("\n"); 
		query.append("	WHERE A.ACIAC_DIV_CD         = 'A'" ).append("\n"); 
		query.append("      AND A.BKG_NO             =  B.BKG_NO" ).append("\n"); 
		query.append("      AND B.VSL_CD          LIKE '%XX'" ).append("\n"); 
		query.append("      AND A.CNMV_STS_CD        = 'OP'" ).append("\n"); 
		query.append("      AND B.BKG_OFC_CD         = O.OFC_CD      " ).append("\n"); 
		query.append("      AND C.BKG_NO             = B.BKG_NO" ).append("\n"); 
		query.append("      AND C.BKG_CUST_TP_CD     = 'S'" ).append("\n"); 
		query.append("      AND T.CUST_CNT_CD        = C.CUST_CNT_CD" ).append("\n"); 
		query.append("      AND T.CUST_SEQ           = C.CUST_SEQ" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("      #if (${rhq_cd} != '')" ).append("\n"); 
		query.append("      		AND O.AR_HD_QTR_OFC_CD   = @[rhq_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      #if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("      		AND B.BKG_OFC_CD         = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      #if (${bkg_no} != '')" ).append("\n"); 
		query.append("      		AND A.BKG_NO             = @[bkg_no]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      #if (${cust_cd} != '')" ).append("\n"); 
		query.append("      		AND C.CUST_CNT_CD        = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("      		AND LPAD(C.CUST_SEQ,6,0) = SUBSTR(@[cust_cd],3)" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      #if (${cust_nm} != '')" ).append("\n"); 
		query.append("      		AND T.CUST_LGL_ENG_NM    LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      #if (${op_loc_cd} != '')" ).append("\n"); 
		query.append("      		AND A.LOC_CD             = @[op_loc_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 

	}
}