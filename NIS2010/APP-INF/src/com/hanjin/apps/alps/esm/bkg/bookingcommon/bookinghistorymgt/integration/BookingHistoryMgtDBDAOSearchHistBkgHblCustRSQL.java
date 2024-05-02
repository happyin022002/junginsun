/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgHblCustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.17 
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

public class BookingHistoryMgtDBDAOSearchHistBkgHblCustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgHblCustRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgHblCustRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_zip_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hbl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cty_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgHblCustRSQL").append("\n"); 
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
		query.append("WITH OLD AS" ).append("\n"); 
		query.append("(SELECT @[bkg_no] BKG_NO" ).append("\n"); 
		query.append(", @[hbl_seq] HBL_SEQ" ).append("\n"); 
		query.append(", @[bkg_cust_tp_cd] BKG_CUST_TP_CD" ).append("\n"); 
		query.append(", @[cust_cnt_cd] CUST_CNT_CD" ).append("\n"); 
		query.append(", @[cust_seq] CUST_SEQ" ).append("\n"); 
		query.append(", @[cust_nm] CUST_NM" ).append("\n"); 
		query.append(", @[cust_addr] CUST_ADDR" ).append("\n"); 
		query.append(", @[cust_zip_id] CUST_ZIP_ID" ).append("\n"); 
		query.append(", @[cty_nm] CTY_NM" ).append("\n"); 
		query.append(", @[ste_cd] STE_CD" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append("     , PRE_CTNT" ).append("\n"); 
		query.append("     , CRNT_CTNT" ).append("\n"); 
		query.append("	 , CNTR_MF_NO AS COLUMN1" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT 'HOUSE B/L'||DECODE(OLD.BKG_CUST_TP_CD, 'S', '-ACTUAL SHIPPER', 'C', '-ULTIMATE CONSIGNEE', 'N', '-ACTUAL NOTIFY', ' ') HIS_CATE_NM" ).append("\n"); 
		query.append("                , OLD.CUST_CNT_CD||" ).append("\n"); 
		query.append("                  '/'||OLD.CUST_SEQ||" ).append("\n"); 
		query.append("                  '/'||OLD.CUST_NM||" ).append("\n"); 
		query.append("                  '/'||OLD.CUST_ADDR PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.CUST_CNT_CD||" ).append("\n"); 
		query.append("                  '/'||NOW.CUST_SEQ||" ).append("\n"); 
		query.append("                  '/'||NOW.CUST_NM||" ).append("\n"); 
		query.append("                  '/'||NOW.CUST_ADDR CRNT_CTNT" ).append("\n"); 
		query.append("                , (" ).append("\n"); 
		query.append("                        SELECT CNTR_MF_NO" ).append("\n"); 
		query.append("                        FROM BKG_HBL" ).append("\n"); 
		query.append("                        WHERE BKG_NO = OLD.BKG_NO" ).append("\n"); 
		query.append("                        AND HBL_SEQ = OLD.HBL_SEQ" ).append("\n"); 
		query.append("                  ) CNTR_MF_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          FROM OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             , BKG_HBL_CUST_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO        (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO       (+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , BKG_HBL_CUST NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO        (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND NOW.HBL_SEQ       (+) = OLD.HBL_SEQ" ).append("\n"); 
		query.append("           AND NOW.BKG_CUST_TP_CD(+) = OLD.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("    )    " ).append("\n"); 
		query.append(" WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 

	}
}