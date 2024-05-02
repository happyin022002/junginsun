/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOCancelBkgDocProcSkdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.16
*@LastModifier : 전성진
*@LastVersion : 1.0
* 2009.12.16 전성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung Jin Jeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOCancelBkgDocProcSkdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOCancelBkgDocProcSkdCSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOCancelBkgDocProcSkdCSQL(){
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
		params.put("bkg_doc_proc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOCancelBkgDocProcSkdCSQL").append("\n"); 
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
		query.append("UPDATE BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("SET DOC_PERF_DELT_FLG = 'Y'" ).append("\n"); 
		query.append("WHERE BKG_NO             = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG_DOC_PROC_TP_CD IN (SELECT ATTR_CTNT2" ).append("\n"); 
		query.append("FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("WHERE HRD_CDG_ID = 'DOC_PROC_SKD_PAIR'" ).append("\n"); 
		query.append("AND ATTR_CTNT1 = @[bkg_doc_proc_tp_cd]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT @[bkg_doc_proc_tp_cd] FROM DUAL)" ).append("\n"); 
		query.append("AND DOC_PERF_DELT_FLG = 'N'" ).append("\n"); 

	}
}