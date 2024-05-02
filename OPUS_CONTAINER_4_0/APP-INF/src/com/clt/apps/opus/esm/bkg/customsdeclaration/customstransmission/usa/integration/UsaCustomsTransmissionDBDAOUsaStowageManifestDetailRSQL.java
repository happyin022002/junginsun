/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOUsaStowageManifestDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.08.12 김도완
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOUsaStowageManifestDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, UsaStowageManifestDetailVO 생성용.
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOUsaStowageManifestDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo ").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOUsaStowageManifestDetailRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' cntr_no," ).append("\n"); 
		query.append("'' opr_cd," ).append("\n"); 
		query.append("'' l_pol," ).append("\n"); 
		query.append("'' pol," ).append("\n"); 
		query.append("'' pod," ).append("\n"); 
		query.append("'' sztp," ).append("\n"); 
		query.append("'' fe," ).append("\n"); 
		query.append("'' sti_pos," ).append("\n"); 
		query.append("'' imdg," ).append("\n"); 
		query.append("'' unno," ).append("\n"); 
		query.append("'' sent_time," ).append("\n"); 
		query.append("'' o_pod," ).append("\n"); 
		query.append("'' vvd," ).append("\n"); 
		query.append("'' vsl_eng_nm," ).append("\n"); 
		query.append("'' vsl_voy," ).append("\n"); 
		query.append("'' crr_cd," ).append("\n"); 
		query.append("'' tmp1," ).append("\n"); 
		query.append("'' tmp2," ).append("\n"); 
		query.append("'' tmp3," ).append("\n"); 
		query.append("'' tmp4," ).append("\n"); 
		query.append("'' tmp5" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}