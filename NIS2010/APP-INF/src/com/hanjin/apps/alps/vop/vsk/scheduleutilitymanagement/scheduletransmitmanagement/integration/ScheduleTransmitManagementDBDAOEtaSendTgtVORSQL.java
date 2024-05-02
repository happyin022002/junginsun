/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ScheduleTransmitManagementDBDAOEtaSendTgtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.24
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.12.24 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScheduleTransmitManagementDBDAOEtaSendTgtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public ScheduleTransmitManagementDBDAOEtaSendTgtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.integration").append("\n"); 
		query.append("FileName : ScheduleTransmitManagementDBDAOEtaSendTgtVORSQL").append("\n"); 
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
		query.append("  '' VSL_CD" ).append("\n"); 
		query.append(", '' SKD_VOY_NO" ).append("\n"); 
		query.append(", '' SKD_DIR_CD" ).append("\n"); 
		query.append(", '' VPS_PORT_CD" ).append("\n"); 
		query.append(", '' CLPT_IND_SEQ" ).append("\n"); 
		query.append(", '' TRSM_HIS_SEQ" ).append("\n"); 
		query.append(", '' YD_CD" ).append("\n"); 
		query.append(", '' TRSM_MZD_CD" ).append("\n"); 
		query.append(", '' TRSM_OWNR_CD" ).append("\n"); 
		query.append(", '' SLAN_CD" ).append("\n"); 
		query.append(", '' ACT_CRR_CD" ).append("\n"); 
		query.append(", '' VPS_ETA_DT" ).append("\n"); 
		query.append(", '' VPS_ETB_DT" ).append("\n"); 
		query.append(", '' VPS_ETD_DT" ).append("\n"); 
		query.append(", '' NTC_ETA_DT" ).append("\n"); 
		query.append(", '' NTC_ETB_DT" ).append("\n"); 
		query.append(", '' NTC_ETD_DT" ).append("\n"); 
		query.append(", '' TRSM_RSN" ).append("\n"); 
		query.append(", '' VSL_FAX_NO" ).append("\n"); 
		query.append(", '' VSL_TLX_NO" ).append("\n"); 
		query.append(", '' VSL_EML" ).append("\n"); 
		query.append(", '' IMST_CD" ).append("\n"); 
		query.append(", '' VSL_FAX_TRSM_EML" ).append("\n"); 
		query.append(", '' VSL_TLX_TRSM_EML" ).append("\n"); 
		query.append(", '' TRSM_LOCL_DT" ).append("\n"); 
		query.append(", '' TRSM_DT" ).append("\n"); 
		query.append(", '' SKD_TRSM_STS_CD" ).append("\n"); 
		query.append(", '' RPM_ADJ_DT" ).append("\n"); 
		query.append(", '' ORG_RPM_PWR" ).append("\n"); 
		query.append(", '' CRNT_RPM_PWR" ).append("\n"); 
		query.append(", '' ESVC_VNDR_SEQ" ).append("\n"); 
		query.append(", '' CRE_USR_ID" ).append("\n"); 
		query.append(", '' LOCL_CRE_DT" ).append("\n"); 
		query.append(", '' CRE_DT" ).append("\n"); 
		query.append(", '' UPD_USR_ID" ).append("\n"); 
		query.append(", '' LOCL_UPD_DT" ).append("\n"); 
		query.append(", '' UPD_DT" ).append("\n"); 
		query.append(", '' EML_SEQ" ).append("\n"); 
		query.append(", '' USR_EML" ).append("\n"); 
		query.append(", '' FM_ETA_DT" ).append("\n"); 
		query.append(", '' TO_ETA_DT" ).append("\n"); 
		query.append(", '' VVD" ).append("\n"); 
		query.append(", '' YD_NM" ).append("\n"); 
		query.append(", '' VSL_ENG_NM" ).append("\n"); 
		query.append(", '' PORT_NM" ).append("\n"); 
		query.append(", '' auto_fax_pop" ).append("\n"); 
		query.append(", '' DFLT_IMST_CD" ).append("\n"); 
		query.append(", '' OFC_CD" ).append("\n"); 
		query.append(", '' SKD_TRSM_STS_NM" ).append("\n"); 
		query.append(", '' FAX_IMST_CD" ).append("\n"); 
		query.append(", '' TLX_IMST_CD" ).append("\n"); 
		query.append(", '' DFLT_FAX_IMST_CD" ).append("\n"); 
		query.append(", '' DFLT_TLX_IMST_CD" ).append("\n"); 
		query.append(", '' SNDR_EML" ).append("\n"); 
		query.append(", '' EML_SND_NO" ).append("\n"); 
		query.append(", '' FB_EML" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}