/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchPoNoByBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.22 
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

public class GeneralBookingReceiptDBDAOSearchPoNoByBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Purchase Other Number와 그외 number 정보를 조회한다. -- UI_BKG-0367-01
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchPoNoByBkgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchPoNoByBkgRSQL").append("\n"); 
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
		query.append("#if (${popuptpcd} == 'S')" ).append("\n"); 
		query.append("select '' BKG_NO, '' REF_SEQ, '' BL_NO, b.BKG_REF_TP_CD, " ).append("\n"); 
		query.append("        case  when b.BKG_REF_TP_CD='BKPO' then a.BKPO" ).append("\n"); 
		query.append("              when b.BKG_REF_TP_CD='LCNO' then a.LCNO" ).append("\n"); 
		query.append("              when b.BKG_REF_TP_CD='HINV' then a.HINV" ).append("\n"); 
		query.append("              when b.BKG_REF_TP_CD='LCDT' then a.LCDT" ).append("\n"); 
		query.append("              when b.BKG_REF_TP_CD='HPDP' then a.HPDP" ).append("\n"); 
		query.append("              when b.BKG_REF_TP_CD='OTHR' then a.OTHR" ).append("\n"); 
		query.append("              when b.BKG_REF_TP_CD='INCO' then a.INCO" ).append("\n"); 
		query.append("        end CUST_REF_NO_CTNT   " ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("        select " ).append("\n"); 
		query.append("          po_no         BKPO" ).append("\n"); 
		query.append("        , lc_no         LCNO" ).append("\n"); 
		query.append("        , inv_no_ctnt   HINV" ).append("\n"); 
		query.append("        , TO_CHAR(lc_exp_dt, 'YYYYMMDD')  LCDT" ).append("\n"); 
		query.append("        , ' '          HPDP" ).append("\n"); 
		query.append("        , ' '          OTHR" ).append("\n"); 
		query.append("        , ' '          INCO" ).append("\n"); 
		query.append("        FROM bkg_xter_rqst_mst" ).append("\n"); 
		query.append("	 where xter_sndr_id = @[xter_sndr_id]" ).append("\n"); 
		query.append("	   and xter_rqst_no = @[xter_rqst_no]" ).append("\n"); 
		query.append("	   and xter_rqst_seq= @[xter_rqst_seq]" ).append("\n"); 
		query.append("      ) a," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        select 'BKPO' BKG_REF_TP_CD from dual union all" ).append("\n"); 
		query.append("        select 'LCNO' from dual union all" ).append("\n"); 
		query.append("        select 'HINV' from dual union all" ).append("\n"); 
		query.append("        select 'LCDT' from dual union all" ).append("\n"); 
		query.append("        select 'HPDP' from dual union all" ).append("\n"); 
		query.append("        select 'OTHR' from dual union all" ).append("\n"); 
		query.append("        select 'INCO' from dual" ).append("\n"); 
		query.append("      ) b" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("SELECT B.BKG_NO " ).append("\n"); 
		query.append("      ,B.REF_SEQ" ).append("\n"); 
		query.append("      ,A.BL_NO " ).append("\n"); 
		query.append("      ,BKG_REF_TP_CD" ).append("\n"); 
		query.append("      ,CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("  FROM BKG_BKG_HIS A" ).append("\n"); 
		query.append("      ,BKG_REF_HIS B" ).append("\n"); 
		query.append(" WHERE A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("   AND A.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("   AND A.CORR_NO = B.CORR_NO(+)" ).append("\n"); 
		query.append("   AND A.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT '' AS BKG_NO" ).append("\n"); 
		query.append("      ,9999999 AS REF_SEQ" ).append("\n"); 
		query.append("      ,'' AS BL_NO" ).append("\n"); 
		query.append("      ,'POYN' AS BKG_REF_TP_CD" ).append("\n"); 
		query.append("      ,DECODE(SUM(1), NULL, 'N', 'Y') AS CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("  FROM BKG_REF_HIS" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("   AND BKG_REF_TP_CD IN ('BKPO','LCNO','HINV','LCDT','HPDP','OTHR','CTPO','INCO')" ).append("\n"); 
		query.append("   AND CUST_REF_NO_CTNT IS NOT NULL" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT '' AS BKG_NO" ).append("\n"); 
		query.append("      ,9999999 AS REF_SEQ" ).append("\n"); 
		query.append("      ,'' AS BL_NO" ).append("\n"); 
		query.append("      ,'DTYN' AS BKG_REF_TP_CD" ).append("\n"); 
		query.append("      ,DECODE(SUM(1), NULL, 'N', 'Y') AS CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("  FROM BKG_REF_DTL_HIS" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("SELECT B.BKG_NO " ).append("\n"); 
		query.append("      ,B.REF_SEQ" ).append("\n"); 
		query.append("      ,A.BL_NO " ).append("\n"); 
		query.append("      ,BKG_REF_TP_CD" ).append("\n"); 
		query.append("      ,CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("  FROM BKG_BOOKING A" ).append("\n"); 
		query.append("      ,BKG_REFERENCE B" ).append("\n"); 
		query.append(" WHERE A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("   AND A.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("--   AND B.BKG_REF_TP_CD IN ('BKPO','LCNO','HINV','LCDT','HPDP','OTHR','INCO')" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT '' AS BKG_NO" ).append("\n"); 
		query.append("      ,9999999 AS REF_SEQ" ).append("\n"); 
		query.append("      ,'' AS BL_NO" ).append("\n"); 
		query.append("      ,'POYN' AS BKG_REF_TP_CD" ).append("\n"); 
		query.append("      ,DECODE(SUM(1), NULL, 'N', 'Y') AS CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("  FROM BKG_REFERENCE" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG_REF_TP_CD IN ('BKPO','LCNO','HINV','LCDT','HPDP','OTHR','CTPO','INCO')" ).append("\n"); 
		query.append("   AND CUST_REF_NO_CTNT IS NOT NULL" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT '' AS BKG_NO" ).append("\n"); 
		query.append("      ,9999999 AS REF_SEQ" ).append("\n"); 
		query.append("      ,'' AS BL_NO" ).append("\n"); 
		query.append("      ,'DTYN' AS BKG_REF_TP_CD" ).append("\n"); 
		query.append("      ,DECODE(SUM(1), NULL, 'N', 'Y') AS CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("  FROM BKG_REF_DTL" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}