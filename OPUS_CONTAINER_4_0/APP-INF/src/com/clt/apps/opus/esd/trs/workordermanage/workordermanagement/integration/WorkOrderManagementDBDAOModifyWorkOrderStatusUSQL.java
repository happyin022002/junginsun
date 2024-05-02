/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderManagementDBDAOModifyWorkOrderStatusUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderManagementDBDAOModifyWorkOrderStatusUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyWorkOrderStatus
	  * </pre>
	  */
	public WorkOrderManagementDBDAOModifyWorkOrderStatusUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("node_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_cre_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.integration").append("\n"); 
		query.append("FileName : WorkOrderManagementDBDAOModifyWorkOrderStatusUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_WRK_ORD WO " ).append("\n"); 
		query.append("   SET WO.WO_TRSP_STS_CD  = " ).append("\n"); 
		query.append("                ( SELECT (CASE WHEN COUNT(*) = SUM(DECODE(SO.DEST_GATE_IN_DT,NULL,0,1)) THEN 'C'" ).append("\n"); 
		query.append("                               WHEN SUM(DECODE(SO.DEST_GATE_IN_DT,NULL,0,1)) > 0 THEN 'P'" ).append("\n"); 
		query.append("                               WHEN SUM(DECODE(SO.ORG_GATE_OUT_DT,NULL,0,1)) > 0 THEN 'S'" ).append("\n"); 
		query.append("                               ELSE WO.WO_TRSP_STS_CD" ).append("\n"); 
		query.append("                          END ) " ).append("\n"); 
		query.append("                    FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("                   WHERE SO.TRSP_WO_OFC_CTY_CD = WO.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("                     AND SO.TRSP_WO_SEQ        = WO.TRSP_WO_SEQ" ).append("\n"); 
		query.append("                     )," ).append("\n"); 
		query.append("       WO.WO_ISS_STS_CD = DECODE(WO.WO_ISS_STS_CD, 'X', 'I', WO.WO_ISS_STS_CD)" ).append("\n"); 
		query.append("WHERE (TRSP_WO_OFC_CTY_CD,TRSP_WO_SEQ) IN" ).append("\n"); 
		query.append("        (SELECT SO.TRSP_WO_OFC_CTY_CD,SO.TRSP_WO_SEQ" ).append("\n"); 
		query.append("           FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("          WHERE ( SO.EQ_NO = @[cntr_no] OR SO.COP_NO = (SELECT COP_NO FROM SCE_COP_HDR WHERE BKG_NO=@[bkg_no] AND CNTR_NO =@[cntr_no] ) )" ).append("\n"); 
		query.append("            AND SO.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND NVL2(@[wo_no], SO.TRSP_WO_OFC_CTY_CD || SO.TRSP_WO_SEQ, 'XXX') = NVL(@[wo_no], 'XXX')" ).append("\n"); 
		query.append("            AND INSTR(SO.FM_NOD_CD||SO.TO_NOD_CD||SO.VIA_NOD_CD, @[node_cd] ) > 0" ).append("\n"); 
		query.append("            AND SO.DELT_FLG = 'N' )" ).append("\n"); 
		query.append("	 AND NVL(@[mvmt_cre_tp_cd], 'X') <> 'A'  " ).append("\n"); 

	}
}