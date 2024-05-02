/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOScgRequestListOptionVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOScgRequestListOptionVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ScgRequestListOptionVO 생성을 위한 Dummy 쿼리
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOScgRequestListOptionVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOScgRequestListOptionVORSQL").append("\n"); 
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
		query.append("'' BOOKING_NO" ).append("\n"); 
		query.append(", '' SLAN_CD3" ).append("\n"); 
		query.append(", '' AUTH_FLG" ).append("\n"); 
		query.append(", '' SLAN_CD4" ).append("\n"); 
		query.append(", '' RGN_SHP_OPR_CD" ).append("\n"); 
		query.append(", '' SLAN_CD5" ).append("\n"); 
		query.append(", '' VAL_OPR_TP_CD" ).append("\n"); 
		query.append(", '' SLAN_CD6" ).append("\n"); 
		query.append(", '' SLAN_CD1" ).append("\n"); 
		query.append(", '' SLAN_CD2" ).append("\n"); 
		query.append(", '' SLAN_CD11" ).append("\n"); 
		query.append(", '' SLAN_CD10" ).append("\n"); 
		query.append(", '' SLAN_CD8" ).append("\n"); 
		query.append(", '' SLAN_CD7" ).append("\n"); 
		query.append(", '' SLAN_CD9" ).append("\n"); 
		query.append(", '' SCG_FLG" ).append("\n"); 
		query.append(", '' VSL_CD" ).append("\n"); 
		query.append(", '' SKD_VOY_NO" ).append("\n"); 
		query.append(", '' SKD_DIR_CD" ).append("\n"); 
		query.append(", '' POL_CD" ).append("\n"); 
		query.append(", '' POD_CD" ).append("\n"); 
		query.append(", '' CGO_OPR_CD" ).append("\n"); 
		query.append(", '' APRO_REF_NO" ).append("\n"); 
		query.append(", '' IMDG_UN_NO" ).append("\n"); 
		query.append(", '' IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append(", '' IMDG_CLSS_CD" ).append("\n"); 
		query.append(", '' FROM_ETA_DT" ).append("\n"); 
		query.append(", '' TO_ETA_DT" ).append("\n"); 
		query.append(", '' SHPR_NM" ).append("\n"); 
		query.append(", '' CGO_OPR_CD" ).append("\n"); 
		query.append(", '' PRP_SHP_NM" ).append("\n"); 
		query.append(", '' EML_SND_NO" ).append("\n"); 
		query.append(", '' UPD_USR_ID" ).append("\n"); 
		query.append(", '' SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append(", '' BKG_NO" ).append("\n"); 
		query.append(", '' SLAN_CD12" ).append("\n"); 
		query.append(", '' SLAN_CD13" ).append("\n"); 
		query.append(", '' SLAN_CD14" ).append("\n"); 
		query.append(", '' SLAN_CD15" ).append("\n"); 
		query.append(", '' SLAN_CD16" ).append("\n"); 
		query.append(", '' SLAN_CD17" ).append("\n"); 
		query.append(", '' SLAN_CD18" ).append("\n"); 
		query.append(", '' SLAN_CD19" ).append("\n"); 
		query.append(", '' SLAN_CD20" ).append("\n"); 
		query.append(", '' SLAN_CD21" ).append("\n"); 
		query.append(", '' SLAN_CD22" ).append("\n"); 
		query.append(", '' SLAN_CD23" ).append("\n"); 
		query.append(", '' SLAN_CD24" ).append("\n"); 
		query.append(", '' SLAN_CD25" ).append("\n"); 
		query.append(", '' SLAN_CD26" ).append("\n"); 
		query.append(", '' SLAN_CD27" ).append("\n"); 
		query.append(", '' SLAN_CD28" ).append("\n"); 
		query.append(", '' SLAN_CD29" ).append("\n"); 
		query.append(", '' SLAN_CD30" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}