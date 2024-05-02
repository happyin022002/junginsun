/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OpfUtilDBDAOMdmCntrTpSzVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.opfcommon.opfutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OpfUtilDBDAOMdmCntrTpSzVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public OpfUtilDBDAOMdmCntrTpSzVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.opfcommon.opfutil.integration").append("\n"); 
		query.append("FileName : OpfUtilDBDAOMdmCntrTpSzVORSQL").append("\n"); 
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
		query.append("SELECT 	CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		,CNTR_SZ_CD" ).append("\n"); 
		query.append("		,CNTR_TP_CD" ).append("\n"); 
		query.append("		,CNTR_TPSZ_LODG_WGT" ).append("\n"); 
		query.append("		,CNTR_TPSZ_LODG_CAPA" ).append("\n"); 
		query.append("		,CNTR_TPSZ_TARE_WGT" ).append("\n"); 
		query.append("		,CNTR_TPSZ_DESC" ).append("\n"); 
		query.append("		,CNTR_TPSZ_RMK" ).append("\n"); 
		query.append("		,CNTR_TPSZ_PSA_CD" ).append("\n"); 
		query.append("		,CNTR_TPSZ_ISO_CD" ).append("\n"); 
		query.append("		,MODI_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		,CRE_USR_ID" ).append("\n"); 
		query.append("		,CRE_DT" ).append("\n"); 
		query.append("		,UPD_USR_ID" ).append("\n"); 
		query.append("		,UPD_DT" ).append("\n"); 
		query.append("		,DELT_FLG" ).append("\n"); 
		query.append("		,EAI_EVNT_DT" ).append("\n"); 
		query.append("		,CNTR_TPSZ_GRP_CD" ).append("\n"); 
		query.append("		,RPT_DP_SEQ" ).append("\n"); 
		query.append("		,ACIAC_DIV_CD" ).append("\n"); 
		query.append("FROM	MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("----AND		DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER	BY	RPT_DP_SEQ" ).append("\n"); 

	}
}