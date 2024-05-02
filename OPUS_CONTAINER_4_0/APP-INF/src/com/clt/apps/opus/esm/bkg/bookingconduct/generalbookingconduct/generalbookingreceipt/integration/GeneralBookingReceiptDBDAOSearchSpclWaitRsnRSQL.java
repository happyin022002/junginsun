/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchSpclWaitRsnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchSpclWaitRsnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSpclWaitRsn
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchSpclWaitRsnRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchSpclWaitRsnRSQL").append("\n"); 
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
		query.append("select case when spcl_not_auth_cnt > 0 then 'Y'" ).append("\n"); 
		query.append("            when spcl_cnt = 0 and chk_flag <> 'N' then 'Y' " ).append("\n"); 
		query.append("			when BFR_CRE_CNT > 0 then 'Y' ELSE 'N' end WT_RSN_SPCL_CGO_FLG" ).append("\n"); 
		query.append("from " ).append("\n"); 
		query.append("    (select sum(spcl_not_auth_cnt) spcl_not_auth_cnt, sum(spcl_cnt) spcl_cnt" ).append("\n"); 
		query.append("    from" ).append("\n"); 
		query.append("        (SELECT sum(decode(NVL(spcl_cgo_apro_Cd, 'X'), 'Y', 0, 'C', 0, 1)) spcl_not_auth_cnt, count(1) spcl_cnt" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("        FROM  bkg_dg_cgo_his" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        FROM  bkg_dg_cgo" ).append("\n"); 
		query.append("#end            " ).append("\n"); 
		query.append("        where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT sum(decode(NVL(spcl_cgo_apro_Cd, 'X'), 'Y', 0, 'C', 0, 1)) spcl_not_auth_cnt, count(1) spcl_cnt" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("        FROM  bkg_rf_cgo_his" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        FROM bkg_rf_cgo " ).append("\n"); 
		query.append("#end            " ).append("\n"); 
		query.append("        where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT sum(decode(NVL(spcl_cgo_apro_Cd, 'X'), 'Y', 0, 'C', 0, 1)) spcl_not_auth_cnt, count(1) spcl_cnt" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("        FROM  bkg_awk_cgo_his" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        FROM  bkg_awk_cgo" ).append("\n"); 
		query.append("#end            " ).append("\n"); 
		query.append("        where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT sum(decode(NVL(spcl_cgo_apro_Cd, 'X'), 'Y', 0, 'C', 0, 1)) spcl_not_auth_cnt, count(1) spcl_cnt" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("        FROM  bkg_bb_cgo_his" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        FROM  bkg_bb_cgo" ).append("\n"); 
		query.append("#end         " ).append("\n"); 
		query.append("        where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    ) approval," ).append("\n"); 
		query.append("    (select bkg_no, nvl(decode(dcgo_flg,    'N', '', 'Y')||" ).append("\n"); 
		query.append("                        decode(rc_flg,      'N', '', 'Y')||" ).append("\n"); 
		query.append("                        decode(awk_cgo_flg, 'N', '', 'Y')||" ).append("\n"); 
		query.append("                        decode(bb_cgo_flg,  'N', '', 'Y'), 'N') CHK_FLaG --하나도 없어야 'N'" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("        FROM  bkg_bkg_his" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        from bkg_booking" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("    AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") chk," ).append("\n"); 
		query.append("(SELECT SUM(BFR_CRE_CNT) BFR_CRE_CNT" ).append("\n"); 
		query.append("   FROM (SELECT 1 BFR_CRE_CNT" ).append("\n"); 
		query.append("         #if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("           FROM  BKG_BKG_HIS B" ).append("\n"); 
		query.append("         #else" ).append("\n"); 
		query.append("           FROM  BKG_BOOKING B" ).append("\n"); 
		query.append("         #end  " ).append("\n"); 
		query.append("          WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("          #if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		    AND B.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("            AND B.DCGO_FLG = 'Y'" ).append("\n"); 
		query.append("            AND NOT EXISTS (SELECT 'Y'" ).append("\n"); 
		query.append("                            #if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("        			          FROM  BKG_DG_CGO_HIS" ).append("\n"); 
		query.append("                            #else" ).append("\n"); 
		query.append("        			          FROM  BKG_DG_CGO" ).append("\n"); 
		query.append("                            #end  " ).append("\n"); 
		query.append("                             WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                             #if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		   			           AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("                             #end			" ).append("\n"); 
		query.append("						    )" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT 1 BFR_CRE_CNT" ).append("\n"); 
		query.append("		 #if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("           FROM  BKG_BKG_HIS B" ).append("\n"); 
		query.append("         #else" ).append("\n"); 
		query.append("           FROM  BKG_BOOKING B" ).append("\n"); 
		query.append("         #end  " ).append("\n"); 
		query.append("          WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		  #if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		    AND B.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("            AND B.RC_FLG = 'Y'" ).append("\n"); 
		query.append("            AND NOT EXISTS (SELECT 'Y'" ).append("\n"); 
		query.append("							#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("        			          FROM  BKG_RF_CGO_HIS" ).append("\n"); 
		query.append("						    #else" ).append("\n"); 
		query.append("        				      FROM  BKG_RF_CGO" ).append("\n"); 
		query.append("							#end  " ).append("\n"); 
		query.append("			                 WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("							 #if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		                       AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("							 #end				" ).append("\n"); 
		query.append("						    )" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("		 SELECT 1 BFR_CRE_CNT" ).append("\n"); 
		query.append("	     #if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("           FROM  BKG_BKG_HIS B" ).append("\n"); 
		query.append("         #else" ).append("\n"); 
		query.append("           FROM  BKG_BOOKING B" ).append("\n"); 
		query.append("         #end  " ).append("\n"); 
		query.append("          WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		  #if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		    AND B.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("		  #end" ).append("\n"); 
		query.append("            AND B.AWK_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("            AND NOT EXISTS (SELECT 'Y'" ).append("\n"); 
		query.append("							#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("        					  FROM  BKG_AWK_CGO_HIS" ).append("\n"); 
		query.append("							#else" ).append("\n"); 
		query.append("        					  FROM  BKG_AWK_CGO" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("                 			 WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("							 #if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		   					   AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("							 #end				" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("		 SELECT 1 BFR_CRE_CNT" ).append("\n"); 
		query.append("		 #if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("           FROM  BKG_BKG_HIS B" ).append("\n"); 
		query.append("		 #else" ).append("\n"); 
		query.append("           FROM  BKG_BOOKING B" ).append("\n"); 
		query.append("		 #end  " ).append("\n"); 
		query.append("          WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		  #if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		    AND B.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("		  #end" ).append("\n"); 
		query.append("            AND B.BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("            AND NOT EXISTS (SELECT 'Y'" ).append("\n"); 
		query.append("							#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("        					  FROM  BKG_BB_CGO_HIS" ).append("\n"); 
		query.append("							#else" ).append("\n"); 
		query.append("        					  FROM  BKG_BB_CGO" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("                             WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("							 #if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		   					   AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("							 #end				" ).append("\n"); 
		query.append("							) " ).append("\n"); 
		query.append(")) BFR_CRE_CNT" ).append("\n"); 

	}
}