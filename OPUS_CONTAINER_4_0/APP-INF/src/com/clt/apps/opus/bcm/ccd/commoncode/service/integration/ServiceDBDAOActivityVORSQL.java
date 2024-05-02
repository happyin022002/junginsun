/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ServiceDBDAOActivityVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.service.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceDBDAOActivityVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ss
	  * </pre>
	  */
	public ServiceDBDAOActivityVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.service.integration").append("\n"); 
		query.append("FileName : ServiceDBDAOActivityVORSQL").append("\n"); 
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
		query.append("SELECT '' AS ACT_CD" ).append("\n"); 
		query.append(",'' AS ACT_NM" ).append("\n"); 
		query.append(",'' AS ACT_DESC" ).append("\n"); 
		query.append(",'' AS ACT_TP_CD" ).append("\n"); 
		query.append(",'' AS FULL_MTY_CD" ).append("\n"); 
		query.append(",'' AS BND_VSKD_SEQ_CD" ).append("\n"); 
		query.append(",'' AS NOD_TP_CD" ).append("\n"); 
		query.append(",'' AS ACT_OP_TP_CD" ).append("\n"); 
		query.append(",'' AS TRSP_MOD_CD" ).append("\n"); 
		query.append(",'' AS ORG_DEST_CD" ).append("\n"); 
		query.append(",'' AS ACT_FLG" ).append("\n"); 
		query.append(",'' AS ACT_STS_MAPG_CD" ).append("\n"); 
		query.append(",'' AS ACT_STND_EDI_STS_CD" ).append("\n"); 
		query.append(",'' AS ESTM_STND_EDI_STS_CD" ).append("\n"); 
		query.append(",'' AS BZC_VIS_FLG" ).append("\n"); 
		query.append(",'' AS CUST_VIS_FLG" ).append("\n"); 
		query.append(",'' AS ACT_RCV_TP_CD" ).append("\n"); 
		query.append(",'' AS COP_SKD_LGC_NO" ).append("\n"); 
		query.append(",'' AS COP_SKD_LGC_TP_CD" ).append("\n"); 
		query.append(",'' AS UPD_AVAL_FLG" ).append("\n"); 
		query.append(",'' AS DELT_FLG" ).append("\n"); 
		query.append(",'' AS CRE_USR_ID" ).append("\n"); 
		query.append(",'' AS CRE_DT" ).append("\n"); 
		query.append(",'' AS UPD_USR_ID" ).append("\n"); 
		query.append(",'' AS UPD_DT" ).append("\n"); 
		query.append(",'' AS EAI_EVNT_DT" ).append("\n"); 
		query.append(",'' AS VNDR_EV_TOL_HRS" ).append("\n"); 
		query.append(",'' AS VNDR_EV_SVC_CATE_CD" ).append("\n"); 
		query.append(",'' AS EAI_IF_ID" ).append("\n"); 
		query.append("	  ,'' AS USER_ID" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}