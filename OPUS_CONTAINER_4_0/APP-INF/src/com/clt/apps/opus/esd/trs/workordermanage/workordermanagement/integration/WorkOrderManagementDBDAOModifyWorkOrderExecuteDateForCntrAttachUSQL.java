/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderManagementDBDAOModifyWorkOrderExecuteDateForCntrAttachUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.08
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.06.08 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderManagementDBDAOModifyWorkOrderExecuteDateForCntrAttachUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderManagementDBDAOModifyWorkOrderExecuteDateForCntrAttach
	  * </pre>
	  */
	public WorkOrderManagementDBDAOModifyWorkOrderExecuteDateForCntrAttachUSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.integration").append("\n"); 
		query.append("FileName : WorkOrderManagementDBDAOModifyWorkOrderExecuteDateForCntrAttachUSQL").append("\n"); 
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
		query.append("MERGE INTO TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("  USING (SELECT /*+ INDEX_DESC(S XPKCTM_MOVEMENT) */" ).append("\n"); 
		query.append("          S.MVMT_STS_CD, S.ORG_YD_CD, S.BKG_NO, TO_CHAR(S.CNMV_EVNT_DT, 'YYYYMMDDHH24MI') CNMV_EVNT_DT, S.WO_NO, S.CNTR_NO" ).append("\n"); 
		query.append("           FROM CTM_MOVEMENT S" ).append("\n"); 
		query.append("          WHERE CNTR_NO = NVL(@[cntr_no], (select eq_no from trs_trsp_svc_ord where trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd] and trsp_so_seq = @[trsp_so_seq]))" ).append("\n"); 
		query.append("            AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND NVL(S.MVMT_CRE_TP_CD, 'X') NOT IN ('C', 'A')" ).append("\n"); 
		query.append("            AND ROWNUM = 1) MV" ).append("\n"); 
		query.append("  ON (		SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd] " ).append("\n"); 
		query.append("		AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("		AND SO.BKG_NO = MV.BKG_NO " ).append("\n"); 
		query.append("		AND SO.EQ_NO = MV.CNTR_NO " ).append("\n"); 
		query.append("		AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("	 )" ).append("\n"); 
		query.append("  WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE" ).append("\n"); 
		query.append("       SET SO.WO_EXE_DT      = " ).append("\n"); 
		query.append("           (CASE 	WHEN NVL(SO.TRS_SUB_STS_CD, 'XX') = 'CM' THEN SO.WO_EXE_DT" ).append("\n"); 
		query.append("					WHEN SO.TRSP_SO_TP_CD = 'Y' AND SO.TRSP_COST_DTL_MOD_CD <> 'DR' AND MV.ORG_YD_CD = SO.FM_NOD_CD AND MV.MVMT_STS_CD IN ('EN', 'TN', 'OP', 'ID') THEN TO_DATE(MV.CNMV_EVNT_DT, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("             		ELSE SO.WO_EXE_DT" ).append("\n"); 
		query.append("           END)" ).append("\n"); 
		query.append("          ,SO.ORG_GATE_OUT_DT =" ).append("\n"); 
		query.append("           (CASE    WHEN NVL(SO.TRS_SUB_STS_CD, 'XX') = 'CM' THEN SO.ORG_GATE_OUT_DT" ).append("\n"); 
		query.append("					WHEN MV.MVMT_STS_CD IN ('EN', 'TN', 'OP', 'ID') AND MV.ORG_YD_CD = SO.FM_NOD_CD THEN TO_DATE(MV.CNMV_EVNT_DT, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("             		ELSE SO.ORG_GATE_OUT_DT" ).append("\n"); 
		query.append("           END)" ).append("\n"); 
		query.append("          ,SO.DEST_GATE_IN_DT =" ).append("\n"); 
		query.append("           (CASE    WHEN NVL(SO.TRS_SUB_STS_CD, 'XX') = 'CM' THEN SO.DEST_GATE_IN_DT" ).append("\n"); 
		query.append("					WHEN MV.MVMT_STS_CD IN ('OC', 'IC', 'MT') AND MV.ORG_YD_CD = SO.TO_NOD_CD THEN	TO_DATE(MV.CNMV_EVNT_DT, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("             		ELSE SO.DEST_GATE_IN_DT" ).append("\n"); 
		query.append("           END)" ).append("\n"); 
		query.append("          ,SO.TRS_SUB_STS_CD =" ).append("\n"); 
		query.append("           (CASE	WHEN NVL(SO.TRS_SUB_STS_CD, 'XX') = 'CM' THEN SO.TRS_SUB_STS_CD" ).append("\n"); 
		query.append("					WHEN MV.MVMT_STS_CD IN ('EN', 'TN', 'OP', 'ID') AND MV.ORG_YD_CD = SO.FM_NOD_CD THEN	'ST'" ).append("\n"); 
		query.append("             		WHEN MV.MVMT_STS_CD IN ('OC', 'IC', 'MT') AND MV.ORG_YD_CD = SO.TO_NOD_CD THEN	'CM'" ).append("\n"); 
		query.append("             		ELSE SO.TRS_SUB_STS_CD" ).append("\n"); 
		query.append("           END)" ).append("\n"); 
		query.append("           ,SO.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("		   ,SO.LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(SO.CRE_OFC_CD)	" ).append("\n"); 
		query.append("		   ,SO.UPD_DT = SYSDATE" ).append("\n"); 

	}
}