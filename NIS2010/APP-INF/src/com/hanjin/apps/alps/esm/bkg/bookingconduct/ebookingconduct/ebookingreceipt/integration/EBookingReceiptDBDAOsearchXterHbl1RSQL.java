/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterHbl1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.15
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterHbl1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterHbl1
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterHbl1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterHbl1RSQL").append("\n"); 
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
		query.append("SELECT row_number() over (partition by HBL.BKG_NO order by HBL.BL_NO_CTNT) AS HBL_SEQ" ).append("\n"); 
		query.append("    , HBL.XTER_RQST_NO AS XTER_SI_NO" ).append("\n"); 
		query.append("	, HBL.XTER_RQST_SEQ AS XTER_SI_SEQ" ).append("\n"); 
		query.append("    , HBL.BL_NO_CTNT HBL_NO" ).append("\n"); 
		query.append("    , SH.CUST_NM SHPR_NM" ).append("\n"); 
		query.append("    , SH.CUST_ADDR SHPR_ADDR" ).append("\n"); 
		query.append("    , CN.CUST_NM CNEE_NM" ).append("\n"); 
		query.append("    , CN.CUST_ADDR CNEE_ADDR" ).append("\n"); 
		query.append("    , NF.CUST_NM NOTI_NM" ).append("\n"); 
		query.append("    , NF.CUST_ADDR NOTI_ADDR" ).append("\n"); 
		query.append("    , DECODE(HBL.XTER_RQST_VIA_CD,'SIM',HBL_CM.ESTM_WGT,HBL.ESTM_WGT) AS HBL_WGT" ).append("\n"); 
		query.append("    , DECODE(HBL.XTER_RQST_VIA_CD,'SIM',HBL_CM.ESTM_WGT_UT_CD,HBL.ESTM_WGT_UT_CD) AS WGT_UT_CD" ).append("\n"); 
		query.append("    , DECODE(HBL.XTER_RQST_VIA_CD,'SIM',HBL_CM.PCK_QTY,HBL.PCK_QTY) AS PCK_QTY" ).append("\n"); 
		query.append("    , DECODE(HBL.XTER_RQST_VIA_CD,'SIM',HBL_CM.PCK_TP_CD,HBL.PCK_TP_CD) AS PCK_TP_CD" ).append("\n"); 
		query.append("    , DECODE(HBL.XTER_RQST_VIA_CD,'SIM',HBL_CM.MEAS_QTY,HBL.MEAS_QTY) AS CMDT_MEAS_QTY" ).append("\n"); 
		query.append("    , DECODE(HBL.XTER_RQST_VIA_CD,'SIM',HBL_CM.MEAS_UT_CD,HBL.MEAS_UT_CD) AS CMDT_MEAS_UT_CD" ).append("\n"); 
		query.append("    , REPLACE(REPLACE(REPLACE(HBL.MK_DESC,  CHR(10), ''),CHR(13), ' '),'''') BL_MK_DESC    " ).append("\n"); 
		query.append("    , REPLACE(REPLACE(REPLACE(HBL.GDS_DESC, CHR(10), ''),CHR(13), ' '),'''') BL_GDS_DESC" ).append("\n"); 
		query.append("	, @[bkg_no] AS BKG_NO" ).append("\n"); 
		query.append("  FROM BKG_XTER_RQST_MST HBL, BKG_XTER_CUST SH, BKG_XTER_CUST CN, BKG_XTER_CUST NF," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("          SELECT MND.XTER_SNDR_ID,MND.XTER_RQST_NO,MND.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                ,SUM(MND.CNTR_MF_WGT) ESTM_WGT,MAX(DECODE(MND.CNTR_SEQ,1,MND.WGT_UT_CD,0)) ESTM_WGT_UT_CD,SUM(MND.PCK_QTY) PCK_QTY" ).append("\n"); 
		query.append("                ,MAX(DECODE(MND.CNTR_SEQ,1,MND.PCK_TP_CD,0)) PCK_TP_CD,SUM(MND.MEAS_QTY) MEAS_QTY,MAX(DECODE(MND.CNTR_SEQ,1,MND.MEAS_UT_CD,0)) MEAS_UT_CD" ).append("\n"); 
		query.append("            FROM BKG_XTER_CNTR_MK_DESC MND, BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("           WHERE MND.XTER_SNDR_ID = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("             AND MND.XTER_RQST_NO = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("             AND MND.XTER_RQST_SEQ = MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("             AND MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("             AND MST.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("             AND MST.BKG_NO= @[bkg_no]" ).append("\n"); 
		query.append("             AND MST.XTER_BL_TP_CD = 'H'" ).append("\n"); 
		query.append("        GROUP BY MND.XTER_SNDR_ID,MND.XTER_RQST_NO,MND.XTER_RQST_SEQ" ).append("\n"); 
		query.append("      ) HBL_CM" ).append("\n"); 
		query.append(" WHERE HBL.XTER_SNDR_ID = SH.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("   AND HBL.XTER_RQST_NO = SH.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("   AND HBL.XTER_RQST_SEQ= SH.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("   AND 'S'              = SH.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("   AND HBL.XTER_SNDR_ID = CN.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("   AND HBL.XTER_RQST_NO = CN.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("   AND HBL.XTER_RQST_SEQ= CN. XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("   AND 'C'              = CN.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("   AND HBL.XTER_SNDR_ID = NF.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("   AND HBL.XTER_RQST_NO = NF.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("   AND HBL.XTER_RQST_SEQ= NF.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("   AND 'N'              = NF.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("   AND HBL.XTER_SNDR_ID = HBL_CM.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("   AND HBL.XTER_RQST_NO = HBL_CM.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("   AND HBL.XTER_RQST_SEQ= HBL_CM.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("   AND HBL.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("   AND HBL.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("   AND HBL.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("   AND HBL.XTER_BL_TP_CD= 'H'" ).append("\n"); 
		query.append("   AND HBL.XTER_RQST_VIA_CD = (SELECT XTER_RQST_VIA_CD" ).append("\n"); 
		query.append("                                 FROM BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("                                WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("                                  AND XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("                                  AND XTER_RQST_SEQ= @[rqst_seq])" ).append("\n"); 
		query.append("ORDER BY HBL_NO ASC" ).append("\n"); 

	}
}