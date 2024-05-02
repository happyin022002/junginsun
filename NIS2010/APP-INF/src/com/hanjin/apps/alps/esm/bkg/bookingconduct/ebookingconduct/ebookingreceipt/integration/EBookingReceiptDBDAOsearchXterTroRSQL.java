/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterTroRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.26
*@LastModifier : 윤용상
*@LastVersion : 1.0
* 2016.07.26 윤용상
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

public class EBookingReceiptDBDAOsearchXterTroRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterTro
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterTroRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOsearchXterTroRSQL").append("\n"); 
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
		query.append("        , SHPR_OWN_TRK_FLG  OWNR_TRK_FLG" ).append("\n"); 
		query.append("        , ACT_SHPR_NM       ACT_SHPR_NM" ).append("\n"); 
		query.append("        , CNTC_PSON_NM" ).append("\n"); 
		query.append("        , CNTC_PHN_NO_CTNT  CNTC_PHN_NO" ).append("\n"); 
		query.append("        , CNTC_MPHN_NO_CTNT CNTC_MPHN_NO" ).append("\n"); 
		query.append("        --, DOR_ZIP_ID        ZN_CD" ).append("\n"); 
		query.append("        , DOR_ZIP_ID        DOR_PST_NO " ).append("\n"); 
		query.append("        , ACT_SHPR_ADDR" ).append("\n"); 
		query.append("        , TRO_RMK           DIFF_RMK" ).append("\n"); 
		query.append("        , (select nvl((select 'Y'" ).append("\n"); 
		query.append("              from mdm_location " ).append("\n"); 
		query.append("             where loc_cd = nvl(nvl(por_cd, pol_cd), " ).append("\n"); 
		query.append("                               (select loc_cd " ).append("\n"); 
		query.append("                                  from mdm_organization " ).append("\n"); 
		query.append("                                 where ofc_cd = bkg_ofc_cd)) " ).append("\n"); 
		query.append("               and conti_cd = 'E'), 'N')" ).append("\n"); 
		query.append("               from bkg_xter_rqst_mst" ).append("\n"); 
		query.append("               where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("               and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("               and xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("          ) IS_EUR" ).append("\n"); 
		query.append("		, CNTR_RTN_YD_CD " ).append("\n"); 
		query.append("		, CNTR_RTN_DT" ).append("\n"); 
		query.append("  FROM BKG_XTER_TRO" ).append("\n"); 
		query.append(" WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("   AND XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("   AND XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 

	}
}