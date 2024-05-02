/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VietnamCustomsTransmissionDBDAOBkgCstmsVnSndLogVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.28
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.08.28 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VietnamCustomsTransmissionDBDAOBkgCstmsVnSndLogVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgCstmsVnSndLogVO
	  * </pre>
	  */
	public VietnamCustomsTransmissionDBDAOBkgCstmsVnSndLogVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.integration ").append("\n"); 
		query.append("FileName : VietnamCustomsTransmissionDBDAOBkgCstmsVnSndLogVORSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("'' vn_mf_snd_ind_cd," ).append("\n"); 
		query.append("'' flt_file_ref_no," ).append("\n"); 
		query.append("'' vvd," ).append("\n"); 
		query.append("'' pol_cd," ).append("\n"); 
		query.append("'' pod_cd," ).append("\n"); 
		query.append("'' vn_cstms_bnd_cd," ).append("\n"); 
		query.append("'' ofc_cd," ).append("\n"); 
		query.append("'' bkg_no," ).append("\n"); 
		query.append("'' cntr_no," ).append("\n"); 
		query.append("'' usr_id	" ).append("\n"); 
		query.append("from dual	" ).append("\n"); 

	}
}