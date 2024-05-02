/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchPoNoByCmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 전성진
*@LastVersion : 1.0
* 2009.09.21 전성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung Jin Jeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchPoNoByCmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CM 별 Purchase Other Number와 그외 number 정보를 조회한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchPoNoByCmRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchPoNoByCmRSQL").append("\n"); 
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
		query.append("''          BKG_NO" ).append("\n"); 
		query.append(", ''          REF_SEQ" ).append("\n"); 
		query.append(", CNTR_NO     CNTR_NO" ).append("\n"); 
		query.append(", PO_NO       PO_NO" ).append("\n"); 
		query.append(", ''          ITM_NO" ).append("\n"); 
		query.append(", ''          ITM_DESC" ).append("\n"); 
		query.append(", PCK_QTY       PCK_QTY" ).append("\n"); 
		query.append(", PCK_TP_CD     PCK_TP_CD" ).append("\n"); 
		query.append(", CNTR_MF_WGT   CNTR_WGT" ).append("\n"); 
		query.append(", ''		WGT_UT_CD" ).append("\n"); 
		query.append(", MEAS_QTY      MEAS_QTY" ).append("\n"); 
		query.append(", ''		MEAS_UT_CD" ).append("\n"); 
		query.append("FROM BKG_XTER_CNTR_MK_DESC" ).append("\n"); 
		query.append("where xter_sndr_id = @[xter_sndr_id]" ).append("\n"); 
		query.append("and xter_rqst_no = @[xter_rqst_no]" ).append("\n"); 
		query.append("and xter_rqst_seq= @[xter_rqst_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("REF_SEQ," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("PO_NO," ).append("\n"); 
		query.append("ITM_NO," ).append("\n"); 
		query.append("ITM_DESC," ).append("\n"); 
		query.append("PCK_QTY," ).append("\n"); 
		query.append("PCK_TP_CD," ).append("\n"); 
		query.append("CNTR_WGT," ).append("\n"); 
		query.append("WGT_UT_CD," ).append("\n"); 
		query.append("MEAS_QTY," ).append("\n"); 
		query.append("MEAS_UT_CD" ).append("\n"); 
		query.append("FROM BKG_REF_DTL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND DE_NO IS NULL" ).append("\n"); 
		query.append("AND PRT_NO IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}