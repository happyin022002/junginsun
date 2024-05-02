/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOCreateDocProcSkdCACSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.18 
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

public class BookingHistoryMgtDBDAOCreateDocProcSkdCACSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * copyTypeCd에 따라, BKG_DOC_PROC_SKD/BKG_DOC_PROC_SKD_HIS 를 생성
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOCreateDocProcSkdCACSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOCreateDocProcSkdCACSQL").append("\n"); 
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
		query.append("#if (${copy_type_cd} == 'BKG')" ).append("\n"); 
		query.append("INSERT INTO BKG_DOC_PROC_SKD (" ).append("\n"); 
		query.append("    BKG_NO " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_DOC_PROC_SKD_HIS (" ).append("\n"); 
		query.append("    BKG_NO " ).append("\n"); 
		query.append("    , CORR_NO " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    , BKG_DOC_PROC_TP_CD " ).append("\n"); 
		query.append("    , DOC_PROC_SEQ " ).append("\n"); 
		query.append("    , EVNT_DT " ).append("\n"); 
		query.append("    , EVNT_GDT " ).append("\n"); 
		query.append("    , EVNT_USR_ID " ).append("\n"); 
		query.append("    , DIFF_RMK " ).append("\n"); 
		query.append("    , BKG_EVNT_CD1 " ).append("\n"); 
		query.append("    , BKG_EVNT_CD2 " ).append("\n"); 
		query.append("    , DOC_PERF_DELT_FLG " ).append("\n"); 
		query.append("    , CRE_USR_ID " ).append("\n"); 
		query.append("    , CRE_DT " ).append("\n"); 
		query.append("    , UPD_USR_ID " ).append("\n"); 
		query.append("    , UPD_DT " ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("#if (${copy_type_cd} == 'BKG')" ).append("\n"); 
		query.append("SELECT BKG_NO " ).append("\n"); 
		query.append("#elseif (${copy_type_cd} == 'TEMP')" ).append("\n"); 
		query.append("SELECT BKG_NO " ).append("\n"); 
		query.append("        , 'TMP0000001' CORR_NO " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT BKG_NO " ).append("\n"); 
		query.append("        , @[ca_no] CORR_NO " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    , BKG_DOC_PROC_TP_CD " ).append("\n"); 
		query.append("    , DOC_PROC_SEQ " ).append("\n"); 
		query.append("    , EVNT_DT " ).append("\n"); 
		query.append("    , EVNT_GDT " ).append("\n"); 
		query.append("    , EVNT_USR_ID " ).append("\n"); 
		query.append("    , DIFF_RMK " ).append("\n"); 
		query.append("    , BKG_EVNT_CD1 " ).append("\n"); 
		query.append("    , BKG_EVNT_CD2 " ).append("\n"); 
		query.append("    , DOC_PERF_DELT_FLG " ).append("\n"); 
		query.append("    , CRE_USR_ID " ).append("\n"); 
		query.append("    , CRE_DT " ).append("\n"); 
		query.append("    , UPD_USR_ID " ).append("\n"); 
		query.append("    , sysdate" ).append("\n"); 
		query.append("#if (${copy_type_cd} == 'BKG')" ).append("\n"); 
		query.append("  FROM BKG_DOC_PROC_SKD_HIS" ).append("\n"); 
		query.append(" WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("   AND BKG_DOC_PROC_TP_CD = 'CNTATC'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  FROM BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG_DOC_PROC_TP_CD = 'CNTATC'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}