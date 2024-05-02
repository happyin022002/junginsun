/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderManagementDBDAOModifyWorkOrderStatusForCntrAttachUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderManagementDBDAOModifyWorkOrderStatusForCntrAttachUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderManagementDBDAOModifyWorkOrderStatusForCntrAttach
	  * </pre>
	  */
	public WorkOrderManagementDBDAOModifyWorkOrderStatusForCntrAttachUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.integration ").append("\n"); 
		query.append("FileName : WorkOrderManagementDBDAOModifyWorkOrderStatusForCntrAttachUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_WRK_ORD WO" ).append("\n"); 
		query.append("   SET WO.WO_TRSP_STS_CD =" ).append("\n"); 
		query.append("       (SELECT (CASE WHEN COUNT(*) = SUM(DECODE(SO.DEST_GATE_IN_DT, NULL, 0, 1)) THEN 'C'" ).append("\n"); 
		query.append("                     WHEN SUM(DECODE(SO.DEST_GATE_IN_DT, NULL, 0, 1)) > 0 THEN 'P'" ).append("\n"); 
		query.append("                     WHEN SUM(DECODE(SO.ORG_GATE_OUT_DT, NULL, 0, 1)) > 0 THEN 'S'" ).append("\n"); 
		query.append("                     ELSE WO.WO_TRSP_STS_CD" ).append("\n"); 
		query.append("               END)" ).append("\n"); 
		query.append("          FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("         WHERE SO.TRSP_WO_OFC_CTY_CD = WO.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND SO.TRSP_WO_SEQ = WO.TRSP_WO_SEQ)" ).append("\n"); 
		query.append("      ,WO.WO_ISS_STS_CD  = DECODE(WO.WO_ISS_STS_CD, 'X', 'I', WO.WO_ISS_STS_CD)" ).append("\n"); 
		query.append("      ,WO.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,WO.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("      ,WO.LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(WO.CRE_OFC_CD)" ).append("\n"); 
		query.append(" WHERE TRSP_WO_OFC_CTY_CD = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND TRSP_WO_SEQ = @[trsp_wo_seq]" ).append("\n"); 

	}
}