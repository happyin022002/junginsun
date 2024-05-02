/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLDocumentationCMDBDAOBkgCustShpRqstVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.18
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2011.10.18 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOBkgCustShpRqstVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgCustShpRqstVO 생성 쿼리
	  * </pre>
	  */
	public BLDocumentationCMDBDAOBkgCustShpRqstVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOBkgCustShpRqstVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("		' ' vvd_cd," ).append("\n"); 
		query.append("	    ' ' pol_cd," ).append("\n"); 
		query.append("	    ' ' slan_cd," ).append("\n"); 
		query.append("	    ' ' pol_cd," ).append("\n"); 
		query.append("	    ' ' cre_dt," ).append("\n"); 
		query.append("		' ' cre_usr_id," ).append("\n"); 
		query.append("    	' ' bkg_no,           " ).append("\n"); 
		query.append("		' ' cntr_no,          " ).append("\n"); 
		query.append("		' ' cntr_seq,         " ).append("\n"); 
		query.append("		' ' cntr_tpsz_cd,     " ).append("\n"); 
		query.append("		' ' cntr_seal_no,    " ).append("\n"); 
		query.append("		' ' pck_qty,     " ).append("\n"); 
		query.append("		' ' pck_tp_cd,        " ).append("\n"); 
		query.append("		' ' cntr_wgt,         " ).append("\n"); 
		query.append("		' ' wgt_ut_cd,        " ).append("\n"); 
		query.append("		' ' meas_qty,         " ).append("\n"); 
		query.append("		' ' meas_ut_cd,       " ).append("\n"); 
		query.append("		' ' cre_usr_id,       " ).append("\n"); 
		query.append("		' ' cre_dt,           " ).append("\n"); 
		query.append("		' ' upd_usr_id,       " ).append("\n"); 
		query.append("		' ' upd_dt  ," ).append("\n"); 
		query.append("		' ' ofc_cd , " ).append("\n"); 
		query.append("        ' ' cntr_vol_qty" ).append("\n"); 
		query.append("	FROM DUAL" ).append("\n"); 

	}
}