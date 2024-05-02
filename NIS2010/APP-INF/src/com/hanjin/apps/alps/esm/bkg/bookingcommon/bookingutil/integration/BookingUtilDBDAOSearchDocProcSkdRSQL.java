/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOSearchDocProcSkdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.09
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchDocProcSkdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDocProcSkd
	  * </pre>
	  */
	public BookingUtilDBDAOSearchDocProcSkdRSQL(){
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
		params.put("doc_perf_delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_doc_proc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchDocProcSkdRSQL").append("\n"); 
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
		query.append("#if ('Y'==${ca_flg}) " ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("       ,BKG_DOC_PROC_TP_CD" ).append("\n"); 
		query.append("       ,DOC_PROC_SEQ" ).append("\n"); 
		query.append("       ,EVNT_DT" ).append("\n"); 
		query.append("       ,EVNT_GDT" ).append("\n"); 
		query.append("       ,EVNT_USR_ID" ).append("\n"); 
		query.append("       ,DIFF_RMK" ).append("\n"); 
		query.append("       ,BKG_EVNT_CD1" ).append("\n"); 
		query.append("       ,BKG_EVNT_CD2" ).append("\n"); 
		query.append("       ,DOC_PERF_DELT_FLG" ).append("\n"); 
		query.append("       ,CRE_USR_ID" ).append("\n"); 
		query.append("       ,CRE_DT" ).append("\n"); 
		query.append("       ,UPD_USR_ID" ).append("\n"); 
		query.append("       ,UPD_DT" ).append("\n"); 
		query.append("  FROM BKG_DOC_PROC_SKD_HIS" ).append("\n"); 
		query.append(" WHERE @[bkg_no] = BKG_NO" ).append("\n"); 
		query.append("   AND 'TMP0000001' = CORR_NO" ).append("\n"); 
		query.append("   AND @[bkg_doc_proc_tp_cd] = BKG_DOC_PROC_TP_CD" ).append("\n"); 
		query.append("   AND @[doc_perf_delt_flg] = DOC_PERF_DELT_FLG" ).append("\n"); 
		query.append("   AND 1 = ROWNUM" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("       ,BKG_DOC_PROC_TP_CD" ).append("\n"); 
		query.append("       ,DOC_PROC_SEQ" ).append("\n"); 
		query.append("       ,EVNT_DT" ).append("\n"); 
		query.append("       ,EVNT_GDT" ).append("\n"); 
		query.append("       ,EVNT_USR_ID" ).append("\n"); 
		query.append("       ,DIFF_RMK" ).append("\n"); 
		query.append("       ,BKG_EVNT_CD1" ).append("\n"); 
		query.append("       ,BKG_EVNT_CD2" ).append("\n"); 
		query.append("       ,DOC_PERF_DELT_FLG" ).append("\n"); 
		query.append("       ,CRE_USR_ID" ).append("\n"); 
		query.append("       ,CRE_DT" ).append("\n"); 
		query.append("       ,UPD_USR_ID" ).append("\n"); 
		query.append("       ,UPD_DT" ).append("\n"); 
		query.append("  FROM BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append(" WHERE @[bkg_no] = BKG_NO" ).append("\n"); 
		query.append("   AND @[bkg_doc_proc_tp_cd] = BKG_DOC_PROC_TP_CD" ).append("\n"); 
		query.append("   AND @[doc_perf_delt_flg] = DOC_PERF_DELT_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}