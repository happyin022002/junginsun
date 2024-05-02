/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchPoNoByCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.15 
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

public class GeneralBookingReceiptDBDAOSearchPoNoByCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container 별 Purchase Other Number를 조회한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchPoNoByCntrRSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOSearchPoNoByCntrRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' BKG_NO" ).append("\n"); 
		query.append(",'' REF_SEQ" ).append("\n"); 
		query.append(",'' R_CNTR_NO " ).append("\n"); 
		query.append(",'' CNTR_NO " ).append("\n"); 
		query.append(",cntr_no as C_CNTR_NO " ).append("\n"); 
		query.append(",po_no as CUST_REF_NO_CTNT " ).append("\n"); 
		query.append(",'' PCK_QTY" ).append("\n"); 
		query.append(",'' CNTR_MF_WGT" ).append("\n"); 
		query.append(",'' MEAS_QTY" ).append("\n"); 
		query.append("FROM BKG_XTER_CNTR_MK_DESC" ).append("\n"); 
		query.append(" where xter_sndr_id = @[xter_sndr_id]" ).append("\n"); 
		query.append("   and xter_rqst_no = @[xter_rqst_no]" ).append("\n"); 
		query.append("   and xter_rqst_seq= @[xter_rqst_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CTR.BKG_NO," ).append("\n"); 
		query.append("CTR.REF_SEQ," ).append("\n"); 
		query.append("CTR.R_CNTR_NO AS R_CNTR_NO," ).append("\n"); 
		query.append("CTR.CNTR_NO AS C_CNTR_NO," ).append("\n"); 
		query.append("CTR.CNTR_NO AS CNTR_NO," ).append("\n"); 
		query.append("CTR.CUST_REF_NO_CTNT," ).append("\n"); 
		query.append("MF.PCK_QTY," ).append("\n"); 
		query.append("MF.CNTR_MF_WGT," ).append("\n"); 
		query.append("MF.MEAS_QTY" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	A.BKG_NO" ).append("\n"); 
		query.append("	,A.CNTR_NO AS CNTR_NO" ).append("\n"); 
		query.append("	,B.CNTR_NO AS R_CNTR_NO" ).append("\n"); 
		query.append("	,B.REF_SEQ" ).append("\n"); 
		query.append("	,CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("    ,A.CORR_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    BKG_CNTR_HIS A, BKG_REF_HIS B" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("    AND A.CORR_NO=B.CORR_NO(+)" ).append("\n"); 
		query.append("	AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND BKG_REF_TP_CD(+)='CTPO'" ).append("\n"); 
		query.append("    AND A.CORR_NO='TMP0000001'" ).append("\n"); 
		query.append("	AND A.CNTR_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append(") CTR," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append("	,CNTR_NO" ).append("\n"); 
		query.append("    ,CORR_NO" ).append("\n"); 
		query.append("	,SUM(PCK_QTY) PCK_QTY" ).append("\n"); 
		query.append("	,SUM(CNTR_MF_WGT) CNTR_MF_WGT" ).append("\n"); 
		query.append("	,SUM(MEAS_QTY) MEAS_QTY" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	BKG_CNTR_MF_DESC_HIS" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("	BKG_NO,CNTR_NO,CORR_NO" ).append("\n"); 
		query.append(") MF" ).append("\n"); 
		query.append("WHERE CTR.BKG_NO = MF.BKG_NO(+)" ).append("\n"); 
		query.append("AND CTR.CNTR_NO = MF.CNTR_NO(+)" ).append("\n"); 
		query.append("AND CTR.CORR_NO = MF.CORR_NO(+)" ).append("\n"); 
		query.append("ORDER BY 4 DESC" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CTR.BKG_NO," ).append("\n"); 
		query.append("CTR.REF_SEQ," ).append("\n"); 
		query.append("CTR.R_CNTR_NO AS R_CNTR_NO," ).append("\n"); 
		query.append("CTR.CNTR_NO AS C_CNTR_NO," ).append("\n"); 
		query.append("CTR.CNTR_NO AS CNTR_NO," ).append("\n"); 
		query.append("CTR.CUST_REF_NO_CTNT," ).append("\n"); 
		query.append("MF.PCK_QTY," ).append("\n"); 
		query.append("MF.CNTR_MF_WGT," ).append("\n"); 
		query.append("MF.MEAS_QTY" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	A.BKG_NO" ).append("\n"); 
		query.append("	,A.CNTR_NO AS CNTR_NO" ).append("\n"); 
		query.append("	,B.CNTR_NO AS R_CNTR_NO" ).append("\n"); 
		query.append("	,B.REF_SEQ" ).append("\n"); 
		query.append("	,CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("	BKG_CONTAINER A, BKG_REFERENCE B" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("	AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND BKG_REF_TP_CD(+)='CTPO'" ).append("\n"); 
		query.append("	AND A.CNTR_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append(") CTR," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append("	,CNTR_NO" ).append("\n"); 
		query.append("	,SUM(PCK_QTY) PCK_QTY" ).append("\n"); 
		query.append("	,SUM(CNTR_MF_WGT) CNTR_MF_WGT" ).append("\n"); 
		query.append("	,SUM(MEAS_QTY) MEAS_QTY" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("	BKG_NO,CNTR_NO" ).append("\n"); 
		query.append(") MF" ).append("\n"); 
		query.append("WHERE CTR.BKG_NO = MF.BKG_NO(+)" ).append("\n"); 
		query.append("AND CTR.CNTR_NO = MF.CNTR_NO(+)" ).append("\n"); 
		query.append("ORDER BY 4 DESC	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}