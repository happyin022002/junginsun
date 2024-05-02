/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchTrs3PtyIFCxlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchTrs3PtyIFCxlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTrs3PtyIFCxl
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchTrs3PtyIFCxlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_prv_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_iss_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration ").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchTrs3PtyIFCxlUSQL").append("\n"); 
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
		query.append("UPDATE TRS_N3RD_PTY_IF" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("CXL_FLG = 'Y' ," ).append("\n"); 
		query.append("TRSP_N3PTY_IF_STS_CD = 'N'" ).append("\n"); 
		query.append("WHERE (TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ) IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("TRSP_SO_SEQ" ).append("\n"); 
		query.append("FROM TRS_TRSP_WRK_ORD_PRV_TMP" ).append("\n"); 
		query.append("WHERE WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("AND WO_ISS_NO = @[wo_iss_no] )" ).append("\n"); 
		query.append("AND TRSP_N3PTY_IF_STS_CD = 'P'" ).append("\n"); 
		query.append("AND IF_FLG = 'Y'" ).append("\n"); 
		query.append("AND NVL(CXL_FLG, 'N') = 'N'" ).append("\n"); 

	}
}