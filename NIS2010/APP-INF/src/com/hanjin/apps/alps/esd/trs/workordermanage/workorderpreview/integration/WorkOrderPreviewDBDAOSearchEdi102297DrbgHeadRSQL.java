/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdi102297DrbgHeadRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchEdi102297DrbgHeadRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdi102297DrbgHead
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdi102297DrbgHeadRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdi102297DrbgHeadRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	NVL(WO.TRSP_WO_OFC_CTY_CD||LPAD(WO.TRSP_WO_SEQ, 17, '0'),@[trsp_wo_ofc_cty_cd]||LPAD(@[trsp_wo_seq], 17, '0')) AS WO_NO," ).append("\n"); 
		query.append("    DECODE (WO.WO_ISS_STS_CD, 'I', 'C', 'R', 'U', 'C', 'U', 'N', 'X') PURPOSE," ).append("\n"); 
		query.append("    TO_CHAR(WO.LOCL_UPD_DT, 'YYYYMMDDHH24MI') SND_DT," ).append("\n"); 
		query.append("    'Hanjin Transportation (PUS Brandch)' RECEIVER," ).append("\n"); 
		query.append("    USR.USR_NM SENDER," ).append("\n"); 
		query.append("    USR.XTN_PHN_NO TEL_NO," ).append("\n"); 
		query.append("    DECODE( SO.TRSP_CRR_MOD_CD, 'TD', 'TR', 'WD', 'BR') TRT_MODE," ).append("\n"); 
		query.append("    SUM(DECODE(SUBSTR(SO.EQ_TPSZ_CD, 2, 1), '2', 1, 0)) QTY_TEU_T," ).append("\n"); 
		query.append("    SUM(DECODE(SUBSTR(SO.EQ_TPSZ_CD, 2, 1), '2', 0, 1)) QTY_FEU_T," ).append("\n"); 
		query.append("    SO.CURR_CD AMT_CUR," ).append("\n"); 
		query.append("    SUM(NVL(SO.BZC_AMT,0)+NVL(SO.NEGO_AMT,0)+NVL(SO.ETC_ADD_AMT,0)+ NVL(SO.TOLL_FEE_AMT,0)) AMT_T," ).append("\n"); 
		query.append("    SO.FM_NOD_CD ORG_YD," ).append("\n"); 
		query.append("    SO.TO_NOD_CD DEST_YD," ).append("\n"); 
		query.append("    '' INS," ).append("\n"); 
		query.append("    WO.WO_RMK RMK" ).append("\n"); 
		query.append("FROM BKG_VVD VVD," ).append("\n"); 
		query.append("    COM_USER USR," ).append("\n"); 
		query.append("    MDM_YARD YD," ).append("\n"); 
		query.append("    TRS_TRSP_WRK_ORD WO," ).append("\n"); 
		query.append("    TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("WHERE SO.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("    AND WO.TRSP_WO_OFC_CTY_CD = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("    AND WO.TRSP_WO_SEQ = @[trsp_wo_seq]" ).append("\n"); 
		query.append("    AND WO.TRSP_WO_OFC_CTY_CD = SO.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("    AND WO.TRSP_WO_SEQ = SO.TRSP_WO_SEQ" ).append("\n"); 
		query.append("    AND WO.CRE_USR_ID = USR.USR_ID" ).append("\n"); 
		query.append("    AND SO.FM_NOD_CD = YD.YD_CD" ).append("\n"); 
		query.append("    AND SO.BKG_NO = VVD.BKG_NO(+)" ).append("\n"); 
		query.append("    AND SUBSTR(SO.FM_NOD_CD, 1, 5) = SUBSTR(VVD.POD_CD(+) , 1, 5)" ).append("\n"); 
		query.append("    -- /* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append("    AND SO.HJL_NO IS NULL" ).append("\n"); 
		query.append("    AND WO.HJL_NO IS NULL" ).append("\n"); 
		query.append("GROUP BY WO.TRSP_WO_OFC_CTY_CD||LPAD( WO.TRSP_WO_SEQ, 17, '0'), " ).append("\n"); 
		query.append("        WO.WO_ISS_STS_CD, " ).append("\n"); 
		query.append("		WO.LOCL_UPD_DT, " ).append("\n"); 
		query.append("        USR.USR_NM, " ).append("\n"); 
		query.append("        USR.XTN_PHN_NO, " ).append("\n"); 
		query.append("        SO.TRSP_CRR_MOD_CD, " ).append("\n"); 
		query.append("        SO.CURR_CD, " ).append("\n"); 
		query.append("        SO.FM_NOD_CD , " ).append("\n"); 
		query.append("        SO.TO_NOD_CD , " ).append("\n"); 
		query.append("        WO.WO_RMK" ).append("\n"); 

	}
}