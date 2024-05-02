/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOAddNonDgCgoTgtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOAddNonDgCgoTgtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOAddNonDgCgoTgtCSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOAddNonDgCgoTgtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_desc_cng_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOAddNonDgCgoTgtCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_NON_DG_CGO_TGT_IF" ).append("\n"); 
		query.append("        (BKG_NO" ).append("\n"); 
		query.append("		, BKG_DESC_CNG_ITM_CD" ).append("\n"); 
		query.append("		, BKG_DESC_CNG_SEQ" ).append("\n"); 
		query.append("		, CNTR_NO" ).append("\n"); 
		query.append("        , IF_SCS_FLG" ).append("\n"); 
		query.append("        , CRE_USR_ID" ).append("\n"); 
		query.append("        , CRE_DT" ).append("\n"); 
		query.append("        , UPD_USR_ID" ).append("\n"); 
		query.append("        , UPD_DT)" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append(" @[bkg_no]" ).append("\n"); 
		query.append(",@[bkg_desc_cng_itm_cd]" ).append("\n"); 
		query.append(",(SELECT NVL(MAX(BKG_DESC_CNG_SEQ)+1, 1) AS BKG_DESC_CNG_SEQ" ).append("\n"); 
		query.append("    FROM BKG_NON_DG_CGO_TGT_IF" ).append("\n"); 
		query.append("   WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     AND BKG_DESC_CNG_ITM_CD= @[bkg_desc_cng_itm_cd])" ).append("\n"); 
		query.append(",@[cntr_no]" ).append("\n"); 
		query.append(",DECODE(@[ca_flg],'Y','C','N')" ).append("\n"); 
		query.append(",'SYSTEM'" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",'SYSTEM'" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}