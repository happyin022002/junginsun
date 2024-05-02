/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterTroInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.28
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2014.11.28 김진주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchXterTroInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * external request 처리를 위해 external rqst의 Tro 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterTroInterfaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchXterTroInterfaceRSQL").append("\n"); 
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
		query.append("SELECT TRO_SEQ" ).append("\n"); 
		query.append("        , SHPR_OWN_TRK_FLG  OWNR_TRK_FLG" ).append("\n"); 
		query.append("        , ACT_SHPR_NM       ACT_SHPR_NM" ).append("\n"); 
		query.append("        , CNTC_PSON_NM" ).append("\n"); 
		query.append("        , CNTC_PHN_NO_CTNT  CNTC_PHN_NO" ).append("\n"); 
		query.append("        , CNTC_MPHN_NO_CTNT CNTC_MPHN_NO" ).append("\n"); 
		query.append("        --, DOR_ZIP_ID        ZN_CD" ).append("\n"); 
		query.append("        , DOR_ZIP_ID        DOR_PST_NO " ).append("\n"); 
		query.append("        , ACT_SHPR_ADDR" ).append("\n"); 
		query.append("        , TRO_RMK  || DECODE(TRO_RMK,NULL,'', ',') ||      " ).append("\n"); 
		query.append("           BKG_JOIN_FNC(CURSOR(  SELECT 'UN No:'||IMDG_UN_NO" ).append("\n"); 
		query.append("                                        ||', IMO Class:'||IMDG_CLSS_ID " ).append("\n"); 
		query.append("                                        ||' (Requested)' TRO_RMK" ).append("\n"); 
		query.append("                                   FROM BKG_XTER_DG_CGO DG" ).append("\n"); 
		query.append("                                   WHERE XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("                                   AND XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("                                   AND XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("                                   UNION ALL" ).append("\n"); 
		query.append("                                   SELECT'Temp:'||ROUND(DECODE(MIN_TEMP_UT_CD, 'F', (5 * MIN_TEMP - 160)/9, MIN_TEMP), 1) --CDO_TEMP" ).append("\n"); 
		query.append("                                        ||', Vantilation:'||VENT_RTO||DECODE(CNTR_VENT_TP_CD, 'P', '%', 'CMH')" ).append("\n"); 
		query.append("                                        ||', Humidity:'||HUMID_RTO" ).append("\n"); 
		query.append("                                        ||'%, Drain:  (Requested)' AS TRO_RMK " ).append("\n"); 
		query.append("                                   FROM BKG_XTER_RF_CGO" ).append("\n"); 
		query.append("                                   WHERE XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("                                   AND XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("                                   AND XTER_RQST_SEQ = @[xter_rqst_seq]))        " ).append("\n"); 
		query.append("            DIFF_RMK" ).append("\n"); 
		query.append("        , (select nvl((select 'Y'" ).append("\n"); 
		query.append("              from mdm_location " ).append("\n"); 
		query.append("             where loc_cd = nvl(nvl(por_cd, pol_cd), " ).append("\n"); 
		query.append("                               (select loc_cd " ).append("\n"); 
		query.append("                                  from mdm_organization " ).append("\n"); 
		query.append("                                 where ofc_cd = bkg_ofc_cd)) " ).append("\n"); 
		query.append("               and conti_cd = 'E'), 'N')" ).append("\n"); 
		query.append("               from bkg_xter_rqst_mst" ).append("\n"); 
		query.append("               where xter_sndr_id = @[xter_sndr_id]" ).append("\n"); 
		query.append("               and xter_rqst_no = @[xter_rqst_no]" ).append("\n"); 
		query.append("               and xter_rqst_seq= @[xter_rqst_seq]" ).append("\n"); 
		query.append("          ) IS_EUR" ).append("\n"); 
		query.append("		, 'O' AS IO_BND_CD" ).append("\n"); 
		query.append("		, 'N' AS CXL_FLG" ).append("\n"); 
		query.append("        , 'N' AS RTN_TRO_FLG" ).append("\n"); 
		query.append("        , 'Y' AS BKGFLG" ).append("\n"); 
		query.append("		, 'I' AS IBFLAG" ).append("\n"); 
		query.append("  FROM BKG_XTER_TRO" ).append("\n"); 
		query.append(" WHERE XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("   AND XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("   AND XTER_RQST_SEQ= @[xter_rqst_seq]" ).append("\n"); 

	}
}