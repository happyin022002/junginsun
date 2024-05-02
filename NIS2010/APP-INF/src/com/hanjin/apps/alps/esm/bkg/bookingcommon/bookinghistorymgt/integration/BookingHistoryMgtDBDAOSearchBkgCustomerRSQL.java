/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchBkgCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.18 
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

public class BookingHistoryMgtDBDAOSearchBkgCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchBkgCustomerRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchBkgCustomerRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchBkgCustomerRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    BKG_NO" ).append("\n"); 
		query.append("    , BKG_CUST_TP_CD" ).append("\n"); 
		query.append("    , CUST_CNT_CD" ).append("\n"); 
		query.append("    , CUST_SEQ" ).append("\n"); 
		query.append("    , CUST_NM" ).append("\n"); 
		query.append("    , CUST_ADDR" ).append("\n"); 
		query.append("    , CUST_CTY_NM" ).append("\n"); 
		query.append("    , CUST_STE_CD" ).append("\n"); 
		query.append("    , CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append("    , CUST_ZIP_ID" ).append("\n"); 
		query.append("    , CUST_FAX_NO" ).append("\n"); 
		query.append("    , CUST_EML" ).append("\n"); 
		query.append("    , CUST_TP_CD" ).append("\n"); 
		query.append("    , REF_NO" ).append("\n"); 
		query.append("    , ADDR_PRN_FLG" ).append("\n"); 
		query.append("    , VAL_NM" ).append("\n"); 
		query.append("    , VAL_FAX_NO" ).append("\n"); 
		query.append("    , VAL_CD" ).append("\n"); 
		query.append("    , VAL_USR_ID" ).append("\n"); 
		query.append("    , VAL_OFC_CD" ).append("\n"); 
		query.append("    , TO_CHAR(VAL_DT, 'YYYY-MM-DD HH24:MI:SS') VAL_DT" ).append("\n"); 
		query.append("    , MTCH_FLG" ).append("\n"); 
		query.append("    , AN_SND_FLG" ).append("\n"); 
		query.append("    , CHG_DP_FLG" ).append("\n"); 
		query.append("    , ORG_CUST_CNT_CD" ).append("\n"); 
		query.append("    , ORG_CUST_SEQ" ).append("\n"); 
		query.append("    , IB_CUST_NM" ).append("\n"); 
		query.append("    , IB_CUST_ADDR" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , TO_CHAR(CRE_DT, 'YYYY-MM-DD HH24:MI:SS') CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("    , TO_CHAR(CUST_CD_UPD_DT, 'YYYY-MM-DD HH24:MI:SS') CUST_CD_UPD_DT" ).append("\n"); 
		query.append("	, EUR_CSTMS_ST_NM" ).append("\n"); 
		query.append("	, EORI_NO" ).append("\n"); 
		query.append("	, END_USR_NM" ).append("\n"); 
		query.append("  FROM BKG_CUSTOMER" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}