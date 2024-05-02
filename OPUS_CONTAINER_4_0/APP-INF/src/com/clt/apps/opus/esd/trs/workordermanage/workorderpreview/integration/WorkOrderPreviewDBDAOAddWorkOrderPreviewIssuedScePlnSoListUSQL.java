/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedScePlnSoListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.30
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.09.30 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedScePlnSoListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddWorkOrderPreviewIssuedScePlnSoList
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedScePlnSoListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wo_cxl_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewIssuedScePlnSoListUSQL").append("\n"); 
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
		query.append("UPDATE SCE_PLN_SO_LIST" ).append("\n"); 
		query.append("SET TRSP_SO_STS_CD = @[trsp_so_sts_cd]" ).append("\n"); 
		query.append("   ,UPD_USR_ID = 'TRSPRV' " ).append("\n"); 
		query.append("   ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("   ,DELT_USR_ID = DECODE(@[trsp_so_sts_cd], 'D', 'TRSPRV', '')" ).append("\n"); 
		query.append("   ,DELT_DT = DECODE(@[trsp_so_sts_cd], 'D', SYSDATE, '')" ).append("\n"); 
		query.append("WHERE (COP_NO, COST_ACT_GRP_SEQ) in ( " ).append("\n"); 
		query.append("		SELECT COP_NO, COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("		FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("		WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("			AND TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("			AND TRSP_SO_TP_CD = DECODE(@[wo_cxl_flg], 'Y', TRSP_SO_TP_CD, 'Y')" ).append("\n"); 
		query.append("			AND NVL(RPLN_UMCH_FLG,'N') = DECODE(@[wo_cxl_flg], 'Y', NVL(RPLN_UMCH_FLG,'N') , 'N' )" ).append("\n"); 
		query.append("	  )" ).append("\n"); 

	}
}