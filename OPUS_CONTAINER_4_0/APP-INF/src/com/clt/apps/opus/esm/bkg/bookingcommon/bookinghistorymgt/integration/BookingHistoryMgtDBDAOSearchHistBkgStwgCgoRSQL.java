/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgStwgCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.12
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2015.01.12 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistBkgStwgCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgStwgCgoRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgStwgCgoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stwg_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stwg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_apro_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aply_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_gdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stwg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgStwgCgoRSQL").append("\n"); 
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
		query.append("WITH OLD AS " ).append("\n"); 
		query.append("(SELECT @[bkg_no] BKG_NO" ).append("\n"); 
		query.append(", @[stwg_seq] STWG_SEQ" ).append("\n"); 
		query.append(", @[stwg_rmk] STWG_RMK" ).append("\n"); 
		query.append(", @[rqst_dt] RQST_DT" ).append("\n"); 
		query.append(", @[rqst_gdt] RQST_GDT" ).append("\n"); 
		query.append(", @[rqst_usr_id] RQST_USR_ID" ).append("\n"); 
		query.append(", @[aply_no] APLY_NO" ).append("\n"); 
		query.append(", @[spcl_cgo_apro_cd] SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append(", @[stwg_cd] STWG_CD" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append("     , PRE_CTNT" ).append("\n"); 
		query.append("     , CRNT_CTNT" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT 'Stowage' HIS_CATE_NM" ).append("\n"); 
		query.append("                , OLD.STWG_CD||" ).append("\n"); 
		query.append("                  '/'||OLD.STWG_RMK" ).append("\n"); 
		query.append("				  PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.STWG_CD||" ).append("\n"); 
		query.append("                  '/'||NOW.STWG_RMK" ).append("\n"); 
		query.append("                  CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD, " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("               BKG_STWG_CGO_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO     (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO    (+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("               BKG_STWG_CGO NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO     (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND NOW.STWG_SEQ(+) = OLD.STWG_SEQ" ).append("\n"); 
		query.append("    )    " ).append("\n"); 
		query.append(" WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 

	}
}