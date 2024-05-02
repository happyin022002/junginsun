/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaInbondTransmissionDBDAOUsaInbondManifestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.12.30 경종윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyoung Jong Yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaInbondTransmissionDBDAOUsaInbondManifestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim UsaInbondManifestListVO 생성용
	  * </pre>
	  */
	public UsaInbondTransmissionDBDAOUsaInbondManifestListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaInbondTransmissionDBDAOUsaInbondManifestListRSQL").append("\n"); 
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
		query.append("SELECT '' CNTR_NO, '' BL_NO, '' VVD, '' DEL_CD, '' IBD_TRSP_NO," ).append("\n"); 
		query.append("'' IBD_TP_CD, '' ARR_DT, '' TRSP_ISS_DT, '' ARR_TIME, '' TRSP_ISS_TIME," ).append("\n"); 
		query.append("'' USA_LST_LOC_CD, '' MJR_IBD_AUTH_DT, '' MJR_IBD_AUTH_TIME, '' XPT_DT, '' XPT_TIME," ).append("\n"); 
		query.append("'' XPT_ACPT_DT, '' XPT_ACPT_TIME, '' CNMV_STS_CD, '' POD_CD, '' HUB_LOC_CD," ).append("\n"); 
		query.append("'' FRT_CLT_FLG, '' OBL_RDEM_FLG, '' CSTMS_CLR_CD, '' ARR_FLG, '' XPT_FLG," ).append("\n"); 
		query.append("'' TRSP_AUTH_DT, '' TRSP_AUTH_TIME," ).append("\n"); 
		query.append("'' PKUP_NO, '' YD_CD, '' AVAL_DT, '' BL_CNTR_FLAG, '' USDATE," ).append("\n"); 
		query.append("'' ARR_DT_BEFORE,	'' XPT_DT_BEFORE," ).append("\n"); 
		query.append("'' TOTAL_BL_CNT, '' INBOND_BL_CNT, '' LOCAL_BL_CNT, '' LCL_FLG, '' INBOND_LOCAL" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}