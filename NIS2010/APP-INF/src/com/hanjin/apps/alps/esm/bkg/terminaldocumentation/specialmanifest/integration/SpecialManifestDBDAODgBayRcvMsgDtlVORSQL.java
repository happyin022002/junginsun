/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialManifestDBDAODgBayRcvMsgDtlVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAODgBayRcvMsgDtlVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DgBayRcvMsgDtlVO 생성을 위해 사용
	  * </pre>
	  */
	public SpecialManifestDBDAODgBayRcvMsgDtlVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration ").append("\n"); 
		query.append("FileName : SpecialManifestDBDAODgBayRcvMsgDtlVORSQL").append("\n"); 
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
		query.append("''BAY_PLN_ID" ).append("\n"); 
		query.append(",''EUR_DG_CNTR_ID" ).append("\n"); 
		query.append(",''CELL_PSN_NO" ).append("\n"); 
		query.append(",''GRS_WGT" ).append("\n"); 
		query.append(",''CNTR_WGT_UT_CD" ).append("\n"); 
		query.append(",''ISO_CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",''POL_CD" ).append("\n"); 
		query.append(",''POD_CD" ).append("\n"); 
		query.append(",''DEL_CD" ).append("\n"); 
		query.append(",''EUR_DG_FULL_MTY_CD" ).append("\n"); 
		query.append(",''CNTR_OPR_ID" ).append("\n"); 
		query.append(",''IMDG_CLSS_CD" ).append("\n"); 
		query.append(",''IMDG_UN_NO" ).append("\n"); 
		query.append(",''CRE_USR_ID" ).append("\n"); 
		query.append(",''CRE_DT" ).append("\n"); 
		query.append(",''UPD_USR_ID" ).append("\n"); 
		query.append(",''UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}