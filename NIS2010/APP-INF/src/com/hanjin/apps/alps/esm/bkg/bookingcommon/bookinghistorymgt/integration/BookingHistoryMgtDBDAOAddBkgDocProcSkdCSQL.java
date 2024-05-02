/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOAddBkgDocProcSkdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.02 
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

public class BookingHistoryMgtDBDAOAddBkgDocProcSkdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOAddBkgDocProcSkdCSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOAddBkgDocProcSkdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_doc_proc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOAddBkgDocProcSkdCSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y' && ${bkg_doc_proc_tp_cd} == 'CNTATC') " ).append("\n"); 
		query.append("INSERT INTO BKG_DOC_PROC_SKD_HIS(" ).append("\n"); 
		query.append("            BKG_NO" ).append("\n"); 
		query.append("          , CORR_NO" ).append("\n"); 
		query.append("          , BKG_DOC_PROC_TP_CD" ).append("\n"); 
		query.append("          , DOC_PROC_SEQ" ).append("\n"); 
		query.append("          , EVNT_DT" ).append("\n"); 
		query.append("          , EVNT_GDT" ).append("\n"); 
		query.append("          , EVNT_USR_ID" ).append("\n"); 
		query.append("          , DIFF_RMK" ).append("\n"); 
		query.append("          , DOC_PERF_DELT_FLG" ).append("\n"); 
		query.append("          , CRE_USR_ID" ).append("\n"); 
		query.append("          , CRE_DT" ).append("\n"); 
		query.append("          , UPD_USR_ID" ).append("\n"); 
		query.append("          , UPD_DT)  " ).append("\n"); 
		query.append(" VALUES (@[bkg_no]" ).append("\n"); 
		query.append("       ,'TMP0000001'" ).append("\n"); 
		query.append("       , @[bkg_doc_proc_tp_cd]" ).append("\n"); 
		query.append("       , (SELECT NVL(MAX(DOC_PROC_SEQ), 0) + 1 AS DOC_PROC_SEQ  " ).append("\n"); 
		query.append("            FROM BKG_DOC_PROC_SKD_HIS  " ).append("\n"); 
		query.append("           WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("             AND BKG_DOC_PROC_TP_CD = @[bkg_doc_proc_tp_cd])" ).append("\n"); 
		query.append("       , GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,BKG_COM_USER_LOC_FNC(@[cre_usr_id]))" ).append("\n"); 
		query.append("	   , GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', sysdate, 'GMT')" ).append("\n"); 
		query.append("       , NVL(@[evnt_usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("       , NVL(@[diff_rmk], (SELECT DOC_PROC_DESC " ).append("\n"); 
		query.append("	        FROM BKG_DOC_PROC_TP " ).append("\n"); 
		query.append("	       WHERE BKG_DOC_PROC_TP_CD = @[bkg_doc_proc_tp_cd]) )" ).append("\n"); 
		query.append("       , 'N'" ).append("\n"); 
		query.append("       , NVL(@[cre_usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("       , sysdate" ).append("\n"); 
		query.append("       , NVL(@[upd_usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("       , sysdate" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("INSERT INTO BKG_DOC_PROC_SKD(" ).append("\n"); 
		query.append("            BKG_NO" ).append("\n"); 
		query.append("          , BKG_DOC_PROC_TP_CD" ).append("\n"); 
		query.append("          , DOC_PROC_SEQ" ).append("\n"); 
		query.append("          , EVNT_DT" ).append("\n"); 
		query.append("          , EVNT_GDT" ).append("\n"); 
		query.append("          , EVNT_USR_ID" ).append("\n"); 
		query.append("          , DIFF_RMK" ).append("\n"); 
		query.append("          , DOC_PERF_DELT_FLG" ).append("\n"); 
		query.append("          , CRE_USR_ID" ).append("\n"); 
		query.append("          , CRE_DT" ).append("\n"); 
		query.append("          , UPD_USR_ID" ).append("\n"); 
		query.append("          , UPD_DT)  " ).append("\n"); 
		query.append(" VALUES (@[bkg_no]" ).append("\n"); 
		query.append("       , @[bkg_doc_proc_tp_cd]" ).append("\n"); 
		query.append("       , (SELECT NVL(MAX(DOC_PROC_SEQ), 0) + 1 AS DOC_PROC_SEQ  " ).append("\n"); 
		query.append("            FROM BKG_DOC_PROC_SKD  " ).append("\n"); 
		query.append("           WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("             AND BKG_DOC_PROC_TP_CD = @[bkg_doc_proc_tp_cd])" ).append("\n"); 
		query.append("       , GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,BKG_COM_USER_LOC_FNC(@[cre_usr_id]))" ).append("\n"); 
		query.append("	   , GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', sysdate, 'GMT')" ).append("\n"); 
		query.append("       , NVL(@[evnt_usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("       , NVL(@[diff_rmk], (SELECT DOC_PROC_DESC " ).append("\n"); 
		query.append("	        FROM BKG_DOC_PROC_TP " ).append("\n"); 
		query.append("	       WHERE BKG_DOC_PROC_TP_CD = @[bkg_doc_proc_tp_cd]) )" ).append("\n"); 
		query.append("       , 'N'" ).append("\n"); 
		query.append("       , NVL(@[cre_usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("       , sysdate" ).append("\n"); 
		query.append("       , NVL(@[upd_usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("       , sysdate" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}