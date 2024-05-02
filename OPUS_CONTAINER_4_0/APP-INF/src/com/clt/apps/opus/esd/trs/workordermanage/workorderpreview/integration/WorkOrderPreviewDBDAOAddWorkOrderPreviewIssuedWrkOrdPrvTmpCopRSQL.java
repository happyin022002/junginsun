/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedWrkOrdPrvTmpCopRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.11 
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

public class WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedWrkOrdPrvTmpCopRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddWorkOrderPreviewIssuedWrkOrdPrvTmpCop
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedWrkOrdPrvTmpCopRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedWrkOrdPrvTmpCopRSQL").append("\n"); 
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
		query.append("A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(", A.TRSP_SO_SEQ" ).append("\n"); 
		query.append(", A.WO_CXL_FLG" ).append("\n"); 
		query.append(", A.WO_PRV_GRP_SEQ" ).append("\n"); 
		query.append(", A.WO_BL_NO_ISS_FLG" ).append("\n"); 
		query.append(", A.DTN_USE_FLG" ).append("\n"); 
		query.append(", A.N3PTY_BIL_FLG" ).append("\n"); 
		query.append(", A.TRSP_RJCT_RSN_CD" ).append("\n"); 
		query.append(", A.TRSP_FRST_FLG" ).append("\n"); 
		query.append(", A.TRSP_DFLT_VNDR_FLG" ).append("\n"); 
		query.append("FROM TRS_TRSP_WRK_ORD_PRV_TMP A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("AND A.WO_ISS_NO = @[wo_iss_no]" ).append("\n"); 

	}
}