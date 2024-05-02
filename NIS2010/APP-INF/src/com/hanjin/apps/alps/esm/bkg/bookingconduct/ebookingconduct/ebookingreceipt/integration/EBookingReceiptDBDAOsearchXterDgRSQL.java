/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterDgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.18
*@LastModifier : 윤용상
*@LastVersion : 1.0
* 2015.12.18 윤용상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YOON Yong-Sang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterDgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterDg
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterDgRSQL(){
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
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterDgRSQL").append("\n"); 
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
		query.append("SELECT nvl(DG_CNTR_SEQ,DCGO_SEQ) DG_CNTR_SEQ" ).append("\n"); 
		query.append("     , CNTR_NO" ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , nvl(CNTR_CGO_SEQ,1) CNTR_CGO_SEQ" ).append("\n"); 
		query.append("     , IMDG_UN_NO" ).append("\n"); 
		query.append("     , IMDG_UN_SEQ IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("     , IMDG_CLSS_ID IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , PRP_SHP_NM" ).append("\n"); 
		query.append("     , HZD_CTNT HZD_DESC" ).append("\n"); 
		query.append("     , FLSH_PNT_CTNT FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("     , PCK_GRP_CD1 IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("     , MRN_POLUT_FLG" ).append("\n"); 
		query.append("     , EMER_CNTC_PNT_CTNT EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append("     , DCGO_STS_CD" ).append("\n"); 
		query.append("     , DG_LMT_QTY_FLG IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("     , DCGO_RMK SPCL_STWG_RQST_DESC" ).append("\n"); 
		query.append("     , GRS_WGT" ).append("\n"); 
		query.append("     , NET_WGT" ).append("\n"); 
		query.append("     , 'KGS' WGT_UT_CD" ).append("\n"); 
		query.append("     , 'N' DG_RIDER --DG RIDER 색표시여부" ).append("\n"); 
		query.append("     , ISOL_GRP_CD as IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("     , DCGO_SEQ" ).append("\n"); 
		query.append("     , EMER_CNTC_PHN_NO_CTNT" ).append("\n"); 
		query.append("     , OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append("     , OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("  FROM BKG_XTER_DG_CGO" ).append("\n"); 
		query.append(" WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("   AND XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("   AND XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 

	}
}