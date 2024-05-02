/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchOpusTroRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.22
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.02.22 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchOpusTroRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOpusTro
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchOpusTroRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchOpusTroRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("		SELECT TRO_SEQ" ).append("\n"); 
		query.append("				, NVL(TRO.OWNR_TRK_FLG, 'N') OWNR_TRK_FLG" ).append("\n"); 
		query.append("				, DECODE(TRO.CXL_FLG,'Y','Cancelled'," ).append("\n"); 
		query.append("				  (SELECT /*+ INDEX_DESC (BKG_TRO_XTER_IF XPKBKG_TRO_XTER_IF) */" ).append("\n"); 
		query.append("						  DECODE(TRO.CXL_FLG, 'Y', 'Cancelled', DECODE(XIF.ACK_STS_CD, 'A', 'Success', 'N', 'Error'," ).append("\n"); 
		query.append("												 'S', 'Success', 'R', 'Error', XIF.ACK_STS_CD))" ).append("\n"); 
		query.append("					 FROM BKG_TRO_XTER_IF XIF " ).append("\n"); 
		query.append("					WHERE XIF.BKG_NO      = TRO.BKG_NO" ).append("\n"); 
		query.append("					  AND XIF.IO_BND_CD   = TRO.IO_BND_CD" ).append("\n"); 
		query.append("					  AND XIF.RTN_TRO_FLG = TRO.RTN_TRO_FLG" ).append("\n"); 
		query.append("					  AND XIF.TRO_SEQ     = TRO.TRO_SEQ" ).append("\n"); 
		query.append("					  AND ROWNUM = 1 " ).append("\n"); 
		query.append("				  )) REQUEST_RESULT " ).append("\n"); 
		query.append("				, TO_CHAR(TRO.RQST_DT, 'YYYY-MM-DD HH24:MI') RQST_DT" ).append("\n"); 
		query.append("				, ACT_SHPR_NM" ).append("\n"); 
		query.append("				, CNTC_PSON_NM" ).append("\n"); 
		query.append("				, ACT_SHPR_PHN_NO CNTC_PHN_NO" ).append("\n"); 
		query.append("				, CNTC_MPHN_NO" ).append("\n"); 
		query.append("				, DOR_PST_NO DOR_PST_NO " ).append("\n"); 
		query.append("				, ACT_SHPR_ADDR" ).append("\n"); 
		query.append("				, DIFF_RMK " ).append("\n"); 
		query.append("				, NVL(TRO.CXL_FLG, 'N') CXL_FLG " ).append("\n"); 
		query.append("				, NVL(TRO.CFM_FLG, 'N') CFM_FLG" ).append("\n"); 
		query.append("				, 'N'                   IS_EUR" ).append("\n"); 
		query.append("                , IO_BND_CD" ).append("\n"); 
		query.append("				, ''                    CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    			, XTER_TRO_SEQ" ).append("\n"); 
		query.append("		 FROM BKG_TRO TRO" ).append("\n"); 
		query.append("		 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		 AND RTN_TRO_FLG = 'N'" ).append("\n"); 
		query.append("		UNION ALL        " ).append("\n"); 
		query.append("		SELECT DISTINCT TRO_SEQ" ).append("\n"); 
		query.append("		, 'N'                   OWNR_TRK_FLG" ).append("\n"); 
		query.append("		, decode(CXL_FLG,'Y','Canceled','') REQUEST_RESULT" ).append("\n"); 
		query.append("		, ''                    RQST_DT" ).append("\n"); 
		query.append("		, ''                    ACT_SHPR_NM" ).append("\n"); 
		query.append("		, ''                    CNTC_PSON_NM" ).append("\n"); 
		query.append("		, ''                    CNTC_PHN_NO" ).append("\n"); 
		query.append("		, ''                    CNTC_MPHN_NO" ).append("\n"); 
		query.append("		, ''                    DOR_PST_NO " ).append("\n"); 
		query.append("		, ''                    ACT_SHPR_ADDR" ).append("\n"); 
		query.append("		, SPCL_INSTR_RMK    DIFF_RMK " ).append("\n"); 
		query.append("		, NVL(CXL_FLG, 'N') CXL_FLG  " ).append("\n"); 
		query.append("		, NVL(CFM_FLG, 'N') CFM_FLG" ).append("\n"); 
		query.append("		, 'Y'                   IS_EUR" ).append("\n"); 
		query.append("        , IO_BND_CD" ).append("\n"); 
		query.append("		, CNTR_TPSZ_CD          CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		, XTER_TRO_SEQ" ).append("\n"); 
		query.append("		FROM BKG_EUR_TRO" ).append("\n"); 
		query.append("		WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" ORDER BY TRO_SEQ" ).append("\n"); 

	}
}