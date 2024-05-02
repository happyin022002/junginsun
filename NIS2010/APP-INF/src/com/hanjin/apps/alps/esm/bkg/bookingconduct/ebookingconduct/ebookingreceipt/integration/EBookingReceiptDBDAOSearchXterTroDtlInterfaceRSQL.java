/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterTroDtlInterfaceRSQL.java
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

public class EBookingReceiptDBDAOSearchXterTroDtlInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * external request 처리를 위해 external rqst의 Tro Dtl 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterTroDtlInterfaceRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOSearchXterTroDtlInterfaceRSQL").append("\n"); 
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
		query.append("SELECT TRO_SEQ" ).append("\n"); 
		query.append("        , TRO_SUB_SEQ" ).append("\n"); 
		query.append("        , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		, 'I' AS IBFLAG" ).append("\n"); 
		query.append("        , CNTR_QTY AS TRO_QTY" ).append("\n"); 
		query.append("		, TO_CHAR(DOR_RQST_DT,'YYYYMMDDHH24MI') AS DOR_ARR_DT" ).append("\n"); 
		query.append("		, '' AS CNTR_NO" ).append("\n"); 
		query.append("		, 'N' AS CXL_FLG" ).append("\n"); 
		query.append("        , PKUP_LOC_CD" ).append("\n"); 
		query.append("		, PKUP_YD_CD" ).append("\n"); 
		query.append("        , '' AS RTN_YD_CD" ).append("\n"); 
		query.append("        , '' AS RTN_LOC_CD" ).append("\n"); 
		query.append("FROM BKG_XTER_TRO_DTL" ).append("\n"); 
		query.append(" WHERE XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("   AND XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("   AND XTER_RQST_SEQ= @[xter_rqst_seq]" ).append("\n"); 

	}
}