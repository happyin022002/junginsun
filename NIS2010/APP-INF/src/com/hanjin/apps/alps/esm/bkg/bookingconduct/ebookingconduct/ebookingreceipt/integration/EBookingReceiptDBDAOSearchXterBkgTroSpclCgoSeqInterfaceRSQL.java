/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterBkgTroSpclCgoSeqInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.23 
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

public class EBookingReceiptDBDAOSearchXterBkgTroSpclCgoSeqInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * external request 처리를 위해 external rqst의 BkgTroSpclCgoSeqVO 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterBkgTroSpclCgoSeqInterfaceRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOSearchXterBkgTroSpclCgoSeqInterfaceRSQL").append("\n"); 
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
		query.append("SELECT M.BKG_NO," ).append("\n"); 
		query.append("       'O'  IO_BND_CD," ).append("\n"); 
		query.append("       'N'  RTN_TRO_FLG," ).append("\n"); 
		query.append("       T.TRO_SEQ," ).append("\n"); 
		query.append("       'DG' SPCL_CGO_CD," ).append("\n"); 
		query.append("       D.DCGO_SEQ SPCL_CGO_SEQ," ).append("\n"); 
		query.append("       'I' IBFLAG" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST M, BKG_XTER_TRO T, BKG_XTER_DG_CGO D" ).append("\n"); 
		query.append("WHERE M.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND M.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND M.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND M.XTER_SNDR_ID = T.XTER_SNDR_ID" ).append("\n"); 
		query.append("AND M.XTER_RQST_NO = T.XTER_RQST_NO" ).append("\n"); 
		query.append("AND M.XTER_RQST_SEQ = T.XTER_RQST_SEQ" ).append("\n"); 
		query.append("AND T.XTER_SNDR_ID = D.XTER_SNDR_ID" ).append("\n"); 
		query.append("AND T.XTER_RQST_NO = D.XTER_RQST_NO" ).append("\n"); 
		query.append("AND T.XTER_RQST_SEQ = D.XTER_RQST_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT M.BKG_NO," ).append("\n"); 
		query.append("       'O'  IO_BND_CD," ).append("\n"); 
		query.append("       'N'  RTN_TRO_FLG," ).append("\n"); 
		query.append("       T.TRO_SEQ," ).append("\n"); 
		query.append("       'RF' SPCL_CGO_CD," ).append("\n"); 
		query.append("       R.RC_SEQ SPCL_CGO_SEQ," ).append("\n"); 
		query.append("       'I' IBFLAG" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST M, BKG_XTER_TRO T, BKG_XTER_RF_CGO R" ).append("\n"); 
		query.append("WHERE M.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND M.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND M.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND M.XTER_SNDR_ID = T.XTER_SNDR_ID" ).append("\n"); 
		query.append("AND M.XTER_RQST_NO = T.XTER_RQST_NO" ).append("\n"); 
		query.append("AND M.XTER_RQST_SEQ = T.XTER_RQST_SEQ" ).append("\n"); 
		query.append("AND T.XTER_SNDR_ID = R.XTER_SNDR_ID" ).append("\n"); 
		query.append("AND T.XTER_RQST_NO = R.XTER_RQST_NO" ).append("\n"); 
		query.append("AND T.XTER_RQST_SEQ = R.XTER_RQST_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT M.BKG_NO," ).append("\n"); 
		query.append("       'O'  IO_BND_CD," ).append("\n"); 
		query.append("       'N'  RTN_TRO_FLG," ).append("\n"); 
		query.append("       T.TRO_SEQ," ).append("\n"); 
		query.append("       'AK' SPCL_CGO_CD," ).append("\n"); 
		query.append("       A.AWK_CGO_SEQ SPCL_CGO_SEQ," ).append("\n"); 
		query.append("       'I' IBFLAG" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST M, BKG_XTER_TRO T, BKG_XTER_AWK_CGO A" ).append("\n"); 
		query.append("WHERE M.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND M.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND M.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND M.XTER_SNDR_ID = T.XTER_SNDR_ID" ).append("\n"); 
		query.append("AND M.XTER_RQST_NO = T.XTER_RQST_NO" ).append("\n"); 
		query.append("AND M.XTER_RQST_SEQ = T.XTER_RQST_SEQ" ).append("\n"); 
		query.append("AND T.XTER_SNDR_ID = A.XTER_SNDR_ID" ).append("\n"); 
		query.append("AND T.XTER_RQST_NO = A.XTER_RQST_NO" ).append("\n"); 
		query.append("AND T.XTER_RQST_SEQ = A.XTER_RQST_SEQ" ).append("\n"); 

	}
}