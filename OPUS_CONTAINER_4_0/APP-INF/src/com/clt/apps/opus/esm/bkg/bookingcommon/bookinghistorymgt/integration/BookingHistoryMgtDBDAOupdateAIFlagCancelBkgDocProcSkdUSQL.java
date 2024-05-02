/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOupdateAIFlagCancelBkgDocProcSkdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOupdateAIFlagCancelBkgDocProcSkdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 미세관 ai flag 업데이트
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOupdateAIFlagCancelBkgDocProcSkdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mf_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_doc_proc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOupdateAIFlagCancelBkgDocProcSkdUSQL").append("\n"); 
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
		query.append("#if (${mf_no} == 'X') " ).append("\n"); 
		query.append("UPDATE BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("   SET DOC_PERF_DELT_FLG = 'Y'" ).append("\n"); 
		query.append("       , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(" WHERE BKG_NO             = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG_DOC_PROC_TP_CD = @[bkg_doc_proc_tp_cd]" ).append("\n"); 
		query.append("   AND DIFF_RMK LIKE 'Amendment%'" ).append("\n"); 
		query.append("   AND DOC_PERF_DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND DOC_PROC_SEQ = (" ).append("\n"); 
		query.append("                            SELECT MAX(DOC_PROC_SEQ)" ).append("\n"); 
		query.append("                            FROM BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("                            WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                            AND BKG_DOC_PROC_TP_CD = @[bkg_doc_proc_tp_cd]" ).append("\n"); 
		query.append("                            AND DIFF_RMK LIKE 'Amendment%'  " ).append("\n"); 
		query.append("					  )  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("   SET DOC_PERF_DELT_FLG = 'Y'" ).append("\n"); 
		query.append("       , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(" WHERE BKG_NO =@[mf_no]" ).append("\n"); 
		query.append("   AND DIFF_RMK = @[bkg_no] " ).append("\n"); 
		query.append("   AND BKG_DOC_PROC_TP_CD = @[bkg_doc_proc_tp_cd]" ).append("\n"); 
		query.append("   AND DOC_PERF_DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND DOC_PROC_SEQ = (" ).append("\n"); 
		query.append("                            SELECT MAX(DOC_PROC_SEQ)" ).append("\n"); 
		query.append("                            FROM BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("                             WHERE BKG_NO = @[mf_no]" ).append("\n"); 
		query.append("                              AND DIFF_RMK = @[bkg_no] " ).append("\n"); 
		query.append("                              AND BKG_DOC_PROC_TP_CD = @[bkg_doc_proc_tp_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}