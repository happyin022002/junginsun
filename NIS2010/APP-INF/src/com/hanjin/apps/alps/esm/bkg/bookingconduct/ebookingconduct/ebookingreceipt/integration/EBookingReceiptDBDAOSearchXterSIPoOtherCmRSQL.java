/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterSIPoOtherCmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.24
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.08.24 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchXterSIPoOtherCmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * alps의 export/import licens no를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterSIPoOtherCmRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOSearchXterSIPoOtherCmRSQL").append("\n"); 
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
		query.append("SELECT DECODE(NVL(REF_SEQ,0),0,'I','U') IBFLAG," ).append("\n"); 
		query.append("       X.BKG_NO," ).append("\n"); 
		query.append("       REF_SEQ," ).append("\n"); 
		query.append("       X.CNTR_NO," ).append("\n"); 
		query.append("       X.PO_NO," ).append("\n"); 
		query.append("       NVL(X.ITM_NO , BR.ITM_NO)  ITM_NO," ).append("\n"); 
		query.append("       NVL(X.ITM_DESC, BR.ITM_DESC) ITM_DESC," ).append("\n"); 
		query.append("       NVL(X.PCK_QTY, BR.PCK_QTY) PCK_QTY," ).append("\n"); 
		query.append("       NVL(X.PCK_TP_CD, BR.PCK_TP_CD) PCK_TP_CD," ).append("\n"); 
		query.append("       NVL(X.CNTR_WGT, BR.CNTR_WGT) CNTR_WGT," ).append("\n"); 
		query.append("       NVL(X.WGT_UT_CD, BR.WGT_UT_CD) WGT_UT_CD," ).append("\n"); 
		query.append("       NVL(X.MEAS_QTY, BR.MEAS_QTY) MEAS_QTY," ).append("\n"); 
		query.append("       NVL(X.MEAS_UT_CD, BR.MEAS_UT_CD) MEAS_UT_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT MST.BKG_NO" ).append("\n"); 
		query.append("        , XC.PO_NO" ).append("\n"); 
		query.append("        , XC.SHP_REF_NO ITM_NO" ).append("\n"); 
		query.append("        , '' ITM_DESC" ).append("\n"); 
		query.append("        , XC.PCK_QTY" ).append("\n"); 
		query.append("        , XC.PCK_TP_CD" ).append("\n"); 
		query.append("        , XC.CNTR_WGT" ).append("\n"); 
		query.append("        , XC.WGT_UT_CD" ).append("\n"); 
		query.append("        , XC.MEAS_QTY" ).append("\n"); 
		query.append("        , XC.MEAS_UT_CD" ).append("\n"); 
		query.append("        , XC.CNTR_NO" ).append("\n"); 
		query.append("    FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("         ,BKG_XTER_CNTR XC     " ).append("\n"); 
		query.append("    WHERE MST.XTER_SNDR_ID  = @[xter_sndr_id]" ).append("\n"); 
		query.append("    AND MST.XTER_RQST_NO  = @[xter_rqst_no]" ).append("\n"); 
		query.append("    AND MST.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("    AND MST.XTER_SNDR_ID  = XC.XTER_SNDR_ID" ).append("\n"); 
		query.append("    AND MST.XTER_RQST_NO  = XC.XTER_RQST_NO" ).append("\n"); 
		query.append("    AND MST.XTER_RQST_SEQ = XC.XTER_RQST_SEQ" ).append("\n"); 
		query.append("    AND XC.PO_NO IS NOT NULL) X" ).append("\n"); 
		query.append("    ,BKG_REF_DTL BR" ).append("\n"); 
		query.append("WHERE X.BKG_NO = BR.BKG_NO(+)" ).append("\n"); 
		query.append("AND X.CNTR_NO = BR.CNTR_NO(+)" ).append("\n"); 
		query.append("AND NVL(BR.DE_NO(+),'N') = 'N'" ).append("\n"); 
		query.append("AND NVL(BR.PRT_NO(+),'N') = 'N'" ).append("\n"); 

	}
}