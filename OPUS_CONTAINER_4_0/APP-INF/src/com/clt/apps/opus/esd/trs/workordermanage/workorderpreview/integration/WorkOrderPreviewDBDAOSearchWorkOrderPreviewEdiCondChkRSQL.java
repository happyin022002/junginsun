/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchWorkOrderPreviewEdiCondChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.03 
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

public class WorkOrderPreviewDBDAOSearchWorkOrderPreviewEdiCondChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Work Order Preview EDI 가능 조건 체크
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchWorkOrderPreviewEdiCondChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_cost_dtl_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchWorkOrderPreviewEdiCondChkRSQL").append("\n"); 
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
		query.append("SELECT EDI_CHK_SEQ AS WO_EDI_FLG" ).append("\n"); 
		query.append("FROM TRS_TRSP_WRK_ORD_EDI" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND TRSP_COST_DTL_MOD_CD IS NULL" ).append("\n"); 
		query.append("AND FM_NOD_CD IS NULL" ).append("\n"); 
		query.append("AND TO_NOD_CD IS NULL" ).append("\n"); 
		query.append("AND CONTI_CD IN ('A','E')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT EDI_CHK_SEQ AS WO_EDI_FLG" ).append("\n"); 
		query.append("FROM TRS_TRSP_WRK_ORD_EDI" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND TRSP_COST_DTL_MOD_CD = @[trsp_cost_dtl_mod_cd]" ).append("\n"); 
		query.append("AND FM_NOD_CD IS NULL" ).append("\n"); 
		query.append("AND TO_NOD_CD IS NULL" ).append("\n"); 
		query.append("AND CONTI_CD IN ('A','E')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT EDI_CHK_SEQ AS WO_EDI_FLG" ).append("\n"); 
		query.append("FROM TRS_TRSP_WRK_ORD_EDI" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND TRSP_COST_DTL_MOD_CD = @[trsp_cost_dtl_mod_cd]" ).append("\n"); 
		query.append("AND FM_NOD_CD = @[fm_nod_cd]" ).append("\n"); 
		query.append("AND TO_NOD_CD = @[to_nod_cd]" ).append("\n"); 
		query.append("AND CONTI_CD IN ('A','E')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT EDI_CHK_SEQ AS WO_EDI_FLG" ).append("\n"); 
		query.append("FROM TRS_TRSP_WRK_ORD_EDI" ).append("\n"); 
		query.append("WHERE VNDR_SEQ IS NULL " ).append("\n"); 
		query.append("AND TRSP_COST_DTL_MOD_CD = @[trsp_cost_dtl_mod_cd]" ).append("\n"); 
		query.append("AND FM_NOD_CD IS NULL" ).append("\n"); 
		query.append("AND TO_NOD_CD IS NULL" ).append("\n"); 
		query.append("AND CONTI_CD = @[conti_cd]" ).append("\n"); 

	}
}