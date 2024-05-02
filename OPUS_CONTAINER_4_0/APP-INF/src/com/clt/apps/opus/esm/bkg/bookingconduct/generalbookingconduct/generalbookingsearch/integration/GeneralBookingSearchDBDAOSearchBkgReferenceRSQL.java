/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchBkgReferenceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.10
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2015.09.10 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchBkgReferenceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchBkgReferenceRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchBkgReferenceRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    SUBSTR(V1.BKG_REF_TP_CD, 2, 5) BKG_REF_TP_CD" ).append("\n"); 
		query.append("   ,V1.BKG_REF_TP_NM" ).append("\n"); 
		query.append("   ,V2.REF_SEQ" ).append("\n"); 
		query.append("   ,V2.CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("   ,V2.CPY_DESC_FLG" ).append("\n"); 
		query.append("   ,@[bkg_no] BKG_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (        " ).append("\n"); 
		query.append("        SELECT  '1FINV' BKG_REF_TP_CD" ).append("\n"); 
		query.append("               ,'Invoice Ref. No.' BKG_REF_TP_NM" ).append("\n"); 
		query.append("        FROM    DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  '2EBRF' BKG_REF_TP_CD" ).append("\n"); 
		query.append("               ,'BKG Ref. No.' BKG_REF_TP_NM" ).append("\n"); 
		query.append("        FROM    DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  '3EBSH' BKG_REF_TP_CD" ).append("\n"); 
		query.append("               ,'BKG SH Ref. No.' BKG_REF_TP_NM" ).append("\n"); 
		query.append("        FROM    DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  '4EBFF' BKG_REF_TP_CD" ).append("\n"); 
		query.append("               ,'BKG FF Ref. No.' BKG_REF_TP_NM" ).append("\n"); 
		query.append("        FROM    DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  '5ESRF' BKG_REF_TP_CD" ).append("\n"); 
		query.append("               ,'S/I Ref. No.' BKG_REF_TP_NM" ).append("\n"); 
		query.append("        FROM    DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  '6ESSH' BKG_REF_TP_CD" ).append("\n"); 
		query.append("               ,'S/I SH Ref. No.' BKG_REF_TP_NM" ).append("\n"); 
		query.append("        FROM    DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  '7ESFF' BKG_REF_TP_CD" ).append("\n"); 
		query.append("               ,'S/I FF Ref. No.' BKG_REF_TP_NM" ).append("\n"); 
		query.append("        FROM    DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  '8RGBK' BKG_REF_TP_CD" ).append("\n"); 
		query.append("               ,'Regional BKG No.' BKG_REF_TP_NM" ).append("\n"); 
		query.append("        FROM    DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  '9XMRN' BKG_REF_TP_CD" ).append("\n"); 
		query.append("               ,'Export MRN No.' BKG_REF_TP_NM" ).append("\n"); 
		query.append("        FROM    DUAL" ).append("\n"); 
		query.append("    ) V1," ).append("\n"); 
		query.append("(    " ).append("\n"); 
		query.append("SELECT  BKG_REF_TP_CD" ).append("\n"); 
		query.append("        , REF_SEQ" ).append("\n"); 
		query.append("        , CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("        , CPY_DESC_FLG" ).append("\n"); 
		query.append("        , BKG_NO" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("        FROM    BKG_REF_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		FROM    BKG_REFERENCE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        WHERE   BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("        AND     CORR_NO = 'TMP0000001'   " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("AND     BKG_REF_TP_CD = 'FINV'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("select BKG_REF_TP_CD" ).append("\n"); 
		query.append("        , REF_SEQ" ).append("\n"); 
		query.append("        , CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("        , CPY_DESC_FLG" ).append("\n"); 
		query.append("        , BKG_NO" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("        FROM    BKG_REF_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		FROM    BKG_REFERENCE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        WHERE   BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("        AND     CORR_NO = 'TMP0000001'   " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("AND     BKG_REF_TP_CD = 'EBRF'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("select BKG_REF_TP_CD" ).append("\n"); 
		query.append("        , MAX(REF_SEQ) REF_SEQ" ).append("\n"); 
		query.append("        , MAX(NVL(CUST_REF_NO_CTNT, SHPR_REF_NO)) CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("        , CPY_DESC_FLG" ).append("\n"); 
		query.append("        , REF.BKG_NO" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("        FROM    BKG_REF_HIS REF, BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		FROM    BKG_REFERENCE REF, BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        WHERE   REF.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("        AND     CORR_NO = 'TMP0000001'   " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("AND     REF.BKG_NO = MST.BKG_NO(+)" ).append("\n"); 
		query.append("AND     'B'        = MST.DOC_TP_CD(+)" ).append("\n"); 
		query.append("AND     REF.BKG_REF_TP_CD = 'EBSH'" ).append("\n"); 
		query.append("GROUP BY BKG_REF_TP_CD" ).append("\n"); 
		query.append("        , CPY_DESC_FLG" ).append("\n"); 
		query.append("        , REF.BKG_NO" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("select BKG_REF_TP_CD" ).append("\n"); 
		query.append("        , MAX(REF_SEQ) REF_SEQ" ).append("\n"); 
		query.append("        , MAX(NVL(CUST_REF_NO_CTNT, FWRD_REF_NO)) CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("        , CPY_DESC_FLG" ).append("\n"); 
		query.append("        , REF.BKG_NO" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("        FROM    BKG_REF_HIS REF, BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		FROM    BKG_REFERENCE REF, BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        WHERE   REF.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("        AND     CORR_NO = 'TMP0000001'   " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("AND     REF.BKG_NO = MST.BKG_NO(+)" ).append("\n"); 
		query.append("AND     'B'        = MST.DOC_TP_CD(+)" ).append("\n"); 
		query.append("AND     REF.BKG_REF_TP_CD = 'EBFF'" ).append("\n"); 
		query.append("GROUP BY BKG_REF_TP_CD" ).append("\n"); 
		query.append("        , CPY_DESC_FLG" ).append("\n"); 
		query.append("        , REF.BKG_NO" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("select BKG_REF_TP_CD" ).append("\n"); 
		query.append("        , REF_SEQ" ).append("\n"); 
		query.append("        , CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("        , CPY_DESC_FLG" ).append("\n"); 
		query.append("        , BKG_NO" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("        FROM    BKG_REF_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		FROM    BKG_REFERENCE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        WHERE   BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("        AND     CORR_NO = 'TMP0000001'   " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("AND     BKG_REF_TP_CD = 'ESRF'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("select BKG_REF_TP_CD" ).append("\n"); 
		query.append("        , MAX(REF_SEQ) REF_SEQ" ).append("\n"); 
		query.append("        , MAX(NVL(CUST_REF_NO_CTNT, SHPR_REF_NO)) CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("        , CPY_DESC_FLG" ).append("\n"); 
		query.append("        , REF.BKG_NO" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("        FROM    BKG_REF_HIS REF, BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		FROM    BKG_REFERENCE REF, BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        WHERE   REF.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("        AND     CORR_NO = 'TMP0000001'   " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("AND     REF.BKG_NO = MST.BKG_NO(+)" ).append("\n"); 
		query.append("AND     'S'        = MST.DOC_TP_CD(+)" ).append("\n"); 
		query.append("AND     REF.BKG_REF_TP_CD = 'ESSH'" ).append("\n"); 
		query.append("GROUP BY BKG_REF_TP_CD" ).append("\n"); 
		query.append("        , CPY_DESC_FLG" ).append("\n"); 
		query.append("        , REF.BKG_NO" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("select BKG_REF_TP_CD" ).append("\n"); 
		query.append("        , MAX(REF_SEQ) REF_SEQ" ).append("\n"); 
		query.append("        , MAX(NVL(CUST_REF_NO_CTNT, FWRD_REF_NO)) CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("        , CPY_DESC_FLG" ).append("\n"); 
		query.append("        , REF.BKG_NO" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("        FROM    BKG_REF_HIS REF, BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		FROM    BKG_REFERENCE REF, BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        WHERE   REF.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("        AND     CORR_NO = 'TMP0000001'   " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("AND     REF.BKG_NO = MST.BKG_NO(+)" ).append("\n"); 
		query.append("AND     'S'        = MST.DOC_TP_CD(+)" ).append("\n"); 
		query.append("AND     REF.BKG_REF_TP_CD = 'ESFF'" ).append("\n"); 
		query.append("GROUP BY BKG_REF_TP_CD" ).append("\n"); 
		query.append("        , CPY_DESC_FLG" ).append("\n"); 
		query.append("        , REF.BKG_NO" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT  BKG_REF_TP_CD" ).append("\n"); 
		query.append("        , REF_SEQ" ).append("\n"); 
		query.append("        , CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("        , CPY_DESC_FLG" ).append("\n"); 
		query.append("        , BKG_NO" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("        FROM    BKG_REF_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		FROM    BKG_REFERENCE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        WHERE   BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("        AND     CORR_NO = 'TMP0000001'   " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("AND     BKG_REF_TP_CD = 'RGBK'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT  BKG_REF_TP_CD" ).append("\n"); 
		query.append("        , REF_SEQ" ).append("\n"); 
		query.append("        , CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("        , CPY_DESC_FLG" ).append("\n"); 
		query.append("        , BKG_NO" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("        FROM    BKG_REF_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		FROM    BKG_REFERENCE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        WHERE   BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("        AND     CORR_NO = 'TMP0000001'   " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("AND     BKG_REF_TP_CD = 'XMRN'" ).append("\n"); 
		query.append("    ) V2" ).append("\n"); 
		query.append("WHERE SUBSTR(V1.BKG_REF_TP_CD, 2, 5) = V2.BKG_REF_TP_CD(+)	" ).append("\n"); 
		query.append("ORDER BY V1.BKG_REF_TP_CD" ).append("\n"); 

	}
}