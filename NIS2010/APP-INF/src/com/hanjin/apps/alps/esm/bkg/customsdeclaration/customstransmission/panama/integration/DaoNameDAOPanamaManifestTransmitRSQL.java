/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOPanamaManifestTransmitRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.07
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.12.07 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.panama.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 * 
 * @author SEUN GMIN KIM    
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOPanamaManifestTransmitRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PanamaManifestTransmit
	  * </pre>
	  */
	public DaoNameDAOPanamaManifestTransmitRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.panama.integration").append("\n"); 
		query.append("FileName : DaoNameDAOPanamaManifestTransmitRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' pnm_Vsl_Opr_Cd," ).append("\n"); 
		query.append("'' clpt_Seq," ).append("\n"); 
		query.append("'' skd_Dir_Cd," ).append("\n"); 
		query.append("'' dgpackage," ).append("\n"); 
		query.append("'' error_Type," ).append("\n"); 
		query.append("'' pnm_Org_Cd," ).append("\n"); 
		query.append("'' pnm_Dest_Cd," ).append("\n"); 
		query.append("'' vst_No," ).append("\n"); 
		query.append("'' mvmt_Seq," ).append("\n"); 
		query.append("'' vvd_Cd," ).append("\n"); 
		query.append("'' vsl_Cd," ).append("\n"); 
		query.append("'' skd_Voy_No," ).append("\n"); 
		query.append("'' upd_usr_id," ).append("\n"); 
		query.append("'' edi_snd_dt" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}