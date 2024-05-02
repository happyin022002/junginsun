/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewSceSoIfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOAddWorkOrderPreviewSceSoIfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sce_so_if insert
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOAddWorkOrderPreviewSceSoIfCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewSceSoIfCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO SCE_SO_IF " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("    SO_RCV_DT " ).append("\n"); 
		query.append("    , SO_RCV_NO " ).append("\n"); 
		query.append("    , TRSP_SO_OFC_CTY_CD " ).append("\n"); 
		query.append("    , TRSP_SO_SEQ " ).append("\n"); 
		query.append("    , SO_IF_STS_CD " ).append("\n"); 
		query.append("    , CRE_USR_ID " ).append("\n"); 
		query.append("    , CRE_DT " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append("  	, SCE_SO_IF_SEQ1.NEXTVAL " ).append("\n"); 
		query.append("  	, TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("  	, TRSP_SO_SEQ" ).append("\n"); 
		query.append("  	, '77'" ).append("\n"); 
		query.append("  	, 'TRS'" ).append("\n"); 
		query.append("  	, SYSDATE" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("    AND TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("    AND TRSP_SO_TP_CD = 'Y'" ).append("\n"); 

	}
}