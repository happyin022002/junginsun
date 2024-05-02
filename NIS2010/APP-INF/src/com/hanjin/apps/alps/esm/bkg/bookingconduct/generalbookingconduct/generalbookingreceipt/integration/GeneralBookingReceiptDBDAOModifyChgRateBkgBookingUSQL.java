/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyChgRateBkgBookingUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.23
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2016.06.23 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dongsun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOModifyChgRateBkgBookingUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingReceiptDB ModifyChgRateBkgBooking
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyChgRateBkgBookingUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("taa_no_old",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no_old",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no_old",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("taa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifyChgRateBkgBookingUSQL").append("\n"); 
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
		query.append("#if (${caflag} == 'Y') " ).append("\n"); 
		query.append(" UPDATE " ).append("\n"); 
		query.append("	BKG_BKG_HIS" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("	SVC_SCP_CD =  @[svc_scp_cd]" ).append("\n"); 
		query.append("	,RFA_NO =  @[rfa_no]" ).append("\n"); 
		query.append("	,SC_NO =  @[sc_no1]" ).append("\n"); 
		query.append("	,TAA_NO = @[taa_no]" ).append("\n"); 
		query.append("    ,CTRT_CNG_TP_CD  = CASE WHEN (@[sc_no_old] <> @[sc_no1] OR @[taa_no_old] <> @[taa_no] " ).append("\n"); 
		query.append("                                                            OR (@[rfa_no_old] <> @[rfa_no] AND SUBSTR(@[rfa_no],6,1) IN ('A','C')) )" ).append("\n"); 
		query.append("                                 AND (@[sc_no_old] LIKE 'DUM%' OR @[rfa_no_old] LIKE 'DUM%' OR @[taa_no_old] LIKE 'DUM%') THEN 'D'" ).append("\n"); 
		query.append("                           WHEN @[rfa_no_old] <> @[rfa_no] AND SUBSTR(@[rfa_no_old],6,1) IN ('G','M','B') " ).append("\n"); 
		query.append("                                                           AND SUBSTR(@[rfa_no],6,1) IN ('A','C') THEN SUBSTR(@[rfa_no_old],6,1)" ).append("\n"); 
		query.append("                            ELSE CTRT_CNG_TP_CD" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("    ,PRE_SC_NO  = CASE WHEN @[sc_no_old] <> @[sc_no1] AND @[sc_no_old] LIKE 'DUM%' THEN @[sc_no_old]" ).append("\n"); 
		query.append("                       ELSE PRE_SC_NO" ).append("\n"); 
		query.append("                  END" ).append("\n"); 
		query.append("    ,PRE_RFA_NO = CASE WHEN @[rfa_no_old] <> @[rfa_no] AND @[rfa_no_old] LIKE 'DUM%' AND SUBSTR(@[rfa_no],6,1) IN ('A','C') THEN @[rfa_no_old]" ).append("\n"); 
		query.append("                       WHEN @[rfa_no_old] <> @[rfa_no] AND SUBSTR(@[rfa_no_old],6,1) IN ('G','B','M') " ).append("\n"); 
		query.append("                                                       AND SUBSTR(@[rfa_no],6,1) IN ('A','C') THEN @[rfa_no_old]" ).append("\n"); 
		query.append("                       ELSE PRE_RFA_NO" ).append("\n"); 
		query.append("                  END" ).append("\n"); 
		query.append("    ,PRE_TAA_NO = CASE WHEN @[taa_no_old] <> @[taa_no] AND @[taa_no_old] LIKE 'DUM%' THEN @[taa_no_old]" ).append("\n"); 
		query.append("                       ELSE PRE_TAA_NO" ).append("\n"); 
		query.append("                  END" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '') " ).append("\n"); 
		query.append("	,CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rep_cmdt_cd} !='')" ).append("\n"); 
		query.append("	,REP_CMDT_CD = @[rep_cmdt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE  " ).append("\n"); 
		query.append("	BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("	AND    CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE " ).append("\n"); 
		query.append("	BKG_BOOKING" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("	SVC_SCP_CD =  @[svc_scp_cd]" ).append("\n"); 
		query.append("	,RFA_NO =  @[rfa_no]" ).append("\n"); 
		query.append("	,SC_NO =  @[sc_no1]" ).append("\n"); 
		query.append("	,TAA_NO = @[taa_no]" ).append("\n"); 
		query.append("    ,CTRT_CNG_TP_CD  = CASE WHEN (@[sc_no_old] <> @[sc_no1] OR @[rfa_no_old] <> @[rfa_no] OR @[taa_no_old] <> @[taa_no]) AND" ).append("\n"); 
		query.append("                                 (@[sc_no_old] LIKE 'DUM%' OR @[rfa_no_old] LIKE 'DUM%' OR @[taa_no_old] LIKE 'DUM%') THEN 'D'" ).append("\n"); 
		query.append("                            WHEN @[rfa_no_old] <> @[rfa_no] AND SUBSTR(@[rfa_no_old],6,1) = 'G' THEN 'G'" ).append("\n"); 
		query.append("                            ELSE CTRT_CNG_TP_CD" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("    ,PRE_SC_NO  = CASE WHEN @[sc_no_old] <> @[sc_no1] AND @[sc_no_old] LIKE 'DUM%' THEN @[sc_no_old]" ).append("\n"); 
		query.append("                       ELSE PRE_SC_NO" ).append("\n"); 
		query.append("                  END" ).append("\n"); 
		query.append("    ,PRE_RFA_NO = CASE WHEN @[rfa_no_old] <> @[rfa_no] AND @[rfa_no_old] LIKE 'DUM%' THEN @[rfa_no_old]" ).append("\n"); 
		query.append("                       WHEN @[rfa_no_old] <> @[rfa_no] AND SUBSTR(@[rfa_no_old],6,1) = 'G' THEN @[rfa_no_old]" ).append("\n"); 
		query.append("                       ELSE PRE_RFA_NO" ).append("\n"); 
		query.append("                  END" ).append("\n"); 
		query.append("    ,PRE_TAA_NO = CASE WHEN @[taa_no_old] <> @[taa_no] AND @[taa_no_old] LIKE 'DUM%' THEN @[taa_no_old]" ).append("\n"); 
		query.append("                       ELSE PRE_TAA_NO" ).append("\n"); 
		query.append("                  END" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '') " ).append("\n"); 
		query.append("	,CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rep_cmdt_cd} !='')" ).append("\n"); 
		query.append("	,REP_CMDT_CD = @[rep_cmdt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE  " ).append("\n"); 
		query.append("	BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}